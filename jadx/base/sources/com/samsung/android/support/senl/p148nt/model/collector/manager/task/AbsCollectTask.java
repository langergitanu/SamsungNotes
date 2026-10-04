package com.samsung.android.support.senl.p148nt.model.collector.manager.task;

import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.model.collector.common.CollectInfo;
import com.samsung.android.support.senl.p148nt.model.collector.common.CollectParam;
import com.samsung.android.support.senl.p148nt.model.collector.common.CollectThreadPoolExecutor;
import com.samsung.android.support.senl.p148nt.model.collector.repository.CollectRepository;
import com.samsung.android.support.senl.p148nt.model.collector.subcollectors.ICollectStateListener;
import com.samsung.android.support.senl.p148nt.model.collector.subcollectors.ICollector;
import com.samsung.android.support.senl.p148nt.model.common.log.CollectLogger;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class AbsCollectTask implements CollectThreadPoolExecutor.CollectTask {
    private static final String TAG = CollectLogger.createTag("AbsCollectTask");
    protected final AtomicBoolean mCanceled = new AtomicBoolean(false);
    protected final CollectInfo mCollectInfo;
    protected final CollectParam mCollectParam;
    protected final ICollectStateListener mCollectStateListener;
    protected ICollector mCollector;

    public AbsCollectTask(@NonNull CollectParam collectParam, CollectInfo.TaskType taskType, @NonNull ICollectStateListener iCollectStateListener) {
        this.mCollectParam = collectParam;
        this.mCollectStateListener = iCollectStateListener;
        this.mCollectInfo = new CollectInfo(collectParam, taskType);
    }

    @Override // com.samsung.android.support.senl.nt.model.collector.common.CollectThreadPoolExecutor.CollectTask
    public void cancel() {
        DataLogger.m12302d(TAG, "cancel");
        this.mCanceled.set(true);
        ICollector iCollector = this.mCollector;
        if (iCollector != null) {
            iCollector.cancel();
        }
    }

    public CollectParam getCollectParam() {
        return this.mCollectParam;
    }

    public long getLastModifiedAt() {
        return this.mCollectInfo.getLastModifiedAt();
    }

    public String getNotePath() {
        return this.mCollectInfo.getNotePath();
    }

    public int getTriggerType() {
        return this.mCollectParam.getTriggerType();
    }

    @Override // com.samsung.android.support.senl.nt.model.collector.common.CollectThreadPoolExecutor.CollectTask
    public String getUuid() {
        return this.mCollectInfo.getUuid();
    }

    public void progressFail() {
        DataLogger.m12302d(TAG, "progressFail");
        ICollector iCollector = this.mCollector;
        if (iCollector != null) {
            iCollector.fail(this.mCollectInfo, new CollectRepository());
        }
        this.mCollectInfo.release();
        this.mCollectStateListener.onCollectFailed(this.mCollectInfo);
    }
}
