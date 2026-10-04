package com.samsung.scsp.framework.core.identity;

import com.samsung.scsp.framework.core.SContextHolder;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
class DeviceRegisterApiImpl extends AbstractRegisterApi {
    public DeviceRegisterApiImpl(SContextHolder sContextHolder) {
        super(sContextHolder, "device");
    }

    @Override // com.samsung.scsp.framework.core.identity.AbstractRegisterApi
    public void saveRequestHeader(Map<String, String> map) {
    }

    @Override // com.samsung.scsp.framework.core.identity.AbstractRegisterApi
    public void saveToken(String str, String str2, long j) {
        if ("device".equals(str)) {
            ScspCorePreferences.get().deviceToken.accept(str2);
            ScspCorePreferences.get().deviceTokenExpiredOn.accept(Long.valueOf(j));
        }
    }
}
