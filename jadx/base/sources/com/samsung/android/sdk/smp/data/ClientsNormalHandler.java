package com.samsung.android.sdk.smp.data;

import android.content.Context;
import android.text.TextUtils;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.smp.common.constants.Constants;
import com.samsung.android.sdk.smp.common.constants.NetworkConfig;
import com.samsung.android.sdk.smp.common.network.NetworkManager;
import com.samsung.android.sdk.smp.common.network.NetworkResult;
import com.samsung.android.sdk.smp.common.preference.PrefManager;
import com.samsung.android.sdk.smp.common.util.DeviceInfoUtil;
import com.samsung.android.sdk.smp.common.util.SmpLog;
import com.samsung.android.sdk.smp.marketing.FeedbackManager;
import com.samsung.android.sdk.smp.spsclient.SpsUtil;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
class ClientsNormalHandler extends ClientsRequestHandler {
    private static final String TAG = "ClientsNormalHandler";

    public ClientsNormalHandler(Context context) {
        super(context);
    }

    private boolean handleWebIdSuccessResponse(String str) {
        try {
            String strOptString = new JSONObject(str).optString(NetworkConfig.FEEDBACK_WEB_ID);
            if (TextUtils.isEmpty(strOptString)) {
                return true;
            }
            getPrefManager().setWebId(strOptString);
            return true;
        } catch (Exception e) {
            AbstractC6670b.m4737B(e, new StringBuilder("invalid server response. "), TAG);
            afterError(1015, "server response error");
            return false;
        }
    }

    private int increaseFailCount() {
        PrefManager prefManager = getPrefManager();
        int uploadFailCount = prefManager.getUploadFailCount() + 1;
        prefManager.setUploadFailCount(uploadFailCount);
        return uploadFailCount;
    }

    private void retryUploadClients(int i) {
        if (FeedbackManager.hasFeedbacksToSend(getContext())) {
            DataManager.setUploadClientsAlarm(getContext(), System.currentTimeMillis() + (((long) (((i - 1) % 7) + 1)) * Constants.HOURMILLIS));
        } else if (i <= 3) {
            DataManager.setUploadClientsAlarm(getContext(), System.currentTimeMillis() + Constants.UPLOAD_RETRY_DELAY_MILLIS);
        }
    }

    @Override // com.samsung.android.sdk.smp.data.ClientsRequestHandler
    public void afterBuildRequestError(String str, String str2) {
        super.afterBuildRequestError(str, str2);
        retryUploadClients(increaseFailCount());
    }

    @Override // com.samsung.android.sdk.smp.data.ClientsRequestHandler
    public void afterError(int i, String str) {
        super.afterError(i, str);
        SmpLog.m6501w(TAG, "response code : " + i + ", msg : " + str);
        int iIncreaseFailCount = increaseFailCount();
        if (i < 400 || i >= 500) {
            retryUploadClients(iIncreaseFailCount);
        }
    }

    @Override // com.samsung.android.sdk.smp.data.ClientsRequestHandler
    public void afterSuccess(ClientsRequest clientsRequest, String str) {
        handleResponse(str);
        adjustDataAfterUploadDone(clientsRequest);
    }

    @Override // com.samsung.android.sdk.smp.data.ClientsRequestHandler
    public boolean beforeRequest() {
        String seedFromSps;
        if (!TextUtils.isEmpty(getPrefManager().getWebId())) {
            return true;
        }
        SmpLog.m6498i(TAG, "webid is empty. request to issue");
        String appId = getAppId();
        String smpId = getSmpId();
        if (TextUtils.isEmpty(appId) || TextUtils.isEmpty(smpId)) {
            afterError(1008, "webid request fail. appid/smpid is empty");
            return false;
        }
        if (DeviceInfoUtil.isSamsungPushService(getContext())) {
            seedFromSps = SpsUtil.getSeedFromSps(getContext());
            if (TextUtils.isEmpty(seedFromSps)) {
                afterError(1008, "webid request fail. sps seed is empty");
                return false;
            }
        } else {
            seedFromSps = null;
        }
        NetworkResult networkResultRequest = NetworkManager.request(getContext(), new SmpIdRequest(appId, seedFromSps, smpId), 30);
        if (networkResultRequest.isSuccess()) {
            return handleWebIdSuccessResponse(networkResultRequest.getResponseMsg());
        }
        afterError(networkResultRequest.getResponseCode(), networkResultRequest.getResponseMsg());
        return false;
    }
}
