package yszhh.wlgj.com.yunshangzhihui_android.ui.custom;

import android.app.Dialog;
import android.content.Context;

/**
 * 自定义dialog
 * 
 * @author Mr.Xu
 */
public class MyCustomDialog extends Dialog {

    public MyCustomDialog(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }
//    // 定义回调事件，用于dialog的点击事件
//    public interface OnCustomDialogListener {
//        public void back(String name);
//    }
//
//    private String name;
//    private OnCustomDialogListener customDialogListener;
//    EditText etName;
//    EditText etCode;
//    private String dialog;
//
//    private String webUserId = "";
//    private String telePhone = "";
//
//    private AddUserTel addtel;
//
//    private String server_code = "";
//    private String server_msg = "";
//
//    public static final int SUCCESS = 1001; // 获取成功
//    public static final int FAILURE = 1002; // 系统异常
//    public static final int PARAMSERROR = 1003; // 参数异常
//
//    public MyCustomDialog(Context context, String name, String userID, OnCustomDialogListener customDialogListener) {
//        super(context);
//        this.name = name;
//        this.customDialogListener = customDialogListener;
//        webUserId = userID;
//    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.add_phone_dialog);
//        // 设置标题
//        setTitle(name);
////        etName = (EditText) findViewById(R.id.edit);// 初始化手机号码框
////        etCode = (EditText) findViewById(R.id.edit2);// 初始化验证码框
////        Button clickBtn = (Button) findViewById(R.id.clickbtn);
////        Button holdBtn = (Button) findViewById(R.id.btn_hold);// 保存按钮
//
//        try {
//            Field field = dialog.getClass().getSuperclass().getDeclaredField("mShowing");
//            field.setAccessible(true);
//            field.set(dialog, false);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        holdBtn.setOnClickListener(clickListener);
//
//    }
//
//    // 点击保存按钮
//    private View.OnClickListener clickListener = new View.OnClickListener() {
//
//        @Override
//        public void onClick(View v) {
//            telePhone = etName.getText().toString().trim();
//            String yzcode = etCode.getText().toString().trim();
//
//            addUserTelePhone();
//        }
//
//        private Handler mHandler = new Handler() {
//
//            @Override
//            public void handleMessage(Message msg) {
//
//                switch (msg.what) {
//                case SUCCESS:
//                    Toast.makeText(getContext(), "提交成功", Toast.LENGTH_LONG).show();
//                    dismiss();
//                    break;
//                case PARAMSERROR:
//                    Toast.makeText(getContext(), "信息获取失败", Toast.LENGTH_LONG).show();
//                    break;
//                case FAILURE:
//                    Toast.makeText(getContext(), "参数异常", Toast.LENGTH_LONG).show();
//                    break;
//                default:
//                    break;
//                }
//            }
//        };
//
//       
//    };
//
}
