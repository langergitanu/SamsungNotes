package kotlinx.coroutines.sync;

import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.SystemPropsKt__SystemProps_commonKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u001a3\u0010\u0005\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u0006*\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00060\bH\u0086H\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\t\u001a\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bH\u0002\"\u000e\u0010\u000f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m13886d2 = {"Semaphore", "Lkotlinx/coroutines/sync/Semaphore;", "permits", "", "acquiredPermits", "withPermit", "T", "action", "Lkotlin/Function0;", "(Lkotlinx/coroutines/sync/Semaphore;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createSegment", "Lkotlinx/coroutines/sync/SemaphoreSegment;", "id", "", "prev", "MAX_SPIN_CYCLES", "PERMIT", "Lkotlinx/coroutines/internal/Symbol;", "TAKEN", "BROKEN", CoeditServiceConstants.ServerResponseCode.SERVER_RESPONSE_CODE_CANCELLED, "SEGMENT_SIZE", "kotlinx-coroutines-core"}, m13887k = 2, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SemaphoreKt {
    private static final int MAX_SPIN_CYCLES = SystemPropsKt__SystemProps_commonKt.systemProp$default("kotlinx.coroutines.semaphore.maxSpinCycles", 100, 0, 0, 12, (Object) null);

    @NotNull
    private static final Symbol PERMIT = new Symbol("PERMIT");

    @NotNull
    private static final Symbol TAKEN = new Symbol("TAKEN");

    @NotNull
    private static final Symbol BROKEN = new Symbol("BROKEN");

    @NotNull
    private static final Symbol CANCELLED = new Symbol(CoeditServiceConstants.ServerResponseCode.SERVER_RESPONSE_CODE_CANCELLED);
    private static final int SEGMENT_SIZE = SystemPropsKt__SystemProps_commonKt.systemProp$default("kotlinx.coroutines.semaphore.segmentSize", 16, 0, 0, 12, (Object) null);

    /* JADX INFO: renamed from: kotlinx.coroutines.sync.SemaphoreKt$withPermit$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 176)
    @DebugMetadata(m14020c = "kotlinx.coroutines.sync.SemaphoreKt", m14021f = "Semaphore.kt", m14022i = {0, 0}, m14023l = {81}, m14024m = "withPermit", m14025n = {"$this$withPermit", "action"}, m14026s = {"L$0", "L$1"})
    public static final class C134701<T> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C134701(Continuation<? super C134701> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SemaphoreKt.withPermit(null, null, this);
        }
    }

    @NotNull
    public static final Semaphore Semaphore(int i, int i2) {
        return new SemaphoreImpl(i, i2);
    }

    public static /* synthetic */ Semaphore Semaphore$default(int i, int i2, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        return Semaphore(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SemaphoreSegment createSegment(long j, SemaphoreSegment semaphoreSegment) {
        return new SemaphoreSegment(j, semaphoreSegment, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object withPermit(@NotNull Semaphore semaphore, @NotNull Function0<? extends T> function0, @NotNull Continuation<? super T> continuation) {
        C134701 c134701;
        if (continuation instanceof C134701) {
            c134701 = (C134701) continuation;
            int i = c134701.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c134701.label = i - Integer.MIN_VALUE;
            } else {
                c134701 = new C134701(continuation);
            }
        }
        Object obj = c134701.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c134701.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            c134701.L$0 = semaphore;
            c134701.L$1 = function0;
            c134701.label = 1;
            if (semaphore.acquire(c134701) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            function0 = (Function0) c134701.L$1;
            semaphore = (Semaphore) c134701.L$0;
            ResultKt.throwOnFailure(obj);
        }
        try {
            return function0.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            semaphore.release();
            InlineMarker.finallyEnd(1);
        }
    }

    private static final <T> Object withPermit$$forInline(Semaphore semaphore, Function0<? extends T> function0, Continuation<? super T> continuation) {
        InlineMarker.mark(0);
        semaphore.acquire(continuation);
        InlineMarker.mark(1);
        try {
            return function0.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            semaphore.release();
            InlineMarker.finallyEnd(1);
        }
    }
}
