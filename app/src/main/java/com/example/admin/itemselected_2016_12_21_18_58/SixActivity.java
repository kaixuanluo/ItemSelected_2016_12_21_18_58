package com.example.admin.itemselected_2016_12_21_18_58;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2016/12/23 15:09 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2016/12/23 15:09 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
public class SixActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_six);

        LinearLayout ll = (LinearLayout) findViewById(R.id.six_empty_ll);

        TextView child = new TextView(this);
        child.setText("wwwwwwwwwwwwwwwwwww");
        ll.addView(child);
    }
}
