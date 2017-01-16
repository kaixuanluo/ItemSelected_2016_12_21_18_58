package com.example.admin.itemselected_2016_12_21_18_58;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.OnTabSelectedListener;
import android.support.design.widget.TabLayout.Tab;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.admin.itemselected_2016_12_21_18_58.view.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2017/1/16 16:18 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2017/1/16 16:18 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
public class ServenActivity extends BaseActivity {

    NoScrollViewPager vp;
    MyViewPageOpenCloseListener myViewPageOpenCloseListener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_serven);

        TabLayout tl = (TabLayout) findViewById(R.id.four_tl);
        vp = (NoScrollViewPager) findViewById(R.id.four_vp);

        myViewPageOpenCloseListener = new MyViewPageOpenCloseListener(vp);

        List<TitleFragment> tfList = new ArrayList<>();
        tfList.add(new TitleFragment("第一个", MyPageFragment.newInstance(0, vp, myViewPageOpenCloseListener)));
        tfList.add(new TitleFragment("第2个", MyPageFragment.newInstance(1, vp, myViewPageOpenCloseListener)));
        tfList.add(new TitleFragment("第3个", MyPageFragment.newInstance(2, vp, myViewPageOpenCloseListener)));
        tfList.add(new TitleFragment("第4个", MyPageFragment.newInstance(3, vp, myViewPageOpenCloseListener)));

        vp.setAdapter(new MyPageAdapter(getSupportFragmentManager(), tfList));
        tl.setupWithViewPager(vp);
        tl.addOnTabSelectedListener(new OnTabSelectedListener() {
            @Override
            public void onTabSelected(Tab tab) {
                if (vp.getVisibility() == View.GONE) {
                    myViewPageOpenCloseListener.open();
                }
            }

            @Override
            public void onTabUnselected(Tab tab) {

            }

            @Override
            public void onTabReselected(Tab tab) {
                if (vp.getVisibility() == View.GONE) {
                    myViewPageOpenCloseListener.open();
                } else if (vp.getVisibility() == View.VISIBLE) {
                    myViewPageOpenCloseListener.close();
                }
            }
        });

    }

    class MyViewPageOpenCloseListener implements CloseOpenListener {

        ViewPager mViewPager;
        public MyViewPageOpenCloseListener(ViewPager vp) {
            this.mViewPager = vp;
        }

        @Override
        public void close() {
            if (mViewPager.getVisibility() == View.VISIBLE) {
                mViewPager.setVisibility(View.GONE);
            }
        }

        @Override
        public void open() {
            if (mViewPager.getVisibility() == View.GONE) {
                mViewPager.setVisibility(View.VISIBLE);
            }
        }
    }

    class MyPageAdapter extends FragmentStatePagerAdapter {

        List<TitleFragment> mTfList;

        public MyPageAdapter(FragmentManager fm) {
            super(fm);
        }

        public MyPageAdapter(FragmentManager fm,  List<TitleFragment> tfList) {
            super(fm);
            this.mTfList = tfList;
        }

        @Override
        public Fragment getItem(int position) {
            return mTfList.get(position).getFragment();
        }

        @Override
        public int getCount() {
            return mTfList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTfList.get(position).getTitle();
        }
    }

    private class TitleFragment {

        String title;
        Fragment fragment;

        public TitleFragment(String title, Fragment fragment) {
            this.title = title;
            this.fragment = fragment;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Fragment getFragment() {
            return fragment;
        }

        public void setFragment(Fragment fragment) {
            this.fragment = fragment;
        }
    }

    public interface CloseOpenListener {
        void close();
        void open();
    }

    public static class MyPageFragment extends Fragment {

        public static MyPageFragment newInstance(int type, NoScrollViewPager vp, CloseOpenListener closeOpenListener) {

            mVp = vp;
            sMCloseOpenListener = closeOpenListener;
            Bundle args = new Bundle();
            args.putInt("args", type);
            MyPageFragment fragment = new MyPageFragment();
            fragment.setArguments(args);
            return fragment;
        }

        TextView tv;
        Button bt;
        static CloseOpenListener sMCloseOpenListener;

        static NoScrollViewPager mVp;
        int mType;

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_four, container, false);
            tv = (TextView) view.findViewById(R.id.frg_four_content_tv);
            bt = (Button) view.findViewById(R.id.frg_four_close_bt);
            bt.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    sMCloseOpenListener.close();
                }
            });
            mType = getArguments().getInt("args");
            return view;

//            mType = getArguments().getInt("args");
//            return super.onCreateView(inflater, container, savedInstanceState);
        }

        @Override
        public void onActivityCreated(@Nullable Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);

            switch (mType) {
                case 0:
                    tv.setText(mType+"");
                    break;
                case 1:
                    tv.setText(mType+"n\n\n" +
                            "n" +
                            "" +
                            "n\n\n\n\n33333");
                    break;
                case 2:
                    tv.setText(mType+"" +
                            "n" +
                            "nn" +
                            "nn" +
                            "n" +
                            "");
                    break;
                case 3:
                    tv.setText(mType+"\n\n\n\\n\n\n\n\n\n\n\n\555555555566666");
                    break;
            }
        }
    }

}
