package yszhh.wlgj.com.yunshangzhihui_android.bases;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import yszhh.wlgj.com.yunshangzhihui_android.ui.adapter.ViewFlowAdapter;
import yszhh.wlgj.com.yunshangzhihui_android.ui.tools.StringHelper;
import yszhh.wlgj.com.yunshangzhihui_android.widgets.CircleFlowIndicator;
import yszhh.wlgj.com.yunshangzhihui_android.widgets.ViewFlow;


public class BaseFragment extends Fragment {

    private Dialog loginDialog;
    private Context mContent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        mContent = getActivity();
    }
    protected void showToast(String str) {
        Toast.makeText(getActivity(), str, Toast.LENGTH_LONG).show();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
    }

    @Override
    public void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
    }

    @Override
    public void onStop() {
        // TODO Auto-generated method stub
        super.onStop();
    }

    /**
     * @Title: getVersionCode
     * @Description: TODO(��ȡ�汾�� �磺code =10)
     * @param
     * @return int 1 �쳣ʱ���� 0
     * @throws
     */
    protected int getVersionCode() {
        try {
            return getActivity().getPackageManager().getPackageInfo(getActivity().getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            return 0;
        }
    }

    protected String getVersionName() {
        try {
            return getActivity().getPackageManager().getPackageInfo(getActivity().getPackageName(), 0).versionName;
        } catch (NameNotFoundException e) {
            return "";
        }
    }

    /**
     * �����·�Ƿ���ͨ
     * 
     * @param context
     * @return
     */
    public static boolean isConnNet(Context context) {
        // ����ֻ��������ӹ�����󣨰�����wi-fi�����ӵĹ��?
        try {
            ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivity != null) {
                // ����������ӹ���Ķ���
                NetworkInfo info = connectivity.getActiveNetworkInfo();
                if (info != null && info.isConnected()) {
                    // �жϵ�ǰ�����Ƿ�������
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

    public void dismissLoadingDialog() {
        if (loginDialog != null && loginDialog.isShowing()) {
            loginDialog.dismiss();
        }
    }

    protected void openActivity(Class<?> pClass) {
        openActivity(pClass, null);
    }

    protected void openActivity(Class<?> pClass, Bundle pBundle) {
        Intent intent = new Intent(getActivity(), pClass);
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
        if (pBundle != null) {
            intent.putExtras(pBundle);
        }
        startActivity(intent);
    }

    protected void setBooleanSharedPreferences(String filename, String key, boolean value) {
        SharedPreferences.Editor editor = getActivity().getSharedPreferences(filename, 0).edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    protected boolean getBooleanSharePreferences(String filename, String key) {
        boolean flag = getActivity().getSharedPreferences(filename, 0).getBoolean(key, false);
        return flag;
    }

    protected void setStringSharedPreferences(String filename, String key, String value) {
        if (mContent != null) {
            SharedPreferences.Editor editor = getActivity().getSharedPreferences(filename, 0).edit();
            editor.putString(key, value);
            editor.commit();
        }
    }

    protected void setLongSharedpreferences(String filename, String key, long value) {
        if (mContent != null) {
            SharedPreferences.Editor editor = mContent.getSharedPreferences(filename, 0).edit();
            editor.putLong(key, value);
            editor.commit();
        }
    }

    protected long getLongSharePreferences(String filename, String key) {
        long result = getActivity().getSharedPreferences(filename, 0).getLong(key, 0);
        return result;
    }
    
    protected String getStringSharePreferences(String filename, String key) {
        String result = getActivity().getSharedPreferences(filename, 0).getString(key, "");

        if (!StringHelper.isNullOrEmpty(result)) {
            return result;
        } else {
            return "";
        }
    }

    /** 
     * 初始化viewFlow并设置数据
     * @param len 实际的图片数
     */
    public void initViewFlows(ViewFlowAdapter adapter,
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
