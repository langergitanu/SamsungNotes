package com.samsung.scsp.framework.core.identity;

import com.samsung.scsp.error.FaultBarrier;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
class DeviceUpdater extends AbstractUpdater {
    private final DeviceUpdateApiImpl updateApi;

    public DeviceUpdater(DeviceUpdateApiImpl deviceUpdateApiImpl) {
        this.updateApi = deviceUpdateApiImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$update$0(DeviceInfo deviceInfo) {
        this.updateApi.update(deviceInfo);
    }

    @Override // com.samsung.scsp.framework.core.identity.AbstractUpdater
    public void update() {
        DeviceInfo newDeviceInfo = getNewDeviceInfo();
        if (newDeviceInfo.isAllFieldsNull()) {
            return;
        }
        FaultBarrier.run(new C11658c(this, newDeviceInfo, 5));
    }
}
