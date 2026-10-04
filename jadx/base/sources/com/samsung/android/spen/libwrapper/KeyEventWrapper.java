package com.samsung.android.spen.libwrapper;

import com.samsung.android.spen.libwrapper.utils.PlatformUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class KeyEventWrapper {
    public static final int KEYCODE_CLIPBOARD;
    public static final int KEYCODE_QUESTION;
    public static final int KEYCODE_SPEAKER;
    public static final int KEYCODE_TEXT;
    public static final int KEYCODE_USER;
    public static final int KEYCODE_WPS_BUTTON;

    static {
        if (PlatformUtils.isSemDevice()) {
            KEYCODE_CLIPBOARD = 1009;
            KEYCODE_QUESTION = 1014;
            KEYCODE_SPEAKER = 1012;
            KEYCODE_TEXT = 1013;
            KEYCODE_USER = 1015;
            KEYCODE_WPS_BUTTON = 1042;
            return;
        }
        KEYCODE_CLIPBOARD = 1009;
        KEYCODE_QUESTION = 1014;
        KEYCODE_SPEAKER = 1012;
        KEYCODE_TEXT = 1013;
        KEYCODE_USER = 1015;
        KEYCODE_WPS_BUTTON = 1042;
    }
}
