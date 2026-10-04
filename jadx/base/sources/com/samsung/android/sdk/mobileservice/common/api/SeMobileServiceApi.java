package com.samsung.android.sdk.mobileservice.common.api;

import android.content.Context;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.sdk.mobileservice.SeMobileServiceSession;
import com.samsung.android.sdk.mobileservice.SeMobileServiceSessionImpl;
import com.samsung.android.sdk.mobileservice.auth.IMobileServiceAuth;
import com.samsung.android.sdk.mobileservice.common.exception.NotAuthorizedException;
import com.samsung.android.sdk.mobileservice.common.exception.NotConnectedException;
import com.samsung.android.sdk.mobileservice.common.exception.NotSupportedApiException;
import com.samsung.android.sdk.mobileservice.place.IMobileServicePlace;
import com.samsung.android.sdk.mobileservice.profile.IMobileServiceProfile;
import com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial;
import com.samsung.android.sdk.mobileservice.util.SdkLog;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class SeMobileServiceApi {
    private final String mApiName;
    private final String mReference;
    protected final SeMobileServiceSessionImpl mSessionInstance;

    public SeMobileServiceApi(SeMobileServiceSession seMobileServiceSession, String str) throws NotConnectedException, NotAuthorizedException, NotSupportedApiException {
        if (!(seMobileServiceSession instanceof SeMobileServiceSessionImpl)) {
            SdkLog.m5784i(str, "Session is invalid " + SdkLog.getReference(seMobileServiceSession));
            throw new NotConnectedException("Session is not connected! After connection callback called, new this api class!");
        }
        SeMobileServiceSessionImpl seMobileServiceSessionImpl = (SeMobileServiceSessionImpl) seMobileServiceSession;
        this.mSessionInstance = seMobileServiceSessionImpl;
        this.mApiName = str;
        this.mReference = SdkLog.getReference(seMobileServiceSessionImpl);
        debugLog(str);
        for (String str2 : getEssentialServiceNames()) {
            if (!seMobileServiceSessionImpl.isAddedService(str2)) {
                SdkLog.m5784i(str, "Not added service " + SdkLog.getReference(seMobileServiceSession));
                throw new NotAuthorizedException(AbstractC0541b.m756B(str2, " is not added service. Before new this api class, you must add this service name on session!"));
            }
        }
        if (!seMobileServiceSessionImpl.isSessionConnected()) {
            SdkLog.m5784i(str, "Session is not connected " + SdkLog.getReference(seMobileServiceSession));
            throw new NotConnectedException("Session is not connected! After connection callback called, new this api class!");
        }
        if (seMobileServiceSessionImpl.isSupportedApi(str)) {
            return;
        }
        SdkLog.m5784i(str, "Api component is not supported. " + SdkLog.getReference(seMobileServiceSession));
        throw new NotSupportedApiException(AbstractC0541b.m756B(str, " is not supported"));
    }

    public void checkAuthorized(int... iArr) throws NotAuthorizedException {
        HashSet hashSet = new HashSet();
        for (int i : iArr) {
            hashSet.add(Integer.valueOf(i));
        }
        int authorized = this.mSessionInstance.getAuthorized();
        if (hashSet.contains(Integer.valueOf(authorized))) {
            if (authorized == 0) {
                debugLog("Account not authorized ");
                throw new NotAuthorizedException("Account is not authorized! you need sign-in");
            }
            if (authorized == 1) {
                debugLog("Device not authorized ");
                throw new NotAuthorizedException("Device is not authorized! you need to authorize device");
            }
            if (authorized != 2) {
                return;
            }
            debugLog("MobileService Agent is not installed ");
            throw new NotAuthorizedException("MobileService Agent is not installed you need to install MobileService Agent");
        }
    }

    public void debugLog(String str) {
        String str2 = this.mApiName;
        StringBuilder sbM781w = AbstractC0541b.m781w(str, " ");
        sbM781w.append(this.mReference);
        SdkLog.m5784i(str2, sbM781w.toString());
    }

    public String getAppId() {
        return this.mSessionInstance.getAppId();
    }

    public IMobileServiceAuth getAuthService() {
        return this.mSessionInstance.getAuthService();
    }

    public Context getContext() {
        return this.mSessionInstance.getContext();
    }

    public abstract String[] getEssentialServiceNames();

    public IMobileServicePlace getPlaceService() {
        return this.mSessionInstance.getPlaceService();
    }

    public IMobileServiceProfile getProfileService() {
        return this.mSessionInstance.getProfileService();
    }

    public String getReference() {
        return this.mReference;
    }

    public long getSemsAgentVersion() {
        return this.mSessionInstance.getSamsungExperienceServiceAgentVersion();
    }

    public IMobileServiceSocial getSocialService() {
        return this.mSessionInstance.getSocialService();
    }

    public String getTag() {
        return this.mApiName;
    }

    public void infoLog(String str) {
        String str2 = this.mApiName;
        StringBuilder sbM781w = AbstractC0541b.m781w(str, " ");
        sbM781w.append(this.mReference);
        SdkLog.m5784i(str2, sbM781w.toString());
    }

    public boolean isNoMoreSupportedSemsAgentVersion(int i) {
        return this.mSessionInstance.isNoMoreSupportedSemsAgentVersion(i);
    }

    public boolean isSupportedSaAgentVersion(int i) {
        return this.mSessionInstance.isSupportedSaAgentVersion(i);
    }

    public boolean isSupportedSemsAgentVersionBetween(int i, int i2) {
        return this.mSessionInstance.isSupportedSemsAgentVersionBetween(i, i2);
    }

    public boolean isSupportedSemsAgentVersionMoreThan(int i) {
        return this.mSessionInstance.isSupportedSemsAgentVersionMoreThan(i);
    }

    public void secureLog(Exception exc) {
        SdkLog.m5785s(exc);
    }

    public void verboseLog(String str) {
        String str2 = this.mApiName;
        StringBuilder sbM781w = AbstractC0541b.m781w(str, " ");
        sbM781w.append(this.mReference);
        SdkLog.m5788v(str2, sbM781w.toString());
    }

    public void secureLog(String str, String... strArr) {
        SdkLog.m5787s(this.mApiName, str, strArr);
    }
}
