package com.yubico.yubikit.piv;

import java.math.BigInteger;
import java.security.Key;
import java.security.interfaces.ECKey;
import java.security.interfaces.RSAKey;
import java.security.spec.EllipticCurve;
import javax.annotation.Nonnull;
import p001A.AbstractC0000a;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'RSA1024' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final class KeyType {
    private static final /* synthetic */ KeyType[] $VALUES;
    public static final KeyType ECCP256;
    public static final KeyType ECCP384;
    public static final KeyType RSA1024;
    public static final KeyType RSA2048;
    public final KeyParams params;
    public final byte value;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum Algorithm {
        RSA,
        EC
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class EcKeyParams extends KeyParams {

        /* JADX INFO: renamed from: a */
        private final BigInteger f8450a;

        /* JADX INFO: renamed from: b */
        private final BigInteger f8451b;

        @Override // com.yubico.yubikit.piv.KeyType.KeyParams
        public boolean matches(Key key) {
            if (key instanceof ECKey) {
                EllipticCurve curve = ((ECKey) key).getParams().getCurve();
                if (curve.getField().getFieldSize() == this.bitLength && curve.getA().equals(this.f8450a) && curve.getB().equals(this.f8451b)) {
                    return true;
                }
            }
            return false;
        }

        private EcKeyParams(int i, String str, String str2) {
            super(Algorithm.EC, i);
            this.f8450a = new BigInteger(str);
            this.f8451b = new BigInteger(str2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class KeyParams {

        @Nonnull
        public final Algorithm algorithm;
        public final int bitLength;

        public abstract boolean matches(Key key);

        private KeyParams(Algorithm algorithm, int i) {
            this.algorithm = algorithm;
            this.bitLength = i;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class RsaKeyParams extends KeyParams {
        @Override // com.yubico.yubikit.piv.KeyType.KeyParams
        public boolean matches(Key key) {
            return (key instanceof RSAKey) && ((RSAKey) key).getModulus().bitLength() == this.bitLength;
        }

        private RsaKeyParams(int i) {
            super(Algorithm.RSA, i);
        }
    }

    static {
        KeyType keyType = new KeyType("RSA1024", 0, (byte) 6, new RsaKeyParams(1024));
        RSA1024 = keyType;
        KeyType keyType2 = new KeyType("RSA2048", 1, (byte) 7, new RsaKeyParams(2048));
        RSA2048 = keyType2;
        KeyType keyType3 = new KeyType("ECCP256", 2, (byte) 17, new EcKeyParams(256, "115792089210356248762697446949407573530086143415290314195533631308867097853948", "41058363725152142129326129780047268409114441015993725554835256314039467401291"));
        ECCP256 = keyType3;
        KeyType keyType4 = new KeyType("ECCP384", 3, (byte) 20, new EcKeyParams(384, "39402006196394479212279040100143613805079739270465446667948293404245721771496870329047266088258938001861606973112316", "27580193559959705877849011840389048093056905856361568521428707301988689241309860865136260764883745107765439761230575"));
        ECCP384 = keyType4;
        $VALUES = new KeyType[]{keyType, keyType2, keyType3, keyType4};
    }

    private KeyType(String str, int i, byte b, KeyParams keyParams) {
        this.value = b;
        this.params = keyParams;
    }

    public static KeyType fromKey(Key key) {
        for (KeyType keyType : values()) {
            if (keyType.params.matches(key)) {
                return keyType;
            }
        }
        throw new IllegalArgumentException("Unsupported key type");
    }

    public static KeyType fromValue(int i) {
        for (KeyType keyType : values()) {
            if (keyType.value == i) {
                return keyType;
            }
        }
        throw new IllegalArgumentException(AbstractC0000a.m11h(i, "Not a valid KeyType:"));
    }

    public static KeyType valueOf(String str) {
        return (KeyType) Enum.valueOf(KeyType.class, str);
    }

    public static KeyType[] values() {
        return (KeyType[]) $VALUES.clone();
    }
}
