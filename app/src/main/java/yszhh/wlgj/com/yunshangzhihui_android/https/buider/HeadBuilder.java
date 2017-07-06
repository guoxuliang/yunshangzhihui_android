package yszhh.wlgj.com.yunshangzhihui_android.https.buider;


import yszhh.wlgj.com.yunshangzhihui_android.https.OkHttpUtils;
import yszhh.wlgj.com.yunshangzhihui_android.https.request.OtherRequest;
import yszhh.wlgj.com.yunshangzhihui_android.https.request.RequestCall;

/**
 * Created by zhy on 16/3/2.
 */
public class HeadBuilder extends GetBuilder
{
    @Override
    public RequestCall build()
    {
        return new OtherRequest(null, null, OkHttpUtils.METHOD.HEAD, url, tag, params, headers,id).build();
    }
}
