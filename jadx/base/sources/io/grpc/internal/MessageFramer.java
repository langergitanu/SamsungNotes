package io.grpc.internal;

import androidx.compose.foundation.layout.AbstractC1038a;
import com.google.common.base.Preconditions;
import com.google.common.p130io.ByteStreams;
import io.grpc.Codec;
import io.grpc.Compressor;
import io.grpc.Drainable;
import io.grpc.KnownLength;
import io.grpc.Status;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.annotation.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class MessageFramer implements Framer {
    private static final byte COMPRESSED = 1;
    private static final int HEADER_LENGTH = 5;
    private static final int NO_MAX_OUTBOUND_MESSAGE_SIZE = -1;
    private static final byte UNCOMPRESSED = 0;
    private WritableBuffer buffer;
    private final WritableBufferAllocator bufferAllocator;
    private boolean closed;
    private long currentMessageWireSize;
    private int messagesBuffered;
    private final Sink sink;
    private final StatsTraceContext statsTraceCtx;
    private int maxOutboundMessageSize = -1;
    private Compressor compressor = Codec.Identity.NONE;
    private boolean messageCompression = true;
    private final OutputStreamAdapter outputStreamAdapter = new OutputStreamAdapter();
    private final ByteBuffer headerScratch = ByteBuffer.allocate(5);
    private int currentMessageSeqNo = -1;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Sink {
        void deliverFrame(@Nullable WritableBuffer writableBuffer, boolean z, boolean z2, int i);
    }

    public MessageFramer(Sink sink, WritableBufferAllocator writableBufferAllocator, StatsTraceContext statsTraceContext) {
        this.sink = (Sink) Preconditions.checkNotNull(sink, "sink");
        this.bufferAllocator = (WritableBufferAllocator) Preconditions.checkNotNull(writableBufferAllocator, "bufferAllocator");
        this.statsTraceCtx = (StatsTraceContext) Preconditions.checkNotNull(statsTraceContext, "statsTraceCtx");
    }

    private void commitToSink(boolean z, boolean z2) {
        WritableBuffer writableBuffer = this.buffer;
        this.buffer = null;
        this.sink.deliverFrame(writableBuffer, z, z2, this.messagesBuffered);
        this.messagesBuffered = 0;
    }

    private int getKnownLength(InputStream inputStream) {
        if ((inputStream instanceof KnownLength) || (inputStream instanceof ByteArrayInputStream)) {
            return inputStream.available();
        }
        return -1;
    }

    private void releaseBuffer() {
        WritableBuffer writableBuffer = this.buffer;
        if (writableBuffer != null) {
            writableBuffer.release();
            this.buffer = null;
        }
    }

    private void verifyNotClosed() {
        if (isClosed()) {
            throw new IllegalStateException("Framer already closed");
        }
    }

    private void writeBufferChain(BufferChainOutputStream bufferChainOutputStream, boolean z) {
        int i = bufferChainOutputStream.readableBytes();
        this.headerScratch.put(z ? (byte) 1 : (byte) 0).putInt(i);
        WritableBuffer writableBufferAllocate = this.bufferAllocator.allocate(5);
        writableBufferAllocate.write(this.headerScratch.array(), 0, this.headerScratch.position());
        if (i == 0) {
            this.buffer = writableBufferAllocate;
            return;
        }
        this.sink.deliverFrame(writableBufferAllocate, false, false, this.messagesBuffered - 1);
        this.messagesBuffered = 1;
        List list = bufferChainOutputStream.bufferList;
        for (int i2 = 0; i2 < list.size() - 1; i2++) {
            this.sink.deliverFrame((WritableBuffer) list.get(i2), false, false, 0);
        }
        this.buffer = (WritableBuffer) AbstractC0000a.m10g(list, 1);
        this.currentMessageWireSize = i;
    }

    private int writeCompressed(InputStream inputStream, int i) throws IOException {
        BufferChainOutputStream bufferChainOutputStream = new BufferChainOutputStream();
        OutputStream outputStreamCompress = this.compressor.compress(bufferChainOutputStream);
        try {
            int iWriteToOutputStream = writeToOutputStream(inputStream, outputStreamCompress);
            outputStreamCompress.close();
            int i2 = this.maxOutboundMessageSize;
            if (i2 < 0 || iWriteToOutputStream <= i2) {
                writeBufferChain(bufferChainOutputStream, true);
                return iWriteToOutputStream;
            }
            Status status = Status.RESOURCE_EXHAUSTED;
            Locale locale = Locale.US;
            throw status.withDescription("message too large " + iWriteToOutputStream + " > " + this.maxOutboundMessageSize).asRuntimeException();
        } catch (Throwable th) {
            outputStreamCompress.close();
            throw th;
        }
    }

    private int writeKnownLengthUncompressed(InputStream inputStream, int i) {
        int i2 = this.maxOutboundMessageSize;
        if (i2 < 0 || i <= i2) {
            this.headerScratch.put((byte) 0).putInt(i);
            if (this.buffer == null) {
                this.buffer = this.bufferAllocator.allocate(this.headerScratch.position() + i);
            }
            writeRaw(this.headerScratch.array(), 0, this.headerScratch.position());
            return writeToOutputStream(inputStream, this.outputStreamAdapter);
        }
        Status status = Status.RESOURCE_EXHAUSTED;
        Locale locale = Locale.US;
        throw status.withDescription("message too large " + i + " > " + this.maxOutboundMessageSize).asRuntimeException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writeRaw(byte[] bArr, int i, int i2) {
        while (i2 > 0) {
            WritableBuffer writableBuffer = this.buffer;
            if (writableBuffer != null && writableBuffer.writableBytes() == 0) {
                commitToSink(false, false);
            }
            if (this.buffer == null) {
                this.buffer = this.bufferAllocator.allocate(i2);
            }
            int iMin = Math.min(i2, this.buffer.writableBytes());
            this.buffer.write(bArr, i, iMin);
            i += iMin;
            i2 -= iMin;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static int writeToOutputStream(InputStream inputStream, OutputStream outputStream) throws IOException {
        if (inputStream instanceof Drainable) {
            return ((Drainable) inputStream).drainTo(outputStream);
        }
        long jCopy = ByteStreams.copy(inputStream, outputStream);
        Preconditions.checkArgument(jCopy <= 2147483647L, "Message size overflow: %s", jCopy);
        return (int) jCopy;
    }

    private int writeUncompressed(InputStream inputStream, int i) throws IOException {
        if (i != -1) {
            this.currentMessageWireSize = i;
            return writeKnownLengthUncompressed(inputStream, i);
        }
        BufferChainOutputStream bufferChainOutputStream = new BufferChainOutputStream();
        int iWriteToOutputStream = writeToOutputStream(inputStream, bufferChainOutputStream);
        int i2 = this.maxOutboundMessageSize;
        if (i2 < 0 || iWriteToOutputStream <= i2) {
            writeBufferChain(bufferChainOutputStream, false);
            return iWriteToOutputStream;
        }
        Status status = Status.RESOURCE_EXHAUSTED;
        Locale locale = Locale.US;
        throw status.withDescription("message too large " + iWriteToOutputStream + " > " + this.maxOutboundMessageSize).asRuntimeException();
    }

    @Override // io.grpc.internal.Framer
    public void close() {
        if (isClosed()) {
            return;
        }
        this.closed = true;
        WritableBuffer writableBuffer = this.buffer;
        if (writableBuffer != null && writableBuffer.readableBytes() == 0) {
            releaseBuffer();
        }
        commitToSink(true, true);
    }

    @Override // io.grpc.internal.Framer
    public void dispose() {
        this.closed = true;
        releaseBuffer();
    }

    @Override // io.grpc.internal.Framer
    public void flush() {
        WritableBuffer writableBuffer = this.buffer;
        if (writableBuffer == null || writableBuffer.readableBytes() <= 0) {
            return;
        }
        commitToSink(false, true);
    }

    @Override // io.grpc.internal.Framer
    public boolean isClosed() {
        return this.closed;
    }

    @Override // io.grpc.internal.Framer
    public void setMaxOutboundMessageSize(int i) {
        Preconditions.checkState(this.maxOutboundMessageSize == -1, "max size already set");
        this.maxOutboundMessageSize = i;
    }

    @Override // io.grpc.internal.Framer
    public void writePayload(InputStream inputStream) {
        verifyNotClosed();
        this.messagesBuffered++;
        int i = this.currentMessageSeqNo + 1;
        this.currentMessageSeqNo = i;
        this.currentMessageWireSize = 0L;
        this.statsTraceCtx.outboundMessage(i);
        boolean z = this.messageCompression && this.compressor != Codec.Identity.NONE;
        try {
            int knownLength = getKnownLength(inputStream);
            int iWriteUncompressed = (knownLength == 0 || !z) ? writeUncompressed(inputStream, knownLength) : writeCompressed(inputStream, knownLength);
            if (knownLength != -1 && iWriteUncompressed != knownLength) {
                throw Status.INTERNAL.withDescription(AbstractC1038a.m1214o(iWriteUncompressed, knownLength, "Message length inaccurate ", " != ")).asRuntimeException();
            }
            long j = iWriteUncompressed;
            this.statsTraceCtx.outboundUncompressedSize(j);
            this.statsTraceCtx.outboundWireSize(this.currentMessageWireSize);
            this.statsTraceCtx.outboundMessageSent(this.currentMessageSeqNo, this.currentMessageWireSize, j);
        } catch (IOException e) {
            throw Status.INTERNAL.withDescription("Failed to frame message").withCause(e).asRuntimeException();
        } catch (RuntimeException e2) {
            throw Status.INTERNAL.withDescription("Failed to frame message").withCause(e2).asRuntimeException();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class OutputStreamAdapter extends OutputStream {
        private OutputStreamAdapter() {
        }

        @Override // java.io.OutputStream
        public void write(int i) {
            write(new byte[]{(byte) i}, 0, 1);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) {
            MessageFramer.this.writeRaw(bArr, i, i2);
        }
    }

    @Override // io.grpc.internal.Framer
    public MessageFramer setCompressor(Compressor compressor) {
        this.compressor = (Compressor) Preconditions.checkNotNull(compressor, "Can't pass an empty compressor");
        return this;
    }

    @Override // io.grpc.internal.Framer
    public MessageFramer setMessageCompression(boolean z) {
        this.messageCompression = z;
        return this;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public final class BufferChainOutputStream extends OutputStream {
        private final List<WritableBuffer> bufferList;
        private WritableBuffer current;

        private BufferChainOutputStream() {
            this.bufferList = new ArrayList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int readableBytes() {
            Iterator<WritableBuffer> it = this.bufferList.iterator();
            int i = 0;
            while (it.hasNext()) {
                i += it.next().readableBytes();
            }
            return i;
        }

        @Override // java.io.OutputStream
        public void write(int i) {
            WritableBuffer writableBuffer = this.current;
            if (writableBuffer == null || writableBuffer.writableBytes() <= 0) {
                write(new byte[]{(byte) i}, 0, 1);
            } else {
                this.current.write((byte) i);
            }
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) {
            if (this.current == null) {
                WritableBuffer writableBufferAllocate = MessageFramer.this.bufferAllocator.allocate(i2);
                this.current = writableBufferAllocate;
                this.bufferList.add(writableBufferAllocate);
            }
            while (i2 > 0) {
                int iMin = Math.min(i2, this.current.writableBytes());
                if (iMin == 0) {
                    WritableBuffer writableBufferAllocate2 = MessageFramer.this.bufferAllocator.allocate(Math.max(i2, this.current.readableBytes() * 2));
                    this.current = writableBufferAllocate2;
                    this.bufferList.add(writableBufferAllocate2);
                } else {
                    this.current.write(bArr, i, iMin);
                    i += iMin;
                    i2 -= iMin;
                }
            }
        }
    }
}
