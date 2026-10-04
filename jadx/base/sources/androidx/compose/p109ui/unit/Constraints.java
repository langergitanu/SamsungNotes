package androidx.compose.p109ui.unit;

import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.p109ui.ExperimentalComposeUiApi;
import androidx.compose.runtime.AbstractC1974b;
import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b!\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 02\u00020\u0001:\u00010B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J;\u0010#\u001a\u00020\u00002\b\b\u0002\u0010 \u001a\u00020\u00072\b\b\u0002\u0010\u001c\u001a\u00020\u00072\b\b\u0002\u0010\u001e\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b$\u0010%J\u001a\u0010&\u001a\u00020\u000b2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b(\u0010)J\u0010\u0010*\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b+\u0010\tJ\u000f\u0010,\u001a\u00020-H\u0016¢\u0006\u0004\b.\u0010/R\u0015\u0010\u0006\u001a\u00020\u00078Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u001a\u0010\u0010\u001a\u00020\u000b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\rR\u001a\u0010\u0014\u001a\u00020\u000b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\rR\u001a\u0010\u0017\u001a\u00020\u000b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\rR\u0011\u0010\u001a\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\tR\u0011\u0010\u001c\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\tR\u0011\u0010\u001e\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\tR\u0011\u0010 \u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b!\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\"\u0010\u0012\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u00061"}, m13886d2 = {"Landroidx/compose/ui/unit/Constraints;", "", "value", "", "constructor-impl", "(J)J", "focusIndex", "", "getFocusIndex-impl", "(J)I", "hasBoundedHeight", "", "getHasBoundedHeight-impl", "(J)Z", "hasBoundedWidth", "getHasBoundedWidth-impl", "hasFixedHeight", "getHasFixedHeight$annotations", "()V", "getHasFixedHeight-impl", "hasFixedWidth", "getHasFixedWidth$annotations", "getHasFixedWidth-impl", "isZero", "isZero$annotations", "isZero-impl", "maxHeight", "getMaxHeight-impl", "maxWidth", "getMaxWidth-impl", "minHeight", "getMinHeight-impl", "minWidth", "getMinWidth-impl", "getValue$annotations", "copy", "copy-Zbe2FdA", "(JIIII)J", "equals", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "ui-unit_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@Immutable
@JvmInline
@SourceDebugExtension({"SMAP\nConstraints.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Constraints.kt\nandroidx/compose/ui/unit/Constraints\n+ 2 Constraints.kt\nandroidx/compose/ui/unit/ConstraintsKt\n+ 3 InlineClassHelper.kt\nandroidx/compose/ui/unit/InlineClassHelperKt\n*L\n1#1,707:1\n69#1:708\n69#1:711\n69#1:714\n69#1:718\n69#1:722\n69#1:725\n69#1:729\n69#1:732\n69#1:736\n686#2:709\n700#2:710\n686#2:712\n700#2:713\n686#2:715\n706#2:716\n694#2:717\n686#2:719\n706#2:720\n694#2:721\n686#2:723\n700#2:724\n686#2:726\n706#2:727\n694#2:728\n686#2:730\n700#2:731\n686#2:733\n706#2:734\n694#2:735\n686#2:737\n700#2:738\n694#2:739\n706#2:740\n37#3,7:741\n37#3,7:748\n37#3,7:755\n*S KotlinDebug\n*F\n+ 1 Constraints.kt\nandroidx/compose/ui/unit/Constraints\n*L\n76#1:708\n86#1:711\n96#1:714\n108#1:718\n121#1:722\n131#1:725\n142#1:729\n155#1:732\n171#1:736\n76#1:709\n76#1:710\n86#1:712\n86#1:713\n96#1:715\n97#1:716\n98#1:717\n108#1:719\n109#1:720\n110#1:721\n121#1:723\n121#1:724\n131#1:726\n132#1:727\n133#1:728\n142#1:730\n142#1:731\n155#1:733\n156#1:734\n157#1:735\n171#1:737\n175#1:738\n179#1:739\n180#1:740\n196#1:741,7\n200#1:748,7\n204#1:755,7\n*E\n"})
public final class Constraints {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int Infinity = Integer.MAX_VALUE;
    private final long value;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J5\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\fJ5\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\fJ%\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0004H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0004H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0016J?\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u001a\u001a\u00020\u001bH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u001e"}, m13886d2 = {"Landroidx/compose/ui/unit/Constraints$Companion;", "", "()V", "Infinity", "", "fitPrioritizingHeight", "Landroidx/compose/ui/unit/Constraints;", "minWidth", "maxWidth", "minHeight", "maxHeight", "fitPrioritizingHeight-Zbe2FdA", "(IIII)J", "fitPrioritizingWidth", "fitPrioritizingWidth-Zbe2FdA", "fixed", "width", "height", "fixed-JhjzzOo", "(II)J", "fixedHeight", "fixedHeight-OenEA2s", "(I)J", "fixedWidth", "fixedWidth-OenEA2s", "restrictConstraints", "prioritizeWidth", "", "restrictConstraints-xF2OJ5Q", "(IIIIZ)J", "ui-unit_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nConstraints.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Constraints.kt\nandroidx/compose/ui/unit/Constraints$Companion\n+ 2 InlineClassHelper.kt\nandroidx/compose/ui/unit/InlineClassHelperKt\n*L\n1#1,707:1\n37#2,7:708\n37#2,7:715\n37#2,7:722\n*S KotlinDebug\n*F\n+ 1 Constraints.kt\nandroidx/compose/ui/unit/Constraints$Companion\n*L\n235#1:708,7\n248#1:715,7\n266#1:722,7\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: restrictConstraints-xF2OJ5Q$default, reason: not valid java name */
        public static /* synthetic */ long m20928restrictConstraintsxF2OJ5Q$default(Companion companion, int i, int i2, int i4, int i5, boolean z, int i6, Object obj) {
            if ((i6 & 16) != 0) {
                z = true;
            }
            return companion.m20934restrictConstraintsxF2OJ5Q(i, i2, i4, i5, z);
        }

        @Stable
        /* JADX INFO: renamed from: fitPrioritizingHeight-Zbe2FdA, reason: not valid java name */
        public final long m20929fitPrioritizingHeightZbe2FdA(int minWidth, int maxWidth, int minHeight, int maxHeight) {
            int iMin = Math.min(minHeight, 262142);
            int iMin2 = maxHeight == Integer.MAX_VALUE ? Integer.MAX_VALUE : Math.min(maxHeight, 262142);
            int iMaxAllowedForSize = ConstraintsKt.maxAllowedForSize(iMin2 == Integer.MAX_VALUE ? iMin : iMin2);
            return ConstraintsKt.Constraints(Math.min(iMaxAllowedForSize, minWidth), maxWidth != Integer.MAX_VALUE ? Math.min(iMaxAllowedForSize, maxWidth) : Integer.MAX_VALUE, iMin, iMin2);
        }

        @Stable
        /* JADX INFO: renamed from: fitPrioritizingWidth-Zbe2FdA, reason: not valid java name */
        public final long m20930fitPrioritizingWidthZbe2FdA(int minWidth, int maxWidth, int minHeight, int maxHeight) {
            int iMin = Math.min(minWidth, 262142);
            int iMin2 = maxWidth == Integer.MAX_VALUE ? Integer.MAX_VALUE : Math.min(maxWidth, 262142);
            int iMaxAllowedForSize = ConstraintsKt.maxAllowedForSize(iMin2 == Integer.MAX_VALUE ? iMin : iMin2);
            return ConstraintsKt.Constraints(iMin, iMin2, Math.min(iMaxAllowedForSize, minHeight), maxHeight != Integer.MAX_VALUE ? Math.min(iMaxAllowedForSize, maxHeight) : Integer.MAX_VALUE);
        }

        @Stable
        /* JADX INFO: renamed from: fixed-JhjzzOo, reason: not valid java name */
        public final long m20931fixedJhjzzOo(int width, int height) {
            if (!(width >= 0 && height >= 0)) {
                InlineClassHelperKt.throwIllegalArgumentException("width(" + width + ") and height(" + height + ") must be >= 0");
            }
            return ConstraintsKt.createConstraints(width, width, height, height);
        }

        @Stable
        /* JADX INFO: renamed from: fixedHeight-OenEA2s, reason: not valid java name */
        public final long m20932fixedHeightOenEA2s(int height) {
            if (!(height >= 0)) {
                InlineClassHelperKt.throwIllegalArgumentException("height(" + height + ") must be >= 0");
            }
            return ConstraintsKt.createConstraints(0, Integer.MAX_VALUE, height, height);
        }

        @Stable
        /* JADX INFO: renamed from: fixedWidth-OenEA2s, reason: not valid java name */
        public final long m20933fixedWidthOenEA2s(int width) {
            if (!(width >= 0)) {
                InlineClassHelperKt.throwIllegalArgumentException("width(" + width + ") must be >= 0");
            }
            return ConstraintsKt.createConstraints(width, width, 0, Integer.MAX_VALUE);
        }

        @Stable
        @Deprecated(message = "Replace with fitPrioritizingWidth", replaceWith = @ReplaceWith(expression = "Constraints.fitPrioritizingWidth(minWidth, maxWidth, minHeight, maxHeight)", imports = {}))
        @ExperimentalComposeUiApi
        /* JADX INFO: renamed from: restrictConstraints-xF2OJ5Q, reason: not valid java name */
        public final long m20934restrictConstraintsxF2OJ5Q(int minWidth, int maxWidth, int minHeight, int maxHeight, boolean prioritizeWidth) {
            return prioritizeWidth ? m20930fitPrioritizingWidthZbe2FdA(minWidth, maxWidth, minHeight, maxHeight) : m20929fitPrioritizingHeightZbe2FdA(minWidth, maxWidth, minHeight, maxHeight);
        }

        private Companion() {
        }
    }

    private /* synthetic */ Constraints(long j) {
        this.value = j;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Constraints m20909boximpl(long j) {
        return new Constraints(j);
    }

    /* JADX INFO: renamed from: copy-Zbe2FdA, reason: not valid java name */
    public static final long m20911copyZbe2FdA(long j, int i, int i2, int i4, int i5) {
        if (!(i4 >= 0 && i >= 0)) {
            InlineClassHelperKt.throwIllegalArgumentException("minHeight(" + i4 + ") and minWidth(" + i + ") must be >= 0");
        }
        if (!(i2 >= i)) {
            InlineClassHelperKt.throwIllegalArgumentException("maxWidth(" + i2 + ") must be >= minWidth(" + i + PropertyUtils.MAPPED_DELIM2);
        }
        if (!(i5 >= i4)) {
            InlineClassHelperKt.throwIllegalArgumentException("maxHeight(" + i5 + ") must be >= minHeight(" + i4 + PropertyUtils.MAPPED_DELIM2);
        }
        return ConstraintsKt.createConstraints(i, i2, i4, i5);
    }

    /* JADX INFO: renamed from: copy-Zbe2FdA$default, reason: not valid java name */
    public static /* synthetic */ long m20912copyZbe2FdA$default(long j, int i, int i2, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = m20923getMinWidthimpl(j);
        }
        int i7 = i;
        if ((i6 & 2) != 0) {
            i2 = m20921getMaxWidthimpl(j);
        }
        int i8 = i2;
        if ((i6 & 4) != 0) {
            i4 = m20922getMinHeightimpl(j);
        }
        int i9 = i4;
        if ((i6 & 8) != 0) {
            i5 = m20920getMaxHeightimpl(j);
        }
        return m20911copyZbe2FdA(j, i7, i8, i9, i5);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m20913equalsimpl(long j, Object obj) {
        return (obj instanceof Constraints) && j == ((Constraints) obj).getValue();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m20914equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* JADX INFO: renamed from: getFocusIndex-impl, reason: not valid java name */
    private static final int m20915getFocusIndeximpl(long j) {
        return (int) (j & 3);
    }

    /* JADX INFO: renamed from: getHasBoundedHeight-impl, reason: not valid java name */
    public static final boolean m20916getHasBoundedHeightimpl(long j) {
        int i = (int) (3 & j);
        int i2 = (((i & 2) >> 1) * 3) + ((i & 1) << 1);
        return (((int) (j >> (i2 + 46))) & ((1 << (18 - i2)) - 1)) != 0;
    }

    /* JADX INFO: renamed from: getHasBoundedWidth-impl, reason: not valid java name */
    public static final boolean m20917getHasBoundedWidthimpl(long j) {
        int i = (int) (3 & j);
        return (((int) (j >> 33)) & ((1 << AbstractC1974b.m1310c((i & 2) >> 1, 3, (i & 1) << 1, 13)) - 1)) != 0;
    }

    /* JADX INFO: renamed from: getHasFixedHeight-impl, reason: not valid java name */
    public static final boolean m20918getHasFixedHeightimpl(long j) {
        int i = (int) (3 & j);
        int i2 = (((i & 2) >> 1) * 3) + ((i & 1) << 1);
        int i4 = (1 << (18 - i2)) - 1;
        int i5 = ((int) (j >> (i2 + 15))) & i4;
        int i6 = ((int) (j >> (i2 + 46))) & i4;
        return i5 == (i6 == 0 ? Integer.MAX_VALUE : i6 - 1);
    }

    /* JADX INFO: renamed from: getHasFixedWidth-impl, reason: not valid java name */
    public static final boolean m20919getHasFixedWidthimpl(long j) {
        int i = (int) (3 & j);
        int iM1310c = (1 << AbstractC1974b.m1310c((i & 2) >> 1, 3, (i & 1) << 1, 13)) - 1;
        int i2 = ((int) (j >> 2)) & iM1310c;
        int i4 = ((int) (j >> 33)) & iM1310c;
        return i2 == (i4 == 0 ? Integer.MAX_VALUE : i4 - 1);
    }

    /* JADX INFO: renamed from: getMaxHeight-impl, reason: not valid java name */
    public static final int m20920getMaxHeightimpl(long j) {
        int i = (int) (3 & j);
        int i2 = (((i & 2) >> 1) * 3) + ((i & 1) << 1);
        int i4 = ((int) (j >> (i2 + 46))) & ((1 << (18 - i2)) - 1);
        if (i4 == 0) {
            return Integer.MAX_VALUE;
        }
        return i4 - 1;
    }

    /* JADX INFO: renamed from: getMaxWidth-impl, reason: not valid java name */
    public static final int m20921getMaxWidthimpl(long j) {
        int i = (int) (3 & j);
        int i2 = (int) (j >> 33);
        int iM1310c = i2 & ((1 << AbstractC1974b.m1310c((i & 2) >> 1, 3, (i & 1) << 1, 13)) - 1);
        if (iM1310c == 0) {
            return Integer.MAX_VALUE;
        }
        return iM1310c - 1;
    }

    /* JADX INFO: renamed from: getMinHeight-impl, reason: not valid java name */
    public static final int m20922getMinHeightimpl(long j) {
        int i = (int) (3 & j);
        int i2 = (((i & 2) >> 1) * 3) + ((i & 1) << 1);
        return ((int) (j >> (i2 + 15))) & ((1 << (18 - i2)) - 1);
    }

    /* JADX INFO: renamed from: getMinWidth-impl, reason: not valid java name */
    public static final int m20923getMinWidthimpl(long j) {
        int i = (int) (3 & j);
        return ((int) (j >> 2)) & ((1 << AbstractC1974b.m1310c((i & 2) >> 1, 3, (i & 1) << 1, 13)) - 1);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m20924hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    /* JADX INFO: renamed from: isZero-impl, reason: not valid java name */
    public static final boolean m20925isZeroimpl(long j) {
        int i = (int) (3 & j);
        int i2 = (((i & 2) >> 1) * 3) + ((i & 1) << 1);
        return (((int) (j >> 33)) & ((1 << (i2 + 13)) - 1)) - 1 == 0 || (((int) (j >> (i2 + 46))) & ((1 << (18 - i2)) - 1)) - 1 == 0;
    }

    @NotNull
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m20926toStringimpl(long j) {
        int iM20921getMaxWidthimpl = m20921getMaxWidthimpl(j);
        String strValueOf = iM20921getMaxWidthimpl == Integer.MAX_VALUE ? "Infinity" : String.valueOf(iM20921getMaxWidthimpl);
        int iM20920getMaxHeightimpl = m20920getMaxHeightimpl(j);
        String strValueOf2 = iM20920getMaxHeightimpl != Integer.MAX_VALUE ? String.valueOf(iM20920getMaxHeightimpl) : "Infinity";
        StringBuilder sb = new StringBuilder("Constraints(minWidth = ");
        sb.append(m20923getMinWidthimpl(j));
        sb.append(", maxWidth = ");
        sb.append(strValueOf);
        sb.append(", minHeight = ");
        sb.append(m20922getMinHeightimpl(j));
        sb.append(", maxHeight = ");
        return AbstractC1038a.m1213n(PropertyUtils.MAPPED_DELIM2, strValueOf2, sb);
    }

    public boolean equals(Object obj) {
        return m20913equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m20924hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m20926toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getValue() {
        return this.value;
    }

    @Stable
    public static /* synthetic */ void getHasFixedHeight$annotations() {
    }

    @Stable
    public static /* synthetic */ void getHasFixedWidth$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getValue$annotations() {
    }

    @Stable
    public static /* synthetic */ void isZero$annotations() {
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m20910constructorimpl(long j) {
        return j;
    }
}
