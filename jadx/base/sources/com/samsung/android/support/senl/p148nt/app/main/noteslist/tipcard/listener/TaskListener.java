package com.samsung.android.support.senl.p148nt.app.main.noteslist.tipcard.listener;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.app.common.util.ViewModeUtils;
import com.samsung.android.support.senl.p148nt.base.common.tipcard.TipCardProgress;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class TaskListener {
    boolean mIsCancelled = false;
    final TipCardTaskListener mTaskListener;
    final TipCardProgress mTipCardProgress;
    final WeakReference<Activity> mWeakRefActivity;

    public TaskListener(Activity activity, @NonNull TipCardProgress tipCardProgress, @NonNull TipCardTaskListener tipCardTaskListener) {
        this.mWeakRefActivity = new WeakReference<>(activity);
        this.mTipCardProgress = tipCardProgress;
        this.mTaskListener = tipCardTaskListener;
        updateProgress();
    }

    private void updateProgress() {
        ViewModeUtils.runOnUiThread(this.mWeakRefActivity.get(), new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.tipcard.listener.TaskListener.1
            @Override // java.lang.Runnable
            public void run() {
                TaskListener taskListener = TaskListener.this;
                if (taskListener.mIsCancelled) {
                    return;
                }
                taskListener.mTaskListener.updateProgress(taskListener.mTipCardProgress);
            }
        });
    }

    public void setOnCancelled() {
        this.mIsCancelled = true;
    }

    public void setProgress(int i, int i2, int i4) {
        this.mTipCardProgress.setProgressInfo(i, i2, i4);
        updateProgress();
    }
}
