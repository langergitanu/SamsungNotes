package com.microsoft.identity.common.internal.activebrokerdiscovery;

import com.microsoft.identity.common.internal.broker.BrokerData;
import com.microsoft.identity.common.internal.broker.ipc.IIpcStrategy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.microsoft.identity.common.internal.activebrokerdiscovery.BrokerDiscoveryClient$Companion$queryFromBroker$2$deferredResults$1$1 */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "Lcom/microsoft/identity/common/internal/broker/BrokerData;", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
@DebugMetadata(m14020c = "com.microsoft.identity.common.internal.activebrokerdiscovery.BrokerDiscoveryClient$Companion$queryFromBroker$2$deferredResults$1$1", m14021f = "BrokerDiscoveryClient.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
public final class C6238x385be92c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super BrokerData>, Object> {
    final /* synthetic */ BrokerData $candidate;
    final /* synthetic */ IIpcStrategy $ipcStrategy;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C6238x385be92c(BrokerData brokerData, IIpcStrategy iIpcStrategy, Continuation<? super C6238x385be92c> continuation) {
        super(2, continuation);
        this.$candidate = brokerData;
        this.$ipcStrategy = iIpcStrategy;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new C6238x385be92c(this.$candidate, this.$ipcStrategy, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return BrokerDiscoveryClient.INSTANCE.makeRequest(this.$candidate, this.$ipcStrategy);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super BrokerData> continuation) {
        return ((C6238x385be92c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
