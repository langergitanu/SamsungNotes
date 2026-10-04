package com.microsoft.identity.common.internal.result;

import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.request.SdkType;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class BrokerResultAdapterFactory {
    public static IBrokerResultAdapter getBrokerResultAdapter(SdkType sdkType) {
        if (sdkType == SdkType.ADAL) {
            Logger.verbose("BrokerResultAdapterFactory", "Using AdalBrokerResultAdapter");
            return new AdalBrokerResultAdapter();
        }
        Logger.verbose("BrokerResultAdapterFactory", "Using MsalBrokerResultAdapter");
        return new MsalBrokerResultAdapter();
    }
}
