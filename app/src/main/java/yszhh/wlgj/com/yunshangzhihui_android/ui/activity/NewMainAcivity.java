package yszhh.wlgj.com.yunshangzhihui_android.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import okhttp3.Call;
import yszhh.wlgj.com.yunshangzhihui_android.R;
import yszhh.wlgj.com.yunshangzhihui_android.bases.BaseActivity;
import yszhh.wlgj.com.yunshangzhihui_android.bean.BeanCallback;
import yszhh.wlgj.com.yunshangzhihui_android.https.OkHttpUtils;
import yszhh.wlgj.com.yunshangzhihui_android.ui.entity.GoalBean;
import yszhh.wlgj.com.yunshangzhihui_android.ui.entity.LoginBbean;
import yszhh.wlgj.com.yunshangzhihui_android.utils.Constants;
import yszhh.wlgj.com.yunshangzhihui_android.utils.UserDataConstants;

/**
 * Created by Administrator on 2017/7/10 0010.
 */

public class NewMainAcivity extends BaseActivity implements View.OnClickListener {
    private LinearLayout out_zgmb, out_jjjs, out_hmgc;
    private ImageView shop_all_btn;
    private String cookies;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newmain);
        cookies = getStringSharePreferences(UserDataConstants.SETTINGS, UserDataConstants.COOKIES);

        initViews();
    }

    private void initViews() {
        out_zgmb = (LinearLayout) findViewById(R.id.out_zgmb);
        out_jjjs = (LinearLayout) findViewById(R.id.out_jjjs);
        out_hmgc = (LinearLayout) findViewById(R.id.out_hmgc);
        shop_all_btn = (ImageView) findViewById(R.id.shop_all_btn);
        out_zgmb.setOnClickListener(this);
        out_jjjs.setOnClickListener(this);
        out_hmgc.setOnClickListener(this);
        shop_all_btn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.out_zgmb:
                //追赶目标
                 url = "http://192.168.3.199:8181/zgcy/a/tjj/catchGdpAreaDetails/AreaGdpList";
                cookies=getStringSharePreferences(UserDataConstants.SETTINGS, UserDataConstants.COOKIES);
                try {
                    posts();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.out_jjjs:
                //经济建设
                break;
            case R.id.out_hmgc:
                break;
            case R.id.shop_all_btn:
                //个人中心
                break;
        }
    }


    /**
     * 处理请求事件
     */

    private void posts() throws Exception {
        if (isConnNet(this)) {
            showToast("请检查网络");
            return;
        }
        OkHttpUtils.post()
                .url(url)
                .addHeader("Cookie", cookies)//添加要传入的请求头参数cookies,cookies
                .build().execute(new BeanCallback<String>() {
            @Override
            public void onError(Call call, Exception e, int id) {
                showToast("失败" + e);
                Log.i("==", "==e" + e);
            }

            @Override
            public void onResponse(String response, int id) {
                showToast("成功"+response.toString());
                String htmldata=response.toString();
//                Log.i("==", "==e" + response.getUrl());
//                String url2=response.getUrl();
                Intent intent = new Intent(NewMainAcivity.this, HtmlWebActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("cookies", cookies);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });
    }

}
