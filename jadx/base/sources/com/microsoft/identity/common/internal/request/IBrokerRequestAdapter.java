package com.microsoft.identity.common.internal.request;

import com.microsoft.identity.common.internal.broker.BrokerRequest;
import com.microsoft.identity.common.java.commands.parameters.DeviceCodeFlowCommandParameters;
import com.microsoft.identity.common.java.commands.parameters.InteractiveTokenCommandParameters;
import com.microsoft.identity.common.java.commands.parameters.SilentTokenCommandParameters;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface IBrokerRequestAdapter {
    BrokerRequest brokerRequestFromAcquireTokenParameters(InteractiveTokenCommandParameters interactiveTokenCommandParameters);

    BrokerRequest brokerRequestFromDeviceCodeFlowCommandParameters(DeviceCodeFlowCommandParameters deviceCodeFlowCommandParameters);

    BrokerRequest brokerRequestFromSilentOperationParameters(SilentTokenCommandParameters silentTokenCommandParameters);
}
