package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub;

import android.app.Activity;
import android.app.ActivityManager;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.MemoryTrimmer;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ComposerMemoryTrimmer extends MemoryTrimmer {
    private static final String TAG = Logger.createTag("ComposerMemoryTrimmer");
    private final ComposerCloser mComposerCloser;
    private final BaseSubManager mSubManager;

    public ComposerMemoryTrimmer(BaseSubManager baseSubManager, ComposerCloser composerCloser) {
        this.mSubManager = baseSubManager;
        this.mComposerCloser = composerCloser;
    }

    private void printMemoryState(Activity activity) {
        if (CommonUtils.isNotAvailableActivity(activity)) {
            return;
        }
        ActivityManager activityManager = (ActivityManager) activity.getSystemService(Constants.StringExtra.EXECUTE_TYPE_ACTIVITY);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        Logger.m11000e(TAG, "total(kb) : " + (memoryInfo.totalMem / 1024) + ", available(kb) : " + (memoryInfo.availMem / 1024) + ", isLow : " + memoryInfo.lowMemory);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.MemoryTrimmer
    public void trimBackgroundMemory() {
        Logger.printMemory(TAG, "trimBackgroundMemory#");
        printMemoryState(this.mSubManager.getComposerLifeState().getActivity());
        this.mSubManager.cancelTaskController();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.MemoryTrimmer
    public void trimCriticalMemory() {
        Logger.printMemory(TAG, "trimCriticalMemory#");
        printMemoryState(this.mSubManager.getComposerLifeState().getActivity());
        this.mComposerCloser.closeComposer(this.mSubManager.getComposerLifeState().getActivity(), null, null);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.MemoryTrimmer
    public void trimRunningMemory() {
        Logger.printMemory(TAG, "trimRunningMemory#");
        if (this.mSubManager.getMenuPresenterManager().getListPresenter() != null) {
            this.mSubManager.getMenuPresenterManager().getListPresenter().getPageListPresenter().trimUnnecessaryResource();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.MemoryTrimmer
    public void trimTaskMemory() {
        Logger.printMemory(TAG, "trimTaskMemory#");
        printMemoryState(this.mSubManager.getComposerLifeState().getActivity());
        this.mSubManager.cancelTaskController();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.MemoryTrimmer
    public void trimUIMemory() {
        boolean zIsResumed = this.mSubManager.getComposerLifeState().getViewState().isResumed();
        AbstractC8014b.m7220v("trimUIMemory# isResumed : ", TAG, zIsResumed);
        if (zIsResumed || this.mSubManager.getMenuPresenterManager().getListPresenter() == null) {
            return;
        }
        this.mSubManager.getMenuPresenterManager().getListPresenter().getPageListPresenter().trimUIResource();
    }
}
