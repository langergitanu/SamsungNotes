package com.google.android.play.core.install.model;

import androidx.appcompat.widget.AbstractC0541b;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: com.google.android.play.core.install.model.a */
/* JADX INFO: loaded from: classes5.dex */
public final class C5150a {

    /* JADX INFO: renamed from: a */
    private static final Map<Integer, String> f2929a;

    /* JADX INFO: renamed from: b */
    private static final Map<Integer, String> f2930b;

    static {
        HashMap map = new HashMap();
        f2929a = map;
        HashMap map2 = new HashMap();
        f2930b = map2;
        map.put(-2, "An unknown error occurred.");
        map.put(-3, "The API is not available on this device.");
        map.put(-4, "The request that was sent by the app is malformed.");
        map.put(-5, "The install is unavailable to this user or device.");
        map.put(-6, "The download/install is not allowed, due to the current device state (e.g. low battery, low disk space, ...).");
        map.put(-7, "The install/update has not been (fully) downloaded yet.");
        map.put(-8, "The install is already in progress and there is no UI flow to resume.");
        map.put(-9, "The Play Store app is either not installed or not the official version.");
        map.put(-10, "The app is not owned by any user on this device. An app is \"owned\" if it has been acquired from Play.");
        map.put(-100, "An internal error happened in the Play Store.");
        map2.put(-2, "ERROR_UNKNOWN");
        map2.put(-3, "ERROR_API_NOT_AVAILABLE");
        map2.put(-4, "ERROR_INVALID_REQUEST");
        map2.put(-5, "ERROR_INSTALL_UNAVAILABLE");
        map2.put(-6, "ERROR_INSTALL_NOT_ALLOWED");
        map2.put(-7, "ERROR_DOWNLOAD_NOT_PRESENT");
        map2.put(-8, "ERROR_INSTALL_IN_PROGRESS");
        map2.put(-100, "ERROR_INTERNAL_ERROR");
        map2.put(-9, "ERROR_PLAY_STORE_NOT_FOUND");
        map2.put(-10, "ERROR_APP_NOT_OWNED");
    }

    /* JADX INFO: renamed from: a */
    public static String m3863a(@InstallErrorCode int i) {
        Map<Integer, String> map = f2929a;
        Integer numValueOf = Integer.valueOf(i);
        if (!map.containsKey(numValueOf)) {
            return "";
        }
        Map<Integer, String> map2 = f2930b;
        if (!map2.containsKey(numValueOf)) {
            return "";
        }
        String str = map.get(numValueOf);
        String str2 = map2.get(numValueOf);
        return AbstractC0541b.m776r(new StringBuilder(String.valueOf(str).length() + 103 + String.valueOf(str2).length()), str, " (https://developer.android.com/reference/com/google/android/play/core/install/model/InstallErrorCode#", str2, ")");
    }
}
