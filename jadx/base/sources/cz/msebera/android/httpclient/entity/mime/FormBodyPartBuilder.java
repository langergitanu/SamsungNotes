package cz.msebera.android.httpclient.entity.mime;

import cz.msebera.android.httpclient.entity.ContentType;
import cz.msebera.android.httpclient.entity.mime.content.AbstractContentBody;
import cz.msebera.android.httpclient.entity.mime.content.ContentBody;
import cz.msebera.android.httpclient.protocol.HTTP;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.Asserts;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class FormBodyPartBuilder {
    private ContentBody body;
    private final Header header;
    private String name;

    public FormBodyPartBuilder(String str, ContentBody contentBody) {
        this();
        this.name = str;
        this.body = contentBody;
    }

    public static FormBodyPartBuilder create(String str, ContentBody contentBody) {
        return new FormBodyPartBuilder(str, contentBody);
    }

    private static String encodeForHeader(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '\"' || cCharAt == '\\' || cCharAt == '\r') {
                sb.append("\\");
            }
            sb.append(cCharAt);
        }
        return sb.toString();
    }

    public FormBodyPartBuilder addField(String str, String str2) {
        Args.notNull(str, "Field name");
        this.header.addField(new MinimalField(str, str2));
        return this;
    }

    public FormBodyPart build() {
        Asserts.notBlank(this.name, "Name");
        Asserts.notNull(this.body, "Content body");
        Header header = new Header();
        Iterator<MinimalField> it = this.header.getFields().iterator();
        while (it.hasNext()) {
            header.addField(it.next());
        }
        if (header.getField("Content-Disposition") == null) {
            StringBuilder sb = new StringBuilder("form-data; name=\"");
            sb.append(encodeForHeader(this.name));
            sb.append("\"");
            if (this.body.getFilename() != null) {
                sb.append("; filename=\"");
                sb.append(encodeForHeader(this.body.getFilename()));
                sb.append("\"");
            }
            header.addField(new MinimalField("Content-Disposition", sb.toString()));
        }
        if (header.getField("Content-Type") == null) {
            ContentBody contentBody = this.body;
            ContentType contentType = contentBody instanceof AbstractContentBody ? ((AbstractContentBody) contentBody).getContentType() : null;
            if (contentType != null) {
                header.addField(new MinimalField("Content-Type", contentType.toString()));
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.body.getMimeType());
                if (this.body.getCharset() != null) {
                    sb2.append(HTTP.CHARSET_PARAM);
                    sb2.append(this.body.getCharset());
                }
                header.addField(new MinimalField("Content-Type", sb2.toString()));
            }
        }
        if (header.getField("Content-Transfer-Encoding") == null) {
            header.addField(new MinimalField("Content-Transfer-Encoding", this.body.getTransferEncoding()));
        }
        return new FormBodyPart(this.name, this.body, header);
    }

    public FormBodyPartBuilder removeFields(String str) {
        Args.notNull(str, "Field name");
        this.header.removeFields(str);
        return this;
    }

    public FormBodyPartBuilder setBody(ContentBody contentBody) {
        this.body = contentBody;
        return this;
    }

    public FormBodyPartBuilder setField(String str, String str2) {
        Args.notNull(str, "Field name");
        this.header.setField(new MinimalField(str, str2));
        return this;
    }

    public FormBodyPartBuilder setName(String str) {
        this.name = str;
        return this;
    }

    public static FormBodyPartBuilder create() {
        return new FormBodyPartBuilder();
    }

    public FormBodyPartBuilder() {
        this.header = new Header();
    }
}
