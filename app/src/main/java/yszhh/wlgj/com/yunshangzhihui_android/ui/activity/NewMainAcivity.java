package yszhh.wlgj.com.yunshangzhihui_android.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import yszhh.wlgj.com.yunshangzhihui_android.R;
import yszhh.wlgj.com.yunshangzhihui_android.bases.BaseActivity;

/**
 * Created by Administrator on 2017/7/10 0010.
 */

public class NewMainAcivity extends BaseActivity implements View.OnClickListener {
    private LinearLayout out_zgmb,out_jjjs,out_hmgc;
    private ImageView shop_all_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newmain);
        initViews();
    }

    private void initViews() {
        out_zgmb=(LinearLayout) findViewById(R.id.out_zgmb);
        out_jjjs=(LinearLayout) findViewById(R.id.out_jjjs);
        out_hmgc=(LinearLayout) findViewById(R.id.out_hmgc);
        shop_all_btn=(ImageView) findViewById(R.id.shop_all_btn);
        out_zgmb.setOnClickListener(this);
        out_jjjs.setOnClickListener(this);
        out_hmgc.setOnClickListener(this);
        shop_all_btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.out_zgmb:
                //追赶目标
                openActivity(WebActivity.class);
                break;
            case R.id.out_jjjs:
                //经济建设
                openActivity(WebActivity.class);
                break;
            case R.id.out_hmgc:
                //惠民工程
                openActivity(WebActivity.class);
                break;
            case R.id.shop_all_btn:
                //个人中心
                openActivity(PersonalCenterActivity.class);
                break;
        }
    }



}
