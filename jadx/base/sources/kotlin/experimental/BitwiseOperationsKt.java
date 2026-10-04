package kotlin.experimental;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0004\n\u0002\u0010\n\n\u0000\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\f\u001a\u0015\u0010\u0003\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\f\u001a\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\f\u001a\r\u0010\u0005\u001a\u00020\u0001*\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0006H\u0087\f\u001a\u0015\u0010\u0003\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0006H\u0087\f\u001a\u0015\u0010\u0004\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0006H\u0087\f\u001a\r\u0010\u0005\u001a\u00020\u0006*\u00020\u0006H\u0087\b¨\u0006\u0007"}, m13886d2 = {"and", "", "other", "or", "xor", "inv", "", "kotlin-stdlib"}, m13887k = 2, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class BitwiseOperationsKt {
    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte and(byte b, byte b5) {
        return (byte) (b & b5);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte inv(byte b) {
        return (byte) (~b);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    /* JADX INFO: renamed from: or */
    private static final byte m14028or(byte b, byte b5) {
        return (byte) (b | b5);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte xor(byte b, byte b5) {
        return (byte) (b ^ b5);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short and(short s, short s2) {
        return (short) (s & s2);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short inv(short s) {
        return (short) (~s);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    /* JADX INFO: renamed from: or */
    private static final short m14029or(short s, short s2) {
        return (short) (s | s2);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short xor(short s, short s2) {
        return (short) (s ^ s2);
    }
}
