package org.apache.http.entity.mime;

import cz.msebera.android.httpclient.protocol.HTTP;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.content.AbstractContentBody;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.util.Args;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class FormBodyPart {
    private final ContentBody body;
    private final Header header;
    private final String name;

    public FormBodyPart(String str, ContentBody contentBody) {
        Args.notNull(str, "Name");
        Args.notNull(contentBody, "Body");
        this.name = str;
        this.body = contentBody;
        this.header = new Header();
        generateContentDisp(contentBody);
        generateContentType(contentBody);
        generateTransferEncoding(contentBody);
    }

    public void addField(String str, String str2) {
        Args.notNull(str, "Field name");
        this.header.addField(new MinimalField(str, str2));
    }

    public void generateContentDisp(ContentBody contentBody) {
        StringBuilder sb = new StringBuilder("form-data; name=\"");
        sb.append(getName());
        sb.append("\"");
        if (contentBody.getFilename() != null) {
            sb.append("; filename=\"");
            sb.append(contentBody.getFilename());
            sb.append("\"");
        }
        addField("Content-Disposition", sb.toString());
    }

    public void generateContentType(ContentBody contentBody) {
        ContentType contentType = contentBody instanceof AbstractContentBody ? ((AbstractContentBody) contentBody).getContentType() : null;
        if (contentType != null) {
            addField("Content-Type", contentType.toString());
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(contentBody.getMimeType());
        if (contentBody.getCharset() != null) {
            sb.append(HTTP.CHARSET_PARAM);
            sb.append(contentBody.getCharset());
        }
        addField("Content-Type", sb.toString());
    }

    public void generateTransferEncoding(ContentBody contentBody) {
        addField("Content-Transfer-Encoding", contentBody.getTransferEncoding());
    }

    public ContentBody getBody() {
        return this.body;
    }

    public Header getHeader() {
        return this.header;
    }

    public String getName() {
        return this.name;
    }
}
