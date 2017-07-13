package yszhh.wlgj.com.yunshangzhihui_android.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import okhttp3.Call;
import okhttp3.Response;
import yszhh.wlgj.com.yunshangzhihui_android.R;
import yszhh.wlgj.com.yunshangzhihui_android.bases.BaseActivity;
import yszhh.wlgj.com.yunshangzhihui_android.bean.BeanCallback;
import yszhh.wlgj.com.yunshangzhihui_android.https.OkHttpUtils;
import yszhh.wlgj.com.yunshangzhihui_android.https.callback.Callback;
import yszhh.wlgj.com.yunshangzhihui_android.ui.entity.LoginBbean;
import yszhh.wlgj.com.yunshangzhihui_android.ui.tools.StringHelper;
import yszhh.wlgj.com.yunshangzhihui_android.utils.Constants;
import yszhh.wlgj.com.yunshangzhihui_android.utils.CryptTool;
import yszhh.wlgj.com.yunshangzhihui_android.utils.UserDataConstants;

/**
 * @author 登陆界面 作者：guoxuliang
 */
public class LoginActivity extends BaseActivity {
    private EditText etusername;// 用户名
    private EditText etpwd;// 密码框
    private Button btlogin;// 登录框

    private String username;// 用户名
    private String password;// 密码
    private String text = "text";

    private LoginBbean loginbean;

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
                login();//调用登陆接口
//                openActivity(WebActivity.class);
//                LoginActivity.this.finish();
            }
        });
    }

    private void login() {
        username = etusername.getText().toString().trim();
        password = etpwd.getText().toString().trim();
        if (username == null && username.equals("")) {
            showToast("用户名不能为空");
            return;
        }
        if (username.length() > 11) {
            showToast("用户名位数不对");
            return;
        }
        if (password == null && password.equals("")) {
            showToast("密码不能为空");
            return;
        }
        try {
            posts();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 处理登录事件
     */

    private void posts() throws Exception {
        if (isConnNet(this)) {
            showToast("请检查网络");
            return;
        }
        String url="http://10.48.40.67:8181/zgcy/a/loginMobile?username=thinkgem&password=admin";
        OkHttpUtils.get().
                url(url)
                .addParams("userName", username)
                .addParams("password", CryptTool.md5Digest(password))
                .build().execute(new BeanCallback<LoginBbean>() {
            @Override
            public void onError(Call call, Exception e, int id) {
                showToast("失败"+e);
                Log.i("==","==e"+e);
            }
            @Override
            public void onResponse(LoginBbean response, int id) {
                showToast("成功");
                String flag=loginbean.getLoginFlag();
                String name=loginbean.getRoleNames();
                boolean admin=loginbean.isAdmin();
                boolean record=loginbean.isNewRecord();
                openActivity(NewMainAcivity.class);
                Log.i("==response","flag"+flag+"=="+"name"+name+"=="+"admin"+admin+"=="+"record"+record);
            }
        });

//        OkHttpUtils.post()
//                .url(url)
//                .addParams("userName", username)
//                .addParams("password", CryptTool.md5Digest(password))
//                .build().execute(new BeanCallback<LoginBbean>() {
//            @Override
//            public void onError(Call call, Exception e, int id) {
//                showToast("失败"+e);
//                Log.i("==","==e"+e);
//            }
//            @Override
//            public void onResponse(LoginBbean response, int id) {
//                showToast("成功");
//                openActivity(NewMainAcivity.class);
//                Log.i("==response","==response"+response);
//            }
//        });

//        OkHttpUtils.post().url(Constants.SERVER_BASE_URL)
//        OkHttpUtils.post().url(url)
//                .addParams("userName", username)
//                .addParams("password", password)
////                .addParams("appType", "0")
//                .build()
//                .execute(new BeanCallback<LoginBbean>() {
//                    @Override
//                    public void onError(Call call, Exception e, int id) {
//                        showToast("失败");
//                    }
//
//                    @Override
//                    public void onResponse(LoginBbean response, int id) {
//                        showToast("成功");
//                        Log.i("", "response" + response + "");
//                        openActivity(NewMainAcivity.class);
//                        LoginActivity.this.finish();
////                        setStringSharedPreferences(UserDataConstants.SETTINGS, UserDataConstants.LOGINNAME, "");
////                        setStringSharedPreferences(UserDataConstants.SETTINGS, UserDataConstants.LOGINPWD, "");
////                        setStringSharedPreferences(UserDataConstants.SETTINGS, UserDataConstants.WEBUSERID, "");
////                        setStringSharedPreferences(UserDataConstants.SETTINGS, UserDataConstants.NICKNAME, "");
////                        setStringSharedPreferences(UserDataConstants.SETTINGS, UserDataConstants.REGISTERTIME, "");
////                        setStringSharedPreferences(UserDataConstants.SETTINGS, UserDataConstants.PAYPWDSTATUS, "");
////                        setStringSharedPreferences(UserDataConstants.SETTINGS, UserDataConstants.GESTUREPWDSTATUS, "");
////                        setStringSharedPreferences(UserDataConstants.SETTINGS, UserDataConstants.RESTRICTIONSPAYSTATUS, "");
////                        setStringSharedPreferences(UserDataConstants.SETTINGS, UserDataConstants.SMALLNOPAYSTATUS, "");
////                        setStringSharedPreferences(UserDataConstants.SETTINGS, UserDataConstants.USEABLEPOINTS, "");
////                        setStringSharedPreferences(UserDataConstants.SETTINGS, UserDataConstants.ALREADYPOINTSOFMONTH, "");
//////                        setStringSharedPreferences(UserDataConstants.SETTINGS, UserDataConstants.HEADPHOTO, headPhoto);
////                        dismissLoadingDialog();
//                        // 通知登陆成功。
//
//                        openActivity(MainActivity.class);
//                        finish();
//
//
//                    }
//                });

    }
    private String getAppDeviceId() {
        TelephonyManager mTelephonyMgr = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        String imei = mTelephonyMgr.getDeviceId();
        showToast(imei);
        if (StringHelper.isNullOrEmpty(imei)) {
            imei = "";
        }
        return imei;
    }
}
