package yszhh.wlgj.com.yunshangzhihui_android.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import yszhh.wlgj.com.yunshangzhihui_android.R;


public class Fragment4 extends Fragment {
	ImageView iv;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_find, null);
		initViews(view);
		return view;
	}
	private void initViews(View view) {
		// TODO Auto-generated method stub
	}

}
