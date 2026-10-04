package org.apache.commons.lang3;

import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Deprecated
public class CharEncoding {
    public static final String ISO_8859_1 = StandardCharsets.ISO_8859_1.name();
    public static final String US_ASCII = StandardCharsets.US_ASCII.name();
    public static final String UTF_16 = StandardCharsets.UTF_16.name();
    public static final String UTF_16BE = StandardCharsets.UTF_16BE.name();
    public static final String UTF_16LE = StandardCharsets.UTF_16LE.name();
    public static final String UTF_8 = StandardCharsets.UTF_8.name();

    @Deprecated
    public CharEncoding() {
    }

    @Deprecated
    public static boolean isSupported(String str) {
        if (str == null) {
            return false;
        }
        try {
            return Charset.isSupported(str);
        } catch (IllegalCharsetNameException unused) {
            return false;
        }
    }
}
