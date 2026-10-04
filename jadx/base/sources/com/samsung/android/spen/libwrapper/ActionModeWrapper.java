package com.samsung.android.spen.libwrapper;

import com.samsung.android.spen.libwrapper.utils.PlatformUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ActionModeWrapper {
    public static final int DEFAULT_HIDE_DURATION;
    public static final int SEM_TYPE_FLOATING;
    public static final int TYPE_FLOATING;
    public static final int TYPE_PRIMARY;

    static {
        if (PlatformUtils.isSemDevice()) {
            DEFAULT_HIDE_DURATION = -1;
            SEM_TYPE_FLOATING = 99;
            TYPE_FLOATING = 1;
            TYPE_PRIMARY = 0;
            return;
        }
        DEFAULT_HIDE_DURATION = -1;
        SEM_TYPE_FLOATING = 99;
        TYPE_FLOATING = 1;
        TYPE_PRIMARY = 0;
    }
}
