package org.apache.xmlbeans;

import kotlin.collections.AbstractC12991c;
import org.apache.poi.javax.xml.namespace.QName;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface SchemaComponent {
    public static final int ANNOTATION = 8;
    public static final int ATTRIBUTE = 3;
    public static final int ATTRIBUTE_GROUP = 4;
    public static final int ELEMENT = 1;
    public static final int IDENTITY_CONSTRAINT = 5;
    public static final int MODEL_GROUP = 6;
    public static final int NOTATION = 7;
    public static final int TYPE = 0;

    /* JADX INFO: renamed from: org.apache.xmlbeans.SchemaComponent$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    /* synthetic */ class C141691 {
        static /* synthetic */ Class class$org$apache$xmlbeans$SchemaComponent;

        public static /* synthetic */ Class class$(String str) throws Throwable {
            try {
                return Class.forName(str);
            } catch (ClassNotFoundException e) {
                throw AbstractC12991c.m13994o(e);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class Ref {
        static final /* synthetic */ boolean $assertionsDisabled;
        public String _handle;
        private volatile SchemaComponent _schemaComponent;
        private SchemaTypeSystem _schemaTypeSystem;

        static {
            if (C141691.class$org$apache$xmlbeans$SchemaComponent == null) {
                C141691.class$org$apache$xmlbeans$SchemaComponent = C141691.class$("org.apache.xmlbeans.SchemaComponent");
            }
            $assertionsDisabled = true;
        }

        public Ref(SchemaComponent schemaComponent) {
            this._schemaComponent = schemaComponent;
        }

        public final SchemaComponent getComponent() {
            String str;
            if (this._schemaComponent == null && this._handle != null) {
                synchronized (this) {
                    try {
                        if (this._schemaComponent == null && (str = this._handle) != null) {
                            this._schemaComponent = this._schemaTypeSystem.resolveHandle(str);
                            this._schemaTypeSystem = null;
                        }
                    } finally {
                    }
                }
            }
            return this._schemaComponent;
        }

        public abstract int getComponentType();

        public final SchemaTypeSystem getTypeSystem() {
            return this._schemaTypeSystem;
        }

        public Ref(SchemaTypeSystem schemaTypeSystem, String str) {
            if (!$assertionsDisabled && str == null) {
                throw new AssertionError();
            }
            this._schemaTypeSystem = schemaTypeSystem;
            this._handle = str;
        }
    }

    Ref getComponentRef();

    int getComponentType();

    QName getName();

    String getSourceName();

    SchemaTypeSystem getTypeSystem();
}
