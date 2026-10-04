package com.samsung.android.app.notes.sync.coedit.deletecore;

import com.samsung.android.app.notes.sync.coedit.deletecore.CoeditDeleteLocalSharedSdocTask;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.coedit.deletecore.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract /* synthetic */ class AbstractC6667a {

    /* JADX INFO: renamed from: a */
    public static final /* synthetic */ int[] f3946a;

    static {
        int[] iArr = new int[CoeditDeleteLocalSharedSdocTask.DeleteType.values().length];
        f3946a = iArr;
        try {
            iArr[CoeditDeleteLocalSharedSdocTask.DeleteType.GROUP.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f3946a[CoeditDeleteLocalSharedSdocTask.DeleteType.GROUP_LEAVE.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f3946a[CoeditDeleteLocalSharedSdocTask.DeleteType.ALL.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}
