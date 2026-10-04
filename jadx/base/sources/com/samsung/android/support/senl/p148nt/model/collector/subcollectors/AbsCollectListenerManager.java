package com.samsung.android.support.senl.p148nt.model.collector.subcollectors;

import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.model.collector.common.CollectInfo;
import com.samsung.android.support.senl.p148nt.model.collector.common.CollectResult;
import com.samsung.android.support.senl.p148nt.model.collector.common.ICollectResult;
import com.samsung.android.support.senl.p148nt.model.collector.repository.ICollectRepository;
import com.samsung.android.support.senl.p148nt.model.common.log.CollectLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class AbsCollectListenerManager implements ICollectListenerManager<ICollectListener> {
    private static final String TAG = CollectLogger.createTag("AbsCollectListenerManager");
    protected final List<ICollectListener> mListenerList = new CopyOnWriteArrayList();

    @Override // com.samsung.android.support.senl.p148nt.model.collector.subcollectors.ICollectListenerManager
    public SpenWNote getOpenedDoc(CollectInfo collectInfo) {
        Iterator<ICollectListener> it = this.mListenerList.iterator();
        while (it.hasNext()) {
            SpenWNote openedDoc = it.next().getOpenedDoc(collectInfo);
            if (openedDoc != null) {
                return openedDoc;
            }
        }
        return null;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.subcollectors.ICollectListenerManager
    public void notifyOnCollectCanceled(CollectInfo collectInfo, ICollectRepository iCollectRepository) {
        if (this.mListenerList.isEmpty()) {
            return;
        }
        DataLogger.m12302d(TAG, "notifyOnCollectCanceled, uuid: " + collectInfo.getUuid());
        Iterator<ICollectListener> it = this.mListenerList.iterator();
        while (it.hasNext()) {
            it.next().onCollectCanceled(collectInfo, new CollectResult(ICollectResult.Result.CANCELED.getValue(), iCollectRepository));
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.subcollectors.ICollectListenerManager
    public void notifyOnCollectFailed(CollectInfo collectInfo, ICollectRepository iCollectRepository) {
        if (this.mListenerList.isEmpty()) {
            return;
        }
        DataLogger.m12302d(TAG, "notifyOnCollectFailed, uuid: " + collectInfo.getUuid());
        Iterator<ICollectListener> it = this.mListenerList.iterator();
        while (it.hasNext()) {
            it.next().onCollectFailed(collectInfo, new CollectResult(ICollectResult.Result.FAILED.getValue(), iCollectRepository));
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.subcollectors.ICollectListenerManager
    public void notifyOnCollectFinished(CollectInfo collectInfo, ICollectRepository iCollectRepository) {
        if (this.mListenerList.isEmpty()) {
            return;
        }
        DataLogger.m12302d(TAG, "notifyOnCollectFinished, uuid: " + collectInfo.getUuid());
        Iterator<ICollectListener> it = this.mListenerList.iterator();
        while (it.hasNext()) {
            it.next().onCollectFinished(collectInfo, new CollectResult(ICollectResult.Result.FINISHED.getValue(), iCollectRepository));
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.subcollectors.ICollectListenerManager
    public void notifyOnCollectStarted(CollectInfo collectInfo) {
        if (this.mListenerList.isEmpty()) {
            return;
        }
        DataLogger.m12302d(TAG, "notifyOnCollectStarted, uuid: " + collectInfo.getUuid());
        Iterator<ICollectListener> it = this.mListenerList.iterator();
        while (it.hasNext()) {
            it.next().onCollectStarted(collectInfo);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.subcollectors.ICollectListenerManager
    public void setStrokeRecognitionData(Map<String, ArrayList<SpenWPage.StrokeRecognitionData>> map, List<String> list, boolean z) {
        Iterator<ICollectListener> it = this.mListenerList.iterator();
        while (it.hasNext()) {
            it.next().setStrokeRecognitionData(map, list, z);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.subcollectors.ICollectListenerManager
    public void addListener(ICollectListener iCollectListener) {
        if (iCollectListener == null || this.mListenerList.contains(iCollectListener)) {
            return;
        }
        this.mListenerList.add(iCollectListener);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.subcollectors.ICollectListenerManager
    public void removeListener(ICollectListener iCollectListener) {
        if (iCollectListener == null || !this.mListenerList.contains(iCollectListener)) {
            return;
        }
        this.mListenerList.remove(iCollectListener);
    }
}
