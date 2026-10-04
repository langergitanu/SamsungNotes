package androidx.work.multiprocess;

import android.content.Context;
import androidx.work.Data;
import androidx.work.DirectExecutor;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p004A2.RunnableC0015b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\f\u001a\u00020\tH¦@ø\u0001\u0000¢\u0006\u0002\u0010\rJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u0019\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u0015H\u0016R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, m13886d2 = {"Landroidx/work/multiprocess/RemoteCoroutineWorker;", "Landroidx/work/multiprocess/RemoteListenableWorker;", "context", "Landroid/content/Context;", "parameters", "Landroidx/work/WorkerParameters;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "future", "Landroidx/work/impl/utils/futures/SettableFuture;", "Landroidx/work/ListenableWorker$Result;", "job", "Lkotlinx/coroutines/CompletableJob;", "doRemoteWork", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onStopped", "", "setProgress", "data", "Landroidx/work/Data;", "(Landroidx/work/Data;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startRemoteWork", "Lcom/google/common/util/concurrent/ListenableFuture;", "work-multiprocess_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nRemoteCoroutineWorker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RemoteCoroutineWorker.kt\nandroidx/work/multiprocess/RemoteCoroutineWorker\n+ 2 ListenableFuture.kt\nandroidx/work/ListenableFutureKt\n+ 3 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,99:1\n40#2,8:100\n48#2:117\n60#2,7:118\n314#3,9:108\n323#3,2:125\n*S KotlinDebug\n*F\n+ 1 RemoteCoroutineWorker.kt\nandroidx/work/multiprocess/RemoteCoroutineWorker\n*L\n91#1:100,8\n91#1:117\n91#1:118,7\n91#1:108,9\n91#1:125,2\n*E\n"})
public abstract class RemoteCoroutineWorker extends RemoteListenableWorker {

    @NotNull
    private final SettableFuture<ListenableWorker.Result> future;

    @NotNull
    private final CompletableJob job;

    /* JADX INFO: renamed from: androidx.work.multiprocess.RemoteCoroutineWorker$startRemoteWork$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.work.multiprocess.RemoteCoroutineWorker$startRemoteWork$1", m14021f = "RemoteCoroutineWorker.kt", m14022i = {}, m14023l = {75}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C41241 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public C41241(Continuation<? super C41241> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return RemoteCoroutineWorker.this.new C41241(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    RemoteCoroutineWorker remoteCoroutineWorker = RemoteCoroutineWorker.this;
                    this.label = 1;
                    obj = remoteCoroutineWorker.doRemoteWork(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                RemoteCoroutineWorker.this.future.set((ListenableWorker.Result) obj);
            } catch (Throwable th) {
                RemoteCoroutineWorker.this.future.setException(th);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C41241) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RemoteCoroutineWorker(@NotNull Context context, @NotNull WorkerParameters parameters) {
        super(context, parameters);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        this.job = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
        SettableFuture<ListenableWorker.Result> settableFutureCreate = SettableFuture.create();
        Intrinsics.checkNotNullExpressionValue(settableFutureCreate, "create()");
        this.future = settableFutureCreate;
        settableFutureCreate.addListener(new RunnableC0015b(this, 25), getTaskExecutor().getSerialTaskExecutor());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(RemoteCoroutineWorker this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.future.isCancelled()) {
            Job.DefaultImpls.cancel$default((Job) this$0.job, (CancellationException) null, 1, (Object) null);
        }
    }

    @Nullable
    public abstract Object doRemoteWork(@NotNull Continuation<? super ListenableWorker.Result> continuation);

    @Override // androidx.work.multiprocess.RemoteListenableWorker, androidx.work.ListenableWorker
    public final void onStopped() {
        super.onStopped();
        this.future.cancel(true);
    }

    @Nullable
    public final Object setProgress(@NotNull Data data, @NotNull Continuation<? super Unit> continuation) throws Throwable {
        final ListenableFuture<Void> progressAsync = setProgressAsync(data);
        Intrinsics.checkNotNullExpressionValue(progressAsync, "setProgressAsync(data)");
        if (progressAsync.isDone()) {
            try {
                progressAsync.get();
            } catch (ExecutionException e) {
                Throwable cause = e.getCause();
                if (cause == null) {
                    throw e;
                }
                throw cause;
            }
        } else {
            final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
            cancellableContinuationImpl.initCancellability();
            progressAsync.addListener(new Runnable() { // from class: androidx.work.multiprocess.RemoteCoroutineWorker$setProgress$$inlined$await$1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
                        Result.Companion companion = Result.INSTANCE;
                        cancellableContinuation.resumeWith(Result.m22215constructorimpl(progressAsync.get()));
                    } catch (Throwable th) {
                        Throwable cause2 = th.getCause();
                        if (cause2 == null) {
                            cause2 = th;
                        }
                        if (th instanceof CancellationException) {
                            cancellableContinuationImpl.cancel(cause2);
                            return;
                        }
                        CancellableContinuation cancellableContinuation2 = cancellableContinuationImpl;
                        Result.Companion companion2 = Result.INSTANCE;
                        cancellableContinuation2.resumeWith(Result.m22215constructorimpl(ResultKt.createFailure(cause2)));
                    }
                }
            }, DirectExecutor.INSTANCE);
            cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: androidx.work.multiprocess.RemoteCoroutineWorker$setProgress$$inlined$await$2
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
                    progressAsync.cancel(false);
                }
            });
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return result;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.work.multiprocess.RemoteListenableWorker
    @NotNull
    public ListenableFuture<ListenableWorker.Result> startRemoteWork() {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault().plus(this.job)), null, null, new C41241(null), 3, null);
        return this.future;
    }
}
