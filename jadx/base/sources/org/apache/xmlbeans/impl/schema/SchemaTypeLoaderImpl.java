package org.apache.xmlbeans.impl.schema;

import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.AbstractC12991c;
import org.apache.poi.javax.xml.XMLConstants;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.ResourceLoader;
import org.apache.xmlbeans.SchemaAttributeGroup;
import org.apache.xmlbeans.SchemaGlobalAttribute;
import org.apache.xmlbeans.SchemaGlobalElement;
import org.apache.xmlbeans.SchemaIdentityConstraint;
import org.apache.xmlbeans.SchemaModelGroup;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.SchemaTypeSystem;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.SystemCache;
import org.apache.xmlbeans.impl.common.XBeanDebug;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class SchemaTypeLoaderImpl extends SchemaTypeLoaderBase {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final Object CACHED_NOT_FOUND;
    private static final SchemaTypeLoader[] EMPTY_SCHEMATYPELOADER_ARRAY;
    public static String METADATA_PACKAGE_LOAD;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$schema$SchemaTypeLoaderImpl;
    private Map _attributeCache;
    private Map _attributeGroupCache;
    private Map _attributeTypeCache;
    private ClassLoader _classLoader;
    private Map _classLoaderTypeSystems;
    private Map _classnameCache;
    private Map _classpathTypeSystems;
    private Map _documentCache;
    private Map _elementCache;
    private Map _idConstraintCache;
    private Map _modelGroupCache;
    private ResourceLoader _resourceLoader;
    private SchemaTypeLoader[] _searchPath;
    private Map _typeCache;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SchemaTypeLoaderCache extends SystemCache {
        static final /* synthetic */ boolean $assertionsDisabled;
        private ThreadLocal _cachedTypeSystems;

        static {
            if (SchemaTypeLoaderImpl.class$org$apache$xmlbeans$impl$schema$SchemaTypeLoaderImpl == null) {
                SchemaTypeLoaderImpl.class$org$apache$xmlbeans$impl$schema$SchemaTypeLoaderImpl = SchemaTypeLoaderImpl.class$("org.apache.xmlbeans.impl.schema.SchemaTypeLoaderImpl");
            }
            $assertionsDisabled = true;
        }

        private SchemaTypeLoaderCache() {
            this._cachedTypeSystems = new ThreadLocal() { // from class: org.apache.xmlbeans.impl.schema.SchemaTypeLoaderImpl.SchemaTypeLoaderCache.1
                @Override // java.lang.ThreadLocal
                public Object initialValue() {
                    return new ArrayList();
                }
            };
        }

        @Override // org.apache.xmlbeans.impl.common.SystemCache
        public void addToTypeLoaderCache(SchemaTypeLoader schemaTypeLoader, ClassLoader classLoader) {
            if (!$assertionsDisabled && (!(schemaTypeLoader instanceof SchemaTypeLoaderImpl) || ((SchemaTypeLoaderImpl) schemaTypeLoader)._classLoader != classLoader)) {
                throw new AssertionError();
            }
            ArrayList arrayList = (ArrayList) this._cachedTypeSystems.get();
            if (arrayList.size() <= 0) {
                arrayList.add(new SoftReference(schemaTypeLoader));
                return;
            }
            Object obj = arrayList.get(0);
            arrayList.set(0, new SoftReference(schemaTypeLoader));
            arrayList.add(obj);
        }

        @Override // org.apache.xmlbeans.impl.common.SystemCache
        public SchemaTypeLoader getFromTypeLoaderCache(ClassLoader classLoader) {
            SchemaTypeLoaderImpl schemaTypeLoaderImpl;
            ArrayList arrayList = (ArrayList) this._cachedTypeSystems.get();
            int i = 0;
            while (true) {
                if (i >= arrayList.size()) {
                    schemaTypeLoaderImpl = null;
                    i = -1;
                    break;
                }
                schemaTypeLoaderImpl = (SchemaTypeLoaderImpl) ((SoftReference) arrayList.get(i)).get();
                if (schemaTypeLoaderImpl == null) {
                    if (!$assertionsDisabled && i <= -1) {
                        throw new AssertionError();
                    }
                    arrayList.remove(i);
                    i--;
                } else if (schemaTypeLoaderImpl._classLoader == classLoader) {
                    break;
                }
                i++;
            }
            if (i > 0) {
                Object obj = arrayList.get(0);
                arrayList.set(0, arrayList.get(i));
                arrayList.set(i, obj);
            }
            return schemaTypeLoaderImpl;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SubLoaderList {
        private Map seen;
        private List theList;

        private SubLoaderList() {
            this.theList = new ArrayList();
            this.seen = new IdentityHashMap();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean add(SchemaTypeLoader schemaTypeLoader) {
            if (this.seen.containsKey(schemaTypeLoader)) {
                return false;
            }
            this.theList.add(schemaTypeLoader);
            this.seen.put(schemaTypeLoader, null);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public SchemaTypeLoader[] toArray() {
            return (SchemaTypeLoader[]) this.theList.toArray(SchemaTypeLoaderImpl.EMPTY_SCHEMATYPELOADER_ARRAY);
        }
    }

    static {
        if (class$org$apache$xmlbeans$impl$schema$SchemaTypeLoaderImpl == null) {
            class$org$apache$xmlbeans$impl$schema$SchemaTypeLoaderImpl = class$("org.apache.xmlbeans.impl.schema.SchemaTypeLoaderImpl");
        }
        $assertionsDisabled = true;
        METADATA_PACKAGE_LOAD = SchemaTypeSystemImpl.METADATA_PACKAGE_GEN;
        CACHED_NOT_FOUND = new Object();
        EMPTY_SCHEMATYPELOADER_ARRAY = new SchemaTypeLoader[0];
        if (SystemCache.get() != null) {
            SystemCache.set(new SchemaTypeLoaderCache());
        }
    }

    private SchemaTypeLoaderImpl(SchemaTypeLoader[] schemaTypeLoaderArr, ResourceLoader resourceLoader, ClassLoader classLoader) {
        if (schemaTypeLoaderArr == null) {
            this._searchPath = EMPTY_SCHEMATYPELOADER_ARRAY;
        } else {
            this._searchPath = schemaTypeLoaderArr;
        }
        this._resourceLoader = resourceLoader;
        this._classLoader = classLoader;
        initCaches();
    }

    public static SchemaTypeLoader build(SchemaTypeLoader[] schemaTypeLoaderArr, ResourceLoader resourceLoader, ClassLoader classLoader) {
        SchemaTypeLoader[] array;
        if (schemaTypeLoaderArr == null) {
            array = EMPTY_SCHEMATYPELOADER_ARRAY;
        } else {
            SubLoaderList subLoaderList = new SubLoaderList();
            for (int i = 0; i < schemaTypeLoaderArr.length; i++) {
                SchemaTypeLoader schemaTypeLoader = schemaTypeLoaderArr[i];
                if (schemaTypeLoader == null) {
                    StringBuffer stringBuffer = new StringBuffer("searchPath[");
                    stringBuffer.append(i);
                    stringBuffer.append("] is null");
                    throw new IllegalArgumentException(stringBuffer.toString());
                }
                if (schemaTypeLoader instanceof SchemaTypeLoaderImpl) {
                    SchemaTypeLoaderImpl schemaTypeLoaderImpl = (SchemaTypeLoaderImpl) schemaTypeLoader;
                    if (schemaTypeLoaderImpl._classLoader == null && schemaTypeLoaderImpl._resourceLoader == null) {
                        int i2 = 0;
                        while (true) {
                            SchemaTypeLoader[] schemaTypeLoaderArr2 = schemaTypeLoaderImpl._searchPath;
                            if (i2 < schemaTypeLoaderArr2.length) {
                                subLoaderList.add(schemaTypeLoaderArr2[i2]);
                                i2++;
                            }
                        }
                    } else {
                        subLoaderList.add(schemaTypeLoaderImpl);
                    }
                } else {
                    subLoaderList.add(schemaTypeLoader);
                }
            }
            array = subLoaderList.toArray();
        }
        return (array.length == 1 && resourceLoader == null && classLoader == null) ? array[0] : new SchemaTypeLoaderImpl(array, resourceLoader, classLoader);
    }

    public static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw AbstractC12991c.m13994o(e);
        }
    }

    public static String crackEntry(ResourceLoader resourceLoader, String str) {
        InputStream resourceAsStream = resourceLoader.getResourceAsStream(str);
        if (resourceAsStream == null) {
            return null;
        }
        return crackPointer(resourceAsStream);
    }

    public static String crackPointer(InputStream inputStream) {
        return SchemaTypeSystemImpl.crackPointer(inputStream);
    }

    public static SchemaTypeLoaderImpl getContextTypeLoader() {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        SchemaTypeLoaderImpl schemaTypeLoaderImpl = (SchemaTypeLoaderImpl) SystemCache.get().getFromTypeLoaderCache(contextClassLoader);
        if (schemaTypeLoaderImpl != null) {
            return schemaTypeLoaderImpl;
        }
        SchemaTypeLoaderImpl schemaTypeLoaderImpl2 = new SchemaTypeLoaderImpl(new SchemaTypeLoader[]{BuiltinSchemaTypeSystem.get()}, null, contextClassLoader);
        SystemCache.get().addToTypeLoaderCache(schemaTypeLoaderImpl2, contextClassLoader);
        return schemaTypeLoaderImpl2;
    }

    private final void initCaches() {
        this._classpathTypeSystems = Collections.synchronizedMap(new HashMap());
        this._classLoaderTypeSystems = Collections.synchronizedMap(new HashMap());
        this._elementCache = Collections.synchronizedMap(new HashMap());
        this._attributeCache = Collections.synchronizedMap(new HashMap());
        this._modelGroupCache = Collections.synchronizedMap(new HashMap());
        this._attributeGroupCache = Collections.synchronizedMap(new HashMap());
        this._idConstraintCache = Collections.synchronizedMap(new HashMap());
        this._typeCache = Collections.synchronizedMap(new HashMap());
        this._documentCache = Collections.synchronizedMap(new HashMap());
        this._attributeTypeCache = Collections.synchronizedMap(new HashMap());
        this._classnameCache = Collections.synchronizedMap(new HashMap());
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaAttributeGroup.Ref findAttributeGroupRef(QName qName) {
        Object obj = this._attributeGroupCache.get(qName);
        if (obj == CACHED_NOT_FOUND) {
            return null;
        }
        SchemaAttributeGroup.Ref refFindAttributeGroupRef = (SchemaAttributeGroup.Ref) obj;
        if (refFindAttributeGroupRef == null) {
            int i = 0;
            while (true) {
                SchemaTypeLoader[] schemaTypeLoaderArr = this._searchPath;
                if (i >= schemaTypeLoaderArr.length || (refFindAttributeGroupRef = schemaTypeLoaderArr[i].findAttributeGroupRef(qName)) != null) {
                    break;
                }
                i++;
            }
            if (refFindAttributeGroupRef == null) {
                StringBuffer stringBuffer = new StringBuffer("schema");
                stringBuffer.append(METADATA_PACKAGE_LOAD);
                stringBuffer.append("/attributegroup/");
                SchemaTypeSystemImpl schemaTypeSystemImplTypeSystemForComponent = typeSystemForComponent(stringBuffer.toString(), qName);
                if (schemaTypeSystemImplTypeSystemForComponent != null) {
                    refFindAttributeGroupRef = schemaTypeSystemImplTypeSystemForComponent.findAttributeGroupRef(qName);
                    if (!$assertionsDisabled && refFindAttributeGroupRef == null) {
                        StringBuffer stringBuffer2 = new StringBuffer("Type system registered attribute group ");
                        stringBuffer2.append(QNameHelper.pretty(qName));
                        stringBuffer2.append(" but does not return it");
                        throw new AssertionError(stringBuffer2.toString());
                    }
                }
            }
            this._attributeGroupCache.put(qName, refFindAttributeGroupRef == null ? CACHED_NOT_FOUND : refFindAttributeGroupRef);
        }
        return refFindAttributeGroupRef;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaGlobalAttribute.Ref findAttributeRef(QName qName) {
        Object obj = this._attributeCache.get(qName);
        if (obj == CACHED_NOT_FOUND) {
            return null;
        }
        SchemaGlobalAttribute.Ref refFindAttributeRef = (SchemaGlobalAttribute.Ref) obj;
        if (refFindAttributeRef == null) {
            int i = 0;
            while (true) {
                SchemaTypeLoader[] schemaTypeLoaderArr = this._searchPath;
                if (i >= schemaTypeLoaderArr.length || (refFindAttributeRef = schemaTypeLoaderArr[i].findAttributeRef(qName)) != null) {
                    break;
                }
                i++;
            }
            if (refFindAttributeRef == null) {
                StringBuffer stringBuffer = new StringBuffer("schema");
                stringBuffer.append(METADATA_PACKAGE_LOAD);
                stringBuffer.append("/attribute/");
                SchemaTypeSystemImpl schemaTypeSystemImplTypeSystemForComponent = typeSystemForComponent(stringBuffer.toString(), qName);
                if (schemaTypeSystemImplTypeSystemForComponent != null) {
                    refFindAttributeRef = schemaTypeSystemImplTypeSystemForComponent.findAttributeRef(qName);
                    if (!$assertionsDisabled && refFindAttributeRef == null) {
                        StringBuffer stringBuffer2 = new StringBuffer("Type system registered attribute ");
                        stringBuffer2.append(QNameHelper.pretty(qName));
                        stringBuffer2.append(" but does not return it");
                        throw new AssertionError(stringBuffer2.toString());
                    }
                }
            }
            this._attributeCache.put(qName, refFindAttributeRef == null ? CACHED_NOT_FOUND : refFindAttributeRef);
        }
        return refFindAttributeRef;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType.Ref findAttributeTypeRef(QName qName) {
        Object obj = this._attributeTypeCache.get(qName);
        if (obj == CACHED_NOT_FOUND) {
            return null;
        }
        SchemaType.Ref refFindAttributeTypeRef = (SchemaType.Ref) obj;
        if (refFindAttributeTypeRef == null) {
            int i = 0;
            while (true) {
                SchemaTypeLoader[] schemaTypeLoaderArr = this._searchPath;
                if (i >= schemaTypeLoaderArr.length || (refFindAttributeTypeRef = schemaTypeLoaderArr[i].findAttributeTypeRef(qName)) != null) {
                    break;
                }
                i++;
            }
            if (refFindAttributeTypeRef == null) {
                StringBuffer stringBuffer = new StringBuffer("schema");
                stringBuffer.append(METADATA_PACKAGE_LOAD);
                stringBuffer.append("/attribute/");
                SchemaTypeSystemImpl schemaTypeSystemImplTypeSystemForComponent = typeSystemForComponent(stringBuffer.toString(), qName);
                if (schemaTypeSystemImplTypeSystemForComponent != null) {
                    refFindAttributeTypeRef = schemaTypeSystemImplTypeSystemForComponent.findAttributeTypeRef(qName);
                    if (!$assertionsDisabled && refFindAttributeTypeRef == null) {
                        StringBuffer stringBuffer2 = new StringBuffer("Type system registered attribute ");
                        stringBuffer2.append(QNameHelper.pretty(qName));
                        stringBuffer2.append(" but does not contain attribute type");
                        throw new AssertionError(stringBuffer2.toString());
                    }
                }
            }
            this._attributeTypeCache.put(qName, refFindAttributeTypeRef == null ? CACHED_NOT_FOUND : refFindAttributeTypeRef);
        }
        return refFindAttributeTypeRef;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType.Ref findDocumentTypeRef(QName qName) {
        Object obj = this._documentCache.get(qName);
        if (obj == CACHED_NOT_FOUND) {
            return null;
        }
        SchemaType.Ref refFindDocumentTypeRef = (SchemaType.Ref) obj;
        if (refFindDocumentTypeRef == null) {
            int i = 0;
            while (true) {
                SchemaTypeLoader[] schemaTypeLoaderArr = this._searchPath;
                if (i >= schemaTypeLoaderArr.length || (refFindDocumentTypeRef = schemaTypeLoaderArr[i].findDocumentTypeRef(qName)) != null) {
                    break;
                }
                i++;
            }
            if (refFindDocumentTypeRef == null) {
                StringBuffer stringBuffer = new StringBuffer("schema");
                stringBuffer.append(METADATA_PACKAGE_LOAD);
                stringBuffer.append("/element/");
                SchemaTypeSystemImpl schemaTypeSystemImplTypeSystemForComponent = typeSystemForComponent(stringBuffer.toString(), qName);
                if (schemaTypeSystemImplTypeSystemForComponent != null) {
                    refFindDocumentTypeRef = schemaTypeSystemImplTypeSystemForComponent.findDocumentTypeRef(qName);
                    if (!$assertionsDisabled && refFindDocumentTypeRef == null) {
                        StringBuffer stringBuffer2 = new StringBuffer("Type system registered element ");
                        stringBuffer2.append(QNameHelper.pretty(qName));
                        stringBuffer2.append(" but does not contain document type");
                        throw new AssertionError(stringBuffer2.toString());
                    }
                }
            }
            this._documentCache.put(qName, refFindDocumentTypeRef == null ? CACHED_NOT_FOUND : refFindDocumentTypeRef);
        }
        return refFindDocumentTypeRef;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaGlobalElement.Ref findElementRef(QName qName) {
        Object obj = this._elementCache.get(qName);
        if (obj == CACHED_NOT_FOUND) {
            return null;
        }
        SchemaGlobalElement.Ref refFindElementRef = (SchemaGlobalElement.Ref) obj;
        if (refFindElementRef == null) {
            int i = 0;
            while (true) {
                SchemaTypeLoader[] schemaTypeLoaderArr = this._searchPath;
                if (i >= schemaTypeLoaderArr.length || (refFindElementRef = schemaTypeLoaderArr[i].findElementRef(qName)) != null) {
                    break;
                }
                i++;
            }
            if (refFindElementRef == null) {
                StringBuffer stringBuffer = new StringBuffer("schema");
                stringBuffer.append(METADATA_PACKAGE_LOAD);
                stringBuffer.append("/element/");
                SchemaTypeSystemImpl schemaTypeSystemImplTypeSystemForComponent = typeSystemForComponent(stringBuffer.toString(), qName);
                if (schemaTypeSystemImplTypeSystemForComponent != null) {
                    refFindElementRef = schemaTypeSystemImplTypeSystemForComponent.findElementRef(qName);
                    if (!$assertionsDisabled && refFindElementRef == null) {
                        StringBuffer stringBuffer2 = new StringBuffer("Type system registered element ");
                        stringBuffer2.append(QNameHelper.pretty(qName));
                        stringBuffer2.append(" but does not return it");
                        throw new AssertionError(stringBuffer2.toString());
                    }
                }
            }
            this._elementCache.put(qName, refFindElementRef == null ? CACHED_NOT_FOUND : refFindElementRef);
        }
        return refFindElementRef;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaIdentityConstraint.Ref findIdentityConstraintRef(QName qName) {
        Object obj = this._idConstraintCache.get(qName);
        if (obj == CACHED_NOT_FOUND) {
            return null;
        }
        SchemaIdentityConstraint.Ref refFindIdentityConstraintRef = (SchemaIdentityConstraint.Ref) obj;
        if (refFindIdentityConstraintRef == null) {
            int i = 0;
            while (true) {
                SchemaTypeLoader[] schemaTypeLoaderArr = this._searchPath;
                if (i >= schemaTypeLoaderArr.length || (refFindIdentityConstraintRef = schemaTypeLoaderArr[i].findIdentityConstraintRef(qName)) != null) {
                    break;
                }
                i++;
            }
            if (refFindIdentityConstraintRef == null) {
                StringBuffer stringBuffer = new StringBuffer("schema");
                stringBuffer.append(METADATA_PACKAGE_LOAD);
                stringBuffer.append("/identityconstraint/");
                SchemaTypeSystemImpl schemaTypeSystemImplTypeSystemForComponent = typeSystemForComponent(stringBuffer.toString(), qName);
                if (schemaTypeSystemImplTypeSystemForComponent != null) {
                    refFindIdentityConstraintRef = schemaTypeSystemImplTypeSystemForComponent.findIdentityConstraintRef(qName);
                    if (!$assertionsDisabled && refFindIdentityConstraintRef == null) {
                        StringBuffer stringBuffer2 = new StringBuffer("Type system registered identity constraint ");
                        stringBuffer2.append(QNameHelper.pretty(qName));
                        stringBuffer2.append(" but does not return it");
                        throw new AssertionError(stringBuffer2.toString());
                    }
                }
            }
            this._idConstraintCache.put(qName, refFindIdentityConstraintRef == null ? CACHED_NOT_FOUND : refFindIdentityConstraintRef);
        }
        return refFindIdentityConstraintRef;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaModelGroup.Ref findModelGroupRef(QName qName) {
        Object obj = this._modelGroupCache.get(qName);
        if (obj == CACHED_NOT_FOUND) {
            return null;
        }
        SchemaModelGroup.Ref refFindModelGroupRef = (SchemaModelGroup.Ref) obj;
        if (refFindModelGroupRef == null) {
            int i = 0;
            while (true) {
                SchemaTypeLoader[] schemaTypeLoaderArr = this._searchPath;
                if (i >= schemaTypeLoaderArr.length || (refFindModelGroupRef = schemaTypeLoaderArr[i].findModelGroupRef(qName)) != null) {
                    break;
                }
                i++;
            }
            if (refFindModelGroupRef == null) {
                StringBuffer stringBuffer = new StringBuffer("schema");
                stringBuffer.append(METADATA_PACKAGE_LOAD);
                stringBuffer.append("/modelgroup/");
                SchemaTypeSystemImpl schemaTypeSystemImplTypeSystemForComponent = typeSystemForComponent(stringBuffer.toString(), qName);
                if (schemaTypeSystemImplTypeSystemForComponent != null) {
                    refFindModelGroupRef = schemaTypeSystemImplTypeSystemForComponent.findModelGroupRef(qName);
                    if (!$assertionsDisabled && refFindModelGroupRef == null) {
                        StringBuffer stringBuffer2 = new StringBuffer("Type system registered model group ");
                        stringBuffer2.append(QNameHelper.pretty(qName));
                        stringBuffer2.append(" but does not return it");
                        throw new AssertionError(stringBuffer2.toString());
                    }
                }
            }
            this._modelGroupCache.put(qName, refFindModelGroupRef == null ? CACHED_NOT_FOUND : refFindModelGroupRef);
        }
        return refFindModelGroupRef;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType.Ref findTypeRef(QName qName) {
        Object obj = this._typeCache.get(qName);
        if (obj == CACHED_NOT_FOUND) {
            return null;
        }
        SchemaType.Ref refFindTypeRef = (SchemaType.Ref) obj;
        if (refFindTypeRef == null) {
            int i = 0;
            while (true) {
                SchemaTypeLoader[] schemaTypeLoaderArr = this._searchPath;
                if (i >= schemaTypeLoaderArr.length || (refFindTypeRef = schemaTypeLoaderArr[i].findTypeRef(qName)) != null) {
                    break;
                }
                i++;
            }
            if (refFindTypeRef == null) {
                StringBuffer stringBuffer = new StringBuffer("schema");
                stringBuffer.append(METADATA_PACKAGE_LOAD);
                stringBuffer.append("/type/");
                SchemaTypeSystemImpl schemaTypeSystemImplTypeSystemForComponent = typeSystemForComponent(stringBuffer.toString(), qName);
                if (schemaTypeSystemImplTypeSystemForComponent != null) {
                    refFindTypeRef = schemaTypeSystemImplTypeSystemForComponent.findTypeRef(qName);
                    if (!$assertionsDisabled && refFindTypeRef == null) {
                        StringBuffer stringBuffer2 = new StringBuffer("Type system registered type ");
                        stringBuffer2.append(QNameHelper.pretty(qName));
                        stringBuffer2.append(" but does not return it");
                        throw new AssertionError(stringBuffer2.toString());
                    }
                }
            }
            this._typeCache.put(qName, refFindTypeRef == null ? CACHED_NOT_FOUND : refFindTypeRef);
        }
        return refFindTypeRef;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public InputStream getSourceAsStream(String str) {
        InputStream resourceAsStream;
        ClassLoader classLoader;
        if (!str.startsWith("/")) {
            str = "/".concat(str);
        }
        ResourceLoader resourceLoader = this._resourceLoader;
        if (resourceLoader != null) {
            StringBuffer stringBuffer = new StringBuffer("schema");
            stringBuffer.append(METADATA_PACKAGE_LOAD);
            stringBuffer.append("/src");
            stringBuffer.append(str);
            resourceAsStream = resourceLoader.getResourceAsStream(stringBuffer.toString());
        } else {
            resourceAsStream = null;
        }
        if (resourceAsStream != null || (classLoader = this._classLoader) == null) {
            return resourceAsStream;
        }
        StringBuffer stringBuffer2 = new StringBuffer("schema");
        stringBuffer2.append(METADATA_PACKAGE_LOAD);
        stringBuffer2.append("/src");
        stringBuffer2.append(str);
        return classLoader.getResourceAsStream(stringBuffer2.toString());
    }

    public SchemaTypeSystemImpl getTypeSystemOnClassloader(String str) throws Throwable {
        StringBuffer stringBuffer = new StringBuffer("Finding type system ");
        stringBuffer.append(str);
        stringBuffer.append(" on classloader");
        XBeanDebug.trace(1, stringBuffer.toString(), 0);
        SchemaTypeSystemImpl schemaTypeSystemImpl = (SchemaTypeSystemImpl) this._classLoaderTypeSystems.get(str);
        if (schemaTypeSystemImpl != null) {
            return schemaTypeSystemImpl;
        }
        StringBuffer stringBuffer2 = new StringBuffer("Type system ");
        stringBuffer2.append(str);
        stringBuffer2.append(" not cached - consulting field");
        XBeanDebug.trace(1, stringBuffer2.toString(), 0);
        SchemaTypeSystemImpl schemaTypeSystemImplForName = SchemaTypeSystemImpl.forName(str, this._classLoader);
        this._classLoaderTypeSystems.put(str, schemaTypeSystemImplForName);
        return schemaTypeSystemImplForName;
    }

    public SchemaTypeSystemImpl getTypeSystemOnClasspath(String str) {
        SchemaTypeSystemImpl schemaTypeSystemImpl = (SchemaTypeSystemImpl) this._classpathTypeSystems.get(str);
        if (schemaTypeSystemImpl != null) {
            return schemaTypeSystemImpl;
        }
        SchemaTypeSystemImpl schemaTypeSystemImpl2 = new SchemaTypeSystemImpl(this._resourceLoader, str, this);
        this._classpathTypeSystems.put(str, schemaTypeSystemImpl2);
        return schemaTypeSystemImpl2;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public boolean isNamespaceDefined(String str) {
        int i = 0;
        while (true) {
            SchemaTypeLoader[] schemaTypeLoaderArr = this._searchPath;
            if (i >= schemaTypeLoaderArr.length) {
                return typeSystemForComponent(AbstractC8014b.m7199a(new StringBuffer("schema"), METADATA_PACKAGE_LOAD, "/namespace/"), new QName(str, XMLConstants.XMLNS_ATTRIBUTE)) != null;
            }
            if (schemaTypeLoaderArr[i].isNamespaceDefined(str)) {
                return true;
            }
            i++;
        }
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType typeForClassname(String str) {
        String strReplace = str.replace('$', '.');
        Object obj = this._classnameCache.get(strReplace);
        if (obj == CACHED_NOT_FOUND) {
            return null;
        }
        SchemaType schemaTypeTypeForClassname = (SchemaType) obj;
        if (schemaTypeTypeForClassname == null) {
            int i = 0;
            while (true) {
                SchemaTypeLoader[] schemaTypeLoaderArr = this._searchPath;
                if (i >= schemaTypeLoaderArr.length || (schemaTypeTypeForClassname = schemaTypeLoaderArr[i].typeForClassname(strReplace)) != null) {
                    break;
                }
                i++;
            }
            if (schemaTypeTypeForClassname == null) {
                StringBuffer stringBuffer = new StringBuffer("schema");
                stringBuffer.append(METADATA_PACKAGE_LOAD);
                stringBuffer.append("/javaname/");
                SchemaTypeSystemImpl schemaTypeSystemImplTypeSystemForClassname = typeSystemForClassname(stringBuffer.toString(), strReplace);
                if (schemaTypeSystemImplTypeSystemForClassname != null) {
                    schemaTypeTypeForClassname = schemaTypeSystemImplTypeSystemForClassname.typeForClassname(strReplace);
                    if (!$assertionsDisabled && schemaTypeTypeForClassname == null) {
                        throw new AssertionError(AbstractC12991c.m13990k("Type system registered type ", strReplace, " but does not return it"));
                    }
                }
            }
            this._classnameCache.put(strReplace, schemaTypeTypeForClassname == null ? CACHED_NOT_FOUND : schemaTypeTypeForClassname);
        }
        return schemaTypeTypeForClassname;
    }

    public SchemaTypeSystemImpl typeSystemForClassname(String str, String str2) {
        String strCrackEntry;
        String strCrackEntry2;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(str2.replace('.', '/'));
        stringBuffer.append(".xsb");
        String string = stringBuffer.toString();
        ResourceLoader resourceLoader = this._resourceLoader;
        if (resourceLoader != null && (strCrackEntry2 = crackEntry(resourceLoader, string)) != null) {
            return getTypeSystemOnClasspath(strCrackEntry2);
        }
        ClassLoader classLoader = this._classLoader;
        if (classLoader == null || (strCrackEntry = crackEntry(classLoader, string)) == null) {
            return null;
        }
        return getTypeSystemOnClassloader(strCrackEntry);
    }

    public SchemaTypeSystemImpl typeSystemForComponent(String str, QName qName) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(QNameHelper.hexsafedir(qName));
        stringBuffer.append(".xsb");
        String string = stringBuffer.toString();
        ResourceLoader resourceLoader = this._resourceLoader;
        String strCrackEntry = resourceLoader != null ? crackEntry(resourceLoader, string) : null;
        ClassLoader classLoader = this._classLoader;
        if (classLoader != null) {
            strCrackEntry = crackEntry(classLoader, string);
        }
        if (strCrackEntry != null) {
            return (SchemaTypeSystemImpl) typeSystemForName(strCrackEntry);
        }
        return null;
    }

    public SchemaTypeSystem typeSystemForName(String str) {
        SchemaTypeSystemImpl typeSystemOnClassloader;
        SchemaTypeSystemImpl typeSystemOnClasspath;
        if (this._resourceLoader != null && (typeSystemOnClasspath = getTypeSystemOnClasspath(str)) != null) {
            return typeSystemOnClasspath;
        }
        if (this._classLoader == null || (typeSystemOnClassloader = getTypeSystemOnClassloader(str)) == null) {
            return null;
        }
        return typeSystemOnClassloader;
    }

    public static String crackEntry(ClassLoader classLoader, String str) {
        InputStream resourceAsStream = classLoader.getResourceAsStream(str);
        if (resourceAsStream == null) {
            return null;
        }
        return crackPointer(resourceAsStream);
    }
}
