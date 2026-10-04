package com.samsung.android.sdk.mobileservice.social;

import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.glance.AbstractC2821a;
import com.samsung.android.sdk.mobileservice.SeMobileServiceSession;
import com.samsung.android.sdk.mobileservice.common.CommonConstants;
import com.samsung.android.sdk.mobileservice.common.ErrorCodeConvertor;
import com.samsung.android.sdk.mobileservice.common.api.SeMobileServiceApi;
import com.samsung.android.sdk.mobileservice.common.exception.NotAuthorizedException;
import com.samsung.android.sdk.mobileservice.common.exception.NotConnectedException;
import com.samsung.android.sdk.mobileservice.common.result.BooleanResult;
import com.samsung.android.sdk.mobileservice.common.result.CommonResult;
import com.samsung.android.sdk.mobileservice.common.result.CommonResultStatus;
import com.samsung.android.sdk.mobileservice.social.buddy.IServiceActivationResultCallback;
import com.samsung.android.sdk.mobileservice.social.buddy.IServiceDeactivationResultCallback;
import com.samsung.android.sdk.mobileservice.social.common.IBundleResultCallback;
import com.samsung.android.sdk.mobileservice.social.social.BundleKey;
import com.samsung.android.sdk.mobileservice.social.social.result.ServiceNumber;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SocialApi extends SeMobileServiceApi {
    public static final String API_NAME = "SocialApi";
    public static final int CONTACT_UPLOAD_BASE_SERVICE = 2;
    public static final int COUNTRY_TYPE_CHINA = 3;
    public static final int COUNTRY_TYPE_EUROPE = 2;
    public static final int COUNTRY_TYPE_GLOBAL = 0;
    public static final int COUNTRY_TYPE_KOREA = 1;
    public static final int DEVICE_AUTH_BASE_SERVICE = 1;
    public static final int SERVICE_ID_CERTIFICATE_SHARING = 1;
    public static final int SERVICE_ID_CONTACT_UPLOAD = 101;
    public static final int SERVICE_ID_PROFILE_CARD_SHARING = 2;
    public static final int SERVICE_ID_PROFILE_SHARING = 0;
    public static final String SERVICE_NAME = "SocialService";
    public static final int SOCIAL_AGREEMENT_BASE_SERVICE = 0;
    private final String EXTRA_RESULT;
    private final String EXTRA_SCOPE;
    private final String EXTRA_SERVICE_ID;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum DisclosureScope {
        NOTHING(-1),
        EVERYONE(0),
        CONTACT_ONLY(1);

        private final int mIndex;

        DisclosureScope(int i) {
            this.mIndex = i;
        }

        public static DisclosureScope fromIndex(int i) {
            DisclosureScope disclosureScope = EVERYONE;
            if (i == disclosureScope.getIndex()) {
                return disclosureScope;
            }
            DisclosureScope disclosureScope2 = CONTACT_ONLY;
            return i == disclosureScope2.getIndex() ? disclosureScope2 : NOTHING;
        }

        public int getIndex() {
            return this.mIndex;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface DisclosureScopeResultCallback {
        void onResult(CommonResult<DisclosureScope> commonResult);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ServiceActivationResultCallback {
        void onResult(BooleanResult booleanResult, int i);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ServiceDeactivationResultCallback {
        void onResult(BooleanResult booleanResult, int i);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ServiceNumberResultCallback {
        void onResult(CommonResult<ServiceNumber> commonResult);
    }

    public SocialApi(SeMobileServiceSession seMobileServiceSession) {
        super(seMobileServiceSession, "SocialApi");
        this.EXTRA_RESULT = "result";
        this.EXTRA_SERVICE_ID = "service_id";
        this.EXTRA_SCOPE = "scope";
    }

    private SocialServiceState bundleToSocialServiceState(Bundle bundle) {
        if (bundle != null) {
            return new SocialServiceState(bundle.getInt("state", 1), (Intent) bundle.getParcelable(MarketingConstants.LINK_TYPE_INTENT));
        }
        debugLog("bundle is null : bundleToSocialServiceState");
        return null;
    }

    private Intent getIntentToDisplay(String str) {
        return getIntentToDisplay(str, new Bundle());
    }

    private boolean isAuthorized() {
        try {
            checkAuthorized(0, 2, 1);
            return true;
        } catch (NotAuthorizedException unused) {
            return false;
        }
    }

    private Bundle isSomethingNeeded(String str) {
        return isSomethingNeeded(str, new Bundle());
    }

    public int getCountryTypeForAgreement() {
        debugLog("getCountryTypeForAgreement ");
        try {
            return getSocialService().getCountryTypeForAgreement();
        } catch (Exception e) {
            secureLog(e);
            return -1;
        }
    }

    public CommonResult<DisclosureScope> getDisclosureScope(int i) {
        debugLog("getDisclosureScope. serviceId: " + i);
        if (!isSupportedSemsAgentVersionMoreThan(CommonConstants.SupportedApiMinVersion.VERSION_13_6_50)) {
            return new CommonResult<>(new CommonResultStatus(-7), null);
        }
        if (!isAuthorized()) {
            secureLog("getDisclosureScope. not authorized. return here.", new String[0]);
            return new CommonResult<>(new CommonResultStatus(-1), null);
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("service_id", i);
            DisclosureScope disclosureScopeFromIndex = DisclosureScope.fromIndex(getSocialService().getDisclosureScope(bundle));
            debugLog("getDisclosureScope serviceId=[" + i + "], result=[" + disclosureScopeFromIndex.name() + "]");
            return new CommonResult<>(new CommonResultStatus(1), disclosureScopeFromIndex);
        } catch (RemoteException | NotConnectedException | NullPointerException e) {
            secureLog(e);
            return new CommonResult<>(new CommonResultStatus(-1), null);
        }
    }

    @Override // com.samsung.android.sdk.mobileservice.common.api.SeMobileServiceApi
    public String[] getEssentialServiceNames() {
        return new String[]{"SocialService"};
    }

    public Intent getIntentForAgreementProcedure() {
        debugLog("getIntentForAgreementProcedure ");
        Bundle bundle = new Bundle();
        bundle.putBoolean("isLegalPopupSupported", true);
        return getIntentToDisplay("AgreementProcedure", bundle);
    }

    public Intent getIntentForForceUpdate() {
        return getIntentToDisplay(BundleKey.FORCE_UPDATE);
    }

    public Intent getIntentForGdprErrorPopup() {
        debugLog("getIntentForGdprErrorPopup ");
        return getIntentToDisplay(BundleKey.GDPR);
    }

    public Intent getIntentForIntroductionDisplay() {
        debugLog("getIntentForIntroductionDisplay ");
        return getIntentToDisplay(BundleKey.INTRODUCTION);
    }

    public Intent getIntentForPersonalInformationCollectionAgreementDisplay() {
        debugLog("getIntentForPersonalInformationCollectionAgreementDisplay ");
        return getIntentToDisplay(BundleKey.PERSONAL_INFORMATION_COLLECTION_AGREEMENT);
    }

    public Intent getIntentForSocialDisclaimerDisplay() {
        debugLog("getIntentForSocialDisclaimerDisplay ");
        return getIntentToDisplay("SocialDisclaimer");
    }

    public Intent getIntentForTermsAndConditionDisplay() {
        debugLog("getIntentForTermsAndConditionDisplay ");
        return getIntentToDisplay(BundleKey.TERMS_AND_CONDITION);
    }

    public SocialServiceState getServiceState() {
        debugLog("getServiceState ");
        try {
            return bundleToSocialServiceState(getSocialService().getServiceState());
        } catch (Exception e) {
            secureLog(e);
            return null;
        }
    }

    public boolean isAgreementProcedureNeeded() {
        debugLog("isAgreementProcedureNeeded ");
        Bundle bundleIsSomethingNeeded = isSomethingNeeded("AgreementProcedure");
        boolean z = bundleIsSomethingNeeded != null ? bundleIsSomethingNeeded.getBoolean("isNeeded", true) : true;
        debugLog("isAgreementProcedureNeeded " + z + SQLKeyword.COMMA);
        return z;
    }

    public BooleanResult isPermissionGranted(String str) {
        debugLog("isPermissionGranted ");
        if (!isSupportedSemsAgentVersionBetween(CommonConstants.SupportedApiMinVersion.VERSION_10_8_6_1, CommonConstants.SupportedApiMinVersion.VERSION_11_0) && !isSupportedSemsAgentVersionMoreThan(CommonConstants.SupportedApiMinVersion.VERSION_13_0_1_28)) {
            return new BooleanResult(new CommonResultStatus(-1), true);
        }
        try {
            return new BooleanResult(new CommonResultStatus(1), getSocialService().isPermissionGranted(AbstractC2821a.m2215f(BundleKey.API_NAME, str)).getBoolean(BundleKey.IS_PERMISSION_GRANTED, false));
        } catch (RemoteException | NotConnectedException | NullPointerException e) {
            secureLog(e);
            return new BooleanResult(new CommonResultStatus(-1), false);
        }
    }

    public BooleanResult isServiceActivated(int i) {
        if (!isAuthorized()) {
            return new BooleanResult(new CommonResultStatus(-1), false);
        }
        try {
            if (getSocialService().isServiceActivated(i) == 1) {
                debugLog("isServiceActivated serviceId=[" + i + "] true ");
                return new BooleanResult(new CommonResultStatus(1), true);
            }
            debugLog("isServiceActivated serviceId=[" + i + "] false ");
            return new BooleanResult(new CommonResultStatus(1), false);
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
        }
    }

    public int requestDisclosureScope(int i, final DisclosureScopeResultCallback disclosureScopeResultCallback) {
        StringBuilder sbM778t = AbstractC0541b.m778t(i, "requestDisclosureScope. serviceId: ", ", callback exist: ");
        sbM778t.append(disclosureScopeResultCallback != null);
        debugLog(sbM778t.toString());
        if (!isSupportedSemsAgentVersionMoreThan(CommonConstants.SupportedApiMinVersion.VERSION_13_6_50)) {
            return -7;
        }
        if (!isAuthorized()) {
            secureLog("requestDisclosureScope. not authorized. return here.", new String[0]);
            return -1;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("service_id", i);
            return getSocialService().requestDisclosureScope(bundle, new IBundleResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.SocialApi.4
                @Override // com.samsung.android.sdk.mobileservice.social.common.IBundleResultCallback
                public void onFailure(long j, String str) {
                    SocialApi.this.debugLog("requestDisclosureScope. fail. code: " + j + ", message: " + str);
                    DisclosureScopeResultCallback disclosureScopeResultCallback2 = disclosureScopeResultCallback;
                    if (disclosureScopeResultCallback2 != null) {
                        disclosureScopeResultCallback2.onResult(new CommonResult<>(new CommonResultStatus(-1, str, Long.toString(j)), null));
                    }
                }

                @Override // com.samsung.android.sdk.mobileservice.social.common.IBundleResultCallback
                public void onSuccess(Bundle bundle2) {
                    if (disclosureScopeResultCallback != null) {
                        DisclosureScope disclosureScopeFromIndex = DisclosureScope.fromIndex(bundle2.getInt("result"));
                        SocialApi.this.debugLog("requestDisclosureScope. success. result: " + disclosureScopeFromIndex.name());
                        disclosureScopeResultCallback.onResult(new CommonResult<>(new CommonResultStatus(1), disclosureScopeFromIndex));
                    }
                }
            });
        } catch (RemoteException | NotConnectedException | NullPointerException e) {
            secureLog(e);
            return -1;
        }
    }

    public int requestDisclosureScopeUpdate(int i, DisclosureScope disclosureScope, final DisclosureScopeResultCallback disclosureScopeResultCallback) {
        StringBuilder sbM778t = AbstractC0541b.m778t(i, "requestDisclosureScopeUpdate. serviceId: ", ", scope: ");
        sbM778t.append(disclosureScope.name());
        sbM778t.append(", callback exist: ");
        sbM778t.append(disclosureScopeResultCallback != null);
        debugLog(sbM778t.toString());
        if (!isSupportedSemsAgentVersionMoreThan(CommonConstants.SupportedApiMinVersion.VERSION_13_6_50)) {
            return -7;
        }
        if (!isAuthorized()) {
            secureLog("requestDisclosureScopeUpdate. not authorized. return here.", new String[0]);
            return -1;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("service_id", i);
            bundle.putInt("scope", disclosureScope.getIndex());
            return getSocialService().requestDisclosureScopeUpdate(bundle, new IBundleResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.SocialApi.5
                @Override // com.samsung.android.sdk.mobileservice.social.common.IBundleResultCallback
                public void onFailure(long j, String str) {
                    SocialApi.this.debugLog("requestDisclosureScopeUpdate. fail. code: " + j + ", message: " + str);
                    DisclosureScopeResultCallback disclosureScopeResultCallback2 = disclosureScopeResultCallback;
                    if (disclosureScopeResultCallback2 != null) {
                        disclosureScopeResultCallback2.onResult(new CommonResult<>(new CommonResultStatus(-1, str, Long.toString(j)), null));
                    }
                }

                @Override // com.samsung.android.sdk.mobileservice.social.common.IBundleResultCallback
                public void onSuccess(Bundle bundle2) {
                    if (disclosureScopeResultCallback != null) {
                        DisclosureScope disclosureScopeFromIndex = DisclosureScope.fromIndex(bundle2.getInt("result"));
                        SocialApi.this.debugLog("requestDisclosureScopeUpdate. success. result: " + disclosureScopeFromIndex.name());
                        disclosureScopeResultCallback.onResult(new CommonResult<>(new CommonResultStatus(1), disclosureScopeFromIndex));
                    }
                }
            });
        } catch (RemoteException | NotConnectedException | NullPointerException e) {
            secureLog(e);
            return -1;
        }
    }

    public int requestServiceActivation(int i, final ServiceActivationResultCallback serviceActivationResultCallback) {
        debugLog("requestServiceActivation serviceId=[" + i + "] ");
        if (!isAuthorized()) {
            return -1;
        }
        try {
            getSocialService().requestServiceActivation(i, new IServiceActivationResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.SocialApi.1
                @Override // com.samsung.android.sdk.mobileservice.social.buddy.IServiceActivationResultCallback
                public void onFailure(int i2, String str) {
                    SocialApi.this.debugLog(AbstractC11014a.m12321f("requestServiceActivation onFailure : code=[", i2, "], message=[", str, "] "));
                    if (serviceActivationResultCallback != null) {
                        serviceActivationResultCallback.onResult(new BooleanResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(i2), str, Integer.toString(i2)), false), -1);
                    }
                }

                @Override // com.samsung.android.sdk.mobileservice.social.buddy.IServiceActivationResultCallback
                public void onSuccess(int i2) {
                    SocialApi.this.debugLog("requestServiceActivation serviceId=[" + i2 + "] onSuccess ");
                    ServiceActivationResultCallback serviceActivationResultCallback2 = serviceActivationResultCallback;
                    if (serviceActivationResultCallback2 != null) {
                        serviceActivationResultCallback2.onResult(new BooleanResult(new CommonResultStatus(1), true), i2);
                    }
                }
            });
            return 1;
        } catch (RemoteException | NotConnectedException | NullPointerException e) {
            secureLog(e);
            return -1;
        }
    }

    public int requestServiceDeactivation(int i, final ServiceDeactivationResultCallback serviceDeactivationResultCallback) {
        debugLog("requestServiceDeactivation serviceId=[" + i + "] ");
        if (!isAuthorized()) {
            return -1;
        }
        try {
            getSocialService().requestServiceDeactivation(i, new IServiceDeactivationResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.SocialApi.2
                @Override // com.samsung.android.sdk.mobileservice.social.buddy.IServiceDeactivationResultCallback
                public void onFailure(int i2, String str) {
                    SocialApi.this.debugLog(AbstractC11014a.m12321f("requestServiceDeactivation onFailure : code=[", i2, "], message=[", str, "] "));
                    if (serviceDeactivationResultCallback != null) {
                        serviceDeactivationResultCallback.onResult(new BooleanResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(i2), str, Integer.toString(i2)), false), -1);
                    }
                }

                @Override // com.samsung.android.sdk.mobileservice.social.buddy.IServiceDeactivationResultCallback
                public void onSuccess(int i2) {
                    SocialApi.this.debugLog("requestServiceDeactivation serviceId=[" + i2 + "] onSuccess ");
                    ServiceDeactivationResultCallback serviceDeactivationResultCallback2 = serviceDeactivationResultCallback;
                    if (serviceDeactivationResultCallback2 != null) {
                        serviceDeactivationResultCallback2.onResult(new BooleanResult(new CommonResultStatus(1), true), i2);
                    }
                }
            });
            return 1;
        } catch (Exception e) {
            secureLog(e);
            return -1;
        }
    }

    public int requestServiceNumber(final ServiceNumberResultCallback serviceNumberResultCallback) {
        debugLog("requestServiceNumberInfo");
        if (!isSupportedSemsAgentVersionMoreThan(CommonConstants.SupportedApiMinVersion.VERSION_12_1)) {
            return -7;
        }
        try {
            getSocialService().requestServiceNumber(new IBundleResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.SocialApi.3
                @Override // com.samsung.android.sdk.mobileservice.social.common.IBundleResultCallback
                public void onFailure(long j, String str) {
                    SocialApi socialApi = SocialApi.this;
                    StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestServiceNumber onFailure : code=[", "], message=[", str);
                    sbM2225p.append("] ");
                    socialApi.debugLog(sbM2225p.toString());
                    CommonResultStatus commonResultStatus = new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), str, String.valueOf(j));
                    ServiceNumberResultCallback serviceNumberResultCallback2 = serviceNumberResultCallback;
                    if (serviceNumberResultCallback2 != null) {
                        serviceNumberResultCallback2.onResult(new CommonResult<>(commonResultStatus, null));
                    }
                }

                @Override // com.samsung.android.sdk.mobileservice.social.common.IBundleResultCallback
                public void onSuccess(Bundle bundle) {
                    SocialApi.this.debugLog("requestServiceNumber onSuccess ");
                    if (serviceNumberResultCallback != null) {
                        serviceNumberResultCallback.onResult(new CommonResult<>(new CommonResultStatus(1), new ServiceNumber(bundle.getInt(BundleKey.SERVICE_NUMBER_CNT, 0), bundle.getBoolean(BundleKey.CONTAINS_MY_NUMBER, false), bundle.getStringArrayList(BundleKey.SERVICE_NUMBER_LiST), bundle.getString(BundleKey.MY_PHONE_NUMBER))));
                    }
                }
            });
            return 1;
        } catch (RemoteException | NotConnectedException | NullPointerException e) {
            secureLog(e);
            return -1;
        }
    }

    private Intent getIntentToDisplay(String str, Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        bundle.putString("what", str);
        try {
            return getSocialService().getIntentToDisplay(bundle);
        } catch (RemoteException | NotConnectedException | NullPointerException e) {
            secureLog(e);
            return null;
        }
    }

    private Bundle isSomethingNeeded(String str, Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        try {
            bundle.putString("what", str);
            return getSocialService().isSomethingNeeded(bundle);
        } catch (RemoteException | NotConnectedException | NullPointerException e) {
            secureLog(e);
            return null;
        }
    }

    public Intent getIntentForAgreementProcedure(int i) {
        debugLog("getIntentForAgreementProcedure ");
        Bundle bundle = new Bundle();
        bundle.putBoolean("isLegalPopupSupported", true);
        bundle.putInt(BundleKey.SERVICE_TYPE, i);
        return getIntentToDisplay("AgreementProcedure", bundle);
    }

    public boolean isAgreementProcedureNeeded(int i) {
        debugLog("isAgreementProcedureNeeded ");
        Bundle bundle = new Bundle();
        bundle.putInt(BundleKey.SERVICE_TYPE, i);
        Bundle bundleIsSomethingNeeded = isSomethingNeeded("AgreementProcedure", bundle);
        boolean z = bundleIsSomethingNeeded != null ? bundleIsSomethingNeeded.getBoolean("isNeeded", true) : true;
        debugLog("isAgreementProcedureNeeded " + z);
        return z;
    }
}
