package yszhh.wlgj.com.yunshangzhihui_android.ui.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import yszhh.wlgj.com.yunshangzhihui_android.R;
import yszhh.wlgj.com.yunshangzhihui_android.bases.BaseActivity;

/**
 * Created by Administrator on 2017/7/11 0011.
 * 经济建设
 */

public class WebActivity extends BaseActivity implements View.OnClickListener {
    private ImageView shop_all_btn;
    private WebView webview_web;
    private Handler handler = null;
    String url;
    String cookies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        initViews();
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            url = bundle.getString("url");
            cookies=bundle.getString("cookies");
            initWeb();
        }


    }

    private void initViews() {
        shop_all_btn = (ImageView) findViewById(R.id.shop_all_btn);
        shop_all_btn.setVisibility(View.GONE);
        webview_web = (WebView) findViewById(R.id.webview_web);
        shop_all_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.shop_all_btn:
                //跳转个人中心
                openActivity(PersonalCenterActivity.class);
                break;
        }
    }

    private void initWeb() {
        WebSettings webSettings = webview_web.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        if (isConnNet(this)) {
            showToast("请检查网络");
            return;
        }
        webview_web.loadUrl("http://192.168.3.199:8181/zgcy/a/tjj/catchGdpAreaDetails/AreaGdpList");

        webview_web.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view,
                                                    String url) {
                return super.shouldOverrideUrlLoading(view, url);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                CookieManager cookieManager = CookieManager.getInstance();
                String CookieStr = cookieManager.getCookie(url);
                Log.i("##CookieStr",CookieStr);
                super.onPageFinished(view, url);
//                webview_web.setInitialScale(200);
//                webview_web.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);


                //编写 javaScript方法
                String javascript = "javascript:function hideOther() {" +
                        "document.getElementsByTagName('body')[0].innerHTML;" +
                        "document.getElementsByTagName('div')[0].style.display='none';" +
                        "document.getElementsByTagName('div')[3].style.display='none';" +
                        "document.getElementsByClassName('dropdown')[0].style.display='none';" +
                        "document.getElementsByClassName('min')[0].remove();" +
                        "var divs = document.getElementsByTagName('div');" +
                        "var lastDiv = divs[divs.length-1];" +
                        "lastDiv.remove();" +
                        "document.getElementsByClassName('showme')[0].remove();" +
                        "document.getElementsByClassName('nei-t3')[1].remove();}";

                //创建方法
                view.loadUrl(javascript);

                //加载方法
                view.loadUrl("javascript:hideOther();");
            }
        });
        webview_web.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((keyCode == KeyEvent.KEYCODE_BACK) && webview_web.canGoBack()) {
                    handler.sendEmptyMessage(1);
                    return true;
                }
                return false;
            }
        });

        handler = new Handler() {
            @Override
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1: {
                        webViewGoBack();
                    }
                    break;
                }
            }
        };
    }

    private void webViewGoBack() {
        webview_web.goBack();
    }
}
