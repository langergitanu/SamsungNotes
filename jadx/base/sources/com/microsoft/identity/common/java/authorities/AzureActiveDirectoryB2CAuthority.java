package com.microsoft.identity.common.java.authorities;

import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.AzureActiveDirectorySlice;
import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsOAuth2Configuration;
import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsOAuth2Strategy;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2StrategyParameters;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class AzureActiveDirectoryB2CAuthority extends Authority {
    private static final String TAG = "AzureActiveDirectoryB2CAuthority";

    public AzureActiveDirectoryB2CAuthority(String str) {
        this.mAuthorityTypeString = "B2C";
        this.mAuthorityUrlString = str;
    }

    public MicrosoftStsOAuth2Configuration createOAuth2Configuration() {
        StringBuilder sb = new StringBuilder();
        String str = TAG;
        sb.append(str);
        sb.append(":createOAuth2Configuration");
        Logger.verbose(sb.toString(), "Creating OAuth2Configuration");
        MicrosoftStsOAuth2Configuration microsoftStsOAuth2Configuration = new MicrosoftStsOAuth2Configuration();
        microsoftStsOAuth2Configuration.setMultipleCloudsSupported(false);
        microsoftStsOAuth2Configuration.setAuthorityUrl(getAuthorityURL());
        if (this.mSlice != null) {
            Logger.info(str + ":createOAuth2Configuration", "Setting slice parameters...");
            AzureActiveDirectorySlice azureActiveDirectorySlice = new AzureActiveDirectorySlice();
            azureActiveDirectorySlice.setSlice(this.mSlice.getSlice());
            azureActiveDirectorySlice.setDataCenter(this.mSlice.getDataCenter());
            microsoftStsOAuth2Configuration.setSlice(azureActiveDirectorySlice);
        }
        return microsoftStsOAuth2Configuration;
    }

    @Override // com.microsoft.identity.common.java.authorities.Authority
    public OAuth2Strategy createOAuth2Strategy(@NonNull OAuth2StrategyParameters oAuth2StrategyParameters) {
        if (oAuth2StrategyParameters != null) {
            return new MicrosoftStsOAuth2Strategy(createOAuth2Configuration(), oAuth2StrategyParameters);
        }
        throw new NullPointerException("parameters is marked non-null but is null");
    }

    public String getB2CPolicyName() {
        return this.mAuthorityUrlString.split("/")[r0.length - 1];
    }
}
