package yszhh.wlgj.com.yunshangzhihui_android.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import yszhh.wlgj.com.yunshangzhihui_android.R;


public class Fragment3 extends Fragment implements OnItemClickListener {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_line, null);
		initViews(view);
		return view;
	}
	
	
	
	

	
	
	
	private void initViews(View view) {

       
		
		
	}
	
	
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
//		Info s = mInfo.get(arg2);
//		TextView tvmessage = (TextView) arg1.findViewById(R.id.list_message_item);
	}
	
}
