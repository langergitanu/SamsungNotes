package androidx.compose.runtime;

import androidx.compose.runtime.MonotonicFrameClock;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\nJ7\u0010\f\u001a\u0002H\r\"\u0004\b\u0000\u0010\r2!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u0002H\r0\u000fH\u0096@¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m13886d2 = {"Landroidx/compose/runtime/PausableMonotonicFrameClock;", "Landroidx/compose/runtime/MonotonicFrameClock;", "frameClock", "(Landroidx/compose/runtime/MonotonicFrameClock;)V", "isPaused", "", "()Z", "latch", "Landroidx/compose/runtime/Latch;", "pause", "", "resume", "withFrameNanos", "R", "onFrame", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "frameTimeNanos", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runtime_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class PausableMonotonicFrameClock implements MonotonicFrameClock {
    public static final int $stable = 8;

    @NotNull
    private final MonotonicFrameClock frameClock;

    @NotNull
    private final Latch latch = new Latch();

    /* JADX INFO: renamed from: androidx.compose.runtime.PausableMonotonicFrameClock$withFrameNanos$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.runtime.PausableMonotonicFrameClock", m14021f = "PausableMonotonicFrameClock.kt", m14022i = {0, 0}, m14023l = {62, 63}, m14024m = "withFrameNanos", m14025n = {"this", "onFrame"}, m14026s = {"L$0", "L$1"})
    public static final class C19491<R> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C19491(Continuation<? super C19491> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PausableMonotonicFrameClock.this.withFrameNanos(null, this);
        }
    }

    public PausableMonotonicFrameClock(@NotNull MonotonicFrameClock monotonicFrameClock) {
        this.frameClock = monotonicFrameClock;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return (R) MonotonicFrameClock.DefaultImpls.fold(this, r, function2);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    @Nullable
    public <E extends CoroutineContext.Element> E get(@NotNull CoroutineContext.Key<E> key) {
        return (E) MonotonicFrameClock.DefaultImpls.get(this, key);
    }

    public final boolean isPaused() {
        return !this.latch.isOpen();
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    @NotNull
    public CoroutineContext minusKey(@NotNull CoroutineContext.Key<?> key) {
        return MonotonicFrameClock.DefaultImpls.minusKey(this, key);
    }

    public final void pause() {
        this.latch.closeLatch();
    }

    @Override // kotlin.coroutines.CoroutineContext
    @NotNull
    public CoroutineContext plus(@NotNull CoroutineContext coroutineContext) {
        return MonotonicFrameClock.DefaultImpls.plus(this, coroutineContext);
    }

    public final void resume() {
        this.latch.openLatch();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.compose.runtime.MonotonicFrameClock
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <R> Object withFrameNanos(@NotNull Function1<? super Long, ? extends R> function1, @NotNull Continuation<? super R> continuation) {
        C19491 c19491;
        PausableMonotonicFrameClock pausableMonotonicFrameClock;
        if (continuation instanceof C19491) {
            c19491 = (C19491) continuation;
            int i = c19491.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c19491.label = i - Integer.MIN_VALUE;
            } else {
                c19491 = new C19491(continuation);
            }
        }
        Object obj = c19491.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c19491.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Latch latch = this.latch;
            c19491.L$0 = this;
            c19491.L$1 = function1;
            c19491.label = 1;
            if (latch.await(c19491) != coroutine_suspended) {
                pausableMonotonicFrameClock = this;
            }
        }
        if (i2 != 1) {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        function1 = (Function1) c19491.L$1;
        pausableMonotonicFrameClock = (PausableMonotonicFrameClock) c19491.L$0;
        ResultKt.throwOnFailure(obj);
        MonotonicFrameClock monotonicFrameClock = pausableMonotonicFrameClock.frameClock;
        c19491.L$0 = null;
        c19491.L$1 = null;
        c19491.label = 2;
        Object objWithFrameNanos = monotonicFrameClock.withFrameNanos(function1, c19491);
        return objWithFrameNanos == coroutine_suspended ? coroutine_suspended : objWithFrameNanos;
    }
}
