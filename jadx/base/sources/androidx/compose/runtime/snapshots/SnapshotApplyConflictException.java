package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m13886d2 = {"Landroidx/compose/runtime/snapshots/SnapshotApplyConflictException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "snapshot", "Landroidx/compose/runtime/snapshots/Snapshot;", "(Landroidx/compose/runtime/snapshots/Snapshot;)V", "getSnapshot", "()Landroidx/compose/runtime/snapshots/Snapshot;", "runtime_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class SnapshotApplyConflictException extends Exception {
    public static final int $stable = 8;

    @NotNull
    private final Snapshot snapshot;

    public SnapshotApplyConflictException(@NotNull Snapshot snapshot) {
        this.snapshot = snapshot;
    }

    @NotNull
    public final Snapshot getSnapshot() {
        return this.snapshot;
    }
}
