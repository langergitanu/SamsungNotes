package org.apache.xmlbeans.impl.values;

import java.math.BigDecimal;
import java.math.BigInteger;
import kotlin.collections.AbstractC12991c;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.common.ValidationContext;
import org.apache.xmlbeans.impl.schema.BuiltinSchemaTypeSystem;
import org.apache.xmlbeans.impl.util.XsTypeConverter;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class JavaDecimalHolder extends XmlObjectBase {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static BigInteger _maxlong;
    private static BigInteger _minlong;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$values$JavaDecimalHolder;
    private BigDecimal _value;

    static {
        if (class$org$apache$xmlbeans$impl$values$JavaDecimalHolder == null) {
            class$org$apache$xmlbeans$impl$values$JavaDecimalHolder = class$("org.apache.xmlbeans.impl.values.JavaDecimalHolder");
        }
        $assertionsDisabled = true;
        _maxlong = BigInteger.valueOf(Long.MAX_VALUE);
        _minlong = BigInteger.valueOf(Long.MIN_VALUE);
    }

    public static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw AbstractC12991c.m13994o(e);
        }
    }

    public static void validateLexical(String str, ValidationContext validationContext) {
        char cCharAt;
        int length = str.length();
        boolean z = false;
        boolean z2 = false;
        for (int i = (length <= 0 || !((cCharAt = str.charAt(0)) == '+' || cCharAt == '-')) ? 0 : 1; i < length; i++) {
            char cCharAt2 = str.charAt(i);
            if (cCharAt2 == '.') {
                if (z2) {
                    validationContext.invalid(XmlErrorCodes.DECIMAL, new Object[]{"saw '.' more than once: ".concat(str)});
                    return;
                }
                z2 = true;
            } else {
                if (cCharAt2 < '0' || cCharAt2 > '9') {
                    StringBuffer stringBuffer = new StringBuffer("unexpected char '");
                    stringBuffer.append((int) cCharAt2);
                    stringBuffer.append("'");
                    validationContext.invalid(XmlErrorCodes.DECIMAL, new Object[]{stringBuffer.toString()});
                    return;
                }
                z = true;
            }
        }
        if (z) {
            return;
        }
        validationContext.invalid(XmlErrorCodes.DECIMAL, new Object[]{"expected at least one digit"});
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public int compare_to(XmlObject xmlObject) {
        return this._value.compareTo(((XmlObjectBase) xmlObject).bigDecimalValue());
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public String compute_text(NamespaceManager namespaceManager) {
        return XsTypeConverter.printDecimal(this._value);
    }

    public int decimalHashCode() {
        if (!$assertionsDisabled && this._value.scale() <= 0) {
            throw new AssertionError();
        }
        String string = this._value.toString();
        int length = string.length() - 1;
        while (length >= 0 && string.charAt(length) == '0') {
            length--;
        }
        if ($assertionsDisabled || string.indexOf(46) < length) {
            return string.substring(0, length + 1).hashCode();
        }
        throw new AssertionError();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public boolean equal_to(XmlObject xmlObject) {
        return this._value.compareTo(((XmlObjectBase) xmlObject).bigDecimalValue()) == 0;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public BigDecimal getBigDecimalValue() {
        check_dated();
        return this._value;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return BuiltinSchemaTypeSystem.ST_DECIMAL;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_BigDecimal(BigDecimal bigDecimal) {
        this._value = bigDecimal;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_nil() {
        this._value = null;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_text(String str) {
        if (_validateOnSet()) {
            validateLexical(str, XmlObjectBase._voorVc);
        }
        try {
            set_BigDecimal(new BigDecimal(str));
        } catch (NumberFormatException unused) {
            XmlObjectBase._voorVc.invalid(XmlErrorCodes.DECIMAL, new Object[]{str});
        }
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public int value_hash_code() {
        if (this._value.scale() > 0 && this._value.setScale(0, 1).compareTo(this._value) != 0) {
            return decimalHashCode();
        }
        BigInteger bigInteger = this._value.toBigInteger();
        if (bigInteger.compareTo(_maxlong) > 0 || bigInteger.compareTo(_minlong) < 0) {
            return bigInteger.hashCode();
        }
        long jLongValue = bigInteger.longValue();
        return (int) (((jLongValue >> 32) * 19) + jLongValue);
    }
}
