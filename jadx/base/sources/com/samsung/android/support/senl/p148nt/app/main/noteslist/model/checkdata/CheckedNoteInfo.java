package com.samsung.android.support.senl.p148nt.app.main.noteslist.model.checkdata;

import android.os.Parcel;
import android.os.Parcelable;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class CheckedNoteInfo implements Parcelable {
    public static final Parcelable.Creator<CheckedNoteInfo> CREATOR = new Parcelable.Creator<CheckedNoteInfo>() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.model.checkdata.CheckedNoteInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CheckedNoteInfo createFromParcel(Parcel parcel) {
            return new CheckedNoteInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CheckedNoteInfo[] newArray(int i) {
            return new CheckedNoteInfo[i];
        }
    };
    private final int corrupted;
    private final long createdTime;
    private final String docUuid;
    private final String filePath;
    private final String folderUuid;
    private final int formatVersion;
    private final int getHasSticky;
    private final boolean isCoverEnabled;
    private final boolean isFavorite;
    private final boolean isLock;
    private final boolean isSdoc;
    private final int lockType;
    private final long modifiedTime;
    private final int pageMode;
    private final String title;
    private final int unknownMinVersion;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CheckInfoBuilder {
        private int corrupted;
        private long createdTime;
        private final String docUuid;
        private String filePath;
        private String folderUuid;
        private int formatVersion;
        private int getHasSticky;
        private boolean isCoverEnabled;
        private boolean isFavorite;
        private boolean isSdoc;
        private int lockType;
        private long modifiedTime;
        private int pageMode;
        private String title;
        private int unknownMinVersion;

        public CheckInfoBuilder(String str) {
            this.docUuid = str;
        }

        public CheckedNoteInfo build() {
            return new CheckedNoteInfo(this);
        }

        public CheckInfoBuilder setCorrupted(int i) {
            this.corrupted = i;
            return this;
        }

        public CheckInfoBuilder setCreatedTime(long j) {
            this.createdTime = j;
            return this;
        }

        public CheckInfoBuilder setFilePath(String str) {
            this.filePath = str;
            return this;
        }

        public CheckInfoBuilder setFolderUuid(String str) {
            this.folderUuid = str;
            return this;
        }

        public CheckInfoBuilder setFormatVersion(int i) {
            this.formatVersion = i;
            return this;
        }

        public CheckInfoBuilder setGetHasSticky(int i) {
            this.getHasSticky = i;
            return this;
        }

        public CheckInfoBuilder setIsCoverEnabled(boolean z) {
            this.isCoverEnabled = z;
            return this;
        }

        public CheckInfoBuilder setIsFavorite(boolean z) {
            this.isFavorite = z;
            return this;
        }

        public CheckInfoBuilder setIsSdoc(boolean z) {
            this.isSdoc = z;
            return this;
        }

        public CheckInfoBuilder setLockType(int i) {
            this.lockType = i;
            return this;
        }

        public CheckInfoBuilder setModifiedTime(long j) {
            this.modifiedTime = j;
            return this;
        }

        public CheckInfoBuilder setPageMode(int i) {
            this.pageMode = i;
            return this;
        }

        public CheckInfoBuilder setTitle(String str) {
            this.title = str;
            return this;
        }

        public CheckInfoBuilder setUnknownMinVersion(int i) {
            this.unknownMinVersion = i;
            return this;
        }
    }

    public CheckedNoteInfo(CheckInfoBuilder checkInfoBuilder) {
        this.docUuid = checkInfoBuilder.docUuid;
        this.folderUuid = checkInfoBuilder.folderUuid;
        this.filePath = checkInfoBuilder.filePath;
        this.title = checkInfoBuilder.title;
        this.isSdoc = checkInfoBuilder.isSdoc;
        this.isFavorite = checkInfoBuilder.isFavorite;
        this.corrupted = checkInfoBuilder.corrupted;
        int i = checkInfoBuilder.lockType;
        this.lockType = i;
        this.createdTime = checkInfoBuilder.createdTime;
        this.modifiedTime = checkInfoBuilder.modifiedTime;
        this.isLock = NotesUtils.isLock(i);
        this.pageMode = checkInfoBuilder.pageMode;
        this.unknownMinVersion = checkInfoBuilder.unknownMinVersion;
        this.formatVersion = checkInfoBuilder.formatVersion;
        this.isCoverEnabled = checkInfoBuilder.isCoverEnabled;
        this.getHasSticky = checkInfoBuilder.getHasSticky;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCorrupted() {
        return this.corrupted;
    }

    public long getCreatedTime() {
        return this.createdTime;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public String getFolderUuid() {
        return this.folderUuid;
    }

    public int getFormatVersion() {
        return this.formatVersion;
    }

    public int getHasSticky() {
        return this.getHasSticky;
    }

    public int getLockType() {
        return this.lockType;
    }

    public long getModifiedTime() {
        return this.modifiedTime;
    }

    public int getPageMode() {
        return this.pageMode;
    }

    public String getTitle() {
        return this.title;
    }

    public int getUnknownMinVersion() {
        return this.unknownMinVersion;
    }

    public String getUuid() {
        return this.docUuid;
    }

    public boolean isCoverEnabled() {
        return this.isCoverEnabled;
    }

    public boolean isFavorite() {
        return this.isFavorite;
    }

    public boolean isLock() {
        return this.isLock;
    }

    public boolean isSdoc() {
        return this.isSdoc;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.docUuid);
        parcel.writeString(this.folderUuid);
        parcel.writeString(this.filePath);
        parcel.writeString(this.title);
        parcel.writeInt(this.isSdoc ? 1 : 0);
        parcel.writeInt(this.isFavorite ? 1 : 0);
        parcel.writeInt(this.corrupted);
        parcel.writeInt(this.lockType);
        parcel.writeLong(this.createdTime);
        parcel.writeLong(this.modifiedTime);
        parcel.writeInt(this.pageMode);
        parcel.writeInt(this.unknownMinVersion);
        parcel.writeInt(this.formatVersion);
        parcel.writeInt(this.isCoverEnabled ? 1 : 0);
        parcel.writeInt(this.getHasSticky);
    }

    public CheckedNoteInfo(Parcel parcel) {
        this.docUuid = parcel.readString();
        this.folderUuid = parcel.readString();
        this.filePath = parcel.readString();
        this.title = parcel.readString();
        this.isSdoc = parcel.readInt() != 0;
        this.isFavorite = parcel.readInt() != 0;
        this.corrupted = parcel.readInt();
        int i = parcel.readInt();
        this.lockType = i;
        this.createdTime = parcel.readLong();
        this.modifiedTime = parcel.readLong();
        this.isLock = NotesUtils.isLock(i);
        this.pageMode = parcel.readInt();
        this.unknownMinVersion = parcel.readInt();
        this.formatVersion = parcel.readInt();
        this.isCoverEnabled = parcel.readInt() != 0;
        this.getHasSticky = parcel.readInt();
    }
}
