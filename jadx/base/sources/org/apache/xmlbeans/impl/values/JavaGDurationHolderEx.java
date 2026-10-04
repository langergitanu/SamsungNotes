package org.apache.xmlbeans.impl.values;

import org.apache.xmlbeans.GDuration;
import org.apache.xmlbeans.GDurationSpecification;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlTokenSource;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class JavaGDurationHolderEx extends XmlObjectBase {
    private SchemaType _schemaType;
    GDuration _value;

    public JavaGDurationHolderEx(SchemaType schemaType, boolean z) {
        this._schemaType = schemaType;
        initComplexType(z, false);
    }

    public static GDuration lex(String str, ValidationContext validationContext) {
        try {
            return new GDuration(str);
        } catch (Exception unused) {
            validationContext.invalid(XmlErrorCodes.DURATION, new Object[]{str});
            return null;
        }
    }

    public static GDuration validateLexical(String str, SchemaType schemaType, ValidationContext validationContext) {
        GDuration gDurationLex = lex(str, validationContext);
        if (gDurationLex != null && schemaType.hasPatternFacet() && !schemaType.matchPatternFacet(str)) {
            validationContext.invalid(XmlErrorCodes.DATATYPE_VALID$PATTERN_VALID, new Object[]{XmlErrorCodes.DURATION, str, QNameHelper.readable(schemaType)});
        }
        return gDurationLex;
    }

    public static void validateValue(GDurationSpecification gDurationSpecification, SchemaType schemaType, ValidationContext validationContext) {
        XmlTokenSource facet = schemaType.getFacet(3);
        if (facet != null) {
            GDuration gDurationGDurationValue = ((XmlObjectBase) facet).gDurationValue();
            if (gDurationSpecification.compareToGDuration(gDurationGDurationValue) <= 0) {
                validationContext.invalid(XmlErrorCodes.DATATYPE_MIN_EXCLUSIVE_VALID, new Object[]{XmlErrorCodes.DURATION, gDurationSpecification, gDurationGDurationValue, QNameHelper.readable(schemaType)});
            }
        }
        XmlTokenSource facet2 = schemaType.getFacet(4);
        if (facet2 != null) {
            GDuration gDurationGDurationValue2 = ((XmlObjectBase) facet2).gDurationValue();
            if (gDurationSpecification.compareToGDuration(gDurationGDurationValue2) < 0) {
                validationContext.invalid(XmlErrorCodes.DATATYPE_MIN_INCLUSIVE_VALID, new Object[]{XmlErrorCodes.DURATION, gDurationSpecification, gDurationGDurationValue2, QNameHelper.readable(schemaType)});
            }
        }
        XmlTokenSource facet3 = schemaType.getFacet(6);
        if (facet3 != null) {
            GDuration gDurationGDurationValue3 = ((XmlObjectBase) facet3).gDurationValue();
            if (gDurationSpecification.compareToGDuration(gDurationGDurationValue3) >= 0) {
                validationContext.invalid(XmlErrorCodes.DATATYPE_MAX_EXCLUSIVE_VALID, new Object[]{XmlErrorCodes.DURATION, gDurationSpecification, gDurationGDurationValue3, QNameHelper.readable(schemaType)});
            }
        }
        XmlTokenSource facet4 = schemaType.getFacet(5);
        if (facet4 != null) {
            GDuration gDurationGDurationValue4 = ((XmlObjectBase) facet4).gDurationValue();
            if (gDurationSpecification.compareToGDuration(gDurationGDurationValue4) > 0) {
                validationContext.invalid(XmlErrorCodes.DATATYPE_MAX_INCLUSIVE_VALID, new Object[]{XmlErrorCodes.DURATION, gDurationSpecification, gDurationGDurationValue4, QNameHelper.readable(schemaType)});
            }
        }
        Object[] enumerationValues = schemaType.getEnumerationValues();
        if (enumerationValues != null) {
            for (Object obj : enumerationValues) {
                if (gDurationSpecification.compareToGDuration(((XmlObjectBase) obj).gDurationValue()) == 0) {
                    return;
                }
            }
            validationContext.invalid(XmlErrorCodes.DATATYPE_ENUM_VALID, new Object[]{XmlErrorCodes.DURATION, gDurationSpecification, QNameHelper.readable(schemaType)});
        }
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public int compare_to(XmlObject xmlObject) {
        return this._value.compareToGDuration(((XmlObjectBase) xmlObject).gDurationValue());
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public String compute_text(NamespaceManager namespaceManager) {
        GDuration gDuration = this._value;
        return gDuration == null ? "" : gDuration.toString();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public boolean equal_to(XmlObject xmlObject) {
        return this._value.equals(((XmlObjectBase) xmlObject).gDurationValue());
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public GDuration getGDurationValue() {
        check_dated();
        GDuration gDuration = this._value;
        if (gDuration == null) {
            return null;
        }
        return gDuration;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return this._schemaType;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_GDuration(GDurationSpecification gDurationSpecification) {
        if (_validateOnSet()) {
            validateValue(gDurationSpecification, this._schemaType, XmlObjectBase._voorVc);
        }
        if (gDurationSpecification.isImmutable() && (gDurationSpecification instanceof GDuration)) {
            this._value = (GDuration) gDurationSpecification;
        } else {
            this._value = new GDuration(gDurationSpecification);
        }
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_nil() {
        this._value = null;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_text(String str) {
        GDuration gDurationValidateLexical = _validateOnSet() ? validateLexical(str, this._schemaType, XmlObjectBase._voorVc) : lex(str, XmlObjectBase._voorVc);
        if (_validateOnSet() && gDurationValidateLexical != null) {
            validateValue(gDurationValidateLexical, this._schemaType, XmlObjectBase._voorVc);
        }
        this._value = gDurationValidateLexical;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void validate_simpleval(String str, ValidationContext validationContext) {
        validateLexical(str, schemaType(), validationContext);
        validateValue(gDurationValue(), schemaType(), validationContext);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public int value_hash_code() {
        return this._value.hashCode();
    }
}
