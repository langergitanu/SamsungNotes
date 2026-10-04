package io.netty.handler.stream;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.internal.ObjectUtil;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class ChunkedStream implements ChunkedInput<ByteBuf> {
    static final int DEFAULT_CHUNK_SIZE = 8192;
    private final int chunkSize;
    private boolean closed;

    /* JADX INFO: renamed from: in */
    private final PushbackInputStream f8957in;
    private long offset;

    public ChunkedStream(InputStream inputStream) {
        this(inputStream, 8192);
    }

    @Override // io.netty.handler.stream.ChunkedInput
    public void close() throws IOException {
        this.closed = true;
        this.f8957in.close();
    }

    @Override // io.netty.handler.stream.ChunkedInput
    public boolean isEndOfInput() throws IOException {
        if (this.closed) {
            return true;
        }
        if (this.f8957in.available() > 0) {
            return false;
        }
        int i = this.f8957in.read();
        if (i < 0) {
            return true;
        }
        this.f8957in.unread(i);
        return false;
    }

    @Override // io.netty.handler.stream.ChunkedInput
    public long length() {
        return -1L;
    }

    @Override // io.netty.handler.stream.ChunkedInput
    public long progress() {
        return this.offset;
    }

    public long transferredBytes() {
        return this.offset;
    }

    public ChunkedStream(InputStream inputStream, int i) {
        ObjectUtil.checkNotNull(inputStream, "in");
        ObjectUtil.checkPositive(i, "chunkSize");
        if (inputStream instanceof PushbackInputStream) {
            this.f8957in = (PushbackInputStream) inputStream;
        } else {
            this.f8957in = new PushbackInputStream(inputStream);
        }
        this.chunkSize = i;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.netty.handler.stream.ChunkedInput
    @Deprecated
    public ByteBuf readChunk(ChannelHandlerContext channelHandlerContext) {
        return readChunk(channelHandlerContext.alloc());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.netty.handler.stream.ChunkedInput
    public ByteBuf readChunk(ByteBufAllocator byteBufAllocator) {
        int iMin;
        if (isEndOfInput()) {
            return null;
        }
        if (this.f8957in.available() <= 0) {
            iMin = this.chunkSize;
        } else {
            iMin = Math.min(this.chunkSize, this.f8957in.available());
        }
        ByteBuf byteBufBuffer = byteBufAllocator.buffer(iMin);
        try {
            int iWriteBytes = byteBufBuffer.writeBytes(this.f8957in, iMin);
            if (iWriteBytes < 0) {
                return null;
            }
            this.offset += (long) iWriteBytes;
            return byteBufBuffer;
        } finally {
            byteBufBuffer.release();
        }
    }
}
