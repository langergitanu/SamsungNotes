package io.netty.handler.codec.http.cookie;

import androidx.appcompat.widget.AbstractC0541b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public abstract class CookieEncoder {
    protected final boolean strict;

    public CookieEncoder(boolean z) {
        this.strict = z;
    }

    public void validateCookie(String str, String str2) {
        if (this.strict) {
            int iFirstInvalidCookieNameOctet = CookieUtil.firstInvalidCookieNameOctet(str);
            if (iFirstInvalidCookieNameOctet >= 0) {
                throw new IllegalArgumentException("Cookie name contains an invalid char: " + str.charAt(iFirstInvalidCookieNameOctet));
            }
            CharSequence charSequenceUnwrapValue = CookieUtil.unwrapValue(str2);
            if (charSequenceUnwrapValue == null) {
                throw new IllegalArgumentException(AbstractC0541b.m772n("Cookie value wrapping quotes are not balanced: ", str2));
            }
            int iFirstInvalidCookieValueOctet = CookieUtil.firstInvalidCookieValueOctet(charSequenceUnwrapValue);
            if (iFirstInvalidCookieValueOctet < 0) {
                return;
            }
            throw new IllegalArgumentException("Cookie value contains an invalid char: " + charSequenceUnwrapValue.charAt(iFirstInvalidCookieValueOctet));
        }
    }
}
