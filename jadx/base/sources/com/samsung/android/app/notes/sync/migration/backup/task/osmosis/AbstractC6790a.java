package com.samsung.android.app.notes.sync.migration.backup.task.osmosis;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.migration.backup.task.osmosis.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract /* synthetic */ class AbstractC6790a {

    /* JADX INFO: renamed from: a */
    public static final /* synthetic */ int[] f4194a;

    static {
        int[] iArr = new int[OSmosisBackupTask$State.values().length];
        try {
            iArr[OSmosisBackupTask$State.NOTES_TRANSFERRING.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr[OSmosisBackupTask$State.ATTACHMENT_TRANSFERRING.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        f4194a = iArr;
    }
}
