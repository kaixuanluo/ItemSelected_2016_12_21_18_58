package com.example.admin.itemselected_2016_12_21_18_58;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends BaseActivity {

    private ListView listView;
    String string[] = { "a", "b", "c", "d", "e", "f", "g", "h" };
    private LayoutInflater inflater;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listViewId);
        ListViewAdapter adapter = new ListViewAdapter();
        listView.setAdapter(adapter);
        listView.setItemsCanFocus(true);// 让ListView的item获得焦点
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);// 单选模式
        // 默认第一个item被选中
        listView.setItemChecked(0, true);

        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 3 ) {
                    startActivity(new Intent(MainActivity.this, SixActivity.class));
                }
                if (i == 4 ) {
                    startActivity(new Intent(MainActivity.this, FiveActivity.class));
                }
                if (i == 6 ) {
                    startActivity(new Intent(MainActivity.this, NextActivity.class));
                }
                if (i == 7 ){
                    startActivity(new Intent(MainActivity.this, ThirdActivity.class));
                }
                if (i == 5) {
                    startActivity(new Intent(MainActivity.this, FourActivity.class));
                }
                if (i == 2) {
                    startActivity(new Intent(MainActivity.this, ServenActivity.class));
                }
            }
        });
    }

    private class ListViewAdapter extends BaseAdapter {

        public ListViewAdapter() {
            super();
            // TODO Auto-generated constructor stub
            inflater = LayoutInflater.from(MainActivity.this);
        }

        @Override
        public int getCount() {
            return string.length;
        }

        @Override
        public Object getItem(int position) {
            return string[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;
            if (view == null) {
                view = inflater.inflate(R.layout.item, parent, false);
                ViewHolder viewHolder = new ViewHolder();
                viewHolder.content = (TextView) view
                        .findViewById(R.id.textViewId);
                view.setTag(viewHolder);
            }
            ViewHolder viewHolder = (ViewHolder) view.getTag();
            viewHolder.content.setText(string[position]);

            return view;
        }

    }

    private class ViewHolder {
        private TextView content;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_more, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
