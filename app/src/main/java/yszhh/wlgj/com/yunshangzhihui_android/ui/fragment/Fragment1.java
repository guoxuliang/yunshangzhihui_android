package yszhh.wlgj.com.yunshangzhihui_android.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import yszhh.wlgj.com.yunshangzhihui_android.R;
import yszhh.wlgj.com.yunshangzhihui_android.bases.BaseFragment;
import yszhh.wlgj.com.yunshangzhihui_android.ui.tools.BackHandledInterface;
import yszhh.wlgj.com.yunshangzhihui_android.ui.tools.StringHelper;


public class Fragment1 extends BaseFragment {
    protected BackHandledInterface mBackHandledInterface;
    private WebView webview_web;
    private ImageView back_title_id;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        initViews(view);
        back_title_id = (ImageView) view.findViewById(R.id.back_title_id);
        return view;
    }

    private void initViews(View view) {
        webview_web = (WebView) view.findViewById(R.id.webview_web);
        back_title_id = (ImageView) view.findViewById(R.id.back_title_id);
        back_title_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                finish();
            }
        });
        WebSettings webSettings = webview_web.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
//        if (isConnNet(getContext())) {
            webview_web.loadUrl("http://jct.xys.gov.cn");
//        } else {
//            showToast("请检查网络");
//        }


        webview_web.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);


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
//=============
        if (!(getActivity() instanceof BackHandledInterface)) {
            throw new ClassCastException(
                    "Hosting Activity must implement BackHandledInterface");
        } else {
            this.mBackHandledInterface = (BackHandledInterface) getActivity();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        // 告诉FragmentActivity，当前Fragment在栈顶
        mBackHandledInterface.setSelectedFragment(this);

    }

    private Handler handler = new Handler() {
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

    private void webViewGoBack() {
        webview_web.goBack();
    }
}
