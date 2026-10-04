package org.apache.xmlbeans.impl.values;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlTokenSource;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class JavaFloatHolderEx extends JavaFloatHolder {
    private SchemaType _schemaType;

    public JavaFloatHolderEx(SchemaType schemaType, boolean z) {
        this._schemaType = schemaType;
        initComplexType(z, false);
    }

    public static float validateLexical(String str, SchemaType schemaType, ValidationContext validationContext) {
        float fValidateLexical = JavaFloatHolder.validateLexical(str, validationContext);
        if (!schemaType.matchPatternFacet(str)) {
            validationContext.invalid(XmlErrorCodes.DATATYPE_VALID$PATTERN_VALID, new Object[]{"float", str, QNameHelper.readable(schemaType)});
        }
        return fValidateLexical;
    }

    public static void validateValue(float f, SchemaType schemaType, ValidationContext validationContext) {
        XmlTokenSource facet = schemaType.getFacet(3);
        if (facet != null) {
            float fFloatValue = ((XmlObjectBase) facet).floatValue();
            if (JavaFloatHolder.compare(f, fFloatValue) <= 0) {
                validationContext.invalid(XmlErrorCodes.DATATYPE_MIN_EXCLUSIVE_VALID, new Object[]{"float", new Float(f), new Float(fFloatValue), QNameHelper.readable(schemaType)});
            }
        }
        XmlTokenSource facet2 = schemaType.getFacet(4);
        if (facet2 != null) {
            float fFloatValue2 = ((XmlObjectBase) facet2).floatValue();
            if (JavaFloatHolder.compare(f, fFloatValue2) < 0) {
                validationContext.invalid(XmlErrorCodes.DATATYPE_MIN_INCLUSIVE_VALID, new Object[]{"float", new Float(f), new Float(fFloatValue2), QNameHelper.readable(schemaType)});
            }
        }
        XmlTokenSource facet3 = schemaType.getFacet(5);
        if (facet3 != null) {
            float fFloatValue3 = ((XmlObjectBase) facet3).floatValue();
            if (JavaFloatHolder.compare(f, fFloatValue3) > 0) {
                validationContext.invalid(XmlErrorCodes.DATATYPE_MAX_INCLUSIVE_VALID, new Object[]{"float", new Float(f), new Float(fFloatValue3), QNameHelper.readable(schemaType)});
            }
        }
        XmlTokenSource facet4 = schemaType.getFacet(6);
        if (facet4 != null) {
            float fFloatValue4 = ((XmlObjectBase) facet4).floatValue();
            if (JavaFloatHolder.compare(f, fFloatValue4) >= 0) {
                validationContext.invalid(XmlErrorCodes.DATATYPE_MAX_EXCLUSIVE_VALID, new Object[]{"float", new Float(f), new Float(fFloatValue4), QNameHelper.readable(schemaType)});
            }
        }
        Object[] enumerationValues = schemaType.getEnumerationValues();
        if (enumerationValues != null) {
            for (Object obj : enumerationValues) {
                if (JavaFloatHolder.compare(f, ((XmlObjectBase) obj).floatValue()) == 0) {
                    return;
                }
            }
            validationContext.invalid(XmlErrorCodes.DATATYPE_ENUM_VALID, new Object[]{"float", new Float(f), QNameHelper.readable(schemaType)});
        }
    }

    @Override // org.apache.xmlbeans.impl.values.JavaFloatHolder, org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return this._schemaType;
    }

    @Override // org.apache.xmlbeans.impl.values.JavaFloatHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_float(float f) {
        if (_validateOnSet()) {
            validateValue(f, this._schemaType, XmlObjectBase._voorVc);
        }
        super.set_float(f);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void validate_simpleval(String str, ValidationContext validationContext) {
        validateLexical(str, schemaType(), validationContext);
        validateValue(floatValue(), schemaType(), validationContext);
    }
}
