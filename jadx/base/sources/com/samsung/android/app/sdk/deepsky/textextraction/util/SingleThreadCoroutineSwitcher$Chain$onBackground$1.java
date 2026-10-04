package com.samsung.android.app.sdk.deepsky.textextraction.util;

import com.samsung.android.app.sdk.deepsky.textextraction.util.SingleThreadCoroutineSwitcher;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [Return] */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u0004\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001\"\u0006\b\u0001\u0010\u0002 \u0001H\u008a@"}, m13886d2 = {"<anonymous>", "Return", "Param"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "com.samsung.android.app.sdk.deepsky.textextraction.util.SingleThreadCoroutineSwitcher$Chain$onBackground$1", m14021f = "SingleThreadCoroutineSwitcher.kt", m14022i = {}, m14023l = {26}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
public final class SingleThreadCoroutineSwitcher$Chain$onBackground$1<Return> extends SuspendLambda implements Function1<Continuation<? super Return>, Object> {
    final /* synthetic */ Function1<Param, Return> $task;
    int label;
    final /* synthetic */ SingleThreadCoroutineSwitcher.Chain<Param> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SingleThreadCoroutineSwitcher$Chain$onBackground$1(SingleThreadCoroutineSwitcher.Chain<? extends Param> chain, Function1<? super Param, ? extends Return> function1, Continuation<? super SingleThreadCoroutineSwitcher$Chain$onBackground$1> continuation) {
        super(1, continuation);
        this.this$0 = chain;
        this.$task = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new SingleThreadCoroutineSwitcher$Chain$onBackground$1(this.this$0, this.$task, continuation);
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
        SingleThreadCoroutineSwitcher.Chain<Param> chain = this.this$0;
        ExecutorCoroutineDispatcher executorCoroutineDispatcher = SingleThreadCoroutineSwitcher.threadContext;
        Function1<Param, Return> function1 = this.$task;
        this.label = 1;
        Object objDoTask = chain.doTask(executorCoroutineDispatcher, function1, this);
        return objDoTask == coroutine_suspended ? coroutine_suspended : objDoTask;
    }

    @Override // kotlin.jvm.functions.Function1
    @Nullable
    public final Object invoke(@Nullable Continuation<? super Return> continuation) {
        return ((SingleThreadCoroutineSwitcher$Chain$onBackground$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
