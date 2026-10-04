package com.samsung.android.support.senl.document.memoconverter.core;

import android.os.Build;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class ConverterUtils {
    public static final int CONVERT_MODE_NORMAL = 0;
    public static final int CONVERT_MODE_RENAME = 2;
    public static final int CONVERT_MODE_REPLACE = 1;
    public static final int DB_VERSION = 10;
    public static final String MIME_TYPE_AUDIO_ALL = "audio/*";
    public static final String MIME_TYPE_AUDIO_MP4 = "audio/mp4";
    public static final String MIME_TYPE_MP4 = "audio/mp4";
    public static final String MIME_TYPE_UNKNOWN = "application/octet-stream";

    /* JADX INFO: renamed from: NO */
    public static final int f5902NO = 0;
    private static final String TAG = "ConverterUtils";
    public static final String UUID_NONE = "";
    public static final int YES = 1;
    public static final String[] CATEGORY_COLUMNS = {"UUID", "orderBy", "sync1", "sync2", "_display_name", "accountName", "accountType"};
    public static final String[] FILE_COLUMNS = {"UUID", "memoUUID", "mime_type", "_display_name", "_size", "orientation", "_data", "sync1"};
    public static final String[] MEMO_COLUMNS = {"UUID", "createdAt", "categoryUUID", "title", "content", "strippedContent", "_data", "lastModifiedAt", "accountName", "accountType", "sync2", "sync1"};
    public static final String[] MEMO_COLUMNS_SEC = {"xmlContent", "display_Content", "isFavorite"};
    public static final String[] ETC_MEMO_COLUMNS = {"title", "createdAt", "lastModifiedAt", "category", "content", "voice", NotesConstants.KEY_FOLDER_UUID};

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface CategoryTable {
        public static final String ACCOUNT_NAME = "accountName";
        public static final String ACCOUNT_TYPE = "accountType";
        public static final String DELETED = "isDeleted";
        public static final String DIRTY = "isDirty";
        public static final String DISPLAY_NAME = "_display_name";

        /* JADX INFO: renamed from: ID */
        public static final String f5903ID = "_id";
        public static final String ORDERBY = "orderBy";
        public static final String SYNC1 = "sync1";
        public static final String SYNC2 = "sync2";
        public static final String UUID = "UUID";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface FileTable {
        public static final String ACCOUNT_NAME = "accountName";
        public static final String ACCOUNT_TYPE = "accountType";
        public static final String DATA = "_data";
        public static final String DELETED = "isDeleted";
        public static final String DIRTY = "isDirty";
        public static final String DISPLAY_NAME = "_display_name";

        /* JADX INFO: renamed from: ID */
        public static final String f5904ID = "_id";
        public static final String MEMOUUID = "memoUUID";
        public static final String MIME_TYPE = "mime_type";
        public static final String ORIENTATION = "orientation";
        public static final String SIZE = "_size";
        public static final String SRCURI = "_srcUri";
        public static final String SYNC1 = "sync1";
        public static final String UUID = "UUID";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface MemoTable {
        public static final String ACCOUNT_NAME = "accountName";
        public static final String ACCOUNT_TYPE = "accountType";
        public static final String CATEGORY_UUID = "categoryUUID";
        public static final String CONTENT = "content";
        public static final String CREATED_TIMESTAMP = "createdAt";
        public static final String DATA = "_data";
        public static final String DELETED = "isDeleted";
        public static final String DIRTY = "isDirty";
        public static final String DISPLAY_CONTENT = "display_Content";
        public static final String FAVORITE = "isFavorite";

        /* JADX INFO: renamed from: ID */
        public static final String f5905ID = "_id";
        public static final String MODIFIED_TIMESTAMP = "lastModifiedAt";
        public static final String STRIPPED_CONTENT = "strippedContent";
        public static final String SYNC1 = "sync1";
        public static final String SYNC2 = "sync2";
        public static final String TITLE = "title";
        public static final String UUID = "UUID";
        public static final String VRFILEUUID_MEMO = "vrfileUUID";
        public static final String VRFILEUUID_SYNCADAPTER = "vrfileuuid";
        public static final String XML_CONTENT = "xmlContent";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Tbl_Base {
        public static final String ACCOUNT_NAME = "accountName";
        public static final String ACCOUNT_TYPE = "accountType";

        /* JADX INFO: renamed from: ID */
        public static final String f5906ID = "_id";
        public static final String IS_DELETED = "isDeleted";
        public static final String IS_DIRTY = "isDirty";
        public static final String IS_NEED_UPSYNC = "isNeedUpsync";
        public static final String MIME_TYPE_ALL = "application/vnd.samsung.memo";
        public static final String MIME_TYPE_ONE = "application/vnd.samsung.memo";
        public static final String SKIP_DIRTY_SET = "v_skipDirtySet";
        public static final String SKIP_SYNC1_SET = "v_skipSync1Set";
        public static final String SYNC1 = "sync1";
        public static final String SYNC2 = "sync2";
        public static final String TABLE_NAME = "_base";
        public static final String UUID = "UUID";
        public static final String lower = "uuid";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Tbl_Category extends Tbl_Base {
        public static final String DISPLAY_NAME = "_display_name";
        public static final String MIME_TYPE_ALL = "vnd.android.cursor.dir/vnd.samsung.memo.category";
        public static final String MIME_TYPE_ONE = "vnd.android.cursor.item/vnd.samsung.memo.category";
        public static final String ORDER_BY = "orderBy";
        public static final String TABLE_NAME = "category";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Tbl_File extends Tbl_Base {
        public static final String DATA = "_data";
        public static final String DISPLAY_NAME = "_display_name";
        public static final String IN_SRCURI = "_srcUri";
        public static final String MEMO_UUID = "memoUUID";
        public static final String MIME_TYPE = "mime_type";
        public static final String MIME_TYPE_ALL = "vnd.android.cursor.dir/vnd.samsung.memo.file";
        public static final String MIME_TYPE_ONE = "vnd.android.cursor.item/vnd.samsung.memo.file";
        public static final String ORIENTATION = "orientation";
        public static final String SIZE = "_size";
        public static final String TABLE_NAME = "file";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Tbl_Memo extends Tbl_Base {
        public static final String CATEGORY_UUID = "categoryUUID";
        public static final String CONTENT = "content";
        public static final String CREATED_AT = "createdAt";
        public static final String DATA = "_data";
        public static final String DISPLAY_CONTENT = "display_Content";
        public static final String IS_FAVORITE = "isFavorite";
        public static final String LAST_MODIFIED_AT = "lastModifiedAt";
        public static final String MIME_TYPE_ALL = "vnd.android.cursor.dir/vnd.samsung.memo";
        public static final String MIME_TYPE_ONE = "vnd.android.cursor.item/vnd.samsung.memo";
        public static final String PHONE_NUM = "_phoneNum";
        public static final String STRIPPED_CONTENT = "strippedContent";
        public static final String TABLE_NAME = "memo";
        public static final String TITLE = "title";
        public static final String VR_FILE_UUID = "vrfileUUID";
        public static final String VR_FILE_lower = "vrfileuuid";
        public static final String XML_CONTENT = "xmlContent";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Tbl_Search {
        public static final String MIME_TYPE_ALL = "vnd.android.cursor.dir/vnd.samsung.memo";
        public static final String TABLE_NAME = "search";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Tbl_SyncState {
        public static final String ACCOUNT_NAME = "accountName";
        public static final String ACCOUNT_TYPE = "accountType";
        public static final String DATA = "data";

        /* JADX INFO: renamed from: ID */
        public static final String f5907ID = "_id";
        public static final String TABLE_NAME = "_sync_state";
    }

    public static String getFolderPath(String str) {
        return str.substring(0, str.lastIndexOf("/") + 1);
    }

    public static String getLockedMemoTitle(String str) {
        int iLastIndexOf = str.lastIndexOf("/");
        int iLastIndexOf2 = str.lastIndexOf("_");
        return (iLastIndexOf < 0 || iLastIndexOf2 < 0) ? "tmp" : str.substring(iLastIndexOf + 1, iLastIndexOf2);
    }

    public static String getRelativePath(String str) {
        if (str == null) {
            return "";
        }
        int iIndexOf = str.indexOf("memo");
        return iIndexOf != -1 ? str.substring(iIndexOf + 4) : str;
    }

    public static String getTitle(String str) {
        int iLastIndexOf = str.lastIndexOf("/");
        int iLastIndexOf2 = str.lastIndexOf(Extension.DOT);
        return (iLastIndexOf < 0 || iLastIndexOf2 < 0) ? "tmp" : str.substring(iLastIndexOf + 1, iLastIndexOf2).replace(":", "_");
    }

    public static StringBuilder handleNewLines(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '\n') {
                sb.append("</p><p>");
            } else if (cCharAt == '\r') {
                sb.append("");
            } else {
                sb.append(cCharAt);
            }
        }
        return sb;
    }

    public static boolean isMondrianOrPicassoInProduction() {
        String str = Build.MODEL;
        return str.contains("T320") || str.contains("T321") || str.contains("T325") || str.contains("T520") || str.contains("T525");
    }
}
