package org.apache.xmlbeans.impl.p229xb.xsdschema.impl;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlNonNegativeInteger;
import org.apache.xmlbeans.impl.p229xb.xsdschema.All;
import org.apache.xmlbeans.impl.p229xb.xsdschema.AllNNI;
import org.apache.xmlbeans.impl.values.JavaIntegerHolderEx;
import org.apache.xmlbeans.impl.values.XmlUnionImpl;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class AllImpl extends ExplicitGroupImpl implements All {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class MaxOccursImpl extends XmlUnionImpl implements All.MaxOccurs, XmlNonNegativeInteger, AllNNI.Member {
        public MaxOccursImpl(SchemaType schemaType) {
            super(schemaType, false);
        }

        public MaxOccursImpl(SchemaType schemaType, boolean z) {
            super(schemaType, z);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class MinOccursImpl extends JavaIntegerHolderEx implements All.MinOccurs {
        public MinOccursImpl(SchemaType schemaType) {
            super(schemaType, false);
        }

        public MinOccursImpl(SchemaType schemaType, boolean z) {
            super(schemaType, z);
        }
    }

    public AllImpl(SchemaType schemaType) {
        super(schemaType);
    }
}
