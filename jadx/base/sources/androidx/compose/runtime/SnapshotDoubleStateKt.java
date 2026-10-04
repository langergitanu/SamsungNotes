package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.StateFactoryMarker;
import kotlin.Metadata;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"androidx/compose/runtime/SnapshotDoubleStateKt__SnapshotDoubleStateKt"}, m13887k = 4, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class SnapshotDoubleStateKt {
    public static final double getValue(@NotNull DoubleState doubleState, @Nullable Object obj, @NotNull KProperty<?> kProperty) {
        return SnapshotDoubleStateKt__SnapshotDoubleStateKt.getValue(doubleState, obj, kProperty);
    }

    @StateFactoryMarker
    @NotNull
    public static final MutableDoubleState mutableDoubleStateOf(double d) {
        return SnapshotDoubleStateKt__SnapshotDoubleStateKt.mutableDoubleStateOf(d);
    }

    public static final void setValue(@NotNull MutableDoubleState mutableDoubleState, @Nullable Object obj, @NotNull KProperty<?> kProperty, double d) {
        SnapshotDoubleStateKt__SnapshotDoubleStateKt.setValue(mutableDoubleState, obj, kProperty, d);
    }
}
