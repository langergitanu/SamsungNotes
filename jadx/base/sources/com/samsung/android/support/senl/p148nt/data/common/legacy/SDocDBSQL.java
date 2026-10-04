package com.samsung.android.support.senl.p148nt.data.common.legacy;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SDocDBSQL {
    public static final String LOCKED_SDOC_LIST = "db_update_list_for_locked_sdoc";
    public static final int SAVE_TYPE_NONE = 0;
    private static final String SQL_CREATE_HASHTAG = "CREATE TABLE IF NOT EXISTS hashtag (_id INTEGER PRIMARY KEY AUTOINCREMENT, UUID TEXT    NOT NULL UNIQUE, name TEXT    NOT NULL, extraInfo TEXT    NOT NULL DEFAULT '', lastModifiedAt INTEGER    NOT NULL, isDeleted INTEGER NOT NULL DEFAULT 0, isDirty INTEGER NOT NULL DEFAULT 1, serverTimestamp INTEGER DEFAULT 1464416139847  )";
    private static final String SQL_CREATE_HASHTAG_CONTENT = "CREATE TABLE IF NOT EXISTS hashtagContent (_id INTEGER PRIMARY KEY AUTOINCREMENT, hashtagUUID TEXT    NOT NULL, sdocUUID TEXT    NOT NULL, extraInfo TEXT    NOT NULL DEFAULT '', isDeleted INTEGER NOT NULL DEFAULT 0, isDirty INTEGER NOT NULL DEFAULT 1, serverTimestamp INTEGER DEFAULT 1464416139847, isSyncFailed INTEGER DEFAULT 0, lastModifiedAt INTEGER    NOT NULL  )";
    private static final String SQL_CREATE_MDE_VIEW = "CREATE VIEW IF NOT EXISTS vsdoc   AS SELECT * FROM sdoc WHERE sdoc.mdeSpaceId == ''";
    private static final String SQL_CREATE_RETRY = "CREATE TABLE IF NOT EXISTS retry (_id INTEGER PRIMARY KEY AUTOINCREMENT, sdocUUID TEXT    NOT NULL, strokeFilePath TEXT    NOT NULL ,state INTEGER NOT NULL DEFAULT 0, recognitionCount INTEGER NOT NULL DEFAULT 0, lastModifiedAt INTEGER NOT NULL  )";
    private static final String SQL_DELETE_POPUP_MEMO = "DELETE FROM category WHERE UUID = 3;";
    private static final String SQL_INSERT_SCREEN_OFF_MEMO = "INSERT INTO category ( UUID,predefine,lastModifiedAt,displayName ) VALUES ( '2', 2, " + System.currentTimeMillis() + ", '' );";
    private static final String SQL_INSERT_POPUP_MEMO = "INSERT INTO category ( UUID,predefine,orderBy,lastModifiedAt,displayName ) VALUES ( '3', 3, 999998, " + System.currentTimeMillis() + ", '' );";

    public static String getSqlCreateHashtag() {
        return SQL_CREATE_HASHTAG;
    }

    public static String getSqlCreateHashtagContent() {
        return SQL_CREATE_HASHTAG_CONTENT;
    }

    public static String getSqlCreateMdeView() {
        return SQL_CREATE_MDE_VIEW;
    }

    public static String getSqlCreateRetry() {
        return SQL_CREATE_RETRY;
    }

    public static String getSqlDeletePopupMemo() {
        return SQL_DELETE_POPUP_MEMO;
    }

    public static String getSqlInsertPopupMemo() {
        return SQL_INSERT_POPUP_MEMO;
    }

    public static String getSqlInsertScreenOffMemo() {
        return SQL_INSERT_SCREEN_OFF_MEMO;
    }
}
