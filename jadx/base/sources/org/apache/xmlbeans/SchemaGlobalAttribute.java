package org.apache.xmlbeans;

import org.apache.xmlbeans.SchemaComponent;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface SchemaGlobalAttribute extends SchemaLocalAttribute, SchemaComponent {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Ref extends SchemaComponent.Ref {
        public Ref(SchemaGlobalAttribute schemaGlobalAttribute) {
            super(schemaGlobalAttribute);
        }

        public final SchemaGlobalAttribute get() {
            return (SchemaGlobalAttribute) getComponent();
        }

        @Override // org.apache.xmlbeans.SchemaComponent.Ref
        public final int getComponentType() {
            return 3;
        }

        public Ref(SchemaTypeSystem schemaTypeSystem, String str) {
            super(schemaTypeSystem, str);
        }
    }

    Ref getRef();
}
