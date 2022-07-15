package com.mistersomov.core.base;

import android.os.Bundle;

import moxy.MvpAppCompatFragment;

public abstract class BaseFragment extends MvpAppCompatFragment {

    public abstract void injectComponent();
    public abstract void destroyComponent();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        injectComponent();
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (isNeedDestroyComponent()) {
            destroyComponent();
        }
    }

    private boolean isNeedDestroyComponent() {
        if (getActivity() == null) {
            return true;
        }
        return !getActivity().isChangingConfigurations();
    }
}
