package com.samsung.android.support.senl.p148nt.model.collector.common;

import com.samsung.android.support.senl.p148nt.model.collector.repository.ICollectRepository;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface ICollectResult {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum Result {
        FINISHED(0),
        CANCELED(1),
        FAILED(2);

        private final int value;

        Result(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    ICollectRepository getRepository();

    int getResult();

    void setRepository(ICollectRepository iCollectRepository);

    void setResult(int i);
}
