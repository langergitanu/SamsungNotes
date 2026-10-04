package com.samsung.android.app.notes.sync.migration;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.migration.q */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract /* synthetic */ class AbstractC6834q {

    /* JADX INFO: renamed from: a */
    public static final /* synthetic */ int[] f4245a;

    static {
        int[] iArr = new int[MigrationScheduler$State.values().length];
        f4245a = iArr;
        try {
            iArr[MigrationScheduler$State.STOP.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f4245a[MigrationScheduler$State.FINISH.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}
