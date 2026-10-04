package androidx.compose.foundation.shape;

import androidx.annotation.IntRange;
import androidx.compose.p109ui.unit.C2256Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a8\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u000e\u001a.\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\u000e2\b\b\u0002\u0010\t\u001a\u00020\u000e2\b\b\u0002\u0010\n\u001a\u00020\u000e2\b\b\u0002\u0010\u000b\u001a\u00020\u000e\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0010\u001a.\u0010\u0000\u001a\u00020\u00012\b\b\u0003\u0010\u0011\u001a\u00020\u00102\b\b\u0003\u0010\u0012\u001a\u00020\u00102\b\b\u0003\u0010\u0013\u001a\u00020\u00102\b\b\u0003\u0010\u0014\u001a\u00020\u0010\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0015"}, m13886d2 = {"AbsoluteCutCornerShape", "Landroidx/compose/foundation/shape/AbsoluteCutCornerShape;", "corner", "Landroidx/compose/foundation/shape/CornerSize;", "size", "Landroidx/compose/ui/unit/Dp;", "AbsoluteCutCornerShape-0680j_4", "(F)Landroidx/compose/foundation/shape/AbsoluteCutCornerShape;", "topLeft", "topRight", "bottomRight", "bottomLeft", "AbsoluteCutCornerShape-a9UjIt4", "(FFFF)Landroidx/compose/foundation/shape/AbsoluteCutCornerShape;", "", "percent", "", "topLeftPercent", "topRightPercent", "bottomRightPercent", "bottomLeftPercent", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nAbsoluteCutCornerShape.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbsoluteCutCornerShape.kt\nandroidx/compose/foundation/shape/AbsoluteCutCornerShapeKt\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n*L\n1#1,199:1\n149#2:200\n149#2:201\n149#2:202\n149#2:203\n*S KotlinDebug\n*F\n+ 1 AbsoluteCutCornerShape.kt\nandroidx/compose/foundation/shape/AbsoluteCutCornerShapeKt\n*L\n146#1:200\n147#1:201\n148#1:202\n149#1:203\n*E\n"})
public final class AbsoluteCutCornerShapeKt {
    @NotNull
    public static final AbsoluteCutCornerShape AbsoluteCutCornerShape(@NotNull CornerSize cornerSize) {
        return new AbsoluteCutCornerShape(cornerSize, cornerSize, cornerSize, cornerSize);
    }

    public static /* synthetic */ AbsoluteCutCornerShape AbsoluteCutCornerShape$default(float f, float f4, float f5, float f6, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f4 = 0.0f;
        }
        if ((i & 4) != 0) {
            f5 = 0.0f;
        }
        if ((i & 8) != 0) {
            f6 = 0.0f;
        }
        return AbsoluteCutCornerShape(f, f4, f5, f6);
    }

    @NotNull
    /* JADX INFO: renamed from: AbsoluteCutCornerShape-0680j_4, reason: not valid java name */
    public static final AbsoluteCutCornerShape m16121AbsoluteCutCornerShape0680j_4(float f) {
        return AbsoluteCutCornerShape(CornerSizeKt.m16129CornerSize0680j_4(f));
    }

    @NotNull
    /* JADX INFO: renamed from: AbsoluteCutCornerShape-a9UjIt4, reason: not valid java name */
    public static final AbsoluteCutCornerShape m16122AbsoluteCutCornerShapea9UjIt4(float f, float f4, float f5, float f6) {
        return new AbsoluteCutCornerShape(CornerSizeKt.m16129CornerSize0680j_4(f), CornerSizeKt.m16129CornerSize0680j_4(f4), CornerSizeKt.m16129CornerSize0680j_4(f5), CornerSizeKt.m16129CornerSize0680j_4(f6));
    }

    /* JADX INFO: renamed from: AbsoluteCutCornerShape-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ AbsoluteCutCornerShape m16123AbsoluteCutCornerShapea9UjIt4$default(float f, float f4, float f5, float f6, int i, Object obj) {
        if ((i & 1) != 0) {
            f = C2256Dp.m20968constructorimpl(0);
        }
        if ((i & 2) != 0) {
            f4 = C2256Dp.m20968constructorimpl(0);
        }
        if ((i & 4) != 0) {
            f5 = C2256Dp.m20968constructorimpl(0);
        }
        if ((i & 8) != 0) {
            f6 = C2256Dp.m20968constructorimpl(0);
        }
        return m16122AbsoluteCutCornerShapea9UjIt4(f, f4, f5, f6);
    }

    @NotNull
    public static final AbsoluteCutCornerShape AbsoluteCutCornerShape(float f) {
        return AbsoluteCutCornerShape(CornerSizeKt.CornerSize(f));
    }

    public static /* synthetic */ AbsoluteCutCornerShape AbsoluteCutCornerShape$default(int i, int i2, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = 0;
        }
        if ((i6 & 2) != 0) {
            i2 = 0;
        }
        if ((i6 & 4) != 0) {
            i4 = 0;
        }
        if ((i6 & 8) != 0) {
            i5 = 0;
        }
        return AbsoluteCutCornerShape(i, i2, i4, i5);
    }

    @NotNull
    public static final AbsoluteCutCornerShape AbsoluteCutCornerShape(int i) {
        return AbsoluteCutCornerShape(CornerSizeKt.CornerSize(i));
    }

    @NotNull
    public static final AbsoluteCutCornerShape AbsoluteCutCornerShape(float f, float f4, float f5, float f6) {
        return new AbsoluteCutCornerShape(CornerSizeKt.CornerSize(f), CornerSizeKt.CornerSize(f4), CornerSizeKt.CornerSize(f5), CornerSizeKt.CornerSize(f6));
    }

    @NotNull
    public static final AbsoluteCutCornerShape AbsoluteCutCornerShape(@IntRange(from = 0, m706to = 100) int i, @IntRange(from = 0, m706to = 100) int i2, @IntRange(from = 0, m706to = 100) int i4, @IntRange(from = 0, m706to = 100) int i5) {
        return new AbsoluteCutCornerShape(CornerSizeKt.CornerSize(i), CornerSizeKt.CornerSize(i2), CornerSizeKt.CornerSize(i4), CornerSizeKt.CornerSize(i5));
    }
}
