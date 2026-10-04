package com.samsung.android.sdk.mobileservice.social.activity;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
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
import com.samsung.android.sdk.mobileservice.social.activity.IActivityBundlePartialResultCallback;
import com.samsung.android.sdk.mobileservice.social.activity.IActivityBundleResultCallback;
import com.samsung.android.sdk.mobileservice.social.activity.IActivityResultCallback;
import com.samsung.android.sdk.mobileservice.social.activity.IDeleteAllActivityResultCallback;
import com.samsung.android.sdk.mobileservice.social.activity.result.ActivityResult;
import com.samsung.android.sdk.mobileservice.social.common.IBundleProgressResultCallback;
import com.samsung.android.sdk.mobileservice.social.group.provider.GroupContract;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class ActivityApi extends SeMobileServiceApi {
    public static final String API_NAME = "ActivityApi";
    private static final int MAX_SIZE_FOR_REQUEST_ACTIVITYLIST = 5;
    public static final int PRIVACY_TYPE_ALL = 0;
    public static final int PRIVACY_TYPE_CONTACTS = 2;
    public static final int PRIVACY_TYPE_NOT_SELECTED = 3;
    public static final int PRIVACY_TYPE_PRIVATE = 1;
    private final int ACTIVITY_TYPE_ALL;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ActivityContentRequest extends ActivityRequest {
        private String mHash;

        public ActivityContentRequest(String str, String str2, int i, String str3) {
            super(str, str2, i);
            this.mHash = str3;
        }

        public String getContentHash() {
            return this.mHash;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ActivityDownloadResultCallback<T> {
        void onPartialResult(T t);

        void onResult(ActivityResult<T> activityResult);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Deprecated
    public interface ActivityImageListResultCallback<T> {
        void onProgress(T t);

        void onResult(ActivityResult<List<T>> activityResult);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ActivityResultCallback<T> {
        void onResult(ActivityResult<T> activityResult);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ClearMyActivityResultCallback {
        void onResult(BooleanResult booleanResult);
    }

    public ActivityApi(SeMobileServiceSession seMobileServiceSession) throws NotAuthorizedException {
        super(seMobileServiceSession, "ActivityApi");
        this.ACTIVITY_TYPE_ALL = -1;
        checkAuthorized(0, 2, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Activity bundleToActivity(Bundle bundle) {
        if (bundle == null) {
            debugLog("bundle is null : bundleToActivity");
            return null;
        }
        String string = bundle.getString("activityId");
        String string2 = bundle.getString("statusMessage", null);
        String string3 = bundle.getString("memo", string2);
        String string4 = bundle.getString("activityType", null);
        return new Activity(string, string3, (string4 == null || !TextUtils.equals(string4, "post")) ? (TextUtils.isEmpty(string3) && TextUtils.isEmpty(string2)) ? 2 : 1 : 4, bundle.getLong(GroupContract.Group.CREATED_TIME, 0L), bundle.getLong("modifiedTime", 0L), bundle.getString("owner"), bundle.getString("ownerName"), bundleToUri(bundle, "activityImageContentUri"), bundleToUri(bundle, "profileImageContentUri"), bundle.getString("meta", null), bundleToContentInfoList(bundle));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ActivityImage bundleToActivityImage(Bundle bundle) {
        if (bundle == null) {
            debugLog("bundle is null : bundleToActivityImage");
            return null;
        }
        return new ActivityImage(bundle.getString("guid"), bundle.getString("activityId"), bundleToUri(bundle, "profileImageContentUri"), bundleToUri(bundle, "activityImageContentUri"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<ActivityImage> bundleToActivityImageList(Bundle bundle) {
        ArrayList arrayList = new ArrayList();
        if (bundle == null) {
            debugLog("bundle is null : bundleToActivityImageList");
            return arrayList;
        }
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("images");
        if (parcelableArrayList != null) {
            Iterator it = parcelableArrayList.iterator();
            while (it.hasNext()) {
                arrayList.add(bundleToActivityImage((Bundle) it.next()));
            }
        }
        debugLog("bundleToActivityImageList size : " + arrayList.size());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<Activity> bundleToActivityList(Bundle bundle) {
        ArrayList arrayList = new ArrayList();
        if (bundle == null) {
            debugLog("bundle is null : bundleToActivityList");
            return arrayList;
        }
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("activities");
        if (parcelableArrayList != null) {
            Iterator it = parcelableArrayList.iterator();
            while (it.hasNext()) {
                arrayList.add(bundleToActivity((Bundle) it.next()));
            }
        }
        debugLog("bundleToActivityList size : " + arrayList.size());
        return arrayList;
    }

    private ContentInfo bundleToContentInfo(Bundle bundle) {
        if (bundle != null) {
            return new ContentInfo(bundle.getString("name"), bundle.getString("hash"), bundle.getLong("size", 0L), bundle.getString("mime"), bundleToUri(bundle, ExternalDataConstants.Column.CONTENT_URI));
        }
        debugLog("bundle is null : bundleToActivityContents");
        return null;
    }

    private List<ContentInfo> bundleToContentInfoList(Bundle bundle) {
        ArrayList arrayList = new ArrayList();
        if (bundle == null) {
            debugLog("bundle is null : bundleToContentInfoList");
            return arrayList;
        }
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("contentsInfo");
        if (parcelableArrayList != null) {
            Iterator it = parcelableArrayList.iterator();
            while (it.hasNext()) {
                arrayList.add(bundleToContentInfo((Bundle) it.next()));
            }
        }
        debugLog("bundleToContentInfoList size : " + arrayList.size());
        return arrayList;
    }

    private CommonResultStatus bundleToResult(Bundle bundle) {
        if (bundle == null) {
            debugLog("bundle is null : bundleToResult");
            return null;
        }
        long j = bundle.getLong("errorCode", -1L);
        if (j == -1) {
            debugLog("not error : bundleToResult");
            return null;
        }
        String string = bundle.getString("errorMessage", null);
        int iConvertErrorcode = ErrorCodeConvertor.convertErrorcode(j);
        return new CommonResultStatus(iConvertErrorcode, string, Long.toString(iConvertErrorcode));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Uri bundleToUri(Bundle bundle, String str) {
        if (bundle == null) {
            debugLog("bundle is null : bundleToUri");
            return null;
        }
        String string = bundle.getString(str, null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return Uri.parse(string);
    }

    private <T> ActivityResult<T> getErrorActivityResult(int i) {
        if (isSupportedSemsAgentVersionMoreThan(i)) {
            return null;
        }
        return new ActivityResult<>(new CommonResultStatus(-7), null);
    }

    private boolean isResultSuccess(CommonResultStatus commonResultStatus) {
        return commonResultStatus == null;
    }

    public int getBuddyActivityCount() {
        debugLog("getBuddyActivityCount");
        return getBuddyActivityCount(null, -1, 3);
    }

    public ActivityResult<List<Activity>> getBuddyActivityList(long j, int i) {
        debugLog("getBuddyActivityList : timestamp=[" + j + "] limit=[" + i + "]");
        return getBuddyActivityList(null, -1, 3, j, i);
    }

    @Override // com.samsung.android.sdk.mobileservice.common.api.SeMobileServiceApi
    public String[] getEssentialServiceNames() {
        return new String[]{"SocialService"};
    }

    @Deprecated
    public int requestActivity(String str, String str2, ActivityDownloadResultCallback<Activity> activityDownloadResultCallback) {
        debugLog("requestActivity : activityId=[" + str2 + "]");
        if (isSupportedSemsAgentVersionMoreThan(1000000000)) {
            return requestActivity(str, str2, 2, activityDownloadResultCallback);
        }
        return -7;
    }

    public int requestActivityContent(ActivityContentRequest activityContentRequest, final ActivityResultCallback<Uri> activityResultCallback) {
        debugLog("requestActivityContent");
        if (!isSupportedSemsAgentVersionMoreThan(CommonConstants.SupportedApiMinVersion.VERSION_10_5)) {
            return -7;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putString("guid", activityContentRequest.getGuid());
            bundle.putString("activityId", activityContentRequest.getActivityId());
            bundle.putInt("activityType", activityContentRequest.getActivityType());
            bundle.putString("hash", activityContentRequest.getContentHash());
            getSocialService().requestActivityContent(bundle, new IActivityBundleResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.activity.ActivityApi.5
                @Override // com.samsung.android.sdk.mobileservice.social.activity.IActivityBundleResultCallback
                public void onFailure(long j, String str) {
                    ActivityApi activityApi = ActivityApi.this;
                    StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestActivityContent onFailure : code=[", "], message=[", str);
                    sbM2225p.append("]");
                    activityApi.debugLog(sbM2225p.toString());
                    if (activityResultCallback != null) {
                        activityResultCallback.onResult(new ActivityResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), str, Long.toString(j)), null));
                    }
                }

                @Override // com.samsung.android.sdk.mobileservice.social.activity.IActivityBundleResultCallback
                public void onSuccess(Bundle bundle2) {
                    ActivityApi.this.debugLog("requestActivityContent onSuccess");
                    if (activityResultCallback != null) {
                        activityResultCallback.onResult(new ActivityResult(new CommonResultStatus(1), ActivityApi.this.bundleToUri(bundle2, ExternalDataConstants.Column.CONTENT_URI)));
                    }
                }
            });
            return 1;
        } catch (NotConnectedException e) {
            secureLog(e);
            return -8;
        } catch (Exception e2) {
            debugLog("requestActivityContent fail");
            secureLog(e2);
            return -1;
        }
    }

    @Deprecated
    public int requestActivityImageList(List<ActivityRequest> list, final ActivityImageListResultCallback<ActivityImage> activityImageListResultCallback) {
        debugLog("requestActivityImageList");
        if (!isSupportedSemsAgentVersionMoreThan(1000000000)) {
            return -7;
        }
        try {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            for (ActivityRequest activityRequest : list) {
                Bundle bundle = new Bundle();
                bundle.putString("guid", activityRequest.getGuid());
                bundle.putString("activityId", activityRequest.getActivityId());
                bundle.putInt("activityType", activityRequest.getActivityType());
                arrayList.add(bundle);
            }
            Bundle bundle2 = new Bundle();
            bundle2.putParcelableArrayList("requestInfo", arrayList);
            getSocialService().requestActivityImageList(bundle2, new IBundleProgressResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.activity.ActivityApi.4
                @Override // com.samsung.android.sdk.mobileservice.social.common.IBundleProgressResultCallback
                public void onFailure(long j, String str) {
                    ActivityApi activityApi = ActivityApi.this;
                    StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestActivityImageList onFailure : code=[", "], message=[", str);
                    sbM2225p.append("]");
                    activityApi.debugLog(sbM2225p.toString());
                    if (activityImageListResultCallback != null) {
                        activityImageListResultCallback.onResult(new ActivityResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), str, Long.toString(j)), null));
                    }
                }

                @Override // com.samsung.android.sdk.mobileservice.social.common.IBundleProgressResultCallback
                public void onProgress(Bundle bundle3) {
                    ActivityApi.this.debugLog("requestActivityImageList onProgress");
                    ActivityImageListResultCallback activityImageListResultCallback2 = activityImageListResultCallback;
                    if (activityImageListResultCallback2 != null) {
                        activityImageListResultCallback2.onProgress(ActivityApi.this.bundleToActivityImage(bundle3));
                    }
                }

                @Override // com.samsung.android.sdk.mobileservice.social.common.IBundleProgressResultCallback
                public void onSuccess(Bundle bundle3) {
                    ActivityApi.this.debugLog("requestActivityImageList onSuccess");
                    ActivityImageListResultCallback activityImageListResultCallback2 = activityImageListResultCallback;
                    if (activityImageListResultCallback2 != null) {
                        activityImageListResultCallback2.onResult(new ActivityResult(new CommonResultStatus(1), ActivityApi.this.bundleToActivityImageList(bundle3)));
                    }
                }
            });
            return 1;
        } catch (NotConnectedException e) {
            debugLog("requestActivityImageList fail");
            secureLog(e);
            return -8;
        } catch (Exception e2) {
            debugLog("requestActivityImageList fail");
            secureLog(e2);
            return -1;
        }
    }

    public int requestActivityList(String str, long j, ActivityDownloadResultCallback<List<Activity>> activityDownloadResultCallback) {
        debugLog("requestActivityList : timestamp:" + j);
        if (isSupportedSemsAgentVersionMoreThan(1000000000)) {
            return requestActivityList(str, j, 5, activityDownloadResultCallback);
        }
        return -7;
    }

    public int requestActivitySync(final ActivityDownloadResultCallback<Boolean> activityDownloadResultCallback) {
        debugLog("requestActivitySync with ActivityDownloadResultCallback");
        if (!isSupportedSemsAgentVersionMoreThan(1000000000)) {
            return -7;
        }
        try {
            getSocialService().requestActivityChanges(new IActivityBundlePartialResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.activity.ActivityApi.9
                @Override // com.samsung.android.sdk.mobileservice.social.activity.IActivityBundlePartialResultCallback
                public void onFailure(long j, String str) {
                    ActivityApi activityApi = ActivityApi.this;
                    StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestActivitySync onFailure : code=[", "], message=[", str);
                    sbM2225p.append("]");
                    activityApi.debugLog(sbM2225p.toString());
                    if (activityDownloadResultCallback != null) {
                        activityDownloadResultCallback.onResult(new ActivityResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), str, Long.toString(j)), Boolean.FALSE));
                    }
                }

                @Override // com.samsung.android.sdk.mobileservice.social.activity.IActivityBundlePartialResultCallback
                public void onPartialResult(Bundle bundle) {
                    ActivityApi.this.debugLog("requestActivitySync onPartialResult");
                    ActivityDownloadResultCallback activityDownloadResultCallback2 = activityDownloadResultCallback;
                    if (activityDownloadResultCallback2 != null) {
                        activityDownloadResultCallback2.onPartialResult(Boolean.TRUE);
                    }
                }

                @Override // com.samsung.android.sdk.mobileservice.social.activity.IActivityBundlePartialResultCallback
                public void onSuccess(Bundle bundle) {
                    ActivityApi.this.debugLog("requestActivitySync onSuccess");
                    ActivityDownloadResultCallback activityDownloadResultCallback2 = activityDownloadResultCallback;
                    if (activityDownloadResultCallback2 != null) {
                        activityDownloadResultCallback2.onResult(new ActivityResult(new CommonResultStatus(1), Boolean.TRUE));
                    }
                }
            });
            return 1;
        } catch (NotConnectedException e) {
            secureLog(e);
            return -8;
        } catch (Exception e2) {
            secureLog(e2);
            return -1;
        }
    }

    @Deprecated
    public int requestMyActivityClear(final ClearMyActivityResultCallback clearMyActivityResultCallback) {
        debugLog("requestMyActivityClear started");
        try {
            getSocialService().requestDeleteAllActivity(new IDeleteAllActivityResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.activity.ActivityApi.1
                @Override // com.samsung.android.sdk.mobileservice.social.activity.IDeleteAllActivityResultCallback
                public void onFailure(int i, String str) {
                    ActivityApi.this.debugLog("requestMyActivityClear onFailure");
                    if (clearMyActivityResultCallback != null) {
                        int iConvertErrorcode = ErrorCodeConvertor.convertErrorcode(i);
                        ActivityApi activityApi = ActivityApi.this;
                        StringBuilder sbM1173s = AbstractC0622a.m1173s(iConvertErrorcode, i, "requestDeleteAllActivity onFailure (", SQLKeyword.COMMA, SQLKeyword.COMMA);
                        sbM1173s.append(str);
                        sbM1173s.append(")");
                        activityApi.debugLog(sbM1173s.toString());
                        clearMyActivityResultCallback.onResult(new BooleanResult(new CommonResultStatus(iConvertErrorcode, str, Integer.toString(i)), false));
                    }
                }

                @Override // com.samsung.android.sdk.mobileservice.social.activity.IDeleteAllActivityResultCallback
                public void onSuccess() {
                    ActivityApi.this.debugLog("requestMyActivityClear onSuccess");
                    ClearMyActivityResultCallback clearMyActivityResultCallback2 = clearMyActivityResultCallback;
                    if (clearMyActivityResultCallback2 != null) {
                        clearMyActivityResultCallback2.onResult(new BooleanResult(new CommonResultStatus(1), true));
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

    @Deprecated
    public int requestMyActivityDeletion(String str, ActivityResultCallback<Boolean> activityResultCallback) {
        return requestMyActivityDeletion(str, 2, activityResultCallback);
    }

    public int requestMyActivityPrivacyType(final ActivityResultCallback<Integer> activityResultCallback) {
        debugLog("requestMyActivityPrivacyType");
        if (!isSupportedSemsAgentVersionMoreThan(1000000000)) {
            return -7;
        }
        try {
            getSocialService().requestMyActivityPrivacy(new IActivityBundleResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.activity.ActivityApi.8
                @Override // com.samsung.android.sdk.mobileservice.social.activity.IActivityBundleResultCallback
                public void onFailure(long j, String str) {
                    ActivityApi activityApi = ActivityApi.this;
                    StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestMyActivityPrivacyType onFailure : code=[", "], message=[", str);
                    sbM2225p.append("]");
                    activityApi.debugLog(sbM2225p.toString());
                    if (activityResultCallback != null) {
                        activityResultCallback.onResult(new ActivityResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), str, Long.toString(j)), null));
                    }
                }

                @Override // com.samsung.android.sdk.mobileservice.social.activity.IActivityBundleResultCallback
                public void onSuccess(Bundle bundle) {
                    ActivityApi.this.debugLog("requestMyActivityPrivacyType onSuccess");
                    if (activityResultCallback != null) {
                        activityResultCallback.onResult(new ActivityResult(new CommonResultStatus(1), bundle != null ? Integer.valueOf(bundle.getInt("privacyType")) : null));
                    }
                }
            });
            return 1;
        } catch (NotConnectedException e) {
            secureLog(e);
            return -8;
        } catch (Exception e2) {
            secureLog(e2);
            return -1;
        }
    }

    public int requestMyActivityPrivacyTypeUpdate(int i, int i2, final ActivityResultCallback<Boolean> activityResultCallback) {
        debugLog("requestMyActivityPrivacyTypeUpdate");
        if (!isSupportedSemsAgentVersionMoreThan(1000000000)) {
            return -7;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("privacyType", i);
            bundle.putInt("oldPrivacyType", i2);
            getSocialService().requestMyActivityPrivacyUpdate(bundle, new IActivityResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.activity.ActivityApi.7
                @Override // com.samsung.android.sdk.mobileservice.social.activity.IActivityResultCallback
                public void onFailure(long j, String str) {
                    ActivityApi activityApi = ActivityApi.this;
                    StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestMyActivityPrivacyTypeUpdate onFailure : code=[", "], message=[", str);
                    sbM2225p.append("]");
                    activityApi.debugLog(sbM2225p.toString());
                    if (activityResultCallback != null) {
                        activityResultCallback.onResult(new ActivityResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), str, Long.toString(j)), Boolean.FALSE));
                    }
                }

                @Override // com.samsung.android.sdk.mobileservice.social.activity.IActivityResultCallback
                public void onSuccess() {
                    ActivityApi.this.debugLog("requestMyActivityPrivacyTypeUpdate onSuccess");
                    ActivityResultCallback activityResultCallback2 = activityResultCallback;
                    if (activityResultCallback2 != null) {
                        activityResultCallback2.onResult(new ActivityResult(new CommonResultStatus(1), Boolean.TRUE));
                    }
                }
            });
            return 1;
        } catch (NotConnectedException e) {
            secureLog(e);
            return -8;
        } catch (Exception e2) {
            secureLog(e2);
            return -1;
        }
    }

    public int setAllBuddyActivityListRead() {
        debugLog("setAllBuddyActivityListRead");
        if (!isSupportedSemsAgentVersionMoreThan(1000000000)) {
            return -7;
        }
        try {
            if (isResultSuccess(bundleToResult(getSocialService().setBuddyActivityListRead(new Bundle())))) {
                debugLog("setAllBuddyActivityListRead success");
                return 1;
            }
            debugLog("setAllBuddyActivityListRead fail");
            return -1;
        } catch (NotConnectedException e) {
            debugLog("setAllBuddyActivityListRead fail");
            secureLog(e);
            return -8;
        } catch (Exception e2) {
            debugLog("setAllBuddyActivityListRead fail");
            secureLog(e2);
            return -1;
        }
    }

    public int setBuddyActivityListRead(List<ActivityRequest> list) {
        debugLog("setBuddyActivityListRead");
        if (!isSupportedSemsAgentVersionMoreThan(1000000000)) {
            return -7;
        }
        try {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            for (ActivityRequest activityRequest : list) {
                Bundle bundle = new Bundle();
                bundle.putString("guid", activityRequest.getGuid());
                bundle.putString("activityId", activityRequest.getActivityId());
                arrayList.add(bundle);
            }
            Bundle bundle2 = new Bundle();
            bundle2.putParcelableArrayList("requestInfo", arrayList);
            if (isResultSuccess(bundleToResult(getSocialService().setBuddyActivityListRead(bundle2)))) {
                debugLog("setBuddyActivityListRead success");
                return 1;
            }
            debugLog("setBuddyActivityListRead fail");
            return -1;
        } catch (NotConnectedException e) {
            debugLog("setBuddyActivityListRead fail");
            secureLog(e);
            return -8;
        } catch (Exception e2) {
            debugLog("setBuddyActivityListRead fail");
            secureLog(e2);
            return -1;
        }
    }

    public int requestMyActivityDeletion(String str, int i, final ActivityResultCallback<Boolean> activityResultCallback) {
        debugLog("requestMyActivityDeletion : activityId=[" + str + "]");
        if (!isSupportedSemsAgentVersionMoreThan(1000000000)) {
            return -7;
        }
        if (TextUtils.isEmpty(str)) {
            debugLog("activityId is empty");
            return -1;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putString("activityId", str);
            bundle.putInt("activityType", i);
            getSocialService().requestActivityDeletion(bundle, new IActivityResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.activity.ActivityApi.6
                @Override // com.samsung.android.sdk.mobileservice.social.activity.IActivityResultCallback
                public void onFailure(long j, String str2) {
                    ActivityApi.this.debugLog("requestMyActivityDeletion onFailure");
                    if (activityResultCallback != null) {
                        int iConvertErrorcode = ErrorCodeConvertor.convertErrorcode(j);
                        ActivityApi.this.debugLog("requestMyActivityDeletion onFailure (" + iConvertErrorcode + SQLKeyword.COMMA + j + SQLKeyword.COMMA + str2 + ")");
                        activityResultCallback.onResult(new ActivityResult(new CommonResultStatus(iConvertErrorcode, str2, Long.toString(j)), Boolean.FALSE));
                    }
                }

                @Override // com.samsung.android.sdk.mobileservice.social.activity.IActivityResultCallback
                public void onSuccess() {
                    ActivityApi.this.debugLog("requestMyActivityDeletion onSuccess");
                    ActivityResultCallback activityResultCallback2 = activityResultCallback;
                    if (activityResultCallback2 != null) {
                        activityResultCallback2.onResult(new ActivityResult(new CommonResultStatus(1), Boolean.TRUE));
                    }
                }
            });
            return 1;
        } catch (NotConnectedException e) {
            secureLog(e);
            return -8;
        } catch (Exception e2) {
            secureLog(e2);
            return -1;
        }
    }

    public int getBuddyActivityCount(int i, int i2) {
        debugLog(AbstractC0622a.m1164j(i, i2, "getBuddyActivityCount : activityType=[", "] readType=[", "]"));
        return getBuddyActivityCount(null, i, i2);
    }

    public ActivityResult<List<Activity>> getBuddyActivityList(int i, int i2, long j, int i4) {
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i2, "getBuddyActivityList : activityType=[", "] readType=[", "] timestamp=[");
        sbM1173s.append(j);
        sbM1173s.append("] limit=[");
        sbM1173s.append(i4);
        sbM1173s.append("]");
        debugLog(sbM1173s.toString());
        return getBuddyActivityList(null, i, i2, j, i4);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ActivityRequest {
        private String mActivityId;
        private int mActivityType;
        private String mGuid;

        public ActivityRequest(String str, String str2) {
            this.mGuid = str;
            this.mActivityId = str2;
            this.mActivityType = 2;
        }

        public String getActivityId() {
            return this.mActivityId;
        }

        public int getActivityType() {
            return this.mActivityType;
        }

        public String getGuid() {
            return this.mGuid;
        }

        public ActivityRequest(String str, String str2, int i) {
            this.mGuid = str;
            this.mActivityId = str2;
            this.mActivityType = i;
        }
    }

    public int requestActivity(String str, String str2, int i, final ActivityDownloadResultCallback<Activity> activityDownloadResultCallback) {
        debugLog("requestActivity : activityId=[" + str2 + "]");
        if (!isSupportedSemsAgentVersionMoreThan(1000000000)) {
            return -7;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                Bundle bundle = new Bundle();
                bundle.putString("guid", str);
                bundle.putString("activityId", str2);
                bundle.putInt("activityType", i);
                getSocialService().requestActivity(bundle, new IActivityBundlePartialResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.activity.ActivityApi.3
                    @Override // com.samsung.android.sdk.mobileservice.social.activity.IActivityBundlePartialResultCallback
                    public void onFailure(long j, String str3) {
                        ActivityApi activityApi = ActivityApi.this;
                        StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestActivity onFailure : code=[", "], message=[", str3);
                        sbM2225p.append("]");
                        activityApi.debugLog(sbM2225p.toString());
                        if (activityDownloadResultCallback != null) {
                            activityDownloadResultCallback.onResult(new ActivityResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), str3, Long.toString(j)), null));
                        }
                    }

                    @Override // com.samsung.android.sdk.mobileservice.social.activity.IActivityBundlePartialResultCallback
                    public void onPartialResult(Bundle bundle2) {
                        ActivityApi.this.debugLog("requestActivity onPartialResult");
                        ActivityDownloadResultCallback activityDownloadResultCallback2 = activityDownloadResultCallback;
                        if (activityDownloadResultCallback2 != null) {
                            activityDownloadResultCallback2.onPartialResult(ActivityApi.this.bundleToActivity(bundle2));
                        }
                    }

                    @Override // com.samsung.android.sdk.mobileservice.social.activity.IActivityBundlePartialResultCallback
                    public void onSuccess(Bundle bundle2) {
                        ActivityApi.this.debugLog("requestActivity onSuccess");
                        ActivityDownloadResultCallback activityDownloadResultCallback2 = activityDownloadResultCallback;
                        if (activityDownloadResultCallback2 != null) {
                            activityDownloadResultCallback2.onResult(new ActivityResult(new CommonResultStatus(1), ActivityApi.this.bundleToActivity(bundle2)));
                        }
                    }
                });
                return 1;
            } catch (NotConnectedException e) {
                secureLog(e);
                return -8;
            } catch (Exception e2) {
                secureLog(e2);
                return -1;
            }
        }
        debugLog("guid or activityId is empty");
        return -1;
    }

    @Deprecated
    public int requestActivityList(String str, long j, int i, final ActivityDownloadResultCallback<List<Activity>> activityDownloadResultCallback) {
        debugLog("requestActivityList : timestamp:" + j + ", limit:" + i);
        if (!isSupportedSemsAgentVersionMoreThan(1000000000)) {
            return -7;
        }
        if (TextUtils.isEmpty(str)) {
            debugLog("guid is empty");
            return -1;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putString("guid", str);
            if (j > 0) {
                bundle.putLong("timestamp", j);
            }
            if (i <= 0) {
                i = 5;
            }
            bundle.putInt("limit", i);
            getSocialService().requestActivityList(bundle, new IActivityBundlePartialResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.activity.ActivityApi.2
                @Override // com.samsung.android.sdk.mobileservice.social.activity.IActivityBundlePartialResultCallback
                public void onFailure(long j2, String str2) {
                    ActivityApi activityApi = ActivityApi.this;
                    StringBuilder sbM2225p = AbstractC2821a.m2225p(j2, "requestActivityList onFailure : code=[", "], message=[", str2);
                    sbM2225p.append("]");
                    activityApi.debugLog(sbM2225p.toString());
                    if (activityDownloadResultCallback != null) {
                        activityDownloadResultCallback.onResult(new ActivityResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j2), str2, Long.toString(j2)), null));
                    }
                }

                @Override // com.samsung.android.sdk.mobileservice.social.activity.IActivityBundlePartialResultCallback
                public void onPartialResult(Bundle bundle2) {
                    ActivityApi.this.debugLog("requestActivityList onPartialResult");
                    if (activityDownloadResultCallback != null) {
                        activityDownloadResultCallback.onPartialResult(ActivityApi.this.bundleToActivityList(bundle2));
                    }
                }

                @Override // com.samsung.android.sdk.mobileservice.social.activity.IActivityBundlePartialResultCallback
                public void onSuccess(Bundle bundle2) {
                    ActivityApi.this.debugLog("requestActivityList onSuccess");
                    if (activityDownloadResultCallback != null) {
                        activityDownloadResultCallback.onResult(new ActivityResult(new CommonResultStatus(1), ActivityApi.this.bundleToActivityList(bundle2)));
                    }
                }
            });
            return 1;
        } catch (NotConnectedException e) {
            secureLog(e);
            return -8;
        } catch (Exception e2) {
            secureLog(e2);
            return -1;
        }
    }

    @Deprecated
    public int requestActivitySync(final ActivityResultCallback<Boolean> activityResultCallback) {
        debugLog("requestActivitySync");
        if (!isSupportedSemsAgentVersionMoreThan(1000000000)) {
            return -7;
        }
        try {
            getSocialService().requestActivitySync(new IActivityBundleResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.activity.ActivityApi.10
                @Override // com.samsung.android.sdk.mobileservice.social.activity.IActivityBundleResultCallback
                public void onFailure(long j, String str) {
                    ActivityApi activityApi = ActivityApi.this;
                    StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestActivitySync onFailure : code=[", "], message=[", str);
                    sbM2225p.append("]");
                    activityApi.debugLog(sbM2225p.toString());
                    if (activityResultCallback != null) {
                        activityResultCallback.onResult(new ActivityResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), str, Long.toString(j)), Boolean.FALSE));
                    }
                }

                @Override // com.samsung.android.sdk.mobileservice.social.activity.IActivityBundleResultCallback
                public void onSuccess(Bundle bundle) {
                    ActivityApi.this.debugLog("requestActivitySync onSuccess");
                    ActivityResultCallback activityResultCallback2 = activityResultCallback;
                    if (activityResultCallback2 != null) {
                        activityResultCallback2.onResult(new ActivityResult(new CommonResultStatus(1), Boolean.TRUE));
                    }
                }
            });
            return 1;
        } catch (NotConnectedException e) {
            secureLog(e);
            return -8;
        } catch (Exception e2) {
            secureLog(e2);
            return -1;
        }
    }

    public ActivityResult<List<Activity>> getBuddyActivityList(String str, int i, int i2, long j, int i4) {
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i2, "getBuddyActivityList : activityType=[", "] readType=[", "] timestamp=[");
        sbM1173s.append(j);
        sbM1173s.append("] limit=[");
        sbM1173s.append(i4);
        sbM1173s.append("]");
        debugLog(sbM1173s.toString());
        ActivityResult<List<Activity>> errorActivityResult = getErrorActivityResult(1000000000);
        if (errorActivityResult != null) {
            return errorActivityResult;
        }
        try {
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(str)) {
                bundle.putString("guid", str);
            }
            if (i != -1) {
                bundle.putInt("activityType", i);
            }
            bundle.putInt("readType", i2);
            if (j > 0) {
                bundle.putLong("timestamp", j);
            }
            if (i4 > 0) {
                bundle.putInt("limit", i4);
            }
            Bundle buddyActivityList = getSocialService().getBuddyActivityList(bundle);
            CommonResultStatus commonResultStatusBundleToResult = bundleToResult(buddyActivityList);
            if (isResultSuccess(commonResultStatusBundleToResult)) {
                debugLog("getBuddyActivityList success");
                return new ActivityResult<>(new CommonResultStatus(1), bundleToActivityList(buddyActivityList));
            }
            debugLog("getBuddyActivityList fail");
            return new ActivityResult<>(commonResultStatusBundleToResult, null);
        } catch (NotConnectedException e) {
            debugLog("getBuddyActivityList fail");
            secureLog(e);
            return new ActivityResult<>(new CommonResultStatus(-8), null);
        } catch (Exception e2) {
            debugLog("getBuddyActivityList fail");
            secureLog(e2);
            return new ActivityResult<>(new CommonResultStatus(-1), null);
        }
    }

    public int getBuddyActivityCount(String str, int i, int i2) {
        debugLog(AbstractC0622a.m1164j(i, i2, "getBuddyActivityCount : activityType=[", "] readType=[", "]"));
        if (!isSupportedSemsAgentVersionMoreThan(CommonConstants.SupportedApiMinVersion.VERSION_10_1)) {
            return -7;
        }
        try {
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(str)) {
                bundle.putString("guid", str);
            }
            if (i != -1) {
                bundle.putInt("activityType", i);
            }
            bundle.putInt("readType", i2);
            Bundle buddyActivityCount = getSocialService().getBuddyActivityCount(bundle);
            if (isResultSuccess(bundleToResult(buddyActivityCount))) {
                int i4 = buddyActivityCount.getInt("totalCount", -1);
                debugLog("getBuddyActivityCount success - totalCount:" + i4);
                return i4;
            }
            debugLog("getBuddyActivityCount fail");
            return -1;
        } catch (NotConnectedException e) {
            debugLog("getBuddyActivityCount fail");
            secureLog(e);
            return -8;
        } catch (Exception e2) {
            debugLog("getBuddyActivityCount fail");
            secureLog(e2);
            return -1;
        }
    }
}
