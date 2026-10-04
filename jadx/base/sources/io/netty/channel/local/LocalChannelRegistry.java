package io.netty.channel.local;

import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import java.net.SocketAddress;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
final class LocalChannelRegistry {
    private static final ConcurrentMap<LocalAddress, Channel> boundChannels = PlatformDependent.newConcurrentHashMap();

    private LocalChannelRegistry() {
    }

    public static Channel get(SocketAddress socketAddress) {
        return boundChannels.get(socketAddress);
    }

    public static LocalAddress register(Channel channel, LocalAddress localAddress, SocketAddress socketAddress) {
        if (localAddress != null) {
            throw new ChannelException("already bound");
        }
        if (!(socketAddress instanceof LocalAddress)) {
            throw new ChannelException("unsupported address type: " + StringUtil.simpleClassName(socketAddress));
        }
        LocalAddress localAddress2 = (LocalAddress) socketAddress;
        if (LocalAddress.ANY.equals(localAddress2)) {
            localAddress2 = new LocalAddress(channel);
        }
        Channel channelPutIfAbsent = boundChannels.putIfAbsent(localAddress2, channel);
        if (channelPutIfAbsent == null) {
            return localAddress2;
        }
        throw new ChannelException("address already in use by: " + channelPutIfAbsent);
    }

    public static void unregister(LocalAddress localAddress) {
        boundChannels.remove(localAddress);
    }
}
