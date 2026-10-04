package org.apache.xmlbeans.impl.values;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlTokenSource;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class JavaHexBinaryHolderEx extends JavaHexBinaryHolder {
    private SchemaType _schemaType;

    public JavaHexBinaryHolderEx(SchemaType schemaType, boolean z) {
        this._schemaType = schemaType;
        initComplexType(z, false);
    }

    public static void validateValue(byte[] bArr, SchemaType schemaType, ValidationContext validationContext) {
        int iIntValue;
        int iIntValue2;
        int iIntValue3;
        XmlTokenSource facet = schemaType.getFacet(0);
        if (facet != null && (iIntValue3 = ((XmlObjectBase) facet).bigIntegerValue().intValue()) != bArr.length) {
            validationContext.invalid(XmlErrorCodes.DATATYPE_LENGTH_VALID$BINARY, new Object[]{XmlErrorCodes.HEXBINARY, new Integer(bArr.length), new Integer(iIntValue3), QNameHelper.readable(schemaType)});
        }
        XmlTokenSource facet2 = schemaType.getFacet(1);
        if (facet2 != null && (iIntValue2 = ((XmlObjectBase) facet2).bigIntegerValue().intValue()) > bArr.length) {
            validationContext.invalid(XmlErrorCodes.DATATYPE_MIN_LENGTH_VALID$BINARY, new Object[]{XmlErrorCodes.HEXBINARY, new Integer(bArr.length), new Integer(iIntValue2), QNameHelper.readable(schemaType)});
        }
        XmlTokenSource facet3 = schemaType.getFacet(2);
        if (facet3 != null && (iIntValue = ((XmlObjectBase) facet3).bigIntegerValue().intValue()) < bArr.length) {
            validationContext.invalid(XmlErrorCodes.DATATYPE_MAX_LENGTH_VALID$BINARY, new Object[]{XmlErrorCodes.HEXBINARY, new Integer(bArr.length), new Integer(iIntValue), QNameHelper.readable(schemaType)});
        }
        Object[] enumerationValues = schemaType.getEnumerationValues();
        if (enumerationValues != null) {
            int i = 0;
            loop0: while (i < enumerationValues.length) {
                byte[] bArrByteArrayValue = ((XmlObjectBase) enumerationValues[i]).byteArrayValue();
                if (bArrByteArrayValue.length == bArr.length) {
                    for (int i2 = 0; i2 < bArrByteArrayValue.length; i2++) {
                        if (bArrByteArrayValue[i2] != bArr[i2]) {
                            break;
                        }
                    }
                    break loop0;
                }
                i++;
            }
            if (i >= enumerationValues.length) {
                validationContext.invalid(XmlErrorCodes.DATATYPE_ENUM_VALID$NO_VALUE, new Object[]{XmlErrorCodes.HEXBINARY, QNameHelper.readable(schemaType)});
            }
        }
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public int get_wscanon_rule() {
        return schemaType().getWhiteSpaceRule();
    }

    @Override // org.apache.xmlbeans.impl.values.JavaHexBinaryHolder, org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return this._schemaType;
    }

    @Override // org.apache.xmlbeans.impl.values.JavaHexBinaryHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_ByteArray(byte[] bArr) {
        if (_validateOnSet()) {
            validateValue(bArr, schemaType(), XmlObjectBase._voorVc);
        }
        super.set_ByteArray(bArr);
    }

    @Override // org.apache.xmlbeans.impl.values.JavaHexBinaryHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_text(String str) {
        byte[] bArrValidateLexical = _validateOnSet() ? JavaHexBinaryHolder.validateLexical(str, schemaType(), XmlObjectBase._voorVc) : JavaHexBinaryHolder.lex(str, XmlObjectBase._voorVc);
        if (_validateOnSet() && bArrValidateLexical != null) {
            validateValue(bArrValidateLexical, schemaType(), XmlObjectBase._voorVc);
        }
        super.set_ByteArray(bArrValidateLexical);
        this._value = bArrValidateLexical;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void validate_simpleval(String str, ValidationContext validationContext) {
        JavaHexBinaryHolder.validateLexical(str, schemaType(), validationContext);
        validateValue(byteArrayValue(), schemaType(), validationContext);
    }
}
