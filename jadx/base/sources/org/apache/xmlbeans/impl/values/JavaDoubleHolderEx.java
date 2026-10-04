package org.apache.xmlbeans.impl.values;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlTokenSource;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class JavaDoubleHolderEx extends JavaDoubleHolder {
    private SchemaType _schemaType;

    public JavaDoubleHolderEx(SchemaType schemaType, boolean z) {
        this._schemaType = schemaType;
        initComplexType(z, false);
    }

    public static double validateLexical(String str, SchemaType schemaType, ValidationContext validationContext) {
        double dValidateLexical = JavaDoubleHolder.validateLexical(str, validationContext);
        if (!schemaType.matchPatternFacet(str)) {
            validationContext.invalid(XmlErrorCodes.DATATYPE_VALID$PATTERN_VALID, new Object[]{XmlErrorCodes.DOUBLE, str, QNameHelper.readable(schemaType)});
        }
        return dValidateLexical;
    }

    public static void validateValue(double d, SchemaType schemaType, ValidationContext validationContext) {
        XmlTokenSource facet = schemaType.getFacet(3);
        if (facet != null) {
            double dDoubleValue = ((XmlObjectBase) facet).doubleValue();
            if (JavaDoubleHolder.compare(d, dDoubleValue) <= 0) {
                validationContext.invalid(XmlErrorCodes.DATATYPE_MIN_EXCLUSIVE_VALID, new Object[]{XmlErrorCodes.DOUBLE, new Double(d), new Double(dDoubleValue), QNameHelper.readable(schemaType)});
            }
        }
        XmlTokenSource facet2 = schemaType.getFacet(4);
        if (facet2 != null) {
            double dDoubleValue2 = ((XmlObjectBase) facet2).doubleValue();
            if (JavaDoubleHolder.compare(d, dDoubleValue2) < 0) {
                validationContext.invalid(XmlErrorCodes.DATATYPE_MIN_INCLUSIVE_VALID, new Object[]{XmlErrorCodes.DOUBLE, new Double(d), new Double(dDoubleValue2), QNameHelper.readable(schemaType)});
            }
        }
        XmlTokenSource facet3 = schemaType.getFacet(5);
        if (facet3 != null) {
            double dDoubleValue3 = ((XmlObjectBase) facet3).doubleValue();
            if (JavaDoubleHolder.compare(d, dDoubleValue3) > 0) {
                validationContext.invalid(XmlErrorCodes.DATATYPE_MAX_INCLUSIVE_VALID, new Object[]{XmlErrorCodes.DOUBLE, new Double(d), new Double(dDoubleValue3), QNameHelper.readable(schemaType)});
            }
        }
        XmlTokenSource facet4 = schemaType.getFacet(6);
        if (facet4 != null) {
            double dDoubleValue4 = ((XmlObjectBase) facet4).doubleValue();
            if (JavaDoubleHolder.compare(d, dDoubleValue4) >= 0) {
                validationContext.invalid(XmlErrorCodes.DATATYPE_MAX_EXCLUSIVE_VALID, new Object[]{XmlErrorCodes.DOUBLE, new Double(d), new Double(dDoubleValue4), QNameHelper.readable(schemaType)});
            }
        }
        Object[] enumerationValues = schemaType.getEnumerationValues();
        if (enumerationValues != null) {
            for (Object obj : enumerationValues) {
                if (JavaDoubleHolder.compare(d, ((XmlObjectBase) obj).doubleValue()) == 0) {
                    return;
                }
            }
            validationContext.invalid(XmlErrorCodes.DATATYPE_ENUM_VALID, new Object[]{XmlErrorCodes.DOUBLE, new Double(d), QNameHelper.readable(schemaType)});
        }
    }

    @Override // org.apache.xmlbeans.impl.values.JavaDoubleHolder, org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return this._schemaType;
    }

    @Override // org.apache.xmlbeans.impl.values.JavaDoubleHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_double(double d) {
        if (_validateOnSet()) {
            validateValue(d, this._schemaType, XmlObjectBase._voorVc);
        }
        super.set_double(d);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void validate_simpleval(String str, ValidationContext validationContext) {
        validateLexical(str, schemaType(), validationContext);
        validateValue(doubleValue(), schemaType(), validationContext);
    }
}
