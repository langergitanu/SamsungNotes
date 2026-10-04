package org.apache.xmlbeans;

import java.io.File;
import java.lang.ref.SoftReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.collections.AbstractC12991c;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.w3c.dom.Node;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class XmlBeans {
    private static final String HOLDER_CLASS_NAME = "TypeSystemHolder";
    public static SchemaType NO_TYPE = null;
    private static final String TYPE_SYSTEM_FIELD = "typeSystem";
    private static String XMLBEANS_TITLE = "org.apache.xmlbeans";
    private static String XMLBEANS_VENDOR = "Apache Software Foundation";
    private static String XMLBEANS_VERSION = "2.6.0";
    private static final Method _compilationMethod;
    private static final Method _getBuiltinSchemaTypeSystemMethod;
    private static final Method _getContextTypeLoaderMethod;
    private static final Method _getNoTypeMethod;
    private static final Method _nodeToCursorMethod;
    private static final Method _nodeToXmlObjectMethod;
    private static final Method _nodeToXmlStreamMethod;
    private static final Constructor _pathResourceLoaderConstructor;
    private static final Method _streamToNodeMethod;
    private static final ThreadLocal _threadLocalLoaderQNameCache;
    private static final Method _typeLoaderBuilderMethod;
    static /* synthetic */ Class array$Ljava$io$File;
    static /* synthetic */ Class array$Lorg$apache$xmlbeans$SchemaTypeLoader;
    static /* synthetic */ Class array$Lorg$apache$xmlbeans$XmlObject;
    static /* synthetic */ Class class$java$lang$ClassLoader;
    static /* synthetic */ Class class$java$lang$String;
    static /* synthetic */ Class class$javax$xml$stream$XMLStreamReader;
    static /* synthetic */ Class class$org$apache$xmlbeans$BindingConfig;
    static /* synthetic */ Class class$org$apache$xmlbeans$Filer;
    static /* synthetic */ Class class$org$apache$xmlbeans$ResourceLoader;
    static /* synthetic */ Class class$org$apache$xmlbeans$SchemaTypeLoader;
    static /* synthetic */ Class class$org$apache$xmlbeans$SchemaTypeSystem;
    static /* synthetic */ Class class$org$apache$xmlbeans$XmlBeans;
    static /* synthetic */ Class class$org$apache$xmlbeans$XmlObject;
    static /* synthetic */ Class class$org$apache$xmlbeans$XmlOptions;
    static /* synthetic */ Class class$org$w3c$dom$Node;

    static {
        Class clsClass$ = class$org$apache$xmlbeans$XmlBeans;
        if (clsClass$ == null) {
            clsClass$ = class$("org.apache.xmlbeans.XmlBeans");
            class$org$apache$xmlbeans$XmlBeans = clsClass$;
        }
        Package r02 = clsClass$.getPackage();
        if (r02 != null) {
            XMLBEANS_TITLE = r02.getImplementationTitle();
            XMLBEANS_VERSION = r02.getImplementationVersion();
            XMLBEANS_VENDOR = r02.getImplementationVendor();
        }
        _threadLocalLoaderQNameCache = new ThreadLocal() { // from class: org.apache.xmlbeans.XmlBeans.1
            @Override // java.lang.ThreadLocal
            public Object initialValue() {
                return new SoftReference(new QNameCache(32));
            }
        };
        _getContextTypeLoaderMethod = buildGetContextTypeLoaderMethod();
        _getBuiltinSchemaTypeSystemMethod = buildGetBuiltinSchemaTypeSystemMethod();
        _getNoTypeMethod = buildGetNoTypeMethod();
        _typeLoaderBuilderMethod = buildTypeLoaderBuilderMethod();
        _compilationMethod = buildCompilationMethod();
        _nodeToCursorMethod = buildNodeToCursorMethod();
        _nodeToXmlObjectMethod = buildNodeToXmlObjectMethod();
        _nodeToXmlStreamMethod = buildNodeToXmlStreamMethod();
        _streamToNodeMethod = buildStreamToNodeMethod();
        _pathResourceLoaderConstructor = buildPathResourceLoaderConstructor();
        NO_TYPE = getNoType();
    }

    private XmlBeans() {
    }

    private static final Method buildCompilationMethod() throws Throwable {
        Class clsClass$ = class$java$lang$String;
        if (clsClass$ == null) {
            clsClass$ = class$("java.lang.String");
            class$java$lang$String = clsClass$;
        }
        Class cls = clsClass$;
        Class clsClass$2 = class$org$apache$xmlbeans$SchemaTypeSystem;
        if (clsClass$2 == null) {
            clsClass$2 = class$("org.apache.xmlbeans.SchemaTypeSystem");
            class$org$apache$xmlbeans$SchemaTypeSystem = clsClass$2;
        }
        Class cls2 = clsClass$2;
        Class clsClass$3 = array$Lorg$apache$xmlbeans$XmlObject;
        if (clsClass$3 == null) {
            clsClass$3 = class$("[Lorg.apache.xmlbeans.XmlObject;");
            array$Lorg$apache$xmlbeans$XmlObject = clsClass$3;
        }
        Class cls3 = clsClass$3;
        Class clsClass$4 = class$org$apache$xmlbeans$BindingConfig;
        if (clsClass$4 == null) {
            clsClass$4 = class$("org.apache.xmlbeans.BindingConfig");
            class$org$apache$xmlbeans$BindingConfig = clsClass$4;
        }
        Class cls4 = clsClass$4;
        Class clsClass$5 = class$org$apache$xmlbeans$SchemaTypeLoader;
        if (clsClass$5 == null) {
            clsClass$5 = class$("org.apache.xmlbeans.SchemaTypeLoader");
            class$org$apache$xmlbeans$SchemaTypeLoader = clsClass$5;
        }
        Class cls5 = clsClass$5;
        Class clsClass$6 = class$org$apache$xmlbeans$Filer;
        if (clsClass$6 == null) {
            clsClass$6 = class$("org.apache.xmlbeans.Filer");
            class$org$apache$xmlbeans$Filer = clsClass$6;
        }
        Class cls6 = clsClass$6;
        Class clsClass$7 = class$org$apache$xmlbeans$XmlOptions;
        if (clsClass$7 == null) {
            clsClass$7 = class$("org.apache.xmlbeans.XmlOptions");
            class$org$apache$xmlbeans$XmlOptions = clsClass$7;
        }
        return buildMethod("org.apache.xmlbeans.impl.schema.SchemaTypeSystemCompiler", "compile", new Class[]{cls, cls2, cls3, cls4, cls5, cls6, clsClass$7});
    }

    private static final Constructor buildConstructor(String str, Class[] clsArr) throws Throwable {
        try {
            Class clsClass$ = class$org$apache$xmlbeans$XmlBeans;
            if (clsClass$ == null) {
                clsClass$ = class$("org.apache.xmlbeans.XmlBeans");
                class$org$apache$xmlbeans$XmlBeans = clsClass$;
            }
            return Class.forName(str, false, clsClass$.getClassLoader()).getConstructor(clsArr);
        } catch (Exception e) {
            throw causedException(new IllegalStateException(AbstractC12991c.m13990k("Cannot load constructor for ", str, ": verify that xbean.jar is on the classpath")), e);
        }
    }

    private static final Method buildGetBuiltinSchemaTypeSystemMethod() {
        return buildNoArgMethod("org.apache.xmlbeans.impl.schema.BuiltinSchemaTypeSystem", "get");
    }

    private static Method buildGetContextTypeLoaderMethod() {
        return buildNoArgMethod("org.apache.xmlbeans.impl.schema.SchemaTypeLoaderImpl", "getContextTypeLoader");
    }

    private static final Method buildGetNoTypeMethod() {
        return buildNoArgMethod("org.apache.xmlbeans.impl.schema.BuiltinSchemaTypeSystem", "getNoType");
    }

    private static final Method buildMethod(String str, String str2, Class[] clsArr) throws Throwable {
        try {
            Class clsClass$ = class$org$apache$xmlbeans$XmlBeans;
            if (clsClass$ == null) {
                clsClass$ = class$("org.apache.xmlbeans.XmlBeans");
                class$org$apache$xmlbeans$XmlBeans = clsClass$;
            }
            return Class.forName(str, false, clsClass$.getClassLoader()).getMethod(str2, clsArr);
        } catch (Exception e) {
            throw causedException(new IllegalStateException(AbstractC12991c.m13990k("Cannot load ", str2, ": verify that xbean.jar is on the classpath")), e);
        }
    }

    private static final Method buildNoArgMethod(String str, String str2) {
        return buildMethod(str, str2, new Class[0]);
    }

    private static final Method buildNodeMethod(String str, String str2) throws Throwable {
        Class clsClass$ = class$org$w3c$dom$Node;
        if (clsClass$ == null) {
            clsClass$ = class$("org.w3c.dom.Node");
            class$org$w3c$dom$Node = clsClass$;
        }
        return buildMethod(str, str2, new Class[]{clsClass$});
    }

    private static final Method buildNodeToCursorMethod() {
        return buildNodeMethod("org.apache.xmlbeans.impl.store.Locale", "nodeToCursor");
    }

    private static final Method buildNodeToXmlObjectMethod() {
        return buildNodeMethod("org.apache.xmlbeans.impl.store.Locale", "nodeToXmlObject");
    }

    private static final Method buildNodeToXmlStreamMethod() {
        return buildNodeMethod("org.apache.xmlbeans.impl.store.Locale", "nodeToXmlStream");
    }

    private static final Constructor buildPathResourceLoaderConstructor() throws Throwable {
        Class clsClass$ = array$Ljava$io$File;
        if (clsClass$ == null) {
            clsClass$ = class$("[Ljava.io.File;");
            array$Ljava$io$File = clsClass$;
        }
        return buildConstructor("org.apache.xmlbeans.impl.schema.PathResourceLoader", new Class[]{clsClass$});
    }

    private static final Method buildStreamToNodeMethod() throws Throwable {
        Class clsClass$ = class$javax$xml$stream$XMLStreamReader;
        if (clsClass$ == null) {
            clsClass$ = class$("org.apache.poi.javax.xml.stream.XMLStreamReader");
            class$javax$xml$stream$XMLStreamReader = clsClass$;
        }
        return buildMethod("org.apache.xmlbeans.impl.store.Locale", "streamToNode", new Class[]{clsClass$});
    }

    private static final Method buildTypeLoaderBuilderMethod() throws Throwable {
        Class clsClass$ = array$Lorg$apache$xmlbeans$SchemaTypeLoader;
        if (clsClass$ == null) {
            clsClass$ = class$("[Lorg.apache.xmlbeans.SchemaTypeLoader;");
            array$Lorg$apache$xmlbeans$SchemaTypeLoader = clsClass$;
        }
        Class clsClass$2 = class$org$apache$xmlbeans$ResourceLoader;
        if (clsClass$2 == null) {
            clsClass$2 = class$("org.apache.xmlbeans.ResourceLoader");
            class$org$apache$xmlbeans$ResourceLoader = clsClass$2;
        }
        Class clsClass$3 = class$java$lang$ClassLoader;
        if (clsClass$3 == null) {
            clsClass$3 = class$("java.lang.ClassLoader");
            class$java$lang$ClassLoader = clsClass$3;
        }
        return buildMethod("org.apache.xmlbeans.impl.schema.SchemaTypeLoaderImpl", "build", new Class[]{clsClass$, clsClass$2, clsClass$3});
    }

    private static RuntimeException causedException(RuntimeException runtimeException, Throwable th) {
        runtimeException.initCause(th);
        return runtimeException;
    }

    public static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw AbstractC12991c.m13994o(e);
        }
    }

    public static String compilePath(String str) {
        return compilePath(str, null);
    }

    public static String compileQuery(String str) {
        return compileQuery(str, null);
    }

    public static SchemaTypeSystem compileXmlBeans(String str, SchemaTypeSystem schemaTypeSystem, XmlObject[] xmlObjectArr, BindingConfig bindingConfig, SchemaTypeLoader schemaTypeLoader, Filer filer, XmlOptions xmlOptions) throws XmlException {
        try {
            Method method = _compilationMethod;
            if (schemaTypeLoader == null) {
                schemaTypeLoader = getContextTypeLoader();
            }
            return (SchemaTypeSystem) method.invoke(null, str, schemaTypeSystem, xmlObjectArr, bindingConfig, schemaTypeLoader, filer, xmlOptions);
        } catch (IllegalAccessException unused) {
            throw new IllegalStateException("No access to SchemaTypeLoaderImpl.forSchemaXml(): verify that version of xbean.jar is correct");
        } catch (InvocationTargetException e) {
            throw wrappedException(e.getCause());
        }
    }

    public static SchemaTypeSystem compileXsd(XmlObject[] xmlObjectArr, SchemaTypeLoader schemaTypeLoader, XmlOptions xmlOptions) {
        return compileXmlBeans(null, null, xmlObjectArr, null, schemaTypeLoader, null, xmlOptions);
    }

    public static SchemaTypeSystem getBuiltinTypeSystem() {
        try {
            return (SchemaTypeSystem) _getBuiltinSchemaTypeSystemMethod.invoke(null, null);
        } catch (IllegalAccessException e) {
            throw causedException(new IllegalStateException("No access to BuiltinSchemaTypeSystem.get(): verify that version of xbean.jar is correct"), e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            IllegalStateException illegalStateException = new IllegalStateException(cause.getMessage());
            illegalStateException.initCause(cause);
            throw illegalStateException;
        }
    }

    public static SchemaTypeLoader getContextTypeLoader() {
        try {
            return (SchemaTypeLoader) _getContextTypeLoaderMethod.invoke(null, null);
        } catch (IllegalAccessException e) {
            throw causedException(new IllegalStateException("No access to SchemaTypeLoaderImpl.getContextTypeLoader(): verify that version of xbean.jar is correct"), e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            IllegalStateException illegalStateException = new IllegalStateException(cause.getMessage());
            illegalStateException.initCause(cause);
            throw illegalStateException;
        }
    }

    private static SchemaType getNoType() {
        try {
            return (SchemaType) _getNoTypeMethod.invoke(null, null);
        } catch (IllegalAccessException e) {
            throw causedException(new IllegalStateException("No access to SchemaTypeLoaderImpl.getContextTypeLoader(): verify that version of xbean.jar is correct"), e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            IllegalStateException illegalStateException = new IllegalStateException(cause.getMessage());
            illegalStateException.initCause(cause);
            throw illegalStateException;
        }
    }

    public static QName getQName(String str) {
        return getQNameCache().getName("", str);
    }

    public static QNameCache getQNameCache() {
        ThreadLocal threadLocal = _threadLocalLoaderQNameCache;
        QNameCache qNameCache = (QNameCache) ((SoftReference) threadLocal.get()).get();
        if (qNameCache != null) {
            return qNameCache;
        }
        QNameCache qNameCache2 = new QNameCache(32);
        threadLocal.set(new SoftReference(qNameCache2));
        return qNameCache2;
    }

    public static final String getTitle() {
        return XMLBEANS_TITLE;
    }

    public static final String getVendor() {
        return XMLBEANS_VENDOR;
    }

    public static final String getVersion() {
        return XMLBEANS_VERSION;
    }

    public static SchemaTypeLoader loadXsd(XmlObject[] xmlObjectArr) {
        return loadXsd(xmlObjectArr, null);
    }

    public static XmlCursor nodeToCursor(Node node) {
        try {
            return (XmlCursor) _nodeToCursorMethod.invoke(null, node);
        } catch (IllegalAccessException e) {
            throw causedException(new IllegalStateException("No access to nodeToCursor verify that version of xbean.jar is correct"), e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            IllegalStateException illegalStateException = new IllegalStateException(cause.getMessage());
            illegalStateException.initCause(cause);
            throw illegalStateException;
        }
    }

    public static XmlObject nodeToXmlObject(Node node) {
        try {
            return (XmlObject) _nodeToXmlObjectMethod.invoke(null, node);
        } catch (IllegalAccessException e) {
            throw causedException(new IllegalStateException("No access to nodeToXmlObject verify that version of xbean.jar is correct"), e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            IllegalStateException illegalStateException = new IllegalStateException(cause.getMessage());
            illegalStateException.initCause(cause);
            throw illegalStateException;
        }
    }

    public static XMLStreamReader nodeToXmlStreamReader(Node node) {
        try {
            return (XMLStreamReader) _nodeToXmlStreamMethod.invoke(null, node);
        } catch (IllegalAccessException e) {
            throw causedException(new IllegalStateException("No access to nodeToXmlStreamReader verify that version of xbean.jar is correct"), e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            IllegalStateException illegalStateException = new IllegalStateException(cause.getMessage());
            illegalStateException.initCause(cause);
            throw illegalStateException;
        }
    }

    public static ResourceLoader resourceLoaderForPath(File[] fileArr) {
        try {
            return (ResourceLoader) _pathResourceLoaderConstructor.newInstance(fileArr);
        } catch (IllegalAccessException e) {
            throw causedException(new IllegalStateException("No access to SchemaTypeLoaderImpl: verify that version of xbean.jar is correct"), e);
        } catch (InstantiationException e2) {
            throw causedException(new IllegalStateException(e2.getMessage()), e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            IllegalStateException illegalStateException = new IllegalStateException(cause.getMessage());
            illegalStateException.initCause(cause);
            throw illegalStateException;
        }
    }

    public static Node streamToNode(XMLStreamReader xMLStreamReader) {
        try {
            return (Node) _streamToNodeMethod.invoke(null, xMLStreamReader);
        } catch (IllegalAccessException e) {
            throw causedException(new IllegalStateException("No access to streamToNode verify that version of xbean.jar is correct"), e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            IllegalStateException illegalStateException = new IllegalStateException(cause.getMessage());
            illegalStateException.initCause(cause);
            throw illegalStateException;
        }
    }

    public static SchemaType typeForClass(Class cls) throws Throwable {
        if (cls != null) {
            Class clsClass$ = class$org$apache$xmlbeans$XmlObject;
            if (clsClass$ == null) {
                clsClass$ = class$("org.apache.xmlbeans.XmlObject");
                class$org$apache$xmlbeans$XmlObject = clsClass$;
            }
            if (clsClass$.isAssignableFrom(cls)) {
                try {
                    Field field = cls.getField("type");
                    if (field == null) {
                        return null;
                    }
                    return (SchemaType) field.get(null);
                } catch (Exception unused) {
                }
            }
        }
        return null;
    }

    public static SchemaTypeLoader typeLoaderForClassLoader(ClassLoader classLoader) {
        try {
            return (SchemaTypeLoader) _typeLoaderBuilderMethod.invoke(null, null, null, classLoader);
        } catch (IllegalAccessException e) {
            throw causedException(new IllegalStateException("No access to SchemaTypeLoaderImpl: verify that version of xbean.jar is correct"), e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            IllegalStateException illegalStateException = new IllegalStateException(cause.getMessage());
            illegalStateException.initCause(cause);
            throw illegalStateException;
        }
    }

    public static SchemaTypeLoader typeLoaderForResource(ResourceLoader resourceLoader) {
        try {
            return (SchemaTypeLoader) _typeLoaderBuilderMethod.invoke(null, null, resourceLoader, null);
        } catch (IllegalAccessException e) {
            throw causedException(new IllegalStateException("No access to SchemaTypeLoaderImpl: verify that version of xbean.jar is correct"), e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            IllegalStateException illegalStateException = new IllegalStateException(cause.getMessage());
            illegalStateException.initCause(cause);
            throw illegalStateException;
        }
    }

    public static SchemaTypeLoader typeLoaderUnion(SchemaTypeLoader[] schemaTypeLoaderArr) {
        try {
            return schemaTypeLoaderArr.length == 1 ? schemaTypeLoaderArr[0] : (SchemaTypeLoader) _typeLoaderBuilderMethod.invoke(null, schemaTypeLoaderArr, null, null);
        } catch (IllegalAccessException e) {
            throw causedException(new IllegalStateException("No access to SchemaTypeLoaderImpl: verify that version of xbean.jar is correct"), e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            IllegalStateException illegalStateException = new IllegalStateException(cause.getMessage());
            illegalStateException.initCause(cause);
            throw illegalStateException;
        }
    }

    public static SchemaTypeSystem typeSystemForClassLoader(ClassLoader classLoader, String str) {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append(".TypeSystemHolder");
            SchemaTypeSystem schemaTypeSystem = (SchemaTypeSystem) classLoader.loadClass(stringBuffer.toString()).getDeclaredField(TYPE_SYSTEM_FIELD).get(null);
            if (schemaTypeSystem != null) {
                return schemaTypeSystem;
            }
            StringBuffer stringBuffer2 = new StringBuffer("SchemaTypeSystem is null for field typeSystem on class with name ");
            stringBuffer2.append(str);
            stringBuffer2.append(".TypeSystemHolder. Please verify the version of xbean.jar is correct.");
            throw new RuntimeException(stringBuffer2.toString());
        } catch (ClassNotFoundException e) {
            throw causedException(new RuntimeException(AbstractC12991c.m13990k("Cannot load SchemaTypeSystem. Unable to load class with name ", str, ".TypeSystemHolder. Make sure the generated binary files are on the classpath.")), e);
        } catch (IllegalAccessException e2) {
            throw causedException(new RuntimeException(AbstractC12991c.m13990k("Field typeSystem on class ", str, ".TypeSystemHolderis not accessible. Please verify the version of xbean.jar is correct.")), e2);
        } catch (NoSuchFieldException e3) {
            throw causedException(new RuntimeException(AbstractC12991c.m13990k("Cannot find field typeSystem on class ", str, ".TypeSystemHolder. Please verify the version of xbean.jar is correct.")), e3);
        }
    }

    private static XmlException wrappedException(Throwable th) {
        return th instanceof XmlException ? (XmlException) th : new XmlException(th.getMessage(), th);
    }

    public static String compilePath(String str, XmlOptions xmlOptions) {
        return getContextTypeLoader().compilePath(str, xmlOptions);
    }

    public static String compileQuery(String str, XmlOptions xmlOptions) {
        return getContextTypeLoader().compileQuery(str, xmlOptions);
    }

    public static SchemaTypeSystem compileXsd(SchemaTypeSystem schemaTypeSystem, XmlObject[] xmlObjectArr, SchemaTypeLoader schemaTypeLoader, XmlOptions xmlOptions) {
        return compileXmlBeans(null, schemaTypeSystem, xmlObjectArr, null, schemaTypeLoader, null, xmlOptions);
    }

    public static QName getQName(String str, String str2) {
        return getQNameCache().getName(str, str2);
    }

    public static SchemaTypeLoader loadXsd(XmlObject[] xmlObjectArr, XmlOptions xmlOptions) throws XmlException {
        try {
            SchemaTypeSystem schemaTypeSystem = (SchemaTypeSystem) _compilationMethod.invoke(null, null, null, xmlObjectArr, null, getContextTypeLoader(), null, xmlOptions);
            if (schemaTypeSystem == null) {
                return null;
            }
            return typeLoaderUnion(new SchemaTypeLoader[]{schemaTypeSystem, getContextTypeLoader()});
        } catch (IllegalAccessException e) {
            throw causedException(new IllegalStateException("No access to SchemaTypeLoaderImpl.forSchemaXml(): verify that version of xbean.jar is correct"), e);
        } catch (InvocationTargetException e2) {
            throw wrappedException(e2.getCause());
        }
    }
}
