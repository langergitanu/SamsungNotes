package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.selection.SelectionManagerKt;
import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.geometry.Rect;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u001a#\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004H\u0080\b\u001a\u001e\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a&\u0010\f\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0000ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a#\u0010\u0011\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004H\u0080\b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0012"}, m13886d2 = {"addExactOrElse", "", "right", "defaultValue", "Lkotlin/Function0;", "distanceSquaredToClosestCornerFromOutside", "", "Landroidx/compose/ui/geometry/Offset;", "rect", "Landroidx/compose/ui/geometry/Rect;", "distanceSquaredToClosestCornerFromOutside-3MmeM6k", "(JLandroidx/compose/ui/geometry/Rect;)F", "findClosestRect", "rect1", "rect2", "findClosestRect-9KIMszo", "(JLandroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;)I", "subtractExactOrElse", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nMathUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MathUtils.kt\nandroidx/compose/foundation/text/input/internal/MathUtilsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,66:1\n1#2:67\n*E\n"})
public final class MathUtilsKt {
    public static final int addExactOrElse(int i, int i2, @NotNull Function0<Integer> function0) {
        int i4 = i + i2;
        return ((i ^ i4) & (i2 ^ i4)) < 0 ? function0.invoke().intValue() : i4;
    }

    /* JADX INFO: renamed from: distanceSquaredToClosestCornerFromOutside-3MmeM6k, reason: not valid java name */
    private static final float m16344distanceSquaredToClosestCornerFromOutside3MmeM6k(long j, Rect rect) {
        if (SelectionManagerKt.m16548containsInclusiveUv8p0NA(rect, j)) {
            return 0.0f;
        }
        float fM18283getDistanceSquaredimpl = Offset.m18283getDistanceSquaredimpl(Offset.m18288minusMKHz9U(rect.m18319getTopLeftF1C5BW0(), j));
        if (fM18283getDistanceSquaredimpl >= Float.MAX_VALUE) {
            fM18283getDistanceSquaredimpl = Float.MAX_VALUE;
        }
        float fM18283getDistanceSquaredimpl2 = Offset.m18283getDistanceSquaredimpl(Offset.m18288minusMKHz9U(rect.m18320getTopRightF1C5BW0(), j));
        if (fM18283getDistanceSquaredimpl2 < fM18283getDistanceSquaredimpl) {
            fM18283getDistanceSquaredimpl = fM18283getDistanceSquaredimpl2;
        }
        float fM18283getDistanceSquaredimpl3 = Offset.m18283getDistanceSquaredimpl(Offset.m18288minusMKHz9U(rect.m18312getBottomLeftF1C5BW0(), j));
        if (fM18283getDistanceSquaredimpl3 < fM18283getDistanceSquaredimpl) {
            fM18283getDistanceSquaredimpl = fM18283getDistanceSquaredimpl3;
        }
        float fM18283getDistanceSquaredimpl4 = Offset.m18283getDistanceSquaredimpl(Offset.m18288minusMKHz9U(rect.m18313getBottomRightF1C5BW0(), j));
        return fM18283getDistanceSquaredimpl4 < fM18283getDistanceSquaredimpl ? fM18283getDistanceSquaredimpl4 : fM18283getDistanceSquaredimpl;
    }

    /* JADX INFO: renamed from: findClosestRect-9KIMszo, reason: not valid java name */
    public static final int m16345findClosestRect9KIMszo(long j, @NotNull Rect rect, @NotNull Rect rect2) {
        float fM16344distanceSquaredToClosestCornerFromOutside3MmeM6k = m16344distanceSquaredToClosestCornerFromOutside3MmeM6k(j, rect);
        float fM16344distanceSquaredToClosestCornerFromOutside3MmeM6k2 = m16344distanceSquaredToClosestCornerFromOutside3MmeM6k(j, rect2);
        if (fM16344distanceSquaredToClosestCornerFromOutside3MmeM6k == fM16344distanceSquaredToClosestCornerFromOutside3MmeM6k2) {
            return 0;
        }
        return fM16344distanceSquaredToClosestCornerFromOutside3MmeM6k < fM16344distanceSquaredToClosestCornerFromOutside3MmeM6k2 ? -1 : 1;
    }

    public static final int subtractExactOrElse(int i, int i2, @NotNull Function0<Integer> function0) {
        int i4 = i - i2;
        return ((i ^ i4) & (i2 ^ i)) < 0 ? function0.invoke().intValue() : i4;
    }
}
