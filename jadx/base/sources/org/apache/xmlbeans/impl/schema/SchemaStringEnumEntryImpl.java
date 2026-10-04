package org.apache.xmlbeans.impl.schema;

import org.apache.xmlbeans.SchemaStringEnumEntry;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class SchemaStringEnumEntryImpl implements SchemaStringEnumEntry {
    private String _enumName;
    private int _int;
    private String _string;

    public SchemaStringEnumEntryImpl(String str, int i, String str2) {
        this._string = str;
        this._int = i;
        this._enumName = str2;
    }

    @Override // org.apache.xmlbeans.SchemaStringEnumEntry
    public String getEnumName() {
        return this._enumName;
    }

    @Override // org.apache.xmlbeans.SchemaStringEnumEntry
    public int getIntValue() {
        return this._int;
    }

    @Override // org.apache.xmlbeans.SchemaStringEnumEntry
    public String getString() {
        return this._string;
    }
}
