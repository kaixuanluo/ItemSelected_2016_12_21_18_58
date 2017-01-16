package com.example.admin.itemselected_2016_12_21_18_58;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.itemselected_2016_12_21_18_58.rcv.ItemTouchHelperAdapter;
import com.example.admin.itemselected_2016_12_21_18_58.rcv.ItemTouchHelperCallback;
import com.example.admin.itemselected_2016_12_21_18_58.rcv.ItemTouchHelperViewHolder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2016/12/22 13:46 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2016/12/22 13:46 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
public class ThirdActivity extends BaseActivity {

    List<String> mDatas;

    ItemTouchHelper mItemTouchHelper;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_third);

        initData();

        RecyclerView rcv = (RecyclerView) findViewById(R.id.third_rcv);
        rcv.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter adapter = new MyAdapter();
        rcv.setAdapter(adapter);

        ItemTouchHelperCallback itemTouchHelperCallback = new ItemTouchHelperCallback(adapter);
        mItemTouchHelper = new ItemTouchHelper(itemTouchHelperCallback);
        mItemTouchHelper.attachToRecyclerView(rcv);
    }

    private void initData () {
        mDatas = new ArrayList<String>();
        for (int i = 'A'; i < 'z'; i++) {
            mDatas.add("" + (char) i);
        }
    }

    class MyAdapter extends RecyclerView.Adapter<MyViewHolder> implements ItemTouchHelperAdapter {

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyViewHolder(LayoutInflater.from(ThirdActivity.this).inflate(R.layout.item,
                    parent, false));
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, int position) {
            holder.mTv.setText(mDatas.get(position)+"");

            holder.mTv.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (MotionEventCompat.getActionMasked(event) == MotionEvent.ACTION_DOWN) {
                        mItemTouchHelper.startDrag(holder);
                    }
                    return false;
                }
            });
        }

        @Override
        public int getItemCount() {
            return mDatas.size();
        }

        @Override
        public boolean onItemMove(int fromPosition, int toPosition) {
            //互换列表中指定位置的数据
            Collections.swap(mDatas, fromPosition, toPosition);
            notifyItemMoved(fromPosition, toPosition);
            return true;
        }

        @Override
        public void onItemDismiss(int position) {
            mDatas.remove(position);
            notifyItemRemoved(position);
        }
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements ItemTouchHelperViewHolder {

        TextView mTv;
        public MyViewHolder(View itemView) {
            super(itemView);
            mTv = (TextView) itemView.findViewById(R.id.textViewId);
        }

        @Override
        public void onItemSelected() {
            itemView.setBackgroundColor(Color.LTGRAY);
        }

        @Override
        public void onItemClear() {
            itemView.setBackgroundColor(0);
        }

    }
}
