package com.samsung.android.spen.libwrapper;

import com.samsung.android.spen.libwrapper.utils.PlatformUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class MotionEventWrapper {
    public static final int ACTION_PEN_CANCEL;
    public static final int ACTION_PEN_DOWN;
    public static final int ACTION_PEN_MOVE;
    public static final int ACTION_PEN_UP;
    public static final int FLAG_EVENT_BY_TWO_FINGER_GESTURE;

    static {
        if (PlatformUtils.isSemDevice()) {
            ACTION_PEN_DOWN = 211;
            ACTION_PEN_MOVE = 213;
            ACTION_PEN_UP = 212;
            ACTION_PEN_CANCEL = 214;
            FLAG_EVENT_BY_TWO_FINGER_GESTURE = 268435456;
            return;
        }
        ACTION_PEN_DOWN = 211;
        ACTION_PEN_MOVE = 213;
        ACTION_PEN_UP = 212;
        ACTION_PEN_CANCEL = 214;
        FLAG_EVENT_BY_TWO_FINGER_GESTURE = 268435456;
    }
}
