package com.vladsch.flexmark.util.collection;

import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface IndexedItemSetMap<M, S, K> extends Map<M, S> {
    boolean addItem(@NotNull K k, int i);

    boolean addSetItem(@NotNull S s, int i);

    boolean containsItem(@NotNull K k, int i);

    boolean containsSetItem(@NotNull S s, int i);

    @NotNull
    M mapKey(@NotNull K k);

    @NotNull
    S newSet();

    boolean removeItem(@NotNull K k, int i);

    boolean removeSetItem(@NotNull S s, int i);
}
