package com.vladsch.flexmark.util.format;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public enum Sort {
    NONE,
    ASCENDING,
    DESCENDING,
    ASCENDING_NUMERIC,
    DESCENDING_NUMERIC,
    ASCENDING_NUMERIC_LAST,
    DESCENDING_NUMERIC_LAST;

    public boolean isDescending() {
        return this == DESCENDING || this == DESCENDING_NUMERIC || this == DESCENDING_NUMERIC_LAST;
    }

    public boolean isNumeric() {
        return this == ASCENDING_NUMERIC || this == ASCENDING_NUMERIC_LAST || this == DESCENDING_NUMERIC || this == DESCENDING_NUMERIC_LAST;
    }

    public boolean isNumericLast() {
        return this == ASCENDING_NUMERIC_LAST || this == DESCENDING_NUMERIC_LAST;
    }
}
