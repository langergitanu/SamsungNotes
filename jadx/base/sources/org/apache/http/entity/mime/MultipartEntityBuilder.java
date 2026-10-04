package org.apache.http.entity.mime;

import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import cz.msebera.android.httpclient.protocol.HTTP;
import java.io.File;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.InputStreamBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.util.Args;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class MultipartEntityBuilder {
    private static /* synthetic */ int[] $SWITCH_TABLE$org$apache$http$entity$mime$HttpMultipartMode = null;
    private static final String DEFAULT_SUBTYPE = "form-data";
    private static final char[] MULTIPART_CHARS = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private String subType = DEFAULT_SUBTYPE;
    private HttpMultipartMode mode = HttpMultipartMode.STRICT;
    private String boundary = null;
    private Charset charset = null;
    private List<FormBodyPart> bodyParts = null;

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

    public static MultipartEntityBuilder create() {
        return new MultipartEntityBuilder();
    }

    private String generateBoundary() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int iNextInt = random.nextInt(11) + 30;
        for (int i = 0; i < iNextInt; i++) {
            char[] cArr = MULTIPART_CHARS;
            sb.append(cArr[random.nextInt(cArr.length)]);
        }
        return sb.toString();
    }

    private String generateContentType(String str, Charset charset) {
        StringBuilder sbM12325j = AbstractC11014a.m12325j("multipart/form-data; boundary=", str);
        if (charset != null) {
            sbM12325j.append(HTTP.CHARSET_PARAM);
            sbM12325j.append(charset.name());
        }
        return sbM12325j.toString();
    }

    public MultipartEntityBuilder addBinaryBody(String str, byte[] bArr, ContentType contentType, String str2) {
        return addPart(str, new ByteArrayBody(bArr, contentType, str2));
    }

    public MultipartEntityBuilder addPart(FormBodyPart formBodyPart) {
        if (formBodyPart == null) {
            return this;
        }
        if (this.bodyParts == null) {
            this.bodyParts = new ArrayList();
        }
        this.bodyParts.add(formBodyPart);
        return this;
    }

    public MultipartEntityBuilder addTextBody(String str, String str2, ContentType contentType) {
        return addPart(str, new StringBody(str2, contentType));
    }

    public HttpEntity build() {
        return buildEntity();
    }

    public MultipartFormEntity buildEntity() {
        String str = this.subType;
        if (str == null) {
            str = DEFAULT_SUBTYPE;
        }
        Charset charset = this.charset;
        String strGenerateBoundary = this.boundary;
        if (strGenerateBoundary == null) {
            strGenerateBoundary = generateBoundary();
        }
        List arrayList = this.bodyParts != null ? new ArrayList(this.bodyParts) : Collections.EMPTY_LIST;
        HttpMultipartMode httpMultipartMode = this.mode;
        if (httpMultipartMode == null) {
            httpMultipartMode = HttpMultipartMode.STRICT;
        }
        int i = $SWITCH_TABLE$org$apache$http$entity$mime$HttpMultipartMode()[httpMultipartMode.ordinal()];
        AbstractMultipartForm httpStrictMultipart = i != 2 ? i != 3 ? new HttpStrictMultipart(str, charset, strGenerateBoundary, arrayList) : new HttpRFC6532Multipart(str, charset, strGenerateBoundary, arrayList) : new HttpBrowserCompatibleMultipart(str, charset, strGenerateBoundary, arrayList);
        return new MultipartFormEntity(httpStrictMultipart, generateContentType(strGenerateBoundary, charset), httpStrictMultipart.getTotalLength());
    }

    public MultipartEntityBuilder setBoundary(String str) {
        this.boundary = str;
        return this;
    }

    public MultipartEntityBuilder setCharset(Charset charset) {
        this.charset = charset;
        return this;
    }

    public MultipartEntityBuilder setLaxMode() {
        this.mode = HttpMultipartMode.BROWSER_COMPATIBLE;
        return this;
    }

    public MultipartEntityBuilder setMode(HttpMultipartMode httpMultipartMode) {
        this.mode = httpMultipartMode;
        return this;
    }

    public MultipartEntityBuilder setStrictMode() {
        this.mode = HttpMultipartMode.STRICT;
        return this;
    }

    public MultipartEntityBuilder addBinaryBody(String str, byte[] bArr) {
        return addBinaryBody(str, bArr, ContentType.DEFAULT_BINARY, (String) null);
    }

    public MultipartEntityBuilder addTextBody(String str, String str2) {
        return addTextBody(str, str2, ContentType.DEFAULT_TEXT);
    }

    public MultipartEntityBuilder addBinaryBody(String str, File file, ContentType contentType, String str2) {
        return addPart(str, new FileBody(file, contentType, str2));
    }

    public MultipartEntityBuilder addBinaryBody(String str, File file) {
        return addBinaryBody(str, file, ContentType.DEFAULT_BINARY, file != null ? file.getName() : null);
    }

    public MultipartEntityBuilder addPart(String str, ContentBody contentBody) {
        Args.notNull(str, "Name");
        Args.notNull(contentBody, "Content body");
        return addPart(new FormBodyPart(str, contentBody));
    }

    public MultipartEntityBuilder addBinaryBody(String str, InputStream inputStream, ContentType contentType, String str2) {
        return addPart(str, new InputStreamBody(inputStream, contentType, str2));
    }

    public MultipartEntityBuilder addBinaryBody(String str, InputStream inputStream) {
        return addBinaryBody(str, inputStream, ContentType.DEFAULT_BINARY, (String) null);
    }
}
