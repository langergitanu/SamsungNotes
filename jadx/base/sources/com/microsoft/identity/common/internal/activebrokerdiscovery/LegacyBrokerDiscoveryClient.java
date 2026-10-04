package com.microsoft.identity.common.internal.activebrokerdiscovery;

import android.content.Context;
import com.microsoft.identity.common.internal.broker.BrokerData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, m13886d2 = {"Lcom/microsoft/identity/common/internal/activebrokerdiscovery/LegacyBrokerDiscoveryClient;", "Lcom/microsoft/identity/common/internal/activebrokerdiscovery/IBrokerDiscoveryClient;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "getActiveBroker", "Lcom/microsoft/identity/common/internal/broker/BrokerData;", "shouldSkipCache", "", "common_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class LegacyBrokerDiscoveryClient implements IBrokerDiscoveryClient {

    @NotNull
    private final Context context;

    public LegacyBrokerDiscoveryClient(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    @Override // com.microsoft.identity.common.internal.activebrokerdiscovery.IBrokerDiscoveryClient
    @Nullable
    public BrokerData getActiveBroker(boolean shouldSkipCache) {
        return new AccountManagerBrokerDiscoveryUtil(this.context).getActiveBrokerFromAccountManager();
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }
}
