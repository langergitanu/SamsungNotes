package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.common;

import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class BackgroundTaskManager {
    private static final String TAG = Logger.createTag("CpV$BackgroundTaskManager");
    private ExecutorService mExecutorService;
    private CpVTask mLastTask;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class CpVTask implements Runnable {
        private boolean mRunningState;

        public abstract void cancel();

        public abstract void doInBackground();

        public boolean isRunning() {
            return this.mRunningState;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Logger.m10999d(BackgroundTaskManager.TAG, "Task# start");
            this.mRunningState = true;
            doInBackground();
            this.mRunningState = false;
            Logger.m10999d(BackgroundTaskManager.TAG, "Task# end");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class PageManagerInitializationTask extends CpVTask {
        SpenWNote mNote;
        PageManager mPageManager;

        public PageManagerInitializationTask(SpenWNote spenWNote, PageManager pageManager) {
            this.mNote = spenWNote;
            this.mPageManager = pageManager;
            pageManager.init(spenWNote.getPageCount(), spenWNote.getPageMode(), true);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.common.BackgroundTaskManager.CpVTask
        public void cancel() {
            this.mPageManager.setDestroyFlag();
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.common.BackgroundTaskManager.CpVTask
        public void doInBackground() {
            this.mPageManager.initPageInfoList(this.mNote);
        }
    }

    public ExecutorService getExecutorService() {
        if (this.mExecutorService == null) {
            this.mExecutorService = Executors.newSingleThreadExecutor(new SenlThreadFactory(TAG));
        }
        return this.mExecutorService;
    }

    public boolean isRunningPageInfoInitTask() {
        CpVTask cpVTask = this.mLastTask;
        return cpVTask != null && cpVTask.isRunning() && (this.mLastTask instanceof PageManagerInitializationTask);
    }

    public void startPageManagerInitTask(SpenWNote spenWNote, PageManager pageManager) {
        if (pageManager.getPageList() == null || pageManager.getPageList().isEmpty()) {
            this.mLastTask = new PageManagerInitializationTask(spenWNote, pageManager);
            getExecutorService().execute(this.mLastTask);
        }
    }

    public void stop() {
        CpVTask cpVTask = this.mLastTask;
        if (cpVTask == null || !cpVTask.isRunning()) {
            return;
        }
        this.mLastTask.cancel();
        getExecutorService().shutdownNow();
        try {
            String str = TAG;
            Logger.m10999d(str, "release# wait thread");
            this.mExecutorService.awaitTermination(1000L, TimeUnit.MILLISECONDS);
            Logger.m10999d(str, "release# wait thread done");
        } catch (InterruptedException e) {
            Logger.m11000e(TAG, e.getMessage());
        }
    }
}
