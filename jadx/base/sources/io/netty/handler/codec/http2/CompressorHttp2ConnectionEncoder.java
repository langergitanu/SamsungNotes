package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.compression.Brotli;
import io.netty.handler.codec.compression.BrotliEncoder;
import io.netty.handler.codec.compression.BrotliOptions;
import io.netty.handler.codec.compression.CompressionOptions;
import io.netty.handler.codec.compression.DeflateOptions;
import io.netty.handler.codec.compression.GzipOptions;
import io.netty.handler.codec.compression.StandardCompressionOptions;
import io.netty.handler.codec.compression.ZlibCodecFactory;
import io.netty.handler.codec.compression.ZlibWrapper;
import io.netty.handler.codec.compression.ZstdEncoder;
import io.netty.handler.codec.compression.ZstdOptions;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http2.Http2Connection;
import io.netty.util.AsciiString;
import io.netty.util.concurrent.Promise;
import io.netty.util.concurrent.PromiseCombiner;
import io.netty.util.internal.ObjectUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class CompressorHttp2ConnectionEncoder extends DecoratingHttp2ConnectionEncoder {
    public static final int DEFAULT_COMPRESSION_LEVEL = 6;
    public static final int DEFAULT_MEM_LEVEL = 8;
    public static final int DEFAULT_WINDOW_BITS = 15;
    private BrotliOptions brotliOptions;
    private int compressionLevel;
    private DeflateOptions deflateOptions;
    private GzipOptions gzipCompressionOptions;
    private int memLevel;
    private final Http2Connection.PropertyKey propertyKey;
    private final boolean supportsCompressionOptions;
    private int windowBits;
    private ZstdOptions zstdOptions;

    public CompressorHttp2ConnectionEncoder(Http2ConnectionEncoder http2ConnectionEncoder) {
        this(http2ConnectionEncoder, defaultCompressionOptions());
    }

    private void bindCompressorToStream(EmbeddedChannel embeddedChannel, int i) {
        Http2Stream http2StreamStream;
        if (embeddedChannel == null || (http2StreamStream = connection().stream(i)) == null) {
            return;
        }
        http2StreamStream.setProperty(this.propertyKey, embeddedChannel);
    }

    private static CompressionOptions[] defaultCompressionOptions() {
        return Brotli.isAvailable() ? new CompressionOptions[]{StandardCompressionOptions.brotli(), StandardCompressionOptions.gzip(), StandardCompressionOptions.deflate()} : new CompressionOptions[]{StandardCompressionOptions.gzip(), StandardCompressionOptions.deflate()};
    }

    private EmbeddedChannel newCompressionChannel(ChannelHandlerContext channelHandlerContext, ZlibWrapper zlibWrapper) {
        if (!this.supportsCompressionOptions) {
            return new EmbeddedChannel(channelHandlerContext.channel().mo13765id(), channelHandlerContext.channel().metadata().hasDisconnect(), channelHandlerContext.channel().config(), ZlibCodecFactory.newZlibEncoder(zlibWrapper, this.compressionLevel, this.windowBits, this.memLevel));
        }
        if (zlibWrapper == ZlibWrapper.GZIP && this.gzipCompressionOptions != null) {
            return new EmbeddedChannel(channelHandlerContext.channel().mo13765id(), channelHandlerContext.channel().metadata().hasDisconnect(), channelHandlerContext.channel().config(), ZlibCodecFactory.newZlibEncoder(zlibWrapper, this.gzipCompressionOptions.compressionLevel(), this.gzipCompressionOptions.windowBits(), this.gzipCompressionOptions.memLevel()));
        }
        if (zlibWrapper == ZlibWrapper.ZLIB && this.deflateOptions != null) {
            return new EmbeddedChannel(channelHandlerContext.channel().mo13765id(), channelHandlerContext.channel().metadata().hasDisconnect(), channelHandlerContext.channel().config(), ZlibCodecFactory.newZlibEncoder(zlibWrapper, this.deflateOptions.compressionLevel(), this.deflateOptions.windowBits(), this.deflateOptions.memLevel()));
        }
        throw new IllegalArgumentException("Unsupported ZlibWrapper: " + zlibWrapper);
    }

    private EmbeddedChannel newCompressor(ChannelHandlerContext channelHandlerContext, Http2Headers http2Headers, boolean z) {
        if (z) {
            return null;
        }
        AsciiString asciiString = HttpHeaderNames.CONTENT_ENCODING;
        CharSequence charSequence = http2Headers.get(asciiString);
        if (charSequence == null) {
            charSequence = HttpHeaderValues.IDENTITY;
        }
        EmbeddedChannel embeddedChannelNewContentCompressor = newContentCompressor(channelHandlerContext, charSequence);
        if (embeddedChannelNewContentCompressor != null) {
            CharSequence targetContentEncoding = getTargetContentEncoding(charSequence);
            if (HttpHeaderValues.IDENTITY.contentEqualsIgnoreCase(targetContentEncoding)) {
                http2Headers.remove(asciiString);
            } else {
                http2Headers.set(asciiString, targetContentEncoding);
            }
            http2Headers.remove(HttpHeaderNames.CONTENT_LENGTH);
        }
        return embeddedChannelNewContentCompressor;
    }

    private static ByteBuf nextReadableBuf(EmbeddedChannel embeddedChannel) {
        while (true) {
            ByteBuf byteBuf = (ByteBuf) embeddedChannel.readOutbound();
            if (byteBuf == null) {
                return null;
            }
            if (byteBuf.isReadable()) {
                return byteBuf;
            }
            byteBuf.release();
        }
    }

    public void cleanup(Http2Stream http2Stream, EmbeddedChannel embeddedChannel) {
        embeddedChannel.finishAndReleaseAll();
        http2Stream.removeProperty(this.propertyKey);
    }

    public EmbeddedChannel newContentCompressor(ChannelHandlerContext channelHandlerContext, CharSequence charSequence) {
        if (HttpHeaderValues.GZIP.contentEqualsIgnoreCase(charSequence) || HttpHeaderValues.X_GZIP.contentEqualsIgnoreCase(charSequence)) {
            return newCompressionChannel(channelHandlerContext, ZlibWrapper.GZIP);
        }
        if (HttpHeaderValues.DEFLATE.contentEqualsIgnoreCase(charSequence) || HttpHeaderValues.X_DEFLATE.contentEqualsIgnoreCase(charSequence)) {
            return newCompressionChannel(channelHandlerContext, ZlibWrapper.ZLIB);
        }
        if (Brotli.isAvailable() && this.brotliOptions != null && HttpHeaderValues.f8893BR.contentEqualsIgnoreCase(charSequence)) {
            return new EmbeddedChannel(channelHandlerContext.channel().mo13765id(), channelHandlerContext.channel().metadata().hasDisconnect(), channelHandlerContext.channel().config(), new BrotliEncoder(this.brotliOptions.parameters()));
        }
        if (this.zstdOptions == null || !HttpHeaderValues.ZSTD.contentEqualsIgnoreCase(charSequence)) {
            return null;
        }
        return new EmbeddedChannel(channelHandlerContext.channel().mo13765id(), channelHandlerContext.channel().metadata().hasDisconnect(), channelHandlerContext.channel().config(), new ZstdEncoder(this.zstdOptions.compressionLevel(), this.zstdOptions.blockSize(), this.zstdOptions.maxEncodeSize()));
    }

    @Override // io.netty.handler.codec.http2.DecoratingHttp2FrameWriter, io.netty.handler.codec.http2.Http2DataWriter
    public ChannelFuture writeData(ChannelHandlerContext channelHandlerContext, int i, ByteBuf byteBuf, int i2, boolean z, ChannelPromise channelPromise) {
        ChannelPromise channelPromise2;
        Throwable th;
        ByteBuf byteBufNextReadableBuf;
        boolean z2;
        Http2Stream http2StreamStream = connection().stream(i);
        EmbeddedChannel embeddedChannel = http2StreamStream == null ? null : (EmbeddedChannel) http2StreamStream.getProperty(this.propertyKey);
        if (embeddedChannel == null) {
            return super.writeData(channelHandlerContext, i, byteBuf, i2, z, channelPromise);
        }
        try {
            embeddedChannel.writeOutbound(byteBuf);
            byteBufNextReadableBuf = nextReadableBuf(embeddedChannel);
            try {
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            channelPromise2 = channelPromise;
        }
        try {
            if (byteBufNextReadableBuf != null) {
                channelPromise2 = channelPromise;
                PromiseCombiner promiseCombiner = new PromiseCombiner(channelHandlerContext.executor());
                int i4 = i2;
                while (true) {
                    ByteBuf byteBuf2 = byteBufNextReadableBuf;
                    byteBufNextReadableBuf = nextReadableBuf(embeddedChannel);
                    boolean z3 = true;
                    boolean z4 = byteBufNextReadableBuf == null && z;
                    if (z4 && embeddedChannel.finish()) {
                        byteBufNextReadableBuf = nextReadableBuf(embeddedChannel);
                        if (byteBufNextReadableBuf != null) {
                            z3 = false;
                        }
                        z2 = z3;
                    } else {
                        z2 = z4;
                    }
                    ChannelPromise channelPromiseNewPromise = channelHandlerContext.newPromise();
                    promiseCombiner.add((Promise) channelPromiseNewPromise);
                    super.writeData(channelHandlerContext, i, byteBuf2, i4, z2, channelPromiseNewPromise);
                    if (byteBufNextReadableBuf == null) {
                        break;
                    }
                    i4 = 0;
                }
                promiseCombiner.finish(channelPromise2);
                if (z) {
                    cleanup(http2StreamStream, embeddedChannel);
                    return channelPromise2;
                }
                return channelPromise2;
            }
            if (!z) {
                channelPromise.setSuccess();
                if (z) {
                    cleanup(http2StreamStream, embeddedChannel);
                }
                return channelPromise;
            }
            if (embeddedChannel.finish()) {
                try {
                    byteBufNextReadableBuf = nextReadableBuf(embeddedChannel);
                } catch (Throwable th4) {
                    th = th4;
                    channelPromise2 = channelPromise;
                }
            }
            if (byteBufNextReadableBuf == null) {
                byteBufNextReadableBuf = Unpooled.EMPTY_BUFFER;
            }
            try {
                ChannelFuture channelFutureWriteData = super.writeData(channelHandlerContext, i, byteBufNextReadableBuf, i2, true, channelPromise);
                if (z) {
                    cleanup(http2StreamStream, embeddedChannel);
                }
                return channelFutureWriteData;
            } catch (Throwable th5) {
                th = th5;
                channelPromise2 = channelPromise;
            }
            channelPromise2.tryFailure(th);
            if (z) {
                cleanup(http2StreamStream, embeddedChannel);
            }
            return channelPromise2;
        } finally {
        }
        th = th;
    }

    @Override // io.netty.handler.codec.http2.DecoratingHttp2FrameWriter, io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeHeaders(ChannelHandlerContext channelHandlerContext, int i, Http2Headers http2Headers, int i2, boolean z, ChannelPromise channelPromise) {
        EmbeddedChannel embeddedChannelNewCompressor;
        ChannelFuture channelFutureWriteHeaders;
        try {
            embeddedChannelNewCompressor = newCompressor(channelHandlerContext, http2Headers, z);
            channelFutureWriteHeaders = super.writeHeaders(channelHandlerContext, i, http2Headers, i2, z, channelPromise);
        } catch (Throwable th) {
            th = th;
        }
        try {
            bindCompressorToStream(embeddedChannelNewCompressor, i);
            return channelFutureWriteHeaders;
        } catch (Throwable th2) {
            th = th2;
            channelPromise.tryFailure(th);
            return channelPromise;
        }
    }

    @Deprecated
    public CompressorHttp2ConnectionEncoder(Http2ConnectionEncoder http2ConnectionEncoder, int i, int i2, int i4) {
        super(http2ConnectionEncoder);
        this.compressionLevel = ObjectUtil.checkInRange(i, 0, 9, "compressionLevel");
        this.windowBits = ObjectUtil.checkInRange(i2, 9, 15, "windowBits");
        this.memLevel = ObjectUtil.checkInRange(i4, 1, 9, "memLevel");
        this.propertyKey = connection().newKey();
        connection().addListener(new Http2ConnectionAdapter() { // from class: io.netty.handler.codec.http2.CompressorHttp2ConnectionEncoder.1
            @Override // io.netty.handler.codec.http2.Http2ConnectionAdapter, io.netty.handler.codec.http2.Http2Connection.Listener
            public void onStreamRemoved(Http2Stream http2Stream) {
                EmbeddedChannel embeddedChannel = (EmbeddedChannel) http2Stream.getProperty(CompressorHttp2ConnectionEncoder.this.propertyKey);
                if (embeddedChannel != null) {
                    CompressorHttp2ConnectionEncoder.this.cleanup(http2Stream, embeddedChannel);
                }
            }
        });
        this.supportsCompressionOptions = false;
    }

    @Override // io.netty.handler.codec.http2.DecoratingHttp2FrameWriter, io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeHeaders(ChannelHandlerContext channelHandlerContext, int i, Http2Headers http2Headers, int i2, short s, boolean z, int i4, boolean z2, ChannelPromise channelPromise) {
        EmbeddedChannel embeddedChannelNewCompressor;
        ChannelFuture channelFutureWriteHeaders;
        try {
            embeddedChannelNewCompressor = newCompressor(channelHandlerContext, http2Headers, z2);
            channelFutureWriteHeaders = super.writeHeaders(channelHandlerContext, i, http2Headers, i2, s, z, i4, z2, channelPromise);
        } catch (Throwable th) {
            th = th;
        }
        try {
            bindCompressorToStream(embeddedChannelNewCompressor, i);
            return channelFutureWriteHeaders;
        } catch (Throwable th2) {
            th = th2;
            channelPromise.tryFailure(th);
            return channelPromise;
        }
    }

    public CompressorHttp2ConnectionEncoder(Http2ConnectionEncoder http2ConnectionEncoder, CompressionOptions... compressionOptionsArr) {
        super(http2ConnectionEncoder);
        ObjectUtil.checkNotNull(compressionOptionsArr, "CompressionOptions");
        ObjectUtil.deepCheckNotNull("CompressionOptions", compressionOptionsArr);
        for (CompressionOptions compressionOptions : compressionOptionsArr) {
            if (Brotli.isAvailable() && (compressionOptions instanceof BrotliOptions)) {
                this.brotliOptions = (BrotliOptions) compressionOptions;
            } else if (compressionOptions instanceof GzipOptions) {
                this.gzipCompressionOptions = (GzipOptions) compressionOptions;
            } else if (compressionOptions instanceof DeflateOptions) {
                this.deflateOptions = (DeflateOptions) compressionOptions;
            } else if (compressionOptions instanceof ZstdOptions) {
                this.zstdOptions = (ZstdOptions) compressionOptions;
            } else {
                throw new IllegalArgumentException("Unsupported CompressionOptions: " + compressionOptions);
            }
        }
        this.supportsCompressionOptions = true;
        this.propertyKey = connection().newKey();
        connection().addListener(new Http2ConnectionAdapter() { // from class: io.netty.handler.codec.http2.CompressorHttp2ConnectionEncoder.2
            @Override // io.netty.handler.codec.http2.Http2ConnectionAdapter, io.netty.handler.codec.http2.Http2Connection.Listener
            public void onStreamRemoved(Http2Stream http2Stream) {
                EmbeddedChannel embeddedChannel = (EmbeddedChannel) http2Stream.getProperty(CompressorHttp2ConnectionEncoder.this.propertyKey);
                if (embeddedChannel != null) {
                    CompressorHttp2ConnectionEncoder.this.cleanup(http2Stream, embeddedChannel);
                }
            }
        });
    }

    public CharSequence getTargetContentEncoding(CharSequence charSequence) {
        return charSequence;
    }
}
