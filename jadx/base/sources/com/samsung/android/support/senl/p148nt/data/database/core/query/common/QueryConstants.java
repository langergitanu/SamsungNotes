package com.samsung.android.support.senl.p148nt.data.database.core.query.common;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class QueryConstants {
    public static final char ESCAPE_CHARACTER = 65533;
    public static final String ESCAPE_CHARACTER_STRING = "'�'";
    public static final String LOCKED_CONDITION = "sdoc.isLock != 0";
    public static final char REPLACEMENT_CHARACTER = 65533;
    public static final String SDOCX_CONDITION = "sdoc.filePath LIKE '%.sdocx'";
    public static final int SPLIT_TASK_UNIT = 500;
    public static final String UNLOCKED_CONDITION = "sdoc.isLock = 0";
    public static final String USED_DOCUMENT_CONDITION = "sdoc.isDeleted = 0";
    public static final String USED_FOLDER_CONDITION = "category_tree.isDeleted = 0";
}
