package com.samsung.android.support.senl.p148nt.model.collector.common;

import com.samsung.android.support.senl.p148nt.model.collector.common.ICollectResult;
import com.samsung.android.support.senl.p148nt.model.collector.repository.ICollectRepository;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class CollectResult implements ICollectResult {
    private ICollectRepository mRepository;
    private int mResult = ICollectResult.Result.FINISHED.getValue();

    public CollectResult(int i, ICollectRepository iCollectRepository) {
        setResult(i);
        setRepository(iCollectRepository);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.common.ICollectResult
    public ICollectRepository getRepository() {
        return this.mRepository;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.common.ICollectResult
    public int getResult() {
        return this.mResult;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.common.ICollectResult
    public void setRepository(ICollectRepository iCollectRepository) {
        this.mRepository = iCollectRepository;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.common.ICollectResult
    public void setResult(int i) {
        this.mResult = i;
    }
}
