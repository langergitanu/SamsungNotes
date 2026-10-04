package androidx.test.core.view;

import androidx.concurrent.futures.ResolvableFuture;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import opennlp.tools.namefind.BilouCodec;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0006\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JW\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2'\u0010\u000f\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0010¢\u0006\u0002\b\u0013ø\u0001\u0000¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, m13886d2 = {"Landroidx/test/core/view/SuspendToFutureAdapter;", "", "()V", "GlobalListenableFutureAwaitContext", "Lkotlinx/coroutines/CoroutineDispatcher;", "GlobalListenableFutureScope", "androidx/test/core/view/SuspendToFutureAdapter$GlobalListenableFutureScope$1", "Landroidx/test/core/view/SuspendToFutureAdapter$GlobalListenableFutureScope$1;", "launchFuture", "Lcom/google/common/util/concurrent/ListenableFuture;", "T", "context", "Lkotlin/coroutines/CoroutineContext;", "launchUndispatched", "", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/CoroutineContext;ZLkotlin/jvm/functions/Function2;)Lcom/google/common/util/concurrent/ListenableFuture;", "DeferredFuture", "core_java_androidx_test_core-core_internal_kt"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class SuspendToFutureAdapter {

    @NotNull
    public static final SuspendToFutureAdapter INSTANCE = new SuspendToFutureAdapter();

    @NotNull
    private static final SuspendToFutureAdapter$GlobalListenableFutureScope$1 GlobalListenableFutureScope = new CoroutineScope() { // from class: androidx.test.core.view.SuspendToFutureAdapter$GlobalListenableFutureScope$1

        @NotNull
        private final CoroutineContext coroutineContext = Dispatchers.getMain();

        @Override // kotlinx.coroutines.CoroutineScope
        @NotNull
        public CoroutineContext getCoroutineContext() {
            return this.coroutineContext;
        }
    };

    @NotNull
    private static final CoroutineDispatcher GlobalListenableFutureAwaitContext = Dispatchers.getUnconfined();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\r\u0010\u0017\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0018J\u001e\u0010\u0017\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0096\u0002¢\u0006\u0002\u0010\u001dJ\b\u0010\u001e\u001a\u00020\u0015H\u0016J\b\u0010\u001f\u001a\u00020\u0015H\u0016J\u001e\u0010 \u001a\u00020\u000f2\f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\"H\u0016ø\u0001\u0000¢\u0006\u0002\u0010#R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR2\u0010\u000b\u001a&\u0012\f\u0012\n \r*\u0004\u0018\u00018\u00008\u0000 \r*\u0012\u0012\f\u0012\n \r*\u0004\u0018\u00018\u00008\u0000\u0018\u00010\f0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006$"}, m13886d2 = {"Landroidx/test/core/view/SuspendToFutureAdapter$DeferredFuture;", "T", "Lcom/google/common/util/concurrent/ListenableFuture;", "Lkotlin/coroutines/Continuation;", "resultDeferred", "Lkotlinx/coroutines/Deferred;", "(Lkotlinx/coroutines/Deferred;)V", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "delegateFuture", "Landroidx/concurrent/futures/ResolvableFuture;", "kotlin.jvm.PlatformType", "addListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Ljava/lang/Runnable;", "executor", "Ljava/util/concurrent/Executor;", "cancel", "", "shouldInterrupt", "get", "()Ljava/lang/Object;", "timeout", "", BilouCodec.UNIT, "Ljava/util/concurrent/TimeUnit;", "(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;", "isCancelled", "isDone", "resumeWith", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "core_java_androidx_test_core-core_internal_kt"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class DeferredFuture<T> implements ListenableFuture<T>, Continuation<T> {
        private final ResolvableFuture<T> delegateFuture;

        @NotNull
        private final Deferred<T> resultDeferred;

        /* JADX WARN: Multi-variable type inference failed */
        public DeferredFuture(@NotNull Deferred<? extends T> resultDeferred) {
            Intrinsics.checkNotNullParameter(resultDeferred, "resultDeferred");
            this.resultDeferred = resultDeferred;
            this.delegateFuture = ResolvableFuture.create();
        }

        @Override // com.google.common.util.concurrent.ListenableFuture
        public void addListener(@NotNull Runnable listener, @NotNull Executor executor) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            Intrinsics.checkNotNullParameter(executor, "executor");
            this.delegateFuture.addListener(listener, executor);
        }

        @Override // java.util.concurrent.Future
        public boolean cancel(boolean shouldInterrupt) {
            boolean zCancel = this.delegateFuture.cancel(shouldInterrupt);
            if (zCancel) {
                Job.DefaultImpls.cancel$default((Job) this.resultDeferred, (CancellationException) null, 1, (Object) null);
            }
            return zCancel;
        }

        @Override // java.util.concurrent.Future
        public T get() {
            return this.delegateFuture.get();
        }

        @Override // kotlin.coroutines.Continuation
        @NotNull
        /* JADX INFO: renamed from: getContext */
        public CoroutineContext get$context() {
            return SuspendToFutureAdapter.GlobalListenableFutureAwaitContext;
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return this.delegateFuture.isCancelled();
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return this.delegateFuture.isDone();
        }

        @Override // kotlin.coroutines.Continuation
        public void resumeWith(@NotNull Object result) {
            Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(result);
            if (thM22218exceptionOrNullimpl == null) {
                this.delegateFuture.set(result);
            } else if (thM22218exceptionOrNullimpl instanceof CancellationException) {
                this.delegateFuture.cancel(false);
            } else {
                this.delegateFuture.setException(thM22218exceptionOrNullimpl);
            }
        }

        @Override // java.util.concurrent.Future
        public T get(long timeout, @NotNull TimeUnit unit) {
            Intrinsics.checkNotNullParameter(unit, "unit");
            return this.delegateFuture.get(timeout, unit);
        }
    }

    private SuspendToFutureAdapter() {
    }

    public static /* synthetic */ ListenableFuture launchFuture$default(SuspendToFutureAdapter suspendToFutureAdapter, CoroutineContext coroutineContext, boolean z, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i & 2) != 0) {
            z = true;
        }
        return suspendToFutureAdapter.launchFuture(coroutineContext, z, function2);
    }

    @NotNull
    public final <T> ListenableFuture<T> launchFuture(@NotNull CoroutineContext context, boolean launchUndispatched, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(block, "block");
        Deferred deferredAsync = BuildersKt.async(GlobalListenableFutureScope, context, launchUndispatched ? CoroutineStart.UNDISPATCHED : CoroutineStart.DEFAULT, block);
        DeferredFuture deferredFuture = new DeferredFuture(deferredAsync);
        Continuation<Unit> continuationCreateCoroutine = ContinuationKt.createCoroutine(new SuspendToFutureAdapter$launchFuture$1$1(deferredAsync), deferredFuture);
        Result.Companion companion = Result.INSTANCE;
        continuationCreateCoroutine.resumeWith(Result.m22215constructorimpl(Unit.INSTANCE));
        return deferredFuture;
    }
}
