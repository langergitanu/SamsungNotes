package com.opencsv.bean;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class HeaderColumnNameTranslateMappingStrategy<T> extends HeaderNameBaseMappingStrategy<T> {
    private final Map<String, String> columnMapping;

    public HeaderColumnNameTranslateMappingStrategy() {
        this.columnMapping = new HashMap();
    }

    public Map<String, String> getColumnMapping() {
        return this.columnMapping;
    }

    @Override // com.opencsv.bean.AbstractMappingStrategy
    public String getColumnName(int i) {
        String byPosition = this.headerIndex.getByPosition(i);
        return byPosition != null ? this.columnMapping.get(byPosition.toUpperCase()) : byPosition;
    }

    public void setColumnMapping(Map<String, String> map) {
        this.columnMapping.clear();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            this.columnMapping.put(entry.getKey().toUpperCase(), entry.getValue());
        }
        if (getType() != null) {
            loadFieldMap();
        }
    }

    public HeaderColumnNameTranslateMappingStrategy(boolean z) {
        super(z);
        this.columnMapping = new HashMap();
    }
}
