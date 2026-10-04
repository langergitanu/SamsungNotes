package com.nimbusds.jose.util;

import java.math.BigInteger;
import net.jcip.annotations.Immutable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
public class Base64URL extends Base64 {
    public Base64URL(String str) {
        super(str);
    }

    public static Base64URL encode(byte[] bArr) {
        return new Base64URL(Base64Codec.encodeToString(bArr, true));
    }

    public static Base64URL from(String str) {
        if (str == null) {
            return null;
        }
        return new Base64URL(str);
    }

    @Override // com.nimbusds.jose.util.Base64
    public boolean equals(Object obj) {
        return (obj instanceof Base64URL) && toString().equals(obj.toString());
    }

    public static Base64URL encode(BigInteger bigInteger) {
        return encode(BigIntegerUtils.toBytesUnsigned(bigInteger));
    }

    public static Base64URL encode(String str) {
        return encode(str.getBytes(StandardCharset.UTF_8));
    }
}
