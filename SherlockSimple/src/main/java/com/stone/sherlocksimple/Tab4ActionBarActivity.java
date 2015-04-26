package com.stone.sherlocksimple;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.ViewConfiguration;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;

import java.lang.reflect.Field;

public class Tab4ActionBarActivity extends SherlockActivity implements ActionBar.TabListener {

    private ActionBar mActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_tab4_action_bar);

        mActionBar = getSupportActionBar();

        setHomeOptions();

        mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        for (int i = 0; i < 10; i++) {
            ActionBar.Tab tab = mActionBar.newTab();
            tab.setIcon(R.mipmap.ic_launcher);
            tab.setText("tab" + i);
            tab.setTabListener(this);
//      tab.setCustomView(view); //设置自定义view为标签
            mActionBar.addTab(tab);//添加标签
        }

    }

    /**
     * 设置左上角功能：自定义返回按钮，无程序图标，有title
     */
    private void setHomeOptions() {

        mActionBar.setDisplayHomeAsUpEnabled(true); //显示返回的图标

        mActionBar.setIcon(R.mipmap.ic_launcher);//设置程序图标
        mActionBar.setDisplayShowHomeEnabled(true);//显示程序图标，如果设成false，则没有程序图标，仅仅就个标题

        mActionBar.setHomeButtonEnabled(true);//启用程序图标 可点击(在holo主题才有用)
    }

    @Override
    public boolean onCreateOptionsMenu(com.actionbarsherlock.view.Menu menu) {
        getSupportMenuInflater().inflate(R.menu.menu_tab4_action_bar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(com.actionbarsherlock.view.MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if (id == android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        System.out.println("tab:" + tab.getText());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}