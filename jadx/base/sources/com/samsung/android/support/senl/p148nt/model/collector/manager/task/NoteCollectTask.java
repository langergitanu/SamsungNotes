package com.samsung.android.support.senl.p148nt.model.collector.manager.task;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.model.collector.common.CollectInfo;
import com.samsung.android.support.senl.p148nt.model.collector.common.CollectParam;
import com.samsung.android.support.senl.p148nt.model.collector.common.ICollectParam;
import com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor.ExceptionFileManager;
import com.samsung.android.support.senl.p148nt.model.collector.repository.CollectRepository;
import com.samsung.android.support.senl.p148nt.model.collector.subcollectors.AbsCollector;
import com.samsung.android.support.senl.p148nt.model.collector.subcollectors.CollectorClassConverter;
import com.samsung.android.support.senl.p148nt.model.collector.subcollectors.DummyCollector;
import com.samsung.android.support.senl.p148nt.model.collector.subcollectors.ICollectStateListener;
import com.samsung.android.support.senl.p148nt.model.collector.subcollectors.ICollector;
import com.samsung.android.support.senl.p148nt.model.common.log.CollectLogger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class NoteCollectTask extends AbsCollectTask implements Comparable<NoteCollectTask> {
    private static final String TAG = CollectLogger.createTag("NoteCollectTask");

    public NoteCollectTask(@NonNull CollectParam collectParam, @NonNull ICollectStateListener iCollectStateListener) {
        super(collectParam, CollectInfo.TaskType.NOTE, iCollectStateListener);
    }

    private int getLinkWith() {
        return this.mCollectInfo.getNoteType() == CollectInfo.NoteType.W_NOTE ? this.mCollectParam.getLinkWith() : ICollectParam.LinkWith.LEGACY_NOTES.getValue();
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof NoteCollectTask) && compareTo((NoteCollectTask) obj) == 0;
    }

    public int hashCode() {
        return super.hashCode();
    }

    @Override // java.lang.Runnable
    public void run() {
        Context applicationContext = BaseUtils.getApplicationContext();
        String uuid = getUuid();
        if (ExceptionFileManager.isExistInExceptList(applicationContext, uuid)) {
            DataLogger.m12302d(TAG, "run, failed, exist in ExceptList");
            progressFail();
            return;
        }
        ExceptionFileManager.addFileInWorkingList(applicationContext, uuid);
        this.mCollectInfo.createDocument();
        if (!this.mCollectInfo.isValid()) {
            DataLogger.m12302d(TAG, "run, failed, not valid");
            progressFail();
            return;
        }
        this.mCollectStateListener.onCollectStarted(this.mCollectInfo, this.mCollectParam.getInReadyState());
        if (this.mCanceled.get()) {
            DataLogger.m12302d(TAG, "run, canceled");
            ExceptionFileManager.removeFileInWorkingList(applicationContext, uuid);
            progressFail();
            return;
        }
        this.mCollector = new DummyCollector(this.mCollectStateListener);
        int linkWith = getLinkWith();
        try {
            try {
                ICollector iCollectorLinkWith = this.mCollector;
                for (int value = ICollectParam.LinkWith.TEXT_SEARCH.getValue(); value <= ICollectParam.LinkWith.DEFAULT.getValue(); value <<= 1) {
                    if (value != ICollectParam.LinkWith.PDF_SEARCH.getValue() && value == (linkWith & value)) {
                        iCollectorLinkWith = iCollectorLinkWith.linkWith((AbsCollector) CollectorClassConverter.convertToClass(value).getConstructor(ICollectStateListener.class).newInstance(this.mCollectStateListener));
                    }
                }
                this.mCollector.collect(this.mCollectInfo, new CollectRepository());
            } catch (Exception e) {
                DataLogger.m12303e(TAG, "run, exception " + e.getMessage());
                progressFail();
            }
            ExceptionFileManager.removeFileInWorkingList(applicationContext, uuid);
        } catch (Throwable th) {
            ExceptionFileManager.removeFileInWorkingList(applicationContext, uuid);
            throw th;
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(NoteCollectTask noteCollectTask) {
        return Integer.compare(noteCollectTask.getCollectParam().getPriority(), this.mCollectParam.getPriority());
    }
}
