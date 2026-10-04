package org.apache.xmlbeans.impl.values;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.common.ValidationContext;
import org.apache.xmlbeans.impl.schema.BuiltinSchemaTypeSystem;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class JavaBooleanHolder extends XmlObjectBase {
    private boolean _value;

    public static boolean validateLexical(String str, ValidationContext validationContext) {
        if (str.equals("true") || str.equals("1")) {
            return true;
        }
        if (!str.equals("false") && !str.equals("0")) {
            validationContext.invalid("boolean", new Object[]{str});
        }
        return false;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public int compare_to(XmlObject xmlObject) {
        return this._value == ((XmlBoolean) xmlObject).getBooleanValue() ? 0 : 2;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public String compute_text(NamespaceManager namespaceManager) {
        return this._value ? "true" : "false";
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public boolean equal_to(XmlObject xmlObject) {
        return this._value == ((XmlBoolean) xmlObject).getBooleanValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public boolean getBooleanValue() {
        check_dated();
        return this._value;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return BuiltinSchemaTypeSystem.ST_BOOLEAN;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_boolean(boolean z) {
        this._value = z;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_nil() {
        this._value = false;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_text(String str) {
        this._value = validateLexical(str, XmlObjectBase._voorVc);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public int value_hash_code() {
        return this._value ? 957379554 : 676335975;
    }
}
