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
import com.samsung.android.app.sdk.deepsky.textextraction.action.ActionConstants;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m13886d2 = {"_call", "Landroidx/compose/ui/graphics/vector/ImageVector;", ActionConstants.ACTION_CALL, "Landroidx/compose/material/icons/Icons$TwoTone;", "getCall", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class CallKt {

    @Nullable
    private static ImageVector _call;

    @NotNull
    public static final ImageVector getCall(@NotNull Icons.TwoTone twoTone) {
        Intrinsics.checkNotNullParameter(twoTone, "<this>");
        ImageVector imageVector = _call;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("TwoTone.Call", C2256Dp.m20968constructorimpl(24.0f), C2256Dp.m20968constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int defaultFillType = VectorKt.getDefaultFillType();
        Color.Companion companion = Color.INSTANCE;
        SolidColor solidColor = new SolidColor(companion.m18551getBlack0d7_KjU(), null);
        StrokeCap.Companion companion2 = StrokeCap.INSTANCE;
        int iM18878getButtKaPHkGw = companion2.m18878getButtKaPHkGw();
        StrokeJoin.Companion companion3 = StrokeJoin.INSTANCE;
        int iM18888getBevelLxFBmk8 = companion3.m18888getBevelLxFBmk8();
        PathBuilder pathBuilderM12318c = AbstractC11014a.m12318c(19.0f, 17.47f);
        pathBuilderM12318c.curveToRelative(-0.88f, -0.07f, -1.75f, -0.22f, -2.6f, -0.45f);
        pathBuilderM12318c.lineToRelative(-1.19f, 1.19f);
        pathBuilderM12318c.curveToRelative(1.2f, 0.41f, 2.48f, 0.67f, 3.8f, 0.75f);
        pathBuilderM12318c.verticalLineToRelative(-1.49f);
        pathBuilderM12318c.close();
        pathBuilderM12318c.moveTo(6.54f, 5.0f);
        pathBuilderM12318c.horizontalLineToRelative(-1.5f);
        pathBuilderM12318c.curveToRelative(0.09f, 1.32f, 0.35f, 2.59f, 0.75f, 3.8f);
        pathBuilderM12318c.lineToRelative(1.2f, -1.2f);
        pathBuilderM12318c.curveToRelative(-0.24f, -0.84f, -0.39f, -1.71f, -0.45f, -2.6f);
        pathBuilderM12318c.close();
        ImageVector.Builder.m19210addPathoIyEayM$default(builder, pathBuilderM12318c.getNodes(), defaultFillType, "", solidColor, 0.3f, null, 0.3f, 1.0f, iM18878getButtKaPHkGw, iM18888getBevelLxFBmk8, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null);
        int defaultFillType2 = VectorKt.getDefaultFillType();
        SolidColor solidColor2 = new SolidColor(companion.m18551getBlack0d7_KjU(), null);
        int iM18878getButtKaPHkGw2 = companion2.m18878getButtKaPHkGw();
        int iM18888getBevelLxFBmk82 = companion3.m18888getBevelLxFBmk8();
        PathBuilder pathBuilderM12318c2 = AbstractC11014a.m12318c(20.0f, 21.0f);
        pathBuilderM12318c2.curveToRelative(0.55f, 0.0f, 1.0f, -0.45f, 1.0f, -1.0f);
        pathBuilderM12318c2.verticalLineToRelative(-3.49f);
        pathBuilderM12318c2.curveToRelative(0.0f, -0.55f, -0.45f, -1.0f, -1.0f, -1.0f);
        pathBuilderM12318c2.curveToRelative(-1.24f, 0.0f, -2.45f, -0.2f, -3.57f, -0.57f);
        pathBuilderM12318c2.curveToRelative(-0.1f, -0.04f, -0.21f, -0.05f, -0.31f, -0.05f);
        pathBuilderM12318c2.curveToRelative(-0.26f, 0.0f, -0.51f, 0.1f, -0.71f, 0.29f);
        pathBuilderM12318c2.lineToRelative(-2.2f, 2.2f);
        pathBuilderM12318c2.curveToRelative(-2.83f, -1.45f, -5.15f, -3.76f, -6.59f, -6.59f);
        pathBuilderM12318c2.lineToRelative(2.2f, -2.2f);
        pathBuilderM12318c2.curveToRelative(0.28f, -0.28f, 0.36f, -0.67f, 0.25f, -1.02f);
        pathBuilderM12318c2.curveTo(8.7f, 6.45f, 8.5f, 5.25f, 8.5f, 4.0f);
        pathBuilderM12318c2.curveToRelative(0.0f, -0.55f, -0.45f, -1.0f, -1.0f, -1.0f);
        pathBuilderM12318c2.lineTo(4.0f, 3.0f);
        pathBuilderM12318c2.curveToRelative(-0.55f, 0.0f, -1.0f, 0.45f, -1.0f, 1.0f);
        pathBuilderM12318c2.curveToRelative(0.0f, 9.39f, 7.61f, 17.0f, 17.0f, 17.0f);
        pathBuilderM12318c2.close();
        pathBuilderM12318c2.moveTo(16.4f, 17.02f);
        pathBuilderM12318c2.curveToRelative(0.85f, 0.24f, 1.72f, 0.39f, 2.6f, 0.45f);
        pathBuilderM12318c2.verticalLineToRelative(1.49f);
        pathBuilderM12318c2.curveToRelative(-1.32f, -0.09f, -2.59f, -0.35f, -3.8f, -0.75f);
        pathBuilderM12318c2.lineToRelative(1.2f, -1.19f);
        pathBuilderM12318c2.close();
        pathBuilderM12318c2.moveTo(5.03f, 5.0f);
        pathBuilderM12318c2.horizontalLineToRelative(1.5f);
        pathBuilderM12318c2.curveToRelative(0.07f, 0.89f, 0.22f, 1.76f, 0.46f, 2.59f);
        pathBuilderM12318c2.lineToRelative(-1.2f, 1.2f);
        pathBuilderM12318c2.curveToRelative(-0.41f, -1.2f, -0.67f, -2.47f, -0.76f, -3.79f);
        pathBuilderM12318c2.close();
        ImageVector imageVectorBuild = ImageVector.Builder.m19210addPathoIyEayM$default(builder, pathBuilderM12318c2.getNodes(), defaultFillType2, "", solidColor2, 1.0f, null, 1.0f, 1.0f, iM18878getButtKaPHkGw2, iM18888getBevelLxFBmk82, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null).build();
        _call = imageVectorBuild;
        Intrinsics.checkNotNull(imageVectorBuild);
        return imageVectorBuild;
    }
}
