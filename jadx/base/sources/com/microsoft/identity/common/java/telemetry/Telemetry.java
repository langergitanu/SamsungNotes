package com.microsoft.identity.common.java.telemetry;

import com.microsoft.identity.common.java.logging.DiagnosticContext;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.telemetry.adapter.BrokerTelemetryAdapter;
import com.microsoft.identity.common.java.telemetry.adapter.TelemetryAggregationAdapter;
import com.microsoft.identity.common.java.telemetry.adapter.TelemetryDefaultAdapter;
import com.microsoft.identity.common.java.telemetry.events.BaseEvent;
import com.microsoft.identity.common.java.telemetry.observers.IBrokerTelemetryObserver;
import com.microsoft.identity.common.java.telemetry.observers.ITelemetryAggregatedObserver;
import com.microsoft.identity.common.java.telemetry.observers.ITelemetryDefaultObserver;
import com.microsoft.identity.common.java.telemetry.observers.ITelemetryObserver;
import com.microsoft.identity.common.java.telemetry.rules.TelemetryPiiOiiRules;
import com.microsoft.identity.common.java.util.StringUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class Telemetry {
    private static final String TAG = "Telemetry";
    private static Queue<ITelemetryObserver> mObservers;
    private static volatile Telemetry sTelemetryInstance;
    private TelemetryConfiguration mDefaultConfiguration;
    private boolean mIsDebugging;
    private final boolean mIsTelemetryEnabled;
    private AbstractTelemetryContext mTelemetryContext;
    private Queue<Map<String, String>> mTelemetryRawDataMap;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Builder {
        private TelemetryConfiguration mDefaultConfiguration;
        private Boolean mIsDebugging;
        private AbstractTelemetryContext mTelemetryContext;

        public Telemetry build() {
            return Telemetry.prepareInstance(this);
        }

        public Builder defaultConfiguration(TelemetryConfiguration telemetryConfiguration) {
            this.mDefaultConfiguration = telemetryConfiguration;
            return this;
        }

        public Builder isDebugging(boolean z) {
            this.mIsDebugging = Boolean.valueOf(z);
            return this;
        }

        public Builder withTelemetryContext(AbstractTelemetryContext abstractTelemetryContext) {
            this.mTelemetryContext = abstractTelemetryContext;
            return this;
        }
    }

    public Telemetry() {
        this.mIsTelemetryEnabled = false;
    }

    private Map<String, String> applyPiiOiiRule(Map<String, String> map) {
        if (this.mDefaultConfiguration.isPiiEnabled()) {
            Logger.warn(TAG, "Telemetry PII/OII is enabled by the developer.");
            return map;
        }
        HashMap map2 = new HashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!TelemetryPiiOiiRules.getInstance().isPiiOrOii(entry.getKey())) {
                map2.put(entry.getKey(), entry.getValue());
            }
        }
        return map2;
    }

    public static void emit(BaseEvent baseEvent) {
        Telemetry telemetry = getInstance();
        if (telemetry.mIsTelemetryEnabled) {
            telemetry.getRequestMap().add(baseEvent.getProperties());
        }
    }

    public static synchronized Telemetry getInstance() {
        try {
            if (sTelemetryInstance == null) {
                new Builder().build();
            }
        } catch (Throwable th) {
            throw th;
        }
        return sTelemetryInstance;
    }

    private synchronized Queue<Map<String, String>> getRequestMap() {
        return this.mTelemetryRawDataMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized Telemetry prepareInstance(Builder builder) {
        try {
            if (sTelemetryInstance == null || !sTelemetryInstance.mIsTelemetryEnabled) {
                sTelemetryInstance = new Telemetry(builder);
            }
        } catch (Throwable th) {
            throw th;
        }
        return sTelemetryInstance;
    }

    private void processRawMap(List<Map<String, String>> list) {
        list.add(applyPiiOiiRule(this.mTelemetryContext.getProperties()));
        Queue<ITelemetryObserver> queue = mObservers;
        if (queue == null) {
            Logger.warn(TAG, "No telemetry observer set.");
            return;
        }
        for (ITelemetryObserver iTelemetryObserver : queue) {
            if (iTelemetryObserver instanceof IBrokerTelemetryObserver) {
                new BrokerTelemetryAdapter((IBrokerTelemetryObserver) iTelemetryObserver).process(list);
            } else if (iTelemetryObserver instanceof ITelemetryAggregatedObserver) {
                new TelemetryAggregationAdapter((ITelemetryAggregatedObserver) iTelemetryObserver).process(list);
            } else if (iTelemetryObserver instanceof ITelemetryDefaultObserver) {
                new TelemetryDefaultAdapter((ITelemetryDefaultObserver) iTelemetryObserver).process(list);
            } else {
                Logger.warn(TAG, "Unknown observer type: " + iTelemetryObserver.getClass());
            }
        }
    }

    public synchronized void addObserver(ITelemetryObserver iTelemetryObserver) {
        try {
            if (iTelemetryObserver == null) {
                throw new IllegalArgumentException("Telemetry Observer instance cannot be null");
            }
            if (mObservers == null) {
                mObservers = new ConcurrentLinkedQueue();
            }
            if (!mObservers.contains(iTelemetryObserver)) {
                mObservers.add(iTelemetryObserver);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void flush() {
        if (getInstance().mIsTelemetryEnabled) {
            flush(DiagnosticContext.INSTANCE.getRequestContext().get("correlation_id"));
        }
    }

    public List<Map<String, String>> getMap() {
        return getInstance().mIsTelemetryEnabled ? getMap(DiagnosticContext.INSTANCE.getRequestContext().get("correlation_id")) : Collections.EMPTY_LIST;
    }

    public synchronized List<ITelemetryObserver> getObservers() {
        try {
        } catch (Throwable th) {
            throw th;
        }
        return Collections.unmodifiableList(mObservers != null ? new CopyOnWriteArrayList(mObservers) : new CopyOnWriteArrayList());
    }

    public synchronized void removeAllObservers() {
        Queue<ITelemetryObserver> queue = mObservers;
        if (queue == null) {
            return;
        }
        queue.clear();
    }

    public synchronized void removeObserver(Class<?> cls) {
        if (cls != null) {
            Queue<ITelemetryObserver> queue = mObservers;
            if (queue != null && !queue.isEmpty()) {
                Iterator<ITelemetryObserver> it = mObservers.iterator();
                while (it.hasNext()) {
                    if (it.next().getClass() == cls) {
                        Logger.verbose(TAG, "The [" + cls.getSimpleName() + "] observer is removed.");
                        it.remove();
                    }
                }
                return;
            }
        }
        Logger.warn(TAG + ":removeObserver", "Unable to remove the observe. Either the observer is null or the observer list is empty.");
    }

    private Telemetry(Builder builder) {
        if (builder != null && builder.mTelemetryContext != null && builder.mDefaultConfiguration != null) {
            this.mIsTelemetryEnabled = true;
            this.mDefaultConfiguration = builder.mDefaultConfiguration;
            this.mTelemetryContext = builder.mTelemetryContext;
            this.mIsDebugging = builder.mIsDebugging.booleanValue();
            this.mTelemetryRawDataMap = new ConcurrentLinkedQueue();
            return;
        }
        Logger.warn(TAG, "Telemetry is disabled because the Telemetry context or configuration is null");
        this.mIsTelemetryEnabled = false;
    }

    public void flush(@NonNull String str) {
        if (str != null) {
            if (this.mIsTelemetryEnabled) {
                if (StringUtil.isNullOrEmpty(str)) {
                    Logger.warn(TAG, "No correlation id set.");
                    return;
                }
                if (this.mDefaultConfiguration.isDebugEnabled() || !this.mIsDebugging) {
                    CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                    Iterator<Map<String, String>> it = this.mTelemetryRawDataMap.iterator();
                    while (it.hasNext()) {
                        Map<String, String> next = it.next();
                        if (str.equalsIgnoreCase(next.get("Microsoft.MSAL.correlation_id"))) {
                            copyOnWriteArrayList.add(applyPiiOiiRule(next));
                            it.remove();
                        }
                    }
                    processRawMap(copyOnWriteArrayList);
                    return;
                }
                return;
            }
            return;
        }
        throw new NullPointerException("correlationId is marked non-null but is null");
    }

    public List<Map<String, String>> getMap(@NonNull String str) {
        if (str != null) {
            if (!this.mIsTelemetryEnabled) {
                return Collections.EMPTY_LIST;
            }
            if (StringUtil.isNullOrEmpty(str)) {
                Logger.warn(TAG, "No correlation id set.");
                return Collections.EMPTY_LIST;
            }
            if (!this.mDefaultConfiguration.isDebugEnabled() && this.mIsDebugging) {
                return Collections.EMPTY_LIST;
            }
            ArrayList arrayList = new ArrayList();
            for (Map<String, String> map : this.mTelemetryRawDataMap) {
                if (str.equalsIgnoreCase(map.get("Microsoft.MSAL.correlation_id"))) {
                    arrayList.add(applyPiiOiiRule(map));
                }
            }
            return arrayList;
        }
        throw new NullPointerException("correlationId is marked non-null but is null");
    }

    public synchronized void removeObserver(ITelemetryObserver iTelemetryObserver) {
        if (iTelemetryObserver != null) {
            Queue<ITelemetryObserver> queue = mObservers;
            if (queue != null && !queue.isEmpty()) {
                mObservers.remove(iTelemetryObserver);
                return;
            }
        }
        Logger.warn(TAG + ":removeObserver", "Unable to remove the observer. Either the observer is null or the observer list is empty.");
    }
}
