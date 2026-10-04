package com.samsung.android.support.senl.p148nt.composer.main.base.util;

import android.content.Context;
import android.os.Build;
import android.view.View;
import com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.GuidingLightConfig;
import com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.GuidingLightEffect;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.PresetEffectColor;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiViewUtils;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J \u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005J\u0018\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/util/GuidingLightEffectUtil;", "", "<init>", "()V", "createGuidingLightEffect", "Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightEffect;", "targetView", "Landroid/view/View;", "radiusPixel", "", "insetPixel", "", "createGuidingLightEffectNudge", "createGuidingLightEffectResultBG", Constants.IntentExtraValue.SHOW, "", "effect", "release", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class GuidingLightEffectUtil {

    @NotNull
    public static final GuidingLightEffectUtil INSTANCE = new GuidingLightEffectUtil();

    private GuidingLightEffectUtil() {
    }

    @JvmStatic
    @Nullable
    public static final GuidingLightEffect createGuidingLightEffect(@NotNull View targetView, float radiusPixel, int insetPixel) {
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        if (Build.VERSION.SDK_INT < 33) {
            return null;
        }
        boolean zIsNightMode = ContextUtils.isNightMode(targetView.getContext());
        GuidingLightConfig guidingLightConfig = !AiViewUtils.isAtLeastOneUI85() ? zIsNightMode ? GuidingLightConfig.DEFAULT_DARK : GuidingLightConfig.DEFAULT_LIGHT : zIsNightMode ? GuidingLightConfig.BUTTON_DARK : GuidingLightConfig.BUTTON_LIGHT;
        Context context = targetView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        GuidingLightEffect guidingLightEffect = new GuidingLightEffect(context, targetView, guidingLightConfig);
        guidingLightEffect.setCornerRadiusPixel(radiusPixel, GuidingLightEffect.CornerRadiusSide.ALL);
        if (!AiViewUtils.isAtLeastOneUI85()) {
            guidingLightEffect.setColorState(PresetEffectColor.State.Common);
        }
        guidingLightEffect.setInsetPixel(insetPixel);
        guidingLightEffect.setDefaultTouchInteraction(true);
        return guidingLightEffect;
    }

    @JvmStatic
    @Nullable
    public static final GuidingLightEffect createGuidingLightEffectResultBG(@NotNull View targetView) {
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        if (Build.VERSION.SDK_INT < 33) {
            return null;
        }
        Context context = targetView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        GuidingLightEffect guidingLightEffect = new GuidingLightEffect(context, targetView, ContextUtils.isNightMode(targetView.getContext()) ? GuidingLightConfig.RESULT_DARK : GuidingLightConfig.RESULT_LIGHT);
        guidingLightEffect.setCornerRadiusPixel(0.0f);
        guidingLightEffect.setLightMovement(GuidingLightEffect.Movement.NONE);
        return guidingLightEffect;
    }

    @Nullable
    public final GuidingLightEffect createGuidingLightEffectNudge(@NotNull View targetView, float radiusPixel, int insetPixel) {
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        if (Build.VERSION.SDK_INT < 33) {
            return null;
        }
        Context context = targetView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        GuidingLightEffect guidingLightEffect = new GuidingLightEffect(context, targetView, ContextUtils.isNightMode(targetView.getContext()) ? GuidingLightConfig.NUDGE_DARK : GuidingLightConfig.NUDGE_LIGHT);
        guidingLightEffect.setCornerRadiusPixel(radiusPixel, GuidingLightEffect.CornerRadiusSide.ALL);
        guidingLightEffect.setInsetPixel(insetPixel);
        guidingLightEffect.setLightMovement(GuidingLightEffect.Movement.NONE);
        guidingLightEffect.setDefaultTouchInteraction(true);
        return guidingLightEffect;
    }

    public final void release(@Nullable GuidingLightEffect effect, @NotNull View targetView) {
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        if (Build.VERSION.SDK_INT < 33 || effect == null) {
            return;
        }
        effect.hide(GuidingLightEffect.HideAnimationType.NONE);
        effect.remove(targetView);
        effect.release();
    }

    public final void show(@Nullable GuidingLightEffect effect) {
        if (Build.VERSION.SDK_INT < 33 || effect == null) {
            return;
        }
        effect.show(GuidingLightEffect.ShowAnimationType.NONE);
    }
}
