package com.samsung.android.sdk.mobileservice.auth;

import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import com.microsoft.identity.common.internal.providers.oauth2.ResponseType;
import com.samsung.android.sdk.mobileservice.SeMobileService;
import com.samsung.android.sdk.mobileservice.SeMobileServiceSession;
import com.samsung.android.sdk.mobileservice.auth.IAccessTokenResultCallback;
import com.samsung.android.sdk.mobileservice.auth.IAuthCodeResultCallback;
import com.samsung.android.sdk.mobileservice.auth.IAuthResultCallback;
import com.samsung.android.sdk.mobileservice.auth.IDisclaimerAgreementForThirdPartyResultCallback;
import com.samsung.android.sdk.mobileservice.auth.IValidationResultCallback;
import com.samsung.android.sdk.mobileservice.auth.result.AccessTokenInfoResult;
import com.samsung.android.sdk.mobileservice.auth.result.AuthInfoResult;
import com.samsung.android.sdk.mobileservice.auth.result.DeviceAuthInfoResult;
import com.samsung.android.sdk.mobileservice.auth.result.ResultTokenInfo;
import com.samsung.android.sdk.mobileservice.common.CommonConstants;
import com.samsung.android.sdk.mobileservice.common.CommonUtils;
import com.samsung.android.sdk.mobileservice.common.ErrorCodeConvertor;
import com.samsung.android.sdk.mobileservice.common.api.SeMobileServiceApi;
import com.samsung.android.sdk.mobileservice.common.exception.NotConnectedException;
import com.samsung.android.sdk.mobileservice.common.result.BooleanResult;
import com.samsung.android.sdk.mobileservice.common.result.CommonResultStatus;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class AuthApi extends SeMobileServiceApi {
    public static final String API_NAME = "AuthApi";
    public static final int SERVICE_ID_GALLERY_CONTENT_SHARING = 32;
    public static final int SERVICE_ID_PROFILE_SHARING = 0;
    public static final String SERVICE_NAME = "AuthService";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface AccessTokenResultCallback {
        void onResult(AccessTokenInfoResult accessTokenInfoResult);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface AuthCodeResultCallback {
        void onResult(ResultTokenInfo resultTokenInfo);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface AuthResultCallback {
        void onResult(AuthInfoResult authInfoResult);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface BundleKey {
        public static final String AGREEMENT_PROCEDURE = "AgreementProcedure";
        public static final String ENFORCE_FTU = "enforceFtu";
        public static final String IS_LEGAL_POPUP_SUPPORTED = "isLegalPopupSupported";
        public static final String IS_NEEDED = "isNeeded";
        public static final String LEGACY_LEGAL_POPUP = "LegacyLegalPopup";
        public static final String SOCIAL_ABOUT_PAGE = "SocialAboutPage";
        public static final String SOCIAL_DISCLAIMER = "SocialDisclaimer";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface DisclaimerAgreementResultCallback {
        void onResult(BooleanResult booleanResult);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ValidationResultCallback {
        void onResult(BooleanResult booleanResult, boolean z, boolean z2, boolean z3, boolean z4);
    }

    public AuthApi(SeMobileServiceSession seMobileServiceSession) {
        super(seMobileServiceSession, "AuthApi");
    }

    private Intent getIntentToDisplay(String str) {
        return getIntentToDisplay(str, new Bundle());
    }

    private boolean isAppIdNullOrEmpty() {
        if (!TextUtils.isEmpty(getAppId())) {
            return false;
        }
        debugLog("appId is null or empty");
        return true;
    }

    private boolean isAvailableSocialService() {
        try {
            if (this.mSessionInstance.isAgentInstalled() && this.mSessionInstance.isAgentEnabled() && getSocialService() != null) {
                return true;
            }
            debugLog("isAvailableSocialService is false - AgentInstalled : " + this.mSessionInstance.isAgentInstalled() + " AgentEnabled : " + this.mSessionInstance.isAgentEnabled());
            return false;
        } catch (Exception unused) {
            debugLog("isAvailableSocialService is exception - AgentInstalled : " + this.mSessionInstance.isAgentInstalled() + " AgentEnabled : " + this.mSessionInstance.isAgentEnabled());
            return false;
        }
    }

    private Bundle isSomethingNeeded(String str) {
        if (!isAvailableSocialService()) {
            return null;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putString("what", str);
            return getSocialService().isSomethingNeeded(bundle);
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return null;
        } catch (NotConnectedException e2) {
            e = e2;
            secureLog(e);
            return null;
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return null;
        } catch (OutOfMemoryError unused) {
            verboseLog("OutOfMemoryError occurred");
            return null;
        }
    }

    public BooleanResult getAccountValidation() {
        if (isAppIdNullOrEmpty()) {
            return new BooleanResult(new CommonResultStatus(-1), false);
        }
        try {
            boolean accountValidation = getAuthService().getAccountValidation();
            debugLog("isAccountValid " + accountValidation + " ");
            return new BooleanResult(new CommonResultStatus(1), accountValidation);
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return new BooleanResult(new CommonResultStatus(-1), false);
        } catch (NotConnectedException e2) {
            e = e2;
            secureLog(e);
            return new BooleanResult(new CommonResultStatus(-1), false);
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return new BooleanResult(new CommonResultStatus(-1), false);
        } catch (OutOfMemoryError unused) {
            verboseLog("OutOfMemoryError occurred");
            return new BooleanResult(new CommonResultStatus(-1), false);
        }
    }

    public AuthInfoResult getAuthInfo() {
        AuthInfo authInfo;
        debugLog("getAuthInfo ");
        if (isAppIdNullOrEmpty()) {
            return new AuthInfoResult(new CommonResultStatus(-1, "appId is null or empty", ""), null);
        }
        try {
            if (getAuthService() == null) {
                debugLog("auth service is null ");
                return new AuthInfoResult(new CommonResultStatus(-1), null);
            }
            Bundle authInfoCached = getAuthService().getAuthInfoCached();
            if (authInfoCached != null) {
                if (authInfoCached.containsKey("account_id")) {
                    authInfo = new AuthInfo();
                    authInfo.setAccountId(authInfoCached.getString("account_id"));
                } else {
                    authInfo = null;
                }
                if (authInfoCached.containsKey("guid")) {
                    if (authInfo == null) {
                        authInfo = new AuthInfo();
                    }
                    authInfo.setGuid(authInfoCached.getString("guid"));
                }
                if (authInfoCached.containsKey("country_code")) {
                    if (authInfo == null) {
                        authInfo = new AuthInfo();
                    }
                    authInfo.setCountryCode(authInfoCached.getString("country_code"));
                }
                if (authInfoCached.containsKey("mcc")) {
                    if (authInfo == null) {
                        authInfo = new AuthInfo();
                    }
                    authInfo.setMobileCountryCode(authInfoCached.getString("mcc"));
                }
                if (authInfoCached.containsKey("device_physical_address")) {
                    if (authInfo == null) {
                        authInfo = new AuthInfo();
                    }
                    authInfo.setDevicePhysicalAddress(authInfoCached.getString("device_physical_address"));
                }
                if (authInfoCached.containsKey("is_email_authenticated")) {
                    if (authInfo == null) {
                        authInfo = new AuthInfo();
                    }
                    authInfo.setEmailAddressAuthenticated(authInfoCached.getBoolean("is_email_authenticated"));
                }
                if (authInfoCached.containsKey("is_name_authenticated")) {
                    if (authInfo == null) {
                        authInfo = new AuthInfo();
                    }
                    authInfo.setRealNameAuthenticated(authInfoCached.getBoolean("is_name_authenticated"));
                }
                if (authInfoCached.containsKey("is_account_disclaimer_agreed")) {
                    if (authInfo == null) {
                        authInfo = new AuthInfo();
                    }
                    authInfo.setAccountDisclaimerAgreed(authInfoCached.getBoolean("is_account_disclaimer_agreed"));
                }
            } else {
                authInfo = null;
            }
            if (authInfo != null) {
                return new AuthInfoResult(new CommonResultStatus(1), authInfo);
            }
            debugLog("getAuthInfo is null");
            return new AuthInfoResult(new CommonResultStatus(1), null);
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return new AuthInfoResult(new CommonResultStatus(-1), null);
        } catch (NotConnectedException e2) {
            e = e2;
            secureLog(e);
            return new AuthInfoResult(new CommonResultStatus(-1), null);
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return new AuthInfoResult(new CommonResultStatus(-1), null);
        } catch (OutOfMemoryError unused) {
            verboseLog("OutOfMemoryError occurred");
            return new AuthInfoResult(new CommonResultStatus(-1), null);
        }
    }

    @Deprecated
    public DeviceAuthInfoResult getDeviceAuthInfo() {
        Bundle deviceAuthInfoCached;
        DeviceAuthInfo deviceAuthInfo;
        debugLog("getDeviceAuthInfo ");
        if (isAppIdNullOrEmpty()) {
            return new DeviceAuthInfoResult(new CommonResultStatus(-1, "appId is null or empty", ""), null);
        }
        try {
            if (CommonUtils.isStandAloneSamsungAccountSupported(getContext())) {
                deviceAuthInfoCached = isAvailableSocialService() ? getSocialService().getDeviceAuthInfoCached() : null;
            } else {
                if (getAuthService() == null) {
                    debugLog("auth service is null ");
                    return new DeviceAuthInfoResult(new CommonResultStatus(-1), null);
                }
                deviceAuthInfoCached = getAuthService().getDeviceAuthInfoCached();
            }
            if (deviceAuthInfoCached != null) {
                if (deviceAuthInfoCached.containsKey("imsi")) {
                    deviceAuthInfo = new DeviceAuthInfo();
                    deviceAuthInfo.setImsi(deviceAuthInfoCached.getString("imsi"));
                } else {
                    deviceAuthInfo = null;
                }
                if (deviceAuthInfoCached.containsKey("msisdn")) {
                    if (deviceAuthInfo == null) {
                        deviceAuthInfo = new DeviceAuthInfo();
                    }
                    deviceAuthInfo.setMsisdn(deviceAuthInfoCached.getString("msisdn"));
                }
            } else {
                deviceAuthInfo = null;
            }
            if (deviceAuthInfo != null) {
                return new DeviceAuthInfoResult(new CommonResultStatus(1), deviceAuthInfo);
            }
            debugLog("getDeviceAuthInfo is null");
            return new DeviceAuthInfoResult(new CommonResultStatus(1), null);
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return new DeviceAuthInfoResult(new CommonResultStatus(-1), null);
        } catch (NotConnectedException e2) {
            e = e2;
            secureLog(e);
            return new DeviceAuthInfoResult(new CommonResultStatus(-1), null);
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return new DeviceAuthInfoResult(new CommonResultStatus(-1), null);
        } catch (OutOfMemoryError unused) {
            verboseLog("OutOfMemoryError occurred");
            return new DeviceAuthInfoResult(new CommonResultStatus(-1), null);
        }
    }

    @Deprecated
    public BooleanResult getDisclaimerAgreementForSocial() {
        boolean disclaimerAgreementForSocial;
        boolean z = false;
        if (isAppIdNullOrEmpty()) {
            return new BooleanResult(new CommonResultStatus(-1), false);
        }
        try {
            if (CommonUtils.isStandAloneSamsungAccountSupported(getContext())) {
                if (isAvailableSocialService()) {
                    disclaimerAgreementForSocial = getSocialService().getDisclaimerAgreementForSocial();
                }
                debugLog("getDisclaimerAgreementForSocial " + z + " ");
                return new BooleanResult(new CommonResultStatus(1), z);
            }
            disclaimerAgreementForSocial = getAuthService().getDisclaimerAgreementForSocial();
            z = disclaimerAgreementForSocial;
            debugLog("getDisclaimerAgreementForSocial " + z + " ");
            return new BooleanResult(new CommonResultStatus(1), z);
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return new BooleanResult(new CommonResultStatus(-1), false);
        } catch (NotConnectedException e2) {
            e = e2;
            secureLog(e);
            return new BooleanResult(new CommonResultStatus(-1), false);
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return new BooleanResult(new CommonResultStatus(-1), false);
        } catch (OutOfMemoryError unused) {
            verboseLog("OutOfMemoryError occurred");
            return new BooleanResult(new CommonResultStatus(-1), false);
        }
    }

    @Override // com.samsung.android.sdk.mobileservice.common.api.SeMobileServiceApi
    public String[] getEssentialServiceNames() {
        return (CommonUtils.isStandAloneSamsungAccountSupported(getContext()) && this.mSessionInstance.isAgentInstalled() && this.mSessionInstance.isAgentEnabled()) ? new String[]{"AuthService", "SocialService"} : new String[]{"AuthService"};
    }

    public Intent getIntentForAccountAccessTokenRequest(String str) {
        debugLog("getIntentForAccountDisclaimerAgreement : accountAppId=[" + getAppId() + "], expiredToken=[" + str + "] ");
        if (isAppIdNullOrEmpty()) {
            return null;
        }
        return getIntentForAccountAccessTokenRequest(getAppId(), str);
    }

    public Intent getIntentForAccountDisclaimerAgreement(boolean z) {
        debugLog("getIntentForAccountDisclaimerAgreement : accountAppId=[" + getAppId() + "], forThirdParty=[" + z + "] ");
        if (isAppIdNullOrEmpty()) {
            return null;
        }
        return getIntentForAccountDisclaimerAgreement(getAppId(), z);
    }

    public Intent getIntentForAccountPasswordConfirmation() {
        debugLog("getIntentForAccountPasswordConfirmation : accountAppId=[" + getAppId() + "] ");
        if (isAppIdNullOrEmpty()) {
            return null;
        }
        return getIntentForAccountPasswordConfirmation(getAppId());
    }

    public Intent getIntentForAccountPasswordConfirmationPopup() {
        debugLog("getIntentForAccountPasswordConfirmationPopup : accountAppId=[" + getAppId() + "] ");
        if (isAppIdNullOrEmpty()) {
            return null;
        }
        return getIntentForAccountPasswordConfirmationPopup(getAppId());
    }

    public Intent getIntentForAccountProfileModification() {
        debugLog("getIntentForAccountProfileModification : accountAppId=[" + getAppId() + "] ");
        if (isAppIdNullOrEmpty()) {
            return null;
        }
        return getIntentForAccountProfileModification(getAppId());
    }

    public Intent getIntentForAccountSetupWizard(boolean z) {
        debugLog("getIntentForAccountSetupWizard : isReactivationLockSupported=[" + z + "]");
        if (isAppIdNullOrEmpty()) {
            return null;
        }
        try {
            return getAuthService().getIntentForAccountSetupWizard(z);
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return null;
        } catch (NotConnectedException e2) {
            e = e2;
            secureLog(e);
            return null;
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return null;
        } catch (OutOfMemoryError unused) {
            verboseLog("OutOfMemoryError occurred");
            return null;
        }
    }

    public Intent getIntentForAccountSignIn() {
        debugLog("getIntentForAccountSignIn");
        if (isAppIdNullOrEmpty()) {
            return null;
        }
        try {
            return getAuthService().getIntentForAccountSignIn();
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return null;
        } catch (NotConnectedException e2) {
            e = e2;
            secureLog(e);
            return null;
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return null;
        } catch (OutOfMemoryError unused) {
            verboseLog("OutOfMemoryError occurred");
            return null;
        }
    }

    public Intent getIntentForAccountSignInPopup() {
        debugLog("getIntentForAccountSignInPopup ");
        if (isAppIdNullOrEmpty()) {
            return null;
        }
        try {
            return getAuthService().getIntentForAccountSignInPopup();
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return null;
        } catch (NotConnectedException e2) {
            e = e2;
            secureLog(e);
            return null;
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return null;
        } catch (OutOfMemoryError unused) {
            verboseLog("OutOfMemoryError occurred");
            return null;
        }
    }

    public Intent getIntentForAccountValidationRequest(boolean z, boolean z2) {
        debugLog("getIntentForAccountDisclaimerAgreement : accountAppId=[" + getAppId() + "], realNameCheck=[" + z + "], validationResultOnly=[" + z2 + "] ");
        if (isAppIdNullOrEmpty()) {
            return null;
        }
        return getIntentForAccountValidationRequest(getAppId(), z, z2);
    }

    public Intent getIntentForSocialDisclaimerAgreement(boolean z, boolean z2) {
        debugLog("getIntentForSocialDisclaimerAgreement : isServiceOnRequired=[" + z + "], isSyncNowRequired=[" + z2 + "] ");
        if (isAppIdNullOrEmpty()) {
            return null;
        }
        try {
            return CommonUtils.isStandAloneSamsungAccountSupported(getContext()) ? getIntentToDisplay(BundleKey.LEGACY_LEGAL_POPUP) : getAuthService().getIntentForSocialDisclaimerAgreement(z, z2);
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return null;
        } catch (NotConnectedException e2) {
            e = e2;
            secureLog(e);
            return null;
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return null;
        } catch (OutOfMemoryError unused) {
            verboseLog("OutOfMemoryError occurred");
            return null;
        }
    }

    public Intent getIntentForSocialDisclaimerDisplay() {
        debugLog("getIntentForSocialDisclaimerDisplay ");
        if (isAppIdNullOrEmpty() || !isSupportedSaAgentVersion(CommonConstants.SupportedApiMinVersion.VERSION_4_1)) {
            return null;
        }
        try {
            return CommonUtils.isStandAloneSamsungAccountSupported(getContext()) ? getIntentToDisplay("SocialDisclaimer") : getAuthService().getIntentForSocialTnC();
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return null;
        } catch (NotConnectedException e2) {
            e = e2;
            secureLog(e);
            return null;
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return null;
        } catch (OutOfMemoryError unused) {
            verboseLog("OutOfMemoryError occurred");
            return null;
        }
    }

    public Intent getIntentForSocialRegistrationInformation() {
        debugLog("getIntentForSocialRegistrationInformation ");
        if (isAppIdNullOrEmpty()) {
            return null;
        }
        try {
            return CommonUtils.isStandAloneSamsungAccountSupported(getContext()) ? getIntentToDisplay(BundleKey.SOCIAL_ABOUT_PAGE) : getAuthService().getIntentForSocialRegistrationInformation();
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return null;
        } catch (NotConnectedException e2) {
            e = e2;
            secureLog(e);
            return null;
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return null;
        } catch (OutOfMemoryError unused) {
            verboseLog("OutOfMemoryError occurred");
            return null;
        }
    }

    public Intent getIntentForSocialSignUp() {
        debugLog("getIntentForSocialSignUp ");
        if (isAppIdNullOrEmpty()) {
            return null;
        }
        try {
            return CommonUtils.isStandAloneSamsungAccountSupported(getContext()) ? getIntentToDisplay(BundleKey.LEGACY_LEGAL_POPUP) : getAuthService().getIntentForSocialSignUp();
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return null;
        } catch (NotConnectedException e2) {
            e = e2;
            secureLog(e);
            return null;
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return null;
        } catch (OutOfMemoryError unused) {
            verboseLog("OutOfMemoryError occurred");
            return null;
        }
    }

    @Deprecated
    public BooleanResult isServiceRegistered(int i) {
        boolean zIsServiceRegistered;
        boolean z = false;
        if (isAppIdNullOrEmpty()) {
            return new BooleanResult(new CommonResultStatus(-1, "appId is null or empty", ""), false);
        }
        try {
            if (CommonUtils.isStandAloneSamsungAccountSupported(getContext())) {
                Bundle bundle = new Bundle();
                bundle.putInt("serviceId", i);
                zIsServiceRegistered = isAvailableSocialService() ? getSocialService().isServiceRegistered(bundle) : false;
            } else {
                zIsServiceRegistered = getAuthService().isServiceRegistered(i);
            }
            if (SeMobileService.getAgentVersion(getContext()) >= 420000000 || i != 32) {
                z = zIsServiceRegistered;
            } else if (zIsServiceRegistered) {
                if (getDeviceAuthInfo().getResult() != null) {
                    z = true;
                }
            }
            debugLog("isServiceRegistered serviceId=[" + i + "] " + z + " ");
            return new BooleanResult(new CommonResultStatus(1), z);
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return new BooleanResult(new CommonResultStatus(-1), false);
        } catch (NotConnectedException e2) {
            e = e2;
            secureLog(e);
            return new BooleanResult(new CommonResultStatus(-1), false);
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return new BooleanResult(new CommonResultStatus(-1), false);
        } catch (OutOfMemoryError unused) {
            verboseLog("OutOfMemoryError occurred");
            return new BooleanResult(new CommonResultStatus(-1), false);
        }
    }

    public BooleanResult isSocialDisclaimerDisplayNeeded() {
        boolean needToShowSocialTncPopup;
        debugLog("isSocialDisclaimerDisplayNeeded ");
        if (isAppIdNullOrEmpty()) {
            return new BooleanResult(new CommonResultStatus(-1, "appId is null or empty", ""), false);
        }
        if (!isSupportedSaAgentVersion(CommonConstants.SupportedApiMinVersion.VERSION_4_1)) {
            return new BooleanResult(new CommonResultStatus(-1), false);
        }
        try {
            if (CommonUtils.isStandAloneSamsungAccountSupported(getContext())) {
                Bundle bundleIsSomethingNeeded = isSomethingNeeded("SocialDisclaimer");
                needToShowSocialTncPopup = bundleIsSomethingNeeded != null ? bundleIsSomethingNeeded.getBoolean("isNeeded", true) : true;
            } else {
                needToShowSocialTncPopup = getAuthService().getNeedToShowSocialTncPopup();
            }
            return new BooleanResult(new CommonResultStatus(1), needToShowSocialTncPopup);
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return new BooleanResult(new CommonResultStatus(-1), false);
        } catch (NotConnectedException e2) {
            e = e2;
            secureLog(e);
            return new BooleanResult(new CommonResultStatus(-1), false);
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return new BooleanResult(new CommonResultStatus(-1), false);
        } catch (OutOfMemoryError unused) {
            verboseLog("OutOfMemoryError occurred");
            return new BooleanResult(new CommonResultStatus(-1), false);
        }
    }

    public int requestAccessTokenForAccount(final AccessTokenResultCallback accessTokenResultCallback) {
        debugLog("requestAccessTokenForAccount : accountAppId=[" + getAppId() + "] ");
        if (isAppIdNullOrEmpty()) {
            return -1;
        }
        try {
            getAuthService().requestAccessTokenForAccount(getAppId(), getContext().getPackageName(), null, new IAccessTokenResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.auth.AuthApi.2
                @Override // com.samsung.android.sdk.mobileservice.auth.IAccessTokenResultCallback
                public void onFailure(String str, String str2) {
                    AuthApi.this.debugLog(AbstractC0541b.m775q("requestAccessTokenForAccount onFailure : code=[", str, "], message=[", str2, "] "));
                    if (accessTokenResultCallback != null) {
                        int iConvertErrorcode = ErrorCodeConvertor.convertErrorcode(str);
                        AuthApi.this.debugLog("converted error code = " + iConvertErrorcode + " - requestAccessTokenForAccount");
                        accessTokenResultCallback.onResult(new AccessTokenInfoResult(new CommonResultStatus(iConvertErrorcode, str2, str), null));
                    }
                }

                @Override // com.samsung.android.sdk.mobileservice.auth.IAccessTokenResultCallback
                public void onSuccess(Bundle bundle, Bundle bundle2) {
                    TokenInfo tokenInfo;
                    AuthApi.this.debugLog("requestAccessTokenForAccount onSuccess ");
                    if (accessTokenResultCallback != null) {
                        if (bundle != null) {
                            tokenInfo = new TokenInfo();
                            if (bundle.containsKey(ResponseType.TOKEN)) {
                                tokenInfo.setToken(bundle.getString(ResponseType.TOKEN));
                            }
                            if (bundle.containsKey("token_type")) {
                                tokenInfo.setTokenType(bundle.getString("token_type"));
                            }
                            if (bundle.containsKey(AuthConstants.EXTRA_API_SERVER_URL)) {
                                tokenInfo.setApiServerUrl(bundle.getString(AuthConstants.EXTRA_API_SERVER_URL));
                            }
                            if (bundle.containsKey(AuthConstants.EXTRA_AUTH_SERVER_URL)) {
                                tokenInfo.setAuthServerUrl(bundle.getString(AuthConstants.EXTRA_AUTH_SERVER_URL));
                            }
                            if (bundle.containsKey("token_issued_time")) {
                                tokenInfo.setTokenIssuedTime(bundle.getLong("token_issued_time"));
                            }
                            if (bundle.containsKey("token_validity_period")) {
                                tokenInfo.setTokenValidityPeriod(bundle.getLong("token_validity_period"));
                            }
                        } else {
                            tokenInfo = null;
                        }
                        accessTokenResultCallback.onResult(new AccessTokenInfoResult(new CommonResultStatus(1), tokenInfo));
                    }
                }
            });
            return 1;
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return -1;
        } catch (NotConnectedException e2) {
            e = e2;
            secureLog(e);
            return -1;
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return -1;
        } catch (OutOfMemoryError unused) {
            verboseLog("OutOfMemoryError occurred");
            return -1;
        }
    }

    public int requestAccountValidation(final ValidationResultCallback validationResultCallback) {
        debugLog("requestAccountValidation : accountAppId=[" + getAppId() + "] ");
        if (isAppIdNullOrEmpty()) {
            return -1;
        }
        try {
            getAuthService().requestValidation(getAppId(), getContext().getPackageName(), null, new IValidationResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.auth.AuthApi.6
                @Override // com.samsung.android.sdk.mobileservice.auth.IValidationResultCallback
                public void onFailure(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
                    AuthApi.this.debugLog(AbstractC0541b.m775q("requestAccountValidation onFailure : code=[", str, "], message=[", str2, "] "));
                    if (validationResultCallback != null) {
                        int iConvertErrorcode = ErrorCodeConvertor.convertErrorcode(str);
                        AuthApi.this.debugLog("converted error code = " + iConvertErrorcode + " - requestAccountValidation");
                        validationResultCallback.onResult(new BooleanResult(new CommonResultStatus(iConvertErrorcode, str2, str), false), z, z2, z3, z4);
                    }
                }

                @Override // com.samsung.android.sdk.mobileservice.auth.IValidationResultCallback
                public void onSuccess() {
                    AuthApi.this.debugLog("requestAccountValidation : onSuccess ");
                    ValidationResultCallback validationResultCallback2 = validationResultCallback;
                    if (validationResultCallback2 != null) {
                        validationResultCallback2.onResult(new BooleanResult(new CommonResultStatus(1), true), false, false, false, false);
                    }
                }
            });
            return 1;
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return -1;
        } catch (NotConnectedException e2) {
            e = e2;
            secureLog(e);
            return -1;
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return -1;
        } catch (OutOfMemoryError unused) {
            verboseLog("OutOfMemoryError occurred");
            return -1;
        }
    }

    public int requestAuthCodeForAccount(final AuthCodeResultCallback authCodeResultCallback) {
        debugLog("requestAuthCodeForAccount : accountAppId=[" + getAppId() + "] ");
        if (isAppIdNullOrEmpty()) {
            return -1;
        }
        try {
            getAuthService().requestAuthCode(getAppId(), getContext().getPackageName(), null, new IAuthCodeResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.auth.AuthApi.5
                @Override // com.samsung.android.sdk.mobileservice.auth.IAuthCodeResultCallback
                public void onFailure(String str, String str2) {
                    AuthApi.this.debugLog(AbstractC0541b.m775q("requestAuthCodeForAccount onFailure : code=[", str, "], message=[", str2, "] "));
                    if (authCodeResultCallback != null) {
                        int iConvertErrorcode = ErrorCodeConvertor.convertErrorcode(str);
                        AuthApi.this.debugLog("converted error code = " + iConvertErrorcode + " - requestAuthCode");
                        authCodeResultCallback.onResult(new ResultTokenInfo(new CommonResultStatus(iConvertErrorcode, str2, str), null));
                    }
                }

                @Override // com.samsung.android.sdk.mobileservice.auth.IAuthCodeResultCallback
                public void onSuccess(Bundle bundle) {
                    TokenInfo tokenInfo;
                    AuthApi.this.debugLog("requestAuthCodeForAccount onSuccess ");
                    if (authCodeResultCallback != null) {
                        if (bundle != null) {
                            tokenInfo = new TokenInfo();
                            if (bundle.containsKey(ResponseType.TOKEN)) {
                                tokenInfo.setToken(bundle.getString(ResponseType.TOKEN));
                            }
                            if (bundle.containsKey("token_type")) {
                                tokenInfo.setTokenType(bundle.getString("token_type"));
                            }
                            if (bundle.containsKey(AuthConstants.EXTRA_API_SERVER_URL)) {
                                tokenInfo.setApiServerUrl(bundle.getString(AuthConstants.EXTRA_API_SERVER_URL));
                            }
                            if (bundle.containsKey(AuthConstants.EXTRA_AUTH_SERVER_URL)) {
                                tokenInfo.setAuthServerUrl(bundle.getString(AuthConstants.EXTRA_AUTH_SERVER_URL));
                            }
                            if (bundle.containsKey("token_issued_time")) {
                                tokenInfo.setTokenIssuedTime(bundle.getLong("token_issued_time"));
                            }
                            if (bundle.containsKey("token_validity_period")) {
                                tokenInfo.setTokenValidityPeriod(bundle.getLong("token_validity_period"));
                            }
                        } else {
                            tokenInfo = null;
                        }
                        authCodeResultCallback.onResult(new ResultTokenInfo(new CommonResultStatus(1), tokenInfo));
                    }
                }
            });
            return 1;
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return -1;
        } catch (NotConnectedException e2) {
            e = e2;
            secureLog(e);
            return -1;
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return -1;
        } catch (OutOfMemoryError unused) {
            verboseLog("OutOfMemoryError occurred");
            return -1;
        }
    }

    public int requestAuthInfo(final AuthResultCallback authResultCallback) {
        debugLog("requestAuthInfo : accountAppId=[" + getAppId() + "] ");
        if (isAppIdNullOrEmpty()) {
            return -1;
        }
        try {
            getAuthService().requestAuthInfo(getAppId(), getContext().getPackageName(), null, new IAuthResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.auth.AuthApi.1
                @Override // com.samsung.android.sdk.mobileservice.auth.IAuthResultCallback
                public void onFailure(String str, String str2) {
                    AuthApi.this.debugLog(AbstractC0541b.m775q("requestAuthInfo onFailure : code=[", str, "], message=[", str2, "] "));
                    if (authResultCallback != null) {
                        authResultCallback.onResult(new AuthInfoResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(str), str2, str), null));
                    }
                }

                @Override // com.samsung.android.sdk.mobileservice.auth.IAuthResultCallback
                public void onSuccess(Bundle bundle) {
                    AuthApi.this.debugLog("requestAuthInfo onSuccess ");
                    if (authResultCallback != null) {
                        AuthInfo authInfo = null;
                        if (bundle != null) {
                            if (bundle.containsKey("account_id")) {
                                authInfo = new AuthInfo();
                                authInfo.setAccountId(bundle.getString("account_id"));
                            }
                            if (bundle.containsKey("guid")) {
                                if (authInfo == null) {
                                    authInfo = new AuthInfo();
                                }
                                authInfo.setGuid(bundle.getString("guid"));
                            }
                            if (bundle.containsKey("country_code")) {
                                if (authInfo == null) {
                                    authInfo = new AuthInfo();
                                }
                                authInfo.setCountryCode(bundle.getString("country_code"));
                            }
                            if (bundle.containsKey("mcc")) {
                                if (authInfo == null) {
                                    authInfo = new AuthInfo();
                                }
                                authInfo.setMobileCountryCode(bundle.getString("mcc"));
                            }
                            if (bundle.containsKey("device_physical_address")) {
                                if (authInfo == null) {
                                    authInfo = new AuthInfo();
                                }
                                authInfo.setDevicePhysicalAddress(bundle.getString("device_physical_address"));
                            }
                            if (bundle.containsKey("is_email_authenticated")) {
                                if (authInfo == null) {
                                    authInfo = new AuthInfo();
                                }
                                authInfo.setEmailAddressAuthenticated(bundle.getBoolean("is_email_authenticated"));
                            }
                            if (bundle.containsKey("is_name_authenticated")) {
                                if (authInfo == null) {
                                    authInfo = new AuthInfo();
                                }
                                authInfo.setRealNameAuthenticated(bundle.getBoolean("is_name_authenticated"));
                            }
                            if (bundle.containsKey("is_account_disclaimer_agreed")) {
                                if (authInfo == null) {
                                    authInfo = new AuthInfo();
                                }
                                authInfo.setAccountDisclaimerAgreed(bundle.getBoolean("is_account_disclaimer_agreed"));
                            }
                        }
                        authResultCallback.onResult(new AuthInfoResult(new CommonResultStatus(1), authInfo));
                    }
                }
            });
            return 1;
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return -1;
        } catch (NotConnectedException e2) {
            e = e2;
            secureLog(e);
            return -1;
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return -1;
        } catch (OutOfMemoryError unused) {
            verboseLog("OutOfMemoryError occurred");
            return -1;
        }
    }

    public int requestDisclaimerAgreementForThirdParty(final DisclaimerAgreementResultCallback disclaimerAgreementResultCallback) {
        debugLog("requestDisclaimerAgreement : accountAppId=[" + getAppId() + "]");
        if (isAppIdNullOrEmpty()) {
            return -1;
        }
        try {
            getAuthService().requestDisclaimerAgreementForThirdParty(getAppId(), getContext().getPackageName(), null, new IDisclaimerAgreementForThirdPartyResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.auth.AuthApi.4
                @Override // com.samsung.android.sdk.mobileservice.auth.IDisclaimerAgreementForThirdPartyResultCallback
                public void onFailure(String str, String str2) {
                    AuthApi.this.debugLog(AbstractC0541b.m775q("requestDisclaimerAgreementForThirdParty onFailure : code=[", str, "], message=[", str2, "] "));
                    if (disclaimerAgreementResultCallback != null) {
                        int iConvertErrorcode = ErrorCodeConvertor.convertErrorcode(str);
                        AuthApi.this.debugLog("converted error code = " + iConvertErrorcode + " - requestDisclaimerAgreement");
                        disclaimerAgreementResultCallback.onResult(new BooleanResult(new CommonResultStatus(iConvertErrorcode, str2, str), false));
                    }
                }

                @Override // com.samsung.android.sdk.mobileservice.auth.IDisclaimerAgreementForThirdPartyResultCallback
                public void onSuccess(boolean z) {
                    AuthApi.this.debugLog("requestDisclaimerAgreement onSuccess ");
                    DisclaimerAgreementResultCallback disclaimerAgreementResultCallback2 = disclaimerAgreementResultCallback;
                    if (disclaimerAgreementResultCallback2 != null) {
                        disclaimerAgreementResultCallback2.onResult(new BooleanResult(new CommonResultStatus(1), z));
                    }
                }
            });
            return 1;
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return -1;
        } catch (NotConnectedException e2) {
            e = e2;
            secureLog(e);
            return -1;
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return -1;
        } catch (OutOfMemoryError unused) {
            verboseLog("OutOfMemoryError occurred");
            return -1;
        }
    }

    public int requestRenewAccessTokenForAccount(String str, final AccessTokenResultCallback accessTokenResultCallback) {
        debugLog("requestRenewAccessTokenForAccount : accountAppId=[" + getAppId() + "], expiredAccessToken=[" + str + "] ");
        if (isAppIdNullOrEmpty()) {
            return -1;
        }
        try {
            getAuthService().requestRenewAccessTokenForAccount(getAppId(), getContext().getPackageName(), null, str, new IAccessTokenResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.auth.AuthApi.3
                @Override // com.samsung.android.sdk.mobileservice.auth.IAccessTokenResultCallback
                public void onFailure(String str2, String str3) {
                    AuthApi.this.debugLog(AbstractC0541b.m775q("requestRenewAccessTokenForAccount onFailure : code=[", str2, "], message=[", str3, "] "));
                    if (accessTokenResultCallback != null) {
                        int iConvertErrorcode = ErrorCodeConvertor.convertErrorcode(str2);
                        AuthApi.this.debugLog("converted error code = " + iConvertErrorcode + " - requestRenewAccessTokenForAccount");
                        accessTokenResultCallback.onResult(new AccessTokenInfoResult(new CommonResultStatus(iConvertErrorcode, str3, str2), null));
                    }
                }

                @Override // com.samsung.android.sdk.mobileservice.auth.IAccessTokenResultCallback
                public void onSuccess(Bundle bundle, Bundle bundle2) {
                    TokenInfo tokenInfo;
                    AuthApi.this.debugLog("requestRenewAccessTokenForAccount onSuccess ");
                    if (accessTokenResultCallback != null) {
                        if (bundle != null) {
                            tokenInfo = new TokenInfo();
                            if (bundle.containsKey(ResponseType.TOKEN)) {
                                tokenInfo.setToken(bundle.getString(ResponseType.TOKEN));
                            }
                            if (bundle.containsKey("token_type")) {
                                tokenInfo.setTokenType(bundle.getString("token_type"));
                            }
                            if (bundle.containsKey(AuthConstants.EXTRA_API_SERVER_URL)) {
                                tokenInfo.setApiServerUrl(bundle.getString(AuthConstants.EXTRA_API_SERVER_URL));
                            }
                            if (bundle.containsKey(AuthConstants.EXTRA_AUTH_SERVER_URL)) {
                                tokenInfo.setAuthServerUrl(bundle.getString(AuthConstants.EXTRA_AUTH_SERVER_URL));
                            }
                            if (bundle.containsKey("token_issued_time")) {
                                tokenInfo.setTokenIssuedTime(bundle.getLong("token_issued_time"));
                            }
                            if (bundle.containsKey("token_validity_period")) {
                                tokenInfo.setTokenValidityPeriod(bundle.getLong("token_validity_period"));
                            }
                        } else {
                            tokenInfo = null;
                        }
                        accessTokenResultCallback.onResult(new AccessTokenInfoResult(new CommonResultStatus(1), tokenInfo));
                    }
                }
            });
            return 1;
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return -1;
        } catch (NotConnectedException e2) {
            e = e2;
            secureLog(e);
            return -1;
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return -1;
        } catch (OutOfMemoryError unused) {
            verboseLog("OutOfMemoryError occurred");
            return -1;
        }
    }

    public int setDisclaimerAgreementForSocial(boolean z) {
        debugLog("setDisclaimerAgreementForSocial ");
        if (isAppIdNullOrEmpty()) {
            return -1;
        }
        if (!isSupportedSaAgentVersion(1000000000)) {
            debugLog("Agent version is under ver. Need to use with Agent 10.0.00.00 or higher.");
            return -7;
        }
        try {
            if (CommonUtils.isStandAloneSamsungAccountSupported(getContext()) && !isAvailableSocialService()) {
                return -1;
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("agreed", z);
            if (CommonUtils.isStandAloneSamsungAccountSupported(getContext())) {
                if (getSocialService().setDisclaimerAgreementForSocial(bundle)) {
                    return 1;
                }
            } else if (getAuthService().setDisclaimerAgreementForSocial(z)) {
                return 1;
            }
            return -1;
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return -1;
        } catch (NotConnectedException e2) {
            e = e2;
            secureLog(e);
            return -1;
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return -1;
        } catch (OutOfMemoryError unused) {
            verboseLog("OutOfMemoryError occurred");
            return -1;
        }
    }

    private Intent getIntentToDisplay(String str, Bundle bundle) {
        if (bundle != null && isAvailableSocialService()) {
            bundle.putString("what", str);
            try {
                return getSocialService().getIntentToDisplay(bundle);
            } catch (RemoteException e) {
                e = e;
                secureLog(e);
                return null;
            } catch (NotConnectedException e2) {
                e = e2;
                secureLog(e);
                return null;
            } catch (NullPointerException e3) {
                e = e3;
                secureLog(e);
                return null;
            } catch (OutOfMemoryError unused) {
                verboseLog("OutOfMemoryError occurred");
                return null;
            }
        }
        return null;
    }

    private Intent getIntentForAccountAccessTokenRequest(String str, String str2) {
        try {
            return getAuthService().getIntentForAccountAccessTokenRequest(str, str2);
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return null;
        } catch (NotConnectedException e2) {
            e = e2;
            secureLog(e);
            return null;
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return null;
        } catch (OutOfMemoryError unused) {
            verboseLog("OutOfMemoryError occurred");
            return null;
        }
    }

    private Intent getIntentForAccountDisclaimerAgreement(String str, boolean z) {
        try {
            return getAuthService().getIntentForAccountDisclaimerAgreement(str, z);
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return null;
        } catch (NotConnectedException e2) {
            e = e2;
            secureLog(e);
            return null;
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return null;
        } catch (OutOfMemoryError unused) {
            verboseLog("OutOfMemoryError occurred");
            return null;
        }
    }

    private Intent getIntentForAccountPasswordConfirmation(String str) {
        debugLog("getIntentForAccountPasswordConfirmation : accountAppId=[" + str + "] ");
        try {
            return getAuthService().getIntentForAccountPasswordConfirmation(str);
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return null;
        } catch (NotConnectedException e2) {
            e = e2;
            secureLog(e);
            return null;
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return null;
        } catch (OutOfMemoryError unused) {
            verboseLog("OutOfMemoryError occurred");
            return null;
        }
    }

    private Intent getIntentForAccountPasswordConfirmationPopup(String str) {
        debugLog("getIntentForAccountPasswordConfirmationPopup : accountAppId=[" + str + "] ");
        try {
            return getAuthService().getIntentForAccountPasswordConfirmationPopup(str);
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return null;
        } catch (NotConnectedException e2) {
            e = e2;
            secureLog(e);
            return null;
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return null;
        } catch (OutOfMemoryError unused) {
            verboseLog("OutOfMemoryError occurred");
            return null;
        }
    }

    private Intent getIntentForAccountProfileModification(String str) {
        try {
            return getAuthService().getIntentForAccountProfileModification(str);
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return null;
        } catch (NotConnectedException e2) {
            e = e2;
            secureLog(e);
            return null;
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return null;
        } catch (OutOfMemoryError unused) {
            verboseLog("OutOfMemoryError occurred");
            return null;
        }
    }

    private Intent getIntentForAccountValidationRequest(String str, boolean z, boolean z2) {
        try {
            return getAuthService().getIntentForAccountValidationRequest(str, z, z2);
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return null;
        } catch (NotConnectedException e2) {
            e = e2;
            secureLog(e);
            return null;
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return null;
        } catch (OutOfMemoryError unused) {
            verboseLog("OutOfMemoryError occurred");
            return null;
        }
    }

    public BooleanResult getDisclaimerAgreementForSocial(int i) {
        boolean disclaimerAgreementForService;
        boolean z = false;
        if (isAppIdNullOrEmpty()) {
            return new BooleanResult(new CommonResultStatus(-1), false);
        }
        if (!isSupportedSaAgentVersion(CommonConstants.SupportedApiMinVersion.VERSION_4_1)) {
            return new BooleanResult(new CommonResultStatus(-1), false);
        }
        try {
            if (CommonUtils.isStandAloneSamsungAccountSupported(getContext())) {
                if (isAvailableSocialService()) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("serviceId", i);
                    disclaimerAgreementForService = getSocialService().getDisclaimerAgreementForService(bundle);
                }
                debugLog("getDisclaimerAgreementForSocial " + z + " ");
                return new BooleanResult(new CommonResultStatus(1), z);
            }
            disclaimerAgreementForService = getAuthService().getDisclaimerAgreementForService(i);
            z = disclaimerAgreementForService;
            debugLog("getDisclaimerAgreementForSocial " + z + " ");
            return new BooleanResult(new CommonResultStatus(1), z);
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return new BooleanResult(new CommonResultStatus(-1), false);
        } catch (NotConnectedException e2) {
            e = e2;
            secureLog(e);
            return new BooleanResult(new CommonResultStatus(-1), false);
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return new BooleanResult(new CommonResultStatus(-1), false);
        } catch (OutOfMemoryError unused) {
            verboseLog("OutOfMemoryError occurred");
            return new BooleanResult(new CommonResultStatus(-1), false);
        }
    }
}
