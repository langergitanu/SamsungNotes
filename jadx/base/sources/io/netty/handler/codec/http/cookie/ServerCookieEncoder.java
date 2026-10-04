package io.netty.handler.codec.http.cookie;

import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import io.netty.handler.codec.DateFormatter;
import io.netty.util.internal.ObjectUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class ServerCookieEncoder extends CookieEncoder {
    public static final ServerCookieEncoder STRICT = new ServerCookieEncoder(true);
    public static final ServerCookieEncoder LAX = new ServerCookieEncoder(false);

    private ServerCookieEncoder(boolean z) {
        super(z);
    }

    private static List<String> dedup(List<String> list, Map<String, Integer> map) {
        boolean[] zArr = new boolean[list.size()];
        Iterator<Integer> it = map.values().iterator();
        while (it.hasNext()) {
            zArr[it.next().intValue()] = true;
        }
        ArrayList arrayList = new ArrayList(map.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (zArr[i]) {
                arrayList.add(list.get(i));
            }
        }
        return arrayList;
    }

    public String encode(String str, String str2) {
        return encode(new DefaultCookie(str, str2));
    }

    public String encode(Cookie cookie) {
        String strName = ((Cookie) ObjectUtil.checkNotNull(cookie, "cookie")).name();
        String strValue = cookie.value() != null ? cookie.value() : "";
        validateCookie(strName, strValue);
        StringBuilder sbStringBuilder = CookieUtil.stringBuilder();
        if (cookie.wrap()) {
            CookieUtil.addQuoted(sbStringBuilder, strName, strValue);
        } else {
            CookieUtil.add(sbStringBuilder, strName, strValue);
        }
        if (cookie.maxAge() != Long.MIN_VALUE) {
            CookieUtil.add(sbStringBuilder, CookieHeaderNames.MAX_AGE, cookie.maxAge());
            Date date = new Date(System.currentTimeMillis() + (cookie.maxAge() * 1000));
            sbStringBuilder.append("Expires");
            sbStringBuilder.append('=');
            DateFormatter.append(date, sbStringBuilder);
            sbStringBuilder.append(SQLKeyword.DELIMITER);
            sbStringBuilder.append(' ');
        }
        if (cookie.path() != null) {
            CookieUtil.add(sbStringBuilder, CookieHeaderNames.PATH, cookie.path());
        }
        if (cookie.domain() != null) {
            CookieUtil.add(sbStringBuilder, CookieHeaderNames.DOMAIN, cookie.domain());
        }
        if (cookie.isSecure()) {
            CookieUtil.add(sbStringBuilder, CookieHeaderNames.SECURE);
        }
        if (cookie.isHttpOnly()) {
            CookieUtil.add(sbStringBuilder, CookieHeaderNames.HTTPONLY);
        }
        if (cookie instanceof DefaultCookie) {
            DefaultCookie defaultCookie = (DefaultCookie) cookie;
            if (defaultCookie.sameSite() != null) {
                CookieUtil.add(sbStringBuilder, CookieHeaderNames.SAMESITE, defaultCookie.sameSite().name());
            }
        }
        return CookieUtil.stripTrailingSeparator(sbStringBuilder);
    }

    public List<String> encode(Cookie... cookieArr) {
        if (((Cookie[]) ObjectUtil.checkNotNull(cookieArr, "cookies")).length == 0) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList(cookieArr.length);
        HashMap map = (!this.strict || cookieArr.length <= 1) ? null : new HashMap();
        boolean z = false;
        for (int i = 0; i < cookieArr.length; i++) {
            Cookie cookie = cookieArr[i];
            arrayList.add(encode(cookie));
            if (map != null) {
                z |= map.put(cookie.name(), Integer.valueOf(i)) != null;
            }
        }
        return z ? dedup(arrayList, map) : arrayList;
    }

    public List<String> encode(Collection<? extends Cookie> collection) {
        if (((Collection) ObjectUtil.checkNotNull(collection, "cookies")).isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList(collection.size());
        HashMap map = (!this.strict || collection.size() <= 1) ? null : new HashMap();
        boolean z = false;
        int i = 0;
        for (Cookie cookie : collection) {
            arrayList.add(encode(cookie));
            if (map != null) {
                int i2 = i + 1;
                z |= map.put(cookie.name(), Integer.valueOf(i)) != null;
                i = i2;
            }
        }
        return z ? dedup(arrayList, map) : arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0084 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<String> encode(Iterable<? extends Cookie> iterable) {
        int i;
        boolean z;
        Iterator it = ((Iterable) ObjectUtil.checkNotNull(iterable, "cookies")).iterator();
        if (!it.hasNext()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        Cookie cookie = (Cookie) it.next();
        HashMap map = (this.strict && it.hasNext()) ? new HashMap() : null;
        arrayList.add(encode(cookie));
        if (map == null) {
            i = 0;
        } else {
            if (map.put(cookie.name(), 0) != null) {
                i = 1;
                z = true;
                while (it.hasNext()) {
                    Cookie cookie2 = (Cookie) it.next();
                    arrayList.add(encode(cookie2));
                    if (map != null) {
                        int i2 = i + 1;
                        z = (map.put(cookie2.name(), Integer.valueOf(i)) != null) | z;
                        i = i2;
                    }
                }
                return !z ? dedup(arrayList, map) : arrayList;
            }
            i = 1;
        }
        z = false;
        while (it.hasNext()) {
        }
        if (!z) {
        }
    }
}
