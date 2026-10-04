package com.samsung.android.app.notes.sync.migration;

import com.samsung.android.app.notes.sync.migration.common.Type$Interface;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.migration.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract /* synthetic */ class AbstractC6788a {

    /* JADX INFO: renamed from: a */
    public static final /* synthetic */ int[] f4188a;

    static {
        int[] iArr = new int[Type$Interface.values().length];
        f4188a = iArr;
        try {
            iArr[Type$Interface.OSMOSIS.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f4188a[Type$Interface.INDEPENDENT.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}
