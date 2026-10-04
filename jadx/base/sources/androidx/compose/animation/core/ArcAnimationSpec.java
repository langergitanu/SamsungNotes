package androidx.compose.animation.core;

import androidx.collection.IntListKt;
import androidx.collection.IntObjectMapKt;
import androidx.compose.runtime.Immutable;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Immutable
@Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B-\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0006H\u0016J,\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00190\u0018\"\b\b\u0001\u0010\u0019*\u00020\u001a2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u00190\u001cH\u0016R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0010\u0010\f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001d"}, m13886d2 = {"Landroidx/compose/animation/core/ArcAnimationSpec;", "T", "Landroidx/compose/animation/core/DurationBasedAnimationSpec;", "mode", "Landroidx/compose/animation/core/ArcMode;", "durationMillis", "", "delayMillis", "easing", "Landroidx/compose/animation/core/Easing;", "(IIILandroidx/compose/animation/core/Easing;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getDelayMillis", "()I", "getDurationMillis", "getEasing", "()Landroidx/compose/animation/core/Easing;", "getMode--9T-Mq4", "I", "equals", "", "other", "", "hashCode", "vectorize", "Landroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroidx/compose/animation/core/AnimationVector;", "converter", "Landroidx/compose/animation/core/TwoWayConverter;", "animation-core_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@ExperimentalAnimationSpecApi
public final class ArcAnimationSpec<T> implements DurationBasedAnimationSpec<T> {
    public static final int $stable = 0;
    private final int delayMillis;
    private final int durationMillis;

    @NotNull
    private final Easing easing;
    private final int mode;

    public /* synthetic */ ArcAnimationSpec(int i, int i2, int i4, Easing easing, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i4, easing);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ArcAnimationSpec)) {
            return false;
        }
        ArcAnimationSpec arcAnimationSpec = (ArcAnimationSpec) other;
        if (ArcMode.m15320equalsimpl0(this.mode, arcAnimationSpec.mode) && this.durationMillis == arcAnimationSpec.durationMillis && this.delayMillis == arcAnimationSpec.delayMillis) {
            return Intrinsics.areEqual(this.easing, arcAnimationSpec.easing);
        }
        return false;
    }

    public final int getDelayMillis() {
        return this.delayMillis;
    }

    public final int getDurationMillis() {
        return this.durationMillis;
    }

    @NotNull
    public final Easing getEasing() {
        return this.easing;
    }

    /* JADX INFO: renamed from: getMode--9T-Mq4, reason: not valid java name and from getter */
    public final int getMode() {
        return this.mode;
    }

    public int hashCode() {
        return this.easing.hashCode() + (((((ArcMode.m15321hashCodeimpl(this.mode) * 31) + this.durationMillis) * 31) + this.delayMillis) * 31);
    }

    private ArcAnimationSpec(int i, int i2, int i4, Easing easing) {
        this.mode = i;
        this.durationMillis = i2;
        this.delayMillis = i4;
        this.easing = easing;
    }

    @Override // androidx.compose.animation.core.FiniteAnimationSpec, androidx.compose.animation.core.AnimationSpec
    @NotNull
    public <V extends AnimationVector> VectorizedDurationBasedAnimationSpec<V> vectorize(@NotNull TwoWayConverter<T, V> converter) {
        return new VectorizedKeyframesSpec(IntListKt.intListOf(0, this.durationMillis), IntObjectMapKt.emptyIntObjectMap(), this.durationMillis, this.delayMillis, this.easing, this.mode, null);
    }

    public /* synthetic */ ArcAnimationSpec(int i, int i2, int i4, Easing easing, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? ArcMode.INSTANCE.m15325getArcBelow9TMq4() : i, (i5 & 2) != 0 ? 300 : i2, (i5 & 4) != 0 ? 0 : i4, (i5 & 8) != 0 ? EasingKt.getFastOutSlowInEasing() : easing, null);
    }
}
