package com.samsung.android.app.notes.sync.contentsharing.sesdb;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AbstractC0541b;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.samsung.android.sdk.mobileservice.social.share.SharedItem;
import com.samsung.android.sdk.mobileservice.social.share.Space;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.UserInfo;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import p207n1.C13541h;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SesCoeditShareReadResolver extends SesShareBaseReadResolver {
    protected static final String AUTHORITY_COEDIT_ITEM;
    protected static final String AUTHORITY_COEDIT_SPACE;
    private static final String CONTENT_ITEM_URI;
    public static final String CONTENT_SPACE_URI;
    public static final String CREATOR_ID = "creator";
    public static final String ITEM_REF_ID = "referred_resource_id";
    public static final String STAND_ALONE = "stand_alone";
    static final String StandAloneNoteConstatnt = "Group://Standalone ";
    private static final String TAG = "SesCoeditShareReadResolver";
    private static SesCoeditShareReadResolver mInstance;

    static {
        String str = "com.samsung.android.mobileservice.social.share.space/app_id/" + CommonUtils.getNewNotesServiceId();
        AUTHORITY_COEDIT_SPACE = str;
        String str2 = "com.samsung.android.mobileservice.social.share.item/app_id/" + CommonUtils.getNewNotesServiceId();
        AUTHORITY_COEDIT_ITEM = str2;
        CONTENT_SPACE_URI = AbstractC0541b.m773o(AuthenticationConstants.BrokerContentProvider.CONTENT_SCHEME, str, "/feature_id/501");
        CONTENT_ITEM_URI = AbstractC0541b.m773o(AuthenticationConstants.BrokerContentProvider.CONTENT_SCHEME, str2, "/feature_id/501");
        mInstance = null;
    }

    private SesCoeditShareReadResolver() {
        this.mContentUri = getSharedContentUri();
    }

    public static synchronized SesCoeditShareReadResolver getInstance() {
        try {
            if (mInstance == null) {
                mInstance = new SesCoeditShareReadResolver();
            }
        } catch (Throwable th) {
            throw th;
        }
        return mInstance;
    }

    @NonNull
    private List<Space> parseStandAloneSpaceList(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        if (cursor == null || !cursor.moveToFirst()) {
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        }
        do {
            String string = cursor.getString(0);
            String string2 = cursor.getString(1);
            String string3 = cursor.getString(2);
            String string4 = cursor.getString(3);
            boolean z = cursor.getInt(4) != 0;
            boolean z2 = cursor.getInt(5) != 0;
            long j = cursor.getLong(6);
            Space space = new Space(string4, string, string3);
            space.setTitle(string2);
            space.setOwnedByMe(z);
            space.setStandAlone(z2);
            space.setCreatedTime(j);
            arrayList.add(space);
        } while (cursor.moveToNext());
        cursor.close();
        return arrayList;
    }

    public String getCoeditNoteCreatorId(Context context, String str, String str2) {
        String string = null;
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return null;
        }
        String[] strArr = {"itemId", "creator"};
        Uri sharedItemContentUri = getSharedItemContentUri(str, str2);
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        try {
            try {
                Cursor cursorQuery = context.getContentResolver().query(sharedItemContentUri, strArr, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            string = cursorQuery.getString(cursorQuery.getColumnIndex("creator"));
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
                Debugger.m8609e(TAG, "getCoeditNoteCreatorId() : " + e.getMessage());
                Binder.restoreCallingIdentity(jClearCallingIdentity);
                return null;
            }
        } catch (Throwable th) {
            Binder.restoreCallingIdentity(jClearCallingIdentity);
            throw th;
        }
    }

    public String getCoeditNoteCreatorName(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            Debugger.m8607d(TAG, "getCoeditNoteCreatorName() : itemId is null");
            return SesCoeditGroupReadResolver.getInstance().getUserName(getGroupId(str), C13541h.m14287e().m14293g());
        }
        UserInfo coeditNoteUserInfo = getCoeditNoteUserInfo(BaseUtils.getApplicationContext(), str, str2);
        if (coeditNoteUserInfo != null) {
            return coeditNoteUserInfo.getCreatorName();
        }
        Debugger.m8607d(TAG, "getCoeditNoteCreatorName() : userinfo is null");
        return null;
    }

    public long getCoeditNoteModifiedTime(Context context, String str, String str2) {
        long j = 0;
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return 0L;
        }
        String[] strArr = {"itemId", "modifiedTime"};
        Uri sharedItemContentUri = getSharedItemContentUri(str, str2);
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        try {
            try {
                Cursor cursorQuery = context.getContentResolver().query(sharedItemContentUri, strArr, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            j = cursorQuery.getLong(cursorQuery.getColumnIndex("modifiedTime"));
                        }
                    } finally {
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                Binder.restoreCallingIdentity(jClearCallingIdentity);
                return j;
            } catch (Exception e) {
                Debugger.m8609e(TAG, "getCoeditNoteCreatorId() : " + e.getMessage());
                Binder.restoreCallingIdentity(jClearCallingIdentity);
                return 0L;
            }
        } catch (Throwable th) {
            Binder.restoreCallingIdentity(jClearCallingIdentity);
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public UserInfo getCoeditNoteUserInfo(Context context, String str, String str2) {
        String str3;
        String string;
        Throwable th;
        String string2;
        String string3 = null;
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return null;
        }
        String[] strArr = {"itemId", "owner", "creator", "meta_data"};
        Uri sharedItemContentUri = getSharedItemContentUri(str, str2);
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        try {
            try {
                Cursor cursorQuery = context.getContentResolver().query(sharedItemContentUri, strArr, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            string = cursorQuery.getString(cursorQuery.getColumnIndex("owner"));
                            try {
                                string2 = cursorQuery.getString(cursorQuery.getColumnIndex("creator"));
                            } catch (Throwable th2) {
                                th = th2;
                                string2 = null;
                            }
                            try {
                                try {
                                    JSONObject jSONObject = new JSONObject(cursorQuery.getString(cursorQuery.getColumnIndex("meta_data")));
                                    if (jSONObject.has("creatorName")) {
                                        string3 = jSONObject.getString("creatorName");
                                    } else {
                                        Debugger.m8607d(TAG, "CREATOR NAME not exist");
                                    }
                                } catch (JSONException e) {
                                    Debugger.m8607d(TAG, "metadata error : " + e.getMessage());
                                }
                                str3 = string3;
                                string3 = string2;
                            } catch (Throwable th3) {
                                th = th3;
                                try {
                                    cursorQuery.close();
                                    throw th;
                                } catch (Throwable th4) {
                                    try {
                                        th.addSuppressed(th4);
                                        throw th;
                                    } catch (Exception e2) {
                                        e = e2;
                                        str3 = string3;
                                        string3 = string2;
                                        Debugger.m8609e(TAG, "getCoeditNoteUserInfo() : " + e.getMessage());
                                        return new UserInfo(string, string3, str3);
                                    }
                                }
                            }
                        } else {
                            str3 = null;
                            string = null;
                        }
                        if (cursorQuery != null) {
                            try {
                                cursorQuery.close();
                            } catch (Exception e3) {
                                e = e3;
                                Debugger.m8609e(TAG, "getCoeditNoteUserInfo() : " + e.getMessage());
                            }
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        string = null;
                        string2 = null;
                    }
                }
            } finally {
                Binder.restoreCallingIdentity(jClearCallingIdentity);
            }
        } catch (Exception e5) {
            e = e5;
            str3 = null;
            string = null;
        }
        return new UserInfo(string, string3, str3);
    }

    public String getResourceId(String str, String str2) {
        String[] strArr = {"referred_resource_id"};
        Uri sharedItemContentUri = getSharedItemContentUri(str, str2);
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        String string = null;
        try {
            try {
                Cursor cursorQuery = this.mContext.getContentResolver().query(sharedItemContentUri, strArr, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            string = cursorQuery.getString(0);
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
                Debugger.m8609e(TAG, "getResourceId() : " + e.getMessage());
                Binder.restoreCallingIdentity(jClearCallingIdentity);
                return null;
            }
        } catch (Throwable th) {
            Binder.restoreCallingIdentity(jClearCallingIdentity);
            throw th;
        }
    }

    @Override // com.samsung.android.app.notes.sync.contentsharing.sesdb.SesShareBaseReadResolver
    public Uri getSharedContentUri() {
        return Uri.parse(CONTENT_SPACE_URI + "/space");
    }

    @Override // com.samsung.android.app.notes.sync.contentsharing.sesdb.SesShareBaseReadResolver
    public Uri getSharedItemContentUri() {
        return Uri.parse(CONTENT_ITEM_URI + "/item");
    }

    public String getSpaceIdByGroupId(String str) {
        String string = "";
        if (str == null || str.isEmpty()) {
            return "";
        }
        String[] strArr = {str};
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        try {
            try {
                Cursor cursorQuery = this.mContext.getContentResolver().query(this.mContentUri, new String[]{"spaceId"}, "groupId = ?", strArr, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            string = cursorQuery.getString(cursorQuery.getColumnIndex("spaceId"));
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
                Debugger.m8609e(TAG, "getSpaceIdByGroupId() : " + e.toString());
                Binder.restoreCallingIdentity(jClearCallingIdentity);
                return "";
            }
        } catch (Throwable th) {
            Binder.restoreCallingIdentity(jClearCallingIdentity);
            throw th;
        }
    }

    @Override // com.samsung.android.app.notes.sync.contentsharing.sesdb.SesShareBaseReadResolver
    public String getSpaceTitle(String str) {
        String string = "";
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        try {
            try {
                Cursor cursorQuery = this.mContext.getContentResolver().query(this.mContentUri.buildUpon().appendPath(str).build(), new String[]{"title"}, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            string = cursorQuery.getString(cursorQuery.getColumnIndex("title"));
                        }
                    } finally {
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Exception e) {
                Debugger.m8609e(TAG, "getSpaceTitle() : " + e.toString());
            }
            Binder.restoreCallingIdentity(jClearCallingIdentity);
            return (string == null || !string.startsWith(StandAloneNoteConstatnt)) ? string : removeStandAlonePrefix(string);
        } catch (Throwable th) {
            Binder.restoreCallingIdentity(jClearCallingIdentity);
            throw th;
        }
    }

    public String getSpaceTitleWithPrefix(String str) {
        String string = "";
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        try {
            try {
                Cursor cursorQuery = this.mContext.getContentResolver().query(this.mContentUri.buildUpon().appendPath(str).build(), new String[]{"title"}, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            string = cursorQuery.getString(cursorQuery.getColumnIndex("title"));
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
                Debugger.m8609e(TAG, "getSpaceTitle() : " + e.toString());
                Binder.restoreCallingIdentity(jClearCallingIdentity);
                return "";
            }
        } catch (Throwable th) {
            Binder.restoreCallingIdentity(jClearCallingIdentity);
            throw th;
        }
    }

    public boolean getStandAlone(String str) {
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        boolean z = false;
        try {
            try {
                Cursor cursorQuery = this.mContext.getContentResolver().query(this.mContentUri.buildUpon().appendPath(str).build(), new String[]{STAND_ALONE}, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            if (cursorQuery.getInt(cursorQuery.getColumnIndex(STAND_ALONE)) != 0) {
                                z = true;
                            }
                        }
                    } finally {
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                Binder.restoreCallingIdentity(jClearCallingIdentity);
                return z;
            } catch (Exception e) {
                Debugger.m8609e(TAG, "getStandAlone() : " + e.toString());
                Binder.restoreCallingIdentity(jClearCallingIdentity);
                return false;
            }
        } catch (Throwable th) {
            Binder.restoreCallingIdentity(jClearCallingIdentity);
            throw th;
        }
    }

    public boolean isSpaceExist(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        String[] strArr = {str};
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        try {
            try {
                Cursor cursorQuery = this.mContext.getContentResolver().query(this.mContentUri, new String[]{"spaceId"}, "spaceId = ?", strArr, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            cursorQuery.close();
                            Binder.restoreCallingIdentity(jClearCallingIdentity);
                            return true;
                        }
                    } finally {
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Exception e) {
                Debugger.m8609e(TAG, "getSpaceIdByGroupId() : " + e.toString());
            }
            Binder.restoreCallingIdentity(jClearCallingIdentity);
            return false;
        } catch (Throwable th) {
            Binder.restoreCallingIdentity(jClearCallingIdentity);
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0137 A[LOOP:0: B:6:0x001a->B:39:0x0137, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x013e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<SharedItem> parseCoeditItemList(Cursor cursor) {
        JSONException jSONException;
        String str;
        long j;
        long j2;
        long j3;
        String str2;
        JSONObject jSONObject;
        String string;
        Cursor cursor2 = cursor;
        String str3 = "creatorName";
        ArrayList arrayList = new ArrayList();
        if (cursor2 == null || !cursor2.moveToFirst()) {
            return arrayList;
        }
        while (true) {
            String string2 = cursor2.getString(0);
            String string3 = cursor2.getString(1);
            String string4 = cursor2.getString(2);
            String string5 = cursor2.getString(3);
            long j5 = cursor2.getLong(4);
            long j6 = cursor2.getLong(5);
            int i = cursor2.getInt(6);
            String string6 = cursor2.getString(7);
            String string7 = cursor2.getString(8);
            ArrayList arrayList2 = arrayList;
            String string8 = cursor2.getString(9);
            String string9 = cursor2.getString(10);
            try {
                jSONObject = new JSONObject(string6);
                string = jSONObject.getString("uuid");
                try {
                    j3 = jSONObject.getLong("lastModifiedAt");
                    try {
                        j2 = jSONObject.has("createdAt") ? jSONObject.getLong("createdAt") : 0L;
                    } catch (JSONException e) {
                        j2 = 0;
                        str = string;
                        j = j3;
                        jSONException = e;
                        j = j2;
                        Debugger.m8607d(TAG, "metadata error : " + jSONException.getMessage());
                        j3 = j;
                        j = j;
                        str2 = str;
                        String str4 = string;
                        String str5 = str3;
                        SharedItem sharedItem = new SharedItem(string2, string3, string4);
                        sharedItem.setTitle(string5);
                        sharedItem.setCreatedTime(j5);
                        sharedItem.setModifiedTime(j6);
                        sharedItem.setOwnedByMe(i <= 0);
                        sharedItem.setResourceId(string7);
                        sharedItem.setCreator(string8);
                        HashMap map = new HashMap();
                        map.put("uuid", str2);
                        map.put("lastModifiedAt", Long.valueOf(j3));
                        map.put("createdAt", Long.valueOf(j2));
                        map.put("DoclastModifiedAt", Long.valueOf(j));
                        map.put(str5, str4);
                        sharedItem.setMetaData(map);
                        sharedItem.setMemo(string9);
                        arrayList2.add(sharedItem);
                        if (cursor.moveToNext()) {
                        }
                    }
                } catch (JSONException e2) {
                    jSONException = e2;
                    j2 = 0;
                    str = string;
                }
            } catch (JSONException e3) {
                jSONException = e3;
                str = null;
                j = 0;
                j2 = 0;
            }
            try {
                j = jSONObject.has("DoclastModifiedAt") ? jSONObject.getLong("DoclastModifiedAt") : 0L;
                string = jSONObject.has(str3) ? jSONObject.getString(str3) : null;
                str2 = string;
            } catch (JSONException e5) {
                str = string;
                jSONException = e5;
                j = 0;
                j = j3;
                Debugger.m8607d(TAG, "metadata error : " + jSONException.getMessage());
                j3 = j;
                j = j;
                str2 = str;
            }
            String str42 = string;
            String str52 = str3;
            SharedItem sharedItem2 = new SharedItem(string2, string3, string4);
            sharedItem2.setTitle(string5);
            sharedItem2.setCreatedTime(j5);
            sharedItem2.setModifiedTime(j6);
            sharedItem2.setOwnedByMe(i <= 0);
            sharedItem2.setResourceId(string7);
            sharedItem2.setCreator(string8);
            HashMap map2 = new HashMap();
            map2.put("uuid", str2);
            map2.put("lastModifiedAt", Long.valueOf(j3));
            map2.put("createdAt", Long.valueOf(j2));
            map2.put("DoclastModifiedAt", Long.valueOf(j));
            map2.put(str52, str42);
            sharedItem2.setMetaData(map2);
            sharedItem2.setMemo(string9);
            arrayList2.add(sharedItem2);
            if (cursor.moveToNext()) {
                return arrayList2;
            }
            arrayList = arrayList2;
            str3 = str52;
            cursor2 = cursor;
        }
    }

    public String removeStandAlonePrefix(@NonNull String str) {
        return str.replace(StandAloneNoteConstatnt, "");
    }

    public List<Space> requestCoEditStandAloneSpaceList() {
        String[] strArr = {"spaceId", "title", "owner", "groupId", "is_owned_by_me", STAND_ALONE, "createTime"};
        String[] strArr2 = {"1"};
        List<Space> arrayList = new ArrayList<>();
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        try {
            try {
                Cursor cursorQuery = this.mContext.getContentResolver().query(this.mContentUri, strArr, "stand_alone=?", strArr2, "createTime DESC");
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.getCount() > 0) {
                            arrayList = parseStandAloneSpaceList(cursorQuery);
                        }
                    } finally {
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                Binder.restoreCallingIdentity(jClearCallingIdentity);
                return arrayList;
            } catch (Throwable th) {
                Binder.restoreCallingIdentity(jClearCallingIdentity);
                throw th;
            }
        } catch (Exception e) {
            Debugger.m8609e(TAG, "requestCoEditStandAloneSpaceList() : " + e.toString());
            Binder.restoreCallingIdentity(jClearCallingIdentity);
            return arrayList;
        }
    }

    @Override // com.samsung.android.app.notes.sync.contentsharing.sesdb.SesShareBaseReadResolver
    public List<SharedItem> requestSharedItemList(Context context, String str) {
        ArrayList arrayList;
        String[] strArr = {"itemId", "spaceId", "owner", "title", "createTime", "modifiedTime", "is_owned_by_me", "meta_data", "referred_resource_id", "creator", "memo"};
        Uri sharedItemContentUri = str != null ? getSharedItemContentUri(str) : getSharedItemContentUri();
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        List<SharedItem> coeditItemList = null;
        try {
            try {
                Cursor cursorQuery = context.getContentResolver().query(sharedItemContentUri, strArr, null, null, null);
                if (cursorQuery != null) {
                    try {
                        arrayList = new ArrayList();
                        try {
                            coeditItemList = cursorQuery.getCount() > 0 ? parseCoeditItemList(cursorQuery) : arrayList;
                        } catch (Throwable th) {
                            th = th;
                            Throwable th2 = th;
                            try {
                                cursorQuery.close();
                                throw th2;
                            } catch (Throwable th3) {
                                try {
                                    th2.addSuppressed(th3);
                                    throw th2;
                                } catch (Exception e) {
                                    e = e;
                                    coeditItemList = arrayList;
                                    Debugger.m8609e(TAG, "requestSharedItemList() : " + e.getMessage());
                                    return coeditItemList;
                                }
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        arrayList = null;
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return coeditItemList;
            } finally {
                Binder.restoreCallingIdentity(jClearCallingIdentity);
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    @Override // com.samsung.android.app.notes.sync.contentsharing.sesdb.SesShareBaseReadResolver
    public List<Space> requestSpaceList() {
        String[] strArr = {"spaceId", "title", "owner", "groupId", "is_owned_by_me", STAND_ALONE, "createTime"};
        List<Space> arrayList = new ArrayList<>();
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        try {
            try {
                Cursor cursorQuery = this.mContext.getContentResolver().query(this.mContentUri, strArr, null, null, "createTime DESC");
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.getCount() > 0) {
                            arrayList = parseStandAloneSpaceList(cursorQuery);
                        }
                    } finally {
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                Binder.restoreCallingIdentity(jClearCallingIdentity);
                return arrayList;
            } catch (Exception e) {
                Debugger.m8609e(TAG, "requestSpaceList() : " + e.toString());
                Binder.restoreCallingIdentity(jClearCallingIdentity);
                return arrayList;
            }
        } catch (Throwable th) {
            Binder.restoreCallingIdentity(jClearCallingIdentity);
            throw th;
        }
    }

    @Override // com.samsung.android.app.notes.sync.contentsharing.sesdb.SesShareBaseReadResolver
    public Uri getSharedItemContentUri(String str) {
        return Uri.parse(CONTENT_ITEM_URI + "/space").buildUpon().appendPath(str).build();
    }

    @Override // com.samsung.android.app.notes.sync.contentsharing.sesdb.SesShareBaseReadResolver
    public Uri getSharedItemContentUri(String str, String str2) {
        return Uri.parse(CONTENT_ITEM_URI + "/space").buildUpon().appendPath(str).appendPath("item").appendPath(str2).build();
    }

    @Override // com.samsung.android.app.notes.sync.contentsharing.sesdb.SesShareBaseReadResolver
    public List<SharedItem> requestSharedItemList(Context context) {
        return requestSharedItemList(context, null);
    }
}
