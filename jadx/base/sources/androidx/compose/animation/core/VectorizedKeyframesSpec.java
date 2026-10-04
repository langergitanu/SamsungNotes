package androidx.compose.animation.core;

import androidx.collection.IntList;
import androidx.collection.IntObjectMap;
import androidx.collection.MutableIntList;
import androidx.collection.MutableIntObjectMap;
import androidx.compose.animation.core.AnimationVector;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B9\b\u0016\u0012\u001e\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u00070\u0005\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006¢\u0006\u0002\u0010\u000bBC\b\u0000\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f0\u000e\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J\u0010\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u0006H\u0002J\u0010\u0010'\u001a\u00020(2\u0006\u0010&\u001a\u00020\u0006H\u0002J \u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u00062\u0006\u0010+\u001a\u00020,H\u0002J-\u0010-\u001a\u00028\u00002\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00028\u00002\u0006\u00101\u001a\u00028\u00002\u0006\u00102\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00103J-\u00104\u001a\u00028\u00002\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00028\u00002\u0006\u00101\u001a\u00028\u00002\u0006\u00102\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00103J%\u00105\u001a\u0002062\u0006\u00100\u001a\u00028\u00002\u0006\u00101\u001a\u00028\u00002\u0006\u00102\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00107R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\t\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0016\u0010\u0011\u001a\u00020\u0012X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0019R\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00028\u0000X\u0082.¢\u0006\u0004\n\u0002\u0010\u001bR\u0010\u0010\u001c\u001a\u00028\u0000X\u0082.¢\u0006\u0004\n\u0002\u0010\u001bR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020 X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020 X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u00028\u0000X\u0082.¢\u0006\u0004\n\u0002\u0010\u001bR\u0010\u0010$\u001a\u00028\u0000X\u0082.¢\u0006\u0004\n\u0002\u0010\u001b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00068"}, m13886d2 = {"Landroidx/compose/animation/core/VectorizedKeyframesSpec;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;", "keyframes", "", "", "Lkotlin/Pair;", "Landroidx/compose/animation/core/Easing;", "durationMillis", "delayMillis", "(Ljava/util/Map;II)V", "timestamps", "Landroidx/collection/IntList;", "Landroidx/collection/IntObjectMap;", "Landroidx/compose/animation/core/VectorizedKeyframeSpecElementInfo;", "defaultEasing", "initialArcMode", "Landroidx/compose/animation/core/ArcMode;", "(Landroidx/collection/IntList;Landroidx/collection/IntObjectMap;IILandroidx/compose/animation/core/Easing;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "arcSpline", "Landroidx/compose/animation/core/ArcSpline;", "getDelayMillis", "()I", "getDurationMillis", "I", "lastInitialValue", "Landroidx/compose/animation/core/AnimationVector;", "lastTargetValue", "modes", "", "posArray", "", "slopeArray", "times", "valueVector", "velocityVector", "findEntryForTimeMillis", "timeMillis", "getEasedTime", "", "getEasedTimeFromIndex", "index", "asFraction", "", "getValueFromNanos", "playTimeNanos", "", "initialValue", "targetValue", "initialVelocity", "(JLandroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getVelocityFromNanos", "init", "", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)V", "animation-core_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nVectorizedAnimationSpec.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VectorizedAnimationSpec.kt\nandroidx/compose/animation/core/VectorizedKeyframesSpec\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 IntList.kt\nandroidx/collection/IntList\n*L\n1#1,1078:1\n215#2,2:1079\n215#2,2:1081\n70#3:1083\n*S KotlinDebug\n*F\n+ 1 VectorizedAnimationSpec.kt\nandroidx/compose/animation/core/VectorizedKeyframesSpec\n*L\n256#1:1079,2\n270#1:1081,2\n503#1:1083\n*E\n"})
public final class VectorizedKeyframesSpec<V extends AnimationVector> implements VectorizedDurationBasedAnimationSpec<V> {
    public static final int $stable = 8;
    private ArcSpline arcSpline;

    @NotNull
    private final Easing defaultEasing;
    private final int delayMillis;
    private final int durationMillis;
    private final int initialArcMode;

    @NotNull
    private final IntObjectMap<VectorizedKeyframeSpecElementInfo<V>> keyframes;
    private V lastInitialValue;
    private V lastTargetValue;
    private int[] modes;
    private float[] posArray;
    private float[] slopeArray;
    private float[] times;

    @NotNull
    private final IntList timestamps;
    private V valueVector;
    private V velocityVector;

    public /* synthetic */ VectorizedKeyframesSpec(IntList intList, IntObjectMap intObjectMap, int i, int i2, Easing easing, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(intList, intObjectMap, i, i2, easing, i4);
    }

    private final int findEntryForTimeMillis(int timeMillis) {
        int iBinarySearch$default = IntListExtensionKt.binarySearch$default(this.timestamps, timeMillis, 0, 0, 6, null);
        return iBinarySearch$default < -1 ? -(iBinarySearch$default + 2) : iBinarySearch$default;
    }

    private final float getEasedTime(int timeMillis) {
        return getEasedTimeFromIndex(findEntryForTimeMillis(timeMillis), timeMillis, false);
    }

    private final float getEasedTimeFromIndex(int index, int timeMillis, boolean asFraction) {
        Easing easing;
        float f;
        IntList intList = this.timestamps;
        if (index >= intList._size - 1) {
            f = timeMillis;
        } else {
            int i = intList.get(index);
            int i2 = this.timestamps.get(index + 1);
            if (timeMillis == i) {
                f = i;
            } else {
                int i4 = i2 - i;
                VectorizedKeyframeSpecElementInfo<V> vectorizedKeyframeSpecElementInfo = this.keyframes.get(i);
                if (vectorizedKeyframeSpecElementInfo == null || (easing = vectorizedKeyframeSpecElementInfo.getEasing()) == null) {
                    easing = this.defaultEasing;
                }
                float f4 = i4;
                float fTransform = easing.transform((timeMillis - i) / f4);
                if (asFraction) {
                    return fTransform;
                }
                f = (f4 * fTransform) + i;
            }
        }
        return f / 1000;
    }

    private final void init(V initialValue, V targetValue, V initialVelocity) {
        float[] fArr;
        float[] fArr2;
        boolean z = this.arcSpline != null;
        if (this.valueVector == null) {
            this.valueVector = (V) AnimationVectorsKt.newInstance(initialValue);
            this.velocityVector = (V) AnimationVectorsKt.newInstance(initialVelocity);
            int size = this.timestamps.getSize();
            float[] fArr3 = new float[size];
            for (int i = 0; i < size; i++) {
                fArr3[i] = this.timestamps.get(i) / 1000;
            }
            this.times = fArr3;
            int size2 = this.timestamps.getSize();
            int[] iArr = new int[size2];
            for (int i2 = 0; i2 < size2; i2++) {
                VectorizedKeyframeSpecElementInfo<V> vectorizedKeyframeSpecElementInfo = this.keyframes.get(this.timestamps.get(i2));
                int iM15379getArcMode9TMq4 = vectorizedKeyframeSpecElementInfo != null ? vectorizedKeyframeSpecElementInfo.m15379getArcMode9TMq4() : this.initialArcMode;
                if (!ArcMode.m15320equalsimpl0(iM15379getArcMode9TMq4, ArcMode.INSTANCE.m15326getArcLinear9TMq4())) {
                    z = true;
                }
                iArr[i2] = iM15379getArcMode9TMq4;
            }
            this.modes = iArr;
        }
        if (z) {
            float[] fArr4 = null;
            if (this.arcSpline != null) {
                V v = this.lastInitialValue;
                if (v == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("lastInitialValue");
                    v = null;
                }
                if (Intrinsics.areEqual(v, initialValue)) {
                    V v4 = this.lastTargetValue;
                    if (v4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("lastTargetValue");
                        v4 = null;
                    }
                    if (Intrinsics.areEqual(v4, targetValue)) {
                        return;
                    }
                }
            }
            this.lastInitialValue = initialValue;
            this.lastTargetValue = targetValue;
            int size3 = initialValue.getSize() + (initialValue.getSize() % 2);
            this.posArray = new float[size3];
            this.slopeArray = new float[size3];
            int size4 = this.timestamps.getSize();
            float[][] fArr5 = new float[size4][];
            for (int i4 = 0; i4 < size4; i4++) {
                int i5 = this.timestamps.get(i4);
                if (i5 != 0) {
                    if (i5 != getDurationMillis()) {
                        fArr = new float[size3];
                        VectorizedKeyframeSpecElementInfo<V> vectorizedKeyframeSpecElementInfo2 = this.keyframes.get(i5);
                        Intrinsics.checkNotNull(vectorizedKeyframeSpecElementInfo2);
                        AnimationVector vectorValue = vectorizedKeyframeSpecElementInfo2.getVectorValue();
                        for (int i6 = 0; i6 < size3; i6++) {
                            fArr[i6] = vectorValue.get$animation_core_release(i6);
                        }
                    } else if (this.keyframes.contains(i5)) {
                        fArr = new float[size3];
                        VectorizedKeyframeSpecElementInfo<V> vectorizedKeyframeSpecElementInfo3 = this.keyframes.get(i5);
                        Intrinsics.checkNotNull(vectorizedKeyframeSpecElementInfo3);
                        AnimationVector vectorValue2 = vectorizedKeyframeSpecElementInfo3.getVectorValue();
                        for (int i7 = 0; i7 < size3; i7++) {
                            fArr[i7] = vectorValue2.get$animation_core_release(i7);
                        }
                    } else {
                        fArr2 = new float[size3];
                        for (int i8 = 0; i8 < size3; i8++) {
                            fArr2[i8] = targetValue.get$animation_core_release(i8);
                        }
                    }
                    fArr2 = fArr;
                } else if (this.keyframes.contains(i5)) {
                    fArr = new float[size3];
                    VectorizedKeyframeSpecElementInfo<V> vectorizedKeyframeSpecElementInfo4 = this.keyframes.get(i5);
                    Intrinsics.checkNotNull(vectorizedKeyframeSpecElementInfo4);
                    AnimationVector vectorValue3 = vectorizedKeyframeSpecElementInfo4.getVectorValue();
                    for (int i9 = 0; i9 < size3; i9++) {
                        fArr[i9] = vectorValue3.get$animation_core_release(i9);
                    }
                    fArr2 = fArr;
                } else {
                    fArr2 = new float[size3];
                    for (int i10 = 0; i10 < size3; i10++) {
                        fArr2[i10] = initialValue.get$animation_core_release(i10);
                    }
                }
                fArr5[i4] = fArr2;
            }
            int[] iArr2 = this.modes;
            if (iArr2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("modes");
                iArr2 = null;
            }
            float[] fArr6 = this.times;
            if (fArr6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("times");
            } else {
                fArr4 = fArr6;
            }
            this.arcSpline = new ArcSpline(iArr2, fArr4, fArr5);
        }
    }

    @Override // androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec
    public int getDelayMillis() {
        return this.delayMillis;
    }

    @Override // androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec
    public int getDurationMillis() {
        return this.durationMillis;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    @NotNull
    public V getValueFromNanos(long playTimeNanos, @NotNull V initialValue, @NotNull V targetValue, @NotNull V initialVelocity) {
        int iClampPlayTime = (int) VectorizedAnimationSpecKt.clampPlayTime(this, playTimeNanos / AnimationKt.MillisToNanos);
        if (this.keyframes.contains(iClampPlayTime)) {
            VectorizedKeyframeSpecElementInfo<V> vectorizedKeyframeSpecElementInfo = this.keyframes.get(iClampPlayTime);
            Intrinsics.checkNotNull(vectorizedKeyframeSpecElementInfo);
            return (V) vectorizedKeyframeSpecElementInfo.getVectorValue();
        }
        if (iClampPlayTime >= getDurationMillis()) {
            return targetValue;
        }
        if (iClampPlayTime <= 0) {
            return initialValue;
        }
        init(initialValue, targetValue, initialVelocity);
        int i = 0;
        if (this.arcSpline == null) {
            int iFindEntryForTimeMillis = findEntryForTimeMillis(iClampPlayTime);
            float easedTimeFromIndex = getEasedTimeFromIndex(iFindEntryForTimeMillis, iClampPlayTime, true);
            int i2 = this.timestamps.get(iFindEntryForTimeMillis);
            if (this.keyframes.contains(i2)) {
                VectorizedKeyframeSpecElementInfo<V> vectorizedKeyframeSpecElementInfo2 = this.keyframes.get(i2);
                Intrinsics.checkNotNull(vectorizedKeyframeSpecElementInfo2);
                initialValue = (V) vectorizedKeyframeSpecElementInfo2.getVectorValue();
            }
            int i4 = this.timestamps.get(iFindEntryForTimeMillis + 1);
            if (this.keyframes.contains(i4)) {
                VectorizedKeyframeSpecElementInfo<V> vectorizedKeyframeSpecElementInfo3 = this.keyframes.get(i4);
                Intrinsics.checkNotNull(vectorizedKeyframeSpecElementInfo3);
                targetValue = (V) vectorizedKeyframeSpecElementInfo3.getVectorValue();
            }
            V v = this.valueVector;
            if (v == null) {
                Intrinsics.throwUninitializedPropertyAccessException("valueVector");
                v = null;
            }
            int size = v.getSize();
            while (i < size) {
                V v4 = this.valueVector;
                if (v4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("valueVector");
                    v4 = null;
                }
                v4.set$animation_core_release(i, VectorConvertersKt.lerp(initialValue.get$animation_core_release(i), targetValue.get$animation_core_release(i), easedTimeFromIndex));
                i++;
            }
            V v5 = this.valueVector;
            if (v5 != null) {
                return v5;
            }
            Intrinsics.throwUninitializedPropertyAccessException("valueVector");
            return null;
        }
        float easedTime = getEasedTime(iClampPlayTime);
        ArcSpline arcSpline = this.arcSpline;
        if (arcSpline == null) {
            Intrinsics.throwUninitializedPropertyAccessException("arcSpline");
            arcSpline = null;
        }
        float[] fArr = this.posArray;
        if (fArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("posArray");
            fArr = null;
        }
        arcSpline.getPos(easedTime, fArr);
        float[] fArr2 = this.posArray;
        if (fArr2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("posArray");
            fArr2 = null;
        }
        int length = fArr2.length;
        while (i < length) {
            V v6 = this.valueVector;
            if (v6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("valueVector");
                v6 = null;
            }
            float[] fArr3 = this.posArray;
            if (fArr3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("posArray");
                fArr3 = null;
            }
            v6.set$animation_core_release(i, fArr3[i]);
            i++;
        }
        V v7 = this.valueVector;
        if (v7 != null) {
            return v7;
        }
        Intrinsics.throwUninitializedPropertyAccessException("valueVector");
        return null;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    @NotNull
    public V getVelocityFromNanos(long playTimeNanos, @NotNull V initialValue, @NotNull V targetValue, @NotNull V initialVelocity) {
        long jClampPlayTime = VectorizedAnimationSpecKt.clampPlayTime(this, playTimeNanos / AnimationKt.MillisToNanos);
        if (jClampPlayTime < 0) {
            return initialVelocity;
        }
        init(initialValue, targetValue, initialVelocity);
        int i = 0;
        if (this.arcSpline == null) {
            AnimationVector valueFromMillis = VectorizedAnimationSpecKt.getValueFromMillis(this, jClampPlayTime - 1, initialValue, targetValue, initialVelocity);
            AnimationVector valueFromMillis2 = VectorizedAnimationSpecKt.getValueFromMillis(this, jClampPlayTime, initialValue, targetValue, initialVelocity);
            int size = valueFromMillis.getSize();
            while (i < size) {
                V v = this.velocityVector;
                if (v == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
                    v = null;
                }
                v.set$animation_core_release(i, (valueFromMillis.get$animation_core_release(i) - valueFromMillis2.get$animation_core_release(i)) * 1000.0f);
                i++;
            }
            V v4 = this.velocityVector;
            if (v4 != null) {
                return v4;
            }
            Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
            return null;
        }
        float easedTime = getEasedTime((int) jClampPlayTime);
        ArcSpline arcSpline = this.arcSpline;
        if (arcSpline == null) {
            Intrinsics.throwUninitializedPropertyAccessException("arcSpline");
            arcSpline = null;
        }
        float[] fArr = this.slopeArray;
        if (fArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("slopeArray");
            fArr = null;
        }
        arcSpline.getSlope(easedTime, fArr);
        float[] fArr2 = this.slopeArray;
        if (fArr2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("slopeArray");
            fArr2 = null;
        }
        int length = fArr2.length;
        while (i < length) {
            V v5 = this.velocityVector;
            if (v5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
                v5 = null;
            }
            float[] fArr3 = this.slopeArray;
            if (fArr3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("slopeArray");
                fArr3 = null;
            }
            v5.set$animation_core_release(i, fArr3[i]);
            i++;
        }
        V v6 = this.velocityVector;
        if (v6 != null) {
            return v6;
        }
        Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
        return null;
    }

    private VectorizedKeyframesSpec(IntList intList, IntObjectMap<VectorizedKeyframeSpecElementInfo<V>> intObjectMap, int i, int i2, Easing easing, int i4) {
        this.timestamps = intList;
        this.keyframes = intObjectMap;
        this.durationMillis = i;
        this.delayMillis = i2;
        this.defaultEasing = easing;
        this.initialArcMode = i4;
    }

    public /* synthetic */ VectorizedKeyframesSpec(Map map, int i, int i2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(map, i, (i4 & 4) != 0 ? 0 : i2);
    }

    public VectorizedKeyframesSpec(@NotNull Map<Integer, ? extends Pair<? extends V, ? extends Easing>> map, int i, int i2) {
        MutableIntList mutableIntList = new MutableIntList(map.size() + 2);
        Iterator<Map.Entry<Integer, ? extends Pair<? extends V, ? extends Easing>>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            mutableIntList.add(it.next().getKey().intValue());
        }
        if (!map.containsKey(0)) {
            mutableIntList.add(0, 0);
        }
        if (!map.containsKey(Integer.valueOf(i))) {
            mutableIntList.add(i);
        }
        mutableIntList.sort();
        MutableIntObjectMap mutableIntObjectMap = new MutableIntObjectMap(0, 1, null);
        for (Map.Entry<Integer, ? extends Pair<? extends V, ? extends Easing>> entry : map.entrySet()) {
            int iIntValue = entry.getKey().intValue();
            Pair<? extends V, ? extends Easing> value = entry.getValue();
            mutableIntObjectMap.set(iIntValue, new VectorizedKeyframeSpecElementInfo(value.getFirst(), value.getSecond(), ArcMode.INSTANCE.m15326getArcLinear9TMq4(), null));
        }
        this(mutableIntList, mutableIntObjectMap, i, i2, EasingKt.getLinearEasing(), ArcMode.INSTANCE.m15326getArcLinear9TMq4(), null);
    }
}
