package androidx.compose.animation.core;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0017\b\u0004\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J7\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00050\u000f\"\b\b\u0001\u0010\u0010*\u00020\u00112\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u00100\u0013H\u0000¢\u0006\u0002\b\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0016\u0010\u0003\u001a\u00028\u0000X\u0080\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f\u0082\u0001\u0001\u0015¨\u0006\u0016"}, m13886d2 = {"Landroidx/compose/animation/core/KeyframeBaseEntity;", "T", "", "value", "easing", "Landroidx/compose/animation/core/Easing;", "(Ljava/lang/Object;Landroidx/compose/animation/core/Easing;)V", "getEasing$animation_core_release", "()Landroidx/compose/animation/core/Easing;", "setEasing$animation_core_release", "(Landroidx/compose/animation/core/Easing;)V", "getValue$animation_core_release", "()Ljava/lang/Object;", "Ljava/lang/Object;", "toPair", "Lkotlin/Pair;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroidx/compose/animation/core/AnimationVector;", "convertToVector", "Lkotlin/Function1;", "toPair$animation_core_release", "Landroidx/compose/animation/core/KeyframesSpec$KeyframeEntity;", "animation-core_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public abstract class KeyframeBaseEntity<T> {
    public static final int $stable = 8;

    @NotNull
    private Easing easing;
    private final T value;

    public /* synthetic */ KeyframeBaseEntity(Object obj, Easing easing, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, easing);
    }

    @NotNull
    /* JADX INFO: renamed from: getEasing$animation_core_release, reason: from getter */
    public final Easing getEasing() {
        return this.easing;
    }

    public final T getValue$animation_core_release() {
        return this.value;
    }

    public final void setEasing$animation_core_release(@NotNull Easing easing) {
        this.easing = easing;
    }

    @NotNull
    public final <V extends AnimationVector> Pair<V, Easing> toPair$animation_core_release(@NotNull Function1<? super T, ? extends V> convertToVector) {
        return TuplesKt.m13893to(convertToVector.invoke(this.value), this.easing);
    }

    private KeyframeBaseEntity(T t, Easing easing) {
        this.value = t;
        this.easing = easing;
    }
}
