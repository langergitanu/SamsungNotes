package org.apache.http.entity.mime;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Deprecated
public class HttpMultipart extends AbstractMultipartForm {
    private static /* synthetic */ int[] $SWITCH_TABLE$org$apache$http$entity$mime$HttpMultipartMode;
    private final HttpMultipartMode mode;
    private final List<FormBodyPart> parts;

    public static /* synthetic */ int[] $SWITCH_TABLE$org$apache$http$entity$mime$HttpMultipartMode() {
        int[] iArr = $SWITCH_TABLE$org$apache$http$entity$mime$HttpMultipartMode;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[HttpMultipartMode.valuesCustom().length];
        try {
            iArr2[HttpMultipartMode.BROWSER_COMPATIBLE.ordinal()] = 2;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[HttpMultipartMode.RFC6532.ordinal()] = 3;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[HttpMultipartMode.STRICT.ordinal()] = 1;
        } catch (NoSuchFieldError unused3) {
        }
        $SWITCH_TABLE$org$apache$http$entity$mime$HttpMultipartMode = iArr2;
        return iArr2;
    }

    public HttpMultipart(String str, Charset charset, String str2, HttpMultipartMode httpMultipartMode) {
        super(str, charset, str2);
        this.mode = httpMultipartMode;
        this.parts = new ArrayList();
    }

    public void addBodyPart(FormBodyPart formBodyPart) {
        if (formBodyPart == null) {
            return;
        }
        this.parts.add(formBodyPart);
    }

    @Override // org.apache.http.entity.mime.AbstractMultipartForm
    public void formatMultipartHeader(FormBodyPart formBodyPart, OutputStream outputStream) throws IOException {
        Header header = formBodyPart.getHeader();
        if ($SWITCH_TABLE$org$apache$http$entity$mime$HttpMultipartMode()[this.mode.ordinal()] != 2) {
            Iterator<MinimalField> it = header.iterator();
            while (it.hasNext()) {
                AbstractMultipartForm.writeField(it.next(), outputStream);
            }
        } else {
            AbstractMultipartForm.writeField(header.getField("Content-Disposition"), this.charset, outputStream);
            if (formBodyPart.getBody().getFilename() != null) {
                AbstractMultipartForm.writeField(header.getField("Content-Type"), this.charset, outputStream);
            }
        }
    }

    @Override // org.apache.http.entity.mime.AbstractMultipartForm
    public List<FormBodyPart> getBodyParts() {
        return this.parts;
    }

    @Override // org.apache.http.entity.mime.AbstractMultipartForm
    public /* bridge */ /* synthetic */ String getBoundary() {
        return super.getBoundary();
    }

    @Override // org.apache.http.entity.mime.AbstractMultipartForm
    public /* bridge */ /* synthetic */ Charset getCharset() {
        return super.getCharset();
    }

    public HttpMultipartMode getMode() {
        return this.mode;
    }

    @Override // org.apache.http.entity.mime.AbstractMultipartForm
    public /* bridge */ /* synthetic */ String getSubType() {
        return super.getSubType();
    }

    @Override // org.apache.http.entity.mime.AbstractMultipartForm
    public /* bridge */ /* synthetic */ long getTotalLength() {
        return super.getTotalLength();
    }

    @Override // org.apache.http.entity.mime.AbstractMultipartForm
    public /* bridge */ /* synthetic */ void writeTo(OutputStream outputStream) throws IOException {
        super.writeTo(outputStream);
    }

    public HttpMultipart(String str, Charset charset, String str2) {
        this(str, charset, str2, HttpMultipartMode.STRICT);
    }

    public HttpMultipart(String str, String str2) {
        this(str, null, str2);
    }
}
