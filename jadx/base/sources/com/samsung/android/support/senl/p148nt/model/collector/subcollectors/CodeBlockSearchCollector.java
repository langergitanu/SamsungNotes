package com.samsung.android.support.senl.p148nt.model.collector.subcollectors;

import android.text.TextUtils;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectCodeBlock;
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
public class CodeBlockSearchCollector extends AbsCollector implements ICollector {
    private static final String TAG = CollectLogger.createTag("CodeBlockSearchCollector");

    public CodeBlockSearchCollector(ICollectStateListener iCollectStateListener) {
        super(iCollectStateListener);
    }

    private void collectCodeBlockData(CollectInfo collectInfo, ICollectRepository iCollectRepository) {
        DataLogger.m12302d(TAG, "collectCodeBlockData");
        ArrayList arrayList = new ArrayList();
        ArrayList<SpenObjectBase> bodyObjectList = collectInfo.getWNote().getBodyObjectList(4194304);
        if (bodyObjectList != null && !bodyObjectList.isEmpty()) {
            Iterator<SpenObjectBase> it = bodyObjectList.iterator();
            while (it.hasNext()) {
                SpenObjectCodeBlock spenObjectCodeBlock = (SpenObjectCodeBlock) it.next();
                NotesStrokeSearchEntity notesStrokeSearchEntity = new NotesStrokeSearchEntity();
                notesStrokeSearchEntity.setType(7);
                notesStrokeSearchEntity.setDocUuid(collectInfo.getUuid());
                StringBuilder sb = new StringBuilder();
                if (spenObjectCodeBlock.getTitle() != null) {
                    String text = spenObjectCodeBlock.getTitle().getText();
                    if (!TextUtils.isEmpty(text)) {
                        sb.append(text);
                        sb.append(" ");
                    }
                }
                if (spenObjectCodeBlock.getBody() != null) {
                    String text2 = spenObjectCodeBlock.getBody().getText();
                    if (!TextUtils.isEmpty(text2)) {
                        sb.append(text2);
                    }
                }
                notesStrokeSearchEntity.setText(sb.toString().trim());
                arrayList.add(notesStrokeSearchEntity);
            }
        }
        iCollectRepository.setCodeBlockData(arrayList);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.subcollectors.AbsCollector, com.samsung.android.support.senl.p148nt.model.collector.subcollectors.ICollector
    public boolean collect(CollectInfo collectInfo, ICollectRepository iCollectRepository) {
        if (isCanceled()) {
            CodeBlockSearchCollectListenerManager.getInstance().notifyOnCollectCanceled(collectInfo, iCollectRepository);
            return collectNext(collectInfo, iCollectRepository);
        }
        if (!isSupported() || !isAvailable(collectInfo)) {
            DataLogger.m12302d(TAG, "collect not executed, not supported or not available");
            CodeBlockSearchCollectListenerManager.getInstance().notifyOnCollectFailed(collectInfo, iCollectRepository);
            return collectNext(collectInfo, iCollectRepository);
        }
        DataLogger.m12302d(TAG, "collect");
        preCollect(collectInfo, iCollectRepository);
        CodeBlockSearchCollectListenerManager.getInstance().notifyOnCollectStarted(collectInfo);
        try {
            collectCodeBlockData(collectInfo, iCollectRepository);
        } catch (Exception e) {
            AbstractC11014a.m12333r(e, new StringBuilder("collect, exception: "), TAG);
        }
        if (isCanceled()) {
            CodeBlockSearchCollectListenerManager.getInstance().notifyOnCollectCanceled(collectInfo, iCollectRepository);
        } else {
            postCollect(collectInfo, iCollectRepository);
            CodeBlockSearchCollectListenerManager.getInstance().notifyOnCollectFinished(collectInfo, iCollectRepository);
        }
        return collectNext(collectInfo, iCollectRepository);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.subcollectors.AbsCollector, com.samsung.android.support.senl.p148nt.model.collector.subcollectors.ICollector
    public boolean fail(CollectInfo collectInfo, ICollectRepository iCollectRepository) {
        CodeBlockSearchCollectListenerManager.getInstance().notifyOnCollectFailed(collectInfo, iCollectRepository);
        return failNext(collectInfo, iCollectRepository);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.subcollectors.AbsCollector, com.samsung.android.support.senl.p148nt.model.collector.subcollectors.ICollector
    public void postCollect(CollectInfo collectInfo, ICollectRepository iCollectRepository) {
        DataLogger.m12302d(TAG, "postCollect");
        CollectResolver.insertStrokeSearchEntities(iCollectRepository.getCodeBlockData());
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.subcollectors.AbsCollector, com.samsung.android.support.senl.p148nt.model.collector.subcollectors.ICollector
    public void preCollect(CollectInfo collectInfo, ICollectRepository iCollectRepository) {
        DataLogger.m12302d(TAG, "preCollect");
        collectInfo.setPageInfo(7);
        CollectResolver.removeStrokeSearchEntities(collectInfo.getUuid(), collectInfo.getRemovedPageIds());
        CollectResolver.removeStrokeSearchEntitiesWithType(collectInfo.getUuid(), collectInfo.getChangedPageIds(), 7);
    }
}
