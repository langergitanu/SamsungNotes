package androidx.glance.session;

import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a=\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012'\u0010\u0002\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003¢\u0006\u0002\b\u0007H\u0080@¢\u0006\u0002\u0010\b\u001aG\u0010\t\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\b\b\u0002\u0010\n\u001a\u00020\u000b2'\u0010\u0002\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003¢\u0006\u0002\b\u0007H\u0080@¢\u0006\u0002\u0010\f\u001aI\u0010\r\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u00012\b\b\u0002\u0010\n\u001a\u00020\u000b2'\u0010\u0002\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003¢\u0006\u0002\b\u0007H\u0080@¢\u0006\u0002\u0010\f\u001a,\u0010\u000e\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00010\u0012H\u0002¨\u0006\u0013"}, m13886d2 = {"noopTimer", "T", "block", "Lkotlin/Function2;", "Landroidx/glance/session/TimerScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withTimer", "timeSource", "Landroidx/glance/session/TimeSource;", "(Landroidx/glance/session/TimeSource;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withTimerOrNull", Constants.ARG_UPDATE, "", "Ljava/util/concurrent/atomic/AtomicReference;", "updater", "Lkotlin/Function1;", "glance_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class TimerScopeKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.glance.session.TimerScopeKt$noopTimer$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "T", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.glance.session.TimerScopeKt$noopTimer$2", m14021f = "TimerScope.kt", m14022i = {}, m14023l = {165}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C35192<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
        final /* synthetic */ Function2<TimerScope, Continuation<? super T>, Object> $block;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C35192(Function2<? super TimerScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super C35192> continuation) {
            super(2, continuation);
            this.$block = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C35192 c35192 = new C35192(this.$block, continuation);
            c35192.L$0 = obj;
            return c35192;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            TimerScopeKt$noopTimer$2$timerScope$1 timerScopeKt$noopTimer$2$timerScope$1 = new TimerScopeKt$noopTimer$2$timerScope$1((CoroutineScope) this.L$0);
            Function2<TimerScope, Continuation<? super T>, Object> function2 = this.$block;
            this.label = 1;
            Object objInvoke = function2.invoke(timerScopeKt$noopTimer$2$timerScope$1, this);
            return objInvoke == coroutine_suspended ? coroutine_suspended : objInvoke;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super T> continuation) {
            return ((C35192) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.glance.session.TimerScopeKt$withTimer$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "T", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.glance.session.TimerScopeKt$withTimer$2", m14021f = "TimerScope.kt", m14022i = {0}, m14023l = {86}, m14024m = "invokeSuspend", m14025n = {"timerJob"}, m14026s = {"L$0"})
    public static final class C35202<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
        final /* synthetic */ Function2<TimerScope, Continuation<? super T>, Object> $block;
        final /* synthetic */ TimeSource $timeSource;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.glance.session.TimerScopeKt$withTimer$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "T", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
        @DebugMetadata(m14020c = "androidx.glance.session.TimerScopeKt$withTimer$2$1", m14021f = "TimerScope.kt", m14022i = {}, m14023l = {127}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
            final /* synthetic */ Function2<TimerScope, Continuation<? super T>, Object> $block;
            final /* synthetic */ TimeSource $timeSource;
            final /* synthetic */ AtomicReference<Job> $timerJob;
            final /* synthetic */ CoroutineScope $timerScope;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass1(Function2<? super TimerScope, ? super Continuation<? super T>, ? extends Object> function2, TimeSource timeSource, CoroutineScope coroutineScope, AtomicReference<Job> atomicReference, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$block = function2;
                this.$timeSource = timeSource;
                this.$timerScope = coroutineScope;
                this.$timerJob = atomicReference;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$block, this.$timeSource, this.$timerScope, this.$timerJob, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i != 0) {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                ResultKt.throwOnFailure(obj);
                TimerScopeKt$withTimer$2$1$blockScope$1 timerScopeKt$withTimer$2$1$blockScope$1 = new TimerScopeKt$withTimer$2$1$blockScope$1((CoroutineScope) this.L$0, this.$timeSource, this.$timerScope, this.$block, this.$timerJob);
                Function2<TimerScope, Continuation<? super T>, Object> function2 = this.$block;
                this.label = 1;
                Object objInvoke = function2.invoke(timerScopeKt$withTimer$2$1$blockScope$1, this);
                return objInvoke == coroutine_suspended ? coroutine_suspended : objInvoke;
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super T> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C35202(Function2<? super TimerScope, ? super Continuation<? super T>, ? extends Object> function2, TimeSource timeSource, Continuation<? super C35202> continuation) {
            super(2, continuation);
            this.$block = function2;
            this.$timeSource = timeSource;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C35202 c35202 = new C35202(this.$block, this.$timeSource, continuation);
            c35202.L$0 = obj;
            return c35202;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            AtomicReference atomicReference;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                AtomicReference atomicReference2 = new AtomicReference(null);
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$block, this.$timeSource, coroutineScope, atomicReference2, null);
                this.L$0 = atomicReference2;
                this.label = 1;
                obj = CoroutineScopeKt.coroutineScope(anonymousClass1, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                atomicReference = atomicReference2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                atomicReference = (AtomicReference) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            Job job = (Job) atomicReference.get();
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            return obj;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super T> continuation) {
            return ((C35202) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: androidx.glance.session.TimerScopeKt$withTimerOrNull$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.glance.session.TimerScopeKt", m14021f = "TimerScope.kt", m14022i = {0}, m14023l = {137}, m14024m = "withTimerOrNull", m14025n = {"block"}, m14026s = {"L$0"})
    public static final class C35211<T> extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C35211(Continuation<? super C35211> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TimerScopeKt.withTimerOrNull(null, null, this);
        }
    }

    @Nullable
    public static final <T> Object noopTimer(@NotNull Function2<? super TimerScope, ? super Continuation<? super T>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
        return CoroutineScopeKt.coroutineScope(new C35192(function2, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> void update(AtomicReference<T> atomicReference, Function1<? super T, ? extends T> function1) {
        while (true) {
            Object obj = atomicReference.get();
            T tInvoke = function1.invoke(obj);
            while (!atomicReference.compareAndSet(obj, tInvoke)) {
                if (atomicReference.get() != obj) {
                    break;
                }
            }
            return;
        }
    }

    @Nullable
    public static final <T> Object withTimer(@NotNull TimeSource timeSource, @NotNull Function2<? super TimerScope, ? super Continuation<? super T>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
        return CoroutineScopeKt.coroutineScope(new C35202(function2, timeSource, null), continuation);
    }

    public static /* synthetic */ Object withTimer$default(TimeSource timeSource, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            timeSource = TimeSource.INSTANCE.getMonotonic();
        }
        return withTimer(timeSource, function2, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object withTimerOrNull(@NotNull TimeSource timeSource, @NotNull Function2<? super TimerScope, ? super Continuation<? super T>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
        C35211 c35211;
        if (continuation instanceof C35211) {
            c35211 = (C35211) continuation;
            int i = c35211.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c35211.label = i - Integer.MIN_VALUE;
            } else {
                c35211 = new C35211(continuation);
            }
        }
        Object obj = c35211.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c35211.label;
        try {
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            c35211.L$0 = function2;
            c35211.label = 1;
            Object objWithTimer = withTimer(timeSource, function2, c35211);
            return objWithTimer == coroutine_suspended ? coroutine_suspended : objWithTimer;
        } catch (TimeoutCancellationException e) {
            if (e.getBlock() == function2.hashCode()) {
                return null;
            }
            throw e;
        }
    }

    public static /* synthetic */ Object withTimerOrNull$default(TimeSource timeSource, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            timeSource = TimeSource.INSTANCE.getMonotonic();
        }
        return withTimerOrNull(timeSource, function2, continuation);
    }
}
