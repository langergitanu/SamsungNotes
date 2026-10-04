package com.microsoft.identity.common.java.providers.microsoft;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.java.commands.parameters.IHasExtraParameters;
import com.microsoft.identity.common.java.providers.oauth2.TokenRequest;
import edu.umd.cs.findbugs.annotations.Nullable;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class MicrosoftTokenRequest extends TokenRequest implements IHasExtraParameters {
    public static final String CLAIMS = "claims";
    public static final String CLIENT_APP_NAME = "x-app-name";
    public static final String CLIENT_APP_VERSION = "x-app-ver";
    public static final String CLIENT_INFO = "client_info";
    public static final String CODE_VERIFIER = "code_verifier";
    public static final String CORRELATION_ID = "client-request-id";
    public static final String DEVICE_CODE = "device_code";
    public static final String ID_TOKEN_VERSION = "itver";
    public static final String INSTANCE_AWARE = "instance_aware";
    public static final String MAM_VERSION = "mamver";
    public static final String MICROSOFT_ENROLLMENT_ID = "microsoft_enrollment_id";
    private transient String mBrokerVersion;

    @SerializedName("claims")
    @Expose
    private String mClaims;

    @SerializedName("x-app-name")
    @Expose
    private String mClientAppName;

    @SerializedName("x-app-ver")
    @Expose
    private String mClientAppVersion;

    @SerializedName("client_info")
    @Expose
    private String mClientInfoEnabled = "1";

    @SerializedName(CODE_VERIFIER)
    private String mCodeVerifier;

    @SerializedName("client-request-id")
    @Expose
    private UUID mCorrelationId;

    @SerializedName("device_code")
    @Expose
    private String mDeviceCode;

    @SerializedName("itver")
    @Expose
    private String mIdTokenVersion;

    @SerializedName("instance_aware")
    @Expose
    private String mInstanceAware;

    @SerializedName(MAM_VERSION)
    @Expose
    private String mMamVersion;

    @SerializedName(MICROSOFT_ENROLLMENT_ID)
    @Expose
    private String mMicrosoftEnrollmentId;
    private boolean mPKeyAuthHeaderAllowed;
    private String mTokenScope;

    public String getBrokerVersion() {
        return this.mBrokerVersion;
    }

    public String getClaims() {
        return this.mClaims;
    }

    public String getClientAppName() {
        return this.mClientAppName;
    }

    public String getClientAppVersion() {
        return this.mClientAppVersion;
    }

    public String getClientInfoEnabled() {
        return this.mClientInfoEnabled;
    }

    public String getCodeVerifier() {
        return this.mCodeVerifier;
    }

    public UUID getCorrelationId() {
        return this.mCorrelationId;
    }

    @Nullable
    public String getDeviceCode() {
        return this.mDeviceCode;
    }

    public String getIdTokenVersion() {
        return this.mIdTokenVersion;
    }

    public String getInstanceAware() {
        return this.mInstanceAware;
    }

    public String getMamVersion() {
        return this.mMamVersion;
    }

    public String getMicrosoftEnrollmentId() {
        return this.mMicrosoftEnrollmentId;
    }

    public String getTokenScope() {
        return this.mTokenScope;
    }

    public boolean isPKeyAuthHeaderAllowed() {
        return this.mPKeyAuthHeaderAllowed;
    }

    public void setBrokerVersion(String str) {
        this.mBrokerVersion = str;
    }

    public void setClaims(String str) {
        this.mClaims = str;
    }

    public void setClientAppName(String str) {
        this.mClientAppName = str;
    }

    public void setClientAppVersion(String str) {
        this.mClientAppVersion = str;
    }

    public void setCodeVerifier(String str) {
        this.mCodeVerifier = str;
    }

    public void setCorrelationId(UUID uuid) {
        this.mCorrelationId = uuid;
    }

    public void setDeviceCode(String str) {
        this.mDeviceCode = str;
    }

    public void setIdTokenVersion(String str) {
        this.mIdTokenVersion = str;
    }

    public void setInstanceAware(String str) {
        this.mInstanceAware = str;
    }

    public void setMamversion(String str) {
        this.mMamVersion = str;
    }

    public void setMicrosoftEnrollmentId(String str) {
        this.mMicrosoftEnrollmentId = str;
    }

    public void setPKeyAuthHeaderAllowed(boolean z) {
        this.mPKeyAuthHeaderAllowed = z;
    }

    public void setTokenScope(String str) {
        this.mTokenScope = str;
    }
}
