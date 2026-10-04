package com.samsung.android.support.senl.p148nt.model.collector.manager.task;

import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.model.collector.common.CollectInfo;
import com.samsung.android.support.senl.p148nt.model.collector.common.CollectParam;
import com.samsung.android.support.senl.p148nt.model.collector.common.ICollectParam;
import com.samsung.android.support.senl.p148nt.model.collector.repository.CollectRepository;
import com.samsung.android.support.senl.p148nt.model.collector.subcollectors.AbsCollector;
import com.samsung.android.support.senl.p148nt.model.collector.subcollectors.CollectorClassConverter;
import com.samsung.android.support.senl.p148nt.model.collector.subcollectors.DummyCollector;
import com.samsung.android.support.senl.p148nt.model.collector.subcollectors.ICollectStateListener;
import com.samsung.android.support.senl.p148nt.model.collector.subcollectors.ICollector;
import com.samsung.android.support.senl.p148nt.model.common.log.CollectLogger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class PdfCollectTask extends AbsCollectTask implements Comparable<PdfCollectTask> {
    private static final String TAG = CollectLogger.createTag("PdfCollectTask");

    public PdfCollectTask(@NonNull CollectParam collectParam, @NonNull ICollectStateListener iCollectStateListener) {
        super(collectParam, CollectInfo.TaskType.PDF, iCollectStateListener);
    }

    @Override // java.lang.Comparable
    public int compareTo(PdfCollectTask pdfCollectTask) {
        return 0;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.mCollectInfo.createDocument();
        if (!this.mCollectInfo.isValid()) {
            DataLogger.m12302d(TAG, "run, failed");
            progressFail();
            return;
        }
        this.mCollectStateListener.onCollectStarted(this.mCollectInfo, false);
        if (this.mCanceled.get()) {
            DataLogger.m12302d(TAG, "run, canceled");
            progressFail();
            return;
        }
        this.mCollector = new DummyCollector(this.mCollectStateListener);
        try {
            ICollector iCollectorLinkWith = this.mCollector.linkWith((AbsCollector) CollectorClassConverter.convertToClass(ICollectParam.LinkWith.PDF_SEARCH.getValue()).getConstructor(ICollectStateListener.class).newInstance(this.mCollectStateListener));
            this.mCollector = iCollectorLinkWith;
            iCollectorLinkWith.collect(this.mCollectInfo, new CollectRepository());
        } catch (Exception e) {
            AbstractC11014a.m12333r(e, new StringBuilder("run, exception "), TAG);
        }
    }
}
