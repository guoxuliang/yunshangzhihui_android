package yszhh.wlgj.com.yunshangzhihui_android.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import yszhh.wlgj.com.yunshangzhihui_android.R;
import yszhh.wlgj.com.yunshangzhihui_android.bases.BaseFragment;


public class Fragment1 extends BaseFragment {
    private static final String INJECTION_TOKEN = "**injection**";
    private WebView mWebView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        initViews(view);
        return view;
    }

    private void initViews(View view) {

    }
}
