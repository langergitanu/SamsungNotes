package com.nimbusds.jose.jca;

import java.security.Provider;
import java.security.SecureRandom;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class JCAContext {
    private Provider provider;
    private SecureRandom randomGen;

    public JCAContext() {
        this(null, null);
    }

    public Provider getProvider() {
        return this.provider;
    }

    public SecureRandom getSecureRandom() {
        SecureRandom secureRandom = this.randomGen;
        return secureRandom != null ? secureRandom : new SecureRandom();
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public void setSecureRandom(SecureRandom secureRandom) {
        this.randomGen = secureRandom;
    }

    public JCAContext(Provider provider, SecureRandom secureRandom) {
        this.provider = provider;
        this.randomGen = secureRandom;
    }
}
