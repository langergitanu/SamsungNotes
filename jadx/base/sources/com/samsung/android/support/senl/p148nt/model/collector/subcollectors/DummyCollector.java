package com.samsung.android.support.senl.p148nt.model.collector.subcollectors;

import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.model.collector.common.CollectInfo;
import com.samsung.android.support.senl.p148nt.model.collector.repository.ICollectRepository;
import com.samsung.android.support.senl.p148nt.model.common.log.CollectLogger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class DummyCollector extends AbsCollector implements ICollector {
    private static final String TAG = CollectLogger.createTag("DummyCollector");

    public DummyCollector(ICollectStateListener iCollectStateListener) {
        super(iCollectStateListener);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.subcollectors.AbsCollector, com.samsung.android.support.senl.p148nt.model.collector.subcollectors.ICollector
    public boolean collect(CollectInfo collectInfo, ICollectRepository iCollectRepository) {
        DataLogger.m12302d(TAG, "collect");
        return collectNext(collectInfo, iCollectRepository);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.subcollectors.AbsCollector, com.samsung.android.support.senl.p148nt.model.collector.subcollectors.ICollector
    public boolean fail(CollectInfo collectInfo, ICollectRepository iCollectRepository) {
        return failNext(collectInfo, iCollectRepository);
    }
}
