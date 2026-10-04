package com.samsung.android.support.senl.p148nt.model.collector.subcollectors;

import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.StorageUtils;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.model.collector.common.CollectInfo;
import com.samsung.android.support.senl.p148nt.model.collector.repository.ICollectRepository;
import com.samsung.android.support.senl.p148nt.model.common.log.CollectLogger;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class AbsCollector implements ICollector {
    private static final String TAG = CollectLogger.createTag("AbsCollector");
    private final AtomicBoolean mCanceled = new AtomicBoolean(false);
    private final ICollectStateListener mCollectStateListener;
    private ICollector mNext;

    public AbsCollector(ICollectStateListener iCollectStateListener) {
        this.mCollectStateListener = iCollectStateListener;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.subcollectors.ICollector
    public boolean cancel() {
        DataLogger.m12302d(TAG, "cancel ".concat(getClass().getSimpleName()));
        this.mCanceled.set(true);
        return cancelNext();
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.subcollectors.ICollector
    public boolean cancelNext() {
        ICollector iCollector = this.mNext;
        if (iCollector == null) {
            return true;
        }
        return iCollector.cancel();
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.subcollectors.ICollector
    public boolean collect(CollectInfo collectInfo, ICollectRepository iCollectRepository) {
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.subcollectors.ICollector
    public boolean collectNext(CollectInfo collectInfo, ICollectRepository iCollectRepository) {
        ICollector iCollector = this.mNext;
        if (iCollector != null) {
            return iCollector.collect(collectInfo, iCollectRepository);
        }
        iCollectRepository.dumpCollectResults(collectInfo.getUuid());
        this.mCollectStateListener.onCollectFinished(collectInfo);
        collectInfo.release();
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.subcollectors.ICollector
    public boolean fail(CollectInfo collectInfo, ICollectRepository iCollectRepository) {
        return failNext(collectInfo, iCollectRepository);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.subcollectors.ICollector
    public boolean failNext(CollectInfo collectInfo, ICollectRepository iCollectRepository) {
        ICollector iCollector = this.mNext;
        if (iCollector == null) {
            return true;
        }
        return iCollector.fail(collectInfo, iCollectRepository);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.subcollectors.ICollector
    public boolean hasSearchSkippedText(SpenObjectBase spenObjectBase) {
        if (spenObjectBase instanceof SpenObjectTextBox) {
            return !((SpenObjectTextBox) spenObjectBase).getTextEditable();
        }
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.subcollectors.ICollector
    public boolean isAvailable(CollectInfo collectInfo) {
        try {
            if (!StorageUtils.isAvailableMemoryForNewMemo()) {
                DataLogger.m12302d(TAG, "isAvailable, not available memory for new note: " + StorageUtils.getAvailableInternalMemorySize());
                return false;
            }
            long length = new File(collectInfo.getNotePath()).length();
            if (StorageUtils.getAvailableInternalMemorySize() > length) {
                return true;
            }
            DataLogger.m12302d(TAG, "isAvailable, not available uncompressedSize: " + length);
            return false;
        } catch (Exception e) {
            AbstractC11014a.m12333r(e, new StringBuilder("isAvailable, exception: "), TAG);
            return true;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.subcollectors.ICollector
    public boolean isCanceled() {
        return this.mCanceled.get();
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.subcollectors.ICollector
    public boolean isSupported() {
        return !DeviceUtils.isPowerManageMode(BaseUtils.getApplicationContext());
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.subcollectors.ICollector
    public ICollector linkWith(ICollector iCollector) {
        this.mNext = iCollector;
        return iCollector;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.subcollectors.ICollector
    public void postCollect(CollectInfo collectInfo, ICollectRepository iCollectRepository) {
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.subcollectors.ICollector
    public void preCollect(CollectInfo collectInfo, ICollectRepository iCollectRepository) {
    }
}
