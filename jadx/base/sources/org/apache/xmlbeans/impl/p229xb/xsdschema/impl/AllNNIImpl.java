package org.apache.xmlbeans.impl.p229xb.xsdschema.impl;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlNonNegativeInteger;
import org.apache.xmlbeans.impl.p229xb.xsdschema.AllNNI;
import org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx;
import org.apache.xmlbeans.impl.values.XmlUnionImpl;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class AllNNIImpl extends XmlUnionImpl implements AllNNI, XmlNonNegativeInteger, AllNNI.Member {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class MemberImpl extends JavaStringEnumerationHolderEx implements AllNNI.Member {
        public MemberImpl(SchemaType schemaType) {
            super(schemaType, false);
        }

        public MemberImpl(SchemaType schemaType, boolean z) {
            super(schemaType, z);
        }
    }

    public AllNNIImpl(SchemaType schemaType) {
        super(schemaType, false);
    }

    public AllNNIImpl(SchemaType schemaType, boolean z) {
        super(schemaType, z);
    }
}
