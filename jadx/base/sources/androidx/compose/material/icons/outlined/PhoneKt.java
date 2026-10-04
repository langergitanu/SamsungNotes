package androidx.compose.material.icons.outlined;

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
@Metadata(m13885d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m13886d2 = {"_phone", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Phone", "Landroidx/compose/material/icons/Icons$Outlined;", "getPhone", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class PhoneKt {

    @Nullable
    private static ImageVector _phone;

    @NotNull
    public static final ImageVector getPhone(@NotNull Icons.Outlined outlined) {
        Intrinsics.checkNotNullParameter(outlined, "<this>");
        ImageVector imageVector = _phone;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Outlined.Phone", C2256Dp.m20968constructorimpl(24.0f), C2256Dp.m20968constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.INSTANCE.m18551getBlack0d7_KjU(), null);
        int iM18878getButtKaPHkGw = StrokeCap.INSTANCE.m18878getButtKaPHkGw();
        int iM18888getBevelLxFBmk8 = StrokeJoin.INSTANCE.m18888getBevelLxFBmk8();
        PathBuilder pathBuilderM12318c = AbstractC11014a.m12318c(6.54f, 5.0f);
        pathBuilderM12318c.curveToRelative(0.06f, 0.89f, 0.21f, 1.76f, 0.45f, 2.59f);
        pathBuilderM12318c.lineToRelative(-1.2f, 1.2f);
        pathBuilderM12318c.curveToRelative(-0.41f, -1.2f, -0.67f, -2.47f, -0.76f, -3.79f);
        pathBuilderM12318c.horizontalLineToRelative(1.51f);
        pathBuilderM12318c.moveToRelative(9.86f, 12.02f);
        pathBuilderM12318c.curveToRelative(0.85f, 0.24f, 1.72f, 0.39f, 2.6f, 0.45f);
        pathBuilderM12318c.verticalLineToRelative(1.49f);
        pathBuilderM12318c.curveToRelative(-1.32f, -0.09f, -2.59f, -0.35f, -3.8f, -0.75f);
        pathBuilderM12318c.lineToRelative(1.2f, -1.19f);
        pathBuilderM12318c.moveTo(7.5f, 3.0f);
        pathBuilderM12318c.horizontalLineTo(4.0f);
        pathBuilderM12318c.curveToRelative(-0.55f, 0.0f, -1.0f, 0.45f, -1.0f, 1.0f);
        pathBuilderM12318c.curveToRelative(0.0f, 9.39f, 7.61f, 17.0f, 17.0f, 17.0f);
        pathBuilderM12318c.curveToRelative(0.55f, 0.0f, 1.0f, -0.45f, 1.0f, -1.0f);
        pathBuilderM12318c.verticalLineToRelative(-3.49f);
        pathBuilderM12318c.curveToRelative(0.0f, -0.55f, -0.45f, -1.0f, -1.0f, -1.0f);
        pathBuilderM12318c.curveToRelative(-1.24f, 0.0f, -2.45f, -0.2f, -3.57f, -0.57f);
        pathBuilderM12318c.curveToRelative(-0.1f, -0.04f, -0.21f, -0.05f, -0.31f, -0.05f);
        pathBuilderM12318c.curveToRelative(-0.26f, 0.0f, -0.51f, 0.1f, -0.71f, 0.29f);
        pathBuilderM12318c.lineToRelative(-2.2f, 2.2f);
        pathBuilderM12318c.curveToRelative(-2.83f, -1.45f, -5.15f, -3.76f, -6.59f, -6.59f);
        pathBuilderM12318c.lineToRelative(2.2f, -2.2f);
        pathBuilderM12318c.curveToRelative(0.28f, -0.28f, 0.36f, -0.67f, 0.25f, -1.02f);
        pathBuilderM12318c.curveTo(8.7f, 6.45f, 8.5f, 5.25f, 8.5f, 4.0f);
        pathBuilderM12318c.curveToRelative(0.0f, -0.55f, -0.45f, -1.0f, -1.0f, -1.0f);
        pathBuilderM12318c.close();
        ImageVector imageVectorBuild = ImageVector.Builder.m19210addPathoIyEayM$default(builder, pathBuilderM12318c.getNodes(), defaultFillType, "", solidColor, 1.0f, null, 1.0f, 1.0f, iM18878getButtKaPHkGw, iM18888getBevelLxFBmk8, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null).build();
        _phone = imageVectorBuild;
        Intrinsics.checkNotNull(imageVectorBuild);
        return imageVectorBuild;
    }
}
