package com.samsung.android.app.notes.sync.contentsharing.sesdb;

import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import androidx.annotation.Nullable;
import com.samsung.android.sdk.mobileservice.social.group.Group;
import com.samsung.android.sdk.mobileservice.social.group.provider.GroupContract;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.util.TextUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class SesGroupBaseReadResolver extends SesReadResolverBase {
    private static final String FAMILY_TYPE = "FMLY";
    private static final String GENERAL_TYPE = "GNRL";
    private static final String LOCAL_TYPE = "UNM1";
    private static final String TAG = "SesGroupBaseReadResolver";

    public SesGroupBaseReadResolver() {
        this.mContentUri = getGroupContentUri();
    }

    private boolean isGroupType(String str, String str2) {
        return str2 != null && str2.equals(getGroupType(str));
    }

    @Nullable
    private List<Group> parseGroupList(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        if (cursor == null || !cursor.moveToFirst()) {
            if (cursor == null) {
                return null;
            }
            cursor.close();
            return null;
        }
        do {
            arrayList.add(new Group(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), null, null, 0L, 0, 0));
        } while (cursor.moveToNext());
        cursor.close();
        return arrayList;
    }

    public ArrayList<String> getGCSGroupMemberIDs(String str) {
        Uri groupMemberContentUri = getGroupMemberContentUri(str);
        ArrayList<String> arrayList = new ArrayList<>();
        String[] strArr = {String.valueOf(2)};
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        try {
            try {
                Cursor cursorQuery = this.mContext.getContentResolver().query(groupMemberContentUri, new String[]{"id"}, "status = ?", strArr, null);
                if (cursorQuery != null) {
                    while (cursorQuery.moveToNext()) {
                        try {
                            arrayList.add(cursorQuery.getString(cursorQuery.getColumnIndex("id")));
                        } finally {
                        }
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                Binder.restoreCallingIdentity(jClearCallingIdentity);
                return arrayList;
            } catch (Exception e) {
                Debugger.m8609e(TAG, "getGCSGroupMemberIDs() : " + e.toString());
                Binder.restoreCallingIdentity(jClearCallingIdentity);
                return arrayList;
            }
        } catch (Throwable th) {
            Binder.restoreCallingIdentity(jClearCallingIdentity);
            throw th;
        }
    }

    public ArrayList<String> getGCSGroupMemberIDsExcludeOwner(String str, String str2) {
        Uri groupMemberContentUri = getGroupMemberContentUri(str);
        ArrayList<String> arrayList = new ArrayList<>();
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        try {
            try {
                Cursor cursorQuery = this.mContext.getContentResolver().query(groupMemberContentUri, new String[]{"id"}, null, null, null);
                if (cursorQuery != null) {
                    while (cursorQuery.moveToNext()) {
                        try {
                            String string = cursorQuery.getString(cursorQuery.getColumnIndex("id"));
                            if (!string.equals(str2)) {
                                arrayList.add(string);
                            }
                        } finally {
                        }
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                Binder.restoreCallingIdentity(jClearCallingIdentity);
                return arrayList;
            } catch (Exception e) {
                Debugger.m8609e(TAG, "getGCSGroupMemberIDs() : " + e.toString());
                Binder.restoreCallingIdentity(jClearCallingIdentity);
                return arrayList;
            }
        } catch (Throwable th) {
            Binder.restoreCallingIdentity(jClearCallingIdentity);
            throw th;
        }
    }

    public abstract Uri getGroupContentUri();

    public abstract Uri getGroupContentUri(String str);

    public int getGroupCount(String str) {
        Uri groupContentUri = getGroupContentUri(str);
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        int i = 0;
        try {
            try {
                Cursor cursorQuery = this.mContext.getContentResolver().query(groupContentUri, new String[]{GroupContract.Group.MEMBERS_COUNT}, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            i = cursorQuery.getInt(cursorQuery.getColumnIndex(GroupContract.Group.MEMBERS_COUNT));
                        }
                    } finally {
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                Binder.restoreCallingIdentity(jClearCallingIdentity);
                return i;
            } catch (Exception e) {
                Debugger.m8609e(TAG, "getGroupCount() : " + e.toString());
                Binder.restoreCallingIdentity(jClearCallingIdentity);
                return 0;
            }
        } catch (Throwable th) {
            Binder.restoreCallingIdentity(jClearCallingIdentity);
            throw th;
        }
    }

    public String getGroupCoverImageUri(String str) {
        Uri groupContentUri = getGroupContentUri(str);
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        String string = null;
        try {
            try {
                Cursor cursorQuery = this.mContext.getContentResolver().query(groupContentUri, new String[]{GroupContract.Group.COVER_THUMBNAIL_CONTENT_URI}, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            string = cursorQuery.getString(cursorQuery.getColumnIndex(GroupContract.Group.COVER_THUMBNAIL_CONTENT_URI));
                        }
                    } finally {
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                Binder.restoreCallingIdentity(jClearCallingIdentity);
                return string;
            } catch (Exception e) {
                Debugger.m8609e(TAG, "getGroupCoverImageUri() : " + e.toString());
                Binder.restoreCallingIdentity(jClearCallingIdentity);
                return null;
            }
        } catch (Throwable th) {
            Binder.restoreCallingIdentity(jClearCallingIdentity);
            throw th;
        }
    }

    @Nullable
    public List<Group> getGroupList() {
        Uri groupContentUri = getGroupContentUri();
        String[] strArr = {"groupId", "groupName", "type", GroupContract.Group.LEADER_ID};
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        try {
            Cursor cursorQuery = this.mContext.getContentResolver().query(groupContentUri, strArr, null, null, null);
            try {
                List<Group> groupList = parseGroupList(cursorQuery);
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return groupList;
            } finally {
            }
        } catch (Exception e) {
            Debugger.m8609e(TAG, "getGroupList() : " + e.toString());
            return null;
        } finally {
            Binder.restoreCallingIdentity(jClearCallingIdentity);
        }
    }

    public abstract Uri getGroupMemberContentUri();

    public abstract Uri getGroupMemberContentUri(String str);

    public String getGroupName(String str) {
        Uri groupContentUri = getGroupContentUri(str);
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        String string = null;
        try {
            try {
                Cursor cursorQuery = this.mContext.getContentResolver().query(groupContentUri, new String[]{"groupName"}, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            string = cursorQuery.getString(cursorQuery.getColumnIndex("groupName"));
                        }
                    } finally {
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                Binder.restoreCallingIdentity(jClearCallingIdentity);
                return string;
            } catch (Exception e) {
                Debugger.m8609e(TAG, "getGroupName() : " + e.toString());
                Binder.restoreCallingIdentity(jClearCallingIdentity);
                return null;
            }
        } catch (Throwable th) {
            Binder.restoreCallingIdentity(jClearCallingIdentity);
            throw th;
        }
    }

    public String getGroupType(String str) {
        Uri groupContentUri = getGroupContentUri(str);
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        String string = null;
        try {
            try {
                Cursor cursorQuery = this.mContext.getContentResolver().query(groupContentUri, new String[]{"type"}, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            string = cursorQuery.getString(cursorQuery.getColumnIndex("type"));
                        }
                    } finally {
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                Binder.restoreCallingIdentity(jClearCallingIdentity);
                return string;
            } catch (Exception e) {
                Debugger.m8609e(TAG, "getGroupType() : " + e.toString());
                Binder.restoreCallingIdentity(jClearCallingIdentity);
                return null;
            }
        } catch (Throwable th) {
            Binder.restoreCallingIdentity(jClearCallingIdentity);
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getMemberThumbnailImageUri(String str, String str2) {
        Uri groupMemberContentUri = getGroupMemberContentUri(str);
        String[] strArr = {str2};
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        try {
            Cursor cursorQuery = this.mContext.getContentResolver().query(groupMemberContentUri, new String[]{SesCoeditGroupReadResolver.THUMBNAIL_CONTENT_URI}, "id = ?", strArr, null);
            if (cursorQuery != null) {
                try {
                    String string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndex(SesCoeditGroupReadResolver.THUMBNAIL_CONTENT_URI)) : null;
                    try {
                        String str3 = TextUtils.isEmpty(string) ? null : string;
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return str3;
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            Throwable th3 = th;
            if (cursorQuery == null) {
                throw th3;
            }
            try {
                cursorQuery.close();
                throw th3;
            } catch (Throwable th4) {
                th3.addSuppressed(th4);
                throw th3;
            }
        } catch (Exception e) {
            Debugger.m8609e(TAG, "getMemberThumbnailImageUri() : " + e.toString());
            return null;
        } finally {
            Binder.restoreCallingIdentity(jClearCallingIdentity);
        }
    }

    public String getUserName(String str, String str2) {
        Uri groupMemberContentUri = getGroupMemberContentUri(str);
        String[] strArr = {str2};
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        String string = null;
        try {
            try {
                Cursor cursorQuery = this.mContext.getContentResolver().query(groupMemberContentUri, new String[]{"name"}, "id = ?", strArr, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            string = cursorQuery.getString(cursorQuery.getColumnIndex("name"));
                        }
                    } finally {
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                Binder.restoreCallingIdentity(jClearCallingIdentity);
                return string;
            } catch (Exception e) {
                Debugger.m8609e(TAG, "getUserName() : " + e.toString());
                Binder.restoreCallingIdentity(jClearCallingIdentity);
                return null;
            }
        } catch (Throwable th) {
            Binder.restoreCallingIdentity(jClearCallingIdentity);
            throw th;
        }
    }

    public boolean isFamilyGroupType(String str) {
        return isGroupType(str, "FMLY");
    }

    public boolean isGeneralGroupType(String str) {
        return isGroupType(str, "GNRL");
    }

    public boolean isLocalGroupType(String str) {
        return isGroupType(str, "UNM1");
    }
}
