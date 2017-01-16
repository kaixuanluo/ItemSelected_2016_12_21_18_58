package com.example.admin.itemselected_2016_12_21_18_58;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2016/12/22 14:26 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2016/12/22 14:26 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setDisplayShowCustomEnabled(true);
//        actionBar.setDisplayHomeAsUpEnabled(true);   // 给左上角图标的左边加上一个返回的图标 。对应ActionBar.DISPLAY_HOME_AS_UP
//        actionBar.setDisplayShowHomeEnabled(true);  //使左上角图标可点击，对应id为android.R.id.home，对应ActionBar.DISPLAY_SHOW_HOME
////        actionBar.setDisplayShowTitleEnabled(false);
//        View view = LayoutInflater.from(this).inflate(R.layout.actionbar_title, null);
//        TextView tvTitle = (TextView) view.findViewById(R.id.action_bar_title_tv);
//        tvTitle.setText(getTitle());
//        LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT,
//                LayoutParams.MATCH_PARENT);
//        layoutParams.gravity = Gravity.CENTER_HORIZONTAL | Gravity.HORIZONTAL_GRAVITY_MASK;
//        actionBar.setCustomView(tvTitle, layoutParams);
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(addTitleBar(layoutResID));
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(addTitleBar(view));
    }

    View addTitleBar (@LayoutRes int viewRes) {
        View viewContent = LayoutInflater.from(this).inflate(viewRes, null);
        return addTitleBar(viewContent);
    }

    View addTitleBar (View view) {
        View toolbarView = LayoutInflater.from(this).inflate(R.layout.custom_toolbar, null);
        FrameLayout fl = (FrameLayout) toolbarView.findViewById(R.id.toolbar_fl);
        fl.addView(view);

        Toolbar toolbar = (Toolbar) toolbarView.findViewById(R.id.toolbar);
        TextView toolbarTitleTv = (TextView) toolbarView.findViewById(R.id.toolbar_title_tv);
        toolbarTitleTv.setText(getTitle());
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);   // 给左上角图标的左边加上一个返回的图标 。对应ActionBar.DISPLAY_HOME_AS_UP
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);  //使左上角图标可点击，对应id为android.R.id.home，对应ActionBar.DISPLAY_SHOW_HOME
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setHomeAsUpIndicator(android.R.drawable.arrow_up_float);
        toolbar.setNavigationOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        return toolbarView;

    }

}
