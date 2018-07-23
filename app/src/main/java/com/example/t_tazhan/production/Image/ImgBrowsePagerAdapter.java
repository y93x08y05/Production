package com.example.t_tazhan.production.Image;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.t_tazhan.production.R;

import java.util.ArrayList;
import java.util.List;

public class ImgBrowsePagerAdapter extends PagerAdapter {

    public static List<ImgSimple> imgSimples;

    public static List<View> views;

    public static Activity mContext;

    public static int width;
    public static int height;

    public ImgBrowsePagerAdapter(Activity context, List<ImgSimple> imgSimples) {

        this.mContext = context;
        this.imgSimples = imgSimples;

        this.views = new ArrayList<>();

        DisplayMetrics dm = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(dm);

        width = dm.widthPixels;
    }

    @Override
    public int getCount() {
        return imgSimples.size();
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((View) object);
    }
    public static ImageLayout layoutContent;
    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        LinearLayout view = (LinearLayout) LayoutInflater.from(mContext).inflate(R.layout.layout_img_browse, null);
        layoutContent = view.findViewById(R.id.layoutContent);
        try {
            float scale = imgSimples.get(position).scale;
            ArrayList<PointSimple> pointSimples = imgSimples.get(position).pointSimples;
            layoutContent.setPoints(pointSimples);
            height = (int) (width * scale);
            layoutContent.setImgBg(width, height);
        } catch (Exception e) {
            e.printStackTrace();
        }
        container.addView(view);
        return view;
    }
}