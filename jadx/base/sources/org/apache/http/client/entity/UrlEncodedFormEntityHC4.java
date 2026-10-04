package org.apache.http.client.entity;

import java.nio.charset.Charset;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.client.utils.URLEncodedUtilsHC4;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntityHC4;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@NotThreadSafe
public class UrlEncodedFormEntityHC4 extends StringEntityHC4 {
    public UrlEncodedFormEntityHC4(List<? extends NameValuePair> list, String str) {
        super(URLEncodedUtilsHC4.format(list, str != null ? str : Charset.forName("ISO-8859-1").name()), ContentType.create("application/x-www-form-urlencoded", str));
    }

    public UrlEncodedFormEntityHC4(Iterable<? extends NameValuePair> iterable, Charset charset) {
        super(URLEncodedUtilsHC4.format(iterable, charset != null ? charset : Charset.forName("ISO-8859-1")), ContentType.create("application/x-www-form-urlencoded", charset));
    }

    public UrlEncodedFormEntityHC4(List<? extends NameValuePair> list) {
        this(list, (Charset) null);
    }

    public UrlEncodedFormEntityHC4(Iterable<? extends NameValuePair> iterable) {
        this(iterable, (Charset) null);
    }
}
