package com.samsung.android.sdk.smp.gdpr;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.smp.SmpAppFilter;
import com.samsung.android.sdk.smp.common.network.NetworkJSonRequest;
import com.samsung.android.sdk.smp.common.network.NetworkManager;
import com.samsung.android.sdk.smp.common.network.NetworkResult;
import com.samsung.android.sdk.smp.common.preference.InitOptionsHolder;
import com.samsung.android.sdk.smp.common.preference.PrefManager;
import com.samsung.android.sdk.smp.common.util.SmpLog;
import com.samsung.android.sdk.smp.task.STask;
import com.samsung.android.sdk.smp.task.STaskDispatcher;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class GDPRManager {
    public static final String GDPR_REQUEST_ID = "requestId";
    private static final String GDPR_REQUEST_TYPE = "gdprRequestType";
    private static final String MODIFIED_FILTER = "modifiedFilter";
    private static final String OPTIN = "optin";
    private static final String OPTIN_TIME = "optinsts";
    private static final String STATUS = "status";
    private static final String STATUS_COMPLETED = "COMPLETED";
    private static final String TAG = "GDPRManager";
    private static final String TYPE_RECTIFICATION = "RECTIFICATION";
    private static final String TYPE_UNSUBSCRIBE = "UNSUBSCRIBE";
    private static final String USERDATA = "userdata";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum GDPRRequestType {
        POST,
        GET
    }

    private static NetworkJSonRequest createGDPRRequest(Context context, String str, GDPRRequestType gDPRRequestType) {
        String appId = InitOptionsHolder.getInstance().getAppId(context);
        if (TextUtils.isEmpty(appId)) {
            SmpLog.m6494e(TAG, "Fail to handle GDPR request:appid null");
            return null;
        }
        PrefManager prefManager = PrefManager.getInstance(context);
        String smpID = prefManager.getSmpID();
        if (TextUtils.isEmpty(smpID)) {
            SmpLog.m6494e(TAG, "Fail to handle GDPR request:smpid null");
            return null;
        }
        String uid = prefManager.getUID();
        return GDPRRequestType.GET.equals(gDPRRequestType) ? new GetGDPRRequest(appId, str, smpID, uid) : new PostGDPRRequest(appId, str, smpID, uid);
    }

    public static void handleGDPRMessage(Context context, JSONObject jSONObject) {
        try {
            String string = jSONObject.getJSONObject("userdata").getString("requestId");
            Bundle bundle = new Bundle();
            bundle.putString("requestId", string);
            STaskDispatcher.dispatchOnService(context, new STask(STask.CommonAction.GDPR, bundle));
        } catch (JSONException e) {
            SmpLog.m6494e(TAG, "Fail to handle GDPR:invalid message. " + e.toString());
        }
    }

    private static void onGetGDPRSuccess(Context context, String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str2);
            String string = jSONObject.getString("status");
            if (STATUS_COMPLETED.equals(string)) {
                SmpLog.m6501w(TAG, "Stop GDPR request. status:" + string);
                return;
            }
            String string2 = jSONObject.getString(GDPR_REQUEST_TYPE);
            int iHashCode = string2.hashCode();
            if (iHashCode == -1558724943) {
                if (string2.equals(TYPE_UNSUBSCRIBE)) {
                    unsubscribe(context, jSONObject);
                    requestGDPR(context, str, GDPRRequestType.POST);
                    return;
                }
                return;
            }
            if (iHashCode == -744860454 && string2.equals(TYPE_RECTIFICATION) && rectification(context, jSONObject)) {
                requestGDPR(context, str, GDPRRequestType.POST);
            }
        } catch (JSONException e) {
            SmpLog.m6494e(TAG, "Fail to get GDPR request. " + e.toString());
        }
    }

    private static boolean rectification(Context context, JSONObject jSONObject) throws JSONException {
        HashMap map = new HashMap();
        JSONArray jSONArray = new JSONArray(jSONObject.getString(MODIFIED_FILTER));
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            Iterator<String> itKeys = jSONObject2.keys();
            if (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, jSONObject2.getString(next));
            }
        }
        try {
            SmpAppFilter.set(context, map);
            return true;
        } catch (Exception e) {
            AbstractC6670b.m4737B(e, new StringBuilder("rectification error. "), TAG);
            return false;
        }
    }

    public static void requestGDPR(Context context, String str, GDPRRequestType gDPRRequestType) {
        String str2 = TAG;
        SmpLog.m6498i(str2, "request:" + gDPRRequestType.name() + " GDPR");
        NetworkJSonRequest networkJSonRequestCreateGDPRRequest = createGDPRRequest(context, str, gDPRRequestType);
        if (networkJSonRequestCreateGDPRRequest == null) {
            SmpLog.m6494e(str2, "Fail to handle GDPR request. create request failed");
            return;
        }
        NetworkResult networkResultRequest = NetworkManager.request(context, networkJSonRequestCreateGDPRRequest, 60);
        if (networkResultRequest.isSuccess()) {
            SmpLog.m6498i(str2, "GDPR request success");
            if (GDPRRequestType.GET.equals(gDPRRequestType)) {
                onGetGDPRSuccess(context, str, networkResultRequest.getResponseMsg());
                return;
            }
            return;
        }
        SmpLog.m6494e(str2, "Fail to handle GDPR request. error code:" + networkResultRequest.getResponseCode() + ", error msg:" + networkResultRequest.getResponseMsg());
    }

    private static void unsubscribe(Context context, JSONObject jSONObject) throws JSONException {
        boolean z = jSONObject.getBoolean("optin");
        long j = jSONObject.getLong(OPTIN_TIME);
        PrefManager prefManager = PrefManager.getInstance(context);
        prefManager.setOptIn(z);
        prefManager.setOptInTime(j);
        SmpLog.m6497hi(TAG, "Apply the GDPR. optin:" + z + ", time:" + j);
    }
}
