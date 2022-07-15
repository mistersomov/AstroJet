package com.mistersomov.core.base;

import android.util.Log;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import moxy.MvpPresenter;
import moxy.MvpView;

public class BasePresenter<T extends MvpView> extends MvpPresenter<T> {

    private static final String ASTROJET_TAG = "ASTROJET_LOGGER";

    public CompositeDisposable compositeDisposable = new CompositeDisposable();

    public void addDisposable(Disposable disposable) {
        compositeDisposable.add(disposable);
    }

    @Override
    public void onDestroy() {
        compositeDisposable.dispose();
        super.onDestroy();
    }

    protected void loggingError(Throwable throwable) {
        String method = Thread
                .currentThread()
                .getStackTrace()[Thread.currentThread().getStackTrace().length - 1].getMethodName();
        Log.e(ASTROJET_TAG, getClass().getName() + " --> " + method + "ERROR: " + throwable.getMessage());
    }
}
