package io.netty.channel.unix;

import io.netty.channel.ChannelOption;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class UnixChannelOption<T> extends ChannelOption<T> {
    public static final ChannelOption<Boolean> SO_REUSEPORT = ChannelOption.valueOf(UnixChannelOption.class, "SO_REUSEPORT");
    public static final ChannelOption<DomainSocketReadMode> DOMAIN_SOCKET_READ_MODE = ChannelOption.valueOf(UnixChannelOption.class, "DOMAIN_SOCKET_READ_MODE");

    public UnixChannelOption() {
        super(null);
    }

    public UnixChannelOption(String str) {
        super(str);
    }
}
