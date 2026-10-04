package com.microsoft.identity.common.internal.cache;

import com.microsoft.identity.common.internal.broker.BrokerData;
import com.microsoft.identity.common.java.interfaces.INameValueStorage;
import com.sec.android.diagmonagent.log.provider.utils.BundleContract;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex;
import net.jcip.annotations.ThreadSafe;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0017\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000bH\u0014J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m13886d2 = {"Lcom/microsoft/identity/common/internal/cache/BaseActiveBrokerCache;", "Lcom/microsoft/identity/common/internal/cache/IActiveBrokerCache;", BundleContract.STORAGE, "Lcom/microsoft/identity/common/java/interfaces/INameValueStorage;", "", "lock", "Lkotlinx/coroutines/sync/Mutex;", "(Lcom/microsoft/identity/common/java/interfaces/INameValueStorage;Lkotlinx/coroutines/sync/Mutex;)V", "clearCachedActiveBroker", "", "getCachedActiveBroker", "Lcom/microsoft/identity/common/internal/broker/BrokerData;", "setCachedActiveBroker", "brokerData", "setCachedActiveBrokerWithoutLock", "setShouldUseAccountManagerForTheNextMilliseconds", "timeInMillis", "", "shouldUseAccountManager", "", "Companion", "common_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
@ThreadSafe
public class BaseActiveBrokerCache implements IActiveBrokerCache {

    @NotNull
    public static final String ACTIVE_BROKER_CACHE_PACKAGE_NAME_KEY = "ACTIVE_BROKER_CACHE_PACKAGE_NAME_KEY";

    @NotNull
    public static final String ACTIVE_BROKER_CACHE_SIGHASH_KEY = "ACTIVE_BROKER_CACHE_SIGHASH_KEY";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String SHOULD_USE_ACCOUNT_MANAGER_UNTIL_EPOCH_MILLISECONDS_KEY = "SHOULD_USE_ACCOUNT_MANAGER_UNTIL_EPOCH_MILLISECONDS_KEY";

    @NotNull
    private final Mutex lock;

    @NotNull
    private final INameValueStorage<String> storage;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, m13886d2 = {"Lcom/microsoft/identity/common/internal/cache/BaseActiveBrokerCache$Companion;", "", "()V", BaseActiveBrokerCache.ACTIVE_BROKER_CACHE_PACKAGE_NAME_KEY, "", BaseActiveBrokerCache.ACTIVE_BROKER_CACHE_SIGHASH_KEY, BaseActiveBrokerCache.SHOULD_USE_ACCOUNT_MANAGER_UNTIL_EPOCH_MILLISECONDS_KEY, "isNotExpired", "", "expiryDate", "", "(Ljava/lang/Long;)Z", "common_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean isNotExpired(@Nullable Long expiryDate) {
            return expiryDate != null && System.currentTimeMillis() < expiryDate.longValue();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.microsoft.identity.common.internal.cache.BaseActiveBrokerCache$clearCachedActiveBroker$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.microsoft.identity.common.internal.cache.BaseActiveBrokerCache$clearCachedActiveBroker$1", m14021f = "BaseActiveBrokerCache.kt", m14022i = {0}, m14023l = {134}, m14024m = "invokeSuspend", m14025n = {"$this$withLock_u24default$iv"}, m14026s = {"L$0"})
    public static final class C62511 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        int label;

        public C62511(Continuation<? super C62511> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return BaseActiveBrokerCache.this.new C62511(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Mutex mutex;
            BaseActiveBrokerCache baseActiveBrokerCache;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                mutex = BaseActiveBrokerCache.this.lock;
                BaseActiveBrokerCache baseActiveBrokerCache2 = BaseActiveBrokerCache.this;
                this.L$0 = mutex;
                this.L$1 = baseActiveBrokerCache2;
                this.label = 1;
                if (mutex.lock(null, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                baseActiveBrokerCache = baseActiveBrokerCache2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                baseActiveBrokerCache = (BaseActiveBrokerCache) this.L$1;
                mutex = (Mutex) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            try {
                baseActiveBrokerCache.storage.remove(BaseActiveBrokerCache.ACTIVE_BROKER_CACHE_PACKAGE_NAME_KEY);
                baseActiveBrokerCache.storage.remove(BaseActiveBrokerCache.ACTIVE_BROKER_CACHE_SIGHASH_KEY);
                baseActiveBrokerCache.storage.remove(BaseActiveBrokerCache.SHOULD_USE_ACCOUNT_MANAGER_UNTIL_EPOCH_MILLISECONDS_KEY);
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
            return ((C62511) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.microsoft.identity.common.internal.cache.BaseActiveBrokerCache$getCachedActiveBroker$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "Lcom/microsoft/identity/common/internal/broker/BrokerData;", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.microsoft.identity.common.internal.cache.BaseActiveBrokerCache$getCachedActiveBroker$1", m14021f = "BaseActiveBrokerCache.kt", m14022i = {0}, m14023l = {134}, m14024m = "invokeSuspend", m14025n = {"$this$withLock_u24default$iv"}, m14026s = {"L$0"})
    public static final class C62521 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super BrokerData>, Object> {
        Object L$0;
        Object L$1;
        int label;

        public C62521(Continuation<? super C62521> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return BaseActiveBrokerCache.this.new C62521(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Mutex mutex;
            BaseActiveBrokerCache baseActiveBrokerCache;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                mutex = BaseActiveBrokerCache.this.lock;
                BaseActiveBrokerCache baseActiveBrokerCache2 = BaseActiveBrokerCache.this;
                this.L$0 = mutex;
                this.L$1 = baseActiveBrokerCache2;
                this.label = 1;
                if (mutex.lock(null, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                baseActiveBrokerCache = baseActiveBrokerCache2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                baseActiveBrokerCache = (BaseActiveBrokerCache) this.L$1;
                mutex = (Mutex) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            try {
                String str = (String) baseActiveBrokerCache.storage.get(BaseActiveBrokerCache.ACTIVE_BROKER_CACHE_PACKAGE_NAME_KEY);
                String str2 = (String) baseActiveBrokerCache.storage.get(BaseActiveBrokerCache.ACTIVE_BROKER_CACHE_SIGHASH_KEY);
                if (str != null && str.length() != 0 && str2 != null && str2.length() != 0) {
                    return new BrokerData(str, str2);
                }
                return null;
            } finally {
                mutex.unlock(null);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super BrokerData> continuation) {
            return ((C62521) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.microsoft.identity.common.internal.cache.BaseActiveBrokerCache$setCachedActiveBroker$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.microsoft.identity.common.internal.cache.BaseActiveBrokerCache$setCachedActiveBroker$1", m14021f = "BaseActiveBrokerCache.kt", m14022i = {0}, m14023l = {134}, m14024m = "invokeSuspend", m14025n = {"$this$withLock_u24default$iv"}, m14026s = {"L$0"})
    public static final class C62531 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ BrokerData $brokerData;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C62531(BrokerData brokerData, Continuation<? super C62531> continuation) {
            super(2, continuation);
            this.$brokerData = brokerData;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return BaseActiveBrokerCache.this.new C62531(this.$brokerData, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            BaseActiveBrokerCache baseActiveBrokerCache;
            Mutex mutex;
            BrokerData brokerData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Mutex mutex2 = BaseActiveBrokerCache.this.lock;
                baseActiveBrokerCache = BaseActiveBrokerCache.this;
                BrokerData brokerData2 = this.$brokerData;
                this.L$0 = mutex2;
                this.L$1 = baseActiveBrokerCache;
                this.L$2 = brokerData2;
                this.label = 1;
                if (mutex2.lock(null, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutex = mutex2;
                brokerData = brokerData2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                brokerData = (BrokerData) this.L$2;
                baseActiveBrokerCache = (BaseActiveBrokerCache) this.L$1;
                mutex = (Mutex) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            try {
                baseActiveBrokerCache.setCachedActiveBrokerWithoutLock(brokerData);
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
            return ((C62531) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.microsoft.identity.common.internal.cache.BaseActiveBrokerCache$setShouldUseAccountManagerForTheNextMilliseconds$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.microsoft.identity.common.internal.cache.BaseActiveBrokerCache$setShouldUseAccountManagerForTheNextMilliseconds$1", m14021f = "BaseActiveBrokerCache.kt", m14022i = {0}, m14023l = {134}, m14024m = "invokeSuspend", m14025n = {"$this$withLock_u24default$iv"}, m14026s = {"L$0"})
    public static final class C62541 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $timeInMillis;
        long J$0;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C62541(long j, Continuation<? super C62541> continuation) {
            super(2, continuation);
            this.$timeInMillis = j;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return BaseActiveBrokerCache.this.new C62541(this.$timeInMillis, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Mutex mutex;
            BaseActiveBrokerCache baseActiveBrokerCache;
            long j;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                mutex = BaseActiveBrokerCache.this.lock;
                long j2 = this.$timeInMillis;
                BaseActiveBrokerCache baseActiveBrokerCache2 = BaseActiveBrokerCache.this;
                this.L$0 = mutex;
                this.L$1 = baseActiveBrokerCache2;
                this.J$0 = j2;
                this.label = 1;
                if (mutex.lock(null, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                baseActiveBrokerCache = baseActiveBrokerCache2;
                j = j2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j = this.J$0;
                baseActiveBrokerCache = (BaseActiveBrokerCache) this.L$1;
                mutex = (Mutex) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            try {
                baseActiveBrokerCache.storage.put(BaseActiveBrokerCache.SHOULD_USE_ACCOUNT_MANAGER_UNTIL_EPOCH_MILLISECONDS_KEY, String.valueOf(System.currentTimeMillis() + j));
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
            return ((C62541) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.microsoft.identity.common.internal.cache.BaseActiveBrokerCache$shouldUseAccountManager$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.microsoft.identity.common.internal.cache.BaseActiveBrokerCache$shouldUseAccountManager$1", m14021f = "BaseActiveBrokerCache.kt", m14022i = {0}, m14023l = {134}, m14024m = "invokeSuspend", m14025n = {"$this$withLock_u24default$iv"}, m14026s = {"L$0"})
    public static final class C62551 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        Object L$0;
        Object L$1;
        int label;

        public C62551(Continuation<? super C62551> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return BaseActiveBrokerCache.this.new C62551(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Mutex mutex;
            BaseActiveBrokerCache baseActiveBrokerCache;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                mutex = BaseActiveBrokerCache.this.lock;
                BaseActiveBrokerCache baseActiveBrokerCache2 = BaseActiveBrokerCache.this;
                this.L$0 = mutex;
                this.L$1 = baseActiveBrokerCache2;
                this.label = 1;
                if (mutex.lock(null, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                baseActiveBrokerCache = baseActiveBrokerCache2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                baseActiveBrokerCache = (BaseActiveBrokerCache) this.L$1;
                mutex = (Mutex) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            try {
                String rawValue = (String) baseActiveBrokerCache.storage.get(BaseActiveBrokerCache.SHOULD_USE_ACCOUNT_MANAGER_UNTIL_EPOCH_MILLISECONDS_KEY);
                if (rawValue != null) {
                    Intrinsics.checkNotNullExpressionValue(rawValue, "rawValue");
                    Long longOrNull = StringsKt.toLongOrNull(rawValue);
                    if (longOrNull != null) {
                        return Boxing.boxBoolean(BaseActiveBrokerCache.INSTANCE.isNotExpired(Boxing.boxLong(longOrNull.longValue())));
                    }
                }
                return Boxing.boxBoolean(false);
            } finally {
                mutex.unlock(null);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Boolean> continuation) {
            return ((C62551) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public BaseActiveBrokerCache(@NotNull INameValueStorage<String> storage, @NotNull Mutex lock) {
        Intrinsics.checkNotNullParameter(storage, "storage");
        Intrinsics.checkNotNullParameter(lock, "lock");
        this.storage = storage;
        this.lock = lock;
    }

    @Override // com.microsoft.identity.common.internal.cache.IActiveBrokerCache
    public void clearCachedActiveBroker() {
        BuildersKt__BuildersKt.runBlocking$default(null, new C62511(null), 1, null);
    }

    @Override // com.microsoft.identity.common.internal.cache.IActiveBrokerCache
    @Nullable
    public BrokerData getCachedActiveBroker() {
        return (BrokerData) BuildersKt__BuildersKt.runBlocking$default(null, new C62521(null), 1, null);
    }

    @Override // com.microsoft.identity.common.internal.cache.IActiveBrokerCache
    public void setCachedActiveBroker(@NotNull BrokerData brokerData) {
        Intrinsics.checkNotNullParameter(brokerData, "brokerData");
        BuildersKt__BuildersKt.runBlocking$default(null, new C62531(brokerData, null), 1, null);
    }

    public void setCachedActiveBrokerWithoutLock(@NotNull BrokerData brokerData) {
        Intrinsics.checkNotNullParameter(brokerData, "brokerData");
        this.storage.put(ACTIVE_BROKER_CACHE_PACKAGE_NAME_KEY, brokerData.getPackageName());
        this.storage.put(ACTIVE_BROKER_CACHE_SIGHASH_KEY, brokerData.getSigningCertificateThumbprint());
        this.storage.remove(SHOULD_USE_ACCOUNT_MANAGER_UNTIL_EPOCH_MILLISECONDS_KEY);
    }

    @Override // com.microsoft.identity.common.internal.cache.IActiveBrokerCache
    public void setShouldUseAccountManagerForTheNextMilliseconds(long timeInMillis) {
        BuildersKt__BuildersKt.runBlocking$default(null, new C62541(timeInMillis, null), 1, null);
    }

    @Override // com.microsoft.identity.common.internal.cache.IActiveBrokerCache
    public boolean shouldUseAccountManager() {
        return ((Boolean) BuildersKt__BuildersKt.runBlocking$default(null, new C62551(null), 1, null)).booleanValue();
    }
}
