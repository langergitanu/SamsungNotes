package org.apache.xmlbeans.impl.values;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.BuiltinSchemaTypeSystem;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class XmlAnySimpleTypeImpl extends XmlObjectBase implements XmlAnySimpleType {
    private SchemaType _schemaType;
    String _textvalue;

    public XmlAnySimpleTypeImpl(SchemaType schemaType, boolean z) {
        this._textvalue = "";
        this._schemaType = schemaType;
        initComplexType(z, false);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public String compute_text(NamespaceManager namespaceManager) {
        return this._textvalue;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public boolean equal_to(XmlObject xmlObject) {
        return this._textvalue.equals(((XmlAnySimpleType) xmlObject).getStringValue());
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public int get_wscanon_rule() {
        return 1;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return this._schemaType;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_nil() {
        this._textvalue = null;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_text(String str) {
        this._textvalue = str;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public int value_hash_code() {
        String str = this._textvalue;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public XmlAnySimpleTypeImpl() {
        this._textvalue = "";
        this._schemaType = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
    }
}
