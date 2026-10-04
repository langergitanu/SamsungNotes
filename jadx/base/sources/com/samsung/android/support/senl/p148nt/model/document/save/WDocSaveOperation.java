package com.samsung.android.support.senl.p148nt.model.document.save;

import android.content.Context;
import android.graphics.RectF;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.work.impl.RunnableC4054d;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.worddoc.SpenVoiceData;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWNoteFile;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.constructor.SpenObjectConstructor;
import com.samsung.android.support.senl.p148nt.base.common.TimeManager;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.Features;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.NotesSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.StorageUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.DataConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.PredefinedCategory;
import com.samsung.android.support.senl.p148nt.data.common.constants.TimeSaveParam;
import com.samsung.android.support.senl.p148nt.data.common.legacy.SaveNoteContents;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.DataUtils;
import com.samsung.android.support.senl.p148nt.data.common.utils.SpenWNoteObjectHelper;
import com.samsung.android.support.senl.p148nt.data.contract.DataToSyncManager;
import com.samsung.android.support.senl.p148nt.data.database.core.converter.DisplayDataConverter;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesContentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.SttContentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.executor.NotesDataTaskExecutor;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.common.scheduler.DataRepositoryScheduler;
import com.samsung.android.support.senl.p148nt.data.repository.document.NotesContentRepository;
import com.samsung.android.support.senl.p148nt.data.repository.document.SttContentRepository;
import com.samsung.android.support.senl.p148nt.data.repository.document.content.ContentDataCreator;
import com.samsung.android.support.senl.p148nt.data.repository.document.content.STTContentDataCreator;
import com.samsung.android.support.senl.p148nt.model.document.save.ThumbnailCreator;
import com.samsung.android.support.senl.p148nt.model.document.save.autotitle.DocumentAutoTitleCreator;
import com.samsung.android.support.senl.p148nt.model.document.save.converter.DisplayBulletDataConverter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class WDocSaveOperation extends SaveOperation<NotesDocumentEntity, SpenWNote> {
    private static final String TAG = DataLogger.createTag("WDocSaveOperation");
    private ThumbnailCreator.EditedInfo mEditedInfo;

    public WDocSaveOperation(@NonNull Context context) {
        super(context);
        this.mEditedInfo = new ThumbnailCreator.EditedInfo(-1, new RectF());
        setSaveStrategy(67592);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setDocumentContentEntity$0(NotesDocumentEntity notesDocumentEntity, List list, List list2, List list3) {
        NotesDataRepositoryFactory notesDataRepositoryFactoryNewInstance = NotesDataRepositoryFactory.newInstance(getContext());
        NotesContentRepository notesContentRepositoryCreateDocumentContentRepository = notesDataRepositoryFactoryNewInstance.createDocumentContentRepository();
        notesContentRepositoryCreateDocumentContentRepository.deleteBySDocUuid(notesDocumentEntity.getUuid(), list);
        notesContentRepositoryCreateDocumentContentRepository.insert(list2);
        if (Features.isSupportSTTFunction()) {
            SttContentRepository sttContentRepositoryCreateSttContentRepository = notesDataRepositoryFactoryNewInstance.createSttContentRepository();
            sttContentRepositoryCreateSttContentRepository.deleteByUuid(notesDocumentEntity.getUuid());
            sttContentRepositoryCreateSttContentRepository.insert((List<SttContentEntity>) list3);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.document.save.SaveOperation
    public void saveToDatabase(@NonNull SpenWNote spenWNote, @NonNull NotesDocumentEntity notesDocumentEntity) {
        NotesDataRepositoryFactory notesDataRepositoryFactoryNewInstance = NotesDataRepositoryFactory.newInstance(getContext());
        if (!notesDocumentEntity.isDirtySkipped()) {
            notesDocumentEntity.setIsDirty(1);
            notesDocumentEntity.setCategoryIsDirty(1);
        }
        String str = TAG;
        DataLogger.m12307i(str, "apply, entity : " + notesDocumentEntity);
        DataLogger.m12308p(str, "save database transaction - start");
        DataLogger.m12308p(str, "save database transaction - DO_NOT_UPDATE_MAPPING_TABLE : " + checkSaveStrategy(4096) + ", isNew : " + isNew());
        if (!checkSaveStrategy(4096)) {
            notesDataRepositoryFactoryNewInstance.createMappedDocumentRepository().setConverted(".sdocx", notesDocumentEntity.getUuid(), isNew());
        }
        DocumentDBSaver.saveSDocX(notesDataRepositoryFactoryNewInstance, spenWNote, notesDocumentEntity, this.mEditedInfo.pageIndex());
        if (checkSaveStrategy(65536)) {
            NotesSamsungAnalytics.insertLog((String) null, "9914", PredefinedCategory.RESTRICTED_FOLDERS.contains(notesDocumentEntity.getCategoryUuid()) ? "a" : "b");
            DataUtils.sendAnalytics(spenWNote);
        }
        if (UUIDUtils.isCoeditUuid(notesDocumentEntity.getUuid())) {
            DataToSyncManager.getInstance().onCoeditDocumentSaved(notesDocumentEntity.getUuid(), spenWNote.getServerCheckPoint());
        }
        if (checkSaveStrategy(8192)) {
            ThumbnailCreator.sendForceUpdateBroadcast(getContext(), notesDocumentEntity);
        }
        DataLogger.m12308p(str, "save database transaction - end");
    }

    @Override // com.samsung.android.support.senl.p148nt.model.document.save.SaveOperation
    public void setDocumentBackgroundEntity(@NonNull SpenWNote spenWNote, @NonNull NotesDocumentEntity notesDocumentEntity) {
        int backgroundColor = spenWNote.getPageCount() > 0 ? spenWNote.getPage(0).getBackgroundColor() : 0;
        notesDocumentEntity.setBackgroundColor(backgroundColor);
        notesDocumentEntity.setBackgroundColorInverted(spenWNote.isBackgroundColorInverted() ? 1 : 0);
        String str = TAG;
        StringBuilder sbM778t = AbstractC0541b.m778t(backgroundColor, "setDocumentBackgroundEntity, color : ", ", isBackgroundColorInverted : ");
        sbM778t.append(spenWNote.isBackgroundColorInverted());
        DataLogger.m12302d(str, sbM778t.toString());
    }

    @Override // com.samsung.android.support.senl.p148nt.model.document.save.SaveOperation
    public void setDocumentContentEntity(@NonNull SpenWNote spenWNote, @NonNull NotesDocumentEntity notesDocumentEntity) {
        List<SttContentEntity> arrayList;
        boolean zCheckSaveStrategy = checkSaveStrategy(2048);
        DataLogger.m12302d(TAG, "setDocumentContentEntity, CREATE_THUMBNAIL_CACHE : " + zCheckSaveStrategy);
        this.mEditedInfo = ThumbnailCreator.getEditedInfo(getContext(), spenWNote);
        ContentDataCreator contentDataCreator = new ContentDataCreator(getContext());
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (zCheckSaveStrategy) {
            new ThumbnailCreator().saveThumbnail(getContext(), spenWNote, notesDocumentEntity.getUuid(), this.mEditedInfo);
            List<NotesContentEntity> listCreateThumbnailEntities = contentDataCreator.createThumbnailEntities(notesDocumentEntity.getUuid());
            notesDocumentEntity.setContentUuid(listCreateThumbnailEntities.isEmpty() ? null : listCreateThumbnailEntities.get(0).getUuid());
            arrayList2.addAll(listCreateThumbnailEntities);
        } else {
            arrayList3.add(DataConstants.MIME_TYPE.IMAGE);
        }
        List<NotesContentEntity> listCreateVoiceEntities = contentDataCreator.createVoiceEntities(spenWNote, notesDocumentEntity.getUuid());
        notesDocumentEntity.setVrUuid(listCreateVoiceEntities.isEmpty() ? null : listCreateVoiceEntities.get(0).getUuid());
        arrayList2.addAll(listCreateVoiceEntities);
        if (Features.isSupportSTTFunction()) {
            HashSet hashSet = new HashSet();
            ArrayList<SpenVoiceData> voiceDataList = spenWNote.getVoiceDataList();
            if (voiceDataList != null) {
                Iterator<SpenVoiceData> it = voiceDataList.iterator();
                while (it.hasNext()) {
                    hashSet.add(it.next().getAttachedFile());
                }
            }
            arrayList = new STTContentDataCreator().createEntities(notesDocumentEntity.getUuid(), hashSet);
        } else {
            arrayList = new ArrayList<>();
        }
        List<SttContentEntity> list = arrayList;
        SpenObjectTextBox bodyText = spenWNote.getBodyText();
        SpenObjectTextBox spenObjectTextBoxMakeObjectTextBox = SpenObjectConstructor.makeObjectTextBox();
        spenObjectTextBoxMakeObjectTextBox.copy(bodyText);
        SpenObjectTextBox spenObjectTextBoxConvertBulletTypeBasedOnIndentLevel = DisplayBulletDataConverter.convertBulletTypeBasedOnIndentLevel(spenObjectTextBoxMakeObjectTextBox);
        String strTrim = DisplayDataConverter.trimMaxContentString(SaveNoteContents.makeStrippedContent(bodyText.getText())).trim();
        notesDocumentEntity.setContentSecureVersion(0);
        notesDocumentEntity.setContent(strTrim);
        notesDocumentEntity.setDisplayContent(DisplayDataConverter.convertDisplayData(spenObjectTextBoxConvertBulletTypeBasedOnIndentLevel, 300, "coedit:///".equals(notesDocumentEntity.getCategoryUuid())));
        notesDocumentEntity.setStrokeUuid(SpenWNoteObjectHelper.existOnlyStrokeObject(spenWNote) ? notesDocumentEntity.getUuid() : "");
        DataRepositoryScheduler.runnable(new RunnableC4054d(this, notesDocumentEntity, arrayList3, arrayList2, list, 5)).executeOn(NotesDataTaskExecutor.getIOThreadExecutor()).execute();
    }

    @Override // com.samsung.android.support.senl.p148nt.model.document.save.SaveOperation
    public void setDocumentPageEntity(@NonNull SpenWNote spenWNote, @NonNull NotesDocumentEntity notesDocumentEntity) {
        notesDocumentEntity.setPageMode(spenWNote.getPageMode() == SpenWNote.PageMode.LIST ? 2 : 1);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.document.save.SaveOperation
    public void setDocumentSize(@NonNull SpenWNote spenWNote, @NonNull NotesDocumentEntity notesDocumentEntity) {
        if (updateDocSize()) {
            notesDocumentEntity.setSize(StorageUtils.getDocumentSize(spenWNote.getInternalDirectory()));
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.document.save.SaveOperation
    public void setDocumentTimeEntity(@NonNull SpenWNote spenWNote, @NonNull NotesDocumentEntity notesDocumentEntity) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!notesDocumentEntity.getKeepServerTimestamp()) {
            notesDocumentEntity.setServerTimestamp(Long.valueOf(TimeManager.getCurrentTime()));
            notesDocumentEntity.setCategoryServerTimeStamp(notesDocumentEntity.getServerTimestamp());
        }
        TimeSaveParam timeSaveParam = notesDocumentEntity.getTimeSaveParam();
        String str = TAG;
        DataLogger.m12302d(str, "setDocumentTimeEntity, timeSaveParam : " + timeSaveParam);
        if (isNew()) {
            long jConvertSdkTimeToAppTime = FileUtils.exists(notesDocumentEntity.getFilePath()) ? TimeManager.convertSdkTimeToAppTime(SpenWNoteFile.getDisplayCreatedTime(notesDocumentEntity.getFilePath())) : jCurrentTimeMillis;
            notesDocumentEntity.setCreatedAt(timeSaveParam.getCreatedTime(Long.valueOf(jConvertSdkTimeToAppTime)).longValue());
            notesDocumentEntity.setLastModifiedAt(timeSaveParam.getLastModifiedTime(Long.valueOf(jConvertSdkTimeToAppTime)).longValue());
        }
        boolean zCheckSaveStrategy = checkSaveStrategy(16384);
        if (!zCheckSaveStrategy) {
            notesDocumentEntity.setLastModifiedAt(timeSaveParam.getLastModifiedTime(Long.valueOf(jCurrentTimeMillis)).longValue());
        }
        if (notesDocumentEntity.getLastModifiedAt() == 0) {
            notesDocumentEntity.setLastModifiedAt(timeSaveParam.getLastModifiedTime(Long.valueOf(jCurrentTimeMillis)).longValue());
        }
        if (notesDocumentEntity.getCreatedAt() == 0) {
            notesDocumentEntity.setCreatedAt(notesDocumentEntity.getLastModifiedAt());
        }
        DataLogger.m12302d(str, "setDocumentTimeEntity, isNew : " + isNew() + ", created : " + notesDocumentEntity.getCreatedAt() + ", modified : " + notesDocumentEntity.getLastModifiedAt() + ", doNotUpdateModifiedTime : " + zCheckSaveStrategy);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.document.save.SaveOperation
    public void setDocumentTitleEntity(@NonNull SpenWNote spenWNote, @NonNull NotesDocumentEntity notesDocumentEntity) {
        String strTrimMaxContentString = DisplayDataConverter.trimMaxContentString(spenWNote.getTitle().getText());
        String hintText = spenWNote.getTitle().getHintText();
        notesDocumentEntity.setTitle(strTrimMaxContentString);
        notesDocumentEntity.setDisplayTitle(DisplayDataConverter.convertDisplayData(spenWNote.getTitle(), 300));
        notesDocumentEntity.setRecommendedTitle(!TextUtils.isEmpty(strTrimMaxContentString) ? "" : new DocumentAutoTitleCreator().create(getContext().getResources(), spenWNote));
        DataLogger.m12302d(TAG, "setDocumentTitleEntity, title : " + DataLogger.getEncode(notesDocumentEntity.getTitle()) + ", hintText : " + DataLogger.getEncode(hintText) + ", recommendedTitle : " + DataLogger.getEncode(notesDocumentEntity.getRecommendedTitle()));
    }

    @Override // com.samsung.android.support.senl.p148nt.model.document.save.SaveOperation
    public void setLockAccountGuidEntity(@NonNull SpenWNote spenWNote, @NonNull NotesDocumentEntity notesDocumentEntity) {
        DataLogger.m12302d(TAG, "setLockAccountGuid, accountGuid : " + DataLogger.pii(getLockAccountGuid()) + ", lockType : " + notesDocumentEntity.getIsLock());
        String lockAccountGuid = notesDocumentEntity.getIsLock() != 0 ? getLockAccountGuid() : "";
        spenWNote.setOwnerId(lockAccountGuid);
        notesDocumentEntity.setLockAccountGuid(lockAccountGuid);
    }
}
