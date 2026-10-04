package com.samsung.context.sdk.samsunganalytics.internal.sender.DLS;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.samsung.android.sdk.smp.common.database.DBContract;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.context.sdk.samsunganalytics.Configuration;
import com.samsung.context.sdk.samsunganalytics.internal.device.DeviceInfo;
import com.samsung.context.sdk.samsunganalytics.internal.policy.PolicyUtils;
import com.samsung.context.sdk.samsunganalytics.internal.sender.BaseLogSender;
import com.samsung.context.sdk.samsunganalytics.internal.sender.LogType;
import com.samsung.context.sdk.samsunganalytics.internal.sender.SimpleLog;
import com.samsung.context.sdk.samsunganalytics.internal.sender.buffering.Manager;
import com.samsung.context.sdk.samsunganalytics.internal.util.Debug;
import com.samsung.context.sdk.samsunganalytics.internal.util.Utils;
import com.sec.android.diagmonagent.common.util.CommonUtils;
import com.sec.android.diagmonagent.common.util.executor.AsyncTaskCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class DLSLogSender extends BaseLogSender {
    public static final int DB_SELECT_LIMIT = 200;
    private final DeviceInfo deviceInfo;

    public DLSLogSender(Context context, Configuration configuration) {
        super(context, configuration);
        this.deviceInfo = DeviceInfo.getDeviceInfo(context);
    }

    private int checkAvailableLogging(int i) {
        if (i == -4) {
            Debug.LogD("DLS Sender", "Network unavailable.");
            return -4;
        }
        if (!PolicyUtils.isPolicyExpired(this.context)) {
            return 0;
        }
        Debug.LogD("DLS Sender", "policy expired. request policy");
        return -6;
    }

    private void flushBufferedLogs(int i, LogType logType, Queue<SimpleLog> queue, AsyncTaskCallback asyncTaskCallback) {
        ArrayList arrayList = new ArrayList();
        Iterator<SimpleLog> it = queue.iterator();
        while (it.hasNext()) {
            LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
            int iMin = Math.min(51200, PolicyUtils.getRemainingQuota(this.context, i));
            int length = 0;
            while (it.hasNext()) {
                SimpleLog next = it.next();
                if (next.getType() == logType) {
                    if (next.getData().getBytes().length + length > iMin) {
                        break;
                    }
                    length += next.getData().getBytes().length;
                    linkedBlockingQueue.add(next);
                    it.remove();
                    arrayList.add(next.getId());
                    if (queue.isEmpty()) {
                        this.manager.remove(arrayList);
                        queue = this.manager.get(200);
                        it = queue.iterator();
                    }
                }
            }
            if (linkedBlockingQueue.isEmpty()) {
                return;
            }
            this.manager.remove(arrayList);
            int i2 = i;
            LogType logType2 = logType;
            sendSum(i2, logType2, linkedBlockingQueue, length, asyncTaskCallback);
            Debug.LogD("DLSLogSender", "send packet : num(" + linkedBlockingQueue.size() + ") size(" + length + ")");
            i = i2;
            logType = logType2;
        }
    }

    private int getNetworkType() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return -4;
        }
        return activeNetworkInfo.getType();
    }

    private int sendOne(int i, SimpleLog simpleLog, AsyncTaskCallback asyncTaskCallback) {
        if (simpleLog == null) {
            return -100;
        }
        int length = simpleLog.getData().getBytes().length;
        int iHasQuota = PolicyUtils.hasQuota(this.context, i, length);
        if (iHasQuota != 0) {
            return iHasQuota;
        }
        PolicyUtils.useQuota(this.context, i, length);
        this.executor.execute(new DLSAPIClient(simpleLog, this.configuration.getTrackingId(), asyncTaskCallback));
        return 0;
    }

    private void sendSum(int i, LogType logType, Queue<SimpleLog> queue, int i2, AsyncTaskCallback asyncTaskCallback) {
        PolicyUtils.useQuota(this.context, i, i2);
        this.executor.execute(new DLSAPIClient(logType, queue, this.configuration.getTrackingId(), asyncTaskCallback));
    }

    @Override // com.samsung.context.sdk.samsunganalytics.internal.sender.LogSender
    public int send(Map<String, String> map) {
        final int networkType = getNetworkType();
        int iCheckAvailableLogging = checkAvailableLogging(networkType);
        if (iCheckAvailableLogging != 0) {
            insert(map);
            if (iCheckAvailableLogging == -6) {
                PolicyUtils.updatePolicy(this.context, this.configuration, this.executor, this.deviceInfo);
                this.manager.delete();
            }
            return iCheckAvailableLogging;
        }
        AsyncTaskCallback asyncTaskCallback = new AsyncTaskCallback() { // from class: com.samsung.context.sdk.samsunganalytics.internal.sender.DLS.DLSLogSender.1
            @Override // com.sec.android.diagmonagent.common.util.executor.AsyncTaskCallback
            public void onFail(int i, String str, String str2, String str3) {
                Manager manager = ((BaseLogSender) DLSLogSender.this).manager;
                long j = Long.parseLong(str);
                LogType logType = LogType.DEVICE;
                if (!str3.equals(logType.getAbbrev())) {
                    logType = LogType.UIX;
                }
                manager.insert(j, str2, logType);
                PolicyUtils.useQuota(((BaseLogSender) DLSLogSender.this).context, networkType, str2.getBytes().length * (-1));
            }

            @Override // com.sec.android.diagmonagent.common.util.executor.AsyncTaskCallback
            public void onSuccess(int i, String str, String str2, String str3) {
            }
        };
        int iSendOne = sendOne(networkType, new SimpleLog(Long.parseLong(map.get(DBContract.AckColumns.TIMESTAMP)), makeBodyString(setCommonParamToLog(map)), getLogType(map)), asyncTaskCallback);
        if (iSendOne == -1) {
            return iSendOne;
        }
        Queue<SimpleLog> queue = this.manager.get(200);
        if (this.manager.isEnabledDatabaseBuffering()) {
            flushBufferedLogs(networkType, LogType.UIX, queue, asyncTaskCallback);
            flushBufferedLogs(networkType, LogType.DEVICE, queue, asyncTaskCallback);
            return iSendOne;
        }
        while (!queue.isEmpty() && (iSendOne = sendOne(networkType, queue.poll(), asyncTaskCallback)) != -1) {
        }
        return iSendOne;
    }

    @Override // com.samsung.context.sdk.samsunganalytics.internal.sender.BaseLogSender
    public Map<String, String> setCommonParamToLog(Map<String, String> map) {
        map.put("la", this.deviceInfo.getLanguage());
        if (!TextUtils.isEmpty(this.deviceInfo.getMcc())) {
            map.put("mcc", this.deviceInfo.getMcc());
        }
        if (!TextUtils.isEmpty(this.deviceInfo.getMnc())) {
            map.put("mnc", this.deviceInfo.getMnc());
        }
        map.put("dm", this.deviceInfo.getDeviceModel());
        map.put("auid", this.configuration.getDeviceId());
        map.put("do", this.deviceInfo.getAndroidVersion());
        map.put("av", CommonUtils.getPackageVersion(this.context));
        map.put("uv", this.configuration.getVersion());
        map.put(VPathDataCmd.RCurveTo, "6.05.079");
        map.put(VPathDataCmd.ArcTo, String.valueOf(this.configuration.getAuidType()));
        map.put("fv", this.deviceInfo.getFirmwareVersion());
        map.put("tid", this.configuration.getTrackingId());
        map.put("tz", String.valueOf(Utils.getTimeZoneOffset()));
        return map;
    }
}
