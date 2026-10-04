package io.netty.handler.codec.http.cookie;

import cz.msebera.android.httpclient.cookie.ClientCookie;
import io.netty.handler.codec.http.cookie.CookieHeaderNames;
import io.netty.util.internal.ObjectUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class DefaultCookie implements Cookie {
    private String domain;
    private boolean httpOnly;
    private long maxAge = Long.MIN_VALUE;
    private final String name;
    private String path;
    private CookieHeaderNames.SameSite sameSite;
    private boolean secure;
    private String value;
    private boolean wrap;

    public DefaultCookie(String str, String str2) {
        this.name = ObjectUtil.checkNonEmptyAfterTrim(str, "name");
        setValue(str2);
    }

    @Override // io.netty.handler.codec.http.cookie.Cookie
    public String domain() {
        return this.domain;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Cookie)) {
            return false;
        }
        Cookie cookie = (Cookie) obj;
        if (!name().equals(cookie.name())) {
            return false;
        }
        if (path() == null) {
            if (cookie.path() != null) {
                return false;
            }
        } else if (cookie.path() == null || !path().equals(cookie.path())) {
            return false;
        }
        return domain() == null ? cookie.domain() == null : domain().equalsIgnoreCase(cookie.domain());
    }

    public int hashCode() {
        return name().hashCode();
    }

    @Override // io.netty.handler.codec.http.cookie.Cookie
    public boolean isHttpOnly() {
        return this.httpOnly;
    }

    @Override // io.netty.handler.codec.http.cookie.Cookie
    public boolean isSecure() {
        return this.secure;
    }

    @Override // io.netty.handler.codec.http.cookie.Cookie
    public long maxAge() {
        return this.maxAge;
    }

    @Override // io.netty.handler.codec.http.cookie.Cookie
    public String name() {
        return this.name;
    }

    @Override // io.netty.handler.codec.http.cookie.Cookie
    public String path() {
        return this.path;
    }

    public CookieHeaderNames.SameSite sameSite() {
        return this.sameSite;
    }

    @Override // io.netty.handler.codec.http.cookie.Cookie
    public void setDomain(String str) {
        this.domain = CookieUtil.validateAttributeValue(ClientCookie.DOMAIN_ATTR, str);
    }

    @Override // io.netty.handler.codec.http.cookie.Cookie
    public void setHttpOnly(boolean z) {
        this.httpOnly = z;
    }

    @Override // io.netty.handler.codec.http.cookie.Cookie
    public void setMaxAge(long j) {
        this.maxAge = j;
    }

    @Override // io.netty.handler.codec.http.cookie.Cookie
    public void setPath(String str) {
        this.path = CookieUtil.validateAttributeValue("path", str);
    }

    public void setSameSite(CookieHeaderNames.SameSite sameSite) {
        this.sameSite = sameSite;
    }

    @Override // io.netty.handler.codec.http.cookie.Cookie
    public void setSecure(boolean z) {
        this.secure = z;
    }

    @Override // io.netty.handler.codec.http.cookie.Cookie
    public void setValue(String str) {
        this.value = (String) ObjectUtil.checkNotNull(str, "value");
    }

    @Override // io.netty.handler.codec.http.cookie.Cookie
    public void setWrap(boolean z) {
        this.wrap = z;
    }

    public String toString() {
        StringBuilder sbStringBuilder = CookieUtil.stringBuilder();
        sbStringBuilder.append(name());
        sbStringBuilder.append('=');
        sbStringBuilder.append(value());
        if (domain() != null) {
            sbStringBuilder.append(", domain=");
            sbStringBuilder.append(domain());
        }
        if (path() != null) {
            sbStringBuilder.append(", path=");
            sbStringBuilder.append(path());
        }
        if (maxAge() >= 0) {
            sbStringBuilder.append(", maxAge=");
            sbStringBuilder.append(maxAge());
            sbStringBuilder.append('s');
        }
        if (isSecure()) {
            sbStringBuilder.append(", secure");
        }
        if (isHttpOnly()) {
            sbStringBuilder.append(", HTTPOnly");
        }
        if (sameSite() != null) {
            sbStringBuilder.append(", SameSite=");
            sbStringBuilder.append(sameSite());
        }
        return sbStringBuilder.toString();
    }

    @Deprecated
    public String validateValue(String str, String str2) {
        return CookieUtil.validateAttributeValue(str, str2);
    }

    @Override // io.netty.handler.codec.http.cookie.Cookie
    public String value() {
        return this.value;
    }

    @Override // io.netty.handler.codec.http.cookie.Cookie
    public boolean wrap() {
        return this.wrap;
    }

    @Override // java.lang.Comparable
    public int compareTo(Cookie cookie) {
        int iCompareTo = name().compareTo(cookie.name());
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (path() == null) {
            if (cookie.path() != null) {
                return -1;
            }
        } else {
            if (cookie.path() == null) {
                return 1;
            }
            int iCompareTo2 = path().compareTo(cookie.path());
            if (iCompareTo2 != 0) {
                return iCompareTo2;
            }
        }
        if (domain() == null) {
            return cookie.domain() != null ? -1 : 0;
        }
        if (cookie.domain() == null) {
            return 1;
        }
        return domain().compareToIgnoreCase(cookie.domain());
    }
}
