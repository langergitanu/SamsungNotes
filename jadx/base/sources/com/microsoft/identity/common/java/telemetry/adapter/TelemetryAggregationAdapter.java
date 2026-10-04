package com.microsoft.identity.common.java.telemetry.adapter;

import androidx.appcompat.widget.AbstractC0541b;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.microsoft.identity.common.java.telemetry.observers.ITelemetryAggregatedObserver;
import com.microsoft.identity.common.java.telemetry.rules.TelemetryAggregationRules;
import com.microsoft.identity.common.java.util.StringUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class TelemetryAggregationAdapter implements ITelemetryAdapter<List<Map<String, String>>> {
    private static final String END = "end";
    private static final String START = "start";
    private ITelemetryAggregatedObserver mObserver;

    public TelemetryAggregationAdapter(@NonNull ITelemetryAggregatedObserver iTelemetryAggregatedObserver) {
        if (iTelemetryAggregatedObserver == null) {
            throw new NullPointerException("observer is marked non-null but is null");
        }
        this.mObserver = iTelemetryAggregatedObserver;
    }

    private void calculateEventResponseTime(@NonNull Map<String, String> map, @NonNull Map<String, String> map2) {
        String str;
        if (map == null) {
            throw new NullPointerException("responseTimeMap is marked non-null but is null");
        }
        if (map2 == null) {
            throw new NullPointerException("aggregatedData is marked non-null but is null");
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            if (key.contains("start") && (str = map.get(key.replace("start", END))) != null) {
                map2.put(key.replace("start", "response"), String.valueOf(Long.parseLong(str) - Long.parseLong(entry.getValue())));
            }
        }
    }

    private void trackEventResponseTime(@NonNull Map<String, String> map, @NonNull Map<String, String> map2) {
        if (map == null) {
            throw new NullPointerException("responseTimeMap is marked non-null but is null");
        }
        if (map2 == null) {
            throw new NullPointerException("event is marked non-null but is null");
        }
        String str = map2.get(TelemetryEventStrings.Key.EVENT_NAME);
        String str2 = map2.get(TelemetryEventStrings.Key.EVENT_TYPE);
        if (str != null && str.contains("start")) {
            map.put(AbstractC0541b.m756B(str2, "_start_time"), map2.get(TelemetryEventStrings.Key.OCCUR_TIME));
        }
        if (str == null || !str.contains(END)) {
            return;
        }
        map.put(AbstractC0541b.m756B(str2, "_end_time"), map2.get(TelemetryEventStrings.Key.OCCUR_TIME));
    }

    public Map<String, String> aggregateEvent(@NonNull List<Map<String, String>> list) {
        if (list == null) {
            throw new NullPointerException("rawData is marked non-null but is null");
        }
        HashMap map = new HashMap();
        Map<String, String> map2 = new HashMap<>();
        for (Map<String, String> map3 : list) {
            String str = map3.get(TelemetryEventStrings.Key.EVENT_NAME);
            String str2 = map3.get(TelemetryEventStrings.Key.EVENT_TYPE);
            if (StringUtil.isNullOrEmpty(str)) {
                map.putAll(applyAggregationRule(map3));
            } else {
                if (str.contains("start")) {
                    String strM756B = AbstractC0541b.m756B(str2, "_count");
                    String str3 = (String) map.get(strM756B);
                    if (str3 == null) {
                        str3 = "0";
                    }
                    map.put(strM756B, String.valueOf(Integer.parseInt(str3) + 1));
                }
                String str4 = map3.containsKey(TelemetryEventStrings.Key.IS_SUCCESSFUL) ? map3.get(TelemetryEventStrings.Key.IS_SUCCESSFUL) : "false";
                map.put(AbstractC0541b.m756B(str2, TelemetryEventStrings.Key.IS_SUCCESSFUL), StringUtil.isNullOrEmpty(str4) ? "false" : str4);
                trackEventResponseTime(map2, map3);
                map.putAll(applyAggregationRule(map3));
            }
        }
        calculateEventResponseTime(map2, map);
        return map;
    }

    public Map<String, String> applyAggregationRule(@NonNull Map<String, String> map) {
        if (map == null) {
            throw new NullPointerException("properties is marked non-null but is null");
        }
        HashMap map2 = new HashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!StringUtil.isNullOrEmpty(entry.getValue()) && !TelemetryAggregationRules.getInstance().isRedundant(entry.getKey())) {
                map2.put(entry.getKey(), entry.getValue());
            }
        }
        return map2;
    }

    public ITelemetryAggregatedObserver getObserver() {
        return this.mObserver;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.identity.common.java.telemetry.adapter.ITelemetryAdapter
    public void process(@NonNull List<Map<String, String>> list) {
        if (list == null) {
            throw new NullPointerException("rawData is marked non-null but is null");
        }
        this.mObserver.onReceived(aggregateEvent(list));
    }
}
