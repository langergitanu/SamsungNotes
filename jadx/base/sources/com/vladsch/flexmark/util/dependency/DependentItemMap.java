package com.vladsch.flexmark.util.dependency;

import com.vladsch.flexmark.util.collection.CollectionHost;
import com.vladsch.flexmark.util.collection.OrderedMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class DependentItemMap<D> extends OrderedMap<Class<?>, DependentItem<D>> {
    public DependentItemMap() {
    }

    public DependentItemMap(int i) {
        super(i);
    }

    public DependentItemMap(CollectionHost<Class<?>> collectionHost) {
        super(collectionHost);
    }

    public DependentItemMap(int i, CollectionHost<Class<?>> collectionHost) {
        super(i, collectionHost);
    }
}
