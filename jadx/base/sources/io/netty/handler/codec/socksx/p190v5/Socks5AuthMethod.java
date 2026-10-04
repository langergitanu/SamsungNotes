package io.netty.handler.codec.socksx.p190v5;

import io.netty.util.internal.ObjectUtil;
import org.apache.commons.beanutils.PropertyUtils;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class Socks5AuthMethod implements Comparable<Socks5AuthMethod> {
    private final byte byteValue;
    private final String name;
    private String text;
    public static final Socks5AuthMethod NO_AUTH = new Socks5AuthMethod(0, "NO_AUTH");
    public static final Socks5AuthMethod GSSAPI = new Socks5AuthMethod(1, "GSSAPI");
    public static final Socks5AuthMethod PASSWORD = new Socks5AuthMethod(2, "PASSWORD");
    public static final Socks5AuthMethod UNACCEPTED = new Socks5AuthMethod(255, "UNACCEPTED");

    public Socks5AuthMethod(int i) {
        this(i, "UNKNOWN");
    }

    public static Socks5AuthMethod valueOf(byte b) {
        return b != -1 ? b != 0 ? b != 1 ? b != 2 ? new Socks5AuthMethod(b) : PASSWORD : GSSAPI : NO_AUTH : UNACCEPTED;
    }

    public byte byteValue() {
        return this.byteValue;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Socks5AuthMethod) && this.byteValue == ((Socks5AuthMethod) obj).byteValue;
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

    public Socks5AuthMethod(int i, String str) {
        this.name = (String) ObjectUtil.checkNotNull(str, "name");
        this.byteValue = (byte) i;
    }

    @Override // java.lang.Comparable
    public int compareTo(Socks5AuthMethod socks5AuthMethod) {
        return this.byteValue - socks5AuthMethod.byteValue;
    }
}
