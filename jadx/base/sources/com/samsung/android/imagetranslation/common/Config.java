package com.samsung.android.imagetranslation.common;

import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class Config {
    public static final boolean IS_USER_DEBUG;
    public static final int KEY_LTT_ENGINE_VERSION = 1;
    public static final double MARGIN_RATIO_X = 0.075d;
    public static final double MARGIN_RATIO_Y = 0.1d;
    public static final int MAX_RESOLUTION_SUPPORTED = 16000;
    public static final int MAX_UPSCALE_LENGTH = 1080;
    public static final double MIN_ASPECT_RATIO = 7.0d;
    public static final int RESIZE_THRESHOLD = 512;

    static {
        String str = Build.TYPE;
        IS_USER_DEBUG = str.contentEquals("eng") || str.contentEquals("userdebug");
    }
}
