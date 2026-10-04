package kotlin.comparisons;

import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import org.apache.xmlbeans.XmlOptions;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001f\u0010\u0000\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a\u001f\u0010\u0000\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\tH\u0007¢\u0006\u0004\b\n\u0010\u000b\u001a\u001f\u0010\u0000\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\fH\u0007¢\u0006\u0004\b\r\u0010\u000e\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0087\b¢\u0006\u0004\b\u0010\u0010\u0011\u001a(\u0010\u0000\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0087\b¢\u0006\u0004\b\u0012\u0010\u0013\u001a(\u0010\u0000\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0087\b¢\u0006\u0004\b\u0014\u0010\u0015\u001a(\u0010\u0000\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0087\b¢\u0006\u0004\b\u0016\u0010\u0017\u001a#\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\n\u0010\u0018\u001a\u00020\u0019\"\u00020\u0001H\u0007¢\u0006\u0004\b\u001a\u0010\u001b\u001a#\u0010\u0000\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\n\u0010\u0018\u001a\u00020\u001c\"\u00020\u0006H\u0007¢\u0006\u0004\b\u001d\u0010\u001e\u001a#\u0010\u0000\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\n\u0010\u0018\u001a\u00020\u001f\"\u00020\tH\u0007¢\u0006\u0004\b \u0010!\u001a#\u0010\u0000\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\n\u0010\u0018\u001a\u00020\"\"\u00020\fH\u0007¢\u0006\u0004\b#\u0010$\u001a\u001f\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0007¢\u0006\u0004\b&\u0010\u0005\u001a\u001f\u0010%\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0006H\u0007¢\u0006\u0004\b'\u0010\b\u001a\u001f\u0010%\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\tH\u0007¢\u0006\u0004\b(\u0010\u000b\u001a\u001f\u0010%\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\fH\u0007¢\u0006\u0004\b)\u0010\u000e\u001a(\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0087\b¢\u0006\u0004\b*\u0010\u0011\u001a(\u0010%\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0087\b¢\u0006\u0004\b+\u0010\u0013\u001a(\u0010%\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0087\b¢\u0006\u0004\b,\u0010\u0015\u001a(\u0010%\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0087\b¢\u0006\u0004\b-\u0010\u0017\u001a#\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\n\u0010\u0018\u001a\u00020\u0019\"\u00020\u0001H\u0007¢\u0006\u0004\b.\u0010\u001b\u001a#\u0010%\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\n\u0010\u0018\u001a\u00020\u001c\"\u00020\u0006H\u0007¢\u0006\u0004\b/\u0010\u001e\u001a#\u0010%\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\n\u0010\u0018\u001a\u00020\u001f\"\u00020\tH\u0007¢\u0006\u0004\b0\u0010!\u001a#\u0010%\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\n\u0010\u0018\u001a\u00020\"\"\u00020\fH\u0007¢\u0006\u0004\b1\u0010$¨\u00062"}, m13886d2 = {"maxOf", "Lkotlin/UInt;", "a", "b", "maxOf-J1ME1BU", "(II)I", "Lkotlin/ULong;", "maxOf-eb3DHEI", "(JJ)J", "Lkotlin/UByte;", "maxOf-Kr8caGY", "(BB)B", "Lkotlin/UShort;", "maxOf-5PvTz6A", "(SS)S", "c", "maxOf-WZ9TVnA", "(III)I", "maxOf-sambcqE", "(JJJ)J", "maxOf-b33U2AM", "(BBB)B", "maxOf-VKSA0NQ", "(SSS)S", "other", "Lkotlin/UIntArray;", "maxOf-Md2H83M", "(I[I)I", "Lkotlin/ULongArray;", "maxOf-R03FKyM", "(J[J)J", "Lkotlin/UByteArray;", "maxOf-Wr6uiD8", "(B[B)B", "Lkotlin/UShortArray;", "maxOf-t1qELG4", "(S[S)S", "minOf", "minOf-J1ME1BU", "minOf-eb3DHEI", "minOf-Kr8caGY", "minOf-5PvTz6A", "minOf-WZ9TVnA", "minOf-sambcqE", "minOf-b33U2AM", "minOf-VKSA0NQ", "minOf-Md2H83M", "minOf-R03FKyM", "minOf-Wr6uiD8", "minOf-t1qELG4", "kotlin-stdlib"}, m13887k = 5, m13888mv = {2, 1, 0}, m13890xi = 49, m13891xs = "kotlin/comparisons/UComparisonsKt")
public class UComparisonsKt___UComparisonsKt {
    @SinceKotlin(version = XmlOptions.GENERATE_JAVA_15)
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: maxOf-5PvTz6A, reason: not valid java name */
    public static final short m23395maxOf5PvTz6A(short s, short s2) {
        return Intrinsics.compare(s & UShort.MAX_VALUE, 65535 & s2) >= 0 ? s : s2;
    }

    @SinceKotlin(version = XmlOptions.GENERATE_JAVA_15)
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: maxOf-J1ME1BU, reason: not valid java name */
    public static int m23396maxOfJ1ME1BU(int i, int i2) {
        return Integer.compareUnsigned(i, i2) >= 0 ? i : i2;
    }

    @SinceKotlin(version = XmlOptions.GENERATE_JAVA_15)
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: maxOf-Kr8caGY, reason: not valid java name */
    public static final byte m23397maxOfKr8caGY(byte b, byte b5) {
        return Intrinsics.compare(b & 255, b5 & 255) >= 0 ? b : b5;
    }

    @SinceKotlin(version = XmlOptions.GENERATE_JAVA_14)
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: maxOf-Md2H83M, reason: not valid java name */
    public static final int m23398maxOfMd2H83M(int i, @NotNull int... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int iM22371getSizeimpl = UIntArray.m22371getSizeimpl(other);
        for (int i2 = 0; i2 < iM22371getSizeimpl; i2++) {
            i = m23396maxOfJ1ME1BU(i, UIntArray.m22370getpVg5ArA(other, i2));
        }
        return i;
    }

    @SinceKotlin(version = XmlOptions.GENERATE_JAVA_14)
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: maxOf-R03FKyM, reason: not valid java name */
    public static final long m23399maxOfR03FKyM(long j, @NotNull long... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int iM22450getSizeimpl = ULongArray.m22450getSizeimpl(other);
        for (int i = 0; i < iM22450getSizeimpl; i++) {
            j = m23404maxOfeb3DHEI(j, ULongArray.m22449getsVKNKU(other, i));
        }
        return j;
    }

    @SinceKotlin(version = XmlOptions.GENERATE_JAVA_15)
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* JADX INFO: renamed from: maxOf-VKSA0NQ, reason: not valid java name */
    private static final short m23400maxOfVKSA0NQ(short s, short s2, short s3) {
        return m23395maxOf5PvTz6A(s, m23395maxOf5PvTz6A(s2, s3));
    }

    @SinceKotlin(version = XmlOptions.GENERATE_JAVA_15)
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* JADX INFO: renamed from: maxOf-WZ9TVnA, reason: not valid java name */
    private static final int m23401maxOfWZ9TVnA(int i, int i2, int i4) {
        return m23396maxOfJ1ME1BU(i, m23396maxOfJ1ME1BU(i2, i4));
    }

    @SinceKotlin(version = XmlOptions.GENERATE_JAVA_14)
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: maxOf-Wr6uiD8, reason: not valid java name */
    public static final byte m23402maxOfWr6uiD8(byte b, @NotNull byte... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int iM22292getSizeimpl = UByteArray.m22292getSizeimpl(other);
        for (int i = 0; i < iM22292getSizeimpl; i++) {
            b = m23397maxOfKr8caGY(b, UByteArray.m22291getw2LRezQ(other, i));
        }
        return b;
    }

    @SinceKotlin(version = XmlOptions.GENERATE_JAVA_15)
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* JADX INFO: renamed from: maxOf-b33U2AM, reason: not valid java name */
    private static final byte m23403maxOfb33U2AM(byte b, byte b5, byte b6) {
        return m23397maxOfKr8caGY(b, m23397maxOfKr8caGY(b5, b6));
    }

    @SinceKotlin(version = XmlOptions.GENERATE_JAVA_15)
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: maxOf-eb3DHEI, reason: not valid java name */
    public static long m23404maxOfeb3DHEI(long j, long j2) {
        return Long.compareUnsigned(j, j2) >= 0 ? j : j2;
    }

    @SinceKotlin(version = XmlOptions.GENERATE_JAVA_15)
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* JADX INFO: renamed from: maxOf-sambcqE, reason: not valid java name */
    private static final long m23405maxOfsambcqE(long j, long j2, long j3) {
        return m23404maxOfeb3DHEI(j, m23404maxOfeb3DHEI(j2, j3));
    }

    @SinceKotlin(version = XmlOptions.GENERATE_JAVA_14)
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: maxOf-t1qELG4, reason: not valid java name */
    public static final short m23406maxOft1qELG4(short s, @NotNull short... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int iM22555getSizeimpl = UShortArray.m22555getSizeimpl(other);
        for (int i = 0; i < iM22555getSizeimpl; i++) {
            s = m23395maxOf5PvTz6A(s, UShortArray.m22554getMh2AYeg(other, i));
        }
        return s;
    }

    @SinceKotlin(version = XmlOptions.GENERATE_JAVA_15)
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: minOf-5PvTz6A, reason: not valid java name */
    public static final short m23407minOf5PvTz6A(short s, short s2) {
        return Intrinsics.compare(s & UShort.MAX_VALUE, 65535 & s2) <= 0 ? s : s2;
    }

    @SinceKotlin(version = XmlOptions.GENERATE_JAVA_15)
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: minOf-J1ME1BU, reason: not valid java name */
    public static int m23408minOfJ1ME1BU(int i, int i2) {
        return Integer.compareUnsigned(i, i2) <= 0 ? i : i2;
    }

    @SinceKotlin(version = XmlOptions.GENERATE_JAVA_15)
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: minOf-Kr8caGY, reason: not valid java name */
    public static final byte m23409minOfKr8caGY(byte b, byte b5) {
        return Intrinsics.compare(b & 255, b5 & 255) <= 0 ? b : b5;
    }

    @SinceKotlin(version = XmlOptions.GENERATE_JAVA_14)
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: minOf-Md2H83M, reason: not valid java name */
    public static final int m23410minOfMd2H83M(int i, @NotNull int... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int iM22371getSizeimpl = UIntArray.m22371getSizeimpl(other);
        for (int i2 = 0; i2 < iM22371getSizeimpl; i2++) {
            i = m23408minOfJ1ME1BU(i, UIntArray.m22370getpVg5ArA(other, i2));
        }
        return i;
    }

    @SinceKotlin(version = XmlOptions.GENERATE_JAVA_14)
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: minOf-R03FKyM, reason: not valid java name */
    public static final long m23411minOfR03FKyM(long j, @NotNull long... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int iM22450getSizeimpl = ULongArray.m22450getSizeimpl(other);
        for (int i = 0; i < iM22450getSizeimpl; i++) {
            j = m23416minOfeb3DHEI(j, ULongArray.m22449getsVKNKU(other, i));
        }
        return j;
    }

    @SinceKotlin(version = XmlOptions.GENERATE_JAVA_15)
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* JADX INFO: renamed from: minOf-VKSA0NQ, reason: not valid java name */
    private static final short m23412minOfVKSA0NQ(short s, short s2, short s3) {
        return m23407minOf5PvTz6A(s, m23407minOf5PvTz6A(s2, s3));
    }

    @SinceKotlin(version = XmlOptions.GENERATE_JAVA_15)
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* JADX INFO: renamed from: minOf-WZ9TVnA, reason: not valid java name */
    private static final int m23413minOfWZ9TVnA(int i, int i2, int i4) {
        return m23408minOfJ1ME1BU(i, m23408minOfJ1ME1BU(i2, i4));
    }

    @SinceKotlin(version = XmlOptions.GENERATE_JAVA_14)
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: minOf-Wr6uiD8, reason: not valid java name */
    public static final byte m23414minOfWr6uiD8(byte b, @NotNull byte... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int iM22292getSizeimpl = UByteArray.m22292getSizeimpl(other);
        for (int i = 0; i < iM22292getSizeimpl; i++) {
            b = m23409minOfKr8caGY(b, UByteArray.m22291getw2LRezQ(other, i));
        }
        return b;
    }

    @SinceKotlin(version = XmlOptions.GENERATE_JAVA_15)
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* JADX INFO: renamed from: minOf-b33U2AM, reason: not valid java name */
    private static final byte m23415minOfb33U2AM(byte b, byte b5, byte b6) {
        return m23409minOfKr8caGY(b, m23409minOfKr8caGY(b5, b6));
    }

    @SinceKotlin(version = XmlOptions.GENERATE_JAVA_15)
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: minOf-eb3DHEI, reason: not valid java name */
    public static long m23416minOfeb3DHEI(long j, long j2) {
        return Long.compareUnsigned(j, j2) <= 0 ? j : j2;
    }

    @SinceKotlin(version = XmlOptions.GENERATE_JAVA_15)
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* JADX INFO: renamed from: minOf-sambcqE, reason: not valid java name */
    private static final long m23417minOfsambcqE(long j, long j2, long j3) {
        return m23416minOfeb3DHEI(j, m23416minOfeb3DHEI(j2, j3));
    }

    @SinceKotlin(version = XmlOptions.GENERATE_JAVA_14)
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: minOf-t1qELG4, reason: not valid java name */
    public static final short m23418minOft1qELG4(short s, @NotNull short... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int iM22555getSizeimpl = UShortArray.m22555getSizeimpl(other);
        for (int i = 0; i < iM22555getSizeimpl; i++) {
            s = m23407minOf5PvTz6A(s, UShortArray.m22554getMh2AYeg(other, i));
        }
        return s;
    }
}
