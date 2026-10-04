package com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory;

import com.microsoft.identity.common.java.providers.microsoft.MicrosoftTokenResponse;
import com.microsoft.identity.common.java.util.CopyUtil;
import java.util.Date;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class AzureActiveDirectoryTokenResponse extends MicrosoftTokenResponse {
    private Date mExpiresOn;
    private String mNotBefore;
    private String mResource;
    private String mSpeRing;

    public Date getExpiresOn() {
        return CopyUtil.copyIfNotNull(this.mExpiresOn);
    }

    public String getNotBefore() {
        return this.mNotBefore;
    }

    public String getResource() {
        return this.mResource;
    }

    @Override // com.microsoft.identity.common.java.providers.microsoft.MicrosoftTokenResponse
    public String getSpeRing() {
        return this.mSpeRing;
    }

    public void setExpiresOn(Date date) {
        this.mExpiresOn = CopyUtil.copyIfNotNull(date);
    }

    public void setNotBefore(String str) {
        this.mNotBefore = str;
    }

    public void setResource(String str) {
        this.mResource = str;
    }

    @Override // com.microsoft.identity.common.java.providers.microsoft.MicrosoftTokenResponse
    public void setSpeRing(String str) {
        this.mSpeRing = str;
    }

    @Override // com.microsoft.identity.common.java.providers.microsoft.MicrosoftTokenResponse, com.microsoft.identity.common.java.providers.oauth2.TokenResponse
    public String toString() {
        return "AzureActiveDirectoryTokenResponse{mExpiresOn=" + this.mExpiresOn + ", mResource='" + this.mResource + "', mNotBefore='" + this.mNotBefore + "', mSpeRing='" + this.mSpeRing + "'} " + super.toString();
    }
}
