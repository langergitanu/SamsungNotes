package com.samsung.android.support.senl.p148nt.coedit.common;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.ApplicationManager;
import com.samsung.android.support.senl.p148nt.coedit.log.CoeditLogger;
import com.samsung.android.support.senl.p148nt.coedit.utils.CoeditUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CoeditNetworkManager {
    private static final String TAG = "CoeditNetworkManager";
    private static CoeditNetworkManager sInstance;
    private String mHandledNetwork;
    private final Map<String, Callback> mNetworkCallbacks = new ConcurrentHashMap();
    private final ConnectivityManager.NetworkCallback mCallBack = new ConnectivityManager.NetworkCallback() { // from class: com.samsung.android.support.senl.nt.coedit.common.CoeditNetworkManager.1
        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(@NonNull Network network) {
            String string = network.toString();
            if (!TextUtils.isEmpty(CoeditNetworkManager.this.mHandledNetwork) && CoeditNetworkManager.this.mHandledNetwork.equals(string)) {
                CoeditLogger.m8923i(CoeditNetworkManager.TAG, "[Network] onAvailable(), skip, already Handle [" + CoeditNetworkManager.this.mHandledNetwork + "]");
                return;
            }
            if (!TextUtils.isEmpty(CoeditNetworkManager.this.mHandledNetwork)) {
                CoeditLogger.m8923i(CoeditNetworkManager.TAG, "[Network] onAvailable(), ignore, Change HandledNetwork [" + CoeditNetworkManager.this.mHandledNetwork + "] to [" + string + "], but still connected network");
                CoeditNetworkManager.this.mHandledNetwork = string;
                return;
            }
            CoeditLogger.m8923i(CoeditNetworkManager.TAG, "[Network] onAvailable(), Change HandledNetwork [" + CoeditNetworkManager.this.mHandledNetwork + "] to [" + string + "]");
            CoeditNetworkManager.this.mHandledNetwork = string;
            if (CoeditUtils.isCoeditDataNetworkAvailable()) {
                Iterator it = CoeditNetworkManager.this.mNetworkCallbacks.values().iterator();
                while (it.hasNext()) {
                    ((Callback) it.next()).onAvailable();
                }
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(@NonNull Network network) {
            String string = network.toString();
            if (TextUtils.isEmpty(CoeditNetworkManager.this.mHandledNetwork) || !CoeditNetworkManager.this.mHandledNetwork.equals(string)) {
                CoeditLogger.m8923i(CoeditNetworkManager.TAG, "[Network] onLost(), ignore, network mismatched, HandleNetwork: [" + CoeditNetworkManager.this.mHandledNetwork + "], LostNetwork: [" + string + "]");
                return;
            }
            AbstractC8014b.m7223y("[Network] onLost(), network: ", string, CoeditNetworkManager.TAG);
            CoeditNetworkManager.this.mHandledNetwork = "";
            if (CoeditUtils.isCoeditDataNetworkAvailable()) {
                return;
            }
            Iterator it = CoeditNetworkManager.this.mNetworkCallbacks.values().iterator();
            while (it.hasNext()) {
                ((Callback) it.next()).onLost();
            }
        }
    };

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Callback {
        void onAvailable();

        void onLost();
    }

    private CoeditNetworkManager() {
    }

    public static synchronized CoeditNetworkManager getInstance() {
        try {
            if (sInstance == null) {
                sInstance = new CoeditNetworkManager();
            }
        } catch (Throwable th) {
            throw th;
        }
        return sInstance;
    }

    public void registerNetworkCallback(String str, Callback callback) {
        AbstractC8014b.m7223y("registerNetworkCallback, tag: ", str, TAG);
        if (this.mNetworkCallbacks.isEmpty()) {
            ConnectivityManager connectivityManager = (ConnectivityManager) ApplicationManager.getInstance().getAppContext().getSystemService("connectivity");
            NetworkRequest networkRequestBuild = new NetworkRequest.Builder().addTransportType(1).addTransportType(0).addCapability(12).build();
            Network activeNetwork = connectivityManager.getActiveNetwork();
            if (activeNetwork != null) {
                String string = activeNetwork.toString();
                AbstractC8014b.m7223y("[Network] CoeditNetworkManager, activeNetwork: ", string, TAG);
                this.mHandledNetwork = string;
            }
            connectivityManager.registerNetworkCallback(networkRequestBuild, this.mCallBack);
        }
        this.mNetworkCallbacks.put(str, callback);
    }

    public void unregisterNetworkCallback(String str) {
        Callback callbackRemove = this.mNetworkCallbacks.remove(str);
        if (this.mNetworkCallbacks.isEmpty()) {
            try {
                ((ConnectivityManager) ApplicationManager.getInstance().getAppContext().getSystemService("connectivity")).unregisterNetworkCallback(this.mCallBack);
            } catch (IllegalArgumentException e) {
                CoeditLogger.m8920e(TAG, "unregisterNetworkCallback : " + e.getMessage());
            }
            AbstractC8014b.m7223y("remove all Callback, tag: ", str, TAG);
        }
        if (callbackRemove != null) {
            AbstractC8014b.m7223y("unregisterNetworkCallback, tag: ", str, TAG);
            return;
        }
        CoeditLogger.m8924w(TAG, "unregisterNetworkCallback, tag: " + str + " is not registered");
    }
}
