package com.microsoft.identity.common.java.interfaces;

import com.microsoft.identity.common.java.providers.oauth2.IStateGenerator;
import com.microsoft.identity.common.java.strategies.IAuthorizationStrategyFactory;
import com.microsoft.identity.common.java.util.IBroadcaster;
import com.microsoft.identity.common.java.util.IClockSkewManager;
import com.microsoft.identity.common.java.util.IPlatformUtil;
import edu.umd.cs.findbugs.annotations.Nullable;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface IPlatformComponents extends IPopManagerSupplier {
    @Nullable
    IAuthorizationStrategyFactory getAuthorizationStrategyFactory();

    @NonNull
    IBroadcaster getBroadcaster();

    @NonNull
    IClockSkewManager getClockSkewManager();

    @NonNull
    IHttpClientWrapper getHttpClientWrapper();

    @NonNull
    IPlatformUtil getPlatformUtil();

    @Nullable
    IStateGenerator getStateGenerator();

    @NonNull
    IStorageSupplier getStorageSupplier();
}
