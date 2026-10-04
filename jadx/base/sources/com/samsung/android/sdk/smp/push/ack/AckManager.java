package com.samsung.android.sdk.smp.push.ack;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.samsung.android.sdk.smp.common.constants.Constants;
import com.samsung.android.sdk.smp.common.database.DBHandler;
import com.samsung.android.sdk.smp.common.database.entity.AckDataEntity;
import com.samsung.android.sdk.smp.common.network.NetworkManager;
import com.samsung.android.sdk.smp.common.network.NetworkResult;
import com.samsung.android.sdk.smp.common.preference.InitOptionsHolder;
import com.samsung.android.sdk.smp.common.preference.PrefManager;
import com.samsung.android.sdk.smp.common.util.SmpLog;
import com.samsung.android.sdk.smp.task.STask;
import com.samsung.android.sdk.smp.task.STaskDispatcher;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class AckManager {
    private static final String TAG = "AckManager";

    public static void dispatchSendAckTask(Context context) {
        if (isDeviceTimeChangedToThePastByCheckingAckSentTime(context)) {
            SmpLog.m6501w(TAG, "device time is changed. update last ack complete time");
            PrefManager.getInstance(context).setLastAckCompleteTime(System.currentTimeMillis());
        }
        STask sTask = new STask(STask.CommonAction.SEND_ACK, null);
        long availableAckTime = getAvailableAckTime(context);
        if (System.currentTimeMillis() <= availableAckTime) {
            STaskDispatcher.setDispatchAlarm(context, sTask, availableAckTime, 1);
        } else {
            STaskDispatcher.cancelDispatchAlarm(context.getApplicationContext(), sTask);
            STaskDispatcher.dispatchOnService(context.getApplicationContext(), sTask);
        }
    }

    private static long getAvailableAckTime(Context context) {
        PrefManager prefManager = PrefManager.getInstance(context);
        return (prefManager.getAckPeriod() * Constants.MINMILLIS) + prefManager.getLastAckCompleteTime();
    }

    public static boolean hasAckDataToSend(Context context) {
        if (context == null) {
            SmpLog.m6494e(TAG, "hasAckDataToSend fail. context null");
            return false;
        }
        DBHandler dBHandlerOpen = DBHandler.open(context);
        if (dBHandlerOpen == null) {
            SmpLog.m6494e(TAG, "hasAckDataToSend fail. dbHandler null");
            return false;
        }
        int ackCount = dBHandlerOpen.getAckCount();
        dBHandlerOpen.close();
        return ackCount > 0;
    }

    private static boolean isDeviceTimeChangedToThePastByCheckingAckSentTime(Context context) {
        return System.currentTimeMillis() < PrefManager.getInstance(context).getLastAckCompleteTime();
    }

    public static void saveAck(Context context, String str, String str2, String str3, String str4) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            SmpLog.m6494e(TAG, "saveAck fail. invalid request. reqId:" + str + ", pushType:" + str2);
            return;
        }
        DBHandler dBHandlerOpen = DBHandler.open(context);
        if (dBHandlerOpen == null) {
            SmpLog.m6494e(TAG, "saveAck fail. dbHandler null");
        } else {
            dBHandlerOpen.addAckData(str, System.currentTimeMillis(), str2, str3, str4);
            dBHandlerOpen.close();
        }
    }

    public static void sendAck(Context context) {
        if (context == null) {
            SmpLog.m6494e(TAG, "sendAck fail. context null");
            return;
        }
        DBHandler dBHandlerOpen = DBHandler.open(context);
        if (dBHandlerOpen == null) {
            SmpLog.m6494e(TAG, "sendAck fail. dbHandler null");
            return;
        }
        try {
            ArrayList<AckDataEntity> ackList = dBHandlerOpen.getAckList();
            if (ackList.size() == 0) {
                return;
            }
            String appId = InitOptionsHolder.getInstance().getAppId(context);
            if (TextUtils.isEmpty(appId)) {
                SmpLog.m6494e(TAG, "sendAck fail. appId is empty");
                dBHandlerOpen.deleteAckList(ackList);
                return;
            }
            NetworkResult networkResultRequest = NetworkManager.request(context, new AckRequest(context, appId, ackList), 60);
            if (networkResultRequest.isSuccess()) {
                PrefManager.getInstance(context).setLastAckCompleteTime(System.currentTimeMillis());
                dBHandlerOpen.deleteAckList(ackList);
            } else {
                if (networkResultRequest.getResponseCode() >= 400 && networkResultRequest.getResponseCode() < 500) {
                    dBHandlerOpen.deleteAckList(ackList);
                    return;
                }
                dBHandlerOpen.incrementAckFailCount();
                dBHandlerOpen.deleteOverRetryAck(5);
                if (dBHandlerOpen.getAckList().size() > 0) {
                    Bundle bundle = new Bundle();
                    bundle.putBoolean(Constants.EXTRA_IS_RETRY, true);
                    STaskDispatcher.setDispatchAlarm(context, new STask(STask.CommonAction.SEND_ACK, bundle), System.currentTimeMillis() + Constants.ACK_RETRY_DELAY_MILLIS, 1);
                }
            }
        } finally {
            dBHandlerOpen.close();
        }
    }
}
