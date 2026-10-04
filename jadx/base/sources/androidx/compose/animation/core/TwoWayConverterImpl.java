package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004B-\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\bR \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\f"}, m13886d2 = {"Landroidx/compose/animation/core/TwoWayConverterImpl;", "T", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/TwoWayConverter;", "convertToVector", "Lkotlin/Function1;", "convertFromVector", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getConvertFromVector", "()Lkotlin/jvm/functions/Function1;", "getConvertToVector", "animation-core_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
final class TwoWayConverterImpl<T, V extends AnimationVector> implements TwoWayConverter<T, V> {

    @NotNull
    private final Function1<V, T> convertFromVector;

    @NotNull
    private final Function1<T, V> convertToVector;

    /* JADX WARN: Multi-variable type inference failed */
    public TwoWayConverterImpl(@NotNull Function1<? super T, ? extends V> function1, @NotNull Function1<? super V, ? extends T> function12) {
        this.convertToVector = function1;
        this.convertFromVector = function12;
    }

    @Override // androidx.compose.animation.core.TwoWayConverter
    @NotNull
    public Function1<V, T> getConvertFromVector() {
        return this.convertFromVector;
    }

    @Override // androidx.compose.animation.core.TwoWayConverter
    @NotNull
    public Function1<T, V> getConvertToVector() {
        return this.convertToVector;
    }
}
