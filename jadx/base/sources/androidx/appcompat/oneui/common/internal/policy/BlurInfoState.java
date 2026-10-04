package androidx.appcompat.oneui.common.internal.policy;

import android.content.Context;
import androidx.annotation.RequiresApi;
import androidx.appcompat.oneui.common.internal.resource.ThemeResourceColor;
import androidx.appcompat.oneui.common.internal.semblurinfo.ColorCurvePreset;
import androidx.appcompat.oneui.common.internal.semblurinfo.SemBlurInfoStateBuilder;
import androidx.appcompat.oneui.common.internal.semblurinfo.SemBlurInfoStateKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, m13886d2 = {"Landroidx/appcompat/oneui/common/internal/policy/BlurInfoState;", "", "()V", "generateFloatingComponentBlurInfoStateBuilder", "Landroidx/appcompat/oneui/common/internal/semblurinfo/SemBlurInfoStateBuilder;", "context", "Landroid/content/Context;", "blurMode", "", "appcompat_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class BlurInfoState {

    @NotNull
    public static final BlurInfoState INSTANCE = new BlurInfoState();

    private BlurInfoState() {
    }

    @RequiresApi(35)
    @NotNull
    public final SemBlurInfoStateBuilder generateFloatingComponentBlurInfoStateBuilder(@NotNull Context context, int blurMode) {
        Intrinsics.checkNotNullParameter(context, "context");
        int i = 0;
        return new SemBlurInfoStateBuilder(blurMode, new ColorCurvePreset(SemBlurInfoStateKt.getFIGMA_BLUR_COMPONENT_LIGHT_THICK(), SemBlurInfoStateKt.getFIGMA_BLUR_COMPONENT_DARK_THICK()), new ThemeResourceColor(i, i, 2, null), 1);
    }
}
