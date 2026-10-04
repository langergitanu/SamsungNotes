package com.samsung.android.sdk.smp.data;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.samsung.android.sdk.smp.SmpException;
import com.samsung.android.sdk.smp.SmpResult;
import com.samsung.android.sdk.smp.common.constants.Constants;
import com.samsung.android.sdk.smp.common.database.DBHandler;
import com.samsung.android.sdk.smp.common.exception.IErrors;
import com.samsung.android.sdk.smp.common.network.NetworkErrorCodeParser;
import com.samsung.android.sdk.smp.common.network.NetworkManager;
import com.samsung.android.sdk.smp.common.network.NetworkResult;
import com.samsung.android.sdk.smp.common.preference.PrefManager;
import com.samsung.android.sdk.smp.common.sharedvariable.SharedMemoryVariableManager;
import com.samsung.android.sdk.smp.common.util.DeviceInfoUtil;
import com.samsung.android.sdk.smp.common.util.SmpLog;
import com.samsung.android.sdk.smp.marketing.Marketing;
import com.samsung.android.sdk.smp.marketing.MarketingManager;
import com.samsung.android.sdk.smp.task.STask;
import com.samsung.android.sdk.smp.task.STaskDispatcher;
import com.samsung.android.sdk.smp.testmode.TestModeChecker;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class DataManager {
    private static final String TAG = "DataManager";
    private static boolean mIsClientsUploading;

    public static void cancelUploadClientsAlarm(Context context) {
        STaskDispatcher.cancelDispatchAlarm(context, new STask(STask.CommonAction.UPLOAD_CLIENTS, null));
    }

    public static void clearAllAppFilterData(Context context) throws SmpException.DBException {
        DBHandler dBHandlerOpenDBAndThrowExceptionIfFailed = openDBAndThrowExceptionIfFailed(context, "clearAllAppFilterData");
        try {
            if (dBHandlerOpenDBAndThrowExceptionIfFailed.deleteAllAppFilter()) {
            } else {
                throw new SmpException.DBException();
            }
        } finally {
            dBHandlerOpenDBAndThrowExceptionIfFailed.close();
        }
    }

    public static void clearAllAppReferrerData(Context context) throws SmpException.DBException {
        DBHandler dBHandlerOpenDBAndThrowExceptionIfFailed = openDBAndThrowExceptionIfFailed(context, "clearAllAppReferrerData");
        try {
            if (dBHandlerOpenDBAndThrowExceptionIfFailed.deleteAllAppReferrer()) {
            } else {
                throw new SmpException.DBException();
            }
        } finally {
            dBHandlerOpenDBAndThrowExceptionIfFailed.close();
        }
    }

    public static void clearAppFilterData(Context context, String str) throws SmpException.DBException {
        DBHandler dBHandlerOpenDBAndThrowExceptionIfFailed = openDBAndThrowExceptionIfFailed(context, "clearAppFilterData");
        try {
            if (dBHandlerOpenDBAndThrowExceptionIfFailed.deleteAppFilter(str)) {
            } else {
                throw new SmpException.DBException();
            }
        } finally {
            dBHandlerOpenDBAndThrowExceptionIfFailed.close();
        }
    }

    public static void clearAppReferrerData(Context context, String str) throws SmpException.DBException {
        DBHandler dBHandlerOpenDBAndThrowExceptionIfFailed = openDBAndThrowExceptionIfFailed(context, "clearAppReferrerData");
        try {
            if (dBHandlerOpenDBAndThrowExceptionIfFailed.deleteAppReferrer(str)) {
            } else {
                throw new SmpException.DBException();
            }
        } finally {
            dBHandlerOpenDBAndThrowExceptionIfFailed.close();
        }
    }

    public static SmpResult clearSmpData(Context context, String str, String str2, String str3, int i, boolean z, String str4) {
        if (!z) {
            NetworkResult networkResultRequest = NetworkManager.request(context, new DeleteRequest(str, str2, str3, str4), i);
            if (!networkResultRequest.isSuccess()) {
                return NetworkErrorCodeParser.parseErrorToSmpResult(networkResultRequest.getResponseCode(), networkResultRequest.getResponseMsg());
            }
        }
        cancelUploadClientsAlarm(context);
        DBHandler dBHandlerOpen = DBHandler.open(context);
        if (dBHandlerOpen != null) {
            dBHandlerOpen.deleteAll();
            dBHandlerOpen.close();
            PrefManager.getInstance(context).removeData();
            return new SmpResult(true, new Bundle());
        }
        SmpLog.m6494e(TAG, "clear data fail. dbHandler is null");
        Bundle bundle = new Bundle();
        bundle.putString("error_code", IErrors.ERROR_CODE_SMP_0401);
        bundle.putString("error_message", IErrors.ERROR_MESSAGE_SMP_0401);
        return new SmpResult(false, bundle);
    }

    public static void deactivate(Context context) {
        PrefManager.getInstance(context).removeData();
        DBHandler dBHandlerOpen = DBHandler.open(context);
        if (dBHandlerOpen == null) {
            SmpLog.m6494e(TAG, "deactivate. fail to delete db. dbHandler is null");
        } else {
            dBHandlerOpen.deleteAll();
            dBHandlerOpen.close();
        }
    }

    public static String getAppFilterData(Context context, String str) throws SmpException.DBException {
        DBHandler dBHandlerOpenDBAndThrowExceptionIfFailed = openDBAndThrowExceptionIfFailed(context, "getAppFilterData");
        String appFilter = dBHandlerOpenDBAndThrowExceptionIfFailed.getAppFilter(str);
        dBHandlerOpenDBAndThrowExceptionIfFailed.close();
        return appFilter;
    }

    public static Set<String> getAppFilterKeySet(Context context) throws SmpException.DBException {
        DBHandler dBHandlerOpenDBAndThrowExceptionIfFailed = openDBAndThrowExceptionIfFailed(context, "getAppFilterKeySet");
        Set<String> appFilterKeySet = dBHandlerOpenDBAndThrowExceptionIfFailed.getAppFilterKeySet();
        dBHandlerOpenDBAndThrowExceptionIfFailed.close();
        return appFilterKeySet;
    }

    public static String getAppReferrerData(Context context, String str) throws SmpException.DBException {
        DBHandler dBHandlerOpenDBAndThrowExceptionIfFailed = openDBAndThrowExceptionIfFailed(context, "getAppReferrerData");
        String appReferrer = dBHandlerOpenDBAndThrowExceptionIfFailed.getAppReferrer(str);
        dBHandlerOpenDBAndThrowExceptionIfFailed.close();
        return appReferrer;
    }

    public static Set<String> getAppReferrerKeySet(Context context) throws SmpException.DBException {
        DBHandler dBHandlerOpenDBAndThrowExceptionIfFailed = openDBAndThrowExceptionIfFailed(context, "getAppReferrerKeySet");
        Set<String> appReferrerKeySet = dBHandlerOpenDBAndThrowExceptionIfFailed.getAppReferrerKeySet();
        dBHandlerOpenDBAndThrowExceptionIfFailed.close();
        return appReferrerKeySet;
    }

    public static long getAvailableUploadPeriod(Context context) {
        return PrefManager.getInstance(context).getLastUploadTryTime() + getUploadPeriodTime(context);
    }

    private static long getUploadPeriodTime(Context context) {
        return (TestModeChecker.isTestMode() ? 60L : PrefManager.getInstance(context).getUploadPeriod()) * Constants.MINMILLIS;
    }

    public static void handleBootOrUpdateEvent(Context context) {
        if (isInitialUploadDone(context)) {
            triggerUploadClients(context, true);
        }
    }

    private static boolean isClientsUploading() {
        return mIsClientsUploading;
    }

    public static boolean isInitialUploadDone(Context context) {
        PrefManager prefManager = PrefManager.getInstance(context);
        if (prefManager.getSmpFirstUploadTime() <= 0) {
            return false;
        }
        if (DeviceInfoUtil.isSamsungPushService(context)) {
            return prefManager.isRandomSmpIdGenerated();
        }
        return true;
    }

    private static DBHandler openDBAndThrowExceptionIfFailed(Context context, String str) throws SmpException.DBException {
        DBHandler dBHandlerOpen = DBHandler.open(context);
        if (dBHandlerOpen != null) {
            return dBHandlerOpen;
        }
        SmpLog.m6494e(TAG, str + " error. db null");
        throw new SmpException.DBException("database open failed");
    }

    public static void requestUploadClientsData(Context context) {
        if (DeviceInfoUtil.isOnlySupportGeneralPush(context)) {
            SmpLog.m6498i(TAG, "device does not upload clients data");
            return;
        }
        if (SharedMemoryVariableManager.getInstance(context).isDataCleared()) {
            SmpLog.m6498i(TAG, "Upload clients request is no more valid. This may because smp data is cleared");
            return;
        }
        setClientsUploading(true);
        cancelUploadClientsAlarm(context);
        PrefManager.getInstance(context).setLastUploadTryTime(System.currentTimeMillis());
        boolean zIsInitialUploadDone = isInitialUploadDone(context);
        String str = TAG;
        StringBuilder sb = new StringBuilder("initial upload : ");
        sb.append(!zIsInitialUploadDone);
        SmpLog.m6492d(str, sb.toString());
        (!zIsInitialUploadDone ? new ClientsInitialHandler(context) : new ClientsNormalHandler(context)).request();
        setClientsUploading(false);
    }

    public static void setAppFilterData(Context context, Map<String, String> map) throws SmpException.DBException {
        DBHandler dBHandlerOpenDBAndThrowExceptionIfFailed = openDBAndThrowExceptionIfFailed(context, "setAppFilterData");
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                setAppFilterData(context, dBHandlerOpenDBAndThrowExceptionIfFailed, entry.getKey(), entry.getValue());
            }
        } finally {
            dBHandlerOpenDBAndThrowExceptionIfFailed.close();
        }
    }

    public static void setAppReferrerData(Context context, Map<String, String> map) throws SmpException.DBException {
        DBHandler dBHandlerOpenDBAndThrowExceptionIfFailed = openDBAndThrowExceptionIfFailed(context, "setAppReferrerData");
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                setAppReferrerData(context, dBHandlerOpenDBAndThrowExceptionIfFailed, entry.getKey(), entry.getValue());
            }
        } finally {
            dBHandlerOpenDBAndThrowExceptionIfFailed.close();
        }
    }

    private static void setClientsUploading(boolean z) {
        mIsClientsUploading = z;
    }

    public static void setUploadClientsAlarm(Context context, long j) {
        STaskDispatcher.setDispatchAlarm(context, new STask(STask.CommonAction.UPLOAD_CLIENTS, null), j, 1);
    }

    public static void triggerUploadClients(Context context, boolean z) {
        if (DeviceInfoUtil.hasSppForceActivationFeature()) {
            SmpLog.m6498i(TAG, "do not proceed upload clients request. spp force activation mode");
            return;
        }
        long availableUploadPeriod = getAvailableUploadPeriod(context);
        if (System.currentTimeMillis() >= availableUploadPeriod) {
            triggerUploadClientsNow(context, z);
        } else {
            setUploadClientsAlarm(context, availableUploadPeriod);
        }
    }

    public static void triggerUploadClientsForFeedback(Context context, String str) {
        int feedbackDispersionMin;
        int feedbackDispersionMax;
        Marketing marketing;
        PrefManager.getInstance(context).setUploadFailCount(0);
        long availableUploadPeriod = getAvailableUploadPeriod(context);
        if (System.currentTimeMillis() < availableUploadPeriod) {
            setUploadClientsAlarm(context, availableUploadPeriod);
            return;
        }
        try {
            marketing = MarketingManager.getMarketing(context, str);
            feedbackDispersionMin = marketing.getFeedbackDispersionMin();
        } catch (Exception e) {
            e = e;
            feedbackDispersionMin = 1;
        }
        try {
            feedbackDispersionMax = marketing.getFeedbackDispersionMax();
        } catch (Exception e2) {
            e = e2;
            SmpLog.m6494e(TAG, e.toString());
            feedbackDispersionMax = 10;
        }
        int iNextInt = new Random().nextInt((feedbackDispersionMax - feedbackDispersionMin) + 1) + feedbackDispersionMin;
        SmpLog.m6498i(TAG, "Feedback dispersion - min: " + iNextInt);
        setUploadClientsAlarm(context, (((long) iNextInt) * Constants.MINMILLIS) + System.currentTimeMillis());
    }

    public static void triggerUploadClientsNow(Context context, boolean z) {
        if (DeviceInfoUtil.hasSppForceActivationFeature()) {
            SmpLog.m6498i(TAG, "do not proceed upload clients request. spp force activation mode");
            return;
        }
        if (z && isClientsUploading()) {
            SmpLog.m6498i(TAG, "do not proceed upload clients request. isClientsUploading : true");
            return;
        }
        cancelUploadClientsAlarm(context);
        STaskDispatcher.dispatchOnService(context, new STask(STask.CommonAction.UPLOAD_CLIENTS, null));
        PrefManager.getInstance(context).setLastUploadTryTime(System.currentTimeMillis());
    }

    public static void setAppFilterData(Context context, String str, String str2) throws SmpException.DBException {
        DBHandler dBHandlerOpenDBAndThrowExceptionIfFailed = openDBAndThrowExceptionIfFailed(context, "setAppFilterData");
        try {
            setAppFilterData(context, dBHandlerOpenDBAndThrowExceptionIfFailed, str, str2);
        } finally {
            dBHandlerOpenDBAndThrowExceptionIfFailed.close();
        }
    }

    public static void setAppReferrerData(Context context, String str, String str2) throws SmpException.DBException {
        DBHandler dBHandlerOpenDBAndThrowExceptionIfFailed = openDBAndThrowExceptionIfFailed(context, "setAppReferrerData");
        try {
            setAppReferrerData(context, dBHandlerOpenDBAndThrowExceptionIfFailed, str, str2);
        } finally {
            dBHandlerOpenDBAndThrowExceptionIfFailed.close();
        }
    }

    private static void setAppFilterData(Context context, DBHandler dBHandler, String str, String str2) throws SmpException.DBException {
        if (TextUtils.isEmpty(str2)) {
            SmpLog.m6498i(TAG, "setAppFilterData. value is empty. change to clear appFilter : " + str);
            clearAppFilterData(context, str);
            return;
        }
        if (!dBHandler.setAppFilter(str, str2)) {
            throw new SmpException.DBException();
        }
    }

    private static void setAppReferrerData(Context context, DBHandler dBHandler, String str, String str2) throws SmpException.DBException {
        if (TextUtils.isEmpty(str2)) {
            SmpLog.m6498i(TAG, "setAppReferrerData. value is empty. change to clear appReferrer : " + str);
            clearAppReferrerData(context, str);
            return;
        }
        if (!dBHandler.setAppReferrer(str, str2)) {
            throw new SmpException.DBException();
        }
    }
}
