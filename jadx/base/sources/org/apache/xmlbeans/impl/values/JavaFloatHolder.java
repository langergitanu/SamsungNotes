package org.apache.xmlbeans.impl.values;

import java.math.BigDecimal;
import java.math.BigInteger;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.common.ValidationContext;
import org.apache.xmlbeans.impl.schema.BuiltinSchemaTypeSystem;
import org.apache.xmlbeans.impl.util.XsTypeConverter;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class JavaFloatHolder extends XmlObjectBase {
    private float _value;

    public static int compare(float f, float f4) {
        if (f < f4) {
            return -1;
        }
        if (f > f4) {
            return 1;
        }
        int iFloatToIntBits = Float.floatToIntBits(f);
        int iFloatToIntBits2 = Float.floatToIntBits(f4);
        if (iFloatToIntBits == iFloatToIntBits2) {
            return 0;
        }
        return iFloatToIntBits < iFloatToIntBits2 ? -1 : 1;
    }

    public static String serialize(float f) {
        return f == Float.POSITIVE_INFINITY ? "INF" : f == Float.NEGATIVE_INFINITY ? "-INF" : f == Float.NaN ? "NaN" : Float.toString(f);
    }

    public static float validateLexical(String str, ValidationContext validationContext) {
        try {
            return XsTypeConverter.lexFloat(str);
        } catch (NumberFormatException unused) {
            validationContext.invalid("float", new Object[]{str});
            return Float.NaN;
        }
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public int compare_to(XmlObject xmlObject) {
        return compare(this._value, ((XmlObjectBase) xmlObject).floatValue());
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public String compute_text(NamespaceManager namespaceManager) {
        return serialize(this._value);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public boolean equal_to(XmlObject xmlObject) {
        return compare(this._value, ((XmlObjectBase) xmlObject).floatValue()) == 0;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public BigDecimal getBigDecimalValue() {
        check_dated();
        return new BigDecimal(this._value);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public double getDoubleValue() {
        check_dated();
        return this._value;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public float getFloatValue() {
        check_dated();
        return this._value;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return BuiltinSchemaTypeSystem.ST_FLOAT;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_BigDecimal(BigDecimal bigDecimal) {
        set_float(bigDecimal.floatValue());
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_BigInteger(BigInteger bigInteger) {
        set_float(bigInteger.floatValue());
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_double(double d) {
        set_float((float) d);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_float(float f) {
        this._value = f;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_long(long j) {
        set_float(j);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_nil() {
        this._value = 0.0f;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_text(String str) {
        set_float(validateLexical(str, XmlObjectBase._voorVc));
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public int value_hash_code() {
        return Float.floatToIntBits(this._value);
    }
}
