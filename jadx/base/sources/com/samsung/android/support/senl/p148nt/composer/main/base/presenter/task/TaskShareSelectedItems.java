package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task;

import android.content.Context;
import android.content.Intent;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.base.composer.share.ShareCallbackReceiver;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.PdfManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.share.ShareException;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.share.ShareSelectedItems;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.share.ShareToOtherAppHandler;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TaskShareSelectedItems extends SingleThreadTask<InputValues, ResultValues> {
    private static final String TAG = Logger.createTag("TaskShareSelectedItems");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class InputValues implements Task.InputValues {
        private Context mContext;
        private ObjectManager mObjectManager;
        private PdfManager mPdfManager;

        public InputValues(Context context, ObjectManager objectManager, PdfManager pdfManager) {
            this.mContext = context;
            this.mObjectManager = objectManager;
            this.mPdfManager = pdfManager;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ResultValues implements Task.ResultValues {
        private Runnable mPostAction;

        public ResultValues(Runnable runnable) {
            this.mPostAction = runnable;
        }

        public Runnable getPostAction() {
            return this.mPostAction;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public boolean isAvailableToReload() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void executeTask(final InputValues inputValues) {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new SenlThreadFactory(TAG));
        this.mExecutorService = executorServiceNewSingleThreadExecutor;
        executorServiceNewSingleThreadExecutor.submit(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskShareSelectedItems.1
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                final Intent intentCreateIntentToShare;
                ResultValues resultValues;
                boolean z = false;
                ResultValues resultValues2 = null;
                try {
                    try {
                        final ShareToOtherAppHandler shareToOtherAppHandler = new ShareToOtherAppHandler();
                        intentCreateIntentToShare = new ShareSelectedItems(shareToOtherAppHandler).createIntentToShare(inputValues.mContext, inputValues.mObjectManager, inputValues.mPdfManager, inputValues.mObjectManager.getSelectedSafeObjectList(), ShareCallbackReceiver.ShareCaller.ComposerContextMenu);
                        resultValues = new ResultValues(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskShareSelectedItems.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                shareToOtherAppHandler.startChooserActivity(inputValues.mContext, intentCreateIntentToShare, 2);
                            }
                        });
                        z = true;
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        Logger.m11003i(TaskShareSelectedItems.TAG, "executeTask done#true" + intentCreateIntentToShare);
                        TaskShareSelectedItems.this.notifyCallback(true, resultValues);
                    } catch (ShareException e) {
                        e = e;
                        resultValues2 = resultValues;
                        Logger.m10999d(TaskShareSelectedItems.TAG, "ComposerException, e : " + e.getMessage());
                        TaskShareSelectedItems.this.notifyCallback(z, resultValues2);
                    } catch (Exception e2) {
                        e = e2;
                        resultValues2 = resultValues;
                        Logger.m11001e(TaskShareSelectedItems.TAG, "Exception#" + e.getMessage(), e);
                        TaskShareSelectedItems.this.notifyCallback(z, resultValues2);
                    } catch (Throwable th2) {
                        th = th2;
                        resultValues2 = resultValues;
                        TaskShareSelectedItems.this.notifyCallback(z, resultValues2);
                        throw th;
                    }
                } catch (ShareException e3) {
                    e = e3;
                } catch (Exception e5) {
                    e = e5;
                }
            }
        });
    }
}
