package androidx.compose.runtime;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.IntRef;
import androidx.compose.runtime.snapshots.StateFactoryMarker;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0000\u001a\"\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\nH\u0007\u001a0\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\b0\f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\nH\u0007\u001a0\u0010\r\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u000e2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0082\b¢\u0006\u0004\b\u0012\u0010\u0013\u001a%\u0010\u0014\u001a\u00020\u0015\"\u0004\b\u0000\u0010\u000e2\u0006\u0010\u0016\u001a\u00020\u00052\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0080\b\u001a*\u0010\u0017\u001a\u0002H\b\"\u0004\b\u0000\u0010\b2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\b0\u0018H\u0082\b¢\u0006\u0004\b\u0019\u0010\u001a\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m13886d2 = {"calculationBlockNestedLevel", "Landroidx/compose/runtime/SnapshotThreadLocal;", "Landroidx/compose/runtime/internal/IntRef;", "derivedStateObservers", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/runtime/DerivedStateObserver;", "derivedStateOf", "Landroidx/compose/runtime/State;", "T", "calculation", "Lkotlin/Function0;", "policy", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "notifyObservers", "R", "derivedState", "Landroidx/compose/runtime/DerivedState;", "block", "notifyObservers$SnapshotStateKt__DerivedStateKt", "(Landroidx/compose/runtime/DerivedState;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "observeDerivedStateRecalculations", "", "observer", "withCalculationNestedLevel", "Lkotlin/Function1;", "withCalculationNestedLevel$SnapshotStateKt__DerivedStateKt", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "runtime_release"}, m13887k = 5, m13888mv = {1, 8, 0}, m13890xi = 48, m13891xs = "androidx/compose/runtime/SnapshotStateKt")
@SourceDebugExtension({"SMAP\nDerivedState.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DerivedState.kt\nandroidx/compose/runtime/SnapshotStateKt__DerivedStateKt\n+ 2 MutableVector.kt\nandroidx/compose/runtime/collection/MutableVectorKt\n+ 3 MutableVector.kt\nandroidx/compose/runtime/collection/MutableVector\n*L\n1#1,400:1\n1188#2:401\n460#3,11:402\n460#3,11:413\n48#3:424\n*S KotlinDebug\n*F\n+ 1 DerivedState.kt\nandroidx/compose/runtime/SnapshotStateKt__DerivedStateKt\n*L\n367#1:401\n373#1:402,11\n377#1:413,11\n397#1:424\n*E\n"})
final /* synthetic */ class SnapshotStateKt__DerivedStateKt {

    @NotNull
    private static final SnapshotThreadLocal<IntRef> calculationBlockNestedLevel = new SnapshotThreadLocal<>();

    @NotNull
    private static final SnapshotThreadLocal<MutableVector<DerivedStateObserver>> derivedStateObservers = new SnapshotThreadLocal<>();

    @NotNull
    public static final MutableVector<DerivedStateObserver> derivedStateObservers() {
        SnapshotThreadLocal<MutableVector<DerivedStateObserver>> snapshotThreadLocal = derivedStateObservers;
        MutableVector<DerivedStateObserver> mutableVector = snapshotThreadLocal.get();
        if (mutableVector != null) {
            return mutableVector;
        }
        MutableVector<DerivedStateObserver> mutableVector2 = new MutableVector<>(new DerivedStateObserver[0], 0);
        snapshotThreadLocal.set(mutableVector2);
        return mutableVector2;
    }

    @StateFactoryMarker
    @NotNull
    public static final <T> State<T> derivedStateOf(@NotNull Function0<? extends T> function0) {
        return new DerivedSnapshotState(function0, null);
    }

    private static final <R> R notifyObservers$SnapshotStateKt__DerivedStateKt(DerivedState<?> derivedState, Function0<? extends R> function0) {
        MutableVector<DerivedStateObserver> mutableVectorDerivedStateObservers = SnapshotStateKt.derivedStateObservers();
        int size = mutableVectorDerivedStateObservers.getSize();
        int i = 0;
        if (size > 0) {
            DerivedStateObserver[] content = mutableVectorDerivedStateObservers.getContent();
            int i2 = 0;
            do {
                content[i2].start(derivedState);
                i2++;
            } while (i2 < size);
        }
        try {
            R rInvoke = function0.invoke();
            InlineMarker.finallyStart(1);
            int size2 = mutableVectorDerivedStateObservers.getSize();
            if (size2 > 0) {
                DerivedStateObserver[] content2 = mutableVectorDerivedStateObservers.getContent();
                do {
                    content2[i].done(derivedState);
                    i++;
                } while (i < size2);
            }
            InlineMarker.finallyEnd(1);
            return rInvoke;
        } catch (Throwable th) {
            InlineMarker.finallyStart(1);
            int size3 = mutableVectorDerivedStateObservers.getSize();
            if (size3 > 0) {
                DerivedStateObserver[] content3 = mutableVectorDerivedStateObservers.getContent();
                do {
                    content3[i].done(derivedState);
                    i++;
                } while (i < size3);
            }
            InlineMarker.finallyEnd(1);
            throw th;
        }
    }

    public static final <R> void observeDerivedStateRecalculations(@NotNull DerivedStateObserver derivedStateObserver, @NotNull Function0<? extends R> function0) {
        MutableVector<DerivedStateObserver> mutableVectorDerivedStateObservers = SnapshotStateKt.derivedStateObservers();
        try {
            mutableVectorDerivedStateObservers.add(derivedStateObserver);
            function0.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            mutableVectorDerivedStateObservers.removeAt(mutableVectorDerivedStateObservers.getSize() - 1);
            InlineMarker.finallyEnd(1);
        }
    }

    private static final <T> T withCalculationNestedLevel$SnapshotStateKt__DerivedStateKt(Function1<? super IntRef, ? extends T> function1) {
        IntRef intRef = (IntRef) calculationBlockNestedLevel.get();
        if (intRef == null) {
            intRef = new IntRef(0);
            calculationBlockNestedLevel.set(intRef);
        }
        return function1.invoke(intRef);
    }

    @StateFactoryMarker
    @NotNull
    public static final <T> State<T> derivedStateOf(@NotNull SnapshotMutationPolicy<T> snapshotMutationPolicy, @NotNull Function0<? extends T> function0) {
        return new DerivedSnapshotState(function0, snapshotMutationPolicy);
    }
}
