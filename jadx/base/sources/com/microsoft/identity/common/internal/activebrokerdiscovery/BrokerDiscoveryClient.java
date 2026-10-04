package com.microsoft.identity.common.internal.activebrokerdiscovery;

import android.content.Context;
import android.os.Bundle;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.exception.BrokerCommunicationException;
import com.microsoft.identity.common.internal.broker.BrokerData;
import com.microsoft.identity.common.internal.broker.BrokerValidator;
import com.microsoft.identity.common.internal.broker.PackageHelper;
import com.microsoft.identity.common.internal.broker.ipc.BrokerOperationBundle;
import com.microsoft.identity.common.internal.broker.ipc.ContentProviderStrategy;
import com.microsoft.identity.common.internal.broker.ipc.IIpcStrategy;
import com.microsoft.identity.common.internal.cache.IClientActiveBrokerCache;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.interfaces.IPlatformComponents;
import com.microsoft.identity.common.java.logging.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.sun.imageio.plugins.jpeg.JPEG;
import java.io.Serializable;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB[\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\u0010\u0014J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0016\u001a\u00020\u0012H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0018R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, m13886d2 = {"Lcom/microsoft/identity/common/internal/activebrokerdiscovery/BrokerDiscoveryClient;", "Lcom/microsoft/identity/common/internal/activebrokerdiscovery/IBrokerDiscoveryClient;", "context", "Landroid/content/Context;", "components", "Lcom/microsoft/identity/common/java/interfaces/IPlatformComponents;", "cache", "Lcom/microsoft/identity/common/internal/cache/IClientActiveBrokerCache;", "(Landroid/content/Context;Lcom/microsoft/identity/common/java/interfaces/IPlatformComponents;Lcom/microsoft/identity/common/internal/cache/IClientActiveBrokerCache;)V", "brokerCandidates", "", "Lcom/microsoft/identity/common/internal/broker/BrokerData;", "getActiveBrokerFromAccountManager", "Lkotlin/Function0;", "ipcStrategy", "Lcom/microsoft/identity/common/internal/broker/ipc/IIpcStrategy;", "isPackageInstalled", "Lkotlin/Function1;", "", "isValidBroker", "(Ljava/util/Set;Lkotlin/jvm/functions/Function0;Lcom/microsoft/identity/common/internal/broker/ipc/IIpcStrategy;Lcom/microsoft/identity/common/internal/cache/IClientActiveBrokerCache;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getActiveBroker", "shouldSkipCache", "getActiveBrokerAsync", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "common_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class BrokerDiscoveryClient implements IBrokerDiscoveryClient {

    @NotNull
    public static final String ACTIVE_BROKER_PACKAGE_NAME_BUNDLE_KEY = "ACTIVE_BROKER_PACKAGE_NAME_BUNDLE_KEY";

    @NotNull
    public static final String ACTIVE_BROKER_SIGNING_CERTIFICATE_THUMBPRINT_BUNDLE_KEY = "ACTIVE_BROKER_SIGNING_CERTIFICATE_THUMBPRINT_BUNDLE_KEY";

    @NotNull
    public static final String ERROR_BUNDLE_KEY = "ERROR_BUNDLE_KEY";

    @NotNull
    private final Set<BrokerData> brokerCandidates;

    @NotNull
    private final IClientActiveBrokerCache cache;

    @NotNull
    private final Function0<BrokerData> getActiveBrokerFromAccountManager;

    @NotNull
    private final IIpcStrategy ipcStrategy;

    @NotNull
    private final Function1<BrokerData, Boolean> isPackageInstalled;

    @NotNull
    private final Function1<BrokerData, Boolean> isValidBroker;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private static final String TAG = Reflection.getOrCreateKotlinClass(BrokerDiscoveryClient.class).getSimpleName();

    @NotNull
    private static final CoroutineDispatcher dispatcher = Dispatchers.getIO().limitedParallelism(10);

    @NotNull
    private static final Mutex classLevelLock = MutexKt.Mutex$default(false, 1, null);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018H\u0002JS\u0010\u0019\u001a\u0004\u0018\u00010\u00122\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00120\u001b2\u0006\u0010\u0017\u001a\u00020\u00182\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u001e0\u001d2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u001e0\u001dH\u0080@ø\u0001\u0000¢\u0006\u0004\b \u0010!R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\u00020\r¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u0002\u001a\u0004\b\u000f\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, m13886d2 = {"Lcom/microsoft/identity/common/internal/activebrokerdiscovery/BrokerDiscoveryClient$Companion;", "", "()V", BrokerDiscoveryClient.ACTIVE_BROKER_PACKAGE_NAME_BUNDLE_KEY, "", BrokerDiscoveryClient.ACTIVE_BROKER_SIGNING_CERTIFICATE_THUMBPRINT_BUNDLE_KEY, BrokerDiscoveryClient.ERROR_BUNDLE_KEY, SearchConstants.TargetContents.TAG, "getTAG", "()Ljava/lang/String;", "classLevelLock", "Lkotlinx/coroutines/sync/Mutex;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "getDispatcher$annotations", "getDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "extractResult", "Lcom/microsoft/identity/common/internal/broker/BrokerData;", "bundle", "Landroid/os/Bundle;", "makeRequest", "candidate", "ipcStrategy", "Lcom/microsoft/identity/common/internal/broker/ipc/IIpcStrategy;", "queryFromBroker", "brokerCandidates", "", "isPackageInstalled", "Lkotlin/Function1;", "", "isValidBroker", "queryFromBroker$common_distRelease", "(Ljava/util/Set;Lcom/microsoft/identity/common/internal/broker/ipc/IIpcStrategy;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "common_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final BrokerData extractResult(Bundle bundle) throws Throwable {
            if (bundle == null) {
                return null;
            }
            Serializable serializable = bundle.getSerializable(BrokerDiscoveryClient.ERROR_BUNDLE_KEY);
            if (serializable != null) {
                throw ((Throwable) serializable);
            }
            String string = bundle.getString(BrokerDiscoveryClient.ACTIVE_BROKER_PACKAGE_NAME_BUNDLE_KEY);
            if (string == null) {
                throw new NoSuchElementException("ACTIVE_BROKER_PACKAGE_NAME_BUNDLE_KEY must not be null");
            }
            String string2 = bundle.getString(BrokerDiscoveryClient.ACTIVE_BROKER_SIGNING_CERTIFICATE_THUMBPRINT_BUNDLE_KEY);
            if (string2 != null) {
                return new BrokerData(string, string2);
            }
            throw new NoSuchElementException("ACTIVE_BROKER_SIGNING_CERTIFICATE_THUMBPRINT_BUNDLE_KEY must not be null");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final BrokerData makeRequest(BrokerData candidate, IIpcStrategy ipcStrategy) {
            String str = getTAG() + ":makeRequest";
            try {
                return extractResult(ipcStrategy.communicateToBroker(new BrokerOperationBundle(BrokerOperationBundle.Operation.BROKER_DISCOVERY_FROM_SDK, candidate.getPackageName(), new Bundle())));
            } catch (Throwable th) {
                if ((th instanceof BrokerCommunicationException) && BrokerCommunicationException.Category.OPERATION_NOT_SUPPORTED_ON_SERVER_SIDE == ((BrokerCommunicationException) th).getCategory()) {
                    Logger.info(str, "Tried broker discovery on " + candidate + ". It doesn't support the IPC mechanism.");
                    return null;
                }
                if ((th instanceof ClientException) && Intrinsics.areEqual(ClientException.ONLY_SUPPORTS_ACCOUNT_MANAGER_ERROR_CODE, ((ClientException) th).getErrorCode())) {
                    Logger.info(str, "Tried broker discovery on " + candidate + ". The Broker side indicates that only AccountManager is supported.");
                    return null;
                }
                Logger.error(str, "Tried broker discovery on " + candidate + ", get an error", th);
                return null;
            }
        }

        @NotNull
        public final CoroutineDispatcher getDispatcher() {
            return BrokerDiscoveryClient.dispatcher;
        }

        @Nullable
        public final String getTAG() {
            return BrokerDiscoveryClient.TAG;
        }

        @Nullable
        public final Object queryFromBroker$common_distRelease(@NotNull Set<BrokerData> set, @NotNull IIpcStrategy iIpcStrategy, @NotNull Function1<? super BrokerData, Boolean> function1, @NotNull Function1<? super BrokerData, Boolean> function12, @NotNull Continuation<? super BrokerData> continuation) {
            return CoroutineScopeKt.coroutineScope(new BrokerDiscoveryClient$Companion$queryFromBroker$2(set, function1, function12, iIpcStrategy, null), continuation);
        }

        private Companion() {
        }

        public static /* synthetic */ void getDispatcher$annotations() {
        }
    }

    /* JADX INFO: renamed from: com.microsoft.identity.common.internal.activebrokerdiscovery.BrokerDiscoveryClient$getActiveBroker$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "Lcom/microsoft/identity/common/internal/broker/BrokerData;", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.microsoft.identity.common.internal.activebrokerdiscovery.BrokerDiscoveryClient$getActiveBroker$1", m14021f = "BrokerDiscoveryClient.kt", m14022i = {}, m14023l = {184}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C62391 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super BrokerData>, Object> {
        final /* synthetic */ boolean $shouldSkipCache;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C62391(boolean z, Continuation<? super C62391> continuation) {
            super(2, continuation);
            this.$shouldSkipCache = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return BrokerDiscoveryClient.this.new C62391(this.$shouldSkipCache, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
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
            BrokerDiscoveryClient brokerDiscoveryClient = BrokerDiscoveryClient.this;
            boolean z = this.$shouldSkipCache;
            this.label = 1;
            Object activeBrokerAsync = brokerDiscoveryClient.getActiveBrokerAsync(z, this);
            return activeBrokerAsync == coroutine_suspended ? coroutine_suspended : activeBrokerAsync;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super BrokerData> continuation) {
            return ((C62391) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.microsoft.identity.common.internal.activebrokerdiscovery.BrokerDiscoveryClient$getActiveBrokerAsync$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.microsoft.identity.common.internal.activebrokerdiscovery.BrokerDiscoveryClient", m14021f = "BrokerDiscoveryClient.kt", m14022i = {0, 0, 0, 0, 1, 1, 1}, m14023l = {267, JPEG.APP4}, m14024m = "getActiveBrokerAsync", m14025n = {"this", "methodTag", "$this$withLock_u24default$iv", "shouldSkipCache", "this", "methodTag", "$this$withLock_u24default$iv"}, m14026s = {"L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2"})
    public static final class C62401 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C62401(Continuation<? super C62401> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BrokerDiscoveryClient.this.getActiveBrokerAsync(false, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BrokerDiscoveryClient(@NotNull Set<BrokerData> brokerCandidates, @NotNull Function0<BrokerData> getActiveBrokerFromAccountManager, @NotNull IIpcStrategy ipcStrategy, @NotNull IClientActiveBrokerCache cache, @NotNull Function1<? super BrokerData, Boolean> isPackageInstalled, @NotNull Function1<? super BrokerData, Boolean> isValidBroker) {
        Intrinsics.checkNotNullParameter(brokerCandidates, "brokerCandidates");
        Intrinsics.checkNotNullParameter(getActiveBrokerFromAccountManager, "getActiveBrokerFromAccountManager");
        Intrinsics.checkNotNullParameter(ipcStrategy, "ipcStrategy");
        Intrinsics.checkNotNullParameter(cache, "cache");
        Intrinsics.checkNotNullParameter(isPackageInstalled, "isPackageInstalled");
        Intrinsics.checkNotNullParameter(isValidBroker, "isValidBroker");
        this.brokerCandidates = brokerCandidates;
        this.getActiveBrokerFromAccountManager = getActiveBrokerFromAccountManager;
        this.ipcStrategy = ipcStrategy;
        this.cache = cache;
        this.isPackageInstalled = isPackageInstalled;
        this.isValidBroker = isValidBroker;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0137 A[Catch: all -> 0x0044, TRY_LEAVE, TryCatch #0 {all -> 0x0044, blocks: (B:14:0x003f, B:52:0x0133, B:54:0x0137, B:57:0x0140, B:59:0x0166, B:61:0x016c), top: B:66:0x003f }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0140 A[Catch: all -> 0x0044, TRY_ENTER, TryCatch #0 {all -> 0x0044, blocks: (B:14:0x003f, B:52:0x0133, B:54:0x0137, B:57:0x0140, B:59:0x0166, B:61:0x016c), top: B:66:0x003f }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getActiveBrokerAsync(boolean z, Continuation<? super BrokerData> continuation) throws Throwable {
        C62401 c62401;
        String strM1170p;
        Mutex mutex;
        BrokerDiscoveryClient brokerDiscoveryClient;
        Mutex mutex2;
        String str;
        BrokerDiscoveryClient brokerDiscoveryClient2;
        BrokerData brokerData;
        if (continuation instanceof C62401) {
            c62401 = (C62401) continuation;
            int i = c62401.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c62401.label = i - Integer.MIN_VALUE;
            } else {
                c62401 = new C62401(continuation);
            }
        }
        C62401 c624012 = c62401;
        Object obj = c624012.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c624012.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            strM1170p = AbstractC0622a.m1170p(TAG, ":getActiveBrokerAsync", new StringBuilder());
            mutex = classLevelLock;
            c624012.L$0 = this;
            c624012.L$1 = strM1170p;
            c624012.L$2 = mutex;
            c624012.Z$0 = z;
            c624012.label = 1;
            if (mutex.lock(null, c624012) != coroutine_suspended) {
                brokerDiscoveryClient = this;
            }
            return coroutine_suspended;
        }
        if (i2 != 1) {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            mutex2 = (Mutex) c624012.L$2;
            str = (String) c624012.L$1;
            brokerDiscoveryClient2 = (BrokerDiscoveryClient) c624012.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                brokerData = (BrokerData) obj;
                if (brokerData == null) {
                    brokerDiscoveryClient2.cache.setCachedActiveBroker(brokerData);
                    mutex2.unlock(null);
                    return brokerData;
                }
                Logger.info(str, "Will skip broker discovery via IPC and fall back to AccountManager for the next 60 minutes.");
                brokerDiscoveryClient2.cache.clearCachedActiveBroker();
                brokerDiscoveryClient2.cache.setShouldUseAccountManagerForTheNextMilliseconds(TimeUnit.MINUTES.toMillis(60L));
                BrokerData brokerDataInvoke = brokerDiscoveryClient2.getActiveBrokerFromAccountManager.invoke();
                StringBuilder sb = new StringBuilder("Tried getting active broker from account manager, get ");
                sb.append(brokerDataInvoke != null ? brokerDataInvoke.getPackageName() : null);
                sb.append('.');
                Logger.info(str, sb.toString());
                mutex2.unlock(null);
                return brokerDataInvoke;
            } catch (Throwable th) {
                th = th;
                mutex2.unlock(null);
                throw th;
            }
        }
        z = c624012.Z$0;
        mutex = (Mutex) c624012.L$2;
        String str2 = (String) c624012.L$1;
        BrokerDiscoveryClient brokerDiscoveryClient3 = (BrokerDiscoveryClient) c624012.L$0;
        ResultKt.throwOnFailure(obj);
        strM1170p = str2;
        brokerDiscoveryClient = brokerDiscoveryClient3;
        Mutex mutex3 = mutex;
        if (!z) {
            try {
                if (brokerDiscoveryClient.cache.shouldUseAccountManager()) {
                    BrokerData brokerDataInvoke2 = brokerDiscoveryClient.getActiveBrokerFromAccountManager.invoke();
                    mutex3.unlock(null);
                    return brokerDataInvoke2;
                }
                BrokerData cachedActiveBroker = brokerDiscoveryClient.cache.getCachedActiveBroker();
                if (cachedActiveBroker != null) {
                    if (!brokerDiscoveryClient.isPackageInstalled.invoke(cachedActiveBroker).booleanValue()) {
                        Logger.info(strM1170p, "There is a cached broker: " + cachedActiveBroker + ", but the app is no longer installed.");
                        brokerDiscoveryClient.cache.clearCachedActiveBroker();
                    } else if (!brokerDiscoveryClient.isValidBroker.invoke(cachedActiveBroker).booleanValue()) {
                        Logger.info(strM1170p, "Clearing cache as the installed app does not have a matching signature hash.");
                        brokerDiscoveryClient.cache.clearCachedActiveBroker();
                    } else {
                        if (brokerDiscoveryClient.ipcStrategy.isSupportedByTargetedBroker(cachedActiveBroker.getPackageName())) {
                            Logger.info(strM1170p, "Returning cached broker: " + cachedActiveBroker);
                            mutex3.unlock(null);
                            return cachedActiveBroker;
                        }
                        Logger.info(strM1170p, "Clearing cache as the installed app does not provide any IPC mechanism to communicate to. (e.g. the broker code isn't shipped with this apk)");
                        brokerDiscoveryClient.cache.clearCachedActiveBroker();
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                mutex2 = mutex3;
                mutex2.unlock(null);
                throw th;
            }
        }
        Companion companion = INSTANCE;
        Set<BrokerData> set = brokerDiscoveryClient.brokerCandidates;
        IIpcStrategy iIpcStrategy = brokerDiscoveryClient.ipcStrategy;
        Function1<BrokerData, Boolean> function1 = brokerDiscoveryClient.isPackageInstalled;
        Function1<BrokerData, Boolean> function12 = brokerDiscoveryClient.isValidBroker;
        c624012.L$0 = brokerDiscoveryClient;
        c624012.L$1 = strM1170p;
        c624012.L$2 = mutex3;
        c624012.label = 2;
        Object objQueryFromBroker$common_distRelease = companion.queryFromBroker$common_distRelease(set, iIpcStrategy, function1, function12, c624012);
        if (objQueryFromBroker$common_distRelease != coroutine_suspended) {
            str = strM1170p;
            brokerDiscoveryClient2 = brokerDiscoveryClient;
            obj = objQueryFromBroker$common_distRelease;
            mutex2 = mutex3;
            brokerData = (BrokerData) obj;
            if (brokerData == null) {
            }
        }
        return coroutine_suspended;
    }

    @Override // com.microsoft.identity.common.internal.activebrokerdiscovery.IBrokerDiscoveryClient
    @Nullable
    public BrokerData getActiveBroker(boolean shouldSkipCache) {
        return (BrokerData) BuildersKt__BuildersKt.runBlocking$default(null, new C62391(shouldSkipCache, null), 1, null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BrokerDiscoveryClient(@NotNull final Context context, @NotNull IPlatformComponents components, @NotNull IClientActiveBrokerCache cache) {
        this(BrokerData.INSTANCE.getKnownBrokerApps(), new Function0<BrokerData>() { // from class: com.microsoft.identity.common.internal.activebrokerdiscovery.BrokerDiscoveryClient.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final BrokerData invoke() {
                return new AccountManagerBrokerDiscoveryUtil(context).getActiveBrokerFromAccountManager();
            }
        }, new ContentProviderStrategy(context, components), cache, new Function1<BrokerData, Boolean>() { // from class: com.microsoft.identity.common.internal.activebrokerdiscovery.BrokerDiscoveryClient.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull BrokerData brokerData) {
                Intrinsics.checkNotNullParameter(brokerData, "brokerData");
                return Boolean.valueOf(new PackageHelper(context).isPackageInstalledAndEnabled(brokerData.getPackageName()));
            }
        }, new Function1<BrokerData, Boolean>() { // from class: com.microsoft.identity.common.internal.activebrokerdiscovery.BrokerDiscoveryClient.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull BrokerData brokerData) {
                Intrinsics.checkNotNullParameter(brokerData, "brokerData");
                return Boolean.valueOf(new BrokerValidator(context).isSignedByKnownKeys(brokerData));
            }
        });
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(components, "components");
        Intrinsics.checkNotNullParameter(cache, "cache");
    }
}
