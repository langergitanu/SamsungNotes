package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option;

import android.content.Context;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.composer.main.base.appwidget.AppWidgetResolverConstructor;
import com.samsung.android.support.senl.p148nt.composer.main.base.appwidget.IAppWidgetCacheInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.appwidget.IAppWidgetResolver;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.model.documents.spen.SpenWordDocument;
import com.samsung.android.support.senl.p148nt.model.repository.data.NotesDocument;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AppWidgetThumbnailTask implements Runnable {
    static final int STATE_END = 2;
    static final int STATE_INIT = 0;
    static final int STATE_START = 1;
    private static final String TAG = Logger.createTag("AppWidgetThumbnailTask");
    private final IAppWidgetResolver mAppWidgetResolver;
    private Context mContext;
    private NotesDocument<SpenWordDocument> mDocState;
    private long mLastModifiedTime;
    private int mState = 0;
    private IAppWidgetCacheInfo mWidgetCacheInfo;

    public AppWidgetThumbnailTask(Context context, IAppWidgetResolver iAppWidgetResolver, NotesDocument<SpenWordDocument> notesDocument, IAppWidgetCacheInfo iAppWidgetCacheInfo, long j) {
        this.mContext = context;
        this.mAppWidgetResolver = iAppWidgetResolver;
        this.mDocState = notesDocument;
        this.mWidgetCacheInfo = iAppWidgetCacheInfo;
        this.mLastModifiedTime = j;
    }

    public static AppWidgetThumbnailTask makeTask(Context context, ComposerModel composerModel, AppWidgetThumbnailTask appWidgetThumbnailTask) {
        Exception exc;
        NotesDocument<SpenWordDocument> docState;
        IAppWidgetResolver appWidgetResolver;
        AppWidgetThumbnailTask appWidgetThumbnailTask2 = null;
        try {
            docState = composerModel.getDocState();
        } catch (Exception e) {
            exc = e;
        }
        if (docState != null && (appWidgetResolver = AppWidgetResolverConstructor.getAppWidgetResolver()) != null && appWidgetResolver.hasWidget(context, docState.getUuid())) {
            Logger.m10999d(TAG, "makeTask#");
            long lastModifiedAt = docState.getDocumentEntityContainer().getEntity().getLastModifiedAt();
            if (appWidgetThumbnailTask != null && !appWidgetThumbnailTask.isDone() && appWidgetThumbnailTask.getLastModifiedTime() >= lastModifiedAt) {
                return null;
            }
            String uuid = docState.getUuid();
            appWidgetResolver.removeCacheInfo(context, uuid);
            AppWidgetThumbnailTask appWidgetThumbnailTask3 = new AppWidgetThumbnailTask(context.getApplicationContext(), appWidgetResolver, docState, appWidgetResolver.createCacheInfo(context, uuid, docState.getPath()), lastModifiedAt);
            try {
                if (docState.getScheduler() == null) {
                    return appWidgetThumbnailTask3;
                }
                docState.getScheduler().getExecutorService().execute(appWidgetThumbnailTask3);
                return appWidgetThumbnailTask3;
            } catch (Exception e2) {
                exc = e2;
                appWidgetThumbnailTask2 = appWidgetThumbnailTask3;
            }
            Logger.m11000e(TAG, exc.getMessage());
            return appWidgetThumbnailTask2;
        }
        return null;
    }

    public long getLastModifiedTime() {
        return this.mLastModifiedTime;
    }

    public boolean isDone() {
        return this.mState == 2;
    }

    public boolean isWidgetUpdate(ComposerModel composerModel) {
        return isDone() || getLastModifiedTime() < composerModel.getNotesDocEntityManager().getLastModifiedTime();
    }

    public void release() {
        this.mContext = null;
        this.mDocState = null;
        this.mWidgetCacheInfo = null;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.mState = 1;
        String strValueOf = String.valueOf(hashCode());
        String str = TAG;
        Logger.startTime(strValueOf, str, "capture start");
        long lastModifiedAt = this.mDocState.getDocumentEntityContainer().getEntity().getLastModifiedAt();
        this.mLastModifiedTime = lastModifiedAt;
        this.mWidgetCacheInfo.setDocLastModifiedTime(lastModifiedAt);
        this.mAppWidgetResolver.createThumbnail(this.mContext, this.mDocState.getUuid(), this.mDocState.getPath(), this.mWidgetCacheInfo, (SpenWNote) this.mDocState.getDoc());
        release();
        Logger.endTime(String.valueOf(hashCode()), str, "capture end");
        this.mState = 2;
    }
}
