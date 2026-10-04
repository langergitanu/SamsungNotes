package com.samsung.android.sdk.smp.push.ack;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.samsung.android.sdk.smp.common.constants.NetworkConfig;
import com.samsung.android.sdk.smp.common.database.entity.AckDataEntity;
import com.samsung.android.sdk.smp.common.exception.InternalException;
import com.samsung.android.sdk.smp.common.network.NetworkJSonRequest;
import com.samsung.android.sdk.smp.common.network.NetworkRequest;
import com.samsung.android.sdk.smp.common.preference.PrefManager;
import com.samsung.android.sdk.smp.common.util.SmpLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
class AckRequest extends NetworkJSonRequest {
    private static final String TAG = "AckRequest";
    private final ArrayList<AckDataEntity> mAckList;
    private final String mAppId;
    private final Context mContext;

    public AckRequest(Context context, String str, ArrayList<AckDataEntity> arrayList) {
        this.mContext = context;
        this.mAppId = str;
        this.mAckList = arrayList;
    }

    private JSONObject convertAckDataToJson(AckDataEntity ackDataEntity) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(NetworkConfig.ACK_REQUEST_ID, ackDataEntity.getRequestId() != null ? ackDataEntity.getRequestId() : "");
        jSONObject.put("timestamp", ackDataEntity.getTimestamp());
        if (!TextUtils.isEmpty(ackDataEntity.getErrorCode())) {
            jSONObject.put("errorCode", ackDataEntity.getErrorCode());
        }
        if (!TextUtils.isEmpty(ackDataEntity.getErrorMsg())) {
            jSONObject.put(NetworkConfig.ACK_ERROR_MSG, ackDataEntity.getErrorMsg());
        }
        return jSONObject;
    }

    @Override // com.samsung.android.sdk.smp.common.network.NetworkJSonRequest
    public JSONObject getJsonRequestBody() throws InternalException.InvalidDataException {
        PrefManager prefManager = PrefManager.getInstance(this.mContext);
        String pushToken = prefManager.getPushToken();
        String pushType = prefManager.getPushType();
        JSONObject jSONObject = new JSONObject();
        if (pushType == null) {
            pushType = "";
        }
        try {
            jSONObject.put("ptype", pushType);
            if (pushToken == null) {
                pushToken = "";
            }
            jSONObject.put(NetworkConfig.ACK_PUSH_TOKEN, pushToken);
            JSONArray jSONArray = new JSONArray();
            Iterator<AckDataEntity> it = this.mAckList.iterator();
            while (it.hasNext()) {
                jSONArray.put(convertAckDataToJson(it.next()));
            }
            jSONObject.put("data", jSONArray);
            return jSONObject;
        } catch (JSONException e) {
            SmpLog.m6494e(TAG, e.toString());
            throw new InternalException.InvalidDataException();
        }
    }

    @Override // com.samsung.android.sdk.smp.common.network.NetworkRequest
    public int getRequestMethod() {
        return 1;
    }

    @Override // com.samsung.android.sdk.smp.common.network.NetworkRequest
    public String getServerUrl(Context context) {
        Uri baseUrl = NetworkRequest.getBaseUrl(context);
        if (baseUrl == null) {
            return null;
        }
        return baseUrl.buildUpon().appendPath(this.mAppId).appendPath("ack").toString();
    }

    @Override // com.samsung.android.sdk.smp.common.network.NetworkJSonRequest
    public boolean isGzipEnabled() {
        return false;
    }
}
