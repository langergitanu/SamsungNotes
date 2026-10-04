package io.netty.bootstrap;

import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import io.netty.bootstrap.AbstractBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.util.AttributeKey;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.net.SocketAddress;
import java.util.Map;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public abstract class AbstractBootstrapConfig<B extends AbstractBootstrap<B, C>, C extends Channel> {
    protected final B bootstrap;

    public AbstractBootstrapConfig(B b) {
        this.bootstrap = (B) ObjectUtil.checkNotNull(b, "bootstrap");
    }

    public final Map<AttributeKey<?>, Object> attrs() {
        return this.bootstrap.attrs();
    }

    public final ChannelFactory<? extends C> channelFactory() {
        return this.bootstrap.channelFactory();
    }

    public final EventLoopGroup group() {
        return this.bootstrap.group();
    }

    public final ChannelHandler handler() {
        return this.bootstrap.handler();
    }

    public final SocketAddress localAddress() {
        return this.bootstrap.localAddress();
    }

    public final Map<ChannelOption<?>, Object> options() {
        return this.bootstrap.options();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(StringUtil.simpleClassName(this));
        sb.append(PropertyUtils.MAPPED_DELIM);
        EventLoopGroup eventLoopGroupGroup = group();
        if (eventLoopGroupGroup != null) {
            sb.append("group: ");
            sb.append(StringUtil.simpleClassName(eventLoopGroupGroup));
            sb.append(SQLKeyword.COMMA);
        }
        ChannelFactory<? extends C> channelFactory = channelFactory();
        if (channelFactory != null) {
            sb.append("channelFactory: ");
            sb.append(channelFactory);
            sb.append(SQLKeyword.COMMA);
        }
        SocketAddress socketAddressLocalAddress = localAddress();
        if (socketAddressLocalAddress != null) {
            sb.append("localAddress: ");
            sb.append(socketAddressLocalAddress);
            sb.append(SQLKeyword.COMMA);
        }
        Map<ChannelOption<?>, Object> mapOptions = options();
        if (!mapOptions.isEmpty()) {
            sb.append("options: ");
            sb.append(mapOptions);
            sb.append(SQLKeyword.COMMA);
        }
        Map<AttributeKey<?>, Object> mapAttrs = attrs();
        if (!mapAttrs.isEmpty()) {
            sb.append("attrs: ");
            sb.append(mapAttrs);
            sb.append(SQLKeyword.COMMA);
        }
        ChannelHandler channelHandlerHandler = handler();
        if (channelHandlerHandler != null) {
            sb.append("handler: ");
            sb.append(channelHandlerHandler);
            sb.append(SQLKeyword.COMMA);
        }
        if (sb.charAt(sb.length() - 1) == '(') {
            sb.append(PropertyUtils.MAPPED_DELIM2);
        } else {
            sb.setCharAt(sb.length() - 2, PropertyUtils.MAPPED_DELIM2);
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }
}
