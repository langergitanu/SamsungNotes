package com.samsung.android.app.sdk.deepsky.textextraction.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/util/SingleThreadCoroutineSwitcher;", "", "()V", "threadContext", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "newChain", "Lcom/samsung/android/app/sdk/deepsky/textextraction/util/SingleThreadCoroutineSwitcher$Chain;", "", "Chain", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class SingleThreadCoroutineSwitcher {

    @NotNull
    public static final SingleThreadCoroutineSwitcher INSTANCE = new SingleThreadCoroutineSwitcher();

    @NotNull
    private static final ExecutorCoroutineDispatcher threadContext;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002B&\u0012\u001c\u0010\u0003\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u0006J5\u0010\b\u001a\u0004\u0018\u0001H\t\"\u0004\b\u0001\u0010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\t0\u0004H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\rJ(\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\t0\u0000\"\u0004\b\u0001\u0010\t2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\t0\u0004J(\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\t0\u0000\"\u0004\b\u0001\u0010\t2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\t0\u0004JT\u0010\u0010\u001a\u00020\u00112%\b\u0002\u0010\u0012\u001a\u001f\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00042%\b\u0002\u0010\u0017\u001a\u001f\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0004R)\u0010\u0003\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/util/SingleThreadCoroutineSwitcher$Chain;", "Param", "", "priorTask", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlin/jvm/functions/Function1;", "doTask", "Return", "context", "Lkotlin/coroutines/CoroutineContext;", "task", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onBackground", "onMain", "start", "Lkotlinx/coroutines/Job;", "onSuccess", "Lkotlin/ParameterName;", "name", "result", "", "onError", "", "exception", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Chain<Param> {

        @NotNull
        private final Function1<Continuation<? super Param>, Object> priorTask;

        /* JADX WARN: Multi-variable type inference failed */
        public Chain(@NotNull Function1<? super Continuation<? super Param>, ? extends Object> priorTask) {
            Intrinsics.checkNotNullParameter(priorTask, "priorTask");
            this.priorTask = priorTask;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final <Return> Object doTask(CoroutineContext coroutineContext, Function1<? super Param, ? extends Return> function1, Continuation<? super Return> continuation) {
            SingleThreadCoroutineSwitcher$Chain$doTask$1 singleThreadCoroutineSwitcher$Chain$doTask$1;
            Ref.ObjectRef objectRef;
            Object objInvoke;
            Ref.ObjectRef objectRef2;
            if (continuation instanceof SingleThreadCoroutineSwitcher$Chain$doTask$1) {
                singleThreadCoroutineSwitcher$Chain$doTask$1 = (SingleThreadCoroutineSwitcher$Chain$doTask$1) continuation;
                int i = singleThreadCoroutineSwitcher$Chain$doTask$1.label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    singleThreadCoroutineSwitcher$Chain$doTask$1.label = i - Integer.MIN_VALUE;
                } else {
                    singleThreadCoroutineSwitcher$Chain$doTask$1 = new SingleThreadCoroutineSwitcher$Chain$doTask$1(this, continuation);
                }
            }
            Object obj = singleThreadCoroutineSwitcher$Chain$doTask$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = singleThreadCoroutineSwitcher$Chain$doTask$1.label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                objectRef = new Ref.ObjectRef();
                Function1<Continuation<? super Param>, Object> function12 = this.priorTask;
                singleThreadCoroutineSwitcher$Chain$doTask$1.L$0 = coroutineContext;
                singleThreadCoroutineSwitcher$Chain$doTask$1.L$1 = function1;
                singleThreadCoroutineSwitcher$Chain$doTask$1.L$2 = objectRef;
                singleThreadCoroutineSwitcher$Chain$doTask$1.label = 1;
                objInvoke = function12.invoke(singleThreadCoroutineSwitcher$Chain$doTask$1);
                if (objInvoke != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                objectRef2 = (Ref.ObjectRef) singleThreadCoroutineSwitcher$Chain$doTask$1.L$0;
                ResultKt.throwOnFailure(obj);
                return objectRef2.element;
            }
            Ref.ObjectRef objectRef3 = (Ref.ObjectRef) singleThreadCoroutineSwitcher$Chain$doTask$1.L$2;
            function1 = (Function1) singleThreadCoroutineSwitcher$Chain$doTask$1.L$1;
            CoroutineContext coroutineContext2 = (CoroutineContext) singleThreadCoroutineSwitcher$Chain$doTask$1.L$0;
            ResultKt.throwOnFailure(obj);
            objectRef = objectRef3;
            coroutineContext = coroutineContext2;
            objInvoke = obj;
            SingleThreadCoroutineSwitcher$Chain$doTask$2 singleThreadCoroutineSwitcher$Chain$doTask$2 = new SingleThreadCoroutineSwitcher$Chain$doTask$2(objectRef, function1, objInvoke, null);
            singleThreadCoroutineSwitcher$Chain$doTask$1.L$0 = objectRef;
            singleThreadCoroutineSwitcher$Chain$doTask$1.L$1 = null;
            singleThreadCoroutineSwitcher$Chain$doTask$1.L$2 = null;
            singleThreadCoroutineSwitcher$Chain$doTask$1.label = 2;
            if (BuildersKt.withContext(coroutineContext, singleThreadCoroutineSwitcher$Chain$doTask$2, singleThreadCoroutineSwitcher$Chain$doTask$1) != coroutine_suspended) {
                objectRef2 = objectRef;
                return objectRef2.element;
            }
            return coroutine_suspended;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Job start$default(Chain chain, Function1 function1, Function1 function12, int i, Object obj) {
            if ((i & 1) != 0) {
                function1 = null;
            }
            if ((i & 2) != 0) {
                function12 = null;
            }
            return chain.start(function1, function12);
        }

        @NotNull
        public final <Return> Chain<Return> onBackground(@NotNull Function1<? super Param, ? extends Return> task) {
            Intrinsics.checkNotNullParameter(task, "task");
            return new Chain<>(new SingleThreadCoroutineSwitcher$Chain$onBackground$1(this, task, null));
        }

        @NotNull
        public final <Return> Chain<Return> onMain(@NotNull Function1<? super Param, ? extends Return> task) {
            Intrinsics.checkNotNullParameter(task, "task");
            return new Chain<>(new SingleThreadCoroutineSwitcher$Chain$onMain$1(this, task, null));
        }

        @NotNull
        public final Job start(@Nullable Function1<? super Param, Unit> onSuccess, @Nullable Function1<? super Throwable, Unit> onError) {
            return BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new SingleThreadCoroutineSwitcher$Chain$start$1(this, onSuccess, onError, null), 3, null);
        }
    }

    /* JADX INFO: renamed from: com.samsung.android.app.sdk.deepsky.textextraction.util.SingleThreadCoroutineSwitcher$newChain$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, m13886d2 = {"<anonymous>", ""}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.samsung.android.app.sdk.deepsky.textextraction.util.SingleThreadCoroutineSwitcher$newChain$1", m14021f = "SingleThreadCoroutineSwitcher.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C71071 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        public C71071(Continuation<? super C71071> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
            return new C71071(continuation);
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

        @Override // kotlin.jvm.functions.Function1
        @Nullable
        public final Object invoke(@Nullable Continuation<? super Unit> continuation) {
            return ((C71071) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    static {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor()");
        threadContext = ExecutorsKt.from(executorServiceNewSingleThreadExecutor);
    }

    private SingleThreadCoroutineSwitcher() {
    }

    @NotNull
    public final Chain<Unit> newChain() {
        return new Chain<>(new C71071(null));
    }
}
