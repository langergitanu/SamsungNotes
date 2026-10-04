package com.samsung.android.support.senl.p148nt.data.database.core.document.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import com.samsung.android.support.senl.p148nt.data.common.constants.RetryState;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Entity(indices = {@Index({"state"})}, tableName = "retry")
public class NotesRetryEntity {

    /* JADX INFO: renamed from: id */
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    private Long f7394id;

    @ColumnInfo(name = "lastModifiedAt")
    private long lastModifiedAt;

    @ColumnInfo(defaultValue = "0", name = "recognitionCount")
    private int recognitionCount;

    @ColumnInfo(defaultValue = "0", name = "version")
    private int version;

    @NonNull
    @ColumnInfo(name = "sdocUUID")
    private String docUuid = "";

    @NonNull
    @ColumnInfo(name = "strokeFilePath")
    private String strokeFilePath = "";

    @ColumnInfo(defaultValue = "0", name = "state")
    private int state = 0;

    @NonNull
    public String getDocUuid() {
        return this.docUuid;
    }

    public Long getId() {
        return this.f7394id;
    }

    public long getLastModifiedAt() {
        return this.lastModifiedAt;
    }

    public int getRecognitionCount() {
        return this.recognitionCount;
    }

    @RetryState
    public int getState() {
        return this.state;
    }

    @NonNull
    public String getStrokeFilePath() {
        return this.strokeFilePath;
    }

    public int getVersion() {
        return this.version;
    }

    public void setDocUuid(@NonNull String str) {
        this.docUuid = str;
    }

    public void setId(Long l) {
        this.f7394id = l;
    }

    public void setLastModifiedAt(long j) {
        this.lastModifiedAt = j;
    }

    public void setRecognitionCount(int i) {
        this.recognitionCount = i;
    }

    public void setState(@RetryState int i) {
        this.state = i;
    }

    public void setStrokeFilePath(@NonNull String str) {
        this.strokeFilePath = str;
    }

    public void setVersion(int i) {
        this.version = i;
    }
}
