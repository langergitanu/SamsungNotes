package com.vladsch.flexmark.util.format.options;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public enum ElementPlacement {
    AS_IS,
    DOCUMENT_TOP,
    GROUP_WITH_FIRST,
    GROUP_WITH_LAST,
    DOCUMENT_BOTTOM;

    public boolean isBottom() {
        return this == DOCUMENT_BOTTOM;
    }

    public boolean isChange() {
        return this != AS_IS;
    }

    public boolean isGroupFirst() {
        return this == GROUP_WITH_FIRST;
    }

    public boolean isGroupLast() {
        return this == GROUP_WITH_LAST;
    }

    public boolean isNoChange() {
        return this == AS_IS;
    }

    public boolean isTop() {
        return this == DOCUMENT_TOP;
    }
}
