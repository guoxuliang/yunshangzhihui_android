package yszhh.wlgj.com.yunshangzhihui_android.https.callback;

/**
 * Created by JimGong on 2016/6/23.
 */
public interface IGenericsSerializator {

    <T> T transform(String response, Class<T> classOfT);
}
