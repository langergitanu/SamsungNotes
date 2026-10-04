package com.microsoft.identity.common.java.providers.microsoft;

import com.microsoft.identity.common.java.constants.SpotbugsWarning;
import com.microsoft.identity.common.java.exception.ServiceException;
import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.ClientInfo;
import com.microsoft.identity.common.java.providers.oauth2.RefreshToken;
import com.microsoft.identity.common.java.util.SchemaUtil;
import com.microsoft.identity.common.java.util.StringUtil;
import edu.umd.cs.findbugs.annotations.Nullable;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@SuppressFBWarnings({SpotbugsWarning.RCN_REDUNDANT_NULLCHECK_WOULD_HAVE_BEEN_A_NPE})
public class MicrosoftRefreshToken extends RefreshToken {
    private String mClientId;
    private ClientInfo mClientInfo;
    private String mEnvironment;
    private String mFamilyId;
    private String mScope;

    public MicrosoftRefreshToken(String str, ClientInfo clientInfo, String str2, String str3, String str4, @Nullable String str5) {
        super(str);
        this.mClientInfo = clientInfo;
        this.mScope = str2;
        this.mClientId = str3;
        this.mEnvironment = str4;
        this.mFamilyId = str5;
    }

    @Override // com.microsoft.identity.common.java.dto.IRefreshTokenRecord
    public String getClientId() {
        return this.mClientId;
    }

    public ClientInfo getClientInfo() {
        return this.mClientInfo;
    }

    @Override // com.microsoft.identity.common.java.dto.IRefreshTokenRecord
    public String getEnvironment() {
        return this.mEnvironment;
    }

    @Override // com.microsoft.identity.common.java.dto.IRefreshTokenRecord
    public String getFamilyId() {
        return this.mFamilyId;
    }

    @Override // com.microsoft.identity.common.java.dto.IRefreshTokenRecord
    public String getHomeAccountId() {
        return SchemaUtil.getHomeAccountId(this.mClientInfo);
    }

    public boolean getIsFamilyRefreshToken() {
        return !StringUtil.isNullOrEmpty(this.mFamilyId);
    }

    @Override // com.microsoft.identity.common.java.dto.IRefreshTokenRecord
    public String getSecret() {
        return getRefreshToken();
    }

    @Override // com.microsoft.identity.common.java.dto.IRefreshTokenRecord
    public String getTarget() {
        return this.mScope;
    }

    public void setEnvironment(String str) {
        this.mEnvironment = str;
    }

    public MicrosoftRefreshToken(@NonNull MicrosoftTokenResponse microsoftTokenResponse) {
        super(microsoftTokenResponse);
        if (microsoftTokenResponse != null) {
            try {
                this.mClientInfo = new ClientInfo(microsoftTokenResponse.getClientInfo());
                this.mFamilyId = microsoftTokenResponse.getFamilyId();
                this.mScope = microsoftTokenResponse.getScope();
                this.mClientId = microsoftTokenResponse.getClientId();
                return;
            } catch (ServiceException e) {
                throw new RuntimeException(e);
            }
        }
        throw new NullPointerException("tokenResponse is marked non-null but is null");
    }
}
