package cz.msebera.android.httpclient.cookie;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.annotation.Obsolete;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface CookieSpec {
    List<Header> formatCookies(List<Cookie> list);

    @Obsolete
    int getVersion();

    @Obsolete
    Header getVersionHeader();

    boolean match(Cookie cookie, CookieOrigin cookieOrigin);

    List<Cookie> parse(Header header, CookieOrigin cookieOrigin);

    void validate(Cookie cookie, CookieOrigin cookieOrigin);
}
