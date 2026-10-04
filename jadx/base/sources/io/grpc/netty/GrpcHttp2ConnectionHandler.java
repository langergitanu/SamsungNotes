package io.grpc.netty;

import com.google.common.base.Preconditions;
import io.grpc.Attributes;
import io.grpc.ChannelLogger;
import io.grpc.Internal;
import io.grpc.InternalChannelz;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.http2.Http2ConnectionDecoder;
import io.netty.handler.codec.http2.Http2ConnectionEncoder;
import io.netty.handler.codec.http2.Http2ConnectionHandler;
import io.netty.handler.codec.http2.Http2Settings;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Internal
public abstract class GrpcHttp2ConnectionHandler extends Http2ConnectionHandler {
    static final ByteToMessageDecoder.Cumulator ADAPTIVE_CUMULATOR = new NettyAdaptiveCumulator(1024);
    static final int ADAPTIVE_CUMULATOR_COMPOSE_MIN_SIZE_DEFAULT = 1024;

    @Nullable
    protected final ChannelPromise channelUnused;
    private final ChannelLogger negotiationLogger;

    public GrpcHttp2ConnectionHandler(ChannelPromise channelPromise, Http2ConnectionDecoder http2ConnectionDecoder, Http2ConnectionEncoder http2ConnectionEncoder, Http2Settings http2Settings, ChannelLogger channelLogger) {
        super(http2ConnectionDecoder, http2ConnectionEncoder, http2Settings);
        this.channelUnused = channelPromise;
        this.negotiationLogger = channelLogger;
        setCumulator(ADAPTIVE_CUMULATOR);
    }

    public String getAuthority() {
        throw new UnsupportedOperationException();
    }

    public Attributes getEagAttributes() {
        return Attributes.EMPTY;
    }

    public ChannelLogger getNegotiationLogger() {
        Preconditions.checkState(this.negotiationLogger != null, "NegotiationLogger must not be null");
        return this.negotiationLogger;
    }

    public void handleProtocolNegotiationCompleted(Attributes attributes, InternalChannelz.Security security) {
    }

    public void notifyUnused() {
        this.channelUnused.setSuccess((Void) null);
    }

    @Deprecated
    public void handleProtocolNegotiationCompleted(Attributes attributes) {
        handleProtocolNegotiationCompleted(attributes, null);
    }
}
