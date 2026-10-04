package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.StateFactoryMarker;
import kotlin.Metadata;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"androidx/compose/runtime/SnapshotIntStateKt__SnapshotIntStateKt"}, m13887k = 4, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class SnapshotIntStateKt {
    public static final int getValue(@NotNull IntState intState, @Nullable Object obj, @NotNull KProperty<?> kProperty) {
        return SnapshotIntStateKt__SnapshotIntStateKt.getValue(intState, obj, kProperty);
    }

    @StateFactoryMarker
    @NotNull
    public static final MutableIntState mutableIntStateOf(int i) {
        return SnapshotIntStateKt__SnapshotIntStateKt.mutableIntStateOf(i);
    }

    public static final void setValue(@NotNull MutableIntState mutableIntState, @Nullable Object obj, @NotNull KProperty<?> kProperty, int i) {
        SnapshotIntStateKt__SnapshotIntStateKt.setValue(mutableIntState, obj, kProperty, i);
    }
}
