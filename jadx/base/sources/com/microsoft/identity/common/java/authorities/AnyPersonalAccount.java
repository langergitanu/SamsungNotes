package com.microsoft.identity.common.java.authorities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class AnyPersonalAccount extends AzureActiveDirectoryAudience {
    public static final String ANY_PERSONAL_ACCOUNT_TENANT_ID = "consumers";

    public AnyPersonalAccount() {
        setTenantId("consumers");
    }

    public AnyPersonalAccount(String str) {
        setTenantId("consumers");
        setCloudUrl(str);
    }
}
