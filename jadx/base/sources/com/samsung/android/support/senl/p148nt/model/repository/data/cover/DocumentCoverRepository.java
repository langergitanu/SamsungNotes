package com.samsung.android.support.senl.p148nt.model.repository.data.cover;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.base.common.access.widgetaccess.WidgetAccessHandler;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentCoverEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.tuple.DocumentCoverStateTuple;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.cover.NotesDocumentCoverRepository;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.document.save.CoverThumbnailCreator;
import com.samsung.android.support.senl.p148nt.model.documents.data.CoverDataSource;
import com.samsung.android.support.senl.p148nt.model.domain.cover.UpdateDocumentCoverUseCase;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class DocumentCoverRepository implements CoverDataSource {
    private String mBackgroundColor;
    private String mCategoryUuid;
    private int mEnabled;
    private int mIsChanged;
    private boolean mIsStoredInDB;
    private boolean mIsUpdatedFromEditor;
    private int mState;
    private String mSummary;
    private int mSummaryAlignment;
    private String mTemplateUuid;
    private String mTitle;
    private int mTitleAlignment;
    private static final String TAG = ModelLogger.createTag("DocumentCoverRepository");
    public static final Parcelable.Creator<DocumentCoverRepository> CREATOR = new Parcelable.Creator<DocumentCoverRepository>() { // from class: com.samsung.android.support.senl.nt.model.repository.data.cover.DocumentCoverRepository.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DocumentCoverRepository createFromParcel(Parcel parcel) {
            return new DocumentCoverRepository(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DocumentCoverRepository[] newArray(int i) {
            return new DocumentCoverRepository[i];
        }
    };

    public DocumentCoverRepository(@NonNull Context context, @NonNull String str) {
        this.mIsChanged = 0;
        this.mTitle = "";
        this.mSummary = "";
        this.mTemplateUuid = "DEFAULT:///";
        this.mCategoryUuid = CoverStickerConstants.Category.NONE.UUID;
        this.mBackgroundColor = "DEFAULT:///";
        this.mState = 0;
        this.mTitleAlignment = 0;
        this.mSummaryAlignment = 0;
        this.mEnabled = 0;
        this.mIsStoredInDB = false;
        this.mIsUpdatedFromEditor = false;
        initData(context, str);
    }

    private void initData(Context context, String str) {
        DocumentCoverStateTuple coverStateTuple = NotesDataRepositoryFactory.newInstance(context).createDocumentCoverRepository().getCoverStateTuple(str);
        if (coverStateTuple == null) {
            return;
        }
        this.mIsStoredInDB = true;
        setCoverData(coverStateTuple.getTitle(), coverStateTuple.getSummary(), coverStateTuple.getTemplateUuid(), coverStateTuple.getCategoryUuid(), coverStateTuple.getBackgroundColor(), coverStateTuple.getIsEnabled(), coverStateTuple.state, coverStateTuple.getTitleAlignment(), coverStateTuple.getSummaryAlignment(), false);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.CoverDataSource
    public String getBackgroundColor() {
        return this.mBackgroundColor;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.CoverDataSource
    public String getCategoryUuid() {
        return this.mCategoryUuid;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.CoverDataSource
    public long getCreatedAt() {
        return 0L;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.CoverDataSource
    public long getLastModifiedAt() {
        return 0L;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.CoverDataSource
    public int getState() {
        return this.mState;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.CoverDataSource
    public String getSummary() {
        return this.mSummary;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.CoverDataSource
    public String getTemplateUuid() {
        return this.mTemplateUuid;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.CoverDataSource
    public String getTitle() {
        return this.mTitle;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.CoverDataSource
    public boolean isChanged() {
        return this.mIsChanged == 1;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.CoverDataSource
    public boolean isEnabled() {
        return this.mEnabled == 1;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.CoverDataSource
    public void save(@NonNull Context context, @NonNull String str) {
        boolean zIsChanged = isChanged();
        DataLogger.m12307i(TAG, "save, isChanged: " + zIsChanged + ", uuid : " + str);
        if (!zIsChanged) {
            CoverThumbnailCreator.deleteCoverFileByUuid(context, str);
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        NotesDocumentCoverRepository notesDocumentCoverRepositoryCreateDocumentCoverRepository = NotesDataRepositoryFactory.newInstance(context).createDocumentCoverRepository();
        NotesDocumentCoverEntity entity = notesDocumentCoverRepositoryCreateDocumentCoverRepository.getEntity(str);
        if (entity == null) {
            entity = new NotesDocumentCoverEntity();
            entity.setDocUuid(str);
            entity.setCreatedAt(jCurrentTimeMillis);
        }
        entity.setTitle(this.mTitle);
        entity.setSummary(this.mSummary);
        entity.setCategoryUuid(this.mCategoryUuid);
        entity.setTemplateUuid(this.mTemplateUuid);
        entity.setBackgroundColor(this.mBackgroundColor);
        entity.setIsEnabled(this.mEnabled);
        entity.setTitleAlignment(this.mTitleAlignment);
        entity.setSummaryAlignment(this.mSummaryAlignment);
        entity.setLastModifiedAt(jCurrentTimeMillis);
        if (new UpdateDocumentCoverUseCase(notesDocumentCoverRepositoryCreateDocumentCoverRepository).invoke(entity, this.mState, "composer-repo")) {
            this.mIsChanged = 0;
            CoverThumbnailCreator.convertCoverPath(context, str);
        }
        if (WidgetAccessHandler.getWidgetAccessContract() != null) {
            WidgetAccessHandler.getWidgetAccessContract().sendUpdateUuidWidgetBroadcast(context, str);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.CoverDataSource
    public void setCoverData(String str, String str2, @CoverConstants.Template String str3, @CoverStickerConstants.Category String str4, @CoverConstants.Color String str5, int i, int i2, int i4, int i5, boolean z) {
        this.mTitle = str;
        this.mSummary = str2;
        this.mTemplateUuid = str3;
        this.mCategoryUuid = str4;
        this.mBackgroundColor = str5;
        this.mEnabled = i;
        this.mState = i2;
        this.mTitleAlignment = i4;
        this.mSummaryAlignment = i5;
        if (z) {
            this.mIsChanged = 1;
            this.mIsUpdatedFromEditor = true;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.CoverDataSource
    public void setEnable(boolean z) {
        this.mEnabled = z ? 1 : 0;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.CoverDataSource
    public void setState(int i) {
        DataLogger.m12302d(TAG, "setState# state : " + i);
        if (this.mState != i) {
            this.mState = i;
            this.mIsChanged = 1;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.CoverDataSource
    public void setTitle(String str) {
        if (this.mTitle.equals(str)) {
            return;
        }
        this.mTitle = str;
        if (this.mIsStoredInDB || this.mIsUpdatedFromEditor) {
            this.mIsChanged = 1;
        }
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder("title: ");
        AbstractC11014a.m12336u(this.mTitle, sb, " [align: ");
        sb.append(this.mTitleAlignment);
        sb.append("], summary: ");
        AbstractC11014a.m12336u(this.mSummary, sb, " [align: ");
        sb.append(this.mSummaryAlignment);
        sb.append("], category: ");
        sb.append(this.mCategoryUuid);
        sb.append(", template: ");
        sb.append(this.mTemplateUuid);
        sb.append(", bgColor: ");
        sb.append(this.mBackgroundColor);
        sb.append(", enable : ");
        sb.append(this.mEnabled);
        sb.append(", state: ");
        sb.append(this.mState);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mIsChanged);
        parcel.writeString(this.mTitle);
        parcel.writeString(this.mSummary);
        parcel.writeString(this.mTemplateUuid);
        parcel.writeString(this.mCategoryUuid);
        parcel.writeInt(this.mEnabled);
        parcel.writeInt(this.mState);
        parcel.writeInt(this.mTitleAlignment);
        parcel.writeInt(this.mSummaryAlignment);
        parcel.writeString(this.mBackgroundColor);
        parcel.writeInt(this.mIsStoredInDB ? 1 : 0);
        parcel.writeInt(this.mIsUpdatedFromEditor ? 1 : 0);
    }

    public DocumentCoverRepository(Parcel parcel) {
        this.mIsChanged = 0;
        this.mTitle = "";
        this.mSummary = "";
        this.mTemplateUuid = "DEFAULT:///";
        this.mCategoryUuid = CoverStickerConstants.Category.NONE.UUID;
        this.mBackgroundColor = "DEFAULT:///";
        this.mState = 0;
        this.mTitleAlignment = 0;
        this.mSummaryAlignment = 0;
        this.mEnabled = 0;
        this.mIsStoredInDB = false;
        this.mIsUpdatedFromEditor = false;
        this.mIsChanged = parcel.readInt();
        this.mTitle = parcel.readString();
        this.mSummary = parcel.readString();
        this.mTemplateUuid = parcel.readString();
        this.mCategoryUuid = parcel.readString();
        this.mEnabled = parcel.readInt();
        this.mState = parcel.readInt();
        this.mTitleAlignment = parcel.readInt();
        this.mSummaryAlignment = parcel.readInt();
        this.mBackgroundColor = parcel.readString();
        this.mIsStoredInDB = parcel.readInt() == 1;
        this.mIsUpdatedFromEditor = parcel.readInt() == 1;
    }
}
