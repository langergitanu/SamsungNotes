package com.samsung.android.sesl.visualeffect.lighteffects.guidinglight;

import android.animation.ValueAnimator;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FloatValueHolder;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/AnimationFactory;", "", "<init>", "()V", "Companion", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class AnimationFactory {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0015B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007JM\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0014¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/AnimationFactory$Companion;", "", "<init>", "()V", "createSpringAnimation", "Landroidx/dynamicanimation/animation/SpringAnimation;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroidx/dynamicanimation/animation/DynamicAnimation$OnAnimationUpdateListener;", "createAnimation", "Landroid/animation/ValueAnimator;", "type", "Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/AnimationFactory$Companion$AnimationType;", "updateListener", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "onStart", "Ljava/lang/Runnable;", "onEnd", "onCancel", "customDuration", "", "(Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/AnimationFactory$Companion$AnimationType;Landroid/animation/ValueAnimator$AnimatorUpdateListener;Ljava/lang/Runnable;Ljava/lang/Runnable;Ljava/lang/Runnable;Ljava/lang/Long;)Landroid/animation/ValueAnimator;", "AnimationType", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0014\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B)\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001a¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/AnimationFactory$Companion$AnimationType;", "", XmlErrorCodes.DURATION, "", "interpolator", "Landroid/view/animation/Interpolator;", Constants.MessagePayloadKeys.FROM, "", "to", "<init>", "(Ljava/lang/String;IJLandroid/view/animation/Interpolator;FF)V", "getDuration", "()J", "getInterpolator", "()Landroid/view/animation/Interpolator;", "getFrom", "()F", "getTo", "SHOW_SIZE_PHASE_1", "SHOW_SIZE_PHASE_2", "SHOW_LUMINANCE", "SHOW_LUMINANCE_LONG", "HIDE_LUMINANCE", "HIDE_LUMINANCE_LONG", "SHOW_SIZE_NOW_BAR_PHASE_1", "SHOW_SIZE_NOW_BAR_PHASE_2", "HIDE_SIZE_NOW_BAR", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
        public static final class AnimationType {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ AnimationType[] $VALUES;
            private final long duration;
            private final float from;

            @NotNull
            private final Interpolator interpolator;
            private final float to;
            public static final AnimationType SHOW_SIZE_PHASE_1 = new AnimationType("SHOW_SIZE_PHASE_1", 0, 800, new PathInterpolator(0.22f, 0.35f, 0.35f, 1.0f), 0.0f, 1.25f);
            public static final AnimationType SHOW_SIZE_PHASE_2 = new AnimationType("SHOW_SIZE_PHASE_2", 1, 850, new PathInterpolator(0.33f, 0.0f, 0.4f, 1.0f), 1.25f, 1.0f);
            public static final AnimationType SHOW_LUMINANCE = new AnimationType("SHOW_LUMINANCE", 2, 200, new PathInterpolator(0.0f, 0.0f, 1.0f, 1.0f), 0.0f, 1.0f);
            public static final AnimationType SHOW_LUMINANCE_LONG = new AnimationType("SHOW_LUMINANCE_LONG", 3, 1000, new PathInterpolator(0.33f, 0.0f, 0.4f, 1.0f), 0.0f, 1.0f);
            public static final AnimationType HIDE_LUMINANCE = new AnimationType("HIDE_LUMINANCE", 4, 200, new PathInterpolator(0.0f, 0.0f, 1.0f, 1.0f), 1.0f, 0.0f);
            public static final AnimationType HIDE_LUMINANCE_LONG = new AnimationType("HIDE_LUMINANCE_LONG", 5, 1000, new PathInterpolator(0.33f, 0.0f, 0.4f, 1.0f), 1.0f, 0.0f);
            public static final AnimationType SHOW_SIZE_NOW_BAR_PHASE_1 = new AnimationType("SHOW_SIZE_NOW_BAR_PHASE_1", 6, 800, new PathInterpolator(0.22f, 0.35f, 0.35f, 1.0f), 0.0f, 1.25f);
            public static final AnimationType SHOW_SIZE_NOW_BAR_PHASE_2 = new AnimationType("SHOW_SIZE_NOW_BAR_PHASE_2", 7, 850, new PathInterpolator(0.33f, 0.0f, 0.4f, 1.0f), 1.25f, 1.0f);
            public static final AnimationType HIDE_SIZE_NOW_BAR = new AnimationType("HIDE_SIZE_NOW_BAR", 8, 850, new PathInterpolator(0.33f, 0.0f, 0.4f, 1.0f), 1.25f, 0.45f);

            private static final /* synthetic */ AnimationType[] $values() {
                return new AnimationType[]{SHOW_SIZE_PHASE_1, SHOW_SIZE_PHASE_2, SHOW_LUMINANCE, SHOW_LUMINANCE_LONG, HIDE_LUMINANCE, HIDE_LUMINANCE_LONG, SHOW_SIZE_NOW_BAR_PHASE_1, SHOW_SIZE_NOW_BAR_PHASE_2, HIDE_SIZE_NOW_BAR};
            }

            static {
                AnimationType[] animationTypeArr$values = $values();
                $VALUES = animationTypeArr$values;
                $ENTRIES = EnumEntriesKt.enumEntries(animationTypeArr$values);
            }

            private AnimationType(String str, int i, long j, Interpolator interpolator, float f, float f4) {
                this.duration = j;
                this.interpolator = interpolator;
                this.from = f;
                this.to = f4;
            }

            @NotNull
            public static EnumEntries<AnimationType> getEntries() {
                return $ENTRIES;
            }

            public static AnimationType valueOf(String str) {
                return (AnimationType) Enum.valueOf(AnimationType.class, str);
            }

            public static AnimationType[] values() {
                return (AnimationType[]) $VALUES.clone();
            }

            public final long getDuration() {
                return this.duration;
            }

            public final float getFrom() {
                return this.from;
            }

            @NotNull
            public final Interpolator getInterpolator() {
                return this.interpolator;
            }

            public final float getTo() {
                return this.to;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ ValueAnimator createAnimation$default(Companion companion, AnimationType animationType, ValueAnimator.AnimatorUpdateListener animatorUpdateListener, Runnable runnable, Runnable runnable2, Runnable runnable3, Long l, int i, Object obj) {
            if ((i & 4) != 0) {
                runnable = null;
            }
            if ((i & 8) != 0) {
                runnable2 = null;
            }
            if ((i & 16) != 0) {
                runnable3 = null;
            }
            if ((i & 32) != 0) {
                l = null;
            }
            return companion.createAnimation(animationType, animatorUpdateListener, runnable, runnable2, runnable3, l);
        }

        @Nullable
        public final ValueAnimator createAnimation(@NotNull AnimationType type, @NotNull ValueAnimator.AnimatorUpdateListener updateListener, @Nullable Runnable onStart, @Nullable Runnable onEnd, @Nullable Runnable onCancel, @Nullable Long customDuration) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(updateListener, "updateListener");
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(type.getFrom(), type.getTo());
            Handler handler = new Handler(Looper.getMainLooper());
            valueAnimatorOfFloat.setDuration(customDuration != null ? customDuration.longValue() : type.getDuration());
            valueAnimatorOfFloat.setInterpolator(type.getInterpolator());
            valueAnimatorOfFloat.addUpdateListener(updateListener);
            valueAnimatorOfFloat.addListener(new AnimationFactory$Companion$createAnimation$1$1(handler, onStart, onEnd, onCancel));
            return valueAnimatorOfFloat;
        }

        @NotNull
        public final SpringAnimation createSpringAnimation(@NotNull DynamicAnimation.OnAnimationUpdateListener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            SpringAnimation springAnimation = new SpringAnimation(new FloatValueHolder(1.0f));
            SpringForce springForce = new SpringForce(100.0f);
            springForce.setDampingRatio(1.0f);
            springForce.setStiffness(361.0f);
            springAnimation.addUpdateListener(listener);
            springAnimation.setSpring(springForce);
            return springAnimation;
        }

        private Companion() {
        }
    }
}
