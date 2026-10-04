package com.samsung.android.sdk.mobileservice.social.share;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
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
import com.samsung.android.sdk.mobileservice.social.share.IShareResultCallback;
import com.samsung.android.sdk.mobileservice.social.share.IShareResultWithFileListCallback;
import com.samsung.android.sdk.mobileservice.social.share.IShareSyncResultCallback;
import com.samsung.android.sdk.mobileservice.social.share.ShareApi;
import com.samsung.android.sdk.mobileservice.social.share.ShareController;
import com.samsung.android.sdk.mobileservice.social.share.result.SharedItemListResult;
import com.samsung.android.sdk.mobileservice.social.share.result.SharedItemWithUriListResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class LegacyShareApiImpl extends SeMobileServiceApi {
    private static final int FEATURE_ID_INVALID = -1;
    private static final String TAG = "LegacyShareApiImpl";
    private final String APP_ID_REMINDER;
    private final ShareController.ShareControllerApiPicker mApiPicker;

    public LegacyShareApiImpl(SeMobileServiceSession seMobileServiceSession) throws NotAuthorizedException {
        super(seMobileServiceSession, "ShareApi");
        this.APP_ID_REMINDER = "8o8b82h22a";
        this.mApiPicker = new ShareController.ShareControllerApiPicker() { // from class: com.samsung.android.sdk.mobileservice.social.share.LegacyShareApiImpl.1
            @Override // com.samsung.android.sdk.mobileservice.social.share.ShareController.ShareControllerApiPicker
            public String getAppId() {
                return LegacyShareApiImpl.this.getAppId();
            }

            @Override // com.samsung.android.sdk.mobileservice.social.share.ShareController.ShareControllerApiPicker
            public String getReference() {
                return LegacyShareApiImpl.this.getReference();
            }

            @Override // com.samsung.android.sdk.mobileservice.social.share.ShareController.ShareControllerApiPicker
            public IMobileServiceSocial getSocialService() {
                return LegacyShareApiImpl.this.getSocialService();
            }
        };
        checkAuthorized(0, 2);
    }

    private boolean checkInvalidFeatureIdAndAgentVersion(int i) {
        if (i != 501 || isSupportedSemsAgentVersionBetween(CommonConstants.SupportedApiMinVersion.VERSION_10_8_8, CommonConstants.SupportedApiMinVersion.VERSION_11_0) || isSupportedSemsAgentVersionMoreThan(CommonConstants.SupportedApiMinVersion.VERSION_13_1_0)) {
            return false;
        }
        infoLog("isValidFeatureIdAndAgentVersion with" + i + "is not supported in this agent version");
        return true;
    }

    private IShareSyncResultCallback createShareSyncCallback(final ShareApi.ShareSyncResultCallback shareSyncResultCallback) {
        return new IShareSyncResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.share.LegacyShareApiImpl.2
            @Override // com.samsung.android.sdk.mobileservice.social.share.IShareSyncResultCallback
            public void onFailure(long j, String str) {
                LegacyShareApiImpl legacyShareApiImpl = LegacyShareApiImpl.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestSync onFailure : code=[", "], message=[", str);
                sbM2225p.append("] ");
                legacyShareApiImpl.infoLog(sbM2225p.toString());
                if (shareSyncResultCallback != null) {
                    shareSyncResultCallback.onResult(new BooleanResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), str, Long.toString(j)), false));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.share.IShareSyncResultCallback
            public void onSuccess() {
                LegacyShareApiImpl.this.infoLog("requestSync onSuccess ");
                ShareApi.ShareSyncResultCallback shareSyncResultCallback2 = shareSyncResultCallback;
                if (shareSyncResultCallback2 != null) {
                    shareSyncResultCallback2.onResult(new BooleanResult(new CommonResultStatus(1), true));
                }
            }
        };
    }

    @Override // com.samsung.android.sdk.mobileservice.common.api.SeMobileServiceApi
    public String[] getEssentialServiceNames() {
        return new String[]{"SocialService"};
    }

    @Override // com.samsung.android.sdk.mobileservice.common.api.SeMobileServiceApi
    public String getTag() {
        return TAG;
    }

    public ShareController requestShare(String str, List<ShareApi.SharedItemRequest> list, int i, final ShareApi.ShareResultCallback shareResultCallback, PendingIntent pendingIntent, Bundle bundle) {
        infoLog("requestShare : spaceId=[" + str + "] ");
        if (i == 501) {
            infoLog("requestShare is not supported in " + i);
            return null;
        }
        if (TextUtils.isEmpty(getAppId())) {
            infoLog("app id is empty ");
            return null;
        }
        IShareResultCallback.Stub stub = new IShareResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.share.LegacyShareApiImpl.3
            @Override // com.samsung.android.sdk.mobileservice.social.share.IShareResultCallback
            public void onFailure(long j, String str2) {
                LegacyShareApiImpl legacyShareApiImpl = LegacyShareApiImpl.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestShare onFailure : code=[", "], message=[", str2);
                sbM2225p.append("] ");
                legacyShareApiImpl.infoLog(sbM2225p.toString());
                if (shareResultCallback != null) {
                    int iConvertErrorcode = ErrorCodeConvertor.convertErrorcode(j);
                    LegacyShareApiImpl.this.debugLog("requestShare Error Message [" + str2 + "]");
                    shareResultCallback.onResult(new SharedItemListResult(new CommonResultStatus(iConvertErrorcode, str2, Long.toString(j)), null, null));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.share.IShareResultCallback
            public void onProgress(Bundle bundle2) {
                LegacyShareApiImpl.this.debugLog("requestShare onProgress ");
                ShareApi.ShareResultCallback shareResultCallback2 = shareResultCallback;
                if (shareResultCallback2 != null) {
                    shareResultCallback2.onProgress(ShareApiUtil.getInstance(LegacyShareApiImpl.this.getTag(), LegacyShareApiImpl.this.getReference(), LegacyShareApiImpl.this.getAppId()).bundleToShareSnapShot(bundle2));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.share.IShareResultCallback
            public void onSuccess(List<Bundle> list2, List<Bundle> list3) {
                LegacyShareApiImpl.this.infoLog("requestShare onSuccess ");
                if (shareResultCallback != null) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<Bundle> it = list2.iterator();
                    while (it.hasNext()) {
                        arrayList.add(ShareApiUtil.getInstance(LegacyShareApiImpl.this.getTag(), LegacyShareApiImpl.this.getReference(), LegacyShareApiImpl.this.getAppId()).createSharedItemResult(it.next()));
                    }
                    ArrayList arrayList2 = new ArrayList();
                    Iterator<Bundle> it2 = list3.iterator();
                    while (it2.hasNext()) {
                        arrayList2.add(ShareApiUtil.getInstance(LegacyShareApiImpl.this.getTag(), LegacyShareApiImpl.this.getReference(), LegacyShareApiImpl.this.getAppId()).createShareFailedItemResult(it2.next()));
                    }
                    shareResultCallback.onResult(new SharedItemListResult(new CommonResultStatus(1), arrayList, arrayList2));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.share.IShareResultCallback
            public void onUploadComplete(Bundle bundle2) {
                LegacyShareApiImpl.this.debugLog("requestShare onUploadComplete ");
                ShareApi.ShareResultCallback shareResultCallback2 = shareResultCallback;
                if (shareResultCallback2 != null) {
                    shareResultCallback2.onUploadComplete(ShareApiUtil.getInstance(LegacyShareApiImpl.this.getTag(), LegacyShareApiImpl.this.getReference(), LegacyShareApiImpl.this.getAppId()).bundleToShareSnapShot(bundle2));
                }
            }
        };
        try {
            ArrayList arrayList = new ArrayList();
            Iterator<ShareApi.SharedItemRequest> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(ShareApiUtil.getInstance(getTag(), getReference(), getAppId()).requestToBundle(it.next()));
            }
            return new ShareController(this.mApiPicker, getSocialService().requestShareWithPendingIntent(getAppId(), str, arrayList, stub, pendingIntent, bundle));
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

    public int requestSync(String str, int i, boolean z, String str2, ShareApi.ShareSyncResultCallback shareSyncResultCallback) {
        infoLog("requestSync with needToShowPermissionUI - syncType : " + str2 + " isPermissionUINeeded : " + z);
        if (!isSupportedSemsAgentVersionMoreThan(CommonConstants.SupportedApiMinVersion.VERSION_12_2_2) || checkInvalidFeatureIdAndAgentVersion(i)) {
            return -7;
        }
        if (TextUtils.isEmpty(getAppId())) {
            infoLog("app id is empty ");
            return -1;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putBoolean(BundleKey.EXTRA_NEED_TO_SHOW_PERMISSION_UI, z);
            bundle.putString(BundleKey.EXTRA_SYNC_TYPE, str2);
            if (i == 501) {
                bundle.putInt("featureId", i);
            } else if (!TextUtils.isEmpty(str)) {
                bundle.putString(BundleKey.EXTRA_CID, str);
            }
            getSocialService().requestShareSyncWithData(getAppId(), bundle, createShareSyncCallback(shareSyncResultCallback));
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

    public ShareController requestShare(String str, List<ShareApi.SharedItemRequest> list, ShareApi.ActionIntent actionIntent, ShareApi.NotificationMessage notificationMessage, int i, final ShareApi.ShareResultCallback shareResultCallback) {
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
        IShareResultCallback.Stub stub = new IShareResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.share.LegacyShareApiImpl.4
            @Override // com.samsung.android.sdk.mobileservice.social.share.IShareResultCallback
            public void onFailure(long j, String str2) {
                LegacyShareApiImpl legacyShareApiImpl = LegacyShareApiImpl.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestShare onFailure : code=[", "], message=[", str2);
                sbM2225p.append("] ");
                legacyShareApiImpl.infoLog(sbM2225p.toString());
                if (shareResultCallback != null) {
                    int iConvertErrorcode = ErrorCodeConvertor.convertErrorcode(j);
                    LegacyShareApiImpl.this.debugLog("requestShare Error Message [" + str2 + "]");
                    shareResultCallback.onResult(new SharedItemListResult(new CommonResultStatus(iConvertErrorcode, str2, Long.toString(j)), null, null));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.share.IShareResultCallback
            public void onProgress(Bundle bundle) {
                LegacyShareApiImpl.this.debugLog("requestShare onProgress ");
                ShareApi.ShareResultCallback shareResultCallback2 = shareResultCallback;
                if (shareResultCallback2 != null) {
                    shareResultCallback2.onProgress(ShareApiUtil.getInstance(LegacyShareApiImpl.this.getTag(), LegacyShareApiImpl.this.getReference(), LegacyShareApiImpl.this.getAppId()).bundleToShareSnapShot(bundle));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.share.IShareResultCallback
            public void onSuccess(List<Bundle> list2, List<Bundle> list3) {
                LegacyShareApiImpl.this.infoLog("requestShare onSuccess ");
                if (shareResultCallback != null) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<Bundle> it = list2.iterator();
                    while (it.hasNext()) {
                        arrayList.add(ShareApiUtil.getInstance(LegacyShareApiImpl.this.getTag(), LegacyShareApiImpl.this.getReference(), LegacyShareApiImpl.this.getAppId()).createSharedItemResult(it.next()));
                    }
                    ArrayList arrayList2 = new ArrayList();
                    Iterator<Bundle> it2 = list3.iterator();
                    while (it2.hasNext()) {
                        arrayList2.add(ShareApiUtil.getInstance(LegacyShareApiImpl.this.getTag(), LegacyShareApiImpl.this.getReference(), LegacyShareApiImpl.this.getAppId()).createShareFailedItemResult(it2.next()));
                    }
                    shareResultCallback.onResult(new SharedItemListResult(new CommonResultStatus(1), arrayList, arrayList2));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.share.IShareResultCallback
            public void onUploadComplete(Bundle bundle) {
                LegacyShareApiImpl.this.debugLog("requestShare onUploadComplete ");
                ShareApi.ShareResultCallback shareResultCallback2 = shareResultCallback;
                if (shareResultCallback2 != null) {
                    shareResultCallback2.onUploadComplete(ShareApiUtil.getInstance(LegacyShareApiImpl.this.getTag(), LegacyShareApiImpl.this.getReference(), LegacyShareApiImpl.this.getAppId()).bundleToShareSnapShot(bundle));
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

    public int requestSync(String str, int i, SyncOption syncOption, ShareApi.ShareSyncResultCallback shareSyncResultCallback) {
        infoLog("requestSync with syncOption - syncType : " + syncOption.getSyncType().toString() + " isPermissionUINeeded : " + syncOption.isPermissionUINeeded() + " isSyncWithQuota : " + syncOption.isSyncWithQuota());
        if ((!isSupportedSemsAgentVersionBetween(CommonConstants.SupportedApiMinVersion.VERSION_10_8_6, CommonConstants.SupportedApiMinVersion.VERSION_11_0) && !isSupportedSemsAgentVersionMoreThan(CommonConstants.SupportedApiMinVersion.VERSION_13_0_1)) || checkInvalidFeatureIdAndAgentVersion(i)) {
            return -7;
        }
        if (getAppId() == null) {
            infoLog("app id is null ");
            return -1;
        }
        try {
            Bundle bundle = new Bundle();
            if (i == 501) {
                bundle.putInt("featureId", i);
            } else if (!TextUtils.isEmpty(str)) {
                bundle.putString(BundleKey.EXTRA_CID, str);
            }
            bundle.putBoolean(BundleKey.EXTRA_NEED_TO_SHOW_PERMISSION_UI, syncOption.isPermissionUINeeded());
            bundle.putString(BundleKey.EXTRA_SYNC_TYPE, syncOption.getSyncType().toString());
            bundle.putBoolean(BundleKey.EXTRA_SYNC_IS_SYNC_WITH_QUOTA, syncOption.isSyncWithQuota());
            getSocialService().requestShareSyncWithOption(getAppId(), bundle, createShareSyncCallback(shareSyncResultCallback));
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

    public ShareController requestShare(String str, ShareApi.SharedItemWithUriListRequest sharedItemWithUriListRequest, int i, final ShareApi.SharedItemWithContentListResultCallback sharedItemWithContentListResultCallback, PendingIntent pendingIntent, Bundle bundle) {
        String strRequestShareWithFileList;
        infoLog("requestShare : spaceId=[" + str + "] ");
        if (checkInvalidFeatureIdAndAgentVersion(i)) {
            return null;
        }
        if (TextUtils.isEmpty(getAppId())) {
            infoLog("app id is empty ");
            return null;
        }
        IShareResultWithFileListCallback.Stub stub = new IShareResultWithFileListCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.share.LegacyShareApiImpl.5
            @Override // com.samsung.android.sdk.mobileservice.social.share.IShareResultWithFileListCallback
            public void onFailure(long j, String str2) {
                LegacyShareApiImpl legacyShareApiImpl = LegacyShareApiImpl.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestShare onFailure : code=[", "], message=[", str2);
                sbM2225p.append("] ");
                legacyShareApiImpl.infoLog(sbM2225p.toString());
                if (sharedItemWithContentListResultCallback != null) {
                    int iConvertErrorcode = ErrorCodeConvertor.convertErrorcode(j);
                    LegacyShareApiImpl.this.debugLog("requestShare Error Message [" + str2 + "]");
                    sharedItemWithContentListResultCallback.onResult(new SharedItemWithUriListResult(new CommonResultStatus(iConvertErrorcode, str2, Long.toString(j)), null));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.share.IShareResultWithFileListCallback
            public void onProgress(Bundle bundle2) {
                LegacyShareApiImpl.this.debugLog("requestShare onProgress ");
                ShareApi.SharedItemWithContentListResultCallback sharedItemWithContentListResultCallback2 = sharedItemWithContentListResultCallback;
                if (sharedItemWithContentListResultCallback2 != null) {
                    sharedItemWithContentListResultCallback2.onProgress(ShareApiUtil.getInstance(LegacyShareApiImpl.this.getTag(), LegacyShareApiImpl.this.getReference(), LegacyShareApiImpl.this.getAppId()).bundleToShareSnapShot(bundle2));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.share.IShareResultWithFileListCallback
            public void onSuccess(Bundle bundle2) {
                LegacyShareApiImpl.this.infoLog("requestShare IShareResultWithAttachedFilesCallback onSuccess ");
                sharedItemWithContentListResultCallback.onResult(new SharedItemWithUriListResult(new CommonResultStatus(1), new SharedItemWithUriList(bundle2)));
            }

            @Override // com.samsung.android.sdk.mobileservice.social.share.IShareResultWithFileListCallback
            public void onUploadComplete(Bundle bundle2) {
                LegacyShareApiImpl.this.debugLog("requestShare onUploadComplete ");
                ShareApi.SharedItemWithContentListResultCallback sharedItemWithContentListResultCallback2 = sharedItemWithContentListResultCallback;
                if (sharedItemWithContentListResultCallback2 != null) {
                    sharedItemWithContentListResultCallback2.onUploadComplete(ShareApiUtil.getInstance(LegacyShareApiImpl.this.getTag(), LegacyShareApiImpl.this.getReference(), LegacyShareApiImpl.this.getAppId()).bundleToShareSnapShot(bundle2));
                }
            }
        };
        try {
            if (i == 501) {
                Bundle bundle2 = new Bundle();
                bundle2.putInt("featureId", i);
                strRequestShareWithFileList = getSocialService().requestShareWithFileListWithData(getAppId(), str, ShareApiUtil.getInstance(getTag(), getReference(), getAppId()).requestToBundle(sharedItemWithUriListRequest), bundle2, stub, pendingIntent, bundle);
            } else {
                strRequestShareWithFileList = getSocialService().requestShareWithFileList(getAppId(), str, ShareApiUtil.getInstance(getTag(), getReference(), getAppId()).requestToBundle(sharedItemWithUriListRequest), stub, pendingIntent, bundle);
            }
            return new ShareController(this.mApiPicker, strRequestShareWithFileList);
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
}
