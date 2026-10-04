package io.netty.bootstrap;

import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.ServerChannel;
import io.netty.util.AttributeKey;
import io.netty.util.internal.StringUtil;
import java.util.Map;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class ServerBootstrapConfig extends AbstractBootstrapConfig<ServerBootstrap, ServerChannel> {
    public ServerBootstrapConfig(ServerBootstrap serverBootstrap) {
        super(serverBootstrap);
    }

    public Map<AttributeKey<?>, Object> childAttrs() {
        return ((ServerBootstrap) this.bootstrap).childAttrs();
    }

    public EventLoopGroup childGroup() {
        return ((ServerBootstrap) this.bootstrap).childGroup();
    }

    public ChannelHandler childHandler() {
        return ((ServerBootstrap) this.bootstrap).childHandler();
    }

    public Map<ChannelOption<?>, Object> childOptions() {
        return ((ServerBootstrap) this.bootstrap).childOptions();
    }

    @Override // io.netty.bootstrap.AbstractBootstrapConfig
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.setLength(sb.length() - 1);
        sb.append(SQLKeyword.COMMA);
        EventLoopGroup eventLoopGroupChildGroup = childGroup();
        if (eventLoopGroupChildGroup != null) {
            sb.append("childGroup: ");
            sb.append(StringUtil.simpleClassName(eventLoopGroupChildGroup));
            sb.append(SQLKeyword.COMMA);
        }
        Map<ChannelOption<?>, Object> mapChildOptions = childOptions();
        if (!mapChildOptions.isEmpty()) {
            sb.append("childOptions: ");
            sb.append(mapChildOptions);
            sb.append(SQLKeyword.COMMA);
        }
        Map<AttributeKey<?>, Object> mapChildAttrs = childAttrs();
        if (!mapChildAttrs.isEmpty()) {
            sb.append("childAttrs: ");
            sb.append(mapChildAttrs);
            sb.append(SQLKeyword.COMMA);
        }
        ChannelHandler channelHandlerChildHandler = childHandler();
        if (channelHandlerChildHandler != null) {
            sb.append("childHandler: ");
            sb.append(channelHandlerChildHandler);
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
