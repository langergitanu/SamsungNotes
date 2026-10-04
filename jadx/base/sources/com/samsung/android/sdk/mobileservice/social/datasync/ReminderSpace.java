package com.samsung.android.sdk.mobileservice.social.datasync;

import android.os.Bundle;
import com.samsung.android.sdk.mobileservice.util.SdkLog;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class ReminderSpace implements IData {
    public static final String SYNC_SERVICE_NAME = "8xyy6yh5v6";
    private final String EXTRA_JSON_STRING;
    private final String JSON_KEY_COLOR;
    private final String JSON_KEY_GROUP_ID;
    private final String JSON_KEY_ICON;
    private final String JSON_KEY_RECORD_ID;
    private final String JSON_KEY_SPACE_ID;
    private Integer mColor;
    private String mGroupId;
    private Integer mIcon;
    private String mSpaceId;

    public ReminderSpace() {
        this.JSON_KEY_GROUP_ID = "group_id";
        this.JSON_KEY_SPACE_ID = "space_id";
        this.JSON_KEY_RECORD_ID = "record_id";
        this.JSON_KEY_COLOR = "color";
        this.JSON_KEY_ICON = "icon";
        this.EXTRA_JSON_STRING = "json_string";
    }

    private void fromJsonString(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.isNull("group_id")) {
                this.mGroupId = jSONObject.getString("group_id");
            }
            if (!jSONObject.isNull("space_id")) {
                this.mSpaceId = jSONObject.getString("space_id");
            }
            if (!jSONObject.isNull("color")) {
                this.mColor = Integer.valueOf(jSONObject.getInt("color"));
            }
            if (jSONObject.isNull("icon")) {
                return;
            }
            this.mIcon = Integer.valueOf(jSONObject.getInt("icon"));
        } catch (JSONException e) {
            SdkLog.m5785s(e);
        }
    }

    private String getRecordId() {
        return this.mGroupId + "_" + this.mSpaceId;
    }

    private Boolean isNull(Object obj) {
        return Boolean.valueOf(obj == null);
    }

    private String toJsonString() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("group_id", this.mGroupId);
            jSONObject.put("space_id", this.mSpaceId);
            jSONObject.put("record_id", getRecordId());
            jSONObject.put("color", this.mColor);
            jSONObject.put("icon", this.mIcon);
            return jSONObject.toString();
        } catch (JSONException e) {
            SdkLog.m5785s(e);
            return null;
        }
    }

    @Override // com.samsung.android.sdk.mobileservice.social.datasync.IData
    public void fromBundle(Bundle bundle) {
        fromJsonString(bundle.getString("json_string"));
    }

    public Integer getColor() {
        return this.mColor;
    }

    public Integer getIcon() {
        return this.mIcon;
    }

    @Override // com.samsung.android.sdk.mobileservice.social.datasync.IData
    public String getSyncServiceName() {
        return SYNC_SERVICE_NAME;
    }

    @Override // com.samsung.android.sdk.mobileservice.social.datasync.IData
    public Boolean isInvalid() {
        return Boolean.valueOf(isNull(this.mGroupId).booleanValue() || isNull(this.mSpaceId).booleanValue() || isNull(this.mColor).booleanValue() || isNull(this.mIcon).booleanValue());
    }

    @Override // com.samsung.android.sdk.mobileservice.social.datasync.IData
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        String jsonString = toJsonString();
        if (jsonString != null) {
            bundle.putString("json_string", jsonString);
        }
        return bundle;
    }

    public ReminderSpace(String str, String str2) {
        this.JSON_KEY_GROUP_ID = "group_id";
        this.JSON_KEY_SPACE_ID = "space_id";
        this.JSON_KEY_RECORD_ID = "record_id";
        this.JSON_KEY_COLOR = "color";
        this.JSON_KEY_ICON = "icon";
        this.EXTRA_JSON_STRING = "json_string";
        this.mGroupId = str;
        this.mSpaceId = str2;
    }

    public ReminderSpace(String str, String str2, Integer num, Integer num2) {
        this(str, str2);
        this.mColor = num;
        this.mIcon = num2;
    }

    public ReminderSpace(Bundle bundle) {
        this.JSON_KEY_GROUP_ID = "group_id";
        this.JSON_KEY_SPACE_ID = "space_id";
        this.JSON_KEY_RECORD_ID = "record_id";
        this.JSON_KEY_COLOR = "color";
        this.JSON_KEY_ICON = "icon";
        this.EXTRA_JSON_STRING = "json_string";
        fromBundle(bundle);
    }
}
