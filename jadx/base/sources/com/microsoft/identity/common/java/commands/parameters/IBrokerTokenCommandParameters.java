package com.microsoft.identity.common.java.commands.parameters;

import com.microsoft.identity.common.java.broker.IBrokerAccount;
import com.microsoft.identity.common.java.request.BrokerRequestType;
import edu.umd.cs.findbugs.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface IBrokerTokenCommandParameters {
    IBrokerAccount getBrokerAccount();

    String getBrokerVersion();

    String getCallerAppVersion();

    String getCallerPackageName();

    int getCallerUid();

    String getHomeAccountId();

    @Nullable
    String getHomeTenantId();

    String getLocalAccountId();

    String getNegotiatedBrokerProtocolVersion();

    BrokerRequestType getRequestType();

    default boolean isRequestFromBroker() {
        return getRequestType() == BrokerRequestType.BROKER_RT_REQUEST || getRequestType() == BrokerRequestType.RESOLVE_INTERRUPT;
    }
}
