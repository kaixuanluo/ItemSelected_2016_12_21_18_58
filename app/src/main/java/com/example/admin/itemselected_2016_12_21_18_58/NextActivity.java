package com.example.admin.itemselected_2016_12_21_18_58;

import android.os.Bundle;
import android.widget.TextView;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2016/12/21 19:05 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2016/12/21 19:05 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
public class NextActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);

        TextView tv1 = (TextView) findViewById(R.id.second_tv_1);
//        tv1.setFocusable(true);
    }
}
