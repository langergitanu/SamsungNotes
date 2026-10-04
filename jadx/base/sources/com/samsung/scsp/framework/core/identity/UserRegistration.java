package com.samsung.scsp.framework.core.identity;

import com.samsung.scsp.error.FaultBarrier;
import com.samsung.scsp.error.Logger;
import com.samsung.scsp.error.Result;
import com.samsung.scsp.framework.core.SContext;
import com.samsung.scsp.framework.core.ScspException;
import com.samsung.scsp.framework.core.util.StringUtil;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
class UserRegistration extends AbstractRegistration {
    private final Logger logger = Logger.get("UserRegistration");
    private final UserRegisterApiImpl registrationApi;

    public UserRegistration(UserRegisterApiImpl userRegisterApiImpl) {
        this.registrationApi = userRegisterApiImpl;
    }

    private void handle(FaultBarrier.ThrowableRunnable throwableRunnable) throws ScspException {
        Result resultRun = FaultBarrier.run(throwableRunnable);
        if (resultRun.rcode == 40100001) {
            ScspIdentityFactory.getUserInstance().onUnauthenticatedForSA();
            verifyAccount();
            resultRun = FaultBarrier.run(throwableRunnable);
        }
        if (!resultRun.success) {
            throw new ScspException(resultRun.rcode, resultRun.rmsg);
        }
    }

    private void verifyAccount() throws ScspException {
        AccountInfoSupplier accountInfoSupplier = SContext.getInstance().getAccountInfoSupplier();
        if (accountInfoSupplier == null || !accountInfoSupplier.has()) {
            ScspCorePreferences.get().clearUser();
            throw new ScspException(ScspException.Code.BAD_IMPLEMENTATION, "Not support your feature when accountInfo is not valid");
        }
    }

    public void deregister(String str) {
        this.logger.m12934i("deregister");
        this.registrationApi.deregister(str);
    }

    @Override // com.samsung.scsp.framework.core.identity.AbstractRegistration
    public void register() throws ScspException {
        this.logger.m12934i("register");
        verifyAccount();
        if (!StringUtil.isEmpty(ScspCorePreferences.get().userToken.get())) {
            this.logger.m12934i("Already user registered.");
            return;
        }
        UserRegisterApiImpl userRegisterApiImpl = this.registrationApi;
        Objects.requireNonNull(userRegisterApiImpl);
        handle(new C11666k(userRegisterApiImpl));
    }
}
