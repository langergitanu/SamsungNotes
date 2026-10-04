package org.apache.http.impl.conn;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import org.apache.http.Header;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.config.MessageConstraints;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.p225io.HttpMessageParserFactory;
import org.apache.http.p225io.HttpMessageWriterFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@NotThreadSafe
class LoggingManagedHttpClientConnection extends DefaultManagedHttpClientConnection {
    private static final String HEADER_TAG = "Headers";
    private static final String TAG = "HttpClient";
    private final WireHC4 wire;

    public LoggingManagedHttpClientConnection(String str, int i, int i2, CharsetDecoder charsetDecoder, CharsetEncoder charsetEncoder, MessageConstraints messageConstraints, ContentLengthStrategy contentLengthStrategy, ContentLengthStrategy contentLengthStrategy2, HttpMessageWriterFactory<HttpRequest> httpMessageWriterFactory, HttpMessageParserFactory<HttpResponse> httpMessageParserFactory) {
        super(str, i, i2, charsetDecoder, charsetEncoder, messageConstraints, contentLengthStrategy, contentLengthStrategy2, httpMessageWriterFactory, httpMessageParserFactory);
        this.wire = new WireHC4(str);
    }

    @Override // org.apache.http.impl.BHttpConnectionBase, org.apache.http.HttpConnection
    public void close() throws IOException {
        if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, String.valueOf(getId()).concat(": Close connection"));
        }
        super.close();
    }

    @Override // org.apache.http.impl.BHttpConnectionBase
    public InputStream getSocketInputStream(Socket socket) {
        InputStream socketInputStream = super.getSocketInputStream(socket);
        return this.wire.enabled() ? new LoggingInputStream(socketInputStream, this.wire) : socketInputStream;
    }

    @Override // org.apache.http.impl.BHttpConnectionBase
    public OutputStream getSocketOutputStream(Socket socket) {
        OutputStream socketOutputStream = super.getSocketOutputStream(socket);
        return this.wire.enabled() ? new LoggingOutputStream(socketOutputStream, this.wire) : socketOutputStream;
    }

    @Override // org.apache.http.impl.DefaultBHttpClientConnection
    public void onRequestSubmitted(HttpRequest httpRequest) {
        if (httpRequest == null || !Log.isLoggable(HEADER_TAG, 3)) {
            return;
        }
        Log.d(HEADER_TAG, String.valueOf(getId()) + " >> " + httpRequest.getRequestLine().toString());
        for (Header header : httpRequest.getAllHeaders()) {
            Log.d(HEADER_TAG, String.valueOf(getId()) + " >> " + header.toString());
        }
    }

    @Override // org.apache.http.impl.DefaultBHttpClientConnection
    public void onResponseReceived(HttpResponse httpResponse) {
        if (httpResponse == null || !Log.isLoggable(HEADER_TAG, 3)) {
            return;
        }
        Log.d(HEADER_TAG, String.valueOf(getId()) + " << " + httpResponse.getStatusLine().toString());
        for (Header header : httpResponse.getAllHeaders()) {
            Log.d(HEADER_TAG, String.valueOf(getId()) + " << " + header.toString());
        }
    }

    @Override // org.apache.http.impl.conn.DefaultManagedHttpClientConnection, org.apache.http.impl.BHttpConnectionBase, org.apache.http.HttpConnection
    public void shutdown() throws IOException {
        if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, String.valueOf(getId()).concat(": Shutdown connection"));
        }
        super.shutdown();
    }
}
