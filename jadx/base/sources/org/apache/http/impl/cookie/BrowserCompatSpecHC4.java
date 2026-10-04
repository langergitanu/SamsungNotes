package org.apache.http.impl.cookie;

import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import cz.msebera.android.httpclient.cookie.ClientCookie;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.FormattedHeader;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.impl.cookie.BrowserCompatSpecFactoryHC4;
import org.apache.http.message.BasicHeaderElement;
import org.apache.http.message.BasicHeaderValueFormatterHC4;
import org.apache.http.message.BufferedHeader;
import org.apache.http.message.ParserCursor;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@NotThreadSafe
public class BrowserCompatSpecHC4 extends CookieSpecBaseHC4 {

    /* JADX INFO: renamed from: $SWITCH_TABLE$org$apache$http$impl$cookie$BrowserCompatSpecFactoryHC4$SecurityLevel */
    private static /* synthetic */ int[] f10026x923f7435;
    private static final String[] DEFAULT_DATE_PATTERNS = {"EEE, dd MMM yyyy HH:mm:ss zzz", "EEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z"};
    private final String[] datepatterns;

    /* JADX INFO: renamed from: $SWITCH_TABLE$org$apache$http$impl$cookie$BrowserCompatSpecFactoryHC4$SecurityLevel */
    public static /* synthetic */ int[] m14967x923f7435() {
        int[] iArr = f10026x923f7435;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[BrowserCompatSpecFactoryHC4.SecurityLevel.valuesCustom().length];
        try {
            iArr2[BrowserCompatSpecFactoryHC4.SecurityLevel.SECURITYLEVEL_DEFAULT.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[BrowserCompatSpecFactoryHC4.SecurityLevel.SECURITYLEVEL_IE_MEDIUM.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        f10026x923f7435 = iArr2;
        return iArr2;
    }

    public BrowserCompatSpecHC4(String[] strArr, BrowserCompatSpecFactoryHC4.SecurityLevel securityLevel) {
        if (strArr != null) {
            this.datepatterns = (String[]) strArr.clone();
        } else {
            this.datepatterns = DEFAULT_DATE_PATTERNS;
        }
        int i = m14967x923f7435()[securityLevel.ordinal()];
        if (i == 1) {
            registerAttribHandler("path", new BasicPathHandlerHC4());
        } else {
            if (i != 2) {
                throw new RuntimeException("Unknown security level");
            }
            registerAttribHandler("path", new BasicPathHandlerHC4() { // from class: org.apache.http.impl.cookie.BrowserCompatSpecHC4.1
                @Override // org.apache.http.impl.cookie.BasicPathHandlerHC4, org.apache.http.cookie.CookieAttributeHandler
                public void validate(Cookie cookie, CookieOrigin cookieOrigin) {
                }
            });
        }
        registerAttribHandler(ClientCookie.DOMAIN_ATTR, new BasicDomainHandlerHC4());
        registerAttribHandler("max-age", new BasicMaxAgeHandlerHC4());
        registerAttribHandler(ClientCookie.SECURE_ATTR, new BasicSecureHandlerHC4());
        registerAttribHandler(ClientCookie.COMMENT_ATTR, new BasicCommentHandlerHC4());
        registerAttribHandler(ClientCookie.EXPIRES_ATTR, new BasicExpiresHandlerHC4(this.datepatterns));
        registerAttribHandler("version", new BrowserCompatVersionAttributeHandler());
    }

    private static boolean isQuoteEnclosed(String str) {
        return str != null && str.startsWith("\"") && str.endsWith("\"");
    }

    @Override // org.apache.http.cookie.CookieSpec
    public List<Header> formatCookies(List<Cookie> list) {
        Args.notEmpty(list, "List of cookies");
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(list.size() * 20);
        charArrayBuffer.append("Cookie");
        charArrayBuffer.append(": ");
        for (int i = 0; i < list.size(); i++) {
            Cookie cookie = list.get(i);
            if (i > 0) {
                charArrayBuffer.append("; ");
            }
            String name = cookie.getName();
            String value = cookie.getValue();
            if (cookie.getVersion() <= 0 || isQuoteEnclosed(value)) {
                charArrayBuffer.append(name);
                charArrayBuffer.append(MarketingConstants.REFERRER_DELIMITER_U003D);
                if (value != null) {
                    charArrayBuffer.append(value);
                }
            } else {
                BasicHeaderValueFormatterHC4.INSTANCE.formatHeaderElement(charArrayBuffer, (HeaderElement) new BasicHeaderElement(name, value), false);
            }
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new BufferedHeader(charArrayBuffer));
        return arrayList;
    }

    @Override // org.apache.http.cookie.CookieSpec
    public int getVersion() {
        return 0;
    }

    @Override // org.apache.http.cookie.CookieSpec
    public Header getVersionHeader() {
        return null;
    }

    @Override // org.apache.http.cookie.CookieSpec
    public List<Cookie> parse(Header header, CookieOrigin cookieOrigin) throws MalformedCookieException {
        CharArrayBuffer charArrayBuffer;
        ParserCursor parserCursor;
        Args.notNull(header, "Header");
        Args.notNull(cookieOrigin, "Cookie origin");
        if (!header.getName().equalsIgnoreCase("Set-Cookie")) {
            throw new MalformedCookieException("Unrecognized cookie header '" + header.toString() + "'");
        }
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
        if (z || !z2) {
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
            elements = new HeaderElement[]{netscapeDraftHeaderParserHC4.parseHeader(charArrayBuffer, parserCursor)};
        }
        return parse(elements, cookieOrigin);
    }

    public String toString() {
        return "compatibility";
    }

    public BrowserCompatSpecHC4(String[] strArr) {
        this(strArr, BrowserCompatSpecFactoryHC4.SecurityLevel.SECURITYLEVEL_DEFAULT);
    }

    public BrowserCompatSpecHC4() {
        this(null, BrowserCompatSpecFactoryHC4.SecurityLevel.SECURITYLEVEL_DEFAULT);
    }
}
