package io.netty.handler.codec.socksx.p190v5;

import io.netty.util.internal.ObjectUtil;
import org.apache.commons.beanutils.PropertyUtils;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class Socks5AddressType implements Comparable<Socks5AddressType> {
    private final byte byteValue;
    private final String name;
    private String text;
    public static final Socks5AddressType IPv4 = new Socks5AddressType(1, "IPv4");
    public static final Socks5AddressType DOMAIN = new Socks5AddressType(3, "DOMAIN");
    public static final Socks5AddressType IPv6 = new Socks5AddressType(4, "IPv6");

    public Socks5AddressType(int i) {
        this(i, "UNKNOWN");
    }

    public static Socks5AddressType valueOf(byte b) {
        return b != 1 ? b != 3 ? b != 4 ? new Socks5AddressType(b) : IPv6 : DOMAIN : IPv4;
    }

    public byte byteValue() {
        return this.byteValue;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Socks5AddressType) && this.byteValue == ((Socks5AddressType) obj).byteValue;
    }

    public int hashCode() {
        return this.byteValue;
    }

    public String toString() {
        String str = this.text;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        sb.append(PropertyUtils.MAPPED_DELIM);
        String strM13j = AbstractC0000a.m13j(sb, this.byteValue & 255, PropertyUtils.MAPPED_DELIM2);
        this.text = strM13j;
        return strM13j;
    }

    public Socks5AddressType(int i, String str) {
        this.name = (String) ObjectUtil.checkNotNull(str, "name");
        this.byteValue = (byte) i;
    }

    @Override // java.lang.Comparable
    public int compareTo(Socks5AddressType socks5AddressType) {
        return this.byteValue - socks5AddressType.byteValue;
    }
}
