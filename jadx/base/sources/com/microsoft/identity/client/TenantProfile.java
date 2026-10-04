package com.microsoft.identity.client;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.microsoft.identity.common.java.providers.oauth2.IDToken;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class TenantProfile extends Account implements ITenantProfile {
    public TenantProfile(@Nullable String str, @Nullable IDToken iDToken) {
        super(str, iDToken);
    }

    @Override // com.microsoft.identity.client.Account, com.microsoft.identity.client.IClaimable
    @NonNull
    public String getTenantId() {
        String str;
        return (getClaims() == null || (str = (String) getClaims().get("tid")) == null) ? "" : str;
    }
}
