package org.apache.xmlbeans.impl.schema;

import androidx.compose.runtime.AbstractC1974b;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.AbstractC12991c;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.BindingConfig;
import org.apache.xmlbeans.SchemaAttributeGroup;
import org.apache.xmlbeans.SchemaComponent;
import org.apache.xmlbeans.SchemaGlobalAttribute;
import org.apache.xmlbeans.SchemaGlobalElement;
import org.apache.xmlbeans.SchemaIdentityConstraint;
import org.apache.xmlbeans.SchemaModelGroup;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.SystemProperties;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlError;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ResolverUtil;
import org.apache.xmlbeans.impl.util.HexBin;
import org.apache.xmlbeans.impl.values.XmlStringImpl;
import org.apache.xmlbeans.impl.values.XmlValueOutOfRangeException;
import org.xml.sax.EntityResolver;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class StscState {
    static final /* synthetic */ boolean $assertionsDisabled;
    public static final Object CHAMELEON_INCLUDE_URI;
    static final SchemaType.Ref[] EMPTY_STREF_ARRAY;
    static final SchemaType[] EMPTY_ST_ARRAY;
    static final XmlValueRef[] FACETS_LIST;
    private static final XmlValueRef[] FACETS_NONE;
    static final XmlValueRef[] FACETS_UNION;
    private static final XmlValueRef[] FACETS_WS_COLLAPSE;
    static final boolean[] FIXED_FACETS_LIST;
    private static final boolean[] FIXED_FACETS_NONE;
    static final boolean[] FIXED_FACETS_UNION;
    private static final boolean[] FIXED_FACETS_WS;
    private static final String PROJECT_URL_PREFIX = "project://local";
    private static final XmlValueRef XMLSTR_COLLAPSE;
    private static final XmlValueRef XMLSTR_PRESERVE;
    private static final XmlValueRef XMLSTR_REPLACE;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$schema$StscState;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$SchemaDocument;
    private static ThreadLocal tl_stscStack;
    private boolean _allowPartial;
    private List _annotations;
    private Map _attributeGroups;
    private Map _attributeTypes;
    URI _baseURI;
    private Map _compatMap;
    private BindingConfig _config;
    private Map _containers;
    private SchemaDependencies _dependencies;
    private byte[] _digest;
    private Map _documentTypes;
    private boolean _doingDownloads;
    private EntityResolver _entityResolver;
    private Collection _errorListener;
    private String _givenStsName;
    private Map _globalAttributes;
    private Map _globalElements;
    private Map _globalTypes;
    private Map _idConstraints;
    private SchemaTypeLoader _importingLoader;
    private boolean _mdefAll;
    private Set _mdefNamespaces;
    private Map _misspelledNames;
    private Map _modelGroups;
    private Set _namespaces;
    private boolean _noAnn;
    private boolean _noDigest;
    private boolean _noPvr;
    private boolean _noUpa;
    private Set _processingGroups;
    private int _recoveredErrors;
    private Map _redefinedAttributeGroups;
    private Map _redefinedGlobalTypes;
    private Map _redefinedModelGroups;
    SchemaTypeLoader _s4sloader;
    private File _schemasDir;
    Map _sourceForUri;
    private SchemaTypeSystemImpl _target;
    private Map _typesByClassname;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class StscStack {
        StscState current;
        ArrayList stack;

        private StscStack() {
            this.stack = new ArrayList();
        }

        public final void pop() {
            this.current = (StscState) AbstractC1974b.m1313f(1, this.stack);
            ArrayList arrayList = this.stack;
            arrayList.remove(arrayList.size() - 1);
        }

        public final StscState push() {
            this.stack.add(this.current);
            StscState stscState = new StscState();
            this.current = stscState;
            return stscState;
        }
    }

    static {
        if (class$org$apache$xmlbeans$impl$schema$StscState == null) {
            class$org$apache$xmlbeans$impl$schema$StscState = class$("org.apache.xmlbeans.impl.schema.StscState");
        }
        $assertionsDisabled = true;
        CHAMELEON_INCLUDE_URI = new Object();
        tl_stscStack = new ThreadLocal();
        XMLSTR_PRESERVE = buildString("preserve");
        XMLSTR_REPLACE = buildString("preserve");
        XMLSTR_COLLAPSE = buildString("preserve");
        EMPTY_ST_ARRAY = new SchemaType[0];
        EMPTY_STREF_ARRAY = new SchemaType.Ref[0];
        XmlValueRef[] xmlValueRefArr = {null, null, null, null, null, null, null, null, null, null, null, null};
        FACETS_NONE = xmlValueRefArr;
        boolean[] zArr = {false, false, false, false, false, false, false, false, false, false, false, false};
        FIXED_FACETS_NONE = zArr;
        XmlValueRef[] xmlValueRefArr2 = {null, null, null, null, null, null, null, null, null, build_wsstring(3), null, null};
        FACETS_WS_COLLAPSE = xmlValueRefArr2;
        boolean[] zArr2 = {false, false, false, false, false, false, false, false, false, true, false, false};
        FIXED_FACETS_WS = zArr2;
        FACETS_UNION = xmlValueRefArr;
        FIXED_FACETS_UNION = zArr;
        FACETS_LIST = xmlValueRefArr2;
        FIXED_FACETS_LIST = zArr2;
    }

    private void addContainer(SchemaContainer schemaContainer) {
        this._containers.put(schemaContainer.getNamespace(), schemaContainer);
        List listRedefinedModelGroups = schemaContainer.redefinedModelGroups();
        for (int i = 0; i < listRedefinedModelGroups.size(); i++) {
            this._redefinedModelGroups.put(((SchemaModelGroup) listRedefinedModelGroups.get(i)).getName(), listRedefinedModelGroups.get(i));
        }
        List listRedefinedAttributeGroups = schemaContainer.redefinedAttributeGroups();
        for (int i2 = 0; i2 < listRedefinedAttributeGroups.size(); i2++) {
            this._redefinedAttributeGroups.put(((SchemaAttributeGroup) listRedefinedAttributeGroups.get(i2)).getName(), listRedefinedAttributeGroups.get(i2));
        }
        List listRedefinedGlobalTypes = schemaContainer.redefinedGlobalTypes();
        for (int i4 = 0; i4 < listRedefinedGlobalTypes.size(); i4++) {
            this._redefinedGlobalTypes.put(((SchemaType) listRedefinedGlobalTypes.get(i4)).getName(), listRedefinedGlobalTypes.get(i4));
        }
        List listGlobalElements = schemaContainer.globalElements();
        for (int i5 = 0; i5 < listGlobalElements.size(); i5++) {
            this._globalElements.put(((SchemaGlobalElement) listGlobalElements.get(i5)).getName(), listGlobalElements.get(i5));
        }
        List listGlobalAttributes = schemaContainer.globalAttributes();
        for (int i6 = 0; i6 < listGlobalAttributes.size(); i6++) {
            this._globalAttributes.put(((SchemaGlobalAttribute) listGlobalAttributes.get(i6)).getName(), listGlobalAttributes.get(i6));
        }
        List listModelGroups = schemaContainer.modelGroups();
        for (int i7 = 0; i7 < listModelGroups.size(); i7++) {
            this._modelGroups.put(((SchemaModelGroup) listModelGroups.get(i7)).getName(), listModelGroups.get(i7));
        }
        List listAttributeGroups = schemaContainer.attributeGroups();
        for (int i8 = 0; i8 < listAttributeGroups.size(); i8++) {
            this._attributeGroups.put(((SchemaAttributeGroup) listAttributeGroups.get(i8)).getName(), listAttributeGroups.get(i8));
        }
        List listGlobalTypes = schemaContainer.globalTypes();
        for (int i9 = 0; i9 < listGlobalTypes.size(); i9++) {
            SchemaType schemaType = (SchemaType) listGlobalTypes.get(i9);
            this._globalTypes.put(schemaType.getName(), schemaType);
            if (schemaType.getFullJavaName() != null) {
                addClassname(schemaType.getFullJavaName(), schemaType);
            }
        }
        List listDocumentTypes = schemaContainer.documentTypes();
        for (int i10 = 0; i10 < listDocumentTypes.size(); i10++) {
            SchemaType schemaType2 = (SchemaType) listDocumentTypes.get(i10);
            this._documentTypes.put(schemaType2.getProperties()[0].getName(), schemaType2);
            if (schemaType2.getFullJavaName() != null) {
                addClassname(schemaType2.getFullJavaName(), schemaType2);
            }
        }
        List listAttributeTypes = schemaContainer.attributeTypes();
        for (int i11 = 0; i11 < listAttributeTypes.size(); i11++) {
            SchemaType schemaType3 = (SchemaType) listAttributeTypes.get(i11);
            this._attributeTypes.put(schemaType3.getProperties()[0].getName(), schemaType3);
            if (schemaType3.getFullJavaName() != null) {
                addClassname(schemaType3.getFullJavaName(), schemaType3);
            }
        }
        List listIdentityConstraints = schemaContainer.identityConstraints();
        for (int i12 = 0; i12 < listIdentityConstraints.size(); i12++) {
            this._idConstraints.put(((SchemaIdentityConstraint) listIdentityConstraints.get(i12)).getName(), listIdentityConstraints.get(i12));
        }
        this._annotations.addAll(schemaContainer.annotations());
        this._namespaces.add(schemaContainer.getNamespace());
        schemaContainer.unsetImmutable();
    }

    public static void addError(Collection collection, String str, int i, XmlObject xmlObject) {
        collection.add(XmlError.forObject(str, 0, xmlObject));
    }

    public static void addInfo(Collection collection, String str) {
        collection.add(XmlError.forMessage(str, 2));
    }

    public static void addWarning(Collection collection, String str, int i, XmlObject xmlObject) {
        collection.add(XmlError.forObject(str, 1, xmlObject));
    }

    private static Set buildDefaultMdefNamespaces() {
        return new HashSet(Arrays.asList("http://www.openuri.org/2002/04/soap/conversation/"));
    }

    public static XmlValueRef buildString(String str) {
        if (str == null) {
            return null;
        }
        try {
            XmlStringImpl xmlStringImpl = new XmlStringImpl();
            xmlStringImpl.set(str);
            xmlStringImpl.setImmutable();
            return new XmlValueRef(xmlStringImpl);
        } catch (XmlValueOutOfRangeException unused) {
            return null;
        }
    }

    public static XmlValueRef build_wsstring(int i) {
        if (i == 1) {
            return XMLSTR_PRESERVE;
        }
        if (i == 2) {
            return XMLSTR_REPLACE;
        }
        if (i != 3) {
            return null;
        }
        return XMLSTR_COLLAPSE;
    }

    public static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw AbstractC12991c.m13994o(e);
        }
    }

    private QName compatName(QName qName, String str) {
        QName qName2;
        if (qName.getNamespaceURI().length() == 0 && str != null && str.length() > 0) {
            qName = new QName(str, qName.getLocalPart());
        }
        Map map = this._compatMap;
        return (map == null || (qName2 = (QName) map.get(qName)) == null) ? qName : qName2;
    }

    private static String crunchName(QName qName) {
        return qName.getLocalPart().toLowerCase();
    }

    public static void end() {
        StscStack stscStack = (StscStack) tl_stscStack.get();
        stscStack.pop();
        if (stscStack.stack.size() == 0) {
            tl_stscStack.set(null);
        }
    }

    public static StscState get() {
        return ((StscStack) tl_stscStack.get()).current;
    }

    private boolean ignoreMdef(QName qName) {
        return this._mdefNamespaces.contains(qName.getNamespaceURI());
    }

    public static StscState start() {
        StscStack stscStack = (StscStack) tl_stscStack.get();
        if (stscStack == null) {
            stscStack = new StscStack();
            tl_stscStack.set(stscStack);
        }
        return stscStack.push();
    }

    public void addAnnotation(SchemaAnnotationImpl schemaAnnotationImpl, String str) {
        if (schemaAnnotationImpl != null) {
            SchemaContainer container = getContainer(str);
            if (!$assertionsDisabled && (container == null || container != schemaAnnotationImpl.getContainer())) {
                throw new AssertionError();
            }
            this._annotations.add(schemaAnnotationImpl);
            container.addAnnotation(schemaAnnotationImpl);
        }
    }

    public void addAttributeGroup(SchemaAttributeGroupImpl schemaAttributeGroupImpl, SchemaAttributeGroupImpl schemaAttributeGroupImpl2) {
        if (schemaAttributeGroupImpl != null) {
            QName name = schemaAttributeGroupImpl.getName();
            SchemaContainer container = getContainer(name.getNamespaceURI());
            if (!$assertionsDisabled && (container == null || container != schemaAttributeGroupImpl.getContainer())) {
                throw new AssertionError();
            }
            if (schemaAttributeGroupImpl2 != null) {
                if (!this._redefinedAttributeGroups.containsKey(schemaAttributeGroupImpl2)) {
                    this._redefinedAttributeGroups.put(schemaAttributeGroupImpl2, schemaAttributeGroupImpl);
                    container.addRedefinedAttributeGroup(schemaAttributeGroupImpl.getRef());
                    return;
                } else {
                    if (ignoreMdef(name)) {
                        return;
                    }
                    if (this._mdefAll) {
                        warning(XmlErrorCodes.SCHEMA_PROPERTIES$DUPLICATE, new Object[]{"attribute group", QNameHelper.pretty(name), ((SchemaComponent) this._redefinedAttributeGroups.get(schemaAttributeGroupImpl2)).getSourceName()}, schemaAttributeGroupImpl.getParseObject());
                        return;
                    } else {
                        error(XmlErrorCodes.SCHEMA_PROPERTIES$DUPLICATE, new Object[]{"attribute group", QNameHelper.pretty(name), ((SchemaComponent) this._redefinedAttributeGroups.get(schemaAttributeGroupImpl2)).getSourceName()}, schemaAttributeGroupImpl.getParseObject());
                        return;
                    }
                }
            }
            if (!this._attributeGroups.containsKey(name)) {
                this._attributeGroups.put(schemaAttributeGroupImpl.getName(), schemaAttributeGroupImpl);
                addSpelling(schemaAttributeGroupImpl.getName(), schemaAttributeGroupImpl);
                container.addAttributeGroup(schemaAttributeGroupImpl.getRef());
            } else {
                if (ignoreMdef(name)) {
                    return;
                }
                if (this._mdefAll) {
                    warning(XmlErrorCodes.SCHEMA_PROPERTIES$DUPLICATE, new Object[]{"attribute group", QNameHelper.pretty(name), ((SchemaComponent) this._attributeGroups.get(name)).getSourceName()}, schemaAttributeGroupImpl.getParseObject());
                } else {
                    error(XmlErrorCodes.SCHEMA_PROPERTIES$DUPLICATE, new Object[]{"attribute group", QNameHelper.pretty(name), ((SchemaComponent) this._attributeGroups.get(name)).getSourceName()}, schemaAttributeGroupImpl.getParseObject());
                }
            }
        }
    }

    public void addAttributeType(SchemaTypeImpl schemaTypeImpl, QName qName) {
        if (this._attributeTypes.containsKey(qName)) {
            if (ignoreMdef(qName)) {
                return;
            }
            if (this._mdefAll) {
                warning(XmlErrorCodes.SCHEMA_PROPERTIES$DUPLICATE, new Object[]{"global attribute", QNameHelper.pretty(qName), ((SchemaComponent) this._attributeTypes.get(qName)).getSourceName()}, schemaTypeImpl.getParseObject());
                return;
            } else {
                error(XmlErrorCodes.SCHEMA_PROPERTIES$DUPLICATE, new Object[]{"global attribute", QNameHelper.pretty(qName), ((SchemaComponent) this._attributeTypes.get(qName)).getSourceName()}, schemaTypeImpl.getParseObject());
                return;
            }
        }
        this._attributeTypes.put(qName, schemaTypeImpl);
        SchemaContainer container = getContainer(qName.getNamespaceURI());
        if (!$assertionsDisabled && (container == null || container != schemaTypeImpl.getContainer())) {
            throw new AssertionError();
        }
        container.addAttributeType(schemaTypeImpl.getRef());
    }

    public void addClassname(String str, SchemaType schemaType) {
        this._typesByClassname.put(str, schemaType);
    }

    public void addDocumentType(SchemaTypeImpl schemaTypeImpl, QName qName) {
        if (this._documentTypes.containsKey(qName)) {
            if (ignoreMdef(qName)) {
                return;
            }
            if (this._mdefAll) {
                warning(XmlErrorCodes.SCHEMA_PROPERTIES$DUPLICATE, new Object[]{"global element", QNameHelper.pretty(qName), ((SchemaComponent) this._documentTypes.get(qName)).getSourceName()}, schemaTypeImpl.getParseObject());
                return;
            } else {
                error(XmlErrorCodes.SCHEMA_PROPERTIES$DUPLICATE, new Object[]{"global element", QNameHelper.pretty(qName), ((SchemaComponent) this._documentTypes.get(qName)).getSourceName()}, schemaTypeImpl.getParseObject());
                return;
            }
        }
        this._documentTypes.put(qName, schemaTypeImpl);
        SchemaContainer container = getContainer(qName.getNamespaceURI());
        if (!$assertionsDisabled && (container == null || container != schemaTypeImpl.getContainer())) {
            throw new AssertionError();
        }
        container.addDocumentType(schemaTypeImpl.getRef());
    }

    public void addGlobalAttribute(SchemaGlobalAttributeImpl schemaGlobalAttributeImpl) {
        if (schemaGlobalAttributeImpl != null) {
            QName name = schemaGlobalAttributeImpl.getName();
            this._globalAttributes.put(name, schemaGlobalAttributeImpl);
            addSpelling(name, schemaGlobalAttributeImpl);
            SchemaContainer container = getContainer(name.getNamespaceURI());
            if (!$assertionsDisabled && (container == null || container != schemaGlobalAttributeImpl.getContainer())) {
                throw new AssertionError();
            }
            container.addGlobalAttribute(schemaGlobalAttributeImpl.getRef());
        }
    }

    public void addGlobalElement(SchemaGlobalElementImpl schemaGlobalElementImpl) {
        if (schemaGlobalElementImpl != null) {
            QName name = schemaGlobalElementImpl.getName();
            this._globalElements.put(name, schemaGlobalElementImpl);
            SchemaContainer container = getContainer(name.getNamespaceURI());
            if (!$assertionsDisabled && (container == null || container != schemaGlobalElementImpl.getContainer())) {
                throw new AssertionError();
            }
            container.addGlobalElement(schemaGlobalElementImpl.getRef());
            addSpelling(name, schemaGlobalElementImpl);
        }
    }

    public void addGlobalType(SchemaTypeImpl schemaTypeImpl, SchemaTypeImpl schemaTypeImpl2) {
        if (schemaTypeImpl != null) {
            QName name = schemaTypeImpl.getName();
            SchemaContainer container = getContainer(name.getNamespaceURI());
            if (!$assertionsDisabled && (container == null || container != schemaTypeImpl.getContainer())) {
                throw new AssertionError();
            }
            if (schemaTypeImpl2 != null) {
                if (!this._redefinedGlobalTypes.containsKey(schemaTypeImpl2)) {
                    this._redefinedGlobalTypes.put(schemaTypeImpl2, schemaTypeImpl);
                    container.addRedefinedType(schemaTypeImpl.getRef());
                    return;
                } else {
                    if (ignoreMdef(name)) {
                        return;
                    }
                    if (this._mdefAll) {
                        warning(XmlErrorCodes.SCHEMA_PROPERTIES$DUPLICATE, new Object[]{"global type", QNameHelper.pretty(name), ((SchemaType) this._redefinedGlobalTypes.get(schemaTypeImpl2)).getSourceName()}, schemaTypeImpl.getParseObject());
                        return;
                    } else {
                        error(XmlErrorCodes.SCHEMA_PROPERTIES$DUPLICATE, new Object[]{"global type", QNameHelper.pretty(name), ((SchemaType) this._redefinedGlobalTypes.get(schemaTypeImpl2)).getSourceName()}, schemaTypeImpl.getParseObject());
                        return;
                    }
                }
            }
            if (!this._globalTypes.containsKey(name)) {
                this._globalTypes.put(name, schemaTypeImpl);
                container.addGlobalType(schemaTypeImpl.getRef());
                addSpelling(name, schemaTypeImpl);
            } else {
                if (ignoreMdef(name)) {
                    return;
                }
                if (this._mdefAll) {
                    warning(XmlErrorCodes.SCHEMA_PROPERTIES$DUPLICATE, new Object[]{"global type", QNameHelper.pretty(name), ((SchemaType) this._globalTypes.get(name)).getSourceName()}, schemaTypeImpl.getParseObject());
                } else {
                    error(XmlErrorCodes.SCHEMA_PROPERTIES$DUPLICATE, new Object[]{"global type", QNameHelper.pretty(name), ((SchemaType) this._globalTypes.get(name)).getSourceName()}, schemaTypeImpl.getParseObject());
                }
            }
        }
    }

    public void addIdConstraint(SchemaIdentityConstraintImpl schemaIdentityConstraintImpl) {
        if (schemaIdentityConstraintImpl != null) {
            QName name = schemaIdentityConstraintImpl.getName();
            SchemaContainer container = getContainer(name.getNamespaceURI());
            if (!$assertionsDisabled && (container == null || container != schemaIdentityConstraintImpl.getContainer())) {
                throw new AssertionError();
            }
            if (this._idConstraints.containsKey(name)) {
                if (ignoreMdef(name)) {
                    return;
                }
                warning(XmlErrorCodes.SCHEMA_PROPERTIES$DUPLICATE, new Object[]{"identity constraint", QNameHelper.pretty(name), ((SchemaComponent) this._idConstraints.get(name)).getSourceName()}, schemaIdentityConstraintImpl.getParseObject());
            } else {
                this._idConstraints.put(name, schemaIdentityConstraintImpl);
                addSpelling(schemaIdentityConstraintImpl.getName(), schemaIdentityConstraintImpl);
                container.addIdentityConstraint(schemaIdentityConstraintImpl.getRef());
            }
        }
    }

    public void addModelGroup(SchemaModelGroupImpl schemaModelGroupImpl, SchemaModelGroupImpl schemaModelGroupImpl2) {
        if (schemaModelGroupImpl != null) {
            QName name = schemaModelGroupImpl.getName();
            SchemaContainer container = getContainer(name.getNamespaceURI());
            if (!$assertionsDisabled && (container == null || container != schemaModelGroupImpl.getContainer())) {
                throw new AssertionError();
            }
            if (schemaModelGroupImpl2 != null) {
                if (!this._redefinedModelGroups.containsKey(schemaModelGroupImpl2)) {
                    this._redefinedModelGroups.put(schemaModelGroupImpl2, schemaModelGroupImpl);
                    container.addRedefinedModelGroup(schemaModelGroupImpl.getRef());
                    return;
                } else {
                    if (ignoreMdef(name)) {
                        return;
                    }
                    if (this._mdefAll) {
                        warning(XmlErrorCodes.SCHEMA_PROPERTIES$DUPLICATE, new Object[]{"model group", QNameHelper.pretty(name), ((SchemaComponent) this._redefinedModelGroups.get(schemaModelGroupImpl2)).getSourceName()}, schemaModelGroupImpl.getParseObject());
                        return;
                    } else {
                        error(XmlErrorCodes.SCHEMA_PROPERTIES$DUPLICATE, new Object[]{"model group", QNameHelper.pretty(name), ((SchemaComponent) this._redefinedModelGroups.get(schemaModelGroupImpl2)).getSourceName()}, schemaModelGroupImpl.getParseObject());
                        return;
                    }
                }
            }
            if (!this._modelGroups.containsKey(name)) {
                this._modelGroups.put(schemaModelGroupImpl.getName(), schemaModelGroupImpl);
                addSpelling(schemaModelGroupImpl.getName(), schemaModelGroupImpl);
                container.addModelGroup(schemaModelGroupImpl.getRef());
            } else {
                if (ignoreMdef(name)) {
                    return;
                }
                if (this._mdefAll) {
                    warning(XmlErrorCodes.SCHEMA_PROPERTIES$DUPLICATE, new Object[]{"model group", QNameHelper.pretty(name), ((SchemaComponent) this._modelGroups.get(name)).getSourceName()}, schemaModelGroupImpl.getParseObject());
                } else {
                    error(XmlErrorCodes.SCHEMA_PROPERTIES$DUPLICATE, new Object[]{"model group", QNameHelper.pretty(name), ((SchemaComponent) this._modelGroups.get(name)).getSourceName()}, schemaModelGroupImpl.getParseObject());
                }
            }
        }
    }

    public void addNamespace(String str) {
        this._namespaces.add(str);
    }

    public void addNewContainer(String str) {
        if (this._containers.containsKey(str)) {
            return;
        }
        SchemaContainer schemaContainer = new SchemaContainer(str);
        schemaContainer.setTypeSystem(sts());
        addNamespace(str);
        this._containers.put(str, schemaContainer);
    }

    public void addSchemaDigest(byte[] bArr) {
        if (this._noDigest) {
            return;
        }
        if (bArr == null) {
            this._noDigest = true;
            this._digest = null;
            return;
        }
        if (this._digest == null) {
            this._digest = new byte[16];
        }
        int length = this._digest.length;
        if (bArr.length < length) {
            length = bArr.length;
        }
        for (int i = 0; i < length; i++) {
            byte[] bArr2 = this._digest;
            bArr2[i] = (byte) (bArr2[i] ^ bArr[i]);
        }
    }

    public void addSourceUri(String str, String str2) {
        if (str == null) {
            return;
        }
        if (str2 == null) {
            str2 = computeSavedFilename(str);
        }
        this._sourceForUri.put(str, str2);
    }

    public void addSpelling(QName qName, SchemaComponent schemaComponent) {
        this._misspelledNames.put(crunchName(qName), schemaComponent);
    }

    public boolean allowPartial() {
        return this._allowPartial;
    }

    public List annotations() {
        return this._annotations;
    }

    public SchemaAttributeGroup[] attributeGroups() {
        return (SchemaAttributeGroup[]) this._attributeGroups.values().toArray(new SchemaAttributeGroup[this._attributeGroups.size()]);
    }

    public SchemaType[] attributeTypes() {
        return (SchemaType[]) this._attributeTypes.values().toArray(new SchemaType[this._attributeTypes.size()]);
    }

    public String computeSavedFilename(String str) {
        return relativize(str, true);
    }

    public SchemaType[] documentTypes() {
        return (SchemaType[]) this._documentTypes.values().toArray(new SchemaType[this._documentTypes.size()]);
    }

    public void error(String str, int i, XmlObject xmlObject) {
        addError(this._errorListener, str, i, xmlObject);
    }

    public SchemaAttributeGroupImpl findAttributeGroup(QName qName, String str, String str2) {
        QName qNameCompatName = compatName(qName, str);
        SchemaAttributeGroupImpl schemaAttributeGroupImpl = (SchemaAttributeGroupImpl) this._attributeGroups.get(qNameCompatName);
        boolean z = false;
        if (schemaAttributeGroupImpl == null && (schemaAttributeGroupImpl = (SchemaAttributeGroupImpl) this._importingLoader.findAttributeGroup(qNameCompatName)) != null) {
            z = true;
        }
        if (!z && str2 != null) {
            registerDependency(str2, qNameCompatName.getNamespaceURI());
        }
        return schemaAttributeGroupImpl;
    }

    public SchemaTypeImpl findAttributeType(QName qName, String str, String str2) {
        QName qNameCompatName = compatName(qName, str);
        SchemaTypeImpl schemaTypeImpl = (SchemaTypeImpl) this._attributeTypes.get(qNameCompatName);
        boolean z = false;
        if (schemaTypeImpl == null && (schemaTypeImpl = (SchemaTypeImpl) this._importingLoader.findAttributeType(qNameCompatName)) != null) {
            z = true;
        }
        if (!z && str2 != null) {
            registerDependency(str2, qNameCompatName.getNamespaceURI());
        }
        return schemaTypeImpl;
    }

    public SchemaTypeImpl findDocumentType(QName qName, String str, String str2) {
        QName qNameCompatName = compatName(qName, str);
        SchemaTypeImpl schemaTypeImpl = (SchemaTypeImpl) this._documentTypes.get(qNameCompatName);
        boolean z = false;
        if (schemaTypeImpl == null && (schemaTypeImpl = (SchemaTypeImpl) this._importingLoader.findDocumentType(qNameCompatName)) != null) {
            z = true;
        }
        if (!z && str2 != null) {
            registerDependency(str2, qNameCompatName.getNamespaceURI());
        }
        return schemaTypeImpl;
    }

    public SchemaGlobalAttributeImpl findGlobalAttribute(QName qName, String str, String str2) {
        QName qNameCompatName = compatName(qName, str);
        SchemaGlobalAttributeImpl schemaGlobalAttributeImpl = (SchemaGlobalAttributeImpl) this._globalAttributes.get(qNameCompatName);
        boolean z = false;
        if (schemaGlobalAttributeImpl == null && (schemaGlobalAttributeImpl = (SchemaGlobalAttributeImpl) this._importingLoader.findAttribute(qNameCompatName)) != null) {
            z = true;
        }
        if (!z && str2 != null) {
            registerDependency(str2, qNameCompatName.getNamespaceURI());
        }
        return schemaGlobalAttributeImpl;
    }

    public SchemaGlobalElementImpl findGlobalElement(QName qName, String str, String str2) {
        QName qNameCompatName = compatName(qName, str);
        SchemaGlobalElementImpl schemaGlobalElementImpl = (SchemaGlobalElementImpl) this._globalElements.get(qNameCompatName);
        boolean z = false;
        if (schemaGlobalElementImpl == null && (schemaGlobalElementImpl = (SchemaGlobalElementImpl) this._importingLoader.findElement(qNameCompatName)) != null) {
            z = true;
        }
        if (!z && str2 != null) {
            registerDependency(str2, qNameCompatName.getNamespaceURI());
        }
        return schemaGlobalElementImpl;
    }

    public SchemaTypeImpl findGlobalType(QName qName, String str, String str2) {
        QName qNameCompatName = compatName(qName, str);
        SchemaTypeImpl schemaTypeImpl = (SchemaTypeImpl) this._globalTypes.get(qNameCompatName);
        boolean z = false;
        if (schemaTypeImpl == null && (schemaTypeImpl = (SchemaTypeImpl) this._importingLoader.findType(qNameCompatName)) != null) {
            z = true;
        }
        if (!z && str2 != null) {
            registerDependency(str2, qNameCompatName.getNamespaceURI());
        }
        return schemaTypeImpl;
    }

    public SchemaIdentityConstraintImpl findIdConstraint(QName qName, String str, String str2) {
        QName qNameCompatName = compatName(qName, str);
        if (str2 != null) {
            registerDependency(str2, qNameCompatName.getNamespaceURI());
        }
        return (SchemaIdentityConstraintImpl) this._idConstraints.get(qNameCompatName);
    }

    public SchemaModelGroupImpl findModelGroup(QName qName, String str, String str2) {
        QName qNameCompatName = compatName(qName, str);
        SchemaModelGroupImpl schemaModelGroupImpl = (SchemaModelGroupImpl) this._modelGroups.get(qNameCompatName);
        boolean z = false;
        if (schemaModelGroupImpl == null && (schemaModelGroupImpl = (SchemaModelGroupImpl) this._importingLoader.findModelGroup(qNameCompatName)) != null) {
            z = true;
        }
        if (!z && str2 != null) {
            registerDependency(str2, qNameCompatName.getNamespaceURI());
        }
        return schemaModelGroupImpl;
    }

    public SchemaAttributeGroupImpl findRedefinedAttributeGroup(QName qName, String str, SchemaAttributeGroupImpl schemaAttributeGroupImpl) {
        QName name = schemaAttributeGroupImpl.getName();
        QName qNameCompatName = compatName(qName, str);
        if (qNameCompatName.equals(name)) {
            return (SchemaAttributeGroupImpl) this._redefinedAttributeGroups.get(schemaAttributeGroupImpl);
        }
        SchemaAttributeGroupImpl schemaAttributeGroupImpl2 = (SchemaAttributeGroupImpl) this._attributeGroups.get(qNameCompatName);
        return schemaAttributeGroupImpl2 == null ? this._importingLoader.findAttributeGroup(qNameCompatName) : schemaAttributeGroupImpl2;
    }

    public SchemaTypeImpl findRedefinedGlobalType(QName qName, String str, SchemaTypeImpl schemaTypeImpl) {
        QName name = schemaTypeImpl.getName();
        QName qNameCompatName = compatName(qName, str);
        if (qNameCompatName.equals(name)) {
            return (SchemaTypeImpl) this._redefinedGlobalTypes.get(schemaTypeImpl);
        }
        SchemaTypeImpl schemaTypeImpl2 = (SchemaTypeImpl) this._globalTypes.get(qNameCompatName);
        return schemaTypeImpl2 == null ? (SchemaTypeImpl) this._importingLoader.findType(qNameCompatName) : schemaTypeImpl2;
    }

    public SchemaModelGroupImpl findRedefinedModelGroup(QName qName, String str, SchemaModelGroupImpl schemaModelGroupImpl) {
        QName name = schemaModelGroupImpl.getName();
        QName qNameCompatName = compatName(qName, str);
        if (qNameCompatName.equals(name)) {
            return (SchemaModelGroupImpl) this._redefinedModelGroups.get(schemaModelGroupImpl);
        }
        SchemaModelGroupImpl schemaModelGroupImpl2 = (SchemaModelGroupImpl) this._modelGroups.get(qNameCompatName);
        return schemaModelGroupImpl2 == null ? this._importingLoader.findModelGroup(qNameCompatName) : schemaModelGroupImpl2;
    }

    public SchemaComponent findSpelling(QName qName) {
        return (SchemaComponent) this._misspelledNames.get(crunchName(qName));
    }

    public void finishProcessing(Object obj) {
        if (!$assertionsDisabled && !this._processingGroups.contains(obj)) {
            throw new AssertionError();
        }
        this._processingGroups.remove(obj);
    }

    public BindingConfig getBindingConfig() {
        return this._config;
    }

    public SchemaContainer getContainer(String str) {
        return (SchemaContainer) this._containers.get(str);
    }

    public Map getContainerMap() {
        return Collections.unmodifiableMap(this._containers);
    }

    public Object[] getCurrentProcessing() {
        return this._processingGroups.toArray();
    }

    public SchemaDependencies getDependencies() {
        return this._dependencies;
    }

    public EntityResolver getEntityResolver() {
        return this._entityResolver;
    }

    public Collection getErrorListener() {
        return this._errorListener;
    }

    public String getJavaPrefix(String str) {
        BindingConfig bindingConfig = this._config;
        if (bindingConfig == null) {
            return null;
        }
        return bindingConfig.lookupPrefixForNamespace(str);
    }

    public String getJavaSuffix(String str) {
        BindingConfig bindingConfig = this._config;
        if (bindingConfig == null) {
            return null;
        }
        return bindingConfig.lookupSuffixForNamespace(str);
    }

    public String getJavaname(QName qName, int i) {
        BindingConfig bindingConfig = this._config;
        if (bindingConfig == null) {
            return null;
        }
        return bindingConfig.lookupJavanameForQName(qName, i);
    }

    public String[] getNamespaces() {
        Set set = this._namespaces;
        return (String[]) set.toArray(new String[set.size()]);
    }

    public String getPackageOverride(String str) {
        BindingConfig bindingConfig = this._config;
        if (bindingConfig == null) {
            return null;
        }
        return bindingConfig.lookupPackageForNamespace(str);
    }

    public int getRecovered() {
        return this._recoveredErrors;
    }

    public SchemaTypeLoader getS4SLoader() {
        return this._s4sloader;
    }

    public File getSchemasDir() {
        return this._schemasDir;
    }

    public SchemaGlobalAttribute[] globalAttributes() {
        return (SchemaGlobalAttribute[]) this._globalAttributes.values().toArray(new SchemaGlobalAttribute[this._globalAttributes.size()]);
    }

    public SchemaGlobalElement[] globalElements() {
        return (SchemaGlobalElement[]) this._globalElements.values().toArray(new SchemaGlobalElement[this._globalElements.size()]);
    }

    public SchemaType[] globalTypes() {
        return (SchemaType[]) this._globalTypes.values().toArray(new SchemaType[this._globalTypes.size()]);
    }

    public SchemaIdentityConstraintImpl[] idConstraints() {
        return (SchemaIdentityConstraintImpl[]) this._idConstraints.values().toArray(new SchemaIdentityConstraintImpl[this._idConstraints.size()]);
    }

    public void info(String str) {
        addInfo(this._errorListener, str);
    }

    public void initFromTypeSystem(SchemaTypeSystemImpl schemaTypeSystemImpl, Set set) {
        SchemaContainer[] schemaContainerArrContainers = schemaTypeSystemImpl.containers();
        for (int i = 0; i < schemaContainerArrContainers.length; i++) {
            if (!set.contains(schemaContainerArrContainers[i].getNamespace())) {
                addContainer(schemaContainerArrContainers[i]);
            }
        }
    }

    public boolean isFileProcessed(String str) {
        return this._dependencies.isFileRepresented(str);
    }

    public boolean isProcessing(Object obj) {
        return this._processingGroups.contains(obj);
    }

    public boolean linkerDefinesNamespace(String str) {
        return this._importingLoader.isNamespaceDefined(str);
    }

    public SchemaModelGroup[] modelGroups() {
        return (SchemaModelGroup[]) this._modelGroups.values().toArray(new SchemaModelGroup[this._modelGroups.size()]);
    }

    public boolean noAnn() {
        return this._noAnn;
    }

    public boolean noPvr() {
        return this._noPvr;
    }

    public boolean noUpa() {
        return this._noUpa;
    }

    public void notFoundError(QName qName, int i, XmlObject xmlObject, boolean z) {
        String str;
        String str2;
        String strPretty;
        String str3;
        Integer num;
        Integer num2;
        QName name;
        String sourceName;
        String strPretty2 = QNameHelper.pretty(qName);
        if (z) {
            this._recoveredErrors++;
        }
        String str4 = "element";
        if (i == 0) {
            str = "type";
        } else if (i == 1) {
            str = "element";
        } else if (i == 3) {
            str = "attribute";
        } else if (i == 4) {
            str = "attribute group";
        } else if (i == 5) {
            str = "identity constraint";
        } else if (i == 6) {
            str = "model group";
        } else {
            if (!$assertionsDisabled) {
                throw new AssertionError();
            }
            str = "definition";
        }
        SchemaComponent schemaComponentFindSpelling = findSpelling(qName);
        if (schemaComponentFindSpelling == null || (name = schemaComponentFindSpelling.getName()) == null) {
            str2 = null;
            strPretty = null;
            str3 = null;
        } else {
            int componentType = schemaComponentFindSpelling.getComponentType();
            if (componentType == 0) {
                str4 = "type";
                sourceName = ((SchemaType) schemaComponentFindSpelling).getSourceName();
            } else if (componentType == 1) {
                sourceName = ((SchemaGlobalElement) schemaComponentFindSpelling).getSourceName();
            } else if (componentType != 3) {
                if (componentType == 4) {
                    str4 = "attribute group";
                } else if (componentType != 6) {
                    sourceName = null;
                    str4 = null;
                } else {
                    str4 = "model group";
                }
                sourceName = null;
            } else {
                sourceName = ((SchemaGlobalAttribute) schemaComponentFindSpelling).getSourceName();
                str4 = "attribute";
            }
            if (sourceName != null) {
                sourceName = sourceName.substring(sourceName.lastIndexOf(47) + 1);
            }
            if (name.equals(qName)) {
                str3 = sourceName;
                str2 = str4;
                strPretty = null;
            } else {
                str3 = sourceName;
                str2 = str4;
                strPretty = QNameHelper.pretty(name);
            }
        }
        if (str2 == null) {
            error(XmlErrorCodes.SCHEMA_QNAME_RESOLVE, new Object[]{str, strPretty2}, xmlObject);
            return;
        }
        Integer num3 = strPretty == null ? new Integer(0) : new Integer(1);
        if (str3 == null) {
            num2 = num3;
            num = new Integer(0);
        } else {
            num = new Integer(1);
            num2 = num3;
        }
        error(XmlErrorCodes.SCHEMA_QNAME_RESOLVE$HELP, new Object[]{str, strPretty2, str2, num2, strPretty, num, str3}, xmlObject);
    }

    public void recover(String str, Object[] objArr, XmlObject xmlObject) {
        addError(this._errorListener, str, objArr, xmlObject);
        this._recoveredErrors++;
    }

    public SchemaAttributeGroup[] redefinedAttributeGroups() {
        return (SchemaAttributeGroup[]) this._redefinedAttributeGroups.values().toArray(new SchemaAttributeGroup[this._redefinedAttributeGroups.size()]);
    }

    public SchemaType[] redefinedGlobalTypes() {
        return (SchemaType[]) this._redefinedGlobalTypes.values().toArray(new SchemaType[this._redefinedGlobalTypes.size()]);
    }

    public SchemaModelGroup[] redefinedModelGroups() {
        return (SchemaModelGroup[]) this._redefinedModelGroups.values().toArray(new SchemaModelGroup[this._redefinedModelGroups.size()]);
    }

    public void registerContribution(String str, String str2) {
        this._dependencies.registerContribution(str, str2);
    }

    public void registerDependency(String str, String str2) {
        this._dependencies.registerDependency(str, str2);
    }

    public String relativize(String str) {
        return relativize(str, false);
    }

    public void setBaseUri(URI uri) {
        this._baseURI = uri;
    }

    public void setBindingConfig(BindingConfig bindingConfig) {
        this._config = bindingConfig;
    }

    public void setDependencies(SchemaDependencies schemaDependencies) {
        this._dependencies = schemaDependencies;
    }

    public void setErrorListener(Collection collection) {
        this._errorListener = collection;
    }

    public void setGivenTypeSystemName(String str) {
        this._givenStsName = str;
    }

    public void setImportingTypeLoader(SchemaTypeLoader schemaTypeLoader) {
        this._importingLoader = schemaTypeLoader;
    }

    public void setOptions(XmlOptions xmlOptions) {
        if (xmlOptions == null) {
            return;
        }
        this._allowPartial = xmlOptions.hasOption("COMPILE_PARTIAL_TYPESYSTEM");
        this._compatMap = (Map) xmlOptions.get(XmlOptions.COMPILE_SUBSTITUTE_NAMES);
        this._noUpa = xmlOptions.hasOption(XmlOptions.COMPILE_NO_UPA_RULE) || !"true".equals(SystemProperties.getProperty("xmlbean.uniqueparticleattribution", "true"));
        this._noPvr = xmlOptions.hasOption(XmlOptions.COMPILE_NO_PVR_RULE) || !"true".equals(SystemProperties.getProperty("xmlbean.particlerestriction", "true"));
        this._noAnn = xmlOptions.hasOption(XmlOptions.COMPILE_NO_ANNOTATIONS) || !"true".equals(SystemProperties.getProperty("xmlbean.schemaannotations", "true"));
        this._doingDownloads = xmlOptions.hasOption(XmlOptions.COMPILE_DOWNLOAD_URLS) ? true : "true".equals(SystemProperties.getProperty("xmlbean.downloadurls", "false"));
        EntityResolver entityResolver = (EntityResolver) xmlOptions.get(XmlOptions.ENTITY_RESOLVER);
        this._entityResolver = entityResolver;
        if (entityResolver == null) {
            this._entityResolver = ResolverUtil.getGlobalEntityResolver();
        }
        if (this._entityResolver != null) {
            this._doingDownloads = true;
        }
        if (xmlOptions.hasOption(XmlOptions.COMPILE_MDEF_NAMESPACES)) {
            this._mdefNamespaces.addAll((Collection) xmlOptions.get(XmlOptions.COMPILE_MDEF_NAMESPACES));
            if (this._mdefNamespaces.contains("##local")) {
                this._mdefNamespaces.remove("##local");
                this._mdefNamespaces.add("");
            }
            if (this._mdefNamespaces.contains("##any")) {
                this._mdefNamespaces.remove("##any");
                this._mdefAll = true;
            }
        }
    }

    public void setSchemasDir(File file) {
        this._schemasDir = file;
    }

    public void setTargetSchemaTypeSystem(SchemaTypeSystemImpl schemaTypeSystemImpl) {
        this._target = schemaTypeSystemImpl;
    }

    public boolean shouldDownloadURI(String str) {
        if (this._doingDownloads) {
            return true;
        }
        if (str == null) {
            return false;
        }
        try {
            URI uri = new URI(str);
            if (!uri.getScheme().equalsIgnoreCase("jar") && !uri.getScheme().equalsIgnoreCase("zip")) {
                return uri.getScheme().equalsIgnoreCase("file");
            }
            String schemeSpecificPart = uri.getSchemeSpecificPart();
            int iLastIndexOf = schemeSpecificPart.lastIndexOf(33);
            if (iLastIndexOf > 0) {
                schemeSpecificPart = schemeSpecificPart.substring(0, iLastIndexOf);
            }
            return shouldDownloadURI(schemeSpecificPart);
        } catch (Exception unused) {
            return false;
        }
    }

    public Map sourceCopyMap() {
        return Collections.unmodifiableMap(this._sourceForUri);
    }

    public String sourceNameForUri(String str) {
        return (String) this._sourceForUri.get(str);
    }

    public void startProcessing(Object obj) {
        if (!$assertionsDisabled && this._processingGroups.contains(obj)) {
            throw new AssertionError();
        }
        this._processingGroups.add(obj);
    }

    public SchemaTypeSystemImpl sts() {
        byte[] bArr;
        SchemaTypeSystemImpl schemaTypeSystemImpl = this._target;
        if (schemaTypeSystemImpl != null) {
            return schemaTypeSystemImpl;
        }
        String strConcat = this._givenStsName;
        if (strConcat == null && (bArr = this._digest) != null) {
            strConcat = "s".concat(new String(HexBin.encode(bArr)));
        }
        SchemaTypeSystemImpl schemaTypeSystemImpl2 = new SchemaTypeSystemImpl(strConcat);
        this._target = schemaTypeSystemImpl2;
        return schemaTypeSystemImpl2;
    }

    public Map typesByClassname() {
        return Collections.unmodifiableMap(this._typesByClassname);
    }

    public void warning(String str, int i, XmlObject xmlObject) {
        addWarning(this._errorListener, str, i, xmlObject);
    }

    private StscState() throws Throwable {
        this._digest = null;
        this._noDigest = false;
        this._allowPartial = false;
        this._recoveredErrors = 0;
        this._containers = new LinkedHashMap();
        this._redefinedGlobalTypes = new LinkedHashMap();
        this._redefinedModelGroups = new LinkedHashMap();
        this._redefinedAttributeGroups = new LinkedHashMap();
        this._globalTypes = new LinkedHashMap();
        this._globalElements = new LinkedHashMap();
        this._globalAttributes = new LinkedHashMap();
        this._modelGroups = new LinkedHashMap();
        this._attributeGroups = new LinkedHashMap();
        this._documentTypes = new LinkedHashMap();
        this._attributeTypes = new LinkedHashMap();
        this._typesByClassname = new LinkedHashMap();
        this._misspelledNames = new HashMap();
        this._processingGroups = new LinkedHashSet();
        this._idConstraints = new LinkedHashMap();
        this._namespaces = new HashSet();
        this._annotations = new ArrayList();
        this._mdefNamespaces = buildDefaultMdefNamespaces();
        this._sourceForUri = new HashMap();
        this._baseURI = URI.create("project://local/");
        Class clsClass$ = class$org$apache$xmlbeans$impl$xb$xsdschema$SchemaDocument;
        if (clsClass$ == null) {
            clsClass$ = class$("org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument");
            class$org$apache$xmlbeans$impl$xb$xsdschema$SchemaDocument = clsClass$;
        }
        this._s4sloader = XmlBeans.typeLoaderForClassLoader(clsClass$.getClassLoader());
    }

    private String relativize(String str, boolean z) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("/")) {
            StringBuffer stringBuffer = new StringBuffer(PROJECT_URL_PREFIX);
            stringBuffer.append(str.replace('\\', '/'));
            str = stringBuffer.toString();
        } else {
            int iIndexOf = str.indexOf(58);
            if (iIndexOf <= 1 || !str.substring(0, iIndexOf).matches("^\\w+$")) {
                StringBuffer stringBuffer2 = new StringBuffer("project://local/");
                stringBuffer2.append(str.replace('\\', '/'));
                str = stringBuffer2.toString();
            }
        }
        URI uri = this._baseURI;
        if (uri != null) {
            try {
                URI uriRelativize = uri.relativize(new URI(str));
                if (!uriRelativize.isAbsolute()) {
                    return uriRelativize.toString();
                }
                str = uriRelativize.toString();
            } catch (URISyntaxException unused) {
            }
        }
        if (!z) {
            return str;
        }
        int iLastIndexOf = str.lastIndexOf(47);
        String strHexsafe = QNameHelper.hexsafe(iLastIndexOf == -1 ? "" : str.substring(0, iLastIndexOf));
        int i = iLastIndexOf + 1;
        int iIndexOf2 = str.indexOf(63, i);
        if (iIndexOf2 == -1) {
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append(strHexsafe);
            stringBuffer3.append("/");
            stringBuffer3.append(str.substring(i));
            return stringBuffer3.toString();
        }
        String strHexsafe2 = QNameHelper.hexsafe(iIndexOf2 != -1 ? str.substring(iIndexOf2) : "");
        if (strHexsafe2.startsWith(QNameHelper.URI_SHA1_PREFIX)) {
            StringBuffer stringBuffer4 = new StringBuffer();
            stringBuffer4.append(strHexsafe);
            stringBuffer4.append("/");
            stringBuffer4.append(str.substring(i, iIndexOf2));
            return stringBuffer4.toString();
        }
        StringBuffer stringBuffer5 = new StringBuffer();
        stringBuffer5.append(strHexsafe);
        stringBuffer5.append("/");
        stringBuffer5.append(str.substring(i, iIndexOf2));
        stringBuffer5.append(strHexsafe2);
        return stringBuffer5.toString();
    }

    public void error(String str, Object[] objArr, XmlObject xmlObject) {
        addError(this._errorListener, str, objArr, xmlObject);
    }

    public void info(String str, Object[] objArr) {
        addInfo(this._errorListener, str, objArr);
    }

    public void warning(String str, Object[] objArr, XmlObject xmlObject) {
        if (str != XmlErrorCodes.RESERVED_TYPE_NAME || xmlObject.documentProperties().getSourceName() == null || xmlObject.documentProperties().getSourceName().indexOf("XMLSchema.xsd") <= 0) {
            addWarning(this._errorListener, str, objArr, xmlObject);
        }
    }

    public static void addError(Collection collection, String str, Object[] objArr, XmlObject xmlObject) {
        collection.add(XmlError.forObject(str, objArr, 0, xmlObject));
    }

    public static void addInfo(Collection collection, String str, Object[] objArr) {
        collection.add(XmlError.forMessage(str, objArr, 2));
    }

    public static void addWarning(Collection collection, String str, Object[] objArr, XmlObject xmlObject) {
        collection.add(XmlError.forObject(str, objArr, 1, xmlObject));
    }

    public static void addError(Collection collection, String str, Object[] objArr, File file) {
        collection.add(XmlError.forLocation(str, objArr, 0, file.toURI().toString(), 0, 0, 0));
    }

    public static void addError(Collection collection, String str, Object[] objArr, URL url) {
        collection.add(XmlError.forLocation(str, objArr, 0, url.toString(), 0, 0, 0));
    }
}
