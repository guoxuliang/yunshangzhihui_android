package yszhh.wlgj.com.yunshangzhihui_android.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


import yszhh.wlgj.com.yunshangzhihui_android.R;
import yszhh.wlgj.com.yunshangzhihui_android.bases.BaseActivity;
import yszhh.wlgj.com.yunshangzhihui_android.ui.tools.StringHelper;

/**
 * @author 登陆界面 作者：guoxuliang
 */
public class LoginActivity extends BaseActivity implements OnClickListener {
    private EditText etusername;// 用户名
    private EditText etpwd;// 密码
    private Button btlogin;// 登录


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
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btlogin:
                String username=etusername.getText().toString().trim();
                String password = etpwd.getText().toString().trim();
                if (StringHelper.isNullOrEmpty(username)) {
                    showToast("请输入用户名");
                    btlogin.setEnabled(true);
                    return;
                }
                if (!StringHelper.isPhoneNumberValid(username)) {
                    showToast("请输入正确手机号");
                    btlogin.setEnabled(true);
                    return;
                }
                if (StringHelper.isNullOrEmpty(password)) {
                    showToast("请输入密码");
                    btlogin.setEnabled(true);
                    return;
                }
                if (password.length() < 8) {
                    showToast("密码长度不对");
                    btlogin.setEnabled(true);
                    return;
                }
                openActivity(MainActivity.class);
                break;
        }
    }
}
