package com.vladsch.flexmark.util.format.options;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public enum ElementPlacementSort {
    AS_IS,
    SORT,
    SORT_UNUSED_LAST,
    SORT_DELETE_UNUSED,
    DELETE_UNUSED;

    public boolean isDeleteUnused() {
        return this == SORT_DELETE_UNUSED || this == DELETE_UNUSED;
    }

    public boolean isSort() {
        return this == SORT_UNUSED_LAST || this == SORT_DELETE_UNUSED || this == SORT;
    }

    public boolean isUnused() {
        return this == SORT_UNUSED_LAST || this == SORT_DELETE_UNUSED || this == DELETE_UNUSED;
    }
}
