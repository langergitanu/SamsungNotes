package com.samsung.android.support.senl.p148nt.data.database.core.sync.entity;

import androidx.annotation.NonNull;
import androidx.glance.AbstractC2821a;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import com.samsung.android.support.senl.p148nt.base.common.constants.DataBaseConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.SyncDBSchema;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Entity(indices = {@Index(unique = true, value = {SyncDBSchema.SyncInfo.CLIENT_ID})}, tableName = SyncDBSchema.SyncInfo.TABLE_NAME)
public class SyncInfoEntity implements Cloneable {

    @ColumnInfo(defaultValue = "0", name = SyncDBSchema.SyncInfo.CLIENT_MODIFIED_TIME)
    private long clientModifiedTime;

    @ColumnInfo(defaultValue = "0", name = SyncDBSchema.SyncInfo.CLIENT_MODIFIED_TIME_FOLDER)
    private long clientModifiedTimeFolder;

    @ColumnInfo(name = SyncDBSchema.SyncInfo.COEDIT_RESOURCE_ID)
    private String coeditResourceId;

    @ColumnInfo(name = SyncDBSchema.SyncInfo.COMMIT_ID)
    private String commitId;

    @ColumnInfo(defaultValue = "0", name = "conflict")
    private int conflict;

    @ColumnInfo(defaultValue = "0", name = SyncDBSchema.SyncInfo.CONFLICT_STRATEGY)
    private int conflictStrategy;

    @ColumnInfo(name = "deviceName")
    private String deviceName;

    /* JADX INFO: renamed from: id */
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    private Long f7421id;

    @ColumnInfo(defaultValue = "1", name = SyncDBSchema.SyncInfo.IS_DIRTY_FOLDER)
    private int isDirtyFolder;

    @ColumnInfo(defaultValue = "0", name = SyncDBSchema.SyncInfo.IS_EXTRA_INFO_DIRTY)
    private int isExtraInfoDirty;

    @ColumnInfo(defaultValue = "0", name = "isSyncFailed")
    private int isSyncFailed;

    @ColumnInfo(defaultValue = "0", name = SyncDBSchema.SyncInfo.LAST_MODIFIED_TIME_FOLDER)
    private long lastModifiedTimeFolder;

    @ColumnInfo(name = "serverId")
    private String noteServerId;

    @ColumnInfo(defaultValue = "0", name = SyncDBSchema.SyncInfo.STROKE_GROUPED)
    private int strokeGrouped;

    @NonNull
    @ColumnInfo(name = SyncDBSchema.SyncInfo.CLIENT_ID)
    private String noteClientId = "";

    @ColumnInfo(defaultValue = "-1", name = SyncDBSchema.SyncInfo.COEDIT_CHECKPOINT)
    private long coeditCheckPoint = -1;

    @ColumnInfo(defaultValue = "0", name = SyncDBSchema.SyncInfo.SYNC_STATE)
    private long syncState = 0;

    @ColumnInfo(defaultValue = "0", name = "deletedBy")
    @DataBaseConstants.DeletedBy
    private int deletedBy = 0;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public @interface ConflictStrategy {
        public static final int BACKUP_AND_REPLACE = 2;
        public static final int CANCEL = 3;
        public static final int NONE = 0;
        public static final int REPLACE = 1;
    }

    public long getClientModifiedTime() {
        return this.clientModifiedTime;
    }

    public long getClientModifiedTimeFolder() {
        return this.clientModifiedTimeFolder;
    }

    public long getCoeditCheckPoint() {
        return this.coeditCheckPoint;
    }

    public String getCoeditResourceId() {
        return this.coeditResourceId;
    }

    public String getCommitId() {
        return this.commitId;
    }

    public int getConflict() {
        return this.conflict;
    }

    @ConflictStrategy
    public int getConflictStrategy() {
        return this.conflictStrategy;
    }

    @DataBaseConstants.DeletedBy
    public int getDeletedBy() {
        return this.deletedBy;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public Long getId() {
        return this.f7421id;
    }

    public int getIsDirtyFolder() {
        return this.isDirtyFolder;
    }

    public int getIsExtraInfoDirty() {
        return this.isExtraInfoDirty;
    }

    public int getIsSyncFailed() {
        return this.isSyncFailed;
    }

    public long getLastModifiedTimeFolder() {
        return this.lastModifiedTimeFolder;
    }

    @NonNull
    public String getNoteClientId() {
        return this.noteClientId;
    }

    public String getNoteServerId() {
        return this.noteServerId;
    }

    public int getStrokeGrouped() {
        return this.strokeGrouped;
    }

    public long getSyncState() {
        return this.syncState;
    }

    public void setClientModifiedTime(long j) {
        this.clientModifiedTime = j;
    }

    public void setClientModifiedTimeFolder(long j) {
        this.clientModifiedTimeFolder = j;
    }

    public void setCoeditCheckPoint(long j) {
        this.coeditCheckPoint = j;
    }

    public void setCoeditResourceId(String str) {
        this.coeditResourceId = str;
    }

    public void setCommitId(String str) {
        this.commitId = str;
    }

    public void setConflict(int i) {
        this.conflict = i;
    }

    public void setConflictStrategy(@ConflictStrategy int i) {
        this.conflictStrategy = i;
    }

    public void setDeletedBy(@DataBaseConstants.DeletedBy int i) {
        this.deletedBy = i;
    }

    public void setDeviceName(String str) {
        this.deviceName = str;
    }

    public void setId(Long l) {
        this.f7421id = l;
    }

    public void setIsDirtyFolder(int i) {
        this.isDirtyFolder = i;
    }

    public void setIsExtraInfoDirty(int i) {
        this.isExtraInfoDirty = i;
    }

    public void setIsSyncFailed(int i) {
        this.isSyncFailed = i;
    }

    public void setLastModifiedTimeFolder(long j) {
        this.lastModifiedTimeFolder = j;
    }

    public void setNoteClientId(@NonNull String str) {
        this.noteClientId = str;
    }

    public void setNoteServerId(String str) {
        this.noteServerId = str;
    }

    public void setStrokeGrouped(int i) {
        this.strokeGrouped = i;
    }

    public void setSyncState(long j) {
        this.syncState = j;
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder("SyncInfoEntity{id=");
        sb.append(this.f7421id);
        sb.append(", noteServerId='");
        sb.append(this.noteServerId);
        sb.append("', noteClientId='");
        sb.append(this.noteClientId);
        sb.append("', clientModifiedTime=");
        sb.append(this.clientModifiedTime);
        sb.append(", isDirtyFolder=");
        sb.append(this.isDirtyFolder);
        sb.append(", clientModifiedTimeFolder=");
        sb.append(this.clientModifiedTimeFolder);
        sb.append(", lastModifiedTimeFolder=");
        sb.append(this.lastModifiedTimeFolder);
        sb.append(", isSyncFailed=");
        sb.append(this.isSyncFailed);
        sb.append(", isExtraInfoDirty=");
        sb.append(this.isExtraInfoDirty);
        sb.append(", syncState=");
        sb.append(this.syncState);
        sb.append(", commitId='");
        sb.append(this.commitId);
        sb.append("', deviceName=");
        sb.append(this.deviceName);
        sb.append(", strokeGrouped=");
        sb.append(this.strokeGrouped);
        sb.append(", conflict=");
        sb.append(this.conflict);
        sb.append(", conflictStrategy=");
        return AbstractC2821a.m2223n(sb, "}", this.conflictStrategy);
    }

    @NonNull
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public SyncInfoEntity m22195clone() {
        return (SyncInfoEntity) super.clone();
    }
}
