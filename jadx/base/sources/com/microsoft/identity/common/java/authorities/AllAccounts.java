package com.microsoft.identity.common.java.authorities;

import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class AllAccounts extends AzureActiveDirectoryAudience {
    public static final String ALL_ACCOUNTS_TENANT_ID = "common";

    public AllAccounts() {
        setTenantId("common");
    }

    public AllAccounts(@NonNull String str) {
        if (str != null) {
            setCloudUrl(str);
            setTenantId("common");
            return;
        }
        throw new NullPointerException("cloudUrl is marked non-null but is null");
    }
}
