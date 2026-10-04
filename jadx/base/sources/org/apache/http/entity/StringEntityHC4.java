package org.apache.http.entity;

import cz.msebera.android.httpclient.protocol.HTTP;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.util.Args;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@NotThreadSafe
public class StringEntityHC4 extends AbstractHttpEntityHC4 implements Cloneable {
    protected final byte[] content;

    public StringEntityHC4(String str, ContentType contentType) {
        Args.notNull(str, "Source string");
        Charset charset = contentType != null ? contentType.getCharset() : null;
        charset = charset == null ? Charset.forName("ISO-8859-1") : charset;
        try {
            this.content = str.getBytes(charset.name());
            if (contentType != null) {
                setContentType(contentType.toString());
            }
        } catch (UnsupportedEncodingException unused) {
            throw new UnsupportedCharsetException(charset.name());
        }
    }

    public Object clone() {
        return super.clone();
    }

    @Override // org.apache.http.HttpEntity
    public InputStream getContent() {
        return new ByteArrayInputStream(this.content);
    }

    @Override // org.apache.http.HttpEntity
    public long getContentLength() {
        return this.content.length;
    }

    @Override // org.apache.http.HttpEntity
    public boolean isRepeatable() {
        return true;
    }

    @Override // org.apache.http.HttpEntity
    public boolean isStreaming() {
        return false;
    }

    @Override // org.apache.http.HttpEntity
    public void writeTo(OutputStream outputStream) throws IOException {
        Args.notNull(outputStream, "Output stream");
        outputStream.write(this.content);
        outputStream.flush();
    }

    @Deprecated
    public StringEntityHC4(String str, String str2, String str3) {
        Args.notNull(str, "Source string");
        str2 = str2 == null ? "text/plain" : str2;
        str3 = str3 == null ? "ISO-8859-1" : str3;
        this.content = str.getBytes(str3);
        setContentType(str2 + HTTP.CHARSET_PARAM + str3);
    }

    public StringEntityHC4(String str, String str2) {
        this(str, ContentType.create(ContentType.TEXT_PLAIN.getMimeType(), str2));
    }

    public StringEntityHC4(String str, Charset charset) {
        this(str, ContentType.create(ContentType.TEXT_PLAIN.getMimeType(), charset));
    }

    public StringEntityHC4(String str) {
        this(str, ContentType.DEFAULT_TEXT);
    }
}
