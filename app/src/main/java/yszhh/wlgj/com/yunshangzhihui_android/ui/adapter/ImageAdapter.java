/*
 * Copyright (C) 2011 Patrik 锟絢erfeldt
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package yszhh.wlgj.com.yunshangzhihui_android.ui.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;

import yszhh.wlgj.com.yunshangzhihui_android.R;


public class ImageAdapter extends BaseAdapter {

	private Context mContext;
	private LayoutInflater mInflater;
	private List<Bitmap> ids = null;

	public ImageAdapter(Context context, List<Bitmap> imagePath) {
		mContext = context;
		ids = imagePath;
		mInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		return Integer.MAX_VALUE; // 杩斿洖寰堝ぇ鐨勫�浣垮緱getView涓殑position涓嶆柇澧炲ぇ鏉ュ疄鐜板惊鐜�
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
		((ImageView) convertView.findViewById(R.id.imgView)).setImageBitmap(ids
				.get(position % ids.size()));
		return convertView;
	}

}
