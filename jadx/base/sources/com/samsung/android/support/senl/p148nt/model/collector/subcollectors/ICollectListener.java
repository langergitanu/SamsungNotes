package com.samsung.android.support.senl.p148nt.model.collector.subcollectors;

import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p148nt.model.collector.common.CollectInfo;
import com.samsung.android.support.senl.p148nt.model.collector.common.ICollectResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface ICollectListener {
    SpenWNote getOpenedDoc(CollectInfo collectInfo);

    void onCollectCanceled(CollectInfo collectInfo, ICollectResult iCollectResult);

    void onCollectFailed(CollectInfo collectInfo, ICollectResult iCollectResult);

    void onCollectFinished(CollectInfo collectInfo, ICollectResult iCollectResult);

    void onCollectStarted(CollectInfo collectInfo);

    void setStrokeRecognitionData(Map<String, ArrayList<SpenWPage.StrokeRecognitionData>> map, List<String> list, boolean z);
}
