package com.samsung.android.app.notes.sync.contentsharing.deletecore;

import com.samsung.android.app.notes.sync.contentsharing.deletecore.DeleteLocalSharedSdocTask;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.contentsharing.deletecore.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract /* synthetic */ class AbstractC6685a {

    /* JADX INFO: renamed from: a */
    public static final /* synthetic */ int[] f3987a;

    static {
        int[] iArr = new int[DeleteLocalSharedSdocTask.DeleteType.values().length];
        f3987a = iArr;
        try {
            iArr[DeleteLocalSharedSdocTask.DeleteType.GROUP.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f3987a[DeleteLocalSharedSdocTask.DeleteType.SPACE.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f3987a[DeleteLocalSharedSdocTask.DeleteType.ALL.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f3987a[DeleteLocalSharedSdocTask.DeleteType.MEMBER.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
