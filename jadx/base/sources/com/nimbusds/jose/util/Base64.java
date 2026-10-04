package com.nimbusds.jose.util;

import java.io.Serializable;
import java.math.BigInteger;
import net.jcip.annotations.Immutable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
public class Base64 implements Serializable {
    private static final long serialVersionUID = 1;
    private final String value;

    public Base64(String str) {
        if (str == null) {
            throw new IllegalArgumentException("The Base64 value must not be null");
        }
        this.value = str;
    }

    public static Base64 encode(byte[] bArr) {
        return new Base64(Base64Codec.encodeToString(bArr, false));
    }

    public static Base64 from(String str) {
        if (str == null) {
            return null;
        }
        return new Base64(str);
    }

    public byte[] decode() {
        return Base64Codec.decode(this.value);
    }

    public BigInteger decodeToBigInteger() {
        return new BigInteger(1, decode());
    }

    public String decodeToString() {
        return new String(decode(), StandardCharset.UTF_8);
    }

    public boolean equals(Object obj) {
        return (obj instanceof Base64) && toString().equals(obj.toString());
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    public String toJSONString() {
        return JSONStringUtils.toJSONString(this.value);
    }

    public String toString() {
        return this.value;
    }

    public static Base64 encode(BigInteger bigInteger) {
        return encode(BigIntegerUtils.toBytesUnsigned(bigInteger));
    }

    public static Base64 encode(String str) {
        return encode(str.getBytes(StandardCharset.UTF_8));
    }
}
