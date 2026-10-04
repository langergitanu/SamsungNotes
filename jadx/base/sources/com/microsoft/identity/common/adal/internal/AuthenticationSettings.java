package com.microsoft.identity.common.adal.internal;

import androidx.annotation.VisibleForTesting;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.microsoft.identity.common.adal.internal.util.StringExtensions;
import com.microsoft.identity.common.java.constants.SpotbugsWarning;
import com.microsoft.identity.common.logging.Logger;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public enum AuthenticationSettings {
    INSTANCE;

    private static final int DEFAULT_EXPIRATION_BUFFER = 300;
    private static final int DEFAULT_READ_CONNECT_TIMEOUT = 30000;
    private static final int SECRET_RAW_KEY_LENGTH = 32;
    private static final String TAG = "AuthenticationSettings";
    private String mActivityPackageName;
    private String mSharedPrefPackageName;
    private final Map<String, byte[]> mBrokerSecretKeys = new HashMap(2);
    private AtomicReference<byte[]> mSecretKeyData = new AtomicReference<>();
    private String mBrokerPackageName = AuthenticationConstants.Broker.COMPANY_PORTAL_APP_PACKAGE_NAME;
    private String mBrokerSignature = AuthenticationConstants.Broker.COMPANY_PORTAL_APP_RELEASE_SIGNATURE_SHA512;
    private boolean mEnableHardwareAcceleration = true;
    private boolean mUseBroker = false;
    private int mExpirationBuffer = 300;
    private int mConnectTimeOut = 30000;
    private int mReadTimeOut = 30000;
    private boolean mIgnoreKeyLoaderNotFoundError = false;

    AuthenticationSettings() {
    }

    public void clearBrokerSecretKeys() {
        this.mBrokerSecretKeys.clear();
    }

    public void clearLegacySecretKeyConfiguration() {
        Logger.info(TAG + ":clearLegacySecretKeyConfiguration", "Clearing legacy secret key configuration.");
        this.mBrokerSecretKeys.clear();
        this.mSecretKeyData.set(null);
    }

    @VisibleForTesting(otherwise = 5)
    public void clearSecretKeysForTestCases() {
        clearLegacySecretKeyConfiguration();
    }

    public String getActivityPackageName() {
        return this.mActivityPackageName;
    }

    public String getBrokerPackageName() {
        return this.mBrokerPackageName;
    }

    public Map<String, byte[]> getBrokerSecretKeys() {
        return Collections.unmodifiableMap(this.mBrokerSecretKeys);
    }

    public String getBrokerSignature() {
        return this.mBrokerSignature;
    }

    public int getConnectTimeOut() {
        return this.mConnectTimeOut;
    }

    public boolean getDisableWebViewHardwareAcceleration() {
        return this.mEnableHardwareAcceleration;
    }

    public int getExpirationBuffer() {
        return this.mExpirationBuffer;
    }

    public int getReadTimeOut() {
        return this.mReadTimeOut;
    }

    public byte[] getSecretKeyData() {
        return this.mSecretKeyData.get();
    }

    public String getSharedPrefPackageName() {
        return this.mSharedPrefPackageName;
    }

    @Deprecated
    public boolean getSkipBroker() {
        return !this.mUseBroker;
    }

    public boolean getUseBroker() {
        return this.mUseBroker;
    }

    public void setActivityPackageName(String str) {
        if (StringExtensions.isNullOrBlank(str)) {
            throw new IllegalArgumentException("activityPackageName cannot be empty or null");
        }
        this.mActivityPackageName = str;
    }

    public void setBrokerPackageName(String str) {
        if (StringExtensions.isNullOrBlank(str)) {
            throw new IllegalArgumentException("packageName cannot be empty or null");
        }
        this.mBrokerPackageName = str;
    }

    public void setBrokerSecretKeys(Map<String, byte[]> map) {
        if (map == null) {
            throw new IllegalArgumentException("The passed in secret key map is null.");
        }
        if (map.size() != 2) {
            throw new IllegalArgumentException("Expect two keys are passed in.");
        }
        for (Map.Entry<String, byte[]> entry : map.entrySet()) {
            if (entry.getValue() == null || entry.getValue().length != 32) {
                throw new IllegalArgumentException("Passed in raw key is null or length is not as expected. ");
            }
            this.mBrokerSecretKeys.put(entry.getKey(), entry.getValue());
        }
    }

    public void setBrokerSignature(String str) {
        if (StringExtensions.isNullOrBlank(str)) {
            throw new IllegalArgumentException("brokerSignature cannot be empty or null");
        }
        this.mBrokerSignature = str;
    }

    public void setConnectTimeOut(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Invalid timeOutMillis");
        }
        this.mConnectTimeOut = i;
    }

    @SuppressFBWarnings({SpotbugsWarning.ME_ENUM_FIELD_SETTER})
    public void setDisableWebViewHardwareAcceleration(boolean z) {
        this.mEnableHardwareAcceleration = z;
    }

    @SuppressFBWarnings({SpotbugsWarning.ME_ENUM_FIELD_SETTER})
    public void setExpirationBuffer(int i) {
        this.mExpirationBuffer = i;
    }

    @SuppressFBWarnings({SpotbugsWarning.ME_ENUM_FIELD_SETTER})
    public void setIgnoreKeyLoaderNotFoundError(boolean z) {
        this.mIgnoreKeyLoaderNotFoundError = z;
    }

    public void setReadTimeOut(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Invalid timeOutMillis");
        }
        this.mReadTimeOut = i;
    }

    public void setSecretKey(byte[] bArr) {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":setSecretKey", new StringBuilder());
        if (bArr == null || bArr.length != 32) {
            throw new IllegalArgumentException("rawKey");
        }
        Logger.warn(strM1170p, "You're using setSecretKey in a version of android that supports keyStore functionality.  Consider not doing this, as it only exists for devices with an SDK lower than 18");
        this.mSecretKeyData.set(bArr);
    }

    @SuppressFBWarnings({SpotbugsWarning.ME_ENUM_FIELD_SETTER})
    public void setSharedPrefPackageName(String str) {
        this.mSharedPrefPackageName = str;
    }

    @Deprecated
    public void setSkipBroker(boolean z) {
        this.mUseBroker = !z;
    }

    @SuppressFBWarnings({SpotbugsWarning.ME_ENUM_FIELD_SETTER})
    public void setUseBroker(boolean z) {
        this.mUseBroker = z;
    }

    public boolean shouldIgnoreKeyLoaderNotFoundError() {
        return this.mIgnoreKeyLoaderNotFoundError;
    }
}
