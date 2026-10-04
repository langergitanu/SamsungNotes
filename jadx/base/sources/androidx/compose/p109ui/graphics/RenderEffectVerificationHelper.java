package androidx.compose.p109ui.graphics;

import android.graphics.RenderEffect;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.compose.p109ui.geometry.Offset;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(31)
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J4\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ$\u0010\u000e\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0013"}, m13886d2 = {"Landroidx/compose/ui/graphics/RenderEffectVerificationHelper;", "", "()V", "createBlurEffect", "Landroid/graphics/RenderEffect;", "inputRenderEffect", "Landroidx/compose/ui/graphics/RenderEffect;", "radiusX", "", "radiusY", "edgeTreatment", "Landroidx/compose/ui/graphics/TileMode;", "createBlurEffect-8A-3gB4", "(Landroidx/compose/ui/graphics/RenderEffect;FFI)Landroid/graphics/RenderEffect;", "createOffsetEffect", TypedValues.Cycle.S_WAVE_OFFSET, "Landroidx/compose/ui/geometry/Offset;", "createOffsetEffect-Uv8p0NA", "(Landroidx/compose/ui/graphics/RenderEffect;J)Landroid/graphics/RenderEffect;", "ui-graphics_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
final class RenderEffectVerificationHelper {

    @NotNull
    public static final RenderEffectVerificationHelper INSTANCE = new RenderEffectVerificationHelper();

    private RenderEffectVerificationHelper() {
    }

    @DoNotInline
    @NotNull
    /* JADX INFO: renamed from: createBlurEffect-8A-3gB4, reason: not valid java name */
    public final RenderEffect m18835createBlurEffect8A3gB4(@Nullable RenderEffect inputRenderEffect, float radiusX, float radiusY, int edgeTreatment) {
        return inputRenderEffect == null ? RenderEffect.createBlurEffect(radiusX, radiusY, AndroidTileMode_androidKt.m18430toAndroidTileMode0vamqd0(edgeTreatment)) : RenderEffect.createBlurEffect(radiusX, radiusY, inputRenderEffect.asAndroidRenderEffect(), AndroidTileMode_androidKt.m18430toAndroidTileMode0vamqd0(edgeTreatment));
    }

    @DoNotInline
    @NotNull
    /* JADX INFO: renamed from: createOffsetEffect-Uv8p0NA, reason: not valid java name */
    public final RenderEffect m18836createOffsetEffectUv8p0NA(@Nullable RenderEffect inputRenderEffect, long offset) {
        return inputRenderEffect == null ? RenderEffect.createOffsetEffect(Offset.m18284getXimpl(offset), Offset.m18285getYimpl(offset)) : RenderEffect.createOffsetEffect(Offset.m18284getXimpl(offset), Offset.m18285getYimpl(offset), inputRenderEffect.asAndroidRenderEffect());
    }
}
