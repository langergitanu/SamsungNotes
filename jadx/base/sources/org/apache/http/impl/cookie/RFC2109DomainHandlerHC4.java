package org.apache.http.impl.cookie;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import java.util.Locale;
import org.apache.http.annotation.Immutable;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.CookieRestrictionViolationException;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;
import org.apache.http.util.Args;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Immutable
public class RFC2109DomainHandlerHC4 implements CookieAttributeHandler {
    @Override // org.apache.http.cookie.CookieAttributeHandler
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

    @Override // org.apache.http.cookie.CookieAttributeHandler
    public void parse(SetCookie setCookie, String str) throws MalformedCookieException {
        Args.notNull(setCookie, "Cookie");
        if (str == null) {
            throw new MalformedCookieException("Missing value for domain attribute");
        }
        if (str.trim().length() == 0) {
            throw new MalformedCookieException("Blank value for domain attribute");
        }
        setCookie.setDomain(str);
    }

    @Override // org.apache.http.cookie.CookieAttributeHandler
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
        String lowerCase = host.toLowerCase(Locale.ENGLISH);
        if (!lowerCase.endsWith(domain)) {
            throw new CookieRestrictionViolationException(AbstractC0541b.m775q("Illegal domain attribute \"", domain, "\". Domain of origin: \"", lowerCase, "\""));
        }
        if (lowerCase.substring(0, lowerCase.length() - domain.length()).indexOf(46) != -1) {
            throw new CookieRestrictionViolationException(AbstractC0541b.m773o("Domain attribute \"", domain, "\" violates RFC 2109: host minus domain may not contain any dots"));
        }
    }
}
