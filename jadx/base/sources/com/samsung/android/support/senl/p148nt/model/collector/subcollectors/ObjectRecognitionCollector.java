package com.samsung.android.support.senl.p148nt.model.collector.subcollectors;

import android.content.Context;
import androidx.annotation.VisibleForTesting;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.C8416h;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.contract.DataToComposerManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.C11253j;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesPageSearchInfoEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesStrokeSearchEntity;
import com.samsung.android.support.senl.p148nt.model.collector.common.CollectInfo;
import com.samsung.android.support.senl.p148nt.model.collector.common.CollectResolver;
import com.samsung.android.support.senl.p148nt.model.collector.common.jsonwrapper.StrokeDataJsonConverter;
import com.samsung.android.support.senl.p148nt.model.collector.recognition.data.ResultTextRecognition;
import com.samsung.android.support.senl.p148nt.model.collector.recognition.data.TextInfo;
import com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor.TextRecognitionExtractor;
import com.samsung.android.support.senl.p148nt.model.collector.repository.ICollectRepository;
import com.samsung.android.support.senl.p148nt.model.common.log.CollectLogger;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ObjectRecognitionCollector extends AbsCollector implements ICollector {
    private static final String TAG = CollectLogger.createTag("ObjectRecognitionCollector");

    public ObjectRecognitionCollector(ICollectStateListener iCollectStateListener) {
        super(iCollectStateListener);
    }

    private List<NotesStrokeSearchEntity> getActionLinkDataInfo(ResultTextRecognition resultTextRecognition, CollectInfo collectInfo) {
        ArrayList arrayList = new ArrayList();
        for (TextInfo textInfo : resultTextRecognition.getLinkInfoList()) {
            NotesStrokeSearchEntity notesStrokeSearchEntity = new NotesStrokeSearchEntity();
            notesStrokeSearchEntity.setDocUuid(collectInfo.getUuid());
            notesStrokeSearchEntity.setPageUuid(textInfo.pageUuid);
            notesStrokeSearchEntity.setType(2);
            notesStrokeSearchEntity.setPageWidth(Integer.valueOf(textInfo.pageWidth));
            notesStrokeSearchEntity.setFilePath("");
            notesStrokeSearchEntity.setHasVisualCue(0);
            SpenWPage.ActionLinkData actionLinkData = new SpenWPage.ActionLinkData();
            actionLinkData.linkStr = textInfo.linkStr;
            actionLinkData.repObjectUuid = textInfo.repObjectUuid;
            actionLinkData.handleList = textInfo.linkObjects;
            actionLinkData.lastCharRect = textInfo.lastCharRect;
            actionLinkData.firstCharRect = textInfo.leftCharRect;
            actionLinkData.linkType = textInfo.linkType;
            actionLinkData.strokeRect = textInfo.strokeRect;
            actionLinkData.pageWidth = textInfo.pageWidth;
            notesStrokeSearchEntity.setActionLinkData(StrokeDataJsonConverter.getJsonStrFromActionLinkData(actionLinkData));
            arrayList.add(notesStrokeSearchEntity);
        }
        DataLogger.m12302d(TAG, "getActionLinkDataInfo, result size: " + arrayList.size());
        return arrayList;
    }

    private List<NotesStrokeSearchEntity> getTextInfo(ResultTextRecognition resultTextRecognition, CollectInfo collectInfo) {
        ArrayList arrayList = new ArrayList();
        for (TextInfo textInfo : resultTextRecognition.getTextInfoList()) {
            NotesStrokeSearchEntity notesStrokeSearchEntity = new NotesStrokeSearchEntity();
            notesStrokeSearchEntity.setDocUuid(collectInfo.getUuid());
            notesStrokeSearchEntity.setPageUuid(textInfo.pageUuid);
            notesStrokeSearchEntity.setHasVisualCue(0);
            notesStrokeSearchEntity.setFilePath(new File(collectInfo.getNotePath()).getName());
            notesStrokeSearchEntity.setText(textInfo.str.trim());
            notesStrokeSearchEntity.setLeft(Integer.valueOf((int) textInfo.rect.left));
            notesStrokeSearchEntity.setTop(Integer.valueOf((int) textInfo.rect.top));
            notesStrokeSearchEntity.setBottom(Integer.valueOf((int) textInfo.rect.bottom));
            notesStrokeSearchEntity.setRight(Integer.valueOf((int) textInfo.rect.right));
            notesStrokeSearchEntity.setPageWidth(Integer.valueOf(textInfo.pageWidth));
            notesStrokeSearchEntity.setType(1);
            arrayList.add(notesStrokeSearchEntity);
        }
        DataLogger.m12302d(TAG, "getTextInfo, result size: " + arrayList.size());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ArrayList lambda$collect$0(Context context, String str) {
        return DataToComposerManager.getInstance().getParseHyperTextContract().parseHyperText(context, str, 0, true);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.subcollectors.AbsCollector, com.samsung.android.support.senl.p148nt.model.collector.subcollectors.ICollector
    public boolean collect(CollectInfo collectInfo, ICollectRepository iCollectRepository) {
        if (isCanceled()) {
            ObjectRecognitionCollectListenerManager.getInstance().notifyOnCollectCanceled(collectInfo, iCollectRepository);
            return collectNext(collectInfo, iCollectRepository);
        }
        if (!isSupported() || !isAvailable(collectInfo)) {
            DataLogger.m12302d(TAG, "collect not executed, not supported or not available");
            ObjectRecognitionCollectListenerManager.getInstance().notifyOnCollectFailed(collectInfo, iCollectRepository);
            return collectNext(collectInfo, iCollectRepository);
        }
        DataLogger.m12302d(TAG, "collect");
        preCollect(collectInfo, iCollectRepository);
        ObjectRecognitionCollectListenerManager.getInstance().notifyOnCollectStarted(collectInfo);
        try {
            TextRecognitionExtractor textRecognitionExtractorCreateTextRecognitionExtractor = createTextRecognitionExtractor(BaseUtils.getApplicationContext(), collectInfo);
            textRecognitionExtractorCreateTextRecognitionExtractor.setTextRecognitionPlugIn(new C8416h(8));
            ResultTextRecognition resultTextRecognitionRequestExtract = textRecognitionExtractorCreateTextRecognitionExtractor.requestExtract(new C11253j(this, 8));
            iCollectRepository.setObjectRecognitionSearchData(getTextInfo(resultTextRecognitionRequestExtract, collectInfo));
            iCollectRepository.setObjectRecognitionActionLinkData(getActionLinkDataInfo(resultTextRecognitionRequestExtract, collectInfo));
            textRecognitionExtractorCreateTextRecognitionExtractor.close();
        } catch (Exception e) {
            AbstractC11014a.m12333r(e, new StringBuilder("collect, exception: "), TAG);
        }
        if (isCanceled()) {
            ObjectRecognitionCollectListenerManager.getInstance().notifyOnCollectCanceled(collectInfo, iCollectRepository);
        } else {
            postCollect(collectInfo, iCollectRepository);
            ObjectRecognitionCollectListenerManager.getInstance().notifyOnCollectFinished(collectInfo, iCollectRepository);
        }
        return collectNext(collectInfo, iCollectRepository);
    }

    @VisibleForTesting
    public TextRecognitionExtractor createTextRecognitionExtractor(Context context, CollectInfo collectInfo) {
        return new TextRecognitionExtractor(context, collectInfo);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.subcollectors.AbsCollector, com.samsung.android.support.senl.p148nt.model.collector.subcollectors.ICollector
    public boolean fail(CollectInfo collectInfo, ICollectRepository iCollectRepository) {
        ObjectRecognitionCollectListenerManager.getInstance().notifyOnCollectFailed(collectInfo, iCollectRepository);
        return failNext(collectInfo, iCollectRepository);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.subcollectors.AbsCollector, com.samsung.android.support.senl.p148nt.model.collector.subcollectors.ICollector
    public void postCollect(CollectInfo collectInfo, ICollectRepository iCollectRepository) {
        DataLogger.m12302d(TAG, "postCollect");
        if (collectInfo.getNoteType() == CollectInfo.NoteType.W_NOTE) {
            Map<String, ArrayList<SpenWPage.SearchData>> searchDataList = CollectResolver.getSearchDataList(iCollectRepository.getObjectRecognitionSearchData());
            Map<String, ArrayList<SpenWPage.ActionLinkData>> actionLinkDataList = CollectResolver.getActionLinkDataList(iCollectRepository.getObjectRecognitionActionLinkData());
            if (ObjectRecognitionCollectListenerManager.getInstance().getOpenedDoc(collectInfo) != null) {
                ObjectRecognitionCollectListenerManager.getInstance().setStrokeRecognitionData(CollectResolver.createStrokeRecognitionData(searchDataList, actionLinkDataList), CollectResolver.createStrokeRecognitionDataResetPageIds(collectInfo.getChangedWPages(), searchDataList), false);
            }
            CollectResolver.insertPageSearchInfoEntities(CollectResolver.createPageSearchInfoEntitiesWithSearchModifiedAt(collectInfo.getUuid(), collectInfo.getWNote(), collectInfo.getChangedPageIds(), collectInfo.getSourceType()));
        } else {
            CollectResolver.setSearchEntityToNoteDoc(collectInfo.getSDoc(), collectInfo.getNotePath(), iCollectRepository.getObjectRecognitionSearchData(), iCollectRepository.getObjectRecognitionActionLinkData());
        }
        CollectResolver.insertStrokeSearchEntities(iCollectRepository.getObjectRecognitionSearchData());
        CollectResolver.insertStrokeSearchEntities(iCollectRepository.getObjectRecognitionActionLinkData());
        iCollectRepository.setEntireObjectRecognitionData(CollectResolver.getRecognizeTextsWithExcludedTypes(collectInfo.getUuid(), 3));
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.subcollectors.AbsCollector, com.samsung.android.support.senl.p148nt.model.collector.subcollectors.ICollector
    public void preCollect(CollectInfo collectInfo, ICollectRepository iCollectRepository) {
        DataLogger.m12302d(TAG, "preCollect");
        collectInfo.setPageInfo(1);
        if (collectInfo.getNoteType() == CollectInfo.NoteType.W_NOTE) {
            List<NotesPageSearchInfoEntity> listCreateChangedPageSearchInfoEntitiesWithContentModifiedAt = CollectResolver.createChangedPageSearchInfoEntitiesWithContentModifiedAt(collectInfo.getUuid(), collectInfo.getWNote(), collectInfo.getChangedPageIds(), collectInfo.getSourceType());
            List<NotesPageSearchInfoEntity> listCreateRemovedPageSearchInfoEntitiesWithContentModifiedAt = CollectResolver.createRemovedPageSearchInfoEntitiesWithContentModifiedAt(collectInfo.getUuid(), collectInfo.getRemovedPageIds());
            CollectResolver.insertPageSearchInfoEntities(listCreateChangedPageSearchInfoEntitiesWithContentModifiedAt);
            CollectResolver.removePageSearchInfoEntities(listCreateRemovedPageSearchInfoEntitiesWithContentModifiedAt);
        }
        CollectResolver.removeStrokeSearchEntities(collectInfo.getUuid(), collectInfo.getRemovedPageIds());
        CollectResolver.removeStrokeSearchEntitiesWithType(collectInfo.getUuid(), collectInfo.getChangedPageIds(), 1);
    }
}
