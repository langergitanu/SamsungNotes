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
@Metadata(m13885d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m13886d2 = {"_exitToApp", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ExitToApp", "Landroidx/compose/material/icons/Icons$Filled;", "getExitToApp", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class ExitToAppKt {

    @Nullable
    private static ImageVector _exitToApp;

    @NotNull
    public static final ImageVector getExitToApp(@NotNull Icons.Filled filled) {
        Intrinsics.checkNotNullParameter(filled, "<this>");
        ImageVector imageVector = _exitToApp;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Filled.ExitToApp", C2256Dp.m20968constructorimpl(24.0f), C2256Dp.m20968constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.INSTANCE.m18551getBlack0d7_KjU(), null);
        int iM18878getButtKaPHkGw = StrokeCap.INSTANCE.m18878getButtKaPHkGw();
        int iM18888getBevelLxFBmk8 = StrokeJoin.INSTANCE.m18888getBevelLxFBmk8();
        PathBuilder pathBuilderM12312A = AbstractC11014a.m12312A(10.09f, 15.59f, 11.5f, 17.0f);
        pathBuilderM12312A.lineToRelative(5.0f, -5.0f);
        pathBuilderM12312A.lineToRelative(-5.0f, -5.0f);
        pathBuilderM12312A.lineToRelative(-1.41f, 1.41f);
        pathBuilderM12312A.lineTo(12.67f, 11.0f);
        pathBuilderM12312A.horizontalLineTo(3.0f);
        pathBuilderM12312A.verticalLineToRelative(2.0f);
        pathBuilderM12312A.horizontalLineToRelative(9.67f);
        pathBuilderM12312A.lineToRelative(-2.58f, 2.59f);
        pathBuilderM12312A.close();
        pathBuilderM12312A.moveTo(19.0f, 3.0f);
        pathBuilderM12312A.horizontalLineTo(5.0f);
        pathBuilderM12312A.curveToRelative(-1.11f, 0.0f, -2.0f, 0.9f, -2.0f, 2.0f);
        pathBuilderM12312A.verticalLineToRelative(4.0f);
        pathBuilderM12312A.horizontalLineToRelative(2.0f);
        pathBuilderM12312A.verticalLineTo(5.0f);
        pathBuilderM12312A.horizontalLineToRelative(14.0f);
        pathBuilderM12312A.verticalLineToRelative(14.0f);
        pathBuilderM12312A.horizontalLineTo(5.0f);
        pathBuilderM12312A.verticalLineToRelative(-4.0f);
        pathBuilderM12312A.horizontalLineTo(3.0f);
        pathBuilderM12312A.verticalLineToRelative(4.0f);
        pathBuilderM12312A.curveToRelative(0.0f, 1.1f, 0.89f, 2.0f, 2.0f, 2.0f);
        pathBuilderM12312A.horizontalLineToRelative(14.0f);
        pathBuilderM12312A.curveToRelative(1.1f, 0.0f, 2.0f, -0.9f, 2.0f, -2.0f);
        pathBuilderM12312A.verticalLineTo(5.0f);
        pathBuilderM12312A.curveToRelative(0.0f, -1.1f, -0.9f, -2.0f, -2.0f, -2.0f);
        pathBuilderM12312A.close();
        ImageVector imageVectorBuild = ImageVector.Builder.m19210addPathoIyEayM$default(builder, pathBuilderM12312A.getNodes(), defaultFillType, "", solidColor, 1.0f, null, 1.0f, 1.0f, iM18878getButtKaPHkGw, iM18888getBevelLxFBmk8, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null).build();
        _exitToApp = imageVectorBuild;
        Intrinsics.checkNotNull(imageVectorBuild);
        return imageVectorBuild;
    }
}
