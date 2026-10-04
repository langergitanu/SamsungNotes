package com.samsung.android.sdk.handwriting.common;

import org.apache.commons.lang3.SystemProperties;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class HwrConfig {
    public static final String HWRSDK_PACKAGE_NAME = "com.samsung.android.sdk.handwriting";
    public static final String HWRSDK_PACKAGE_NAME_WATCH = "com.samsung.android.sdk.handwriting.watch";
    public static final String LIBNAME_GESTURE = "libSPenGesture.so";
    public static final int USE_32BIT_LIBRARY = 1;
    public static final int USE_64BIT_LIBRARY = 2;
    public static final int USE_SYSTEM_DEFAULT = 0;
    public static final String FILE_SEPARATOR = System.getProperty(SystemProperties.FILE_SEPARATOR);
    public static final String PATH_SEPARATOR = System.getProperty(SystemProperties.PATH_SEPARATOR);
    private static int mLibraryAbi = 0;

    public static int getLibraryAbi() {
        return mLibraryAbi;
    }

    public static void setLibraryAbi(int i) {
        mLibraryAbi = i;
    }
}
