package io.netty.handler.codec.http.cookie;

import io.netty.util.internal.ObjectUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class ServerCookieDecoder extends CookieDecoder {
    private static final String RFC2965_DOMAIN = "$Domain";
    private static final String RFC2965_PATH = "$Path";
    private static final String RFC2965_PORT = "$Port";
    private static final String RFC2965_VERSION = "$Version";
    public static final ServerCookieDecoder STRICT = new ServerCookieDecoder(true);
    public static final ServerCookieDecoder LAX = new ServerCookieDecoder(false);

    private ServerCookieDecoder(boolean z) {
        super(z);
    }

    public Set<Cookie> decode(String str) {
        TreeSet treeSet = new TreeSet();
        decode(treeSet, str);
        return treeSet;
    }

    public List<Cookie> decodeAll(String str) {
        ArrayList arrayList = new ArrayList();
        decode(arrayList, str);
        return Collections.unmodifiableList(arrayList);
    }

    private void decode(Collection<? super Cookie> collection, String str) {
        boolean z;
        int iIndexOf;
        int i;
        int i2;
        int i4;
        int i5;
        int length = ((String) ObjectUtil.checkNotNull(str, "header")).length();
        if (length == 0) {
            return;
        }
        String str2 = str;
        if (str2.regionMatches(true, 0, RFC2965_VERSION, 0, 8)) {
            iIndexOf = str2.indexOf(59) + 1;
            z = true;
        } else {
            z = false;
            iIndexOf = 0;
        }
        while (iIndexOf != length) {
            char cCharAt = str2.charAt(iIndexOf);
            if (cCharAt == '\t' || cCharAt == '\n' || cCharAt == 11 || cCharAt == '\f' || cCharAt == '\r' || cCharAt == ' ' || cCharAt == ',' || cCharAt == ';') {
                iIndexOf++;
            } else {
                int i6 = iIndexOf;
                while (true) {
                    char cCharAt2 = str2.charAt(i6);
                    i = -1;
                    if (cCharAt2 == ';') {
                        i2 = i6;
                        i4 = i2;
                        break;
                    }
                    if (cCharAt2 == '=') {
                        i = i6 + 1;
                        if (i == length) {
                            i2 = i6;
                            i4 = i;
                            i = 0;
                        } else {
                            int iIndexOf2 = str2.indexOf(59, i);
                            if (iIndexOf2 <= 0) {
                                iIndexOf2 = length;
                            }
                            i5 = iIndexOf2;
                            i4 = i5;
                            i2 = i6;
                        }
                    } else {
                        i6++;
                        if (i6 == length) {
                            i2 = length;
                            i4 = i6;
                            break;
                        }
                    }
                }
                i5 = i;
                if (!z || (!str2.regionMatches(iIndexOf, RFC2965_PATH, 0, 5) && !str2.regionMatches(iIndexOf, RFC2965_DOMAIN, 0, 7) && !str2.regionMatches(iIndexOf, RFC2965_PORT, 0, 5))) {
                    String str3 = str2;
                    DefaultCookie defaultCookieInitCookie = initCookie(str3, iIndexOf, i2, i, i5);
                    str2 = str3;
                    if (defaultCookieInitCookie != null) {
                        collection.add(defaultCookieInitCookie);
                    }
                }
                iIndexOf = i4;
            }
        }
    }
}
