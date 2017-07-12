package yszhh.wlgj.com.yunshangzhihui_android.utils;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.content.Context;

import java.util.LinkedList;
import java.util.List;

import yszhh.wlgj.com.yunshangzhihui_android.ui.fragment.Fragment1;

/**
 * Created by Administrator on 2017/7/10 0010.
 */

public class SystemApplication extends Application {
    public boolean m_bKeyRight = true;
    private static Context ct;
    private List<Activity> activityList = new LinkedList<Activity>();
    private List<Fragment> fragmentList = new LinkedList<Fragment>();
    private static SystemApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        ct = getApplicationContext();
//        initImageLoader(ct);

        // 发包时打开这个，取消日志。。平时关闭 查看日志
//        CrashExceptionHandler crashHandler = CrashExceptionHandler.getInstance();
//        crashHandler.init(getApplicationContext());// 不发时注释掉
    }

//    public static void initImageLoader(Context context) {
//        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context).threadPriority(Thread.NORM_PRIORITY - 2)// 加载图片的线程数
//                .denyCacheImageMultipleSizesInMemory()// 解码图像的大尺寸将在内存中缓存先前解码图像的小尺寸。
//                .discCacheFileNameGenerator(new Md5FileNameGenerator())// 设置磁盘缓存文件名称
//                .tasksProcessingOrder(QueueProcessingType.LIFO)// 设置加载显示图片队列进程
//                .build();
//        // .writeDebugLogs() // 发布时删除日志信息--需要删除这个
//        // Initialize ImageLoader with configuration.
//        ImageLoader.getInstance().init(config);
//    }

    public static SystemApplication getInstance() {
        if (null == instance) {
            instance = new SystemApplication();
        }
        return instance;
    }

    // 添加Activity到容器中
    public void addActivity(Activity activity) {
        activityList.add(activity);
    }

    // 遍历所有Activity并finish
    public void exit() {
        for (Activity activity : activityList) {
            activity.finish();
        }
        System.exit(0);
    }

}
