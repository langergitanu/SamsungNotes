package com.samsung.android.support.senl.p148nt.model.collector.subcollectors;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class TemplateSearchCollectListenerManager extends AbsCollectListenerManager {
    private static TemplateSearchCollectListenerManager mInstance;

    private TemplateSearchCollectListenerManager() {
    }

    public static synchronized TemplateSearchCollectListenerManager getInstance() {
        try {
            if (mInstance == null) {
                mInstance = new TemplateSearchCollectListenerManager();
            }
        } catch (Throwable th) {
            throw th;
        }
        return mInstance;
    }
}
