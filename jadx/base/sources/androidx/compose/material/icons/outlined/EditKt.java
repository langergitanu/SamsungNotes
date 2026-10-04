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
@Metadata(m13885d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m13886d2 = {"_edit", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Edit", "Landroidx/compose/material/icons/Icons$Outlined;", "getEdit", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class EditKt {

    @Nullable
    private static ImageVector _edit;

    @NotNull
    public static final ImageVector getEdit(@NotNull Icons.Outlined outlined) {
        Intrinsics.checkNotNullParameter(outlined, "<this>");
        ImageVector imageVector = _edit;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Outlined.Edit", C2256Dp.m20968constructorimpl(24.0f), C2256Dp.m20968constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.INSTANCE.m18551getBlack0d7_KjU(), null);
        int iM18878getButtKaPHkGw = StrokeCap.INSTANCE.m18878getButtKaPHkGw();
        int iM18888getBevelLxFBmk8 = StrokeJoin.INSTANCE.m18888getBevelLxFBmk8();
        PathBuilder pathBuilderM12319d = AbstractC11014a.m12319d(14.06f, 9.02f, 0.92f, 0.92f);
        pathBuilderM12319d.lineTo(5.92f, 19.0f);
        pathBuilderM12319d.lineTo(5.0f, 19.0f);
        pathBuilderM12319d.verticalLineToRelative(-0.92f);
        pathBuilderM12319d.lineToRelative(9.06f, -9.06f);
        pathBuilderM12319d.moveTo(17.66f, 3.0f);
        pathBuilderM12319d.curveToRelative(-0.25f, 0.0f, -0.51f, 0.1f, -0.7f, 0.29f);
        pathBuilderM12319d.lineToRelative(-1.83f, 1.83f);
        pathBuilderM12319d.lineToRelative(3.75f, 3.75f);
        pathBuilderM12319d.lineToRelative(1.83f, -1.83f);
        pathBuilderM12319d.curveToRelative(0.39f, -0.39f, 0.39f, -1.02f, 0.0f, -1.41f);
        pathBuilderM12319d.lineToRelative(-2.34f, -2.34f);
        pathBuilderM12319d.curveToRelative(-0.2f, -0.2f, -0.45f, -0.29f, -0.71f, -0.29f);
        pathBuilderM12319d.close();
        pathBuilderM12319d.moveTo(14.06f, 6.19f);
        pathBuilderM12319d.lineTo(3.0f, 17.25f);
        pathBuilderM12319d.lineTo(3.0f, 21.0f);
        pathBuilderM12319d.horizontalLineToRelative(3.75f);
        pathBuilderM12319d.lineTo(17.81f, 9.94f);
        pathBuilderM12319d.lineToRelative(-3.75f, -3.75f);
        pathBuilderM12319d.close();
        ImageVector imageVectorBuild = ImageVector.Builder.m19210addPathoIyEayM$default(builder, pathBuilderM12319d.getNodes(), defaultFillType, "", solidColor, 1.0f, null, 1.0f, 1.0f, iM18878getButtKaPHkGw, iM18888getBevelLxFBmk8, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null).build();
        _edit = imageVectorBuild;
        Intrinsics.checkNotNull(imageVectorBuild);
        return imageVectorBuild;
    }
}
