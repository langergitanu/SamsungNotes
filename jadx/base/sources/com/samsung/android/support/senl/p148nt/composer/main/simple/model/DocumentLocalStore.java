package com.samsung.android.support.senl.p148nt.composer.main.simple.model;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.samsung.android.sdk.pen.document.SpenUnsupportedTypeException;
import com.samsung.android.sdk.pen.document.SpenUnsupportedVersionException;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.base.common.sync.ITempServerNoteListener;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSyncManager;
import com.samsung.android.support.senl.p148nt.base.common.sync.TemporalServerNoteInfo;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.service.OpenParam;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.simple.common.SimpleComposerConstant;
import com.samsung.android.support.senl.p148nt.composer.main.simple.model.DocumentLoadContract;
import com.samsung.android.support.senl.p148nt.model.documents.file.DocumentFileManager;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DocumentLocalStore implements DocumentLoadContract.IDataStore {
    private static final String TAG = Logger.createTag("DocumentLocalStore", SimpleComposerConstant.TAG_PREFIX);
    private DocumentLoadContract.IComposer mComposer;
    private final boolean mIsNeededDownload;
    private DocumentLoadContract.LoadListener mLoadListener;
    private Runnable mLoadResult;
    private LoadTask mLoadTask;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final ExecutorService mExecutorService = Executors.newSingleThreadExecutor(new SenlThreadFactory(TAG));

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class LoadTask implements Callable<Void> {
        private final Context mContext;
        private final DocumentLoadContract.LoadListener mLoadNoteListener;
        private final String mLoadPath;
        private final int mPageWidth;

        public LoadTask(Context context, String str, int i, DocumentLoadContract.LoadListener loadListener) {
            this.mContext = context;
            this.mLoadPath = str;
            this.mPageWidth = i;
            this.mLoadNoteListener = loadListener;
        }

        @Override // java.util.concurrent.Callable
        public Void call() {
            Logger.m11003i(DocumentLocalStore.TAG, "LoadTask#start");
            try {
                this.mLoadNoteListener.onLoadNoteCompleted(DocumentFileManager.getInstance().open(this.mContext, this.mLoadPath, this.mPageWidth, 1000, false, false, false), this.mLoadPath);
            } catch (SpenUnsupportedTypeException | SpenUnsupportedVersionException | IOException e) {
                Logger.m11001e(DocumentLocalStore.TAG, "load# fail ", e);
                this.mLoadNoteListener.onLoadNoteFailed(e);
            }
            Logger.m11003i(DocumentLocalStore.TAG, "LoadTask#end");
            return null;
        }
    }

    public DocumentLocalStore(boolean z) {
        this.mIsNeededDownload = z;
    }

    private void requestDownloadServerNote(OpenParam openParam) {
        final TemporalServerNoteInfo temporalServerNoteInfo = new TemporalServerNoteInfo();
        temporalServerNoteInfo.setFullFolderPath(openParam.getDocPath());
        temporalServerNoteInfo.setDocUuid(openParam.getUuid());
        temporalServerNoteInfo.setTempServerNoteListener(new ITempServerNoteListener() { // from class: com.samsung.android.support.senl.nt.composer.main.simple.model.DocumentLocalStore.2
            @Override // com.samsung.android.support.senl.p148nt.base.common.sync.ITempServerNoteListener
            public void onFailed(int i) {
                AbstractC0000a.m3D(i, "requestDownloadServerNote#onFailed# ", DocumentLocalStore.TAG);
                DocumentLocalStore.this.mHandler.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.simple.model.DocumentLocalStore.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ToastHandler.show(DocumentLocalStore.this.mComposer.getActivity(), C9086R.string.composer_save_to_device_fail, 0);
                    }
                });
            }

            @Override // com.samsung.android.support.senl.p148nt.base.common.sync.ITempServerNoteListener
            public void onReceived() {
                Logger.m10999d(DocumentLocalStore.TAG, "requestDownloadServerNote#onReceived#");
                DocumentLocalStore.this.mExecutorService.submit(DocumentLocalStore.this.mLoadTask);
                temporalServerNoteInfo.setTempServerNoteListener(null);
            }
        });
        RequestToSyncManager.INSTANCE.getInstance().requestSyncDownForServerNoteTemporarily(temporalServerNoteInfo);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.simple.model.DocumentLoadContract.IDataStore
    public void loadDocument(DocumentLoadContract.IComposer iComposer, OpenParam openParam) {
        this.mComposer = iComposer;
        LoadTask loadTask = new LoadTask(iComposer.getActivity(), openParam.getDocPath(), openParam.getPageWidth(), new DocumentLoadContract.LoadListener() { // from class: com.samsung.android.support.senl.nt.composer.main.simple.model.DocumentLocalStore.1
            @Override // com.samsung.android.support.senl.nt.composer.main.simple.model.DocumentLoadContract.LoadListener
            public void onLoadNoteCompleted(final SpenWNote spenWNote, final String str) {
                if (DocumentLocalStore.this.mLoadListener == null) {
                    return;
                }
                DocumentLocalStore.this.mLoadResult = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.simple.model.DocumentLocalStore.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DocumentLocalStore.this.mLoadListener.onLoadNoteCompleted(spenWNote, str);
                        DocumentLocalStore.this.mLoadResult = null;
                    }
                };
                DocumentLocalStore.this.mHandler.post(DocumentLocalStore.this.mLoadResult);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.simple.model.DocumentLoadContract.LoadListener
            public void onLoadNoteFailed(final Throwable th) {
                if (DocumentLocalStore.this.mLoadListener == null) {
                    return;
                }
                DocumentLocalStore.this.mLoadResult = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.simple.model.DocumentLocalStore.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        DocumentLocalStore.this.mLoadListener.onLoadNoteFailed(th);
                        DocumentLocalStore.this.mLoadResult = null;
                    }
                };
                DocumentLocalStore.this.mHandler.post(DocumentLocalStore.this.mLoadResult);
            }
        });
        this.mLoadTask = loadTask;
        if (this.mIsNeededDownload) {
            requestDownloadServerNote(openParam);
        } else {
            this.mExecutorService.submit(loadTask);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.simple.model.DocumentLoadContract.IDataStore
    public void onDestroyed() {
        this.mExecutorService.shutdownNow();
        Runnable runnable = this.mLoadResult;
        if (runnable != null) {
            this.mHandler.removeCallbacks(runnable);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.simple.model.DocumentLoadContract.IDataStore
    public void setLoadListener(DocumentLoadContract.LoadListener loadListener) {
        this.mLoadListener = loadListener;
    }
}
