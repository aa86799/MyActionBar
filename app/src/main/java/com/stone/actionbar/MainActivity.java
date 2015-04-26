package com.stone.actionbar;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    ActionBar mActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mActionBar = getSupportActionBar();

//        mActionBar.collapseActionView();//收缩折叠 action view
        mActionBar.addOnMenuVisibilityListener(new ActionBar.OnMenuVisibilityListener() {
            @Override
            public void onMenuVisibilityChanged(boolean isVisible) {
                if (isVisible) {
                    System.out.println("menus is visible");
                }
            }
        });
//        mActionBar.dispatchMenuVisibilityChanged(true);//
//        mActionBar.getCustomView();

        mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);//default


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

//        LinearLayout item = (LinearLayout)menu.findItem(R.id.action_day).getActionView();//需要api11
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
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

        return super.onOptionsItemSelected(item);
    }

    public void barVisible(View view) {
        if (mActionBar.isShowing()) {
            mActionBar.hide();
        } else {
            mActionBar.show();
        }
    }

    public void tab(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {//api11
            startActivity(new Intent(this, Tab4ActionBarActivity2.class));
        } else if (Build.VERSION.SDK_INT > Build.VERSION_CODES.ECLAIR_MR1) {//api7
            startActivity(new Intent(this, Tab4ActionBarActivity.class));
        }
    }

    public void list(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {//api11
            startActivity(new Intent(this, List4ActionActivity2.class));
        } else if (Build.VERSION.SDK_INT > Build.VERSION_CODES.ECLAIR_MR1) {//api7
            startActivity(new Intent(this, List4ActionActivity.class));
        }

    }

    public void actionBarSherlock(View view) {

    }
}
