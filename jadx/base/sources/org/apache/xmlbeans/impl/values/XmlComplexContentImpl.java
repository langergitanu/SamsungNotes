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
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.SchemaProperty;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.SchemaTypeImpl;
import org.apache.xmlbeans.impl.schema.SchemaTypeVisitorImpl;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class XmlComplexContentImpl extends XmlObjectBase {
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$values$XmlComplexContentImpl;
    private SchemaTypeImpl _schemaType;

    static {
        if (class$org$apache$xmlbeans$impl$values$XmlComplexContentImpl == null) {
            class$org$apache$xmlbeans$impl$values$XmlComplexContentImpl = class$("org.apache.xmlbeans.impl.values.XmlComplexContentImpl");
        }
        $assertionsDisabled = true;
    }

    public XmlComplexContentImpl(SchemaType schemaType) {
        this._schemaType = (SchemaTypeImpl) schemaType;
        initComplexType(true, true);
    }

    public static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw AbstractC12991c.m13994o(e);
        }
    }

    public SimpleValue[] arraySetterHelper(int i, QName qName) {
        SimpleValue[] simpleValueArr = new SimpleValue[i];
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qName);
        while (iCount_elements > i) {
            iCount_elements = AbstractC12991c.m13980a(iCount_elements, 1, typeStore, qName, iCount_elements, -1);
        }
        int i2 = 0;
        while (i2 < i) {
            simpleValueArr[i2] = (SimpleValue) (i2 >= iCount_elements ? typeStore.add_element_user(qName) : typeStore.find_element_user(qName, i2));
            i2++;
        }
        return simpleValueArr;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public String compute_text(NamespaceManager namespaceManager) {
        return null;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public boolean equal_to(XmlObject xmlObject) {
        return this._schemaType.equals(xmlObject.schemaType());
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.impl.values.TypeStoreUser
    public String get_default_attribute_text(QName qName) {
        return super.get_default_attribute_text(qName);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.impl.values.TypeStoreUser
    public String get_default_element_text(QName qName) {
        SchemaProperty elementProperty = schemaType().getElementProperty(qName);
        return elementProperty == null ? "" : elementProperty.getDefaultText();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.impl.values.TypeStoreUser
    public int get_elementflags(QName qName) {
        SchemaProperty elementProperty = schemaType().getElementProperty(qName);
        if (elementProperty == null) {
            return 0;
        }
        if (elementProperty.hasDefault() == 1 || elementProperty.hasFixed() == 1 || elementProperty.hasNillable() == 1) {
            return -1;
        }
        return (elementProperty.hasDefault() == 0 ? 0 : 2) | (elementProperty.hasFixed() == 0 ? 0 : 4) | (elementProperty.hasNillable() != 0 ? 1 : 0);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.impl.values.TypeStoreUser
    public boolean is_child_element_order_sensitive() {
        return schemaType().isOrderSensitive();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.impl.values.TypeStoreUser
    public TypeStoreVisitor new_visitor() {
        return new SchemaTypeVisitorImpl(this._schemaType.getContentModel());
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return this._schemaType;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public final void set_String(String str) {
        if (!$assertionsDisabled && this._schemaType.getContentType() == 2) {
            throw new AssertionError();
        }
        if (this._schemaType.getContentType() == 4 || this._schemaType.isNoType()) {
            super.set_String(str);
        } else {
            StringBuffer stringBuffer = new StringBuffer("Type does not allow for textual content: ");
            stringBuffer.append(this._schemaType);
            throw new IllegalArgumentException(stringBuffer.toString());
        }
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_text(String str) {
        if (!$assertionsDisabled && this._schemaType.getContentType() != 4 && !this._schemaType.isNoType()) {
            throw new AssertionError();
        }
    }

    public void unionArraySetterHelper(Object[] objArr, QName qName) {
        int i = 0;
        int length = objArr == null ? 0 : objArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qName);
        while (iCount_elements > length) {
            iCount_elements = AbstractC12991c.m13980a(iCount_elements, 1, typeStore, qName, iCount_elements, -1);
        }
        while (i < length) {
            ((XmlObjectBase) (i >= iCount_elements ? typeStore.add_element_user(qName) : typeStore.find_element_user(qName, i))).objectSet(objArr[i]);
            i++;
        }
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public int value_hash_code() {
        throw new IllegalStateException("Complex types cannot be used as hash keys");
    }

    public SimpleValue[] arraySetterHelper(int i, QName qName, QNameSet qNameSet) {
        TypeStoreUser typeStoreUserFind_element_user;
        SimpleValue[] simpleValueArr = new SimpleValue[i];
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qNameSet);
        while (iCount_elements > i) {
            iCount_elements = AbstractC12991c.m13981b(iCount_elements, 1, typeStore, qNameSet, iCount_elements, -1);
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qNameSet, i2);
            }
            simpleValueArr[i2] = (SimpleValue) typeStoreUserFind_element_user;
        }
        return simpleValueArr;
    }

    public void unionArraySetterHelper(Object[] objArr, QName qName, QNameSet qNameSet) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = objArr == null ? 0 : objArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qNameSet);
        while (iCount_elements > length) {
            iCount_elements = AbstractC12991c.m13981b(iCount_elements, 1, typeStore, qNameSet, iCount_elements, -1);
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qNameSet, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).objectSet(objArr[i]);
        }
    }

    public void arraySetterHelper(boolean[] zArr, QName qName) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = zArr == null ? 0 : zArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qName);
        while (iCount_elements > length) {
            iCount_elements = AbstractC12991c.m13980a(iCount_elements, 1, typeStore, qName, iCount_elements, -1);
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qName, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set(zArr[i]);
        }
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_nil() {
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void update_from_complex_content() {
    }

    public void arraySetterHelper(float[] fArr, QName qName) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = fArr == null ? 0 : fArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qName);
        while (iCount_elements > length) {
            iCount_elements = AbstractC12991c.m13980a(iCount_elements, 1, typeStore, qName, iCount_elements, -1);
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qName, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set(fArr[i]);
        }
    }

    public void arraySetterHelper(double[] dArr, QName qName) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = dArr == null ? 0 : dArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qName);
        while (iCount_elements > length) {
            iCount_elements = AbstractC12991c.m13980a(iCount_elements, 1, typeStore, qName, iCount_elements, -1);
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qName, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set(dArr[i]);
        }
    }

    public void arraySetterHelper(byte[] bArr, QName qName) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = bArr == null ? 0 : bArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qName);
        while (iCount_elements > length) {
            iCount_elements = AbstractC12991c.m13980a(iCount_elements, 1, typeStore, qName, iCount_elements, -1);
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qName, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set(bArr[i]);
        }
    }

    public void arraySetterHelper(short[] sArr, QName qName) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = sArr == null ? 0 : sArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qName);
        while (iCount_elements > length) {
            iCount_elements = AbstractC12991c.m13980a(iCount_elements, 1, typeStore, qName, iCount_elements, -1);
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qName, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set(sArr[i]);
        }
    }

    public void arraySetterHelper(int[] iArr, QName qName) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = iArr == null ? 0 : iArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qName);
        while (iCount_elements > length) {
            iCount_elements = AbstractC12991c.m13980a(iCount_elements, 1, typeStore, qName, iCount_elements, -1);
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qName, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set(iArr[i]);
        }
    }

    public void arraySetterHelper(long[] jArr, QName qName) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = jArr == null ? 0 : jArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qName);
        while (iCount_elements > length) {
            iCount_elements = AbstractC12991c.m13980a(iCount_elements, 1, typeStore, qName, iCount_elements, -1);
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qName, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set(jArr[i]);
        }
    }

    public void arraySetterHelper(BigDecimal[] bigDecimalArr, QName qName) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = bigDecimalArr == null ? 0 : bigDecimalArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qName);
        while (iCount_elements > length) {
            iCount_elements = AbstractC12991c.m13980a(iCount_elements, 1, typeStore, qName, iCount_elements, -1);
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qName, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set(bigDecimalArr[i]);
        }
    }

    public void arraySetterHelper(BigInteger[] bigIntegerArr, QName qName) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = bigIntegerArr == null ? 0 : bigIntegerArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qName);
        while (iCount_elements > length) {
            iCount_elements = AbstractC12991c.m13980a(iCount_elements, 1, typeStore, qName, iCount_elements, -1);
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qName, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set(bigIntegerArr[i]);
        }
    }

    public void arraySetterHelper(String[] strArr, QName qName) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = strArr == null ? 0 : strArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qName);
        while (iCount_elements > length) {
            iCount_elements = AbstractC12991c.m13980a(iCount_elements, 1, typeStore, qName, iCount_elements, -1);
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qName, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set(strArr[i]);
        }
    }

    public void arraySetterHelper(byte[][] bArr, QName qName) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = bArr == null ? 0 : bArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qName);
        while (iCount_elements > length) {
            iCount_elements = AbstractC12991c.m13980a(iCount_elements, 1, typeStore, qName, iCount_elements, -1);
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qName, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set(bArr[i]);
        }
    }

    public void arraySetterHelper(GDate[] gDateArr, QName qName) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = gDateArr == null ? 0 : gDateArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qName);
        while (iCount_elements > length) {
            iCount_elements = AbstractC12991c.m13980a(iCount_elements, 1, typeStore, qName, iCount_elements, -1);
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qName, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set((GDateSpecification) gDateArr[i]);
        }
    }

    public void arraySetterHelper(GDuration[] gDurationArr, QName qName) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = gDurationArr == null ? 0 : gDurationArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qName);
        while (iCount_elements > length) {
            iCount_elements = AbstractC12991c.m13980a(iCount_elements, 1, typeStore, qName, iCount_elements, -1);
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qName, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set((GDurationSpecification) gDurationArr[i]);
        }
    }

    public void arraySetterHelper(Calendar[] calendarArr, QName qName) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = calendarArr == null ? 0 : calendarArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qName);
        while (iCount_elements > length) {
            iCount_elements = AbstractC12991c.m13980a(iCount_elements, 1, typeStore, qName, iCount_elements, -1);
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qName, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set(calendarArr[i]);
        }
    }

    public void arraySetterHelper(Date[] dateArr, QName qName) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = dateArr == null ? 0 : dateArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qName);
        while (iCount_elements > length) {
            iCount_elements = AbstractC12991c.m13980a(iCount_elements, 1, typeStore, qName, iCount_elements, -1);
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qName, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set(dateArr[i]);
        }
    }

    public void arraySetterHelper(QName[] qNameArr, QName qName) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = qNameArr == null ? 0 : qNameArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qName);
        while (iCount_elements > length) {
            iCount_elements = AbstractC12991c.m13980a(iCount_elements, 1, typeStore, qName, iCount_elements, -1);
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qName, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set(qNameArr[i]);
        }
    }

    public void arraySetterHelper(StringEnumAbstractBase[] stringEnumAbstractBaseArr, QName qName) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = stringEnumAbstractBaseArr == null ? 0 : stringEnumAbstractBaseArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qName);
        while (iCount_elements > length) {
            iCount_elements = AbstractC12991c.m13980a(iCount_elements, 1, typeStore, qName, iCount_elements, -1);
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qName, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set(stringEnumAbstractBaseArr[i]);
        }
    }

    public void arraySetterHelper(List[] listArr, QName qName) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = listArr == null ? 0 : listArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qName);
        while (iCount_elements > length) {
            iCount_elements = AbstractC12991c.m13980a(iCount_elements, 1, typeStore, qName, iCount_elements, -1);
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qName, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set(listArr[i]);
        }
    }

    public void arraySetterHelper(boolean[] zArr, QName qName, QNameSet qNameSet) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = zArr == null ? 0 : zArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qNameSet);
        while (iCount_elements > length) {
            iCount_elements = AbstractC12991c.m13981b(iCount_elements, 1, typeStore, qNameSet, iCount_elements, -1);
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qNameSet, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set(zArr[i]);
        }
    }

    public void arraySetterHelper(float[] fArr, QName qName, QNameSet qNameSet) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = fArr == null ? 0 : fArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qNameSet);
        while (iCount_elements > length) {
            iCount_elements = AbstractC12991c.m13981b(iCount_elements, 1, typeStore, qNameSet, iCount_elements, -1);
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qNameSet, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set(fArr[i]);
        }
    }

    public void arraySetterHelper(double[] dArr, QName qName, QNameSet qNameSet) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = dArr == null ? 0 : dArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qNameSet);
        while (iCount_elements > length) {
            iCount_elements = AbstractC12991c.m13981b(iCount_elements, 1, typeStore, qNameSet, iCount_elements, -1);
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qNameSet, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set(dArr[i]);
        }
    }

    public void arraySetterHelper(byte[] bArr, QName qName, QNameSet qNameSet) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = bArr == null ? 0 : bArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qNameSet);
        while (iCount_elements > length) {
            iCount_elements = AbstractC12991c.m13981b(iCount_elements, 1, typeStore, qNameSet, iCount_elements, -1);
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qNameSet, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set(bArr[i]);
        }
    }

    public void arraySetterHelper(short[] sArr, QName qName, QNameSet qNameSet) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = sArr == null ? 0 : sArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qNameSet);
        while (iCount_elements > length) {
            iCount_elements = AbstractC12991c.m13981b(iCount_elements, 1, typeStore, qNameSet, iCount_elements, -1);
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qNameSet, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set(sArr[i]);
        }
    }

    public void arraySetterHelper(int[] iArr, QName qName, QNameSet qNameSet) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = iArr == null ? 0 : iArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qNameSet);
        while (iCount_elements > length) {
            iCount_elements = AbstractC12991c.m13981b(iCount_elements, 1, typeStore, qNameSet, iCount_elements, -1);
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qNameSet, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set(iArr[i]);
        }
    }

    public void arraySetterHelper(long[] jArr, QName qName, QNameSet qNameSet) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = jArr == null ? 0 : jArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qNameSet);
        while (iCount_elements > length) {
            iCount_elements = AbstractC12991c.m13981b(iCount_elements, 1, typeStore, qNameSet, iCount_elements, -1);
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qNameSet, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set(jArr[i]);
        }
    }

    public void arraySetterHelper(BigDecimal[] bigDecimalArr, QName qName, QNameSet qNameSet) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = bigDecimalArr == null ? 0 : bigDecimalArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qNameSet);
        while (iCount_elements > length) {
            iCount_elements = AbstractC12991c.m13981b(iCount_elements, 1, typeStore, qNameSet, iCount_elements, -1);
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qNameSet, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set(bigDecimalArr[i]);
        }
    }

    public void arraySetterHelper(BigInteger[] bigIntegerArr, QName qName, QNameSet qNameSet) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = bigIntegerArr == null ? 0 : bigIntegerArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qNameSet);
        while (iCount_elements > length) {
            iCount_elements = AbstractC12991c.m13981b(iCount_elements, 1, typeStore, qNameSet, iCount_elements, -1);
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qNameSet, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set(bigIntegerArr[i]);
        }
    }

    public void arraySetterHelper(String[] strArr, QName qName, QNameSet qNameSet) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = strArr == null ? 0 : strArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qNameSet);
        while (iCount_elements > length) {
            iCount_elements = AbstractC12991c.m13981b(iCount_elements, 1, typeStore, qNameSet, iCount_elements, -1);
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qNameSet, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set(strArr[i]);
        }
    }

    public void arraySetterHelper(byte[][] bArr, QName qName, QNameSet qNameSet) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = bArr == null ? 0 : bArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qNameSet);
        while (iCount_elements > length) {
            iCount_elements = AbstractC12991c.m13981b(iCount_elements, 1, typeStore, qNameSet, iCount_elements, -1);
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qNameSet, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set(bArr[i]);
        }
    }

    public void arraySetterHelper(GDate[] gDateArr, QName qName, QNameSet qNameSet) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = gDateArr == null ? 0 : gDateArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qNameSet);
        while (iCount_elements > length) {
            iCount_elements = AbstractC12991c.m13981b(iCount_elements, 1, typeStore, qNameSet, iCount_elements, -1);
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qNameSet, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set((GDateSpecification) gDateArr[i]);
        }
    }

    public void arraySetterHelper(GDuration[] gDurationArr, QName qName, QNameSet qNameSet) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = gDurationArr == null ? 0 : gDurationArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qNameSet);
        while (iCount_elements > length) {
            iCount_elements = AbstractC12991c.m13981b(iCount_elements, 1, typeStore, qNameSet, iCount_elements, -1);
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qNameSet, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set((GDurationSpecification) gDurationArr[i]);
        }
    }

    public void arraySetterHelper(Calendar[] calendarArr, QName qName, QNameSet qNameSet) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = calendarArr == null ? 0 : calendarArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qNameSet);
        while (iCount_elements > length) {
            iCount_elements = AbstractC12991c.m13981b(iCount_elements, 1, typeStore, qNameSet, iCount_elements, -1);
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qNameSet, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set(calendarArr[i]);
        }
    }

    public void arraySetterHelper(Date[] dateArr, QName qName, QNameSet qNameSet) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = dateArr == null ? 0 : dateArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qNameSet);
        while (iCount_elements > length) {
            iCount_elements = AbstractC12991c.m13981b(iCount_elements, 1, typeStore, qNameSet, iCount_elements, -1);
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qNameSet, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set(dateArr[i]);
        }
    }

    public void arraySetterHelper(QName[] qNameArr, QName qName, QNameSet qNameSet) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = qNameArr == null ? 0 : qNameArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qNameSet);
        while (iCount_elements > length) {
            iCount_elements = AbstractC12991c.m13981b(iCount_elements, 1, typeStore, qNameSet, iCount_elements, -1);
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qNameSet, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set(qNameArr[i]);
        }
    }

    public void arraySetterHelper(StringEnumAbstractBase[] stringEnumAbstractBaseArr, QName qName, QNameSet qNameSet) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = stringEnumAbstractBaseArr == null ? 0 : stringEnumAbstractBaseArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qNameSet);
        while (iCount_elements > length) {
            iCount_elements = AbstractC12991c.m13981b(iCount_elements, 1, typeStore, qNameSet, iCount_elements, -1);
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qNameSet, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set(stringEnumAbstractBaseArr[i]);
        }
    }

    public void arraySetterHelper(List[] listArr, QName qName, QNameSet qNameSet) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = listArr == null ? 0 : listArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qNameSet);
        while (iCount_elements > length) {
            iCount_elements = AbstractC12991c.m13981b(iCount_elements, 1, typeStore, qNameSet, iCount_elements, -1);
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qNameSet, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set(listArr[i]);
        }
    }

    public void arraySetterHelper(XmlObject[] xmlObjectArr, QName qName) throws Throwable {
        int i;
        int i2;
        int i4;
        int iCount_elements;
        TypeStoreUser typeStoreUserFind_element_user;
        TypeStore typeStore = get_store();
        int i5 = 0;
        if (xmlObjectArr != null && xmlObjectArr.length != 0) {
            int iCount_elements2 = typeStore.count_elements(qName);
            int i6 = 0;
            while (true) {
                if (i6 >= xmlObjectArr.length) {
                    break;
                }
                if (!xmlObjectArr[i6].isImmutable()) {
                    XmlCursor xmlCursorNewCursor = xmlObjectArr[i6].newCursor();
                    if (xmlCursorNewCursor.toParent() && xmlCursorNewCursor.getObject() == this) {
                        xmlCursorNewCursor.dispose();
                        break;
                    }
                    xmlCursorNewCursor.dispose();
                }
                i6++;
            }
            if (i6 >= xmlObjectArr.length || typeStore.find_element_user(qName, 0) != xmlObjectArr[i6]) {
                i = 0;
                i2 = 0;
                i4 = i6;
                iCount_elements = iCount_elements2;
            } else {
                while (i5 < i6) {
                    ((XmlObjectBase) typeStore.insert_element_user(qName, i5)).set(xmlObjectArr[i5]);
                    i5++;
                }
                int i7 = i6 + 1;
                int i8 = i5 + 1;
                int i9 = i7;
                while (i9 < xmlObjectArr.length) {
                    XmlCursor xmlCursorNewCursor2 = xmlObjectArr[i9].isImmutable() ? null : xmlObjectArr[i9].newCursor();
                    if (xmlCursorNewCursor2 != null && xmlCursorNewCursor2.toParent() && xmlCursorNewCursor2.getObject() == this) {
                        xmlCursorNewCursor2.dispose();
                        if (typeStore.find_element_user(qName, i8) != xmlObjectArr[i9]) {
                            break;
                        }
                    } else {
                        xmlCursorNewCursor2.dispose();
                        ((XmlObjectBase) typeStore.insert_element_user(qName, i8)).set(xmlObjectArr[i9]);
                    }
                    i9++;
                    i8++;
                }
                iCount_elements = typeStore.count_elements(qName);
                i = i9;
                i4 = i;
                i2 = i8;
            }
            for (int i10 = i4; i10 < xmlObjectArr.length; i10++) {
                ((XmlObjectBase) typeStore.add_element_user(qName)).set(xmlObjectArr[i10]);
            }
            int iM13980a = iCount_elements;
            while (iM13980a > (i4 - i) + i2) {
                iM13980a = AbstractC12991c.m13980a(iM13980a, 1, typeStore, qName, iM13980a, -1);
            }
            while (i < i4) {
                if (i2 >= iM13980a) {
                    typeStoreUserFind_element_user = typeStore.add_element_user(qName);
                } else {
                    typeStoreUserFind_element_user = typeStore.find_element_user(qName, i2);
                }
                ((XmlObjectBase) typeStoreUserFind_element_user).set(xmlObjectArr[i]);
                i++;
                i2++;
            }
            return;
        }
        for (int iCount_elements3 = typeStore.count_elements(qName); iCount_elements3 > 0; iCount_elements3--) {
            typeStore.remove_element(qName, 0);
        }
    }

    public void arraySetterHelper(XmlObject[] xmlObjectArr, QName qName, QNameSet qNameSet) throws Throwable {
        int i;
        int i2;
        int i4;
        int iCount_elements;
        TypeStoreUser typeStoreUserFind_element_user;
        TypeStore typeStore = get_store();
        int i5 = 0;
        if (xmlObjectArr != null && xmlObjectArr.length != 0) {
            int iCount_elements2 = typeStore.count_elements(qNameSet);
            int i6 = 0;
            while (true) {
                if (i6 >= xmlObjectArr.length) {
                    break;
                }
                if (!xmlObjectArr[i6].isImmutable()) {
                    XmlCursor xmlCursorNewCursor = xmlObjectArr[i6].newCursor();
                    if (xmlCursorNewCursor.toParent() && xmlCursorNewCursor.getObject() == this) {
                        xmlCursorNewCursor.dispose();
                        break;
                    }
                    xmlCursorNewCursor.dispose();
                }
                i6++;
            }
            if (i6 >= xmlObjectArr.length || typeStore.find_element_user(qNameSet, 0) != xmlObjectArr[i6]) {
                i = 0;
                i2 = 0;
                i4 = i6;
                iCount_elements = iCount_elements2;
            } else {
                while (i5 < i6) {
                    ((XmlObjectBase) typeStore.insert_element_user(qNameSet, qName, i5)).set(xmlObjectArr[i5]);
                    i5++;
                }
                int i7 = i6 + 1;
                int i8 = i5 + 1;
                int i9 = i7;
                while (i9 < xmlObjectArr.length) {
                    XmlCursor xmlCursorNewCursor2 = xmlObjectArr[i9].isImmutable() ? null : xmlObjectArr[i9].newCursor();
                    if (xmlCursorNewCursor2 != null && xmlCursorNewCursor2.toParent() && xmlCursorNewCursor2.getObject() == this) {
                        xmlCursorNewCursor2.dispose();
                        if (typeStore.find_element_user(qNameSet, i8) != xmlObjectArr[i9]) {
                            break;
                        }
                    } else {
                        xmlCursorNewCursor2.dispose();
                        ((XmlObjectBase) typeStore.insert_element_user(qNameSet, qName, i8)).set(xmlObjectArr[i9]);
                    }
                    i9++;
                    i8++;
                }
                iCount_elements = typeStore.count_elements(qName);
                i = i9;
                i4 = i;
                i2 = i8;
            }
            for (int i10 = i4; i10 < xmlObjectArr.length; i10++) {
                ((XmlObjectBase) typeStore.add_element_user(qName)).set(xmlObjectArr[i10]);
            }
            int iM13981b = iCount_elements;
            while (iM13981b > (i4 - i) + i2) {
                iM13981b = AbstractC12991c.m13981b(iM13981b, 1, typeStore, qNameSet, iM13981b, -1);
            }
            while (i < i4) {
                if (i2 >= iM13981b) {
                    typeStoreUserFind_element_user = typeStore.add_element_user(qName);
                } else {
                    typeStoreUserFind_element_user = typeStore.find_element_user(qNameSet, i2);
                }
                ((XmlObjectBase) typeStoreUserFind_element_user).set(xmlObjectArr[i]);
                i++;
                i2++;
            }
            return;
        }
        for (int iCount_elements3 = typeStore.count_elements(qNameSet); iCount_elements3 > 0; iCount_elements3--) {
            typeStore.remove_element(qNameSet, 0);
        }
    }
}
