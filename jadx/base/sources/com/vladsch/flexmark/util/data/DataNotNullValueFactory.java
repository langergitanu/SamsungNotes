package com.vladsch.flexmark.util.data;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface DataNotNullValueFactory<T> extends DataValueFactory<T> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.vladsch.flexmark.util.data.DataValueFactory, java.util.function.Function
    @NotNull
    T apply(@NotNull DataHolder dataHolder);
}
