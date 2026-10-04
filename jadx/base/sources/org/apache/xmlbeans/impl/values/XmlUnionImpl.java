package org.apache.xmlbeans.impl.values;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import kotlin.collections.AbstractC12991c;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.GDate;
import org.apache.xmlbeans.GDateSpecification;
import org.apache.xmlbeans.GDuration;
import org.apache.xmlbeans.GDurationSpecification;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlTokenSource;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;
import org.apache.xmlbeans.impl.schema.SchemaTypeImpl;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class XmlUnionImpl extends XmlObjectBase implements XmlAnySimpleType {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final int JAVA_BYTEARRAY = 50;
    private static final int JAVA_CALENDAR = 49;
    private static final int JAVA_DATE = 48;
    private static final int JAVA_LIST = 51;
    private static final int JAVA_NUMBER = 47;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$values$XmlUnionImpl;
    private SchemaType _schemaType;
    private String _textvalue = "";
    private XmlAnySimpleType _value;

    static {
        if (class$org$apache$xmlbeans$impl$values$XmlUnionImpl == null) {
            class$org$apache$xmlbeans$impl$values$XmlUnionImpl = class$("org.apache.xmlbeans.impl.values.XmlUnionImpl");
        }
        $assertionsDisabled = true;
    }

    public XmlUnionImpl(SchemaType schemaType, boolean z) {
        this._schemaType = schemaType;
        initComplexType(z, false);
    }

    private static boolean check(XmlObject xmlObject, SchemaType schemaType) {
        XmlAnySimpleType[] enumerationValues = schemaType.getEnumerationValues();
        if (enumerationValues == null) {
            return true;
        }
        for (XmlAnySimpleType xmlAnySimpleType : enumerationValues) {
            if (xmlAnySimpleType.valueEquals(xmlObject)) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw AbstractC12991c.m13994o(e);
        }
    }

    public static boolean lexical_overlap(int i, int i2) {
        if (i != i2 && i != 2 && i2 != 2 && i != 12 && i2 != 12 && i != 6 && i2 != 6) {
            if (i != 3) {
                if (i == 4) {
                    if (i2 != 3 && i2 != 5 && i2 != 13 && i2 != 18) {
                        switch (i2) {
                            case 7:
                            case 8:
                            case 9:
                            case 10:
                            case 11:
                                break;
                            default:
                                return false;
                        }
                    }
                    return true;
                }
                if (i == 5) {
                    if (i2 != 3 && i2 != 4 && i2 != 18) {
                        switch (i2) {
                            case 7:
                            case 8:
                            case 9:
                            case 10:
                            case 11:
                                break;
                            default:
                                return false;
                        }
                    }
                    return true;
                }
                if (i == 13) {
                    return i2 == 4 || i2 == 7 || i2 == 8;
                }
                if (i != 18) {
                    switch (i) {
                        case 7:
                        case 8:
                            return i2 == 3 || i2 == 4 || i2 == 5 || i2 == 7 || i2 == 8 || i2 == 13;
                        case 9:
                        case 10:
                        case 11:
                            break;
                        default:
                            return false;
                    }
                }
                if (i2 != 4 && i2 != 5 && i2 != 18) {
                    switch (i2) {
                        case 9:
                        case 10:
                        case 11:
                            break;
                        default:
                            return false;
                    }
                }
                return true;
            }
            if (i2 != 7 && i2 != 8) {
                return false;
            }
        }
        return true;
    }

    private static boolean logical_overlap(SchemaType schemaType, int i) {
        boolean z = $assertionsDisabled;
        if (!z && schemaType.getSimpleVariety() == 2) {
            throw new AssertionError();
        }
        if (i <= 46) {
            return schemaType.getSimpleVariety() == 1 && schemaType.getPrimitiveType().getBuiltinTypeCode() == i;
        }
        switch (i) {
            case 47:
                if (schemaType.getSimpleVariety() != 1) {
                    return false;
                }
                int builtinTypeCode = schemaType.getPrimitiveType().getBuiltinTypeCode();
                if (builtinTypeCode != 18 && builtinTypeCode != 20 && builtinTypeCode != 21) {
                    switch (builtinTypeCode) {
                        case 9:
                        case 10:
                        case 11:
                            break;
                        default:
                            return false;
                    }
                }
                return true;
            case 48:
                if (schemaType.getSimpleVariety() != 1) {
                    return false;
                }
                int builtinTypeCode2 = schemaType.getPrimitiveType().getBuiltinTypeCode();
                return builtinTypeCode2 == 14 || builtinTypeCode2 == 16;
            case 49:
                if (schemaType.getSimpleVariety() != 1) {
                    return false;
                }
                switch (schemaType.getPrimitiveType().getBuiltinTypeCode()) {
                    case 14:
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                        return true;
                    default:
                        return false;
                }
            case 50:
                if (schemaType.getSimpleVariety() != 1) {
                    return false;
                }
                int builtinTypeCode3 = schemaType.getPrimitiveType().getBuiltinTypeCode();
                return builtinTypeCode3 == 4 || builtinTypeCode3 == 5;
            case 51:
                return schemaType.getSimpleVariety() == 3;
            default:
                if (z) {
                    return false;
                }
                throw new AssertionError("missing case");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0079, code lost:
    
        if (r1 == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x007b, code lost:
    
        org.apache.xmlbeans.impl.values.NamespaceContext.pop();
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0093, code lost:
    
        throw new org.apache.xmlbeans.impl.values.XmlValueOutOfRangeException(org.apache.xmlbeans.XmlErrorCodes.DATATYPE_VALID$UNION, new java.lang.Object[]{r9.toString(), org.apache.xmlbeans.impl.common.QNameHelper.readable(r7._schemaType)});
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0039 A[Catch: all -> 0x0033, TRY_LEAVE, TryCatch #0 {all -> 0x0033, blocks: (B:13:0x002c, B:19:0x0036, B:21:0x0039, B:23:0x0041, B:24:0x0049, B:29:0x0058, B:32:0x005d, B:33:0x0073), top: B:45:0x002c, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0094 A[LOOP:0: B:12:0x002a->B:40:0x0094, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0079 A[EDGE_INSN: B:48:0x0079->B:36:0x0079 BREAK  A[LOOP:0: B:12:0x002a->B:40:0x0094], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void set_primitive(int i, Object obj) {
        boolean z;
        int i2;
        SchemaType[] unionConstituentTypes = this._schemaType.getUnionConstituentTypes();
        if (!$assertionsDisabled && unionConstituentTypes == null) {
            throw new AssertionError();
        }
        boolean z2 = true;
        if (has_store()) {
            NamespaceContext.push(new NamespaceContext(get_store()));
            z = true;
        } else {
            z = false;
        }
        while (true) {
            if (z2) {
                while (i2 < unionConstituentTypes.length) {
                }
                if (z2) {
                }
            } else {
                try {
                    if (_validateOnSet()) {
                        break;
                    }
                    for (i2 = 0; i2 < unionConstituentTypes.length; i2++) {
                        if (logical_overlap(unionConstituentTypes[i2], i)) {
                            try {
                                XmlAnySimpleType xmlAnySimpleTypeNewValue = ((SchemaTypeImpl) unionConstituentTypes[i2]).newValue(obj, z2);
                                this._value = xmlAnySimpleTypeNewValue;
                                this._textvalue = xmlAnySimpleTypeNewValue.stringValue();
                                if (z) {
                                    NamespaceContext.pop();
                                    return;
                                }
                                return;
                            } catch (XmlValueOutOfRangeException unused) {
                                continue;
                            } catch (Exception e) {
                                if (!$assertionsDisabled) {
                                    StringBuffer stringBuffer = new StringBuffer();
                                    stringBuffer.append("Unexpected ");
                                    stringBuffer.append(e);
                                    throw new AssertionError(stringBuffer.toString());
                                }
                            }
                        }
                    }
                    if (z2) {
                        break;
                    } else {
                        z2 = false;
                    }
                } catch (Throwable th) {
                    if (z) {
                        NamespaceContext.pop();
                    }
                    throw th;
                }
            }
        }
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public String compute_text(NamespaceManager namespaceManager) {
        return this._textvalue;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public boolean equal_to(XmlObject xmlObject) {
        return this._value.valueEquals(xmlObject);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public BigDecimal getBigDecimalValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return null;
        }
        return ((SimpleValue) xmlAnySimpleType).getBigDecimalValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public BigInteger getBigIntegerValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return null;
        }
        return ((SimpleValue) xmlAnySimpleType).getBigIntegerValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public boolean getBooleanValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return false;
        }
        return ((SimpleValue) xmlAnySimpleType).getBooleanValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public byte[] getByteArrayValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return null;
        }
        return ((SimpleValue) xmlAnySimpleType).getByteArrayValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public byte getByteValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return (byte) 0;
        }
        return ((SimpleValue) xmlAnySimpleType).getByteValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public Calendar getCalendarValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return null;
        }
        return ((SimpleValue) xmlAnySimpleType).getCalendarValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public Date getDateValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return null;
        }
        return ((SimpleValue) xmlAnySimpleType).getDateValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public double getDoubleValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return 0.0d;
        }
        return ((SimpleValue) xmlAnySimpleType).getDoubleValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public StringEnumAbstractBase getEnumValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return null;
        }
        return ((SimpleValue) xmlAnySimpleType).getEnumValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public float getFloatValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return 0.0f;
        }
        return ((SimpleValue) xmlAnySimpleType).getFloatValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public GDate getGDateValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return null;
        }
        return ((SimpleValue) xmlAnySimpleType).getGDateValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public GDuration getGDurationValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return null;
        }
        return ((SimpleValue) xmlAnySimpleType).getGDurationValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public int getIntValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return 0;
        }
        return ((SimpleValue) xmlAnySimpleType).getIntValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public List getListValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return null;
        }
        return ((SimpleValue) xmlAnySimpleType).getListValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public long getLongValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return 0L;
        }
        return ((SimpleValue) xmlAnySimpleType).getLongValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public QName getQNameValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return null;
        }
        return ((SimpleValue) xmlAnySimpleType).getQNameValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public short getShortValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return (short) 0;
        }
        return ((SimpleValue) xmlAnySimpleType).getShortValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public String getStringValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return null;
        }
        return xmlAnySimpleType.getStringValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public int get_wscanon_rule() {
        return 1;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public SchemaType instanceType() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return null;
        }
        return ((SimpleValue) xmlAnySimpleType).instanceType();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public boolean is_defaultable_ws(String str) {
        try {
            XmlAnySimpleType xmlAnySimpleType = this._value;
            set_text(str);
            this._value = xmlAnySimpleType;
            return false;
        } catch (XmlValueOutOfRangeException unused) {
            return true;
        }
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return this._schemaType;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_BigDecimal(BigDecimal bigDecimal) {
        set_primitive(47, bigDecimal);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_BigInteger(BigInteger bigInteger) {
        set_primitive(47, bigInteger);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_ByteArray(byte[] bArr) {
        set_primitive(50, bArr);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_Calendar(Calendar calendar) {
        set_primitive(49, calendar);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_Date(Date date) {
        set_primitive(48, date);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_GDate(GDateSpecification gDateSpecification) {
        int builtinTypeCode = gDateSpecification.getBuiltinTypeCode();
        if (builtinTypeCode <= 0) {
            throw new XmlValueOutOfRangeException();
        }
        set_primitive(builtinTypeCode, gDateSpecification);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_GDuration(GDurationSpecification gDurationSpecification) {
        set_primitive(13, gDurationSpecification);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_QName(QName qName) {
        set_primitive(7, qName);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_b64(byte[] bArr) {
        set_primitive(50, bArr);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_boolean(boolean z) {
        set_primitive(3, new Boolean(z));
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_byte(byte b) {
        set_primitive(47, new Byte(b));
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_double(double d) {
        set_primitive(47, new Double(d));
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_enum(StringEnumAbstractBase stringEnumAbstractBase) {
        set_primitive(12, stringEnumAbstractBase);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_float(float f) {
        set_primitive(47, new Float(f));
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_hex(byte[] bArr) {
        set_primitive(50, bArr);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_int(int i) {
        set_primitive(47, new Integer(i));
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_list(List list) {
        set_primitive(51, list);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_long(long j) {
        set_primitive(47, new Long(j));
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_nil() {
        this._value = null;
        this._textvalue = null;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_short(short s) {
        set_primitive(47, new Short(s));
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0096, code lost:
    
        if (r2 == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0098, code lost:
    
        org.apache.xmlbeans.impl.values.NamespaceContext.pop();
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x009b, code lost:
    
        r8._textvalue = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00ae, code lost:
    
        throw new org.apache.xmlbeans.impl.values.XmlValueOutOfRangeException(org.apache.xmlbeans.XmlErrorCodes.DATATYPE_VALID$UNION, new java.lang.Object[]{r9, org.apache.xmlbeans.impl.common.QNameHelper.readable(r8._schemaType)});
     */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00af A[LOOP:0: B:19:0x0051->B:44:0x00af, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0060 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0096 A[EDGE_INSN: B:52:0x0096->B:40:0x0096 BREAK  A[LOOP:0: B:19:0x0051->B:44:0x00af], SYNTHETIC] */
    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void set_text(String str) {
        boolean z;
        if (!this._schemaType.matchPatternFacet(str) && _validateOnSet()) {
            throw new XmlValueOutOfRangeException(XmlErrorCodes.DATATYPE_VALID$PATTERN_VALID, new Object[]{"string", str, QNameHelper.readable(this._schemaType)});
        }
        String str2 = this._textvalue;
        this._textvalue = str;
        SchemaType[] unionConstituentTypes = this._schemaType.getUnionConstituentTypes();
        if (!$assertionsDisabled && unionConstituentTypes == null) {
            throw new AssertionError();
        }
        boolean z2 = true;
        if (has_store()) {
            NamespaceContext.push(new NamespaceContext(get_store()));
            z = true;
        } else {
            z = false;
        }
        while (true) {
            if (z2) {
                while (i < unionConstituentTypes.length) {
                }
                if (z2) {
                }
            } else {
                try {
                    if (_validateOnSet()) {
                        break;
                    }
                    for (SchemaType schemaType : unionConstituentTypes) {
                        try {
                            XmlAnySimpleType xmlAnySimpleTypeNewValue = ((SchemaTypeImpl) schemaType).newValue(str, z2);
                            if (check(xmlAnySimpleTypeNewValue, this._schemaType)) {
                                this._value = xmlAnySimpleTypeNewValue;
                                if (z) {
                                    NamespaceContext.pop();
                                    return;
                                }
                                return;
                            }
                        } catch (XmlValueOutOfRangeException unused) {
                        } catch (Exception e) {
                            StringBuffer stringBuffer = new StringBuffer();
                            stringBuffer.append("Troublesome union exception caused by unexpected ");
                            stringBuffer.append(e);
                            throw new RuntimeException(stringBuffer.toString(), e);
                        }
                    }
                    if (z2) {
                        break;
                    } else {
                        z2 = false;
                    }
                } catch (Throwable th) {
                    if (z) {
                        NamespaceContext.pop();
                    }
                    throw th;
                }
            }
        }
    }

    public void set_xmldate(XmlObject xmlObject) {
        set_primitive(16, xmlObject);
    }

    public void set_xmldatetime(XmlObject xmlObject) {
        set_primitive(14, xmlObject);
    }

    public void set_xmldecimal(XmlObject xmlObject) {
        set_primitive(11, xmlObject);
    }

    public void set_xmldouble(XmlObject xmlObject) {
        set_primitive(10, xmlObject);
    }

    public void set_xmlduration(XmlObject xmlObject) {
        set_primitive(13, xmlObject);
    }

    public void set_xmlfloat(XmlObject xmlObject) {
        set_primitive(9, xmlObject);
    }

    public void set_xmlgday(XmlObject xmlObject) {
        set_primitive(20, xmlObject);
    }

    public void set_xmlgmonth(XmlObject xmlObject) {
        set_primitive(21, xmlObject);
    }

    public void set_xmlgmonthday(XmlObject xmlObject) {
        set_primitive(19, xmlObject);
    }

    public void set_xmlgyear(XmlObject xmlObject) {
        set_primitive(18, xmlObject);
    }

    public void set_xmlgyearmonth(XmlObject xmlObject) {
        set_primitive(17, xmlObject);
    }

    public void set_xmltime(XmlObject xmlObject) {
        set_primitive(15, xmlObject);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void validate_simpleval(String str, ValidationContext validationContext) {
        try {
            check_dated();
            XmlTokenSource xmlTokenSource = this._value;
            if (xmlTokenSource != null) {
                ((XmlObjectBase) xmlTokenSource).validate_simpleval(str, validationContext);
                return;
            }
            StringBuffer stringBuffer = new StringBuffer("'");
            stringBuffer.append(str);
            stringBuffer.append("' does not match any of the member types for ");
            stringBuffer.append(QNameHelper.readable(schemaType()));
            validationContext.invalid(XmlErrorCodes.UNION, new Object[]{stringBuffer.toString()});
        } catch (Exception unused) {
            StringBuffer stringBuffer2 = new StringBuffer("'");
            stringBuffer2.append(str);
            stringBuffer2.append("' does not match any of the member types for ");
            stringBuffer2.append(QNameHelper.readable(schemaType()));
            validationContext.invalid(XmlErrorCodes.UNION, new Object[]{stringBuffer2.toString()});
        }
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public int value_hash_code() {
        return this._value.hashCode();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public List xgetListValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return null;
        }
        return ((SimpleValue) xmlAnySimpleType).xgetListValue();
    }
}
