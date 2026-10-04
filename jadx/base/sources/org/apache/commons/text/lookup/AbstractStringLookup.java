package org.apache.commons.text.lookup;

import androidx.appcompat.widget.AbstractC0541b;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
abstract class AbstractStringLookup implements StringLookup {
    protected static final char SPLIT_CH = ':';
    protected static final String SPLIT_STR = String.valueOf(SPLIT_CH);

    public static String toLookupKey(String str, String str2, String str3) {
        return AbstractC0541b.m757C(str, str2, str3);
    }

    @Deprecated
    public String substringAfter(String str, char c) {
        return StringUtils.substringAfter(str, c);
    }

    @Deprecated
    public String substringAfterLast(String str, char c) {
        return StringUtils.substringAfterLast(str, c);
    }

    @Deprecated
    public String substringAfter(String str, String str2) {
        return StringUtils.substringAfter(str, str2);
    }

    public static String toLookupKey(String str, String str2) {
        return toLookupKey(str, SPLIT_STR, str2);
    }
}
