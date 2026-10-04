package com.microsoft.identity.common.java.nativeauth;

import javax.annotation.Nonnull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class BuildValues {

    /* JADX INFO: renamed from: DC */
    @Nonnull
    private static String f3599DC = "";

    @Nonnull
    private static Boolean USE_MOCK_API_FOR_NATIVE_AUTH_AUTHORITY = Boolean.FALSE;

    public static String getDC() {
        return f3599DC;
    }

    public static void setDC(String str) {
        f3599DC = str;
    }

    public static void setUseMockApiForNativeAuth(Boolean bool) {
        USE_MOCK_API_FOR_NATIVE_AUTH_AUTHORITY = bool;
    }

    public static Boolean shouldUseMockApiForNativeAuth() {
        return USE_MOCK_API_FOR_NATIVE_AUTH_AUTHORITY;
    }
}
