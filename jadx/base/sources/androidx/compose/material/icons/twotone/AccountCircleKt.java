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
@Metadata(m13885d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m13886d2 = {"_accountCircle", "Landroidx/compose/ui/graphics/vector/ImageVector;", "AccountCircle", "Landroidx/compose/material/icons/Icons$TwoTone;", "getAccountCircle", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class AccountCircleKt {

    @Nullable
    private static ImageVector _accountCircle;

    @NotNull
    public static final ImageVector getAccountCircle(@NotNull Icons.TwoTone twoTone) {
        Intrinsics.checkNotNullParameter(twoTone, "<this>");
        ImageVector imageVector = _accountCircle;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("TwoTone.AccountCircle", C2256Dp.m20968constructorimpl(24.0f), C2256Dp.m20968constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int defaultFillType = VectorKt.getDefaultFillType();
        Color.Companion companion = Color.INSTANCE;
        SolidColor solidColor = new SolidColor(companion.m18551getBlack0d7_KjU(), null);
        StrokeCap.Companion companion2 = StrokeCap.INSTANCE;
        int iM18878getButtKaPHkGw = companion2.m18878getButtKaPHkGw();
        StrokeJoin.Companion companion3 = StrokeJoin.INSTANCE;
        int iM18888getBevelLxFBmk8 = companion3.m18888getBevelLxFBmk8();
        PathBuilder pathBuilderM12318c = AbstractC11014a.m12318c(12.0f, 4.0f);
        pathBuilderM12318c.curveToRelative(-4.42f, 0.0f, -8.0f, 3.58f, -8.0f, 8.0f);
        pathBuilderM12318c.curveToRelative(0.0f, 1.95f, 0.7f, 3.73f, 1.86f, 5.12f);
        pathBuilderM12318c.curveTo(7.55f, 15.8f, 9.68f, 15.0f, 12.0f, 15.0f);
        pathBuilderM12318c.reflectiveCurveToRelative(4.45f, 0.8f, 6.14f, 2.12f);
        pathBuilderM12318c.curveTo(19.3f, 15.73f, 20.0f, 13.95f, 20.0f, 12.0f);
        pathBuilderM12318c.curveTo(20.0f, 7.58f, 16.42f, 4.0f, 12.0f, 4.0f);
        pathBuilderM12318c.close();
        pathBuilderM12318c.moveTo(12.0f, 13.0f);
        pathBuilderM12318c.curveToRelative(-1.93f, 0.0f, -3.5f, -1.57f, -3.5f, -3.5f);
        pathBuilderM12318c.curveTo(8.5f, 7.57f, 10.07f, 6.0f, 12.0f, 6.0f);
        pathBuilderM12318c.reflectiveCurveToRelative(3.5f, 1.57f, 3.5f, 3.5f);
        pathBuilderM12318c.curveTo(15.5f, 11.43f, 13.93f, 13.0f, 12.0f, 13.0f);
        pathBuilderM12318c.close();
        ImageVector.Builder.m19210addPathoIyEayM$default(builder, pathBuilderM12318c.getNodes(), defaultFillType, "", solidColor, 0.3f, null, 0.3f, 1.0f, iM18878getButtKaPHkGw, iM18888getBevelLxFBmk8, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null);
        int defaultFillType2 = VectorKt.getDefaultFillType();
        SolidColor solidColor2 = new SolidColor(companion.m18551getBlack0d7_KjU(), null);
        int iM18878getButtKaPHkGw2 = companion2.m18878getButtKaPHkGw();
        int iM18888getBevelLxFBmk82 = companion3.m18888getBevelLxFBmk8();
        PathBuilder pathBuilderM12318c2 = AbstractC11014a.m12318c(12.0f, 2.0f);
        pathBuilderM12318c2.curveTo(6.48f, 2.0f, 2.0f, 6.48f, 2.0f, 12.0f);
        pathBuilderM12318c2.curveToRelative(0.0f, 5.52f, 4.48f, 10.0f, 10.0f, 10.0f);
        pathBuilderM12318c2.reflectiveCurveToRelative(10.0f, -4.48f, 10.0f, -10.0f);
        pathBuilderM12318c2.curveTo(22.0f, 6.48f, 17.52f, 2.0f, 12.0f, 2.0f);
        pathBuilderM12318c2.close();
        pathBuilderM12318c2.moveTo(12.0f, 20.0f);
        pathBuilderM12318c2.curveToRelative(-1.74f, 0.0f, -3.34f, -0.56f, -4.65f, -1.5f);
        pathBuilderM12318c2.curveTo(8.66f, 17.56f, 10.26f, 17.0f, 12.0f, 17.0f);
        pathBuilderM12318c2.reflectiveCurveToRelative(3.34f, 0.56f, 4.65f, 1.5f);
        pathBuilderM12318c2.curveTo(15.34f, 19.44f, 13.74f, 20.0f, 12.0f, 20.0f);
        pathBuilderM12318c2.close();
        pathBuilderM12318c2.moveTo(18.14f, 17.12f);
        pathBuilderM12318c2.curveTo(16.45f, 15.8f, 14.32f, 15.0f, 12.0f, 15.0f);
        pathBuilderM12318c2.reflectiveCurveToRelative(-4.45f, 0.8f, -6.14f, 2.12f);
        pathBuilderM12318c2.curveTo(4.7f, 15.73f, 4.0f, 13.95f, 4.0f, 12.0f);
        pathBuilderM12318c2.curveToRelative(0.0f, -4.42f, 3.58f, -8.0f, 8.0f, -8.0f);
        pathBuilderM12318c2.reflectiveCurveToRelative(8.0f, 3.58f, 8.0f, 8.0f);
        pathBuilderM12318c2.curveTo(20.0f, 13.95f, 19.3f, 15.73f, 18.14f, 17.12f);
        pathBuilderM12318c2.close();
        ImageVector.Builder.m19210addPathoIyEayM$default(builder, pathBuilderM12318c2.getNodes(), defaultFillType2, "", solidColor2, 1.0f, null, 1.0f, 1.0f, iM18878getButtKaPHkGw2, iM18888getBevelLxFBmk82, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null);
        int defaultFillType3 = VectorKt.getDefaultFillType();
        SolidColor solidColor3 = new SolidColor(companion.m18551getBlack0d7_KjU(), null);
        int iM18878getButtKaPHkGw3 = companion2.m18878getButtKaPHkGw();
        int iM18888getBevelLxFBmk83 = companion3.m18888getBevelLxFBmk8();
        PathBuilder pathBuilderM12318c3 = AbstractC11014a.m12318c(12.0f, 5.93f);
        pathBuilderM12318c3.curveToRelative(-1.93f, 0.0f, -3.5f, 1.57f, -3.5f, 3.5f);
        pathBuilderM12318c3.curveToRelative(0.0f, 1.93f, 1.57f, 3.5f, 3.5f, 3.5f);
        pathBuilderM12318c3.reflectiveCurveToRelative(3.5f, -1.57f, 3.5f, -3.5f);
        pathBuilderM12318c3.curveTo(15.5f, 7.5f, 13.93f, 5.93f, 12.0f, 5.93f);
        pathBuilderM12318c3.close();
        pathBuilderM12318c3.moveTo(12.0f, 10.93f);
        pathBuilderM12318c3.curveToRelative(-0.83f, 0.0f, -1.5f, -0.67f, -1.5f, -1.5f);
        pathBuilderM12318c3.reflectiveCurveToRelative(0.67f, -1.5f, 1.5f, -1.5f);
        pathBuilderM12318c3.reflectiveCurveToRelative(1.5f, 0.67f, 1.5f, 1.5f);
        pathBuilderM12318c3.reflectiveCurveTo(12.83f, 10.93f, 12.0f, 10.93f);
        pathBuilderM12318c3.close();
        ImageVector imageVectorBuild = ImageVector.Builder.m19210addPathoIyEayM$default(builder, pathBuilderM12318c3.getNodes(), defaultFillType3, "", solidColor3, 1.0f, null, 1.0f, 1.0f, iM18878getButtKaPHkGw3, iM18888getBevelLxFBmk83, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null).build();
        _accountCircle = imageVectorBuild;
        Intrinsics.checkNotNull(imageVectorBuild);
        return imageVectorBuild;
    }
}
