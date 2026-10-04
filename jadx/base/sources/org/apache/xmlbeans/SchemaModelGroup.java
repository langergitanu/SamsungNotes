package org.apache.xmlbeans;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaComponent;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface SchemaModelGroup extends SchemaComponent, SchemaAnnotated {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Ref extends SchemaComponent.Ref {
        public Ref(SchemaModelGroup schemaModelGroup) {
            super(schemaModelGroup);
        }

        public final SchemaModelGroup get() {
            return (SchemaModelGroup) getComponent();
        }

        @Override // org.apache.xmlbeans.SchemaComponent.Ref
        public final int getComponentType() {
            return 6;
        }

        public Ref(SchemaTypeSystem schemaTypeSystem, String str) {
            super(schemaTypeSystem, str);
        }
    }

    @Override // org.apache.xmlbeans.SchemaComponent
    int getComponentType();

    @Override // org.apache.xmlbeans.SchemaComponent
    QName getName();

    Object getUserData();
}
