package androidx.appcompat.oneui.common.internal.semblurinfo;

import androidx.annotation.RestrictTo;
import androidx.core.view.SemBlurCompat;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0016\u0010\u0000\u001a\u00020\u00018\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0004\u001a\u00020\u00018\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0003¨\u0006\u0006"}, m13886d2 = {"FIGMA_BLUR_COMPONENT_DARK_THICK", "Landroidx/core/view/SemBlurCompat$CurveParameter;", "getFIGMA_BLUR_COMPONENT_DARK_THICK", "()Landroidx/core/view/SemBlurCompat$CurveParameter;", "FIGMA_BLUR_COMPONENT_LIGHT_THICK", "getFIGMA_BLUR_COMPONENT_LIGHT_THICK", "appcompat_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class SemBlurInfoStateKt {

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    private static final SemBlurCompat.CurveParameter FIGMA_BLUR_COMPONENT_LIGHT_THICK = new SemBlurCompat.CurveParameter(300, 0.4f, 15.0f, 15.0f, 235.0f, 176.7f, 253.2f);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    private static final SemBlurCompat.CurveParameter FIGMA_BLUR_COMPONENT_DARK_THICK = new SemBlurCompat.CurveParameter(300, 0.5f, -15.0f, 0.0f, 255.0f, 33.8f, 153.7f);

    @NotNull
    public static final SemBlurCompat.CurveParameter getFIGMA_BLUR_COMPONENT_DARK_THICK() {
        return FIGMA_BLUR_COMPONENT_DARK_THICK;
    }

    @NotNull
    public static final SemBlurCompat.CurveParameter getFIGMA_BLUR_COMPONENT_LIGHT_THICK() {
        return FIGMA_BLUR_COMPONENT_LIGHT_THICK;
    }
}
