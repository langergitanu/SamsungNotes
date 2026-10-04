package com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory;

import com.microsoft.identity.common.java.providers.oauth2.OAuth2Configuration;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class AzureActiveDirectoryOAuth2Configuration extends OAuth2Configuration {
    private URL mAuthorityUrl;
    private boolean mMultipleCloudsSupported;
    private AzureActiveDirectorySlice mSlice;
    private boolean mAuthorityHostValidationEnabled = true;
    private Map<String, String> mFlightParameters = new HashMap();

    public URL getAuthorityUrl() {
        return this.mAuthorityUrl;
    }

    public Map<String, String> getFlightParameters() {
        return this.mFlightParameters;
    }

    public boolean getMultipleCloudsSupported() {
        return this.mMultipleCloudsSupported;
    }

    public AzureActiveDirectorySlice getSlice() {
        return this.mSlice;
    }

    public boolean isAuthorityHostValidationEnabled() {
        return this.mAuthorityHostValidationEnabled;
    }

    public void setAuthorityHostValidationEnabled(boolean z) {
        this.mAuthorityHostValidationEnabled = z;
    }

    public void setAuthorityUrl(URL url) {
        this.mAuthorityUrl = url;
    }

    public void setFlightParameters(Map<String, String> map) {
        this.mFlightParameters = map;
    }

    public void setMultipleCloudsSupported(boolean z) {
        this.mMultipleCloudsSupported = z;
    }

    public void setSlice(AzureActiveDirectorySlice azureActiveDirectorySlice) {
        this.mSlice = azureActiveDirectorySlice;
    }
}
