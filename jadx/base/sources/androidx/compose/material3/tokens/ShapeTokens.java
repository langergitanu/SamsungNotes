package androidx.compose.material3.tokens;

import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.p109ui.graphics.RectangleShapeKt;
import androidx.compose.p109ui.graphics.Shape;
import androidx.compose.p109ui.unit.C2256Dp;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0011\u0010\u0011\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0011\u0010\u0013\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0011\u0010\u0015\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0006¨\u0006\u001d"}, m13886d2 = {"Landroidx/compose/material3/tokens/ShapeTokens;", "", "()V", "CornerExtraLarge", "Landroidx/compose/foundation/shape/RoundedCornerShape;", "getCornerExtraLarge", "()Landroidx/compose/foundation/shape/RoundedCornerShape;", "CornerExtraLargeTop", "getCornerExtraLargeTop", "CornerExtraSmall", "getCornerExtraSmall", "CornerExtraSmallTop", "getCornerExtraSmallTop", "CornerFull", "getCornerFull", "CornerLarge", "getCornerLarge", "CornerLargeEnd", "getCornerLargeEnd", "CornerLargeTop", "getCornerLargeTop", "CornerMedium", "getCornerMedium", "CornerNone", "Landroidx/compose/ui/graphics/Shape;", "getCornerNone", "()Landroidx/compose/ui/graphics/Shape;", "CornerSmall", "getCornerSmall", "material3_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class ShapeTokens {

    @NotNull
    private static final RoundedCornerShape CornerExtraLarge;

    @NotNull
    private static final RoundedCornerShape CornerExtraLargeTop;

    @NotNull
    private static final RoundedCornerShape CornerExtraSmall;

    @NotNull
    private static final RoundedCornerShape CornerExtraSmallTop;

    @NotNull
    private static final RoundedCornerShape CornerLarge;

    @NotNull
    private static final RoundedCornerShape CornerLargeEnd;

    @NotNull
    private static final RoundedCornerShape CornerLargeTop;

    @NotNull
    public static final ShapeTokens INSTANCE = new ShapeTokens();

    @NotNull
    private static final RoundedCornerShape CornerFull = RoundedCornerShapeKt.getCircleShape();

    @NotNull
    private static final RoundedCornerShape CornerMedium = RoundedCornerShapeKt.m16137RoundedCornerShape0680j_4(C2256Dp.m20968constructorimpl((float) 12.0d));

    @NotNull
    private static final Shape CornerNone = RectangleShapeKt.getRectangleShape();

    @NotNull
    private static final RoundedCornerShape CornerSmall = RoundedCornerShapeKt.m16137RoundedCornerShape0680j_4(C2256Dp.m20968constructorimpl((float) 8.0d));

    static {
        float f = (float) 28.0d;
        CornerExtraLarge = RoundedCornerShapeKt.m16137RoundedCornerShape0680j_4(C2256Dp.m20968constructorimpl(f));
        float f4 = (float) 0.0d;
        CornerExtraLargeTop = RoundedCornerShapeKt.m16138RoundedCornerShapea9UjIt4(C2256Dp.m20968constructorimpl(f), C2256Dp.m20968constructorimpl(f), C2256Dp.m20968constructorimpl(f4), C2256Dp.m20968constructorimpl(f4));
        float f5 = (float) 4.0d;
        CornerExtraSmall = RoundedCornerShapeKt.m16137RoundedCornerShape0680j_4(C2256Dp.m20968constructorimpl(f5));
        CornerExtraSmallTop = RoundedCornerShapeKt.m16138RoundedCornerShapea9UjIt4(C2256Dp.m20968constructorimpl(f5), C2256Dp.m20968constructorimpl(f5), C2256Dp.m20968constructorimpl(f4), C2256Dp.m20968constructorimpl(f4));
        float f6 = (float) 16.0d;
        CornerLarge = RoundedCornerShapeKt.m16137RoundedCornerShape0680j_4(C2256Dp.m20968constructorimpl(f6));
        CornerLargeEnd = RoundedCornerShapeKt.m16138RoundedCornerShapea9UjIt4(C2256Dp.m20968constructorimpl(f4), C2256Dp.m20968constructorimpl(f6), C2256Dp.m20968constructorimpl(f6), C2256Dp.m20968constructorimpl(f4));
        CornerLargeTop = RoundedCornerShapeKt.m16138RoundedCornerShapea9UjIt4(C2256Dp.m20968constructorimpl(f6), C2256Dp.m20968constructorimpl(f6), C2256Dp.m20968constructorimpl(f4), C2256Dp.m20968constructorimpl(f4));
    }

    private ShapeTokens() {
    }

    @NotNull
    public final RoundedCornerShape getCornerExtraLarge() {
        return CornerExtraLarge;
    }

    @NotNull
    public final RoundedCornerShape getCornerExtraLargeTop() {
        return CornerExtraLargeTop;
    }

    @NotNull
    public final RoundedCornerShape getCornerExtraSmall() {
        return CornerExtraSmall;
    }

    @NotNull
    public final RoundedCornerShape getCornerExtraSmallTop() {
        return CornerExtraSmallTop;
    }

    @NotNull
    public final RoundedCornerShape getCornerFull() {
        return CornerFull;
    }

    @NotNull
    public final RoundedCornerShape getCornerLarge() {
        return CornerLarge;
    }

    @NotNull
    public final RoundedCornerShape getCornerLargeEnd() {
        return CornerLargeEnd;
    }

    @NotNull
    public final RoundedCornerShape getCornerLargeTop() {
        return CornerLargeTop;
    }

    @NotNull
    public final RoundedCornerShape getCornerMedium() {
        return CornerMedium;
    }

    @NotNull
    public final Shape getCornerNone() {
        return CornerNone;
    }

    @NotNull
    public final RoundedCornerShape getCornerSmall() {
        return CornerSmall;
    }
}
