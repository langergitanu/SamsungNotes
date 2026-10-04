package opennlp.tools.formats.brat;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class EventAnnotation extends BratAnnotation {
    private final Map<String, String> arguments;
    private final String eventTrigger;

    public EventAnnotation(String str, String str2, String str3, Map<String, String> map) {
        super(str, str2);
        Objects.requireNonNull(str3);
        this.eventTrigger = str3;
        HashMap map2 = new HashMap(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            Objects.requireNonNull(key);
            String value = entry.getValue();
            Objects.requireNonNull(value);
            map2.put(key, value);
        }
        this.arguments = Collections.unmodifiableMap(map2);
    }

    public Map<String, String> getArguments() {
        return this.arguments;
    }

    public String getEventTrigger() {
        return this.eventTrigger;
    }
}
