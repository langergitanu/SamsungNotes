package org.apache.xmlbeans.impl.values;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class JavaStringEnumerationHolderEx extends JavaStringHolderEx {
    private StringEnumAbstractBase _val;

    public JavaStringEnumerationHolderEx(SchemaType schemaType, boolean z) {
        super(schemaType, z);
    }

    public static void validateLexical(String str, SchemaType schemaType, ValidationContext validationContext) {
        JavaStringHolderEx.validateLexical(str, schemaType, validationContext);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public StringEnumAbstractBase getEnumValue() {
        check_dated();
        return this._val;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_enum(StringEnumAbstractBase stringEnumAbstractBase) {
        Class enumJavaClass = schemaType().getEnumJavaClass();
        if (enumJavaClass != null && !stringEnumAbstractBase.getClass().equals(enumJavaClass)) {
            throw new XmlValueOutOfRangeException();
        }
        super.set_text(stringEnumAbstractBase.toString());
        this._val = stringEnumAbstractBase;
    }

    @Override // org.apache.xmlbeans.impl.values.JavaStringHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_nil() {
        this._val = null;
        super.set_nil();
    }

    @Override // org.apache.xmlbeans.impl.values.JavaStringHolderEx, org.apache.xmlbeans.impl.values.JavaStringHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_text(String str) {
        StringEnumAbstractBase stringEnumAbstractBaseEnumForString = schemaType().enumForString(str);
        if (stringEnumAbstractBaseEnumForString == null) {
            throw new XmlValueOutOfRangeException(XmlErrorCodes.DATATYPE_ENUM_VALID, new Object[]{"string", str, QNameHelper.readable(schemaType())});
        }
        super.set_text(str);
        this._val = stringEnumAbstractBaseEnumForString;
    }
}
