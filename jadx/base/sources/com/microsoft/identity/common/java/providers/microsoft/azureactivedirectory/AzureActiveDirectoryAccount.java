package com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory;

import androidx.compose.foundation.layout.AbstractC1038a;
import com.microsoft.identity.common.java.constants.SpotbugsWarning;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAccount;
import com.microsoft.identity.common.java.providers.oauth2.IDToken;
import com.microsoft.identity.common.java.util.StringUtil;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.HashMap;
import java.util.Map;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class AzureActiveDirectoryAccount extends MicrosoftAccount {
    private static final String TAG = "AzureActiveDirectoryAccount";
    private String mIdentityProvider;

    public AzureActiveDirectoryAccount() {
    }

    @Override // com.microsoft.identity.common.java.providers.microsoft.MicrosoftAccount
    public boolean canEqual(Object obj) {
        return obj instanceof AzureActiveDirectoryAccount;
    }

    @Override // com.microsoft.identity.common.java.providers.microsoft.MicrosoftAccount
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AzureActiveDirectoryAccount)) {
            return false;
        }
        AzureActiveDirectoryAccount azureActiveDirectoryAccount = (AzureActiveDirectoryAccount) obj;
        if (!azureActiveDirectoryAccount.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        String str = this.mIdentityProvider;
        String str2 = azureActiveDirectoryAccount.mIdentityProvider;
        return str != null ? str.equals(str2) : str2 == null;
    }

    @Override // com.microsoft.identity.common.java.dto.IAccountRecord
    public String getAuthorityType() {
        return MicrosoftAccount.AUTHORITY_TYPE_MS_STS;
    }

    @Override // com.microsoft.identity.common.java.providers.microsoft.MicrosoftAccount
    public String getDisplayableIdFromClaims(Map<String, ?> map) {
        if (!StringUtil.isNullOrEmpty((String) map.get("upn"))) {
            Logger.info(TAG + ":getDisplayableId", "Returning upn as displayableId");
            return (String) map.get("upn");
        }
        if (StringUtil.isNullOrEmpty((String) map.get("email"))) {
            return null;
        }
        Logger.info(TAG + ":getDisplayableId", "Returning email as displayableId");
        return (String) map.get("email");
    }

    public synchronized String getIdentityProvider() {
        return this.mIdentityProvider;
    }

    @Override // com.microsoft.identity.common.java.providers.microsoft.MicrosoftAccount
    public int hashCode() {
        int iHashCode = super.hashCode();
        String str = this.mIdentityProvider;
        return (iHashCode * 59) + (str == null ? 43 : str.hashCode());
    }

    public synchronized void setIdentityProvider(String str) {
        this.mIdentityProvider = str;
    }

    @Override // com.microsoft.identity.common.java.providers.microsoft.MicrosoftAccount
    public String toString() {
        StringBuilder sb = new StringBuilder("AzureActiveDirectoryAccount{} ");
        sb.append(super.toString());
        sb.append(", mIdentityProvider='");
        return AbstractC1038a.m1213n('\'', this.mIdentityProvider, sb);
    }

    @SuppressFBWarnings({SpotbugsWarning.RCN_REDUNDANT_NULLCHECK_WOULD_HAVE_BEEN_A_NPE})
    public AzureActiveDirectoryAccount(@NonNull IDToken iDToken, @NonNull ClientInfo clientInfo) {
        super(iDToken, clientInfo);
        if (iDToken == null) {
            throw new NullPointerException("idToken is marked non-null but is null");
        }
        if (clientInfo == null) {
            throw new NullPointerException("clientInfo is marked non-null but is null");
        }
        this.mIdentityProvider = (String) new HashMap(iDToken.getTokenClaims()).get("idp");
        String str = TAG;
        Logger.verbose(str, "Init: " + str);
    }
}
