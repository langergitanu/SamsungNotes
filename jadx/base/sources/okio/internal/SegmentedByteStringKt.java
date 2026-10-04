package okio.internal;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ByteString;
import okio.Segment;
import okio.SegmentedByteString;
import okio.Util;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m13884bv = {1, 0, 3}, m13885d1 = {"\u0000R\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a\u0017\u0010\u0006\u001a\u00020\u0007*\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0080\b\u001a\r\u0010\u000b\u001a\u00020\u0001*\u00020\bH\u0080\b\u001a\r\u0010\f\u001a\u00020\u0001*\u00020\bH\u0080\b\u001a\u0015\u0010\r\u001a\u00020\u000e*\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0001H\u0080\b\u001a-\u0010\u0010\u001a\u00020\u0007*\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0001H\u0080\b\u001a-\u0010\u0010\u001a\u00020\u0007*\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0001H\u0080\b\u001a\u001d\u0010\u0016\u001a\u00020\u0015*\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0001H\u0080\b\u001a\r\u0010\u0019\u001a\u00020\u0012*\u00020\bH\u0080\b\u001a%\u0010\u001a\u001a\u00020\u001b*\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0001H\u0080\b\u001a]\u0010\u001e\u001a\u00020\u001b*\u00020\b2K\u0010\u001f\u001aG\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u001b0 H\u0080\bø\u0001\u0000\u001aj\u0010\u001e\u001a\u00020\u001b*\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00012K\u0010\u001f\u001aG\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u001b0 H\u0082\b\u001a\u0014\u0010$\u001a\u00020\u0001*\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0001H\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006%"}, m13886d2 = {"binarySearch", "", "", "value", "fromIndex", "toIndex", "commonEquals", "", "Lokio/SegmentedByteString;", "other", "", "commonGetSize", "commonHashCode", "commonInternalGet", "", "pos", "commonRangeEquals", TypedValues.Cycle.S_WAVE_OFFSET, "", "otherOffset", "byteCount", "Lokio/ByteString;", "commonSubstring", "beginIndex", TextConst.KEY_END_INDEX, "commonToByteArray", "commonWrite", "", "buffer", "Lokio/Buffer;", "forEachSegment", "action", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "data", "segment", "okio"}, m13887k = 2, m13888mv = {1, 4, 1})
public final class SegmentedByteStringKt {
    public static final int binarySearch(@NotNull int[] binarySearch, int i, int i2, int i4) {
        Intrinsics.checkNotNullParameter(binarySearch, "$this$binarySearch");
        int i5 = i4 - 1;
        while (i2 <= i5) {
            int i6 = (i2 + i5) >>> 1;
            int i7 = binarySearch[i6];
            if (i7 < i) {
                i2 = i6 + 1;
            } else {
                if (i7 <= i) {
                    return i6;
                }
                i5 = i6 - 1;
            }
        }
        return (-i2) - 1;
    }

    public static final boolean commonEquals(@NotNull SegmentedByteString commonEquals, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(commonEquals, "$this$commonEquals");
        if (obj == commonEquals) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == commonEquals.size() && commonEquals.rangeEquals(0, byteString, 0, commonEquals.size())) {
                return true;
            }
        }
        return false;
    }

    public static final int commonGetSize(@NotNull SegmentedByteString commonGetSize) {
        Intrinsics.checkNotNullParameter(commonGetSize, "$this$commonGetSize");
        return commonGetSize.getDirectory()[commonGetSize.getSegments().length - 1];
    }

    public static final int commonHashCode(@NotNull SegmentedByteString commonHashCode) {
        Intrinsics.checkNotNullParameter(commonHashCode, "$this$commonHashCode");
        int hashCode = commonHashCode.getHashCode();
        if (hashCode != 0) {
            return hashCode;
        }
        int length = commonHashCode.getSegments().length;
        int i = 0;
        int i2 = 1;
        int i4 = 0;
        while (i < length) {
            int i5 = commonHashCode.getDirectory()[length + i];
            int i6 = commonHashCode.getDirectory()[i];
            byte[] bArr = commonHashCode.getSegments()[i];
            int i7 = (i6 - i4) + i5;
            while (i5 < i7) {
                i2 = (i2 * 31) + bArr[i5];
                i5++;
            }
            i++;
            i4 = i6;
        }
        commonHashCode.setHashCode$okio(i2);
        return i2;
    }

    public static final byte commonInternalGet(@NotNull SegmentedByteString commonInternalGet, int i) {
        Intrinsics.checkNotNullParameter(commonInternalGet, "$this$commonInternalGet");
        Util.checkOffsetAndCount(commonInternalGet.getDirectory()[commonInternalGet.getSegments().length - 1], i, 1L);
        int iSegment = segment(commonInternalGet, i);
        return commonInternalGet.getSegments()[iSegment][(i - (iSegment == 0 ? 0 : commonInternalGet.getDirectory()[iSegment - 1])) + commonInternalGet.getDirectory()[commonInternalGet.getSegments().length + iSegment]];
    }

    public static final boolean commonRangeEquals(@NotNull SegmentedByteString commonRangeEquals, int i, @NotNull ByteString other, int i2, int i4) {
        Intrinsics.checkNotNullParameter(commonRangeEquals, "$this$commonRangeEquals");
        Intrinsics.checkNotNullParameter(other, "other");
        if (i < 0 || i > commonRangeEquals.size() - i4) {
            return false;
        }
        int i5 = i4 + i;
        int iSegment = segment(commonRangeEquals, i);
        while (i < i5) {
            int i6 = iSegment == 0 ? 0 : commonRangeEquals.getDirectory()[iSegment - 1];
            int i7 = commonRangeEquals.getDirectory()[iSegment] - i6;
            int i8 = commonRangeEquals.getDirectory()[commonRangeEquals.getSegments().length + iSegment];
            int iMin = Math.min(i5, i7 + i6) - i;
            if (!other.rangeEquals(i2, commonRangeEquals.getSegments()[iSegment], (i - i6) + i8, iMin)) {
                return false;
            }
            i2 += iMin;
            i += iMin;
            iSegment++;
        }
        return true;
    }

    @NotNull
    public static final ByteString commonSubstring(@NotNull SegmentedByteString commonSubstring, int i, int i2) {
        Intrinsics.checkNotNullParameter(commonSubstring, "$this$commonSubstring");
        if (!(i >= 0)) {
            throw new IllegalArgumentException(AbstractC0541b.m767i(i, "beginIndex=", " < 0").toString());
        }
        if (!(i2 <= commonSubstring.size())) {
            StringBuilder sbM778t = AbstractC0541b.m778t(i2, "endIndex=", " > length(");
            sbM778t.append(commonSubstring.size());
            sbM778t.append(PropertyUtils.MAPPED_DELIM2);
            throw new IllegalArgumentException(sbM778t.toString().toString());
        }
        int i4 = i2 - i;
        if (!(i4 >= 0)) {
            throw new IllegalArgumentException(AbstractC1038a.m1214o(i2, i, "endIndex=", " < beginIndex=").toString());
        }
        if (i == 0 && i2 == commonSubstring.size()) {
            return commonSubstring;
        }
        if (i == i2) {
            return ByteString.EMPTY;
        }
        int iSegment = segment(commonSubstring, i);
        int iSegment2 = segment(commonSubstring, i2 - 1);
        byte[][] bArr = (byte[][]) ArraysKt.copyOfRange(commonSubstring.getSegments(), iSegment, iSegment2 + 1);
        int[] iArr = new int[bArr.length * 2];
        if (iSegment <= iSegment2) {
            int i5 = 0;
            int i6 = iSegment;
            while (true) {
                iArr[i5] = Math.min(commonSubstring.getDirectory()[i6] - i, i4);
                int i7 = i5 + 1;
                iArr[i5 + bArr.length] = commonSubstring.getDirectory()[commonSubstring.getSegments().length + i6];
                if (i6 == iSegment2) {
                    break;
                }
                i6++;
                i5 = i7;
            }
        }
        int i8 = iSegment != 0 ? commonSubstring.getDirectory()[iSegment - 1] : 0;
        int length = bArr.length;
        iArr[length] = (i - i8) + iArr[length];
        return new SegmentedByteString(bArr, iArr);
    }

    @NotNull
    public static final byte[] commonToByteArray(@NotNull SegmentedByteString commonToByteArray) {
        Intrinsics.checkNotNullParameter(commonToByteArray, "$this$commonToByteArray");
        byte[] bArr = new byte[commonToByteArray.size()];
        int length = commonToByteArray.getSegments().length;
        int i = 0;
        int i2 = 0;
        int i4 = 0;
        while (i < length) {
            int i5 = commonToByteArray.getDirectory()[length + i];
            int i6 = commonToByteArray.getDirectory()[i];
            int i7 = i6 - i2;
            ArraysKt.copyInto(commonToByteArray.getSegments()[i], bArr, i4, i5, i5 + i7);
            i4 += i7;
            i++;
            i2 = i6;
        }
        return bArr;
    }

    public static final void commonWrite(@NotNull SegmentedByteString commonWrite, @NotNull Buffer buffer, int i, int i2) {
        Intrinsics.checkNotNullParameter(commonWrite, "$this$commonWrite");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int i4 = i + i2;
        int iSegment = segment(commonWrite, i);
        while (i < i4) {
            int i5 = iSegment == 0 ? 0 : commonWrite.getDirectory()[iSegment - 1];
            int i6 = commonWrite.getDirectory()[iSegment] - i5;
            int i7 = commonWrite.getDirectory()[commonWrite.getSegments().length + iSegment];
            int iMin = Math.min(i4, i6 + i5) - i;
            int i8 = (i - i5) + i7;
            Segment segment = new Segment(commonWrite.getSegments()[iSegment], i8, i8 + iMin, true, false);
            Segment segment2 = buffer.head;
            if (segment2 == null) {
                segment.prev = segment;
                segment.next = segment;
                buffer.head = segment;
            } else {
                Intrinsics.checkNotNull(segment2);
                Segment segment3 = segment2.prev;
                Intrinsics.checkNotNull(segment3);
                segment3.push(segment);
            }
            i += iMin;
            iSegment++;
        }
        buffer.setSize$okio(buffer.size() + ((long) i2));
    }

    public static final void forEachSegment(@NotNull SegmentedByteString forEachSegment, @NotNull Function3<? super byte[], ? super Integer, ? super Integer, Unit> action) {
        Intrinsics.checkNotNullParameter(forEachSegment, "$this$forEachSegment");
        Intrinsics.checkNotNullParameter(action, "action");
        int length = forEachSegment.getSegments().length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i4 = forEachSegment.getDirectory()[length + i];
            int i5 = forEachSegment.getDirectory()[i];
            action.invoke(forEachSegment.getSegments()[i], Integer.valueOf(i4), Integer.valueOf(i5 - i2));
            i++;
            i2 = i5;
        }
    }

    public static final int segment(@NotNull SegmentedByteString segment, int i) {
        Intrinsics.checkNotNullParameter(segment, "$this$segment");
        int iBinarySearch = binarySearch(segment.getDirectory(), i + 1, 0, segment.getSegments().length);
        return iBinarySearch >= 0 ? iBinarySearch : ~iBinarySearch;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void forEachSegment(SegmentedByteString segmentedByteString, int i, int i2, Function3<? super byte[], ? super Integer, ? super Integer, Unit> function3) {
        int iSegment = segment(segmentedByteString, i);
        while (i < i2) {
            int i4 = iSegment == 0 ? 0 : segmentedByteString.getDirectory()[iSegment - 1];
            int i5 = segmentedByteString.getDirectory()[iSegment] - i4;
            int i6 = segmentedByteString.getDirectory()[segmentedByteString.getSegments().length + iSegment];
            int iMin = Math.min(i2, i5 + i4) - i;
            function3.invoke(segmentedByteString.getSegments()[iSegment], Integer.valueOf((i - i4) + i6), Integer.valueOf(iMin));
            i += iMin;
            iSegment++;
        }
    }

    public static final boolean commonRangeEquals(@NotNull SegmentedByteString commonRangeEquals, int i, @NotNull byte[] other, int i2, int i4) {
        Intrinsics.checkNotNullParameter(commonRangeEquals, "$this$commonRangeEquals");
        Intrinsics.checkNotNullParameter(other, "other");
        if (i < 0 || i > commonRangeEquals.size() - i4 || i2 < 0 || i2 > other.length - i4) {
            return false;
        }
        int i5 = i4 + i;
        int iSegment = segment(commonRangeEquals, i);
        while (i < i5) {
            int i6 = iSegment == 0 ? 0 : commonRangeEquals.getDirectory()[iSegment - 1];
            int i7 = commonRangeEquals.getDirectory()[iSegment] - i6;
            int i8 = commonRangeEquals.getDirectory()[commonRangeEquals.getSegments().length + iSegment];
            int iMin = Math.min(i5, i7 + i6) - i;
            if (!Util.arrayRangeEquals(commonRangeEquals.getSegments()[iSegment], (i - i6) + i8, other, i2, iMin)) {
                return false;
            }
            i2 += iMin;
            i += iMin;
            iSegment++;
        }
        return true;
    }
}
