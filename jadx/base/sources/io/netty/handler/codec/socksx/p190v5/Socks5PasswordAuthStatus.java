package io.netty.handler.codec.socksx.p190v5;

import io.netty.util.internal.ObjectUtil;
import org.apache.commons.beanutils.PropertyUtils;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class Socks5PasswordAuthStatus implements Comparable<Socks5PasswordAuthStatus> {
    private final byte byteValue;
    private final String name;
    private String text;
    public static final Socks5PasswordAuthStatus SUCCESS = new Socks5PasswordAuthStatus(0, "SUCCESS");
    public static final Socks5PasswordAuthStatus FAILURE = new Socks5PasswordAuthStatus(255, "FAILURE");

    public Socks5PasswordAuthStatus(int i) {
        this(i, "UNKNOWN");
    }

    public static Socks5PasswordAuthStatus valueOf(byte b) {
        return b != -1 ? b != 0 ? new Socks5PasswordAuthStatus(b) : SUCCESS : FAILURE;
    }

    public byte byteValue() {
        return this.byteValue;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Socks5PasswordAuthStatus) && this.byteValue == ((Socks5PasswordAuthStatus) obj).byteValue;
    }

    public int hashCode() {
        return this.byteValue;
    }

    public boolean isSuccess() {
        return this.byteValue == 0;
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

    public Socks5PasswordAuthStatus(int i, String str) {
        this.name = (String) ObjectUtil.checkNotNull(str, "name");
        this.byteValue = (byte) i;
    }

    @Override // java.lang.Comparable
    public int compareTo(Socks5PasswordAuthStatus socks5PasswordAuthStatus) {
        return this.byteValue - socks5PasswordAuthStatus.byteValue;
    }
}
