package com.samsung.android.sdk.mobileservice.auth;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class AuthInfo {
    private boolean mAccountDisclaimerAgreed;
    private String mAccountId;
    private String mCountryCode;
    private String mDevicePhysicalAddress;
    private boolean mEmailAddressAuthenticated;
    private String mGuid;
    private String mMobileCountryCode;
    private boolean mRealNameAuthenticated;

    public boolean getAccountDisclaimerAgreed() {
        return this.mAccountDisclaimerAgreed;
    }

    public String getAccountId() {
        return this.mAccountId;
    }

    public String getCountryCode() {
        return this.mCountryCode;
    }

    public String getDevicePhysicalAddress() {
        return this.mDevicePhysicalAddress;
    }

    public boolean getEmailAddressAuthenticated() {
        return this.mEmailAddressAuthenticated;
    }

    public String getGuid() {
        return this.mGuid;
    }

    public String getMobileCountryCode() {
        return this.mMobileCountryCode;
    }

    public boolean getRealNameAuthenticated() {
        return this.mRealNameAuthenticated;
    }

    public void setAccountDisclaimerAgreed(boolean z) {
        this.mAccountDisclaimerAgreed = z;
    }

    public void setAccountId(String str) {
        this.mAccountId = str;
    }

    public void setCountryCode(String str) {
        this.mCountryCode = str;
    }

    public void setDevicePhysicalAddress(String str) {
        this.mDevicePhysicalAddress = str;
    }

    public void setEmailAddressAuthenticated(boolean z) {
        this.mEmailAddressAuthenticated = z;
    }

    public void setGuid(String str) {
        this.mGuid = str;
    }

    public void setMobileCountryCode(String str) {
        this.mMobileCountryCode = str;
    }

    public void setRealNameAuthenticated(boolean z) {
        this.mRealNameAuthenticated = z;
    }
}
