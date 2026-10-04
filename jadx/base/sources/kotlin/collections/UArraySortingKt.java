package kotlin.collections;

import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u00000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0006\u0010\u0007\u001a'\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\n\u0010\u000b\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\r\u0010\u000e\u001a'\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u000f\u0010\u0010\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0012\u0010\u0013\u001a'\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0014\u0010\u0015\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0017\u0010\u0018\u001a'\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0019\u0010\u001a\u001a'\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\u001e\u0010\u000b\u001a'\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\u001f\u0010\u0010\u001a'\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b \u0010\u0015\u001a'\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b!\u0010\u001a¨\u0006\""}, m13886d2 = {"partition", "", "array", "Lkotlin/UByteArray;", "left", "right", "partition-4UcCI2c", "([BII)I", "quickSort", "", "quickSort-4UcCI2c", "([BII)V", "Lkotlin/UShortArray;", "partition-Aa5vz7o", "([SII)I", "quickSort-Aa5vz7o", "([SII)V", "Lkotlin/UIntArray;", "partition-oBK06Vg", "([III)I", "quickSort-oBK06Vg", "([III)V", "Lkotlin/ULongArray;", "partition--nroSd4", "([JII)I", "quickSort--nroSd4", "([JII)V", "sortArray", "fromIndex", "toIndex", "sortArray-4UcCI2c", "sortArray-Aa5vz7o", "sortArray-oBK06Vg", "sortArray--nroSd4", "kotlin-stdlib"}, m13887k = 2, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class UArraySortingKt {
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: partition--nroSd4, reason: not valid java name */
    private static final int m22670partitionnroSd4(long[] jArr, int i, int i2) {
        long jM22449getsVKNKU = ULongArray.m22449getsVKNKU(jArr, (i + i2) / 2);
        while (i <= i2) {
            while (Long.compareUnsigned(ULongArray.m22449getsVKNKU(jArr, i), jM22449getsVKNKU) < 0) {
                i++;
            }
            while (Long.compareUnsigned(ULongArray.m22449getsVKNKU(jArr, i2), jM22449getsVKNKU) > 0) {
                i2--;
            }
            if (i <= i2) {
                long jM22449getsVKNKU2 = ULongArray.m22449getsVKNKU(jArr, i);
                ULongArray.m22454setk8EXiF4(jArr, i, ULongArray.m22449getsVKNKU(jArr, i2));
                ULongArray.m22454setk8EXiF4(jArr, i2, jM22449getsVKNKU2);
                i++;
                i2--;
            }
        }
        return i;
    }

    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: partition-4UcCI2c, reason: not valid java name */
    private static final int m22671partition4UcCI2c(byte[] bArr, int i, int i2) {
        int i4;
        byte bM22291getw2LRezQ = UByteArray.m22291getw2LRezQ(bArr, (i + i2) / 2);
        while (i <= i2) {
            while (true) {
                i4 = bM22291getw2LRezQ & 255;
                if (Intrinsics.compare(UByteArray.m22291getw2LRezQ(bArr, i) & 255, i4) >= 0) {
                    break;
                }
                i++;
            }
            while (Intrinsics.compare(UByteArray.m22291getw2LRezQ(bArr, i2) & 255, i4) > 0) {
                i2--;
            }
            if (i <= i2) {
                byte bM22291getw2LRezQ2 = UByteArray.m22291getw2LRezQ(bArr, i);
                UByteArray.m22296setVurrAj0(bArr, i, UByteArray.m22291getw2LRezQ(bArr, i2));
                UByteArray.m22296setVurrAj0(bArr, i2, bM22291getw2LRezQ2);
                i++;
                i2--;
            }
        }
        return i;
    }

    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: partition-Aa5vz7o, reason: not valid java name */
    private static final int m22672partitionAa5vz7o(short[] sArr, int i, int i2) {
        int i4;
        short sM22554getMh2AYeg = UShortArray.m22554getMh2AYeg(sArr, (i + i2) / 2);
        while (i <= i2) {
            while (true) {
                int iM22554getMh2AYeg = UShortArray.m22554getMh2AYeg(sArr, i) & UShort.MAX_VALUE;
                i4 = sM22554getMh2AYeg & UShort.MAX_VALUE;
                if (Intrinsics.compare(iM22554getMh2AYeg, i4) >= 0) {
                    break;
                }
                i++;
            }
            while (Intrinsics.compare(UShortArray.m22554getMh2AYeg(sArr, i2) & UShort.MAX_VALUE, i4) > 0) {
                i2--;
            }
            if (i <= i2) {
                short sM22554getMh2AYeg2 = UShortArray.m22554getMh2AYeg(sArr, i);
                UShortArray.m22559set01HTLdE(sArr, i, UShortArray.m22554getMh2AYeg(sArr, i2));
                UShortArray.m22559set01HTLdE(sArr, i2, sM22554getMh2AYeg2);
                i++;
                i2--;
            }
        }
        return i;
    }

    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: partition-oBK06Vg, reason: not valid java name */
    private static final int m22673partitionoBK06Vg(int[] iArr, int i, int i2) {
        int iM22370getpVg5ArA = UIntArray.m22370getpVg5ArA(iArr, (i + i2) / 2);
        while (i <= i2) {
            while (Integer.compareUnsigned(UIntArray.m22370getpVg5ArA(iArr, i), iM22370getpVg5ArA) < 0) {
                i++;
            }
            while (Integer.compareUnsigned(UIntArray.m22370getpVg5ArA(iArr, i2), iM22370getpVg5ArA) > 0) {
                i2--;
            }
            if (i <= i2) {
                int iM22370getpVg5ArA2 = UIntArray.m22370getpVg5ArA(iArr, i);
                UIntArray.m22375setVXSXFK8(iArr, i, UIntArray.m22370getpVg5ArA(iArr, i2));
                UIntArray.m22375setVXSXFK8(iArr, i2, iM22370getpVg5ArA2);
                i++;
                i2--;
            }
        }
        return i;
    }

    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: quickSort--nroSd4, reason: not valid java name */
    private static final void m22674quickSortnroSd4(long[] jArr, int i, int i2) {
        int iM22670partitionnroSd4 = m22670partitionnroSd4(jArr, i, i2);
        int i4 = iM22670partitionnroSd4 - 1;
        if (i < i4) {
            m22674quickSortnroSd4(jArr, i, i4);
        }
        if (iM22670partitionnroSd4 < i2) {
            m22674quickSortnroSd4(jArr, iM22670partitionnroSd4, i2);
        }
    }

    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: quickSort-4UcCI2c, reason: not valid java name */
    private static final void m22675quickSort4UcCI2c(byte[] bArr, int i, int i2) {
        int iM22671partition4UcCI2c = m22671partition4UcCI2c(bArr, i, i2);
        int i4 = iM22671partition4UcCI2c - 1;
        if (i < i4) {
            m22675quickSort4UcCI2c(bArr, i, i4);
        }
        if (iM22671partition4UcCI2c < i2) {
            m22675quickSort4UcCI2c(bArr, iM22671partition4UcCI2c, i2);
        }
    }

    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: quickSort-Aa5vz7o, reason: not valid java name */
    private static final void m22676quickSortAa5vz7o(short[] sArr, int i, int i2) {
        int iM22672partitionAa5vz7o = m22672partitionAa5vz7o(sArr, i, i2);
        int i4 = iM22672partitionAa5vz7o - 1;
        if (i < i4) {
            m22676quickSortAa5vz7o(sArr, i, i4);
        }
        if (iM22672partitionAa5vz7o < i2) {
            m22676quickSortAa5vz7o(sArr, iM22672partitionAa5vz7o, i2);
        }
    }

    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: quickSort-oBK06Vg, reason: not valid java name */
    private static final void m22677quickSortoBK06Vg(int[] iArr, int i, int i2) {
        int iM22673partitionoBK06Vg = m22673partitionoBK06Vg(iArr, i, i2);
        int i4 = iM22673partitionoBK06Vg - 1;
        if (i < i4) {
            m22677quickSortoBK06Vg(iArr, i, i4);
        }
        if (iM22673partitionoBK06Vg < i2) {
            m22677quickSortoBK06Vg(iArr, iM22673partitionoBK06Vg, i2);
        }
    }

    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sortArray--nroSd4, reason: not valid java name */
    public static final void m22678sortArraynroSd4(@NotNull long[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m22674quickSortnroSd4(array, i, i2 - 1);
    }

    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sortArray-4UcCI2c, reason: not valid java name */
    public static final void m22679sortArray4UcCI2c(@NotNull byte[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m22675quickSort4UcCI2c(array, i, i2 - 1);
    }

    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sortArray-Aa5vz7o, reason: not valid java name */
    public static final void m22680sortArrayAa5vz7o(@NotNull short[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m22676quickSortAa5vz7o(array, i, i2 - 1);
    }

    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sortArray-oBK06Vg, reason: not valid java name */
    public static final void m22681sortArrayoBK06Vg(@NotNull int[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m22677quickSortoBK06Vg(array, i, i2 - 1);
    }
}
