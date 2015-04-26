package com.stone.sherlocksimple;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;

import java.util.ArrayList;

/**
 */
public class List4ActionActivity extends SherlockActivity {
    ActionBar mActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_list4_action);


        mActionBar = getSupportActionBar();

        setHomeOptions();

        mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);

        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            list.add("bar item" + i);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);

        mActionBar.setListNavigationCallbacks(adapter, new ActionBar.OnNavigationListener() {
            @Override
            public boolean onNavigationItemSelected(int itemPosition, long itemId) {
                Toast.makeText(getApplicationContext(), "itemPosition=" + itemPosition
                        + "----itemId" + itemId, Toast.LENGTH_SHORT).show();
                return true;
            }
        });

    }

    /**
     * 设置左上角功能：系统默认的返回按钮，有程序图标，无title
     */
    private void setHomeOptions() {
        mActionBar.setTitle("");

//        mActionBar.setDisplayHomeAsUpEnabled(true); //显示返回的图标

//        mActionBar.setDefaultDisplayHomeAsUpEnabled(true);//使用默认返回图标
//        mActionBar.setDisplayHomeAsUpEnabled(true); //显示返回的图标

//        mActionBar.setIcon(R.mipmap.ic_launcher);//设置home图标，manifest中的activity-icon居然无效
        mActionBar.setLogo(R.mipmap.ic_launcher);//设置logo图标
//        mActionBar.setDisplayShowHomeEnabled(true);//显示home图标，如果设成false，则没有程序图标，仅仅就个标题

        /*
        int DISPLAY_HOME_AS_UP	显示“home”元素，比如出现一个 “up” 功能
        int	DISPLAY_SHOW_CUSTOM	Show 显示自定义内容view，如果设置了
        int	DISPLAY_SHOW_HOME	显示“home”元素
        int	DISPLAY_SHOW_TITLE	显示activity的title和副title，如果设置了  mActionBar.setSubtitle();
        int	DISPLAY_USE_LOGO	使用logo在actionbar，如果图标可用。Use logo instead of icon if available.
         */
        //会覆盖上面的set操作。如果仅设置一项，如show_home,那么仅有show_home的功能，homeAsUp没了
        mActionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME | ActionBar.DISPLAY_HOME_AS_UP | ActionBar.DISPLAY_USE_LOGO);

//        mActionBar.setHomeButtonEnabled(true);//启用程序图标 (在holo主题才有用)
    }

    @Override
    public boolean onCreateOptionsMenu(com.actionbarsherlock.view.Menu menu) {
        getSupportMenuInflater().inflate(R.menu.menu_list4_action, menu);
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
}
