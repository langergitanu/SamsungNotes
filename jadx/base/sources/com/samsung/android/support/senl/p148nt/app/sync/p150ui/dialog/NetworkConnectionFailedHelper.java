package com.samsung.android.support.senl.p148nt.app.sync.p150ui.dialog;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.TrafficStats;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.text.TextUtils;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p148nt.app.sync.p150ui.notification.SyncNotificationHelper;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import java.lang.reflect.Field;
import java.util.List;
import p042J1.C0145c;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class NetworkConnectionFailedHelper {
    public static final String NETWORK_CONNECTION_ACTION = "NETWORK_CONNECTION_ACTION";
    public static final String NETWORK_CONNECTION_FAILED_TYPE = "NETWORK_CONNECTION_FAILED_TYPE";
    public static final String NETWORK_CONNECTION_SYNC_TYPE = "NETWORK_CONNECTION_SYNC_TYPE";
    public static final String NETWORK_RECONNECTION_RESULT_TYPE = "NETWORK_RECONNECTION_RESULT_TYPE";
    public static final String REQUEST_APP_PROCESS_INFO_NAME = "processState";
    private static final String TAG = "NT$NetworkConnectionFailedHelper";
    private static final NetworkConnectionFailedHelper mInstance = new NetworkConnectionFailedHelper();
    private NetworkConnectionFailedDialog mCurrentDialog = null;

    private NetworkConnectionFailedHelper() {
    }

    public static NetworkConnectionFailedHelper getInstance() {
        return mInstance;
    }

    private String getPacakageNameLollipop(Context context) {
        try {
            Field declaredField = ActivityManager.RunningAppProcessInfo.class.getDeclaredField(REQUEST_APP_PROCESS_INFO_NAME);
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService(Constants.StringExtra.EXECUTE_TYPE_ACTIVITY)).getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return null;
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.importance <= 100 && runningAppProcessInfo.importanceReasonCode == 0 && declaredField.getInt(runningAppProcessInfo) == 2) {
                    return runningAppProcessInfo.pkgList[0];
                }
            }
            return null;
        } catch (IllegalAccessException | NoSuchFieldException | SecurityException unused) {
            Debugger.m8609e(TAG, "getPacakageNameLollipop() : Failed with NoSuchFieldException | IllegalAccessException | SecurityException");
            return null;
        } catch (Exception unused2) {
            Debugger.m8609e(TAG, "getPacakageNameLollipop() : Failed with Exception");
            return null;
        }
    }

    private void startActivity(Context context, int i, int i2) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context.getApplicationContext(), (Class<?>) NetworkConnectionFailedDialog.class);
        intent.putExtra(NETWORK_CONNECTION_FAILED_TYPE, Integer.toString(i));
        intent.putExtra(NETWORK_CONNECTION_SYNC_TYPE, Integer.toString(i2));
        boolean z = true;
        if (context instanceof Activity) {
            Debugger.m8607d(TAG, "startActivity() - context is instance of activity (using FLAG_ACTIVITY_SINGLE_TOP)");
            intent.addFlags(536870912);
        } else {
            Debugger.m8607d(TAG, "startActivity() - context is instance of non-activity");
            intent.setFlags(268435456);
            String currentTaskPacakageName = getCurrentTaskPacakageName(context);
            if (TextUtils.isEmpty(currentTaskPacakageName) || !C0145c.m330o().equalsIgnoreCase(currentTaskPacakageName)) {
                Debugger.m8607d(TAG, "\t current package not " + C0145c.m330o() + " (using FLAG_ACTIVITY_MULTIPLE_TASK)");
                intent.addFlags(1216348160);
                z = false;
            } else {
                Debugger.m8607d(TAG, "\t current package is " + C0145c.m330o() + " (using FLAG_ACTIVITY_SINGLE_TOP)");
                intent.addFlags(536870912);
            }
        }
        intent.putExtra(NetworkConnectionFailedDialog.IS_RUN_ON_ACTIVITY, Boolean.toString(z));
        if (context.getPackageManager().queryIntentActivities(intent, 0).size() > 0) {
            context.startActivity(intent);
        } else {
            Debugger.m8609e(TAG, "startActivity() : NetworkConnectionFailedDialog Activity is not found!");
        }
    }

    public String getCurrentTaskPacakageName(Context context) {
        return getPacakageNameLollipop(context);
    }

    public void postToast(final Context context, final String str) {
        if (context == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.sync.ui.dialog.NetworkConnectionFailedHelper.1
            @Override // java.lang.Runnable
            public void run() {
                ToastHandler.show(context, str, 1);
            }
        });
    }

    public void reConnectedToMobile(Context context) {
        if (context == null) {
            return;
        }
        synchronized (mInstance) {
            try {
                Debugger.m8607d(TAG, "reConnectedToMobile()");
                NetworkConnectionFailedDialog networkConnectionFailedDialog = this.mCurrentDialog;
                if (networkConnectionFailedDialog != null && (networkConnectionFailedDialog.getConnectionType() == 101 || this.mCurrentDialog.getConnectionType() == 102 || this.mCurrentDialog.getConnectionType() == 103 || this.mCurrentDialog.getConnectionType() == 104)) {
                    this.mCurrentDialog.finish();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void reConnectedToWAN(Context context) {
        if (context == null) {
            return;
        }
        synchronized (mInstance) {
            try {
                Debugger.m8607d(TAG, "reConnectedToWAN()");
                NetworkConnectionFailedDialog networkConnectionFailedDialog = this.mCurrentDialog;
                if (networkConnectionFailedDialog != null) {
                    networkConnectionFailedDialog.finish();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean reachedToMaxBytes(Context context) {
        boolean z = false;
        if (context == null) {
            return false;
        }
        long mobileRxBytes = TrafficStats.getMobileRxBytes();
        if (mobileRxBytes <= 0) {
            return false;
        }
        Long maxBytesOverMobile = DownloadManager.getMaxBytesOverMobile(context);
        Debugger.m8607d(TAG, String.format("[Connection] reachedToMaxBytes(getMaxBytesOverMobile()) : %d / %d", Long.valueOf(mobileRxBytes), maxBytesOverMobile));
        if (maxBytesOverMobile != null && mobileRxBytes > maxBytesOverMobile.longValue()) {
            z = true;
        }
        Long recommendedMaxBytesOverMobile = DownloadManager.getRecommendedMaxBytesOverMobile(context);
        Debugger.m8607d(TAG, String.format("[Connection] reachedToMaxBytes(getRecommendedMaxBytesOverMobile()) : %d / %d", Long.valueOf(mobileRxBytes), maxBytesOverMobile));
        boolean z2 = (recommendedMaxBytesOverMobile == null || mobileRxBytes <= recommendedMaxBytesOverMobile.longValue()) ? z : true;
        AbstractC4539a.m3190D("reachedToMaxBytes() : ", Boolean.toString(z2), TAG);
        return z2;
    }

    public void setCurrentDialog(NetworkConnectionFailedDialog networkConnectionFailedDialog) {
        synchronized (mInstance) {
            this.mCurrentDialog = networkConnectionFailedDialog;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x004a A[Catch: all -> 0x0039, TryCatch #0 {all -> 0x0039, blocks: (B:6:0x000b, B:14:0x001a, B:15:0x001d, B:20:0x004d, B:18:0x003b, B:19:0x004a), top: B:24:0x000b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void show(Context context, int i) {
        Debugger.m8615i(TAG, Constants.IntentExtraValue.SHOW);
        if (context == null) {
            return;
        }
        synchronized (this) {
            try {
                int iUpdateCurrentType = updateCurrentType(context, i);
                if (iUpdateCurrentType != 0 && iUpdateCurrentType != 1 && iUpdateCurrentType != 2 && iUpdateCurrentType != 3) {
                    switch (iUpdateCurrentType) {
                        case 99:
                            NetworkConnectionFailedType.getInstance();
                            postToast(context, context.getString(NetworkConnectionFailedType.getResIdToast(iUpdateCurrentType)));
                            break;
                        case 100:
                        case 101:
                        case 102:
                        case 103:
                        case 104:
                            break;
                        default:
                            new SyncNotificationHelper(context).cancelNetworkErrNotification();
                            Debugger.m8607d(TAG, String.format("show() : incorrectly connection type(%d)", Integer.valueOf(iUpdateCurrentType)));
                            break;
                    }
                } else {
                    startActivity(context, iUpdateCurrentType, i);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int updateCurrentType(Context context, int i) {
        Debugger.m8615i(TAG, "updateCurrentType()");
        if (C0145c.m339x(context)) {
            Debugger.m8607d(TAG, "updateCurrentType() NetworkUtil.isNonPhone(context) == true");
            if (C0145c.m334s(context)) {
                Debugger.m8607d(TAG, "updateCurrentType() - CONNECTED_TO_WAN -");
                return 0;
            }
            Debugger.m8607d(TAG, "updateCurrentType() - WIFI_ONLY_MODELS_CONNECTION_FAILED -");
            return 99;
        }
        if (i == 1 && C0145c.m299G(context) && !C0145c.m298F(context)) {
            Debugger.m8607d(TAG, "updateCurrentType() - WIFI_NOT_AVAILABLE_ON_WIFI_ONLY -");
            return 100;
        }
        if (C0145c.m298F(context)) {
            Debugger.m8607d(TAG, "updateCurrentType() NetworkUtil.isWifiConnected(context) == true");
            Debugger.m8607d(TAG, "updateCurrentType() - CONNECTED_TO_WAN -");
            return 0;
        }
        if (C0145c.m335t(context)) {
            Debugger.m8607d(TAG, "updateCurrentType() NetworkUtil.isFlightMode(context) == true");
            Debugger.m8607d(TAG, "updateCurrentType() - FLIGHT_MODE -");
            return 101;
        }
        if (!C0145c.m334s(context)) {
            Debugger.m8607d(TAG, "updateCurrentType() NetworkUtil.isDataCapable(context) == false");
            Debugger.m8607d(TAG, "updateCurrentType() - MOBILE_DATA_TURNED_OFF -");
            return 102;
        }
        if (!C0145c.m293A(context)) {
            if (!reachedToMaxBytes(context)) {
                Debugger.m8607d(TAG, "updateCurrentType() - MOBILE_DATA_WARNING -");
                return 3;
            }
            Debugger.m8607d(TAG, "updateCurrentType() reachedToMaxBytes(context) == true");
            Debugger.m8607d(TAG, "updateCurrentType() - DATA_REACHED_TO_LIMIT -");
            return 104;
        }
        Debugger.m8607d(TAG, "updateCurrentType() Roaming");
        if (context == null) {
            Debugger.m8609e("SC/NetworkUtils", "isDataRoamingEnabled() : context is null");
        } else {
            z = Settings.Global.getInt(context.getApplicationContext().getContentResolver(), "data_roaming", 0) == 1;
            if (C0145c.f408j != z) {
                C0145c.f408j = z;
                Debugger.m8615i("SC/NetworkUtils", "isDataRoamingEnabled() : connection enabled = " + C0145c.f408j);
            }
            z = C0145c.f408j;
        }
        if (z) {
            Debugger.m8607d(TAG, "updateCurrentType() - ROAM_DATA_WARNING -");
            return 2;
        }
        Debugger.m8607d(TAG, "updateCurrentType() \tNetworkUtil.isDataRoamingEnabled(context) == false");
        Debugger.m8607d(TAG, "updateCurrentType() - DATA_ROAMING_IS_OFF -");
        return 103;
    }
}
