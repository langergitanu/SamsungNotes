package androidx.compose.p109ui.graphics;

import android.graphics.ColorSpace;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007\u001a\f\u0010\u0003\u001a\u00020\u0002*\u00020\u0001H\u0007¨\u0006\u0004"}, m13886d2 = {"toAndroidColorSpace", "Landroid/graphics/ColorSpace;", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "toComposeColorSpace", "ui-graphics_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class AndroidColorSpace_androidKt {
    @RequiresApi(26)
    @NotNull
    public static final ColorSpace toAndroidColorSpace(@NotNull androidx.compose.p109ui.graphics.colorspace.ColorSpace colorSpace) {
        return ColorSpaceVerificationHelper.androidColorSpace(colorSpace);
    }

    @RequiresApi(26)
    @NotNull
    public static final androidx.compose.p109ui.graphics.colorspace.ColorSpace toComposeColorSpace(@NotNull ColorSpace colorSpace) {
        return ColorSpaceVerificationHelper.composeColorSpace(colorSpace);
    }
}
