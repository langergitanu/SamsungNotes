package com.samsung.android.app.notes.sync.items;

import android.util.Pair;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class ImportItem implements Serializable {
    public static final String ALREADY_IMPORTED = "already_imported";
    public static final String CATEGORY_ORDER = "category_order";
    public static final String CONTAINER_NAME = "container_name";
    public static final String CONTENT = "content";
    public static final String DOWNLOAD_COMPLETED = "download_completed";
    public static final String EXTRAOBJECT = "EXTRAOBJECT";
    public static final int FILE_LOCATION_LOCAL_INTERNAL = 101;
    public static final int FILE_LOCATION_LOCAL_MICROSD = 103;
    public static final int FILE_LOCATION_SERVER = 102;
    public static final String ITEM_TYPE = "item_type";
    public static final int ITEM_TYPE_ETC = 35;
    public static final int ITEM_TYPE_MEMO_NMEMO = 11;
    public static final int ITEM_TYPE_MEMO_SCLOUD = 10;
    public static final int ITEM_TYPE_MEMO_SMEMO2 = 12;
    public static final int ITEM_TYPE_MEMO_TMEMO2 = 13;
    public static final int ITEM_TYPE_NOTE = 20;
    public static final int ITEM_TYPE_QMEMO = 36;
    public static final int ITEM_TYPE_SCRAPBOOK_SCLOUD = 33;
    public static final int ITEM_TYPE_SDOC = 30;
    public static final int ITEM_TYPE_SDOCX_SCLOUD = 31;
    public static final int ITEM_TYPE_TMEMO1 = 32;
    public static final String LOCATION_FULL_PATH = "location_full_path";
    public static final String LOCATION_TYPE = "location_type";
    public static final String REMOVE_ON_CONVERTED = "remove_on_converted";
    public static final String REPLACED = "replaced";
    public static final String SERVER_KEY = "server_key";
    private static final String TAG = "ImportItem";
    public static final String TIME_STAMP = "time_stamp";
    public static final String TITLE = "title";
    private static final long serialVersionUID = 1;
    private boolean mAlreadyImported;
    private String mCategoryOrder;
    private long mCategoryServerTimeStamp;
    private String mCategoryUUID;
    private boolean mChangeUUID;
    private String mContainerName;
    private String mContent;
    private long mCreatedTime;
    private int mDeleteType;
    private boolean mDownloadCompleted;
    private Object mExtraObject;
    private boolean mFavorite;
    private int mItemType;
    private String mLocalFullPath;
    private int mLocationType;
    private int mLockState;
    private boolean mNeedCopyToExternal;
    private boolean mNeedToCopySDoc;
    private String mOwnerId;
    private boolean mRemoveOnConverted;
    private boolean mReplaced;
    private String mRestorePath;
    private String mRestoredUUID;
    private boolean mSaveNew;
    private boolean mSaveRecovery;
    private long mSaveTime;
    private String mServerKey;
    private long mServerTimeStamp;
    private long mTimeStamp;
    private String mTitle;
    private Pair<String, String> mUuidPair;
    private int mWidgetID;
    private int mathMode;
    private long msLastSyncTime;
    private String msSyncAccountId;
    private String msSyncDocumentid;
    private long recycleBinTimeMoved;

    public ImportItem() {
        this.mContainerName = "";
        this.mTitle = "";
        this.mContent = "";
        this.mTimeStamp = 0L;
        this.mServerKey = "";
        this.mLocalFullPath = "";
        this.mDownloadCompleted = false;
        this.mRemoveOnConverted = false;
        this.mAlreadyImported = false;
        this.mReplaced = false;
        this.mCategoryOrder = null;
        this.mFavorite = false;
        this.mCategoryUUID = "";
        this.mCategoryServerTimeStamp = 0L;
        this.mServerTimeStamp = 0L;
        this.mSaveNew = false;
        this.mSaveRecovery = false;
        this.mChangeUUID = false;
        this.mNeedToCopySDoc = false;
        this.mLockState = 0;
        this.mSaveTime = 0L;
        this.mCreatedTime = 0L;
        this.mWidgetID = 0;
        this.mRestoredUUID = "";
        this.mOwnerId = "";
        this.mDeleteType = 0;
        this.mRestorePath = "";
    }

    public String getCategoryOrder() {
        return this.mCategoryOrder;
    }

    public long getCategoryServerTimeStamp() {
        return this.mCategoryServerTimeStamp;
    }

    public String getCategoryUUID() {
        return this.mCategoryUUID;
    }

    public boolean getChangeUUIDFlag() {
        return this.mChangeUUID;
    }

    public String getContainerName() {
        return this.mContainerName;
    }

    public String getContent() {
        return this.mContent;
    }

    public long getCreatedTime() {
        return this.mCreatedTime;
    }

    public int getDeleteType() {
        return this.mDeleteType;
    }

    public boolean getDownloadCompleted() {
        return this.mDownloadCompleted;
    }

    public Object getExtraObject() {
        return this.mExtraObject;
    }

    public boolean getFavorite() {
        return this.mFavorite;
    }

    public int getItemType() {
        return this.mItemType;
    }

    public String getLocalFullPath() {
        return this.mLocalFullPath;
    }

    public int getLocationType() {
        return this.mLocationType;
    }

    public int getLockState() {
        return this.mLockState;
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

    public String getMsSyncDocumentid() {
        return this.msSyncDocumentid;
    }

    public boolean getNeedCopyToExternal() {
        return this.mNeedCopyToExternal;
    }

    public boolean getNeedToCopySDocFlag() {
        return this.mNeedToCopySDoc;
    }

    public String getOwnerId() {
        return this.mOwnerId;
    }

    public long getRecycleBinTimeMoved() {
        return this.recycleBinTimeMoved;
    }

    public boolean getRemoveOnConverted() {
        return this.mRemoveOnConverted;
    }

    public String getRestorePath() {
        return this.mRestorePath;
    }

    public String getRestoredUUID() {
        return this.mRestoredUUID;
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

    public long getTimeStamp() {
        return this.mTimeStamp;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public Pair<String, String> getUuidPair() {
        if (this.mUuidPair == null) {
            this.mUuidPair = new Pair<>(getServerKey(), getServerKey());
        }
        return this.mUuidPair;
    }

    public int getWidgetID() {
        return this.mWidgetID;
    }

    public boolean isAlreadyImported() {
        return this.mAlreadyImported;
    }

    public boolean isReplaced() {
        return this.mReplaced;
    }

    public void setAlreadyImported(boolean z) {
        this.mAlreadyImported = z;
    }

    public void setCategoryOrder(String str) {
        this.mCategoryOrder = str;
    }

    public void setCategoryServerTimeStamp(long j) {
        this.mCategoryServerTimeStamp = j;
    }

    public void setCategoryUUID(String str) {
        this.mCategoryUUID = str;
    }

    public void setChangeUUIDFlag(boolean z) {
        this.mChangeUUID = z;
    }

    public void setContainerName(String str) {
        this.mContainerName = str;
    }

    public void setContent(String str) {
        this.mContent = str;
    }

    public void setCreatedTime(long j) {
        this.mCreatedTime = j;
    }

    public void setDeleteType(int i) {
        this.mDeleteType = i;
    }

    public void setDownloadCompleted(boolean z) {
        this.mDownloadCompleted = z;
    }

    public void setExtraObject(Object obj) {
        this.mExtraObject = obj;
    }

    public void setFavorite(boolean z) {
        this.mFavorite = z;
    }

    public void setItemType(int i) {
        this.mItemType = i;
    }

    public void setLocalFullPath(String str) {
        this.mLocalFullPath = str;
    }

    public void setLocationType(int i) {
        this.mLocationType = i;
    }

    public void setLockState(int i) {
        this.mLockState = i;
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

    public void setMsSyncDocumentid(String str) {
        this.msSyncDocumentid = str;
    }

    public void setNeedCopyToExternal(boolean z) {
        this.mNeedCopyToExternal = z;
    }

    public void setNeedToCopySDocFlag(boolean z) {
        this.mNeedToCopySDoc = z;
    }

    public void setOwnerId(String str) {
        this.mOwnerId = str;
    }

    public void setRecycleBinTimeMoved(long j) {
        this.recycleBinTimeMoved = j;
    }

    public void setRemoveOnConverted(boolean z) {
        this.mRemoveOnConverted = z;
    }

    public void setReplaced(boolean z) {
        this.mReplaced = z;
    }

    public void setRestorePath(String str) {
        this.mRestorePath = str;
    }

    public void setRestoredUUID(String str) {
        this.mRestoredUUID = str;
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

    public void setTimeStamp(long j) {
        this.mTimeStamp = j;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public void setUuidPair(String str, String str2) {
        this.mUuidPair = new Pair<>(str, str2);
    }

    public void setWidgetID(int i) {
        this.mWidgetID = i;
    }

    public ImportItem(int i) {
        this.mContainerName = "";
        this.mTitle = "";
        this.mContent = "";
        this.mTimeStamp = 0L;
        this.mServerKey = "";
        this.mLocalFullPath = "";
        this.mDownloadCompleted = false;
        this.mRemoveOnConverted = false;
        this.mAlreadyImported = false;
        this.mReplaced = false;
        this.mCategoryOrder = null;
        this.mFavorite = false;
        this.mCategoryUUID = "";
        this.mCategoryServerTimeStamp = 0L;
        this.mServerTimeStamp = 0L;
        this.mSaveNew = false;
        this.mSaveRecovery = false;
        this.mChangeUUID = false;
        this.mNeedToCopySDoc = false;
        this.mLockState = 0;
        this.mSaveTime = 0L;
        this.mCreatedTime = 0L;
        this.mWidgetID = 0;
        this.mRestoredUUID = "";
        this.mOwnerId = "";
        this.mDeleteType = 0;
        this.mRestorePath = "";
        this.mItemType = i;
    }

    public ImportItem(int i, String str, String str2, long j, String str3) {
        this.mTitle = "";
        this.mLocalFullPath = "";
        this.mDownloadCompleted = false;
        this.mRemoveOnConverted = false;
        this.mReplaced = false;
        this.mCategoryOrder = null;
        this.mFavorite = false;
        this.mCategoryUUID = "";
        this.mCategoryServerTimeStamp = 0L;
        this.mServerTimeStamp = 0L;
        this.mSaveNew = false;
        this.mSaveRecovery = false;
        this.mChangeUUID = false;
        this.mNeedToCopySDoc = false;
        this.mLockState = 0;
        this.mSaveTime = 0L;
        this.mCreatedTime = 0L;
        this.mWidgetID = 0;
        this.mRestoredUUID = "";
        this.mOwnerId = "";
        this.mDeleteType = 0;
        this.mRestorePath = "";
        this.mItemType = i;
        this.mContainerName = str;
        this.mContent = str2;
        this.mTimeStamp = j;
        this.mServerKey = str3;
        this.mLocationType = 102;
        this.mAlreadyImported = false;
    }

    public ImportItem(int i, String str, String str2, long j, String str3, boolean z) {
        this.mTitle = "";
        this.mLocalFullPath = "";
        this.mDownloadCompleted = false;
        this.mRemoveOnConverted = false;
        this.mReplaced = false;
        this.mCategoryOrder = null;
        this.mFavorite = false;
        this.mCategoryUUID = "";
        this.mCategoryServerTimeStamp = 0L;
        this.mServerTimeStamp = 0L;
        this.mSaveNew = false;
        this.mSaveRecovery = false;
        this.mChangeUUID = false;
        this.mNeedToCopySDoc = false;
        this.mLockState = 0;
        this.mSaveTime = 0L;
        this.mCreatedTime = 0L;
        this.mWidgetID = 0;
        this.mRestoredUUID = "";
        this.mOwnerId = "";
        this.mDeleteType = 0;
        this.mRestorePath = "";
        this.mItemType = i;
        this.mContainerName = str;
        this.mContent = str2;
        this.mTimeStamp = j;
        this.mServerKey = str3;
        this.mLocationType = 102;
        this.mAlreadyImported = z;
    }
}
