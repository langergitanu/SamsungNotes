package com.samsung.android.sdk.mobileservice.social;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.samsung.android.sdk.mobileservice.social.activity.IActivityBundlePartialResultCallback;
import com.samsung.android.sdk.mobileservice.social.activity.IActivityBundleResultCallback;
import com.samsung.android.sdk.mobileservice.social.activity.IActivityResultCallback;
import com.samsung.android.sdk.mobileservice.social.activity.IDeleteAllActivityResultCallback;
import com.samsung.android.sdk.mobileservice.social.buddy.IBuddyInfoResultCallback;
import com.samsung.android.sdk.mobileservice.social.buddy.IPublicBuddyInfoResultCallback;
import com.samsung.android.sdk.mobileservice.social.buddy.IServiceActivationResultCallback;
import com.samsung.android.sdk.mobileservice.social.buddy.IServiceDeactivationResultCallback;
import com.samsung.android.sdk.mobileservice.social.buddy.ISyncResultCallback;
import com.samsung.android.sdk.mobileservice.social.common.IBundleProgressResultCallback;
import com.samsung.android.sdk.mobileservice.social.common.IBundleResultCallback;
import com.samsung.android.sdk.mobileservice.social.feedback.IFeedbackBundlePartialResultCallback;
import com.samsung.android.sdk.mobileservice.social.feedback.IFeedbackBundleResultCallback;
import com.samsung.android.sdk.mobileservice.social.group.IGroupCoverImageDownloadingResultCallback;
import com.samsung.android.sdk.mobileservice.social.group.IGroupInvitationResultCallback;
import com.samsung.android.sdk.mobileservice.social.group.IGroupListResultCallback;
import com.samsung.android.sdk.mobileservice.social.group.IGroupListWithInvitationResultCallback;
import com.samsung.android.sdk.mobileservice.social.group.IGroupRequestResultCallback;
import com.samsung.android.sdk.mobileservice.social.group.IGroupResultCallback;
import com.samsung.android.sdk.mobileservice.social.group.IGroupSyncResultCallback;
import com.samsung.android.sdk.mobileservice.social.group.IMemberListResultCallback;
import com.samsung.android.sdk.mobileservice.social.share.IContentDownloadingResultCallback;
import com.samsung.android.sdk.mobileservice.social.share.IDownloadThumbnailResultCallback;
import com.samsung.android.sdk.mobileservice.social.share.IShareBulkItemResultCallback;
import com.samsung.android.sdk.mobileservice.social.share.IShareResultCallback;
import com.samsung.android.sdk.mobileservice.social.share.IShareResultWithFileListCallback;
import com.samsung.android.sdk.mobileservice.social.share.IShareStatusCallback;
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
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public interface IMobileServiceSocial extends IInterface {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Default implements IMobileServiceSocial {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int cancelShare(String str, String str2) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public void clearSpaceUnreadCount(String str, String str2) {
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public void clearSpaceUnreadCountWithData(String str, Bundle bundle, String str2) {
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int dataSyncDelete(String str, Bundle bundle, IBundleResultCallback iBundleResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int dataSyncGetSyncedData(String str, Bundle bundle, IBundleResultCallback iBundleResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int dataSyncUpsert(String str, Bundle bundle, IBundleResultCallback iBundleResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public Bundle getBuddyActivityCount(Bundle bundle) {
            return null;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public Bundle getBuddyActivityList(Bundle bundle) {
            return null;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public void getBuddyInfo(Bundle bundle, IBuddyInfoResultCallback iBuddyInfoResultCallback) {
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public Bundle getBuddySyncTime() {
            return null;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int getCountryTypeForAgreement() {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public Bundle getDeviceAuthInfoCached() {
            return null;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public boolean getDisclaimerAgreementForService(Bundle bundle) {
            return false;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public boolean getDisclaimerAgreementForSocial() {
            return false;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int getDisclosureScope(Bundle bundle) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public Bundle getFamilyQuotaWithData(Bundle bundle) {
            return null;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public List<Bundle> getGroupList(String str) {
            return null;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public List<Bundle> getGroupListWithData(Bundle bundle) {
            return null;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public Intent getIntentToDisplay(Bundle bundle) {
            return null;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public Bundle getNotification(Bundle bundle) {
            return null;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public Bundle getQuota() {
            return null;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public Bundle getQuotaWithData(Bundle bundle) {
            return null;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public Bundle getServiceState() {
            return null;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int getShareStatus(String str, String str2) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public Bundle getVerifiedOriginalFileListWithData(Bundle bundle) {
            return null;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public Bundle isPermissionGranted(Bundle bundle) {
            return null;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int isServiceActivated(int i) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public boolean isServiceRegistered(Bundle bundle) {
            return false;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public Bundle isSomethingNeeded(Bundle bundle) {
            return null;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int pauseShare(String str, String str2) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public void requestActivity(Bundle bundle, IActivityBundlePartialResultCallback iActivityBundlePartialResultCallback) {
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public void requestActivityChanges(IActivityBundlePartialResultCallback iActivityBundlePartialResultCallback) {
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public void requestActivityContent(Bundle bundle, IActivityBundleResultCallback iActivityBundleResultCallback) {
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public void requestActivityContentStreamingUrl(Bundle bundle, IActivityBundleResultCallback iActivityBundleResultCallback) {
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public void requestActivityDeletion(Bundle bundle, IActivityResultCallback iActivityResultCallback) {
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public void requestActivityImageList(Bundle bundle, IBundleProgressResultCallback iBundleProgressResultCallback) {
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public void requestActivityList(Bundle bundle, IActivityBundlePartialResultCallback iActivityBundlePartialResultCallback) {
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public Bundle requestActivityPosting(Bundle bundle, PendingIntent pendingIntent, IBundleProgressResultCallback iBundleProgressResultCallback) {
            return null;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public void requestActivitySync(IActivityBundleResultCallback iActivityBundleResultCallback) {
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestAllSpaceList(String str, ISpaceListResultCallback iSpaceListResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestAllSpaceListWithData(String str, Bundle bundle, ISpaceListResultCallback iSpaceListResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public void requestAppUpdateAndLaunchForBuddy(Bundle bundle, IBuddyInfoResultCallback iBuddyInfoResultCallback) {
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public void requestBuddySync(int i, ISyncResultCallback iSyncResultCallback) {
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public String requestBulkItemShare(Bundle bundle, IShareBulkItemResultCallback iShareBulkItemResultCallback) {
            return null;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public void requestCommentCreation(Bundle bundle, IFeedbackBundleResultCallback iFeedbackBundleResultCallback) {
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public void requestCommentDeletion(Bundle bundle, IFeedbackBundleResultCallback iFeedbackBundleResultCallback) {
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public void requestCommentList(Bundle bundle, IFeedbackBundlePartialResultCallback iFeedbackBundlePartialResultCallback) {
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public void requestCommentUpdate(Bundle bundle, IFeedbackBundleResultCallback iFeedbackBundleResultCallback) {
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public Bundle requestContentsController(Bundle bundle) {
            return null;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestDelegateAuthorityOfOwner(String str, String str2, String str3, IGroupResultCallback iGroupResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestDelegateAuthorityOfOwnerWithData(Bundle bundle, IGroupResultCallback iGroupResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public void requestDeleteAllActivity(IDeleteAllActivityResultCallback iDeleteAllActivityResultCallback) {
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestDeleteAllItemsFromTrashBinWithData(Bundle bundle, ITrashBinResultCallback iTrashBinResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestDeleteItemListFromTrashBinWithData(Bundle bundle, ITrashBinResultCallback iTrashBinResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestDisclosureScope(Bundle bundle, IBundleResultCallback iBundleResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestDisclosureScopeUpdate(Bundle bundle, IBundleResultCallback iBundleResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public void requestEmotionMemberList(Bundle bundle, IFeedbackBundlePartialResultCallback iFeedbackBundlePartialResultCallback) {
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public void requestEmotionUpdate(Bundle bundle, IFeedbackBundleResultCallback iFeedbackBundleResultCallback) {
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestFamilyGroupCreationWithData(Bundle bundle, Bundle bundle2, IGroupResultCallback iGroupResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestFamilyGroupDeletionWithData(Bundle bundle, IGroupRequestResultCallback iGroupRequestResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestFamilyGroupMemberListWithData(Bundle bundle, IMemberListResultCallback iMemberListResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public void requestFeedback(Bundle bundle, IFeedbackBundlePartialResultCallback iFeedbackBundlePartialResultCallback) {
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestGroup(String str, String str2, IGroupResultCallback iGroupResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestGroupAuthorityChange(Bundle bundle, IGroupResultCallback iGroupResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestGroupCreation(String str, Bundle bundle, Bundle bundle2, IGroupInvitationResultCallback iGroupInvitationResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestGroupCreationWithData(Bundle bundle, Bundle bundle2, Bundle bundle3, IGroupInvitationResultCallback iGroupInvitationResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestGroupDeletion(String str, String str2, IGroupRequestResultCallback iGroupRequestResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestGroupDeletionWithData(Bundle bundle, IGroupRequestResultCallback iGroupRequestResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestGroupInvitationAcceptance(String str, String str2, IGroupRequestResultCallback iGroupRequestResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestGroupInvitationAcceptanceWithData(Bundle bundle, IGroupRequestResultCallback iGroupRequestResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestGroupInvitationRejection(String str, String str2, IGroupRequestResultCallback iGroupRequestResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestGroupInvitationRejectionWithData(Bundle bundle, IGroupRequestResultCallback iGroupRequestResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestGroupList(String str, IGroupListResultCallback iGroupListResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestGroupListWithData(Bundle bundle, IGroupListResultCallback iGroupListResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestGroupMemberInvitation(String str, String str2, Bundle bundle, IGroupInvitationResultCallback iGroupInvitationResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestGroupMemberInvitationWithData(Bundle bundle, Bundle bundle2, IGroupInvitationResultCallback iGroupInvitationResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestGroupMemberList(String str, String str2, IMemberListResultCallback iMemberListResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestGroupMemberListWithData(Bundle bundle, IMemberListResultCallback iMemberListResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestGroupMemberRemoval(String str, String str2, String str3, IGroupRequestResultCallback iGroupRequestResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestGroupMemberRemovalWithData(Bundle bundle, IGroupRequestResultCallback iGroupRequestResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestGroupPendingInvitationCancellation(String str, String str2, String str3, IGroupRequestResultCallback iGroupRequestResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestGroupPendingInvitationCancellationWithData(Bundle bundle, IGroupRequestResultCallback iGroupRequestResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestGroupSync(String str, IGroupSyncResultCallback iGroupSyncResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestGroupSyncWithData(Bundle bundle, IGroupSyncResultCallback iGroupSyncResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestGroupSyncWithoutImage(String str, IGroupSyncResultCallback iGroupSyncResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestGroupSyncWithoutImageWithData(Bundle bundle, IGroupSyncResultCallback iGroupSyncResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestGroupUpdate(String str, String str2, Bundle bundle, IGroupResultCallback iGroupResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestGroupWithData(Bundle bundle, IGroupResultCallback iGroupResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestGroupWithInvitationList(String str, IGroupListWithInvitationResultCallback iGroupListWithInvitationResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestGroupWithInvitationListWithData(Bundle bundle, IGroupListWithInvitationResultCallback iGroupListWithInvitationResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestInstantShare(String str, Bundle bundle, List<Bundle> list, IShareResultCallback iShareResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestInvitationLinkCreation(Bundle bundle, IGroupResultCallback iGroupResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestInvitationLinkDeletion(Bundle bundle, IGroupResultCallback iGroupResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestLeave(String str, String str2, IGroupRequestResultCallback iGroupRequestResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestLeaveWithData(Bundle bundle, IGroupRequestResultCallback iGroupRequestResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestMoveItemListToTrashBinWithData(Bundle bundle, ITrashBinResultCallback iTrashBinResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public void requestMyActivityPrivacy(IActivityBundleResultCallback iActivityBundleResultCallback) {
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public void requestMyActivityPrivacyUpdate(Bundle bundle, IActivityResultCallback iActivityResultCallback) {
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestOriginalGroupImageDownload(String str, String str2, IGroupCoverImageDownloadingResultCallback iGroupCoverImageDownloadingResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestOriginalSharedContentWithFileListDownload(String str, String str2, String str3, List<String> list, IContentDownloadingResultCallback iContentDownloadingResultCallback, PendingIntent pendingIntent, Bundle bundle) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestOriginalSharedContentWithFileListDownloadWithData(String str, String str2, String str3, List<String> list, Bundle bundle, IContentDownloadingResultCallback iContentDownloadingResultCallback, PendingIntent pendingIntent, Bundle bundle2) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestOriginalSharedContentWithItemFileListDownloadWithPath(String str, String str2, String str3, List<String> list, IContentDownloadingResultCallback iContentDownloadingResultCallback, PendingIntent pendingIntent, Bundle bundle, String str4) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        /* JADX INFO: renamed from: requestOriginalSharedContentWithItemFileListDownloadWithPathWithData */
        public int mo5781xd48f8faa(String str, String str2, String str3, List<String> list, Bundle bundle, IContentDownloadingResultCallback iContentDownloadingResultCallback, PendingIntent pendingIntent, Bundle bundle2, String str4) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestOriginalSharedContentsDownload(String str, String str2, String[] strArr, IContentDownloadingResultCallback iContentDownloadingResultCallback, PendingIntent pendingIntent, Bundle bundle) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestOriginalSharedContentsDownloadToHiddenFolder(Bundle bundle, IContentDownloadingResultCallback iContentDownloadingResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestOriginalSharedContentsDownloadWithPath(String str, String str2, String[] strArr, IContentDownloadingResultCallback iContentDownloadingResultCallback, PendingIntent pendingIntent, Bundle bundle, String str3) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestOriginalSpaceImageDownload(String str, String str2, ISpaceCoverImageDownloadingResultCallback iSpaceCoverImageDownloadingResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestOriginalSpaceImageDownloadWithData(String str, String str2, Bundle bundle, ISpaceCoverImageDownloadingResultCallback iSpaceCoverImageDownloadingResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public void requestProfileImageList(Bundle bundle, IBundleProgressResultCallback iBundleProgressResultCallback) {
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public void requestPublicBuddyInfo(String str, IPublicBuddyInfoResultCallback iPublicBuddyInfoResultCallback) {
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestRestoreItemListFromTrashBinWithData(Bundle bundle, ITrashBinResultCallback iTrashBinResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public void requestServiceActivation(int i, IServiceActivationResultCallback iServiceActivationResultCallback) {
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public void requestServiceDeactivation(int i, IServiceDeactivationResultCallback iServiceDeactivationResultCallback) {
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestServiceNumber(IBundleResultCallback iBundleResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public String requestShareListUpdateWithItemFileList(String str, String str2, List<Bundle> list, IShareResultCallback iShareResultCallback, PendingIntent pendingIntent, Bundle bundle) {
            return null;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public String requestShareListUpdateWithItemFileListWithData(String str, String str2, List<Bundle> list, Bundle bundle, IShareResultCallback iShareResultCallback, PendingIntent pendingIntent, Bundle bundle2) {
            return null;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestShareSync(String str, IShareSyncResultCallback iShareSyncResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestShareSyncWithData(String str, Bundle bundle, IShareSyncResultCallback iShareSyncResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestShareSyncWithOption(String str, Bundle bundle, IShareSyncResultCallback iShareSyncResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public String requestShareUpdateWithUriList(String str, String str2, String str3, Bundle bundle, IShareResultWithFileListCallback iShareResultWithFileListCallback, PendingIntent pendingIntent, Bundle bundle2) {
            return null;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public String requestShareWithData(String str, String str2, List<Bundle> list, Bundle bundle, IShareResultCallback iShareResultCallback) {
            return null;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public String requestShareWithFileList(String str, String str2, Bundle bundle, IShareResultWithFileListCallback iShareResultWithFileListCallback, PendingIntent pendingIntent, Bundle bundle2) {
            return null;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public String requestShareWithFileListWithData(String str, String str2, Bundle bundle, Bundle bundle2, IShareResultWithFileListCallback iShareResultWithFileListCallback, PendingIntent pendingIntent, Bundle bundle3) {
            return null;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public String requestShareWithItemFileList(String str, String str2, List<Bundle> list, IShareResultCallback iShareResultCallback, PendingIntent pendingIntent, Bundle bundle) {
            return null;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public String requestShareWithItemFileListWithData(String str, String str2, List<Bundle> list, Bundle bundle, IShareResultCallback iShareResultCallback, PendingIntent pendingIntent, Bundle bundle2) {
            return null;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public String requestShareWithPendingIntent(String str, String str2, List<Bundle> list, IShareResultCallback iShareResultCallback, PendingIntent pendingIntent, Bundle bundle) {
            return null;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestSharedItem(String str, String str2, String str3, ISharedItemResultCallback iSharedItemResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestSharedItemDeletion(String str, String str2, String str3, ISharedItemDeletionResultCallback iSharedItemDeletionResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestSharedItemDeletionWithData(String str, String str2, String str3, Bundle bundle, ISharedItemDeletionResultCallback iSharedItemDeletionResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestSharedItemList(String str, String str2, String str3, String str4, ISharedItemListResultCallback iSharedItemListResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestSharedItemListDeletion(String str, String str2, List<String> list, ISharedItemListDeletionResultCallback iSharedItemListDeletionResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestSharedItemListDeletionWithData(String str, String str2, List<String> list, Bundle bundle, ISharedItemListDeletionResultCallback iSharedItemListDeletionResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestSharedItemListInTrashBinWithData(Bundle bundle, ISharedItemListResultCallback iSharedItemListResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public String requestSharedItemListUpdate(String str, String str2, List<Bundle> list, IShareResultCallback iShareResultCallback, PendingIntent pendingIntent, Bundle bundle) {
            return null;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestSharedItemListWithFileList(String str, String str2, String str3, String str4, ISharedItemListResultCallback iSharedItemListResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestSharedItemListWithFileListWithData(String str, String str2, String str3, String str4, Bundle bundle, ISharedItemListResultCallback iSharedItemListResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestSharedItemSync(String str, String str2, IShareSyncResultCallback iShareSyncResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestSharedItemSyncWithData(String str, String str2, Bundle bundle, IShareSyncResultCallback iShareSyncResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public void requestSharedItemSyncWithResolution(String str, Bundle bundle, IShareSyncResultCallback iShareSyncResultCallback) {
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestSharedItemSyncWithResolutionWithData(String str, Bundle bundle, Bundle bundle2, IShareSyncResultCallback iShareSyncResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public String requestSharedItemUpdate(String str, String str2, String str3, Bundle bundle, ISharedItemUpdateResultCallback iSharedItemUpdateResultCallback, PendingIntent pendingIntent, Bundle bundle2) {
            return null;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestSharedItemWithData(String str, String str2, String str3, Bundle bundle, ISharedItemResultCallback iSharedItemResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestSharedItemWithGroupId(String str, String str2, String str3, String str4, ISharedItemResultCallback iSharedItemResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestSharedItemWithGroupIdWithData(String str, String str2, String str3, String str4, Bundle bundle, ISharedItemResultCallback iSharedItemResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestSpace(String str, String str2, ISpaceResultCallback iSpaceResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestSpaceCreation(String str, String str2, Bundle bundle, ISpaceResultCallback iSpaceResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestSpaceCreationWithData(String str, String str2, Bundle bundle, Bundle bundle2, ISpaceResultCallback iSpaceResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestSpaceDeletion(String str, String str2, ISpaceDeletionResultCallback iSpaceDeletionResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestSpaceDeletionWithData(String str, String str2, Bundle bundle, ISpaceDeletionResultCallback iSpaceDeletionResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestSpaceList(String str, String str2, ISpaceListResultCallback iSpaceListResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestSpaceListSync(String str, IShareSyncResultCallback iShareSyncResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestSpaceListSyncWithData(String str, Bundle bundle, IShareSyncResultCallback iShareSyncResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestSpaceListWithData(String str, String str2, Bundle bundle, ISpaceListResultCallback iSpaceListResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestSpaceUpdate(String str, String str2, Bundle bundle, ISpaceResultCallback iSpaceResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestSpaceUpdateWithData(String str, String str2, Bundle bundle, Bundle bundle2, ISpaceResultCallback iSpaceResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestSpaceWithData(String str, String str2, Bundle bundle, ISpaceResultCallback iSpaceResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public void requestSync(ISyncResultCallback iSyncResultCallback) {
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestThumbnailDownload(String str, String str2, String str3, String str4, String str5, String str6, IDownloadThumbnailResultCallback iDownloadThumbnailResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int requestWebLinkEnabled(Bundle bundle, boolean z, IBundleResultCallback iBundleResultCallback) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int resumeShare(String str, String str2) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public Bundle setBuddyActivityListRead(Bundle bundle) {
            return null;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public boolean setDisclaimerAgreementForSocial(Bundle bundle) {
            return false;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
        public int setShareStatusListener(String str, String str2, IShareStatusCallback iShareStatusCallback) {
            return 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class Stub extends Binder implements IMobileServiceSocial {
        private static final String DESCRIPTOR = "com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial";
        static final int TRANSACTION_cancelShare = 26;
        static final int TRANSACTION_clearSpaceUnreadCount = 29;
        static final int TRANSACTION_clearSpaceUnreadCountWithData = 95;
        static final int TRANSACTION_dataSyncDelete = 158;
        static final int TRANSACTION_dataSyncGetSyncedData = 159;
        static final int TRANSACTION_dataSyncUpsert = 157;
        static final int TRANSACTION_getBuddyActivityCount = 81;
        static final int TRANSACTION_getBuddyActivityList = 46;
        static final int TRANSACTION_getBuddyInfo = 110;
        static final int TRANSACTION_getBuddySyncTime = 163;
        static final int TRANSACTION_getCountryTypeForAgreement = 61;
        static final int TRANSACTION_getDeviceAuthInfoCached = 107;
        static final int TRANSACTION_getDisclaimerAgreementForService = 106;
        static final int TRANSACTION_getDisclaimerAgreementForSocial = 105;
        static final int TRANSACTION_getDisclosureScope = 162;
        static final int TRANSACTION_getFamilyQuotaWithData = 148;
        static final int TRANSACTION_getGroupList = 10;
        static final int TRANSACTION_getGroupListWithData = 124;
        static final int TRANSACTION_getIntentToDisplay = 43;
        static final int TRANSACTION_getNotification = 59;
        static final int TRANSACTION_getQuota = 115;
        static final int TRANSACTION_getQuotaWithData = 118;
        static final int TRANSACTION_getServiceState = 68;
        static final int TRANSACTION_getShareStatus = 27;
        static final int TRANSACTION_getVerifiedOriginalFileListWithData = 143;
        static final int TRANSACTION_isPermissionGranted = 119;
        static final int TRANSACTION_isServiceActivated = 2;
        static final int TRANSACTION_isServiceRegistered = 108;
        static final int TRANSACTION_isSomethingNeeded = 67;
        static final int TRANSACTION_pauseShare = 24;
        static final int TRANSACTION_requestActivity = 51;
        static final int TRANSACTION_requestActivityChanges = 74;
        static final int TRANSACTION_requestActivityContent = 86;
        static final int TRANSACTION_requestActivityContentStreamingUrl = 84;
        static final int TRANSACTION_requestActivityDeletion = 45;
        static final int TRANSACTION_requestActivityImageList = 69;
        static final int TRANSACTION_requestActivityList = 44;
        static final int TRANSACTION_requestActivityPosting = 83;
        static final int TRANSACTION_requestActivitySync = 50;
        static final int TRANSACTION_requestAllSpaceList = 20;
        static final int TRANSACTION_requestAllSpaceListWithData = 94;
        static final int TRANSACTION_requestAppUpdateAndLaunchForBuddy = 155;
        static final int TRANSACTION_requestBuddySync = 109;
        static final int TRANSACTION_requestBulkItemShare = 156;
        static final int TRANSACTION_requestCommentCreation = 54;
        static final int TRANSACTION_requestCommentDeletion = 56;
        static final int TRANSACTION_requestCommentList = 53;
        static final int TRANSACTION_requestCommentUpdate = 55;
        static final int TRANSACTION_requestContentsController = 85;
        static final int TRANSACTION_requestDelegateAuthorityOfOwner = 71;
        static final int TRANSACTION_requestDelegateAuthorityOfOwnerWithData = 135;
        static final int TRANSACTION_requestDeleteAllActivity = 6;
        static final int TRANSACTION_requestDeleteAllItemsFromTrashBinWithData = 153;
        static final int TRANSACTION_requestDeleteItemListFromTrashBinWithData = 152;
        static final int TRANSACTION_requestDisclosureScope = 160;
        static final int TRANSACTION_requestDisclosureScopeUpdate = 161;
        static final int TRANSACTION_requestEmotionMemberList = 58;
        static final int TRANSACTION_requestEmotionUpdate = 57;
        static final int TRANSACTION_requestFamilyGroupCreationWithData = 146;
        static final int TRANSACTION_requestFamilyGroupDeletionWithData = 147;
        static final int TRANSACTION_requestFamilyGroupMemberListWithData = 149;
        static final int TRANSACTION_requestFeedback = 52;
        static final int TRANSACTION_requestGroup = 9;
        static final int TRANSACTION_requestGroupAuthorityChange = 136;
        static final int TRANSACTION_requestGroupCreation = 32;
        static final int TRANSACTION_requestGroupCreationWithData = 125;
        static final int TRANSACTION_requestGroupDeletion = 33;
        static final int TRANSACTION_requestGroupDeletionWithData = 126;
        static final int TRANSACTION_requestGroupInvitationAcceptance = 35;
        static final int TRANSACTION_requestGroupInvitationAcceptanceWithData = 128;
        static final int TRANSACTION_requestGroupInvitationRejection = 36;
        static final int TRANSACTION_requestGroupInvitationRejectionWithData = 129;
        static final int TRANSACTION_requestGroupList = 8;
        static final int TRANSACTION_requestGroupListWithData = 121;
        static final int TRANSACTION_requestGroupMemberInvitation = 34;
        static final int TRANSACTION_requestGroupMemberInvitationWithData = 127;
        static final int TRANSACTION_requestGroupMemberList = 37;
        static final int TRANSACTION_requestGroupMemberListWithData = 130;
        static final int TRANSACTION_requestGroupMemberRemoval = 39;
        static final int TRANSACTION_requestGroupMemberRemovalWithData = 132;
        static final int TRANSACTION_requestGroupPendingInvitationCancellation = 41;
        static final int TRANSACTION_requestGroupPendingInvitationCancellationWithData = 134;
        static final int TRANSACTION_requestGroupSync = 7;
        static final int TRANSACTION_requestGroupSyncWithData = 122;
        static final int TRANSACTION_requestGroupSyncWithoutImage = 87;
        static final int TRANSACTION_requestGroupSyncWithoutImageWithData = 123;
        static final int TRANSACTION_requestGroupUpdate = 73;
        static final int TRANSACTION_requestGroupWithData = 120;
        static final int TRANSACTION_requestGroupWithInvitationList = 38;
        static final int TRANSACTION_requestGroupWithInvitationListWithData = 131;
        static final int TRANSACTION_requestInstantShare = 42;
        static final int TRANSACTION_requestInvitationLinkCreation = 144;
        static final int TRANSACTION_requestInvitationLinkDeletion = 145;
        static final int TRANSACTION_requestLeave = 40;
        static final int TRANSACTION_requestLeaveWithData = 133;
        static final int TRANSACTION_requestMoveItemListToTrashBinWithData = 150;
        static final int TRANSACTION_requestMyActivityPrivacy = 49;
        static final int TRANSACTION_requestMyActivityPrivacyUpdate = 48;
        static final int TRANSACTION_requestOriginalGroupImageDownload = 21;
        static final int TRANSACTION_requestOriginalSharedContentWithFileListDownload = 63;

        /* JADX INFO: renamed from: TRANSACTION_requestOriginalSharedContentWithFileListDownloadWithData */
        static final int f4877xcd5100ad = 102;

        /* JADX INFO: renamed from: TRANSACTION_requestOriginalSharedContentWithItemFileListDownloadWithPath */
        static final int f4878x933045db = 80;

        /* JADX INFO: renamed from: TRANSACTION_requestOriginalSharedContentWithItemFileListDownloadWithPathWithData */
        static final int f4879x7766e08b = 101;
        static final int TRANSACTION_requestOriginalSharedContentsDownload = 23;
        static final int TRANSACTION_requestOriginalSharedContentsDownloadToHiddenFolder = 113;
        static final int TRANSACTION_requestOriginalSharedContentsDownloadWithPath = 75;
        static final int TRANSACTION_requestOriginalSpaceImageDownload = 22;
        static final int TRANSACTION_requestOriginalSpaceImageDownloadWithData = 139;
        static final int TRANSACTION_requestProfileImageList = 70;
        static final int TRANSACTION_requestPublicBuddyInfo = 5;
        static final int TRANSACTION_requestRestoreItemListFromTrashBinWithData = 151;
        static final int TRANSACTION_requestServiceActivation = 3;
        static final int TRANSACTION_requestServiceDeactivation = 4;
        static final int TRANSACTION_requestServiceNumber = 112;
        static final int TRANSACTION_requestShareListUpdateWithItemFileList = 79;
        static final int TRANSACTION_requestShareListUpdateWithItemFileListWithData = 100;
        static final int TRANSACTION_requestShareSync = 11;
        static final int TRANSACTION_requestShareSyncWithData = 88;
        static final int TRANSACTION_requestShareSyncWithOption = 116;
        static final int TRANSACTION_requestShareUpdateWithUriList = 64;
        static final int TRANSACTION_requestShareWithData = 114;
        static final int TRANSACTION_requestShareWithFileList = 62;
        static final int TRANSACTION_requestShareWithFileListWithData = 137;
        static final int TRANSACTION_requestShareWithItemFileList = 77;
        static final int TRANSACTION_requestShareWithItemFileListWithData = 99;
        static final int TRANSACTION_requestShareWithPendingIntent = 12;
        static final int TRANSACTION_requestSharedItem = 13;
        static final int TRANSACTION_requestSharedItemDeletion = 14;
        static final int TRANSACTION_requestSharedItemDeletionWithData = 138;
        static final int TRANSACTION_requestSharedItemList = 65;
        static final int TRANSACTION_requestSharedItemListDeletion = 76;
        static final int TRANSACTION_requestSharedItemListDeletionWithData = 98;
        static final int TRANSACTION_requestSharedItemListInTrashBinWithData = 154;
        static final int TRANSACTION_requestSharedItemListUpdate = 78;
        static final int TRANSACTION_requestSharedItemListWithFileList = 66;
        static final int TRANSACTION_requestSharedItemListWithFileListWithData = 103;
        static final int TRANSACTION_requestSharedItemSync = 31;
        static final int TRANSACTION_requestSharedItemSyncWithData = 140;
        static final int TRANSACTION_requestSharedItemSyncWithResolution = 82;
        static final int TRANSACTION_requestSharedItemSyncWithResolutionWithData = 97;
        static final int TRANSACTION_requestSharedItemUpdate = 60;
        static final int TRANSACTION_requestSharedItemWithData = 141;
        static final int TRANSACTION_requestSharedItemWithGroupId = 72;
        static final int TRANSACTION_requestSharedItemWithGroupIdWithData = 142;
        static final int TRANSACTION_requestSpace = 15;
        static final int TRANSACTION_requestSpaceCreation = 16;
        static final int TRANSACTION_requestSpaceCreationWithData = 90;
        static final int TRANSACTION_requestSpaceDeletion = 17;
        static final int TRANSACTION_requestSpaceDeletionWithData = 91;
        static final int TRANSACTION_requestSpaceList = 18;
        static final int TRANSACTION_requestSpaceListSync = 30;
        static final int TRANSACTION_requestSpaceListSyncWithData = 96;
        static final int TRANSACTION_requestSpaceListWithData = 92;
        static final int TRANSACTION_requestSpaceUpdate = 19;
        static final int TRANSACTION_requestSpaceUpdateWithData = 93;
        static final int TRANSACTION_requestSpaceWithData = 89;
        static final int TRANSACTION_requestSync = 1;
        static final int TRANSACTION_requestThumbnailDownload = 111;
        static final int TRANSACTION_requestWebLinkEnabled = 117;
        static final int TRANSACTION_resumeShare = 25;
        static final int TRANSACTION_setBuddyActivityListRead = 47;
        static final int TRANSACTION_setDisclaimerAgreementForSocial = 104;
        static final int TRANSACTION_setShareStatusListener = 28;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class Proxy implements IMobileServiceSocial {
            public static IMobileServiceSocial sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int cancelShare(String str, String str2) {
                int iCancelShare;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (this.mRemote.transact(26, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iCancelShare = parcelObtain2.readInt();
                    } else {
                        iCancelShare = Stub.getDefaultImpl().cancelShare(str, str2);
                    }
                    return iCancelShare;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public void clearSpaceUnreadCount(String str, String str2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (this.mRemote.transact(29, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().clearSpaceUnreadCount(str, str2);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public void clearSpaceUnreadCountWithData(String str, Bundle bundle, String str2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeString(str2);
                    if (this.mRemote.transact(95, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().clearSpaceUnreadCountWithData(str, bundle, str2);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int dataSyncDelete(String str, Bundle bundle, IBundleResultCallback iBundleResultCallback) {
                int iDataSyncDelete;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iBundleResultCallback != null ? iBundleResultCallback.asBinder() : null);
                    if (this.mRemote.transact(158, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iDataSyncDelete = parcelObtain2.readInt();
                    } else {
                        iDataSyncDelete = Stub.getDefaultImpl().dataSyncDelete(str, bundle, iBundleResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iDataSyncDelete;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int dataSyncGetSyncedData(String str, Bundle bundle, IBundleResultCallback iBundleResultCallback) {
                int iDataSyncGetSyncedData;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iBundleResultCallback != null ? iBundleResultCallback.asBinder() : null);
                    if (this.mRemote.transact(159, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iDataSyncGetSyncedData = parcelObtain2.readInt();
                    } else {
                        iDataSyncGetSyncedData = Stub.getDefaultImpl().dataSyncGetSyncedData(str, bundle, iBundleResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iDataSyncGetSyncedData;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int dataSyncUpsert(String str, Bundle bundle, IBundleResultCallback iBundleResultCallback) {
                int iDataSyncUpsert;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iBundleResultCallback != null ? iBundleResultCallback.asBinder() : null);
                    if (this.mRemote.transact(157, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iDataSyncUpsert = parcelObtain2.readInt();
                    } else {
                        iDataSyncUpsert = Stub.getDefaultImpl().dataSyncUpsert(str, bundle, iBundleResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iDataSyncUpsert;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public Bundle getBuddyActivityCount(Bundle bundle) {
                Bundle buddyActivityCount;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(81, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        buddyActivityCount = parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                    } else {
                        buddyActivityCount = Stub.getDefaultImpl().getBuddyActivityCount(bundle);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return buddyActivityCount;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public Bundle getBuddyActivityList(Bundle bundle) {
                Bundle buddyActivityList;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(46, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        buddyActivityList = parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                    } else {
                        buddyActivityList = Stub.getDefaultImpl().getBuddyActivityList(bundle);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return buddyActivityList;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public void getBuddyInfo(Bundle bundle, IBuddyInfoResultCallback iBuddyInfoResultCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iBuddyInfoResultCallback != null ? iBuddyInfoResultCallback.asBinder() : null);
                    if (this.mRemote.transact(110, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().getBuddyInfo(bundle, iBuddyInfoResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public Bundle getBuddySyncTime() {
                Bundle buddySyncTime;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(163, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        buddySyncTime = parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                    } else {
                        buddySyncTime = Stub.getDefaultImpl().getBuddySyncTime();
                    }
                    return buddySyncTime;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int getCountryTypeForAgreement() {
                int countryTypeForAgreement;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(61, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        countryTypeForAgreement = parcelObtain2.readInt();
                    } else {
                        countryTypeForAgreement = Stub.getDefaultImpl().getCountryTypeForAgreement();
                    }
                    return countryTypeForAgreement;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public Bundle getDeviceAuthInfoCached() {
                Bundle deviceAuthInfoCached;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(107, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        deviceAuthInfoCached = parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                    } else {
                        deviceAuthInfoCached = Stub.getDefaultImpl().getDeviceAuthInfoCached();
                    }
                    return deviceAuthInfoCached;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public boolean getDisclaimerAgreementForService(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(106, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        boolean disclaimerAgreementForService = Stub.getDefaultImpl().getDisclaimerAgreementForService(bundle);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return disclaimerAgreementForService;
                    }
                    parcelObtain2.readException();
                    boolean z = parcelObtain2.readInt() != 0;
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return z;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public boolean getDisclaimerAgreementForSocial() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(105, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDisclaimerAgreementForSocial();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int getDisclosureScope(Bundle bundle) {
                int disclosureScope;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(162, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        disclosureScope = parcelObtain2.readInt();
                    } else {
                        disclosureScope = Stub.getDefaultImpl().getDisclosureScope(bundle);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return disclosureScope;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public Bundle getFamilyQuotaWithData(Bundle bundle) {
                Bundle familyQuotaWithData;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(148, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        familyQuotaWithData = parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                    } else {
                        familyQuotaWithData = Stub.getDefaultImpl().getFamilyQuotaWithData(bundle);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return familyQuotaWithData;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public List<Bundle> getGroupList(String str) {
                List<Bundle> listCreateTypedArrayList;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (this.mRemote.transact(10, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        listCreateTypedArrayList = parcelObtain2.createTypedArrayList(Bundle.CREATOR);
                    } else {
                        listCreateTypedArrayList = Stub.getDefaultImpl().getGroupList(str);
                    }
                    return listCreateTypedArrayList;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public List<Bundle> getGroupListWithData(Bundle bundle) {
                List<Bundle> listCreateTypedArrayList;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(124, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        listCreateTypedArrayList = parcelObtain2.createTypedArrayList(Bundle.CREATOR);
                    } else {
                        listCreateTypedArrayList = Stub.getDefaultImpl().getGroupListWithData(bundle);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return listCreateTypedArrayList;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public Intent getIntentToDisplay(Bundle bundle) {
                Intent intentToDisplay;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(43, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        intentToDisplay = parcelObtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcelObtain2) : null;
                    } else {
                        intentToDisplay = Stub.getDefaultImpl().getIntentToDisplay(bundle);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return intentToDisplay;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public Bundle getNotification(Bundle bundle) {
                Bundle notification;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(59, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        notification = parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                    } else {
                        notification = Stub.getDefaultImpl().getNotification(bundle);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return notification;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public Bundle getQuota() {
                Bundle quota;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(115, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        quota = parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                    } else {
                        quota = Stub.getDefaultImpl().getQuota();
                    }
                    return quota;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public Bundle getQuotaWithData(Bundle bundle) {
                Bundle quotaWithData;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(118, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        quotaWithData = parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                    } else {
                        quotaWithData = Stub.getDefaultImpl().getQuotaWithData(bundle);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return quotaWithData;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public Bundle getServiceState() {
                Bundle serviceState;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(68, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        serviceState = parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                    } else {
                        serviceState = Stub.getDefaultImpl().getServiceState();
                    }
                    return serviceState;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int getShareStatus(String str, String str2) {
                int shareStatus;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (this.mRemote.transact(27, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        shareStatus = parcelObtain2.readInt();
                    } else {
                        shareStatus = Stub.getDefaultImpl().getShareStatus(str, str2);
                    }
                    return shareStatus;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public Bundle getVerifiedOriginalFileListWithData(Bundle bundle) {
                Bundle verifiedOriginalFileListWithData;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(143, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        verifiedOriginalFileListWithData = parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                    } else {
                        verifiedOriginalFileListWithData = Stub.getDefaultImpl().getVerifiedOriginalFileListWithData(bundle);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return verifiedOriginalFileListWithData;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public Bundle isPermissionGranted(Bundle bundle) {
                Bundle bundleIsPermissionGranted;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(119, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        bundleIsPermissionGranted = parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                    } else {
                        bundleIsPermissionGranted = Stub.getDefaultImpl().isPermissionGranted(bundle);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return bundleIsPermissionGranted;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int isServiceActivated(int i) {
                int iIsServiceActivated;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    if (this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iIsServiceActivated = parcelObtain2.readInt();
                    } else {
                        iIsServiceActivated = Stub.getDefaultImpl().isServiceActivated(i);
                    }
                    return iIsServiceActivated;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public boolean isServiceRegistered(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(108, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        boolean zIsServiceRegistered = Stub.getDefaultImpl().isServiceRegistered(bundle);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return zIsServiceRegistered;
                    }
                    parcelObtain2.readException();
                    boolean z = parcelObtain2.readInt() != 0;
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return z;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public Bundle isSomethingNeeded(Bundle bundle) {
                Bundle bundleIsSomethingNeeded;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(67, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        bundleIsSomethingNeeded = parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                    } else {
                        bundleIsSomethingNeeded = Stub.getDefaultImpl().isSomethingNeeded(bundle);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return bundleIsSomethingNeeded;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int pauseShare(String str, String str2) {
                int iPauseShare;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (this.mRemote.transact(24, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iPauseShare = parcelObtain2.readInt();
                    } else {
                        iPauseShare = Stub.getDefaultImpl().pauseShare(str, str2);
                    }
                    return iPauseShare;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public void requestActivity(Bundle bundle, IActivityBundlePartialResultCallback iActivityBundlePartialResultCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iActivityBundlePartialResultCallback != null ? iActivityBundlePartialResultCallback.asBinder() : null);
                    if (this.mRemote.transact(51, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().requestActivity(bundle, iActivityBundlePartialResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public void requestActivityChanges(IActivityBundlePartialResultCallback iActivityBundlePartialResultCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iActivityBundlePartialResultCallback != null ? iActivityBundlePartialResultCallback.asBinder() : null);
                    if (this.mRemote.transact(74, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().requestActivityChanges(iActivityBundlePartialResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public void requestActivityContent(Bundle bundle, IActivityBundleResultCallback iActivityBundleResultCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iActivityBundleResultCallback != null ? iActivityBundleResultCallback.asBinder() : null);
                    if (this.mRemote.transact(86, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().requestActivityContent(bundle, iActivityBundleResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public void requestActivityContentStreamingUrl(Bundle bundle, IActivityBundleResultCallback iActivityBundleResultCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iActivityBundleResultCallback != null ? iActivityBundleResultCallback.asBinder() : null);
                    if (this.mRemote.transact(84, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().requestActivityContentStreamingUrl(bundle, iActivityBundleResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public void requestActivityDeletion(Bundle bundle, IActivityResultCallback iActivityResultCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iActivityResultCallback != null ? iActivityResultCallback.asBinder() : null);
                    if (this.mRemote.transact(45, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().requestActivityDeletion(bundle, iActivityResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public void requestActivityImageList(Bundle bundle, IBundleProgressResultCallback iBundleProgressResultCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iBundleProgressResultCallback != null ? iBundleProgressResultCallback.asBinder() : null);
                    if (this.mRemote.transact(69, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().requestActivityImageList(bundle, iBundleProgressResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public void requestActivityList(Bundle bundle, IActivityBundlePartialResultCallback iActivityBundlePartialResultCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iActivityBundlePartialResultCallback != null ? iActivityBundlePartialResultCallback.asBinder() : null);
                    if (this.mRemote.transact(44, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().requestActivityList(bundle, iActivityBundlePartialResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public Bundle requestActivityPosting(Bundle bundle, PendingIntent pendingIntent, IBundleProgressResultCallback iBundleProgressResultCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        parcelObtain.writeInt(1);
                        pendingIntent.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iBundleProgressResultCallback != null ? iBundleProgressResultCallback.asBinder() : null);
                    if (!this.mRemote.transact(83, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        Bundle bundleRequestActivityPosting = Stub.getDefaultImpl().requestActivityPosting(bundle, pendingIntent, iBundleProgressResultCallback);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return bundleRequestActivityPosting;
                    }
                    parcelObtain2.readException();
                    Bundle bundle2 = parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return bundle2;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public void requestActivitySync(IActivityBundleResultCallback iActivityBundleResultCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iActivityBundleResultCallback != null ? iActivityBundleResultCallback.asBinder() : null);
                    if (this.mRemote.transact(50, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().requestActivitySync(iActivityBundleResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestAllSpaceList(String str, ISpaceListResultCallback iSpaceListResultCallback) {
                int iRequestAllSpaceList;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iSpaceListResultCallback != null ? iSpaceListResultCallback.asBinder() : null);
                    if (this.mRemote.transact(20, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestAllSpaceList = parcelObtain2.readInt();
                    } else {
                        iRequestAllSpaceList = Stub.getDefaultImpl().requestAllSpaceList(str, iSpaceListResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestAllSpaceList;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestAllSpaceListWithData(String str, Bundle bundle, ISpaceListResultCallback iSpaceListResultCallback) {
                int iRequestAllSpaceListWithData;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iSpaceListResultCallback != null ? iSpaceListResultCallback.asBinder() : null);
                    if (this.mRemote.transact(94, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestAllSpaceListWithData = parcelObtain2.readInt();
                    } else {
                        iRequestAllSpaceListWithData = Stub.getDefaultImpl().requestAllSpaceListWithData(str, bundle, iSpaceListResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestAllSpaceListWithData;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public void requestAppUpdateAndLaunchForBuddy(Bundle bundle, IBuddyInfoResultCallback iBuddyInfoResultCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iBuddyInfoResultCallback != null ? iBuddyInfoResultCallback.asBinder() : null);
                    if (this.mRemote.transact(155, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().requestAppUpdateAndLaunchForBuddy(bundle, iBuddyInfoResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public void requestBuddySync(int i, ISyncResultCallback iSyncResultCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeStrongBinder(iSyncResultCallback != null ? iSyncResultCallback.asBinder() : null);
                    if (this.mRemote.transact(109, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().requestBuddySync(i, iSyncResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public String requestBulkItemShare(Bundle bundle, IShareBulkItemResultCallback iShareBulkItemResultCallback) {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iShareBulkItemResultCallback != null ? iShareBulkItemResultCallback.asBinder() : null);
                    if (this.mRemote.transact(156, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = Stub.getDefaultImpl().requestBulkItemShare(bundle, iShareBulkItemResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return string;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public void requestCommentCreation(Bundle bundle, IFeedbackBundleResultCallback iFeedbackBundleResultCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iFeedbackBundleResultCallback != null ? iFeedbackBundleResultCallback.asBinder() : null);
                    if (this.mRemote.transact(54, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().requestCommentCreation(bundle, iFeedbackBundleResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public void requestCommentDeletion(Bundle bundle, IFeedbackBundleResultCallback iFeedbackBundleResultCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iFeedbackBundleResultCallback != null ? iFeedbackBundleResultCallback.asBinder() : null);
                    if (this.mRemote.transact(56, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().requestCommentDeletion(bundle, iFeedbackBundleResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public void requestCommentList(Bundle bundle, IFeedbackBundlePartialResultCallback iFeedbackBundlePartialResultCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iFeedbackBundlePartialResultCallback != null ? iFeedbackBundlePartialResultCallback.asBinder() : null);
                    if (this.mRemote.transact(53, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().requestCommentList(bundle, iFeedbackBundlePartialResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public void requestCommentUpdate(Bundle bundle, IFeedbackBundleResultCallback iFeedbackBundleResultCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iFeedbackBundleResultCallback != null ? iFeedbackBundleResultCallback.asBinder() : null);
                    if (this.mRemote.transact(55, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().requestCommentUpdate(bundle, iFeedbackBundleResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public Bundle requestContentsController(Bundle bundle) {
                Bundle bundleRequestContentsController;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(85, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        bundleRequestContentsController = parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                    } else {
                        bundleRequestContentsController = Stub.getDefaultImpl().requestContentsController(bundle);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return bundleRequestContentsController;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestDelegateAuthorityOfOwner(String str, String str2, String str3, IGroupResultCallback iGroupResultCallback) {
                int iRequestDelegateAuthorityOfOwner;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeStrongBinder(iGroupResultCallback != null ? iGroupResultCallback.asBinder() : null);
                    if (this.mRemote.transact(71, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestDelegateAuthorityOfOwner = parcelObtain2.readInt();
                    } else {
                        iRequestDelegateAuthorityOfOwner = Stub.getDefaultImpl().requestDelegateAuthorityOfOwner(str, str2, str3, iGroupResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestDelegateAuthorityOfOwner;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestDelegateAuthorityOfOwnerWithData(Bundle bundle, IGroupResultCallback iGroupResultCallback) {
                int iRequestDelegateAuthorityOfOwnerWithData;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iGroupResultCallback != null ? iGroupResultCallback.asBinder() : null);
                    if (this.mRemote.transact(135, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestDelegateAuthorityOfOwnerWithData = parcelObtain2.readInt();
                    } else {
                        iRequestDelegateAuthorityOfOwnerWithData = Stub.getDefaultImpl().requestDelegateAuthorityOfOwnerWithData(bundle, iGroupResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestDelegateAuthorityOfOwnerWithData;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public void requestDeleteAllActivity(IDeleteAllActivityResultCallback iDeleteAllActivityResultCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iDeleteAllActivityResultCallback != null ? iDeleteAllActivityResultCallback.asBinder() : null);
                    if (this.mRemote.transact(6, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().requestDeleteAllActivity(iDeleteAllActivityResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestDeleteAllItemsFromTrashBinWithData(Bundle bundle, ITrashBinResultCallback iTrashBinResultCallback) {
                int iRequestDeleteAllItemsFromTrashBinWithData;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iTrashBinResultCallback != null ? iTrashBinResultCallback.asBinder() : null);
                    if (this.mRemote.transact(153, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestDeleteAllItemsFromTrashBinWithData = parcelObtain2.readInt();
                    } else {
                        iRequestDeleteAllItemsFromTrashBinWithData = Stub.getDefaultImpl().requestDeleteAllItemsFromTrashBinWithData(bundle, iTrashBinResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestDeleteAllItemsFromTrashBinWithData;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestDeleteItemListFromTrashBinWithData(Bundle bundle, ITrashBinResultCallback iTrashBinResultCallback) {
                int iRequestDeleteItemListFromTrashBinWithData;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iTrashBinResultCallback != null ? iTrashBinResultCallback.asBinder() : null);
                    if (this.mRemote.transact(152, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestDeleteItemListFromTrashBinWithData = parcelObtain2.readInt();
                    } else {
                        iRequestDeleteItemListFromTrashBinWithData = Stub.getDefaultImpl().requestDeleteItemListFromTrashBinWithData(bundle, iTrashBinResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestDeleteItemListFromTrashBinWithData;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestDisclosureScope(Bundle bundle, IBundleResultCallback iBundleResultCallback) {
                int iRequestDisclosureScope;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iBundleResultCallback != null ? iBundleResultCallback.asBinder() : null);
                    if (this.mRemote.transact(160, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestDisclosureScope = parcelObtain2.readInt();
                    } else {
                        iRequestDisclosureScope = Stub.getDefaultImpl().requestDisclosureScope(bundle, iBundleResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestDisclosureScope;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestDisclosureScopeUpdate(Bundle bundle, IBundleResultCallback iBundleResultCallback) {
                int iRequestDisclosureScopeUpdate;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iBundleResultCallback != null ? iBundleResultCallback.asBinder() : null);
                    if (this.mRemote.transact(161, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestDisclosureScopeUpdate = parcelObtain2.readInt();
                    } else {
                        iRequestDisclosureScopeUpdate = Stub.getDefaultImpl().requestDisclosureScopeUpdate(bundle, iBundleResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestDisclosureScopeUpdate;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public void requestEmotionMemberList(Bundle bundle, IFeedbackBundlePartialResultCallback iFeedbackBundlePartialResultCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iFeedbackBundlePartialResultCallback != null ? iFeedbackBundlePartialResultCallback.asBinder() : null);
                    if (this.mRemote.transact(58, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().requestEmotionMemberList(bundle, iFeedbackBundlePartialResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public void requestEmotionUpdate(Bundle bundle, IFeedbackBundleResultCallback iFeedbackBundleResultCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iFeedbackBundleResultCallback != null ? iFeedbackBundleResultCallback.asBinder() : null);
                    if (this.mRemote.transact(57, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().requestEmotionUpdate(bundle, iFeedbackBundleResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestFamilyGroupCreationWithData(Bundle bundle, Bundle bundle2, IGroupResultCallback iGroupResultCallback) {
                int iRequestFamilyGroupCreationWithData;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (bundle2 != null) {
                        parcelObtain.writeInt(1);
                        bundle2.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iGroupResultCallback != null ? iGroupResultCallback.asBinder() : null);
                    if (this.mRemote.transact(146, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestFamilyGroupCreationWithData = parcelObtain2.readInt();
                    } else {
                        iRequestFamilyGroupCreationWithData = Stub.getDefaultImpl().requestFamilyGroupCreationWithData(bundle, bundle2, iGroupResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestFamilyGroupCreationWithData;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestFamilyGroupDeletionWithData(Bundle bundle, IGroupRequestResultCallback iGroupRequestResultCallback) {
                int iRequestFamilyGroupDeletionWithData;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iGroupRequestResultCallback != null ? iGroupRequestResultCallback.asBinder() : null);
                    if (this.mRemote.transact(147, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestFamilyGroupDeletionWithData = parcelObtain2.readInt();
                    } else {
                        iRequestFamilyGroupDeletionWithData = Stub.getDefaultImpl().requestFamilyGroupDeletionWithData(bundle, iGroupRequestResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestFamilyGroupDeletionWithData;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestFamilyGroupMemberListWithData(Bundle bundle, IMemberListResultCallback iMemberListResultCallback) {
                int iRequestFamilyGroupMemberListWithData;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iMemberListResultCallback != null ? iMemberListResultCallback.asBinder() : null);
                    if (this.mRemote.transact(149, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestFamilyGroupMemberListWithData = parcelObtain2.readInt();
                    } else {
                        iRequestFamilyGroupMemberListWithData = Stub.getDefaultImpl().requestFamilyGroupMemberListWithData(bundle, iMemberListResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestFamilyGroupMemberListWithData;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public void requestFeedback(Bundle bundle, IFeedbackBundlePartialResultCallback iFeedbackBundlePartialResultCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iFeedbackBundlePartialResultCallback != null ? iFeedbackBundlePartialResultCallback.asBinder() : null);
                    if (this.mRemote.transact(52, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().requestFeedback(bundle, iFeedbackBundlePartialResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestGroup(String str, String str2, IGroupResultCallback iGroupResultCallback) {
                int iRequestGroup;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStrongBinder(iGroupResultCallback != null ? iGroupResultCallback.asBinder() : null);
                    if (this.mRemote.transact(9, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestGroup = parcelObtain2.readInt();
                    } else {
                        iRequestGroup = Stub.getDefaultImpl().requestGroup(str, str2, iGroupResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestGroup;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestGroupAuthorityChange(Bundle bundle, IGroupResultCallback iGroupResultCallback) {
                int iRequestGroupAuthorityChange;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iGroupResultCallback != null ? iGroupResultCallback.asBinder() : null);
                    if (this.mRemote.transact(136, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestGroupAuthorityChange = parcelObtain2.readInt();
                    } else {
                        iRequestGroupAuthorityChange = Stub.getDefaultImpl().requestGroupAuthorityChange(bundle, iGroupResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestGroupAuthorityChange;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestGroupCreation(String str, Bundle bundle, Bundle bundle2, IGroupInvitationResultCallback iGroupInvitationResultCallback) {
                int iRequestGroupCreation;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (bundle2 != null) {
                        parcelObtain.writeInt(1);
                        bundle2.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iGroupInvitationResultCallback != null ? iGroupInvitationResultCallback.asBinder() : null);
                    if (this.mRemote.transact(32, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestGroupCreation = parcelObtain2.readInt();
                    } else {
                        iRequestGroupCreation = Stub.getDefaultImpl().requestGroupCreation(str, bundle, bundle2, iGroupInvitationResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestGroupCreation;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestGroupCreationWithData(Bundle bundle, Bundle bundle2, Bundle bundle3, IGroupInvitationResultCallback iGroupInvitationResultCallback) {
                int iRequestGroupCreationWithData;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (bundle2 != null) {
                        parcelObtain.writeInt(1);
                        bundle2.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (bundle3 != null) {
                        parcelObtain.writeInt(1);
                        bundle3.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iGroupInvitationResultCallback != null ? iGroupInvitationResultCallback.asBinder() : null);
                    if (this.mRemote.transact(125, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestGroupCreationWithData = parcelObtain2.readInt();
                    } else {
                        iRequestGroupCreationWithData = Stub.getDefaultImpl().requestGroupCreationWithData(bundle, bundle2, bundle3, iGroupInvitationResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestGroupCreationWithData;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestGroupDeletion(String str, String str2, IGroupRequestResultCallback iGroupRequestResultCallback) {
                int iRequestGroupDeletion;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStrongBinder(iGroupRequestResultCallback != null ? iGroupRequestResultCallback.asBinder() : null);
                    if (this.mRemote.transact(33, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestGroupDeletion = parcelObtain2.readInt();
                    } else {
                        iRequestGroupDeletion = Stub.getDefaultImpl().requestGroupDeletion(str, str2, iGroupRequestResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestGroupDeletion;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestGroupDeletionWithData(Bundle bundle, IGroupRequestResultCallback iGroupRequestResultCallback) {
                int iRequestGroupDeletionWithData;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iGroupRequestResultCallback != null ? iGroupRequestResultCallback.asBinder() : null);
                    if (this.mRemote.transact(126, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestGroupDeletionWithData = parcelObtain2.readInt();
                    } else {
                        iRequestGroupDeletionWithData = Stub.getDefaultImpl().requestGroupDeletionWithData(bundle, iGroupRequestResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestGroupDeletionWithData;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestGroupInvitationAcceptance(String str, String str2, IGroupRequestResultCallback iGroupRequestResultCallback) {
                int iRequestGroupInvitationAcceptance;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStrongBinder(iGroupRequestResultCallback != null ? iGroupRequestResultCallback.asBinder() : null);
                    if (this.mRemote.transact(35, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestGroupInvitationAcceptance = parcelObtain2.readInt();
                    } else {
                        iRequestGroupInvitationAcceptance = Stub.getDefaultImpl().requestGroupInvitationAcceptance(str, str2, iGroupRequestResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestGroupInvitationAcceptance;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestGroupInvitationAcceptanceWithData(Bundle bundle, IGroupRequestResultCallback iGroupRequestResultCallback) {
                int iRequestGroupInvitationAcceptanceWithData;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iGroupRequestResultCallback != null ? iGroupRequestResultCallback.asBinder() : null);
                    if (this.mRemote.transact(128, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestGroupInvitationAcceptanceWithData = parcelObtain2.readInt();
                    } else {
                        iRequestGroupInvitationAcceptanceWithData = Stub.getDefaultImpl().requestGroupInvitationAcceptanceWithData(bundle, iGroupRequestResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestGroupInvitationAcceptanceWithData;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestGroupInvitationRejection(String str, String str2, IGroupRequestResultCallback iGroupRequestResultCallback) {
                int iRequestGroupInvitationRejection;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStrongBinder(iGroupRequestResultCallback != null ? iGroupRequestResultCallback.asBinder() : null);
                    if (this.mRemote.transact(36, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestGroupInvitationRejection = parcelObtain2.readInt();
                    } else {
                        iRequestGroupInvitationRejection = Stub.getDefaultImpl().requestGroupInvitationRejection(str, str2, iGroupRequestResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestGroupInvitationRejection;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestGroupInvitationRejectionWithData(Bundle bundle, IGroupRequestResultCallback iGroupRequestResultCallback) {
                int iRequestGroupInvitationRejectionWithData;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iGroupRequestResultCallback != null ? iGroupRequestResultCallback.asBinder() : null);
                    if (this.mRemote.transact(129, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestGroupInvitationRejectionWithData = parcelObtain2.readInt();
                    } else {
                        iRequestGroupInvitationRejectionWithData = Stub.getDefaultImpl().requestGroupInvitationRejectionWithData(bundle, iGroupRequestResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestGroupInvitationRejectionWithData;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestGroupList(String str, IGroupListResultCallback iGroupListResultCallback) {
                int iRequestGroupList;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iGroupListResultCallback != null ? iGroupListResultCallback.asBinder() : null);
                    if (this.mRemote.transact(8, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestGroupList = parcelObtain2.readInt();
                    } else {
                        iRequestGroupList = Stub.getDefaultImpl().requestGroupList(str, iGroupListResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestGroupList;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestGroupListWithData(Bundle bundle, IGroupListResultCallback iGroupListResultCallback) {
                int iRequestGroupListWithData;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iGroupListResultCallback != null ? iGroupListResultCallback.asBinder() : null);
                    if (this.mRemote.transact(121, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestGroupListWithData = parcelObtain2.readInt();
                    } else {
                        iRequestGroupListWithData = Stub.getDefaultImpl().requestGroupListWithData(bundle, iGroupListResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestGroupListWithData;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestGroupMemberInvitation(String str, String str2, Bundle bundle, IGroupInvitationResultCallback iGroupInvitationResultCallback) {
                int iRequestGroupMemberInvitation;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iGroupInvitationResultCallback != null ? iGroupInvitationResultCallback.asBinder() : null);
                    if (this.mRemote.transact(34, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestGroupMemberInvitation = parcelObtain2.readInt();
                    } else {
                        iRequestGroupMemberInvitation = Stub.getDefaultImpl().requestGroupMemberInvitation(str, str2, bundle, iGroupInvitationResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestGroupMemberInvitation;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestGroupMemberInvitationWithData(Bundle bundle, Bundle bundle2, IGroupInvitationResultCallback iGroupInvitationResultCallback) {
                int iRequestGroupMemberInvitationWithData;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (bundle2 != null) {
                        parcelObtain.writeInt(1);
                        bundle2.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iGroupInvitationResultCallback != null ? iGroupInvitationResultCallback.asBinder() : null);
                    if (this.mRemote.transact(127, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestGroupMemberInvitationWithData = parcelObtain2.readInt();
                    } else {
                        iRequestGroupMemberInvitationWithData = Stub.getDefaultImpl().requestGroupMemberInvitationWithData(bundle, bundle2, iGroupInvitationResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestGroupMemberInvitationWithData;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestGroupMemberList(String str, String str2, IMemberListResultCallback iMemberListResultCallback) {
                int iRequestGroupMemberList;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStrongBinder(iMemberListResultCallback != null ? iMemberListResultCallback.asBinder() : null);
                    if (this.mRemote.transact(37, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestGroupMemberList = parcelObtain2.readInt();
                    } else {
                        iRequestGroupMemberList = Stub.getDefaultImpl().requestGroupMemberList(str, str2, iMemberListResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestGroupMemberList;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestGroupMemberListWithData(Bundle bundle, IMemberListResultCallback iMemberListResultCallback) {
                int iRequestGroupMemberListWithData;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iMemberListResultCallback != null ? iMemberListResultCallback.asBinder() : null);
                    if (this.mRemote.transact(130, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestGroupMemberListWithData = parcelObtain2.readInt();
                    } else {
                        iRequestGroupMemberListWithData = Stub.getDefaultImpl().requestGroupMemberListWithData(bundle, iMemberListResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestGroupMemberListWithData;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestGroupMemberRemoval(String str, String str2, String str3, IGroupRequestResultCallback iGroupRequestResultCallback) {
                int iRequestGroupMemberRemoval;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeStrongBinder(iGroupRequestResultCallback != null ? iGroupRequestResultCallback.asBinder() : null);
                    if (this.mRemote.transact(39, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestGroupMemberRemoval = parcelObtain2.readInt();
                    } else {
                        iRequestGroupMemberRemoval = Stub.getDefaultImpl().requestGroupMemberRemoval(str, str2, str3, iGroupRequestResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestGroupMemberRemoval;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestGroupMemberRemovalWithData(Bundle bundle, IGroupRequestResultCallback iGroupRequestResultCallback) {
                int iRequestGroupMemberRemovalWithData;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iGroupRequestResultCallback != null ? iGroupRequestResultCallback.asBinder() : null);
                    if (this.mRemote.transact(132, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestGroupMemberRemovalWithData = parcelObtain2.readInt();
                    } else {
                        iRequestGroupMemberRemovalWithData = Stub.getDefaultImpl().requestGroupMemberRemovalWithData(bundle, iGroupRequestResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestGroupMemberRemovalWithData;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestGroupPendingInvitationCancellation(String str, String str2, String str3, IGroupRequestResultCallback iGroupRequestResultCallback) {
                int iRequestGroupPendingInvitationCancellation;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeStrongBinder(iGroupRequestResultCallback != null ? iGroupRequestResultCallback.asBinder() : null);
                    if (this.mRemote.transact(41, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestGroupPendingInvitationCancellation = parcelObtain2.readInt();
                    } else {
                        iRequestGroupPendingInvitationCancellation = Stub.getDefaultImpl().requestGroupPendingInvitationCancellation(str, str2, str3, iGroupRequestResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestGroupPendingInvitationCancellation;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestGroupPendingInvitationCancellationWithData(Bundle bundle, IGroupRequestResultCallback iGroupRequestResultCallback) {
                int iRequestGroupPendingInvitationCancellationWithData;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iGroupRequestResultCallback != null ? iGroupRequestResultCallback.asBinder() : null);
                    if (this.mRemote.transact(134, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestGroupPendingInvitationCancellationWithData = parcelObtain2.readInt();
                    } else {
                        iRequestGroupPendingInvitationCancellationWithData = Stub.getDefaultImpl().requestGroupPendingInvitationCancellationWithData(bundle, iGroupRequestResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestGroupPendingInvitationCancellationWithData;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestGroupSync(String str, IGroupSyncResultCallback iGroupSyncResultCallback) {
                int iRequestGroupSync;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iGroupSyncResultCallback != null ? iGroupSyncResultCallback.asBinder() : null);
                    if (this.mRemote.transact(7, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestGroupSync = parcelObtain2.readInt();
                    } else {
                        iRequestGroupSync = Stub.getDefaultImpl().requestGroupSync(str, iGroupSyncResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestGroupSync;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestGroupSyncWithData(Bundle bundle, IGroupSyncResultCallback iGroupSyncResultCallback) {
                int iRequestGroupSyncWithData;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iGroupSyncResultCallback != null ? iGroupSyncResultCallback.asBinder() : null);
                    if (this.mRemote.transact(122, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestGroupSyncWithData = parcelObtain2.readInt();
                    } else {
                        iRequestGroupSyncWithData = Stub.getDefaultImpl().requestGroupSyncWithData(bundle, iGroupSyncResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestGroupSyncWithData;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestGroupSyncWithoutImage(String str, IGroupSyncResultCallback iGroupSyncResultCallback) {
                int iRequestGroupSyncWithoutImage;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iGroupSyncResultCallback != null ? iGroupSyncResultCallback.asBinder() : null);
                    if (this.mRemote.transact(87, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestGroupSyncWithoutImage = parcelObtain2.readInt();
                    } else {
                        iRequestGroupSyncWithoutImage = Stub.getDefaultImpl().requestGroupSyncWithoutImage(str, iGroupSyncResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestGroupSyncWithoutImage;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestGroupSyncWithoutImageWithData(Bundle bundle, IGroupSyncResultCallback iGroupSyncResultCallback) {
                int iRequestGroupSyncWithoutImageWithData;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iGroupSyncResultCallback != null ? iGroupSyncResultCallback.asBinder() : null);
                    if (this.mRemote.transact(123, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestGroupSyncWithoutImageWithData = parcelObtain2.readInt();
                    } else {
                        iRequestGroupSyncWithoutImageWithData = Stub.getDefaultImpl().requestGroupSyncWithoutImageWithData(bundle, iGroupSyncResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestGroupSyncWithoutImageWithData;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestGroupUpdate(String str, String str2, Bundle bundle, IGroupResultCallback iGroupResultCallback) {
                int iRequestGroupUpdate;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iGroupResultCallback != null ? iGroupResultCallback.asBinder() : null);
                    if (this.mRemote.transact(73, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestGroupUpdate = parcelObtain2.readInt();
                    } else {
                        iRequestGroupUpdate = Stub.getDefaultImpl().requestGroupUpdate(str, str2, bundle, iGroupResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestGroupUpdate;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestGroupWithData(Bundle bundle, IGroupResultCallback iGroupResultCallback) {
                int iRequestGroupWithData;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iGroupResultCallback != null ? iGroupResultCallback.asBinder() : null);
                    if (this.mRemote.transact(120, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestGroupWithData = parcelObtain2.readInt();
                    } else {
                        iRequestGroupWithData = Stub.getDefaultImpl().requestGroupWithData(bundle, iGroupResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestGroupWithData;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestGroupWithInvitationList(String str, IGroupListWithInvitationResultCallback iGroupListWithInvitationResultCallback) {
                int iRequestGroupWithInvitationList;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iGroupListWithInvitationResultCallback != null ? iGroupListWithInvitationResultCallback.asBinder() : null);
                    if (this.mRemote.transact(38, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestGroupWithInvitationList = parcelObtain2.readInt();
                    } else {
                        iRequestGroupWithInvitationList = Stub.getDefaultImpl().requestGroupWithInvitationList(str, iGroupListWithInvitationResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestGroupWithInvitationList;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestGroupWithInvitationListWithData(Bundle bundle, IGroupListWithInvitationResultCallback iGroupListWithInvitationResultCallback) {
                int iRequestGroupWithInvitationListWithData;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iGroupListWithInvitationResultCallback != null ? iGroupListWithInvitationResultCallback.asBinder() : null);
                    if (this.mRemote.transact(131, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestGroupWithInvitationListWithData = parcelObtain2.readInt();
                    } else {
                        iRequestGroupWithInvitationListWithData = Stub.getDefaultImpl().requestGroupWithInvitationListWithData(bundle, iGroupListWithInvitationResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestGroupWithInvitationListWithData;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestInstantShare(String str, Bundle bundle, List<Bundle> list, IShareResultCallback iShareResultCallback) {
                int iRequestInstantShare;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeTypedList(list);
                    parcelObtain.writeStrongBinder(iShareResultCallback != null ? iShareResultCallback.asBinder() : null);
                    if (this.mRemote.transact(42, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestInstantShare = parcelObtain2.readInt();
                    } else {
                        iRequestInstantShare = Stub.getDefaultImpl().requestInstantShare(str, bundle, list, iShareResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestInstantShare;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestInvitationLinkCreation(Bundle bundle, IGroupResultCallback iGroupResultCallback) {
                int iRequestInvitationLinkCreation;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iGroupResultCallback != null ? iGroupResultCallback.asBinder() : null);
                    if (this.mRemote.transact(144, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestInvitationLinkCreation = parcelObtain2.readInt();
                    } else {
                        iRequestInvitationLinkCreation = Stub.getDefaultImpl().requestInvitationLinkCreation(bundle, iGroupResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestInvitationLinkCreation;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestInvitationLinkDeletion(Bundle bundle, IGroupResultCallback iGroupResultCallback) {
                int iRequestInvitationLinkDeletion;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iGroupResultCallback != null ? iGroupResultCallback.asBinder() : null);
                    if (this.mRemote.transact(145, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestInvitationLinkDeletion = parcelObtain2.readInt();
                    } else {
                        iRequestInvitationLinkDeletion = Stub.getDefaultImpl().requestInvitationLinkDeletion(bundle, iGroupResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestInvitationLinkDeletion;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestLeave(String str, String str2, IGroupRequestResultCallback iGroupRequestResultCallback) {
                int iRequestLeave;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStrongBinder(iGroupRequestResultCallback != null ? iGroupRequestResultCallback.asBinder() : null);
                    if (this.mRemote.transact(40, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestLeave = parcelObtain2.readInt();
                    } else {
                        iRequestLeave = Stub.getDefaultImpl().requestLeave(str, str2, iGroupRequestResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestLeave;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestLeaveWithData(Bundle bundle, IGroupRequestResultCallback iGroupRequestResultCallback) {
                int iRequestLeaveWithData;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iGroupRequestResultCallback != null ? iGroupRequestResultCallback.asBinder() : null);
                    if (this.mRemote.transact(133, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestLeaveWithData = parcelObtain2.readInt();
                    } else {
                        iRequestLeaveWithData = Stub.getDefaultImpl().requestLeaveWithData(bundle, iGroupRequestResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestLeaveWithData;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestMoveItemListToTrashBinWithData(Bundle bundle, ITrashBinResultCallback iTrashBinResultCallback) {
                int iRequestMoveItemListToTrashBinWithData;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iTrashBinResultCallback != null ? iTrashBinResultCallback.asBinder() : null);
                    if (this.mRemote.transact(150, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestMoveItemListToTrashBinWithData = parcelObtain2.readInt();
                    } else {
                        iRequestMoveItemListToTrashBinWithData = Stub.getDefaultImpl().requestMoveItemListToTrashBinWithData(bundle, iTrashBinResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestMoveItemListToTrashBinWithData;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public void requestMyActivityPrivacy(IActivityBundleResultCallback iActivityBundleResultCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iActivityBundleResultCallback != null ? iActivityBundleResultCallback.asBinder() : null);
                    if (this.mRemote.transact(49, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().requestMyActivityPrivacy(iActivityBundleResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public void requestMyActivityPrivacyUpdate(Bundle bundle, IActivityResultCallback iActivityResultCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iActivityResultCallback != null ? iActivityResultCallback.asBinder() : null);
                    if (this.mRemote.transact(48, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().requestMyActivityPrivacyUpdate(bundle, iActivityResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestOriginalGroupImageDownload(String str, String str2, IGroupCoverImageDownloadingResultCallback iGroupCoverImageDownloadingResultCallback) {
                int iRequestOriginalGroupImageDownload;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStrongBinder(iGroupCoverImageDownloadingResultCallback != null ? iGroupCoverImageDownloadingResultCallback.asBinder() : null);
                    if (this.mRemote.transact(21, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestOriginalGroupImageDownload = parcelObtain2.readInt();
                    } else {
                        iRequestOriginalGroupImageDownload = Stub.getDefaultImpl().requestOriginalGroupImageDownload(str, str2, iGroupCoverImageDownloadingResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestOriginalGroupImageDownload;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestOriginalSharedContentWithFileListDownload(String str, String str2, String str3, List<String> list, IContentDownloadingResultCallback iContentDownloadingResultCallback, PendingIntent pendingIntent, Bundle bundle) {
                int iRequestOriginalSharedContentWithFileListDownload;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeStringList(list);
                    parcelObtain.writeStrongBinder(iContentDownloadingResultCallback != null ? iContentDownloadingResultCallback.asBinder() : null);
                    if (pendingIntent != null) {
                        parcelObtain.writeInt(1);
                        pendingIntent.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(63, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestOriginalSharedContentWithFileListDownload = parcelObtain2.readInt();
                    } else {
                        iRequestOriginalSharedContentWithFileListDownload = Stub.getDefaultImpl().requestOriginalSharedContentWithFileListDownload(str, str2, str3, list, iContentDownloadingResultCallback, pendingIntent, bundle);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestOriginalSharedContentWithFileListDownload;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestOriginalSharedContentWithFileListDownloadWithData(String str, String str2, String str3, List<String> list, Bundle bundle, IContentDownloadingResultCallback iContentDownloadingResultCallback, PendingIntent pendingIntent, Bundle bundle2) {
                int iRequestOriginalSharedContentWithFileListDownloadWithData;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeStringList(list);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iContentDownloadingResultCallback != null ? iContentDownloadingResultCallback.asBinder() : null);
                    if (pendingIntent != null) {
                        parcelObtain.writeInt(1);
                        pendingIntent.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (bundle2 != null) {
                        parcelObtain.writeInt(1);
                        bundle2.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(102, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestOriginalSharedContentWithFileListDownloadWithData = parcelObtain2.readInt();
                    } else {
                        iRequestOriginalSharedContentWithFileListDownloadWithData = Stub.getDefaultImpl().requestOriginalSharedContentWithFileListDownloadWithData(str, str2, str3, list, bundle, iContentDownloadingResultCallback, pendingIntent, bundle2);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestOriginalSharedContentWithFileListDownloadWithData;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestOriginalSharedContentWithItemFileListDownloadWithPath(String str, String str2, String str3, List<String> list, IContentDownloadingResultCallback iContentDownloadingResultCallback, PendingIntent pendingIntent, Bundle bundle, String str4) {
                int iRequestOriginalSharedContentWithItemFileListDownloadWithPath;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeStringList(list);
                    parcelObtain.writeStrongBinder(iContentDownloadingResultCallback != null ? iContentDownloadingResultCallback.asBinder() : null);
                    if (pendingIntent != null) {
                        parcelObtain.writeInt(1);
                        pendingIntent.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeString(str4);
                    if (this.mRemote.transact(80, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestOriginalSharedContentWithItemFileListDownloadWithPath = parcelObtain2.readInt();
                    } else {
                        iRequestOriginalSharedContentWithItemFileListDownloadWithPath = Stub.getDefaultImpl().requestOriginalSharedContentWithItemFileListDownloadWithPath(str, str2, str3, list, iContentDownloadingResultCallback, pendingIntent, bundle, str4);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestOriginalSharedContentWithItemFileListDownloadWithPath;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            /* JADX INFO: renamed from: requestOriginalSharedContentWithItemFileListDownloadWithPathWithData */
            public int mo5781xd48f8faa(String str, String str2, String str3, List<String> list, Bundle bundle, IContentDownloadingResultCallback iContentDownloadingResultCallback, PendingIntent pendingIntent, Bundle bundle2, String str4) {
                int iMo5781xd48f8faa;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeStringList(list);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iContentDownloadingResultCallback != null ? iContentDownloadingResultCallback.asBinder() : null);
                    if (pendingIntent != null) {
                        parcelObtain.writeInt(1);
                        pendingIntent.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (bundle2 != null) {
                        parcelObtain.writeInt(1);
                        bundle2.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeString(str4);
                    if (this.mRemote.transact(101, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iMo5781xd48f8faa = parcelObtain2.readInt();
                    } else {
                        iMo5781xd48f8faa = Stub.getDefaultImpl().mo5781xd48f8faa(str, str2, str3, list, bundle, iContentDownloadingResultCallback, pendingIntent, bundle2, str4);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iMo5781xd48f8faa;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestOriginalSharedContentsDownload(String str, String str2, String[] strArr, IContentDownloadingResultCallback iContentDownloadingResultCallback, PendingIntent pendingIntent, Bundle bundle) {
                int iRequestOriginalSharedContentsDownload;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStringArray(strArr);
                    parcelObtain.writeStrongBinder(iContentDownloadingResultCallback != null ? iContentDownloadingResultCallback.asBinder() : null);
                    if (pendingIntent != null) {
                        parcelObtain.writeInt(1);
                        pendingIntent.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(23, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestOriginalSharedContentsDownload = parcelObtain2.readInt();
                    } else {
                        iRequestOriginalSharedContentsDownload = Stub.getDefaultImpl().requestOriginalSharedContentsDownload(str, str2, strArr, iContentDownloadingResultCallback, pendingIntent, bundle);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestOriginalSharedContentsDownload;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestOriginalSharedContentsDownloadToHiddenFolder(Bundle bundle, IContentDownloadingResultCallback iContentDownloadingResultCallback) {
                int iRequestOriginalSharedContentsDownloadToHiddenFolder;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iContentDownloadingResultCallback != null ? iContentDownloadingResultCallback.asBinder() : null);
                    if (this.mRemote.transact(113, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestOriginalSharedContentsDownloadToHiddenFolder = parcelObtain2.readInt();
                    } else {
                        iRequestOriginalSharedContentsDownloadToHiddenFolder = Stub.getDefaultImpl().requestOriginalSharedContentsDownloadToHiddenFolder(bundle, iContentDownloadingResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestOriginalSharedContentsDownloadToHiddenFolder;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestOriginalSharedContentsDownloadWithPath(String str, String str2, String[] strArr, IContentDownloadingResultCallback iContentDownloadingResultCallback, PendingIntent pendingIntent, Bundle bundle, String str3) {
                int iRequestOriginalSharedContentsDownloadWithPath;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStringArray(strArr);
                    parcelObtain.writeStrongBinder(iContentDownloadingResultCallback != null ? iContentDownloadingResultCallback.asBinder() : null);
                    if (pendingIntent != null) {
                        parcelObtain.writeInt(1);
                        pendingIntent.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeString(str3);
                    if (this.mRemote.transact(75, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestOriginalSharedContentsDownloadWithPath = parcelObtain2.readInt();
                    } else {
                        iRequestOriginalSharedContentsDownloadWithPath = Stub.getDefaultImpl().requestOriginalSharedContentsDownloadWithPath(str, str2, strArr, iContentDownloadingResultCallback, pendingIntent, bundle, str3);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestOriginalSharedContentsDownloadWithPath;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestOriginalSpaceImageDownload(String str, String str2, ISpaceCoverImageDownloadingResultCallback iSpaceCoverImageDownloadingResultCallback) {
                int iRequestOriginalSpaceImageDownload;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStrongBinder(iSpaceCoverImageDownloadingResultCallback != null ? iSpaceCoverImageDownloadingResultCallback.asBinder() : null);
                    if (this.mRemote.transact(22, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestOriginalSpaceImageDownload = parcelObtain2.readInt();
                    } else {
                        iRequestOriginalSpaceImageDownload = Stub.getDefaultImpl().requestOriginalSpaceImageDownload(str, str2, iSpaceCoverImageDownloadingResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestOriginalSpaceImageDownload;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestOriginalSpaceImageDownloadWithData(String str, String str2, Bundle bundle, ISpaceCoverImageDownloadingResultCallback iSpaceCoverImageDownloadingResultCallback) {
                int iRequestOriginalSpaceImageDownloadWithData;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iSpaceCoverImageDownloadingResultCallback != null ? iSpaceCoverImageDownloadingResultCallback.asBinder() : null);
                    if (this.mRemote.transact(139, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestOriginalSpaceImageDownloadWithData = parcelObtain2.readInt();
                    } else {
                        iRequestOriginalSpaceImageDownloadWithData = Stub.getDefaultImpl().requestOriginalSpaceImageDownloadWithData(str, str2, bundle, iSpaceCoverImageDownloadingResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestOriginalSpaceImageDownloadWithData;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public void requestProfileImageList(Bundle bundle, IBundleProgressResultCallback iBundleProgressResultCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iBundleProgressResultCallback != null ? iBundleProgressResultCallback.asBinder() : null);
                    if (this.mRemote.transact(70, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().requestProfileImageList(bundle, iBundleProgressResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public void requestPublicBuddyInfo(String str, IPublicBuddyInfoResultCallback iPublicBuddyInfoResultCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iPublicBuddyInfoResultCallback != null ? iPublicBuddyInfoResultCallback.asBinder() : null);
                    if (this.mRemote.transact(5, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().requestPublicBuddyInfo(str, iPublicBuddyInfoResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestRestoreItemListFromTrashBinWithData(Bundle bundle, ITrashBinResultCallback iTrashBinResultCallback) {
                int iRequestRestoreItemListFromTrashBinWithData;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iTrashBinResultCallback != null ? iTrashBinResultCallback.asBinder() : null);
                    if (this.mRemote.transact(151, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestRestoreItemListFromTrashBinWithData = parcelObtain2.readInt();
                    } else {
                        iRequestRestoreItemListFromTrashBinWithData = Stub.getDefaultImpl().requestRestoreItemListFromTrashBinWithData(bundle, iTrashBinResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestRestoreItemListFromTrashBinWithData;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public void requestServiceActivation(int i, IServiceActivationResultCallback iServiceActivationResultCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeStrongBinder(iServiceActivationResultCallback != null ? iServiceActivationResultCallback.asBinder() : null);
                    if (this.mRemote.transact(3, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().requestServiceActivation(i, iServiceActivationResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public void requestServiceDeactivation(int i, IServiceDeactivationResultCallback iServiceDeactivationResultCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeStrongBinder(iServiceDeactivationResultCallback != null ? iServiceDeactivationResultCallback.asBinder() : null);
                    if (this.mRemote.transact(4, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().requestServiceDeactivation(i, iServiceDeactivationResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestServiceNumber(IBundleResultCallback iBundleResultCallback) {
                int iRequestServiceNumber;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iBundleResultCallback != null ? iBundleResultCallback.asBinder() : null);
                    if (this.mRemote.transact(112, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestServiceNumber = parcelObtain2.readInt();
                    } else {
                        iRequestServiceNumber = Stub.getDefaultImpl().requestServiceNumber(iBundleResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestServiceNumber;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public String requestShareListUpdateWithItemFileList(String str, String str2, List<Bundle> list, IShareResultCallback iShareResultCallback, PendingIntent pendingIntent, Bundle bundle) {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeTypedList(list);
                    parcelObtain.writeStrongBinder(iShareResultCallback != null ? iShareResultCallback.asBinder() : null);
                    if (pendingIntent != null) {
                        parcelObtain.writeInt(1);
                        pendingIntent.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(79, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = Stub.getDefaultImpl().requestShareListUpdateWithItemFileList(str, str2, list, iShareResultCallback, pendingIntent, bundle);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return string;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public String requestShareListUpdateWithItemFileListWithData(String str, String str2, List<Bundle> list, Bundle bundle, IShareResultCallback iShareResultCallback, PendingIntent pendingIntent, Bundle bundle2) {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeTypedList(list);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iShareResultCallback != null ? iShareResultCallback.asBinder() : null);
                    if (pendingIntent != null) {
                        parcelObtain.writeInt(1);
                        pendingIntent.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (bundle2 != null) {
                        parcelObtain.writeInt(1);
                        bundle2.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(100, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = Stub.getDefaultImpl().requestShareListUpdateWithItemFileListWithData(str, str2, list, bundle, iShareResultCallback, pendingIntent, bundle2);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return string;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestShareSync(String str, IShareSyncResultCallback iShareSyncResultCallback) {
                int iRequestShareSync;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iShareSyncResultCallback != null ? iShareSyncResultCallback.asBinder() : null);
                    if (this.mRemote.transact(11, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestShareSync = parcelObtain2.readInt();
                    } else {
                        iRequestShareSync = Stub.getDefaultImpl().requestShareSync(str, iShareSyncResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestShareSync;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestShareSyncWithData(String str, Bundle bundle, IShareSyncResultCallback iShareSyncResultCallback) {
                int iRequestShareSyncWithData;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iShareSyncResultCallback != null ? iShareSyncResultCallback.asBinder() : null);
                    if (this.mRemote.transact(88, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestShareSyncWithData = parcelObtain2.readInt();
                    } else {
                        iRequestShareSyncWithData = Stub.getDefaultImpl().requestShareSyncWithData(str, bundle, iShareSyncResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestShareSyncWithData;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestShareSyncWithOption(String str, Bundle bundle, IShareSyncResultCallback iShareSyncResultCallback) {
                int iRequestShareSyncWithOption;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iShareSyncResultCallback != null ? iShareSyncResultCallback.asBinder() : null);
                    if (this.mRemote.transact(116, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestShareSyncWithOption = parcelObtain2.readInt();
                    } else {
                        iRequestShareSyncWithOption = Stub.getDefaultImpl().requestShareSyncWithOption(str, bundle, iShareSyncResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestShareSyncWithOption;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public String requestShareUpdateWithUriList(String str, String str2, String str3, Bundle bundle, IShareResultWithFileListCallback iShareResultWithFileListCallback, PendingIntent pendingIntent, Bundle bundle2) {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iShareResultWithFileListCallback != null ? iShareResultWithFileListCallback.asBinder() : null);
                    if (pendingIntent != null) {
                        parcelObtain.writeInt(1);
                        pendingIntent.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (bundle2 != null) {
                        parcelObtain.writeInt(1);
                        bundle2.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(64, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = Stub.getDefaultImpl().requestShareUpdateWithUriList(str, str2, str3, bundle, iShareResultWithFileListCallback, pendingIntent, bundle2);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return string;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public String requestShareWithData(String str, String str2, List<Bundle> list, Bundle bundle, IShareResultCallback iShareResultCallback) {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeTypedList(list);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iShareResultCallback != null ? iShareResultCallback.asBinder() : null);
                    if (this.mRemote.transact(114, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = Stub.getDefaultImpl().requestShareWithData(str, str2, list, bundle, iShareResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return string;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public String requestShareWithFileList(String str, String str2, Bundle bundle, IShareResultWithFileListCallback iShareResultWithFileListCallback, PendingIntent pendingIntent, Bundle bundle2) {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iShareResultWithFileListCallback != null ? iShareResultWithFileListCallback.asBinder() : null);
                    if (pendingIntent != null) {
                        parcelObtain.writeInt(1);
                        pendingIntent.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (bundle2 != null) {
                        parcelObtain.writeInt(1);
                        bundle2.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(62, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = Stub.getDefaultImpl().requestShareWithFileList(str, str2, bundle, iShareResultWithFileListCallback, pendingIntent, bundle2);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return string;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public String requestShareWithFileListWithData(String str, String str2, Bundle bundle, Bundle bundle2, IShareResultWithFileListCallback iShareResultWithFileListCallback, PendingIntent pendingIntent, Bundle bundle3) {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (bundle2 != null) {
                        parcelObtain.writeInt(1);
                        bundle2.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iShareResultWithFileListCallback != null ? iShareResultWithFileListCallback.asBinder() : null);
                    if (pendingIntent != null) {
                        parcelObtain.writeInt(1);
                        pendingIntent.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (bundle3 != null) {
                        parcelObtain.writeInt(1);
                        bundle3.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(137, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = Stub.getDefaultImpl().requestShareWithFileListWithData(str, str2, bundle, bundle2, iShareResultWithFileListCallback, pendingIntent, bundle3);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return string;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public String requestShareWithItemFileList(String str, String str2, List<Bundle> list, IShareResultCallback iShareResultCallback, PendingIntent pendingIntent, Bundle bundle) {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeTypedList(list);
                    parcelObtain.writeStrongBinder(iShareResultCallback != null ? iShareResultCallback.asBinder() : null);
                    if (pendingIntent != null) {
                        parcelObtain.writeInt(1);
                        pendingIntent.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(77, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = Stub.getDefaultImpl().requestShareWithItemFileList(str, str2, list, iShareResultCallback, pendingIntent, bundle);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return string;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public String requestShareWithItemFileListWithData(String str, String str2, List<Bundle> list, Bundle bundle, IShareResultCallback iShareResultCallback, PendingIntent pendingIntent, Bundle bundle2) {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeTypedList(list);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iShareResultCallback != null ? iShareResultCallback.asBinder() : null);
                    if (pendingIntent != null) {
                        parcelObtain.writeInt(1);
                        pendingIntent.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (bundle2 != null) {
                        parcelObtain.writeInt(1);
                        bundle2.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(99, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = Stub.getDefaultImpl().requestShareWithItemFileListWithData(str, str2, list, bundle, iShareResultCallback, pendingIntent, bundle2);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return string;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public String requestShareWithPendingIntent(String str, String str2, List<Bundle> list, IShareResultCallback iShareResultCallback, PendingIntent pendingIntent, Bundle bundle) {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeTypedList(list);
                    parcelObtain.writeStrongBinder(iShareResultCallback != null ? iShareResultCallback.asBinder() : null);
                    if (pendingIntent != null) {
                        parcelObtain.writeInt(1);
                        pendingIntent.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(12, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = Stub.getDefaultImpl().requestShareWithPendingIntent(str, str2, list, iShareResultCallback, pendingIntent, bundle);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return string;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestSharedItem(String str, String str2, String str3, ISharedItemResultCallback iSharedItemResultCallback) {
                int iRequestSharedItem;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeStrongBinder(iSharedItemResultCallback != null ? iSharedItemResultCallback.asBinder() : null);
                    if (this.mRemote.transact(13, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestSharedItem = parcelObtain2.readInt();
                    } else {
                        iRequestSharedItem = Stub.getDefaultImpl().requestSharedItem(str, str2, str3, iSharedItemResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestSharedItem;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestSharedItemDeletion(String str, String str2, String str3, ISharedItemDeletionResultCallback iSharedItemDeletionResultCallback) {
                int iRequestSharedItemDeletion;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeStrongBinder(iSharedItemDeletionResultCallback != null ? iSharedItemDeletionResultCallback.asBinder() : null);
                    if (this.mRemote.transact(14, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestSharedItemDeletion = parcelObtain2.readInt();
                    } else {
                        iRequestSharedItemDeletion = Stub.getDefaultImpl().requestSharedItemDeletion(str, str2, str3, iSharedItemDeletionResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestSharedItemDeletion;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestSharedItemDeletionWithData(String str, String str2, String str3, Bundle bundle, ISharedItemDeletionResultCallback iSharedItemDeletionResultCallback) {
                int iRequestSharedItemDeletionWithData;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iSharedItemDeletionResultCallback != null ? iSharedItemDeletionResultCallback.asBinder() : null);
                    if (this.mRemote.transact(138, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestSharedItemDeletionWithData = parcelObtain2.readInt();
                    } else {
                        iRequestSharedItemDeletionWithData = Stub.getDefaultImpl().requestSharedItemDeletionWithData(str, str2, str3, bundle, iSharedItemDeletionResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestSharedItemDeletionWithData;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestSharedItemList(String str, String str2, String str3, String str4, ISharedItemListResultCallback iSharedItemListResultCallback) {
                int iRequestSharedItemList;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeString(str4);
                    parcelObtain.writeStrongBinder(iSharedItemListResultCallback != null ? iSharedItemListResultCallback.asBinder() : null);
                    if (this.mRemote.transact(65, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestSharedItemList = parcelObtain2.readInt();
                    } else {
                        iRequestSharedItemList = Stub.getDefaultImpl().requestSharedItemList(str, str2, str3, str4, iSharedItemListResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestSharedItemList;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestSharedItemListDeletion(String str, String str2, List<String> list, ISharedItemListDeletionResultCallback iSharedItemListDeletionResultCallback) {
                int iRequestSharedItemListDeletion;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStringList(list);
                    parcelObtain.writeStrongBinder(iSharedItemListDeletionResultCallback != null ? iSharedItemListDeletionResultCallback.asBinder() : null);
                    if (this.mRemote.transact(76, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestSharedItemListDeletion = parcelObtain2.readInt();
                    } else {
                        iRequestSharedItemListDeletion = Stub.getDefaultImpl().requestSharedItemListDeletion(str, str2, list, iSharedItemListDeletionResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestSharedItemListDeletion;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestSharedItemListDeletionWithData(String str, String str2, List<String> list, Bundle bundle, ISharedItemListDeletionResultCallback iSharedItemListDeletionResultCallback) {
                int iRequestSharedItemListDeletionWithData;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStringList(list);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iSharedItemListDeletionResultCallback != null ? iSharedItemListDeletionResultCallback.asBinder() : null);
                    if (this.mRemote.transact(98, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestSharedItemListDeletionWithData = parcelObtain2.readInt();
                    } else {
                        iRequestSharedItemListDeletionWithData = Stub.getDefaultImpl().requestSharedItemListDeletionWithData(str, str2, list, bundle, iSharedItemListDeletionResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestSharedItemListDeletionWithData;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestSharedItemListInTrashBinWithData(Bundle bundle, ISharedItemListResultCallback iSharedItemListResultCallback) {
                int iRequestSharedItemListInTrashBinWithData;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iSharedItemListResultCallback != null ? iSharedItemListResultCallback.asBinder() : null);
                    if (this.mRemote.transact(154, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestSharedItemListInTrashBinWithData = parcelObtain2.readInt();
                    } else {
                        iRequestSharedItemListInTrashBinWithData = Stub.getDefaultImpl().requestSharedItemListInTrashBinWithData(bundle, iSharedItemListResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestSharedItemListInTrashBinWithData;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public String requestSharedItemListUpdate(String str, String str2, List<Bundle> list, IShareResultCallback iShareResultCallback, PendingIntent pendingIntent, Bundle bundle) {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeTypedList(list);
                    parcelObtain.writeStrongBinder(iShareResultCallback != null ? iShareResultCallback.asBinder() : null);
                    if (pendingIntent != null) {
                        parcelObtain.writeInt(1);
                        pendingIntent.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(78, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = Stub.getDefaultImpl().requestSharedItemListUpdate(str, str2, list, iShareResultCallback, pendingIntent, bundle);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return string;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestSharedItemListWithFileList(String str, String str2, String str3, String str4, ISharedItemListResultCallback iSharedItemListResultCallback) {
                int iRequestSharedItemListWithFileList;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeString(str4);
                    parcelObtain.writeStrongBinder(iSharedItemListResultCallback != null ? iSharedItemListResultCallback.asBinder() : null);
                    if (this.mRemote.transact(66, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestSharedItemListWithFileList = parcelObtain2.readInt();
                    } else {
                        iRequestSharedItemListWithFileList = Stub.getDefaultImpl().requestSharedItemListWithFileList(str, str2, str3, str4, iSharedItemListResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestSharedItemListWithFileList;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestSharedItemListWithFileListWithData(String str, String str2, String str3, String str4, Bundle bundle, ISharedItemListResultCallback iSharedItemListResultCallback) {
                int iRequestSharedItemListWithFileListWithData;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeString(str4);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iSharedItemListResultCallback != null ? iSharedItemListResultCallback.asBinder() : null);
                    if (this.mRemote.transact(103, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestSharedItemListWithFileListWithData = parcelObtain2.readInt();
                    } else {
                        iRequestSharedItemListWithFileListWithData = Stub.getDefaultImpl().requestSharedItemListWithFileListWithData(str, str2, str3, str4, bundle, iSharedItemListResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestSharedItemListWithFileListWithData;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestSharedItemSync(String str, String str2, IShareSyncResultCallback iShareSyncResultCallback) {
                int iRequestSharedItemSync;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStrongBinder(iShareSyncResultCallback != null ? iShareSyncResultCallback.asBinder() : null);
                    if (this.mRemote.transact(31, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestSharedItemSync = parcelObtain2.readInt();
                    } else {
                        iRequestSharedItemSync = Stub.getDefaultImpl().requestSharedItemSync(str, str2, iShareSyncResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestSharedItemSync;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestSharedItemSyncWithData(String str, String str2, Bundle bundle, IShareSyncResultCallback iShareSyncResultCallback) {
                int iRequestSharedItemSyncWithData;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iShareSyncResultCallback != null ? iShareSyncResultCallback.asBinder() : null);
                    if (this.mRemote.transact(140, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestSharedItemSyncWithData = parcelObtain2.readInt();
                    } else {
                        iRequestSharedItemSyncWithData = Stub.getDefaultImpl().requestSharedItemSyncWithData(str, str2, bundle, iShareSyncResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestSharedItemSyncWithData;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public void requestSharedItemSyncWithResolution(String str, Bundle bundle, IShareSyncResultCallback iShareSyncResultCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iShareSyncResultCallback != null ? iShareSyncResultCallback.asBinder() : null);
                    if (this.mRemote.transact(82, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().requestSharedItemSyncWithResolution(str, bundle, iShareSyncResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestSharedItemSyncWithResolutionWithData(String str, Bundle bundle, Bundle bundle2, IShareSyncResultCallback iShareSyncResultCallback) {
                int iRequestSharedItemSyncWithResolutionWithData;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (bundle2 != null) {
                        parcelObtain.writeInt(1);
                        bundle2.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iShareSyncResultCallback != null ? iShareSyncResultCallback.asBinder() : null);
                    if (this.mRemote.transact(97, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestSharedItemSyncWithResolutionWithData = parcelObtain2.readInt();
                    } else {
                        iRequestSharedItemSyncWithResolutionWithData = Stub.getDefaultImpl().requestSharedItemSyncWithResolutionWithData(str, bundle, bundle2, iShareSyncResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestSharedItemSyncWithResolutionWithData;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public String requestSharedItemUpdate(String str, String str2, String str3, Bundle bundle, ISharedItemUpdateResultCallback iSharedItemUpdateResultCallback, PendingIntent pendingIntent, Bundle bundle2) {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iSharedItemUpdateResultCallback != null ? iSharedItemUpdateResultCallback.asBinder() : null);
                    if (pendingIntent != null) {
                        parcelObtain.writeInt(1);
                        pendingIntent.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (bundle2 != null) {
                        parcelObtain.writeInt(1);
                        bundle2.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(60, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = Stub.getDefaultImpl().requestSharedItemUpdate(str, str2, str3, bundle, iSharedItemUpdateResultCallback, pendingIntent, bundle2);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return string;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestSharedItemWithData(String str, String str2, String str3, Bundle bundle, ISharedItemResultCallback iSharedItemResultCallback) {
                int iRequestSharedItemWithData;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iSharedItemResultCallback != null ? iSharedItemResultCallback.asBinder() : null);
                    if (this.mRemote.transact(141, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestSharedItemWithData = parcelObtain2.readInt();
                    } else {
                        iRequestSharedItemWithData = Stub.getDefaultImpl().requestSharedItemWithData(str, str2, str3, bundle, iSharedItemResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestSharedItemWithData;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestSharedItemWithGroupId(String str, String str2, String str3, String str4, ISharedItemResultCallback iSharedItemResultCallback) {
                int iRequestSharedItemWithGroupId;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeString(str4);
                    parcelObtain.writeStrongBinder(iSharedItemResultCallback != null ? iSharedItemResultCallback.asBinder() : null);
                    if (this.mRemote.transact(72, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestSharedItemWithGroupId = parcelObtain2.readInt();
                    } else {
                        iRequestSharedItemWithGroupId = Stub.getDefaultImpl().requestSharedItemWithGroupId(str, str2, str3, str4, iSharedItemResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestSharedItemWithGroupId;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestSharedItemWithGroupIdWithData(String str, String str2, String str3, String str4, Bundle bundle, ISharedItemResultCallback iSharedItemResultCallback) {
                int iRequestSharedItemWithGroupIdWithData;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeString(str4);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iSharedItemResultCallback != null ? iSharedItemResultCallback.asBinder() : null);
                    if (this.mRemote.transact(142, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestSharedItemWithGroupIdWithData = parcelObtain2.readInt();
                    } else {
                        iRequestSharedItemWithGroupIdWithData = Stub.getDefaultImpl().requestSharedItemWithGroupIdWithData(str, str2, str3, str4, bundle, iSharedItemResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestSharedItemWithGroupIdWithData;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestSpace(String str, String str2, ISpaceResultCallback iSpaceResultCallback) {
                int iRequestSpace;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStrongBinder(iSpaceResultCallback != null ? iSpaceResultCallback.asBinder() : null);
                    if (this.mRemote.transact(15, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestSpace = parcelObtain2.readInt();
                    } else {
                        iRequestSpace = Stub.getDefaultImpl().requestSpace(str, str2, iSpaceResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestSpace;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestSpaceCreation(String str, String str2, Bundle bundle, ISpaceResultCallback iSpaceResultCallback) {
                int iRequestSpaceCreation;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iSpaceResultCallback != null ? iSpaceResultCallback.asBinder() : null);
                    if (this.mRemote.transact(16, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestSpaceCreation = parcelObtain2.readInt();
                    } else {
                        iRequestSpaceCreation = Stub.getDefaultImpl().requestSpaceCreation(str, str2, bundle, iSpaceResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestSpaceCreation;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestSpaceCreationWithData(String str, String str2, Bundle bundle, Bundle bundle2, ISpaceResultCallback iSpaceResultCallback) {
                int iRequestSpaceCreationWithData;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (bundle2 != null) {
                        parcelObtain.writeInt(1);
                        bundle2.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iSpaceResultCallback != null ? iSpaceResultCallback.asBinder() : null);
                    if (this.mRemote.transact(90, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestSpaceCreationWithData = parcelObtain2.readInt();
                    } else {
                        iRequestSpaceCreationWithData = Stub.getDefaultImpl().requestSpaceCreationWithData(str, str2, bundle, bundle2, iSpaceResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestSpaceCreationWithData;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestSpaceDeletion(String str, String str2, ISpaceDeletionResultCallback iSpaceDeletionResultCallback) {
                int iRequestSpaceDeletion;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStrongBinder(iSpaceDeletionResultCallback != null ? iSpaceDeletionResultCallback.asBinder() : null);
                    if (this.mRemote.transact(17, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestSpaceDeletion = parcelObtain2.readInt();
                    } else {
                        iRequestSpaceDeletion = Stub.getDefaultImpl().requestSpaceDeletion(str, str2, iSpaceDeletionResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestSpaceDeletion;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestSpaceDeletionWithData(String str, String str2, Bundle bundle, ISpaceDeletionResultCallback iSpaceDeletionResultCallback) {
                int iRequestSpaceDeletionWithData;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iSpaceDeletionResultCallback != null ? iSpaceDeletionResultCallback.asBinder() : null);
                    if (this.mRemote.transact(91, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestSpaceDeletionWithData = parcelObtain2.readInt();
                    } else {
                        iRequestSpaceDeletionWithData = Stub.getDefaultImpl().requestSpaceDeletionWithData(str, str2, bundle, iSpaceDeletionResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestSpaceDeletionWithData;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestSpaceList(String str, String str2, ISpaceListResultCallback iSpaceListResultCallback) {
                int iRequestSpaceList;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStrongBinder(iSpaceListResultCallback != null ? iSpaceListResultCallback.asBinder() : null);
                    if (this.mRemote.transact(18, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestSpaceList = parcelObtain2.readInt();
                    } else {
                        iRequestSpaceList = Stub.getDefaultImpl().requestSpaceList(str, str2, iSpaceListResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestSpaceList;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestSpaceListSync(String str, IShareSyncResultCallback iShareSyncResultCallback) {
                int iRequestSpaceListSync;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iShareSyncResultCallback != null ? iShareSyncResultCallback.asBinder() : null);
                    if (this.mRemote.transact(30, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestSpaceListSync = parcelObtain2.readInt();
                    } else {
                        iRequestSpaceListSync = Stub.getDefaultImpl().requestSpaceListSync(str, iShareSyncResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestSpaceListSync;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestSpaceListSyncWithData(String str, Bundle bundle, IShareSyncResultCallback iShareSyncResultCallback) {
                int iRequestSpaceListSyncWithData;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iShareSyncResultCallback != null ? iShareSyncResultCallback.asBinder() : null);
                    if (this.mRemote.transact(96, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestSpaceListSyncWithData = parcelObtain2.readInt();
                    } else {
                        iRequestSpaceListSyncWithData = Stub.getDefaultImpl().requestSpaceListSyncWithData(str, bundle, iShareSyncResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestSpaceListSyncWithData;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestSpaceListWithData(String str, String str2, Bundle bundle, ISpaceListResultCallback iSpaceListResultCallback) {
                int iRequestSpaceListWithData;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iSpaceListResultCallback != null ? iSpaceListResultCallback.asBinder() : null);
                    if (this.mRemote.transact(92, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestSpaceListWithData = parcelObtain2.readInt();
                    } else {
                        iRequestSpaceListWithData = Stub.getDefaultImpl().requestSpaceListWithData(str, str2, bundle, iSpaceListResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestSpaceListWithData;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestSpaceUpdate(String str, String str2, Bundle bundle, ISpaceResultCallback iSpaceResultCallback) {
                int iRequestSpaceUpdate;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iSpaceResultCallback != null ? iSpaceResultCallback.asBinder() : null);
                    if (this.mRemote.transact(19, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestSpaceUpdate = parcelObtain2.readInt();
                    } else {
                        iRequestSpaceUpdate = Stub.getDefaultImpl().requestSpaceUpdate(str, str2, bundle, iSpaceResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestSpaceUpdate;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestSpaceUpdateWithData(String str, String str2, Bundle bundle, Bundle bundle2, ISpaceResultCallback iSpaceResultCallback) {
                int iRequestSpaceUpdateWithData;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (bundle2 != null) {
                        parcelObtain.writeInt(1);
                        bundle2.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iSpaceResultCallback != null ? iSpaceResultCallback.asBinder() : null);
                    if (this.mRemote.transact(93, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestSpaceUpdateWithData = parcelObtain2.readInt();
                    } else {
                        iRequestSpaceUpdateWithData = Stub.getDefaultImpl().requestSpaceUpdateWithData(str, str2, bundle, bundle2, iSpaceResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestSpaceUpdateWithData;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestSpaceWithData(String str, String str2, Bundle bundle, ISpaceResultCallback iSpaceResultCallback) {
                int iRequestSpaceWithData;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iSpaceResultCallback != null ? iSpaceResultCallback.asBinder() : null);
                    if (this.mRemote.transact(89, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestSpaceWithData = parcelObtain2.readInt();
                    } else {
                        iRequestSpaceWithData = Stub.getDefaultImpl().requestSpaceWithData(str, str2, bundle, iSpaceResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestSpaceWithData;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public void requestSync(ISyncResultCallback iSyncResultCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iSyncResultCallback != null ? iSyncResultCallback.asBinder() : null);
                    if (this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().requestSync(iSyncResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestThumbnailDownload(String str, String str2, String str3, String str4, String str5, String str6, IDownloadThumbnailResultCallback iDownloadThumbnailResultCallback) {
                int iRequestThumbnailDownload;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeString(str4);
                    parcelObtain.writeString(str5);
                    parcelObtain.writeString(str6);
                    parcelObtain.writeStrongBinder(iDownloadThumbnailResultCallback != null ? iDownloadThumbnailResultCallback.asBinder() : null);
                    if (this.mRemote.transact(111, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestThumbnailDownload = parcelObtain2.readInt();
                    } else {
                        iRequestThumbnailDownload = Stub.getDefaultImpl().requestThumbnailDownload(str, str2, str3, str4, str5, str6, iDownloadThumbnailResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestThumbnailDownload;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int requestWebLinkEnabled(Bundle bundle, boolean z, IBundleResultCallback iBundleResultCallback) {
                int iRequestWebLinkEnabled;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeInt(z ? 1 : 0);
                    parcelObtain.writeStrongBinder(iBundleResultCallback != null ? iBundleResultCallback.asBinder() : null);
                    if (this.mRemote.transact(117, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iRequestWebLinkEnabled = parcelObtain2.readInt();
                    } else {
                        iRequestWebLinkEnabled = Stub.getDefaultImpl().requestWebLinkEnabled(bundle, z, iBundleResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRequestWebLinkEnabled;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int resumeShare(String str, String str2) {
                int iResumeShare;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (this.mRemote.transact(25, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iResumeShare = parcelObtain2.readInt();
                    } else {
                        iResumeShare = Stub.getDefaultImpl().resumeShare(str, str2);
                    }
                    return iResumeShare;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public Bundle setBuddyActivityListRead(Bundle bundle) {
                Bundle buddyActivityListRead;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(47, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        buddyActivityListRead = parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                    } else {
                        buddyActivityListRead = Stub.getDefaultImpl().setBuddyActivityListRead(bundle);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return buddyActivityListRead;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public boolean setDisclaimerAgreementForSocial(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(104, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        boolean disclaimerAgreementForSocial = Stub.getDefaultImpl().setDisclaimerAgreementForSocial(bundle);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return disclaimerAgreementForSocial;
                    }
                    parcelObtain2.readException();
                    boolean z = parcelObtain2.readInt() != 0;
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return z;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial
            public int setShareStatusListener(String str, String str2, IShareStatusCallback iShareStatusCallback) {
                int shareStatusListener;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStrongBinder(iShareStatusCallback != null ? iShareStatusCallback.asBinder() : null);
                    if (this.mRemote.transact(28, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        shareStatusListener = parcelObtain2.readInt();
                    } else {
                        shareStatusListener = Stub.getDefaultImpl().setShareStatusListener(str, str2, iShareStatusCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return shareStatusListener;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IMobileServiceSocial asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IMobileServiceSocial)) ? new Proxy(iBinder) : (IMobileServiceSocial) iInterfaceQueryLocalInterface;
        }

        public static IMobileServiceSocial getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IMobileServiceSocial iMobileServiceSocial) {
            if (Proxy.sDefaultImpl != null || iMobileServiceSocial == null) {
                return false;
            }
            Proxy.sDefaultImpl = iMobileServiceSocial;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface(DESCRIPTOR);
                    requestSync(ISyncResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    int iIsServiceActivated = isServiceActivated(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(iIsServiceActivated);
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    requestServiceActivation(parcel.readInt(), IServiceActivationResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    requestServiceDeactivation(parcel.readInt(), IServiceDeactivationResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    requestPublicBuddyInfo(parcel.readString(), IPublicBuddyInfoResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    requestDeleteAllActivity(IDeleteAllActivityResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    int iRequestGroupSync = requestGroupSync(parcel.readString(), IGroupSyncResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestGroupSync);
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    int iRequestGroupList = requestGroupList(parcel.readString(), IGroupListResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestGroupList);
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    int iRequestGroup = requestGroup(parcel.readString(), parcel.readString(), IGroupResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestGroup);
                    return true;
                case 10:
                    parcel.enforceInterface(DESCRIPTOR);
                    List<Bundle> groupList = getGroupList(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(groupList);
                    return true;
                case 11:
                    parcel.enforceInterface(DESCRIPTOR);
                    int iRequestShareSync = requestShareSync(parcel.readString(), IShareSyncResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestShareSync);
                    return true;
                case 12:
                    Bundle bundle = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    String string = parcel.readString();
                    String string2 = parcel.readString();
                    Parcelable.Creator creator = Bundle.CREATOR;
                    ArrayList arrayListCreateTypedArrayList = parcel.createTypedArrayList(creator);
                    IShareResultCallback iShareResultCallbackAsInterface = IShareResultCallback.Stub.asInterface(parcel.readStrongBinder());
                    PendingIntent pendingIntent = parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null;
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) creator.createFromParcel(parcel);
                    }
                    String strRequestShareWithPendingIntent = requestShareWithPendingIntent(string, string2, arrayListCreateTypedArrayList, iShareResultCallbackAsInterface, pendingIntent, bundle);
                    parcel2.writeNoException();
                    parcel2.writeString(strRequestShareWithPendingIntent);
                    return true;
                case 13:
                    parcel.enforceInterface(DESCRIPTOR);
                    int iRequestSharedItem = requestSharedItem(parcel.readString(), parcel.readString(), parcel.readString(), ISharedItemResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestSharedItem);
                    return true;
                case 14:
                    parcel.enforceInterface(DESCRIPTOR);
                    int iRequestSharedItemDeletion = requestSharedItemDeletion(parcel.readString(), parcel.readString(), parcel.readString(), ISharedItemDeletionResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestSharedItemDeletion);
                    return true;
                case 15:
                    parcel.enforceInterface(DESCRIPTOR);
                    int iRequestSpace = requestSpace(parcel.readString(), parcel.readString(), ISpaceResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestSpace);
                    return true;
                case 16:
                    Bundle bundle2 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    String string3 = parcel.readString();
                    String string4 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    int iRequestSpaceCreation = requestSpaceCreation(string3, string4, bundle2, ISpaceResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestSpaceCreation);
                    return true;
                case 17:
                    parcel.enforceInterface(DESCRIPTOR);
                    int iRequestSpaceDeletion = requestSpaceDeletion(parcel.readString(), parcel.readString(), ISpaceDeletionResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestSpaceDeletion);
                    return true;
                case 18:
                    parcel.enforceInterface(DESCRIPTOR);
                    int iRequestSpaceList = requestSpaceList(parcel.readString(), parcel.readString(), ISpaceListResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestSpaceList);
                    return true;
                case 19:
                    Bundle bundle3 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    String string5 = parcel.readString();
                    String string6 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        bundle3 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    int iRequestSpaceUpdate = requestSpaceUpdate(string5, string6, bundle3, ISpaceResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestSpaceUpdate);
                    return true;
                case 20:
                    parcel.enforceInterface(DESCRIPTOR);
                    int iRequestAllSpaceList = requestAllSpaceList(parcel.readString(), ISpaceListResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestAllSpaceList);
                    return true;
                case 21:
                    parcel.enforceInterface(DESCRIPTOR);
                    int iRequestOriginalGroupImageDownload = requestOriginalGroupImageDownload(parcel.readString(), parcel.readString(), IGroupCoverImageDownloadingResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestOriginalGroupImageDownload);
                    return true;
                case 22:
                    parcel.enforceInterface(DESCRIPTOR);
                    int iRequestOriginalSpaceImageDownload = requestOriginalSpaceImageDownload(parcel.readString(), parcel.readString(), ISpaceCoverImageDownloadingResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestOriginalSpaceImageDownload);
                    return true;
                case 23:
                    Bundle bundle4 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    String string7 = parcel.readString();
                    String string8 = parcel.readString();
                    String[] strArrCreateStringArray = parcel.createStringArray();
                    IContentDownloadingResultCallback iContentDownloadingResultCallbackAsInterface = IContentDownloadingResultCallback.Stub.asInterface(parcel.readStrongBinder());
                    PendingIntent pendingIntent2 = parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null;
                    if (parcel.readInt() != 0) {
                        bundle4 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    int iRequestOriginalSharedContentsDownload = requestOriginalSharedContentsDownload(string7, string8, strArrCreateStringArray, iContentDownloadingResultCallbackAsInterface, pendingIntent2, bundle4);
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestOriginalSharedContentsDownload);
                    return true;
                case 24:
                    parcel.enforceInterface(DESCRIPTOR);
                    int iPauseShare = pauseShare(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(iPauseShare);
                    return true;
                case 25:
                    parcel.enforceInterface(DESCRIPTOR);
                    int iResumeShare = resumeShare(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(iResumeShare);
                    return true;
                case 26:
                    parcel.enforceInterface(DESCRIPTOR);
                    int iCancelShare = cancelShare(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(iCancelShare);
                    return true;
                case 27:
                    parcel.enforceInterface(DESCRIPTOR);
                    int shareStatus = getShareStatus(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(shareStatus);
                    return true;
                case 28:
                    parcel.enforceInterface(DESCRIPTOR);
                    int shareStatusListener = setShareStatusListener(parcel.readString(), parcel.readString(), IShareStatusCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(shareStatusListener);
                    return true;
                case 29:
                    parcel.enforceInterface(DESCRIPTOR);
                    clearSpaceUnreadCount(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 30:
                    parcel.enforceInterface(DESCRIPTOR);
                    int iRequestSpaceListSync = requestSpaceListSync(parcel.readString(), IShareSyncResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestSpaceListSync);
                    return true;
                case 31:
                    parcel.enforceInterface(DESCRIPTOR);
                    int iRequestSharedItemSync = requestSharedItemSync(parcel.readString(), parcel.readString(), IShareSyncResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestSharedItemSync);
                    return true;
                case 32:
                    Bundle bundle5 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    String string9 = parcel.readString();
                    Bundle bundle6 = parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null;
                    if (parcel.readInt() != 0) {
                        bundle5 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    int iRequestGroupCreation = requestGroupCreation(string9, bundle6, bundle5, IGroupInvitationResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestGroupCreation);
                    return true;
                case 33:
                    parcel.enforceInterface(DESCRIPTOR);
                    int iRequestGroupDeletion = requestGroupDeletion(parcel.readString(), parcel.readString(), IGroupRequestResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestGroupDeletion);
                    return true;
                case 34:
                    Bundle bundle7 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    String string10 = parcel.readString();
                    String string11 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        bundle7 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    int iRequestGroupMemberInvitation = requestGroupMemberInvitation(string10, string11, bundle7, IGroupInvitationResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestGroupMemberInvitation);
                    return true;
                case 35:
                    parcel.enforceInterface(DESCRIPTOR);
                    int iRequestGroupInvitationAcceptance = requestGroupInvitationAcceptance(parcel.readString(), parcel.readString(), IGroupRequestResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestGroupInvitationAcceptance);
                    return true;
                case 36:
                    parcel.enforceInterface(DESCRIPTOR);
                    int iRequestGroupInvitationRejection = requestGroupInvitationRejection(parcel.readString(), parcel.readString(), IGroupRequestResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestGroupInvitationRejection);
                    return true;
                case 37:
                    parcel.enforceInterface(DESCRIPTOR);
                    int iRequestGroupMemberList = requestGroupMemberList(parcel.readString(), parcel.readString(), IMemberListResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestGroupMemberList);
                    return true;
                case 38:
                    parcel.enforceInterface(DESCRIPTOR);
                    int iRequestGroupWithInvitationList = requestGroupWithInvitationList(parcel.readString(), IGroupListWithInvitationResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestGroupWithInvitationList);
                    return true;
                case 39:
                    parcel.enforceInterface(DESCRIPTOR);
                    int iRequestGroupMemberRemoval = requestGroupMemberRemoval(parcel.readString(), parcel.readString(), parcel.readString(), IGroupRequestResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestGroupMemberRemoval);
                    return true;
                case 40:
                    parcel.enforceInterface(DESCRIPTOR);
                    int iRequestLeave = requestLeave(parcel.readString(), parcel.readString(), IGroupRequestResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestLeave);
                    return true;
                case 41:
                    parcel.enforceInterface(DESCRIPTOR);
                    int iRequestGroupPendingInvitationCancellation = requestGroupPendingInvitationCancellation(parcel.readString(), parcel.readString(), parcel.readString(), IGroupRequestResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestGroupPendingInvitationCancellation);
                    return true;
                case 42:
                    Bundle bundle8 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    String string12 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        bundle8 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    int iRequestInstantShare = requestInstantShare(string12, bundle8, parcel.createTypedArrayList(Bundle.CREATOR), IShareResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestInstantShare);
                    return true;
                case 43:
                    Bundle bundle9 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        bundle9 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    Intent intentToDisplay = getIntentToDisplay(bundle9);
                    parcel2.writeNoException();
                    if (intentToDisplay != null) {
                        parcel2.writeInt(1);
                        intentToDisplay.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 44:
                    Bundle bundle10 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        bundle10 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    requestActivityList(bundle10, IActivityBundlePartialResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 45:
                    Bundle bundle11 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        bundle11 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    requestActivityDeletion(bundle11, IActivityResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 46:
                    Bundle bundle12 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        bundle12 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    Bundle buddyActivityList = getBuddyActivityList(bundle12);
                    parcel2.writeNoException();
                    if (buddyActivityList != null) {
                        parcel2.writeInt(1);
                        buddyActivityList.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 47:
                    Bundle bundle13 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        bundle13 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    Bundle buddyActivityListRead = setBuddyActivityListRead(bundle13);
                    parcel2.writeNoException();
                    if (buddyActivityListRead != null) {
                        parcel2.writeInt(1);
                        buddyActivityListRead.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 48:
                    Bundle bundle14 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        bundle14 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    requestMyActivityPrivacyUpdate(bundle14, IActivityResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 49:
                    parcel.enforceInterface(DESCRIPTOR);
                    requestMyActivityPrivacy(IActivityBundleResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 50:
                    parcel.enforceInterface(DESCRIPTOR);
                    requestActivitySync(IActivityBundleResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 51:
                    Bundle bundle15 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        bundle15 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    requestActivity(bundle15, IActivityBundlePartialResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 52:
                    Bundle bundle16 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        bundle16 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    requestFeedback(bundle16, IFeedbackBundlePartialResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 53:
                    Bundle bundle17 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        bundle17 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    requestCommentList(bundle17, IFeedbackBundlePartialResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 54:
                    Bundle bundle18 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        bundle18 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    requestCommentCreation(bundle18, IFeedbackBundleResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 55:
                    Bundle bundle19 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        bundle19 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    requestCommentUpdate(bundle19, IFeedbackBundleResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 56:
                    Bundle bundle20 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        bundle20 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    requestCommentDeletion(bundle20, IFeedbackBundleResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 57:
                    Bundle bundle21 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        bundle21 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    requestEmotionUpdate(bundle21, IFeedbackBundleResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 58:
                    Bundle bundle22 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        bundle22 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    requestEmotionMemberList(bundle22, IFeedbackBundlePartialResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 59:
                    Bundle bundle23 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        bundle23 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    Bundle notification = getNotification(bundle23);
                    parcel2.writeNoException();
                    if (notification != null) {
                        parcel2.writeInt(1);
                        notification.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 60:
                    Bundle bundle24 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    String string13 = parcel.readString();
                    String string14 = parcel.readString();
                    String string15 = parcel.readString();
                    Bundle bundle25 = parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null;
                    ISharedItemUpdateResultCallback iSharedItemUpdateResultCallbackAsInterface = ISharedItemUpdateResultCallback.Stub.asInterface(parcel.readStrongBinder());
                    PendingIntent pendingIntent3 = parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null;
                    if (parcel.readInt() != 0) {
                        bundle24 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    String strRequestSharedItemUpdate = requestSharedItemUpdate(string13, string14, string15, bundle25, iSharedItemUpdateResultCallbackAsInterface, pendingIntent3, bundle24);
                    parcel2.writeNoException();
                    parcel2.writeString(strRequestSharedItemUpdate);
                    return true;
                case 61:
                    parcel.enforceInterface(DESCRIPTOR);
                    int countryTypeForAgreement = getCountryTypeForAgreement();
                    parcel2.writeNoException();
                    parcel2.writeInt(countryTypeForAgreement);
                    return true;
                case 62:
                    Bundle bundle26 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    String string16 = parcel.readString();
                    String string17 = parcel.readString();
                    Bundle bundle27 = parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null;
                    IShareResultWithFileListCallback iShareResultWithFileListCallbackAsInterface = IShareResultWithFileListCallback.Stub.asInterface(parcel.readStrongBinder());
                    PendingIntent pendingIntent4 = parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null;
                    if (parcel.readInt() != 0) {
                        bundle26 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    String strRequestShareWithFileList = requestShareWithFileList(string16, string17, bundle27, iShareResultWithFileListCallbackAsInterface, pendingIntent4, bundle26);
                    parcel2.writeNoException();
                    parcel2.writeString(strRequestShareWithFileList);
                    return true;
                case 63:
                    Bundle bundle28 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    String string18 = parcel.readString();
                    String string19 = parcel.readString();
                    String string20 = parcel.readString();
                    ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
                    IContentDownloadingResultCallback iContentDownloadingResultCallbackAsInterface2 = IContentDownloadingResultCallback.Stub.asInterface(parcel.readStrongBinder());
                    PendingIntent pendingIntent5 = parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null;
                    if (parcel.readInt() != 0) {
                        bundle28 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    int iRequestOriginalSharedContentWithFileListDownload = requestOriginalSharedContentWithFileListDownload(string18, string19, string20, arrayListCreateStringArrayList, iContentDownloadingResultCallbackAsInterface2, pendingIntent5, bundle28);
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestOriginalSharedContentWithFileListDownload);
                    return true;
                case 64:
                    Bundle bundle29 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    String string21 = parcel.readString();
                    String string22 = parcel.readString();
                    String string23 = parcel.readString();
                    Bundle bundle30 = parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null;
                    IShareResultWithFileListCallback iShareResultWithFileListCallbackAsInterface2 = IShareResultWithFileListCallback.Stub.asInterface(parcel.readStrongBinder());
                    PendingIntent pendingIntent6 = parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null;
                    if (parcel.readInt() != 0) {
                        bundle29 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    String strRequestShareUpdateWithUriList = requestShareUpdateWithUriList(string21, string22, string23, bundle30, iShareResultWithFileListCallbackAsInterface2, pendingIntent6, bundle29);
                    parcel2.writeNoException();
                    parcel2.writeString(strRequestShareUpdateWithUriList);
                    return true;
                case 65:
                    parcel.enforceInterface(DESCRIPTOR);
                    int iRequestSharedItemList = requestSharedItemList(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), ISharedItemListResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestSharedItemList);
                    return true;
                case 66:
                    parcel.enforceInterface(DESCRIPTOR);
                    int iRequestSharedItemListWithFileList = requestSharedItemListWithFileList(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), ISharedItemListResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestSharedItemListWithFileList);
                    return true;
                case 67:
                    Bundle bundle31 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        bundle31 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    Bundle bundleIsSomethingNeeded = isSomethingNeeded(bundle31);
                    parcel2.writeNoException();
                    if (bundleIsSomethingNeeded != null) {
                        parcel2.writeInt(1);
                        bundleIsSomethingNeeded.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 68:
                    parcel.enforceInterface(DESCRIPTOR);
                    Bundle serviceState = getServiceState();
                    parcel2.writeNoException();
                    if (serviceState != null) {
                        parcel2.writeInt(1);
                        serviceState.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 69:
                    Bundle bundle32 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        bundle32 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    requestActivityImageList(bundle32, IBundleProgressResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 70:
                    Bundle bundle33 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        bundle33 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    requestProfileImageList(bundle33, IBundleProgressResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 71:
                    parcel.enforceInterface(DESCRIPTOR);
                    int iRequestDelegateAuthorityOfOwner = requestDelegateAuthorityOfOwner(parcel.readString(), parcel.readString(), parcel.readString(), IGroupResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestDelegateAuthorityOfOwner);
                    return true;
                case 72:
                    parcel.enforceInterface(DESCRIPTOR);
                    int iRequestSharedItemWithGroupId = requestSharedItemWithGroupId(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), ISharedItemResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestSharedItemWithGroupId);
                    return true;
                case 73:
                    Bundle bundle34 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    String string24 = parcel.readString();
                    String string25 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        bundle34 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    int iRequestGroupUpdate = requestGroupUpdate(string24, string25, bundle34, IGroupResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestGroupUpdate);
                    return true;
                case 74:
                    parcel.enforceInterface(DESCRIPTOR);
                    requestActivityChanges(IActivityBundlePartialResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 75:
                    Bundle bundle35 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    String string26 = parcel.readString();
                    String string27 = parcel.readString();
                    String[] strArrCreateStringArray2 = parcel.createStringArray();
                    IContentDownloadingResultCallback iContentDownloadingResultCallbackAsInterface3 = IContentDownloadingResultCallback.Stub.asInterface(parcel.readStrongBinder());
                    PendingIntent pendingIntent7 = parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null;
                    if (parcel.readInt() != 0) {
                        bundle35 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    int iRequestOriginalSharedContentsDownloadWithPath = requestOriginalSharedContentsDownloadWithPath(string26, string27, strArrCreateStringArray2, iContentDownloadingResultCallbackAsInterface3, pendingIntent7, bundle35, parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestOriginalSharedContentsDownloadWithPath);
                    return true;
                case 76:
                    parcel.enforceInterface(DESCRIPTOR);
                    int iRequestSharedItemListDeletion = requestSharedItemListDeletion(parcel.readString(), parcel.readString(), parcel.createStringArrayList(), ISharedItemListDeletionResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestSharedItemListDeletion);
                    return true;
                case 77:
                    Bundle bundle36 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    String string28 = parcel.readString();
                    String string29 = parcel.readString();
                    Parcelable.Creator creator2 = Bundle.CREATOR;
                    ArrayList arrayListCreateTypedArrayList2 = parcel.createTypedArrayList(creator2);
                    IShareResultCallback iShareResultCallbackAsInterface2 = IShareResultCallback.Stub.asInterface(parcel.readStrongBinder());
                    PendingIntent pendingIntent8 = parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null;
                    if (parcel.readInt() != 0) {
                        bundle36 = (Bundle) creator2.createFromParcel(parcel);
                    }
                    String strRequestShareWithItemFileList = requestShareWithItemFileList(string28, string29, arrayListCreateTypedArrayList2, iShareResultCallbackAsInterface2, pendingIntent8, bundle36);
                    parcel2.writeNoException();
                    parcel2.writeString(strRequestShareWithItemFileList);
                    return true;
                case 78:
                    Bundle bundle37 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    String string30 = parcel.readString();
                    String string31 = parcel.readString();
                    Parcelable.Creator creator3 = Bundle.CREATOR;
                    ArrayList arrayListCreateTypedArrayList3 = parcel.createTypedArrayList(creator3);
                    IShareResultCallback iShareResultCallbackAsInterface3 = IShareResultCallback.Stub.asInterface(parcel.readStrongBinder());
                    PendingIntent pendingIntent9 = parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null;
                    if (parcel.readInt() != 0) {
                        bundle37 = (Bundle) creator3.createFromParcel(parcel);
                    }
                    String strRequestSharedItemListUpdate = requestSharedItemListUpdate(string30, string31, arrayListCreateTypedArrayList3, iShareResultCallbackAsInterface3, pendingIntent9, bundle37);
                    parcel2.writeNoException();
                    parcel2.writeString(strRequestSharedItemListUpdate);
                    return true;
                case 79:
                    Bundle bundle38 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    String string32 = parcel.readString();
                    String string33 = parcel.readString();
                    Parcelable.Creator creator4 = Bundle.CREATOR;
                    ArrayList arrayListCreateTypedArrayList4 = parcel.createTypedArrayList(creator4);
                    IShareResultCallback iShareResultCallbackAsInterface4 = IShareResultCallback.Stub.asInterface(parcel.readStrongBinder());
                    PendingIntent pendingIntent10 = parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null;
                    if (parcel.readInt() != 0) {
                        bundle38 = (Bundle) creator4.createFromParcel(parcel);
                    }
                    String strRequestShareListUpdateWithItemFileList = requestShareListUpdateWithItemFileList(string32, string33, arrayListCreateTypedArrayList4, iShareResultCallbackAsInterface4, pendingIntent10, bundle38);
                    parcel2.writeNoException();
                    parcel2.writeString(strRequestShareListUpdateWithItemFileList);
                    return true;
                case 80:
                    Bundle bundle39 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    String string34 = parcel.readString();
                    String string35 = parcel.readString();
                    String string36 = parcel.readString();
                    ArrayList<String> arrayListCreateStringArrayList2 = parcel.createStringArrayList();
                    IContentDownloadingResultCallback iContentDownloadingResultCallbackAsInterface4 = IContentDownloadingResultCallback.Stub.asInterface(parcel.readStrongBinder());
                    PendingIntent pendingIntent11 = parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null;
                    if (parcel.readInt() != 0) {
                        bundle39 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    int iRequestOriginalSharedContentWithItemFileListDownloadWithPath = requestOriginalSharedContentWithItemFileListDownloadWithPath(string34, string35, string36, arrayListCreateStringArrayList2, iContentDownloadingResultCallbackAsInterface4, pendingIntent11, bundle39, parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestOriginalSharedContentWithItemFileListDownloadWithPath);
                    return true;
                case 81:
                    Bundle bundle40 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        bundle40 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    Bundle buddyActivityCount = getBuddyActivityCount(bundle40);
                    parcel2.writeNoException();
                    if (buddyActivityCount != null) {
                        parcel2.writeInt(1);
                        buddyActivityCount.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 82:
                    Bundle bundle41 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    String string37 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        bundle41 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    requestSharedItemSyncWithResolution(string37, bundle41, IShareSyncResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 83:
                    PendingIntent pendingIntent12 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    Bundle bundle42 = parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null;
                    if (parcel.readInt() != 0) {
                        pendingIntent12 = (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel);
                    }
                    Bundle bundleRequestActivityPosting = requestActivityPosting(bundle42, pendingIntent12, IBundleProgressResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (bundleRequestActivityPosting != null) {
                        parcel2.writeInt(1);
                        bundleRequestActivityPosting.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 84:
                    Bundle bundle43 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        bundle43 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    requestActivityContentStreamingUrl(bundle43, IActivityBundleResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 85:
                    Bundle bundle44 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        bundle44 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    Bundle bundleRequestContentsController = requestContentsController(bundle44);
                    parcel2.writeNoException();
                    if (bundleRequestContentsController != null) {
                        parcel2.writeInt(1);
                        bundleRequestContentsController.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 86:
                    Bundle bundle45 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        bundle45 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    requestActivityContent(bundle45, IActivityBundleResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 87:
                    parcel.enforceInterface(DESCRIPTOR);
                    int iRequestGroupSyncWithoutImage = requestGroupSyncWithoutImage(parcel.readString(), IGroupSyncResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestGroupSyncWithoutImage);
                    return true;
                case 88:
                    Bundle bundle46 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    String string38 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        bundle46 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    int iRequestShareSyncWithData = requestShareSyncWithData(string38, bundle46, IShareSyncResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestShareSyncWithData);
                    return true;
                case 89:
                    Bundle bundle47 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    String string39 = parcel.readString();
                    String string40 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        bundle47 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    int iRequestSpaceWithData = requestSpaceWithData(string39, string40, bundle47, ISpaceResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestSpaceWithData);
                    return true;
                case 90:
                    Bundle bundle48 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    String string41 = parcel.readString();
                    String string42 = parcel.readString();
                    Bundle bundle49 = parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null;
                    if (parcel.readInt() != 0) {
                        bundle48 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    int iRequestSpaceCreationWithData = requestSpaceCreationWithData(string41, string42, bundle49, bundle48, ISpaceResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestSpaceCreationWithData);
                    return true;
                case 91:
                    Bundle bundle50 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    String string43 = parcel.readString();
                    String string44 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        bundle50 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    int iRequestSpaceDeletionWithData = requestSpaceDeletionWithData(string43, string44, bundle50, ISpaceDeletionResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestSpaceDeletionWithData);
                    return true;
                case 92:
                    Bundle bundle51 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    String string45 = parcel.readString();
                    String string46 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        bundle51 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    int iRequestSpaceListWithData = requestSpaceListWithData(string45, string46, bundle51, ISpaceListResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestSpaceListWithData);
                    return true;
                case 93:
                    Bundle bundle52 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    String string47 = parcel.readString();
                    String string48 = parcel.readString();
                    Bundle bundle53 = parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null;
                    if (parcel.readInt() != 0) {
                        bundle52 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    int iRequestSpaceUpdateWithData = requestSpaceUpdateWithData(string47, string48, bundle53, bundle52, ISpaceResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestSpaceUpdateWithData);
                    return true;
                case 94:
                    parcel.enforceInterface(DESCRIPTOR);
                    int iRequestAllSpaceListWithData = requestAllSpaceListWithData(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, ISpaceListResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestAllSpaceListWithData);
                    return true;
                case 95:
                    parcel.enforceInterface(DESCRIPTOR);
                    clearSpaceUnreadCountWithData(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 96:
                    parcel.enforceInterface(DESCRIPTOR);
                    int iRequestSpaceListSyncWithData = requestSpaceListSyncWithData(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, IShareSyncResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestSpaceListSyncWithData);
                    return true;
                case 97:
                    Bundle bundle54 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    String string49 = parcel.readString();
                    Bundle bundle55 = parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null;
                    if (parcel.readInt() != 0) {
                        bundle54 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    int iRequestSharedItemSyncWithResolutionWithData = requestSharedItemSyncWithResolutionWithData(string49, bundle55, bundle54, IShareSyncResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestSharedItemSyncWithResolutionWithData);
                    return true;
                case 98:
                    Bundle bundle56 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    String string50 = parcel.readString();
                    String string51 = parcel.readString();
                    ArrayList<String> arrayListCreateStringArrayList3 = parcel.createStringArrayList();
                    if (parcel.readInt() != 0) {
                        bundle56 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    int iRequestSharedItemListDeletionWithData = requestSharedItemListDeletionWithData(string50, string51, arrayListCreateStringArrayList3, bundle56, ISharedItemListDeletionResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestSharedItemListDeletionWithData);
                    return true;
                case 99:
                    Bundle bundle57 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    String string52 = parcel.readString();
                    String string53 = parcel.readString();
                    Parcelable.Creator creator5 = Bundle.CREATOR;
                    ArrayList arrayListCreateTypedArrayList5 = parcel.createTypedArrayList(creator5);
                    Bundle bundle58 = parcel.readInt() != 0 ? (Bundle) creator5.createFromParcel(parcel) : null;
                    IShareResultCallback iShareResultCallbackAsInterface5 = IShareResultCallback.Stub.asInterface(parcel.readStrongBinder());
                    PendingIntent pendingIntent13 = parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null;
                    if (parcel.readInt() != 0) {
                        bundle57 = (Bundle) creator5.createFromParcel(parcel);
                    }
                    String strRequestShareWithItemFileListWithData = requestShareWithItemFileListWithData(string52, string53, arrayListCreateTypedArrayList5, bundle58, iShareResultCallbackAsInterface5, pendingIntent13, bundle57);
                    parcel2.writeNoException();
                    parcel2.writeString(strRequestShareWithItemFileListWithData);
                    return true;
                case 100:
                    Bundle bundle59 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    String string54 = parcel.readString();
                    String string55 = parcel.readString();
                    Parcelable.Creator creator6 = Bundle.CREATOR;
                    ArrayList arrayListCreateTypedArrayList6 = parcel.createTypedArrayList(creator6);
                    Bundle bundle60 = parcel.readInt() != 0 ? (Bundle) creator6.createFromParcel(parcel) : null;
                    IShareResultCallback iShareResultCallbackAsInterface6 = IShareResultCallback.Stub.asInterface(parcel.readStrongBinder());
                    PendingIntent pendingIntent14 = parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null;
                    if (parcel.readInt() != 0) {
                        bundle59 = (Bundle) creator6.createFromParcel(parcel);
                    }
                    String strRequestShareListUpdateWithItemFileListWithData = requestShareListUpdateWithItemFileListWithData(string54, string55, arrayListCreateTypedArrayList6, bundle60, iShareResultCallbackAsInterface6, pendingIntent14, bundle59);
                    parcel2.writeNoException();
                    parcel2.writeString(strRequestShareListUpdateWithItemFileListWithData);
                    return true;
                case 101:
                    Bundle bundle61 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    String string56 = parcel.readString();
                    String string57 = parcel.readString();
                    String string58 = parcel.readString();
                    ArrayList<String> arrayListCreateStringArrayList4 = parcel.createStringArrayList();
                    Bundle bundle62 = parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null;
                    IContentDownloadingResultCallback iContentDownloadingResultCallbackAsInterface5 = IContentDownloadingResultCallback.Stub.asInterface(parcel.readStrongBinder());
                    PendingIntent pendingIntent15 = parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null;
                    if (parcel.readInt() != 0) {
                        bundle61 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    int iMo5781xd48f8faa = mo5781xd48f8faa(string56, string57, string58, arrayListCreateStringArrayList4, bundle62, iContentDownloadingResultCallbackAsInterface5, pendingIntent15, bundle61, parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(iMo5781xd48f8faa);
                    return true;
                case 102:
                    Bundle bundle63 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    String string59 = parcel.readString();
                    String string60 = parcel.readString();
                    String string61 = parcel.readString();
                    ArrayList<String> arrayListCreateStringArrayList5 = parcel.createStringArrayList();
                    Bundle bundle64 = parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null;
                    IContentDownloadingResultCallback iContentDownloadingResultCallbackAsInterface6 = IContentDownloadingResultCallback.Stub.asInterface(parcel.readStrongBinder());
                    PendingIntent pendingIntent16 = parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null;
                    if (parcel.readInt() != 0) {
                        bundle63 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    int iRequestOriginalSharedContentWithFileListDownloadWithData = requestOriginalSharedContentWithFileListDownloadWithData(string59, string60, string61, arrayListCreateStringArrayList5, bundle64, iContentDownloadingResultCallbackAsInterface6, pendingIntent16, bundle63);
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestOriginalSharedContentWithFileListDownloadWithData);
                    return true;
                case 103:
                    Bundle bundle65 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    String string62 = parcel.readString();
                    String string63 = parcel.readString();
                    String string64 = parcel.readString();
                    String string65 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        bundle65 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    int iRequestSharedItemListWithFileListWithData = requestSharedItemListWithFileListWithData(string62, string63, string64, string65, bundle65, ISharedItemListResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestSharedItemListWithFileListWithData);
                    return true;
                case 104:
                    Bundle bundle66 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        bundle66 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    boolean disclaimerAgreementForSocial = setDisclaimerAgreementForSocial(bundle66);
                    parcel2.writeNoException();
                    parcel2.writeInt(disclaimerAgreementForSocial ? 1 : 0);
                    return true;
                case 105:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean disclaimerAgreementForSocial2 = getDisclaimerAgreementForSocial();
                    parcel2.writeNoException();
                    parcel2.writeInt(disclaimerAgreementForSocial2 ? 1 : 0);
                    return true;
                case 106:
                    Bundle bundle67 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        bundle67 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    boolean disclaimerAgreementForService = getDisclaimerAgreementForService(bundle67);
                    parcel2.writeNoException();
                    parcel2.writeInt(disclaimerAgreementForService ? 1 : 0);
                    return true;
                case 107:
                    parcel.enforceInterface(DESCRIPTOR);
                    Bundle deviceAuthInfoCached = getDeviceAuthInfoCached();
                    parcel2.writeNoException();
                    if (deviceAuthInfoCached != null) {
                        parcel2.writeInt(1);
                        deviceAuthInfoCached.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 108:
                    Bundle bundle68 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        bundle68 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    boolean zIsServiceRegistered = isServiceRegistered(bundle68);
                    parcel2.writeNoException();
                    parcel2.writeInt(zIsServiceRegistered ? 1 : 0);
                    return true;
                case 109:
                    parcel.enforceInterface(DESCRIPTOR);
                    requestBuddySync(parcel.readInt(), ISyncResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 110:
                    Bundle bundle69 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        bundle69 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    getBuddyInfo(bundle69, IBuddyInfoResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 111:
                    parcel.enforceInterface(DESCRIPTOR);
                    int iRequestThumbnailDownload = requestThumbnailDownload(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), IDownloadThumbnailResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestThumbnailDownload);
                    return true;
                case 112:
                    parcel.enforceInterface(DESCRIPTOR);
                    int iRequestServiceNumber = requestServiceNumber(IBundleResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestServiceNumber);
                    return true;
                case 113:
                    parcel.enforceInterface(DESCRIPTOR);
                    int iRequestOriginalSharedContentsDownloadToHiddenFolder = requestOriginalSharedContentsDownloadToHiddenFolder(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, IContentDownloadingResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestOriginalSharedContentsDownloadToHiddenFolder);
                    return true;
                case 114:
                    Bundle bundle70 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    String string66 = parcel.readString();
                    String string67 = parcel.readString();
                    Parcelable.Creator creator7 = Bundle.CREATOR;
                    ArrayList arrayListCreateTypedArrayList7 = parcel.createTypedArrayList(creator7);
                    if (parcel.readInt() != 0) {
                        bundle70 = (Bundle) creator7.createFromParcel(parcel);
                    }
                    String strRequestShareWithData = requestShareWithData(string66, string67, arrayListCreateTypedArrayList7, bundle70, IShareResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeString(strRequestShareWithData);
                    return true;
                case 115:
                    parcel.enforceInterface(DESCRIPTOR);
                    Bundle quota = getQuota();
                    parcel2.writeNoException();
                    if (quota != null) {
                        parcel2.writeInt(1);
                        quota.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 116:
                    Bundle bundle71 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    String string68 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        bundle71 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    int iRequestShareSyncWithOption = requestShareSyncWithOption(string68, bundle71, IShareSyncResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestShareSyncWithOption);
                    return true;
                case 117:
                    Bundle bundle72 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        bundle72 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    int iRequestWebLinkEnabled = requestWebLinkEnabled(bundle72, parcel.readInt() != 0, IBundleResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestWebLinkEnabled);
                    return true;
                case 118:
                    Bundle bundle73 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        bundle73 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    Bundle quotaWithData = getQuotaWithData(bundle73);
                    parcel2.writeNoException();
                    if (quotaWithData != null) {
                        parcel2.writeInt(1);
                        quotaWithData.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 119:
                    Bundle bundle74 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        bundle74 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    Bundle bundleIsPermissionGranted = isPermissionGranted(bundle74);
                    parcel2.writeNoException();
                    if (bundleIsPermissionGranted != null) {
                        parcel2.writeInt(1);
                        bundleIsPermissionGranted.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 120:
                    Bundle bundle75 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        bundle75 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    int iRequestGroupWithData = requestGroupWithData(bundle75, IGroupResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestGroupWithData);
                    return true;
                case 121:
                    Bundle bundle76 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        bundle76 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    int iRequestGroupListWithData = requestGroupListWithData(bundle76, IGroupListResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestGroupListWithData);
                    return true;
                case 122:
                    Bundle bundle77 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        bundle77 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    int iRequestGroupSyncWithData = requestGroupSyncWithData(bundle77, IGroupSyncResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestGroupSyncWithData);
                    return true;
                case 123:
                    Bundle bundle78 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        bundle78 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    int iRequestGroupSyncWithoutImageWithData = requestGroupSyncWithoutImageWithData(bundle78, IGroupSyncResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestGroupSyncWithoutImageWithData);
                    return true;
                case 124:
                    Bundle bundle79 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        bundle79 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    List<Bundle> groupListWithData = getGroupListWithData(bundle79);
                    parcel2.writeNoException();
                    parcel2.writeTypedList(groupListWithData);
                    return true;
                case 125:
                    Bundle bundle80 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    Bundle bundle81 = parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null;
                    Bundle bundle82 = parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null;
                    if (parcel.readInt() != 0) {
                        bundle80 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    int iRequestGroupCreationWithData = requestGroupCreationWithData(bundle81, bundle82, bundle80, IGroupInvitationResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestGroupCreationWithData);
                    return true;
                case 126:
                    Bundle bundle83 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        bundle83 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    int iRequestGroupDeletionWithData = requestGroupDeletionWithData(bundle83, IGroupRequestResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestGroupDeletionWithData);
                    return true;
                case 127:
                    Bundle bundle84 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    Bundle bundle85 = parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null;
                    if (parcel.readInt() != 0) {
                        bundle84 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    int iRequestGroupMemberInvitationWithData = requestGroupMemberInvitationWithData(bundle85, bundle84, IGroupInvitationResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestGroupMemberInvitationWithData);
                    return true;
                case 128:
                    Bundle bundle86 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        bundle86 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    int iRequestGroupInvitationAcceptanceWithData = requestGroupInvitationAcceptanceWithData(bundle86, IGroupRequestResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestGroupInvitationAcceptanceWithData);
                    return true;
                case 129:
                    Bundle bundle87 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        bundle87 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    int iRequestGroupInvitationRejectionWithData = requestGroupInvitationRejectionWithData(bundle87, IGroupRequestResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestGroupInvitationRejectionWithData);
                    return true;
                case 130:
                    Bundle bundle88 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        bundle88 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    int iRequestGroupMemberListWithData = requestGroupMemberListWithData(bundle88, IMemberListResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestGroupMemberListWithData);
                    return true;
                case 131:
                    Bundle bundle89 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        bundle89 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    int iRequestGroupWithInvitationListWithData = requestGroupWithInvitationListWithData(bundle89, IGroupListWithInvitationResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestGroupWithInvitationListWithData);
                    return true;
                case 132:
                    Bundle bundle90 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        bundle90 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    int iRequestGroupMemberRemovalWithData = requestGroupMemberRemovalWithData(bundle90, IGroupRequestResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestGroupMemberRemovalWithData);
                    return true;
                case 133:
                    Bundle bundle91 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        bundle91 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    int iRequestLeaveWithData = requestLeaveWithData(bundle91, IGroupRequestResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestLeaveWithData);
                    return true;
                case 134:
                    Bundle bundle92 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        bundle92 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    int iRequestGroupPendingInvitationCancellationWithData = requestGroupPendingInvitationCancellationWithData(bundle92, IGroupRequestResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestGroupPendingInvitationCancellationWithData);
                    return true;
                case 135:
                    Bundle bundle93 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        bundle93 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    int iRequestDelegateAuthorityOfOwnerWithData = requestDelegateAuthorityOfOwnerWithData(bundle93, IGroupResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestDelegateAuthorityOfOwnerWithData);
                    return true;
                case 136:
                    Bundle bundle94 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        bundle94 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    int iRequestGroupAuthorityChange = requestGroupAuthorityChange(bundle94, IGroupResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestGroupAuthorityChange);
                    return true;
                case 137:
                    Bundle bundle95 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    String string69 = parcel.readString();
                    String string70 = parcel.readString();
                    Bundle bundle96 = parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null;
                    Bundle bundle97 = parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null;
                    IShareResultWithFileListCallback iShareResultWithFileListCallbackAsInterface3 = IShareResultWithFileListCallback.Stub.asInterface(parcel.readStrongBinder());
                    PendingIntent pendingIntent17 = parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null;
                    if (parcel.readInt() != 0) {
                        bundle95 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    String strRequestShareWithFileListWithData = requestShareWithFileListWithData(string69, string70, bundle96, bundle97, iShareResultWithFileListCallbackAsInterface3, pendingIntent17, bundle95);
                    parcel2.writeNoException();
                    parcel2.writeString(strRequestShareWithFileListWithData);
                    return true;
                case 138:
                    Bundle bundle98 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    String string71 = parcel.readString();
                    String string72 = parcel.readString();
                    String string73 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        bundle98 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    int iRequestSharedItemDeletionWithData = requestSharedItemDeletionWithData(string71, string72, string73, bundle98, ISharedItemDeletionResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestSharedItemDeletionWithData);
                    return true;
                case 139:
                    Bundle bundle99 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    String string74 = parcel.readString();
                    String string75 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        bundle99 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    int iRequestOriginalSpaceImageDownloadWithData = requestOriginalSpaceImageDownloadWithData(string74, string75, bundle99, ISpaceCoverImageDownloadingResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestOriginalSpaceImageDownloadWithData);
                    return true;
                case 140:
                    Bundle bundle100 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    String string76 = parcel.readString();
                    String string77 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        bundle100 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    int iRequestSharedItemSyncWithData = requestSharedItemSyncWithData(string76, string77, bundle100, IShareSyncResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestSharedItemSyncWithData);
                    return true;
                case 141:
                    Bundle bundle101 = null;
                    parcel.enforceInterface(DESCRIPTOR);
                    String string78 = parcel.readString();
                    String string79 = parcel.readString();
                    String string80 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        bundle101 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    int iRequestSharedItemWithData = requestSharedItemWithData(string78, string79, string80, bundle101, ISharedItemResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestSharedItemWithData);
                    return true;
                case 142:
                    parcel.enforceInterface(DESCRIPTOR);
                    Bundle bundle102 = null;
                    String string81 = parcel.readString();
                    String string82 = parcel.readString();
                    String string83 = parcel.readString();
                    String string84 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        bundle102 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    int iRequestSharedItemWithGroupIdWithData = requestSharedItemWithGroupIdWithData(string81, string82, string83, string84, bundle102, ISharedItemResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestSharedItemWithGroupIdWithData);
                    return true;
                case 143:
                    parcel.enforceInterface(DESCRIPTOR);
                    Bundle verifiedOriginalFileListWithData = getVerifiedOriginalFileListWithData(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (verifiedOriginalFileListWithData != null) {
                        parcel2.writeInt(1);
                        verifiedOriginalFileListWithData.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 144:
                    parcel.enforceInterface(DESCRIPTOR);
                    int iRequestInvitationLinkCreation = requestInvitationLinkCreation(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, IGroupResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestInvitationLinkCreation);
                    return true;
                case 145:
                    parcel.enforceInterface(DESCRIPTOR);
                    int iRequestInvitationLinkDeletion = requestInvitationLinkDeletion(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, IGroupResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestInvitationLinkDeletion);
                    return true;
                case 146:
                    parcel.enforceInterface(DESCRIPTOR);
                    int iRequestFamilyGroupCreationWithData = requestFamilyGroupCreationWithData(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, IGroupResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestFamilyGroupCreationWithData);
                    return true;
                case 147:
                    parcel.enforceInterface(DESCRIPTOR);
                    int iRequestFamilyGroupDeletionWithData = requestFamilyGroupDeletionWithData(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, IGroupRequestResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestFamilyGroupDeletionWithData);
                    return true;
                case 148:
                    parcel.enforceInterface(DESCRIPTOR);
                    Bundle familyQuotaWithData = getFamilyQuotaWithData(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (familyQuotaWithData != null) {
                        parcel2.writeInt(1);
                        familyQuotaWithData.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 149:
                    parcel.enforceInterface(DESCRIPTOR);
                    int iRequestFamilyGroupMemberListWithData = requestFamilyGroupMemberListWithData(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, IMemberListResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestFamilyGroupMemberListWithData);
                    return true;
                case 150:
                    parcel.enforceInterface(DESCRIPTOR);
                    int iRequestMoveItemListToTrashBinWithData = requestMoveItemListToTrashBinWithData(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, ITrashBinResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestMoveItemListToTrashBinWithData);
                    return true;
                case 151:
                    parcel.enforceInterface(DESCRIPTOR);
                    int iRequestRestoreItemListFromTrashBinWithData = requestRestoreItemListFromTrashBinWithData(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, ITrashBinResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestRestoreItemListFromTrashBinWithData);
                    return true;
                case 152:
                    parcel.enforceInterface(DESCRIPTOR);
                    int iRequestDeleteItemListFromTrashBinWithData = requestDeleteItemListFromTrashBinWithData(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, ITrashBinResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestDeleteItemListFromTrashBinWithData);
                    return true;
                case 153:
                    parcel.enforceInterface(DESCRIPTOR);
                    int iRequestDeleteAllItemsFromTrashBinWithData = requestDeleteAllItemsFromTrashBinWithData(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, ITrashBinResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestDeleteAllItemsFromTrashBinWithData);
                    return true;
                case 154:
                    parcel.enforceInterface(DESCRIPTOR);
                    int iRequestSharedItemListInTrashBinWithData = requestSharedItemListInTrashBinWithData(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, ISharedItemListResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestSharedItemListInTrashBinWithData);
                    return true;
                case 155:
                    parcel.enforceInterface(DESCRIPTOR);
                    requestAppUpdateAndLaunchForBuddy(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, IBuddyInfoResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 156:
                    parcel.enforceInterface(DESCRIPTOR);
                    String strRequestBulkItemShare = requestBulkItemShare(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, IShareBulkItemResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeString(strRequestBulkItemShare);
                    return true;
                case 157:
                    parcel.enforceInterface(DESCRIPTOR);
                    int iDataSyncUpsert = dataSyncUpsert(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, IBundleResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iDataSyncUpsert);
                    return true;
                case 158:
                    parcel.enforceInterface(DESCRIPTOR);
                    int iDataSyncDelete = dataSyncDelete(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, IBundleResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iDataSyncDelete);
                    return true;
                case 159:
                    parcel.enforceInterface(DESCRIPTOR);
                    int iDataSyncGetSyncedData = dataSyncGetSyncedData(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, IBundleResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iDataSyncGetSyncedData);
                    return true;
                case 160:
                    parcel.enforceInterface(DESCRIPTOR);
                    int iRequestDisclosureScope = requestDisclosureScope(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, IBundleResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestDisclosureScope);
                    return true;
                case 161:
                    parcel.enforceInterface(DESCRIPTOR);
                    int iRequestDisclosureScopeUpdate = requestDisclosureScopeUpdate(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, IBundleResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequestDisclosureScopeUpdate);
                    return true;
                case 162:
                    parcel.enforceInterface(DESCRIPTOR);
                    int disclosureScope = getDisclosureScope(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(disclosureScope);
                    return true;
                case 163:
                    parcel.enforceInterface(DESCRIPTOR);
                    Bundle buddySyncTime = getBuddySyncTime();
                    parcel2.writeNoException();
                    if (buddySyncTime != null) {
                        parcel2.writeInt(1);
                        buddySyncTime.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    int cancelShare(String str, String str2);

    void clearSpaceUnreadCount(String str, String str2);

    void clearSpaceUnreadCountWithData(String str, Bundle bundle, String str2);

    int dataSyncDelete(String str, Bundle bundle, IBundleResultCallback iBundleResultCallback);

    int dataSyncGetSyncedData(String str, Bundle bundle, IBundleResultCallback iBundleResultCallback);

    int dataSyncUpsert(String str, Bundle bundle, IBundleResultCallback iBundleResultCallback);

    Bundle getBuddyActivityCount(Bundle bundle);

    Bundle getBuddyActivityList(Bundle bundle);

    void getBuddyInfo(Bundle bundle, IBuddyInfoResultCallback iBuddyInfoResultCallback);

    Bundle getBuddySyncTime();

    int getCountryTypeForAgreement();

    Bundle getDeviceAuthInfoCached();

    boolean getDisclaimerAgreementForService(Bundle bundle);

    boolean getDisclaimerAgreementForSocial();

    int getDisclosureScope(Bundle bundle);

    Bundle getFamilyQuotaWithData(Bundle bundle);

    List<Bundle> getGroupList(String str);

    List<Bundle> getGroupListWithData(Bundle bundle);

    Intent getIntentToDisplay(Bundle bundle);

    Bundle getNotification(Bundle bundle);

    Bundle getQuota();

    Bundle getQuotaWithData(Bundle bundle);

    Bundle getServiceState();

    int getShareStatus(String str, String str2);

    Bundle getVerifiedOriginalFileListWithData(Bundle bundle);

    Bundle isPermissionGranted(Bundle bundle);

    int isServiceActivated(int i);

    boolean isServiceRegistered(Bundle bundle);

    Bundle isSomethingNeeded(Bundle bundle);

    int pauseShare(String str, String str2);

    void requestActivity(Bundle bundle, IActivityBundlePartialResultCallback iActivityBundlePartialResultCallback);

    void requestActivityChanges(IActivityBundlePartialResultCallback iActivityBundlePartialResultCallback);

    void requestActivityContent(Bundle bundle, IActivityBundleResultCallback iActivityBundleResultCallback);

    void requestActivityContentStreamingUrl(Bundle bundle, IActivityBundleResultCallback iActivityBundleResultCallback);

    void requestActivityDeletion(Bundle bundle, IActivityResultCallback iActivityResultCallback);

    void requestActivityImageList(Bundle bundle, IBundleProgressResultCallback iBundleProgressResultCallback);

    void requestActivityList(Bundle bundle, IActivityBundlePartialResultCallback iActivityBundlePartialResultCallback);

    Bundle requestActivityPosting(Bundle bundle, PendingIntent pendingIntent, IBundleProgressResultCallback iBundleProgressResultCallback);

    void requestActivitySync(IActivityBundleResultCallback iActivityBundleResultCallback);

    int requestAllSpaceList(String str, ISpaceListResultCallback iSpaceListResultCallback);

    int requestAllSpaceListWithData(String str, Bundle bundle, ISpaceListResultCallback iSpaceListResultCallback);

    void requestAppUpdateAndLaunchForBuddy(Bundle bundle, IBuddyInfoResultCallback iBuddyInfoResultCallback);

    void requestBuddySync(int i, ISyncResultCallback iSyncResultCallback);

    String requestBulkItemShare(Bundle bundle, IShareBulkItemResultCallback iShareBulkItemResultCallback);

    void requestCommentCreation(Bundle bundle, IFeedbackBundleResultCallback iFeedbackBundleResultCallback);

    void requestCommentDeletion(Bundle bundle, IFeedbackBundleResultCallback iFeedbackBundleResultCallback);

    void requestCommentList(Bundle bundle, IFeedbackBundlePartialResultCallback iFeedbackBundlePartialResultCallback);

    void requestCommentUpdate(Bundle bundle, IFeedbackBundleResultCallback iFeedbackBundleResultCallback);

    Bundle requestContentsController(Bundle bundle);

    int requestDelegateAuthorityOfOwner(String str, String str2, String str3, IGroupResultCallback iGroupResultCallback);

    int requestDelegateAuthorityOfOwnerWithData(Bundle bundle, IGroupResultCallback iGroupResultCallback);

    void requestDeleteAllActivity(IDeleteAllActivityResultCallback iDeleteAllActivityResultCallback);

    int requestDeleteAllItemsFromTrashBinWithData(Bundle bundle, ITrashBinResultCallback iTrashBinResultCallback);

    int requestDeleteItemListFromTrashBinWithData(Bundle bundle, ITrashBinResultCallback iTrashBinResultCallback);

    int requestDisclosureScope(Bundle bundle, IBundleResultCallback iBundleResultCallback);

    int requestDisclosureScopeUpdate(Bundle bundle, IBundleResultCallback iBundleResultCallback);

    void requestEmotionMemberList(Bundle bundle, IFeedbackBundlePartialResultCallback iFeedbackBundlePartialResultCallback);

    void requestEmotionUpdate(Bundle bundle, IFeedbackBundleResultCallback iFeedbackBundleResultCallback);

    int requestFamilyGroupCreationWithData(Bundle bundle, Bundle bundle2, IGroupResultCallback iGroupResultCallback);

    int requestFamilyGroupDeletionWithData(Bundle bundle, IGroupRequestResultCallback iGroupRequestResultCallback);

    int requestFamilyGroupMemberListWithData(Bundle bundle, IMemberListResultCallback iMemberListResultCallback);

    void requestFeedback(Bundle bundle, IFeedbackBundlePartialResultCallback iFeedbackBundlePartialResultCallback);

    int requestGroup(String str, String str2, IGroupResultCallback iGroupResultCallback);

    int requestGroupAuthorityChange(Bundle bundle, IGroupResultCallback iGroupResultCallback);

    int requestGroupCreation(String str, Bundle bundle, Bundle bundle2, IGroupInvitationResultCallback iGroupInvitationResultCallback);

    int requestGroupCreationWithData(Bundle bundle, Bundle bundle2, Bundle bundle3, IGroupInvitationResultCallback iGroupInvitationResultCallback);

    int requestGroupDeletion(String str, String str2, IGroupRequestResultCallback iGroupRequestResultCallback);

    int requestGroupDeletionWithData(Bundle bundle, IGroupRequestResultCallback iGroupRequestResultCallback);

    int requestGroupInvitationAcceptance(String str, String str2, IGroupRequestResultCallback iGroupRequestResultCallback);

    int requestGroupInvitationAcceptanceWithData(Bundle bundle, IGroupRequestResultCallback iGroupRequestResultCallback);

    int requestGroupInvitationRejection(String str, String str2, IGroupRequestResultCallback iGroupRequestResultCallback);

    int requestGroupInvitationRejectionWithData(Bundle bundle, IGroupRequestResultCallback iGroupRequestResultCallback);

    int requestGroupList(String str, IGroupListResultCallback iGroupListResultCallback);

    int requestGroupListWithData(Bundle bundle, IGroupListResultCallback iGroupListResultCallback);

    int requestGroupMemberInvitation(String str, String str2, Bundle bundle, IGroupInvitationResultCallback iGroupInvitationResultCallback);

    int requestGroupMemberInvitationWithData(Bundle bundle, Bundle bundle2, IGroupInvitationResultCallback iGroupInvitationResultCallback);

    int requestGroupMemberList(String str, String str2, IMemberListResultCallback iMemberListResultCallback);

    int requestGroupMemberListWithData(Bundle bundle, IMemberListResultCallback iMemberListResultCallback);

    int requestGroupMemberRemoval(String str, String str2, String str3, IGroupRequestResultCallback iGroupRequestResultCallback);

    int requestGroupMemberRemovalWithData(Bundle bundle, IGroupRequestResultCallback iGroupRequestResultCallback);

    int requestGroupPendingInvitationCancellation(String str, String str2, String str3, IGroupRequestResultCallback iGroupRequestResultCallback);

    int requestGroupPendingInvitationCancellationWithData(Bundle bundle, IGroupRequestResultCallback iGroupRequestResultCallback);

    int requestGroupSync(String str, IGroupSyncResultCallback iGroupSyncResultCallback);

    int requestGroupSyncWithData(Bundle bundle, IGroupSyncResultCallback iGroupSyncResultCallback);

    int requestGroupSyncWithoutImage(String str, IGroupSyncResultCallback iGroupSyncResultCallback);

    int requestGroupSyncWithoutImageWithData(Bundle bundle, IGroupSyncResultCallback iGroupSyncResultCallback);

    int requestGroupUpdate(String str, String str2, Bundle bundle, IGroupResultCallback iGroupResultCallback);

    int requestGroupWithData(Bundle bundle, IGroupResultCallback iGroupResultCallback);

    int requestGroupWithInvitationList(String str, IGroupListWithInvitationResultCallback iGroupListWithInvitationResultCallback);

    int requestGroupWithInvitationListWithData(Bundle bundle, IGroupListWithInvitationResultCallback iGroupListWithInvitationResultCallback);

    int requestInstantShare(String str, Bundle bundle, List<Bundle> list, IShareResultCallback iShareResultCallback);

    int requestInvitationLinkCreation(Bundle bundle, IGroupResultCallback iGroupResultCallback);

    int requestInvitationLinkDeletion(Bundle bundle, IGroupResultCallback iGroupResultCallback);

    int requestLeave(String str, String str2, IGroupRequestResultCallback iGroupRequestResultCallback);

    int requestLeaveWithData(Bundle bundle, IGroupRequestResultCallback iGroupRequestResultCallback);

    int requestMoveItemListToTrashBinWithData(Bundle bundle, ITrashBinResultCallback iTrashBinResultCallback);

    void requestMyActivityPrivacy(IActivityBundleResultCallback iActivityBundleResultCallback);

    void requestMyActivityPrivacyUpdate(Bundle bundle, IActivityResultCallback iActivityResultCallback);

    int requestOriginalGroupImageDownload(String str, String str2, IGroupCoverImageDownloadingResultCallback iGroupCoverImageDownloadingResultCallback);

    int requestOriginalSharedContentWithFileListDownload(String str, String str2, String str3, List<String> list, IContentDownloadingResultCallback iContentDownloadingResultCallback, PendingIntent pendingIntent, Bundle bundle);

    int requestOriginalSharedContentWithFileListDownloadWithData(String str, String str2, String str3, List<String> list, Bundle bundle, IContentDownloadingResultCallback iContentDownloadingResultCallback, PendingIntent pendingIntent, Bundle bundle2);

    int requestOriginalSharedContentWithItemFileListDownloadWithPath(String str, String str2, String str3, List<String> list, IContentDownloadingResultCallback iContentDownloadingResultCallback, PendingIntent pendingIntent, Bundle bundle, String str4);

    /* JADX INFO: renamed from: requestOriginalSharedContentWithItemFileListDownloadWithPathWithData */
    int mo5781xd48f8faa(String str, String str2, String str3, List<String> list, Bundle bundle, IContentDownloadingResultCallback iContentDownloadingResultCallback, PendingIntent pendingIntent, Bundle bundle2, String str4);

    int requestOriginalSharedContentsDownload(String str, String str2, String[] strArr, IContentDownloadingResultCallback iContentDownloadingResultCallback, PendingIntent pendingIntent, Bundle bundle);

    int requestOriginalSharedContentsDownloadToHiddenFolder(Bundle bundle, IContentDownloadingResultCallback iContentDownloadingResultCallback);

    int requestOriginalSharedContentsDownloadWithPath(String str, String str2, String[] strArr, IContentDownloadingResultCallback iContentDownloadingResultCallback, PendingIntent pendingIntent, Bundle bundle, String str3);

    int requestOriginalSpaceImageDownload(String str, String str2, ISpaceCoverImageDownloadingResultCallback iSpaceCoverImageDownloadingResultCallback);

    int requestOriginalSpaceImageDownloadWithData(String str, String str2, Bundle bundle, ISpaceCoverImageDownloadingResultCallback iSpaceCoverImageDownloadingResultCallback);

    void requestProfileImageList(Bundle bundle, IBundleProgressResultCallback iBundleProgressResultCallback);

    void requestPublicBuddyInfo(String str, IPublicBuddyInfoResultCallback iPublicBuddyInfoResultCallback);

    int requestRestoreItemListFromTrashBinWithData(Bundle bundle, ITrashBinResultCallback iTrashBinResultCallback);

    void requestServiceActivation(int i, IServiceActivationResultCallback iServiceActivationResultCallback);

    void requestServiceDeactivation(int i, IServiceDeactivationResultCallback iServiceDeactivationResultCallback);

    int requestServiceNumber(IBundleResultCallback iBundleResultCallback);

    String requestShareListUpdateWithItemFileList(String str, String str2, List<Bundle> list, IShareResultCallback iShareResultCallback, PendingIntent pendingIntent, Bundle bundle);

    String requestShareListUpdateWithItemFileListWithData(String str, String str2, List<Bundle> list, Bundle bundle, IShareResultCallback iShareResultCallback, PendingIntent pendingIntent, Bundle bundle2);

    int requestShareSync(String str, IShareSyncResultCallback iShareSyncResultCallback);

    int requestShareSyncWithData(String str, Bundle bundle, IShareSyncResultCallback iShareSyncResultCallback);

    int requestShareSyncWithOption(String str, Bundle bundle, IShareSyncResultCallback iShareSyncResultCallback);

    String requestShareUpdateWithUriList(String str, String str2, String str3, Bundle bundle, IShareResultWithFileListCallback iShareResultWithFileListCallback, PendingIntent pendingIntent, Bundle bundle2);

    String requestShareWithData(String str, String str2, List<Bundle> list, Bundle bundle, IShareResultCallback iShareResultCallback);

    String requestShareWithFileList(String str, String str2, Bundle bundle, IShareResultWithFileListCallback iShareResultWithFileListCallback, PendingIntent pendingIntent, Bundle bundle2);

    String requestShareWithFileListWithData(String str, String str2, Bundle bundle, Bundle bundle2, IShareResultWithFileListCallback iShareResultWithFileListCallback, PendingIntent pendingIntent, Bundle bundle3);

    String requestShareWithItemFileList(String str, String str2, List<Bundle> list, IShareResultCallback iShareResultCallback, PendingIntent pendingIntent, Bundle bundle);

    String requestShareWithItemFileListWithData(String str, String str2, List<Bundle> list, Bundle bundle, IShareResultCallback iShareResultCallback, PendingIntent pendingIntent, Bundle bundle2);

    String requestShareWithPendingIntent(String str, String str2, List<Bundle> list, IShareResultCallback iShareResultCallback, PendingIntent pendingIntent, Bundle bundle);

    int requestSharedItem(String str, String str2, String str3, ISharedItemResultCallback iSharedItemResultCallback);

    int requestSharedItemDeletion(String str, String str2, String str3, ISharedItemDeletionResultCallback iSharedItemDeletionResultCallback);

    int requestSharedItemDeletionWithData(String str, String str2, String str3, Bundle bundle, ISharedItemDeletionResultCallback iSharedItemDeletionResultCallback);

    int requestSharedItemList(String str, String str2, String str3, String str4, ISharedItemListResultCallback iSharedItemListResultCallback);

    int requestSharedItemListDeletion(String str, String str2, List<String> list, ISharedItemListDeletionResultCallback iSharedItemListDeletionResultCallback);

    int requestSharedItemListDeletionWithData(String str, String str2, List<String> list, Bundle bundle, ISharedItemListDeletionResultCallback iSharedItemListDeletionResultCallback);

    int requestSharedItemListInTrashBinWithData(Bundle bundle, ISharedItemListResultCallback iSharedItemListResultCallback);

    String requestSharedItemListUpdate(String str, String str2, List<Bundle> list, IShareResultCallback iShareResultCallback, PendingIntent pendingIntent, Bundle bundle);

    int requestSharedItemListWithFileList(String str, String str2, String str3, String str4, ISharedItemListResultCallback iSharedItemListResultCallback);

    int requestSharedItemListWithFileListWithData(String str, String str2, String str3, String str4, Bundle bundle, ISharedItemListResultCallback iSharedItemListResultCallback);

    int requestSharedItemSync(String str, String str2, IShareSyncResultCallback iShareSyncResultCallback);

    int requestSharedItemSyncWithData(String str, String str2, Bundle bundle, IShareSyncResultCallback iShareSyncResultCallback);

    void requestSharedItemSyncWithResolution(String str, Bundle bundle, IShareSyncResultCallback iShareSyncResultCallback);

    int requestSharedItemSyncWithResolutionWithData(String str, Bundle bundle, Bundle bundle2, IShareSyncResultCallback iShareSyncResultCallback);

    String requestSharedItemUpdate(String str, String str2, String str3, Bundle bundle, ISharedItemUpdateResultCallback iSharedItemUpdateResultCallback, PendingIntent pendingIntent, Bundle bundle2);

    int requestSharedItemWithData(String str, String str2, String str3, Bundle bundle, ISharedItemResultCallback iSharedItemResultCallback);

    int requestSharedItemWithGroupId(String str, String str2, String str3, String str4, ISharedItemResultCallback iSharedItemResultCallback);

    int requestSharedItemWithGroupIdWithData(String str, String str2, String str3, String str4, Bundle bundle, ISharedItemResultCallback iSharedItemResultCallback);

    int requestSpace(String str, String str2, ISpaceResultCallback iSpaceResultCallback);

    int requestSpaceCreation(String str, String str2, Bundle bundle, ISpaceResultCallback iSpaceResultCallback);

    int requestSpaceCreationWithData(String str, String str2, Bundle bundle, Bundle bundle2, ISpaceResultCallback iSpaceResultCallback);

    int requestSpaceDeletion(String str, String str2, ISpaceDeletionResultCallback iSpaceDeletionResultCallback);

    int requestSpaceDeletionWithData(String str, String str2, Bundle bundle, ISpaceDeletionResultCallback iSpaceDeletionResultCallback);

    int requestSpaceList(String str, String str2, ISpaceListResultCallback iSpaceListResultCallback);

    int requestSpaceListSync(String str, IShareSyncResultCallback iShareSyncResultCallback);

    int requestSpaceListSyncWithData(String str, Bundle bundle, IShareSyncResultCallback iShareSyncResultCallback);

    int requestSpaceListWithData(String str, String str2, Bundle bundle, ISpaceListResultCallback iSpaceListResultCallback);

    int requestSpaceUpdate(String str, String str2, Bundle bundle, ISpaceResultCallback iSpaceResultCallback);

    int requestSpaceUpdateWithData(String str, String str2, Bundle bundle, Bundle bundle2, ISpaceResultCallback iSpaceResultCallback);

    int requestSpaceWithData(String str, String str2, Bundle bundle, ISpaceResultCallback iSpaceResultCallback);

    void requestSync(ISyncResultCallback iSyncResultCallback);

    int requestThumbnailDownload(String str, String str2, String str3, String str4, String str5, String str6, IDownloadThumbnailResultCallback iDownloadThumbnailResultCallback);

    int requestWebLinkEnabled(Bundle bundle, boolean z, IBundleResultCallback iBundleResultCallback);

    int resumeShare(String str, String str2);

    Bundle setBuddyActivityListRead(Bundle bundle);

    boolean setDisclaimerAgreementForSocial(Bundle bundle);

    int setShareStatusListener(String str, String str2, IShareStatusCallback iShareStatusCallback);
}
