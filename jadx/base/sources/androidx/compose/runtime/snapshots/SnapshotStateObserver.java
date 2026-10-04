package androidx.compose.runtime.snapshots;

import androidx.collection.MutableObjectIntMap;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ObjectIntMap;
import androidx.collection.ScatterSet;
import androidx.compose.runtime.AbstractC1974b;
import androidx.compose.runtime.ActualJvm_jvmKt;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DerivedState;
import androidx.compose.runtime.DerivedStateObserver;
import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.collection.ScatterSetWrapper;
import androidx.compose.runtime.collection.ScopeMap;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import com.samsung.android.sdk.mobileservice.profile.Profile;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import org.apache.commons.beanutils.FluentPropertyBeanIntrospector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.TestOnly;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0001\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u00017B.\u0012'\u0010\u0002\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\tJ\u0016\u0010\u001d\u001a\u00020\u00052\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\fH\u0002J\u0006\u0010\u001f\u001a\u00020\u0005J\u000e\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0001J)\u0010!\u001a\u00020\u00052!\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00150\u0003J\b\u0010#\u001a\u00020\u0015H\u0002J&\u0010$\u001a\u00020\u0011\"\b\b\u0000\u0010%*\u00020\u00012\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u0002H%\u0012\u0004\u0012\u00020\u00050\u0003H\u0002J\u001d\u0010'\u001a\u00020\u00052\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00050\u0003H\u0082\bJ\u001e\u0010)\u001a\u00020\u00052\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00010\f2\u0006\u0010+\u001a\u00020\rH\u0007J?\u0010,\u001a\u00020\u0005\"\b\b\u0000\u0010%*\u00020\u00012\u0006\u0010 \u001a\u0002H%2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u0002H%\u0012\u0004\u0012\u00020\u00050\u00032\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010.J\u0010\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\fH\u0002J\u001d\u00100\u001a\u00020\u00052\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00150\u0003H\u0082\bJ\b\u00101\u001a\u000202H\u0002J\b\u00103\u001a\u00020\u0005H\u0002J\u0006\u00104\u001a\u00020\u0005J\u0006\u00105\u001a\u00020\u0005J\u0016\u00106\u001a\u00020\u00052\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007R&\u0010\n\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00050\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010\u0002\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0018\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0019j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00068"}, m13886d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "", "onChangedExecutor", "Lkotlin/Function1;", "Lkotlin/Function0;", "", "Lkotlin/ParameterName;", "name", Profile.PhoneNumberData.TYPE_CALLBACK, "(Lkotlin/jvm/functions/Function1;)V", "applyObserver", "Lkotlin/Function2;", "", "Landroidx/compose/runtime/snapshots/Snapshot;", "applyUnsubscribe", "Landroidx/compose/runtime/snapshots/ObserverHandle;", "currentMap", "Landroidx/compose/runtime/snapshots/SnapshotStateObserver$ObservedScopeMap;", "currentMapThreadId", "", "isPaused", "", "observedScopeMaps", "Landroidx/compose/runtime/collection/MutableVector;", "pendingChanges", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/runtime/AtomicReference;", "readObserver", "sendingNotifications", "addChanges", FluentPropertyBeanIntrospector.DEFAULT_WRITE_METHOD_PREFIX, "clear", "scope", "clearIf", "predicate", "drainChanges", "ensureMap", "T", "onChanged", "forEachScopeMap", "block", "notifyChanges", "changes", "snapshot", "observeReads", "onValueChangedForScope", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "removeChanges", "removeScopeMapIf", "report", "", "sendNotifications", "start", "stop", "withNoObservations", "ObservedScopeMap", "runtime_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSnapshotStateObserver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SnapshotStateObserver.kt\nandroidx/compose/runtime/snapshots/SnapshotStateObserver\n+ 2 MutableVector.kt\nandroidx/compose/runtime/collection/MutableVectorKt\n+ 3 ActualJvm.jvm.kt\nandroidx/compose/runtime/ActualJvm_jvmKt\n+ 4 MutableVector.kt\nandroidx/compose/runtime/collection/MutableVector\n+ 5 Preconditions.kt\nandroidx/compose/runtime/PreconditionsKt\n*L\n1#1,654:1\n186#1:659\n187#1:661\n188#1,2:673\n192#1:711\n193#1:713\n194#1,2:729\n192#1:731\n193#1:733\n194#1,2:749\n186#1:751\n187#1:753\n188#1,2:765\n1208#2:655\n1187#2,2:656\n89#3:658\n89#3:660\n89#3:675\n89#3:687\n89#3:703\n89#3:712\n89#3:732\n89#3:752\n460#4,11:662\n460#4,11:676\n838#4,15:688\n838#4,15:714\n838#4,15:734\n460#4,11:754\n366#4,12:767\n728#4,2:779\n33#5,7:704\n*S KotlinDebug\n*F\n+ 1 SnapshotStateObserver.kt\nandroidx/compose/runtime/snapshots/SnapshotStateObserver\n*L\n70#1:659\n70#1:661\n70#1:673,2\n292#1:711\n292#1:713\n292#1:729,2\n303#1:731\n303#1:733\n303#1:749,2\n336#1:751\n336#1:753\n336#1:765,2\n178#1:655\n178#1:656,2\n64#1:658\n70#1:660\n186#1:675\n192#1:687\n234#1:703\n292#1:712\n303#1:732\n336#1:752\n70#1:662,11\n187#1:676,11\n193#1:688,15\n292#1:714,15\n303#1:734,15\n336#1:754,11\n349#1:767,12\n352#1:779,2\n243#1:704,7\n*E\n"})
public final class SnapshotStateObserver {
    public static final int $stable = 8;

    @Nullable
    private ObserverHandle applyUnsubscribe;

    @Nullable
    private ObservedScopeMap currentMap;
    private boolean isPaused;

    @NotNull
    private final Function1<Function0<Unit>, Unit> onChangedExecutor;
    private boolean sendingNotifications;

    @NotNull
    private final AtomicReference<Object> pendingChanges = new AtomicReference<>(null);

    @NotNull
    private final Function2<Set<? extends Object>, Snapshot, Unit> applyObserver = new Function2<Set<? extends Object>, Snapshot, Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver$applyObserver$1
        {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Set<? extends Object> set, Snapshot snapshot) {
            invoke2(set, snapshot);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull Set<? extends Object> set, @NotNull Snapshot snapshot) {
            this.this$0.addChanges(set);
            if (this.this$0.drainChanges()) {
                this.this$0.sendNotifications();
            }
        }
    };

    @NotNull
    private final Function1<Object, Unit> readObserver = new Function1<Object, Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver$readObserver$1
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
            if (this.this$0.isPaused) {
                return;
            }
            MutableVector mutableVector = this.this$0.observedScopeMaps;
            SnapshotStateObserver snapshotStateObserver = this.this$0;
            synchronized (mutableVector) {
                SnapshotStateObserver.ObservedScopeMap observedScopeMap = snapshotStateObserver.currentMap;
                Intrinsics.checkNotNull(observedScopeMap);
                observedScopeMap.recordRead(obj);
                Unit unit = Unit.INSTANCE;
            }
        }
    };

    @NotNull
    private final MutableVector<ObservedScopeMap> observedScopeMaps = new MutableVector<>(new ObservedScopeMap[16], 0);
    private long currentMapThreadId = -1;

    /* JADX WARN: Multi-variable type inference failed */
    public SnapshotStateObserver(@NotNull Function1<? super Function0<Unit>, Unit> function1) {
        this.onChangedExecutor = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void addChanges(Set<? extends Object> set) {
        List listPlus;
        while (true) {
            Object obj = this.pendingChanges.get();
            if (obj == null) {
                listPlus = set;
            } else if (obj instanceof Set) {
                listPlus = CollectionsKt.listOf((Object[]) new Set[]{obj, set});
            } else {
                if (!(obj instanceof List)) {
                    report();
                    throw new KotlinNothingValueException();
                }
                listPlus = CollectionsKt.plus((Collection) obj, (Iterable) CollectionsKt.listOf(set));
            }
            AtomicReference<Object> atomicReference = this.pendingChanges;
            while (!atomicReference.compareAndSet(obj, listPlus)) {
                if (atomicReference.get() != obj) {
                    break;
                }
            }
            return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean drainChanges() {
        boolean z;
        synchronized (this.observedScopeMaps) {
            z = this.sendingNotifications;
        }
        if (z) {
            return false;
        }
        boolean z2 = false;
        while (true) {
            Set<? extends Object> setRemoveChanges = removeChanges();
            if (setRemoveChanges == null) {
                return z2;
            }
            synchronized (this.observedScopeMaps) {
                try {
                    MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
                    int size = mutableVector.getSize();
                    if (size > 0) {
                        ObservedScopeMap[] content = mutableVector.getContent();
                        int i = 0;
                        do {
                            z2 = content[i].recordInvalidation(setRemoveChanges) || z2;
                            i++;
                        } while (i < size);
                    }
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    private final <T> ObservedScopeMap ensureMap(Function1<? super T, Unit> onChanged) {
        ObservedScopeMap observedScopeMap;
        MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
        int size = mutableVector.getSize();
        if (size > 0) {
            ObservedScopeMap[] content = mutableVector.getContent();
            int i = 0;
            do {
                observedScopeMap = content[i];
                if (observedScopeMap.getOnChanged() == onChanged) {
                    break;
                }
                i++;
            } while (i < size);
            observedScopeMap = null;
        } else {
            observedScopeMap = null;
        }
        ObservedScopeMap observedScopeMap2 = observedScopeMap;
        if (observedScopeMap2 != null) {
            return observedScopeMap2;
        }
        Intrinsics.checkNotNull(onChanged, "null cannot be cast to non-null type kotlin.Function1<kotlin.Any, kotlin.Unit>");
        ObservedScopeMap observedScopeMap3 = new ObservedScopeMap((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(onChanged, 1));
        this.observedScopeMaps.add(observedScopeMap3);
        return observedScopeMap3;
    }

    private final void forEachScopeMap(Function1<? super ObservedScopeMap, Unit> block) {
        synchronized (this.observedScopeMaps) {
            try {
                MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
                int size = mutableVector.getSize();
                if (size > 0) {
                    ObservedScopeMap[] content = mutableVector.getContent();
                    int i = 0;
                    do {
                        block.invoke(content[i]);
                        i++;
                    } while (i < size);
                }
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        InlineMarker.finallyEnd(1);
    }

    private final Set<Object> removeChanges() {
        Set<Object> set;
        while (true) {
            Object obj = this.pendingChanges.get();
            Object objSubList = null;
            if (obj == null) {
                return null;
            }
            if (obj instanceof Set) {
                set = (Set) obj;
            } else {
                if (!(obj instanceof List)) {
                    report();
                    throw new KotlinNothingValueException();
                }
                List list = (List) obj;
                Set<Object> set2 = (Set) list.get(0);
                if (list.size() == 2) {
                    objSubList = list.get(1);
                } else if (list.size() > 2) {
                    objSubList = list.subList(1, list.size());
                }
                set = set2;
            }
            AtomicReference<Object> atomicReference = this.pendingChanges;
            while (!atomicReference.compareAndSet(obj, objSubList)) {
                if (atomicReference.get() != obj) {
                    break;
                }
            }
            return set;
        }
    }

    private final void removeScopeMapIf(Function1<? super ObservedScopeMap, Boolean> block) {
        synchronized (this.observedScopeMaps) {
            try {
                MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
                int size = mutableVector.getSize();
                int i = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    if (block.invoke(mutableVector.getContent()[i2]).booleanValue()) {
                        i++;
                    } else if (i > 0) {
                        mutableVector.getContent()[i2 - i] = mutableVector.getContent()[i2];
                    }
                }
                int i4 = size - i;
                ArraysKt___ArraysJvmKt.fill(mutableVector.getContent(), (Object) null, i4, size);
                mutableVector.setSize(i4);
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        InlineMarker.finallyEnd(1);
    }

    private final Void report() {
        ComposerKt.composeRuntimeError("Unexpected notification");
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendNotifications() {
        this.onChangedExecutor.invoke(new Function0<Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver.sendNotifications.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                do {
                    MutableVector mutableVector = SnapshotStateObserver.this.observedScopeMaps;
                    SnapshotStateObserver snapshotStateObserver = SnapshotStateObserver.this;
                    synchronized (mutableVector) {
                        try {
                            if (!snapshotStateObserver.sendingNotifications) {
                                snapshotStateObserver.sendingNotifications = true;
                                try {
                                    MutableVector mutableVector2 = snapshotStateObserver.observedScopeMaps;
                                    int size = mutableVector2.getSize();
                                    if (size > 0) {
                                        Object[] content = mutableVector2.getContent();
                                        int i = 0;
                                        do {
                                            ((ObservedScopeMap) content[i]).notifyInvalidatedScopes();
                                            i++;
                                        } while (i < size);
                                    }
                                    snapshotStateObserver.sendingNotifications = false;
                                } finally {
                                }
                            }
                            Unit unit = Unit.INSTANCE;
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                } while (SnapshotStateObserver.this.drainChanges());
            }
        });
    }

    public final void clear(@NotNull Object scope) {
        synchronized (this.observedScopeMaps) {
            try {
                MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
                int size = mutableVector.getSize();
                int i = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    ObservedScopeMap observedScopeMap = mutableVector.getContent()[i2];
                    observedScopeMap.clearScopeObservations(scope);
                    if (!observedScopeMap.hasScopeObservations()) {
                        i++;
                    } else if (i > 0) {
                        mutableVector.getContent()[i2 - i] = mutableVector.getContent()[i2];
                    }
                }
                int i4 = size - i;
                ArraysKt___ArraysJvmKt.fill(mutableVector.getContent(), (Object) null, i4, size);
                mutableVector.setSize(i4);
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void clearIf(@NotNull Function1<Object, Boolean> predicate) {
        synchronized (this.observedScopeMaps) {
            try {
                MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
                int size = mutableVector.getSize();
                int i = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    ObservedScopeMap observedScopeMap = mutableVector.getContent()[i2];
                    observedScopeMap.removeScopeIf(predicate);
                    if (!observedScopeMap.hasScopeObservations()) {
                        i++;
                    } else if (i > 0) {
                        mutableVector.getContent()[i2 - i] = mutableVector.getContent()[i2];
                    }
                }
                int i4 = size - i;
                ArraysKt___ArraysJvmKt.fill(mutableVector.getContent(), (Object) null, i4, size);
                mutableVector.setSize(i4);
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @TestOnly
    public final void notifyChanges(@NotNull Set<? extends Object> changes, @NotNull Snapshot snapshot) {
        this.applyObserver.invoke(changes, snapshot);
    }

    public final <T> void observeReads(@NotNull T scope, @NotNull Function1<? super T, Unit> onValueChangedForScope, @NotNull Function0<Unit> block) {
        ObservedScopeMap observedScopeMapEnsureMap;
        synchronized (this.observedScopeMaps) {
            observedScopeMapEnsureMap = ensureMap(onValueChangedForScope);
        }
        boolean z = this.isPaused;
        ObservedScopeMap observedScopeMap = this.currentMap;
        long j = this.currentMapThreadId;
        if (j != -1) {
            if (!(j == ActualJvm_jvmKt.currentThreadId())) {
                StringBuilder sbM1323p = AbstractC1974b.m1323p(j, "Detected multithreaded access to SnapshotStateObserver: previousThreadId=", "), currentThread={id=");
                sbM1323p.append(ActualJvm_jvmKt.currentThreadId());
                sbM1323p.append(", name=");
                sbM1323p.append(ActualJvm_jvmKt.currentThreadName());
                sbM1323p.append("}. Note that observation on multiple threads in layout/draw is not supported. Make sure your measure/layout/draw for each Owner (AndroidComposeView) is executed on the same thread.");
                PreconditionsKt.throwIllegalArgumentException(sbM1323p.toString());
            }
        }
        try {
            this.isPaused = false;
            this.currentMap = observedScopeMapEnsureMap;
            this.currentMapThreadId = ActualJvm_jvmKt.currentThreadId();
            observedScopeMapEnsureMap.observe(scope, this.readObserver, block);
        } finally {
            this.currentMap = observedScopeMap;
            this.isPaused = z;
            this.currentMapThreadId = j;
        }
    }

    public final void start() {
        this.applyUnsubscribe = Snapshot.INSTANCE.registerApplyObserver(this.applyObserver);
    }

    public final void stop() {
        ObserverHandle observerHandle = this.applyUnsubscribe;
        if (observerHandle != null) {
            observerHandle.dispose();
        }
    }

    @Deprecated(message = "Replace with Snapshot.withoutReadObservation()", replaceWith = @ReplaceWith(expression = "Snapshot.withoutReadObservation(block)", imports = {"androidx.compose.runtime.snapshots.Snapshot"}))
    public final void withNoObservations(@NotNull Function0<Unit> block) {
        boolean z = this.isPaused;
        this.isPaused = true;
        try {
            block.invoke();
        } finally {
            this.isPaused = z;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\u001f\u001a\u00020\u0004J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0001H\u0002J\u000e\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0001J\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020\u0004J0\u0010&\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00012\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00040)J\u0014\u0010*\u001a\u00020$2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00010,J\u000e\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u0001J.\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00012\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00010\bH\u0002J\u0018\u00100\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00012\u0006\u0010.\u001a\u00020\u0001H\u0002J)\u00101\u001a\u00020\u00042!\u00102\u001a\u001d\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020$0\u0003J\u0012\u00105\u001a\u00020\u00042\n\u00106\u001a\u0006\u0012\u0002\b\u00030\rR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u0001\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R6\u0010\u0017\u001a*\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0018j\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\b0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u001c\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00067"}, m13886d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateObserver$ObservedScopeMap;", "", "onChanged", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "currentScope", "currentScopeReads", "Landroidx/collection/MutableObjectIntMap;", "currentToken", "", "dependencyToDerivedStates", "Landroidx/compose/runtime/collection/ScopeMap;", "Landroidx/compose/runtime/DerivedState;", "deriveStateScopeCount", "derivedStateObserver", "Landroidx/compose/runtime/DerivedStateObserver;", "getDerivedStateObserver", "()Landroidx/compose/runtime/DerivedStateObserver;", "invalidated", "Landroidx/collection/MutableScatterSet;", "getOnChanged", "()Lkotlin/jvm/functions/Function1;", "recordedDerivedStateValues", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "scopeToValues", "Landroidx/collection/MutableScatterMap;", "statesToReread", "Landroidx/compose/runtime/collection/MutableVector;", "valueToScopes", "clear", "clearObsoleteStateReads", "scope", "clearScopeObservations", "hasScopeObservations", "", "notifyInvalidatedScopes", "observe", "readObserver", "block", "Lkotlin/Function0;", "recordInvalidation", "changes", "", "recordRead", "value", "recordedValues", "removeObservation", "removeScopeIf", "predicate", "Lkotlin/ParameterName;", "name", "rereadDerivedState", "derivedState", "runtime_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nSnapshotStateObserver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SnapshotStateObserver.kt\nandroidx/compose/runtime/snapshots/SnapshotStateObserver$ObservedScopeMap\n+ 2 MutableVector.kt\nandroidx/compose/runtime/collection/MutableVectorKt\n+ 3 ObjectIntMap.kt\nandroidx/collection/ObjectIntMap\n+ 4 ScatterMap.kt\nandroidx/collection/ScatterMapKt\n+ 5 StateObjectImpl.kt\nandroidx/compose/runtime/snapshots/ReaderKind$Companion\n+ 6 DerivedState.kt\nandroidx/compose/runtime/SnapshotStateKt__DerivedStateKt\n+ 7 MutableVector.kt\nandroidx/compose/runtime/collection/MutableVector\n+ 8 ObjectIntMap.kt\nandroidx/collection/MutableObjectIntMap\n+ 9 ScatterMap.kt\nandroidx/collection/MutableScatterMap\n+ 10 ScatterMap.kt\nandroidx/collection/ScatterMap\n+ 11 ScatterSetWrapper.kt\nandroidx/compose/runtime/collection/ScatterSetWrapperKt\n+ 12 ScatterSet.kt\nandroidx/collection/ScatterSet\n+ 13 ScopeMap.kt\nandroidx/compose/runtime/collection/ScopeMap\n+ 14 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,654:1\n1208#2:655\n1187#2,2:656\n416#3,3:658\n374#3,6:661\n384#3,3:668\n387#3,2:672\n420#3:674\n421#3:676\n390#3,6:677\n422#3:683\n374#3,6:695\n384#3,3:702\n387#3,2:706\n390#3,6:712\n402#3,4:719\n374#3,6:723\n384#3,3:730\n387#3,2:734\n407#3,2:736\n390#3,6:738\n409#3:744\n402#3,4:760\n374#3,6:764\n384#3,3:771\n387#3,2:775\n407#3,2:777\n390#3,6:779\n409#3:785\n1956#4:667\n1820#4:671\n1956#4:701\n1820#4:705\n1956#4:729\n1820#4:733\n1956#4:752\n1820#4:756\n1956#4:770\n1820#4:774\n1956#4:810\n1820#4:814\n1956#4:834\n1820#4:838\n1956#4:857\n1820#4:861\n1956#4:900\n1820#4:904\n1956#4:936\n1820#4:940\n1956#4:975\n1820#4:979\n1956#4:998\n1820#4:1002\n1956#4:1041\n1820#4:1045\n1956#4:1077\n1820#4:1081\n1956#4:1125\n1820#4:1129\n1956#4:1155\n1820#4:1159\n52#5:675\n52#5:684\n52#5:817\n392#6,6:685\n398#6,2:692\n48#7:691\n460#7,11:1098\n844#8:694\n846#8,4:708\n850#8:718\n1049#9:745\n1051#9:759\n1052#9,3:786\n1055#9:795\n365#10,6:746\n375#10,3:753\n378#10,2:757\n381#10,6:789\n48#11,3:796\n53#11:962\n55#11:1097\n228#12,4:799\n198#12,7:803\n209#12,3:811\n212#12,2:815\n228#12,4:823\n198#12,7:827\n209#12,3:835\n212#12,2:839\n228#12,4:846\n198#12,7:850\n209#12,3:858\n212#12,9:862\n232#12:871\n215#12,6:876\n232#12:882\n228#12,4:889\n198#12,7:893\n209#12,3:901\n212#12,9:905\n232#12:914\n228#12,4:925\n198#12,7:929\n209#12,3:937\n212#12,9:941\n232#12:950\n215#12,6:955\n232#12:961\n228#12,4:964\n198#12,7:968\n209#12,3:976\n212#12,2:980\n228#12,4:987\n198#12,7:991\n209#12,3:999\n212#12,9:1003\n232#12:1012\n215#12,6:1017\n232#12:1023\n228#12,4:1030\n198#12,7:1034\n209#12,3:1042\n212#12,9:1046\n232#12:1055\n228#12,4:1066\n198#12,7:1070\n209#12,3:1078\n212#12,9:1082\n232#12:1091\n228#12,4:1114\n198#12,7:1118\n209#12,3:1126\n212#12,9:1130\n232#12:1139\n228#12,4:1144\n198#12,7:1148\n209#12,3:1156\n212#12,9:1160\n232#12:1169\n77#13,5:818\n77#13,5:841\n85#13,4:872\n85#13:883\n77#13,5:884\n85#13,4:915\n88#13:919\n77#13,5:920\n85#13,4:951\n77#13,5:982\n85#13,4:1013\n85#13:1024\n77#13,5:1025\n85#13,4:1056\n88#13:1060\n77#13,5:1061\n85#13,4:1092\n77#13,5:1109\n85#13,4:1140\n1855#14:963\n1856#14:1096\n*S KotlinDebug\n*F\n+ 1 SnapshotStateObserver.kt\nandroidx/compose/runtime/snapshots/SnapshotStateObserver$ObservedScopeMap\n*L\n399#1:655\n399#1:656,2\n471#1:658,3\n471#1:661,6\n471#1:668,3\n471#1:672,2\n471#1:674\n471#1:676\n471#1:677,6\n471#1:683\n514#1:695,6\n514#1:702,3\n514#1:706,2\n514#1:712,6\n528#1:719,4\n528#1:723,6\n528#1:730,3\n528#1:734,2\n528#1:736,2\n528#1:738,6\n528#1:744\n540#1:760,4\n540#1:764,6\n540#1:771,3\n540#1:775,2\n540#1:777,2\n540#1:779,6\n540#1:785\n471#1:667\n471#1:671\n514#1:701\n514#1:705\n528#1:729\n528#1:733\n537#1:752\n537#1:756\n540#1:770\n540#1:774\n581#1:810\n581#1:814\n590#1:834\n590#1:838\n601#1:857\n601#1:861\n601#1:900\n601#1:904\n612#1:936\n612#1:940\n590#1:975\n590#1:979\n601#1:998\n601#1:1002\n601#1:1041\n601#1:1045\n612#1:1077\n612#1:1081\n632#1:1125\n632#1:1129\n649#1:1155\n649#1:1159\n473#1:675\n481#1:684\n583#1:817\n501#1:685,6\n501#1:692,2\n501#1:691\n619#1:1098,11\n514#1:694\n514#1:708,4\n514#1:718\n537#1:745\n537#1:759\n537#1:786,3\n537#1:795\n537#1:746,6\n537#1:753,3\n537#1:757,2\n537#1:789,6\n581#1:796,3\n581#1:962\n581#1:1097\n581#1:799,4\n581#1:803,7\n581#1:811,3\n581#1:815,2\n590#1:823,4\n590#1:827,7\n590#1:835,3\n590#1:839,2\n601#1:846,4\n601#1:850,7\n601#1:858,3\n601#1:862,9\n601#1:871\n590#1:876,6\n590#1:882\n601#1:889,4\n601#1:893,7\n601#1:901,3\n601#1:905,9\n601#1:914\n612#1:925,4\n612#1:929,7\n612#1:937,3\n612#1:941,9\n612#1:950\n581#1:955,6\n581#1:961\n590#1:964,4\n590#1:968,7\n590#1:976,3\n590#1:980,2\n601#1:987,4\n601#1:991,7\n601#1:999,3\n601#1:1003,9\n601#1:1012\n590#1:1017,6\n590#1:1023\n601#1:1030,4\n601#1:1034,7\n601#1:1042,3\n601#1:1046,9\n601#1:1055\n612#1:1066,4\n612#1:1070,7\n612#1:1078,3\n612#1:1082,9\n612#1:1091\n632#1:1114,4\n632#1:1118,7\n632#1:1126,3\n632#1:1130,9\n632#1:1139\n649#1:1144,4\n649#1:1148,7\n649#1:1156,3\n649#1:1160,9\n649#1:1169\n590#1:818,5\n601#1:841,5\n601#1:872,4\n590#1:883\n601#1:884,5\n601#1:915,4\n590#1:919\n612#1:920,5\n612#1:951,4\n601#1:982,5\n601#1:1013,4\n590#1:1024\n601#1:1025,5\n601#1:1056,4\n590#1:1060\n612#1:1061,5\n612#1:1092,4\n632#1:1109,5\n632#1:1140,4\n581#1:963\n581#1:1096\n*E\n"})
    public static final class ObservedScopeMap {

        @Nullable
        private Object currentScope;

        @Nullable
        private MutableObjectIntMap<Object> currentScopeReads;
        private int deriveStateScopeCount;

        @NotNull
        private final MutableScatterSet<Object> invalidated;

        @NotNull
        private final Function1<Object, Unit> onChanged;

        @NotNull
        private final MutableScatterMap<Object, MutableObjectIntMap<Object>> scopeToValues;
        private int currentToken = -1;

        @NotNull
        private final ScopeMap<Object, Object> valueToScopes = new ScopeMap<>();

        @NotNull
        private final MutableVector<DerivedState<?>> statesToReread = new MutableVector<>(new DerivedState[16], 0);

        @NotNull
        private final DerivedStateObserver derivedStateObserver = new DerivedStateObserver() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver$ObservedScopeMap$derivedStateObserver$1
            @Override // androidx.compose.runtime.DerivedStateObserver
            public void done(@NotNull DerivedState<?> derivedState) {
                SnapshotStateObserver.ObservedScopeMap observedScopeMap = this.this$0;
                observedScopeMap.deriveStateScopeCount--;
            }

            @Override // androidx.compose.runtime.DerivedStateObserver
            public void start(@NotNull DerivedState<?> derivedState) {
                this.this$0.deriveStateScopeCount++;
            }
        };

        @NotNull
        private final ScopeMap<Object, DerivedState<?>> dependencyToDerivedStates = new ScopeMap<>();

        @NotNull
        private final HashMap<DerivedState<?>, Object> recordedDerivedStateValues = new HashMap<>();

        public ObservedScopeMap(@NotNull Function1<Object, Unit> function1) {
            this.onChanged = function1;
            int i = 0;
            int i2 = 1;
            DefaultConstructorMarker defaultConstructorMarker = null;
            this.scopeToValues = new MutableScatterMap<>(i, i2, defaultConstructorMarker);
            this.invalidated = new MutableScatterSet<>(i, i2, defaultConstructorMarker);
        }

        private final void clearObsoleteStateReads(Object scope) {
            int i = this.currentToken;
            MutableObjectIntMap<Object> mutableObjectIntMap = this.currentScopeReads;
            if (mutableObjectIntMap == null) {
                return;
            }
            long[] jArr = mutableObjectIntMap.metadata;
            int length = jArr.length - 2;
            if (length < 0) {
                return;
            }
            int i2 = 0;
            while (true) {
                long j = jArr[i2];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i4 = 8 - ((~(i2 - length)) >>> 31);
                    for (int i5 = 0; i5 < i4; i5++) {
                        if ((255 & j) < 128) {
                            int i6 = (i2 << 3) + i5;
                            Object obj = mutableObjectIntMap.keys[i6];
                            boolean z = mutableObjectIntMap.values[i6] != i;
                            if (z) {
                                removeObservation(scope, obj);
                            }
                            if (z) {
                                mutableObjectIntMap.removeValueAt(i6);
                            }
                        }
                        j >>= 8;
                    }
                    if (i4 != 8) {
                        return;
                    }
                }
                if (i2 == length) {
                    return;
                } else {
                    i2++;
                }
            }
        }

        private final void removeObservation(Object scope, Object value) {
            this.valueToScopes.remove(value, scope);
            if (!(value instanceof DerivedState) || this.valueToScopes.contains(value)) {
                return;
            }
            this.dependencyToDerivedStates.removeScope(value);
            this.recordedDerivedStateValues.remove(value);
        }

        public final void clear() {
            this.valueToScopes.clear();
            this.scopeToValues.clear();
            this.dependencyToDerivedStates.clear();
            this.recordedDerivedStateValues.clear();
        }

        public final void clearScopeObservations(@NotNull Object scope) {
            MutableObjectIntMap<Object> mutableObjectIntMapRemove = this.scopeToValues.remove(scope);
            if (mutableObjectIntMapRemove == null) {
                return;
            }
            Object[] objArr = mutableObjectIntMapRemove.keys;
            int[] iArr = mutableObjectIntMapRemove.values;
            long[] jArr = mutableObjectIntMapRemove.metadata;
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
                            int i5 = (i << 3) + i4;
                            Object obj = objArr[i5];
                            int i6 = iArr[i5];
                            removeObservation(scope, obj);
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

        @NotNull
        public final DerivedStateObserver getDerivedStateObserver() {
            return this.derivedStateObserver;
        }

        @NotNull
        public final Function1<Object, Unit> getOnChanged() {
            return this.onChanged;
        }

        public final boolean hasScopeObservations() {
            return this.scopeToValues.isNotEmpty();
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0044  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void notifyInvalidatedScopes() {
            MutableScatterSet<Object> mutableScatterSet = this.invalidated;
            Function1<Object, Unit> function1 = this.onChanged;
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
                                function1.invoke(objArr[(i << 3) + i4]);
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
            mutableScatterSet.clear();
        }

        public final void observe(@NotNull Object scope, @NotNull Function1<Object, Unit> readObserver, @NotNull Function0<Unit> block) {
            Object obj = this.currentScope;
            MutableObjectIntMap<Object> mutableObjectIntMap = this.currentScopeReads;
            int i = this.currentToken;
            this.currentScope = scope;
            this.currentScopeReads = this.scopeToValues.get(scope);
            if (this.currentToken == -1) {
                this.currentToken = SnapshotKt.currentSnapshot().getId();
            }
            DerivedStateObserver derivedStateObserver = this.derivedStateObserver;
            MutableVector<DerivedStateObserver> mutableVectorDerivedStateObservers = SnapshotStateKt.derivedStateObservers();
            try {
                mutableVectorDerivedStateObservers.add(derivedStateObserver);
                Snapshot.INSTANCE.observe(readObserver, null, block);
                mutableVectorDerivedStateObservers.removeAt(mutableVectorDerivedStateObservers.getSize() - 1);
                Object obj2 = this.currentScope;
                Intrinsics.checkNotNull(obj2);
                clearObsoleteStateReads(obj2);
                this.currentScope = obj;
                this.currentScopeReads = mutableObjectIntMap;
                this.currentToken = i;
            } catch (Throwable th) {
                mutableVectorDerivedStateObservers.removeAt(mutableVectorDerivedStateObservers.getSize() - 1);
                throw th;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:100:0x0243  */
        /* JADX WARN: Removed duplicated region for block: B:103:0x0259  */
        /* JADX WARN: Removed duplicated region for block: B:118:0x029d A[PHI: r11
          0x029d: PHI (r11v42 boolean) = (r11v41 boolean), (r11v43 boolean) binds: [B:109:0x0274, B:117:0x029b] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:177:0x040a A[PHI: r13
          0x040a: PHI (r13v5 boolean) = (r13v4 boolean), (r13v7 boolean) binds: [B:168:0x03dd, B:176:0x0408] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:214:0x04c9 A[PHI: r11
          0x04c9: PHI (r11v14 boolean) = (r11v13 boolean), (r11v15 boolean) binds: [B:205:0x04a0, B:213:0x04c7] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:218:0x04da  */
        /* JADX WARN: Removed duplicated region for block: B:221:0x04e8  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x0154 A[PHI: r39
          0x0154: PHI (r39v2 boolean) = (r39v1 boolean), (r39v4 boolean) binds: [B:47:0x0128, B:56:0x0152] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:96:0x0232 A[PHI: r11
          0x0232: PHI (r11v51 boolean) = (r11v50 boolean), (r11v52 boolean) binds: [B:87:0x0209, B:95:0x0230] A[DONT_GENERATE, DONT_INLINE]] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final boolean recordInvalidation(@NotNull Set<? extends Object> changes) {
            boolean z;
            Iterator it;
            ScopeMap<Object, DerivedState<?>> scopeMap;
            Object obj;
            int i;
            Object obj2;
            long[] jArr;
            Iterator it2;
            ScopeMap<Object, DerivedState<?>> scopeMap2;
            long[] jArr2;
            long j;
            long[] jArr3;
            ScopeMap<Object, Object> scopeMap3;
            Object[] objArr;
            String str;
            int i2;
            long[] jArr4;
            ScopeMap<Object, Object> scopeMap4;
            Object[] objArr2;
            String str2;
            int i4;
            int i5;
            long j2;
            int i6;
            int i7;
            Object obj3;
            Object obj4;
            Object[] objArr3;
            String str3;
            int i8;
            long j3;
            int i9;
            int i10;
            ScopeMap<Object, DerivedState<?>> scopeMap5 = this.dependencyToDerivedStates;
            HashMap<DerivedState<?>, Object> map = this.recordedDerivedStateValues;
            ScopeMap<Object, Object> scopeMap6 = this.valueToScopes;
            MutableScatterSet<Object> mutableScatterSet = this.invalidated;
            String str4 = "null cannot be cast to non-null type androidx.compose.runtime.DerivedState<kotlin.Any?>";
            int i11 = 8;
            int i12 = 0;
            if (changes instanceof ScatterSetWrapper) {
                ScatterSet set$runtime_release = ((ScatterSetWrapper) changes).getSet$runtime_release();
                Object[] objArr4 = set$runtime_release.elements;
                long[] jArr5 = set$runtime_release.metadata;
                int length = jArr5.length - 2;
                if (length >= 0) {
                    int i13 = 0;
                    z = false;
                    while (true) {
                        long j5 = jArr5[i13];
                        if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i14 = 8 - ((~(i13 - length)) >>> 31);
                            int i15 = 0;
                            while (i15 < i14) {
                                if ((j5 & 255) < 128) {
                                    int i16 = i11;
                                    Object obj5 = objArr4[(i13 << 3) + i15];
                                    jArr4 = jArr5;
                                    if (obj5 instanceof StateObjectImpl) {
                                        scopeMap4 = scopeMap6;
                                        if (!((StateObjectImpl) obj5).m18128isReadInh_f27i8$runtime_release(ReaderKind.m18116constructorimpl(2))) {
                                            objArr2 = objArr4;
                                            str2 = str4;
                                            i4 = length;
                                            i5 = i13;
                                            j2 = j5;
                                            i6 = i14;
                                        }
                                        i7 = 8;
                                    } else {
                                        scopeMap4 = scopeMap6;
                                    }
                                    if (!scopeMap5.contains(obj5) || (obj4 = scopeMap5.getMap().get(obj5)) == null) {
                                        objArr2 = objArr4;
                                        str2 = str4;
                                        i4 = length;
                                        i5 = i13;
                                        j2 = j5;
                                        i6 = i14;
                                        obj3 = scopeMap4.getMap().get(obj5);
                                        if (obj3 != null) {
                                            if (obj3 instanceof MutableScatterSet) {
                                                MutableScatterSet mutableScatterSet2 = (MutableScatterSet) obj3;
                                                Object[] objArr5 = mutableScatterSet2.elements;
                                                long[] jArr6 = mutableScatterSet2.metadata;
                                                int length2 = jArr6.length - 2;
                                                if (length2 >= 0) {
                                                    int i17 = 0;
                                                    while (true) {
                                                        long j6 = jArr6[i17];
                                                        if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                            int i18 = 8 - ((~(i17 - length2)) >>> 31);
                                                            for (int i19 = 0; i19 < i18; i19++) {
                                                                if ((j6 & 255) < 128) {
                                                                    mutableScatterSet.add(objArr5[(i17 << 3) + i19]);
                                                                    z = true;
                                                                }
                                                                j6 >>= 8;
                                                            }
                                                            if (i18 != 8) {
                                                                break;
                                                            }
                                                            if (i17 == length2) {
                                                                break;
                                                            }
                                                            i17++;
                                                        }
                                                    }
                                                }
                                            } else {
                                                mutableScatterSet.add(obj3);
                                                z = true;
                                            }
                                        }
                                        i7 = 8;
                                    } else {
                                        if (obj4 instanceof MutableScatterSet) {
                                            MutableScatterSet mutableScatterSet3 = (MutableScatterSet) obj4;
                                            Object[] objArr6 = mutableScatterSet3.elements;
                                            long[] jArr7 = mutableScatterSet3.metadata;
                                            int length3 = jArr7.length - 2;
                                            if (length3 >= 0) {
                                                j2 = j5;
                                                int i20 = 0;
                                                boolean z2 = z;
                                                while (true) {
                                                    long j7 = jArr7[i20];
                                                    i4 = length;
                                                    i5 = i13;
                                                    if ((((~j7) << 7) & j7 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                        int i21 = 8 - ((~(i20 - length3)) >>> 31);
                                                        int i22 = 0;
                                                        while (i22 < i21) {
                                                            if ((j7 & 255) < 128) {
                                                                objArr3 = objArr4;
                                                                DerivedState<?> derivedState = (DerivedState) objArr6[(i20 << 3) + i22];
                                                                Intrinsics.checkNotNull(derivedState, str4);
                                                                i8 = i22;
                                                                Object obj6 = map.get(derivedState);
                                                                SnapshotMutationPolicy<?> policy = derivedState.getPolicy();
                                                                if (policy == null) {
                                                                    policy = SnapshotStateKt.structuralEqualityPolicy();
                                                                }
                                                                j3 = j7;
                                                                if (policy.equivalent(derivedState.getCurrentRecord().getCurrentValue(), obj6)) {
                                                                    str3 = str4;
                                                                    i9 = i14;
                                                                    this.statesToReread.add(derivedState);
                                                                } else {
                                                                    Object obj7 = scopeMap4.getMap().get(derivedState);
                                                                    if (obj7 != null) {
                                                                        if (obj7 instanceof MutableScatterSet) {
                                                                            MutableScatterSet mutableScatterSet4 = (MutableScatterSet) obj7;
                                                                            Object[] objArr7 = mutableScatterSet4.elements;
                                                                            long[] jArr8 = mutableScatterSet4.metadata;
                                                                            int length4 = jArr8.length - 2;
                                                                            if (length4 >= 0) {
                                                                                boolean z3 = z2;
                                                                                i9 = i14;
                                                                                int i23 = 0;
                                                                                while (true) {
                                                                                    long j8 = jArr8[i23];
                                                                                    long[] jArr9 = jArr8;
                                                                                    str3 = str4;
                                                                                    if ((((~j8) << 7) & j8 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                                                        int i24 = 8 - ((~(i23 - length4)) >>> 31);
                                                                                        int i25 = 0;
                                                                                        while (i25 < i24) {
                                                                                            if ((j8 & 255) < 128) {
                                                                                                i10 = i25;
                                                                                                mutableScatterSet.add(objArr7[(i23 << 3) + i25]);
                                                                                                z3 = true;
                                                                                            } else {
                                                                                                i10 = i25;
                                                                                            }
                                                                                            j8 >>= i16;
                                                                                            i25 = i10 + 1;
                                                                                        }
                                                                                        if (i24 != i16) {
                                                                                            break;
                                                                                        }
                                                                                        if (i23 == length4) {
                                                                                            break;
                                                                                        }
                                                                                        i23++;
                                                                                        str4 = str3;
                                                                                        jArr8 = jArr9;
                                                                                        i16 = 8;
                                                                                    }
                                                                                }
                                                                                z2 = z3;
                                                                            }
                                                                        } else {
                                                                            str3 = str4;
                                                                            i9 = i14;
                                                                            mutableScatterSet.add(obj7);
                                                                            z2 = true;
                                                                        }
                                                                    }
                                                                    str3 = str4;
                                                                }
                                                                j7 = j3 >> 8;
                                                                i22 = i8 + 1;
                                                                i16 = 8;
                                                                objArr4 = objArr3;
                                                                i14 = i9;
                                                                str4 = str3;
                                                            } else {
                                                                objArr3 = objArr4;
                                                                str3 = str4;
                                                                i8 = i22;
                                                                j3 = j7;
                                                            }
                                                            i9 = i14;
                                                            j7 = j3 >> 8;
                                                            i22 = i8 + 1;
                                                            i16 = 8;
                                                            objArr4 = objArr3;
                                                            i14 = i9;
                                                            str4 = str3;
                                                        }
                                                        objArr2 = objArr4;
                                                        str2 = str4;
                                                        i6 = i14;
                                                        if (i21 != i16) {
                                                            break;
                                                        }
                                                    } else {
                                                        objArr2 = objArr4;
                                                        str2 = str4;
                                                        i6 = i14;
                                                    }
                                                    if (i20 == length3) {
                                                        break;
                                                    }
                                                    i20++;
                                                    length = i4;
                                                    i13 = i5;
                                                    objArr4 = objArr2;
                                                    i14 = i6;
                                                    str4 = str2;
                                                    i16 = 8;
                                                }
                                                z = z2;
                                            }
                                        } else {
                                            objArr2 = objArr4;
                                            str2 = str4;
                                            i4 = length;
                                            i5 = i13;
                                            j2 = j5;
                                            i6 = i14;
                                            DerivedState<?> derivedState2 = (DerivedState) obj4;
                                            Object obj8 = map.get(derivedState2);
                                            SnapshotMutationPolicy<?> policy2 = derivedState2.getPolicy();
                                            if (policy2 == null) {
                                                policy2 = SnapshotStateKt.structuralEqualityPolicy();
                                            }
                                            if (policy2.equivalent(derivedState2.getCurrentRecord().getCurrentValue(), obj8)) {
                                                this.statesToReread.add(derivedState2);
                                            } else {
                                                Object obj9 = scopeMap4.getMap().get(derivedState2);
                                                if (obj9 != null) {
                                                    if (obj9 instanceof MutableScatterSet) {
                                                        MutableScatterSet mutableScatterSet5 = (MutableScatterSet) obj9;
                                                        Object[] objArr8 = mutableScatterSet5.elements;
                                                        long[] jArr10 = mutableScatterSet5.metadata;
                                                        int length5 = jArr10.length - 2;
                                                        if (length5 >= 0) {
                                                            int i26 = 0;
                                                            while (true) {
                                                                long j9 = jArr10[i26];
                                                                if ((((~j9) << 7) & j9 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                                    int i27 = 8 - ((~(i26 - length5)) >>> 31);
                                                                    for (int i28 = 0; i28 < i27; i28++) {
                                                                        if ((j9 & 255) < 128) {
                                                                            mutableScatterSet.add(objArr8[(i26 << 3) + i28]);
                                                                            z = true;
                                                                        }
                                                                        j9 >>= 8;
                                                                    }
                                                                    if (i27 != 8) {
                                                                        break;
                                                                    }
                                                                    if (i26 == length5) {
                                                                        break;
                                                                    }
                                                                    i26++;
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        mutableScatterSet.add(obj9);
                                                        z = true;
                                                    }
                                                }
                                            }
                                        }
                                        obj3 = scopeMap4.getMap().get(obj5);
                                        if (obj3 != null) {
                                        }
                                        i7 = 8;
                                    }
                                } else {
                                    jArr4 = jArr5;
                                    scopeMap4 = scopeMap6;
                                    objArr2 = objArr4;
                                    str2 = str4;
                                    i4 = length;
                                    i5 = i13;
                                    j2 = j5;
                                    i6 = i14;
                                    i7 = i11;
                                }
                                j5 = j2 >> i7;
                                i15++;
                                i11 = i7;
                                jArr5 = jArr4;
                                scopeMap6 = scopeMap4;
                                length = i4;
                                i13 = i5;
                                objArr4 = objArr2;
                                i14 = i6;
                                str4 = str2;
                            }
                            jArr3 = jArr5;
                            scopeMap3 = scopeMap6;
                            objArr = objArr4;
                            str = str4;
                            int i29 = length;
                            int i30 = i13;
                            if (i14 != i11) {
                                break;
                            }
                            length = i29;
                            i2 = i30;
                        } else {
                            jArr3 = jArr5;
                            scopeMap3 = scopeMap6;
                            objArr = objArr4;
                            str = str4;
                            i2 = i13;
                        }
                        if (i2 == length) {
                            break;
                        }
                        i13 = i2 + 1;
                        jArr5 = jArr3;
                        scopeMap6 = scopeMap3;
                        objArr4 = objArr;
                        str4 = str;
                        i11 = 8;
                    }
                } else {
                    z = false;
                }
            } else {
                Iterator it3 = changes.iterator();
                z = false;
                while (it3.hasNext()) {
                    Object next = it3.next();
                    if (!(next instanceof StateObjectImpl) || ((StateObjectImpl) next).m18128isReadInh_f27i8$runtime_release(ReaderKind.m18116constructorimpl(2))) {
                        if (!scopeMap5.contains(next) || (obj2 = scopeMap5.getMap().get(next)) == null) {
                            it = it3;
                            scopeMap = scopeMap5;
                            obj = scopeMap6.getMap().get(next);
                            if (obj != null) {
                                if (obj instanceof MutableScatterSet) {
                                    MutableScatterSet mutableScatterSet6 = (MutableScatterSet) obj;
                                    Object[] objArr9 = mutableScatterSet6.elements;
                                    long[] jArr11 = mutableScatterSet6.metadata;
                                    int length6 = jArr11.length - 2;
                                    if (length6 >= 0) {
                                        while (true) {
                                            long j10 = jArr11[i];
                                            if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                int i31 = 8 - ((~(i - length6)) >>> 31);
                                                for (int i32 = 0; i32 < i31; i32++) {
                                                    if ((j10 & 255) < 128) {
                                                        mutableScatterSet.add(objArr9[(i << 3) + i32]);
                                                        z = true;
                                                    }
                                                    j10 >>= 8;
                                                }
                                                if (i31 == 8) {
                                                    break;
                                                }
                                            }
                                            i = i != length6 ? i + 1 : 0;
                                        }
                                    }
                                } else {
                                    mutableScatterSet.add(obj);
                                    z = true;
                                }
                            }
                        } else {
                            if (obj2 instanceof MutableScatterSet) {
                                MutableScatterSet mutableScatterSet7 = (MutableScatterSet) obj2;
                                Object[] objArr10 = mutableScatterSet7.elements;
                                long[] jArr12 = mutableScatterSet7.metadata;
                                int length7 = jArr12.length - 2;
                                if (length7 >= 0) {
                                    int i33 = 0;
                                    while (true) {
                                        long j11 = jArr12[i33];
                                        if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                                            int i34 = 8 - ((~(i33 - length7)) >>> 31);
                                            int i35 = 0;
                                            while (i35 < i34) {
                                                if ((j11 & 255) < 128) {
                                                    DerivedState<?> derivedState3 = (DerivedState) objArr10[(i33 << 3) + i35];
                                                    it2 = it3;
                                                    Intrinsics.checkNotNull(derivedState3, "null cannot be cast to non-null type androidx.compose.runtime.DerivedState<kotlin.Any?>");
                                                    Object obj10 = map.get(derivedState3);
                                                    SnapshotMutationPolicy<?> policy3 = derivedState3.getPolicy();
                                                    if (policy3 == null) {
                                                        policy3 = SnapshotStateKt.structuralEqualityPolicy();
                                                    }
                                                    scopeMap2 = scopeMap5;
                                                    jArr2 = jArr12;
                                                    if (policy3.equivalent(derivedState3.getCurrentRecord().getCurrentValue(), obj10)) {
                                                        j = j11;
                                                        this.statesToReread.add(derivedState3);
                                                    } else {
                                                        Object obj11 = scopeMap6.getMap().get(derivedState3);
                                                        if (obj11 != null) {
                                                            if (obj11 instanceof MutableScatterSet) {
                                                                MutableScatterSet mutableScatterSet8 = (MutableScatterSet) obj11;
                                                                Object[] objArr11 = mutableScatterSet8.elements;
                                                                long[] jArr13 = mutableScatterSet8.metadata;
                                                                int length8 = jArr13.length - 2;
                                                                if (length8 >= 0) {
                                                                    j = j11;
                                                                    int i36 = 0;
                                                                    boolean z4 = z;
                                                                    while (true) {
                                                                        long j12 = jArr13[i36];
                                                                        long[] jArr14 = jArr13;
                                                                        Object[] objArr12 = objArr11;
                                                                        if ((((~j12) << 7) & j12 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                                            int i37 = 8 - ((~(i36 - length8)) >>> 31);
                                                                            for (int i38 = 0; i38 < i37; i38++) {
                                                                                if ((j12 & 255) < 128) {
                                                                                    mutableScatterSet.add(objArr12[(i36 << 3) + i38]);
                                                                                    z4 = true;
                                                                                }
                                                                                j12 >>= 8;
                                                                            }
                                                                            if (i37 != 8) {
                                                                                break;
                                                                            }
                                                                            if (i36 == length8) {
                                                                                break;
                                                                            }
                                                                            i36++;
                                                                            objArr11 = objArr12;
                                                                            jArr13 = jArr14;
                                                                        }
                                                                    }
                                                                    z = z4;
                                                                }
                                                            } else {
                                                                j = j11;
                                                                mutableScatterSet.add(obj11);
                                                                z = true;
                                                            }
                                                        }
                                                    }
                                                    j11 = j >> 8;
                                                    i35++;
                                                    it3 = it2;
                                                    scopeMap5 = scopeMap2;
                                                    jArr12 = jArr2;
                                                } else {
                                                    it2 = it3;
                                                    scopeMap2 = scopeMap5;
                                                    jArr2 = jArr12;
                                                }
                                                j = j11;
                                                j11 = j >> 8;
                                                i35++;
                                                it3 = it2;
                                                scopeMap5 = scopeMap2;
                                                jArr12 = jArr2;
                                            }
                                            it = it3;
                                            scopeMap = scopeMap5;
                                            jArr = jArr12;
                                            if (i34 != 8) {
                                                break;
                                            }
                                        } else {
                                            it = it3;
                                            scopeMap = scopeMap5;
                                            jArr = jArr12;
                                        }
                                        if (i33 == length7) {
                                            break;
                                        }
                                        i33++;
                                        it3 = it;
                                        scopeMap5 = scopeMap;
                                        jArr12 = jArr;
                                    }
                                }
                            } else {
                                it = it3;
                                scopeMap = scopeMap5;
                                DerivedState<?> derivedState4 = (DerivedState) obj2;
                                Object obj12 = map.get(derivedState4);
                                SnapshotMutationPolicy<?> policy4 = derivedState4.getPolicy();
                                if (policy4 == null) {
                                    policy4 = SnapshotStateKt.structuralEqualityPolicy();
                                }
                                if (policy4.equivalent(derivedState4.getCurrentRecord().getCurrentValue(), obj12)) {
                                    this.statesToReread.add(derivedState4);
                                } else {
                                    Object obj13 = scopeMap6.getMap().get(derivedState4);
                                    if (obj13 != null) {
                                        if (obj13 instanceof MutableScatterSet) {
                                            MutableScatterSet mutableScatterSet9 = (MutableScatterSet) obj13;
                                            Object[] objArr13 = mutableScatterSet9.elements;
                                            long[] jArr15 = mutableScatterSet9.metadata;
                                            int length9 = jArr15.length - 2;
                                            if (length9 >= 0) {
                                                int i39 = 0;
                                                while (true) {
                                                    long j13 = jArr15[i39];
                                                    if ((((~j13) << 7) & j13 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                        int i40 = 8 - ((~(i39 - length9)) >>> 31);
                                                        for (int i41 = 0; i41 < i40; i41++) {
                                                            if ((j13 & 255) < 128) {
                                                                mutableScatterSet.add(objArr13[(i39 << 3) + i41]);
                                                                z = true;
                                                            }
                                                            j13 >>= 8;
                                                        }
                                                        if (i40 != 8) {
                                                            break;
                                                        }
                                                        if (i39 == length9) {
                                                            break;
                                                        }
                                                        i39++;
                                                    }
                                                }
                                            }
                                        } else {
                                            mutableScatterSet.add(obj13);
                                            z = true;
                                        }
                                    }
                                }
                            }
                            obj = scopeMap6.getMap().get(next);
                            if (obj != null) {
                            }
                        }
                        it3 = it;
                        scopeMap5 = scopeMap;
                    } else {
                        it = it3;
                        scopeMap = scopeMap5;
                    }
                    it3 = it;
                    scopeMap5 = scopeMap;
                }
            }
            if (this.statesToReread.isNotEmpty()) {
                MutableVector<DerivedState<?>> mutableVector = this.statesToReread;
                int size = mutableVector.getSize();
                if (size > 0) {
                    DerivedState<?>[] content = mutableVector.getContent();
                    while (true) {
                        rereadDerivedState(content[i12]);
                        int i42 = i12 + 1;
                        if (i42 >= size) {
                            break;
                        }
                        i12 = i42;
                    }
                }
                this.statesToReread.clear();
            }
            return z;
        }

        public final void recordRead(@NotNull Object value) {
            Object obj = this.currentScope;
            Intrinsics.checkNotNull(obj);
            int i = this.currentToken;
            MutableObjectIntMap<Object> mutableObjectIntMap = this.currentScopeReads;
            if (mutableObjectIntMap == null) {
                mutableObjectIntMap = new MutableObjectIntMap<>(0, 1, null);
                this.currentScopeReads = mutableObjectIntMap;
                this.scopeToValues.set(obj, mutableObjectIntMap);
                Unit unit = Unit.INSTANCE;
            }
            recordRead(value, i, obj, mutableObjectIntMap);
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x009d  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00a8  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void removeScopeIf(@NotNull Function1<Object, Boolean> predicate) {
            long[] jArr;
            long[] jArr2;
            long j;
            char c;
            long j2;
            int i;
            long j3;
            MutableScatterMap<Object, MutableObjectIntMap<Object>> mutableScatterMap = this.scopeToValues;
            long[] jArr3 = mutableScatterMap.metadata;
            int length = jArr3.length - 2;
            if (length < 0) {
                return;
            }
            int i2 = 0;
            while (true) {
                long j5 = jArr3[i2];
                char c2 = 7;
                long j6 = -9187201950435737472L;
                if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i4 = 8;
                    int i5 = 8 - ((~(i2 - length)) >>> 31);
                    int i6 = 0;
                    while (i6 < i5) {
                        if ((j5 & 255) < 128) {
                            int i7 = (i2 << 3) + i6;
                            c = c2;
                            Object obj = mutableScatterMap.keys[i7];
                            j2 = j6;
                            MutableObjectIntMap mutableObjectIntMap = (MutableObjectIntMap) mutableScatterMap.values[i7];
                            Boolean boolInvoke = predicate.invoke(obj);
                            if (boolInvoke.booleanValue()) {
                                Object[] objArr = mutableObjectIntMap.keys;
                                int[] iArr = mutableObjectIntMap.values;
                                long[] jArr4 = mutableObjectIntMap.metadata;
                                int i8 = i4;
                                int length2 = jArr4.length - 2;
                                if (length2 >= 0) {
                                    jArr2 = jArr3;
                                    j = j5;
                                    int i9 = 0;
                                    while (true) {
                                        long j7 = jArr4[i9];
                                        long[] jArr5 = jArr4;
                                        if ((((~j7) << c) & j7 & j2) != j2) {
                                            int i10 = 8 - ((~(i9 - length2)) >>> 31);
                                            for (int i11 = 0; i11 < i10; i11++) {
                                                if ((j7 & 255) < 128) {
                                                    int i12 = (i9 << 3) + i11;
                                                    j3 = j7;
                                                    Object obj2 = objArr[i12];
                                                    int i13 = iArr[i12];
                                                    removeObservation(obj, obj2);
                                                } else {
                                                    j3 = j7;
                                                }
                                                j7 = j3 >> i8;
                                            }
                                            if (i10 != i8) {
                                                break;
                                            }
                                            if (i9 == length2) {
                                                break;
                                            }
                                            i9++;
                                            jArr4 = jArr5;
                                            i8 = 8;
                                        }
                                    }
                                } else {
                                    jArr2 = jArr3;
                                    j = j5;
                                }
                                if (boolInvoke.booleanValue()) {
                                    mutableScatterMap.removeValueAt(i7);
                                }
                                i = 8;
                            }
                        } else {
                            jArr2 = jArr3;
                            j = j5;
                            c = c2;
                            j2 = j6;
                            i = i4;
                        }
                        i6++;
                        i4 = i;
                        j5 = j >> i;
                        c2 = c;
                        j6 = j2;
                        jArr3 = jArr2;
                    }
                    jArr = jArr3;
                    if (i5 != i4) {
                        return;
                    }
                } else {
                    jArr = jArr3;
                }
                if (i2 == length) {
                    return;
                }
                i2++;
                jArr3 = jArr;
            }
        }

        public final void rereadDerivedState(@NotNull DerivedState<?> derivedState) {
            long[] jArr;
            long[] jArr2;
            int i;
            MutableObjectIntMap<Object> mutableObjectIntMap;
            MutableScatterMap<Object, MutableObjectIntMap<Object>> mutableScatterMap = this.scopeToValues;
            int id = SnapshotKt.currentSnapshot().getId();
            Object obj = this.valueToScopes.getMap().get(derivedState);
            if (obj == null) {
                return;
            }
            DefaultConstructorMarker defaultConstructorMarker = null;
            int i2 = 1;
            int i4 = 0;
            if (!(obj instanceof MutableScatterSet)) {
                MutableObjectIntMap<Object> mutableObjectIntMap2 = mutableScatterMap.get(obj);
                if (mutableObjectIntMap2 == null) {
                    mutableObjectIntMap2 = new MutableObjectIntMap<>(i4, i2, defaultConstructorMarker);
                    mutableScatterMap.set(obj, mutableObjectIntMap2);
                    Unit unit = Unit.INSTANCE;
                }
                recordRead(derivedState, id, obj, mutableObjectIntMap2);
                return;
            }
            MutableScatterSet mutableScatterSet = (MutableScatterSet) obj;
            Object[] objArr = mutableScatterSet.elements;
            long[] jArr3 = mutableScatterSet.metadata;
            int length = jArr3.length - 2;
            if (length < 0) {
                return;
            }
            int i5 = 0;
            while (true) {
                long j = jArr3[i5];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i6 = 8;
                    int i7 = 8 - ((~(i5 - length)) >>> 31);
                    int i8 = 0;
                    while (i8 < i7) {
                        if ((j & 255) < 128) {
                            i = i6;
                            Object obj2 = objArr[(i5 << 3) + i8];
                            MutableObjectIntMap<Object> mutableObjectIntMap3 = mutableScatterMap.get(obj2);
                            jArr2 = jArr3;
                            if (mutableObjectIntMap3 == null) {
                                mutableObjectIntMap = new MutableObjectIntMap<>(i4, i2, defaultConstructorMarker);
                                mutableScatterMap.set(obj2, mutableObjectIntMap);
                                Unit unit2 = Unit.INSTANCE;
                            } else {
                                mutableObjectIntMap = mutableObjectIntMap3;
                            }
                            recordRead(derivedState, id, obj2, mutableObjectIntMap);
                        } else {
                            jArr2 = jArr3;
                            i = i6;
                        }
                        j >>= i;
                        i8++;
                        i6 = i;
                        jArr3 = jArr2;
                    }
                    jArr = jArr3;
                    if (i7 != i6) {
                        return;
                    }
                } else {
                    jArr = jArr3;
                }
                if (i5 == length) {
                    return;
                }
                i5++;
                jArr3 = jArr;
            }
        }

        private final void recordRead(Object value, int currentToken, Object currentScope, MutableObjectIntMap<Object> recordedValues) {
            int i;
            int i2;
            int i4;
            if (this.deriveStateScopeCount > 0) {
                return;
            }
            int iPut = recordedValues.put(value, currentToken, -1);
            int i5 = 2;
            if (!(value instanceof DerivedState) || iPut == currentToken) {
                i = 2;
                i2 = -1;
            } else {
                DerivedState.Record currentRecord = ((DerivedState) value).getCurrentRecord();
                this.recordedDerivedStateValues.put(value, currentRecord.getCurrentValue());
                ObjectIntMap<StateObject> dependencies = currentRecord.getDependencies();
                ScopeMap<Object, DerivedState<?>> scopeMap = this.dependencyToDerivedStates;
                scopeMap.removeScope(value);
                Object[] objArr = dependencies.keys;
                long[] jArr = dependencies.metadata;
                int length = jArr.length - 2;
                if (length >= 0) {
                    int i6 = 0;
                    while (true) {
                        long j = jArr[i6];
                        if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i7 = 8 - ((~(i6 - length)) >>> 31);
                            int i8 = 0;
                            while (i8 < i7) {
                                if ((j & 255) < 128) {
                                    i4 = i5;
                                    StateObject stateObject = (StateObject) objArr[(i6 << 3) + i8];
                                    if (stateObject instanceof StateObjectImpl) {
                                        ((StateObjectImpl) stateObject).m18129recordReadInh_f27i8$runtime_release(ReaderKind.m18116constructorimpl(i4));
                                    }
                                    scopeMap.add(stateObject, value);
                                } else {
                                    i4 = i5;
                                }
                                j >>= 8;
                                i8++;
                                i5 = i4;
                            }
                            i = i5;
                            if (i7 != 8) {
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
                } else {
                    i = 2;
                }
                i2 = -1;
            }
            if (iPut == i2) {
                if (value instanceof StateObjectImpl) {
                    ((StateObjectImpl) value).m18129recordReadInh_f27i8$runtime_release(ReaderKind.m18116constructorimpl(i));
                }
                this.valueToScopes.add(value, currentScope);
            }
        }
    }

    public final void clear() {
        synchronized (this.observedScopeMaps) {
            try {
                MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
                int size = mutableVector.getSize();
                if (size > 0) {
                    ObservedScopeMap[] content = mutableVector.getContent();
                    int i = 0;
                    do {
                        content[i].clear();
                        i++;
                    } while (i < size);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
