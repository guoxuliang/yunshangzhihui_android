package yszhh.wlgj.com.yunshangzhihui_android.utils;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;
import yszhh.wlgj.com.yunshangzhihui_android.R;

/**
 * @作者：Administrator
 * @时间：2016-05-12 
 * @描述：自定义带切换图标的密码密文/明文显示
 */

public class EditTextWithPwdChanged extends EditText {
	private Drawable imgAble;
	private Context mContext;
	private Drawable leftDrawable;
	private boolean isFlags;//默认为密文

	// 默认构造函数
	public EditTextWithPwdChanged(Context context) {
		super(context);
		mContext = context;
		init();
	}

	// 默认构造函数
	public EditTextWithPwdChanged(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		mContext = context;
		init();
	}

	// 默认构造函数
	public EditTextWithPwdChanged(Context context, AttributeSet attrs) {
		super(context, attrs);
		mContext = context;
		init();
	}
	
	// 初始化
	private void init() {
		imgAble = mContext.getResources().getDrawable(R.mipmap.icon_close);
		leftDrawable = getCompoundDrawables()[0];
		// 添加监听
		addTextChangedListener(new TextWatcher() {
			public void onTextChanged(CharSequence s, int start, int before, int count) {
			}

			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
			}

			public void afterTextChanged(Editable s) {
				setDrawable();
			}
		});
		setDrawable();
	}

	// 设置删除图片
	private void setDrawable() {
		if (length() < 1)
			setCompoundDrawablesWithIntrinsicBounds(leftDrawable, null, null, null);
		else
			setCompoundDrawablesWithIntrinsicBounds(leftDrawable, null, imgAble, null);
	}

	// 处理事件
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (imgAble != null && event.getAction() == MotionEvent.ACTION_UP) {
			int eventX = (int) event.getRawX();
            int eventY = (int) event.getRawY();
            Rect rect = new Rect();
            getGlobalVisibleRect(rect);
            rect.left = rect.right - 50;
            if(rect.contains(eventX, eventY)) 
            	if(isFlags){
            		isFlags = false;
            		imgAble = mContext.getResources().getDrawable(R.mipmap.icon_close);
            		setTransformationMethod(PasswordTransformationMethod.getInstance());//密文显示
            		
            	}else{
            		isFlags = true;
            		imgAble = mContext.getResources().getDrawable(R.mipmap.icon_open);
            		setTransformationMethod(HideReturnsTransformationMethod.getInstance());//明文显示
            	}
		}
		return super.onTouchEvent(event);
	}
}
