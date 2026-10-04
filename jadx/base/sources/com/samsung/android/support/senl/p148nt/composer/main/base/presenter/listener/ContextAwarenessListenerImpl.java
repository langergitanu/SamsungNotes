package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.listener;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.model.contextawareness.ContextAwarenessListener;
import com.samsung.android.support.senl.p148nt.model.contextawareness.common.result.IContextAwarenessResult;
import java.util.Observable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ContextAwarenessListenerImpl extends Observable implements ContextAwarenessListener {
    private static final String TAG = Logger.createTag("ContextAwarenessListenerImpl");
    private Activity mActivity;

    public void init(@NonNull Activity activity) {
        Logger.m10999d(TAG, "init#");
        this.mActivity = activity;
    }

    public boolean isValidState() {
        Activity activity = this.mActivity;
        if (activity != null && !activity.isFinishing() && !this.mActivity.isDestroyed()) {
            return true;
        }
        Logger.m10999d(TAG, "isValidState# invalid");
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.contextawareness.ContextAwarenessListener
    public void onContextAwarenessFinished(@NonNull IContextAwarenessResult iContextAwarenessResult) {
        Logger.m10999d(TAG, "onContextAwarenessFinished#");
        if (isValidState()) {
            setChanged();
            notifyObservers(iContextAwarenessResult);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.contextawareness.ContextAwarenessListener
    public void onContextAwarenessStarted() {
        Logger.m10999d(TAG, "onContextAwarenessStarted#");
    }

    public void release() {
        Logger.m10999d(TAG, "release#");
        this.mActivity = null;
    }
}
