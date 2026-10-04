package com.google.api.client.http;

import androidx.compose.runtime.AbstractC1974b;
import com.google.api.client.util.Charsets;
import com.google.api.client.util.IOUtils;
import com.google.api.client.util.LoggingInputStream;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.StringUtils;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class HttpResponse {
    private InputStream content;
    private final String contentEncoding;
    private int contentLoggingLimit;
    private boolean contentRead;
    private final String contentType;
    private boolean loggingEnabled;
    private final HttpMediaType mediaType;
    private final HttpRequest request;
    LowLevelHttpResponse response;
    private final int statusCode;
    private final String statusMessage;

    public HttpResponse(HttpRequest httpRequest, LowLevelHttpResponse lowLevelHttpResponse) {
        StringBuilder sbM1324q;
        this.request = httpRequest;
        this.contentLoggingLimit = httpRequest.getContentLoggingLimit();
        this.loggingEnabled = httpRequest.isLoggingEnabled();
        this.response = lowLevelHttpResponse;
        this.contentEncoding = lowLevelHttpResponse.getContentEncoding();
        int statusCode = lowLevelHttpResponse.getStatusCode();
        boolean z = false;
        statusCode = statusCode < 0 ? 0 : statusCode;
        this.statusCode = statusCode;
        String reasonPhrase = lowLevelHttpResponse.getReasonPhrase();
        this.statusMessage = reasonPhrase;
        Logger logger = HttpTransport.LOGGER;
        if (this.loggingEnabled && logger.isLoggable(Level.CONFIG)) {
            z = true;
        }
        if (z) {
            sbM1324q = AbstractC1974b.m1324q("-------------- RESPONSE --------------");
            String str = StringUtils.LINE_SEPARATOR;
            sbM1324q.append(str);
            String statusLine = lowLevelHttpResponse.getStatusLine();
            if (statusLine != null) {
                sbM1324q.append(statusLine);
            } else {
                sbM1324q.append(statusCode);
                if (reasonPhrase != null) {
                    sbM1324q.append(' ');
                    sbM1324q.append(reasonPhrase);
                }
            }
            sbM1324q.append(str);
        } else {
            sbM1324q = null;
        }
        httpRequest.getResponseHeaders().fromHttpResponse(lowLevelHttpResponse, z ? sbM1324q : null);
        String contentType = lowLevelHttpResponse.getContentType();
        contentType = contentType == null ? httpRequest.getResponseHeaders().getContentType() : contentType;
        this.contentType = contentType;
        this.mediaType = contentType != null ? new HttpMediaType(contentType) : null;
        if (z) {
            logger.config(sbM1324q.toString());
        }
    }

    private boolean hasMessageBody() {
        int statusCode = getStatusCode();
        if (!getRequest().getRequestMethod().equals("HEAD") && statusCode / 100 != 1 && statusCode != 204 && statusCode != 304) {
            return true;
        }
        ignore();
        return false;
    }

    public void disconnect() {
        ignore();
        this.response.disconnect();
    }

    public void download(OutputStream outputStream) throws IOException {
        IOUtils.copy(getContent(), outputStream);
    }

    public InputStream getContent() throws IOException {
        if (!this.contentRead) {
            InputStream content = this.response.getContent();
            if (content != null) {
                try {
                    String str = this.contentEncoding;
                    if (str != null && str.contains("gzip")) {
                        content = new GZIPInputStream(content);
                    }
                    Logger logger = HttpTransport.LOGGER;
                    if (this.loggingEnabled) {
                        Level level = Level.CONFIG;
                        if (logger.isLoggable(level)) {
                            content = new LoggingInputStream(content, logger, level, this.contentLoggingLimit);
                        }
                    }
                    this.content = content;
                } catch (EOFException unused) {
                    content.close();
                } catch (Throwable th) {
                    content.close();
                    throw th;
                }
            }
            this.contentRead = true;
        }
        return this.content;
    }

    public Charset getContentCharset() {
        HttpMediaType httpMediaType = this.mediaType;
        return (httpMediaType == null || httpMediaType.getCharsetParameter() == null) ? Charsets.ISO_8859_1 : this.mediaType.getCharsetParameter();
    }

    public String getContentEncoding() {
        return this.contentEncoding;
    }

    public int getContentLoggingLimit() {
        return this.contentLoggingLimit;
    }

    public String getContentType() {
        return this.contentType;
    }

    public HttpHeaders getHeaders() {
        return this.request.getResponseHeaders();
    }

    public HttpMediaType getMediaType() {
        return this.mediaType;
    }

    public HttpRequest getRequest() {
        return this.request;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getStatusMessage() {
        return this.statusMessage;
    }

    public HttpTransport getTransport() {
        return this.request.getTransport();
    }

    public void ignore() {
        InputStream content = getContent();
        if (content != null) {
            content.close();
        }
    }

    public boolean isLoggingEnabled() {
        return this.loggingEnabled;
    }

    public boolean isSuccessStatusCode() {
        return HttpStatusCodes.isSuccess(this.statusCode);
    }

    public <T> T parseAs(Class<T> cls) {
        if (hasMessageBody()) {
            return (T) this.request.getParser().parseAndClose(getContent(), getContentCharset(), (Class) cls);
        }
        return null;
    }

    public String parseAsString() throws IOException {
        InputStream content = getContent();
        if (content == null) {
            return "";
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        IOUtils.copy(content, byteArrayOutputStream);
        return byteArrayOutputStream.toString(getContentCharset().name());
    }

    public HttpResponse setContentLoggingLimit(int i) {
        Preconditions.checkArgument(i >= 0, "The content logging limit must be non-negative.");
        this.contentLoggingLimit = i;
        return this;
    }

    public HttpResponse setLoggingEnabled(boolean z) {
        this.loggingEnabled = z;
        return this;
    }

    public Object parseAs(Type type) {
        if (hasMessageBody()) {
            return this.request.getParser().parseAndClose(getContent(), getContentCharset(), type);
        }
        return null;
    }
}
