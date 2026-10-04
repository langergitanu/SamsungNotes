package cz.msebera.android.httpclient.impl.cookie;

import cz.msebera.android.httpclient.conn.util.PublicSuffixMatcher;
import cz.msebera.android.httpclient.cookie.Cookie;
import cz.msebera.android.httpclient.cookie.CookieAttributeHandler;
import cz.msebera.android.httpclient.cookie.CookieOrigin;
import cz.msebera.android.httpclient.cookie.SetCookie;
import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Deprecated
public class PublicSuffixFilter implements CookieAttributeHandler {
    private Collection<String> exceptions;
    private PublicSuffixMatcher matcher;
    private Collection<String> suffixes;
    private final CookieAttributeHandler wrapped;

    public PublicSuffixFilter(CookieAttributeHandler cookieAttributeHandler) {
        this.wrapped = cookieAttributeHandler;
    }

    private boolean isForPublicSuffix(Cookie cookie) {
        if (this.matcher == null) {
            this.matcher = new PublicSuffixMatcher(this.suffixes, this.exceptions);
        }
        return this.matcher.matches(cookie.getDomain());
    }

    @Override // cz.msebera.android.httpclient.cookie.CookieAttributeHandler
    public boolean match(Cookie cookie, CookieOrigin cookieOrigin) {
        if (isForPublicSuffix(cookie)) {
            return false;
        }
        return this.wrapped.match(cookie, cookieOrigin);
    }

    @Override // cz.msebera.android.httpclient.cookie.CookieAttributeHandler
    public void parse(SetCookie setCookie, String str) {
        this.wrapped.parse(setCookie, str);
    }

    public void setExceptions(Collection<String> collection) {
        this.exceptions = collection;
        this.matcher = null;
    }

    public void setPublicSuffixes(Collection<String> collection) {
        this.suffixes = collection;
        this.matcher = null;
    }

    @Override // cz.msebera.android.httpclient.cookie.CookieAttributeHandler
    public void validate(Cookie cookie, CookieOrigin cookieOrigin) {
        this.wrapped.validate(cookie, cookieOrigin);
    }
}
