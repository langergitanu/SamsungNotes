package androidx.compose.animation.core;

import androidx.exifinterface.media.ExifInterface;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u00002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a1\u0010\u0002\u001a\u00020\u0003\"\b\b\u0000\u0010\u0004*\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u0001H\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0002\u0010\n\u001a\u0018\u0010\u000b\u001a\u00020\f*\u0006\u0012\u0002\b\u00030\r2\u0006\u0010\u000e\u001a\u00020\fH\u0000\u001a9\u0010\u000f\u001a\u00020\f\"\b\b\u0000\u0010\u0004*\u00020\u0005*\b\u0012\u0004\u0012\u0002H\u00040\u00102\u0006\u0010\u0011\u001a\u0002H\u00042\u0006\u0010\u0012\u001a\u0002H\u00042\u0006\u0010\u0013\u001a\u0002H\u0004H\u0000¢\u0006\u0002\u0010\u0014\u001aA\u0010\u0015\u001a\u0002H\u0004\"\b\b\u0000\u0010\u0004*\u00020\u0005*\b\u0012\u0004\u0012\u0002H\u00040\u00102\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u0002H\u00042\u0006\u0010\u0018\u001a\u0002H\u00042\u0006\u0010\u0019\u001a\u0002H\u0004H\u0000¢\u0006\u0002\u0010\u001a\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m13886d2 = {"InfiniteIterations", "", "createSpringAnimations", "Landroidx/compose/animation/core/Animations;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroidx/compose/animation/core/AnimationVector;", "visibilityThreshold", "dampingRatio", "", "stiffness", "(Landroidx/compose/animation/core/AnimationVector;FF)Landroidx/compose/animation/core/Animations;", "clampPlayTime", "", "Landroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;", DBSchema.DocumentThumbnail.PLAY_TIME, "getDurationMillis", "Landroidx/compose/animation/core/VectorizedAnimationSpec;", "initialValue", "targetValue", "initialVelocity", "(Landroidx/compose/animation/core/VectorizedAnimationSpec;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)J", "getValueFromMillis", "playTimeMillis", "start", "end", "startVelocity", "(Landroidx/compose/animation/core/VectorizedAnimationSpec;JLandroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "animation-core_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class VectorizedAnimationSpecKt {
    private static final int InfiniteIterations = Integer.MAX_VALUE;

    public static final long clampPlayTime(@NotNull VectorizedDurationBasedAnimationSpec<?> vectorizedDurationBasedAnimationSpec, long j) {
        return RangesKt.coerceIn(j - ((long) vectorizedDurationBasedAnimationSpec.getDelayMillis()), 0L, vectorizedDurationBasedAnimationSpec.getDurationMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <V extends AnimationVector> Animations createSpringAnimations(V v, float f, float f4) {
        return v != null ? new Animations(v, f, f4) { // from class: androidx.compose.animation.core.VectorizedAnimationSpecKt.createSpringAnimations.1

            @NotNull
            private final List<FloatSpringSpec> anims;

            /* JADX WARN: Incorrect types in method signature: (TV;FF)V */
            {
                IntRange intRangeUntil = RangesKt.until(0, v.getSize());
                ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(intRangeUntil));
                Iterator<Integer> it = intRangeUntil.iterator();
                while (it.hasNext()) {
                    arrayList.add(new FloatSpringSpec(f, f4, v.get$animation_core_release(((IntIterator) it).nextInt())));
                }
                this.anims = arrayList;
            }

            @Override // androidx.compose.animation.core.Animations
            @NotNull
            public FloatSpringSpec get(int index) {
                return this.anims.get(index);
            }
        } : new Animations(f, f4) { // from class: androidx.compose.animation.core.VectorizedAnimationSpecKt.createSpringAnimations.2

            @NotNull
            private final FloatSpringSpec anim;

            {
                this.anim = new FloatSpringSpec(f, f4, 0.0f, 4, null);
            }

            @Override // androidx.compose.animation.core.Animations
            @NotNull
            public FloatSpringSpec get(int index) {
                return this.anim;
            }
        };
    }

    public static final <V extends AnimationVector> long getDurationMillis(@NotNull VectorizedAnimationSpec<V> vectorizedAnimationSpec, @NotNull V v, @NotNull V v4, @NotNull V v5) {
        return vectorizedAnimationSpec.getDurationNanos(v, v4, v5) / AnimationKt.MillisToNanos;
    }

    @NotNull
    public static final <V extends AnimationVector> V getValueFromMillis(@NotNull VectorizedAnimationSpec<V> vectorizedAnimationSpec, long j, @NotNull V v, @NotNull V v4, @NotNull V v5) {
        return (V) vectorizedAnimationSpec.getValueFromNanos(j * AnimationKt.MillisToNanos, v, v4, v5);
    }
}
