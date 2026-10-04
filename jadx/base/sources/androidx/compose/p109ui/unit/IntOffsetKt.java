package androidx.compose.p109ui.unit;

import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.geometry.OffsetKt;
import androidx.compose.p109ui.util.MathHelpersKt;
import androidx.compose.runtime.Stable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0005\u001a*\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\nH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u001f\u0010\r\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0001H\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u001f\u0010\r\u001a\u00020\u000e*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u000eH\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0011\u001a\u001f\u0010\u0013\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0001H\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0011\u001a\u001f\u0010\u0013\u001a\u00020\u000e*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u000eH\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0011\u001a\u0016\u0010\u0016\u001a\u00020\u0001*\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0017\u0010\u0019\u001a\u00020\u000e*\u00020\u0001H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0018\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001b"}, m13886d2 = {"IntOffset", "Landroidx/compose/ui/unit/IntOffset;", "x", "", "y", "(II)J", "lerp", "start", "stop", "fraction", "", "lerp-81ZRxRo", "(JJF)J", "minus", "Landroidx/compose/ui/geometry/Offset;", TypedValues.Cycle.S_WAVE_OFFSET, "minus-Nv-tHpc", "(JJ)J", "minus-oCl6YwE", "plus", "plus-Nv-tHpc", "plus-oCl6YwE", "round", "round-k-4lQ0M", "(J)J", "toOffset", "toOffset--gyyYBs", "ui-unit_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nIntOffset.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IntOffset.kt\nandroidx/compose/ui/unit/IntOffsetKt\n+ 2 InlineClassHelper.kt\nandroidx/compose/ui/util/InlineClassHelperKt\n+ 3 InlineClassHelper.jvm.kt\nandroidx/compose/ui/util/InlineClassHelper_jvmKt\n*L\n1#1,199:1\n100#2:200\n100#2:201\n100#2:203\n26#3:202\n*S KotlinDebug\n*F\n+ 1 IntOffset.kt\nandroidx/compose/ui/unit/IntOffsetKt\n*L\n35#1:200\n166#1:201\n198#1:203\n198#1:202\n*E\n"})
public final class IntOffsetKt {
    @Stable
    public static final long IntOffset(int i, int i2) {
        return IntOffset.m21090constructorimpl((((long) i2) & 4294967295L) | (((long) i) << 32));
    }

    @Stable
    /* JADX INFO: renamed from: lerp-81ZRxRo, reason: not valid java name */
    public static final long m21107lerp81ZRxRo(long j, long j2, float f) {
        return IntOffset.m21090constructorimpl((((long) MathHelpersKt.lerp(IntOffset.m21096getXimpl(j), IntOffset.m21096getXimpl(j2), f)) << 32) | (((long) MathHelpersKt.lerp(IntOffset.m21097getYimpl(j), IntOffset.m21097getYimpl(j2), f)) & 4294967295L));
    }

    @Stable
    /* JADX INFO: renamed from: minus-Nv-tHpc, reason: not valid java name */
    public static final long m21108minusNvtHpc(long j, long j2) {
        return OffsetKt.Offset(Offset.m18284getXimpl(j) - IntOffset.m21096getXimpl(j2), Offset.m18285getYimpl(j) - IntOffset.m21097getYimpl(j2));
    }

    @Stable
    /* JADX INFO: renamed from: minus-oCl6YwE, reason: not valid java name */
    public static final long m21109minusoCl6YwE(long j, long j2) {
        return OffsetKt.Offset(IntOffset.m21096getXimpl(j) - Offset.m18284getXimpl(j2), IntOffset.m21097getYimpl(j) - Offset.m18285getYimpl(j2));
    }

    @Stable
    /* JADX INFO: renamed from: plus-Nv-tHpc, reason: not valid java name */
    public static final long m21110plusNvtHpc(long j, long j2) {
        return OffsetKt.Offset(Offset.m18284getXimpl(j) + IntOffset.m21096getXimpl(j2), Offset.m18285getYimpl(j) + IntOffset.m21097getYimpl(j2));
    }

    @Stable
    /* JADX INFO: renamed from: plus-oCl6YwE, reason: not valid java name */
    public static final long m21111plusoCl6YwE(long j, long j2) {
        return OffsetKt.Offset(Offset.m18284getXimpl(j2) + IntOffset.m21096getXimpl(j), Offset.m18285getYimpl(j2) + IntOffset.m21097getYimpl(j));
    }

    @Stable
    /* JADX INFO: renamed from: round-k-4lQ0M, reason: not valid java name */
    public static final long m21112roundk4lQ0M(long j) {
        int iRound = Math.round(Offset.m18284getXimpl(j));
        return IntOffset.m21090constructorimpl((((long) Math.round(Offset.m18285getYimpl(j))) & 4294967295L) | (((long) iRound) << 32));
    }

    @Stable
    /* JADX INFO: renamed from: toOffset--gyyYBs, reason: not valid java name */
    public static final long m21113toOffsetgyyYBs(long j) {
        return OffsetKt.Offset(IntOffset.m21096getXimpl(j), IntOffset.m21097getYimpl(j));
    }
}
