package com.samsung.android.support.senl.p148nt.data.database.core.sync;

import com.samsung.android.support.senl.p148nt.data.common.constants.CategoryConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class FolderNodeItem {
    public static final String SYNC_SDOCX_FOLDER_NODE_TYPE_FOLDER = "folder";
    public static final String SYNC_SDOCX_FOLDER_NODE_TYPE_NOTE = "note";
    public static final String SYNC_WDOC_FOLDER_NODE_STATE_NORMAL = "normal";
    public static final String SYNC_WDOC_FOLDER_NODE_STATE_TRASHED = "trashed";
    public String categoryUuid;
    public long createdTime;
    public boolean deleted;
    public int isCategoryDirty;
    public int isDeleted;
    public int isDirty;
    public int isSyncWithMS;
    public long lastModifiedTime;
    public String name;
    public String parentFolderNodeId;
    public long recycleBinMovedTime;
    public String restorePath;
    public String state;
    public long syncModifiedTime;
    public String type;
    public String uUid;
    public int displayNameColor = -1;
    public int reorder = CategoryConstants.DEFAULT_REORDER;
}
