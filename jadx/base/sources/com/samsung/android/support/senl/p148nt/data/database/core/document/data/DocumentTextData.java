package com.samsung.android.support.senl.p148nt.data.database.core.document.data;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DocumentTextData {

    @NonNull
    @ColumnInfo(name = "UUID")
    private String uuid = "";

    @NonNull
    @ColumnInfo(defaultValue = "", name = "title")
    private String title = "";

    @NonNull
    @ColumnInfo(defaultValue = "", name = "strippedContent", typeAffinity = 5)
    private String strippedContent = "";

    @NonNull
    public String getStrippedContent() {
        return this.strippedContent;
    }

    @NonNull
    public String getTitle() {
        return this.title;
    }

    @NonNull
    public String getUuid() {
        return this.uuid;
    }

    public void setStrippedContent(@NonNull String str) {
        this.strippedContent = str;
    }

    public void setTitle(String str) {
        if (str == null) {
            str = "";
        }
        this.title = str;
    }

    public void setUuid(@NonNull String str) {
        this.uuid = str;
    }
}
