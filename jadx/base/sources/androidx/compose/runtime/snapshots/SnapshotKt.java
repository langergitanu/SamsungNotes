package androidx.compose.runtime.snapshots;

import androidx.collection.MutableScatterSet;
import androidx.compose.runtime.AtomicInt;
import androidx.compose.runtime.SnapshotThreadLocal;
import androidx.compose.runtime.WeakReference;
import androidx.compose.runtime.collection.ScatterSetWrapperKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotIdSet;
import com.google.firebase.messaging.Constants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0096\u0001\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0001\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\n\u001a\b\u0010)\u001a\u00020\bH\u0002\u001a6\u0010)\u001a\u0002H*\"\u0004\b\u0000\u0010*2!\u0010+\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u0002H*0\u000fH\u0002¢\u0006\u0002\u0010,\u001a\b\u0010-\u001a\u00020\bH\u0002\u001a4\u0010.\u001a\u00020\u00072\b\u0010/\u001a\u0004\u0018\u00010\u00072\u0016\b\u0002\u00100\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f2\b\b\u0002\u00101\u001a\u000202H\u0002\u001a\u001f\u00103\u001a\u0002H*\"\b\b\u0000\u0010**\u0002042\u0006\u00105\u001a\u0002H*H\u0001¢\u0006\u0002\u00106\u001a'\u00103\u001a\u0002H*\"\b\b\u0000\u0010**\u0002042\u0006\u00105\u001a\u0002H*2\u0006\u00107\u001a\u00020\u0007H\u0001¢\u0006\u0002\u00108\u001a\b\u00109\u001a\u00020\u0007H\u0000\u001aL\u0010:\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f2\u0014\u00100\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f2\u0014\u0010;\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f2\b\b\u0002\u0010<\u001a\u000202H\u0002\u001aB\u0010=\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f2\u0014\u0010>\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f2\u0014\u0010;\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\u000fH\u0002\u001a\u0018\u0010?\u001a\u00020\b2\u0006\u00107\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u0016H\u0001\u001a.\u0010A\u001a\u0010\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u000204\u0018\u00010B2\u0006\u00109\u001a\u00020C2\u0006\u0010D\u001a\u00020C2\u0006\u0010E\u001a\u00020\u0010H\u0002\u001a\u0010\u0010F\u001a\u0002022\u0006\u0010@\u001a\u00020\u0016H\u0002\u001a\u0010\u0010G\u001a\u00020\b2\u0006\u0010@\u001a\u00020\u0016H\u0002\u001a\b\u0010H\u001a\u00020IH\u0002\u001a1\u0010J\u001a\u0004\u0018\u0001H*\"\b\b\u0000\u0010**\u0002042\u0006\u00105\u001a\u0002H*2\u0006\u0010K\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0010H\u0002¢\u0006\u0002\u0010L\u001a\u0010\u0010M\u001a\u00020\b2\u0006\u0010N\u001a\u00020\u0001H\u0000\u001a\b\u0010O\u001a\u00020IH\u0002\u001a\"\u0010P\u001a\u0002H*\"\u0004\b\u0000\u0010*2\f\u0010+\u001a\b\u0012\u0004\u0012\u0002H*0QH\u0081\b¢\u0006\u0002\u0010R\u001a>\u0010S\u001a\u0002H*\"\u0004\b\u0000\u0010*2\u0006\u0010T\u001a\u00020\u00072!\u0010+\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u0002H*0\u000fH\u0002¢\u0006\u0002\u0010U\u001a:\u0010V\u001a\u0002H*\"\b\b\u0000\u0010**\u00020\u00072!\u0010+\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u0002H*0\u000fH\u0002¢\u0006\u0002\u0010W\u001a\u0018\u0010X\u001a\u00020\u00012\u0006\u0010K\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0010H\u0000\u001a\u0012\u0010Y\u001a\u0004\u0018\u0001042\u0006\u0010@\u001a\u00020\u0016H\u0002\u001a \u0010Z\u001a\u0002022\u0006\u0010[\u001a\u0002042\u0006\u00107\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0010H\u0002\u001a \u0010Z\u001a\u0002022\u0006\u00109\u001a\u00020\u00012\u0006\u0010\\\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0010H\u0002\u001a\u0010\u0010]\u001a\u00020\b2\u0006\u00107\u001a\u00020\u0007H\u0002\u001a\u001c\u0010^\u001a\u00020\u0010*\u00020\u00102\u0006\u0010_\u001a\u00020\u00012\u0006\u0010`\u001a\u00020\u0001H\u0000\u001a!\u0010a\u001a\u000204*\u0002042\u0012\u0010b\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u0002020\u000fH\u0082\b\u001a#\u0010c\u001a\u0002H*\"\b\b\u0000\u0010**\u000204*\u0002H*2\u0006\u0010@\u001a\u00020\u0016H\u0000¢\u0006\u0002\u0010d\u001a+\u0010e\u001a\u0002H*\"\b\b\u0000\u0010**\u000204*\u0002H*2\u0006\u0010@\u001a\u00020\u00162\u0006\u00107\u001a\u00020\u0007H\u0000¢\u0006\u0002\u0010f\u001a+\u0010g\u001a\u0002H*\"\b\b\u0000\u0010**\u000204*\u0002H*2\u0006\u0010@\u001a\u00020\u00162\u0006\u00107\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010f\u001aK\u0010h\u001a\u0002Hi\"\b\b\u0000\u0010**\u000204\"\u0004\b\u0001\u0010i*\u0002H*2\u0006\u0010@\u001a\u00020\u00162\u0006\u0010j\u001a\u0002H*2\u0017\u0010+\u001a\u0013\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002Hi0\u000f¢\u0006\u0002\bkH\u0080\b¢\u0006\u0002\u0010l\u001a3\u0010m\u001a\u0002H*\"\b\b\u0000\u0010**\u000204*\u0002H*2\u0006\u0010@\u001a\u00020\u00162\u0006\u00107\u001a\u00020\u00072\u0006\u0010j\u001a\u0002H*H\u0000¢\u0006\u0002\u0010n\u001a!\u0010J\u001a\u0002H*\"\b\b\u0000\u0010**\u000204*\u0002H*2\u0006\u0010@\u001a\u00020\u0016¢\u0006\u0002\u0010d\u001a)\u0010J\u001a\u0002H*\"\b\b\u0000\u0010**\u000204*\u0002H*2\u0006\u0010@\u001a\u00020\u00162\u0006\u00107\u001a\u00020\u0007¢\u0006\u0002\u0010f\u001aE\u0010o\u001a\u0002Hi\"\b\b\u0000\u0010**\u000204\"\u0004\b\u0001\u0010i*\u0002H*2!\u0010+\u001a\u001d\u0012\u0013\u0012\u0011H*¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(5\u0012\u0004\u0012\u0002Hi0\u000fH\u0086\b¢\u0006\u0002\u0010p\u001aC\u0010q\u001a\u0002Hi\"\b\b\u0000\u0010**\u000204\"\u0004\b\u0001\u0010i*\u0002H*2\u0006\u0010@\u001a\u00020\u00162\u0017\u0010+\u001a\u0013\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002Hi0\u000f¢\u0006\u0002\bkH\u0086\b¢\u0006\u0002\u0010r\u001aK\u0010q\u001a\u0002Hi\"\b\b\u0000\u0010**\u000204\"\u0004\b\u0001\u0010i*\u0002H*2\u0006\u0010@\u001a\u00020\u00162\u0006\u00107\u001a\u00020\u00072\u0017\u0010+\u001a\u0013\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002Hi0\u000f¢\u0006\u0002\bkH\u0086\b¢\u0006\u0002\u0010s\u001a+\u0010t\u001a\u0002H*\"\b\b\u0000\u0010**\u000204*\u0002H*2\u0006\u0010@\u001a\u00020\u00162\u0006\u00107\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010f\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\",\u0010\u0002\u001a \u0012\u001c\u0012\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00040\u0003X\u0082\u000e¢\u0006\u0002\n\u0000\".\u0010\t\u001a\"\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b0\nj\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b`\rX\u0082\u0004¢\u0006\u0002\n\u0000\")\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\b0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000\" \u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u000f0\u0003X\u0082\u000e¢\u0006\u0002\n\u0000\"\u001c\u0010\u0018\u001a\u00020\u00068\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u000e\u0010\u001d\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000\"\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000\"\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001c\u0010#\u001a\u00020\u00078\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u001a\u001a\u0004\b%\u0010&\"\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00070(X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006u"}, m13886d2 = {"INVALID_SNAPSHOT", "", "applyObservers", "", "Lkotlin/Function2;", "", "", "Landroidx/compose/runtime/snapshots/Snapshot;", "", "currentGlobalSnapshot", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/runtime/snapshots/GlobalSnapshot;", "kotlin.jvm.PlatformType", "Landroidx/compose/runtime/AtomicReference;", "emptyLambda", "Lkotlin/Function1;", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "Lkotlin/ParameterName;", "name", "invalid", "extraStateObjects", "Landroidx/compose/runtime/snapshots/SnapshotWeakSet;", "Landroidx/compose/runtime/snapshots/StateObject;", "globalWriteObservers", "lock", "getLock$annotations", "()V", "getLock", "()Ljava/lang/Object;", "nextSnapshotId", "openSnapshots", "pendingApplyObserverCount", "Landroidx/compose/runtime/AtomicInt;", "pinningTable", "Landroidx/compose/runtime/snapshots/SnapshotDoubleIndexHeap;", "snapshotInitializer", "getSnapshotInitializer$annotations", "getSnapshotInitializer", "()Landroidx/compose/runtime/snapshots/Snapshot;", "threadSnapshot", "Landroidx/compose/runtime/SnapshotThreadLocal;", "advanceGlobalSnapshot", "T", "block", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "checkAndOverwriteUnusedRecordsLocked", "createTransparentSnapshotWithNoParentReadObserver", "previousSnapshot", "readObserver", "ownsPreviousSnapshot", "", "current", "Landroidx/compose/runtime/snapshots/StateRecord;", "r", "(Landroidx/compose/runtime/snapshots/StateRecord;)Landroidx/compose/runtime/snapshots/StateRecord;", "snapshot", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/Snapshot;)Landroidx/compose/runtime/snapshots/StateRecord;", "currentSnapshot", "mergedReadObserver", "parentObserver", "mergeReadObserver", "mergedWriteObserver", "writeObserver", "notifyWrite", "state", "optimisticMerges", "", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "applyingSnapshot", "invalidSnapshots", "overwriteUnusedRecordsLocked", "processForUnusedRecordsLocked", "readError", "", "readable", "id", "(Landroidx/compose/runtime/snapshots/StateRecord;ILandroidx/compose/runtime/snapshots/SnapshotIdSet;)Landroidx/compose/runtime/snapshots/StateRecord;", "releasePinningLocked", "handle", "reportReadonlySnapshotWrite", "sync", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "takeNewGlobalSnapshot", "previousGlobalSnapshot", "(Landroidx/compose/runtime/snapshots/Snapshot;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "takeNewSnapshot", "(Lkotlin/jvm/functions/Function1;)Landroidx/compose/runtime/snapshots/Snapshot;", "trackPinning", "usedLocked", "valid", "data", "candidateSnapshot", "validateOpen", "addRange", Constants.MessagePayloadKeys.FROM, "until", "findYoungestOr", "predicate", "newOverwritableRecordLocked", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;)Landroidx/compose/runtime/snapshots/StateRecord;", "newWritableRecord", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;Landroidx/compose/runtime/snapshots/Snapshot;)Landroidx/compose/runtime/snapshots/StateRecord;", "newWritableRecordLocked", "overwritable", "R", "candidate", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;Landroidx/compose/runtime/snapshots/StateRecord;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "overwritableRecord", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;Landroidx/compose/runtime/snapshots/Snapshot;Landroidx/compose/runtime/snapshots/StateRecord;)Landroidx/compose/runtime/snapshots/StateRecord;", "withCurrent", "(Landroidx/compose/runtime/snapshots/StateRecord;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "writable", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;Landroidx/compose/runtime/snapshots/Snapshot;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "writableRecord", "runtime_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSnapshot.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Snapshot.kt\nandroidx/compose/runtime/snapshots/SnapshotKt\n+ 2 ActualJvm.jvm.kt\nandroidx/compose/runtime/ActualJvm_jvmKt\n+ 3 ListUtils.kt\nandroidx/compose/runtime/snapshots/ListUtilsKt\n+ 4 ScatterSet.kt\nandroidx/collection/ScatterSet\n+ 5 ScatterMap.kt\nandroidx/collection/ScatterMapKt\n+ 6 SnapshotWeakSet.kt\nandroidx/compose/runtime/snapshots/SnapshotWeakSet\n+ 7 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,2431:1\n1843#1:2432\n1843#1:2435\n1843#1:2437\n1843#1:2445\n1843#1:2473\n1843#1:2475\n2163#1,9:2477\n1843#1:2514\n1843#1:2516\n1843#1:2518\n1843#1:2520\n1843#1:2523\n1843#1:2525\n1843#1:2553\n89#2:2433\n89#2:2434\n89#2:2436\n89#2:2438\n89#2:2446\n89#2:2474\n89#2:2476\n89#2:2515\n89#2:2517\n89#2:2519\n89#2:2521\n89#2:2524\n89#2:2526\n89#2:2554\n33#3,6:2439\n228#4,4:2447\n198#4,7:2451\n209#4,3:2459\n212#4,9:2463\n232#4:2472\n228#4,4:2527\n198#4,7:2531\n209#4,3:2539\n212#4,9:2543\n232#4:2552\n1956#5:2458\n1820#5:2462\n1956#5:2538\n1820#5:2542\n125#6,28:2486\n1#7:2522\n*S KotlinDebug\n*F\n+ 1 Snapshot.kt\nandroidx/compose/runtime/snapshots/SnapshotKt\n*L\n720#1:2432\n1904#1:2435\n1930#1:2437\n1952#1:2445\n1982#1:2473\n2035#1:2475\n2145#1:2477,9\n2199#1:2514\n2225#1:2516\n2234#1:2518\n2302#1:2520\n2314#1:2523\n2342#1:2525\n2407#1:2553\n720#1:2433\n1843#1:2434\n1904#1:2436\n1930#1:2438\n1952#1:2446\n1982#1:2474\n2035#1:2476\n2199#1:2515\n2225#1:2517\n2234#1:2519\n2302#1:2521\n2314#1:2524\n2342#1:2526\n2407#1:2554\n1944#1:2439,6\n1954#1:2447,4\n1954#1:2451,7\n1954#1:2459,3\n1954#1:2463,9\n1954#1:2472\n2365#1:2527,4\n2365#1:2531,7\n2365#1:2539,3\n2365#1:2543,9\n2365#1:2552\n1954#1:2458\n1954#1:2462\n2365#1:2538\n2365#1:2542\n2175#1:2486,28\n*E\n"})
public final class SnapshotKt {
    private static final int INVALID_SNAPSHOT = 0;

    @NotNull
    private static List<? extends Function2<? super Set<? extends Object>, ? super Snapshot, Unit>> applyObservers;

    @NotNull
    private static final AtomicReference<GlobalSnapshot> currentGlobalSnapshot;

    @NotNull
    private static final SnapshotWeakSet<StateObject> extraStateObjects;

    @NotNull
    private static List<? extends Function1<Object, Unit>> globalWriteObservers;
    private static int nextSnapshotId;

    @NotNull
    private static SnapshotIdSet openSnapshots;

    @NotNull
    private static AtomicInt pendingApplyObserverCount;

    @NotNull
    private static final SnapshotDoubleIndexHeap pinningTable;

    @NotNull
    private static final Snapshot snapshotInitializer;

    @NotNull
    private static final Function1<SnapshotIdSet, Unit> emptyLambda = new Function1<SnapshotIdSet, Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotKt$emptyLambda$1
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull SnapshotIdSet snapshotIdSet) {
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SnapshotIdSet snapshotIdSet) {
            invoke2(snapshotIdSet);
            return Unit.INSTANCE;
        }
    };

    @NotNull
    private static final SnapshotThreadLocal<Snapshot> threadSnapshot = new SnapshotThreadLocal<>();

    @NotNull
    private static final Object lock = new Object();

    static {
        SnapshotIdSet.Companion companion = SnapshotIdSet.INSTANCE;
        openSnapshots = companion.getEMPTY();
        nextSnapshotId = 2;
        pinningTable = new SnapshotDoubleIndexHeap();
        extraStateObjects = new SnapshotWeakSet<>();
        applyObservers = CollectionsKt.emptyList();
        globalWriteObservers = CollectionsKt.emptyList();
        int i = nextSnapshotId;
        nextSnapshotId = i + 1;
        GlobalSnapshot globalSnapshot = new GlobalSnapshot(i, companion.getEMPTY());
        openSnapshots = openSnapshots.set(globalSnapshot.getId());
        AtomicReference<GlobalSnapshot> atomicReference = new AtomicReference<>(globalSnapshot);
        currentGlobalSnapshot = atomicReference;
        snapshotInitializer = atomicReference.get();
        pendingApplyObserverCount = new AtomicInt(0);
    }

    @NotNull
    public static final SnapshotIdSet addRange(@NotNull SnapshotIdSet snapshotIdSet, int i, int i2) {
        while (i < i2) {
            snapshotIdSet = snapshotIdSet.set(i);
            i++;
        }
        return snapshotIdSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> T advanceGlobalSnapshot(Function1<? super SnapshotIdSet, ? extends T> function1) {
        GlobalSnapshot globalSnapshot;
        MutableScatterSet<StateObject> modified$runtime_release;
        T t;
        Snapshot snapshot = snapshotInitializer;
        Intrinsics.checkNotNull(snapshot, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.GlobalSnapshot");
        synchronized (getLock()) {
            try {
                globalSnapshot = currentGlobalSnapshot.get();
                modified$runtime_release = globalSnapshot.getModified$runtime_release();
                if (modified$runtime_release != null) {
                    pendingApplyObserverCount.add(1);
                }
                t = (T) takeNewGlobalSnapshot(globalSnapshot, function1);
            } catch (Throwable th) {
                throw th;
            }
        }
        if (modified$runtime_release != null) {
            try {
                List<? extends Function2<? super Set<? extends Object>, ? super Snapshot, Unit>> list = applyObservers;
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    list.get(i).invoke(ScatterSetWrapperKt.wrapIntoSet(modified$runtime_release), globalSnapshot);
                }
            } finally {
                pendingApplyObserverCount.add(-1);
            }
        }
        synchronized (getLock()) {
            try {
                checkAndOverwriteUnusedRecordsLocked();
                if (modified$runtime_release != null) {
                    Object[] objArr = modified$runtime_release.elements;
                    long[] jArr = modified$runtime_release.metadata;
                    int length = jArr.length - 2;
                    if (length >= 0) {
                        int i2 = 0;
                        while (true) {
                            long j = jArr[i2];
                            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                                int i4 = 8 - ((~(i2 - length)) >>> 31);
                                for (int i5 = 0; i5 < i4; i5++) {
                                    if ((255 & j) < 128) {
                                        processForUnusedRecordsLocked((StateObject) objArr[(i2 << 3) + i5]);
                                    }
                                    j >>= 8;
                                }
                                if (i4 != 8) {
                                    break;
                                }
                                if (i2 == length) {
                                    break;
                                }
                                i2++;
                            }
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return t;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkAndOverwriteUnusedRecordsLocked() {
        SnapshotWeakSet<StateObject> snapshotWeakSet = extraStateObjects;
        int size$runtime_release = snapshotWeakSet.getSize();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= size$runtime_release) {
                break;
            }
            WeakReference<StateObject> weakReference = snapshotWeakSet.getValues$runtime_release()[i];
            StateObject stateObject = weakReference != null ? weakReference.get() : null;
            if (stateObject != null && overwriteUnusedRecordsLocked(stateObject)) {
                if (i2 != i) {
                    snapshotWeakSet.getValues$runtime_release()[i2] = weakReference;
                    snapshotWeakSet.getHashes()[i2] = snapshotWeakSet.getHashes()[i];
                }
                i2++;
            }
            i++;
        }
        for (int i4 = i2; i4 < size$runtime_release; i4++) {
            snapshotWeakSet.getValues$runtime_release()[i4] = null;
            snapshotWeakSet.getHashes()[i4] = 0;
        }
        if (i2 != size$runtime_release) {
            snapshotWeakSet.setSize$runtime_release(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Snapshot createTransparentSnapshotWithNoParentReadObserver(Snapshot snapshot, Function1<Object, Unit> function1, boolean z) {
        boolean z2 = snapshot instanceof MutableSnapshot;
        if (z2 || snapshot == null) {
            return new TransparentObserverMutableSnapshot(z2 ? (MutableSnapshot) snapshot : null, function1, null, false, z);
        }
        return new TransparentObserverSnapshot(snapshot, function1, false, z);
    }

    public static /* synthetic */ Snapshot createTransparentSnapshotWithNoParentReadObserver$default(Snapshot snapshot, Function1 function1, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        return createTransparentSnapshotWithNoParentReadObserver(snapshot, function1, z);
    }

    @PublishedApi
    @NotNull
    public static final <T extends StateRecord> T current(@NotNull T t, @NotNull Snapshot snapshot) {
        T t2 = (T) readable(t, snapshot.getId(), snapshot.getInvalid());
        if (t2 != null) {
            return t2;
        }
        readError();
        throw new KotlinNothingValueException();
    }

    @NotNull
    public static final Snapshot currentSnapshot() {
        Snapshot snapshot = threadSnapshot.get();
        return snapshot == null ? currentGlobalSnapshot.get() : snapshot;
    }

    private static final StateRecord findYoungestOr(StateRecord stateRecord, Function1<? super StateRecord, Boolean> function1) {
        StateRecord stateRecord2 = stateRecord;
        while (stateRecord != null) {
            if (function1.invoke(stateRecord).booleanValue()) {
                return stateRecord;
            }
            if (stateRecord2.getSnapshotId() < stateRecord.getSnapshotId()) {
                stateRecord2 = stateRecord;
            }
            stateRecord = stateRecord.getNext();
        }
        return stateRecord2;
    }

    @NotNull
    public static final Object getLock() {
        return lock;
    }

    @NotNull
    public static final Snapshot getSnapshotInitializer() {
        return snapshotInitializer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function1<Object, Unit> mergedReadObserver(final Function1<Object, Unit> function1, final Function1<Object, Unit> function12, boolean z) {
        if (!z) {
            function12 = null;
        }
        return (function1 == null || function12 == null || function1 == function12) ? function1 == null ? function12 : function1 : new Function1<Object, Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotKt.mergedReadObserver.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2(obj);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Object obj) {
                function1.invoke(obj);
                function12.invoke(obj);
            }
        };
    }

    public static /* synthetic */ Function1 mergedReadObserver$default(Function1 function1, Function1 function12, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return mergedReadObserver(function1, function12, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function1<Object, Unit> mergedWriteObserver(final Function1<Object, Unit> function1, final Function1<Object, Unit> function12) {
        return (function1 == null || function12 == null || function1 == function12) ? function1 == null ? function12 : function1 : new Function1<Object, Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotKt.mergedWriteObserver.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2(obj);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Object obj) {
                function1.invoke(obj);
                function12.invoke(obj);
            }
        };
    }

    @NotNull
    public static final <T extends StateRecord> T newOverwritableRecordLocked(@NotNull T t, @NotNull StateObject stateObject) {
        T t2 = (T) usedLocked(stateObject);
        if (t2 != null) {
            t2.setSnapshotId$runtime_release(Integer.MAX_VALUE);
            return t2;
        }
        T t5 = (T) t.create();
        t5.setSnapshotId$runtime_release(Integer.MAX_VALUE);
        t5.setNext$runtime_release(stateObject.getFirstStateRecord());
        Intrinsics.checkNotNull(t5, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.newOverwritableRecordLocked$lambda$16");
        stateObject.prependStateRecord(t5);
        Intrinsics.checkNotNull(t5, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.newOverwritableRecordLocked");
        return t5;
    }

    @NotNull
    public static final <T extends StateRecord> T newWritableRecord(@NotNull T t, @NotNull StateObject stateObject, @NotNull Snapshot snapshot) {
        T t2;
        synchronized (getLock()) {
            t2 = (T) newWritableRecordLocked(t, stateObject, snapshot);
        }
        return t2;
    }

    private static final <T extends StateRecord> T newWritableRecordLocked(T t, StateObject stateObject, Snapshot snapshot) {
        T t2 = (T) newOverwritableRecordLocked(t, stateObject);
        t2.assign(t);
        t2.setSnapshotId$runtime_release(snapshot.getId());
        return t2;
    }

    @PublishedApi
    public static final void notifyWrite(@NotNull Snapshot snapshot, @NotNull StateObject stateObject) {
        snapshot.setWriteCount$runtime_release(snapshot.getWriteCount() + 1);
        Function1<Object, Unit> writeObserver$runtime_release = snapshot.getWriteObserver$runtime_release();
        if (writeObserver$runtime_release != null) {
            writeObserver$runtime_release.invoke(stateObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map<StateRecord, StateRecord> optimisticMerges(MutableSnapshot mutableSnapshot, MutableSnapshot mutableSnapshot2, SnapshotIdSet snapshotIdSet) {
        long[] jArr;
        int i;
        Map<StateRecord, StateRecord> map;
        long[] jArr2;
        int i2;
        Map<StateRecord, StateRecord> map2;
        int i4;
        MutableScatterSet<StateObject> modified$runtime_release = mutableSnapshot2.getModified$runtime_release();
        int id = mutableSnapshot.getId();
        Map<StateRecord, StateRecord> map3 = null;
        if (modified$runtime_release == null) {
            return null;
        }
        SnapshotIdSet snapshotIdSetM1337or = mutableSnapshot2.getInvalid().set(mutableSnapshot2.getId()).m1337or(mutableSnapshot2.getPreviousIds());
        Object[] objArr = modified$runtime_release.elements;
        long[] jArr3 = modified$runtime_release.metadata;
        int length = jArr3.length - 2;
        if (length < 0) {
            return null;
        }
        HashMap map4 = null;
        int i5 = 0;
        while (true) {
            long j = jArr3[i5];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i6 = 8;
                int i7 = 8 - ((~(i5 - length)) >>> 31);
                int i8 = 0;
                while (i8 < i7) {
                    if ((255 & j) < 128) {
                        StateObject stateObject = (StateObject) objArr[(i5 << 3) + i8];
                        StateRecord firstStateRecord = stateObject.getFirstStateRecord();
                        map2 = map3;
                        StateRecord stateRecord = readable(firstStateRecord, id, snapshotIdSet);
                        if (stateRecord == null) {
                            i4 = i6;
                        } else {
                            i4 = i6;
                            StateRecord stateRecord2 = readable(firstStateRecord, id, snapshotIdSetM1337or);
                            if (stateRecord2 != null && !Intrinsics.areEqual(stateRecord, stateRecord2)) {
                                jArr2 = jArr3;
                                i2 = id;
                                StateRecord stateRecord3 = readable(firstStateRecord, mutableSnapshot2.getId(), mutableSnapshot2.getInvalid());
                                if (stateRecord3 == null) {
                                    readError();
                                    throw new KotlinNothingValueException();
                                }
                                StateRecord stateRecordMergeRecords = stateObject.mergeRecords(stateRecord2, stateRecord, stateRecord3);
                                if (stateRecordMergeRecords == null) {
                                    return map2;
                                }
                                if (map4 == null) {
                                    map4 = new HashMap();
                                }
                                map4.put(stateRecord, stateRecordMergeRecords);
                                map4 = map4;
                            }
                        }
                        jArr2 = jArr3;
                        i2 = id;
                    } else {
                        jArr2 = jArr3;
                        i2 = id;
                        map2 = map3;
                        i4 = i6;
                    }
                    j >>= i4;
                    i8++;
                    map3 = map2;
                    i6 = i4;
                    jArr3 = jArr2;
                    id = i2;
                }
                jArr = jArr3;
                i = id;
                map = map3;
                if (i7 != i6) {
                    return map4;
                }
            } else {
                jArr = jArr3;
                i = id;
                map = map3;
            }
            if (i5 == length) {
                return map4;
            }
            i5++;
            map3 = map;
            jArr3 = jArr;
            id = i;
        }
    }

    public static final <T extends StateRecord, R> R overwritable(@NotNull T t, @NotNull StateObject stateObject, @NotNull T t2, @NotNull Function1<? super T, ? extends R> function1) {
        Snapshot current;
        R rInvoke;
        getSnapshotInitializer();
        synchronized (getLock()) {
            try {
                current = Snapshot.INSTANCE.getCurrent();
                rInvoke = function1.invoke(overwritableRecord(t, stateObject, current, t2));
                InlineMarker.finallyStart(1);
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        InlineMarker.finallyEnd(1);
        notifyWrite(current, stateObject);
        return rInvoke;
    }

    @NotNull
    public static final <T extends StateRecord> T overwritableRecord(@NotNull T t, @NotNull StateObject stateObject, @NotNull Snapshot snapshot, @NotNull T t2) {
        T t5;
        if (snapshot.getReadOnly()) {
            snapshot.mo18114recordModified$runtime_release(stateObject);
        }
        int id = snapshot.getId();
        if (t2.getSnapshotId() == id) {
            return t2;
        }
        synchronized (getLock()) {
            t5 = (T) newOverwritableRecordLocked(t, stateObject);
        }
        t5.setSnapshotId$runtime_release(id);
        if (t2.getSnapshotId() != 1) {
            snapshot.mo18114recordModified$runtime_release(stateObject);
        }
        return t5;
    }

    private static final boolean overwriteUnusedRecordsLocked(StateObject stateObject) {
        StateRecord stateRecord;
        int iLowestOrDefault = pinningTable.lowestOrDefault(nextSnapshotId);
        StateRecord stateRecord2 = null;
        StateRecord firstStateRecord = null;
        int i = 0;
        for (StateRecord firstStateRecord2 = stateObject.getFirstStateRecord(); firstStateRecord2 != null; firstStateRecord2 = firstStateRecord2.getNext()) {
            int snapshotId$runtime_release = firstStateRecord2.getSnapshotId();
            if (snapshotId$runtime_release != 0) {
                if (snapshotId$runtime_release >= iLowestOrDefault) {
                    i++;
                } else if (stateRecord2 == null) {
                    i++;
                    stateRecord2 = firstStateRecord2;
                } else {
                    if (firstStateRecord2.getSnapshotId() < stateRecord2.getSnapshotId()) {
                        stateRecord = stateRecord2;
                        stateRecord2 = firstStateRecord2;
                    } else {
                        stateRecord = firstStateRecord2;
                    }
                    if (firstStateRecord == null) {
                        firstStateRecord = stateObject.getFirstStateRecord();
                        StateRecord stateRecord3 = firstStateRecord;
                        while (true) {
                            if (firstStateRecord == null) {
                                firstStateRecord = stateRecord3;
                                break;
                            }
                            if (firstStateRecord.getSnapshotId() >= iLowestOrDefault) {
                                break;
                            }
                            if (stateRecord3.getSnapshotId() < firstStateRecord.getSnapshotId()) {
                                stateRecord3 = firstStateRecord;
                            }
                            firstStateRecord = firstStateRecord.getNext();
                        }
                    }
                    stateRecord2.setSnapshotId$runtime_release(0);
                    stateRecord2.assign(firstStateRecord);
                    stateRecord2 = stateRecord;
                }
            }
        }
        return i > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void processForUnusedRecordsLocked(StateObject stateObject) {
        if (overwriteUnusedRecordsLocked(stateObject)) {
            extraStateObjects.add(stateObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void readError() {
        throw new IllegalStateException("Reading a state that was created after the snapshot was taken or in a snapshot that has not yet been applied");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T extends StateRecord> T readable(T t, int i, SnapshotIdSet snapshotIdSet) {
        T t2 = null;
        while (t != null) {
            if (valid(t, i, snapshotIdSet) && (t2 == null || t2.getSnapshotId() < t.getSnapshotId())) {
                t2 = t;
            }
            t = (T) t.getNext();
        }
        if (t2 != null) {
            return t2;
        }
        return null;
    }

    public static final void releasePinningLocked(int i) {
        pinningTable.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void reportReadonlySnapshotWrite() {
        throw new IllegalStateException("Cannot modify a state object in a read-only snapshot");
    }

    @PublishedApi
    public static final <T> T sync(@NotNull Function0<? extends T> function0) {
        T tInvoke;
        synchronized (getLock()) {
            try {
                tInvoke = function0.invoke();
                InlineMarker.finallyStart(1);
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        InlineMarker.finallyEnd(1);
        return tInvoke;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> T takeNewGlobalSnapshot(Snapshot snapshot, Function1<? super SnapshotIdSet, ? extends T> function1) {
        T tInvoke = function1.invoke(openSnapshots.clear(snapshot.getId()));
        synchronized (getLock()) {
            int i = nextSnapshotId;
            nextSnapshotId = i + 1;
            openSnapshots = openSnapshots.clear(snapshot.getId());
            currentGlobalSnapshot.set(new GlobalSnapshot(i, openSnapshots));
            snapshot.dispose();
            openSnapshots = openSnapshots.set(i);
            Unit unit = Unit.INSTANCE;
        }
        return tInvoke;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T extends Snapshot> T takeNewSnapshot(final Function1<? super SnapshotIdSet, ? extends T> function1) {
        return (T) advanceGlobalSnapshot(new Function1<SnapshotIdSet, T>() { // from class: androidx.compose.runtime.snapshots.SnapshotKt.takeNewSnapshot.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            /* JADX WARN: Incorrect return type in method signature: (Landroidx/compose/runtime/snapshots/SnapshotIdSet;)TT; */
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Snapshot invoke(@NotNull SnapshotIdSet snapshotIdSet) {
                Snapshot snapshot = (Snapshot) function1.invoke(snapshotIdSet);
                synchronized (SnapshotKt.getLock()) {
                    SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(snapshot.getId());
                    Unit unit = Unit.INSTANCE;
                }
                return snapshot;
            }
        });
    }

    public static final int trackPinning(int i, @NotNull SnapshotIdSet snapshotIdSet) {
        int iAdd;
        int iLowest = snapshotIdSet.lowest(i);
        synchronized (getLock()) {
            iAdd = pinningTable.add(iLowest);
        }
        return iAdd;
    }

    private static final StateRecord usedLocked(StateObject stateObject) {
        int iLowestOrDefault = pinningTable.lowestOrDefault(nextSnapshotId) - 1;
        SnapshotIdSet empty = SnapshotIdSet.INSTANCE.getEMPTY();
        StateRecord stateRecord = null;
        for (StateRecord firstStateRecord = stateObject.getFirstStateRecord(); firstStateRecord != null; firstStateRecord = firstStateRecord.getNext()) {
            if (firstStateRecord.getSnapshotId() != 0) {
                if (valid(firstStateRecord, iLowestOrDefault, empty)) {
                    if (stateRecord == null) {
                        stateRecord = firstStateRecord;
                    } else if (firstStateRecord.getSnapshotId() >= stateRecord.getSnapshotId()) {
                        return stateRecord;
                    }
                }
            }
            return firstStateRecord;
        }
        return null;
    }

    private static final boolean valid(int i, int i2, SnapshotIdSet snapshotIdSet) {
        return (i2 == 0 || i2 > i || snapshotIdSet.get(i2)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void validateOpen(Snapshot snapshot) {
        int iLowestOrDefault;
        if (openSnapshots.get(snapshot.getId())) {
            return;
        }
        StringBuilder sb = new StringBuilder("Snapshot is not open: id=");
        sb.append(snapshot.getId());
        sb.append(", disposed=");
        sb.append(snapshot.getDisposed());
        sb.append(", applied=");
        MutableSnapshot mutableSnapshot = snapshot instanceof MutableSnapshot ? (MutableSnapshot) snapshot : null;
        sb.append(mutableSnapshot != null ? Boolean.valueOf(mutableSnapshot.getApplied()) : "read-only");
        sb.append(", lowestPin=");
        synchronized (getLock()) {
            iLowestOrDefault = pinningTable.lowestOrDefault(-1);
        }
        sb.append(iLowestOrDefault);
        throw new IllegalStateException(sb.toString().toString());
    }

    public static final <T extends StateRecord, R> R withCurrent(@NotNull T t, @NotNull Function1<? super T, ? extends R> function1) {
        return function1.invoke(current(t));
    }

    public static final <T extends StateRecord, R> R writable(@NotNull T t, @NotNull StateObject stateObject, @NotNull Function1<? super T, ? extends R> function1) {
        Snapshot current;
        R rInvoke;
        getSnapshotInitializer();
        synchronized (getLock()) {
            try {
                current = Snapshot.INSTANCE.getCurrent();
                rInvoke = function1.invoke(writableRecord(t, stateObject, current));
                InlineMarker.finallyStart(1);
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        InlineMarker.finallyEnd(1);
        notifyWrite(current, stateObject);
        return rInvoke;
    }

    @PublishedApi
    @NotNull
    public static final <T extends StateRecord> T writableRecord(@NotNull T t, @NotNull StateObject stateObject, @NotNull Snapshot snapshot) {
        T t2;
        if (snapshot.getReadOnly()) {
            snapshot.mo18114recordModified$runtime_release(stateObject);
        }
        int id = snapshot.getId();
        T t5 = (T) readable(t, id, snapshot.getInvalid());
        if (t5 == null) {
            readError();
            throw new KotlinNothingValueException();
        }
        if (t5.getSnapshotId() == snapshot.getId()) {
            return t5;
        }
        synchronized (getLock()) {
            t2 = (T) readable(stateObject.getFirstStateRecord(), id, snapshot.getInvalid());
            if (t2 == null) {
                readError();
                throw new KotlinNothingValueException();
            }
            if (t2.getSnapshotId() != id) {
                t2 = (T) newWritableRecordLocked(t2, stateObject, snapshot);
            }
        }
        Intrinsics.checkNotNull(t2, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.writableRecord");
        if (t5.getSnapshotId() != 1) {
            snapshot.mo18114recordModified$runtime_release(stateObject);
        }
        return t2;
    }

    @PublishedApi
    @NotNull
    public static final <T extends StateRecord> T current(@NotNull T t) {
        T t2;
        Snapshot.Companion companion = Snapshot.INSTANCE;
        Snapshot current = companion.getCurrent();
        T t5 = (T) readable(t, current.getId(), current.getInvalid());
        if (t5 != null) {
            return t5;
        }
        synchronized (getLock()) {
            Snapshot current2 = companion.getCurrent();
            t2 = (T) readable(t, current2.getId(), current2.getInvalid());
        }
        if (t2 != null) {
            return t2;
        }
        readError();
        throw new KotlinNothingValueException();
    }

    private static final boolean valid(StateRecord stateRecord, int i, SnapshotIdSet snapshotIdSet) {
        return valid(i, stateRecord.getSnapshotId(), snapshotIdSet);
    }

    @NotNull
    public static final <T extends StateRecord> T readable(@NotNull T t, @NotNull StateObject stateObject) {
        T t2;
        Snapshot.Companion companion = Snapshot.INSTANCE;
        Snapshot current = companion.getCurrent();
        Function1<Object, Unit> readObserver = current.getReadObserver();
        if (readObserver != null) {
            readObserver.invoke(stateObject);
        }
        T t5 = (T) readable(t, current.getId(), current.getInvalid());
        if (t5 != null) {
            return t5;
        }
        synchronized (getLock()) {
            Snapshot current2 = companion.getCurrent();
            StateRecord firstStateRecord = stateObject.getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.readable$lambda$9");
            t2 = (T) readable(firstStateRecord, current2.getId(), current2.getInvalid());
            if (t2 == null) {
                readError();
                throw new KotlinNothingValueException();
            }
        }
        return t2;
    }

    public static final <T extends StateRecord, R> R writable(@NotNull T t, @NotNull StateObject stateObject, @NotNull Snapshot snapshot, @NotNull Function1<? super T, ? extends R> function1) {
        R rInvoke;
        synchronized (getLock()) {
            try {
                rInvoke = function1.invoke(writableRecord(t, stateObject, snapshot));
                InlineMarker.finallyStart(1);
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        InlineMarker.finallyEnd(1);
        notifyWrite(snapshot, stateObject);
        return rInvoke;
    }

    @NotNull
    public static final <T extends StateRecord> T readable(@NotNull T t, @NotNull StateObject stateObject, @NotNull Snapshot snapshot) {
        Function1<Object, Unit> readObserver = snapshot.getReadObserver();
        if (readObserver != null) {
            readObserver.invoke(stateObject);
        }
        T t2 = (T) readable(t, snapshot.getId(), snapshot.getInvalid());
        if (t2 != null) {
            return t2;
        }
        readError();
        throw new KotlinNothingValueException();
    }

    @PublishedApi
    public static /* synthetic */ void getLock$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getSnapshotInitializer$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void advanceGlobalSnapshot() {
        advanceGlobalSnapshot(new Function1<SnapshotIdSet, Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotKt.advanceGlobalSnapshot.3
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull SnapshotIdSet snapshotIdSet) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SnapshotIdSet snapshotIdSet) {
                invoke2(snapshotIdSet);
                return Unit.INSTANCE;
            }
        });
    }
}
