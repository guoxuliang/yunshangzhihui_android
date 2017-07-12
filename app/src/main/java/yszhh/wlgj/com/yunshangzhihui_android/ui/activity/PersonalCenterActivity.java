package yszhh.wlgj.com.yunshangzhihui_android.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import yszhh.wlgj.com.yunshangzhihui_android.R;
import yszhh.wlgj.com.yunshangzhihui_android.bases.BaseActivity;

/**
 * Created by Administrator on 2017/7/11 0011.
 */

public class PersonalCenterActivity extends BaseActivity implements View.OnClickListener {
    private ImageView shop_all_btn;
    private LinearLayout version_updata;
    private LinearLayout exit_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_center);
        initView();
    }

    private void initView() {
        shop_all_btn = (ImageView) findViewById(R.id.shop_all_btn);
        shop_all_btn.setVisibility(View.GONE);
        version_updata= (LinearLayout) findViewById(R.id.version_updata);
        exit_login= (LinearLayout) findViewById(R.id.exit_login);
        version_updata.setOnClickListener(this);
        exit_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.version_updata:

                break;
        }
    }
}
