package com.microsoft.identity.common.internal.cache;

import com.microsoft.identity.common.internal.broker.BrokerData;
import kotlin.Metadata;
import net.jcip.annotations.ThreadSafe;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&¨\u0006\r"}, m13886d2 = {"Lcom/microsoft/identity/common/internal/cache/IActiveBrokerCache;", "", "clearCachedActiveBroker", "", "getCachedActiveBroker", "Lcom/microsoft/identity/common/internal/broker/BrokerData;", "setCachedActiveBroker", "brokerData", "setShouldUseAccountManagerForTheNextMilliseconds", "timeInMillis", "", "shouldUseAccountManager", "", "common_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
@ThreadSafe
public interface IActiveBrokerCache {
    void clearCachedActiveBroker();

    @Nullable
    BrokerData getCachedActiveBroker();

    void setCachedActiveBroker(@NotNull BrokerData brokerData);

    void setShouldUseAccountManagerForTheNextMilliseconds(long timeInMillis);

    boolean shouldUseAccountManager();
}
