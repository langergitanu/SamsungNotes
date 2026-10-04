package com.microsoft.identity.common.java.authorities;

import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.opentelemetry.AttributeName;
import com.microsoft.identity.common.java.opentelemetry.SpanExtension;
import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.AzureActiveDirectory;
import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.AzureActiveDirectoryCloud;
import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.AzureActiveDirectorySlice;
import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsOAuth2Configuration;
import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsOAuth2Strategy;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2StrategyParameters;
import com.microsoft.identity.common.java.util.CommonURIBuilder;
import com.microsoft.identity.common.java.util.StringUtil;
import edu.umd.cs.findbugs.annotations.Nullable;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class AzureActiveDirectoryAuthority extends Authority {
    private static final transient String TAG = "AzureActiveDirectoryAuthority";

    @SerializedName("audience")
    public AzureActiveDirectoryAudience mAudience;

    @SerializedName("flight_parameters")
    public Map<String, String> mFlightParameters;
    private boolean mMultipleCloudsSupported;

    public AzureActiveDirectoryAuthority(AzureActiveDirectoryAudience azureActiveDirectoryAudience) {
        this.mMultipleCloudsSupported = false;
        this.mAudience = azureActiveDirectoryAudience;
        this.mAuthorityTypeString = "AAD";
    }

    @NonNull
    public static String convertToDefaultAuthority(@NonNull String str) throws ClientException {
        if (str == null) {
            throw new NullPointerException("authorityUrl is marked non-null but is null");
        }
        try {
            CommonURIBuilder commonURIBuilder = new CommonURIBuilder(str);
            commonURIBuilder.setPath("common");
            return commonURIBuilder.toString();
        } catch (URISyntaxException e) {
            throw new ClientException("malformed_url", "Cannot construct common authority URL", e);
        }
    }

    @Nullable
    private static synchronized AzureActiveDirectoryCloud getAzureActiveDirectoryCloud(@NonNull AzureActiveDirectoryAudience azureActiveDirectoryAudience) {
        if (azureActiveDirectoryAudience == null) {
            throw new NullPointerException("audience is marked non-null but is null");
        }
        try {
        } catch (MalformedURLException e) {
            Logger.errorPII(TAG + ":getAzureActiveDirectoryCloud", "AAD cloud URL was malformed.", e);
            return null;
        }
        return AzureActiveDirectory.getAzureActiveDirectoryCloud(new URL(azureActiveDirectoryAudience.getCloudUrl()));
    }

    public MicrosoftStsOAuth2Configuration createOAuth2Configuration() {
        StringBuilder sb = new StringBuilder();
        String str = TAG;
        sb.append(str);
        sb.append(":createOAuth2Configuration");
        Logger.verbose(sb.toString(), "Creating OAuth2Configuration");
        MicrosoftStsOAuth2Configuration microsoftStsOAuth2Configuration = new MicrosoftStsOAuth2Configuration();
        microsoftStsOAuth2Configuration.setAuthorityUrl(getAuthorityURL());
        if (this.mSlice != null) {
            Logger.info(str + ":createOAuth2Configuration", "Setting slice parameters...");
            AzureActiveDirectorySlice azureActiveDirectorySlice = new AzureActiveDirectorySlice();
            azureActiveDirectorySlice.setSlice(this.mSlice.getSlice());
            azureActiveDirectorySlice.setDataCenter(this.mSlice.getDataCenter());
            microsoftStsOAuth2Configuration.setSlice(azureActiveDirectorySlice);
        }
        if (this.mFlightParameters != null) {
            Logger.info(str + ":createOAuth2Configuration", "Setting flight parameters...");
            for (Map.Entry<String, String> entry : this.mFlightParameters.entrySet()) {
                microsoftStsOAuth2Configuration.getFlightParameters().put(entry.getKey(), entry.getValue());
            }
        }
        microsoftStsOAuth2Configuration.setMultipleCloudsSupported(this.mMultipleCloudsSupported);
        return microsoftStsOAuth2Configuration;
    }

    @Override // com.microsoft.identity.common.java.authorities.Authority
    public OAuth2Strategy createOAuth2Strategy(@NonNull OAuth2StrategyParameters oAuth2StrategyParameters) {
        if (oAuth2StrategyParameters != null) {
            return new MicrosoftStsOAuth2Strategy(createOAuth2Configuration(), oAuth2StrategyParameters);
        }
        throw new NullPointerException("parameters is marked non-null but is null");
    }

    public AzureActiveDirectoryAudience getAudience() {
        return this.mAudience;
    }

    @Override // com.microsoft.identity.common.java.authorities.Authority
    public URI getAuthorityUri() {
        CommonURIBuilder commonURIBuilder;
        try {
            AzureActiveDirectoryCloud azureActiveDirectoryCloud = getAzureActiveDirectoryCloud(this.mAudience);
            if (azureActiveDirectoryCloud == null) {
                commonURIBuilder = new CommonURIBuilder(this.mAudience.getCloudUrl());
            } else {
                commonURIBuilder = new CommonURIBuilder("https://" + azureActiveDirectoryCloud.getPreferredNetworkHostName());
            }
            if (!StringUtil.isNullOrEmpty(this.mAudience.getTenantId())) {
                ArrayList arrayList = new ArrayList(commonURIBuilder.getPathSegments());
                arrayList.add(this.mAudience.getTenantId());
                commonURIBuilder.setPathSegments(arrayList);
            }
            return commonURIBuilder.build();
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException("Authority URI is invalid.", e);
        }
    }

    public boolean isMultipleCloudsSupported() {
        return this.mMultipleCloudsSupported;
    }

    public synchronized boolean isSameCloudAsAuthority(@NonNull AzureActiveDirectoryAuthority azureActiveDirectoryAuthority) {
        try {
            if (azureActiveDirectoryAuthority == null) {
                throw new NullPointerException("authorityToCheck is marked non-null but is null");
            }
            if (!AzureActiveDirectory.isInitialized()) {
                AzureActiveDirectory.performCloudDiscovery();
            }
            AzureActiveDirectoryCloud azureActiveDirectoryCloud = getAzureActiveDirectoryCloud(this.mAudience);
            AzureActiveDirectoryCloud azureActiveDirectoryCloud2 = getAzureActiveDirectoryCloud(azureActiveDirectoryAuthority.getAudience());
            if (azureActiveDirectoryCloud == null && azureActiveDirectoryCloud2 == null) {
                return false;
            }
            if (azureActiveDirectoryCloud != null && azureActiveDirectoryCloud2 != null) {
                SpanExtension.current().setAttribute(AttributeName.home_cloud_name.name(), azureActiveDirectoryCloud2.getPreferredCacheHostName());
                SpanExtension.current().setAttribute(AttributeName.requested_cloud_name.name(), azureActiveDirectoryCloud.getPreferredCacheHostName());
            }
            return Objects.equals(azureActiveDirectoryCloud, azureActiveDirectoryCloud2);
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setMultipleCloudsSupported(boolean z) {
        this.mMultipleCloudsSupported = z;
    }

    public AzureActiveDirectoryAuthority() {
        this.mMultipleCloudsSupported = false;
        this.mAudience = new AllAccounts();
        this.mAuthorityTypeString = "AAD";
        this.mMultipleCloudsSupported = false;
    }
}
