package com.stone.sherlocksimple;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.actionbarsherlock.app.SherlockActivity;


public class MainActivity extends SherlockActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(com.actionbarsherlock.view.Menu menu) {
        getSupportMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void list(View view) {
        startActivity(new Intent(this, List4ActionActivity.class));
    }

    public void tab(View view) {
        startActivity(new Intent(this, Tab4ActionBarActivity.class));
    }
}
