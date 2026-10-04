package androidx.compose.foundation.layout;

import androidx.compose.p109ui.unit.Constraints;
import androidx.compose.p109ui.unit.ConstraintsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0081@\u0018\u00002\u00020\u0001B)\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bB\u0019\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\u0007\u0010\rB\u0011\b\u0002\u0012\u0006\u0010\u000e\u001a\u00020\n¢\u0006\u0004\b\u0007\u0010\u000fJ;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u001f\u0010\u0011J\u0015\u0010 \u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b!\u0010\"J\u0015\u0010#\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b$\u0010\"J\u0013\u0010%\u001a\u00020\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b&\u0010\u000fJ\u001b\u0010'\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b(\u0010\rJ\u0010\u0010)\u001a\u00020*HÖ\u0001¢\u0006\u0004\b+\u0010,R\u0012\u0010\u0006\u001a\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0005\u001a\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0011R\u0012\u0010\u0004\u001a\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u0012\u0010\u0002\u001a\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0011R\u0016\u0010\u000e\u001a\u00020\nX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0015\u0088\u0001\u000e\u0092\u0001\u00020\n\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006-"}, m13886d2 = {"Landroidx/compose/foundation/layout/OrientationIndependentConstraints;", "", "mainAxisMin", "", "mainAxisMax", "crossAxisMin", "crossAxisMax", "constructor-impl", "(IIII)J", "c", "Landroidx/compose/ui/unit/Constraints;", "orientation", "Landroidx/compose/foundation/layout/LayoutOrientation;", "(JLandroidx/compose/foundation/layout/LayoutOrientation;)J", "value", "(J)J", "getCrossAxisMax-impl", "(J)I", "getCrossAxisMin-impl", "getMainAxisMax-impl", "getMainAxisMin-impl", "J", "copy", "copy-yUG9Ft0", "(JIIII)J", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "maxHeight", "maxHeight-impl", "(JLandroidx/compose/foundation/layout/LayoutOrientation;)I", "maxWidth", "maxWidth-impl", "stretchCrossAxis", "stretchCrossAxis-q4ezo7Y", "toBoxConstraints", "toBoxConstraints-OenEA2s", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "foundation-layout_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@JvmInline
@SourceDebugExtension({"SMAP\nRowColumnImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RowColumnImpl.kt\nandroidx/compose/foundation/layout/OrientationIndependentConstraints\n*L\n1#1,723:1\n229#1:724\n230#1:725\n232#1:726\n231#1:727\n232#1:728\n229#1,4:729\n231#1,2:733\n229#1,2:735\n230#1:737\n232#1:738\n232#1:739\n230#1:740\n229#1:741\n230#1:742\n231#1:743\n232#1:744\n*S KotlinDebug\n*F\n+ 1 RowColumnImpl.kt\nandroidx/compose/foundation/layout/OrientationIndependentConstraints\n*L\n257#1:724\n258#1:725\n259#1:726\n259#1:727\n260#1:728\n266#1:729,4\n268#1:733,2\n268#1:735,2\n274#1:737\n276#1:738\n282#1:739\n284#1:740\n288#1:741\n289#1:742\n290#1:743\n291#1:744\n*E\n"})
public final class OrientationIndependentConstraints {
    private final long value;

    private /* synthetic */ OrientationIndependentConstraints(long j) {
        this.value = j;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ OrientationIndependentConstraints m15820boximpl(long j) {
        return new OrientationIndependentConstraints(j);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static long m15822constructorimpl(long j) {
        return j;
    }

    /* JADX INFO: renamed from: copy-yUG9Ft0, reason: not valid java name */
    public static final long m15824copyyUG9Ft0(long j, int i, int i2, int i4, int i5) {
        return m15821constructorimpl(i, i2, i4, i5);
    }

    /* JADX INFO: renamed from: copy-yUG9Ft0$default, reason: not valid java name */
    public static /* synthetic */ long m15825copyyUG9Ft0$default(long j, int i, int i2, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = Constraints.m20923getMinWidthimpl(j);
        }
        int i7 = i;
        if ((i6 & 2) != 0) {
            i2 = Constraints.m20921getMaxWidthimpl(j);
        }
        int i8 = i2;
        if ((i6 & 4) != 0) {
            i4 = Constraints.m20922getMinHeightimpl(j);
        }
        int i9 = i4;
        if ((i6 & 8) != 0) {
            i5 = Constraints.m20920getMaxHeightimpl(j);
        }
        return m15824copyyUG9Ft0(j, i7, i8, i9, i5);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m15826equalsimpl(long j, Object obj) {
        return (obj instanceof OrientationIndependentConstraints) && Constraints.m20914equalsimpl0(j, ((OrientationIndependentConstraints) obj).getValue());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m15827equalsimpl0(long j, long j2) {
        return Constraints.m20914equalsimpl0(j, j2);
    }

    /* JADX INFO: renamed from: getCrossAxisMax-impl, reason: not valid java name */
    public static final int m15828getCrossAxisMaximpl(long j) {
        return Constraints.m20920getMaxHeightimpl(j);
    }

    /* JADX INFO: renamed from: getCrossAxisMin-impl, reason: not valid java name */
    public static final int m15829getCrossAxisMinimpl(long j) {
        return Constraints.m20922getMinHeightimpl(j);
    }

    /* JADX INFO: renamed from: getMainAxisMax-impl, reason: not valid java name */
    public static final int m15830getMainAxisMaximpl(long j) {
        return Constraints.m20921getMaxWidthimpl(j);
    }

    /* JADX INFO: renamed from: getMainAxisMin-impl, reason: not valid java name */
    public static final int m15831getMainAxisMinimpl(long j) {
        return Constraints.m20923getMinWidthimpl(j);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m15832hashCodeimpl(long j) {
        return Constraints.m20924hashCodeimpl(j);
    }

    /* JADX INFO: renamed from: maxHeight-impl, reason: not valid java name */
    public static final int m15833maxHeightimpl(long j, @NotNull LayoutOrientation layoutOrientation) {
        return layoutOrientation == LayoutOrientation.Horizontal ? Constraints.m20920getMaxHeightimpl(j) : Constraints.m20921getMaxWidthimpl(j);
    }

    /* JADX INFO: renamed from: maxWidth-impl, reason: not valid java name */
    public static final int m15834maxWidthimpl(long j, @NotNull LayoutOrientation layoutOrientation) {
        return layoutOrientation == LayoutOrientation.Horizontal ? Constraints.m20921getMaxWidthimpl(j) : Constraints.m20920getMaxHeightimpl(j);
    }

    /* JADX INFO: renamed from: stretchCrossAxis-q4ezo7Y, reason: not valid java name */
    public static final long m15835stretchCrossAxisq4ezo7Y(long j) {
        return m15821constructorimpl(Constraints.m20923getMinWidthimpl(j), Constraints.m20921getMaxWidthimpl(j), Constraints.m20920getMaxHeightimpl(j) != Integer.MAX_VALUE ? Constraints.m20920getMaxHeightimpl(j) : Constraints.m20922getMinHeightimpl(j), Constraints.m20920getMaxHeightimpl(j));
    }

    /* JADX INFO: renamed from: toBoxConstraints-OenEA2s, reason: not valid java name */
    public static final long m15836toBoxConstraintsOenEA2s(long j, @NotNull LayoutOrientation layoutOrientation) {
        return layoutOrientation == LayoutOrientation.Horizontal ? ConstraintsKt.Constraints(Constraints.m20923getMinWidthimpl(j), Constraints.m20921getMaxWidthimpl(j), Constraints.m20922getMinHeightimpl(j), Constraints.m20920getMaxHeightimpl(j)) : ConstraintsKt.Constraints(Constraints.m20922getMinHeightimpl(j), Constraints.m20920getMaxHeightimpl(j), Constraints.m20923getMinWidthimpl(j), Constraints.m20921getMaxWidthimpl(j));
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m15837toStringimpl(long j) {
        return "OrientationIndependentConstraints(value=" + ((Object) Constraints.m20926toStringimpl(j)) + PropertyUtils.MAPPED_DELIM2;
    }

    public boolean equals(Object obj) {
        return m15826equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m15832hashCodeimpl(this.value);
    }

    public String toString() {
        return m15837toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getValue() {
        return this.value;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m15821constructorimpl(int i, int i2, int i4, int i5) {
        return m15822constructorimpl(ConstraintsKt.Constraints(i, i2, i4, i5));
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m15823constructorimpl(long j, @NotNull LayoutOrientation layoutOrientation) {
        LayoutOrientation layoutOrientation2 = LayoutOrientation.Horizontal;
        return m15821constructorimpl(layoutOrientation == layoutOrientation2 ? Constraints.m20923getMinWidthimpl(j) : Constraints.m20922getMinHeightimpl(j), layoutOrientation == layoutOrientation2 ? Constraints.m20921getMaxWidthimpl(j) : Constraints.m20920getMaxHeightimpl(j), layoutOrientation == layoutOrientation2 ? Constraints.m20922getMinHeightimpl(j) : Constraints.m20923getMinWidthimpl(j), layoutOrientation == layoutOrientation2 ? Constraints.m20920getMaxHeightimpl(j) : Constraints.m20921getMaxWidthimpl(j));
    }
}
