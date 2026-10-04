package org.apache.http.impl.cookie;

import java.util.Date;
import org.apache.http.annotation.Immutable;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;
import org.apache.http.util.Args;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Immutable
public class BasicExpiresHandlerHC4 extends AbstractCookieAttributeHandlerHC4 {
    private final String[] datepatterns;

    public BasicExpiresHandlerHC4(String[] strArr) {
        Args.notNull(strArr, "Array of date patterns");
        this.datepatterns = strArr;
    }

    @Override // org.apache.http.cookie.CookieAttributeHandler
    public void parse(SetCookie setCookie, String str) throws MalformedCookieException {
        Args.notNull(setCookie, "Cookie");
        if (str == null) {
            throw new MalformedCookieException("Missing value for expires attribute");
        }
        Date date = org.apache.http.client.utils.DateUtils.parseDate(str, this.datepatterns);
        if (date == null) {
            throw new MalformedCookieException("Unable to parse expires attribute: ".concat(str));
        }
        setCookie.setExpiryDate(date);
    }
}
