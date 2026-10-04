package io.netty.handler.codec.http2;

import cz.msebera.android.httpclient.impl.client.cache.CacheValidityPolicy;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http2.Http2FrameReader;
import io.netty.handler.codec.http2.Http2HeadersDecoder;
import io.netty.util.internal.PlatformDependent;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class DefaultHttp2FrameReader implements Http2FrameReader, Http2FrameSizePolicy, Http2FrameReader.Configuration {
    private Http2Flags flags;
    private byte frameType;
    private HeadersContinuation headersContinuation;
    private final Http2HeadersDecoder headersDecoder;
    private int maxFrameSize;
    private int payloadLength;
    private boolean readError;
    private boolean readingHeaders;
    private int streamId;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class HeadersBlockBuilder {
        private ByteBuf headerBlock;

        public HeadersBlockBuilder() {
        }

        private void headerSizeExceeded() throws Http2Exception {
            close();
            Http2CodecUtil.headerListSizeExceeded(DefaultHttp2FrameReader.this.headersDecoder.configuration().maxHeaderListSizeGoAway());
        }

        public final void addFragment(ByteBuf byteBuf, int i, ByteBufAllocator byteBufAllocator, boolean z) throws Http2Exception {
            if (this.headerBlock == null) {
                if (i > DefaultHttp2FrameReader.this.headersDecoder.configuration().maxHeaderListSizeGoAway()) {
                    headerSizeExceeded();
                }
                if (z) {
                    this.headerBlock = byteBuf.readRetainedSlice(i);
                    return;
                } else {
                    this.headerBlock = byteBufAllocator.buffer(i).writeBytes(byteBuf, i);
                    return;
                }
            }
            if (DefaultHttp2FrameReader.this.headersDecoder.configuration().maxHeaderListSizeGoAway() - ((long) i) < this.headerBlock.readableBytes()) {
                headerSizeExceeded();
            }
            if (this.headerBlock.isWritable(i)) {
                this.headerBlock.writeBytes(byteBuf, i);
                return;
            }
            ByteBuf byteBufBuffer = byteBufAllocator.buffer(this.headerBlock.readableBytes() + i);
            byteBufBuffer.writeBytes(this.headerBlock).writeBytes(byteBuf, i);
            this.headerBlock.release();
            this.headerBlock = byteBufBuffer;
        }

        public void close() {
            ByteBuf byteBuf = this.headerBlock;
            if (byteBuf != null) {
                byteBuf.release();
                this.headerBlock = null;
            }
            DefaultHttp2FrameReader.this.headersContinuation = null;
        }

        public Http2Headers headers() {
            try {
                return DefaultHttp2FrameReader.this.headersDecoder.decodeHeaders(DefaultHttp2FrameReader.this.streamId, this.headerBlock);
            } finally {
                close();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public abstract class HeadersContinuation {
        private final HeadersBlockBuilder builder;

        private HeadersContinuation() {
            this.builder = DefaultHttp2FrameReader.this.new HeadersBlockBuilder();
        }

        public final void close() {
            this.builder.close();
        }

        public abstract int getStreamId();

        public final HeadersBlockBuilder headersBlockBuilder() {
            return this.builder;
        }

        public abstract void processFragment(boolean z, ByteBuf byteBuf, int i, Http2FrameListener http2FrameListener);
    }

    public DefaultHttp2FrameReader() {
        this(true);
    }

    private void closeHeadersContinuation() {
        HeadersContinuation headersContinuation = this.headersContinuation;
        if (headersContinuation != null) {
            headersContinuation.close();
            this.headersContinuation = null;
        }
    }

    private static int lengthWithoutTrailingPadding(int i, int i2) {
        return i2 == 0 ? i : i - (i2 - 1);
    }

    private void processHeaderState(ByteBuf byteBuf) throws Http2Exception {
        if (byteBuf.readableBytes() < 9) {
            return;
        }
        int unsignedMedium = byteBuf.readUnsignedMedium();
        this.payloadLength = unsignedMedium;
        if (unsignedMedium > this.maxFrameSize) {
            throw Http2Exception.connectionError(Http2Error.FRAME_SIZE_ERROR, "Frame length: %d exceeds maximum: %d", Integer.valueOf(unsignedMedium), Integer.valueOf(this.maxFrameSize));
        }
        this.frameType = byteBuf.readByte();
        this.flags = new Http2Flags(byteBuf.readUnsignedByte());
        this.streamId = Http2CodecUtil.readUnsignedInt(byteBuf);
        this.readingHeaders = false;
        switch (this.frameType) {
            case 0:
                verifyDataFrame();
                return;
            case 1:
                verifyHeadersFrame();
                return;
            case 2:
                verifyPriorityFrame();
                return;
            case 3:
                verifyRstStreamFrame();
                return;
            case 4:
                verifySettingsFrame();
                return;
            case 5:
                verifyPushPromiseFrame();
                return;
            case 6:
                verifyPingFrame();
                return;
            case 7:
                verifyGoAwayFrame();
                return;
            case 8:
                verifyWindowUpdateFrame();
                return;
            case 9:
                verifyContinuationFrame();
                return;
            default:
                verifyUnknownFrame();
                return;
        }
    }

    private void processPayloadState(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, Http2FrameListener http2FrameListener) throws Http2Exception {
        if (byteBuf.readableBytes() < this.payloadLength) {
            return;
        }
        int i = byteBuf.readerIndex() + this.payloadLength;
        this.readingHeaders = true;
        switch (this.frameType) {
            case 0:
                readDataFrame(channelHandlerContext, byteBuf, i, http2FrameListener);
                break;
            case 1:
                readHeadersFrame(channelHandlerContext, byteBuf, i, http2FrameListener);
                break;
            case 2:
                readPriorityFrame(channelHandlerContext, byteBuf, http2FrameListener);
                break;
            case 3:
                readRstStreamFrame(channelHandlerContext, byteBuf, http2FrameListener);
                break;
            case 4:
                readSettingsFrame(channelHandlerContext, byteBuf, http2FrameListener);
                break;
            case 5:
                readPushPromiseFrame(channelHandlerContext, byteBuf, i, http2FrameListener);
                break;
            case 6:
                readPingFrame(channelHandlerContext, byteBuf.readLong(), http2FrameListener);
                break;
            case 7:
                readGoAwayFrame(channelHandlerContext, byteBuf, i, http2FrameListener);
                break;
            case 8:
                readWindowUpdateFrame(channelHandlerContext, byteBuf, http2FrameListener);
                break;
            case 9:
                readContinuationFrame(byteBuf, i, http2FrameListener);
                break;
            default:
                readUnknownFrame(channelHandlerContext, byteBuf, i, http2FrameListener);
                break;
        }
        byteBuf.readerIndex(i);
    }

    private void readContinuationFrame(ByteBuf byteBuf, int i, Http2FrameListener http2FrameListener) {
        this.headersContinuation.processFragment(this.flags.endOfHeaders(), byteBuf, i - byteBuf.readerIndex(), http2FrameListener);
        resetHeadersContinuationIfEnd(this.flags.endOfHeaders());
    }

    private void readDataFrame(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, int i, Http2FrameListener http2FrameListener) throws Http2Exception {
        int padding = readPadding(byteBuf);
        verifyPadding(padding);
        http2FrameListener.onDataRead(channelHandlerContext, this.streamId, byteBuf.readSlice(lengthWithoutTrailingPadding(i - byteBuf.readerIndex(), padding)), padding, this.flags.endOfStream());
    }

    private static void readGoAwayFrame(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, int i, Http2FrameListener http2FrameListener) {
        http2FrameListener.onGoAwayRead(channelHandlerContext, Http2CodecUtil.readUnsignedInt(byteBuf), byteBuf.readUnsignedInt(), byteBuf.readSlice(i - byteBuf.readerIndex()));
    }

    private void readHeadersFrame(final ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, int i, Http2FrameListener http2FrameListener) throws Http2Exception {
        int i2;
        final int i4 = this.streamId;
        final Http2Flags http2Flags = this.flags;
        final int padding = readPadding(byteBuf);
        verifyPadding(padding);
        if (!this.flags.priorityPresent()) {
            this.headersContinuation = new HeadersContinuation() { // from class: io.netty.handler.codec.http2.DefaultHttp2FrameReader.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                }

                @Override // io.netty.handler.codec.http2.DefaultHttp2FrameReader.HeadersContinuation
                public int getStreamId() {
                    return i4;
                }

                @Override // io.netty.handler.codec.http2.DefaultHttp2FrameReader.HeadersContinuation
                public void processFragment(boolean z, ByteBuf byteBuf2, int i5, Http2FrameListener http2FrameListener2) throws Http2Exception {
                    HeadersBlockBuilder headersBlockBuilder = headersBlockBuilder();
                    headersBlockBuilder.addFragment(byteBuf2, i5, channelHandlerContext.alloc(), z);
                    if (z) {
                        http2FrameListener2.onHeadersRead(channelHandlerContext, i4, headersBlockBuilder.headers(), padding, http2Flags.endOfStream());
                    }
                }
            };
            this.headersContinuation.processFragment(this.flags.endOfHeaders(), byteBuf, lengthWithoutTrailingPadding(i - byteBuf.readerIndex(), padding), http2FrameListener);
            resetHeadersContinuationIfEnd(this.flags.endOfHeaders());
            return;
        }
        long unsignedInt = byteBuf.readUnsignedInt();
        final boolean z = false;
        if ((CacheValidityPolicy.MAX_AGE & unsignedInt) != 0) {
            i2 = 0;
            z = true;
        } else {
            i2 = 0;
        }
        final int i5 = (int) (unsignedInt & 2147483647L);
        int i6 = this.streamId;
        if (i5 == i6) {
            throw Http2Exception.streamError(i6, Http2Error.PROTOCOL_ERROR, "A stream cannot depend on itself.", new Object[i2]);
        }
        final short unsignedByte = (short) (byteBuf.readUnsignedByte() + 1);
        int iLengthWithoutTrailingPadding = lengthWithoutTrailingPadding(i - byteBuf.readerIndex(), padding);
        HeadersContinuation headersContinuation = new HeadersContinuation() { // from class: io.netty.handler.codec.http2.DefaultHttp2FrameReader.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // io.netty.handler.codec.http2.DefaultHttp2FrameReader.HeadersContinuation
            public int getStreamId() {
                return i4;
            }

            @Override // io.netty.handler.codec.http2.DefaultHttp2FrameReader.HeadersContinuation
            public void processFragment(boolean z2, ByteBuf byteBuf2, int i7, Http2FrameListener http2FrameListener2) throws Http2Exception {
                HeadersBlockBuilder headersBlockBuilder = headersBlockBuilder();
                headersBlockBuilder.addFragment(byteBuf2, i7, channelHandlerContext.alloc(), z2);
                if (z2) {
                    http2FrameListener2.onHeadersRead(channelHandlerContext, i4, headersBlockBuilder.headers(), i5, unsignedByte, z, padding, http2Flags.endOfStream());
                }
            }
        };
        this.headersContinuation = headersContinuation;
        headersContinuation.processFragment(this.flags.endOfHeaders(), byteBuf, iLengthWithoutTrailingPadding, http2FrameListener);
        resetHeadersContinuationIfEnd(this.flags.endOfHeaders());
    }

    private int readPadding(ByteBuf byteBuf) {
        if (this.flags.paddingPresent()) {
            return byteBuf.readUnsignedByte() + 1;
        }
        return 0;
    }

    private void readPingFrame(ChannelHandlerContext channelHandlerContext, long j, Http2FrameListener http2FrameListener) {
        if (this.flags.ack()) {
            http2FrameListener.onPingAckRead(channelHandlerContext, j);
        } else {
            http2FrameListener.onPingRead(channelHandlerContext, j);
        }
    }

    private void readPriorityFrame(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, Http2FrameListener http2FrameListener) throws Http2Exception {
        long unsignedInt = byteBuf.readUnsignedInt();
        boolean z = (CacheValidityPolicy.MAX_AGE & unsignedInt) != 0;
        int i = (int) (unsignedInt & 2147483647L);
        int i2 = this.streamId;
        if (i == i2) {
            throw Http2Exception.streamError(i2, Http2Error.PROTOCOL_ERROR, "A stream cannot depend on itself.", new Object[0]);
        }
        http2FrameListener.onPriorityRead(channelHandlerContext, this.streamId, i, (short) (byteBuf.readUnsignedByte() + 1), z);
    }

    private void readPushPromiseFrame(final ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, int i, Http2FrameListener http2FrameListener) throws Http2Exception {
        final int i2 = this.streamId;
        final int padding = readPadding(byteBuf);
        verifyPadding(padding);
        final int unsignedInt = Http2CodecUtil.readUnsignedInt(byteBuf);
        this.headersContinuation = new HeadersContinuation() { // from class: io.netty.handler.codec.http2.DefaultHttp2FrameReader.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // io.netty.handler.codec.http2.DefaultHttp2FrameReader.HeadersContinuation
            public int getStreamId() {
                return i2;
            }

            @Override // io.netty.handler.codec.http2.DefaultHttp2FrameReader.HeadersContinuation
            public void processFragment(boolean z, ByteBuf byteBuf2, int i4, Http2FrameListener http2FrameListener2) throws Http2Exception {
                headersBlockBuilder().addFragment(byteBuf2, i4, channelHandlerContext.alloc(), z);
                if (z) {
                    http2FrameListener2.onPushPromiseRead(channelHandlerContext, i2, unsignedInt, headersBlockBuilder().headers(), padding);
                }
            }
        };
        this.headersContinuation.processFragment(this.flags.endOfHeaders(), byteBuf, lengthWithoutTrailingPadding(i - byteBuf.readerIndex(), padding), http2FrameListener);
        resetHeadersContinuationIfEnd(this.flags.endOfHeaders());
    }

    private void readRstStreamFrame(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, Http2FrameListener http2FrameListener) {
        http2FrameListener.onRstStreamRead(channelHandlerContext, this.streamId, byteBuf.readUnsignedInt());
    }

    private void readSettingsFrame(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, Http2FrameListener http2FrameListener) throws Http2Exception {
        if (this.flags.ack()) {
            http2FrameListener.onSettingsAckRead(channelHandlerContext);
            return;
        }
        int i = this.payloadLength / 6;
        Http2Settings http2Settings = new Http2Settings();
        for (int i2 = 0; i2 < i; i2++) {
            char unsignedShort = (char) byteBuf.readUnsignedShort();
            try {
                http2Settings.put(unsignedShort, Long.valueOf(byteBuf.readUnsignedInt()));
            } catch (IllegalArgumentException e) {
                if (unsignedShort != 4) {
                    throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, e, "Protocol error: %s", e.getMessage());
                }
                throw Http2Exception.connectionError(Http2Error.FLOW_CONTROL_ERROR, e, "Failed setting initial window size: %s", e.getMessage());
            }
        }
        http2FrameListener.onSettingsRead(channelHandlerContext, http2Settings);
    }

    private void readUnknownFrame(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, int i, Http2FrameListener http2FrameListener) {
        http2FrameListener.onUnknownFrame(channelHandlerContext, this.frameType, this.streamId, this.flags, byteBuf.readSlice(i - byteBuf.readerIndex()));
    }

    private void readWindowUpdateFrame(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, Http2FrameListener http2FrameListener) throws Http2Exception {
        int unsignedInt = Http2CodecUtil.readUnsignedInt(byteBuf);
        if (unsignedInt != 0) {
            http2FrameListener.onWindowUpdateRead(channelHandlerContext, this.streamId, unsignedInt);
        } else {
            int i = this.streamId;
            throw Http2Exception.streamError(i, Http2Error.PROTOCOL_ERROR, "Received WINDOW_UPDATE with delta 0 for stream: %d", Integer.valueOf(i));
        }
    }

    private void resetHeadersContinuationIfEnd(boolean z) {
        if (z) {
            closeHeadersContinuation();
        }
    }

    private void verifyAssociatedWithAStream() throws Http2Exception {
        if (this.streamId == 0) {
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Frame of type %s must be associated with a stream.", Byte.valueOf(this.frameType));
        }
    }

    private void verifyContinuationFrame() throws Http2Exception {
        verifyAssociatedWithAStream();
        HeadersContinuation headersContinuation = this.headersContinuation;
        if (headersContinuation == null) {
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Received %s frame but not currently processing headers.", Byte.valueOf(this.frameType));
        }
        if (this.streamId != headersContinuation.getStreamId()) {
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Continuation stream ID does not match pending headers. Expected %d, but received %d.", Integer.valueOf(this.headersContinuation.getStreamId()), Integer.valueOf(this.streamId));
        }
        if (this.payloadLength < this.flags.getPaddingPresenceFieldLength()) {
            throw Http2Exception.streamError(this.streamId, Http2Error.FRAME_SIZE_ERROR, "Frame length %d too small for padding.", Integer.valueOf(this.payloadLength));
        }
    }

    private void verifyDataFrame() throws Http2Exception {
        verifyAssociatedWithAStream();
        verifyNotProcessingHeaders();
        if (this.payloadLength < this.flags.getPaddingPresenceFieldLength()) {
            throw Http2Exception.streamError(this.streamId, Http2Error.FRAME_SIZE_ERROR, "Frame length %d too small.", Integer.valueOf(this.payloadLength));
        }
    }

    private void verifyGoAwayFrame() throws Http2Exception {
        verifyNotProcessingHeaders();
        if (this.streamId != 0) {
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "A stream ID must be zero.", new Object[0]);
        }
        int i = this.payloadLength;
        if (i < 8) {
            throw Http2Exception.connectionError(Http2Error.FRAME_SIZE_ERROR, "Frame length %d too small.", Integer.valueOf(i));
        }
    }

    private void verifyHeadersFrame() throws Http2Exception {
        verifyAssociatedWithAStream();
        verifyNotProcessingHeaders();
        if (this.payloadLength >= this.flags.getNumPriorityBytes() + this.flags.getPaddingPresenceFieldLength()) {
            return;
        }
        throw Http2Exception.streamError(this.streamId, Http2Error.FRAME_SIZE_ERROR, "Frame length too small." + this.payloadLength, new Object[0]);
    }

    private void verifyNotProcessingHeaders() throws Http2Exception {
        if (this.headersContinuation != null) {
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Received frame of type %s while processing headers on stream %d.", Byte.valueOf(this.frameType), Integer.valueOf(this.headersContinuation.getStreamId()));
        }
    }

    private void verifyPadding(int i) throws Http2Exception {
        if (lengthWithoutTrailingPadding(this.payloadLength, i) < 0) {
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Frame payload too small for padding.", new Object[0]);
        }
    }

    private void verifyPingFrame() throws Http2Exception {
        verifyNotProcessingHeaders();
        if (this.streamId != 0) {
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "A stream ID must be zero.", new Object[0]);
        }
        int i = this.payloadLength;
        if (i != 8) {
            throw Http2Exception.connectionError(Http2Error.FRAME_SIZE_ERROR, "Frame length %d incorrect size for ping.", Integer.valueOf(i));
        }
    }

    private void verifyPriorityFrame() throws Http2Exception {
        verifyAssociatedWithAStream();
        verifyNotProcessingHeaders();
        int i = this.payloadLength;
        if (i != 5) {
            throw Http2Exception.streamError(this.streamId, Http2Error.FRAME_SIZE_ERROR, "Invalid frame length %d.", Integer.valueOf(i));
        }
    }

    private void verifyPushPromiseFrame() throws Http2Exception {
        verifyNotProcessingHeaders();
        int paddingPresenceFieldLength = this.flags.getPaddingPresenceFieldLength() + 4;
        int i = this.payloadLength;
        if (i < paddingPresenceFieldLength) {
            throw Http2Exception.streamError(this.streamId, Http2Error.FRAME_SIZE_ERROR, "Frame length %d too small.", Integer.valueOf(i));
        }
    }

    private void verifyRstStreamFrame() throws Http2Exception {
        verifyAssociatedWithAStream();
        verifyNotProcessingHeaders();
        int i = this.payloadLength;
        if (i != 4) {
            throw Http2Exception.connectionError(Http2Error.FRAME_SIZE_ERROR, "Invalid frame length %d.", Integer.valueOf(i));
        }
    }

    private void verifySettingsFrame() throws Http2Exception {
        verifyNotProcessingHeaders();
        if (this.streamId != 0) {
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "A stream ID must be zero.", new Object[0]);
        }
        if (this.flags.ack() && this.payloadLength > 0) {
            throw Http2Exception.connectionError(Http2Error.FRAME_SIZE_ERROR, "Ack settings frame must have an empty payload.", new Object[0]);
        }
        int i = this.payloadLength;
        if (i % 6 > 0) {
            throw Http2Exception.connectionError(Http2Error.FRAME_SIZE_ERROR, "Frame length %d invalid.", Integer.valueOf(i));
        }
    }

    private static void verifyStreamOrConnectionId(int i, String str) throws Http2Exception {
        if (i < 0) {
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "%s must be >= 0", str);
        }
    }

    private void verifyUnknownFrame() throws Http2Exception {
        verifyNotProcessingHeaders();
    }

    private void verifyWindowUpdateFrame() throws Http2Exception {
        verifyNotProcessingHeaders();
        verifyStreamOrConnectionId(this.streamId, "Stream ID");
        int i = this.payloadLength;
        if (i != 4) {
            throw Http2Exception.connectionError(Http2Error.FRAME_SIZE_ERROR, "Invalid frame length %d.", Integer.valueOf(i));
        }
    }

    @Override // io.netty.handler.codec.http2.Http2FrameReader, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        closeHeadersContinuation();
    }

    @Override // io.netty.handler.codec.http2.Http2FrameReader.Configuration
    public Http2HeadersDecoder.Configuration headersConfiguration() {
        return this.headersDecoder.configuration();
    }

    @Override // io.netty.handler.codec.http2.Http2FrameSizePolicy
    public void maxFrameSize(int i) throws Http2Exception {
        if (!Http2CodecUtil.isMaxFrameSizeValid(i)) {
            throw Http2Exception.streamError(this.streamId, Http2Error.FRAME_SIZE_ERROR, "Invalid MAX_FRAME_SIZE specified in sent settings: %d", Integer.valueOf(i));
        }
        this.maxFrameSize = i;
    }

    @Override // io.netty.handler.codec.http2.Http2FrameReader
    public void readFrame(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, Http2FrameListener http2FrameListener) throws Throwable {
        if (this.readError) {
            byteBuf.skipBytes(byteBuf.readableBytes());
            return;
        }
        do {
            try {
                if (this.readingHeaders) {
                    processHeaderState(byteBuf);
                    if (this.readingHeaders) {
                        return;
                    }
                }
                processPayloadState(channelHandlerContext, byteBuf, http2FrameListener);
                if (!this.readingHeaders) {
                    return;
                }
            } catch (Http2Exception e) {
                this.readError = !Http2Exception.isStreamError(e);
                throw e;
            } catch (RuntimeException e2) {
                this.readError = true;
                throw e2;
            } catch (Throwable th) {
                this.readError = true;
                PlatformDependent.throwException(th);
                return;
            }
        } while (byteBuf.isReadable());
    }

    public DefaultHttp2FrameReader(boolean z) {
        this(new DefaultHttp2HeadersDecoder(z));
    }

    public DefaultHttp2FrameReader(Http2HeadersDecoder http2HeadersDecoder) {
        this.readingHeaders = true;
        this.headersDecoder = http2HeadersDecoder;
        this.maxFrameSize = 16384;
    }

    @Override // io.netty.handler.codec.http2.Http2FrameSizePolicy
    public int maxFrameSize() {
        return this.maxFrameSize;
    }

    @Override // io.netty.handler.codec.http2.Http2FrameReader
    public Http2FrameReader.Configuration configuration() {
        return this;
    }

    @Override // io.netty.handler.codec.http2.Http2FrameReader.Configuration
    public Http2FrameSizePolicy frameSizePolicy() {
        return this;
    }
}
