package com.samsung.android.sdk.pen.ocr;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SpenLibraryLoader {
    private static final String LIB_EXT_SO = ".so";
    private static final String LIB_PREFIX = "lib";
    public static final String SOCR_PROVIDER_PACKAGE_NAME = "com.samsung.android.sdk.ocr";
    private static final String TAG = "SpenLibraryLoader";
    private static final Map<LibType, List<String>> libMap;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum LibType {
        OCR,
        Moire
    }

    static {
        HashMap map = new HashMap();
        map.put(LibType.OCR, Arrays.asList("SDKonnxruntime.spenocr.samsung", "SDKRecognitionOCR.spenocr.samsung"));
        map.put(LibType.Moire, Arrays.asList("tensorflowlite_c.spenocr.samsung", "SDKMoireDetector.spenocr.samsung"));
        libMap = Collections.unmodifiableMap(map);
    }

    public static String getMainLibName(LibType libType) {
        List<String> list = libMap.get(libType);
        return (list == null || list.size() <= 0) ? "" : (String) AbstractC0000a.m10g(list, 1);
    }

    @SuppressLint({"UnsafeDynamicallyLoadedCode"})
    private static boolean loadLibraries(String str, List<String> list) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    Iterator<String> it = list.iterator();
                    while (it.hasNext()) {
                        String str2 = LIB_PREFIX + it.next() + LIB_EXT_SO;
                        String str3 = str + File.separator + str2;
                        Log.d(TAG, "loadLibraries : " + str3);
                        if (!new File(str3).exists()) {
                            Log.i(TAG, "loadLibraries : " + str2 + " does not exist");
                            return false;
                        }
                        System.load(str3);
                    }
                    return true;
                }
            } catch (UnsatisfiedLinkError e) {
                Log.e(TAG, "loadLibraries : Cannot load remote libs : " + e.getLocalizedMessage());
            }
        }
        return false;
    }

    public static boolean loadRemoteLibrary(Context context, LibType libType) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo("com.samsung.android.sdk.ocr", 0);
            Log.d(TAG, "loadRemoteLibrary : " + applicationInfo.nativeLibraryDir);
            return loadLibraries(applicationInfo.nativeLibraryDir, libMap.get(libType));
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(TAG, "loadRemoteLibrary : Cannot find remote lib : " + e.getLocalizedMessage());
            return false;
        }
    }
}
