package com.samsung.android.support.senl.p148nt.app.lock.view.base;

import android.os.SystemClock;
import androidx.fragment.app.Fragment;
import com.samsung.android.support.senl.p145cm.base.framework.desktopmode.DesktopModeCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.app.lock.presenter.base.IBaseContract;
import com.samsung.android.support.senl.p148nt.app.lock.utils.LockLogger;
import com.samsung.android.support.senl.p148nt.base.common.util.LockPrefUtils;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbsBaseView extends Fragment implements IBaseContract.IView {
    private static final String TAG = LockLogger.createTag("AbsBaseView");
    protected boolean mIsFinishing = false;
    private ViewStateListener mStateListener;

    @Override // com.samsung.android.support.senl.nt.app.lock.presenter.base.IBaseContract.IView
    public void changeScenario(int i) {
        ViewStateListener viewStateListener = this.mStateListener;
        if (viewStateListener != null) {
            viewStateListener.onScenarioChange(i);
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.lock.presenter.base.IBaseContract.IView
    public void changeViewTo(int i, int i2) {
        ViewStateListener viewStateListener = this.mStateListener;
        if (viewStateListener != null) {
            viewStateListener.onViewChange(i, i2);
        }
    }

    public void exitMultiWindow() {
        if (getActivity() != null) {
            WindowManagerCompat.getInstance().exitMultiWindow(getActivity());
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.lock.presenter.base.IBaseContract.IView
    public void finishCancel() {
        this.mIsFinishing = true;
        ViewStateListener viewStateListener = this.mStateListener;
        if (viewStateListener != null) {
            viewStateListener.onFinishCancel();
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.lock.presenter.base.IBaseContract.IView
    public void finishSuccess() {
        ViewStateListener viewStateListener = this.mStateListener;
        if (viewStateListener != null) {
            viewStateListener.onFinishSuccess();
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.lock.presenter.base.IBaseContract.IView
    public long getSavedPasswordBlockingTime() {
        long blockEndTime = LockPrefUtils.getBlockEndTime(getContext()) - SystemClock.elapsedRealtime();
        LockLogger.m7356d(TAG, "blocking time : " + blockEndTime);
        long millis = TimeUnit.SECONDS.toMillis(30L);
        if (blockEndTime >= 0 && blockEndTime <= millis) {
            return blockEndTime;
        }
        LockPrefUtils.setBlockEndTime(getContext(), 0L);
        return 0L;
    }

    public boolean isBlockedByMultiwindow() {
        if (getActivity() == null || DesktopModeCompat.INSTANCE.getInstance().isDexMode(getContext())) {
            return false;
        }
        return WindowManagerCompat.getInstance().isMultiWindowMode(getActivity());
    }

    public void onWindowFocusChanged(boolean z) {
    }

    @Override // com.samsung.android.support.senl.nt.app.lock.presenter.base.IBaseContract.IView
    public void resetPasswordBlockingEndTime() {
        if (getContext() != null) {
            LockPrefUtils.setBlockEndTime(getContext(), 0L);
        }
    }

    public void setOnFinishCallback(ViewStateListener viewStateListener) {
        this.mStateListener = viewStateListener;
    }
}
