package androidx.glance.appwidget.multiprocess;

import androidx.glance.oneui.common.GlanceLog;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ap\u0010\u0002\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u00020\u00012)\b\u0002\u0010\u0005\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0006¢\u0006\u0002\b\u000b2'\u0010\f\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0006¢\u0006\u0002\b\u000bH\u0086@¢\u0006\u0002\u0010\r\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m13886d2 = {SearchConstants.TargetContents.TAG, "", "withTimer", "T", "key", "timerCallback", "Lkotlin/Function2;", "Landroidx/glance/appwidget/multiprocess/TimerScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "block", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "glance-appwidget_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class TimerScopeKt {

    @NotNull
    private static final String TAG = "GWT:TimerScope";

    /* JADX INFO: renamed from: androidx.glance.appwidget.multiprocess.TimerScopeKt$withTimer$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, m13886d2 = {"<anonymous>", "", "T", "Landroidx/glance/appwidget/multiprocess/TimerScope;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.glance.appwidget.multiprocess.TimerScopeKt$withTimer$2", m14021f = "TimerScope.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C29862 extends SuspendLambda implements Function2<TimerScope, Continuation<? super Unit>, Object> {
        int label;

        public C29862(Continuation<? super C29862> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new C29862(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull TimerScope timerScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C29862) create(timerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.glance.appwidget.multiprocess.TimerScopeKt$withTimer$3 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "T", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.glance.appwidget.multiprocess.TimerScopeKt$withTimer$3", m14021f = "TimerScope.kt", m14022i = {0}, m14023l = {28}, m14024m = "invokeSuspend", m14025n = {"timerJob"}, m14026s = {"L$0"})
    public static final class C29873<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
        final /* synthetic */ Function2<TimerScope, Continuation<? super T>, Object> $block;
        final /* synthetic */ String $key;
        final /* synthetic */ Function2<TimerScope, Continuation<? super Unit>, Object> $timerCallback;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.glance.appwidget.multiprocess.TimerScopeKt$withTimer$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "T", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
        @DebugMetadata(m14020c = "androidx.glance.appwidget.multiprocess.TimerScopeKt$withTimer$3$1", m14021f = "TimerScope.kt", m14022i = {}, m14023l = {47}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
            final /* synthetic */ Function2<TimerScope, Continuation<? super T>, Object> $block;
            final /* synthetic */ String $key;
            final /* synthetic */ Function2<TimerScope, Continuation<? super Unit>, Object> $timerCallback;
            final /* synthetic */ AtomicReference<Job> $timerJob;
            final /* synthetic */ CoroutineScope $timerScope;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass1(Function2<? super TimerScope, ? super Continuation<? super T>, ? extends Object> function2, AtomicReference<Job> atomicReference, CoroutineScope coroutineScope, String str, Function2<? super TimerScope, ? super Continuation<? super Unit>, ? extends Object> function22, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$block = function2;
                this.$timerJob = atomicReference;
                this.$timerScope = coroutineScope;
                this.$key = str;
                this.$timerCallback = function22;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$block, this.$timerJob, this.$timerScope, this.$key, this.$timerCallback, continuation);
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
                TimerScopeKt$withTimer$3$1$blockScope$1 timerScopeKt$withTimer$3$1$blockScope$1 = new TimerScopeKt$withTimer$3$1$blockScope$1((CoroutineScope) this.L$0, this.$timerJob, this.$timerScope, this.$key, this.$timerCallback, this.$block);
                Function2<TimerScope, Continuation<? super T>, Object> function2 = this.$block;
                this.label = 1;
                Object objInvoke = function2.invoke(timerScopeKt$withTimer$3$1$blockScope$1, this);
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
        public C29873(Function2<? super TimerScope, ? super Continuation<? super T>, ? extends Object> function2, String str, Function2<? super TimerScope, ? super Continuation<? super Unit>, ? extends Object> function22, Continuation<? super C29873> continuation) {
            super(2, continuation);
            this.$block = function2;
            this.$key = str;
            this.$timerCallback = function22;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C29873 c29873 = new C29873(this.$block, this.$key, this.$timerCallback, continuation);
            c29873.L$0 = obj;
            return c29873;
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
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$block, atomicReference2, coroutineScope, this.$key, this.$timerCallback, null);
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
            GlanceLog.INSTANCE.m2297d(TimerScopeKt.TAG, "cancel " + obj);
            Job job = (Job) atomicReference.get();
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            return obj;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super T> continuation) {
            return ((C29873) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Nullable
    public static final <T> Object withTimer(@NotNull String str, @NotNull Function2<? super TimerScope, ? super Continuation<? super Unit>, ? extends Object> function2, @NotNull Function2<? super TimerScope, ? super Continuation<? super T>, ? extends Object> function22, @NotNull Continuation<? super T> continuation) {
        return CoroutineScopeKt.coroutineScope(new C29873(function22, str, function2, null), continuation);
    }

    public static /* synthetic */ Object withTimer$default(String str, Function2 function2, Function2 function22, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = new C29862(null);
        }
        return withTimer(str, function2, function22, continuation);
    }
}
