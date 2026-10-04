package com.samsung.android.livetranslation.common;

import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class Config {
    public static final int IS_MSER_NEEDED = 8;
    public static boolean IS_PROFILING_ENABLED = false;
    public static final boolean IS_USER_DEBUG;
    public static final int KEY_DEVICE_HEIGHT = 4;
    public static final int KEY_DEVICE_WIDTH = 3;
    public static final int KEY_LTT_ENGINE_API_VERSON = 2;
    public static final int KEY_LTT_ENGINE_VERSION = 1;
    public static final int KEY_ORIGINAL_IMAGE_HEIGHT = 6;
    public static final int KEY_ORIGINAL_IMAGE_WIDTH = 5;
    public static final int KEY_RESIZE_IMAGE_FACTOR = 7;
    public static final double LINE_SPACE_RATIO = 1.0d;
    public static final double MARGIN_RATIO_X = 0.075d;
    public static final double MARGIN_RATIO_Y = 0.1d;
    public static final int SETPROP_SUCCESS = 1;

    static {
        String str = Build.TYPE;
        IS_USER_DEBUG = str.contentEquals("eng") || str.contentEquals("userdebug");
        IS_PROFILING_ENABLED = true;
    }
}
