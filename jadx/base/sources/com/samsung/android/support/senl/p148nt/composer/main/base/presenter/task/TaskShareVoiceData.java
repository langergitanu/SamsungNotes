package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task;

import android.content.Context;
import com.samsung.android.sdk.pen.worddoc.SpenVoiceData;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.share.ShareToOtherAppHandler;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TaskShareVoiceData extends SingleThreadTask<InputValues, ResultValues> {
    private static final String TAG = Logger.createTag("TaskShareVoiceData");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class InputValues implements Task.InputValues {
        private Context mContext;
        private String mDocumentPath;
        private ObjectManager mObjectManager;
        private List<SpenVoiceData> mShareList;

        public InputValues(Context context, ObjectManager objectManager, List<SpenVoiceData> list, String str) {
            ArrayList arrayList = new ArrayList();
            this.mShareList = arrayList;
            this.mContext = context;
            this.mObjectManager = objectManager;
            arrayList.clear();
            this.mShareList.addAll(list);
            this.mDocumentPath = str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ResultValues implements Task.ResultValues {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public boolean isAvailableToReload() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void executeTask(final InputValues inputValues) {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new SenlThreadFactory(TAG));
        this.mExecutorService = executorServiceNewSingleThreadExecutor;
        executorServiceNewSingleThreadExecutor.execute(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskShareVoiceData.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    try {
                        new ShareToOtherAppHandler().shareVoiceData(inputValues.mContext, inputValues.mObjectManager.getNote(), inputValues.mShareList, inputValues.mDocumentPath, 0);
                        TaskShareVoiceData.this.notifyCallback(true, null);
                    } catch (Exception e) {
                        Logger.m11001e(TaskShareVoiceData.TAG, e.getMessage(), e);
                        TaskShareVoiceData.this.notifyCallback(false, null);
                    }
                } catch (Throwable th) {
                    TaskShareVoiceData.this.notifyCallback(false, null);
                    throw th;
                }
            }
        });
    }
}
