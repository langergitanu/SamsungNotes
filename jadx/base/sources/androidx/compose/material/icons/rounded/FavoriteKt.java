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
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m13886d2 = {"_favorite", "Landroidx/compose/ui/graphics/vector/ImageVector;", FolderConstants.Favorite.DISPLAY_NAME, "Landroidx/compose/material/icons/Icons$Rounded;", "getFavorite", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class FavoriteKt {

    @Nullable
    private static ImageVector _favorite;

    @NotNull
    public static final ImageVector getFavorite(@NotNull Icons.Rounded rounded) {
        Intrinsics.checkNotNullParameter(rounded, "<this>");
        ImageVector imageVector = _favorite;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Rounded.Favorite", C2256Dp.m20968constructorimpl(24.0f), C2256Dp.m20968constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.INSTANCE.m18551getBlack0d7_KjU(), null);
        int iM18878getButtKaPHkGw = StrokeCap.INSTANCE.m18878getButtKaPHkGw();
        int iM18888getBevelLxFBmk8 = StrokeJoin.INSTANCE.m18888getBevelLxFBmk8();
        PathBuilder pathBuilderM12318c = AbstractC11014a.m12318c(13.35f, 20.13f);
        pathBuilderM12318c.curveToRelative(-0.76f, 0.69f, -1.93f, 0.69f, -2.69f, -0.01f);
        pathBuilderM12318c.lineToRelative(-0.11f, -0.1f);
        pathBuilderM12318c.curveTo(5.3f, 15.27f, 1.87f, 12.16f, 2.0f, 8.28f);
        pathBuilderM12318c.curveToRelative(0.06f, -1.7f, 0.93f, -3.33f, 2.34f, -4.29f);
        pathBuilderM12318c.curveToRelative(2.64f, -1.8f, 5.9f, -0.96f, 7.66f, 1.1f);
        pathBuilderM12318c.curveToRelative(1.76f, -2.06f, 5.02f, -2.91f, 7.66f, -1.1f);
        pathBuilderM12318c.curveToRelative(1.41f, 0.96f, 2.28f, 2.59f, 2.34f, 4.29f);
        pathBuilderM12318c.curveToRelative(0.14f, 3.88f, -3.3f, 6.99f, -8.55f, 11.76f);
        pathBuilderM12318c.lineToRelative(-0.1f, 0.09f);
        pathBuilderM12318c.close();
        ImageVector imageVectorBuild = ImageVector.Builder.m19210addPathoIyEayM$default(builder, pathBuilderM12318c.getNodes(), defaultFillType, "", solidColor, 1.0f, null, 1.0f, 1.0f, iM18878getButtKaPHkGw, iM18888getBevelLxFBmk8, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null).build();
        _favorite = imageVectorBuild;
        Intrinsics.checkNotNull(imageVectorBuild);
        return imageVectorBuild;
    }
}
