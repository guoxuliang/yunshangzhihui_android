package yszhh.wlgj.com.yunshangzhihui_android.utils;

/**
 * @类名称: Constants
 * @类描述: TODO(这里用一句话描述这个类的作用)
 * @作者
 * @日期
 * 
 */
public class Constants {
//	  public static final String SERVER_BASE_URL = "http://192.168.1.100:8080/";//张诚
	  public static final String SERVER_BASE_URL = "http://192.168.0.47:8080/";//王丰
//    public static final String SERVER_BASE_URL = "http://192.168.0.202:9081";// 内网测试
//    public static final String SERVER_BASE_URL = "http://202.100.15.66:9082";// 公网测试
//    public static final String SERVER_BASE_URL = "http://202.100.15.66:9080";// 公网
    public static String WSDL = "source-api/rest/sourcewebservice/";//公
//    public static String WSDL = "source-api/rest/bmwebservice/";//内
    
    
    public static boolean UPDATE_USER_SUCCESS=false;
    public static int DOWNLOAD_SUCCESS=2;//是否下载成功  -1 失败，0 未下载完成， 1 下载完成, 2 已下载过
    public static boolean APP_EXIST=false;//应用是否存在
}
