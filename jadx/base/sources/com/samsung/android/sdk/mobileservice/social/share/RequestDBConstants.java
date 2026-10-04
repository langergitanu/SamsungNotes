package com.samsung.android.sdk.mobileservice.social.share;

import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class RequestDBConstants {
    private static final String AUTHORITY = "com.samsung.android.mobileservice.social.share";
    private static final String CONTENT_AUTHORITY_DOT = "content://com.samsung.android.mobileservice.social.share.";
    public static final String CONTENT_URI = "content_uri";
    public static final String CREATOR = "creator";
    public static final String FILE_NAME = "file_name";
    public static final String FILE_REPLACE_REQUIRED = "file_replace_required";
    public static final String FILE_URI = "file_uri";
    public static final String HASH = "hash";
    public static final String INSTANT_META_DATA = "instant_meta_data";
    public static final String ITEM_IDX = "item_idx";
    public static final String MEDIA_SERVICE_CONTENT_ID = "media_service_content_id";
    public static final String MEMO = "memo";
    public static final String META_DATA = "meta_data";
    public static final String MIME_TYPE = "mime_type";
    private static final String PATTERN_APP_ID = "/app_id";
    private static final String PATTERN_FEATURE_ID = "/feature_id";
    private static final String PATTERN_ITEM = "/item";
    public static final String REFERRED_RESOURCE_ID = "referred_resource_id";
    public static final String REQUEST_ID = "request_id";
    public static final String SIZE = "size";
    public static final String SPACE_ID = "spaceId";
    private static final String TABLE_NAME = "bulk_item";
    public static final String TITLE = "title";
    private static final String URI = "content://com.samsung.android.mobileservice.social.share.bulk_item";

    public static Uri getBulkItemUri(String str, int i) {
        return Uri.parse("content://com.samsung.android.mobileservice.social.share.bulk_item/app_id/" + str + "/feature_id/" + i);
    }

    public static Uri getItemUri(String str, int i) {
        return Uri.parse("content://com.samsung.android.mobileservice.social.share.item/app_id/" + str + "/feature_id/" + i + PATTERN_ITEM);
    }
}
