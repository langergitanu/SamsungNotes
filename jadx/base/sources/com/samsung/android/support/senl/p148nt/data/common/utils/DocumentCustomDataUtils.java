package com.samsung.android.support.senl.p148nt.data.common.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.framework.constructor.AndroidInstanceConstructor;
import com.samsung.android.support.senl.p148nt.base.common.util.DynamicTemplateUuidUtil;
import com.samsung.android.support.senl.p148nt.data.common.constants.DocumentCustomDataConstants;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DocumentCustomDataUtils {
    private static final String TAG = DataLogger.createTag("DocumentCustomDataUtils");

    public static void updateDynamicTemplateData(@NonNull SpenWNote spenWNote, @NonNull String str) {
        JSONObject jSONObjectMakeJsonObject = AndroidInstanceConstructor.makeJsonObject(spenWNote.getAppCustomData());
        if (jSONObjectMakeJsonObject.has(DocumentCustomDataConstants.KEY_DYNAMIC_TEMPLATE)) {
            return;
        }
        DynamicTemplateUuidUtil.Info info = DynamicTemplateUuidUtil.INSTANCE.getInfo(str);
        JSONObject jSONObjectMakeJsonObject2 = AndroidInstanceConstructor.makeJsonObject("");
        jSONObjectMakeJsonObject2.put("version", info.getVersion());
        jSONObjectMakeJsonObject2.put("type", info.getType());
        jSONObjectMakeJsonObject2.put("index", info.getIndex());
        jSONObjectMakeJsonObject.put(DocumentCustomDataConstants.KEY_DYNAMIC_TEMPLATE, jSONObjectMakeJsonObject2);
        spenWNote.setAppCustomData(jSONObjectMakeJsonObject.toString());
        AbstractC11014a.m12334s("updateDynamicTemplateData, uuid: ", str, TAG);
    }

    public static String updateDynamicTemplateUuid(@NonNull String str, @Nullable String str2) {
        try {
            JSONObject jSONObjectMakeJsonObject = AndroidInstanceConstructor.makeJsonObject(str2);
            if (!jSONObjectMakeJsonObject.has(DocumentCustomDataConstants.KEY_DYNAMIC_TEMPLATE)) {
                return str;
            }
            JSONObject jSONObject = jSONObjectMakeJsonObject.getJSONObject(DocumentCustomDataConstants.KEY_DYNAMIC_TEMPLATE);
            String str3 = str + DynamicTemplateUuidUtil.INSTANCE.getPostFixForUuid(jSONObject.getInt("version"), jSONObject.getString("type"), jSONObject.getString("index"));
            DataLogger.m12302d(TAG, "updateDynamicTemplateUuid, from: " + str + " / to: " + str3);
            return str3;
        } catch (JSONException e) {
            DataLogger.m12303e(TAG, "updateDynamicTemplateUuid, e: " + e.getMessage());
            return str;
        }
    }
}
