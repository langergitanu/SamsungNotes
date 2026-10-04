package com.samsung.android.sdk.mobileservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import com.samsung.android.sdk.mobileservice.auth.IMobileServiceAuth;
import com.samsung.android.sdk.mobileservice.common.CommonConstants;
import com.samsung.android.sdk.mobileservice.common.ICommonService;
import com.samsung.android.sdk.mobileservice.common.exception.NotConnectedException;
import com.samsung.android.sdk.mobileservice.place.IMobileServicePlace;
import com.samsung.android.sdk.mobileservice.profile.IMobileServiceProfile;
import com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial;
import com.samsung.android.sdk.mobileservice.util.SdkLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
class SeMobileServiceBindManager implements BindChangeListener {
    private static final String BIND_CLASS_NAME_AUTH = "com.osp.app.signin.service.SemsAidlService";
    private static final String BIND_CLASS_NAME_COMMON = "com.samsung.android.mobileservice.commonservice.CommonService";
    private static final String BIND_CLASS_NAME_COMMON_FOR_SA = "com.samsung.android.samsungaccount.mobileservice.commonservice.CommonService";
    private static final String BIND_CLASS_NAME_SOCIAL = "com.samsung.android.mobileservice.social.MobileServiceSocialService";
    private static final String BIND_PACKAGE_NAME = "com.samsung.android.mobileservice";
    private static final String BIND_REQUEST_SERVICE_AUTH = "com.samsung.android.mobileservice.auth.REQUEST_SERVICE";
    private static final String BIND_REQUEST_SERVICE_COMMON = "com.samsung.android.mobileservice.common.REQUEST_SERVICE";
    private static final String BIND_REQUEST_SERVICE_PLACE = "com.samsung.android.mobileservice.place.REQUEST_SERVICE";
    private static final String BIND_REQUEST_SERVICE_PROFILE = "com.samsung.android.mobileservice.profile.REQUEST_SERVICE";
    private static final String EXTRA_APP_ID = "app_id";
    private static final long MIN_AGENT_SUPPORT_VERSION = 0;
    private static final String TAG = "SeMobileServiceBindManager";
    private static Map<String, SeMobileServiceBindManager> sMap = new HashMap();
    private final String mAppId;
    private boolean mIsMobileServiceAgentEnabled;
    private boolean mIsMobileServiceAgentInstalled;
    private boolean mIsStandAloneSA;
    private VersionExchangeInfo mVersionExchangeInfo = null;
    final VersionExchangeInfo mEmptyVersionExchangeInfo = new VersionExchangeInfo();
    private HashSet<String> mSupportedServices = new HashSet<>();
    private ServiceHandler<ICommonService> mCommonServiceHandler = null;
    private ServiceHandler<ICommonService> mSaCommonServiceHandler = null;
    private ServiceHandler<IMobileServiceAuth> mAuthServiceHandler = null;
    private ServiceHandler<IMobileServiceProfile> mProfileServiceHandler = null;
    private ServiceHandler<IMobileServicePlace> mPlaceServiceHandler = null;
    private ServiceHandler<IMobileServiceSocial> mSocialServiceHandler = null;
    private ServiceHandler<IMobileServiceSocial> mUnknownServiceHandler = new ServiceHandler<IMobileServiceSocial>() { // from class: com.samsung.android.sdk.mobileservice.SeMobileServiceBindManager.1
        @Override // com.samsung.android.sdk.mobileservice.SeMobileServiceBindManager.ServiceHandler
        public IMobileServiceSocial asInterface(IBinder iBinder) {
            return null;
        }
    };
    private Set<BindChangeListener> bindChangeListeners = new CopyOnWriteArraySet();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum BindState {
        UNBOUND,
        BINDING,
        BOUND;

        public boolean isBound() {
            return this == BOUND;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class RequesterServiceHandler<T extends IInterface> extends ServiceHandler<T> {
        @Override // com.samsung.android.sdk.mobileservice.SeMobileServiceBindManager.ServiceHandler
        public T getService(SeMobileServiceSession seMobileServiceSession) throws NotConnectedException {
            if (this.service != null && this.bindRequestSet.contains(seMobileServiceSession)) {
                return this.service;
            }
            throw new NotConnectedException(AbstractC0622a.m1170p(this.serviceName, " is not connected", new StringBuilder()));
        }

        @Override // com.samsung.android.sdk.mobileservice.SeMobileServiceBindManager.ServiceHandler
        public boolean isBound(SeMobileServiceSession seMobileServiceSession) {
            return super.isBound(seMobileServiceSession) && this.bindRequestSet.contains(seMobileServiceSession);
        }

        @Override // com.samsung.android.sdk.mobileservice.SeMobileServiceBindManager.ServiceHandler
        public boolean unbindable(SeMobileServiceSession seMobileServiceSession) {
            return super.unbindable(seMobileServiceSession) && this.bindRequestSet.contains(seMobileServiceSession);
        }

        private RequesterServiceHandler(String str, String str2, String str3, String str4, String str5, BindChangeListener bindChangeListener) {
            super(str, str2, str3, str4, str5, bindChangeListener);
        }
    }

    private SeMobileServiceBindManager(String str, boolean z, boolean z2, boolean z3) {
        this.mAppId = str;
        this.mIsStandAloneSA = z;
        this.mIsMobileServiceAgentInstalled = z2;
        this.mIsMobileServiceAgentEnabled = z3;
    }

    private SessionErrorCode checkExchangeInfo(String str, int i, long j) {
        SdkLog.m5782d(TAG, str + " version:" + j);
        if (i == 3) {
            SdkLog.m5784i(TAG, "Force update is needed for old agent");
            return SessionErrorCode.CAUSE_AGENT_FORCE_UPDATE_REQUIRED;
        }
        if (i == 2) {
            SdkLog.m5784i(TAG, "SDK version " + SeMobileService.getSdkVersionCode() + " is lower than min " + str + " required SDK version");
            return SessionErrorCode.CAUSE_SDK_OLD_VERSION;
        }
        if (j < 0) {
            SdkLog.m5784i(TAG, str + " version " + j + " is lower than min required version 0");
            return SessionErrorCode.CAUSE_AGENT_OLD_VERSION;
        }
        if (i == 4) {
            SdkLog.m5784i(TAG, "Agent is not available");
            return SessionErrorCode.CAUSE_AGENT_NOT_AVAILABLE;
        }
        if (i == 0 || i == 1) {
            return SessionErrorCode.NO_PROBLEM;
        }
        SdkLog.m5784i(TAG, "Agent error status is not defined.");
        return SessionErrorCode.CAUSE_UNDEFINED;
    }

    private void exchangeConfiguration() {
        SdkLog.m5782d(TAG, "exchangeConfiguration - sesAgentInstalled:" + this.mIsMobileServiceAgentInstalled + ", sesAgentEnabled:" + this.mIsMobileServiceAgentEnabled + ", saStandAlone:" + this.mIsStandAloneSA);
        if (!needExchangeInfoInit()) {
            SdkLog.m5784i(TAG, "exchangeConfiguration : already set");
            return;
        }
        if ((this.mIsMobileServiceAgentInstalled && this.mIsMobileServiceAgentEnabled && !getCommonServiceHandler().isBound(null)) || (this.mIsStandAloneSA && !getSaCommonServiceHandler().isBound(null))) {
            SdkLog.m5782d(TAG, "exchangeConfiguration : common service not ready");
            return;
        }
        VersionExchangeInfo versionExchangeInfo = new VersionExchangeInfo();
        versionExchangeInfo.setSdkVersion(SeMobileService.getSdkVersionCode());
        versionExchangeInfo.setAppId(this.mAppId);
        versionExchangeInfo.addService(getAllServiceNames());
        Bundle bundle = versionExchangeInfo.toBundle();
        try {
            if (this.mIsMobileServiceAgentInstalled && this.mIsMobileServiceAgentEnabled) {
                versionExchangeInfo.put(((ICommonService) getCommonServiceHandler().getService(null)).exchangeConfiguration(bundle), this.mIsStandAloneSA, new String[0]);
            }
            if (this.mIsStandAloneSA) {
                versionExchangeInfo.put(((ICommonService) getSaCommonServiceHandler().getService(null)).exchangeConfiguration(bundle), true, getSocialServiceNames());
            }
            for (String str : getAllServiceNames()) {
                int serviceVersion = versionExchangeInfo.getServiceVersion(str);
                int serviceStatus = versionExchangeInfo.getServiceStatus(str);
                if (serviceVersion == 0 || serviceStatus != 0) {
                    StringBuilder sbM780v = AbstractC0541b.m780v("requested service:", serviceVersion, str, "[", "], status: ");
                    sbM780v.append(serviceStatus);
                    SdkLog.m5784i(TAG, sbM780v.toString());
                } else {
                    this.mSupportedServices.add(str);
                }
            }
            this.mVersionExchangeInfo = versionExchangeInfo;
        } catch (Exception unused) {
            getVersionExchangeInfo().clear();
            SdkLog.m5784i(TAG, "error during version exchange.");
        }
    }

    public static synchronized SeMobileServiceBindManager get(String str, boolean z, boolean z2, boolean z3) {
        SeMobileServiceBindManager seMobileServiceBindManager;
        seMobileServiceBindManager = sMap.get(str);
        if (seMobileServiceBindManager == null) {
            seMobileServiceBindManager = new SeMobileServiceBindManager(str, z, z2, z3);
            sMap.put("" + str, seMobileServiceBindManager);
        }
        return seMobileServiceBindManager;
    }

    private String[] getAllServiceNames() {
        return new String[]{"AuthService", "ProfileService", "PlaceService", "SocialService"};
    }

    private synchronized ServiceHandler<ICommonService> getCommonServiceHandler() throws Throwable {
        SeMobileServiceBindManager seMobileServiceBindManager;
        try {
            try {
                if (this.mCommonServiceHandler == null) {
                    seMobileServiceBindManager = this;
                    seMobileServiceBindManager.mCommonServiceHandler = new ServiceHandler<ICommonService>(this.mAppId, CommonConstants.SERVICE_NAME_COMMON, "com.samsung.android.mobileservice", BIND_CLASS_NAME_COMMON, BIND_REQUEST_SERVICE_COMMON, this) { // from class: com.samsung.android.sdk.mobileservice.SeMobileServiceBindManager.2
                        @Override // com.samsung.android.sdk.mobileservice.SeMobileServiceBindManager.ServiceHandler
                        public ICommonService asInterface(IBinder iBinder) {
                            return ICommonService.Stub.asInterface(iBinder);
                        }
                    };
                } else {
                    seMobileServiceBindManager = this;
                }
                return seMobileServiceBindManager.mCommonServiceHandler;
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }

    private synchronized ServiceHandler<ICommonService> getSaCommonServiceHandler() throws Throwable {
        SeMobileServiceBindManager seMobileServiceBindManager;
        try {
            try {
                if (this.mSaCommonServiceHandler == null) {
                    seMobileServiceBindManager = this;
                    seMobileServiceBindManager.mSaCommonServiceHandler = new ServiceHandler<ICommonService>(this.mAppId, CommonConstants.SERVICE_NAME_SA_COMMON, "com.osp.app.signin", BIND_CLASS_NAME_COMMON_FOR_SA, BIND_REQUEST_SERVICE_COMMON, this) { // from class: com.samsung.android.sdk.mobileservice.SeMobileServiceBindManager.3
                        @Override // com.samsung.android.sdk.mobileservice.SeMobileServiceBindManager.ServiceHandler
                        public ICommonService asInterface(IBinder iBinder) {
                            return ICommonService.Stub.asInterface(iBinder);
                        }
                    };
                } else {
                    seMobileServiceBindManager = this;
                }
                return seMobileServiceBindManager.mSaCommonServiceHandler;
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }

    private String[] getSaServiceNames() {
        return new String[]{"AuthService", "ProfileService", "PlaceService"};
    }

    private String getSamsungAccountPackageName() {
        return this.mIsStandAloneSA ? "com.osp.app.signin" : "com.samsung.android.mobileservice";
    }

    private String[] getSocialServiceNames() {
        return new String[]{"SocialService"};
    }

    private void onCommonSvcBound(ServiceHandler<? extends ICommonService> serviceHandler) {
        try {
            SdkLog.m5782d(TAG, "do migration as first connection : " + serviceHandler.getServiceName());
            SdkLog.m5782d(TAG, "migration result : " + ((ICommonService) serviceHandler.getService(null)).doMigration());
            exchangeConfiguration();
        } catch (Exception e) {
            SdkLog.m5785s(e);
        }
    }

    public synchronized void addBindChangeListener(BindChangeListener bindChangeListener) {
        if (bindChangeListener != null) {
            this.bindChangeListeners.add(bindChangeListener);
        }
    }

    public Set<String> bindServices(Context context, Collection<String> collection, SeMobileServiceSession seMobileServiceSession) {
        HashSet hashSet = new HashSet();
        if (collection != null) {
            for (String str : collection) {
                ServiceHandler<?> serviceHandler = getServiceHandler(str);
                if (serviceHandler == null) {
                    SdkLog.m5784i(TAG, "unknown service name : " + str);
                } else if (serviceHandler.bindService(context, seMobileServiceSession)) {
                    hashSet.add(str);
                }
            }
        }
        return hashSet;
    }

    public SessionErrorCode getAgentStatus() {
        boolean z;
        SessionErrorCode sessionErrorCodeCheckExchangeInfo;
        VersionExchangeInfo versionExchangeInfo = this.mVersionExchangeInfo;
        return (versionExchangeInfo == null || !((z = this.mIsMobileServiceAgentInstalled) || this.mIsMobileServiceAgentEnabled || this.mIsStandAloneSA)) ? SessionErrorCode.CAUSE_AGENT_NOT_AVAILABLE : (z && this.mIsMobileServiceAgentEnabled && (sessionErrorCodeCheckExchangeInfo = checkExchangeInfo("SES", versionExchangeInfo.getAgentStatus(), (long) versionExchangeInfo.getSesVersion())) != SessionErrorCode.NO_PROBLEM) ? sessionErrorCodeCheckExchangeInfo : this.mIsStandAloneSA ? checkExchangeInfo("SA", versionExchangeInfo.getSaAgentStatus(), versionExchangeInfo.getSaAgentVersion()) : SessionErrorCode.NO_PROBLEM;
    }

    public synchronized ServiceHandler<IMobileServiceAuth> getAuthServiceHandler() throws Throwable {
        SeMobileServiceBindManager seMobileServiceBindManager;
        try {
            try {
                if (this.mAuthServiceHandler == null) {
                    seMobileServiceBindManager = this;
                    seMobileServiceBindManager.mAuthServiceHandler = new RequesterServiceHandler<IMobileServiceAuth>(this.mAppId, "AuthService", getSamsungAccountPackageName(), BIND_CLASS_NAME_AUTH, BIND_REQUEST_SERVICE_AUTH, this) { // from class: com.samsung.android.sdk.mobileservice.SeMobileServiceBindManager.4
                        @Override // com.samsung.android.sdk.mobileservice.SeMobileServiceBindManager.ServiceHandler
                        public IMobileServiceAuth asInterface(IBinder iBinder) {
                            return IMobileServiceAuth.Stub.asInterface(iBinder);
                        }
                    };
                } else {
                    seMobileServiceBindManager = this;
                }
                return seMobileServiceBindManager.mAuthServiceHandler;
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }

    public synchronized ServiceHandler<IMobileServicePlace> getPlaceServiceHandler() throws Throwable {
        SeMobileServiceBindManager seMobileServiceBindManager;
        try {
            try {
                if (this.mPlaceServiceHandler == null) {
                    seMobileServiceBindManager = this;
                    seMobileServiceBindManager.mPlaceServiceHandler = new RequesterServiceHandler<IMobileServicePlace>(this.mAppId, "PlaceService", getSamsungAccountPackageName(), BIND_CLASS_NAME_AUTH, BIND_REQUEST_SERVICE_PLACE, this) { // from class: com.samsung.android.sdk.mobileservice.SeMobileServiceBindManager.6
                        @Override // com.samsung.android.sdk.mobileservice.SeMobileServiceBindManager.ServiceHandler
                        public IMobileServicePlace asInterface(IBinder iBinder) {
                            return IMobileServicePlace.Stub.asInterface(iBinder);
                        }
                    };
                } else {
                    seMobileServiceBindManager = this;
                }
                return seMobileServiceBindManager.mPlaceServiceHandler;
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }

    public synchronized ServiceHandler<IMobileServiceProfile> getProfileServiceHandler() throws Throwable {
        SeMobileServiceBindManager seMobileServiceBindManager;
        try {
            try {
                if (this.mProfileServiceHandler == null) {
                    seMobileServiceBindManager = this;
                    seMobileServiceBindManager.mProfileServiceHandler = new RequesterServiceHandler<IMobileServiceProfile>(this.mAppId, "ProfileService", getSamsungAccountPackageName(), BIND_CLASS_NAME_AUTH, BIND_REQUEST_SERVICE_PROFILE, this) { // from class: com.samsung.android.sdk.mobileservice.SeMobileServiceBindManager.5
                        @Override // com.samsung.android.sdk.mobileservice.SeMobileServiceBindManager.ServiceHandler
                        public IMobileServiceProfile asInterface(IBinder iBinder) {
                            return IMobileServiceProfile.Stub.asInterface(iBinder);
                        }
                    };
                } else {
                    seMobileServiceBindManager = this;
                }
                return seMobileServiceBindManager.mProfileServiceHandler;
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public synchronized ServiceHandler<?> getServiceHandler(String str) {
        if (str == null) {
            str = "";
        }
        try {
            switch (str.hashCode()) {
                case -1348797491:
                    if (str.equals("AuthService")) {
                        return getAuthServiceHandler();
                    }
                    break;
                case -207817778:
                    if (str.equals("PlaceService")) {
                        return getPlaceServiceHandler();
                    }
                    break;
                case 153034988:
                    if (str.equals("ProfileService")) {
                        return getProfileServiceHandler();
                    }
                    break;
                case 836900345:
                    if (str.equals(CommonConstants.SERVICE_NAME_SA_COMMON)) {
                        return getSaCommonServiceHandler();
                    }
                    break;
                case 1266397800:
                    if (str.equals("SocialService")) {
                        return getSocialServiceHandler();
                    }
                    break;
                case 2024019467:
                    if (str.equals(CommonConstants.SERVICE_NAME_COMMON)) {
                        return getCommonServiceHandler();
                    }
                    break;
            }
            return this.mUnknownServiceHandler;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized ServiceHandler<IMobileServiceSocial> getSocialServiceHandler() throws Throwable {
        SeMobileServiceBindManager seMobileServiceBindManager;
        try {
            try {
                if (this.mSocialServiceHandler == null) {
                    seMobileServiceBindManager = this;
                    seMobileServiceBindManager.mSocialServiceHandler = new RequesterServiceHandler<IMobileServiceSocial>(this.mAppId, "SocialService", "com.samsung.android.mobileservice", BIND_CLASS_NAME_SOCIAL, null, this) { // from class: com.samsung.android.sdk.mobileservice.SeMobileServiceBindManager.7
                        @Override // com.samsung.android.sdk.mobileservice.SeMobileServiceBindManager.ServiceHandler
                        public IMobileServiceSocial asInterface(IBinder iBinder) {
                            return IMobileServiceSocial.Stub.asInterface(iBinder);
                        }
                    };
                } else {
                    seMobileServiceBindManager = this;
                }
                return seMobileServiceBindManager.mSocialServiceHandler;
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }

    public Set<String> getUnsupportedServices() {
        return this.mSupportedServices;
    }

    public VersionExchangeInfo getVersionExchangeInfo() {
        VersionExchangeInfo versionExchangeInfo = this.mVersionExchangeInfo;
        return versionExchangeInfo == null ? this.mEmptyVersionExchangeInfo : versionExchangeInfo;
    }

    public boolean isConnectedAll(Collection<String> collection, SeMobileServiceSession seMobileServiceSession) {
        if (needExchangeInfoInit()) {
            SdkLog.m5784i(TAG, "isConnectedAll : needExchangeInfoInit");
            return false;
        }
        for (String str : collection) {
            if (TextUtils.isEmpty(str) || !this.mSupportedServices.contains(str)) {
                SdkLog.m5784i(TAG, "isConnectedAll : not support service : " + str);
            } else if (!getServiceHandler(str).isBound(seMobileServiceSession)) {
                SdkLog.m5784i(TAG, "isConnectedAll : is not bound " + str);
                return false;
            }
        }
        return true;
    }

    public boolean needExchangeInfoInit() {
        return this.mVersionExchangeInfo == null;
    }

    @Override // com.samsung.android.sdk.mobileservice.BindChangeListener
    public void onBindChanged(String str, BindState bindState, BindState bindState2) {
        if ((TextUtils.equals(CommonConstants.SERVICE_NAME_COMMON, str) || TextUtils.equals(CommonConstants.SERVICE_NAME_SA_COMMON, str)) && bindState2 == BindState.BOUND) {
            onCommonSvcBound(getServiceHandler(str));
        }
        for (BindChangeListener bindChangeListener : this.bindChangeListeners) {
            if (bindChangeListener != null) {
                bindChangeListener.onBindChanged(str, bindState, bindState2);
            }
        }
    }

    public void register(Collection<String> collection, SeMobileServiceSession seMobileServiceSession) {
        if (collection == null) {
            return;
        }
        Iterator<String> it = collection.iterator();
        while (it.hasNext()) {
            getServiceHandler(it.next()).register(seMobileServiceSession);
        }
    }

    public synchronized void removeBindChangeListener(BindChangeListener bindChangeListener) {
        if (bindChangeListener != null) {
            this.bindChangeListeners.remove(bindChangeListener);
        }
    }

    public void reset(boolean z, boolean z2, boolean z3) {
        SdkLog.m5784i(TAG, "reset");
        this.mIsStandAloneSA = z;
        this.mIsMobileServiceAgentInstalled = z2;
        this.mIsMobileServiceAgentEnabled = z3;
        this.mVersionExchangeInfo = null;
        this.mSupportedServices.clear();
    }

    public void unbindServices(Context context, Collection<String> collection, SeMobileServiceSession seMobileServiceSession) {
        if (collection == null) {
            return;
        }
        for (String str : collection) {
            ServiceHandler<?> serviceHandler = getServiceHandler(str);
            if (serviceHandler == null) {
                SdkLog.m5784i(TAG, "unbindServices : unknown service name : " + str);
            } else if (serviceHandler.unbindable(seMobileServiceSession)) {
                serviceHandler.unbindService(context, seMobileServiceSession);
            }
        }
        ServiceHandler[] serviceHandlerArr = {this.mAuthServiceHandler, this.mPlaceServiceHandler, this.mProfileServiceHandler, this.mSocialServiceHandler, this.mCommonServiceHandler, this.mSaCommonServiceHandler};
        for (int i = 0; i < 6; i++) {
            ServiceHandler serviceHandler2 = serviceHandlerArr[i];
            if (serviceHandler2 != null && serviceHandler2.bindState != BindState.UNBOUND) {
                return;
            }
        }
        SdkLog.m5782d(TAG, "all services unbound");
        reset(this.mIsStandAloneSA, this.mIsMobileServiceAgentInstalled, this.mIsMobileServiceAgentEnabled);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class ServiceHandler<T extends IInterface> implements ServiceConnection {
        private static final String TAG = "ServiceHandler";
        private final String action;
        private final String appId;
        Set<SeMobileServiceSession> bindRequestSet;
        private BindState bindState;
        private final BindChangeListener listener;
        private boolean needUnbindBeforeBinding;
        private final String packageName;
        T service;
        private final String serviceClassName;
        final String serviceName;

        private void log(String str) {
            StringBuilder sbM781w = AbstractC0541b.m781w(str, " : ");
            sbM781w.append(this.serviceName);
            SdkLog.m5784i(TAG, sbM781w.toString());
        }

        private void setBindState(BindState bindState) {
            log("setBindState : " + this.bindState + " to " + bindState);
            if (bindState == BindState.UNBOUND) {
                this.service = null;
            }
            BindState bindState2 = this.bindState;
            this.bindState = bindState;
            BindChangeListener bindChangeListener = this.listener;
            if (bindChangeListener != null) {
                bindChangeListener.onBindChanged(this.serviceName, bindState2, bindState);
            }
        }

        public abstract T asInterface(IBinder iBinder);

        public synchronized boolean bindService(Context context, SeMobileServiceSession seMobileServiceSession) {
            if (context == null) {
                log("bindService fail : context is null");
                return false;
            }
            if (TextUtils.isEmpty(this.packageName)) {
                log("bindService fail : unknown service");
                return false;
            }
            register(seMobileServiceSession);
            if (this.bindState != BindState.UNBOUND) {
                log("bindService : already requested : " + this.bindState);
                if (this.bindState != BindState.BOUND || this.service != null) {
                    return true;
                }
                log("state is bound but service is null.");
            }
            log("bindService");
            if (this.needUnbindBeforeBinding) {
                log("unbind first because of garbage connection");
                try {
                    context.unbindService(this);
                } catch (Exception e) {
                    SdkLog.m5783e(TAG, e.getMessage());
                }
                this.needUnbindBeforeBinding = false;
            }
            setBindState(BindState.BINDING);
            Intent intent = new Intent();
            if (!TextUtils.isEmpty(this.action)) {
                intent.setAction(this.action);
            }
            intent.putExtra("app_id", this.appId);
            intent.setClassName(this.packageName, this.serviceClassName);
            boolean zBindService = context.bindService(intent, this, 1);
            if (!zBindService) {
                log("bindService : request fail");
                this.bindRequestSet.remove(seMobileServiceSession);
            }
            return zBindService;
        }

        public T getService(SeMobileServiceSession seMobileServiceSession) throws NotConnectedException {
            T t = this.service;
            if (t != null) {
                return t;
            }
            throw new NotConnectedException(AbstractC0622a.m1170p(this.serviceName, " is not connected", new StringBuilder()));
        }

        public String getServiceName() {
            return this.serviceName;
        }

        public boolean isBound(SeMobileServiceSession seMobileServiceSession) {
            return this.bindState.isBound() && this.service != null;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            log("onServiceConnected");
            if (iBinder == null) {
                log("IBinder is null");
                setBindState(BindState.UNBOUND);
            } else {
                if (this.bindState == BindState.UNBOUND) {
                    log("service state is unbound.");
                    return;
                }
                this.service = (T) asInterface(iBinder);
                setBindState(BindState.BOUND);
                this.needUnbindBeforeBinding = false;
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            log("onServiceDisconnected");
            this.needUnbindBeforeBinding = true;
            setBindState(BindState.UNBOUND);
        }

        public void register(SeMobileServiceSession seMobileServiceSession) {
            this.bindRequestSet.add(seMobileServiceSession);
        }

        public synchronized void unbindService(Context context, SeMobileServiceSession seMobileServiceSession) {
            if (context == null) {
                log("unbindService fail : context is null");
                return;
            }
            if (TextUtils.isEmpty(this.packageName)) {
                log("unbindService fail : unknown service");
                return;
            }
            this.bindRequestSet.remove(seMobileServiceSession);
            if (this.bindState == BindState.UNBOUND) {
                log("unbindService : not bound");
                return;
            }
            if (!this.bindRequestSet.isEmpty()) {
                log("request unbindService but other sessions are still remain. Don't unbind.");
                return;
            }
            log("unbindService");
            try {
                context.unbindService(this);
            } catch (Exception e) {
                SdkLog.m5783e(TAG, e.getMessage());
            }
            setBindState(BindState.UNBOUND);
        }

        public boolean unbindable(SeMobileServiceSession seMobileServiceSession) {
            return this.bindState != BindState.UNBOUND;
        }

        private ServiceHandler() {
            this("", "unknown", "", "", "", null);
        }

        private ServiceHandler(String str, String str2, String str3, String str4, String str5, BindChangeListener bindChangeListener) {
            this.service = null;
            this.bindState = BindState.UNBOUND;
            this.needUnbindBeforeBinding = false;
            this.bindRequestSet = new HashSet();
            this.appId = str;
            this.serviceName = str2;
            this.packageName = str3;
            this.serviceClassName = str4;
            this.action = str5;
            this.listener = bindChangeListener;
        }
    }
}
