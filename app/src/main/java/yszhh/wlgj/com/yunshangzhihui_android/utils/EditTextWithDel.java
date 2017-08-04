package yszhh.wlgj.com.yunshangzhihui_android.utils;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;

import yszhh.wlgj.com.yunshangzhihui_android.R;

/**
 * @作者：Administrator
 * @时间：2014-3-24 上午10:53:24
 * @描述：自定义带删除图标的edittext
 */

public class EditTextWithDel extends EditText {
	private Drawable imgAble;
	private Context mContext;
	private Drawable leftDrawable;

	// 默认构造函数
	public EditTextWithDel(Context context) {
		super(context);
		mContext = context;
		init();
	}

	// 默认构造函数
	public EditTextWithDel(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		mContext = context;
		init();
	}

	// 默认构造函数
	public EditTextWithDel(Context context, AttributeSet attrs) {
		super(context, attrs);
		mContext = context;
		init();
	}

	// 初始化
	private void init() {
		imgAble = mContext.getResources().getDrawable(R.mipmap.icon_delete);
		leftDrawable = getCompoundDrawables()[0];
		// 添加监听
		addTextChangedListener(new TextWatcher() {
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				String contents = s.toString();
				int length = contents.length();
//				if (length == 4) {
//					if (contents.substring(3).equals(new String(" "))) { // -
//						contents = contents.substring(0, 3);
//						setText(contents);
//						setSelection(contents.length());
//					} else { // +
//						contents = contents.substring(0, 3) + " " + contents.substring(3);
//						setText(contents);
//						setSelection(contents.length());
//					}
//				} else if (length == 9) {
//					if (contents.substring(8).equals(new String(" "))) { // -
//						contents = contents.substring(0, 8);
//						setText(contents);
//						setSelection(contents.length());
//					} else {// +
//						contents = contents.substring(0, 8) + " " + contents.substring(8);
//						setText(contents);
//						setSelection(contents.length());
//					}
//				}
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

	// 处理删除事件
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (imgAble != null && event.getAction() == MotionEvent.ACTION_UP) {
			int eventX = (int) event.getRawX();
            int eventY = (int) event.getRawY();
            Rect rect = new Rect();
            getGlobalVisibleRect(rect);
            rect.left = rect.right - 50;
            if(rect.contains(eventX, eventY)) 
            	setText("");
		}
		return super.onTouchEvent(event);
	}
}
