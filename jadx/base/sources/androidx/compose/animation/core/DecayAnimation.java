package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 3)
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004B9\b\u0016\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\u0006\u0010\t\u001a\u00028\u0000\u0012\u0006\u0010\n\u001a\u00028\u0001¢\u0006\u0002\u0010\u000bB9\b\u0016\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\u0006\u0010\t\u001a\u00028\u0000\u0012\u0006\u0010\f\u001a\u00028\u0000¢\u0006\u0002\u0010\rB7\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u000e\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\u0006\u0010\t\u001a\u00028\u0000\u0012\u0006\u0010\n\u001a\u00028\u0001¢\u0006\u0002\u0010\u000fJ\u0015\u0010#\u001a\u00028\u00002\u0006\u0010$\u001a\u00020\u0011H\u0016¢\u0006\u0002\u0010%J\u0015\u0010&\u001a\u00028\u00012\u0006\u0010$\u001a\u00020\u0011H\u0016¢\u0006\u0002\u0010'R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\u00020\u00118VX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u00028\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u0013\u0010\t\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0019\u001a\u00028\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u0013\u0010\n\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u001dX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001eR\u0016\u0010\u001f\u001a\u00028\u0000X\u0096\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b \u0010\u0017R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u0006("}, m13886d2 = {"Landroidx/compose/animation/core/DecayAnimation;", "T", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/Animation;", "animationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "initialValue", "initialVelocityVector", "(Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationVector;)V", "initialVelocity", "(Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Ljava/lang/Object;)V", "Landroidx/compose/animation/core/VectorizedDecayAnimationSpec;", "(Landroidx/compose/animation/core/VectorizedDecayAnimationSpec;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationVector;)V", "durationNanos", "", "getDurationNanos", "()J", "endVelocity", "Landroidx/compose/animation/core/AnimationVector;", "getInitialValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "initialValueVector", "getInitialVelocityVector", "()Landroidx/compose/animation/core/AnimationVector;", "isInfinite", "", "()Z", "targetValue", "getTargetValue", "getTypeConverter", "()Landroidx/compose/animation/core/TwoWayConverter;", "getValueFromNanos", "playTimeNanos", "(J)Ljava/lang/Object;", "getVelocityVectorFromNanos", "(J)Landroidx/compose/animation/core/AnimationVector;", "animation-core_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class DecayAnimation<T, V extends AnimationVector> implements Animation<T, V> {
    public static final int $stable = 0;

    @NotNull
    private final VectorizedDecayAnimationSpec<V> animationSpec;
    private final long durationNanos;

    @NotNull
    private final V endVelocity;
    private final T initialValue;

    @NotNull
    private final V initialValueVector;

    @NotNull
    private final V initialVelocityVector;
    private final boolean isInfinite;
    private final T targetValue;

    @NotNull
    private final TwoWayConverter<T, V> typeConverter;

    public DecayAnimation(@NotNull VectorizedDecayAnimationSpec<V> vectorizedDecayAnimationSpec, @NotNull TwoWayConverter<T, V> twoWayConverter, T t, @NotNull V v) {
        this.animationSpec = vectorizedDecayAnimationSpec;
        this.typeConverter = twoWayConverter;
        this.initialValue = t;
        V vInvoke = getTypeConverter().getConvertToVector().invoke(t);
        this.initialValueVector = vInvoke;
        this.initialVelocityVector = (V) AnimationVectorsKt.copy(v);
        this.targetValue = (T) getTypeConverter().getConvertFromVector().invoke(vectorizedDecayAnimationSpec.getTargetValue(vInvoke, v));
        this.durationNanos = vectorizedDecayAnimationSpec.getDurationNanos(vInvoke, v);
        V v4 = (V) AnimationVectorsKt.copy(vectorizedDecayAnimationSpec.getVelocityFromNanos(getDurationNanos(), vInvoke, v));
        this.endVelocity = v4;
        int size = v4.getSize();
        for (int i = 0; i < size; i++) {
            V v5 = this.endVelocity;
            v5.set$animation_core_release(i, RangesKt.coerceIn(v5.get$animation_core_release(i), -this.animationSpec.getAbsVelocityThreshold(), this.animationSpec.getAbsVelocityThreshold()));
        }
    }

    @Override // androidx.compose.animation.core.Animation
    public long getDurationNanos() {
        return this.durationNanos;
    }

    public final T getInitialValue() {
        return this.initialValue;
    }

    @NotNull
    public final V getInitialVelocityVector() {
        return this.initialVelocityVector;
    }

    @Override // androidx.compose.animation.core.Animation
    public T getTargetValue() {
        return this.targetValue;
    }

    @Override // androidx.compose.animation.core.Animation
    @NotNull
    public TwoWayConverter<T, V> getTypeConverter() {
        return this.typeConverter;
    }

    @Override // androidx.compose.animation.core.Animation
    public T getValueFromNanos(long playTimeNanos) {
        return !isFinishedFromNanos(playTimeNanos) ? (T) getTypeConverter().getConvertFromVector().invoke(this.animationSpec.getValueFromNanos(playTimeNanos, this.initialValueVector, this.initialVelocityVector)) : getTargetValue();
    }

    @Override // androidx.compose.animation.core.Animation
    @NotNull
    public V getVelocityVectorFromNanos(long playTimeNanos) {
        return !isFinishedFromNanos(playTimeNanos) ? (V) this.animationSpec.getVelocityFromNanos(playTimeNanos, this.initialValueVector, this.initialVelocityVector) : this.endVelocity;
    }

    @Override // androidx.compose.animation.core.Animation
    /* JADX INFO: renamed from: isInfinite, reason: from getter */
    public boolean getIsInfinite() {
        return this.isInfinite;
    }

    public DecayAnimation(@NotNull DecayAnimationSpec<T> decayAnimationSpec, @NotNull TwoWayConverter<T, V> twoWayConverter, T t, @NotNull V v) {
        this(decayAnimationSpec.vectorize(twoWayConverter), twoWayConverter, t, v);
    }

    public DecayAnimation(@NotNull DecayAnimationSpec<T> decayAnimationSpec, @NotNull TwoWayConverter<T, V> twoWayConverter, T t, T t2) {
        this(decayAnimationSpec.vectorize(twoWayConverter), twoWayConverter, t, twoWayConverter.getConvertToVector().invoke(t2));
    }
}
