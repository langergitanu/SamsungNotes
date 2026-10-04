package org.apache.xmlbeans.impl.p229xb.xsdschema.impl;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.p229xb.xsdschema.DerivationSet;
import org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx;
import org.apache.xmlbeans.impl.values.XmlListImpl;
import org.apache.xmlbeans.impl.values.XmlUnionImpl;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class DerivationSetImpl extends XmlUnionImpl implements DerivationSet, DerivationSet.Member, DerivationSet.Member2 {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class MemberImpl extends JavaStringEnumerationHolderEx implements DerivationSet.Member {
        public MemberImpl(SchemaType schemaType) {
            super(schemaType, false);
        }

        public MemberImpl(SchemaType schemaType, boolean z) {
            super(schemaType, z);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class MemberImpl2 extends XmlListImpl implements DerivationSet.Member2 {
        public MemberImpl2(SchemaType schemaType) {
            super(schemaType, false);
        }

        public MemberImpl2(SchemaType schemaType, boolean z) {
            super(schemaType, z);
        }
    }

    public DerivationSetImpl(SchemaType schemaType) {
        super(schemaType, false);
    }

    public DerivationSetImpl(SchemaType schemaType, boolean z) {
        super(schemaType, z);
    }
}
