package com.samsung.android.support.senl.p148nt.data.database.core.document.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverConstants;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Entity(foreignKeys = {@ForeignKey(childColumns = {"documentUUID"}, entity = NotesDocumentEntity.class, onDelete = 5, parentColumns = {"UUID"})}, tableName = "suggested_cover")
public class SuggestedCoverEntity {
    private static final String TAG = DataLogger.createTag("SuggestedCoverEntity");

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "documentUUID")
    private String docUuid = "";

    @ColumnInfo(defaultValue = "0", name = "state")
    private int state = 0;

    @NonNull
    public String getDocUuid() {
        return this.docUuid;
    }

    @CoverConstants.SuggestedState
    public int getState() {
        return this.state;
    }

    public void setDocUuid(@NonNull String str) {
        this.docUuid = str;
    }

    public void setState(@CoverConstants.SuggestedState int i) {
        this.state = i;
    }

    public void setState(int i, String str) {
        DataLogger.m12302d(TAG, "setState# state : " + i + ", caller : " + str);
        setState(i);
    }
}
