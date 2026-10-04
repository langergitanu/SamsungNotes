package androidx.compose.material.ripple;

import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.geometry.OffsetKt;
import androidx.compose.p109ui.geometry.Size;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.Density;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import opennlp.tools.tokenize.TokenizerME;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u001d\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a)\u0010\r\u001a\u00020\b*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\nH\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0013"}, m13886d2 = {"BoundedRippleExtraRadius", "Landroidx/compose/ui/unit/Dp;", TokenizerME.NO_SPLIT, "FadeInDuration", "", "FadeOutDuration", "RadiusDuration", "getRippleStartRadius", "", "size", "Landroidx/compose/ui/geometry/Size;", "getRippleStartRadius-uvyYCjk", "(J)F", "getRippleEndRadius", "Landroidx/compose/ui/unit/Density;", "bounded", "", "getRippleEndRadius-cSwnlzA", "(Landroidx/compose/ui/unit/Density;ZJ)F", "material-ripple_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class RippleAnimationKt {
    private static final float BoundedRippleExtraRadius = C2256Dp.m20968constructorimpl(10);
    private static final int FadeInDuration = 75;
    private static final int FadeOutDuration = 150;
    private static final int RadiusDuration = 225;

    /* JADX INFO: renamed from: getRippleEndRadius-cSwnlzA, reason: not valid java name */
    public static final float m16971getRippleEndRadiuscSwnlzA(@NotNull Density getRippleEndRadius, boolean z, long j) {
        Intrinsics.checkNotNullParameter(getRippleEndRadius, "$this$getRippleEndRadius");
        float fM18282getDistanceimpl = Offset.m18282getDistanceimpl(OffsetKt.Offset(Size.m18353getWidthimpl(j), Size.m18350getHeightimpl(j))) / 2.0f;
        return z ? getRippleEndRadius.mo15546toPx0680j_4(BoundedRippleExtraRadius) + fM18282getDistanceimpl : fM18282getDistanceimpl;
    }

    /* JADX INFO: renamed from: getRippleStartRadius-uvyYCjk, reason: not valid java name */
    public static final float m16972getRippleStartRadiusuvyYCjk(long j) {
        return Math.max(Size.m18353getWidthimpl(j), Size.m18350getHeightimpl(j)) * 0.3f;
    }
}
