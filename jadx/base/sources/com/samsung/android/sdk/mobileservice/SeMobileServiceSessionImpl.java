package com.samsung.android.sdk.mobileservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.sdk.mobileservice.SeMobileServiceBindManager;
import com.samsung.android.sdk.mobileservice.SeMobileServiceSession;
import com.samsung.android.sdk.mobileservice.auth.IMobileServiceAuth;
import com.samsung.android.sdk.mobileservice.common.CommonConstants;
import com.samsung.android.sdk.mobileservice.common.CommonUtils;
import com.samsung.android.sdk.mobileservice.common.exception.NotConnectedException;
import com.samsung.android.sdk.mobileservice.place.IMobileServicePlace;
import com.samsung.android.sdk.mobileservice.profile.IMobileServiceProfile;
import com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial;
import com.samsung.android.sdk.mobileservice.util.SdkLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SeMobileServiceSessionImpl implements SeMobileServiceSession, BindChangeListener {
    private static final int CONNECTION_TIMEOUT = 20000;
    private static final int MSG_FAILURE = 2;
    private static final int MSG_SUCCESS = 1;
    private static final int MSG_TIMEOUT = 100;
    private static final String TAG = "SeMobileServiceSession";
    private String mAppId;
    private SeMobileServiceBindManager mBindManager;
    private SeMobileServiceSession.ConnectionResultCallback mConnectionResultCallback;
    private Context mContext;
    private ExecutorService mExecutorService;
    private boolean mIsMobileServiceAgentEnable;
    private boolean mIsMobileServiceAgentInstalled;
    private boolean mIsStandAloneSA;
    private HashSet<String> mAddedServices = new HashSet<>();
    private BroadcastReceiver mReceiver = null;
    private SeMobileServiceSession.ServiceConnectionListener mServiceConnectionListener = null;
    private SeMobileServiceSession.OnAgentUpdatedListener mOnAgentUpdatedListener = null;
    private VersionExchangeInfo mVersionExchangeInfo = null;
    private Handler mConnectionCallbackHandler = new Handler(Looper.getMainLooper()) { // from class: com.samsung.android.sdk.mobileservice.SeMobileServiceSessionImpl.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Message messageObtain = Message.obtain(message);
            int i = messageObtain.what;
            boolean z = true;
            if (i != 1) {
                if (i != 2) {
                    if (i != 100) {
                        return;
                    }
                    SeMobileServiceSessionImpl.this.onConnectFail(SessionErrorCode.CAUSE_CONNECT_TIMEOUT.getValue());
                    return;
                } else {
                    int i2 = messageObtain.arg1;
                    if (SeMobileServiceSessionImpl.this.mConnectionResultCallback != null) {
                        SeMobileServiceSessionImpl.this.mConnectionResultCallback.onFailure(i2);
                        return;
                    }
                    return;
                }
            }
            if (SeMobileServiceSessionImpl.this.mConnectionResultCallback == null) {
                return;
            }
            SessionErrorCode agentStatus = SeMobileServiceSessionImpl.this.mBindManager.getAgentStatus();
            if (agentStatus != SessionErrorCode.NO_PROBLEM) {
                SeMobileServiceSessionImpl.this.onConnectFail(agentStatus.getValue());
                return;
            }
            HashMap<String, Integer> map = new HashMap<>();
            for (String str : SeMobileServiceSessionImpl.this.mAddedServices) {
                int serviceStatus = SeMobileServiceSessionImpl.this.getVersionExchangeInfoOnSession().getServiceStatus(str);
                map.put(str, Integer.valueOf(serviceStatus));
                if (serviceStatus != 0) {
                    z = false;
                }
            }
            synchronized (this) {
                SeMobileServiceSessionImpl.this.mConnectionResultCallback.onSuccess(map, z);
            }
        }
    };

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class SesPackageEventReceiver extends BroadcastReceiver {
        private SesPackageEventReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            SdkLog.m5784i(SeMobileServiceSessionImpl.TAG, "onReceive - receive " + intent.getAction());
            Uri data = intent.getData();
            if (data == null) {
                return;
            }
            String schemeSpecificPart = data.getSchemeSpecificPart();
            if (!"android.intent.action.PACKAGE_ADDED".equals(intent.getAction())) {
                if ("android.intent.action.PACKAGE_CHANGED".equals(intent.getAction()) && "com.samsung.android.mobileservice".equals(schemeSpecificPart)) {
                    SeMobileServiceSessionImpl.this.handlePackageChanged(schemeSpecificPart);
                    return;
                }
                return;
            }
            if ("com.samsung.android.mobileservice".equals(schemeSpecificPart) || (SeMobileServiceSessionImpl.this.mIsStandAloneSA && "com.osp.app.signin".equals(schemeSpecificPart))) {
                SeMobileServiceSessionImpl.this.handlePackageAdded(context, schemeSpecificPart);
            }
        }
    }

    public SeMobileServiceSessionImpl(Context context, HashSet<String> hashSet, String str, SeMobileServiceSession.ConnectionResultCallback connectionResultCallback) {
        this.mContext = context.getApplicationContext();
        this.mConnectionResultCallback = connectionResultCallback;
        this.mAddedServices.addAll(hashSet);
        this.mAppId = str;
        this.mIsStandAloneSA = CommonUtils.isStandAloneSamsungAccountSupported(this.mContext);
        this.mIsMobileServiceAgentInstalled = SeMobileService.isAgentInstalled(getContext());
        boolean zIsAgentEnabled = SeMobileService.isAgentEnabled(getContext());
        this.mIsMobileServiceAgentEnable = zIsAgentEnabled;
        this.mBindManager = SeMobileServiceBindManager.get(this.mAppId, this.mIsStandAloneSA, this.mIsMobileServiceAgentInstalled, zIsAgentEnabled);
        this.mExecutorService = Executors.newCachedThreadPool();
    }

    private synchronized void connectInternal() {
        SdkLog.m5784i(TAG, "connectInternal" + SdkLog.getReference(this));
        setCallbackTimeout();
        this.mBindManager.addBindChangeListener(this);
        if (this.mBindManager.needExchangeInfoInit()) {
            SdkLog.m5784i(TAG, "needExchangeInfoInit : true on connectInternal");
            Set<String> commonServices = getCommonServices();
            if (this.mBindManager.bindServices(this.mContext, commonServices, this).size() != commonServices.size()) {
                onConnectFail(SessionErrorCode.CAUSE_AGENT_NOT_AVAILABLE.getValue());
                return;
            }
        }
        this.mBindManager.register(this.mAddedServices, this);
        if (isConnectedAll()) {
            onConnectComplete();
        } else {
            this.mBindManager.bindServices(this.mContext, this.mAddedServices, this);
        }
    }

    private synchronized void disconnectInternal() {
        SdkLog.m5782d(TAG, "disconnectInternal " + SdkLog.getReference(this));
        this.mBindManager.removeBindChangeListener(this);
        HashSet hashSet = new HashSet(getCommonServices());
        hashSet.addAll(this.mAddedServices);
        this.mBindManager.unbindServices(this.mContext, hashSet, this);
    }

    private Set<String> getCommonServices() {
        HashSet hashSet = new HashSet();
        if (this.mIsMobileServiceAgentInstalled && this.mIsMobileServiceAgentEnable) {
            hashSet.add(CommonConstants.SERVICE_NAME_COMMON);
        }
        if (this.mIsStandAloneSA) {
            hashSet.add(CommonConstants.SERVICE_NAME_SA_COMMON);
        }
        if (hashSet.isEmpty()) {
            SdkLog.m5784i(TAG, "getCommonServices is empty" + SdkLog.getReference(this));
        }
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public VersionExchangeInfo getVersionExchangeInfoOnSession() {
        VersionExchangeInfo versionExchangeInfo = this.mVersionExchangeInfo;
        if (versionExchangeInfo != null) {
            return versionExchangeInfo;
        }
        SdkLog.m5784i(TAG, "getVersionExchangeInfoOnSession: mVersionExchangeInfo is null");
        return this.mBindManager.mEmptyVersionExchangeInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlePackageAdded(Context context, String str) {
        SdkLog.m5784i(TAG, "handlePackageAdded - package is " + str);
        SeMobileServiceSession.OnAgentUpdatedListener onAgentUpdatedListener = this.mOnAgentUpdatedListener;
        if (onAgentUpdatedListener != null) {
            onAgentUpdatedListener.onAgentUpdated();
        }
        if ("com.samsung.android.mobileservice".equals(str)) {
            this.mIsMobileServiceAgentInstalled = SeMobileService.isAgentInstalled(getContext());
            this.mIsMobileServiceAgentEnable = SeMobileService.isAgentEnabled(getContext());
        }
        boolean zIsStandAloneSamsungAccountSupported = CommonUtils.isStandAloneSamsungAccountSupported(context);
        this.mIsStandAloneSA = zIsStandAloneSamsungAccountSupported;
        this.mBindManager.reset(zIsStandAloneSamsungAccountSupported, this.mIsMobileServiceAgentInstalled, this.mIsMobileServiceAgentEnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlePackageChanged(String str) {
        SdkLog.m5784i(TAG, "handlePackageChanged - package is " + str);
        boolean zIsAgentEnabled = SeMobileService.isAgentEnabled(getContext());
        if (zIsAgentEnabled != this.mIsMobileServiceAgentEnable) {
            this.mIsMobileServiceAgentEnable = zIsAgentEnabled;
            this.mBindManager.reset(this.mIsStandAloneSA, this.mIsMobileServiceAgentInstalled, zIsAgentEnabled);
        }
    }

    private SessionErrorCode isAgentAvailable() {
        this.mIsMobileServiceAgentInstalled = SeMobileService.isAgentInstalled(getContext());
        this.mIsMobileServiceAgentEnable = SeMobileService.isAgentEnabled(getContext());
        SdkLog.m5782d(TAG, "SESInstalled:" + this.mIsMobileServiceAgentInstalled + ", SESEnabled:" + this.mIsMobileServiceAgentEnable);
        if (this.mIsStandAloneSA) {
            if (!SeMobileService.isSaAgentInstalled(getContext())) {
                return SessionErrorCode.CAUSE_AGENT_NOT_INSTALLED;
            }
        } else {
            if (!this.mIsMobileServiceAgentInstalled) {
                return SessionErrorCode.CAUSE_AGENT_NOT_INSTALLED;
            }
            if (!this.mIsMobileServiceAgentEnable) {
                return SessionErrorCode.CAUSE_AGENT_DISABLED;
            }
        }
        return SessionErrorCode.NO_PROBLEM;
    }

    private boolean isConnectedAll() {
        return this.mBindManager.isConnectedAll(this.mAddedServices, this);
    }

    private void onAddedSvcBindChanged(final String str, SeMobileServiceBindManager.BindState bindState, SeMobileServiceBindManager.BindState bindState2) {
        SeMobileServiceBindManager.BindState bindState3 = SeMobileServiceBindManager.BindState.BINDING;
        if ((bindState == bindState3 && bindState2 == SeMobileServiceBindManager.BindState.BOUND) || bindState2 == bindState3) {
            return;
        }
        final int i = bindState2 == SeMobileServiceBindManager.BindState.BOUND ? 1 : -1;
        this.mExecutorService.execute(new Runnable() { // from class: com.samsung.android.sdk.mobileservice.SeMobileServiceSessionImpl.2
            @Override // java.lang.Runnable
            public void run() {
                if (SeMobileServiceSessionImpl.this.mServiceConnectionListener != null) {
                    SeMobileServiceSessionImpl.this.mServiceConnectionListener.onChanged(i, str);
                }
            }
        });
    }

    private void onConnectComplete() {
        if (isConnectedAll()) {
            if (this.mBindManager.needExchangeInfoInit()) {
                SdkLog.m5784i(TAG, "onConnectComplete : need exchange info " + SdkLog.getReference(this));
            } else {
                SdkLog.m5784i(TAG, "onConnectComplete" + SdkLog.getReference(this));
                this.mVersionExchangeInfo = this.mBindManager.getVersionExchangeInfo();
                sendSuccessCallback();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onConnectFail(int i) {
        StringBuilder sbM778t = AbstractC0541b.m778t(i, "onConnectFail : ", ":");
        sbM778t.append(SdkLog.getReference(this));
        SdkLog.m5784i(TAG, sbM778t.toString());
        disconnectInternal();
        sendErrorCallback(i);
    }

    private void registerAgentUpdateReceiver() {
        if (this.mReceiver == null) {
            SdkLog.m5782d(TAG, "registerReceiver");
            this.mReceiver = new SesPackageEventReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
            intentFilter.addAction("android.intent.action.PACKAGE_CHANGED");
            intentFilter.addDataScheme("package");
            intentFilter.addDataSchemeSpecificPart("com.samsung.android.mobileservice", 0);
            intentFilter.addDataSchemeSpecificPart("com.osp.app.signin", 0);
            this.mContext.registerReceiver(this.mReceiver, intentFilter);
        }
    }

    private void sendErrorCallback(int i) {
        this.mConnectionCallbackHandler.removeMessages(100);
        Handler handler = this.mConnectionCallbackHandler;
        handler.sendMessage(handler.obtainMessage(2, i, 0));
    }

    private void sendSuccessCallback() {
        if (this.mConnectionCallbackHandler.hasMessages(100)) {
            this.mConnectionCallbackHandler.removeMessages(100);
            Handler handler = this.mConnectionCallbackHandler;
            handler.sendMessage(handler.obtainMessage(1));
        }
    }

    private void setCallbackTimeout() {
        this.mConnectionCallbackHandler.removeMessages(100);
        Handler handler = this.mConnectionCallbackHandler;
        handler.sendMessageDelayed(handler.obtainMessage(100), 20000L);
    }

    private void unregisterAgentUpdateReceiver() {
        if (this.mReceiver != null) {
            SdkLog.m5784i(TAG, "unregisterReceiver Receiver");
            this.mContext.unregisterReceiver(this.mReceiver);
            this.mReceiver = null;
        }
    }

    @Override // com.samsung.android.sdk.mobileservice.SeMobileServiceSession
    public void connect() {
        SdkLog.m5784i(TAG, "connect " + SdkLog.getReference(this));
        SessionErrorCode sessionErrorCodeIsAgentAvailable = isAgentAvailable();
        if (sessionErrorCodeIsAgentAvailable == SessionErrorCode.NO_PROBLEM) {
            registerAgentUpdateReceiver();
            connectInternal();
            return;
        }
        sendErrorCallback(sessionErrorCodeIsAgentAvailable.getValue());
        SdkLog.m5784i(TAG, "MobileService agent is not installed, errorCode:" + sessionErrorCodeIsAgentAvailable.getValue() + " : " + SdkLog.getReference(this));
    }

    @Override // com.samsung.android.sdk.mobileservice.SeMobileServiceSession
    public void disconnect() {
        SdkLog.m5784i(TAG, "disconnect " + SdkLog.getReference(this));
        try {
            unregisterAgentUpdateReceiver();
        } catch (Exception unused) {
            SdkLog.m5784i(TAG, "receiver is not registered. " + SdkLog.getReference(this));
        }
        this.mVersionExchangeInfo = null;
        disconnectInternal();
        SdkLog.m5784i(TAG, "disconnect done " + SdkLog.getReference(this));
    }

    public void finalize() throws Throwable {
        super.finalize();
    }

    public String getAppId() {
        return this.mAppId;
    }

    public IMobileServiceAuth getAuthService() {
        return (IMobileServiceAuth) this.mBindManager.getAuthServiceHandler().getService(this);
    }

    public int getAuthorized() {
        Bundle deviceAuthInfoCached;
        int i = 0;
        try {
            try {
            } catch (NotConnectedException e) {
                e = e;
                SdkLog.m5785s(e);
                StringBuilder sbM778t = AbstractC0541b.m778t(i, "getAuthorized:", ":");
                sbM778t.append(SdkLog.getReference(this));
                SdkLog.m5784i(TAG, sbM778t.toString());
                return i;
            }
        } catch (RemoteException e2) {
            e = e2;
            SdkLog.m5785s(e);
            StringBuilder sbM778t2 = AbstractC0541b.m778t(i, "getAuthorized:", ":");
            sbM778t2.append(SdkLog.getReference(this));
            SdkLog.m5784i(TAG, sbM778t2.toString());
            return i;
        } catch (NullPointerException e3) {
            e = e3;
            SdkLog.m5785s(e);
            StringBuilder sbM778t22 = AbstractC0541b.m778t(i, "getAuthorized:", ":");
            sbM778t22.append(SdkLog.getReference(this));
            SdkLog.m5784i(TAG, sbM778t22.toString());
            return i;
        }
        if (getAuthService() == null) {
            SdkLog.m5784i(TAG, "getAuthService() return null! " + SdkLog.getReference(this));
            return 0;
        }
        Bundle authInfoCached = getAuthService().getAuthInfoCached();
        if (authInfoCached != null && !authInfoCached.isEmpty()) {
            if (!CommonUtils.isStandAloneSamsungAccountSupported(this.mContext)) {
                deviceAuthInfoCached = getAuthService().getDeviceAuthInfoCached();
            } else {
                if (!this.mIsMobileServiceAgentInstalled || !this.mIsMobileServiceAgentEnable) {
                    return 2;
                }
                try {
                    deviceAuthInfoCached = getSocialService().getDeviceAuthInfoCached();
                } catch (NotConnectedException unused) {
                    SdkLog.m5784i(TAG, "getSocialService() return null! " + SdkLog.getReference(this));
                    return 1;
                }
            }
            i = (deviceAuthInfoCached == null || deviceAuthInfoCached.isEmpty()) ? 1 : 3;
        }
        StringBuilder sbM778t222 = AbstractC0541b.m778t(i, "getAuthorized:", ":");
        sbM778t222.append(SdkLog.getReference(this));
        SdkLog.m5784i(TAG, sbM778t222.toString());
        return i;
    }

    public Context getContext() {
        return this.mContext;
    }

    @Override // com.samsung.android.sdk.mobileservice.SeMobileServiceSession
    public long getLatestAgentVersionInGalaxyApps() {
        SdkLog.m5784i(TAG, "getLatestSaAgentVersionInGalaxyApps");
        return getVersionExchangeInfoOnSession().getAgentLastestVersionInGalaxyApps();
    }

    @Override // com.samsung.android.sdk.mobileservice.SeMobileServiceSession
    public long getLatestSaAgentVersionInGalaxyApps() {
        SdkLog.m5784i(TAG, "getLatestSaAgentVersionInGalaxyApps");
        return getVersionExchangeInfoOnSession().getSaAgentLastestVersionInGalaxyApps();
    }

    public IMobileServicePlace getPlaceService() {
        return (IMobileServicePlace) this.mBindManager.getPlaceServiceHandler().getService(this);
    }

    public IMobileServiceProfile getProfileService() {
        return (IMobileServiceProfile) this.mBindManager.getProfileServiceHandler().getService(this);
    }

    @Override // com.samsung.android.sdk.mobileservice.SeMobileServiceSession
    public long getSamsungAccountAgentVersion() {
        SdkLog.m5784i(TAG, "getSamsungAccountAgentVersion");
        return getVersionExchangeInfoOnSession().getSaAgentVersion();
    }

    @Override // com.samsung.android.sdk.mobileservice.SeMobileServiceSession
    public long getSamsungExperienceServiceAgentVersion() {
        SdkLog.m5784i(TAG, "getSamsungExperienceServiceAgentVersion");
        return getVersionExchangeInfoOnSession().getSesVersion();
    }

    public int getSeMobileServiceSupportApiVersion(String str) {
        return getVersionExchangeInfoOnSession().getApiVersion(str);
    }

    @Override // com.samsung.android.sdk.mobileservice.SeMobileServiceSession
    public int getServiceStatus(String str) {
        return getVersionExchangeInfoOnSession().getServiceStatus(str);
    }

    public IMobileServiceSocial getSocialService() {
        return (IMobileServiceSocial) this.mBindManager.getSocialServiceHandler().getService(this);
    }

    @Override // com.samsung.android.sdk.mobileservice.SeMobileServiceSession
    public boolean isAddedService(String str) {
        return this.mAddedServices.contains(str);
    }

    public boolean isAgentEnabled() {
        return this.mIsMobileServiceAgentEnable;
    }

    public boolean isAgentInstalled() {
        return this.mIsMobileServiceAgentInstalled;
    }

    public boolean isNoMoreSupportedSemsAgentVersion(int i) {
        SdkLog.m5782d(TAG, "isNoMoreSupportedSemsAgentVersion");
        boolean z = getVersionExchangeInfoOnSession().getSesVersion() >= i;
        if (z) {
            SdkLog.m5782d(TAG, "isNoMoreSupportedSemsAgentVersion: not support version");
        }
        return z;
    }

    @Override // com.samsung.android.sdk.mobileservice.SeMobileServiceSession
    public boolean isServiceConnected(String str) {
        return this.mBindManager.getServiceHandler(str).isBound(this);
    }

    @Override // com.samsung.android.sdk.mobileservice.SeMobileServiceSession
    public boolean isSessionConnected() {
        return isConnectedAll();
    }

    @Override // com.samsung.android.sdk.mobileservice.SeMobileServiceSession
    public boolean isSupportedApi(String str) {
        return getSeMobileServiceSupportApiVersion(str) > 0;
    }

    public boolean isSupportedSaAgentVersion(int i) {
        SdkLog.m5782d(TAG, "isSupportedSaAgentVersion");
        boolean z = getVersionExchangeInfoOnSession().getSaAgentVersion() >= i;
        if (!z) {
            SdkLog.m5782d(TAG, "isSupportedSaAgentVersion: not support version");
        }
        return z;
    }

    public boolean isSupportedSemsAgentVersionBetween(int i, int i2) {
        SdkLog.m5782d(TAG, "isSupportedSemsAgentVersionBetween - more than : " + i + ", less than : " + i2);
        int sesVersion = getVersionExchangeInfoOnSession().getSesVersion();
        boolean z = sesVersion >= i && sesVersion < i2;
        if (!z) {
            SdkLog.m5782d(TAG, "isSupportedSemsAgentVersionBetween: not between version : " + i + ", less than : " + i2);
        }
        return z;
    }

    public boolean isSupportedSemsAgentVersionMoreThan(int i) {
        SdkLog.m5782d(TAG, "isSupportedSemsAgentVersionMoreThan - more than : " + i);
        boolean z = getVersionExchangeInfoOnSession().getSesVersion() >= i;
        if (!z) {
            SdkLog.m5782d(TAG, "isSupportedSemsAgentVersionMoreThan: not more version : " + i);
        }
        return z;
    }

    @Override // com.samsung.android.sdk.mobileservice.BindChangeListener
    public void onBindChanged(String str, SeMobileServiceBindManager.BindState bindState, SeMobileServiceBindManager.BindState bindState2) {
        if (this.mAddedServices.contains(str)) {
            onAddedSvcBindChanged(str, bindState, bindState2);
        }
        if (bindState2 == SeMobileServiceBindManager.BindState.BOUND) {
            onConnectComplete();
        }
    }

    @Override // com.samsung.android.sdk.mobileservice.SeMobileServiceSession
    public void reconnect() {
        SdkLog.m5784i(TAG, "reconnect " + SdkLog.getReference(this));
        if (!isConnectedAll()) {
            connectInternal();
            return;
        }
        SdkLog.m5784i(TAG, "reconnect : already connected" + SdkLog.getReference(this));
    }

    @Override // com.samsung.android.sdk.mobileservice.SeMobileServiceSession
    public void setOnAgentUpdatedListener(SeMobileServiceSession.OnAgentUpdatedListener onAgentUpdatedListener) {
        this.mOnAgentUpdatedListener = onAgentUpdatedListener;
    }

    @Override // com.samsung.android.sdk.mobileservice.SeMobileServiceSession
    public void setSessionListener(SeMobileServiceSession.ServiceConnectionListener serviceConnectionListener) {
        this.mServiceConnectionListener = serviceConnectionListener;
    }
}
