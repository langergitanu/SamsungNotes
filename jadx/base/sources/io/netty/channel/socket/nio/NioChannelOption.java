package io.netty.channel.socket.nio;

import io.netty.channel.ChannelException;
import io.netty.channel.ChannelOption;
import io.netty.util.internal.SuppressJava6Requirement;
import java.io.IOException;
import java.net.SocketOption;
import java.net.StandardSocketOptions;
import java.nio.channels.Channel;
import java.nio.channels.NetworkChannel;
import java.nio.channels.ServerSocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@SuppressJava6Requirement(reason = "Usage explicit by the user")
public final class NioChannelOption<T> extends ChannelOption<T> {
    private final SocketOption<T> option;

    private NioChannelOption(SocketOption<T> socketOption) {
        super(socketOption.name());
        this.option = socketOption;
    }

    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    public static <T> T getOption(Channel channel, NioChannelOption<T> nioChannelOption) {
        NetworkChannel networkChannel = (NetworkChannel) channel;
        if (!networkChannel.supportedOptions().contains(((NioChannelOption) nioChannelOption).option)) {
            return null;
        }
        if ((networkChannel instanceof ServerSocketChannel) && ((NioChannelOption) nioChannelOption).option == StandardSocketOptions.IP_TOS) {
            return null;
        }
        try {
            return (T) networkChannel.getOption(((NioChannelOption) nioChannelOption).option);
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    public static ChannelOption[] getOptions(Channel channel) {
        NetworkChannel networkChannel = (NetworkChannel) channel;
        Set<SocketOption<?>> setSupportedOptions = networkChannel.supportedOptions();
        int i = 0;
        if (!(networkChannel instanceof ServerSocketChannel)) {
            ChannelOption[] channelOptionArr = new ChannelOption[setSupportedOptions.size()];
            Iterator<SocketOption<?>> it = setSupportedOptions.iterator();
            while (it.hasNext()) {
                channelOptionArr[i] = new NioChannelOption(it.next());
                i++;
            }
            return channelOptionArr;
        }
        ArrayList arrayList = new ArrayList(setSupportedOptions.size());
        for (SocketOption<?> socketOption : setSupportedOptions) {
            if (socketOption != StandardSocketOptions.IP_TOS) {
                arrayList.add(new NioChannelOption(socketOption));
            }
        }
        return (ChannelOption[]) arrayList.toArray(new ChannelOption[0]);
    }

    /* JADX INFO: renamed from: of */
    public static <T> ChannelOption<T> m13770of(SocketOption<T> socketOption) {
        return new NioChannelOption(socketOption);
    }

    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    public static <T> boolean setOption(Channel channel, NioChannelOption<T> nioChannelOption, T t) {
        NetworkChannel networkChannel = (NetworkChannel) channel;
        if (!networkChannel.supportedOptions().contains(((NioChannelOption) nioChannelOption).option)) {
            return false;
        }
        if ((networkChannel instanceof ServerSocketChannel) && ((NioChannelOption) nioChannelOption).option == StandardSocketOptions.IP_TOS) {
            return false;
        }
        try {
            networkChannel.setOption(((NioChannelOption) nioChannelOption).option, t);
            return true;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }
}
