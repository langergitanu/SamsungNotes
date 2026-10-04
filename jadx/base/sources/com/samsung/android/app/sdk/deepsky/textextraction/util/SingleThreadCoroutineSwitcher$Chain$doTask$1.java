package com.samsung.android.app.sdk.deepsky.textextraction.util;

import com.samsung.android.app.sdk.deepsky.textextraction.util.SingleThreadCoroutineSwitcher;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "com.samsung.android.app.sdk.deepsky.textextraction.util.SingleThreadCoroutineSwitcher$Chain", m14021f = "SingleThreadCoroutineSwitcher.kt", m14022i = {0, 0, 0, 1}, m14023l = {35, 36}, m14024m = "doTask", m14025n = {"context", "task", "tempResult", "tempResult"}, m14026s = {"L$0", "L$1", "L$2", "L$0"})
public final class SingleThreadCoroutineSwitcher$Chain$doTask$1<Return> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SingleThreadCoroutineSwitcher.Chain<Param> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SingleThreadCoroutineSwitcher$Chain$doTask$1(SingleThreadCoroutineSwitcher.Chain<? extends Param> chain, Continuation<? super SingleThreadCoroutineSwitcher$Chain$doTask$1> continuation) {
        super(continuation);
        this.this$0 = chain;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.doTask(null, null, this);
    }
}
