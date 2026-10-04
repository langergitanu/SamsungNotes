package org.apache.xmlbeans;

import java.util.Map;
import org.apache.xmlbeans.SchemaComponent;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface SchemaIdentityConstraint extends SchemaComponent, SchemaAnnotated {
    public static final int CC_KEY = 1;
    public static final int CC_KEYREF = 2;
    public static final int CC_UNIQUE = 3;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Ref extends SchemaComponent.Ref {
        public Ref(SchemaIdentityConstraint schemaIdentityConstraint) {
            super(schemaIdentityConstraint);
        }

        public final SchemaIdentityConstraint get() {
            return (SchemaIdentityConstraint) getComponent();
        }

        @Override // org.apache.xmlbeans.SchemaComponent.Ref
        public final int getComponentType() {
            return 5;
        }

        public Ref(SchemaTypeSystem schemaTypeSystem, String str) {
            super(schemaTypeSystem, str);
        }
    }

    int getConstraintCategory();

    Object getFieldPath(int i);

    String[] getFields();

    Map getNSMap();

    SchemaIdentityConstraint getReferencedKey();

    String getSelector();

    Object getSelectorPath();

    Object getUserData();
}
