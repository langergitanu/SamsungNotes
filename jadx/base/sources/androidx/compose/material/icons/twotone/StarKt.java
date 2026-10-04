package androidx.compose.material.icons.twotone;

import androidx.compose.material.icons.Icons;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.SolidColor;
import androidx.compose.p109ui.graphics.StrokeCap;
import androidx.compose.p109ui.graphics.StrokeJoin;
import androidx.compose.p109ui.graphics.vector.ImageVector;
import androidx.compose.p109ui.graphics.vector.PathBuilder;
import androidx.compose.p109ui.graphics.vector.VectorKt;
import androidx.compose.p109ui.unit.C2256Dp;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m13886d2 = {"_star", "Landroidx/compose/ui/graphics/vector/ImageVector;", CoverStickerConstants.Category.STAR.NAME, "Landroidx/compose/material/icons/Icons$TwoTone;", "getStar", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class StarKt {

    @Nullable
    private static ImageVector _star;

    @NotNull
    public static final ImageVector getStar(@NotNull Icons.TwoTone twoTone) {
        Intrinsics.checkNotNullParameter(twoTone, "<this>");
        ImageVector imageVector = _star;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("TwoTone.Star", C2256Dp.m20968constructorimpl(24.0f), C2256Dp.m20968constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int defaultFillType = VectorKt.getDefaultFillType();
        Color.Companion companion = Color.INSTANCE;
        SolidColor solidColor = new SolidColor(companion.m18551getBlack0d7_KjU(), null);
        StrokeCap.Companion companion2 = StrokeCap.INSTANCE;
        int iM18878getButtKaPHkGw = companion2.m18878getButtKaPHkGw();
        StrokeJoin.Companion companion3 = StrokeJoin.INSTANCE;
        int iM18888getBevelLxFBmk8 = companion3.m18888getBevelLxFBmk8();
        PathBuilder pathBuilderM12319d = AbstractC11014a.m12319d(12.0f, 15.4f, -3.76f, 2.27f);
        pathBuilderM12319d.lineToRelative(1.0f, -4.28f);
        pathBuilderM12319d.lineToRelative(-3.32f, -2.88f);
        pathBuilderM12319d.lineToRelative(4.38f, -0.38f);
        pathBuilderM12319d.lineToRelative(1.7f, -4.03f);
        pathBuilderM12319d.lineToRelative(1.71f, 4.04f);
        pathBuilderM12319d.lineToRelative(4.38f, 0.38f);
        ImageVector.Builder.m19210addPathoIyEayM$default(builder, AbstractC11014a.m12313B(pathBuilderM12319d, -3.32f, 2.88f, 1.0f, 4.28f), defaultFillType, "", solidColor, 0.3f, null, 0.3f, 1.0f, iM18878getButtKaPHkGw, iM18888getBevelLxFBmk8, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null);
        int defaultFillType2 = VectorKt.getDefaultFillType();
        SolidColor solidColor2 = new SolidColor(companion.m18551getBlack0d7_KjU(), null);
        int iM18878getButtKaPHkGw2 = companion2.m18878getButtKaPHkGw();
        int iM18888getBevelLxFBmk82 = companion3.m18888getBevelLxFBmk8();
        PathBuilder pathBuilderM12319d2 = AbstractC11014a.m12319d(22.0f, 9.24f, -7.19f, -0.62f);
        pathBuilderM12319d2.lineTo(12.0f, 2.0f);
        pathBuilderM12319d2.lineTo(9.19f, 8.63f);
        pathBuilderM12319d2.lineTo(2.0f, 9.24f);
        pathBuilderM12319d2.lineToRelative(5.46f, 4.73f);
        pathBuilderM12319d2.lineTo(5.82f, 21.0f);
        pathBuilderM12319d2.lineTo(12.0f, 17.27f);
        pathBuilderM12319d2.lineTo(18.18f, 21.0f);
        pathBuilderM12319d2.lineToRelative(-1.63f, -7.03f);
        pathBuilderM12319d2.lineTo(22.0f, 9.24f);
        pathBuilderM12319d2.close();
        pathBuilderM12319d2.moveTo(12.0f, 15.4f);
        pathBuilderM12319d2.lineToRelative(-3.76f, 2.27f);
        pathBuilderM12319d2.lineToRelative(1.0f, -4.28f);
        pathBuilderM12319d2.lineToRelative(-3.32f, -2.88f);
        pathBuilderM12319d2.lineToRelative(4.38f, -0.38f);
        pathBuilderM12319d2.lineTo(12.0f, 6.1f);
        pathBuilderM12319d2.lineToRelative(1.71f, 4.04f);
        pathBuilderM12319d2.lineToRelative(4.38f, 0.38f);
        pathBuilderM12319d2.lineToRelative(-3.32f, 2.88f);
        pathBuilderM12319d2.lineToRelative(1.0f, 4.28f);
        pathBuilderM12319d2.lineTo(12.0f, 15.4f);
        pathBuilderM12319d2.close();
        ImageVector imageVectorBuild = ImageVector.Builder.m19210addPathoIyEayM$default(builder, pathBuilderM12319d2.getNodes(), defaultFillType2, "", solidColor2, 1.0f, null, 1.0f, 1.0f, iM18878getButtKaPHkGw2, iM18888getBevelLxFBmk82, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null).build();
        _star = imageVectorBuild;
        Intrinsics.checkNotNull(imageVectorBuild);
        return imageVectorBuild;
    }
}
