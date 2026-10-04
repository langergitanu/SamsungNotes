package com.opencsv.bean;

import com.opencsv.bean.MappingStrategy;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractMappingStrategyBuilder<S, T extends MappingStrategy<S>> {
    protected Class<? extends S> type;

    public abstract T build();

    public AbstractMappingStrategyBuilder<S, T> withType(Class<? extends S> cls) {
        this.type = cls;
        return this;
    }
}
