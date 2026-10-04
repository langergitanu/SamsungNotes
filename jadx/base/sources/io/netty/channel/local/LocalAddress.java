package io.netty.channel.local;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import io.netty.channel.Channel;
import io.netty.util.internal.ObjectUtil;
import java.net.SocketAddress;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class LocalAddress extends SocketAddress implements Comparable<LocalAddress> {
    public static final LocalAddress ANY = new LocalAddress("ANY");
    private static final long serialVersionUID = 4644331421130916435L;

    /* JADX INFO: renamed from: id */
    private final String f8862id;
    private final String strVal;

    public LocalAddress(Channel channel) {
        StringBuilder sbM1627q = AbstractC2322a.m1627q(16, "local:E");
        sbM1627q.append(Long.toHexString((((long) channel.hashCode()) & 4294967295L) | 4294967296L));
        sbM1627q.setCharAt(7, ':');
        this.f8862id = sbM1627q.substring(6);
        this.strVal = sbM1627q.toString();
    }

    public boolean equals(Object obj) {
        if (obj instanceof LocalAddress) {
            return this.f8862id.equals(((LocalAddress) obj).f8862id);
        }
        return false;
    }

    public int hashCode() {
        return this.f8862id.hashCode();
    }

    /* JADX INFO: renamed from: id */
    public String m13767id() {
        return this.f8862id;
    }

    public String toString() {
        return this.strVal;
    }

    @Override // java.lang.Comparable
    public int compareTo(LocalAddress localAddress) {
        return this.f8862id.compareTo(localAddress.f8862id);
    }

    public LocalAddress(String str) {
        String lowerCase = ObjectUtil.checkNonEmptyAfterTrim(str, "id").toLowerCase();
        this.f8862id = lowerCase;
        this.strVal = AbstractC0541b.m772n("local:", lowerCase);
    }

    public LocalAddress(Class<?> cls) {
        this(cls.getSimpleName() + '/' + UUID.randomUUID());
    }
}
