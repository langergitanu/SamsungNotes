package com.samsung.android.sdk.mobileservice.social.share;

import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.runtime.AbstractC1974b;
import androidx.glance.AbstractC2821a;
import com.samsung.android.sdk.mobileservice.social.share.ShareApi;
import com.samsung.android.sdk.mobileservice.social.share.result.ContentDownloadResult;
import com.samsung.android.sdk.mobileservice.util.SdkLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class ShareApiUtil {
    private static ShareApiUtil sInstance;
    private final String APP_ID_GALLERY = "22n6hzkam0";
    private final String APP_ID_REMINDER = "8o8b82h22a";
    private final String SPLIT_TOKEN = "_*sems&_";
    private String mApiName;
    private String mAppId;
    private String mReference;

    private ShareApiUtil(String str, String str2, String str3) {
        this.mApiName = str;
        this.mReference = str2;
        this.mAppId = str3;
    }

    private void createSharedItemResult(SharedItem sharedItem, Bundle bundle) {
        sharedItem.setLastModifier(bundle.getString(BundleKey.LAST_MODIFIER_ID));
        sharedItem.setTitle(bundle.getString("title", ""));
        sharedItem.setMemo(bundle.getString("memo", ""));
        sharedItem.setCreatedTime(bundle.getLong(BundleKey.CREATED_TIME, 0L));
        sharedItem.setModifiedTime(bundle.getLong("modified_time", 0L));
        sharedItem.setMimeType(bundle.getString("mime_type", ""));
        String string = bundle.getString(BundleKey.THUMBNAIL_URI, "");
        if (string != null) {
            sharedItem.setThumbnailFileUri(Uri.parse(string));
        }
        String string2 = bundle.getString("thumbnail_content_uri", null);
        if (string2 != null) {
            sharedItem.setThumbnailContentUri(Uri.parse(string2));
        }
        sharedItem.setOwnedByMe(bundle.getBoolean("is_owned_by_me", false));
        sharedItem.setMetaData((HashMap) bundle.getSerializable("meta_data"));
        sharedItem.setSize(bundle.getLong(BundleKey.FILE_SIZE, 0L));
        sharedItem.setOriginalContentPath(bundle.getString("original_content_path", ""));
        String string3 = bundle.getString(BundleKey.ORIGINAL_CONTENT_URI, null);
        if (string3 != null) {
            sharedItem.setOriginalContentUri(Uri.parse(string3));
        }
        sharedItem.setStreamingUrl(bundle.getString("streaming_url", ""));
        sharedItem.setSourceCid(bundle.getString("source_cid", ""));
        sharedItem.setResourceId(bundle.getString("referred_resource_id", null));
        sharedItem.setCreator(bundle.getString("creator", null));
        showLog("- itemId=[" + sharedItem.getItemId() + "], spaceId=[" + sharedItem.getSpaceId() + "], ownerId=[" + sharedItem.getLeaderId() + "], title=[" + sharedItem.getTitle() + "], memo=[" + sharedItem.getMemo() + "], createdTime=[" + sharedItem.getCreatedTime() + "], modifiedTime=[" + sharedItem.getModifiedTime() + "], mimeType=[" + sharedItem.getMimeType() + "], thumbnailUri=[" + string + "], lastModifier=[" + sharedItem.getLastModifier() + "]");
    }

    private Space createSpace(Bundle bundle) {
        String string = bundle.getString("space_id", null);
        String string2 = bundle.getString("group_id", null);
        String string3 = bundle.getString(BundleKey.OWNER_ID, null);
        return TextUtils.equals(this.mAppId, "22n6hzkam0") ? new GallerySpace(string2, string, string3, bundle) : TextUtils.equals(this.mAppId, "8o8b82h22a") ? new ReminderSpace(string2, string, string3, bundle) : new Space(string2, string, string3);
    }

    private WebLink createWebLinkResult(Bundle bundle) {
        String string = bundle.getString("weblink_url", "");
        String string2 = bundle.getString("weblink_creator", "");
        long j = bundle.getLong("weblink_created_time");
        long j2 = bundle.getLong("weblink_expired_time");
        if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2) || j == 0 || j2 == 0) {
            return null;
        }
        return new WebLink(string, string2, j, j2);
    }

    public static ShareApiUtil getInstance(String str, String str2, String str3) {
        if (sInstance == null) {
            synchronized (ShareApiUtil.class) {
                try {
                    if (sInstance == null) {
                        sInstance = new ShareApiUtil(str, str2, str3);
                    }
                } finally {
                }
            }
        }
        return sInstance;
    }

    private String getMetaString(Map map) {
        StringBuilder sb = new StringBuilder();
        if (map != null) {
            Iterator it = map.keySet().iterator();
            while (it.hasNext()) {
                String string = it.next().toString();
                if (sb.length() > 0) {
                    sb.append("_*sems&_");
                }
                sb.append(string);
                sb.append("_*sems&_");
                sb.append(map.get(string));
            }
        }
        return sb.toString();
    }

    private void showLog(String str) {
        String str2 = this.mApiName;
        StringBuilder sbM781w = AbstractC0541b.m781w(str, " ");
        sbM781w.append(this.mReference);
        SdkLog.m5782d(str2, sbM781w.toString());
    }

    public ContentDownloadResult.DownloadedContent bundleToDownloadContent(Bundle bundle) {
        String string = bundle.getString("space_id", null);
        String string2 = bundle.getString("item_id", null);
        String string3 = bundle.getString(BundleKey.CONTENT_HASH, null);
        String string4 = bundle.getString(BundleKey.DOWNLOADED_URI, null);
        String string5 = bundle.getString(BundleKey.DOWNLOADED_CONTENT_URI, null);
        String string6 = bundle.getString("mime_type", null);
        long j = bundle.getLong(BundleKey.FILE_SIZE, -1L);
        Uri uri = string4 != null ? Uri.parse(string4) : null;
        Uri uri2 = string5 != null ? Uri.parse(string5) : null;
        showLog(AbstractC0541b.m776r(AbstractC0000a.m16m("- successList : space_id=[", string, "], item_id=[", string2, "], downloaded_uri=["), string4, "], mime_type=[", string6, "]"));
        return new ContentDownloadResult.DownloadedContent(string, string2, string3, uri, uri2, string6, j);
    }

    public SharedContentDownloadSnapshot bundleToDownloadSnapShot(Bundle bundle) {
        long j = bundle.getLong(BundleKey.totalBytes, 0L);
        long j2 = bundle.getLong(BundleKey.totalBytesTransferred, 0L);
        int i = bundle.getInt(BundleKey.totalFileCount, 0);
        int i2 = bundle.getInt(BundleKey.totalFileCountTransferred, 0);
        long j3 = bundle.getLong(BundleKey.currentFileBytes, 0L);
        long j5 = bundle.getLong(BundleKey.currentFileBytesTransferred, 0L);
        int i4 = bundle.getInt(BundleKey.currentFileIndex, 0);
        StringBuilder sbM1323p = AbstractC1974b.m1323p(j, "- totalBytes=[", "], totalBytesTransferred=[");
        sbM1323p.append(j2);
        sbM1323p.append("], totalFileCount=[");
        sbM1323p.append(i);
        AbstractC1974b.m1330w(i2, "], totalFileCountTransferred=[", "], currentFileBytes=[", sbM1323p);
        sbM1323p.append(j3);
        AbstractC1038a.m1223x(sbM1323p, "], currentFileBytesTransferred=[", j5, "], currentFileIndex=[");
        showLog(AbstractC2821a.m2223n(sbM1323p, "] ", i4));
        return new SharedContentDownloadSnapshot(j, j2, i, i2, j3, j5, i4);
    }

    public ShareSnapshot bundleToShareSnapShot(Bundle bundle) {
        long j = bundle.getLong(BundleKey.totalBytes, 0L);
        long j2 = bundle.getLong(BundleKey.totalBytesTransferred, 0L);
        int i = bundle.getInt(BundleKey.totalFileCount, 0);
        int i2 = bundle.getInt(BundleKey.totalFileCountTransferred, 0);
        long j3 = bundle.getLong(BundleKey.currentFileBytes, 0L);
        long j5 = bundle.getLong(BundleKey.currentFileBytesTransferred, 0L);
        int i4 = bundle.getInt(BundleKey.currentFileIndex, 0);
        StringBuilder sbM1323p = AbstractC1974b.m1323p(j, "- totalBytes=[", "], totalBytesTransferred=[");
        sbM1323p.append(j2);
        sbM1323p.append("], totalFileCount=[");
        sbM1323p.append(i);
        AbstractC1974b.m1330w(i2, "], totalFileCountTransferred=[", "], currentFileBytes=[", sbM1323p);
        sbM1323p.append(j3);
        AbstractC1038a.m1223x(sbM1323p, "], currentFileBytesTransferred=[", j5, "], currentFileIndex=[");
        showLog(AbstractC2821a.m2223n(sbM1323p, "] ", i4));
        return new ShareSnapshot(j, j2, i, i2, j3, j5, i4);
    }

    public ShareApi.SharedItemRequest createShareFailedItemResult(Bundle bundle) {
        String string = bundle.getString("title", "");
        int i = bundle.getInt("request_type", -1);
        ShareApi.SharedItemRequest sharedItemRequest = null;
        if (i == 0) {
            ShareApi.SharedItemWithUriRequest sharedItemWithUriRequest = new ShareApi.SharedItemWithUriRequest(string);
            sharedItemWithUriRequest.setUri(Uri.parse(bundle.getString("content_uri", null)));
            sharedItemRequest = sharedItemWithUriRequest;
        } else if (i == 1) {
            ShareApi.SharedItemWithSCloudHashRequest sharedItemWithSCloudHashRequest = new ShareApi.SharedItemWithSCloudHashRequest(string);
            sharedItemWithSCloudHashRequest.setHash(bundle.getString(BundleKey.CONTENT_HASH, ""));
            sharedItemWithSCloudHashRequest.setContentSize(bundle.getLong(BundleKey.FILE_SIZE, -1L));
            sharedItemWithSCloudHashRequest.setContentName(bundle.getString("file_name", ""));
            sharedItemRequest = sharedItemWithSCloudHashRequest;
        } else if (i == 2) {
            ShareApi.SharedItemWithMediaServiceContentIdRequest sharedItemWithMediaServiceContentIdRequest = new ShareApi.SharedItemWithMediaServiceContentIdRequest(string);
            sharedItemWithMediaServiceContentIdRequest.setMediaServiceContentId(bundle.getString("media_service_content_id", ""));
            sharedItemWithMediaServiceContentIdRequest.setContentSize(bundle.getLong(BundleKey.FILE_SIZE, -1L));
            sharedItemWithMediaServiceContentIdRequest.setContentName(bundle.getString("file_name", ""));
            sharedItemRequest = sharedItemWithMediaServiceContentIdRequest;
        }
        if (sharedItemRequest != null) {
            sharedItemRequest.setMemo(bundle.getString("memo", ""));
            sharedItemRequest.setContentMimeType(bundle.getString("mime_type", ""));
            sharedItemRequest.setMetaData((HashMap) bundle.getSerializable("meta_data"));
            sharedItemRequest.setInstantMetaData((HashMap) bundle.getSerializable("instant_meta_data"));
            showLog(" request tyep=[" + i + "], title=[" + sharedItemRequest.getTitle() + "], memo=[" + sharedItemRequest.getMemo() + "], mimeType=[" + sharedItemRequest.getContentMimeType() + "]");
        }
        return sharedItemRequest;
    }

    public ShareApi.SharedItemWithUriListRequest createShareFailedItemWithUriListResult(Bundle bundle) {
        ShareApi.SharedItemWithUriListRequest sharedItemWithUriListRequest = new ShareApi.SharedItemWithUriListRequest(bundle.getString("title", ""));
        String string = bundle.getString("memo", "");
        Map map = (Map) bundle.getSerializable("meta_data");
        Map map2 = (Map) bundle.getSerializable("instant_meta_data");
        sharedItemWithUriListRequest.setMemo(string);
        sharedItemWithUriListRequest.setMetaData(map);
        sharedItemWithUriListRequest.setInstantMetaData(map2);
        ArrayList<Bundle> parcelableArrayList = bundle.getParcelableArrayList(BundleKey.SHARE_FILE_LIST);
        if (parcelableArrayList != null) {
            for (Bundle bundle2 : parcelableArrayList) {
                String string2 = bundle2.getString("content_uri", "");
                sharedItemWithUriListRequest.addUri(Uri.parse(string2), bundle2.getString("mime_type", ""));
            }
        }
        sharedItemWithUriListRequest.setCreator(bundle.getString("creator", ""));
        sharedItemWithUriListRequest.setResourceId(bundle.getString("referred_resource_id", ""));
        return sharedItemWithUriListRequest;
    }

    public Space createSpaceResult(Bundle bundle) {
        Space spaceCreateSpace = createSpace(bundle);
        spaceCreateSpace.setTitle(bundle.getString("title", ""));
        spaceCreateSpace.setMemo(bundle.getString("memo", ""));
        spaceCreateSpace.setCreatedTime(bundle.getLong(BundleKey.CREATED_TIME, 0L));
        spaceCreateSpace.setModifiedTime(bundle.getLong("modified_time", 0L));
        String string = bundle.getString(BundleKey.THUMBNAIL_URI, null);
        spaceCreateSpace.setWebLink(createWebLinkResult(bundle));
        if (string != null) {
            spaceCreateSpace.setCoverThumbnailFileUri(Uri.parse(string));
        }
        spaceCreateSpace.setSourceCid(bundle.getString("source_cid", null));
        spaceCreateSpace.setUnreadCount(bundle.getInt("unread_count", 0));
        spaceCreateSpace.setUnreadCount(bundle.getInt("item_count", 0));
        spaceCreateSpace.setOwnedByMe(bundle.getBoolean("is_owned_by_me", false));
        spaceCreateSpace.setMetaData((HashMap) bundle.getSerializable("meta_data"));
        spaceCreateSpace.setSize(bundle.getLong(BundleKey.FILE_SIZE, 0L));
        spaceCreateSpace.setContentUpdatedTime(bundle.getLong("contents_update_time", 0L));
        long j = bundle.getLong("my_usage", 0L);
        spaceCreateSpace.setMyUsage(j);
        long j2 = bundle.getLong("my_count_usage", 0L);
        spaceCreateSpace.setMyCountUsage(j2);
        spaceCreateSpace.setStandAlone(bundle.getBoolean(BundleKey.IS_STANDALONE, false));
        StringBuilder sb = new StringBuilder("- spaceId=[");
        sb.append(spaceCreateSpace.getSpaceId());
        sb.append("], groupId=[");
        sb.append(spaceCreateSpace.getGroupId());
        sb.append("], ownerId=[");
        sb.append(spaceCreateSpace.getLeaderId());
        sb.append("], title=[");
        sb.append(spaceCreateSpace.getTitle());
        sb.append("], memo=[");
        sb.append(spaceCreateSpace.getMemo());
        sb.append("], coverImageUri=[");
        sb.append(string);
        AbstractC1038a.m1223x(sb, "], myUsage=[", j, " ], myCountUsage=[");
        showLog(AbstractC2821a.m2224o(sb, " ]", j2));
        return spaceCreateSpace;
    }

    public TrashedItem createTrashedItemResult(Bundle bundle) {
        TrashedItem trashedItem = new TrashedItem(bundle.getString("item_id"), bundle.getString("space_id"), bundle.getString(BundleKey.OWNER_ID));
        createSharedItemResult(trashedItem, bundle);
        trashedItem.setExpiryAt(bundle.getLong(BundleKey.EXPIRY_AT, 0L));
        return trashedItem;
    }

    public Bundle requestToBundle(ShareApi.SpaceRequest spaceRequest, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("title", spaceRequest.getTitle());
        bundle.putString("memo", spaceRequest.getMemo());
        bundle.putBoolean(BundleKey.IS_STANDALONE, spaceRequest.isStandAlone());
        StringBuilder sbM15l = AbstractC0000a.m15l("requestSpaceCreation : groupId=[", str, "] , title=[");
        sbM15l.append(spaceRequest.getTitle());
        sbM15l.append("], memo=[");
        sbM15l.append(spaceRequest.getMemo());
        sbM15l.append("]");
        showLog(sbM15l.toString());
        bundle.putString("mime_type", spaceRequest.getMimeType());
        if (spaceRequest instanceof ShareApi.SpaceWithUriRequest) {
            ShareApi.SpaceWithUriRequest spaceWithUriRequest = (ShareApi.SpaceWithUriRequest) spaceRequest;
            if (spaceWithUriRequest.getCoverImageUri() != null) {
                bundle.putString("content_uri", spaceWithUriRequest.getCoverImageUri().toString());
                showLog("requestSpaceCreation : coverImageUriString=[" + spaceWithUriRequest.getCoverImageUri().toString() + "]");
            }
        } else if (spaceRequest instanceof ShareApi.SpaceWithSCloudHashRequest) {
            ShareApi.SpaceWithSCloudHashRequest spaceWithSCloudHashRequest = (ShareApi.SpaceWithSCloudHashRequest) spaceRequest;
            if (spaceWithSCloudHashRequest.getHash() != null) {
                bundle.putString(BundleKey.CONTENT_HASH, spaceWithSCloudHashRequest.getHash());
                bundle.putLong(BundleKey.FILE_SIZE, spaceWithSCloudHashRequest.getCoverImageSize());
                bundle.putString("file_name", spaceWithSCloudHashRequest.getCoverImageName());
            }
        } else if (spaceRequest instanceof ShareApi.SpaceWithMediaServiceContentIdRequest) {
            ShareApi.SpaceWithMediaServiceContentIdRequest spaceWithMediaServiceContentIdRequest = (ShareApi.SpaceWithMediaServiceContentIdRequest) spaceRequest;
            if (spaceWithMediaServiceContentIdRequest.getMediaServiceContentId() != null) {
                bundle.putString("media_service_content_id", spaceWithMediaServiceContentIdRequest.getMediaServiceContentId());
                bundle.putLong(BundleKey.FILE_SIZE, spaceWithMediaServiceContentIdRequest.getCoverImageSize());
                bundle.putString("file_name", spaceWithMediaServiceContentIdRequest.getCoverImageName());
            }
        }
        bundle.putSerializable("meta_data", (HashMap) spaceRequest.getMetaData());
        return bundle;
    }

    public List<ContentValues> requestToContentValues(ShareApi.SharedItemWithUriListRequest sharedItemWithUriListRequest, String str, int i, long j) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < sharedItemWithUriListRequest.getUris().size(); i2++) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("title", sharedItemWithUriListRequest.getTitle());
            contentValues.put("spaceId", str);
            contentValues.put("memo", sharedItemWithUriListRequest.getMemo());
            contentValues.put("meta_data", getMetaString(sharedItemWithUriListRequest.getMetaData()));
            contentValues.put("instant_meta_data", getMetaString(sharedItemWithUriListRequest.getInstantMetaData()));
            contentValues.put("creator", sharedItemWithUriListRequest.getCreator());
            contentValues.put("referred_resource_id", sharedItemWithUriListRequest.getResourceId());
            contentValues.put("content_uri", sharedItemWithUriListRequest.getUris().get(i2).toString());
            contentValues.put("mime_type", sharedItemWithUriListRequest.getMimeTypeList().get(i2));
            contentValues.put(RequestDBConstants.ITEM_IDX, Integer.valueOf(i));
            contentValues.put("request_id", Long.valueOf(j));
            arrayList.add(contentValues);
        }
        return arrayList;
    }

    public ContentValues requestToContentValues(ShareApi.SharedItemRequest sharedItemRequest, String str, int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", sharedItemRequest.getTitle());
        contentValues.put("spaceId", str);
        contentValues.put("memo", sharedItemRequest.getMemo());
        contentValues.put("mime_type", sharedItemRequest.getContentMimeType());
        contentValues.put("meta_data", getMetaString(sharedItemRequest.getMetaData()));
        contentValues.put("instant_meta_data", getMetaString(sharedItemRequest.getInstantMetaData()));
        contentValues.put(RequestDBConstants.ITEM_IDX, Integer.valueOf(i));
        contentValues.put("request_id", Long.valueOf(j));
        if (sharedItemRequest instanceof ShareApi.SharedItemWithUriRequest) {
            ShareApi.SharedItemWithUriRequest sharedItemWithUriRequest = (ShareApi.SharedItemWithUriRequest) sharedItemRequest;
            contentValues.put(sharedItemWithUriRequest.isFileUri() ? RequestDBConstants.FILE_URI : "content_uri", sharedItemWithUriRequest.getUri().toString());
            return contentValues;
        }
        if (sharedItemRequest instanceof ShareApi.SharedItemWithSCloudHashRequest) {
            ShareApi.SharedItemWithSCloudHashRequest sharedItemWithSCloudHashRequest = (ShareApi.SharedItemWithSCloudHashRequest) sharedItemRequest;
            contentValues.put("hash", sharedItemWithSCloudHashRequest.getHash());
            contentValues.put("size", Long.valueOf(sharedItemWithSCloudHashRequest.getContentSize()));
            contentValues.put("file_name", sharedItemWithSCloudHashRequest.getContentName());
            return contentValues;
        }
        if (sharedItemRequest instanceof ShareApi.SharedItemWithMediaServiceContentIdRequest) {
            ShareApi.SharedItemWithMediaServiceContentIdRequest sharedItemWithMediaServiceContentIdRequest = (ShareApi.SharedItemWithMediaServiceContentIdRequest) sharedItemRequest;
            contentValues.put("media_service_content_id", sharedItemWithMediaServiceContentIdRequest.getMediaServiceContentId());
            contentValues.put("size", Long.valueOf(sharedItemWithMediaServiceContentIdRequest.getContentSize()));
            contentValues.put("file_name", sharedItemWithMediaServiceContentIdRequest.getContentName());
        }
        return contentValues;
    }

    public SharedItem createSharedItemResult(Bundle bundle) {
        SharedItem sharedItem = new SharedItem(bundle.getString("item_id"), bundle.getString("space_id"), bundle.getString(BundleKey.OWNER_ID));
        createSharedItemResult(sharedItem, bundle);
        return sharedItem;
    }

    public Bundle requestToBundle(ShareApi.SharedItemWithUriListRequest sharedItemWithUriListRequest) {
        Bundle bundle = new Bundle();
        bundle.putString("title", sharedItemWithUriListRequest.getTitle());
        bundle.putString("memo", sharedItemWithUriListRequest.getMemo());
        bundle.putString("mime_type", sharedItemWithUriListRequest.getContentMimeType());
        bundle.putInt("request_type", 0);
        bundle.putSerializable("meta_data", (HashMap) sharedItemWithUriListRequest.getMetaData());
        bundle.putSerializable("instant_meta_data", (HashMap) sharedItemWithUriListRequest.getInstantMetaData());
        bundle.putString("creator", sharedItemWithUriListRequest.getCreator());
        bundle.putString("referred_resource_id", sharedItemWithUriListRequest.getResourceId());
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        for (int i = 0; i < sharedItemWithUriListRequest.getUris().size(); i++) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("content_uri", sharedItemWithUriListRequest.getUris().get(i).toString());
            bundle2.putString("mime_type", sharedItemWithUriListRequest.getMimeTypeList().get(i));
            arrayList.add(bundle2);
        }
        bundle.putParcelableArrayList(BundleKey.SHARE_FILE_LIST, arrayList);
        showLog("- title=[" + sharedItemWithUriListRequest.getTitle() + "], memo=[" + sharedItemWithUriListRequest.getMemo() + "], mime_type=[" + sharedItemWithUriListRequest.getContentMimeType() + "] ");
        return bundle;
    }

    public Bundle requestToBundle(ShareApi.SharedItemUpdateWithUriListRequest sharedItemUpdateWithUriListRequest) {
        Bundle bundle = new Bundle();
        bundle.putString("item_id", sharedItemUpdateWithUriListRequest.getItemId());
        bundle.putString("title", sharedItemUpdateWithUriListRequest.getTitle());
        bundle.putString("memo", sharedItemUpdateWithUriListRequest.getMemo());
        bundle.putString("mime_type", sharedItemUpdateWithUriListRequest.getContentMimeType());
        bundle.putInt("request_type", 0);
        bundle.putSerializable("meta_data", (HashMap) sharedItemUpdateWithUriListRequest.getMetaData());
        bundle.putSerializable("instant_meta_data", (HashMap) sharedItemUpdateWithUriListRequest.getInstantMetaData());
        bundle.putBoolean("file_replace_required", sharedItemUpdateWithUriListRequest.isFileReplaceRequired());
        bundle.putString("creator", sharedItemUpdateWithUriListRequest.getCreator());
        bundle.putString("referred_resource_id", sharedItemUpdateWithUriListRequest.getResourceId());
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        for (int i = 0; i < sharedItemUpdateWithUriListRequest.getUris().size(); i++) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("content_uri", sharedItemUpdateWithUriListRequest.getUris().get(i).toString());
            bundle2.putString("mime_type", sharedItemUpdateWithUriListRequest.getMimeTypeList().get(i));
            arrayList.add(bundle2);
        }
        bundle.putParcelableArrayList(BundleKey.SHARE_FILE_LIST, arrayList);
        showLog("- title=[" + sharedItemUpdateWithUriListRequest.getTitle() + "], memo=[" + sharedItemUpdateWithUriListRequest.getMemo() + "], mime_type=[" + sharedItemUpdateWithUriListRequest.getContentMimeType() + "] ");
        return bundle;
    }

    public Bundle requestToBundle(ShareApi.SharedItemRequest sharedItemRequest) {
        Bundle bundle = new Bundle();
        bundle.putString("item_id", sharedItemRequest.getItemId());
        bundle.putString("title", sharedItemRequest.getTitle());
        bundle.putString("memo", sharedItemRequest.getMemo());
        bundle.putString("mime_type", sharedItemRequest.getContentMimeType());
        bundle.putSerializable("meta_data", (HashMap) sharedItemRequest.getMetaData());
        bundle.putSerializable("instant_meta_data", (HashMap) sharedItemRequest.getInstantMetaData());
        if (sharedItemRequest instanceof ShareApi.SharedItemWithUriRequest) {
            ShareApi.SharedItemWithUriRequest sharedItemWithUriRequest = (ShareApi.SharedItemWithUriRequest) sharedItemRequest;
            bundle.putString(sharedItemWithUriRequest.isFileUri() ? "content_file_uri" : "content_uri", sharedItemWithUriRequest.getUri() == null ? "" : sharedItemWithUriRequest.getUri().toString());
            bundle.putInt("request_type", 0);
        } else if (sharedItemRequest instanceof ShareApi.SharedItemWithSCloudHashRequest) {
            ShareApi.SharedItemWithSCloudHashRequest sharedItemWithSCloudHashRequest = (ShareApi.SharedItemWithSCloudHashRequest) sharedItemRequest;
            bundle.putString(BundleKey.CONTENT_HASH, sharedItemWithSCloudHashRequest.getHash());
            bundle.putLong(BundleKey.FILE_SIZE, sharedItemWithSCloudHashRequest.getContentSize());
            bundle.putString("file_name", sharedItemWithSCloudHashRequest.getContentName());
            bundle.putInt("request_type", 1);
        } else if (sharedItemRequest instanceof ShareApi.SharedItemWithMediaServiceContentIdRequest) {
            ShareApi.SharedItemWithMediaServiceContentIdRequest sharedItemWithMediaServiceContentIdRequest = (ShareApi.SharedItemWithMediaServiceContentIdRequest) sharedItemRequest;
            bundle.putString("media_service_content_id", sharedItemWithMediaServiceContentIdRequest.getMediaServiceContentId());
            bundle.putLong(BundleKey.FILE_SIZE, sharedItemWithMediaServiceContentIdRequest.getContentSize());
            bundle.putString("file_name", sharedItemWithMediaServiceContentIdRequest.getContentName());
            bundle.putInt("request_type", 2);
        } else {
            bundle.putInt("request_type", 0);
        }
        showLog("- title=[" + sharedItemRequest.getTitle() + "], memo=[" + sharedItemRequest.getMemo() + "], mime_type=[" + sharedItemRequest.getContentMimeType() + "] ");
        return bundle;
    }
}
