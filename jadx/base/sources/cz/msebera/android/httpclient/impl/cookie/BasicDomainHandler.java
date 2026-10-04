package cz.msebera.android.httpclient.impl.cookie;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.conn.util.InetAddressUtils;
import cz.msebera.android.httpclient.cookie.ClientCookie;
import cz.msebera.android.httpclient.cookie.CommonCookieAttributeHandler;
import cz.msebera.android.httpclient.cookie.Cookie;
import cz.msebera.android.httpclient.cookie.CookieOrigin;
import cz.msebera.android.httpclient.cookie.CookieRestrictionViolationException;
import cz.msebera.android.httpclient.cookie.MalformedCookieException;
import cz.msebera.android.httpclient.cookie.SetCookie;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.TextUtils;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Contract(threading = ThreadingBehavior.IMMUTABLE)
public class BasicDomainHandler implements CommonCookieAttributeHandler {
    public static boolean domainMatch(String str, String str2) {
        if (!InetAddressUtils.isIPv4Address(str2) && !InetAddressUtils.isIPv6Address(str2)) {
            if (str.startsWith(Extension.DOT)) {
                str = str.substring(1);
            }
            if (str2.endsWith(str)) {
                int length = str2.length() - str.length();
                if (length == 0) {
                    return true;
                }
                if (length > 1 && str2.charAt(length - 1) == '.') {
                    return true;
                }
            }
        }
        return false;
    }

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
        if (domain.startsWith(Extension.DOT)) {
            domain = domain.substring(1);
        }
        String lowerCase = domain.toLowerCase(Locale.ROOT);
        if (host.equals(lowerCase)) {
            return true;
        }
        if ((cookie instanceof ClientCookie) && ((ClientCookie) cookie).containsAttribute(ClientCookie.DOMAIN_ATTR)) {
            return domainMatch(lowerCase, host);
        }
        return false;
    }

    @Override // cz.msebera.android.httpclient.cookie.CookieAttributeHandler
    public void parse(SetCookie setCookie, String str) throws MalformedCookieException {
        Args.notNull(setCookie, "Cookie");
        if (TextUtils.isBlank(str)) {
            throw new MalformedCookieException("Blank or null value for domain attribute");
        }
        if (str.endsWith(Extension.DOT)) {
            return;
        }
        if (str.startsWith(Extension.DOT)) {
            str = str.substring(1);
        }
        setCookie.setDomain(str.toLowerCase(Locale.ROOT));
    }

    @Override // cz.msebera.android.httpclient.cookie.CookieAttributeHandler
    public void validate(Cookie cookie, CookieOrigin cookieOrigin) throws CookieRestrictionViolationException {
        Args.notNull(cookie, "Cookie");
        Args.notNull(cookieOrigin, "Cookie origin");
        String host = cookieOrigin.getHost();
        String domain = cookie.getDomain();
        if (domain == null) {
            throw new CookieRestrictionViolationException("Cookie 'domain' may not be null");
        }
        if (!host.equals(domain) && !domainMatch(domain, host)) {
            throw new CookieRestrictionViolationException(AbstractC0541b.m775q("Illegal 'domain' attribute \"", domain, "\". Domain of origin: \"", host, "\""));
        }
    }
}
