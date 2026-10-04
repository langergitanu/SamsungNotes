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
@Metadata(m13885d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m13886d2 = {"_send", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Send", "Landroidx/compose/material/icons/Icons$TwoTone;", "getSend", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class SendKt {

    @Nullable
    private static ImageVector _send;

    @NotNull
    public static final ImageVector getSend(@NotNull Icons.TwoTone twoTone) {
        Intrinsics.checkNotNullParameter(twoTone, "<this>");
        ImageVector imageVector = _send;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("TwoTone.Send", C2256Dp.m20968constructorimpl(24.0f), C2256Dp.m20968constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int defaultFillType = VectorKt.getDefaultFillType();
        Color.Companion companion = Color.INSTANCE;
        SolidColor solidColor = new SolidColor(companion.m18551getBlack0d7_KjU(), null);
        StrokeCap.Companion companion2 = StrokeCap.INSTANCE;
        int iM18878getButtKaPHkGw = companion2.m18878getButtKaPHkGw();
        StrokeJoin.Companion companion3 = StrokeJoin.INSTANCE;
        int iM18888getBevelLxFBmk8 = companion3.m18888getBevelLxFBmk8();
        PathBuilder pathBuilderM12319d = AbstractC11014a.m12319d(4.0f, 8.25f, 7.51f, 1.0f);
        pathBuilderM12319d.lineToRelative(-7.5f, -3.22f);
        pathBuilderM12319d.close();
        pathBuilderM12319d.moveTo(4.01f, 17.97f);
        ImageVector.Builder.m19210addPathoIyEayM$default(builder, AbstractC11014a.m12313B(pathBuilderM12319d, 7.5f, -3.22f, -7.51f, 1.0f), defaultFillType, "", solidColor, 0.3f, null, 0.3f, 1.0f, iM18878getButtKaPHkGw, iM18888getBevelLxFBmk8, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null);
        int defaultFillType2 = VectorKt.getDefaultFillType();
        SolidColor solidColor2 = new SolidColor(companion.m18551getBlack0d7_KjU(), null);
        int iM18878getButtKaPHkGw2 = companion2.m18878getButtKaPHkGw();
        int iM18888getBevelLxFBmk82 = companion3.m18888getBevelLxFBmk8();
        PathBuilder pathBuilderM12312A = AbstractC11014a.m12312A(2.01f, 3.0f, 2.0f, 10.0f);
        pathBuilderM12312A.lineToRelative(15.0f, 2.0f);
        pathBuilderM12312A.lineToRelative(-15.0f, 2.0f);
        pathBuilderM12312A.lineToRelative(0.01f, 7.0f);
        pathBuilderM12312A.lineTo(23.0f, 12.0f);
        pathBuilderM12312A.lineTo(2.01f, 3.0f);
        pathBuilderM12312A.close();
        pathBuilderM12312A.moveTo(4.0f, 8.25f);
        pathBuilderM12312A.lineTo(4.0f, 6.03f);
        pathBuilderM12312A.lineToRelative(7.51f, 3.22f);
        pathBuilderM12312A.lineToRelative(-7.51f, -1.0f);
        pathBuilderM12312A.close();
        pathBuilderM12312A.moveTo(4.01f, 17.97f);
        pathBuilderM12312A.verticalLineToRelative(-2.22f);
        ImageVector imageVectorBuild = ImageVector.Builder.m19210addPathoIyEayM$default(builder, AbstractC11014a.m12313B(pathBuilderM12312A, 7.51f, -1.0f, -7.51f, 3.22f), defaultFillType2, "", solidColor2, 1.0f, null, 1.0f, 1.0f, iM18878getButtKaPHkGw2, iM18888getBevelLxFBmk82, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null).build();
        _send = imageVectorBuild;
        Intrinsics.checkNotNull(imageVectorBuild);
        return imageVectorBuild;
    }
}
