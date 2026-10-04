package androidx.compose.p109ui.unit;

import androidx.compose.p109ui.geometry.Size;
import androidx.compose.p109ui.geometry.SizeKt;
import androidx.compose.runtime.Stable;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u001d\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\u000b\u001a\u0016\u0010\f\u001a\u00020\u0002*\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u0006\u001a\u001f\u0010\u000f\u001a\u00020\u0002*\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0002H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0016\u0010\u0013\u001a\u00020\u0014*\u00020\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0016\u0010\u0017\u001a\u00020\u0002*\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0006\u001a\u0016\u0010\u0019\u001a\u00020\r*\u00020\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0006\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001b"}, m13886d2 = {"center", "Landroidx/compose/ui/unit/IntOffset;", "Landroidx/compose/ui/unit/IntSize;", "getCenter-ozmzZPI$annotations", "(J)V", "getCenter-ozmzZPI", "(J)J", "IntSize", "width", "", "height", "(II)J", "roundToIntSize", "Landroidx/compose/ui/geometry/Size;", "roundToIntSize-uvyYCjk", "times", "size", "times-O0kMr_c", "(IJ)J", "toIntRect", "Landroidx/compose/ui/unit/IntRect;", "toIntRect-ozmzZPI", "(J)Landroidx/compose/ui/unit/IntRect;", "toIntSize", "toIntSize-uvyYCjk", "toSize", "toSize-ozmzZPI", "ui-unit_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nIntSize.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IntSize.kt\nandroidx/compose/ui/unit/IntSizeKt\n+ 2 InlineClassHelper.kt\nandroidx/compose/ui/util/InlineClassHelperKt\n+ 3 InlineClassHelper.jvm.kt\nandroidx/compose/ui/util/InlineClassHelper_jvmKt\n*L\n1#1,146:1\n100#2:147\n100#2:148\n100#2:151\n26#3:149\n26#3:150\n*S KotlinDebug\n*F\n+ 1 IntSize.kt\nandroidx/compose/ui/unit/IntSizeKt\n*L\n33#1:147\n133#1:148\n141#1:151\n142#1:149\n143#1:150\n*E\n"})
public final class IntSizeKt {
    @Stable
    public static final long IntSize(int i, int i2) {
        return IntSize.m21133constructorimpl((((long) i2) & 4294967295L) | (((long) i) << 32));
    }

    /* JADX INFO: renamed from: getCenter-ozmzZPI, reason: not valid java name */
    public static final long m21144getCenterozmzZPI(long j) {
        return IntOffset.m21090constructorimpl((((j << 32) >> 33) & 4294967295L) | ((j >> 33) << 32));
    }

    @Stable
    /* JADX INFO: renamed from: roundToIntSize-uvyYCjk, reason: not valid java name */
    public static final long m21146roundToIntSizeuvyYCjk(long j) {
        int iRound = Math.round(Size.m18353getWidthimpl(j));
        return IntSize.m21133constructorimpl((((long) Math.round(Size.m18350getHeightimpl(j))) & 4294967295L) | (((long) iRound) << 32));
    }

    @Stable
    /* JADX INFO: renamed from: times-O0kMr_c, reason: not valid java name */
    public static final long m21147timesO0kMr_c(int i, long j) {
        return IntSize.m21140timesYEO4UFw(j, i);
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: toIntRect-ozmzZPI, reason: not valid java name */
    public static final IntRect m21148toIntRectozmzZPI(long j) {
        return IntRectKt.m21128IntRectVbeCjmY(IntOffset.INSTANCE.m21106getZeronOccac(), j);
    }

    @Stable
    /* JADX INFO: renamed from: toIntSize-uvyYCjk, reason: not valid java name */
    public static final long m21149toIntSizeuvyYCjk(long j) {
        int iM18353getWidthimpl = (int) Size.m18353getWidthimpl(j);
        return IntSize.m21133constructorimpl((((long) ((int) Size.m18350getHeightimpl(j))) & 4294967295L) | (((long) iM18353getWidthimpl) << 32));
    }

    @Stable
    /* JADX INFO: renamed from: toSize-ozmzZPI, reason: not valid java name */
    public static final long m21150toSizeozmzZPI(long j) {
        return SizeKt.Size(IntSize.m21138getWidthimpl(j), IntSize.m21137getHeightimpl(j));
    }

    @Stable
    /* JADX INFO: renamed from: getCenter-ozmzZPI$annotations, reason: not valid java name */
    public static /* synthetic */ void m21145getCenterozmzZPI$annotations(long j) {
    }
}
