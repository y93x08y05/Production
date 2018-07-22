package com.example.t_tazhan.production.Image;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.t_tazhan.production.R;

import java.util.ArrayList;
import java.util.List;

public class ImageBrowseActivity extends AppCompatActivity {

    private ViewPager viewPagerImg;

    private List<ImgSimple> imgSimples;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_image_browse);

        viewPagerImg = this.findViewById(R.id.viewPagerImgs);
        viewPagerImg.setOffscreenPageLimit(2);

        initData();

        PagerAdapter adapter = new ImgBrowsePagerAdapter(this, imgSimples);
        viewPagerImg.setAdapter(adapter);

    }

    private void initData() {
        imgSimples = new ArrayList<>();
        ImgSimple imgSimple1 = new ImgSimple();
        imgSimple1.scale = 1.6f;
        ArrayList<PointSimple> pointSimples = new ArrayList<>();
        PointSimple pointSimple1 = new PointSimple();
        pointSimple1.width_scale = 0.36f;
        pointSimple1.height_scale = 0.75f;
        pointSimples.add(pointSimple1);
        imgSimples.add(imgSimple1);
    }
}
