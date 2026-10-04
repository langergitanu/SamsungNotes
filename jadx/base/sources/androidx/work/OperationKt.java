package androidx.work;

import androidx.work.Operation;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0003\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0004"}, m13886d2 = {"await", "Landroidx/work/Operation$State$SUCCESS;", "Landroidx/work/Operation;", "(Landroidx/work/Operation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "work-runtime_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nOperation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Operation.kt\nandroidx/work/OperationKt\n+ 2 ListenableFuture.kt\nandroidx/work/ListenableFutureKt\n+ 3 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,30:1\n40#2,8:31\n48#2:48\n60#2,7:49\n48#2:58\n60#2,7:59\n314#3,9:39\n323#3,2:56\n*S KotlinDebug\n*F\n+ 1 Operation.kt\nandroidx/work/OperationKt\n*L\n29#1:31,8\n29#1:48\n29#1:49,7\n29#1:58\n29#1:59,7\n29#1:39,9\n29#1:56,2\n*E\n"})
public final class OperationKt {

    /* JADX INFO: renamed from: androidx.work.OperationKt$await$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 176)
    @DebugMetadata(m14020c = "androidx.work.OperationKt", m14021f = "Operation.kt", m14022i = {0}, m14023l = {39}, m14024m = "await", m14025n = {"$this$await$iv"}, m14026s = {"L$0"})
    @SourceDebugExtension({"SMAP\nOperation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Operation.kt\nandroidx/work/OperationKt$await$1\n*L\n1#1,30:1\n*E\n"})
    public static final class C40291 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C40291(Continuation<? super C40291> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OperationKt.await(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object await(@NotNull Operation operation, @NotNull Continuation<? super Operation.State.SUCCESS> continuation) throws Throwable {
        C40291 c40291;
        Object obj;
        if (continuation instanceof C40291) {
            c40291 = (C40291) continuation;
            int i = c40291.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c40291.label = i - Integer.MIN_VALUE;
            } else {
                c40291 = new C40291(continuation);
            }
        }
        Object result = c40291.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c40291.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(result);
            ListenableFuture<Operation.State.SUCCESS> result2 = operation.getResult();
            Intrinsics.checkNotNullExpressionValue(result2, "result");
            if (result2.isDone()) {
                try {
                    obj = result2.get();
                    Intrinsics.checkNotNullExpressionValue(obj, "result.await()");
                    return obj;
                } catch (ExecutionException e) {
                    Throwable cause = e.getCause();
                    if (cause == null) {
                        throw e;
                    }
                    throw cause;
                }
            }
            c40291.L$0 = result2;
            c40291.label = 1;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(c40291), 1);
            cancellableContinuationImpl.initCancellability();
            result2.addListener(new ListenableFutureKt$await$2$1(cancellableContinuationImpl, result2), DirectExecutor.INSTANCE);
            cancellableContinuationImpl.invokeOnCancellation(new ListenableFutureKt$await$2$2(result2));
            result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(c40291);
            }
            if (result == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(result);
        }
        obj = result;
        Intrinsics.checkNotNullExpressionValue(obj, "result.await()");
        return obj;
    }

    private static final Object await$$forInline(Operation operation, Continuation<? super Operation.State.SUCCESS> continuation) throws Throwable {
        Object result;
        ListenableFuture<Operation.State.SUCCESS> result2 = operation.getResult();
        Intrinsics.checkNotNullExpressionValue(result2, "result");
        ListenableFuture<Operation.State.SUCCESS> listenableFuture = result2;
        if (listenableFuture.isDone()) {
            try {
                result = listenableFuture.get();
            } catch (ExecutionException e) {
                Throwable cause = e.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw e;
            }
        } else {
            InlineMarker.mark(0);
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
            cancellableContinuationImpl.initCancellability();
            listenableFuture.addListener(new ListenableFutureKt$await$2$1(cancellableContinuationImpl, listenableFuture), DirectExecutor.INSTANCE);
            cancellableContinuationImpl.invokeOnCancellation(new ListenableFutureKt$await$2$2(listenableFuture));
            Unit unit = Unit.INSTANCE;
            result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            InlineMarker.mark(1);
        }
        Intrinsics.checkNotNullExpressionValue(result, "result.await()");
        return result;
    }
}
