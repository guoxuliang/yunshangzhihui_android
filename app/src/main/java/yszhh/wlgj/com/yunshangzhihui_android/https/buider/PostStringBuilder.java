package yszhh.wlgj.com.yunshangzhihui_android.https.buider;


import okhttp3.MediaType;
import yszhh.wlgj.com.yunshangzhihui_android.https.request.PostStringRequest;
import yszhh.wlgj.com.yunshangzhihui_android.https.request.RequestCall;

/**
 * Created by zhy on 15/12/14.
 */
public class PostStringBuilder extends OkHttpRequestBuilder<PostStringBuilder> {
    private String content;
    private MediaType mediaType;


    public PostStringBuilder content(String content)
    {
        this.content = content;
        return this;
    }

    public PostStringBuilder mediaType(MediaType mediaType)
    {
        this.mediaType = mediaType;
        return this;
    }

    @Override
    public RequestCall build()
    {
        return new PostStringRequest(url, tag, params, headers, content, mediaType,id).build();
    }


}
