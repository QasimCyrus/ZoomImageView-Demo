package com.cyrus.zoomimageviewdemo.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.cyrus.zoomimageviewdemo.R;

import java.util.List;

/**
 * GridView适配器
 * <p>
 * Created by Cyrus on 2016/11/9.
 */

public class GridViewAdapter extends BaseAdapter {

    private List<Bitmap> mDrawables;
    private Context mContext;

    public GridViewAdapter(Context context, List<Bitmap> drawables) {
        mContext = context;
        mDrawables = drawables;
    }

    @Override
    public int getCount() {
        return mDrawables.size();
    }

    @Override
    public Object getItem(int position) {
        return mDrawables.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();

            convertView = View.inflate(mContext, R.layout.item_grid_image, null);
//            convertView = LayoutInflater.from(mContext)
//                    .inflate(R.layout.item_grid_image, parent, false);
            viewHolder.mImageView = (ImageView) convertView.findViewById(R.id.iv_grid_item);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        //设置每张图片的宽高
        GridView gridView = (GridView) parent;
        int horizontalSpacing = gridView.getHorizontalSpacing();
        int numColumns = gridView.getNumColumns();
        int itemSize = (gridView.getWidth() - (numColumns - 1) * horizontalSpacing
                - gridView.getPaddingLeft() - gridView.getPaddingRight()) / numColumns;

        AbsListView.LayoutParams params = new AbsListView.LayoutParams(itemSize, itemSize);
        viewHolder.mImageView.setLayoutParams(params);

        viewHolder.mImageView.setImageBitmap(mDrawables.get(position));

        return convertView;
    }

    private class ViewHolder {
        ImageView mImageView;
    }

}
