package cz.msebera.android.httpclient.entity.mime;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
class HttpBrowserCompatibleMultipart extends AbstractMultipartForm {
    private final List<FormBodyPart> parts;

    public HttpBrowserCompatibleMultipart(Charset charset, String str, List<FormBodyPart> list) {
        super(charset, str);
        this.parts = list;
    }

    @Override // cz.msebera.android.httpclient.entity.mime.AbstractMultipartForm
    public void formatMultipartHeader(FormBodyPart formBodyPart, OutputStream outputStream) throws IOException {
        Header header = formBodyPart.getHeader();
        AbstractMultipartForm.writeField(header.getField("Content-Disposition"), this.charset, outputStream);
        if (formBodyPart.getBody().getFilename() != null) {
            AbstractMultipartForm.writeField(header.getField("Content-Type"), this.charset, outputStream);
        }
    }

    @Override // cz.msebera.android.httpclient.entity.mime.AbstractMultipartForm
    public List<FormBodyPart> getBodyParts() {
        return this.parts;
    }
}
