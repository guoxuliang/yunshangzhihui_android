package yszhh.wlgj.com.yunshangzhihui_android.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import yszhh.wlgj.com.yunshangzhihui_android.R;
import yszhh.wlgj.com.yunshangzhihui_android.bases.BaseActivity;
import yszhh.wlgj.com.yunshangzhihui_android.ui.fragment.Fragment1;
import yszhh.wlgj.com.yunshangzhihui_android.ui.fragment.Fragment2;
import yszhh.wlgj.com.yunshangzhihui_android.ui.fragment.Fragment3;
import yszhh.wlgj.com.yunshangzhihui_android.ui.fragment.Fragment4;
import yszhh.wlgj.com.yunshangzhihui_android.ui.fragment.Fragment5;
import yszhh.wlgj.com.yunshangzhihui_android.ui.tools.BackHandledInterface;

public class MainActivity extends BaseActivity implements BackHandledInterface {
    private Fragment fragment1;
    private Fragment fragment2;
    private Fragment fragment3;
    private Fragment fragment4;
    private Fragment fragment5;
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private RadioGroup radioGroup;
    private RadioButton radio1;
    RadioButton radio2;
    RadioButton radio3;
    RadioButton radio4;
    RadioButton radio5;

    private Fragment1 mBackHandedFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup1);
        // radio0= radioGroup.findViewById(R.id.radio0).setChecked(true);
        radio1 = (RadioButton) radioGroup.findViewById(R.id.radio0);
        radio1.setChecked(true);
        radio2 = (RadioButton) radioGroup.findViewById(R.id.radio1);
        radio3 = (RadioButton) radioGroup.findViewById(R.id.radio2);
        radio4 = (RadioButton) radioGroup.findViewById(R.id.radio3);
        radio5 = (RadioButton) radioGroup.findViewById(R.id.radio4);

        transaction = fragmentManager.beginTransaction();
        Fragment fragment = new Fragment1();
        transaction.replace(R.id.content, fragment);
        transaction.commit();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio0:

                        transaction = fragmentManager.beginTransaction();
                        fragment1 = new Fragment1();
                        transaction.replace(R.id.content, fragment1);
                        transaction.commit();
                        break;
                    case R.id.radio1:
                        transaction = fragmentManager.beginTransaction();
                        fragment2 = new Fragment2();
                        transaction.replace(R.id.content, fragment2);
                        transaction.commit();
                        break;
                    case R.id.radio2:
                        transaction = fragmentManager.beginTransaction();
                        fragment3 = new Fragment3();
                        transaction.replace(R.id.content, fragment3);
                        transaction.commit();
                        break;
                    case R.id.radio3:
                        transaction = fragmentManager.beginTransaction();
                        fragment4 = new Fragment4();
                        transaction.replace(R.id.content, fragment4);
                        transaction.commit();
                        break;
                    case R.id.radio4:
                        transaction = fragmentManager.beginTransaction();
                        fragment5 = new Fragment5();
                        transaction.replace(R.id.content, fragment5);
                        transaction.commit();
                        break;
                }

            }
        });

    }

    long waitTime = 2 * 1000;
    long touchTime = 0;
    // 再按一次退出
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN && KeyEvent.KEYCODE_BACK == keyCode) {
            long currentTime = System.currentTimeMillis();
            if ((currentTime - touchTime) >= waitTime) {
                Toast.makeText(MainActivity.this, "再按一次退出", Toast.LENGTH_SHORT).show();
                touchTime = currentTime;
            } else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    @Override
    public void setSelectedFragment(Fragment1 selectedFragment) {
        this.mBackHandedFragment = selectedFragment;

    }
}