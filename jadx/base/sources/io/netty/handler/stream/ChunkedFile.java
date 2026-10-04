package io.netty.handler.stream;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.internal.ObjectUtil;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class ChunkedFile implements ChunkedInput<ByteBuf> {
    private final int chunkSize;
    private final long endOffset;
    private final RandomAccessFile file;
    private long offset;
    private final long startOffset;

    public ChunkedFile(File file) {
        this(file, 8192);
    }

    @Override // io.netty.handler.stream.ChunkedInput
    public void close() throws IOException {
        this.file.close();
    }

    public long currentOffset() {
        return this.offset;
    }

    public long endOffset() {
        return this.endOffset;
    }

    @Override // io.netty.handler.stream.ChunkedInput
    public boolean isEndOfInput() {
        return this.offset >= this.endOffset || !this.file.getChannel().isOpen();
    }

    @Override // io.netty.handler.stream.ChunkedInput
    public long length() {
        return this.endOffset - this.startOffset;
    }

    @Override // io.netty.handler.stream.ChunkedInput
    public long progress() {
        return this.offset - this.startOffset;
    }

    public long startOffset() {
        return this.startOffset;
    }

    public ChunkedFile(File file, int i) {
        this(new RandomAccessFile(file, "r"), i);
    }

    public ChunkedFile(RandomAccessFile randomAccessFile) {
        this(randomAccessFile, 8192);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.netty.handler.stream.ChunkedInput
    @Deprecated
    public ByteBuf readChunk(ChannelHandlerContext channelHandlerContext) {
        return readChunk(channelHandlerContext.alloc());
    }

    public ChunkedFile(RandomAccessFile randomAccessFile, int i) {
        this(randomAccessFile, 0L, randomAccessFile.length(), i);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.netty.handler.stream.ChunkedInput
    public ByteBuf readChunk(ByteBufAllocator byteBufAllocator) {
        long j = this.offset;
        long j2 = this.endOffset;
        if (j >= j2) {
            return null;
        }
        int iMin = (int) Math.min(this.chunkSize, j2 - j);
        ByteBuf byteBufHeapBuffer = byteBufAllocator.heapBuffer(iMin);
        try {
            this.file.readFully(byteBufHeapBuffer.array(), byteBufHeapBuffer.arrayOffset(), iMin);
            byteBufHeapBuffer.writerIndex(iMin);
            this.offset = j + ((long) iMin);
            return byteBufHeapBuffer;
        } catch (Throwable th) {
            byteBufHeapBuffer.release();
            throw th;
        }
    }

    public ChunkedFile(RandomAccessFile randomAccessFile, long j, long j2, int i) throws IOException {
        ObjectUtil.checkNotNull(randomAccessFile, "file");
        ObjectUtil.checkPositiveOrZero(j, TypedValues.Cycle.S_WAVE_OFFSET);
        ObjectUtil.checkPositiveOrZero(j2, "length");
        ObjectUtil.checkPositive(i, "chunkSize");
        this.file = randomAccessFile;
        this.startOffset = j;
        this.offset = j;
        this.endOffset = j2 + j;
        this.chunkSize = i;
        randomAccessFile.seek(j);
    }
}
