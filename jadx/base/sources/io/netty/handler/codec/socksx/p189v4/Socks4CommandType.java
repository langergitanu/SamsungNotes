package io.netty.handler.codec.socksx.p189v4;

import com.google.api.client.http.HttpMethods;
import io.netty.util.internal.ObjectUtil;
import org.apache.commons.beanutils.PropertyUtils;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class Socks4CommandType implements Comparable<Socks4CommandType> {
    private final byte byteValue;
    private final String name;
    private String text;
    public static final Socks4CommandType CONNECT = new Socks4CommandType(1, HttpMethods.CONNECT);
    public static final Socks4CommandType BIND = new Socks4CommandType(2, "BIND");

    public Socks4CommandType(int i) {
        this(i, "UNKNOWN");
    }

    public static Socks4CommandType valueOf(byte b) {
        return b != 1 ? b != 2 ? new Socks4CommandType(b) : BIND : CONNECT;
    }

    public byte byteValue() {
        return this.byteValue;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Socks4CommandType) && this.byteValue == ((Socks4CommandType) obj).byteValue;
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

    public Socks4CommandType(int i, String str) {
        this.name = (String) ObjectUtil.checkNotNull(str, "name");
        this.byteValue = (byte) i;
    }

    @Override // java.lang.Comparable
    public int compareTo(Socks4CommandType socks4CommandType) {
        return this.byteValue - socks4CommandType.byteValue;
    }
}
