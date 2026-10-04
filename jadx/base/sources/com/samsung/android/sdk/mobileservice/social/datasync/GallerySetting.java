package com.samsung.android.sdk.mobileservice.social.datasync;

import android.os.Bundle;
import com.samsung.android.sdk.mobileservice.social.datasync.provider.DataSyncContract;
import com.samsung.android.sdk.mobileservice.util.SdkLog;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class GallerySetting implements IData {
    public static final String SYNC_SERVICE_NAME = "ds86adcvg5";
    private String mSortType;
    private final String JSON_KEY_SORT_TYPE = DataSyncContract.GallerySettingData.SORT_TYPE;
    private final String EXTRA_JSON_STRING = "json_string";

    public GallerySetting() {
    }

    private void fromJsonString(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.isNull(DataSyncContract.GallerySettingData.SORT_TYPE)) {
                return;
            }
            this.mSortType = jSONObject.getString(DataSyncContract.GallerySettingData.SORT_TYPE);
        } catch (JSONException e) {
            SdkLog.m5785s(e);
        }
    }

    private Boolean isNull(Object obj) {
        return Boolean.valueOf(obj == null);
    }

    private String toJsonString() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(DataSyncContract.GallerySettingData.SORT_TYPE, this.mSortType);
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

    public String getSortType() {
        return this.mSortType;
    }

    @Override // com.samsung.android.sdk.mobileservice.social.datasync.IData
    public String getSyncServiceName() {
        return SYNC_SERVICE_NAME;
    }

    @Override // com.samsung.android.sdk.mobileservice.social.datasync.IData
    public Boolean isInvalid() {
        return isNull(this.mSortType);
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

    public GallerySetting(String str) {
        this.mSortType = str;
    }

    public GallerySetting(Bundle bundle) {
        fromBundle(bundle);
    }
}
