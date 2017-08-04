package yszhh.wlgj.com.yunshangzhihui_android.bean;

/**
 * Created by Administrator on 2017/7/10 0010.
 */

import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import okhttp3.Response;
import yszhh.wlgj.com.yunshangzhihui_android.https.callback.Callback;

/**
 * Created by ${YiHan} on 2016/4/15 0015.
 */
public abstract class BeanCallback<T> extends Callback<T> {

    @Override
    public T parseNetworkResponse(Response response,int id) throws Exception {
        Type type = this.getClass().getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            //如果用户写了泛型，就会进入这里，否者不会执行
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type beanType = parameterizedType.getActualTypeArguments()[0];
            if (beanType == String.class) {
                //如果是String类型，直接返回字符串
                return (T) response.body().string();
            } else {
                //如果是 Bean List Map ，则解析完后返回
                return new Gson().fromJson(response.body().string(), beanType);
            }
        } else {
            //如果没有写泛型，直接返回Response对象
            return (T) response;
        }
    }
}
