package com.samsung.scsp.framework.core.identity;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
class DeviceIdentityImpl extends AbstractIdentityImpl {
    public DeviceIdentityImpl() {
        super(false);
        this.registration = new DeviceRegistration(new DeviceRegisterApiImpl(this.scontextHolder));
        this.token = new DeviceToken(new DeviceTokenApiImpl(this.scontextHolder));
        this.updater = new DeviceUpdater(new DeviceUpdateApiImpl(this.scontextHolder, new C11656a(this, 3)));
    }
}
