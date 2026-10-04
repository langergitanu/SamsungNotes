package androidx.compose.material.icons.filled;

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
@Metadata(m13885d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m13886d2 = {"_settings", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Settings", "Landroidx/compose/material/icons/Icons$Filled;", "getSettings", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class SettingsKt {

    @Nullable
    private static ImageVector _settings;

    @NotNull
    public static final ImageVector getSettings(@NotNull Icons.Filled filled) {
        Intrinsics.checkNotNullParameter(filled, "<this>");
        ImageVector imageVector = _settings;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Filled.Settings", C2256Dp.m20968constructorimpl(24.0f), C2256Dp.m20968constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.INSTANCE.m18551getBlack0d7_KjU(), null);
        int iM18878getButtKaPHkGw = StrokeCap.INSTANCE.m18878getButtKaPHkGw();
        int iM18888getBevelLxFBmk8 = StrokeJoin.INSTANCE.m18888getBevelLxFBmk8();
        PathBuilder pathBuilderM12318c = AbstractC11014a.m12318c(19.14f, 12.94f);
        pathBuilderM12318c.curveToRelative(0.04f, -0.3f, 0.06f, -0.61f, 0.06f, -0.94f);
        pathBuilderM12318c.curveToRelative(0.0f, -0.32f, -0.02f, -0.64f, -0.07f, -0.94f);
        pathBuilderM12318c.lineToRelative(2.03f, -1.58f);
        pathBuilderM12318c.curveToRelative(0.18f, -0.14f, 0.23f, -0.41f, 0.12f, -0.61f);
        pathBuilderM12318c.lineToRelative(-1.92f, -3.32f);
        pathBuilderM12318c.curveToRelative(-0.12f, -0.22f, -0.37f, -0.29f, -0.59f, -0.22f);
        pathBuilderM12318c.lineToRelative(-2.39f, 0.96f);
        pathBuilderM12318c.curveToRelative(-0.5f, -0.38f, -1.03f, -0.7f, -1.62f, -0.94f);
        pathBuilderM12318c.lineTo(14.4f, 2.81f);
        pathBuilderM12318c.curveToRelative(-0.04f, -0.24f, -0.24f, -0.41f, -0.48f, -0.41f);
        pathBuilderM12318c.horizontalLineToRelative(-3.84f);
        pathBuilderM12318c.curveToRelative(-0.24f, 0.0f, -0.43f, 0.17f, -0.47f, 0.41f);
        pathBuilderM12318c.lineTo(9.25f, 5.35f);
        pathBuilderM12318c.curveTo(8.66f, 5.59f, 8.12f, 5.92f, 7.63f, 6.29f);
        pathBuilderM12318c.lineTo(5.24f, 5.33f);
        pathBuilderM12318c.curveToRelative(-0.22f, -0.08f, -0.47f, 0.0f, -0.59f, 0.22f);
        pathBuilderM12318c.lineTo(2.74f, 8.87f);
        pathBuilderM12318c.curveTo(2.62f, 9.08f, 2.66f, 9.34f, 2.86f, 9.48f);
        pathBuilderM12318c.lineToRelative(2.03f, 1.58f);
        pathBuilderM12318c.curveTo(4.84f, 11.36f, 4.8f, 11.69f, 4.8f, 12.0f);
        pathBuilderM12318c.reflectiveCurveToRelative(0.02f, 0.64f, 0.07f, 0.94f);
        pathBuilderM12318c.lineToRelative(-2.03f, 1.58f);
        pathBuilderM12318c.curveToRelative(-0.18f, 0.14f, -0.23f, 0.41f, -0.12f, 0.61f);
        pathBuilderM12318c.lineToRelative(1.92f, 3.32f);
        pathBuilderM12318c.curveToRelative(0.12f, 0.22f, 0.37f, 0.29f, 0.59f, 0.22f);
        pathBuilderM12318c.lineToRelative(2.39f, -0.96f);
        pathBuilderM12318c.curveToRelative(0.5f, 0.38f, 1.03f, 0.7f, 1.62f, 0.94f);
        pathBuilderM12318c.lineToRelative(0.36f, 2.54f);
        pathBuilderM12318c.curveToRelative(0.05f, 0.24f, 0.24f, 0.41f, 0.48f, 0.41f);
        pathBuilderM12318c.horizontalLineToRelative(3.84f);
        pathBuilderM12318c.curveToRelative(0.24f, 0.0f, 0.44f, -0.17f, 0.47f, -0.41f);
        pathBuilderM12318c.lineToRelative(0.36f, -2.54f);
        pathBuilderM12318c.curveToRelative(0.59f, -0.24f, 1.13f, -0.56f, 1.62f, -0.94f);
        pathBuilderM12318c.lineToRelative(2.39f, 0.96f);
        pathBuilderM12318c.curveToRelative(0.22f, 0.08f, 0.47f, 0.0f, 0.59f, -0.22f);
        pathBuilderM12318c.lineToRelative(1.92f, -3.32f);
        pathBuilderM12318c.curveToRelative(0.12f, -0.22f, 0.07f, -0.47f, -0.12f, -0.61f);
        pathBuilderM12318c.lineTo(19.14f, 12.94f);
        pathBuilderM12318c.close();
        pathBuilderM12318c.moveTo(12.0f, 15.6f);
        pathBuilderM12318c.curveToRelative(-1.98f, 0.0f, -3.6f, -1.62f, -3.6f, -3.6f);
        pathBuilderM12318c.reflectiveCurveToRelative(1.62f, -3.6f, 3.6f, -3.6f);
        pathBuilderM12318c.reflectiveCurveToRelative(3.6f, 1.62f, 3.6f, 3.6f);
        pathBuilderM12318c.reflectiveCurveTo(13.98f, 15.6f, 12.0f, 15.6f);
        pathBuilderM12318c.close();
        ImageVector imageVectorBuild = ImageVector.Builder.m19210addPathoIyEayM$default(builder, pathBuilderM12318c.getNodes(), defaultFillType, "", solidColor, 1.0f, null, 1.0f, 1.0f, iM18878getButtKaPHkGw, iM18888getBevelLxFBmk8, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null).build();
        _settings = imageVectorBuild;
        Intrinsics.checkNotNull(imageVectorBuild);
        return imageVectorBuild;
    }
}
