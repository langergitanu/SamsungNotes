package androidx.compose.runtime;

import androidx.collection.MutableIntList;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ObjectIntMap;
import androidx.collection.ScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.DerivedState;
import androidx.compose.runtime.changelist.ChangeList;
import androidx.compose.runtime.collection.ScatterSetWrapper;
import androidx.compose.runtime.collection.ScopeMap;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.snapshots.ReaderKind;
import androidx.compose.runtime.snapshots.StateObject;
import androidx.compose.runtime.snapshots.StateObjectImpl;
import androidx.compose.runtime.tooling.CompositionObserver;
import androidx.compose.runtime.tooling.CompositionObserverHandle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.poi.sun.awt.AppContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.TestOnly;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002¥\u0001B%\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\b\u0010X\u001a\u00020\u001aH\u0016J\u0018\u0010Y\u001a\u00020\u001a2\u0006\u0010Z\u001a\u00020,2\u0006\u0010[\u001a\u00020\u0013H\u0002J\u001e\u0010Y\u001a\u00020\u001a2\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020,0+2\u0006\u0010[\u001a\u00020\u0013H\u0002J\b\u0010]\u001a\u00020\u001aH\u0016J\u0010\u0010^\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010_\u001a\u00020\u001aH\u0016J\b\u0010`\u001a\u00020\u001aH\u0016J\b\u0010a\u001a\u00020\u001aH\u0002J \u0010b\u001a\u00020\u001a2\u0011\u0010c\u001a\r\u0012\u0004\u0012\u00020\u001a0\u0019¢\u0006\u0002\b\u001bH\u0016¢\u0006\u0002\u0010\u001fJ \u0010d\u001a\u00020\u001a2\u0011\u0010c\u001a\r\u0012\u0004\u0012\u00020\u001a0\u0019¢\u0006\u0002\b\u001bH\u0002¢\u0006\u0002\u0010\u001fJ\r\u0010e\u001a\u00020:H\u0000¢\u0006\u0002\bfJ\b\u0010g\u001a\u00020\u001aH\u0016J3\u0010h\u001a\u0002Hi\"\u0004\b\u0000\u0010i2\b\u0010j\u001a\u0004\u0018\u00010\u00012\u0006\u0010k\u001a\u00020:2\f\u0010l\u001a\b\u0012\u0004\u0012\u0002Hi0\u0019H\u0016¢\u0006\u0002\u0010mJ\b\u0010n\u001a\u00020\u001aH\u0016J\u0010\u0010o\u001a\u00020\u001a2\u0006\u0010p\u001a\u00020qH\u0016J\b\u0010r\u001a\u00020\u001aH\u0002J\b\u0010s\u001a\u00020\u001aH\u0002J#\u0010t\u001a\u0004\u0018\u0001Hu\"\u0004\b\u0000\u0010u2\f\u0010v\u001a\b\u0012\u0004\u0012\u0002Hu0wH\u0016¢\u0006\u0002\u0010xJ\"\u0010y\u001a\u0002Hu\"\u0004\b\u0000\u0010u2\f\u0010l\u001a\b\u0012\u0004\u0012\u0002Hu0\u0019H\u0082\b¢\u0006\u0002\u0010zJC\u0010{\u001a\u0002Hu\"\u0004\b\u0000\u0010u2-\u0010l\u001a)\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020,00¢\u0006\f\b}\u0012\b\b~\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u0002Hu0|H\u0082\b¢\u0006\u0002\u0010\u007fJ)\u0010\u0080\u0001\u001a\u00020\u001a2\u001e\u0010\u0081\u0001\u001a\u0019\u0012\u0015\u0012\u0013\u0012\u0005\u0012\u00030\u0083\u0001\u0012\u0007\u0012\u0005\u0018\u00010\u0083\u00010\u0082\u00010$H\u0016J\u001e\u0010\u0084\u0001\u001a\u00030\u0085\u00012\u0007\u0010\u0086\u0001\u001a\u00020%2\t\u0010\u0087\u0001\u001a\u0004\u0018\u00010,H\u0016J\t\u0010\u0088\u0001\u001a\u00020\u001aH\u0016J(\u0010\u0089\u0001\u001a\u00030\u0085\u00012\u0007\u0010\u0086\u0001\u001a\u00020%2\b\u0010\u008a\u0001\u001a\u00030\u008b\u00012\t\u0010\u0087\u0001\u001a\u0004\u0018\u00010,H\u0002J\u000f\u0010\u008c\u0001\u001a\u00020\u001a2\u0006\u0010v\u001a\u00020:J\u0011\u0010\u008d\u0001\u001a\u00020\u001a2\u0006\u0010Z\u001a\u00020,H\u0002J\u001a\u0010\u008e\u0001\u001a\u00030\u008f\u00012\b\u0010\u0090\u0001\u001a\u00030\u0091\u0001H\u0000¢\u0006\u0003\b\u0092\u0001J\f\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u0091\u0001H\u0002J\u0017\u0010\u0093\u0001\u001a\u00020\u00132\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020,0+H\u0016J\u0017\u0010\u0094\u0001\u001a\u00020\u001a2\f\u0010l\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0016J\t\u0010\u0095\u0001\u001a\u00020\u0013H\u0016J\u0012\u0010\u0096\u0001\u001a\u00020\u001a2\u0007\u0010\u0086\u0001\u001a\u00020%H\u0016J\u0017\u0010\u0097\u0001\u001a\u00020\u001a2\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020,0+H\u0016J\u0011\u0010\u0098\u0001\u001a\u00020\u001a2\u0006\u0010Z\u001a\u00020,H\u0016J\u0011\u0010\u0099\u0001\u001a\u00020\u001a2\u0006\u0010Z\u001a\u00020,H\u0016J\u001b\u0010\u009a\u0001\u001a\u00020\u001a2\n\u0010p\u001a\u0006\u0012\u0002\b\u000301H\u0000¢\u0006\u0003\b\u009b\u0001J!\u0010\u009c\u0001\u001a\u00020\u001a2\u0007\u0010\u0087\u0001\u001a\u00020,2\u0007\u0010\u0086\u0001\u001a\u00020%H\u0000¢\u0006\u0003\b\u009d\u0001J!\u0010\u009e\u0001\u001a\u00020\u001a2\u0011\u0010c\u001a\r\u0012\u0004\u0012\u00020\u001a0\u0019¢\u0006\u0002\b\u001bH\u0016¢\u0006\u0002\u0010\u001fJ!\u0010\u009f\u0001\u001a\u00020\u001a2\u0011\u0010c\u001a\r\u0012\u0004\u0012\u00020\u001a0\u0019¢\u0006\u0002\b\u001bH\u0016¢\u0006\u0002\u0010\u001fJ\u0015\u0010 \u0001\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020,00H\u0002J#\u0010¡\u0001\u001a\u0002Hu\"\u0004\b\u0000\u0010u2\f\u0010l\u001a\b\u0012\u0004\u0012\u0002Hu0\u0019H\u0082\b¢\u0006\u0002\u0010zJ\u001d\u0010¢\u0001\u001a\u00020\u00132\u0007\u0010\u0086\u0001\u001a\u00020%2\t\u0010\u0087\u0001\u001a\u0004\u0018\u00010,H\u0002J\u0011\u0010£\u0001\u001a\u00020\u001a2\u0006\u0010S\u001a\u00020TH\u0002J\t\u0010¤\u0001\u001a\u00020\u001aH\u0016R\u0010\u0010\f\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R'\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u001a0\u0019¢\u0006\u0002\b\u001bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$8AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020%0)X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+8AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u001e\u0010/\u001a\u0012\u0012\u0004\u0012\u00020,\u0012\b\u0012\u0006\u0012\u0002\b\u00030100X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00103\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b4\u0010\u0015R\u0014\u00105\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b6\u0010\u0015R\u0014\u00107\u001a\b\u0012\u0004\u0012\u00020%0)X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u00010\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010;\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020,00X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010<\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b<\u0010\u0015R\u0014\u0010=\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b=\u0010\u0015R\u0011\u0010>\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\u0015R\u000e\u0010?\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010A\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020%00X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010B\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020%00X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010C\u001a\b\u0012\u0004\u0012\u00020,0+8AX\u0080\u0004¢\u0006\u0006\u001a\u0004\bD\u0010.R\u0014\u0010E\u001a\u00020FX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010I\u001a\u00020\u0013X\u0080\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bJ\u0010\u0011\u001a\u0004\bK\u0010\u0015\"\u0004\bL\u0010MR\"\u0010N\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010,0Oj\n\u0012\u0006\u0012\u0004\u0018\u00010,`PX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\bQ\u0010RR\u001a\u0010S\u001a\u00020TX\u0080\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bU\u0010\u0011\u001a\u0004\bV\u0010W¨\u0006¦\u0001"}, m13886d2 = {"Landroidx/compose/runtime/CompositionImpl;", "Landroidx/compose/runtime/ControlledComposition;", "Landroidx/compose/runtime/ReusableComposition;", "Landroidx/compose/runtime/RecomposeScopeOwner;", "Landroidx/compose/runtime/CompositionServices;", "parent", "Landroidx/compose/runtime/CompositionContext;", "applier", "Landroidx/compose/runtime/Applier;", "recomposeContext", "Lkotlin/coroutines/CoroutineContext;", "(Landroidx/compose/runtime/CompositionContext;Landroidx/compose/runtime/Applier;Lkotlin/coroutines/CoroutineContext;)V", "_recomposeContext", "abandonSet", "", "Landroidx/compose/runtime/RememberObserver;", "getAbandonSet$annotations", "()V", "areChildrenComposing", "", "getAreChildrenComposing", "()Z", "changes", "Landroidx/compose/runtime/changelist/ChangeList;", "composable", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "getComposable", "()Lkotlin/jvm/functions/Function2;", "setComposable", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "composer", "Landroidx/compose/runtime/ComposerImpl;", "conditionalScopes", "", "Landroidx/compose/runtime/RecomposeScopeImpl;", "getConditionalScopes$runtime_release", "()Ljava/util/List;", "conditionallyInvalidatedScopes", "Landroidx/collection/MutableScatterSet;", "derivedStateDependencies", "", "", "getDerivedStateDependencies$runtime_release", "()Ljava/util/Set;", "derivedStates", "Landroidx/compose/runtime/collection/ScopeMap;", "Landroidx/compose/runtime/DerivedState;", AppContext.DISPOSED_PROPERTY_NAME, "hasInvalidations", "getHasInvalidations", "hasPendingChanges", "getHasPendingChanges", "invalidatedScopes", "invalidationDelegate", "invalidationDelegateGroup", "", "invalidations", "isComposing", "isDisposed", "isRoot", "lateChanges", "lock", "observations", "observationsProcessed", "observedObjects", "getObservedObjects$runtime_release", "observerHolder", "Landroidx/compose/runtime/CompositionObserverHolder;", "getObserverHolder$runtime_release", "()Landroidx/compose/runtime/CompositionObserverHolder;", "pendingInvalidScopes", "getPendingInvalidScopes$runtime_release$annotations", "getPendingInvalidScopes$runtime_release", "setPendingInvalidScopes$runtime_release", "(Z)V", "pendingModifications", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/runtime/AtomicReference;", "getRecomposeContext", "()Lkotlin/coroutines/CoroutineContext;", "slotTable", "Landroidx/compose/runtime/SlotTable;", "getSlotTable$runtime_release$annotations", "getSlotTable$runtime_release", "()Landroidx/compose/runtime/SlotTable;", "abandonChanges", "addPendingInvalidationsLocked", "value", "forgetConditionalScopes", "values", "applyChanges", "applyChangesInLocked", "applyLateChanges", "changesApplied", "cleanUpDerivedStateObservations", "composeContent", "content", "composeInitial", "composerStacksSizes", "composerStacksSizes$runtime_release", "deactivate", "delegateInvalidations", "R", "to", "groupIndex", "block", "(Landroidx/compose/runtime/ControlledComposition;ILkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "dispose", "disposeUnusedMovableContent", "state", "Landroidx/compose/runtime/MovableContentState;", "drainPendingModificationsForCompositionLocked", "drainPendingModificationsLocked", "getCompositionService", "T", "key", "Landroidx/compose/runtime/CompositionServiceKey;", "(Landroidx/compose/runtime/CompositionServiceKey;)Ljava/lang/Object;", "guardChanges", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "guardInvalidationsLocked", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "insertMovableContent", "references", "Lkotlin/Pair;", "Landroidx/compose/runtime/MovableContentStateReference;", "invalidate", "Landroidx/compose/runtime/InvalidationResult;", "scope", "instance", "invalidateAll", "invalidateChecked", "anchor", "Landroidx/compose/runtime/Anchor;", "invalidateGroupsWithKey", "invalidateScopeOfLocked", "observe", "Landroidx/compose/runtime/tooling/CompositionObserverHandle;", "observer", "Landroidx/compose/runtime/tooling/CompositionObserver;", "observe$runtime_release", "observesAnyOf", "prepareCompose", "recompose", "recomposeScopeReleased", "recordModificationsOf", "recordReadOf", "recordWriteOf", "removeDerivedStateObservation", "removeDerivedStateObservation$runtime_release", "removeObservation", "removeObservation$runtime_release", "setContent", "setContentWithReuse", "takeInvalidations", "trackAbandonedValues", "tryImminentInvalidation", "validateRecomposeScopeAnchors", "verifyConsistent", "RememberEventDispatcher", "runtime_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nComposition.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Composition.kt\nandroidx/compose/runtime/CompositionImpl\n+ 2 ActualJvm.jvm.kt\nandroidx/compose/runtime/ActualJvm_jvmKt\n+ 3 Preconditions.kt\nandroidx/compose/runtime/PreconditionsKt\n+ 4 ListUtils.kt\nandroidx/compose/runtime/snapshots/ListUtilsKt\n+ 5 SlotTable.kt\nandroidx/compose/runtime/SlotTable\n+ 6 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 7 ScatterSetWrapper.kt\nandroidx/compose/runtime/collection/ScatterSetWrapperKt\n+ 8 ScatterSet.kt\nandroidx/collection/ScatterSet\n+ 9 ScatterMap.kt\nandroidx/collection/ScatterMapKt\n+ 10 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 11 ScopeMap.kt\nandroidx/compose/runtime/collection/ScopeMap\n+ 12 ScatterMap.kt\nandroidx/collection/MutableScatterMap\n+ 13 ScatterMap.kt\nandroidx/collection/ScatterMap\n+ 14 ScatterSet.kt\nandroidx/collection/MutableScatterSet\n+ 15 StateObjectImpl.kt\nandroidx/compose/runtime/snapshots/ReaderKind$Companion\n+ 16 ObjectIntMap.kt\nandroidx/collection/ObjectIntMap\n+ 17 Trace.kt\nandroidx/compose/runtime/TraceKt\n+ 18 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,1504:1\n1055#1,2:1525\n1225#1,3:1527\n1045#1,6:1531\n1228#1,7:1537\n1057#1,4:1544\n1055#1,2:2048\n1225#1,3:2050\n1045#1,6:2053\n1228#1,7:2059\n1057#1,4:2066\n1055#1,2:2079\n1225#1,10:2081\n1057#1,4:2091\n1055#1,2:2188\n1225#1,10:2190\n1057#1,4:2200\n1055#1,2:2205\n1225#1,10:2207\n1057#1,4:2217\n1055#1,2:2222\n1225#1,10:2224\n1057#1,4:2234\n1225#1,10:2238\n89#2:1505\n89#2:1513\n89#2:1514\n89#2:1530\n89#2:1548\n89#2:1565\n89#2:1566\n89#2:2011\n89#2:2047\n89#2:2187\n89#2:2204\n89#2:2221\n89#2:2248\n89#2:2251\n89#2:2252\n89#2:2253\n89#2:2322\n50#3,7:1506\n50#3,7:1549\n50#3,7:2314\n93#4,2:1515\n33#4,4:1517\n95#4,2:1521\n38#4:1523\n97#4:1524\n110#4,2:2070\n33#4,6:2072\n112#4:2078\n33#4,4:2310\n38#4:2321\n175#5,5:1556\n181#5,3:1562\n175#5,5:2095\n181#5,3:2101\n175#5,5:2107\n181#5,3:2113\n175#5,5:2326\n181#5,3:2332\n1#6:1561\n1#6:2100\n1#6:2112\n1#6:2307\n1#6:2331\n48#7,3:1567\n53#7:1596\n55#7:1599\n48#7,3:1635\n53#7:1698\n55#7:1727\n228#8,4:1570\n198#8,7:1574\n209#8,3:1582\n212#8,9:1586\n232#8:1595\n228#8,4:1605\n198#8,7:1609\n209#8,3:1617\n212#8,9:1621\n232#8:1630\n228#8,4:1638\n198#8,7:1642\n209#8,3:1650\n212#8,2:1654\n228#8,4:1661\n198#8,7:1665\n209#8,3:1673\n212#8,9:1677\n232#8:1686\n215#8,6:1691\n232#8:1697\n228#8,4:1700\n198#8,7:1704\n209#8,3:1712\n212#8,9:1716\n232#8:1725\n198#8,7:1751\n209#8,3:1759\n212#8,2:1763\n215#8,6:1769\n198#8,7:1815\n209#8,3:1823\n212#8,2:1827\n215#8,6:1833\n198#8,16:1879\n215#8,6:1899\n198#8,7:1924\n209#8,3:1932\n212#8,2:1936\n215#8,6:1942\n228#8,4:1981\n198#8,7:1985\n209#8,3:1993\n212#8,9:1997\n232#8:2006\n228#8,4:2017\n198#8,7:2021\n209#8,3:2029\n212#8,9:2033\n232#8:2042\n198#8,16:2143\n215#8,6:2163\n228#8,4:2260\n198#8,7:2264\n209#8,3:2272\n212#8,2:2276\n215#8,6:2280\n232#8:2286\n1956#9:1581\n1820#9:1585\n1956#9:1616\n1820#9:1620\n1956#9:1649\n1820#9:1653\n1956#9:1672\n1820#9:1676\n1956#9:1711\n1820#9:1715\n1956#9:1736\n1820#9:1740\n1956#9:1758\n1820#9:1762\n1956#9:1800\n1820#9:1804\n1956#9:1822\n1820#9:1826\n1956#9:1864\n1820#9:1868\n1956#9:1931\n1820#9:1935\n1956#9:1959\n1820#9:1963\n1956#9:1992\n1820#9:1996\n1956#9:2028\n1820#9:2032\n1956#9:2128\n1820#9:2132\n1956#9:2271\n1820#9:2275\n1855#10,2:1597\n1855#10:1699\n1856#10:1726\n77#11,5:1600\n85#11,4:1631\n77#11,5:1656\n85#11,4:1687\n138#11:1728\n139#11,5:1744\n144#11,5:1776\n152#11:1791\n138#11:1792\n139#11,5:1808\n144#11,5:1840\n152#11:1855\n138#11:1856\n139#11,5:1872\n144#11,5:1906\n152#11:1921\n77#11,5:1976\n85#11,4:2007\n77#11,5:2012\n85#11,4:2043\n138#11:2120\n139#11,5:2136\n144#11,5:2170\n152#11:2185\n91#11:2254\n77#11,5:2255\n92#11,2:2278\n85#11,10:2287\n1049#12:1729\n1051#12:1743\n1052#12,3:1781\n1055#12:1790\n1049#12:1793\n1051#12:1807\n1052#12,3:1845\n1055#12:1854\n1049#12:1857\n1051#12:1871\n1052#12,3:1911\n1055#12:1920\n1049#12:2121\n1051#12:2135\n1052#12,3:2175\n1055#12:2184\n365#13,6:1730\n375#13,3:1737\n378#13,2:1741\n381#13,6:1784\n365#13,6:1794\n375#13,3:1801\n378#13,2:1805\n381#13,6:1848\n365#13,6:1858\n375#13,3:1865\n378#13,2:1869\n381#13,6:1914\n365#13,6:2122\n375#13,3:2129\n378#13,2:2133\n381#13,6:2178\n784#14,2:1749\n787#14,4:1765\n791#14:1775\n784#14,2:1813\n787#14,4:1829\n791#14:1839\n784#14,2:1877\n787#14,4:1895\n791#14:1905\n784#14,2:1922\n787#14,4:1938\n791#14:1948\n784#14,2:2141\n787#14,4:2159\n791#14:2169\n51#15:1949\n51#15:1967\n416#16,3:1950\n374#16,6:1953\n384#16,3:1960\n387#16,2:1964\n420#16:1966\n421#16:1968\n390#16,6:1969\n422#16:1975\n46#17,3:2104\n50#17:2116\n46#17,3:2117\n50#17:2186\n46#17,3:2323\n50#17:2335\n13579#18,2:2249\n11653#18,9:2297\n13579#18:2306\n13580#18:2308\n11662#18:2309\n*S KotlinDebug\n*F\n+ 1 Composition.kt\nandroidx/compose/runtime/CompositionImpl\n*L\n731#1:1525,2\n731#1:1527,3\n734#1:1531,6\n731#1:1537,7\n731#1:1544,4\n940#1:2048,2\n940#1:2050,3\n941#1:2053,6\n940#1:2059,7\n940#1:2066,4\n961#1:2079,2\n961#1:2081,10\n961#1:2091,4\n1012#1:2188,2\n1012#1:2190,10\n1012#1:2200,4\n1021#1:2205,2\n1021#1:2207,10\n1021#1:2217,4\n1031#1:2222,2\n1031#1:2224,10\n1031#1:2234,4\n1056#1:2238,10\n632#1:1505\n654#1:1513\n671#1:1514\n732#1:1530\n751#1:1548\n797#1:1565\n818#1:1566\n928#1:2011\n938#1:2047\n1011#1:2187\n1020#1:2204\n1030#1:2221\n1073#1:2248\n1079#1:2251\n1114#1:2252\n1141#1:2253\n1253#1:2322\n647#1:1506,7\n752#1:1549,7\n1215#1:2314,7\n678#1:1515,2\n678#1:1517,4\n678#1:1521,2\n678#1:1523\n678#1:1524\n960#1:2070,2\n960#1:2072,6\n960#1:2078\n1213#1:2310,4\n1213#1:2321\n782#1:1556,5\n782#1:1562,3\n969#1:2095,5\n969#1:2101,3\n983#1:2107,5\n983#1:2113,3\n1260#1:2326,5\n1260#1:2332,3\n782#1:1561\n969#1:2100\n983#1:2112\n1212#1:2307\n1260#1:2331\n828#1:1567,3\n828#1:1596\n828#1:1599\n855#1:1635,3\n855#1:1698\n855#1:1727\n828#1:1570,4\n828#1:1574,7\n828#1:1582,3\n828#1:1586,9\n828#1:1595\n840#1:1605,4\n840#1:1609,7\n840#1:1617,3\n840#1:1621,9\n840#1:1630\n855#1:1638,4\n855#1:1642,7\n855#1:1650,3\n855#1:1654,2\n860#1:1661,4\n860#1:1665,7\n860#1:1673,3\n860#1:1677,9\n860#1:1686\n855#1:1691,6\n855#1:1697\n860#1:1700,4\n860#1:1704,7\n860#1:1712,3\n860#1:1716,9\n860#1:1725\n869#1:1751,7\n869#1:1759,3\n869#1:1763,2\n869#1:1769,6\n875#1:1815,7\n875#1:1823,3\n875#1:1827,2\n875#1:1833,6\n882#1:1879,16\n882#1:1899,6\n884#1:1924,7\n884#1:1932,3\n884#1:1936,2\n884#1:1942,6\n920#1:1981,4\n920#1:1985,7\n920#1:1993,3\n920#1:1997,9\n920#1:2006\n933#1:2017,4\n933#1:2021,7\n933#1:2029,3\n933#1:2033,9\n933#1:2042\n998#1:2143,16\n998#1:2163,6\n1170#1:2260,4\n1170#1:2264,7\n1170#1:2272,3\n1170#1:2276,2\n1170#1:2280,6\n1170#1:2286\n828#1:1581\n828#1:1585\n840#1:1616\n840#1:1620\n855#1:1649\n855#1:1653\n860#1:1672\n860#1:1676\n860#1:1711\n860#1:1715\n869#1:1736\n869#1:1740\n869#1:1758\n869#1:1762\n875#1:1800\n875#1:1804\n875#1:1822\n875#1:1826\n882#1:1864\n882#1:1868\n884#1:1931\n884#1:1935\n905#1:1959\n905#1:1963\n920#1:1992\n920#1:1996\n933#1:2028\n933#1:2032\n998#1:2128\n998#1:2132\n1170#1:2271\n1170#1:2275\n828#1:1597,2\n855#1:1699\n855#1:1726\n840#1:1600,5\n840#1:1631,4\n860#1:1656,5\n860#1:1687,4\n869#1:1728\n869#1:1744,5\n869#1:1776,5\n869#1:1791\n875#1:1792\n875#1:1808,5\n875#1:1840,5\n875#1:1855\n882#1:1856\n882#1:1872,5\n882#1:1906,5\n882#1:1921\n920#1:1976,5\n920#1:2007,4\n933#1:2012,5\n933#1:2043,4\n998#1:2120\n998#1:2136,5\n998#1:2170,5\n998#1:2185\n1170#1:2254\n1170#1:2255,5\n1170#1:2278,2\n1170#1:2287,10\n869#1:1729\n869#1:1743\n869#1:1781,3\n869#1:1790\n875#1:1793\n875#1:1807\n875#1:1845,3\n875#1:1854\n882#1:1857\n882#1:1871\n882#1:1911,3\n882#1:1920\n998#1:2121\n998#1:2135\n998#1:2175,3\n998#1:2184\n869#1:1730,6\n869#1:1737,3\n869#1:1741,2\n869#1:1784,6\n875#1:1794,6\n875#1:1801,3\n875#1:1805,2\n875#1:1848,6\n882#1:1858,6\n882#1:1865,3\n882#1:1869,2\n882#1:1914,6\n998#1:2122,6\n998#1:2129,3\n998#1:2133,2\n998#1:2178,6\n869#1:1749,2\n869#1:1765,4\n869#1:1775\n875#1:1813,2\n875#1:1829,4\n875#1:1839\n882#1:1877,2\n882#1:1895,4\n882#1:1905\n884#1:1922,2\n884#1:1938,4\n884#1:1948\n998#1:2141,2\n998#1:2159,4\n998#1:2169\n896#1:1949\n907#1:1967\n905#1:1950,3\n905#1:1953,6\n905#1:1960,3\n905#1:1964,2\n905#1:1966\n905#1:1968\n905#1:1969,6\n905#1:1975\n979#1:2104,3\n979#1:2116\n996#1:2117,3\n996#1:2186\n1256#1:2323,3\n1256#1:2335\n1074#1:2249,2\n1212#1:2297,9\n1212#1:2306\n1212#1:2308\n1212#1:2309\n*E\n"})
public final class CompositionImpl implements ControlledComposition, ReusableComposition, RecomposeScopeOwner, CompositionServices {
    public static final int $stable = 8;

    @Nullable
    private final CoroutineContext _recomposeContext;

    @NotNull
    private final Set<RememberObserver> abandonSet;

    @NotNull
    private final Applier<?> applier;

    @NotNull
    private final ChangeList changes;

    @NotNull
    private Function2<? super Composer, ? super Integer, Unit> composable;

    @NotNull
    private final ComposerImpl composer;

    @NotNull
    private final MutableScatterSet<RecomposeScopeImpl> conditionallyInvalidatedScopes;

    @NotNull
    private final ScopeMap<Object, DerivedState<?>> derivedStates;
    private boolean disposed;

    @NotNull
    private final MutableScatterSet<RecomposeScopeImpl> invalidatedScopes;

    @Nullable
    private CompositionImpl invalidationDelegate;
    private int invalidationDelegateGroup;

    @NotNull
    private ScopeMap<RecomposeScopeImpl, Object> invalidations;
    private final boolean isRoot;

    @NotNull
    private final ChangeList lateChanges;

    @NotNull
    private final Object lock;

    @NotNull
    private final ScopeMap<Object, RecomposeScopeImpl> observations;

    @NotNull
    private final ScopeMap<Object, RecomposeScopeImpl> observationsProcessed;

    @NotNull
    private final CompositionObserverHolder observerHolder;

    @NotNull
    private final CompositionContext parent;
    private boolean pendingInvalidScopes;

    @NotNull
    private final AtomicReference<Object> pendingModifications;

    @NotNull
    private final SlotTable slotTable;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J(\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J\u0006\u0010\u001a\u001a\u00020\u0013J\u0006\u0010\u001b\u001a\u00020\u0013J\u0006\u0010\u001c\u001a\u00020\u0013J(\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J\u0010\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J(\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0002J(\u0010\r\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J\u0010\u0010\u0010\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0004H\u0016J\u0016\u0010 \u001a\u00020\u00132\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, m13886d2 = {"Landroidx/compose/runtime/CompositionImpl$RememberEventDispatcher;", "Landroidx/compose/runtime/RememberManager;", "abandoning", "", "Landroidx/compose/runtime/RememberObserver;", "(Ljava/util/Set;)V", "afters", "Landroidx/collection/MutableIntList;", "leaving", "", "", "pending", "priorities", "releasing", "Landroidx/collection/MutableScatterSet;", "Landroidx/compose/runtime/ComposeNodeLifecycleCallback;", "remembering", "sideEffects", "Lkotlin/Function0;", "", "deactivating", "instance", "endRelativeOrder", "", "priority", "endRelativeAfter", "dispatchAbandons", "dispatchRememberObservers", "dispatchSideEffects", "forgetting", "processPendingLeaving", "recordLeaving", "sideEffect", "effect", "runtime_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nComposition.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Composition.kt\nandroidx/compose/runtime/CompositionImpl$RememberEventDispatcher\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Trace.kt\nandroidx/compose/runtime/TraceKt\n+ 4 ListUtils.kt\nandroidx/compose/runtime/snapshots/ListUtilsKt\n*L\n1#1,1504:1\n1#2:1505\n46#3,5:1506\n46#3,3:1511\n50#3:1520\n46#3,3:1521\n50#3:1530\n46#3,5:1531\n33#4,6:1514\n33#4,6:1524\n*S KotlinDebug\n*F\n+ 1 Composition.kt\nandroidx/compose/runtime/CompositionImpl$RememberEventDispatcher\n*L\n1339#1:1506,5\n1361#1:1511,3\n1361#1:1520\n1372#1:1521,3\n1372#1:1530\n1383#1:1531,5\n1362#1:1514,6\n1373#1:1524,6\n*E\n"})
    public static final class RememberEventDispatcher implements RememberManager {

        @NotNull
        private final Set<RememberObserver> abandoning;

        @Nullable
        private MutableScatterSet<ComposeNodeLifecycleCallback> releasing;

        @NotNull
        private final List<RememberObserver> remembering = new ArrayList();

        @NotNull
        private final List<Object> leaving = new ArrayList();

        @NotNull
        private final List<Function0<Unit>> sideEffects = new ArrayList();

        @NotNull
        private final List<Object> pending = new ArrayList();

        @NotNull
        private final MutableIntList priorities = new MutableIntList(0, 1, null);

        @NotNull
        private final MutableIntList afters = new MutableIntList(0, 1, null);

        public RememberEventDispatcher(@NotNull Set<RememberObserver> set) {
            this.abandoning = set;
        }

        private final void processPendingLeaving(int endRelativeOrder) {
            if (this.pending.isEmpty()) {
                return;
            }
            int i = 0;
            int i2 = 0;
            List listMutableListOf = null;
            MutableIntList mutableIntList = null;
            MutableIntList mutableIntList2 = null;
            while (i2 < this.afters.getSize()) {
                if (endRelativeOrder <= this.afters.get(i2)) {
                    Object objRemove = this.pending.remove(i2);
                    int iRemoveAt = this.afters.removeAt(i2);
                    int iRemoveAt2 = this.priorities.removeAt(i2);
                    if (listMutableListOf == null) {
                        listMutableListOf = CollectionsKt.mutableListOf(objRemove);
                        mutableIntList2 = new MutableIntList(0, 1, null);
                        mutableIntList2.add(iRemoveAt);
                        mutableIntList = new MutableIntList(0, 1, null);
                        mutableIntList.add(iRemoveAt2);
                    } else {
                        Intrinsics.checkNotNull(mutableIntList, "null cannot be cast to non-null type androidx.collection.MutableIntList");
                        Intrinsics.checkNotNull(mutableIntList2, "null cannot be cast to non-null type androidx.collection.MutableIntList");
                        listMutableListOf.add(objRemove);
                        mutableIntList2.add(iRemoveAt);
                        mutableIntList.add(iRemoveAt2);
                    }
                } else {
                    i2++;
                }
            }
            if (listMutableListOf != null) {
                Intrinsics.checkNotNull(mutableIntList, "null cannot be cast to non-null type androidx.collection.MutableIntList");
                Intrinsics.checkNotNull(mutableIntList2, "null cannot be cast to non-null type androidx.collection.MutableIntList");
                int size = listMutableListOf.size() - 1;
                while (i < size) {
                    int i4 = i + 1;
                    int size2 = listMutableListOf.size();
                    for (int i5 = i4; i5 < size2; i5++) {
                        int i6 = mutableIntList2.get(i);
                        int i7 = mutableIntList2.get(i5);
                        if (i6 < i7 || (i7 == i6 && mutableIntList.get(i) < mutableIntList.get(i5))) {
                            CompositionKt.swap(listMutableListOf, i, i5);
                            CompositionKt.swap(mutableIntList, i, i5);
                            CompositionKt.swap(mutableIntList2, i, i5);
                        }
                    }
                    i = i4;
                }
                this.leaving.addAll(listMutableListOf);
            }
        }

        private final void recordLeaving(Object instance, int endRelativeOrder, int priority, int endRelativeAfter) {
            processPendingLeaving(endRelativeOrder);
            if (endRelativeAfter < 0 || endRelativeAfter >= endRelativeOrder) {
                this.leaving.add(instance);
                return;
            }
            this.pending.add(instance);
            this.priorities.add(priority);
            this.afters.add(endRelativeAfter);
        }

        @Override // androidx.compose.runtime.RememberManager
        public void deactivating(@NotNull ComposeNodeLifecycleCallback instance, int endRelativeOrder, int priority, int endRelativeAfter) {
            recordLeaving(instance, endRelativeOrder, priority, endRelativeAfter);
        }

        public final void dispatchAbandons() {
            if (this.abandoning.isEmpty()) {
                return;
            }
            Object objBeginSection = Trace.INSTANCE.beginSection("Compose:abandons");
            try {
                Iterator<RememberObserver> it = this.abandoning.iterator();
                while (it.hasNext()) {
                    RememberObserver next = it.next();
                    it.remove();
                    next.onAbandoned();
                }
                Unit unit = Unit.INSTANCE;
                Trace.INSTANCE.endSection(objBeginSection);
            } catch (Throwable th) {
                Trace.INSTANCE.endSection(objBeginSection);
                throw th;
            }
        }

        /* JADX WARN: Finally extract failed */
        public final void dispatchRememberObservers() {
            processPendingLeaving(Integer.MIN_VALUE);
            if (!this.leaving.isEmpty()) {
                Object objBeginSection = Trace.INSTANCE.beginSection("Compose:onForgotten");
                try {
                    MutableScatterSet<ComposeNodeLifecycleCallback> mutableScatterSet = this.releasing;
                    for (int size = this.leaving.size() - 1; -1 < size; size--) {
                        Object obj = this.leaving.get(size);
                        if (obj instanceof RememberObserver) {
                            this.abandoning.remove(obj);
                            ((RememberObserver) obj).onForgotten();
                        }
                        if (obj instanceof ComposeNodeLifecycleCallback) {
                            if (mutableScatterSet == null || !mutableScatterSet.contains((ComposeNodeLifecycleCallback) obj)) {
                                ((ComposeNodeLifecycleCallback) obj).onDeactivate();
                            } else {
                                ((ComposeNodeLifecycleCallback) obj).onRelease();
                            }
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                    Trace.INSTANCE.endSection(objBeginSection);
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (this.remembering.isEmpty()) {
                return;
            }
            Object objBeginSection2 = Trace.INSTANCE.beginSection("Compose:onRemembered");
            try {
                List<RememberObserver> list = this.remembering;
                int size2 = list.size();
                for (int i = 0; i < size2; i++) {
                    RememberObserver rememberObserver = list.get(i);
                    this.abandoning.remove(rememberObserver);
                    rememberObserver.onRemembered();
                }
                Unit unit2 = Unit.INSTANCE;
                Trace.INSTANCE.endSection(objBeginSection2);
            } finally {
                Trace.INSTANCE.endSection(objBeginSection2);
            }
        }

        public final void dispatchSideEffects() {
            if (this.sideEffects.isEmpty()) {
                return;
            }
            Object objBeginSection = Trace.INSTANCE.beginSection("Compose:sideeffects");
            try {
                List<Function0<Unit>> list = this.sideEffects;
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    list.get(i).invoke();
                }
                this.sideEffects.clear();
                Unit unit = Unit.INSTANCE;
                Trace.INSTANCE.endSection(objBeginSection);
            } catch (Throwable th) {
                Trace.INSTANCE.endSection(objBeginSection);
                throw th;
            }
        }

        @Override // androidx.compose.runtime.RememberManager
        public void forgetting(@NotNull RememberObserver instance, int endRelativeOrder, int priority, int endRelativeAfter) {
            recordLeaving(instance, endRelativeOrder, priority, endRelativeAfter);
        }

        @Override // androidx.compose.runtime.RememberManager
        public void releasing(@NotNull ComposeNodeLifecycleCallback instance, int endRelativeOrder, int priority, int endRelativeAfter) {
            MutableScatterSet<ComposeNodeLifecycleCallback> mutableScatterSetMutableScatterSetOf = this.releasing;
            if (mutableScatterSetMutableScatterSetOf == null) {
                mutableScatterSetMutableScatterSetOf = ScatterSetKt.mutableScatterSetOf();
                this.releasing = mutableScatterSetMutableScatterSetOf;
            }
            mutableScatterSetMutableScatterSetOf.plusAssign(instance);
            recordLeaving(instance, endRelativeOrder, priority, endRelativeAfter);
        }

        @Override // androidx.compose.runtime.RememberManager
        public void remembering(@NotNull RememberObserver instance) {
            this.remembering.add(instance);
        }

        @Override // androidx.compose.runtime.RememberManager
        public void sideEffect(@NotNull Function0<Unit> effect) {
            this.sideEffects.add(effect);
        }
    }

    public CompositionImpl(@NotNull CompositionContext compositionContext, @NotNull Applier<?> applier, @Nullable CoroutineContext coroutineContext) {
        this.parent = compositionContext;
        this.applier = applier;
        this.pendingModifications = new AtomicReference<>(null);
        this.lock = new Object();
        Set<RememberObserver> setAsMutableSet = new MutableScatterSet(0, 1, null).asMutableSet();
        this.abandonSet = setAsMutableSet;
        SlotTable slotTable = new SlotTable();
        if (compositionContext.getCollectingCallByInformation$runtime_release()) {
            slotTable.collectCalledByInformation();
        }
        if (compositionContext.getCollectingSourceInformation()) {
            slotTable.collectSourceInformation();
        }
        this.slotTable = slotTable;
        this.observations = new ScopeMap<>();
        this.invalidatedScopes = new MutableScatterSet<>(0, 1, null);
        this.conditionallyInvalidatedScopes = new MutableScatterSet<>(0, 1, null);
        this.derivedStates = new ScopeMap<>();
        ChangeList changeList = new ChangeList();
        this.changes = changeList;
        ChangeList changeList2 = new ChangeList();
        this.lateChanges = changeList2;
        this.observationsProcessed = new ScopeMap<>();
        this.invalidations = new ScopeMap<>();
        this.observerHolder = new CompositionObserverHolder(null, false, 3, null);
        ComposerImpl composerImpl = new ComposerImpl(applier, compositionContext, slotTable, setAsMutableSet, changeList, changeList2, this);
        compositionContext.registerComposer$runtime_release(composerImpl);
        this.composer = composerImpl;
        this._recomposeContext = coroutineContext;
        this.isRoot = compositionContext instanceof Recomposer;
        this.composable = ComposableSingletons$CompositionKt.INSTANCE.m17982getLambda1$runtime_release();
    }

    private final void addPendingInvalidationsLocked(Object value, boolean forgetConditionalScopes) {
        Object obj = this.observations.getMap().get(value);
        if (obj == null) {
            return;
        }
        if (!(obj instanceof MutableScatterSet)) {
            RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) obj;
            if (this.observationsProcessed.remove(value, recomposeScopeImpl) || recomposeScopeImpl.invalidateForResult(value) == InvalidationResult.IGNORED) {
                return;
            }
            if (!recomposeScopeImpl.isConditional() || forgetConditionalScopes) {
                this.invalidatedScopes.add(recomposeScopeImpl);
                return;
            } else {
                this.conditionallyInvalidatedScopes.add(recomposeScopeImpl);
                return;
            }
        }
        MutableScatterSet mutableScatterSet = (MutableScatterSet) obj;
        Object[] objArr = mutableScatterSet.elements;
        long[] jArr = mutableScatterSet.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i4 = 0; i4 < i2; i4++) {
                    if ((255 & j) < 128) {
                        RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) objArr[(i << 3) + i4];
                        if (!this.observationsProcessed.remove(value, recomposeScopeImpl2) && recomposeScopeImpl2.invalidateForResult(value) != InvalidationResult.IGNORED) {
                            if (!recomposeScopeImpl2.isConditional() || forgetConditionalScopes) {
                                this.invalidatedScopes.add(recomposeScopeImpl2);
                            } else {
                                this.conditionallyInvalidatedScopes.add(recomposeScopeImpl2);
                            }
                        }
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    private final void applyChangesInLocked(ChangeList changes) throws Throwable {
        RememberEventDispatcher rememberEventDispatcher;
        long[] jArr;
        int i;
        RememberEventDispatcher rememberEventDispatcher2;
        long[] jArr2;
        long j;
        char c;
        long j2;
        int i2;
        boolean zIsEmpty;
        RememberEventDispatcher rememberEventDispatcher3;
        RememberEventDispatcher rememberEventDispatcher4 = new RememberEventDispatcher(this.abandonSet);
        try {
            if (changes.isEmpty()) {
                if (this.lateChanges.isEmpty()) {
                    rememberEventDispatcher4.dispatchAbandons();
                    return;
                }
                return;
            }
            try {
                Trace trace = Trace.INSTANCE;
                Object objBeginSection = trace.beginSection("Compose:applyChanges");
                try {
                    this.applier.onBeginChanges();
                    SlotWriter slotWriterOpenWriter = this.slotTable.openWriter();
                    int i4 = 0;
                    try {
                        changes.executeAndFlushAllPendingChanges(this.applier, slotWriterOpenWriter, rememberEventDispatcher4);
                        Unit unit = Unit.INSTANCE;
                        slotWriterOpenWriter.close(true);
                        this.applier.onEndChanges();
                        trace.endSection(objBeginSection);
                        rememberEventDispatcher4.dispatchRememberObservers();
                        rememberEventDispatcher4.dispatchSideEffects();
                        if (this.pendingInvalidScopes) {
                            Object objBeginSection2 = trace.beginSection("Compose:unobserve");
                            try {
                                this.pendingInvalidScopes = false;
                                MutableScatterMap<Object, Object> map = this.observations.getMap();
                                long[] jArr3 = map.metadata;
                                int length = jArr3.length - 2;
                                if (length >= 0) {
                                    int i5 = 0;
                                    while (true) {
                                        long j3 = jArr3[i5];
                                        char c2 = 7;
                                        long j5 = -9187201950435737472L;
                                        if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                                            int i6 = 8;
                                            int i7 = 8 - ((~(i5 - length)) >>> 31);
                                            int i8 = i4;
                                            while (i8 < i7) {
                                                if ((j3 & 255) < 128) {
                                                    c = c2;
                                                    int i9 = (i5 << 3) + i8;
                                                    j2 = j5;
                                                    Object obj = map.keys[i9];
                                                    Object obj2 = map.values[i9];
                                                    if (obj2 instanceof MutableScatterSet) {
                                                        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$2>");
                                                        MutableScatterSet mutableScatterSet = (MutableScatterSet) obj2;
                                                        Object[] objArr = mutableScatterSet.elements;
                                                        long[] jArr4 = mutableScatterSet.metadata;
                                                        int i10 = i6;
                                                        int length2 = jArr4.length - 2;
                                                        i = i8;
                                                        if (length2 >= 0) {
                                                            jArr2 = jArr3;
                                                            int i11 = 0;
                                                            while (true) {
                                                                long j6 = jArr4[i11];
                                                                j = j3;
                                                                if ((((~j6) << c) & j6 & j2) != j2) {
                                                                    int i12 = 8 - ((~(i11 - length2)) >>> 31);
                                                                    int i13 = 0;
                                                                    while (i13 < i12) {
                                                                        if ((j6 & 255) < 128) {
                                                                            rememberEventDispatcher3 = rememberEventDispatcher4;
                                                                            int i14 = (i11 << 3) + i13;
                                                                            try {
                                                                                if (!((RecomposeScopeImpl) objArr[i14]).getValid()) {
                                                                                    mutableScatterSet.removeElementAt(i14);
                                                                                }
                                                                            } catch (Throwable th) {
                                                                                th = th;
                                                                                Trace.INSTANCE.endSection(objBeginSection2);
                                                                                throw th;
                                                                            }
                                                                        } else {
                                                                            rememberEventDispatcher3 = rememberEventDispatcher4;
                                                                        }
                                                                        j6 >>= i10;
                                                                        i13++;
                                                                        rememberEventDispatcher4 = rememberEventDispatcher3;
                                                                    }
                                                                    rememberEventDispatcher2 = rememberEventDispatcher4;
                                                                    if (i12 != i10) {
                                                                        break;
                                                                    }
                                                                } else {
                                                                    rememberEventDispatcher2 = rememberEventDispatcher4;
                                                                }
                                                                if (i11 == length2) {
                                                                    break;
                                                                }
                                                                i11++;
                                                                j3 = j;
                                                                rememberEventDispatcher4 = rememberEventDispatcher2;
                                                                i10 = 8;
                                                            }
                                                        } else {
                                                            rememberEventDispatcher2 = rememberEventDispatcher4;
                                                            jArr2 = jArr3;
                                                            j = j3;
                                                        }
                                                        zIsEmpty = mutableScatterSet.isEmpty();
                                                    } else {
                                                        i = i8;
                                                        rememberEventDispatcher2 = rememberEventDispatcher4;
                                                        jArr2 = jArr3;
                                                        j = j3;
                                                        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$2");
                                                        zIsEmpty = !((RecomposeScopeImpl) obj2).getValid();
                                                    }
                                                    if (zIsEmpty) {
                                                        map.removeValueAt(i9);
                                                    }
                                                    i2 = 8;
                                                } else {
                                                    i = i8;
                                                    rememberEventDispatcher2 = rememberEventDispatcher4;
                                                    jArr2 = jArr3;
                                                    j = j3;
                                                    c = c2;
                                                    j2 = j5;
                                                    i2 = i6;
                                                }
                                                j3 = j >> i2;
                                                i8 = i + 1;
                                                i6 = i2;
                                                c2 = c;
                                                j5 = j2;
                                                jArr3 = jArr2;
                                                rememberEventDispatcher4 = rememberEventDispatcher2;
                                            }
                                            rememberEventDispatcher = rememberEventDispatcher4;
                                            jArr = jArr3;
                                            if (i7 != i6) {
                                                break;
                                            }
                                        } else {
                                            rememberEventDispatcher = rememberEventDispatcher4;
                                            jArr = jArr3;
                                        }
                                        if (i5 == length) {
                                            break;
                                        }
                                        i5++;
                                        jArr3 = jArr;
                                        rememberEventDispatcher4 = rememberEventDispatcher;
                                        i4 = 0;
                                    }
                                } else {
                                    rememberEventDispatcher = rememberEventDispatcher4;
                                }
                                cleanUpDerivedStateObservations();
                                Unit unit2 = Unit.INSTANCE;
                                Trace.INSTANCE.endSection(objBeginSection2);
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        } else {
                            rememberEventDispatcher = rememberEventDispatcher4;
                        }
                        if (this.lateChanges.isEmpty()) {
                            rememberEventDispatcher.dispatchAbandons();
                            return;
                        }
                        return;
                    } catch (Throwable th3) {
                        try {
                            slotWriterOpenWriter.close(false);
                            throw th3;
                        } catch (Throwable th4) {
                            th = th4;
                            Trace.INSTANCE.endSection(objBeginSection);
                            throw th;
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Throwable th7) {
            th = th7;
        }
        if (this.lateChanges.isEmpty()) {
            rememberEventDispatcher4.dispatchAbandons();
        }
        throw th;
    }

    private final void cleanUpDerivedStateObservations() {
        char c;
        long j;
        long j2;
        long j3;
        long[] jArr;
        long[] jArr2;
        long j5;
        int i;
        char c2;
        long j6;
        long j7;
        int i2;
        boolean zIsEmpty;
        long[] jArr3;
        int i4;
        int i5;
        MutableScatterMap<Object, Object> map = this.derivedStates.getMap();
        long[] jArr4 = map.metadata;
        int length = jArr4.length - 2;
        char c4 = 7;
        long j8 = -9187201950435737472L;
        int i6 = 8;
        if (length >= 0) {
            int i7 = 0;
            long j9 = 128;
            while (true) {
                long j10 = jArr4[i7];
                j2 = 255;
                if ((((~j10) << c4) & j10 & j8) != j8) {
                    int i8 = 8 - ((~(i7 - length)) >>> 31);
                    int i9 = 0;
                    while (i9 < i8) {
                        if ((j10 & 255) < j9) {
                            c2 = c4;
                            int i10 = (i7 << 3) + i9;
                            j6 = j8;
                            Object obj = map.keys[i10];
                            Object obj2 = map.values[i10];
                            if (obj2 instanceof MutableScatterSet) {
                                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$2>");
                                MutableScatterSet mutableScatterSet = (MutableScatterSet) obj2;
                                Object[] objArr = mutableScatterSet.elements;
                                long[] jArr5 = mutableScatterSet.metadata;
                                int length2 = jArr5.length - 2;
                                if (length2 >= 0) {
                                    j7 = j9;
                                    int i11 = 0;
                                    int i12 = i6;
                                    while (true) {
                                        int i13 = length2;
                                        long j11 = jArr5[i11];
                                        j5 = j10;
                                        if ((((~j11) << c2) & j11 & j6) != j6) {
                                            int i14 = 8 - ((~(i11 - i13)) >>> 31);
                                            int i15 = 0;
                                            while (i15 < i14) {
                                                if ((j11 & 255) < j7) {
                                                    jArr3 = jArr4;
                                                    int i16 = (i11 << 3) + i15;
                                                    i4 = i15;
                                                    i5 = i9;
                                                    if (!this.observations.contains((DerivedState) objArr[i16])) {
                                                        mutableScatterSet.removeElementAt(i16);
                                                    }
                                                } else {
                                                    jArr3 = jArr4;
                                                    i4 = i15;
                                                    i5 = i9;
                                                }
                                                j11 >>= i12;
                                                i15 = i4 + 1;
                                                i9 = i5;
                                                jArr4 = jArr3;
                                            }
                                            jArr2 = jArr4;
                                            i = i9;
                                            if (i14 != i12) {
                                                break;
                                            }
                                        } else {
                                            jArr2 = jArr4;
                                            i = i9;
                                        }
                                        length2 = i13;
                                        if (i11 == length2) {
                                            break;
                                        }
                                        i11++;
                                        j10 = j5;
                                        i9 = i;
                                        jArr4 = jArr2;
                                        i12 = 8;
                                    }
                                } else {
                                    jArr2 = jArr4;
                                    j5 = j10;
                                    i = i9;
                                    j7 = j9;
                                }
                                zIsEmpty = mutableScatterSet.isEmpty();
                            } else {
                                jArr2 = jArr4;
                                j5 = j10;
                                i = i9;
                                j7 = j9;
                                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$2");
                                zIsEmpty = !this.observations.contains((DerivedState) obj2);
                            }
                            if (zIsEmpty) {
                                map.removeValueAt(i10);
                            }
                            i2 = 8;
                        } else {
                            jArr2 = jArr4;
                            j5 = j10;
                            i = i9;
                            c2 = c4;
                            j6 = j8;
                            j7 = j9;
                            i2 = i6;
                        }
                        j10 = j5 >> i2;
                        i9 = i + 1;
                        i6 = i2;
                        c4 = c2;
                        j8 = j6;
                        j9 = j7;
                        jArr4 = jArr2;
                    }
                    jArr = jArr4;
                    c = c4;
                    j = j8;
                    j3 = j9;
                    if (i8 != i6) {
                        break;
                    }
                } else {
                    jArr = jArr4;
                    c = c4;
                    j = j8;
                    j3 = j9;
                }
                if (i7 == length) {
                    break;
                }
                i7++;
                c4 = c;
                j8 = j;
                j9 = j3;
                jArr4 = jArr;
                i6 = 8;
            }
        } else {
            c = 7;
            j = -9187201950435737472L;
            j2 = 255;
            j3 = 128;
        }
        if (!this.conditionallyInvalidatedScopes.isNotEmpty()) {
            return;
        }
        MutableScatterSet<RecomposeScopeImpl> mutableScatterSet2 = this.conditionallyInvalidatedScopes;
        Object[] objArr2 = mutableScatterSet2.elements;
        long[] jArr6 = mutableScatterSet2.metadata;
        int length3 = jArr6.length - 2;
        if (length3 < 0) {
            return;
        }
        int i17 = 0;
        while (true) {
            long j12 = jArr6[i17];
            if ((((~j12) << c) & j12 & j) != j) {
                int i18 = 8 - ((~(i17 - length3)) >>> 31);
                for (int i19 = 0; i19 < i18; i19++) {
                    if ((j12 & j2) < j3) {
                        int i20 = (i17 << 3) + i19;
                        if (!((RecomposeScopeImpl) objArr2[i20]).isConditional()) {
                            mutableScatterSet2.removeElementAt(i20);
                        }
                    }
                    j12 >>= 8;
                }
                if (i18 != 8) {
                    return;
                }
            }
            if (i17 == length3) {
                return;
            } else {
                i17++;
            }
        }
    }

    private final void composeInitial(Function2<? super Composer, ? super Integer, Unit> content) {
        if (this.disposed) {
            PreconditionsKt.throwIllegalStateException("The composition is disposed");
        }
        this.composable = content;
        this.parent.composeInitial$runtime_release(this, content);
    }

    private final void drainPendingModificationsForCompositionLocked() {
        Object andSet = this.pendingModifications.getAndSet(CompositionKt.PendingApplyNoModifications);
        if (andSet != null) {
            if (Intrinsics.areEqual(andSet, CompositionKt.PendingApplyNoModifications)) {
                ComposerKt.composeRuntimeError("pending composition has not been applied");
                throw new KotlinNothingValueException();
            }
            if (andSet instanceof Set) {
                addPendingInvalidationsLocked((Set<? extends Object>) andSet, true);
                return;
            }
            if (!(andSet instanceof Object[])) {
                ComposerKt.composeRuntimeError("corrupt pendingModifications drain: " + this.pendingModifications);
                throw new KotlinNothingValueException();
            }
            for (Set<? extends Object> set : (Set[]) andSet) {
                addPendingInvalidationsLocked(set, true);
            }
        }
    }

    private final void drainPendingModificationsLocked() {
        Object andSet = this.pendingModifications.getAndSet(null);
        if (Intrinsics.areEqual(andSet, CompositionKt.PendingApplyNoModifications)) {
            return;
        }
        if (andSet instanceof Set) {
            addPendingInvalidationsLocked((Set<? extends Object>) andSet, false);
            return;
        }
        if (andSet instanceof Object[]) {
            for (Set<? extends Object> set : (Set[]) andSet) {
                addPendingInvalidationsLocked(set, false);
            }
            return;
        }
        if (andSet == null) {
            ComposerKt.composeRuntimeError("calling recordModificationsOf and applyChanges concurrently is not supported");
            throw new KotlinNothingValueException();
        }
        ComposerKt.composeRuntimeError("corrupt pendingModifications drain: " + this.pendingModifications);
        throw new KotlinNothingValueException();
    }

    private final boolean getAreChildrenComposing() {
        return this.composer.getAreChildrenComposing$runtime_release();
    }

    private final <T> T guardChanges(Function0<? extends T> block) throws Exception {
        try {
            try {
                T tInvoke = block.invoke();
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                return tInvoke;
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                if (!this.abandonSet.isEmpty()) {
                    new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                }
                InlineMarker.finallyEnd(1);
                throw th;
            }
        } catch (Exception e) {
            abandonChanges();
            throw e;
        }
    }

    private final <T> T guardInvalidationsLocked(Function1<? super ScopeMap<RecomposeScopeImpl, Object>, ? extends T> block) throws Exception {
        ScopeMap<RecomposeScopeImpl, Object> scopeMapTakeInvalidations = takeInvalidations();
        try {
            return block.invoke(scopeMapTakeInvalidations);
        } catch (Exception e) {
            this.invalidations = scopeMapTakeInvalidations;
            throw e;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00b0 A[Catch: all -> 0x001e, EDGE_INSN: B:66:0x00b0->B:51:0x00b0 BREAK  A[LOOP:0: B:33:0x0067->B:47:0x00a8], EDGE_INSN: B:67:0x00b0->B:51:0x00b0 BREAK  A[LOOP:0: B:33:0x0067->B:47:0x00a8], TRY_LEAVE, TryCatch #0 {all -> 0x001e, blocks: (B:4:0x000b, B:6:0x0010, B:14:0x0023, B:16:0x0029, B:19:0x002d, B:21:0x0033, B:23:0x003e, B:25:0x0042, B:26:0x004b, B:28:0x0057, B:30:0x005b, B:33:0x0067, B:35:0x0077, B:37:0x0083, B:39:0x008d, B:43:0x009c, B:47:0x00a8, B:48:0x00ab, B:51:0x00b0), top: B:64:0x000b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final InvalidationResult invalidateChecked(RecomposeScopeImpl scope, Anchor anchor, Object instance) {
        int i;
        synchronized (this.lock) {
            try {
                CompositionImpl compositionImpl = this.invalidationDelegate;
                CompositionImpl compositionImpl2 = null;
                if (compositionImpl != null) {
                    if (!this.slotTable.groupContainsAnchor(this.invalidationDelegateGroup, anchor)) {
                        compositionImpl = null;
                    }
                    compositionImpl2 = compositionImpl;
                }
                if (compositionImpl2 == null) {
                    if (tryImminentInvalidation(scope, instance)) {
                        return InvalidationResult.IMMINENT;
                    }
                    CompositionObserver compositionObserverObserver = observer();
                    if (instance == null) {
                        this.invalidations.set(scope, ScopeInvalidated.INSTANCE);
                    } else if (compositionObserverObserver != null || (instance instanceof DerivedState)) {
                        Object obj = this.invalidations.getMap().get(scope);
                        if (obj == null) {
                            this.invalidations.add(scope, instance);
                        } else if (obj instanceof MutableScatterSet) {
                            MutableScatterSet mutableScatterSet = (MutableScatterSet) obj;
                            Object[] objArr = mutableScatterSet.elements;
                            long[] jArr = mutableScatterSet.metadata;
                            int length = jArr.length - 2;
                            if (length >= 0) {
                                int i2 = 0;
                                loop0: while (true) {
                                    long j = jArr[i2];
                                    if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                                        int i4 = 8;
                                        int i5 = 8 - ((~(i2 - length)) >>> 31);
                                        int i6 = 0;
                                        while (i6 < i5) {
                                            if ((j & 255) < 128) {
                                                i = i4;
                                                if (objArr[(i2 << 3) + i6] == ScopeInvalidated.INSTANCE) {
                                                    break loop0;
                                                }
                                            } else {
                                                i = i4;
                                            }
                                            j >>= i;
                                            i6++;
                                            i4 = i;
                                        }
                                        if (i5 != i4) {
                                            break;
                                        }
                                        if (i2 == length) {
                                            break;
                                        }
                                        i2++;
                                    }
                                }
                                this.invalidations.add(scope, instance);
                            }
                        } else if (obj == ScopeInvalidated.INSTANCE) {
                        }
                    } else {
                        this.invalidations.set(scope, ScopeInvalidated.INSTANCE);
                    }
                }
                if (compositionImpl2 != null) {
                    return compositionImpl2.invalidateChecked(scope, anchor, instance);
                }
                this.parent.invalidate$runtime_release(this);
                return isComposing() ? InvalidationResult.DEFERRED : InvalidationResult.SCHEDULED;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void invalidateScopeOfLocked(Object value) {
        Object obj = this.observations.getMap().get(value);
        if (obj == null) {
            return;
        }
        if (!(obj instanceof MutableScatterSet)) {
            RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) obj;
            if (recomposeScopeImpl.invalidateForResult(value) == InvalidationResult.IMMINENT) {
                this.observationsProcessed.add(value, recomposeScopeImpl);
                return;
            }
            return;
        }
        MutableScatterSet mutableScatterSet = (MutableScatterSet) obj;
        Object[] objArr = mutableScatterSet.elements;
        long[] jArr = mutableScatterSet.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i4 = 0; i4 < i2; i4++) {
                    if ((255 & j) < 128) {
                        RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) objArr[(i << 3) + i4];
                        if (recomposeScopeImpl2.invalidateForResult(value) == InvalidationResult.IMMINENT) {
                            this.observationsProcessed.add(value, recomposeScopeImpl2);
                        }
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    private final CompositionObserver observer() {
        CompositionObserverHolder compositionObserverHolder = this.observerHolder;
        if (compositionObserverHolder.getRoot()) {
            return compositionObserverHolder.getObserver();
        }
        CompositionObserverHolder observerHolder$runtime_release = this.parent.getObserverHolder();
        CompositionObserver observer = observerHolder$runtime_release != null ? observerHolder$runtime_release.getObserver() : null;
        if (!Intrinsics.areEqual(observer, compositionObserverHolder.getObserver())) {
            compositionObserverHolder.setObserver(observer);
        }
        return observer;
    }

    private final ScopeMap<RecomposeScopeImpl, Object> takeInvalidations() {
        ScopeMap<RecomposeScopeImpl, Object> scopeMap = this.invalidations;
        this.invalidations = new ScopeMap<>();
        return scopeMap;
    }

    private final <T> T trackAbandonedValues(Function0<? extends T> block) {
        try {
            T tInvoke = block.invoke();
            InlineMarker.finallyStart(1);
            InlineMarker.finallyEnd(1);
            return tInvoke;
        } catch (Throwable th) {
            InlineMarker.finallyStart(1);
            if (!this.abandonSet.isEmpty()) {
                new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
            }
            InlineMarker.finallyEnd(1);
            throw th;
        }
    }

    private final boolean tryImminentInvalidation(RecomposeScopeImpl scope, Object instance) {
        return isComposing() && this.composer.tryImminentInvalidation$runtime_release(scope, instance);
    }

    private final void validateRecomposeScopeAnchors(SlotTable slotTable) {
        Object[] slots = slotTable.getSlots();
        ArrayList arrayList = new ArrayList();
        for (Object obj : slots) {
            RecomposeScopeImpl recomposeScopeImpl = obj instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) obj : null;
            if (recomposeScopeImpl != null) {
                arrayList.add(recomposeScopeImpl);
            }
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) arrayList.get(i);
            Anchor anchor = recomposeScopeImpl2.getAnchor();
            if (anchor != null && !slotTable.slotsOf$runtime_release(anchor.toIndexFor(slotTable)).contains(recomposeScopeImpl2)) {
                PreconditionsKt.throwIllegalStateException("Misaligned anchor " + anchor + " in scope " + recomposeScopeImpl2 + " encountered, scope found at " + ArraysKt.indexOf((RecomposeScopeImpl[]) slotTable.getSlots(), recomposeScopeImpl2));
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void abandonChanges() {
        this.pendingModifications.set(null);
        this.changes.clear();
        this.lateChanges.clear();
        if (this.abandonSet.isEmpty()) {
            return;
        }
        new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void applyChanges() {
        synchronized (this.lock) {
            try {
                applyChangesInLocked(this.changes);
                drainPendingModificationsLocked();
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                try {
                    try {
                        if (!this.abandonSet.isEmpty()) {
                            new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                        }
                        throw th;
                    } catch (Exception e) {
                        abandonChanges();
                        throw e;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void applyLateChanges() {
        synchronized (this.lock) {
            try {
                if (this.lateChanges.isNotEmpty()) {
                    applyChangesInLocked(this.lateChanges);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                try {
                    try {
                        if (!this.abandonSet.isEmpty()) {
                            new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                        }
                        throw th;
                    } catch (Exception e) {
                        abandonChanges();
                        throw e;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void changesApplied() {
        synchronized (this.lock) {
            try {
                this.composer.changesApplied$runtime_release();
                if (!this.abandonSet.isEmpty()) {
                    new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                try {
                    try {
                        if (!this.abandonSet.isEmpty()) {
                            new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                        }
                        throw th;
                    } catch (Exception e) {
                        abandonChanges();
                        throw e;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void composeContent(@NotNull Function2<? super Composer, ? super Integer, Unit> content) {
        ScopeMap<RecomposeScopeImpl, Object> scopeMapTakeInvalidations;
        try {
            synchronized (this.lock) {
                try {
                    drainPendingModificationsForCompositionLocked();
                    scopeMapTakeInvalidations = takeInvalidations();
                    CompositionObserver compositionObserverObserver = observer();
                    if (compositionObserverObserver != null) {
                        Map<RecomposeScopeImpl, Set<Object>> mapAsMap = scopeMapTakeInvalidations.asMap();
                        Intrinsics.checkNotNull(mapAsMap, "null cannot be cast to non-null type kotlin.collections.Map<androidx.compose.runtime.RecomposeScope, kotlin.collections.Set<kotlin.Any>?>");
                        compositionObserverObserver.onBeginComposition(this, mapAsMap);
                    }
                    this.composer.composeContent$runtime_release(scopeMapTakeInvalidations, content);
                    if (compositionObserverObserver != null) {
                        compositionObserverObserver.onEndComposition(this);
                        Unit unit = Unit.INSTANCE;
                    }
                } catch (Exception e) {
                    this.invalidations = scopeMapTakeInvalidations;
                    throw e;
                } finally {
                }
            }
        } finally {
        }
    }

    public final int composerStacksSizes$runtime_release() {
        return this.composer.stacksSize$runtime_release();
    }

    @Override // androidx.compose.runtime.ReusableComposition
    public void deactivate() {
        synchronized (this.lock) {
            try {
                boolean z = this.slotTable.getGroupsSize() > 0;
                if (z || !this.abandonSet.isEmpty()) {
                    Trace trace = Trace.INSTANCE;
                    Object objBeginSection = trace.beginSection("Compose:deactivate");
                    try {
                        RememberEventDispatcher rememberEventDispatcher = new RememberEventDispatcher(this.abandonSet);
                        if (z) {
                            this.applier.onBeginChanges();
                            SlotWriter slotWriterOpenWriter = this.slotTable.openWriter();
                            try {
                                ComposerKt.deactivateCurrentGroup(slotWriterOpenWriter, rememberEventDispatcher);
                                Unit unit = Unit.INSTANCE;
                                slotWriterOpenWriter.close(true);
                                this.applier.onEndChanges();
                                rememberEventDispatcher.dispatchRememberObservers();
                            } catch (Throwable th) {
                                slotWriterOpenWriter.close(false);
                                throw th;
                            }
                        }
                        rememberEventDispatcher.dispatchAbandons();
                        Unit unit2 = Unit.INSTANCE;
                        trace.endSection(objBeginSection);
                    } catch (Throwable th2) {
                        Trace.INSTANCE.endSection(objBeginSection);
                        throw th2;
                    }
                }
                this.observations.clear();
                this.derivedStates.clear();
                this.invalidations.clear();
                this.changes.clear();
                this.lateChanges.clear();
                this.composer.deactivate$runtime_release();
                Unit unit3 = Unit.INSTANCE;
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public <R> R delegateInvalidations(@Nullable ControlledComposition to, int groupIndex, @NotNull Function0<? extends R> block) {
        if (to == null || Intrinsics.areEqual(to, this) || groupIndex < 0) {
            return block.invoke();
        }
        this.invalidationDelegate = (CompositionImpl) to;
        this.invalidationDelegateGroup = groupIndex;
        try {
            return block.invoke();
        } finally {
            this.invalidationDelegate = null;
            this.invalidationDelegateGroup = 0;
        }
    }

    @Override // androidx.compose.runtime.Composition
    public void dispose() {
        synchronized (this.lock) {
            try {
                if (this.composer.getIsComposing()) {
                    PreconditionsKt.throwIllegalStateException("Composition is disposed while composing. If dispose is triggered by a call in @Composable function, consider wrapping it with SideEffect block.");
                }
                if (!this.disposed) {
                    this.disposed = true;
                    this.composable = ComposableSingletons$CompositionKt.INSTANCE.m17983getLambda2$runtime_release();
                    ChangeList deferredChanges$runtime_release = this.composer.getDeferredChanges();
                    if (deferredChanges$runtime_release != null) {
                        applyChangesInLocked(deferredChanges$runtime_release);
                    }
                    boolean z = this.slotTable.getGroupsSize() > 0;
                    if (z || !this.abandonSet.isEmpty()) {
                        RememberEventDispatcher rememberEventDispatcher = new RememberEventDispatcher(this.abandonSet);
                        if (z) {
                            this.applier.onBeginChanges();
                            SlotWriter slotWriterOpenWriter = this.slotTable.openWriter();
                            try {
                                ComposerKt.removeCurrentGroup(slotWriterOpenWriter, rememberEventDispatcher);
                                Unit unit = Unit.INSTANCE;
                                slotWriterOpenWriter.close(true);
                                this.applier.clear();
                                this.applier.onEndChanges();
                                rememberEventDispatcher.dispatchRememberObservers();
                            } catch (Throwable th) {
                                slotWriterOpenWriter.close(false);
                                throw th;
                            }
                        }
                        rememberEventDispatcher.dispatchAbandons();
                    }
                    this.composer.dispose$runtime_release();
                }
                Unit unit2 = Unit.INSTANCE;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        this.parent.unregisterComposition$runtime_release(this);
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void disposeUnusedMovableContent(@NotNull MovableContentState state) {
        RememberEventDispatcher rememberEventDispatcher = new RememberEventDispatcher(this.abandonSet);
        SlotWriter slotWriterOpenWriter = state.getSlotTable().openWriter();
        try {
            ComposerKt.removeCurrentGroup(slotWriterOpenWriter, rememberEventDispatcher);
            Unit unit = Unit.INSTANCE;
            slotWriterOpenWriter.close(true);
            rememberEventDispatcher.dispatchRememberObservers();
        } catch (Throwable th) {
            slotWriterOpenWriter.close(false);
            throw th;
        }
    }

    @NotNull
    public final Function2<Composer, Integer, Unit> getComposable() {
        return this.composable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.runtime.CompositionServices
    @Nullable
    public <T> T getCompositionService(@NotNull CompositionServiceKey<T> key) {
        if (Intrinsics.areEqual(key, CompositionKt.getCompositionImplServiceKey())) {
            return this;
        }
        return null;
    }

    @TestOnly
    @NotNull
    public final List<RecomposeScopeImpl> getConditionalScopes$runtime_release() {
        return CollectionsKt.toList(this.conditionallyInvalidatedScopes.asSet());
    }

    @TestOnly
    @NotNull
    public final Set<Object> getDerivedStateDependencies$runtime_release() {
        return this.derivedStates.getMap().asMap().keySet();
    }

    @Override // androidx.compose.runtime.Composition
    public boolean getHasInvalidations() {
        boolean z;
        synchronized (this.lock) {
            z = this.invalidations.getSize() > 0;
        }
        return z;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public boolean getHasPendingChanges() {
        boolean hasPendingChanges$runtime_release;
        synchronized (this.lock) {
            hasPendingChanges$runtime_release = this.composer.getHasPendingChanges$runtime_release();
        }
        return hasPendingChanges$runtime_release;
    }

    @TestOnly
    @NotNull
    public final Set<Object> getObservedObjects$runtime_release() {
        return this.observations.getMap().asMap().keySet();
    }

    @NotNull
    /* JADX INFO: renamed from: getObserverHolder$runtime_release, reason: from getter */
    public final CompositionObserverHolder getObserverHolder() {
        return this.observerHolder;
    }

    /* JADX INFO: renamed from: getPendingInvalidScopes$runtime_release, reason: from getter */
    public final boolean getPendingInvalidScopes() {
        return this.pendingInvalidScopes;
    }

    @NotNull
    public final CoroutineContext getRecomposeContext() {
        CoroutineContext coroutineContext = this._recomposeContext;
        return coroutineContext == null ? this.parent.getRecomposeCoroutineContext$runtime_release() : coroutineContext;
    }

    @NotNull
    /* JADX INFO: renamed from: getSlotTable$runtime_release, reason: from getter */
    public final SlotTable getSlotTable() {
        return this.slotTable;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void insertMovableContent(@NotNull List<Pair<MovableContentStateReference, MovableContentStateReference>> references) {
        int size = references.size();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= size) {
                z = true;
                break;
            } else if (!Intrinsics.areEqual(references.get(i).getFirst().getComposition(), this)) {
                break;
            } else {
                i++;
            }
        }
        ComposerKt.runtimeCheck(z);
        try {
            this.composer.insertMovableContentReferences(references);
            Unit unit = Unit.INSTANCE;
        } finally {
        }
    }

    @Override // androidx.compose.runtime.RecomposeScopeOwner
    @NotNull
    public InvalidationResult invalidate(@NotNull RecomposeScopeImpl scope, @Nullable Object instance) {
        CompositionImpl compositionImpl;
        if (scope.getDefaultsInScope()) {
            scope.setDefaultsInvalid(true);
        }
        Anchor anchor = scope.getAnchor();
        if (anchor == null || !anchor.getValid()) {
            return InvalidationResult.IGNORED;
        }
        if (this.slotTable.ownsAnchor(anchor)) {
            return !scope.getCanRecompose() ? InvalidationResult.IGNORED : invalidateChecked(scope, anchor, instance);
        }
        synchronized (this.lock) {
            compositionImpl = this.invalidationDelegate;
        }
        return (compositionImpl == null || !compositionImpl.tryImminentInvalidation(scope, instance)) ? InvalidationResult.IGNORED : InvalidationResult.IMMINENT;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void invalidateAll() {
        synchronized (this.lock) {
            try {
                for (Object obj : this.slotTable.getSlots()) {
                    RecomposeScopeImpl recomposeScopeImpl = obj instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) obj : null;
                    if (recomposeScopeImpl != null) {
                        recomposeScopeImpl.invalidate();
                    }
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void invalidateGroupsWithKey(int key) {
        List<RecomposeScopeImpl> listInvalidateGroupsWithKey$runtime_release;
        synchronized (this.lock) {
            listInvalidateGroupsWithKey$runtime_release = this.slotTable.invalidateGroupsWithKey$runtime_release(key);
        }
        if (listInvalidateGroupsWithKey$runtime_release != null) {
            int size = listInvalidateGroupsWithKey$runtime_release.size();
            for (int i = 0; i < size; i++) {
                if (listInvalidateGroupsWithKey$runtime_release.get(i).invalidateForResult(null) != InvalidationResult.IGNORED) {
                }
            }
            return;
        }
        if (this.composer.forceRecomposeScopes$runtime_release()) {
            this.parent.invalidate$runtime_release(this);
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public boolean isComposing() {
        return this.composer.getIsComposing();
    }

    @Override // androidx.compose.runtime.Composition
    /* JADX INFO: renamed from: isDisposed, reason: from getter */
    public boolean getDisposed() {
        return this.disposed;
    }

    /* JADX INFO: renamed from: isRoot, reason: from getter */
    public final boolean getIsRoot() {
        return this.isRoot;
    }

    @NotNull
    public final CompositionObserverHandle observe$runtime_release(@NotNull final CompositionObserver observer) {
        synchronized (this.lock) {
            this.observerHolder.setObserver(observer);
            this.observerHolder.setRoot(true);
            Unit unit = Unit.INSTANCE;
        }
        return new CompositionObserverHandle() { // from class: androidx.compose.runtime.CompositionImpl$observe$2
            @Override // androidx.compose.runtime.tooling.CompositionObserverHandle
            public void dispose() {
                Object obj = this.this$0.lock;
                CompositionImpl compositionImpl = this.this$0;
                CompositionObserver compositionObserver = observer;
                synchronized (obj) {
                    try {
                        if (Intrinsics.areEqual(compositionImpl.getObserverHolder().getObserver(), compositionObserver)) {
                            compositionImpl.getObserverHolder().setObserver(null);
                            compositionImpl.getObserverHolder().setRoot(false);
                        }
                        Unit unit2 = Unit.INSTANCE;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        };
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0050, code lost:
    
        return true;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0057  */
    @Override // androidx.compose.runtime.ControlledComposition
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean observesAnyOf(@NotNull Set<? extends Object> values) {
        if (values instanceof ScatterSetWrapper) {
            ScatterSet set$runtime_release = ((ScatterSetWrapper) values).getSet$runtime_release();
            Object[] objArr = set$runtime_release.elements;
            long[] jArr = set$runtime_release.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i = 0;
                loop0: while (true) {
                    long j = jArr[i];
                    if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i2 = 8 - ((~(i - length)) >>> 31);
                        for (int i4 = 0; i4 < i2; i4++) {
                            if ((255 & j) < 128) {
                                Object obj = objArr[(i << 3) + i4];
                                if (this.observations.contains(obj) || this.derivedStates.contains(obj)) {
                                    break loop0;
                                }
                            }
                            j >>= 8;
                        }
                        if (i2 != 8) {
                            break;
                        }
                        if (i == length) {
                            break;
                        }
                        i++;
                    }
                }
            }
        } else {
            for (Object obj2 : values) {
                if (this.observations.contains(obj2) || this.derivedStates.contains(obj2)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void prepareCompose(@NotNull Function0<Unit> block) {
        this.composer.prepareCompose$runtime_release(block);
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public boolean recompose() {
        boolean zRecompose$runtime_release;
        synchronized (this.lock) {
            try {
                drainPendingModificationsForCompositionLocked();
                try {
                    ScopeMap<RecomposeScopeImpl, Object> scopeMapTakeInvalidations = takeInvalidations();
                    try {
                        CompositionObserver compositionObserverObserver = observer();
                        if (compositionObserverObserver != null) {
                            Map<RecomposeScopeImpl, Set<Object>> mapAsMap = scopeMapTakeInvalidations.asMap();
                            Intrinsics.checkNotNull(mapAsMap, "null cannot be cast to non-null type kotlin.collections.Map<androidx.compose.runtime.RecomposeScope, kotlin.collections.Set<kotlin.Any>?>");
                            compositionObserverObserver.onBeginComposition(this, mapAsMap);
                        }
                        zRecompose$runtime_release = this.composer.recompose$runtime_release(scopeMapTakeInvalidations);
                        if (!zRecompose$runtime_release) {
                            drainPendingModificationsLocked();
                        }
                        if (compositionObserverObserver != null) {
                            compositionObserverObserver.onEndComposition(this);
                        }
                    } catch (Exception e) {
                        this.invalidations = scopeMapTakeInvalidations;
                        throw e;
                    }
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zRecompose$runtime_release;
    }

    @Override // androidx.compose.runtime.RecomposeScopeOwner
    public void recomposeScopeReleased(@NotNull RecomposeScopeImpl scope) {
        this.pendingInvalidScopes = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.runtime.ControlledComposition
    public void recordModificationsOf(@NotNull Set<? extends Object> values) {
        Object obj;
        boolean z;
        Object objPlus;
        do {
            obj = this.pendingModifications.get();
            z = true;
            if (obj == null ? true : Intrinsics.areEqual(obj, CompositionKt.PendingApplyNoModifications)) {
                objPlus = values;
            } else if (obj instanceof Set) {
                objPlus = new Set[]{obj, values};
            } else {
                if (!(obj instanceof Object[])) {
                    throw new IllegalStateException(("corrupt pendingModifications: " + this.pendingModifications).toString());
                }
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.collections.Set<kotlin.Any>>");
                objPlus = ArraysKt___ArraysJvmKt.plus((Set<? extends Object>[]) ((Set[]) ((Set[]) obj)), values);
            }
            AtomicReference<Object> atomicReference = this.pendingModifications;
            while (true) {
                if (atomicReference.compareAndSet(obj, objPlus)) {
                    break;
                } else if (atomicReference.get() != obj) {
                    z = false;
                    break;
                }
            }
        } while (!z);
        if (obj == null) {
            synchronized (this.lock) {
                drainPendingModificationsLocked();
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition, androidx.compose.runtime.RecomposeScopeOwner
    public void recordReadOf(@NotNull Object value) {
        RecomposeScopeImpl currentRecomposeScope$runtime_release;
        int i;
        int i2;
        int i4;
        if (getAreChildrenComposing() || (currentRecomposeScope$runtime_release = this.composer.getCurrentRecomposeScope$runtime_release()) == null) {
            return;
        }
        int i5 = 1;
        currentRecomposeScope$runtime_release.setUsed(true);
        if (currentRecomposeScope$runtime_release.recordRead(value)) {
            return;
        }
        if (value instanceof StateObjectImpl) {
            ((StateObjectImpl) value).m18129recordReadInh_f27i8$runtime_release(ReaderKind.m18116constructorimpl(1));
        }
        this.observations.add(value, currentRecomposeScope$runtime_release);
        if (value instanceof DerivedState) {
            DerivedState<?> derivedState = (DerivedState) value;
            DerivedState.Record<?> currentRecord = derivedState.getCurrentRecord();
            this.derivedStates.removeScope(value);
            ObjectIntMap<StateObject> dependencies = currentRecord.getDependencies();
            Object[] objArr = dependencies.keys;
            long[] jArr = dependencies.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i6 = 0;
                while (true) {
                    long j = jArr[i6];
                    if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i7 = 8;
                        int i8 = 8 - ((~(i6 - length)) >>> 31);
                        int i9 = 0;
                        while (i9 < i8) {
                            if ((j & 255) < 128) {
                                i2 = i5;
                                StateObject stateObject = (StateObject) objArr[(i6 << 3) + i9];
                                if (stateObject instanceof StateObjectImpl) {
                                    i4 = i7;
                                    ((StateObjectImpl) stateObject).m18129recordReadInh_f27i8$runtime_release(ReaderKind.m18116constructorimpl(i2));
                                } else {
                                    i4 = i7;
                                }
                                this.derivedStates.add(stateObject, value);
                            } else {
                                i2 = i5;
                                i4 = i7;
                            }
                            j >>= i4;
                            i9++;
                            i5 = i2;
                            i7 = i4;
                        }
                        i = i5;
                        if (i8 != i7) {
                            break;
                        }
                    } else {
                        i = i5;
                    }
                    if (i6 == length) {
                        break;
                    }
                    i6++;
                    i5 = i;
                }
            }
            currentRecomposeScope$runtime_release.recordDerivedStateValue(derivedState, currentRecord.getCurrentValue());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005b  */
    @Override // androidx.compose.runtime.ControlledComposition
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void recordWriteOf(@NotNull Object value) {
        synchronized (this.lock) {
            try {
                invalidateScopeOfLocked(value);
                Object obj = this.derivedStates.getMap().get(value);
                if (obj != null) {
                    if (obj instanceof MutableScatterSet) {
                        MutableScatterSet mutableScatterSet = (MutableScatterSet) obj;
                        Object[] objArr = mutableScatterSet.elements;
                        long[] jArr = mutableScatterSet.metadata;
                        int length = jArr.length - 2;
                        if (length >= 0) {
                            int i = 0;
                            while (true) {
                                long j = jArr[i];
                                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                                    int i2 = 8 - ((~(i - length)) >>> 31);
                                    for (int i4 = 0; i4 < i2; i4++) {
                                        if ((255 & j) < 128) {
                                            invalidateScopeOfLocked((DerivedState) objArr[(i << 3) + i4]);
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
                    } else {
                        invalidateScopeOfLocked((DerivedState) obj);
                    }
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void removeDerivedStateObservation$runtime_release(@NotNull DerivedState<?> state) {
        if (this.observations.contains(state)) {
            return;
        }
        this.derivedStates.removeScope(state);
    }

    public final void removeObservation$runtime_release(@NotNull Object instance, @NotNull RecomposeScopeImpl scope) {
        this.observations.remove(instance, scope);
    }

    public final void setComposable(@NotNull Function2<? super Composer, ? super Integer, Unit> function2) {
        this.composable = function2;
    }

    @Override // androidx.compose.runtime.Composition
    public void setContent(@NotNull Function2<? super Composer, ? super Integer, Unit> content) {
        composeInitial(content);
    }

    @Override // androidx.compose.runtime.ReusableComposition
    public void setContentWithReuse(@NotNull Function2<? super Composer, ? super Integer, Unit> content) {
        this.composer.startReuseFromRoot();
        composeInitial(content);
        this.composer.endReuseFromRoot();
    }

    public final void setPendingInvalidScopes$runtime_release(boolean z) {
        this.pendingInvalidScopes = z;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void verifyConsistent() {
        synchronized (this.lock) {
            try {
                if (!isComposing()) {
                    this.composer.verifyConsistent$runtime_release();
                    this.slotTable.verifyWellFormed();
                    validateRecomposeScopeAnchors(this.slotTable);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static /* synthetic */ void getAbandonSet$annotations() {
    }

    public static /* synthetic */ void getPendingInvalidScopes$runtime_release$annotations() {
    }

    public static /* synthetic */ void getSlotTable$runtime_release$annotations() {
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0353  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x017e A[EDGE_INSN: B:70:0x017e->B:219:0x0117 BREAK  A[LOOP:13: B:60:0x014c->B:71:0x0180]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void addPendingInvalidationsLocked(Set<? extends Object> values, boolean forgetConditionalScopes) {
        char c;
        long j;
        long j2;
        long j3;
        int i;
        long[] jArr;
        String str;
        long[] jArr2;
        String str2;
        long j5;
        boolean zContains;
        long j6;
        long[] jArr3;
        int i2;
        long[] jArr4;
        int i4;
        int i5;
        long j7;
        boolean zIsEmpty;
        int i6;
        long j8;
        long j9;
        char c2;
        long j10;
        int i7;
        int i8;
        int i9;
        Object obj = null;
        char c4 = 7;
        long j11 = -9187201950435737472L;
        int i10 = 8;
        if (values instanceof ScatterSetWrapper) {
            ScatterSet set$runtime_release = ((ScatterSetWrapper) values).getSet$runtime_release();
            Object[] objArr = set$runtime_release.elements;
            long[] jArr5 = set$runtime_release.metadata;
            int length = jArr5.length - 2;
            if (length >= 0) {
                int i11 = 0;
                j2 = 128;
                while (true) {
                    long j12 = jArr5[i11];
                    j3 = 255;
                    if ((((~j12) << c4) & j12 & j11) != j11) {
                        int i12 = 8 - ((~(i11 - length)) >>> 31);
                        int i13 = 0;
                        while (i13 < i12) {
                            if ((j12 & 255) < 128) {
                                c2 = c4;
                                Object obj2 = objArr[(i11 << 3) + i13];
                                j10 = j11;
                                if (obj2 instanceof RecomposeScopeImpl) {
                                    ((RecomposeScopeImpl) obj2).invalidateForResult(obj);
                                } else {
                                    addPendingInvalidationsLocked(obj2, forgetConditionalScopes);
                                    Object obj3 = this.derivedStates.getMap().get(obj2);
                                    if (obj3 != null) {
                                        if (obj3 instanceof MutableScatterSet) {
                                            MutableScatterSet mutableScatterSet = (MutableScatterSet) obj3;
                                            Object[] objArr2 = mutableScatterSet.elements;
                                            long[] jArr6 = mutableScatterSet.metadata;
                                            int length2 = jArr6.length - 2;
                                            if (length2 >= 0) {
                                                j9 = j12;
                                                int i14 = 0;
                                                while (true) {
                                                    long j13 = jArr6[i14];
                                                    int i15 = i10;
                                                    i7 = length;
                                                    if ((((~j13) << c2) & j13 & j10) != j10) {
                                                        int i16 = 8 - ((~(i14 - length2)) >>> 31);
                                                        int i17 = 0;
                                                        while (i17 < i16) {
                                                            if ((j13 & 255) < 128) {
                                                                i9 = i15;
                                                                addPendingInvalidationsLocked((DerivedState) objArr2[(i14 << 3) + i17], forgetConditionalScopes);
                                                            } else {
                                                                i9 = i15;
                                                            }
                                                            j13 >>= i9;
                                                            i17++;
                                                            i15 = i9;
                                                        }
                                                        if (i16 != i15) {
                                                            break;
                                                        }
                                                        if (i14 == length2) {
                                                            break;
                                                        }
                                                        i14++;
                                                        length = i7;
                                                        i10 = 8;
                                                    }
                                                }
                                            }
                                        } else {
                                            j9 = j12;
                                            i7 = length;
                                            addPendingInvalidationsLocked((DerivedState) obj3, forgetConditionalScopes);
                                        }
                                        i8 = 8;
                                    }
                                }
                                j9 = j12;
                                i7 = length;
                                i8 = 8;
                            } else {
                                j9 = j12;
                                c2 = c4;
                                j10 = j11;
                                i7 = length;
                                i8 = i10;
                            }
                            i13++;
                            length = i7;
                            i10 = i8;
                            c4 = c2;
                            j11 = j10;
                            j12 = j9 >> i8;
                            obj = null;
                        }
                        c = c4;
                        j = j11;
                        int i18 = length;
                        if (i12 != i10) {
                            break;
                        } else {
                            length = i18;
                        }
                    } else {
                        c = c4;
                        j = j11;
                    }
                    if (i11 == length) {
                        break;
                    }
                    i11++;
                    c4 = c;
                    j11 = j;
                    obj = null;
                    i10 = 8;
                }
            } else {
                c = 7;
                j = -9187201950435737472L;
                j2 = 128;
                j3 = 255;
            }
        } else {
            c = 7;
            j = -9187201950435737472L;
            j2 = 128;
            j3 = 255;
            for (Object obj4 : values) {
                if (obj4 instanceof RecomposeScopeImpl) {
                    ((RecomposeScopeImpl) obj4).invalidateForResult(null);
                } else {
                    addPendingInvalidationsLocked(obj4, forgetConditionalScopes);
                    Object obj5 = this.derivedStates.getMap().get(obj4);
                    if (obj5 != null) {
                        if (obj5 instanceof MutableScatterSet) {
                            MutableScatterSet mutableScatterSet2 = (MutableScatterSet) obj5;
                            Object[] objArr3 = mutableScatterSet2.elements;
                            long[] jArr7 = mutableScatterSet2.metadata;
                            int length3 = jArr7.length - 2;
                            if (length3 >= 0) {
                                while (true) {
                                    long j14 = jArr7[i];
                                    if ((((~j14) << 7) & j14 & (-9187201950435737472L)) != -9187201950435737472L) {
                                        int i19 = 8 - ((~(i - length3)) >>> 31);
                                        for (int i20 = 0; i20 < i19; i20++) {
                                            if ((j14 & 255) < 128) {
                                                addPendingInvalidationsLocked((DerivedState) objArr3[(i << 3) + i20], forgetConditionalScopes);
                                            }
                                            j14 >>= 8;
                                        }
                                        if (i19 == 8) {
                                            i = i != length3 ? i + 1 : 0;
                                        }
                                    }
                                }
                            }
                        } else {
                            addPendingInvalidationsLocked((DerivedState) obj5, forgetConditionalScopes);
                        }
                    }
                }
            }
        }
        MutableScatterSet<RecomposeScopeImpl> mutableScatterSet3 = this.conditionallyInvalidatedScopes;
        MutableScatterSet<RecomposeScopeImpl> mutableScatterSet4 = this.invalidatedScopes;
        String str3 = "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$2>";
        if (forgetConditionalScopes && mutableScatterSet3.isNotEmpty()) {
            MutableScatterMap<Object, Object> map = this.observations.getMap();
            long[] jArr8 = map.metadata;
            int length4 = jArr8.length - 2;
            if (length4 >= 0) {
                int i21 = 0;
                while (true) {
                    long j15 = jArr8[i21];
                    if ((((~j15) << c) & j15 & j) != j) {
                        int i22 = 8 - ((~(i21 - length4)) >>> 31);
                        int i23 = 0;
                        while (i23 < i22) {
                            if ((j15 & j3) < j2) {
                                int i24 = (i21 << 3) + i23;
                                Object obj6 = map.keys[i24];
                                Object obj7 = map.values[i24];
                                if (obj7 instanceof MutableScatterSet) {
                                    Intrinsics.checkNotNull(obj7, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$2>");
                                    MutableScatterSet mutableScatterSet5 = (MutableScatterSet) obj7;
                                    Object[] objArr4 = mutableScatterSet5.elements;
                                    long[] jArr9 = mutableScatterSet5.metadata;
                                    jArr4 = jArr8;
                                    int length5 = jArr9.length - 2;
                                    if (length5 >= 0) {
                                        j7 = j15;
                                        int i25 = 0;
                                        while (true) {
                                            long j16 = jArr9[i25];
                                            i4 = length4;
                                            i5 = i21;
                                            if ((((~j16) << c) & j16 & j) != j) {
                                                int i26 = 8 - ((~(i25 - length5)) >>> 31);
                                                for (int i27 = 0; i27 < i26; i27 = i6 + 1) {
                                                    if ((j16 & j3) < j2) {
                                                        i6 = i27;
                                                        int i28 = (i25 << 3) + i6;
                                                        j8 = j16;
                                                        RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) objArr4[i28];
                                                        if (mutableScatterSet3.contains(recomposeScopeImpl) || mutableScatterSet4.contains(recomposeScopeImpl)) {
                                                            mutableScatterSet5.removeElementAt(i28);
                                                        }
                                                    } else {
                                                        i6 = i27;
                                                        j8 = j16;
                                                    }
                                                    j16 = j8 >> 8;
                                                }
                                                if (i26 != 8) {
                                                    break;
                                                }
                                                if (i25 == length5) {
                                                    break;
                                                }
                                                i25++;
                                                length4 = i4;
                                                i21 = i5;
                                            }
                                        }
                                    } else {
                                        i4 = length4;
                                        i5 = i21;
                                        j7 = j15;
                                    }
                                    zIsEmpty = mutableScatterSet5.isEmpty();
                                } else {
                                    jArr4 = jArr8;
                                    i4 = length4;
                                    i5 = i21;
                                    j7 = j15;
                                    Intrinsics.checkNotNull(obj7, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$2");
                                    RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) obj7;
                                    zIsEmpty = mutableScatterSet3.contains(recomposeScopeImpl2) || mutableScatterSet4.contains(recomposeScopeImpl2);
                                }
                                if (zIsEmpty) {
                                    map.removeValueAt(i24);
                                }
                            } else {
                                jArr4 = jArr8;
                                i4 = length4;
                                i5 = i21;
                                j7 = j15;
                            }
                            j15 = j7 >> 8;
                            i23++;
                            length4 = i4;
                            jArr8 = jArr4;
                            i21 = i5;
                        }
                        jArr3 = jArr8;
                        int i29 = length4;
                        int i30 = i21;
                        if (i22 != 8) {
                            break;
                        }
                        length4 = i29;
                        i2 = i30;
                    } else {
                        jArr3 = jArr8;
                        i2 = i21;
                    }
                    if (i2 == length4) {
                        break;
                    }
                    i21 = i2 + 1;
                    jArr8 = jArr3;
                }
            }
            mutableScatterSet3.clear();
            cleanUpDerivedStateObservations();
            return;
        }
        if (mutableScatterSet4.isNotEmpty()) {
            MutableScatterMap<Object, Object> map2 = this.observations.getMap();
            long[] jArr10 = map2.metadata;
            int length6 = jArr10.length - 2;
            if (length6 >= 0) {
                int i31 = 0;
                while (true) {
                    long j17 = jArr10[i31];
                    if ((((~j17) << c) & j17 & j) != j) {
                        int i32 = 8 - ((~(i31 - length6)) >>> 31);
                        int i33 = 0;
                        while (i33 < i32) {
                            if ((j17 & j3) < j2) {
                                int i34 = (i31 << 3) + i33;
                                Object obj8 = map2.keys[i34];
                                Object obj9 = map2.values[i34];
                                if (obj9 instanceof MutableScatterSet) {
                                    Intrinsics.checkNotNull(obj9, str3);
                                    MutableScatterSet mutableScatterSet6 = (MutableScatterSet) obj9;
                                    Object[] objArr5 = mutableScatterSet6.elements;
                                    long[] jArr11 = mutableScatterSet6.metadata;
                                    int length7 = jArr11.length - 2;
                                    jArr2 = jArr10;
                                    str2 = str3;
                                    if (length7 >= 0) {
                                        int i35 = 0;
                                        while (true) {
                                            long j18 = jArr11[i35];
                                            j5 = j17;
                                            if ((((~j18) << c) & j18 & j) != j) {
                                                int i36 = 8 - ((~(i35 - length7)) >>> 31);
                                                int i37 = 0;
                                                while (i37 < i36) {
                                                    if ((j18 & j3) < j2) {
                                                        j6 = j18;
                                                        int i38 = (i35 << 3) + i37;
                                                        if (mutableScatterSet4.contains((RecomposeScopeImpl) objArr5[i38])) {
                                                            mutableScatterSet6.removeElementAt(i38);
                                                        }
                                                    } else {
                                                        j6 = j18;
                                                    }
                                                    i37++;
                                                    j18 = j6 >> 8;
                                                }
                                                if (i36 != 8) {
                                                    break;
                                                }
                                                if (i35 == length7) {
                                                    break;
                                                }
                                                i35++;
                                                j17 = j5;
                                            }
                                        }
                                    } else {
                                        j5 = j17;
                                    }
                                    zContains = mutableScatterSet6.isEmpty();
                                } else {
                                    jArr2 = jArr10;
                                    str2 = str3;
                                    j5 = j17;
                                    Intrinsics.checkNotNull(obj9, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$2");
                                    zContains = mutableScatterSet4.contains((RecomposeScopeImpl) obj9);
                                }
                                if (zContains) {
                                    map2.removeValueAt(i34);
                                }
                            } else {
                                jArr2 = jArr10;
                                str2 = str3;
                                j5 = j17;
                            }
                            j17 = j5 >> 8;
                            i33++;
                            jArr10 = jArr2;
                            str3 = str2;
                        }
                        jArr = jArr10;
                        str = str3;
                        if (i32 != 8) {
                            break;
                        }
                    } else {
                        jArr = jArr10;
                        str = str3;
                    }
                    if (i31 == length6) {
                        break;
                    }
                    i31++;
                    jArr10 = jArr;
                    str3 = str;
                }
            }
            cleanUpDerivedStateObservations();
            mutableScatterSet4.clear();
        }
    }

    public /* synthetic */ CompositionImpl(CompositionContext compositionContext, Applier applier, CoroutineContext coroutineContext, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(compositionContext, applier, (i & 4) != 0 ? null : coroutineContext);
    }
}
