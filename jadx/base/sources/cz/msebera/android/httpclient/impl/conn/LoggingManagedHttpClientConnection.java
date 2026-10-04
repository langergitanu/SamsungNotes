package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.config.MessageConstraints;
import cz.msebera.android.httpclient.entity.ContentLengthStrategy;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.p172io.HttpMessageParserFactory;
import cz.msebera.android.httpclient.p172io.HttpMessageWriterFactory;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
class LoggingManagedHttpClientConnection extends DefaultManagedHttpClientConnection {
    private final HttpClientAndroidLog headerLog;
    private final HttpClientAndroidLog log;
    private final Wire wire;

    public LoggingManagedHttpClientConnection(String str, HttpClientAndroidLog httpClientAndroidLog, HttpClientAndroidLog httpClientAndroidLog2, HttpClientAndroidLog httpClientAndroidLog3, int i, int i2, CharsetDecoder charsetDecoder, CharsetEncoder charsetEncoder, MessageConstraints messageConstraints, ContentLengthStrategy contentLengthStrategy, ContentLengthStrategy contentLengthStrategy2, HttpMessageWriterFactory<HttpRequest> httpMessageWriterFactory, HttpMessageParserFactory<HttpResponse> httpMessageParserFactory) {
        super(str, i, i2, charsetDecoder, charsetEncoder, messageConstraints, contentLengthStrategy, contentLengthStrategy2, httpMessageWriterFactory, httpMessageParserFactory);
        this.log = httpClientAndroidLog;
        this.headerLog = httpClientAndroidLog2;
        this.wire = new Wire(httpClientAndroidLog3, str);
    }

    @Override // cz.msebera.android.httpclient.impl.BHttpConnectionBase, cz.msebera.android.httpclient.HttpConnection, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (super.isOpen()) {
            if (this.log.isDebugEnabled()) {
                this.log.debug(getId() + ": Close connection");
            }
            super.close();
        }
    }

    @Override // cz.msebera.android.httpclient.impl.BHttpConnectionBase
    public InputStream getSocketInputStream(Socket socket) {
        InputStream socketInputStream = super.getSocketInputStream(socket);
        return this.wire.enabled() ? new LoggingInputStream(socketInputStream, this.wire) : socketInputStream;
    }

    @Override // cz.msebera.android.httpclient.impl.BHttpConnectionBase
    public OutputStream getSocketOutputStream(Socket socket) {
        OutputStream socketOutputStream = super.getSocketOutputStream(socket);
        return this.wire.enabled() ? new LoggingOutputStream(socketOutputStream, this.wire) : socketOutputStream;
    }

    @Override // cz.msebera.android.httpclient.impl.DefaultBHttpClientConnection
    public void onRequestSubmitted(HttpRequest httpRequest) {
        if (httpRequest == null || !this.headerLog.isDebugEnabled()) {
            return;
        }
        this.headerLog.debug(getId() + " >> " + httpRequest.getRequestLine().toString());
        for (Header header : httpRequest.getAllHeaders()) {
            this.headerLog.debug(getId() + " >> " + header.toString());
        }
    }

    @Override // cz.msebera.android.httpclient.impl.DefaultBHttpClientConnection
    public void onResponseReceived(HttpResponse httpResponse) {
        if (httpResponse == null || !this.headerLog.isDebugEnabled()) {
            return;
        }
        this.headerLog.debug(getId() + " << " + httpResponse.getStatusLine().toString());
        for (Header header : httpResponse.getAllHeaders()) {
            this.headerLog.debug(getId() + " << " + header.toString());
        }
    }

    @Override // cz.msebera.android.httpclient.impl.BHttpConnectionBase, cz.msebera.android.httpclient.HttpConnection
    public void setSocketTimeout(int i) {
        if (this.log.isDebugEnabled()) {
            this.log.debug(getId() + ": set socket timeout to " + i);
        }
        super.setSocketTimeout(i);
    }

    @Override // cz.msebera.android.httpclient.impl.conn.DefaultManagedHttpClientConnection, cz.msebera.android.httpclient.impl.BHttpConnectionBase, cz.msebera.android.httpclient.HttpConnection
    public void shutdown() throws IOException {
        if (this.log.isDebugEnabled()) {
            this.log.debug(getId() + ": Shutdown connection");
        }
        super.shutdown();
    }
}
