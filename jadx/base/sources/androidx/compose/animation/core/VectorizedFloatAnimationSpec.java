package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000b\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0000\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ%\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0013J%\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0015J-\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0018J-\u0010\u0019\u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0018R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00028\u0000X\u0082.¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\f\u001a\u00028\u0000X\u0082.¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\r\u001a\u00028\u0000X\u0082.¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006\u001a"}, m13886d2 = {"Landroidx/compose/animation/core/VectorizedFloatAnimationSpec;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/VectorizedFiniteAnimationSpec;", "anim", "Landroidx/compose/animation/core/FloatAnimationSpec;", "(Landroidx/compose/animation/core/FloatAnimationSpec;)V", "anims", "Landroidx/compose/animation/core/Animations;", "(Landroidx/compose/animation/core/Animations;)V", "endVelocityVector", "Landroidx/compose/animation/core/AnimationVector;", "valueVector", "velocityVector", "getDurationNanos", "", "initialValue", "targetValue", "initialVelocity", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)J", "getEndVelocity", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getValueFromNanos", "playTimeNanos", "(JLandroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getVelocityFromNanos", "animation-core_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nVectorizedAnimationSpec.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VectorizedAnimationSpec.kt\nandroidx/compose/animation/core/VectorizedFloatAnimationSpec\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1078:1\n1855#2,2:1079\n*S KotlinDebug\n*F\n+ 1 VectorizedAnimationSpec.kt\nandroidx/compose/animation/core/VectorizedFloatAnimationSpec\n*L\n1069#1:1079,2\n*E\n"})
public final class VectorizedFloatAnimationSpec<V extends AnimationVector> implements VectorizedFiniteAnimationSpec<V> {
    public static final int $stable = 8;

    @NotNull
    private final Animations anims;
    private V endVelocityVector;
    private V valueVector;
    private V velocityVector;

    public VectorizedFloatAnimationSpec(@NotNull Animations animations) {
        this.anims = animations;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public long getDurationNanos(@NotNull V initialValue, @NotNull V targetValue, @NotNull V initialVelocity) {
        Iterator<Integer> it = RangesKt.until(0, initialValue.getSize()).iterator();
        long jMax = 0;
        while (it.hasNext()) {
            int iNextInt = ((IntIterator) it).nextInt();
            jMax = Math.max(jMax, this.anims.get(iNextInt).getDurationNanos(initialValue.get$animation_core_release(iNextInt), targetValue.get$animation_core_release(iNextInt), initialVelocity.get$animation_core_release(iNextInt)));
        }
        return jMax;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    @NotNull
    public V getEndVelocity(@NotNull V initialValue, @NotNull V targetValue, @NotNull V initialVelocity) {
        if (this.endVelocityVector == null) {
            this.endVelocityVector = (V) AnimationVectorsKt.newInstance(initialVelocity);
        }
        V v = this.endVelocityVector;
        if (v == null) {
            Intrinsics.throwUninitializedPropertyAccessException("endVelocityVector");
            v = null;
        }
        int size$animation_core_release = v.getSize();
        for (int i = 0; i < size$animation_core_release; i++) {
            V v4 = this.endVelocityVector;
            if (v4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("endVelocityVector");
                v4 = null;
            }
            v4.set$animation_core_release(i, this.anims.get(i).getEndVelocity(initialValue.get$animation_core_release(i), targetValue.get$animation_core_release(i), initialVelocity.get$animation_core_release(i)));
        }
        V v5 = this.endVelocityVector;
        if (v5 != null) {
            return v5;
        }
        Intrinsics.throwUninitializedPropertyAccessException("endVelocityVector");
        return null;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    @NotNull
    public V getValueFromNanos(long playTimeNanos, @NotNull V initialValue, @NotNull V targetValue, @NotNull V initialVelocity) {
        if (this.valueVector == null) {
            this.valueVector = (V) AnimationVectorsKt.newInstance(initialValue);
        }
        V v = this.valueVector;
        if (v == null) {
            Intrinsics.throwUninitializedPropertyAccessException("valueVector");
            v = null;
        }
        int size$animation_core_release = v.getSize();
        for (int i = 0; i < size$animation_core_release; i++) {
            V v4 = this.valueVector;
            if (v4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("valueVector");
                v4 = null;
            }
            v4.set$animation_core_release(i, this.anims.get(i).getValueFromNanos(playTimeNanos, initialValue.get$animation_core_release(i), targetValue.get$animation_core_release(i), initialVelocity.get$animation_core_release(i)));
        }
        V v5 = this.valueVector;
        if (v5 != null) {
            return v5;
        }
        Intrinsics.throwUninitializedPropertyAccessException("valueVector");
        return null;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    @NotNull
    public V getVelocityFromNanos(long playTimeNanos, @NotNull V initialValue, @NotNull V targetValue, @NotNull V initialVelocity) {
        if (this.velocityVector == null) {
            this.velocityVector = (V) AnimationVectorsKt.newInstance(initialVelocity);
        }
        V v = this.velocityVector;
        if (v == null) {
            Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
            v = null;
        }
        int size$animation_core_release = v.getSize();
        for (int i = 0; i < size$animation_core_release; i++) {
            V v4 = this.velocityVector;
            if (v4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
                v4 = null;
            }
            v4.set$animation_core_release(i, this.anims.get(i).getVelocityFromNanos(playTimeNanos, initialValue.get$animation_core_release(i), targetValue.get$animation_core_release(i), initialVelocity.get$animation_core_release(i)));
        }
        V v5 = this.velocityVector;
        if (v5 != null) {
            return v5;
        }
        Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
        return null;
    }

    public VectorizedFloatAnimationSpec(@NotNull final FloatAnimationSpec floatAnimationSpec) {
        this(new Animations() { // from class: androidx.compose.animation.core.VectorizedFloatAnimationSpec.1
            @Override // androidx.compose.animation.core.Animations
            @NotNull
            public FloatAnimationSpec get(int index) {
                return floatAnimationSpec;
            }
        });
    }
}
