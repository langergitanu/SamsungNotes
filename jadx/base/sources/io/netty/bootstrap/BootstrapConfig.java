package io.netty.bootstrap;

import io.netty.channel.Channel;
import io.netty.resolver.AddressResolverGroup;
import java.net.SocketAddress;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class BootstrapConfig extends AbstractBootstrapConfig<Bootstrap, Channel> {
    public BootstrapConfig(Bootstrap bootstrap) {
        super(bootstrap);
    }

    public SocketAddress remoteAddress() {
        return ((Bootstrap) this.bootstrap).remoteAddress();
    }

    public AddressResolverGroup<?> resolver() {
        return ((Bootstrap) this.bootstrap).resolver();
    }

    @Override // io.netty.bootstrap.AbstractBootstrapConfig
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.setLength(sb.length() - 1);
        sb.append(", resolver: ");
        sb.append(resolver());
        SocketAddress socketAddressRemoteAddress = remoteAddress();
        if (socketAddressRemoteAddress != null) {
            sb.append(", remoteAddress: ");
            sb.append(socketAddressRemoteAddress);
        }
        sb.append(PropertyUtils.MAPPED_DELIM2);
        return sb.toString();
    }
}
