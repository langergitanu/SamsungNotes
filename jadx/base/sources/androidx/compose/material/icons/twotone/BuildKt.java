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
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m13886d2 = {"_build", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Build", "Landroidx/compose/material/icons/Icons$TwoTone;", "getBuild", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class BuildKt {

    @Nullable
    private static ImageVector _build;

    @NotNull
    public static final ImageVector getBuild(@NotNull Icons.TwoTone twoTone) {
        Intrinsics.checkNotNullParameter(twoTone, "<this>");
        ImageVector imageVector = _build;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("TwoTone.Build", C2256Dp.m20968constructorimpl(24.0f), C2256Dp.m20968constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int defaultFillType = VectorKt.getDefaultFillType();
        Color.Companion companion = Color.INSTANCE;
        SolidColor solidColor = new SolidColor(companion.m18551getBlack0d7_KjU(), null);
        StrokeCap.Companion companion2 = StrokeCap.INSTANCE;
        int iM18878getButtKaPHkGw = companion2.m18878getButtKaPHkGw();
        StrokeJoin.Companion companion3 = StrokeJoin.INSTANCE;
        int iM18888getBevelLxFBmk8 = companion3.m18888getBevelLxFBmk8();
        PathBuilder pathBuilderM12318c = AbstractC11014a.m12318c(11.92f, 8.28f);
        pathBuilderM12318c.curveToRelative(0.24f, -1.4f, -0.16f, -2.89f, -1.24f, -3.96f);
        pathBuilderM12318c.curveToRelative(-0.94f, -0.95f, -2.2f, -1.39f, -3.44f, -1.32f);
        pathBuilderM12318c.lineToRelative(3.09f, 3.09f);
        pathBuilderM12318c.lineToRelative(-4.24f, 4.24f);
        pathBuilderM12318c.lineTo(3.0f, 7.24f);
        pathBuilderM12318c.curveToRelative(-0.07f, 1.24f, 0.37f, 2.49f, 1.31f, 3.44f);
        pathBuilderM12318c.curveToRelative(1.04f, 1.04f, 2.47f, 1.45f, 3.83f, 1.25f);
        pathBuilderM12318c.curveToRelative(0.71f, -0.1f, 1.4f, -0.38f, 2.0f, -0.82f);
        pathBuilderM12318c.lineToRelative(9.46f, 9.46f);
        pathBuilderM12318c.lineToRelative(0.88f, -0.88f);
        pathBuilderM12318c.lineToRelative(-9.45f, -9.45f);
        pathBuilderM12318c.curveToRelative(0.47f, -0.6f, 0.77f, -1.26f, 0.89f, -1.96f);
        pathBuilderM12318c.close();
        ImageVector.Builder.m19210addPathoIyEayM$default(builder, pathBuilderM12318c.getNodes(), defaultFillType, "", solidColor, 0.3f, null, 0.3f, 1.0f, iM18878getButtKaPHkGw, iM18888getBevelLxFBmk8, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null);
        int defaultFillType2 = VectorKt.getDefaultFillType();
        SolidColor solidColor2 = new SolidColor(companion.m18551getBlack0d7_KjU(), null);
        int iM18878getButtKaPHkGw2 = companion2.m18878getButtKaPHkGw();
        int iM18888getBevelLxFBmk82 = companion3.m18888getBevelLxFBmk8();
        PathBuilder pathBuilderM12312A = AbstractC11014a.m12312A(22.61f, 18.97f, 13.54f, 9.9f);
        pathBuilderM12312A.curveToRelative(0.93f, -2.34f, 0.45f, -5.1f, -1.44f, -7.0f);
        pathBuilderM12312A.curveTo(9.8f, 0.6f, 6.22f, 0.39f, 3.67f, 2.25f);
        pathBuilderM12312A.lineTo(7.5f, 6.08f);
        pathBuilderM12312A.lineTo(6.08f, 7.5f);
        pathBuilderM12312A.lineTo(2.25f, 3.67f);
        pathBuilderM12312A.curveTo(0.39f, 6.21f, 0.6f, 9.79f, 2.9f, 12.09f);
        pathBuilderM12312A.curveToRelative(1.86f, 1.86f, 4.57f, 2.35f, 6.89f, 1.48f);
        pathBuilderM12312A.lineToRelative(9.11f, 9.11f);
        pathBuilderM12312A.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0.0f);
        pathBuilderM12312A.lineToRelative(2.3f, -2.3f);
        pathBuilderM12312A.curveToRelative(0.4f, -0.38f, 0.4f, -1.02f, 0.0f, -1.41f);
        pathBuilderM12312A.close();
        pathBuilderM12312A.moveTo(19.61f, 20.57f);
        pathBuilderM12312A.lineToRelative(-9.46f, -9.46f);
        pathBuilderM12312A.curveToRelative(-0.61f, 0.45f, -1.29f, 0.72f, -2.0f, 0.82f);
        pathBuilderM12312A.curveToRelative(-1.36f, 0.2f, -2.79f, -0.21f, -3.83f, -1.25f);
        pathBuilderM12312A.curveToRelative(-0.95f, -0.94f, -1.39f, -2.2f, -1.32f, -3.44f);
        pathBuilderM12312A.lineToRelative(3.09f, 3.09f);
        pathBuilderM12312A.lineToRelative(4.24f, -4.24f);
        pathBuilderM12312A.lineTo(7.24f, 3.0f);
        pathBuilderM12312A.curveToRelative(1.24f, -0.07f, 2.49f, 0.37f, 3.44f, 1.31f);
        pathBuilderM12312A.curveToRelative(1.08f, 1.08f, 1.49f, 2.57f, 1.24f, 3.96f);
        pathBuilderM12312A.curveToRelative(-0.12f, 0.7f, -0.42f, 1.36f, -0.88f, 1.95f);
        ImageVector imageVectorBuild = ImageVector.Builder.m19210addPathoIyEayM$default(builder, AbstractC11014a.m12313B(pathBuilderM12312A, 9.45f, 9.45f, -0.88f, 0.9f), defaultFillType2, "", solidColor2, 1.0f, null, 1.0f, 1.0f, iM18878getButtKaPHkGw2, iM18888getBevelLxFBmk82, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null).build();
        _build = imageVectorBuild;
        Intrinsics.checkNotNull(imageVectorBuild);
        return imageVectorBuild;
    }
}
