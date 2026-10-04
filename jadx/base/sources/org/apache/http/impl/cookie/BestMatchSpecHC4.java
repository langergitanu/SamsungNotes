package org.apache.http.impl.cookie;

import cz.msebera.android.httpclient.cookie.ClientCookie;
import java.util.List;
import org.apache.http.FormattedHeader;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.CookieSpec;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie2;
import org.apache.http.message.ParserCursor;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@NotThreadSafe
public class BestMatchSpecHC4 implements CookieSpec {
    private BrowserCompatSpecHC4 compat;
    private final String[] datepatterns;
    private RFC2109SpecHC4 obsoleteStrict;
    private final boolean oneHeader;
    private RFC2965SpecHC4 strict;

    public BestMatchSpecHC4(String[] strArr, boolean z) {
        this.datepatterns = strArr == null ? null : (String[]) strArr.clone();
        this.oneHeader = z;
    }

    private BrowserCompatSpecHC4 getCompat() {
        if (this.compat == null) {
            this.compat = new BrowserCompatSpecHC4(this.datepatterns);
        }
        return this.compat;
    }

    private RFC2109SpecHC4 getObsoleteStrict() {
        if (this.obsoleteStrict == null) {
            this.obsoleteStrict = new RFC2109SpecHC4(this.datepatterns, this.oneHeader);
        }
        return this.obsoleteStrict;
    }

    private RFC2965SpecHC4 getStrict() {
        if (this.strict == null) {
            this.strict = new RFC2965SpecHC4(this.datepatterns, this.oneHeader);
        }
        return this.strict;
    }

    @Override // org.apache.http.cookie.CookieSpec
    public List<Header> formatCookies(List<Cookie> list) {
        Args.notNull(list, "List of cookies");
        int version = Integer.MAX_VALUE;
        boolean z = true;
        for (Cookie cookie : list) {
            if (!(cookie instanceof SetCookie2)) {
                z = false;
            }
            if (cookie.getVersion() < version) {
                version = cookie.getVersion();
            }
        }
        return version > 0 ? z ? getStrict().formatCookies(list) : getObsoleteStrict().formatCookies(list) : getCompat().formatCookies(list);
    }

    @Override // org.apache.http.cookie.CookieSpec
    public int getVersion() {
        return getStrict().getVersion();
    }

    @Override // org.apache.http.cookie.CookieSpec
    public Header getVersionHeader() {
        return getStrict().getVersionHeader();
    }

    @Override // org.apache.http.cookie.CookieSpec
    public boolean match(Cookie cookie, CookieOrigin cookieOrigin) {
        Args.notNull(cookie, "Cookie");
        Args.notNull(cookieOrigin, "Cookie origin");
        return cookie.getVersion() > 0 ? cookie instanceof SetCookie2 ? getStrict().match(cookie, cookieOrigin) : getObsoleteStrict().match(cookie, cookieOrigin) : getCompat().match(cookie, cookieOrigin);
    }

    @Override // org.apache.http.cookie.CookieSpec
    public List<Cookie> parse(Header header, CookieOrigin cookieOrigin) throws MalformedCookieException {
        CharArrayBuffer charArrayBuffer;
        ParserCursor parserCursor;
        Args.notNull(header, "Header");
        Args.notNull(cookieOrigin, "Cookie origin");
        HeaderElement[] elements = header.getElements();
        boolean z = false;
        boolean z2 = false;
        for (HeaderElement headerElement : elements) {
            if (headerElement.getParameterByName("version") != null) {
                z2 = true;
            }
            if (headerElement.getParameterByName(ClientCookie.EXPIRES_ATTR) != null) {
                z = true;
            }
        }
        if (!z && z2) {
            return "Set-Cookie2".equals(header.getName()) ? getStrict().parse(elements, cookieOrigin) : getObsoleteStrict().parse(elements, cookieOrigin);
        }
        NetscapeDraftHeaderParserHC4 netscapeDraftHeaderParserHC4 = NetscapeDraftHeaderParserHC4.DEFAULT;
        if (header instanceof FormattedHeader) {
            FormattedHeader formattedHeader = (FormattedHeader) header;
            charArrayBuffer = formattedHeader.getBuffer();
            parserCursor = new ParserCursor(formattedHeader.getValuePos(), charArrayBuffer.length());
        } else {
            String value = header.getValue();
            if (value == null) {
                throw new MalformedCookieException("Header value is null");
            }
            charArrayBuffer = new CharArrayBuffer(value.length());
            charArrayBuffer.append(value);
            parserCursor = new ParserCursor(0, charArrayBuffer.length());
        }
        return getCompat().parse(new HeaderElement[]{netscapeDraftHeaderParserHC4.parseHeader(charArrayBuffer, parserCursor)}, cookieOrigin);
    }

    public String toString() {
        return "best-match";
    }

    @Override // org.apache.http.cookie.CookieSpec
    public void validate(Cookie cookie, CookieOrigin cookieOrigin) throws MalformedCookieException {
        Args.notNull(cookie, "Cookie");
        Args.notNull(cookieOrigin, "Cookie origin");
        if (cookie.getVersion() <= 0) {
            getCompat().validate(cookie, cookieOrigin);
        } else if (cookie instanceof SetCookie2) {
            getStrict().validate(cookie, cookieOrigin);
        } else {
            getObsoleteStrict().validate(cookie, cookieOrigin);
        }
    }

    public BestMatchSpecHC4() {
        this(null, false);
    }
}
