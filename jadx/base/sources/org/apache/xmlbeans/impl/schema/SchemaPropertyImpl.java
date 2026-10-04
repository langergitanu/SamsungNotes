package org.apache.xmlbeans.impl.schema;

import java.math.BigInteger;
import java.util.Set;
import kotlin.collections.AbstractC12991c;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.SchemaProperty;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class SchemaPropertyImpl implements SchemaProperty {
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$schema$SchemaPropertyImpl;
    private Set _acceptedNames;
    private SchemaType.Ref _containerTypeRef;
    private String _defaultText;
    private XmlValueRef _defaultValue;
    private boolean _extendsArray;
    private boolean _extendsOption;
    private boolean _extendsSingleton;
    private int _hasDefault;
    private int _hasFixed;
    private int _hasNillable;
    private boolean _isAttribute;
    private boolean _isImmutable;
    private SchemaType.Ref _javaBasedOnTypeRef;
    private String _javaPropertyName;
    private QNameSet _javaSetterDelimiter;
    private int _javaTypeCode;
    private BigInteger _maxOccurs;
    private BigInteger _minOccurs;
    private QName _name;
    private SchemaType.Ref _typeref;

    static {
        if (class$org$apache$xmlbeans$impl$schema$SchemaPropertyImpl == null) {
            class$org$apache$xmlbeans$impl$schema$SchemaPropertyImpl = class$("org.apache.xmlbeans.impl.schema.SchemaPropertyImpl");
        }
        $assertionsDisabled = true;
    }

    public static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw AbstractC12991c.m13994o(e);
        }
    }

    private void mutate() {
        if (this._isImmutable) {
            throw new IllegalStateException();
        }
    }

    @Override // org.apache.xmlbeans.SchemaProperty
    public QName[] acceptedNames() {
        Set set = this._acceptedNames;
        return set == null ? new QName[]{this._name} : (QName[]) set.toArray(new QName[set.size()]);
    }

    @Override // org.apache.xmlbeans.SchemaProperty
    public boolean extendsJavaArray() {
        return this._extendsArray;
    }

    @Override // org.apache.xmlbeans.SchemaProperty
    public boolean extendsJavaOption() {
        return this._extendsOption;
    }

    @Override // org.apache.xmlbeans.SchemaProperty
    public boolean extendsJavaSingleton() {
        return this._extendsSingleton;
    }

    @Override // org.apache.xmlbeans.SchemaProperty
    public SchemaType getContainerType() {
        return this._containerTypeRef.get();
    }

    @Override // org.apache.xmlbeans.SchemaProperty
    public String getDefaultText() {
        return this._defaultText;
    }

    @Override // org.apache.xmlbeans.SchemaProperty
    public XmlAnySimpleType getDefaultValue() {
        XmlValueRef xmlValueRef = this._defaultValue;
        if (xmlValueRef != null) {
            return xmlValueRef.get();
        }
        return null;
    }

    @Override // org.apache.xmlbeans.SchemaProperty
    public String getJavaPropertyName() {
        return this._javaPropertyName;
    }

    @Override // org.apache.xmlbeans.SchemaProperty
    public QNameSet getJavaSetterDelimiter() {
        if (this._isAttribute) {
            return QNameSet.EMPTY;
        }
        if (this._javaSetterDelimiter == null) {
            ((SchemaTypeImpl) getContainerType()).assignJavaElementSetterModel();
        }
        if ($assertionsDisabled || this._javaSetterDelimiter != null) {
            return this._javaSetterDelimiter;
        }
        throw new AssertionError();
    }

    @Override // org.apache.xmlbeans.SchemaProperty
    public int getJavaTypeCode() {
        return this._javaTypeCode;
    }

    @Override // org.apache.xmlbeans.SchemaProperty
    public BigInteger getMaxOccurs() {
        return this._maxOccurs;
    }

    @Override // org.apache.xmlbeans.SchemaProperty
    public BigInteger getMinOccurs() {
        return this._minOccurs;
    }

    @Override // org.apache.xmlbeans.SchemaProperty
    public QName getName() {
        return this._name;
    }

    @Override // org.apache.xmlbeans.SchemaProperty
    public SchemaType getType() {
        return this._typeref.get();
    }

    @Override // org.apache.xmlbeans.SchemaProperty
    public int hasDefault() {
        return this._hasDefault;
    }

    @Override // org.apache.xmlbeans.SchemaProperty
    public int hasFixed() {
        return this._hasFixed;
    }

    @Override // org.apache.xmlbeans.SchemaProperty
    public int hasNillable() {
        return this._hasNillable;
    }

    @Override // org.apache.xmlbeans.SchemaProperty
    public boolean isAttribute() {
        return this._isAttribute;
    }

    @Override // org.apache.xmlbeans.SchemaProperty
    public boolean isReadOnly() {
        return false;
    }

    @Override // org.apache.xmlbeans.SchemaProperty
    public SchemaType javaBasedOnType() {
        SchemaType.Ref ref = this._javaBasedOnTypeRef;
        if (ref == null) {
            return null;
        }
        return ref.get();
    }

    public void setAcceptedNames(Set set) {
        mutate();
        this._acceptedNames = set;
    }

    public void setAttribute(boolean z) {
        mutate();
        this._isAttribute = z;
    }

    public void setContainerTypeRef(SchemaType.Ref ref) {
        mutate();
        this._containerTypeRef = ref;
    }

    public void setDefault(int i) {
        mutate();
        this._hasDefault = i;
    }

    public void setDefaultText(String str) {
        mutate();
        this._defaultText = str;
    }

    public void setDefaultValue(XmlValueRef xmlValueRef) {
        mutate();
        this._defaultValue = xmlValueRef;
    }

    public void setExtendsJava(SchemaType.Ref ref, boolean z, boolean z2, boolean z3) {
        mutate();
        this._javaBasedOnTypeRef = ref;
        this._extendsSingleton = z;
        this._extendsOption = z2;
        this._extendsArray = z3;
    }

    public void setFixed(int i) {
        mutate();
        this._hasFixed = i;
    }

    public void setImmutable() {
        mutate();
        this._isImmutable = true;
    }

    public void setJavaPropertyName(String str) {
        mutate();
        this._javaPropertyName = str;
    }

    public void setJavaSetterDelimiter(QNameSet qNameSet) {
        this._javaSetterDelimiter = qNameSet;
    }

    public void setJavaTypeCode(int i) {
        mutate();
        this._javaTypeCode = i;
    }

    public void setMaxOccurs(BigInteger bigInteger) {
        mutate();
        this._maxOccurs = bigInteger;
    }

    public void setMinOccurs(BigInteger bigInteger) {
        mutate();
        this._minOccurs = bigInteger;
    }

    public void setName(QName qName) {
        mutate();
        this._name = qName;
    }

    public void setNillable(int i) {
        mutate();
        this._hasNillable = i;
    }

    public void setTypeRef(SchemaType.Ref ref) {
        mutate();
        this._typeref = ref;
    }

    public void setAcceptedNames(QNameSet qNameSet) {
        mutate();
        this._acceptedNames = qNameSet.includedQNamesInExcludedURIs();
    }
}
