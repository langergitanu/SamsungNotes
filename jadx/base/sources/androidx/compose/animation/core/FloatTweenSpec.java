package androidx.compose.animation.core;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0002J \u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J(\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J(\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR\u000e\u0010\r\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m13886d2 = {"Landroidx/compose/animation/core/FloatTweenSpec;", "Landroidx/compose/animation/core/FloatAnimationSpec;", XmlErrorCodes.DURATION, "", "delay", "easing", "Landroidx/compose/animation/core/Easing;", "(IILandroidx/compose/animation/core/Easing;)V", "getDelay", "()I", "delayNanos", "", "getDuration", "durationNanos", "clampPlayTimeNanos", "playTimeNanos", "getDurationNanos", "initialValue", "", "targetValue", "initialVelocity", "getValueFromNanos", "getVelocityFromNanos", "animation-core_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nFloatAnimationSpec.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FloatAnimationSpec.kt\nandroidx/compose/animation/core/FloatTweenSpec\n+ 2 MathHelpers.kt\nandroidx/compose/ui/util/MathHelpersKt\n*L\n1#1,265:1\n71#2,16:266\n*S KotlinDebug\n*F\n+ 1 FloatAnimationSpec.kt\nandroidx/compose/animation/core/FloatTweenSpec\n*L\n218#1:266,16\n*E\n"})
public final class FloatTweenSpec implements FloatAnimationSpec {
    public static final int $stable = 0;
    private final int delay;
    private final long delayNanos;
    private final int duration;
    private final long durationNanos;

    @NotNull
    private final Easing easing;

    public FloatTweenSpec() {
        this(0, 0, null, 7, null);
    }

    private final long clampPlayTimeNanos(long playTimeNanos) {
        return RangesKt.coerceIn(playTimeNanos - this.delayNanos, 0L, this.durationNanos);
    }

    public final int getDelay() {
        return this.delay;
    }

    public final int getDuration() {
        return this.duration;
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public long getDurationNanos(float initialValue, float targetValue, float initialVelocity) {
        return ((long) (this.delay + this.duration)) * AnimationKt.MillisToNanos;
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public float getValueFromNanos(long playTimeNanos, float initialValue, float targetValue, float initialVelocity) {
        float fClampPlayTimeNanos = this.duration == 0 ? 1.0f : clampPlayTimeNanos(playTimeNanos) / this.durationNanos;
        Easing easing = this.easing;
        if (fClampPlayTimeNanos < 0.0f) {
            fClampPlayTimeNanos = 0.0f;
        }
        return VectorConvertersKt.lerp(initialValue, targetValue, easing.transform(fClampPlayTimeNanos <= 1.0f ? fClampPlayTimeNanos : 1.0f));
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public float getVelocityFromNanos(long playTimeNanos, float initialValue, float targetValue, float initialVelocity) {
        long jClampPlayTimeNanos = clampPlayTimeNanos(playTimeNanos);
        if (jClampPlayTimeNanos < 0) {
            return 0.0f;
        }
        if (jClampPlayTimeNanos == 0) {
            return initialVelocity;
        }
        return (getValueFromNanos(jClampPlayTimeNanos, initialValue, targetValue, initialVelocity) - getValueFromNanos(jClampPlayTimeNanos - AnimationKt.MillisToNanos, initialValue, targetValue, initialVelocity)) * 1000.0f;
    }

    public FloatTweenSpec(int i, int i2, @NotNull Easing easing) {
        this.duration = i;
        this.delay = i2;
        this.easing = easing;
        this.durationNanos = ((long) i) * AnimationKt.MillisToNanos;
        this.delayNanos = ((long) i2) * AnimationKt.MillisToNanos;
    }

    public /* synthetic */ FloatTweenSpec(int i, int i2, Easing easing, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 300 : i, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) != 0 ? EasingKt.getFastOutSlowInEasing() : easing);
    }
}
