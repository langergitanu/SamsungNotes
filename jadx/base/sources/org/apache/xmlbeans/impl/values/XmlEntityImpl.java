package org.apache.xmlbeans.impl.values;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlENTITY;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class XmlEntityImpl extends JavaStringHolderEx implements XmlENTITY {
    public XmlEntityImpl() {
        super(XmlENTITY.type, false);
    }

    public XmlEntityImpl(SchemaType schemaType, boolean z) {
        super(schemaType, z);
    }
}
