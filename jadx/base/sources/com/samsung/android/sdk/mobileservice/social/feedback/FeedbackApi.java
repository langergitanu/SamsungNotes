package com.samsung.android.sdk.mobileservice.social.feedback;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.glance.AbstractC2821a;
import com.samsung.android.sdk.mobileservice.SeMobileServiceSession;
import com.samsung.android.sdk.mobileservice.common.ErrorCodeConvertor;
import com.samsung.android.sdk.mobileservice.common.api.SeMobileServiceApi;
import com.samsung.android.sdk.mobileservice.common.exception.NotAuthorizedException;
import com.samsung.android.sdk.mobileservice.common.exception.NotConnectedException;
import com.samsung.android.sdk.mobileservice.common.result.CommonResultStatus;
import com.samsung.android.sdk.mobileservice.social.common.IBundleProgressResultCallback;
import com.samsung.android.sdk.mobileservice.social.feedback.EmotionMemberList;
import com.samsung.android.sdk.mobileservice.social.feedback.IFeedbackBundlePartialResultCallback;
import com.samsung.android.sdk.mobileservice.social.feedback.IFeedbackBundleResultCallback;
import com.samsung.android.sdk.mobileservice.social.feedback.result.FeedbackResult;
import com.samsung.android.sdk.mobileservice.social.group.provider.GroupContract;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.common.HandoffConstant;
import cz.msebera.android.httpclient.cookie.ClientCookie;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class FeedbackApi extends SeMobileServiceApi {
    public static final String API_NAME = "FeedbackApi";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface FeedbackDownloadResultCallback<T> {
        void onPartialResult(T t);

        void onResult(FeedbackResult<T> feedbackResult);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface FeedbackResultCallback<T> {
        void onResult(FeedbackResult<T> feedbackResult);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ProfileImageListResultCallback<T> {
        void onProgress(T t);

        void onResult(FeedbackResult<List<T>> feedbackResult);
    }

    public FeedbackApi(SeMobileServiceSession seMobileServiceSession) throws NotAuthorizedException {
        super(seMobileServiceSession, "FeedbackApi");
        checkAuthorized(0, 2, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T extends ContentId> EmotionMemberList<T> bundleToActivityEmotionMemberList(T t, String str, Bundle bundle) {
        if (bundle == null) {
            debugLog("bundle is null : bundleToActivityEmotionMemberList");
            return null;
        }
        String string = bundle.getString("nextMemberGuid");
        ArrayList arrayList = new ArrayList();
        ArrayList<Bundle> parcelableArrayList = bundle.getParcelableArrayList("members");
        if (parcelableArrayList != null) {
            for (Bundle bundle2 : parcelableArrayList) {
                String string2 = bundle2.getString("memberName", null);
                String string3 = bundle2.getString("memberId");
                long j = bundle2.getLong("updateTime", 0L);
                int i = bundle2.getInt("emotionType", 0);
                String string4 = bundle2.getString("profileImageContentUri", null);
                arrayList.add(new EmotionMemberList.EmotionMember(new UserProfile(string3, string2, !TextUtils.isEmpty(string4) ? Uri.parse(string4) : null), j, i));
            }
        }
        debugLog("bundleToActivityEmotionMemberList size : " + arrayList.size());
        return new EmotionMemberList<>(t, str, string, arrayList);
    }

    private Comment bundleToComment(Bundle bundle) {
        if (bundle == null) {
            debugLog("bundle is null : bundleToComment");
            return null;
        }
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("emotions");
        ArrayList arrayList = new ArrayList();
        if (parcelableArrayList != null) {
            Iterator it = parcelableArrayList.iterator();
            while (it.hasNext()) {
                arrayList.add(bundleToEmotion((Bundle) it.next()));
            }
        }
        String string = bundle.getString("commentId");
        String string2 = bundle.getString(ClientCookie.COMMENT_ATTR);
        String string3 = bundle.getString(GroupContract.Group.LEADER_ID);
        String string4 = bundle.getString("ownerName", null);
        long j = bundle.getLong(GroupContract.Group.CREATED_TIME, 0L);
        int i = bundle.getInt("myEmotionType", -1);
        String string5 = bundle.getString("profileImageContentUri", null);
        return new Comment(string, string2, new UserProfile(string3, string4, TextUtils.isEmpty(string5) ? null : Uri.parse(string5)), j, new EmotionList(i, arrayList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CommentList bundleToCommentList(Bundle bundle) {
        if (bundle == null) {
            debugLog("bundle is null : bundleToCommentList");
            return null;
        }
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("comments");
        ArrayList arrayList = new ArrayList();
        if (parcelableArrayList != null) {
            Iterator it = parcelableArrayList.iterator();
            while (it.hasNext()) {
                arrayList.add(bundleToComment((Bundle) it.next()));
            }
        }
        String string = bundle.getString("nextCommentId", null);
        debugLog("bundleToCommentList size : " + arrayList.size());
        return new CommentList(string, arrayList);
    }

    private ContentId bundleToContentId(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        if (bundle.getInt("contentIdType", -1) == 1) {
            return new ActivityContentId(bundle);
        }
        debugLog("bundleToContentId is error" + bundle.getInt("contentIdType", -1));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Emotion bundleToEmotion(Bundle bundle) {
        if (bundle != null) {
            return new Emotion(bundle.getInt("emotionType", 0), bundle.getInt("count", 0));
        }
        debugLog("bundle is null : bundleToEmotion");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Feedback<?> bundleToFeedback(Bundle bundle) {
        if (bundle == null) {
            debugLog("bundle is null : bundleToActivityFeedback");
            return null;
        }
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("comments");
        ArrayList arrayList = new ArrayList();
        if (parcelableArrayList != null) {
            Iterator it = parcelableArrayList.iterator();
            while (it.hasNext()) {
                arrayList.add(bundleToComment((Bundle) it.next()));
            }
        }
        ArrayList parcelableArrayList2 = bundle.getParcelableArrayList("emotions");
        ArrayList arrayList2 = new ArrayList();
        if (parcelableArrayList2 != null) {
            Iterator it2 = parcelableArrayList2.iterator();
            while (it2.hasNext()) {
                arrayList2.add(bundleToEmotion((Bundle) it2.next()));
            }
        }
        ContentId contentIdBundleToContentId = bundleToContentId(bundle);
        int i = bundle.getInt("myEmotionType", -1);
        return new Feedback<>(contentIdBundleToContentId, new EmotionList(i, arrayList2), bundle.getInt("commentCount"), new CommentList(bundle.getString("nextCommentId"), arrayList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T extends ContentId> List<Feedback<T>> bundleToFeedbackList(Bundle bundle, List<Feedback<T>> list) {
        if (bundle == null) {
            debugLog("bundle is null : bundleToActivityFeedback");
            return null;
        }
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("activities");
        if (parcelableArrayList != null) {
            Iterator it = parcelableArrayList.iterator();
            while (it.hasNext()) {
                list.add(bundleToFeedback((Bundle) it.next()));
            }
        }
        debugLog("bundleToFeedbackList size : " + list.size());
        return list;
    }

    private List<Notification<?>> bundleToNotificationList(Bundle bundle) {
        if (bundle == null) {
            debugLog("bundle is null : bundleToNotificationList");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList<Bundle> parcelableArrayList = bundle.getParcelableArrayList("notifications");
        if (parcelableArrayList != null) {
            for (Bundle bundle2 : parcelableArrayList) {
                String string = bundle2.getString("notificationId");
                String string2 = bundle2.getString("senderGuid");
                String string3 = bundle2.getString(HandoffConstant.KEY_SENDER_NAME, null);
                ContentId contentIdBundleToContentId = bundleToContentId(bundle2);
                String string4 = bundle2.getString("commentId", null);
                String string5 = bundle2.getString(ClientCookie.COMMENT_ATTR, null);
                int i = bundle2.getInt("emotionType", -1);
                int i2 = Notification.FEEDBACK_TYPE_COMMENT;
                if (bundle2.containsKey("emotionType")) {
                    i2 = Notification.FEEDBACK_TYPE_EMOTION;
                }
                long j = bundle2.getLong("timestamp", 0L);
                String string6 = bundle2.getString("profileImageContentUri", null);
                arrayList.add(new Notification(contentIdBundleToContentId, string, i2, new UserProfile(string2, string3, !TextUtils.isEmpty(string6) ? Uri.parse(string6) : null), string4, string5, i, j));
            }
        }
        debugLog("bundleToNotificationList size : " + arrayList.size());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public UserProfile bundleToProfileImage(Bundle bundle) {
        if (bundle == null) {
            debugLog("bundle is null : bundleToProfileImage");
            return null;
        }
        String string = bundle.getString("guid");
        String string2 = bundle.getString("profileImageContentUri", null);
        return new UserProfile(string, TextUtils.isEmpty(string2) ? null : Uri.parse(string2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<UserProfile> bundleToProfileImageList(Bundle bundle) {
        if (bundle == null) {
            debugLog("bundle is null : bundleToProfileImageList");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("images");
        if (parcelableArrayList != null) {
            Iterator it = parcelableArrayList.iterator();
            while (it.hasNext()) {
                arrayList.add(bundleToProfileImage((Bundle) it.next()));
            }
        }
        debugLog("bundleToImageList size : " + arrayList.size());
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

    private <T> FeedbackResult<T> getErrorFeedbackResult(int i) {
        if (isSupportedSemsAgentVersionMoreThan(i)) {
            return null;
        }
        return new FeedbackResult<>(new CommonResultStatus(-7), null);
    }

    private boolean isResultSuccess(CommonResultStatus commonResultStatus) {
        return commonResultStatus == null;
    }

    @Override // com.samsung.android.sdk.mobileservice.common.api.SeMobileServiceApi
    public String[] getEssentialServiceNames() {
        return new String[]{"SocialService"};
    }

    public FeedbackResult<List<Notification<?>>> getNotificationList(int i, boolean z) {
        debugLog("getNotificationList");
        FeedbackResult<List<Notification<?>>> errorFeedbackResult = getErrorFeedbackResult(1000000000);
        if (errorFeedbackResult != null) {
            return errorFeedbackResult;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("contentIdType", i);
            bundle.putBoolean("requestClear", z);
            Bundle notification = getSocialService().getNotification(bundle);
            CommonResultStatus commonResultStatusBundleToResult = bundleToResult(notification);
            if (!isResultSuccess(commonResultStatusBundleToResult)) {
                debugLog("getNotificationList fail");
                return new FeedbackResult<>(commonResultStatusBundleToResult, null);
            }
            debugLog("getNotificationList success ");
            return new FeedbackResult<>(new CommonResultStatus(1), bundleToNotificationList(notification));
        } catch (NotConnectedException e) {
            secureLog(e);
            return new FeedbackResult<>(new CommonResultStatus(-8), null);
        } catch (Exception e2) {
            secureLog(e2);
            return new FeedbackResult<>(new CommonResultStatus(-1), null);
        }
    }

    public <T extends ContentId> int requestCommentCreation(T t, String str, final FeedbackResultCallback<String> feedbackResultCallback) {
        debugLog("requestCommentCreation : contentId =[" + t + "]");
        if (!isSupportedSemsAgentVersionMoreThan(1000000000)) {
            return -7;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putBundle("contentId", t.toBundle());
            bundle.putString(ClientCookie.COMMENT_ATTR, str);
            getSocialService().requestCommentCreation(bundle, new IFeedbackBundleResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.feedback.FeedbackApi.3
                @Override // com.samsung.android.sdk.mobileservice.social.feedback.IFeedbackBundleResultCallback
                public void onFailure(long j, String str2) {
                    FeedbackApi feedbackApi = FeedbackApi.this;
                    StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestCommentCreation onFailure : code=[", "], message=[", str2);
                    sbM2225p.append("] ");
                    feedbackApi.debugLog(sbM2225p.toString());
                    if (feedbackResultCallback != null) {
                        feedbackResultCallback.onResult(new FeedbackResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), str2, Long.toString(j)), null));
                    }
                }

                @Override // com.samsung.android.sdk.mobileservice.social.feedback.IFeedbackBundleResultCallback
                public void onSuccess(Bundle bundle2) {
                    FeedbackApi.this.debugLog("requestCommentCreation onSuccess ");
                    if (feedbackResultCallback != null) {
                        feedbackResultCallback.onResult(new FeedbackResult(new CommonResultStatus(1), bundle2.getString("commentId")));
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

    public <T extends ContentId> int requestCommentDeletion(T t, String str, final FeedbackResultCallback<Boolean> feedbackResultCallback) {
        debugLog("requestCommentDeletion : contentId=[" + t + "] commentId=[" + str + "] ");
        if (!isSupportedSemsAgentVersionMoreThan(1000000000)) {
            return -7;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putBundle("contentId", t.toBundle());
            bundle.putString("commentId", str);
            getSocialService().requestCommentDeletion(bundle, new IFeedbackBundleResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.feedback.FeedbackApi.5
                @Override // com.samsung.android.sdk.mobileservice.social.feedback.IFeedbackBundleResultCallback
                public void onFailure(long j, String str2) {
                    FeedbackApi feedbackApi = FeedbackApi.this;
                    StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestCommentDeletion onFailure : code=[", "], message=[", str2);
                    sbM2225p.append("] ");
                    feedbackApi.debugLog(sbM2225p.toString());
                    if (feedbackResultCallback != null) {
                        feedbackResultCallback.onResult(new FeedbackResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), str2, Long.toString(j)), Boolean.FALSE));
                    }
                }

                @Override // com.samsung.android.sdk.mobileservice.social.feedback.IFeedbackBundleResultCallback
                public void onSuccess(Bundle bundle2) {
                    FeedbackApi.this.debugLog("requestCommentDeletion onSuccess ");
                    FeedbackResultCallback feedbackResultCallback2 = feedbackResultCallback;
                    if (feedbackResultCallback2 != null) {
                        feedbackResultCallback2.onResult(new FeedbackResult(new CommonResultStatus(1), Boolean.TRUE));
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

    public <T extends ContentId> int requestCommentList(T t, int i, FeedbackDownloadResultCallback<CommentList> feedbackDownloadResultCallback) {
        debugLog("requestCommentList : contentId=[" + t + "] ");
        return requestCommentList(t, i, null, feedbackDownloadResultCallback);
    }

    public <T extends ContentId> int requestEmotionCancellation(T t, int i, FeedbackResultCallback<Emotion> feedbackResultCallback) {
        debugLog("requestEmotionCancellation : contentId=[" + t + "] previousEmotionType=[" + i + "] ");
        return requestEmotionCancellation(t, null, i, feedbackResultCallback);
    }

    public <T extends ContentId> int requestEmotionMemberList(T t, int i, FeedbackDownloadResultCallback<EmotionMemberList<T>> feedbackDownloadResultCallback) {
        debugLog("requestEmotionMemberList : contentId=[" + t + "] ");
        return requestEmotionMemberList(t, null, i, null, feedbackDownloadResultCallback);
    }

    public <T extends ContentId> int requestEmotionUpdate(T t, int i, FeedbackResultCallback<Emotion> feedbackResultCallback) {
        debugLog("requestEmotionUpdate : contentId=[" + t + "] emotionType=[" + i + "] ");
        return requestEmotionUpdate(t, null, i, feedbackResultCallback);
    }

    public <T extends ContentId> int requestFeedback(T t, final FeedbackDownloadResultCallback<Feedback<T>> feedbackDownloadResultCallback) {
        debugLog("requestFeedback");
        if (!isSupportedSemsAgentVersionMoreThan(1000000000)) {
            return -7;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putBundle("contentId", t.toBundle());
            getSocialService().requestFeedback(bundle, new IFeedbackBundlePartialResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.feedback.FeedbackApi.1
                @Override // com.samsung.android.sdk.mobileservice.social.feedback.IFeedbackBundlePartialResultCallback
                public void onFailure(long j, String str) {
                    FeedbackApi feedbackApi = FeedbackApi.this;
                    StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestFeedback onFailure : code=[", "], message=[", str);
                    sbM2225p.append("] ");
                    feedbackApi.debugLog(sbM2225p.toString());
                    if (feedbackDownloadResultCallback != null) {
                        feedbackDownloadResultCallback.onResult(new FeedbackResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), str, Long.toString(j)), null));
                    }
                }

                @Override // com.samsung.android.sdk.mobileservice.social.feedback.IFeedbackBundlePartialResultCallback
                public void onPartialResult(Bundle bundle2) {
                    FeedbackApi.this.debugLog("requestFeedback onPartialResult ");
                    FeedbackDownloadResultCallback feedbackDownloadResultCallback2 = feedbackDownloadResultCallback;
                    if (feedbackDownloadResultCallback2 != null) {
                        feedbackDownloadResultCallback2.onPartialResult(FeedbackApi.this.bundleToFeedback(bundle2));
                    }
                }

                @Override // com.samsung.android.sdk.mobileservice.social.feedback.IFeedbackBundlePartialResultCallback
                public void onSuccess(Bundle bundle2) {
                    FeedbackApi.this.debugLog("requestFeedback onSuccess ");
                    FeedbackDownloadResultCallback feedbackDownloadResultCallback2 = feedbackDownloadResultCallback;
                    if (feedbackDownloadResultCallback2 != null) {
                        feedbackDownloadResultCallback2.onResult(new FeedbackResult(new CommonResultStatus(1), FeedbackApi.this.bundleToFeedback(bundle2)));
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

    public <T extends ContentId> int requestFeedbackForContentIdList(List<T> list, final FeedbackDownloadResultCallback<List<Feedback<T>>> feedbackDownloadResultCallback) {
        debugLog("requestFeedbackForContentIdList");
        if (!isSupportedSemsAgentVersionMoreThan(1000000000)) {
            return -7;
        }
        try {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().toBundle());
            }
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("contentIds", arrayList);
            getSocialService().requestFeedback(bundle, new IFeedbackBundlePartialResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.feedback.FeedbackApi.2
                @Override // com.samsung.android.sdk.mobileservice.social.feedback.IFeedbackBundlePartialResultCallback
                public void onFailure(long j, String str) {
                    FeedbackApi feedbackApi = FeedbackApi.this;
                    StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestFeedbackForContentIdList onFailure : code=[", "], message=[", str);
                    sbM2225p.append("] ");
                    feedbackApi.debugLog(sbM2225p.toString());
                    if (feedbackDownloadResultCallback != null) {
                        feedbackDownloadResultCallback.onResult(new FeedbackResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), str, Long.toString(j)), null));
                    }
                }

                @Override // com.samsung.android.sdk.mobileservice.social.feedback.IFeedbackBundlePartialResultCallback
                public void onPartialResult(Bundle bundle2) {
                    FeedbackApi.this.debugLog("requestFeedbackForContentIdList onPartialResult ");
                    FeedbackDownloadResultCallback feedbackDownloadResultCallback2 = feedbackDownloadResultCallback;
                    if (feedbackDownloadResultCallback2 != null) {
                        feedbackDownloadResultCallback2.onPartialResult(FeedbackApi.this.bundleToFeedbackList(bundle2, new ArrayList()));
                    }
                }

                @Override // com.samsung.android.sdk.mobileservice.social.feedback.IFeedbackBundlePartialResultCallback
                public void onSuccess(Bundle bundle2) {
                    FeedbackApi.this.debugLog("requestFeedbackForContentIdList onSuccess ");
                    FeedbackDownloadResultCallback feedbackDownloadResultCallback2 = feedbackDownloadResultCallback;
                    if (feedbackDownloadResultCallback2 != null) {
                        feedbackDownloadResultCallback2.onResult(new FeedbackResult(new CommonResultStatus(1), FeedbackApi.this.bundleToFeedbackList(bundle2, new ArrayList())));
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

    public <T extends ContentId> int requestMyCommentUpdate(T t, String str, String str2, final FeedbackResultCallback<Boolean> feedbackResultCallback) {
        debugLog("requestMyCommentUpdate : contentId=[" + t + "]");
        if (!isSupportedSemsAgentVersionMoreThan(1000000000)) {
            return -7;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putBundle("contentId", t.toBundle());
            bundle.putString("commentId", str);
            bundle.putString(ClientCookie.COMMENT_ATTR, str2);
            getSocialService().requestCommentUpdate(bundle, new IFeedbackBundleResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.feedback.FeedbackApi.4
                @Override // com.samsung.android.sdk.mobileservice.social.feedback.IFeedbackBundleResultCallback
                public void onFailure(long j, String str3) {
                    FeedbackApi feedbackApi = FeedbackApi.this;
                    StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestMyCommentUpdate onFailure : code=[", "], message=[", str3);
                    sbM2225p.append("] ");
                    feedbackApi.debugLog(sbM2225p.toString());
                    if (feedbackResultCallback != null) {
                        feedbackResultCallback.onResult(new FeedbackResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), str3, Long.toString(j)), Boolean.FALSE));
                    }
                }

                @Override // com.samsung.android.sdk.mobileservice.social.feedback.IFeedbackBundleResultCallback
                public void onSuccess(Bundle bundle2) {
                    FeedbackApi.this.debugLog("requestMyCommentUpdate onSuccess ");
                    FeedbackResultCallback feedbackResultCallback2 = feedbackResultCallback;
                    if (feedbackResultCallback2 != null) {
                        feedbackResultCallback2.onResult(new FeedbackResult(new CommonResultStatus(1), Boolean.TRUE));
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

    public int requestProfileImageList(List<String> list, final ProfileImageListResultCallback<UserProfile> profileImageListResultCallback) {
        debugLog("requestProfileImageList");
        if (!isSupportedSemsAgentVersionMoreThan(1000000000)) {
            return -7;
        }
        try {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("guid", str);
                    arrayList.add(bundle);
                }
            }
            Bundle bundle2 = new Bundle();
            bundle2.putParcelableArrayList("guids", arrayList);
            getSocialService().requestProfileImageList(bundle2, new IBundleProgressResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.feedback.FeedbackApi.10
                @Override // com.samsung.android.sdk.mobileservice.social.common.IBundleProgressResultCallback
                public void onFailure(long j, String str2) {
                    FeedbackApi feedbackApi = FeedbackApi.this;
                    StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestProfileImageList onFailure : code=[", "], message=[", str2);
                    sbM2225p.append("] ");
                    feedbackApi.debugLog(sbM2225p.toString());
                    if (profileImageListResultCallback != null) {
                        profileImageListResultCallback.onResult(new FeedbackResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), str2, Long.toString(j)), null));
                    }
                }

                @Override // com.samsung.android.sdk.mobileservice.social.common.IBundleProgressResultCallback
                public void onProgress(Bundle bundle3) {
                    FeedbackApi.this.debugLog("requestProfileImageList onProgress ");
                    ProfileImageListResultCallback profileImageListResultCallback2 = profileImageListResultCallback;
                    if (profileImageListResultCallback2 != null) {
                        profileImageListResultCallback2.onProgress(FeedbackApi.this.bundleToProfileImage(bundle3));
                    }
                }

                @Override // com.samsung.android.sdk.mobileservice.social.common.IBundleProgressResultCallback
                public void onSuccess(Bundle bundle3) {
                    FeedbackApi.this.debugLog("requestProfileImageList onSuccess ");
                    ProfileImageListResultCallback profileImageListResultCallback2 = profileImageListResultCallback;
                    if (profileImageListResultCallback2 != null) {
                        profileImageListResultCallback2.onResult(new FeedbackResult(new CommonResultStatus(1), FeedbackApi.this.bundleToProfileImageList(bundle3)));
                    }
                }
            });
            return 1;
        } catch (NotConnectedException e) {
            debugLog("requestProfileImageList fail");
            secureLog(e);
            return -8;
        } catch (Exception e2) {
            debugLog("requestProfileImageList fail");
            secureLog(e2);
            return -1;
        }
    }

    public <T extends ContentId> int requestCommentList(T t, int i, String str, final FeedbackDownloadResultCallback<CommentList> feedbackDownloadResultCallback) {
        debugLog("requestCommentList : contentId=[" + t + "] limit=[" + i + "] nextCommentId=[" + str + "] ");
        if (!isSupportedSemsAgentVersionMoreThan(1000000000)) {
            return -7;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putBundle("contentId", t.toBundle());
            bundle.putInt("limit", i);
            if (!TextUtils.isEmpty(str)) {
                bundle.putString("nextCommentId", str);
            }
            getSocialService().requestCommentList(bundle, new IFeedbackBundlePartialResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.feedback.FeedbackApi.6
                @Override // com.samsung.android.sdk.mobileservice.social.feedback.IFeedbackBundlePartialResultCallback
                public void onFailure(long j, String str2) {
                    FeedbackApi feedbackApi = FeedbackApi.this;
                    StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestCommentList onFailure : code=[", "], message=[", str2);
                    sbM2225p.append("] ");
                    feedbackApi.debugLog(sbM2225p.toString());
                    if (feedbackDownloadResultCallback != null) {
                        feedbackDownloadResultCallback.onResult(new FeedbackResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), str2, Long.toString(j)), null));
                    }
                }

                @Override // com.samsung.android.sdk.mobileservice.social.feedback.IFeedbackBundlePartialResultCallback
                public void onPartialResult(Bundle bundle2) {
                    FeedbackApi.this.debugLog("requestCommentList onPartialResult ");
                    FeedbackDownloadResultCallback feedbackDownloadResultCallback2 = feedbackDownloadResultCallback;
                    if (feedbackDownloadResultCallback2 != null) {
                        feedbackDownloadResultCallback2.onPartialResult(FeedbackApi.this.bundleToCommentList(bundle2));
                    }
                }

                @Override // com.samsung.android.sdk.mobileservice.social.feedback.IFeedbackBundlePartialResultCallback
                public void onSuccess(Bundle bundle2) {
                    FeedbackApi.this.debugLog("requestCommentList onSuccess ");
                    FeedbackDownloadResultCallback feedbackDownloadResultCallback2 = feedbackDownloadResultCallback;
                    if (feedbackDownloadResultCallback2 != null) {
                        feedbackDownloadResultCallback2.onResult(new FeedbackResult(new CommonResultStatus(1), FeedbackApi.this.bundleToCommentList(bundle2)));
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

    public <T extends ContentId> int requestEmotionCancellation(T t, String str, int i, final FeedbackResultCallback<Emotion> feedbackResultCallback) {
        debugLog("requestEmotionCancellation : contentId=[" + t + "] commentId=[" + str + "] previousEmotionType=[" + i + "] ");
        if (!isSupportedSemsAgentVersionMoreThan(1000000000)) {
            return -7;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putBundle("contentId", t.toBundle());
            if (!TextUtils.isEmpty(str)) {
                bundle.putString("commentId", str);
            }
            bundle.putBoolean("cancelAction", true);
            bundle.putInt("emotionType", i);
            getSocialService().requestEmotionUpdate(bundle, new IFeedbackBundleResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.feedback.FeedbackApi.8
                @Override // com.samsung.android.sdk.mobileservice.social.feedback.IFeedbackBundleResultCallback
                public void onFailure(long j, String str2) {
                    FeedbackApi feedbackApi = FeedbackApi.this;
                    StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestEmotionCancellation onFailure : code=[", "], message=[", str2);
                    sbM2225p.append("] ");
                    feedbackApi.debugLog(sbM2225p.toString());
                    if (feedbackResultCallback != null) {
                        feedbackResultCallback.onResult(new FeedbackResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), str2, Long.toString(j)), null));
                    }
                }

                @Override // com.samsung.android.sdk.mobileservice.social.feedback.IFeedbackBundleResultCallback
                public void onSuccess(Bundle bundle2) {
                    FeedbackApi.this.debugLog("requestEmotionCancellation onSuccess ");
                    if (feedbackResultCallback != null) {
                        bundle2.getInt("count", -1);
                        feedbackResultCallback.onResult(new FeedbackResult(new CommonResultStatus(1), FeedbackApi.this.bundleToEmotion(bundle2)));
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

    public <T extends ContentId> int requestEmotionMemberList(T t, int i, String str, FeedbackDownloadResultCallback<EmotionMemberList<T>> feedbackDownloadResultCallback) {
        debugLog("requestEmotionMemberList : contentId=[" + t + "] nextMemberGuid=[" + str + "] ");
        return requestEmotionMemberList(t, null, i, str, feedbackDownloadResultCallback);
    }

    public <T extends ContentId> int requestEmotionUpdate(T t, String str, int i, final FeedbackResultCallback<Emotion> feedbackResultCallback) {
        debugLog("requestEmotionUpdate : contentId=[" + t + "] commentId=[" + str + "] ");
        if (!isSupportedSemsAgentVersionMoreThan(1000000000)) {
            return -7;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putBundle("contentId", t.toBundle());
            if (!TextUtils.isEmpty(str)) {
                bundle.putString("commentId", str);
            }
            bundle.putBoolean("cancelAction", false);
            bundle.putInt("emotionType", i);
            getSocialService().requestEmotionUpdate(bundle, new IFeedbackBundleResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.feedback.FeedbackApi.7
                @Override // com.samsung.android.sdk.mobileservice.social.feedback.IFeedbackBundleResultCallback
                public void onFailure(long j, String str2) {
                    FeedbackApi feedbackApi = FeedbackApi.this;
                    StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestEmotionUpdate onFailure : code=[", "], message=[", str2);
                    sbM2225p.append("] ");
                    feedbackApi.debugLog(sbM2225p.toString());
                    if (feedbackResultCallback != null) {
                        feedbackResultCallback.onResult(new FeedbackResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), str2, Long.toString(j)), null));
                    }
                }

                @Override // com.samsung.android.sdk.mobileservice.social.feedback.IFeedbackBundleResultCallback
                public void onSuccess(Bundle bundle2) {
                    FeedbackApi.this.debugLog("requestEmotionUpdate onSuccess ");
                    FeedbackResultCallback feedbackResultCallback2 = feedbackResultCallback;
                    if (feedbackResultCallback2 != null) {
                        feedbackResultCallback2.onResult(new FeedbackResult(new CommonResultStatus(1), FeedbackApi.this.bundleToEmotion(bundle2)));
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

    public <T extends ContentId> int requestEmotionMemberList(T t, String str, int i, FeedbackDownloadResultCallback<EmotionMemberList<T>> feedbackDownloadResultCallback) {
        debugLog("requestEmotionMemberList : contentId=[" + t + "] commentId=[" + str + "] ");
        return requestEmotionMemberList(t, str, i, null, feedbackDownloadResultCallback);
    }

    public <T extends ContentId> int requestEmotionMemberList(final T t, final String str, int i, String str2, final FeedbackDownloadResultCallback<EmotionMemberList<T>> feedbackDownloadResultCallback) {
        debugLog("requestEmotionMemberList : contentId=[" + t + "] commentId=[" + str + "] ");
        if (!isSupportedSemsAgentVersionMoreThan(1000000000)) {
            return -7;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putBundle("contentId", t.toBundle());
            bundle.putInt("limit", i);
            if (!TextUtils.isEmpty(str)) {
                bundle.putString("commentId", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                bundle.putString("nextMemberGuid", str2);
            }
            getSocialService().requestEmotionMemberList(bundle, new IFeedbackBundlePartialResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.feedback.FeedbackApi.9
                @Override // com.samsung.android.sdk.mobileservice.social.feedback.IFeedbackBundlePartialResultCallback
                public void onFailure(long j, String str3) {
                    FeedbackApi feedbackApi = FeedbackApi.this;
                    StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestEmotionMemberList onFailure : code=[", "], message=[", str3);
                    sbM2225p.append("] ");
                    feedbackApi.debugLog(sbM2225p.toString());
                    if (feedbackDownloadResultCallback != null) {
                        feedbackDownloadResultCallback.onResult(new FeedbackResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), str3, Long.toString(j)), null));
                    }
                }

                @Override // com.samsung.android.sdk.mobileservice.social.feedback.IFeedbackBundlePartialResultCallback
                public void onPartialResult(Bundle bundle2) {
                    FeedbackApi.this.debugLog("requestEmotionMemberList onPartialResult ");
                    FeedbackDownloadResultCallback feedbackDownloadResultCallback2 = feedbackDownloadResultCallback;
                    if (feedbackDownloadResultCallback2 != null) {
                        feedbackDownloadResultCallback2.onPartialResult(FeedbackApi.this.bundleToActivityEmotionMemberList(t, str, bundle2));
                    }
                }

                @Override // com.samsung.android.sdk.mobileservice.social.feedback.IFeedbackBundlePartialResultCallback
                public void onSuccess(Bundle bundle2) {
                    FeedbackApi.this.debugLog("requestEmotionMemberList onSuccess ");
                    if (feedbackDownloadResultCallback != null) {
                        feedbackDownloadResultCallback.onResult(new FeedbackResult(new CommonResultStatus(1), FeedbackApi.this.bundleToActivityEmotionMemberList(t, str, bundle2)));
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
}
