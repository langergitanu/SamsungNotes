package io.netty.handler.proxy;

import androidx.collection.AbstractC0622a;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.socksx.p190v5.DefaultSocks5CommandRequest;
import io.netty.handler.codec.socksx.p190v5.DefaultSocks5InitialRequest;
import io.netty.handler.codec.socksx.p190v5.DefaultSocks5PasswordAuthRequest;
import io.netty.handler.codec.socksx.p190v5.Socks5AddressType;
import io.netty.handler.codec.socksx.p190v5.Socks5AuthMethod;
import io.netty.handler.codec.socksx.p190v5.Socks5ClientEncoder;
import io.netty.handler.codec.socksx.p190v5.Socks5CommandResponse;
import io.netty.handler.codec.socksx.p190v5.Socks5CommandResponseDecoder;
import io.netty.handler.codec.socksx.p190v5.Socks5CommandStatus;
import io.netty.handler.codec.socksx.p190v5.Socks5CommandType;
import io.netty.handler.codec.socksx.p190v5.Socks5InitialRequest;
import io.netty.handler.codec.socksx.p190v5.Socks5InitialResponse;
import io.netty.handler.codec.socksx.p190v5.Socks5InitialResponseDecoder;
import io.netty.handler.codec.socksx.p190v5.Socks5PasswordAuthResponse;
import io.netty.handler.codec.socksx.p190v5.Socks5PasswordAuthResponseDecoder;
import io.netty.handler.codec.socksx.p190v5.Socks5PasswordAuthStatus;
import io.netty.util.NetUtil;
import io.netty.util.internal.StringUtil;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class Socks5ProxyHandler extends ProxyHandler {
    private static final String AUTH_PASSWORD = "password";
    private static final Socks5InitialRequest INIT_REQUEST_NO_AUTH;
    private static final Socks5InitialRequest INIT_REQUEST_PASSWORD;
    private static final String PROTOCOL = "socks5";
    private String decoderName;
    private String encoderName;
    private final String password;
    private final String username;

    static {
        Socks5AuthMethod socks5AuthMethod = Socks5AuthMethod.NO_AUTH;
        INIT_REQUEST_NO_AUTH = new DefaultSocks5InitialRequest(Collections.singletonList(socks5AuthMethod));
        INIT_REQUEST_PASSWORD = new DefaultSocks5InitialRequest(Arrays.asList(socks5AuthMethod, Socks5AuthMethod.PASSWORD));
    }

    public Socks5ProxyHandler(SocketAddress socketAddress) {
        this(socketAddress, null, null);
    }

    private void sendConnectCommand(ChannelHandlerContext channelHandlerContext) throws ProxyConnectException {
        String hostAddress;
        Socks5AddressType socks5AddressType;
        InetSocketAddress inetSocketAddress = (InetSocketAddress) destinationAddress();
        if (inetSocketAddress.isUnresolved()) {
            socks5AddressType = Socks5AddressType.DOMAIN;
            hostAddress = inetSocketAddress.getHostString();
        } else {
            hostAddress = inetSocketAddress.getAddress().getHostAddress();
            if (NetUtil.isValidIpV4Address(hostAddress)) {
                socks5AddressType = Socks5AddressType.IPv4;
            } else {
                if (!NetUtil.isValidIpV6Address(hostAddress)) {
                    throw new ProxyConnectException(exceptionMessage("unknown address type: " + StringUtil.simpleClassName(hostAddress)));
                }
                socks5AddressType = Socks5AddressType.IPv6;
            }
        }
        ChannelPipeline channelPipelinePipeline = channelHandlerContext.pipeline();
        String str = this.decoderName;
        channelPipelinePipeline.replace(str, str, new Socks5CommandResponseDecoder());
        sendToProxyServer(new DefaultSocks5CommandRequest(Socks5CommandType.CONNECT, socks5AddressType, hostAddress, inetSocketAddress.getPort()));
    }

    private Socks5AuthMethod socksAuthMethod() {
        return (this.username == null && this.password == null) ? Socks5AuthMethod.NO_AUTH : Socks5AuthMethod.PASSWORD;
    }

    @Override // io.netty.handler.proxy.ProxyHandler
    public void addCodec(ChannelHandlerContext channelHandlerContext) {
        ChannelPipeline channelPipelinePipeline = channelHandlerContext.pipeline();
        String strName = channelHandlerContext.name();
        Socks5InitialResponseDecoder socks5InitialResponseDecoder = new Socks5InitialResponseDecoder();
        channelPipelinePipeline.addBefore(strName, null, socks5InitialResponseDecoder);
        this.decoderName = channelPipelinePipeline.context(socks5InitialResponseDecoder).name();
        String strM1170p = AbstractC0622a.m1170p(this.decoderName, ".encoder", new StringBuilder());
        this.encoderName = strM1170p;
        channelPipelinePipeline.addBefore(strName, strM1170p, Socks5ClientEncoder.DEFAULT);
    }

    @Override // io.netty.handler.proxy.ProxyHandler
    public String authScheme() {
        return socksAuthMethod() == Socks5AuthMethod.PASSWORD ? "password" : "none";
    }

    @Override // io.netty.handler.proxy.ProxyHandler
    public boolean handleResponse(ChannelHandlerContext channelHandlerContext, Object obj) throws ProxyConnectException {
        if (!(obj instanceof Socks5InitialResponse)) {
            if (!(obj instanceof Socks5PasswordAuthResponse)) {
                Socks5CommandResponse socks5CommandResponse = (Socks5CommandResponse) obj;
                if (socks5CommandResponse.status() == Socks5CommandStatus.SUCCESS) {
                    return true;
                }
                throw new ProxyConnectException(exceptionMessage("status: " + socks5CommandResponse.status()));
            }
            Socks5PasswordAuthResponse socks5PasswordAuthResponse = (Socks5PasswordAuthResponse) obj;
            if (socks5PasswordAuthResponse.status() == Socks5PasswordAuthStatus.SUCCESS) {
                sendConnectCommand(channelHandlerContext);
                return false;
            }
            throw new ProxyConnectException(exceptionMessage("authStatus: " + socks5PasswordAuthResponse.status()));
        }
        Socks5InitialResponse socks5InitialResponse = (Socks5InitialResponse) obj;
        Socks5AuthMethod socks5AuthMethodSocksAuthMethod = socksAuthMethod();
        Socks5AuthMethod socks5AuthMethodAuthMethod = socks5InitialResponse.authMethod();
        Socks5AuthMethod socks5AuthMethod = Socks5AuthMethod.NO_AUTH;
        if (socks5AuthMethodAuthMethod != socks5AuthMethod && socks5AuthMethodAuthMethod != socks5AuthMethodSocksAuthMethod) {
            throw new ProxyConnectException(exceptionMessage("unexpected authMethod: " + socks5InitialResponse.authMethod()));
        }
        if (socks5AuthMethodAuthMethod == socks5AuthMethod) {
            sendConnectCommand(channelHandlerContext);
        } else {
            if (socks5AuthMethodAuthMethod != Socks5AuthMethod.PASSWORD) {
                throw new Error();
            }
            ChannelPipeline channelPipelinePipeline = channelHandlerContext.pipeline();
            String str = this.decoderName;
            channelPipelinePipeline.replace(str, str, new Socks5PasswordAuthResponseDecoder());
            String str2 = this.username;
            if (str2 == null) {
                str2 = "";
            }
            String str3 = this.password;
            sendToProxyServer(new DefaultSocks5PasswordAuthRequest(str2, str3 != null ? str3 : ""));
        }
        return false;
    }

    @Override // io.netty.handler.proxy.ProxyHandler
    public Object newInitialMessage(ChannelHandlerContext channelHandlerContext) {
        return socksAuthMethod() == Socks5AuthMethod.PASSWORD ? INIT_REQUEST_PASSWORD : INIT_REQUEST_NO_AUTH;
    }

    public String password() {
        return this.password;
    }

    @Override // io.netty.handler.proxy.ProxyHandler
    public String protocol() {
        return PROTOCOL;
    }

    @Override // io.netty.handler.proxy.ProxyHandler
    public void removeDecoder(ChannelHandlerContext channelHandlerContext) {
        ChannelPipeline channelPipelinePipeline = channelHandlerContext.pipeline();
        if (channelPipelinePipeline.context(this.decoderName) != null) {
            channelPipelinePipeline.remove(this.decoderName);
        }
    }

    @Override // io.netty.handler.proxy.ProxyHandler
    public void removeEncoder(ChannelHandlerContext channelHandlerContext) {
        channelHandlerContext.pipeline().remove(this.encoderName);
    }

    public String username() {
        return this.username;
    }

    public Socks5ProxyHandler(SocketAddress socketAddress, String str, String str2) {
        super(socketAddress);
        if (str != null && str.isEmpty()) {
            str = null;
        }
        if (str2 != null && str2.isEmpty()) {
            str2 = null;
        }
        this.username = str;
        this.password = str2;
    }
}
