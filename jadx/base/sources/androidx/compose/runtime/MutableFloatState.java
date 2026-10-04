package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.AutoboxingStateValueProperty;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Stable
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\n\bg\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002R\u0018\u0010\u0004\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038W@WX\u0096\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0003"}, m13886d2 = {"Landroidx/compose/runtime/MutableFloatState;", "Landroidx/compose/runtime/FloatState;", "Landroidx/compose/runtime/MutableState;", "", "floatValue", "getFloatValue", "()F", "setFloatValue", "(F)V", "value", "getValue", "()Ljava/lang/Float;", "setValue", "runtime_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public interface MutableFloatState extends FloatState, MutableState<Float> {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class DefaultImpls {
        @AutoboxingStateValueProperty(preferredPropertyName = "floatValue")
        @Deprecated
        @NotNull
        public static Float getValue(@NotNull MutableFloatState mutableFloatState) {
            return Float.valueOf(MutableFloatState.access$getValue$jd(mutableFloatState));
        }

        @AutoboxingStateValueProperty(preferredPropertyName = "floatValue")
        @Deprecated
        public static void setValue(@NotNull MutableFloatState mutableFloatState, float f) {
            MutableFloatState.super.setValue(f);
        }
    }

    static /* synthetic */ float access$getValue$jd(MutableFloatState mutableFloatState) {
        return super.getValue().floatValue();
    }

    @Override // androidx.compose.runtime.FloatState
    float getFloatValue();

    void setFloatValue(float f);

    @Override // androidx.compose.runtime.MutableState
    /* bridge */ /* synthetic */ default void setValue(Float f) {
        setValue(f.floatValue());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.compose.runtime.FloatState, androidx.compose.runtime.State
    @AutoboxingStateValueProperty(preferredPropertyName = "floatValue")
    @NotNull
    default Float getValue() {
        return Float.valueOf(getFloatValue());
    }

    @AutoboxingStateValueProperty(preferredPropertyName = "floatValue")
    default void setValue(float f) {
        setFloatValue(f);
    }
}
