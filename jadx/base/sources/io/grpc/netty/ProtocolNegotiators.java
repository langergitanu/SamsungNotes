package io.grpc.netty;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.ForOverride;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import io.grpc.CallCredentials;
import io.grpc.ChannelCredentials;
import io.grpc.ChannelLogger;
import io.grpc.ChoiceChannelCredentials;
import io.grpc.ChoiceServerCredentials;
import io.grpc.CompositeCallCredentials;
import io.grpc.CompositeChannelCredentials;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.InsecureServerCredentials;
import io.grpc.InternalChannelz;
import io.grpc.SecurityLevel;
import io.grpc.ServerCredentials;
import io.grpc.Status;
import io.grpc.TlsChannelCredentials;
import io.grpc.TlsServerCredentials;
import io.grpc.internal.GrpcAttributes;
import io.grpc.internal.GrpcUtil;
import io.grpc.internal.ObjectPool;
import io.grpc.netty.ProtocolNegotiator;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.DefaultHttpRequest;
import io.netty.handler.codec.http.HttpClientCodec;
import io.netty.handler.codec.http.HttpClientUpgradeHandler;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.handler.codec.http2.Http2ClientUpgradeCodec;
import io.netty.handler.proxy.HttpProxyHandler;
import io.netty.handler.proxy.ProxyConnectionEvent;
import io.netty.handler.ssl.ClientAuth;
import io.netty.handler.ssl.OpenSsl;
import io.netty.handler.ssl.OpenSslEngine;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.SslHandler;
import io.netty.handler.ssl.SslHandshakeCompletionEvent;
import io.netty.handler.ssl.SslProvider;
import io.netty.util.AsciiString;
import java.io.ByteArrayInputStream;
import java.net.SocketAddress;
import java.net.URI;
import java.nio.channels.ClosedChannelException;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSession;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
final class ProtocolNegotiators {
    private static final Logger log = Logger.getLogger(ProtocolNegotiators.class.getName());
    private static final EnumSet<TlsChannelCredentials.Feature> understoodTlsFeatures = EnumSet.of(TlsChannelCredentials.Feature.MTLS, TlsChannelCredentials.Feature.CUSTOM_MANAGERS);
    private static final EnumSet<TlsServerCredentials.Feature> understoodServerTlsFeatures = EnumSet.of(TlsServerCredentials.Feature.MTLS, TlsServerCredentials.Feature.CUSTOM_MANAGERS);

    /* JADX INFO: renamed from: io.grpc.netty.ProtocolNegotiators$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C122722 {
        static final /* synthetic */ int[] $SwitchMap$io$grpc$TlsServerCredentials$ClientAuth;

        static {
            int[] iArr = new int[TlsServerCredentials.ClientAuth.values().length];
            $SwitchMap$io$grpc$TlsServerCredentials$ClientAuth = iArr;
            try {
                iArr[TlsServerCredentials.ClientAuth.OPTIONAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$grpc$TlsServerCredentials$ClientAuth[TlsServerCredentials.ClientAuth.REQUIRE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$grpc$TlsServerCredentials$ClientAuth[TlsServerCredentials.ClientAuth.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ClientTlsHandler extends ProtocolNegotiationHandler {
        private Executor executor;
        private final String host;
        private final int port;
        private final SslContext sslContext;

        public ClientTlsHandler(ChannelHandler channelHandler, SslContext sslContext, String str, Executor executor, ChannelLogger channelLogger) {
            super(channelHandler, channelLogger);
            this.sslContext = (SslContext) Preconditions.checkNotNull(sslContext, "sslContext");
            HostPort authority = ProtocolNegotiators.parseAuthority(str);
            this.host = authority.host;
            this.port = authority.port;
            this.executor = executor;
        }

        private void propagateTlsComplete(ChannelHandlerContext channelHandlerContext, SSLSession sSLSession) {
            InternalChannelz.Security security = new InternalChannelz.Security(new InternalChannelz.Tls(sSLSession));
            ProtocolNegotiationEvent protocolNegotiationEvent = getProtocolNegotiationEvent();
            replaceProtocolNegotiationEvent(protocolNegotiationEvent.withAttributes(protocolNegotiationEvent.getAttributes().toBuilder().set(GrpcAttributes.ATTR_SECURITY_LEVEL, SecurityLevel.PRIVACY_AND_INTEGRITY).set(Grpc.TRANSPORT_ATTR_SSL_SESSION, sSLSession).build()).withSecurity(security));
            fireProtocolNegotiationEvent(channelHandlerContext);
        }

        @Override // io.grpc.netty.ProtocolNegotiators.ProtocolNegotiationHandler
        public void handlerAdded0(ChannelHandlerContext channelHandlerContext) {
            SSLEngine sSLEngineNewEngine = this.sslContext.newEngine(channelHandlerContext.alloc(), this.host, this.port);
            SSLParameters sSLParameters = sSLEngineNewEngine.getSSLParameters();
            sSLParameters.setEndpointIdentificationAlgorithm("HTTPS");
            sSLEngineNewEngine.setSSLParameters(sSLParameters);
            channelHandlerContext.pipeline().addBefore(channelHandlerContext.name(), null, this.executor != null ? new SslHandler(sSLEngineNewEngine, false, this.executor) : new SslHandler(sSLEngineNewEngine, false));
        }

        @Override // io.grpc.netty.ProtocolNegotiators.ProtocolNegotiationHandler
        public void userEventTriggered0(ChannelHandlerContext channelHandlerContext, Object obj) {
            if (!(obj instanceof SslHandshakeCompletionEvent)) {
                super.userEventTriggered0(channelHandlerContext, obj);
                return;
            }
            SslHandshakeCompletionEvent sslHandshakeCompletionEvent = (SslHandshakeCompletionEvent) obj;
            if (!sslHandshakeCompletionEvent.isSuccess()) {
                Throwable thCause = sslHandshakeCompletionEvent.cause();
                if (thCause instanceof ClosedChannelException) {
                    thCause = Status.UNAVAILABLE.withDescription("Connection closed while performing TLS negotiation").withCause(thCause).asRuntimeException();
                }
                channelHandlerContext.fireExceptionCaught(thCause);
                return;
            }
            SslHandler sslHandler = (SslHandler) channelHandlerContext.pipeline().get(SslHandler.class);
            if (this.sslContext.applicationProtocolNegotiator().protocols().contains(sslHandler.applicationProtocol())) {
                ProtocolNegotiators.logSslEngineDetails(Level.FINER, channelHandlerContext, "TLS negotiation succeeded.", null);
                propagateTlsComplete(channelHandlerContext, sslHandler.engine().getSession());
            } else {
                RuntimeException runtimeExceptionUnavailableException = ProtocolNegotiators.unavailableException("Failed ALPN negotiation: Unable to find compatible protocol");
                ProtocolNegotiators.logSslEngineDetails(Level.FINE, channelHandlerContext, "TLS negotiation failed.", runtimeExceptionUnavailableException);
                channelHandlerContext.fireExceptionCaught((Throwable) runtimeExceptionUnavailableException);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ClientTlsProtocolNegotiator implements ProtocolNegotiator {
        private Executor executor;
        private final ObjectPool<? extends Executor> executorPool;
        private final SslContext sslContext;

        public ClientTlsProtocolNegotiator(SslContext sslContext, ObjectPool<? extends Executor> objectPool) {
            this.sslContext = (SslContext) Preconditions.checkNotNull(sslContext, "sslContext");
            this.executorPool = objectPool;
            if (objectPool != null) {
                this.executor = objectPool.getObject();
            }
        }

        @Override // io.grpc.netty.ProtocolNegotiator
        public void close() {
            Executor executor;
            ObjectPool<? extends Executor> objectPool = this.executorPool;
            if (objectPool == null || (executor = this.executor) == null) {
                return;
            }
            objectPool.returnObject(executor);
        }

        @Override // io.grpc.netty.ProtocolNegotiator
        public ChannelHandler newHandler(GrpcHttp2ConnectionHandler grpcHttp2ConnectionHandler) {
            GrpcNegotiationHandler grpcNegotiationHandler = new GrpcNegotiationHandler(grpcHttp2ConnectionHandler);
            ChannelLogger negotiationLogger = grpcHttp2ConnectionHandler.getNegotiationLogger();
            return new WaitUntilActiveHandler(new ClientTlsHandler(grpcNegotiationHandler, this.sslContext, grpcHttp2ConnectionHandler.getAuthority(), this.executor, negotiationLogger), negotiationLogger);
        }

        @Override // io.grpc.netty.ProtocolNegotiator
        public AsciiString scheme() {
            return Utils.HTTPS;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class FixedProtocolNegotiatorServerFactory implements ProtocolNegotiator.ServerFactory {
        private final ProtocolNegotiator protocolNegotiator;

        public FixedProtocolNegotiatorServerFactory(ProtocolNegotiator protocolNegotiator) {
            this.protocolNegotiator = (ProtocolNegotiator) Preconditions.checkNotNull(protocolNegotiator, "protocolNegotiator");
        }

        @Override // io.grpc.netty.ProtocolNegotiator.ServerFactory
        public ProtocolNegotiator newNegotiator(ObjectPool<? extends Executor> objectPool) {
            return this.protocolNegotiator;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class FromChannelCredentialsResult {
        public final CallCredentials callCredentials;
        public final String error;
        public final ProtocolNegotiator.ClientFactory negotiator;

        private FromChannelCredentialsResult(ProtocolNegotiator.ClientFactory clientFactory, CallCredentials callCredentials, String str) {
            this.negotiator = clientFactory;
            this.callCredentials = callCredentials;
            this.error = str;
        }

        public static FromChannelCredentialsResult error(String str) {
            return new FromChannelCredentialsResult(null, null, (String) Preconditions.checkNotNull(str, "error"));
        }

        public static FromChannelCredentialsResult negotiator(ProtocolNegotiator.ClientFactory clientFactory) {
            return new FromChannelCredentialsResult((ProtocolNegotiator.ClientFactory) Preconditions.checkNotNull(clientFactory, "factory"), null, null);
        }

        public FromChannelCredentialsResult withCallCredentials(CallCredentials callCredentials) {
            Preconditions.checkNotNull(callCredentials, "callCreds");
            if (this.error != null) {
                return this;
            }
            CallCredentials callCredentials2 = this.callCredentials;
            if (callCredentials2 != null) {
                callCredentials = new CompositeCallCredentials(callCredentials2, callCredentials);
            }
            return new FromChannelCredentialsResult(this.negotiator, callCredentials, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class FromServerCredentialsResult {
        public final String error;
        public final ProtocolNegotiator.ServerFactory negotiator;

        private FromServerCredentialsResult(ProtocolNegotiator.ServerFactory serverFactory, String str) {
            this.negotiator = serverFactory;
            this.error = str;
        }

        public static FromServerCredentialsResult error(String str) {
            return new FromServerCredentialsResult(null, (String) Preconditions.checkNotNull(str, "error"));
        }

        public static FromServerCredentialsResult negotiator(ProtocolNegotiator.ServerFactory serverFactory) {
            return new FromServerCredentialsResult((ProtocolNegotiator.ServerFactory) Preconditions.checkNotNull(serverFactory, "factory"), null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class GrpcNegotiationHandler extends ChannelInboundHandlerAdapter {
        private final GrpcHttp2ConnectionHandler next;

        public GrpcNegotiationHandler(GrpcHttp2ConnectionHandler grpcHttp2ConnectionHandler) {
            this.next = (GrpcHttp2ConnectionHandler) Preconditions.checkNotNull(grpcHttp2ConnectionHandler, "next");
        }

        @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
        public void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object obj) {
            if (!(obj instanceof ProtocolNegotiationEvent)) {
                super.userEventTriggered(channelHandlerContext, obj);
                return;
            }
            ProtocolNegotiationEvent protocolNegotiationEvent = (ProtocolNegotiationEvent) obj;
            channelHandlerContext.pipeline().replace(channelHandlerContext.name(), (String) null, this.next);
            this.next.handleProtocolNegotiationCompleted(protocolNegotiationEvent.getAttributes(), protocolNegotiationEvent.getSecurity());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @VisibleForTesting
    public static final class HostPort {
        final String host;
        final int port;

        public HostPort(String str, int i) {
            this.host = str;
            this.port = i;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Http2UpgradeAndGrpcHandler extends ChannelInboundHandlerAdapter {
        private final String authority;
        private final ChannelLogger negotiationLogger;
        private final GrpcHttp2ConnectionHandler next;
        private ProtocolNegotiationEvent pne;

        public Http2UpgradeAndGrpcHandler(String str, GrpcHttp2ConnectionHandler grpcHttp2ConnectionHandler) {
            this.authority = (String) Preconditions.checkNotNull(str, "authority");
            this.next = (GrpcHttp2ConnectionHandler) Preconditions.checkNotNull(grpcHttp2ConnectionHandler, "next");
            this.negotiationLogger = grpcHttp2ConnectionHandler.getNegotiationLogger();
        }

        @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
        public void handlerAdded(ChannelHandlerContext channelHandlerContext) {
            this.negotiationLogger.log(ChannelLogger.ChannelLogLevel.INFO, "Http2Upgrade started");
            HttpClientCodec httpClientCodec = new HttpClientCodec();
            channelHandlerContext.pipeline().addBefore(channelHandlerContext.name(), null, httpClientCodec);
            channelHandlerContext.pipeline().addBefore(channelHandlerContext.name(), null, new HttpClientUpgradeHandler(httpClientCodec, new Http2ClientUpgradeCodec(this.next), 1000));
            DefaultHttpRequest defaultHttpRequest = new DefaultHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, "/");
            defaultHttpRequest.headers().add(HttpHeaderNames.HOST, this.authority);
            channelHandlerContext.writeAndFlush(defaultHttpRequest).addListener(ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
            super.handlerAdded(channelHandlerContext);
        }

        @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
        public void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object obj) {
            if (obj instanceof ProtocolNegotiationEvent) {
                Preconditions.checkState(this.pne == null, "negotiation already started");
                this.pne = (ProtocolNegotiationEvent) obj;
            } else {
                if (obj == HttpClientUpgradeHandler.UpgradeEvent.UPGRADE_SUCCESSFUL) {
                    Preconditions.checkState(this.pne != null, "negotiation not yet complete");
                    this.negotiationLogger.log(ChannelLogger.ChannelLogLevel.INFO, "Http2Upgrade finished");
                    channelHandlerContext.pipeline().remove(channelHandlerContext.name());
                    this.next.handleProtocolNegotiationCompleted(this.pne.getAttributes(), this.pne.getSecurity());
                    return;
                }
                if (obj == HttpClientUpgradeHandler.UpgradeEvent.UPGRADE_REJECTED) {
                    channelHandlerContext.fireExceptionCaught((Throwable) ProtocolNegotiators.unavailableException("HTTP/2 upgrade rejected"));
                } else {
                    super.userEventTriggered(channelHandlerContext, obj);
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class PlaintextProtocolNegotiator implements ProtocolNegotiator {
        @Override // io.grpc.netty.ProtocolNegotiator
        public void close() {
        }

        @Override // io.grpc.netty.ProtocolNegotiator
        public ChannelHandler newHandler(GrpcHttp2ConnectionHandler grpcHttp2ConnectionHandler) {
            return new WaitUntilActiveHandler(new GrpcNegotiationHandler(grpcHttp2ConnectionHandler), grpcHttp2ConnectionHandler.getNegotiationLogger());
        }

        @Override // io.grpc.netty.ProtocolNegotiator
        public AsciiString scheme() {
            return Utils.HTTP;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @VisibleForTesting
    public static final class PlaintextProtocolNegotiatorClientFactory implements ProtocolNegotiator.ClientFactory {
        @Override // io.grpc.netty.ProtocolNegotiator.ClientFactory
        public int getDefaultPort() {
            return 80;
        }

        @Override // io.grpc.netty.ProtocolNegotiator.ClientFactory
        public ProtocolNegotiator newNegotiator() {
            return ProtocolNegotiators.plaintext();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @VisibleForTesting
    public static final class PlaintextProtocolNegotiatorServerFactory implements ProtocolNegotiator.ServerFactory {
        @Override // io.grpc.netty.ProtocolNegotiator.ServerFactory
        public ProtocolNegotiator newNegotiator(ObjectPool<? extends Executor> objectPool) {
            return ProtocolNegotiators.serverPlaintext();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class PlaintextUpgradeProtocolNegotiator implements ProtocolNegotiator {
        @Override // io.grpc.netty.ProtocolNegotiator
        public void close() {
        }

        @Override // io.grpc.netty.ProtocolNegotiator
        public ChannelHandler newHandler(GrpcHttp2ConnectionHandler grpcHttp2ConnectionHandler) {
            return new WaitUntilActiveHandler(new Http2UpgradeAndGrpcHandler(grpcHttp2ConnectionHandler.getAuthority(), grpcHttp2ConnectionHandler), grpcHttp2ConnectionHandler.getNegotiationLogger());
        }

        @Override // io.grpc.netty.ProtocolNegotiator
        public AsciiString scheme() {
            return Utils.HTTP;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class PlaintextUpgradeProtocolNegotiatorClientFactory implements ProtocolNegotiator.ClientFactory {
        private PlaintextUpgradeProtocolNegotiatorClientFactory() {
        }

        @Override // io.grpc.netty.ProtocolNegotiator.ClientFactory
        public int getDefaultPort() {
            return 80;
        }

        @Override // io.grpc.netty.ProtocolNegotiator.ClientFactory
        public ProtocolNegotiator newNegotiator() {
            return ProtocolNegotiators.plaintextUpgrade();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ProxyProtocolNegotiationHandler extends ProtocolNegotiationHandler {
        private final SocketAddress address;

        @Nullable
        private final String password;

        @Nullable
        private final String userName;

        public ProxyProtocolNegotiationHandler(SocketAddress socketAddress, @Nullable String str, @Nullable String str2, ChannelHandler channelHandler, ChannelLogger channelLogger) {
            super(channelHandler, channelLogger);
            this.address = (SocketAddress) Preconditions.checkNotNull(socketAddress, "address");
            this.userName = str;
            this.password = str2;
        }

        @Override // io.grpc.netty.ProtocolNegotiators.ProtocolNegotiationHandler
        public void protocolNegotiationEventTriggered(ChannelHandlerContext channelHandlerContext) {
            channelHandlerContext.pipeline().addBefore(channelHandlerContext.name(), null, (this.userName == null || this.password == null) ? new HttpProxyHandler(this.address) : new HttpProxyHandler(this.address, this.userName, this.password));
        }

        @Override // io.grpc.netty.ProtocolNegotiators.ProtocolNegotiationHandler
        public void userEventTriggered0(ChannelHandlerContext channelHandlerContext, Object obj) {
            if (obj instanceof ProxyConnectionEvent) {
                fireProtocolNegotiationEvent(channelHandlerContext);
            } else {
                userEventTriggered(channelHandlerContext, obj);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ServerTlsHandler extends ChannelInboundHandlerAdapter {
        private Executor executor;
        private final ChannelHandler next;
        private ProtocolNegotiationEvent pne = ProtocolNegotiationEvent.DEFAULT;
        private final SslContext sslContext;

        public ServerTlsHandler(ChannelHandler channelHandler, SslContext sslContext, ObjectPool<? extends Executor> objectPool) {
            this.sslContext = (SslContext) Preconditions.checkNotNull(sslContext, "sslContext");
            this.next = (ChannelHandler) Preconditions.checkNotNull(channelHandler, "next");
            if (objectPool != null) {
                this.executor = objectPool.getObject();
            }
        }

        private void fireProtocolNegotiationEvent(ChannelHandlerContext channelHandlerContext, SSLSession sSLSession) {
            channelHandlerContext.fireUserEventTriggered((Object) this.pne.withAttributes(this.pne.getAttributes().toBuilder().set(GrpcAttributes.ATTR_SECURITY_LEVEL, SecurityLevel.PRIVACY_AND_INTEGRITY).set(Grpc.TRANSPORT_ATTR_SSL_SESSION, sSLSession).build()).withSecurity(new InternalChannelz.Security(new InternalChannelz.Tls(sSLSession))));
        }

        @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
        public void handlerAdded(ChannelHandlerContext channelHandlerContext) {
            super.handlerAdded(channelHandlerContext);
            SSLEngine sSLEngineNewEngine = this.sslContext.newEngine(channelHandlerContext.alloc());
            channelHandlerContext.pipeline().addBefore(channelHandlerContext.name(), null, this.executor != null ? new SslHandler(sSLEngineNewEngine, false, this.executor) : new SslHandler(sSLEngineNewEngine, false));
        }

        @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
        public void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object obj) {
            if (obj instanceof ProtocolNegotiationEvent) {
                this.pne = (ProtocolNegotiationEvent) obj;
                return;
            }
            if (!(obj instanceof SslHandshakeCompletionEvent)) {
                super.userEventTriggered(channelHandlerContext, obj);
                return;
            }
            SslHandshakeCompletionEvent sslHandshakeCompletionEvent = (SslHandshakeCompletionEvent) obj;
            if (!sslHandshakeCompletionEvent.isSuccess()) {
                ProtocolNegotiators.logSslEngineDetails(Level.FINE, channelHandlerContext, "TLS negotiation failed for new client.", null);
                channelHandlerContext.fireExceptionCaught(sslHandshakeCompletionEvent.cause());
                return;
            }
            SslHandler sslHandler = (SslHandler) channelHandlerContext.pipeline().get(SslHandler.class);
            if (this.sslContext.applicationProtocolNegotiator().protocols().contains(sslHandler.applicationProtocol())) {
                channelHandlerContext.pipeline().replace(channelHandlerContext.name(), (String) null, this.next);
                fireProtocolNegotiationEvent(channelHandlerContext, sslHandler.engine().getSession());
            } else {
                ProtocolNegotiators.logSslEngineDetails(Level.FINE, channelHandlerContext, "TLS negotiation failed for new client.", null);
                channelHandlerContext.fireExceptionCaught((Throwable) ProtocolNegotiators.unavailableException("Failed protocol negotiation: Unable to find compatible protocol"));
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @VisibleForTesting
    public static final class TlsProtocolNegotiatorClientFactory implements ProtocolNegotiator.ClientFactory {
        private final SslContext sslContext;

        public TlsProtocolNegotiatorClientFactory(SslContext sslContext) {
            this.sslContext = (SslContext) Preconditions.checkNotNull(sslContext, "sslContext");
        }

        @Override // io.grpc.netty.ProtocolNegotiator.ClientFactory
        public int getDefaultPort() {
            return GrpcUtil.DEFAULT_PORT_SSL;
        }

        @Override // io.grpc.netty.ProtocolNegotiator.ClientFactory
        public ProtocolNegotiator newNegotiator() {
            return ProtocolNegotiators.tls(this.sslContext);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @VisibleForTesting
    public static final class TlsProtocolNegotiatorServerFactory implements ProtocolNegotiator.ServerFactory {
        private final SslContext sslContext;

        public TlsProtocolNegotiatorServerFactory(SslContext sslContext) {
            this.sslContext = (SslContext) Preconditions.checkNotNull(sslContext, "sslContext");
        }

        @Override // io.grpc.netty.ProtocolNegotiator.ServerFactory
        public ProtocolNegotiator newNegotiator(ObjectPool<? extends Executor> objectPool) {
            return ProtocolNegotiators.serverTls(this.sslContext, objectPool);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class WaitUntilActiveHandler extends ProtocolNegotiationHandler {
        boolean protocolNegotiationEventReceived;

        public WaitUntilActiveHandler(ChannelHandler channelHandler, ChannelLogger channelLogger) {
            super(channelHandler, channelLogger);
        }

        private void replaceOnActive(ChannelHandlerContext channelHandlerContext) {
            ProtocolNegotiationEvent protocolNegotiationEvent = getProtocolNegotiationEvent();
            replaceProtocolNegotiationEvent(protocolNegotiationEvent.withAttributes(protocolNegotiationEvent.getAttributes().toBuilder().set(Grpc.TRANSPORT_ATTR_LOCAL_ADDR, channelHandlerContext.channel().localAddress()).set(Grpc.TRANSPORT_ATTR_REMOTE_ADDR, channelHandlerContext.channel().remoteAddress()).set(GrpcAttributes.ATTR_SECURITY_LEVEL, SecurityLevel.NONE).build()));
        }

        @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
        public void channelActive(ChannelHandlerContext channelHandlerContext) {
            if (this.protocolNegotiationEventReceived) {
                replaceOnActive(channelHandlerContext);
                fireProtocolNegotiationEvent(channelHandlerContext);
            }
            super.channelActive(channelHandlerContext);
        }

        @Override // io.grpc.netty.ProtocolNegotiators.ProtocolNegotiationHandler
        public void protocolNegotiationEventTriggered(ChannelHandlerContext channelHandlerContext) {
            this.protocolNegotiationEventReceived = true;
            if (channelHandlerContext.channel().isActive()) {
                replaceOnActive(channelHandlerContext);
                fireProtocolNegotiationEvent(channelHandlerContext);
            }
        }
    }

    private ProtocolNegotiators() {
    }

    public static ProtocolNegotiator.ServerFactory fixedServerFactory(ProtocolNegotiator protocolNegotiator) {
        return new FixedProtocolNegotiatorServerFactory(protocolNegotiator);
    }

    public static FromChannelCredentialsResult from(ChannelCredentials channelCredentials) {
        if (!(channelCredentials instanceof TlsChannelCredentials)) {
            if (channelCredentials instanceof InsecureChannelCredentials) {
                return FromChannelCredentialsResult.negotiator(plaintextClientFactory());
            }
            if (channelCredentials instanceof CompositeChannelCredentials) {
                CompositeChannelCredentials compositeChannelCredentials = (CompositeChannelCredentials) channelCredentials;
                return from(compositeChannelCredentials.getChannelCredentials()).withCallCredentials(compositeChannelCredentials.getCallCredentials());
            }
            if (channelCredentials instanceof NettyChannelCredentials) {
                return FromChannelCredentialsResult.negotiator(((NettyChannelCredentials) channelCredentials).getNegotiator());
            }
            if (!(channelCredentials instanceof ChoiceChannelCredentials)) {
                return FromChannelCredentialsResult.error("Unsupported credential type: ".concat(channelCredentials.getClass().getName()));
            }
            StringBuilder sb = new StringBuilder();
            Iterator<ChannelCredentials> it = ((ChoiceChannelCredentials) channelCredentials).getCredentialsList().iterator();
            while (it.hasNext()) {
                FromChannelCredentialsResult fromChannelCredentialsResultFrom = from(it.next());
                if (fromChannelCredentialsResultFrom.error == null) {
                    return fromChannelCredentialsResultFrom;
                }
                sb.append(SQLKeyword.COMMA);
                sb.append(fromChannelCredentialsResultFrom.error);
            }
            return FromChannelCredentialsResult.error(sb.substring(2));
        }
        TlsChannelCredentials tlsChannelCredentials = (TlsChannelCredentials) channelCredentials;
        Set<TlsChannelCredentials.Feature> setIncomprehensible = tlsChannelCredentials.incomprehensible(understoodTlsFeatures);
        if (!setIncomprehensible.isEmpty()) {
            return FromChannelCredentialsResult.error("TLS features not understood: " + setIncomprehensible);
        }
        SslContextBuilder sslContextBuilderForClient = GrpcSslContexts.forClient();
        if (tlsChannelCredentials.getKeyManagers() != null) {
            sslContextBuilderForClient.keyManager(new FixedKeyManagerFactory(tlsChannelCredentials.getKeyManagers()));
        } else if (tlsChannelCredentials.getPrivateKey() != null) {
            sslContextBuilderForClient.keyManager(new ByteArrayInputStream(tlsChannelCredentials.getCertificateChain()), new ByteArrayInputStream(tlsChannelCredentials.getPrivateKey()), tlsChannelCredentials.getPrivateKeyPassword());
        }
        if (tlsChannelCredentials.getTrustManagers() != null) {
            sslContextBuilderForClient.trustManager(new FixedTrustManagerFactory(tlsChannelCredentials.getTrustManagers()));
        } else if (tlsChannelCredentials.getRootCertificates() != null) {
            sslContextBuilderForClient.trustManager(new ByteArrayInputStream(tlsChannelCredentials.getRootCertificates()));
        }
        try {
            return FromChannelCredentialsResult.negotiator(tlsClientFactory(sslContextBuilderForClient.build()));
        } catch (SSLException e) {
            log.log(Level.FINE, "Exception building SslContext", (Throwable) e);
            return FromChannelCredentialsResult.error("Unable to create SslContext: " + e.getMessage());
        }
    }

    public static ProtocolNegotiator httpProxy(final SocketAddress socketAddress, @Nullable final String str, @Nullable final String str2, final ProtocolNegotiator protocolNegotiator) {
        Preconditions.checkNotNull(protocolNegotiator, "negotiator");
        Preconditions.checkNotNull(socketAddress, "proxyAddress");
        final AsciiString asciiStringScheme = protocolNegotiator.scheme();
        return new ProtocolNegotiator() { // from class: io.grpc.netty.ProtocolNegotiators.1ProxyNegotiator
            @Override // io.grpc.netty.ProtocolNegotiator
            public void close() {
                protocolNegotiator.close();
            }

            @Override // io.grpc.netty.ProtocolNegotiator
            public ChannelHandler newHandler(GrpcHttp2ConnectionHandler grpcHttp2ConnectionHandler) {
                return new ProxyProtocolNegotiationHandler(socketAddress, str, str2, protocolNegotiator.newHandler(grpcHttp2ConnectionHandler), grpcHttp2ConnectionHandler.getNegotiationLogger());
            }

            @Override // io.grpc.netty.ProtocolNegotiator
            public AsciiString scheme() {
                return asciiStringScheme;
            }
        };
    }

    @VisibleForTesting
    public static void logSslEngineDetails(Level level, ChannelHandlerContext channelHandlerContext, String str, @Nullable Throwable th) {
        Logger logger = log;
        if (logger.isLoggable(level)) {
            SslHandler sslHandler = (SslHandler) channelHandlerContext.pipeline().get(SslHandler.class);
            SSLEngine sSLEngineEngine = sslHandler.engine();
            StringBuilder sbM12325j = AbstractC11014a.m12325j(str, "\nSSLEngine Details: [\n");
            if (sSLEngineEngine instanceof OpenSslEngine) {
                sbM12325j.append("    OpenSSL, Version: 0x");
                sbM12325j.append(Integer.toHexString(OpenSsl.version()));
                sbM12325j.append(" (");
                sbM12325j.append(OpenSsl.versionString());
                sbM12325j.append("), ALPN supported: ");
                sbM12325j.append(SslProvider.isAlpnSupported(SslProvider.OPENSSL));
            } else if (JettyTlsUtil.isJettyAlpnConfigured()) {
                sbM12325j.append("    Jetty ALPN");
            } else if (JettyTlsUtil.isJettyNpnConfigured()) {
                sbM12325j.append("    Jetty NPN");
            } else if (JettyTlsUtil.isJava9AlpnAvailable()) {
                sbM12325j.append("    JDK9 ALPN");
            }
            sbM12325j.append("\n    TLS Protocol: ");
            sbM12325j.append(sSLEngineEngine.getSession().getProtocol());
            sbM12325j.append("\n    Application Protocol: ");
            sbM12325j.append(sslHandler.applicationProtocol());
            sbM12325j.append("\n    Need Client Auth: ");
            sbM12325j.append(sSLEngineEngine.getNeedClientAuth());
            sbM12325j.append("\n    Want Client Auth: ");
            sbM12325j.append(sSLEngineEngine.getWantClientAuth());
            sbM12325j.append("\n    Supported protocols=");
            sbM12325j.append(Arrays.toString(sSLEngineEngine.getSupportedProtocols()));
            sbM12325j.append("\n    Enabled protocols=");
            sbM12325j.append(Arrays.toString(sSLEngineEngine.getEnabledProtocols()));
            sbM12325j.append("\n    Supported ciphers=");
            sbM12325j.append(Arrays.toString(sSLEngineEngine.getSupportedCipherSuites()));
            sbM12325j.append("\n    Enabled ciphers=");
            sbM12325j.append(Arrays.toString(sSLEngineEngine.getEnabledCipherSuites()));
            sbM12325j.append("\n]");
            logger.log(level, sbM12325j.toString(), th);
        }
    }

    @VisibleForTesting
    public static HostPort parseAuthority(String str) {
        int port;
        URI uriAuthorityToUri = GrpcUtil.authorityToUri((String) Preconditions.checkNotNull(str, "authority"));
        if (uriAuthorityToUri.getHost() != null) {
            str = uriAuthorityToUri.getHost();
            port = uriAuthorityToUri.getPort();
        } else {
            port = -1;
        }
        return new HostPort(str, port);
    }

    public static ProtocolNegotiator plaintext() {
        return new PlaintextProtocolNegotiator();
    }

    public static ProtocolNegotiator.ClientFactory plaintextClientFactory() {
        return new PlaintextProtocolNegotiatorClientFactory();
    }

    public static ProtocolNegotiator plaintextUpgrade() {
        return new PlaintextUpgradeProtocolNegotiator();
    }

    public static ProtocolNegotiator.ClientFactory plaintextUpgradeClientFactory() {
        return new PlaintextUpgradeProtocolNegotiatorClientFactory();
    }

    public static ProtocolNegotiator serverPlaintext() {
        return new PlaintextProtocolNegotiator();
    }

    public static ProtocolNegotiator.ServerFactory serverPlaintextFactory() {
        return new PlaintextProtocolNegotiatorServerFactory();
    }

    public static ProtocolNegotiator serverTls(final SslContext sslContext, final ObjectPool<? extends Executor> objectPool) {
        Preconditions.checkNotNull(sslContext, "sslContext");
        final Executor object = objectPool != null ? objectPool.getObject() : null;
        return new ProtocolNegotiator() { // from class: io.grpc.netty.ProtocolNegotiators.1
            @Override // io.grpc.netty.ProtocolNegotiator
            public void close() {
                Executor executor;
                ObjectPool objectPool2 = objectPool;
                if (objectPool2 == null || (executor = object) == null) {
                    return;
                }
                objectPool2.returnObject(executor);
            }

            @Override // io.grpc.netty.ProtocolNegotiator
            public ChannelHandler newHandler(GrpcHttp2ConnectionHandler grpcHttp2ConnectionHandler) {
                return new WaitUntilActiveHandler(new ServerTlsHandler(new GrpcNegotiationHandler(grpcHttp2ConnectionHandler), sslContext, objectPool), grpcHttp2ConnectionHandler.getNegotiationLogger());
            }

            @Override // io.grpc.netty.ProtocolNegotiator
            public AsciiString scheme() {
                return Utils.HTTPS;
            }
        };
    }

    public static ProtocolNegotiator.ServerFactory serverTlsFactory(SslContext sslContext) {
        return new TlsProtocolNegotiatorServerFactory(sslContext);
    }

    public static ProtocolNegotiator tls(SslContext sslContext, ObjectPool<? extends Executor> objectPool) {
        return new ClientTlsProtocolNegotiator(sslContext, objectPool);
    }

    public static ProtocolNegotiator.ClientFactory tlsClientFactory(SslContext sslContext) {
        return new TlsProtocolNegotiatorClientFactory(sslContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static RuntimeException unavailableException(String str) {
        return Status.UNAVAILABLE.withDescription(str).asRuntimeException();
    }

    public static ProtocolNegotiator tls(SslContext sslContext) {
        return tls(sslContext, null);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ProtocolNegotiationHandler extends ChannelDuplexHandler {
        private final ChannelLogger negotiationLogger;
        private final String negotiatorName;
        private final ChannelHandler next;
        private ProtocolNegotiationEvent pne;

        public ProtocolNegotiationHandler(ChannelHandler channelHandler, String str, ChannelLogger channelLogger) {
            this.next = (ChannelHandler) Preconditions.checkNotNull(channelHandler, "next");
            this.negotiatorName = str;
            this.negotiationLogger = (ChannelLogger) Preconditions.checkNotNull(channelLogger, "negotiationLogger");
        }

        public final void fireProtocolNegotiationEvent(ChannelHandlerContext channelHandlerContext) {
            Preconditions.checkState(this.pne != null, "previous protocol negotiation event hasn't triggered");
            this.negotiationLogger.log(ChannelLogger.ChannelLogLevel.INFO, "{0} completed", this.negotiatorName);
            channelHandlerContext.pipeline().replace(channelHandlerContext.name(), (String) null, this.next);
            channelHandlerContext.fireUserEventTriggered((Object) this.pne);
        }

        public final ProtocolNegotiationEvent getProtocolNegotiationEvent() {
            Preconditions.checkState(this.pne != null, "previous protocol negotiation event hasn't triggered");
            return this.pne;
        }

        @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
        public final void handlerAdded(ChannelHandlerContext channelHandlerContext) {
            this.negotiationLogger.log(ChannelLogger.ChannelLogLevel.DEBUG, "{0} started", this.negotiatorName);
            handlerAdded0(channelHandlerContext);
        }

        @ForOverride
        public void handlerAdded0(ChannelHandlerContext channelHandlerContext) {
            super.handlerAdded(channelHandlerContext);
        }

        @ForOverride
        public void protocolNegotiationEventTriggered(ChannelHandlerContext channelHandlerContext) {
        }

        public final void replaceProtocolNegotiationEvent(ProtocolNegotiationEvent protocolNegotiationEvent) {
            Preconditions.checkState(this.pne != null, "previous protocol negotiation event hasn't triggered");
            this.pne = (ProtocolNegotiationEvent) Preconditions.checkNotNull(protocolNegotiationEvent);
        }

        @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
        public final void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object obj) {
            if (!(obj instanceof ProtocolNegotiationEvent)) {
                userEventTriggered0(channelHandlerContext, obj);
                return;
            }
            ProtocolNegotiationEvent protocolNegotiationEvent = this.pne;
            Preconditions.checkState(protocolNegotiationEvent == null, "pre-existing negotiation: %s < %s", protocolNegotiationEvent, obj);
            this.pne = (ProtocolNegotiationEvent) obj;
            protocolNegotiationEventTriggered(channelHandlerContext);
        }

        public void userEventTriggered0(ChannelHandlerContext channelHandlerContext, Object obj) {
            super.userEventTriggered(channelHandlerContext, obj);
        }

        public ProtocolNegotiationHandler(ChannelHandler channelHandler, ChannelLogger channelLogger) {
            this.next = (ChannelHandler) Preconditions.checkNotNull(channelHandler, "next");
            this.negotiatorName = getClass().getSimpleName().replace("Handler", "");
            this.negotiationLogger = (ChannelLogger) Preconditions.checkNotNull(channelLogger, "negotiationLogger");
        }
    }

    public static ProtocolNegotiator serverTls(SslContext sslContext) {
        return serverTls(sslContext, null);
    }

    public static FromServerCredentialsResult from(ServerCredentials serverCredentials) {
        SslContextBuilder sslContextBuilderForServer;
        if (serverCredentials instanceof TlsServerCredentials) {
            TlsServerCredentials tlsServerCredentials = (TlsServerCredentials) serverCredentials;
            Set<TlsServerCredentials.Feature> setIncomprehensible = tlsServerCredentials.incomprehensible(understoodServerTlsFeatures);
            if (!setIncomprehensible.isEmpty()) {
                return FromServerCredentialsResult.error("TLS features not understood: " + setIncomprehensible);
            }
            if (tlsServerCredentials.getKeyManagers() != null) {
                sslContextBuilderForServer = GrpcSslContexts.configure(SslContextBuilder.forServer(new FixedKeyManagerFactory(tlsServerCredentials.getKeyManagers())));
            } else if (tlsServerCredentials.getPrivateKey() != null) {
                sslContextBuilderForServer = GrpcSslContexts.forServer(new ByteArrayInputStream(tlsServerCredentials.getCertificateChain()), new ByteArrayInputStream(tlsServerCredentials.getPrivateKey()), tlsServerCredentials.getPrivateKeyPassword());
            } else {
                throw new AssertionError("BUG! No key");
            }
            if (tlsServerCredentials.getTrustManagers() != null) {
                sslContextBuilderForServer.trustManager(new FixedTrustManagerFactory(tlsServerCredentials.getTrustManagers()));
            } else if (tlsServerCredentials.getRootCertificates() != null) {
                sslContextBuilderForServer.trustManager(new ByteArrayInputStream(tlsServerCredentials.getRootCertificates()));
            }
            int i = C122722.$SwitchMap$io$grpc$TlsServerCredentials$ClientAuth[tlsServerCredentials.getClientAuth().ordinal()];
            if (i == 1) {
                sslContextBuilderForServer.clientAuth(ClientAuth.OPTIONAL);
            } else if (i == 2) {
                sslContextBuilderForServer.clientAuth(ClientAuth.REQUIRE);
            } else {
                if (i != 3) {
                    return FromServerCredentialsResult.error("Unknown TlsServerCredentials.ClientAuth value: " + tlsServerCredentials.getClientAuth());
                }
                sslContextBuilderForServer.clientAuth(ClientAuth.NONE);
            }
            try {
                return FromServerCredentialsResult.negotiator(serverTlsFactory(sslContextBuilderForServer.build()));
            } catch (SSLException e) {
                throw new IllegalArgumentException("Unexpected error converting ServerCredentials to Netty SslContext", e);
            }
        }
        if (serverCredentials instanceof InsecureServerCredentials) {
            return FromServerCredentialsResult.negotiator(serverPlaintextFactory());
        }
        if (serverCredentials instanceof NettyServerCredentials) {
            return FromServerCredentialsResult.negotiator(((NettyServerCredentials) serverCredentials).getNegotiator());
        }
        if (serverCredentials instanceof ChoiceServerCredentials) {
            StringBuilder sb = new StringBuilder();
            Iterator<ServerCredentials> it = ((ChoiceServerCredentials) serverCredentials).getCredentialsList().iterator();
            while (it.hasNext()) {
                FromServerCredentialsResult fromServerCredentialsResultFrom = from(it.next());
                if (fromServerCredentialsResultFrom.error == null) {
                    return fromServerCredentialsResultFrom;
                }
                sb.append(SQLKeyword.COMMA);
                sb.append(fromServerCredentialsResultFrom.error);
            }
            return FromServerCredentialsResult.error(sb.substring(2));
        }
        return FromServerCredentialsResult.error("Unsupported credential type: ".concat(serverCredentials.getClass().getName()));
    }
}
