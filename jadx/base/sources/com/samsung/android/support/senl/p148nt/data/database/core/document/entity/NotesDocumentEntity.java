package com.samsung.android.support.senl.p148nt.data.database.core.document.entity;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Entity(indices = {@Index(unique = true, value = {"UUID"}), @Index({"filePath"}), @Index({"isFavorite"}), @Index({"categoryUUID", "isDeleted"}), @Index({"importedAt"})}, tableName = "sdoc")
public class NotesDocumentEntity extends AbsNotesDocumentEntity {
    public static final Parcelable.Creator<NotesDocumentEntity> CREATOR = new Parcelable.Creator<NotesDocumentEntity>() { // from class: com.samsung.android.support.senl.nt.data.database.core.document.entity.NotesDocumentEntity.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NotesDocumentEntity createFromParcel(Parcel parcel) {
            return new NotesDocumentEntity(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NotesDocumentEntity[] newArray(int i) {
            return new NotesDocumentEntity[i];
        }
    };

    @ColumnInfo(defaultValue = "", name = "accountName")
    private String accountName;

    @ColumnInfo(name = "accountType")
    private String accountType;

    @ColumnInfo(defaultValue = "1", name = DBSchema.Document.CATEGORY_IS_DIRTY)
    private int categoryIsDirty;

    @ColumnInfo(defaultValue = "1464416139847", name = DBSchema.Document.CATEGORY_SERVER_TIMESTAMP)
    private Long categoryServerTimeStamp;

    @ColumnInfo(defaultValue = "0", name = DBSchema.Document.MATH_MODE)
    private int mathMode;

    @ColumnInfo(defaultValue = "0", name = DBSchema.Document.MS_LAST_SYNC_TIME)
    private long msLastSyncTime;

    @ColumnInfo(name = DBSchema.Document.MS_SYNC_ACCOUNT_ID)
    private String msSyncAccountId;

    @ColumnInfo(name = DBSchema.Document.MS_SYNC_DOCUMENT_UUID)
    private String msSyncDocumentUuid;

    @NonNull
    @ColumnInfo(defaultValue = "", name = DBSchema.Document.NOTENAME)
    private String noteName;

    @ColumnInfo(defaultValue = "1464416139847", name = "serverTimestamp")
    private Long serverTimestamp;

    @NonNull
    @ColumnInfo(defaultValue = "", name = "strippedContent", typeAffinity = 5)
    private String strippedContent;

    public NotesDocumentEntity() {
        this.accountName = "";
        this.strippedContent = "";
        this.serverTimestamp = 1464416139847L;
        this.categoryServerTimeStamp = 1464416139847L;
        this.categoryIsDirty = 1;
        this.noteName = "";
        this.msLastSyncTime = 0L;
        this.mathMode = 0;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.entity.AbsNotesDocumentEntity
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof NotesDocumentEntity) {
            NotesDocumentEntity notesDocumentEntity = (NotesDocumentEntity) obj;
            if (super.equals(obj) && getCategoryIsDirty() == notesDocumentEntity.getCategoryIsDirty() && getMsLastSyncTime() == notesDocumentEntity.getMsLastSyncTime() && Objects.equals(getAccountType(), notesDocumentEntity.getAccountType()) && Objects.equals(getAccountName(), notesDocumentEntity.getAccountName()) && Objects.equals(getServerTimestamp(), notesDocumentEntity.getServerTimestamp()) && Objects.equals(getCategoryServerTimeStamp(), notesDocumentEntity.getCategoryServerTimeStamp()) && Objects.equals(getNoteName(), notesDocumentEntity.getNoteName()) && Objects.equals(getMsSyncAccountId(), notesDocumentEntity.getMsSyncAccountId()) && Objects.equals(getMsSyncDocumentUuid(), notesDocumentEntity.getMsSyncDocumentUuid()) && Integer.valueOf(getMathMode()).equals(Integer.valueOf(notesDocumentEntity.getMathMode()))) {
                return true;
            }
        }
        return false;
    }

    public String getAccountName() {
        return this.accountName;
    }

    public String getAccountType() {
        return this.accountType;
    }

    public int getCategoryIsDirty() {
        return this.categoryIsDirty;
    }

    public Long getCategoryServerTimeStamp() {
        return this.categoryServerTimeStamp;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.entity.AbsNotesDocumentEntity
    public String getDebugInfo() {
        return super.getDebugInfo().concat(", accountType='" + this.accountType + "', accountName='" + DataLogger.pii(this.accountName) + "', noteName='" + this.noteName + "', mathMode='" + this.mathMode + '\'');
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.entity.AbsNotesDocumentEntity
    public String getInfo() {
        String info = super.getInfo();
        StringBuilder sb = new StringBuilder(", serverTimestamp=");
        sb.append(this.serverTimestamp);
        sb.append(", categoryServerTimeStamp=");
        sb.append(this.categoryServerTimeStamp);
        sb.append(", categoryIsDirty=");
        sb.append(this.categoryIsDirty);
        sb.append(", msSyncAccountId=");
        sb.append(DataLogger.pii(this.msSyncAccountId));
        sb.append(", msSyncDocumentUuid=");
        AbstractC11014a.m12336u(this.msSyncDocumentUuid, sb, ", msLastSyncTime=");
        sb.append(this.msLastSyncTime);
        return info.concat(sb.toString());
    }

    public int getMathMode() {
        return this.mathMode;
    }

    public long getMsLastSyncTime() {
        return this.msLastSyncTime;
    }

    public String getMsSyncAccountId() {
        return this.msSyncAccountId;
    }

    public String getMsSyncDocumentUuid() {
        return this.msSyncDocumentUuid;
    }

    @NonNull
    public String getNoteName() {
        return this.noteName;
    }

    public Long getServerTimestamp() {
        return this.serverTimestamp;
    }

    @NonNull
    public String getStrippedContent() {
        return this.strippedContent;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.entity.AbsNotesDocumentEntity
    public int hashCode() {
        return Objects.hash(Integer.valueOf(super.hashCode()), this.accountType, this.accountName, this.serverTimestamp, this.categoryServerTimeStamp, Integer.valueOf(this.categoryIsDirty), this.noteName, this.msSyncAccountId, this.msSyncDocumentUuid, Long.valueOf(this.msLastSyncTime), Integer.valueOf(this.mathMode));
    }

    public void setAccountName(String str) {
        this.accountName = str;
    }

    public void setAccountType(String str) {
        this.accountType = str;
    }

    public void setCategoryIsDirty(int i) {
        this.categoryIsDirty = i;
    }

    public void setCategoryServerTimeStamp(Long l) {
        this.categoryServerTimeStamp = l;
    }

    public void setMathMode(int i) {
        this.mathMode = i;
    }

    public void setMsLastSyncTime(long j) {
        this.msLastSyncTime = j;
    }

    public void setMsSyncAccountId(String str) {
        this.msSyncAccountId = str;
    }

    public void setMsSyncDocumentUuid(String str) {
        this.msSyncDocumentUuid = str;
    }

    public void setNoteName(@NonNull String str) {
        this.noteName = str;
    }

    public void setServerTimestamp(Long l) {
        this.serverTimestamp = l;
    }

    public void setStrippedContent(@NonNull String str) {
        this.strippedContent = str;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.entity.AbsNotesDocumentEntity, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.accountType);
        parcel.writeString(this.accountName);
        if (this.serverTimestamp == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeLong(this.serverTimestamp.longValue());
        }
        if (this.categoryServerTimeStamp == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeLong(this.categoryServerTimeStamp.longValue());
        }
        parcel.writeInt(this.categoryIsDirty);
        parcel.writeString(this.noteName);
        parcel.writeString(this.msSyncAccountId);
        parcel.writeString(this.msSyncDocumentUuid);
        parcel.writeLong(this.msLastSyncTime);
        parcel.writeInt(this.mathMode);
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.entity.AbsNotesDocumentEntity
    @NonNull
    /* JADX INFO: renamed from: clone */
    public NotesDocumentEntity mo22193clone() {
        return (NotesDocumentEntity) super.mo22193clone();
    }

    public NotesDocumentEntity(Parcel parcel) {
        super(parcel);
        this.accountName = "";
        this.strippedContent = "";
        this.serverTimestamp = 1464416139847L;
        this.categoryServerTimeStamp = 1464416139847L;
        this.categoryIsDirty = 1;
        this.noteName = "";
        this.msLastSyncTime = 0L;
        this.mathMode = 0;
        this.accountType = parcel.readString();
        this.accountName = parcel.readString();
        if (parcel.readByte() == 0) {
            this.serverTimestamp = null;
        } else {
            this.serverTimestamp = Long.valueOf(parcel.readLong());
        }
        if (parcel.readByte() == 0) {
            this.categoryServerTimeStamp = null;
        } else {
            this.categoryServerTimeStamp = Long.valueOf(parcel.readLong());
        }
        this.categoryIsDirty = parcel.readInt();
        this.noteName = parcel.readString();
        this.msSyncAccountId = parcel.readString();
        this.msSyncDocumentUuid = parcel.readString();
        this.msLastSyncTime = parcel.readLong();
        this.mathMode = parcel.readInt();
    }
}
