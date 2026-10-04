package org.apache.xmlbeans.impl.store;

import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.AbstractC12991c;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlDate;
import org.apache.xmlbeans.XmlDecimal;
import org.apache.xmlbeans.XmlDouble;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlFloat;
import org.apache.xmlbeans.XmlInteger;
import org.apache.xmlbeans.XmlLong;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlRuntimeException;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.common.XPath;
import org.apache.xmlbeans.impl.store.Cur;
import org.apache.xmlbeans.impl.store.Locale;
import org.apache.xmlbeans.impl.store.QueryDelegate;
import org.w3c.dom.Node;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class Query {
    static final /* synthetic */ boolean $assertionsDisabled;
    public static final String QUERY_DELEGATE_INTERFACE = "QUERY_DELEGATE_INTERFACE";
    private static String _delIntfName;
    public static String _useDelegateForXQuery;
    public static String _useXdkForXQuery;
    private static boolean _xdkAvailable;
    private static Method _xdkCompileQuery;
    private static HashMap _xdkQueryCache;
    private static boolean _xqrl2002Available;
    private static Method _xqrl2002CompileQuery;
    private static HashMap _xqrl2002QueryCache;
    private static boolean _xqrlAvailable;
    private static Method _xqrlCompileQuery;
    private static HashMap _xqrlQueryCache;
    static /* synthetic */ Class class$java$lang$Boolean;
    static /* synthetic */ Class class$java$lang$String;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$store$Query;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class DelegateQueryImpl extends Query {
        static final /* synthetic */ boolean $assertionsDisabled;
        private QueryDelegate.QueryInterface _xqueryImpl;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class DelegateQueryEngine {
            static final /* synthetic */ boolean $assertionsDisabled;
            private Cur _cur;
            private QueryDelegate.QueryInterface _engine;
            private XmlOptions _options;
            private long _version;

            static {
                if (Query.class$org$apache$xmlbeans$impl$store$Query == null) {
                    Query.class$org$apache$xmlbeans$impl$store$Query = Query.class$("org.apache.xmlbeans.impl.store.Query");
                }
                $assertionsDisabled = true;
            }

            public DelegateQueryEngine(QueryDelegate.QueryInterface queryInterface, Cur cur, XmlOptions xmlOptions) {
                this._engine = queryInterface;
                this._version = cur._locale.version();
                this._cur = cur.weakCur(this);
                this._options = xmlOptions;
            }

            private SchemaType getType(Object obj) {
                return obj instanceof Integer ? XmlInteger.type : obj instanceof Double ? XmlDouble.type : obj instanceof Long ? XmlLong.type : obj instanceof Float ? XmlFloat.type : obj instanceof BigDecimal ? XmlDecimal.type : obj instanceof Boolean ? XmlBoolean.type : obj instanceof String ? XmlString.type : obj instanceof Date ? XmlDate.type : XmlAnySimpleType.type;
            }

            private Cur loadNode(Locale locale, Node node) {
                Cur.CurLoadContext curLoadContext = new Cur.CurLoadContext(locale, this._options);
                try {
                    loadNodeHelper(locale, node, curLoadContext);
                    Cur curFinish = curLoadContext.finish();
                    Locale.associateSourceName(curFinish, this._options);
                    Locale.autoTypeDocument(curFinish, null, this._options);
                    return curFinish;
                } catch (Exception e) {
                    throw new XmlRuntimeException(e.getMessage(), e);
                }
            }

            private void loadNodeHelper(Locale locale, Node node, Locale.LoadContext loadContext) {
                if (node.getNodeType() == 2) {
                    loadContext.attr(new QName(node.getNamespaceURI(), node.getLocalName(), node.getPrefix()), node.getNodeValue());
                } else {
                    locale.loadNode(node, loadContext);
                }
            }

            public XmlCursor cursorExecute() {
                Cur cur = this._cur;
                if (cur != null) {
                    cur._locale.version();
                }
                List listExecQuery = this._engine.execQuery(this._cur.getDom(), (Map) XmlOptions.maskNull(this._options).get(XmlOptions.XQUERY_VARIABLE_MAP));
                if (!$assertionsDisabled && listExecQuery.size() <= -1) {
                    throw new AssertionError();
                }
                Cursor cursor = null;
                this._engine = null;
                Locale locale = Locale.getLocale(this._cur._locale._schemaTypeLoader, this._options);
                locale.enter();
                Cur.CurLoadContext curLoadContext = new Cur.CurLoadContext(locale, this._options);
                for (int i = 0; i < listExecQuery.size(); i++) {
                    try {
                        loadNodeHelper(locale, (Node) listExecQuery.get(i), curLoadContext);
                    } catch (Exception unused) {
                        locale.exit();
                    } catch (Throwable th) {
                        locale.exit();
                        throw th;
                    }
                }
                Cur curFinish = curLoadContext.finish();
                Locale.associateSourceName(curFinish, this._options);
                Locale.autoTypeDocument(curFinish, null, this._options);
                Cursor cursor2 = new Cursor(curFinish);
                locale.exit();
                cursor = cursor2;
                release();
                return cursor;
            }

            public XmlObject[] objectExecute() {
                Cur curLoadNode;
                Cur cur = this._cur;
                if (cur != null) {
                    cur._locale.version();
                }
                List listExecQuery = this._engine.execQuery(this._cur.getDom(), (Map) XmlOptions.maskNull(this._options).get(XmlOptions.XQUERY_VARIABLE_MAP));
                if (!$assertionsDisabled && listExecQuery.size() <= -1) {
                    throw new AssertionError();
                }
                XmlObject[] xmlObjectArr = new XmlObject[listExecQuery.size()];
                for (int i = 0; i < listExecQuery.size(); i++) {
                    Locale locale = Locale.getLocale(this._cur._locale._schemaTypeLoader, this._options);
                    locale.enter();
                    Object obj = listExecQuery.get(i);
                    try {
                        try {
                            if (obj instanceof Node) {
                                curLoadNode = loadNode(locale, (Node) obj);
                            } else {
                                curLoadNode = locale.load("<xml-fragment/>").tempCur();
                                curLoadNode.setValue(obj.toString());
                                Locale.autoTypeDocument(curLoadNode, getType(obj), null);
                                xmlObjectArr[i] = curLoadNode.getObject();
                            }
                            xmlObjectArr[i] = curLoadNode.getObject();
                            locale.exit();
                            curLoadNode.release();
                        } catch (XmlException e) {
                            throw new RuntimeException(e);
                        }
                    } catch (Throwable th) {
                        locale.exit();
                        throw th;
                    }
                }
                release();
                this._engine = null;
                return xmlObjectArr;
            }

            public void release() {
                Cur cur = this._cur;
                if (cur != null) {
                    cur.release();
                    this._cur = null;
                }
            }
        }

        static {
            if (Query.class$org$apache$xmlbeans$impl$store$Query == null) {
                Query.class$org$apache$xmlbeans$impl$store$Query = Query.class$("org.apache.xmlbeans.impl.store.Query");
            }
            $assertionsDisabled = true;
        }

        private DelegateQueryImpl(QueryDelegate.QueryInterface queryInterface) {
            this._xqueryImpl = queryInterface;
        }

        public static Query createDelegateCompiledQuery(String str, String str2, String str3, int i) {
            if (!$assertionsDisabled && (str3.startsWith(Extension.DOT) || str3.startsWith(".."))) {
                throw new AssertionError();
            }
            QueryDelegate.QueryInterface queryInterfaceCreateInstance = QueryDelegate.createInstance(str, str2, str3, i);
            if (queryInterfaceCreateInstance == null) {
                return null;
            }
            return new DelegateQueryImpl(queryInterfaceCreateInstance);
        }

        @Override // org.apache.xmlbeans.impl.store.Query
        public XmlCursor cursorExecute(Cur cur, XmlOptions xmlOptions) {
            return new DelegateQueryEngine(this._xqueryImpl, cur, xmlOptions).cursorExecute();
        }

        @Override // org.apache.xmlbeans.impl.store.Query
        public XmlObject[] objectExecute(Cur cur, XmlOptions xmlOptions) {
            return new DelegateQueryEngine(this._xqueryImpl, cur, xmlOptions).objectExecute();
        }
    }

    static {
        if (class$org$apache$xmlbeans$impl$store$Query == null) {
            class$org$apache$xmlbeans$impl$store$Query = class$("org.apache.xmlbeans.impl.store.Query");
        }
        $assertionsDisabled = true;
        _useDelegateForXQuery = "use delegate for xquery";
        _useXdkForXQuery = "use xdk for xquery";
        _xdkQueryCache = new HashMap();
        _xdkAvailable = true;
        _xqrlQueryCache = new HashMap();
        _xqrlAvailable = true;
        _xqrl2002QueryCache = new HashMap();
        _xqrl2002Available = true;
        Class clsClass$ = class$org$apache$xmlbeans$impl$store$Query;
        if (clsClass$ == null) {
            clsClass$ = class$("org.apache.xmlbeans.impl.store.Query");
            class$org$apache$xmlbeans$impl$store$Query = clsClass$;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clsClass$.getClassLoader().getResourceAsStream("META-INF/services/org.apache.xmlbeans.impl.store.QueryDelegate.QueryInterface")));
            _delIntfName = bufferedReader.readLine().trim();
            bufferedReader.close();
        } catch (Exception unused) {
            _delIntfName = null;
        }
    }

    public static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw AbstractC12991c.m13994o(e);
        }
    }

    public static synchronized String compileQuery(String str, XmlOptions xmlOptions) {
        getCompiledQuery(str, xmlOptions);
        return str;
    }

    private static Query createXdkCompiledQuery(String str, String str2) throws Throwable {
        if (!_xdkAvailable) {
            return null;
        }
        if (_xdkCompileQuery == null) {
            try {
                Class<?> cls = Class.forName("org.apache.xmlbeans.impl.store.OXQXBXqrlImpl");
                Class clsClass$ = class$java$lang$String;
                if (clsClass$ == null) {
                    clsClass$ = class$("java.lang.String");
                    class$java$lang$String = clsClass$;
                }
                Class clsClass$2 = class$java$lang$String;
                if (clsClass$2 == null) {
                    clsClass$2 = class$("java.lang.String");
                    class$java$lang$String = clsClass$2;
                }
                Class clsClass$3 = class$java$lang$Boolean;
                if (clsClass$3 == null) {
                    clsClass$3 = class$("java.lang.Boolean");
                    class$java$lang$Boolean = clsClass$3;
                }
                _xdkCompileQuery = cls.getDeclaredMethod("compileQuery", clsClass$, clsClass$2, clsClass$3);
            } catch (ClassNotFoundException unused) {
                _xdkAvailable = false;
                return null;
            } catch (Exception e) {
                _xdkAvailable = false;
                throw new RuntimeException(e.getMessage(), e);
            }
        }
        try {
            return (Query) _xdkCompileQuery.invoke(null, str, str2, new Boolean(true));
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2.getMessage(), e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            throw new RuntimeException(cause.getMessage(), cause);
        }
    }

    private static Query createXqrlCompiledQuery(String str, String str2) throws Throwable {
        if (!_xqrlAvailable) {
            return null;
        }
        if (_xqrlCompileQuery == null) {
            try {
                Class<?> cls = Class.forName("org.apache.xmlbeans.impl.store.XqrlImpl");
                Class clsClass$ = class$java$lang$String;
                if (clsClass$ == null) {
                    clsClass$ = class$("java.lang.String");
                    class$java$lang$String = clsClass$;
                }
                Class clsClass$2 = class$java$lang$String;
                if (clsClass$2 == null) {
                    clsClass$2 = class$("java.lang.String");
                    class$java$lang$String = clsClass$2;
                }
                Class clsClass$3 = class$java$lang$Boolean;
                if (clsClass$3 == null) {
                    clsClass$3 = class$("java.lang.Boolean");
                    class$java$lang$Boolean = clsClass$3;
                }
                _xqrlCompileQuery = cls.getDeclaredMethod("compileQuery", clsClass$, clsClass$2, clsClass$3);
            } catch (ClassNotFoundException unused) {
                _xqrlAvailable = false;
                return null;
            } catch (Exception e) {
                _xqrlAvailable = false;
                throw new RuntimeException(e.getMessage(), e);
            }
        }
        try {
            return (Query) _xqrlCompileQuery.invoke(null, str, str2, new Boolean(true));
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2.getMessage(), e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            throw new RuntimeException(cause.getMessage(), cause);
        }
    }

    public static XmlCursor cursorExecQuery(Cur cur, String str, XmlOptions xmlOptions) {
        return getCompiledQuery(str, xmlOptions).cursorExecute(cur, xmlOptions);
    }

    public static synchronized Query getCompiledQuery(String str, XmlOptions xmlOptions) {
        return getCompiledQuery(str, Path.getCurrentNodeVar(xmlOptions), xmlOptions);
    }

    private static Query getXqrl2002CompiledQuery(String str, String str2) throws Throwable {
        if (_xqrl2002Available && _xqrl2002CompileQuery == null) {
            try {
                Class<?> cls = Class.forName("org.apache.xmlbeans.impl.store.Xqrl2002Impl");
                Class clsClass$ = class$java$lang$String;
                if (clsClass$ == null) {
                    clsClass$ = class$("java.lang.String");
                    class$java$lang$String = clsClass$;
                }
                Class clsClass$2 = class$java$lang$String;
                if (clsClass$2 == null) {
                    clsClass$2 = class$("java.lang.String");
                    class$java$lang$String = clsClass$2;
                }
                Class clsClass$3 = class$java$lang$Boolean;
                if (clsClass$3 == null) {
                    clsClass$3 = class$("java.lang.Boolean");
                    class$java$lang$Boolean = clsClass$3;
                }
                _xqrl2002CompileQuery = cls.getDeclaredMethod("compileQuery", clsClass$, clsClass$2, clsClass$3);
            } catch (ClassNotFoundException unused) {
                _xqrl2002Available = false;
                return null;
            } catch (Exception e) {
                _xqrl2002Available = false;
                throw new RuntimeException(e.getMessage(), e);
            }
        }
        try {
            return (Query) _xqrl2002CompileQuery.invoke(null, str, str2, new Boolean(true));
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2.getMessage(), e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            throw new RuntimeException(cause.getMessage(), cause);
        }
    }

    public static XmlObject[] objectExecQuery(Cur cur, String str, XmlOptions xmlOptions) {
        return getCompiledQuery(str, xmlOptions).objectExecute(cur, xmlOptions);
    }

    public abstract XmlCursor cursorExecute(Cur cur, XmlOptions xmlOptions);

    public abstract XmlObject[] objectExecute(Cur cur, XmlOptions xmlOptions);

    /* JADX WARN: Removed duplicated region for block: B:45:0x008d A[Catch: all -> 0x0010, TRY_LEAVE, TryCatch #0 {all -> 0x0010, blocks: (B:4:0x0003, B:8:0x000a, B:9:0x000f, B:12:0x0013, B:14:0x001f, B:18:0x002b, B:20:0x0031, B:23:0x0038, B:24:0x003f, B:25:0x0040, B:28:0x0049, B:43:0x0085, B:45:0x008d, B:49:0x0099, B:51:0x009f, B:54:0x00a6, B:56:0x00ae, B:60:0x00ba, B:62:0x00c0, B:65:0x00c7, B:67:0x00cf, B:69:0x00da, B:73:0x00e2, B:74:0x00e9, B:68:0x00d8, B:31:0x0052, B:32:0x0058, B:34:0x0060, B:38:0x0074, B:37:0x0069, B:39:0x0075, B:42:0x007e, B:27:0x0046), top: B:77:0x0003, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ae A[Catch: all -> 0x0010, TRY_LEAVE, TryCatch #0 {all -> 0x0010, blocks: (B:4:0x0003, B:8:0x000a, B:9:0x000f, B:12:0x0013, B:14:0x001f, B:18:0x002b, B:20:0x0031, B:23:0x0038, B:24:0x003f, B:25:0x0040, B:28:0x0049, B:43:0x0085, B:45:0x008d, B:49:0x0099, B:51:0x009f, B:54:0x00a6, B:56:0x00ae, B:60:0x00ba, B:62:0x00c0, B:65:0x00c7, B:67:0x00cf, B:69:0x00da, B:73:0x00e2, B:74:0x00e9, B:68:0x00d8, B:31:0x0052, B:32:0x0058, B:34:0x0060, B:38:0x0074, B:37:0x0069, B:39:0x0075, B:42:0x007e, B:27:0x0046), top: B:77:0x0003, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00cf A[Catch: all -> 0x0010, TryCatch #0 {all -> 0x0010, blocks: (B:4:0x0003, B:8:0x000a, B:9:0x000f, B:12:0x0013, B:14:0x001f, B:18:0x002b, B:20:0x0031, B:23:0x0038, B:24:0x003f, B:25:0x0040, B:28:0x0049, B:43:0x0085, B:45:0x008d, B:49:0x0099, B:51:0x009f, B:54:0x00a6, B:56:0x00ae, B:60:0x00ba, B:62:0x00c0, B:65:0x00c7, B:67:0x00cf, B:69:0x00da, B:73:0x00e2, B:74:0x00e9, B:68:0x00d8, B:31:0x0052, B:32:0x0058, B:34:0x0060, B:38:0x0074, B:37:0x0069, B:39:0x0075, B:42:0x007e, B:27:0x0046), top: B:77:0x0003, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d8 A[Catch: all -> 0x0010, TryCatch #0 {all -> 0x0010, blocks: (B:4:0x0003, B:8:0x000a, B:9:0x000f, B:12:0x0013, B:14:0x001f, B:18:0x002b, B:20:0x0031, B:23:0x0038, B:24:0x003f, B:25:0x0040, B:28:0x0049, B:43:0x0085, B:45:0x008d, B:49:0x0099, B:51:0x009f, B:54:0x00a6, B:56:0x00ae, B:60:0x00ba, B:62:0x00c0, B:65:0x00c7, B:67:0x00cf, B:69:0x00da, B:73:0x00e2, B:74:0x00e9, B:68:0x00d8, B:31:0x0052, B:32:0x0058, B:34:0x0060, B:38:0x0074, B:37:0x0069, B:39:0x0075, B:42:0x007e, B:27:0x0046), top: B:77:0x0003, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00e0 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00e2 A[Catch: all -> 0x0010, TRY_ENTER, TryCatch #0 {all -> 0x0010, blocks: (B:4:0x0003, B:8:0x000a, B:9:0x000f, B:12:0x0013, B:14:0x001f, B:18:0x002b, B:20:0x0031, B:23:0x0038, B:24:0x003f, B:25:0x0040, B:28:0x0049, B:43:0x0085, B:45:0x008d, B:49:0x0099, B:51:0x009f, B:54:0x00a6, B:56:0x00ae, B:60:0x00ba, B:62:0x00c0, B:65:0x00c7, B:67:0x00cf, B:69:0x00da, B:73:0x00e2, B:74:0x00e9, B:68:0x00d8, B:31:0x0052, B:32:0x0058, B:34:0x0060, B:38:0x0074, B:37:0x0069, B:39:0x0075, B:42:0x007e, B:27:0x0046), top: B:77:0x0003, inners: #1, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized Query getCompiledQuery(String str, String str2, XmlOptions xmlOptions) {
        Object obj;
        Query queryCreateDelegateCompiledQuery;
        try {
            if (!$assertionsDisabled && str == null) {
                throw new AssertionError();
            }
            XmlOptions xmlOptionsMaskNull = XmlOptions.maskNull(xmlOptions);
            if (xmlOptionsMaskNull.hasOption(Path._forceXqrl2002ForXpathXQuery)) {
                Query query = (Query) _xqrl2002QueryCache.get(str);
                if (query != null) {
                    return query;
                }
                Query xqrl2002CompiledQuery = getXqrl2002CompiledQuery(str, str2);
                if (xqrl2002CompiledQuery == null) {
                    throw new RuntimeException("No 2002 query engine found.");
                }
                _xqrl2002QueryCache.put(str, xqrl2002CompiledQuery);
                return xqrl2002CompiledQuery;
            }
            HashMap map = new HashMap();
            int iIntValue = 0;
            try {
                try {
                    XPath.compileXPath(str, str2, map);
                } catch (XPath.XPathCompileException unused) {
                    if (map.get(XPath._NS_BOUNDARY) != null) {
                        obj = map.get(XPath._NS_BOUNDARY);
                        iIntValue = ((Integer) obj).intValue();
                    }
                }
                if (map.get(XPath._NS_BOUNDARY) == null) {
                    if (xmlOptionsMaskNull.hasOption(_useXdkForXQuery)) {
                        Query query2 = (Query) _xdkQueryCache.get(str);
                        if (query2 != null) {
                            return query2;
                        }
                        Query queryCreateXdkCompiledQuery = createXdkCompiledQuery(str, str2);
                        if (queryCreateXdkCompiledQuery != null) {
                            _xdkQueryCache.put(str, queryCreateXdkCompiledQuery);
                            return queryCreateXdkCompiledQuery;
                        }
                    }
                    if (!xmlOptionsMaskNull.hasOption(_useDelegateForXQuery)) {
                        Query query3 = (Query) _xqrlQueryCache.get(str);
                        if (query3 != null) {
                            return query3;
                        }
                        Query queryCreateXqrlCompiledQuery = createXqrlCompiledQuery(str, str2);
                        if (queryCreateXqrlCompiledQuery != null) {
                            _xqrlQueryCache.put(str, queryCreateXqrlCompiledQuery);
                            return queryCreateXqrlCompiledQuery;
                        }
                    }
                    queryCreateDelegateCompiledQuery = DelegateQueryImpl.createDelegateCompiledQuery(!xmlOptionsMaskNull.hasOption(QUERY_DELEGATE_INTERFACE) ? (String) xmlOptionsMaskNull.get(QUERY_DELEGATE_INTERFACE) : _delIntfName, str, str2, iIntValue);
                    if (queryCreateDelegateCompiledQuery == null) {
                        return queryCreateDelegateCompiledQuery;
                    }
                    throw new RuntimeException("No query engine found");
                }
                obj = map.get(XPath._NS_BOUNDARY);
                iIntValue = ((Integer) obj).intValue();
                if (xmlOptionsMaskNull.hasOption(_useXdkForXQuery)) {
                }
                if (!xmlOptionsMaskNull.hasOption(_useDelegateForXQuery)) {
                }
                queryCreateDelegateCompiledQuery = DelegateQueryImpl.createDelegateCompiledQuery(!xmlOptionsMaskNull.hasOption(QUERY_DELEGATE_INTERFACE) ? (String) xmlOptionsMaskNull.get(QUERY_DELEGATE_INTERFACE) : _delIntfName, str, str2, iIntValue);
                if (queryCreateDelegateCompiledQuery == null) {
                }
            } catch (Throwable th) {
                if (map.get(XPath._NS_BOUNDARY) != null) {
                    ((Integer) map.get(XPath._NS_BOUNDARY)).getClass();
                }
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
