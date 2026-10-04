package com.microsoft.identity.common.java.providers.oauth2;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class ClientAssertion {
    private static final String DEFAULT_CLIENT_ASSERTION_TYPE = "urn:ietf:params:oauth:client-assertion-type:jwt-bearer";
    private String mClientAssertion;
    private String mClientAssertionType = DEFAULT_CLIENT_ASSERTION_TYPE;

    public String getClientAssertion() {
        return this.mClientAssertion;
    }

    public String getClientAssertionType() {
        return this.mClientAssertionType;
    }

    public void setClientAssertion(String str) {
        this.mClientAssertion = str;
    }

    public void setClientAssertionType(String str) {
        this.mClientAssertionType = str;
    }
}
