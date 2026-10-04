package com.samsung.scsp.framework.core.identity;

import com.samsung.scsp.common.ContextFactory;
import com.samsung.scsp.framework.core.ScspException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ScspIdentityFactory {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class LazyHolder {
        private static final ScspUserIdentity scspUserIdentity = new ScspUserIdentity();
        private static final ScspDeviceIdentity scspDeviceIdentity = new ScspDeviceIdentity();

        private LazyHolder() {
        }
    }

    private static void checkContext() throws ScspException {
        if (ContextFactory.getApplicationContext() == null) {
            throw new ScspException(ScspException.Code.BAD_IMPLEMENTATION, "SDK is not set up. please check if Scsp.setUp has been called.");
        }
    }

    public static AbstractScspIdentity getInstance(boolean z) throws ScspException {
        checkContext();
        return z ? LazyHolder.scspUserIdentity : LazyHolder.scspDeviceIdentity;
    }

    public static ScspUserIdentity getUserInstance() throws ScspException {
        checkContext();
        return LazyHolder.scspUserIdentity;
    }
}
