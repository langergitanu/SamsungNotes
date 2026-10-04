package androidx.room;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.ThreadContextElementKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\u001d\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a\u0015\u0010\u0006\u001a\u00020\u0007*\u00020\bH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\t\u001a9\u0010\n\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u000b*\u00020\b2\u001c\u0010\f\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\rH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, m13886d2 = {"acquireTransactionThread", "Lkotlin/coroutines/ContinuationInterceptor;", "Ljava/util/concurrent/Executor;", "controlJob", "Lkotlinx/coroutines/Job;", "(Ljava/util/concurrent/Executor;Lkotlinx/coroutines/Job;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createTransactionContext", "Lkotlin/coroutines/CoroutineContext;", "Landroidx/room/RoomDatabase;", "(Landroidx/room/RoomDatabase;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withTransaction", "R", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Landroidx/room/RoomDatabase;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "room-ktx_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
@JvmName(name = "RoomDatabaseKt")
public final class RoomDatabaseKt {

    /* JADX INFO: renamed from: androidx.room.RoomDatabaseKt$createTransactionContext$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.room.RoomDatabaseKt", m14021f = "RoomDatabaseExt.kt", m14022i = {0, 0}, m14023l = {100}, m14024m = "createTransactionContext", m14025n = {"$this$createTransactionContext", "controlJob"}, m14026s = {"L$0", "L$1"})
    public static final class C38421 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C38421(Continuation<? super C38421> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RoomDatabaseKt.createTransactionContext(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.room.RoomDatabaseKt$withTransaction$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.room.RoomDatabaseKt", m14021f = "RoomDatabaseExt.kt", m14022i = {0, 0}, m14023l = {51, 52}, m14024m = "withTransaction", m14025n = {"$this$withTransaction", "block"}, m14026s = {"L$0", "L$1"})
    public static final class C38441<R> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C38441(Continuation<? super C38441> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RoomDatabaseKt.withTransaction(null, null, this);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: androidx.room.RoomDatabaseKt$withTransaction$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "R", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.room.RoomDatabaseKt$withTransaction$2", m14021f = "RoomDatabaseExt.kt", m14022i = {0}, m14023l = {59}, m14024m = "invokeSuspend", m14025n = {"transactionElement"}, m14026s = {"L$0"})
    public static final class C38452<R> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super R>, Object> {
        final /* synthetic */ Function1<Continuation<? super R>, Object> $block;
        final /* synthetic */ RoomDatabase $this_withTransaction;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C38452(RoomDatabase roomDatabase, Function1<? super Continuation<? super R>, ? extends Object> function1, Continuation<? super C38452> continuation) {
            super(2, continuation);
            this.$this_withTransaction = roomDatabase;
            this.$block = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C38452 c38452 = new C38452(this.$this_withTransaction, this.$block, continuation);
            c38452.L$0 = obj;
            return c38452;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r0v3 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            Throwable th;
            TransactionElement transactionElement;
            TransactionElement coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineContext.Element element = ((CoroutineScope) this.L$0).getCoroutineContext().get(TransactionElement.INSTANCE);
                    Intrinsics.checkNotNull(element);
                    TransactionElement transactionElement2 = (TransactionElement) element;
                    transactionElement2.acquire();
                    try {
                        this.$this_withTransaction.beginTransaction();
                        try {
                            Function1<Continuation<? super R>, Object> function1 = this.$block;
                            this.L$0 = transactionElement2;
                            this.label = 1;
                            Object objInvoke = function1.invoke(this);
                            if (objInvoke == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            transactionElement = transactionElement2;
                            obj = objInvoke;
                        } catch (Throwable th2) {
                            th = th2;
                            this.$this_withTransaction.endTransaction();
                            throw th;
                        }
                    } catch (Throwable th3) {
                        coroutine_suspended = transactionElement2;
                        th = th3;
                        coroutine_suspended.release();
                        throw th;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    transactionElement = (TransactionElement) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th4) {
                        th = th4;
                        this.$this_withTransaction.endTransaction();
                        throw th;
                    }
                }
                this.$this_withTransaction.setTransactionSuccessful();
                this.$this_withTransaction.endTransaction();
                transactionElement.release();
                return obj;
            } catch (Throwable th5) {
                th = th5;
            }
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super R> continuation) {
            return ((C38452) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object acquireTransactionThread(Executor executor, final Job job, Continuation<? super ContinuationInterceptor> continuation) {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: androidx.room.RoomDatabaseKt$acquireTransactionThread$2$1
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
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
        });
        try {
            executor.execute(new Runnable() { // from class: androidx.room.RoomDatabaseKt$acquireTransactionThread$2$2

                /* JADX INFO: renamed from: androidx.room.RoomDatabaseKt$acquireTransactionThread$2$2$1 */
                /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
                @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
                @DebugMetadata(m14020c = "androidx.room.RoomDatabaseKt$acquireTransactionThread$2$2$1", m14021f = "RoomDatabaseExt.kt", m14022i = {}, m14023l = {125}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
                public static final class C38411 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ CancellableContinuation<ContinuationInterceptor> $continuation;
                    final /* synthetic */ Job $controlJob;
                    private /* synthetic */ Object L$0;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    public C38411(CancellableContinuation<? super ContinuationInterceptor> cancellableContinuation, Job job, Continuation<? super C38411> continuation) {
                        super(2, continuation);
                        this.$continuation = cancellableContinuation;
                        this.$controlJob = job;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @NotNull
                    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                        C38411 c38411 = new C38411(this.$continuation, this.$controlJob, continuation);
                        c38411.L$0 = obj;
                        return c38411;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                            CancellableContinuation<ContinuationInterceptor> cancellableContinuation = this.$continuation;
                            Result.Companion companion = Result.INSTANCE;
                            CoroutineContext.Element element = coroutineScope.getCoroutineContext().get(ContinuationInterceptor.INSTANCE);
                            Intrinsics.checkNotNull(element);
                            cancellableContinuation.resumeWith(Result.m22215constructorimpl(element));
                            Job job = this.$controlJob;
                            this.label = 1;
                            if (job.join(this) == coroutine_suspended) {
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
                        return ((C38411) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    BuildersKt__BuildersKt.runBlocking$default(null, new C38411(cancellableContinuationImpl, job, null), 1, null);
                }
            });
        } catch (RejectedExecutionException e) {
            cancellableContinuationImpl.cancel(new IllegalStateException("Unable to acquire a thread to perform the database transaction.", e));
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object createTransactionContext(RoomDatabase roomDatabase, Continuation<? super CoroutineContext> continuation) {
        C38421 c38421;
        RoomDatabase roomDatabase2;
        CompletableJob completableJob;
        if (continuation instanceof C38421) {
            c38421 = (C38421) continuation;
            int i = c38421.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c38421.label = i - Integer.MIN_VALUE;
            } else {
                c38421 = new C38421(continuation);
            }
        }
        Object obj = c38421.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c38421.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            final CompletableJob completableJobJob$default = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
            Job job = (Job) c38421.get$context().get(Job.INSTANCE);
            if (job != null) {
                job.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.room.RoomDatabaseKt.createTransactionContext.2
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
                        Job.DefaultImpls.cancel$default((Job) completableJobJob$default, (CancellationException) null, 1, (Object) null);
                    }
                });
            }
            Executor transactionExecutor = roomDatabase.getTransactionExecutor();
            c38421.L$0 = roomDatabase;
            c38421.L$1 = completableJobJob$default;
            c38421.label = 1;
            Object objAcquireTransactionThread = acquireTransactionThread(transactionExecutor, completableJobJob$default, c38421);
            if (objAcquireTransactionThread == coroutine_suspended) {
                return coroutine_suspended;
            }
            roomDatabase2 = roomDatabase;
            completableJob = completableJobJob$default;
            obj = objAcquireTransactionThread;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            completableJob = (CompletableJob) c38421.L$1;
            roomDatabase2 = (RoomDatabase) c38421.L$0;
            ResultKt.throwOnFailure(obj);
        }
        ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) obj;
        TransactionElement transactionElement = new TransactionElement(completableJob, continuationInterceptor);
        return continuationInterceptor.plus(transactionElement).plus(ThreadContextElementKt.asContextElement(roomDatabase2.getSuspendingTransactionId(), Boxing.boxInt(System.identityHashCode(completableJob))));
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0063, code lost:
    
        if (r7 == r1) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <R> Object withTransaction(@NotNull RoomDatabase roomDatabase, @NotNull Function1<? super Continuation<? super R>, ? extends Object> function1, @NotNull Continuation<? super R> continuation) {
        C38441 c38441;
        Object objWithContext;
        if (continuation instanceof C38441) {
            c38441 = (C38441) continuation;
            int i = c38441.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c38441.label = i - Integer.MIN_VALUE;
            } else {
                c38441 = new C38441(continuation);
            }
        }
        Object objCreateTransactionContext = c38441.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c38441.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objCreateTransactionContext);
            TransactionElement transactionElement = (TransactionElement) c38441.get$context().get(TransactionElement.INSTANCE);
            if (transactionElement == null || (transactionDispatcher = transactionElement.getTransactionDispatcher()) == null) {
                c38441.L$0 = roomDatabase;
                c38441.L$1 = function1;
                c38441.label = 1;
                objCreateTransactionContext = createTransactionContext(roomDatabase, c38441);
            } else {
                C38452 c38452 = new C38452(roomDatabase, function1, null);
                c38441.L$0 = null;
                c38441.L$1 = null;
                c38441.label = 2;
                objWithContext = BuildersKt.withContext(transactionDispatcher, c38452, c38441);
                if (objWithContext != coroutine_suspended) {
                    return objWithContext;
                }
            }
            return coroutine_suspended;
        }
        if (i2 != 1) {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objCreateTransactionContext);
            return objCreateTransactionContext;
        }
        function1 = (Function1) c38441.L$1;
        roomDatabase = (RoomDatabase) c38441.L$0;
        ResultKt.throwOnFailure(objCreateTransactionContext);
        CoroutineContext transactionDispatcher = (CoroutineContext) objCreateTransactionContext;
        C38452 c384522 = new C38452(roomDatabase, function1, null);
        c38441.L$0 = null;
        c38441.L$1 = null;
        c38441.label = 2;
        objWithContext = BuildersKt.withContext(transactionDispatcher, c384522, c38441);
        if (objWithContext != coroutine_suspended) {
            return coroutine_suspended;
        }
    }
}
