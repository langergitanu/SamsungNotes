package io.netty.handler.codec.http2;

import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpStatusClass;
import io.netty.handler.codec.http.HttpUtil;
import io.netty.handler.codec.http2.Http2Connection;
import io.netty.handler.codec.http2.Http2FrameReader;
import io.netty.handler.codec.http2.Http2HeadersDecoder;
import io.netty.handler.codec.http2.Http2Stream;
import io.netty.util.AsciiString;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class DefaultHttp2ConnectionDecoder implements Http2ConnectionDecoder {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) DefaultHttp2ConnectionDecoder.class);
    private final boolean autoAckPing;
    private final Http2Connection connection;
    private final Http2Connection.PropertyKey contentLengthKey;
    private final Http2ConnectionEncoder encoder;
    private final Http2FrameReader frameReader;
    private Http2FrameListener internalFrameListener;
    private Http2LifecycleManager lifecycleManager;
    private Http2FrameListener listener;
    private final Http2PromisedRequestVerifier requestVerifier;
    private final Http2SettingsReceivedConsumer settingsReceivedConsumer;

    /* JADX INFO: renamed from: io.netty.handler.codec.http2.DefaultHttp2ConnectionDecoder$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C125831 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State;

        static {
            int[] iArr = new int[Http2Stream.State.values().length];
            $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State = iArr;
            try {
                iArr[Http2Stream.State.OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[Http2Stream.State.HALF_CLOSED_LOCAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[Http2Stream.State.HALF_CLOSED_REMOTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[Http2Stream.State.CLOSED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[Http2Stream.State.RESERVED_REMOTE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[Http2Stream.State.IDLE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ContentLength {
        private final long expected;
        private long seen;

        public ContentLength(long j) {
            this.expected = j;
        }

        public void increaseReceivedBytes(boolean z, int i, int i2, boolean z2) throws Http2Exception {
            long j = this.seen + ((long) i2);
            this.seen = j;
            if (j < 0) {
                throw Http2Exception.streamError(i, Http2Error.PROTOCOL_ERROR, "Received amount of data did overflow and so not match content-length header %d", Long.valueOf(this.expected));
            }
            long j2 = this.expected;
            if (j > j2) {
                throw Http2Exception.streamError(i, Http2Error.PROTOCOL_ERROR, "Received amount of data %d does not match content-length header %d", Long.valueOf(j), Long.valueOf(this.expected));
            }
            if (z2) {
                if ((j != 0 || z) && j2 > j) {
                    throw Http2Exception.streamError(i, Http2Error.PROTOCOL_ERROR, "Received amount of data %d does not match content-length header %d", Long.valueOf(j), Long.valueOf(this.expected));
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public final class FrameReadListener implements Http2FrameListener {
        private FrameReadListener() {
        }

        private void applyLocalSettings(Http2Settings http2Settings) throws Http2Exception {
            Boolean boolPushEnabled = http2Settings.pushEnabled();
            Http2FrameReader.Configuration configuration = DefaultHttp2ConnectionDecoder.this.frameReader.configuration();
            Http2HeadersDecoder.Configuration configurationHeadersConfiguration = configuration.headersConfiguration();
            Http2FrameSizePolicy http2FrameSizePolicyFrameSizePolicy = configuration.frameSizePolicy();
            if (boolPushEnabled != null) {
                if (DefaultHttp2ConnectionDecoder.this.connection.isServer()) {
                    throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Server sending SETTINGS frame with ENABLE_PUSH specified", new Object[0]);
                }
                DefaultHttp2ConnectionDecoder.this.connection.local().allowPushTo(boolPushEnabled.booleanValue());
            }
            Long lMaxConcurrentStreams = http2Settings.maxConcurrentStreams();
            if (lMaxConcurrentStreams != null) {
                DefaultHttp2ConnectionDecoder.this.connection.remote().maxActiveStreams((int) Math.min(lMaxConcurrentStreams.longValue(), 2147483647L));
            }
            Long lHeaderTableSize = http2Settings.headerTableSize();
            if (lHeaderTableSize != null) {
                configurationHeadersConfiguration.maxHeaderTableSize(lHeaderTableSize.longValue());
            }
            Long lMaxHeaderListSize = http2Settings.maxHeaderListSize();
            if (lMaxHeaderListSize != null) {
                configurationHeadersConfiguration.maxHeaderListSize(lMaxHeaderListSize.longValue(), DefaultHttp2ConnectionDecoder.this.calculateMaxHeaderListSizeGoAway(lMaxHeaderListSize.longValue()));
            }
            Integer numMaxFrameSize = http2Settings.maxFrameSize();
            if (numMaxFrameSize != null) {
                http2FrameSizePolicyFrameSizePolicy.maxFrameSize(numMaxFrameSize.intValue());
            }
            Integer numInitialWindowSize = http2Settings.initialWindowSize();
            if (numInitialWindowSize != null) {
                DefaultHttp2ConnectionDecoder.this.flowController().initialWindowSize(numInitialWindowSize.intValue());
            }
        }

        private boolean shouldIgnoreHeadersOrDataFrame(ChannelHandlerContext channelHandlerContext, int i, Http2Stream http2Stream, String str) throws Http2Exception {
            String str2;
            if (http2Stream == null) {
                if (streamCreatedAfterGoAwaySent(i)) {
                    DefaultHttp2ConnectionDecoder.logger.info("{} ignoring {} frame for stream {}. Stream sent after GOAWAY sent", channelHandlerContext.channel(), str, Integer.valueOf(i));
                    return true;
                }
                verifyStreamMayHaveExisted(i);
                throw Http2Exception.streamError(i, Http2Error.STREAM_CLOSED, "Received %s frame for an unknown stream %d", str, Integer.valueOf(i));
            }
            if (!http2Stream.isResetSent() && !streamCreatedAfterGoAwaySent(i)) {
                return false;
            }
            if (DefaultHttp2ConnectionDecoder.logger.isInfoEnabled()) {
                InternalLogger internalLogger = DefaultHttp2ConnectionDecoder.logger;
                Channel channel = channelHandlerContext.channel();
                if (http2Stream.isResetSent()) {
                    str2 = "RST_STREAM sent.";
                } else {
                    str2 = "Stream created after GOAWAY sent. Last known stream by peer " + DefaultHttp2ConnectionDecoder.this.connection.remote().lastStreamKnownByPeer();
                }
                internalLogger.info("{} ignoring {} frame for stream {}", channel, str, str2);
            }
            return true;
        }

        private boolean streamCreatedAfterGoAwaySent(int i) {
            Http2Connection.Endpoint<Http2RemoteFlowController> endpointRemote = DefaultHttp2ConnectionDecoder.this.connection.remote();
            return DefaultHttp2ConnectionDecoder.this.connection.goAwaySent() && endpointRemote.isValidStreamId(i) && i > endpointRemote.lastStreamKnownByPeer();
        }

        private void verifyStreamMayHaveExisted(int i) throws Http2Exception {
            if (!DefaultHttp2ConnectionDecoder.this.connection.streamMayHaveExisted(i)) {
                throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Stream %d does not exist", Integer.valueOf(i));
            }
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public int onDataRead(ChannelHandlerContext channelHandlerContext, int i, ByteBuf byteBuf, int i2, boolean z) throws Http2Exception {
            Http2Stream http2StreamStream = DefaultHttp2ConnectionDecoder.this.connection.stream(i);
            Http2LocalFlowController http2LocalFlowControllerFlowController = DefaultHttp2ConnectionDecoder.this.flowController();
            int i4 = byteBuf.readableBytes();
            int i5 = i4 + i2;
            try {
                if (shouldIgnoreHeadersOrDataFrame(channelHandlerContext, i, http2StreamStream, "DATA")) {
                    http2LocalFlowControllerFlowController.receiveFlowControlledFrame(http2StreamStream, byteBuf, i2, z);
                    http2LocalFlowControllerFlowController.consumeBytes(http2StreamStream, i5);
                    verifyStreamMayHaveExisted(i);
                    return i5;
                }
                int i6 = C125831.$SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[http2StreamStream.state().ordinal()];
                Http2Exception http2ExceptionStreamError = (i6 == 1 || i6 == 2) ? null : (i6 == 3 || i6 == 4) ? Http2Exception.streamError(http2StreamStream.mo13773id(), Http2Error.STREAM_CLOSED, "Stream %d in unexpected state: %s", Integer.valueOf(http2StreamStream.mo13773id()), http2StreamStream.state()) : Http2Exception.streamError(http2StreamStream.mo13773id(), Http2Error.PROTOCOL_ERROR, "Stream %d in unexpected state: %s", Integer.valueOf(http2StreamStream.mo13773id()), http2StreamStream.state());
                int iUnconsumedBytes = DefaultHttp2ConnectionDecoder.this.unconsumedBytes(http2StreamStream);
                try {
                    try {
                        try {
                            http2LocalFlowControllerFlowController.receiveFlowControlledFrame(http2StreamStream, byteBuf, i2, z);
                            DefaultHttp2ConnectionDecoder.this.unconsumedBytes(http2StreamStream);
                            if (http2ExceptionStreamError != null) {
                                throw http2ExceptionStreamError;
                            }
                            DefaultHttp2ConnectionDecoder.this.verifyContentLength(http2StreamStream, i4, z);
                            int iOnDataRead = DefaultHttp2ConnectionDecoder.this.listener.onDataRead(channelHandlerContext, i, byteBuf, i2, z);
                            if (z) {
                                DefaultHttp2ConnectionDecoder.this.lifecycleManager.closeStreamRemote(http2StreamStream, channelHandlerContext.newSucceededFuture());
                            }
                            http2LocalFlowControllerFlowController.consumeBytes(http2StreamStream, iOnDataRead);
                            return iOnDataRead;
                        } catch (RuntimeException e) {
                            int iUnconsumedBytes2 = i5 - (iUnconsumedBytes - DefaultHttp2ConnectionDecoder.this.unconsumedBytes(http2StreamStream));
                            throw e;
                        }
                    } catch (Http2Exception e2) {
                        int iUnconsumedBytes3 = i5 - (iUnconsumedBytes - DefaultHttp2ConnectionDecoder.this.unconsumedBytes(http2StreamStream));
                        throw e2;
                    }
                } catch (Throwable th) {
                    http2LocalFlowControllerFlowController.consumeBytes(http2StreamStream, i5);
                    throw th;
                }
            } catch (Http2Exception e3) {
                http2LocalFlowControllerFlowController.receiveFlowControlledFrame(http2StreamStream, byteBuf, i2, z);
                http2LocalFlowControllerFlowController.consumeBytes(http2StreamStream, i5);
                throw e3;
            } catch (Throwable th2) {
                throw Http2Exception.connectionError(Http2Error.INTERNAL_ERROR, th2, "Unhandled error on data stream id %d", Integer.valueOf(i));
            }
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onGoAwayRead(ChannelHandlerContext channelHandlerContext, int i, long j, ByteBuf byteBuf) {
            DefaultHttp2ConnectionDecoder.this.onGoAwayRead0(channelHandlerContext, i, j, byteBuf);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onHeadersRead(ChannelHandlerContext channelHandlerContext, int i, Http2Headers http2Headers, int i2, boolean z) throws Http2Exception {
            onHeadersRead(channelHandlerContext, i, http2Headers, 0, (short) 16, false, i2, z);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onPingAckRead(ChannelHandlerContext channelHandlerContext, long j) {
            DefaultHttp2ConnectionDecoder.this.listener.onPingAckRead(channelHandlerContext, j);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onPingRead(ChannelHandlerContext channelHandlerContext, long j) {
            ChannelHandlerContext channelHandlerContext2;
            long j2;
            if (DefaultHttp2ConnectionDecoder.this.autoAckPing) {
                channelHandlerContext2 = channelHandlerContext;
                j2 = j;
                DefaultHttp2ConnectionDecoder.this.encoder.writePing(channelHandlerContext2, true, j2, channelHandlerContext.newPromise());
            } else {
                channelHandlerContext2 = channelHandlerContext;
                j2 = j;
            }
            DefaultHttp2ConnectionDecoder.this.listener.onPingRead(channelHandlerContext2, j2);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onPriorityRead(ChannelHandlerContext channelHandlerContext, int i, int i2, short s, boolean z) {
            DefaultHttp2ConnectionDecoder.this.encoder.flowController().updateDependencyTree(i, i2, s, z);
            DefaultHttp2ConnectionDecoder.this.listener.onPriorityRead(channelHandlerContext, i, i2, s, z);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onPushPromiseRead(ChannelHandlerContext channelHandlerContext, int i, int i2, Http2Headers http2Headers, int i4) throws Http2Exception {
            if (DefaultHttp2ConnectionDecoder.this.connection().isServer()) {
                throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "A client cannot push.", new Object[0]);
            }
            Http2Stream http2StreamStream = DefaultHttp2ConnectionDecoder.this.connection.stream(i);
            if (shouldIgnoreHeadersOrDataFrame(channelHandlerContext, i, http2StreamStream, "PUSH_PROMISE")) {
                return;
            }
            int i5 = C125831.$SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[http2StreamStream.state().ordinal()];
            if (i5 != 1 && i5 != 2) {
                throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Stream %d in unexpected state for receiving push promise: %s", Integer.valueOf(http2StreamStream.mo13773id()), http2StreamStream.state());
            }
            if (!DefaultHttp2ConnectionDecoder.this.requestVerifier.isAuthoritative(channelHandlerContext, http2Headers)) {
                throw Http2Exception.streamError(i2, Http2Error.PROTOCOL_ERROR, "Promised request on stream %d for promised stream %d is not authoritative", Integer.valueOf(i), Integer.valueOf(i2));
            }
            if (!DefaultHttp2ConnectionDecoder.this.requestVerifier.isCacheable(http2Headers)) {
                throw Http2Exception.streamError(i2, Http2Error.PROTOCOL_ERROR, "Promised request on stream %d for promised stream %d is not known to be cacheable", Integer.valueOf(i), Integer.valueOf(i2));
            }
            if (!DefaultHttp2ConnectionDecoder.this.requestVerifier.isSafe(http2Headers)) {
                throw Http2Exception.streamError(i2, Http2Error.PROTOCOL_ERROR, "Promised request on stream %d for promised stream %d is not known to be safe", Integer.valueOf(i), Integer.valueOf(i2));
            }
            DefaultHttp2ConnectionDecoder.this.connection.remote().reservePushStream(i2, http2StreamStream);
            DefaultHttp2ConnectionDecoder.this.listener.onPushPromiseRead(channelHandlerContext, i, i2, http2Headers, i4);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onRstStreamRead(ChannelHandlerContext channelHandlerContext, int i, long j) throws Http2Exception {
            Http2Stream http2StreamStream = DefaultHttp2ConnectionDecoder.this.connection.stream(i);
            if (http2StreamStream == null) {
                verifyStreamMayHaveExisted(i);
                return;
            }
            int i2 = C125831.$SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[http2StreamStream.state().ordinal()];
            if (i2 != 4) {
                if (i2 == 6) {
                    throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "RST_STREAM received for IDLE stream %d", Integer.valueOf(i));
                }
                DefaultHttp2ConnectionDecoder.this.listener.onRstStreamRead(channelHandlerContext, i, j);
                DefaultHttp2ConnectionDecoder.this.lifecycleManager.closeStream(http2StreamStream, channelHandlerContext.newSucceededFuture());
            }
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onSettingsAckRead(ChannelHandlerContext channelHandlerContext) throws Http2Exception {
            Http2Settings http2SettingsPollSentSettings = DefaultHttp2ConnectionDecoder.this.encoder.pollSentSettings();
            if (http2SettingsPollSentSettings != null) {
                applyLocalSettings(http2SettingsPollSentSettings);
            }
            DefaultHttp2ConnectionDecoder.this.listener.onSettingsAckRead(channelHandlerContext);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onSettingsRead(ChannelHandlerContext channelHandlerContext, Http2Settings http2Settings) {
            if (DefaultHttp2ConnectionDecoder.this.settingsReceivedConsumer == null) {
                DefaultHttp2ConnectionDecoder.this.encoder.writeSettingsAck(channelHandlerContext, channelHandlerContext.newPromise());
                DefaultHttp2ConnectionDecoder.this.encoder.remoteSettings(http2Settings);
            } else {
                DefaultHttp2ConnectionDecoder.this.settingsReceivedConsumer.consumeReceivedSettings(http2Settings);
            }
            DefaultHttp2ConnectionDecoder.this.listener.onSettingsRead(channelHandlerContext, http2Settings);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onUnknownFrame(ChannelHandlerContext channelHandlerContext, byte b, int i, Http2Flags http2Flags, ByteBuf byteBuf) {
            DefaultHttp2ConnectionDecoder.this.onUnknownFrame0(channelHandlerContext, b, i, http2Flags, byteBuf);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onWindowUpdateRead(ChannelHandlerContext channelHandlerContext, int i, int i2) throws Http2Exception {
            Http2Stream http2StreamStream = DefaultHttp2ConnectionDecoder.this.connection.stream(i);
            if (http2StreamStream == null || http2StreamStream.state() == Http2Stream.State.CLOSED || streamCreatedAfterGoAwaySent(i)) {
                verifyStreamMayHaveExisted(i);
            } else {
                DefaultHttp2ConnectionDecoder.this.encoder.flowController().incrementWindowSize(http2StreamStream, i2);
                DefaultHttp2ConnectionDecoder.this.listener.onWindowUpdateRead(channelHandlerContext, i, i2);
            }
        }

        public /* synthetic */ FrameReadListener(DefaultHttp2ConnectionDecoder defaultHttp2ConnectionDecoder, C125831 c125831) {
            this();
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onHeadersRead(ChannelHandlerContext channelHandlerContext, int i, Http2Headers http2Headers, int i2, short s, boolean z, int i4, boolean z2) throws Http2Exception {
            Http2Stream http2Stream;
            boolean zIsHeadersReceived;
            boolean z3;
            AsciiString asciiString;
            List<CharSequence> all;
            Http2Stream http2StreamStream = DefaultHttp2ConnectionDecoder.this.connection.stream(i);
            if (http2StreamStream == null && !DefaultHttp2ConnectionDecoder.this.connection.streamMayHaveExisted(i)) {
                Http2Stream http2StreamCreateStream = DefaultHttp2ConnectionDecoder.this.connection.remote().createStream(i, z2);
                z3 = http2StreamCreateStream.state() == Http2Stream.State.HALF_CLOSED_REMOTE;
                http2Stream = http2StreamCreateStream;
                zIsHeadersReceived = false;
            } else if (http2StreamStream != null) {
                http2Stream = http2StreamStream;
                zIsHeadersReceived = http2StreamStream.isHeadersReceived();
                z3 = false;
            } else {
                http2Stream = http2StreamStream;
                zIsHeadersReceived = false;
                z3 = false;
            }
            if (shouldIgnoreHeadersOrDataFrame(channelHandlerContext, i, http2Stream, "HEADERS")) {
                return;
            }
            boolean z4 = !DefaultHttp2ConnectionDecoder.this.connection.isServer() && HttpStatusClass.valueOf(http2Headers.status()) == HttpStatusClass.INFORMATIONAL;
            if (((z4 || !z2) && http2Stream.isHeadersReceived()) || http2Stream.isTrailersReceived()) {
                throw Http2Exception.streamError(i, Http2Error.PROTOCOL_ERROR, "Stream %d received too many headers EOS: %s state: %s", Integer.valueOf(i), Boolean.valueOf(z2), http2Stream.state());
            }
            int i5 = C125831.$SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[http2Stream.state().ordinal()];
            if (i5 != 1 && i5 != 2) {
                if (i5 != 3) {
                    if (i5 == 4) {
                        throw Http2Exception.streamError(http2Stream.mo13773id(), Http2Error.STREAM_CLOSED, "Stream %d in unexpected state: %s", Integer.valueOf(http2Stream.mo13773id()), http2Stream.state());
                    }
                    if (i5 != 5) {
                        throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Stream %d in unexpected state: %s", Integer.valueOf(http2Stream.mo13773id()), http2Stream.state());
                    }
                    http2Stream.open(z2);
                } else if (!z3) {
                    throw Http2Exception.streamError(http2Stream.mo13773id(), Http2Error.STREAM_CLOSED, "Stream %d in unexpected state: %s", Integer.valueOf(http2Stream.mo13773id()), http2Stream.state());
                }
            }
            if (!zIsHeadersReceived && (all = http2Headers.getAll((asciiString = HttpHeaderNames.CONTENT_LENGTH))) != null && !all.isEmpty()) {
                try {
                    long jNormalizeAndGetContentLength = HttpUtil.normalizeAndGetContentLength(all, false, true);
                    if (jNormalizeAndGetContentLength != -1) {
                        http2Headers.setLong(asciiString, jNormalizeAndGetContentLength);
                        http2Stream.setProperty(DefaultHttp2ConnectionDecoder.this.contentLengthKey, new ContentLength(jNormalizeAndGetContentLength));
                    }
                } catch (IllegalArgumentException e) {
                    throw Http2Exception.streamError(http2Stream.mo13773id(), Http2Error.PROTOCOL_ERROR, e, "Multiple content-length headers received", new Object[0]);
                }
            }
            http2Stream.headersReceived(z4);
            DefaultHttp2ConnectionDecoder.this.verifyContentLength(http2Stream, 0, z2);
            DefaultHttp2ConnectionDecoder.this.encoder.flowController().updateDependencyTree(i, i2, s, z);
            DefaultHttp2ConnectionDecoder.this.listener.onHeadersRead(channelHandlerContext, i, http2Headers, i2, s, z, i4, z2);
            if (z2) {
                DefaultHttp2ConnectionDecoder.this.lifecycleManager.closeStreamRemote(http2Stream, channelHandlerContext.newSucceededFuture());
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public final class PrefaceFrameListener implements Http2FrameListener {
        private PrefaceFrameListener() {
        }

        private void verifyPrefaceReceived() throws Http2Exception {
            if (!DefaultHttp2ConnectionDecoder.this.prefaceReceived()) {
                throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Received non-SETTINGS as first frame.", new Object[0]);
            }
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public int onDataRead(ChannelHandlerContext channelHandlerContext, int i, ByteBuf byteBuf, int i2, boolean z) throws Http2Exception {
            verifyPrefaceReceived();
            return DefaultHttp2ConnectionDecoder.this.internalFrameListener.onDataRead(channelHandlerContext, i, byteBuf, i2, z);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onGoAwayRead(ChannelHandlerContext channelHandlerContext, int i, long j, ByteBuf byteBuf) {
            DefaultHttp2ConnectionDecoder.this.onGoAwayRead0(channelHandlerContext, i, j, byteBuf);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onHeadersRead(ChannelHandlerContext channelHandlerContext, int i, Http2Headers http2Headers, int i2, boolean z) throws Http2Exception {
            verifyPrefaceReceived();
            DefaultHttp2ConnectionDecoder.this.internalFrameListener.onHeadersRead(channelHandlerContext, i, http2Headers, i2, z);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onPingAckRead(ChannelHandlerContext channelHandlerContext, long j) throws Http2Exception {
            verifyPrefaceReceived();
            DefaultHttp2ConnectionDecoder.this.internalFrameListener.onPingAckRead(channelHandlerContext, j);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onPingRead(ChannelHandlerContext channelHandlerContext, long j) throws Http2Exception {
            verifyPrefaceReceived();
            DefaultHttp2ConnectionDecoder.this.internalFrameListener.onPingRead(channelHandlerContext, j);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onPriorityRead(ChannelHandlerContext channelHandlerContext, int i, int i2, short s, boolean z) throws Http2Exception {
            verifyPrefaceReceived();
            DefaultHttp2ConnectionDecoder.this.internalFrameListener.onPriorityRead(channelHandlerContext, i, i2, s, z);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onPushPromiseRead(ChannelHandlerContext channelHandlerContext, int i, int i2, Http2Headers http2Headers, int i4) throws Http2Exception {
            verifyPrefaceReceived();
            DefaultHttp2ConnectionDecoder.this.internalFrameListener.onPushPromiseRead(channelHandlerContext, i, i2, http2Headers, i4);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onRstStreamRead(ChannelHandlerContext channelHandlerContext, int i, long j) throws Http2Exception {
            verifyPrefaceReceived();
            DefaultHttp2ConnectionDecoder.this.internalFrameListener.onRstStreamRead(channelHandlerContext, i, j);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onSettingsAckRead(ChannelHandlerContext channelHandlerContext) throws Http2Exception {
            verifyPrefaceReceived();
            DefaultHttp2ConnectionDecoder.this.internalFrameListener.onSettingsAckRead(channelHandlerContext);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onSettingsRead(ChannelHandlerContext channelHandlerContext, Http2Settings http2Settings) {
            if (!DefaultHttp2ConnectionDecoder.this.prefaceReceived()) {
                DefaultHttp2ConnectionDecoder defaultHttp2ConnectionDecoder = DefaultHttp2ConnectionDecoder.this;
                defaultHttp2ConnectionDecoder.internalFrameListener = new FrameReadListener(defaultHttp2ConnectionDecoder, null);
            }
            DefaultHttp2ConnectionDecoder.this.internalFrameListener.onSettingsRead(channelHandlerContext, http2Settings);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onUnknownFrame(ChannelHandlerContext channelHandlerContext, byte b, int i, Http2Flags http2Flags, ByteBuf byteBuf) {
            DefaultHttp2ConnectionDecoder.this.onUnknownFrame0(channelHandlerContext, b, i, http2Flags, byteBuf);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onWindowUpdateRead(ChannelHandlerContext channelHandlerContext, int i, int i2) throws Http2Exception {
            verifyPrefaceReceived();
            DefaultHttp2ConnectionDecoder.this.internalFrameListener.onWindowUpdateRead(channelHandlerContext, i, i2);
        }

        public /* synthetic */ PrefaceFrameListener(DefaultHttp2ConnectionDecoder defaultHttp2ConnectionDecoder, C125831 c125831) {
            this();
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onHeadersRead(ChannelHandlerContext channelHandlerContext, int i, Http2Headers http2Headers, int i2, short s, boolean z, int i4, boolean z2) throws Http2Exception {
            verifyPrefaceReceived();
            DefaultHttp2ConnectionDecoder.this.internalFrameListener.onHeadersRead(channelHandlerContext, i, http2Headers, i2, s, z, i4, z2);
        }
    }

    public DefaultHttp2ConnectionDecoder(Http2Connection http2Connection, Http2ConnectionEncoder http2ConnectionEncoder, Http2FrameReader http2FrameReader) {
        this(http2Connection, http2ConnectionEncoder, http2FrameReader, Http2PromisedRequestVerifier.ALWAYS_VERIFY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int unconsumedBytes(Http2Stream http2Stream) {
        return flowController().unconsumedBytes(http2Stream);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void verifyContentLength(Http2Stream http2Stream, int i, boolean z) {
        ContentLength contentLength = (ContentLength) http2Stream.getProperty(this.contentLengthKey);
        if (contentLength != null) {
            try {
                contentLength.increaseReceivedBytes(this.connection.isServer(), http2Stream.mo13773id(), i, z);
            } finally {
                if (z) {
                    http2Stream.removeProperty(this.contentLengthKey);
                }
            }
        }
    }

    public long calculateMaxHeaderListSizeGoAway(long j) {
        return Http2CodecUtil.calculateMaxHeaderListSizeGoAway(j);
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionDecoder, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.frameReader.close();
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionDecoder
    public Http2Connection connection() {
        return this.connection;
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionDecoder
    public void decodeFrame(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        this.frameReader.readFrame(channelHandlerContext, byteBuf, this.internalFrameListener);
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionDecoder
    public final Http2LocalFlowController flowController() {
        return (Http2LocalFlowController) this.connection.local().flowController();
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionDecoder
    public void frameListener(Http2FrameListener http2FrameListener) {
        this.listener = (Http2FrameListener) ObjectUtil.checkNotNull(http2FrameListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionDecoder
    public void lifecycleManager(Http2LifecycleManager http2LifecycleManager) {
        this.lifecycleManager = (Http2LifecycleManager) ObjectUtil.checkNotNull(http2LifecycleManager, "lifecycleManager");
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionDecoder
    public Http2Settings localSettings() {
        Http2Settings http2Settings = new Http2Settings();
        Http2FrameReader.Configuration configuration = this.frameReader.configuration();
        Http2HeadersDecoder.Configuration configurationHeadersConfiguration = configuration.headersConfiguration();
        Http2FrameSizePolicy http2FrameSizePolicyFrameSizePolicy = configuration.frameSizePolicy();
        http2Settings.initialWindowSize(flowController().initialWindowSize());
        http2Settings.maxConcurrentStreams(this.connection.remote().maxActiveStreams());
        http2Settings.headerTableSize(configurationHeadersConfiguration.maxHeaderTableSize());
        http2Settings.maxFrameSize(http2FrameSizePolicyFrameSizePolicy.maxFrameSize());
        http2Settings.maxHeaderListSize(configurationHeadersConfiguration.maxHeaderListSize());
        if (!this.connection.isServer()) {
            http2Settings.pushEnabled(this.connection.local().allowPushTo());
        }
        return http2Settings;
    }

    public void onGoAwayRead0(ChannelHandlerContext channelHandlerContext, int i, long j, ByteBuf byteBuf) {
        this.listener.onGoAwayRead(channelHandlerContext, i, j, byteBuf);
        this.connection.goAwayReceived(i, j, byteBuf);
    }

    public void onUnknownFrame0(ChannelHandlerContext channelHandlerContext, byte b, int i, Http2Flags http2Flags, ByteBuf byteBuf) {
        this.listener.onUnknownFrame(channelHandlerContext, b, i, http2Flags, byteBuf);
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionDecoder
    public boolean prefaceReceived() {
        return FrameReadListener.class == this.internalFrameListener.getClass();
    }

    public DefaultHttp2ConnectionDecoder(Http2Connection http2Connection, Http2ConnectionEncoder http2ConnectionEncoder, Http2FrameReader http2FrameReader, Http2PromisedRequestVerifier http2PromisedRequestVerifier) {
        this(http2Connection, http2ConnectionEncoder, http2FrameReader, http2PromisedRequestVerifier, true);
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionDecoder
    public Http2FrameListener frameListener() {
        return this.listener;
    }

    public DefaultHttp2ConnectionDecoder(Http2Connection http2Connection, Http2ConnectionEncoder http2ConnectionEncoder, Http2FrameReader http2FrameReader, Http2PromisedRequestVerifier http2PromisedRequestVerifier, boolean z) {
        this(http2Connection, http2ConnectionEncoder, http2FrameReader, http2PromisedRequestVerifier, z, true);
    }

    public DefaultHttp2ConnectionDecoder(Http2Connection http2Connection, Http2ConnectionEncoder http2ConnectionEncoder, Http2FrameReader http2FrameReader, Http2PromisedRequestVerifier http2PromisedRequestVerifier, boolean z, boolean z2) {
        this.internalFrameListener = new PrefaceFrameListener(this, null);
        this.autoAckPing = z2;
        if (z) {
            this.settingsReceivedConsumer = null;
        } else if (http2ConnectionEncoder instanceof Http2SettingsReceivedConsumer) {
            this.settingsReceivedConsumer = (Http2SettingsReceivedConsumer) http2ConnectionEncoder;
        } else {
            throw new IllegalArgumentException(AbstractC2322a.m1621k("disabling autoAckSettings requires the encoder to be a ", Http2SettingsReceivedConsumer.class));
        }
        Http2Connection http2Connection2 = (Http2Connection) ObjectUtil.checkNotNull(http2Connection, "connection");
        this.connection = http2Connection2;
        this.contentLengthKey = http2Connection2.newKey();
        this.frameReader = (Http2FrameReader) ObjectUtil.checkNotNull(http2FrameReader, "frameReader");
        this.encoder = (Http2ConnectionEncoder) ObjectUtil.checkNotNull(http2ConnectionEncoder, "encoder");
        this.requestVerifier = (Http2PromisedRequestVerifier) ObjectUtil.checkNotNull(http2PromisedRequestVerifier, "requestVerifier");
        if (http2Connection.local().flowController() == null) {
            http2Connection.local().flowController(new DefaultHttp2LocalFlowController(http2Connection));
        }
        ((Http2LocalFlowController) http2Connection.local().flowController()).frameWriter(http2ConnectionEncoder.frameWriter());
    }
}
