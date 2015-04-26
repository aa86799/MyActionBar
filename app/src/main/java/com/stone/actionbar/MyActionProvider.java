package com.stone.actionbar;

import android.content.Context;
import android.view.ActionProvider;
import android.view.LayoutInflater;
import android.view.View;

/**
 * author : stone
 * email  : aa86799@163.com
 * time   : 15/4/26 19 05
 */
public class MyActionProvider extends ActionProvider {

    private Context context;
    /**
     * Creates a new instance.
     *
     * @param context Context for accessing resources.
     */
    public MyActionProvider(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public View onCreateActionView() {
        View view = LayoutInflater.from(this.context).inflate(R.layout.action_provider, null);
        return view;
    }

}
