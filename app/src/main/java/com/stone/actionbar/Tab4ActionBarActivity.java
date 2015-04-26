package com.stone.actionbar;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

/**
 * 使用v7 actionbar
 */
public class Tab4ActionBarActivity extends AppCompatActivity implements ActionBar.TabListener {

    private ActionBar mActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab4_action_bar);

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
        mActionBar.setHomeAsUpIndicator(android.R.drawable.ic_menu_rotate);//定义返回图标
        mActionBar.setDisplayHomeAsUpEnabled(true); //显示返回的图标

//        mActionBar.setDefaultDisplayHomeAsUpEnabled(true);//使用默认返回图标
//        mActionBar.setDisplayHomeAsUpEnabled(true); //显示返回的图标

        mActionBar.setIcon(R.mipmap.ic_launcher);//设置程序图标
        mActionBar.setDisplayShowHomeEnabled(false);//显示程序图标，如果设成false，则没有程序图标，仅仅就个标题

        mActionBar.setHomeButtonEnabled(true);//启用程序图标 可点击(在holo主题才有用)
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tab4_action_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
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
    public void onTabSelected(Tab tab, android.support.v4.app.FragmentTransaction ft) {

    }

    @Override
    public void onTabUnselected(Tab tab, android.support.v4.app.FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(Tab tab, android.support.v4.app.FragmentTransaction ft) {

    }
}
