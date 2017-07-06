///**
// * @项目名称：ICS2.1
// * @文件名: UpdateService.java
// * @包名 com.tbwy.ty.ics.service
// * @描述: TODO(用一句话描述该文件做什么)
// * @作者 fengxian
// * @日期 2013-10-30 下午2:53:36
// * @版本 V2.0
// */
//package yszhh.wlgj.com.yunshangzhihui_android.ui.service;
//
//import android.app.Notification;
//import android.app.NotificationManager;
//import android.app.PendingIntent;
//import android.app.Service;
//import android.content.Intent;
//import android.net.Uri;
//import android.os.Handler;
//import android.os.IBinder;
//import android.os.Message;
//import android.view.View;
//import android.view.View.OnClickListener;
//
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.InputStream;
//import java.net.HttpURLConnection;
//import java.net.URL;
//
//import yszhh.wlgj.com.yunshangzhihui_android.R;
//import yszhh.wlgj.com.yunshangzhihui_android.ui.fragment.Fragment1;
//
//
///**
// * @类名称: UpdateService
// * @类描述: TODO(提供下载更新的服务类)
// * @作者 fengxian
// * @日期 2013-10-30 下午2:53:36
// *
// */
//
//public class UpdateService extends Service implements OnClickListener {
//
////    private static final LogProxy log_download = LogManager.getLog("UpdateService");
//     private static final int NOTIFYID=1012;
//
//    // app
//    private String titleId;
//
//    // Url
//    private String downloadurl;
//
//    // 文件存储
//    private File updateDir = null;
//    private File updateFile = null;
//
//    // 通知栏
//    private NotificationManager updateNotificationManager = null;
//    private Notification updateNotification = null;
//    // 通知栏跳转Intent
//    private Intent updateIntent = null;
//    private PendingIntent updatePendingIntent = null;
//    private static final int DOWNLOAD_COMPLETE = 0001;
//    private static final int DOWNLOAD_FAIL = 0002;
//    HttpHandler<File> handler;
//    private int totalSize;
//
//    @Override
//    public void onCreate() {
//        // TODO Auto-generated method stub
//        super.onCreate();
//
////        log_download.debug("onCreateonCreate");
//    }
//
//    @Override
//    public void onStart(Intent intent, int startId) {
//        // TODO Auto-generated method stub
//        super.onStart(intent, startId);
//
////        log_download.debug("onStartonStartonStart");
//    }
//
//    /* 下载包安装路径 */
//    private static final String savePath = "/sdcard/download/tianyibianmin";
//
//    @Override
//    public int onStartCommand(Intent intent, int flags, int startId) {
//        // TODO Auto-generated method stub
//        // 获取传值
////        log_download.debug("....onStartCommand");
//        if (intent != null) {
//
//            titleId = intent.getStringExtra("titleId");
//            downloadurl = intent.getStringExtra("appurl");
//            // 创建文件
//            File file = new File(savePath);
//            if (!file.exists()) {
//                file.mkdir();
//            }
//            if (android.os.Environment.MEDIA_MOUNTED.equals(android.os.Environment.getExternalStorageState())) {
//                // updateDir = new
//                // File(Environment.getExternalStorageDirectory(),
//                // Global.downloadDir);
//                updateDir = file;
//                updateFile = new File(updateDir.getPath(), titleId + ".apk");
//            }
//
//            this.updateNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
//            this.updateNotification = new Notification();
//
//            // 设置下载过程中，点击通知栏，回到主界面
//            updateIntent = new Intent(this, Fragment1.class);
//            // updateIntent.setAction("fengxianaaa");
//            updatePendingIntent = PendingIntent.getActivity(this, 0, updateIntent, 0);
//            // 设置通知栏显示内容
//            updateNotification.icon = R.mipmap.ic_launcher;
//            updateNotification.flags |= Notification.FLAG_AUTO_CANCEL;
//            updateNotification.tickerText = "开始下载";
//            updateNotification.setLatestEventInfo(this, "云上智慧", "0%", updatePendingIntent);
//            // 发出通知
//            updateNotificationManager.notify(NOTIFYID, updateNotification);
//
//            // 开启一个新的线程下载，如果使用Service同步下载，会导致ANR问题，Service本身也会阻塞
//            new Thread(new updateRunnable()).start();// 这个是下载的重点，是下载的过程
//
//        } else {
//
//        }
//
//        return super.onStartCommand(intent, flags, startId);
//
//    }
//
//    private Handler updateHandler = new Handler() {
//        @Override
//        public void handleMessage(Message msg) {
//            switch (msg.what) {
//            case DOWNLOAD_COMPLETE:
////                handler.cancel();// xUtils下载完后用
//                // 点击安装PendingIntent
//                showNotification();
//                // cancleNotify();
//                break;
//            case DOWNLOAD_FAIL:
//                // 下载失败
//                updateNotification.setLatestEventInfo(UpdateService.this, "云上智慧", "下载失败,点击取消。", updatePendingIntent);
//
//                // 设置点击通知栏后消失
//                updateNotification.flags |= Notification.FLAG_AUTO_CANCEL;
//                updateNotificationManager.notify(NOTIFYID, updateNotification);
//                // updateNotificationManager.cancel(0);
//                break;
////            case 11:
////                handler.cancel();
////                break;
//            default:
//                stopSelf();
//            }
//        }
//
//        private void showNotification() {
//            Uri uri = Uri.fromFile(updateFile);
//            Intent installIntent = new Intent(Intent.ACTION_VIEW);
//            installIntent.setDataAndType(uri, "application/vnd.android.package-archive");
//            updatePendingIntent = PendingIntent.getActivity(UpdateService.this, 0, installIntent, 0);
//
//            updateNotification.defaults = Notification.DEFAULT_SOUND;// 铃声提醒
//            updateNotification.setLatestEventInfo(UpdateService.this, "云上智慧", "下载完成,点击安装。", updatePendingIntent);
//            updateNotification.flags |= Notification.FLAG_AUTO_CANCEL;
//            updateNotificationManager.notify(NOTIFYID, updateNotification);
//            // updateNotificationManager.cancel(0);
//            installIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            // 停止服务
//            stopSelf();
//            startActivity(installIntent);
//        }
//    };
//
//    private void cancleNotify() {
//        updateNotificationManager.cancelAll();
//    }
//
//    class updateRunnable implements Runnable {
//        Message message = updateHandler.obtainMessage();
//
//        public void run() {
//            message.what = DOWNLOAD_COMPLETE;
//            try {
//                // 增加权限;
//                if (!updateDir.exists()) {
//                    updateDir.mkdirs();
//                }
//                if (!updateFile.exists()) {
//                    updateFile.createNewFile();
//                }
//                // 增加权限;
//                long downloadSize = downloadUpdateFile(downloadurl, updateFile);
//                // "http://202.100.15.66:8090/img/Apk/android/bianmin/zhihuishequ_v2.0.1_201309257056.apk",
//                // updateFile);
//                if (downloadSize > 0) {
//                    // 下载成功
//                    updateHandler.sendMessage(message);
//                }
//            } catch (Exception ex) {
//                ex.printStackTrace();
//                message.what = DOWNLOAD_FAIL;
//                // 下载失败
//                updateHandler.sendMessage(message);
//            }
//        }
//    }
//
//    public long downloadUpdateFile(String downloadUrl, File saveFile) throws Exception {
//        int downloadCount = 0;
//        int currentSize = 0;
//        long totalSize = 0;
//        int updateTotalSize = 0;
//
//        HttpURLConnection httpConnection = null;
//        InputStream is = null;
//        FileOutputStream fos = null;
//
//        try {
//            URL url = new URL(downloadUrl);
//            httpConnection = (HttpURLConnection) url.openConnection();
//            httpConnection.setRequestProperty("User-Agent", "PacificHttpClient");
//            if (currentSize > 0) {
//                httpConnection.setRequestProperty("RANGE", "bytes=" + currentSize + "-");
//            }
//            httpConnection.setConnectTimeout(10000);
//            httpConnection.setReadTimeout(20000);
//            updateTotalSize = httpConnection.getContentLength();
//            if (httpConnection.getResponseCode() == 404) {
//                throw new Exception("fail!");
//            }
//            is = httpConnection.getInputStream();
//            fos = new FileOutputStream(saveFile, false);
//            byte buffer[] = new byte[4096];
//            int readsize = 0;
//            while ((readsize = is.read(buffer)) > 0) {
//                fos.write(buffer, 0, readsize);
//                totalSize += readsize;
//                // 为了防止频繁的通知导致应用吃紧，百分比增加10才通知一次
//                if ((downloadCount == 0) || (int) (totalSize * 100 / updateTotalSize) - 10 > downloadCount) {
//                    downloadCount += 10;
//                    updateNotification.setLatestEventInfo(UpdateService.this, "正在下载", (int) totalSize * 100 / updateTotalSize + "%",
//                            updatePendingIntent);
//                    updateNotification.flags |= Notification.FLAG_AUTO_CANCEL;
//                    updateNotificationManager.notify(NOTIFYID, updateNotification);
//                }
//            }
//        } finally {
//            if (httpConnection != null) {
//                httpConnection.disconnect();
//            }
//            if (is != null) {
//                is.close();
//            }
//            if (fos != null) {
//                fos.close();
//            }
//        }
//        return totalSize;
//    }
//
//    /* 这个方法是使用xUtils进行下载文件*/
//    public long downloadUpdateFileUsedxUtils(String downloadUrl, String saveFile) throws Exception {
//        HttpUtils httpUtils = new HttpUtils();
//        handler = httpUtils.download(downloadUrl, saveFile, true, false, new RequestCallBack<File>() {
//
//            @Override
//            public void onFailure(HttpException arg0, String arg1) {
//            }
//
//            @Override
//            public void onLoading(long total, long current, boolean isUploading) {
//                totalSize = (int) total;
//                // 为了防止频繁的通知导致应用吃紧，百分比增加10才通知一次
//                updateNotification.setLatestEventInfo(UpdateService.this, "正在下载", (int) (current * 100 / total) + "%", updatePendingIntent);
//                updateNotification.flags |= Notification.FLAG_AUTO_CANCEL;
//                updateNotificationManager.notify(NOTIFYID, updateNotification);
//            }
//
//            @Override
//            public void onSuccess(ResponseInfo<File> arg0) {
//                updateHandler.sendEmptyMessage(DOWNLOAD_COMPLETE);
//            }
//        });
//        return totalSize;
//    }
//
//    @Override
//    public IBinder onBind(Intent intent) {
//        // TODO Auto-generated method stub
//        return null;
//    }
//
//    @Override
//    public void onClick(View v) {
//        //
//        switch (v.getId()) {
//        case 0:
//            // cancleNotify();
//            break;
//
//        default:
//            break;
//        }
//
//    }
//
//}
