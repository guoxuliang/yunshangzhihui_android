package yszhh.wlgj.com.yunshangzhihui_android.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import okhttp3.Call;
import okhttp3.Request;
import yszhh.wlgj.com.yunshangzhihui_android.R;
import yszhh.wlgj.com.yunshangzhihui_android.bases.BaseFragment;
import yszhh.wlgj.com.yunshangzhihui_android.https.OkHttpUtils;
import yszhh.wlgj.com.yunshangzhihui_android.https.callback.StringCallback;


public class Fragment1 extends BaseFragment {
    private String mBaseUrl = "http://192.168.31.242:8888/okHttpServer/";
    private static final String TAG = "MainActivity";
    private Button button;
    private TextView textview;
    private Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        button = (Button) view.findViewById(R.id.button);
        textview = (TextView) view.findViewById(R.id.textview);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getHtml(v);
            }
        });
    }

    public class MyStringCallback extends StringCallback {
        @Override
        public void onBefore(Request request, int id) {

        }

        @Override
        public void onAfter(int id) {

        }

        @Override
        public void onError(Call call, Exception e, int id) {
            e.printStackTrace();
            textview.setText("onError:" + e.getMessage());
        }

        @Override
        public void onResponse(String response, int id) {
            Log.e(TAG, "onResponse：complete");
            textview.setText("onResponse:" + response);

            switch (id) {
                case 100:
                    Toast.makeText(context, "http", Toast.LENGTH_SHORT).show();
                    break;
                case 101:
                    Toast.makeText(context, "https", Toast.LENGTH_SHORT).show();
                    break;
            }
        }

        @Override
        public void inProgress(float progress, long total, int id) {
            Log.e(TAG, "inProgress:" + progress);
        }
    }

    public void getHtml(View view)
    {
        String url = "http://www.zhiyun-tech.com/App/Rider-M/changelog-zh.txt";
        url="http://blog.csdn.net/danshijin/article/details/50196049";
        OkHttpUtils
                .get()
                .url(url)
                .id(100)
                .build()
                .execute(new MyStringCallback());
    }
}
