package com.samsung.android.support.senl.p148nt.app.trigger.task;

import android.content.Context;
import android.os.AsyncTask;
import com.samsung.android.support.senl.p148nt.app.converter.ConverterDialogManager;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
abstract class AbsTriggerTask<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> {
    protected WeakReference<Context> mContextRef;
    protected ConverterDialogManager mDialogManager;

    public AbsTriggerTask(Context context, ConverterDialogManager converterDialogManager) {
        this.mContextRef = new WeakReference<>(context);
        this.mDialogManager = converterDialogManager;
    }

    public void dismissDialog() {
        ConverterDialogManager converterDialogManager = this.mDialogManager;
        if (converterDialogManager != null) {
            converterDialogManager.dismiss();
            this.mDialogManager = null;
        }
    }

    @Override // android.os.AsyncTask
    public void onCancelled() {
        super.onCancelled();
        dismissDialog();
        release();
    }

    public void release() {
        WeakReference<Context> weakReference = this.mContextRef;
        if (weakReference != null) {
            weakReference.clear();
            this.mContextRef = null;
        }
    }
}
