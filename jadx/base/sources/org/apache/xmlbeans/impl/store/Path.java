package org.apache.xmlbeans.impl.store;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ConcurrentModificationException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.collections.AbstractC12991c;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlDate;
import org.apache.xmlbeans.XmlDecimal;
import org.apache.xmlbeans.XmlDouble;
import org.apache.xmlbeans.XmlFloat;
import org.apache.xmlbeans.XmlInteger;
import org.apache.xmlbeans.XmlLong;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.common.XPath;
import org.apache.xmlbeans.impl.store.DomImpl;
import org.apache.xmlbeans.impl.store.PathDelegate;
import org.w3c.dom.Node;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class Path {
    public static final String PATH_DELEGATE_INTERFACE = "PATH_DELEGATE_INTERFACE";
    private static final int USE_DELEGATE = 4;
    private static final int USE_XBEAN = 1;
    private static final int USE_XDK = 16;
    private static final int USE_XQRL = 2;
    private static final int USE_XQRL2002 = 8;
    private static String _delIntfName = null;
    public static String _forceXqrl2002ForXpathXQuery = "use xqrl-2002 for xpath";
    public static String _useDelegateForXpath = "use delegate for xpath";
    public static String _useXbeanForXpath = "use xbean for xpath";
    public static String _useXdkForXpath = "use xdk for xpath";
    public static String _useXqrlForXpath = "use xqrl for xpath";
    private static Method _xdkCompilePath;
    private static Method _xqrl2002CompilePath;
    private static Method _xqrlCompilePath;
    static /* synthetic */ Class class$java$lang$Boolean;
    static /* synthetic */ Class class$java$lang$String;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$store$Path;
    protected final String _pathKey;
    private static Map _xbeanPathCache = new WeakHashMap();
    private static Map _xdkPathCache = new WeakHashMap();
    private static Map _xqrlPathCache = new WeakHashMap();
    private static Map _xqrl2002PathCache = new WeakHashMap();
    private static boolean _xdkAvailable = true;
    private static boolean _xqrlAvailable = true;
    private static boolean _xqrl2002Available = true;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class DelegatePathImpl extends Path {
        static final /* synthetic */ boolean $assertionsDisabled;
        private PathDelegate.SelectPathInterface _xpathImpl;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class DelegatePathEngine extends XPath.ExecutionContext implements PathEngine {
            static final /* synthetic */ boolean $assertionsDisabled;
            private Cur _cur;
            private PathDelegate.SelectPathInterface _engine;
            private boolean _firstCall = true;
            private long _version;

            static {
                if (Path.class$org$apache$xmlbeans$impl$store$Path == null) {
                    Path.class$org$apache$xmlbeans$impl$store$Path = Path.class$("org.apache.xmlbeans.impl.store.Path");
                }
                $assertionsDisabled = true;
            }

            public DelegatePathEngine(PathDelegate.SelectPathInterface selectPathInterface, Cur cur) {
                this._engine = selectPathInterface;
                this._version = cur._locale.version();
                this._cur = cur.weakCur(this);
            }

            private SchemaType getType(Object obj) {
                return obj instanceof Integer ? XmlInteger.type : obj instanceof Double ? XmlDouble.type : obj instanceof Long ? XmlLong.type : obj instanceof Float ? XmlFloat.type : obj instanceof BigDecimal ? XmlDecimal.type : obj instanceof Boolean ? XmlBoolean.type : obj instanceof String ? XmlString.type : obj instanceof Date ? XmlDate.type : XmlAnySimpleType.type;
            }

            @Override // org.apache.xmlbeans.impl.store.Path.PathEngine
            public boolean next(Cur cur) {
                Cur curTempCur;
                if (!this._firstCall) {
                    return false;
                }
                this._firstCall = false;
                Cur cur2 = this._cur;
                if (cur2 != null && this._version != cur2._locale.version()) {
                    throw new ConcurrentModificationException("Document changed during select");
                }
                List listSelectPath = this._engine.selectPath(this._cur.getDom());
                for (int i = 0; i < listSelectPath.size(); i++) {
                    Object obj = listSelectPath.get(i);
                    if (!(obj instanceof Node)) {
                        String string = listSelectPath.get(i).toString();
                        try {
                            curTempCur = cur._locale.load("<xml-fragment/>").tempCur();
                            curTempCur.setValue(string);
                            Locale.autoTypeDocument(curTempCur, getType(obj), null);
                            curTempCur.next();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        if (!$assertionsDisabled && !(obj instanceof DomImpl.Dom)) {
                            throw new AssertionError("New object created in XPATH!");
                        }
                        curTempCur = ((DomImpl.Dom) obj).tempCur();
                    }
                    cur.addToSelection(curTempCur);
                    curTempCur.release();
                }
                release();
                this._engine = null;
                return true;
            }

            @Override // org.apache.xmlbeans.impl.store.Path.PathEngine
            public void release() {
                Cur cur = this._cur;
                if (cur != null) {
                    cur.release();
                    this._cur = null;
                }
            }
        }

        static {
            if (Path.class$org$apache$xmlbeans$impl$store$Path == null) {
                Path.class$org$apache$xmlbeans$impl$store$Path = Path.class$("org.apache.xmlbeans.impl.store.Path");
            }
            $assertionsDisabled = true;
        }

        private DelegatePathImpl(PathDelegate.SelectPathInterface selectPathInterface, String str) {
            super(str);
            this._xpathImpl = selectPathInterface;
        }

        public static Path create(String str, String str2, String str3, Map map) {
            if (!$assertionsDisabled && str3.startsWith("$")) {
                throw new AssertionError();
            }
            PathDelegate.SelectPathInterface selectPathInterfaceCreateInstance = PathDelegate.createInstance(str, str2, str3, map);
            if (selectPathInterfaceCreateInstance == null) {
                return null;
            }
            return new DelegatePathImpl(selectPathInterfaceCreateInstance, str2);
        }

        @Override // org.apache.xmlbeans.impl.store.Path
        public PathEngine execute(Cur cur, XmlOptions xmlOptions) {
            return new DelegatePathEngine(this._xpathImpl, cur);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface PathEngine {
        boolean next(Cur cur);

        void release();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class XbeanPath extends Path {
        private final XPath _compiledPath;
        private final String _currentVar;
        public Map namespaces;

        private XbeanPath(String str, String str2, XPath xPath) {
            super(str);
            this._currentVar = str2;
            this._compiledPath = xPath;
        }

        public static Path create(String str, String str2, Map map) {
            try {
                return new XbeanPath(str, str2, XPath.compileXPath(str, str2, map));
            } catch (XPath.XPathCompileException unused) {
                return null;
            }
        }

        @Override // org.apache.xmlbeans.impl.store.Path
        public PathEngine execute(Cur cur, XmlOptions xmlOptions) {
            XmlOptions xmlOptionsMaskNull = XmlOptions.maskNull(xmlOptions);
            return (!cur.isContainer() || this._compiledPath.sawDeepDot()) ? Path.getCompiledPath(this._pathKey, 22, this._currentVar, xmlOptionsMaskNull.hasOption(Path.PATH_DELEGATE_INTERFACE) ? (String) xmlOptionsMaskNull.get(Path.PATH_DELEGATE_INTERFACE) : Path._delIntfName).execute(cur, xmlOptionsMaskNull) : new XbeanPathEngine(this._compiledPath, cur);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class XbeanPathEngine extends XPath.ExecutionContext implements PathEngine {
        static final /* synthetic */ boolean $assertionsDisabled;
        private Cur _cur;
        private final long _version;

        static {
            if (Path.class$org$apache$xmlbeans$impl$store$Path == null) {
                Path.class$org$apache$xmlbeans$impl$store$Path = Path.class$("org.apache.xmlbeans.impl.store.Path");
            }
            $assertionsDisabled = true;
        }

        public XbeanPathEngine(XPath xPath, Cur cur) {
            if (!$assertionsDisabled && !cur.isContainer()) {
                throw new AssertionError();
            }
            this._version = cur._locale.version();
            Cur curWeakCur = cur.weakCur(this);
            this._cur = curWeakCur;
            curWeakCur.push();
            init(xPath);
            int iStart = start();
            if ((iStart & 1) != 0) {
                cur.addToSelection();
            }
            doAttrs(iStart, cur);
            if ((iStart & 2) == 0 || !Locale.toFirstChildElement(this._cur)) {
                release();
            }
        }

        private void advance(Cur cur) {
            if (!$assertionsDisabled && this._cur == null) {
                throw new AssertionError();
            }
            if (this._cur.isFinish()) {
                if (this._cur.isAtEndOfLastPush()) {
                    release();
                    return;
                } else {
                    end();
                    this._cur.next();
                    return;
                }
            }
            if (!this._cur.isElem()) {
                do {
                    this._cur.next();
                } while (!this._cur.isContainerOrFinish());
                return;
            }
            int iElement = element(this._cur.getName());
            if ((iElement & 1) != 0) {
                cur.addToSelection(this._cur);
            }
            doAttrs(iElement, cur);
            if ((iElement & 2) == 0 || !Locale.toFirstChildElement(this._cur)) {
                end();
                this._cur.skip();
            }
        }

        private void doAttrs(int i, Cur cur) {
            if (!$assertionsDisabled && !this._cur.isContainer()) {
                throw new AssertionError();
            }
            if ((i & 4) == 0 || !this._cur.toFirstAttr()) {
                return;
            }
            do {
                if (attr(this._cur.getName())) {
                    cur.addToSelection(this._cur);
                }
            } while (this._cur.toNextAttr());
            this._cur.toParent();
        }

        @Override // org.apache.xmlbeans.impl.store.Path.PathEngine
        public boolean next(Cur cur) {
            Cur cur2 = this._cur;
            if (cur2 != null && this._version != cur2._locale.version()) {
                throw new ConcurrentModificationException("Document changed during select");
            }
            int iSelectionCount = cur.selectionCount();
            while (this._cur != null) {
                advance(cur);
                if (iSelectionCount != cur.selectionCount()) {
                    return true;
                }
            }
            return false;
        }

        @Override // org.apache.xmlbeans.impl.store.Path.PathEngine
        public void release() {
            Cur cur = this._cur;
            if (cur != null) {
                cur.release();
                this._cur = null;
            }
        }
    }

    static {
        Class clsClass$ = class$org$apache$xmlbeans$impl$store$Path;
        if (clsClass$ == null) {
            clsClass$ = class$("org.apache.xmlbeans.impl.store.Path");
            class$org$apache$xmlbeans$impl$store$Path = clsClass$;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clsClass$.getClassLoader().getResourceAsStream("META-INF/services/org.apache.xmlbeans.impl.store.PathDelegate.SelectPathInterface")));
            _delIntfName = bufferedReader.readLine().trim();
            bufferedReader.close();
        } catch (Exception unused) {
            _delIntfName = null;
        }
    }

    public Path(String str) {
        this._pathKey = str;
    }

    public static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw AbstractC12991c.m13994o(e);
        }
    }

    public static synchronized String compilePath(String str, XmlOptions xmlOptions) {
        return getCompiledPath(str, xmlOptions)._pathKey;
    }

    private static Path createXdkCompiledPath(String str, String str2) throws Throwable {
        if (!_xdkAvailable) {
            return null;
        }
        if (_xdkCompilePath == null) {
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
                _xdkCompilePath = cls.getDeclaredMethod("compilePath", clsClass$, clsClass$2, clsClass$3);
            } catch (ClassNotFoundException unused) {
                _xdkAvailable = false;
                return null;
            } catch (Exception e) {
                _xdkAvailable = false;
                throw new RuntimeException(e.getMessage(), e);
            }
        }
        try {
            return (Path) _xdkCompilePath.invoke(null, str, str2, new Boolean(true));
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2.getMessage(), e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            throw new RuntimeException(cause.getMessage(), cause);
        }
    }

    private static Path createXqrl2002CompiledPath(String str, String str2) throws Throwable {
        if (!_xqrl2002Available) {
            return null;
        }
        if (_xqrl2002CompilePath == null) {
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
                _xqrl2002CompilePath = cls.getDeclaredMethod("compilePath", clsClass$, clsClass$2, clsClass$3);
            } catch (ClassNotFoundException unused) {
                _xqrl2002Available = false;
                return null;
            } catch (Exception e) {
                _xqrl2002Available = false;
                throw new RuntimeException(e.getMessage(), e);
            }
        }
        try {
            return (Path) _xqrl2002CompilePath.invoke(null, str, str2, new Boolean(true));
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2.getMessage(), e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            throw new RuntimeException(cause.getMessage(), cause);
        }
    }

    private static Path createXqrlCompiledPath(String str, String str2) throws Throwable {
        if (!_xqrlAvailable) {
            return null;
        }
        if (_xqrlCompilePath == null) {
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
                _xqrlCompilePath = cls.getDeclaredMethod("compilePath", clsClass$, clsClass$2, clsClass$3);
            } catch (ClassNotFoundException unused) {
                _xqrlAvailable = false;
                return null;
            } catch (Exception e) {
                _xqrlAvailable = false;
                throw new RuntimeException(e.getMessage(), e);
            }
        }
        try {
            return (Path) _xqrlCompilePath.invoke(null, str, str2, new Boolean(true));
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2.getMessage(), e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            throw new RuntimeException(cause.getMessage(), cause);
        }
    }

    public static Path getCompiledPath(String str, XmlOptions xmlOptions) {
        XmlOptions xmlOptionsMaskNull = XmlOptions.maskNull(xmlOptions);
        return getCompiledPath(str, xmlOptionsMaskNull.hasOption(_useDelegateForXpath) ? 4 : xmlOptionsMaskNull.hasOption(_useXqrlForXpath) ? 2 : xmlOptionsMaskNull.hasOption(_useXdkForXpath) ? 16 : xmlOptionsMaskNull.hasOption(_useXbeanForXpath) ? 1 : xmlOptionsMaskNull.hasOption(_forceXqrl2002ForXpathXQuery) ? 8 : 23, getCurrentNodeVar(xmlOptionsMaskNull), xmlOptionsMaskNull.hasOption(PATH_DELEGATE_INTERFACE) ? (String) xmlOptionsMaskNull.get(PATH_DELEGATE_INTERFACE) : _delIntfName);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0018  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x001a A[Catch: all -> 0x000b, TryCatch #0 {, blocks: (B:5:0x0005, B:9:0x000d, B:10:0x0010, B:14:0x0026, B:13:0x001a), top: B:20:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static synchronized Path getCompiledPathDelegate(String str, String str2, Map map, String str3) {
        int iIntValue;
        if (map == null) {
            map = new HashMap();
            try {
                XPath.compileXPath(str, str2, map);
            } catch (XPath.XPathCompileException unused) {
            }
            iIntValue = map.get(XPath._NS_BOUNDARY) != null ? 0 : ((Integer) map.get(XPath._NS_BOUNDARY)).intValue();
            map.remove(XPath._NS_BOUNDARY);
        } else {
            XPath.compileXPath(str, str2, map);
            if (map.get(XPath._NS_BOUNDARY) != null) {
            }
            map.remove(XPath._NS_BOUNDARY);
        }
        return DelegatePathImpl.create(str3, str.substring(iIntValue), str2, map);
    }

    private static synchronized Path getCompiledPathXbean(String str, String str2, Map map) {
        Path pathCreate;
        pathCreate = XbeanPath.create(str, str2, map);
        if (pathCreate != null) {
            _xbeanPathCache.put(pathCreate._pathKey, new WeakReference(pathCreate));
        }
        return pathCreate;
    }

    private static synchronized Path getCompiledPathXdk(String str, String str2) {
        Path pathCreateXdkCompiledPath;
        pathCreateXdkCompiledPath = createXdkCompiledPath(str, str2);
        if (pathCreateXdkCompiledPath != null) {
            _xdkPathCache.put(pathCreateXdkCompiledPath._pathKey, new WeakReference(pathCreateXdkCompiledPath));
        }
        return pathCreateXdkCompiledPath;
    }

    private static synchronized Path getCompiledPathXqrl(String str, String str2) {
        Path pathCreateXqrlCompiledPath;
        pathCreateXqrlCompiledPath = createXqrlCompiledPath(str, str2);
        if (pathCreateXqrlCompiledPath != null) {
            _xqrlPathCache.put(pathCreateXqrlCompiledPath._pathKey, new WeakReference(pathCreateXqrlCompiledPath));
        }
        return pathCreateXqrlCompiledPath;
    }

    private static synchronized Path getCompiledPathXqrl2002(String str, String str2) {
        Path pathCreateXqrl2002CompiledPath;
        pathCreateXqrl2002CompiledPath = createXqrl2002CompiledPath(str, str2);
        if (pathCreateXqrl2002CompiledPath != null) {
            _xqrl2002PathCache.put(pathCreateXqrl2002CompiledPath._pathKey, new WeakReference(pathCreateXqrl2002CompiledPath));
        }
        return pathCreateXqrl2002CompiledPath;
    }

    public static String getCurrentNodeVar(XmlOptions xmlOptions) {
        XmlOptions xmlOptionsMaskNull = XmlOptions.maskNull(xmlOptions);
        if (!xmlOptionsMaskNull.hasOption(XmlOptions.XQUERY_CURRENT_NODE_VAR)) {
            return "this";
        }
        String str = (String) xmlOptionsMaskNull.get(XmlOptions.XQUERY_CURRENT_NODE_VAR);
        if (str.startsWith("$")) {
            throw new IllegalArgumentException("Omit the '$' prefix for the current node variable");
        }
        return str;
    }

    public abstract PathEngine execute(Cur cur, XmlOptions xmlOptions);

    public static synchronized Path getCompiledPath(String str, int i, String str2, String str3) {
        HashMap map;
        int i2 = i & 4;
        if (i2 != 0) {
            try {
                map = new HashMap();
            } catch (Throwable th) {
                throw th;
            }
        } else {
            map = null;
        }
        int i4 = i & 1;
        WeakReference weakReference = i4 != 0 ? (WeakReference) _xbeanPathCache.get(str) : null;
        if (weakReference == null && (i & 2) != 0) {
            weakReference = (WeakReference) _xqrlPathCache.get(str);
        }
        if (weakReference == null && (i & 16) != 0) {
            weakReference = (WeakReference) _xdkPathCache.get(str);
        }
        if (weakReference == null && (i & 8) != 0) {
            weakReference = (WeakReference) _xqrl2002PathCache.get(str);
        }
        Path compiledPathXqrl2002 = weakReference != null ? (Path) weakReference.get() : null;
        if (compiledPathXqrl2002 != null) {
            return compiledPathXqrl2002;
        }
        if (i4 != 0) {
            compiledPathXqrl2002 = getCompiledPathXbean(str, str2, map);
        }
        if (compiledPathXqrl2002 == null && (i & 2) != 0) {
            compiledPathXqrl2002 = getCompiledPathXqrl(str, str2);
        }
        if (compiledPathXqrl2002 == null && (i & 16) != 0) {
            compiledPathXqrl2002 = getCompiledPathXdk(str, str2);
        }
        if (compiledPathXqrl2002 == null && i2 != 0) {
            compiledPathXqrl2002 = getCompiledPathDelegate(str, str2, map, str3);
        }
        if (compiledPathXqrl2002 == null && (i & 8) != 0) {
            compiledPathXqrl2002 = getCompiledPathXqrl2002(str, str2);
        }
        if (compiledPathXqrl2002 != null) {
            return compiledPathXqrl2002;
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (i4 != 0) {
            stringBuffer.append(" Trying XBeans path engine...");
        }
        if ((i & 2) != 0) {
            stringBuffer.append(" Trying XQRL...");
        }
        if ((i & 16) != 0) {
            stringBuffer.append(" Trying XDK...");
        }
        if (i2 != 0) {
            stringBuffer.append(" Trying delegated path engine...");
        }
        if ((i & 8) != 0) {
            stringBuffer.append(" Trying XQRL2002...");
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append(stringBuffer.toString());
        stringBuffer2.append(" FAILED on ");
        stringBuffer2.append(str);
        throw new RuntimeException(stringBuffer2.toString());
    }
}
