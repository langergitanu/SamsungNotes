package org.apache.xmlbeans.impl.values;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class JavaBooleanHolderEx extends JavaBooleanHolder {
    private SchemaType _schemaType;

    public JavaBooleanHolderEx(SchemaType schemaType, boolean z) {
        this._schemaType = schemaType;
        initComplexType(z, false);
    }

    public static boolean validateLexical(String str, SchemaType schemaType, ValidationContext validationContext) {
        boolean zValidateLexical = JavaBooleanHolder.validateLexical(str, validationContext);
        validatePattern(str, schemaType, validationContext);
        return zValidateLexical;
    }

    public static void validatePattern(String str, SchemaType schemaType, ValidationContext validationContext) {
        if (schemaType.matchPatternFacet(str)) {
            return;
        }
        validationContext.invalid(XmlErrorCodes.DATATYPE_VALID$PATTERN_VALID, new Object[]{"boolean", str, QNameHelper.readable(schemaType)});
    }

    @Override // org.apache.xmlbeans.impl.values.JavaBooleanHolder, org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return this._schemaType;
    }

    @Override // org.apache.xmlbeans.impl.values.JavaBooleanHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_text(String str) {
        if (_validateOnSet()) {
            validatePattern(str, this._schemaType, XmlObjectBase._voorVc);
        }
        super.set_text(str);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void validate_simpleval(String str, ValidationContext validationContext) {
        validateLexical(str, schemaType(), validationContext);
    }
}
