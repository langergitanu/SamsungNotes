package com.microsoft.identity.common.java.providers.microsoft.microsoftsts;

import com.microsoft.identity.common.java.constants.SpotbugsWarning;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAccount;
import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.ClientInfo;
import com.microsoft.identity.common.java.providers.oauth2.IDToken;
import com.microsoft.identity.common.java.util.SchemaUtil;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.Map;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class MicrosoftStsAccount extends MicrosoftAccount {
    private static final String TAG = "MicrosoftStsAccount";

    public MicrosoftStsAccount() {
        String str = TAG;
        Logger.verbose(str, "Init: " + str);
    }

    @Override // com.microsoft.identity.common.java.providers.microsoft.MicrosoftAccount
    public boolean canEqual(Object obj) {
        return obj instanceof MicrosoftStsAccount;
    }

    @Override // com.microsoft.identity.common.java.providers.microsoft.MicrosoftAccount
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof MicrosoftStsAccount) && ((MicrosoftStsAccount) obj).canEqual(this) && super.equals(obj);
    }

    @Override // com.microsoft.identity.common.java.dto.IAccountRecord
    public String getAuthorityType() {
        return MicrosoftAccount.AUTHORITY_TYPE_MS_STS;
    }

    @Override // com.microsoft.identity.common.java.providers.microsoft.MicrosoftAccount
    public String getDisplayableIdFromClaims(@NonNull Map<String, ?> map) {
        if (map != null) {
            return SchemaUtil.getDisplayableId(map);
        }
        throw new NullPointerException("claims is marked non-null but is null");
    }

    @Override // com.microsoft.identity.common.java.providers.microsoft.MicrosoftAccount
    public int hashCode() {
        return super.hashCode();
    }

    @SuppressFBWarnings({SpotbugsWarning.RCN_REDUNDANT_NULLCHECK_WOULD_HAVE_BEEN_A_NPE})
    public MicrosoftStsAccount(@NonNull IDToken iDToken, @NonNull ClientInfo clientInfo) {
        super(iDToken, clientInfo);
        if (iDToken == null) {
            throw new NullPointerException("idToken is marked non-null but is null");
        }
        if (clientInfo != null) {
            String str = TAG;
            Logger.verbose(str, "Init: " + str);
            return;
        }
        throw new NullPointerException("clientInfo is marked non-null but is null");
    }
}
