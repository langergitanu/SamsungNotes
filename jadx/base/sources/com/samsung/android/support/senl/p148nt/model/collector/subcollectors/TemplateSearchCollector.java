package com.samsung.android.support.senl.p148nt.model.collector.subcollectors;

import android.text.TextUtils;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectTable;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesStrokeSearchEntity;
import com.samsung.android.support.senl.p148nt.model.collector.common.CollectInfo;
import com.samsung.android.support.senl.p148nt.model.collector.common.CollectResolver;
import com.samsung.android.support.senl.p148nt.model.collector.repository.ICollectRepository;
import com.samsung.android.support.senl.p148nt.model.common.log.CollectLogger;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class TemplateSearchCollector extends AbsCollector implements ICollector {
    private static final String TAG = CollectLogger.createTag("TemplateSearchCollector");

    public TemplateSearchCollector(ICollectStateListener iCollectStateListener) {
        super(iCollectStateListener);
    }

    private void collectTableTextData(CollectInfo collectInfo, ICollectRepository iCollectRepository) {
        String str = TAG;
        DataLogger.m12302d(str, "collectTableTextData");
        ArrayList arrayList = new ArrayList();
        ArrayList<SpenObjectBase> bodyObjectList = collectInfo.getWNote().getBodyObjectList(2097152);
        if (bodyObjectList != null && !bodyObjectList.isEmpty()) {
            DataLogger.m12302d(str, "collectTableTextData tableObjectList " + bodyObjectList.size());
            Iterator<SpenObjectBase> it = bodyObjectList.iterator();
            while (it.hasNext()) {
                SpenObjectTable spenObjectTable = (SpenObjectTable) it.next();
                NotesStrokeSearchEntity notesStrokeSearchEntity = new NotesStrokeSearchEntity();
                notesStrokeSearchEntity.setType(6);
                notesStrokeSearchEntity.setDocUuid(collectInfo.getUuid());
                int rowsCount = spenObjectTable.getRowsCount();
                int columnsCount = spenObjectTable.getColumnsCount();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < rowsCount; i++) {
                    for (int i2 = 0; i2 < columnsCount; i2++) {
                        SpenObjectTextBox contentObject = spenObjectTable.getContentObject(i, i2);
                        if (hasSearchSkippedText(contentObject)) {
                            DataLogger.m12302d(TAG, "collectTableTextData, hasSearchSkippedText");
                        } else {
                            String text = contentObject.getText();
                            if (!TextUtils.isEmpty(text)) {
                                sb.append(text);
                                sb.append(" ");
                            }
                        }
                    }
                }
                if (!TextUtils.isEmpty(sb.toString())) {
                    notesStrokeSearchEntity.setText(sb.toString().trim());
                    arrayList.add(notesStrokeSearchEntity);
                }
            }
        }
        iCollectRepository.setTableTextData(arrayList);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.subcollectors.AbsCollector, com.samsung.android.support.senl.p148nt.model.collector.subcollectors.ICollector
    public boolean collect(CollectInfo collectInfo, ICollectRepository iCollectRepository) {
        if (isCanceled()) {
            TemplateSearchCollectListenerManager.getInstance().notifyOnCollectCanceled(collectInfo, iCollectRepository);
            return collectNext(collectInfo, iCollectRepository);
        }
        if (!isSupported() || !isAvailable(collectInfo)) {
            DataLogger.m12302d(TAG, "collect not executed, not supported or not available");
            TemplateSearchCollectListenerManager.getInstance().notifyOnCollectFailed(collectInfo, iCollectRepository);
            return collectNext(collectInfo, iCollectRepository);
        }
        DataLogger.m12302d(TAG, "collect");
        preCollect(collectInfo, iCollectRepository);
        TemplateSearchCollectListenerManager.getInstance().notifyOnCollectStarted(collectInfo);
        try {
            collectTableTextData(collectInfo, iCollectRepository);
        } catch (Exception e) {
            AbstractC11014a.m12333r(e, new StringBuilder("collect, exception: "), TAG);
        }
        if (isCanceled()) {
            TemplateSearchCollectListenerManager.getInstance().notifyOnCollectCanceled(collectInfo, iCollectRepository);
        } else {
            postCollect(collectInfo, iCollectRepository);
            TemplateSearchCollectListenerManager.getInstance().notifyOnCollectFinished(collectInfo, iCollectRepository);
        }
        return collectNext(collectInfo, iCollectRepository);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.subcollectors.AbsCollector, com.samsung.android.support.senl.p148nt.model.collector.subcollectors.ICollector
    public boolean fail(CollectInfo collectInfo, ICollectRepository iCollectRepository) {
        TemplateSearchCollectListenerManager.getInstance().notifyOnCollectFailed(collectInfo, iCollectRepository);
        return failNext(collectInfo, iCollectRepository);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.subcollectors.AbsCollector, com.samsung.android.support.senl.p148nt.model.collector.subcollectors.ICollector
    public void postCollect(CollectInfo collectInfo, ICollectRepository iCollectRepository) {
        DataLogger.m12302d(TAG, "postCollect");
        CollectResolver.insertStrokeSearchEntities(iCollectRepository.getTableTextData());
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.subcollectors.AbsCollector, com.samsung.android.support.senl.p148nt.model.collector.subcollectors.ICollector
    public void preCollect(CollectInfo collectInfo, ICollectRepository iCollectRepository) {
        DataLogger.m12302d(TAG, "preCollect");
        collectInfo.setPageInfo(6);
        CollectResolver.removeStrokeSearchEntities(collectInfo.getUuid(), collectInfo.getRemovedPageIds());
        CollectResolver.removeStrokeSearchEntitiesWithType(collectInfo.getUuid(), collectInfo.getChangedPageIds(), 6);
    }
}
