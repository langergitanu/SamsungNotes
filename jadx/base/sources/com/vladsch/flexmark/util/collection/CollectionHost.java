package com.vladsch.flexmark.util.collection;

import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface CollectionHost<K> {
    void adding(int i, @Nullable K k, @Nullable Object obj);

    void addingNulls(int i);

    void clearing();

    int getIteratorModificationCount();

    @Nullable
    Object removing(int i, @Nullable K k);

    boolean skipHostUpdate();
}
