package com.samsung.android.support.senl.p148nt.data.database.core.document.data;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import com.samsung.android.support.senl.p145cm.base.common.constants.LockType;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.DataConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.DeleteType;
import com.samsung.android.support.senl.p148nt.data.common.constants.DocumentExtension;
import com.samsung.android.support.senl.p148nt.data.common.constants.DocumentExtensionUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.PageMode;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.SyncDBSchema;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Entity(tableName = "sdoc")
public class MainListDocumentData implements Parcelable {
    public static final Parcelable.Creator<MainListDocumentData> CREATOR = new Parcelable.Creator<MainListDocumentData>() { // from class: com.samsung.android.support.senl.nt.data.database.core.document.data.MainListDocumentData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MainListDocumentData createFromParcel(Parcel parcel) {
            return new MainListDocumentData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MainListDocumentData[] newArray(int i) {
            return new MainListDocumentData[i];
        }
    };

    @ColumnInfo(name = DBSchema.Document.ABSOLUTE_PATH)
    private String absolutePath;

    @ColumnInfo(defaultValue = "0", name = "backgroundColor")
    private int backgroundColor;

    @ColumnInfo(defaultValue = "0", name = DBSchema.Document.BACKGROUND_COLOR_INVERTED)
    private int backgroundColorInverted;

    @ColumnInfo(defaultValue = "0", name = DBSchema.DocumentThumbnail.BACKGROUND_TYPE)
    private int backgroundType;

    @NonNull
    @ColumnInfo(defaultValue = "uncategorized:///", name = "categoryUUID")
    private String categoryUuid;

    @NonNull
    @ColumnInfo(defaultValue = "", name = "content", typeAffinity = 5)
    private String content;

    @ColumnInfo(defaultValue = "", name = DBSchema.Document.CONTENT_UUID)
    private String contentUuid;

    @ColumnInfo(defaultValue = "0", name = DBSchema.Document.CORRUPTED)
    private int corrupted;

    @NonNull
    @ColumnInfo(defaultValue = "DEFAULT:///", name = "coverBackgroundColor")
    private String coverBackgroundColor;

    @NonNull
    @ColumnInfo(defaultValue = CoverStickerConstants.Category.NONE.UUID, name = "coverStickerUuid")
    private String coverStickerUuid;

    @ColumnInfo(defaultValue = "0", name = "coverSuggestedState")
    public int coverSuggestedState;

    @NonNull
    @ColumnInfo(defaultValue = "", name = ExternalDataConstants.Column.COVER_SUMMARY)
    private String coverSummary;

    @ColumnInfo(defaultValue = "0", name = "coverSummaryAlignment")
    private int coverSummaryAlignment;

    @NonNull
    @ColumnInfo(defaultValue = "DEFAULT:///", name = "coverTemplateUuid")
    private String coverTemplateUuid;

    @ColumnInfo(name = "createdAt")
    private long createdAt;

    @NonNull
    @ColumnInfo(name = "displayContent", typeAffinity = 5)
    private byte[] displayContent;

    @DocumentExtension
    @Ignore
    private String fileExtension;

    @NonNull
    @ColumnInfo(name = "filePath")
    private String filePath;

    @ColumnInfo(defaultValue = "0", name = "firstContentType")
    private Integer firstContentType;

    @ColumnInfo(defaultValue = "0", name = "firstOpendAt")
    private long firstOpenedAt;

    @ColumnInfo(defaultValue = "0", name = DBSchema.DocumentExtra.FORMAT_VERSION)
    private int formatVersion;

    @ColumnInfo(defaultValue = "0", name = DBSchema.DocumentExtra.HAS_STICKY)
    private int hasSticky;

    /* JADX INFO: renamed from: id */
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    private Long f7386id;

    @ColumnInfo(defaultValue = "", name = DBSchema.DocumentThumbnail.IMAGE_PATH)
    private String imagePath;

    @ColumnInfo(defaultValue = "1", name = "isCoverEnabled")
    private int isCoverEnabled;

    @ColumnInfo(defaultValue = "0", name = "isDeleted")
    private int isDeleted;

    @ColumnInfo(defaultValue = "1", name = "isDirty")
    private int isDirty;

    @ColumnInfo(defaultValue = "0", name = "isFavorite")
    private int isFavorite;

    @ColumnInfo(defaultValue = "0", name = "isLock")
    @LockType
    private int isLock;

    @ColumnInfo(defaultValue = "0", name = "isSaving")
    private int isSavingByWhichPid;

    @ColumnInfo(name = "lastModifiedAt")
    private long lastModifiedAt;

    @ColumnInfo(defaultValue = "0", name = DBSchema.DocumentThumbnail.LAYOUT)
    private int layout;

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

    @ColumnInfo(defaultValue = "0", name = DBSchema.Document.PAGE_MODE)
    private int pageMode;

    @ColumnInfo(defaultValue = "", name = DBSchema.DocumentThumbnail.PLAY_TIME)
    private String playTime;

    @NonNull
    @ColumnInfo(defaultValue = "", name = DBSchema.Document.RECOMMENDED_TITLE)
    private String recommendedTitle;

    @ColumnInfo(defaultValue = "0", name = "recycle_bin_time_moved")
    private long recycleBinTimeMoved;

    @ColumnInfo(defaultValue = "0", name = "secondContentType")
    private Integer secondContentType;

    @ColumnInfo(defaultValue = "0", name = "size")
    private long size;

    @ColumnInfo(defaultValue = "", name = "strokeUUID")
    private String strokeUuid;

    @ColumnInfo(defaultValue = "0", name = SyncDBSchema.SyncInfo.SYNC_STATE)
    private long syncState;

    @NonNull
    @ColumnInfo(defaultValue = "", name = "title")
    private String title;

    @ColumnInfo(defaultValue = "0", name = DBSchema.DocumentExtra.UNKNOWN_MIN_VERSION)
    private int unknownMinVersion;

    @NonNull
    @ColumnInfo(name = "UUID")
    private String uuid;

    @ColumnInfo(defaultValue = "", name = DBSchema.Document.VR_UUID)
    private String vrUuid;

    public MainListDocumentData() {
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
        this.categoryUuid = "uncategorized:///";
        this.filePath = "";
        this.isFavorite = 0;
        this.isLock = 0;
        this.isSavingByWhichPid = 0;
        this.recycleBinTimeMoved = 0L;
        this.firstOpenedAt = 0L;
        this.mdeSpaceId = "";
        this.mdeItemId = "";
        this.mdeGroupId = "";
        this.mdeOwnerId = "";
        this.absolutePath = "";
        this.backgroundColor = 0;
        this.backgroundColorInverted = 0;
        this.corrupted = 0;
        this.pageMode = 0;
        this.size = 0L;
        this.coverTemplateUuid = "DEFAULT:///";
        this.coverSummary = "";
        this.coverSummaryAlignment = 0;
        this.coverStickerUuid = CoverStickerConstants.Category.NONE.UUID;
        this.coverBackgroundColor = "DEFAULT:///";
        this.isCoverEnabled = 1;
        this.coverSuggestedState = 0;
        this.syncState = 0L;
        this.backgroundType = 0;
        this.layout = 0;
        this.imagePath = "";
        this.playTime = "";
    }

    private String getDebugInfo() {
        return ", vrUuid='" + this.vrUuid + "', strokeUuid='" + this.strokeUuid + "', isSavingByWhichPid=" + this.isSavingByWhichPid + ", backgroundColor=" + this.backgroundColor + ", backgroundColorInverted=" + this.backgroundColorInverted + ", contentUuid='" + this.contentUuid + "', firstContentType=" + this.firstContentType + ", secondContentType=" + this.secondContentType + ", firstOpenedAt=" + this.firstOpenedAt + ", mdeSpaceId='" + this.mdeSpaceId + "', mdeItemId='" + this.mdeItemId + "', mdeGroupId='" + this.mdeGroupId + "', mdeOwnerId='" + this.mdeOwnerId + "', hasSticky=" + this.hasSticky + ", background=" + this.backgroundType + ", layout=" + this.layout;
    }

    private String getInfo() {
        StringBuilder sb = new StringBuilder(", uuid='");
        sb.append(this.uuid);
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
        sb.append(", coverSummary: ");
        sb.append(this.coverSummary);
        sb.append(" [");
        sb.append(this.coverSummaryAlignment);
        sb.append("], coverSticker: ");
        sb.append(this.coverStickerUuid);
        sb.append(", coverTemplate: ");
        sb.append(this.coverTemplateUuid);
        sb.append(", coverEnabled: ");
        sb.append(this.isCoverEnabled);
        sb.append(", syncState: ");
        sb.append(this.syncState);
        sb.append(", size: ");
        sb.append(this.size);
        sb.append(", formatVersion: ");
        sb.append(this.formatVersion);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MainListDocumentData) {
            MainListDocumentData mainListDocumentData = (MainListDocumentData) obj;
            if (this.isDeleted == mainListDocumentData.isDeleted && this.isDirty == mainListDocumentData.isDirty && this.createdAt == mainListDocumentData.createdAt && this.lastModifiedAt == mainListDocumentData.lastModifiedAt && this.isFavorite == mainListDocumentData.isFavorite && this.isLock == mainListDocumentData.isLock && this.corrupted == mainListDocumentData.corrupted && this.recycleBinTimeMoved == mainListDocumentData.recycleBinTimeMoved && this.firstOpenedAt == mainListDocumentData.firstOpenedAt && this.backgroundColor == mainListDocumentData.backgroundColor && this.backgroundColorInverted == mainListDocumentData.backgroundColorInverted && this.pageMode == mainListDocumentData.pageMode && Objects.equals(this.title, mainListDocumentData.title) && Objects.equals(this.vrUuid, mainListDocumentData.vrUuid) && Objects.equals(this.contentUuid, mainListDocumentData.contentUuid) && Objects.equals(this.firstContentType, mainListDocumentData.firstContentType) && Objects.equals(this.secondContentType, mainListDocumentData.secondContentType) && Objects.equals(this.strokeUuid, mainListDocumentData.strokeUuid) && Objects.equals(getFilePath(), mainListDocumentData.getFilePath()) && Objects.equals(this.recommendedTitle, mainListDocumentData.recommendedTitle) && Objects.equals(this.coverTemplateUuid, mainListDocumentData.coverTemplateUuid) && Objects.equals(this.coverSummary, mainListDocumentData.coverSummary) && Integer.valueOf(this.coverSummaryAlignment).equals(Integer.valueOf(mainListDocumentData.coverSummaryAlignment)) && Objects.equals(this.coverStickerUuid, mainListDocumentData.coverStickerUuid) && Objects.equals(this.coverBackgroundColor, mainListDocumentData.coverBackgroundColor) && Integer.valueOf(getIsCoverEnabled()).equals(Integer.valueOf(mainListDocumentData.getIsCoverEnabled())) && Integer.valueOf(this.coverSuggestedState).equals(Integer.valueOf(mainListDocumentData.coverSuggestedState)) && Long.valueOf(this.syncState).equals(Long.valueOf(mainListDocumentData.syncState)) && this.hasSticky == mainListDocumentData.hasSticky && this.unknownMinVersion == mainListDocumentData.unknownMinVersion && this.formatVersion == mainListDocumentData.formatVersion && this.backgroundType == mainListDocumentData.backgroundType && this.layout == mainListDocumentData.layout && Objects.equals(this.imagePath, mainListDocumentData.imagePath) && Objects.equals(this.playTime, mainListDocumentData.playTime)) {
                return true;
            }
        }
        return false;
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

    @DataConstants.PageBackgroundType
    public int getBackgroundType() {
        return this.backgroundType;
    }

    @NonNull
    public String getCategoryUuid() {
        return this.categoryUuid;
    }

    @NonNull
    public String getContent() {
        return this.content;
    }

    public String getContentUuid() {
        return this.contentUuid;
    }

    public int getCorrupted() {
        return this.corrupted;
    }

    @NonNull
    public String getCoverBackgroundColor() {
        return this.coverBackgroundColor;
    }

    @CoverConstants.SuggestedState
    public int getCoverState() {
        return this.coverSuggestedState;
    }

    @NonNull
    public String getCoverStickerUuid() {
        return this.coverStickerUuid;
    }

    @NonNull
    public String getCoverSummary() {
        return this.coverSummary;
    }

    public int getCoverSummaryAlignment() {
        return this.coverSummaryAlignment;
    }

    @NonNull
    public String getCoverTemplateUuid() {
        return this.coverTemplateUuid;
    }

    public long getCreatedAt() {
        return this.createdAt;
    }

    public byte[] getDisplayContent() {
        return this.displayContent;
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

    public long getFirstOpenedAt() {
        return this.firstOpenedAt;
    }

    public int getFormatVersion() {
        return this.formatVersion;
    }

    public int getHasSticky() {
        return this.hasSticky;
    }

    public Long getId() {
        return this.f7386id;
    }

    @Nullable
    public String getImagePath() {
        return this.imagePath;
    }

    @NonNull
    public String getImgObjectPathInThumbnailPage() {
        if (this.imagePath.isEmpty()) {
            return "";
        }
        return this.filePath + this.imagePath;
    }

    public int getIsCoverEnabled() {
        return this.isCoverEnabled;
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

    public long getLastModifiedAt() {
        return this.lastModifiedAt;
    }

    @DataConstants.Layout
    public int getLayout() {
        return this.layout;
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

    @PageMode
    public int getPageMode() {
        return this.pageMode;
    }

    @Nullable
    public String getPlayTime() {
        return this.playTime;
    }

    @NonNull
    public String getRecommendedTitle() {
        return this.recommendedTitle;
    }

    public long getRecycleBinTimeMoved() {
        return this.recycleBinTimeMoved;
    }

    public Integer getSecondContentType() {
        return this.secondContentType;
    }

    public long getSize() {
        return this.size;
    }

    public String getStrokeUuid() {
        return this.strokeUuid;
    }

    public long getSyncState() {
        return this.syncState;
    }

    @NonNull
    public String getTitle() {
        return this.title;
    }

    public int getUnknownMinVersion() {
        return this.unknownMinVersion;
    }

    @NonNull
    public String getUuid() {
        return this.uuid;
    }

    public String getVrUuid() {
        return this.vrUuid;
    }

    public int hashCode() {
        return Arrays.hashCode(this.displayContent) + (Objects.hash(this.uuid, Integer.valueOf(this.isDeleted), Integer.valueOf(this.isDirty), this.title, this.recommendedTitle, this.content, Long.valueOf(this.createdAt), Long.valueOf(this.lastModifiedAt), this.vrUuid, this.contentUuid, this.firstContentType, this.secondContentType, this.strokeUuid, this.categoryUuid, getFilePath(), Integer.valueOf(this.isFavorite), Integer.valueOf(this.isLock), Integer.valueOf(this.corrupted), Integer.valueOf(this.isSavingByWhichPid), Long.valueOf(this.recycleBinTimeMoved), Long.valueOf(this.firstOpenedAt), this.mdeSpaceId, this.mdeItemId, this.mdeGroupId, this.mdeOwnerId, this.absolutePath, Integer.valueOf(this.backgroundColor), Integer.valueOf(this.backgroundColorInverted), Integer.valueOf(this.pageMode)) * 31);
    }

    public boolean isCoverEnabled() {
        return getIsCoverEnabled() == 1;
    }

    public boolean isSDoc() {
        return ".sdoc".equals(getFileExtension());
    }

    public boolean isSDocX() {
        return ".sdocx".equals(getFileExtension());
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

    public void setBackgroundType(@DataConstants.PageBackgroundType int i) {
        this.backgroundType = i;
    }

    public void setCategoryUuid(@NonNull String str) {
        this.categoryUuid = str;
    }

    public void setContent(@NonNull String str) {
        this.content = str;
    }

    public void setContentUuid(String str) {
        this.contentUuid = str;
    }

    public void setCorrupted(int i) {
        this.corrupted = i;
    }

    public void setCoverBackgroundColor(@Nullable @CoverConstants.Color String str) {
        if (str == null) {
            str = "DEFAULT:///";
        }
        this.coverBackgroundColor = str;
    }

    public void setCoverEnabled(boolean z) {
        setIsCoverEnabled(z ? 1 : 0);
    }

    public void setCoverState(@CoverConstants.SuggestedState int i) {
        this.coverSuggestedState = i;
    }

    public void setCoverStickerUuid(@Nullable @CoverStickerConstants.Category String str) {
        if (str == null) {
            str = CoverStickerConstants.Category.NONE.UUID;
        }
        this.coverStickerUuid = str;
    }

    public void setCoverSummary(@Nullable String str) {
        if (str == null) {
            str = "";
        }
        this.coverSummary = str;
    }

    public void setCoverSummaryAlignment(int i) {
        this.coverSummaryAlignment = i;
    }

    public void setCoverTemplateUuid(@Nullable @CoverConstants.Template String str) {
        if (str == null) {
            str = "DEFAULT:///";
        }
        this.coverTemplateUuid = str;
    }

    public void setCreatedAt(long j) {
        this.createdAt = j;
    }

    public void setDisplayContent(@NonNull byte[] bArr) {
        this.displayContent = bArr;
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

    public void setFirstOpenedAt(long j) {
        this.firstOpenedAt = j;
    }

    public void setFormatVersion(int i) {
        this.formatVersion = i;
    }

    public void setHasSticky(int i) {
        this.hasSticky = i;
    }

    public void setId(Long l) {
        this.f7386id = l;
    }

    public void setImagePath(String str) {
        if (str == null) {
            str = "";
        }
        this.imagePath = str;
    }

    public void setIsCoverEnabled(int i) {
        this.isCoverEnabled = i;
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

    public void setLastModifiedAt(long j) {
        this.lastModifiedAt = j;
    }

    public void setLayout(@DataConstants.Layout int i) {
        this.layout = i;
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

    public void setPageMode(@PageMode int i) {
        this.pageMode = i;
    }

    public void setPlayTime(String str) {
        if (str == null) {
            str = "";
        }
        this.playTime = str;
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

    public void setSecondContentType(Integer num) {
        this.secondContentType = num;
    }

    public void setSize(long j) {
        this.size = j;
    }

    public void setStrokeUuid(String str) {
        this.strokeUuid = str;
    }

    public void setSyncState(long j) {
        this.syncState = j;
    }

    public void setTitle(String str) {
        if (str == null) {
            str = "";
        }
        this.title = str;
    }

    public void setUnknownMinVersion(int i) {
        this.unknownMinVersion = i;
    }

    public void setUuid(@NonNull String str) {
        this.uuid = str;
    }

    public void setVrUuid(String str) {
        this.vrUuid = str;
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder(getClass().getSimpleName());
        sb.append('{');
        return AbstractC1038a.m1213n('}', getInfo(), sb);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        if (this.f7386id == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeLong(this.f7386id.longValue());
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
        parcel.writeString(this.categoryUuid);
        parcel.writeString(this.filePath);
        parcel.writeInt(this.isFavorite);
        parcel.writeInt(this.isLock);
        parcel.writeInt(this.isSavingByWhichPid);
        parcel.writeLong(this.recycleBinTimeMoved);
        parcel.writeLong(this.firstOpenedAt);
        parcel.writeString(this.mdeSpaceId);
        parcel.writeString(this.mdeItemId);
        parcel.writeString(this.mdeGroupId);
        parcel.writeString(this.mdeOwnerId);
        parcel.writeString(this.absolutePath);
        parcel.writeInt(this.backgroundColor);
        parcel.writeString(this.fileExtension);
        parcel.writeString(this.recommendedTitle);
        parcel.writeInt(this.backgroundColorInverted);
        parcel.writeInt(this.corrupted);
        parcel.writeInt(this.pageMode);
        parcel.writeString(this.coverTemplateUuid);
        parcel.writeString(this.coverSummary);
        parcel.writeInt(this.coverSummaryAlignment);
        parcel.writeString(this.coverStickerUuid);
        parcel.writeString(this.coverBackgroundColor);
        parcel.writeInt(this.isCoverEnabled);
        parcel.writeInt(this.coverSuggestedState);
        parcel.writeLong(this.syncState);
        parcel.writeInt(this.hasSticky);
        parcel.writeInt(this.unknownMinVersion);
        parcel.writeLong(this.size);
        parcel.writeInt(this.formatVersion);
        parcel.writeInt(this.backgroundType);
        parcel.writeInt(this.layout);
        parcel.writeString(this.imagePath);
        parcel.writeString(this.playTime);
    }

    public MainListDocumentData(Parcel parcel) {
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
        this.categoryUuid = "uncategorized:///";
        this.filePath = "";
        this.isFavorite = 0;
        this.isLock = 0;
        this.isSavingByWhichPid = 0;
        this.recycleBinTimeMoved = 0L;
        this.firstOpenedAt = 0L;
        this.mdeSpaceId = "";
        this.mdeItemId = "";
        this.mdeGroupId = "";
        this.mdeOwnerId = "";
        this.absolutePath = "";
        this.backgroundColor = 0;
        this.backgroundColorInverted = 0;
        this.corrupted = 0;
        this.pageMode = 0;
        this.size = 0L;
        this.coverTemplateUuid = "DEFAULT:///";
        this.coverSummary = "";
        this.coverSummaryAlignment = 0;
        this.coverStickerUuid = CoverStickerConstants.Category.NONE.UUID;
        this.coverBackgroundColor = "DEFAULT:///";
        this.isCoverEnabled = 1;
        this.coverSuggestedState = 0;
        this.syncState = 0L;
        this.backgroundType = 0;
        this.layout = 0;
        this.imagePath = "";
        this.playTime = "";
        if (parcel.readByte() == 0) {
            this.f7386id = null;
        } else {
            this.f7386id = Long.valueOf(parcel.readLong());
        }
        String string = parcel.readString();
        Objects.requireNonNull(string);
        this.uuid = string;
        this.isDeleted = parcel.readInt();
        this.isDirty = parcel.readInt();
        String string2 = parcel.readString();
        Objects.requireNonNull(string2);
        this.title = string2;
        String string3 = parcel.readString();
        Objects.requireNonNull(string3);
        this.content = string3;
        byte[] bArrCreateByteArray = parcel.createByteArray();
        Objects.requireNonNull(bArrCreateByteArray);
        this.displayContent = bArrCreateByteArray;
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
        String string4 = parcel.readString();
        Objects.requireNonNull(string4);
        this.categoryUuid = string4;
        String string5 = parcel.readString();
        Objects.requireNonNull(string5);
        this.filePath = string5;
        this.isFavorite = parcel.readInt();
        this.isLock = parcel.readInt();
        this.isSavingByWhichPid = parcel.readInt();
        this.recycleBinTimeMoved = parcel.readLong();
        this.firstOpenedAt = parcel.readLong();
        String string6 = parcel.readString();
        Objects.requireNonNull(string6);
        this.mdeSpaceId = string6;
        String string7 = parcel.readString();
        Objects.requireNonNull(string7);
        this.mdeItemId = string7;
        String string8 = parcel.readString();
        Objects.requireNonNull(string8);
        this.mdeGroupId = string8;
        String string9 = parcel.readString();
        Objects.requireNonNull(string9);
        this.mdeOwnerId = string9;
        this.absolutePath = parcel.readString();
        this.backgroundColor = parcel.readInt();
        this.fileExtension = parcel.readString();
        String string10 = parcel.readString();
        Objects.requireNonNull(string10);
        this.recommendedTitle = string10;
        this.backgroundColorInverted = parcel.readInt();
        this.corrupted = parcel.readInt();
        this.pageMode = parcel.readInt();
        String string11 = parcel.readString();
        Objects.requireNonNull(string11);
        this.coverTemplateUuid = string11;
        String string12 = parcel.readString();
        Objects.requireNonNull(string12);
        this.coverSummary = string12;
        this.coverSummaryAlignment = parcel.readInt();
        String string13 = parcel.readString();
        Objects.requireNonNull(string13);
        this.coverStickerUuid = string13;
        String string14 = parcel.readString();
        Objects.requireNonNull(string14);
        this.coverBackgroundColor = string14;
        this.isCoverEnabled = parcel.readInt();
        this.coverSuggestedState = parcel.readInt();
        this.syncState = parcel.readLong();
        this.hasSticky = parcel.readInt();
        this.unknownMinVersion = parcel.readInt();
        this.size = parcel.readLong();
        this.formatVersion = parcel.readInt();
        this.backgroundType = parcel.readInt();
        this.layout = parcel.readInt();
        this.imagePath = parcel.readString();
        this.playTime = parcel.readString();
    }
}
