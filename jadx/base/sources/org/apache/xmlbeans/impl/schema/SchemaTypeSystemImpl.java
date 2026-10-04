package org.apache.xmlbeans.impl.schema;

import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.remotefunction.RemoteConstant;
import io.netty.handler.codec.http2.Http2CodecUtil;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import kotlin.collections.AbstractC12991c;
import opennlp.tools.formats.brat.AnnotationConfiguration;
import org.apache.commons.lang3.SystemProperties;
import org.apache.poi.javax.xml.XMLConstants;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.xmlbeans.Filer;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.ResourceLoader;
import org.apache.xmlbeans.SchemaAnnotation;
import org.apache.xmlbeans.SchemaAttributeGroup;
import org.apache.xmlbeans.SchemaAttributeModel;
import org.apache.xmlbeans.SchemaComponent;
import org.apache.xmlbeans.SchemaGlobalAttribute;
import org.apache.xmlbeans.SchemaGlobalElement;
import org.apache.xmlbeans.SchemaIdentityConstraint;
import org.apache.xmlbeans.SchemaLocalAttribute;
import org.apache.xmlbeans.SchemaLocalElement;
import org.apache.xmlbeans.SchemaModelGroup;
import org.apache.xmlbeans.SchemaParticle;
import org.apache.xmlbeans.SchemaProperty;
import org.apache.xmlbeans.SchemaStringEnumEntry;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.SchemaTypeLoaderException;
import org.apache.xmlbeans.SchemaTypeSystem;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.common.NameUtil;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.XBeanDebug;
import org.apache.xmlbeans.impl.regex.RegularExpression;
import org.apache.xmlbeans.impl.schema.SchemaAnnotationImpl;
import org.apache.xmlbeans.impl.schema.StscComplexTypeResolver;
import org.apache.xmlbeans.impl.util.FilerImpl;
import org.apache.xmlbeans.impl.util.HexBin;
import org.apache.xmlbeans.impl.values.XmlObjectBase;
import org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroupDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.GroupDocument;
import org.apache.xmlbeans.soap.SOAPArrayType;
import org.apache.xmlbeans.soap.SchemaWSDLArrayType;
import p258y.AbstractC14516b;
import repackage.Repackager;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class SchemaTypeSystemImpl extends SchemaTypeLoaderBase implements SchemaTypeSystem {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final int CONSTANT_CLASS = 7;
    private static final int CONSTANT_DOUBLE = 6;
    private static final int CONSTANT_FIELD = 9;
    private static final int CONSTANT_FLOAT = 4;
    private static final int CONSTANT_INTEGER = 3;
    private static final int CONSTANT_INTERFACEMETHOD = 11;
    private static final int CONSTANT_LONG = 5;
    private static final int CONSTANT_METHOD = 10;
    private static final int CONSTANT_NAMEANDTYPE = 12;
    private static final int CONSTANT_STRING = 8;
    private static final int CONSTANT_UNICODE = 2;
    private static final int CONSTANT_UTF8 = 1;
    public static final int DATA_BABE = -629491010;
    private static final SchemaAttributeGroup[] EMPTY_AG_ARRAY;
    private static final SchemaAnnotation[] EMPTY_ANN_ARRAY;
    private static final SchemaGlobalAttribute[] EMPTY_GA_ARRAY;
    private static final SchemaGlobalElement[] EMPTY_GE_ARRAY;
    private static final SchemaIdentityConstraint[] EMPTY_IC_ARRAY;
    private static final SchemaModelGroup[] EMPTY_MG_ARRAY;
    private static final SchemaType[] EMPTY_ST_ARRAY;
    public static final int FIELD_GLOBAL = 1;
    public static final int FIELD_LOCALATTR = 2;
    public static final int FIELD_LOCALELT = 3;
    public static final int FIELD_NONE = 0;
    public static final int FILETYPE_SCHEMAATTRIBUTE = 4;
    public static final int FILETYPE_SCHEMAATTRIBUTEGROUP = 7;
    public static final int FILETYPE_SCHEMAELEMENT = 3;
    public static final int FILETYPE_SCHEMAIDENTITYCONSTRAINT = 8;
    public static final int FILETYPE_SCHEMAINDEX = 1;
    public static final int FILETYPE_SCHEMAMODELGROUP = 6;
    public static final int FILETYPE_SCHEMAPOINTER = 5;
    public static final int FILETYPE_SCHEMATYPE = 2;
    static final int FLAG_ABSTRACT = 262144;
    static final int FLAG_ATTRIBUTE_TYPE = 524288;
    static final int FLAG_BLOCK_EXT = 4096;
    static final int FLAG_BLOCK_REST = 8192;
    static final int FLAG_BOUNDED = 8;
    static final int FLAG_COMPILED = 2048;
    static final int FLAG_DOCUMENT_TYPE = 2;
    static final int FLAG_FINAL_EXT = 16384;
    static final int FLAG_FINAL_LIST = 131072;
    static final int FLAG_FINAL_REST = 32768;
    static final int FLAG_FINAL_UNION = 65536;
    static final int FLAG_FINITE = 16;
    static final int FLAG_HAS_PATTERN = 256;
    static final int FLAG_NUMERIC = 32;
    static final int FLAG_ORDERED = 4;
    static final int FLAG_ORDER_SENSITIVE = 512;
    public static final int FLAG_PART_ABSTRACT = 128;
    public static final int FLAG_PART_BLOCKEXT = 16;
    public static final int FLAG_PART_BLOCKREST = 32;
    public static final int FLAG_PART_BLOCKSUBST = 64;
    public static final int FLAG_PART_FINALEXT = 256;
    public static final int FLAG_PART_FINALREST = 512;
    public static final int FLAG_PART_FIXED = 4;
    public static final int FLAG_PART_NILLABLE = 8;
    public static final int FLAG_PART_SKIPPABLE = 1;
    public static final int FLAG_PROP_ISATTR = 1;
    public static final int FLAG_PROP_JAVAARRAY = 8;
    public static final int FLAG_PROP_JAVAOPTIONAL = 4;
    public static final int FLAG_PROP_JAVASINGLETON = 2;
    static final int FLAG_SIMPLE_TYPE = 1;
    static final int FLAG_STRINGENUM = 64;
    static final int FLAG_TOTAL_ORDER = 1024;
    static final int FLAG_UNION_OF_LISTS = 128;
    private static final String HOLDER_TEMPLATE_CLASS = "org.apache.xmlbeans.impl.schema.TypeSystemHolder";
    private static final String HOLDER_TEMPLATE_CLASSFILE = "TypeSystemHolder.template";
    private static final String[] HOLDER_TEMPLATE_NAMES;
    public static final int MAJOR_VERSION = 2;
    private static final int MAX_UNSIGNED_SHORT = 65535;
    public static String METADATA_PACKAGE_GEN = null;
    public static final int MINOR_VERSION = 24;
    public static final int RELEASE_NUMBER = 0;
    static final byte[] SINGLE_ZERO_BYTE;
    private static byte[] _mask;
    private static Random _random;
    static /* synthetic */ Class class$org$apache$xmlbeans$SchemaTypeSystem;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$schema$SchemaTypeSystemImpl;
    private List _annotations;
    private Map _attributeGroups;
    private Map _attributeTypes;
    private String _basePackage;
    private ClassLoader _classloader;
    private SchemaDependencies _deps;
    private Map _documentTypes;
    private Filer _filer;
    private Map _globalAttributes;
    private Map _globalElements;
    private Map _globalTypes;
    SchemaTypeLoader _linker;
    private HandlePool _localHandles;
    private Map _modelGroups;
    private String _name;
    private Set _namespaces;
    private List _redefinedAttributeGroups;
    private List _redefinedGlobalTypes;
    private List _redefinedModelGroups;
    private ResourceLoader _resourceLoader;
    private boolean _incomplete = false;
    private Map _containers = new HashMap();
    private Map _identityConstraints = Collections.EMPTY_MAP;
    private Map _typeRefsByClassname = new HashMap();
    private final Map _resolvedHandles = new HashMap();
    private boolean _allNonGroupHandlesResolved = false;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class HandlePool {
        private boolean _started;
        private Map _handlesToRefs = new LinkedHashMap();
        private Map _componentsToHandles = new LinkedHashMap();

        public HandlePool() {
        }

        private String addUniqueHandle(SchemaComponent schemaComponent, String str) {
            String lowerCase = str.toLowerCase();
            int i = 2;
            String string = lowerCase;
            while (this._handlesToRefs.containsKey(string)) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(lowerCase);
                stringBuffer.append(i);
                string = stringBuffer.toString();
                i++;
            }
            this._handlesToRefs.put(string, schemaComponent.getComponentRef());
            this._componentsToHandles.put(schemaComponent, string);
            return string;
        }

        public Set getAllHandles() {
            return this._handlesToRefs.keySet();
        }

        public String handleForAttribute(SchemaGlobalAttribute schemaGlobalAttribute) {
            if (schemaGlobalAttribute == null) {
                return null;
            }
            if (schemaGlobalAttribute.getTypeSystem() != SchemaTypeSystemImpl.this.getTypeSystem()) {
                throw new IllegalArgumentException("Cannot supply handles for types from another type system");
            }
            String str = (String) this._componentsToHandles.get(schemaGlobalAttribute);
            return str == null ? addUniqueHandle(schemaGlobalAttribute, AbstractC8014b.m7199a(new StringBuffer(), NameUtil.upperCamelCase(schemaGlobalAttribute.getName().getLocalPart()), AnnotationConfiguration.ATTRIBUTE_TYPE)) : str;
        }

        public String handleForAttributeGroup(SchemaAttributeGroup schemaAttributeGroup) {
            if (schemaAttributeGroup == null) {
                return null;
            }
            if (schemaAttributeGroup.getTypeSystem() != SchemaTypeSystemImpl.this.getTypeSystem()) {
                throw new IllegalArgumentException("Cannot supply handles for types from another type system");
            }
            String str = (String) this._componentsToHandles.get(schemaAttributeGroup);
            return str == null ? addUniqueHandle(schemaAttributeGroup, AbstractC8014b.m7199a(new StringBuffer(), NameUtil.upperCamelCase(schemaAttributeGroup.getName().getLocalPart()), "AttributeGroup")) : str;
        }

        public String handleForComponent(SchemaComponent schemaComponent) {
            if (schemaComponent == null) {
                return null;
            }
            if (schemaComponent.getTypeSystem() != SchemaTypeSystemImpl.this.getTypeSystem()) {
                throw new IllegalArgumentException("Cannot supply handles for types from another type system");
            }
            if (schemaComponent instanceof SchemaType) {
                return handleForType((SchemaType) schemaComponent);
            }
            if (schemaComponent instanceof SchemaGlobalElement) {
                return handleForElement((SchemaGlobalElement) schemaComponent);
            }
            if (schemaComponent instanceof SchemaGlobalAttribute) {
                return handleForAttribute((SchemaGlobalAttribute) schemaComponent);
            }
            if (schemaComponent instanceof SchemaModelGroup) {
                return handleForModelGroup((SchemaModelGroup) schemaComponent);
            }
            if (schemaComponent instanceof SchemaAttributeGroup) {
                return handleForAttributeGroup((SchemaAttributeGroup) schemaComponent);
            }
            if (schemaComponent instanceof SchemaIdentityConstraint) {
                return handleForIdentityConstraint((SchemaIdentityConstraint) schemaComponent);
            }
            throw new IllegalStateException("Component type cannot have a handle");
        }

        public String handleForElement(SchemaGlobalElement schemaGlobalElement) {
            if (schemaGlobalElement == null) {
                return null;
            }
            if (schemaGlobalElement.getTypeSystem() != SchemaTypeSystemImpl.this.getTypeSystem()) {
                throw new IllegalArgumentException("Cannot supply handles for types from another type system");
            }
            String str = (String) this._componentsToHandles.get(schemaGlobalElement);
            return str == null ? addUniqueHandle(schemaGlobalElement, AbstractC8014b.m7199a(new StringBuffer(), NameUtil.upperCamelCase(schemaGlobalElement.getName().getLocalPart()), "Element")) : str;
        }

        public String handleForIdentityConstraint(SchemaIdentityConstraint schemaIdentityConstraint) {
            if (schemaIdentityConstraint == null) {
                return null;
            }
            if (schemaIdentityConstraint.getTypeSystem() != SchemaTypeSystemImpl.this.getTypeSystem()) {
                throw new IllegalArgumentException("Cannot supply handles for types from another type system");
            }
            String str = (String) this._componentsToHandles.get(schemaIdentityConstraint);
            return str == null ? addUniqueHandle(schemaIdentityConstraint, AbstractC8014b.m7199a(new StringBuffer(), NameUtil.upperCamelCase(schemaIdentityConstraint.getName().getLocalPart()), "IdentityConstraint")) : str;
        }

        public String handleForModelGroup(SchemaModelGroup schemaModelGroup) {
            if (schemaModelGroup == null) {
                return null;
            }
            if (schemaModelGroup.getTypeSystem() != SchemaTypeSystemImpl.this.getTypeSystem()) {
                throw new IllegalArgumentException("Cannot supply handles for types from another type system");
            }
            String str = (String) this._componentsToHandles.get(schemaModelGroup);
            return str == null ? addUniqueHandle(schemaModelGroup, AbstractC8014b.m7199a(new StringBuffer(), NameUtil.upperCamelCase(schemaModelGroup.getName().getLocalPart()), "ModelGroup")) : str;
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0058  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public String handleForType(SchemaType schemaType) {
            String str;
            String string;
            if (schemaType == null) {
                return null;
            }
            if (schemaType.getTypeSystem() != SchemaTypeSystemImpl.this.getTypeSystem()) {
                throw new IllegalArgumentException("Cannot supply handles for types from another type system");
            }
            String str2 = (String) this._componentsToHandles.get(schemaType);
            if (str2 != null) {
                return str2;
            }
            QName name = schemaType.getName();
            if (name != null) {
                str = "";
            } else if (schemaType.isDocumentType()) {
                name = schemaType.getDocumentElementName();
                str = "Doc";
            } else if (schemaType.isAttributeType()) {
                name = schemaType.getAttributeTypeAttributeName();
                str = "AttrType";
            } else if (schemaType.getContainerField() != null) {
                name = schemaType.getContainerField().getName();
                str = schemaType.getContainerField().isAttribute() ? "Attr" : "Elem";
            }
            String upperCase = Integer.toHexString(schemaType.toString().hashCode() | Integer.MIN_VALUE).substring(4).toUpperCase();
            if (name == null) {
                string = AbstractC12991c.m13990k("Anon", upperCase, PackageRelationship.TYPE_ATTRIBUTE_NAME);
            } else {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(NameUtil.upperCamelCase(name.getLocalPart()));
                stringBuffer.append(upperCase);
                stringBuffer.append(str);
                stringBuffer.append(PackageRelationship.TYPE_ATTRIBUTE_NAME);
                string = stringBuffer.toString();
            }
            return addUniqueHandle(schemaType, string);
        }

        public SchemaComponent.Ref refForHandle(String str) {
            if (str == null) {
                return null;
            }
            return (SchemaComponent.Ref) this._handlesToRefs.get(str);
        }

        public void startWriteMode() {
            this._started = true;
            this._componentsToHandles = new LinkedHashMap();
            for (String str : this._handlesToRefs.keySet()) {
                this._componentsToHandles.put(((SchemaComponent.Ref) this._handlesToRefs.get(str)).getComponent(), str);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class StringPool {
        private String _handle;
        private String _name;
        private List intsToStrings = new ArrayList();
        private Map stringsToInts = new HashMap();

        public StringPool(String str, String str2) {
            this._handle = str;
            this._name = str2;
            this.intsToStrings.add(null);
        }

        public int codeForString(String str) {
            if (str == null) {
                return 0;
            }
            Integer num = (Integer) this.stringsToInts.get(str);
            if (num == null) {
                num = new Integer(this.intsToStrings.size());
                this.intsToStrings.add(str);
                this.stringsToInts.put(str, num);
            }
            return num.intValue();
        }

        public void readFrom(DataInputStream dataInputStream) {
            if (this.intsToStrings.size() != 1 || this.stringsToInts.size() != 0) {
                throw new IllegalStateException();
            }
            try {
                int unsignedShort = dataInputStream.readUnsignedShort();
                for (int i = 1; i < unsignedShort; i++) {
                    if (codeForString(dataInputStream.readUTF().intern()) != i) {
                        throw new IllegalStateException();
                    }
                }
            } catch (IOException e) {
                throw new SchemaTypeLoaderException(e.getMessage() == null ? e.getMessage() : "IO Exception", this._name, this._handle, 9, e);
            }
        }

        public String stringForCode(int i) {
            if (i == 0) {
                return null;
            }
            return (String) this.intsToStrings.get(i);
        }

        public void writeTo(DataOutputStream dataOutputStream) {
            if (this.intsToStrings.size() >= 65535) {
                StringBuffer stringBuffer = new StringBuffer("Too many strings (");
                stringBuffer.append(this.intsToStrings.size());
                stringBuffer.append(")");
                throw new SchemaTypeLoaderException(stringBuffer.toString(), this._name, this._handle, 10);
            }
            try {
                dataOutputStream.writeShort(this.intsToStrings.size());
                Iterator it = this.intsToStrings.iterator();
                it.next();
                while (it.hasNext()) {
                    dataOutputStream.writeUTF((String) it.next());
                }
            } catch (IOException e) {
                throw new SchemaTypeLoaderException(e.getMessage(), this._name, this._handle, 9);
            }
        }
    }

    static {
        String name;
        if (class$org$apache$xmlbeans$impl$schema$SchemaTypeSystemImpl == null) {
            class$org$apache$xmlbeans$impl$schema$SchemaTypeSystemImpl = class$("org.apache.xmlbeans.impl.schema.SchemaTypeSystemImpl");
        }
        $assertionsDisabled = true;
        Class clsClass$ = class$org$apache$xmlbeans$SchemaTypeSystem;
        if (clsClass$ == null) {
            clsClass$ = class$("org.apache.xmlbeans.SchemaTypeSystem");
            class$org$apache$xmlbeans$SchemaTypeSystem = clsClass$;
        }
        Package r12 = clsClass$.getPackage();
        if (r12 == null) {
            Class clsClass$2 = class$org$apache$xmlbeans$SchemaTypeSystem;
            if (clsClass$2 == null) {
                clsClass$2 = class$("org.apache.xmlbeans.SchemaTypeSystem");
                class$org$apache$xmlbeans$SchemaTypeSystem = clsClass$2;
            }
            String name2 = clsClass$2.getName();
            Class clsClass$3 = class$org$apache$xmlbeans$SchemaTypeSystem;
            if (clsClass$3 == null) {
                clsClass$3 = class$("org.apache.xmlbeans.SchemaTypeSystem");
                class$org$apache$xmlbeans$SchemaTypeSystem = clsClass$3;
            }
            name = name2.substring(0, clsClass$3.getName().lastIndexOf(Extension.DOT));
        } else {
            name = r12.getName();
        }
        METADATA_PACKAGE_GEN = name.replaceAll(RemoteConstant.VERSION_DIVIDE, "_");
        HOLDER_TEMPLATE_NAMES = makeClassStrings(HOLDER_TEMPLATE_CLASS);
        _mask = new byte[16];
        EMPTY_ST_ARRAY = new SchemaType[0];
        EMPTY_GE_ARRAY = new SchemaGlobalElement[0];
        EMPTY_GA_ARRAY = new SchemaGlobalAttribute[0];
        EMPTY_MG_ARRAY = new SchemaModelGroup[0];
        EMPTY_AG_ARRAY = new SchemaAttributeGroup[0];
        EMPTY_IC_ARRAY = new SchemaIdentityConstraint[0];
        EMPTY_ANN_ARRAY = new SchemaAnnotation[0];
        SINGLE_ZERO_BYTE = new byte[]{0};
    }

    public SchemaTypeSystemImpl(Class cls) throws Throwable {
        String name = cls.getName();
        this._name = name.substring(0, name.lastIndexOf(46));
        StringBuffer stringBuffer = new StringBuffer("Loading type system ");
        stringBuffer.append(this._name);
        XBeanDebug.trace(1, stringBuffer.toString(), 1);
        this._basePackage = nameToPathString(this._name);
        ClassLoader classLoader = cls.getClassLoader();
        this._classloader = classLoader;
        this._linker = SchemaTypeLoaderImpl.build(null, null, classLoader);
        this._resourceLoader = new ClassLoaderResourceLoader(this._classloader);
        try {
            initFromHeader();
            StringBuffer stringBuffer2 = new StringBuffer("Finished loading type system ");
            stringBuffer2.append(this._name);
            XBeanDebug.trace(1, stringBuffer2.toString(), -1);
        } catch (Error e) {
            XBeanDebug.logException(e);
            throw e;
        } catch (RuntimeException e2) {
            XBeanDebug.logException(e2);
            throw e2;
        }
    }

    private void addContainer(String str) {
        SchemaContainer schemaContainer = new SchemaContainer(str);
        schemaContainer.setTypeSystem(this);
        this._containers.put(str, schemaContainer);
    }

    private void assertContainersSynchronized() {
        if ($assertionsDisabled) {
            return;
        }
        HashMap map = new HashMap();
        Iterator it = this._containers.values().iterator();
        while (it.hasNext()) {
            map.putAll(buildComponentRefMap((SchemaComponent[]) ((SchemaContainer) it.next()).globalElements().toArray(new SchemaComponent[0])));
        }
        if (!$assertionsDisabled && !this._globalElements.equals(map)) {
            throw new AssertionError();
        }
        HashMap map2 = new HashMap();
        Iterator it2 = this._containers.values().iterator();
        while (it2.hasNext()) {
            map2.putAll(buildComponentRefMap((SchemaComponent[]) ((SchemaContainer) it2.next()).globalAttributes().toArray(new SchemaComponent[0])));
        }
        if (!$assertionsDisabled && !this._globalAttributes.equals(map2)) {
            throw new AssertionError();
        }
        HashMap map3 = new HashMap();
        Iterator it3 = this._containers.values().iterator();
        while (it3.hasNext()) {
            map3.putAll(buildComponentRefMap((SchemaComponent[]) ((SchemaContainer) it3.next()).modelGroups().toArray(new SchemaComponent[0])));
        }
        if (!$assertionsDisabled && !this._modelGroups.equals(map3)) {
            throw new AssertionError();
        }
        HashSet hashSet = new HashSet();
        Iterator it4 = this._containers.values().iterator();
        while (it4.hasNext()) {
            hashSet.addAll(buildComponentRefList((SchemaComponent[]) ((SchemaContainer) it4.next()).redefinedModelGroups().toArray(new SchemaComponent[0])));
        }
        if (!$assertionsDisabled && !new HashSet(this._redefinedModelGroups).equals(hashSet)) {
            throw new AssertionError();
        }
        HashMap map4 = new HashMap();
        Iterator it5 = this._containers.values().iterator();
        while (it5.hasNext()) {
            map4.putAll(buildComponentRefMap((SchemaComponent[]) ((SchemaContainer) it5.next()).attributeGroups().toArray(new SchemaComponent[0])));
        }
        if (!$assertionsDisabled && !this._attributeGroups.equals(map4)) {
            throw new AssertionError();
        }
        HashSet hashSet2 = new HashSet();
        Iterator it6 = this._containers.values().iterator();
        while (it6.hasNext()) {
            hashSet2.addAll(buildComponentRefList((SchemaComponent[]) ((SchemaContainer) it6.next()).redefinedAttributeGroups().toArray(new SchemaComponent[0])));
        }
        if (!$assertionsDisabled && !new HashSet(this._redefinedAttributeGroups).equals(hashSet2)) {
            throw new AssertionError();
        }
        HashMap map5 = new HashMap();
        Iterator it7 = this._containers.values().iterator();
        while (it7.hasNext()) {
            map5.putAll(buildComponentRefMap((SchemaComponent[]) ((SchemaContainer) it7.next()).globalTypes().toArray(new SchemaComponent[0])));
        }
        if (!$assertionsDisabled && !this._globalTypes.equals(map5)) {
            throw new AssertionError();
        }
        HashSet hashSet3 = new HashSet();
        Iterator it8 = this._containers.values().iterator();
        while (it8.hasNext()) {
            hashSet3.addAll(buildComponentRefList((SchemaComponent[]) ((SchemaContainer) it8.next()).redefinedGlobalTypes().toArray(new SchemaComponent[0])));
        }
        if (!$assertionsDisabled && !new HashSet(this._redefinedGlobalTypes).equals(hashSet3)) {
            throw new AssertionError();
        }
        HashMap map6 = new HashMap();
        Iterator it9 = this._containers.values().iterator();
        while (it9.hasNext()) {
            map6.putAll(buildDocumentMap((SchemaType[]) ((SchemaContainer) it9.next()).documentTypes().toArray(new SchemaType[0])));
        }
        if (!$assertionsDisabled && !this._documentTypes.equals(map6)) {
            throw new AssertionError();
        }
        HashMap map7 = new HashMap();
        Iterator it10 = this._containers.values().iterator();
        while (it10.hasNext()) {
            map7.putAll(buildAttributeTypeMap((SchemaType[]) ((SchemaContainer) it10.next()).attributeTypes().toArray(new SchemaType[0])));
        }
        if (!$assertionsDisabled && !this._attributeTypes.equals(map7)) {
            throw new AssertionError();
        }
        HashMap map8 = new HashMap();
        Iterator it11 = this._containers.values().iterator();
        while (it11.hasNext()) {
            map8.putAll(buildComponentRefMap((SchemaComponent[]) ((SchemaContainer) it11.next()).identityConstraints().toArray(new SchemaComponent[0])));
        }
        if (!$assertionsDisabled && !this._identityConstraints.equals(map8)) {
            throw new AssertionError();
        }
        HashSet hashSet4 = new HashSet();
        Iterator it12 = this._containers.values().iterator();
        while (it12.hasNext()) {
            hashSet4.addAll(((SchemaContainer) it12.next()).annotations());
        }
        if (!$assertionsDisabled && !new HashSet(this._annotations).equals(hashSet4)) {
            throw new AssertionError();
        }
        HashSet hashSet5 = new HashSet();
        Iterator it13 = this._containers.values().iterator();
        while (it13.hasNext()) {
            hashSet5.add(((SchemaContainer) it13.next()).getNamespace());
        }
        if (!$assertionsDisabled && !this._namespaces.equals(hashSet5)) {
            throw new AssertionError();
        }
    }

    private static Map buildAttributeTypeMap(SchemaType[] schemaTypeArr) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i = 0; i < schemaTypeArr.length; i++) {
            linkedHashMap.put(schemaTypeArr[i].getAttributeTypeAttributeName(), schemaTypeArr[i].getRef());
        }
        return linkedHashMap;
    }

    private static List buildComponentRefList(SchemaComponent[] schemaComponentArr) {
        ArrayList arrayList = new ArrayList();
        for (SchemaComponent schemaComponent : schemaComponentArr) {
            arrayList.add(schemaComponent.getComponentRef());
        }
        return arrayList;
    }

    private static Map buildComponentRefMap(SchemaComponent[] schemaComponentArr) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i = 0; i < schemaComponentArr.length; i++) {
            linkedHashMap.put(schemaComponentArr[i].getName(), schemaComponentArr[i].getComponentRef());
        }
        return linkedHashMap;
    }

    private void buildContainers(List list, List list2, List list3) {
        for (Map.Entry entry : this._globalElements.entrySet()) {
            getContainerNonNull(((QName) entry.getKey()).getNamespaceURI()).addGlobalElement((SchemaGlobalElement.Ref) entry.getValue());
        }
        for (Map.Entry entry2 : this._globalAttributes.entrySet()) {
            getContainerNonNull(((QName) entry2.getKey()).getNamespaceURI()).addGlobalAttribute((SchemaGlobalAttribute.Ref) entry2.getValue());
        }
        for (Map.Entry entry3 : this._modelGroups.entrySet()) {
            getContainerNonNull(((QName) entry3.getKey()).getNamespaceURI()).addModelGroup((SchemaModelGroup.Ref) entry3.getValue());
        }
        for (Map.Entry entry4 : this._attributeGroups.entrySet()) {
            getContainerNonNull(((QName) entry4.getKey()).getNamespaceURI()).addAttributeGroup((SchemaAttributeGroup.Ref) entry4.getValue());
        }
        for (Map.Entry entry5 : this._identityConstraints.entrySet()) {
            getContainerNonNull(((QName) entry5.getKey()).getNamespaceURI()).addIdentityConstraint((SchemaIdentityConstraint.Ref) entry5.getValue());
        }
        for (Map.Entry entry6 : this._globalTypes.entrySet()) {
            getContainerNonNull(((QName) entry6.getKey()).getNamespaceURI()).addGlobalType((SchemaType.Ref) entry6.getValue());
        }
        for (Map.Entry entry7 : this._documentTypes.entrySet()) {
            getContainerNonNull(((QName) entry7.getKey()).getNamespaceURI()).addDocumentType((SchemaType.Ref) entry7.getValue());
        }
        for (Map.Entry entry8 : this._attributeTypes.entrySet()) {
            getContainerNonNull(((QName) entry8.getKey()).getNamespaceURI()).addAttributeType((SchemaType.Ref) entry8.getValue());
        }
        List list4 = this._redefinedGlobalTypes;
        if (list4 != null && this._redefinedModelGroups != null && this._redefinedAttributeGroups != null) {
            if (!$assertionsDisabled && list4.size() != list.size()) {
                throw new AssertionError();
            }
            Iterator it = this._redefinedGlobalTypes.iterator();
            Iterator it2 = list.iterator();
            while (it.hasNext()) {
                getContainerNonNull(((QName) it2.next()).getNamespaceURI()).addRedefinedType((SchemaType.Ref) it.next());
            }
            Iterator it3 = this._redefinedModelGroups.iterator();
            Iterator it4 = list2.iterator();
            while (it3.hasNext()) {
                getContainerNonNull(((QName) it4.next()).getNamespaceURI()).addRedefinedModelGroup((SchemaModelGroup.Ref) it3.next());
            }
            Iterator it5 = this._redefinedAttributeGroups.iterator();
            Iterator it6 = list3.iterator();
            while (it5.hasNext()) {
                getContainerNonNull(((QName) it6.next()).getNamespaceURI()).addRedefinedAttributeGroup((SchemaAttributeGroup.Ref) it5.next());
            }
        }
        List list5 = this._annotations;
        if (list5 != null) {
            Iterator it7 = list5.iterator();
            while (it7.hasNext()) {
                getContainerNonNull("").addAnnotation((SchemaAnnotation) it7.next());
            }
        }
        Iterator it8 = this._containers.values().iterator();
        while (it8.hasNext()) {
            ((SchemaContainer) it8.next()).setImmutable();
        }
    }

    private static Map buildDocumentMap(SchemaType[] schemaTypeArr) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i = 0; i < schemaTypeArr.length; i++) {
            linkedHashMap.put(schemaTypeArr[i].getDocumentElementName(), schemaTypeArr[i].getRef());
        }
        return linkedHashMap;
    }

    private Map buildTypeRefsByClassname() {
        ArrayList arrayList = new ArrayList();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        arrayList.addAll(Arrays.asList(documentTypes()));
        arrayList.addAll(Arrays.asList(attributeTypes()));
        arrayList.addAll(Arrays.asList(globalTypes()));
        for (int i = 0; i < arrayList.size(); i++) {
            SchemaType schemaType = (SchemaType) arrayList.get(i);
            String fullJavaName = schemaType.getFullJavaName();
            if (fullJavaName != null) {
                linkedHashMap.put(fullJavaName.replace('$', '.'), schemaType.getRef());
            }
            arrayList.addAll(Arrays.asList(schemaType.getAnonymousTypes()));
        }
        return linkedHashMap;
    }

    public static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw AbstractC12991c.m13994o(e);
        }
    }

    public static String crackPointer(InputStream inputStream) throws Throwable {
        DataInputStream dataInputStream;
        DataInputStream dataInputStream2 = null;
        try {
            dataInputStream = new DataInputStream(inputStream);
            try {
                if (dataInputStream.readInt() != -629491010) {
                    try {
                        dataInputStream.close();
                    } catch (IOException unused) {
                    }
                    return null;
                }
                short s = dataInputStream.readShort();
                short s2 = dataInputStream.readShort();
                if (s != 2) {
                    try {
                        dataInputStream.close();
                    } catch (IOException unused2) {
                    }
                    return null;
                }
                if (s2 > 24) {
                    try {
                        dataInputStream.close();
                    } catch (IOException unused3) {
                    }
                    return null;
                }
                if (s > 2 || (s == 2 && s2 >= 18)) {
                    dataInputStream.readShort();
                }
                if (dataInputStream.readShort() != 5) {
                    try {
                        dataInputStream.close();
                    } catch (IOException unused4) {
                    }
                    return null;
                }
                StringPool stringPool = new StringPool("pointer", "unk");
                stringPool.readFrom(dataInputStream);
                String strStringForCode = stringPool.stringForCode(dataInputStream.readShort());
                try {
                    dataInputStream.close();
                } catch (IOException unused5) {
                }
                return strStringForCode;
            } catch (IOException unused6) {
                if (dataInputStream != null) {
                    try {
                        dataInputStream.close();
                    } catch (IOException unused7) {
                    }
                }
                return null;
            } catch (Throwable th) {
                th = th;
                dataInputStream2 = dataInputStream;
                if (dataInputStream2 != null) {
                    try {
                        dataInputStream2.close();
                    } catch (IOException unused8) {
                    }
                }
                throw th;
            }
        } catch (IOException unused9) {
            dataInputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean fileContainsTypeSystem(File file, String str) throws Throwable {
        ZipFile zipFile;
        boolean z;
        String strM7199a = AbstractC8014b.m7199a(new StringBuffer(), nameToPathString(str), "index.xsb");
        if (file.isDirectory()) {
            return new File(file, strM7199a).isFile();
        }
        ZipFile zipFile2 = null;
        try {
            try {
                zipFile = new ZipFile(file);
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            e = e;
        }
        try {
            ZipEntry entry = zipFile.getEntry(strM7199a);
            if (entry != null) {
                z = !entry.isDirectory();
            }
            try {
                zipFile.close();
            } catch (IOException unused) {
            }
            return z;
        } catch (IOException e2) {
            e = e2;
            StringBuffer stringBuffer = new StringBuffer("Problem loading SchemaTypeSystem, zipfilename ");
            stringBuffer.append(file);
            XBeanDebug.log(stringBuffer.toString());
            XBeanDebug.logException(e);
            throw new SchemaTypeLoaderException(e.getMessage(), str, "index", 9);
        } catch (Throwable th2) {
            th = th2;
            zipFile2 = zipFile;
            if (zipFile2 != null) {
                try {
                    zipFile2.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }

    private void fixupContainers() {
        for (SchemaContainer schemaContainer : this._containers.values()) {
            schemaContainer.setTypeSystem(this);
            schemaContainer.setImmutable();
        }
    }

    public static SchemaTypeSystemImpl forName(String str, ClassLoader classLoader) {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append(".TypeSystemHolder");
            return (SchemaTypeSystemImpl) Class.forName(stringBuffer.toString(), true, classLoader).getField("typeSystem").get(null);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SchemaContainer getContainer(String str) {
        return (SchemaContainer) this._containers.get(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SchemaContainer getContainerNonNull(String str) {
        SchemaContainer container = getContainer(str);
        if (container != null) {
            return container;
        }
        addContainer(str);
        return getContainer(str);
    }

    private void initFromHeader() throws Throwable {
        XsbReader xsbReader;
        Throwable th;
        StringBuffer stringBuffer = new StringBuffer("Reading unresolved handles for type system ");
        stringBuffer.append(this._name);
        XBeanDebug.trace(1, stringBuffer.toString(), 0);
        try {
            xsbReader = new XsbReader("index", 1);
        } catch (Throwable th2) {
            xsbReader = null;
            th = th2;
        }
        try {
            HandlePool handlePool = new HandlePool();
            this._localHandles = handlePool;
            xsbReader.readHandlePool(handlePool);
            this._globalElements = xsbReader.readQNameRefMap();
            this._globalAttributes = xsbReader.readQNameRefMap();
            this._modelGroups = xsbReader.readQNameRefMap();
            this._attributeGroups = xsbReader.readQNameRefMap();
            this._identityConstraints = xsbReader.readQNameRefMap();
            this._globalTypes = xsbReader.readQNameRefMap();
            this._documentTypes = xsbReader.readQNameRefMap();
            this._attributeTypes = xsbReader.readQNameRefMap();
            this._typeRefsByClassname = xsbReader.readClassnameRefMap();
            this._namespaces = xsbReader.readNamespaces();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            if (xsbReader.atLeast(2, 15, 0)) {
                this._redefinedGlobalTypes = xsbReader.readQNameRefMapAsList(arrayList);
                this._redefinedModelGroups = xsbReader.readQNameRefMapAsList(arrayList2);
                this._redefinedAttributeGroups = xsbReader.readQNameRefMapAsList(arrayList3);
            }
            if (xsbReader.atLeast(2, 19, 0)) {
                this._annotations = xsbReader.readAnnotations();
            }
            buildContainers(arrayList, arrayList2, arrayList3);
            xsbReader.readEnd();
        } catch (Throwable th3) {
            th = th3;
            if (xsbReader == null) {
                throw th;
            }
            xsbReader.readEnd();
            throw th;
        }
    }

    private static String[] makeClassStrings(String str) {
        String[] strArr = new String[4];
        strArr[0] = str;
        strArr[1] = str.replace('.', '/');
        strArr[2] = AbstractC8014b.m7199a(new StringBuffer("L"), strArr[1], ";");
        StringBuffer stringBuffer = new StringBuffer("class$");
        stringBuffer.append(str.replace('.', '$'));
        strArr[3] = stringBuffer.toString();
        return strArr;
    }

    private static String nameToPathString(String str) {
        String strReplace = str.replace('.', '/');
        return (strReplace.endsWith("/") || strReplace.length() <= 0) ? strReplace : strReplace.concat("/");
    }

    private static synchronized void nextBytes(byte[] bArr) {
        try {
            if (_random == null) {
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                    Class clsClass$ = class$org$apache$xmlbeans$impl$schema$SchemaTypeSystemImpl;
                    if (clsClass$ == null) {
                        clsClass$ = class$("org.apache.xmlbeans.impl.schema.SchemaTypeSystemImpl");
                        class$org$apache$xmlbeans$impl$schema$SchemaTypeSystemImpl = clsClass$;
                    }
                    dataOutputStream.writeInt(System.identityHashCode(clsClass$));
                    String[] strArr = {"user.name", "user.dir", SystemProperties.USER_TIMEZONE, SystemProperties.USER_COUNTRY, SystemProperties.JAVA_CLASS_PATH, "java.home", SystemProperties.JAVA_VENDOR, SystemProperties.JAVA_VERSION, SystemProperties.OS_VERSION};
                    for (int i = 0; i < 9; i++) {
                        String property = org.apache.xmlbeans.SystemProperties.getProperty(strArr[i]);
                        if (property != null) {
                            dataOutputStream.writeUTF(property);
                            dataOutputStream.writeInt(System.identityHashCode(property));
                        }
                    }
                    dataOutputStream.writeLong(Runtime.getRuntime().freeMemory());
                    dataOutputStream.close();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    for (int i2 = 0; i2 < byteArray.length; i2++) {
                        byte[] bArr2 = _mask;
                        int length = i2 % bArr2.length;
                        byte b = (byte) (bArr2[length] * 21);
                        bArr2[length] = b;
                        bArr2[length] = (byte) (b + i2);
                    }
                } catch (IOException e) {
                    XBeanDebug.logException(e);
                }
                _random = new Random(System.currentTimeMillis());
            }
            _random.nextBytes(bArr);
            for (int i4 = 0; i4 < bArr.length; i4++) {
                byte[] bArr3 = _mask;
                bArr[i4] = (byte) (bArr3[bArr3.length & i4] ^ bArr[i4]);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private static String repackageConstant(String str, String[] strArr, Repackager repackager) {
        int i = 0;
        while (true) {
            String[] strArr2 = HOLDER_TEMPLATE_NAMES;
            if (i >= strArr2.length) {
                return repackager != null ? repackager.repackage(new StringBuffer(str)).toString() : str;
            }
            if (strArr2[i].equals(str)) {
                return strArr[i];
            }
            i++;
        }
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public SchemaAnnotation[] annotations() {
        List list = this._annotations;
        if (list == null || list.isEmpty()) {
            return EMPTY_ANN_ARRAY;
        }
        return (SchemaAnnotation[]) this._annotations.toArray(new SchemaAnnotation[this._annotations.size()]);
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public SchemaAttributeGroup[] attributeGroups() {
        if (this._attributeGroups.isEmpty()) {
            return EMPTY_AG_ARRAY;
        }
        SchemaAttributeGroup[] schemaAttributeGroupArr = new SchemaAttributeGroup[this._attributeGroups.size()];
        Iterator it = this._attributeGroups.values().iterator();
        int i = 0;
        while (it.hasNext()) {
            schemaAttributeGroupArr[i] = ((SchemaAttributeGroup.Ref) it.next()).get();
            i++;
        }
        return schemaAttributeGroupArr;
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public SchemaType[] attributeTypes() {
        if (this._attributeTypes.isEmpty()) {
            return EMPTY_ST_ARRAY;
        }
        SchemaType[] schemaTypeArr = new SchemaType[this._attributeTypes.size()];
        Iterator it = this._attributeTypes.values().iterator();
        int i = 0;
        while (it.hasNext()) {
            schemaTypeArr[i] = ((SchemaType.Ref) it.next()).get();
            i++;
        }
        return schemaTypeArr;
    }

    public SchemaContainer[] containers() {
        SchemaContainer[] schemaContainerArr = new SchemaContainer[this._containers.size()];
        Iterator it = this._containers.values().iterator();
        int i = 0;
        while (it.hasNext()) {
            schemaContainerArr[i] = (SchemaContainer) it.next();
            i++;
        }
        return schemaContainerArr;
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public SchemaType[] documentTypes() {
        if (this._documentTypes.isEmpty()) {
            return EMPTY_ST_ARRAY;
        }
        SchemaType[] schemaTypeArr = new SchemaType[this._documentTypes.size()];
        Iterator it = this._documentTypes.values().iterator();
        int i = 0;
        while (it.hasNext()) {
            schemaTypeArr[i] = ((SchemaType.Ref) it.next()).get();
            i++;
        }
        return schemaTypeArr;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaAttributeGroup.Ref findAttributeGroupRef(QName qName) {
        return (SchemaAttributeGroup.Ref) this._attributeGroups.get(qName);
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaGlobalAttribute.Ref findAttributeRef(QName qName) {
        return (SchemaGlobalAttribute.Ref) this._globalAttributes.get(qName);
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType.Ref findAttributeTypeRef(QName qName) {
        return (SchemaType.Ref) this._attributeTypes.get(qName);
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType.Ref findDocumentTypeRef(QName qName) {
        return (SchemaType.Ref) this._documentTypes.get(qName);
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaGlobalElement.Ref findElementRef(QName qName) {
        return (SchemaGlobalElement.Ref) this._globalElements.get(qName);
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaIdentityConstraint.Ref findIdentityConstraintRef(QName qName) {
        return (SchemaIdentityConstraint.Ref) this._identityConstraints.get(qName);
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaModelGroup.Ref findModelGroupRef(QName qName) {
        return (SchemaModelGroup.Ref) this._modelGroups.get(qName);
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType.Ref findTypeRef(QName qName) {
        return (SchemaType.Ref) this._globalTypes.get(qName);
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public ClassLoader getClassLoader() {
        return this._classloader;
    }

    public SchemaDependencies getDependencies() {
        return this._deps;
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public String getName() {
        return this._name;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public InputStream getSourceAsStream(String str) {
        if (!str.startsWith("/")) {
            str = "/".concat(str);
        }
        ResourceLoader resourceLoader = this._resourceLoader;
        StringBuffer stringBuffer = new StringBuffer("schema");
        stringBuffer.append(METADATA_PACKAGE_GEN);
        stringBuffer.append("/src");
        stringBuffer.append(str);
        return resourceLoader.getResourceAsStream(stringBuffer.toString());
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public SchemaGlobalAttribute[] globalAttributes() {
        if (this._globalAttributes.isEmpty()) {
            return EMPTY_GA_ARRAY;
        }
        SchemaGlobalAttribute[] schemaGlobalAttributeArr = new SchemaGlobalAttribute[this._globalAttributes.size()];
        Iterator it = this._globalAttributes.values().iterator();
        int i = 0;
        while (it.hasNext()) {
            schemaGlobalAttributeArr[i] = ((SchemaGlobalAttribute.Ref) it.next()).get();
            i++;
        }
        return schemaGlobalAttributeArr;
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public SchemaGlobalElement[] globalElements() {
        if (this._globalElements.isEmpty()) {
            return EMPTY_GE_ARRAY;
        }
        SchemaGlobalElement[] schemaGlobalElementArr = new SchemaGlobalElement[this._globalElements.size()];
        Iterator it = this._globalElements.values().iterator();
        int i = 0;
        while (it.hasNext()) {
            schemaGlobalElementArr[i] = ((SchemaGlobalElement.Ref) it.next()).get();
            i++;
        }
        return schemaGlobalElementArr;
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public SchemaType[] globalTypes() {
        if (this._globalTypes.isEmpty()) {
            return EMPTY_ST_ARRAY;
        }
        SchemaType[] schemaTypeArr = new SchemaType[this._globalTypes.size()];
        Iterator it = this._globalTypes.values().iterator();
        int i = 0;
        while (it.hasNext()) {
            schemaTypeArr[i] = ((SchemaType.Ref) it.next()).get();
            i++;
        }
        return schemaTypeArr;
    }

    public String handleForType(SchemaType schemaType) {
        return this._localHandles.handleForType(schemaType);
    }

    public SchemaIdentityConstraint[] identityConstraints() {
        if (this._identityConstraints.isEmpty()) {
            return EMPTY_IC_ARRAY;
        }
        SchemaIdentityConstraint[] schemaIdentityConstraintArr = new SchemaIdentityConstraint[this._identityConstraints.size()];
        Iterator it = this._identityConstraints.values().iterator();
        int i = 0;
        while (it.hasNext()) {
            schemaIdentityConstraintArr[i] = ((SchemaIdentityConstraint.Ref) it.next()).get();
            i++;
        }
        return schemaIdentityConstraintArr;
    }

    public boolean isIncomplete() {
        return this._incomplete;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public boolean isNamespaceDefined(String str) {
        return this._namespaces.contains(str);
    }

    public void loadFromBuilder(SchemaGlobalElement[] schemaGlobalElementArr, SchemaGlobalAttribute[] schemaGlobalAttributeArr, SchemaType[] schemaTypeArr, SchemaType[] schemaTypeArr2, SchemaType[] schemaTypeArr3) {
        if (!$assertionsDisabled && this._classloader != null) {
            throw new AssertionError();
        }
        this._localHandles = new HandlePool();
        this._globalElements = buildComponentRefMap(schemaGlobalElementArr);
        this._globalAttributes = buildComponentRefMap(schemaGlobalAttributeArr);
        this._globalTypes = buildComponentRefMap(schemaTypeArr);
        this._documentTypes = buildDocumentMap(schemaTypeArr2);
        this._attributeTypes = buildAttributeTypeMap(schemaTypeArr3);
        this._typeRefsByClassname = buildTypeRefsByClassname();
        List list = Collections.EMPTY_LIST;
        buildContainers(list, list, list);
        this._namespaces = new HashSet();
    }

    public void loadFromStscState(StscState stscState) {
        if (!$assertionsDisabled && this._classloader != null) {
            throw new AssertionError();
        }
        this._localHandles = new HandlePool();
        this._globalElements = buildComponentRefMap(stscState.globalElements());
        this._globalAttributes = buildComponentRefMap(stscState.globalAttributes());
        this._modelGroups = buildComponentRefMap(stscState.modelGroups());
        this._redefinedModelGroups = buildComponentRefList(stscState.redefinedModelGroups());
        this._attributeGroups = buildComponentRefMap(stscState.attributeGroups());
        this._redefinedAttributeGroups = buildComponentRefList(stscState.redefinedAttributeGroups());
        this._globalTypes = buildComponentRefMap(stscState.globalTypes());
        this._redefinedGlobalTypes = buildComponentRefList(stscState.redefinedGlobalTypes());
        this._documentTypes = buildDocumentMap(stscState.documentTypes());
        this._attributeTypes = buildAttributeTypeMap(stscState.attributeTypes());
        this._typeRefsByClassname = buildTypeRefsByClassname(stscState.typesByClassname());
        this._identityConstraints = buildComponentRefMap(stscState.idConstraints());
        this._annotations = stscState.annotations();
        this._namespaces = new HashSet(Arrays.asList(stscState.getNamespaces()));
        this._containers = stscState.getContainerMap();
        fixupContainers();
        assertContainersSynchronized();
        setDependencies(stscState.getDependencies());
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public SchemaModelGroup[] modelGroups() {
        if (this._modelGroups.isEmpty()) {
            return EMPTY_MG_ARRAY;
        }
        SchemaModelGroup[] schemaModelGroupArr = new SchemaModelGroup[this._modelGroups.size()];
        Iterator it = this._modelGroups.values().iterator();
        int i = 0;
        while (it.hasNext()) {
            schemaModelGroupArr[i] = ((SchemaModelGroup.Ref) it.next()).get();
            i++;
        }
        return schemaModelGroupArr;
    }

    public SchemaAttributeGroup[] redefinedAttributeGroups() {
        List list = this._redefinedAttributeGroups;
        if (list == null || list.isEmpty()) {
            return EMPTY_AG_ARRAY;
        }
        SchemaAttributeGroup[] schemaAttributeGroupArr = new SchemaAttributeGroup[this._redefinedAttributeGroups.size()];
        Iterator it = this._redefinedAttributeGroups.iterator();
        int i = 0;
        while (it.hasNext()) {
            schemaAttributeGroupArr[i] = ((SchemaAttributeGroup.Ref) it.next()).get();
            i++;
        }
        return schemaAttributeGroupArr;
    }

    public SchemaType[] redefinedGlobalTypes() {
        List list = this._redefinedGlobalTypes;
        if (list == null || list.isEmpty()) {
            return EMPTY_ST_ARRAY;
        }
        SchemaType[] schemaTypeArr = new SchemaType[this._redefinedGlobalTypes.size()];
        Iterator it = this._redefinedGlobalTypes.iterator();
        int i = 0;
        while (it.hasNext()) {
            schemaTypeArr[i] = ((SchemaType.Ref) it.next()).get();
            i++;
        }
        return schemaTypeArr;
    }

    public SchemaModelGroup[] redefinedModelGroups() {
        List list = this._redefinedModelGroups;
        if (list == null || list.isEmpty()) {
            return EMPTY_MG_ARRAY;
        }
        SchemaModelGroup[] schemaModelGroupArr = new SchemaModelGroup[this._redefinedModelGroups.size()];
        Iterator it = this._redefinedModelGroups.iterator();
        int i = 0;
        while (it.hasNext()) {
            schemaModelGroupArr[i] = ((SchemaModelGroup.Ref) it.next()).get();
            i++;
        }
        return schemaModelGroupArr;
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public void resolve() throws Throwable {
        StringBuffer stringBuffer = new StringBuffer("Resolve called type system ");
        stringBuffer.append(this._name);
        XBeanDebug.trace(1, stringBuffer.toString(), 0);
        if (this._allNonGroupHandlesResolved) {
            return;
        }
        StringBuffer stringBuffer2 = new StringBuffer("Resolving all handles for type system ");
        stringBuffer2.append(this._name);
        XBeanDebug.trace(1, stringBuffer2.toString(), 1);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this._globalElements.values());
        arrayList.addAll(this._globalAttributes.values());
        arrayList.addAll(this._globalTypes.values());
        arrayList.addAll(this._documentTypes.values());
        arrayList.addAll(this._attributeTypes.values());
        arrayList.addAll(this._identityConstraints.values());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((SchemaComponent.Ref) it.next()).getComponent();
        }
        StringBuffer stringBuffer3 = new StringBuffer("Finished resolving type system ");
        stringBuffer3.append(this._name);
        XBeanDebug.trace(1, stringBuffer3.toString(), -1);
        this._allNonGroupHandlesResolved = true;
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public SchemaComponent resolveHandle(String str) throws Throwable {
        SchemaComponent schemaComponent;
        SchemaComponent schemaComponentFinishLoadingType;
        synchronized (this._resolvedHandles) {
            schemaComponent = (SchemaComponent) this._resolvedHandles.get(str);
        }
        if (schemaComponent != null) {
            return schemaComponent;
        }
        XsbReader xsbReader = new XsbReader(str, 65535);
        int actualFiletype = xsbReader.getActualFiletype();
        if (actualFiletype == 2) {
            StringBuffer stringBuffer = new StringBuffer("Resolving type for handle ");
            stringBuffer.append(str);
            XBeanDebug.trace(1, stringBuffer.toString(), 0);
            schemaComponentFinishLoadingType = xsbReader.finishLoadingType();
        } else if (actualFiletype == 3) {
            StringBuffer stringBuffer2 = new StringBuffer("Resolving element for handle ");
            stringBuffer2.append(str);
            XBeanDebug.trace(1, stringBuffer2.toString(), 0);
            schemaComponentFinishLoadingType = xsbReader.finishLoadingElement();
        } else if (actualFiletype == 4) {
            StringBuffer stringBuffer3 = new StringBuffer("Resolving attribute for handle ");
            stringBuffer3.append(str);
            XBeanDebug.trace(1, stringBuffer3.toString(), 0);
            schemaComponentFinishLoadingType = xsbReader.finishLoadingAttribute();
        } else if (actualFiletype == 6) {
            StringBuffer stringBuffer4 = new StringBuffer("Resolving model group for handle ");
            stringBuffer4.append(str);
            XBeanDebug.trace(1, stringBuffer4.toString(), 0);
            schemaComponentFinishLoadingType = xsbReader.finishLoadingModelGroup();
        } else if (actualFiletype == 7) {
            StringBuffer stringBuffer5 = new StringBuffer("Resolving attribute group for handle ");
            stringBuffer5.append(str);
            XBeanDebug.trace(1, stringBuffer5.toString(), 0);
            schemaComponentFinishLoadingType = xsbReader.finishLoadingAttributeGroup();
        } else {
            if (actualFiletype != 8) {
                throw new IllegalStateException("Illegal handle type");
            }
            StringBuffer stringBuffer6 = new StringBuffer("Resolving id constraint for handle ");
            stringBuffer6.append(str);
            XBeanDebug.trace(1, stringBuffer6.toString(), 0);
            schemaComponentFinishLoadingType = xsbReader.finishLoadingIdentityConstraint();
        }
        synchronized (this._resolvedHandles) {
            try {
                if (this._resolvedHandles.containsKey(str)) {
                    schemaComponentFinishLoadingType = (SchemaComponent) this._resolvedHandles.get(str);
                } else {
                    this._resolvedHandles.put(str, schemaComponentFinishLoadingType);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return schemaComponentFinishLoadingType;
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public void save(Filer filer) throws Throwable {
        if (this._incomplete) {
            throw new IllegalStateException("Incomplete SchemaTypeSystems cannot be saved.");
        }
        if (filer == null) {
            throw new IllegalArgumentException("filer must not be null");
        }
        this._filer = filer;
        this._localHandles.startWriteMode();
        saveTypesRecursively(globalTypes());
        saveTypesRecursively(documentTypes());
        saveTypesRecursively(attributeTypes());
        saveGlobalElements(globalElements());
        saveGlobalAttributes(globalAttributes());
        saveModelGroups(modelGroups());
        saveAttributeGroups(attributeGroups());
        saveIdentityConstraints(identityConstraints());
        saveTypesRecursively(redefinedGlobalTypes());
        saveModelGroups(redefinedModelGroups());
        saveAttributeGroups(redefinedAttributeGroups());
        saveIndex();
        savePointers();
        saveLoader();
    }

    public void saveAttributeGroup(SchemaAttributeGroup schemaAttributeGroup) {
        if (this._incomplete) {
            throw new IllegalStateException("This SchemaTypeSystem cannot be saved.");
        }
        String strHandleForAttributeGroup = this._localHandles.handleForAttributeGroup(schemaAttributeGroup);
        XsbReader xsbReader = new XsbReader(strHandleForAttributeGroup);
        xsbReader.writeAttributeGroupData(schemaAttributeGroup);
        xsbReader.writeRealHeader(strHandleForAttributeGroup, 7);
        xsbReader.writeAttributeGroupData(schemaAttributeGroup);
        xsbReader.writeEnd();
    }

    public void saveAttributeGroups(SchemaAttributeGroup[] schemaAttributeGroupArr) {
        if (this._incomplete) {
            throw new IllegalStateException("This SchemaTypeSystem cannot be saved.");
        }
        for (SchemaAttributeGroup schemaAttributeGroup : schemaAttributeGroupArr) {
            saveAttributeGroup(schemaAttributeGroup);
        }
    }

    public void saveGlobalAttribute(SchemaGlobalAttribute schemaGlobalAttribute) {
        if (this._incomplete) {
            throw new IllegalStateException("This SchemaTypeSystem cannot be saved.");
        }
        String strHandleForAttribute = this._localHandles.handleForAttribute(schemaGlobalAttribute);
        XsbReader xsbReader = new XsbReader(strHandleForAttribute);
        xsbReader.writeAttributeData(schemaGlobalAttribute);
        xsbReader.writeString(schemaGlobalAttribute.getSourceName());
        xsbReader.writeRealHeader(strHandleForAttribute, 4);
        xsbReader.writeAttributeData(schemaGlobalAttribute);
        xsbReader.writeString(schemaGlobalAttribute.getSourceName());
        xsbReader.writeEnd();
    }

    public void saveGlobalAttributes(SchemaGlobalAttribute[] schemaGlobalAttributeArr) {
        if (this._incomplete) {
            throw new IllegalStateException("This SchemaTypeSystem cannot be saved.");
        }
        for (SchemaGlobalAttribute schemaGlobalAttribute : schemaGlobalAttributeArr) {
            saveGlobalAttribute(schemaGlobalAttribute);
        }
    }

    public void saveGlobalElement(SchemaGlobalElement schemaGlobalElement) {
        if (this._incomplete) {
            throw new IllegalStateException("This SchemaTypeSystem cannot be saved.");
        }
        String strHandleForElement = this._localHandles.handleForElement(schemaGlobalElement);
        XsbReader xsbReader = new XsbReader(strHandleForElement);
        xsbReader.writeParticleData((SchemaParticle) schemaGlobalElement);
        xsbReader.writeString(schemaGlobalElement.getSourceName());
        xsbReader.writeRealHeader(strHandleForElement, 3);
        xsbReader.writeParticleData((SchemaParticle) schemaGlobalElement);
        xsbReader.writeString(schemaGlobalElement.getSourceName());
        xsbReader.writeEnd();
    }

    public void saveGlobalElements(SchemaGlobalElement[] schemaGlobalElementArr) {
        if (this._incomplete) {
            throw new IllegalStateException("This SchemaTypeSystem cannot be saved.");
        }
        for (SchemaGlobalElement schemaGlobalElement : schemaGlobalElementArr) {
            saveGlobalElement(schemaGlobalElement);
        }
    }

    public void saveIdentityConstraint(SchemaIdentityConstraint schemaIdentityConstraint) {
        if (this._incomplete) {
            throw new IllegalStateException("This SchemaTypeSystem cannot be saved.");
        }
        String strHandleForIdentityConstraint = this._localHandles.handleForIdentityConstraint(schemaIdentityConstraint);
        XsbReader xsbReader = new XsbReader(strHandleForIdentityConstraint);
        xsbReader.writeIdConstraintData(schemaIdentityConstraint);
        xsbReader.writeRealHeader(strHandleForIdentityConstraint, 8);
        xsbReader.writeIdConstraintData(schemaIdentityConstraint);
        xsbReader.writeEnd();
    }

    public void saveIdentityConstraints(SchemaIdentityConstraint[] schemaIdentityConstraintArr) {
        if (this._incomplete) {
            throw new IllegalStateException("This SchemaTypeSystem cannot be saved.");
        }
        for (SchemaIdentityConstraint schemaIdentityConstraint : schemaIdentityConstraintArr) {
            saveIdentityConstraint(schemaIdentityConstraint);
        }
    }

    public void saveIndex() {
        XsbReader xsbReader = new XsbReader("index");
        xsbReader.writeIndexData();
        xsbReader.writeRealHeader("index", 1);
        xsbReader.writeIndexData();
        xsbReader.writeEnd();
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00fd A[Catch: Exception -> 0x0122, TRY_ENTER, TRY_LEAVE, TryCatch #9 {Exception -> 0x0122, blocks: (B:40:0x00fd, B:52:0x011f), top: B:68:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void saveLoader() throws Throwable {
        OutputStream outputStream;
        OutputStream outputStream2;
        InputStream resourceAsStream;
        String strIndexClassForSystem = SchemaTypeCodePrinter.indexClassForSystem(this);
        String[] strArrMakeClassStrings = makeClassStrings(strIndexClassForSystem);
        if (!$assertionsDisabled && strArrMakeClassStrings.length != HOLDER_TEMPLATE_NAMES.length) {
            throw new AssertionError();
        }
        FilerImpl filerImpl = this._filer;
        InputStream inputStream = null;
        Repackager repackager = filerImpl instanceof FilerImpl ? filerImpl.getRepackager() : null;
        try {
            try {
                Class clsClass$ = class$org$apache$xmlbeans$impl$schema$SchemaTypeSystemImpl;
                if (clsClass$ == null) {
                    clsClass$ = class$("org.apache.xmlbeans.impl.schema.SchemaTypeSystemImpl");
                    class$org$apache$xmlbeans$impl$schema$SchemaTypeSystemImpl = clsClass$;
                }
                resourceAsStream = clsClass$.getResourceAsStream(HOLDER_TEMPLATE_CLASSFILE);
            } catch (Exception unused) {
                return;
            }
        } catch (IOException unused2) {
            outputStream2 = null;
        } catch (Throwable th) {
            th = th;
            outputStream = null;
        }
        try {
            if (resourceAsStream == null) {
                throw new SchemaTypeLoaderException("couldn't find resource: TypeSystemHolder.template", this._name, null, 9);
            }
            DataInputStream dataInputStream = new DataInputStream(resourceAsStream);
            Filer filer = this._filer;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(strIndexClassForSystem.replace('.', '/'));
            stringBuffer.append(".class");
            OutputStream outputStreamCreateBinaryFile = filer.createBinaryFile(stringBuffer.toString());
            DataOutputStream dataOutputStream = new DataOutputStream(outputStreamCreateBinaryFile);
            dataOutputStream.writeInt(dataInputStream.readInt());
            dataOutputStream.writeShort(dataInputStream.readUnsignedShort());
            dataOutputStream.writeShort(dataInputStream.readUnsignedShort());
            int unsignedShort = dataInputStream.readUnsignedShort();
            dataOutputStream.writeShort(unsignedShort);
            for (int i = 1; i < unsignedShort; i++) {
                int unsignedByte = dataInputStream.readUnsignedByte();
                dataOutputStream.writeByte(unsignedByte);
                switch (unsignedByte) {
                    case 1:
                        dataOutputStream.writeUTF(repackageConstant(dataInputStream.readUTF(), strArrMakeClassStrings, repackager));
                        break;
                    case 2:
                    default:
                        StringBuffer stringBuffer2 = new StringBuffer();
                        stringBuffer2.append("Unexpected constant type: ");
                        stringBuffer2.append(unsignedByte);
                        throw new RuntimeException(stringBuffer2.toString());
                    case 3:
                    case 4:
                        dataOutputStream.writeInt(dataInputStream.readInt());
                        break;
                    case 5:
                    case 6:
                        dataOutputStream.writeInt(dataInputStream.readInt());
                        dataOutputStream.writeInt(dataInputStream.readInt());
                        break;
                    case 7:
                    case 8:
                        dataOutputStream.writeShort(dataInputStream.readUnsignedShort());
                        break;
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                        dataOutputStream.writeShort(dataInputStream.readUnsignedShort());
                        dataOutputStream.writeShort(dataInputStream.readUnsignedShort());
                        break;
                }
            }
            while (true) {
                try {
                    try {
                        dataOutputStream.writeByte(dataInputStream.readByte());
                    } catch (Exception unused3) {
                        if (outputStreamCreateBinaryFile == null) {
                            outputStreamCreateBinaryFile.close();
                        }
                        return;
                    }
                } catch (EOFException unused4) {
                    resourceAsStream.close();
                    if (outputStreamCreateBinaryFile == null) {
                    }
                }
            }
        } catch (IOException unused5) {
            outputStream2 = null;
            inputStream = resourceAsStream;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception unused6) {
                }
            }
            if (outputStream2 != null) {
                outputStream2.close();
            }
        } catch (Throwable th2) {
            th = th2;
            outputStream = null;
            inputStream = resourceAsStream;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception unused7) {
                }
            }
            if (outputStream == null) {
                throw th;
            }
            try {
                outputStream.close();
                throw th;
            } catch (Exception unused8) {
                throw th;
            }
        }
    }

    public void saveModelGroup(SchemaModelGroup schemaModelGroup) {
        if (this._incomplete) {
            throw new IllegalStateException("This SchemaTypeSystem cannot be saved.");
        }
        String strHandleForModelGroup = this._localHandles.handleForModelGroup(schemaModelGroup);
        XsbReader xsbReader = new XsbReader(strHandleForModelGroup);
        xsbReader.writeModelGroupData(schemaModelGroup);
        xsbReader.writeRealHeader(strHandleForModelGroup, 6);
        xsbReader.writeModelGroupData(schemaModelGroup);
        xsbReader.writeEnd();
    }

    public void saveModelGroups(SchemaModelGroup[] schemaModelGroupArr) {
        if (this._incomplete) {
            throw new IllegalStateException("This SchemaTypeSystem cannot be saved.");
        }
        for (SchemaModelGroup schemaModelGroup : schemaModelGroupArr) {
            saveModelGroup(schemaModelGroup);
        }
    }

    public void savePointerFile(String str, String str2) {
        XsbReader xsbReader = new XsbReader(str);
        xsbReader.writeString(str2);
        xsbReader.writeRealHeader(str, 5);
        xsbReader.writeString(str2);
        xsbReader.writeEnd();
    }

    public void savePointers() {
        savePointersForComponents(globalElements(), AbstractC8014b.m7199a(new StringBuffer("schema"), METADATA_PACKAGE_GEN, "/element/"));
        savePointersForComponents(globalAttributes(), AbstractC8014b.m7199a(new StringBuffer("schema"), METADATA_PACKAGE_GEN, "/attribute/"));
        savePointersForComponents(modelGroups(), AbstractC8014b.m7199a(new StringBuffer("schema"), METADATA_PACKAGE_GEN, "/modelgroup/"));
        savePointersForComponents(attributeGroups(), AbstractC8014b.m7199a(new StringBuffer("schema"), METADATA_PACKAGE_GEN, "/attributegroup/"));
        savePointersForComponents(globalTypes(), AbstractC8014b.m7199a(new StringBuffer("schema"), METADATA_PACKAGE_GEN, "/type/"));
        savePointersForComponents(identityConstraints(), AbstractC8014b.m7199a(new StringBuffer("schema"), METADATA_PACKAGE_GEN, "/identityconstraint/"));
        Set set = this._namespaces;
        StringBuffer stringBuffer = new StringBuffer("schema");
        stringBuffer.append(METADATA_PACKAGE_GEN);
        stringBuffer.append("/namespace/");
        savePointersForNamespaces(set, stringBuffer.toString());
        Set setKeySet = this._typeRefsByClassname.keySet();
        StringBuffer stringBuffer2 = new StringBuffer("schema");
        stringBuffer2.append(METADATA_PACKAGE_GEN);
        stringBuffer2.append("/javaname/");
        savePointersForClassnames(setKeySet, stringBuffer2.toString());
        savePointersForComponents(redefinedModelGroups(), AbstractC8014b.m7199a(new StringBuffer("schema"), METADATA_PACKAGE_GEN, "/redefinedmodelgroup/"));
        savePointersForComponents(redefinedAttributeGroups(), AbstractC8014b.m7199a(new StringBuffer("schema"), METADATA_PACKAGE_GEN, "/redefinedattributegroup/"));
        savePointersForComponents(redefinedGlobalTypes(), AbstractC8014b.m7199a(new StringBuffer("schema"), METADATA_PACKAGE_GEN, "/redefinedtype/"));
    }

    public void savePointersForClassnames(Set set, String str) {
        Iterator it = set.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append(str2.replace('.', '/'));
            savePointerFile(stringBuffer.toString(), this._name);
        }
    }

    public void savePointersForComponents(SchemaComponent[] schemaComponentArr, String str) {
        for (SchemaComponent schemaComponent : schemaComponentArr) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append(QNameHelper.hexsafedir(schemaComponent.getName()));
            savePointerFile(stringBuffer.toString(), this._name);
        }
    }

    public void savePointersForNamespaces(Set set, String str) {
        Iterator it = set.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append(QNameHelper.hexsafedir(new QName(str2, XMLConstants.XMLNS_ATTRIBUTE)));
            savePointerFile(stringBuffer.toString(), this._name);
        }
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public void saveToDirectory(File file) throws Throwable {
        save(new FilerImpl(file, (File) null, (Repackager) null, false, false));
    }

    public void saveType(SchemaType schemaType) {
        String strHandleForType = this._localHandles.handleForType(schemaType);
        XsbReader xsbReader = new XsbReader(strHandleForType);
        xsbReader.writeTypeData(schemaType);
        xsbReader.writeRealHeader(strHandleForType, 2);
        xsbReader.writeTypeData(schemaType);
        xsbReader.writeEnd();
    }

    public void saveTypesRecursively(SchemaType[] schemaTypeArr) {
        for (int i = 0; i < schemaTypeArr.length; i++) {
            if (schemaTypeArr[i].getTypeSystem() == getTypeSystem()) {
                saveType(schemaTypeArr[i]);
                saveTypesRecursively(schemaTypeArr[i].getAnonymousTypes());
            }
        }
    }

    public void setDependencies(SchemaDependencies schemaDependencies) {
        this._deps = schemaDependencies;
    }

    public void setIncomplete(boolean z) {
        this._incomplete = z;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType typeForClassname(String str) {
        SchemaType.Ref ref = (SchemaType.Ref) this._typeRefsByClassname.get(str);
        if (ref != null) {
            return ref.get();
        }
        return null;
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public SchemaType typeForHandle(String str) {
        SchemaType schemaType;
        synchronized (this._resolvedHandles) {
            schemaType = (SchemaType) this._resolvedHandles.get(str);
        }
        return schemaType;
    }

    public SchemaTypeSystem typeSystemForName(String str) {
        String str2 = this._name;
        if (str2 == null || !str.equals(str2)) {
            return null;
        }
        return this;
    }

    private Map buildTypeRefsByClassname(Map map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String str : map.keySet()) {
            linkedHashMap.put(str, ((SchemaType) map.get(str)).getRef());
        }
        return linkedHashMap;
    }

    public final SchemaTypeSystemImpl getTypeSystem() {
        return this;
    }

    public SchemaTypeSystemImpl(ResourceLoader resourceLoader, String str, SchemaTypeLoader schemaTypeLoader) throws Throwable {
        this._name = str;
        this._basePackage = nameToPathString(str);
        this._linker = schemaTypeLoader;
        this._resourceLoader = resourceLoader;
        try {
            initFromHeader();
        } catch (Error e) {
            XBeanDebug.logException(e);
            throw e;
        } catch (RuntimeException e2) {
            XBeanDebug.logException(e2);
            throw e2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class XsbReader {
        static final /* synthetic */ boolean $assertionsDisabled;
        int _actualfiletype;
        String _handle;
        DataInputStream _input;
        private int _majorver;
        private int _minorver;
        DataOutputStream _output;
        private int _releaseno;
        StringPool _stringPool;

        static {
            if (SchemaTypeSystemImpl.class$org$apache$xmlbeans$impl$schema$SchemaTypeSystemImpl == null) {
                SchemaTypeSystemImpl.class$org$apache$xmlbeans$impl$schema$SchemaTypeSystemImpl = SchemaTypeSystemImpl.class$("org.apache.xmlbeans.impl.schema.SchemaTypeSystemImpl");
            }
            $assertionsDisabled = true;
        }

        public XsbReader(String str, int i) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(SchemaTypeSystemImpl.this._basePackage);
            stringBuffer.append(str);
            stringBuffer.append(".xsb");
            String string = stringBuffer.toString();
            InputStream loaderStream = getLoaderStream(string);
            if (loaderStream == null) {
                throw new SchemaTypeLoaderException(AbstractC14516b.m15113a("XML-BEANS compiled schema: Could not locate compiled schema resource ", string), SchemaTypeSystemImpl.this._name, str, 0);
            }
            this._input = new DataInputStream(loaderStream);
            this._handle = str;
            if (readInt() != -629491010) {
                throw new SchemaTypeLoaderException("XML-BEANS compiled schema: Wrong magic cookie", SchemaTypeSystemImpl.this._name, str, 1);
            }
            this._majorver = readShort();
            int i2 = readShort();
            this._minorver = i2;
            if (this._majorver != 2) {
                StringBuffer stringBuffer2 = new StringBuffer("XML-BEANS compiled schema: Wrong major version - expecting 2, got ");
                stringBuffer2.append(this._majorver);
                throw new SchemaTypeLoaderException(stringBuffer2.toString(), SchemaTypeSystemImpl.this._name, str, 2);
            }
            if (i2 > 24) {
                StringBuffer stringBuffer3 = new StringBuffer("XML-BEANS compiled schema: Incompatible minor version - expecting up to 24, got ");
                stringBuffer3.append(this._minorver);
                throw new SchemaTypeLoaderException(stringBuffer3.toString(), SchemaTypeSystemImpl.this._name, str, 3);
            }
            if (i2 < 14) {
                StringBuffer stringBuffer4 = new StringBuffer("XML-BEANS compiled schema: Incompatible minor version - expecting at least 14, got ");
                stringBuffer4.append(this._minorver);
                throw new SchemaTypeLoaderException(stringBuffer4.toString(), SchemaTypeSystemImpl.this._name, str, 3);
            }
            if (atLeast(2, 18, 0)) {
                this._releaseno = readShort();
            }
            int i4 = readShort();
            if (i4 == i || i == 65535) {
                StringPool stringPool = new StringPool(this._handle, SchemaTypeSystemImpl.this._name);
                this._stringPool = stringPool;
                stringPool.readFrom(this._input);
                this._actualfiletype = i4;
                return;
            }
            StringBuffer stringBuffer5 = new StringBuffer("XML-BEANS compiled schema: File has the wrong type - expecting type ");
            stringBuffer5.append(i);
            stringBuffer5.append(", got type ");
            stringBuffer5.append(i4);
            throw new SchemaTypeLoaderException(stringBuffer5.toString(), SchemaTypeSystemImpl.this._name, str, 4);
        }

        public boolean atLeast(int i, int i2, int i4) {
            int i5 = this._majorver;
            if (i5 > i) {
                return true;
            }
            if (i5 < i) {
                return false;
            }
            int i6 = this._minorver;
            if (i6 > i2) {
                return true;
            }
            return i6 >= i2 && this._releaseno >= i4;
        }

        public boolean atMost(int i, int i2, int i4) {
            int i5 = this._majorver;
            if (i5 > i) {
                return false;
            }
            if (i5 < i) {
                return true;
            }
            int i6 = this._minorver;
            if (i6 > i2) {
                return false;
            }
            return i6 < i2 || this._releaseno <= i4;
        }

        public void checkContainerNotNull(SchemaContainer schemaContainer, QName qName) {
            if (schemaContainer != null) {
                return;
            }
            StringBuffer stringBuffer = new StringBuffer("Loading of resource ");
            stringBuffer.append(SchemaTypeSystemImpl.this._name);
            stringBuffer.append('.');
            stringBuffer.append(this._handle);
            stringBuffer.append("failed, information from ");
            stringBuffer.append(SchemaTypeSystemImpl.this._name);
            stringBuffer.append(".index.xsb is  out of sync (or conflicting index files found)");
            throw new LinkageError(stringBuffer.toString());
        }

        public int fileTypeFromComponentType(int i) {
            if (i == 0) {
                return 2;
            }
            if (i == 1) {
                return 3;
            }
            if (i == 3) {
                return 4;
            }
            if (i == 4) {
                return 7;
            }
            if (i == 5) {
                return 8;
            }
            if (i == 6) {
                return 6;
            }
            throw new IllegalStateException("Unexpected component type");
        }

        public SchemaGlobalAttribute finishLoadingAttribute() {
            try {
                try {
                    try {
                        QName qName = readQName();
                        SchemaContainer container = SchemaTypeSystemImpl.this.getContainer(qName.getNamespaceURI());
                        checkContainerNotNull(container, qName);
                        SchemaGlobalAttributeImpl schemaGlobalAttributeImpl = new SchemaGlobalAttributeImpl(container);
                        loadAttribute(schemaGlobalAttributeImpl, qName, container);
                        schemaGlobalAttributeImpl.setFilename(readString());
                        return schemaGlobalAttributeImpl;
                    } catch (Exception e) {
                        throw new SchemaTypeLoaderException("Cannot load type from typesystem", SchemaTypeSystemImpl.this._name, this._handle, 14, e);
                    }
                } catch (SchemaTypeLoaderException e2) {
                    throw e2;
                }
            } finally {
                readEnd();
            }
        }

        public SchemaAttributeGroup finishLoadingAttributeGroup() {
            SchemaContainer schemaContainer;
            boolean z;
            QName qName = readQName();
            SchemaContainer container = SchemaTypeSystemImpl.this.getContainer(qName.getNamespaceURI());
            checkContainerNotNull(container, qName);
            SchemaAttributeGroupImpl schemaAttributeGroupImpl = new SchemaAttributeGroupImpl(container);
            try {
                try {
                    String string = readString();
                    boolean z2 = true;
                    if (readShort() == 1) {
                        schemaContainer = container;
                        z = true;
                    } else {
                        schemaContainer = container;
                        z = false;
                    }
                    String string2 = atLeast(2, 22, 0) ? readString() : null;
                    if (!atLeast(2, 15, 0) || readShort() != 1) {
                        z2 = false;
                    }
                    schemaAttributeGroupImpl.init(qName, string, z, string2, z2, AttributeGroupDocument.Factory.parse(readString()).getAttributeGroup(), readAnnotation(schemaContainer), (Object) null);
                    if (atLeast(2, 21, 0)) {
                        schemaAttributeGroupImpl.setFilename(readString());
                    }
                    readEnd();
                    return schemaAttributeGroupImpl;
                } catch (SchemaTypeLoaderException e) {
                    throw e;
                } catch (Exception e2) {
                    throw new SchemaTypeLoaderException("Cannot load type from typesystem", SchemaTypeSystemImpl.this._name, this._handle, 14, e2);
                }
            } catch (Throwable th) {
                readEnd();
                throw th;
            }
        }

        public SchemaGlobalElement finishLoadingElement() {
            try {
                try {
                    int i = readShort();
                    if (i != 4) {
                        throw new SchemaTypeLoaderException("Wrong particle type ", SchemaTypeSystemImpl.this._name, this._handle, 11);
                    }
                    int i2 = readShort();
                    BigInteger bigInteger = readBigInteger();
                    BigInteger bigInteger2 = readBigInteger();
                    QNameSet qNameSet = readQNameSet();
                    QName qName = readQName();
                    SchemaContainer container = SchemaTypeSystemImpl.this.getContainer(qName.getNamespaceURI());
                    checkContainerNotNull(container, qName);
                    SchemaGlobalElementImpl schemaGlobalElementImpl = new SchemaGlobalElementImpl(container);
                    schemaGlobalElementImpl.setParticleType(i);
                    schemaGlobalElementImpl.setMinOccurs(bigInteger);
                    schemaGlobalElementImpl.setMaxOccurs(bigInteger2);
                    boolean z = true;
                    schemaGlobalElementImpl.setTransitionRules(qNameSet, (i2 & 1) != 0);
                    schemaGlobalElementImpl.setNameAndTypeRef(qName, readTypeRef());
                    schemaGlobalElementImpl.setDefault(readString(), (i2 & 4) != 0, null);
                    if (atLeast(2, 16, 0)) {
                        schemaGlobalElementImpl.setDefaultValue(readXmlValueObject());
                    }
                    schemaGlobalElementImpl.setNillable((i2 & 8) != 0);
                    schemaGlobalElementImpl.setBlock((i2 & 16) != 0, (i2 & 32) != 0, (i2 & 64) != 0);
                    schemaGlobalElementImpl.setWsdlArrayType(readSOAPArrayType());
                    schemaGlobalElementImpl.setAbstract((i2 & 128) != 0);
                    schemaGlobalElementImpl.setAnnotation(readAnnotation(container));
                    boolean z2 = (i2 & 256) != 0;
                    if ((i2 & 512) == 0) {
                        z = false;
                    }
                    schemaGlobalElementImpl.setFinal(z2, z);
                    if (atLeast(2, 17, 0)) {
                        schemaGlobalElementImpl.setSubstitutionGroup((SchemaGlobalElement.Ref) readHandle());
                    }
                    int i4 = readShort();
                    for (int i5 = 0; i5 < i4; i5++) {
                        schemaGlobalElementImpl.addSubstitutionGroupMember(readQName());
                    }
                    int i6 = readShort();
                    SchemaIdentityConstraint.Ref[] refArr = new SchemaIdentityConstraint.Ref[i6];
                    for (int i7 = 0; i7 < i6; i7++) {
                        refArr[i7] = (SchemaIdentityConstraint.Ref) readHandle();
                    }
                    schemaGlobalElementImpl.setIdentityConstraints(refArr);
                    schemaGlobalElementImpl.setFilename(readString());
                    readEnd();
                    return schemaGlobalElementImpl;
                } catch (SchemaTypeLoaderException e) {
                    throw e;
                } catch (Exception e2) {
                    throw new SchemaTypeLoaderException("Cannot load type from typesystem", SchemaTypeSystemImpl.this._name, null, 14, e2);
                }
            } catch (Throwable th) {
                readEnd();
                throw th;
            }
        }

        public SchemaIdentityConstraint finishLoadingIdentityConstraint() {
            try {
                try {
                    try {
                        QName qName = readQName();
                        SchemaContainer container = SchemaTypeSystemImpl.this.getContainer(qName.getNamespaceURI());
                        checkContainerNotNull(container, qName);
                        SchemaIdentityConstraintImpl schemaIdentityConstraintImpl = new SchemaIdentityConstraintImpl(container);
                        schemaIdentityConstraintImpl.setName(qName);
                        schemaIdentityConstraintImpl.setConstraintCategory(readShort());
                        schemaIdentityConstraintImpl.setSelector(readString());
                        schemaIdentityConstraintImpl.setAnnotation(readAnnotation(container));
                        int i = readShort();
                        String[] strArr = new String[i];
                        for (int i2 = 0; i2 < i; i2++) {
                            strArr[i2] = readString();
                        }
                        schemaIdentityConstraintImpl.setFields(strArr);
                        if (schemaIdentityConstraintImpl.getConstraintCategory() == 2) {
                            schemaIdentityConstraintImpl.setReferencedKey((SchemaIdentityConstraint.Ref) readHandle());
                        }
                        int i4 = readShort();
                        HashMap map = new HashMap();
                        for (int i5 = 0; i5 < i4; i5++) {
                            map.put(readString(), readString());
                        }
                        schemaIdentityConstraintImpl.setNSMap(map);
                        if (atLeast(2, 21, 0)) {
                            schemaIdentityConstraintImpl.setFilename(readString());
                        }
                        readEnd();
                        return schemaIdentityConstraintImpl;
                    } catch (SchemaTypeLoaderException e) {
                        throw e;
                    }
                } catch (Exception e2) {
                    throw new SchemaTypeLoaderException("Cannot load type from typesystem", SchemaTypeSystemImpl.this._name, this._handle, 14, e2);
                }
            } catch (Throwable th) {
                readEnd();
                throw th;
            }
        }

        public SchemaModelGroup finishLoadingModelGroup() {
            SchemaContainer schemaContainer;
            boolean z;
            QName qName = readQName();
            SchemaContainer container = SchemaTypeSystemImpl.this.getContainer(qName.getNamespaceURI());
            checkContainerNotNull(container, qName);
            SchemaModelGroupImpl schemaModelGroupImpl = new SchemaModelGroupImpl(container);
            try {
                try {
                    String string = readString();
                    if (readShort() == 1) {
                        schemaContainer = container;
                        z = true;
                    } else {
                        schemaContainer = container;
                        z = false;
                    }
                    schemaModelGroupImpl.init(qName, string, z, atLeast(2, 22, 0) ? readString() : null, atLeast(2, 22, 0) ? readString() : null, atLeast(2, 15, 0) && readShort() == 1, GroupDocument.Factory.parse(readString()).getGroup(), readAnnotation(schemaContainer), (Object) null);
                    if (atLeast(2, 21, 0)) {
                        schemaModelGroupImpl.setFilename(readString());
                    }
                    readEnd();
                    return schemaModelGroupImpl;
                } catch (SchemaTypeLoaderException e) {
                    throw e;
                } catch (Exception e2) {
                    throw new SchemaTypeLoaderException("Cannot load type from typesystem", SchemaTypeSystemImpl.this._name, this._handle, 14, e2);
                }
            } catch (Throwable th) {
                readEnd();
                throw th;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public SchemaType finishLoadingType() {
            int i;
            int i2;
            int i4;
            int i5;
            QName attributeTypeAttributeName;
            int i6;
            SchemaParticle schemaParticle;
            Map linkedHashMap;
            String str = "";
            try {
                try {
                    try {
                        SchemaTypeImpl schemaTypeImpl = new SchemaTypeImpl(SchemaTypeSystemImpl.this.getContainerNonNull(""), true);
                        schemaTypeImpl.setName(readQName());
                        schemaTypeImpl.setOuterSchemaTypeRef(readTypeRef());
                        schemaTypeImpl.setBaseDepth(readShort());
                        schemaTypeImpl.setBaseTypeRef(readTypeRef());
                        schemaTypeImpl.setDerivationType(readShort());
                        schemaTypeImpl.setAnnotation(readAnnotation(null));
                        int i7 = readShort();
                        if (i7 == 1) {
                            schemaTypeImpl.setContainerFieldRef(readHandle());
                        } else if (i7 == 2) {
                            schemaTypeImpl.setContainerFieldIndex((short) 1, readShort());
                        } else if (i7 == 3) {
                            schemaTypeImpl.setContainerFieldIndex((short) 2, readShort());
                        }
                        String string = readString();
                        if (string == null) {
                            string = "";
                        }
                        schemaTypeImpl.setFullJavaName(string);
                        String string2 = readString();
                        if (string2 != null) {
                            str = string2;
                        }
                        schemaTypeImpl.setFullJavaImplName(str);
                        schemaTypeImpl.setAnonymousTypeRefs(readTypeRefArray());
                        schemaTypeImpl.setAnonymousUnionMemberOrdinal(readShort());
                        int i8 = readInt();
                        int i9 = 0;
                        boolean z = (i8 & 1) == 0;
                        schemaTypeImpl.setCompiled((i8 & 2048) != 0);
                        schemaTypeImpl.setDocumentType((i8 & 2) != 0);
                        schemaTypeImpl.setAttributeType((524288 & i8) != 0);
                        schemaTypeImpl.setSimpleType(!z);
                        if (z) {
                            schemaTypeImpl.setAbstractFinal((262144 & i8) != 0, (i8 & 16384) != 0, (i8 & 32768) != 0, (i8 & 131072) != 0, (i8 & 65536) != 0);
                            schemaTypeImpl.setBlock((i8 & 4096) != 0, (i8 & 8192) != 0);
                            schemaTypeImpl.setOrderSensitive((i8 & 512) != 0);
                            int i10 = readShort();
                            schemaTypeImpl.setComplexTypeVariety(i10);
                            if (atLeast(2, 23, 0)) {
                                schemaTypeImpl.setContentBasedOnTypeRef(readTypeRef());
                            }
                            SchemaAttributeModelImpl schemaAttributeModelImpl = new SchemaAttributeModelImpl();
                            int i11 = readShort();
                            for (int i12 = 0; i12 < i11; i12++) {
                                schemaAttributeModelImpl.addAttribute(readAttributeData());
                            }
                            schemaAttributeModelImpl.setWildcardSet(readQNameSet());
                            schemaAttributeModelImpl.setWildcardProcess(readShort());
                            Map linkedHashMap2 = new LinkedHashMap();
                            int i13 = readShort();
                            int i14 = 0;
                            while (i14 < i13) {
                                int i15 = i9;
                                SchemaProperty propertyData = readPropertyData();
                                if (!propertyData.isAttribute()) {
                                    StringBuffer stringBuffer = new StringBuffer();
                                    stringBuffer.append("Attribute property ");
                                    stringBuffer.append(i14);
                                    stringBuffer.append(" is not an attribute");
                                    throw new SchemaTypeLoaderException(stringBuffer.toString(), SchemaTypeSystemImpl.this._name, this._handle, 6);
                                }
                                linkedHashMap2.put(propertyData.getName(), propertyData);
                                i14++;
                                i9 = i15;
                            }
                            i = i9;
                            if (i10 == 3 || i10 == 4) {
                                i6 = readShort();
                                SchemaParticle[] particleArray = readParticleArray();
                                if (particleArray.length == 1) {
                                    schemaParticle = particleArray[i];
                                } else {
                                    if (particleArray.length != 0) {
                                        throw new SchemaTypeLoaderException("Content model not well-formed", SchemaTypeSystemImpl.this._name, this._handle, 7);
                                    }
                                    schemaParticle = null;
                                }
                                linkedHashMap = new LinkedHashMap();
                                i2 = 65536;
                                int i16 = readShort();
                                i4 = 131072;
                                for (int i17 = i; i17 < i16; i17++) {
                                    SchemaProperty propertyData2 = readPropertyData();
                                    if (propertyData2.isAttribute()) {
                                        StringBuffer stringBuffer2 = new StringBuffer();
                                        stringBuffer2.append("Element property ");
                                        stringBuffer2.append(i17);
                                        stringBuffer2.append(" is not an element");
                                        throw new SchemaTypeLoaderException(stringBuffer2.toString(), SchemaTypeSystemImpl.this._name, this._handle, 6);
                                    }
                                    linkedHashMap.put(propertyData2.getName(), propertyData2);
                                }
                            } else {
                                i2 = 65536;
                                i4 = 131072;
                                i6 = i;
                                schemaParticle = null;
                                linkedHashMap = null;
                            }
                            SchemaParticle schemaParticle2 = schemaParticle;
                            schemaTypeImpl.setContentModel(schemaParticle2, schemaAttributeModelImpl, linkedHashMap, linkedHashMap2, i6 == 1 ? 1 : i);
                            StscComplexTypeResolver.WildcardResult wildcardResultSummarizeEltWildcards = StscComplexTypeResolver.summarizeEltWildcards(schemaParticle2);
                            StscComplexTypeResolver.WildcardResult wildcardResultSummarizeAttrWildcards = StscComplexTypeResolver.summarizeAttrWildcards(schemaAttributeModelImpl);
                            schemaTypeImpl.setWildcardSummary(wildcardResultSummarizeEltWildcards.typedWildcards, wildcardResultSummarizeEltWildcards.hasWildcards, wildcardResultSummarizeAttrWildcards.typedWildcards, wildcardResultSummarizeAttrWildcards.hasWildcards);
                            i5 = i10;
                        } else {
                            i = 0;
                            i2 = 65536;
                            i4 = 131072;
                            i5 = 0;
                        }
                        if (!z || i5 == 2) {
                            int i18 = readShort();
                            schemaTypeImpl.setSimpleTypeVariety(i18);
                            int i19 = (i8 & 64) != 0 ? 1 : i;
                            schemaTypeImpl.setOrdered((i8 & 4) != 0 ? i : (i8 & 1024) != 0 ? 2 : 1);
                            schemaTypeImpl.setBounded((i8 & 8) != 0 ? 1 : i);
                            schemaTypeImpl.setFinite((i8 & 16) != 0 ? 1 : i);
                            schemaTypeImpl.setNumeric((i8 & 32) != 0 ? 1 : i);
                            schemaTypeImpl.setUnionOfLists((i8 & 128) != 0 ? 1 : i);
                            schemaTypeImpl.setSimpleFinal((i8 & 32768) != 0 ? 1 : i, (i8 & i4) != 0 ? 1 : i, (i8 & i2) != 0 ? 1 : i);
                            XmlValueRef[] xmlValueRefArr = new XmlValueRef[12];
                            boolean[] zArr = new boolean[12];
                            int i20 = readShort();
                            for (int i21 = i; i21 < i20; i21++) {
                                int i22 = readShort();
                                xmlValueRefArr[i22] = readXmlValueObject();
                                zArr[i22] = readShort() == 1 ? true : i;
                            }
                            schemaTypeImpl.setBasicFacets(xmlValueRefArr, zArr);
                            schemaTypeImpl.setWhiteSpaceRule(readShort());
                            schemaTypeImpl.setPatternFacet((i8 & 256) != 0 ? 1 : i);
                            int i23 = readShort();
                            RegularExpression[] regularExpressionArr = new RegularExpression[i23];
                            for (int i24 = i; i24 < i23; i24++) {
                                regularExpressionArr[i24] = new RegularExpression(readString(), "X");
                            }
                            schemaTypeImpl.setPatterns(regularExpressionArr);
                            int i25 = readShort();
                            XmlValueRef[] xmlValueRefArr2 = new XmlValueRef[i25];
                            for (int i26 = i; i26 < i25; i26++) {
                                xmlValueRefArr2[i26] = readXmlValueObject();
                            }
                            if (i25 == 0) {
                                xmlValueRefArr2 = null;
                            }
                            schemaTypeImpl.setEnumerationValues(xmlValueRefArr2);
                            schemaTypeImpl.setBaseEnumTypeRef(readTypeRef());
                            if (i19 != 0) {
                                int i27 = readShort();
                                SchemaStringEnumEntry[] schemaStringEnumEntryArr = new SchemaStringEnumEntry[i27];
                                for (int i28 = i; i28 < i27; i28++) {
                                    schemaStringEnumEntryArr[i28] = new SchemaStringEnumEntryImpl(readString(), readShort(), readString());
                                }
                                schemaTypeImpl.setStringEnumEntries(schemaStringEnumEntryArr);
                            }
                            if (i18 == 1) {
                                schemaTypeImpl.setPrimitiveTypeRef(readTypeRef());
                                schemaTypeImpl.setDecimalSize(readInt());
                            } else if (i18 == 2) {
                                schemaTypeImpl.setPrimitiveTypeRef(BuiltinSchemaTypeSystem.ST_ANY_SIMPLE.getRef());
                                schemaTypeImpl.setUnionMemberTypeRefs(readTypeRefArray());
                            } else {
                                if (i18 != 3) {
                                    throw new SchemaTypeLoaderException("Simple type does not have a recognized variety", SchemaTypeSystemImpl.this._name, this._handle, 8);
                                }
                                schemaTypeImpl.setPrimitiveTypeRef(BuiltinSchemaTypeSystem.ST_ANY_SIMPLE.getRef());
                                schemaTypeImpl.setListItemTypeRef(readTypeRef());
                            }
                        }
                        schemaTypeImpl.setFilename(readString());
                        if (schemaTypeImpl.getName() != null) {
                            SchemaContainer container = SchemaTypeSystemImpl.this.getContainer(schemaTypeImpl.getName().getNamespaceURI());
                            checkContainerNotNull(container, schemaTypeImpl.getName());
                            schemaTypeImpl.setContainer(container);
                        } else if (schemaTypeImpl.isDocumentType()) {
                            QName documentElementName = schemaTypeImpl.getDocumentElementName();
                            if (documentElementName != null) {
                                SchemaContainer container2 = SchemaTypeSystemImpl.this.getContainer(documentElementName.getNamespaceURI());
                                checkContainerNotNull(container2, documentElementName);
                                schemaTypeImpl.setContainer(container2);
                            }
                        } else if (schemaTypeImpl.isAttributeType() && (attributeTypeAttributeName = schemaTypeImpl.getAttributeTypeAttributeName()) != null) {
                            SchemaContainer container3 = SchemaTypeSystemImpl.this.getContainer(attributeTypeAttributeName.getNamespaceURI());
                            checkContainerNotNull(container3, attributeTypeAttributeName);
                            schemaTypeImpl.setContainer(container3);
                        }
                        readEnd();
                        return schemaTypeImpl;
                    } catch (SchemaTypeLoaderException e) {
                        throw e;
                    }
                } catch (Exception e2) {
                    throw new SchemaTypeLoaderException("Cannot load type from typesystem", SchemaTypeSystemImpl.this._name, this._handle, 14, e2);
                }
            } catch (Throwable th) {
                readEnd();
                throw th;
            }
        }

        public int getActualFiletype() {
            return this._actualfiletype;
        }

        public InputStream getLoaderStream(String str) {
            return SchemaTypeSystemImpl.this._resourceLoader.getResourceAsStream(str);
        }

        public OutputStream getSaverStream(String str) {
            try {
                return SchemaTypeSystemImpl.this._filer.createBinaryFile(str);
            } catch (IOException e) {
                throw new SchemaTypeLoaderException(e.getMessage(), SchemaTypeSystemImpl.this._name, this._handle, 9);
            }
        }

        public void loadAttribute(SchemaLocalAttributeImpl schemaLocalAttributeImpl, QName qName, SchemaContainer schemaContainer) {
            schemaLocalAttributeImpl.init(qName, readTypeRef(), readShort(), readString(), null, atLeast(2, 16, 0) ? readXmlValueObject() : null, readShort() == 1, readSOAPArrayType(), readAnnotation(schemaContainer), null);
        }

        public void loadParticle(SchemaParticleImpl schemaParticleImpl, int i) {
            int i2 = readShort();
            schemaParticleImpl.setParticleType(i);
            schemaParticleImpl.setMinOccurs(readBigInteger());
            schemaParticleImpl.setMaxOccurs(readBigInteger());
            schemaParticleImpl.setTransitionRules(readQNameSet(), (i2 & 1) != 0);
            if (i == 1 || i == 2 || i == 3) {
                schemaParticleImpl.setParticleChildren(readParticleArray());
                return;
            }
            if (i != 4) {
                if (i != 5) {
                    throw new SchemaTypeLoaderException("Unrecognized particle type ", SchemaTypeSystemImpl.this._name, this._handle, 11);
                }
                schemaParticleImpl.setWildcardSet(readQNameSet());
                schemaParticleImpl.setWildcardProcess(readShort());
                return;
            }
            SchemaLocalElementImpl schemaLocalElementImpl = (SchemaLocalElementImpl) schemaParticleImpl;
            schemaLocalElementImpl.setNameAndTypeRef(readQName(), readTypeRef());
            schemaLocalElementImpl.setDefault(readString(), (i2 & 4) != 0, null);
            if (atLeast(2, 16, 0)) {
                schemaLocalElementImpl.setDefaultValue(readXmlValueObject());
            }
            schemaLocalElementImpl.setNillable((i2 & 8) != 0);
            schemaLocalElementImpl.setBlock((i2 & 16) != 0, (i2 & 32) != 0, (i2 & 64) != 0);
            schemaLocalElementImpl.setWsdlArrayType(readSOAPArrayType());
            schemaLocalElementImpl.setAbstract((i2 & 128) != 0);
            schemaLocalElementImpl.setAnnotation(readAnnotation(null));
            int i4 = readShort();
            SchemaIdentityConstraint.Ref[] refArr = new SchemaIdentityConstraint.Ref[i4];
            for (int i5 = 0; i5 < i4; i5++) {
                refArr[i5] = (SchemaIdentityConstraint.Ref) readHandle();
            }
            schemaLocalElementImpl.setIdentityConstraints(refArr);
        }

        public SchemaAnnotation readAnnotation(SchemaContainer schemaContainer) {
            int i;
            if (!atLeast(2, 19, 0) || (i = readInt()) == -1) {
                return null;
            }
            SchemaAnnotation.Attribute[] attributeArr = new SchemaAnnotation.Attribute[i];
            for (int i2 = 0; i2 < i; i2++) {
                attributeArr[i2] = new SchemaAnnotationImpl.AttributeImpl(readQName(), readString(), atLeast(2, 24, 0) ? readString() : null);
            }
            int i4 = readInt();
            String[] strArr = new String[i4];
            for (int i5 = 0; i5 < i4; i5++) {
                strArr[i5] = readString();
            }
            int i6 = readInt();
            String[] strArr2 = new String[i6];
            for (int i7 = 0; i7 < i6; i7++) {
                strArr2[i7] = readString();
            }
            return new SchemaAnnotationImpl(schemaContainer, strArr2, strArr, attributeArr);
        }

        public List readAnnotations() {
            int i = readInt();
            ArrayList arrayList = new ArrayList(i);
            SchemaContainer containerNonNull = SchemaTypeSystemImpl.this.getContainerNonNull("");
            for (int i2 = 0; i2 < i; i2++) {
                arrayList.add(readAnnotation(containerNonNull));
            }
            return arrayList;
        }

        public SchemaLocalAttribute readAttributeData() {
            SchemaLocalAttributeImpl schemaLocalAttributeImpl = new SchemaLocalAttributeImpl();
            loadAttribute(schemaLocalAttributeImpl, readQName(), null);
            return schemaLocalAttributeImpl;
        }

        public BigInteger readBigInteger() {
            byte[] byteArray = readByteArray();
            if (byteArray.length == 0) {
                return null;
            }
            return (byteArray.length == 1 && byteArray[0] == 0) ? BigInteger.ZERO : (byteArray.length == 1 && byteArray[0] == 1) ? BigInteger.ONE : new BigInteger(byteArray);
        }

        public byte[] readByteArray() {
            try {
                byte[] bArr = new byte[this._input.readShort()];
                this._input.readFully(bArr);
                return bArr;
            } catch (IOException e) {
                throw new SchemaTypeLoaderException(e.getMessage(), SchemaTypeSystemImpl.this._name, this._handle, 9);
            }
        }

        public Map readClassnameRefMap() {
            HashMap map = new HashMap();
            int i = readShort();
            for (int i2 = 0; i2 < i; i2++) {
                map.put(readString(), readHandle());
            }
            return map;
        }

        public double readDouble() {
            try {
                return this._input.readDouble();
            } catch (IOException e) {
                throw new SchemaTypeLoaderException(e.getMessage(), SchemaTypeSystemImpl.this._name, this._handle, 9);
            }
        }

        public void readEnd() {
            try {
                DataInputStream dataInputStream = this._input;
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
            } catch (IOException unused) {
            }
            this._input = null;
            this._stringPool = null;
            this._handle = null;
        }

        public void readExtensionsList() {
            int i = readShort();
            if (!$assertionsDisabled && i != 0) {
                throw new AssertionError();
            }
            for (int i2 = 0; i2 < i; i2++) {
                readString();
                readString();
                readString();
            }
        }

        public SchemaComponent.Ref readHandle() {
            String string = readString();
            if (string == null) {
                return null;
            }
            if (string.charAt(0) != '_') {
                return SchemaTypeSystemImpl.this._localHandles.refForHandle(string);
            }
            char cCharAt = string.charAt(2);
            if (cCharAt == 'A') {
                return SchemaTypeSystemImpl.this._linker.findAttributeRef(QNameHelper.forPretty(string, 4));
            }
            if (cCharAt == 'I') {
                SchemaType schemaType = (SchemaType) BuiltinSchemaTypeSystem.get().resolveHandle(string);
                return schemaType != null ? schemaType.getRef() : ((SchemaType) XQuerySchemaTypeSystem.get().resolveHandle(string)).getRef();
            }
            if (cCharAt == 'Y') {
                SchemaType schemaTypeTypeForSignature = SchemaTypeSystemImpl.this._linker.typeForSignature(string.substring(4));
                if (schemaTypeTypeForSignature != null) {
                    return schemaTypeTypeForSignature.getRef();
                }
                throw new SchemaTypeLoaderException("Cannot resolve type for handle ".concat(string), SchemaTypeSystemImpl.this._name, this._handle, 13);
            }
            if (cCharAt == 'D') {
                return SchemaTypeSystemImpl.this._linker.findIdentityConstraintRef(QNameHelper.forPretty(string, 4));
            }
            if (cCharAt == 'E') {
                return SchemaTypeSystemImpl.this._linker.findElementRef(QNameHelper.forPretty(string, 4));
            }
            switch (cCharAt) {
                case 'M':
                    return SchemaTypeSystemImpl.this._linker.findModelGroupRef(QNameHelper.forPretty(string, 4));
                case 'N':
                    return SchemaTypeSystemImpl.this._linker.findAttributeGroupRef(QNameHelper.forPretty(string, 4));
                case 'O':
                    return SchemaTypeSystemImpl.this._linker.findDocumentTypeRef(QNameHelper.forPretty(string, 4));
                default:
                    switch (cCharAt) {
                        case 'R':
                            SchemaGlobalAttribute schemaGlobalAttributeFindAttribute = SchemaTypeSystemImpl.this._linker.findAttribute(QNameHelper.forPretty(string, 4));
                            if (schemaGlobalAttributeFindAttribute != null) {
                                return schemaGlobalAttributeFindAttribute.getType().getRef();
                            }
                            throw new SchemaTypeLoaderException("Cannot resolve attribute for handle ".concat(string), SchemaTypeSystemImpl.this._name, this._handle, 13);
                        case 'S':
                            SchemaGlobalElement schemaGlobalElementFindElement = SchemaTypeSystemImpl.this._linker.findElement(QNameHelper.forPretty(string, 4));
                            if (schemaGlobalElementFindElement != null) {
                                return schemaGlobalElementFindElement.getType().getRef();
                            }
                            throw new SchemaTypeLoaderException("Cannot resolve element for handle ".concat(string), SchemaTypeSystemImpl.this._name, this._handle, 13);
                        case 'T':
                            return SchemaTypeSystemImpl.this._linker.findTypeRef(QNameHelper.forPretty(string, 4));
                        default:
                            throw new SchemaTypeLoaderException("Cannot resolve handle ".concat(string), SchemaTypeSystemImpl.this._name, this._handle, 13);
                    }
            }
        }

        public void readHandlePool(HandlePool handlePool) {
            Object ref;
            if (handlePool._handlesToRefs.size() != 0 || handlePool._started) {
                throw new IllegalStateException("Nonempty handle set before read");
            }
            int i = readShort();
            for (int i2 = 0; i2 < i; i2++) {
                String string = readString();
                int i4 = readShort();
                if (i4 == 2) {
                    ref = new SchemaType.Ref(SchemaTypeSystemImpl.this.getTypeSystem(), string);
                } else if (i4 == 3) {
                    ref = new SchemaGlobalElement.Ref(SchemaTypeSystemImpl.this.getTypeSystem(), string);
                } else if (i4 == 4) {
                    ref = new SchemaGlobalAttribute.Ref(SchemaTypeSystemImpl.this.getTypeSystem(), string);
                } else if (i4 == 6) {
                    ref = new SchemaModelGroup.Ref(SchemaTypeSystemImpl.this.getTypeSystem(), string);
                } else if (i4 == 7) {
                    ref = new SchemaAttributeGroup.Ref(SchemaTypeSystemImpl.this.getTypeSystem(), string);
                } else {
                    if (i4 != 8) {
                        StringBuffer stringBuffer = new StringBuffer("Schema index has an unrecognized entry of type ");
                        stringBuffer.append(i4);
                        throw new SchemaTypeLoaderException(stringBuffer.toString(), SchemaTypeSystemImpl.this._name, string, 5);
                    }
                    ref = new SchemaIdentityConstraint.Ref(SchemaTypeSystemImpl.this.getTypeSystem(), string);
                }
                handlePool._handlesToRefs.put(string, ref);
            }
        }

        public int readInt() {
            try {
                return this._input.readInt();
            } catch (IOException e) {
                throw new SchemaTypeLoaderException(e.getMessage(), SchemaTypeSystemImpl.this._name, this._handle, 9);
            }
        }

        public Set readNamespaces() {
            HashSet hashSet = new HashSet();
            int i = readShort();
            for (int i2 = 0; i2 < i; i2++) {
                hashSet.add(readString());
            }
            return hashSet;
        }

        public SchemaParticle[] readParticleArray() {
            int i = readShort();
            SchemaParticle[] schemaParticleArr = new SchemaParticle[i];
            for (int i2 = 0; i2 < i; i2++) {
                schemaParticleArr[i2] = readParticleData();
            }
            return schemaParticleArr;
        }

        public SchemaParticle readParticleData() {
            int i = readShort();
            SchemaParticleImpl schemaParticleImpl = i != 4 ? new SchemaParticleImpl() : new SchemaLocalElementImpl();
            loadParticle(schemaParticleImpl, i);
            return schemaParticleImpl;
        }

        public SchemaProperty readPropertyData() {
            SchemaPropertyImpl schemaPropertyImpl = new SchemaPropertyImpl();
            schemaPropertyImpl.setName(readQName());
            schemaPropertyImpl.setTypeRef(readTypeRef());
            int i = readShort();
            schemaPropertyImpl.setAttribute((i & 1) != 0);
            schemaPropertyImpl.setContainerTypeRef(readTypeRef());
            schemaPropertyImpl.setMinOccurs(readBigInteger());
            schemaPropertyImpl.setMaxOccurs(readBigInteger());
            schemaPropertyImpl.setNillable(readShort());
            schemaPropertyImpl.setDefault(readShort());
            schemaPropertyImpl.setFixed(readShort());
            schemaPropertyImpl.setDefaultText(readString());
            schemaPropertyImpl.setJavaPropertyName(readString());
            schemaPropertyImpl.setJavaTypeCode(readShort());
            schemaPropertyImpl.setExtendsJava(readTypeRef(), (i & 2) != 0, (i & 4) != 0, (i & 8) != 0);
            if (atMost(2, 19, 0)) {
                schemaPropertyImpl.setJavaSetterDelimiter(readQNameSet());
            }
            if (atLeast(2, 16, 0)) {
                schemaPropertyImpl.setDefaultValue(readXmlValueObject());
            }
            if (!schemaPropertyImpl.isAttribute() && atLeast(2, 17, 0)) {
                int i2 = readShort();
                LinkedHashSet linkedHashSet = new LinkedHashSet(i2);
                for (int i4 = 0; i4 < i2; i4++) {
                    linkedHashSet.add(readQName());
                }
                schemaPropertyImpl.setAcceptedNames(linkedHashSet);
            }
            schemaPropertyImpl.setImmutable();
            return schemaPropertyImpl;
        }

        public QName readQName() {
            String string = readString();
            String string2 = readString();
            if (string2 == null) {
                return null;
            }
            return new QName(string, string2);
        }

        public Map readQNameRefMap() {
            HashMap map = new HashMap();
            int i = readShort();
            for (int i2 = 0; i2 < i; i2++) {
                map.put(readQName(), readHandle());
            }
            return map;
        }

        public List readQNameRefMapAsList(List list) {
            int i = readShort();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 < i; i2++) {
                QName qName = readQName();
                arrayList.add(readHandle());
                list.add(qName);
            }
            return arrayList;
        }

        public QNameSet readQNameSet() {
            int i = readShort();
            HashSet hashSet = new HashSet();
            int i2 = readShort();
            for (int i4 = 0; i4 < i2; i4++) {
                hashSet.add(readString());
            }
            HashSet hashSet2 = new HashSet();
            int i5 = readShort();
            for (int i6 = 0; i6 < i5; i6++) {
                hashSet2.add(readQName());
            }
            HashSet hashSet3 = new HashSet();
            int i7 = readShort();
            for (int i8 = 0; i8 < i7; i8++) {
                hashSet3.add(readQName());
            }
            return i == 1 ? QNameSet.forSets(hashSet, null, hashSet2, hashSet3) : QNameSet.forSets(null, hashSet, hashSet3, hashSet2);
        }

        public SOAPArrayType readSOAPArrayType() {
            QName qName = readQName();
            String string = readString();
            if (qName == null) {
                return null;
            }
            return new SOAPArrayType(qName, string);
        }

        public int readShort() {
            try {
                return this._input.readUnsignedShort();
            } catch (IOException e) {
                throw new SchemaTypeLoaderException(e.getMessage(), SchemaTypeSystemImpl.this._name, this._handle, 9);
            }
        }

        public String readString() {
            return this._stringPool.stringForCode(readShort());
        }

        public SchemaType.Ref readTypeRef() {
            return (SchemaType.Ref) readHandle();
        }

        public SchemaType.Ref[] readTypeRefArray() {
            int i = readShort();
            SchemaType.Ref[] refArr = new SchemaType.Ref[i];
            for (int i2 = 0; i2 < i; i2++) {
                refArr[i2] = readTypeRef();
            }
            return refArr;
        }

        public XmlValueRef readXmlValueObject() {
            SchemaType.Ref typeRef = readTypeRef();
            if (typeRef == null) {
                return null;
            }
            int i = readShort();
            if (i != 0) {
                if (i == 65535) {
                    int i2 = readShort();
                    ArrayList arrayList = new ArrayList();
                    writeShort(arrayList.size());
                    for (int i4 = 0; i4 < i2; i4++) {
                        arrayList.add(readXmlValueObject());
                    }
                    return new XmlValueRef(typeRef, arrayList);
                }
                switch (i) {
                    case 2:
                    case 3:
                    case 6:
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                        return new XmlValueRef(typeRef, readString());
                    case 4:
                    case 5:
                        return new XmlValueRef(typeRef, readByteArray());
                    case 7:
                    case 8:
                        return new XmlValueRef(typeRef, readQName());
                    case 9:
                    case 10:
                        return new XmlValueRef(typeRef, new Double(readDouble()));
                    default:
                        if (!$assertionsDisabled) {
                            throw new AssertionError();
                        }
                        break;
                }
            }
            return new XmlValueRef(typeRef, null);
        }

        public void writeAnnotation(SchemaAnnotation schemaAnnotation) {
            if (schemaAnnotation == null) {
                writeInt(-1);
                return;
            }
            SchemaAnnotation.Attribute[] attributes = schemaAnnotation.getAttributes();
            writeInt(attributes.length);
            for (int i = 0; i < attributes.length; i++) {
                QName name = attributes[i].getName();
                String value = attributes[i].getValue();
                String valueUri = attributes[i].getValueUri();
                writeQName(name);
                writeString(value);
                writeString(valueUri);
            }
            XmlObject[] userInformation = schemaAnnotation.getUserInformation();
            writeInt(userInformation.length);
            XmlOptions saveAggressiveNamespaces = new XmlOptions().setSaveOuter().setSaveAggressiveNamespaces();
            for (XmlObject xmlObject : userInformation) {
                writeString(xmlObject.xmlText(saveAggressiveNamespaces));
            }
            XmlObject[] applicationInformation = schemaAnnotation.getApplicationInformation();
            writeInt(applicationInformation.length);
            for (XmlObject xmlObject2 : applicationInformation) {
                writeString(xmlObject2.xmlText(saveAggressiveNamespaces));
            }
        }

        public void writeAnnotations(SchemaAnnotation[] schemaAnnotationArr) {
            writeInt(schemaAnnotationArr.length);
            for (SchemaAnnotation schemaAnnotation : schemaAnnotationArr) {
                writeAnnotation(schemaAnnotation);
            }
        }

        public void writeAttributeData(SchemaLocalAttribute schemaLocalAttribute) {
            writeQName(schemaLocalAttribute.getName());
            writeType(schemaLocalAttribute.getType());
            writeShort(schemaLocalAttribute.getUse());
            writeString(schemaLocalAttribute.getDefaultText());
            writeXmlValueObject(schemaLocalAttribute.getDefaultValue());
            writeShort(schemaLocalAttribute.isFixed() ? 1 : 0);
            writeSOAPArrayType(((SchemaWSDLArrayType) schemaLocalAttribute).getWSDLArrayType());
            writeAnnotation(schemaLocalAttribute.getAnnotation());
        }

        public void writeAttributeGroupData(SchemaAttributeGroup schemaAttributeGroup) {
            SchemaAttributeGroupImpl schemaAttributeGroupImpl = (SchemaAttributeGroupImpl) schemaAttributeGroup;
            writeQName(schemaAttributeGroupImpl.getName());
            writeString(schemaAttributeGroupImpl.getTargetNamespace());
            writeShort(schemaAttributeGroupImpl.getChameleonNamespace() != null ? 1 : 0);
            writeString(schemaAttributeGroupImpl.getFormDefault());
            writeShort(schemaAttributeGroupImpl.isRedefinition() ? 1 : 0);
            writeString(schemaAttributeGroupImpl.getParseObject().xmlText(new XmlOptions().setSaveOuter()));
            writeAnnotation(schemaAttributeGroupImpl.getAnnotation());
            writeString(schemaAttributeGroupImpl.getSourceName());
        }

        public void writeAttributeTypeMap(SchemaType[] schemaTypeArr) {
            writeShort(schemaTypeArr.length);
            for (int i = 0; i < schemaTypeArr.length; i++) {
                writeQName(schemaTypeArr[i].getAttributeTypeAttributeName());
                writeHandle(schemaTypeArr[i]);
            }
        }

        public void writeBigInteger(BigInteger bigInteger) {
            if (bigInteger == null) {
                writeShort(0);
            } else if (bigInteger.signum() == 0) {
                writeByteArray(SchemaTypeSystemImpl.SINGLE_ZERO_BYTE);
            } else {
                writeByteArray(bigInteger.toByteArray());
            }
        }

        public void writeByteArray(byte[] bArr) {
            try {
                writeShort(bArr.length);
                DataOutputStream dataOutputStream = this._output;
                if (dataOutputStream != null) {
                    dataOutputStream.write(bArr);
                }
            } catch (IOException e) {
                throw new SchemaTypeLoaderException(e.getMessage(), SchemaTypeSystemImpl.this._name, this._handle, 9);
            }
        }

        public void writeClassnameMap(Map map) {
            writeShort(map.size());
            for (String str : map.keySet()) {
                writeString(str);
                writeHandle(((SchemaType.Ref) map.get(str)).get());
            }
        }

        public void writeDocumentTypeMap(SchemaType[] schemaTypeArr) {
            writeShort(schemaTypeArr.length);
            for (int i = 0; i < schemaTypeArr.length; i++) {
                writeQName(schemaTypeArr[i].getDocumentElementName());
                writeHandle(schemaTypeArr[i]);
            }
        }

        public void writeDouble(double d) {
            DataOutputStream dataOutputStream = this._output;
            if (dataOutputStream != null) {
                try {
                    dataOutputStream.writeDouble(d);
                } catch (IOException e) {
                    throw new SchemaTypeLoaderException(e.getMessage(), SchemaTypeSystemImpl.this._name, this._handle, 9);
                }
            }
        }

        public void writeEnd() {
            try {
                DataOutputStream dataOutputStream = this._output;
                if (dataOutputStream != null) {
                    dataOutputStream.flush();
                    this._output.close();
                }
                this._output = null;
                this._stringPool = null;
                this._handle = null;
            } catch (IOException e) {
                throw new SchemaTypeLoaderException(e.getMessage(), SchemaTypeSystemImpl.this._name, this._handle, 9);
            }
        }

        public void writeHandle(SchemaComponent schemaComponent) {
            if (schemaComponent == null || schemaComponent.getTypeSystem() == SchemaTypeSystemImpl.this.getTypeSystem()) {
                writeString(SchemaTypeSystemImpl.this._localHandles.handleForComponent(schemaComponent));
                return;
            }
            int componentType = schemaComponent.getComponentType();
            if (componentType == 0) {
                SchemaType schemaType = (SchemaType) schemaComponent;
                if (schemaType.isBuiltinType()) {
                    StringBuffer stringBuffer = new StringBuffer("_BI_");
                    stringBuffer.append(schemaType.getName().getLocalPart());
                    writeString(stringBuffer.toString());
                    return;
                } else if (schemaType.getName() != null) {
                    StringBuffer stringBuffer2 = new StringBuffer("_XT_");
                    stringBuffer2.append(QNameHelper.pretty(schemaType.getName()));
                    writeString(stringBuffer2.toString());
                    return;
                } else if (schemaType.isDocumentType()) {
                    StringBuffer stringBuffer3 = new StringBuffer("_XO_");
                    stringBuffer3.append(QNameHelper.pretty(schemaType.getDocumentElementName()));
                    writeString(stringBuffer3.toString());
                    return;
                } else {
                    StringBuffer stringBuffer4 = new StringBuffer("_XY_");
                    stringBuffer4.append(schemaType.toString());
                    writeString(stringBuffer4.toString());
                    return;
                }
            }
            if (componentType == 1) {
                StringBuffer stringBuffer5 = new StringBuffer("_XE_");
                stringBuffer5.append(QNameHelper.pretty(schemaComponent.getName()));
                writeString(stringBuffer5.toString());
                return;
            }
            if (componentType == 3) {
                StringBuffer stringBuffer6 = new StringBuffer("_XA_");
                stringBuffer6.append(QNameHelper.pretty(schemaComponent.getName()));
                writeString(stringBuffer6.toString());
                return;
            }
            if (componentType == 4) {
                StringBuffer stringBuffer7 = new StringBuffer("_XN_");
                stringBuffer7.append(QNameHelper.pretty(schemaComponent.getName()));
                writeString(stringBuffer7.toString());
            } else if (componentType == 5) {
                StringBuffer stringBuffer8 = new StringBuffer("_XD_");
                stringBuffer8.append(QNameHelper.pretty(schemaComponent.getName()));
                writeString(stringBuffer8.toString());
            } else if (componentType == 6) {
                StringBuffer stringBuffer9 = new StringBuffer("_XM_");
                stringBuffer9.append(QNameHelper.pretty(schemaComponent.getName()));
                writeString(stringBuffer9.toString());
            } else {
                if (!$assertionsDisabled) {
                    throw new AssertionError();
                }
                StringBuffer stringBuffer10 = new StringBuffer("Cannot write handle for component ");
                stringBuffer10.append(schemaComponent);
                throw new SchemaTypeLoaderException(stringBuffer10.toString(), SchemaTypeSystemImpl.this._name, this._handle, 13);
            }
        }

        public void writeHandlePool(HandlePool handlePool) {
            writeShort(handlePool._componentsToHandles.size());
            for (SchemaComponent schemaComponent : handlePool._componentsToHandles.keySet()) {
                String str = (String) handlePool._componentsToHandles.get(schemaComponent);
                int iFileTypeFromComponentType = fileTypeFromComponentType(schemaComponent.getComponentType());
                writeString(str);
                writeShort(iFileTypeFromComponentType);
            }
        }

        public void writeIdConstraintData(SchemaIdentityConstraint schemaIdentityConstraint) {
            writeQName(schemaIdentityConstraint.getName());
            writeShort(schemaIdentityConstraint.getConstraintCategory());
            writeString(schemaIdentityConstraint.getSelector());
            writeAnnotation(schemaIdentityConstraint.getAnnotation());
            String[] fields = schemaIdentityConstraint.getFields();
            writeShort(fields.length);
            for (String str : fields) {
                writeString(str);
            }
            if (schemaIdentityConstraint.getConstraintCategory() == 2) {
                writeHandle(schemaIdentityConstraint.getReferencedKey());
            }
            Set<Map.Entry> setEntrySet = schemaIdentityConstraint.getNSMap().entrySet();
            writeShort(setEntrySet.size());
            for (Map.Entry entry : setEntrySet) {
                String str2 = (String) entry.getKey();
                String str3 = (String) entry.getValue();
                writeString(str2);
                writeString(str3);
            }
            writeString(schemaIdentityConstraint.getSourceName());
        }

        public void writeIndexData() {
            writeHandlePool(SchemaTypeSystemImpl.this._localHandles);
            writeQNameMap(SchemaTypeSystemImpl.this.globalElements());
            writeQNameMap(SchemaTypeSystemImpl.this.globalAttributes());
            writeQNameMap(SchemaTypeSystemImpl.this.modelGroups());
            writeQNameMap(SchemaTypeSystemImpl.this.attributeGroups());
            writeQNameMap(SchemaTypeSystemImpl.this.identityConstraints());
            writeQNameMap(SchemaTypeSystemImpl.this.globalTypes());
            writeDocumentTypeMap(SchemaTypeSystemImpl.this.documentTypes());
            writeAttributeTypeMap(SchemaTypeSystemImpl.this.attributeTypes());
            writeClassnameMap(SchemaTypeSystemImpl.this._typeRefsByClassname);
            writeNamespaces(SchemaTypeSystemImpl.this._namespaces);
            writeQNameMap(SchemaTypeSystemImpl.this.redefinedGlobalTypes());
            writeQNameMap(SchemaTypeSystemImpl.this.redefinedModelGroups());
            writeQNameMap(SchemaTypeSystemImpl.this.redefinedAttributeGroups());
            writeAnnotations(SchemaTypeSystemImpl.this.annotations());
        }

        public void writeInt(int i) {
            DataOutputStream dataOutputStream = this._output;
            if (dataOutputStream != null) {
                try {
                    dataOutputStream.writeInt(i);
                } catch (IOException e) {
                    throw new SchemaTypeLoaderException(e.getMessage(), SchemaTypeSystemImpl.this._name, this._handle, 9);
                }
            }
        }

        public void writeModelGroupData(SchemaModelGroup schemaModelGroup) {
            SchemaModelGroupImpl schemaModelGroupImpl = (SchemaModelGroupImpl) schemaModelGroup;
            writeQName(schemaModelGroupImpl.getName());
            writeString(schemaModelGroupImpl.getTargetNamespace());
            writeShort(schemaModelGroupImpl.getChameleonNamespace() != null ? 1 : 0);
            writeString(schemaModelGroupImpl.getElemFormDefault());
            writeString(schemaModelGroupImpl.getAttFormDefault());
            writeShort(schemaModelGroupImpl.isRedefinition() ? 1 : 0);
            writeString(schemaModelGroupImpl.getParseObject().xmlText(new XmlOptions().setSaveOuter()));
            writeAnnotation(schemaModelGroupImpl.getAnnotation());
            writeString(schemaModelGroupImpl.getSourceName());
        }

        public void writeNamespaces(Set set) {
            writeShort(set.size());
            Iterator it = set.iterator();
            while (it.hasNext()) {
                writeString((String) it.next());
            }
        }

        public void writeParticleArray(SchemaParticle[] schemaParticleArr) {
            writeShort(schemaParticleArr.length);
            for (SchemaParticle schemaParticle : schemaParticleArr) {
                writeParticleData(schemaParticle);
            }
        }

        public void writeParticleData(SchemaParticle schemaParticle) {
            writeShort(schemaParticle.getParticleType());
            short s = schemaParticle.isSkippable() ? (short) 1 : (short) 0;
            if (schemaParticle.getParticleType() == 4) {
                SchemaLocalElement schemaLocalElement = (SchemaLocalElement) schemaParticle;
                if (schemaLocalElement.isFixed()) {
                    s = (short) (s | 4);
                }
                if (schemaLocalElement.isNillable()) {
                    s = (short) (s | 8);
                }
                if (schemaLocalElement.blockExtension()) {
                    s = (short) (s | 16);
                }
                if (schemaLocalElement.blockRestriction()) {
                    s = (short) (s | 32);
                }
                if (schemaLocalElement.blockSubstitution()) {
                    s = (short) (s | 64);
                }
                if (schemaLocalElement.isAbstract()) {
                    s = (short) (s | 128);
                }
                if (schemaLocalElement instanceof SchemaGlobalElement) {
                    SchemaGlobalElement schemaGlobalElement = (SchemaGlobalElement) schemaLocalElement;
                    if (schemaGlobalElement.finalExtension()) {
                        s = (short) (s | Http2CodecUtil.MAX_WEIGHT);
                    }
                    if (schemaGlobalElement.finalRestriction()) {
                        s = (short) (s | 512);
                    }
                }
            }
            writeShort(s);
            writeBigInteger(schemaParticle.getMinOccurs());
            writeBigInteger(schemaParticle.getMaxOccurs());
            writeQNameSet(schemaParticle.acceptedStartNames());
            int particleType = schemaParticle.getParticleType();
            if (particleType == 1 || particleType == 2 || particleType == 3) {
                writeParticleArray(schemaParticle.getParticleChildren());
                return;
            }
            if (particleType != 4) {
                if (particleType != 5) {
                    throw new SchemaTypeLoaderException("Unrecognized particle type ", SchemaTypeSystemImpl.this._name, this._handle, 11);
                }
                writeQNameSet(schemaParticle.getWildcardSet());
                writeShort(schemaParticle.getWildcardProcess());
                return;
            }
            SchemaLocalElement schemaLocalElement2 = (SchemaLocalElement) schemaParticle;
            writeQName(schemaLocalElement2.getName());
            writeType(schemaLocalElement2.getType());
            writeString(schemaLocalElement2.getDefaultText());
            writeXmlValueObject(schemaLocalElement2.getDefaultValue());
            writeSOAPArrayType(((SchemaWSDLArrayType) schemaLocalElement2).getWSDLArrayType());
            writeAnnotation(schemaLocalElement2.getAnnotation());
            if (schemaLocalElement2 instanceof SchemaGlobalElement) {
                SchemaGlobalElement schemaGlobalElement2 = (SchemaGlobalElement) schemaLocalElement2;
                writeHandle(schemaGlobalElement2.substitutionGroup());
                QName[] qNameArrSubstitutionGroupMembers = schemaGlobalElement2.substitutionGroupMembers();
                writeShort(qNameArrSubstitutionGroupMembers.length);
                for (QName qName : qNameArrSubstitutionGroupMembers) {
                    writeQName(qName);
                }
            }
            SchemaIdentityConstraint[] identityConstraints = schemaLocalElement2.getIdentityConstraints();
            writeShort(identityConstraints.length);
            for (SchemaIdentityConstraint schemaIdentityConstraint : identityConstraints) {
                writeHandle(schemaIdentityConstraint);
            }
        }

        public void writePropertyData(SchemaProperty schemaProperty) {
            writeQName(schemaProperty.getName());
            writeType(schemaProperty.getType());
            writeShort((schemaProperty.isAttribute() ? 1 : 0) | (schemaProperty.extendsJavaSingleton() ? 2 : 0) | (schemaProperty.extendsJavaOption() ? 4 : 0) | (schemaProperty.extendsJavaArray() ? 8 : 0));
            writeType(schemaProperty.getContainerType());
            writeBigInteger(schemaProperty.getMinOccurs());
            writeBigInteger(schemaProperty.getMaxOccurs());
            writeShort(schemaProperty.hasNillable());
            writeShort(schemaProperty.hasDefault());
            writeShort(schemaProperty.hasFixed());
            writeString(schemaProperty.getDefaultText());
            writeString(schemaProperty.getJavaPropertyName());
            writeShort(schemaProperty.getJavaTypeCode());
            writeType(schemaProperty.javaBasedOnType());
            writeXmlValueObject(schemaProperty.getDefaultValue());
            if (schemaProperty.isAttribute()) {
                return;
            }
            QName[] qNameArrAcceptedNames = schemaProperty.acceptedNames();
            writeShort(qNameArrAcceptedNames.length);
            for (QName qName : qNameArrAcceptedNames) {
                writeQName(qName);
            }
        }

        public void writeQName(QName qName) {
            if (qName == null) {
                writeString(null);
                writeString(null);
            } else {
                writeString(qName.getNamespaceURI());
                writeString(qName.getLocalPart());
            }
        }

        public void writeQNameMap(SchemaComponent[] schemaComponentArr) {
            writeShort(schemaComponentArr.length);
            for (int i = 0; i < schemaComponentArr.length; i++) {
                writeQName(schemaComponentArr[i].getName());
                writeHandle(schemaComponentArr[i]);
            }
        }

        public void writeQNameSet(QNameSet qNameSet) {
            int i = qNameSet.excludedURIs() != null ? 1 : 0;
            writeShort(i);
            Set setExcludedURIs = i != 0 ? qNameSet.excludedURIs() : qNameSet.includedURIs();
            writeShort(setExcludedURIs.size());
            Iterator it = setExcludedURIs.iterator();
            while (it.hasNext()) {
                writeString((String) it.next());
            }
            Set setExcludedQNamesInIncludedURIs = i != 0 ? qNameSet.excludedQNamesInIncludedURIs() : qNameSet.includedQNamesInExcludedURIs();
            writeShort(setExcludedQNamesInIncludedURIs.size());
            Iterator it2 = setExcludedQNamesInIncludedURIs.iterator();
            while (it2.hasNext()) {
                writeQName((QName) it2.next());
            }
            Set setIncludedQNamesInExcludedURIs = i != 0 ? qNameSet.includedQNamesInExcludedURIs() : qNameSet.excludedQNamesInIncludedURIs();
            writeShort(setIncludedQNamesInExcludedURIs.size());
            Iterator it3 = setIncludedQNamesInExcludedURIs.iterator();
            while (it3.hasNext()) {
                writeQName((QName) it3.next());
            }
        }

        public void writeRealHeader(String str, int i) {
            String string;
            if (str.indexOf(47) >= 0) {
                string = str.concat(".xsb");
            } else {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(SchemaTypeSystemImpl.this._basePackage);
                stringBuffer.append(str);
                stringBuffer.append(".xsb");
                string = stringBuffer.toString();
            }
            OutputStream saverStream = getSaverStream(string);
            if (saverStream == null) {
                throw new SchemaTypeLoaderException(AbstractC14516b.m15113a("Could not write compiled schema resource ", string), SchemaTypeSystemImpl.this._name, str, 12);
            }
            this._output = new DataOutputStream(saverStream);
            this._handle = str;
            writeInt(SchemaTypeSystemImpl.DATA_BABE);
            writeShort(2);
            writeShort(24);
            writeShort(0);
            writeShort(i);
            this._stringPool.writeTo(this._output);
        }

        public void writeSOAPArrayType(SOAPArrayType sOAPArrayType) {
            if (sOAPArrayType == null) {
                writeQName(null);
                writeString(null);
            } else {
                writeQName(sOAPArrayType.getQName());
                writeString(sOAPArrayType.soap11DimensionString());
            }
        }

        public void writeShort(int i) {
            if (i >= 65535 || i < -1) {
                StringBuffer stringBuffer = new StringBuffer("Value ");
                stringBuffer.append(i);
                stringBuffer.append(" out of range: must fit in a 16-bit unsigned short.");
                throw new SchemaTypeLoaderException(stringBuffer.toString(), SchemaTypeSystemImpl.this._name, this._handle, 10);
            }
            DataOutputStream dataOutputStream = this._output;
            if (dataOutputStream != null) {
                try {
                    dataOutputStream.writeShort(i);
                } catch (IOException e) {
                    throw new SchemaTypeLoaderException(e.getMessage(), SchemaTypeSystemImpl.this._name, this._handle, 9);
                }
            }
        }

        public void writeString(String str) {
            writeShort(this._stringPool.codeForString(str));
        }

        public void writeType(SchemaType schemaType) {
            writeHandle(schemaType);
        }

        public void writeTypeArray(SchemaType[] schemaTypeArr) {
            writeShort(schemaTypeArr.length);
            for (SchemaType schemaType : schemaTypeArr) {
                writeHandle(schemaType);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v119 */
        /* JADX WARN: Type inference failed for: r1v120 */
        /* JADX WARN: Type inference failed for: r1v121 */
        /* JADX WARN: Type inference failed for: r1v122 */
        /* JADX WARN: Type inference failed for: r1v123 */
        /* JADX WARN: Type inference failed for: r1v124 */
        /* JADX WARN: Type inference failed for: r1v125 */
        /* JADX WARN: Type inference failed for: r1v126 */
        /* JADX WARN: Type inference failed for: r1v127 */
        /* JADX WARN: Type inference failed for: r1v128 */
        /* JADX WARN: Type inference failed for: r1v129 */
        /* JADX WARN: Type inference failed for: r1v130 */
        /* JADX WARN: Type inference failed for: r1v131 */
        /* JADX WARN: Type inference failed for: r1v132 */
        /* JADX WARN: Type inference failed for: r1v133 */
        /* JADX WARN: Type inference failed for: r1v134 */
        /* JADX WARN: Type inference failed for: r1v135 */
        /* JADX WARN: Type inference failed for: r1v136 */
        /* JADX WARN: Type inference failed for: r1v137 */
        /* JADX WARN: Type inference failed for: r1v138 */
        /* JADX WARN: Type inference failed for: r1v139 */
        /* JADX WARN: Type inference failed for: r1v140 */
        /* JADX WARN: Type inference failed for: r1v141 */
        /* JADX WARN: Type inference failed for: r1v142 */
        /* JADX WARN: Type inference failed for: r1v143 */
        /* JADX WARN: Type inference failed for: r1v144 */
        /* JADX WARN: Type inference failed for: r1v145 */
        /* JADX WARN: Type inference failed for: r1v146 */
        /* JADX WARN: Type inference failed for: r1v147 */
        /* JADX WARN: Type inference failed for: r1v148 */
        /* JADX WARN: Type inference failed for: r1v149 */
        /* JADX WARN: Type inference failed for: r1v150 */
        /* JADX WARN: Type inference failed for: r1v151 */
        /* JADX WARN: Type inference failed for: r1v152 */
        /* JADX WARN: Type inference failed for: r1v24 */
        /* JADX WARN: Type inference failed for: r1v25 */
        /* JADX WARN: Type inference failed for: r1v26 */
        /* JADX WARN: Type inference failed for: r1v27 */
        /* JADX WARN: Type inference failed for: r1v28 */
        /* JADX WARN: Type inference failed for: r1v29 */
        /* JADX WARN: Type inference failed for: r1v30 */
        /* JADX WARN: Type inference failed for: r1v31 */
        /* JADX WARN: Type inference failed for: r1v32 */
        /* JADX WARN: Type inference failed for: r1v33 */
        /* JADX WARN: Type inference failed for: r1v34 */
        /* JADX WARN: Type inference failed for: r1v35 */
        /* JADX WARN: Type inference failed for: r1v36 */
        /* JADX WARN: Type inference failed for: r1v37 */
        /* JADX WARN: Type inference failed for: r1v38 */
        /* JADX WARN: Type inference failed for: r1v39 */
        /* JADX WARN: Type inference failed for: r1v40 */
        public void writeTypeData(SchemaType schemaType) {
            writeQName(schemaType.getName());
            writeType(schemaType.getOuterType());
            SchemaTypeImpl schemaTypeImpl = (SchemaTypeImpl) schemaType;
            writeShort(schemaTypeImpl.getBaseDepth());
            writeType(schemaType.getBaseType());
            writeShort(schemaType.getDerivationType());
            writeAnnotation(schemaType.getAnnotation());
            if (schemaType.getContainerField() == null) {
                writeShort(0);
            } else if (schemaType.getOuterType().isAttributeType() || schemaType.getOuterType().isDocumentType()) {
                writeShort(1);
                writeHandle((SchemaComponent) schemaType.getContainerField());
            } else if (schemaType.getContainerField().isAttribute()) {
                writeShort(2);
                writeShort(((SchemaTypeImpl) schemaType.getOuterType()).getIndexForLocalAttribute((SchemaLocalAttribute) schemaType.getContainerField()));
            } else {
                writeShort(3);
                writeShort(((SchemaTypeImpl) schemaType.getOuterType()).getIndexForLocalElement((SchemaLocalElement) schemaType.getContainerField()));
            }
            writeString(schemaType.getFullJavaName());
            writeString(schemaType.getFullJavaImplName());
            writeTypeArray(schemaType.getAnonymousTypes());
            writeShort(schemaType.getAnonymousUnionMemberOrdinal());
            boolean zIsSimpleType = schemaType.isSimpleType();
            ?? r12 = zIsSimpleType;
            if (schemaType.isDocumentType()) {
                r12 = (zIsSimpleType ? 1 : 0) | 2;
            }
            ?? r13 = r12;
            if (schemaType.isAttributeType()) {
                r13 = (r12 == true ? 1 : 0) | 524288;
            }
            ?? r14 = r13;
            if (schemaType.ordered() != 0) {
                r14 = (r13 == true ? 1 : 0) | 4;
            }
            ?? r15 = r14;
            if (schemaType.ordered() == 2) {
                r15 = (r14 == true ? 1 : 0) | 1024;
            }
            ?? r16 = r15;
            if (schemaType.isBounded()) {
                r16 = (r15 == true ? 1 : 0) | 8;
            }
            ?? r17 = r16;
            if (schemaType.isFinite()) {
                r17 = (r16 == true ? 1 : 0) | 16;
            }
            ?? r18 = r17;
            if (schemaType.isNumeric()) {
                r18 = (r17 == true ? 1 : 0) | 32;
            }
            ?? r19 = r18;
            if (schemaType.hasStringEnumValues()) {
                r19 = (r18 == true ? 1 : 0) | 64;
            }
            ?? r110 = r19;
            if (schemaTypeImpl.isUnionOfLists()) {
                r110 = (r19 == true ? 1 : 0) | 128;
            }
            ?? r111 = r110;
            if (schemaType.hasPatternFacet()) {
                r111 = (r110 == true ? 1 : 0) | 256;
            }
            ?? r112 = r111;
            if (schemaType.isOrderSensitive()) {
                r112 = (r111 == true ? 1 : 0) | 512;
            }
            ?? r113 = r112;
            if (schemaType.blockExtension()) {
                r113 = (r112 == true ? 1 : 0) | 4096;
            }
            ?? r114 = r113;
            if (schemaType.blockRestriction()) {
                r114 = (r113 == true ? 1 : 0) | 8192;
            }
            ?? r115 = r114;
            if (schemaType.finalExtension()) {
                r115 = (r114 == true ? 1 : 0) | 16384;
            }
            ?? r116 = r115;
            if (schemaType.finalRestriction()) {
                r116 = (r115 == true ? 1 : 0) | 16384;
            }
            ?? r117 = r116;
            if (schemaType.finalList()) {
                r117 = (r116 == true ? 1 : 0) | 131072;
            }
            ?? r118 = r117;
            if (schemaType.finalUnion()) {
                r118 = (r117 == true ? 1 : 0) | 65536;
            }
            int i = r118;
            if (schemaType.isAbstract()) {
                i = (r118 == true ? 1 : 0) | 262144;
            }
            writeInt(i);
            if (!schemaType.isSimpleType()) {
                writeShort(schemaType.getContentType());
                writeType(schemaType.getContentBasedOnType());
                SchemaAttributeModel attributeModel = schemaType.getAttributeModel();
                SchemaLocalAttribute[] attributes = attributeModel.getAttributes();
                writeShort(attributes.length);
                for (SchemaLocalAttribute schemaLocalAttribute : attributes) {
                    writeAttributeData(schemaLocalAttribute);
                }
                writeQNameSet(attributeModel.getWildcardSet());
                writeShort(attributeModel.getWildcardProcess());
                SchemaProperty[] attributeProperties = schemaType.getAttributeProperties();
                writeShort(attributeProperties.length);
                for (SchemaProperty schemaProperty : attributeProperties) {
                    writePropertyData(schemaProperty);
                }
                if (schemaType.getContentType() == 3 || schemaType.getContentType() == 4) {
                    writeShort(schemaType.hasAllContent() ? 1 : 0);
                    writeParticleArray(schemaType.getContentModel() != null ? new SchemaParticle[]{schemaType.getContentModel()} : new SchemaParticle[0]);
                    SchemaProperty[] elementProperties = schemaType.getElementProperties();
                    writeShort(elementProperties.length);
                    for (SchemaProperty schemaProperty2 : elementProperties) {
                        writePropertyData(schemaProperty2);
                    }
                }
            }
            if (schemaType.isSimpleType() || schemaType.getContentType() == 2) {
                writeShort(schemaType.getSimpleVariety());
                int i2 = 0;
                for (int i4 = 0; i4 <= 11; i4++) {
                    if (schemaType.getFacet(i4) != null) {
                        i2++;
                    }
                }
                writeShort(i2);
                for (int i5 = 0; i5 <= 11; i5++) {
                    XmlAnySimpleType facet = schemaType.getFacet(i5);
                    if (facet != null) {
                        writeShort(i5);
                        writeXmlValueObject(facet);
                        writeShort(schemaType.isFacetFixed(i5) ? 1 : 0);
                    }
                }
                writeShort(schemaType.getWhiteSpaceRule());
                RegularExpression[] patternExpressions = schemaTypeImpl.getPatternExpressions();
                writeShort(patternExpressions.length);
                for (RegularExpression regularExpression : patternExpressions) {
                    writeString(regularExpression.getPattern());
                }
                XmlAnySimpleType[] enumerationValues = schemaType.getEnumerationValues();
                if (enumerationValues == null) {
                    writeShort(0);
                } else {
                    writeShort(enumerationValues.length);
                    for (XmlAnySimpleType xmlAnySimpleType : enumerationValues) {
                        writeXmlValueObject(xmlAnySimpleType);
                    }
                }
                writeType(schemaType.getBaseEnumType());
                if (schemaType.hasStringEnumValues()) {
                    SchemaStringEnumEntry[] stringEnumEntries = schemaType.getStringEnumEntries();
                    writeShort(stringEnumEntries.length);
                    for (int i6 = 0; i6 < stringEnumEntries.length; i6++) {
                        writeString(stringEnumEntries[i6].getString());
                        writeShort(stringEnumEntries[i6].getIntValue());
                        writeString(stringEnumEntries[i6].getEnumName());
                    }
                }
                int simpleVariety = schemaType.getSimpleVariety();
                if (simpleVariety == 1) {
                    writeType(schemaType.getPrimitiveType());
                    writeInt(schemaType.getDecimalSize());
                } else if (simpleVariety == 2) {
                    writeTypeArray(schemaType.getUnionMemberTypes());
                } else if (simpleVariety == 3) {
                    writeType(schemaType.getListItemType());
                }
            }
            writeString(schemaType.getSourceName());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void writeXmlValueObject(XmlAnySimpleType xmlAnySimpleType) {
            SchemaType schemaType = xmlAnySimpleType == 0 ? null : xmlAnySimpleType.schemaType();
            writeType(schemaType);
            if (schemaType == null) {
                return;
            }
            SimpleValue simpleValue = (SimpleValue) xmlAnySimpleType;
            SchemaType schemaTypeInstanceType = simpleValue.instanceType();
            if (schemaTypeInstanceType == null) {
                writeShort(0);
            }
            if (schemaTypeInstanceType.getSimpleVariety() == 3) {
                writeShort(-1);
                List listXgetListValue = ((XmlObjectBase) xmlAnySimpleType).xgetListValue();
                writeShort(listXgetListValue.size());
                Iterator it = listXgetListValue.iterator();
                while (it.hasNext()) {
                    writeXmlValueObject((XmlAnySimpleType) it.next());
                }
                return;
            }
            int builtinTypeCode = schemaTypeInstanceType.getPrimitiveType().getBuiltinTypeCode();
            writeShort(builtinTypeCode);
            switch (builtinTypeCode) {
                case 2:
                case 3:
                case 6:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                    writeString(xmlAnySimpleType.getStringValue());
                    break;
                case 4:
                case 5:
                    writeByteArray(simpleValue.getByteArrayValue());
                    break;
                case 7:
                case 8:
                    writeQName(simpleValue.getQNameValue());
                    break;
                case 9:
                    writeDouble(simpleValue.getFloatValue());
                    break;
                case 10:
                    writeDouble(simpleValue.getDoubleValue());
                    break;
            }
        }

        public XsbReader(String str) {
            this._handle = str;
            this._stringPool = new StringPool(str, SchemaTypeSystemImpl.this._name);
        }
    }

    public SchemaTypeSystemImpl(String str) {
        if (str == null) {
            byte[] bArr = new byte[16];
            nextBytes(bArr);
            str = "s".concat(new String(HexBin.encode(bArr)));
        }
        StringBuffer stringBuffer = new StringBuffer("schema");
        stringBuffer.append(METADATA_PACKAGE_GEN);
        stringBuffer.append(".system.");
        stringBuffer.append(str);
        String string = stringBuffer.toString();
        this._name = string;
        this._basePackage = nameToPathString(string);
        this._classloader = null;
    }
}
