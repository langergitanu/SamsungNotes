package com.microsoft.identity.common.internal.activebrokerdiscovery;

import com.microsoft.identity.common.internal.broker.BrokerData;
import com.microsoft.identity.common.internal.broker.ipc.IIpcStrategy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "Lcom/microsoft/identity/common/internal/broker/BrokerData;", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
@DebugMetadata(m14020c = "com.microsoft.identity.common.internal.activebrokerdiscovery.BrokerDiscoveryClient$Companion$queryFromBroker$2", m14021f = "BrokerDiscoveryClient.kt", m14022i = {}, m14023l = {108}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
public final class BrokerDiscoveryClient$Companion$queryFromBroker$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super BrokerData>, Object> {
    final /* synthetic */ Set<BrokerData> $brokerCandidates;
    final /* synthetic */ IIpcStrategy $ipcStrategy;
    final /* synthetic */ Function1<BrokerData, Boolean> $isPackageInstalled;
    final /* synthetic */ Function1<BrokerData, Boolean> $isValidBroker;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BrokerDiscoveryClient$Companion$queryFromBroker$2(Set<BrokerData> set, Function1<? super BrokerData, Boolean> function1, Function1<? super BrokerData, Boolean> function12, IIpcStrategy iIpcStrategy, Continuation<? super BrokerDiscoveryClient$Companion$queryFromBroker$2> continuation) {
        super(2, continuation);
        this.$brokerCandidates = set;
        this.$isPackageInstalled = function1;
        this.$isValidBroker = function12;
        this.$ipcStrategy = iIpcStrategy;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        BrokerDiscoveryClient$Companion$queryFromBroker$2 brokerDiscoveryClient$Companion$queryFromBroker$2 = new BrokerDiscoveryClient$Companion$queryFromBroker$2(this.$brokerCandidates, this.$isPackageInstalled, this.$isValidBroker, this.$ipcStrategy, continuation);
        brokerDiscoveryClient$Companion$queryFromBroker$2.L$0 = obj;
        return brokerDiscoveryClient$Companion$queryFromBroker$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Set<BrokerData> set = this.$brokerCandidates;
            Function1<BrokerData, Boolean> function1 = this.$isPackageInstalled;
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : set) {
                if (function1.invoke((BrokerData) obj2).booleanValue()) {
                    arrayList.add(obj2);
                }
            }
            Function1<BrokerData, Boolean> function12 = this.$isValidBroker;
            ArrayList arrayList2 = new ArrayList();
            for (Object obj3 : arrayList) {
                if (function12.invoke((BrokerData) obj3).booleanValue()) {
                    arrayList2.add(obj3);
                }
            }
            IIpcStrategy iIpcStrategy = this.$ipcStrategy;
            ArrayList arrayList3 = new ArrayList(CollectionsKt.m13952k(arrayList2));
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList3.add(BuildersKt__Builders_commonKt.async$default(coroutineScope, BrokerDiscoveryClient.INSTANCE.getDispatcher(), null, new C6238x385be92c((BrokerData) it.next(), iIpcStrategy, null), 2, null));
            }
            this.label = 1;
            obj = AwaitKt.awaitAll(arrayList3, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return CollectionsKt.firstOrNull(CollectionsKt.filterNotNull((Iterable) obj));
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super BrokerData> continuation) {
        return ((BrokerDiscoveryClient$Companion$queryFromBroker$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
