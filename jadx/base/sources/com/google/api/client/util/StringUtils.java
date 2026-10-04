package com.google.api.client.util;

import org.apache.commons.lang3.SystemProperties;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class StringUtils {
    public static final String LINE_SEPARATOR = System.getProperty(SystemProperties.LINE_SEPARATOR);

    private StringUtils() {
    }

    public static byte[] getBytesUtf8(String str) {
        return com.google.api.client.repackaged.org.apache.commons.codec.binary.StringUtils.getBytesUtf8(str);
    }

    public static String newStringUtf8(byte[] bArr) {
        return com.google.api.client.repackaged.org.apache.commons.codec.binary.StringUtils.newStringUtf8(bArr);
    }
}
