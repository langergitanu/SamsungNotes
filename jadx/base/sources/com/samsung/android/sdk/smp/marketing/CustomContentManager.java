package com.samsung.android.sdk.smp.marketing;

import android.content.Context;
import com.samsung.android.sdk.smp.common.constants.FeedbackDetailConstants;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.sdk.smp.common.exception.InternalException;
import com.samsung.android.sdk.smp.common.network.NetworkManager;
import com.samsung.android.sdk.smp.common.network.NetworkResult;
import com.samsung.android.sdk.smp.common.util.SmpLog;
import com.samsung.android.sdk.smp.common.util.TimeUtil;
import com.samsung.android.sdk.smp.marketing.MarketingParser;
import com.samsung.android.sdk.smp.marketing.customcontent.CustomContentRequest;
import com.samsung.android.sdk.smp.marketing.customcontent.CustomContentResult;
import com.samsung.android.sdk.smp.marketing.customcontent.entity.CustomContentEntity;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class CustomContentManager {
    private static final String TAG = "CustomContentManager";

    private static CustomContentResult getResponse(CustomContentEntity customContentEntity, String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception e) {
            SmpLog.m6494e(TAG, "Fail to parse custom content response. " + e);
        }
        if (MarketingConstants.CustomContentConst.NUDGE.equals(customContentEntity.path)) {
            return handleNudgeResponse(customContentEntity.mid, new JSONObject(customContentEntity.userdata), jSONObject);
        }
        SmpLog.m6494e(TAG, "invalid custom content type : " + customContentEntity.path);
        return CustomContentResult.fail(FeedbackDetailConstants.INVALID_CUSTOM_CONTENT_RESPONSE);
    }

    private static CustomContentResult handleNetworkError(NetworkResult networkResult) {
        String responseMsg = networkResult.getResponseMsg();
        if (responseMsg == null) {
            responseMsg = "null";
        }
        SmpLog.m6494e(TAG, "Fail to handle custom content request. error code:" + networkResult.getResponseCode() + ", error msg:" + responseMsg);
        return CustomContentResult.fail(networkResult.getResponseCode() + "_" + responseMsg.replaceAll(" ", "_"));
    }

    private static CustomContentResult handleNudgeResponse(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            String string = jSONObject2.getString("cardDisplayTime");
            String string2 = jSONObject2.getString("cardDisplayTimeMin");
            int i = jSONObject2.getInt("random");
            if (!isValidTime(MarketingParser.parseDisplayTime(str, jSONObject2), i)) {
                return CustomContentResult.fail(FeedbackDetailConstants.INVALID_TIME);
            }
            jSONObject.put("cardDisplayTime", string);
            jSONObject.put("cardDisplayTimeMin", string2);
            jSONObject.put("random", i);
            return CustomContentResult.success(jSONObject.toString());
        } catch (InternalException.WrongMarketingDataException | JSONException unused) {
            return CustomContentResult.fail(FeedbackDetailConstants.INVALID_CUSTOM_CONTENT_RESPONSE);
        }
    }

    private static boolean isValidTime(MarketingParser.PairTime<TimeUtil.Time> pairTime, int i) {
        if (pairTime.start.getHour() >= 0 && pairTime.start.getHour() <= 24 && pairTime.end.getHour() >= 0 && pairTime.end.getHour() <= 24 && pairTime.start.getMin() >= 0 && pairTime.start.getMin() <= 60 && pairTime.end.getMin() >= 0 && pairTime.end.getMin() <= 60 && !TimeUtil.isInvalidRandom(i)) {
            return true;
        }
        SmpLog.m6494e(TAG, "invalid time");
        return false;
    }

    public static CustomContentResult requestCustomContent(Context context, CustomContentEntity customContentEntity) {
        CustomContentResult customContentResultCheckValidation = customContentEntity.checkValidation();
        if (customContentResultCheckValidation != null) {
            return customContentResultCheckValidation;
        }
        NetworkResult networkResultRequest = NetworkManager.request(context, new CustomContentRequest(customContentEntity), 10);
        if (!networkResultRequest.isSuccess()) {
            return handleNetworkError(networkResultRequest);
        }
        SmpLog.m6498i(TAG, "custom content request success");
        return getResponse(customContentEntity, networkResultRequest.getResponseMsg());
    }
}
