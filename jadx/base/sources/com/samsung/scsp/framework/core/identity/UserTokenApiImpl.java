package com.samsung.scsp.framework.core.identity;

import com.samsung.scsp.framework.core.SContextHolder;
import com.samsung.scsp.framework.core.ScspException;
import com.samsung.scsp.framework.core.identity.IdentityApiContract;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
class UserTokenApiImpl extends AbstractTokenApi {
    public UserTokenApiImpl(SContextHolder sContextHolder) {
        super(sContextHolder, IdentityApiContract.Token.USER);
    }

    @Override // com.samsung.scsp.framework.core.identity.AbstractTokenApi
    public Map<String, String> makeRequestHeader(SContextHolder sContextHolder) throws ScspException {
        Map<String, String> mapMakeRequestHeader = super.makeRequestHeader(sContextHolder);
        AccountInfoSupplier accountInfoSupplier = sContextHolder.scontext.getAccountInfoSupplier();
        mapMakeRequestHeader.put(IdentityApiContract.Header.X_SC_ACCESS_TOKEN, accountInfoSupplier.getAccessToken());
        mapMakeRequestHeader.put(IdentityApiContract.Header.X_SC_UID, accountInfoSupplier.getUserId());
        return mapMakeRequestHeader;
    }

    @Override // com.samsung.scsp.framework.core.identity.AbstractTokenApi
    public void saveToken(String str, long j) {
        ScspCorePreferences.get().userToken.accept(str);
        ScspCorePreferences.get().userTokenExpiredOn.accept(Long.valueOf(j));
        this.logger.m12934i("Success to renew user token");
    }
}
