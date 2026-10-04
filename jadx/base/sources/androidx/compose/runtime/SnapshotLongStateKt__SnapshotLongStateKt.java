package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.StateFactoryMarker;
import kotlin.Metadata;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a#\u0010\u0004\u001a\u00020\u0003*\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\u0086\n\u001a+\u0010\n\u001a\u00020\u000b*\u00020\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\n¨\u0006\f"}, m13886d2 = {"mutableLongStateOf", "Landroidx/compose/runtime/MutableLongState;", "value", "", "getValue", "Landroidx/compose/runtime/LongState;", "thisObj", "", "property", "Lkotlin/reflect/KProperty;", "setValue", "", "runtime_release"}, m13887k = 5, m13888mv = {1, 8, 0}, m13890xi = 48, m13891xs = "androidx/compose/runtime/SnapshotLongStateKt")
final /* synthetic */ class SnapshotLongStateKt__SnapshotLongStateKt {
    public static final long getValue(@NotNull LongState longState, @Nullable Object obj, @NotNull KProperty<?> kProperty) {
        return longState.getLongValue();
    }

    @StateFactoryMarker
    @NotNull
    public static final MutableLongState mutableLongStateOf(long j) {
        return ActualAndroid_androidKt.createSnapshotMutableLongState(j);
    }

    public static final void setValue(@NotNull MutableLongState mutableLongState, @Nullable Object obj, @NotNull KProperty<?> kProperty, long j) {
        mutableLongState.setLongValue(j);
    }
}
