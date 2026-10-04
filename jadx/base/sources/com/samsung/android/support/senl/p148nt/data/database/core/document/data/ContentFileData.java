package com.samsung.android.support.senl.p148nt.data.database.core.document.data;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ContentFileData {

    @NonNull
    @ColumnInfo(name = "UUID")
    public String uuid = "";

    @NonNull
    @ColumnInfo(name = "sdocUUID")
    public String sdocUuid = "";

    @NonNull
    @ColumnInfo(name = "filePath")
    public String docPath = "";

    @NonNull
    @ColumnInfo(defaultValue = "", name = "contentPath")
    public String contentFilePath = "";

    @NonNull
    @ColumnInfo(defaultValue = "", name = "displayName")
    public String displayName = "";

    @NonNull
    @ColumnInfo(defaultValue = "application/octet-stream", name = "mime_type")
    public String mimeType = "application/octet-stream";

    @ColumnInfo(defaultValue = "0", name = "size")
    public long size = 0;

    @ColumnInfo(defaultValue = "0", name = "createdAt")
    public long createdAt = 0;
}
