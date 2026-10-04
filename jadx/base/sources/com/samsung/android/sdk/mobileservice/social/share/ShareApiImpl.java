package com.samsung.android.sdk.mobileservice.social.share;

import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.glance.AbstractC2821a;
import com.samsung.android.sdk.mobileservice.SeMobileServiceSession;
import com.samsung.android.sdk.mobileservice.common.CommonConstants;
import com.samsung.android.sdk.mobileservice.common.ErrorCodeConvertor;
import com.samsung.android.sdk.mobileservice.common.api.SeMobileServiceApi;
import com.samsung.android.sdk.mobileservice.common.exception.NotAuthorizedException;
import com.samsung.android.sdk.mobileservice.common.exception.NotConnectedException;
import com.samsung.android.sdk.mobileservice.common.result.BooleanResult;
import com.samsung.android.sdk.mobileservice.common.result.CommonResultStatus;
import com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial;
import com.samsung.android.sdk.mobileservice.social.common.IBundleResultCallback;
import com.samsung.android.sdk.mobileservice.social.share.IContentDownloadingResultCallback;
import com.samsung.android.sdk.mobileservice.social.share.IDownloadThumbnailResultCallback;
import com.samsung.android.sdk.mobileservice.social.share.IShareBulkItemResultCallback;
import com.samsung.android.sdk.mobileservice.social.share.IShareResultCallback;
import com.samsung.android.sdk.mobileservice.social.share.IShareResultWithFileListCallback;
import com.samsung.android.sdk.mobileservice.social.share.IShareSyncResultCallback;
import com.samsung.android.sdk.mobileservice.social.share.ISharedItemDeletionResultCallback;
import com.samsung.android.sdk.mobileservice.social.share.ISharedItemListDeletionResultCallback;
import com.samsung.android.sdk.mobileservice.social.share.ISharedItemListResultCallback;
import com.samsung.android.sdk.mobileservice.social.share.ISharedItemResultCallback;
import com.samsung.android.sdk.mobileservice.social.share.ISharedItemUpdateResultCallback;
import com.samsung.android.sdk.mobileservice.social.share.ISpaceCoverImageDownloadingResultCallback;
import com.samsung.android.sdk.mobileservice.social.share.ISpaceDeletionResultCallback;
import com.samsung.android.sdk.mobileservice.social.share.ISpaceListResultCallback;
import com.samsung.android.sdk.mobileservice.social.share.ISpaceResultCallback;
import com.samsung.android.sdk.mobileservice.social.share.ITrashBinResultCallback;
import com.samsung.android.sdk.mobileservice.social.share.Quota;
import com.samsung.android.sdk.mobileservice.social.share.ShareApi;
import com.samsung.android.sdk.mobileservice.social.share.ShareController;
import com.samsung.android.sdk.mobileservice.social.share.SharedItemWithUriList;
import com.samsung.android.sdk.mobileservice.social.share.provider.SharedItemContract;
import com.samsung.android.sdk.mobileservice.social.share.result.ContentDownloadResult;
import com.samsung.android.sdk.mobileservice.social.share.result.DownloadImageResult;
import com.samsung.android.sdk.mobileservice.social.share.result.ItemListResult;
import com.samsung.android.sdk.mobileservice.social.share.result.OriginalFile;
import com.samsung.android.sdk.mobileservice.social.share.result.OriginalFileListResult;
import com.samsung.android.sdk.mobileservice.social.share.result.QuotaResult;
import com.samsung.android.sdk.mobileservice.social.share.result.SharedItemListDeletionResult;
import com.samsung.android.sdk.mobileservice.social.share.result.SharedItemListResult;
import com.samsung.android.sdk.mobileservice.social.share.result.SharedItemListWithContentListResult;
import com.samsung.android.sdk.mobileservice.social.share.result.SharedItemListWithUriListResult;
import com.samsung.android.sdk.mobileservice.social.share.result.SharedItemResult;
import com.samsung.android.sdk.mobileservice.social.share.result.SharedItemWithUriListResult;
import com.samsung.android.sdk.mobileservice.social.share.result.SpaceImageDownloadResult;
import com.samsung.android.sdk.mobileservice.social.share.result.SpaceListResult;
import com.samsung.android.sdk.mobileservice.social.share.result.SpaceResult;
import com.samsung.android.sdk.mobileservice.social.share.result.TrashedItemListResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
class ShareApiImpl extends SeMobileServiceApi {
    private static final int BULK_INSERT_CHUNK_SIZE = 250;
    private static final int FEATURE_ID_INVALID = -1;
    private static final String TAG = "ShareApiImpl";
    private final String APP_ID_REMINDER;
    private final ShareController.ShareControllerApiPicker mApiPicker;

    public ShareApiImpl(SeMobileServiceSession seMobileServiceSession) throws NotAuthorizedException {
        super(seMobileServiceSession, "ShareApi");
        this.APP_ID_REMINDER = "8o8b82h22a";
        this.mApiPicker = new ShareController.ShareControllerApiPicker() { // from class: com.samsung.android.sdk.mobileservice.social.share.ShareApiImpl.1
            @Override // com.samsung.android.sdk.mobileservice.social.share.ShareController.ShareControllerApiPicker
            public String getAppId() {
                return ShareApiImpl.this.getAppId();
            }

            @Override // com.samsung.android.sdk.mobileservice.social.share.ShareController.ShareControllerApiPicker
            public String getReference() {
                return ShareApiImpl.this.getReference();
            }

            @Override // com.samsung.android.sdk.mobileservice.social.share.ShareController.ShareControllerApiPicker
            public IMobileServiceSocial getSocialService() {
                return ShareApiImpl.this.getSocialService();
            }
        };
        checkAuthorized(0, 2);
    }

    private List<OriginalFile> bundleToOriginalFileList(Bundle bundle) {
        ArrayList arrayList = new ArrayList();
        ArrayList<Bundle> parcelableArrayList = bundle.getParcelableArrayList(BundleKey.ORIGINAL_FILE_LIST);
        if (parcelableArrayList != null) {
            for (Bundle bundle2 : parcelableArrayList) {
                String string = bundle2.getString("hash");
                String string2 = bundle2.getString(BundleKey.FILE_PATH);
                String string3 = bundle2.getString("content_uri");
                Uri uri = Uri.EMPTY;
                if (!TextUtils.isEmpty(string3)) {
                    uri = Uri.parse(string3);
                }
                arrayList.add(new OriginalFile(string, string2, uri));
            }
        }
        return arrayList;
    }

    private Quota bundleToQuota(Bundle bundle) {
        String string = bundle != null ? bundle.getString(BundleKey.LIMIT_TYPE, "") : "";
        long j = bundle != null ? bundle.getLong(BundleKey.TOTAL_USAGE, -1L) : -1L;
        long j2 = bundle != null ? bundle.getLong("limit", -1L) : -1L;
        long j3 = bundle != null ? bundle.getLong(BundleKey.TOTAL_COUNT_USAGE, -1L) : -1L;
        long j5 = bundle != null ? bundle.getLong(BundleKey.LIMIT_COUNT_USAGE, -1L) : -1L;
        boolean z = false;
        if (bundle != null && bundle.getBoolean(BundleKey.isUnlimited, false)) {
            z = true;
        }
        return new Quota(Quota.LimitType.toLimitType(string), j, j2, j3, j5, z);
    }

    private boolean checkInvalidFeatureIdAndAgentVersion(int i) {
        if (i != 501 || isSupportedSemsAgentVersionBetween(CommonConstants.SupportedApiMinVersion.VERSION_10_8_8, CommonConstants.SupportedApiMinVersion.VERSION_11_0) || isSupportedSemsAgentVersionMoreThan(CommonConstants.SupportedApiMinVersion.VERSION_13_1_0)) {
            return false;
        }
        infoLog("isValidFeatureIdAndAgentVersion with" + i + "is not supported in this agent version");
        return true;
    }

    private IShareSyncResultCallback createShareSyncCallback(final ShareApi.ShareSyncResultCallback shareSyncResultCallback) {
        return new IShareSyncResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.share.ShareApiImpl.2
            @Override // com.samsung.android.sdk.mobileservice.social.share.IShareSyncResultCallback
            public void onFailure(long j, String str) {
                ShareApiImpl shareApiImpl = ShareApiImpl.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestSync onFailure : code=[", "], message=[", str);
                sbM2225p.append("] ");
                shareApiImpl.infoLog(sbM2225p.toString());
                if (shareSyncResultCallback != null) {
                    shareSyncResultCallback.onResult(new BooleanResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), str, Long.toString(j)), false));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.share.IShareSyncResultCallback
            public void onSuccess() {
                ShareApiImpl.this.infoLog("requestSync onSuccess ");
                ShareApi.ShareSyncResultCallback shareSyncResultCallback2 = shareSyncResultCallback;
                if (shareSyncResultCallback2 != null) {
                    shareSyncResultCallback2.onResult(new BooleanResult(new CommonResultStatus(1), true));
                }
            }
        };
    }

    private int downloadThumbnail(String str, String str2, String str3, String str4, String str5, final ShareApi.ShareBaseResultCallback<DownloadImageResult> shareBaseResultCallback) {
        if (TextUtils.isEmpty(getAppId())) {
            infoLog("app id is empty ");
            return -1;
        }
        try {
            getSocialService().requestThumbnailDownload(getAppId(), str, str2, str3, str4, str5, new IDownloadThumbnailResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.share.ShareApiImpl.22
                @Override // com.samsung.android.sdk.mobileservice.social.share.IDownloadThumbnailResultCallback
                public void onFailure(long j, String str6) {
                    ShareApiImpl shareApiImpl = ShareApiImpl.this;
                    StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestThumbnailDownload onFailure : code=[", "], message=[", str6);
                    sbM2225p.append("] ");
                    shareApiImpl.infoLog(sbM2225p.toString());
                    if (shareBaseResultCallback != null) {
                        shareBaseResultCallback.onResult(new DownloadImageResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), str6, Long.toString(j)), null));
                    }
                }

                @Override // com.samsung.android.sdk.mobileservice.social.share.IDownloadThumbnailResultCallback
                public void onSuccess(Bundle bundle) {
                    ShareApiImpl.this.infoLog("requestThumbnailDownload onSuccess ");
                    if (shareBaseResultCallback != null) {
                        String string = bundle.getString("item_id", null);
                        String string2 = bundle.getString(BundleKey.CONTENT_HASH, null);
                        String string3 = bundle.getString(BundleKey.ITEM_THUMBNAIL_LOCAL_PATH, null);
                        DownloadImageResult.DownloadedImage downloadedImage = new DownloadImageResult.DownloadedImage(string, string2, string3 != null ? Uri.parse(string3) : null);
                        ShareApiImpl.this.debugLog(AbstractC0541b.m775q("- item_id = [", string, "], thumbnail local path = [", string3, "] "));
                        shareBaseResultCallback.onResult(new DownloadImageResult(new CommonResultStatus(1), downloadedImage));
                    }
                }
            });
            return 1;
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return -1;
        } catch (NotConnectedException e2) {
            secureLog(e2);
            return -8;
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return -1;
        }
    }

    private SharedItemWithUriList.Content getContentFromDB(Cursor cursor) {
        SharedItemWithUriList.Content content = new SharedItemWithUriList.Content(cursor.getString(cursor.getColumnIndex("hash")), cursor.getString(cursor.getColumnIndex("mime_type")), null, cursor.getString(cursor.getColumnIndex("name")), cursor.getLong(cursor.getColumnIndex("size")), null);
        content.setThumbnailContentUri(Uri.parse(cursor.getString(cursor.getColumnIndex("thumbnail_content_uri"))));
        return content;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0101 A[Catch: all -> 0x00fe, TRY_LEAVE, TryCatch #3 {all -> 0x00fe, blocks: (B:5:0x0020, B:7:0x0026, B:11:0x00d2, B:16:0x0101), top: B:40:0x0020, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<SharedItem> getItemFromDB(Context context, int i, long j) {
        Uri itemUri = RequestDBConstants.getItemUri(getAppId(), i);
        String strM1169o = AbstractC0622a.m1169o("bulk_item_request_id = ", j);
        ArrayList arrayList = new ArrayList();
        try {
            Cursor cursorQuery = context.getContentResolver().query(itemUri, null, strM1169o, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        do {
                            SharedItem sharedItem = new SharedItem(cursorQuery.getString(cursorQuery.getColumnIndex("itemId")), cursorQuery.getString(cursorQuery.getColumnIndex("spaceId")), cursorQuery.getString(cursorQuery.getColumnIndex("owner")));
                            sharedItem.setTitle(cursorQuery.getString(cursorQuery.getColumnIndex("title")));
                            sharedItem.setMemo(cursorQuery.getString(cursorQuery.getColumnIndex("memo")));
                            sharedItem.setCreator(cursorQuery.getString(cursorQuery.getColumnIndex("creator")));
                            sharedItem.setLastModifier(cursorQuery.getString(cursorQuery.getColumnIndex(SharedItemContract.Item.LAST_MODIFIER)));
                            sharedItem.setCreatedTime(cursorQuery.getLong(cursorQuery.getColumnIndex("createTime")));
                            sharedItem.setModifiedTime(cursorQuery.getLong(cursorQuery.getColumnIndex("modifiedTime")));
                            sharedItem.setMimeType(cursorQuery.getString(cursorQuery.getColumnIndex("mime_type")));
                            sharedItem.setStreamingUrl(cursorQuery.getString(cursorQuery.getColumnIndex("streaming_url")));
                            sharedItem.setSize(cursorQuery.getLong(cursorQuery.getColumnIndex("size")));
                            sharedItem.setOwnedByMe(cursorQuery.getInt(cursorQuery.getColumnIndex("is_owned_by_me")) > 0);
                            sharedItem.setThumbnailContentUri(Uri.parse(cursorQuery.getString(cursorQuery.getColumnIndex("thumbnail_content_uri"))));
                            sharedItem.setMetaString(cursorQuery.getString(cursorQuery.getColumnIndex("meta_data")));
                            arrayList.add(sharedItem);
                        } while (cursorQuery.moveToNext());
                    } else {
                        infoLog("content uri is wrong");
                    }
                } finally {
                }
            }
            if (cursorQuery == null) {
                return arrayList;
            }
            cursorQuery.close();
            return arrayList;
        } catch (Exception e) {
            secureLog(e);
            infoLog("getItemFromDB exception is occurred while get response");
            return arrayList;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0061 A[Catch: all -> 0x0045, TRY_LEAVE, TryCatch #1 {all -> 0x0045, blocks: (B:5:0x0021, B:7:0x0027, B:9:0x0039, B:13:0x005a, B:12:0x0048, B:16:0x0061), top: B:35:0x0021, outer: #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private List<SharedItemWithUriList> getItemWithUriListFromDB(Context context, int i, long j) {
        Uri itemUri = RequestDBConstants.getItemUri(getAppId(), i);
        String strM1169o = AbstractC0622a.m1169o("request_id = ", j);
        HashMap map = new HashMap();
        try {
            Cursor cursorQuery = context.getContentResolver().query(itemUri, null, strM1169o, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        do {
                            String string = cursorQuery.getString(cursorQuery.getColumnIndex("itemId"));
                            SharedItemWithUriList sharedItemWithUriList = (SharedItemWithUriList) map.get(string);
                            if (sharedItemWithUriList != null) {
                                sharedItemWithUriList.getContentList().add(getContentFromDB(cursorQuery));
                            } else {
                                SharedItemWithUriList sharedItemFromDB = getSharedItemFromDB(cursorQuery, string);
                                sharedItemFromDB.getContentList().add(getContentFromDB(cursorQuery));
                                map.put(string, sharedItemFromDB);
                            }
                        } while (cursorQuery.moveToNext());
                    } else {
                        infoLog("content uri is wrong");
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                } finally {
                }
            }
        } catch (Exception unused) {
            infoLog("getItemWithUriListFromDB exception is occurred while get response");
        }
        return new ArrayList(map.values());
    }

    private SharedItemWithUriList getSharedItemFromDB(Cursor cursor, String str) {
        SharedItemWithUriList sharedItemWithUriList = new SharedItemWithUriList(str, cursor.getString(cursor.getColumnIndex("spaceId")), cursor.getString(cursor.getColumnIndex("owner")));
        sharedItemWithUriList.setLastModifierId(cursor.getString(cursor.getColumnIndex(SharedItemContract.Item.LAST_MODIFIER)));
        sharedItemWithUriList.setTitle(cursor.getString(cursor.getColumnIndex("title")));
        sharedItemWithUriList.setMemo(cursor.getString(cursor.getColumnIndex("memo")));
        sharedItemWithUriList.setCreatedTime(cursor.getLong(cursor.getColumnIndex("createTime")));
        sharedItemWithUriList.setModifiedTime(cursor.getLong(cursor.getColumnIndex("modifiedTime")));
        sharedItemWithUriList.setOwnedByMe(cursor.getInt(cursor.getColumnIndex("is_owned_by_me")) > 0);
        sharedItemWithUriList.setCreator(cursor.getString(cursor.getColumnIndex("creator")));
        sharedItemWithUriList.setResourceId(cursor.getString(cursor.getColumnIndex("referred_resource_id")));
        sharedItemWithUriList.setMetaString(cursor.getString(cursor.getColumnIndex("meta_data")));
        return sharedItemWithUriList;
    }

    private long insertBulkItemToDB(Context context, String str, List<ShareApi.SharedItemRequest> list, int i) {
        int iBulkInsert;
        ArrayList arrayList = new ArrayList();
        long jCurrentTimeMillis = System.currentTimeMillis();
        Iterator<ShareApi.SharedItemRequest> it = list.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            String str2 = str;
            arrayList.add(ShareApiUtil.getInstance(getTag(), getReference(), getAppId()).requestToContentValues(it.next(), str2, i2, jCurrentTimeMillis));
            str = str2;
            i2++;
        }
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        Uri bulkItemUri = RequestDBConstants.getBulkItemUri(getAppId(), i);
        if (arrayList.size() > 250) {
            iBulkInsert = 0;
            for (int i4 = 0; i4 < arrayList.size(); i4 += 250) {
                List listSubList = arrayList.subList(i4, Math.min(arrayList.size() - i4, 250) + i4);
                infoLog("bulkInsert : Enter A=[" + listSubList.size() + "] ");
                iBulkInsert += context.getContentResolver().bulkInsert(bulkItemUri, (ContentValues[]) listSubList.toArray(new ContentValues[listSubList.size()]));
            }
        } else {
            infoLog("bulkInsert : Enter B=[0] ");
            iBulkInsert = context.getContentResolver().bulkInsert(bulkItemUri, (ContentValues[]) arrayList.toArray(new ContentValues[arrayList.size()]));
        }
        infoLog("bulkInsert : Uri=[" + bulkItemUri + "] ");
        infoLog("bulkInsert : count=[" + arrayList.size() + "] ");
        infoLog("bulkInsert : size=[" + iBulkInsert + "] ");
        Binder.restoreCallingIdentity(jClearCallingIdentity);
        return jCurrentTimeMillis;
    }

    private long insertBulkItemWithUriListToDB(Context context, String str, List<ShareApi.SharedItemWithUriListRequest> list, int i) {
        ArrayList arrayList = new ArrayList();
        long jCurrentTimeMillis = System.currentTimeMillis();
        Iterator<ShareApi.SharedItemWithUriListRequest> it = list.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            String str2 = str;
            arrayList.addAll(ShareApiUtil.getInstance(getTag(), getReference(), getAppId()).requestToContentValues(it.next(), str2, i2, jCurrentTimeMillis));
            str = str2;
            i2++;
        }
        ContentValues[] contentValuesArr = (ContentValues[]) arrayList.toArray(new ContentValues[arrayList.size()]);
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        context.getContentResolver().bulkInsert(RequestDBConstants.getBulkItemUri(getAppId(), i), contentValuesArr);
        Binder.restoreCallingIdentity(jClearCallingIdentity);
        return jCurrentTimeMillis;
    }

    public void clearUnreadCount(String str, String str2, int i) {
        if (checkInvalidFeatureIdAndAgentVersion(i)) {
            infoLog("clearUnreadCount is not supported in " + i);
            return;
        }
        try {
            if (i == 501) {
                Bundle bundle = new Bundle();
                bundle.putInt("featureId", i);
                getSocialService().clearSpaceUnreadCountWithData(getAppId(), bundle, str);
            } else {
                if (TextUtils.isEmpty(str2)) {
                    getSocialService().clearSpaceUnreadCount(getAppId(), str);
                    return;
                }
                Bundle bundle2 = new Bundle();
                bundle2.putString(BundleKey.EXTRA_CID, str2);
                getSocialService().clearSpaceUnreadCountWithData(getAppId(), bundle2, str);
            }
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
        } catch (NotConnectedException e2) {
            e = e2;
            secureLog(e);
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
        }
    }

    @Override // com.samsung.android.sdk.mobileservice.common.api.SeMobileServiceApi
    public String[] getEssentialServiceNames() {
        return new String[]{"SocialService"};
    }

    public QuotaResult getFamilyQuota(int i) {
        infoLog("getFamilyQuota ");
        if (!isSupportedSemsAgentVersionBetween(CommonConstants.SupportedApiMinVersion.VERSION_10_8_9, CommonConstants.SupportedApiMinVersion.VERSION_11_0) && !isSupportedSemsAgentVersionMoreThan(CommonConstants.SupportedApiMinVersion.VERSION_13_1_10)) {
            return new QuotaResult(new CommonResultStatus(-7), null);
        }
        if (checkInvalidFeatureIdAndAgentVersion(i)) {
            return new QuotaResult(new CommonResultStatus(-7), null);
        }
        if (getAppId() == null) {
            infoLog("app id is null ");
            return new QuotaResult(new CommonResultStatus(-1), null);
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("featureId", i);
            bundle.putString("appId", getAppId());
            return new QuotaResult(new CommonResultStatus(1), bundleToQuota(getSocialService().getFamilyQuotaWithData(bundle)));
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return new QuotaResult(new CommonResultStatus(-1), null);
        } catch (NotConnectedException e2) {
            secureLog(e2);
            return new QuotaResult(new CommonResultStatus(-8), null);
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return new QuotaResult(new CommonResultStatus(-1), null);
        }
    }

    public QuotaResult getQuota(int i) {
        infoLog("getQuota ");
        if (!isSupportedSemsAgentVersionBetween(CommonConstants.SupportedApiMinVersion.VERSION_10_8_6, CommonConstants.SupportedApiMinVersion.VERSION_11_0) && !isSupportedSemsAgentVersionMoreThan(CommonConstants.SupportedApiMinVersion.VERSION_13_0_1)) {
            return new QuotaResult(new CommonResultStatus(-7), null);
        }
        if (checkInvalidFeatureIdAndAgentVersion(i)) {
            return new QuotaResult(new CommonResultStatus(-7), null);
        }
        if (getAppId() == null) {
            infoLog("app id is null ");
            return new QuotaResult(new CommonResultStatus(-1), null);
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("featureId", i);
            bundle.putString("appId", getAppId());
            return new QuotaResult(new CommonResultStatus(1), bundleToQuota(getSocialService().getQuotaWithData(bundle)));
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return new QuotaResult(new CommonResultStatus(-1), null);
        } catch (NotConnectedException e2) {
            secureLog(e2);
            return new QuotaResult(new CommonResultStatus(-8), null);
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return new QuotaResult(new CommonResultStatus(-1), null);
        }
    }

    @Override // com.samsung.android.sdk.mobileservice.common.api.SeMobileServiceApi
    public String getTag() {
        return TAG;
    }

    public OriginalFileListResult getVerifiedOriginalFileList(List<String> list, int i) {
        infoLog("getVerifiedOriginalFileList : count=[" + list.size() + "]");
        if (!isSupportedSemsAgentVersionMoreThan(CommonConstants.SupportedApiMinVersion.VERSION_13_1_0)) {
            return new OriginalFileListResult(new CommonResultStatus(-7), null);
        }
        if (getAppId() == null) {
            infoLog("app id is null ");
            return new OriginalFileListResult(new CommonResultStatus(-1), null);
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("featureId", i);
            bundle.putString("appId", getAppId());
            bundle.putStringArrayList(BundleKey.HASH_LIST, new ArrayList<>(list));
            return new OriginalFileListResult(new CommonResultStatus(1), bundleToOriginalFileList(getSocialService().getVerifiedOriginalFileListWithData(bundle)));
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return new OriginalFileListResult(new CommonResultStatus(-1), null);
        } catch (NotConnectedException e2) {
            secureLog(e2);
            return new OriginalFileListResult(new CommonResultStatus(-8), null);
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return new OriginalFileListResult(new CommonResultStatus(-1), null);
        }
    }

    public ShareController requestBulkItemShare(final Context context, String str, List<ShareApi.SharedItemRequest> list, ShareApi.ActionIntent actionIntent, ShareApi.NotificationMessage notificationMessage, final int i, Boolean bool, final ShareApi.ShareUploadResultCallback<SharedItemListResult> shareUploadResultCallback) {
        infoLog("requestBulkItemShare : spaceId=[" + str + "] ");
        if (i == 501 || i == 102) {
            infoLog("requestBulkItemShare is not supported in " + i);
            return null;
        }
        if (getAppId() == null) {
            infoLog("app id is null ");
            return null;
        }
        if (!isSupportedSemsAgentVersionMoreThan(CommonConstants.SupportedApiMinVersion.VERSION_13_6_50)) {
            return requestShare(str, list, actionIntent, notificationMessage, i, shareUploadResultCallback);
        }
        final long jInsertBulkItemToDB = insertBulkItemToDB(context, str, list, i);
        IShareBulkItemResultCallback.Stub stub = new IShareBulkItemResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.share.ShareApiImpl.16
            @Override // com.samsung.android.sdk.mobileservice.social.share.IShareBulkItemResultCallback
            public void onFailure(long j, String str2) {
                ShareApiImpl shareApiImpl = ShareApiImpl.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestShare onFailure : code=[", "], message=[", str2);
                sbM2225p.append("] ");
                shareApiImpl.infoLog(sbM2225p.toString());
                if (shareUploadResultCallback != null) {
                    int iConvertErrorcode = ErrorCodeConvertor.convertErrorcode(j);
                    ShareApiImpl.this.debugLog(AbstractC0541b.m773o("requestShare Error Message [", str2, "]"));
                    shareUploadResultCallback.onResult(new SharedItemListResult(new CommonResultStatus(iConvertErrorcode, str2, Long.toString(j)), null, null));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.share.IShareBulkItemResultCallback
            public void onProgress(Bundle bundle) {
                ShareApiImpl.this.debugLog("requestShare onProgress ");
                ShareApi.ShareUploadResultCallback shareUploadResultCallback2 = shareUploadResultCallback;
                if (shareUploadResultCallback2 != null) {
                    shareUploadResultCallback2.onProgress(ShareApiUtil.getInstance(ShareApiImpl.this.getTag(), ShareApiImpl.this.getReference(), ShareApiImpl.this.getAppId()).bundleToShareSnapShot(bundle));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.share.IShareBulkItemResultCallback
            public void onSuccess() {
                ShareApiImpl.this.infoLog("requestShare onSuccess ");
                if (shareUploadResultCallback != null) {
                    List itemFromDB = ShareApiImpl.this.getItemFromDB(context, i, jInsertBulkItemToDB);
                    ShareApiImpl.this.infoLog("successItemList size = " + itemFromDB.size());
                    shareUploadResultCallback.onResult(new SharedItemListResult(new CommonResultStatus(1), itemFromDB, new ArrayList()));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.share.IShareBulkItemResultCallback
            public void onUploadComplete(Bundle bundle) {
                ShareApiImpl.this.debugLog("requestShare onUploadComplete ");
                ShareApi.ShareUploadResultCallback shareUploadResultCallback2 = shareUploadResultCallback;
                if (shareUploadResultCallback2 != null) {
                    shareUploadResultCallback2.onUploadComplete(ShareApiUtil.getInstance(ShareApiImpl.this.getTag(), ShareApiImpl.this.getReference(), ShareApiImpl.this.getAppId()).bundleToShareSnapShot(bundle));
                }
            }
        };
        try {
            ArrayList arrayList = new ArrayList();
            Iterator<ShareApi.SharedItemRequest> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(ShareApiUtil.getInstance(getTag(), getReference(), getAppId()).requestToBundle(it.next()));
            }
            Bundle bundle = new Bundle();
            if (actionIntent != null) {
                bundle.putParcelable(BundleKey.PENDING_INTENTS, actionIntent.toBundle());
            }
            if (notificationMessage != null) {
                bundle.putParcelable(BundleKey.NOTIFICATION_MESSAGES, notificationMessage.toBundle());
            }
            if (bool != null) {
                bundle.putBoolean(BundleKey.USE_PRE_THUMBNAIL, bool.booleanValue());
            }
            bundle.putString("app_id", getAppId());
            bundle.putString("space_id", str);
            bundle.putString("request_id", String.valueOf(jInsertBulkItemToDB));
            return new ShareController(this.mApiPicker, getSocialService().requestBulkItemShare(bundle, stub));
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return null;
        } catch (NotConnectedException e2) {
            e = e2;
            secureLog(e);
            return null;
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return null;
        }
    }

    public int requestDeleteAllItemsFromTrashBin(String str, String str2, String str3, int i, final ShareApi.ShareBaseResultCallback<ItemListResult> shareBaseResultCallback) {
        infoLog("requestDeleteAllItemsFromTrashBin : spaceId=[" + str2 + "]");
        if (!isSupportedSemsAgentVersionMoreThan(CommonConstants.SupportedApiMinVersion.VERSION_13_1_10)) {
            return -1;
        }
        if (TextUtils.isEmpty(getAppId())) {
            infoLog("app id is empty ");
            return -1;
        }
        ITrashBinResultCallback.Stub stub = new ITrashBinResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.share.ShareApiImpl.34
            @Override // com.samsung.android.sdk.mobileservice.social.share.ITrashBinResultCallback
            public void onFailure(long j, String str4) {
                ShareApiImpl shareApiImpl = ShareApiImpl.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestDeleteAllItemsFromTrashBin onFailure : code=[", "], message=[", str4);
                sbM2225p.append("] ");
                shareApiImpl.infoLog(sbM2225p.toString());
                if (shareBaseResultCallback != null) {
                    shareBaseResultCallback.onResult(new ItemListResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), str4, Long.toString(j)), new ArrayList(), new ArrayList()));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.share.ITrashBinResultCallback
            public void onSuccess(List<Bundle> list) {
                ShareApiImpl.this.infoLog("requestDeleteAllItemsFromTrashBin onSuccess ");
                if (shareBaseResultCallback != null) {
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    for (Bundle bundle : list) {
                        String string = bundle.getString("space_id");
                        String string2 = bundle.getString("item_id");
                        if (bundle.getBoolean("result")) {
                            arrayList.add(new ItemListResult.SharedItemListSuccessResult(string, string2));
                        } else {
                            arrayList2.add(new ItemListResult.SharedItemListFailureResult(string, string2, Long.valueOf(bundle.getLong("error_code"))));
                        }
                    }
                    shareBaseResultCallback.onResult(new ItemListResult(new CommonResultStatus(1), arrayList, arrayList2));
                }
            }
        };
        try {
            Bundle bundle = new Bundle();
            bundle.putString("appId", getAppId());
            if (i != -1) {
                bundle.putInt("featureId", i);
            }
            if (!TextUtils.isEmpty(str3)) {
                bundle.putString(BundleKey.EXTRA_CID, str3);
            }
            bundle.putString("groupId", str);
            bundle.putString("spaceId", str2);
            getSocialService().requestDeleteAllItemsFromTrashBinWithData(bundle, stub);
            return 1;
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return -1;
        } catch (NotConnectedException e2) {
            secureLog(e2);
            return -8;
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return -1;
        }
    }

    public int requestDeleteItemListFromTrashBin(String str, String str2, List<String> list, String str3, int i, final ShareApi.ShareBaseResultCallback<ItemListResult> shareBaseResultCallback) {
        StringBuilder sbM15l = AbstractC0000a.m15l("requestDeleteItemListFromTrashBin : spaceId=[", str2, "], itemId size=");
        sbM15l.append(list.size());
        infoLog(sbM15l.toString());
        if (!isSupportedSemsAgentVersionMoreThan(CommonConstants.SupportedApiMinVersion.VERSION_13_1_10)) {
            return -1;
        }
        if (TextUtils.isEmpty(getAppId())) {
            infoLog("app id is empty ");
            return -1;
        }
        ITrashBinResultCallback.Stub stub = new ITrashBinResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.share.ShareApiImpl.33
            @Override // com.samsung.android.sdk.mobileservice.social.share.ITrashBinResultCallback
            public void onFailure(long j, String str4) {
                ShareApiImpl shareApiImpl = ShareApiImpl.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestDeleteItemListFromTrashBin onFailure : code=[", "], message=[", str4);
                sbM2225p.append("] ");
                shareApiImpl.infoLog(sbM2225p.toString());
                if (shareBaseResultCallback != null) {
                    shareBaseResultCallback.onResult(new ItemListResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), str4, Long.toString(j)), new ArrayList(), new ArrayList()));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.share.ITrashBinResultCallback
            public void onSuccess(List<Bundle> list2) {
                ShareApiImpl.this.infoLog("requestDeleteItemListFromTrashBin onSuccess ");
                if (shareBaseResultCallback != null) {
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    for (Bundle bundle : list2) {
                        String string = bundle.getString("space_id");
                        String string2 = bundle.getString("item_id");
                        if (bundle.getBoolean("result")) {
                            arrayList.add(new ItemListResult.SharedItemListSuccessResult(string, string2));
                        } else {
                            arrayList2.add(new ItemListResult.SharedItemListFailureResult(string, string2, Long.valueOf(bundle.getLong("error_code"))));
                        }
                    }
                    shareBaseResultCallback.onResult(new ItemListResult(new CommonResultStatus(1), arrayList, arrayList2));
                }
            }
        };
        try {
            Bundle bundle = new Bundle();
            bundle.putString("appId", getAppId());
            if (i != -1) {
                bundle.putInt("featureId", i);
            }
            if (!TextUtils.isEmpty(str3)) {
                bundle.putString(BundleKey.EXTRA_CID, str3);
            }
            bundle.putString("groupId", str);
            bundle.putString("spaceId", str2);
            bundle.putStringArrayList(BundleKey.itemIdList, new ArrayList<>(list));
            getSocialService().requestDeleteItemListFromTrashBinWithData(bundle, stub);
            return 1;
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return -1;
        } catch (NotConnectedException e2) {
            secureLog(e2);
            return -8;
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return -1;
        }
    }

    public int requestItemThumbnailDownload(String str, String str2, String str3, String str4, String str5, int i, ShareApi.ShareBaseResultCallback<DownloadImageResult> shareBaseResultCallback) {
        StringBuilder sbM16m = AbstractC0000a.m16m("requestItemThumbnailDownload. groupId=[", str, "] spaceId=[", str2, "] itemId=[");
        sbM16m.append(str3);
        sbM16m.append("] ");
        infoLog(sbM16m.toString());
        if (!isSupportedSemsAgentVersionMoreThan(CommonConstants.SupportedApiMinVersion.VERSION_12_1)) {
            return -7;
        }
        if (i != 501) {
            return downloadThumbnail(str, str2, str3, str4, str5, shareBaseResultCallback);
        }
        infoLog("requestItemThumbnailDownload is not supported in " + i);
        return -1;
    }

    public int requestMoveItemListToTrashBin(String str, String str2, List<String> list, String str3, int i, final ShareApi.ShareBaseResultCallback<ItemListResult> shareBaseResultCallback) {
        StringBuilder sbM15l = AbstractC0000a.m15l("requestMoveItemListToTrashBin : spaceId=[", str2, "], itemId size=");
        sbM15l.append(list.size());
        infoLog(sbM15l.toString());
        if (!isSupportedSemsAgentVersionMoreThan(CommonConstants.SupportedApiMinVersion.VERSION_13_1_10)) {
            return -1;
        }
        if (TextUtils.isEmpty(getAppId())) {
            infoLog("app id is empty ");
            return -1;
        }
        ITrashBinResultCallback.Stub stub = new ITrashBinResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.share.ShareApiImpl.31
            @Override // com.samsung.android.sdk.mobileservice.social.share.ITrashBinResultCallback
            public void onFailure(long j, String str4) {
                ShareApiImpl shareApiImpl = ShareApiImpl.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestMoveItemListToTrashBin onFailure : code=[", "], message=[", str4);
                sbM2225p.append("] ");
                shareApiImpl.infoLog(sbM2225p.toString());
                if (shareBaseResultCallback != null) {
                    shareBaseResultCallback.onResult(new ItemListResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), str4, Long.toString(j)), new ArrayList(), new ArrayList()));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.share.ITrashBinResultCallback
            public void onSuccess(List<Bundle> list2) {
                ShareApiImpl.this.infoLog("requestMoveItemListToTrashBin onSuccess ");
                if (shareBaseResultCallback != null) {
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    for (Bundle bundle : list2) {
                        String string = bundle.getString("space_id");
                        String string2 = bundle.getString("item_id");
                        if (bundle.getBoolean("result")) {
                            arrayList.add(new ItemListResult.SharedItemListSuccessResult(string, string2));
                        } else {
                            arrayList2.add(new ItemListResult.SharedItemListFailureResult(string, string2, Long.valueOf(bundle.getLong("error_code"))));
                        }
                    }
                    shareBaseResultCallback.onResult(new ItemListResult(new CommonResultStatus(1), arrayList, arrayList2));
                }
            }
        };
        try {
            Bundle bundle = new Bundle();
            bundle.putString("appId", getAppId());
            if (i != -1) {
                bundle.putInt("featureId", i);
            }
            if (!TextUtils.isEmpty(str3)) {
                bundle.putString(BundleKey.EXTRA_CID, str3);
            }
            bundle.putString("groupId", str);
            bundle.putString("spaceId", str2);
            bundle.putStringArrayList(BundleKey.itemIdList, new ArrayList<>(list));
            getSocialService().requestMoveItemListToTrashBinWithData(bundle, stub);
            return 1;
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return -1;
        } catch (NotConnectedException e2) {
            secureLog(e2);
            return -8;
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return -1;
        }
    }

    public int requestRestoreItemListFromTrashBin(String str, String str2, List<String> list, String str3, int i, final ShareApi.ShareBaseResultCallback<ItemListResult> shareBaseResultCallback) {
        StringBuilder sbM15l = AbstractC0000a.m15l("requestRestoreItemListFromTrashBin : spaceId=[", str2, "], itemId size=");
        sbM15l.append(list.size());
        infoLog(sbM15l.toString());
        if (!isSupportedSemsAgentVersionMoreThan(CommonConstants.SupportedApiMinVersion.VERSION_13_1_10)) {
            return -1;
        }
        if (TextUtils.isEmpty(getAppId())) {
            infoLog("app id is empty ");
            return -1;
        }
        ITrashBinResultCallback.Stub stub = new ITrashBinResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.share.ShareApiImpl.32
            @Override // com.samsung.android.sdk.mobileservice.social.share.ITrashBinResultCallback
            public void onFailure(long j, String str4) {
                ShareApiImpl shareApiImpl = ShareApiImpl.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestRestoreItemListFromTrashBin onFailure : code=[", "], message=[", str4);
                sbM2225p.append("] ");
                shareApiImpl.infoLog(sbM2225p.toString());
                if (shareBaseResultCallback != null) {
                    shareBaseResultCallback.onResult(new ItemListResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), str4, Long.toString(j)), new ArrayList(), new ArrayList()));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.share.ITrashBinResultCallback
            public void onSuccess(List<Bundle> list2) {
                ShareApiImpl.this.infoLog("requestRestoreItemListFromTrashBin onSuccess ");
                if (shareBaseResultCallback != null) {
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    for (Bundle bundle : list2) {
                        String string = bundle.getString("space_id");
                        String string2 = bundle.getString("item_id");
                        if (bundle.getBoolean("result")) {
                            arrayList.add(new ItemListResult.SharedItemListSuccessResult(string, string2));
                        } else {
                            arrayList2.add(new ItemListResult.SharedItemListFailureResult(string, string2, Long.valueOf(bundle.getLong("error_code"))));
                        }
                    }
                    shareBaseResultCallback.onResult(new ItemListResult(new CommonResultStatus(1), arrayList, arrayList2));
                }
            }
        };
        try {
            Bundle bundle = new Bundle();
            bundle.putString("appId", getAppId());
            if (i != -1) {
                bundle.putInt("featureId", i);
            }
            if (!TextUtils.isEmpty(str3)) {
                bundle.putString(BundleKey.EXTRA_CID, str3);
            }
            bundle.putString("groupId", str);
            bundle.putString("spaceId", str2);
            bundle.putStringArrayList(BundleKey.itemIdList, new ArrayList<>(list));
            getSocialService().requestRestoreItemListFromTrashBinWithData(bundle, stub);
            return 1;
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return -1;
        } catch (NotConnectedException e2) {
            secureLog(e2);
            return -8;
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return -1;
        }
    }

    public ShareController requestShare(String str, List<ShareApi.SharedItemWithUriListRequest> list, String str2, int i, final ShareApi.ShareUploadResultCallback<SharedItemListWithUriListResult> shareUploadResultCallback, PendingIntent pendingIntent, Bundle bundle) {
        String strRequestShareWithItemFileList;
        infoLog("requestShare : spaceId=[" + str + "] ");
        if (checkInvalidFeatureIdAndAgentVersion(i)) {
            return null;
        }
        if (TextUtils.isEmpty(getAppId())) {
            infoLog("app id is empty ");
            return null;
        }
        IShareResultCallback.Stub stub = new IShareResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.share.ShareApiImpl.14
            @Override // com.samsung.android.sdk.mobileservice.social.share.IShareResultCallback
            public void onFailure(long j, String str3) {
                ShareApiImpl shareApiImpl = ShareApiImpl.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestShare onFailure : code=[", "], message=[", str3);
                sbM2225p.append("] ");
                shareApiImpl.infoLog(sbM2225p.toString());
                if (shareUploadResultCallback != null) {
                    int iConvertErrorcode = ErrorCodeConvertor.convertErrorcode(j);
                    ShareApiImpl.this.debugLog(AbstractC0541b.m773o("requestShare Error Message [", str3, "]"));
                    shareUploadResultCallback.onResult(new SharedItemListWithUriListResult(new CommonResultStatus(iConvertErrorcode, str3, Long.toString(j)), null, null));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.share.IShareResultCallback
            public void onProgress(Bundle bundle2) {
                ShareApiImpl.this.debugLog("requestShare onProgress ");
                ShareApi.ShareUploadResultCallback shareUploadResultCallback2 = shareUploadResultCallback;
                if (shareUploadResultCallback2 != null) {
                    shareUploadResultCallback2.onProgress(ShareApiUtil.getInstance(ShareApiImpl.this.getTag(), ShareApiImpl.this.getReference(), ShareApiImpl.this.getAppId()).bundleToShareSnapShot(bundle2));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.share.IShareResultCallback
            public void onSuccess(List<Bundle> list2, List<Bundle> list3) {
                ShareApiImpl.this.infoLog("requestShare onSuccess ");
                if (shareUploadResultCallback != null) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<Bundle> it = list2.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new SharedItemWithUriList(it.next()));
                    }
                    ArrayList arrayList2 = new ArrayList();
                    Iterator<Bundle> it2 = list3.iterator();
                    while (it2.hasNext()) {
                        arrayList2.add(ShareApiUtil.getInstance(ShareApiImpl.this.getTag(), ShareApiImpl.this.getReference(), ShareApiImpl.this.getAppId()).createShareFailedItemWithUriListResult(it2.next()));
                    }
                    shareUploadResultCallback.onResult(new SharedItemListWithUriListResult(new CommonResultStatus(1), arrayList, arrayList2));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.share.IShareResultCallback
            public void onUploadComplete(Bundle bundle2) {
                ShareApiImpl.this.debugLog("requestShare onUploadComplete ");
                ShareApi.ShareUploadResultCallback shareUploadResultCallback2 = shareUploadResultCallback;
                if (shareUploadResultCallback2 != null) {
                    shareUploadResultCallback2.onUploadComplete(ShareApiUtil.getInstance(ShareApiImpl.this.getTag(), ShareApiImpl.this.getReference(), ShareApiImpl.this.getAppId()).bundleToShareSnapShot(bundle2));
                }
            }
        };
        try {
            ArrayList arrayList = new ArrayList();
            Iterator<ShareApi.SharedItemWithUriListRequest> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(ShareApiUtil.getInstance(getTag(), getReference(), getAppId()).requestToBundle(it.next()));
            }
            if (i == 501) {
                Bundle bundle2 = new Bundle();
                bundle2.putInt("featureId", i);
                strRequestShareWithItemFileList = getSocialService().requestShareWithItemFileListWithData(getAppId(), str, arrayList, bundle2, stub, pendingIntent, bundle);
            } else if (TextUtils.isEmpty(str2)) {
                strRequestShareWithItemFileList = getSocialService().requestShareWithItemFileList(getAppId(), str, arrayList, stub, pendingIntent, bundle);
            } else {
                Bundle bundle3 = new Bundle();
                bundle3.putString(BundleKey.EXTRA_CID, str2);
                strRequestShareWithItemFileList = getSocialService().requestShareWithItemFileListWithData(getAppId(), str, arrayList, bundle3, stub, pendingIntent, bundle);
            }
            return new ShareController(this.mApiPicker, strRequestShareWithItemFileList);
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return null;
        } catch (NotConnectedException e2) {
            e = e2;
            secureLog(e);
            return null;
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return null;
        }
    }

    public int requestSharedContentDownload(String str, List<String> list, int i, final ShareApi.ContentDownloadingResultCallback contentDownloadingResultCallback, PendingIntent pendingIntent, Bundle bundle, String str2) {
        infoLog("requestSharedContentDownload spaceId=[" + str + "] itemIdList=[" + list + "] ");
        if (i == 501) {
            infoLog("requestSharedContentDownload is not supported in " + i);
            return -1;
        }
        if (TextUtils.isEmpty(getAppId())) {
            infoLog("app id is empty ");
            return -1;
        }
        IContentDownloadingResultCallback.Stub stub = new IContentDownloadingResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.share.ShareApiImpl.13
            @Override // com.samsung.android.sdk.mobileservice.social.share.IContentDownloadingResultCallback
            public void onFailure(long j, String str3) {
                ShareApiImpl shareApiImpl = ShareApiImpl.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestSharedContentDownload onFailure : code=[", "], message=[", str3);
                sbM2225p.append("] ");
                shareApiImpl.infoLog(sbM2225p.toString());
                if (contentDownloadingResultCallback != null) {
                    contentDownloadingResultCallback.onResult(new ContentDownloadResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), str3, Long.toString(j)), null, null));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.share.IContentDownloadingResultCallback
            public void onProgress(Bundle bundle2) {
                ShareApiImpl.this.debugLog("requestSharedContentDownload onProgress ");
                ShareApi.ContentDownloadingResultCallback contentDownloadingResultCallback2 = contentDownloadingResultCallback;
                if (contentDownloadingResultCallback2 != null) {
                    contentDownloadingResultCallback2.onProgress(ShareApiUtil.getInstance(ShareApiImpl.this.getTag(), ShareApiImpl.this.getReference(), ShareApiImpl.this.getAppId()).bundleToDownloadSnapShot(bundle2));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.share.IContentDownloadingResultCallback
            public void onSuccess(List<Bundle> list2, List<Bundle> list3) {
                ShareApiImpl.this.infoLog("requestSharedContentDownload onSuccess ");
                if (contentDownloadingResultCallback != null) {
                    if (list2.isEmpty() && list3.isEmpty()) {
                        ShareApiImpl.this.debugLog("requestSharedContentDownload bundle is empty!!");
                        contentDownloadingResultCallback.onResult(new ContentDownloadResult(new CommonResultStatus(1), null, null));
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    Iterator<Bundle> it = list2.iterator();
                    while (it.hasNext()) {
                        arrayList.add(ShareApiUtil.getInstance(ShareApiImpl.this.getTag(), ShareApiImpl.this.getReference(), ShareApiImpl.this.getAppId()).bundleToDownloadContent(it.next()));
                    }
                    Iterator<Bundle> it2 = list3.iterator();
                    while (it2.hasNext()) {
                        arrayList2.add(ShareApiUtil.getInstance(ShareApiImpl.this.getTag(), ShareApiImpl.this.getReference(), ShareApiImpl.this.getAppId()).bundleToDownloadContent(it2.next()));
                    }
                    contentDownloadingResultCallback.onResult(new ContentDownloadResult(new CommonResultStatus(1), arrayList, arrayList2));
                }
            }
        };
        try {
            if (TextUtils.isEmpty(str2)) {
                getSocialService().requestOriginalSharedContentsDownload(getAppId(), str, (String[]) list.toArray(new String[0]), stub, pendingIntent, bundle);
                return 1;
            }
            getSocialService().requestOriginalSharedContentsDownloadWithPath(getAppId(), str, (String[]) list.toArray(new String[0]), stub, pendingIntent, bundle, str2);
            return 1;
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return -1;
        } catch (NotConnectedException e2) {
            secureLog(e2);
            return -8;
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return -1;
        }
    }

    public int requestSharedContentDownloadToHiddenFolder(String str, List<String> list, int i, final ShareApi.ContentDownloadingResultCallback contentDownloadingResultCallback) {
        infoLog("requestSharedContentDownloadToHiddenFolder spaceId=[" + str + "] itemIdList=[" + list + "] ");
        if (!isSupportedSemsAgentVersionMoreThan(CommonConstants.SupportedApiMinVersion.VERSION_12_1)) {
            return -7;
        }
        if (i == 501) {
            infoLog("requestSharedContentDownloadToHiddenFolder is not supported in " + i);
            return -1;
        }
        if (TextUtils.isEmpty(getAppId())) {
            infoLog("app id is empty ");
            return -1;
        }
        IContentDownloadingResultCallback.Stub stub = new IContentDownloadingResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.share.ShareApiImpl.12
            @Override // com.samsung.android.sdk.mobileservice.social.share.IContentDownloadingResultCallback
            public void onFailure(long j, String str2) {
                ShareApiImpl shareApiImpl = ShareApiImpl.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestSharedContentDownload onFailure : code=[", "], message=[", str2);
                sbM2225p.append("] ");
                shareApiImpl.infoLog(sbM2225p.toString());
                if (contentDownloadingResultCallback != null) {
                    contentDownloadingResultCallback.onResult(new ContentDownloadResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), str2, Long.toString(j)), null, null));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.share.IContentDownloadingResultCallback
            public void onProgress(Bundle bundle) {
                ShareApiImpl.this.debugLog("requestSharedContentDownload onProgress ");
                ShareApi.ContentDownloadingResultCallback contentDownloadingResultCallback2 = contentDownloadingResultCallback;
                if (contentDownloadingResultCallback2 != null) {
                    contentDownloadingResultCallback2.onProgress(ShareApiUtil.getInstance(ShareApiImpl.this.getTag(), ShareApiImpl.this.getReference(), ShareApiImpl.this.getAppId()).bundleToDownloadSnapShot(bundle));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.share.IContentDownloadingResultCallback
            public void onSuccess(List<Bundle> list2, List<Bundle> list3) {
                ShareApiImpl.this.infoLog("requestSharedContentDownloadToHiddenFolder onSuccess ");
                if (contentDownloadingResultCallback != null) {
                    if (list2.isEmpty() && list3.isEmpty()) {
                        ShareApiImpl.this.debugLog("requestSharedContentDownloadToHiddenFolder bundle is empty!!");
                        contentDownloadingResultCallback.onResult(new ContentDownloadResult(new CommonResultStatus(1), null, null));
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    Iterator<Bundle> it = list2.iterator();
                    while (it.hasNext()) {
                        arrayList.add(ShareApiUtil.getInstance(ShareApiImpl.this.getTag(), ShareApiImpl.this.getReference(), ShareApiImpl.this.getAppId()).bundleToDownloadContent(it.next()));
                    }
                    Iterator<Bundle> it2 = list3.iterator();
                    while (it2.hasNext()) {
                        arrayList2.add(ShareApiUtil.getInstance(ShareApiImpl.this.getTag(), ShareApiImpl.this.getReference(), ShareApiImpl.this.getAppId()).bundleToDownloadContent(it2.next()));
                    }
                    contentDownloadingResultCallback.onResult(new ContentDownloadResult(new CommonResultStatus(1), arrayList, arrayList2));
                }
            }
        };
        try {
            Bundle bundle = new Bundle();
            bundle.putString("appId", getAppId());
            bundle.putString("spaceId", str);
            bundle.putStringArrayList(BundleKey.itemIdList, new ArrayList<>(list));
            getSocialService().requestOriginalSharedContentsDownloadToHiddenFolder(bundle, stub);
            return 1;
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return -1;
        } catch (NotConnectedException e2) {
            secureLog(e2);
            return -8;
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return -1;
        }
    }

    public int requestSharedItem(String str, String str2, String str3, int i, final ShareApi.SharedItemResultCallback sharedItemResultCallback) {
        infoLog(AbstractC0541b.m775q("requestSpace : spaceId=[", str2, "], itemId=[", str3, "] "));
        if (i == 501) {
            infoLog("requestSharedItem is not supported in " + i);
            return -1;
        }
        if (!isSupportedSemsAgentVersionMoreThan(CommonConstants.SupportedApiMinVersion.VERSION_4_1) || checkInvalidFeatureIdAndAgentVersion(i)) {
            return -7;
        }
        if (TextUtils.isEmpty(getAppId())) {
            infoLog("app id is empty ");
            return -1;
        }
        ISharedItemResultCallback.Stub stub = new ISharedItemResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.share.ShareApiImpl.29
            @Override // com.samsung.android.sdk.mobileservice.social.share.ISharedItemResultCallback
            public void onFailure(long j, String str4) {
                ShareApiImpl shareApiImpl = ShareApiImpl.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestSpace onFailure : code=[", "], message=[", str4);
                sbM2225p.append("] ");
                shareApiImpl.infoLog(sbM2225p.toString());
                if (sharedItemResultCallback != null) {
                    int iConvertErrorcode = ErrorCodeConvertor.convertErrorcode(j);
                    ShareApiImpl.this.debugLog(AbstractC0541b.m773o("requestSpace Error Message [", str4, "]"));
                    sharedItemResultCallback.onResult(new SharedItemResult(new CommonResultStatus(iConvertErrorcode, str4, Long.toString(j)), null));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.share.ISharedItemResultCallback
            public void onSuccess(Bundle bundle) {
                ShareApiImpl.this.infoLog("requestSpace onSuccess ");
                ShareApi.SharedItemResultCallback sharedItemResultCallback2 = sharedItemResultCallback;
                if (sharedItemResultCallback2 != null) {
                    sharedItemResultCallback2.onResult(new SharedItemResult(new CommonResultStatus(1), ShareApiUtil.getInstance(ShareApiImpl.this.getTag(), ShareApiImpl.this.getReference(), ShareApiImpl.this.getAppId()).createSharedItemResult(bundle)));
                }
            }
        };
        try {
            if (TextUtils.isEmpty(str)) {
                getSocialService().requestSharedItem(getAppId(), str2, str3, stub);
                return 1;
            }
            getSocialService().requestSharedItemWithGroupId(getAppId(), str, str2, str3, stub);
            return 1;
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return -1;
        } catch (NotConnectedException e2) {
            secureLog(e2);
            return -8;
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return -1;
        }
    }

    public int requestSharedItemDeletion(String str, List<String> list, String str2, int i, final ShareApi.ShareBaseResultCallback<ItemListResult> shareBaseResultCallback) {
        StringBuilder sbM15l = AbstractC0000a.m15l("requestSharedItemDeletion : spaceId=[", str, "], itemId size=");
        sbM15l.append(list.size());
        infoLog(sbM15l.toString());
        if (checkInvalidFeatureIdAndAgentVersion(i)) {
            return -7;
        }
        if (TextUtils.isEmpty(getAppId())) {
            infoLog("app id is empty ");
            return -1;
        }
        ISharedItemListDeletionResultCallback.Stub stub = new ISharedItemListDeletionResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.share.ShareApiImpl.11
            @Override // com.samsung.android.sdk.mobileservice.social.share.ISharedItemListDeletionResultCallback
            public void onFailure(long j, String str3) {
                ShareApiImpl shareApiImpl = ShareApiImpl.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestSharedItemDeletion onFailure : code=[", "], message=[", str3);
                sbM2225p.append("] ");
                shareApiImpl.infoLog(sbM2225p.toString());
                if (shareBaseResultCallback != null) {
                    shareBaseResultCallback.onResult(new ItemListResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), str3, Long.toString(j)), new ArrayList(), new ArrayList()));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.share.ISharedItemListDeletionResultCallback
            public void onSuccess(List<Bundle> list2) {
                ShareApiImpl.this.infoLog("requestSharedItemDeletion onSuccess ");
                if (shareBaseResultCallback != null) {
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    for (Bundle bundle : list2) {
                        String string = bundle.getString("space_id");
                        String string2 = bundle.getString("item_id");
                        if (bundle.getBoolean("result")) {
                            arrayList.add(new ItemListResult.SharedItemListSuccessResult(string, string2));
                        } else {
                            arrayList2.add(new ItemListResult.SharedItemListFailureResult(string, string2, Long.valueOf(bundle.getLong("error_code"))));
                        }
                    }
                    shareBaseResultCallback.onResult(new ItemListResult(new CommonResultStatus(1), arrayList, arrayList2));
                }
            }
        };
        try {
            if (i == 501) {
                Bundle bundle = new Bundle();
                bundle.putInt("featureId", i);
                getSocialService().requestSharedItemListDeletionWithData(getAppId(), str, list, bundle, stub);
                return 1;
            }
            if (TextUtils.isEmpty(str2)) {
                getSocialService().requestSharedItemListDeletion(getAppId(), str, list, stub);
                return 1;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString(BundleKey.EXTRA_CID, str2);
            getSocialService().requestSharedItemListDeletionWithData(getAppId(), str, list, bundle2, stub);
            return 1;
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return -1;
        } catch (NotConnectedException e2) {
            secureLog(e2);
            return -8;
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return -1;
        }
    }

    public int requestSharedItemList(String str, String str2, String str3, String str4, int i, final ShareApi.SharedItemListWithContentListResultCallback sharedItemListWithContentListResultCallback) {
        StringBuilder sbM16m = AbstractC0000a.m16m("requestSharedItemList : groupId=[", str, "], spaceId=[", str2, "], resolution=[");
        sbM16m.append(str3);
        sbM16m.append("] ");
        infoLog(sbM16m.toString());
        if (!isSupportedSemsAgentVersionMoreThan(CommonConstants.SupportedApiMinVersion.VERSION_4_1) || checkInvalidFeatureIdAndAgentVersion(i)) {
            return -7;
        }
        if (TextUtils.isEmpty(getAppId())) {
            infoLog("app id is empty ");
            return -1;
        }
        ISharedItemListResultCallback.Stub stub = new ISharedItemListResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.share.ShareApiImpl.27
            @Override // com.samsung.android.sdk.mobileservice.social.share.ISharedItemListResultCallback
            public void onFailure(long j, String str5) {
                ShareApiImpl shareApiImpl = ShareApiImpl.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestSpace onFailure : code=[", "], message=[", str5);
                sbM2225p.append("] ");
                shareApiImpl.infoLog(sbM2225p.toString());
                if (sharedItemListWithContentListResultCallback != null) {
                    int iConvertErrorcode = ErrorCodeConvertor.convertErrorcode(j);
                    ShareApiImpl.this.debugLog(AbstractC0541b.m773o("requestSpace Error Message [", str5, "]"));
                    sharedItemListWithContentListResultCallback.onResult(new SharedItemListWithContentListResult(new CommonResultStatus(iConvertErrorcode, str5, Long.toString(j)), null));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.share.ISharedItemListResultCallback
            public void onSuccess(List<Bundle> list) {
                ShareApiImpl.this.infoLog("requestSharedItemList(with content list) onSuccess");
                if (sharedItemListWithContentListResultCallback != null) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<Bundle> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new SharedItemWithUriList(it.next()));
                    }
                    sharedItemListWithContentListResultCallback.onResult(new SharedItemListWithContentListResult(new CommonResultStatus(1), arrayList));
                }
            }
        };
        try {
            if (i == 501) {
                Bundle bundle = new Bundle();
                bundle.putInt("featureId", i);
                getSocialService().requestSharedItemListWithFileListWithData(getAppId(), str, str2, str3, bundle, stub);
                return 1;
            }
            if (TextUtils.isEmpty(str4)) {
                getSocialService().requestSharedItemListWithFileList(getAppId(), str, str2, str3, stub);
                return 1;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString(BundleKey.EXTRA_CID, str4);
            getSocialService().requestSharedItemListWithFileListWithData(getAppId(), str, str2, str3, bundle2, stub);
            return 1;
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return -1;
        } catch (NotConnectedException e2) {
            secureLog(e2);
            return -8;
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return -1;
        }
    }

    public int requestSharedItemListInTrashBin(String str, String str2, String str3, String str4, int i, final ShareApi.ShareBaseResultCallback<TrashedItemListResult> shareBaseResultCallback) {
        StringBuilder sbM16m = AbstractC0000a.m16m("requestSharedItemListInTrashBin : groupId=[", str, "], spaceId=[", str2, "], resolution=[");
        sbM16m.append(str4);
        sbM16m.append("] ");
        infoLog(sbM16m.toString());
        if (!isSupportedSemsAgentVersionMoreThan(CommonConstants.SupportedApiMinVersion.VERSION_13_1_10)) {
            return -1;
        }
        if (TextUtils.isEmpty(getAppId())) {
            infoLog("app id is empty ");
            return -1;
        }
        ISharedItemListResultCallback.Stub stub = new ISharedItemListResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.share.ShareApiImpl.35
            @Override // com.samsung.android.sdk.mobileservice.social.share.ISharedItemListResultCallback
            public void onFailure(long j, String str5) {
                ShareApiImpl shareApiImpl = ShareApiImpl.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestSharedItemListInTrashBin onFailure : code=[", "], message=[", str5);
                sbM2225p.append("] ");
                shareApiImpl.infoLog(sbM2225p.toString());
                if (shareBaseResultCallback != null) {
                    shareBaseResultCallback.onResult(new TrashedItemListResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), str5, Long.toString(j)), new ArrayList(), new ArrayList()));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.share.ISharedItemListResultCallback
            public void onSuccess(List<Bundle> list) {
                ShareApiImpl.this.infoLog("requestSharedItemListInTrashBin onSuccess ");
                if (shareBaseResultCallback != null) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<Bundle> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(ShareApiUtil.getInstance(ShareApiImpl.this.getTag(), ShareApiImpl.this.getReference(), ShareApiImpl.this.getAppId()).createTrashedItemResult(it.next()));
                    }
                    shareBaseResultCallback.onResult(new TrashedItemListResult(new CommonResultStatus(1), arrayList, null));
                }
            }
        };
        try {
            Bundle bundle = new Bundle();
            bundle.putString("appId", getAppId());
            if (i != -1) {
                bundle.putInt("featureId", i);
            }
            if (!TextUtils.isEmpty(str3)) {
                bundle.putString(BundleKey.EXTRA_CID, str3);
            }
            bundle.putString("groupId", str);
            bundle.putString("spaceId", str2);
            if (str4 != null) {
                bundle.putString(BundleKey.THUMBNAIL_RESOLUTION, str4);
            }
            getSocialService().requestSharedItemListInTrashBinWithData(bundle, stub);
            return 1;
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return -1;
        } catch (NotConnectedException e2) {
            secureLog(e2);
            return -8;
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return -1;
        }
    }

    public int requestSharedItemSync(String str, String str2, String str3, int i, final ShareApi.SharedItemSyncResultCallback sharedItemSyncResultCallback) {
        infoLog("requestSharedItemSync : spaceId=[" + str + "] ");
        if (!isSupportedSemsAgentVersionMoreThan(CommonConstants.SupportedApiMinVersion.VERSION_10_1) || checkInvalidFeatureIdAndAgentVersion(i)) {
            return -7;
        }
        if (TextUtils.isEmpty(getAppId())) {
            infoLog("app id is empty ");
            return -1;
        }
        IShareSyncResultCallback.Stub stub = new IShareSyncResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.share.ShareApiImpl.10
            @Override // com.samsung.android.sdk.mobileservice.social.share.IShareSyncResultCallback
            public void onFailure(long j, String str4) {
                ShareApiImpl shareApiImpl = ShareApiImpl.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestSharedItemSync onFailure : code=[", "], message=[", str4);
                sbM2225p.append("] ");
                shareApiImpl.infoLog(sbM2225p.toString());
                if (sharedItemSyncResultCallback != null) {
                    sharedItemSyncResultCallback.onResult(new BooleanResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), str4, Long.toString(j)), false));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.share.IShareSyncResultCallback
            public void onSuccess() {
                ShareApiImpl.this.infoLog("requestSharedItemSync onSuccess ");
                ShareApi.SharedItemSyncResultCallback sharedItemSyncResultCallback2 = sharedItemSyncResultCallback;
                if (sharedItemSyncResultCallback2 != null) {
                    sharedItemSyncResultCallback2.onResult(new BooleanResult(new CommonResultStatus(1), true));
                }
            }
        };
        Bundle bundle = new Bundle();
        bundle.putString("space_id", str);
        bundle.putString(BundleKey.THUMBNAIL_RESOLUTION, str2);
        try {
            if (i == 501) {
                Bundle bundle2 = new Bundle();
                bundle2.putInt("featureId", i);
                getSocialService().requestSharedItemSyncWithResolutionWithData(getAppId(), bundle, bundle2, stub);
                return 1;
            }
            if (TextUtils.isEmpty(str3)) {
                getSocialService().requestSharedItemSyncWithResolution(getAppId(), bundle, stub);
                return 1;
            }
            Bundle bundle3 = new Bundle();
            bundle3.putString(BundleKey.EXTRA_CID, str3);
            getSocialService().requestSharedItemSyncWithResolutionWithData(getAppId(), bundle, bundle3, stub);
            return 1;
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return -1;
        } catch (NotConnectedException e2) {
            secureLog(e2);
            return -8;
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return -1;
        }
    }

    public ShareController requestSharedItemUpdate(String str, String str2, ShareApi.SharedItemWithUriListRequest sharedItemWithUriListRequest, int i, final ShareApi.SharedItemWithContentListResultCallback sharedItemWithContentListResultCallback, PendingIntent pendingIntent, Bundle bundle) {
        infoLog("requestSpace : spaceId=[" + str + "] ");
        if (i == 501) {
            infoLog("requestSharedItemUpdate is not supported in " + i);
            return null;
        }
        if (TextUtils.isEmpty(getAppId())) {
            infoLog("app id is empty ");
            return null;
        }
        try {
            return new ShareController(this.mApiPicker, getSocialService().requestShareUpdateWithUriList(getAppId(), str, str2, ShareApiUtil.getInstance(getTag(), getReference(), getAppId()).requestToBundle(sharedItemWithUriListRequest), new IShareResultWithFileListCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.share.ShareApiImpl.24
                @Override // com.samsung.android.sdk.mobileservice.social.share.IShareResultWithFileListCallback
                public void onFailure(long j, String str3) {
                    ShareApiImpl shareApiImpl = ShareApiImpl.this;
                    StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestSpace onFailure : code=[", "], message=[", str3);
                    sbM2225p.append("] ");
                    shareApiImpl.infoLog(sbM2225p.toString());
                    if (sharedItemWithContentListResultCallback != null) {
                        int iConvertErrorcode = ErrorCodeConvertor.convertErrorcode(j);
                        ShareApiImpl.this.debugLog(AbstractC0541b.m773o("requestSpace Error Message [", str3, "]"));
                        sharedItemWithContentListResultCallback.onResult(new SharedItemWithUriListResult(new CommonResultStatus(iConvertErrorcode, str3, Long.toString(j)), null));
                    }
                }

                @Override // com.samsung.android.sdk.mobileservice.social.share.IShareResultWithFileListCallback
                public void onProgress(Bundle bundle2) {
                    ShareApiImpl.this.debugLog("requestShare onProgress ");
                    ShareApi.SharedItemWithContentListResultCallback sharedItemWithContentListResultCallback2 = sharedItemWithContentListResultCallback;
                    if (sharedItemWithContentListResultCallback2 != null) {
                        sharedItemWithContentListResultCallback2.onProgress(ShareApiUtil.getInstance(ShareApiImpl.this.getTag(), ShareApiImpl.this.getReference(), ShareApiImpl.this.getAppId()).bundleToShareSnapShot(bundle2));
                    }
                }

                @Override // com.samsung.android.sdk.mobileservice.social.share.IShareResultWithFileListCallback
                public void onSuccess(Bundle bundle2) {
                    ShareApiImpl.this.infoLog("requestSpace onSuccess ");
                    ShareApi.SharedItemWithContentListResultCallback sharedItemWithContentListResultCallback2 = sharedItemWithContentListResultCallback;
                    if (sharedItemWithContentListResultCallback2 != null) {
                        sharedItemWithContentListResultCallback2.onResult(new SharedItemWithUriListResult(new CommonResultStatus(1), new SharedItemWithUriList(bundle2)));
                    }
                }

                @Override // com.samsung.android.sdk.mobileservice.social.share.IShareResultWithFileListCallback
                public void onUploadComplete(Bundle bundle2) {
                    ShareApiImpl.this.debugLog("requestShare onUploadComplete ");
                    ShareApi.SharedItemWithContentListResultCallback sharedItemWithContentListResultCallback2 = sharedItemWithContentListResultCallback;
                    if (sharedItemWithContentListResultCallback2 != null) {
                        sharedItemWithContentListResultCallback2.onUploadComplete(ShareApiUtil.getInstance(ShareApiImpl.this.getTag(), ShareApiImpl.this.getReference(), ShareApiImpl.this.getAppId()).bundleToShareSnapShot(bundle2));
                    }
                }
            }, pendingIntent, bundle));
        } catch (RemoteException | NotConnectedException | NullPointerException e) {
            secureLog(e);
            return null;
        }
    }

    public ShareController requestSharedItemWithUriListUpdate(String str, List<ShareApi.SharedItemUpdateWithUriListRequest> list, String str2, int i, final ShareApi.ShareUploadResultCallback<SharedItemListWithUriListResult> shareUploadResultCallback, PendingIntent pendingIntent, Bundle bundle) {
        String strRequestShareListUpdateWithItemFileList;
        infoLog("requestSpace : spaceId=[" + str + "] ");
        if (checkInvalidFeatureIdAndAgentVersion(i)) {
            return null;
        }
        if (TextUtils.isEmpty(getAppId())) {
            infoLog("app id is empty ");
            return null;
        }
        IShareResultCallback.Stub stub = new IShareResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.share.ShareApiImpl.15
            @Override // com.samsung.android.sdk.mobileservice.social.share.IShareResultCallback
            public void onFailure(long j, String str3) {
                ShareApiImpl shareApiImpl = ShareApiImpl.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestSharedItemUpdate onFailure : code=[", "], message=[", str3);
                sbM2225p.append("] ");
                shareApiImpl.infoLog(sbM2225p.toString());
                if (shareUploadResultCallback != null) {
                    int iConvertErrorcode = ErrorCodeConvertor.convertErrorcode(j);
                    ShareApiImpl.this.debugLog(AbstractC0541b.m773o("requestSharedItemUpdate Error Message [", str3, "]"));
                    shareUploadResultCallback.onResult(new SharedItemListWithUriListResult(new CommonResultStatus(iConvertErrorcode, str3, Long.toString(j)), null, null));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.share.IShareResultCallback
            public void onProgress(Bundle bundle2) {
                ShareApiImpl.this.debugLog("requestSharedItemUpdate onProgress ");
                ShareApi.ShareUploadResultCallback shareUploadResultCallback2 = shareUploadResultCallback;
                if (shareUploadResultCallback2 != null) {
                    shareUploadResultCallback2.onProgress(ShareApiUtil.getInstance(ShareApiImpl.this.getTag(), ShareApiImpl.this.getReference(), ShareApiImpl.this.getAppId()).bundleToShareSnapShot(bundle2));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.share.IShareResultCallback
            public void onSuccess(List<Bundle> list2, List<Bundle> list3) {
                ShareApiImpl.this.infoLog("requestSharedItemUpdate onSuccess ");
                if (shareUploadResultCallback != null) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<Bundle> it = list2.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new SharedItemWithUriList(it.next()));
                    }
                    ArrayList arrayList2 = new ArrayList();
                    Iterator<Bundle> it2 = list3.iterator();
                    while (it2.hasNext()) {
                        arrayList2.add(ShareApiUtil.getInstance(ShareApiImpl.this.getTag(), ShareApiImpl.this.getReference(), ShareApiImpl.this.getAppId()).createShareFailedItemWithUriListResult(it2.next()));
                    }
                    shareUploadResultCallback.onResult(new SharedItemListWithUriListResult(new CommonResultStatus(1), arrayList, arrayList2));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.share.IShareResultCallback
            public void onUploadComplete(Bundle bundle2) {
                ShareApiImpl.this.debugLog("requestSharedItemUpdate onUploadComplete ");
                ShareApi.ShareUploadResultCallback shareUploadResultCallback2 = shareUploadResultCallback;
                if (shareUploadResultCallback2 != null) {
                    shareUploadResultCallback2.onUploadComplete(ShareApiUtil.getInstance(ShareApiImpl.this.getTag(), ShareApiImpl.this.getReference(), ShareApiImpl.this.getAppId()).bundleToShareSnapShot(bundle2));
                }
            }
        };
        ArrayList arrayList = new ArrayList();
        Iterator<ShareApi.SharedItemUpdateWithUriListRequest> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(ShareApiUtil.getInstance(getTag(), getReference(), getAppId()).requestToBundle(it.next()));
        }
        try {
            if (i == 501) {
                Bundle bundle2 = new Bundle();
                bundle2.putInt("featureId", i);
                strRequestShareListUpdateWithItemFileList = getSocialService().requestShareListUpdateWithItemFileListWithData(getAppId(), str, arrayList, bundle2, stub, pendingIntent, bundle);
            } else if (TextUtils.isEmpty(str2)) {
                strRequestShareListUpdateWithItemFileList = getSocialService().requestShareListUpdateWithItemFileList(getAppId(), str, arrayList, stub, pendingIntent, bundle);
            } else {
                Bundle bundle3 = new Bundle();
                bundle3.putString(BundleKey.EXTRA_CID, str2);
                strRequestShareListUpdateWithItemFileList = getSocialService().requestShareListUpdateWithItemFileListWithData(getAppId(), str, arrayList, bundle3, stub, pendingIntent, bundle);
            }
            return new ShareController(this.mApiPicker, strRequestShareListUpdateWithItemFileList);
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return null;
        } catch (NotConnectedException e2) {
            e = e2;
            secureLog(e);
            return null;
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return null;
        }
    }

    public int requestSpace(String str, String str2, int i, final ShareApi.SpaceResultCallback spaceResultCallback) {
        infoLog("requestSpace : spaceId=[" + str + "] ");
        if (!isSupportedSemsAgentVersionMoreThan(CommonConstants.SupportedApiMinVersion.VERSION_4_1) || checkInvalidFeatureIdAndAgentVersion(i)) {
            return -7;
        }
        if (TextUtils.isEmpty(getAppId())) {
            infoLog("app id is empty ");
            return -1;
        }
        ISpaceResultCallback.Stub stub = new ISpaceResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.share.ShareApiImpl.5
            @Override // com.samsung.android.sdk.mobileservice.social.share.ISpaceResultCallback
            public void onFailure(long j, String str3) {
                ShareApiImpl shareApiImpl = ShareApiImpl.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestSpace onFailure : code=[", "], message=[", str3);
                sbM2225p.append("] ");
                shareApiImpl.infoLog(sbM2225p.toString());
                if (spaceResultCallback != null) {
                    int iConvertErrorcode = ErrorCodeConvertor.convertErrorcode(j);
                    ShareApiImpl.this.debugLog(AbstractC0541b.m773o("requestSpace Error Message [", str3, "]"));
                    spaceResultCallback.onResult(new SpaceResult(new CommonResultStatus(iConvertErrorcode, str3, Long.toString(j)), null));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.share.ISpaceResultCallback
            public void onSuccess(Bundle bundle) {
                ShareApiImpl.this.infoLog("requestSpace onSuccess ");
                ShareApi.SpaceResultCallback spaceResultCallback2 = spaceResultCallback;
                if (spaceResultCallback2 != null) {
                    spaceResultCallback2.onResult(new SpaceResult(new CommonResultStatus(1), ShareApiUtil.getInstance(ShareApiImpl.this.getTag(), ShareApiImpl.this.getReference(), ShareApiImpl.this.getAppId()).createSpaceResult(bundle)));
                }
            }
        };
        try {
            if (i == 501) {
                Bundle bundle = new Bundle();
                bundle.putInt("featureId", i);
                getSocialService().requestSpaceWithData(getAppId(), str, bundle, stub);
                return 1;
            }
            if (TextUtils.isEmpty(str2)) {
                getSocialService().requestSpace(getAppId(), str, stub);
                return 1;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString(BundleKey.EXTRA_CID, str2);
            getSocialService().requestSpaceWithData(getAppId(), str, bundle2, stub);
            return 1;
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return -1;
        } catch (NotConnectedException e2) {
            secureLog(e2);
            return -8;
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return -1;
        }
    }

    public int requestSpaceCoverImageDownload(String str, int i, final ShareApi.ImageDownloadingResultCallback imageDownloadingResultCallback) {
        infoLog("requestOriginalSpaceImageDownload spaceId=[" + str + "] ");
        if (checkInvalidFeatureIdAndAgentVersion(i)) {
            return -7;
        }
        if (TextUtils.isEmpty(getAppId())) {
            infoLog("app id is empty ");
            return -1;
        }
        try {
            getSocialService().requestOriginalSpaceImageDownload(getAppId(), str, new ISpaceCoverImageDownloadingResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.share.ShareApiImpl.21
                @Override // com.samsung.android.sdk.mobileservice.social.share.ISpaceCoverImageDownloadingResultCallback
                public void onFailure(long j, String str2) {
                    ShareApiImpl shareApiImpl = ShareApiImpl.this;
                    StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestOriginalSpaceImageDownload onFailure : code=[", "], message=[", str2);
                    sbM2225p.append("] ");
                    shareApiImpl.infoLog(sbM2225p.toString());
                    if (imageDownloadingResultCallback != null) {
                        imageDownloadingResultCallback.onResult(new SpaceImageDownloadResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), str2, Long.toString(j)), null));
                    }
                }

                @Override // com.samsung.android.sdk.mobileservice.social.share.ISpaceCoverImageDownloadingResultCallback
                public void onSuccess(Bundle bundle) {
                    ShareApiImpl.this.infoLog("requestOriginalSpaceImageDownload onSuccess ");
                    if (imageDownloadingResultCallback != null) {
                        String string = bundle.getString("space_id", null);
                        String string2 = bundle.getString(BundleKey.DOWNLOADED_URI, null);
                        SpaceImageDownloadResult.DownloadedImage downloadedImage = new SpaceImageDownloadResult.DownloadedImage(string, string2 != null ? Uri.parse(string2) : null);
                        ShareApiImpl.this.debugLog(AbstractC0541b.m775q("- space_id=[", string, "], downloaded_uri=[", string2, "] "));
                        imageDownloadingResultCallback.onResult(new SpaceImageDownloadResult(new CommonResultStatus(1), downloadedImage));
                    }
                }
            });
            return 1;
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return -1;
        } catch (NotConnectedException e2) {
            secureLog(e2);
            return -8;
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return -1;
        }
    }

    public int requestSpaceCreation(String str, ShareApi.SpaceRequest spaceRequest, String str2, int i, final ShareApi.SpaceResultCallback spaceResultCallback) {
        if (checkInvalidFeatureIdAndAgentVersion(i)) {
            return -7;
        }
        if (TextUtils.isEmpty(getAppId())) {
            infoLog("app id is empty ");
            return -1;
        }
        ISpaceResultCallback.Stub stub = new ISpaceResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.share.ShareApiImpl.3
            @Override // com.samsung.android.sdk.mobileservice.social.share.ISpaceResultCallback
            public void onFailure(long j, String str3) {
                ShareApiImpl shareApiImpl = ShareApiImpl.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestSpaceCreation onFailure : code=[", "], message=[", str3);
                sbM2225p.append("] ");
                shareApiImpl.infoLog(sbM2225p.toString());
                if (spaceResultCallback != null) {
                    spaceResultCallback.onResult(new SpaceResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), str3, Long.toString(j)), null));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.share.ISpaceResultCallback
            public void onSuccess(Bundle bundle) {
                ShareApiImpl.this.infoLog("requestSpaceCreation onSuccess ");
                ShareApi.SpaceResultCallback spaceResultCallback2 = spaceResultCallback;
                if (spaceResultCallback2 != null) {
                    spaceResultCallback2.onResult(new SpaceResult(new CommonResultStatus(1), ShareApiUtil.getInstance(ShareApiImpl.this.getTag(), ShareApiImpl.this.getReference(), ShareApiImpl.this.getAppId()).createSpaceResult(bundle)));
                }
            }
        };
        try {
            Bundle bundleRequestToBundle = ShareApiUtil.getInstance(getTag(), getReference(), getAppId()).requestToBundle(spaceRequest, str);
            if (i == 501) {
                Bundle bundle = new Bundle();
                bundle.putInt("featureId", i);
                getSocialService().requestSpaceCreationWithData(getAppId(), str, bundleRequestToBundle, bundle, stub);
                return 1;
            }
            if (TextUtils.isEmpty(str2)) {
                getSocialService().requestSpaceCreation(getAppId(), str, bundleRequestToBundle, stub);
                return 1;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString(BundleKey.EXTRA_CID, str2);
            getSocialService().requestSpaceCreationWithData(getAppId(), str, bundleRequestToBundle, bundle2, stub);
            return 1;
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return -1;
        } catch (NotConnectedException e2) {
            secureLog(e2);
            return -8;
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return -1;
        }
    }

    public int requestSpaceDeletion(String str, String str2, int i, final ShareApi.SpaceDeletionResultCallback spaceDeletionResultCallback) {
        infoLog("requestSpaceDeletion : spaceId=[" + str + "] ");
        if (!isSupportedSemsAgentVersionMoreThan(CommonConstants.SupportedApiMinVersion.VERSION_4_1) || checkInvalidFeatureIdAndAgentVersion(i)) {
            return -7;
        }
        if (TextUtils.isEmpty(getAppId())) {
            infoLog("app id is empty ");
            return -1;
        }
        ISpaceDeletionResultCallback.Stub stub = new ISpaceDeletionResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.share.ShareApiImpl.7
            @Override // com.samsung.android.sdk.mobileservice.social.share.ISpaceDeletionResultCallback
            public void onFailure(long j, String str3) {
                ShareApiImpl shareApiImpl = ShareApiImpl.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestSpaceDeletion onFailure : code=[", "], message=[", str3);
                sbM2225p.append("] ");
                shareApiImpl.infoLog(sbM2225p.toString());
                if (spaceDeletionResultCallback != null) {
                    spaceDeletionResultCallback.onResult(new BooleanResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), str3, Long.toString(j)), false));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.share.ISpaceDeletionResultCallback
            public void onSuccess() {
                ShareApiImpl.this.infoLog("requestSpaceDeletion onSuccess ");
                ShareApi.SpaceDeletionResultCallback spaceDeletionResultCallback2 = spaceDeletionResultCallback;
                if (spaceDeletionResultCallback2 != null) {
                    spaceDeletionResultCallback2.onResult(new BooleanResult(new CommonResultStatus(1), true));
                }
            }
        };
        try {
            if (i == 501) {
                Bundle bundle = new Bundle();
                bundle.putInt("featureId", i);
                getSocialService().requestSpaceDeletionWithData(getAppId(), str, bundle, stub);
                return 1;
            }
            if (TextUtils.isEmpty(str2)) {
                getSocialService().requestSpaceDeletion(getAppId(), str, stub);
                return 1;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString(BundleKey.EXTRA_CID, str2);
            getSocialService().requestSpaceDeletionWithData(getAppId(), str, bundle2, stub);
            return 1;
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return -1;
        } catch (NotConnectedException e2) {
            secureLog(e2);
            return -8;
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return -1;
        }
    }

    public int requestSpaceList(String str, String str2, int i, final ShareApi.SpaceListResultCallback spaceListResultCallback) {
        infoLog("requestSpaceList : groupId=[" + str + "] ");
        if (!isSupportedSemsAgentVersionMoreThan(CommonConstants.SupportedApiMinVersion.VERSION_4_1) || checkInvalidFeatureIdAndAgentVersion(i)) {
            return -7;
        }
        if (TextUtils.isEmpty(getAppId())) {
            infoLog("app id is empty ");
            return -1;
        }
        ISpaceListResultCallback.Stub stub = new ISpaceListResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.share.ShareApiImpl.4
            @Override // com.samsung.android.sdk.mobileservice.social.share.ISpaceListResultCallback
            public void onFailure(long j, String str3) {
                ShareApiImpl shareApiImpl = ShareApiImpl.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestSpaceList onFailure : code=[", "], message=[", str3);
                sbM2225p.append("] ");
                shareApiImpl.infoLog(sbM2225p.toString());
                if (spaceListResultCallback != null) {
                    spaceListResultCallback.onResult(new SpaceListResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), str3, Long.toString(j)), null));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.share.ISpaceListResultCallback
            public void onSuccess(List<Bundle> list) {
                ShareApiImpl.this.infoLog("requestSpaceList onSuccess ");
                if (spaceListResultCallback != null) {
                    ArrayList arrayList = new ArrayList();
                    for (Bundle bundle : list) {
                        String string = bundle.getString("space_id");
                        String string2 = bundle.getString("group_id");
                        String string3 = bundle.getString(BundleKey.OWNER_ID);
                        ShareApiImpl.this.debugLog(AbstractC0622a.m1170p(string3, "] ", AbstractC0000a.m16m("- groupId=[", string2, "], spaceId=[", string, "], ownerId=[")));
                        if (string == null || string2 == null || string3 == null) {
                            ShareApiImpl.this.debugLog("requestSpaceList is error (one of spaceId, ownerId and groupId is erro)");
                            spaceListResultCallback.onResult(new SpaceListResult(new CommonResultStatus(-1, "Invalid space information", ""), null));
                            return;
                        }
                        arrayList.add(ShareApiUtil.getInstance(ShareApiImpl.this.getTag(), ShareApiImpl.this.getReference(), ShareApiImpl.this.getAppId()).createSpaceResult(bundle));
                    }
                    spaceListResultCallback.onResult(new SpaceListResult(new CommonResultStatus(1), arrayList));
                }
            }
        };
        try {
            if (i == 501) {
                Bundle bundle = new Bundle();
                bundle.putInt("featureId", i);
                getSocialService().requestSpaceListWithData(getAppId(), str, bundle, stub);
                return 1;
            }
            if (TextUtils.isEmpty(str2)) {
                getSocialService().requestSpaceList(getAppId(), str, stub);
                return 1;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString(BundleKey.EXTRA_CID, str2);
            getSocialService().requestSpaceListWithData(getAppId(), str, bundle2, stub);
            return 1;
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return -1;
        } catch (NotConnectedException e2) {
            secureLog(e2);
            return -8;
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return -1;
        }
    }

    public int requestSpaceListSync(String str, int i, final ShareApi.SpaceListSyncResultCallback spaceListSyncResultCallback) {
        infoLog("requestSpaceListSync ");
        if (!isSupportedSemsAgentVersionMoreThan(CommonConstants.SupportedApiMinVersion.VERSION_4_1) || checkInvalidFeatureIdAndAgentVersion(i)) {
            return -7;
        }
        if (TextUtils.isEmpty(getAppId())) {
            infoLog("app id is empty ");
            return -1;
        }
        IShareSyncResultCallback.Stub stub = new IShareSyncResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.share.ShareApiImpl.9
            @Override // com.samsung.android.sdk.mobileservice.social.share.IShareSyncResultCallback
            public void onFailure(long j, String str2) {
                ShareApiImpl shareApiImpl = ShareApiImpl.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestSpaceListSync onFailure : code=[", "], message=[", str2);
                sbM2225p.append("] ");
                shareApiImpl.infoLog(sbM2225p.toString());
                if (spaceListSyncResultCallback != null) {
                    spaceListSyncResultCallback.onResult(new BooleanResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), str2, Long.toString(j)), false));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.share.IShareSyncResultCallback
            public void onSuccess() {
                ShareApiImpl.this.infoLog("requestSpaceListSync onSuccess ");
                ShareApi.SpaceListSyncResultCallback spaceListSyncResultCallback2 = spaceListSyncResultCallback;
                if (spaceListSyncResultCallback2 != null) {
                    spaceListSyncResultCallback2.onResult(new BooleanResult(new CommonResultStatus(1), true));
                }
            }
        };
        try {
            if (i == 501) {
                Bundle bundle = new Bundle();
                bundle.putInt("featureId", i);
                getSocialService().requestSpaceListSyncWithData(getAppId(), bundle, stub);
                return 1;
            }
            if (TextUtils.isEmpty(str)) {
                getSocialService().requestSpaceListSync(getAppId(), stub);
                return 1;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString(BundleKey.EXTRA_CID, str);
            getSocialService().requestSpaceListSyncWithData(getAppId(), bundle2, stub);
            return 1;
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return -1;
        } catch (NotConnectedException e2) {
            secureLog(e2);
            return -8;
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return -1;
        }
    }

    public int requestSpaceUpdate(String str, boolean z, String str2, int i, ShareApi.SpaceResultCallback spaceResultCallback) {
        if (i == 501) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(BundleKey.IS_STANDALONE, z);
            return requestSpaceUpdate(str, bundle, str2, i, spaceResultCallback);
        }
        infoLog("requestSpaceUpdate with isStandAlone is not supported in " + i);
        return -1;
    }

    public int requestSync(String str, int i, ShareApi.ShareSyncResultCallback shareSyncResultCallback) {
        infoLog("requestSync ");
        if (!isSupportedSemsAgentVersionMoreThan(CommonConstants.SupportedApiMinVersion.VERSION_4_1) || checkInvalidFeatureIdAndAgentVersion(i)) {
            return -7;
        }
        if (TextUtils.isEmpty(getAppId())) {
            infoLog("app id is empty ");
            return -1;
        }
        try {
            if (i == 501) {
                Bundle bundle = new Bundle();
                bundle.putInt("featureId", i);
                getSocialService().requestShareSyncWithData(getAppId(), bundle, createShareSyncCallback(shareSyncResultCallback));
                return 1;
            }
            if (TextUtils.isEmpty(str)) {
                getSocialService().requestShareSync(getAppId(), createShareSyncCallback(shareSyncResultCallback));
                return 1;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString(BundleKey.EXTRA_CID, str);
            getSocialService().requestShareSyncWithData(getAppId(), bundle2, createShareSyncCallback(shareSyncResultCallback));
            return 1;
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return -1;
        } catch (NotConnectedException e2) {
            secureLog(e2);
            return -8;
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return -1;
        }
    }

    public int requestThumbnailDownload(String str, String str2, String str3, String str4, String str5, int i, ShareApi.ShareBaseResultCallback<DownloadImageResult> shareBaseResultCallback) {
        StringBuilder sbM16m = AbstractC0000a.m16m("requestThumbnailDownload. groupId=[", str, "] spaceId=[", str2, "] itemId=[");
        sbM16m.append(str3);
        sbM16m.append("] ");
        infoLog(sbM16m.toString());
        if (!isSupportedSemsAgentVersionMoreThan(CommonConstants.SupportedApiMinVersion.VERSION_11_2) || isNoMoreSupportedSemsAgentVersion(CommonConstants.SupportedApiMinVersion.VERSION_12_1)) {
            return -7;
        }
        if (i != 501) {
            return downloadThumbnail(str, str2, str3, str4, str5, shareBaseResultCallback);
        }
        infoLog("requestItemThumbnailDownload is not supported in " + i);
        return -1;
    }

    public int requestWebLinkEnabled(String str, String str2, boolean z, int i, final ShareApi.ShareBaseResultCallback<SpaceResult> shareBaseResultCallback) {
        if (!isSupportedSemsAgentVersionMoreThan(CommonConstants.SupportedApiMinVersion.VERSION_13_0_1) || checkInvalidFeatureIdAndAgentVersion(i)) {
            return -7;
        }
        if (TextUtils.isEmpty(getAppId())) {
            infoLog("app id is empty ");
            return -1;
        }
        IBundleResultCallback.Stub stub = new IBundleResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.share.ShareApiImpl.30
            @Override // com.samsung.android.sdk.mobileservice.social.common.IBundleResultCallback
            public void onFailure(long j, String str3) {
                ShareApiImpl shareApiImpl = ShareApiImpl.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestWebLinkEnabled onFailure : code=[", "], message=[", str3);
                sbM2225p.append("] ");
                shareApiImpl.infoLog(sbM2225p.toString());
                if (shareBaseResultCallback != null) {
                    shareBaseResultCallback.onResult(new SpaceResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), str3, Long.toString(j)), null));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.common.IBundleResultCallback
            public void onSuccess(Bundle bundle) {
                ShareApiImpl.this.infoLog("requestWebLinkEnabled onSuccess ");
                ShareApi.ShareBaseResultCallback shareBaseResultCallback2 = shareBaseResultCallback;
                if (shareBaseResultCallback2 != null) {
                    shareBaseResultCallback2.onResult(new SpaceResult(new CommonResultStatus(1), ShareApiUtil.getInstance(ShareApiImpl.this.getTag(), ShareApiImpl.this.getReference(), ShareApiImpl.this.getAppId()).createSpaceResult(bundle)));
                }
            }
        };
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("featureId", i);
            bundle.putString("appId", getAppId());
            bundle.putString("groupId", str);
            bundle.putString("spaceId", str2);
            getSocialService().requestWebLinkEnabled(bundle, z, stub);
            return 1;
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return -1;
        } catch (NotConnectedException e2) {
            secureLog(e2);
            return -8;
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return -1;
        }
    }

    public int requestSpaceUpdate(String str, Bundle bundle, String str2, int i, final ShareApi.SpaceResultCallback spaceResultCallback) {
        infoLog("requestSpaceUpdate : spaceId=[" + str + "] ");
        if (!isSupportedSemsAgentVersionMoreThan(CommonConstants.SupportedApiMinVersion.VERSION_4_1) || checkInvalidFeatureIdAndAgentVersion(i)) {
            return -7;
        }
        if (TextUtils.isEmpty(getAppId())) {
            infoLog("app id is empty ");
            return -1;
        }
        ISpaceResultCallback.Stub stub = new ISpaceResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.share.ShareApiImpl.6
            @Override // com.samsung.android.sdk.mobileservice.social.share.ISpaceResultCallback
            public void onFailure(long j, String str3) {
                ShareApiImpl shareApiImpl = ShareApiImpl.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestSpaceUpdate onFailure : code=[", "], message=[", str3);
                sbM2225p.append("] ");
                shareApiImpl.infoLog(sbM2225p.toString());
                if (spaceResultCallback != null) {
                    spaceResultCallback.onResult(new SpaceResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), str3, Long.toString(j)), null));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.share.ISpaceResultCallback
            public void onSuccess(Bundle bundle2) {
                ShareApiImpl.this.infoLog("requestSpaceUpdate onSuccess ");
                ShareApi.SpaceResultCallback spaceResultCallback2 = spaceResultCallback;
                if (spaceResultCallback2 != null) {
                    spaceResultCallback2.onResult(new SpaceResult(new CommonResultStatus(1), ShareApiUtil.getInstance(ShareApiImpl.this.getTag(), ShareApiImpl.this.getReference(), ShareApiImpl.this.getAppId()).createSpaceResult(bundle2)));
                }
            }
        };
        try {
            if (i == 501) {
                Bundle bundle2 = new Bundle();
                bundle2.putInt("featureId", i);
                getSocialService().requestSpaceUpdateWithData(getAppId(), str, bundle2, bundle, stub);
                return 1;
            }
            if (!TextUtils.isEmpty(str2)) {
                Bundle bundle3 = new Bundle();
                bundle3.putString(BundleKey.EXTRA_CID, str2);
                getSocialService().requestSpaceUpdateWithData(getAppId(), str, bundle3, bundle, stub);
                return 1;
            }
            getSocialService().requestSpaceUpdate(getAppId(), str, bundle, stub);
            return 1;
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return -1;
        } catch (NotConnectedException e2) {
            secureLog(e2);
            return -8;
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return -1;
        }
    }

    public int requestSharedContentDownload(String str, String str2, List<String> list, String str3, int i, final ShareApi.ContentDownloadingResultCallback contentDownloadingResultCallback, PendingIntent pendingIntent, Bundle bundle, String str4) {
        StringBuilder sbM16m = AbstractC0000a.m16m("requestSharedContentDownload spaceId=[", str, "] itemId=[", str2, "] hash = [");
        sbM16m.append(list);
        sbM16m.append("] ");
        infoLog(sbM16m.toString());
        if (i == 501) {
            infoLog("requestSharedContentDownload is not supported in " + i);
            return -1;
        }
        if (TextUtils.isEmpty(getAppId())) {
            infoLog("app id is empty ");
            return -1;
        }
        if (!TextUtils.equals("8o8b82h22a", getAppId())) {
            infoLog("app id is not reminder. this api use only reminder");
            return -1;
        }
        IContentDownloadingResultCallback.Stub stub = new IContentDownloadingResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.share.ShareApiImpl.18
            @Override // com.samsung.android.sdk.mobileservice.social.share.IContentDownloadingResultCallback
            public void onFailure(long j, String str5) {
                ShareApiImpl shareApiImpl = ShareApiImpl.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestSharedContentDownload onFailure : code=[", "], message=[", str5);
                sbM2225p.append("] ");
                shareApiImpl.infoLog(sbM2225p.toString());
                if (contentDownloadingResultCallback != null) {
                    contentDownloadingResultCallback.onResult(new ContentDownloadResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), str5, Long.toString(j)), null, null));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.share.IContentDownloadingResultCallback
            public void onProgress(Bundle bundle2) {
                ShareApiImpl.this.debugLog("requestSharedContentDownload onProgress ");
                ShareApi.ContentDownloadingResultCallback contentDownloadingResultCallback2 = contentDownloadingResultCallback;
                if (contentDownloadingResultCallback2 != null) {
                    contentDownloadingResultCallback2.onProgress(ShareApiUtil.getInstance(ShareApiImpl.this.getTag(), ShareApiImpl.this.getReference(), ShareApiImpl.this.getAppId()).bundleToDownloadSnapShot(bundle2));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.share.IContentDownloadingResultCallback
            public void onSuccess(List<Bundle> list2, List<Bundle> list3) {
                ShareApiImpl.this.infoLog("requestSharedContentDownload onSuccess ");
                if (contentDownloadingResultCallback != null) {
                    if (list2.isEmpty() && list3.isEmpty()) {
                        ShareApiImpl.this.debugLog("requestSharedContentDownload bundle is empty!!");
                        contentDownloadingResultCallback.onResult(new ContentDownloadResult(new CommonResultStatus(1), null, null));
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    Iterator<Bundle> it = list2.iterator();
                    while (it.hasNext()) {
                        arrayList.add(ShareApiUtil.getInstance(ShareApiImpl.this.getTag(), ShareApiImpl.this.getReference(), ShareApiImpl.this.getAppId()).bundleToDownloadContent(it.next()));
                    }
                    Iterator<Bundle> it2 = list3.iterator();
                    while (it2.hasNext()) {
                        arrayList2.add(ShareApiUtil.getInstance(ShareApiImpl.this.getTag(), ShareApiImpl.this.getReference(), ShareApiImpl.this.getAppId()).bundleToDownloadContent(it2.next()));
                    }
                    contentDownloadingResultCallback.onResult(new ContentDownloadResult(new CommonResultStatus(1), arrayList, arrayList2));
                }
            }
        };
        try {
            if (TextUtils.isEmpty(str3)) {
                if (TextUtils.isEmpty(str4)) {
                    getSocialService().requestOriginalSharedContentWithFileListDownload(getAppId(), str, str2, list, stub, pendingIntent, bundle);
                    return 1;
                }
                getSocialService().requestOriginalSharedContentWithItemFileListDownloadWithPath(getAppId(), str, str2, list, stub, pendingIntent, bundle, str4);
                return 1;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString(BundleKey.EXTRA_CID, str3);
            if (TextUtils.isEmpty(str4)) {
                getSocialService().requestOriginalSharedContentWithFileListDownloadWithData(getAppId(), str, str2, list, bundle2, stub, pendingIntent, bundle);
                return 1;
            }
            getSocialService().mo5781xd48f8faa(getAppId(), str, str2, list, bundle2, stub, pendingIntent, bundle, str4);
            return 1;
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return -1;
        } catch (NotConnectedException e2) {
            secureLog(e2);
            return -8;
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return -1;
        }
    }

    public ShareController requestSharedItemUpdate(String str, List<ShareApi.SharedItemRequest> list, int i, final ShareApi.ShareUploadResultCallback<SharedItemListResult> shareUploadResultCallback, PendingIntent pendingIntent, Bundle bundle) {
        StringBuilder sbM15l = AbstractC0000a.m15l("requestSpace : spaceId=[", str, "], request size =[");
        sbM15l.append(list.size());
        sbM15l.append("] ");
        infoLog(sbM15l.toString());
        if (i == 501) {
            infoLog("requestSharedItemUpdate is not supported in " + i);
            return null;
        }
        if (TextUtils.isEmpty(getAppId())) {
            infoLog("app id is empty ");
            return null;
        }
        IShareResultCallback.Stub stub = new IShareResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.share.ShareApiImpl.25
            @Override // com.samsung.android.sdk.mobileservice.social.share.IShareResultCallback
            public void onFailure(long j, String str2) {
                ShareApiImpl shareApiImpl = ShareApiImpl.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestSpace onFailure : code=[", "], message=[", str2);
                sbM2225p.append("] ");
                shareApiImpl.infoLog(sbM2225p.toString());
                if (shareUploadResultCallback != null) {
                    int iConvertErrorcode = ErrorCodeConvertor.convertErrorcode(j);
                    ShareApiImpl.this.debugLog(AbstractC0541b.m773o("requestShare Error Message [", str2, "]"));
                    shareUploadResultCallback.onResult(new SharedItemListResult(new CommonResultStatus(iConvertErrorcode, str2, Long.toString(j)), null, null));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.share.IShareResultCallback
            public void onProgress(Bundle bundle2) {
                ShareApiImpl.this.debugLog("requestShare onProgress ");
                ShareApi.ShareUploadResultCallback shareUploadResultCallback2 = shareUploadResultCallback;
                if (shareUploadResultCallback2 != null) {
                    shareUploadResultCallback2.onProgress(ShareApiUtil.getInstance(ShareApiImpl.this.getTag(), ShareApiImpl.this.getReference(), ShareApiImpl.this.getAppId()).bundleToShareSnapShot(bundle2));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.share.IShareResultCallback
            public void onSuccess(List<Bundle> list2, List<Bundle> list3) {
                ShareApiImpl.this.infoLog("requestSharedItemUpdate onSuccess ");
                if (shareUploadResultCallback != null) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<Bundle> it = list2.iterator();
                    while (it.hasNext()) {
                        arrayList.add(ShareApiUtil.getInstance(ShareApiImpl.this.getTag(), ShareApiImpl.this.getReference(), ShareApiImpl.this.getAppId()).createSharedItemResult(it.next()));
                    }
                    ArrayList arrayList2 = new ArrayList();
                    Iterator<Bundle> it2 = list3.iterator();
                    while (it2.hasNext()) {
                        arrayList2.add(ShareApiUtil.getInstance(ShareApiImpl.this.getTag(), ShareApiImpl.this.getReference(), ShareApiImpl.this.getAppId()).createShareFailedItemResult(it2.next()));
                    }
                    shareUploadResultCallback.onResult(new SharedItemListResult(new CommonResultStatus(1), arrayList, arrayList2));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.share.IShareResultCallback
            public void onUploadComplete(Bundle bundle2) {
                ShareApiImpl.this.debugLog("requestShare onUploadComplete ");
                ShareApi.ShareUploadResultCallback shareUploadResultCallback2 = shareUploadResultCallback;
                if (shareUploadResultCallback2 != null) {
                    shareUploadResultCallback2.onUploadComplete(ShareApiUtil.getInstance(ShareApiImpl.this.getTag(), ShareApiImpl.this.getReference(), ShareApiImpl.this.getAppId()).bundleToShareSnapShot(bundle2));
                }
            }
        };
        try {
            ArrayList arrayList = new ArrayList();
            Iterator<ShareApi.SharedItemRequest> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(ShareApiUtil.getInstance(getTag(), getReference(), getAppId()).requestToBundle(it.next()));
            }
            return new ShareController(this.mApiPicker, getSocialService().requestSharedItemListUpdate(getAppId(), str, arrayList, stub, pendingIntent, bundle));
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return null;
        } catch (NotConnectedException e2) {
            e = e2;
            secureLog(e);
            return null;
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return null;
        }
    }

    public int requestSpaceList(String str, int i, final ShareApi.SpaceListResultCallback spaceListResultCallback) {
        infoLog("requestSpaceList ");
        if (!isSupportedSemsAgentVersionMoreThan(CommonConstants.SupportedApiMinVersion.VERSION_4_1) || checkInvalidFeatureIdAndAgentVersion(i)) {
            return -7;
        }
        if (TextUtils.isEmpty(getAppId())) {
            infoLog("app id is empty ");
            return -1;
        }
        ISpaceListResultCallback.Stub stub = new ISpaceListResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.share.ShareApiImpl.8
            @Override // com.samsung.android.sdk.mobileservice.social.share.ISpaceListResultCallback
            public void onFailure(long j, String str2) {
                ShareApiImpl shareApiImpl = ShareApiImpl.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestSpaceList onFailure : code=[", "], message=[", str2);
                sbM2225p.append("] ");
                shareApiImpl.infoLog(sbM2225p.toString());
                if (spaceListResultCallback != null) {
                    spaceListResultCallback.onResult(new SpaceListResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), str2, Long.toString(j)), null));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.share.ISpaceListResultCallback
            public void onSuccess(List<Bundle> list) {
                ShareApiImpl.this.infoLog("requestSpaceList onSuccess ");
                if (spaceListResultCallback != null) {
                    ArrayList arrayList = new ArrayList();
                    for (Bundle bundle : list) {
                        String string = bundle.getString("space_id");
                        String string2 = bundle.getString("group_id");
                        String string3 = bundle.getString(BundleKey.OWNER_ID);
                        if (string == null || string2 == null || string3 == null) {
                            spaceListResultCallback.onResult(new SpaceListResult(new CommonResultStatus(-1, "Invalid space information", ""), null));
                            return;
                        }
                        arrayList.add(ShareApiUtil.getInstance(ShareApiImpl.this.getTag(), ShareApiImpl.this.getReference(), ShareApiImpl.this.getAppId()).createSpaceResult(bundle));
                    }
                    spaceListResultCallback.onResult(new SpaceListResult(new CommonResultStatus(1), arrayList));
                }
            }
        };
        try {
            if (i == 501) {
                Bundle bundle = new Bundle();
                bundle.putInt("featureId", i);
                getSocialService().requestAllSpaceListWithData(getAppId(), bundle, stub);
                return 1;
            }
            if (!TextUtils.isEmpty(str)) {
                Bundle bundle2 = new Bundle();
                bundle2.putString(BundleKey.EXTRA_CID, str);
                getSocialService().requestAllSpaceListWithData(getAppId(), bundle2, stub);
                return 1;
            }
            getSocialService().requestAllSpaceList(getAppId(), stub);
            return 1;
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return -1;
        } catch (NotConnectedException e2) {
            secureLog(e2);
            return -8;
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return -1;
        }
    }

    public int requestSharedItemSync(String str, int i, final ShareApi.SharedItemSyncResultCallback sharedItemSyncResultCallback) {
        infoLog("requestSharedItemSync : spaceId=[" + str + "] ");
        if (checkInvalidFeatureIdAndAgentVersion(i)) {
            return -7;
        }
        if (TextUtils.isEmpty(getAppId())) {
            infoLog("app id is empty ");
            return -1;
        }
        IShareSyncResultCallback.Stub stub = new IShareSyncResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.share.ShareApiImpl.23
            @Override // com.samsung.android.sdk.mobileservice.social.share.IShareSyncResultCallback
            public void onFailure(long j, String str2) {
                ShareApiImpl shareApiImpl = ShareApiImpl.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestSharedItemSync onFailure : code=[", "], message=[", str2);
                sbM2225p.append("] ");
                shareApiImpl.infoLog(sbM2225p.toString());
                if (sharedItemSyncResultCallback != null) {
                    sharedItemSyncResultCallback.onResult(new BooleanResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), str2, Long.toString(j)), false));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.share.IShareSyncResultCallback
            public void onSuccess() {
                ShareApiImpl.this.infoLog("requestSharedItemSync onSuccess ");
                ShareApi.SharedItemSyncResultCallback sharedItemSyncResultCallback2 = sharedItemSyncResultCallback;
                if (sharedItemSyncResultCallback2 != null) {
                    sharedItemSyncResultCallback2.onResult(new BooleanResult(new CommonResultStatus(1), true));
                }
            }
        };
        try {
            if (i == 501) {
                Bundle bundle = new Bundle();
                bundle.putInt("featureId", i);
                getSocialService().requestSharedItemSyncWithData(getAppId(), str, bundle, stub);
                return 1;
            }
            getSocialService().requestSharedItemSync(getAppId(), str, stub);
            return 1;
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return -1;
        } catch (NotConnectedException e2) {
            secureLog(e2);
            return -8;
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return -1;
        }
    }

    public int requestSharedItemDeletion(String str, String str2, int i, final ShareApi.SharedItemDeletionResultCallback sharedItemDeletionResultCallback) {
        infoLog(AbstractC0541b.m775q("requestSharedItemDeletion : spaceId=[", str, "], itemId=[", str2, "] "));
        if (checkInvalidFeatureIdAndAgentVersion(i)) {
            return -7;
        }
        if (TextUtils.isEmpty(getAppId())) {
            infoLog("app id is empty ");
            return -1;
        }
        ISharedItemDeletionResultCallback.Stub stub = new ISharedItemDeletionResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.share.ShareApiImpl.19
            @Override // com.samsung.android.sdk.mobileservice.social.share.ISharedItemDeletionResultCallback
            public void onFailure(long j, String str3) {
                ShareApiImpl shareApiImpl = ShareApiImpl.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestSharedItemDeletion onFailure : code=[", "], message=[", str3);
                sbM2225p.append("] ");
                shareApiImpl.infoLog(sbM2225p.toString());
                if (sharedItemDeletionResultCallback != null) {
                    sharedItemDeletionResultCallback.onResult(new BooleanResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), str3, Long.toString(j)), false));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.share.ISharedItemDeletionResultCallback
            public void onSuccess() {
                ShareApiImpl.this.infoLog("requestSharedItemDeletion onSuccess ");
                ShareApi.SharedItemDeletionResultCallback sharedItemDeletionResultCallback2 = sharedItemDeletionResultCallback;
                if (sharedItemDeletionResultCallback2 != null) {
                    sharedItemDeletionResultCallback2.onResult(new BooleanResult(new CommonResultStatus(1), true));
                }
            }
        };
        try {
            if (i == 501) {
                Bundle bundle = new Bundle();
                bundle.putInt("featureId", i);
                getSocialService().requestSharedItemDeletionWithData(getAppId(), str, str2, bundle, stub);
                return 1;
            }
            getSocialService().requestSharedItemDeletion(getAppId(), str, str2, stub);
            return 1;
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return -1;
        } catch (NotConnectedException e2) {
            secureLog(e2);
            return -8;
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return -1;
        }
    }

    public ShareController requestShare(String str, List<ShareApi.SharedItemRequest> list, ShareApi.ActionIntent actionIntent, ShareApi.NotificationMessage notificationMessage, int i, final ShareApi.ShareUploadResultCallback<SharedItemListResult> shareUploadResultCallback) {
        String strRequestShareWithData;
        infoLog("requestShare : spaceId=[" + str + "] ");
        if (i == 501) {
            infoLog("requestShare is not supported in " + i);
            return null;
        }
        if (getAppId() == null) {
            infoLog("app id is null ");
            return null;
        }
        IShareResultCallback.Stub stub = new IShareResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.share.ShareApiImpl.17
            @Override // com.samsung.android.sdk.mobileservice.social.share.IShareResultCallback
            public void onFailure(long j, String str2) {
                ShareApiImpl shareApiImpl = ShareApiImpl.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestShare onFailure : code=[", "], message=[", str2);
                sbM2225p.append("] ");
                shareApiImpl.infoLog(sbM2225p.toString());
                if (shareUploadResultCallback != null) {
                    int iConvertErrorcode = ErrorCodeConvertor.convertErrorcode(j);
                    ShareApiImpl.this.debugLog(AbstractC0541b.m773o("requestShare Error Message [", str2, "]"));
                    shareUploadResultCallback.onResult(new SharedItemListResult(new CommonResultStatus(iConvertErrorcode, str2, Long.toString(j)), null, null));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.share.IShareResultCallback
            public void onProgress(Bundle bundle) {
                ShareApiImpl.this.debugLog("requestShare onProgress ");
                ShareApi.ShareUploadResultCallback shareUploadResultCallback2 = shareUploadResultCallback;
                if (shareUploadResultCallback2 != null) {
                    shareUploadResultCallback2.onProgress(ShareApiUtil.getInstance(ShareApiImpl.this.getTag(), ShareApiImpl.this.getReference(), ShareApiImpl.this.getAppId()).bundleToShareSnapShot(bundle));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.share.IShareResultCallback
            public void onSuccess(List<Bundle> list2, List<Bundle> list3) {
                ShareApiImpl.this.infoLog("requestShare onSuccess ");
                if (shareUploadResultCallback != null) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<Bundle> it = list2.iterator();
                    while (it.hasNext()) {
                        arrayList.add(ShareApiUtil.getInstance(ShareApiImpl.this.getTag(), ShareApiImpl.this.getReference(), ShareApiImpl.this.getAppId()).createSharedItemResult(it.next()));
                    }
                    ArrayList arrayList2 = new ArrayList();
                    Iterator<Bundle> it2 = list3.iterator();
                    while (it2.hasNext()) {
                        arrayList2.add(ShareApiUtil.getInstance(ShareApiImpl.this.getTag(), ShareApiImpl.this.getReference(), ShareApiImpl.this.getAppId()).createShareFailedItemResult(it2.next()));
                    }
                    shareUploadResultCallback.onResult(new SharedItemListResult(new CommonResultStatus(1), arrayList, arrayList2));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.share.IShareResultCallback
            public void onUploadComplete(Bundle bundle) {
                ShareApiImpl.this.debugLog("requestShare onUploadComplete ");
                ShareApi.ShareUploadResultCallback shareUploadResultCallback2 = shareUploadResultCallback;
                if (shareUploadResultCallback2 != null) {
                    shareUploadResultCallback2.onUploadComplete(ShareApiUtil.getInstance(ShareApiImpl.this.getTag(), ShareApiImpl.this.getReference(), ShareApiImpl.this.getAppId()).bundleToShareSnapShot(bundle));
                }
            }
        };
        try {
            ArrayList arrayList = new ArrayList();
            Iterator<ShareApi.SharedItemRequest> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(ShareApiUtil.getInstance(getTag(), getReference(), getAppId()).requestToBundle(it.next()));
            }
            if (!isSupportedSemsAgentVersionBetween(CommonConstants.SupportedApiMinVersion.VERSION_10_8_6, CommonConstants.SupportedApiMinVersion.VERSION_11_0) && !isSupportedSemsAgentVersionMoreThan(CommonConstants.SupportedApiMinVersion.VERSION_13_0_1)) {
                strRequestShareWithData = getSocialService().requestShareWithPendingIntent(getAppId(), str, arrayList, stub, actionIntent != null ? actionIntent.getShareCompleteIntent() : null, notificationMessage != null ? notificationMessage.toBundle() : null);
            } else {
                Bundle bundle = new Bundle();
                if (actionIntent != null) {
                    bundle.putParcelable(BundleKey.PENDING_INTENTS, actionIntent.toBundle());
                }
                if (notificationMessage != null) {
                    bundle.putParcelable(BundleKey.NOTIFICATION_MESSAGES, notificationMessage.toBundle());
                }
                strRequestShareWithData = getSocialService().requestShareWithData(getAppId(), str, arrayList, bundle, stub);
            }
            return new ShareController(this.mApiPicker, strRequestShareWithData);
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return null;
        } catch (NotConnectedException e2) {
            e = e2;
            secureLog(e);
            return null;
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return null;
        }
    }

    public int requestSharedItemList(String str, String str2, String str3, int i, final ShareApi.SharedItemListResultCallback sharedItemListResultCallback) {
        StringBuilder sbM16m = AbstractC0000a.m16m("requestSharedItemList : groupId=[", str, "], spaceId=[", str2, "], resolution=[");
        sbM16m.append(str3);
        sbM16m.append("] ");
        infoLog(sbM16m.toString());
        if (i == 501) {
            infoLog("requestSharedItemList is not supported in " + i);
            return -1;
        }
        if (!isSupportedSemsAgentVersionMoreThan(CommonConstants.SupportedApiMinVersion.VERSION_4_1) || checkInvalidFeatureIdAndAgentVersion(i)) {
            return -7;
        }
        if (TextUtils.isEmpty(getAppId())) {
            infoLog("app id is empty ");
            return -1;
        }
        try {
            getSocialService().requestSharedItemList(getAppId(), str, str2, str3, new ISharedItemListResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.share.ShareApiImpl.28
                @Override // com.samsung.android.sdk.mobileservice.social.share.ISharedItemListResultCallback
                public void onFailure(long j, String str4) {
                    ShareApiImpl shareApiImpl = ShareApiImpl.this;
                    StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestSpace onFailure : code=[", "], message=[", str4);
                    sbM2225p.append("] ");
                    shareApiImpl.infoLog(sbM2225p.toString());
                    if (sharedItemListResultCallback != null) {
                        ErrorCodeConvertor.convertErrorcode(j);
                        ShareApiImpl.this.debugLog(AbstractC0541b.m773o("requestSpace Error Message [", str4, "]"));
                    }
                }

                @Override // com.samsung.android.sdk.mobileservice.social.share.ISharedItemListResultCallback
                public void onSuccess(List<Bundle> list) {
                    ShareApiImpl.this.infoLog("requestSharedItemList(without content list) onSuccess ");
                    if (sharedItemListResultCallback != null) {
                        ArrayList arrayList = new ArrayList();
                        Iterator<Bundle> it = list.iterator();
                        while (it.hasNext()) {
                            arrayList.add(ShareApiUtil.getInstance(ShareApiImpl.this.getTag(), ShareApiImpl.this.getReference(), ShareApiImpl.this.getAppId()).createSharedItemResult(it.next()));
                        }
                        sharedItemListResultCallback.onResult(new SharedItemListResult(new CommonResultStatus(1), arrayList, null));
                    }
                }
            });
            return 1;
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return -1;
        } catch (NotConnectedException e2) {
            secureLog(e2);
            return -8;
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return -1;
        }
    }

    public ShareController requestSharedItemUpdate(String str, String str2, ShareApi.SharedItemRequest sharedItemRequest, int i, final ShareApi.SharedItemUpdateResultCallback sharedItemUpdateResultCallback, PendingIntent pendingIntent, Bundle bundle) {
        infoLog(AbstractC0541b.m775q("requestSpace : spaceId=[", str, "], itemId=[", str2, "] "));
        if (i == 501) {
            infoLog("requestSharedItemUpdate is not supported in " + i);
            return null;
        }
        if (TextUtils.isEmpty(getAppId())) {
            infoLog("app id is empty ");
            return null;
        }
        try {
            return new ShareController(this.mApiPicker, getSocialService().requestSharedItemUpdate(getAppId(), str, str2, ShareApiUtil.getInstance(getTag(), getReference(), getAppId()).requestToBundle(sharedItemRequest), new ISharedItemUpdateResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.share.ShareApiImpl.26
                @Override // com.samsung.android.sdk.mobileservice.social.share.ISharedItemUpdateResultCallback
                public void onFailure(long j, String str3) {
                    ShareApiImpl shareApiImpl = ShareApiImpl.this;
                    StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestSpace onFailure : code=[", "], message=[", str3);
                    sbM2225p.append("] ");
                    shareApiImpl.infoLog(sbM2225p.toString());
                    if (sharedItemUpdateResultCallback != null) {
                        int iConvertErrorcode = ErrorCodeConvertor.convertErrorcode(j);
                        ShareApiImpl.this.debugLog(AbstractC0541b.m773o("requestSpace Error Message [", str3, "]"));
                        sharedItemUpdateResultCallback.onResult(new SharedItemResult(new CommonResultStatus(iConvertErrorcode, str3, Long.toString(j)), null));
                    }
                }

                @Override // com.samsung.android.sdk.mobileservice.social.share.ISharedItemUpdateResultCallback
                public void onProgress(Bundle bundle2) {
                    ShareApiImpl.this.debugLog("requestShare onProgress ");
                    ShareApi.SharedItemUpdateResultCallback sharedItemUpdateResultCallback2 = sharedItemUpdateResultCallback;
                    if (sharedItemUpdateResultCallback2 != null) {
                        sharedItemUpdateResultCallback2.onProgress(ShareApiUtil.getInstance(ShareApiImpl.this.getTag(), ShareApiImpl.this.getReference(), ShareApiImpl.this.getAppId()).bundleToShareSnapShot(bundle2));
                    }
                }

                @Override // com.samsung.android.sdk.mobileservice.social.share.ISharedItemUpdateResultCallback
                public void onSuccess(Bundle bundle2) {
                    ShareApiImpl.this.infoLog("requestSpace onSuccess ");
                    ShareApi.SharedItemUpdateResultCallback sharedItemUpdateResultCallback2 = sharedItemUpdateResultCallback;
                    if (sharedItemUpdateResultCallback2 != null) {
                        sharedItemUpdateResultCallback2.onResult(new SharedItemResult(new CommonResultStatus(1), ShareApiUtil.getInstance(ShareApiImpl.this.getTag(), ShareApiImpl.this.getReference(), ShareApiImpl.this.getAppId()).createSharedItemResult(bundle2)));
                    }
                }

                @Override // com.samsung.android.sdk.mobileservice.social.share.ISharedItemUpdateResultCallback
                public void onUploadComplete(Bundle bundle2) {
                    ShareApiImpl.this.debugLog("requestShare onUploadComplete ");
                    ShareApi.SharedItemUpdateResultCallback sharedItemUpdateResultCallback2 = sharedItemUpdateResultCallback;
                    if (sharedItemUpdateResultCallback2 != null) {
                        sharedItemUpdateResultCallback2.onUploadComplete(ShareApiUtil.getInstance(ShareApiImpl.this.getTag(), ShareApiImpl.this.getReference(), ShareApiImpl.this.getAppId()).bundleToShareSnapShot(bundle2));
                    }
                }
            }, pendingIntent, bundle));
        } catch (RemoteException | NotConnectedException | NullPointerException e) {
            secureLog(e);
            return null;
        }
    }

    public int requestSharedItemDeletion(String str, List<String> list, int i, final ShareApi.SharedItemDeletionListResultCallback sharedItemDeletionListResultCallback) {
        StringBuilder sbM15l = AbstractC0000a.m15l("requestSharedItemDeletion : spaceId=[", str, "], itemId size=");
        sbM15l.append(list.size());
        infoLog(sbM15l.toString());
        if (checkInvalidFeatureIdAndAgentVersion(i)) {
            return -7;
        }
        if (TextUtils.isEmpty(getAppId())) {
            infoLog("app id is empty ");
            return -1;
        }
        ISharedItemListDeletionResultCallback.Stub stub = new ISharedItemListDeletionResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.share.ShareApiImpl.20
            @Override // com.samsung.android.sdk.mobileservice.social.share.ISharedItemListDeletionResultCallback
            public void onFailure(long j, String str2) {
                ShareApiImpl shareApiImpl = ShareApiImpl.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestSharedItemDeletion onFailure : code=[", "], message=[", str2);
                sbM2225p.append("] ");
                shareApiImpl.infoLog(sbM2225p.toString());
                if (sharedItemDeletionListResultCallback != null) {
                    sharedItemDeletionListResultCallback.onResult(new SharedItemListDeletionResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), str2, Long.toString(j)), new ArrayList()));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.share.ISharedItemListDeletionResultCallback
            public void onSuccess(List<Bundle> list2) {
                ShareApiImpl.this.infoLog("requestSharedItemDeletion onSuccess ");
                if (sharedItemDeletionListResultCallback != null) {
                    ArrayList arrayList = new ArrayList();
                    for (Bundle bundle : list2) {
                        arrayList.add(new SharedItemListDeletionResult.SharedItemDeletionResult(bundle.getString("space_id"), bundle.getString("item_id"), bundle.getBoolean("result")));
                    }
                    sharedItemDeletionListResultCallback.onResult(new SharedItemListDeletionResult(new CommonResultStatus(1), arrayList));
                }
            }
        };
        try {
            if (i == 501) {
                Bundle bundle = new Bundle();
                bundle.putInt("featureId", i);
                getSocialService().requestSharedItemListDeletionWithData(getAppId(), str, list, bundle, stub);
                return 1;
            }
            getSocialService().requestSharedItemListDeletion(getAppId(), str, list, stub);
            return 1;
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return -1;
        } catch (NotConnectedException e2) {
            secureLog(e2);
            return -8;
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return -1;
        }
    }
}
