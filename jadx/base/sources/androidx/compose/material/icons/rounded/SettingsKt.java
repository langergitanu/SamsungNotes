package androidx.compose.material.icons.rounded;

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
@Metadata(m13885d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m13886d2 = {"_settings", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Settings", "Landroidx/compose/material/icons/Icons$Rounded;", "getSettings", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class SettingsKt {

    @Nullable
    private static ImageVector _settings;

    @NotNull
    public static final ImageVector getSettings(@NotNull Icons.Rounded rounded) {
        Intrinsics.checkNotNullParameter(rounded, "<this>");
        ImageVector imageVector = _settings;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Rounded.Settings", C2256Dp.m20968constructorimpl(24.0f), C2256Dp.m20968constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.INSTANCE.m18551getBlack0d7_KjU(), null);
        int iM18878getButtKaPHkGw = StrokeCap.INSTANCE.m18878getButtKaPHkGw();
        int iM18888getBevelLxFBmk8 = StrokeJoin.INSTANCE.m18888getBevelLxFBmk8();
        PathBuilder pathBuilderM12318c = AbstractC11014a.m12318c(19.5f, 12.0f);
        pathBuilderM12318c.curveToRelative(0.0f, -0.23f, -0.01f, -0.45f, -0.03f, -0.68f);
        pathBuilderM12318c.lineToRelative(1.86f, -1.41f);
        pathBuilderM12318c.curveToRelative(0.4f, -0.3f, 0.51f, -0.86f, 0.26f, -1.3f);
        pathBuilderM12318c.lineToRelative(-1.87f, -3.23f);
        pathBuilderM12318c.curveToRelative(-0.25f, -0.44f, -0.79f, -0.62f, -1.25f, -0.42f);
        pathBuilderM12318c.lineToRelative(-2.15f, 0.91f);
        pathBuilderM12318c.curveToRelative(-0.37f, -0.26f, -0.76f, -0.49f, -1.17f, -0.68f);
        pathBuilderM12318c.lineToRelative(-0.29f, -2.31f);
        pathBuilderM12318c.curveTo(14.8f, 2.38f, 14.37f, 2.0f, 13.87f, 2.0f);
        pathBuilderM12318c.horizontalLineToRelative(-3.73f);
        pathBuilderM12318c.curveTo(9.63f, 2.0f, 9.2f, 2.38f, 9.14f, 2.88f);
        pathBuilderM12318c.lineTo(8.85f, 5.19f);
        pathBuilderM12318c.curveToRelative(-0.41f, 0.19f, -0.8f, 0.42f, -1.17f, 0.68f);
        pathBuilderM12318c.lineTo(5.53f, 4.96f);
        pathBuilderM12318c.curveToRelative(-0.46f, -0.2f, -1.0f, -0.02f, -1.25f, 0.42f);
        pathBuilderM12318c.lineTo(2.41f, 8.62f);
        pathBuilderM12318c.curveToRelative(-0.25f, 0.44f, -0.14f, 0.99f, 0.26f, 1.3f);
        pathBuilderM12318c.lineToRelative(1.86f, 1.41f);
        pathBuilderM12318c.curveTo(4.51f, 11.55f, 4.5f, 11.77f, 4.5f, 12.0f);
        pathBuilderM12318c.reflectiveCurveToRelative(0.01f, 0.45f, 0.03f, 0.68f);
        pathBuilderM12318c.lineToRelative(-1.86f, 1.41f);
        pathBuilderM12318c.curveToRelative(-0.4f, 0.3f, -0.51f, 0.86f, -0.26f, 1.3f);
        pathBuilderM12318c.lineToRelative(1.87f, 3.23f);
        pathBuilderM12318c.curveToRelative(0.25f, 0.44f, 0.79f, 0.62f, 1.25f, 0.42f);
        pathBuilderM12318c.lineToRelative(2.15f, -0.91f);
        pathBuilderM12318c.curveToRelative(0.37f, 0.26f, 0.76f, 0.49f, 1.17f, 0.68f);
        pathBuilderM12318c.lineToRelative(0.29f, 2.31f);
        pathBuilderM12318c.curveTo(9.2f, 21.62f, 9.63f, 22.0f, 10.13f, 22.0f);
        pathBuilderM12318c.horizontalLineToRelative(3.73f);
        pathBuilderM12318c.curveToRelative(0.5f, 0.0f, 0.93f, -0.38f, 0.99f, -0.88f);
        pathBuilderM12318c.lineToRelative(0.29f, -2.31f);
        pathBuilderM12318c.curveToRelative(0.41f, -0.19f, 0.8f, -0.42f, 1.17f, -0.68f);
        pathBuilderM12318c.lineToRelative(2.15f, 0.91f);
        pathBuilderM12318c.curveToRelative(0.46f, 0.2f, 1.0f, 0.02f, 1.25f, -0.42f);
        pathBuilderM12318c.lineToRelative(1.87f, -3.23f);
        pathBuilderM12318c.curveToRelative(0.25f, -0.44f, 0.14f, -0.99f, -0.26f, -1.3f);
        pathBuilderM12318c.lineToRelative(-1.86f, -1.41f);
        pathBuilderM12318c.curveTo(19.49f, 12.45f, 19.5f, 12.23f, 19.5f, 12.0f);
        pathBuilderM12318c.close();
        pathBuilderM12318c.moveTo(12.04f, 15.5f);
        pathBuilderM12318c.curveToRelative(-1.93f, 0.0f, -3.5f, -1.57f, -3.5f, -3.5f);
        pathBuilderM12318c.reflectiveCurveToRelative(1.57f, -3.5f, 3.5f, -3.5f);
        pathBuilderM12318c.reflectiveCurveToRelative(3.5f, 1.57f, 3.5f, 3.5f);
        pathBuilderM12318c.reflectiveCurveTo(13.97f, 15.5f, 12.04f, 15.5f);
        pathBuilderM12318c.close();
        ImageVector imageVectorBuild = ImageVector.Builder.m19210addPathoIyEayM$default(builder, pathBuilderM12318c.getNodes(), defaultFillType, "", solidColor, 1.0f, null, 1.0f, 1.0f, iM18878getButtKaPHkGw, iM18888getBevelLxFBmk8, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null).build();
        _settings = imageVectorBuild;
        Intrinsics.checkNotNull(imageVectorBuild);
        return imageVectorBuild;
    }
}
