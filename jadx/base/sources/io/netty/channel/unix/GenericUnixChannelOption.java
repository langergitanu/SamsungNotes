package io.netty.channel.unix;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public abstract class GenericUnixChannelOption<T> extends UnixChannelOption<T> {
    private final int level;
    private final int optname;

    public GenericUnixChannelOption(String str, int i, int i2) {
        super(str);
        this.level = i;
        this.optname = i2;
    }

    public int level() {
        return this.level;
    }

    public int optname() {
        return this.optname;
    }
}
