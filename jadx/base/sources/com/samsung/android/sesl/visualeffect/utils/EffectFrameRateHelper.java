package com.samsung.android.sesl.visualeffect.utils;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.FloatRange;
import com.samsung.android.feature.SemFloatingFeature;
import com.samsung.android.sesl.visualeffect.utils.EffectFrameRateHelper;
import com.samsung.android.support.senl.p148nt.app.sync.cloudsettings.callee.NotesSyncRpcProvider;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u0000 \u00042\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/utils/EffectFrameRateHelper;", "", "<init>", "()V", "Companion", "FrameRateAnimatorUpdateListener", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class EffectFrameRateHelper {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String TAG = "EffectFrameRateHelper";

    @Nullable
    private static Boolean sHasDynamicFrameRate;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\t\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\b¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/utils/EffectFrameRateHelper$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "sHasDynamicFrameRate", "", "Ljava/lang/Boolean;", "isViewFrameRateUpdateAvailable", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean isViewFrameRateUpdateAvailable() {
            if (EffectFrameRateHelper.sHasDynamicFrameRate != null) {
                Boolean bool = EffectFrameRateHelper.sHasDynamicFrameRate;
                Intrinsics.checkNotNull(bool, "null cannot be cast to non-null type kotlin.Boolean");
                return bool.booleanValue();
            }
            EffectFrameRateHelper.sHasDynamicFrameRate = Boolean.valueOf(Intrinsics.areEqual(SemFloatingFeature.getInstance().getString("SEC_FLOATING_FEATURE_LCD_CONFIG_HFR_MODE"), "4"));
            Log.i(EffectFrameRateHelper.TAG, "hasDynamicFrameRate : " + EffectFrameRateHelper.sHasDynamicFrameRate);
            Boolean bool2 = EffectFrameRateHelper.sHasDynamicFrameRate;
            Intrinsics.checkNotNull(bool2, "null cannot be cast to non-null type kotlin.Boolean");
            return bool2.booleanValue();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B4\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0006H\u0016J\u001a\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\u001c\u001a\u00020\u001dH\u0002J\f\u0010\u001e\u001a\u00020\n*\u00020\u0006H\u0002R)\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0012R&\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00038\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001f"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/utils/EffectFrameRateHelper$FrameRateAnimatorUpdateListener;", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "frameRate", "", "updateListener", "Lkotlin/Function1;", "Landroid/animation/ValueAnimator;", "Lkotlin/ParameterName;", "name", "anim", "", "<init>", "(FLkotlin/jvm/functions/Function1;)V", "refAnimator", "Ljava/lang/ref/WeakReference;", "durationMsByFps", "", "lastUpdateTime", "Ljava/lang/Long;", "value", "requestedFrameRate", "getRequestedFrameRate", "()F", "setRequestedFrameRate", "(F)V", "onAnimationUpdate", "animation", Constants.ARG_UPDATE, NotesSyncRpcProvider.FORCE_SYNC, "", "addAnimationStateChangeListener", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nEffectFrameRateHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EffectFrameRateHelper.kt\ncom/samsung/android/sesl/visualeffect/utils/EffectFrameRateHelper$FrameRateAnimatorUpdateListener\n+ 2 Animator.kt\nandroidx/core/animation/AnimatorKt\n*L\n1#1,90:1\n91#2,14:91\n*S KotlinDebug\n*F\n+ 1 EffectFrameRateHelper.kt\ncom/samsung/android/sesl/visualeffect/utils/EffectFrameRateHelper$FrameRateAnimatorUpdateListener\n*L\n71#1:91,14\n*E\n"})
    public static class FrameRateAnimatorUpdateListener implements ValueAnimator.AnimatorUpdateListener {
        private long durationMsByFps;

        @Nullable
        private Long lastUpdateTime;

        @NotNull
        private WeakReference<ValueAnimator> refAnimator;

        @FloatRange(from = 1.0d, m705to = 120.0d)
        private float requestedFrameRate;

        @NotNull
        private final Function1<ValueAnimator, Unit> updateListener;

        /* JADX WARN: Multi-variable type inference failed */
        public FrameRateAnimatorUpdateListener(float f, @NotNull Function1<? super ValueAnimator, Unit> updateListener) {
            Intrinsics.checkNotNullParameter(updateListener, "updateListener");
            this.updateListener = updateListener;
            this.refAnimator = new WeakReference<>(null);
            this.durationMsByFps = (long) (1000 / f);
            this.requestedFrameRate = f;
        }

        private final void addAnimationStateChangeListener(final ValueAnimator valueAnimator) {
            valueAnimator.addListener(new Animator.AnimatorListener() { // from class: com.samsung.android.sesl.visualeffect.utils.EffectFrameRateHelper$FrameRateAnimatorUpdateListener$addAnimationStateChangeListener$$inlined$addListener$default$1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(@NotNull Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(@NotNull Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(@NotNull Animator animator) {
                    final EffectFrameRateHelper.FrameRateAnimatorUpdateListener frameRateAnimatorUpdateListener = this.this$0;
                    final ValueAnimator valueAnimator2 = valueAnimator;
                    new Animator.AnimatorListener() { // from class: com.samsung.android.sesl.visualeffect.utils.EffectFrameRateHelper$FrameRateAnimatorUpdateListener$addAnimationStateChangeListener$1$1
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animation) {
                            Intrinsics.checkNotNullParameter(animation, "animation");
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animation) {
                            Intrinsics.checkNotNullParameter(animation, "animation");
                            frameRateAnimatorUpdateListener.update(valueAnimator2, true);
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animation) {
                            Intrinsics.checkNotNullParameter(animation, "animation");
                            frameRateAnimatorUpdateListener.update(valueAnimator2, true);
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animation) {
                            Intrinsics.checkNotNullParameter(animation, "animation");
                            frameRateAnimatorUpdateListener.update(valueAnimator2, true);
                        }
                    };
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(@NotNull Animator animator) {
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void update(ValueAnimator animation, boolean force) {
            if (this.lastUpdateTime == null) {
                this.lastUpdateTime = Long.valueOf(SystemClock.elapsedRealtime());
            }
            Long l = this.lastUpdateTime;
            if (l != null) {
                long jLongValue = l.longValue();
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                if (force || jElapsedRealtime - jLongValue >= this.durationMsByFps) {
                    this.updateListener.invoke(animation);
                    this.lastUpdateTime = Long.valueOf(jElapsedRealtime);
                }
            }
        }

        public static /* synthetic */ void update$default(FrameRateAnimatorUpdateListener frameRateAnimatorUpdateListener, ValueAnimator valueAnimator, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: update");
            }
            if ((i & 2) != 0) {
                z = false;
            }
            frameRateAnimatorUpdateListener.update(valueAnimator, z);
        }

        public final float getRequestedFrameRate() {
            return this.requestedFrameRate;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NotNull ValueAnimator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            if (this.refAnimator.get() == null) {
                this.refAnimator = new WeakReference<>(animation);
                addAnimationStateChangeListener(animation);
            }
            update$default(this, animation, false, 2, null);
        }

        public final void setRequestedFrameRate(float f) {
            this.requestedFrameRate = f;
            this.durationMsByFps = (long) (1000 / f);
        }

        public /* synthetic */ FrameRateAnimatorUpdateListener(float f, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? 60.0f : f, function1);
        }
    }
}
