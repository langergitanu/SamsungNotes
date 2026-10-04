package androidx.compose.runtime.snapshots;

import androidx.collection.MutableScatterSet;
import androidx.compose.runtime.AbstractC1974b;
import androidx.compose.runtime.ActualJvm_jvmKt;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001BK\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\b\u00106\u001a\u000207H\u0016J\b\u00108\u001a\u00020\u0006H\u0016J\b\u00109\u001a\u00020\tH\u0016J\u0015\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=H\u0010¢\u0006\u0002\b>J\u0015\u0010?\u001a\u00020;2\u0006\u0010<\u001a\u00020=H\u0010¢\u0006\u0002\b@J\r\u0010A\u001a\u00020\u0006H\u0010¢\u0006\u0002\bBJ\u0015\u0010C\u001a\u00020\u00062\u0006\u0010D\u001a\u00020\u001dH\u0010¢\u0006\u0002\bEJ4\u0010F\u001a\u00020\u00012\u0014\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00042\u0014\u00103\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004H\u0016J\u001e\u0010G\u001a\u00020=2\u0014\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004H\u0016R\u0014\u0010\f\u001a\u00020\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00108V@PX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u00168P@PX\u0090\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R4\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c8P@VX\u0090\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R@\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00042\u0014\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004@VX\u0090\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020-X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R$\u00100\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00108P@PX\u0090\u000e¢\u0006\f\u001a\u0004\b1\u0010\u0013\"\u0004\b2\u0010\u0015R@\u00103\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00042\u0014\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004@VX\u0090\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010&\"\u0004\b5\u0010(¨\u0006H"}, m13886d2 = {"Landroidx/compose/runtime/snapshots/TransparentObserverMutableSnapshot;", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "parentSnapshot", "specifiedReadObserver", "Lkotlin/Function1;", "", "", "specifiedWriteObserver", "mergeParentObservers", "", "ownsParentSnapshot", "(Landroidx/compose/runtime/snapshots/MutableSnapshot;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZZ)V", "currentSnapshot", "getCurrentSnapshot", "()Landroidx/compose/runtime/snapshots/MutableSnapshot;", "value", "", "id", "getId", "()I", "setId$runtime_release", "(I)V", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "invalid", "getInvalid$runtime_release", "()Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "setInvalid$runtime_release", "(Landroidx/compose/runtime/snapshots/SnapshotIdSet;)V", "Landroidx/collection/MutableScatterSet;", "Landroidx/compose/runtime/snapshots/StateObject;", "modified", "getModified$runtime_release", "()Landroidx/collection/MutableScatterSet;", "setModified", "(Landroidx/collection/MutableScatterSet;)V", "<set-?>", "readObserver", "getReadObserver$runtime_release", "()Lkotlin/jvm/functions/Function1;", "setReadObserver", "(Lkotlin/jvm/functions/Function1;)V", "readOnly", "getReadOnly", "()Z", "threadId", "", "getThreadId$runtime_release", "()J", "writeCount", "getWriteCount$runtime_release", "setWriteCount$runtime_release", "writeObserver", "getWriteObserver$runtime_release", "setWriteObserver", "apply", "Landroidx/compose/runtime/snapshots/SnapshotApplyResult;", "dispose", "hasPendingChanges", "nestedActivated", "", "snapshot", "Landroidx/compose/runtime/snapshots/Snapshot;", "nestedActivated$runtime_release", "nestedDeactivated", "nestedDeactivated$runtime_release", "notifyObjectsInitialized", "notifyObjectsInitialized$runtime_release", "recordModified", "state", "recordModified$runtime_release", "takeNestedMutableSnapshot", "takeNestedSnapshot", "runtime_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class TransparentObserverMutableSnapshot extends MutableSnapshot {
    public static final int $stable = 8;
    private final boolean mergeParentObservers;
    private final boolean ownsParentSnapshot;

    @Nullable
    private final MutableSnapshot parentSnapshot;

    @Nullable
    private Function1<Object, Unit> readObserver;
    private final long threadId;

    @Nullable
    private Function1<Object, Unit> writeObserver;

    public TransparentObserverMutableSnapshot(@Nullable MutableSnapshot mutableSnapshot, @Nullable Function1<Object, Unit> function1, @Nullable Function1<Object, Unit> function12, boolean z, boolean z2) {
        Function1<Object, Unit> writeObserver$runtime_release;
        Function1<Object, Unit> readObserver;
        super(0, SnapshotIdSet.INSTANCE.getEMPTY(), SnapshotKt.mergedReadObserver(function1, (mutableSnapshot == null || (readObserver = mutableSnapshot.getReadObserver()) == null) ? ((GlobalSnapshot) SnapshotKt.currentGlobalSnapshot.get()).getReadObserver() : readObserver, z), SnapshotKt.mergedWriteObserver(function12, (mutableSnapshot == null || (writeObserver$runtime_release = mutableSnapshot.getWriteObserver$runtime_release()) == null) ? ((GlobalSnapshot) SnapshotKt.currentGlobalSnapshot.get()).getWriteObserver$runtime_release() : writeObserver$runtime_release));
        this.parentSnapshot = mutableSnapshot;
        this.mergeParentObservers = z;
        this.ownsParentSnapshot = z2;
        this.readObserver = super.getReadObserver();
        this.writeObserver = super.getWriteObserver$runtime_release();
        this.threadId = ActualJvm_jvmKt.currentThreadId();
    }

    private final MutableSnapshot getCurrentSnapshot() {
        MutableSnapshot mutableSnapshot = this.parentSnapshot;
        return mutableSnapshot == null ? (MutableSnapshot) SnapshotKt.currentGlobalSnapshot.get() : mutableSnapshot;
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot
    @NotNull
    public SnapshotApplyResult apply() {
        return getCurrentSnapshot().apply();
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public void dispose() {
        MutableSnapshot mutableSnapshot;
        setDisposed$runtime_release(true);
        if (!this.ownsParentSnapshot || (mutableSnapshot = this.parentSnapshot) == null) {
            return;
        }
        mutableSnapshot.dispose();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public int getId() {
        return getCurrentSnapshot().getId();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    @NotNull
    /* JADX INFO: renamed from: getInvalid$runtime_release */
    public SnapshotIdSet getInvalid() {
        return getCurrentSnapshot().getInvalid();
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    @Nullable
    public MutableScatterSet<StateObject> getModified$runtime_release() {
        return getCurrentSnapshot().getModified$runtime_release();
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    @Nullable
    /* JADX INFO: renamed from: getReadObserver$runtime_release, reason: merged with bridge method [inline-methods] */
    public Function1<Object, Unit> getReadObserver() {
        return this.readObserver;
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public boolean getReadOnly() {
        return getCurrentSnapshot().getReadOnly();
    }

    /* JADX INFO: renamed from: getThreadId$runtime_release, reason: from getter */
    public final long getThreadId() {
        return this.threadId;
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    /* JADX INFO: renamed from: getWriteCount$runtime_release */
    public int getWriteCount() {
        return getCurrentSnapshot().getWriteCount();
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    @Nullable
    public Function1<Object, Unit> getWriteObserver$runtime_release() {
        return this.writeObserver;
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public boolean hasPendingChanges() {
        return getCurrentSnapshot().hasPendingChanges();
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    @NotNull
    /* JADX INFO: renamed from: nestedActivated$runtime_release, reason: merged with bridge method [inline-methods] */
    public Void mo18112nestedActivated$runtime_release(@NotNull Snapshot snapshot) {
        throw AbstractC1974b.m1326s();
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    @NotNull
    /* JADX INFO: renamed from: nestedDeactivated$runtime_release, reason: merged with bridge method [inline-methods] */
    public Void mo18113nestedDeactivated$runtime_release(@NotNull Snapshot snapshot) {
        throw AbstractC1974b.m1326s();
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public void notifyObjectsInitialized$runtime_release() {
        getCurrentSnapshot().notifyObjectsInitialized$runtime_release();
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    /* JADX INFO: renamed from: recordModified$runtime_release */
    public void mo18114recordModified$runtime_release(@NotNull StateObject state) {
        getCurrentSnapshot().mo18114recordModified$runtime_release(state);
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void setId$runtime_release(int i) {
        throw AbstractC1974b.m1326s();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void setInvalid$runtime_release(@NotNull SnapshotIdSet snapshotIdSet) {
        throw AbstractC1974b.m1326s();
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot
    public void setModified(@Nullable MutableScatterSet<StateObject> mutableScatterSet) {
        throw AbstractC1974b.m1326s();
    }

    public void setReadObserver(@Nullable Function1<Object, Unit> function1) {
        this.readObserver = function1;
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public void setWriteCount$runtime_release(int i) {
        getCurrentSnapshot().setWriteCount$runtime_release(i);
    }

    public void setWriteObserver(@Nullable Function1<Object, Unit> function1) {
        this.writeObserver = function1;
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot
    @NotNull
    public MutableSnapshot takeNestedMutableSnapshot(@Nullable Function1<Object, Unit> readObserver, @Nullable Function1<Object, Unit> writeObserver) {
        Function1<Object, Unit> function1MergedReadObserver$default = SnapshotKt.mergedReadObserver$default(readObserver, getReadObserver(), false, 4, null);
        Function1<Object, Unit> function1MergedWriteObserver = SnapshotKt.mergedWriteObserver(writeObserver, getWriteObserver$runtime_release());
        return !this.mergeParentObservers ? new TransparentObserverMutableSnapshot(getCurrentSnapshot().takeNestedMutableSnapshot(null, function1MergedWriteObserver), function1MergedReadObserver$default, function1MergedWriteObserver, false, true) : getCurrentSnapshot().takeNestedMutableSnapshot(function1MergedReadObserver$default, function1MergedWriteObserver);
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    @NotNull
    public Snapshot takeNestedSnapshot(@Nullable Function1<Object, Unit> readObserver) {
        Function1<Object, Unit> function1MergedReadObserver$default = SnapshotKt.mergedReadObserver$default(readObserver, getReadObserver(), false, 4, null);
        return !this.mergeParentObservers ? SnapshotKt.createTransparentSnapshotWithNoParentReadObserver(getCurrentSnapshot().takeNestedSnapshot(null), function1MergedReadObserver$default, true) : getCurrentSnapshot().takeNestedSnapshot(function1MergedReadObserver$default);
    }
}
