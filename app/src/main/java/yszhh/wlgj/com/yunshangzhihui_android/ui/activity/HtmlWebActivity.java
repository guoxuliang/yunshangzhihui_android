package yszhh.wlgj.com.yunshangzhihui_android.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import yszhh.wlgj.com.yunshangzhihui_android.R;
import yszhh.wlgj.com.yunshangzhihui_android.bases.BaseActivity;
import yszhh.wlgj.com.yunshangzhihui_android.utils.UserDataConstants;

/**
 * Created by Administrator on 2017/7/11 0011.
 * 经济建设
 */

public class HtmlWebActivity extends BaseActivity implements View.OnClickListener {
    private static java.lang.String cookies;
    private ImageView shop_all_btn;
    private WebView webview_web;
    private Handler handler = null;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        initViews();
    }

    private void initViews() {
        cookies = getStringSharePreferences(UserDataConstants.SETTINGS, UserDataConstants.COOKIES);
        webview_web = (WebView) findViewById(R.id.webview_web);
        webview_web.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    if (keyCode == KeyEvent.KEYCODE_BACK && webview_web.canGoBack()) {  //表示按返回键
                        webview_web.goBack();   //后退
                        //webview.goForward();//前进
                        return true;    //已处理
                    }
                }
                return false;
            }
        });
        String url = "http://192.168.3.199:8181/zgcy/a/shouye?flag=1";
        synCookies(this, url, cookies);
        webview_web.loadUrl(url);
    }

    /**
     * 设置Cookie
     *
     * @param context
     * @param url
     * @param cookie  格式：uid=21233 如需设置多个，需要多次调用
     */
    public void synCookies(Context context, String url, String cookie) {
        CookieSyncManager.createInstance(context);
        CookieManager cookieManager = CookieManager.getInstance();
        //得到向URL中添加的Cookie的值
        cookieManager.setAcceptCookie(true);
        cookieManager.setCookie(url, cookie);//cookies是在HttpClient中获得的cookie
        CookieSyncManager.getInstance().sync();
    }

    /**
     * 清除Cookie
     *
     * @param context
     */
    public static void removeCookie(Context context) {
        CookieSyncManager.createInstance(context);
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.removeAllCookie();
        CookieSyncManager.getInstance().sync();
    }


    protected void configWebView(final WebView webView, boolean needCache) {

        if (!needCache) {
            webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        }

        webView.getSettings().setJavaScriptEnabled(true);
        //启用数据库
        webView.getSettings().setDatabaseEnabled(true);
        //设置定位的数据库路径
        String dir = this.getApplicationContext().getDir("database", Context.MODE_PRIVATE).getPath();
        webView.getSettings().setGeolocationDatabasePath(dir);
        //启用地理定位
        webView.getSettings().setGeolocationEnabled(true);
        //开启DomStorage缓存
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setLoadsImagesAutomatically(true);
        //设置webview属性可以对js进行操作
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                webview_web.loadUrl("javascript:yincang()");
            }
        });
        webView.setWebChromeClient(new WebChromeClient());
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    protected void onResume() {
        configWebView(webview_web, false);
        super.onResume();
    }
}
