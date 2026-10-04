package com.samsung.scsp.framework.core.identity;

import android.os.Build;
import com.samsung.scsp.common.ContextFactory;
import com.samsung.scsp.error.FaultBarrier;
import com.samsung.scsp.error.Logger;
import com.samsung.scsp.framework.core.BuildConfig;
import com.samsung.scsp.framework.core.SContext;
import com.samsung.scsp.framework.core.SContextHolder;
import com.samsung.scsp.framework.core.decorator.SdkConfig;
import com.samsung.scsp.framework.core.util.DeviceUtil;
import com.samsung.scsp.framework.core.util.StringUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
abstract class AbstractIdentityImpl implements Identity {
    protected final Logger logger = Logger.get(getClass().getSimpleName());
    protected AbstractRegistration registration;
    protected final SContextHolder scontextHolder;
    protected AbstractToken token;
    protected AbstractUpdater updater;

    public AbstractIdentityImpl(boolean z) {
        this.scontextHolder = new SContextHolder(BuildConfig.LIBRARY_PACKAGE_NAME, BuildConfig.VERSION_NAME, z, false, SdkConfig.Domain.play);
    }

    private void checkRegister() {
        if (isAppVersionChanged() || isOsVersionChanged() || isPlatformVersionChanged() || isCountryCodeChanged() || isNewPdidCreated()) {
            this.logger.m12934i("Re-register is required due to property change");
            ScspCorePreferences.get().clear();
        }
        this.registration.register();
    }

    private void checkToken() {
        this.token.get();
    }

    private boolean isAppVersionChanged() {
        String appVersion = SContext.getInstance().getAppVersion();
        return (StringUtil.isEmpty(appVersion) || StringUtil.equals(ScspCorePreferences.get().appVersion.get(), appVersion)) ? false : true;
    }

    private boolean isCountryCodeChanged() {
        String iso3CountryCode = DeviceUtil.getIso3CountryCode(ContextFactory.getApplicationContext());
        return (StringUtil.isEmpty(iso3CountryCode) || StringUtil.equals(ScspCorePreferences.get().countryCode.get(), iso3CountryCode)) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean isNewPdidCreated() {
        if (StringUtil.isEmpty(ScspCorePreferences.get().pdid.get())) {
            return !StringUtil.isEmpty((String) FaultBarrier.get(new C11656a(this, 0), null, true).obj);
        }
        return false;
    }

    private boolean isOsVersionChanged() {
        String string = Integer.toString(Build.VERSION.SDK_INT);
        return (StringUtil.isEmpty(string) || StringUtil.equals(ScspCorePreferences.get().osVersion.get(), string)) ? false : true;
    }

    private boolean isPlatformVersionChanged() {
        String oneUiVersion = DeviceUtil.getOneUiVersion();
        return (StringUtil.isEmpty(oneUiVersion) || StringUtil.equals(ScspCorePreferences.get().platformVersion.get(), oneUiVersion)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$isNewPdidCreated$0() {
        return DeviceUtil.getDeviceUniqueId(ContextFactory.getApplicationContext(), this.scontextHolder.scontext.getDeviceIdSupplier());
    }

    @Override // com.samsung.scsp.framework.core.identity.Identity
    public void checkUpdate() {
        this.updater.update();
    }

    @Override // com.samsung.scsp.framework.core.identity.Identity
    public String getToken() {
        return this.token.get();
    }

    @Override // com.samsung.scsp.framework.core.identity.Identity
    public boolean initialize() {
        checkRegister();
        checkToken();
        return true;
    }

    @Override // com.samsung.scsp.framework.core.identity.Identity
    public void onRegistrationRequired() {
        this.registration.register();
    }

    @Override // com.samsung.scsp.framework.core.identity.Identity
    public void renewToken(String str) {
        this.token.renew(str);
    }
}
