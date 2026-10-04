package androidx.compose.runtime.snapshots;

import androidx.collection.MutableScatterSet;
import androidx.compose.runtime.ActualJvm_jvmKt;
import androidx.compose.runtime.ExperimentalComposeApi;
import androidx.compose.runtime.InternalComposeApi;
import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.internal.StabilityInferred;
import java.util.Collection;
import java.util.Set;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.poi.sun.awt.AppContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 T2\u00020\u0001:\u0001TB\u0017\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\r\u00101\u001a\u00020\"H\u0000¢\u0006\u0002\b2J\r\u00103\u001a\u00020\"H\u0010¢\u0006\u0002\b4J\b\u00105\u001a\u00020\"H\u0016J\"\u00106\u001a\u0002H7\"\u0004\b\u0000\u001072\f\u00108\u001a\b\u0012\u0004\u0012\u0002H709H\u0086\b¢\u0006\u0002\u0010:J\b\u0010;\u001a\u00020\bH&J\n\u0010<\u001a\u0004\u0018\u00010\u0000H\u0011J\u0015\u0010=\u001a\u00020\"2\u0006\u0010>\u001a\u00020\u0000H ¢\u0006\u0002\b?J\u0015\u0010@\u001a\u00020\"2\u0006\u0010>\u001a\u00020\u0000H ¢\u0006\u0002\bAJ\r\u0010B\u001a\u00020\"H ¢\u0006\u0002\bCJ\u0015\u0010D\u001a\u00020\"2\u0006\u0010E\u001a\u00020\u001aH ¢\u0006\u0002\bFJ\r\u0010G\u001a\u00020\"H\u0000¢\u0006\u0002\bHJ\r\u0010I\u001a\u00020\"H\u0010¢\u0006\u0002\bJJ\u0012\u0010K\u001a\u00020\"2\b\u0010>\u001a\u0004\u0018\u00010\u0000H\u0011J \u0010L\u001a\u00020\u00002\u0016\b\u0002\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\"\u0018\u00010!H&J\r\u0010M\u001a\u00020\u0003H\u0000¢\u0006\u0002\bNJ\n\u0010O\u001a\u0004\u0018\u00010\u0000H\u0007J\u0012\u0010P\u001a\u00020\"2\b\u0010Q\u001a\u0004\u0018\u00010\u0000H\u0007J\r\u0010R\u001a\u00020\"H\u0000¢\u0006\u0002\bSR\u001a\u0010\u0007\u001a\u00020\bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003@PX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0005X\u0090\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0015\u0010\u0016\u001a\u00020\b8À\u0002X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\nR\u001a\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019X \u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u0003X\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u001e\u0010\u001fR(\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\"\u0018\u00010!8 X¡\u0004¢\u0006\f\u0012\u0004\b#\u0010\u001f\u001a\u0004\b$\u0010%R\u0012\u0010&\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\nR\u0012\u0010(\u001a\u00020\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R$\u0010,\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u00038P@PX\u0090\u000e¢\u0006\f\u001a\u0004\b-\u0010\u000f\"\u0004\b.\u0010\u0011R \u0010/\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\"\u0018\u00010!X \u0004¢\u0006\u0006\u001a\u0004\b0\u0010%\u0082\u0001\u0004UVWX¨\u0006Y"}, m13886d2 = {"Landroidx/compose/runtime/snapshots/Snapshot;", "", "id", "", "invalid", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "(ILandroidx/compose/runtime/snapshots/SnapshotIdSet;)V", AppContext.DISPOSED_PROPERTY_NAME, "", "getDisposed$runtime_release", "()Z", "setDisposed$runtime_release", "(Z)V", "<set-?>", "getId", "()I", "setId$runtime_release", "(I)V", "getInvalid$runtime_release", "()Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "setInvalid$runtime_release", "(Landroidx/compose/runtime/snapshots/SnapshotIdSet;)V", "isPinned", "isPinned$runtime_release", "modified", "Landroidx/collection/MutableScatterSet;", "Landroidx/compose/runtime/snapshots/StateObject;", "getModified$runtime_release", "()Landroidx/collection/MutableScatterSet;", "pinningTrackingHandle", "getPinningTrackingHandle$annotations", "()V", "readObserver", "Lkotlin/Function1;", "", "getReadObserver$annotations", "getReadObserver", "()Lkotlin/jvm/functions/Function1;", "readOnly", "getReadOnly", "root", "getRoot", "()Landroidx/compose/runtime/snapshots/Snapshot;", "value", "writeCount", "getWriteCount$runtime_release", "setWriteCount$runtime_release", "writeObserver", "getWriteObserver$runtime_release", "closeAndReleasePinning", "closeAndReleasePinning$runtime_release", "closeLocked", "closeLocked$runtime_release", "dispose", "enter", "T", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "hasPendingChanges", "makeCurrent", "nestedActivated", "snapshot", "nestedActivated$runtime_release", "nestedDeactivated", "nestedDeactivated$runtime_release", "notifyObjectsInitialized", "notifyObjectsInitialized$runtime_release", "recordModified", "state", "recordModified$runtime_release", "releasePinnedSnapshotLocked", "releasePinnedSnapshotLocked$runtime_release", "releasePinnedSnapshotsForCloseLocked", "releasePinnedSnapshotsForCloseLocked$runtime_release", "restoreCurrent", "takeNestedSnapshot", "takeoverPinnedSnapshot", "takeoverPinnedSnapshot$runtime_release", "unsafeEnter", "unsafeLeave", "oldSnapshot", "validateNotDisposed", "validateNotDisposed$runtime_release", "Companion", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "Landroidx/compose/runtime/snapshots/NestedReadonlySnapshot;", "Landroidx/compose/runtime/snapshots/ReadonlySnapshot;", "Landroidx/compose/runtime/snapshots/TransparentObserverSnapshot;", "runtime_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSnapshot.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Snapshot.kt\nandroidx/compose/runtime/snapshots/Snapshot\n+ 2 Snapshot.kt\nandroidx/compose/runtime/snapshots/SnapshotKt\n+ 3 ActualJvm.jvm.kt\nandroidx/compose/runtime/ActualJvm_jvmKt\n+ 4 Preconditions.kt\nandroidx/compose/runtime/PreconditionsKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,2431:1\n1843#2:2432\n1843#2:2441\n89#3:2433\n89#3:2442\n50#4,7:2434\n33#4,7:2443\n1#5:2450\n*S KotlinDebug\n*F\n+ 1 Snapshot.kt\nandroidx/compose/runtime/snapshots/Snapshot\n*L\n100#1:2432\n251#1:2441\n100#1:2433\n251#1:2442\n186#1:2434,7\n280#1:2443,7\n*E\n"})
public abstract class Snapshot {
    public static final int PreexistingSnapshotId = 1;
    private boolean disposed;
    private int id;

    @NotNull
    private SnapshotIdSet invalid;
    private int pinningTrackingHandle;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0017\u001a\u00020\u0007H\u0001J\"\u0010\u0018\u001a\u0002H\u0019\"\u0004\b\u0000\u0010\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00190\u001bH\u0086\b¢\u0006\u0002\u0010\u001cJ\u0012\u0010\u001d\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u0007H\u0001J\u0006\u0010\u001f\u001a\u00020 JO\u0010!\u001a\u0002H\u0019\"\u0004\b\u0000\u0010\u00192\u0016\b\u0002\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020 \u0018\u00010#2\u0016\b\u0002\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020 \u0018\u00010#2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00190\u001b¢\u0006\u0002\u0010%J\b\u0010&\u001a\u00020\u0004H\u0007J&\u0010'\u001a\u00020(2\u001e\u0010)\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010+\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020 0*J\u001a\u0010,\u001a\u00020(2\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020 0#J\n\u0010-\u001a\u0004\u0018\u00010\u0007H\u0001J\u0012\u0010.\u001a\u00020 2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0007H\u0001J0\u0010/\u001a\u00020 2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00072\u0006\u00100\u001a\u00020\u00072\u0014\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020 \u0018\u00010#H\u0001J\u0006\u00101\u001a\u00020 J6\u00102\u001a\u0002032\u0016\b\u0002\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020 \u0018\u00010#2\u0016\b\u0002\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020 \u0018\u00010#J\u001e\u00104\u001a\u00020\u00072\u0016\b\u0002\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020 \u0018\u00010#J\"\u00105\u001a\u0002H6\"\u0004\b\u0000\u001062\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H60\u001bH\u0086\b¢\u0006\u0002\u0010\u001cJ4\u00107\u001a\u0002H\u0019\"\u0004\b\u0000\u0010\u00192\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u0002H\u00190\u001b¢\u0006\u0002\b8H\u0086\b\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u001cR\u0014\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u00078@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0002\u001a\u0004\b\f\u0010\tR\u0011\u0010\r\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000fR\u0019\u0010\u0011\u001a\u00020\u000e*\u00020\u00128Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0011\u001a\u00020\u000e*\u00020\u00158Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0016¨\u00069"}, m13886d2 = {"Landroidx/compose/runtime/snapshots/Snapshot$Companion;", "", "()V", "PreexistingSnapshotId", "", "getPreexistingSnapshotId$annotations", "current", "Landroidx/compose/runtime/snapshots/Snapshot;", "getCurrent", "()Landroidx/compose/runtime/snapshots/Snapshot;", "currentThreadSnapshot", "getCurrentThreadSnapshot$annotations", "getCurrentThreadSnapshot", "isApplyObserverNotificationPending", "", "()Z", "isInSnapshot", "canBeReused", "Landroidx/compose/runtime/snapshots/TransparentObserverMutableSnapshot;", "getCanBeReused", "(Landroidx/compose/runtime/snapshots/TransparentObserverMutableSnapshot;)Z", "Landroidx/compose/runtime/snapshots/TransparentObserverSnapshot;", "(Landroidx/compose/runtime/snapshots/TransparentObserverSnapshot;)Z", "createNonObservableSnapshot", "global", "T", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "makeCurrentNonObservable", "previous", "notifyObjectsInitialized", "", "observe", "readObserver", "Lkotlin/Function1;", "writeObserver", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "openSnapshotCount", "registerApplyObserver", "Landroidx/compose/runtime/snapshots/ObserverHandle;", "observer", "Lkotlin/Function2;", "", "registerGlobalWriteObserver", "removeCurrent", "restoreCurrent", "restoreNonObservable", "nonObservable", "sendApplyNotifications", "takeMutableSnapshot", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "takeSnapshot", "withMutableSnapshot", "R", "withoutReadObservation", "Landroidx/compose/runtime/DisallowComposableCalls;", "runtime_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nSnapshot.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Snapshot.kt\nandroidx/compose/runtime/snapshots/Snapshot$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Snapshot.kt\nandroidx/compose/runtime/snapshots/Snapshot\n+ 4 Snapshot.kt\nandroidx/compose/runtime/snapshots/SnapshotKt\n+ 5 ActualJvm.jvm.kt\nandroidx/compose/runtime/ActualJvm_jvmKt\n*L\n1#1,2431:1\n547#1:2438\n547#1:2444\n550#1:2445\n1#2:2432\n138#3,5:2433\n138#3,5:2439\n1843#4:2446\n1843#4:2448\n1843#4:2450\n1843#4:2452\n1843#4:2454\n89#5:2447\n89#5:2449\n89#5:2451\n89#5:2453\n89#5:2455\n*S KotlinDebug\n*F\n+ 1 Snapshot.kt\nandroidx/compose/runtime/snapshots/Snapshot$Companion\n*L\n493#1:2438\n555#1:2444\n559#1:2445\n462#1:2433,5\n529#1:2439,5\n623#1:2446\n650#1:2448\n688#1:2450\n627#1:2452\n655#1:2454\n623#1:2447\n650#1:2449\n688#1:2451\n627#1:2453\n655#1:2455\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final boolean getCanBeReused(TransparentObserverMutableSnapshot transparentObserverMutableSnapshot) {
            return transparentObserverMutableSnapshot.getThreadId() == ActualJvm_jvmKt.currentThreadId();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Object observe$default(Companion companion, Function1 function1, Function1 function12, Function0 function0, int i, Object obj) {
            if ((i & 1) != 0) {
                function1 = null;
            }
            if ((i & 2) != 0) {
                function12 = null;
            }
            return companion.observe(function1, function12, function0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void registerApplyObserver$lambda$6(Function2 function2) {
            synchronized (SnapshotKt.getLock()) {
                SnapshotKt.applyObservers = CollectionsKt.minus(SnapshotKt.applyObservers, function2);
                Unit unit = Unit.INSTANCE;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void registerGlobalWriteObserver$lambda$9(Function1 function1) {
            synchronized (SnapshotKt.getLock()) {
                SnapshotKt.globalWriteObservers = CollectionsKt.minus(SnapshotKt.globalWriteObservers, function1);
                Unit unit = Unit.INSTANCE;
            }
            SnapshotKt.advanceGlobalSnapshot();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ MutableSnapshot takeMutableSnapshot$default(Companion companion, Function1 function1, Function1 function12, int i, Object obj) {
            if ((i & 1) != 0) {
                function1 = null;
            }
            if ((i & 2) != 0) {
                function12 = null;
            }
            return companion.takeMutableSnapshot(function1, function12);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Snapshot takeSnapshot$default(Companion companion, Function1 function1, int i, Object obj) {
            if ((i & 1) != 0) {
                function1 = null;
            }
            return companion.takeSnapshot(function1);
        }

        @PublishedApi
        @NotNull
        public final Snapshot createNonObservableSnapshot() {
            return SnapshotKt.createTransparentSnapshotWithNoParentReadObserver$default((Snapshot) SnapshotKt.threadSnapshot.get(), null, false, 6, null);
        }

        @NotNull
        public final Snapshot getCurrent() {
            return SnapshotKt.currentSnapshot();
        }

        @Nullable
        public final Snapshot getCurrentThreadSnapshot() {
            return (Snapshot) SnapshotKt.threadSnapshot.get();
        }

        public final <T> T global(@NotNull Function0<? extends T> block) {
            Snapshot snapshotRemoveCurrent = removeCurrent();
            T tInvoke = block.invoke();
            Snapshot.INSTANCE.restoreCurrent(snapshotRemoveCurrent);
            return tInvoke;
        }

        public final boolean isApplyObserverNotificationPending() {
            return SnapshotKt.pendingApplyObserverCount.get() > 0;
        }

        public final boolean isInSnapshot() {
            return SnapshotKt.threadSnapshot.get() != null;
        }

        @PublishedApi
        @NotNull
        public final Snapshot makeCurrentNonObservable(@Nullable Snapshot previous) {
            if (previous instanceof TransparentObserverMutableSnapshot) {
                TransparentObserverMutableSnapshot transparentObserverMutableSnapshot = (TransparentObserverMutableSnapshot) previous;
                if (transparentObserverMutableSnapshot.getThreadId() == ActualJvm_jvmKt.currentThreadId()) {
                    transparentObserverMutableSnapshot.setReadObserver(null);
                    return previous;
                }
            }
            if (previous instanceof TransparentObserverSnapshot) {
                TransparentObserverSnapshot transparentObserverSnapshot = (TransparentObserverSnapshot) previous;
                if (transparentObserverSnapshot.getThreadId$runtime_release() == ActualJvm_jvmKt.currentThreadId()) {
                    transparentObserverSnapshot.setReadObserver(null);
                    return previous;
                }
            }
            Snapshot snapshotCreateTransparentSnapshotWithNoParentReadObserver$default = SnapshotKt.createTransparentSnapshotWithNoParentReadObserver$default(previous, null, false, 6, null);
            snapshotCreateTransparentSnapshotWithNoParentReadObserver$default.makeCurrent();
            return snapshotCreateTransparentSnapshotWithNoParentReadObserver$default;
        }

        public final void notifyObjectsInitialized() {
            SnapshotKt.currentSnapshot().notifyObjectsInitialized$runtime_release();
        }

        public final <T> T observe(@Nullable Function1<Object, Unit> readObserver, @Nullable Function1<Object, Unit> writeObserver, @NotNull Function0<? extends T> block) {
            Snapshot transparentObserverMutableSnapshot;
            if (readObserver == null && writeObserver == null) {
                return block.invoke();
            }
            Snapshot snapshot = (Snapshot) SnapshotKt.threadSnapshot.get();
            if (snapshot instanceof TransparentObserverMutableSnapshot) {
                TransparentObserverMutableSnapshot transparentObserverMutableSnapshot2 = (TransparentObserverMutableSnapshot) snapshot;
                if (transparentObserverMutableSnapshot2.getThreadId() == ActualJvm_jvmKt.currentThreadId()) {
                    Function1<Object, Unit> readObserver$runtime_release = transparentObserverMutableSnapshot2.getReadObserver();
                    Function1<Object, Unit> writeObserver$runtime_release = transparentObserverMutableSnapshot2.getWriteObserver$runtime_release();
                    try {
                        ((TransparentObserverMutableSnapshot) snapshot).setReadObserver(SnapshotKt.mergedReadObserver$default(readObserver, readObserver$runtime_release, false, 4, null));
                        ((TransparentObserverMutableSnapshot) snapshot).setWriteObserver(SnapshotKt.mergedWriteObserver(writeObserver, writeObserver$runtime_release));
                        return block.invoke();
                    } finally {
                        transparentObserverMutableSnapshot2.setReadObserver(readObserver$runtime_release);
                        transparentObserverMutableSnapshot2.setWriteObserver(writeObserver$runtime_release);
                    }
                }
            }
            if (snapshot == null || (snapshot instanceof MutableSnapshot)) {
                transparentObserverMutableSnapshot = new TransparentObserverMutableSnapshot(snapshot instanceof MutableSnapshot ? (MutableSnapshot) snapshot : null, readObserver, writeObserver, true, false);
            } else {
                if (readObserver == null) {
                    return block.invoke();
                }
                transparentObserverMutableSnapshot = snapshot.takeNestedSnapshot(readObserver);
            }
            try {
                Snapshot snapshotMakeCurrent = transparentObserverMutableSnapshot.makeCurrent();
                try {
                    T tInvoke = block.invoke();
                    transparentObserverMutableSnapshot.restoreCurrent(snapshotMakeCurrent);
                    transparentObserverMutableSnapshot.dispose();
                    return tInvoke;
                } catch (Throwable th) {
                    transparentObserverMutableSnapshot.restoreCurrent(snapshotMakeCurrent);
                    throw th;
                }
            } catch (Throwable th2) {
                transparentObserverMutableSnapshot.dispose();
                throw th2;
            }
        }

        @InternalComposeApi
        public final int openSnapshotCount() {
            return CollectionsKt.toList(SnapshotKt.openSnapshots).size();
        }

        @NotNull
        public final ObserverHandle registerApplyObserver(@NotNull Function2<? super Set<? extends Object>, ? super Snapshot, Unit> observer) {
            SnapshotKt.advanceGlobalSnapshot(SnapshotKt.emptyLambda);
            synchronized (SnapshotKt.getLock()) {
                SnapshotKt.applyObservers = CollectionsKt.plus((Collection<? extends Function2<? super Set<? extends Object>, ? super Snapshot, Unit>>) SnapshotKt.applyObservers, observer);
                Unit unit = Unit.INSTANCE;
            }
            return new C2023a(observer, 0);
        }

        @NotNull
        public final ObserverHandle registerGlobalWriteObserver(@NotNull Function1<Object, Unit> observer) {
            synchronized (SnapshotKt.getLock()) {
                SnapshotKt.globalWriteObservers = CollectionsKt.plus((Collection<? extends Function1<Object, Unit>>) SnapshotKt.globalWriteObservers, observer);
                Unit unit = Unit.INSTANCE;
            }
            SnapshotKt.advanceGlobalSnapshot();
            return new C2023a(observer, 1);
        }

        @PublishedApi
        @Nullable
        public final Snapshot removeCurrent() {
            Snapshot snapshot = (Snapshot) SnapshotKt.threadSnapshot.get();
            if (snapshot != null) {
                SnapshotKt.threadSnapshot.set(null);
            }
            return snapshot;
        }

        @PublishedApi
        public final void restoreCurrent(@Nullable Snapshot previous) {
            if (previous != null) {
                SnapshotKt.threadSnapshot.set(previous);
            }
        }

        @PublishedApi
        public final void restoreNonObservable(@Nullable Snapshot previous, @NotNull Snapshot nonObservable, @Nullable Function1<Object, Unit> observer) {
            if (previous != nonObservable) {
                nonObservable.restoreCurrent(previous);
                nonObservable.dispose();
            } else if (previous instanceof TransparentObserverMutableSnapshot) {
                ((TransparentObserverMutableSnapshot) previous).setReadObserver(observer);
            } else if (previous instanceof TransparentObserverSnapshot) {
                ((TransparentObserverSnapshot) previous).setReadObserver(observer);
            } else {
                throw new IllegalStateException(("Non-transparent snapshot was reused: " + previous).toString());
            }
        }

        public final void sendApplyNotifications() {
            boolean z;
            synchronized (SnapshotKt.getLock()) {
                MutableScatterSet<StateObject> modified$runtime_release = ((GlobalSnapshot) SnapshotKt.currentGlobalSnapshot.get()).getModified$runtime_release();
                z = false;
                if (modified$runtime_release != null) {
                    if (modified$runtime_release.isNotEmpty()) {
                        z = true;
                    }
                }
            }
            if (z) {
                SnapshotKt.advanceGlobalSnapshot();
            }
        }

        @NotNull
        public final MutableSnapshot takeMutableSnapshot(@Nullable Function1<Object, Unit> readObserver, @Nullable Function1<Object, Unit> writeObserver) {
            MutableSnapshot mutableSnapshotTakeNestedMutableSnapshot;
            Snapshot snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
            MutableSnapshot mutableSnapshot = snapshotCurrentSnapshot instanceof MutableSnapshot ? (MutableSnapshot) snapshotCurrentSnapshot : null;
            if (mutableSnapshot == null || (mutableSnapshotTakeNestedMutableSnapshot = mutableSnapshot.takeNestedMutableSnapshot(readObserver, writeObserver)) == null) {
                throw new IllegalStateException("Cannot create a mutable snapshot of an read-only snapshot");
            }
            return mutableSnapshotTakeNestedMutableSnapshot;
        }

        @NotNull
        public final Snapshot takeSnapshot(@Nullable Function1<Object, Unit> readObserver) {
            return SnapshotKt.currentSnapshot().takeNestedSnapshot(readObserver);
        }

        public final <R> R withMutableSnapshot(@NotNull Function0<? extends R> block) {
            MutableSnapshot mutableSnapshotTakeMutableSnapshot$default = takeMutableSnapshot$default(this, null, null, 3, null);
            try {
                Snapshot snapshotMakeCurrent = mutableSnapshotTakeMutableSnapshot$default.makeCurrent();
                try {
                    R rInvoke = block.invoke();
                    InlineMarker.finallyStart(1);
                    mutableSnapshotTakeMutableSnapshot$default.restoreCurrent(snapshotMakeCurrent);
                    InlineMarker.finallyEnd(1);
                    mutableSnapshotTakeMutableSnapshot$default.apply().check();
                    return rInvoke;
                } catch (Throwable th) {
                    InlineMarker.finallyStart(1);
                    mutableSnapshotTakeMutableSnapshot$default.restoreCurrent(snapshotMakeCurrent);
                    InlineMarker.finallyEnd(1);
                    throw th;
                }
            } finally {
                InlineMarker.finallyStart(1);
                mutableSnapshotTakeMutableSnapshot$default.dispose();
                InlineMarker.finallyEnd(1);
            }
        }

        public final <T> T withoutReadObservation(@NotNull Function0<? extends T> block) {
            Snapshot currentThreadSnapshot = getCurrentThreadSnapshot();
            Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
            Snapshot snapshotMakeCurrentNonObservable = makeCurrentNonObservable(currentThreadSnapshot);
            try {
                return block.invoke();
            } finally {
                InlineMarker.finallyStart(1);
                restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                InlineMarker.finallyEnd(1);
            }
        }

        private Companion() {
        }

        private final boolean getCanBeReused(TransparentObserverSnapshot transparentObserverSnapshot) {
            return transparentObserverSnapshot.getThreadId$runtime_release() == ActualJvm_jvmKt.currentThreadId();
        }

        @PublishedApi
        public static /* synthetic */ void getCurrentThreadSnapshot$annotations() {
        }

        public static /* synthetic */ void getPreexistingSnapshotId$annotations() {
        }
    }

    public /* synthetic */ Snapshot(int i, SnapshotIdSet snapshotIdSet, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, snapshotIdSet);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Snapshot takeNestedSnapshot$default(Snapshot snapshot, Function1 function1, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: takeNestedSnapshot");
        }
        if ((i & 1) != 0) {
            function1 = null;
        }
        return snapshot.takeNestedSnapshot(function1);
    }

    public final void closeAndReleasePinning$runtime_release() {
        synchronized (SnapshotKt.getLock()) {
            closeLocked$runtime_release();
            releasePinnedSnapshotsForCloseLocked$runtime_release();
            Unit unit = Unit.INSTANCE;
        }
    }

    public void closeLocked$runtime_release() {
        SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.clear(getId());
    }

    public void dispose() {
        this.disposed = true;
        synchronized (SnapshotKt.getLock()) {
            releasePinnedSnapshotLocked$runtime_release();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final <T> T enter(@NotNull Function0<? extends T> block) {
        Snapshot snapshotMakeCurrent = makeCurrent();
        try {
            return block.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            restoreCurrent(snapshotMakeCurrent);
            InlineMarker.finallyEnd(1);
        }
    }

    /* JADX INFO: renamed from: getDisposed$runtime_release, reason: from getter */
    public final boolean getDisposed() {
        return this.disposed;
    }

    public int getId() {
        return this.id;
    }

    @NotNull
    /* JADX INFO: renamed from: getInvalid$runtime_release, reason: from getter */
    public SnapshotIdSet getInvalid() {
        return this.invalid;
    }

    @Nullable
    public abstract MutableScatterSet<StateObject> getModified$runtime_release();

    @Nullable
    public abstract Function1<Object, Unit> getReadObserver();

    public abstract boolean getReadOnly();

    @NotNull
    public abstract Snapshot getRoot();

    public int getWriteCount$runtime_release() {
        return 0;
    }

    @Nullable
    public abstract Function1<Object, Unit> getWriteObserver$runtime_release();

    public abstract boolean hasPendingChanges();

    public final boolean isPinned$runtime_release() {
        return this.pinningTrackingHandle >= 0;
    }

    @PublishedApi
    @Nullable
    public Snapshot makeCurrent() {
        Snapshot snapshot = (Snapshot) SnapshotKt.threadSnapshot.get();
        SnapshotKt.threadSnapshot.set(this);
        return snapshot;
    }

    /* JADX INFO: renamed from: nestedActivated$runtime_release */
    public abstract void mo18112nestedActivated$runtime_release(@NotNull Snapshot snapshot);

    /* JADX INFO: renamed from: nestedDeactivated$runtime_release */
    public abstract void mo18113nestedDeactivated$runtime_release(@NotNull Snapshot snapshot);

    public abstract void notifyObjectsInitialized$runtime_release();

    /* JADX INFO: renamed from: recordModified$runtime_release */
    public abstract void mo18114recordModified$runtime_release(@NotNull StateObject state);

    public final void releasePinnedSnapshotLocked$runtime_release() {
        int i = this.pinningTrackingHandle;
        if (i >= 0) {
            SnapshotKt.releasePinningLocked(i);
            this.pinningTrackingHandle = -1;
        }
    }

    public void releasePinnedSnapshotsForCloseLocked$runtime_release() {
        releasePinnedSnapshotLocked$runtime_release();
    }

    @PublishedApi
    public void restoreCurrent(@Nullable Snapshot snapshot) {
        SnapshotKt.threadSnapshot.set(snapshot);
    }

    public final void setDisposed$runtime_release(boolean z) {
        this.disposed = z;
    }

    public void setId$runtime_release(int i) {
        this.id = i;
    }

    public void setInvalid$runtime_release(@NotNull SnapshotIdSet snapshotIdSet) {
        this.invalid = snapshotIdSet;
    }

    public void setWriteCount$runtime_release(int i) {
        throw new IllegalStateException("Updating write count is not supported for this snapshot");
    }

    @NotNull
    public abstract Snapshot takeNestedSnapshot(@Nullable Function1<Object, Unit> readObserver);

    public final int takeoverPinnedSnapshot$runtime_release() {
        int i = this.pinningTrackingHandle;
        this.pinningTrackingHandle = -1;
        return i;
    }

    @ExperimentalComposeApi
    @Nullable
    public final Snapshot unsafeEnter() {
        return makeCurrent();
    }

    @ExperimentalComposeApi
    public final void unsafeLeave(@Nullable Snapshot oldSnapshot) {
        if (!(SnapshotKt.threadSnapshot.get() == this)) {
            PreconditionsKt.throwIllegalStateException("Cannot leave snapshot; " + this + " is not the current snapshot");
        }
        restoreCurrent(oldSnapshot);
    }

    public final void validateNotDisposed$runtime_release() {
        if (this.disposed) {
            PreconditionsKt.throwIllegalArgumentException("Cannot use a disposed snapshot");
        }
    }

    private Snapshot(int i, SnapshotIdSet snapshotIdSet) {
        this.invalid = snapshotIdSet;
        this.id = i;
        this.pinningTrackingHandle = i != 0 ? SnapshotKt.trackPinning(i, getInvalid()) : -1;
    }

    private static /* synthetic */ void getPinningTrackingHandle$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getReadObserver$annotations() {
    }
}
