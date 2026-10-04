package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0000H&J\b\u0010\u0011\u001a\u00020\u0000H&R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0000X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0012"}, m13886d2 = {"Landroidx/compose/runtime/snapshots/StateRecord;", "", "()V", "next", "getNext$runtime_release", "()Landroidx/compose/runtime/snapshots/StateRecord;", "setNext$runtime_release", "(Landroidx/compose/runtime/snapshots/StateRecord;)V", "snapshotId", "", "getSnapshotId$runtime_release", "()I", "setSnapshotId$runtime_release", "(I)V", "assign", "", "value", "create", "runtime_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public abstract class StateRecord {
    public static final int $stable = 8;

    @Nullable
    private StateRecord next;
    private int snapshotId = SnapshotKt.currentSnapshot().getId();

    public abstract void assign(@NotNull StateRecord value);

    @NotNull
    public abstract StateRecord create();

    @Nullable
    /* JADX INFO: renamed from: getNext$runtime_release, reason: from getter */
    public final StateRecord getNext() {
        return this.next;
    }

    /* JADX INFO: renamed from: getSnapshotId$runtime_release, reason: from getter */
    public final int getSnapshotId() {
        return this.snapshotId;
    }

    public final void setNext$runtime_release(@Nullable StateRecord stateRecord) {
        this.next = stateRecord;
    }

    public final void setSnapshotId$runtime_release(int i) {
        this.snapshotId = i;
    }
}
