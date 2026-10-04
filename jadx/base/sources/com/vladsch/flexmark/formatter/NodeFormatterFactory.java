package com.vladsch.flexmark.formatter;

import com.vladsch.flexmark.util.data.DataHolder;
import com.vladsch.flexmark.util.dependency.Dependent;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface NodeFormatterFactory extends Dependent {
    @Override // com.vladsch.flexmark.util.dependency.Dependent
    default boolean affectsGlobalScope() {
        return false;
    }

    @NotNull
    NodeFormatter create(@NotNull DataHolder dataHolder);

    @Override // com.vladsch.flexmark.util.dependency.Dependent
    @Nullable
    default Set<Class<?>> getAfterDependents() {
        return null;
    }

    @Override // com.vladsch.flexmark.util.dependency.Dependent
    @Nullable
    default Set<Class<?>> getBeforeDependents() {
        return null;
    }
}
