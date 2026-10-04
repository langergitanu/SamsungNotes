package cz.msebera.android.httpclient.cookie;

import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Contract(threading = ThreadingBehavior.IMMUTABLE)
public class CookiePathComparator implements Serializable, Comparator<Cookie> {
    public static final CookiePathComparator INSTANCE = new CookiePathComparator();
    private static final long serialVersionUID = 7523645369616405818L;

    private String normalizePath(Cookie cookie) {
        String path = cookie.getPath();
        if (path == null) {
            path = "/";
        }
        return !path.endsWith("/") ? path.concat("/") : path;
    }

    @Override // java.util.Comparator
    public int compare(Cookie cookie, Cookie cookie2) {
        String strNormalizePath = normalizePath(cookie);
        String strNormalizePath2 = normalizePath(cookie2);
        if (strNormalizePath.equals(strNormalizePath2)) {
            return 0;
        }
        if (strNormalizePath.startsWith(strNormalizePath2)) {
            return -1;
        }
        return strNormalizePath2.startsWith(strNormalizePath) ? 1 : 0;
    }
}
