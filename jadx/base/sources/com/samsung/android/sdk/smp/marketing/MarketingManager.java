package com.samsung.android.sdk.smp.marketing;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.samsung.android.sdk.smp.common.constants.Constants;
import com.samsung.android.sdk.smp.common.constants.FeedbackDetailConstants;
import com.samsung.android.sdk.smp.common.constants.FeedbackEvent;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.sdk.smp.common.constants.MarketingState;
import com.samsung.android.sdk.smp.common.database.DBHandler;
import com.samsung.android.sdk.smp.common.exception.InternalException;
import com.samsung.android.sdk.smp.common.preference.PrefManager;
import com.samsung.android.sdk.smp.common.sharedvariable.SharedMemoryVariableManager;
import com.samsung.android.sdk.smp.common.util.DeviceInfoUtil;
import com.samsung.android.sdk.smp.common.util.FileIOUtil;
import com.samsung.android.sdk.smp.common.util.FilePathUtil;
import com.samsung.android.sdk.smp.common.util.SmpLog;
import com.samsung.android.sdk.smp.common.util.TimeUtil;
import com.samsung.android.sdk.smp.data.DataManager;
import com.samsung.android.sdk.smp.data.DebugDataManager;
import com.samsung.android.sdk.smp.display.DisplayManager;
import com.samsung.android.sdk.smp.marketing.MarketingParser;
import com.samsung.android.sdk.smp.marketing.customcontent.CustomContentResult;
import com.samsung.android.sdk.smp.marketing.customcontent.entity.NudgeEntity;
import com.samsung.android.sdk.smp.task.SMarketingTask;
import com.samsung.android.sdk.smp.task.STask;
import com.samsung.android.sdk.smp.task.STaskDispatcher;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class MarketingManager {
    private static final String TAG = "MarketingManager";
    private static Map<String, Marketing> mMarketing = new HashMap();
    private static long sLastDoIncompRequestTime;

    private static void addCustomContentFeedback(Context context, String str, CustomContentResult customContentResult) {
        if (customContentResult == null || customContentResult.isSuccess()) {
            return;
        }
        FeedbackManager.addFeedback(context, str, FeedbackEvent.CUSTOM_CONTENT_REQUEST_FAILED, customContentResult.getFeedbackDetail());
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [T, java.lang.Long] */
    /* JADX WARN: Type inference failed for: r0v5, types: [T, com.samsung.android.sdk.smp.common.util.TimeUtil$Time] */
    /* JADX WARN: Type inference failed for: r1v3, types: [T, com.samsung.android.sdk.smp.common.util.TimeUtil$Time] */
    /* JADX WARN: Type inference failed for: r1v8, types: [T, java.lang.Long] */
    private static void adjustMarketingDisplayTimeByTimeBase(MarketingParser.MarketingDisplayTime marketingDisplayTime) {
        if ("local".equals(marketingDisplayTime.timeBase)) {
            MarketingParser.PairTime<Long> pairTime = marketingDisplayTime.ttl;
            pairTime.start = Long.valueOf(TimeUtil.adjustLocalTimeToUtc0(pairTime.start.longValue()));
            MarketingParser.PairTime<Long> pairTime2 = marketingDisplayTime.ttl;
            pairTime2.end = Long.valueOf(TimeUtil.adjustLocalTimeToUtc0(pairTime2.end.longValue()));
            return;
        }
        MarketingParser.PairTime<TimeUtil.Time> pairTime3 = marketingDisplayTime.displayTime;
        pairTime3.start = TimeUtil.adjustUtc0ToLocalTime(pairTime3.start);
        MarketingParser.PairTime<TimeUtil.Time> pairTime4 = marketingDisplayTime.displayTime;
        pairTime4.end = TimeUtil.adjustUtc0ToLocalTime(pairTime4.end);
    }

    public static void cancelAllMarketingAlarms(Context context, String str) {
        STaskDispatcher.cancelDispatchAlarm(context, new SMarketingTask(STask.MarketingAction.BASIC, null, str));
        STaskDispatcher.cancelDispatchAlarm(context, new SMarketingTask(STask.MarketingAction.CLEAR, null, str));
        STaskDispatcher.cancelDispatchAlarm(context, new SMarketingTask(STask.MarketingAction.CHECK_NOTIFICATION_CLEARED, null, str));
    }

    private static boolean checkFcmRealtimeMarketing(Context context, String str, String str2) {
        if (!"fcm".equals(PrefManager.getInstance(context).getPushType())) {
            return false;
        }
        try {
            MarketingParser.MarketingDisplayTime marketingDisplayTime = MarketingParser.parseMarketingDisplayTime(str, new JSONObject(str2));
            adjustMarketingDisplayTimeByTimeBase(marketingDisplayTime);
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis < marketingDisplayTime.ttl.start.longValue() || marketingDisplayTime.ttl.end.longValue() < jCurrentTimeMillis) {
                return false;
            }
            MarketingParser.PairTime<TimeUtil.Time> pairTime = marketingDisplayTime.displayTime;
            TimeUtil.Time time = pairTime.start;
            TimeUtil.Time time2 = pairTime.end;
            MarketingParser.PairTime<TimeUtil.Time> pairTime2 = marketingDisplayTime.doNotDisturbTime;
            boolean zIsTimeInBetween = TimeUtil.isTimeInBetween(time, time2, pairTime2.start, pairTime2.end, jCurrentTimeMillis);
            SmpLog.m6499i(TAG, str, "real time marketing : " + zIsTimeInBetween);
            return zIsTimeInBetween;
        } catch (Exception e) {
            SmpLog.m6494e(TAG, "check realtime marketing fail : parsing error. " + e);
            return false;
        }
    }

    public static void checkNotificationCleared(Context context, String str) {
        DBHandler dBHandlerOpen = DBHandler.open(context);
        if (dBHandlerOpen == null) {
            SmpLog.m6495e(TAG, str, "db open fail");
            return;
        }
        if (!MarketingState.DISPLAYED.equals(dBHandlerOpen.getMarketingState(str))) {
            SmpLog.m6502w(TAG, str, "checkNotificationCleared. not displayed state. ignore this");
            dBHandlerOpen.close();
            return;
        }
        if (DeviceInfoUtil.isNotificationVisible(context, dBHandlerOpen.getMarketingDisplayId(str))) {
            SmpLog.m6499i(TAG, str, "checkNotificationCleared. notification is visible");
            STaskDispatcher.setDispatchAlarm(context, new SMarketingTask(STask.MarketingAction.CHECK_NOTIFICATION_CLEARED, null, str), System.currentTimeMillis() + MarketingConstants.CHECK_NOTIFICATION_CLEARED_DELAY_MILLIS, 0);
        } else {
            SmpLog.m6499i(TAG, str, "checkNotificationCleared. notification is cleared. generate click feedback");
            Marketing.setToGone(context, str, true);
            FeedbackManager.addFeedback(context, str, FeedbackEvent.CLICKED, null);
        }
        dBHandlerOpen.close();
    }

    private static boolean checkValidity(String str) {
        return !TextUtils.isEmpty(str) && str.length() <= 32;
    }

    private static boolean clearMarketingData(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            SmpLog.m6495e(TAG, str, "fail to clear data. invalid params");
            return false;
        }
        DBHandler dBHandlerOpen = DBHandler.open(context);
        if (dBHandlerOpen == null) {
            SmpLog.m6495e(TAG, str, "fail to clear data. db open fail");
            return false;
        }
        try {
            if (dBHandlerOpen.isMarketingExist(str)) {
                if (MarketingState.DISPLAYED.equals(dBHandlerOpen.getMarketingState(str))) {
                    try {
                        DisplayManager displayManager = DisplayManager.getDisplayManager(getMarketing(context, str).getMarketingType());
                        int marketingDisplayId = dBHandlerOpen.getMarketingDisplayId(str);
                        if (displayManager != null && marketingDisplayId > 0) {
                            displayManager.clear(context, marketingDisplayId);
                        }
                    } catch (Exception e) {
                        SmpLog.m6494e(TAG, "fail to clear data. " + e);
                        dBHandlerOpen.close();
                        return false;
                    }
                }
                cancelAllMarketingAlarms(context, str);
                FileIOUtil.deleteFiles(FilePathUtil.getResDirectory(context, str));
                dBHandlerOpen.deleteMarketingData(str);
                clearMarketingMap(str);
                SmpLog.m6493d(TAG, str, "successfully delete all related data");
            }
            dBHandlerOpen.close();
            return true;
        } catch (Throwable th) {
            dBHandlerOpen.close();
            throw th;
        }
    }

    public static void clearMarketingMap(String str) {
        mMarketing.remove(str);
    }

    public static void deleteIncompletedMarketings(Context context, String str) {
        DBHandler dBHandlerOpen = DBHandler.open(context);
        if (dBHandlerOpen == null) {
            SmpLog.m6494e(TAG, "db open fail");
            return;
        }
        for (String str2 : dBHandlerOpen.getAllIncompletedMarketingList("marketing")) {
            try {
                cancelAllMarketingAlarms(context, str2);
                Marketing.setToFail(context, str2, FeedbackEvent.USER_INFO_CHANGED, str);
                SmpLog.m6498i(TAG, "deleteIncompletedMarketings. mid: " + str2);
            } catch (Exception e) {
                SmpLog.m6495e(TAG, str2, "deleteIncompletedMarketings. error while parsing " + e);
            }
        }
        dBHandlerOpen.close();
    }

    private static void deleteOverDatedMarketings(Context context) {
        DBHandler dBHandlerOpen = DBHandler.open(context);
        if (dBHandlerOpen == null) {
            return;
        }
        ArrayList<String> allMarketingList = dBHandlerOpen.getAllMarketingList();
        for (int i = 0; i < allMarketingList.size(); i++) {
            String str = allMarketingList.get(i);
            try {
                if (isMarketingOverDated(context, str)) {
                    MarketingState marketingState = dBHandlerOpen.getMarketingState(str);
                    if (MarketingState.DISPLAYED.equals(marketingState)) {
                        try {
                            Marketing marketing = getMarketing(context, str);
                            SmpLog.m6493d(TAG, str, "overdated but delete later to send feedback");
                            marketing.clearDisplayedMarketing(context);
                            dBHandlerOpen.updateMarketingReceivedTime(str, (System.currentTimeMillis() - MarketingConstants.MARKETING_SAVE_TIME_MILLIS) + Constants.DAYMILLIS);
                        } catch (Exception unused) {
                        }
                    } else if (MarketingState.INCOMP_GET_STATUS_API.equals(marketingState) || MarketingState.INCOMP_RESOURCE.equals(marketingState) || MarketingState.INCOMP_DISPLAY.equals(marketingState)) {
                        SmpLog.m6493d(TAG, str, "overdated but delete later to send feedback");
                        if (DeviceInfoUtil.isPowerSaveMode(context)) {
                            Marketing.setToFail(context, str, FeedbackEvent.POWER_SAVING_MODE, null);
                        } else if (DeviceInfoUtil.isDataSaverMode(context)) {
                            Marketing.setToFail(context, str, FeedbackEvent.DATA_SAVER_MODE, null);
                        } else {
                            Marketing.setToFail(context, str, FeedbackEvent.CONSUME_FAIL, null);
                        }
                        dBHandlerOpen.updateMarketingReceivedTime(str, (System.currentTimeMillis() - MarketingConstants.MARKETING_SAVE_TIME_MILLIS) + Constants.DAYMILLIS);
                    } else {
                        clearMarketingData(context, str);
                    }
                }
            } catch (InternalException.InvalidArgumentException e) {
                SmpLog.m6495e(TAG, str, "fail to delete overdated marketings:" + e.getMessage());
            }
        }
        dBHandlerOpen.close();
    }

    private static void deleteUnusedResources(Context context) {
        File[] fileArrListFiles;
        DBHandler dBHandlerOpen;
        if (context != null) {
            String resDirectory = FilePathUtil.getResDirectory(context);
            File file = new File(resDirectory);
            if (!file.exists() || (fileArrListFiles = file.listFiles()) == null || (dBHandlerOpen = DBHandler.open(context)) == null) {
                return;
            }
            for (File file2 : fileArrListFiles) {
                if (!dBHandlerOpen.isMarketingExist(file2.getName())) {
                    SmpLog.m6492d(TAG, "delete unused resource[" + file2.getPath() + "]");
                    FileIOUtil.deleteFiles(resDirectory + "/" + file2.getName());
                }
            }
            dBHandlerOpen.close();
        }
    }

    private static void dispatchOnServiceCustomContentRequest(Context context, String str, String str2, int i) {
        Bundle bundle = new Bundle();
        bundle.putString(Constants.EXTRA_KEY_MARKETING_SUB_ACTION, Constants.EXTRA_ACTION_REQUEST_CUSTOM_CONTENT);
        bundle.putString(Constants.EXTRA_KEY_APPDATA, str2);
        bundle.putInt(Constants.EXTRA_KEY_DISPLAYID, i);
        STaskDispatcher.dispatchOnService(context, new SMarketingTask(STask.MarketingAction.BASIC, bundle, str));
    }

    private static void dispatchOnServiceDeliver(Context context, MarketingParser.AppData appData, String str, int i, int i2) {
        FeedbackManager.addFeedback(context, appData.mid, FeedbackEvent.DELIVER, DebugDataManager.generateDeliverFeedbackDetail(context, i2));
        Bundle bundle = new Bundle();
        bundle.putString(Constants.EXTRA_KEY_MARKETING_SUB_ACTION, Constants.EXTRA_ACTION_DELIVER);
        bundle.putString("mid", appData.mid);
        bundle.putString(Constants.EXTRA_KEY_MSGTYPE, appData.msgType);
        bundle.putString("userdata", str);
        bundle.putInt(Constants.EXTRA_KEY_DISPLAYID, i);
        STaskDispatcher.dispatchOnService(context, new SMarketingTask(STask.MarketingAction.BASIC, bundle, appData.mid));
    }

    public static void doIncompleteRequest(Context context) {
        DBHandler dBHandlerOpen = DBHandler.open(context);
        if (dBHandlerOpen == null) {
            SmpLog.m6494e(TAG, "doIncompleteRequest. dbHandler null");
            return;
        }
        long j = sLastDoIncompRequestTime;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (Constants.DO_INCOMP_REQUEST_PREVENT_MILLIS > jCurrentTimeMillis - j) {
            SmpLog.m6498i(TAG, "doIncompleteRequest. execution time is too short");
            dBHandlerOpen.close();
            return;
        }
        sLastDoIncompRequestTime = jCurrentTimeMillis;
        for (Map.Entry<String, MarketingState> entry : dBHandlerOpen.getAllMarketingStates().entrySet()) {
            String key = entry.getKey();
            if (SharedMemoryVariableManager.getInstance(context).isRunningRealtimeMidInFcmService(key)) {
                SmpLog.m6498i(TAG, "doIncompleteRequest. skip " + key + ". It is already running in FcmService");
            } else {
                doIncompleteRequest(context, key, entry.getValue());
            }
        }
        dBHandlerOpen.close();
    }

    private static void finishRealtimeMarketing(Context context, String str) {
        String str2 = TAG;
        SmpLog.m6499i(str2, str, "finish real time marketing");
        SharedMemoryVariableManager sharedMemoryVariableManager = SharedMemoryVariableManager.getInstance(context);
        if (!sharedMemoryVariableManager.isRunningRealtimeMidInFcmService(str)) {
            SmpLog.m6499i(str2, str, "real time marketing already finished");
            return;
        }
        DataManager.requestUploadClientsData(context);
        if (sharedMemoryVariableManager.countRunningRealtimeMidsInFcmService() > 1) {
            SmpLog.m6499i(str2, str, "multiple real-time marketings are running. do not cancel FCM_SERVICE_COMPLEMENTARY_EVENT alarm");
        } else {
            STaskDispatcher.cancelDispatchAlarm(context, new STask(STask.CommonAction.FCM_SERVICE_COMPLEMENTARY_EVENT, null));
        }
        PrefManager.getInstance(context).setFcmServiceRetryCount(0);
        sharedMemoryVariableManager.removeRunningRealtimeMidInFcmService(str);
    }

    private static CustomContentResult getCustomContent(Context context, MarketingParser.AppData appData) {
        PrefManager prefManager = PrefManager.getInstance(context);
        String str = appData.customContent;
        str.getClass();
        if (str.equals(MarketingConstants.CustomContentConst.NUDGE)) {
            return CustomContentManager.requestCustomContent(context, new NudgeEntity(appData.mid, prefManager.getUID(), appData.userdata));
        }
        SmpLog.m6494e(TAG, "invalid custom content path");
        return CustomContentResult.fail(FeedbackDetailConstants.INVALID_CUSTOM_CONTENT_PATH);
    }

    private static ArrayList<String> getDisplayedMarketings(Context context) {
        DBHandler dBHandlerOpen = DBHandler.open(context);
        if (dBHandlerOpen == null) {
            SmpLog.m6494e(TAG, "getDisplayedMarketings. dbHandler null");
            return new ArrayList<>();
        }
        try {
            ArrayList<String> marketingList = dBHandlerOpen.getMarketingList(MarketingState.DISPLAYED);
            if (marketingList != null) {
                return marketingList;
            }
            SmpLog.m6494e(TAG, "getDisplayedMarketings. fail to get marketings");
            return new ArrayList<>();
        } finally {
            dBHandlerOpen.close();
        }
    }

    public static Marketing getMarketing(Context context, String str, String str2, String str3, int i) throws InternalException.DBException, InternalException.InvalidArgumentException {
        if (context == null || TextUtils.isEmpty(str)) {
            SmpLog.m6495e(TAG, str, "fail to get marketing. invalid params");
            throw new InternalException.InvalidArgumentException();
        }
        DBHandler dBHandlerOpen = DBHandler.open(context);
        if (dBHandlerOpen == null) {
            SmpLog.m6494e(TAG, "db open fail");
            throw new InternalException.DBException();
        }
        try {
            Marketing appData = MarketingParser.parseAppData(context, str, str2, str3, i);
            appData.setExpectedDisplayTimeMillis(dBHandlerOpen.getExpectedDisplayTime(str));
            if (appData.getExpectedDisplayTimeMillis() <= 0) {
                appData.updateExpectedDisplayTime(context);
            }
            mMarketing.put(str, appData);
            dBHandlerOpen.close();
            return appData;
        } catch (Throwable th) {
            dBHandlerOpen.close();
            throw th;
        }
    }

    @TargetApi(23)
    public static HashMap<String, Marketing> getUndeletableDisplayedNotifications(Context context) {
        HashMap<String, Marketing> map = new HashMap<>();
        Iterator<String> it = getDisplayedMarketings(context).iterator();
        while (it.hasNext()) {
            try {
                Marketing marketing = getMarketing(context, it.next());
                if ("1".equals(marketing.getMarketingType()) && marketing.isUndeletable() && DeviceInfoUtil.isSamsungPushService(context) && marketing.getChannelType() == 1) {
                    map.put(marketing.getMid(), marketing);
                }
            } catch (Exception unused) {
            }
        }
        return map;
    }

    @TargetApi(23)
    public static ArrayList<Marketing> getVisibleNotifications(Context context, boolean z) {
        ArrayList<Marketing> arrayList = new ArrayList<>();
        int i = z ? 1 : 2;
        Iterator<String> it = getDisplayedMarketings(context).iterator();
        while (it.hasNext()) {
            try {
                Marketing marketing = getMarketing(context, it.next());
                if ("1".equals(marketing.getMarketingType()) && marketing.getChannelType() == i && DeviceInfoUtil.isNotificationVisible(context, marketing.getDisplayId())) {
                    arrayList.add(marketing);
                }
            } catch (Exception unused) {
            }
        }
        return arrayList;
    }

    public static void handleBootOrUpdateEvent(Context context, boolean z) {
        HashMap<String, Marketing> undeletableDisplayedNotifications = getUndeletableDisplayedNotifications(context);
        redisplayMarketing(context, new ArrayList(undeletableDisplayedNotifications.values()));
        handleDisplayedMarketingsWhenBootOrUpdate(context, undeletableDisplayedNotifications, z);
        doIncompleteRequest(context);
        deleteOverDatedMarketings(context);
        deleteUnusedResources(context);
    }

    private static String handleCustomContent(Context context, MarketingParser.AppData appData) {
        CustomContentResult customContent = getCustomContent(context, appData);
        if (customContent.isSuccess()) {
            return customContent.getData();
        }
        SmpLog.m6494e(TAG, "fail to handle custom content");
        addCustomContentFeedback(context, appData.mid, customContent);
        return null;
    }

    private static void handleDisplayedMarketingsWhenBootOrUpdate(Context context, HashMap<String, Marketing> map, boolean z) {
        DBHandler dBHandlerOpen = DBHandler.open(context);
        if (dBHandlerOpen == null) {
            SmpLog.m6494e(TAG, "handleDisplayedMarketingsWhenBootOrUpdate. dbHandler null");
            return;
        }
        for (String str : dBHandlerOpen.getAllDisplayedMarketingList()) {
            if (!map.containsKey(str)) {
                Marketing.setToGone(context, str, false);
            }
            try {
                Marketing marketing = getMarketing(context, str);
                if ((marketing.getClearTimeMillis() == 0 ? marketing.getTtlEndMillis() : marketing.getClearTimeMillis()) > System.currentTimeMillis()) {
                    FeedbackManager.addFeedback(context, str, FeedbackEvent.SYSTEM_EVENT_RECEIVED, z ? FeedbackDetailConstants.REBOOT : FeedbackDetailConstants.APP_UPDATE);
                }
            } catch (Exception e) {
                SmpLog.m6495e(TAG, str, "handleDisplayedMarketingsWhenBootOrUpdate. error while parsing " + e);
            }
        }
        dBHandlerOpen.close();
    }

    public static void handleFcmMessage(Context context, String str, int i) {
        MarketingParser.AppData appDataHandleMessageData = handleMessageData(context, str);
        if (appDataHandleMessageData == null) {
            return;
        }
        boolean zCheckFcmRealtimeMarketing = checkFcmRealtimeMarketing(context, appDataHandleMessageData.mid, appDataHandleMessageData.userdata);
        if (zCheckFcmRealtimeMarketing) {
            startRealtimeMarketing(context, appDataHandleMessageData.mid);
        }
        try {
            try {
                int iInsertMarketingToDB = insertMarketingToDB(context, appDataHandleMessageData.mid, appDataHandleMessageData.msgType, appDataHandleMessageData.userdata);
                if (iInsertMarketingToDB >= 0) {
                    String str2 = appDataHandleMessageData.userdata;
                    if (isCustomContent(appDataHandleMessageData)) {
                        String strHandleCustomContent = handleCustomContent(context, appDataHandleMessageData);
                        if (updateMarketingUserdataToDB(context, appDataHandleMessageData.mid, strHandleCustomContent)) {
                            zCheckFcmRealtimeMarketing = checkFcmRealtimeMarketing(context, appDataHandleMessageData.mid, strHandleCustomContent);
                            updateFcmRealtimeMarketingStatus(context, appDataHandleMessageData.mid, zCheckFcmRealtimeMarketing);
                            str2 = strHandleCustomContent;
                        }
                    }
                    dispatchOnServiceDeliver(context, appDataHandleMessageData, str2, iInsertMarketingToDB, i);
                    if (!zCheckFcmRealtimeMarketing) {
                        return;
                    }
                } else if (!zCheckFcmRealtimeMarketing) {
                    return;
                }
                finishRealtimeMarketing(context, appDataHandleMessageData.mid);
            } catch (InternalException.WrongMarketingDataException e) {
                handleMarketingExceptions(e, context, appDataHandleMessageData.mid);
                if (zCheckFcmRealtimeMarketing) {
                    finishRealtimeMarketing(context, appDataHandleMessageData.mid);
                }
            }
        } catch (Throwable th) {
            if (zCheckFcmRealtimeMarketing) {
                finishRealtimeMarketing(context, appDataHandleMessageData.mid);
            }
            throw th;
        }
    }

    public static void handleMarketingExceptions(Exception exc, Context context, String str) {
        if (exc instanceof InternalException.DBException) {
            SmpLog.m6495e(TAG, str, "fail to handle message. db error. " + exc);
            Marketing.setToFail(context, str, FeedbackEvent.CLIENT_INTERNAL_ERROR, FeedbackDetailConstants.DB_ERROR);
            return;
        }
        if (exc instanceof InternalException.InvalidArgumentException) {
            SmpLog.m6495e(TAG, str, "fail to handle message. internal error");
            Marketing.setToFail(context, str, FeedbackEvent.CLIENT_INTERNAL_ERROR, null);
            return;
        }
        if (exc instanceof InternalException.NotSupportedTypeException) {
            SmpLog.m6495e(TAG, str, "fail to handle message. not supported type");
            Marketing.setToFail(context, str, FeedbackEvent.UNSUPPORTED_TYPE, null);
            return;
        }
        if (exc instanceof InternalException.WrongMarketingDataException) {
            SmpLog.m6495e(TAG, str, "fail to handle message. wrong meta data");
            Marketing.setToFail(context, str, FeedbackEvent.WRONG_META_DATA, null);
        } else if (exc instanceof InternalException.DisplayErrorDueToDoNotDisturbTimeException) {
            SmpLog.m6495e(TAG, str, "fail to handle message. display not available due to do not disturb time");
            Marketing.setToFail(context, str, FeedbackEvent.CONSUME_FAIL, FeedbackDetailConstants.FAIL_DUE_TO_DO_NOT_DISTURB_TIME);
        } else if (exc instanceof InternalException.InvalidReferrerException) {
            SmpLog.m6495e(TAG, str, "fail to handle message. invalid referrer");
            Marketing.setToFail(context, str, FeedbackEvent.REFERRER_VALIDATION_FAIL, null);
        } else {
            SmpLog.m6495e(TAG, str, "fail to handle message. unknown exception");
            Marketing.setToFail(context, str, FeedbackEvent.CLIENT_INTERNAL_ERROR, null);
        }
    }

    public static void handleMessage(Context context, String str, String str2, String str3, int i) {
        try {
            getMarketing(context, str, str2, str3, i).requestDownloadResource(context);
        } catch (InternalException.DBException | InternalException.DisplayErrorDueToDoNotDisturbTimeException | InternalException.InvalidArgumentException | InternalException.NotSupportedTypeException | InternalException.WrongMarketingDataException e) {
            handleMarketingExceptions(e, context, str);
        }
        deleteOverDatedMarketings(context);
        deleteUnusedResources(context);
    }

    private static MarketingParser.AppData handleMessageData(Context context, String str) {
        if (context == null) {
            SmpLog.m6494e(TAG, "fail to handle message. context is null");
            return null;
        }
        MarketingParser.AppData appData = MarketingParser.parseAppData(str);
        if (appData == null) {
            SmpLog.m6494e(TAG, "fail to handle message. invalid data");
        }
        return appData;
    }

    public static void handleSppCustomContentMessage(Context context, String str, int i) {
        MarketingParser.AppData appDataHandleMessageData = handleMessageData(context, str);
        if (appDataHandleMessageData == null) {
            return;
        }
        String str2 = appDataHandleMessageData.userdata;
        String strHandleCustomContent = handleCustomContent(context, appDataHandleMessageData);
        if (updateMarketingUserdataToDB(context, appDataHandleMessageData.mid, strHandleCustomContent)) {
            str2 = strHandleCustomContent;
        }
        dispatchOnServiceDeliver(context, appDataHandleMessageData, str2, i, 0);
    }

    public static void handleSppMessage(Context context, String str) {
        MarketingParser.AppData appDataHandleMessageData = handleMessageData(context, str);
        if (appDataHandleMessageData == null) {
            return;
        }
        try {
            int iInsertMarketingToDB = insertMarketingToDB(context, appDataHandleMessageData.mid, appDataHandleMessageData.msgType, appDataHandleMessageData.userdata);
            if (iInsertMarketingToDB < 0) {
                return;
            }
            String str2 = appDataHandleMessageData.userdata;
            if (isCustomContent(appDataHandleMessageData)) {
                dispatchOnServiceCustomContentRequest(context, appDataHandleMessageData.mid, str, iInsertMarketingToDB);
            } else {
                dispatchOnServiceDeliver(context, appDataHandleMessageData, str2, iInsertMarketingToDB, 0);
            }
        } catch (InternalException.WrongMarketingDataException e) {
            handleMarketingExceptions(e, context, appDataHandleMessageData.mid);
        }
    }

    private static int insertMarketingToDB(Context context, String str, String str2, String str3) {
        if (!checkValidity(str)) {
            SmpLog.m6494e(TAG, "fail to insert marketing. invalid mid");
            return -1;
        }
        DBHandler dBHandlerOpen = DBHandler.open(context);
        if (dBHandlerOpen == null) {
            SmpLog.m6495e(TAG, str, "fail to insert marketing. db open fail");
            return -1;
        }
        try {
            if (Marketing.isTestMsg(str, str2) || MarketingState.FAILED.equals(dBHandlerOpen.getMarketingState(str))) {
                if (!clearMarketingData(context, str)) {
                    SmpLog.m6495e(TAG, str, "fail to delete previous marketing");
                    dBHandlerOpen.close();
                    return -1;
                }
            }
            if (dBHandlerOpen.isMarketingExist(str)) {
                SmpLog.m6502w(TAG, str, "already have the same marketing");
                dBHandlerOpen.close();
                return -1;
            }
            if (!checkValidity(str2, str3)) {
                dBHandlerOpen.insertMarketingData(str, null, null);
                throw new InternalException.WrongMarketingDataException();
            }
            int iInsertMarketingData = dBHandlerOpen.insertMarketingData(str, str3, str2);
            dBHandlerOpen.close();
            return iInsertMarketingData;
        } catch (Throwable th) {
            dBHandlerOpen.close();
            throw th;
        }
    }

    private static boolean isCustomContent(MarketingParser.AppData appData) {
        return !TextUtils.isEmpty(appData.customContent) && appData.customContent.length() <= 100;
    }

    private static boolean isMarketingOverDated(Context context, String str) throws InternalException.InvalidArgumentException {
        if (context == null || str == null) {
            SmpLog.m6495e(TAG, str, "invalid params");
            throw new InternalException.InvalidArgumentException();
        }
        DBHandler dBHandlerOpen = DBHandler.open(context);
        if (dBHandlerOpen == null) {
            SmpLog.m6495e(TAG, str, "db open fail");
            throw new InternalException.InvalidArgumentException();
        }
        try {
            long marketingReceivedTime = dBHandlerOpen.getMarketingReceivedTime(str);
            if (marketingReceivedTime < 0) {
                SmpLog.m6495e(TAG, str, "fail to get marketing received time");
                throw new InternalException.InvalidArgumentException();
            }
            try {
                long ttlStartMillis = getMarketing(context, str).getTtlStartMillis();
                if (ttlStartMillis > marketingReceivedTime) {
                    marketingReceivedTime = ttlStartMillis;
                }
            } catch (Exception unused) {
            }
            return System.currentTimeMillis() >= marketingReceivedTime + MarketingConstants.MARKETING_SAVE_TIME_MILLIS;
        } finally {
            dBHandlerOpen.close();
        }
    }

    public static long numberOfIncompletedMarketings(Context context) {
        DBHandler dBHandlerOpen = DBHandler.open(context);
        if (dBHandlerOpen == null) {
            return 0L;
        }
        long jCountIncompletedMarketings = dBHandlerOpen.countIncompletedMarketings();
        dBHandlerOpen.close();
        return jCountIncompletedMarketings;
    }

    public static void redisplayMarketing(Context context, ArrayList<Marketing> arrayList) {
        Iterator<Marketing> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().displayMarketing(context, false);
        }
    }

    private static void startRealtimeMarketing(Context context, String str) {
        String str2 = TAG;
        SmpLog.m6499i(str2, str, "start real time marketing");
        SharedMemoryVariableManager sharedMemoryVariableManager = SharedMemoryVariableManager.getInstance(context);
        if (sharedMemoryVariableManager.isRunningRealtimeMidInFcmService(str)) {
            SmpLog.m6499i(str2, str, "real time marketing already running");
            return;
        }
        sharedMemoryVariableManager.addRunningRealtimeMidInFcmService(str);
        PrefManager.getInstance(context).setFcmServiceRetryCount(0);
        STaskDispatcher.setDispatchAlarm(context, new STask(STask.CommonAction.FCM_SERVICE_COMPLEMENTARY_EVENT, null), System.currentTimeMillis() + Constants.FCM_SERVICE_COMPLEMENTARY_MILLIS, 0);
    }

    private static void updateFcmRealtimeMarketingStatus(Context context, String str, boolean z) {
        if (z) {
            startRealtimeMarketing(context, str);
        } else {
            finishRealtimeMarketing(context, str);
        }
    }

    private static boolean updateMarketingUserdataToDB(Context context, String str, String str2) {
        DBHandler dBHandlerOpen = DBHandler.open(context);
        if (dBHandlerOpen == null) {
            SmpLog.m6495e(TAG, str, "fail to insert marketing. db open fail");
            return false;
        }
        if (TextUtils.isEmpty(str2)) {
            SmpLog.m6495e(TAG, str, "fail to insert marketing. invalid data");
            return false;
        }
        try {
            return dBHandlerOpen.updateMarketingUserData(str, str2);
        } finally {
            dBHandlerOpen.close();
        }
    }

    private static boolean checkValidity(String str, String str2) {
        return !TextUtils.isEmpty(str) && str.length() <= 20 && !TextUtils.isEmpty(str2) && str2.length() <= 10240;
    }

    public static Marketing getMarketing(Context context, String str) throws InternalException.DBException, InternalException.InvalidArgumentException {
        if (context != null && !TextUtils.isEmpty(str)) {
            Marketing marketing = mMarketing.get(str);
            if (marketing == null) {
                DBHandler dBHandlerOpen = DBHandler.open(context);
                if (dBHandlerOpen != null) {
                    try {
                        Marketing marketing2 = getMarketing(context, str, dBHandlerOpen.getMarketingMsgType(str), dBHandlerOpen.getMarketingUserdata(str), dBHandlerOpen.getMarketingDisplayId(str));
                        dBHandlerOpen.close();
                        marketing = marketing2;
                    } catch (Throwable th) {
                        dBHandlerOpen.close();
                        throw th;
                    }
                } else {
                    SmpLog.m6495e(TAG, str, "db open fail");
                    throw new InternalException.DBException();
                }
            }
            if (marketing.getExpectedDisplayTimeMillis() <= 0) {
                marketing.updateExpectedDisplayTime(context);
            }
            return marketing;
        }
        SmpLog.m6495e(TAG, str, "fail to get marketing. invalid params");
        throw new InternalException.InvalidArgumentException();
    }

    private static void doIncompleteRequest(Context context, String str, MarketingState marketingState) {
        MarketingState marketingState2 = MarketingState.INCOMP_GET_STATUS_API;
        if (marketingState2.equals(marketingState) || MarketingState.INCOMP_RESOURCE.equals(marketingState) || MarketingState.INCOMP_DISPLAY.equals(marketingState) || MarketingState.DISPLAYED.equals(marketingState)) {
            try {
                SmpLog.m6499i(TAG, str, "Incomplete Request. state:" + marketingState);
                Marketing marketing = getMarketing(context, str);
                if (marketingState2.equals(marketingState)) {
                    marketing.setAlarmForScreenOnListener(context);
                    marketing.setAlarmForGetMarketingStatus(context);
                    return;
                }
                if (MarketingState.INCOMP_RESOURCE.equals(marketingState)) {
                    Bundle bundle = new Bundle();
                    bundle.putString(Constants.EXTRA_KEY_MARKETING_SUB_ACTION, Constants.EXTRA_ACTION_DOWNLOAD_RESOURCE);
                    STaskDispatcher.setDispatchAlarm(context, new SMarketingTask(STask.MarketingAction.BASIC, bundle, str), System.currentTimeMillis(), 0);
                } else if (MarketingState.INCOMP_DISPLAY.equals(marketingState)) {
                    marketing.setAlarmForScreenOnListener(context);
                    marketing.setAlarmForDisplay(context);
                } else if (marketing.getTtlEndMillis() <= System.currentTimeMillis()) {
                    marketing.clearDisplayedMarketing(context);
                }
            } catch (InternalException.DBException unused) {
                Marketing.setToFail(context, str, FeedbackEvent.CLIENT_INTERNAL_ERROR, FeedbackDetailConstants.DB_ERROR);
            } catch (InternalException.DisplayErrorDueToDoNotDisturbTimeException unused2) {
                Marketing.setToFail(context, str, FeedbackEvent.CONSUME_FAIL, FeedbackDetailConstants.FAIL_DUE_TO_DO_NOT_DISTURB_TIME);
            } catch (InternalException.InvalidArgumentException unused3) {
                Marketing.setToFail(context, str, FeedbackEvent.CLIENT_INTERNAL_ERROR, null);
            } catch (InternalException.NotSupportedTypeException unused4) {
                Marketing.setToFail(context, str, FeedbackEvent.UNSUPPORTED_TYPE, null);
            } catch (InternalException.WrongMarketingDataException unused5) {
                Marketing.setToFail(context, str, FeedbackEvent.WRONG_META_DATA, null);
            }
        }
    }
}
