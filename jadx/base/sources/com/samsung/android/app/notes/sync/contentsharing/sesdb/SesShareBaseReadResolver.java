package com.samsung.android.app.notes.sync.contentsharing.sesdb;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.sdk.mobileservice.social.share.BundleKey;
import com.samsung.android.sdk.mobileservice.social.share.SharedItem;
import com.samsung.android.sdk.mobileservice.social.share.Space;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class SesShareBaseReadResolver extends SesReadResolverBase {
    public static final String GROUP_ID = "groupId";
    public static final String IS_OWNED_BY_ME = "is_owned_by_me";
    public static final String ITEM_CREATE_TIME = "createTime";
    public static final String ITEM_ID = "itemId";
    public static final String ITEM_MODIFIED_TIME = "modifiedTime";
    public static final String META_DATA = "meta_data";
    public static final String OWNER = "owner";
    protected static final String PATTERN_CONTENTS = "/contents";
    protected static final String PATTERN_GROUP = "/group";
    protected static final String PATTERN_ITEM = "/item";
    protected static final String PATTERN_SPACE = "/space";
    public static final String SPACE_CREATE_TIME = "createTime";
    public static final String SPACE_ID = "spaceId";
    private static final String TAG = "SesShareBaseReadResolver";
    public static final String TITLE = "title";

    public SesShareBaseReadResolver() {
        this.mContentUri = getSharedContentUri();
    }

    private List<Space> parseSpaceList(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        if (cursor == null || !cursor.moveToFirst()) {
            if (cursor == null) {
                return null;
            }
            cursor.close();
            return null;
        }
        do {
            String string = cursor.getString(0);
            String string2 = cursor.getString(1);
            String string3 = cursor.getString(2);
            String string4 = cursor.getString(3);
            boolean z = cursor.getInt(4) != 0;
            Space space = new Space(string4, string, string3);
            space.setTitle(string2);
            space.setOwnedByMe(z);
            arrayList.add(space);
        } while (cursor.moveToNext());
        cursor.close();
        return arrayList;
    }

    public List<String> getDefaultNotebooksName(String str) {
        String[] strArr = {"title"};
        String strM773o = AbstractC0541b.m773o("title Like '", str, "'");
        ArrayList arrayList = new ArrayList();
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        try {
            try {
                Cursor cursorQuery = this.mContext.getContentResolver().query(this.mContentUri, strArr, strM773o, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            do {
                                arrayList.add(cursorQuery.getString(0));
                            } while (cursorQuery.moveToNext());
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
                Debugger.m8609e(TAG, "getDefaultNotebooksName() : " + e.getMessage());
                Binder.restoreCallingIdentity(jClearCallingIdentity);
                return arrayList;
            }
        } catch (Throwable th) {
            Binder.restoreCallingIdentity(jClearCallingIdentity);
            throw th;
        }
    }

    public String getGroupId(String str) {
        String string = "";
        if (str == null || str.isEmpty()) {
            return "";
        }
        String[] strArr = {str};
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        try {
            try {
                Cursor cursorQuery = this.mContext.getContentResolver().query(this.mContentUri, new String[]{"groupId"}, "spaceId = ?", strArr, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            string = cursorQuery.getString(cursorQuery.getColumnIndex("groupId"));
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
                Debugger.m8609e(TAG, "getGroupId() : " + e.getMessage());
                Binder.restoreCallingIdentity(jClearCallingIdentity);
                return "";
            }
        } catch (Throwable th) {
            Binder.restoreCallingIdentity(jClearCallingIdentity);
            throw th;
        }
    }

    public String getOriginalUriByItemId(Context context, String str, String str2) {
        String[] strArr = {"itemId", BundleKey.ORIGINAL_CONTENT_URI};
        Uri sharedItemContentUri = getSharedItemContentUri(str, str2);
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        String string = null;
        try {
            try {
                Cursor cursorQuery = context.getContentResolver().query(sharedItemContentUri, strArr, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            cursorQuery.getString(cursorQuery.getColumnIndex("itemId"));
                            string = cursorQuery.getString(cursorQuery.getColumnIndex(BundleKey.ORIGINAL_CONTENT_URI));
                        }
                    } finally {
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                Binder.restoreCallingIdentity(jClearCallingIdentity);
                return string;
            } catch (Throwable th) {
                Binder.restoreCallingIdentity(jClearCallingIdentity);
                throw th;
            }
        } catch (Exception e) {
            Debugger.m8609e(TAG, "getSharedItemContentUriByItemId() : " + e.getMessage());
            Binder.restoreCallingIdentity(jClearCallingIdentity);
            return null;
        }
    }

    public abstract Uri getSharedContentUri();

    /* JADX WARN: Removed duplicated region for block: B:20:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SharedItem getSharedItemByItemId(Context context, String str, String str2) {
        List<SharedItem> itemList;
        String[] strArr = {"itemId", "spaceId", "owner", "title", "createTime", "modifiedTime", "is_owned_by_me", "meta_data", "memo"};
        Uri sharedItemContentUri = getSharedItemContentUri(str, str2);
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        try {
            try {
                Cursor cursorQuery = context.getContentResolver().query(sharedItemContentUri, strArr, null, null, null);
                if (cursorQuery != null) {
                    try {
                        itemList = cursorQuery.getCount() > 0 ? parseItemList(cursorQuery) : null;
                        if (cursorQuery != null) {
                            try {
                                cursorQuery.close();
                            } catch (Exception e) {
                                e = e;
                                Debugger.m8609e(TAG, "getSharedItemByItemId() : " + e.getMessage());
                            }
                        }
                    } catch (Throwable th) {
                        try {
                            cursorQuery.close();
                            throw th;
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                            throw th;
                        }
                    }
                }
            } finally {
                Binder.restoreCallingIdentity(jClearCallingIdentity);
            }
        } catch (Exception e2) {
            e = e2;
            itemList = null;
        }
        if (itemList == null || itemList.isEmpty()) {
            return null;
        }
        return itemList.get(0);
    }

    public abstract Uri getSharedItemContentUri();

    public abstract Uri getSharedItemContentUri(String str);

    public abstract Uri getSharedItemContentUri(String str, String str2);

    public int getSharedItemCount() {
        Cursor cursorQuery;
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        try {
            try {
                cursorQuery = this.mContext.getContentResolver().query(this.mContentUri, null, null, null, null);
            } finally {
                Binder.restoreCallingIdentity(jClearCallingIdentity);
            }
        } catch (Exception e) {
            Debugger.m8609e(TAG, "getSharedItemCount() : " + e.getMessage());
        }
        if (cursorQuery == null) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return 0;
        }
        try {
            int count = cursorQuery.getCount();
            cursorQuery.close();
            return count;
        } finally {
        }
    }

    public int getSpaceCount() {
        Cursor cursorQuery;
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        try {
            try {
                cursorQuery = this.mContext.getContentResolver().query(getSharedContentUri(), null, null, null, null);
            } finally {
                Binder.restoreCallingIdentity(jClearCallingIdentity);
            }
        } catch (Exception e) {
            Debugger.m8609e(TAG, "getSpaceCount() : " + e.getMessage());
        }
        if (cursorQuery == null) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return 0;
        }
        try {
            int count = cursorQuery.getCount();
            cursorQuery.close();
            return count;
        } finally {
        }
    }

    public String getSpaceTitle(String str) {
        String string = "";
        String[] strArr = {str};
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        try {
            try {
                Cursor cursorQuery = this.mContext.getContentResolver().query(this.mContentUri, new String[]{"title"}, "spaceId = ?", strArr, null);
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
            } catch (Throwable th) {
                Binder.restoreCallingIdentity(jClearCallingIdentity);
                throw th;
            }
        } catch (Exception e) {
            Debugger.m8609e(TAG, "getSpaceTitle() : " + e.getMessage());
            Binder.restoreCallingIdentity(jClearCallingIdentity);
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean isSpaceOwner(String str) {
        int i;
        Uri uri = this.mContentUri;
        String[] strArr = {str};
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        try {
            try {
                Cursor cursorQuery = this.mContext.getContentResolver().query(uri, new String[]{"is_owned_by_me"}, "spaceId = ?", strArr, null);
                if (cursorQuery != null) {
                    try {
                        i = cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
                        if (cursorQuery != null) {
                            try {
                                cursorQuery.close();
                            } catch (Exception e) {
                                e = e;
                                Debugger.m8609e(TAG, "isSpaceOwner() : " + e.getMessage());
                            }
                        }
                    } catch (Throwable th) {
                        try {
                            cursorQuery.close();
                            throw th;
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                            throw th;
                        }
                    }
                }
            } catch (Exception e2) {
                e = e2;
                i = 0;
            }
            Binder.restoreCallingIdentity(jClearCallingIdentity);
            return i != 0;
        } catch (Throwable th3) {
            Binder.restoreCallingIdentity(jClearCallingIdentity);
            throw th3;
        }
    }

    public List<SharedItem> parseItemList(Cursor cursor) {
        long j;
        long j2;
        Cursor cursor2 = cursor;
        ArrayList arrayList = new ArrayList();
        if (cursor2 != null && cursor2.moveToFirst()) {
            while (true) {
                String string = cursor2.getString(0);
                String string2 = cursor2.getString(1);
                String string3 = cursor2.getString(2);
                String string4 = cursor2.getString(3);
                long j3 = cursor2.getLong(4);
                long j5 = cursor2.getLong(5);
                int i = cursor2.getInt(6);
                String string5 = cursor2.getString(7);
                String string6 = cursor2.getString(8);
                long j6 = 0;
                String string7 = null;
                try {
                    JSONObject jSONObject = new JSONObject(string5);
                    string7 = jSONObject.getString("uuid");
                    j = jSONObject.getLong("lastModifiedAt");
                    try {
                        j2 = jSONObject.has("createdAt") ? jSONObject.getLong("createdAt") : 0L;
                    } catch (JSONException e) {
                        e = e;
                        j2 = 0;
                    }
                    try {
                        if (jSONObject.has("DoclastModifiedAt")) {
                            j6 = jSONObject.getLong("DoclastModifiedAt");
                        }
                    } catch (JSONException e2) {
                        e = e2;
                        Debugger.m8607d(TAG, "metadata error : " + e.getMessage());
                    }
                } catch (JSONException e3) {
                    e = e3;
                    j = 0;
                    j2 = 0;
                }
                String str = string7;
                SharedItem sharedItem = new SharedItem(string, string2, string3);
                sharedItem.setTitle(string4);
                sharedItem.setCreatedTime(j3);
                sharedItem.setModifiedTime(j5);
                sharedItem.setOwnedByMe(i > 0);
                HashMap map = new HashMap();
                map.put("uuid", str);
                map.put("lastModifiedAt", Long.valueOf(j));
                map.put("createdAt", Long.valueOf(j2));
                map.put("DoclastModifiedAt", Long.valueOf(j6));
                sharedItem.setMetaData(map);
                sharedItem.setMemo(string6);
                arrayList.add(sharedItem);
                if (!cursor.moveToNext()) {
                    break;
                }
                cursor2 = cursor;
            }
        }
        return arrayList;
    }

    public List<SharedItem> requestSharedItemList(Context context) {
        return requestSharedItemList(context, null);
    }

    public List<Space> requestSpaceList() {
        String[] strArr = {"spaceId", "title", "owner", "groupId", "is_owned_by_me"};
        List<Space> arrayList = new ArrayList<>();
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        try {
            try {
                Cursor cursorQuery = this.mContext.getContentResolver().query(this.mContentUri, strArr, null, null, "createTime DESC");
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.getCount() > 0) {
                            arrayList = parseSpaceList(cursorQuery);
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
                Debugger.m8609e(TAG, "requestSpaceList() : " + e.getMessage());
                Binder.restoreCallingIdentity(jClearCallingIdentity);
                return arrayList;
            }
        } catch (Throwable th) {
            Binder.restoreCallingIdentity(jClearCallingIdentity);
            throw th;
        }
    }

    public List<SharedItem> requestSharedItemList(Context context, String str) {
        ArrayList arrayList;
        String[] strArr = {"itemId", "spaceId", "owner", "title", "createTime", "modifiedTime", "is_owned_by_me", "meta_data", "memo"};
        Uri sharedItemContentUri = str != null ? getSharedItemContentUri(str) : getSharedItemContentUri();
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        List<SharedItem> itemList = null;
        try {
            try {
                Cursor cursorQuery = context.getContentResolver().query(sharedItemContentUri, strArr, null, null, null);
                if (cursorQuery != null) {
                    try {
                        arrayList = new ArrayList();
                        try {
                            itemList = cursorQuery.getCount() > 0 ? parseItemList(cursorQuery) : arrayList;
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
                                    itemList = arrayList;
                                    Debugger.m8609e(TAG, "requestSharedItemList() : " + e.getMessage());
                                    return itemList;
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
                return itemList;
            } finally {
                Binder.restoreCallingIdentity(jClearCallingIdentity);
            }
        } catch (Exception e2) {
            e = e2;
        }
    }
}
