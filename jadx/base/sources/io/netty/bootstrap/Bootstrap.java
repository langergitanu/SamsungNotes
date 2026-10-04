package io.netty.bootstrap;

import io.netty.bootstrap.AbstractBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelPromise;
import io.netty.channel.EventLoopGroup;
import io.netty.resolver.AddressResolver;
import io.netty.resolver.AddressResolverGroup;
import io.netty.resolver.DefaultAddressResolverGroup;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class Bootstrap extends AbstractBootstrap<Bootstrap, Channel> {
    private final BootstrapConfig config;
    private volatile SocketAddress remoteAddress;
    private volatile AddressResolverGroup<SocketAddress> resolver;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) Bootstrap.class);
    private static final AddressResolverGroup<?> DEFAULT_RESOLVER = DefaultAddressResolverGroup.INSTANCE;

    public Bootstrap() {
        this.config = new BootstrapConfig(this);
        this.resolver = DEFAULT_RESOLVER;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void doConnect(final SocketAddress socketAddress, final SocketAddress socketAddress2, final ChannelPromise channelPromise) {
        final Channel channel = channelPromise.channel();
        channel.eventLoop().execute(new Runnable() { // from class: io.netty.bootstrap.Bootstrap.3
            @Override // java.lang.Runnable
            public void run() {
                SocketAddress socketAddress3 = socketAddress2;
                if (socketAddress3 == null) {
                    channel.connect(socketAddress, channelPromise);
                } else {
                    channel.connect(socketAddress, socketAddress3, channelPromise);
                }
                channelPromise.addListener((GenericFutureListener<? extends Future<? super Void>>) ChannelFutureListener.CLOSE_ON_FAILURE);
            }
        });
    }

    private ChannelFuture doResolveAndConnect(final SocketAddress socketAddress, final SocketAddress socketAddress2) {
        ChannelFuture channelFutureInitAndRegister = initAndRegister();
        final Channel channel = channelFutureInitAndRegister.channel();
        if (channelFutureInitAndRegister.isDone()) {
            return !channelFutureInitAndRegister.isSuccess() ? channelFutureInitAndRegister : doResolveAndConnect0(channel, socketAddress, socketAddress2, channel.newPromise());
        }
        final AbstractBootstrap.PendingRegistrationPromise pendingRegistrationPromise = new AbstractBootstrap.PendingRegistrationPromise(channel);
        channelFutureInitAndRegister.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.bootstrap.Bootstrap.1
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(ChannelFuture channelFuture) {
                Throwable thCause = channelFuture.cause();
                if (thCause != null) {
                    pendingRegistrationPromise.setFailure(thCause);
                } else {
                    pendingRegistrationPromise.registered();
                    Bootstrap.this.doResolveAndConnect0(channel, socketAddress, socketAddress2, pendingRegistrationPromise);
                }
            }
        });
        return pendingRegistrationPromise;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ChannelFuture doResolveAndConnect0(final Channel channel, SocketAddress socketAddress, final SocketAddress socketAddress2, final ChannelPromise channelPromise) {
        try {
            try {
                AddressResolver<T> resolver = this.resolver.getResolver(channel.eventLoop());
                if (resolver.isSupported(socketAddress) && !resolver.isResolved(socketAddress)) {
                    Future futureResolve = resolver.resolve(socketAddress);
                    if (!futureResolve.isDone()) {
                        futureResolve.addListener(new FutureListener<SocketAddress>() { // from class: io.netty.bootstrap.Bootstrap.2
                            @Override // io.netty.util.concurrent.GenericFutureListener
                            public void operationComplete(Future<SocketAddress> future) {
                                if (future.cause() == null) {
                                    Bootstrap.doConnect(future.getNow(), socketAddress2, channelPromise);
                                } else {
                                    channel.close();
                                    channelPromise.setFailure(future.cause());
                                }
                            }
                        });
                        return channelPromise;
                    }
                    Throwable thCause = futureResolve.cause();
                    if (thCause == null) {
                        doConnect((SocketAddress) futureResolve.getNow(), socketAddress2, channelPromise);
                        return channelPromise;
                    }
                    channel.close();
                    channelPromise.setFailure(thCause);
                    return channelPromise;
                }
                doConnect(socketAddress, socketAddress2, channelPromise);
                return channelPromise;
            } catch (Throwable th) {
                channel.close();
                return channelPromise.setFailure(th);
            }
        } catch (Throwable th2) {
            channelPromise.tryFailure(th2);
            return channelPromise;
        }
    }

    public ChannelFuture connect() {
        validate();
        SocketAddress socketAddress = this.remoteAddress;
        if (socketAddress != null) {
            return doResolveAndConnect(socketAddress, this.config.localAddress());
        }
        throw new IllegalStateException("remoteAddress not set");
    }

    @Override // io.netty.bootstrap.AbstractBootstrap
    public void init(Channel channel) {
        channel.pipeline().addLast(this.config.handler());
        AbstractBootstrap.setChannelOptions(channel, newOptionsArray(), logger);
        AbstractBootstrap.setAttributes(channel, newAttributesArray());
    }

    public Bootstrap remoteAddress(SocketAddress socketAddress) {
        this.remoteAddress = socketAddress;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Bootstrap resolver(AddressResolverGroup<?> addressResolverGroup) {
        AddressResolverGroup addressResolverGroup2 = addressResolverGroup;
        if (addressResolverGroup == null) {
            addressResolverGroup2 = DEFAULT_RESOLVER;
        }
        this.resolver = addressResolverGroup2;
        return this;
    }

    @Override // io.netty.bootstrap.AbstractBootstrap
    public final BootstrapConfig config() {
        return this.config;
    }

    public Bootstrap remoteAddress(String str, int i) {
        this.remoteAddress = InetSocketAddress.createUnresolved(str, i);
        return this;
    }

    public final AddressResolverGroup<?> resolver() {
        return this.resolver;
    }

    @Override // io.netty.bootstrap.AbstractBootstrap
    public Bootstrap validate() {
        super.validate();
        if (this.config.handler() != null) {
            return this;
        }
        throw new IllegalStateException("handler not set");
    }

    @Override // io.netty.bootstrap.AbstractBootstrap
    /* JADX INFO: renamed from: clone */
    public Bootstrap mo22210clone() {
        return new Bootstrap(this);
    }

    public Bootstrap remoteAddress(InetAddress inetAddress, int i) {
        this.remoteAddress = new InetSocketAddress(inetAddress, i);
        return this;
    }

    private Bootstrap(Bootstrap bootstrap) {
        super(bootstrap);
        this.config = new BootstrapConfig(this);
        this.resolver = DEFAULT_RESOLVER;
        this.resolver = bootstrap.resolver;
        this.remoteAddress = bootstrap.remoteAddress;
    }

    public Bootstrap clone(EventLoopGroup eventLoopGroup) {
        Bootstrap bootstrap = new Bootstrap(this);
        bootstrap.group = eventLoopGroup;
        return bootstrap;
    }

    public final SocketAddress remoteAddress() {
        return this.remoteAddress;
    }

    public ChannelFuture connect(String str, int i) {
        return connect(InetSocketAddress.createUnresolved(str, i));
    }

    public ChannelFuture connect(InetAddress inetAddress, int i) {
        return connect(new InetSocketAddress(inetAddress, i));
    }

    public ChannelFuture connect(SocketAddress socketAddress) {
        ObjectUtil.checkNotNull(socketAddress, "remoteAddress");
        validate();
        return doResolveAndConnect(socketAddress, this.config.localAddress());
    }

    public ChannelFuture connect(SocketAddress socketAddress, SocketAddress socketAddress2) {
        ObjectUtil.checkNotNull(socketAddress, "remoteAddress");
        validate();
        return doResolveAndConnect(socketAddress, socketAddress2);
    }
}
