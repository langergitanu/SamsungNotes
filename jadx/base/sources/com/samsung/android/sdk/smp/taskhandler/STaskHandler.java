package com.samsung.android.sdk.smp.taskhandler;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.samsung.android.sdk.smp.common.constants.Constants;
import com.samsung.android.sdk.smp.common.constants.FeedbackEvent;
import com.samsung.android.sdk.smp.common.constants.MarketingState;
import com.samsung.android.sdk.smp.common.database.DBHandler;
import com.samsung.android.sdk.smp.common.exception.InternalException;
import com.samsung.android.sdk.smp.common.preference.PrefManager;
import com.samsung.android.sdk.smp.common.sharedvariable.SharedMemoryVariableManager;
import com.samsung.android.sdk.smp.common.util.DeviceInfoUtil;
import com.samsung.android.sdk.smp.common.util.SmpLog;
import com.samsung.android.sdk.smp.common.util.TimeUtil;
import com.samsung.android.sdk.smp.data.DataManager;
import com.samsung.android.sdk.smp.data.DebugDataManager;
import com.samsung.android.sdk.smp.data.UsageManager;
import com.samsung.android.sdk.smp.gdpr.GDPRManager;
import com.samsung.android.sdk.smp.interfaceimpl.SmpInterfaceImpl;
import com.samsung.android.sdk.smp.marketing.FeedbackManager;
import com.samsung.android.sdk.smp.marketing.MarketingManager;
import com.samsung.android.sdk.smp.push.PushHelper;
import com.samsung.android.sdk.smp.push.ack.AckManager;
import com.samsung.android.sdk.smp.spsclient.ScreenOnController;
import com.samsung.android.sdk.smp.task.SMarketingTask;
import com.samsung.android.sdk.smp.task.STask;
import com.samsung.android.sdk.smp.task.STaskDispatcher;
import com.samsung.android.sdk.smp.testmode.TestModeChecker;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class STaskHandler {
    private static final String TAG = "STaskHandler";

    public static void handle(Context context, STask sTask) {
        try {
            if (context == null || sTask == null) {
                SmpLog.m6494e(TAG, "handle. context or task is null");
                return;
            }
            if (!DeviceInfoUtil.isSupportCountryCode()) {
                SmpLog.m6496he(TAG, "The current country code is not supported on this sdk. should check the sdk that you are importing.");
                return;
            }
            if (PrefManager.getInstance(context).isSmpDeactivated() && !STask.CommonAction.DEACTIVATE.equals(sTask.getAction())) {
                SmpLog.m6497hi(TAG, "handleCommonAction. smp is deactivated. do nothing");
                return;
            }
            SmpLog.m6498i(TAG, "handle action. " + sTask.toString());
            if (sTask instanceof SMarketingTask) {
                handleMarketingAction(context, sTask.getAction(), ((SMarketingTask) sTask).getMid(), sTask.getData());
            } else {
                handleCommonAction(context, sTask.getAction(), sTask.getData());
            }
        } catch (InternalException.ProviderErrorException e) {
            SmpLog.m6496he(TAG, "Exception STaskHandler handle() action: " + sTask.getAction() + " " + e.getErrorMessage());
        }
    }

    private static void handleCommonAction(Context context, STask.Action action, Bundle bundle) {
        if (STask.CommonAction.INITIALIZE.equals(action)) {
            SmpInterfaceImpl.init(context);
            return;
        }
        if (STask.CommonAction.UPLOAD_CLIENTS.equals(action)) {
            DataManager.requestUploadClientsData(context);
            return;
        }
        if (STask.CommonAction.SEND_ACK.equals(action)) {
            AckManager.sendAck(context);
            return;
        }
        STask.CommonAction commonAction = STask.CommonAction.HANDLE_INCOMP_MARKETING_REQUESTS;
        if (commonAction.equals(action)) {
            MarketingManager.doIncompleteRequest(context);
            return;
        }
        if (STask.CommonAction.SAVE_APP_USAGE.equals(action)) {
            if (bundle != null) {
                UsageManager.saveAppUsage(context, bundle);
                return;
            }
            return;
        }
        if (STask.CommonAction.GDPR.equals(action)) {
            if (bundle != null) {
                GDPRManager.requestGDPR(context, bundle.getString("requestId"), GDPRManager.GDPRRequestType.GET);
                return;
            }
            return;
        }
        if (STask.CommonAction.HANDLE_APP_UPDATE_EVENT.equals(action) || STask.CommonAction.HANDLE_BOOT_COMPLETED_EVENT.equals(action)) {
            if (!TestModeChecker.isTestModeChecked()) {
                TestModeChecker.checkModeAndEnableLog(context);
            }
            boolean zEquals = STask.CommonAction.HANDLE_BOOT_COMPLETED_EVENT.equals(action);
            PushHelper.getInstance().handleBootOrUpdateEvent(context);
            MarketingManager.handleBootOrUpdateEvent(context, zEquals);
            DataManager.handleBootOrUpdateEvent(context);
            return;
        }
        if (STask.CommonAction.DEACTIVATE.equals(action)) {
            DataManager.deactivate(context);
            return;
        }
        STask.CommonAction commonAction2 = STask.CommonAction.FCM_SERVICE_COMPLEMENTARY_EVENT;
        if (!commonAction2.equals(action)) {
            if (STask.CommonAction.UPLOAD_EXTERNAL_FEEDBACK.equals(action)) {
                FeedbackManager.sendExternalFeedbacks(context);
                return;
            }
            SmpLog.m6494e(TAG, "handleCommonAction. invalid action : " + action);
            return;
        }
        if (SharedMemoryVariableManager.getInstance(context).countRunningRealtimeMidsInFcmService() <= 0) {
            STaskDispatcher.dispatchOnService(context, new STask(commonAction, null));
            return;
        }
        PrefManager prefManager = PrefManager.getInstance(context);
        int fcmServiceRetryCount = prefManager.getFcmServiceRetryCount();
        String str = TAG;
        SmpLog.m6498i(str, "FcmService complementary retry count : " + fcmServiceRetryCount);
        if (fcmServiceRetryCount >= 3) {
            SmpLog.m6498i(str, "over FcmService complementary retry count");
        } else {
            prefManager.setFcmServiceRetryCount(fcmServiceRetryCount + 1);
            STaskDispatcher.setDispatchAlarm(context, new STask(commonAction2, null), System.currentTimeMillis() + Constants.FCM_SERVICE_COMPLEMENTARY_MILLIS, 0);
        }
    }

    private static void handleMarketingAction(Context context, STask.Action action, String str, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            SmpLog.m6494e(TAG, "handleAction error. mid is empty");
            return;
        }
        DBHandler dBHandlerOpen = DBHandler.open(context);
        try {
            if (dBHandlerOpen == null) {
                SmpLog.m6495e(TAG, str, "handleAction error. dbHandler is null");
                return;
            }
            try {
                MarketingState marketingState = dBHandlerOpen.getMarketingState(str);
                if (MarketingState.CANCELED.equals(marketingState)) {
                    SmpLog.m6493d(TAG, str, "already canceled. ignore this event");
                    return;
                }
                if (STask.MarketingAction.BASIC.equals(action)) {
                    handleMarketingBasicAction(context, str, bundle, marketingState);
                } else if (STask.MarketingAction.CLEAR.equals(action)) {
                    MarketingManager.getMarketing(context, str).clearDisplayedMarketing(context);
                } else if (STask.MarketingAction.CUSTOM_FEEDBACK.equals(action)) {
                    String string = bundle.getString(Constants.EXTRA_KEY_CUSTOM_FEEDBACK);
                    if (string != null) {
                        FeedbackManager.addFeedback(context, str, FeedbackEvent.CUSTOM_FEEDBACK, string);
                    }
                } else if (STask.MarketingAction.SCREEN_ON.equals(action)) {
                    handleScreenOn(context, str, bundle);
                } else if (STask.MarketingAction.CHECK_NOTIFICATION_CLEARED.equals(action)) {
                    MarketingManager.checkNotificationCleared(context, str);
                } else {
                    SmpLog.m6495e(TAG, str, "handleAction error. invalid action : " + action);
                }
            } catch (InternalException.DBException | InternalException.DisplayErrorDueToDoNotDisturbTimeException | InternalException.InvalidArgumentException | InternalException.NotSupportedTypeException | InternalException.WrongMarketingDataException e) {
                MarketingManager.handleMarketingExceptions(e, context, str);
            }
        } finally {
            dBHandlerOpen.close();
        }
    }

    private static void handleMarketingBasicAction(Context context, String str, Bundle bundle, MarketingState marketingState) {
        if (bundle == null) {
            SmpLog.m6495e(TAG, str, "handleMarketingBasicAction error. data is null");
            return;
        }
        String string = bundle.getString(Constants.EXTRA_KEY_MARKETING_SUB_ACTION, "");
        if (!isValidState(string, marketingState)) {
            SmpLog.m6499i(TAG, str, "invalid state:" + marketingState);
            return;
        }
        string.getClass();
        switch (string) {
            case "request_custom_content":
                MarketingManager.handleSppCustomContentMessage(context, bundle.getString(Constants.EXTRA_KEY_APPDATA), bundle.getInt(Constants.EXTRA_KEY_DISPLAYID));
                break;
            case "download_res":
                MarketingManager.getMarketing(context, str).requestDownloadResource(context);
                break;
            case "get_marketing_status":
                MarketingManager.getMarketing(context, str).requestGetMarketingStatus(context);
                break;
            case "deliver":
                MarketingManager.handleMessage(context, str, bundle.getString(Constants.EXTRA_KEY_MSGTYPE), bundle.getString("userdata"), bundle.getInt(Constants.EXTRA_KEY_DISPLAYID));
                break;
            case "display":
                MarketingManager.getMarketing(context, str).displayMarketing(context, bundle.getBoolean(Constants.EXTRA_KEY_IS_FIRST_DISPLAY));
                break;
        }
        DebugDataManager.addFeedback(context, bundle, str, true);
    }

    private static void handleScreenOn(Context context, String str, Bundle bundle) throws InternalException.DBException {
        if (bundle == null) {
            SmpLog.m6495e(TAG, str, "handleScreenOn error. data is null");
            return;
        }
        String string = bundle.getString(Constants.EXTRA_KEY_MARKETING_SUB_ACTION, "");
        string.getClass();
        if (string.equals(Constants.EXTRA_ACTION_SCREEN_ON_FIRED)) {
            MarketingManager.getMarketing(context, str).forceDisplay(context);
            return;
        }
        if (string.equals(Constants.EXTRA_ACTION_SCREEN_ON_LISTENING_START)) {
            ScreenOnController.getInstance().startCheckingScreenOn(context, str, new TimeUtil.Time(bundle.getInt(Constants.EXTRA_KEY_DISPLAY_START_HOUR), bundle.getInt(Constants.EXTRA_KEY_DISPLAY_START_MIN)), new TimeUtil.Time(bundle.getInt(Constants.EXTRA_KEY_DISPLAY_END_HOUR), bundle.getInt(Constants.EXTRA_KEY_DISPLAY_END_MIN)), new TimeUtil.Time(bundle.getInt(Constants.EXTRA_KEY_DISPLAY_START_HOUR), bundle.getInt(Constants.EXTRA_KEY_DISPLAY_START_MIN)), new TimeUtil.Time(bundle.getInt(Constants.EXTRA_KEY_DISPLAY_START_HOUR), bundle.getInt(Constants.EXTRA_KEY_DISPLAY_START_MIN)), bundle.getLong(Constants.EXTRA_KEY_SCREEN_ON_END_TIME));
        }
    }

    private static boolean isValidState(String str, MarketingState marketingState) {
        str.getClass();
        switch (str) {
            case "request_custom_content":
            case "download_res":
            case "deliver":
                return MarketingState.INCOMP_RESOURCE.equals(marketingState);
            case "get_marketing_status":
                return MarketingState.INCOMP_GET_STATUS_API.equals(marketingState);
            case "display":
                return MarketingState.INCOMP_DISPLAY.equals(marketingState);
            default:
                return false;
        }
    }
}
