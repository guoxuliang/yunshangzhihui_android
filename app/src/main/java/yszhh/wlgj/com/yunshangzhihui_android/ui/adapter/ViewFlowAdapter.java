package yszhh.wlgj.com.yunshangzhihui_android.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import yszhh.wlgj.com.yunshangzhihui_android.R;


public class ViewFlowAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private static final int[] ids = {R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher };

    public ViewFlowAdapter(Context context) {
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.viewflow_image_item, null);
        }
        ((ImageView) convertView.findViewById(R.id.imgView)).setImageResource(ids[position % ids.length]);
        return convertView;
    }

}
