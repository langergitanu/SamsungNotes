package com.samsung.android.support.senl.p148nt.model.importer.task;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ImportDocInfo {
    private long mMSLastSyncTime;
    private String mMSSyncAccountId;
    private String mMSSyncDocumentid;
    private int mMathMode;
    private boolean mNeedCopyToExternal;
    private long mRecycleBinTimeMoved;
    private String mTitle = "";
    private String mServerKey = "";
    private boolean mFavorite = false;
    private String mCategoryUuid = "";
    private long mCategoryServerTimeStamp = 0;
    private long mServerTimeStamp = 0;
    private boolean mSaveNew = false;
    private boolean mSaveRecovery = false;
    private boolean mChangeUuid = false;
    private int mLockState = 0;
    private long mSaveTime = 0;
    private long mCreatedTime = 0;
    private String mOwnerId = "";
    private int mDeleteType = 0;
    private String mRestorePath = "";

    public long getCategoryServerTimeStamp() {
        return this.mCategoryServerTimeStamp;
    }

    public String getCategoryUuid() {
        return this.mCategoryUuid;
    }

    public boolean getChangeUuidFlag() {
        return this.mChangeUuid;
    }

    public long getCreatedTime() {
        return this.mCreatedTime;
    }

    public int getDeleteType() {
        return this.mDeleteType;
    }

    public boolean getFavorite() {
        return this.mFavorite;
    }

    public int getLockState() {
        return this.mLockState;
    }

    public int getMathMode() {
        return this.mMathMode;
    }

    public long getMsLastSyncTime() {
        return this.mMSLastSyncTime;
    }

    public String getMsSyncAccountId() {
        return this.mMSSyncAccountId;
    }

    public String getMsSyncDocumentid() {
        return this.mMSSyncDocumentid;
    }

    public boolean getNeedCopyToExternal() {
        return this.mNeedCopyToExternal;
    }

    public String getOwnerId() {
        return this.mOwnerId;
    }

    public long getRecycleBinTimeMoved() {
        return this.mRecycleBinTimeMoved;
    }

    public String getRestorePath() {
        return this.mRestorePath;
    }

    public boolean getSaveNew() {
        return this.mSaveNew;
    }

    public boolean getSaveRecovery() {
        return this.mSaveRecovery;
    }

    public long getSaveTime() {
        return this.mSaveTime;
    }

    public String getServerKey() {
        return this.mServerKey;
    }

    public long getServerTimeStamp() {
        return this.mServerTimeStamp;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setCategoryServerTimeStamp(long j) {
        this.mCategoryServerTimeStamp = j;
    }

    public void setCategoryUuid(String str) {
        this.mCategoryUuid = str;
    }

    public void setChangeUuidFlag(boolean z) {
        this.mChangeUuid = z;
    }

    public void setCreatedTime(long j) {
        this.mCreatedTime = j;
    }

    public void setDeleteType(int i) {
        this.mDeleteType = i;
    }

    public void setFavorite(boolean z) {
        this.mFavorite = z;
    }

    public void setLockState(int i) {
        this.mLockState = i;
    }

    public void setMathMode(int i) {
        this.mMathMode = i;
    }

    public void setMsLastSyncTime(long j) {
        this.mMSLastSyncTime = j;
    }

    public void setMsSyncAccountId(String str) {
        this.mMSSyncAccountId = str;
    }

    public void setMsSyncDocumentid(String str) {
        this.mMSSyncDocumentid = str;
    }

    public void setNeedCopyToExternal(boolean z) {
        this.mNeedCopyToExternal = z;
    }

    public void setOwnerId(String str) {
        this.mOwnerId = str;
    }

    public void setRecycleBinTimeMoved(long j) {
        this.mRecycleBinTimeMoved = j;
    }

    public void setRestorePath(String str) {
        this.mRestorePath = str;
    }

    public void setSaveNew(boolean z) {
        this.mSaveNew = z;
    }

    public void setSaveRecovery(boolean z) {
        this.mSaveRecovery = z;
    }

    public void setSaveTime(long j) {
        this.mSaveTime = j;
    }

    public void setServerKey(String str) {
        this.mServerKey = str;
    }

    public void setServerTimeStamp(long j) {
        this.mServerTimeStamp = j;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }
}
