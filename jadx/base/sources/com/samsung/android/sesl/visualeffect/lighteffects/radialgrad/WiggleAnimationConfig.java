package com.samsung.android.sesl.visualeffect.lighteffects.radialgrad;

import android.animation.Animator;
import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.graphics.PointF;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.RequiresApi;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAuthorizationResponse;
import com.samsung.android.sesl.visualeffect.lighteffects.common.config.AnimatableAttribute;
import com.samsung.android.sesl.visualeffect.lighteffects.common.control.VibeEffectControl;
import com.samsung.android.sesl.visualeffect.lighteffects.processinglight.C7868a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@RequiresApi(26)
@Metadata(m13885d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u0000 T2\u00020\u0001:\u0001TBI\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ4\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00072\b\b\u0002\u0010#\u001a\u00020\u00072\b\b\u0002\u0010$\u001a\u00020\u0007H\u0002J\u007f\u0010%\u001a6\u0012\u0004\u0012\u00020 \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020(0'0&j\u001a\u0012\u0004\u0012\u00020 \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020(0'`)2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020(0'2\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020(0'2\u0014\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020(\u0018\u00010'H\u0000¢\u0006\u0002\b.J¤\u0001\u0010/\u001a\b\u0012\u0004\u0012\u000201002\u0006\u00102\u001a\u00020+2\u0006\u00103\u001a\u00020\u00072\u0006\u00104\u001a\u00020\n2\u0006\u00105\u001a\u00020+2\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\n2!\u0010*\u001a\u001d\u0012\u0013\u0012\u00110+¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(:\u0012\u0004\u0012\u00020(0'2\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020(0'2\u0014\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020(\u0018\u00010'2\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020(0'H\u0000¢\u0006\u0002\b<J\u0093\u0001\u0010/\u001a\b\u0012\u0004\u0012\u000201002\u0006\u00102\u001a\u00020+2\u0006\u00103\u001a\u00020\u00072\u0006\u00104\u001a\u00020\n2\u0006\u00105\u001a\u00020+2\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\n2:\u0010=\u001a6\u0012\u0004\u0012\u00020 \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020(0'0&j\u001a\u0012\u0004\u0012\u00020 \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020(0'`)2\u0012\u0010>\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020(0'H\u0001¢\u0006\u0002\b<J3\u0010?\u001a\u00020(2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00030A2\u0006\u0010B\u001a\u00020\n2\u0006\u0010C\u001a\u00020\n2\u0006\u0010D\u001a\u00020EH\u0002¢\u0006\u0002\u0010FJ\t\u0010G\u001a\u00020\u0003HÆ\u0003J\t\u0010H\u001a\u00020\u0005HÆ\u0003J\u0010\u0010I\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010J\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010K\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0017J\t\u0010L\u001a\u00020\u0007HÆ\u0003JP\u0010M\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0007HÆ\u0001¢\u0006\u0002\u0010NJ\u0013\u0010O\u001a\u00020P2\b\u0010Q\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010R\u001a\u00020\nHÖ\u0001J\t\u0010S\u001a\u00020 HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0015\u0010\u0013R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001a¨\u0006U"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/lighteffects/radialgrad/WiggleAnimationConfig;", "", MicrosoftAuthorizationResponse.INTERVAL, "", "interpolation", "Landroid/view/animation/Interpolator;", "deltaPosition", "", "deltaScale", "changeColor", "", "fps", "<init>", "(JLandroid/view/animation/Interpolator;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Integer;F)V", "getInterval", "()J", "getInterpolation", "()Landroid/view/animation/Interpolator;", "getDeltaPosition", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getDeltaScale", "getChangeColor", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getFps", "()F", "randf", "getRandf", "makeKeyframe", "Landroid/animation/PropertyValuesHolder;", "keyString", "", "fromValue", "toValue", "fromFraction", "toFraction", "buildListener", "Ljava/util/HashMap;", "Lkotlin/Function1;", "", "Lkotlin/collections/HashMap;", "positionListener", "Landroid/graphics/PointF;", "scaleListener", "colorListener", "buildListener$sesl_visualeffect_INTERNAL_2_1_10_release", "build", "", "Landroid/animation/ValueAnimator;", "initialPosition", "initialScale", "initialColor", "currentPosition", "currentScale", "currentColor", "Lkotlin/ParameterName;", "name", "p", "onTransformAnimationFinish", "build$sesl_visualeffect_INTERNAL_2_1_10_release", "onUpdateListeners", "onAnimationFinish", "invokeBasedFps", "lastTime", "", "index", "threshold", "runnable", "Ljava/lang/Runnable;", "([Ljava/lang/Long;IILjava/lang/Runnable;)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(JLandroid/view/animation/Interpolator;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Integer;F)Lcom/samsung/android/sesl/visualeffect/lighteffects/radialgrad/WiggleAnimationConfig;", "equals", "", "other", "hashCode", "toString", "Companion", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final /* data */ class WiggleAnimationConfig {

    @NotNull
    public static final String KEY_COLORINT = "color";

    @NotNull
    public static final String KEY_POSITION = "position";

    @NotNull
    private static final String KEY_POSITION_X = "x";

    @NotNull
    private static final String KEY_POSITION_Y = "y";

    @NotNull
    public static final String KEY_SCALE = "scale";

    @Nullable
    private final Integer changeColor;

    @Nullable
    private final Float deltaPosition;

    @Nullable
    private final Float deltaScale;
    private final float fps;

    @NotNull
    private final Interpolator interpolation;
    private final long interval;

    public WiggleAnimationConfig() {
        this(0L, null, null, null, null, 0.0f, 63, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void build$lambda$13$lambda$12(WiggleAnimationConfig wiggleAnimationConfig, Long[] lArr, int i, final HashMap map, final ValueAnimator valueAnimator, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (wiggleAnimationConfig.deltaPosition != null) {
            final int i2 = 0;
            wiggleAnimationConfig.invokeBasedFps(lArr, 0, i, new Runnable() { // from class: com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.j
                @Override // java.lang.Runnable
                public final void run() {
                    switch (i2) {
                        case 0:
                            WiggleAnimationConfig.build$lambda$13$lambda$12$lambda$9$lambda$8(map, valueAnimator);
                            break;
                        default:
                            WiggleAnimationConfig.build$lambda$13$lambda$12$lambda$11$lambda$10(map, valueAnimator);
                            break;
                    }
                }
            });
        }
        if (wiggleAnimationConfig.deltaScale != null) {
            final int i4 = 1;
            wiggleAnimationConfig.invokeBasedFps(lArr, 1, i, new Runnable() { // from class: com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.j
                @Override // java.lang.Runnable
                public final void run() {
                    switch (i4) {
                        case 0:
                            WiggleAnimationConfig.build$lambda$13$lambda$12$lambda$9$lambda$8(map, valueAnimator);
                            break;
                        default:
                            WiggleAnimationConfig.build$lambda$13$lambda$12$lambda$11$lambda$10(map, valueAnimator);
                            break;
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void build$lambda$13$lambda$12$lambda$11$lambda$10(HashMap map, ValueAnimator valueAnimator) {
        Function1 function1 = (Function1) map.get(KEY_SCALE);
        if (function1 != null) {
            Object animatedValue = valueAnimator.getAnimatedValue(KEY_SCALE);
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            function1.invoke((Float) animatedValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void build$lambda$13$lambda$12$lambda$9$lambda$8(HashMap map, ValueAnimator valueAnimator) {
        Function1 function1 = (Function1) map.get("position");
        if (function1 != null) {
            Object animatedValue = valueAnimator.getAnimatedValue("x");
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            float fFloatValue = ((Float) animatedValue).floatValue();
            Object animatedValue2 = valueAnimator.getAnimatedValue("y");
            Intrinsics.checkNotNull(animatedValue2, "null cannot be cast to non-null type kotlin.Float");
            function1.invoke(new PointF(fFloatValue, ((Float) animatedValue2).floatValue()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit build$lambda$15$lambda$14(HashMap map, VibeEffectControl vibeEffectControl, float f, Color animatedValue) {
        Intrinsics.checkNotNullParameter(animatedValue, "animatedValue");
        Function1 function1 = (Function1) map.get("color");
        if (function1 != null) {
            function1.invoke(Integer.valueOf(animatedValue.toArgb()));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit buildListener$lambda$4$lambda$0(Function1 function1, Object it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke((PointF) it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit buildListener$lambda$4$lambda$1(Function1 function1, Object it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke((Float) it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit buildListener$lambda$4$lambda$3$lambda$2(Function1 function1, Object it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke((Integer) it);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ WiggleAnimationConfig copy$default(WiggleAnimationConfig wiggleAnimationConfig, long j, Interpolator interpolator, Float f, Float f4, Integer num, float f5, int i, Object obj) {
        if ((i & 1) != 0) {
            j = wiggleAnimationConfig.interval;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            interpolator = wiggleAnimationConfig.interpolation;
        }
        Interpolator interpolator2 = interpolator;
        if ((i & 4) != 0) {
            f = wiggleAnimationConfig.deltaPosition;
        }
        Float f6 = f;
        if ((i & 8) != 0) {
            f4 = wiggleAnimationConfig.deltaScale;
        }
        Float f7 = f4;
        if ((i & 16) != 0) {
            num = wiggleAnimationConfig.changeColor;
        }
        Integer num2 = num;
        if ((i & 32) != 0) {
            f5 = wiggleAnimationConfig.fps;
        }
        return wiggleAnimationConfig.copy(j2, interpolator2, f6, f7, num2, f5);
    }

    private final float getRandf() {
        return (Random.INSTANCE.nextFloat() - 0.5f) * 2.0f;
    }

    private final void invokeBasedFps(Long[] lastTime, int index, int threshold, Runnable runnable) {
        long jNanoTime = System.nanoTime();
        if (jNanoTime - lastTime[index].longValue() >= threshold) {
            runnable.run();
            lastTime[index] = Long.valueOf(jNanoTime);
        }
    }

    private final PropertyValuesHolder makeKeyframe(String keyString, float fromValue, float toValue, float fromFraction, float toFraction) {
        PropertyValuesHolder propertyValuesHolderOfKeyframe = PropertyValuesHolder.ofKeyframe(keyString, Keyframe.ofFloat(fromFraction, fromValue), Keyframe.ofFloat(toFraction, toValue));
        Intrinsics.checkNotNullExpressionValue(propertyValuesHolderOfKeyframe, "ofKeyframe(...)");
        return propertyValuesHolderOfKeyframe;
    }

    public static /* synthetic */ PropertyValuesHolder makeKeyframe$default(WiggleAnimationConfig wiggleAnimationConfig, String str, float f, float f4, float f5, float f6, int i, Object obj) {
        if ((i & 8) != 0) {
            f5 = 0.0f;
        }
        float f7 = f5;
        if ((i & 16) != 0) {
            f6 = 1.0f;
        }
        return wiggleAnimationConfig.makeKeyframe(str, f, f4, f7, f6);
    }

    @NotNull
    public final List<ValueAnimator> build$sesl_visualeffect_INTERNAL_2_1_10_release(@NotNull PointF initialPosition, float initialScale, int initialColor, @NotNull PointF currentPosition, float currentScale, int currentColor, @NotNull Function1<? super PointF, Unit> positionListener, @NotNull Function1<? super Float, Unit> scaleListener, @Nullable Function1<? super Integer, Unit> colorListener, @NotNull Function1<? super ValueAnimator, Unit> onTransformAnimationFinish) {
        Intrinsics.checkNotNullParameter(initialPosition, "initialPosition");
        Intrinsics.checkNotNullParameter(currentPosition, "currentPosition");
        Intrinsics.checkNotNullParameter(positionListener, "positionListener");
        Intrinsics.checkNotNullParameter(scaleListener, "scaleListener");
        Intrinsics.checkNotNullParameter(onTransformAnimationFinish, "onTransformAnimationFinish");
        return build$sesl_visualeffect_INTERNAL_2_1_10_release(initialPosition, initialScale, initialColor, currentPosition, currentScale, currentColor, buildListener$sesl_visualeffect_INTERNAL_2_1_10_release(positionListener, scaleListener, colorListener), onTransformAnimationFinish);
    }

    @NotNull
    public final HashMap<String, Function1<Object, Unit>> buildListener$sesl_visualeffect_INTERNAL_2_1_10_release(@NotNull Function1<? super PointF, Unit> positionListener, @NotNull Function1<? super Float, Unit> scaleListener, @Nullable Function1<? super Integer, Unit> colorListener) {
        Intrinsics.checkNotNullParameter(positionListener, "positionListener");
        Intrinsics.checkNotNullParameter(scaleListener, "scaleListener");
        HashMap<String, Function1<Object, Unit>> map = new HashMap<>();
        map.put("position", new C7881i(positionListener, 0));
        map.put(KEY_SCALE, new C7881i(scaleListener, 1));
        if (colorListener != null) {
            map.put("color", new C7881i(colorListener, 2));
        }
        return map;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getInterval() {
        return this.interval;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Interpolator getInterpolation() {
        return this.interpolation;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Float getDeltaPosition() {
        return this.deltaPosition;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Float getDeltaScale() {
        return this.deltaScale;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Integer getChangeColor() {
        return this.changeColor;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final float getFps() {
        return this.fps;
    }

    @NotNull
    public final WiggleAnimationConfig copy(long interval, @NotNull Interpolator interpolation, @Nullable Float deltaPosition, @Nullable Float deltaScale, @Nullable Integer changeColor, float fps) {
        Intrinsics.checkNotNullParameter(interpolation, "interpolation");
        return new WiggleAnimationConfig(interval, interpolation, deltaPosition, deltaScale, changeColor, fps);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WiggleAnimationConfig)) {
            return false;
        }
        WiggleAnimationConfig wiggleAnimationConfig = (WiggleAnimationConfig) other;
        return this.interval == wiggleAnimationConfig.interval && Intrinsics.areEqual(this.interpolation, wiggleAnimationConfig.interpolation) && Intrinsics.areEqual((Object) this.deltaPosition, (Object) wiggleAnimationConfig.deltaPosition) && Intrinsics.areEqual((Object) this.deltaScale, (Object) wiggleAnimationConfig.deltaScale) && Intrinsics.areEqual(this.changeColor, wiggleAnimationConfig.changeColor) && Float.compare(this.fps, wiggleAnimationConfig.fps) == 0;
    }

    @Nullable
    public final Integer getChangeColor() {
        return this.changeColor;
    }

    @Nullable
    public final Float getDeltaPosition() {
        return this.deltaPosition;
    }

    @Nullable
    public final Float getDeltaScale() {
        return this.deltaScale;
    }

    public final float getFps() {
        return this.fps;
    }

    @NotNull
    public final Interpolator getInterpolation() {
        return this.interpolation;
    }

    public final long getInterval() {
        return this.interval;
    }

    public int hashCode() {
        int iHashCode = (this.interpolation.hashCode() + (Long.hashCode(this.interval) * 31)) * 31;
        Float f = this.deltaPosition;
        int iHashCode2 = (iHashCode + (f == null ? 0 : f.hashCode())) * 31;
        Float f4 = this.deltaScale;
        int iHashCode3 = (iHashCode2 + (f4 == null ? 0 : f4.hashCode())) * 31;
        Integer num = this.changeColor;
        return Float.hashCode(this.fps) + ((iHashCode3 + (num != null ? num.hashCode() : 0)) * 31);
    }

    @NotNull
    public String toString() {
        return "WiggleAnimationConfig(interval=" + this.interval + ", interpolation=" + this.interpolation + ", deltaPosition=" + this.deltaPosition + ", deltaScale=" + this.deltaScale + ", changeColor=" + this.changeColor + ", fps=" + this.fps + ")";
    }

    public WiggleAnimationConfig(long j, @NotNull Interpolator interpolation, @Nullable Float f, @Nullable Float f4, @Nullable Integer num, float f5) {
        Intrinsics.checkNotNullParameter(interpolation, "interpolation");
        this.interval = j;
        this.interpolation = interpolation;
        this.deltaPosition = f;
        this.deltaScale = f4;
        this.changeColor = num;
        this.fps = f5;
    }

    @RequiresApi(26)
    @NotNull
    public final List<ValueAnimator> build$sesl_visualeffect_INTERNAL_2_1_10_release(@NotNull PointF initialPosition, float initialScale, int initialColor, @NotNull PointF currentPosition, float currentScale, int currentColor, @NotNull final HashMap<String, Function1<Object, Unit>> onUpdateListeners, @NotNull final Function1<? super ValueAnimator, Unit> onAnimationFinish) {
        PropertyValuesHolder propertyValuesHolderMakeKeyframe$default;
        PropertyValuesHolder propertyValuesHolderMakeKeyframe$default2;
        PropertyValuesHolder propertyValuesHolderMakeKeyframe$default3;
        Intrinsics.checkNotNullParameter(initialPosition, "initialPosition");
        Intrinsics.checkNotNullParameter(currentPosition, "currentPosition");
        Intrinsics.checkNotNullParameter(onUpdateListeners, "onUpdateListeners");
        Intrinsics.checkNotNullParameter(onAnimationFinish, "onAnimationFinish");
        ValueAnimator valueAnimatorBuild$sesl_visualeffect_INTERNAL_2_1_10_release = null;
        if (this.deltaPosition != null) {
            propertyValuesHolderMakeKeyframe$default = makeKeyframe$default(this, "x", currentPosition.x, (this.deltaPosition.floatValue() * getRandf()) + initialPosition.x, 0.0f, 0.0f, 24, null);
        } else {
            propertyValuesHolderMakeKeyframe$default = null;
        }
        if (this.deltaPosition != null) {
            propertyValuesHolderMakeKeyframe$default2 = makeKeyframe$default(this, "y", currentPosition.y, (this.deltaPosition.floatValue() * getRandf()) + initialPosition.y, 0.0f, 0.0f, 24, null);
        } else {
            propertyValuesHolderMakeKeyframe$default2 = null;
        }
        if (this.deltaScale != null) {
            propertyValuesHolderMakeKeyframe$default3 = makeKeyframe$default(this, KEY_SCALE, currentScale, (this.deltaScale.floatValue() * getRandf()) + initialScale, 0.0f, 0.0f, 24, null);
        } else {
            propertyValuesHolderMakeKeyframe$default3 = null;
        }
        final ValueAnimator valueAnimatorOfPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(propertyValuesHolderMakeKeyframe$default, propertyValuesHolderMakeKeyframe$default2, propertyValuesHolderMakeKeyframe$default3);
        valueAnimatorOfPropertyValuesHolder.setRepeatCount(0);
        valueAnimatorOfPropertyValuesHolder.setRepeatMode(1);
        valueAnimatorOfPropertyValuesHolder.setInterpolator(this.interpolation);
        valueAnimatorOfPropertyValuesHolder.setDuration(this.interval);
        final int i = (int) (1000000000 / this.fps);
        long j = i;
        final Long[] lArr = {Long.valueOf(System.nanoTime() - j), Long.valueOf(System.nanoTime() - j)};
        valueAnimatorOfPropertyValuesHolder.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.k
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                WiggleAnimationConfig.build$lambda$13$lambda$12(this.f5371a, lArr, i, onUpdateListeners, valueAnimatorOfPropertyValuesHolder, valueAnimator);
            }
        });
        valueAnimatorOfPropertyValuesHolder.addListener(new Animator.AnimatorListener() { // from class: com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.WiggleAnimationConfig$build$xFormAnim$4$2
            private boolean cancelled;

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                this.cancelled = true;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                if (this.cancelled) {
                    return;
                }
                onAnimationFinish.invoke((ValueAnimator) animation);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        });
        if (this.changeColor != null && onUpdateListeners.get("color") != null) {
            long j2 = this.interval;
            Interpolator interpolator = this.interpolation;
            Color colorValueOf = Color.valueOf(initialColor);
            Intrinsics.checkNotNullExpressionValue(colorValueOf, "valueOf(...)");
            Color colorValueOf2 = Color.valueOf(this.changeColor.intValue());
            Intrinsics.checkNotNullExpressionValue(colorValueOf2, "valueOf(...)");
            valueAnimatorBuild$sesl_visualeffect_INTERNAL_2_1_10_release = new AnimatableAttribute(j2, 0L, colorValueOf, colorValueOf2, interpolator, 2, -1, null, new C7868a(onUpdateListeners, 1), 130, null).build$sesl_visualeffect_INTERNAL_2_1_10_release(null);
        }
        ArrayList arrayListArrayListOf = CollectionsKt.arrayListOf(valueAnimatorOfPropertyValuesHolder);
        if (valueAnimatorBuild$sesl_visualeffect_INTERNAL_2_1_10_release != null) {
            arrayListArrayListOf.add(valueAnimatorBuild$sesl_visualeffect_INTERNAL_2_1_10_release);
        }
        return arrayListArrayListOf;
    }

    public /* synthetic */ WiggleAnimationConfig(long j, Interpolator interpolator, Float f, Float f4, Integer num, float f5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Constants.WGL_INTERVAL : j, (i & 2) != 0 ? new LinearInterpolator() : interpolator, (i & 4) != 0 ? null : f, (i & 8) != 0 ? null : f4, (i & 16) == 0 ? num : null, (i & 32) != 0 ? 60.0f : f5);
    }
}
