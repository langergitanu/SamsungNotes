package io.netty.handler.codec.http2;

import androidx.collection.AbstractC0622a;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import cz.msebera.android.httpclient.impl.client.cache.CacheValidityPolicy;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.http2.Http2CodecUtil;
import io.netty.handler.codec.http2.Http2FrameWriter;
import io.netty.handler.codec.http2.Http2HeadersEncoder;
import io.netty.util.collection.CharObjectMap;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class DefaultHttp2FrameWriter implements Http2FrameWriter, Http2FrameSizePolicy, Http2FrameWriter.Configuration {
    private static final String STREAM_DEPENDENCY = "Stream Dependency";
    private static final String STREAM_ID = "Stream ID";
    private static final ByteBuf ZERO_BUFFER = Unpooled.unreleasableBuffer(Unpooled.directBuffer(255).writeZero(255)).asReadOnly();
    private final Http2HeadersEncoder headersEncoder;
    private int maxFrameSize;

    public DefaultHttp2FrameWriter() {
        this(new DefaultHttp2HeadersEncoder());
    }

    private static int paddingBytes(int i) {
        return i - 1;
    }

    private static void verifyErrorCode(long j) {
        if (j < 0 || j > 4294967295L) {
            throw new IllegalArgumentException(AbstractC0622a.m1169o("Invalid errorCode: ", j));
        }
    }

    private static void verifyStreamId(int i, String str) {
        ObjectUtil.checkPositive(i, str);
    }

    private static void verifyStreamOrConnectionId(int i, String str) {
        ObjectUtil.checkPositiveOrZero(i, str);
    }

    private static void verifyWeight(short s) {
        if (s < 1 || s > 256) {
            throw new IllegalArgumentException(AbstractC0000a.m11h(s, "Invalid weight: "));
        }
    }

    private static void verifyWindowSizeIncrement(int i) {
        ObjectUtil.checkPositiveOrZero(i, "windowSizeIncrement");
    }

    private ChannelFuture writeContinuationFrames(ChannelHandlerContext channelHandlerContext, int i, ByteBuf byteBuf, Http2CodecUtil.SimpleChannelPromiseAggregator simpleChannelPromiseAggregator) {
        Http2Flags http2Flags = new Http2Flags();
        if (byteBuf.isReadable()) {
            int iMin = Math.min(byteBuf.readableBytes(), this.maxFrameSize);
            ByteBuf byteBufBuffer = channelHandlerContext.alloc().buffer(10);
            Http2CodecUtil.writeFrameHeaderInternal(byteBufBuffer, iMin, (byte) 9, http2Flags, i);
            do {
                int iMin2 = Math.min(byteBuf.readableBytes(), this.maxFrameSize);
                ByteBuf retainedSlice = byteBuf.readRetainedSlice(iMin2);
                if (byteBuf.isReadable()) {
                    channelHandlerContext.write(byteBufBuffer.retain(), simpleChannelPromiseAggregator.newPromise());
                } else {
                    http2Flags = http2Flags.endOfHeaders(true);
                    byteBufBuffer.release();
                    byteBufBuffer = channelHandlerContext.alloc().buffer(10);
                    Http2CodecUtil.writeFrameHeaderInternal(byteBufBuffer, iMin2, (byte) 9, http2Flags, i);
                    channelHandlerContext.write(byteBufBuffer, simpleChannelPromiseAggregator.newPromise());
                }
                channelHandlerContext.write(retainedSlice, simpleChannelPromiseAggregator.newPromise());
            } while (byteBuf.isReadable());
        }
        return simpleChannelPromiseAggregator;
    }

    private ChannelFuture writeHeadersInternal(ChannelHandlerContext channelHandlerContext, int i, Http2Headers http2Headers, int i2, boolean z, boolean z2, int i4, short s, boolean z3, ChannelPromise channelPromise) {
        Http2CodecUtil.SimpleChannelPromiseAggregator simpleChannelPromiseAggregator = new Http2CodecUtil.SimpleChannelPromiseAggregator(channelPromise, channelHandlerContext.channel(), channelHandlerContext.executor());
        ByteBuf byteBufBuffer = null;
        try {
            try {
                verifyStreamId(i, STREAM_ID);
                if (z2) {
                    verifyStreamOrConnectionId(i4, STREAM_DEPENDENCY);
                    Http2CodecUtil.verifyPadding(i2);
                    verifyWeight(s);
                }
                byteBufBuffer = channelHandlerContext.alloc().buffer();
                this.headersEncoder.encodeHeaders(i, http2Headers, byteBufBuffer);
                Http2Flags http2FlagsPaddingPresent = new Http2Flags().endOfStream(z).priorityPresent(z2).paddingPresent(i2 > 0);
                int numPriorityBytes = http2FlagsPaddingPresent.getNumPriorityBytes() + i2;
                ByteBuf retainedSlice = byteBufBuffer.readRetainedSlice(Math.min(byteBufBuffer.readableBytes(), this.maxFrameSize - numPriorityBytes));
                http2FlagsPaddingPresent.endOfHeaders(!byteBufBuffer.isReadable());
                int i5 = retainedSlice.readableBytes() + numPriorityBytes;
                ByteBuf byteBufBuffer2 = channelHandlerContext.alloc().buffer(15);
                Http2CodecUtil.writeFrameHeaderInternal(byteBufBuffer2, i5, (byte) 1, http2FlagsPaddingPresent, i);
                writePaddingLength(byteBufBuffer2, i2);
                if (z2) {
                    byteBufBuffer2.writeInt(z3 ? (int) (((long) i4) | CacheValidityPolicy.MAX_AGE) : i4);
                    byteBufBuffer2.writeByte(s - 1);
                }
                channelHandlerContext.write(byteBufBuffer2, simpleChannelPromiseAggregator.newPromise());
                channelHandlerContext.write(retainedSlice, simpleChannelPromiseAggregator.newPromise());
                if (paddingBytes(i2) > 0) {
                    channelHandlerContext.write(ZERO_BUFFER.slice(0, paddingBytes(i2)), simpleChannelPromiseAggregator.newPromise());
                }
                if (!http2FlagsPaddingPresent.endOfHeaders()) {
                    writeContinuationFrames(channelHandlerContext, i, byteBufBuffer, simpleChannelPromiseAggregator);
                }
            } finally {
            }
        } catch (Http2Exception e) {
            simpleChannelPromiseAggregator.setFailure((Throwable) e);
            if (byteBufBuffer != null) {
            }
            return simpleChannelPromiseAggregator.doneAllocatingPromises();
        } catch (Throwable th) {
            simpleChannelPromiseAggregator.setFailure(th);
            simpleChannelPromiseAggregator.doneAllocatingPromises();
            PlatformDependent.throwException(th);
            if (byteBufBuffer != null) {
            }
            return simpleChannelPromiseAggregator.doneAllocatingPromises();
        }
        byteBufBuffer.release();
        return simpleChannelPromiseAggregator.doneAllocatingPromises();
    }

    private static void writePaddingLength(ByteBuf byteBuf, int i) {
        if (i > 0) {
            byteBuf.writeByte(i - 1);
        }
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter.Configuration
    public Http2HeadersEncoder.Configuration headersConfiguration() {
        return this.headersEncoder.configuration();
    }

    @Override // io.netty.handler.codec.http2.Http2FrameSizePolicy
    public void maxFrameSize(int i) throws Http2Exception {
        if (!Http2CodecUtil.isMaxFrameSizeValid(i)) {
            throw Http2Exception.connectionError(Http2Error.FRAME_SIZE_ERROR, "Invalid MAX_FRAME_SIZE specified in sent settings: %d", Integer.valueOf(i));
        }
        this.maxFrameSize = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x014d A[Catch: all -> 0x0138, TRY_LEAVE, TryCatch #5 {all -> 0x0138, blocks: (B:40:0x00e1, B:46:0x0109, B:50:0x0110, B:53:0x0126, B:60:0x013c, B:61:0x0147, B:63:0x014d), top: B:86:0x00e1 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x016e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // io.netty.handler.codec.http2.Http2DataWriter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ChannelFuture writeData(ChannelHandlerContext channelHandlerContext, int i, ByteBuf byteBuf, int i2, boolean z, ChannelPromise channelPromise) {
        Throwable th;
        ByteBuf byteBuf2;
        int i4;
        Http2Flags http2Flags;
        ByteBuf byteBufBuffer;
        ByteBuf byteBufSlice;
        ByteBuf byteBuf3;
        int i5;
        int i6;
        int iMin;
        int i7;
        ByteBuf slice = byteBuf;
        Http2CodecUtil.SimpleChannelPromiseAggregator simpleChannelPromiseAggregator = new Http2CodecUtil.SimpleChannelPromiseAggregator(channelPromise, channelHandlerContext.channel(), channelHandlerContext.executor());
        try {
            verifyStreamId(i, STREAM_ID);
            Http2CodecUtil.verifyPadding(i2);
            i4 = slice.readableBytes();
            http2Flags = new Http2Flags();
            http2Flags.endOfStream(false);
            http2Flags.paddingPresent(false);
            if (i4 > this.maxFrameSize) {
                byteBufBuffer = channelHandlerContext.alloc().buffer(9);
                try {
                    Http2CodecUtil.writeFrameHeaderInternal(byteBufBuffer, this.maxFrameSize, (byte) 0, http2Flags, i);
                    do {
                        channelHandlerContext.write(byteBufBuffer.retainedSlice(), simpleChannelPromiseAggregator.newPromise());
                        channelHandlerContext.write(slice.readRetainedSlice(this.maxFrameSize), simpleChannelPromiseAggregator.newPromise());
                        i7 = this.maxFrameSize;
                        i4 -= i7;
                    } while (i4 > i7);
                } catch (Throwable th2) {
                    th = th2;
                    byteBuf2 = byteBufBuffer;
                }
            } else {
                byteBufBuffer = null;
            }
            try {
            } catch (Throwable th3) {
                th = th3;
                byteBuf2 = byteBufBuffer;
            }
        } catch (Throwable th4) {
            th = th4;
            byteBuf2 = null;
        }
        if (i2 != 0) {
            int i8 = this.maxFrameSize;
            if (i4 == i8) {
                i4 -= i8;
                if (byteBufBuffer == null) {
                    byteBufSlice = channelHandlerContext.alloc().buffer(9);
                    Http2CodecUtil.writeFrameHeaderInternal(byteBufSlice, this.maxFrameSize, (byte) 0, http2Flags, i);
                } else {
                    byteBufSlice = byteBufBuffer.slice();
                    byteBufBuffer = null;
                }
                channelHandlerContext.write(byteBufSlice, simpleChannelPromiseAggregator.newPromise());
                int i9 = slice.readableBytes();
                int i10 = this.maxFrameSize;
                if (i9 != i10) {
                    slice = slice.readSlice(i10);
                }
                channelHandlerContext.write(slice, simpleChannelPromiseAggregator.newPromise());
                byteBuf3 = byteBufBuffer;
                slice = null;
            } else if (byteBufBuffer != null) {
                byteBufBuffer.release();
                i5 = i4;
                byteBuf3 = null;
                i6 = i2;
                while (true) {
                    try {
                        int iMin2 = Math.min(i5, this.maxFrameSize);
                        boolean z2 = true;
                        iMin = Math.min(i6, Math.max(0, (this.maxFrameSize - 1) - iMin2));
                        i6 -= iMin;
                        i5 -= iMin2;
                        ByteBuf byteBufBuffer2 = channelHandlerContext.alloc().buffer(10);
                        http2Flags.endOfStream(!z && i5 == 0 && i6 == 0);
                        if (iMin > 0) {
                            z2 = false;
                        }
                        http2Flags.paddingPresent(z2);
                        Http2CodecUtil.writeFrameHeaderInternal(byteBufBuffer2, iMin + iMin2, (byte) 0, http2Flags, i);
                        writePaddingLength(byteBufBuffer2, iMin);
                        channelHandlerContext.write(byteBufBuffer2, simpleChannelPromiseAggregator.newPromise());
                        if (slice != null) {
                            if (i5 == 0) {
                                try {
                                    channelHandlerContext.write(slice.readSlice(iMin2), simpleChannelPromiseAggregator.newPromise());
                                    slice = null;
                                } catch (Throwable th5) {
                                    th = th5;
                                    byteBuf2 = byteBuf3;
                                    slice = null;
                                    if (byteBuf2 != null) {
                                    }
                                    if (slice != null) {
                                    }
                                    return simpleChannelPromiseAggregator;
                                }
                            } else {
                                channelHandlerContext.write(slice.readRetainedSlice(iMin2), simpleChannelPromiseAggregator.newPromise());
                            }
                        }
                        if (paddingBytes(iMin) > 0) {
                            channelHandlerContext.write(ZERO_BUFFER.slice(0, paddingBytes(iMin)), simpleChannelPromiseAggregator.newPromise());
                        }
                        if (i5 != 0 && i6 == 0) {
                            break;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        byteBuf2 = byteBuf3;
                    }
                }
            } else {
                byteBuf3 = byteBufBuffer;
            }
            i5 = i4;
            i6 = i2;
            while (true) {
                int iMin22 = Math.min(i5, this.maxFrameSize);
                boolean z22 = true;
                iMin = Math.min(i6, Math.max(0, (this.maxFrameSize - 1) - iMin22));
                i6 -= iMin;
                i5 -= iMin22;
                ByteBuf byteBufBuffer22 = channelHandlerContext.alloc().buffer(10);
                if (z) {
                    http2Flags.endOfStream(!z && i5 == 0 && i6 == 0);
                    if (iMin > 0) {
                    }
                    http2Flags.paddingPresent(z22);
                    Http2CodecUtil.writeFrameHeaderInternal(byteBufBuffer22, iMin + iMin22, (byte) 0, http2Flags, i);
                    writePaddingLength(byteBufBuffer22, iMin);
                    channelHandlerContext.write(byteBufBuffer22, simpleChannelPromiseAggregator.newPromise());
                    if (slice != null) {
                    }
                    if (paddingBytes(iMin) > 0) {
                    }
                    if (i5 != 0) {
                    }
                }
                if (byteBuf2 != null) {
                    byteBuf2.release();
                }
                if (slice != null) {
                    try {
                        slice.release();
                    } finally {
                        simpleChannelPromiseAggregator.setFailure(th);
                        simpleChannelPromiseAggregator.doneAllocatingPromises();
                    }
                }
                return simpleChannelPromiseAggregator;
            }
        }
        if (byteBufBuffer != null) {
            byteBufBuffer.release();
        }
        ByteBuf byteBufBuffer3 = channelHandlerContext.alloc().buffer(9);
        http2Flags.endOfStream(z);
        Http2CodecUtil.writeFrameHeaderInternal(byteBufBuffer3, i4, (byte) 0, http2Flags, i);
        channelHandlerContext.write(byteBufBuffer3, simpleChannelPromiseAggregator.newPromise());
        channelHandlerContext.write(slice.readSlice(i4), simpleChannelPromiseAggregator.newPromise());
        return simpleChannelPromiseAggregator.doneAllocatingPromises();
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeFrame(ChannelHandlerContext channelHandlerContext, byte b, int i, Http2Flags http2Flags, ByteBuf byteBuf, ChannelPromise channelPromise) {
        Http2CodecUtil.SimpleChannelPromiseAggregator simpleChannelPromiseAggregator = new Http2CodecUtil.SimpleChannelPromiseAggregator(channelPromise, channelHandlerContext.channel(), channelHandlerContext.executor());
        try {
            verifyStreamOrConnectionId(i, STREAM_ID);
            ByteBuf byteBufBuffer = channelHandlerContext.alloc().buffer(9);
            Http2CodecUtil.writeFrameHeaderInternal(byteBufBuffer, byteBuf.readableBytes(), b, http2Flags, i);
            channelHandlerContext.write(byteBufBuffer, simpleChannelPromiseAggregator.newPromise());
            try {
                channelHandlerContext.write(byteBuf, simpleChannelPromiseAggregator.newPromise());
            } catch (Throwable th) {
                simpleChannelPromiseAggregator.setFailure(th);
            }
            return simpleChannelPromiseAggregator.doneAllocatingPromises();
        } catch (Throwable th2) {
            try {
                byteBuf.release();
                return simpleChannelPromiseAggregator;
            } finally {
                simpleChannelPromiseAggregator.setFailure(th2);
                simpleChannelPromiseAggregator.doneAllocatingPromises();
            }
        }
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeGoAway(ChannelHandlerContext channelHandlerContext, int i, long j, ByteBuf byteBuf, ChannelPromise channelPromise) {
        Http2CodecUtil.SimpleChannelPromiseAggregator simpleChannelPromiseAggregator = new Http2CodecUtil.SimpleChannelPromiseAggregator(channelPromise, channelHandlerContext.channel(), channelHandlerContext.executor());
        try {
            verifyStreamOrConnectionId(i, "Last Stream ID");
            verifyErrorCode(j);
            int i2 = byteBuf.readableBytes() + 8;
            ByteBuf byteBufBuffer = channelHandlerContext.alloc().buffer(17);
            Http2CodecUtil.writeFrameHeaderInternal(byteBufBuffer, i2, (byte) 7, new Http2Flags(), 0);
            byteBufBuffer.writeInt(i);
            byteBufBuffer.writeInt((int) j);
            channelHandlerContext.write(byteBufBuffer, simpleChannelPromiseAggregator.newPromise());
            try {
                channelHandlerContext.write(byteBuf, simpleChannelPromiseAggregator.newPromise());
            } catch (Throwable th) {
                simpleChannelPromiseAggregator.setFailure(th);
            }
            return simpleChannelPromiseAggregator.doneAllocatingPromises();
        } catch (Throwable th2) {
            try {
                byteBuf.release();
                return simpleChannelPromiseAggregator;
            } finally {
                simpleChannelPromiseAggregator.setFailure(th2);
                simpleChannelPromiseAggregator.doneAllocatingPromises();
            }
        }
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeHeaders(ChannelHandlerContext channelHandlerContext, int i, Http2Headers http2Headers, int i2, boolean z, ChannelPromise channelPromise) {
        return writeHeadersInternal(channelHandlerContext, i, http2Headers, i2, z, false, 0, (short) 0, false, channelPromise);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writePing(ChannelHandlerContext channelHandlerContext, boolean z, long j, ChannelPromise channelPromise) {
        Http2Flags http2FlagsAck = z ? new Http2Flags().ack(true) : new Http2Flags();
        ByteBuf byteBufBuffer = channelHandlerContext.alloc().buffer(17);
        Http2CodecUtil.writeFrameHeaderInternal(byteBufBuffer, 8, (byte) 6, http2FlagsAck, 0);
        byteBufBuffer.writeLong(j);
        return channelHandlerContext.write(byteBufBuffer, channelPromise);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writePriority(ChannelHandlerContext channelHandlerContext, int i, int i2, short s, boolean z, ChannelPromise channelPromise) {
        try {
            verifyStreamId(i, STREAM_ID);
            verifyStreamOrConnectionId(i2, STREAM_DEPENDENCY);
            verifyWeight(s);
            ByteBuf byteBufBuffer = channelHandlerContext.alloc().buffer(14);
            Http2CodecUtil.writeFrameHeaderInternal(byteBufBuffer, 5, (byte) 2, new Http2Flags(), i);
            if (z) {
                i2 = (int) (((long) i2) | CacheValidityPolicy.MAX_AGE);
            }
            byteBufBuffer.writeInt(i2);
            byteBufBuffer.writeByte(s - 1);
            return channelHandlerContext.write(byteBufBuffer, channelPromise);
        } catch (Throwable th) {
            return channelPromise.setFailure(th);
        }
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writePushPromise(ChannelHandlerContext channelHandlerContext, int i, int i2, Http2Headers http2Headers, int i4, ChannelPromise channelPromise) {
        Http2CodecUtil.SimpleChannelPromiseAggregator simpleChannelPromiseAggregator = new Http2CodecUtil.SimpleChannelPromiseAggregator(channelPromise, channelHandlerContext.channel(), channelHandlerContext.executor());
        ByteBuf byteBufBuffer = null;
        try {
            try {
                verifyStreamId(i, STREAM_ID);
                verifyStreamId(i2, "Promised Stream ID");
                Http2CodecUtil.verifyPadding(i4);
                byteBufBuffer = channelHandlerContext.alloc().buffer();
                this.headersEncoder.encodeHeaders(i, http2Headers, byteBufBuffer);
                Http2Flags http2FlagsPaddingPresent = new Http2Flags().paddingPresent(i4 > 0);
                int i5 = i4 + 4;
                ByteBuf retainedSlice = byteBufBuffer.readRetainedSlice(Math.min(byteBufBuffer.readableBytes(), this.maxFrameSize - i5));
                http2FlagsPaddingPresent.endOfHeaders(true ^ byteBufBuffer.isReadable());
                int i6 = retainedSlice.readableBytes() + i5;
                ByteBuf byteBufBuffer2 = channelHandlerContext.alloc().buffer(14);
                Http2CodecUtil.writeFrameHeaderInternal(byteBufBuffer2, i6, (byte) 5, http2FlagsPaddingPresent, i);
                writePaddingLength(byteBufBuffer2, i4);
                byteBufBuffer2.writeInt(i2);
                channelHandlerContext.write(byteBufBuffer2, simpleChannelPromiseAggregator.newPromise());
                channelHandlerContext.write(retainedSlice, simpleChannelPromiseAggregator.newPromise());
                if (paddingBytes(i4) > 0) {
                    channelHandlerContext.write(ZERO_BUFFER.slice(0, paddingBytes(i4)), simpleChannelPromiseAggregator.newPromise());
                }
                if (!http2FlagsPaddingPresent.endOfHeaders()) {
                    writeContinuationFrames(channelHandlerContext, i, byteBufBuffer, simpleChannelPromiseAggregator);
                }
            } catch (Throwable th) {
                if (byteBufBuffer != null) {
                    byteBufBuffer.release();
                }
                throw th;
            }
        } catch (Http2Exception e) {
            simpleChannelPromiseAggregator.setFailure((Throwable) e);
            if (byteBufBuffer != null) {
            }
            return simpleChannelPromiseAggregator.doneAllocatingPromises();
        } catch (Throwable th2) {
            simpleChannelPromiseAggregator.setFailure(th2);
            simpleChannelPromiseAggregator.doneAllocatingPromises();
            PlatformDependent.throwException(th2);
            if (byteBufBuffer != null) {
            }
            return simpleChannelPromiseAggregator.doneAllocatingPromises();
        }
        byteBufBuffer.release();
        return simpleChannelPromiseAggregator.doneAllocatingPromises();
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeRstStream(ChannelHandlerContext channelHandlerContext, int i, long j, ChannelPromise channelPromise) {
        try {
            verifyStreamId(i, STREAM_ID);
            verifyErrorCode(j);
            ByteBuf byteBufBuffer = channelHandlerContext.alloc().buffer(13);
            Http2CodecUtil.writeFrameHeaderInternal(byteBufBuffer, 4, (byte) 3, new Http2Flags(), i);
            byteBufBuffer.writeInt((int) j);
            return channelHandlerContext.write(byteBufBuffer, channelPromise);
        } catch (Throwable th) {
            return channelPromise.setFailure(th);
        }
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeSettings(ChannelHandlerContext channelHandlerContext, Http2Settings http2Settings, ChannelPromise channelPromise) {
        try {
            ObjectUtil.checkNotNull(http2Settings, SettingsConstants.EXTRA_FROM_NOTES_ASSIST_FOR_LAUNCH_FROM_SETTINGS);
            int size = http2Settings.size() * 6;
            ByteBuf byteBufBuffer = channelHandlerContext.alloc().buffer(size + 9);
            Http2CodecUtil.writeFrameHeaderInternal(byteBufBuffer, size, (byte) 4, new Http2Flags(), 0);
            for (CharObjectMap.PrimitiveEntry<Long> primitiveEntry : http2Settings.entries()) {
                byteBufBuffer.writeChar(primitiveEntry.key());
                byteBufBuffer.writeInt(primitiveEntry.value().intValue());
            }
            return channelHandlerContext.write(byteBufBuffer, channelPromise);
        } catch (Throwable th) {
            return channelPromise.setFailure(th);
        }
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeSettingsAck(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
        try {
            ByteBuf byteBufBuffer = channelHandlerContext.alloc().buffer(9);
            Http2CodecUtil.writeFrameHeaderInternal(byteBufBuffer, 0, (byte) 4, new Http2Flags().ack(true), 0);
            return channelHandlerContext.write(byteBufBuffer, channelPromise);
        } catch (Throwable th) {
            return channelPromise.setFailure(th);
        }
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeWindowUpdate(ChannelHandlerContext channelHandlerContext, int i, int i2, ChannelPromise channelPromise) {
        try {
            verifyStreamOrConnectionId(i, STREAM_ID);
            verifyWindowSizeIncrement(i2);
            ByteBuf byteBufBuffer = channelHandlerContext.alloc().buffer(13);
            Http2CodecUtil.writeFrameHeaderInternal(byteBufBuffer, 4, (byte) 8, new Http2Flags(), i);
            byteBufBuffer.writeInt(i2);
            return channelHandlerContext.write(byteBufBuffer, channelPromise);
        } catch (Throwable th) {
            return channelPromise.setFailure(th);
        }
    }

    public DefaultHttp2FrameWriter(Http2HeadersEncoder.SensitivityDetector sensitivityDetector) {
        this(new DefaultHttp2HeadersEncoder(sensitivityDetector));
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeHeaders(ChannelHandlerContext channelHandlerContext, int i, Http2Headers http2Headers, int i2, short s, boolean z, int i4, boolean z2, ChannelPromise channelPromise) {
        return writeHeadersInternal(channelHandlerContext, i, http2Headers, i4, z2, true, i2, s, z, channelPromise);
    }

    public DefaultHttp2FrameWriter(Http2HeadersEncoder.SensitivityDetector sensitivityDetector, boolean z) {
        this(new DefaultHttp2HeadersEncoder(sensitivityDetector, z));
    }

    public DefaultHttp2FrameWriter(Http2HeadersEncoder http2HeadersEncoder) {
        this.headersEncoder = http2HeadersEncoder;
        this.maxFrameSize = 16384;
    }

    @Override // io.netty.handler.codec.http2.Http2FrameSizePolicy
    public int maxFrameSize() {
        return this.maxFrameSize;
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public Http2FrameWriter.Configuration configuration() {
        return this;
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter.Configuration
    public Http2FrameSizePolicy frameSizePolicy() {
        return this;
    }
}
