package uk.p245ac.p246ed.p247ph.snuggletex.internal;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class VariableManager {
    private final Map<String, Map<String, Object>> variableMap = new HashMap();

    public Object getVariable(String str, String str2) {
        Map<String, Object> map = this.variableMap.get(str);
        if (map != null) {
            return map.get(str2);
        }
        return null;
    }

    public Map<String, Object> getVariableMapForNamespace(String str) {
        return this.variableMap.get(str);
    }

    public void setVariable(String str, String str2, Object obj) {
        Map<String, Object> map = this.variableMap.get(str);
        if (map == null) {
            map = new HashMap<>();
            this.variableMap.put(str, map);
        }
        map.put(str2, obj);
    }
}
