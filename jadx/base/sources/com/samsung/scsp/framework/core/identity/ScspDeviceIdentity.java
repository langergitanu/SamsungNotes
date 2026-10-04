package com.samsung.scsp.framework.core.identity;

import com.samsung.scsp.error.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ScspDeviceIdentity extends AbstractScspIdentity {
    private static final Logger logger = Logger.get("ScspDeviceIdentity");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class LazyHolder {
        private static final DeviceIdentityImpl identityImpl = new DeviceIdentityImpl();

        private LazyHolder() {
        }
    }

    public ScspDeviceIdentity() {
        super(LazyHolder.identityImpl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onRegistrationRequired$0() {
        ScspCorePreferences.get().deviceToken.remove();
        ScspCorePreferences.get().deviceTokenExpiredOn.remove();
        super.onRegistrationRequired();
    }

    @Override // com.samsung.scsp.framework.core.identity.AbstractScspIdentity
    public void onRegistrationRequired() {
        logger.m12934i("onRegistrationRequired");
        checkSetUp();
        transactionInternal(new C11656a(this, 7));
    }
}
