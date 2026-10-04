package com.samsung.android.support.senl.p148nt.model.collector.subcollectors;

import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.support.senl.p148nt.model.collector.common.CollectInfo;
import com.samsung.android.support.senl.p148nt.model.collector.repository.ICollectRepository;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface ICollector {
    boolean cancel();

    boolean cancelNext();

    boolean collect(CollectInfo collectInfo, ICollectRepository iCollectRepository);

    boolean collectNext(CollectInfo collectInfo, ICollectRepository iCollectRepository);

    boolean fail(CollectInfo collectInfo, ICollectRepository iCollectRepository);

    boolean failNext(CollectInfo collectInfo, ICollectRepository iCollectRepository);

    boolean hasSearchSkippedText(SpenObjectBase spenObjectBase);

    boolean isAvailable(CollectInfo collectInfo);

    boolean isCanceled();

    boolean isSupported();

    ICollector linkWith(ICollector iCollector);

    void postCollect(CollectInfo collectInfo, ICollectRepository iCollectRepository);

    void preCollect(CollectInfo collectInfo, ICollectRepository iCollectRepository);
}
