package com.samsung.android.sdk.smp.interfaceimpl;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.sdk.smp.BuildConfig;
import com.samsung.android.sdk.smp.SmpCallback;
import com.samsung.android.sdk.smp.SmpConfiguration;
import com.samsung.android.sdk.smp.SmpConstants;
import com.samsung.android.sdk.smp.SmpException;
import com.samsung.android.sdk.smp.SmpInitOptions;
import com.samsung.android.sdk.smp.SmpListeners;
import com.samsung.android.sdk.smp.SmpResult;
import com.samsung.android.sdk.smp.common.constants.Constants;
import com.samsung.android.sdk.smp.common.constants.FeedbackDetailConstants;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.sdk.smp.common.exception.IErrors;
import com.samsung.android.sdk.smp.common.exception.InternalException;
import com.samsung.android.sdk.smp.common.interfaces.ListenerManager;
import com.samsung.android.sdk.smp.common.preference.InitOptionsHolder;
import com.samsung.android.sdk.smp.common.preference.PrefManager;
import com.samsung.android.sdk.smp.common.sharedvariable.SharedMemoryVariableManager;
import com.samsung.android.sdk.smp.common.util.BroadcastUtil;
import com.samsung.android.sdk.smp.common.util.DeviceInfoUtil;
import com.samsung.android.sdk.smp.common.util.SmpLog;
import com.samsung.android.sdk.smp.data.DataManager;
import com.samsung.android.sdk.smp.marketing.FeedbackManager;
import com.samsung.android.sdk.smp.marketing.Marketing;
import com.samsung.android.sdk.smp.marketing.MarketingManager;
import com.samsung.android.sdk.smp.push.PushHelper;
import com.samsung.android.sdk.smp.push.ack.AckManager;
import com.samsung.android.sdk.smp.task.SMarketingTask;
import com.samsung.android.sdk.smp.task.STask;
import com.samsung.android.sdk.smp.task.STaskDispatcher;
import com.samsung.android.sdk.smp.testmode.TestModeChecker;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SmpInterfaceImpl {
    private static final int PRINT_TOKEN_LENGTH = 5;
    private static final String TAG = "SmpInterfaceImpl";

    public static void appUpdated(Context context) {
        SmpLog.m6497hi(TAG, "app updated");
        STaskDispatcher.dispatchOnService(context, new STask(STask.CommonAction.HANDLE_APP_UPDATE_EVENT, null));
    }

    public static void bootCompleted(Context context) {
        SmpLog.m6497hi(TAG, "boot completed");
        STaskDispatcher.dispatchOnService(context, new STask(STask.CommonAction.HANDLE_BOOT_COMPLETED_EVENT, null));
    }

    private static boolean canUploadClientsForInit(long j, long j2, long j3) {
        return j >= j2 && j >= j3 + Constants.UPLOAD_CLIENTS_FOR_INIT_COOLING_MILLIS;
    }

    public static void clearAllAppFilter(Context context) {
        DataManager.clearAllAppFilterData(context);
    }

    public static void clearAllAppReferrer(Context context) {
        DataManager.clearAllAppReferrerData(context);
    }

    public static void clearAppFilter(Context context, String str) {
        DataManager.clearAppFilterData(context, str);
    }

    public static void clearAppReferrer(Context context, String str) {
        DataManager.clearAppReferrerData(context, str);
    }

    public static SmpResult clearData(Context context, int i) {
        String str = TAG;
        SmpLog.m6497hi(str, "clear data. timeout:" + i);
        SharedMemoryVariableManager.getInstance(context).setDataCleared(true);
        SmpResult smpResultClearSmpData = clearSmpData(context, i);
        if (smpResultClearSmpData.isSuccess()) {
            SmpLog.m6497hi(str, "clear data success");
            return smpResultClearSmpData;
        }
        SharedMemoryVariableManager.getInstance(context).setDataCleared(false);
        String string = smpResultClearSmpData.getResultData() != null ? smpResultClearSmpData.getResultData().getString("error_code") : "";
        String string2 = smpResultClearSmpData.getResultData() != null ? smpResultClearSmpData.getResultData().getString("error_message") : "";
        SmpLog.m6496he(str, "clear data fail - " + string);
        SmpLog.m6494e(str, "error msg - " + string2);
        return smpResultClearSmpData;
    }

    private static SmpResult clearSmpData(Context context, int i) {
        InitOptionsHolder.getInstance();
        PrefManager prefManager = PrefManager.getInstance(context);
        String appId = InitOptionsHolder.getInstance().getAppId(context);
        String deviceNickname = TestModeChecker.getDeviceNickname();
        boolean z = false;
        if (TextUtils.isEmpty(appId)) {
            Bundle bundle = new Bundle();
            bundle.putString("error_code", IErrors.ERROR_CODE_SMP_0201);
            bundle.putString("error_message", IErrors.ERROR_MESSAGE_SMP_0201);
            return new SmpResult(false, bundle);
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("error_code", IErrors.ERROR_CODE_SMP_0203);
            bundle2.putString("error_message", IErrors.ERROR_MESSAGE_SMP_0203);
            return new SmpResult(false, bundle2);
        }
        String smpID = prefManager.getSmpID();
        String uid = prefManager.getUID();
        if (TextUtils.isEmpty(smpID)) {
            SmpLog.m6497hi(TAG, "SmpId is not generated yet. clear device data only");
            z = true;
        }
        return DataManager.clearSmpData(context, appId, smpID, uid, i, z, deviceNickname);
    }

    public static void feedback(Context context, String str, String str2) {
        String str3 = TAG;
        SmpLog.m6497hi(str3, "add custom feedback - mid:" + str);
        SmpLog.m6492d(str3, "event :" + str2);
        Bundle bundle = new Bundle();
        bundle.putString(Constants.EXTRA_KEY_CUSTOM_FEEDBACK, str2);
        STaskDispatcher.dispatchOnService(context, new SMarketingTask(STask.MarketingAction.CUSTOM_FEEDBACK, bundle, str));
    }

    public static String getAppFilter(Context context, String str) {
        return DataManager.getAppFilterData(context, str);
    }

    public static Set<String> getAppFilterKeySet(Context context) {
        return DataManager.getAppFilterKeySet(context);
    }

    public static String getAppReferrer(Context context, String str) {
        return DataManager.getAppReferrerData(context, str);
    }

    public static Set<String> getAppReferrerKeySet(Context context) {
        return DataManager.getAppReferrerKeySet(context);
    }

    private static String getDelimiter(String str, boolean z) {
        return z ? Uri.encode(str) : AbstractC0541b.m772n("\\", str);
    }

    public static String getGuid(Context context) {
        return PrefManager.getInstance(context).getUID();
    }

    public static String getNotifChannelId(Context context, SmpConfiguration.ChannelInfo.Type type) {
        return PrefManager.getInstance(context).getNotiChannelId(type.ordinal() + 1);
    }

    public static int getNotifColor(Context context) {
        return PrefManager.getInstance(context).getNotiColor();
    }

    public static String getNotifGroup(Context context) {
        return PrefManager.getInstance(context).getNotiGroup();
    }

    public static SmpResult getOptIn(Context context) {
        if (DeviceInfoUtil.isOnlySupportGeneralPush(context)) {
            SmpLog.m6496he(TAG, "device does not support getOptIn");
            Bundle bundle = new Bundle();
            bundle.putString("error_code", IErrors.ERROR_CODE_SMP_0204);
            bundle.putString("error_message", IErrors.ERROR_MESSAGE_SMP_0204);
            return new SmpResult(false, bundle);
        }
        PrefManager prefManager = PrefManager.getInstance(context);
        Bundle bundle2 = new Bundle();
        boolean optIn = prefManager.getOptIn();
        bundle2.putBoolean("optin", optIn);
        bundle2.putLong(SmpConstants.OPTIN_TIME, prefManager.getOptInTime());
        SmpLog.m6498i(TAG, "current optin : " + optIn);
        return new SmpResult(true, bundle2);
    }

    private static Map<String, String> getParsedReferrerMap(Uri uri) {
        if (uri == null) {
            return null;
        }
        return parseReferrer(uri.getQueryParameter(SmpConstants.REFERRER_KEY), false);
    }

    public static String getPushToken(Context context) {
        String pushToken = PrefManager.getInstance(context).getPushToken();
        SmpLog.m6497hi(TAG, "get token : " + printToken(pushToken));
        return pushToken;
    }

    public static String getPushType(Context context) {
        String pushType = PrefManager.getInstance(context).getPushType();
        SmpLog.m6497hi(TAG, "get push type : " + pushType);
        return pushType;
    }

    public static String getSmpID(Context context) {
        if (DeviceInfoUtil.isOnlySupportGeneralPush(context)) {
            SmpLog.m6496he(TAG, "device does not support SmpId");
            return null;
        }
        PrefManager prefManager = PrefManager.getInstance(context);
        if (DataManager.isInitialUploadDone(context)) {
            return prefManager.getSmpID();
        }
        return null;
    }

    public static void getSmpId(final Context context, final SmpCallback.Success<String> success, final SmpCallback.Error error) {
        new Thread(new Runnable() { // from class: com.samsung.android.sdk.smp.interfaceimpl.SmpInterfaceImpl.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SmpCallback.Success success2 = success;
                    if (success2 != null) {
                        success2.onSuccess(SmpInterfaceImpl.getSmpID(context));
                    }
                } catch (InternalException.ProviderErrorException e) {
                    error.onError(e.getErrorMessage());
                }
            }
        }).start();
    }

    public static Uri getSound(Context context) {
        String soundUriString = PrefManager.getInstance(context).getSoundUriString();
        if (TextUtils.isEmpty(soundUriString)) {
            return null;
        }
        return Uri.parse(soundUriString);
    }

    public static boolean getSoundEnabled(Context context) {
        return PrefManager.getInstance(context).getSoundEnabled();
    }

    private static SmpResult getSuccessSmpResult(boolean z, long j) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("optin", z);
        bundle.putLong(SmpConstants.OPTIN_TIME, j);
        return new SmpResult(true, bundle);
    }

    public static boolean getVibrateEnabled(Context context) {
        return PrefManager.getInstance(context).getVibrateEnabled();
    }

    public static long[] getVibratePattern(Context context) {
        return PrefManager.getInstance(context).getVibratePattern();
    }

    public static void init(Context context, String str, SmpInitOptions smpInitOptions) {
        init(context, str, null, smpInitOptions);
    }

    private static boolean isDefaultChannel(SmpConfiguration.ChannelInfo.Type type, String str) {
        if (SmpConfiguration.ChannelInfo.Type.Notice.equals(type) && Constants.DEFAULT_NOTICE_CHANNELID.equals(str)) {
            return true;
        }
        return SmpConfiguration.ChannelInfo.Type.Marketing.equals(type) && Constants.DEFAULT_MARKETING_CHANNELID.equals(str);
    }

    private static boolean isMainProcess(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        ActivityManager activityManager = (ActivityManager) context.getApplicationContext().getSystemService(Constants.StringExtra.EXECUTE_TYPE_ACTIVITY);
        if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null || runningAppProcesses.size() == 0) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == Process.myPid() && context.getPackageName().equals(runningAppProcessInfo.processName)) {
                return true;
            }
        }
        return false;
    }

    private static Map<String, String> parseReferrer(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            SmpLog.m6501w(TAG, "empty referrer data");
            return null;
        }
        String delimiter = getDelimiter(MarketingConstants.REFERRER_DELIMITER_U003D, z);
        String delimiter2 = getDelimiter("|", z);
        HashMap map = new HashMap();
        for (String str2 : str.split(delimiter2)) {
            String[] strArrSplit = str2.split(delimiter);
            map.put(strArrSplit[0], strArrSplit[1]);
        }
        return map;
    }

    private static String printToken(String str) {
        if (TextUtils.isEmpty(str)) {
            return "null";
        }
        int length = str.length();
        if (length < 5) {
            return "invalid";
        }
        return "..." + str.substring(length - 5, length) + " (" + length + ")";
    }

    @TargetApi(26)
    private static void removeDefaultChannelAndReplace(Context context, SmpConfiguration.ChannelInfo.Type type, String str, String str2) {
        NotificationManager notificationManager = (NotificationManager) context.getApplicationContext().getSystemService("notification");
        PrefManager prefManager = PrefManager.getInstance(context.getApplicationContext());
        ArrayList<Marketing> visibleNotifications = MarketingManager.getVisibleNotifications(context, SmpConfiguration.ChannelInfo.Type.Notice.equals(type));
        notificationManager.deleteNotificationChannel(str);
        prefManager.setNotiChannelId(type.ordinal() + 1, str2);
        MarketingManager.redisplayMarketing(context, visibleNotifications);
        SmpLog.m6498i(TAG, "default channel has been deleted : redisplay notifications");
    }

    public static void removeSmpInitResultListener() {
        SmpLog.m6497hi(TAG, "remove init result listener");
        ListenerManager.getInstance().removeSmpInitResultListener();
    }

    public static void removeSmpPushResultListener() {
        SmpLog.m6497hi(TAG, "remove push result listener");
        ListenerManager.getInstance().removeSmpPushResultListener();
    }

    public static void saSignInOrOut(Context context) {
        MarketingManager.deleteIncompletedMarketings(context, FeedbackDetailConstants.SA_SIGN_IN_OR_OUT);
    }

    public static void setAppFilter(Context context, String str, String str2) {
        DataManager.setAppFilterData(context, str, str2);
    }

    public static void setAppReferrer(Context context, String str, String str2) {
        DataManager.setAppReferrerData(context, str, str2);
    }

    public static void setDebug(final Context context, final boolean z) {
        SmpLog.enableLog(z);
        if (context != null) {
            new Thread(new Runnable() { // from class: com.samsung.android.sdk.smp.interfaceimpl.SmpInterfaceImpl.1
                @Override // java.lang.Runnable
                public void run() {
                    PrefManager.getInstance(context).setLogEnabled(z);
                }
            }).start();
        }
    }

    public static void setGuid(Context context, String str) {
        String str2 = TAG;
        SmpLog.m6497hi(str2, "set guid");
        SmpLog.m6492d(str2, "guid : " + str);
        if (str == null) {
            str = "";
        }
        PrefManager prefManager = PrefManager.getInstance(context);
        if (str.equals(prefManager.getUID())) {
            return;
        }
        prefManager.setUID(str);
        MarketingManager.deleteIncompletedMarketings(context, FeedbackDetailConstants.UID_CHANGED);
    }

    public static void setNotifChannel(Context context, Map<SmpConfiguration.ChannelInfo.Type, String> map) throws SmpException.IllegalStateException {
        NotificationManager notificationManager = (NotificationManager) context.getApplicationContext().getSystemService("notification");
        PrefManager prefManager = PrefManager.getInstance(context.getApplicationContext());
        for (Map.Entry<SmpConfiguration.ChannelInfo.Type, String> entry : map.entrySet()) {
            String value = entry.getValue();
            if (notificationManager.getNotificationChannel(value) == null) {
                SmpLog.m6494e(TAG, "channel - " + value + " is not created");
                throw new SmpException.IllegalStateException(AbstractC0541b.m773o("Channel - ", value, " is not created. Channel must be created before setNotifChannel()"));
            }
            SmpConfiguration.ChannelInfo.Type key = entry.getKey();
            int iOrdinal = key.ordinal() + 1;
            String notiChannelId = prefManager.getNotiChannelId(iOrdinal);
            if (value == null || value.equals(notiChannelId) || !isDefaultChannel(key, notiChannelId)) {
                prefManager.setNotiChannelId(iOrdinal, value);
            } else {
                removeDefaultChannelAndReplace(context, key, notiChannelId, value);
            }
        }
    }

    public static void setNotifColor(Context context, int i) {
        PrefManager.getInstance(context).setNotiColor(i);
    }

    public static void setNotifGroup(Context context, String str) {
        PrefManager.getInstance(context).setNotiGroup(str);
    }

    public static synchronized SmpResult setOptIn(Context context, boolean z, long j) {
        if (DeviceInfoUtil.isOnlySupportGeneralPush(context)) {
            SmpLog.m6496he(TAG, "device does not support setOptIn");
            Bundle bundle = new Bundle();
            bundle.putString("error_code", IErrors.ERROR_CODE_SMP_0204);
            bundle.putString("error_message", IErrors.ERROR_MESSAGE_SMP_0204);
            return new SmpResult(false, bundle);
        }
        String str = TAG;
        SmpLog.m6498i(str, "setOptIn - optIn: " + z + ", optInTime: " + j);
        PrefManager prefManager = PrefManager.getInstance(context);
        boolean optIn = prefManager.getOptIn();
        prefManager.setOptIn(z);
        prefManager.setOptInTime(j);
        SmpResult successSmpResult = getSuccessSmpResult(z, j);
        if (z) {
            SmpLog.m6497hi(str, "optIn success. - optInTime: " + j);
        } else {
            SmpLog.m6497hi(str, "optOut success. - optInTime: " + j);
        }
        if (optIn != z) {
            MarketingManager.deleteIncompletedMarketings(context, FeedbackDetailConstants.OPT_IN_CHANGED);
        }
        return successSmpResult;
    }

    public static void setSmpInitResultListener(SmpListeners.SmpInitResultListener smpInitResultListener) {
        SmpLog.m6497hi(TAG, "set init result listener");
        ListenerManager.getInstance().setSmpInitResultListener(smpInitResultListener);
    }

    public static void setSmpPushResultListener(SmpListeners.SmpPushResultListener smpPushResultListener) {
        SmpLog.m6497hi(TAG, "set push result listener");
        ListenerManager.getInstance().setSmpPushResultListener(smpPushResultListener);
    }

    public static void setSound(Context context, Uri uri) {
        PrefManager.getInstance(context).setSoundUriString(uri.toString());
    }

    public static void setSoundEnabled(Context context, boolean z) {
        PrefManager.getInstance(context).setSoundEnabled(z);
    }

    public static void setVibrateEnabled(Context context, boolean z) {
        PrefManager.getInstance(context).setVibrateEnabled(z);
    }

    public static void setVibratePattern(Context context, long[] jArr) {
        PrefManager.getInstance(context).setVibratePattern(jArr);
    }

    private static void uploadClientsForInit(Context context) {
        PrefManager prefManager = PrefManager.getInstance(context);
        if (!DataManager.isInitialUploadDone(context)) {
            DataManager.triggerUploadClientsNow(context, true);
            return;
        }
        long availableUploadPeriod = DataManager.getAvailableUploadPeriod(context);
        long lastUploadTryTime = prefManager.getLastUploadTryTime();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (canUploadClientsForInit(jCurrentTimeMillis, availableUploadPeriod, lastUploadTryTime)) {
            DataManager.triggerUploadClientsNow(context, true);
        } else if (jCurrentTimeMillis < lastUploadTryTime) {
            SmpLog.m6501w(TAG, "device time is changed. update last upload time");
            prefManager.setLastUploadTryTime(jCurrentTimeMillis);
        } else {
            long j = availableUploadPeriod - jCurrentTimeMillis;
            long j2 = (lastUploadTryTime + com.samsung.android.sdk.smp.common.constants.Constants.UPLOAD_CLIENTS_FOR_INIT_COOLING_MILLIS) - jCurrentTimeMillis;
            long jMax = Math.max(j, j2);
            String str = TAG;
            StringBuilder sbM1323p = AbstractC1974b.m1323p(j, "until upload period : ", ", until cooling time : ");
            sbM1323p.append(j2);
            SmpLog.m6498i(str, sbM1323p.toString());
            SmpLog.m6498i(str, "next upload will be available after " + (jMax / com.samsung.android.sdk.smp.common.constants.Constants.MINMILLIS) + " minutes");
        }
        BroadcastUtil.broadcastSmpInitSuccess(context, false);
    }

    public static void getGuid(final Context context, final SmpCallback.Success<String> success, final SmpCallback.Error error) {
        new Thread(new Runnable() { // from class: com.samsung.android.sdk.smp.interfaceimpl.SmpInterfaceImpl.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SmpCallback.Success success2 = success;
                    if (success2 != null) {
                        success2.onSuccess(SmpInterfaceImpl.getGuid(context));
                    }
                } catch (InternalException.ProviderErrorException e) {
                    error.onError(e.getErrorMessage());
                }
            }
        }).start();
    }

    public static void getNotifChannelId(final Context context, final SmpConfiguration.ChannelInfo.Type type, final SmpCallback.Success<String> success, final SmpCallback.Error error) {
        new Thread(new Runnable() { // from class: com.samsung.android.sdk.smp.interfaceimpl.SmpInterfaceImpl.18
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SmpCallback.Success success2 = success;
                    if (success2 != null) {
                        success2.onSuccess(SmpInterfaceImpl.getNotifChannelId(context, type));
                    }
                } catch (InternalException.ProviderErrorException e) {
                    error.onError(e.getErrorMessage());
                }
            }
        }).start();
    }

    public static void getNotifColor(final Context context, final SmpCallback.Success<Integer> success, final SmpCallback.Error error) {
        new Thread(new Runnable() { // from class: com.samsung.android.sdk.smp.interfaceimpl.SmpInterfaceImpl.16
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SmpCallback.Success success2 = success;
                    if (success2 != null) {
                        success2.onSuccess(Integer.valueOf(SmpInterfaceImpl.getNotifColor(context)));
                    }
                } catch (InternalException.ProviderErrorException e) {
                    error.onError(e.getErrorMessage());
                }
            }
        }).start();
    }

    public static void getNotifGroup(final Context context, final SmpCallback.Success<String> success, final SmpCallback.Error error) {
        new Thread(new Runnable() { // from class: com.samsung.android.sdk.smp.interfaceimpl.SmpInterfaceImpl.20
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SmpCallback.Success success2 = success;
                    if (success2 != null) {
                        success2.onSuccess(SmpInterfaceImpl.getNotifGroup(context));
                    }
                } catch (InternalException.ProviderErrorException e) {
                    error.onError(e.getErrorMessage());
                }
            }
        }).start();
    }

    private static Map<String, String> getParsedReferrerMap(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        return parseReferrer(bundle.getString(SmpConstants.REFERRER_KEY), true);
    }

    public static void getSoundEnabled(final Context context, final SmpCallback.Success<Boolean> success, final SmpCallback.Error error) {
        new Thread(new Runnable() { // from class: com.samsung.android.sdk.smp.interfaceimpl.SmpInterfaceImpl.10
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SmpCallback.Success success2 = success;
                    if (success2 != null) {
                        success2.onSuccess(Boolean.valueOf(SmpInterfaceImpl.getSoundEnabled(context)));
                    }
                } catch (InternalException.ProviderErrorException e) {
                    error.onError(e.getErrorMessage());
                }
            }
        }).start();
    }

    public static void getVibrateEnabled(final Context context, final SmpCallback.Success<Boolean> success, final SmpCallback.Error error) {
        new Thread(new Runnable() { // from class: com.samsung.android.sdk.smp.interfaceimpl.SmpInterfaceImpl.14
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SmpCallback.Success success2 = success;
                    if (success2 != null) {
                        success2.onSuccess(Boolean.valueOf(SmpInterfaceImpl.getVibrateEnabled(context)));
                    }
                } catch (InternalException.ProviderErrorException e) {
                    error.onError(e.getErrorMessage());
                }
            }
        }).start();
    }

    public static void getVibratePattern(final Context context, final SmpCallback.Success<Long[]> success, final SmpCallback.Error error) {
        new Thread(new Runnable() { // from class: com.samsung.android.sdk.smp.interfaceimpl.SmpInterfaceImpl.12
            @Override // java.lang.Runnable
            public void run() {
                Long[] lArr;
                try {
                    if (success != null) {
                        long[] vibratePattern = SmpInterfaceImpl.getVibratePattern(context);
                        if (vibratePattern == null || vibratePattern.length <= 0) {
                            lArr = null;
                        } else {
                            lArr = new Long[vibratePattern.length];
                            for (int i = 0; i < vibratePattern.length; i++) {
                                lArr[i] = Long.valueOf(vibratePattern[i]);
                            }
                        }
                        success.onSuccess(lArr);
                    }
                } catch (InternalException.ProviderErrorException e) {
                    error.onError(e.getErrorMessage());
                }
            }
        }).start();
    }

    public static void init(Context context, String str, SmpConstants.PushModeForHkAndMo pushModeForHkAndMo, SmpInitOptions smpInitOptions) {
        char cCharAt = BuildConfig.FLAVOR.charAt(0);
        SmpLog.m6497hi(TAG, "init." + smpInitOptions.toString() + " P:" + SmpConstants.PushModeForHkAndMo.getName(pushModeForHkAndMo) + " A:" + cCharAt);
        InitOptionsHolder.getInstance().initialize(str, pushModeForHkAndMo, smpInitOptions);
        STaskDispatcher.dispatchOnThread(context, new STask(STask.CommonAction.INITIALIZE, null));
    }

    public static void setAppFilter(Context context, Map<String, String> map) {
        DataManager.setAppFilterData(context, map);
    }

    public static void setAppReferrer(Context context, Map<String, String> map) {
        DataManager.setAppReferrerData(context, map);
    }

    public static void setNotifColor(final Context context, final int i, final SmpCallback.Success<Void> success, final SmpCallback.Error error) {
        new Thread(new Runnable() { // from class: com.samsung.android.sdk.smp.interfaceimpl.SmpInterfaceImpl.15
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SmpInterfaceImpl.setNotifColor(context, i);
                    SmpCallback.Success success2 = success;
                    if (success2 != null) {
                        success2.onSuccess(null);
                    }
                } catch (InternalException.ProviderErrorException e) {
                    error.onError(e.getErrorMessage());
                }
            }
        }).start();
    }

    public static void setNotifGroup(final Context context, final String str, final SmpCallback.Success<Void> success, final SmpCallback.Error error) {
        new Thread(new Runnable() { // from class: com.samsung.android.sdk.smp.interfaceimpl.SmpInterfaceImpl.19
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SmpInterfaceImpl.setNotifGroup(context, str);
                    SmpCallback.Success success2 = success;
                    if (success2 != null) {
                        success2.onSuccess(null);
                    }
                } catch (InternalException.ProviderErrorException e) {
                    error.onError(e.getErrorMessage());
                }
            }
        }).start();
    }

    public static void setSoundEnabled(final Context context, final boolean z, final SmpCallback.Success<Void> success, final SmpCallback.Error error) {
        new Thread(new Runnable() { // from class: com.samsung.android.sdk.smp.interfaceimpl.SmpInterfaceImpl.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SmpInterfaceImpl.setSoundEnabled(context, z);
                    SmpCallback.Success success2 = success;
                    if (success2 != null) {
                        success2.onSuccess(null);
                    }
                } catch (InternalException.ProviderErrorException e) {
                    error.onError(e.getErrorMessage());
                }
            }
        }).start();
    }

    public static void setVibrateEnabled(final Context context, final boolean z, final SmpCallback.Success<Void> success, final SmpCallback.Error error) {
        new Thread(new Runnable() { // from class: com.samsung.android.sdk.smp.interfaceimpl.SmpInterfaceImpl.13
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SmpInterfaceImpl.setVibrateEnabled(context, z);
                    SmpCallback.Success success2 = success;
                    if (success2 != null) {
                        success2.onSuccess(null);
                    }
                } catch (InternalException.ProviderErrorException e) {
                    error.onError(e.getErrorMessage());
                }
            }
        }).start();
    }

    public static void setVibratePattern(final Context context, final long[] jArr, final SmpCallback.Success<Void> success, final SmpCallback.Error error) {
        new Thread(new Runnable() { // from class: com.samsung.android.sdk.smp.interfaceimpl.SmpInterfaceImpl.11
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SmpInterfaceImpl.setVibratePattern(context, jArr);
                    SmpCallback.Success success2 = success;
                    if (success2 != null) {
                        success2.onSuccess(null);
                    }
                } catch (InternalException.ProviderErrorException e) {
                    error.onError(e.getErrorMessage());
                }
            }
        }).start();
    }

    public static Map<String, String> getParsedReferrerMap(Intent intent) {
        Map<String, String> parsedReferrerMap = getParsedReferrerMap(intent.getData());
        if (parsedReferrerMap != null) {
            return parsedReferrerMap;
        }
        Map<String, String> parsedReferrerMap2 = getParsedReferrerMap(intent.getExtras());
        if (parsedReferrerMap2 != null) {
            return parsedReferrerMap2;
        }
        return null;
    }

    public static void getPushToken(final Context context, final SmpCallback.Success<String> success, final SmpCallback.Error error) {
        new Thread(new Runnable() { // from class: com.samsung.android.sdk.smp.interfaceimpl.SmpInterfaceImpl.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SmpCallback.Success success2 = success;
                    if (success2 != null) {
                        success2.onSuccess(SmpInterfaceImpl.getPushToken(context));
                    }
                } catch (InternalException.ProviderErrorException e) {
                    error.onError(e.getErrorMessage());
                }
            }
        }).start();
    }

    public static void getPushType(final Context context, final SmpCallback.Success<String> success, final SmpCallback.Error error) {
        new Thread(new Runnable() { // from class: com.samsung.android.sdk.smp.interfaceimpl.SmpInterfaceImpl.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SmpCallback.Success success2 = success;
                    if (success2 != null) {
                        success2.onSuccess(SmpInterfaceImpl.getPushType(context));
                    }
                } catch (InternalException.ProviderErrorException e) {
                    error.onError(e.getErrorMessage());
                }
            }
        }).start();
    }

    public static void setSound(final Context context, final Uri uri, final SmpCallback.Success<Void> success, final SmpCallback.Error error) {
        new Thread(new Runnable() { // from class: com.samsung.android.sdk.smp.interfaceimpl.SmpInterfaceImpl.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SmpInterfaceImpl.setSound(context, uri);
                    SmpCallback.Success success2 = success;
                    if (success2 != null) {
                        success2.onSuccess(null);
                    }
                } catch (InternalException.ProviderErrorException e) {
                    error.onError(e.getErrorMessage());
                }
            }
        }).start();
    }

    public static void getSound(final Context context, final SmpCallback.Success<Uri> success, final SmpCallback.Error error) {
        new Thread(new Runnable() { // from class: com.samsung.android.sdk.smp.interfaceimpl.SmpInterfaceImpl.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SmpCallback.Success success2 = success;
                    if (success2 != null) {
                        success2.onSuccess(SmpInterfaceImpl.getSound(context));
                    }
                } catch (InternalException.ProviderErrorException e) {
                    error.onError(e.getErrorMessage());
                }
            }
        }).start();
    }

    public static void init(Context context) {
        TestModeChecker.checkModeAndEnableLog(context);
        InitOptionsHolder initOptionsHolder = InitOptionsHolder.getInstance();
        initOptionsHolder.saveInitDataToPref(context);
        SharedMemoryVariableManager.getInstance(context).setDataCleared(false);
        PrefManager prefManager = PrefManager.getInstance(context);
        String str = TAG;
        SmpLog.m6497hi(str, "ptype:" + prefManager.getPushType() + ", token:" + printToken(prefManager.getPushToken()) + SQLKeyword.COMMA + initOptionsHolder.toString());
        if (!isMainProcess(context)) {
            SmpLog.m6498i(str, "init but not on main process. do nothing.");
            return;
        }
        PushHelper pushHelper = PushHelper.getInstance();
        pushHelper.initializePushPlatform(context);
        if (!PushHelper.isPushRegComplete(context)) {
            pushHelper.register(context);
            return;
        }
        if (DeviceInfoUtil.hasSppForceActivationFeature()) {
            BroadcastUtil.broadcastSmpInitSuccessForSppForceActivationFeature(context);
            return;
        }
        try {
            if (pushHelper.validateAndSwitchPushPlatform(context)) {
                if (MarketingManager.numberOfIncompletedMarketings(context) > SharedMemoryVariableManager.getInstance(context).countRunningRealtimeMidsInFcmService()) {
                    STaskDispatcher.dispatchOnService(context, new STask(STask.CommonAction.HANDLE_INCOMP_MARKETING_REQUESTS, null));
                }
                if (FeedbackManager.getExternalFeedbackDataCount(context) > 0) {
                    STaskDispatcher.dispatchOnService(context.getApplicationContext(), new STask(STask.CommonAction.UPLOAD_EXTERNAL_FEEDBACK, null));
                    return;
                }
                return;
            }
            if (!DeviceInfoUtil.isOnlySupportGeneralPush(context)) {
                uploadClientsForInit(context);
            } else {
                BroadcastUtil.broadcastSmpInitSuccess(context, false);
            }
            if (MarketingManager.numberOfIncompletedMarketings(context) > SharedMemoryVariableManager.getInstance(context).countRunningRealtimeMidsInFcmService()) {
                STaskDispatcher.dispatchOnService(context, new STask(STask.CommonAction.HANDLE_INCOMP_MARKETING_REQUESTS, null));
            }
            if (FeedbackManager.getExternalFeedbackDataCount(context) > 0) {
                STaskDispatcher.dispatchOnService(context.getApplicationContext(), new STask(STask.CommonAction.UPLOAD_EXTERNAL_FEEDBACK, null));
            }
            if (AckManager.hasAckDataToSend(context)) {
                AckManager.dispatchSendAckTask(context);
            }
        } catch (Throwable th) {
            if (MarketingManager.numberOfIncompletedMarketings(context) > SharedMemoryVariableManager.getInstance(context).countRunningRealtimeMidsInFcmService()) {
                STaskDispatcher.dispatchOnService(context, new STask(STask.CommonAction.HANDLE_INCOMP_MARKETING_REQUESTS, null));
            }
            if (FeedbackManager.getExternalFeedbackDataCount(context) > 0) {
                STaskDispatcher.dispatchOnService(context.getApplicationContext(), new STask(STask.CommonAction.UPLOAD_EXTERNAL_FEEDBACK, null));
            }
            throw th;
        }
    }

    public static void setGuid(final Context context, final String str, final SmpCallback.Success<Void> success, final SmpCallback.Error error) {
        new Thread(new Runnable() { // from class: com.samsung.android.sdk.smp.interfaceimpl.SmpInterfaceImpl.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SmpInterfaceImpl.setGuid(context, str);
                    SmpCallback.Success success2 = success;
                    if (success2 != null) {
                        success2.onSuccess(null);
                    }
                } catch (InternalException.ProviderErrorException e) {
                    error.onError(e.getMessage());
                }
            }
        }).start();
    }

    public static void setNotifChannel(final Context context, final Map<SmpConfiguration.ChannelInfo.Type, String> map, final SmpCallback.Success<Void> success, final SmpCallback.Error error) {
        new Thread(new Runnable() { // from class: com.samsung.android.sdk.smp.interfaceimpl.SmpInterfaceImpl.17
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SmpInterfaceImpl.setNotifChannel(context, map);
                    SmpCallback.Success success2 = success;
                    if (success2 != null) {
                        success2.onSuccess(null);
                    }
                } catch (Exception e) {
                    error.onError(e.getMessage());
                }
            }
        }).start();
    }
}
