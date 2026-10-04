package org.apache.xmlbeans.impl.values;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaField;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface TypeStoreVisitor {
    String get_default_text();

    int get_elementflags();

    SchemaField get_schema_field();

    boolean visit(QName qName);
}
