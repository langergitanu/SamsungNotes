package com.samsung.android.sdk.scs.p142ai.asr;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface ErrorCode {
    public static final int AUDIO = 3;
    public static final int CLIENT = 5;
    public static final int INSUFFICIENT_PERMISSIONS = 9;
    public static final int LANGUAGE_PACKAGE_DISABLED = 13;
    public static final int NETWORK = 2;
    public static final int NETWORK_TIMEOUT = 1;
    public static final int NOT_SET = 0;
    public static final int NO_LID_LANGUAGE_PACKAGE_INSTALLED = 14;
    public static final int NO_MATCH = 7;
    public static final int NO_PROPER_LANGUAGE_PACKAGE_INSTALLED = 10;
    public static final int RECOGNIZER_BUSY = 8;
    public static final int RECOGNIZER_UNINITIALIZED = 15;
    public static final int RESOURCE_INCOMPATIBLE = 11;
    public static final int SERVICE = 4;
    public static final int SPEECH_TIMEOUT = 6;
    public static final int UNSUPPORTED_FEATURE = -1;
    public static final int UNSUPPORTED_LOCALE = 12;
}
