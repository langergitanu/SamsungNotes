package com.samsung.android.sesl.visualeffect.lighteffects.guidinglight;

import android.animation.ValueAnimator;
import android.util.Log;
import androidx.annotation.RequiresApi;
import com.samsung.android.sdk.mobileservice.profile.Profile;
import com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.AnimationFactory;
import com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.GuidingLightEffect;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@RequiresApi(33)
@Metadata(m13885d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0001\u0018\u0000 +2\u00020\u0001:\u0002+,B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J+\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010\u0015J\u001a\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00172\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0006\u0010\u0018\u001a\u00020\u000eJ\u0006\u0010\u0019\u001a\u00020\u000eJ)\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0002\u0010\u0015J\u001a\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u00172\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\u0012\u0010\u001d\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\u001a\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u001f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J)\u0010 \u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010!\u001a\u00020\"H\u0002¢\u0006\u0002\u0010#J\u001a\u0010$\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J \u0010%\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\nH\u0002J\u0018\u0010*\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/AnimationManager;", "", ExternalDataConstants.EmbeddingConfig.KEY, "Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightConfig;", "lightControl", "Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightControl;", "<init>", "(Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightConfig;Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightControl;)V", "showAnimations", "", "Landroid/animation/ValueAnimator;", "[Landroid/animation/ValueAnimator;", "hideAnimation", "showWithAnimation", "", "animationType", "Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightEffect$ShowAnimationType;", "customDuration", "", Profile.PhoneNumberData.TYPE_CALLBACK, "Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/AnimationManager$AnimationCallback;", "(Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightEffect$ShowAnimationType;Ljava/lang/Long;Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/AnimationManager$AnimationCallback;)V", "hideWithAnimation", "Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightEffect$HideAnimationType;", "cancelAllAnimations", "release", "runShowAnimation", "type", "runHideAnimation", "createSizeAnimation", "createLuminanceAnimation", "Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/AnimationFactory$Companion$AnimationType;", "createNowBarAnimation", "isShortcut", "", "(Ljava/lang/Long;Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/AnimationManager$AnimationCallback;Z)V", "hideByLuminance", "updateSizeByAnimation", "litRadius", "", "refRadius", "animator", "updateSize", "Companion", "AnimationCallback", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nAnimationManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnimationManager.kt\ncom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/AnimationManager\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,316:1\n13409#2,2:317\n1863#3,2:319\n*S KotlinDebug\n*F\n+ 1 AnimationManager.kt\ncom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/AnimationManager\n*L\n70#1:317,2\n79#1:319,2\n*E\n"})
public final class AnimationManager {

    @NotNull
    private static final String TAG = "AnimationManager";

    @NotNull
    private final GuidingLightConfig config;

    @Nullable
    private ValueAnimator hideAnimation;

    @NotNull
    private final GuidingLightControl lightControl;

    @NotNull
    private final ValueAnimator[] showAnimations;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/AnimationManager$AnimationCallback;", "", "onAnimationStart", "", "onAnimationEnd", "onAnimationCancel", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface AnimationCallback {
        void onAnimationCancel();

        void onAnimationEnd();

        void onAnimationStart();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[GuidingLightEffect.ShowAnimationType.values().length];
            try {
                iArr[GuidingLightEffect.ShowAnimationType.SIZE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[GuidingLightEffect.ShowAnimationType.LUMINANCE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[GuidingLightEffect.ShowAnimationType.LUMINANCE_LONG.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[GuidingLightEffect.ShowAnimationType.NOW_BAR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[GuidingLightEffect.ShowAnimationType.NOW_BAR_SHORTCUT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[GuidingLightEffect.ShowAnimationType.NONE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[GuidingLightEffect.HideAnimationType.values().length];
            try {
                iArr2[GuidingLightEffect.HideAnimationType.LUMINANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[GuidingLightEffect.HideAnimationType.LUMINANCE_LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[GuidingLightEffect.HideAnimationType.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public AnimationManager(@NotNull GuidingLightConfig config, @NotNull GuidingLightControl lightControl) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(lightControl, "lightControl");
        this.config = config;
        this.lightControl = lightControl;
        this.showAnimations = new ValueAnimator[]{null, null, null};
    }

    private final void createLuminanceAnimation(AnimationFactory.Companion.AnimationType animationType, AnimationCallback callback) {
        float globalLuminance = this.config.getGlobalLuminance();
        int i = 0;
        this.showAnimations[0] = AnimationFactory.Companion.createAnimation$default(AnimationFactory.INSTANCE, animationType, new C7850b(this, globalLuminance, i), null, new RunnableC7852d(callback, 2), new RunnableC7856h(this, globalLuminance, callback, i), null, 36, null);
        ValueAnimator valueAnimator = this.showAnimations[0];
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createLuminanceAnimation$lambda$10(AnimationManager animationManager, float f, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        GuidingLightRenderEffect renderEffect = animationManager.lightControl.getRenderEffect();
        if (renderEffect != null) {
            Object animatedValue = it.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            renderEffect.setGlobalLuminance(((Float) animatedValue).floatValue() * f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createLuminanceAnimation$lambda$11(AnimationManager animationManager, float f, AnimationCallback animationCallback) {
        GuidingLightRenderEffect renderEffect = animationManager.lightControl.getRenderEffect();
        if (renderEffect != null) {
            renderEffect.setGlobalLuminance(f);
        }
        if (animationCallback != null) {
            animationCallback.onAnimationCancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createLuminanceAnimation$lambda$12(AnimationCallback animationCallback) {
        if (animationCallback != null) {
            animationCallback.onAnimationEnd();
        }
    }

    private final void createNowBarAnimation(Long customDuration, AnimationCallback callback, boolean isShortcut) {
        AnimationManager animationManager = this;
        float lightRadius = animationManager.config.getLightRadius();
        float reflLightRadius = animationManager.config.getReflLightRadius();
        ValueAnimator[] valueAnimatorArr = animationManager.showAnimations;
        AnimationFactory.Companion companion = AnimationFactory.INSTANCE;
        int i = 0;
        valueAnimatorArr[0] = AnimationFactory.Companion.createAnimation$default(companion, AnimationFactory.Companion.AnimationType.SHOW_SIZE_NOW_BAR_PHASE_1, new C7854f(lightRadius, reflLightRadius, i, animationManager), null, new RunnableC7855g(animationManager, i), new RunnableC7851c(animationManager, lightRadius, reflLightRadius, callback, 1), customDuration, 4, null);
        if (isShortcut) {
            ValueAnimator[] valueAnimatorArr2 = animationManager.showAnimations;
            AnimationFactory.Companion.AnimationType animationType = AnimationFactory.Companion.AnimationType.HIDE_SIZE_NOW_BAR;
            C7854f c7854f = new C7854f(lightRadius, reflLightRadius, 1, animationManager);
            RunnableC7851c runnableC7851c = new RunnableC7851c(animationManager, lightRadius, reflLightRadius, callback, 2);
            animationManager = this;
            valueAnimatorArr2[1] = AnimationFactory.Companion.createAnimation$default(companion, animationType, c7854f, null, new RunnableC7851c(animationManager, lightRadius, reflLightRadius, callback, 3), runnableC7851c, null, 36, null);
        } else {
            animationManager.showAnimations[1] = AnimationFactory.Companion.createAnimation$default(companion, AnimationFactory.Companion.AnimationType.SHOW_SIZE_NOW_BAR_PHASE_2, new C7854f(lightRadius, reflLightRadius, 2, animationManager), null, new RunnableC7852d(callback, 1), new RunnableC7851c(animationManager, lightRadius, reflLightRadius, callback, 4), null, 36, null);
        }
        ValueAnimator valueAnimator = animationManager.showAnimations[0];
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createNowBarAnimation$lambda$13(AnimationManager animationManager, float f, float f4, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        animationManager.updateSizeByAnimation(f, f4, it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createNowBarAnimation$lambda$14(AnimationManager animationManager) {
        ValueAnimator valueAnimator = animationManager.showAnimations[1];
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createNowBarAnimation$lambda$15(AnimationManager animationManager, float f, float f4, AnimationCallback animationCallback) {
        animationManager.updateSize(f, f4);
        if (animationCallback != null) {
            animationCallback.onAnimationCancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createNowBarAnimation$lambda$16(AnimationManager animationManager, float f, float f4, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        animationManager.updateSizeByAnimation(f, f4, it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createNowBarAnimation$lambda$17(AnimationManager animationManager, float f, float f4, AnimationCallback animationCallback) {
        animationManager.updateSize(f, f4);
        if (animationCallback != null) {
            animationCallback.onAnimationCancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createNowBarAnimation$lambda$18(AnimationManager animationManager, float f, float f4, AnimationCallback animationCallback) {
        animationManager.updateSize(f, f4);
        if (animationCallback != null) {
            animationCallback.onAnimationEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createNowBarAnimation$lambda$19(AnimationManager animationManager, float f, float f4, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        animationManager.updateSizeByAnimation(f, f4, it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createNowBarAnimation$lambda$20(AnimationManager animationManager, float f, float f4, AnimationCallback animationCallback) {
        animationManager.updateSize(f, f4);
        if (animationCallback != null) {
            animationCallback.onAnimationCancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createNowBarAnimation$lambda$21(AnimationCallback animationCallback) {
        if (animationCallback != null) {
            animationCallback.onAnimationEnd();
        }
    }

    private final void createSizeAnimation(AnimationCallback callback) {
        float lightRadius = this.config.getLightRadius();
        float reflLightRadius = this.config.getReflLightRadius();
        ValueAnimator[] valueAnimatorArr = this.showAnimations;
        AnimationFactory.Companion companion = AnimationFactory.INSTANCE;
        valueAnimatorArr[0] = AnimationFactory.Companion.createAnimation$default(companion, AnimationFactory.Companion.AnimationType.SHOW_SIZE_PHASE_1, new C7854f(lightRadius, reflLightRadius, 3, this), null, new RunnableC7855g(this, 1), new RunnableC7851c(this, lightRadius, reflLightRadius, callback, 5), null, 36, null);
        this.showAnimations[1] = AnimationFactory.Companion.createAnimation$default(companion, AnimationFactory.Companion.AnimationType.SHOW_SIZE_PHASE_2, new C7854f(lightRadius, reflLightRadius, 4, this), null, new RunnableC7852d(callback, 0), new RunnableC7851c(this, lightRadius, reflLightRadius, callback, 0), null, 36, null);
        float globalLuminance = this.config.getGlobalLuminance();
        this.showAnimations[2] = AnimationFactory.Companion.createAnimation$default(companion, AnimationFactory.Companion.AnimationType.SHOW_LUMINANCE, new C7850b(this, globalLuminance, 1), null, null, new RunnableC7853e(this, globalLuminance, 0), null, 44, null);
        ValueAnimator valueAnimator = this.showAnimations[0];
        if (valueAnimator != null) {
            valueAnimator.start();
        }
        ValueAnimator valueAnimator2 = this.showAnimations[2];
        if (valueAnimator2 != null) {
            valueAnimator2.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createSizeAnimation$lambda$2(AnimationManager animationManager, float f, float f4, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        animationManager.updateSizeByAnimation(f, f4, it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createSizeAnimation$lambda$3(AnimationManager animationManager) {
        ValueAnimator valueAnimator = animationManager.showAnimations[1];
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createSizeAnimation$lambda$4(AnimationManager animationManager, float f, float f4, AnimationCallback animationCallback) {
        animationManager.updateSize(f, f4);
        if (animationCallback != null) {
            animationCallback.onAnimationCancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createSizeAnimation$lambda$5(AnimationManager animationManager, float f, float f4, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        animationManager.updateSizeByAnimation(f, f4, it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createSizeAnimation$lambda$6(AnimationManager animationManager, float f, float f4, AnimationCallback animationCallback) {
        animationManager.updateSize(f, f4);
        if (animationCallback != null) {
            animationCallback.onAnimationCancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createSizeAnimation$lambda$7(AnimationCallback animationCallback) {
        if (animationCallback != null) {
            animationCallback.onAnimationEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createSizeAnimation$lambda$8(AnimationManager animationManager, float f, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        GuidingLightRenderEffect renderEffect = animationManager.lightControl.getRenderEffect();
        if (renderEffect != null) {
            Object animatedValue = it.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            renderEffect.setGlobalLuminance(((Float) animatedValue).floatValue() * f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createSizeAnimation$lambda$9(AnimationManager animationManager, float f) {
        GuidingLightRenderEffect renderEffect = animationManager.lightControl.getRenderEffect();
        if (renderEffect != null) {
            renderEffect.setGlobalLuminance(f);
        }
    }

    private final void hideByLuminance(AnimationFactory.Companion.AnimationType type, AnimationCallback callback) {
        float globalLuminance = this.config.getGlobalLuminance();
        ValueAnimator valueAnimatorCreateAnimation$default = AnimationFactory.Companion.createAnimation$default(AnimationFactory.INSTANCE, type, new C7850b(this, globalLuminance, 2), null, new RunnableC7856h(this, globalLuminance, callback, 1), new RunnableC7852d(callback, 3), null, 36, null);
        this.hideAnimation = valueAnimatorCreateAnimation$default;
        if (valueAnimatorCreateAnimation$default != null) {
            valueAnimatorCreateAnimation$default.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hideByLuminance$lambda$22(AnimationManager animationManager, float f, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        GuidingLightRenderEffect renderEffect = animationManager.lightControl.getRenderEffect();
        if (renderEffect != null) {
            Object animatedValue = it.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            renderEffect.setGlobalLuminance(((Float) animatedValue).floatValue() * f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hideByLuminance$lambda$23(AnimationManager animationManager, float f, AnimationCallback animationCallback) {
        GuidingLightRenderEffect renderEffect = animationManager.lightControl.getRenderEffect();
        if (renderEffect != null) {
            renderEffect.setGlobalLuminance(f);
        }
        if (animationCallback != null) {
            animationCallback.onAnimationEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hideByLuminance$lambda$24(AnimationCallback animationCallback) {
        if (animationCallback != null) {
            animationCallback.onAnimationCancel();
        }
    }

    public static /* synthetic */ void hideWithAnimation$default(AnimationManager animationManager, GuidingLightEffect.HideAnimationType hideAnimationType, AnimationCallback animationCallback, int i, Object obj) {
        if ((i & 2) != 0) {
            animationCallback = null;
        }
        animationManager.hideWithAnimation(hideAnimationType, animationCallback);
    }

    private final void runHideAnimation(GuidingLightEffect.HideAnimationType type, AnimationCallback callback) {
        cancelAllAnimations();
        if (callback != null) {
            callback.onAnimationStart();
        }
        int i = WhenMappings.$EnumSwitchMapping$1[type.ordinal()];
        if (i == 1) {
            hideByLuminance(AnimationFactory.Companion.AnimationType.HIDE_LUMINANCE, callback);
            return;
        }
        if (i == 2) {
            hideByLuminance(AnimationFactory.Companion.AnimationType.HIDE_LUMINANCE_LONG, callback);
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            if (callback != null) {
                callback.onAnimationEnd();
            }
        }
    }

    private final void runShowAnimation(GuidingLightEffect.ShowAnimationType type, Long customDuration, AnimationCallback callback) {
        cancelAllAnimations();
        if (callback != null) {
            callback.onAnimationStart();
        }
        switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
            case 1:
                createSizeAnimation(callback);
                return;
            case 2:
                createLuminanceAnimation(AnimationFactory.Companion.AnimationType.SHOW_LUMINANCE, callback);
                return;
            case 3:
                createLuminanceAnimation(AnimationFactory.Companion.AnimationType.SHOW_LUMINANCE_LONG, callback);
                return;
            case 4:
                createNowBarAnimation(customDuration, callback, false);
                return;
            case 5:
                createNowBarAnimation(customDuration, callback, true);
                return;
            case 6:
                GuidingLightRenderEffect renderEffect = this.lightControl.getRenderEffect();
                if (renderEffect != null) {
                    renderEffect.update(true);
                }
                if (callback != null) {
                    callback.onAnimationEnd();
                    return;
                }
                return;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static /* synthetic */ void showWithAnimation$default(AnimationManager animationManager, GuidingLightEffect.ShowAnimationType showAnimationType, Long l, AnimationCallback animationCallback, int i, Object obj) {
        if ((i & 2) != 0) {
            l = null;
        }
        if ((i & 4) != 0) {
            animationCallback = null;
        }
        animationManager.showWithAnimation(showAnimationType, l, animationCallback);
    }

    private final void updateSize(float litRadius, float refRadius) {
        GuidingLightRenderEffect renderEffect = this.lightControl.getRenderEffect();
        if (renderEffect != null) {
            renderEffect.setLightRadius(litRadius);
        }
        GuidingLightRenderEffect renderEffect2 = this.lightControl.getRenderEffect();
        if (renderEffect2 != null) {
            renderEffect2.setReflLightRadius(refRadius);
        }
    }

    private final void updateSizeByAnimation(float litRadius, float refRadius, ValueAnimator animator) {
        Object animatedValue = animator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float fFloatValue = ((Float) animatedValue).floatValue() * litRadius;
        Object animatedValue2 = animator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue2, "null cannot be cast to non-null type kotlin.Float");
        updateSize(fFloatValue, ((Float) animatedValue2).floatValue() * refRadius);
    }

    public final void cancelAllAnimations() {
        for (ValueAnimator valueAnimator : this.showAnimations) {
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
        }
        ValueAnimator valueAnimator2 = this.hideAnimation;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
    }

    public final void hideWithAnimation(@NotNull GuidingLightEffect.HideAnimationType animationType, @Nullable AnimationCallback callback) {
        Intrinsics.checkNotNullParameter(animationType, "animationType");
        Log.i(TAG, "Hide animation: " + animationType);
        runHideAnimation(animationType, callback);
    }

    public final void release() {
        cancelAllAnimations();
        Iterator<Integer> it = ArraysKt.getIndices(this.showAnimations).iterator();
        while (it.hasNext()) {
            this.showAnimations[((IntIterator) it).nextInt()] = null;
        }
    }

    public final void showWithAnimation(@NotNull GuidingLightEffect.ShowAnimationType animationType, @Nullable Long customDuration, @Nullable AnimationCallback callback) {
        Intrinsics.checkNotNullParameter(animationType, "animationType");
        Log.i(TAG, "Show animation: " + animationType);
        runShowAnimation(animationType, customDuration, callback);
    }
}
