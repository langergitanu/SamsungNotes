package androidx.compose.runtime.snapshots;

import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.collection.ScatterSetWrapperKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.snapshots.SnapshotApplyResult;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0015\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u001e\b\u0017\u0018\u0000 g2\u00020\u0001:\u0001gBC\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\u0010\u000bJ\b\u00109\u001a\u00020\tH\u0002J\r\u0010:\u001a\u00020\tH\u0000¢\u0006\u0002\b;J$\u0010:\u001a\u0002H<\"\u0004\b\u0000\u0010<2\f\u0010=\u001a\b\u0012\u0004\u0012\u0002H<0>H\u0080\b¢\u0006\u0004\b;\u0010?J\b\u0010@\u001a\u00020AH\u0016J\r\u0010B\u001a\u00020\tH\u0010¢\u0006\u0002\bCJ\b\u0010D\u001a\u00020\tH\u0016J\b\u0010E\u001a\u00020\rH\u0016J3\u0010F\u001a\u00020A2\u0006\u0010G\u001a\u00020\u00032\u0014\u0010H\u001a\u0010\u0012\u0004\u0012\u00020J\u0012\u0004\u0012\u00020J\u0018\u00010I2\u0006\u0010K\u001a\u00020\u0005H\u0000¢\u0006\u0002\bLJ\u0015\u0010M\u001a\u00020\t2\u0006\u0010N\u001a\u00020\u0001H\u0010¢\u0006\u0002\bOJ\u0015\u0010P\u001a\u00020\t2\u0006\u0010N\u001a\u00020\u0001H\u0010¢\u0006\u0002\bQJ\r\u0010R\u001a\u00020\tH\u0010¢\u0006\u0002\bSJ\u0015\u0010T\u001a\u00020\t2\u0006\u0010U\u001a\u00020\u0014H\u0010¢\u0006\u0002\bVJ\u0015\u0010W\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0002\bXJ\u0015\u0010Y\u001a\u00020\t2\u0006\u00102\u001a\u00020\u0005H\u0000¢\u0006\u0002\bZJ\u0015\u0010[\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0002\b\\J\u0015\u0010]\u001a\u00020\t2\u0006\u0010^\u001a\u00020&H\u0000¢\u0006\u0002\b_J\r\u0010`\u001a\u00020\tH\u0010¢\u0006\u0002\baJ\b\u0010b\u001a\u00020\tH\u0002J8\u0010c\u001a\u00020\u00002\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u00072\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H\u0016J\u001e\u0010d\u001a\u00020\u00012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H\u0016J\b\u0010e\u001a\u00020\tH\u0002J\b\u0010f\u001a\u00020\tH\u0002R\u001a\u0010\f\u001a\u00020\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R4\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001a2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001a@VX\u0090\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020&X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0014\u0010-\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010\u000fR\u0014\u0010/\u001a\u00020\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u000e\u00102\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00103\u001a\u00020\u0003X\u0090\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010,¨\u0006h"}, m13886d2 = {"Landroidx/compose/runtime/snapshots/MutableSnapshot;", "Landroidx/compose/runtime/snapshots/Snapshot;", "id", "", "invalid", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "readObserver", "Lkotlin/Function1;", "", "", "writeObserver", "(ILandroidx/compose/runtime/snapshots/SnapshotIdSet;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "applied", "", "getApplied$runtime_release", "()Z", "setApplied$runtime_release", "(Z)V", "merged", "", "Landroidx/compose/runtime/snapshots/StateObject;", "getMerged$runtime_release", "()Ljava/util/List;", "setMerged$runtime_release", "(Ljava/util/List;)V", "<set-?>", "Landroidx/collection/MutableScatterSet;", "modified", "getModified$runtime_release", "()Landroidx/collection/MutableScatterSet;", "setModified", "(Landroidx/collection/MutableScatterSet;)V", "previousIds", "getPreviousIds$runtime_release", "()Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "setPreviousIds$runtime_release", "(Landroidx/compose/runtime/snapshots/SnapshotIdSet;)V", "previousPinnedSnapshots", "", "getPreviousPinnedSnapshots$runtime_release", "()[I", "setPreviousPinnedSnapshots$runtime_release", "([I)V", "getReadObserver$runtime_release", "()Lkotlin/jvm/functions/Function1;", "readOnly", "getReadOnly", "root", "getRoot", "()Landroidx/compose/runtime/snapshots/Snapshot;", "snapshots", "writeCount", "getWriteCount$runtime_release", "()I", "setWriteCount$runtime_release", "(I)V", "getWriteObserver$runtime_release", "abandon", "advance", "advance$runtime_release", "T", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "apply", "Landroidx/compose/runtime/snapshots/SnapshotApplyResult;", "closeLocked", "closeLocked$runtime_release", "dispose", "hasPendingChanges", "innerApplyLocked", "snapshotId", "optimisticMerges", "", "Landroidx/compose/runtime/snapshots/StateRecord;", "invalidSnapshots", "innerApplyLocked$runtime_release", "nestedActivated", "snapshot", "nestedActivated$runtime_release", "nestedDeactivated", "nestedDeactivated$runtime_release", "notifyObjectsInitialized", "notifyObjectsInitialized$runtime_release", "recordModified", "state", "recordModified$runtime_release", "recordPrevious", "recordPrevious$runtime_release", "recordPreviousList", "recordPreviousList$runtime_release", "recordPreviousPinnedSnapshot", "recordPreviousPinnedSnapshot$runtime_release", "recordPreviousPinnedSnapshots", VElementKey.HANDLES, "recordPreviousPinnedSnapshots$runtime_release", "releasePinnedSnapshotsForCloseLocked", "releasePinnedSnapshotsForCloseLocked$runtime_release", "releasePreviouslyPinnedSnapshotsLocked", "takeNestedMutableSnapshot", "takeNestedSnapshot", "validateNotApplied", "validateNotAppliedOrPinned", "Companion", "runtime_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSnapshot.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Snapshot.kt\nandroidx/compose/runtime/snapshots/MutableSnapshot\n+ 2 Snapshot.kt\nandroidx/compose/runtime/snapshots/SnapshotKt\n+ 3 ActualJvm.jvm.kt\nandroidx/compose/runtime/ActualJvm_jvmKt\n+ 4 ListUtils.kt\nandroidx/compose/runtime/snapshots/ListUtilsKt\n+ 5 ScatterSet.kt\nandroidx/collection/ScatterSet\n+ 6 ScatterMap.kt\nandroidx/collection/ScatterMapKt\n+ 7 Preconditions.kt\nandroidx/compose/runtime/PreconditionsKt\n+ 8 Snapshot.kt\nandroidx/compose/runtime/snapshots/Snapshot\n+ 9 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,2431:1\n1099#1,2:2432\n1105#1,3:2436\n1108#1,6:2441\n1099#1,2:2521\n1105#1,3:2525\n1108#1,6:2530\n1099#1,9:2625\n1108#1,6:2636\n1843#2:2434\n1843#2:2439\n1843#2:2447\n1843#2:2461\n1843#2:2523\n1843#2:2528\n1843#2:2614\n1843#2:2623\n1843#2:2634\n1843#2:2642\n1843#2:2644\n89#3:2435\n89#3:2440\n89#3:2448\n89#3:2462\n89#3:2524\n89#3:2529\n89#3:2615\n89#3:2624\n89#3:2635\n89#3:2643\n89#3:2645\n33#4,6:2449\n33#4,6:2455\n33#4,6:2515\n33#4,4:2610\n38#4:2616\n33#4,6:2617\n228#5,4:2463\n198#5,7:2467\n209#5,3:2475\n212#5,9:2479\n232#5:2488\n228#5,4:2489\n198#5,7:2493\n209#5,3:2501\n212#5,9:2505\n232#5:2514\n228#5,4:2558\n198#5,7:2562\n209#5,3:2570\n212#5,9:2574\n232#5:2583\n228#5,4:2584\n198#5,7:2588\n209#5,3:2596\n212#5,9:2600\n232#5:2609\n1956#6:2474\n1820#6:2478\n1956#6:2500\n1820#6:2504\n1956#6:2569\n1820#6:2573\n1956#6:2595\n1820#6:2599\n33#7,7:2536\n50#7,7:2543\n50#7,7:2551\n201#8:2550\n1#9:2646\n*S KotlinDebug\n*F\n+ 1 Snapshot.kt\nandroidx/compose/runtime/snapshots/MutableSnapshot\n*L\n785#1:2432,2\n785#1:2436,3\n785#1:2441,6\n920#1:2521,2\n920#1:2525,3\n920#1:2530,6\n1116#1:2625,9\n1116#1:2636,6\n786#1:2434\n785#1:2439\n837#1:2447\n893#1:2461\n921#1:2523\n920#1:2528\n1082#1:2614\n1107#1:2623\n1116#1:2634\n1119#1:2642\n1143#1:2644\n786#1:2435\n785#1:2440\n837#1:2448\n893#1:2462\n921#1:2524\n920#1:2529\n1082#1:2615\n1107#1:2624\n1116#1:2635\n1119#1:2643\n1143#1:2645\n877#1:2449,6\n885#1:2455,6\n898#1:2515,6\n1079#1:2610,4\n1079#1:2616\n1090#1:2617,6\n896#1:2463,4\n896#1:2467,7\n896#1:2475,3\n896#1:2479,9\n896#1:2488\n897#1:2489,4\n897#1:2493,7\n897#1:2501,3\n897#1:2505,9\n897#1:2514\n985#1:2558,4\n985#1:2562,7\n985#1:2570,3\n985#1:2574,9\n985#1:2583\n1020#1:2584,4\n1020#1:2588,7\n1020#1:2596,3\n1020#1:2600,9\n1020#1:2609\n896#1:2474\n896#1:2478\n897#1:2500\n897#1:2504\n985#1:2569\n985#1:2573\n1020#1:2595\n1020#1:2599\n937#1:2536,7\n961#1:2543,7\n967#1:2551,7\n967#1:2550\n*E\n"})
public class MutableSnapshot extends Snapshot {
    private boolean applied;

    @Nullable
    private List<? extends StateObject> merged;

    @Nullable
    private MutableScatterSet<StateObject> modified;

    @NotNull
    private SnapshotIdSet previousIds;

    @NotNull
    private int[] previousPinnedSnapshots;

    @Nullable
    private final Function1<Object, Unit> readObserver;
    private int snapshots;
    private int writeCount;

    @Nullable
    private final Function1<Object, Unit> writeObserver;

    @NotNull
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    @NotNull
    private static final int[] EmptyIntArray = new int[0];

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, m13886d2 = {"Landroidx/compose/runtime/snapshots/MutableSnapshot$Companion;", "", "()V", "EmptyIntArray", "", "runtime_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public MutableSnapshot(int i, @NotNull SnapshotIdSet snapshotIdSet, @Nullable Function1<Object, Unit> function1, @Nullable Function1<Object, Unit> function12) {
        super(i, snapshotIdSet, null);
        this.readObserver = function1;
        this.writeObserver = function12;
        this.previousIds = SnapshotIdSet.INSTANCE.getEMPTY();
        this.previousPinnedSnapshots = EmptyIntArray;
        this.snapshots = 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void abandon() {
        MutableScatterSet<StateObject> modified$runtime_release = getModified$runtime_release();
        if (modified$runtime_release != null) {
            validateNotApplied();
            setModified(null);
            int id = getId();
            Object[] objArr = modified$runtime_release.elements;
            long[] jArr = modified$runtime_release.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i = 0;
                while (true) {
                    long j = jArr[i];
                    if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i2 = 8 - ((~(i - length)) >>> 31);
                        for (int i4 = 0; i4 < i2; i4++) {
                            if ((255 & j) < 128) {
                                for (StateRecord firstStateRecord = ((StateObject) objArr[(i << 3) + i4]).getFirstStateRecord(); firstStateRecord != null; firstStateRecord = firstStateRecord.getNext()) {
                                    if (firstStateRecord.getSnapshotId() == id || CollectionsKt.contains(this.previousIds, Integer.valueOf(firstStateRecord.getSnapshotId()))) {
                                        firstStateRecord.setSnapshotId$runtime_release(0);
                                    }
                                }
                            }
                            j >>= 8;
                        }
                        if (i2 != 8) {
                            break;
                        } else if (i == length) {
                            break;
                        } else {
                            i++;
                        }
                    }
                }
            }
        }
        closeAndReleasePinning$runtime_release();
    }

    private final void releasePreviouslyPinnedSnapshotsLocked() {
        int length = this.previousPinnedSnapshots.length;
        for (int i = 0; i < length; i++) {
            SnapshotKt.releasePinningLocked(this.previousPinnedSnapshots[i]);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MutableSnapshot takeNestedMutableSnapshot$default(MutableSnapshot mutableSnapshot, Function1 function1, Function1 function12, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: takeNestedMutableSnapshot");
        }
        if ((i & 1) != 0) {
            function1 = null;
        }
        if ((i & 2) != 0) {
            function12 = null;
        }
        return mutableSnapshot.takeNestedMutableSnapshot(function1, function12);
    }

    private final void validateNotApplied() {
        if (this.applied) {
            PreconditionsKt.throwIllegalStateException("Unsupported operation on a snapshot that has been applied");
        }
    }

    private final void validateNotAppliedOrPinned() {
        if (!this.applied || ((Snapshot) this).pinningTrackingHandle >= 0) {
            return;
        }
        PreconditionsKt.throwIllegalStateException("Unsupported operation on a disposed or applied snapshot");
    }

    public final <T> T advance$runtime_release(@NotNull Function0<? extends T> block) {
        recordPrevious$runtime_release(getId());
        T tInvoke = block.invoke();
        if (getApplied() || getDisposed()) {
            return tInvoke;
        }
        int id = getId();
        synchronized (SnapshotKt.getLock()) {
            try {
                int i = SnapshotKt.nextSnapshotId;
                SnapshotKt.nextSnapshotId = i + 1;
                setId$runtime_release(i);
                SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(getId());
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        InlineMarker.finallyEnd(1);
        setInvalid$runtime_release(SnapshotKt.addRange(getInvalid(), id + 1, getId()));
        return tInvoke;
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0186  */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SnapshotApplyResult apply() {
        MutableScatterSet<StateObject> modified$runtime_release;
        long j;
        long j2;
        MutableScatterSet<StateObject> modified$runtime_release2 = getModified$runtime_release();
        Map<StateRecord, ? extends StateRecord> mapOptimisticMerges = modified$runtime_release2 != null ? SnapshotKt.optimisticMerges((MutableSnapshot) SnapshotKt.currentGlobalSnapshot.get(), this, SnapshotKt.openSnapshots.clear(((GlobalSnapshot) SnapshotKt.currentGlobalSnapshot.get()).getId())) : null;
        List listEmptyList = CollectionsKt.emptyList();
        synchronized (SnapshotKt.getLock()) {
            try {
                SnapshotKt.validateOpen(this);
                if (modified$runtime_release2 == null || modified$runtime_release2.get_size() == 0) {
                    closeLocked$runtime_release();
                    GlobalSnapshot globalSnapshot = (GlobalSnapshot) SnapshotKt.currentGlobalSnapshot.get();
                    SnapshotKt.takeNewGlobalSnapshot(globalSnapshot, SnapshotKt.emptyLambda);
                    modified$runtime_release = globalSnapshot.getModified$runtime_release();
                    if (modified$runtime_release == null || !modified$runtime_release.isNotEmpty()) {
                        modified$runtime_release = null;
                    } else {
                        listEmptyList = SnapshotKt.applyObservers;
                    }
                } else {
                    GlobalSnapshot globalSnapshot2 = (GlobalSnapshot) SnapshotKt.currentGlobalSnapshot.get();
                    SnapshotApplyResult snapshotApplyResultInnerApplyLocked$runtime_release = innerApplyLocked$runtime_release(SnapshotKt.nextSnapshotId, mapOptimisticMerges, SnapshotKt.openSnapshots.clear(globalSnapshot2.getId()));
                    if (!Intrinsics.areEqual(snapshotApplyResultInnerApplyLocked$runtime_release, SnapshotApplyResult.Success.INSTANCE)) {
                        return snapshotApplyResultInnerApplyLocked$runtime_release;
                    }
                    closeLocked$runtime_release();
                    SnapshotKt.takeNewGlobalSnapshot(globalSnapshot2, SnapshotKt.emptyLambda);
                    modified$runtime_release = globalSnapshot2.getModified$runtime_release();
                    setModified(null);
                    globalSnapshot2.setModified(null);
                    listEmptyList = SnapshotKt.applyObservers;
                }
                Unit unit = Unit.INSTANCE;
                this.applied = true;
                if (modified$runtime_release != null) {
                    Set setWrapIntoSet = ScatterSetWrapperKt.wrapIntoSet(modified$runtime_release);
                    if (!setWrapIntoSet.isEmpty()) {
                        int size = listEmptyList.size();
                        for (int i = 0; i < size; i++) {
                            ((Function2) listEmptyList.get(i)).invoke(setWrapIntoSet, this);
                        }
                    }
                }
                if (modified$runtime_release2 != null && modified$runtime_release2.isNotEmpty()) {
                    Set setWrapIntoSet2 = ScatterSetWrapperKt.wrapIntoSet(modified$runtime_release2);
                    int size2 = listEmptyList.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        ((Function2) listEmptyList.get(i2)).invoke(setWrapIntoSet2, this);
                    }
                }
                synchronized (SnapshotKt.getLock()) {
                    try {
                        releasePinnedSnapshotsForCloseLocked$runtime_release();
                        SnapshotKt.checkAndOverwriteUnusedRecordsLocked();
                        if (modified$runtime_release != null) {
                            Object[] objArr = modified$runtime_release.elements;
                            long[] jArr = modified$runtime_release.metadata;
                            int length = jArr.length - 2;
                            if (length >= 0) {
                                int i4 = 0;
                                j = 128;
                                while (true) {
                                    long j3 = jArr[i4];
                                    j2 = 255;
                                    if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                                        int i5 = 8 - ((~(i4 - length)) >>> 31);
                                        for (int i6 = 0; i6 < i5; i6++) {
                                            if ((j3 & 255) < 128) {
                                                SnapshotKt.processForUnusedRecordsLocked((StateObject) objArr[(i4 << 3) + i6]);
                                            }
                                            j3 >>= 8;
                                        }
                                        if (i5 != 8) {
                                            break;
                                        }
                                        if (i4 == length) {
                                            break;
                                        }
                                        i4++;
                                    }
                                }
                            } else {
                                j = 128;
                                j2 = 255;
                            }
                        }
                        if (modified$runtime_release2 != null) {
                            Object[] objArr2 = modified$runtime_release2.elements;
                            long[] jArr2 = modified$runtime_release2.metadata;
                            int length2 = jArr2.length - 2;
                            if (length2 >= 0) {
                                int i7 = 0;
                                while (true) {
                                    long j5 = jArr2[i7];
                                    if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                                        int i8 = 8 - ((~(i7 - length2)) >>> 31);
                                        for (int i9 = 0; i9 < i8; i9++) {
                                            if ((j5 & j2) < j) {
                                                SnapshotKt.processForUnusedRecordsLocked((StateObject) objArr2[(i7 << 3) + i9]);
                                            }
                                            j5 >>= 8;
                                        }
                                        if (i8 != 8) {
                                            break;
                                        }
                                        if (i7 == length2) {
                                            break;
                                        }
                                        i7++;
                                    }
                                }
                            }
                        }
                        List<? extends StateObject> list = this.merged;
                        if (list != null) {
                            int size3 = list.size();
                            for (int i10 = 0; i10 < size3; i10++) {
                                SnapshotKt.processForUnusedRecordsLocked(list.get(i10));
                            }
                        }
                        this.merged = null;
                        Unit unit2 = Unit.INSTANCE;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return SnapshotApplyResult.Success.INSTANCE;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void closeLocked$runtime_release() {
        SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.clear(getId()).andNot(this.previousIds);
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void dispose() {
        if (getDisposed()) {
            return;
        }
        super.dispose();
        mo18113nestedDeactivated$runtime_release(this);
    }

    /* JADX INFO: renamed from: getApplied$runtime_release, reason: from getter */
    public final boolean getApplied() {
        return this.applied;
    }

    @Nullable
    public final List<StateObject> getMerged$runtime_release() {
        return this.merged;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    @Nullable
    public MutableScatterSet<StateObject> getModified$runtime_release() {
        return this.modified;
    }

    @NotNull
    /* JADX INFO: renamed from: getPreviousIds$runtime_release, reason: from getter */
    public final SnapshotIdSet getPreviousIds() {
        return this.previousIds;
    }

    @NotNull
    /* JADX INFO: renamed from: getPreviousPinnedSnapshots$runtime_release, reason: from getter */
    public final int[] getPreviousPinnedSnapshots() {
        return this.previousPinnedSnapshots;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    @Nullable
    /* JADX INFO: renamed from: getReadObserver$runtime_release */
    public Function1<Object, Unit> getReadObserver() {
        return this.readObserver;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public boolean getReadOnly() {
        return false;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* JADX INFO: renamed from: getWriteCount$runtime_release, reason: from getter */
    public int getWriteCount() {
        return this.writeCount;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    @Nullable
    public Function1<Object, Unit> getWriteObserver$runtime_release() {
        return this.writeObserver;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public boolean hasPendingChanges() {
        MutableScatterSet<StateObject> modified$runtime_release = getModified$runtime_release();
        return modified$runtime_release != null && modified$runtime_release.isNotEmpty();
    }

    @NotNull
    public final SnapshotApplyResult innerApplyLocked$runtime_release(int snapshotId, @Nullable Map<StateRecord, ? extends StateRecord> optimisticMerges, @NotNull SnapshotIdSet invalidSnapshots) {
        SnapshotIdSet snapshotIdSet;
        Object[] objArr;
        long[] jArr;
        SnapshotIdSet snapshotIdSet2;
        Object[] objArr2;
        long[] jArr2;
        int i;
        StateRecord stateRecord;
        StateRecord stateRecordMergeRecords;
        SnapshotIdSet snapshotIdSetM1337or = getInvalid().set(getId()).m1337or(this.previousIds);
        MutableScatterSet<StateObject> modified$runtime_release = getModified$runtime_release();
        Intrinsics.checkNotNull(modified$runtime_release);
        Object[] objArr3 = modified$runtime_release.elements;
        long[] jArr3 = modified$runtime_release.metadata;
        int length = jArr3.length - 2;
        ArrayList arrayList = null;
        List<? extends StateObject> listPlus = null;
        if (length >= 0) {
            int i2 = 0;
            while (true) {
                long j = jArr3[i2];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i4 = 8;
                    int i5 = 8 - ((~(i2 - length)) >>> 31);
                    int i6 = 0;
                    while (i6 < i5) {
                        if ((j & 255) < 128) {
                            StateObject stateObject = (StateObject) objArr3[(i2 << 3) + i6];
                            i = i4;
                            StateRecord firstStateRecord = stateObject.getFirstStateRecord();
                            objArr2 = objArr3;
                            jArr2 = jArr3;
                            ArrayList arrayList2 = arrayList;
                            StateRecord stateRecord2 = SnapshotKt.readable(firstStateRecord, snapshotId, invalidSnapshots);
                            if (stateRecord2 == null || (stateRecord = SnapshotKt.readable(firstStateRecord, getId(), snapshotIdSetM1337or)) == null) {
                                snapshotIdSet2 = snapshotIdSetM1337or;
                            } else {
                                snapshotIdSet2 = snapshotIdSetM1337or;
                                if (stateRecord.getSnapshotId() != 1 && !Intrinsics.areEqual(stateRecord2, stateRecord)) {
                                    StateRecord stateRecord3 = SnapshotKt.readable(firstStateRecord, getId(), getInvalid());
                                    if (stateRecord3 == null) {
                                        SnapshotKt.readError();
                                        throw new KotlinNothingValueException();
                                    }
                                    if (optimisticMerges == null || (stateRecordMergeRecords = optimisticMerges.get(stateRecord2)) == null) {
                                        stateRecordMergeRecords = stateObject.mergeRecords(stateRecord, stateRecord2, stateRecord3);
                                    }
                                    if (stateRecordMergeRecords == null) {
                                        return new SnapshotApplyResult.Failure(this);
                                    }
                                    if (!Intrinsics.areEqual(stateRecordMergeRecords, stateRecord3)) {
                                        if (Intrinsics.areEqual(stateRecordMergeRecords, stateRecord2)) {
                                            ArrayList arrayList3 = arrayList2 == null ? new ArrayList() : arrayList2;
                                            arrayList3.add(TuplesKt.m13893to(stateObject, stateRecord2.create()));
                                            if (listPlus == null) {
                                                listPlus = new ArrayList<>();
                                            }
                                            listPlus.add(stateObject);
                                            arrayList = arrayList3;
                                        } else {
                                            arrayList = arrayList2 == null ? new ArrayList() : arrayList2;
                                            arrayList.add(!Intrinsics.areEqual(stateRecordMergeRecords, stateRecord) ? TuplesKt.m13893to(stateObject, stateRecordMergeRecords) : TuplesKt.m13893to(stateObject, stateRecord.create()));
                                        }
                                    }
                                }
                            }
                            arrayList = arrayList2;
                        } else {
                            snapshotIdSet2 = snapshotIdSetM1337or;
                            objArr2 = objArr3;
                            jArr2 = jArr3;
                            i = i4;
                        }
                        j >>= i;
                        i6++;
                        i4 = i;
                        objArr3 = objArr2;
                        jArr3 = jArr2;
                        snapshotIdSetM1337or = snapshotIdSet2;
                    }
                    snapshotIdSet = snapshotIdSetM1337or;
                    objArr = objArr3;
                    jArr = jArr3;
                    if (i5 != i4) {
                        break;
                    }
                } else {
                    snapshotIdSet = snapshotIdSetM1337or;
                    objArr = objArr3;
                    jArr = jArr3;
                }
                if (i2 == length) {
                    break;
                }
                i2++;
                objArr3 = objArr;
                jArr3 = jArr;
                snapshotIdSetM1337or = snapshotIdSet;
            }
        }
        if (arrayList != null) {
            advance$runtime_release();
            int size = arrayList.size();
            for (int i7 = 0; i7 < size; i7++) {
                Pair pair = (Pair) arrayList.get(i7);
                StateObject stateObject2 = (StateObject) pair.component1();
                StateRecord stateRecord4 = (StateRecord) pair.component2();
                stateRecord4.setSnapshotId$runtime_release(getId());
                synchronized (SnapshotKt.getLock()) {
                    stateRecord4.setNext$runtime_release(stateObject2.getFirstStateRecord());
                    stateObject2.prependStateRecord(stateRecord4);
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
        if (listPlus != null) {
            int size2 = listPlus.size();
            for (int i8 = 0; i8 < size2; i8++) {
                modified$runtime_release.remove(listPlus.get(i8));
            }
            List<? extends StateObject> list = this.merged;
            if (list != null) {
                listPlus = CollectionsKt.plus((Collection) list, (Iterable) listPlus);
            }
            this.merged = listPlus;
        }
        return SnapshotApplyResult.Success.INSTANCE;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* JADX INFO: renamed from: nestedActivated$runtime_release */
    public void mo18112nestedActivated$runtime_release(@NotNull Snapshot snapshot) {
        this.snapshots++;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* JADX INFO: renamed from: nestedDeactivated$runtime_release */
    public void mo18113nestedDeactivated$runtime_release(@NotNull Snapshot snapshot) {
        if (!(this.snapshots > 0)) {
            PreconditionsKt.throwIllegalArgumentException("no pending nested snapshots");
        }
        int i = this.snapshots - 1;
        this.snapshots = i;
        if (i != 0 || this.applied) {
            return;
        }
        abandon();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void notifyObjectsInitialized$runtime_release() {
        if (this.applied || getDisposed()) {
            return;
        }
        advance$runtime_release();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* JADX INFO: renamed from: recordModified$runtime_release */
    public void mo18114recordModified$runtime_release(@NotNull StateObject state) {
        MutableScatterSet<StateObject> modified$runtime_release = getModified$runtime_release();
        if (modified$runtime_release == null) {
            modified$runtime_release = ScatterSetKt.mutableScatterSetOf();
            setModified(modified$runtime_release);
        }
        modified$runtime_release.add(state);
    }

    public final void recordPrevious$runtime_release(int id) {
        synchronized (SnapshotKt.getLock()) {
            this.previousIds = this.previousIds.set(id);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void recordPreviousList$runtime_release(@NotNull SnapshotIdSet snapshots) {
        synchronized (SnapshotKt.getLock()) {
            this.previousIds = this.previousIds.m1337or(snapshots);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void recordPreviousPinnedSnapshot$runtime_release(int id) {
        if (id >= 0) {
            this.previousPinnedSnapshots = ArraysKt.plus(this.previousPinnedSnapshots, id);
        }
    }

    public final void recordPreviousPinnedSnapshots$runtime_release(@NotNull int[] handles) {
        if (handles.length == 0) {
            return;
        }
        int[] iArr = this.previousPinnedSnapshots;
        if (iArr.length != 0) {
            handles = ArraysKt.plus(iArr, handles);
        }
        this.previousPinnedSnapshots = handles;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void releasePinnedSnapshotsForCloseLocked$runtime_release() {
        releasePreviouslyPinnedSnapshotsLocked();
        super.releasePinnedSnapshotsForCloseLocked$runtime_release();
    }

    public final void setApplied$runtime_release(boolean z) {
        this.applied = z;
    }

    public final void setMerged$runtime_release(@Nullable List<? extends StateObject> list) {
        this.merged = list;
    }

    public void setModified(@Nullable MutableScatterSet<StateObject> mutableScatterSet) {
        this.modified = mutableScatterSet;
    }

    public final void setPreviousIds$runtime_release(@NotNull SnapshotIdSet snapshotIdSet) {
        this.previousIds = snapshotIdSet;
    }

    public final void setPreviousPinnedSnapshots$runtime_release(@NotNull int[] iArr) {
        this.previousPinnedSnapshots = iArr;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void setWriteCount$runtime_release(int i) {
        this.writeCount = i;
    }

    @NotNull
    public MutableSnapshot takeNestedMutableSnapshot(@Nullable Function1<Object, Unit> readObserver, @Nullable Function1<Object, Unit> writeObserver) throws Throwable {
        int i;
        SnapshotIdSet invalid;
        validateNotDisposed$runtime_release();
        validateNotAppliedOrPinned();
        recordPrevious$runtime_release(getId());
        synchronized (SnapshotKt.getLock()) {
            try {
                i = SnapshotKt.nextSnapshotId;
                SnapshotKt.nextSnapshotId = i + 1;
                SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(i);
                invalid = getInvalid();
                setInvalid$runtime_release(invalid.set(i));
            } catch (Throwable th) {
                th = th;
            }
            try {
                NestedMutableSnapshot nestedMutableSnapshot = new NestedMutableSnapshot(i, SnapshotKt.addRange(invalid, getId() + 1, i), SnapshotKt.mergedReadObserver$default(readObserver, getReadObserver(), false, 4, null), SnapshotKt.mergedWriteObserver(writeObserver, getWriteObserver$runtime_release()), this);
                if (getApplied() || getDisposed()) {
                    return nestedMutableSnapshot;
                }
                int id = getId();
                synchronized (SnapshotKt.getLock()) {
                    int i2 = SnapshotKt.nextSnapshotId;
                    SnapshotKt.nextSnapshotId = i2 + 1;
                    setId$runtime_release(i2);
                    SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(getId());
                    Unit unit = Unit.INSTANCE;
                }
                setInvalid$runtime_release(SnapshotKt.addRange(getInvalid(), id + 1, getId()));
                return nestedMutableSnapshot;
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    @NotNull
    public Snapshot takeNestedSnapshot(@Nullable Function1<Object, Unit> readObserver) {
        NestedReadonlySnapshot nestedReadonlySnapshot;
        validateNotDisposed$runtime_release();
        validateNotAppliedOrPinned();
        int id = getId();
        recordPrevious$runtime_release(getId());
        synchronized (SnapshotKt.getLock()) {
            int i = SnapshotKt.nextSnapshotId;
            SnapshotKt.nextSnapshotId = i + 1;
            SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(i);
            nestedReadonlySnapshot = new NestedReadonlySnapshot(i, SnapshotKt.addRange(getInvalid(), id + 1, i), SnapshotKt.mergedReadObserver$default(readObserver, getReadObserver(), false, 4, null), this);
        }
        if (getApplied() || getDisposed()) {
            return nestedReadonlySnapshot;
        }
        int id2 = getId();
        synchronized (SnapshotKt.getLock()) {
            int i2 = SnapshotKt.nextSnapshotId;
            SnapshotKt.nextSnapshotId = i2 + 1;
            setId$runtime_release(i2);
            SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(getId());
            Unit unit = Unit.INSTANCE;
        }
        setInvalid$runtime_release(SnapshotKt.addRange(getInvalid(), id2 + 1, getId()));
        return nestedReadonlySnapshot;
    }

    public final void advance$runtime_release() {
        recordPrevious$runtime_release(getId());
        Unit unit = Unit.INSTANCE;
        if (getApplied() || getDisposed()) {
            return;
        }
        int id = getId();
        synchronized (SnapshotKt.getLock()) {
            int i = SnapshotKt.nextSnapshotId;
            SnapshotKt.nextSnapshotId = i + 1;
            setId$runtime_release(i);
            SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(getId());
        }
        setInvalid$runtime_release(SnapshotKt.addRange(getInvalid(), id + 1, getId()));
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    @NotNull
    public Snapshot getRoot() {
        return this;
    }
}
