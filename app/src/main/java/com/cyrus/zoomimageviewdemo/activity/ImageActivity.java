package com.cyrus.zoomimageviewdemo.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.cyrus.zoomimageviewdemo.R;
import com.cyrus.zoomimageviewdemo.adapter.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        List<Bitmap> drawables = new ArrayList<>();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 2;//图片较大，压缩画质
        drawables.add(BitmapFactory.decodeResource(getResources(), R.drawable.tongyeong, options));
        drawables.add(BitmapFactory.decodeResource(getResources(), R.drawable.brighton, options));
        drawables.add(BitmapFactory.decodeResource(getResources(), R.drawable.czech, options));
        drawables.add(BitmapFactory.decodeResource(getResources(), R.drawable.dresden, options));
        drawables.add(BitmapFactory.decodeResource(getResources(), R.drawable.hongkong, options));
        drawables.add(BitmapFactory.decodeResource(getResources(), R.drawable.korea, options));
        drawables.add(BitmapFactory.decodeResource(getResources(), R.drawable.positano, options));
        drawables.add(BitmapFactory.decodeResource(getResources(), R.drawable.holyroodpark, options));
        drawables.add(BitmapFactory.decodeResource(getResources(), R.drawable.praha, options));

        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        Intent intent = getIntent();

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this, drawables);
        viewPager.setAdapter(viewPagerAdapter);

        int itemPosition = intent.getIntExtra("mPosition", 0);
        viewPager.setCurrentItem(itemPosition);
    }

}
