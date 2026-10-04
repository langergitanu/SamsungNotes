package androidx.compose.runtime;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, m13886d2 = {"Landroidx/compose/runtime/UnboxedLongState;", "Landroidx/compose/runtime/LongState;", "baseState", "Landroidx/compose/runtime/State;", "", "(Landroidx/compose/runtime/State;)V", "longValue", "getLongValue", "()J", "value", "getValue", "()Ljava/lang/Long;", "toString", "", "runtime_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class UnboxedLongState implements LongState {
    public static final int $stable = 0;

    @NotNull
    private final State<Long> baseState;

    public UnboxedLongState(@NotNull State<Long> state) {
        this.baseState = state;
    }

    @Override // androidx.compose.runtime.LongState
    public long getLongValue() {
        return this.baseState.getValue().longValue();
    }

    @NotNull
    public String toString() {
        return "UnboxedLongState(baseState=" + this.baseState + ")@" + hashCode();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.compose.runtime.LongState, androidx.compose.runtime.State
    @NotNull
    public Long getValue() {
        return this.baseState.getValue();
    }
}
