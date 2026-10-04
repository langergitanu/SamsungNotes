package com.samsung.android.app.notes.sync.contentsharing.sesdb;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.mobileservice.social.group.provider.GroupContract;
import com.samsung.android.sdk.mobileservice.social.group.provider.GroupMemberContract;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.CoeditResolverContract;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import java.util.ArrayList;
import java.util.List;
import p207n1.C13541h;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SesCoeditGroupReadResolver extends SesGroupBaseReadResolver {
    private static final String TAG = "SesCoeditGroupReadResolver";
    public static final String THUMBNAIL_CONTENT_URI = "thumbnailContentUri";
    private static SesCoeditGroupReadResolver mInstance;

    private SesCoeditGroupReadResolver() {
        this.mContentUri = getGroupContentUri();
    }

    public static C6689c getAllGroupLiveData(Context context) {
        return new C6689c(context, getInstance().getGroupContentUri(), true);
    }

    public static C6690d getComposerMemberInfoListLiveData(Context context, String str) {
        return new C6690d(context, str);
    }

    public static synchronized SesCoeditGroupReadResolver getInstance() {
        try {
            if (mInstance == null) {
                mInstance = new SesCoeditGroupReadResolver();
            }
        } catch (Throwable th) {
            throw th;
        }
        return mInstance;
    }

    public static C6691e getMemberListData(Context context, String str) {
        return new C6691e(context, str);
    }

    public String getAuthorityByMemberId(String str, String str2) {
        Uri memberContentUri = getMemberContentUri(str2);
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        String string = null;
        try {
            try {
                Cursor cursorQuery = this.mContext.getContentResolver().query(memberContentUri, new String[]{"id", "authority"}, "groupId=?", new String[]{str}, null);
                if (cursorQuery != null) {
                    while (cursorQuery.moveToNext()) {
                        try {
                            string = cursorQuery.getString(cursorQuery.getColumnIndex("authority"));
                        } finally {
                        }
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                Binder.restoreCallingIdentity(jClearCallingIdentity);
                return string;
            } catch (Exception e) {
                Debugger.m8609e(TAG, "getAuthorityByMemberId() : " + e.toString());
                Binder.restoreCallingIdentity(jClearCallingIdentity);
                return null;
            }
        } catch (Throwable th) {
            Binder.restoreCallingIdentity(jClearCallingIdentity);
            throw th;
        }
    }

    @Override // com.samsung.android.app.notes.sync.contentsharing.sesdb.SesGroupBaseReadResolver
    public Uri getGroupContentUri() {
        return GroupContract.Group.CONTENT_URI.buildUpon().appendPath("app_id").appendPath(CommonUtils.getNewNotesServiceId()).appendPath("feature_id").appendPath(String.valueOf(501)).appendPath("group").build();
    }

    @Override // com.samsung.android.app.notes.sync.contentsharing.sesdb.SesGroupBaseReadResolver
    public Uri getGroupMemberContentUri() {
        return GroupMemberContract.GroupMember.CONTENT_URI.buildUpon().appendPath("app_id").appendPath(CommonUtils.getNewNotesServiceId()).appendPath("feature_id").appendPath(String.valueOf(501)).appendPath("group").build();
    }

    public String getLeaderId(String str) {
        Uri groupContentUri = getGroupContentUri(str);
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        String string = null;
        try {
            try {
                Cursor cursorQuery = this.mContext.getContentResolver().query(groupContentUri, new String[]{GroupContract.Group.LEADER_ID}, null, null, null);
                if (cursorQuery != null) {
                    while (cursorQuery.moveToNext()) {
                        try {
                            string = cursorQuery.getString(cursorQuery.getColumnIndex(GroupContract.Group.LEADER_ID));
                        } finally {
                        }
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                Binder.restoreCallingIdentity(jClearCallingIdentity);
                return string;
            } catch (Exception e) {
                Debugger.m8609e(TAG, "getLeaderId() : " + e.toString());
                Binder.restoreCallingIdentity(jClearCallingIdentity);
                return null;
            }
        } catch (Throwable th) {
            Binder.restoreCallingIdentity(jClearCallingIdentity);
            throw th;
        }
    }

    public Uri getMemberContentUri(String str) {
        return GroupMemberContract.GroupMember.CONTENT_URI.buildUpon().appendPath("app_id").appendPath(CommonUtils.getNewNotesServiceId()).appendPath("feature_id").appendPath(String.valueOf(501)).appendPath("member").appendPath(str).build();
    }

    public List<CoeditResolverContract.MemberInfo> getMemberInfoList(String str) {
        return getMemberInfoList(str, "status = ?", new String[]{String.valueOf(2)});
    }

    public List<CoeditResolverContract.MemberInfo> getMemberInfoListIncludePending(String str) {
        return getMemberInfoList(str, null, null);
    }

    public boolean isCurrentUserByMemberId(@NonNull String str) {
        return str.equals(C13541h.m14287e().m14293g());
    }

    public boolean isGroupLeaderByMemberId(@NonNull String str, @NonNull String str2) {
        return str2.equals(getLeaderId(str));
    }

    @Override // com.samsung.android.app.notes.sync.contentsharing.sesdb.SesGroupBaseReadResolver
    public Uri getGroupContentUri(String str) {
        return getGroupContentUri().buildUpon().appendPath(str).build();
    }

    @Override // com.samsung.android.app.notes.sync.contentsharing.sesdb.SesGroupBaseReadResolver
    public Uri getGroupMemberContentUri(String str) {
        return getGroupMemberContentUri().buildUpon().appendPath(str).build();
    }

    public Uri getMemberContentUri() {
        return GroupMemberContract.GroupMember.CONTENT_URI.buildUpon().appendPath("app_id").appendPath(CommonUtils.getNewNotesServiceId()).appendPath("feature_id").appendPath(String.valueOf(501)).appendPath("member").build();
    }

    public List<CoeditResolverContract.MemberInfo> getMemberInfoList(String str, String str2, String[] strArr) {
        Uri groupMemberContentUri = getGroupMemberContentUri(str);
        ArrayList arrayList = new ArrayList();
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        try {
            Cursor cursorQuery = this.mContext.getContentResolver().query(groupMemberContentUri, new String[]{"id", "name", THUMBNAIL_CONTENT_URI, "authority", "status", "expiredTime", "optionalId"}, str2, strArr, null);
            try {
                if (cursorQuery == null) {
                    Debugger.m8609e(TAG, "getMemberInfoList() : No cursor!");
                } else {
                    while (cursorQuery.moveToNext()) {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("name"));
                        arrayList.add(new CoeditResolverContract.MemberInfo(cursorQuery.getString(cursorQuery.getColumnIndex("id")), string, cursorQuery.getString(cursorQuery.getColumnIndex("authority")), cursorQuery.getString(cursorQuery.getColumnIndex(THUMBNAIL_CONTENT_URI)), cursorQuery.getLong(cursorQuery.getColumnIndex("expiredTime")), cursorQuery.getInt(cursorQuery.getColumnIndex("status")), cursorQuery.getString(cursorQuery.getColumnIndex("optionalId"))));
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return arrayList;
            } finally {
            }
        } catch (Exception e) {
            Debugger.m8609e(TAG, "getMemberInfoList() : " + e.toString());
            return arrayList;
        } finally {
            Binder.restoreCallingIdentity(jClearCallingIdentity);
        }
    }
}
