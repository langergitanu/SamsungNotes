package androidx.datastore.core;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ClosedSendChannelException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002Bf\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0014\u0010\u0005\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\u001a\u0010\t\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\b0\n\u0012\"\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00020\nø\u0001\u0000¢\u0006\u0002\u0010\rJ\u0013\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00028\u0000¢\u0006\u0002\u0010\u0015R/\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00020\nX\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, m13886d2 = {"Landroidx/datastore/core/SimpleActor;", "T", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "onComplete", "Lkotlin/Function1;", "", "", "onUndeliveredElement", "Lkotlin/Function2;", "consumeMessage", "Lkotlin/coroutines/Continuation;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "messageQueue", "Lkotlinx/coroutines/channels/Channel;", "remainingMessages", "Ljava/util/concurrent/atomic/AtomicInteger;", "offer", "msg", "(Ljava/lang/Object;)V", "datastore-core"}, m13887k = 1, m13888mv = {1, 5, 1}, m13890xi = 48)
public final class SimpleActor<T> {

    @NotNull
    private final Function2<T, Continuation<? super Unit>, Object> consumeMessage;

    @NotNull
    private final Channel<T> messageQueue;

    @NotNull
    private final AtomicInteger remainingMessages;

    @NotNull
    private final CoroutineScope scope;

    /* JADX INFO: renamed from: androidx.datastore.core.SimpleActor$offer$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, m13886d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 5, 1}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.datastore.core.SimpleActor$offer$2", m14021f = "SimpleActor.kt", m14022i = {}, m14023l = {122, 122}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C26142 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ SimpleActor<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C26142(SimpleActor<T> simpleActor, Continuation<? super C26142> continuation) {
            super(2, continuation);
            this.this$0 = simpleActor;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new C26142(this.this$0, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x005f, code lost:
        
            if (r1.invoke(r6, r5) != r0) goto L21;
         */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0056 A[PHI: r1 r6
          0x0056: PHI (r1v1 kotlin.jvm.functions.Function2) = (r1v2 kotlin.jvm.functions.Function2), (r1v4 kotlin.jvm.functions.Function2) binds: [B:16:0x0053, B:9:0x001a] A[DONT_GENERATE, DONT_INLINE]
          0x0056: PHI (r6v8 java.lang.Object) = (r6v15 java.lang.Object), (r6v0 java.lang.Object) binds: [B:16:0x0053, B:9:0x001a] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x005f -> B:21:0x0062). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(@NotNull Object obj) {
            Function2 function2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (!(((SimpleActor) this.this$0).remainingMessages.get() > 0)) {
                    throw new IllegalStateException("Check failed.");
                }
                CoroutineScopeKt.ensureActive(((SimpleActor) this.this$0).scope);
                function2 = ((SimpleActor) this.this$0).consumeMessage;
                Channel channel = ((SimpleActor) this.this$0).messageQueue;
                this.L$0 = function2;
                this.label = 1;
                obj = channel.receive(this);
                if (obj != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                if (((SimpleActor) this.this$0).remainingMessages.decrementAndGet() == 0) {
                    return Unit.INSTANCE;
                }
                CoroutineScopeKt.ensureActive(((SimpleActor) this.this$0).scope);
                function2 = ((SimpleActor) this.this$0).consumeMessage;
                Channel channel2 = ((SimpleActor) this.this$0).messageQueue;
                this.L$0 = function2;
                this.label = 1;
                obj = channel2.receive(this);
                if (obj != coroutine_suspended) {
                    this.L$0 = null;
                    this.label = 2;
                }
                return coroutine_suspended;
            }
            function2 = (Function2) this.L$0;
            ResultKt.throwOnFailure(obj);
            this.L$0 = null;
            this.label = 2;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C26142) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SimpleActor(@NotNull CoroutineScope scope, @NotNull final Function1<? super Throwable, Unit> onComplete, @NotNull final Function2<? super T, ? super Throwable, Unit> onUndeliveredElement, @NotNull Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> consumeMessage) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        Intrinsics.checkNotNullParameter(onUndeliveredElement, "onUndeliveredElement");
        Intrinsics.checkNotNullParameter(consumeMessage, "consumeMessage");
        this.scope = scope;
        this.consumeMessage = consumeMessage;
        this.messageQueue = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        this.remainingMessages = new AtomicInteger(0);
        Job job = (Job) scope.getCoroutineContext().get(Job.INSTANCE);
        if (job == null) {
            return;
        }
        job.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.datastore.core.SimpleActor.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Throwable th) {
                Unit unit;
                onComplete.invoke(th);
                ((SimpleActor) this).messageQueue.close(th);
                do {
                    Object objM23724getOrNullimpl = ChannelResult.m23724getOrNullimpl(((SimpleActor) this).messageQueue.mo23712tryReceivePtdJZtk());
                    if (objM23724getOrNullimpl == null) {
                        unit = null;
                    } else {
                        onUndeliveredElement.invoke((T) objM23724getOrNullimpl, th);
                        unit = Unit.INSTANCE;
                    }
                } while (unit != null);
            }
        });
    }

    public final void offer(T msg) {
        Object objMo23705trySendJP2dKIU = this.messageQueue.mo23705trySendJP2dKIU(msg);
        if (objMo23705trySendJP2dKIU instanceof ChannelResult.Closed) {
            Throwable thM23723exceptionOrNullimpl = ChannelResult.m23723exceptionOrNullimpl(objMo23705trySendJP2dKIU);
            if (thM23723exceptionOrNullimpl != null) {
                throw thM23723exceptionOrNullimpl;
            }
            throw new ClosedSendChannelException("Channel was closed normally");
        }
        if (!ChannelResult.m23729isSuccessimpl(objMo23705trySendJP2dKIU)) {
            throw new IllegalStateException("Check failed.");
        }
        if (this.remainingMessages.getAndIncrement() == 0) {
            BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C26142(this, null), 3, null);
        }
    }
}
