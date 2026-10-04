package io.grpc.netty;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Ticker;
import io.grpc.ChannelLogger;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.http2.Http2CodecUtil;
import io.netty.handler.codec.http2.Http2ConnectionDecoder;
import io.netty.handler.codec.http2.Http2ConnectionEncoder;
import io.netty.handler.codec.http2.Http2LocalFlowController;
import io.netty.handler.codec.http2.Http2Settings;
import io.netty.handler.codec.http2.Http2Stream;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
abstract class AbstractNettyHandler extends GrpcHttp2ConnectionHandler {
    private static final long BDP_MEASUREMENT_PING = 1234;
    private static final long GRACEFUL_SHUTDOWN_NO_TIMEOUT = -1;
    private boolean autoTuneFlowControlOn;
    private ChannelHandlerContext ctx;
    private final FlowControlPinger flowControlPing;
    private final int initialConnectionWindow;
    private boolean initialWindowSent;
    private final Ticker ticker;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class AllowPingLimiter implements PingLimiter {
        private AllowPingLimiter() {
        }

        @Override // io.grpc.netty.AbstractNettyHandler.PingLimiter
        public boolean isPingAllowed() {
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public final class FlowControlPinger {
        public static final int MAX_BACKOFF = 10;
        private static final int MAX_WINDOW_SIZE = 8388608;
        private int dataSizeSincePing;
        private long lastBandwidth;
        private long lastPingTime;
        private int lastTargetWindow;
        private int pingCount;
        private int pingFrequencyMultiplier;
        private final PingLimiter pingLimiter;
        private int pingReturn;
        private boolean pinging;

        public FlowControlPinger(PingLimiter pingLimiter) {
            Preconditions.checkNotNull(pingLimiter, "pingLimiter");
            this.pingLimiter = pingLimiter;
        }

        private void incrementDataSincePing(int i) {
            setDataSizeSincePing(getDataSincePing() + i);
        }

        private boolean isPinging() {
            return this.pinging;
        }

        private void sendPing(ChannelHandlerContext channelHandlerContext) {
            setDataSizeSincePing(0);
            this.lastPingTime = AbstractNettyHandler.this.ticker.read();
            AbstractNettyHandler.this.encoder().writePing(channelHandlerContext, false, AbstractNettyHandler.BDP_MEASUREMENT_PING, channelHandlerContext.newPromise());
            this.pingCount++;
        }

        private void setDataSizeSincePing(int i) {
            this.dataSizeSincePing = i;
        }

        private void setPinging(boolean z) {
            this.pinging = z;
        }

        @VisibleForTesting
        public int getDataSincePing() {
            return this.dataSizeSincePing;
        }

        @VisibleForTesting
        public int getPingCount() {
            return this.pingCount;
        }

        @VisibleForTesting
        public int getPingReturn() {
            return this.pingReturn;
        }

        public int maxWindow() {
            return 8388608;
        }

        public void onDataRead(int i, int i2) {
            if (AbstractNettyHandler.this.autoTuneFlowControlOn) {
                int dataSincePing = getDataSincePing() + i + i2;
                if (!isPinging() && this.pingLimiter.isPingAllowed() && dataSincePing * 2 >= this.lastTargetWindow * this.pingFrequencyMultiplier) {
                    setPinging(true);
                    sendPing(AbstractNettyHandler.this.ctx());
                }
                if (this.lastTargetWindow == 0) {
                    this.lastTargetWindow = AbstractNettyHandler.this.decoder().flowController().initialWindowSize(AbstractNettyHandler.this.connection().connectionStream());
                }
                incrementDataSincePing(i + i2);
            }
        }

        public long payload() {
            return AbstractNettyHandler.BDP_MEASUREMENT_PING;
        }

        @VisibleForTesting
        public void setDataSizeAndSincePing(int i) {
            setDataSizeSincePing(i);
            this.pingFrequencyMultiplier = 1;
            this.lastPingTime = AbstractNettyHandler.this.ticker.read();
        }

        public void updateWindow() {
            if (AbstractNettyHandler.this.autoTuneFlowControlOn) {
                this.pingReturn++;
                setPinging(false);
                long j = AbstractNettyHandler.this.ticker.read() - this.lastPingTime;
                if (j == 0) {
                    j = 1;
                }
                long nanos = (TimeUnit.SECONDS.toNanos(1L) * ((long) getDataSincePing())) / j;
                int iMin = Math.min(getDataSincePing() * 2, 8388608);
                Http2LocalFlowController http2LocalFlowControllerFlowController = AbstractNettyHandler.this.decoder().flowController();
                int iInitialWindowSize = http2LocalFlowControllerFlowController.initialWindowSize(AbstractNettyHandler.this.connection().connectionStream());
                if (nanos <= this.lastBandwidth || iMin <= iInitialWindowSize) {
                    this.pingFrequencyMultiplier = Math.min(this.pingFrequencyMultiplier + 1, 10);
                    return;
                }
                this.pingFrequencyMultiplier = 0;
                this.lastBandwidth = nanos;
                this.lastTargetWindow = iMin;
                http2LocalFlowControllerFlowController.incrementWindowSize(AbstractNettyHandler.this.connection().connectionStream(), iMin - iInitialWindowSize);
                http2LocalFlowControllerFlowController.initialWindowSize(iMin);
                Http2Settings http2Settings = new Http2Settings();
                http2Settings.initialWindowSize(iMin);
                AbstractNettyHandler.this.frameWriter().writeSettings(AbstractNettyHandler.this.ctx(), http2Settings, AbstractNettyHandler.this.ctx().newPromise());
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface PingLimiter {
        boolean isPingAllowed();
    }

    public AbstractNettyHandler(ChannelPromise channelPromise, Http2ConnectionDecoder http2ConnectionDecoder, Http2ConnectionEncoder http2ConnectionEncoder, Http2Settings http2Settings, ChannelLogger channelLogger, boolean z, PingLimiter pingLimiter, Ticker ticker) {
        super(channelPromise, http2ConnectionDecoder, http2ConnectionEncoder, http2Settings, channelLogger);
        this.initialWindowSent = false;
        gracefulShutdownTimeoutMillis(-1L);
        this.initialConnectionWindow = http2Settings.initialWindowSize() == null ? -1 : http2Settings.initialWindowSize().intValue();
        this.autoTuneFlowControlOn = z;
        this.flowControlPing = new FlowControlPinger(pingLimiter == null ? new AllowPingLimiter() : pingLimiter);
        this.ticker = (Ticker) Preconditions.checkNotNull(ticker, "ticker");
    }

    private void sendInitialConnectionWindow() {
        if (this.initialWindowSent || !this.ctx.channel().isActive()) {
            return;
        }
        Http2Stream http2StreamConnectionStream = connection().connectionStream();
        decoder().flowController().incrementWindowSize(http2StreamConnectionStream, this.initialConnectionWindow - ((Http2LocalFlowController) connection().local().flowController()).windowSize(http2StreamConnectionStream));
        this.initialWindowSent = true;
        this.ctx.flush();
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionHandler, io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelActive(ChannelHandlerContext channelHandlerContext) {
        super.channelActive(channelHandlerContext);
        sendInitialConnectionWindow();
    }

    public final ChannelHandlerContext ctx() {
        return this.ctx;
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionHandler, io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
    public final void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) {
        if (Http2CodecUtil.getEmbeddedHttp2Exception(th) == null) {
            onError(channelHandlerContext, false, th);
        } else {
            super.exceptionCaught(channelHandlerContext, th);
        }
    }

    @VisibleForTesting
    public FlowControlPinger flowControlPing() {
        return this.flowControlPing;
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionHandler, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) {
        this.ctx = channelHandlerContext;
        super.handlerAdded(channelHandlerContext);
        sendInitialConnectionWindow();
    }

    @VisibleForTesting
    public void setAutoTuneFlowControl(boolean z) {
        this.autoTuneFlowControlOn = z;
    }
}
