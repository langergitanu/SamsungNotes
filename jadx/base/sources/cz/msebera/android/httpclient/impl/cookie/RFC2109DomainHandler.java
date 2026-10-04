package cz.msebera.android.httpclient.impl.cookie;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.cookie.ClientCookie;
import cz.msebera.android.httpclient.cookie.CommonCookieAttributeHandler;
import cz.msebera.android.httpclient.cookie.Cookie;
import cz.msebera.android.httpclient.cookie.CookieOrigin;
import cz.msebera.android.httpclient.cookie.CookieRestrictionViolationException;
import cz.msebera.android.httpclient.cookie.MalformedCookieException;
import cz.msebera.android.httpclient.cookie.SetCookie;
import cz.msebera.android.httpclient.util.Args;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Contract(threading = ThreadingBehavior.IMMUTABLE)
public class RFC2109DomainHandler implements CommonCookieAttributeHandler {
    @Override // cz.msebera.android.httpclient.cookie.CommonCookieAttributeHandler
    public String getAttributeName() {
        return ClientCookie.DOMAIN_ATTR;
    }

    @Override // cz.msebera.android.httpclient.cookie.CookieAttributeHandler
    public boolean match(Cookie cookie, CookieOrigin cookieOrigin) {
        Args.notNull(cookie, "Cookie");
        Args.notNull(cookieOrigin, "Cookie origin");
        String host = cookieOrigin.getHost();
        String domain = cookie.getDomain();
        if (domain == null) {
            return false;
        }
        if (host.equals(domain)) {
            return true;
        }
        return domain.startsWith(Extension.DOT) && host.endsWith(domain);
    }

    @Override // cz.msebera.android.httpclient.cookie.CookieAttributeHandler
    public void parse(SetCookie setCookie, String str) throws MalformedCookieException {
        Args.notNull(setCookie, "Cookie");
        if (str == null) {
            throw new MalformedCookieException("Missing value for domain attribute");
        }
        if (str.trim().isEmpty()) {
            throw new MalformedCookieException("Blank value for domain attribute");
        }
        setCookie.setDomain(str);
    }

    @Override // cz.msebera.android.httpclient.cookie.CookieAttributeHandler
    public void validate(Cookie cookie, CookieOrigin cookieOrigin) throws CookieRestrictionViolationException {
        Args.notNull(cookie, "Cookie");
        Args.notNull(cookieOrigin, "Cookie origin");
        String host = cookieOrigin.getHost();
        String domain = cookie.getDomain();
        if (domain == null) {
            throw new CookieRestrictionViolationException("Cookie domain may not be null");
        }
        if (domain.equals(host)) {
            return;
        }
        if (domain.indexOf(46) == -1) {
            throw new CookieRestrictionViolationException(AbstractC0541b.m775q("Domain attribute \"", domain, "\" does not match the host \"", host, "\""));
        }
        if (!domain.startsWith(Extension.DOT)) {
            throw new CookieRestrictionViolationException(AbstractC0541b.m773o("Domain attribute \"", domain, "\" violates RFC 2109: domain must start with a dot"));
        }
        int iIndexOf = domain.indexOf(46, 1);
        if (iIndexOf < 0 || iIndexOf == domain.length() - 1) {
            throw new CookieRestrictionViolationException(AbstractC0541b.m773o("Domain attribute \"", domain, "\" violates RFC 2109: domain must contain an embedded dot"));
        }
        String lowerCase = host.toLowerCase(Locale.ROOT);
        if (!lowerCase.endsWith(domain)) {
            throw new CookieRestrictionViolationException(AbstractC0541b.m775q("Illegal domain attribute \"", domain, "\". Domain of origin: \"", lowerCase, "\""));
        }
        if (lowerCase.substring(0, lowerCase.length() - domain.length()).indexOf(46) != -1) {
            throw new CookieRestrictionViolationException(AbstractC0541b.m773o("Domain attribute \"", domain, "\" violates RFC 2109: host minus domain may not contain any dots"));
        }
    }
}
