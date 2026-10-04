package com.samsung.android.sdk.mobileservice.social.datasync;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.samsung.android.sdk.mobileservice.social.datasync.provider.DataSyncContract;
import com.samsung.android.sdk.mobileservice.util.SdkLog;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class ProfileCard implements IData {
    public static final String SYNC_SERVICE_NAME = "rMnFaz1GB6";
    private final String EXTRA_JSON_STRING;
    private final String JSON_KEY_BG_FILE_URI;
    private final String JSON_KEY_CUSTOM_BG_HASH;
    private final String JSON_KEY_CUSTOM_TIMESTAMP;
    private Uri mBgFileUri;
    private String mCustomBgHash;
    private long mCustomTimestamp;
    private MetaData mMeta;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class MetaData {
        private static final String JSON_KEY_BG_SOURCE = "bg_source";
        private static final String JSON_KEY_BG_TYPE = "bg_type";
        private static final String JSON_KEY_FILE_EXTENSION = "file_extension";
        private static final String JSON_KEY_FONT_FACE = "font_face";
        private static final String JSON_KEY_FONT_WEIGHT = "font_weight";
        private static final String JSON_KEY_GRADIENT_ANGLE = "gradient_angle";
        private static final String JSON_KEY_NAME_ALIGN = "name_align";
        private static final String JSON_KEY_NAME_COLOR = "name_color";
        private static final String JSON_KEY_SQUARE_CROP = "square_crop_rect";
        private String mBgSource;
        private String mBgType;
        private String mFileExtension;
        private String mFontFace;
        private int mFontWeight;
        private float mGradientAngle;
        private int mNameAlign;
        private String mNameColor;
        private String mSquareCrop;

        public MetaData() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Boolean isInvalid() {
            return Boolean.valueOf(TextUtils.isEmpty(this.mBgType));
        }

        public String getBgSource() {
            return this.mBgSource;
        }

        public String getBgType() {
            return this.mBgType;
        }

        public String getFileExtension() {
            return this.mFileExtension;
        }

        public String getFontFace() {
            return this.mFontFace;
        }

        public int getFontWeight() {
            return this.mFontWeight;
        }

        public float getGradientAngle() {
            return this.mGradientAngle;
        }

        public int getNameAlign() {
            return this.mNameAlign;
        }

        public String getNameColor() {
            return this.mNameColor;
        }

        public String getSquareCrop() {
            return this.mSquareCrop;
        }

        public MetaData(String str, String str2, int i, int i2, String str3, float f, String str4, String str5, String str6) {
            this.mBgType = str;
            this.mFontFace = str2;
            this.mFontWeight = i;
            this.mNameAlign = i2;
            this.mNameColor = str3;
            this.mGradientAngle = f;
            this.mSquareCrop = str4;
            this.mFileExtension = str5;
            this.mBgSource = str6;
        }

        public MetaData(JSONObject jSONObject) {
            try {
                this.mBgType = jSONObject.has("bg_type") ? jSONObject.getString("bg_type") : "";
                this.mFontFace = jSONObject.has("font_face") ? jSONObject.getString("font_face") : "";
                this.mFontWeight = jSONObject.has("font_weight") ? jSONObject.getInt("font_weight") : 0;
                this.mNameAlign = jSONObject.has("name_align") ? jSONObject.getInt("name_align") : 0;
                this.mNameColor = jSONObject.has("name_color") ? jSONObject.getString("name_color") : "";
                this.mGradientAngle = jSONObject.has("gradient_angle") ? (float) jSONObject.getDouble("gradient_angle") : 0.0f;
                this.mSquareCrop = jSONObject.has("square_crop_rect") ? jSONObject.getString("square_crop_rect") : "";
                this.mFileExtension = jSONObject.has("file_extension") ? jSONObject.getString("file_extension") : "";
                this.mBgSource = jSONObject.has("bg_source") ? jSONObject.getString("bg_source") : "";
            } catch (JSONException e) {
                SdkLog.m5785s(e);
            }
        }
    }

    public ProfileCard() {
        this.JSON_KEY_BG_FILE_URI = DataSyncContract.ProfileCardData.BACKGROUND_FILE_URI;
        this.JSON_KEY_CUSTOM_BG_HASH = DataSyncContract.ProfileCardData.CUSTOM_BACKGROUND_HASH;
        this.JSON_KEY_CUSTOM_TIMESTAMP = DataSyncContract.ProfileCardData.CUSTOM_TIMESTAMP;
        this.EXTRA_JSON_STRING = "json_string";
        this.mCustomTimestamp = 0L;
    }

    private void fromJsonString(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.mBgFileUri = Uri.parse(jSONObject.has(DataSyncContract.ProfileCardData.BACKGROUND_FILE_URI) ? jSONObject.getString(DataSyncContract.ProfileCardData.BACKGROUND_FILE_URI) : "");
            this.mCustomBgHash = jSONObject.has(DataSyncContract.ProfileCardData.CUSTOM_BACKGROUND_HASH) ? jSONObject.getString(DataSyncContract.ProfileCardData.CUSTOM_BACKGROUND_HASH) : "";
            this.mCustomTimestamp = jSONObject.has(DataSyncContract.ProfileCardData.CUSTOM_BACKGROUND_HASH) ? jSONObject.getLong(DataSyncContract.ProfileCardData.CUSTOM_TIMESTAMP) : 0L;
            this.mMeta = new MetaData(jSONObject);
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
            Uri uri = this.mBgFileUri;
            if (uri != null) {
                jSONObject.put(DataSyncContract.ProfileCardData.BACKGROUND_FILE_URI, uri.toString());
            }
            String str = this.mCustomBgHash;
            if (str != null) {
                jSONObject.put(DataSyncContract.ProfileCardData.CUSTOM_BACKGROUND_HASH, str);
            }
            long j = this.mCustomTimestamp;
            if (j != 0) {
                jSONObject.put(DataSyncContract.ProfileCardData.CUSTOM_TIMESTAMP, j);
            }
            MetaData metaData = this.mMeta;
            if (metaData != null) {
                jSONObject.put(DataSyncContract.ProfileCardData.BACKGROUND_TYPE, metaData.getBgType());
                jSONObject.put(DataSyncContract.ProfileCardData.FONT_FACE, this.mMeta.getFontFace());
                jSONObject.put("font_weight", this.mMeta.getFontWeight());
                jSONObject.put(DataSyncContract.ProfileCardData.NAME_ALIGN, this.mMeta.getNameAlign());
                jSONObject.put(DataSyncContract.ProfileCardData.NAME_COLOR, this.mMeta.getNameColor());
                jSONObject.put(DataSyncContract.ProfileCardData.GRADIENT_ANGLE, this.mMeta.getGradientAngle());
                jSONObject.put(DataSyncContract.ProfileCardData.SQUARE_CROP_RECT, this.mMeta.getSquareCrop());
                jSONObject.put(DataSyncContract.ProfileCardData.FILE_EXTENSION, this.mMeta.getFileExtension());
                jSONObject.put(DataSyncContract.ProfileCardData.BG_SOURCE, this.mMeta.getBgSource());
            }
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

    public Uri getBgFileUri() {
        return this.mBgFileUri;
    }

    public String getCustomBgHash() {
        return this.mCustomBgHash;
    }

    public long getCustomTimestamp() {
        return this.mCustomTimestamp;
    }

    public MetaData getMeta() {
        return this.mMeta;
    }

    @Override // com.samsung.android.sdk.mobileservice.social.datasync.IData
    public String getSyncServiceName() {
        return SYNC_SERVICE_NAME;
    }

    @Override // com.samsung.android.sdk.mobileservice.social.datasync.IData
    public Boolean isInvalid() {
        return Boolean.valueOf(isNull(this.mBgFileUri).booleanValue() || isNull(this.mCustomBgHash).booleanValue() || isNull(this.mMeta).booleanValue() || this.mMeta.isInvalid().booleanValue() || this.mCustomTimestamp == 0);
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

    public ProfileCard(Uri uri, String str, long j, MetaData metaData) {
        this.JSON_KEY_BG_FILE_URI = DataSyncContract.ProfileCardData.BACKGROUND_FILE_URI;
        this.JSON_KEY_CUSTOM_BG_HASH = DataSyncContract.ProfileCardData.CUSTOM_BACKGROUND_HASH;
        this.JSON_KEY_CUSTOM_TIMESTAMP = DataSyncContract.ProfileCardData.CUSTOM_TIMESTAMP;
        this.EXTRA_JSON_STRING = "json_string";
        this.mBgFileUri = uri;
        this.mCustomBgHash = str;
        this.mCustomTimestamp = j;
        this.mMeta = metaData;
    }

    public ProfileCard(Bundle bundle) {
        this.JSON_KEY_BG_FILE_URI = DataSyncContract.ProfileCardData.BACKGROUND_FILE_URI;
        this.JSON_KEY_CUSTOM_BG_HASH = DataSyncContract.ProfileCardData.CUSTOM_BACKGROUND_HASH;
        this.JSON_KEY_CUSTOM_TIMESTAMP = DataSyncContract.ProfileCardData.CUSTOM_TIMESTAMP;
        this.EXTRA_JSON_STRING = "json_string";
        this.mCustomTimestamp = 0L;
        fromBundle(bundle);
    }
}
