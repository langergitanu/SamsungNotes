package androidx.lifecycle.compose;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aG\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u00022\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\u000b\u001aI\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u00022\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\u000e\u001a?\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\u0010\u001aA\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000f2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, m13886d2 = {"collectAsStateWithLifecycle", "Landroidx/compose/runtime/State;", "T", "Lkotlinx/coroutines/flow/Flow;", "initialValue", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "minActiveState", "Landroidx/lifecycle/Lifecycle$State;", "context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;Lkotlin/coroutines/CoroutineContext;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$State;Lkotlin/coroutines/CoroutineContext;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "Lkotlinx/coroutines/flow/StateFlow;", "(Lkotlinx/coroutines/flow/StateFlow;Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;Lkotlin/coroutines/CoroutineContext;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "(Lkotlinx/coroutines/flow/StateFlow;Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$State;Lkotlin/coroutines/CoroutineContext;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "lifecycle-runtime-compose_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nFlowExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FlowExt.kt\nandroidx/lifecycle/compose/FlowExtKt\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 3 Composer.kt\nandroidx/compose/runtime/ComposerKt\n*L\n1#1,181:1\n74#2:182\n74#2:183\n1116#3,6:184\n*S KotlinDebug\n*F\n+ 1 FlowExt.kt\nandroidx/lifecycle/compose/FlowExtKt\n*L\n58#1:182\n131#1:183\n171#1:184,6\n*E\n"})
public final class FlowExtKt {
    @Composable
    @NotNull
    public static final <T> State<T> collectAsStateWithLifecycle(@NotNull StateFlow<? extends T> stateFlow, @Nullable LifecycleOwner lifecycleOwner, @Nullable Lifecycle.State state, @Nullable CoroutineContext coroutineContext, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(743249048);
        if ((i2 & 1) != 0) {
            lifecycleOwner = (LifecycleOwner) composer.consume(LocalLifecycleOwnerKt.getLocalLifecycleOwner());
        }
        if ((i2 & 2) != 0) {
            state = Lifecycle.State.STARTED;
        }
        Lifecycle.State state2 = state;
        if ((i2 & 4) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        CoroutineContext coroutineContext2 = coroutineContext;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(743249048, i, -1, "androidx.lifecycle.compose.collectAsStateWithLifecycle (FlowExt.kt:60)");
        }
        int i4 = i << 3;
        State<T> stateCollectAsStateWithLifecycle = collectAsStateWithLifecycle(stateFlow, stateFlow.getValue(), lifecycleOwner.getLifecycle(), state2, coroutineContext2, composer, (i & 14) | (i4 & 7168) | (i4 & 57344), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return stateCollectAsStateWithLifecycle;
    }

    @Composable
    @NotNull
    public static final <T> State<T> collectAsStateWithLifecycle(@NotNull StateFlow<? extends T> stateFlow, @NotNull Lifecycle lifecycle, @Nullable Lifecycle.State state, @Nullable CoroutineContext coroutineContext, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-1858162195);
        if ((i2 & 2) != 0) {
            state = Lifecycle.State.STARTED;
        }
        Lifecycle.State state2 = state;
        if ((i2 & 4) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        CoroutineContext coroutineContext2 = coroutineContext;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1858162195, i, -1, "androidx.lifecycle.compose.collectAsStateWithLifecycle (FlowExt.kt:95)");
        }
        int i4 = i << 3;
        State<T> stateCollectAsStateWithLifecycle = collectAsStateWithLifecycle(stateFlow, stateFlow.getValue(), lifecycle, state2, coroutineContext2, composer, (i & 14) | (i4 & 896) | (i4 & 7168) | (i4 & 57344), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return stateCollectAsStateWithLifecycle;
    }

    @Composable
    @NotNull
    public static final <T> State<T> collectAsStateWithLifecycle(@NotNull Flow<? extends T> flow, T t, @Nullable LifecycleOwner lifecycleOwner, @Nullable Lifecycle.State state, @Nullable CoroutineContext coroutineContext, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-1485997211);
        LifecycleOwner lifecycleOwner2 = (i2 & 2) != 0 ? (LifecycleOwner) composer.consume(LocalLifecycleOwnerKt.getLocalLifecycleOwner()) : lifecycleOwner;
        Lifecycle.State state2 = (i2 & 4) != 0 ? Lifecycle.State.STARTED : state;
        CoroutineContext coroutineContext2 = (i2 & 8) != 0 ? EmptyCoroutineContext.INSTANCE : coroutineContext;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1485997211, i, -1, "androidx.lifecycle.compose.collectAsStateWithLifecycle (FlowExt.kt:133)");
        }
        State<T> stateCollectAsStateWithLifecycle = collectAsStateWithLifecycle(flow, t, lifecycleOwner2.getLifecycle(), state2, coroutineContext2, composer, (i & 14) | (((i >> 3) & 8) << 3) | (i & 112) | (i & 7168) | (i & 57344), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return stateCollectAsStateWithLifecycle;
    }

    @Composable
    @NotNull
    public static final <T> State<T> collectAsStateWithLifecycle(@NotNull Flow<? extends T> flow, T t, @NotNull Lifecycle lifecycle, @Nullable Lifecycle.State state, @Nullable CoroutineContext coroutineContext, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1977777920);
        if ((i2 & 4) != 0) {
            state = Lifecycle.State.STARTED;
        }
        Lifecycle.State state2 = state;
        if ((i2 & 8) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        CoroutineContext coroutineContext2 = coroutineContext;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1977777920, i, -1, "androidx.lifecycle.compose.collectAsStateWithLifecycle (FlowExt.kt:169)");
        }
        Object[] objArr = {flow, lifecycle, state2, coroutineContext2};
        composer.startReplaceableGroup(710004817);
        boolean zChangedInstance = composer.changedInstance(lifecycle) | ((((i & 7168) ^ 3072) > 2048 && composer.changed(state2)) || (i & 3072) == 2048) | composer.changedInstance(coroutineContext2) | composer.changedInstance(flow);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            FlowExtKt$collectAsStateWithLifecycle$1$1 flowExtKt$collectAsStateWithLifecycle$1$1 = new FlowExtKt$collectAsStateWithLifecycle$1$1(lifecycle, state2, coroutineContext2, flow, null);
            composer.updateRememberedValue(flowExtKt$collectAsStateWithLifecycle$1$1);
            objRememberedValue = flowExtKt$collectAsStateWithLifecycle$1$1;
        }
        composer.endReplaceableGroup();
        State<T> stateProduceState = SnapshotStateKt.produceState((Object) t, objArr, (Function2) objRememberedValue, composer, (i >> 3) & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return stateProduceState;
    }
}
