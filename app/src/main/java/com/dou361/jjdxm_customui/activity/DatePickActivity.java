package com.dou361.jjdxm_customui.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dou361.jjdxm_customui.R;
import com.dou361.customui.ui.DateTimeSelectorDialogBuilder;
/**
 * ========================================
 * <p/>
 * 版 权：dou361.com 版权所有 （C） 2015
 * <p/>
 * 作 者：陈冠明
 * <p/>
 * 个人网站：http://www.dou361.com
 * <p/>
 * 版 本：1.0
 * <p/>
 * 创建日期：2016/5/18 11:12
 * <p/>
 * 描 述：日期选择面板
 * <p/>
 * <p/>
 * 修订历史：
 * <p/>
 * ========================================
 */
public class DatePickActivity extends AppCompatActivity implements View.OnClickListener, DateTimeSelectorDialogBuilder.OnSaveListener {

    private Context mContext;
    private TextView tv_date;
    private Button btn_select;
    private Button btn_select_ymd;
    private Button btn_select_ymdhm;
    private Button btn_select_ymdhms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_pick);
        mContext = this;
        tv_date = (TextView) findViewById(R.id.tv_date);
        btn_select = (Button) findViewById(R.id.btn_select);
        btn_select_ymd = (Button) findViewById(R.id.btn_select_ymd);
        btn_select_ymdhm = (Button) findViewById(R.id.btn_select_ymdhm);
        btn_select_ymdhms = (Button) findViewById(R.id.btn_select_ymdhms);
        btn_select.setOnClickListener(this);
        btn_select_ymd.setOnClickListener(this);
        btn_select_ymdhm.setOnClickListener(this);
        btn_select_ymdhms.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_select:
                selectDate();
                break;
            case R.id.btn_select_ymd:
                selectDateYMD();
                break;
            case R.id.btn_select_ymdhm:
                selectDateYMDHM();
                break;
            case R.id.btn_select_ymdhms:
                selectDateYMDHMS();
                break;
        }
    }

    private void selectDate() {
        DateTimeSelectorDialogBuilder date = new DateTimeSelectorDialogBuilder(mContext);
        date.setOnSaveListener(this);
        date.show();
    }

    private void selectDateYMD() {
        DateTimeSelectorDialogBuilder date = new DateTimeSelectorDialogBuilder(mContext);
        date.setShowDateType(DateTimeSelectorDialogBuilder.TYPE_YYYYMMDD);
        date.show();
    }

    private void selectDateYMDHM() {
        DateTimeSelectorDialogBuilder date = new DateTimeSelectorDialogBuilder(mContext);
        date.setShowDateType(DateTimeSelectorDialogBuilder.TYPE_YYYYMMDDHHMM);
        date.show();
    }

    private void selectDateYMDHMS() {
        DateTimeSelectorDialogBuilder date = new DateTimeSelectorDialogBuilder(mContext);
        date.setShowDateType(DateTimeSelectorDialogBuilder.TYPE_YYYYMMDDHHMMSS);
        date.show();
    }

    @Override
    public void onSaveSelectedDate(int tag, String selectedDate) {
        tv_date.setText(selectedDate);
    }
}
