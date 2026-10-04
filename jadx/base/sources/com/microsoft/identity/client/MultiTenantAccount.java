package com.microsoft.identity.client;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.microsoft.identity.common.java.providers.oauth2.IDToken;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class MultiTenantAccount extends Account implements IMultiTenantAccount {
    private Map<String, ITenantProfile> mTenantProfiles;

    public MultiTenantAccount(@Nullable String str, @Nullable IDToken iDToken) {
        super(str, iDToken);
        this.mTenantProfiles = new HashMap();
    }

    @Override // com.microsoft.identity.client.IMultiTenantAccount
    @NonNull
    public Map<String, ITenantProfile> getTenantProfiles() {
        return Collections.unmodifiableMap(this.mTenantProfiles);
    }

    public void setTenantProfiles(@NonNull Map<String, ITenantProfile> map) {
        this.mTenantProfiles = map;
    }
}
