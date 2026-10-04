package com.microsoft.identity.client;

import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.AzureActiveDirectoryEnvironment;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public enum AzureCloudInstance {
    AzurePublic(AzureActiveDirectoryEnvironment.PRODUCTION_CLOUD_URL),
    AzureChina("https://login.partner.microsoftonline.cn"),
    AzureGermany("https://login.microsoftonline.de"),
    AzureUsGov("https://login.microsoftonline.us");

    private String cloudInstanceUri;

    AzureCloudInstance(String str) {
        this.cloudInstanceUri = str;
    }

    public String getCloudInstanceUri() {
        return this.cloudInstanceUri;
    }
}
