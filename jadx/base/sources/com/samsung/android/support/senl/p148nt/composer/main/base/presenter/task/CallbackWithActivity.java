package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task;

import android.app.Activity;
import com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.ResultValues;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public abstract class CallbackWithActivity<R extends Task.ResultValues> implements Task.Callback<R> {
    private Activity mActivity;

    public CallbackWithActivity(Activity activity) {
        this.mActivity = activity;
    }

    public Activity getActivity() {
        return this.mActivity;
    }

    public void setActivity(Activity activity) {
        this.mActivity = activity;
    }
}
