package com.samsung.context.sdk.samsunganalytics.internal.setting;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import com.samsung.android.sdk.smp.common.database.DBContract;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.context.sdk.samsunganalytics.Configuration;
import com.samsung.context.sdk.samsunganalytics.internal.policy.PolicyUtils;
import com.samsung.context.sdk.samsunganalytics.internal.sender.LogType;
import com.samsung.context.sdk.samsunganalytics.internal.sender.Sender;
import com.samsung.context.sdk.samsunganalytics.internal.util.Debug;
import com.samsung.context.sdk.samsunganalytics.internal.util.Preferences;
import com.samsung.context.sdk.samsunganalytics.internal.util.Utils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.AbstractC12991c;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SettingLogSender {
    private final Configuration config;
    private final Context context;

    public SettingLogSender(Context context, Configuration configuration) {
        this.context = context;
        this.config = configuration;
    }

    private Map<String, String> getBasicLogs() {
        return getBasicLogs(String.valueOf(System.currentTimeMillis()));
    }

    private boolean sendLogWithProvider(List<String> list) {
        Uri uriInsert;
        String strValueOf = String.valueOf(System.currentTimeMillis());
        ContentValues contentValues = new ContentValues();
        contentValues.put("tcType", Integer.valueOf(this.config.isEnableUseInAppLogging() ? 1 : 0));
        contentValues.put("tid", this.config.getTrackingId());
        contentValues.put("logType", LogType.UIX.getAbbrev());
        contentValues.put("timeStamp", strValueOf);
        contentValues.put("agree", Integer.valueOf(this.config.getUserAgreement().isAgreement() ? 1 : 0));
        if (!Utils.isSendingAppCommonSupported(this.context)) {
            Utils.addAppCommonData(this.context, contentValues, this.config);
        }
        if (Utils.isAddingContentValueKeyAllowed(this.context)) {
            contentValues.put("networkType", Integer.valueOf(this.config.getNetworkType()));
        }
        Map<String, String> basicLogs = getBasicLogs(strValueOf);
        basicLogs.put(VPathDataCmd.RCurveTo, "6.05.079");
        basicLogs.put("tz", String.valueOf(Utils.getTimeZoneOffset()));
        Uri uri = Uri.parse("content://com.sec.android.log.diagmonagent.sa/log");
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            basicLogs.put("sti", it.next());
            contentValues.put("body", Utils.makeDelimiterString(basicLogs, Utils.Depth.ONE_DEPTH));
            try {
                uriInsert = this.context.getContentResolver().insert(uri, contentValues);
            } catch (IllegalArgumentException e) {
                Debug.logwingW("failed to send setting log" + e.getMessage());
                uriInsert = null;
            }
            if (uriInsert == null) {
                return false;
            }
            int i = Integer.parseInt(uriInsert.getLastPathSegment());
            if (i != 0 && i != 2) {
                return false;
            }
        }
        return true;
    }

    private boolean sendLogWithSender(List<String> list) {
        Map<String, String> basicLogs = getBasicLogs();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            basicLogs.put("sti", it.next());
            if (Sender.get(this.context, PolicyUtils.getSenderType(), this.config).send(basicLogs) != 0) {
                return false;
            }
        }
        return true;
    }

    public void sendLog() {
        boolean zSendLogWithSender;
        boolean zIsAgreement = this.config.getUserAgreement().isAgreement();
        if (!Utils.isProvidingDataSupported(this.context) && !zIsAgreement) {
            Debug.LogD("user do not agree setting");
            return;
        }
        if (!Utils.compareDays(1, Long.valueOf(Preferences.getPreferences(this.context).getLong(Preferences.STATUS_SENT_DATE, 0L)))) {
            Debug.LogD("do not send setting < 1day");
            return;
        }
        List<String> list = new SettingLogReader(this.context).read();
        if (list == null || list.isEmpty()) {
            Debug.LogD("Setting Sender", "No status log");
            return;
        }
        Debug.LogD("Send Setting Log");
        int senderType = PolicyUtils.getSenderType();
        if (senderType == 3) {
            zSendLogWithSender = sendLogWithProvider(list);
        } else if (senderType == 2 || senderType == 0) {
            zSendLogWithSender = sendLogWithSender(list);
        } else {
            Debug.logwingW("Sender type is invalid : " + senderType);
            zSendLogWithSender = false;
        }
        if (zSendLogWithSender) {
            Preferences.getPreferences(this.context).edit().putLong(Preferences.STATUS_SENT_DATE, System.currentTimeMillis()).apply();
        } else {
            Preferences.getPreferences(this.context).edit().putLong(Preferences.STATUS_SENT_DATE, 0L).apply();
        }
        Debug.LogD("Send Setting Log Result = " + zSendLogWithSender);
    }

    private Map<String, String> getBasicLogs(String str) {
        return AbstractC12991c.m13996q(DBContract.AckColumns.TIMESTAMP, str, "t", "st");
    }
}
