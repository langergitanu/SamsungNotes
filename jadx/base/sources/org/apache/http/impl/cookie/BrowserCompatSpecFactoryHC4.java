package org.apache.http.impl.cookie;

import cz.msebera.android.httpclient.cookie.params.CookieSpecPNames;
import java.util.Collection;
import org.apache.http.annotation.Immutable;
import org.apache.http.cookie.CookieSpec;
import org.apache.http.cookie.CookieSpecFactory;
import org.apache.http.cookie.CookieSpecProvider;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Immutable
public class BrowserCompatSpecFactoryHC4 implements CookieSpecFactory, CookieSpecProvider {
    private final String[] datepatterns;
    private final SecurityLevel securityLevel;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum SecurityLevel {
        SECURITYLEVEL_DEFAULT,
        SECURITYLEVEL_IE_MEDIUM;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static SecurityLevel[] valuesCustom() {
            SecurityLevel[] securityLevelArrValuesCustom = values();
            int length = securityLevelArrValuesCustom.length;
            SecurityLevel[] securityLevelArr = new SecurityLevel[length];
            System.arraycopy(securityLevelArrValuesCustom, 0, securityLevelArr, 0, length);
            return securityLevelArr;
        }
    }

    public BrowserCompatSpecFactoryHC4(String[] strArr, SecurityLevel securityLevel) {
        this.datepatterns = strArr;
        this.securityLevel = securityLevel;
    }

    @Override // org.apache.http.cookie.CookieSpecProvider
    public CookieSpec create(HttpContext httpContext) {
        return new BrowserCompatSpecHC4(this.datepatterns);
    }

    @Override // org.apache.http.cookie.CookieSpecFactory
    public CookieSpec newInstance(HttpParams httpParams) {
        if (httpParams == null) {
            return new BrowserCompatSpecHC4(null, this.securityLevel);
        }
        Collection collection = (Collection) httpParams.getParameter(CookieSpecPNames.DATE_PATTERNS);
        return new BrowserCompatSpecHC4(collection != null ? (String[]) collection.toArray(new String[collection.size()]) : null, this.securityLevel);
    }

    public BrowserCompatSpecFactoryHC4(String[] strArr) {
        this(null, SecurityLevel.SECURITYLEVEL_DEFAULT);
    }

    public BrowserCompatSpecFactoryHC4() {
        this(null, SecurityLevel.SECURITYLEVEL_DEFAULT);
    }
}
