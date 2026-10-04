package com.samsung.android.support.senl.p148nt.coedit.caller;

import android.os.Handler;
import android.os.Looper;
import com.samsung.android.support.senl.p148nt.coedit.log.CoeditLogger;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CoeditNoteEventManager {
    public static final String LINK_EVENT_STRING = "COEDIT_LINK_";
    private static EventBus sDefaultEventBus;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class DefaultEventBusImpl implements EventBus {
        private static final String TAG = "DefaultEventBusImpl";
        private final Set<Listenable> mListeners;

        public /* synthetic */ DefaultEventBusImpl(int i) {
            this();
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.caller.EventBus
        public boolean publish(final Event event) {
            boolean z;
            synchronized (this.mListeners) {
                z = false;
                for (final Listenable listenable : this.mListeners) {
                    if (event.getEventType().equals(listenable.requestName())) {
                        try {
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.samsung.android.support.senl.nt.coedit.caller.CoeditNoteEventManager.DefaultEventBusImpl.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    listenable.run(event);
                                }
                            });
                            z = true;
                        } catch (Exception e) {
                            CoeditLogger.m8920e(TAG, "publish failed " + e.getMessage());
                        }
                    }
                }
            }
            return z;
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.caller.EventBus
        public void register(Listenable listenable) {
            synchronized (this.mListeners) {
                this.mListeners.add(listenable);
            }
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.caller.EventBus
        public void unregister(Listenable listenable) {
            synchronized (this.mListeners) {
                this.mListeners.remove(listenable);
            }
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.caller.EventBus
        public void unregisterAll() {
            synchronized (this.mListeners) {
                this.mListeners.clear();
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
