package com.samsung.scsp.framework.core.identity;

import com.samsung.scsp.error.FaultBarrier;
import com.samsung.scsp.error.Logger;
import com.samsung.scsp.error.Response;
import com.samsung.scsp.framework.core.ScspException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
abstract class AbstractToken {
    private final boolean isAccountRequiredFeature;
    protected final Logger logger = Logger.get(getClass().getSimpleName());
    private final AbstractTokenApi tokenApi;

    public AbstractToken(AbstractTokenApi abstractTokenApi, boolean z) {
        this.tokenApi = abstractTokenApi;
        this.isAccountRequiredFeature = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$renew$0(String str) {
        return this.tokenApi.renew(str);
    }

    public abstract String get();

    public abstract String getTokenFromPreference();

    public Response<String> handle(FaultBarrier.ThrowableSupplier<String> throwableSupplier) {
        Response<String> response = FaultBarrier.get(throwableSupplier, null);
        if (response.rcode != 40001001) {
            return response;
        }
        ScspIdentityFactory.getInstance(this.isAccountRequiredFeature).onRegistrationRequired();
        return FaultBarrier.get(new C11656a(this, 2), null);
    }

    public String renew(String str) throws ScspException {
        this.logger.m12934i("Renew token");
        Response<String> responseHandle = handle(new C11658c(this, str, 2));
        if (responseHandle.success) {
            return responseHandle.obj;
        }
        throw new ScspException(responseHandle.rcode, responseHandle.rmsg);
    }
}
