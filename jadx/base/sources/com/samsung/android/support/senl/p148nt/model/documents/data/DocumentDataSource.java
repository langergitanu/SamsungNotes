package com.samsung.android.support.senl.p148nt.model.documents.data;

import android.content.Context;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.constants.WritingMode;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentEntityContainer;
import com.samsung.android.support.senl.p148nt.model.documents.data.ISpenDocument;
import com.samsung.android.support.senl.p148nt.model.repository.data.sticky.StickyDataSource;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface DocumentDataSource<SpenDocument extends ISpenDocument, Entity extends DocumentEntityContainer> extends Parcelable {
    void clearChangedPageIdList();

    void clearVoiceRecordingInfo();

    DocumentDataSource<SpenDocument, Entity> cloneDocument(@NonNull DocumentSubscriptionId documentSubscriptionId, @NonNull Context context);

    void copy(DocumentDataSource<?, ?> documentDataSource);

    void createThumbnail(Context context);

    ArrayList<String> getChangedPageIdList();

    CoverDataSource getCoverDataSource();

    SpenDocument getDoc();

    @NonNull
    Entity getDocumentEntityContainer();

    @NonNull
    DocumentRepository<SpenDocument, ? extends Entity> getDocumentRepository();

    String getLoadPath();

    String getLockConfirm();

    MdeDataSource getMdeDataSource();

    String getPath();

    @Nullable
    DocumentSchedulerDataSource getScheduler();

    @NonNull
    StickyDataSource getStickyDataSource();

    @NonNull
    DocumentSubscriptionId getSubscriptionId();

    TagDataSource getTagDataSource();

    @NonNull
    String getUuid();

    VoiceRecordingDataSource getVoiceRecordingInfo();

    @WritingMode
    int getWritingMode();

    boolean isChangedOnlyThumbnail();

    boolean isContentChanged();

    boolean isContentEmpty();

    boolean isCoverChanged();

    boolean isDiscarded();

    boolean isEntityChanged();

    boolean isLocked();

    boolean isNew();

    boolean isSaveCache();

    boolean isStickyNoteChanged();

    boolean isTagChanged();

    void reserveDiscard(boolean z);

    SaveResult save(@NonNull Context context);

    boolean saveAutoTitle(@NonNull Context context);

    SaveResult saveCache(@NonNull Context context);

    SaveResult saveCacheSpenDocument();

    void saveCoverData(@NonNull Context context);

    SaveResult saveSpenDocument();

    void saveStickyNotes(@NonNull Context context);

    boolean saveTagDataSource(@NonNull Context context);

    boolean saveToDatabase(@NonNull Context context, boolean z);

    void setAllPageIdList();

    void setDirty(boolean z);

    void setDoc(SpenDocument spendocument);

    void setMdeDataSource(MdeDataSource mdeDataSource);

    void setNewDocument(boolean z);

    void setScheduler(DocumentSchedulerDataSource documentSchedulerDataSource);

    void setVoiceRecordingInfo(String str, int i);

    SaveResult snapSave(@NonNull Context context);

    SaveResult snapSaveSpenDocument();
}
