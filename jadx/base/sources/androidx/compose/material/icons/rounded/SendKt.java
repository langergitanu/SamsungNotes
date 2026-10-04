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
@Metadata(m13885d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m13886d2 = {"_send", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Send", "Landroidx/compose/material/icons/Icons$Rounded;", "getSend", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class SendKt {

    @Nullable
    private static ImageVector _send;

    @NotNull
    public static final ImageVector getSend(@NotNull Icons.Rounded rounded) {
        Intrinsics.checkNotNullParameter(rounded, "<this>");
        ImageVector imageVector = _send;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Rounded.Send", C2256Dp.m20968constructorimpl(24.0f), C2256Dp.m20968constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.INSTANCE.m18551getBlack0d7_KjU(), null);
        int iM18878getButtKaPHkGw = StrokeCap.INSTANCE.m18878getButtKaPHkGw();
        int iM18888getBevelLxFBmk8 = StrokeJoin.INSTANCE.m18888getBevelLxFBmk8();
        PathBuilder pathBuilderM12319d = AbstractC11014a.m12319d(3.4f, 20.4f, 17.45f, -7.48f);
        pathBuilderM12319d.curveToRelative(0.81f, -0.35f, 0.81f, -1.49f, 0.0f, -1.84f);
        pathBuilderM12319d.lineTo(3.4f, 3.6f);
        pathBuilderM12319d.curveToRelative(-0.66f, -0.29f, -1.39f, 0.2f, -1.39f, 0.91f);
        pathBuilderM12319d.lineTo(2.0f, 9.12f);
        pathBuilderM12319d.curveToRelative(0.0f, 0.5f, 0.37f, 0.93f, 0.87f, 0.99f);
        pathBuilderM12319d.lineTo(17.0f, 12.0f);
        pathBuilderM12319d.lineTo(2.87f, 13.88f);
        pathBuilderM12319d.curveToRelative(-0.5f, 0.07f, -0.87f, 0.5f, -0.87f, 1.0f);
        pathBuilderM12319d.lineToRelative(0.01f, 4.61f);
        pathBuilderM12319d.curveToRelative(0.0f, 0.71f, 0.73f, 1.2f, 1.39f, 0.91f);
        pathBuilderM12319d.close();
        ImageVector imageVectorBuild = ImageVector.Builder.m19210addPathoIyEayM$default(builder, pathBuilderM12319d.getNodes(), defaultFillType, "", solidColor, 1.0f, null, 1.0f, 1.0f, iM18878getButtKaPHkGw, iM18888getBevelLxFBmk8, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null).build();
        _send = imageVectorBuild;
        Intrinsics.checkNotNull(imageVectorBuild);
        return imageVectorBuild;
    }
}
