package yszhh.wlgj.com.yunshangzhihui_android.bases;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.Display;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import yszhh.wlgj.com.yunshangzhihui_android.R;
import yszhh.wlgj.com.yunshangzhihui_android.ui.adapter.ImageAdapter;
import yszhh.wlgj.com.yunshangzhihui_android.ui.custom.MyDialog;
import yszhh.wlgj.com.yunshangzhihui_android.widgets.CircleFlowIndicator;
import yszhh.wlgj.com.yunshangzhihui_android.widgets.ViewFlow;


public class BaseActivity extends AppCompatActivity {
    private Dialog loginDialog;
    private Dialog updateDialog;

    @Override
    public void onBackPressed() {
        // if
        super.onBackPressed();
    }

    /**
     * 
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            if (onBackKeyDown(keyCode, event)) {
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    protected boolean onBackKeyDown(int keyCode, KeyEvent event) {
        return false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    protected boolean hasExtra(String pExtraKey) {
        if (getIntent() != null) {
            return getIntent().hasExtra(pExtraKey);
        }
        return false;
    }

    protected void openActivity(Class<?> pClass) {
        openActivity(pClass, null);
    }

    protected void showToast(String str) {
        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG).show();
    }
    
    protected void openActivity(Class<?> pClass, Bundle pBundle) {
        Intent intent = new Intent(this, pClass);
        if (pBundle != null) {
            intent.putExtras(pBundle);
        }
        startActivity(intent);
    }

    protected void openActivity(String pAction) {
        openActivity(pAction, null);
    }

    protected void openActivity(String pAction, Bundle pBundle) {
        Intent intent = new Intent(pAction);
        // intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (pBundle != null) {
            intent.putExtras(pBundle);
        }
        startActivity(intent);
    }

    /** 关闭提示框*/
    public void dismissLoadingDialog() {
        if (loginDialog != null && loginDialog.isShowing()) {
            loginDialog.dismiss();
        }
    }

    public void canclecheckNewVersionDialog() {
        if (updateDialog != null && updateDialog.isShowing()) {
            updateDialog.dismiss();
        }
    }

    
    /** 等待提示框 */
    public void showLoadingDialog(String msg) {
        if (loginDialog == null) {
            loginDialog = new MyDialog(BaseActivity.this, R.style.MyDialog);
        }
        if (loginDialog.isShowing()) {
            loginDialog.dismiss();
        }

        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.login_dialog, null);
        TextView text = (TextView) view.findViewById(R.id.login_dialog_textview);
        text.setText(msg);
        // 设置显示位置
        Window window = loginDialog.getWindow();
        window.setGravity(Gravity.CENTER);
        // 设置透明度
        Display display = getWindowManager().getDefaultDisplay();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.alpha = 0.8f;
        lp.width = (int) (display.getWidth() * 0.85);
        window.setAttributes(lp);

        // 弹出对话框或某些模式窗口时，后面的内容会变得模糊或不清楚
        // window.setFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND,
        // WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
        loginDialog.setCanceledOnTouchOutside(false);
        loginDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK) {
                    return true;
                } else {
                    return false; // 默认返回 false

                }
            }
        });
        loginDialog.setContentView(view);
        loginDialog.setCancelable(false);
        loginDialog.show();
    }
    
    /**
     * 检测网路是否连通
     * 
     * @param context
     * @return
     */
    public static boolean isConnNet(Context context) {
        // 获得手机所有连接管理对象（包括对wi-fi等连接的管理）
        try {
            ConnectivityManager connectivity = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivity != null) {
                // 获得网络连接管理的对象
                NetworkInfo info = connectivity.getActiveNetworkInfo();
                if (info != null && info.isConnected()) {
                    // 判断当前网络是否已连接
                    if (info.getState() == NetworkInfo.State.CONNECTED)
                        ;
                    return true;
                }
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    protected void setBooleanSharedPreferences(String filename, String key, boolean value) {
        SharedPreferences.Editor editor = this.getSharedPreferences(filename, 0).edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    protected boolean getBooleanSharePreferences(String filename, String key) {
        boolean flag = this.getSharedPreferences(filename, 0).getBoolean(key, false);
        return flag;
    }

    protected void setStringSharedPreferences(String filename, String key, String value) {
        SharedPreferences.Editor editor = this.getSharedPreferences(filename, 0).edit();
        editor.putString(key, value);
        editor.commit();
    }

    protected String getStringSharePreferences(String filename, String key) {
        String result = this.getSharedPreferences(filename, 0).getString(key, "");
        return result;
    }

    protected void setLongSharedpreferences(String filename, String key, long value) {
        SharedPreferences.Editor editor = this.getSharedPreferences(filename, 0).edit();
        editor.putLong(key, value);
        editor.commit();
    }

    protected long getLongSharePreferences(String filename, String key) {
        long result = this.getSharedPreferences(filename, 0).getLong(key, 0);
        return result;
    }

    public void defaultFinish() {
        super.finish();
    }

    public void onPageFinished(WebView view, String url) {
        // TODO Auto-generated method stub

    }

    public void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {

            return;
        }
        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {

            View listItem = listAdapter.getView(i, null, listView);
            LinearLayout layout = new LinearLayout(this);
            layout.addView(listItem);
            layout.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }
    
    // EditText错误提示
    public void showTipError(EditText ed, String estring) {
        int ecolor = R.color.black;
        ForegroundColorSpan fgcspan = new ForegroundColorSpan(ecolor);
        SpannableStringBuilder ssbuilder = new SpannableStringBuilder(estring);
        ssbuilder.setSpan(fgcspan, 0, estring.length(), 0);
        ed.setError(ssbuilder);
    }
    
    /** 
     * 初始化viewFlow并设置数据
     * @param len 实际的图片数
     */
    public void initViewFlows(Context context, ImageAdapter adapter,
                              ViewFlow viewFlow, CircleFlowIndicator indicator, int len) {
        // 设置Adapter
        viewFlow.setAdapter(adapter);
        // 设置监听，主要是设置点点的背景
//      mViewFlow.setOnPageChangeListener(new OnPageChangeListenerImpl(mLytPoints));
        viewFlow.setmSideBuffer(len);
        viewFlow.setFlowIndicator(indicator);
        viewFlow.setTimeSpan(4500);
        viewFlow.setSelection(3*1000);  //设置初始位置
        viewFlow.startAutoFlowTimer();  //启动自动播放
    } 
    
}
