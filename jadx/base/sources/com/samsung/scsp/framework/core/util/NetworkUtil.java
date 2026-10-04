package com.samsung.scsp.framework.core.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import androidx.work.multiprocess.C4148a;
import com.samsung.scsp.error.FaultBarrier;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class NetworkUtil {
    /* JADX WARN: Multi-variable type inference failed */
    private static boolean isConnected(Context context, int i) {
        return ((Boolean) FaultBarrier.get(new C4148a(context, i, 8), Boolean.FALSE).obj).booleanValue();
    }

    public static boolean isEthernetConnected(Context context) {
        return isConnected(context, 3);
    }

    public static boolean isMobileConnected(Context context) {
        return isConnected(context, 0);
    }

    private static boolean isWiFiConnected(Context context) {
        return isConnected(context, 1);
    }

    public static boolean isWifiOrEthernetConnected(Context context) {
        return isWiFiConnected(context) || isEthernetConnected(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean lambda$isConnected$0(Context context, int i) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
        return networkCapabilities != null ? Boolean.valueOf(networkCapabilities.hasTransport(i)) : Boolean.FALSE;
    }
}
