package com.samsung.android.app.notes.sync.synchronization.managers;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.synchronization.managers.h */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract /* synthetic */ class AbstractC6905h {

    /* JADX INFO: renamed from: a */
    public static final /* synthetic */ int[] f4480a;

    static {
        int[] iArr = new int[SyncStateManager$SyncFailState.values().length];
        f4480a = iArr;
        try {
            iArr[SyncStateManager$SyncFailState.WIFI_ONLY.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f4480a[SyncStateManager$SyncFailState.POWER_SAVING.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f4480a[SyncStateManager$SyncFailState.MASTER_SYNC.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f4480a[SyncStateManager$SyncFailState.PHONE_PERMISSION.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f4480a[SyncStateManager$SyncFailState.NETWORK.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
