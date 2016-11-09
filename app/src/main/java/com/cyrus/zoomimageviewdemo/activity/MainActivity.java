package com.cyrus.zoomimageviewdemo.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.cyrus.zoomimageviewdemo.R;
import com.cyrus.zoomimageviewdemo.adapter.GridViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Bitmap> drawables = new ArrayList<>();

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 2;//图片太大，在这里进行压缩
        drawables.add(BitmapFactory.decodeResource(getResources(), R.drawable.tongyeong, options));
        drawables.add(BitmapFactory.decodeResource(getResources(), R.drawable.brighton, options));
        drawables.add(BitmapFactory.decodeResource(getResources(), R.drawable.czech, options));
        drawables.add(BitmapFactory.decodeResource(getResources(), R.drawable.dresden, options));
        drawables.add(BitmapFactory.decodeResource(getResources(), R.drawable.hongkong, options));
        drawables.add(BitmapFactory.decodeResource(getResources(), R.drawable.korea, options));
        drawables.add(BitmapFactory.decodeResource(getResources(), R.drawable.positano, options));
        drawables.add(BitmapFactory.decodeResource(getResources(), R.drawable.holyroodpark, options));
        drawables.add(BitmapFactory.decodeResource(getResources(), R.drawable.praha, options));

        GridView gridView = (GridView) findViewById(R.id.grid_view);
        GridViewAdapter gridViewAdapter = new GridViewAdapter(this, drawables);
        gridView.setAdapter(gridViewAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, ImageActivity.class);
                intent.putExtra("mPosition", position);
                startActivity(intent);
            }
        });
    }

}
