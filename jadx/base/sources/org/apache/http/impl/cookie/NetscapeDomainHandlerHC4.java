package org.apache.http.impl.cookie;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import java.util.Locale;
import java.util.StringTokenizer;
import org.apache.http.annotation.Immutable;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.CookieRestrictionViolationException;
import org.apache.http.util.Args;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Immutable
public class NetscapeDomainHandlerHC4 extends BasicDomainHandlerHC4 {
    private static boolean isSpecialDomain(String str) {
        String upperCase = str.toUpperCase(Locale.ENGLISH);
        return upperCase.endsWith(".COM") || upperCase.endsWith(".EDU") || upperCase.endsWith(".NET") || upperCase.endsWith(".GOV") || upperCase.endsWith(".MIL") || upperCase.endsWith(".ORG") || upperCase.endsWith(".INT");
    }

    @Override // org.apache.http.impl.cookie.BasicDomainHandlerHC4, org.apache.http.cookie.CookieAttributeHandler
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

    @Override // org.apache.http.impl.cookie.BasicDomainHandlerHC4, org.apache.http.cookie.CookieAttributeHandler
    public void validate(Cookie cookie, CookieOrigin cookieOrigin) throws CookieRestrictionViolationException {
        super.validate(cookie, cookieOrigin);
        String host = cookieOrigin.getHost();
        String domain = cookie.getDomain();
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
