package org.apache.xmlbeans;

import org.apache.xmlbeans.XmlCursor;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class SchemaBookmark extends XmlCursor.XmlBookmark {
    private Object _value;

    public SchemaBookmark(Object obj) {
        this._value = obj;
    }

    public Object getValue() {
        return this._value;
    }
}
