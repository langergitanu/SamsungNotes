package com.samsung.android.sdk.smp.push;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.sdk.smp.common.preference.PrefManager;
import com.samsung.android.sdk.smp.common.util.DeviceInfoUtil;
import com.samsung.android.sdk.smp.common.util.SmpLog;
import com.samsung.android.sdk.smp.gdpr.GDPRManager;
import com.samsung.android.sdk.smp.marketing.MarketingManager;
import com.samsung.android.sdk.smp.push.ack.AckManager;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class PushMsgHandler {
    private static final String ERROR_CODE_INVALID_PUSHTYPE = "EACK001";
    private static final String FCM_REQUESTID = "smp-requestID";
    private static final String MSG_TYPE = "type";
    private static final String SMP_MSG_KEY = "ppmt";
    private static final String TAG = "PushMsgHandler";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ISmpPushInterface {
        void generalMessageReceivedImpl();

        void marketingMessageReceivedImpl(String str, String str2);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface MsgType {
        public static final String MARKETING = "marketing";
        public static final String PASSIVE = "passive";
        public static final String SYSTEM_GDPR = "system_gdpr";
        public static final String TEST = "test";
    }

    private String getRequestId(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        Matcher matcher = Pattern.compile("^(smp)-[a-zA-Z0-9]*-[0-9]*").matcher(str2);
        return matcher.find() ? str2.substring(0, matcher.end()) : ("spp".equals(str) && str2.contains(Log.TAG_SEPARATOR)) ? str2.substring(0, str2.lastIndexOf(64)) : str2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0068, code lost:
    
        if (r5.equals("marketing") != false) goto L28;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0077 A[Catch: Exception -> 0x0056, TryCatch #1 {Exception -> 0x0056, blocks: (B:15:0x0038, B:16:0x0048, B:43:0x00ab, B:18:0x004c, B:28:0x006a, B:30:0x0077, B:37:0x008b, B:32:0x007f, B:33:0x0083, B:23:0x0058, B:26:0x0062, B:39:0x009d, B:41:0x00a6, B:34:0x0086), top: B:49:0x0038, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean handleSmpMessage(Context context, String str, int i, ISmpPushInterface iSmpPushInterface, boolean z) {
        if (PrefManager.getInstance(context).isSmpDeactivated()) {
            SmpLog.m6497hi(TAG, "message received but deactivated");
            return false;
        }
        if (!PushHelper.isPushRegComplete(context)) {
            SmpLog.m6497hi(TAG, "message received but push registration is not done");
            return false;
        }
        if (DeviceInfoUtil.hasSppForceActivationFeature()) {
            SmpLog.m6497hi(TAG, "message received but not supported : spp force activation feature");
            return false;
        }
        String str2 = TAG;
        SmpLog.m6498i(str2, str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("type");
            switch (string.hashCode()) {
                case -1535532113:
                    if (string.equals(MsgType.SYSTEM_GDPR)) {
                        GDPRManager.handleGDPRMessage(context, jSONObject);
                    }
                    SmpLog.m6494e(str2, "Invalid message. wrong type : ".concat(string));
                    break;
                case -933770714:
                    break;
                case -792039641:
                    if (string.equals("passive")) {
                        String strOptString = jSONObject.optString("extra", null);
                        if (!DeviceInfoUtil.isOnlySupportGeneralPush(context)) {
                            SmpLog.m6496he(str2, "failed. device does not support");
                        } else if (z) {
                            MarketingManager.handleSppMessage(context, str);
                        } else {
                            MarketingManager.handleFcmMessage(context, str, i);
                        }
                        try {
                            iSmpPushInterface.marketingMessageReceivedImpl(str, strOptString);
                        } catch (Exception e) {
                            SmpLog.m6494e(TAG, "Error while handling marketingMessageReceivedImpl. " + e);
                        }
                    }
                    SmpLog.m6494e(str2, "Invalid message. wrong type : ".concat(string));
                    break;
                case 3556498:
                    if (string.equals("test")) {
                        String strOptString2 = jSONObject.optString("extra", null);
                        if (!DeviceInfoUtil.isOnlySupportGeneralPush(context)) {
                        }
                        iSmpPushInterface.marketingMessageReceivedImpl(str, strOptString2);
                    }
                    SmpLog.m6494e(str2, "Invalid message. wrong type : ".concat(string));
                    break;
                default:
                    SmpLog.m6494e(str2, "Invalid message. wrong type : ".concat(string));
                    break;
            }
        } catch (Exception e2) {
            SmpLog.m6494e(TAG, "Invalid message. " + e2);
            return false;
        }
        return false;
        return false;
    }

    private void sendMessageAck(Context context, String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str2)) {
            SmpLog.m6497hi(TAG, "reqId is empty. do not send ack");
            return;
        }
        String str5 = TAG;
        SmpLog.m6498i(str5, "message received [reqId:" + str2 + "]");
        if (!PushHelper.isPushRegComplete(context)) {
            SmpLog.m6497hi(str5, "message received but push registration is not done");
        } else {
            AckManager.saveAck(context, str2, str, str3, str4);
            AckManager.dispatchSendAckTask(context);
        }
    }

    public void handleFcmMessage(Context context, Map<String, String> map, int i, ISmpPushInterface iSmpPushInterface) {
        String str;
        String requestId;
        String str2;
        String str3;
        boolean zHandleSmpMessage;
        if (!DeviceInfoUtil.isSupportCountryCode()) {
            SmpLog.m6496he(TAG, "The current country code is not supported on this sdk. should check the sdk that you are importing.");
            return;
        }
        String str4 = "fcm";
        String str5 = null;
        if (map == null) {
            requestId = getRequestId("fcm", null);
            str = null;
        } else {
            str = map.get(SMP_MSG_KEY);
            requestId = getRequestId("fcm", map.get(FCM_REQUESTID));
        }
        String str6 = requestId;
        if (str != null) {
            SmpLog.m6497hi(TAG, "message received : smp");
            zHandleSmpMessage = handleSmpMessage(context, str, i, iSmpPushInterface, false);
            str3 = null;
            str2 = null;
        } else {
            String str7 = TAG;
            SmpLog.m6497hi(str7, "message received : general");
            String pushType = PrefManager.getInstance(context).getPushType();
            if ("fcm".equals(pushType)) {
                iSmpPushInterface.generalMessageReceivedImpl();
                str4 = null;
            } else {
                SmpLog.m6497hi(str7, "message received but type mismatched. type : " + pushType);
                SmpLog.m6494e(str7, "error : " + str6 + " will not be delivered");
                str5 = ERROR_CODE_INVALID_PUSHTYPE;
            }
            str2 = str4;
            str3 = str5;
            zHandleSmpMessage = true;
        }
        if (zHandleSmpMessage) {
            sendMessageAck(context, "fcm", str6, str3, str2);
        }
    }

    public void handleSPPMessage(Context context, Bundle bundle, ISmpPushInterface iSmpPushInterface) {
        String requestId;
        String string;
        String str;
        String str2;
        boolean zHandleSmpMessage;
        if (!DeviceInfoUtil.isSupportCountryCode()) {
            SmpLog.m6496he(TAG, "The current country code is not supported on this sdk. should check the sdk that you are importing.");
            return;
        }
        String str3 = "spp";
        String str4 = null;
        if (bundle == null) {
            requestId = getRequestId("spp", null);
            string = null;
        } else {
            requestId = getRequestId("spp", bundle.getString("notificationId"));
            string = bundle.getString("msg");
        }
        String str5 = requestId;
        if (SMP_MSG_KEY.equals(string)) {
            SmpLog.m6497hi(TAG, "message received : smp");
            zHandleSmpMessage = handleSmpMessage(context, bundle.getString("appData"), 0, iSmpPushInterface, true);
            str2 = null;
            str = null;
        } else {
            String str6 = TAG;
            SmpLog.m6497hi(str6, "message received : general");
            String pushType = PrefManager.getInstance(context).getPushType();
            if ("spp".equals(pushType)) {
                iSmpPushInterface.generalMessageReceivedImpl();
                str3 = null;
            } else {
                SmpLog.m6497hi(str6, "message received but type mismatched. type : " + pushType);
                SmpLog.m6494e(str6, "error : " + str5 + " will not be delivered");
                str4 = ERROR_CODE_INVALID_PUSHTYPE;
            }
            str = str3;
            str2 = str4;
            zHandleSmpMessage = true;
        }
        if (zHandleSmpMessage) {
            sendMessageAck(context, "spp", str5, str2, str);
        }
    }
}
