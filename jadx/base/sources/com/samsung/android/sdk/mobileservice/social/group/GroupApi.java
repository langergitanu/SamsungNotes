package com.samsung.android.sdk.mobileservice.social.group;

import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.AbstractC2821a;
import com.samsung.android.sdk.mobileservice.SeMobileServiceSession;
import com.samsung.android.sdk.mobileservice.common.CommonConstants;
import com.samsung.android.sdk.mobileservice.common.ErrorCodeConvertor;
import com.samsung.android.sdk.mobileservice.common.api.SeMobileServiceApi;
import com.samsung.android.sdk.mobileservice.common.exception.NotAuthorizedException;
import com.samsung.android.sdk.mobileservice.common.exception.NotConnectedException;
import com.samsung.android.sdk.mobileservice.common.exception.NotSupportedApiException;
import com.samsung.android.sdk.mobileservice.common.result.BooleanResult;
import com.samsung.android.sdk.mobileservice.common.result.CommonResultStatus;
import com.samsung.android.sdk.mobileservice.social.group.GroupAuthority;
import com.samsung.android.sdk.mobileservice.social.group.IGroupCoverImageDownloadingResultCallback;
import com.samsung.android.sdk.mobileservice.social.group.IGroupInvitationResultCallback;
import com.samsung.android.sdk.mobileservice.social.group.IGroupListResultCallback;
import com.samsung.android.sdk.mobileservice.social.group.IGroupListWithInvitationResultCallback;
import com.samsung.android.sdk.mobileservice.social.group.IGroupRequestResultCallback;
import com.samsung.android.sdk.mobileservice.social.group.IGroupResultCallback;
import com.samsung.android.sdk.mobileservice.social.group.IGroupSyncResultCallback;
import com.samsung.android.sdk.mobileservice.social.group.IMemberListResultCallback;
import com.samsung.android.sdk.mobileservice.social.group.provider.GroupInvitationContract;
import com.samsung.android.sdk.mobileservice.social.group.result.GroupAuthorityListResult;
import com.samsung.android.sdk.mobileservice.social.group.result.GroupImageDownloadResult;
import com.samsung.android.sdk.mobileservice.social.group.result.GroupInvitationListResult;
import com.samsung.android.sdk.mobileservice.social.group.result.GroupInvitationResult;
import com.samsung.android.sdk.mobileservice.social.group.result.GroupListResult;
import com.samsung.android.sdk.mobileservice.social.group.result.GroupMemberResult;
import com.samsung.android.sdk.mobileservice.social.group.result.GroupResult;
import com.samsung.android.sdk.mobileservice.social.group.result.InvitationLinkResult;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.request.ImportHandler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class GroupApi extends SeMobileServiceApi {
    public static final String API_NAME = "GroupApi";
    private final HashSet<Integer> featureIdSet;
    private int mFeatureId;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class FamilyGroupRequest {
        private final String mGroupName;

        public FamilyGroupRequest(String str) {
            this.mGroupName = str;
        }

        public String getGroupName() {
            return this.mGroupName;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface GroupListResultCallback {
        void onResult(GroupListResult groupListResult);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface GroupResultCallback<T> {
        void onResult(T t);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface GroupSyncResultCallback {
        void onResult(BooleanResult booleanResult);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ImageDownloadingResultCallback {
        void onResult(GroupImageDownloadResult groupImageDownloadResult);
    }

    public GroupApi(SeMobileServiceSession seMobileServiceSession) throws NotAuthorizedException {
        super(seMobileServiceSession, "GroupApi");
        this.mFeatureId = -1;
        this.featureIdSet = new HashSet<>(Arrays.asList(4, 32, 32, 101, 102, 103, 104, 107, 501));
        checkAuthorized(0, 2);
    }

    private GroupAuthority bundleToAuthority(Bundle bundle) {
        String string = bundle.getString("group_id");
        String string2 = bundle.getString("member_guid");
        String string3 = bundle.getString("optional_id");
        String string4 = bundle.getString("authority");
        int i = bundle.getInt(BundleKey.FAILED_REASON, 0);
        GroupAuthority.AuthorityType authorityType = GroupAuthority.AuthorityType.toAuthorityType(string4);
        debugLog("- groupId=[" + string + "]");
        debugLog("- authority=[" + string4 + "]");
        debugLog("- failedReason=[" + i + "]");
        return new GroupAuthority(string, string2, string3, authorityType, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<GroupAuthority> bundleToAuthorityList(Bundle bundle) {
        ArrayList arrayList = new ArrayList();
        if (bundle == null) {
            debugLog("bundle is null : bundleToAuthorityList");
            return arrayList;
        }
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(BundleKey.AUTHORITY_LIST);
        if (parcelableArrayList != null) {
            Iterator it = parcelableArrayList.iterator();
            while (it.hasNext()) {
                arrayList.add(bundleToAuthority((Bundle) it.next()));
            }
        }
        debugLog("bundleToActivityList size : " + arrayList.size());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Group bundleToGroup(Bundle bundle) {
        String string = bundle.getString("group_id", null);
        String string2 = bundle.getString("group_name", null);
        debugLog(AbstractC0541b.m775q("- groupId=[", string, "], groupName=[", string2, "] "));
        String string3 = bundle.getString(BundleKey.GROUP_TYPE, null);
        String string4 = bundle.getString(com.samsung.android.sdk.mobileservice.social.share.BundleKey.OWNER_ID, null);
        long j = bundle.getLong(com.samsung.android.sdk.mobileservice.social.share.BundleKey.CREATED_TIME, 0L);
        int i = bundle.getInt("max_member_count", 0);
        int i2 = bundle.getInt("active_member_count", 0);
        long j2 = bundle.getLong("group_update_time", 0L);
        long j3 = bundle.getLong("contents_update_time", 0L);
        long j5 = bundle.getLong("expire_time", 0L);
        boolean z = bundle.getBoolean(BundleKey.AUTHORITY_MANAGE, false);
        String string5 = bundle.getString(BundleKey.DEFAULT_MEMBER_AUTHORITY);
        GroupAuthority.AuthorityType authorityType = GroupAuthority.AuthorityType.toAuthorityType(string5);
        InvitationLink invitationLinkBundleToInvitationLink = bundleToInvitationLink(bundle);
        debugLog("- groupType=[" + string3 + "]");
        debugLog("- maxMemberCount=[" + i + "]");
        debugLog("- activeMemberCount=[" + i2 + "]");
        debugLog("- contentsUpdateTime=[" + j3 + "]");
        debugLog("- expireTime=[" + j5 + "]");
        debugLog("- authorityManage=[" + z + "]");
        debugLog("- defaultMemberAuthority=[" + string5 + "]");
        return new Group(string, string2, string3, string4, j, i, i2, j2, j3, j5, z, invitationLinkBundleToInvitationLink, authorityType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public InvitationLink bundleToInvitationLink(Bundle bundle) {
        if (bundle == null) {
            debugLog("bundle is null : bundleToInvitationLink");
            return null;
        }
        String string = bundle.getString(BundleKey.INVITATION_LINK_URL);
        if (TextUtils.isEmpty(string)) {
            debugLog("url is null : bundleToInvitationLink");
            return null;
        }
        long j = bundle.getLong(BundleKey.INVITATION_LINK_CREATED_TIME);
        long j2 = bundle.getLong(BundleKey.INVITATION_LINK_EXPIRED_TIME);
        InvitationLink invitationLink = new InvitationLink(string, j, j2);
        debugLog("bundleToInvitationLink : " + string + " / " + j + " / " + j2);
        return invitationLink;
    }

    private boolean checkInvalidFeatureIdAndAgentVersion() {
        if (this.mFeatureId != 501 || isSupportedSemsAgentVersionBetween(CommonConstants.SupportedApiMinVersion.VERSION_10_8_9, CommonConstants.SupportedApiMinVersion.VERSION_11_0) || isSupportedSemsAgentVersionMoreThan(CommonConstants.SupportedApiMinVersion.VERSION_13_1_0)) {
            return false;
        }
        infoLog("checkInvalidFeatureIdAndAgentVersion with" + this.mFeatureId + "is not supported in this agent version");
        return true;
    }

    private boolean isValidFeatureId(int i) {
        return this.featureIdSet.contains(Integer.valueOf(i));
    }

    @Override // com.samsung.android.sdk.mobileservice.common.api.SeMobileServiceApi
    public String[] getEssentialServiceNames() {
        return new String[]{"SocialService"};
    }

    public GroupListResult getGroupList() {
        List<Bundle> groupList;
        infoLog("getGroupList started");
        if (checkInvalidFeatureIdAndAgentVersion()) {
            return new GroupListResult(new CommonResultStatus(-7), null);
        }
        if (getAppId() == null) {
            infoLog("app id is null ");
            return new GroupListResult(new CommonResultStatus(-1), null);
        }
        try {
            if (this.mFeatureId == 501) {
                Bundle bundle = new Bundle();
                bundle.putInt("featureId", this.mFeatureId);
                bundle.putString("appId", getAppId());
                groupList = getSocialService().getGroupListWithData(bundle);
            } else {
                groupList = getSocialService().getGroupList(getAppId());
            }
            ArrayList arrayList = new ArrayList();
            Iterator<Bundle> it = groupList.iterator();
            while (it.hasNext()) {
                arrayList.add(bundleToGroup(it.next()));
            }
            return new GroupListResult(new CommonResultStatus(1), arrayList);
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return new GroupListResult(new CommonResultStatus(-1), null);
        } catch (NotConnectedException e2) {
            secureLog(e2);
            return new GroupListResult(new CommonResultStatus(-8), null);
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return new GroupListResult(new CommonResultStatus(-1), null);
        }
    }

    public int requestFamilyGroupCreation(FamilyGroupRequest familyGroupRequest, final GroupResultCallback<GroupResult> groupResultCallback) {
        infoLog("requestFamilyGroupCreation ");
        if (!isSupportedSemsAgentVersionMoreThan(CommonConstants.SupportedApiMinVersion.VERSION_13_1_10)) {
            return -7;
        }
        if (getAppId() == null) {
            infoLog("app id is null ");
            return -1;
        }
        Bundle bundle = new Bundle();
        bundle.putString("group_name", familyGroupRequest.getGroupName());
        IGroupResultCallback.Stub stub = new IGroupResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.group.GroupApi.20
            @Override // com.samsung.android.sdk.mobileservice.social.group.IGroupResultCallback
            public void onFailure(long j, String str) {
                GroupApi groupApi = GroupApi.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestFamilyGroupCreation onFailure : code=[", "], message=[", str);
                sbM2225p.append("] ");
                groupApi.infoLog(sbM2225p.toString());
                if (GroupApi.this.getSemsAgentVersion() >= 1050000000 || groupResultCallback == null) {
                    return;
                }
                groupResultCallback.onResult(new GroupResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), str, Long.toString(j)), null));
            }

            @Override // com.samsung.android.sdk.mobileservice.social.group.IGroupResultCallback
            public void onFailureWithBundle(Bundle bundle2) {
                long j = bundle2.getLong("error_code");
                String string = bundle2.getString("error_message");
                String string2 = bundle2.getString("error_string", null);
                GroupApi groupApi = GroupApi.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestFamilyGroupCreation onFailureWithBundle : code=[", "], message=[", string);
                sbM2225p.append("] ");
                groupApi.infoLog(sbM2225p.toString());
                if (groupResultCallback != null) {
                    groupResultCallback.onResult(new GroupResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), string, Long.toString(j), string2), null));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.group.IGroupResultCallback
            public void onSuccess(Bundle bundle2) {
                GroupApi.this.infoLog("requestFamilyGroupCreation onSuccess ");
                if (groupResultCallback != null) {
                    GroupApi.this.debugLog(AbstractC0541b.m775q("- groupId=[", bundle2.getString("group_id", null), "], groupName=[", bundle2.getString("group_name", null), "] "));
                    groupResultCallback.onResult(new GroupResult(new CommonResultStatus(1), GroupApi.this.bundleToGroup(bundle2)));
                }
            }
        };
        try {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("featureId", this.mFeatureId);
            bundle2.putString("appId", getAppId());
            getSocialService().requestFamilyGroupCreationWithData(bundle2, bundle, stub);
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

    public int requestFamilyGroupDeletion(String str, final GroupResultCallback<BooleanResult> groupResultCallback) {
        infoLog("requestFamilyGroupDeletion ");
        if (!isSupportedSemsAgentVersionMoreThan(CommonConstants.SupportedApiMinVersion.VERSION_13_1_10)) {
            return -7;
        }
        if (getAppId() == null) {
            infoLog("app id is null ");
            return -1;
        }
        IGroupRequestResultCallback.Stub stub = new IGroupRequestResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.group.GroupApi.21
            @Override // com.samsung.android.sdk.mobileservice.social.group.IGroupRequestResultCallback
            public void onFailure(long j, String str2) {
                GroupApi groupApi = GroupApi.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestFamilyGroupDeletion onFailure : code=[", "], message=[", str2);
                sbM2225p.append("] ");
                groupApi.infoLog(sbM2225p.toString());
                if (GroupApi.this.getSemsAgentVersion() >= 1050000000 || groupResultCallback == null) {
                    return;
                }
                groupResultCallback.onResult(new BooleanResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), str2, Long.toString(j)), false));
            }

            @Override // com.samsung.android.sdk.mobileservice.social.group.IGroupRequestResultCallback
            public void onFailureWithBundle(Bundle bundle) {
                long j = bundle.getLong("error_code");
                String string = bundle.getString("error_message");
                String string2 = bundle.getString("error_string", null);
                GroupApi groupApi = GroupApi.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestFamilyGroupDeletion onFailureWithBundle : code=[", "], message=[", string);
                sbM2225p.append("] ");
                groupApi.infoLog(sbM2225p.toString());
                if (groupResultCallback != null) {
                    groupResultCallback.onResult(new BooleanResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), string, Long.toString(j), string2), false));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.group.IGroupRequestResultCallback
            public void onSuccess() {
                GroupApi.this.infoLog("requestFamilyGroupDeletion onSuccess ");
                GroupResultCallback groupResultCallback2 = groupResultCallback;
                if (groupResultCallback2 != null) {
                    groupResultCallback2.onResult(new BooleanResult(new CommonResultStatus(1), true));
                }
            }
        };
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("featureId", this.mFeatureId);
            bundle.putString("appId", getAppId());
            bundle.putString("groupId", str);
            getSocialService().requestFamilyGroupDeletionWithData(bundle, stub);
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

    public int requestFamilyGroupMemberList(String str, final GroupResultCallback<GroupMemberResult> groupResultCallback) {
        infoLog("requestFamilyGroupMemberList");
        if (!isSupportedSemsAgentVersionMoreThan(CommonConstants.SupportedApiMinVersion.VERSION_13_1_10)) {
            return -7;
        }
        if (getAppId() == null) {
            infoLog("app id is null ");
            return -1;
        }
        IMemberListResultCallback.Stub stub = new IMemberListResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.group.GroupApi.22
            @Override // com.samsung.android.sdk.mobileservice.social.group.IMemberListResultCallback
            public void onFailure(long j, String str2) {
                GroupApi groupApi = GroupApi.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestFamilyGroupMemberList onFailure : code=[", "], message=[", str2);
                sbM2225p.append("] ");
                groupApi.infoLog(sbM2225p.toString());
                if (GroupApi.this.getSemsAgentVersion() >= 1050000000 || groupResultCallback == null) {
                    return;
                }
                groupResultCallback.onResult(new GroupMemberResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), str2, Long.toString(j)), null));
            }

            @Override // com.samsung.android.sdk.mobileservice.social.group.IMemberListResultCallback
            public void onFailureWithBundle(Bundle bundle) {
                long j = bundle.getLong("error_code");
                String string = bundle.getString("error_message");
                String string2 = bundle.getString("error_string", null);
                GroupApi groupApi = GroupApi.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestFamilyGroupMemberList onFailureWithBundle : code=[", "], message=[", string);
                sbM2225p.append("] ");
                groupApi.infoLog(sbM2225p.toString());
                if (groupResultCallback != null) {
                    groupResultCallback.onResult(new GroupMemberResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), string, Long.toString(j), string2), null));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.group.IMemberListResultCallback
            public void onSuccess(List<Bundle> list) {
                List<Bundle> list2;
                GroupApi.this.infoLog("requestFamilyGroupMemberList onSuccess ");
                if (groupResultCallback != null) {
                    ArrayList arrayList = new ArrayList();
                    for (Bundle bundle : list) {
                        String string = bundle.getString("name", null);
                        String string2 = bundle.getString("id", null);
                        String string3 = bundle.getString("optionalId", null);
                        int i = bundle.getInt("status", 0);
                        String string4 = bundle.getString("thumbnail_local_path", null);
                        String string5 = bundle.getString("thumbnail_content_uri", null);
                        boolean z = bundle.getBoolean("owner", false);
                        Uri uri = string4 != null ? Uri.parse(string4) : null;
                        Uri uri2 = string4 != null ? Uri.parse(string5) : null;
                        String string6 = bundle.getString("authority", null);
                        GroupMember groupMember = new GroupMember(string2, string3, i, string, z, uri, uri2, GroupAuthority.AuthorityType.toAuthorityType(string6));
                        GroupApi.this.debugLog("- authority=[" + string6 + "]");
                        arrayList.add(groupMember);
                    }
                    GroupMemberResult groupMemberResult = new GroupMemberResult(new CommonResultStatus(1), arrayList);
                    if (list.isEmpty()) {
                        list2 = list;
                        groupMemberResult.setTotalCountWithInvitation(0);
                    } else {
                        list2 = list;
                        groupMemberResult.setTotalCountWithInvitation(list2.get(0).getInt(ImportHandler.KEY_TOTAL, 0));
                    }
                    GroupApi.this.infoLog("requestFamilyGroupMemberList onSuccess. result size: " + list2.size() + ", groupMembers size: " + arrayList.size());
                    groupResultCallback.onResult(groupMemberResult);
                }
            }
        };
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("featureId", this.mFeatureId);
            bundle.putString("appId", getAppId());
            bundle.putString("groupId", str);
            getSocialService().requestFamilyGroupMemberListWithData(bundle, stub);
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

    public int requestGroup(String str, final GroupResultCallback<GroupResult> groupResultCallback) {
        infoLog("requestGroup : groupId=[" + str + "] ");
        if (!isSupportedSemsAgentVersionMoreThan(CommonConstants.SupportedApiMinVersion.VERSION_4_1) || checkInvalidFeatureIdAndAgentVersion()) {
            return -7;
        }
        if (getAppId() == null) {
            infoLog("app id is null ");
            return -1;
        }
        IGroupResultCallback.Stub stub = new IGroupResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.group.GroupApi.2
            @Override // com.samsung.android.sdk.mobileservice.social.group.IGroupResultCallback
            public void onFailure(long j, String str2) {
                GroupApi groupApi = GroupApi.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestGroup onFailure : code=[", "], message=[", str2);
                sbM2225p.append("] ");
                groupApi.infoLog(sbM2225p.toString());
                if (GroupApi.this.getSemsAgentVersion() >= 1050000000 || groupResultCallback == null) {
                    return;
                }
                groupResultCallback.onResult(new GroupResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), str2, Long.toString(j)), null));
            }

            @Override // com.samsung.android.sdk.mobileservice.social.group.IGroupResultCallback
            public void onFailureWithBundle(Bundle bundle) {
                long j = bundle.getLong("error_code");
                String string = bundle.getString("error_message");
                String string2 = bundle.getString("error_string", null);
                GroupApi groupApi = GroupApi.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestGroup onFailureWithBundle : code=[", "], message=[", string);
                sbM2225p.append("] ");
                groupApi.infoLog(sbM2225p.toString());
                if (groupResultCallback != null) {
                    groupResultCallback.onResult(new GroupResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), string, Long.toString(j), string2), null));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.group.IGroupResultCallback
            public void onSuccess(Bundle bundle) {
                GroupApi.this.infoLog("requestGroup onSuccess ");
                GroupResultCallback groupResultCallback2 = groupResultCallback;
                if (groupResultCallback2 != null) {
                    groupResultCallback2.onResult(new GroupResult(new CommonResultStatus(1), GroupApi.this.bundleToGroup(bundle)));
                }
            }
        };
        try {
            if (this.mFeatureId != 501) {
                getSocialService().requestGroup(getAppId(), str, stub);
                return 1;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("featureId", this.mFeatureId);
            bundle.putString("appId", getAppId());
            bundle.putString("groupId", str);
            getSocialService().requestGroupWithData(bundle, stub);
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

    public int requestGroupAuthorityChange(String str, List<String> list, GroupAuthority.AuthorityType authorityType, final GroupResultCallback<GroupAuthorityListResult> groupResultCallback) {
        infoLog("requestGroupAuthorityChange ");
        if (checkInvalidFeatureIdAndAgentVersion()) {
            return -7;
        }
        if (this.mFeatureId != 501) {
            infoLog("requestGroupAuthorityChange is not supported in FEATURE_ID_INVALID");
            return -1;
        }
        if (getAppId() == null) {
            infoLog("app id is null ");
            return -1;
        }
        IGroupResultCallback.Stub stub = new IGroupResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.group.GroupApi.19
            @Override // com.samsung.android.sdk.mobileservice.social.group.IGroupResultCallback
            public void onFailure(long j, String str2) {
                GroupApi groupApi = GroupApi.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestGroupAuthorityChange onFailure : code=[", "], message=[", str2);
                sbM2225p.append("] ");
                groupApi.infoLog(sbM2225p.toString());
                if (GroupApi.this.getSemsAgentVersion() >= 1050000000 || groupResultCallback == null) {
                    return;
                }
                groupResultCallback.onResult(new GroupAuthorityListResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), str2, Long.toString(j)), null));
            }

            @Override // com.samsung.android.sdk.mobileservice.social.group.IGroupResultCallback
            public void onFailureWithBundle(Bundle bundle) {
                long j = bundle.getLong("error_code");
                String string = bundle.getString("error_message");
                String string2 = bundle.getString("error_string", null);
                GroupApi groupApi = GroupApi.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestGroupAuthorityChange onFailureWithBundle : code=[", "], message=[", string);
                sbM2225p.append("] ");
                groupApi.infoLog(sbM2225p.toString());
                if (groupResultCallback != null) {
                    groupResultCallback.onResult(new GroupAuthorityListResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), string, Long.toString(j), string2), null));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.group.IGroupResultCallback
            public void onSuccess(Bundle bundle) {
                GroupApi.this.infoLog("requestGroupAuthorityChange onSuccess ");
                GroupResultCallback groupResultCallback2 = groupResultCallback;
                if (groupResultCallback2 != null) {
                    groupResultCallback2.onResult(new GroupAuthorityListResult(new CommonResultStatus(1), GroupApi.this.bundleToAuthorityList(bundle)));
                }
            }
        };
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("featureId", this.mFeatureId);
            bundle.putString("appId", getAppId());
            bundle.putString("groupId", str);
            bundle.putString("authority", authorityType.getAuthority());
            bundle.putStringArrayList("memberGuidList", new ArrayList<>(list));
            getSocialService().requestGroupAuthorityChange(bundle, stub);
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
    public int requestGroupCoverImageDownload(String str, final ImageDownloadingResultCallback imageDownloadingResultCallback) {
        infoLog("requestOriginalImageDownload groupId=[" + str + "] ");
        if (getAppId() == null) {
            infoLog("app id is null ");
            return -1;
        }
        if (this.mFeatureId != -1) {
            infoLog("The cover image is not supported in " + this.mFeatureId);
            return -1;
        }
        try {
            getSocialService().requestOriginalGroupImageDownload(getAppId(), str, new IGroupCoverImageDownloadingResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.group.GroupApi.1
                @Override // com.samsung.android.sdk.mobileservice.social.group.IGroupCoverImageDownloadingResultCallback
                public void onFailure(long j, String str2) {
                    GroupApi groupApi = GroupApi.this;
                    StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestGroupCoverImageDownload onFailure : code=[", "], message=[", str2);
                    sbM2225p.append("] ");
                    groupApi.infoLog(sbM2225p.toString());
                    if (GroupApi.this.getSemsAgentVersion() >= 1050000000 || imageDownloadingResultCallback == null) {
                        return;
                    }
                    imageDownloadingResultCallback.onResult(new GroupImageDownloadResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), str2, Long.toString(j)), null));
                }

                @Override // com.samsung.android.sdk.mobileservice.social.group.IGroupCoverImageDownloadingResultCallback
                public void onFailureWithBundle(Bundle bundle) {
                    long j = bundle.getLong("error_code");
                    String string = bundle.getString("error_message");
                    String string2 = bundle.getString("error_string", null);
                    GroupApi groupApi = GroupApi.this;
                    StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestGroupCoverImageDownload onFailureWithBundle : code=[", "], message=[", string);
                    sbM2225p.append("] ");
                    groupApi.infoLog(sbM2225p.toString());
                    if (imageDownloadingResultCallback != null) {
                        imageDownloadingResultCallback.onResult(new GroupImageDownloadResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), string, Long.toString(j), string2), null));
                    }
                }

                @Override // com.samsung.android.sdk.mobileservice.social.group.IGroupCoverImageDownloadingResultCallback
                public void onSuccess(Bundle bundle) {
                    GroupApi.this.infoLog("requestOriginalImageDownload onSuccess ");
                    if (imageDownloadingResultCallback != null) {
                        String string = bundle.getString("group_id", null);
                        String string2 = bundle.getString(com.samsung.android.sdk.mobileservice.social.share.BundleKey.DOWNLOADED_URI, null);
                        GroupImageDownloadResult.DownloadedImage downloadedImage = new GroupImageDownloadResult.DownloadedImage(string, string2 != null ? Uri.parse(string2) : null);
                        GroupApi.this.debugLog(AbstractC0541b.m775q("- groupId=[", string, "], uriString=[", string2, "] "));
                        imageDownloadingResultCallback.onResult(new GroupImageDownloadResult(new CommonResultStatus(1), downloadedImage));
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

    public int requestGroupCreation(GroupRequest groupRequest, InvitationRequest invitationRequest, final GroupResultCallback<GroupInvitationResult> groupResultCallback) {
        Bundle bundle;
        infoLog("requestGroupCreation ");
        if (!isSupportedSemsAgentVersionMoreThan(1000000000) || checkInvalidFeatureIdAndAgentVersion()) {
            return -7;
        }
        if (getAppId() == null) {
            infoLog("app id is null ");
            return -1;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("group_name", groupRequest.getGroupName());
        bundle2.putString(BundleKey.GROUP_TYPE, groupRequest.getGroupType());
        bundle2.putString("mime_type", groupRequest.getMimeType());
        if (groupRequest.getCoverImageUri() != null) {
            bundle2.putString("cover_thumbnail_uri", groupRequest.getCoverImageUri().toString());
        }
        if (groupRequest.getUseInvitationLink()) {
            bundle2.putBoolean(BundleKey.USE_INVITATION_LINK, groupRequest.getUseInvitationLink());
        }
        if (groupRequest.getDefaultMemberAuthorityType() != GroupAuthority.AuthorityType.INVALID) {
            bundle2.putString(BundleKey.DEFAULT_MEMBER_AUTHORITY, groupRequest.getDefaultMemberAuthorityType().getAuthority());
        }
        if (invitationRequest != null) {
            bundle = new Bundle();
            bundle.putInt("invitation_type", invitationRequest.getIdType());
            bundle.putString("invitation_message", invitationRequest.getInvitationMessage());
            bundle.putStringArrayList("id", new ArrayList<>(invitationRequest.getIds()));
            bundle.putStringArrayList("optionalId", new ArrayList<>(invitationRequest.getOptionalIds()));
        } else {
            bundle = null;
        }
        IGroupInvitationResultCallback.Stub stub = new IGroupInvitationResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.group.GroupApi.6
            @Override // com.samsung.android.sdk.mobileservice.social.group.IGroupInvitationResultCallback
            public void onFailure(long j, String str) {
                GroupApi groupApi = GroupApi.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestGroupCreation onFailure : code=[", "], message=[", str);
                sbM2225p.append("] ");
                groupApi.infoLog(sbM2225p.toString());
                if (GroupApi.this.getSemsAgentVersion() >= 1050000000 || groupResultCallback == null) {
                    return;
                }
                groupResultCallback.onResult(new GroupInvitationResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), str, Long.toString(j)), null, null, null));
            }

            @Override // com.samsung.android.sdk.mobileservice.social.group.IGroupInvitationResultCallback
            public void onFailureWithBundle(Bundle bundle3) {
                long j = bundle3.getLong("error_code");
                String string = bundle3.getString("error_message");
                String string2 = bundle3.getString("error_string", null);
                GroupApi groupApi = GroupApi.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestGroupCreation onFailureWithBundle : code=[", "], message=[", string);
                sbM2225p.append("] ");
                groupApi.infoLog(sbM2225p.toString());
                if (groupResultCallback != null) {
                    groupResultCallback.onResult(new GroupInvitationResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), string, Long.toString(j), string2), null, null, null));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.group.IGroupInvitationResultCallback
            public void onSuccess(Bundle bundle3, List<Bundle> list) {
                GroupApi.this.infoLog("requestGroupCreation onSuccess ");
                if (groupResultCallback != null) {
                    GroupApi.this.debugLog(AbstractC0541b.m775q("- groupId=[", bundle3.getString("group_id", null), "], groupName=[", bundle3.getString("group_name", null), "] "));
                    String string = bundle3.getString("error_string", "");
                    Group groupBundleToGroup = GroupApi.this.bundleToGroup(bundle3);
                    ArrayList arrayList = new ArrayList();
                    for (Bundle bundle4 : list) {
                        String string2 = bundle4.getString("id", null);
                        String string3 = bundle4.getString("optionalId", null);
                        String string4 = bundle4.getString("reason", null);
                        GroupApi.this.debugLog("- reason=[" + string4 + "]");
                        arrayList.add(new GroupInvitationResult.ExcludedMember(string2, string3, string4));
                    }
                    groupResultCallback.onResult(new GroupInvitationResult(new CommonResultStatus(1), groupBundleToGroup, arrayList, string));
                }
            }
        };
        try {
            if (this.mFeatureId != 501) {
                getSocialService().requestGroupCreation(getAppId(), bundle2, bundle, stub);
                return 1;
            }
            Bundle bundle3 = new Bundle();
            bundle3.putInt("featureId", this.mFeatureId);
            bundle3.putString("appId", getAppId());
            getSocialService().requestGroupCreationWithData(bundle3, bundle2, bundle, stub);
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

    public int requestGroupDeletion(String str, final GroupResultCallback<BooleanResult> groupResultCallback) {
        infoLog("requestGroupDeletion ");
        if (!isSupportedSemsAgentVersionMoreThan(1000000000) || checkInvalidFeatureIdAndAgentVersion()) {
            return -7;
        }
        if (getAppId() == null) {
            infoLog("app id is null ");
            return -1;
        }
        IGroupRequestResultCallback.Stub stub = new IGroupRequestResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.group.GroupApi.9
            @Override // com.samsung.android.sdk.mobileservice.social.group.IGroupRequestResultCallback
            public void onFailure(long j, String str2) {
                GroupApi groupApi = GroupApi.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestGroupDeletion onFailure : code=[", "], message=[", str2);
                sbM2225p.append("] ");
                groupApi.infoLog(sbM2225p.toString());
                if (GroupApi.this.getSemsAgentVersion() >= 1050000000 || groupResultCallback == null) {
                    return;
                }
                groupResultCallback.onResult(new BooleanResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), str2, Long.toString(j)), false));
            }

            @Override // com.samsung.android.sdk.mobileservice.social.group.IGroupRequestResultCallback
            public void onFailureWithBundle(Bundle bundle) {
                long j = bundle.getLong("error_code");
                String string = bundle.getString("error_message");
                String string2 = bundle.getString("error_string", null);
                GroupApi groupApi = GroupApi.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestGroupDeletion onFailureWithBundle : code=[", "], message=[", string);
                sbM2225p.append("] ");
                groupApi.infoLog(sbM2225p.toString());
                if (groupResultCallback != null) {
                    groupResultCallback.onResult(new BooleanResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), string, Long.toString(j), string2), false));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.group.IGroupRequestResultCallback
            public void onSuccess() {
                GroupApi.this.infoLog("requestGroupDeletion onSuccess ");
                GroupResultCallback groupResultCallback2 = groupResultCallback;
                if (groupResultCallback2 != null) {
                    groupResultCallback2.onResult(new BooleanResult(new CommonResultStatus(1), true));
                }
            }
        };
        try {
            if (this.mFeatureId != 501) {
                getSocialService().requestGroupDeletion(getAppId(), str, stub);
                return 1;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("featureId", this.mFeatureId);
            bundle.putString("appId", getAppId());
            bundle.putString("groupId", str);
            getSocialService().requestGroupDeletionWithData(bundle, stub);
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

    public int requestGroupInvitationAcceptance(String str, final GroupResultCallback<BooleanResult> groupResultCallback) {
        infoLog("requestGroupInvitationAcceptance ");
        if (checkInvalidFeatureIdAndAgentVersion()) {
            return -7;
        }
        if (getAppId() == null) {
            infoLog("app id is null ");
            return -1;
        }
        IGroupRequestResultCallback.Stub stub = new IGroupRequestResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.group.GroupApi.11
            @Override // com.samsung.android.sdk.mobileservice.social.group.IGroupRequestResultCallback
            public void onFailure(long j, String str2) {
                GroupApi groupApi = GroupApi.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestGroupInvitationAcceptance onFailure : code=[", "], message=[", str2);
                sbM2225p.append("] ");
                groupApi.infoLog(sbM2225p.toString());
                if (GroupApi.this.getSemsAgentVersion() >= 1050000000 || groupResultCallback == null) {
                    return;
                }
                groupResultCallback.onResult(new BooleanResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), str2, Long.toString(j)), false));
            }

            @Override // com.samsung.android.sdk.mobileservice.social.group.IGroupRequestResultCallback
            public void onFailureWithBundle(Bundle bundle) {
                long j = bundle.getLong("error_code");
                String string = bundle.getString("error_message");
                String string2 = bundle.getString("error_string", null);
                GroupApi groupApi = GroupApi.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestGroupInvitationAcceptance onFailureWithBundle : code=[", "], message=[", string);
                sbM2225p.append("] ");
                groupApi.infoLog(sbM2225p.toString());
                if (groupResultCallback != null) {
                    groupResultCallback.onResult(new BooleanResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), string, Long.toString(j), string2), false));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.group.IGroupRequestResultCallback
            public void onSuccess() {
                GroupApi.this.infoLog("requestGroupInvitationAcceptance onSuccess ");
                GroupResultCallback groupResultCallback2 = groupResultCallback;
                if (groupResultCallback2 != null) {
                    groupResultCallback2.onResult(new BooleanResult(new CommonResultStatus(1), true));
                }
            }
        };
        try {
            if (this.mFeatureId != 501) {
                getSocialService().requestGroupInvitationAcceptance(getAppId(), str, stub);
                return 1;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("featureId", this.mFeatureId);
            bundle.putString("appId", getAppId());
            bundle.putString("groupId", str);
            getSocialService().requestGroupInvitationAcceptanceWithData(bundle, stub);
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

    public int requestGroupInvitationRejection(String str, final GroupResultCallback<BooleanResult> groupResultCallback) {
        infoLog("requestGroupInvitationRejection ");
        if (checkInvalidFeatureIdAndAgentVersion()) {
            return -7;
        }
        if (getAppId() == null) {
            infoLog("app id is null ");
            return -1;
        }
        IGroupRequestResultCallback.Stub stub = new IGroupRequestResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.group.GroupApi.12
            @Override // com.samsung.android.sdk.mobileservice.social.group.IGroupRequestResultCallback
            public void onFailure(long j, String str2) {
                GroupApi groupApi = GroupApi.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestGroupInvitationRejection onFailure : code=[", "], message=[", str2);
                sbM2225p.append("] ");
                groupApi.infoLog(sbM2225p.toString());
                if (GroupApi.this.getSemsAgentVersion() >= 1050000000 || groupResultCallback == null) {
                    return;
                }
                groupResultCallback.onResult(new BooleanResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), str2, Long.toString(j)), false));
            }

            @Override // com.samsung.android.sdk.mobileservice.social.group.IGroupRequestResultCallback
            public void onFailureWithBundle(Bundle bundle) {
                long j = bundle.getLong("error_code");
                String string = bundle.getString("error_message");
                String string2 = bundle.getString("error_string", null);
                GroupApi groupApi = GroupApi.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestGroupInvitationRejection onFailureWithBundle : code=[", "], message=[", string);
                sbM2225p.append("] ");
                groupApi.infoLog(sbM2225p.toString());
                if (groupResultCallback != null) {
                    groupResultCallback.onResult(new BooleanResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), string, Long.toString(j), string2), false));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.group.IGroupRequestResultCallback
            public void onSuccess() {
                GroupApi.this.infoLog("requestGroupInvitationRejection onSuccess ");
                GroupResultCallback groupResultCallback2 = groupResultCallback;
                if (groupResultCallback2 != null) {
                    groupResultCallback2.onResult(new BooleanResult(new CommonResultStatus(1), true));
                }
            }
        };
        try {
            if (this.mFeatureId != 501) {
                getSocialService().requestGroupInvitationRejection(getAppId(), str, stub);
                return 1;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("featureId", this.mFeatureId);
            bundle.putString("appId", getAppId());
            bundle.putString("groupId", str);
            getSocialService().requestGroupInvitationRejectionWithData(bundle, stub);
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

    public int requestGroupList(final GroupListResultCallback groupListResultCallback) {
        infoLog("requestGroupList ");
        if (!isSupportedSemsAgentVersionMoreThan(CommonConstants.SupportedApiMinVersion.VERSION_4_1) || checkInvalidFeatureIdAndAgentVersion()) {
            return -7;
        }
        if (getAppId() == null) {
            infoLog("app id is null ");
            return -1;
        }
        IGroupListResultCallback.Stub stub = new IGroupListResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.group.GroupApi.3
            @Override // com.samsung.android.sdk.mobileservice.social.group.IGroupListResultCallback
            public void onFailure(long j, String str) {
                GroupApi groupApi = GroupApi.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestGroupList onFailure : code=[", "], message=[", str);
                sbM2225p.append("] ");
                groupApi.infoLog(sbM2225p.toString());
                if (GroupApi.this.getSemsAgentVersion() >= 1050000000 || groupListResultCallback == null) {
                    return;
                }
                groupListResultCallback.onResult(new GroupListResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), str, Long.toString(j)), null));
            }

            @Override // com.samsung.android.sdk.mobileservice.social.group.IGroupListResultCallback
            public void onFailureWithBundle(Bundle bundle) {
                long j = bundle.getLong("error_code");
                String string = bundle.getString("error_message");
                String string2 = bundle.getString("error_string", null);
                GroupApi groupApi = GroupApi.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestGroupList onFailureWithBundle : code=[", "], message=[", string);
                sbM2225p.append("] ");
                groupApi.infoLog(sbM2225p.toString());
                if (groupListResultCallback != null) {
                    groupListResultCallback.onResult(new GroupListResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), string, Long.toString(j), string2), null));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.group.IGroupListResultCallback
            public void onSuccess(List<Bundle> list) {
                GroupApi.this.infoLog("requestGroupList onSuccess ");
                if (groupListResultCallback != null) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<Bundle> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(GroupApi.this.bundleToGroup(it.next()));
                    }
                    groupListResultCallback.onResult(new GroupListResult(new CommonResultStatus(1), arrayList));
                }
            }
        };
        try {
            if (this.mFeatureId != 501) {
                getSocialService().requestGroupList(getAppId(), stub);
                return 1;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("featureId", this.mFeatureId);
            bundle.putString("appId", getAppId());
            getSocialService().requestGroupListWithData(bundle, stub);
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

    public int requestGroupMemberInvitation(String str, InvitationRequest invitationRequest, final GroupResultCallback<GroupInvitationResult> groupResultCallback) {
        infoLog("requestGroupMemberInvitation ");
        if (!isSupportedSemsAgentVersionMoreThan(1000000000) || checkInvalidFeatureIdAndAgentVersion()) {
            return -7;
        }
        if (getAppId() == null) {
            infoLog("app id is null ");
            return -1;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("invitation_type", invitationRequest.getIdType());
        bundle.putString("invitation_message", invitationRequest.getInvitationMessage());
        bundle.putStringArrayList("id", new ArrayList<>(invitationRequest.getIds()));
        bundle.putStringArrayList("optionalId", new ArrayList<>(invitationRequest.getOptionalIds()));
        IGroupInvitationResultCallback.Stub stub = new IGroupInvitationResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.group.GroupApi.10
            @Override // com.samsung.android.sdk.mobileservice.social.group.IGroupInvitationResultCallback
            public void onFailure(long j, String str2) {
                GroupApi groupApi = GroupApi.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestGroupMemberInvitation onFailure : code=[", "], message=[", str2);
                sbM2225p.append("] ");
                groupApi.infoLog(sbM2225p.toString());
                if (GroupApi.this.getSemsAgentVersion() >= 1050000000 || groupResultCallback == null) {
                    return;
                }
                groupResultCallback.onResult(new GroupInvitationResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), str2, Long.toString(j)), null, null, null));
            }

            @Override // com.samsung.android.sdk.mobileservice.social.group.IGroupInvitationResultCallback
            public void onFailureWithBundle(Bundle bundle2) {
                long j = bundle2.getLong("error_code");
                String string = bundle2.getString("error_message");
                String string2 = bundle2.getString("error_string", null);
                GroupApi groupApi = GroupApi.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestGroupMemberInvitation onFailureWithBundle : code=[", "], message=[", string);
                sbM2225p.append("] ");
                groupApi.infoLog(sbM2225p.toString());
                if (groupResultCallback != null) {
                    groupResultCallback.onResult(new GroupInvitationResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), string, Long.toString(j), string2), null, null, null));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.group.IGroupInvitationResultCallback
            public void onSuccess(Bundle bundle2, List<Bundle> list) {
                GroupApi.this.infoLog("requestGroupMemberInvitation onSuccess ");
                if (groupResultCallback != null) {
                    GroupApi.this.debugLog(AbstractC0541b.m775q("- groupId=[", bundle2.getString("group_id", null), "], groupName=[", bundle2.getString("group_name", null), "] "));
                    String string = bundle2.getString("error_string", "");
                    Group groupBundleToGroup = GroupApi.this.bundleToGroup(bundle2);
                    ArrayList arrayList = new ArrayList();
                    for (Bundle bundle3 : list) {
                        String string2 = bundle3.getString("id", null);
                        String string3 = bundle3.getString("optionalId", null);
                        String string4 = bundle3.getString("reason", null);
                        GroupApi.this.debugLog("- reason=[" + string4 + "]");
                        arrayList.add(new GroupInvitationResult.ExcludedMember(string2, string3, string4));
                    }
                    groupResultCallback.onResult(new GroupInvitationResult(new CommonResultStatus(1), groupBundleToGroup, arrayList, string));
                }
            }
        };
        try {
            if (this.mFeatureId != 501) {
                getSocialService().requestGroupMemberInvitation(getAppId(), str, bundle, stub);
                return 1;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putInt("featureId", this.mFeatureId);
            bundle2.putString("appId", getAppId());
            bundle2.putString("groupId", str);
            getSocialService().requestGroupMemberInvitationWithData(bundle2, bundle, stub);
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

    public int requestGroupMemberList(String str, final GroupResultCallback<GroupMemberResult> groupResultCallback) {
        infoLog("requestGroupMemberList ");
        if (!isSupportedSemsAgentVersionMoreThan(1000000000) || checkInvalidFeatureIdAndAgentVersion()) {
            return -7;
        }
        if (getAppId() == null) {
            infoLog("app id is null ");
            return -1;
        }
        IMemberListResultCallback.Stub stub = new IMemberListResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.group.GroupApi.13
            @Override // com.samsung.android.sdk.mobileservice.social.group.IMemberListResultCallback
            public void onFailure(long j, String str2) {
                GroupApi groupApi = GroupApi.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestGroupMemberList onFailure : code=[", "], message=[", str2);
                sbM2225p.append("] ");
                groupApi.infoLog(sbM2225p.toString());
                if (GroupApi.this.getSemsAgentVersion() >= 1050000000 || groupResultCallback == null) {
                    return;
                }
                groupResultCallback.onResult(new GroupMemberResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), str2, Long.toString(j)), null));
            }

            @Override // com.samsung.android.sdk.mobileservice.social.group.IMemberListResultCallback
            public void onFailureWithBundle(Bundle bundle) {
                long j = bundle.getLong("error_code");
                String string = bundle.getString("error_message");
                String string2 = bundle.getString("error_string", null);
                GroupApi groupApi = GroupApi.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestGroupMemberList onFailureWithBundle : code=[", "], message=[", string);
                sbM2225p.append("] ");
                groupApi.infoLog(sbM2225p.toString());
                if (groupResultCallback != null) {
                    groupResultCallback.onResult(new GroupMemberResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), string, Long.toString(j), string2), null));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.group.IMemberListResultCallback
            public void onSuccess(List<Bundle> list) {
                List<Bundle> list2;
                GroupApi.this.infoLog("requestGroupMemberList onSuccess ");
                if (groupResultCallback != null) {
                    ArrayList arrayList = new ArrayList();
                    for (Bundle bundle : list) {
                        String string = bundle.getString("name", null);
                        String string2 = bundle.getString("id", null);
                        String string3 = bundle.getString("optionalId", null);
                        int i = bundle.getInt("status", 0);
                        int i2 = bundle.getInt("invitation_type", 0);
                        String string4 = bundle.getString("thumbnail_local_path", null);
                        String string5 = bundle.getString("thumbnail_content_uri", null);
                        boolean z = bundle.getBoolean("owner", false);
                        Uri uri = string4 != null ? Uri.parse(string4) : null;
                        Uri uri2 = string4 != null ? Uri.parse(string5) : null;
                        String string6 = bundle.getString("authority", null);
                        GroupMember groupMember = i2 != 0 ? new GroupMember(i2, string2, string3, i, string, z, uri, uri2) : new GroupMember(string2, string3, i, string, z, uri, uri2, GroupAuthority.AuthorityType.toAuthorityType(string6));
                        GroupApi.this.debugLog("- authority=[" + string6 + "]");
                        arrayList.add(groupMember);
                    }
                    GroupMemberResult groupMemberResult = new GroupMemberResult(new CommonResultStatus(1), arrayList);
                    if (list.isEmpty()) {
                        list2 = list;
                        groupMemberResult.setTotalCountWithInvitation(0);
                    } else {
                        list2 = list;
                        groupMemberResult.setTotalCountWithInvitation(list2.get(0).getInt(ImportHandler.KEY_TOTAL, 0));
                    }
                    GroupApi.this.infoLog("requestGroupMemberList onSuccess. result size: " + list2.size() + ", groupMembers size: " + arrayList.size());
                    groupResultCallback.onResult(groupMemberResult);
                }
            }
        };
        try {
            if (this.mFeatureId != 501) {
                getSocialService().requestGroupMemberList(getAppId(), str, stub);
                return 1;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("featureId", this.mFeatureId);
            bundle.putString("appId", getAppId());
            bundle.putString("groupId", str);
            getSocialService().requestGroupMemberListWithData(bundle, stub);
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

    public int requestGroupMemberRemoval(String str, String str2, final GroupResultCallback<BooleanResult> groupResultCallback) {
        infoLog("requestGroupMemberRemoval ");
        if (checkInvalidFeatureIdAndAgentVersion()) {
            return -7;
        }
        if (getAppId() == null) {
            infoLog("app id is null ");
            return -1;
        }
        IGroupRequestResultCallback.Stub stub = new IGroupRequestResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.group.GroupApi.15
            @Override // com.samsung.android.sdk.mobileservice.social.group.IGroupRequestResultCallback
            public void onFailure(long j, String str3) {
                GroupApi groupApi = GroupApi.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestGroupMemberRemoval onFailure : code=[", "], message=[", str3);
                sbM2225p.append("] ");
                groupApi.infoLog(sbM2225p.toString());
                if (GroupApi.this.getSemsAgentVersion() >= 1050000000 || groupResultCallback == null) {
                    return;
                }
                groupResultCallback.onResult(new BooleanResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), str3, Long.toString(j)), false));
            }

            @Override // com.samsung.android.sdk.mobileservice.social.group.IGroupRequestResultCallback
            public void onFailureWithBundle(Bundle bundle) {
                long j = bundle.getLong("error_code");
                String string = bundle.getString("error_message");
                String string2 = bundle.getString("error_string", null);
                GroupApi groupApi = GroupApi.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestGroupMemberRemoval onFailureWithBundle : code=[", "], message=[", string);
                sbM2225p.append("] ");
                groupApi.infoLog(sbM2225p.toString());
                if (groupResultCallback != null) {
                    groupResultCallback.onResult(new BooleanResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), string, Long.toString(j), string2), false));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.group.IGroupRequestResultCallback
            public void onSuccess() {
                GroupApi.this.infoLog("requestGroupMemberRemoval onSuccess ");
                GroupResultCallback groupResultCallback2 = groupResultCallback;
                if (groupResultCallback2 != null) {
                    groupResultCallback2.onResult(new BooleanResult(new CommonResultStatus(1), true));
                }
            }
        };
        try {
            if (this.mFeatureId != 501) {
                getSocialService().requestGroupMemberRemoval(getAppId(), str, str2, stub);
                return 1;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("featureId", this.mFeatureId);
            bundle.putString("appId", getAppId());
            bundle.putString("groupId", str);
            bundle.putString("memberGuid", str2);
            getSocialService().requestGroupMemberRemovalWithData(bundle, stub);
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

    public int requestGroupPendingInvitationCancellation(String str, String str2, final GroupResultCallback<BooleanResult> groupResultCallback) {
        infoLog("requestGroupPendingInvitationCancellation ");
        if (checkInvalidFeatureIdAndAgentVersion()) {
            return -7;
        }
        if (getAppId() == null) {
            infoLog("app id is null ");
            return -1;
        }
        IGroupRequestResultCallback.Stub stub = new IGroupRequestResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.group.GroupApi.17
            @Override // com.samsung.android.sdk.mobileservice.social.group.IGroupRequestResultCallback
            public void onFailure(long j, String str3) {
                GroupApi groupApi = GroupApi.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestGroupPendingInvitationCancellation onFailure : code=[", "], message=[", str3);
                sbM2225p.append("] ");
                groupApi.infoLog(sbM2225p.toString());
                if (GroupApi.this.getSemsAgentVersion() >= 1050000000 || groupResultCallback == null) {
                    return;
                }
                groupResultCallback.onResult(new BooleanResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), str3, Long.toString(j)), false));
            }

            @Override // com.samsung.android.sdk.mobileservice.social.group.IGroupRequestResultCallback
            public void onFailureWithBundle(Bundle bundle) {
                long j = bundle.getLong("error_code");
                String string = bundle.getString("error_message");
                String string2 = bundle.getString("error_string", null);
                GroupApi groupApi = GroupApi.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestGroupPendingInvitationCancellation onFailureWithBundle : code=[", "], message=[", string);
                sbM2225p.append("] ");
                groupApi.infoLog(sbM2225p.toString());
                if (groupResultCallback != null) {
                    groupResultCallback.onResult(new BooleanResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), string, Long.toString(j), string2), false));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.group.IGroupRequestResultCallback
            public void onSuccess() {
                GroupApi.this.infoLog("requestGroupPendingInvitationCancellation onSuccess ");
                GroupResultCallback groupResultCallback2 = groupResultCallback;
                if (groupResultCallback2 != null) {
                    groupResultCallback2.onResult(new BooleanResult(new CommonResultStatus(1), true));
                }
            }
        };
        try {
            if (this.mFeatureId != 501) {
                getSocialService().requestGroupPendingInvitationCancellation(getAppId(), str, str2, stub);
                return 1;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("featureId", this.mFeatureId);
            bundle.putString("appId", getAppId());
            bundle.putString("groupId", str);
            bundle.putString("memberGuid", str2);
            getSocialService().requestGroupPendingInvitationCancellationWithData(bundle, stub);
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
    public int requestGroupUpdate(String str, GroupRequest groupRequest, final GroupResultCallback<GroupResult> groupResultCallback) {
        infoLog("requestGroupUpdate ");
        if (!isSupportedSemsAgentVersionMoreThan(1000000000)) {
            return -7;
        }
        if (this.mFeatureId != -1) {
            infoLog("requestGroupUpdate is not supported in " + this.mFeatureId);
            return -1;
        }
        if (getAppId() == null) {
            infoLog("app id is null ");
            return -1;
        }
        Bundle bundle = new Bundle();
        bundle.putString("group_name", groupRequest.getGroupName());
        bundle.putString("mime_type", groupRequest.getMimeType());
        if (groupRequest.getCoverImageUri() != null) {
            bundle.putString("cover_thumbnail_uri", groupRequest.getCoverImageUri().toString());
        }
        try {
            getSocialService().requestGroupUpdate(getAppId(), str, bundle, new IGroupResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.group.GroupApi.8
                @Override // com.samsung.android.sdk.mobileservice.social.group.IGroupResultCallback
                public void onFailure(long j, String str2) {
                    GroupApi groupApi = GroupApi.this;
                    StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestGroupUpdate onFailure : code=[", "], message=[", str2);
                    sbM2225p.append("] ");
                    groupApi.infoLog(sbM2225p.toString());
                    if (GroupApi.this.getSemsAgentVersion() >= 1050000000 || groupResultCallback == null) {
                        return;
                    }
                    groupResultCallback.onResult(new GroupResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), str2, Long.toString(j)), null));
                }

                @Override // com.samsung.android.sdk.mobileservice.social.group.IGroupResultCallback
                public void onFailureWithBundle(Bundle bundle2) {
                    long j = bundle2.getLong("error_code");
                    String string = bundle2.getString("error_message");
                    String string2 = bundle2.getString("error_string", null);
                    GroupApi groupApi = GroupApi.this;
                    StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestGroupUpdate onFailureWithBundle : code=[", "], message=[", string);
                    sbM2225p.append("] ");
                    groupApi.infoLog(sbM2225p.toString());
                    if (groupResultCallback != null) {
                        groupResultCallback.onResult(new GroupResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), string, Long.toString(j), string2), null));
                    }
                }

                @Override // com.samsung.android.sdk.mobileservice.social.group.IGroupResultCallback
                public void onSuccess(Bundle bundle2) {
                    GroupApi.this.infoLog("requestGroupUpdate onSuccess ");
                    GroupResultCallback groupResultCallback2 = groupResultCallback;
                    if (groupResultCallback2 != null) {
                        groupResultCallback2.onResult(new GroupResult(new CommonResultStatus(1), GroupApi.this.bundleToGroup(bundle2)));
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

    public int requestInvitationLinkCreation(String str, final GroupResultCallback<InvitationLinkResult> groupResultCallback) {
        infoLog("requestInvitationLinkCreation ");
        if (getAppId() == null) {
            infoLog("app id is null ");
            return -1;
        }
        if (!isSupportedSemsAgentVersionBetween(CommonConstants.SupportedApiMinVersion.VERSION_10_8_9, CommonConstants.SupportedApiMinVersion.VERSION_11_0) && !isSupportedSemsAgentVersionMoreThan(CommonConstants.SupportedApiMinVersion.VERSION_13_1_10)) {
            infoLog(getAppId() + " with " + this.mFeatureId + " is not supported in this agent version");
            return -7;
        }
        IGroupResultCallback.Stub stub = new IGroupResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.group.GroupApi.23
            @Override // com.samsung.android.sdk.mobileservice.social.group.IGroupResultCallback
            public void onFailure(long j, String str2) {
                GroupApi groupApi = GroupApi.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestInvitationLinkCreation onFailure : code=[", "], message=[", str2);
                sbM2225p.append("] ");
                groupApi.infoLog(sbM2225p.toString());
                if (groupResultCallback != null) {
                    groupResultCallback.onResult(new InvitationLinkResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), str2, Long.toString(j)), null));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.group.IGroupResultCallback
            public void onFailureWithBundle(Bundle bundle) {
                long j = bundle.getLong("error_code");
                String string = bundle.getString("error_message");
                String string2 = bundle.getString("error_string", null);
                GroupApi groupApi = GroupApi.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestInvitationLinkCreation onFailureWithBundle : code=[", "], message=[", string);
                sbM2225p.append("] ");
                groupApi.infoLog(sbM2225p.toString());
                if (groupResultCallback != null) {
                    groupResultCallback.onResult(new InvitationLinkResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), string, Long.toString(j), string2), null));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.group.IGroupResultCallback
            public void onSuccess(Bundle bundle) {
                GroupApi.this.infoLog("requestInvitationLinkCreation onSuccess ");
                GroupResultCallback groupResultCallback2 = groupResultCallback;
                if (groupResultCallback2 != null) {
                    groupResultCallback2.onResult(new InvitationLinkResult(new CommonResultStatus(1), GroupApi.this.bundleToInvitationLink(bundle)));
                }
            }
        };
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("featureId", this.mFeatureId);
            bundle.putString("appId", getAppId());
            bundle.putString("groupId", str);
            getSocialService().requestInvitationLinkCreation(bundle, stub);
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

    public int requestInvitationLinkDeletion(String str, String str2, final GroupResultCallback<BooleanResult> groupResultCallback) {
        infoLog("requestInvitationLinkDeletion ");
        if (getAppId() == null) {
            infoLog("app id is null ");
            return -1;
        }
        if (!isSupportedSemsAgentVersionBetween(CommonConstants.SupportedApiMinVersion.VERSION_10_8_9, CommonConstants.SupportedApiMinVersion.VERSION_11_0) && !isSupportedSemsAgentVersionMoreThan(CommonConstants.SupportedApiMinVersion.VERSION_13_1_10)) {
            infoLog(getAppId() + " with " + this.mFeatureId + " is not supported in this agent version");
            return -7;
        }
        IGroupResultCallback.Stub stub = new IGroupResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.group.GroupApi.24
            @Override // com.samsung.android.sdk.mobileservice.social.group.IGroupResultCallback
            public void onFailure(long j, String str3) {
                GroupApi groupApi = GroupApi.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestInvitationLinkDeletion onFailure : code=[", "], message=[", str3);
                sbM2225p.append("] ");
                groupApi.infoLog(sbM2225p.toString());
                if (groupResultCallback != null) {
                    groupResultCallback.onResult(new BooleanResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), str3, Long.toString(j)), false));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.group.IGroupResultCallback
            public void onFailureWithBundle(Bundle bundle) {
                long j = bundle.getLong("error_code");
                String string = bundle.getString("error_message");
                String string2 = bundle.getString("error_string", null);
                GroupApi groupApi = GroupApi.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestInvitationLinkDeletion onFailureWithBundle : code=[", "], message=[", string);
                sbM2225p.append("] ");
                groupApi.infoLog(sbM2225p.toString());
                if (groupResultCallback != null) {
                    groupResultCallback.onResult(new BooleanResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), string, Long.toString(j), string2), false));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.group.IGroupResultCallback
            public void onSuccess(Bundle bundle) {
                GroupApi.this.infoLog("requestInvitationLinkDeletion onSuccess ");
                GroupResultCallback groupResultCallback2 = groupResultCallback;
                if (groupResultCallback2 != null) {
                    groupResultCallback2.onResult(new BooleanResult(new CommonResultStatus(1), true));
                }
            }
        };
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("featureId", this.mFeatureId);
            bundle.putString("appId", getAppId());
            bundle.putString("groupId", str);
            bundle.putString(BundleKey.INVITATION_LINK_URL, str2);
            getSocialService().requestInvitationLinkDeletion(bundle, stub);
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

    public int requestLeaderAssignment(String str, String str2, final GroupResultCallback<GroupResult> groupResultCallback) {
        infoLog("requestLeaderAssignment ");
        if (checkInvalidFeatureIdAndAgentVersion()) {
            return -7;
        }
        if (getAppId() == null) {
            infoLog("app id is null ");
            return -1;
        }
        IGroupResultCallback.Stub stub = new IGroupResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.group.GroupApi.18
            @Override // com.samsung.android.sdk.mobileservice.social.group.IGroupResultCallback
            public void onFailure(long j, String str3) {
                GroupApi groupApi = GroupApi.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestLeaderAssignment onFailure : code=[", "], message=[", str3);
                sbM2225p.append("] ");
                groupApi.infoLog(sbM2225p.toString());
                if (groupResultCallback != null) {
                    groupResultCallback.onResult(new GroupResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), str3, Long.toString(j)), null));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.group.IGroupResultCallback
            public void onFailureWithBundle(Bundle bundle) {
                long j = bundle.getLong("error_code");
                String string = bundle.getString("error_message");
                String string2 = bundle.getString("error_string", null);
                GroupApi groupApi = GroupApi.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestLeaderAssignment onFailureWithBundle : code=[", "], message=[", string);
                sbM2225p.append("] ");
                groupApi.infoLog(sbM2225p.toString());
                if (groupResultCallback != null) {
                    groupResultCallback.onResult(new GroupResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), string, Long.toString(j), string2), null));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.group.IGroupResultCallback
            public void onSuccess(Bundle bundle) {
                GroupApi.this.infoLog("requestLeaderAssignment onSuccess ");
                GroupResultCallback groupResultCallback2 = groupResultCallback;
                if (groupResultCallback2 != null) {
                    groupResultCallback2.onResult(new GroupResult(new CommonResultStatus(1), GroupApi.this.bundleToGroup(bundle)));
                }
            }
        };
        try {
            if (this.mFeatureId != 501) {
                getSocialService().requestDelegateAuthorityOfOwner(getAppId(), str, str2, stub);
                return 1;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("featureId", this.mFeatureId);
            bundle.putString("appId", getAppId());
            bundle.putString("groupId", str);
            bundle.putString("memberGuid", str2);
            getSocialService().requestDelegateAuthorityOfOwnerWithData(bundle, stub);
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

    public int requestLeave(String str, final GroupResultCallback<BooleanResult> groupResultCallback) {
        infoLog("requestGroupMemberRemoval ");
        if (!isSupportedSemsAgentVersionMoreThan(1000000000) || checkInvalidFeatureIdAndAgentVersion()) {
            return -7;
        }
        if (getAppId() == null) {
            infoLog("app id is null ");
            return -1;
        }
        IGroupRequestResultCallback.Stub stub = new IGroupRequestResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.group.GroupApi.16
            @Override // com.samsung.android.sdk.mobileservice.social.group.IGroupRequestResultCallback
            public void onFailure(long j, String str2) {
                GroupApi groupApi = GroupApi.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestGroupMemberRemoval onFailure : code=[", "], message=[", str2);
                sbM2225p.append("] ");
                groupApi.infoLog(sbM2225p.toString());
                if (GroupApi.this.getSemsAgentVersion() >= 1050000000 || groupResultCallback == null) {
                    return;
                }
                groupResultCallback.onResult(new BooleanResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), str2, Long.toString(j)), false));
            }

            @Override // com.samsung.android.sdk.mobileservice.social.group.IGroupRequestResultCallback
            public void onFailureWithBundle(Bundle bundle) {
                long j = bundle.getLong("error_code");
                String string = bundle.getString("error_message");
                String string2 = bundle.getString("error_string", null);
                GroupApi groupApi = GroupApi.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestGroupMemberRemoval onFailureWithBundle : code=[", "], message=[", string);
                sbM2225p.append("] ");
                groupApi.infoLog(sbM2225p.toString());
                if (groupResultCallback != null) {
                    groupResultCallback.onResult(new BooleanResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), string, Long.toString(j), string2), false));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.group.IGroupRequestResultCallback
            public void onSuccess() {
                GroupApi.this.infoLog("requestGroupMemberRemoval onSuccess ");
                GroupResultCallback groupResultCallback2 = groupResultCallback;
                if (groupResultCallback2 != null) {
                    groupResultCallback2.onResult(new BooleanResult(new CommonResultStatus(1), true));
                }
            }
        };
        try {
            if (this.mFeatureId != 501) {
                getSocialService().requestLeave(getAppId(), str, stub);
                return 1;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("featureId", this.mFeatureId);
            bundle.putString("appId", getAppId());
            bundle.putString("groupId", str);
            getSocialService().requestLeaveWithData(bundle, stub);
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

    public int requestMyInvitationList(final GroupResultCallback<GroupInvitationListResult> groupResultCallback) {
        infoLog("requestGroupWithInvitationList ");
        if (!isSupportedSemsAgentVersionMoreThan(1000000000) || checkInvalidFeatureIdAndAgentVersion()) {
            return -7;
        }
        if (getAppId() == null) {
            infoLog("app id is null ");
            return -1;
        }
        IGroupListWithInvitationResultCallback.Stub stub = new IGroupListWithInvitationResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.group.GroupApi.14
            @Override // com.samsung.android.sdk.mobileservice.social.group.IGroupListWithInvitationResultCallback
            public void onFailure(long j, String str) {
                GroupApi groupApi = GroupApi.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestGroupWithInvitationList onFailure : code=[", "], message=[", str);
                sbM2225p.append("] ");
                groupApi.infoLog(sbM2225p.toString());
                if (GroupApi.this.getSemsAgentVersion() >= 1050000000 || groupResultCallback == null) {
                    return;
                }
                groupResultCallback.onResult(new GroupInvitationListResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), str, Long.toString(j)), null));
            }

            @Override // com.samsung.android.sdk.mobileservice.social.group.IGroupListWithInvitationResultCallback
            public void onFailureWithBundle(Bundle bundle) {
                long j = bundle.getLong("error_code");
                String string = bundle.getString("error_message");
                String string2 = bundle.getString("error_string", null);
                GroupApi groupApi = GroupApi.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestGroupWithInvitationList onFailureWithBundle : code=[", "], message=[", string);
                sbM2225p.append("] ");
                groupApi.infoLog(sbM2225p.toString());
                if (groupResultCallback != null) {
                    groupResultCallback.onResult(new GroupInvitationListResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), string, Long.toString(j), string2), null));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.group.IGroupListWithInvitationResultCallback
            public void onSuccess(List<Bundle> list) {
                GroupApi.this.infoLog("requestGroupWithInvitationList onSuccess ");
                if (groupResultCallback != null) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<Bundle> it = list.iterator();
                    while (it.hasNext()) {
                        Bundle next = it.next();
                        String string = next.getString("group_id", null);
                        String string2 = next.getString("group_name", null);
                        GroupApi.this.debugLog(AbstractC0541b.m775q("- groupId=[", string, "], groupName=[", string2, "] "));
                        String string3 = next.getString("group_cover_thumbnail_url", null);
                        String string4 = next.getString("group_cover_thumbnail_uri", null);
                        String string5 = next.getString("group_cover_thumbnail_content_uri", null);
                        String string6 = next.getString("invitation_message", null);
                        String string7 = next.getString(GroupInvitationContract.Invitation.REQUESTER_ID, null);
                        String string8 = next.getString(GroupInvitationContract.Invitation.REQUESTER_NAME, null);
                        String string9 = next.getString("requesterImageUrl", null);
                        String string10 = next.getString("requesterImageFileUri", null);
                        String string11 = next.getString("requesterImageContentUri", null);
                        long j = next.getLong(GroupInvitationContract.Invitation.REQUESTED_TIME, 0L);
                        long j2 = next.getLong("expired_time", 0L);
                        Iterator<Bundle> it2 = it;
                        GroupApi.this.debugLog("- expiredTime=[" + j2 + "]");
                        arrayList.add(new GroupInvitationListResult.GroupInvitation(string, string2, string3, string4 != null ? Uri.parse(string4) : null, string5 != null ? Uri.parse(string5) : null, string6, string7, string8, string9, string10 != null ? Uri.parse(string10) : null, string11 != null ? Uri.parse(string11) : null, j, j2));
                        it = it2;
                    }
                    groupResultCallback.onResult(new GroupInvitationListResult(new CommonResultStatus(1), arrayList));
                }
            }
        };
        try {
            if (this.mFeatureId != 501) {
                getSocialService().requestGroupWithInvitationList(getAppId(), stub);
                return 1;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("featureId", this.mFeatureId);
            bundle.putString("appId", getAppId());
            getSocialService().requestGroupWithInvitationListWithData(bundle, stub);
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

    public int requestSync(final GroupSyncResultCallback groupSyncResultCallback) {
        infoLog("requestSync ");
        if (!isSupportedSemsAgentVersionMoreThan(CommonConstants.SupportedApiMinVersion.VERSION_4_1) || checkInvalidFeatureIdAndAgentVersion()) {
            return -7;
        }
        if (getAppId() == null) {
            infoLog("app id is null ");
            return -1;
        }
        IGroupSyncResultCallback.Stub stub = new IGroupSyncResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.group.GroupApi.4
            @Override // com.samsung.android.sdk.mobileservice.social.group.IGroupSyncResultCallback
            public void onFailure(long j, String str) {
                GroupApi groupApi = GroupApi.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestSync onFailure : code=[", "], message=[", str);
                sbM2225p.append("] ");
                groupApi.infoLog(sbM2225p.toString());
                if (GroupApi.this.getSemsAgentVersion() >= 1050000000 || groupSyncResultCallback == null) {
                    return;
                }
                groupSyncResultCallback.onResult(new BooleanResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), str, Long.toString(j)), false));
            }

            @Override // com.samsung.android.sdk.mobileservice.social.group.IGroupSyncResultCallback
            public void onFailureWithBundle(Bundle bundle) {
                long j = bundle.getLong("error_code");
                String string = bundle.getString("error_message");
                String string2 = bundle.getString("error_string", null);
                GroupApi groupApi = GroupApi.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestSync onFailureWithBundle : code=[", "], message=[", string);
                sbM2225p.append("] ");
                groupApi.infoLog(sbM2225p.toString());
                if (groupSyncResultCallback != null) {
                    groupSyncResultCallback.onResult(new BooleanResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), string, Long.toString(j), string2), false));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.group.IGroupSyncResultCallback
            public void onSuccess() {
                GroupApi.this.infoLog("requestSync onSuccess ");
                GroupSyncResultCallback groupSyncResultCallback2 = groupSyncResultCallback;
                if (groupSyncResultCallback2 != null) {
                    groupSyncResultCallback2.onResult(new BooleanResult(new CommonResultStatus(1), true));
                }
            }
        };
        try {
            if (this.mFeatureId != 501) {
                getSocialService().requestGroupSync(getAppId(), stub);
                return 1;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("featureId", this.mFeatureId);
            bundle.putString("appId", getAppId());
            getSocialService().requestGroupSyncWithData(bundle, stub);
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

    public int requestSyncWithoutImage(final GroupSyncResultCallback groupSyncResultCallback) {
        infoLog("requestSyncWithoutImage ");
        if (!isSupportedSemsAgentVersionMoreThan(CommonConstants.SupportedApiMinVersion.VERSION_10_5) || checkInvalidFeatureIdAndAgentVersion()) {
            return -7;
        }
        if (getAppId() == null) {
            infoLog("app id is null ");
            return -1;
        }
        IGroupSyncResultCallback.Stub stub = new IGroupSyncResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.group.GroupApi.5
            @Override // com.samsung.android.sdk.mobileservice.social.group.IGroupSyncResultCallback
            public void onFailure(long j, String str) {
                GroupApi groupApi = GroupApi.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestSyncWithoutImage onFailure : code=[", "], message=[", str);
                sbM2225p.append("] ");
                groupApi.infoLog(sbM2225p.toString());
                if (GroupApi.this.getSemsAgentVersion() >= 1050000000 || groupSyncResultCallback == null) {
                    return;
                }
                groupSyncResultCallback.onResult(new BooleanResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), str, Long.toString(j)), false));
            }

            @Override // com.samsung.android.sdk.mobileservice.social.group.IGroupSyncResultCallback
            public void onFailureWithBundle(Bundle bundle) {
                long j = bundle.getLong("error_code");
                String string = bundle.getString("error_message");
                String string2 = bundle.getString("error_string", null);
                GroupApi groupApi = GroupApi.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestSyncWithoutImage onFailureWithBundle : code=[", "], message=[", string);
                sbM2225p.append("] ");
                groupApi.infoLog(sbM2225p.toString());
                if (groupSyncResultCallback != null) {
                    groupSyncResultCallback.onResult(new BooleanResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), string, Long.toString(j), string2), false));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.group.IGroupSyncResultCallback
            public void onSuccess() {
                GroupApi.this.infoLog("requestSyncWithoutImage onSuccess ");
                GroupSyncResultCallback groupSyncResultCallback2 = groupSyncResultCallback;
                if (groupSyncResultCallback2 != null) {
                    groupSyncResultCallback2.onResult(new BooleanResult(new CommonResultStatus(1), true));
                }
            }
        };
        try {
            if (this.mFeatureId != 501) {
                getSocialService().requestGroupSyncWithoutImage(getAppId(), stub);
                return 1;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("featureId", this.mFeatureId);
            bundle.putString("appId", getAppId());
            getSocialService().requestGroupSyncWithoutImageWithData(bundle, stub);
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

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class InvitationRequest {

        @Deprecated
        public static final int ID_TYPE_ACCOUNT_ID = 3;

        @Deprecated
        public static final int ID_TYPE_DUID = 2;

        @Deprecated
        public static final int ID_TYPE_GUID = 0;

        @Deprecated
        public static final int ID_TYPE_MSISDN = 1;
        private int mIdType;
        private List<String> mIds;
        private String mInvitationMessage;
        private List<String> mOptionalIds;

        public InvitationRequest(String str, int i, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
            this.mInvitationMessage = str;
            this.mIdType = i;
            this.mIds = arrayList;
            this.mOptionalIds = arrayList2;
        }

        @Deprecated
        public int getIdType() {
            return this.mIdType;
        }

        public List<String> getIds() {
            return this.mIds;
        }

        public String getInvitationMessage() {
            return this.mInvitationMessage;
        }

        public List<String> getOptionalIds() {
            return this.mOptionalIds;
        }

        public InvitationRequest(String str, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
            this.mInvitationMessage = str;
            this.mIdType = 0;
            this.mIds = arrayList;
            this.mOptionalIds = arrayList2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class GroupRequest {
        public static final String GROUP_TYPE_AUTO_HOTSPOT = "AHSP";

        @Deprecated
        public static final String GROUP_TYPE_FAMILY = "FMLY";

        @Deprecated
        public static final String GROUP_TYPE_GENERAL = "GNRL";
        public static final String GROUP_TYPE_LOCAL = "UNM1";
        private Uri mCoverImageUri;
        private GroupAuthority.AuthorityType mDefaultMemberAuthority;
        private String mGroupName;
        private String mGroupType;
        private String mMimeType;
        private boolean mUseInvitationLink;

        @Deprecated
        public GroupRequest(String str, String str2, Uri uri, String str3) {
            this.mUseInvitationLink = false;
            this.mDefaultMemberAuthority = GroupAuthority.AuthorityType.INVALID;
            this.mGroupName = str;
            this.mGroupType = str2;
            this.mCoverImageUri = uri;
            this.mMimeType = str3;
        }

        @Deprecated
        public Uri getCoverImageUri() {
            return this.mCoverImageUri;
        }

        public GroupAuthority.AuthorityType getDefaultMemberAuthorityType() {
            return this.mDefaultMemberAuthority;
        }

        public String getGroupName() {
            return this.mGroupName;
        }

        public String getGroupType() {
            return this.mGroupType;
        }

        public String getMimeType() {
            return this.mMimeType;
        }

        public boolean getUseInvitationLink() {
            return this.mUseInvitationLink;
        }

        public GroupRequest(String str, String str2) {
            this.mUseInvitationLink = false;
            this.mDefaultMemberAuthority = GroupAuthority.AuthorityType.INVALID;
            this.mGroupName = str;
            this.mGroupType = str2;
        }

        public GroupRequest(String str, String str2, boolean z, GroupAuthority.AuthorityType authorityType) {
            this.mUseInvitationLink = false;
            GroupAuthority.AuthorityType authorityType2 = GroupAuthority.AuthorityType.INVALID;
            this.mGroupName = str;
            this.mGroupType = str2;
            this.mUseInvitationLink = z;
            this.mDefaultMemberAuthority = authorityType;
        }

        public GroupRequest(String str, String str2, boolean z) {
            this.mUseInvitationLink = false;
            this.mDefaultMemberAuthority = GroupAuthority.AuthorityType.INVALID;
            this.mGroupName = str;
            this.mGroupType = str2;
            this.mUseInvitationLink = z;
        }

        @Deprecated
        public GroupRequest(String str, Uri uri, String str2) {
            this.mUseInvitationLink = false;
            this.mDefaultMemberAuthority = GroupAuthority.AuthorityType.INVALID;
            this.mGroupName = str;
            this.mCoverImageUri = uri;
            this.mMimeType = str2;
        }

        public GroupRequest(String str) {
            this.mUseInvitationLink = false;
            this.mDefaultMemberAuthority = GroupAuthority.AuthorityType.INVALID;
            this.mGroupName = str;
        }
    }

    public GroupApi(SeMobileServiceSession seMobileServiceSession, int i) throws NotAuthorizedException, NotSupportedApiException {
        super(seMobileServiceSession, "GroupApi");
        this.mFeatureId = -1;
        this.featureIdSet = new HashSet<>(Arrays.asList(4, 32, 32, 101, 102, 103, 104, 107, 501));
        checkAuthorized(0, 2);
        if (isValidFeatureId(i)) {
            this.mFeatureId = i;
            return;
        }
        throw new NotSupportedApiException(AbstractC2322a.m1615e(i, " is not valid"));
    }

    public int requestGroupCreation(GroupRequest groupRequest, final GroupResultCallback<GroupInvitationResult> groupResultCallback) {
        infoLog("requestGroupCreation only for invitation link");
        if (!isSupportedSemsAgentVersionBetween(CommonConstants.SupportedApiMinVersion.VERSION_10_8_9, CommonConstants.SupportedApiMinVersion.VERSION_11_0) && !isSupportedSemsAgentVersionMoreThan(CommonConstants.SupportedApiMinVersion.VERSION_13_1_10)) {
            infoLog(getAppId() + " with " + this.mFeatureId + " is not supported in this agent version");
            return -7;
        }
        if (getAppId() == null) {
            infoLog("app id is null");
            return -1;
        }
        Bundle bundle = new Bundle();
        bundle.putString("group_name", groupRequest.getGroupName());
        bundle.putString(BundleKey.GROUP_TYPE, groupRequest.getGroupType());
        bundle.putString("mime_type", groupRequest.getMimeType());
        bundle.putBoolean(BundleKey.USE_INVITATION_LINK, groupRequest.getUseInvitationLink());
        if (groupRequest.getDefaultMemberAuthorityType() != GroupAuthority.AuthorityType.INVALID) {
            bundle.putString(BundleKey.DEFAULT_MEMBER_AUTHORITY, groupRequest.getDefaultMemberAuthorityType().getAuthority());
        }
        IGroupInvitationResultCallback.Stub stub = new IGroupInvitationResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.group.GroupApi.7
            @Override // com.samsung.android.sdk.mobileservice.social.group.IGroupInvitationResultCallback
            public void onFailure(long j, String str) {
                GroupApi groupApi = GroupApi.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestGroupCreation only for invitation link is onFailure : code=[", "], message=[", str);
                sbM2225p.append("] ");
                groupApi.infoLog(sbM2225p.toString());
            }

            @Override // com.samsung.android.sdk.mobileservice.social.group.IGroupInvitationResultCallback
            public void onFailureWithBundle(Bundle bundle2) {
                if (groupResultCallback == null) {
                    GroupApi.this.infoLog("callback is null, requestGroupCreation only for invitation link is onFailureWithBundle ");
                    return;
                }
                long j = bundle2.getLong("error_code");
                String string = bundle2.getString("error_message");
                String string2 = bundle2.getString("error_string", null);
                GroupApi groupApi = GroupApi.this;
                StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "requestGroupCreation only for invitation link is onFailureWithBundle : code=[", "], message=[", string);
                sbM2225p.append("] ");
                groupApi.infoLog(sbM2225p.toString());
                groupResultCallback.onResult(new GroupInvitationResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(j), string, Long.toString(j), string2), null, null, null));
            }

            @Override // com.samsung.android.sdk.mobileservice.social.group.IGroupInvitationResultCallback
            public void onSuccess(Bundle bundle2, List<Bundle> list) {
                if (groupResultCallback == null) {
                    GroupApi.this.infoLog("callback is null, requestGroupCreation only for invitation link is onSuccess ");
                    return;
                }
                GroupApi.this.infoLog("requestGroupCreation only for invitation link is onSuccess ");
                GroupApi.this.debugLog(AbstractC0541b.m775q("- groupId=[", bundle2.getString("group_id", null), "], groupName=[", bundle2.getString("group_name", null), "] "));
                String string = bundle2.getString("error_string", "");
                groupResultCallback.onResult(new GroupInvitationResult(new CommonResultStatus(1), GroupApi.this.bundleToGroup(bundle2), new ArrayList(0), string));
            }
        };
        try {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("featureId", this.mFeatureId);
            bundle2.putString("appId", getAppId());
            getSocialService().requestGroupCreationWithData(bundle2, bundle, new Bundle(), stub);
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
