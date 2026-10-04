package com.samsung.android.spen.libwrapper;

import com.samsung.android.spen.libwrapper.utils.PlatformUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class MediaSessionWrapper {
    public static final int FLAG_HANDLES_MEDIA_BUTTONS;

    static {
        if (PlatformUtils.isSemDevice()) {
            FLAG_HANDLES_MEDIA_BUTTONS = 268435456;
        } else {
            FLAG_HANDLES_MEDIA_BUTTONS = 1;
        }
    }
}
