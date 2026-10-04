package com.samsung.android.app.notes.sync.importing.core;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
class NetworkStatusManager {
    private static final NetworkStatusManager ourInstance = new NetworkStatusManager();
    private static boolean isNetworkConnected = false;
    private static boolean isWiFiConnected = false;

    private NetworkStatusManager() {
    }

    public static NetworkStatusManager getInstance() {
        return ourInstance;
    }

    public static boolean isNetworkConnected() {
        return isNetworkConnected;
    }

    public static boolean isWiFiConnected() {
        return isWiFiConnected;
    }

    public static void setNetworkConnected(boolean z) {
        isNetworkConnected = z;
    }

    public static void setWiFiConnected(boolean z) {
        isWiFiConnected = z;
    }
}
