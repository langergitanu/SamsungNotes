package io.netty.handler.stream;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.internal.ObjectUtil;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.FileChannel;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class ChunkedNioFile implements ChunkedInput<ByteBuf> {
    private final int chunkSize;
    private final long endOffset;

    /* JADX INFO: renamed from: in */
    private final FileChannel f8955in;
    private long offset;
    private final long startOffset;

    public ChunkedNioFile(File file) {
        this(new RandomAccessFile(file, "r").getChannel());
    }

    @Override // io.netty.handler.stream.ChunkedInput
    public void close() throws IOException {
        this.f8955in.close();
    }

    public long currentOffset() {
        return this.offset;
    }

    public long endOffset() {
        return this.endOffset;
    }

    @Override // io.netty.handler.stream.ChunkedInput
    public boolean isEndOfInput() {
        return this.offset >= this.endOffset || !this.f8955in.isOpen();
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

    public ChunkedNioFile(File file, int i) {
        this(new RandomAccessFile(file, "r").getChannel(), i);
    }

    public ChunkedNioFile(FileChannel fileChannel) {
        this(fileChannel, 8192);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.netty.handler.stream.ChunkedInput
    @Deprecated
    public ByteBuf readChunk(ChannelHandlerContext channelHandlerContext) {
        return readChunk(channelHandlerContext.alloc());
    }

    public ChunkedNioFile(FileChannel fileChannel, int i) {
        this(fileChannel, 0L, fileChannel.size(), i);
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
        ByteBuf byteBufBuffer = byteBufAllocator.buffer(iMin);
        int i = 0;
        do {
            try {
                int iWriteBytes = byteBufBuffer.writeBytes(this.f8955in, ((long) i) + j, iMin - i);
                if (iWriteBytes < 0) {
                    break;
                }
                i += iWriteBytes;
            } catch (Throwable th) {
                byteBufBuffer.release();
                throw th;
            }
        } while (i != iMin);
        this.offset += (long) i;
        return byteBufBuffer;
    }

    public ChunkedNioFile(FileChannel fileChannel, long j, long j2, int i) throws ClosedChannelException {
        ObjectUtil.checkNotNull(fileChannel, "in");
        ObjectUtil.checkPositiveOrZero(j, TypedValues.Cycle.S_WAVE_OFFSET);
        ObjectUtil.checkPositiveOrZero(j2, "length");
        ObjectUtil.checkPositive(i, "chunkSize");
        if (fileChannel.isOpen()) {
            this.f8955in = fileChannel;
            this.chunkSize = i;
            this.startOffset = j;
            this.offset = j;
            this.endOffset = j + j2;
            return;
        }
        throw new ClosedChannelException();
    }
}
