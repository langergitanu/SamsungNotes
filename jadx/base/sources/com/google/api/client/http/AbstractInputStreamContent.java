package com.google.api.client.http;

import com.google.api.client.util.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractInputStreamContent implements HttpContent {
    private boolean closeInputStream = true;
    private String type;

    public AbstractInputStreamContent(String str) {
        setType(str);
    }

    public final boolean getCloseInputStream() {
        return this.closeInputStream;
    }

    public abstract InputStream getInputStream();

    @Override // com.google.api.client.http.HttpContent
    public String getType() {
        return this.type;
    }

    public AbstractInputStreamContent setCloseInputStream(boolean z) {
        this.closeInputStream = z;
        return this;
    }

    public AbstractInputStreamContent setType(String str) {
        this.type = str;
        return this;
    }

    @Override // com.google.api.client.http.HttpContent, com.google.api.client.util.StreamingContent
    public void writeTo(OutputStream outputStream) throws IOException {
        IOUtils.copy(getInputStream(), outputStream, this.closeInputStream);
        outputStream.flush();
    }
}
