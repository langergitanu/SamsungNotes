package com.microsoft.identity.common.java.authorities;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.AzureActiveDirectorySlice;
import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsOAuth2Configuration;
import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsOAuth2Strategy;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2StrategyParameters;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.remotefunction.RemoteConstant;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class CIAMAuthority extends Authority {
    public static final String CIAM_LOGIN_URL_SEGMENT = "ciamlogin.com";
    private static final transient String TAG = "CIAMAuthority";
    private final boolean CIAM_USE_OPENID_CONFIGURATION = true;

    public CIAMAuthority(@NonNull String str) {
        if (str == null) {
            throw new NullPointerException("authorityUrl is marked non-null but is null");
        }
        this.mAuthorityTypeString = Authority.CIAM;
        this.mAuthorityUrlString = str;
    }

    private MicrosoftStsOAuth2Configuration createOAuth2Configuration() {
        StringBuilder sb = new StringBuilder();
        String str = TAG;
        sb.append(str);
        sb.append(":createOAuth2Configuration");
        Logger.verbose(sb.toString(), "Creating OAuth2Configuration");
        MicrosoftStsOAuth2Configuration microsoftStsOAuth2Configuration = new MicrosoftStsOAuth2Configuration();
        microsoftStsOAuth2Configuration.setAuthorityUrl(getAuthorityURL());
        microsoftStsOAuth2Configuration.setMultipleCloudsSupported(false);
        if (this.mSlice != null) {
            Logger.info(str + ":createOAuth2Configuration", "Setting slice parameters...");
            AzureActiveDirectorySlice azureActiveDirectorySlice = new AzureActiveDirectorySlice();
            azureActiveDirectorySlice.setSlice(this.mSlice.getSlice());
            azureActiveDirectorySlice.setDataCenter(this.mSlice.getDataCenter());
            microsoftStsOAuth2Configuration.setSlice(azureActiveDirectorySlice);
        }
        return microsoftStsOAuth2Configuration;
    }

    public static String getTenantIdVariantUrlFromAuthorityWithoutPath(@NonNull String str, @NonNull String str2) {
        if (str == null) {
            throw new NullPointerException("authorityNoPath is marked non-null but is null");
        }
        if (str2 == null) {
            throw new NullPointerException("tenantId is marked non-null but is null");
        }
        if (str.startsWith("https://")) {
            str = str.substring(8);
        }
        if (str.endsWith("/")) {
            str = AbstractC2322a.m1614d(1, 0, str);
        }
        return AbstractC0541b.m774p("https://", str, "/", str2);
    }

    public static String getTenantNameVariantUrlFromAuthorityWithoutPath(@NonNull String str) {
        if (str == null) {
            throw new NullPointerException("authorityNoPath is marked non-null but is null");
        }
        if (str.startsWith("https://")) {
            str = str.substring(8);
        }
        if (str.endsWith("/")) {
            str = AbstractC2322a.m1614d(1, 0, str);
        }
        return AbstractC0541b.m775q("https://", str, "/", str.split(RemoteConstant.VERSION_DIVIDE)[0], ".onmicrosoft.com");
    }

    @Override // com.microsoft.identity.common.java.authorities.Authority
    public OAuth2Strategy createOAuth2Strategy(OAuth2StrategyParameters oAuth2StrategyParameters) {
        MicrosoftStsOAuth2Configuration microsoftStsOAuth2ConfigurationCreateOAuth2Configuration = createOAuth2Configuration();
        oAuth2StrategyParameters.setUsingOpenIdConfiguration(true);
        return new MicrosoftStsOAuth2Strategy(microsoftStsOAuth2ConfigurationCreateOAuth2Configuration, oAuth2StrategyParameters);
    }
}
