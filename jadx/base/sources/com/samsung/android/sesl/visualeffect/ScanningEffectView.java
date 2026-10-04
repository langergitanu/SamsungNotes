package com.samsung.android.sesl.visualeffect;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.annotation.RequiresApi;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.WiggleAnimationConfig;
import com.samsung.android.sesl.visualeffect.surfaceeffects.ripple.MultiRippleController;
import com.samsung.android.sesl.visualeffect.surfaceeffects.ripple.MultiRippleView;
import com.samsung.android.sesl.visualeffect.surfaceeffects.ripple.RippleAnimation;
import com.samsung.android.sesl.visualeffect.surfaceeffects.ripple.RippleAnimationConfig;
import com.samsung.android.sesl.visualeffect.surfaceeffects.ripple.RippleShader;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 O2\u00020\u00012\u00020\u0002:\u0003OPQB\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010H\u001a\u00020IH\u0014J\b\u0010J\u001a\u00020IH\u0017J\b\u0010K\u001a\u00020LH\u0007J\b\u0010M\u001a\u00020LH\u0003J\b\u0010N\u001a\u00020IH\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R(\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u00108V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010%\"\u0004\b*\u0010'R\u001a\u0010+\u001a\u00020,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001e\u00101\u001a\u0002028\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001a\u00107\u001a\u00020,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010.\"\u0004\b9\u00100R\u001a\u0010:\u001a\u00020,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010.\"\u0004\b<\u00100R\u001a\u0010=\u001a\u00020,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010.\"\u0004\b?\u00100R*\u0010@\u001a\u0012\u0012\u0004\u0012\u00020B0Aj\b\u0012\u0004\u0012\u00020B`CX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010G¨\u0006R"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/ScanningEffectView;", "Lcom/samsung/android/sesl/visualeffect/EffectView;", "Lcom/samsung/android/sesl/visualeffect/MaskingSupportedEffectView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "multiRippleView", "Lcom/samsung/android/sesl/visualeffect/surfaceeffects/ripple/MultiRippleView;", "multiRippleController", "Lcom/samsung/android/sesl/visualeffect/surfaceeffects/ripple/MultiRippleController;", "sparkleView", "sparkleController", "value", "Landroid/graphics/Path;", "maskPath", "getMaskPath", "()Landroid/graphics/Path;", "setMaskPath", "(Landroid/graphics/Path;)V", "startPoint", "Landroid/graphics/PointF;", "getStartPoint", "()Landroid/graphics/PointF;", "setStartPoint", "(Landroid/graphics/PointF;)V", "interpolator", "Landroid/view/animation/Interpolator;", "getInterpolator", "()Landroid/view/animation/Interpolator;", "setInterpolator", "(Landroid/view/animation/Interpolator;)V", "sparkleStrength", "", "getSparkleStrength", "()F", "setSparkleStrength", "(F)V", "sparkleScale", "getSparkleScale", "setSparkleScale", "sparkleColor", "", "getSparkleColor", "()I", "setSparkleColor", "(I)V", "sparkleFadeParams", "Lcom/samsung/android/sesl/visualeffect/surfaceeffects/ripple/RippleShader$FadeParams;", "getSparkleFadeParams", "()Lcom/samsung/android/sesl/visualeffect/surfaceeffects/ripple/RippleShader$FadeParams;", "setSparkleFadeParams", "(Lcom/samsung/android/sesl/visualeffect/surfaceeffects/ripple/RippleShader$FadeParams;)V", "rippleInnerColor", "getRippleInnerColor", "setRippleInnerColor", "rippleCenterColor", "getRippleCenterColor", "setRippleCenterColor", "rippleOuterColor", "getRippleOuterColor", "setRippleOuterColor", "rippleConfigs", "Ljava/util/ArrayList;", "Lcom/samsung/android/sesl/visualeffect/ScanningEffectView$RippleConfig;", "Lkotlin/collections/ArrayList;", "getRippleConfigs", "()Ljava/util/ArrayList;", "setRippleConfigs", "(Ljava/util/ArrayList;)V", "initView", "", "startAnimation", "startAnimationTokenized", "Lcom/samsung/android/sesl/visualeffect/ScanningEffectView$AnimationToken;", "startScanningAnimation", "reset", "Companion", "RippleConfig", "AnimationToken", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nScanningEffectView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScanningEffectView.kt\ncom/samsung/android/sesl/visualeffect/ScanningEffectView\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,289:1\n1#2:290\n*E\n"})
public final class ScanningEffectView extends EffectView implements MaskingSupportedEffectView {
    public static final int RIPPLE1_ALPHA_DEFAULT = 60;
    public static final int RIPPLE3_ALPHA_DEFAULT = 80;
    public static final float RIPPLE_SIZE_SCALE_DEFAULT = 1.45f;
    public static final float SPARKLE_SIZE_SCALE_DEFAULT = 1.45f;
    public static final float SPARKLE_STRENGTH_DEFAULT = 0.25f;

    @NotNull
    public static final String TAG = "ScanningEffectView";

    @NotNull
    private Interpolator interpolator;
    private MultiRippleController multiRippleController;
    private MultiRippleView multiRippleView;
    private int rippleCenterColor;

    @NotNull
    private ArrayList<RippleConfig> rippleConfigs;
    private int rippleInnerColor;
    private int rippleOuterColor;
    private int sparkleColor;
    private MultiRippleController sparkleController;

    @RequiresApi(33)
    @NotNull
    private RippleShader.FadeParams sparkleFadeParams;
    private float sparkleScale;
    private float sparkleStrength;
    private MultiRippleView sparkleView;

    @NotNull
    private PointF startPoint;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int COLOR_SPARKLE = Color.parseColor("#FFFFFF");
    private static final int COLOR_RIPPLE_INNER = Color.parseColor("#2275FF");
    private static final int COLOR_RIPPLE_CENTER = Color.parseColor("#23C492");
    private static final int COLOR_RIPPLE_OUTER = Color.parseColor("#2275FF");

    @RequiresApi(33)
    @NotNull
    private static final RippleShader.FadeParams SPARKLE_FADE_PARAMS_DEFAULT = new RippleShader.FadeParams(0.0f, 0.65f, 0.15f, 1.0f);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u00103\u001a\u000204H\u0000¢\u0006\u0002\b5J\u0006\u00106\u001a\u000207J\u000e\u00108\u001a\u0002042\u0006\u00109\u001a\u00020\u001dJ\b\u0010:\u001a\u000204H\u0007R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR*\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0011j\b\u0012\u0004\u0012\u00020\u0005`\u0012X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R*\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0011j\b\u0012\u0004\u0012\u00020\u000b`\u0012X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010%\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020$8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u0010*\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b+\u0010!\"\u0004\b,\u0010#R$\u0010-\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b.\u0010!\"\u0004\b/\u0010#R$\u00100\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b1\u0010!\"\u0004\b2\u0010#¨\u0006;"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/ScanningEffectView$AnimationToken;", "", "<init>", "()V", "sparkleAnimation", "Lcom/samsung/android/sesl/visualeffect/surfaceeffects/ripple/RippleAnimation;", "getSparkleAnimation$sesl_visualeffect_INTERNAL_2_1_10_release", "()Lcom/samsung/android/sesl/visualeffect/surfaceeffects/ripple/RippleAnimation;", "setSparkleAnimation$sesl_visualeffect_INTERNAL_2_1_10_release", "(Lcom/samsung/android/sesl/visualeffect/surfaceeffects/ripple/RippleAnimation;)V", "sparkleConfig", "Lcom/samsung/android/sesl/visualeffect/surfaceeffects/ripple/RippleAnimationConfig;", "getSparkleConfig$sesl_visualeffect_INTERNAL_2_1_10_release", "()Lcom/samsung/android/sesl/visualeffect/surfaceeffects/ripple/RippleAnimationConfig;", "setSparkleConfig$sesl_visualeffect_INTERNAL_2_1_10_release", "(Lcom/samsung/android/sesl/visualeffect/surfaceeffects/ripple/RippleAnimationConfig;)V", "rippleAnimations", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getRippleAnimations$sesl_visualeffect_INTERNAL_2_1_10_release", "()Ljava/util/ArrayList;", "setRippleAnimations$sesl_visualeffect_INTERNAL_2_1_10_release", "(Ljava/util/ArrayList;)V", "rippleConfigs", "getRippleConfigs$sesl_visualeffect_INTERNAL_2_1_10_release", "setRippleConfigs$sesl_visualeffect_INTERNAL_2_1_10_release", "expireCount", "", "onExpiredRunnable", "Ljava/lang/Runnable;", "value", "sparkleColor", "getSparkleColor", "()I", "setSparkleColor", "(I)V", "", "sparkleStrength", "getSparkleStrength", "()F", "setSparkleStrength", "(F)V", "rippleOuterColor", "getRippleOuterColor", "setRippleOuterColor", "rippleCenterColor", "getRippleCenterColor", "setRippleCenterColor", "rippleInnerColor", "getRippleInnerColor", "setRippleInnerColor", "countExpired", "", "countExpired$sesl_visualeffect_INTERNAL_2_1_10_release", "isExpired", "", "setOnExpired", "runnable", "updateConfigs", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nScanningEffectView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScanningEffectView.kt\ncom/samsung/android/sesl/visualeffect/ScanningEffectView$AnimationToken\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,289:1\n1863#2,2:290\n*S KotlinDebug\n*F\n+ 1 ScanningEffectView.kt\ncom/samsung/android/sesl/visualeffect/ScanningEffectView$AnimationToken\n*L\n156#1:290,2\n*E\n"})
    public static final class AnimationToken {
        private int expireCount;

        @Nullable
        private Runnable onExpiredRunnable;

        @NotNull
        private ArrayList<RippleAnimation> rippleAnimations = new ArrayList<>();

        @NotNull
        private ArrayList<RippleAnimationConfig> rippleConfigs = new ArrayList<>();

        @Nullable
        private RippleAnimation sparkleAnimation;

        @Nullable
        private RippleAnimationConfig sparkleConfig;

        public final void countExpired$sesl_visualeffect_INTERNAL_2_1_10_release() {
            Runnable runnable;
            this.expireCount++;
            if (!isExpired() || (runnable = this.onExpiredRunnable) == null) {
                return;
            }
            runnable.run();
        }

        @NotNull
        public final ArrayList<RippleAnimation> getRippleAnimations$sesl_visualeffect_INTERNAL_2_1_10_release() {
            return this.rippleAnimations;
        }

        public final int getRippleCenterColor() {
            return this.rippleConfigs.get(2).getColor();
        }

        @NotNull
        public final ArrayList<RippleAnimationConfig> getRippleConfigs$sesl_visualeffect_INTERNAL_2_1_10_release() {
            return this.rippleConfigs;
        }

        public final int getRippleInnerColor() {
            return this.rippleConfigs.get(1).getColor();
        }

        public final int getRippleOuterColor() {
            return this.rippleConfigs.get(0).getColor();
        }

        @Nullable
        /* JADX INFO: renamed from: getSparkleAnimation$sesl_visualeffect_INTERNAL_2_1_10_release, reason: from getter */
        public final RippleAnimation getSparkleAnimation() {
            return this.sparkleAnimation;
        }

        public final int getSparkleColor() {
            RippleAnimationConfig rippleAnimationConfig = this.sparkleConfig;
            if (rippleAnimationConfig != null) {
                return rippleAnimationConfig.getSparkleColor();
            }
            return 0;
        }

        @Nullable
        /* JADX INFO: renamed from: getSparkleConfig$sesl_visualeffect_INTERNAL_2_1_10_release, reason: from getter */
        public final RippleAnimationConfig getSparkleConfig() {
            return this.sparkleConfig;
        }

        public final float getSparkleStrength() {
            RippleAnimationConfig rippleAnimationConfig = this.sparkleConfig;
            if (rippleAnimationConfig != null) {
                return rippleAnimationConfig.getSparkleStrength();
            }
            return 0.0f;
        }

        public final boolean isExpired() {
            return this.expireCount >= this.rippleConfigs.size() + 1;
        }

        public final void setOnExpired(@NotNull Runnable runnable) {
            Intrinsics.checkNotNullParameter(runnable, "runnable");
            this.onExpiredRunnable = runnable;
        }

        public final void setRippleAnimations$sesl_visualeffect_INTERNAL_2_1_10_release(@NotNull ArrayList<RippleAnimation> arrayList) {
            Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
            this.rippleAnimations = arrayList;
        }

        public final void setRippleCenterColor(int i) {
            this.rippleConfigs.get(2).setColor(i);
        }

        public final void setRippleConfigs$sesl_visualeffect_INTERNAL_2_1_10_release(@NotNull ArrayList<RippleAnimationConfig> arrayList) {
            Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
            this.rippleConfigs = arrayList;
        }

        public final void setRippleInnerColor(int i) {
            this.rippleConfigs.get(1).setColor(i);
        }

        public final void setRippleOuterColor(int i) {
            this.rippleConfigs.get(0).setColor(i);
        }

        public final void setSparkleAnimation$sesl_visualeffect_INTERNAL_2_1_10_release(@Nullable RippleAnimation rippleAnimation) {
            this.sparkleAnimation = rippleAnimation;
        }

        public final void setSparkleColor(int i) {
            RippleAnimationConfig rippleAnimationConfig = this.sparkleConfig;
            if (rippleAnimationConfig != null) {
                rippleAnimationConfig.setSparkleColor(i);
            }
        }

        public final void setSparkleConfig$sesl_visualeffect_INTERNAL_2_1_10_release(@Nullable RippleAnimationConfig rippleAnimationConfig) {
            this.sparkleConfig = rippleAnimationConfig;
        }

        public final void setSparkleStrength(float f) {
            RippleAnimationConfig rippleAnimationConfig = this.sparkleConfig;
            if (rippleAnimationConfig != null) {
                rippleAnimationConfig.setSparkleStrength(f);
            }
        }

        @RequiresApi(33)
        public final void updateConfigs() {
            if (isExpired()) {
                Log.w(ScanningEffectView.TAG, "updateConfigs called but the token is already expired. ");
                return;
            }
            RippleAnimation rippleAnimation = this.sparkleAnimation;
            if (rippleAnimation != null) {
                rippleAnimation.updateConfigs();
            }
            Iterator<T> it = this.rippleAnimations.iterator();
            while (it.hasNext()) {
                ((RippleAnimation) it.next()).updateConfigs();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u0011\u0010\u000e\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\tR\u000e\u0010\u0010\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\u00020\u00168\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/ScanningEffectView$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "COLOR_SPARKLE", "", "getCOLOR_SPARKLE", "()I", "COLOR_RIPPLE_INNER", "getCOLOR_RIPPLE_INNER", "COLOR_RIPPLE_CENTER", "getCOLOR_RIPPLE_CENTER", "COLOR_RIPPLE_OUTER", "getCOLOR_RIPPLE_OUTER", "RIPPLE1_ALPHA_DEFAULT", "RIPPLE3_ALPHA_DEFAULT", "RIPPLE_SIZE_SCALE_DEFAULT", "", "SPARKLE_STRENGTH_DEFAULT", "SPARKLE_FADE_PARAMS_DEFAULT", "Lcom/samsung/android/sesl/visualeffect/surfaceeffects/ripple/RippleShader$FadeParams;", "getSPARKLE_FADE_PARAMS_DEFAULT", "()Lcom/samsung/android/sesl/visualeffect/surfaceeffects/ripple/RippleShader$FadeParams;", "SPARKLE_SIZE_SCALE_DEFAULT", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int getCOLOR_RIPPLE_CENTER() {
            return ScanningEffectView.COLOR_RIPPLE_CENTER;
        }

        public final int getCOLOR_RIPPLE_INNER() {
            return ScanningEffectView.COLOR_RIPPLE_INNER;
        }

        public final int getCOLOR_RIPPLE_OUTER() {
            return ScanningEffectView.COLOR_RIPPLE_OUTER;
        }

        public final int getCOLOR_SPARKLE() {
            return ScanningEffectView.COLOR_SPARKLE;
        }

        @NotNull
        public final RippleShader.FadeParams getSPARKLE_FADE_PARAMS_DEFAULT() {
            return ScanningEffectView.SPARKLE_FADE_PARAMS_DEFAULT;
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScanningEffectView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        float f = 0.0f;
        this.startPoint = new PointF(0.0f, 0.0f);
        this.interpolator = new PathInterpolator(0.22f, 0.5f, 0.0f, 1.0f);
        this.sparkleStrength = 0.25f;
        this.sparkleScale = 1.45f;
        this.sparkleColor = COLOR_SPARKLE;
        this.sparkleFadeParams = SPARKLE_FADE_PARAMS_DEFAULT;
        this.rippleInnerColor = COLOR_RIPPLE_INNER;
        this.rippleCenterColor = COLOR_RIPPLE_CENTER;
        this.rippleOuterColor = COLOR_RIPPLE_OUTER;
        int i = 0;
        int i2 = 2;
        DefaultConstructorMarker defaultConstructorMarker = null;
        this.rippleConfigs = CollectionsKt.arrayListOf(new RippleConfig(i, f, i2, defaultConstructorMarker), new RippleConfig(60, f, i2, defaultConstructorMarker), new RippleConfig(i, f, i2, defaultConstructorMarker), new RippleConfig(80, f, i2, defaultConstructorMarker));
        LayoutInflater.from(context).inflate(C7843R.layout.scanning_effect_view, this);
        initView();
        setDuration(2000L);
    }

    @RequiresApi(33)
    private final AnimationToken startScanningAnimation() {
        int iCoerceAtLeast = RangesKt.coerceAtLeast(getWidth(), getHeight());
        float f = getContext().getResources().getDisplayMetrics().density * 1.0f;
        final AnimationToken animationToken = new AnimationToken();
        MultiRippleController multiRippleController = this.multiRippleController;
        if (multiRippleController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("multiRippleController");
            multiRippleController = null;
        }
        Float requestedEffectFrameRate = getRequestedEffectFrameRate();
        long duration = getDuration();
        PointF pointF = this.startPoint;
        float f4 = iCoerceAtLeast;
        float f5 = 1.4284f * f4;
        RippleAnimationConfig rippleAnimationConfig = new RippleAnimationConfig(requestedEffectFrameRate, duration, pointF.x, pointF.y, 0.0f, 0.0f, this.rippleConfigs.get(1).getScale(), f5, f5, f, this.rippleOuterColor, Color.parseColor("#FFFFFF"), this.rippleConfigs.get(1).getAlpha(), 0.0f, new RippleShader.FadeParams(0.0f, 0.1f, 0.55f, 1.0f), new RippleShader.FadeParams(0.0f, 0.0f, 0.0f, 0.8f), new RippleShader.FadeParams(0.0f, 0.0f, 0.0f, 0.8f), false, false, this.interpolator, false, 1048576, null);
        animationToken.getRippleConfigs$sesl_visualeffect_INTERNAL_2_1_10_release().add(rippleAnimationConfig);
        RippleAnimation rippleAnimation = new RippleAnimation(rippleAnimationConfig);
        animationToken.getRippleAnimations$sesl_visualeffect_INTERNAL_2_1_10_release().add(rippleAnimation);
        final int i = 0;
        multiRippleController.play(rippleAnimation, new Runnable() { // from class: com.samsung.android.sesl.visualeffect.b
            @Override // java.lang.Runnable
            public final void run() {
                switch (i) {
                    case 0:
                        animationToken.countExpired$sesl_visualeffect_INTERNAL_2_1_10_release();
                        break;
                    case 1:
                        animationToken.countExpired$sesl_visualeffect_INTERNAL_2_1_10_release();
                        break;
                    default:
                        animationToken.countExpired$sesl_visualeffect_INTERNAL_2_1_10_release();
                        break;
                }
            }
        });
        MultiRippleController multiRippleController2 = this.multiRippleController;
        if (multiRippleController2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("multiRippleController");
            multiRippleController2 = null;
        }
        Float requestedEffectFrameRate2 = getRequestedEffectFrameRate();
        long duration2 = getDuration();
        PointF pointF2 = this.startPoint;
        float f6 = f4 * 1.162f;
        RippleAnimationConfig rippleAnimationConfig2 = new RippleAnimationConfig(requestedEffectFrameRate2, duration2, pointF2.x, pointF2.y, 0.0f, 0.0f, this.rippleConfigs.get(3).getScale(), f6, f6, getContext().getResources().getDisplayMetrics().density * 1.0f, this.rippleCenterColor, Color.parseColor("#FFFFFF"), this.rippleConfigs.get(3).getAlpha(), 0.0f, new RippleShader.FadeParams(0.0f, 0.1f, 0.55f, 1.0f), new RippleShader.FadeParams(0.0f, 0.0f, 0.0f, 0.8f), new RippleShader.FadeParams(0.0f, 0.0f, 0.0f, 0.8f), false, false, this.interpolator, false, 1048576, null);
        animationToken.getRippleConfigs$sesl_visualeffect_INTERNAL_2_1_10_release().add(rippleAnimationConfig2);
        RippleAnimation rippleAnimation2 = new RippleAnimation(rippleAnimationConfig2);
        animationToken.getRippleAnimations$sesl_visualeffect_INTERNAL_2_1_10_release().add(rippleAnimation2);
        final int i2 = 1;
        multiRippleController2.play(rippleAnimation2, new Runnable() { // from class: com.samsung.android.sesl.visualeffect.b
            @Override // java.lang.Runnable
            public final void run() {
                switch (i2) {
                    case 0:
                        animationToken.countExpired$sesl_visualeffect_INTERNAL_2_1_10_release();
                        break;
                    case 1:
                        animationToken.countExpired$sesl_visualeffect_INTERNAL_2_1_10_release();
                        break;
                    default:
                        animationToken.countExpired$sesl_visualeffect_INTERNAL_2_1_10_release();
                        break;
                }
            }
        });
        MultiRippleController multiRippleController3 = this.sparkleController;
        if (multiRippleController3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sparkleController");
            multiRippleController3 = null;
        }
        Float requestedEffectFrameRate3 = getRequestedEffectFrameRate();
        long duration3 = getDuration();
        PointF pointF3 = this.startPoint;
        RippleAnimationConfig rippleAnimationConfig3 = new RippleAnimationConfig(requestedEffectFrameRate3, duration3, pointF3.x, pointF3.y, 0.0f, 0.0f, this.sparkleScale, f6, f6, getContext().getResources().getDisplayMetrics().density * 1.2f, Color.parseColor("#FFFFFF"), this.sparkleColor, 0, this.sparkleStrength, null, this.sparkleFadeParams, null, false, false, this.interpolator, false, 1048576, null);
        animationToken.setSparkleConfig$sesl_visualeffect_INTERNAL_2_1_10_release(rippleAnimationConfig3);
        RippleAnimation rippleAnimation3 = new RippleAnimation(rippleAnimationConfig3);
        animationToken.setSparkleAnimation$sesl_visualeffect_INTERNAL_2_1_10_release(rippleAnimation3);
        final int i4 = 2;
        multiRippleController3.play(rippleAnimation3, new Runnable() { // from class: com.samsung.android.sesl.visualeffect.b
            @Override // java.lang.Runnable
            public final void run() {
                switch (i4) {
                    case 0:
                        animationToken.countExpired$sesl_visualeffect_INTERNAL_2_1_10_release();
                        break;
                    case 1:
                        animationToken.countExpired$sesl_visualeffect_INTERNAL_2_1_10_release();
                        break;
                    default:
                        animationToken.countExpired$sesl_visualeffect_INTERNAL_2_1_10_release();
                        break;
                }
            }
        });
        return animationToken;
    }

    @NotNull
    public final Interpolator getInterpolator() {
        return this.interpolator;
    }

    @Override // com.samsung.android.sesl.visualeffect.MaskingSupportedEffectView
    @Nullable
    public Path getMaskPath() {
        MultiRippleView multiRippleView = this.sparkleView;
        if (multiRippleView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sparkleView");
            multiRippleView = null;
        }
        return multiRippleView.getMaskPath();
    }

    public final int getRippleCenterColor() {
        return this.rippleCenterColor;
    }

    @NotNull
    public final ArrayList<RippleConfig> getRippleConfigs() {
        return this.rippleConfigs;
    }

    public final int getRippleInnerColor() {
        return this.rippleInnerColor;
    }

    public final int getRippleOuterColor() {
        return this.rippleOuterColor;
    }

    public final int getSparkleColor() {
        return this.sparkleColor;
    }

    @NotNull
    public final RippleShader.FadeParams getSparkleFadeParams() {
        return this.sparkleFadeParams;
    }

    public final float getSparkleScale() {
        return this.sparkleScale;
    }

    public final float getSparkleStrength() {
        return this.sparkleStrength;
    }

    @NotNull
    public final PointF getStartPoint() {
        return this.startPoint;
    }

    @Override // com.samsung.android.sesl.visualeffect.EffectView
    public void initView() {
        this.multiRippleView = (MultiRippleView) findViewById(C7843R.id.ripple_view);
        MultiRippleView multiRippleView = this.multiRippleView;
        MultiRippleView multiRippleView2 = null;
        if (multiRippleView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("multiRippleView");
            multiRippleView = null;
        }
        this.multiRippleController = new MultiRippleController(multiRippleView);
        this.sparkleView = (MultiRippleView) findViewById(C7843R.id.sparkle_view);
        MultiRippleView multiRippleView3 = this.sparkleView;
        if (multiRippleView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sparkleView");
        } else {
            multiRippleView2 = multiRippleView3;
        }
        this.sparkleController = new MultiRippleController(multiRippleView2);
    }

    @Override // com.samsung.android.sesl.visualeffect.EffectView
    public void reset() {
    }

    public final void setInterpolator(@NotNull Interpolator interpolator) {
        Intrinsics.checkNotNullParameter(interpolator, "<set-?>");
        this.interpolator = interpolator;
    }

    @Override // com.samsung.android.sesl.visualeffect.MaskingSupportedEffectView
    public void setMaskPath(@Nullable Path path) {
        MultiRippleView multiRippleView = this.sparkleView;
        MultiRippleView multiRippleView2 = null;
        if (multiRippleView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sparkleView");
            multiRippleView = null;
        }
        multiRippleView.setMaskPath(path);
        MultiRippleView multiRippleView3 = this.multiRippleView;
        if (multiRippleView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("multiRippleView");
        } else {
            multiRippleView2 = multiRippleView3;
        }
        multiRippleView2.setMaskPath(path);
    }

    public final void setRippleCenterColor(int i) {
        this.rippleCenterColor = i;
    }

    public final void setRippleConfigs(@NotNull ArrayList<RippleConfig> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.rippleConfigs = arrayList;
    }

    public final void setRippleInnerColor(int i) {
        this.rippleInnerColor = i;
    }

    public final void setRippleOuterColor(int i) {
        this.rippleOuterColor = i;
    }

    public final void setSparkleColor(int i) {
        this.sparkleColor = i;
    }

    public final void setSparkleFadeParams(@NotNull RippleShader.FadeParams fadeParams) {
        Intrinsics.checkNotNullParameter(fadeParams, "<set-?>");
        this.sparkleFadeParams = fadeParams;
    }

    public final void setSparkleScale(float f) {
        this.sparkleScale = f;
    }

    public final void setSparkleStrength(float f) {
        this.sparkleStrength = f;
    }

    public final void setStartPoint(@NotNull PointF pointF) {
        Intrinsics.checkNotNullParameter(pointF, "<set-?>");
        this.startPoint = pointF;
    }

    @Override // com.samsung.android.sesl.visualeffect.EffectView
    @RequiresApi(33)
    public void startAnimation() {
        super.startAnimation();
        startScanningAnimation();
    }

    @RequiresApi(33)
    @NotNull
    public final AnimationToken startAnimationTokenized() {
        super.startAnimation();
        return startScanningAnimation();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/ScanningEffectView$RippleConfig;", "", "alpha", "", WiggleAnimationConfig.KEY_SCALE, "", "<init>", "(IF)V", "getAlpha", "()I", "setAlpha", "(I)V", "getScale", "()F", "setScale", "(F)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final /* data */ class RippleConfig {
        private int alpha;
        private float scale;

        public RippleConfig(int i, float f) {
            this.alpha = i;
            this.scale = f;
        }

        public static /* synthetic */ RippleConfig copy$default(RippleConfig rippleConfig, int i, float f, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = rippleConfig.alpha;
            }
            if ((i2 & 2) != 0) {
                f = rippleConfig.scale;
            }
            return rippleConfig.copy(i, f);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getAlpha() {
            return this.alpha;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final float getScale() {
            return this.scale;
        }

        @NotNull
        public final RippleConfig copy(int alpha, float scale) {
            return new RippleConfig(alpha, scale);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RippleConfig)) {
                return false;
            }
            RippleConfig rippleConfig = (RippleConfig) other;
            return this.alpha == rippleConfig.alpha && Float.compare(this.scale, rippleConfig.scale) == 0;
        }

        public final int getAlpha() {
            return this.alpha;
        }

        public final float getScale() {
            return this.scale;
        }

        public int hashCode() {
            return Float.hashCode(this.scale) + (Integer.hashCode(this.alpha) * 31);
        }

        public final void setAlpha(int i) {
            this.alpha = i;
        }

        public final void setScale(float f) {
            this.scale = f;
        }

        @NotNull
        public String toString() {
            return "RippleConfig(alpha=" + this.alpha + ", scale=" + this.scale + ")";
        }

        public /* synthetic */ RippleConfig(int i, float f, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, (i2 & 2) != 0 ? 1.45f : f);
        }
    }
}
