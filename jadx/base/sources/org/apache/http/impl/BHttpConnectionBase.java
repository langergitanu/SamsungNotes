package org.apache.http.impl;

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
import org.apache.http.Header;
import org.apache.http.HttpConnection;
import org.apache.http.HttpConnectionMetrics;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpInetConnection;
import org.apache.http.HttpMessage;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.config.MessageConstraints;
import org.apache.http.entity.BasicHttpEntityHC4;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.impl.entity.LaxContentLengthStrategyHC4;
import org.apache.http.impl.entity.StrictContentLengthStrategyHC4;
import org.apache.http.impl.io.HttpTransportMetricsImpl;
import org.apache.http.impl.p224io.ChunkedInputStreamHC4;
import org.apache.http.impl.p224io.ChunkedOutputStreamHC4;
import org.apache.http.impl.p224io.ContentLengthInputStreamHC4;
import org.apache.http.impl.p224io.ContentLengthOutputStreamHC4;
import org.apache.http.impl.p224io.IdentityInputStreamHC4;
import org.apache.http.impl.p224io.IdentityOutputStreamHC4;
import org.apache.http.impl.p224io.SessionInputBufferImpl;
import org.apache.http.impl.p224io.SessionOutputBufferImpl;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.util.Args;
import org.apache.http.util.Asserts;
import org.apache.http.util.NetUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@NotThreadSafe
public class BHttpConnectionBase implements HttpConnection, HttpInetConnection {
    private final HttpConnectionMetricsImpl connMetrics;
    private final SessionInputBufferImpl inbuffer;
    private final ContentLengthStrategy incomingContentStrategy;
    private volatile boolean open;
    private final SessionOutputBufferImpl outbuffer;
    private final ContentLengthStrategy outgoingContentStrategy;
    private volatile Socket socket;

    public BHttpConnectionBase(int i, int i2, CharsetDecoder charsetDecoder, CharsetEncoder charsetEncoder, MessageConstraints messageConstraints, ContentLengthStrategy contentLengthStrategy, ContentLengthStrategy contentLengthStrategy2) {
        Args.positive(i, "Buffer size");
        HttpTransportMetricsImpl httpTransportMetricsImpl = new HttpTransportMetricsImpl();
        HttpTransportMetricsImpl httpTransportMetricsImpl2 = new HttpTransportMetricsImpl();
        this.inbuffer = new SessionInputBufferImpl(httpTransportMetricsImpl, i, -1, messageConstraints == null ? MessageConstraints.DEFAULT : messageConstraints, charsetDecoder);
        this.outbuffer = new SessionOutputBufferImpl(httpTransportMetricsImpl2, i, i2, charsetEncoder);
        this.connMetrics = new HttpConnectionMetricsImpl(httpTransportMetricsImpl, httpTransportMetricsImpl2);
        this.incomingContentStrategy = contentLengthStrategy == null ? LaxContentLengthStrategyHC4.INSTANCE : contentLengthStrategy;
        this.outgoingContentStrategy = contentLengthStrategy2 == null ? StrictContentLengthStrategyHC4.INSTANCE : contentLengthStrategy2;
    }

    private int fillInputBuffer(int i) throws SocketException {
        int soTimeout = this.socket.getSoTimeout();
        try {
            this.socket.setSoTimeout(i);
            return this.inbuffer.fillBuffer();
        } finally {
            this.socket.setSoTimeout(soTimeout);
        }
    }

    public boolean awaitInput(int i) throws SocketException {
        if (this.inbuffer.hasBufferedData()) {
            return true;
        }
        fillInputBuffer(i);
        return this.inbuffer.hasBufferedData();
    }

    public void bind(Socket socket) {
        Args.notNull(socket, "Socket");
        this.socket = socket;
        this.open = true;
        this.inbuffer.bind(null);
        this.outbuffer.bind(null);
    }

    @Override // org.apache.http.HttpConnection
    public void close() throws IOException {
        if (this.open) {
            this.open = false;
            Socket socket = this.socket;
            try {
                this.inbuffer.clear();
                this.outbuffer.flush();
                try {
                    try {
                        socket.shutdownOutput();
                    } catch (IOException unused) {
                    }
                    socket.shutdownInput();
                } catch (IOException | UnsupportedOperationException unused2) {
                }
            } finally {
                socket.close();
            }
        }
    }

    public InputStream createInputStream(long j, SessionInputBuffer sessionInputBuffer) {
        return j == -2 ? new ChunkedInputStreamHC4(sessionInputBuffer) : j == -1 ? new IdentityInputStreamHC4(sessionInputBuffer) : new ContentLengthInputStreamHC4(sessionInputBuffer, j);
    }

    public OutputStream createOutputStream(long j, SessionOutputBuffer sessionOutputBuffer) {
        return j == -2 ? new ChunkedOutputStreamHC4(2048, sessionOutputBuffer) : j == -1 ? new IdentityOutputStreamHC4(sessionOutputBuffer) : new ContentLengthOutputStreamHC4(sessionOutputBuffer, j);
    }

    public void doFlush() throws IOException {
        this.outbuffer.flush();
    }

    public void ensureOpen() {
        Asserts.check(this.open, "Connection is not open");
        if (!this.inbuffer.isBound()) {
            this.inbuffer.bind(getSocketInputStream(this.socket));
        }
        if (this.outbuffer.isBound()) {
            return;
        }
        this.outbuffer.bind(getSocketOutputStream(this.socket));
    }

    @Override // org.apache.http.HttpInetConnection
    public InetAddress getLocalAddress() {
        if (this.socket != null) {
            return this.socket.getLocalAddress();
        }
        return null;
    }

    @Override // org.apache.http.HttpInetConnection
    public int getLocalPort() {
        if (this.socket != null) {
            return this.socket.getLocalPort();
        }
        return -1;
    }

    @Override // org.apache.http.HttpConnection
    public HttpConnectionMetrics getMetrics() {
        return this.connMetrics;
    }

    @Override // org.apache.http.HttpInetConnection
    public InetAddress getRemoteAddress() {
        if (this.socket != null) {
            return this.socket.getInetAddress();
        }
        return null;
    }

    @Override // org.apache.http.HttpInetConnection
    public int getRemotePort() {
        if (this.socket != null) {
            return this.socket.getPort();
        }
        return -1;
    }

    public SessionInputBuffer getSessionInputBuffer() {
        return this.inbuffer;
    }

    public SessionOutputBuffer getSessionOutputBuffer() {
        return this.outbuffer;
    }

    public Socket getSocket() {
        return this.socket;
    }

    public InputStream getSocketInputStream(Socket socket) {
        return socket.getInputStream();
    }

    public OutputStream getSocketOutputStream(Socket socket) {
        return socket.getOutputStream();
    }

    @Override // org.apache.http.HttpConnection
    public int getSocketTimeout() {
        if (this.socket != null) {
            try {
                return this.socket.getSoTimeout();
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

    @Override // org.apache.http.HttpConnection
    public boolean isOpen() {
        return this.open;
    }

    @Override // org.apache.http.HttpConnection
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

    public HttpEntity prepareInput(HttpMessage httpMessage) throws HttpException {
        BasicHttpEntityHC4 basicHttpEntityHC4 = new BasicHttpEntityHC4();
        long jDetermineLength = this.incomingContentStrategy.determineLength(httpMessage);
        InputStream inputStreamCreateInputStream = createInputStream(jDetermineLength, this.inbuffer);
        if (jDetermineLength == -2) {
            basicHttpEntityHC4.setChunked(true);
            basicHttpEntityHC4.setContentLength(-1L);
            basicHttpEntityHC4.setContent(inputStreamCreateInputStream);
        } else if (jDetermineLength == -1) {
            basicHttpEntityHC4.setChunked(false);
            basicHttpEntityHC4.setContentLength(-1L);
            basicHttpEntityHC4.setContent(inputStreamCreateInputStream);
        } else {
            basicHttpEntityHC4.setChunked(false);
            basicHttpEntityHC4.setContentLength(jDetermineLength);
            basicHttpEntityHC4.setContent(inputStreamCreateInputStream);
        }
        Header firstHeader = httpMessage.getFirstHeader("Content-Type");
        if (firstHeader != null) {
            basicHttpEntityHC4.setContentType(firstHeader);
        }
        Header firstHeader2 = httpMessage.getFirstHeader("Content-Encoding");
        if (firstHeader2 != null) {
            basicHttpEntityHC4.setContentEncoding(firstHeader2);
        }
        return basicHttpEntityHC4;
    }

    public OutputStream prepareOutput(HttpMessage httpMessage) {
        return createOutputStream(this.outgoingContentStrategy.determineLength(httpMessage), this.outbuffer);
    }

    @Override // org.apache.http.HttpConnection
    public void setSocketTimeout(int i) {
        if (this.socket != null) {
            try {
                this.socket.setSoTimeout(i);
            } catch (SocketException unused) {
            }
        }
    }

    @Override // org.apache.http.HttpConnection
    public void shutdown() throws IOException {
        this.open = false;
        Socket socket = this.socket;
        if (socket != null) {
            socket.close();
        }
    }

    public String toString() {
        if (this.socket == null) {
            return "[Not bound]";
        }
        StringBuilder sb = new StringBuilder();
        SocketAddress remoteSocketAddress = this.socket.getRemoteSocketAddress();
        SocketAddress localSocketAddress = this.socket.getLocalSocketAddress();
        if (remoteSocketAddress != null && localSocketAddress != null) {
            NetUtils.formatAddress(sb, localSocketAddress);
            sb.append("<->");
            NetUtils.formatAddress(sb, remoteSocketAddress);
        }
        return sb.toString();
    }
}
