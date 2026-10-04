package org.apache.xmlbeans.impl.values;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlNormalizedString;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class XmlNormalizedStringImpl extends JavaStringHolderEx implements XmlNormalizedString {
    public XmlNormalizedStringImpl() {
        super(XmlNormalizedString.type, false);
    }

    public XmlNormalizedStringImpl(SchemaType schemaType, boolean z) {
        super(schemaType, z);
    }
}
