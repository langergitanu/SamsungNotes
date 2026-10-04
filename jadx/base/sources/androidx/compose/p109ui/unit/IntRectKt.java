package androidx.compose.p109ui.unit;

import androidx.compose.p109ui.geometry.Rect;
import androidx.compose.p109ui.util.MathHelpersKt;
import androidx.compose.runtime.Stable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u0006\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a \u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0014H\u0007\u001a\f\u0010\u0015\u001a\u00020\u0001*\u00020\u0016H\u0007\u001a\f\u0010\u0017\u001a\u00020\u0016*\u00020\u0001H\u0007\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0018"}, m13886d2 = {"IntRect", "Landroidx/compose/ui/unit/IntRect;", "topLeft", "Landroidx/compose/ui/unit/IntOffset;", "bottomRight", "IntRect-E1MhUcY", "(JJ)Landroidx/compose/ui/unit/IntRect;", TypedValues.Cycle.S_WAVE_OFFSET, "size", "Landroidx/compose/ui/unit/IntSize;", "IntRect-VbeCjmY", "center", "radius", "", "IntRect-ar5cAso", "(JI)Landroidx/compose/ui/unit/IntRect;", "lerp", "start", "stop", "fraction", "", "roundToIntRect", "Landroidx/compose/ui/geometry/Rect;", "toRect", "ui-unit_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nIntRect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IntRect.kt\nandroidx/compose/ui/unit/IntRectKt\n+ 2 InlineClassHelper.jvm.kt\nandroidx/compose/ui/util/InlineClassHelper_jvmKt\n*L\n1#1,335:1\n26#2:336\n26#2:337\n26#2:338\n26#2:339\n*S KotlinDebug\n*F\n+ 1 IntRect.kt\nandroidx/compose/ui/unit/IntRectKt\n*L\n330#1:336\n331#1:337\n332#1:338\n333#1:339\n*E\n"})
public final class IntRectKt {
    @Stable
    @NotNull
    /* JADX INFO: renamed from: IntRect-E1MhUcY, reason: not valid java name */
    public static final IntRect m21127IntRectE1MhUcY(long j, long j2) {
        return new IntRect(IntOffset.m21096getXimpl(j), IntOffset.m21097getYimpl(j), IntOffset.m21096getXimpl(j2), IntOffset.m21097getYimpl(j2));
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: IntRect-VbeCjmY, reason: not valid java name */
    public static final IntRect m21128IntRectVbeCjmY(long j, long j2) {
        return new IntRect(IntOffset.m21096getXimpl(j), IntOffset.m21097getYimpl(j), IntSize.m21138getWidthimpl(j2) + IntOffset.m21096getXimpl(j), IntSize.m21137getHeightimpl(j2) + IntOffset.m21097getYimpl(j));
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: IntRect-ar5cAso, reason: not valid java name */
    public static final IntRect m21129IntRectar5cAso(long j, int i) {
        return new IntRect(IntOffset.m21096getXimpl(j) - i, IntOffset.m21097getYimpl(j) - i, IntOffset.m21096getXimpl(j) + i, IntOffset.m21097getYimpl(j) + i);
    }

    @Stable
    @NotNull
    public static final IntRect lerp(@NotNull IntRect intRect, @NotNull IntRect intRect2, float f) {
        return new IntRect(MathHelpersKt.lerp(intRect.getLeft(), intRect2.getLeft(), f), MathHelpersKt.lerp(intRect.getTop(), intRect2.getTop(), f), MathHelpersKt.lerp(intRect.getRight(), intRect2.getRight(), f), MathHelpersKt.lerp(intRect.getBottom(), intRect2.getBottom(), f));
    }

    @Stable
    @NotNull
    public static final IntRect roundToIntRect(@NotNull Rect rect) {
        return new IntRect(Math.round(rect.getLeft()), Math.round(rect.getTop()), Math.round(rect.getRight()), Math.round(rect.getBottom()));
    }

    @Stable
    @NotNull
    public static final Rect toRect(@NotNull IntRect intRect) {
        return new Rect(intRect.getLeft(), intRect.getTop(), intRect.getRight(), intRect.getBottom());
    }
}
