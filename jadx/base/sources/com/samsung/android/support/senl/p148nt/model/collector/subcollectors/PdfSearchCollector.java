package com.samsung.android.support.senl.p148nt.model.collector.subcollectors;

import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import com.samsung.android.sdk.composer.pdf.SpenNotePdfSearch;
import com.samsung.android.sdk.pdf.SpenPdfWriter;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.extractor.TextExtractorManager;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesStrokeSearchEntity;
import com.samsung.android.support.senl.p148nt.model.collector.common.CollectInfo;
import com.samsung.android.support.senl.p148nt.model.collector.common.CollectResolver;
import com.samsung.android.support.senl.p148nt.model.collector.repository.ICollectRepository;
import com.samsung.android.support.senl.p148nt.model.common.log.CollectLogger;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class PdfSearchCollector extends AbsCollector implements ICollector {
    private static final int MEMORY_DUMP_TRIGGER_INDEX = 100;
    private static final float PDF_IMAGE_RATIO;
    private SpenNotePdfSearch mSpenNotePdfSearch;
    private TextExtractorManager mTextExtractorManager;
    private static final String TAG = CollectLogger.createTag("PdfSearchCollector");
    private static final int ONE_PAGE_SEARCH_DATA_LIMIT = SearchConstants.SEARCH_TEXT_MAX_LENGTH;

    static {
        PDF_IMAGE_RATIO = DeviceUtils.isTabletModel() ? 1.0f : 1.5f;
    }

    public PdfSearchCollector(ICollectStateListener iCollectStateListener) {
        super(iCollectStateListener);
    }

    private String getPdfOCRText(SpenWPage spenWPage, int i) {
        StringBuilder sb = new StringBuilder();
        ArrayList<SpenWPage.PDFData> pDFData = spenWPage.getPDFData();
        if (pDFData == null || pDFData.isEmpty()) {
            return "";
        }
        Iterator<SpenWPage.PDFData> it = pDFData.iterator();
        while (it.hasNext()) {
            String filePath = it.next().getFilePath();
            if (!TextUtils.isEmpty(filePath)) {
                SpenPdfWriter spenPdfWriter = new SpenPdfWriter(BaseUtils.getContext());
                spenPdfWriter.open(filePath, "", spenWPage.getWidth());
                String strExecuteTextExtractor = this.mTextExtractorManager.executeTextExtractor(spenPdfWriter.getPageImage(i, PDF_IMAGE_RATIO));
                if (!TextUtils.isEmpty(strExecuteTextExtractor)) {
                    sb.append(strExecuteTextExtractor);
                    sb.append(" ");
                }
                spenPdfWriter.close();
            }
        }
        if (DeviceInfo.isEngMode()) {
            DataLogger.m12303e(TAG, "getPdfOCRText, ocrText: " + ((Object) sb));
        }
        return sb.toString();
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.subcollectors.AbsCollector, com.samsung.android.support.senl.p148nt.model.collector.subcollectors.ICollector
    public boolean collect(CollectInfo collectInfo, ICollectRepository iCollectRepository) {
        TextExtractorManager textExtractorManager;
        if (isCanceled()) {
            PdfSearchCollectListenerManager.getInstance().notifyOnCollectCanceled(collectInfo, iCollectRepository);
            return collectNext(collectInfo, iCollectRepository);
        }
        if (!isSupported() || !isAvailable(collectInfo)) {
            DataLogger.m12302d(TAG, "collect not executed, not supported or not available");
            PdfSearchCollectListenerManager.getInstance().notifyOnCollectFailed(collectInfo, iCollectRepository);
            return collectNext(collectInfo, iCollectRepository);
        }
        String str = TAG;
        DataLogger.m12302d(str, "collect");
        preCollect(collectInfo, iCollectRepository);
        PdfSearchCollectListenerManager.getInstance().notifyOnCollectStarted(collectInfo);
        try {
            try {
            } catch (Exception e) {
                DataLogger.m12303e(TAG, "collect, exception: " + e.getMessage());
                SpenNotePdfSearch spenNotePdfSearch = this.mSpenNotePdfSearch;
                if (spenNotePdfSearch != null) {
                    spenNotePdfSearch.close();
                }
                textExtractorManager = this.mTextExtractorManager;
                if (textExtractorManager != null) {
                }
            }
            if (collectInfo.getChangedWPages().isEmpty()) {
                DataLogger.m12303e(str, "collect, no pdf pages");
                PdfSearchCollectListenerManager.getInstance().notifyOnCollectFinished(collectInfo, iCollectRepository);
                return collectNext(collectInfo, iCollectRepository);
            }
            SpenNotePdfSearch spenNotePdfSearchCreatePdfSearch = createPdfSearch();
            this.mSpenNotePdfSearch = spenNotePdfSearchCreatePdfSearch;
            spenNotePdfSearchCreatePdfSearch.setDocument(collectInfo.getWNote());
            this.mTextExtractorManager = new TextExtractorManager(BaseUtils.getContext());
            ArrayList arrayList = new ArrayList();
            int i = 0;
            for (SpenWPage spenWPage : collectInfo.getChangedWPages()) {
                if (isCanceled()) {
                    PdfSearchCollectListenerManager.getInstance().notifyOnCollectCanceled(collectInfo, iCollectRepository);
                    boolean zCollectNext = collectNext(collectInfo, iCollectRepository);
                    SpenNotePdfSearch spenNotePdfSearch2 = this.mSpenNotePdfSearch;
                    if (spenNotePdfSearch2 != null) {
                        spenNotePdfSearch2.close();
                    }
                    TextExtractorManager textExtractorManager2 = this.mTextExtractorManager;
                    if (textExtractorManager2 != null) {
                        textExtractorManager2.release();
                    }
                    return zCollectNext;
                }
                if (collectInfo.getAddedPageIds().contains(spenWPage.getId())) {
                    if (i % 100 == 0) {
                        DataLogger.printMemory(TAG, "getPageText#");
                    }
                    i++;
                    StringBuilder sb = new StringBuilder();
                    String pageText = this.mSpenNotePdfSearch.getPageText(spenWPage);
                    if (!TextUtils.isEmpty(pageText)) {
                        sb.append(pageText);
                        sb.append(" ");
                    }
                    int length = sb.length();
                    int i2 = ONE_PAGE_SEARCH_DATA_LIMIT;
                    if (length > i2) {
                        sb.setLength(i2);
                    }
                    NotesStrokeSearchEntity notesStrokeSearchEntity = new NotesStrokeSearchEntity();
                    notesStrokeSearchEntity.setDocUuid(collectInfo.getUuid());
                    notesStrokeSearchEntity.setPageUuid(spenWPage.getId());
                    notesStrokeSearchEntity.setText(sb.toString());
                    notesStrokeSearchEntity.setType(3);
                    arrayList.add(notesStrokeSearchEntity);
                }
            }
            iCollectRepository.setPdfRecognitionData(arrayList);
            SpenNotePdfSearch spenNotePdfSearch3 = this.mSpenNotePdfSearch;
            if (spenNotePdfSearch3 != null) {
                spenNotePdfSearch3.close();
            }
            textExtractorManager = this.mTextExtractorManager;
            if (textExtractorManager != null) {
                textExtractorManager.release();
            }
            if (isCanceled()) {
                PdfSearchCollectListenerManager.getInstance().notifyOnCollectCanceled(collectInfo, iCollectRepository);
            } else {
                postCollect(collectInfo, iCollectRepository);
                PdfSearchCollectListenerManager.getInstance().notifyOnCollectFinished(collectInfo, iCollectRepository);
            }
            return collectNext(collectInfo, iCollectRepository);
        } finally {
            SpenNotePdfSearch spenNotePdfSearch4 = this.mSpenNotePdfSearch;
            if (spenNotePdfSearch4 != null) {
                spenNotePdfSearch4.close();
            }
            TextExtractorManager textExtractorManager3 = this.mTextExtractorManager;
            if (textExtractorManager3 != null) {
                textExtractorManager3.release();
            }
        }
    }

    @VisibleForTesting
    public SpenNotePdfSearch createPdfSearch() {
        return new SpenNotePdfSearch();
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.subcollectors.AbsCollector, com.samsung.android.support.senl.p148nt.model.collector.subcollectors.ICollector
    public boolean fail(CollectInfo collectInfo, ICollectRepository iCollectRepository) {
        PdfSearchCollectListenerManager.getInstance().notifyOnCollectFailed(collectInfo, iCollectRepository);
        return failNext(collectInfo, iCollectRepository);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.subcollectors.AbsCollector, com.samsung.android.support.senl.p148nt.model.collector.subcollectors.ICollector
    public void postCollect(CollectInfo collectInfo, ICollectRepository iCollectRepository) {
        DataLogger.m12302d(TAG, "postCollect");
        CollectResolver.insertStrokeSearchEntities(iCollectRepository.getPdfRecognitionData());
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.subcollectors.AbsCollector, com.samsung.android.support.senl.p148nt.model.collector.subcollectors.ICollector
    public void preCollect(CollectInfo collectInfo, ICollectRepository iCollectRepository) {
        DataLogger.m12302d(TAG, "preCollect");
        collectInfo.setPageInfo(3);
        CollectResolver.removeStrokeSearchEntities(collectInfo.getUuid(), collectInfo.getRemovedPageIds());
    }
}
