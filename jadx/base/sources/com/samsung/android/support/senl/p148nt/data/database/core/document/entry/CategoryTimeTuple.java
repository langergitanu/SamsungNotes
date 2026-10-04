package com.samsung.android.support.senl.p148nt.data.database.core.document.entry;

import androidx.room.ColumnInfo;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CategoryTimeTuple {

    @ColumnInfo(name = "UUID")
    public String categoryUuid;

    @ColumnInfo(name = "serverTimestamp")
    public Long time;

    public CategoryTimeTuple(Long l, String str) {
        this.time = l;
        this.categoryUuid = str;
    }
}
