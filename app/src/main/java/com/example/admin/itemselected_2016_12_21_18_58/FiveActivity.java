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
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.widget.LinearLayoutCompat.LayoutParams;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.admin.itemselected_2016_12_21_18_58.bean.MenuListBean.MenuList;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2016/12/23 13:48 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2016/12/23 13:48 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
public class FiveActivity extends BaseActivity {

    ViewPager vp;
    MyViewPageOpenCloseListener myViewPageOpenCloseListener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_five);

        TabLayout tl = (TabLayout) findViewById(R.id.four_tl);
        vp = (ViewPager) findViewById(R.id.four_vp);

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

        vp.addOnPageChangeListener(new OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
//                vp.resetHeight(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
//        vp.resetHeight(0);
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

    public static class MyPageFragment extends MyMenuFragment {

        public static MyPageFragment newInstance(int type, ViewPager vp, CloseOpenListener closeOpenListener) {

            mVp = vp;
            sMCloseOpenListener = closeOpenListener;
            Bundle args = new Bundle();
            args.putInt("args", type);
            MyPageFragment fragment = new MyPageFragment();
            fragment.setArguments(args);
            return fragment;
        }

        Button bt;
        static CloseOpenListener sMCloseOpenListener;

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            mType = getArguments().getInt("args");
            return super.onCreateView(inflater, container, savedInstanceState);
        }

        @Override
        public void onActivityCreated(@Nullable Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);

            switch (mType) {
                case 0:
//                    tv.setText(mType+"");
                    ArrayList<MenuList> menuLists = new ArrayList<>();
                    for (int i = 'a'; i<'b'; i++){
                        menuLists.add(new MenuList(i+"", new ArrayList<MenuList>()));
                    }
                    addListMenu(menuLists);

//                    for (int i = 0; i < menuLists.size(); i++) {
//                        View view1 = LayoutInflater.from(this.getContext())
//                                .inflate(R.layout.item, null);
//                        TextView tv = (TextView) view1.findViewById(R.id.textViewId);
//                        tv.setText(menuLists.get(i).getMenuName()+"");
//                        mLlContent.addView(view1);
//                    }

//                    TextView textView = new TextView(this.getContext());
//                    textView.setText("qqqqqqq");
//                    mLlContent.addView(textView);

                    break;
                case 1:
//                    tv.setText(mType+"n\n\n" +
//                            "n" +
//                            "" +
//                            "n\n\n\n\n33333");

                    ArrayList<MenuList> menuLists1 = new ArrayList<>();
                    for (int i = 'a'; i<'t'; i++){
                        menuLists1.add(new MenuList(i+"", new ArrayList<MenuList>()));
                    }
                    addListMenu(menuLists1);
                    break;
                case 2:
//                    tv.setText(mType+"" +
//                            "n" +
//                            "nn" +
//                            "nn" +
//                            "n" +
//                            "");
                    ArrayList<MenuList> menuLists2 = new ArrayList<>();
                    for (int i = 'a'; i<'q'; i++){
                        menuLists2.add(new MenuList(i+"", new ArrayList<MenuList>()));
                    }
                    addListMenu(menuLists2);
                    break;
                case 3:
//                    tv.setText(mType+"\n\n\n\\n\n\n\n\n\n\n\n\555555555566666");

                    ArrayList<MenuList> menuLists3 = new ArrayList<>();
                    for (int i = 'a'; i<'z'; i++){
                        menuLists3.add(new MenuList(i+"", new ArrayList<MenuList>()));
                    }
                    addListMenu(menuLists3);

                    break;
            }
        }
    }

    public static class MyMenuFragment extends Fragment {

        static ViewPager mVp;
        int mType;
        LinearLayout mLlContent;

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_menu_empty, container, false);
            mLlContent = (LinearLayout) view.findViewById(R.id.fragment_menu_empty_ll);
            LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    FrameLayout.LayoutParams.MATCH_PARENT);
            view.setLayoutParams(params);
//            mVp.setObjectForPosition(view, mType);
//            return super.onCreateView(inflater, (ViewGroup) view, savedInstanceState);
            return view;
        }

        public void addListMenu (final ArrayList<MenuList> menuLists) {
            if (menuLists == null || menuLists.isEmpty()){
                return;
            }

            for (int i = 0; i < menuLists.size(); i++) {
                LinearLayout ll = new LinearLayout(MyMenuFragment.this.getContext());
                ll.setOrientation(LinearLayout.HORIZONTAL);

                View view1 = LayoutInflater.from(MyMenuFragment.this.getContext())
                        .inflate(R.layout.item, null);
                TextView tv = (TextView) view1.findViewById(R.id.textViewId);
                tv.setText(menuLists.get(i).getMenuName()+"");

                mLlContent.addView(view1);
            }

//            ListView lv = new ListView(this.getContext());
//            lv.setItemsCanFocus(true);// 让ListView的item获得焦点
//            lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);// 单选模式
//            // 默认第一个item被选中
//            lv.setItemChecked(0, true);
//            lv.setAdapter(new BaseAdapter() {
//                @Override
//                public int getCount() {
//                    return menuLists.size();
//                }
//
//                @Override
//                public Object getItem(int i) {
//                    return menuLists.get(i);
//                }
//
//                @Override
//                public long getItemId(int i) {
//                    return i;
//                }
//
//                @Override
//                public View getView(int i, View view, ViewGroup viewGroup) {
//                    View view1 = LayoutInflater.from(MyMenuFragment.this.getContext())
//                            .inflate(R.layout.item, viewGroup, false);
//                    TextView tv = (TextView) view1.findViewById(R.id.textViewId);
//                    tv.setText(menuLists.get(i).getMenuName()+"");
//                    return view1;
//                }
//            });
//
//            mLlContent.addView(lv);
//
//            lv.setOnItemClickListener(new OnItemClickListener() {
//                @Override
//                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                    Log.e(" click ", menuLists + " click " + menuLists.get(i));
//                }
//            });
        }

        public void onMenuListClick (LinearLayout ll, ListView lv) {

        }
    }
}
