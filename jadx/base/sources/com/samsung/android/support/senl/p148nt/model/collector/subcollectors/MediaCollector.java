package com.samsung.android.support.senl.p148nt.model.collector.subcollectors;

import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectVoice;
import com.samsung.android.sdk.pen.worddoc.SpenVoiceData;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
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
public class MediaCollector extends AbsCollector implements ICollector {
    private static final String TAG = CollectLogger.createTag("MediaCollector");

    public MediaCollector(ICollectStateListener iCollectStateListener) {
        super(iCollectStateListener);
    }

    private void collectAudioData(CollectInfo collectInfo, ICollectRepository iCollectRepository) {
        ArrayList arrayList = new ArrayList();
        ArrayList<SpenObjectBase> bodyObjectList = collectInfo.getWNote().getBodyObjectList(512);
        if (bodyObjectList != null && !bodyObjectList.isEmpty()) {
            Iterator<SpenObjectBase> it = bodyObjectList.iterator();
            while (it.hasNext()) {
                SpenObjectVoice spenObjectVoice = (SpenObjectVoice) it.next();
                NotesStrokeSearchEntity notesStrokeSearchEntity = new NotesStrokeSearchEntity();
                notesStrokeSearchEntity.setType(5);
                notesStrokeSearchEntity.setDocUuid(collectInfo.getUuid());
                notesStrokeSearchEntity.setText(spenObjectVoice.getTitle());
                arrayList.add(notesStrokeSearchEntity);
            }
        }
        for (SpenWPage spenWPage : collectInfo.getWNote().getPageList()) {
            ArrayList<SpenObjectBase> objectList = spenWPage.getObjectList(512);
            if (!objectList.isEmpty()) {
                Iterator<SpenObjectBase> it2 = objectList.iterator();
                while (it2.hasNext()) {
                    SpenObjectVoice spenObjectVoice2 = (SpenObjectVoice) it2.next();
                    NotesStrokeSearchEntity notesStrokeSearchEntity2 = new NotesStrokeSearchEntity();
                    notesStrokeSearchEntity2.setType(5);
                    notesStrokeSearchEntity2.setDocUuid(collectInfo.getUuid());
                    notesStrokeSearchEntity2.setPageUuid(spenWPage.getId());
                    notesStrokeSearchEntity2.setText(spenObjectVoice2.getTitle());
                    arrayList.add(notesStrokeSearchEntity2);
                }
            }
        }
        iCollectRepository.setAudioData(arrayList);
    }

    private void collectVoiceRecordingData(CollectInfo collectInfo, ICollectRepository iCollectRepository) {
        ArrayList arrayList = new ArrayList();
        ArrayList<SpenVoiceData> voiceDataList = collectInfo.getWNote().getVoiceDataList();
        if (voiceDataList != null) {
            for (SpenVoiceData spenVoiceData : voiceDataList) {
                NotesStrokeSearchEntity notesStrokeSearchEntity = new NotesStrokeSearchEntity();
                notesStrokeSearchEntity.setType(4);
                notesStrokeSearchEntity.setDocUuid(collectInfo.getUuid());
                notesStrokeSearchEntity.setText(spenVoiceData.getName());
                arrayList.add(notesStrokeSearchEntity);
            }
        }
        iCollectRepository.setVoiceRecordingData(arrayList);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.subcollectors.AbsCollector, com.samsung.android.support.senl.p148nt.model.collector.subcollectors.ICollector
    public boolean collect(CollectInfo collectInfo, ICollectRepository iCollectRepository) {
        if (isCanceled()) {
            MediaCollectListenerManager.getInstance().notifyOnCollectCanceled(collectInfo, iCollectRepository);
            return collectNext(collectInfo, iCollectRepository);
        }
        if (!isSupported() || !isAvailable(collectInfo)) {
            DataLogger.m12302d(TAG, "collect not executed, not supported or not available");
            MediaCollectListenerManager.getInstance().notifyOnCollectFailed(collectInfo, iCollectRepository);
            return collectNext(collectInfo, iCollectRepository);
        }
        DataLogger.m12302d(TAG, "collect");
        preCollect(collectInfo, iCollectRepository);
        MediaCollectListenerManager.getInstance().notifyOnCollectStarted(collectInfo);
        try {
            collectVoiceRecordingData(collectInfo, iCollectRepository);
            collectAudioData(collectInfo, iCollectRepository);
        } catch (Exception e) {
            AbstractC11014a.m12333r(e, new StringBuilder("collect, exception: "), TAG);
        }
        if (isCanceled()) {
            MediaCollectListenerManager.getInstance().notifyOnCollectCanceled(collectInfo, iCollectRepository);
        } else {
            postCollect(collectInfo, iCollectRepository);
            MediaCollectListenerManager.getInstance().notifyOnCollectFinished(collectInfo, iCollectRepository);
        }
        return collectNext(collectInfo, iCollectRepository);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.subcollectors.AbsCollector, com.samsung.android.support.senl.p148nt.model.collector.subcollectors.ICollector
    public void postCollect(CollectInfo collectInfo, ICollectRepository iCollectRepository) {
        DataLogger.m12302d(TAG, "postCollect");
        CollectResolver.insertStrokeSearchEntities(iCollectRepository.getVoiceRecordingData());
        CollectResolver.insertStrokeSearchEntities(iCollectRepository.getAudioData());
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.subcollectors.AbsCollector, com.samsung.android.support.senl.p148nt.model.collector.subcollectors.ICollector
    public void preCollect(CollectInfo collectInfo, ICollectRepository iCollectRepository) {
        DataLogger.m12302d(TAG, "preCollect");
        collectInfo.setPageInfo(4);
        CollectResolver.removeStrokeSearchEntitiesWithTypes(collectInfo.getUuid(), 4);
        CollectResolver.removeStrokeSearchEntitiesWithTypes(collectInfo.getUuid(), 5);
    }
}
