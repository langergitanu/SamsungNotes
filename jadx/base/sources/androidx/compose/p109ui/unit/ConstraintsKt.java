package androidx.compose.p109ui.unit;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.Stable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.Constraints;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementFormulasCmd;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u00008\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\b\u001a5\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u001a\u001a\u0018\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0003H\u0002\u001a\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0003H\u0002\u001a-\u0010 \u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0003H\u0000¢\u0006\u0002\u0010\u001a\u001a\u0011\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u0003H\u0082\b\u001a\u0011\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u0003H\u0082\b\u001a\u0018\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u0003H\u0002\u001a\u0010\u0010)\u001a\u00020*2\u0006\u0010\u001f\u001a\u00020\u0003H\u0002\u001a\u0010\u0010+\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0003H\u0002\u001a\u0011\u0010,\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u0003H\u0082\b\u001a\u0011\u0010-\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u0003H\u0082\b\u001a\u001c\u0010.\u001a\u00020\u0015*\u00020\u00152\u0006\u0010/\u001a\u00020\u0015ø\u0001\u0000¢\u0006\u0004\b0\u00101\u001a\u001e\u0010.\u001a\u000202*\u00020\u00152\u0006\u0010\u001f\u001a\u000202H\u0007ø\u0001\u0000¢\u0006\u0004\b3\u00101\u001a\u001e\u00104\u001a\u00020\u0003*\u00020\u00152\u0006\u00105\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b6\u00107\u001a\u001e\u00108\u001a\u00020\u0003*\u00020\u00152\u0006\u00109\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b:\u00107\u001a\u001e\u0010;\u001a\u00020<*\u00020\u00152\u0006\u0010\u001f\u001a\u000202H\u0007ø\u0001\u0000¢\u0006\u0004\b=\u0010>\u001a*\u0010?\u001a\u00020\u0015*\u00020\u00152\b\b\u0002\u0010@\u001a\u00020\u00032\b\b\u0002\u0010A\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\bB\u0010C\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006D"}, m13886d2 = {"FocusMask", "", "Infinity", "", "MaxAllowedForMaxFocusBits", "MaxAllowedForMaxNonFocusBits", "MaxAllowedForMinFocusBits", "MaxAllowedForMinNonFocusBits", "MaxFocusBits", "MaxFocusHeight", "MaxFocusMask", "MaxFocusWidth", "MaxNonFocusBits", "MaxNonFocusMask", "MinFocusBits", "MinFocusHeight", "MinFocusMask", "MinFocusWidth", "MinNonFocusBits", "MinNonFocusMask", Constraints.TAG, "Landroidx/compose/ui/unit/Constraints;", "minWidth", "maxWidth", "minHeight", "maxHeight", "(IIII)J", "addMaxWithMinimum", VElementFormulasCmd.FMAX, "value", "bitsNeedForSizeUnchecked", "size", "createConstraints", "heightMask", "bitOffset", "indexToBitOffset", "index", "invalidConstraint", "", "widthVal", "heightVal", "invalidSize", "", "maxAllowedForSize", "minHeightOffsets", "widthMask", "constrain", "otherConstraints", "constrain-N9IONVI", "(JJ)J", "Landroidx/compose/ui/unit/IntSize;", "constrain-4WqzIAM", "constrainHeight", "height", "constrainHeight-K40F9xA", "(JI)I", "constrainWidth", "width", "constrainWidth-K40F9xA", "isSatisfiedBy", "", "isSatisfiedBy-4WqzIAM", "(JJ)Z", TypedValues.Cycle.S_WAVE_OFFSET, "horizontal", "vertical", "offset-NN6Ew-U", "(JII)J", "ui-unit_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nConstraints.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Constraints.kt\nandroidx/compose/ui/unit/ConstraintsKt\n+ 2 InlineClassHelper.kt\nandroidx/compose/ui/unit/InlineClassHelperKt\n*L\n1#1,707:1\n686#1,9:708\n37#2,7:717\n37#2,7:724\n37#2,7:731\n*S KotlinDebug\n*F\n+ 1 Constraints.kt\nandroidx/compose/ui/unit/ConstraintsKt\n*L\n506#1:708,9\n549#1:717,7\n552#1:724,7\n555#1:731,7\n*E\n"})
public final class ConstraintsKt {
    private static final long FocusMask = 3;
    private static final int Infinity = Integer.MAX_VALUE;
    private static final int MaxAllowedForMaxFocusBits = 8190;
    private static final int MaxAllowedForMaxNonFocusBits = 262142;
    private static final int MaxAllowedForMinFocusBits = 32766;
    private static final int MaxAllowedForMinNonFocusBits = 65534;
    private static final int MaxFocusBits = 18;
    private static final int MaxFocusHeight = 0;
    private static final int MaxFocusMask = 262143;
    private static final int MaxFocusWidth = 3;
    private static final int MaxNonFocusBits = 13;
    private static final int MaxNonFocusMask = 8191;
    private static final int MinFocusBits = 16;
    private static final int MinFocusHeight = 1;
    private static final int MinFocusMask = 65535;
    private static final int MinFocusWidth = 2;
    private static final int MinNonFocusBits = 15;
    private static final int MinNonFocusMask = 32767;

    @Stable
    public static final long Constraints(int i, int i2, int i4, int i5) {
        boolean z = false;
        if (!(i2 >= i)) {
            InlineClassHelperKt.throwIllegalArgumentException("maxWidth(" + i2 + ") must be >= than minWidth(" + i + PropertyUtils.MAPPED_DELIM2);
        }
        if (!(i5 >= i4)) {
            InlineClassHelperKt.throwIllegalArgumentException("maxHeight(" + i5 + ") must be >= than minHeight(" + i4 + PropertyUtils.MAPPED_DELIM2);
        }
        if (i >= 0 && i4 >= 0) {
            z = true;
        }
        if (!z) {
            InlineClassHelperKt.throwIllegalArgumentException("minWidth(" + i + ") and minHeight(" + i4 + ") must be >= 0");
        }
        return createConstraints(i, i2, i4, i5);
    }

    public static /* synthetic */ long Constraints$default(int i, int i2, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = 0;
        }
        if ((i6 & 2) != 0) {
            i2 = Integer.MAX_VALUE;
        }
        if ((i6 & 4) != 0) {
            i4 = 0;
        }
        if ((i6 & 8) != 0) {
            i5 = Integer.MAX_VALUE;
        }
        return Constraints(i, i2, i4, i5);
    }

    private static final int addMaxWithMinimum(int i, int i2) {
        return i == Integer.MAX_VALUE ? i : RangesKt.coerceAtLeast(i + i2, 0);
    }

    private static final int bitsNeedForSizeUnchecked(int i) {
        if (i < MaxNonFocusMask) {
            return 13;
        }
        if (i < 32767) {
            return 15;
        }
        if (i < 65535) {
            return 16;
        }
        return i < MaxFocusMask ? 18 : 255;
    }

    @Stable
    /* JADX INFO: renamed from: constrain-4WqzIAM, reason: not valid java name */
    public static final long m20935constrain4WqzIAM(long j, long j2) {
        return IntSizeKt.IntSize(RangesKt.coerceIn(IntSize.m21138getWidthimpl(j2), Constraints.m20923getMinWidthimpl(j), Constraints.m20921getMaxWidthimpl(j)), RangesKt.coerceIn(IntSize.m21137getHeightimpl(j2), Constraints.m20922getMinHeightimpl(j), Constraints.m20920getMaxHeightimpl(j)));
    }

    /* JADX INFO: renamed from: constrain-N9IONVI, reason: not valid java name */
    public static final long m20936constrainN9IONVI(long j, long j2) {
        return Constraints(RangesKt.coerceIn(Constraints.m20923getMinWidthimpl(j2), Constraints.m20923getMinWidthimpl(j), Constraints.m20921getMaxWidthimpl(j)), RangesKt.coerceIn(Constraints.m20921getMaxWidthimpl(j2), Constraints.m20923getMinWidthimpl(j), Constraints.m20921getMaxWidthimpl(j)), RangesKt.coerceIn(Constraints.m20922getMinHeightimpl(j2), Constraints.m20922getMinHeightimpl(j), Constraints.m20920getMaxHeightimpl(j)), RangesKt.coerceIn(Constraints.m20920getMaxHeightimpl(j2), Constraints.m20922getMinHeightimpl(j), Constraints.m20920getMaxHeightimpl(j)));
    }

    @Stable
    /* JADX INFO: renamed from: constrainHeight-K40F9xA, reason: not valid java name */
    public static final int m20937constrainHeightK40F9xA(long j, int i) {
        return RangesKt.coerceIn(i, Constraints.m20922getMinHeightimpl(j), Constraints.m20920getMaxHeightimpl(j));
    }

    @Stable
    /* JADX INFO: renamed from: constrainWidth-K40F9xA, reason: not valid java name */
    public static final int m20938constrainWidthK40F9xA(long j, int i) {
        return RangesKt.coerceIn(i, Constraints.m20923getMinWidthimpl(j), Constraints.m20921getMaxWidthimpl(j));
    }

    public static final long createConstraints(int i, int i2, int i4, int i5) {
        int i6 = i5 == Integer.MAX_VALUE ? i4 : i5;
        int iBitsNeedForSizeUnchecked = bitsNeedForSizeUnchecked(i6);
        int i7 = i2 == Integer.MAX_VALUE ? i : i2;
        int iBitsNeedForSizeUnchecked2 = bitsNeedForSizeUnchecked(i7);
        if (iBitsNeedForSizeUnchecked + iBitsNeedForSizeUnchecked2 > 31) {
            invalidConstraint(i7, i6);
        }
        int i8 = i2 + 1;
        int i9 = i8 & (~(i8 >> 31));
        int i10 = i5 + 1;
        int i11 = i10 & (~(i10 >> 31));
        int i12 = 0;
        if (iBitsNeedForSizeUnchecked2 != 13) {
            if (iBitsNeedForSizeUnchecked2 == 18) {
                i12 = 3;
            } else if (iBitsNeedForSizeUnchecked2 == 15) {
                i12 = 1;
            } else if (iBitsNeedForSizeUnchecked2 == 16) {
                i12 = 2;
            }
        }
        int i13 = (((i12 & 2) >> 1) * 3) + ((i12 & 1) << 1);
        return Constraints.m20910constructorimpl((((long) i9) << 33) | ((long) i12) | (((long) i) << 2) | (((long) i4) << (i13 + 15)) | (((long) i11) << (i13 + 46)));
    }

    private static final int heightMask(int i) {
        return (1 << (18 - i)) - 1;
    }

    private static final int indexToBitOffset(int i) {
        return (((i & 2) >> 1) * 3) + ((i & 1) << 1);
    }

    private static final void invalidConstraint(int i, int i2) {
        throw new IllegalArgumentException(AbstractC0622a.m1164j(i, i2, "Can't represent a width of ", " and height of ", " in Constraints"));
    }

    private static final Void invalidSize(int i) {
        throw new IllegalArgumentException(AbstractC0541b.m767i(i, "Can't represent a size of ", " in Constraints"));
    }

    @Stable
    /* JADX INFO: renamed from: isSatisfiedBy-4WqzIAM, reason: not valid java name */
    public static final boolean m20939isSatisfiedBy4WqzIAM(long j, long j2) {
        int iM20923getMinWidthimpl = Constraints.m20923getMinWidthimpl(j);
        int iM20921getMaxWidthimpl = Constraints.m20921getMaxWidthimpl(j);
        int iM21138getWidthimpl = IntSize.m21138getWidthimpl(j2);
        if (iM20923getMinWidthimpl > iM21138getWidthimpl || iM21138getWidthimpl > iM20921getMaxWidthimpl) {
            return false;
        }
        int iM20922getMinHeightimpl = Constraints.m20922getMinHeightimpl(j);
        int iM20920getMaxHeightimpl = Constraints.m20920getMaxHeightimpl(j);
        int iM21137getHeightimpl = IntSize.m21137getHeightimpl(j2);
        return iM20922getMinHeightimpl <= iM21137getHeightimpl && iM21137getHeightimpl <= iM20920getMaxHeightimpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int maxAllowedForSize(int i) {
        if (i < MaxNonFocusMask) {
            return MaxAllowedForMaxNonFocusBits;
        }
        if (i < 32767) {
            return MaxAllowedForMinNonFocusBits;
        }
        if (i < 65535) {
            return MaxAllowedForMinFocusBits;
        }
        if (i < MaxFocusMask) {
            return MaxAllowedForMaxFocusBits;
        }
        invalidSize(i);
        throw new KotlinNothingValueException();
    }

    private static final int minHeightOffsets(int i) {
        return i + 15;
    }

    @Stable
    /* JADX INFO: renamed from: offset-NN6Ew-U, reason: not valid java name */
    public static final long m20940offsetNN6EwU(long j, int i, int i2) {
        return Constraints(RangesKt.coerceAtLeast(Constraints.m20923getMinWidthimpl(j) + i, 0), addMaxWithMinimum(Constraints.m20921getMaxWidthimpl(j), i), RangesKt.coerceAtLeast(Constraints.m20922getMinHeightimpl(j) + i2, 0), addMaxWithMinimum(Constraints.m20920getMaxHeightimpl(j), i2));
    }

    /* JADX INFO: renamed from: offset-NN6Ew-U$default, reason: not valid java name */
    public static /* synthetic */ long m20941offsetNN6EwU$default(long j, int i, int i2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = 0;
        }
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        return m20940offsetNN6EwU(j, i, i2);
    }

    private static final int widthMask(int i) {
        return (1 << (i + 13)) - 1;
    }
}
