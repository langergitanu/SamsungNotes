package com.samsung.scsp.framework.core.identity;

import com.samsung.scsp.framework.core.util.StringUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
class DeviceToken extends AbstractToken {
    public DeviceToken(AbstractTokenApi abstractTokenApi) {
        super(abstractTokenApi, false);
    }

    @Override // com.samsung.scsp.framework.core.identity.AbstractToken
    public String get() {
        this.logger.m12934i("Get token");
        String tokenFromPreference = getTokenFromPreference();
        if (StringUtil.isEmpty(tokenFromPreference)) {
            this.logger.m12934i("DeviceToken is empty");
            ScspIdentityFactory.getInstance(false).onRegistrationRequired();
            return getTokenFromPreference();
        }
        if (ScspCorePreferences.get().deviceTokenExpiredOn.get().longValue() <= System.currentTimeMillis()) {
            this.logger.m12934i("DeviceToken is expired");
            return renew(tokenFromPreference);
        }
        this.logger.m12934i("DeviceToken is valid");
        return tokenFromPreference;
    }

    @Override // com.samsung.scsp.framework.core.identity.AbstractToken
    public String getTokenFromPreference() {
        return ScspCorePreferences.get().deviceToken.get();
    }
}
