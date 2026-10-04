package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import io.grpc.Codec;
import io.grpc.Decompressor;
import io.grpc.Status;
import io.grpc.internal.StreamListener;
import java.io.Closeable;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.zip.DataFormatException;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@NotThreadSafe
public class MessageDeframer implements Closeable, Deframer {
    private static final int COMPRESSED_FLAG_MASK = 1;
    private static final int HEADER_LENGTH = 5;
    private static final int MAX_BUFFER_SIZE = 2097152;
    private static final int RESERVED_MASK = 254;
    private boolean compressedFlag;
    private Decompressor decompressor;
    private GzipInflatingBuffer fullStreamDecompressor;
    private int inboundBodyWireSize;
    private byte[] inflatedBuffer;
    private int inflatedIndex;
    private Listener listener;
    private int maxInboundMessageSize;
    private CompositeReadableBuffer nextFrame;
    private long pendingDeliveries;
    private final StatsTraceContext statsTraceCtx;
    private final TransportTracer transportTracer;
    private State state = State.HEADER;
    private int requiredLength = 5;
    private CompositeReadableBuffer unprocessed = new CompositeReadableBuffer();
    private boolean inDelivery = false;
    private int currentMessageSeqNo = -1;
    private boolean closeWhenComplete = false;
    private volatile boolean stopDelivery = false;

    /* JADX INFO: renamed from: io.grpc.internal.MessageDeframer$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C121841 {
        static final /* synthetic */ int[] $SwitchMap$io$grpc$internal$MessageDeframer$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$io$grpc$internal$MessageDeframer$State = iArr;
            try {
                iArr[State.HEADER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$grpc$internal$MessageDeframer$State[State.BODY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Listener {
        void bytesRead(int i);

        void deframeFailed(Throwable th);

        void deframerClosed(boolean z);

        void messagesAvailable(StreamListener.MessageProducer messageProducer);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SingleMessageProducer implements StreamListener.MessageProducer {
        private InputStream message;

        public /* synthetic */ SingleMessageProducer(InputStream inputStream, C121841 c121841) {
            this(inputStream);
        }

        @Override // io.grpc.internal.StreamListener.MessageProducer
        @Nullable
        public InputStream next() {
            InputStream inputStream = this.message;
            this.message = null;
            return inputStream;
        }

        private SingleMessageProducer(InputStream inputStream) {
            this.message = inputStream;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum State {
        HEADER,
        BODY
    }

    public MessageDeframer(Listener listener, Decompressor decompressor, int i, StatsTraceContext statsTraceContext, TransportTracer transportTracer) {
        this.listener = (Listener) Preconditions.checkNotNull(listener, "sink");
        this.decompressor = (Decompressor) Preconditions.checkNotNull(decompressor, "decompressor");
        this.maxInboundMessageSize = i;
        this.statsTraceCtx = (StatsTraceContext) Preconditions.checkNotNull(statsTraceContext, "statsTraceCtx");
        this.transportTracer = (TransportTracer) Preconditions.checkNotNull(transportTracer, "transportTracer");
    }

    private void deliver() {
        if (this.inDelivery) {
            return;
        }
        this.inDelivery = true;
        while (!this.stopDelivery && this.pendingDeliveries > 0 && readRequiredBytes()) {
            try {
                int i = C121841.$SwitchMap$io$grpc$internal$MessageDeframer$State[this.state.ordinal()];
                if (i == 1) {
                    processHeader();
                } else {
                    if (i != 2) {
                        throw new AssertionError("Invalid state: " + this.state);
                    }
                    processBody();
                    this.pendingDeliveries--;
                }
            } catch (Throwable th) {
                this.inDelivery = false;
                throw th;
            }
        }
        if (this.stopDelivery) {
            close();
            this.inDelivery = false;
        } else {
            if (this.closeWhenComplete && isStalled()) {
                close();
            }
            this.inDelivery = false;
        }
    }

    private InputStream getCompressedBody() {
        Decompressor decompressor = this.decompressor;
        if (decompressor == Codec.Identity.NONE) {
            throw Status.INTERNAL.withDescription("Can't decode compressed gRPC message as compression not configured").asRuntimeException();
        }
        try {
            return new SizeEnforcingInputStream(decompressor.decompress(ReadableBuffers.openStream(this.nextFrame, true)), this.maxInboundMessageSize, this.statsTraceCtx);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private InputStream getUncompressedBody() {
        this.statsTraceCtx.inboundUncompressedSize(this.nextFrame.readableBytes());
        return ReadableBuffers.openStream(this.nextFrame, true);
    }

    private boolean isClosedOrScheduledToClose() {
        return isClosed() || this.closeWhenComplete;
    }

    private boolean isStalled() {
        GzipInflatingBuffer gzipInflatingBuffer = this.fullStreamDecompressor;
        return gzipInflatingBuffer != null ? gzipInflatingBuffer.isStalled() : this.unprocessed.readableBytes() == 0;
    }

    private void processBody() {
        this.statsTraceCtx.inboundMessageRead(this.currentMessageSeqNo, this.inboundBodyWireSize, -1L);
        this.inboundBodyWireSize = 0;
        InputStream compressedBody = this.compressedFlag ? getCompressedBody() : getUncompressedBody();
        this.nextFrame = null;
        this.listener.messagesAvailable(new SingleMessageProducer(compressedBody, null));
        this.state = State.HEADER;
        this.requiredLength = 5;
    }

    private void processHeader() {
        int unsignedByte = this.nextFrame.readUnsignedByte();
        if ((unsignedByte & 254) != 0) {
            throw Status.INTERNAL.withDescription("gRPC frame header malformed: reserved bits not zero").asRuntimeException();
        }
        this.compressedFlag = (unsignedByte & 1) != 0;
        int i = this.nextFrame.readInt();
        this.requiredLength = i;
        if (i >= 0 && i <= this.maxInboundMessageSize) {
            int i2 = this.currentMessageSeqNo + 1;
            this.currentMessageSeqNo = i2;
            this.statsTraceCtx.inboundMessage(i2);
            this.transportTracer.reportMessageReceived();
            this.state = State.BODY;
            return;
        }
        Status status = Status.RESOURCE_EXHAUSTED;
        Locale locale = Locale.US;
        throw status.withDescription("gRPC message exceeds maximum size " + this.maxInboundMessageSize + ": " + this.requiredLength).asRuntimeException();
    }

    private boolean readRequiredBytes() throws Throwable {
        int andResetDeflatedBytesConsumed;
        int i = 0;
        try {
            if (this.nextFrame == null) {
                this.nextFrame = new CompositeReadableBuffer();
            }
            int andResetBytesConsumed = 0;
            andResetDeflatedBytesConsumed = 0;
            while (true) {
                try {
                    int i2 = this.requiredLength - this.nextFrame.readableBytes();
                    if (i2 <= 0) {
                        if (andResetBytesConsumed > 0) {
                            this.listener.bytesRead(andResetBytesConsumed);
                            if (this.state == State.BODY) {
                                if (this.fullStreamDecompressor != null) {
                                    this.statsTraceCtx.inboundWireSize(andResetDeflatedBytesConsumed);
                                    this.inboundBodyWireSize += andResetDeflatedBytesConsumed;
                                    return true;
                                }
                                this.statsTraceCtx.inboundWireSize(andResetBytesConsumed);
                                this.inboundBodyWireSize += andResetBytesConsumed;
                            }
                        }
                        return true;
                    }
                    if (this.fullStreamDecompressor != null) {
                        try {
                            byte[] bArr = this.inflatedBuffer;
                            if (bArr == null || this.inflatedIndex == bArr.length) {
                                this.inflatedBuffer = new byte[Math.min(i2, 2097152)];
                                this.inflatedIndex = 0;
                            }
                            int iInflateBytes = this.fullStreamDecompressor.inflateBytes(this.inflatedBuffer, this.inflatedIndex, Math.min(i2, this.inflatedBuffer.length - this.inflatedIndex));
                            andResetBytesConsumed += this.fullStreamDecompressor.getAndResetBytesConsumed();
                            andResetDeflatedBytesConsumed += this.fullStreamDecompressor.getAndResetDeflatedBytesConsumed();
                            if (iInflateBytes == 0) {
                                if (andResetBytesConsumed > 0) {
                                    this.listener.bytesRead(andResetBytesConsumed);
                                    if (this.state == State.BODY) {
                                        if (this.fullStreamDecompressor != null) {
                                            this.statsTraceCtx.inboundWireSize(andResetDeflatedBytesConsumed);
                                            this.inboundBodyWireSize += andResetDeflatedBytesConsumed;
                                            return false;
                                        }
                                        this.statsTraceCtx.inboundWireSize(andResetBytesConsumed);
                                        this.inboundBodyWireSize += andResetBytesConsumed;
                                    }
                                }
                                return false;
                            }
                            this.nextFrame.addBuffer(ReadableBuffers.wrap(this.inflatedBuffer, this.inflatedIndex, iInflateBytes));
                            this.inflatedIndex += iInflateBytes;
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        } catch (DataFormatException e2) {
                            throw new RuntimeException(e2);
                        }
                    } else {
                        if (this.unprocessed.readableBytes() == 0) {
                            if (andResetBytesConsumed > 0) {
                                this.listener.bytesRead(andResetBytesConsumed);
                                if (this.state == State.BODY) {
                                    if (this.fullStreamDecompressor != null) {
                                        this.statsTraceCtx.inboundWireSize(andResetDeflatedBytesConsumed);
                                        this.inboundBodyWireSize += andResetDeflatedBytesConsumed;
                                        return false;
                                    }
                                    this.statsTraceCtx.inboundWireSize(andResetBytesConsumed);
                                    this.inboundBodyWireSize += andResetBytesConsumed;
                                }
                            }
                            return false;
                        }
                        int iMin = Math.min(i2, this.unprocessed.readableBytes());
                        andResetBytesConsumed += iMin;
                        this.nextFrame.addBuffer(this.unprocessed.readBytes(iMin));
                    }
                } catch (Throwable th) {
                    int i4 = andResetBytesConsumed;
                    th = th;
                    i = i4;
                    if (i > 0) {
                        this.listener.bytesRead(i);
                        if (this.state == State.BODY) {
                            if (this.fullStreamDecompressor != null) {
                                this.statsTraceCtx.inboundWireSize(andResetDeflatedBytesConsumed);
                                this.inboundBodyWireSize += andResetDeflatedBytesConsumed;
                            } else {
                                this.statsTraceCtx.inboundWireSize(i);
                                this.inboundBodyWireSize += i;
                            }
                        }
                    }
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            andResetDeflatedBytesConsumed = 0;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, io.grpc.internal.Deframer
    public void close() {
        if (isClosed()) {
            return;
        }
        CompositeReadableBuffer compositeReadableBuffer = this.nextFrame;
        boolean z = compositeReadableBuffer != null && compositeReadableBuffer.readableBytes() > 0;
        try {
            GzipInflatingBuffer gzipInflatingBuffer = this.fullStreamDecompressor;
            if (gzipInflatingBuffer != null) {
                boolean z2 = z || gzipInflatingBuffer.hasPartialData();
                this.fullStreamDecompressor.close();
                z = z2;
            }
            CompositeReadableBuffer compositeReadableBuffer2 = this.unprocessed;
            if (compositeReadableBuffer2 != null) {
                compositeReadableBuffer2.close();
            }
            CompositeReadableBuffer compositeReadableBuffer3 = this.nextFrame;
            if (compositeReadableBuffer3 != null) {
                compositeReadableBuffer3.close();
            }
            this.fullStreamDecompressor = null;
            this.unprocessed = null;
            this.nextFrame = null;
            this.listener.deframerClosed(z);
        } catch (Throwable th) {
            this.fullStreamDecompressor = null;
            this.unprocessed = null;
            this.nextFrame = null;
            throw th;
        }
    }

    @Override // io.grpc.internal.Deframer
    public void closeWhenComplete() {
        if (isClosed()) {
            return;
        }
        if (isStalled()) {
            close();
        } else {
            this.closeWhenComplete = true;
        }
    }

    @Override // io.grpc.internal.Deframer
    public void deframe(ReadableBuffer readableBuffer) throws Throwable {
        Preconditions.checkNotNull(readableBuffer, "data");
        boolean z = true;
        try {
            if (isClosedOrScheduledToClose()) {
                readableBuffer.close();
                return;
            }
            GzipInflatingBuffer gzipInflatingBuffer = this.fullStreamDecompressor;
            if (gzipInflatingBuffer != null) {
                gzipInflatingBuffer.addGzippedBytes(readableBuffer);
            } else {
                this.unprocessed.addBuffer(readableBuffer);
            }
            try {
                deliver();
            } catch (Throwable th) {
                th = th;
                z = false;
                if (z) {
                    readableBuffer.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public boolean hasPendingDeliveries() {
        return this.pendingDeliveries != 0;
    }

    public boolean isClosed() {
        return this.unprocessed == null && this.fullStreamDecompressor == null;
    }

    @Override // io.grpc.internal.Deframer
    public void request(int i) {
        Preconditions.checkArgument(i > 0, "numMessages must be > 0");
        if (isClosed()) {
            return;
        }
        this.pendingDeliveries += (long) i;
        deliver();
    }

    @Override // io.grpc.internal.Deframer
    public void setDecompressor(Decompressor decompressor) {
        Preconditions.checkState(this.fullStreamDecompressor == null, "Already set full stream decompressor");
        this.decompressor = (Decompressor) Preconditions.checkNotNull(decompressor, "Can't pass an empty decompressor");
    }

    @Override // io.grpc.internal.Deframer
    public void setFullStreamDecompressor(GzipInflatingBuffer gzipInflatingBuffer) {
        Preconditions.checkState(this.decompressor == Codec.Identity.NONE, "per-message decompressor already set");
        Preconditions.checkState(this.fullStreamDecompressor == null, "full stream decompressor already set");
        this.fullStreamDecompressor = (GzipInflatingBuffer) Preconditions.checkNotNull(gzipInflatingBuffer, "Can't pass a null full stream decompressor");
        this.unprocessed = null;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    @Override // io.grpc.internal.Deframer
    public void setMaxInboundMessageSize(int i) {
        this.maxInboundMessageSize = i;
    }

    public void stopDelivery() {
        this.stopDelivery = true;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @VisibleForTesting
    public static final class SizeEnforcingInputStream extends FilterInputStream {
        private long count;
        private long mark;
        private long maxCount;
        private final int maxMessageSize;
        private final StatsTraceContext statsTraceCtx;

        public SizeEnforcingInputStream(InputStream inputStream, int i, StatsTraceContext statsTraceContext) {
            super(inputStream);
            this.mark = -1L;
            this.maxMessageSize = i;
            this.statsTraceCtx = statsTraceContext;
        }

        private void reportCount() {
            long j = this.count;
            long j2 = this.maxCount;
            if (j > j2) {
                this.statsTraceCtx.inboundUncompressedSize(j - j2);
                this.maxCount = this.count;
            }
        }

        private void verifySize() {
            if (this.count <= this.maxMessageSize) {
                return;
            }
            throw Status.RESOURCE_EXHAUSTED.withDescription("Decompressed gRPC message exceeds maximum size " + this.maxMessageSize).asRuntimeException();
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void mark(int i) {
            ((FilterInputStream) this).in.mark(i);
            this.mark = this.count;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int i = ((FilterInputStream) this).in.read();
            if (i != -1) {
                this.count++;
            }
            verifySize();
            reportCount();
            return i;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void reset() {
            if (!((FilterInputStream) this).in.markSupported()) {
                throw new IOException("Mark not supported");
            }
            if (this.mark == -1) {
                throw new IOException("Mark not set");
            }
            ((FilterInputStream) this).in.reset();
            this.count = this.mark;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public long skip(long j) throws IOException {
            long jSkip = ((FilterInputStream) this).in.skip(j);
            this.count += jSkip;
            verifySize();
            reportCount();
            return jSkip;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int i4 = ((FilterInputStream) this).in.read(bArr, i, i2);
            if (i4 != -1) {
                this.count += (long) i4;
            }
            verifySize();
            reportCount();
            return i4;
        }
    }
}
