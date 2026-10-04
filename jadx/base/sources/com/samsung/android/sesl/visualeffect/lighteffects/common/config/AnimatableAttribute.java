package com.samsung.android.sesl.visualeffect.lighteffects.common.config;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.RequiresApi;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.sesl.visualeffect.lighteffects.common.control.VibeEffectControl;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice.C10889o;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@RequiresApi(26)
@Metadata(m13885d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002Bª\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00028\u0000\u0012\b\b\u0002\u0010\u0007\u001a\u00028\u0000\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012Q\b\u0002\u0010\u000f\u001aK\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0010¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010,\u001a\u00020-\"\n\b\u0001\u0010.\u0018\u0001*\u00020\u0002H\u0082\bJ\u0016\u0010/\u001a\u000200*\u0002002\b\u0010\u0014\u001a\u0004\u0018\u00010\u0011H\u0002J\u0017\u00101\u001a\u0002002\b\u0010\u0014\u001a\u0004\u0018\u00010\u0011H\u0000¢\u0006\u0002\b2J\t\u00103\u001a\u00020\u0004HÆ\u0003J\t\u00104\u001a\u00020\u0004HÆ\u0003J\u000e\u00105\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u000e\u00106\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u001fJ\t\u00107\u001a\u00020\tHÆ\u0003J\t\u00108\u001a\u00020\u000bHÆ\u0003J\t\u00109\u001a\u00020\u000bHÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u000eHÆ\u0003JR\u0010;\u001aK\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0010HÆ\u0003J¹\u0001\u0010<\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00028\u00002\b\b\u0002\u0010\u0007\u001a\u00028\u00002\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2Q\b\u0002\u0010\u000f\u001aK\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0010HÆ\u0001¢\u0006\u0002\u0010=J\u0013\u0010>\u001a\u00020-2\b\u0010?\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010@\u001a\u00020\u000bHÖ\u0001J\t\u0010A\u001a\u00020BHÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0013\u0010\u0006\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u0007\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010 \u001a\u0004\b!\u0010\u001fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b&\u0010%R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(RZ\u0010\u000f\u001aK\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0010\u0010+\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006C"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/lighteffects/common/config/AnimatableAttribute;", "T", "", XmlErrorCodes.DURATION, "", "delay", "fromValue", "toValue", "interpolation", "Landroid/view/animation/Interpolator;", "repeatMode", "", "repeatCount", "animationListener", "Landroid/animation/Animator$AnimatorListener;", "onValueUpdated", "Lkotlin/Function3;", "Lcom/samsung/android/sesl/visualeffect/lighteffects/common/control/VibeEffectControl;", "Lkotlin/ParameterName;", "name", "effect", "", "fraction", "animatedValue", "", "<init>", "(JJLjava/lang/Object;Ljava/lang/Object;Landroid/view/animation/Interpolator;IILandroid/animation/Animator$AnimatorListener;Lkotlin/jvm/functions/Function3;)V", "getDuration", "()J", "getDelay", "getFromValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getToValue", "getInterpolation", "()Landroid/view/animation/Interpolator;", "getRepeatMode", "()I", "getRepeatCount", "getAnimationListener", "()Landroid/animation/Animator$AnimatorListener;", "getOnValueUpdated", "()Lkotlin/jvm/functions/Function3;", "animationListenerInternal", "isTypeOf", "", "R", "applyAttrs", "Landroid/animation/ValueAnimator;", "build", "build$sesl_visualeffect_INTERNAL_2_1_10_release", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(JJLjava/lang/Object;Ljava/lang/Object;Landroid/view/animation/Interpolator;IILandroid/animation/Animator$AnimatorListener;Lkotlin/jvm/functions/Function3;)Lcom/samsung/android/sesl/visualeffect/lighteffects/common/config/AnimatableAttribute;", "equals", "other", "hashCode", "toString", "", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nAnimatableAttribute.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnimatableAttribute.kt\ncom/samsung/android/sesl/visualeffect/lighteffects/common/config/AnimatableAttribute\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,60:1\n25#1:62\n25#1:63\n25#1:64\n1#2:61\n*S KotlinDebug\n*F\n+ 1 AnimatableAttribute.kt\ncom/samsung/android/sesl/visualeffect/lighteffects/common/config/AnimatableAttribute\n*L\n48#1:62\n50#1:63\n36#1:64\n*E\n"})
public final /* data */ class AnimatableAttribute<T> {

    @Nullable
    private final Animator.AnimatorListener animationListener;

    @Nullable
    private Animator.AnimatorListener animationListenerInternal;
    private final long delay;
    private final long duration;

    @NotNull
    private final T fromValue;

    @NotNull
    private final Interpolator interpolation;

    @Nullable
    private final Function3<VibeEffectControl, Float, T, Unit> onValueUpdated;
    private final int repeatCount;
    private final int repeatMode;

    @NotNull
    private final T toValue;

    /* JADX WARN: Multi-variable type inference failed */
    public AnimatableAttribute(long j, long j2, @NotNull T fromValue, @NotNull T toValue, @NotNull Interpolator interpolation, int i, int i2, @Nullable Animator.AnimatorListener animatorListener, @Nullable Function3<? super VibeEffectControl, ? super Float, ? super T, Unit> function3) {
        Intrinsics.checkNotNullParameter(fromValue, "fromValue");
        Intrinsics.checkNotNullParameter(toValue, "toValue");
        Intrinsics.checkNotNullParameter(interpolation, "interpolation");
        this.duration = j;
        this.delay = j2;
        this.fromValue = fromValue;
        this.toValue = toValue;
        this.interpolation = interpolation;
        this.repeatMode = i;
        this.repeatCount = i2;
        this.animationListener = animatorListener;
        this.onValueUpdated = function3;
    }

    private final ValueAnimator applyAttrs(ValueAnimator valueAnimator, VibeEffectControl vibeEffectControl) {
        valueAnimator.setDuration(this.duration);
        valueAnimator.setStartDelay(this.delay);
        valueAnimator.setRepeatMode(this.repeatMode);
        valueAnimator.setRepeatCount(this.repeatCount);
        valueAnimator.setInterpolator(this.interpolation);
        valueAnimator.addUpdateListener(new C10889o(valueAnimator, 1, this, vibeEffectControl));
        Animator.AnimatorListener animatorListener = this.animationListener;
        if (animatorListener != null) {
            valueAnimator.addListener(animatorListener);
        }
        Animator.AnimatorListener animatorListener2 = this.animationListenerInternal;
        if (animatorListener2 != null) {
            valueAnimator.addListener(animatorListener2);
        }
        return valueAnimator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void applyAttrs$lambda$3$lambda$0(ValueAnimator valueAnimator, AnimatableAttribute animatableAttribute, VibeEffectControl vibeEffectControl, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if ((animatedValue instanceof Integer ? (Integer) animatedValue : null) != null) {
            T t = animatableAttribute.fromValue;
            if (((Color) (t instanceof Color ? t : null)) != null) {
                Function3<VibeEffectControl, Float, T, Unit> function3 = animatableAttribute.onValueUpdated;
                if (function3 != null) {
                    Float fValueOf = Float.valueOf(valueAnimator.getAnimatedFraction());
                    Object objValueOf = Color.valueOf(((Number) animatedValue).intValue());
                    Intrinsics.checkNotNull(objValueOf, "null cannot be cast to non-null type T of com.samsung.android.sesl.visualeffect.lighteffects.common.config.AnimatableAttribute");
                    function3.invoke(vibeEffectControl, fValueOf, (T) objValueOf);
                    return;
                }
                return;
            }
        }
        Function3<VibeEffectControl, Float, T, Unit> function32 = animatableAttribute.onValueUpdated;
        if (function32 != null) {
            Float fValueOf2 = Float.valueOf(valueAnimator.getAnimatedFraction());
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type T of com.samsung.android.sesl.visualeffect.lighteffects.common.config.AnimatableAttribute");
            function32.invoke(vibeEffectControl, fValueOf2, (T) animatedValue);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AnimatableAttribute copy$default(AnimatableAttribute animatableAttribute, long j, long j2, Object obj, Object obj2, Interpolator interpolator, int i, int i2, Animator.AnimatorListener animatorListener, Function3 function3, int i4, Object obj3) {
        if ((i4 & 1) != 0) {
            j = animatableAttribute.duration;
        }
        return animatableAttribute.copy(j, (i4 & 2) != 0 ? animatableAttribute.delay : j2, (i4 & 4) != 0 ? animatableAttribute.fromValue : obj, (i4 & 8) != 0 ? animatableAttribute.toValue : obj2, (i4 & 16) != 0 ? animatableAttribute.interpolation : interpolator, (i4 & 32) != 0 ? animatableAttribute.repeatMode : i, (i4 & 64) != 0 ? animatableAttribute.repeatCount : i2, (i4 & 128) != 0 ? animatableAttribute.animationListener : animatorListener, (i4 & 256) != 0 ? animatableAttribute.onValueUpdated : function3);
    }

    private final /* synthetic */ <R> boolean isTypeOf() {
        T t = this.fromValue;
        Intrinsics.reifiedOperationMarker(2, "R");
        return t != null;
    }

    @NotNull
    public final ValueAnimator build$sesl_visualeffect_INTERNAL_2_1_10_release(@Nullable VibeEffectControl effect) {
        ValueAnimator valueAnimatorOfArgb;
        T t = this.fromValue;
        if (((Float) (!(t instanceof Float) ? null : t)) != null) {
            Intrinsics.checkNotNull(t, "null cannot be cast to non-null type kotlin.Float");
            float fFloatValue = ((Float) t).floatValue();
            T t2 = this.toValue;
            Intrinsics.checkNotNull(t2, "null cannot be cast to non-null type kotlin.Float");
            valueAnimatorOfArgb = ValueAnimator.ofFloat(fFloatValue, ((Float) t2).floatValue());
        } else {
            if (((Color) (t instanceof Color ? t : null)) == null) {
                throw new RuntimeException("RTTI Failed. Unsupported animation type used. Implement for this type on " + Reflection.getOrCreateKotlinClass(AnimatableAttribute.class));
            }
            Intrinsics.checkNotNull(t, "null cannot be cast to non-null type android.graphics.Color");
            int argb = ((Color) t).toArgb();
            T t5 = this.toValue;
            Intrinsics.checkNotNull(t5, "null cannot be cast to non-null type android.graphics.Color");
            valueAnimatorOfArgb = ValueAnimator.ofArgb(argb, ((Color) t5).toArgb());
        }
        Intrinsics.checkNotNull(valueAnimatorOfArgb);
        return applyAttrs(valueAnimatorOfArgb, effect);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getDuration() {
        return this.duration;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getDelay() {
        return this.delay;
    }

    @NotNull
    public final T component3() {
        return this.fromValue;
    }

    @NotNull
    public final T component4() {
        return this.toValue;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Interpolator getInterpolation() {
        return this.interpolation;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getRepeatMode() {
        return this.repeatMode;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getRepeatCount() {
        return this.repeatCount;
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Animator.AnimatorListener getAnimationListener() {
        return this.animationListener;
    }

    @Nullable
    public final Function3<VibeEffectControl, Float, T, Unit> component9() {
        return this.onValueUpdated;
    }

    @NotNull
    public final AnimatableAttribute<T> copy(long duration, long delay, @NotNull T fromValue, @NotNull T toValue, @NotNull Interpolator interpolation, int repeatMode, int repeatCount, @Nullable Animator.AnimatorListener animationListener, @Nullable Function3<? super VibeEffectControl, ? super Float, ? super T, Unit> onValueUpdated) {
        Intrinsics.checkNotNullParameter(fromValue, "fromValue");
        Intrinsics.checkNotNullParameter(toValue, "toValue");
        Intrinsics.checkNotNullParameter(interpolation, "interpolation");
        return new AnimatableAttribute<>(duration, delay, fromValue, toValue, interpolation, repeatMode, repeatCount, animationListener, onValueUpdated);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnimatableAttribute)) {
            return false;
        }
        AnimatableAttribute animatableAttribute = (AnimatableAttribute) other;
        return this.duration == animatableAttribute.duration && this.delay == animatableAttribute.delay && Intrinsics.areEqual(this.fromValue, animatableAttribute.fromValue) && Intrinsics.areEqual(this.toValue, animatableAttribute.toValue) && Intrinsics.areEqual(this.interpolation, animatableAttribute.interpolation) && this.repeatMode == animatableAttribute.repeatMode && this.repeatCount == animatableAttribute.repeatCount && Intrinsics.areEqual(this.animationListener, animatableAttribute.animationListener) && Intrinsics.areEqual(this.onValueUpdated, animatableAttribute.onValueUpdated);
    }

    @Nullable
    public final Animator.AnimatorListener getAnimationListener() {
        return this.animationListener;
    }

    public final long getDelay() {
        return this.delay;
    }

    public final long getDuration() {
        return this.duration;
    }

    @NotNull
    public final T getFromValue() {
        return this.fromValue;
    }

    @NotNull
    public final Interpolator getInterpolation() {
        return this.interpolation;
    }

    @Nullable
    public final Function3<VibeEffectControl, Float, T, Unit> getOnValueUpdated() {
        return this.onValueUpdated;
    }

    public final int getRepeatCount() {
        return this.repeatCount;
    }

    public final int getRepeatMode() {
        return this.repeatMode;
    }

    @NotNull
    public final T getToValue() {
        return this.toValue;
    }

    public int hashCode() {
        int iM1157c = AbstractC0622a.m1157c(this.repeatCount, AbstractC0622a.m1157c(this.repeatMode, (this.interpolation.hashCode() + ((this.toValue.hashCode() + ((this.fromValue.hashCode() + AbstractC1974b.m1311d(this.delay, Long.hashCode(this.duration) * 31, 31)) * 31)) * 31)) * 31, 31), 31);
        Animator.AnimatorListener animatorListener = this.animationListener;
        int iHashCode = (iM1157c + (animatorListener == null ? 0 : animatorListener.hashCode())) * 31;
        Function3<VibeEffectControl, Float, T, Unit> function3 = this.onValueUpdated;
        return iHashCode + (function3 != null ? function3.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        long j = this.duration;
        long j2 = this.delay;
        T t = this.fromValue;
        T t2 = this.toValue;
        Interpolator interpolator = this.interpolation;
        int i = this.repeatMode;
        int i2 = this.repeatCount;
        Animator.AnimatorListener animatorListener = this.animationListener;
        Function3<VibeEffectControl, Float, T, Unit> function3 = this.onValueUpdated;
        StringBuilder sbM1323p = AbstractC1974b.m1323p(j, "AnimatableAttribute(duration=", ", delay=");
        sbM1323p.append(j2);
        sbM1323p.append(", fromValue=");
        sbM1323p.append(t);
        sbM1323p.append(", toValue=");
        sbM1323p.append(t2);
        sbM1323p.append(", interpolation=");
        sbM1323p.append(interpolator);
        AbstractC0622a.m1180z(sbM1323p, i, i2, ", repeatMode=", ", repeatCount=");
        sbM1323p.append(", animationListener=");
        sbM1323p.append(animatorListener);
        sbM1323p.append(", onValueUpdated=");
        sbM1323p.append(function3);
        sbM1323p.append(")");
        return sbM1323p.toString();
    }

    public /* synthetic */ AnimatableAttribute(long j, long j2, Object obj, Object obj2, Interpolator interpolator, int i, int i2, Animator.AnimatorListener animatorListener, Function3 function3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0L : j, (i4 & 2) != 0 ? 0L : j2, obj, (i4 & 8) != 0 ? obj : obj2, (i4 & 16) != 0 ? new LinearInterpolator() : interpolator, (i4 & 32) != 0 ? 1 : i, (i4 & 64) != 0 ? -1 : i2, (i4 & 128) != 0 ? null : animatorListener, (i4 & 256) != 0 ? null : function3);
    }
}
