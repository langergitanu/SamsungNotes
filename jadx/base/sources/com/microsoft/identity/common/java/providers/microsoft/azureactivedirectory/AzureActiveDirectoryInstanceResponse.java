package com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory;

import com.google.gson.annotations.SerializedName;
import com.samsung.android.sdk.mobileservice.social.group.provider.GroupContract;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class AzureActiveDirectoryInstanceResponse {

    @SerializedName("api-version")
    private String mApiVersion;

    @SerializedName(GroupContract.Group.META_DATA)
    private ArrayList<AzureActiveDirectoryCloud> mClouds;

    @SerializedName("tenant_discovery_endpoint")
    private String mTestDiscoveryEndpoint;

    public String getApiVersion() {
        return this.mApiVersion;
    }

    public ArrayList<AzureActiveDirectoryCloud> getClouds() {
        return this.mClouds;
    }

    public String getTestDiscoveryEndpoint() {
        return this.mTestDiscoveryEndpoint;
    }
}
