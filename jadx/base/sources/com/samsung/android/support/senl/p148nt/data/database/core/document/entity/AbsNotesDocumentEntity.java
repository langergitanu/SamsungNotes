package com.samsung.android.support.senl.p148nt.data.database.core.document.entity;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import com.samsung.android.support.senl.p145cm.base.common.constants.LockType;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.DeleteType;
import com.samsung.android.support.senl.p148nt.data.common.constants.DocumentExtension;
import com.samsung.android.support.senl.p148nt.data.common.constants.DocumentExtensionUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.PageMode;
import com.samsung.android.support.senl.p148nt.data.common.constants.TimeSaveParam;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbsNotesDocumentEntity implements Cloneable, Parcelable {
    private static final String TAG = DataLogger.createTag("AbsNotesDocumentEntity");

    @ColumnInfo(name = DBSchema.Document.ABSOLUTE_PATH)
    private String absolutePath;

    @ColumnInfo(defaultValue = "0", name = "backgroundColor")
    private int backgroundColor;

    @ColumnInfo(defaultValue = "0", name = DBSchema.Document.BACKGROUND_COLOR_INVERTED)
    private int backgroundColorInverted;

    @NonNull
    @ColumnInfo(defaultValue = "uncategorized:///", name = "categoryUUID")
    private String categoryUuid;

    @NonNull
    @ColumnInfo(defaultValue = "", name = "content", typeAffinity = 5)
    private String content;

    @ColumnInfo(defaultValue = "0", name = "contentSecureVersion")
    private int contentSecureVersion;

    @ColumnInfo(defaultValue = "", name = DBSchema.Document.CONTENT_UUID)
    private String contentUuid;

    @ColumnInfo(defaultValue = "0", name = DBSchema.Document.CORRUPTED)
    private int corrupted;

    @ColumnInfo(name = "createdAt")
    private long createdAt;

    @ColumnInfo(defaultValue = "0", name = "deleteRecommended")
    private int deleteRecommended;

    @Ignore
    private boolean dirtySkipped;

    @NonNull
    @ColumnInfo(name = "displayContent", typeAffinity = 5)
    private byte[] displayContent;

    @ColumnInfo(name = "displayTitle", typeAffinity = 5)
    private byte[] displayTitle;

    @DocumentExtension
    @Ignore
    private String fileExtension;

    @NonNull
    @ColumnInfo(name = "filePath")
    private String filePath;

    @ColumnInfo(defaultValue = "0", name = "firstContentType")
    private Integer firstContentType;

    @ColumnInfo(defaultValue = "0", name = "firstHandwritingHeight")
    private int firstHandwritingHeight;

    @ColumnInfo(defaultValue = "0", name = "firstOpendAt")
    private long firstOpendAt;

    /* JADX INFO: renamed from: id */
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    private Long f7387id;

    @ColumnInfo(defaultValue = "0", name = "importedAt")
    private long importedAt;

    @ColumnInfo(defaultValue = "0", name = "isDeleted")
    private int isDeleted;

    @ColumnInfo(defaultValue = "1", name = "isDirty")
    private int isDirty;

    @ColumnInfo(defaultValue = "0", name = "isFavorite")
    private int isFavorite;

    @Ignore
    private boolean isImported;

    @ColumnInfo(defaultValue = "0", name = "isLock")
    @LockType
    private int isLock;

    @ColumnInfo(defaultValue = "0", name = "isSaving")
    private int isSavingByWhichPid;

    @Ignore
    private boolean isSynced;

    @Ignore
    private boolean keepServerTimestamp;

    @ColumnInfo(defaultValue = "0", name = DBSchema.Document.LAST_MAPPED_AT)
    private long lastMappedAt;

    @ColumnInfo(name = "lastModifiedAt")
    private long lastModifiedAt;

    @ColumnInfo(defaultValue = "0", name = "lastOpenedAt")
    private long lastOpenedAt;

    @ColumnInfo(name = DBSchema.Document.LOCK_ACCOUNT_GUID)
    private String lockAccountGuid;

    @NonNull
    @ColumnInfo(defaultValue = "", name = "mdeExtra")
    private String mdeExtra;

    @NonNull
    @ColumnInfo(defaultValue = "", name = "mdeGroupId")
    private String mdeGroupId;

    @NonNull
    @ColumnInfo(defaultValue = "", name = "mdeItemId")
    private String mdeItemId;

    @NonNull
    @ColumnInfo(defaultValue = "", name = "mdeOwnerId")
    private String mdeOwnerId;

    @NonNull
    @ColumnInfo(defaultValue = "", name = "mdeSpaceId")
    private String mdeSpaceId;

    @Ignore
    private String originUuid;

    @ColumnInfo(defaultValue = "0", name = DBSchema.Document.PAGE_MODE)
    private int pageMode;

    @ColumnInfo(defaultValue = "0", name = "recommendedAt")
    private long recommendedAt;

    @NonNull
    @ColumnInfo(defaultValue = "", name = DBSchema.Document.RECOMMENDED_TITLE)
    private String recommendedTitle;

    @ColumnInfo(defaultValue = "0", name = "recycle_bin_time_moved")
    private long recycleBinTimeMoved;

    @ColumnInfo(defaultValue = "0", name = "reminderRequestCode")
    private int reminderRequestCode;

    @ColumnInfo(defaultValue = "0", name = "reminderTriggerTime")
    private long reminderTriggerTime;

    @Ignore
    private boolean removeActionLinkData;

    @ColumnInfo(defaultValue = "0", name = "saveType")
    private int saveType;

    @ColumnInfo(defaultValue = "0", name = "secondContentType")
    private Integer secondContentType;

    @ColumnInfo(defaultValue = "0", name = "secondOpenedAt")
    private long secondOpenedAt;

    @Ignore
    private String serverId;

    @ColumnInfo(defaultValue = "0", name = "size")
    private long size;

    @ColumnInfo(defaultValue = "0.0", name = "strokeRatio", typeAffinity = 4)
    private Float strokeRatio;

    @ColumnInfo(defaultValue = "", name = "strokeUUID")
    private String strokeUuid;

    @Ignore
    private final TimeSaveParam timeSaveParam;

    @NonNull
    @ColumnInfo(defaultValue = "", name = "title")
    private String title;

    @Ignore
    private boolean updateContents;

    @Ignore
    private boolean updateStrokeInWorkerThread;

    @Ignore
    private boolean updateStrokeSearchData;

    @NonNull
    @ColumnInfo(name = "UUID")
    private String uuid;

    @ColumnInfo(defaultValue = "", name = DBSchema.Document.VR_UUID)
    private String vrUuid;

    @Ignore
    private int widgetId;

    public AbsNotesDocumentEntity() {
        this.uuid = "";
        this.isDeleted = 0;
        this.isDirty = 1;
        this.title = "";
        this.recommendedTitle = "";
        this.content = "";
        this.displayContent = new byte[0];
        this.createdAt = 0L;
        this.lastModifiedAt = 0L;
        this.vrUuid = "";
        this.contentUuid = "";
        this.firstContentType = 0;
        this.secondContentType = 0;
        this.strokeUuid = "";
        this.strokeRatio = Float.valueOf(0.0f);
        this.categoryUuid = "uncategorized:///";
        this.filePath = "";
        this.isFavorite = 0;
        this.isLock = 0;
        this.isSavingByWhichPid = 0;
        this.reminderTriggerTime = 0L;
        this.reminderRequestCode = 0;
        this.recycleBinTimeMoved = 0L;
        this.contentSecureVersion = 0;
        this.size = 0L;
        this.displayTitle = new byte[0];
        this.saveType = 0;
        this.firstOpendAt = 0L;
        this.secondOpenedAt = 0L;
        this.lastOpenedAt = 0L;
        this.importedAt = 0L;
        this.recommendedAt = 0L;
        this.lastMappedAt = 0L;
        this.mdeSpaceId = "";
        this.mdeItemId = "";
        this.mdeExtra = "";
        this.mdeGroupId = "";
        this.mdeOwnerId = "";
        this.firstHandwritingHeight = 0;
        this.deleteRecommended = 0;
        this.absolutePath = "";
        this.backgroundColor = 0;
        this.backgroundColorInverted = 0;
        this.corrupted = 0;
        this.pageMode = 0;
        this.updateStrokeSearchData = true;
        this.dirtySkipped = false;
        this.widgetId = -1;
        this.keepServerTimestamp = false;
        this.timeSaveParam = new TimeSaveParam();
        this.updateStrokeInWorkerThread = true;
        this.updateContents = true;
        this.originUuid = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AbsNotesDocumentEntity)) {
            return false;
        }
        AbsNotesDocumentEntity absNotesDocumentEntity = (AbsNotesDocumentEntity) obj;
        return getIsDeleted() == absNotesDocumentEntity.getIsDeleted() && getIsDirty() == absNotesDocumentEntity.getIsDirty() && getCreatedAt() == absNotesDocumentEntity.getCreatedAt() && getLastModifiedAt() == absNotesDocumentEntity.getLastModifiedAt() && getIsFavorite() == absNotesDocumentEntity.getIsFavorite() && getIsLock() == absNotesDocumentEntity.getIsLock() && getCorrupted() == absNotesDocumentEntity.getCorrupted() && getReminderTriggerTime() == absNotesDocumentEntity.getReminderTriggerTime() && getReminderRequestCode() == absNotesDocumentEntity.getReminderRequestCode() && getRecycleBinTimeMoved() == absNotesDocumentEntity.getRecycleBinTimeMoved() && getContentSecureVersion() == absNotesDocumentEntity.getContentSecureVersion() && getFirstOpendAt() == absNotesDocumentEntity.getFirstOpendAt() && getSecondOpenedAt() == absNotesDocumentEntity.getSecondOpenedAt() && getLastOpenedAt() == absNotesDocumentEntity.getLastOpenedAt() && getImportedAt() == absNotesDocumentEntity.getImportedAt() && getRecommendedAt() == absNotesDocumentEntity.getRecommendedAt() && getLastMappedAt() == absNotesDocumentEntity.getLastMappedAt() && getFirstHandwritingHeight() == absNotesDocumentEntity.getFirstHandwritingHeight() && isImported() == absNotesDocumentEntity.isImported() && isRemoveActionLinkData() == absNotesDocumentEntity.isRemoveActionLinkData() && getBackgroundColor() == absNotesDocumentEntity.getBackgroundColor() && getBackgroundColorInverted() == absNotesDocumentEntity.getBackgroundColorInverted() && getPageMode() == absNotesDocumentEntity.getPageMode() && Objects.equals(getTitle(), absNotesDocumentEntity.getTitle()) && Objects.equals(getVrUuid(), absNotesDocumentEntity.getVrUuid()) && Objects.equals(getContentUuid(), absNotesDocumentEntity.getContentUuid()) && Objects.equals(getFirstContentType(), absNotesDocumentEntity.getFirstContentType()) && Objects.equals(getSecondContentType(), absNotesDocumentEntity.getSecondContentType()) && Objects.equals(getStrokeUuid(), absNotesDocumentEntity.getStrokeUuid()) && Objects.equals(getStrokeRatio(), absNotesDocumentEntity.getStrokeRatio()) && Objects.equals(getCategoryUuid(), absNotesDocumentEntity.getCategoryUuid()) && Objects.equals(getFilePath(), absNotesDocumentEntity.getFilePath()) && Objects.equals(getRecommendedTitle(), absNotesDocumentEntity.getRecommendedTitle()) && Objects.equals(getLockAccountGuid(), absNotesDocumentEntity.getLockAccountGuid());
    }

    public String getAbsolutePath() {
        return this.absolutePath;
    }

    public int getBackgroundColor() {
        return this.backgroundColor;
    }

    public int getBackgroundColorInverted() {
        return this.backgroundColorInverted;
    }

    @NonNull
    public String getCategoryUuid() {
        return this.categoryUuid;
    }

    public String getContent() {
        String str = this.content;
        return str == null ? "" : str;
    }

    public int getContentSecureVersion() {
        return this.contentSecureVersion;
    }

    public String getContentUuid() {
        return this.contentUuid;
    }

    public int getCorrupted() {
        return this.corrupted;
    }

    public long getCreatedAt() {
        return this.createdAt;
    }

    public String getDebugInfo() {
        return ", vrUuid='" + this.vrUuid + "', strokeUuid='" + this.strokeUuid + "', widgetId=" + this.widgetId + ", isSavingByWhichPid=" + this.isSavingByWhichPid + ", backgroundColor=" + this.backgroundColor + ", backgroundColorInverted=" + this.backgroundColorInverted + ", contentUuid='" + this.contentUuid + "', firstContentType=" + this.firstContentType + ", secondContentType=" + this.secondContentType + ", strokeRatio=" + this.strokeRatio + ", reminderTriggerTime=" + this.reminderTriggerTime + ", reminderRequestCode=" + this.reminderRequestCode + ", contentSecureVersion=" + this.contentSecureVersion + ", size=" + this.size + ", firstOpendAt=" + this.firstOpendAt + ", secondOpenedAt=" + this.secondOpenedAt + ", lastOpenedAt=" + this.lastOpenedAt + ", importedAt=" + this.importedAt + ", recommendedAt=" + this.recommendedAt + ", mdeSpaceId='" + this.mdeSpaceId + "', mdeItemId='" + this.mdeItemId + "', mdeExtra='" + this.mdeExtra + "', mdeGroupId='" + this.mdeGroupId + "', mdeOwnerId='" + this.mdeOwnerId + "', firstHandwritingHeight=" + this.firstHandwritingHeight + ", deleteRecommended=" + this.deleteRecommended + ", isImported=" + this.isImported + ", removeActionLinkData=" + this.removeActionLinkData + ", updateStrokeSearchData=" + this.updateStrokeSearchData + ", dirtySkipped=" + this.dirtySkipped;
    }

    public int getDeleteRecommended() {
        return this.deleteRecommended;
    }

    public byte[] getDisplayContent() {
        return this.displayContent;
    }

    public byte[] getDisplayTitle() {
        return this.displayTitle;
    }

    public String getFileExtension() {
        if (this.fileExtension == null) {
            setFileExtension(DocumentExtensionUtils.getExtension(getFilePath()));
        }
        return this.fileExtension;
    }

    @NonNull
    public String getFilePath() {
        return this.filePath;
    }

    public Integer getFirstContentType() {
        return this.firstContentType;
    }

    public int getFirstHandwritingHeight() {
        return this.firstHandwritingHeight;
    }

    public long getFirstOpendAt() {
        return this.firstOpendAt;
    }

    public Long getId() {
        return this.f7387id;
    }

    public long getImportedAt() {
        return this.importedAt;
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder("id=");
        sb.append(this.f7387id);
        sb.append(", uuid='");
        sb.append(this.uuid);
        sb.append("', originUuid='");
        sb.append(this.originUuid);
        sb.append("', isDeleted=");
        sb.append(this.isDeleted);
        sb.append(", isDirty=");
        sb.append(this.isDirty);
        sb.append(", title='");
        AbstractC11014a.m12336u(this.title, sb, "', recommendedTitle='");
        AbstractC11014a.m12336u(this.recommendedTitle, sb, "', pageMode='");
        sb.append(this.pageMode);
        sb.append(", createdAt=");
        sb.append(this.createdAt);
        sb.append(", lastModifiedAt=");
        sb.append(this.lastModifiedAt);
        sb.append(", lastMappedAt=");
        sb.append(this.lastMappedAt);
        sb.append(", categoryUuid='");
        sb.append(this.categoryUuid);
        sb.append("', recycleBinTimeMoved=");
        sb.append(this.recycleBinTimeMoved);
        sb.append(", filePath='");
        AbstractC11014a.m12336u(this.filePath, sb, "', isFavorite=");
        sb.append(this.isFavorite);
        sb.append(", isLock=");
        sb.append(this.isLock);
        sb.append(", corrupted=");
        sb.append(this.corrupted);
        sb.append(", lockAccountGuid=");
        sb.append(DataLogger.pii(this.lockAccountGuid));
        return sb.toString();
    }

    @DeleteType
    public int getIsDeleted() {
        return this.isDeleted;
    }

    public int getIsDirty() {
        return this.isDirty;
    }

    public int getIsFavorite() {
        return this.isFavorite;
    }

    @LockType
    public int getIsLock() {
        return this.isLock;
    }

    public int getIsSavingByWhichPid() {
        return this.isSavingByWhichPid;
    }

    public boolean getIsSynced() {
        return this.isSynced;
    }

    public boolean getKeepServerTimestamp() {
        return this.keepServerTimestamp;
    }

    public long getLastMappedAt() {
        return this.lastMappedAt;
    }

    public long getLastModifiedAt() {
        return this.lastModifiedAt;
    }

    public long getLastOpenedAt() {
        return this.lastOpenedAt;
    }

    public String getLockAccountGuid() {
        return this.lockAccountGuid;
    }

    @NonNull
    public String getMdeExtra() {
        return this.mdeExtra;
    }

    @NonNull
    public String getMdeGroupId() {
        return this.mdeGroupId;
    }

    @NonNull
    public String getMdeItemId() {
        return this.mdeItemId;
    }

    @NonNull
    public String getMdeOwnerId() {
        return this.mdeOwnerId;
    }

    @NonNull
    public String getMdeSpaceId() {
        return this.mdeSpaceId;
    }

    public String getOriginUuid() {
        return this.originUuid;
    }

    @PageMode
    public int getPageMode() {
        return this.pageMode;
    }

    public long getRecommendedAt() {
        return this.recommendedAt;
    }

    @NonNull
    public String getRecommendedTitle() {
        return this.recommendedTitle;
    }

    public long getRecycleBinTimeMoved() {
        return this.recycleBinTimeMoved;
    }

    public int getReminderRequestCode() {
        return this.reminderRequestCode;
    }

    public long getReminderTriggerTime() {
        return this.reminderTriggerTime;
    }

    public int getSaveType() {
        return this.saveType;
    }

    public Integer getSecondContentType() {
        return this.secondContentType;
    }

    public long getSecondOpenedAt() {
        return this.secondOpenedAt;
    }

    public String getServerId() {
        return this.serverId;
    }

    public long getSize() {
        return this.size;
    }

    public Float getStrokeRatio() {
        return this.strokeRatio;
    }

    public String getStrokeUuid() {
        return this.strokeUuid;
    }

    public TimeSaveParam getTimeSaveParam() {
        return this.timeSaveParam;
    }

    @NonNull
    public String getTitle() {
        return this.title;
    }

    @NonNull
    public String getUuid() {
        return this.uuid;
    }

    public String getVrUuid() {
        return this.vrUuid;
    }

    public int getWidgetId() {
        return this.widgetId;
    }

    public int hashCode() {
        return Arrays.hashCode(getDisplayTitle()) + ((Arrays.hashCode(getDisplayContent()) + (Objects.hash(getUuid(), Integer.valueOf(getIsDeleted()), Integer.valueOf(getIsDirty()), getTitle(), getRecommendedTitle(), getContent(), Long.valueOf(getCreatedAt()), Long.valueOf(getLastModifiedAt()), getVrUuid(), getContentUuid(), getFirstContentType(), getSecondContentType(), getStrokeUuid(), getStrokeRatio(), getCategoryUuid(), getFilePath(), Integer.valueOf(getIsFavorite()), Integer.valueOf(getIsLock()), Integer.valueOf(getCorrupted()), Integer.valueOf(getIsSavingByWhichPid()), Long.valueOf(getReminderTriggerTime()), Integer.valueOf(getReminderRequestCode()), Long.valueOf(getRecycleBinTimeMoved()), Integer.valueOf(getContentSecureVersion()), Long.valueOf(getSize()), Integer.valueOf(getSaveType()), Long.valueOf(getFirstOpendAt()), Long.valueOf(getSecondOpenedAt()), Long.valueOf(getLastOpenedAt()), Long.valueOf(getImportedAt()), Long.valueOf(getRecommendedAt()), Long.valueOf(getLastMappedAt()), getMdeSpaceId(), getMdeItemId(), getMdeExtra(), getMdeGroupId(), getMdeOwnerId(), Integer.valueOf(getFirstHandwritingHeight()), Integer.valueOf(getDeleteRecommended()), getAbsolutePath(), Integer.valueOf(getBackgroundColor()), Integer.valueOf(getBackgroundColorInverted()), Integer.valueOf(getPageMode()), getLockAccountGuid()) * 31)) * 31);
    }

    public boolean isDirtySkipped() {
        return this.dirtySkipped;
    }

    public boolean isImported() {
        return this.isImported;
    }

    public boolean isRemoveActionLinkData() {
        return this.removeActionLinkData;
    }

    public boolean isSdoc() {
        return ".sdoc".equals(getFileExtension());
    }

    public boolean isSdocx() {
        return ".sdocx".equals(getFileExtension());
    }

    public boolean isUpdateContents() {
        return this.updateContents;
    }

    public boolean isUpdateStrokeInWorkerThread() {
        return this.updateStrokeInWorkerThread;
    }

    public boolean isUpdateStrokeSearchData() {
        return this.updateStrokeSearchData;
    }

    public void setAbsolutePath(String str) {
        this.absolutePath = str;
    }

    public void setBackgroundColor(int i) {
        this.backgroundColor = i;
    }

    public void setBackgroundColorInverted(int i) {
        this.backgroundColorInverted = i;
    }

    public void setCategoryUuid(@NonNull String str) {
        this.categoryUuid = str;
    }

    public void setContent(@NonNull String str) {
        this.content = str;
    }

    public void setContentSecureVersion(int i) {
        this.contentSecureVersion = i;
    }

    public void setContentUuid(String str) {
        this.contentUuid = str;
    }

    public void setCorrupted(int i) {
        this.corrupted = i;
    }

    public void setCreatedAt(long j) {
        this.createdAt = j;
    }

    public void setDeleteRecommended(int i) {
        this.deleteRecommended = i;
    }

    public void setDirtySkipped(boolean z) {
        this.dirtySkipped = z;
    }

    public void setDisplayContent(@NonNull byte[] bArr) {
        if (bArr != null && bArr.length > 40960) {
            String str = TAG;
            DataLogger.m12305f(str, "setDisplayContent, byte: " + bArr.length);
            DataLogger.m12305f(str, "setDisplayContent, callee: " + CommonUtils.getCallee(Thread.currentThread().getStackTrace(), true));
            bArr = new byte[0];
        }
        this.displayContent = bArr;
    }

    public void setDisplayTitle(byte[] bArr) {
        this.displayTitle = bArr;
    }

    public void setFileExtension(String str) {
        this.fileExtension = str;
    }

    public void setFilePath(@NonNull String str) {
        this.filePath = str;
        setFileExtension(DocumentExtensionUtils.getExtension(str));
    }

    public void setFirstContentType(Integer num) {
        this.firstContentType = num;
    }

    public void setFirstHandwritingHeight(int i) {
        this.firstHandwritingHeight = i;
    }

    public void setFirstOpendAt(long j) {
        this.firstOpendAt = j;
    }

    public void setId(Long l) {
        this.f7387id = l;
    }

    public void setImported(boolean z) {
        this.isImported = z;
    }

    public void setImportedAt(long j) {
        this.importedAt = j;
    }

    public void setIsDeleted(@DeleteType int i) {
        this.isDeleted = i;
    }

    public void setIsDirty(int i) {
        this.isDirty = i;
    }

    public void setIsFavorite(int i) {
        this.isFavorite = i;
    }

    public void setIsLock(@LockType int i) {
        this.isLock = i;
    }

    public void setIsSavingByWhichPid(int i) {
        this.isSavingByWhichPid = i;
    }

    public void setIsSynced(boolean z) {
        this.isSynced = z;
    }

    public void setKeepServerTimestamp(boolean z) {
        this.keepServerTimestamp = z;
    }

    public void setLastMappedAt(long j) {
        this.lastMappedAt = j;
    }

    public void setLastModifiedAt(long j) {
        this.lastModifiedAt = j;
    }

    public void setLastOpenedAt(long j) {
        this.lastOpenedAt = j;
    }

    public void setLockAccountGuid(String str) {
        this.lockAccountGuid = str;
    }

    public void setMdeExtra(@NonNull String str) {
        this.mdeExtra = str;
    }

    public void setMdeGroupId(@NonNull String str) {
        this.mdeGroupId = str;
    }

    public void setMdeItemId(@NonNull String str) {
        this.mdeItemId = str;
    }

    public void setMdeOwnerId(@NonNull String str) {
        this.mdeOwnerId = str;
    }

    public void setMdeSpaceId(@NonNull String str) {
        this.mdeSpaceId = str;
    }

    public void setOriginUuid(String str) {
        this.originUuid = str;
    }

    public void setPageMode(@PageMode int i) {
        this.pageMode = i;
    }

    public void setRecommendedAt(long j) {
        this.recommendedAt = j;
    }

    public void setRecommendedTitle(String str) {
        if (str == null) {
            str = "";
        }
        this.recommendedTitle = str;
    }

    public void setRecycleBinTimeMoved(long j) {
        this.recycleBinTimeMoved = j;
    }

    public void setReminderRequestCode(int i) {
        this.reminderRequestCode = i;
    }

    public void setReminderTriggerTime(long j) {
        this.reminderTriggerTime = j;
    }

    public void setRemoveActionLinkData(boolean z) {
        this.removeActionLinkData = z;
    }

    public void setSaveType(int i) {
        this.saveType = i;
    }

    public void setSecondContentType(Integer num) {
        this.secondContentType = num;
    }

    public void setSecondOpenedAt(long j) {
        this.secondOpenedAt = j;
    }

    public void setServerId(String str) {
        this.serverId = str;
    }

    public void setSize(long j) {
        this.size = j;
    }

    public void setStrokeRatio(Float f) {
        this.strokeRatio = f;
    }

    public void setStrokeUuid(String str) {
        this.strokeUuid = str;
    }

    public void setTitle(String str) {
        if (str == null) {
            str = "";
        }
        this.title = str;
    }

    public void setUpdateContents(boolean z) {
        this.updateContents = z;
    }

    public void setUpdateStrokeInWorkerThread(boolean z) {
        this.updateStrokeInWorkerThread = z;
    }

    public void setUpdateStrokeSearchData(boolean z) {
        this.updateStrokeSearchData = z;
    }

    public void setUuid(@NonNull String str) {
        this.uuid = str;
    }

    public void setVrUuid(String str) {
        this.vrUuid = str;
    }

    public void setWidgetId(int i) {
        this.widgetId = i;
    }

    @NonNull
    public String toString() {
        return getClass().getSimpleName() + '{' + getInfo() + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (this.f7387id == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeLong(this.f7387id.longValue());
        }
        parcel.writeString(this.uuid);
        parcel.writeInt(this.isDeleted);
        parcel.writeInt(this.isDirty);
        parcel.writeString(this.title);
        parcel.writeString(this.content);
        parcel.writeByteArray(this.displayContent);
        parcel.writeLong(this.createdAt);
        parcel.writeLong(this.lastModifiedAt);
        parcel.writeString(this.vrUuid);
        parcel.writeString(this.contentUuid);
        if (this.firstContentType == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(this.firstContentType.intValue());
        }
        if (this.secondContentType == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(this.secondContentType.intValue());
        }
        parcel.writeString(this.strokeUuid);
        if (this.strokeRatio == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeFloat(this.strokeRatio.floatValue());
        }
        parcel.writeString(this.categoryUuid);
        parcel.writeString(this.filePath);
        parcel.writeInt(this.isFavorite);
        parcel.writeInt(this.isLock);
        parcel.writeInt(this.isSavingByWhichPid);
        parcel.writeLong(this.reminderTriggerTime);
        parcel.writeInt(this.reminderRequestCode);
        parcel.writeLong(this.recycleBinTimeMoved);
        parcel.writeInt(this.contentSecureVersion);
        parcel.writeInt((int) this.size);
        parcel.writeByteArray(this.displayTitle);
        parcel.writeInt(this.saveType);
        parcel.writeLong(this.firstOpendAt);
        parcel.writeLong(this.secondOpenedAt);
        parcel.writeLong(this.lastOpenedAt);
        parcel.writeLong(this.importedAt);
        parcel.writeLong(this.recommendedAt);
        parcel.writeString(this.mdeSpaceId);
        parcel.writeString(this.mdeItemId);
        parcel.writeString(this.mdeExtra);
        parcel.writeString(this.mdeGroupId);
        parcel.writeString(this.mdeOwnerId);
        parcel.writeInt(this.firstHandwritingHeight);
        parcel.writeInt(this.deleteRecommended);
        parcel.writeString(this.absolutePath);
        parcel.writeInt(this.backgroundColor);
        parcel.writeByte(this.isImported ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.removeActionLinkData ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.updateStrokeSearchData ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.dirtySkipped ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.widgetId);
        parcel.writeByte(this.keepServerTimestamp ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.updateStrokeInWorkerThread ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.updateContents ? (byte) 1 : (byte) 0);
        parcel.writeString(this.serverId);
        parcel.writeString(this.fileExtension);
        parcel.writeLong(this.lastMappedAt);
        parcel.writeByte(this.isSynced ? (byte) 1 : (byte) 0);
        parcel.writeString(this.recommendedTitle);
        parcel.writeInt(this.backgroundColorInverted);
        parcel.writeString(this.lockAccountGuid);
        parcel.writeInt(this.corrupted);
        parcel.writeInt(this.pageMode);
    }

    @Override // 
    @NonNull
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public AbsNotesDocumentEntity mo22193clone() {
        return (AbsNotesDocumentEntity) super.clone();
    }

    public AbsNotesDocumentEntity(Parcel parcel) {
        this.uuid = "";
        this.isDeleted = 0;
        this.isDirty = 1;
        this.title = "";
        this.recommendedTitle = "";
        this.content = "";
        this.displayContent = new byte[0];
        this.createdAt = 0L;
        this.lastModifiedAt = 0L;
        this.vrUuid = "";
        this.contentUuid = "";
        this.firstContentType = 0;
        this.secondContentType = 0;
        this.strokeUuid = "";
        this.strokeRatio = Float.valueOf(0.0f);
        this.categoryUuid = "uncategorized:///";
        this.filePath = "";
        this.isFavorite = 0;
        this.isLock = 0;
        this.isSavingByWhichPid = 0;
        this.reminderTriggerTime = 0L;
        this.reminderRequestCode = 0;
        this.recycleBinTimeMoved = 0L;
        this.contentSecureVersion = 0;
        this.size = 0L;
        this.displayTitle = new byte[0];
        this.saveType = 0;
        this.firstOpendAt = 0L;
        this.secondOpenedAt = 0L;
        this.lastOpenedAt = 0L;
        this.importedAt = 0L;
        this.recommendedAt = 0L;
        this.lastMappedAt = 0L;
        this.mdeSpaceId = "";
        this.mdeItemId = "";
        this.mdeExtra = "";
        this.mdeGroupId = "";
        this.mdeOwnerId = "";
        this.firstHandwritingHeight = 0;
        this.deleteRecommended = 0;
        this.absolutePath = "";
        this.backgroundColor = 0;
        this.backgroundColorInverted = 0;
        this.corrupted = 0;
        this.pageMode = 0;
        this.updateStrokeSearchData = true;
        this.dirtySkipped = false;
        this.widgetId = -1;
        this.keepServerTimestamp = false;
        this.timeSaveParam = new TimeSaveParam();
        this.updateStrokeInWorkerThread = true;
        this.updateContents = true;
        this.originUuid = null;
        if (parcel.readByte() == 0) {
            this.f7387id = null;
        } else {
            this.f7387id = Long.valueOf(parcel.readLong());
        }
        this.uuid = parcel.readString();
        this.isDeleted = parcel.readInt();
        this.isDirty = parcel.readInt();
        this.title = parcel.readString();
        this.content = parcel.readString();
        this.displayContent = parcel.createByteArray();
        this.createdAt = parcel.readLong();
        this.lastModifiedAt = parcel.readLong();
        this.vrUuid = parcel.readString();
        this.contentUuid = parcel.readString();
        if (parcel.readByte() == 0) {
            this.firstContentType = null;
        } else {
            this.firstContentType = Integer.valueOf(parcel.readInt());
        }
        if (parcel.readByte() == 0) {
            this.secondContentType = null;
        } else {
            this.secondContentType = Integer.valueOf(parcel.readInt());
        }
        this.strokeUuid = parcel.readString();
        if (parcel.readByte() == 0) {
            this.strokeRatio = null;
        } else {
            this.strokeRatio = Float.valueOf(parcel.readFloat());
        }
        this.categoryUuid = parcel.readString();
        this.filePath = parcel.readString();
        this.isFavorite = parcel.readInt();
        this.isLock = parcel.readInt();
        this.isSavingByWhichPid = parcel.readInt();
        this.reminderTriggerTime = parcel.readLong();
        this.reminderRequestCode = parcel.readInt();
        this.recycleBinTimeMoved = parcel.readLong();
        this.contentSecureVersion = parcel.readInt();
        this.size = parcel.readInt();
        this.displayTitle = parcel.createByteArray();
        this.saveType = parcel.readInt();
        this.firstOpendAt = parcel.readLong();
        this.secondOpenedAt = parcel.readLong();
        this.lastOpenedAt = parcel.readLong();
        this.importedAt = parcel.readLong();
        this.recommendedAt = parcel.readLong();
        this.mdeSpaceId = parcel.readString();
        this.mdeItemId = parcel.readString();
        this.mdeExtra = parcel.readString();
        this.mdeGroupId = parcel.readString();
        this.mdeOwnerId = parcel.readString();
        this.firstHandwritingHeight = parcel.readInt();
        this.deleteRecommended = parcel.readInt();
        this.absolutePath = parcel.readString();
        this.backgroundColor = parcel.readInt();
        this.isImported = parcel.readByte() != 0;
        this.removeActionLinkData = parcel.readByte() != 0;
        this.updateStrokeSearchData = parcel.readByte() != 0;
        this.dirtySkipped = parcel.readByte() != 0;
        this.widgetId = parcel.readInt();
        this.keepServerTimestamp = parcel.readByte() != 0;
        this.updateStrokeInWorkerThread = parcel.readByte() != 0;
        this.updateContents = parcel.readByte() != 0;
        this.serverId = parcel.readString();
        this.fileExtension = parcel.readString();
        this.lastMappedAt = parcel.readLong();
        this.isSynced = parcel.readByte() != 0;
        this.recommendedTitle = parcel.readString();
        this.backgroundColorInverted = parcel.readInt();
        this.lockAccountGuid = parcel.readString();
        this.corrupted = parcel.readInt();
        this.pageMode = parcel.readInt();
    }
}
