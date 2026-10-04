package org.apache.xmlbeans.impl.schema;

import org.apache.xmlbeans.SchemaComponent;
import org.apache.xmlbeans.SchemaGlobalAttribute;
import org.apache.xmlbeans.SchemaTypeSystem;
import org.apache.xmlbeans.XmlObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class SchemaGlobalAttributeImpl extends SchemaLocalAttributeImpl implements SchemaGlobalAttribute {
    private boolean _chameleon;
    SchemaContainer _container;
    String _filename;
    private String _parseTNS;
    private SchemaGlobalAttribute.Ref _selfref = new SchemaGlobalAttribute.Ref(this);

    public SchemaGlobalAttributeImpl(SchemaContainer schemaContainer) {
        this._container = schemaContainer;
    }

    public String getChameleonNamespace() {
        if (this._chameleon) {
            return this._parseTNS;
        }
        return null;
    }

    @Override // org.apache.xmlbeans.SchemaComponent
    public SchemaComponent.Ref getComponentRef() {
        return getRef();
    }

    @Override // org.apache.xmlbeans.SchemaComponent
    public int getComponentType() {
        return 3;
    }

    public SchemaContainer getContainer() {
        return this._container;
    }

    public XmlObject getParseObject() {
        return this._parseObject;
    }

    @Override // org.apache.xmlbeans.SchemaGlobalAttribute
    public SchemaGlobalAttribute.Ref getRef() {
        return this._selfref;
    }

    @Override // org.apache.xmlbeans.SchemaComponent
    public String getSourceName() {
        return this._filename;
    }

    public String getTargetNamespace() {
        return this._parseTNS;
    }

    @Override // org.apache.xmlbeans.SchemaComponent
    public SchemaTypeSystem getTypeSystem() {
        return this._container.getTypeSystem();
    }

    public void setFilename(String str) {
        this._filename = str;
    }

    public void setParseContext(XmlObject xmlObject, String str, boolean z) {
        this._parseObject = xmlObject;
        this._parseTNS = str;
        this._chameleon = z;
    }
}
