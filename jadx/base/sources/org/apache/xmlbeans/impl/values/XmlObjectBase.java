package org.apache.xmlbeans.impl.values;

import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import kotlin.collections.AbstractC12991c;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.DelegateXmlObject;
import org.apache.xmlbeans.GDate;
import org.apache.xmlbeans.GDateSpecification;
import org.apache.xmlbeans.GDuration;
import org.apache.xmlbeans.GDurationSpecification;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.SchemaAttributeModel;
import org.apache.xmlbeans.SchemaField;
import org.apache.xmlbeans.SchemaLocalAttribute;
import org.apache.xmlbeans.SchemaProperty;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlDocumentProperties;
import org.apache.xmlbeans.XmlError;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlRuntimeException;
import org.apache.xmlbeans.impl.common.GlobalLock;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;
import org.apache.xmlbeans.impl.common.XmlErrorWatcher;
import org.apache.xmlbeans.impl.common.XmlLocale;
import org.apache.xmlbeans.impl.common.XmlWhitespace;
import org.apache.xmlbeans.impl.schema.SchemaTypeImpl;
import org.apache.xmlbeans.impl.schema.SchemaTypeVisitorImpl;
import org.apache.xmlbeans.impl.validator.Validator;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;
import org.xml.sax.ContentHandler;
import org.xml.sax.ext.LexicalHandler;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class XmlObjectBase implements TypeStoreUser, Serializable, XmlObject, SimpleValue {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final XmlObject[] EMPTY_RESULT;
    private static final int FLAGS_DATED = 672;
    private static final int FLAGS_ELEMENT = 7;
    private static final int FLAG_ATTRIBUTE = 8;
    private static final int FLAG_COMPLEXCONTENT = 16384;
    private static final int FLAG_COMPLEXTYPE = 8192;
    private static final int FLAG_ELEMENT_DATED = 512;
    private static final int FLAG_FIXED = 4;
    private static final int FLAG_HASDEFAULT = 2;
    private static final int FLAG_IMMUTABLE = 4096;
    private static final int FLAG_ISDEFAULT = 256;
    private static final int FLAG_NIL = 64;
    private static final int FLAG_NILLABLE = 1;
    private static final int FLAG_NIL_DATED = 128;
    private static final int FLAG_NOT_VARIABLE = 32768;
    private static final int FLAG_ORPHANED = 2048;
    private static final int FLAG_SETTINGDEFAULT = 1024;
    private static final int FLAG_STORE = 16;
    private static final int FLAG_VALIDATE_ON_SET = 65536;
    private static final int FLAG_VALUE_DATED = 32;
    public static final short KIND_SETTERHELPER_ARRAYITEM = 2;
    public static final short KIND_SETTERHELPER_SINGLETON = 1;
    public static final short MAJOR_VERSION_NUMBER = 1;
    public static final short MINOR_VERSION_NUMBER = 1;
    private static final BigInteger _max;
    private static final BigInteger _min;
    private static final XmlOptions _toStringOptions;
    public static final ValidationContext _voorVc;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$values$XmlObjectBase;
    private int _flags = 65;
    private Object _textsource;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ImmutableValueValidationContext implements ValidationContext {
        private Collection _coll;
        private XmlObject _loc;

        public ImmutableValueValidationContext(Collection collection, XmlObject xmlObject) {
            this._coll = collection;
            this._loc = xmlObject;
        }

        @Override // org.apache.xmlbeans.impl.common.ValidationContext
        public void invalid(String str) {
            this._coll.add(XmlError.forObject(str, this._loc));
        }

        @Override // org.apache.xmlbeans.impl.common.ValidationContext
        public void invalid(String str, Object[] objArr) {
            this._coll.add(XmlError.forObject(str, objArr, this._loc));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SerializedInteriorObject implements Serializable {
        private static final long serialVersionUID = 1;
        transient XmlObject _impl;
        transient XmlObject _root;

        private int distanceToRoot() {
            XmlCursor xmlCursorNewCursor = this._impl.newCursor();
            int i = 0;
            while (!xmlCursorNewCursor.toPrevToken().isNone()) {
                if (!xmlCursorNewCursor.currentTokenType().isNamespace()) {
                    i++;
                }
            }
            xmlCursorNewCursor.dispose();
            return i;
        }

        private XmlObject objectAtDistance(int i) {
            XmlCursor xmlCursorNewCursor = this._root.newCursor();
            while (i > 0) {
                xmlCursorNewCursor.toNextToken();
                if (!xmlCursorNewCursor.currentTokenType().isNamespace()) {
                    i--;
                }
            }
            XmlObject object = xmlCursorNewCursor.getObject();
            xmlCursorNewCursor.dispose();
            return object;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException {
            this._root = (XmlObject) objectInputStream.readObject();
            objectInputStream.readBoolean();
            this._impl = objectAtDistance(objectInputStream.readInt());
        }

        private Object readResolve() {
            return this._impl;
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeObject(this._root);
            objectOutputStream.writeBoolean(false);
            objectOutputStream.writeInt(distanceToRoot());
        }

        private SerializedInteriorObject() {
        }

        private SerializedInteriorObject(XmlObject xmlObject, XmlObject xmlObject2) {
            this._impl = xmlObject;
            this._root = xmlObject2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SerializedRootObject implements Serializable {
        private static final long serialVersionUID = 1;
        transient XmlObject _impl;
        transient Class _xbeanClass;

        private void readObject(ObjectInputStream objectInputStream) throws Throwable {
            int unsignedShort;
            int unsignedShort2;
            String objectV0;
            try {
                this._xbeanClass = (Class) objectInputStream.readObject();
                int unsignedShort3 = objectInputStream.readUnsignedShort();
                if (unsignedShort3 == 0) {
                    unsignedShort = objectInputStream.readUnsignedShort();
                    unsignedShort2 = objectInputStream.readUnsignedShort();
                } else {
                    unsignedShort = 0;
                    unsignedShort2 = 0;
                }
                if (unsignedShort == 0) {
                    objectV0 = readObjectV0(objectInputStream, unsignedShort3);
                    objectInputStream.readBoolean();
                } else {
                    if (unsignedShort != 1) {
                        StringBuffer stringBuffer = new StringBuffer("Deserialization error: version number ");
                        stringBuffer.append(unsignedShort);
                        stringBuffer.append(Extension.DOT);
                        stringBuffer.append(unsignedShort2);
                        stringBuffer.append(" not supported.");
                        throw new IOException(stringBuffer.toString());
                    }
                    if (unsignedShort2 != 1) {
                        StringBuffer stringBuffer2 = new StringBuffer("Deserialization error: version number ");
                        stringBuffer2.append(unsignedShort);
                        stringBuffer2.append(Extension.DOT);
                        stringBuffer2.append(unsignedShort2);
                        stringBuffer2.append(" not supported.");
                        throw new IOException(stringBuffer2.toString());
                    }
                    objectV0 = (String) objectInputStream.readObject();
                    objectInputStream.readBoolean();
                }
                this._impl = XmlBeans.getContextTypeLoader().parse(objectV0, (SchemaType) null, new XmlOptions().setDocumentType(XmlBeans.typeForClass(this._xbeanClass)));
            } catch (Exception e) {
                throw ((IOException) new IOException(e.getMessage()).initCause(e));
            }
        }

        private String readObjectV0(ObjectInputStream objectInputStream, int i) throws Throwable {
            DataInputStream dataInputStream;
            Throwable th;
            byte[] bArr = new byte[i + 2];
            int i2 = 0;
            bArr[0] = (byte) ((i >> 8) & 255);
            bArr[1] = (byte) (i & 255);
            while (i2 < i) {
                int i4 = objectInputStream.read(bArr, i2 + 2, i - i2);
                if (i4 == -1) {
                    break;
                }
                i2 += i4;
            }
            if (i2 != i) {
                StringBuffer stringBuffer = new StringBuffer("Error reading backwards compatible XmlObject: number of bytes read (");
                stringBuffer.append(i2);
                stringBuffer.append(") != number expected (");
                stringBuffer.append(i);
                stringBuffer.append(")");
                throw new IOException(stringBuffer.toString());
            }
            try {
                dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
                try {
                    String utf = dataInputStream.readUTF();
                    dataInputStream.close();
                    return utf;
                } catch (Throwable th2) {
                    th = th2;
                    if (dataInputStream != null) {
                        dataInputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                dataInputStream = null;
                th = th3;
            }
        }

        private Object readResolve() {
            return this._impl;
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeObject(this._xbeanClass);
            objectOutputStream.writeShort(0);
            objectOutputStream.writeShort(1);
            objectOutputStream.writeShort(1);
            objectOutputStream.writeObject(this._impl.xmlText());
            objectOutputStream.writeBoolean(false);
        }

        private SerializedRootObject() {
        }

        private SerializedRootObject(XmlObject xmlObject) {
            this._xbeanClass = xmlObject.schemaType().getJavaClass();
            this._impl = xmlObject;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ValueOutOfRangeValidationContext implements ValidationContext {
        private ValueOutOfRangeValidationContext() {
        }

        @Override // org.apache.xmlbeans.impl.common.ValidationContext
        public void invalid(String str) {
            throw new XmlValueOutOfRangeException(str);
        }

        @Override // org.apache.xmlbeans.impl.common.ValidationContext
        public void invalid(String str, Object[] objArr) {
            throw new XmlValueOutOfRangeException(str, objArr);
        }
    }

    static {
        if (class$org$apache$xmlbeans$impl$values$XmlObjectBase == null) {
            class$org$apache$xmlbeans$impl$values$XmlObjectBase = class$("org.apache.xmlbeans.impl.values.XmlObjectBase");
        }
        $assertionsDisabled = true;
        _voorVc = new ValueOutOfRangeValidationContext();
        _max = BigInteger.valueOf(Long.MAX_VALUE);
        _min = BigInteger.valueOf(Long.MIN_VALUE);
        _toStringOptions = buildInnerPrettyOptions();
        EMPTY_RESULT = new XmlObject[0];
    }

    private static XmlObject[] _typedArray(XmlObject[] xmlObjectArr) {
        if (xmlObjectArr.length != 0) {
            SchemaType schemaType = xmlObjectArr[0].schemaType();
            if (!schemaType.equals(XmlObject.type) && !schemaType.isNoType()) {
                int i = 1;
                while (true) {
                    if (i >= xmlObjectArr.length) {
                        Class javaClass = schemaType.getJavaClass();
                        while (javaClass == null) {
                            schemaType = schemaType.getBaseType();
                            if (!XmlObject.type.equals(schemaType)) {
                                javaClass = schemaType.getJavaClass();
                            }
                        }
                        XmlObject[] xmlObjectArr2 = (XmlObject[]) Array.newInstance((Class<?>) javaClass, xmlObjectArr.length);
                        System.arraycopy(xmlObjectArr, 0, xmlObjectArr2, 0, xmlObjectArr.length);
                        return xmlObjectArr2;
                    }
                    if (xmlObjectArr[i].schemaType().isNoType()) {
                        break;
                    }
                    schemaType = schemaType.getCommonBaseType(xmlObjectArr[i].schemaType());
                    if (schemaType.equals(XmlObject.type)) {
                        break;
                    }
                    i++;
                }
            }
        }
        return xmlObjectArr;
    }

    private final String apply_wscanon(String str) {
        return XmlWhitespace.collapse(str, get_wscanon_rule());
    }

    public static final XmlOptions buildInnerPrettyOptions() {
        XmlOptions xmlOptions = new XmlOptions();
        xmlOptions.put(XmlOptions.SAVE_INNER);
        xmlOptions.put(XmlOptions.SAVE_PRETTY_PRINT);
        xmlOptions.put(XmlOptions.SAVE_AGGRESSIVE_NAMESPACES);
        xmlOptions.put(XmlOptions.SAVE_USE_DEFAULT_NAMESPACE);
        return xmlOptions;
    }

    private final void check_element_dated() {
        int i = this._flags;
        if ((i & 512) != 0 && (i & 32768) == 0) {
            if ((i & 2048) != 0) {
                throw new XmlValueDisconnectedException();
            }
            this._flags = get_store().compute_flags() | (this._flags & (-520));
        }
        int i2 = this._flags;
        if ((i2 & 32768) != 0) {
            this._flags = i2 & (-513);
        }
    }

    public static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw AbstractC12991c.m13994o(e);
        }
    }

    private final boolean comparable_value_spaces(SchemaType schemaType, SchemaType schemaType2) {
        if (!$assertionsDisabled && (schemaType.getSimpleVariety() == 2 || schemaType2.getSimpleVariety() == 2)) {
            throw new AssertionError();
        }
        if (!schemaType.isSimpleType() && !schemaType2.isSimpleType()) {
            return schemaType.getContentType() == schemaType2.getContentType();
        }
        if (schemaType.isSimpleType() && schemaType2.isSimpleType()) {
            if (schemaType.getSimpleVariety() == 3 && schemaType2.getSimpleVariety() == 3) {
                return true;
            }
            if (schemaType.getSimpleVariety() != 3 && schemaType2.getSimpleVariety() != 3) {
                return schemaType.getPrimitiveType().equals(schemaType2.getPrimitiveType());
            }
        }
        return false;
    }

    private final int compareValueImpl(XmlObject xmlObject) {
        SchemaType schemaTypeInstanceType;
        SchemaType schemaTypeInstanceType2;
        try {
            schemaTypeInstanceType = instanceType();
            schemaTypeInstanceType2 = ((SimpleValue) xmlObject).instanceType();
        } catch (XmlValueOutOfRangeException unused) {
        }
        if (schemaTypeInstanceType == null && schemaTypeInstanceType2 == null) {
            return 0;
        }
        if (schemaTypeInstanceType != null && schemaTypeInstanceType2 != null && schemaTypeInstanceType.isSimpleType() && !schemaTypeInstanceType.isURType() && schemaTypeInstanceType2.isSimpleType() && !schemaTypeInstanceType2.isURType()) {
            if (schemaTypeInstanceType.getPrimitiveType().getBuiltinTypeCode() != schemaTypeInstanceType2.getPrimitiveType().getBuiltinTypeCode()) {
                return 2;
            }
            return compare_to(xmlObject);
        }
        return 2;
    }

    private XmlObject ensureStore() {
        String strCompute_text;
        if ((this._flags & 16) != 0) {
            return this;
        }
        check_dated();
        if ((this._flags & 64) != 0) {
            strCompute_text = "";
        } else {
            strCompute_text = compute_text(has_store() ? get_store() : null);
        }
        XmlObject xmlObjectNewInstance = XmlObject.Factory.newInstance(new XmlOptions().setDocumentType(schemaType()));
        XmlCursor xmlCursorNewCursor = xmlObjectNewInstance.newCursor();
        xmlCursorNewCursor.toNextToken();
        xmlCursorNewCursor.insertChars(strCompute_text);
        return xmlObjectNewInstance;
    }

    private final String getPrimitiveTypeName() {
        SchemaType schemaType = schemaType();
        if (schemaType.isNoType()) {
            return "unknown";
        }
        SchemaType primitiveType = schemaType.getPrimitiveType();
        return primitiveType == null ? "complex" : primitiveType.getName().getLocalPart();
    }

    private XmlObject getRootXmlObject() {
        XmlCursor xmlCursorNewCursor = newCursor();
        if (xmlCursorNewCursor == null) {
            return this;
        }
        xmlCursorNewCursor.toStartDoc();
        XmlObject object = xmlCursorNewCursor.getObject();
        xmlCursorNewCursor.dispose();
        return object;
    }

    private XmlObjectBase getTargetForSetter(QName qName, int i, short s) {
        if (s == 1) {
            check_orphaned();
            XmlObjectBase xmlObjectBase = (XmlObjectBase) get_store().find_element_user(qName, i);
            if (xmlObjectBase == null) {
                xmlObjectBase = (XmlObjectBase) get_store().add_element_user(qName);
            }
            if (xmlObjectBase.isImmutable()) {
                throw new IllegalStateException("Cannot set the value of an immutable XmlObject");
            }
            return xmlObjectBase;
        }
        if (s != 2) {
            StringBuffer stringBuffer = new StringBuffer("Unknown kindSetterHelper: ");
            stringBuffer.append((int) s);
            throw new IllegalArgumentException(stringBuffer.toString());
        }
        check_orphaned();
        XmlObjectBase xmlObjectBase2 = (XmlObjectBase) get_store().find_element_user(qName, i);
        if (xmlObjectBase2 == null) {
            throw new IndexOutOfBoundsException();
        }
        if (xmlObjectBase2.isImmutable()) {
            throw new IllegalStateException("Cannot set the value of an immutable XmlObject");
        }
        return xmlObjectBase2;
    }

    private boolean isRootXmlObject() {
        XmlCursor xmlCursorNewCursor = newCursor();
        if (xmlCursorNewCursor == null) {
            return false;
        }
        boolean z = !xmlCursorNewCursor.toParent();
        xmlCursorNewCursor.dispose();
        return z;
    }

    public static Object java_value(XmlObject xmlObject) {
        if (xmlObject.isNil()) {
            return null;
        }
        if (!(xmlObject instanceof XmlAnySimpleType)) {
            return xmlObject;
        }
        SimpleValue simpleValue = (SimpleValue) xmlObject;
        SchemaType schemaTypeInstanceType = simpleValue.instanceType();
        boolean z = $assertionsDisabled;
        if (!z && schemaTypeInstanceType == null) {
            throw new AssertionError("Nil case should have been handled above");
        }
        if (schemaTypeInstanceType.getSimpleVariety() == 3) {
            return simpleValue.getListValue();
        }
        switch (schemaTypeInstanceType.getPrimitiveType().getBuiltinTypeCode()) {
            case 2:
            case 8:
            case 12:
                break;
            case 3:
                return simpleValue.getBooleanValue() ? Boolean.TRUE : Boolean.FALSE;
            case 4:
            case 5:
                return simpleValue.getByteArrayValue();
            case 6:
                return simpleValue.getStringValue();
            case 7:
                return simpleValue.getQNameValue();
            case 9:
                return new Float(simpleValue.getFloatValue());
            case 10:
                return new Double(simpleValue.getDoubleValue());
            case 11:
                int decimalSize = schemaTypeInstanceType.getDecimalSize();
                if (decimalSize == 8) {
                    return new Byte(simpleValue.getByteValue());
                }
                if (decimalSize == 16) {
                    return new Short(simpleValue.getShortValue());
                }
                if (decimalSize == 32) {
                    return new Integer(simpleValue.getIntValue());
                }
                if (decimalSize == 64) {
                    return new Long(simpleValue.getLongValue());
                }
                switch (decimalSize) {
                    case 1000000:
                        return simpleValue.getBigIntegerValue();
                    case SchemaType.SIZE_BIG_DECIMAL /* 1000001 */:
                        break;
                    default:
                        if (!z) {
                            throw new AssertionError("invalid numeric bit count");
                        }
                        break;
                }
                return simpleValue.getBigDecimalValue();
            case 13:
                return simpleValue.getGDurationValue();
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
                return simpleValue.getCalendarValue();
            default:
                if (!z) {
                    throw new AssertionError("encountered nonprimitive type.");
                }
                break;
        }
        return simpleValue.getStringValue();
    }

    private static XmlOptions makeInnerOptions(XmlOptions xmlOptions) {
        XmlOptions xmlOptions2 = new XmlOptions(xmlOptions);
        xmlOptions2.put(XmlOptions.SAVE_INNER);
        return xmlOptions2;
    }

    private TypeStoreUser objSetterHelper(XmlObjectBase xmlObjectBase, QName qName, int i, short s) {
        XmlObjectBase targetForSetter = getTargetForSetter(qName, i, s);
        targetForSetter.check_orphaned();
        xmlObjectBase.check_orphaned();
        return targetForSetter.get_store().copy_contents_from(xmlObjectBase.get_store()).get_store().change_type(xmlObjectBase.schemaType());
    }

    private boolean preCheck() {
        if (has_store()) {
            return get_store().get_locale().noSync();
        }
        return false;
    }

    private SchemaField schemaField() {
        SchemaField containerField = schemaType().getContainerField();
        return containerField == null ? get_store().get_schema_field() : containerField;
    }

    private final void set_commit() {
        int i = this._flags;
        boolean z = (i & 64) != 0;
        this._flags = i & (-321);
        if ((i & 16) == 0) {
            this._textsource = null;
            return;
        }
        this._flags = i & (-993);
        get_store().invalidate_text();
        if (z) {
            get_store().invalidate_nil();
        }
    }

    private final void set_prepare() {
        check_element_dated();
        if ((this._flags & 4096) != 0) {
            throw new IllegalStateException();
        }
    }

    private TypeStoreUser setterHelper(XmlObjectBase xmlObjectBase) {
        check_orphaned();
        xmlObjectBase.check_orphaned();
        return get_store().copy_contents_from(xmlObjectBase.get_store()).get_store().change_type(xmlObjectBase.schemaType());
    }

    private static XmlObjectBase underlying(XmlObject xmlObject) {
        if (xmlObject == null) {
            return null;
        }
        if (xmlObject instanceof XmlObjectBase) {
            return (XmlObjectBase) xmlObject;
        }
        while (xmlObject instanceof DelegateXmlObject) {
            xmlObject = ((DelegateXmlObject) xmlObject).underlyingXmlObject();
        }
        if (xmlObject instanceof XmlObjectBase) {
            return (XmlObjectBase) xmlObject;
        }
        throw new IllegalStateException("Non-native implementations of XmlObject should extend FilterXmlObject or implement DelegateXmlObject");
    }

    private final void update_from_wscanon_text(String str) {
        int i = this._flags;
        if ((i & 2) == 0 || (i & 1024) != 0 || (i & 8) != 0 || !str.equals("")) {
            set_text(str);
            this._flags &= -321;
            return;
        }
        String strCompute_default_text = get_store().compute_default_text();
        if (strCompute_default_text == null) {
            throw new XmlValueOutOfRangeException();
        }
        this._flags |= 1024;
        try {
            setStringValue(strCompute_default_text);
            this._flags = (this._flags & (-1089)) | 256;
        } catch (Throwable th) {
            this._flags &= -1025;
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean validate_immutable(XmlOptions xmlOptions) {
        boolean zHasError;
        XmlErrorWatcher xmlErrorWatcher = new XmlErrorWatcher(xmlOptions == null ? null : (Collection) xmlOptions.get(XmlOptions.ERROR_LISTENER));
        if (schemaType().isSimpleType() || (xmlOptions != null && xmlOptions.hasOption(XmlOptions.VALIDATE_TEXT_ONLY))) {
            String str = (String) this._textsource;
            if (str == null) {
                str = "";
            }
            validate_simpleval(str, new ImmutableValueValidationContext(xmlErrorWatcher, this));
            zHasError = xmlErrorWatcher.hasError();
        } else {
            SchemaProperty[] properties = schemaType().getProperties();
            for (int i = 0; i < properties.length; i++) {
                if (properties[i].getMinOccurs().signum() > 0) {
                    if (properties[i].isAttribute()) {
                        xmlErrorWatcher.add(XmlError.forObject(XmlErrorCodes.ELEM_COMPLEX_TYPE_LOCALLY_VALID$MISSING_REQUIRED_ATTRIBUTE, new Object[]{QNameHelper.pretty(properties[i].getName())}, this));
                    } else {
                        xmlErrorWatcher.add(XmlError.forObject(XmlErrorCodes.ELEM_COMPLEX_TYPE_LOCALLY_VALID$MISSING_ELEMENT, new Object[]{properties[i].getMinOccurs(), QNameHelper.pretty(properties[i].getName())}, this));
                    }
                }
            }
            if (schemaType().getContentType() != 2) {
                zHasError = xmlErrorWatcher.hasError();
            }
        }
        return !zHasError;
    }

    private final boolean valueEqualsImpl(XmlObject xmlObject) {
        check_dated();
        SchemaType schemaTypeInstanceType = instanceType();
        SchemaType schemaTypeInstanceType2 = ((SimpleValue) xmlObject).instanceType();
        if (schemaTypeInstanceType == null && schemaTypeInstanceType2 == null) {
            return true;
        }
        if (schemaTypeInstanceType == null || schemaTypeInstanceType2 == null || !comparable_value_spaces(schemaTypeInstanceType, schemaTypeInstanceType2)) {
            return false;
        }
        return xmlObject.schemaType().getSimpleVariety() == 2 ? underlying(xmlObject).equal_to(this) : equal_to(xmlObject);
    }

    public final XmlObject _copy() {
        return _copy(null);
    }

    public boolean _isComplexContent() {
        return (this._flags & 16384) != 0;
    }

    public boolean _isComplexType() {
        return (this._flags & 8192) != 0;
    }

    public final XmlObject _set(XmlObject xmlObject) {
        TypeStoreUser typeStoreUserChange_type;
        if (isImmutable()) {
            throw new IllegalStateException("Cannot set the value of an immutable XmlObject");
        }
        XmlObjectBase xmlObjectBaseUnderlying = underlying(xmlObject);
        if (xmlObjectBaseUnderlying == null) {
            setNil();
            return this;
        }
        if (xmlObjectBaseUnderlying.isImmutable()) {
            set(xmlObjectBaseUnderlying.stringValue());
            typeStoreUserChange_type = this;
        } else {
            check_orphaned();
            xmlObjectBaseUnderlying.check_orphaned();
            typeStoreUserChange_type = get_store().copy_contents_from(xmlObjectBaseUnderlying.get_store()).get_store().change_type(xmlObjectBaseUnderlying.schemaType());
        }
        return (XmlObject) typeStoreUserChange_type;
    }

    public boolean _validateOnSet() {
        return (this._flags & 65536) != 0;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public final void attach_store(TypeStore typeStore) {
        this._textsource = typeStore;
        int i = this._flags;
        if ((i & 4096) != 0) {
            throw new IllegalStateException();
        }
        this._flags = i | 688;
        if (typeStore.is_attribute()) {
            this._flags |= 8;
        }
        if (typeStore.validate_on_set()) {
            this._flags |= 65536;
        }
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public BigDecimal bigDecimalValue() {
        return getBigDecimalValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public BigInteger bigIntegerValue() {
        return getBigIntegerValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public boolean booleanValue() {
        return getBooleanValue();
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public boolean build_nil() {
        boolean z = $assertionsDisabled;
        if (!z && (this._flags & 16) == 0) {
            throw new AssertionError();
        }
        if (z || (this._flags & 32) == 0) {
            return (this._flags & 64) != 0;
        }
        throw new AssertionError();
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public final String build_text(NamespaceManager namespaceManager) {
        boolean z = $assertionsDisabled;
        if (!z && (this._flags & 16) == 0) {
            throw new AssertionError();
        }
        if (!z && (this._flags & 32) != 0) {
            throw new AssertionError();
        }
        if ((this._flags & 320) != 0) {
            return "";
        }
        if (namespaceManager == null) {
            namespaceManager = has_store() ? get_store() : null;
        }
        return compute_text(namespaceManager);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public byte[] byteArrayValue() {
        return getByteArrayValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public byte byteValue() {
        return getByteValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public Calendar calendarValue() {
        return getCalendarValue();
    }

    @Override // org.apache.xmlbeans.XmlObject
    public XmlObject changeType(SchemaType schemaType) {
        XmlObject xmlObject;
        if (schemaType == null) {
            throw new IllegalArgumentException("Invalid type (null)");
        }
        if ((this._flags & 16) == 0) {
            throw new IllegalStateException("XML Value Objects cannot have thier type changed");
        }
        synchronized (monitor()) {
            check_orphaned();
            xmlObject = (XmlObject) get_store().change_type(schemaType);
        }
        return xmlObject;
    }

    public final void check_dated() {
        String str;
        int i = this._flags;
        if ((i & FLAGS_DATED) != 0) {
            if ((i & 2048) != 0) {
                throw new XmlValueDisconnectedException();
            }
            if (!$assertionsDisabled && (i & 16) == 0) {
                throw new AssertionError();
            }
            check_element_dated();
            if ((this._flags & 512) != 0) {
                this._flags = get_store().compute_flags() | (this._flags & (-520));
            }
            boolean z = false;
            if ((this._flags & 128) != 0) {
                if (get_store().find_nil()) {
                    int i2 = this._flags;
                    if ((i2 & 1) == 0 && (i2 & 65536) != 0) {
                        throw new XmlValueOutOfRangeException();
                    }
                    set_nil();
                    this._flags |= 64;
                    z = true;
                } else {
                    this._flags &= -65;
                }
                this._flags &= -129;
            }
            if (!z) {
                if ((this._flags & 16384) != 0 || (str = get_wscanon_text()) == null) {
                    update_from_complex_content();
                } else {
                    NamespaceContext.push(new NamespaceContext(get_store()));
                    try {
                        update_from_wscanon_text(str);
                    } finally {
                        NamespaceContext.pop();
                    }
                }
            }
            this._flags &= -33;
        }
    }

    public final void check_orphaned() {
        if (is_orphaned()) {
            throw new XmlValueDisconnectedException();
        }
    }

    @Override // org.apache.xmlbeans.XmlObject
    public final int compareTo(Object obj) throws Throwable {
        int iCompareValue = compareValue((XmlObject) obj);
        if (iCompareValue != 2) {
            return iCompareValue;
        }
        throw new ClassCastException();
    }

    @Override // org.apache.xmlbeans.XmlObject
    public final int compareValue(XmlObject xmlObject) throws Throwable {
        int iCompareValueImpl;
        int iCompareValueImpl2;
        if (xmlObject == null) {
            return 2;
        }
        boolean z = false;
        try {
            try {
                if (isImmutable()) {
                    if (xmlObject.isImmutable()) {
                        return compareValueImpl(xmlObject);
                    }
                    synchronized (xmlObject.monitor()) {
                        iCompareValueImpl2 = compareValueImpl(xmlObject);
                    }
                    return iCompareValueImpl2;
                }
                if (!xmlObject.isImmutable() && monitor() != xmlObject.monitor()) {
                    GlobalLock.acquire();
                    try {
                        try {
                            synchronized (monitor()) {
                                try {
                                    try {
                                        synchronized (xmlObject.monitor()) {
                                            try {
                                                GlobalLock.release();
                                                return compareValueImpl(xmlObject);
                                            } catch (Throwable th) {
                                                th = th;
                                                throw th;
                                            }
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    throw th;
                                }
                            }
                        } catch (Throwable th4) {
                            th = th4;
                        }
                    } catch (InterruptedException e) {
                        e = e;
                        throw new XmlRuntimeException(e);
                    } catch (Throwable th5) {
                        th = th5;
                        z = true;
                        if (z) {
                            GlobalLock.release();
                        }
                        throw th;
                    }
                }
                synchronized (monitor()) {
                    iCompareValueImpl = compareValueImpl(xmlObject);
                }
                return iCompareValueImpl;
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (InterruptedException e2) {
            e = e2;
        }
    }

    public int compare_to(XmlObject xmlObject) {
        return equal_to(xmlObject) ? 0 : 2;
    }

    public abstract String compute_text(NamespaceManager namespaceManager);

    @Override // org.apache.xmlbeans.XmlObject
    public final XmlObject copy() {
        XmlObject xmlObject_copy;
        if (preCheck()) {
            return _copy();
        }
        synchronized (monitor()) {
            xmlObject_copy = _copy();
        }
        return xmlObject_copy;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public TypeStoreUser create_attribute_user(QName qName) {
        return (TypeStoreUser) ((SchemaTypeImpl) schemaType()).createAttributeType(qName, get_store().get_schematypeloader());
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public TypeStoreUser create_element_user(QName qName, QName qName2) {
        return (TypeStoreUser) ((SchemaTypeImpl) schemaType()).createElementType(qName, qName2, get_store().get_schematypeloader());
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public Date dateValue() {
        return getDateValue();
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public void disconnect_store() {
        if (!$assertionsDisabled && (this._flags & 16) == 0) {
            throw new AssertionError();
        }
        this._flags |= 2720;
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public XmlDocumentProperties documentProperties() {
        XmlCursor xmlCursorNewCursorForce = newCursorForce();
        try {
            return xmlCursorNewCursorForce.documentProperties();
        } finally {
            xmlCursorNewCursorForce.dispose();
        }
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public double doubleValue() {
        return getDoubleValue();
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void dump() {
        XmlCursor xmlCursorNewCursorForce = newCursorForce();
        try {
            xmlCursorNewCursorForce.dump();
        } finally {
            xmlCursorNewCursorForce.dispose();
        }
    }

    public int elementFlags() {
        check_element_dated();
        return this._flags & 7;
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public StringEnumAbstractBase enumValue() {
        return getEnumValue();
    }

    public abstract boolean equal_to(XmlObject xmlObject);

    public final boolean equals(Object obj) {
        if (!isImmutable()) {
            return super.equals(obj);
        }
        if (!(obj instanceof XmlObject)) {
            return false;
        }
        XmlObject xmlObject = (XmlObject) obj;
        if (xmlObject.isImmutable()) {
            return valueEquals(xmlObject);
        }
        return false;
    }

    @Override // org.apache.xmlbeans.XmlObject
    public XmlObject[] execQuery(String str) {
        return execQuery(str, null);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public float floatValue() {
        return getFloatValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public GDate gDateValue() {
        return getGDateValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public GDuration gDurationValue() {
        return getGDurationValue();
    }

    public final XmlObject generatedSetterHelperImpl(XmlObject xmlObject, QName qName, int i, short s) throws Throwable {
        XmlObject xmlObject2;
        XmlObject xmlObject3;
        XmlObject xmlObject4;
        XmlObjectBase targetForSetter;
        XmlObjectBase targetForSetter2;
        XmlObjectBase xmlObjectBaseUnderlying = underlying(xmlObject);
        if (xmlObjectBaseUnderlying == null) {
            synchronized (monitor()) {
                targetForSetter2 = getTargetForSetter(qName, i, s);
                targetForSetter2.setNil();
            }
            return targetForSetter2;
        }
        if (xmlObjectBaseUnderlying.isImmutable()) {
            synchronized (monitor()) {
                targetForSetter = getTargetForSetter(qName, i, s);
                targetForSetter.setStringValue(xmlObjectBaseUnderlying.getStringValue());
            }
            return targetForSetter;
        }
        boolean zPreCheck = preCheck();
        boolean zPreCheck2 = xmlObjectBaseUnderlying.preCheck();
        if (monitor() == xmlObjectBaseUnderlying.monitor()) {
            if (zPreCheck) {
                return (XmlObject) objSetterHelper(xmlObjectBaseUnderlying, qName, i, s);
            }
            synchronized (monitor()) {
                xmlObject4 = (XmlObject) objSetterHelper(xmlObjectBaseUnderlying, qName, i, s);
            }
            return xmlObject4;
        }
        if (zPreCheck) {
            if (zPreCheck2) {
                return (XmlObject) objSetterHelper(xmlObjectBaseUnderlying, qName, i, s);
            }
            synchronized (xmlObjectBaseUnderlying.monitor()) {
                xmlObject3 = (XmlObject) objSetterHelper(xmlObjectBaseUnderlying, qName, i, s);
            }
            return xmlObject3;
        }
        if (zPreCheck2) {
            synchronized (monitor()) {
                xmlObject2 = (XmlObject) objSetterHelper(xmlObjectBaseUnderlying, qName, i, s);
            }
            return xmlObject2;
        }
        boolean z = false;
        try {
            try {
                GlobalLock.acquire();
            } catch (Throwable th) {
                th = th;
            }
        } catch (InterruptedException e) {
            e = e;
        }
        try {
            try {
                synchronized (monitor()) {
                    try {
                        try {
                            synchronized (xmlObjectBaseUnderlying.monitor()) {
                                try {
                                    GlobalLock.release();
                                    return (XmlObject) objSetterHelper(xmlObjectBaseUnderlying, qName, i, s);
                                } catch (Throwable th2) {
                                    th = th2;
                                    throw th;
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        throw th;
                    }
                }
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (InterruptedException e2) {
            e = e2;
            throw new XmlRuntimeException(e);
        } catch (Throwable th6) {
            th = th6;
            z = true;
            if (z) {
                GlobalLock.release();
            }
            throw th;
        }
    }

    public BigDecimal getBigDecimalValue() {
        throw new XmlValueNotSupportedException(XmlErrorCodes.EXCEPTION_VALUE_NOT_SUPPORTED_S2J, new Object[]{getPrimitiveTypeName(), "numeric"});
    }

    public BigInteger getBigIntegerValue() {
        BigDecimal bigDecimalBigDecimalValue = bigDecimalValue();
        if (bigDecimalBigDecimalValue == null) {
            return null;
        }
        return bigDecimalBigDecimalValue.toBigInteger();
    }

    public boolean getBooleanValue() {
        throw new XmlValueNotSupportedException(XmlErrorCodes.EXCEPTION_VALUE_NOT_SUPPORTED_S2J, new Object[]{getPrimitiveTypeName(), "boolean"});
    }

    public byte[] getByteArrayValue() {
        throw new XmlValueNotSupportedException(XmlErrorCodes.EXCEPTION_VALUE_NOT_SUPPORTED_S2J, new Object[]{getPrimitiveTypeName(), "byte[]"});
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public byte getByteValue() {
        long intValue = getIntValue();
        if (intValue > 127) {
            throw new XmlValueOutOfRangeException();
        }
        if (intValue >= -128) {
            return (byte) intValue;
        }
        throw new XmlValueOutOfRangeException();
    }

    public Calendar getCalendarValue() {
        throw new XmlValueNotSupportedException(XmlErrorCodes.EXCEPTION_VALUE_NOT_SUPPORTED_S2J, new Object[]{getPrimitiveTypeName(), "Calendar"});
    }

    public Date getDateValue() {
        throw new XmlValueNotSupportedException(XmlErrorCodes.EXCEPTION_VALUE_NOT_SUPPORTED_S2J, new Object[]{getPrimitiveTypeName(), "Date"});
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public Node getDomNode() {
        XmlCursor xmlCursorNewCursorForce = newCursorForce();
        try {
            return xmlCursorNewCursorForce.getDomNode();
        } finally {
            xmlCursorNewCursorForce.dispose();
        }
    }

    public double getDoubleValue() {
        BigDecimal bigDecimalValue = getBigDecimalValue();
        if (bigDecimalValue == null) {
            return 0.0d;
        }
        return bigDecimalValue.doubleValue();
    }

    public StringEnumAbstractBase getEnumValue() {
        throw new XmlValueNotSupportedException(XmlErrorCodes.EXCEPTION_VALUE_NOT_SUPPORTED_S2J, new Object[]{getPrimitiveTypeName(), "enum"});
    }

    public float getFloatValue() {
        BigDecimal bigDecimalValue = getBigDecimalValue();
        if (bigDecimalValue == null) {
            return 0.0f;
        }
        return bigDecimalValue.floatValue();
    }

    public GDate getGDateValue() {
        throw new XmlValueNotSupportedException(XmlErrorCodes.EXCEPTION_VALUE_NOT_SUPPORTED_S2J, new Object[]{getPrimitiveTypeName(), "Date"});
    }

    public GDuration getGDurationValue() {
        throw new XmlValueNotSupportedException(XmlErrorCodes.EXCEPTION_VALUE_NOT_SUPPORTED_S2J, new Object[]{getPrimitiveTypeName(), "Duration"});
    }

    public int getIntValue() {
        long longValue = getLongValue();
        if (longValue > 2147483647L) {
            throw new XmlValueOutOfRangeException();
        }
        if (longValue >= -2147483648L) {
            return (int) longValue;
        }
        throw new XmlValueOutOfRangeException();
    }

    public List getListValue() {
        throw new XmlValueNotSupportedException(XmlErrorCodes.EXCEPTION_VALUE_NOT_SUPPORTED_S2J, new Object[]{getPrimitiveTypeName(), "List"});
    }

    public long getLongValue() {
        BigInteger bigIntegerValue = getBigIntegerValue();
        if (bigIntegerValue == null) {
            return 0L;
        }
        if (bigIntegerValue.compareTo(_max) >= 0) {
            throw new XmlValueOutOfRangeException();
        }
        if (bigIntegerValue.compareTo(_min) > 0) {
            return bigIntegerValue.longValue();
        }
        throw new XmlValueOutOfRangeException();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public Object getObjectValue() {
        return java_value(this);
    }

    public QName getQNameValue() {
        throw new XmlValueNotSupportedException(XmlErrorCodes.EXCEPTION_VALUE_NOT_SUPPORTED_S2J, new Object[]{getPrimitiveTypeName(), XmlErrorCodes.QNAME});
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public short getShortValue() {
        long intValue = getIntValue();
        if (intValue > 32767) {
            throw new XmlValueOutOfRangeException();
        }
        if (intValue >= -32768) {
            return (short) intValue;
        }
        throw new XmlValueOutOfRangeException();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public String getStringValue() {
        if (isImmutable()) {
            if ((this._flags & 64) != 0) {
                return null;
            }
            return compute_text(null);
        }
        synchronized (monitor()) {
            try {
                if (_isComplexContent()) {
                    return get_store().fetch_text(1);
                }
                check_dated();
                if ((this._flags & 64) != 0) {
                    return null;
                }
                return compute_text(has_store() ? get_store() : null);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final XmlLocale getXmlLocale() {
        return get_store().get_locale();
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public SchemaField get_attribute_field(QName qName) {
        SchemaAttributeModel attributeModel = schemaType().getAttributeModel();
        if (attributeModel == null) {
            return null;
        }
        return attributeModel.getAttribute(qName);
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public SchemaType get_attribute_type(QName qName) {
        return schemaType().getAttributeType(qName, get_store().get_schematypeloader());
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public int get_attributeflags(QName qName) {
        SchemaProperty attributeProperty;
        if (_isComplexType() && (attributeProperty = schemaType().getAttributeProperty(qName)) != null) {
            return (attributeProperty.hasDefault() == 0 ? 0 : 2) | (attributeProperty.hasFixed() != 0 ? 4 : 0);
        }
        return 0;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public String get_default_attribute_text(QName qName) {
        if (!$assertionsDisabled && !_isComplexType()) {
            throw new AssertionError();
        }
        if (!_isComplexType()) {
            throw new IllegalStateException();
        }
        SchemaProperty attributeProperty = schemaType().getAttributeProperty(qName);
        return attributeProperty == null ? "" : attributeProperty.getDefaultText();
    }

    public XmlAnySimpleType get_default_attribute_value(QName qName) {
        SchemaLocalAttribute attribute;
        SchemaAttributeModel attributeModel = schemaType().getAttributeModel();
        if (attributeModel == null || (attribute = attributeModel.getAttribute(qName)) == null) {
            return null;
        }
        return attribute.getDefaultValue();
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public String get_default_element_text(QName qName) {
        if (!$assertionsDisabled && !_isComplexContent()) {
            throw new AssertionError();
        }
        if (!_isComplexContent()) {
            throw new IllegalStateException();
        }
        SchemaProperty elementProperty = schemaType().getElementProperty(qName);
        return elementProperty == null ? "" : elementProperty.getDefaultText();
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public final QNameSet get_element_ending_delimiters(QName qName) {
        SchemaProperty elementProperty = schemaType().getElementProperty(qName);
        if (elementProperty == null) {
            return null;
        }
        return elementProperty.getJavaSetterDelimiter();
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public SchemaType get_element_type(QName qName, QName qName2) {
        return schemaType().getElementType(qName, qName2, get_store().get_schematypeloader());
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public int get_elementflags(QName qName) {
        SchemaProperty elementProperty;
        if (!_isComplexContent() || (elementProperty = schemaType().getElementProperty(qName)) == null) {
            return 0;
        }
        if (elementProperty.hasDefault() == 1 || elementProperty.hasFixed() == 1 || elementProperty.hasNillable() == 1) {
            return -1;
        }
        return (elementProperty.hasDefault() == 0 ? 0 : 2) | (elementProperty.hasFixed() == 0 ? 0 : 4) | (elementProperty.hasNillable() != 0 ? 1 : 0);
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public SchemaType get_schema_type() {
        return schemaType();
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public final TypeStore get_store() {
        if ($assertionsDisabled || (this._flags & 16) != 0) {
            return (TypeStore) this._textsource;
        }
        throw new AssertionError();
    }

    public int get_wscanon_rule() {
        return 3;
    }

    public final String get_wscanon_text() {
        return (this._flags & 16) == 0 ? apply_wscanon((String) this._textsource) : get_store().fetch_text(get_wscanon_rule());
    }

    public final boolean has_store() {
        return (this._flags & 16) != 0;
    }

    public final int hashCode() {
        if (!isImmutable()) {
            return super.hashCode();
        }
        synchronized (monitor()) {
            try {
                if (isNil()) {
                    return 0;
                }
                return value_hash_code();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void initComplexType(boolean z, boolean z2) {
        this._flags = (z ? 8192 : 0) | (z2 ? 16384 : 0) | this._flags;
    }

    public void init_flags(SchemaProperty schemaProperty) {
        if (schemaProperty == null) {
            return;
        }
        if (schemaProperty.hasDefault() == 1 || schemaProperty.hasFixed() == 1 || schemaProperty.hasNillable() == 1) {
            return;
        }
        int i = this._flags & (-8);
        this._flags = i;
        this._flags = (schemaProperty.hasDefault() == 0 ? 0 : 2) | (schemaProperty.hasFixed() == 0 ? 0 : 4) | (schemaProperty.hasNillable() == 0 ? 0 : 1) | 32768 | i;
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public SchemaType instanceType() {
        SchemaType schemaType;
        synchronized (monitor()) {
            schemaType = isNil() ? null : schemaType();
        }
        return schemaType;
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public int intValue() {
        return getIntValue();
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public final void invalidate_element_order() {
        if (!$assertionsDisabled && (this._flags & 16) == 0) {
            throw new AssertionError();
        }
        this._flags |= FLAGS_DATED;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public final void invalidate_nilvalue() {
        if (!$assertionsDisabled && (this._flags & 16) == 0) {
            throw new AssertionError();
        }
        this._flags |= 160;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public final void invalidate_value() {
        if (!$assertionsDisabled && (this._flags & 16) == 0) {
            throw new AssertionError();
        }
        this._flags |= 32;
    }

    public final boolean isDefault() {
        check_dated();
        return (this._flags & 256) != 0;
    }

    public final boolean isDefaultable() {
        check_element_dated();
        return (this._flags & 2) != 0;
    }

    public final boolean isFixed() {
        check_element_dated();
        return (this._flags & 4) != 0;
    }

    @Override // org.apache.xmlbeans.XmlObject
    public boolean isImmutable() {
        return (this._flags & 4096) != 0;
    }

    public boolean isInstanceOf(SchemaType schemaType) {
        if (schemaType.getSimpleVariety() != 2) {
            for (SchemaType schemaTypeInstanceType = instanceType(); schemaTypeInstanceType != null; schemaTypeInstanceType = schemaTypeInstanceType.getBaseType()) {
                if (schemaType == schemaTypeInstanceType) {
                    return true;
                }
            }
            return false;
        }
        HashSet hashSet = new HashSet(Arrays.asList(schemaType.getUnionConstituentTypes()));
        for (SchemaType schemaTypeInstanceType2 = instanceType(); schemaTypeInstanceType2 != null; schemaTypeInstanceType2 = schemaTypeInstanceType2.getBaseType()) {
            if (hashSet.contains(schemaTypeInstanceType2)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.apache.xmlbeans.XmlObject
    public final boolean isNil() {
        boolean z;
        synchronized (monitor()) {
            check_dated();
            z = (this._flags & 64) != 0;
        }
        return z;
    }

    public final boolean isNillable() {
        check_element_dated();
        return (this._flags & 1) != 0;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public boolean is_child_element_order_sensitive() {
        if (_isComplexType()) {
            return schemaType().isOrderSensitive();
        }
        return false;
    }

    public boolean is_defaultable_ws(String str) {
        return true;
    }

    public final boolean is_orphaned() {
        return (this._flags & 2048) != 0;
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public List listValue() {
        return getListValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public long longValue() {
        return getLongValue();
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public final Object monitor() {
        return has_store() ? get_store().get_locale() : this;
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public XmlCursor newCursor() {
        XmlCursor xmlCursorNew_cursor;
        if ((this._flags & 16) == 0) {
            throw new IllegalStateException("XML Value Objects cannot create cursors");
        }
        check_orphaned();
        XmlLocale xmlLocale = getXmlLocale();
        if (xmlLocale.noSync()) {
            xmlLocale.enter();
            try {
                return get_store().new_cursor();
            } finally {
            }
        }
        synchronized (xmlLocale) {
            try {
                xmlLocale.enter();
                try {
                    xmlCursorNew_cursor = get_store().new_cursor();
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return xmlCursorNew_cursor;
    }

    public XmlCursor newCursorForce() {
        XmlCursor xmlCursorNewCursor;
        synchronized (monitor()) {
            xmlCursorNewCursor = ensureStore().newCursor();
        }
        return xmlCursorNewCursor;
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public Node newDomNode() {
        return newDomNode(null);
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public InputStream newInputStream() {
        return newInputStream(null);
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public Reader newReader() {
        return newReader(null);
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public XMLInputStream newXMLInputStream() {
        return newXMLInputStream(null);
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public XMLStreamReader newXMLStreamReader() {
        return newXMLStreamReader(null);
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public TypeStoreVisitor new_visitor() {
        if (_isComplexContent()) {
            return new SchemaTypeVisitorImpl(schemaType().getContentModel());
        }
        return null;
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void objectSet(Object obj) {
        setObjectValue(obj);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public Object objectValue() {
        return getObjectValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public QName qNameValue() {
        return getQNameValue();
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void save(ContentHandler contentHandler, LexicalHandler lexicalHandler, XmlOptions xmlOptions) {
        XmlCursor xmlCursorNewCursorForce = newCursorForce();
        try {
            xmlCursorNewCursorForce.save(contentHandler, lexicalHandler, makeInnerOptions(xmlOptions));
        } finally {
            xmlCursorNewCursorForce.dispose();
        }
    }

    public abstract SchemaType schemaType();

    @Override // org.apache.xmlbeans.XmlObject
    public XmlObject selectAttribute(QName qName) {
        XmlCursor xmlCursorNewCursor = newCursor();
        try {
            if (!xmlCursorNewCursor.isContainer()) {
                return null;
            }
            if (xmlCursorNewCursor.toFirstAttribute()) {
                while (!xmlCursorNewCursor.getName().equals(qName)) {
                    if (!xmlCursorNewCursor.toNextAttribute()) {
                    }
                }
                return xmlCursorNewCursor.getObject();
            }
            return null;
        } finally {
            xmlCursorNewCursor.dispose();
        }
    }

    @Override // org.apache.xmlbeans.XmlObject
    public XmlObject[] selectAttributes(QNameSet qNameSet) {
        if (qNameSet == null) {
            throw new IllegalArgumentException();
        }
        XmlCursor xmlCursorNewCursor = newCursor();
        try {
            if (!xmlCursorNewCursor.isContainer()) {
                return EMPTY_RESULT;
            }
            ArrayList arrayList = new ArrayList();
            if (xmlCursorNewCursor.toFirstAttribute()) {
                do {
                    if (qNameSet.contains(xmlCursorNewCursor.getName())) {
                        arrayList.add(xmlCursorNewCursor.getObject());
                    }
                } while (xmlCursorNewCursor.toNextAttribute());
            }
            return arrayList.size() == 0 ? EMPTY_RESULT : (XmlObject[]) arrayList.toArray(EMPTY_RESULT);
        } finally {
            xmlCursorNewCursor.dispose();
        }
    }

    @Override // org.apache.xmlbeans.XmlObject
    public XmlObject[] selectChildren(QName qName) {
        XmlCursor xmlCursorNewCursor = newCursor();
        try {
            if (!xmlCursorNewCursor.isContainer()) {
                return EMPTY_RESULT;
            }
            ArrayList arrayList = new ArrayList();
            if (xmlCursorNewCursor.toChild(qName)) {
                do {
                    arrayList.add(xmlCursorNewCursor.getObject());
                } while (xmlCursorNewCursor.toNextSibling(qName));
            }
            return arrayList.size() == 0 ? EMPTY_RESULT : (XmlObject[]) arrayList.toArray(EMPTY_RESULT);
        } finally {
            xmlCursorNewCursor.dispose();
        }
    }

    @Override // org.apache.xmlbeans.XmlObject
    public XmlObject[] selectPath(String str) {
        return selectPath(str, null);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void set(String str) {
        setStringValue(str);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public final void setBigDecimalValue(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            setNil();
            return;
        }
        synchronized (monitor()) {
            set_prepare();
            set_BigDecimal(bigDecimal);
            set_commit();
        }
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public final void setBigIntegerValue(BigInteger bigInteger) {
        if (bigInteger == null) {
            setNil();
            return;
        }
        synchronized (monitor()) {
            set_prepare();
            set_BigInteger(bigInteger);
            set_commit();
        }
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public final void setBooleanValue(boolean z) {
        synchronized (monitor()) {
            set_prepare();
            set_boolean(z);
            set_commit();
        }
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public final void setByteArrayValue(byte[] bArr) {
        if (bArr == null) {
            setNil();
            return;
        }
        synchronized (monitor()) {
            set_prepare();
            set_ByteArray(bArr);
            set_commit();
        }
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public final void setByteValue(byte b) {
        synchronized (monitor()) {
            set_prepare();
            set_byte(b);
            set_commit();
        }
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public final void setCalendarValue(Calendar calendar) {
        if (calendar == null) {
            setNil();
            return;
        }
        synchronized (monitor()) {
            set_prepare();
            set_Calendar(calendar);
            set_commit();
        }
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public final void setDateValue(Date date) {
        if (date == null) {
            setNil();
            return;
        }
        synchronized (monitor()) {
            set_prepare();
            set_Date(date);
            set_commit();
        }
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public final void setDoubleValue(double d) {
        synchronized (monitor()) {
            set_prepare();
            set_double(d);
            set_commit();
        }
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public final void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase) {
        if (stringEnumAbstractBase == null) {
            setNil();
            return;
        }
        synchronized (monitor()) {
            set_prepare();
            set_enum(stringEnumAbstractBase);
            set_commit();
        }
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public final void setFloatValue(float f) {
        synchronized (monitor()) {
            set_prepare();
            set_float(f);
            set_commit();
        }
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public final void setGDateValue(GDate gDate) {
        if (gDate == null) {
            setNil();
            return;
        }
        synchronized (monitor()) {
            set_prepare();
            set_GDate(gDate);
            set_commit();
        }
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public final void setGDurationValue(GDuration gDuration) {
        if (gDuration == null) {
            setNil();
            return;
        }
        synchronized (monitor()) {
            set_prepare();
            set_GDuration(gDuration);
            set_commit();
        }
    }

    public void setImmutable() {
        int i = this._flags;
        if ((i & 4112) != 0) {
            throw new IllegalStateException();
        }
        this._flags = i | 4096;
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public final void setIntValue(int i) {
        synchronized (monitor()) {
            set_prepare();
            set_int(i);
            set_commit();
        }
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public final void setListValue(List list) {
        if (list == null) {
            setNil();
            return;
        }
        synchronized (monitor()) {
            set_prepare();
            set_list(list);
            set_commit();
        }
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public final void setLongValue(long j) {
        synchronized (monitor()) {
            set_prepare();
            set_long(j);
            set_commit();
        }
    }

    @Override // org.apache.xmlbeans.XmlObject
    public final void setNil() {
        synchronized (monitor()) {
            try {
                set_prepare();
                int i = this._flags;
                if ((i & 1) == 0 && (i & 65536) != 0) {
                    throw new XmlValueNotNillableException();
                }
                set_nil();
                int i2 = this._flags | 64;
                this._flags = i2;
                if ((i2 & 16) != 0) {
                    get_store().invalidate_text();
                    this._flags &= -673;
                    get_store().invalidate_nil();
                } else {
                    this._textsource = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void setObjectValue(Object obj) throws Throwable {
        if (obj == null) {
            setNil();
            return;
        }
        if (obj instanceof XmlObject) {
            set((XmlObject) obj);
            return;
        }
        if (obj instanceof String) {
            setStringValue((String) obj);
            return;
        }
        if (obj instanceof StringEnumAbstractBase) {
            setEnumValue((StringEnumAbstractBase) obj);
            return;
        }
        if (obj instanceof BigInteger) {
            setBigIntegerValue((BigInteger) obj);
            return;
        }
        if (obj instanceof BigDecimal) {
            setBigDecimalValue((BigDecimal) obj);
            return;
        }
        if (obj instanceof Byte) {
            setByteValue(((Byte) obj).byteValue());
            return;
        }
        if (obj instanceof Short) {
            setShortValue(((Short) obj).shortValue());
            return;
        }
        if (obj instanceof Integer) {
            setIntValue(((Integer) obj).intValue());
            return;
        }
        if (obj instanceof Long) {
            setLongValue(((Long) obj).longValue());
            return;
        }
        if (obj instanceof Boolean) {
            setBooleanValue(((Boolean) obj).booleanValue());
            return;
        }
        if (obj instanceof Float) {
            setFloatValue(((Float) obj).floatValue());
            return;
        }
        if (obj instanceof Double) {
            setDoubleValue(((Double) obj).doubleValue());
            return;
        }
        if (obj instanceof Calendar) {
            setCalendarValue((Calendar) obj);
            return;
        }
        if (obj instanceof Date) {
            setDateValue((Date) obj);
            return;
        }
        if (obj instanceof GDateSpecification) {
            setGDateValue((GDateSpecification) obj);
            return;
        }
        if (obj instanceof GDurationSpecification) {
            setGDurationValue((GDurationSpecification) obj);
            return;
        }
        if (obj instanceof QName) {
            setQNameValue((QName) obj);
        } else if (obj instanceof List) {
            setListValue((List) obj);
        } else {
            if (!(obj instanceof byte[])) {
                throw new XmlValueNotSupportedException("Can't set union object of class : ".concat(obj.getClass().getName()));
            }
            setByteArrayValue((byte[]) obj);
        }
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public final void setQNameValue(QName qName) {
        if (qName == null) {
            setNil();
            return;
        }
        synchronized (monitor()) {
            set_prepare();
            set_QName(qName);
            set_commit();
        }
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public final void setShortValue(short s) {
        synchronized (monitor()) {
            set_prepare();
            set_short(s);
            set_commit();
        }
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public final void setStringValue(String str) {
        if (str == null) {
            setNil();
            return;
        }
        synchronized (monitor()) {
            set_prepare();
            set_String(str);
        }
    }

    public void setValidateOnSet() {
        this._flags |= 65536;
    }

    public void set_BigDecimal(BigDecimal bigDecimal) {
        throw new XmlValueNotSupportedException(XmlErrorCodes.EXCEPTION_VALUE_NOT_SUPPORTED_J2S, new Object[]{"numeric", getPrimitiveTypeName()});
    }

    public void set_BigInteger(BigInteger bigInteger) {
        set_BigDecimal(new BigDecimal(bigInteger));
    }

    public void set_ByteArray(byte[] bArr) {
        throw new XmlValueNotSupportedException(XmlErrorCodes.EXCEPTION_VALUE_NOT_SUPPORTED_J2S, new Object[]{"byte[]", getPrimitiveTypeName()});
    }

    public void set_Calendar(Calendar calendar) {
        throw new XmlValueNotSupportedException(XmlErrorCodes.EXCEPTION_VALUE_NOT_SUPPORTED_J2S, new Object[]{"Calendar", getPrimitiveTypeName()});
    }

    public void set_ComplexXml(XmlObject xmlObject) {
        throw new XmlValueNotSupportedException(XmlErrorCodes.EXCEPTION_VALUE_NOT_SUPPORTED_J2S, new Object[]{"complex content", getPrimitiveTypeName()});
    }

    public void set_Date(Date date) {
        throw new XmlValueNotSupportedException(XmlErrorCodes.EXCEPTION_VALUE_NOT_SUPPORTED_J2S, new Object[]{"Date", getPrimitiveTypeName()});
    }

    public void set_GDate(GDateSpecification gDateSpecification) {
        throw new XmlValueNotSupportedException(XmlErrorCodes.EXCEPTION_VALUE_NOT_SUPPORTED_J2S, new Object[]{"Date", getPrimitiveTypeName()});
    }

    public void set_GDuration(GDurationSpecification gDurationSpecification) {
        throw new XmlValueNotSupportedException(XmlErrorCodes.EXCEPTION_VALUE_NOT_SUPPORTED_J2S, new Object[]{"Duration", getPrimitiveTypeName()});
    }

    public void set_QName(QName qName) {
        throw new XmlValueNotSupportedException(XmlErrorCodes.EXCEPTION_VALUE_NOT_SUPPORTED_J2S, new Object[]{XmlErrorCodes.QNAME, getPrimitiveTypeName()});
    }

    public void set_String(String str) {
        int i = this._flags;
        if ((i & 4096) != 0) {
            throw new IllegalStateException();
        }
        boolean z = (i & 64) != 0;
        update_from_wscanon_text(apply_wscanon(str));
        int i2 = this._flags;
        if ((i2 & 16) == 0) {
            this._textsource = str;
            return;
        }
        this._flags = i2 & (-33);
        if ((i2 & 1024) == 0) {
            get_store().store_text(str);
        }
        if (z) {
            get_store().invalidate_nil();
        }
    }

    public void set_b64(byte[] bArr) {
        set_ByteArray(bArr);
    }

    public void set_boolean(boolean z) {
        throw new XmlValueNotSupportedException(XmlErrorCodes.EXCEPTION_VALUE_NOT_SUPPORTED_J2S, new Object[]{"boolean", getPrimitiveTypeName()});
    }

    public void set_byte(byte b) {
        set_int(b);
    }

    public void set_char(char c) {
        set_String(Character.toString(c));
    }

    public void set_double(double d) {
        set_BigDecimal(new BigDecimal(d));
    }

    public void set_enum(StringEnumAbstractBase stringEnumAbstractBase) {
        throw new XmlValueNotSupportedException(XmlErrorCodes.EXCEPTION_VALUE_NOT_SUPPORTED_J2S, new Object[]{"enum", getPrimitiveTypeName()});
    }

    public void set_float(float f) {
        set_BigDecimal(new BigDecimal(f));
    }

    public void set_hex(byte[] bArr) {
        set_ByteArray(bArr);
    }

    public void set_int(int i) {
        set_long(i);
    }

    public void set_list(List list) {
        throw new XmlValueNotSupportedException(XmlErrorCodes.EXCEPTION_VALUE_NOT_SUPPORTED_J2S, new Object[]{"List", getPrimitiveTypeName()});
    }

    public void set_long(long j) {
        set_BigInteger(BigInteger.valueOf(j));
    }

    public final void set_newValue(XmlObject xmlObject) {
        if (xmlObject == null || xmlObject.isNil()) {
            setNil();
            return;
        }
        if (xmlObject instanceof XmlAnySimpleType) {
            XmlAnySimpleType xmlAnySimpleType = (XmlAnySimpleType) xmlObject;
            SchemaType schemaTypeInstanceType = ((SimpleValue) xmlAnySimpleType).instanceType();
            boolean z = $assertionsDisabled;
            if (!z && schemaTypeInstanceType == null) {
                throw new AssertionError("Nil case should have been handled already");
            }
            if (schemaTypeInstanceType.getSimpleVariety() != 3) {
                synchronized (monitor()) {
                    boolean z2 = true;
                    if (!z) {
                        try {
                            if (schemaTypeInstanceType.getSimpleVariety() != 1) {
                                throw new AssertionError();
                            }
                        } finally {
                        }
                    }
                    switch (schemaTypeInstanceType.getPrimitiveType().getBuiltinTypeCode()) {
                        case 2:
                            if (xmlAnySimpleType.isImmutable()) {
                                z2 = false;
                            } else {
                                NamespaceContext.push(new NamespaceContext(xmlAnySimpleType));
                            }
                            try {
                                set_prepare();
                                set_xmlanysimple(xmlAnySimpleType);
                                set_commit();
                                return;
                            } finally {
                                if (z2) {
                                    NamespaceContext.pop();
                                }
                            }
                        case 3:
                            boolean booleanValue = ((SimpleValue) xmlAnySimpleType).getBooleanValue();
                            set_prepare();
                            set_boolean(booleanValue);
                            set_commit();
                            return;
                        case 4:
                            byte[] byteArrayValue = ((SimpleValue) xmlAnySimpleType).getByteArrayValue();
                            set_prepare();
                            set_b64(byteArrayValue);
                            set_commit();
                            return;
                        case 5:
                            byte[] byteArrayValue2 = ((SimpleValue) xmlAnySimpleType).getByteArrayValue();
                            set_prepare();
                            set_hex(byteArrayValue2);
                            set_commit();
                            return;
                        case 6:
                            String stringValue = xmlAnySimpleType.getStringValue();
                            set_prepare();
                            set_text(stringValue);
                            set_commit();
                            return;
                        case 7:
                            QName qNameValue = ((SimpleValue) xmlAnySimpleType).getQNameValue();
                            set_prepare();
                            set_QName(qNameValue);
                            set_commit();
                            return;
                        case 8:
                            String stringValue2 = xmlAnySimpleType.getStringValue();
                            set_prepare();
                            set_notation(stringValue2);
                            set_commit();
                            return;
                        case 9:
                            float floatValue = ((SimpleValue) xmlAnySimpleType).getFloatValue();
                            set_prepare();
                            set_float(floatValue);
                            set_commit();
                            return;
                        case 10:
                            double doubleValue = ((SimpleValue) xmlAnySimpleType).getDoubleValue();
                            set_prepare();
                            set_double(doubleValue);
                            set_commit();
                            return;
                        case 11:
                            int decimalSize = schemaTypeInstanceType.getDecimalSize();
                            if (decimalSize == 8) {
                                byte byteValue = ((SimpleValue) xmlAnySimpleType).getByteValue();
                                set_prepare();
                                set_byte(byteValue);
                            } else if (decimalSize == 16) {
                                short shortValue = ((SimpleValue) xmlAnySimpleType).getShortValue();
                                set_prepare();
                                set_short(shortValue);
                            } else if (decimalSize == 32) {
                                int intValue = ((SimpleValue) xmlAnySimpleType).getIntValue();
                                set_prepare();
                                set_int(intValue);
                            } else if (decimalSize != 64) {
                                switch (decimalSize) {
                                    case 1000000:
                                        BigInteger bigIntegerValue = ((SimpleValue) xmlAnySimpleType).getBigIntegerValue();
                                        set_prepare();
                                        set_BigInteger(bigIntegerValue);
                                        break;
                                    default:
                                        if (!z) {
                                            throw new AssertionError("invalid numeric bit count");
                                        }
                                        break;
                                    case SchemaType.SIZE_BIG_DECIMAL /* 1000001 */:
                                        BigDecimal bigDecimalValue = ((SimpleValue) xmlAnySimpleType).getBigDecimalValue();
                                        set_prepare();
                                        set_BigDecimal(bigDecimalValue);
                                        break;
                                }
                            } else {
                                long longValue = ((SimpleValue) xmlAnySimpleType).getLongValue();
                                set_prepare();
                                set_long(longValue);
                            }
                            set_commit();
                            return;
                        case 12:
                            String stringValue3 = xmlAnySimpleType.getStringValue();
                            set_prepare();
                            set_String(stringValue3);
                            set_commit();
                            return;
                        case 13:
                            GDuration gDurationValue = ((SimpleValue) xmlAnySimpleType).getGDurationValue();
                            set_prepare();
                            set_GDuration(gDurationValue);
                            set_commit();
                            return;
                        case 14:
                        case 15:
                        case 16:
                        case 17:
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                            GDate gDateValue = ((SimpleValue) xmlAnySimpleType).getGDateValue();
                            set_prepare();
                            set_GDate(gDateValue);
                            set_commit();
                            return;
                        default:
                            if (!z) {
                                throw new AssertionError("encountered nonprimitive type.");
                            }
                            break;
                            break;
                    }
                }
            } else {
                synchronized (monitor()) {
                    set_prepare();
                    set_list(((SimpleValue) xmlAnySimpleType).xgetListValue());
                    set_commit();
                }
                return;
            }
        }
        throw new IllegalStateException("Complex type unexpected");
    }

    public abstract void set_nil();

    public void set_notation(String str) {
        throw new XmlValueNotSupportedException();
    }

    public void set_short(short s) {
        set_int(s);
    }

    public abstract void set_text(String str);

    public void set_xmlanysimple(XmlAnySimpleType xmlAnySimpleType) {
        set_String(xmlAnySimpleType.getStringValue());
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public short shortValue() {
        return getShortValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public String stringValue() {
        return getStringValue();
    }

    @Override // org.apache.xmlbeans.XmlObject
    public XmlObject substitute(QName qName, SchemaType schemaType) {
        XmlObject xmlObject;
        if (qName == null) {
            throw new IllegalArgumentException("Invalid name (null)");
        }
        if (schemaType == null) {
            throw new IllegalArgumentException("Invalid type (null)");
        }
        if ((this._flags & 16) == 0) {
            throw new IllegalStateException("XML Value Objects cannot be used with substitution");
        }
        synchronized (monitor()) {
            check_orphaned();
            xmlObject = (XmlObject) get_store().substitute(qName, schemaType);
        }
        return xmlObject;
    }

    @Override // org.apache.xmlbeans.XmlObject
    public final String toString() {
        String strXmlText;
        synchronized (monitor()) {
            strXmlText = ensureStore().xmlText(_toStringOptions);
        }
        return strXmlText;
    }

    public void update_from_complex_content() {
        throw new XmlValueNotSupportedException("Complex content");
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public final boolean uses_invalidate_value() {
        SchemaType schemaType = schemaType();
        return schemaType.isSimpleType() || schemaType.getContentType() == 2;
    }

    @Override // org.apache.xmlbeans.XmlObject
    public boolean validate() {
        return validate(null);
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public void validate_now() {
        check_dated();
    }

    @Override // org.apache.xmlbeans.XmlObject
    public final boolean valueEquals(XmlObject xmlObject) throws Throwable {
        boolean zValueEqualsImpl;
        boolean zValueEqualsImpl2;
        boolean z = false;
        try {
            try {
                if (isImmutable()) {
                    if (xmlObject.isImmutable()) {
                        return valueEqualsImpl(xmlObject);
                    }
                    synchronized (xmlObject.monitor()) {
                        zValueEqualsImpl2 = valueEqualsImpl(xmlObject);
                    }
                    return zValueEqualsImpl2;
                }
                if (!xmlObject.isImmutable() && monitor() != xmlObject.monitor()) {
                    GlobalLock.acquire();
                    try {
                        try {
                            synchronized (monitor()) {
                                try {
                                    try {
                                        synchronized (xmlObject.monitor()) {
                                            try {
                                                GlobalLock.release();
                                                return valueEqualsImpl(xmlObject);
                                            } catch (Throwable th) {
                                                th = th;
                                                throw th;
                                            }
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    throw th;
                                }
                            }
                        } catch (Throwable th4) {
                            th = th4;
                        }
                    } catch (InterruptedException e) {
                        e = e;
                        throw new XmlRuntimeException(e);
                    } catch (Throwable th5) {
                        th = th5;
                        z = true;
                        if (z) {
                            GlobalLock.release();
                        }
                        throw th;
                    }
                }
                synchronized (monitor()) {
                    zValueEqualsImpl = valueEqualsImpl(xmlObject);
                }
                return zValueEqualsImpl;
            } catch (InterruptedException e2) {
                e = e2;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    @Override // org.apache.xmlbeans.XmlObject
    public int valueHashCode() {
        int iValue_hash_code;
        synchronized (monitor()) {
            iValue_hash_code = value_hash_code();
        }
        return iValue_hash_code;
    }

    public abstract int value_hash_code();

    public Object writeReplace() {
        synchronized (monitor()) {
            try {
                if (isRootXmlObject()) {
                    return new SerializedRootObject(this);
                }
                return new SerializedInteriorObject(this, getRootXmlObject());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public List xgetListValue() {
        throw new XmlValueNotSupportedException(XmlErrorCodes.EXCEPTION_VALUE_NOT_SUPPORTED_S2J, new Object[]{getPrimitiveTypeName(), "List"});
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public List xlistValue() {
        return xgetListValue();
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public String xmlText() {
        return xmlText(null);
    }

    public final XmlObject _copy(XmlOptions xmlOptions) {
        if (isImmutable()) {
            return this;
        }
        check_orphaned();
        return (XmlObject) get_store().copy(get_store().get_schematypeloader(), schemaType(), xmlOptions);
    }

    @Override // org.apache.xmlbeans.XmlObject
    public XmlObject[] execQuery(String str, XmlOptions xmlOptions) {
        XmlObject[] xmlObjectArr_typedArray;
        synchronized (monitor()) {
            try {
                TypeStore typeStore = get_store();
                if (typeStore == null) {
                    throw new XmlRuntimeException("Cannot do XQuery on XML Value Objects");
                }
                try {
                    xmlObjectArr_typedArray = _typedArray(typeStore.exec_query(str, xmlOptions));
                } catch (XmlException e) {
                    throw new XmlRuntimeException(e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return xmlObjectArr_typedArray;
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public Node newDomNode(XmlOptions xmlOptions) {
        XmlCursor xmlCursorNewCursorForce = newCursorForce();
        try {
            return xmlCursorNewCursorForce.newDomNode(makeInnerOptions(xmlOptions));
        } finally {
            xmlCursorNewCursorForce.dispose();
        }
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public InputStream newInputStream(XmlOptions xmlOptions) {
        XmlCursor xmlCursorNewCursorForce = newCursorForce();
        try {
            return xmlCursorNewCursorForce.newInputStream(makeInnerOptions(xmlOptions));
        } finally {
            xmlCursorNewCursorForce.dispose();
        }
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public Reader newReader(XmlOptions xmlOptions) {
        XmlCursor xmlCursorNewCursorForce = newCursorForce();
        try {
            return xmlCursorNewCursorForce.newReader(makeInnerOptions(xmlOptions));
        } finally {
            xmlCursorNewCursorForce.dispose();
        }
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public XMLInputStream newXMLInputStream(XmlOptions xmlOptions) {
        XmlCursor xmlCursorNewCursorForce = newCursorForce();
        try {
            return xmlCursorNewCursorForce.newXMLInputStream(makeInnerOptions(xmlOptions));
        } finally {
            xmlCursorNewCursorForce.dispose();
        }
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public XMLStreamReader newXMLStreamReader(XmlOptions xmlOptions) {
        XmlCursor xmlCursorNewCursorForce = newCursorForce();
        try {
            return xmlCursorNewCursorForce.newXMLStreamReader(makeInnerOptions(xmlOptions));
        } finally {
            xmlCursorNewCursorForce.dispose();
        }
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void save(File file, XmlOptions xmlOptions) {
        XmlCursor xmlCursorNewCursorForce = newCursorForce();
        try {
            xmlCursorNewCursorForce.save(file, makeInnerOptions(xmlOptions));
        } finally {
            xmlCursorNewCursorForce.dispose();
        }
    }

    @Override // org.apache.xmlbeans.XmlObject
    public XmlObject[] selectPath(String str, XmlOptions xmlOptions) {
        XmlObject[] xmlObjectArr;
        XmlCursor xmlCursorNewCursor = newCursor();
        if (xmlCursorNewCursor == null) {
            throw new XmlValueDisconnectedException();
        }
        try {
            xmlCursorNewCursor.selectPath(str, xmlOptions);
            if (xmlCursorNewCursor.hasNextSelection()) {
                xmlObjectArr = new XmlObject[xmlCursorNewCursor.getSelectionCount()];
                int i = 0;
                while (xmlCursorNewCursor.toNextSelection()) {
                    XmlObject object = xmlCursorNewCursor.getObject();
                    xmlObjectArr[i] = object;
                    if (object == null) {
                        if (xmlCursorNewCursor.toParent()) {
                            XmlObject object2 = xmlCursorNewCursor.getObject();
                            xmlObjectArr[i] = object2;
                            if (object2 != null) {
                            }
                        }
                        throw new XmlRuntimeException("Path must select only elements and attributes");
                    }
                    i++;
                }
            } else {
                xmlObjectArr = EMPTY_RESULT;
            }
            xmlCursorNewCursor.dispose();
            return _typedArray(xmlObjectArr);
        } catch (Throwable th) {
            xmlCursorNewCursor.dispose();
            throw th;
        }
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void set(boolean z) {
        setBooleanValue(z);
    }

    public final void setGDateValue(GDateSpecification gDateSpecification) {
        if (gDateSpecification == null) {
            setNil();
            return;
        }
        synchronized (monitor()) {
            set_prepare();
            set_GDate(gDateSpecification);
            set_commit();
        }
    }

    public final void setGDurationValue(GDurationSpecification gDurationSpecification) {
        if (gDurationSpecification == null) {
            setNil();
            return;
        }
        synchronized (monitor()) {
            set_prepare();
            set_GDuration(gDurationSpecification);
            set_commit();
        }
    }

    @Override // org.apache.xmlbeans.XmlObject
    public boolean validate(XmlOptions xmlOptions) {
        boolean zIsValid;
        int i = this._flags;
        if ((i & 16) == 0) {
            if ((i & 4096) != 0) {
                return validate_immutable(xmlOptions);
            }
            throw new IllegalStateException("XML objects with no underlying store cannot be validated");
        }
        synchronized (monitor()) {
            try {
                if ((this._flags & 2048) != 0) {
                    throw new XmlValueDisconnectedException();
                }
                SchemaField schemaField = schemaField();
                SchemaType schemaType = schemaType();
                TypeStore typeStore = get_store();
                Validator validator = new Validator(schemaType, schemaField, typeStore.get_schematypeloader(), xmlOptions, (Collection) null);
                typeStore.validate(validator);
                zIsValid = validator.isValid();
            } catch (Throwable th) {
                throw th;
            }
        }
        return zIsValid;
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public String xmlText(XmlOptions xmlOptions) {
        XmlCursor xmlCursorNewCursorForce = newCursorForce();
        try {
            return xmlCursorNewCursorForce.xmlText(makeInnerOptions(xmlOptions));
        } finally {
            xmlCursorNewCursorForce.dispose();
        }
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void save(OutputStream outputStream, XmlOptions xmlOptions) {
        XmlCursor xmlCursorNewCursorForce = newCursorForce();
        try {
            xmlCursorNewCursorForce.save(outputStream, makeInnerOptions(xmlOptions));
        } finally {
            xmlCursorNewCursorForce.dispose();
        }
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void set(byte b) {
        setByteValue(b);
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void save(Writer writer, XmlOptions xmlOptions) {
        XmlCursor xmlCursorNewCursorForce = newCursorForce();
        try {
            xmlCursorNewCursorForce.save(writer, makeInnerOptions(xmlOptions));
        } finally {
            xmlCursorNewCursorForce.dispose();
        }
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void set(short s) {
        setShortValue(s);
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void save(ContentHandler contentHandler, LexicalHandler lexicalHandler) {
        save(contentHandler, lexicalHandler, null);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void set(int i) {
        setIntValue(i);
    }

    @Override // org.apache.xmlbeans.XmlObject
    public final XmlObject copy(XmlOptions xmlOptions) {
        XmlObject xmlObject_copy;
        if (preCheck()) {
            return _copy(xmlOptions);
        }
        synchronized (monitor()) {
            xmlObject_copy = _copy(xmlOptions);
        }
        return xmlObject_copy;
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void save(File file) {
        save(file, (XmlOptions) null);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void set(long j) {
        setLongValue(j);
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void save(OutputStream outputStream) {
        save(outputStream, (XmlOptions) null);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void set(BigInteger bigInteger) {
        setBigIntegerValue(bigInteger);
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void save(Writer writer) {
        save(writer, (XmlOptions) null);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void set(BigDecimal bigDecimal) {
        setBigDecimalValue(bigDecimal);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void set(float f) {
        setFloatValue(f);
    }

    @Override // org.apache.xmlbeans.XmlObject
    public XmlObject selectAttribute(String str, String str2) {
        return selectAttribute(new QName(str, str2));
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void set(double d) {
        setDoubleValue(d);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void set(byte[] bArr) {
        setByteArrayValue(bArr);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void set(StringEnumAbstractBase stringEnumAbstractBase) {
        setEnumValue(stringEnumAbstractBase);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void set(Calendar calendar) {
        setCalendarValue(calendar);
    }

    @Override // org.apache.xmlbeans.XmlObject
    public XmlObject[] selectChildren(String str, String str2) {
        return selectChildren(new QName(str, str2));
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void set(Date date) {
        setDateValue(date);
    }

    @Override // org.apache.xmlbeans.XmlObject
    public XmlObject[] selectChildren(QNameSet qNameSet) {
        if (qNameSet != null) {
            XmlCursor xmlCursorNewCursor = newCursor();
            try {
                if (!xmlCursorNewCursor.isContainer()) {
                    return EMPTY_RESULT;
                }
                ArrayList arrayList = new ArrayList();
                if (xmlCursorNewCursor.toFirstChild()) {
                    do {
                        if (!$assertionsDisabled && !xmlCursorNewCursor.isContainer()) {
                            throw new AssertionError();
                        }
                        if (qNameSet.contains(xmlCursorNewCursor.getName())) {
                            arrayList.add(xmlCursorNewCursor.getObject());
                        }
                    } while (xmlCursorNewCursor.toNextSibling());
                }
                if (arrayList.size() == 0) {
                    return EMPTY_RESULT;
                }
                return (XmlObject[]) arrayList.toArray(EMPTY_RESULT);
            } finally {
                xmlCursorNewCursor.dispose();
            }
        }
        throw new IllegalArgumentException();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void set(GDateSpecification gDateSpecification) {
        setGDateValue(gDateSpecification);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void set(GDurationSpecification gDurationSpecification) {
        setGDurationValue(gDurationSpecification);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void set(QName qName) {
        setQNameValue(qName);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void set(List list) {
        setListValue(list);
    }

    @Override // org.apache.xmlbeans.XmlObject
    public final XmlObject set(XmlObject xmlObject) throws Throwable {
        TypeStoreUser typeStoreUser;
        if (!isImmutable()) {
            XmlObjectBase xmlObjectBaseUnderlying = underlying(xmlObject);
            if (xmlObjectBaseUnderlying == null) {
                setNil();
                return this;
            }
            if (xmlObjectBaseUnderlying.isImmutable()) {
                setStringValue(xmlObjectBaseUnderlying.getStringValue());
                typeStoreUser = this;
            } else {
                boolean zPreCheck = preCheck();
                boolean zPreCheck2 = xmlObjectBaseUnderlying.preCheck();
                if (monitor() == xmlObjectBaseUnderlying.monitor()) {
                    if (zPreCheck) {
                        typeStoreUser = setterHelper(xmlObjectBaseUnderlying);
                    } else {
                        synchronized (monitor()) {
                            typeStoreUser = setterHelper(xmlObjectBaseUnderlying);
                        }
                    }
                } else if (zPreCheck) {
                    if (zPreCheck2) {
                        typeStoreUser = setterHelper(xmlObjectBaseUnderlying);
                    } else {
                        synchronized (xmlObjectBaseUnderlying.monitor()) {
                            typeStoreUser = setterHelper(xmlObjectBaseUnderlying);
                        }
                    }
                } else if (zPreCheck2) {
                    synchronized (monitor()) {
                        typeStoreUser = setterHelper(xmlObjectBaseUnderlying);
                    }
                } else {
                    boolean z = false;
                    try {
                        try {
                            GlobalLock.acquire();
                        } catch (InterruptedException e) {
                            e = e;
                        }
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        try {
                            synchronized (monitor()) {
                                try {
                                    try {
                                        synchronized (xmlObjectBaseUnderlying.monitor()) {
                                            try {
                                                GlobalLock.release();
                                                typeStoreUser = setterHelper(xmlObjectBaseUnderlying);
                                            } catch (Throwable th2) {
                                                th = th2;
                                                throw th;
                                            }
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
                                    z = true;
                                    throw th;
                                }
                            }
                        } catch (Throwable th5) {
                            th = th5;
                        }
                    } catch (InterruptedException e2) {
                        e = e2;
                        z = true;
                        throw new XmlRuntimeException(e);
                    } catch (Throwable th6) {
                        th = th6;
                        z = true;
                        if (z) {
                            GlobalLock.release();
                        }
                        throw th;
                    }
                }
            }
            return (XmlObject) typeStoreUser;
        }
        throw new IllegalStateException("Cannot set the value of an immutable XmlObject");
    }

    public void validate_simpleval(String str, ValidationContext validationContext) {
    }
}
