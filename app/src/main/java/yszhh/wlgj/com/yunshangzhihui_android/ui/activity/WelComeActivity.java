package yszhh.wlgj.com.yunshangzhihui_android.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;

import yszhh.wlgj.com.yunshangzhihui_android.R;
import yszhh.wlgj.com.yunshangzhihui_android.bases.BaseActivity;


public class WelComeActivity extends BaseActivity implements OnClickListener {
    private final int SPLASH_DISPLAY_LENGHT = 5000;  //延迟5秒

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_wel_come);
//		initView();
        initTimer();
    }

    private void initTimer() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(WelComeActivity.this, LoginActivity.class);
                WelComeActivity.this.startActivity(intent);
                WelComeActivity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGHT);
    }

    private void initView() {
    }

    @Override
    public void onClick(View arg0) {
    }

}
