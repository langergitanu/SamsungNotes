package cz.msebera.android.httpclient.impl.cookie;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.cookie.ClientCookie;
import cz.msebera.android.httpclient.cookie.Cookie;
import cz.msebera.android.httpclient.cookie.CookieOrigin;
import cz.msebera.android.httpclient.cookie.CookieRestrictionViolationException;
import cz.msebera.android.httpclient.cookie.MalformedCookieException;
import cz.msebera.android.httpclient.cookie.SetCookie;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.TextUtils;
import java.util.Locale;
import java.util.StringTokenizer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Contract(threading = ThreadingBehavior.IMMUTABLE)
public class NetscapeDomainHandler extends BasicDomainHandler {
    private static boolean isSpecialDomain(String str) {
        String upperCase = str.toUpperCase(Locale.ROOT);
        return upperCase.endsWith(".COM") || upperCase.endsWith(".EDU") || upperCase.endsWith(".NET") || upperCase.endsWith(".GOV") || upperCase.endsWith(".MIL") || upperCase.endsWith(".ORG") || upperCase.endsWith(".INT");
    }

    @Override // cz.msebera.android.httpclient.impl.cookie.BasicDomainHandler, cz.msebera.android.httpclient.cookie.CommonCookieAttributeHandler
    public String getAttributeName() {
        return ClientCookie.DOMAIN_ATTR;
    }

    @Override // cz.msebera.android.httpclient.impl.cookie.BasicDomainHandler, cz.msebera.android.httpclient.cookie.CookieAttributeHandler
    public boolean match(Cookie cookie, CookieOrigin cookieOrigin) {
        Args.notNull(cookie, "Cookie");
        Args.notNull(cookieOrigin, "Cookie origin");
        String host = cookieOrigin.getHost();
        String domain = cookie.getDomain();
        if (domain == null) {
            return false;
        }
        return host.endsWith(domain);
    }

    @Override // cz.msebera.android.httpclient.impl.cookie.BasicDomainHandler, cz.msebera.android.httpclient.cookie.CookieAttributeHandler
    public void parse(SetCookie setCookie, String str) throws MalformedCookieException {
        Args.notNull(setCookie, "Cookie");
        if (TextUtils.isBlank(str)) {
            throw new MalformedCookieException("Blank or null value for domain attribute");
        }
        setCookie.setDomain(str);
    }

    @Override // cz.msebera.android.httpclient.impl.cookie.BasicDomainHandler, cz.msebera.android.httpclient.cookie.CookieAttributeHandler
    public void validate(Cookie cookie, CookieOrigin cookieOrigin) throws CookieRestrictionViolationException {
        String host = cookieOrigin.getHost();
        String domain = cookie.getDomain();
        if (!host.equals(domain) && !BasicDomainHandler.domainMatch(domain, host)) {
            throw new CookieRestrictionViolationException(AbstractC0541b.m775q("Illegal domain attribute \"", domain, "\". Domain of origin: \"", host, "\""));
        }
        if (host.contains(Extension.DOT)) {
            int iCountTokens = new StringTokenizer(domain, Extension.DOT).countTokens();
            if (isSpecialDomain(domain)) {
                if (iCountTokens < 2) {
                    throw new CookieRestrictionViolationException(AbstractC0541b.m773o("Domain attribute \"", domain, "\" violates the Netscape cookie specification for special domains"));
                }
            } else if (iCountTokens < 3) {
                throw new CookieRestrictionViolationException(AbstractC0541b.m773o("Domain attribute \"", domain, "\" violates the Netscape cookie specification"));
            }
        }
    }
}
