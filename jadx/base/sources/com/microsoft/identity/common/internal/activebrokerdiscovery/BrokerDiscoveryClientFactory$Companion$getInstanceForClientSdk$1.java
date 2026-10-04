package com.microsoft.identity.common.internal.activebrokerdiscovery;

import android.content.Context;
import com.microsoft.identity.common.internal.activebrokerdiscovery.BrokerDiscoveryClientFactory;
import com.microsoft.identity.common.internal.cache.ClientActiveBrokerCache;
import com.microsoft.identity.common.java.interfaces.IPlatformComponents;
import com.microsoft.identity.common.java.interfaces.IStorageSupplier;
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
import kotlinx.coroutines.sync.Mutex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
@DebugMetadata(m14020c = "com.microsoft.identity.common.internal.activebrokerdiscovery.BrokerDiscoveryClientFactory$Companion$getInstanceForClientSdk$1", m14021f = "BrokerDiscoveryClientFactory.kt", m14022i = {0}, m14023l = {146}, m14024m = "invokeSuspend", m14025n = {"$this$withLock_u24default$iv"}, m14026s = {"L$0"})
public final class BrokerDiscoveryClientFactory$Companion$getInstanceForClientSdk$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ IPlatformComponents $platformComponents;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BrokerDiscoveryClientFactory$Companion$getInstanceForClientSdk$1(Context context, IPlatformComponents iPlatformComponents, Continuation<? super BrokerDiscoveryClientFactory$Companion$getInstanceForClientSdk$1> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$platformComponents = iPlatformComponents;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new BrokerDiscoveryClientFactory$Companion$getInstanceForClientSdk$1(this.$context, this.$platformComponents, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Context context;
        Mutex mutex;
        IPlatformComponents iPlatformComponents;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Mutex mutex2 = BrokerDiscoveryClientFactory.lock;
            context = this.$context;
            IPlatformComponents iPlatformComponents2 = this.$platformComponents;
            this.L$0 = mutex2;
            this.L$1 = context;
            this.L$2 = iPlatformComponents2;
            this.label = 1;
            if (mutex2.lock(null, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutex = mutex2;
            iPlatformComponents = iPlatformComponents2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            iPlatformComponents = (IPlatformComponents) this.L$2;
            context = (Context) this.L$1;
            mutex = (Mutex) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        try {
            if (BrokerDiscoveryClientFactory.clientSdkInstance == null) {
                BrokerDiscoveryClientFactory.Companion companion = BrokerDiscoveryClientFactory.INSTANCE;
                ClientActiveBrokerCache.Companion companion2 = ClientActiveBrokerCache.INSTANCE;
                IStorageSupplier storageSupplier = iPlatformComponents.getStorageSupplier();
                Intrinsics.checkNotNullExpressionValue(storageSupplier, "platformComponents.storageSupplier");
                BrokerDiscoveryClientFactory.clientSdkInstance = companion.getInstance(context, iPlatformComponents, companion2.getClientSdkCache(storageSupplier));
            }
            Unit unit = Unit.INSTANCE;
            mutex.unlock(null);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            mutex.unlock(null);
            throw th;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((BrokerDiscoveryClientFactory$Companion$getInstanceForClientSdk$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
