package io.netty.channel.unix;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class DatagramSocketAddress extends InetSocketAddress {
    private static final long serialVersionUID = 3094819287843178401L;
    private final DatagramSocketAddress localAddress;
    private final int receivedAmount;

    public DatagramSocketAddress(byte[] bArr, int i, int i2, int i4, DatagramSocketAddress datagramSocketAddress) {
        super(newAddress(bArr, i), i2);
        this.receivedAmount = i4;
        this.localAddress = datagramSocketAddress;
    }

    private static InetAddress newAddress(byte[] bArr, int i) {
        return bArr.length == 4 ? InetAddress.getByAddress(bArr) : Inet6Address.getByAddress((String) null, bArr, i);
    }

    public DatagramSocketAddress localAddress() {
        return this.localAddress;
    }

    public int receivedAmount() {
        return this.receivedAmount;
    }
}
