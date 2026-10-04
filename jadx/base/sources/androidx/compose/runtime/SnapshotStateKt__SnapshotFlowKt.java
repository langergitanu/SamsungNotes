package androidx.compose.runtime;

import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSet;
import androidx.compose.runtime.collection.ScatterSetWrapper;
import androidx.compose.runtime.snapshots.ObserverHandle;
import androidx.compose.runtime.snapshots.ReaderKind;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.StateObjectImpl;
import java.util.Collection;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;
import org.apache.commons.beanutils.FluentPropertyBeanIntrospector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\u001a \u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\u001a?\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\b\b\u0000\u0010\u0002*\u0002H\u0007\"\u0004\b\u0001\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\b\u001a\u0002H\u00072\b\b\u0002\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\u000b\u001a-\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\f2\b\b\u0002\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\r\u001a%\u0010\u000e\u001a\u00020\u000f*\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013H\u0002¢\u0006\u0002\b\u0014¨\u0006\u0015"}, m13886d2 = {"snapshotFlow", "Lkotlinx/coroutines/flow/Flow;", "T", "block", "Lkotlin/Function0;", "collectAsState", "Landroidx/compose/runtime/State;", "R", "initial", "context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "Lkotlinx/coroutines/flow/StateFlow;", "(Lkotlinx/coroutines/flow/StateFlow;Lkotlin/coroutines/CoroutineContext;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "intersects", "", "Landroidx/collection/MutableScatterSet;", "", FluentPropertyBeanIntrospector.DEFAULT_WRITE_METHOD_PREFIX, "", "intersects$SnapshotStateKt__SnapshotFlowKt", "runtime_release"}, m13887k = 5, m13888mv = {1, 8, 0}, m13890xi = 48, m13891xs = "androidx/compose/runtime/SnapshotStateKt")
@SourceDebugExtension({"SMAP\nSnapshotFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SnapshotFlow.kt\nandroidx/compose/runtime/SnapshotStateKt__SnapshotFlowKt\n+ 2 Composer.kt\nandroidx/compose/runtime/ComposerKt\n+ 3 ScatterSet.kt\nandroidx/collection/ScatterSet\n+ 4 ScatterMap.kt\nandroidx/collection/ScatterMapKt\n*L\n1#1,185:1\n1225#2,6:186\n254#3,2:192\n228#3,4:194\n198#3,7:198\n209#3,3:206\n212#3,9:210\n232#3:219\n256#3:220\n1956#4:205\n1820#4:209\n*S KotlinDebug\n*F\n+ 1 SnapshotFlow.kt\nandroidx/compose/runtime/SnapshotStateKt__SnapshotFlowKt\n*L\n66#1:186,6\n184#1:192,2\n184#1:194,4\n184#1:198,7\n184#1:206,3\n184#1:210,9\n184#1:219\n184#1:220\n184#1:205\n184#1:209\n*E\n"})
final /* synthetic */ class SnapshotStateKt__SnapshotFlowKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@"}, m13886d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/flow/FlowCollector;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1", m14021f = "SnapshotFlow.kt", m14022i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2}, m14023l = {148, 152, 174}, m14024m = "invokeSuspend", m14025n = {"$this$flow", "readSet", "readObserver", "appliedChanges", "unregisterApplyObserver", "lastValue", "$this$flow", "readSet", "readObserver", "appliedChanges", "unregisterApplyObserver", "lastValue", "found", "$this$flow", "readSet", "readObserver", "appliedChanges", "unregisterApplyObserver", "lastValue"}, m14026s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
    @SourceDebugExtension({"SMAP\nSnapshotFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SnapshotFlow.kt\nandroidx/compose/runtime/SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1\n+ 2 Snapshot.kt\nandroidx/compose/runtime/snapshots/Snapshot\n*L\n1#1,185:1\n138#2,5:186\n138#2,5:191\n*S KotlinDebug\n*F\n+ 1 SnapshotFlow.kt\nandroidx/compose/runtime/SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1\n*L\n143#1:186,5\n166#1:191,5\n*E\n"})
    public static final class C19711<T> extends SuspendLambda implements Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<T> $block;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C19711(Function0<? extends T> function0, Continuation<? super C19711> continuation) {
            super(2, continuation);
            this.$block = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C19711 c19711 = new C19711(this.$block, continuation);
            c19711.L$0 = obj;
            return c19711;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Path cross not found for [B:33:0x00cb, B:37:0x00d4], limit reached: 74 */
        /* JADX WARN: Path cross not found for [B:41:0x00e3, B:57:0x0122], limit reached: 74 */
        /* JADX WARN: Path cross not found for [B:57:0x0122, B:41:0x00e3], limit reached: 74 */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00c0  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x00e3 A[Catch: all -> 0x0055, TRY_LEAVE, TryCatch #0 {all -> 0x0055, blocks: (B:15:0x0050, B:31:0x00c7, B:33:0x00cb, B:38:0x00d5, B:41:0x00e3, B:45:0x00f9, B:47:0x0102, B:55:0x011e, B:56:0x0121, B:42:0x00ee, B:44:0x00f6, B:53:0x011a, B:54:0x011d), top: B:68:0x0050, inners: #1 }] */
        /* JADX WARN: Type inference failed for: r10v1, types: [java.lang.Object, kotlinx.coroutines.flow.FlowCollector] */
        /* JADX WARN: Type inference failed for: r10v2, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r10v5 */
        /* JADX WARN: Type inference failed for: r10v6 */
        /* JADX WARN: Type inference failed for: r10v8, types: [kotlinx.coroutines.flow.FlowCollector] */
        /* JADX WARN: Type inference failed for: r11v1 */
        /* JADX WARN: Type inference failed for: r11v2, types: [java.lang.Object, kotlinx.coroutines.flow.FlowCollector] */
        /* JADX WARN: Type inference failed for: r11v5 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            ObserverHandle observerHandleRegisterApplyObserver;
            ?? r10;
            final MutableScatterSet mutableScatterSet;
            Function1<Object, Unit> function1;
            final Channel channelChannel$default;
            Object objInvoke;
            ObserverHandle observerHandle;
            ?? r11;
            MutableScatterSet mutableScatterSet2;
            Function1<Object, Unit> function12;
            Channel channel;
            Object obj2;
            int i;
            Set set;
            Snapshot snapshotTakeSnapshot;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            int i4 = 0;
            int i5 = 1;
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    r10 = (FlowCollector) this.L$0;
                    mutableScatterSet = new MutableScatterSet(i4, i5, null);
                    function1 = new Function1<Object, Unit>() { // from class: androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1$readObserver$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Object obj3) {
                            invoke2(obj3);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull Object obj3) {
                            if (obj3 instanceof StateObjectImpl) {
                                ((StateObjectImpl) obj3).m18129recordReadInh_f27i8$runtime_release(ReaderKind.m18116constructorimpl(4));
                            }
                            mutableScatterSet.add(obj3);
                        }
                    };
                    channelChannel$default = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
                    Snapshot.Companion companion = Snapshot.INSTANCE;
                    observerHandleRegisterApplyObserver = companion.registerApplyObserver(new Function2<Set<? extends Object>, Snapshot, Unit>() { // from class: androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1$unregisterApplyObserver$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Set<? extends Object> set2, Snapshot snapshot) {
                            invoke2(set2, snapshot);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull Set<? extends Object> set2, @NotNull Snapshot snapshot) {
                            if (!(set2 instanceof ScatterSetWrapper)) {
                                Set<? extends Object> set3 = set2;
                                if ((set3 instanceof Collection) && set3.isEmpty()) {
                                    return;
                                }
                                for (Object obj3 : set3) {
                                    if (!(obj3 instanceof StateObjectImpl) || ((StateObjectImpl) obj3).m18128isReadInh_f27i8$runtime_release(ReaderKind.m18116constructorimpl(4))) {
                                    }
                                }
                                return;
                            }
                            ScatterSet set$runtime_release = ((ScatterSetWrapper) set2).getSet$runtime_release();
                            Object[] objArr = set$runtime_release.elements;
                            long[] jArr = set$runtime_release.metadata;
                            int length = jArr.length - 2;
                            if (length < 0) {
                                return;
                            }
                            int i6 = 0;
                            loop0: while (true) {
                                long j = jArr[i6];
                                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                                    int i7 = 8 - ((~(i6 - length)) >>> 31);
                                    for (int i8 = 0; i8 < i7; i8++) {
                                        if ((255 & j) < 128) {
                                            Object obj4 = objArr[(i6 << 3) + i8];
                                            if (!(obj4 instanceof StateObjectImpl) || ((StateObjectImpl) obj4).m18128isReadInh_f27i8$runtime_release(ReaderKind.m18116constructorimpl(4))) {
                                                break loop0;
                                            }
                                        }
                                        j >>= 8;
                                    }
                                    if (i7 != 8) {
                                        return;
                                    }
                                }
                                if (i6 == length) {
                                    return;
                                } else {
                                    i6++;
                                }
                            }
                            channelChannel$default.mo23705trySendJP2dKIU(set2);
                        }
                    });
                    Snapshot snapshotTakeSnapshot2 = companion.takeSnapshot(function1);
                    Function0<T> function0 = this.$block;
                    try {
                        Snapshot snapshotMakeCurrent = snapshotTakeSnapshot2.makeCurrent();
                        try {
                            objInvoke = function0.invoke();
                            snapshotTakeSnapshot2.dispose();
                            this.L$0 = r10;
                            this.L$1 = mutableScatterSet;
                            this.L$2 = function1;
                            this.L$3 = channelChannel$default;
                            this.L$4 = observerHandleRegisterApplyObserver;
                            this.L$5 = objInvoke;
                            this.label = 1;
                            if (r10.emit(objInvoke, this) == coroutine_suspended) {
                            }
                            return coroutine_suspended;
                        } finally {
                        }
                    } finally {
                    }
                }
                if (i2 != 1) {
                    if (i2 == 2) {
                        i = this.I$0;
                        obj2 = this.L$5;
                        observerHandle = (ObserverHandle) this.L$4;
                        channel = (Channel) this.L$3;
                        function12 = (Function1) this.L$2;
                        mutableScatterSet2 = (MutableScatterSet) this.L$1;
                        FlowCollector flowCollector = (FlowCollector) this.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            r11 = flowCollector;
                            set = (Set) obj;
                            do {
                                i = (i == 0 || SnapshotStateKt__SnapshotFlowKt.intersects$SnapshotStateKt__SnapshotFlowKt(mutableScatterSet2, set)) ? 1 : 0;
                                set = (Set) ChannelResult.m23724getOrNullimpl(channel.mo23712tryReceivePtdJZtk());
                            } while (set != null);
                            if (i != 0) {
                                try {
                                    mutableScatterSet2.clear();
                                    snapshotTakeSnapshot = Snapshot.INSTANCE.takeSnapshot(function12);
                                    Function0<T> function02 = this.$block;
                                    try {
                                        objInvoke = function02.invoke();
                                        snapshotTakeSnapshot.dispose();
                                        if (!Intrinsics.areEqual(objInvoke, obj2)) {
                                            this.L$0 = r11;
                                            this.L$1 = mutableScatterSet2;
                                            this.L$2 = function12;
                                            this.L$3 = channel;
                                            this.L$4 = observerHandle;
                                            this.L$5 = objInvoke;
                                            this.label = 3;
                                            if (r11.emit(objInvoke, this) != coroutine_suspended) {
                                                observerHandleRegisterApplyObserver = observerHandle;
                                                channelChannel$default = channel;
                                                function1 = function12;
                                                mutableScatterSet = mutableScatterSet2;
                                                r10 = r11;
                                            }
                                            return coroutine_suspended;
                                        }
                                    } finally {
                                    }
                                } finally {
                                }
                                Snapshot snapshotMakeCurrent2 = snapshotTakeSnapshot.makeCurrent();
                            }
                            objInvoke = obj2;
                            observerHandleRegisterApplyObserver = observerHandle;
                            channelChannel$default = channel;
                            function1 = function12;
                            mutableScatterSet = mutableScatterSet2;
                            r10 = r11;
                        } catch (Throwable th) {
                            th = th;
                            observerHandleRegisterApplyObserver = observerHandle;
                            observerHandleRegisterApplyObserver.dispose();
                            throw th;
                        }
                    } else if (i2 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
                objInvoke = this.L$5;
                observerHandleRegisterApplyObserver = (ObserverHandle) this.L$4;
                channelChannel$default = (Channel) this.L$3;
                function1 = (Function1) this.L$2;
                mutableScatterSet = (MutableScatterSet) this.L$1;
                r10 = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(obj);
                this.L$0 = r10;
                this.L$1 = mutableScatterSet;
                this.L$2 = function1;
                this.L$3 = channelChannel$default;
                this.L$4 = observerHandleRegisterApplyObserver;
                this.L$5 = objInvoke;
                this.I$0 = 0;
                this.label = 2;
                obj = channelChannel$default.receive(this);
                if (obj != coroutine_suspended) {
                    r11 = r10;
                    mutableScatterSet2 = mutableScatterSet;
                    function12 = function1;
                    channel = channelChannel$default;
                    observerHandle = observerHandleRegisterApplyObserver;
                    obj2 = objInvoke;
                    i = 0;
                    set = (Set) obj;
                    do {
                        if (i == 0) {
                        }
                        set = (Set) ChannelResult.m23724getOrNullimpl(channel.mo23712tryReceivePtdJZtk());
                    } while (set != null);
                    if (i != 0) {
                    }
                    objInvoke = obj2;
                    observerHandleRegisterApplyObserver = observerHandle;
                    channelChannel$default = channel;
                    function1 = function12;
                    mutableScatterSet = mutableScatterSet2;
                    r10 = r11;
                    this.L$0 = r10;
                    this.L$1 = mutableScatterSet;
                    this.L$2 = function1;
                    this.L$3 = channelChannel$default;
                    this.L$4 = observerHandleRegisterApplyObserver;
                    this.L$5 = objInvoke;
                    this.I$0 = 0;
                    this.label = 2;
                    obj = channelChannel$default.receive(this);
                    if (obj != coroutine_suspended) {
                    }
                }
                return coroutine_suspended;
            } catch (Throwable th2) {
                th = th2;
                observerHandleRegisterApplyObserver.dispose();
                throw th;
            }
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull FlowCollector<? super T> flowCollector, @Nullable Continuation<? super Unit> continuation) {
            return ((C19711) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Composable
    @NotNull
    public static final <T> State<T> collectAsState(@NotNull StateFlow<? extends T> stateFlow, @Nullable CoroutineContext coroutineContext, @Nullable Composer composer, int i, int i2) {
        if ((i2 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        CoroutineContext coroutineContext2 = coroutineContext;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1439883919, i, -1, "androidx.compose.runtime.collectAsState (SnapshotFlow.kt:49)");
        }
        State<T> stateCollectAsState = SnapshotStateKt.collectAsState(stateFlow, stateFlow.getValue(), coroutineContext2, composer, (i & 14) | ((i << 3) & 896), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return stateCollectAsState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean intersects$SnapshotStateKt__SnapshotFlowKt(MutableScatterSet<Object> mutableScatterSet, Set<? extends Object> set) {
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
                        if ((255 & j) < 128 && set.contains(objArr[(i << 3) + i4])) {
                            return true;
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
        return false;
    }

    @NotNull
    public static final <T> Flow<T> snapshotFlow(@NotNull Function0<? extends T> function0) {
        return FlowKt.flow(new C19711(function0, null));
    }

    @Composable
    @NotNull
    public static final <T extends R, R> State<R> collectAsState(@NotNull Flow<? extends T> flow, R r, @Nullable CoroutineContext coroutineContext, @Nullable Composer composer, int i, int i2) {
        if ((i2 & 2) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        CoroutineContext coroutineContext2 = coroutineContext;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-606625098, i, -1, "androidx.compose.runtime.collectAsState (SnapshotFlow.kt:65)");
        }
        boolean zChangedInstance = composer.changedInstance(coroutineContext2) | composer.changedInstance(flow);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new SnapshotStateKt__SnapshotFlowKt$collectAsState$1$1(coroutineContext2, flow, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        State<R> stateProduceState = SnapshotStateKt.produceState(r, flow, coroutineContext2, (Function2) objRememberedValue, composer, ((i >> 3) & 14) | ((i << 3) & 112) | (i & 896));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return stateProduceState;
    }
}
