package org.apache.xmlbeans.impl.values;

import java.util.Calendar;
import java.util.Date;
import kotlin.collections.AbstractC12991c;
import org.apache.xmlbeans.GDate;
import org.apache.xmlbeans.GDateBuilder;
import org.apache.xmlbeans.GDateSpecification;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlTokenSource;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;
import p258y.AbstractC14516b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class JavaGDateHolderEx extends XmlObjectBase {
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$values$JavaGDateHolderEx;
    private SchemaType _schemaType;
    private GDate _value;

    static {
        if (class$org$apache$xmlbeans$impl$values$JavaGDateHolderEx == null) {
            class$org$apache$xmlbeans$impl$values$JavaGDateHolderEx = class$("org.apache.xmlbeans.impl.values.JavaGDateHolderEx");
        }
        $assertionsDisabled = true;
    }

    public JavaGDateHolderEx(SchemaType schemaType, boolean z) {
        this._schemaType = schemaType;
        initComplexType(z, false);
    }

    public static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw AbstractC12991c.m13994o(e);
        }
    }

    public static GDate lex(String str, SchemaType schemaType, ValidationContext validationContext) {
        GDate gDate;
        try {
            gDate = new GDate(str);
        } catch (Exception unused) {
            validationContext.invalid("date", new Object[]{str});
            gDate = null;
        }
        if (gDate != null) {
            if (gDate.getBuiltinTypeCode() != schemaType.getPrimitiveType().getBuiltinTypeCode()) {
                validationContext.invalid("date", new Object[]{AbstractC14516b.m15113a("wrong type: ", str)});
                return null;
            }
            if (!gDate.isValid()) {
                validationContext.invalid("date", new Object[]{str});
                return null;
            }
        }
        return gDate;
    }

    public static GDate validateLexical(String str, SchemaType schemaType, ValidationContext validationContext) {
        GDate gDateLex = lex(str, schemaType, validationContext);
        if (gDateLex != null && schemaType.hasPatternFacet() && !schemaType.matchPatternFacet(str)) {
            validationContext.invalid(XmlErrorCodes.DATATYPE_VALID$PATTERN_VALID, new Object[]{"date", str, QNameHelper.readable(schemaType)});
        }
        return gDateLex;
    }

    public static void validateValue(GDateSpecification gDateSpecification, SchemaType schemaType, ValidationContext validationContext) {
        if (gDateSpecification.getBuiltinTypeCode() != schemaType.getPrimitiveType().getBuiltinTypeCode()) {
            StringBuffer stringBuffer = new StringBuffer("Date (");
            stringBuffer.append(gDateSpecification);
            stringBuffer.append(") does not have the set of fields required for ");
            stringBuffer.append(QNameHelper.readable(schemaType));
            validationContext.invalid("date", new Object[]{stringBuffer.toString()});
        }
        XmlTokenSource facet = schemaType.getFacet(3);
        if (facet != null) {
            GDate gDateGDateValue = ((XmlObjectBase) facet).gDateValue();
            if (gDateSpecification.compareToGDate(gDateGDateValue) <= 0) {
                validationContext.invalid(XmlErrorCodes.DATATYPE_MIN_EXCLUSIVE_VALID, new Object[]{"date", gDateSpecification, gDateGDateValue, QNameHelper.readable(schemaType)});
            }
        }
        XmlTokenSource facet2 = schemaType.getFacet(4);
        if (facet2 != null) {
            GDate gDateGDateValue2 = ((XmlObjectBase) facet2).gDateValue();
            if (gDateSpecification.compareToGDate(gDateGDateValue2) < 0) {
                validationContext.invalid(XmlErrorCodes.DATATYPE_MIN_INCLUSIVE_VALID, new Object[]{"date", gDateSpecification, gDateGDateValue2, QNameHelper.readable(schemaType)});
            }
        }
        XmlTokenSource facet3 = schemaType.getFacet(6);
        if (facet3 != null) {
            GDate gDateGDateValue3 = ((XmlObjectBase) facet3).gDateValue();
            if (gDateSpecification.compareToGDate(gDateGDateValue3) >= 0) {
                validationContext.invalid(XmlErrorCodes.DATATYPE_MAX_EXCLUSIVE_VALID, new Object[]{"date", gDateSpecification, gDateGDateValue3, QNameHelper.readable(schemaType)});
            }
        }
        XmlTokenSource facet4 = schemaType.getFacet(5);
        if (facet4 != null) {
            GDate gDateGDateValue4 = ((XmlObjectBase) facet4).gDateValue();
            if (gDateSpecification.compareToGDate(gDateGDateValue4) > 0) {
                validationContext.invalid(XmlErrorCodes.DATATYPE_MAX_INCLUSIVE_VALID, new Object[]{"date", gDateSpecification, gDateGDateValue4, QNameHelper.readable(schemaType)});
            }
        }
        Object[] enumerationValues = schemaType.getEnumerationValues();
        if (enumerationValues != null) {
            for (Object obj : enumerationValues) {
                if (gDateSpecification.compareToGDate(((XmlObjectBase) obj).gDateValue()) == 0) {
                    return;
                }
            }
            validationContext.invalid(XmlErrorCodes.DATATYPE_ENUM_VALID, new Object[]{"date", gDateSpecification, QNameHelper.readable(schemaType)});
        }
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public int compare_to(XmlObject xmlObject) {
        return this._value.compareToGDate(((XmlObjectBase) xmlObject).gDateValue());
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public String compute_text(NamespaceManager namespaceManager) {
        GDate gDate = this._value;
        return gDate == null ? "" : gDate.toString();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public boolean equal_to(XmlObject xmlObject) {
        return this._value.equals(((XmlObjectBase) xmlObject).gDateValue());
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public Calendar getCalendarValue() {
        check_dated();
        GDate gDate = this._value;
        if (gDate == null) {
            return null;
        }
        return gDate.getCalendar();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public Date getDateValue() {
        check_dated();
        GDate gDate = this._value;
        if (gDate == null) {
            return null;
        }
        return gDate.getDate();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public GDate getGDateValue() {
        check_dated();
        GDate gDate = this._value;
        if (gDate == null) {
            return null;
        }
        return gDate;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public int getIntValue() {
        int builtinTypeCode = schemaType().getPrimitiveType().getBuiltinTypeCode();
        if (builtinTypeCode != 20 && builtinTypeCode != 21 && builtinTypeCode != 18) {
            throw new XmlValueOutOfRangeException();
        }
        check_dated();
        GDate gDate = this._value;
        if (gDate == null) {
            return 0;
        }
        if (builtinTypeCode == 18) {
            return gDate.getYear();
        }
        if (builtinTypeCode == 20) {
            return gDate.getDay();
        }
        if (builtinTypeCode == 21) {
            return gDate.getMonth();
        }
        if ($assertionsDisabled) {
            throw new IllegalStateException();
        }
        throw new AssertionError();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return this._schemaType;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_Calendar(Calendar calendar) {
        int builtinTypeCode = schemaType().getPrimitiveType().getBuiltinTypeCode();
        GDateBuilder gDateBuilder = new GDateBuilder(calendar);
        gDateBuilder.setBuiltinTypeCode(builtinTypeCode);
        GDate gDate = gDateBuilder.toGDate();
        if (_validateOnSet()) {
            validateValue(gDate, this._schemaType, XmlObjectBase._voorVc);
        }
        this._value = gDate;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_Date(Date date) {
        int builtinTypeCode = schemaType().getPrimitiveType().getBuiltinTypeCode();
        if ((builtinTypeCode != 16 && builtinTypeCode != 14) || date == null) {
            throw new XmlValueOutOfRangeException();
        }
        GDateBuilder gDateBuilder = new GDateBuilder(date);
        gDateBuilder.setBuiltinTypeCode(builtinTypeCode);
        GDate gDate = gDateBuilder.toGDate();
        if (_validateOnSet()) {
            validateValue(gDate, this._schemaType, XmlObjectBase._voorVc);
        }
        this._value = gDate;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_GDate(GDateSpecification gDateSpecification) {
        GDate gDate;
        int builtinTypeCode = schemaType().getPrimitiveType().getBuiltinTypeCode();
        if (gDateSpecification.isImmutable() && (gDateSpecification instanceof GDate) && gDateSpecification.getBuiltinTypeCode() == builtinTypeCode) {
            gDate = (GDate) gDateSpecification;
        } else {
            if (gDateSpecification.getBuiltinTypeCode() != builtinTypeCode) {
                GDateSpecification gDateBuilder = new GDateBuilder(gDateSpecification);
                gDateBuilder.setBuiltinTypeCode(builtinTypeCode);
                gDateSpecification = gDateBuilder;
            }
            gDate = new GDate(gDateSpecification);
        }
        if (_validateOnSet()) {
            validateValue(gDate, this._schemaType, XmlObjectBase._voorVc);
        }
        this._value = gDate;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_int(int i) {
        int builtinTypeCode = schemaType().getPrimitiveType().getBuiltinTypeCode();
        if (builtinTypeCode != 20 && builtinTypeCode != 21 && builtinTypeCode != 18) {
            throw new XmlValueOutOfRangeException();
        }
        GDateBuilder gDateBuilder = new GDateBuilder();
        if (builtinTypeCode == 18) {
            gDateBuilder.setYear(i);
        } else if (builtinTypeCode == 20) {
            gDateBuilder.setDay(i);
        } else if (builtinTypeCode == 21) {
            gDateBuilder.setMonth(i);
        }
        if (_validateOnSet()) {
            validateValue(gDateBuilder, this._schemaType, XmlObjectBase._voorVc);
        }
        this._value = gDateBuilder.toGDate();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_nil() {
        this._value = null;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_text(String str) {
        GDate gDateValidateLexical = _validateOnSet() ? validateLexical(str, this._schemaType, XmlObjectBase._voorVc) : lex(str, this._schemaType, XmlObjectBase._voorVc);
        if (_validateOnSet() && gDateValidateLexical != null) {
            validateValue(gDateValidateLexical, this._schemaType, XmlObjectBase._voorVc);
        }
        this._value = gDateValidateLexical;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void validate_simpleval(String str, ValidationContext validationContext) {
        validateLexical(str, schemaType(), validationContext);
        validateValue(gDateValue(), schemaType(), validationContext);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public int value_hash_code() {
        return this._value.hashCode();
    }
}
