package com.samsung.scsp.framework.core.identity;

import com.samsung.scsp.error.Logger;
import com.samsung.scsp.framework.core.util.StringUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
class DeviceRegistration extends AbstractRegistration {
    private final Logger logger = Logger.get("DeviceRegistration");
    private final AbstractRegisterApi registrationApi;

    public DeviceRegistration(AbstractRegisterApi abstractRegisterApi) {
        this.registrationApi = abstractRegisterApi;
    }

    @Override // com.samsung.scsp.framework.core.identity.AbstractRegistration
    public void register() {
        this.logger.m12934i("register");
        if (StringUtil.isEmpty(ScspCorePreferences.get().deviceToken.get())) {
            this.registrationApi.register();
        } else {
            this.logger.m12934i("Already device registered.");
        }
    }
}
