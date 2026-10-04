package com.samsung.android.sdk.smp.data;

import android.content.Context;
import android.text.TextUtils;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.smp.common.constants.NetworkConfig;
import com.samsung.android.sdk.smp.common.exception.IErrors;
import com.samsung.android.sdk.smp.common.network.NetworkManager;
import com.samsung.android.sdk.smp.common.network.NetworkResult;
import com.samsung.android.sdk.smp.common.preference.PrefManager;
import com.samsung.android.sdk.smp.common.util.BroadcastUtil;
import com.samsung.android.sdk.smp.common.util.DeviceInfoUtil;
import com.samsung.android.sdk.smp.common.util.SmpLog;
import com.samsung.android.sdk.smp.spsclient.SpsUtil;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
class ClientsInitialHandler extends ClientsRequestHandler {
    private static final String RESPONSE_DEVICEID = "deviceid";
    private static final String RESPONSE_SMPID = "smpid";
    private static final String TAG = "ClientsInitialHandler";

    public ClientsInitialHandler(Context context) {
        super(context);
    }

    private boolean handleSmpIdSuccessResponse(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (DeviceInfoUtil.isSamsungPushService(getContext())) {
                String string = jSONObject.getString("deviceid");
                if (TextUtils.isEmpty(string)) {
                    SmpLog.m6494e(TAG, "invalid server response. sps deviceid null");
                    BroadcastUtil.broadcastSmpInitFail(getContext(), IErrors.ERROR_CODE_SMP_0502, IErrors.ERROR_MESSAGE_SMP_0502);
                    return false;
                }
                if (!SpsUtil.setDeviceIdAppFilter(getContext(), string)) {
                    SmpLog.m6494e(TAG, "fail to set sps deviceid");
                    BroadcastUtil.broadcastSmpInitFail(getContext(), IErrors.ERROR_CODE_SMP_0401, IErrors.ERROR_MESSAGE_SMP_0401);
                    return false;
                }
            }
            String string2 = jSONObject.getString("smpid");
            if (TextUtils.isEmpty(string2)) {
                SmpLog.m6494e(TAG, "invalid server response. smpid is null");
                BroadcastUtil.broadcastSmpInitFail(getContext(), IErrors.ERROR_CODE_SMP_0502, IErrors.ERROR_MESSAGE_SMP_0502);
                return false;
            }
            getPrefManager().setSmpID(string2);
            updateSmpId(string2);
            String strOptString = jSONObject.optString(NetworkConfig.FEEDBACK_WEB_ID);
            if (TextUtils.isEmpty(strOptString)) {
                return true;
            }
            getPrefManager().setWebId(strOptString);
            return true;
        } catch (Exception e) {
            AbstractC6670b.m4737B(e, new StringBuilder("invalid server response. "), TAG);
            BroadcastUtil.broadcastSmpInitFail(getContext(), IErrors.ERROR_CODE_SMP_0502, IErrors.ERROR_MESSAGE_SMP_0502);
            return false;
        }
    }

    private boolean setFirstUploadTime(String str) {
        if (getPrefManager().getSmpFirstUploadTime() > 0) {
            SmpLog.m6498i(TAG, "already have first upload time. skip setting firstUploadTime");
            return true;
        }
        try {
            getPrefManager().setSmpFristUploadTime(new JSONObject(str).getLong(NetworkConfig.CLIENTS_INIT_STS));
            return true;
        } catch (Exception e) {
            AbstractC6670b.m4737B(e, new StringBuilder("invalid server response. "), TAG);
            return false;
        }
    }

    @Override // com.samsung.android.sdk.smp.data.ClientsRequestHandler
    public void afterBuildRequestError(String str, String str2) {
        super.afterBuildRequestError(str, str2);
        BroadcastUtil.broadcastSmpInitFail(getContext(), str, str2);
    }

    @Override // com.samsung.android.sdk.smp.data.ClientsRequestHandler
    public void afterError(int i, String str) {
        String str2;
        String strM1616f;
        super.afterError(i, str);
        if (i < 1000) {
            strM1616f = AbstractC2322a.m1616f(i, "Internal server error - ", ":", str);
            str2 = IErrors.ERROR_CODE_SMP_0501;
        } else if (i == 1002 || i == 1003 || i == 1010) {
            str2 = IErrors.ERROR_CODE_SMP_0301;
            strM1616f = IErrors.ERROR_MESSAGE_SMP_0301;
        } else if (i != 1015) {
            str2 = IErrors.ERROR_CODE_SMP_0401;
            strM1616f = IErrors.ERROR_MESSAGE_SMP_0401;
        } else {
            str2 = IErrors.ERROR_CODE_SMP_0502;
            strM1616f = IErrors.ERROR_MESSAGE_SMP_0502;
        }
        BroadcastUtil.broadcastSmpInitFail(getContext(), str2, strM1616f);
    }

    @Override // com.samsung.android.sdk.smp.data.ClientsRequestHandler
    public void afterSuccess(ClientsRequest clientsRequest, String str) {
        if (!setFirstUploadTime(str)) {
            BroadcastUtil.broadcastSmpInitFail(getContext(), IErrors.ERROR_CODE_SMP_0502, IErrors.ERROR_MESSAGE_SMP_0502);
            return;
        }
        handleResponse(str);
        adjustDataAfterUploadDone(clientsRequest);
        BroadcastUtil.broadcastSmpInitSuccess(getContext(), true);
    }

    @Override // com.samsung.android.sdk.smp.data.ClientsRequestHandler
    public boolean beforeRequest() {
        String seedFromSps;
        String appId = getAppId();
        if (TextUtils.isEmpty(appId)) {
            SmpLog.m6494e(TAG, "request fail. appid null");
            BroadcastUtil.broadcastSmpInitFail(getContext(), IErrors.ERROR_CODE_SMP_0401, IErrors.ERROR_MESSAGE_SMP_0401);
            return false;
        }
        boolean zIsSamsungPushService = DeviceInfoUtil.isSamsungPushService(getContext());
        String smpId = getSmpId();
        if (zIsSamsungPushService) {
            if (PrefManager.getInstance(getContext()).isRandomSmpIdGenerated()) {
                SmpLog.m6498i(TAG, "already have random smpid. skip generation");
                return true;
            }
        } else if (!TextUtils.isEmpty(smpId)) {
            SmpLog.m6498i(TAG, "already have smpid. skip generation");
            return true;
        }
        if (zIsSamsungPushService) {
            seedFromSps = SpsUtil.getSeedFromSps(getContext());
            if (TextUtils.isEmpty(seedFromSps)) {
                SmpLog.m6494e(TAG, "request fail. seed null");
                BroadcastUtil.broadcastSmpInitFail(getContext(), IErrors.ERROR_CODE_SMP_0102, IErrors.ERROR_MESSAGE_SMP_0102);
                return false;
            }
        } else {
            seedFromSps = null;
        }
        NetworkResult networkResultRequest = NetworkManager.request(getContext(), new SmpIdRequest(appId, seedFromSps, null), 30);
        if (networkResultRequest.isSuccess()) {
            return handleSmpIdSuccessResponse(networkResultRequest.getResponseMsg());
        }
        afterError(networkResultRequest.getResponseCode(), networkResultRequest.getResponseMsg());
        return false;
    }
}
