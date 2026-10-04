package androidx.glance.appwidget.multiprocess;

import android.content.Context;
import androidx.compose.runtime.Recomposer;
import androidx.glance.Emittable;
import androidx.glance.EmittableWithChildren;
import androidx.glance.appwidget.RemoteViewsRoot;
import androidx.glance.oneui.common.GlanceLog;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "androidx.glance.appwidget.multiprocess.CoroutineSession$runComposition$3$1$2", m14021f = "CoroutineSession.kt", m14022i = {}, m14023l = {94}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
public final class CoroutineSession$runComposition$3$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Recomposer $recomposer;
    final /* synthetic */ RemoteViewsRoot $root;
    final /* synthetic */ CoroutineScope $this_runCatching;
    final /* synthetic */ MutableStateFlow<Boolean> $uiReady;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CoroutineSession this$0;

    /* JADX INFO: renamed from: androidx.glance.appwidget.multiprocess.CoroutineSession$runComposition$3$1$2$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m13886d2 = {"<anonymous>", "", "state", "Landroidx/compose/runtime/Recomposer$State;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.glance.appwidget.multiprocess.CoroutineSession$runComposition$3$1$2$1", m14021f = "CoroutineSession.kt", m14022i = {}, m14023l = {104, 114}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C29751 extends SuspendLambda implements Function2<Recomposer.State, Continuation<? super Unit>, Object> {
        final /* synthetic */ CoroutineScope $$this$launch;
        final /* synthetic */ Context $context;
        final /* synthetic */ Ref.LongRef $lastRecomposeCount;
        final /* synthetic */ Recomposer $recomposer;
        final /* synthetic */ RemoteViewsRoot $root;
        final /* synthetic */ CoroutineScope $this_runCatching;
        final /* synthetic */ MutableStateFlow<Boolean> $uiReady;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ CoroutineSession this$0;

        /* JADX INFO: renamed from: androidx.glance.appwidget.multiprocess.CoroutineSession$runComposition$3$1$2$1$WhenMappings */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Recomposer.State.values().length];
                try {
                    iArr[Recomposer.State.Idle.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Recomposer.State.ShutDown.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C29751(Recomposer recomposer, Ref.LongRef longRef, MutableStateFlow<Boolean> mutableStateFlow, RemoteViewsRoot remoteViewsRoot, CoroutineSession coroutineSession, Context context, CoroutineScope coroutineScope, CoroutineScope coroutineScope2, Continuation<? super C29751> continuation) {
            super(2, continuation);
            this.$recomposer = recomposer;
            this.$lastRecomposeCount = longRef;
            this.$uiReady = mutableStateFlow;
            this.$root = remoteViewsRoot;
            this.this$0 = coroutineSession;
            this.$context = context;
            this.$this_runCatching = coroutineScope;
            this.$$this$launch = coroutineScope2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C29751 c29751 = new C29751(this.$recomposer, this.$lastRecomposeCount, this.$uiReady, this.$root, this.this$0, this.$context, this.$this_runCatching, this.$$this$launch, continuation);
            c29751.L$0 = obj;
            return c29751;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull Recomposer.State state, @Nullable Continuation<? super Unit> continuation) {
            return ((C29751) create(state, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:32:0x00bb, code lost:
        
            if (r10.emit(r1, r9) != r0) goto L34;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(@NotNull Object obj) {
            boolean zBooleanValue;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
            } catch (Exception e) {
                GlanceLog.INSTANCE.m2305w("GWT:CoroutineSession", "Exception " + e + " occurred while processEmittableTree");
                JobKt__JobKt.cancel$default(this.$this_runCatching.getCoroutineContext(), (CancellationException) null, 1, (Object) null);
                zBooleanValue = true;
            }
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                int i2 = WhenMappings.$EnumSwitchMapping$0[((Recomposer.State) this.L$0).ordinal()];
                if (i2 == 1) {
                    if (this.$recomposer.getChangeCount() > this.$lastRecomposeCount.element || !this.$uiReady.getValue().booleanValue()) {
                        Emittable emittableCopy = this.$root.copy();
                        Intrinsics.checkNotNull(emittableCopy, "null cannot be cast to non-null type androidx.glance.EmittableWithChildren");
                        CoroutineSession coroutineSession = this.this$0;
                        Context context = this.$context;
                        this.label = 1;
                        obj = coroutineSession.processEmittableTree(context, (EmittableWithChildren) emittableCopy, this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        zBooleanValue = ((Boolean) obj).booleanValue();
                        if (!this.$uiReady.getValue().booleanValue()) {
                            MutableStateFlow<Boolean> mutableStateFlow = this.$uiReady;
                            Boolean boolBoxBoolean = Boxing.boxBoolean(true);
                            this.label = 2;
                        }
                    }
                    this.$lastRecomposeCount.element = this.$recomposer.getChangeCount();
                } else if (i2 == 2) {
                    CoroutineScopeKt.cancel$default(this.$$this$launch, null, 1, null);
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
                zBooleanValue = ((Boolean) obj).booleanValue();
                if (!this.$uiReady.getValue().booleanValue() && zBooleanValue) {
                    MutableStateFlow<Boolean> mutableStateFlow2 = this.$uiReady;
                    Boolean boolBoxBoolean2 = Boxing.boxBoolean(true);
                    this.label = 2;
                }
                this.$lastRecomposeCount.element = this.$recomposer.getChangeCount();
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$lastRecomposeCount.element = this.$recomposer.getChangeCount();
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutineSession$runComposition$3$1$2(Recomposer recomposer, MutableStateFlow<Boolean> mutableStateFlow, RemoteViewsRoot remoteViewsRoot, CoroutineSession coroutineSession, Context context, CoroutineScope coroutineScope, Continuation<? super CoroutineSession$runComposition$3$1$2> continuation) {
        super(2, continuation);
        this.$recomposer = recomposer;
        this.$uiReady = mutableStateFlow;
        this.$root = remoteViewsRoot;
        this.this$0 = coroutineSession;
        this.$context = context;
        this.$this_runCatching = coroutineScope;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        CoroutineSession$runComposition$3$1$2 coroutineSession$runComposition$3$1$2 = new CoroutineSession$runComposition$3$1$2(this.$recomposer, this.$uiReady, this.$root, this.this$0, this.$context, this.$this_runCatching, continuation);
        coroutineSession$runComposition$3$1$2.L$0 = obj;
        return coroutineSession$runComposition$3$1$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Ref.LongRef longRef = new Ref.LongRef();
            longRef.element = this.$recomposer.getChangeCount();
            StateFlow<Recomposer.State> currentState = this.$recomposer.getCurrentState();
            C29751 c29751 = new C29751(this.$recomposer, longRef, this.$uiReady, this.$root, this.this$0, this.$context, this.$this_runCatching, coroutineScope, null);
            this.label = 1;
            if (FlowKt.collectLatest(currentState, c29751, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((CoroutineSession$runComposition$3$1$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
