package com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor;

import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.model.common.log.CollectLogger;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class EventManager {
    private static EventBus sDefaultEventBus;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class DefaultEventBusImpl implements EventBus {
        private static final String TAG = CollectLogger.createTag("DefaultEventBusImpl");
        private final Set<Listenable> mListeners;

        public /* synthetic */ DefaultEventBusImpl(int i) {
            this();
        }

        @Override // com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor.EventBus
        public Set<Listenable> getListeners() {
            return this.mListeners;
        }

        @Override // com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor.EventBus
        public boolean publish(Event event) {
            boolean z;
            synchronized (this.mListeners) {
                z = false;
                for (Listenable listenable : this.mListeners) {
                    if (event.getEventType().equals(listenable.requestName())) {
                        try {
                            listenable.run(event);
                            z = true;
                        } catch (Exception e) {
                            Logger.m8698e(TAG, "publish failed " + e.toString());
                        }
                    }
                }
            }
            return z;
        }

        @Override // com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor.EventBus
        public void register(Listenable listenable) {
            synchronized (this.mListeners) {
                this.mListeners.add(listenable);
            }
        }

        @Override // com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor.EventBus
        public void unregister(Listenable listenable) {
            synchronized (this.mListeners) {
                this.mListeners.remove(listenable);
            }
        }

        private DefaultEventBusImpl() {
            this.mListeners = new HashSet();
        }
    }

    public static synchronized EventBus getEventBus() {
        try {
            if (sDefaultEventBus == null) {
                sDefaultEventBus = new DefaultEventBusImpl(0);
            }
        } catch (Throwable th) {
            throw th;
        }
        return sDefaultEventBus;
    }
}
