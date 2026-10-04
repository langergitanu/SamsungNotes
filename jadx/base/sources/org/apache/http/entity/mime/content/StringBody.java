package org.apache.http.entity.mime.content;

import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import org.apache.http.Consts;
import org.apache.http.entity.ContentType;
import org.apache.http.util.Args;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class StringBody extends AbstractContentBody {
    private final byte[] content;

    @Deprecated
    public StringBody(String str, String str2, Charset charset) {
        this(str, ContentType.create(str2, charset));
    }

    @Deprecated
    public static StringBody create(String str, String str2, Charset charset) {
        try {
            return new StringBody(str, str2, charset);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException("Charset " + charset + " is not supported", e);
        }
    }

    @Override // org.apache.http.entity.mime.content.ContentDescriptor
    public long getContentLength() {
        return this.content.length;
    }

    @Override // org.apache.http.entity.mime.content.ContentBody
    public String getFilename() {
        return null;
    }

    public Reader getReader() {
        Charset charset = getContentType().getCharset();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.content);
        if (charset == null) {
            charset = Consts.ASCII;
        }
        return new InputStreamReader(byteArrayInputStream, charset);
    }

    @Override // org.apache.http.entity.mime.content.ContentDescriptor
    public String getTransferEncoding() {
        return "8bit";
    }

    @Override // org.apache.http.entity.mime.content.ContentBody
    public void writeTo(OutputStream outputStream) throws IOException {
        Args.notNull(outputStream, "Output stream");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.content);
        byte[] bArr = new byte[4096];
        while (true) {
            int i = byteArrayInputStream.read(bArr);
            if (i == -1) {
                outputStream.flush();
                return;
            }
            outputStream.write(bArr, 0, i);
        }
    }

    @Deprecated
    public StringBody(String str, Charset charset) {
        this(str, "text/plain", charset);
    }

    @Deprecated
    public StringBody(String str) {
        this(str, "text/plain", Consts.ASCII);
    }

    @Deprecated
    public static StringBody create(String str, Charset charset) {
        return create(str, null, charset);
    }

    public StringBody(String str, ContentType contentType) {
        super(contentType);
        Args.notNull(str, Bixby2Constants.SLOT_VALUE_SHARE_AS_TEXT);
        Charset charset = contentType.getCharset();
        String strName = (charset == null ? Consts.ASCII : charset).name();
        try {
            this.content = str.getBytes(strName);
        } catch (UnsupportedEncodingException unused) {
            throw new UnsupportedCharsetException(strName);
        }
    }

    @Deprecated
    public static StringBody create(String str) {
        return create(str, null, null);
    }
}
