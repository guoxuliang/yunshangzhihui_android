package yszhh.wlgj.com.yunshangzhihui_android.ui.activity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.LogRecord;

import okhttp3.Call;
import okhttp3.Cookie;
import yszhh.wlgj.com.yunshangzhihui_android.R;
import yszhh.wlgj.com.yunshangzhihui_android.bases.BaseActivity;
import yszhh.wlgj.com.yunshangzhihui_android.bean.BeanCallback;
import yszhh.wlgj.com.yunshangzhihui_android.https.OkHttpUtils;
import yszhh.wlgj.com.yunshangzhihui_android.https.cookie.CookieJarImpl;
import yszhh.wlgj.com.yunshangzhihui_android.ui.entity.LoginBbean;
import yszhh.wlgj.com.yunshangzhihui_android.utils.Constants;
import yszhh.wlgj.com.yunshangzhihui_android.utils.Gradient;
import yszhh.wlgj.com.yunshangzhihui_android.utils.UserDataConstants;

/**
 * @author 登陆界面 作者：guoxuliang
 */
public class LoginActivity extends BaseActivity {
    private EditText etusername;// 用户名
    private EditText etpwd;// 密码框
    private Button btlogin, mButton;// 登录框
    private String username;// 用户名
    private String password;// 密码
    private String text = "text";
    private LoginBbean loginbean;
    String TAG = LoginActivity.class.getSimpleName();
    int flag = 1;

    private boolean islogin;
    private String message;
    private String cookies2;
    private String cookies;
    private String cookies1;
    private String id;
    private boolean isNewRecord;
    private String remarks;
    private String createDate;
    private String updateDate;
    private String area;
    private String loginName;
    private String no;
    private String name;
    private String email;
    private String phone;
    private String mobile;
    private String userType;
    private String loginIp;
    private String loginDate;
    private String loginFlag;
    private String photo;
    private String oldLoginIp;
    private String oldLoginDate;
    private String management;
    private String roleNames;
    private boolean admin;

    private String enname;
    private String roleType;
    private String dataScope;
    private String sysData;
    private String useable;
    private String menuIds;
    private String officeIds;

    private ImageView animationIV;
    private AnimationDrawable animationDrawable;



    Gradient mGradient;

    private Drawable oldBackground = null;
    private Drawable bg_a;
    private Drawable bg_b;
    LinearLayout up;
    int isWhat = 1;

//    private Handler handler = new Handler() {
//
//        // 该方法运行在主线程中
//        // 接收到handler发送的消息，对UI进行操作
//        @Override
//        public void handleMessage(Message msg) {
//            // TODO Auto-generated method stub
//            if (msg.what == 0x123) {
//                animationIV.setImageResource(R.drawable.animation);
//                animationDrawable = (AnimationDrawable) animationIV.getDrawable();
//                startAlphaAnimation();
//                animationDrawable.start();
////                AlphaAnimation alphaAnimation = (AlphaAnimation) AnimationUtils.loadAnimation(LoginActivity.this, R.anim.alpha);
////                animationIV.startAnimation(alphaAnimation);
//
//            }
//        }
//    };
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
//        animationIV = (ImageView) findViewById(R.id.animationIV);
        btlogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                login();//调用登陆接口
            }
        });
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                handler.sendEmptyMessage(0x123);//发送消息
//            }
//        }).start();

        mGradient = (Gradient) findViewById(R.id.gradient);
        //创建imageview
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.mipmap.icon_1);
        ImageView imageView2 = new ImageView(this);
        imageView2.setImageResource(R.mipmap.icon_2);
        ImageView imageView3 = new ImageView(this);
        imageView3.setImageResource(R.mipmap.icon_3);
        ImageView imageView4 = new ImageView(this);
        imageView4.setImageResource(R.mipmap.icon_4);
        List<ImageView> list = new ArrayList<>();
        list.add(imageView);
        list.add(imageView2);
        list.add(imageView3);
        list.add(imageView4);
        //设置图片即可
        mGradient.setImageViews(list);
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
//        showLoadingDialog("登录中...");
        String url = Constants.SERVER_BASE_URL + "a/loginMobile";
        OkHttpUtils.post()
                .url(url)
//                .addParams("username", username)
//                .addParams("password", password)
                .addParams("username", username)
                .addParams("password", password)
                .build().execute(new BeanCallback<LoginBbean>() {
            @Override
            public void onError(Call call, Exception e, int id) {
                showToast("失败==" + e);
                Log.i("==", "==e==" + e);
            }

            @Override
            public void onResponse(LoginBbean response, int id) {
                if (response != null) {
                    islogin = response.getIsLogin();
                    message = response.getMessage();
//                    List<Cookie> cookies = httpclient.getCookieStore().getCookies();
                    cookies1 = response.getCookies();
                    setStringSharedPreferences(UserDataConstants.SETTINGS, UserDataConstants.COOKIES, "jeesite.session.id=" + cookies1);
                    if (islogin) {
                        String ids = response.getUser().getId();
                        isNewRecord = response.getUser().getIsNewRecord();
                        remarks = response.getUser().getRemarks();
                        createDate = response.getUser().getCreateDate();
                        updateDate = response.getUser().getUpdateDate();
                        area = response.getUser().getArea();
                        loginName = response.getUser().getLoginName();
                        no = response.getUser().getNo();
                        name = response.getUser().getName();
                        email = response.getUser().getEmail();
                        phone = response.getUser().getPhone();
                        mobile = response.getUser().getMobile();
                        userType = response.getUser().getUserType();
                        loginIp = response.getUser().getLoginIp();
                        loginDate = response.getUser().getLoginDate();
                        loginFlag = response.getUser().getLoginFlag();
                        photo = response.getUser().getPhoto();
                        oldLoginIp = response.getUser().getOldLoginIp();
                        oldLoginDate = response.getUser().getOldLoginDate();
                        management = response.getUser().getManagement();
                        roleNames = response.getUser().getRoleNames();
                        admin = response.getUser().getAdmin();


                        setStringSharedPreferences(UserDataConstants.SETTINGS, UserDataConstants.ID, ids);
                        setStringSharedPreferences(UserDataConstants.SETTINGS, UserDataConstants.NO, no);
                        setStringSharedPreferences(UserDataConstants.SETTINGS, UserDataConstants.NAME, name);
                        setStringSharedPreferences(UserDataConstants.SETTINGS, UserDataConstants.EMAIL, email);
                        setStringSharedPreferences(UserDataConstants.SETTINGS, UserDataConstants.PHONE, phone);
                        setStringSharedPreferences(UserDataConstants.SETTINGS, UserDataConstants.MOBLE, mobile);
                        setStringSharedPreferences(UserDataConstants.SETTINGS, UserDataConstants.USERTYPE, userType);
                        setStringSharedPreferences(UserDataConstants.SETTINGS, UserDataConstants.LOGINIP, loginIp);
                        setStringSharedPreferences(UserDataConstants.SETTINGS, UserDataConstants.LOGINDATE, loginDate);
                        setStringSharedPreferences(UserDataConstants.SETTINGS, UserDataConstants.LOGINFLAG, loginFlag);
                        setStringSharedPreferences(UserDataConstants.SETTINGS, UserDataConstants.PHOTO, photo);

                        dismissLoadingDialog();
                        showToast(islogin + "");
                        Intent intent = new Intent(LoginActivity.this, HtmlWebActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("cookies", cookies);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    } else {
                        showToast("失败原因:" + message);
                    }
                } else {
                    showToast("response==" + response);
                }


            }
        });
    }

    /**
     * 处理登录事件
     */
    private void postweb() throws Exception {
        if (isConnNet(this)) {
            showToast("请检查网络");
            return;
        }
//        showLoadingDialog("登录中...");
        String url = "http://192.168.3.199:8181/zgcy/a/shouye";
        OkHttpUtils.post()
                .url(url)
//                .addParams("username", username)
//                .addParams("password", password)
                .addHeader("Cookie", cookies1)//添加要传入的请求头参数cookies,cookies
                .addParams("flag", flag + "")
                .build().execute(new BeanCallback<String>() {
            @Override
            public void onError(Call call, Exception e, int id) {
                showToast("失败==" + e);
                Log.i("==", "==e==" + e);
            }

            @Override
            public void onResponse(String response, int id) {
                if (response != null) {

                    Intent intent = new Intent(LoginActivity.this, HtmlWebActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("cookies", cookies);
                    intent.putExtras(bundle);
                    startActivity(intent);
                } else {
                    showToast("response==" + response);
                }


            }
        });
    }

    private void getCookie(CookieJarImpl okHttpUtils) {
        List cookies = okHttpUtils.getCookieStore().getCookies();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < cookies.size(); i++) {
            Cookie cookie = (Cookie) cookies.get(i);
            String cookieName = cookie.name();
            String cookieValue = cookie.value();
            if (!TextUtils.isEmpty(cookieName)
                    && !TextUtils.isEmpty(cookieValue)) {
                sb.append(cookieName + "=");
                sb.append(cookieValue + ";");
            }
        }
        setStringSharedPreferences(UserDataConstants.SETTINGS, UserDataConstants.COOKIES, sb.toString());
    }
    public void startAlphaAnimation(){
        /**
         * @param fromAlpha 开始的透明度，取值是0.0f~1.0f，0.0f表示完全透明， 1.0f表示和原来一样
         * @param toAlpha 结束的透明度，同上
         */
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.2f);
        //设置动画持续时长
        alphaAnimation.setDuration(3000);
        //设置动画结束之后的状态是否是动画的最终状态，true，表示是保持动画结束时的最终状态
        alphaAnimation.setFillAfter(true);
        //设置动画结束之后的状态是否是动画开始时的状态，true，表示是保持动画开始时的状态
        alphaAnimation.setFillBefore(true);
        //设置动画的重复模式：反转REVERSE和重新开始RESTART
        alphaAnimation.setRepeatMode(AlphaAnimation.REVERSE);
        //设置动画播放次数
        alphaAnimation.setRepeatCount(AlphaAnimation.INFINITE);
        //开始动画
        animationIV.startAnimation(alphaAnimation);
        //清除动画
        animationIV.clearAnimation();
        //同样cancel()也能取消掉动画
        alphaAnimation.cancel();
    }
}
