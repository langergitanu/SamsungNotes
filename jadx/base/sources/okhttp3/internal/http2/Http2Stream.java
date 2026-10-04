package okhttp3.internal.http2;

import androidx.collection.AbstractC0622a;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import javax.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.internal.Util;
import okio.AsyncTimeout;
import okio.Buffer;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.Timeout;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class Http2Stream {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    long bytesLeftInWriteWindow;
    final Http2Connection connection;

    @Nullable
    ErrorCode errorCode;

    @Nullable
    IOException errorException;
    private boolean hasResponseHeaders;
    private final Deque<Headers> headersQueue;

    /* JADX INFO: renamed from: id */
    final int f9649id;
    final StreamTimeout readTimeout;
    final FramingSink sink;
    private final FramingSource source;
    long unacknowledgedBytesRead = 0;
    final StreamTimeout writeTimeout;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public final class FramingSink implements Sink {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final long EMIT_BUFFER_SIZE = 16384;
        boolean closed;
        boolean finished;
        private final Buffer sendBuffer = new Buffer();
        private Headers trailers;

        public FramingSink() {
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x005e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void emitFrame(boolean z) throws IOException {
            Http2Stream http2Stream;
            long jMin;
            Http2Stream http2Stream2;
            boolean z2;
            synchronized (Http2Stream.this) {
                Http2Stream.this.writeTimeout.enter();
                while (true) {
                    try {
                        http2Stream = Http2Stream.this;
                        if (http2Stream.bytesLeftInWriteWindow > 0 || this.finished || this.closed || http2Stream.errorCode != null) {
                            break;
                        } else {
                            http2Stream.waitForIo();
                        }
                    } finally {
                        Http2Stream.this.writeTimeout.exitAndThrowIfTimedOut();
                    }
                }
                http2Stream.writeTimeout.exitAndThrowIfTimedOut();
                Http2Stream.this.checkOutNotClosed();
                jMin = Math.min(Http2Stream.this.bytesLeftInWriteWindow, this.sendBuffer.size());
                http2Stream2 = Http2Stream.this;
                http2Stream2.bytesLeftInWriteWindow -= jMin;
            }
            http2Stream2.writeTimeout.enter();
            if (z) {
                try {
                    z2 = jMin == this.sendBuffer.size();
                } catch (Throwable th) {
                    throw th;
                }
            }
            boolean z3 = z2;
            Http2Stream http2Stream3 = Http2Stream.this;
            http2Stream3.connection.writeData(http2Stream3.f9649id, z3, this.sendBuffer, jMin);
            Http2Stream.this.writeTimeout.exitAndThrowIfTimedOut();
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            synchronized (Http2Stream.this) {
                try {
                    if (this.closed) {
                        return;
                    }
                    if (!Http2Stream.this.sink.finished) {
                        boolean z = this.sendBuffer.size() > 0;
                        if (this.trailers != null) {
                            while (this.sendBuffer.size() > 0) {
                                emitFrame(false);
                            }
                            Http2Stream http2Stream = Http2Stream.this;
                            http2Stream.connection.writeHeaders(http2Stream.f9649id, true, Util.toHeaderBlock(this.trailers));
                        } else if (z) {
                            while (this.sendBuffer.size() > 0) {
                                emitFrame(true);
                            }
                        } else {
                            Http2Stream http2Stream2 = Http2Stream.this;
                            http2Stream2.connection.writeData(http2Stream2.f9649id, true, null, 0L);
                        }
                    }
                    synchronized (Http2Stream.this) {
                        this.closed = true;
                    }
                    Http2Stream.this.connection.flush();
                    Http2Stream.this.cancelStreamIfNecessary();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            synchronized (Http2Stream.this) {
                Http2Stream.this.checkOutNotClosed();
            }
            while (this.sendBuffer.size() > 0) {
                emitFrame(false);
                Http2Stream.this.connection.flush();
            }
        }

        @Override // okio.Sink
        /* JADX INFO: renamed from: timeout */
        public Timeout getTimeout() {
            return Http2Stream.this.writeTimeout;
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j) throws IOException {
            this.sendBuffer.write(buffer, j);
            while (this.sendBuffer.size() >= 16384) {
                emitFrame(false);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public final class FramingSource implements Source {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        boolean closed;
        boolean finished;
        private final long maxByteCount;
        private Headers trailers;
        private final Buffer receiveBuffer = new Buffer();
        private final Buffer readBuffer = new Buffer();

        public FramingSource(long j) {
            this.maxByteCount = j;
        }

        private void updateConnectionFlowControl(long j) {
            Http2Stream.this.connection.updateConnectionFlowControl(j);
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            long size;
            synchronized (Http2Stream.this) {
                this.closed = true;
                size = this.readBuffer.size();
                this.readBuffer.clear();
                Http2Stream.this.notifyAll();
            }
            if (size > 0) {
                updateConnectionFlowControl(size);
            }
            Http2Stream.this.cancelStreamIfNecessary();
        }

        /* JADX WARN: Removed duplicated region for block: B:39:0x0092  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x0096  */
        @Override // okio.Source
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public long read(Buffer buffer, long j) throws Throwable {
            Throwable streamResetException;
            long j2;
            if (j < 0) {
                throw new IllegalArgumentException(AbstractC0622a.m1169o("byteCount < 0: ", j));
            }
            while (true) {
                synchronized (Http2Stream.this) {
                    try {
                        Http2Stream.this.readTimeout.enter();
                        try {
                            Http2Stream http2Stream = Http2Stream.this;
                            if (http2Stream.errorCode != null) {
                                streamResetException = http2Stream.errorException;
                                if (streamResetException == null) {
                                    streamResetException = new StreamResetException(Http2Stream.this.errorCode);
                                }
                            } else {
                                streamResetException = null;
                            }
                            if (this.closed) {
                                throw new IOException("stream closed");
                            }
                            if (this.readBuffer.size() > 0) {
                                Buffer buffer2 = this.readBuffer;
                                j2 = buffer2.read(buffer, Math.min(j, buffer2.size()));
                                Http2Stream http2Stream2 = Http2Stream.this;
                                long j3 = http2Stream2.unacknowledgedBytesRead + j2;
                                http2Stream2.unacknowledgedBytesRead = j3;
                                if (streamResetException == null && j3 >= http2Stream2.connection.okHttpSettings.getInitialWindowSize() / 2) {
                                    Http2Stream http2Stream3 = Http2Stream.this;
                                    http2Stream3.connection.writeWindowUpdateLater(http2Stream3.f9649id, http2Stream3.unacknowledgedBytesRead);
                                    Http2Stream.this.unacknowledgedBytesRead = 0L;
                                }
                            } else {
                                if (this.finished || streamResetException != null) {
                                    break;
                                }
                                Http2Stream.this.waitForIo();
                                Http2Stream.this.readTimeout.exitAndThrowIfTimedOut();
                            }
                        } finally {
                            Http2Stream.this.readTimeout.exitAndThrowIfTimedOut();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (j2 == -1) {
                    updateConnectionFlowControl(j2);
                    return j2;
                }
                if (streamResetException == null) {
                    return -1L;
                }
                throw streamResetException;
            }
            j2 = -1;
            Http2Stream.this.readTimeout.exitAndThrowIfTimedOut();
            if (j2 == -1) {
            }
        }

        public void receive(BufferedSource bufferedSource, long j) throws EOFException {
            boolean z;
            boolean z2;
            long size;
            while (j > 0) {
                synchronized (Http2Stream.this) {
                    z = this.finished;
                    z2 = this.readBuffer.size() + j > this.maxByteCount;
                }
                if (z2) {
                    bufferedSource.skip(j);
                    Http2Stream.this.closeLater(ErrorCode.FLOW_CONTROL_ERROR);
                    return;
                }
                if (z) {
                    bufferedSource.skip(j);
                    return;
                }
                long j2 = bufferedSource.read(this.receiveBuffer, j);
                if (j2 == -1) {
                    throw new EOFException();
                }
                j -= j2;
                synchronized (Http2Stream.this) {
                    try {
                        if (this.closed) {
                            size = this.receiveBuffer.size();
                            this.receiveBuffer.clear();
                        } else {
                            boolean z3 = this.readBuffer.size() == 0;
                            this.readBuffer.writeAll(this.receiveBuffer);
                            if (z3) {
                                Http2Stream.this.notifyAll();
                            }
                            size = 0;
                        }
                    } finally {
                    }
                }
                if (size > 0) {
                    updateConnectionFlowControl(size);
                }
            }
        }

        @Override // okio.Source
        /* JADX INFO: renamed from: timeout */
        public Timeout getTimeout() {
            return Http2Stream.this.readTimeout;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class StreamTimeout extends AsyncTimeout {
        public StreamTimeout() {
        }

        public void exitAndThrowIfTimedOut() throws IOException {
            if (exit()) {
                throw newTimeoutException(null);
            }
        }

        @Override // okio.AsyncTimeout
        public IOException newTimeoutException(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // okio.AsyncTimeout
        public void timedOut() {
            Http2Stream.this.closeLater(ErrorCode.CANCEL);
            Http2Stream.this.connection.sendDegradedPingLater();
        }
    }

    public Http2Stream(int i, Http2Connection http2Connection, boolean z, boolean z2, @Nullable Headers headers) {
        ArrayDeque arrayDeque = new ArrayDeque();
        this.headersQueue = arrayDeque;
        this.readTimeout = new StreamTimeout();
        this.writeTimeout = new StreamTimeout();
        if (http2Connection == null) {
            throw new NullPointerException("connection == null");
        }
        this.f9649id = i;
        this.connection = http2Connection;
        this.bytesLeftInWriteWindow = http2Connection.peerSettings.getInitialWindowSize();
        FramingSource framingSource = new FramingSource(http2Connection.okHttpSettings.getInitialWindowSize());
        this.source = framingSource;
        FramingSink framingSink = new FramingSink();
        this.sink = framingSink;
        framingSource.finished = z2;
        framingSink.finished = z;
        if (headers != null) {
            arrayDeque.add(headers);
        }
        if (isLocallyInitiated() && headers != null) {
            throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
        }
        if (!isLocallyInitiated() && headers == null) {
            throw new IllegalStateException("remotely-initiated streams should have headers");
        }
    }

    private boolean closeInternal(ErrorCode errorCode, @Nullable IOException iOException) {
        synchronized (this) {
            try {
                if (this.errorCode != null) {
                    return false;
                }
                if (this.source.finished && this.sink.finished) {
                    return false;
                }
                this.errorCode = errorCode;
                this.errorException = iOException;
                notifyAll();
                this.connection.removeStream(this.f9649id);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void addBytesToWriteWindow(long j) {
        this.bytesLeftInWriteWindow += j;
        if (j > 0) {
            notifyAll();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void cancelStreamIfNecessary() {
        boolean z;
        boolean zIsOpen;
        synchronized (this) {
            try {
                FramingSource framingSource = this.source;
                if (framingSource.finished || !framingSource.closed) {
                    z = false;
                } else {
                    FramingSink framingSink = this.sink;
                    if (framingSink.finished || framingSink.closed) {
                        z = true;
                    }
                }
                zIsOpen = isOpen();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z) {
            close(ErrorCode.CANCEL, null);
        } else {
            if (zIsOpen) {
                return;
            }
            this.connection.removeStream(this.f9649id);
        }
    }

    public void checkOutNotClosed() throws IOException {
        FramingSink framingSink = this.sink;
        if (framingSink.closed) {
            throw new IOException("stream closed");
        }
        if (framingSink.finished) {
            throw new IOException("stream finished");
        }
        if (this.errorCode != null) {
            IOException iOException = this.errorException;
            if (iOException == null) {
                throw new StreamResetException(this.errorCode);
            }
        }
    }

    public void close(ErrorCode errorCode, @Nullable IOException iOException) {
        if (closeInternal(errorCode, iOException)) {
            this.connection.writeSynReset(this.f9649id, errorCode);
        }
    }

    public void closeLater(ErrorCode errorCode) {
        if (closeInternal(errorCode, null)) {
            this.connection.writeSynResetLater(this.f9649id, errorCode);
        }
    }

    public void enqueueTrailers(Headers headers) {
        synchronized (this) {
            try {
                if (this.sink.finished) {
                    throw new IllegalStateException("already finished");
                }
                if (headers.size() == 0) {
                    throw new IllegalArgumentException("trailers.size() == 0");
                }
                this.sink.trailers = headers;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Http2Connection getConnection() {
        return this.connection;
    }

    public synchronized ErrorCode getErrorCode() {
        return this.errorCode;
    }

    public int getId() {
        return this.f9649id;
    }

    public Sink getSink() {
        synchronized (this) {
            try {
                if (!this.hasResponseHeaders && !isLocallyInitiated()) {
                    throw new IllegalStateException("reply before requesting the sink");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.sink;
    }

    public Source getSource() {
        return this.source;
    }

    public boolean isLocallyInitiated() {
        return this.connection.client == ((this.f9649id & 1) == 1);
    }

    public synchronized boolean isOpen() {
        try {
            if (this.errorCode != null) {
                return false;
            }
            FramingSource framingSource = this.source;
            if (framingSource.finished || framingSource.closed) {
                FramingSink framingSink = this.sink;
                if (framingSink.finished || framingSink.closed) {
                    if (this.hasResponseHeaders) {
                        return false;
                    }
                }
            }
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public Timeout readTimeout() {
        return this.readTimeout;
    }

    public void receiveData(BufferedSource bufferedSource, int i) {
        this.source.receive(bufferedSource, i);
    }

    public void receiveHeaders(Headers headers, boolean z) {
        boolean zIsOpen;
        synchronized (this) {
            try {
                if (this.hasResponseHeaders && z) {
                    this.source.trailers = headers;
                } else {
                    this.hasResponseHeaders = true;
                    this.headersQueue.add(headers);
                }
                if (z) {
                    this.source.finished = true;
                }
                zIsOpen = isOpen();
                notifyAll();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (zIsOpen) {
            return;
        }
        this.connection.removeStream(this.f9649id);
    }

    public synchronized void receiveRstStream(ErrorCode errorCode) {
        if (this.errorCode == null) {
            this.errorCode = errorCode;
            notifyAll();
        }
    }

    public synchronized Headers takeHeaders() throws IOException {
        this.readTimeout.enter();
        while (this.headersQueue.isEmpty() && this.errorCode == null) {
            try {
                waitForIo();
            } catch (Throwable th) {
                this.readTimeout.exitAndThrowIfTimedOut();
                throw th;
            }
        }
        this.readTimeout.exitAndThrowIfTimedOut();
        if (this.headersQueue.isEmpty()) {
            IOException iOException = this.errorException;
            if (iOException != null) {
                throw iOException;
            }
            throw new StreamResetException(this.errorCode);
        }
        return this.headersQueue.removeFirst();
    }

    public synchronized Headers trailers() throws IOException {
        try {
            if (this.errorCode != null) {
                IOException iOException = this.errorException;
                if (iOException != null) {
                    throw iOException;
                }
                throw new StreamResetException(this.errorCode);
            }
            FramingSource framingSource = this.source;
            if (!framingSource.finished || !framingSource.receiveBuffer.exhausted() || !this.source.readBuffer.exhausted()) {
                throw new IllegalStateException("too early; can't read the trailers yet");
            }
        } finally {
        }
        return this.source.trailers != null ? this.source.trailers : Util.EMPTY_HEADERS;
    }

    public void waitForIo() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    public void writeHeaders(List<Header> list, boolean z, boolean z2) {
        if (list == null) {
            throw new NullPointerException("headers == null");
        }
        synchronized (this) {
            try {
                this.hasResponseHeaders = true;
                if (z) {
                    this.sink.finished = true;
                }
            } finally {
            }
        }
        if (!z2) {
            synchronized (this.connection) {
                z2 = this.connection.bytesLeftInWriteWindow == 0;
            }
        }
        this.connection.writeHeaders(this.f9649id, z, list);
        if (z2) {
            this.connection.flush();
        }
    }

    public Timeout writeTimeout() {
        return this.writeTimeout;
    }
}
