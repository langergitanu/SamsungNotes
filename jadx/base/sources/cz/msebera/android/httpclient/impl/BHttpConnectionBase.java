package cz.msebera.android.httpclient.impl;

import cz.msebera.android.httpclient.ConnectionClosedException;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpConnectionMetrics;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpInetConnection;
import cz.msebera.android.httpclient.HttpMessage;
import cz.msebera.android.httpclient.config.MessageConstraints;
import cz.msebera.android.httpclient.entity.BasicHttpEntity;
import cz.msebera.android.httpclient.entity.ContentLengthStrategy;
import cz.msebera.android.httpclient.impl.entity.LaxContentLengthStrategy;
import cz.msebera.android.httpclient.impl.entity.StrictContentLengthStrategy;
import cz.msebera.android.httpclient.impl.p171io.ChunkedInputStream;
import cz.msebera.android.httpclient.impl.p171io.ChunkedOutputStream;
import cz.msebera.android.httpclient.impl.p171io.ContentLengthInputStream;
import cz.msebera.android.httpclient.impl.p171io.ContentLengthOutputStream;
import cz.msebera.android.httpclient.impl.p171io.EmptyInputStream;
import cz.msebera.android.httpclient.impl.p171io.HttpTransportMetricsImpl;
import cz.msebera.android.httpclient.impl.p171io.IdentityInputStream;
import cz.msebera.android.httpclient.impl.p171io.IdentityOutputStream;
import cz.msebera.android.httpclient.impl.p171io.SessionInputBufferImpl;
import cz.msebera.android.httpclient.impl.p171io.SessionOutputBufferImpl;
import cz.msebera.android.httpclient.p172io.SessionInputBuffer;
import cz.msebera.android.httpclient.p172io.SessionOutputBuffer;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.NetUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class BHttpConnectionBase implements HttpInetConnection {
    private final HttpConnectionMetricsImpl connMetrics;
    private final SessionInputBufferImpl inBuffer;
    private final ContentLengthStrategy incomingContentStrategy;
    private final MessageConstraints messageConstraints;
    private final SessionOutputBufferImpl outbuffer;
    private final ContentLengthStrategy outgoingContentStrategy;
    private final AtomicReference<Socket> socketHolder;

    public BHttpConnectionBase(int i, int i2, CharsetDecoder charsetDecoder, CharsetEncoder charsetEncoder, MessageConstraints messageConstraints, ContentLengthStrategy contentLengthStrategy, ContentLengthStrategy contentLengthStrategy2) {
        Args.positive(i, "Buffer size");
        HttpTransportMetricsImpl httpTransportMetricsImpl = new HttpTransportMetricsImpl();
        HttpTransportMetricsImpl httpTransportMetricsImpl2 = new HttpTransportMetricsImpl();
        this.inBuffer = new SessionInputBufferImpl(httpTransportMetricsImpl, i, -1, messageConstraints != null ? messageConstraints : MessageConstraints.DEFAULT, charsetDecoder);
        this.outbuffer = new SessionOutputBufferImpl(httpTransportMetricsImpl2, i, i2, charsetEncoder);
        this.messageConstraints = messageConstraints;
        this.connMetrics = new HttpConnectionMetricsImpl(httpTransportMetricsImpl, httpTransportMetricsImpl2);
        this.incomingContentStrategy = contentLengthStrategy == null ? LaxContentLengthStrategy.INSTANCE : contentLengthStrategy;
        this.outgoingContentStrategy = contentLengthStrategy2 == null ? StrictContentLengthStrategy.INSTANCE : contentLengthStrategy2;
        this.socketHolder = new AtomicReference<>();
    }

    private int fillInputBuffer(int i) throws SocketException {
        Socket socket = this.socketHolder.get();
        int soTimeout = socket.getSoTimeout();
        try {
            socket.setSoTimeout(i);
            return this.inBuffer.fillBuffer();
        } finally {
            socket.setSoTimeout(soTimeout);
        }
    }

    public boolean awaitInput(int i) throws SocketException {
        if (this.inBuffer.hasBufferedData()) {
            return true;
        }
        fillInputBuffer(i);
        return this.inBuffer.hasBufferedData();
    }

    public void bind(Socket socket) {
        Args.notNull(socket, "Socket");
        this.socketHolder.set(socket);
        this.inBuffer.bind(null);
        this.outbuffer.bind(null);
    }

    @Override // cz.msebera.android.httpclient.HttpConnection, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Socket andSet = this.socketHolder.getAndSet(null);
        if (andSet != null) {
            try {
                this.inBuffer.clear();
                this.outbuffer.flush();
                try {
                    try {
                        andSet.shutdownOutput();
                    } catch (IOException | UnsupportedOperationException unused) {
                    }
                } catch (IOException unused2) {
                }
                andSet.shutdownInput();
            } finally {
                andSet.close();
            }
        }
    }

    public InputStream createInputStream(long j, SessionInputBuffer sessionInputBuffer) {
        return j == -2 ? new ChunkedInputStream(sessionInputBuffer, this.messageConstraints) : j == -1 ? new IdentityInputStream(sessionInputBuffer) : j == 0 ? EmptyInputStream.INSTANCE : new ContentLengthInputStream(sessionInputBuffer, j);
    }

    public OutputStream createOutputStream(long j, SessionOutputBuffer sessionOutputBuffer) {
        return j == -2 ? new ChunkedOutputStream(2048, sessionOutputBuffer) : j == -1 ? new IdentityOutputStream(sessionOutputBuffer) : new ContentLengthOutputStream(sessionOutputBuffer, j);
    }

    public void doFlush() throws IOException {
        this.outbuffer.flush();
    }

    public void ensureOpen() throws ConnectionClosedException {
        Socket socket = this.socketHolder.get();
        if (socket == null) {
            throw new ConnectionClosedException();
        }
        if (!this.inBuffer.isBound()) {
            this.inBuffer.bind(getSocketInputStream(socket));
        }
        if (this.outbuffer.isBound()) {
            return;
        }
        this.outbuffer.bind(getSocketOutputStream(socket));
    }

    @Override // cz.msebera.android.httpclient.HttpInetConnection
    public InetAddress getLocalAddress() {
        Socket socket = this.socketHolder.get();
        if (socket != null) {
            return socket.getLocalAddress();
        }
        return null;
    }

    @Override // cz.msebera.android.httpclient.HttpInetConnection
    public int getLocalPort() {
        Socket socket = this.socketHolder.get();
        if (socket != null) {
            return socket.getLocalPort();
        }
        return -1;
    }

    @Override // cz.msebera.android.httpclient.HttpConnection
    public HttpConnectionMetrics getMetrics() {
        return this.connMetrics;
    }

    @Override // cz.msebera.android.httpclient.HttpInetConnection
    public InetAddress getRemoteAddress() {
        Socket socket = this.socketHolder.get();
        if (socket != null) {
            return socket.getInetAddress();
        }
        return null;
    }

    @Override // cz.msebera.android.httpclient.HttpInetConnection
    public int getRemotePort() {
        Socket socket = this.socketHolder.get();
        if (socket != null) {
            return socket.getPort();
        }
        return -1;
    }

    public SessionInputBuffer getSessionInputBuffer() {
        return this.inBuffer;
    }

    public SessionOutputBuffer getSessionOutputBuffer() {
        return this.outbuffer;
    }

    public Socket getSocket() {
        return this.socketHolder.get();
    }

    public InputStream getSocketInputStream(Socket socket) {
        return socket.getInputStream();
    }

    public OutputStream getSocketOutputStream(Socket socket) {
        return socket.getOutputStream();
    }

    @Override // cz.msebera.android.httpclient.HttpConnection
    public int getSocketTimeout() {
        Socket socket = this.socketHolder.get();
        if (socket != null) {
            try {
                return socket.getSoTimeout();
            } catch (SocketException unused) {
            }
        }
        return -1;
    }

    public void incrementRequestCount() {
        this.connMetrics.incrementRequestCount();
    }

    public void incrementResponseCount() {
        this.connMetrics.incrementResponseCount();
    }

    @Override // cz.msebera.android.httpclient.HttpConnection
    public boolean isOpen() {
        return this.socketHolder.get() != null;
    }

    @Override // cz.msebera.android.httpclient.HttpConnection
    public boolean isStale() {
        if (!isOpen()) {
            return true;
        }
        try {
            return fillInputBuffer(1) < 0;
        } catch (SocketTimeoutException unused) {
            return false;
        } catch (IOException unused2) {
            return true;
        }
    }

    public HttpEntity prepareInput(HttpMessage httpMessage) {
        BasicHttpEntity basicHttpEntity = new BasicHttpEntity();
        long jDetermineLength = this.incomingContentStrategy.determineLength(httpMessage);
        InputStream inputStreamCreateInputStream = createInputStream(jDetermineLength, this.inBuffer);
        if (jDetermineLength == -2) {
            basicHttpEntity.setChunked(true);
            basicHttpEntity.setContentLength(-1L);
            basicHttpEntity.setContent(inputStreamCreateInputStream);
        } else if (jDetermineLength == -1) {
            basicHttpEntity.setChunked(false);
            basicHttpEntity.setContentLength(-1L);
            basicHttpEntity.setContent(inputStreamCreateInputStream);
        } else {
            basicHttpEntity.setChunked(false);
            basicHttpEntity.setContentLength(jDetermineLength);
            basicHttpEntity.setContent(inputStreamCreateInputStream);
        }
        Header firstHeader = httpMessage.getFirstHeader("Content-Type");
        if (firstHeader != null) {
            basicHttpEntity.setContentType(firstHeader);
        }
        Header firstHeader2 = httpMessage.getFirstHeader("Content-Encoding");
        if (firstHeader2 != null) {
            basicHttpEntity.setContentEncoding(firstHeader2);
        }
        return basicHttpEntity;
    }

    public OutputStream prepareOutput(HttpMessage httpMessage) {
        return createOutputStream(this.outgoingContentStrategy.determineLength(httpMessage), this.outbuffer);
    }

    @Override // cz.msebera.android.httpclient.HttpConnection
    public void setSocketTimeout(int i) {
        Socket socket = this.socketHolder.get();
        if (socket != null) {
            try {
                socket.setSoTimeout(i);
            } catch (SocketException unused) {
            }
        }
    }

    @Override // cz.msebera.android.httpclient.HttpConnection
    public void shutdown() throws IOException {
        Socket andSet = this.socketHolder.getAndSet(null);
        if (andSet != null) {
            try {
                andSet.setSoLinger(true, 0);
            } catch (IOException unused) {
            } finally {
                andSet.close();
            }
        }
    }

    public String toString() {
        Socket socket = this.socketHolder.get();
        if (socket == null) {
            return "[Not bound]";
        }
        StringBuilder sb = new StringBuilder();
        SocketAddress remoteSocketAddress = socket.getRemoteSocketAddress();
        SocketAddress localSocketAddress = socket.getLocalSocketAddress();
        if (remoteSocketAddress != null && localSocketAddress != null) {
            NetUtils.formatAddress(sb, localSocketAddress);
            sb.append("<->");
            NetUtils.formatAddress(sb, remoteSocketAddress);
        }
        return sb.toString();
    }
}
