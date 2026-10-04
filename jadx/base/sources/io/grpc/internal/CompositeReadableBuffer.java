package io.grpc.internal;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.InvalidMarkException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class CompositeReadableBuffer extends AbstractReadableBuffer {
    private boolean marked;
    private final Deque<ReadableBuffer> readableBuffers;
    private int readableBytes;
    private Deque<ReadableBuffer> rewindableBuffers;
    private static final NoThrowReadOperation<Void> UBYTE_OP = new NoThrowReadOperation<Void>() { // from class: io.grpc.internal.CompositeReadableBuffer.1
        @Override // io.grpc.internal.CompositeReadableBuffer.NoThrowReadOperation, io.grpc.internal.CompositeReadableBuffer.ReadOperation
        public int read(ReadableBuffer readableBuffer, int i, Void r32, int i2) {
            return readableBuffer.readUnsignedByte();
        }
    };
    private static final NoThrowReadOperation<Void> SKIP_OP = new NoThrowReadOperation<Void>() { // from class: io.grpc.internal.CompositeReadableBuffer.2
        @Override // io.grpc.internal.CompositeReadableBuffer.NoThrowReadOperation, io.grpc.internal.CompositeReadableBuffer.ReadOperation
        public int read(ReadableBuffer readableBuffer, int i, Void r32, int i2) {
            readableBuffer.skipBytes(i);
            return 0;
        }
    };
    private static final NoThrowReadOperation<byte[]> BYTE_ARRAY_OP = new NoThrowReadOperation<byte[]>() { // from class: io.grpc.internal.CompositeReadableBuffer.3
        @Override // io.grpc.internal.CompositeReadableBuffer.NoThrowReadOperation, io.grpc.internal.CompositeReadableBuffer.ReadOperation
        public int read(ReadableBuffer readableBuffer, int i, byte[] bArr, int i2) {
            readableBuffer.readBytes(bArr, i2, i);
            return i2 + i;
        }
    };
    private static final NoThrowReadOperation<ByteBuffer> BYTE_BUF_OP = new NoThrowReadOperation<ByteBuffer>() { // from class: io.grpc.internal.CompositeReadableBuffer.4
        @Override // io.grpc.internal.CompositeReadableBuffer.NoThrowReadOperation, io.grpc.internal.CompositeReadableBuffer.ReadOperation
        public int read(ReadableBuffer readableBuffer, int i, ByteBuffer byteBuffer, int i2) {
            int iLimit = byteBuffer.limit();
            byteBuffer.limit(byteBuffer.position() + i);
            readableBuffer.readBytes(byteBuffer);
            byteBuffer.limit(iLimit);
            return 0;
        }
    };
    private static final ReadOperation<OutputStream> STREAM_OP = new ReadOperation<OutputStream>() { // from class: io.grpc.internal.CompositeReadableBuffer.5
        @Override // io.grpc.internal.CompositeReadableBuffer.ReadOperation
        public int read(ReadableBuffer readableBuffer, int i, OutputStream outputStream, int i2) {
            readableBuffer.readBytes(outputStream, i);
            return 0;
        }
    };

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface NoThrowReadOperation<T> extends ReadOperation<T> {
        @Override // io.grpc.internal.CompositeReadableBuffer.ReadOperation
        int read(ReadableBuffer readableBuffer, int i, T t, int i2);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ReadOperation<T> {
        int read(ReadableBuffer readableBuffer, int i, T t, int i2);
    }

    public CompositeReadableBuffer(int i) {
        this.readableBuffers = new ArrayDeque(i);
    }

    private void advanceBuffer() {
        if (!this.marked) {
            this.readableBuffers.remove().close();
            return;
        }
        this.rewindableBuffers.add(this.readableBuffers.remove());
        ReadableBuffer readableBufferPeek = this.readableBuffers.peek();
        if (readableBufferPeek != null) {
            readableBufferPeek.mark();
        }
    }

    private void advanceBufferIfNecessary() {
        if (this.readableBuffers.peek().readableBytes() == 0) {
            advanceBuffer();
        }
    }

    private void enqueueBuffer(ReadableBuffer readableBuffer) {
        if (!(readableBuffer instanceof CompositeReadableBuffer)) {
            this.readableBuffers.add(readableBuffer);
            this.readableBytes = readableBuffer.readableBytes() + this.readableBytes;
            return;
        }
        CompositeReadableBuffer compositeReadableBuffer = (CompositeReadableBuffer) readableBuffer;
        while (!compositeReadableBuffer.readableBuffers.isEmpty()) {
            this.readableBuffers.add(compositeReadableBuffer.readableBuffers.remove());
        }
        this.readableBytes += compositeReadableBuffer.readableBytes;
        compositeReadableBuffer.readableBytes = 0;
        compositeReadableBuffer.close();
    }

    private <T> int execute(ReadOperation<T> readOperation, int i, T t, int i2) {
        checkReadable(i);
        if (!this.readableBuffers.isEmpty()) {
            advanceBufferIfNecessary();
        }
        while (i > 0 && !this.readableBuffers.isEmpty()) {
            ReadableBuffer readableBufferPeek = this.readableBuffers.peek();
            int iMin = Math.min(i, readableBufferPeek.readableBytes());
            i2 = readOperation.read(readableBufferPeek, iMin, t, i2);
            i -= iMin;
            this.readableBytes -= iMin;
            advanceBufferIfNecessary();
        }
        if (i <= 0) {
            return i2;
        }
        throw new AssertionError("Failed executing read operation");
    }

    private <T> int executeNoThrow(NoThrowReadOperation<T> noThrowReadOperation, int i, T t, int i2) {
        try {
            return execute(noThrowReadOperation, i, t, i2);
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    public void addBuffer(ReadableBuffer readableBuffer) {
        boolean z = this.marked && this.readableBuffers.isEmpty();
        enqueueBuffer(readableBuffer);
        if (z) {
            this.readableBuffers.peek().mark();
        }
    }

    @Override // io.grpc.internal.AbstractReadableBuffer, io.grpc.internal.ReadableBuffer
    public boolean byteBufferSupported() {
        Iterator<ReadableBuffer> it = this.readableBuffers.iterator();
        while (it.hasNext()) {
            if (!it.next().byteBufferSupported()) {
                return false;
            }
        }
        return true;
    }

    @Override // io.grpc.internal.AbstractReadableBuffer, io.grpc.internal.ReadableBuffer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        while (!this.readableBuffers.isEmpty()) {
            this.readableBuffers.remove().close();
        }
        if (this.rewindableBuffers != null) {
            while (!this.rewindableBuffers.isEmpty()) {
                this.rewindableBuffers.remove().close();
            }
        }
    }

    @Override // io.grpc.internal.AbstractReadableBuffer, io.grpc.internal.ReadableBuffer
    @Nullable
    public ByteBuffer getByteBuffer() {
        if (this.readableBuffers.isEmpty()) {
            return null;
        }
        return this.readableBuffers.peek().getByteBuffer();
    }

    @Override // io.grpc.internal.AbstractReadableBuffer, io.grpc.internal.ReadableBuffer
    public void mark() {
        if (this.rewindableBuffers == null) {
            this.rewindableBuffers = new ArrayDeque(Math.min(this.readableBuffers.size(), 16));
        }
        while (!this.rewindableBuffers.isEmpty()) {
            this.rewindableBuffers.remove().close();
        }
        this.marked = true;
        ReadableBuffer readableBufferPeek = this.readableBuffers.peek();
        if (readableBufferPeek != null) {
            readableBufferPeek.mark();
        }
    }

    @Override // io.grpc.internal.AbstractReadableBuffer, io.grpc.internal.ReadableBuffer
    public boolean markSupported() {
        Iterator<ReadableBuffer> it = this.readableBuffers.iterator();
        while (it.hasNext()) {
            if (!it.next().markSupported()) {
                return false;
            }
        }
        return true;
    }

    @Override // io.grpc.internal.ReadableBuffer
    public void readBytes(byte[] bArr, int i, int i2) {
        executeNoThrow(BYTE_ARRAY_OP, i2, bArr, i);
    }

    @Override // io.grpc.internal.ReadableBuffer
    public int readUnsignedByte() {
        return executeNoThrow(UBYTE_OP, 1, null, 0);
    }

    @Override // io.grpc.internal.ReadableBuffer
    public int readableBytes() {
        return this.readableBytes;
    }

    @Override // io.grpc.internal.AbstractReadableBuffer, io.grpc.internal.ReadableBuffer
    public void reset() {
        if (!this.marked) {
            throw new InvalidMarkException();
        }
        ReadableBuffer readableBufferPeek = this.readableBuffers.peek();
        if (readableBufferPeek != null) {
            int i = readableBufferPeek.readableBytes();
            readableBufferPeek.reset();
            this.readableBytes = (readableBufferPeek.readableBytes() - i) + this.readableBytes;
        }
        while (true) {
            ReadableBuffer readableBufferPollLast = this.rewindableBuffers.pollLast();
            if (readableBufferPollLast == null) {
                return;
            }
            readableBufferPollLast.reset();
            this.readableBuffers.addFirst(readableBufferPollLast);
            this.readableBytes = readableBufferPollLast.readableBytes() + this.readableBytes;
        }
    }

    @Override // io.grpc.internal.ReadableBuffer
    public void skipBytes(int i) {
        executeNoThrow(SKIP_OP, i, null, 0);
    }

    @Override // io.grpc.internal.ReadableBuffer
    public void readBytes(ByteBuffer byteBuffer) {
        executeNoThrow(BYTE_BUF_OP, byteBuffer.remaining(), byteBuffer, 0);
    }

    public CompositeReadableBuffer() {
        this.readableBuffers = new ArrayDeque();
    }

    @Override // io.grpc.internal.ReadableBuffer
    public void readBytes(OutputStream outputStream, int i) {
        execute(STREAM_OP, i, outputStream, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [io.grpc.internal.ReadableBuffer] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [io.grpc.internal.ReadableBuffer] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [io.grpc.internal.CompositeReadableBuffer] */
    /* JADX WARN: Type inference failed for: r1v3, types: [io.grpc.internal.CompositeReadableBuffer] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    @Override // io.grpc.internal.ReadableBuffer
    public ReadableBuffer readBytes(int i) {
        ReadableBuffer readableBufferPoll;
        int i2;
        ReadableBuffer bytes;
        ?? r12;
        ?? r02;
        if (i <= 0) {
            return ReadableBuffers.empty();
        }
        checkReadable(i);
        this.readableBytes -= i;
        ?? r03 = 0;
        ?? compositeReadableBuffer = 0;
        while (true) {
            ReadableBuffer readableBufferPeek = this.readableBuffers.peek();
            int i4 = readableBufferPeek.readableBytes();
            if (i4 > i) {
                bytes = readableBufferPeek.readBytes(i);
                i2 = 0;
            } else {
                if (this.marked) {
                    readableBufferPoll = readableBufferPeek.readBytes(i4);
                    advanceBuffer();
                } else {
                    readableBufferPoll = this.readableBuffers.poll();
                }
                ReadableBuffer readableBuffer = readableBufferPoll;
                i2 = i - i4;
                bytes = readableBuffer;
            }
            if (r03 == 0) {
                r02 = bytes;
                r12 = compositeReadableBuffer;
            } else {
                if (compositeReadableBuffer == 0) {
                    compositeReadableBuffer = new CompositeReadableBuffer(i2 != 0 ? Math.min(this.readableBuffers.size() + 2, 16) : 2);
                    compositeReadableBuffer.addBuffer(r03);
                    r03 = compositeReadableBuffer;
                }
                compositeReadableBuffer.addBuffer(bytes);
                r02 = r03;
                r12 = compositeReadableBuffer;
            }
            if (i2 <= 0) {
                return r02;
            }
            i = i2;
            r03 = r02;
            compositeReadableBuffer = r12;
        }
    }
}
