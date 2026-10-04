package com.vladsch.flexmark.util.data;

import java.util.function.Function;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface DataValueFactory<T> extends Function<DataHolder, T> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.function.Function
    @Nullable
    T apply(@NotNull DataHolder dataHolder);
}
