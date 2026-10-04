package com.google.android.appfunctions.service;

import android.content.Context;
import com.google.android.appfunctions.AppFunctionContext;
import com.google.android.appfunctions.ExecuteAppFunctionRequest;
import com.google.android.appfunctions.internal.AppFunctionInvoker;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "com.google.android.appfunctions.service.AppFunctionServiceDelegate$invokeFunctionInternal$result$1", m14021f = "AppFunctionServiceDelegate.kt", m14022i = {}, m14023l = {114}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
public final class AppFunctionServiceDelegate$invokeFunctionInternal$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Object>, Object> {
    final /* synthetic */ String $callingPackageName;
    final /* synthetic */ ExecuteAppFunctionRequest $executeAppFunctionRequest;
    final /* synthetic */ Map<String, Object> $paramList;
    int label;
    final /* synthetic */ AppFunctionServiceDelegate this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppFunctionServiceDelegate$invokeFunctionInternal$result$1(AppFunctionServiceDelegate appFunctionServiceDelegate, String str, ExecuteAppFunctionRequest executeAppFunctionRequest, Map<String, ? extends Object> map, Continuation<? super AppFunctionServiceDelegate$invokeFunctionInternal$result$1> continuation) {
        super(2, continuation);
        this.this$0 = appFunctionServiceDelegate;
        this.$callingPackageName = str;
        this.$executeAppFunctionRequest = executeAppFunctionRequest;
        this.$paramList = map;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AppFunctionServiceDelegate$invokeFunctionInternal$result$1(this.this$0, this.$callingPackageName, this.$executeAppFunctionRequest, this.$paramList, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Object> continuation) {
        return invoke2(coroutineScope, (Continuation<Object>) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
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
        AppFunctionInvoker appFunctionInvoker = this.this$0.appFunctionInvoker;
        AppFunctionServiceDelegate appFunctionServiceDelegate = this.this$0;
        Context context = appFunctionServiceDelegate.appContext;
        Intrinsics.checkNotNullExpressionValue(context, "access$getAppContext$p(...)");
        AppFunctionContext appFunctionContextPrepareAppFunctionContext = appFunctionServiceDelegate.prepareAppFunctionContext(context, this.$callingPackageName);
        String functionIdentifier = this.$executeAppFunctionRequest.getFunctionIdentifier();
        Map<String, ? extends Object> map = this.$paramList;
        this.label = 1;
        Object objUnsafeInvoke = appFunctionInvoker.unsafeInvoke(appFunctionContextPrepareAppFunctionContext, functionIdentifier, map, this);
        return objUnsafeInvoke == coroutine_suspended ? coroutine_suspended : objUnsafeInvoke;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<Object> continuation) {
        return ((AppFunctionServiceDelegate$invokeFunctionInternal$result$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
