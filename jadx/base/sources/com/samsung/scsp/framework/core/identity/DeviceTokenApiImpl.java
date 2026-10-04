package com.samsung.scsp.framework.core.identity;

import com.samsung.scsp.framework.core.SContextHolder;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
class DeviceTokenApiImpl extends AbstractTokenApi {
    public DeviceTokenApiImpl(SContextHolder sContextHolder) {
        super(sContextHolder, "device");
    }

    @Override // com.samsung.scsp.framework.core.identity.AbstractTokenApi
    public void saveToken(String str, long j) {
        ScspCorePreferences.get().deviceToken.accept(str);
        ScspCorePreferences.get().deviceTokenExpiredOn.accept(Long.valueOf(j));
        this.logger.m12934i("Success to renew device token");
    }
}
