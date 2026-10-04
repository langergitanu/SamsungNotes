package com.samsung.android.sdk.mobileservice.social.datasync;

import android.os.Bundle;
import com.samsung.android.sdk.mobileservice.util.SdkLog;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class GallerySpace implements IData {
    public static final String SYNC_SERVICE_NAME = "G5CJkhyQnz";
    private final String EXTRA_JSON_STRING;
    private final String JSON_KEY_GROUP_ID;
    private final String JSON_KEY_RECORD_ID;
    private final String JSON_KEY_SORT_VALUE;
    private final String JSON_KEY_SPACE_ID;
    private String mGroupId;
    private String mSortValue;
    private String mSpaceId;

    public GallerySpace() {
        this.JSON_KEY_GROUP_ID = "group_id";
        this.JSON_KEY_SPACE_ID = "space_id";
        this.JSON_KEY_RECORD_ID = "record_id";
        this.JSON_KEY_SORT_VALUE = "sort_value";
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
            if (jSONObject.isNull("sort_value")) {
                return;
            }
            this.mSortValue = jSONObject.getString("sort_value");
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
            jSONObject.put("sort_value", this.mSortValue);
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

    public String getSortValue() {
        return this.mSortValue;
    }

    @Override // com.samsung.android.sdk.mobileservice.social.datasync.IData
    public String getSyncServiceName() {
        return SYNC_SERVICE_NAME;
    }

    @Override // com.samsung.android.sdk.mobileservice.social.datasync.IData
    public Boolean isInvalid() {
        return Boolean.valueOf(isNull(this.mGroupId).booleanValue() || isNull(this.mSpaceId).booleanValue() || isNull(this.mSortValue).booleanValue());
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

    public GallerySpace(String str, String str2) {
        this.JSON_KEY_GROUP_ID = "group_id";
        this.JSON_KEY_SPACE_ID = "space_id";
        this.JSON_KEY_RECORD_ID = "record_id";
        this.JSON_KEY_SORT_VALUE = "sort_value";
        this.EXTRA_JSON_STRING = "json_string";
        this.mGroupId = str;
        this.mSpaceId = str2;
    }

    public GallerySpace(String str, String str2, String str3) {
        this(str, str2);
        this.mSortValue = str3;
    }

    public GallerySpace(Bundle bundle) {
        this.JSON_KEY_GROUP_ID = "group_id";
        this.JSON_KEY_SPACE_ID = "space_id";
        this.JSON_KEY_RECORD_ID = "record_id";
        this.JSON_KEY_SORT_VALUE = "sort_value";
        this.EXTRA_JSON_STRING = "json_string";
        fromBundle(bundle);
    }
}
