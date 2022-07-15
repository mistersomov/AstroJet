package com.mistersomov.core.base;

import android.os.Bundle;

import moxy.MvpAppCompatActivity;

public abstract class BaseActivity extends MvpAppCompatActivity {

    public abstract int getLayoutResId();

    public abstract void injectComponent();
    public abstract void destroyComponent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        injectComponent();
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isNeedDestroyComponent()) {
            destroyComponent();
        }
    }

    private boolean isNeedDestroyComponent() {
        return !this.isChangingConfigurations();
    }
}
