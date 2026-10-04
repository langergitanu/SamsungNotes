package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.voice;

import android.content.Context;
import android.view.View;
import androidx.annotation.RequiresApi;
import com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.GuidingLightConfig;
import com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.GuidingLightEffect;
import com.samsung.android.sesl.visualeffect.lighteffects.processinglight.ProcessingLightConfig;
import com.samsung.android.sesl.visualeffect.lighteffects.processinglight.ProcessingLightEffect;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.PresetEffectColor;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiViewUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p035H2.RunnableC0117b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\tJ\u0012\u0010\u000e\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0006H\u0007J,\u0010\u000f\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0007J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0006H\u0007J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0006H\u0007R\u001c\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/voice/AIGuidingLightEffect;", "", "<init>", "()V", "mProcessingEffectMap", "", "Landroid/view/View;", "Lcom/samsung/android/sesl/visualeffect/lighteffects/processinglight/ProcessingLightEffect;", "effectMap", "Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightEffect;", "add", "", "view", "effect", "removeGuideLightingEffect", "applyGuidingLightEffectBackground", "context", "Landroid/content/Context;", "inset", "", "cornerRadius", "makeProcessingLightEffect", "removeProcessingLightEffect", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class AIGuidingLightEffect {

    @NotNull
    public static final AIGuidingLightEffect INSTANCE = new AIGuidingLightEffect();

    @Nullable
    private static Map<View, ProcessingLightEffect> mProcessingEffectMap = new LinkedHashMap();

    @Nullable
    private static Map<View, GuidingLightEffect> effectMap = new LinkedHashMap();

    private AIGuidingLightEffect() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [T, com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.GuidingLightEffect] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @JvmStatic
    @RequiresApi(33)
    public static final void applyGuidingLightEffectBackground(@Nullable View view, @Nullable Context context, int inset, int cornerRadius) {
        if (view == null || context == null) {
            return;
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Map<View, GuidingLightEffect> map = effectMap;
        T t = map != null ? map.get(view) : 0;
        objectRef.element = t;
        if (t == 0) {
            ?? guidingLightEffect = new GuidingLightEffect(context, view, !AiViewUtils.isAtLeastOneUI85() ? GuidingLightConfig.DEFAULT_LIGHT : GuidingLightConfig.BUTTON_LIGHT);
            objectRef.element = guidingLightEffect;
            INSTANCE.add(view, guidingLightEffect);
        }
        view.post(new RunnableC0117b(objectRef, cornerRadius, inset, 6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void applyGuidingLightEffectBackground$lambda$2$lambda$1(Ref.ObjectRef objectRef, int i, int i2) {
        GuidingLightEffect guidingLightEffect = (GuidingLightEffect) objectRef.element;
        guidingLightEffect.setCornerRadiusPixel(i);
        guidingLightEffect.setInsetPixel(i2);
        if (!AiViewUtils.isAtLeastOneUI85()) {
            guidingLightEffect.setColorState(PresetEffectColor.State.Input);
        }
        guidingLightEffect.setDefaultTouchInteraction(false);
        GuidingLightEffect.show$default(guidingLightEffect, null, 1, null);
    }

    @JvmStatic
    @RequiresApi(33)
    public static final void removeGuideLightingEffect(@Nullable View view) {
        if (view == null) {
            return;
        }
        Map<View, GuidingLightEffect> map = effectMap;
        GuidingLightEffect guidingLightEffectRemove = map != null ? map.remove(view) : null;
        if (guidingLightEffectRemove != null) {
            guidingLightEffectRemove.hide(GuidingLightEffect.HideAnimationType.NONE);
        }
        if (guidingLightEffectRemove != null) {
            guidingLightEffectRemove.remove(view);
        }
        if (guidingLightEffectRemove != null) {
            guidingLightEffectRemove.release();
        }
    }

    public final void add(@Nullable View view, @Nullable GuidingLightEffect effect) {
        Map<View, GuidingLightEffect> map;
        if (view == null || effect == null) {
            return;
        }
        Map<View, GuidingLightEffect> map2 = effectMap;
        if ((map2 != null ? map2.get(view) : null) == null && (map = effectMap) != null) {
            map.put(view, effect);
        }
    }

    @RequiresApi(api = 33)
    @NotNull
    public final ProcessingLightEffect makeProcessingLightEffect(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Map<View, ProcessingLightEffect> map = mProcessingEffectMap;
        ProcessingLightEffect processingLightEffect = map != null ? map.get(view) : null;
        if (processingLightEffect != null) {
            return processingLightEffect;
        }
        ProcessingLightConfig vi_config_default = ProcessingLightConfig.INSTANCE.getVI_CONFIG_DEFAULT();
        vi_config_default.setAngle(60.0f);
        vi_config_default.setBlendMode(ProcessingLightConfig.BlendMode.PREMULT);
        ProcessingLightEffect processingLightEffect2 = new ProcessingLightEffect(view.getContext(), view, vi_config_default);
        Map<View, ProcessingLightEffect> map2 = mProcessingEffectMap;
        if (map2 != null) {
            map2.put(view, processingLightEffect2);
        }
        return processingLightEffect2;
    }

    @RequiresApi(api = 33)
    public final void removeProcessingLightEffect(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Map<View, ProcessingLightEffect> map = mProcessingEffectMap;
        ProcessingLightEffect processingLightEffectRemove = map != null ? map.remove(view) : null;
        if (processingLightEffectRemove != null) {
            processingLightEffectRemove.remove(view);
        }
        if (processingLightEffectRemove != null) {
            processingLightEffectRemove.stop();
        }
        if (processingLightEffectRemove != null) {
            processingLightEffectRemove.release();
        }
    }
}
