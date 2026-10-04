package com.samsung.android.support.senl.p148nt.app.main.common.data;

import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class MainEntryParam {
    private int corrupted;
    private String docTitle;
    private String fileExtension;
    private String filePath;
    private String folderUuid;
    private String groupId;
    private String guid;
    private String highLightText;
    private int isDeleted;
    private boolean isSdoc;
    private long lastModifiedAt;
    private int lockType;
    private String mdeOwnerId;
    private int modeIndex;
    private String oldUuid = "";
    private int requestCode;
    private long size;
    private String spaceId;
    private long syncState;
    private int toolType;
    private String uiTitle;
    private String uuid;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Builder {
        private MainEntryParam mainEntryParam;

        public Builder() {
            if (this.mainEntryParam == null) {
                this.mainEntryParam = new MainEntryParam();
            }
        }

        public MainEntryParam build() {
            return this.mainEntryParam;
        }

        public Builder setDeleted(int i) {
            this.mainEntryParam.setDeleted(i);
            return this;
        }

        public Builder setDocumentData(MainListDocumentData mainListDocumentData) {
            this.mainEntryParam.setUuid(mainListDocumentData.getUuid());
            this.mainEntryParam.setFolderUuid(mainListDocumentData.getCategoryUuid());
            this.mainEntryParam.setFilePath(mainListDocumentData.getFilePath());
            this.mainEntryParam.setFileExtension(mainListDocumentData.getFileExtension());
            this.mainEntryParam.setGroupId(mainListDocumentData.getMdeGroupId());
            this.mainEntryParam.setSpaceId(mainListDocumentData.getMdeSpaceId());
            this.mainEntryParam.setMdeOwnerId(mainListDocumentData.getMdeOwnerId());
            this.mainEntryParam.setDocTitle(mainListDocumentData.getTitle());
            this.mainEntryParam.setLastModifiedAt(mainListDocumentData.getLastModifiedAt());
            this.mainEntryParam.setSyncState(mainListDocumentData.getSyncState());
            this.mainEntryParam.setSdoc(mainListDocumentData.isSDoc());
            this.mainEntryParam.setDeleted(mainListDocumentData.getIsDeleted());
            this.mainEntryParam.setLockType(mainListDocumentData.getIsLock());
            this.mainEntryParam.setCorrupted(mainListDocumentData.getCorrupted());
            this.mainEntryParam.setSize(mainListDocumentData.getSize());
            return this;
        }

        public Builder setFilePath(String str) {
            this.mainEntryParam.setFilePath(str);
            return this;
        }

        public Builder setFolderUuid(String str) {
            this.mainEntryParam.setFolderUuid(str);
            return this;
        }

        public Builder setGuid(String str) {
            this.mainEntryParam.setGuid(str);
            return this;
        }

        public Builder setLastModifiedAt(long j) {
            this.mainEntryParam.setLastModifiedAt(j);
            return this;
        }

        public Builder setLockType(int i) {
            this.mainEntryParam.setLockType(i);
            return this;
        }

        public Builder setModeIndex(int i) {
            this.mainEntryParam.setModeIndex(i);
            return this;
        }

        public Builder setOldUuid(String str) {
            this.mainEntryParam.setOldUuid(str);
            return this;
        }

        public Builder setRequestCode(int i) {
            this.mainEntryParam.setRequestCode(i);
            return this;
        }

        public Builder setSdoc(boolean z) {
            this.mainEntryParam.setSdoc(z);
            return this;
        }

        public Builder setTitle(String str) {
            this.mainEntryParam.setDocTitle(str);
            return this;
        }

        public Builder setToolType(int i) {
            this.mainEntryParam.setToolType(i);
            return this;
        }

        public Builder setUuid(String str) {
            this.mainEntryParam.setUuid(str);
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDeleted(int i) {
        this.isDeleted = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDocTitle(String str) {
        this.docTitle = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFileExtension(String str) {
        this.fileExtension = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFilePath(@NonNull String str) {
        this.filePath = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFolderUuid(String str) {
        this.folderUuid = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGroupId(String str) {
        this.groupId = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGuid(String str) {
        this.guid = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLastModifiedAt(long j) {
        this.lastModifiedAt = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLockType(int i) {
        this.lockType = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMdeOwnerId(String str) {
        this.mdeOwnerId = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRequestCode(int i) {
        this.requestCode = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSdoc(boolean z) {
        this.isSdoc = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSpaceId(String str) {
        this.spaceId = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUuid(@NonNull String str) {
        this.uuid = str;
    }

    public int getCorrupted() {
        return this.corrupted;
    }

    public String getDocTitle() {
        return this.docTitle;
    }

    public String getFileExtension() {
        return this.fileExtension;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public String getFolderUuid() {
        return this.folderUuid;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public String getGuid() {
        return this.guid;
    }

    public String getHighLightText() {
        return this.highLightText;
    }

    public int getIsDeleted() {
        return this.isDeleted;
    }

    public long getLastModifiedAt() {
        return this.lastModifiedAt;
    }

    public int getLockType() {
        return this.lockType;
    }

    public String getMdeOwnerId() {
        return this.mdeOwnerId;
    }

    public int getModeIndex() {
        return this.modeIndex;
    }

    public String getOldUuid() {
        return this.oldUuid;
    }

    public int getRequestCode() {
        return this.requestCode;
    }

    public long getSize() {
        return this.size;
    }

    public String getSpaceId() {
        return this.spaceId;
    }

    public long getSyncState() {
        return this.syncState;
    }

    public int getToolType() {
        return this.toolType;
    }

    public String getUiTitle() {
        return this.uiTitle;
    }

    public String getUuid() {
        return this.uuid;
    }

    public boolean isSdoc() {
        return this.isSdoc;
    }

    public void setCorrupted(int i) {
        this.corrupted = i;
    }

    public void setHighLightText(String str) {
        this.highLightText = str;
    }

    public void setModeIndex(int i) {
        this.modeIndex = i;
    }

    public void setOldUuid(String str) {
        this.oldUuid = str;
    }

    public void setSize(long j) {
        this.size = j;
    }

    public void setSyncState(long j) {
        this.syncState = j;
    }

    public void setToolType(int i) {
        this.toolType = i;
    }

    public void setUiTitle(String str) {
        this.uiTitle = str;
    }
}
