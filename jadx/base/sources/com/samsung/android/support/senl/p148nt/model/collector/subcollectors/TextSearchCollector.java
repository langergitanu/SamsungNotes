package com.samsung.android.support.senl.p148nt.model.collector.subcollectors;

import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.data.common.legacy.SaveNoteContents;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.converter.DisplayDataConverter;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentTextSearchEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesStrokeSearchEntity;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.model.collector.common.CollectInfo;
import com.samsung.android.support.senl.p148nt.model.collector.common.CollectResolver;
import com.samsung.android.support.senl.p148nt.model.collector.recognition.data.TextInfo;
import com.samsung.android.support.senl.p148nt.model.collector.repository.ICollectRepository;
import com.samsung.android.support.senl.p148nt.model.common.log.CollectLogger;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class TextSearchCollector extends AbsCollector implements ICollector {
    private static final String TAG = CollectLogger.createTag("TextSearchCollector");

    public TextSearchCollector(ICollectStateListener iCollectStateListener) {
        super(iCollectStateListener);
    }

    private void collectBodyTextData(CollectInfo collectInfo, ICollectRepository iCollectRepository) {
        iCollectRepository.setBodyTextData(collectInfo.getNoteType() == CollectInfo.NoteType.S_DOC ? NotesDataRepositoryFactory.newInstance(BaseUtils.getContext()).createDocumentDataRepository().get(collectInfo.getUuid()).getContent() : collectInfo.getWNote().getBodyText().getText());
    }

    private void collectTextBoxData(CollectInfo collectInfo, ICollectRepository iCollectRepository) {
        ArrayList arrayList = new ArrayList();
        for (SpenWPage spenWPage : collectInfo.getChangedWPages()) {
            String id = spenWPage.getId();
            for (SpenObjectBase spenObjectBase : spenWPage.getObjectList()) {
                if (spenObjectBase.getType() == 2 || spenObjectBase.getType() == 7) {
                    if (hasSearchSkippedText(spenObjectBase)) {
                        DataLogger.m12302d(TAG, "collectTableTextData, hasSearchSkippedText");
                    } else {
                        TextInfo textInfoConvertFromObjectShape = convertFromObjectShape((SpenObjectShape) spenObjectBase, id, spenWPage.getWidth());
                        if (textInfoConvertFromObjectShape != null) {
                            arrayList.add(textInfoConvertFromObjectShape);
                        }
                    }
                }
            }
        }
        iCollectRepository.setTextBoxSearchData(getTextBoxInfo(arrayList, collectInfo));
    }

    private void collectTitleData(CollectInfo collectInfo, ICollectRepository iCollectRepository) {
        String text;
        if (collectInfo.getNoteType() != CollectInfo.NoteType.W_NOTE || (text = collectInfo.getWNote().getTitle().getText()) == null || text.isEmpty()) {
            return;
        }
        iCollectRepository.setTitleData(text);
    }

    private TextInfo convertFromObjectShape(SpenObjectShape spenObjectShape, String str, int i) {
        if (spenObjectShape.getText() == null) {
            return null;
        }
        TextInfo textInfo = new TextInfo();
        textInfo.str = spenObjectShape.getText();
        textInfo.rect = spenObjectShape.getDrawnRect();
        textInfo.contentType = 0;
        textInfo.pageUuid = str;
        textInfo.pageWidth = i;
        return textInfo;
    }

    private NotesDocumentTextSearchEntity createBodyTextSearchEntity(CollectInfo collectInfo, ICollectRepository iCollectRepository) {
        String strMakeStrippedContent = SaveNoteContents.makeStrippedContent(DisplayDataConverter.trimMaxIndexContentString(iCollectRepository.getBodyTextData()));
        NotesDocumentTextSearchEntity notesDocumentTextSearchEntity = new NotesDocumentTextSearchEntity();
        notesDocumentTextSearchEntity.setDocUuid(collectInfo.getUuid());
        notesDocumentTextSearchEntity.setFilePath(collectInfo.getNotePath());
        notesDocumentTextSearchEntity.setStrippedContent(strMakeStrippedContent);
        return notesDocumentTextSearchEntity;
    }

    private List<NotesStrokeSearchEntity> getTextBoxInfo(List<TextInfo> list, CollectInfo collectInfo) {
        ArrayList arrayList = new ArrayList();
        for (TextInfo textInfo : list) {
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
            notesStrokeSearchEntity.setType(0);
            arrayList.add(notesStrokeSearchEntity);
        }
        DataLogger.m12302d(TAG, "getTextBoxInfo, result size: " + arrayList.size());
        return arrayList;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.subcollectors.AbsCollector, com.samsung.android.support.senl.p148nt.model.collector.subcollectors.ICollector
    public boolean collect(CollectInfo collectInfo, ICollectRepository iCollectRepository) {
        if (isCanceled()) {
            TextSearchCollectListenerManager.getInstance().notifyOnCollectCanceled(collectInfo, iCollectRepository);
            return collectNext(collectInfo, iCollectRepository);
        }
        if (!isSupported() || !isAvailable(collectInfo)) {
            DataLogger.m12302d(TAG, "collect not executed, not supported or not available");
            TextSearchCollectListenerManager.getInstance().notifyOnCollectFailed(collectInfo, iCollectRepository);
            return collectNext(collectInfo, iCollectRepository);
        }
        DataLogger.m12302d(TAG, "collect");
        preCollect(collectInfo, iCollectRepository);
        TextSearchCollectListenerManager.getInstance().notifyOnCollectStarted(collectInfo);
        try {
            collectTextBoxData(collectInfo, iCollectRepository);
            collectTitleData(collectInfo, iCollectRepository);
            collectBodyTextData(collectInfo, iCollectRepository);
        } catch (Exception e) {
            AbstractC11014a.m12333r(e, new StringBuilder("collect, exception: "), TAG);
        }
        if (isCanceled()) {
            TextSearchCollectListenerManager.getInstance().notifyOnCollectCanceled(collectInfo, iCollectRepository);
        } else {
            postCollect(collectInfo, iCollectRepository);
            TextSearchCollectListenerManager.getInstance().notifyOnCollectFinished(collectInfo, iCollectRepository);
        }
        return collectNext(collectInfo, iCollectRepository);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.subcollectors.AbsCollector, com.samsung.android.support.senl.p148nt.model.collector.subcollectors.ICollector
    public boolean fail(CollectInfo collectInfo, ICollectRepository iCollectRepository) {
        TextSearchCollectListenerManager.getInstance().notifyOnCollectFailed(collectInfo, iCollectRepository);
        return failNext(collectInfo, iCollectRepository);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.subcollectors.AbsCollector, com.samsung.android.support.senl.p148nt.model.collector.subcollectors.ICollector
    public void postCollect(CollectInfo collectInfo, ICollectRepository iCollectRepository) {
        DataLogger.m12302d(TAG, "postCollect");
        CollectResolver.insertStrokeSearchEntities(iCollectRepository.getTextBoxSearchData());
        CollectResolver.insertContentTextData(createBodyTextSearchEntity(collectInfo, iCollectRepository));
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.subcollectors.AbsCollector, com.samsung.android.support.senl.p148nt.model.collector.subcollectors.ICollector
    public void preCollect(CollectInfo collectInfo, ICollectRepository iCollectRepository) {
        DataLogger.m12302d(TAG, "preCollect");
        collectInfo.setPageInfo(0);
        CollectResolver.removeStrokeSearchEntities(collectInfo.getUuid(), collectInfo.getRemovedPageIds());
        CollectResolver.removeStrokeSearchEntitiesWithType(collectInfo.getUuid(), collectInfo.getChangedPageIds(), 0);
    }
}
