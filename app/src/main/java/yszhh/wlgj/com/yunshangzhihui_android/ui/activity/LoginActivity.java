package yszhh.wlgj.com.yunshangzhihui_android.ui.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.gson.Gson;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.Request;
import yszhh.wlgj.com.yunshangzhihui_android.R;
import yszhh.wlgj.com.yunshangzhihui_android.bases.BaseActivity;
import yszhh.wlgj.com.yunshangzhihui_android.https.OkHttpUtils;
import yszhh.wlgj.com.yunshangzhihui_android.https.callback.BitmapCallback;
import yszhh.wlgj.com.yunshangzhihui_android.https.callback.Callback;
import yszhh.wlgj.com.yunshangzhihui_android.https.callback.FileCallBack;
import yszhh.wlgj.com.yunshangzhihui_android.https.callback.StringCallback;
import yszhh.wlgj.com.yunshangzhihui_android.ui.entity.User;

/**
 * @author 登陆界面 作者：guoxuliang
 */
public class LoginActivity extends BaseActivity implements OnClickListener{
    private EditText etusername;// 用户名
    private EditText etpwd;// 密码
    private Button btlogin,btlogin2,btlogin3,btlogin4,btlogin5,btlogin6,btlogin7,btlogin8,btlogin9,btlogin10;// 登录
    private String username;
    private String password;
    private TextView textview;
    private ImageView imageview;

    private String mBaseUrl = "http://192.168.31.242:8888/okHttpServer/";
    private static final String TAG = "MainActivity";

    public class MyStringCallback extends StringCallback
    {
        @Override
        public void onBefore(Request request, int id)
        {

            setTitle("loading...");
        }

        @Override
        public void onAfter(int id)
        {
            setTitle("Sample-okHttp");
        }

        @Override
        public void onError(Call call, Exception e, int id)
        {
            e.printStackTrace();
            textview.setText("onError:" + e.getMessage());
        }

        @Override
        public void onResponse(String response, int id)
        {
            Log.e(TAG, "onResponse：complete");
            textview.setText("onResponse:" + response);

            switch (id)
            {
                case 100:
                    Toast.makeText(LoginActivity.this, "http", Toast.LENGTH_SHORT).show();
                    break;
                case 101:
                    Toast.makeText(LoginActivity.this, "https", Toast.LENGTH_SHORT).show();
                    break;
            }
        }

        @Override
        public void inProgress(float progress, long total, int id)
        {
            Log.e(TAG, "inProgress:" + progress);
        }
    }


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
        btlogin2 = (Button) findViewById(R.id.btlogin2);
        btlogin3 = (Button) findViewById(R.id.btlogin3);
        btlogin4 = (Button) findViewById(R.id.btlogin4);
        btlogin5 = (Button) findViewById(R.id.btlogin5);
        btlogin6 = (Button) findViewById(R.id.btlogin6);
        btlogin7 = (Button) findViewById(R.id.btlogin7);
        btlogin8 = (Button) findViewById(R.id.btlogin8);
        btlogin9 = (Button) findViewById(R.id.btlogin9);
        btlogin10 = (Button) findViewById(R.id.btlogin10);
        btlogin3.setOnClickListener(this);
        btlogin4.setOnClickListener(this);
        btlogin5.setOnClickListener(this);
        btlogin6.setOnClickListener(this);
        btlogin7.setOnClickListener(this);
        btlogin8.setOnClickListener(this);
        btlogin9.setOnClickListener(this);
        btlogin10.setOnClickListener(this);
        textview= (TextView) findViewById(R.id.textview);
        imageview= (ImageView) findViewById(R.id.imageview);
    }
    @Override
    public void onClick(View v) {
switch (v.getId()){
    case R.id.btlogin:
        textview.setText("");
        getHtml(textview);
        break;
    case R.id.btlogin2:
        textview.setText("");
        postString(textview);
        break;
    case R.id.btlogin3:
        textview.setText("");
        postFile(textview);
        break;
    case R.id.btlogin4:
        textview.setText("");
        getHttpsHtml(textview);
        break;
    case R.id.btlogin5:
        textview.setText("");
        postFile(textview);
        break;
    case R.id.btlogin6:
        textview.setText("");
        getHttpsHtml(textview);
        break;
    case R.id.btlogin7:
        textview.setText("");
        getImage(textview);
        break;
    case R.id.btlogin8:
        textview.setText("");
        uploadFile(textview);
        break;
    case R.id.btlogin9:
        textview.setText("");
        multiFileUpload(textview);
        break;
    case R.id.btlogin10:
        textview.setText("");
        downloadFile(textview);
        break;

}

    }

    public void getHtml(View view)
    {
        String url = "http://www.zhiyun-tech.com/App/Rider-M/changelog-zh.txt";
        url="http://www.391k.com/api/xapi.ashx/info.json?key=bd_hyrzjjfb4modhj&size=10&page=1";
        OkHttpUtils
                .get()
                .url(url)
                .id(100)
                .build()
                .execute(new MyStringCallback());
    }

    public void postString(View view)
    {
        String url = mBaseUrl + "user!postString";
        OkHttpUtils
                .postString()
                .url(url)
                .mediaType(MediaType.parse("application/json; charset=utf-8"))
                .content(new Gson().toJson(new User("zhy", "123")))
                .build()
                .execute(new MyStringCallback());

    }
    public void postFile(View view){
        File file = new File(Environment.getExternalStorageDirectory(), "messenger_01.png");
        if (!file.exists())
        {
            Toast.makeText(LoginActivity.this, "文件不存在，请修改文件路径", Toast.LENGTH_SHORT).show();
            return;
        }
        String url = mBaseUrl + "user!postFile";
        OkHttpUtils
                .postFile()
                .url(url)
                .file(file)
                .build()
                .execute(new MyStringCallback());
    }

    public void getHttpsHtml(View view)
    {
        String url = "https://kyfw.12306.cn/otn/";

//                "https://12
//        url =3.125.219.144:8443/mobileConnect/MobileConnect/authLogin.action?systemid=100009&mobile=13260284063&pipe=2&reqtime=1422986580048&ispin=2";
        OkHttpUtils
                .get()//
                .url(url)//
                .id(101)
                .build()//
                .execute(new MyStringCallback());

    }
    public void getImage(View view) {
        textview.setText("");
        String url = "http://images.csdn.net/20150817/1.jpg";
        OkHttpUtils
                .get()//
                .url(url)//
                .tag(this)//
                .build()//
                .connTimeOut(20000)
                .readTimeOut(20000)
                .writeTimeOut(20000)
                .execute(new BitmapCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        textview.setText("onError:" + e.getMessage());
                    }

                    @Override
                    public void onResponse(Bitmap bitmap, int id) {
                        Log.e("TAG", "onResponse：complete");
                        imageview.setImageBitmap(bitmap);
                    }
                });
    }

    public void uploadFile(View view)
    {

        File file = new File(Environment.getExternalStorageDirectory(), "messenger_01.png");
        if (!file.exists())
        {
            Toast.makeText(LoginActivity.this, "文件不存在，请修改文件路径", Toast.LENGTH_SHORT).show();
            return;
        }
        Map<String, String> params = new HashMap<>();
        params.put("username", "张鸿洋");
        params.put("password", "123");

        Map<String, String> headers = new HashMap<>();
        headers.put("APP-Key", "APP-Secret222");
        headers.put("APP-Secret", "APP-Secret111");

        String url = mBaseUrl + "user!uploadFile";

        OkHttpUtils.post()//
                .addFile("mFile", "messenger_01.png", file)//
                .url(url)//
                .params(params)//
                .headers(headers)//
                .build()//
                .execute(new MyStringCallback());
    }

    public void multiFileUpload(View view)
    {
        File file = new File(Environment.getExternalStorageDirectory(), "messenger_01.png");
        File file2 = new File(Environment.getExternalStorageDirectory(), "test1#.txt");
        if (!file.exists())
        {
            Toast.makeText(LoginActivity.this, "文件不存在，请修改文件路径", Toast.LENGTH_SHORT).show();
            return;
        }
        Map<String, String> params = new HashMap<>();
        params.put("username", "张鸿洋");
        params.put("password", "123");

        String url = mBaseUrl + "user!uploadFile";
        OkHttpUtils.post()//
                .addFile("mFile", "messenger_01.png", file)//
                .addFile("mFile", "test1.txt", file2)//
                .url(url)
                .params(params)//
                .build()//
                .execute(new MyStringCallback());
    }

    public void downloadFile(View view)
    {
        String url = "https://github.com/hongyangAndroid/okhttp-utils/blob/master/okhttputils-2_4_1.jar?raw=true";
        OkHttpUtils//
                .get()//
                .url(url)//
                .build()//
                .execute(new FileCallBack(Environment.getExternalStorageDirectory().getAbsolutePath(), "gson-2.2.1.jar")//
                {

                    @Override
                    public void onBefore(Request request, int id)
                    {
                    }

                    @Override
                    public void inProgress(float progress, long total, int id)
                    {
//                        mProgressBar.setProgress((int) (100 * progress));
                        Log.e(TAG, "inProgress :" + (int) (100 * progress));
                    }

                    @Override
                    public void onError(Call call, Exception e, int id)
                    {
                        Log.e(TAG, "onError :" + e.getMessage());
                    }

                    @Override
                    public void onResponse(File file, int id)
                    {
                        Log.e(TAG, "onResponse :" + file.getAbsolutePath());
                    }
                });
    }
}
