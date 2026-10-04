package io.netty.handler.codec.socksx.p189v4;

import io.netty.util.internal.ObjectUtil;
import org.apache.commons.beanutils.PropertyUtils;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class Socks4CommandStatus implements Comparable<Socks4CommandStatus> {
    private final byte byteValue;
    private final String name;
    private String text;
    public static final Socks4CommandStatus SUCCESS = new Socks4CommandStatus(90, "SUCCESS");
    public static final Socks4CommandStatus REJECTED_OR_FAILED = new Socks4CommandStatus(91, "REJECTED_OR_FAILED");
    public static final Socks4CommandStatus IDENTD_UNREACHABLE = new Socks4CommandStatus(92, "IDENTD_UNREACHABLE");
    public static final Socks4CommandStatus IDENTD_AUTH_FAILURE = new Socks4CommandStatus(93, "IDENTD_AUTH_FAILURE");

    public Socks4CommandStatus(int i) {
        this(i, "UNKNOWN");
    }

    public static Socks4CommandStatus valueOf(byte b) {
        switch (b) {
            case 90:
                return SUCCESS;
            case 91:
                return REJECTED_OR_FAILED;
            case 92:
                return IDENTD_UNREACHABLE;
            case 93:
                return IDENTD_AUTH_FAILURE;
            default:
                return new Socks4CommandStatus(b);
        }
    }

    public byte byteValue() {
        return this.byteValue;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Socks4CommandStatus) && this.byteValue == ((Socks4CommandStatus) obj).byteValue;
    }

    public int hashCode() {
        return this.byteValue;
    }

    public boolean isSuccess() {
        return this.byteValue == 90;
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

    public Socks4CommandStatus(int i, String str) {
        this.name = (String) ObjectUtil.checkNotNull(str, "name");
        this.byteValue = (byte) i;
    }

    @Override // java.lang.Comparable
    public int compareTo(Socks4CommandStatus socks4CommandStatus) {
        return this.byteValue - socks4CommandStatus.byteValue;
    }
}
