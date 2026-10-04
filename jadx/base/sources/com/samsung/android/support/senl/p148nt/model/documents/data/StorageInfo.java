package com.samsung.android.support.senl.p148nt.model.documents.data;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class StorageInfo {
    private static final long UNIT_GB = 1073741824;
    private static final long UNIT_KB = 1024;
    private static final long UNIT_MB = 1048576;
    private static final int UNIT_SHIFT = 10;
    private final Unit mUnit;
    private final long mValue;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum Unit {
        B,
        kB,
        MB,
        GB
    }

    public StorageInfo(long j) {
        if (j > 1073741824) {
            this.mValue = j / 1073741824;
            this.mUnit = Unit.GB;
        } else if (j > 1048576) {
            this.mValue = j / 1048576;
            this.mUnit = Unit.MB;
        } else if (j > 1024) {
            this.mValue = j / 1024;
            this.mUnit = Unit.kB;
        } else {
            this.mValue = j;
            this.mUnit = Unit.B;
        }
    }

    public String getUnit() {
        return this.mUnit.equals(Unit.B) ? "byte" : this.mUnit.name();
    }

    public long getValue() {
        return this.mValue;
    }
}
