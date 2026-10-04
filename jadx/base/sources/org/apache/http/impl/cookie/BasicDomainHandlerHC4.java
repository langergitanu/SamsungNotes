package org.apache.http.impl.cookie;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
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
public class BasicDomainHandlerHC4 implements CookieAttributeHandler {
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
        if (!domain.startsWith(Extension.DOT)) {
            domain = String.valueOf('.') + domain;
        }
        return host.endsWith(domain) || host.equals(domain.substring(1));
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
        if (!host.contains(Extension.DOT)) {
            if (!host.equals(domain)) {
                throw new CookieRestrictionViolationException(AbstractC0541b.m775q("Illegal domain attribute \"", domain, "\". Domain of origin: \"", host, "\""));
            }
        } else {
            if (host.endsWith(domain)) {
                return;
            }
            if (domain.startsWith(Extension.DOT)) {
                domain = domain.substring(1, domain.length());
            }
            if (!host.equals(domain)) {
                throw new CookieRestrictionViolationException(AbstractC0541b.m775q("Illegal domain attribute \"", domain, "\". Domain of origin: \"", host, "\""));
            }
        }
    }
}
