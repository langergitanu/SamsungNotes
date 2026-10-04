package com.samsung.context.sdk.samsunganalytics.internal.property;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import com.samsung.android.sdk.smp.common.database.DBContract;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.context.sdk.samsunganalytics.Configuration;
import com.samsung.context.sdk.samsunganalytics.internal.policy.PolicyUtils;
import com.samsung.context.sdk.samsunganalytics.internal.policy.Validation;
import com.samsung.context.sdk.samsunganalytics.internal.sender.LogType;
import com.samsung.context.sdk.samsunganalytics.internal.sender.Sender;
import com.samsung.context.sdk.samsunganalytics.internal.util.AuthUtil;
import com.samsung.context.sdk.samsunganalytics.internal.util.Debug;
import com.samsung.context.sdk.samsunganalytics.internal.util.Preferences;
import com.samsung.context.sdk.samsunganalytics.internal.util.Utils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class PropertyLogSender {
    private static final String URI = "content://com.sec.android.log.diagmonagent.sa/log";
    private final Configuration config;
    private final Context context;

    public PropertyLogSender(Context context, Configuration configuration) {
        this.context = context;
        this.config = configuration;
    }

    private boolean needToSendProperty(Context context, String str) {
        String string = Preferences.getPreferences(context).getString(Preferences.PROPERTY_DATA, "");
        long j = Preferences.getPreferences(context).getLong(Preferences.PROPERTY_SENT_DATE, 0L);
        if (string.equals(str) && !Utils.compareDays(1, Long.valueOf(j))) {
            Debug.LogD("do not send property < 1day");
            return false;
        }
        Preferences.getPreferences(context).edit().putString(Preferences.PROPERTY_DATA, str).apply();
        Preferences.getPreferences(context).edit().putLong(Preferences.PROPERTY_SENT_DATE, System.currentTimeMillis()).apply();
        Debug.LogI("update property, send it");
        return true;
    }

    public void sendLog() {
        int iSend;
        Uri uriInsert;
        boolean zIsAgreement = this.config.getUserAgreement().isAgreement();
        if (!Utils.isProvidingDataSupported(this.context) && !zIsAgreement) {
            Debug.LogD("user do not agree Property");
            return;
        }
        Map<String, ?> all = Preferences.getPropertyPreferences(this.context).getAll();
        if (all != null && !this.config.isEnableUseInAppLogging()) {
            all.remove("guid");
        }
        if (all == null || all.isEmpty()) {
            Debug.LogD("PropertyLogBuildClient", "No Property log");
            return;
        }
        String strMakeDelimiterString = Utils.makeDelimiterString(Validation.checkSizeLimit(all), Utils.Depth.TWO_DEPTH);
        if (needToSendProperty(this.context, AuthUtil.sha256(strMakeDelimiterString))) {
            Debug.LogI("Send Property Log");
            HashMap map = new HashMap();
            String strValueOf = String.valueOf(System.currentTimeMillis());
            map.put(DBContract.AckColumns.TIMESTAMP, strValueOf);
            map.put("t", "pp");
            map.put("cp", strMakeDelimiterString);
            if (PolicyUtils.getSenderType() >= 3) {
                map.put(VPathDataCmd.RCurveTo, "6.05.079");
                map.put("tz", String.valueOf(Utils.getTimeZoneOffset()));
                ContentValues contentValues = new ContentValues();
                contentValues.put("tcType", Integer.valueOf(this.config.isEnableUseInAppLogging() ? 1 : 0));
                contentValues.put("tid", this.config.getTrackingId());
                contentValues.put("logType", LogType.UIX.getAbbrev());
                contentValues.put("timeStamp", strValueOf);
                contentValues.put("agree", Integer.valueOf(zIsAgreement ? 1 : 0));
                contentValues.put("body", Utils.makeDelimiterString(map, Utils.Depth.ONE_DEPTH));
                if (!Utils.isSendingAppCommonSupported(this.context)) {
                    Utils.addAppCommonData(this.context, contentValues, this.config);
                }
                if (Utils.isAddingContentValueKeyAllowed(this.context)) {
                    contentValues.put("networkType", Integer.valueOf(this.config.getNetworkType()));
                }
                try {
                    uriInsert = this.context.getContentResolver().insert(Uri.parse(URI), contentValues);
                } catch (IllegalArgumentException e) {
                    Debug.logwingE("failed to send properties" + e.getMessage());
                    uriInsert = null;
                }
                if (uriInsert == null) {
                    Debug.LogD("Property send fail");
                    return;
                }
                iSend = Integer.parseInt(uriInsert.getLastPathSegment());
            } else {
                iSend = Sender.get(this.context, PolicyUtils.getSenderType(), this.config).send(map);
            }
            Debug.LogI("Send Property Log Result = " + iSend);
        }
    }
}
