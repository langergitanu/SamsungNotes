package com.samsung.scsp.framework.core.identity;

import com.samsung.scsp.error.FaultBarrier;
import com.samsung.scsp.error.Response;
import com.samsung.scsp.framework.core.SContext;
import com.samsung.scsp.framework.core.ScspException;
import com.samsung.scsp.framework.core.util.StringUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
class UserToken extends AbstractToken {
    public UserToken(AbstractTokenApi abstractTokenApi) {
        super(abstractTokenApi, true);
    }

    private void verifyAccount() throws ScspException {
        AccountInfoSupplier accountInfoSupplier = SContext.getInstance().getAccountInfoSupplier();
        if (accountInfoSupplier == null || !accountInfoSupplier.has()) {
            ScspCorePreferences.get().clearUser();
            throw new ScspException(ScspException.Code.BAD_IMPLEMENTATION, "Not support your feature when accountInfo is not valid");
        }
    }

    @Override // com.samsung.scsp.framework.core.identity.AbstractToken
    public String get() throws ScspException {
        this.logger.m12934i("Get token");
        verifyAccount();
        String tokenFromPreference = getTokenFromPreference();
        if (StringUtil.isEmpty(tokenFromPreference)) {
            this.logger.m12934i("UserToken is empty");
            ScspIdentityFactory.getInstance(true).onRegistrationRequired();
            return getTokenFromPreference();
        }
        if (ScspCorePreferences.get().userTokenExpiredOn.get().longValue() <= System.currentTimeMillis()) {
            this.logger.m12934i("UserToken is expired");
            return renew(tokenFromPreference);
        }
        this.logger.m12934i("UserToken is valid");
        return tokenFromPreference;
    }

    @Override // com.samsung.scsp.framework.core.identity.AbstractToken
    public String getTokenFromPreference() {
        return ScspCorePreferences.get().userToken.get();
    }

    @Override // com.samsung.scsp.framework.core.identity.AbstractToken
    public Response<String> handle(FaultBarrier.ThrowableSupplier<String> throwableSupplier) throws ScspException {
        Response<String> responseHandle = super.handle(throwableSupplier);
        if (responseHandle.rcode != 40100001) {
            return responseHandle;
        }
        ScspIdentityFactory.getUserInstance().onUnauthenticatedForSA();
        verifyAccount();
        return FaultBarrier.get(throwableSupplier, null);
    }
}
