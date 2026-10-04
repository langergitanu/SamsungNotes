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
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002 \u0001*\u00020\u0003H\u008a@"}, m13886d2 = {"<anonymous>", "", "Param", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "com.samsung.android.app.sdk.deepsky.textextraction.util.SingleThreadCoroutineSwitcher$Chain$start$1", m14021f = "SingleThreadCoroutineSwitcher.kt", m14022i = {}, m14023l = {54}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
public final class SingleThreadCoroutineSwitcher$Chain$start$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Throwable, Unit> $onError;
    final /* synthetic */ Function1<Param, Unit> $onSuccess;
    int label;
    final /* synthetic */ SingleThreadCoroutineSwitcher.Chain<Param> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SingleThreadCoroutineSwitcher$Chain$start$1(SingleThreadCoroutineSwitcher.Chain<? extends Param> chain, Function1<? super Param, Unit> function1, Function1<? super Throwable, Unit> function12, Continuation<? super SingleThreadCoroutineSwitcher$Chain$start$1> continuation) {
        super(2, continuation);
        this.this$0 = chain;
        this.$onSuccess = function1;
        this.$onError = function12;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SingleThreadCoroutineSwitcher$Chain$start$1(this.this$0, this.$onSuccess, this.$onError, continuation);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Function1 function1 = ((SingleThreadCoroutineSwitcher.Chain) this.this$0).priorTask;
                this.label = 1;
                obj = function1.invoke(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Function1<Param, Unit> function12 = this.$onSuccess;
            if (function12 != 0) {
                function12.invoke((Param) obj);
            }
        } catch (Throwable th) {
            Function1<Throwable, Unit> function13 = this.$onError;
            if (function13 != null) {
                function13.invoke(th);
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SingleThreadCoroutineSwitcher$Chain$start$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
