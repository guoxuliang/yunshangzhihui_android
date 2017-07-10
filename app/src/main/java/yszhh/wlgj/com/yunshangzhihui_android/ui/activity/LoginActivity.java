package yszhh.wlgj.com.yunshangzhihui_android.ui.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import okhttp3.Call;
import okhttp3.Response;
import yszhh.wlgj.com.yunshangzhihui_android.R;
import yszhh.wlgj.com.yunshangzhihui_android.bases.BaseActivity;
import yszhh.wlgj.com.yunshangzhihui_android.bean.BeanCallback;
import yszhh.wlgj.com.yunshangzhihui_android.https.OkHttpUtils;
import yszhh.wlgj.com.yunshangzhihui_android.https.callback.StringCallback;
import yszhh.wlgj.com.yunshangzhihui_android.ui.entity.LoginBbean;
import yszhh.wlgj.com.yunshangzhihui_android.utils.Constants;

/**
 * @author 登陆界面 作者：guoxuliang
 */
public class LoginActivity extends BaseActivity {
    private EditText etusername;// 用户名
    private EditText etpwd;// 密码
    private Button btlogin;// 登录
    private String username;
    private String password;
    private TextView textview;
    String TAG = LoginActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();

    }

    private void initViews() {
        etusername = (EditText) findViewById(R.id.etusername);
        etpwd = (EditText) findViewById(R.id.etpwd);
        btlogin = (Button) findViewById(R.id.btlogin);
        btlogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                posts();
            }
        });
        textview = (TextView) findViewById(R.id.textview);
    }


    /**
     * 处理登录事件
     */

    private void  posts(){
//        OkHttpUtils.post()
//                .url(Constants.SERVER_BASE_URL)
//                .addParams("name","name")
//                .addParams("pwd","pwd")
//                .build().execute(new BeanCallback<LoginBbean>() {
//            @Override
//            public LoginBbean parseNetworkResponse(Response response, int id) throws Exception {
//                return null;
//            }
//
//            @Override
//            public void onError(Call call, Exception e, int id) {
//
//            }
//
//            @Override
//            public void onResponse(LoginBbean response, int id) {
//
//            }
//
//        });

        OkHttpUtils.post().url(Constants.SERVER_BASE_URL)
                .addParams("strLoginName", "白航")
                .addParams("strPassWord", "860513")
                .addParams("appType", "0")
                .build()
                .execute(new BeanCallback<LoginBbean>() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        showToast("失败");
                    }

                    @Override
                    public void onResponse(LoginBbean response, int id) {
//                        LogLess.$json(response);
                        showToast("成功");
                        Log.i("","response"+response+"");
                    }
                });

    }

}
