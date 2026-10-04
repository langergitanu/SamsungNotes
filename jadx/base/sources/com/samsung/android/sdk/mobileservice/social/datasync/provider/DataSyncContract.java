package com.samsung.android.sdk.mobileservice.social.datasync.provider;

import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class DataSyncContract {
    public static final String AUTHORITY = "com.samsung.android.mobileservice.datasync";
    private static final Uri AUTHORITY_URI = Uri.parse("content://com.samsung.android.mobileservice.datasync");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Data {
        public static final Uri CONTENT_URI = Uri.withAppendedPath(DataSyncContract.AUTHORITY_URI, "data");
        public static final String TIMESTAMP = "timestamp";

        private Data() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class GallerySettingData extends Data {
        public static final String SORT_TYPE = "sort_type";

        private GallerySettingData() {
            super();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ProfileCardData extends Data {
        public static final String BACKGROUND_FILE_URI = "bg_file_uri";
        public static final String BACKGROUND_TYPE = "bg_type";
        public static final String BG_SOURCE = "bg_source";
        public static final String CUSTOM_BACKGROUND_HASH = "custom_bg_profile";
        public static final String CUSTOM_TIMESTAMP = "custom_timestamp";
        public static final String FILE_EXTENSION = "file_extension";
        public static final String FONT_FACE = "font_face";
        public static final String FONT_WEIGHT = "font_weight";
        public static final String GRADIENT_ANGLE = "gradient_angle";
        public static final String NAME_ALIGN = "name_align";
        public static final String NAME_COLOR = "name_color";
        public static final String SQUARE_CROP_RECT = "square_crop_rect";

        private ProfileCardData() {
            super();
        }
    }

    private DataSyncContract() {
    }
}
