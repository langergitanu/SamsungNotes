package cz.msebera.android.httpclient.impl;

import cz.msebera.android.httpclient.ConnectionClosedException;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpServerConnection;
import cz.msebera.android.httpclient.config.MessageConstraints;
import cz.msebera.android.httpclient.entity.ContentLengthStrategy;
import cz.msebera.android.httpclient.impl.entity.DisallowIdentityContentLengthStrategy;
import cz.msebera.android.httpclient.impl.p171io.DefaultHttpRequestParserFactory;
import cz.msebera.android.httpclient.impl.p171io.DefaultHttpResponseWriterFactory;
import cz.msebera.android.httpclient.p172io.HttpMessageParser;
import cz.msebera.android.httpclient.p172io.HttpMessageParserFactory;
import cz.msebera.android.httpclient.p172io.HttpMessageWriter;
import cz.msebera.android.httpclient.p172io.HttpMessageWriterFactory;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class DefaultBHttpServerConnection extends BHttpConnectionBase implements HttpServerConnection {
    private final HttpMessageParser<HttpRequest> requestParser;
    private final HttpMessageWriter<HttpResponse> responseWriter;

    public DefaultBHttpServerConnection(int i, int i2, CharsetDecoder charsetDecoder, CharsetEncoder charsetEncoder, MessageConstraints messageConstraints, ContentLengthStrategy contentLengthStrategy, ContentLengthStrategy contentLengthStrategy2, HttpMessageParserFactory<HttpRequest> httpMessageParserFactory, HttpMessageWriterFactory<HttpResponse> httpMessageWriterFactory) {
        super(i, i2, charsetDecoder, charsetEncoder, messageConstraints, contentLengthStrategy == null ? DisallowIdentityContentLengthStrategy.INSTANCE : contentLengthStrategy, contentLengthStrategy2);
        this.requestParser = (httpMessageParserFactory != null ? httpMessageParserFactory : DefaultHttpRequestParserFactory.INSTANCE).create(getSessionInputBuffer(), messageConstraints);
        this.responseWriter = (httpMessageWriterFactory != null ? httpMessageWriterFactory : DefaultHttpResponseWriterFactory.INSTANCE).create(getSessionOutputBuffer());
    }

    @Override // cz.msebera.android.httpclient.impl.BHttpConnectionBase
    public void bind(Socket socket) {
        super.bind(socket);
    }

    @Override // cz.msebera.android.httpclient.HttpServerConnection
    public void flush() throws IOException {
        ensureOpen();
        doFlush();
    }

    public void onRequestReceived(HttpRequest httpRequest) {
    }

    public void onResponseSubmitted(HttpResponse httpResponse) {
    }

    @Override // cz.msebera.android.httpclient.HttpServerConnection
    public void receiveRequestEntity(HttpEntityEnclosingRequest httpEntityEnclosingRequest) throws ConnectionClosedException {
        Args.notNull(httpEntityEnclosingRequest, "HTTP request");
        ensureOpen();
        httpEntityEnclosingRequest.setEntity(prepareInput(httpEntityEnclosingRequest));
    }

    @Override // cz.msebera.android.httpclient.HttpServerConnection
    public HttpRequest receiveRequestHeader() throws ConnectionClosedException {
        ensureOpen();
        HttpRequest httpRequest = (HttpRequest) this.requestParser.parse();
        onRequestReceived(httpRequest);
        incrementRequestCount();
        return httpRequest;
    }

    @Override // cz.msebera.android.httpclient.HttpServerConnection
    public void sendResponseEntity(HttpResponse httpResponse) throws IOException {
        Args.notNull(httpResponse, "HTTP response");
        ensureOpen();
        HttpEntity entity = httpResponse.getEntity();
        if (entity == null) {
            return;
        }
        OutputStream outputStreamPrepareOutput = prepareOutput(httpResponse);
        entity.writeTo(outputStreamPrepareOutput);
        outputStreamPrepareOutput.close();
    }

    @Override // cz.msebera.android.httpclient.HttpServerConnection
    public void sendResponseHeader(HttpResponse httpResponse) throws ConnectionClosedException {
        Args.notNull(httpResponse, "HTTP response");
        ensureOpen();
        this.responseWriter.write(httpResponse);
        onResponseSubmitted(httpResponse);
        if (httpResponse.getStatusLine().getStatusCode() >= 200) {
            incrementResponseCount();
        }
    }

    public DefaultBHttpServerConnection(int i, CharsetDecoder charsetDecoder, CharsetEncoder charsetEncoder, MessageConstraints messageConstraints) {
        this(i, i, charsetDecoder, charsetEncoder, messageConstraints, null, null, null, null);
    }

    public DefaultBHttpServerConnection(int i) {
        this(i, i, null, null, null, null, null, null, null);
    }
}
