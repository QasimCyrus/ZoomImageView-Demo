package com.cyrus.zoomimageviewdemo.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.cyrus.zoomimageviewdemo.R;
import com.cyrus.zoomimageviewdemo.ZoomImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * 大图ViewPage的适配器
 * <p>
 * Created by Cyrus on 2016/11/9.
 */

public class ViewPagerAdapter extends PagerAdapter {

    private List<Bitmap> mDrawables;
    private List<View> mViews;

    public ViewPagerAdapter(Context context, List<Bitmap> drawables) {
        mDrawables = drawables;

        mViews = new ArrayList<>();
        for (int i = 0; i < mDrawables.size(); i++) {
            mViews.add(View.inflate(context, R.layout.item_pager_image, null));
        }
    }

    @Override
    public int getCount() {
        return mDrawables.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = mViews.get(position);

        ZoomImageView zoomImageView = (ZoomImageView) view.findViewById(R.id.zoom_image_view);
        zoomImageView.setImageBitmap(mDrawables.get(position));

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
