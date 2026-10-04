package cz.msebera.android.httpclient.entity.mime.content;

import cz.msebera.android.httpclient.entity.ContentType;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class InputStreamBody extends AbstractContentBody {
    private final String filename;

    /* JADX INFO: renamed from: in */
    private final InputStream f8490in;

    @Deprecated
    public InputStreamBody(InputStream inputStream, String str, String str2) {
        this(inputStream, ContentType.create(str), str2);
    }

    @Override // cz.msebera.android.httpclient.entity.mime.content.ContentDescriptor
    public long getContentLength() {
        return -1L;
    }

    @Override // cz.msebera.android.httpclient.entity.mime.content.ContentBody
    public String getFilename() {
        return this.filename;
    }

    public InputStream getInputStream() {
        return this.f8490in;
    }

    @Override // cz.msebera.android.httpclient.entity.mime.content.ContentDescriptor
    public String getTransferEncoding() {
        return "binary";
    }

    @Override // cz.msebera.android.httpclient.entity.mime.content.ContentBody
    public void writeTo(OutputStream outputStream) throws IOException {
        Args.notNull(outputStream, "Output stream");
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int i = this.f8490in.read(bArr);
                if (i == -1) {
                    outputStream.flush();
                    this.f8490in.close();
                    return;
                }
                outputStream.write(bArr, 0, i);
            }
        } catch (Throwable th) {
            this.f8490in.close();
            throw th;
        }
    }

    public InputStreamBody(InputStream inputStream, String str) {
        this(inputStream, ContentType.DEFAULT_BINARY, str);
    }

    public InputStreamBody(InputStream inputStream, ContentType contentType, String str) {
        super(contentType);
        Args.notNull(inputStream, "Input stream");
        this.f8490in = inputStream;
        this.filename = str;
    }

    public InputStreamBody(InputStream inputStream, ContentType contentType) {
        this(inputStream, contentType, (String) null);
    }
}
