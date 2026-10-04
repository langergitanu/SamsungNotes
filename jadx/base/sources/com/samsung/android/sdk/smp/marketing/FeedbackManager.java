package com.samsung.android.sdk.smp.marketing;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.smp.common.constants.Constants;
import com.samsung.android.sdk.smp.common.constants.FeedbackDetailConstants;
import com.samsung.android.sdk.smp.common.constants.FeedbackEvent;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.sdk.smp.common.database.DBHandler;
import com.samsung.android.sdk.smp.common.database.entity.ExternalFeedbackUrlDataEntity;
import com.samsung.android.sdk.smp.common.network.NetworkManager;
import com.samsung.android.sdk.smp.common.network.NetworkResult;
import com.samsung.android.sdk.smp.common.sharedvariable.SharedMemoryVariableManager;
import com.samsung.android.sdk.smp.common.util.SmpLog;
import com.samsung.android.sdk.smp.data.DataManager;
import com.samsung.android.sdk.smp.task.STask;
import com.samsung.android.sdk.smp.task.STaskDispatcher;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class FeedbackManager {
    private static final String TAG = "FeedbackManager";
    private static final HashSet<String> sExternalClickFeedbackMids = new HashSet<>();

    /* JADX INFO: renamed from: com.samsung.android.sdk.smp.marketing.FeedbackManager$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C78271 {

        /* JADX INFO: renamed from: $SwitchMap$com$samsung$android$sdk$smp$marketing$FeedbackManager$UploadType */
        static final /* synthetic */ int[] f5251xb5cab96f;

        static {
            int[] iArr = new int[UploadType.values().length];
            f5251xb5cab96f = iArr;
            try {
                iArr[UploadType.DISPERSION_IN_SMP_SERVICE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5251xb5cab96f[UploadType.UPLOAD_NOW_IN_SMP_SERVICE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5251xb5cab96f[UploadType.SKIP_NOW_AND_UPLOAD_LATER_IN_FCM_SERVICE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum UploadType {
        SKIP_NOW_AND_UPLOAD_LATER_IN_FCM_SERVICE,
        DISPERSION_IN_SMP_SERVICE,
        UPLOAD_NOW_IN_SMP_SERVICE
    }

    public static void addFeedback(Context context, String str, FeedbackEvent feedbackEvent, String str2) {
        String str3 = TAG;
        SmpLog.m6499i(str3, str, "==== << " + feedbackEvent + " >> ====");
        if (context == null || TextUtils.isEmpty(str) || feedbackEvent == null) {
            SmpLog.m6495e(str3, str, "fail to add feedback. invalid params");
            return;
        }
        DBHandler dBHandlerOpen = DBHandler.open(context);
        if (dBHandlerOpen == null) {
            SmpLog.m6495e(str3, str, "fail to add feedback. db open fail.");
            return;
        }
        try {
            if (!isValidFeedback(dBHandlerOpen, str, feedbackEvent, str2)) {
                dBHandlerOpen.close();
                return;
            }
            if (dBHandlerOpen.addFeedbackData(str, feedbackEvent, str2)) {
                int i = C78271.f5251xb5cab96f[getUploadType(context, str, feedbackEvent).ordinal()];
                if (i == 1) {
                    DataManager.triggerUploadClientsForFeedback(context, str);
                } else if (i == 2) {
                    DataManager.triggerUploadClientsNow(context, false);
                }
            }
        } finally {
            dBHandlerOpen.close();
        }
    }

    public static void deleteFeedbacks(Context context, JSONArray jSONArray) {
        if (jSONArray == null) {
            SmpLog.m6494e(TAG, "deleteFeedbacks. error : marketings empty");
            return;
        }
        DBHandler dBHandlerOpen = DBHandler.open(context);
        if (dBHandlerOpen == null) {
            SmpLog.m6494e(TAG, "deleteFeedbacks. error : dbhandler null");
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                dBHandlerOpen.deleteFeedbacks(jSONObject.getString("mid"), new JSONArray(jSONObject.getString("feedback")));
            } catch (Exception e) {
                AbstractC6670b.m4737B(e, new StringBuilder("deleteFeedbacks. error : "), TAG);
            }
        }
        dBHandlerOpen.close();
    }

    public static int getExternalFeedbackDataCount(Context context) {
        DBHandler dBHandlerOpen = DBHandler.open(context);
        if (dBHandlerOpen == null) {
            SmpLog.m6494e(TAG, "db open fail");
            return -1;
        }
        int iCountExternalFeedbackData = dBHandlerOpen.countExternalFeedbackData();
        dBHandlerOpen.close();
        return iCountExternalFeedbackData;
    }

    private static UploadType getUploadType(Context context, String str, FeedbackEvent feedbackEvent) {
        if (isUserActionFbid(feedbackEvent)) {
            SmpLog.m6498i(TAG, "user action fbid. upload type: UPLOAD_NOW_IN_SMP_SERVICE");
            return UploadType.UPLOAD_NOW_IN_SMP_SERVICE;
        }
        try {
            if (SharedMemoryVariableManager.getInstance(context).isRunningRealtimeMidInFcmService(str)) {
                if (feedbackEvent == FeedbackEvent.CONSUMED && "2".equals(MarketingManager.getMarketing(context, str).getMarketingType())) {
                    SmpLog.m6498i(TAG, "popup and fbid is CONSUMED. upload type: UPLOAD_NOW_IN_SMP_SERVICE");
                    return UploadType.UPLOAD_NOW_IN_SMP_SERVICE;
                }
                SmpLog.m6498i(TAG, "running in fcm service. upload type: SKIP_NOW_AND_UPLOAD_LATER_IN_FCM_SERVICE");
                return UploadType.SKIP_NOW_AND_UPLOAD_LATER_IN_FCM_SERVICE;
            }
            if (feedbackEvent != FeedbackEvent.CONSUMED || MarketingManager.getMarketing(context, str).getRandomMinutes() <= 0) {
                SmpLog.m6498i(TAG, "upload type: DISPERSION_IN_SMP_SERVICE");
                return UploadType.DISPERSION_IN_SMP_SERVICE;
            }
            SmpLog.m6498i(TAG, "random is over 0 and fbid is CONSUMED. upload type: UPLOAD_NOW_IN_SMP_SERVICE");
            return UploadType.UPLOAD_NOW_IN_SMP_SERVICE;
        } catch (Exception e) {
            String str2 = TAG;
            SmpLog.m6494e(str2, e.toString());
            SmpLog.m6498i(str2, "default upload type: DISPERSION_IN_SMP_SERVICE");
            return UploadType.DISPERSION_IN_SMP_SERVICE;
        }
    }

    public static void handleClickFeedbackIntent(Context context, Intent intent) {
        if (context == null || intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra(Constants.EXTRA_SMP_FEEDBACK_PATH);
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        String stringExtra2 = intent.getStringExtra(Constants.EXTRA_SMP_SENDER_PACKAGE);
        String stringExtra3 = intent.getStringExtra(Constants.EXTRA_SMP_MID);
        String stringExtra4 = intent.getStringExtra(Constants.EXTRA_SMP_LINK_TYPE);
        HashSet<String> hashSet = sExternalClickFeedbackMids;
        if (hashSet.contains(stringExtra3)) {
            SmpLog.m6499i(TAG, stringExtra3, "handleClickFeedbackIntent. click feedback is already generated. ignore this");
            return;
        }
        hashSet.add(stringExtra3);
        String str = TAG;
        StringBuilder sbM16m = AbstractC0000a.m16m("handleClickFeedbackIntent. feedback path : ", stringExtra, ", sender:", stringExtra2, ", linkType:");
        sbM16m.append(stringExtra4);
        SmpLog.m6499i(str, stringExtra3, sbM16m.toString());
        if (context.getPackageName().equals(stringExtra2)) {
            Marketing.setToGone(context, stringExtra3, true);
            addFeedback(context, stringExtra3, FeedbackEvent.CLICKED, stringExtra4);
        } else {
            saveExternalFeedback(context, stringExtra);
            STaskDispatcher.dispatchOnService(context.getApplicationContext(), new STask(STask.CommonAction.UPLOAD_EXTERNAL_FEEDBACK, null));
        }
    }

    public static boolean hasFeedbacksToSend(Context context) {
        DBHandler dBHandlerOpen = DBHandler.open(context);
        if (dBHandlerOpen != null) {
            Map<String, JSONArray> allFeedbacksToSend = dBHandlerOpen.getAllFeedbacksToSend();
            dBHandlerOpen.close();
            if (allFeedbacksToSend.size() > 0) {
                return true;
            }
        }
        return false;
    }

    private static boolean isDuplicatesAllowed(FeedbackEvent feedbackEvent) {
        return feedbackEvent == FeedbackEvent.CLICKED || feedbackEvent == FeedbackEvent.CLICKED_BUTTON_1 || feedbackEvent == FeedbackEvent.CLICKED_BUTTON_2 || feedbackEvent == FeedbackEvent.CLICKED_BUTTON_3 || feedbackEvent == FeedbackEvent.SYSTEM_EVENT_RECEIVED || feedbackEvent == FeedbackEvent.CLIENT_DEBUG;
    }

    private static boolean isUserActionFbid(FeedbackEvent feedbackEvent) {
        return feedbackEvent == FeedbackEvent.CLICKED || feedbackEvent == FeedbackEvent.CLICKED_BUTTON_1 || feedbackEvent == FeedbackEvent.CLICKED_BUTTON_2 || feedbackEvent == FeedbackEvent.CLICKED_BUTTON_3 || feedbackEvent == FeedbackEvent.IGNORED;
    }

    private static boolean isValidFeedback(DBHandler dBHandler, String str, FeedbackEvent feedbackEvent, String str2) {
        if (feedbackEvent.equals(dBHandler.getLastFbid(str)) && !isDuplicatesAllowed(feedbackEvent)) {
            SmpLog.m6499i(TAG, str, "the feedback " + feedbackEvent + " is already added");
            return false;
        }
        if (FeedbackDetailConstants.APP_UPDATE.equals(str2) && dBHandler.isAppUpdateFeedbackAdded(str)) {
            SmpLog.m6499i(TAG, str, "app update feedback is already added");
            return false;
        }
        if (!FeedbackDetailConstants.REBOOT.equals(str2) || !dBHandler.isRebootFeedbackAdded(str)) {
            return true;
        }
        SmpLog.m6499i(TAG, str, "reboot feedback is already added");
        return false;
    }

    public static void saveExternalFeedback(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            SmpLog.m6494e(TAG, "save external feedback fail. ");
            return;
        }
        DBHandler dBHandlerOpen = DBHandler.open(context);
        if (dBHandlerOpen == null) {
            SmpLog.m6494e(TAG, "save external feedback fail. dbHandler null");
        } else {
            dBHandlerOpen.addExternalFeedbackData(str);
            dBHandlerOpen.close();
        }
    }

    public static void sendExternalFeedbacks(Context context) {
        long jCurrentTimeMillis;
        long j;
        if (context == null) {
            SmpLog.m6494e(TAG, "send external feedbacks fail. context null");
            return;
        }
        DBHandler dBHandlerOpen = DBHandler.open(context);
        if (dBHandlerOpen == null) {
            SmpLog.m6494e(TAG, "db open fail");
            return;
        }
        ArrayList<ExternalFeedbackUrlDataEntity> externalFeedbackList = dBHandlerOpen.getExternalFeedbackList();
        int externalFeedbackFailCount = 0;
        for (int i = 0; i < externalFeedbackList.size(); i++) {
            String path = externalFeedbackList.get(i).getPath();
            NetworkResult networkResultRequest = NetworkManager.request(context, new ExternalFeedbackRequest(path), 60);
            if (networkResultRequest.isSuccess()) {
                dBHandlerOpen.deleteExternalFeedbackData(path);
            } else if (networkResultRequest.getResponseCode() < 400 || networkResultRequest.getResponseCode() >= 500) {
                externalFeedbackFailCount = dBHandlerOpen.getExternalFeedbackFailCount(path) + 1;
                dBHandlerOpen.updateExternalFeedbackFailCount(path, externalFeedbackFailCount);
                if (externalFeedbackFailCount > 5) {
                    dBHandlerOpen.deleteExternalFeedbackData(path);
                }
            } else {
                dBHandlerOpen.deleteExternalFeedbackData(path);
            }
        }
        if (externalFeedbackFailCount > 0 && externalFeedbackFailCount <= 5) {
            if (externalFeedbackFailCount <= 3) {
                jCurrentTimeMillis = System.currentTimeMillis();
                j = MarketingConstants.UPLOAD_EXTERNAL_FEEDBACK_FIRST_DELAY_MILLIS;
            } else {
                jCurrentTimeMillis = System.currentTimeMillis();
                j = MarketingConstants.UPLOAD_EXTERNAL_FEEDBACK_SECOND_DELAY_MILLIS;
            }
            STaskDispatcher.setDispatchAlarm(context, new STask(STask.CommonAction.UPLOAD_EXTERNAL_FEEDBACK, null), jCurrentTimeMillis + j, 1);
        }
        dBHandlerOpen.close();
    }
}
