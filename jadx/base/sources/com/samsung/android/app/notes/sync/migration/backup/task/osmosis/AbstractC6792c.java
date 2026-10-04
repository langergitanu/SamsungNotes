package com.samsung.android.app.notes.sync.migration.backup.task.osmosis;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.migration.backup.task.osmosis.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract /* synthetic */ class AbstractC6792c {

    /* JADX INFO: renamed from: a */
    public static final /* synthetic */ int[] f4203a;

    static {
        int[] iArr = new int[OSmosisIndexingTask$State.values().length];
        try {
            iArr[OSmosisIndexingTask$State.DATA_CREATING.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr[OSmosisIndexingTask$State.DATA_INDEXING.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        f4203a = iArr;
    }
}
