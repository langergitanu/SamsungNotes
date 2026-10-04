package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.stream.ChunkedInput;
import io.netty.util.internal.ObjectUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class Http2DataChunkedInput implements ChunkedInput<Http2DataFrame> {
    private boolean endStreamSent;
    private final ChunkedInput<ByteBuf> input;
    private final Http2FrameStream stream;

    public Http2DataChunkedInput(ChunkedInput<ByteBuf> chunkedInput, Http2FrameStream http2FrameStream) {
        this.input = (ChunkedInput) ObjectUtil.checkNotNull(chunkedInput, "input");
        this.stream = (Http2FrameStream) ObjectUtil.checkNotNull(http2FrameStream, "stream");
    }

    @Override // io.netty.handler.stream.ChunkedInput
    public void close() {
        this.input.close();
    }

    @Override // io.netty.handler.stream.ChunkedInput
    public boolean isEndOfInput() {
        if (this.input.isEndOfInput()) {
            return this.endStreamSent;
        }
        return false;
    }

    @Override // io.netty.handler.stream.ChunkedInput
    public long length() {
        return this.input.length();
    }

    @Override // io.netty.handler.stream.ChunkedInput
    public long progress() {
        return this.input.progress();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.netty.handler.stream.ChunkedInput
    @Deprecated
    public Http2DataFrame readChunk(ChannelHandlerContext channelHandlerContext) {
        return readChunk(channelHandlerContext.alloc());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.netty.handler.stream.ChunkedInput
    public Http2DataFrame readChunk(ByteBufAllocator byteBufAllocator) {
        if (this.endStreamSent) {
            return null;
        }
        if (this.input.isEndOfInput()) {
            this.endStreamSent = true;
            return new DefaultHttp2DataFrame(true).stream(this.stream);
        }
        ByteBuf chunk = this.input.readChunk(byteBufAllocator);
        if (chunk == null) {
            return null;
        }
        DefaultHttp2DataFrame defaultHttp2DataFrameStream = new DefaultHttp2DataFrame(chunk, this.input.isEndOfInput()).stream(this.stream);
        if (defaultHttp2DataFrameStream.isEndStream()) {
            this.endStreamSent = true;
        }
        return defaultHttp2DataFrameStream;
    }
}
