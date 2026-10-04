package org.apache.http.client.entity;

import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.entity.AbstractHttpEntityHC4;
import org.apache.http.entity.BasicHttpEntityHC4;
import org.apache.http.entity.ByteArrayEntityHC4;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.FileEntityHC4;
import org.apache.http.entity.InputStreamEntityHC4;
import org.apache.http.entity.SerializableEntityHC4;
import org.apache.http.entity.StringEntityHC4;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@NotThreadSafe
public class EntityBuilder {
    private byte[] binary;
    private boolean chunked;
    private String contentEncoding;
    private ContentType contentType;
    private File file;
    private boolean gzipCompress;
    private List<NameValuePair> parameters;
    private Serializable serializable;
    private InputStream stream;
    private String text;

    private void clearContent() {
        this.text = null;
        this.binary = null;
        this.stream = null;
        this.parameters = null;
        this.serializable = null;
        this.file = null;
    }

    public static EntityBuilder create() {
        return new EntityBuilder();
    }

    private ContentType getContentOrDefault(ContentType contentType) {
        ContentType contentType2 = this.contentType;
        return contentType2 != null ? contentType2 : contentType;
    }

    public HttpEntity build() {
        AbstractHttpEntityHC4 fileEntityHC4;
        ContentType contentType;
        String str = this.text;
        if (str != null) {
            fileEntityHC4 = new StringEntityHC4(str, getContentOrDefault(ContentType.DEFAULT_TEXT));
        } else {
            byte[] bArr = this.binary;
            if (bArr != null) {
                fileEntityHC4 = new ByteArrayEntityHC4(bArr, getContentOrDefault(ContentType.DEFAULT_BINARY));
            } else {
                InputStream inputStream = this.stream;
                if (inputStream != null) {
                    fileEntityHC4 = new InputStreamEntityHC4(inputStream, 1L, getContentOrDefault(ContentType.DEFAULT_BINARY));
                } else {
                    List<NameValuePair> list = this.parameters;
                    if (list != null) {
                        ContentType contentType2 = this.contentType;
                        fileEntityHC4 = new UrlEncodedFormEntityHC4(list, contentType2 != null ? contentType2.getCharset() : null);
                    } else {
                        Serializable serializable = this.serializable;
                        if (serializable != null) {
                            fileEntityHC4 = new SerializableEntityHC4(serializable);
                            fileEntityHC4.setContentType(ContentType.DEFAULT_BINARY.toString());
                        } else {
                            File file = this.file;
                            fileEntityHC4 = file != null ? new FileEntityHC4(file, getContentOrDefault(ContentType.DEFAULT_BINARY)) : new BasicHttpEntityHC4();
                        }
                    }
                }
            }
        }
        if (fileEntityHC4.getContentType() != null && (contentType = this.contentType) != null) {
            fileEntityHC4.setContentType(contentType.toString());
        }
        fileEntityHC4.setContentEncoding(this.contentEncoding);
        fileEntityHC4.setChunked(this.chunked);
        return this.gzipCompress ? new GzipCompressingEntity(fileEntityHC4) : fileEntityHC4;
    }

    public EntityBuilder chunked() {
        this.chunked = true;
        return this;
    }

    public byte[] getBinary() {
        return this.binary;
    }

    public String getContentEncoding() {
        return this.contentEncoding;
    }

    public ContentType getContentType() {
        return this.contentType;
    }

    public File getFile() {
        return this.file;
    }

    public List<NameValuePair> getParameters() {
        return this.parameters;
    }

    public Serializable getSerializable() {
        return this.serializable;
    }

    public InputStream getStream() {
        return this.stream;
    }

    public String getText() {
        return this.text;
    }

    public EntityBuilder gzipCompress() {
        this.gzipCompress = true;
        return this;
    }

    public boolean isChunked() {
        return this.chunked;
    }

    public boolean isGzipCompress() {
        return this.gzipCompress;
    }

    public EntityBuilder setBinary(byte[] bArr) {
        clearContent();
        this.binary = bArr;
        return this;
    }

    public EntityBuilder setContentEncoding(String str) {
        this.contentEncoding = str;
        return this;
    }

    public EntityBuilder setContentType(ContentType contentType) {
        this.contentType = contentType;
        return this;
    }

    public EntityBuilder setFile(File file) {
        clearContent();
        this.file = file;
        return this;
    }

    public EntityBuilder setParameters(List<NameValuePair> list) {
        clearContent();
        this.parameters = list;
        return this;
    }

    public EntityBuilder setSerializable(Serializable serializable) {
        clearContent();
        this.serializable = serializable;
        return this;
    }

    public EntityBuilder setStream(InputStream inputStream) {
        clearContent();
        this.stream = inputStream;
        return this;
    }

    public EntityBuilder setText(String str) {
        clearContent();
        this.text = str;
        return this;
    }

    public EntityBuilder setParameters(NameValuePair... nameValuePairArr) {
        return setParameters(Arrays.asList(nameValuePairArr));
    }
}
