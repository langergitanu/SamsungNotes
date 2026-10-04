package com.vladsch.flexmark.util.format;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final class ColumnSort {
    public final int column;

    @NotNull
    public final Sort sort;

    private ColumnSort(int i, @NotNull Sort sort) {
        this.column = i;
        this.sort = sort;
    }

    @NotNull
    public static ColumnSort columnSort(int i, @NotNull Sort sort) {
        return new ColumnSort(i, sort);
    }

    @NotNull
    public static ColumnSort columnSort(int i, boolean z, boolean z2, boolean z3) {
        if (!z2) {
            return new ColumnSort(i, z ? Sort.DESCENDING : Sort.ASCENDING);
        }
        if (z3) {
            return new ColumnSort(i, z ? Sort.DESCENDING_NUMERIC_LAST : Sort.ASCENDING_NUMERIC_LAST);
        }
        return new ColumnSort(i, z ? Sort.DESCENDING_NUMERIC : Sort.ASCENDING_NUMERIC);
    }
}
