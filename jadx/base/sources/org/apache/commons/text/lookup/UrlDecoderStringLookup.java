package org.apache.commons.text.lookup;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
final class UrlDecoderStringLookup extends AbstractStringLookup {
    static final UrlDecoderStringLookup INSTANCE = new UrlDecoderStringLookup();

    private UrlDecoderStringLookup() {
    }

    public String decode(String str, String str2) {
        return URLDecoder.decode(str, str2);
    }

    @Override // org.apache.commons.text.lookup.StringLookup
    public String lookup(String str) {
        if (str == null) {
            return null;
        }
        String strName = StandardCharsets.UTF_8.name();
        try {
            return decode(str, strName);
        } catch (UnsupportedEncodingException e) {
            throw IllegalArgumentExceptions.format(e, "%s: source=%s, encoding=%s", e, str, strName);
        }
    }
}
