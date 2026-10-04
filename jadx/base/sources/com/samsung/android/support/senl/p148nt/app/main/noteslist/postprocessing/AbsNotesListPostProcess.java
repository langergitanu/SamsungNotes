package com.samsung.android.support.senl.p148nt.app.main.noteslist.postprocessing;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.base.common.log.AppLaunchLog;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbsNotesListPostProcess {
    protected ViewTreeObserver.OnPreDrawListener mFirstDrawListener = null;
    protected View mMainListView = null;
    protected Handler mHandler = null;
    protected Runnable mRunnable = null;

    /* JADX INFO: Access modifiers changed from: private */
    public void executeLogicsPostDelay(long j) {
        MainLogger.m7254d(getTag(), "executeLogicsPostDelay");
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        } else {
            this.mHandler = new Handler(Looper.getMainLooper());
        }
        Runnable runnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.postprocessing.AbsNotesListPostProcess.2
            @Override // java.lang.Runnable
            public void run() {
                MainLogger.m7254d(AbsNotesListPostProcess.this.getTag(), "executeLogicsPostDelay# run");
                AbsNotesListPostProcess absNotesListPostProcess = AbsNotesListPostProcess.this;
                if (absNotesListPostProcess.mHandler == null || absNotesListPostProcess.mRunnable == null) {
                    return;
                }
                absNotesListPostProcess.mRunnable = null;
                absNotesListPostProcess.executeLogics();
            }
        };
        this.mRunnable = runnable;
        this.mHandler.postDelayed(runnable, j);
    }

    public abstract void executeLogics();

    public void executeOnPreDraw(@NonNull final View view, final long j, final AppLaunchLog.LogParam logParam) {
        if (this.mMainListView != null && this.mFirstDrawListener != null) {
            MainLogger.m7254d(getTag(), "executeOnPreDraw# mMainListView and mFirstDrawListener is not null");
            view.getViewTreeObserver().removeOnPreDrawListener(this.mFirstDrawListener);
        }
        this.mMainListView = view;
        this.mFirstDrawListener = new ViewTreeObserver.OnPreDrawListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.postprocessing.AbsNotesListPostProcess.1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                MainLogger.m7254d(AbsNotesListPostProcess.this.getTag(), "executeOnPreDraw# onPreDraw");
                AppLaunchLog.LogParam logParam2 = logParam;
                if (logParam2 != null) {
                    AppLaunchLog.m8604d(logParam2);
                }
                view.getViewTreeObserver().removeOnPreDrawListener(this);
                AbsNotesListPostProcess absNotesListPostProcess = AbsNotesListPostProcess.this;
                absNotesListPostProcess.mFirstDrawListener = null;
                absNotesListPostProcess.mMainListView = null;
                absNotesListPostProcess.executeLogicsPostDelay(j);
                return true;
            }
        };
        this.mMainListView.getViewTreeObserver().addOnPreDrawListener(this.mFirstDrawListener);
    }

    public abstract String getTag();

    public boolean inactivate(boolean z) {
        boolean z2;
        if (z) {
            this.mRunnable = null;
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.mHandler = null;
        }
        if (this.mFirstDrawListener != null) {
            View view = this.mMainListView;
            if (view != null) {
                view.getViewTreeObserver().removeOnPreDrawListener(this.mFirstDrawListener);
            }
            this.mFirstDrawListener = null;
            z2 = true;
        } else {
            z2 = false;
        }
        this.mMainListView = null;
        return z2;
    }
}
