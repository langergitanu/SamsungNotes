package org.apache.xmlbeans.impl.store;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import kotlin.collections.AbstractC12991c;
import org.apache.poi.javax.xml.XMLConstants;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.CDataBookmark;
import org.apache.xmlbeans.QNameCache;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlDocumentProperties;
import org.apache.xmlbeans.XmlError;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlLineNumber;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlRuntimeException;
import org.apache.xmlbeans.XmlSaxHandler;
import org.apache.xmlbeans.XmlTokenSource;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ResolverUtil;
import org.apache.xmlbeans.impl.common.SystemCache;
import org.apache.xmlbeans.impl.common.XMLNameHelper;
import org.apache.xmlbeans.impl.common.XmlLocale;
import org.apache.xmlbeans.impl.piccolo.io.FileFormatException;
import org.apache.xmlbeans.impl.piccolo.xml.Piccolo;
import org.apache.xmlbeans.impl.store.Cur;
import org.apache.xmlbeans.impl.store.DomImpl;
import org.apache.xmlbeans.impl.store.Saaj;
import org.apache.xmlbeans.xml.stream.Attribute;
import org.apache.xmlbeans.xml.stream.AttributeIterator;
import org.apache.xmlbeans.xml.stream.CharacterData;
import org.apache.xmlbeans.xml.stream.Comment;
import org.apache.xmlbeans.xml.stream.Location;
import org.apache.xmlbeans.xml.stream.ProcessingInstruction;
import org.apache.xmlbeans.xml.stream.Space;
import org.apache.xmlbeans.xml.stream.StartDocument;
import org.apache.xmlbeans.xml.stream.StartElement;
import org.apache.xmlbeans.xml.stream.XMLEvent;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLName;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.ccil.cowan.tagsoup.Parser;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.DTDHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.ext.DeclHandler;
import org.xml.sax.ext.LexicalHandler;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class Locale implements DOMImplementation, Saaj.SaajCallback, XmlLocale {
    static final /* synthetic */ boolean $assertionsDisabled;
    static final int ATTR = 3;
    static final int COMMENT = 4;
    public static final String COPY_USE_NEW_LOCALE = "COPY_USE_NEW_LOCALE";
    static final int ELEM = 2;
    static final int PROCINST = 5;
    static final int ROOT = 1;
    static final int TEXT = 0;
    public static final String USE_SAME_LOCALE = "USE_SAME_LOCALE";
    static final int WS_COLLAPSE = 3;
    static final int WS_PRESERVE = 1;
    static final int WS_REPLACE = 2;
    static final int WS_UNSPECIFIED = 0;
    static final String _openFragUri = "http://www.openuri.org/fragment";
    static final QName _openuriFragment;
    static final String _schema = "http://www.w3.org/2001/XMLSchema";
    static final String _xml1998Uri = "http://www.w3.org/XML/1998/namespace";
    static final QName _xmlFragment;
    static final String _xmlnsUri = "http://www.w3.org/2000/xmlns/";
    static final String _xsi = "http://www.w3.org/2001/XMLSchema-instance";
    static final QName _xsiLoc;
    static final QName _xsiNil;
    static final QName _xsiNoLoc;
    static final QName _xsiType;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$store$Locale;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$store$Locale$DocProps;
    private static ThreadLocal tl_scrubBuffer;
    int _cchSrc;
    ChangeListener _changeListeners;
    private CharUtil _charUtil;
    Cur _curPool;
    int _curPoolCount;
    private int _entryCount;
    Cur.Locations _locations;
    boolean _noSync;
    int _numTempFramesLeft;
    int _offSrc;
    DomImpl.Dom _ownerDoc;
    int _posTemp;
    QNameFactory _qnameFactory;
    private ReferenceQueue _refQueue;
    Cur _registered;
    Saaj _saaj;
    SchemaTypeLoader _schemaTypeLoader;
    Cur[] _tempFrames;
    boolean _validateOnSet;
    long _versionAll;
    long _versionSansText;
    nthCache _nthCache_A = new nthCache();
    nthCache _nthCache_B = new nthCache();
    domNthCache _domNthCache_A = new domNthCache();
    domNthCache _domNthCache_B = new domNthCache();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ChangeListener {
        ChangeListener getNextChangeListener();

        void notifyChange();

        void setNextChangeListener(ChangeListener changeListener);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class DefaultEntityResolver implements EntityResolver {
        private DefaultEntityResolver() {
        }

        @Override // org.xml.sax.EntityResolver
        public InputSource resolveEntity(String str, String str2) {
            return new InputSource(new StringReader(""));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class DefaultQNameFactory implements QNameFactory {
        private QNameCache _cache;

        private DefaultQNameFactory() {
            this._cache = XmlBeans.getQNameCache();
        }

        @Override // org.apache.xmlbeans.impl.store.QNameFactory
        public QName getQName(String str, String str2) {
            return this._cache.getName(str, str2, "");
        }

        @Override // org.apache.xmlbeans.impl.store.QNameFactory
        public QName getQName(String str, String str2, String str3) {
            return this._cache.getName(str, str2, str3);
        }

        @Override // org.apache.xmlbeans.impl.store.QNameFactory
        public QName getQName(char[] cArr, int i, int i2, char[] cArr2, int i4, int i5) {
            return this._cache.getName(new String(cArr, i, i2), new String(cArr2, i4, i5), "");
        }

        @Override // org.apache.xmlbeans.impl.store.QNameFactory
        public QName getQName(char[] cArr, int i, int i2, char[] cArr2, int i4, int i5, char[] cArr3, int i6, int i7) {
            return this._cache.getName(new String(cArr, i, i2), new String(cArr2, i4, i5), new String(cArr3, i6, i7));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class DocProps extends XmlDocumentProperties {
        private HashMap _map;

        private DocProps() {
            this._map = new HashMap();
        }

        @Override // org.apache.xmlbeans.XmlDocumentProperties
        public Object get(Object obj) {
            return this._map.get(obj);
        }

        @Override // org.apache.xmlbeans.XmlDocumentProperties
        public Object put(Object obj, Object obj2) {
            return this._map.put(obj, obj2);
        }

        @Override // org.apache.xmlbeans.XmlDocumentProperties
        public Object remove(Object obj) {
            return this._map.remove(obj);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class LoadContext {
        private Hashtable _idAttrs;

        public abstract void abort();

        public void addIdAttr(String str, String str2) {
            if (this._idAttrs == null) {
                this._idAttrs = new Hashtable();
            }
            this._idAttrs.put(str2, str);
        }

        public abstract void attr(String str, String str2, String str3, String str4);

        public abstract void attr(QName qName, String str);

        public abstract void bookmark(XmlCursor.XmlBookmark xmlBookmark);

        public abstract void bookmarkLastAttr(QName qName, XmlCursor.XmlBookmark xmlBookmark);

        public abstract void bookmarkLastNonAttr(XmlCursor.XmlBookmark xmlBookmark);

        public abstract void comment(String str);

        public abstract void comment(char[] cArr, int i, int i2);

        public abstract void endDTD();

        public abstract void endElement();

        public abstract Cur finish();

        public boolean isAttrOfTypeId(QName qName, QName qName2) {
            if (this._idAttrs == null) {
                return false;
            }
            String prefix = qName.getPrefix();
            String localPart = qName.getLocalPart();
            if (!"".equals(prefix)) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(prefix);
                stringBuffer.append(":");
                stringBuffer.append(localPart);
                localPart = stringBuffer.toString();
            }
            String str = (String) this._idAttrs.get(localPart);
            if (str == null) {
                return false;
            }
            String prefix2 = qName2.getPrefix();
            qName2.getLocalPart();
            String localPart2 = qName2.getLocalPart();
            if (!"".equals(prefix2)) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append(prefix2);
                stringBuffer2.append(":");
                stringBuffer2.append(localPart2);
                localPart2 = stringBuffer2.toString();
            }
            return str.equals(localPart2);
        }

        public abstract void lineNumber(int i, int i2, int i4);

        public abstract void procInst(String str, String str2);

        public abstract void startDTD(String str, String str2, String str3);

        public abstract void startElement(QName qName);

        public abstract void text(String str);

        public abstract void text(char[] cArr, int i, int i2);

        public abstract void xmlns(String str, String str2);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class LocalDocumentQNameFactory implements QNameFactory {
        private QNameCache _cache = new QNameCache(32);

        private LocalDocumentQNameFactory() {
        }

        @Override // org.apache.xmlbeans.impl.store.QNameFactory
        public QName getQName(String str, String str2) {
            return this._cache.getName(str, str2, "");
        }

        @Override // org.apache.xmlbeans.impl.store.QNameFactory
        public QName getQName(String str, String str2, String str3) {
            return this._cache.getName(str, str2, str3);
        }

        @Override // org.apache.xmlbeans.impl.store.QNameFactory
        public QName getQName(char[] cArr, int i, int i2, char[] cArr2, int i4, int i5) {
            return this._cache.getName(new String(cArr, i, i2), new String(cArr2, i4, i5), "");
        }

        @Override // org.apache.xmlbeans.impl.store.QNameFactory
        public QName getQName(char[] cArr, int i, int i2, char[] cArr2, int i4, int i5, char[] cArr3, int i6, int i7) {
            return this._cache.getName(new String(cArr, i, i2), new String(cArr2, i4, i5), new String(cArr3, i6, i7));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class PiccoloSaxLoader extends SaxLoader {
        private Piccolo _piccolo;

        private PiccoloSaxLoader(Piccolo piccolo) {
            super(piccolo, piccolo.getStartLocator());
            this._piccolo = piccolo;
        }

        public static PiccoloSaxLoader newInstance() {
            return new PiccoloSaxLoader(new Piccolo());
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.SaxLoader
        public void postLoad(Cur cur) throws Throwable {
            XmlDocumentProperties docProps = Locale.getDocProps(cur, true);
            docProps.setEncoding(this._piccolo.getEncoding());
            docProps.setVersion(this._piccolo.getVersion());
            super.postLoad(cur);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Ref extends PhantomReference {
        Cur _cur;

        public Ref(Cur cur, Object obj) {
            super(obj, cur._locale.refQueue());
            this._cur = cur;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ScrubBuffer {
        private static final int NOSPACE_STATE = 2;
        private static final int SPACE_SEEN_STATE = 1;
        private static final int START_STATE = 0;
        private int _state;
        private int _wsr;
        private char[] _srcBuf = new char[1024];
        private StringBuffer _sb = new StringBuffer();

        public String getResultAsString() {
            return this._sb.toString();
        }

        public void init(int i) {
            StringBuffer stringBuffer = this._sb;
            stringBuffer.delete(0, stringBuffer.length());
            this._wsr = i;
            this._state = 0;
        }

        public void scrub(Object obj, int i, int i2) {
            char[] cArr;
            if (i2 == 0) {
                return;
            }
            if (this._wsr == 1) {
                CharUtil.getString(this._sb, obj, i, i2);
                return;
            }
            if (obj instanceof char[]) {
                cArr = (char[]) obj;
            } else {
                char[] cArr2 = this._srcBuf;
                if (i2 > cArr2.length) {
                    if (i2 <= 16384) {
                        cArr2 = new char[16384];
                        this._srcBuf = cArr2;
                    } else {
                        cArr2 = new char[i2];
                    }
                }
                CharUtil.getChars(cArr2, 0, obj, i, i2);
                cArr = cArr2;
                i = 0;
            }
            int i4 = 0;
            for (int i5 = 0; i5 < i2; i5++) {
                char c = cArr[i + i5];
                if (c == ' ' || c == '\n' || c == '\r' || c == '\t') {
                    this._sb.append(cArr, i + i4, i5 - i4);
                    i4 = i5 + 1;
                    if (this._wsr == 2) {
                        this._sb.append(' ');
                    } else if (this._state == 2) {
                        this._state = 1;
                    }
                } else {
                    if (this._state == 1) {
                        this._sb.append(' ');
                    }
                    this._state = 2;
                }
            }
            this._sb.append(cArr, i + i4, i2 - i4);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class XmlReaderSaxLoader extends SaxLoader {
        public XmlReaderSaxLoader(XMLReader xMLReader) {
            super(xMLReader, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class XmlSaxHandlerImpl extends SaxHandler implements XmlSaxHandler {
        private XmlOptions _options;
        private SchemaType _type;

        public XmlSaxHandlerImpl(Locale locale, SchemaType schemaType, XmlOptions xmlOptions) {
            super(null);
            this._options = xmlOptions;
            this._type = schemaType;
            XmlOptions xmlOptions2 = new XmlOptions(xmlOptions);
            xmlOptions2.put("LOAD_USE_LOCALE_CHAR_UTIL");
            initSaxHandler(locale, xmlOptions2);
        }

        @Override // org.apache.xmlbeans.XmlSaxHandler
        public void bookmarkLastAttr(QName qName, XmlCursor.XmlBookmark xmlBookmark) {
            this._context.bookmarkLastAttr(qName, xmlBookmark);
        }

        @Override // org.apache.xmlbeans.XmlSaxHandler
        public void bookmarkLastEvent(XmlCursor.XmlBookmark xmlBookmark) {
            this._context.bookmarkLastNonAttr(xmlBookmark);
        }

        @Override // org.apache.xmlbeans.XmlSaxHandler
        public ContentHandler getContentHandler() {
            if (this._context == null) {
                return null;
            }
            return this;
        }

        @Override // org.apache.xmlbeans.XmlSaxHandler
        public LexicalHandler getLexicalHandler() {
            if (this._context == null) {
                return null;
            }
            return this;
        }

        @Override // org.apache.xmlbeans.XmlSaxHandler
        public XmlObject getObject() {
            if (this._context == null) {
                return null;
            }
            this._locale.enter();
            try {
                Cur curFinish = this._context.finish();
                Locale.autoTypeDocument(curFinish, this._type, this._options);
                XmlObject xmlObject = (XmlObject) curFinish.getUser();
                curFinish.release();
                this._context = null;
                return xmlObject;
            } finally {
                this._locale.exit();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class domNthCache {
        static final /* synthetic */ boolean $assertionsDisabled;
        public static final int BLITZ_BOUNDARY = 40;
        private DomImpl.Dom _child;
        private int _len;

        /* JADX INFO: renamed from: _n */
        private int f10176_n;
        private DomImpl.Dom _parent;
        private long _version;

        static {
            if (Locale.class$org$apache$xmlbeans$impl$store$Locale == null) {
                Locale.class$org$apache$xmlbeans$impl$store$Locale = Locale.class$("org.apache.xmlbeans.impl.store.Locale");
            }
            $assertionsDisabled = true;
        }

        public domNthCache() {
        }

        public int distance(DomImpl.Dom dom, int i) {
            if (!$assertionsDisabled && i < 0) {
                throw new AssertionError();
            }
            if (this._version != Locale.this.version()) {
                return 2147483646;
            }
            if (dom != this._parent) {
                return Integer.MAX_VALUE;
            }
            int i2 = this.f10176_n;
            return i > i2 ? i - i2 : i2 - i;
        }

        public DomImpl.Dom fetch(DomImpl.Dom dom, int i) {
            if (!$assertionsDisabled && i < 0) {
                throw new AssertionError();
            }
            if (this._version != Locale.this.version() || this._parent != dom) {
                this._parent = dom;
                this._version = Locale.this.version();
                this._child = null;
                this.f10176_n = -1;
                this._len = -1;
                DomImpl.Dom domFirstChild = DomImpl.firstChild(this._parent);
                while (true) {
                    if (domFirstChild == null) {
                        break;
                    }
                    int i2 = this.f10176_n + 1;
                    this.f10176_n = i2;
                    if (this._child == null && i == i2) {
                        this._child = domFirstChild;
                        break;
                    }
                    domFirstChild = DomImpl.nextSibling(domFirstChild);
                }
                return this._child;
            }
            int i4 = this.f10176_n;
            if (i4 < 0) {
                return null;
            }
            if (i > i4) {
                while (i > this.f10176_n) {
                    DomImpl.Dom domNextSibling = DomImpl.nextSibling(this._child);
                    if (domNextSibling == null) {
                        return null;
                    }
                    this._child = domNextSibling;
                    this.f10176_n++;
                }
            } else if (i < i4) {
                while (i < this.f10176_n) {
                    DomImpl.Dom domPrevSibling = DomImpl.prevSibling(this._child);
                    if (domPrevSibling == null) {
                        return null;
                    }
                    this._child = domPrevSibling;
                    this.f10176_n--;
                }
            }
            return this._child;
        }

        public int length(DomImpl.Dom dom) {
            int i;
            if (this._version != Locale.this.version() || this._parent != dom) {
                this._parent = dom;
                this._version = Locale.this.version();
                this._child = null;
                this.f10176_n = -1;
                this._len = -1;
            }
            if (this._len == -1) {
                DomImpl.Dom domFirstChild = this._child;
                if (domFirstChild == null || (i = this.f10176_n) == -1) {
                    domFirstChild = DomImpl.firstChild(this._parent);
                    this._len = 0;
                    this._child = domFirstChild;
                    this.f10176_n = 0;
                } else {
                    this._len = i;
                }
                while (domFirstChild != null) {
                    this._len++;
                    domFirstChild = DomImpl.nextSibling(domFirstChild);
                }
            }
            return this._len;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class nthCache {
        static final /* synthetic */ boolean $assertionsDisabled;
        private Xobj _child;

        /* JADX INFO: renamed from: _n */
        private int f10177_n;
        private QName _name;
        private Xobj _parent;
        private QNameSet _set;
        private long _version;

        static {
            if (Locale.class$org$apache$xmlbeans$impl$store$Locale == null) {
                Locale.class$org$apache$xmlbeans$impl$store$Locale = Locale.class$("org.apache.xmlbeans.impl.store.Locale");
            }
            $assertionsDisabled = true;
        }

        public nthCache() {
        }

        private boolean cacheSame(QName qName, QNameSet qNameSet) {
            return qNameSet == null ? namesSame(qName, this._name) : setsSame(qNameSet, this._set);
        }

        private boolean nameHit(QName qName, QNameSet qNameSet, QName qName2) {
            return qNameSet == null ? namesSame(qName, qName2) : qNameSet.contains(qName2);
        }

        private boolean namesSame(QName qName, QName qName2) {
            return qName == null || qName.equals(qName2);
        }

        private boolean setsSame(QNameSet qNameSet, QNameSet qNameSet2) {
            return qNameSet != null && qNameSet == qNameSet2;
        }

        public int distance(Xobj xobj, QName qName, QNameSet qNameSet, int i) {
            if (!$assertionsDisabled && i < 0) {
                throw new AssertionError();
            }
            if (this._version != Locale.this.version()) {
                return 2147483646;
            }
            if (xobj != this._parent || !cacheSame(qName, qNameSet)) {
                return Integer.MAX_VALUE;
            }
            int i2 = this.f10177_n;
            return i > i2 ? i - i2 : i2 - i;
        }

        /* JADX WARN: Code restructure failed: missing block: B:37:0x0072, code lost:
        
            r4._child = r5;
            r4.f10177_n++;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x0096, code lost:
        
            r4._child = r5;
            r4.f10177_n--;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Xobj fetch(Xobj xobj, QName qName, QNameSet qNameSet, int i) {
            if (!$assertionsDisabled && i < 0) {
                throw new AssertionError();
            }
            if (this._version != Locale.this.version() || this._parent != xobj || !cacheSame(qName, qNameSet) || i == 0) {
                this._version = Locale.this.version();
                this._parent = xobj;
                this._name = qName;
                this._child = null;
                this.f10177_n = -1;
                Xobj xobj2 = xobj._firstChild;
                while (true) {
                    if (xobj2 != null) {
                        if (xobj2.isElem() && nameHit(qName, qNameSet, xobj2._name)) {
                            this._child = xobj2;
                            this.f10177_n = 0;
                            break;
                        }
                        xobj2 = xobj2._nextSibling;
                    } else {
                        break;
                    }
                }
            }
            int i2 = this.f10177_n;
            if (i2 < 0) {
                return null;
            }
            if (i > i2) {
                while (i > this.f10177_n) {
                    Xobj xobj3 = this._child;
                    while (true) {
                        xobj3 = xobj3._nextSibling;
                        if (xobj3 == null) {
                            return null;
                        }
                        if (!xobj3.isElem() || !nameHit(qName, qNameSet, xobj3._name)) {
                        }
                    }
                }
            } else if (i < i2) {
                while (i < this.f10177_n) {
                    Xobj xobj4 = this._child;
                    while (true) {
                        xobj4 = xobj4._prevSibling;
                        if (xobj4 == null) {
                            return null;
                        }
                        if (!xobj4.isElem() || !nameHit(qName, qNameSet, xobj4._name)) {
                        }
                    }
                }
            }
            return this._child;
        }
    }

    static {
        if (class$org$apache$xmlbeans$impl$store$Locale == null) {
            class$org$apache$xmlbeans$impl$store$Locale = class$("org.apache.xmlbeans.impl.store.Locale");
        }
        $assertionsDisabled = true;
        _xsiNil = new QName(_xsi, "nil", "xsi");
        _xsiType = new QName(_xsi, "type", "xsi");
        _xsiLoc = new QName(_xsi, "schemaLocation", "xsi");
        _xsiNoLoc = new QName(_xsi, "noNamespaceSchemaLocation", "xsi");
        _openuriFragment = new QName(_openFragUri, "fragment", "frag");
        _xmlFragment = new QName("xml-fragment");
        tl_scrubBuffer = new ThreadLocal() { // from class: org.apache.xmlbeans.impl.store.Locale.1
            @Override // java.lang.ThreadLocal
            public Object initialValue() {
                return new SoftReference(new ScrubBuffer());
            }
        };
    }

    private Locale(SchemaTypeLoader schemaTypeLoader, XmlOptions xmlOptions) {
        XmlOptions xmlOptionsMaskNull = XmlOptions.maskNull(xmlOptions);
        this._noSync = xmlOptionsMaskNull.hasOption(XmlOptions.UNSYNCHRONIZED);
        this._numTempFramesLeft = 8;
        this._tempFrames = new Cur[8];
        this._qnameFactory = new DefaultQNameFactory();
        this._locations = new Cur.Locations(this);
        this._schemaTypeLoader = schemaTypeLoader;
        this._validateOnSet = xmlOptionsMaskNull.hasOption(XmlOptions.VALIDATE_ON_SET);
        Object obj = xmlOptionsMaskNull.get(Saaj.SAAJ_IMPL);
        if (obj != null) {
            if (!(obj instanceof Saaj)) {
                StringBuffer stringBuffer = new StringBuffer("Saaj impl not correct type: ");
                stringBuffer.append(obj);
                throw new IllegalStateException(stringBuffer.toString());
            }
            Saaj saaj = (Saaj) obj;
            this._saaj = saaj;
            saaj.setCallback(this);
        }
    }

    private static void addNamespace(StringBuffer stringBuffer, QName qName) {
        if (qName.getNamespaceURI() == null) {
            stringBuffer.append("<no namespace>");
            return;
        }
        stringBuffer.append("\"");
        stringBuffer.append(qName.getNamespaceURI());
        stringBuffer.append("\"");
    }

    public static void applyNamespaces(Cur cur, Map map) {
        if (!$assertionsDisabled && !cur.isContainer()) {
            throw new AssertionError();
        }
        for (String str : map.keySet()) {
            if (!str.toLowerCase().startsWith("xml") && cur.namespaceForPrefix(str, false) == null) {
                cur.push();
                cur.next();
                cur.createAttr(cur._locale.createXmlns(str));
                cur.next();
                cur.insertString((String) map.get(str));
                cur.pop();
            }
        }
    }

    public static String applyWhiteSpaceRule(String str, int i) {
        boolean z = false;
        int length = str == null ? 0 : str.length();
        if (length == 0) {
            return str;
        }
        int i2 = 1;
        if (i == 1) {
            return str;
        }
        if (i == 2) {
            for (int i4 = 0; i4 < length; i4++) {
                char cCharAt = str.charAt(i4);
                if (cCharAt == '\n' || cCharAt == '\r' || cCharAt == '\t') {
                    return processWhiteSpaceRule(str, i);
                }
            }
            return str;
        }
        if (i != 3) {
            return str;
        }
        if (CharUtil.isWhiteSpace(str.charAt(0)) || CharUtil.isWhiteSpace(str.charAt(length - 1))) {
            return processWhiteSpaceRule(str, i);
        }
        while (i2 < length) {
            boolean zIsWhiteSpace = CharUtil.isWhiteSpace(str.charAt(i2));
            if (zIsWhiteSpace && z) {
                return processWhiteSpaceRule(str, i);
            }
            i2++;
            z = zIsWhiteSpace;
        }
        return str;
    }

    public static void associateSourceName(Cur cur, XmlOptions xmlOptions) {
        String str = (String) XmlOptions.safeGet(xmlOptions, XmlOptions.DOCUMENT_SOURCE_NAME);
        if (str != null) {
            getDocProps(cur, true).setSourceName(str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void autoTypeDocument(Cur cur, SchemaType schemaType, XmlOptions xmlOptions) {
        SchemaType schemaTypeFindType;
        boolean z = $assertionsDisabled;
        if (!z && !cur.isRoot()) {
            throw new AssertionError();
        }
        SchemaType schemaType2 = (SchemaType) XmlOptions.maskNull(xmlOptions).get(XmlOptions.DOCUMENT_TYPE);
        if (schemaType2 != null) {
            cur.setType(schemaType2);
            return;
        }
        SchemaType schemaTypeFindAttributeType = null;
        if (schemaType == null || schemaType.getName() != null) {
            QName xsiTypeName = cur.getXsiTypeName();
            schemaTypeFindType = xsiTypeName == null ? null : cur._locale._schemaTypeLoader.findType(xsiTypeName);
            if (schemaType != null && !schemaType.isAssignableFrom(schemaTypeFindType)) {
                schemaTypeFindType = null;
            }
        }
        if (schemaTypeFindType == null && (schemaType == null || schemaType.isDocumentType())) {
            if (!z && !cur.isRoot()) {
                throw new AssertionError();
            }
            cur.push();
            QName name = (cur.hasAttrs() || !toFirstChildElement(cur) || toNextSiblingElement(cur)) ? null : cur.getName();
            cur.pop();
            if (name != null && (schemaTypeFindType = cur._locale._schemaTypeLoader.findDocumentType(name)) != null && schemaType != null) {
                QName documentElementName = schemaType.getDocumentElementName();
                if (!documentElementName.equals(name) && !schemaType.isValidSubstitution(name)) {
                    StringBuffer stringBuffer = new StringBuffer("Element ");
                    stringBuffer.append(QNameHelper.pretty(name));
                    stringBuffer.append(" is not a valid ");
                    stringBuffer.append(QNameHelper.pretty(documentElementName));
                    stringBuffer.append(" document or a valid substitution.");
                    throw new XmlException(stringBuffer.toString());
                }
            }
        }
        if (schemaTypeFindType == null && schemaType == null) {
            cur.push();
            if (toFirstNormalAttr(cur) && !toNextNormalAttr(cur)) {
                schemaTypeFindAttributeType = cur._locale._schemaTypeLoader.findAttributeType(cur.getName());
            }
            cur.pop();
            schemaTypeFindType = schemaTypeFindAttributeType;
        }
        if (schemaTypeFindType == null) {
            schemaTypeFindType = schemaType;
        }
        if (schemaTypeFindType == null) {
            schemaTypeFindType = XmlBeans.NO_TYPE;
        }
        cur.setType(schemaTypeFindType);
        if (schemaType != null) {
            if (schemaTypeFindType.isDocumentType()) {
                verifyDocumentType(cur, schemaTypeFindType.getDocumentElementName());
            } else if (schemaTypeFindType.isAttributeType()) {
                verifyAttributeType(cur, schemaTypeFindType.getAttributeTypeAttributeName());
            }
        }
    }

    public static boolean beginsWithXml(String str) {
        char cCharAt;
        char cCharAt2;
        if (str.length() < 3) {
            return false;
        }
        char cCharAt3 = str.charAt(0);
        return (cCharAt3 == 'x' || cCharAt3 == 'X') && ((cCharAt = str.charAt(1)) == 'm' || cCharAt == 'M') && ((cCharAt2 = str.charAt(2)) == 'l' || cCharAt2 == 'L');
    }

    private static DomImpl.Dom checkNode(Node node) {
        if (node == null) {
            throw new IllegalArgumentException("Node is null");
        }
        if (node instanceof DomImpl.Dom) {
            return (DomImpl.Dom) node;
        }
        throw new IllegalArgumentException("Node is not an XmlBeans node");
    }

    public static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw AbstractC12991c.m13994o(e);
        }
    }

    private void doAttributes(XMLStreamReader xMLStreamReader, LoadContext loadContext) {
        int attributeCount = xMLStreamReader.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            loadContext.attr(xMLStreamReader.getAttributeLocalName(i), xMLStreamReader.getAttributeNamespace(i), xMLStreamReader.getAttributePrefix(i), xMLStreamReader.getAttributeValue(i));
        }
    }

    private void doNamespaces(XMLStreamReader xMLStreamReader, LoadContext loadContext) {
        int namespaceCount = xMLStreamReader.getNamespaceCount();
        for (int i = 0; i < namespaceCount; i++) {
            String namespacePrefix = xMLStreamReader.getNamespacePrefix(i);
            if (namespacePrefix == null || namespacePrefix.length() == 0) {
                loadContext.attr(XMLConstants.XMLNS_ATTRIBUTE, "http://www.w3.org/2000/xmlns/", null, xMLStreamReader.getNamespaceURI(i));
            } else {
                loadContext.attr(namespacePrefix, "http://www.w3.org/2000/xmlns/", XMLConstants.XMLNS_ATTRIBUTE, xMLStreamReader.getNamespaceURI(i));
            }
        }
    }

    public static Map getAllNamespaces(Cur cur, Map map) {
        boolean z = $assertionsDisabled;
        if (!z && !cur.isNode()) {
            throw new AssertionError();
        }
        cur.push();
        if (!cur.isContainer()) {
            cur.toParent();
        }
        if (!z && !cur.isContainer()) {
            throw new AssertionError();
        }
        do {
            QName name = cur.getName();
            while (cur.toNextAttr()) {
                if (cur.isXmlns()) {
                    String xmlnsPrefix = cur.getXmlnsPrefix();
                    String xmlnsUri = cur.getXmlnsUri();
                    if (xmlnsPrefix.length() != 0 || xmlnsUri.length() <= 0 || name == null || name.getNamespaceURI().length() <= 0) {
                        if (map == null) {
                            map = new HashMap();
                        }
                        if (!map.containsKey(xmlnsPrefix)) {
                            map.put(xmlnsPrefix, xmlnsUri);
                        }
                    }
                }
            }
            if (!cur.isContainer()) {
                cur.toParentRaw();
            }
        } while (cur.toParentRaw());
        cur.pop();
        return map;
    }

    public static XmlDocumentProperties getDocProps(Cur cur, boolean z) throws Throwable {
        cur.push();
        while (cur.toParent()) {
        }
        Class clsClass$ = class$org$apache$xmlbeans$impl$store$Locale$DocProps;
        if (clsClass$ == null) {
            clsClass$ = class$("org.apache.xmlbeans.impl.store.Locale$DocProps");
            class$org$apache$xmlbeans$impl$store$Locale$DocProps = clsClass$;
        }
        DocProps docProps = (DocProps) cur.getBookmark(clsClass$);
        if (docProps == null && z) {
            Class clsClass$2 = class$org$apache$xmlbeans$impl$store$Locale$DocProps;
            if (clsClass$2 == null) {
                clsClass$2 = class$("org.apache.xmlbeans.impl.store.Locale$DocProps");
                class$org$apache$xmlbeans$impl$store$Locale$DocProps = clsClass$2;
            }
            docProps = new DocProps();
            cur.setBookmark(clsClass$2, docProps);
        }
        cur.pop();
        return docProps;
    }

    public static Locale getLocale(SchemaTypeLoader schemaTypeLoader, XmlOptions xmlOptions) {
        Locale locale;
        if (schemaTypeLoader == null) {
            schemaTypeLoader = XmlBeans.getContextTypeLoader();
        }
        XmlOptions xmlOptionsMaskNull = XmlOptions.maskNull(xmlOptions);
        if (!xmlOptionsMaskNull.hasOption(USE_SAME_LOCALE)) {
            return new Locale(schemaTypeLoader, xmlOptionsMaskNull);
        }
        Object obj = xmlOptionsMaskNull.get(USE_SAME_LOCALE);
        if (obj instanceof Locale) {
            locale = (Locale) obj;
        } else {
            if (!(obj instanceof XmlTokenSource)) {
                StringBuffer stringBuffer = new StringBuffer("Source locale not understood: ");
                stringBuffer.append(obj);
                throw new IllegalArgumentException(stringBuffer.toString());
            }
            locale = (Locale) ((XmlTokenSource) obj).monitor();
        }
        if (locale._schemaTypeLoader != schemaTypeLoader) {
            throw new IllegalArgumentException("Source locale does not support same schema type loader");
        }
        Saaj saaj = locale._saaj;
        if (saaj != null && saaj != xmlOptionsMaskNull.get(Saaj.SAAJ_IMPL)) {
            throw new IllegalArgumentException("Source locale does not support same saaj");
        }
        if (!locale._validateOnSet || xmlOptionsMaskNull.hasOption(XmlOptions.VALIDATE_ON_SET)) {
            return locale;
        }
        throw new IllegalArgumentException("Source locale does not support same validate on set");
    }

    private static SaxLoader getPiccoloSaxLoader() {
        SaxLoader saxLoader = (SaxLoader) SystemCache.get().getSaxLoader();
        if (saxLoader != null) {
            return saxLoader;
        }
        PiccoloSaxLoader piccoloSaxLoaderNewInstance = PiccoloSaxLoader.newInstance();
        SystemCache.get().setSaxLoader(piccoloSaxLoaderNewInstance);
        return piccoloSaxLoaderNewInstance;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static SaxLoader getSaxLoader(XmlOptions xmlOptions) {
        XmlOptions xmlOptionsMaskNull = XmlOptions.maskNull(xmlOptions);
        EntityResolver entityResolver = null;
        Object[] objArr = 0;
        if (!xmlOptionsMaskNull.hasOption(XmlOptions.LOAD_USE_DEFAULT_RESOLVER)) {
            EntityResolver defaultEntityResolver = (EntityResolver) xmlOptionsMaskNull.get(XmlOptions.ENTITY_RESOLVER);
            if (defaultEntityResolver == null) {
                defaultEntityResolver = ResolverUtil.getGlobalEntityResolver();
            }
            if (defaultEntityResolver == null) {
                defaultEntityResolver = new DefaultEntityResolver();
            }
            entityResolver = defaultEntityResolver;
        }
        if (!xmlOptionsMaskNull.hasOption(XmlOptions.LOAD_USE_XMLREADER)) {
            SaxLoader piccoloSaxLoader = getPiccoloSaxLoader();
            piccoloSaxLoader.setEntityResolver(entityResolver);
            return piccoloSaxLoader;
        }
        XMLReader xMLReader = (XMLReader) xmlOptionsMaskNull.get(XmlOptions.LOAD_USE_XMLREADER);
        if (xMLReader == null) {
            throw new IllegalArgumentException("XMLReader is null");
        }
        XmlReaderSaxLoader xmlReaderSaxLoader = new XmlReaderSaxLoader(xMLReader);
        if (entityResolver != null) {
            xMLReader.setEntityResolver(entityResolver);
        }
        return xmlReaderSaxLoader;
    }

    public static ScrubBuffer getScrubBuffer(int i) {
        ScrubBuffer scrubBuffer = (ScrubBuffer) ((SoftReference) tl_scrubBuffer.get()).get();
        if (scrubBuffer == null) {
            scrubBuffer = new ScrubBuffer();
            tl_scrubBuffer.set(new SoftReference(scrubBuffer));
        }
        scrubBuffer.init(i);
        return scrubBuffer;
    }

    public static String getTextValue(Cur cur) {
        if (!$assertionsDisabled && !cur.isNode()) {
            throw new AssertionError();
        }
        if (!cur.hasChildren()) {
            return cur.getValueAsString();
        }
        StringBuffer stringBuffer = new StringBuffer();
        cur.push();
        while (true) {
            cur.next();
            if (cur.isAtEndOfLastPush()) {
                cur.pop();
                return stringBuffer.toString();
            }
            if (cur.isText() && ((!cur._xobj.isComment() && !cur._xobj.isProcinst()) || cur._pos >= cur._xobj._cchValue)) {
                CharUtil.getString(stringBuffer, cur.getChars(-1), cur._offSrc, cur._cchSrc);
            }
        }
    }

    public static boolean isFragment(Cur cur, Cur cur2) {
        boolean z;
        int iKind;
        if (!$assertionsDisabled && cur2.isAttr()) {
            throw new AssertionError();
        }
        cur.push();
        cur2.push();
        int i = 0;
        while (!cur.isSamePos(cur2) && (iKind = cur.kind()) != 3) {
            if ((iKind == 0 && !isWhiteSpace(cur.getCharsAsString(-1))) || (iKind == 2 && (i = i + 1) > 1)) {
                z = true;
                break;
            }
            if (!$assertionsDisabled && iKind == 3) {
                throw new AssertionError();
            }
            if (iKind != 0) {
                cur.toEnd();
            }
            cur.next();
        }
        z = false;
        cur.pop();
        cur2.pop();
        return z || i != 1;
    }

    public static boolean isFragmentQName(QName qName) {
        return qName.equals(_openuriFragment) || qName.equals(_xmlFragment);
    }

    public static final boolean isWhiteSpace(String str) {
        int length = str.length();
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (!CharUtil.isWhiteSpace(str.charAt(i))) {
                return false;
            }
            length = i;
        }
    }

    public static boolean isXmlns(QName qName) {
        String prefix = qName.getPrefix();
        if (prefix.equals(XMLConstants.XMLNS_ATTRIBUTE)) {
            return true;
        }
        return prefix.length() == 0 && qName.getLocalPart().equals(XMLConstants.XMLNS_ATTRIBUTE);
    }

    private static void lineNumber(XMLEvent xMLEvent, LoadContext loadContext) {
        Location location = xMLEvent.getLocation();
        if (location != null) {
            loadContext.lineNumber(location.getLineNumber(), location.getColumnNumber(), -1);
        }
    }

    private DomImpl.Dom load(InputSource inputSource, XmlOptions xmlOptions) {
        return getSaxLoader(xmlOptions).load(this, inputSource, xmlOptions).getDom();
    }

    private void loadNodeChildren(Node node, LoadContext loadContext) {
        for (Node firstChild = node.getFirstChild(); firstChild != null; firstChild = firstChild.getNextSibling()) {
            loadNode(firstChild, loadContext);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Cur loadXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws Throwable {
        Map namespaceMap;
        XmlOptions xmlOptionsMaskNull = XmlOptions.maskNull(xmlOptions);
        boolean zHasOption = xmlOptionsMaskNull.hasOption(XmlOptions.LOAD_LINE_NUMBERS);
        StartElement startElementPeek = xMLInputStream.peek();
        if (startElementPeek != null && startElementPeek.getType() == 2 && (namespaceMap = startElementPeek.getNamespaceMap()) != null && namespaceMap.size() > 0) {
            HashMap map = new HashMap();
            map.putAll(namespaceMap);
            XmlOptions xmlOptions2 = new XmlOptions(xmlOptionsMaskNull);
            xmlOptions2.put(XmlOptions.LOAD_ADDITIONAL_NAMESPACES, map);
            xmlOptionsMaskNull = xmlOptions2;
        }
        Cur.CurLoadContext curLoadContext = new Cur.CurLoadContext(this, xmlOptionsMaskNull);
        StartDocument next = xMLInputStream.next();
        String str = null;
        boolean z = true;
        String str2 = null;
        String str3 = null;
        while (true) {
            if (next != null) {
                int type = next.getType();
                if (type != 1) {
                    if (type != 2) {
                        switch (type) {
                            case 4:
                                curLoadContext.endElement();
                                if (zHasOption) {
                                    lineNumber((XMLEvent) next, (LoadContext) curLoadContext);
                                }
                                break;
                            case 8:
                                ProcessingInstruction processingInstruction = (ProcessingInstruction) next;
                                curLoadContext.procInst(processingInstruction.getTarget(), processingInstruction.getData());
                                if (zHasOption) {
                                    lineNumber((XMLEvent) next, (LoadContext) curLoadContext);
                                }
                                break;
                            case 16:
                                CharacterData characterData = (CharacterData) next;
                                if (characterData.hasContent()) {
                                    curLoadContext.text(characterData.getContent());
                                    if (zHasOption) {
                                        lineNumber((XMLEvent) next, (LoadContext) curLoadContext);
                                    }
                                }
                                break;
                            case 32:
                                Comment comment = (Comment) next;
                                if (comment.hasContent()) {
                                    curLoadContext.comment(comment.getContent());
                                    if (zHasOption) {
                                        lineNumber((XMLEvent) next, (LoadContext) curLoadContext);
                                    }
                                }
                                break;
                            case 64:
                                if (((Space) next).ignorable()) {
                                    break;
                                }
                                break;
                            case 128:
                                if (!xMLInputStream.hasNext()) {
                                }
                                break;
                            case 256:
                                StartDocument startDocument = next;
                                String systemId = startDocument.getSystemId();
                                String characterEncodingScheme = startDocument.getCharacterEncodingScheme();
                                String version = startDocument.getVersion();
                                startDocument.isStandalone();
                                boolean zIsStandalone = startDocument.isStandalone();
                                if (zHasOption) {
                                    lineNumber((XMLEvent) next, (LoadContext) curLoadContext);
                                }
                                z = zIsStandalone;
                                str = systemId;
                                str2 = characterEncodingScheme;
                                str3 = version;
                                break;
                            case 512:
                                if (zHasOption) {
                                    lineNumber((XMLEvent) next, (LoadContext) curLoadContext);
                                }
                                break;
                            case 1024:
                            case 2048:
                            case 4096:
                            case 8192:
                                break;
                            default:
                                StringBuffer stringBuffer = new StringBuffer("Unhandled xml event type: ");
                                stringBuffer.append(next.getTypeAsString());
                                throw new RuntimeException(stringBuffer.toString());
                        }
                    } else {
                        curLoadContext.startElement(XMLNameHelper.getQName(next.getName()));
                        if (zHasOption) {
                            lineNumber((XMLEvent) next, (LoadContext) curLoadContext);
                        }
                        StartElement startElement = (StartElement) next;
                        AttributeIterator attributes = startElement.getAttributes();
                        while (attributes.hasNext()) {
                            Attribute next2 = attributes.next();
                            curLoadContext.attr(XMLNameHelper.getQName(next2.getName()), next2.getValue());
                        }
                        AttributeIterator namespaces = startElement.getNamespaces();
                        while (namespaces.hasNext()) {
                            Attribute next3 = namespaces.next();
                            XMLName name = next3.getName();
                            String localName = name.getLocalName();
                            if (name.getPrefix() == null && localName.equals(XMLConstants.XMLNS_ATTRIBUTE)) {
                                localName = "";
                            }
                            curLoadContext.xmlns(localName, next3.getValue());
                        }
                    }
                }
                next = xMLInputStream.next();
            }
        }
        Cur curFinish = curLoadContext.finish();
        associateSourceName(curFinish, xmlOptionsMaskNull);
        XmlDocumentProperties docProps = getDocProps(curFinish, true);
        docProps.setDoctypeSystemId(str);
        docProps.setEncoding(str2);
        docProps.setVersion(str3);
        docProps.setStandalone(z);
        return curFinish;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b8 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c1 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Cur loadXMLStreamReader(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws Throwable {
        XmlOptions xmlOptionsMaskNull = XmlOptions.maskNull(xmlOptions);
        boolean zHasOption = xmlOptionsMaskNull.hasOption(XmlOptions.LOAD_LINE_NUMBERS);
        Cur.CurLoadContext curLoadContext = new Cur.CurLoadContext(this, xmlOptionsMaskNull);
        int eventType = xMLStreamReader.getEventType();
        String str = null;
        int i = 0;
        boolean z = false;
        String str2 = null;
        while (true) {
            switch (eventType) {
                case 1:
                    i++;
                    curLoadContext.startElement(xMLStreamReader.getName());
                    if (zHasOption) {
                        lineNumber(xMLStreamReader, curLoadContext);
                    }
                    doAttributes(xMLStreamReader, curLoadContext);
                    doNamespaces(xMLStreamReader, curLoadContext);
                    if (xMLStreamReader.hasNext() && i > 0) {
                        eventType = xMLStreamReader.next();
                    }
                    break;
                case 2:
                    i--;
                    curLoadContext.endElement();
                    if (zHasOption) {
                        lineNumber(xMLStreamReader, curLoadContext);
                    }
                    if (xMLStreamReader.hasNext()) {
                    }
                    break;
                case 3:
                    curLoadContext.procInst(xMLStreamReader.getPITarget(), xMLStreamReader.getPIData());
                    if (zHasOption) {
                        lineNumber(xMLStreamReader, curLoadContext);
                    }
                    if (xMLStreamReader.hasNext()) {
                    }
                    break;
                case 4:
                case 12:
                    curLoadContext.text(xMLStreamReader.getTextCharacters(), xMLStreamReader.getTextStart(), xMLStreamReader.getTextLength());
                    if (zHasOption) {
                        lineNumber(xMLStreamReader, curLoadContext);
                    }
                    if (xMLStreamReader.hasNext()) {
                    }
                    break;
                case 5:
                    curLoadContext.comment(xMLStreamReader.getText());
                    if (zHasOption) {
                        lineNumber(xMLStreamReader, curLoadContext);
                    }
                    if (xMLStreamReader.hasNext()) {
                    }
                    break;
                case 6:
                case 11:
                    if (xMLStreamReader.hasNext()) {
                    }
                    break;
                case 7:
                    i++;
                    String characterEncodingScheme = xMLStreamReader.getCharacterEncodingScheme();
                    String version = xMLStreamReader.getVersion();
                    boolean zIsStandalone = xMLStreamReader.isStandalone();
                    if (zHasOption) {
                        lineNumber(xMLStreamReader, curLoadContext);
                    }
                    z = zIsStandalone;
                    str2 = version;
                    str = characterEncodingScheme;
                    if (xMLStreamReader.hasNext()) {
                    }
                    break;
                case 8:
                    if (zHasOption) {
                        lineNumber(xMLStreamReader, curLoadContext);
                    }
                    break;
                case 9:
                    curLoadContext.text(xMLStreamReader.getText());
                    if (xMLStreamReader.hasNext()) {
                    }
                    break;
                case 10:
                    doAttributes(xMLStreamReader, curLoadContext);
                    if (xMLStreamReader.hasNext()) {
                    }
                    break;
                case 13:
                    doNamespaces(xMLStreamReader, curLoadContext);
                    if (xMLStreamReader.hasNext()) {
                    }
                    break;
                default:
                    StringBuffer stringBuffer = new StringBuffer("Unhandled xml event type: ");
                    stringBuffer.append(eventType);
                    throw new RuntimeException(stringBuffer.toString());
            }
        }
        Cur curFinish = curLoadContext.finish();
        associateSourceName(curFinish, xmlOptionsMaskNull);
        XmlDocumentProperties docProps = getDocProps(curFinish, true);
        docProps.setEncoding(str);
        docProps.setVersion(str2);
        docProps.setStandalone(z);
        return curFinish;
    }

    private static boolean namespacesSame(QName qName, QName qName2) {
        if (qName == qName2) {
            return true;
        }
        if (qName != null && qName2 != null) {
            if (qName.getNamespaceURI() == qName2.getNamespaceURI()) {
                return true;
            }
            if (qName.getNamespaceURI() != null && qName2.getNamespaceURI() != null) {
                return qName.getNamespaceURI().equals(qName2.getNamespaceURI());
            }
        }
        return false;
    }

    public static DOMImplementation newDomImplementation(SchemaTypeLoader schemaTypeLoader, XmlOptions xmlOptions) {
        return getLocale(schemaTypeLoader, xmlOptions);
    }

    public static XmlObject newInstance(SchemaTypeLoader schemaTypeLoader, SchemaType schemaType, XmlOptions xmlOptions) {
        XmlObject xmlObjectNewInstance;
        Locale locale = getLocale(schemaTypeLoader, xmlOptions);
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale.newInstance(schemaType, xmlOptions);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    xmlObjectNewInstance = locale.newInstance(schemaType, xmlOptions);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return xmlObjectNewInstance;
    }

    public static XmlSaxHandler newSaxHandler(SchemaTypeLoader schemaTypeLoader, SchemaType schemaType, XmlOptions xmlOptions) {
        XmlSaxHandler xmlSaxHandlerNewSaxHandler;
        Locale locale = getLocale(schemaTypeLoader, xmlOptions);
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale.newSaxHandler(schemaType, xmlOptions);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    xmlSaxHandlerNewSaxHandler = locale.newSaxHandler(schemaType, xmlOptions);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return xmlSaxHandlerNewSaxHandler;
    }

    public static XmlCursor nodeToCursor(Node node) {
        return DomImpl._getXmlCursor(checkNode(node));
    }

    public static XmlObject nodeToXmlObject(Node node) {
        return DomImpl._getXmlObject(checkNode(node));
    }

    public static XMLStreamReader nodeToXmlStream(Node node) {
        return DomImpl._getXmlStreamReader(checkNode(node));
    }

    public static XmlObject parseToXmlObject(SchemaTypeLoader schemaTypeLoader, String str, SchemaType schemaType, XmlOptions xmlOptions) {
        XmlObject toXmlObject;
        Locale locale = getLocale(schemaTypeLoader, xmlOptions);
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale.parseToXmlObject(str, schemaType, xmlOptions);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    toXmlObject = locale.parseToXmlObject(str, schemaType, xmlOptions);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return toXmlObject;
    }

    private void pollQueue() {
        if (this._refQueue == null) {
            return;
        }
        while (true) {
            Ref ref = (Ref) this._refQueue.poll();
            if (ref == null) {
                return;
            }
            Cur cur = ref._cur;
            if (cur != null) {
                cur.release();
            }
        }
    }

    public static String processWhiteSpaceRule(String str, int i) {
        ScrubBuffer scrubBuffer = getScrubBuffer(i);
        scrubBuffer.scrub(str, 0, str.length());
        return scrubBuffer.getResultAsString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0022, code lost:
    
        r3.pop();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0026, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean pushToContainer(Cur cur) {
        cur.push();
        while (true) {
            int iKind = cur.kind();
            if (iKind == -2 || iKind == -1) {
                break;
            }
            if (iKind == 1 || iKind == 2) {
                break;
            }
            if (iKind == 4 || iKind == 5) {
                cur.skip();
            } else {
                cur.nextWithAttrs();
            }
        }
        return true;
    }

    public static Node streamToNode(XMLStreamReader xMLStreamReader) {
        return Jsr173.nodeFromStream(xMLStreamReader);
    }

    public static boolean toChild(Cur cur, QName qName, int i) {
        if (i < 0 || !pushToContainer(cur)) {
            return false;
        }
        Xobj xobjFindNthChildElem = cur._locale.findNthChildElem(cur._xobj, qName, null, i);
        cur.pop();
        if (xobjFindNthChildElem == null) {
            return false;
        }
        cur.moveTo(xobjFindNthChildElem);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x003b, code lost:
    
        r6.moveTo(r0, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x003e, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean toFirstChildElement(Cur cur) {
        Xobj xobj = cur._xobj;
        int i = cur._pos;
        while (true) {
            int iKind = cur.kind();
            if (iKind == -2 || iKind == -1) {
                break;
            }
            if (iKind == 1 || iKind == 2) {
                break;
            }
            if (iKind == 4 || iKind == 5) {
                cur.skip();
            } else {
                cur.nextWithAttrs();
            }
        }
        if (cur.toFirstChild() && (cur.isElem() || toNextSiblingElement(cur))) {
            return true;
        }
        cur.moveTo(xobj, i);
        return false;
    }

    public static boolean toFirstNormalAttr(Cur cur) {
        cur.push();
        if (cur.toFirstAttr()) {
            while (cur.isXmlns()) {
                if (!cur.toNextAttr()) {
                }
            }
            cur.popButStay();
            return true;
        }
        cur.pop();
        return false;
    }

    public static boolean toLastChildElement(Cur cur) {
        if (!pushToContainer(cur)) {
            return false;
        }
        if (cur.toLastChild() && (cur.isElem() || toPrevSiblingElement(cur))) {
            cur.popButStay();
            return true;
        }
        cur.pop();
        return false;
    }

    public static boolean toNextNormalAttr(Cur cur) {
        cur.push();
        while (cur.toNextAttr()) {
            if (!cur.isXmlns()) {
                cur.popButStay();
                return true;
            }
        }
        cur.pop();
        return false;
    }

    public static boolean toNextSiblingElement(Cur cur) {
        if (!cur.hasParent()) {
            return false;
        }
        cur.push();
        int iKind = cur.kind();
        if (iKind == 3) {
            cur.toParent();
            cur.next();
        } else if (iKind == 2) {
            cur.skip();
        }
        while (true) {
            int iKind2 = cur.kind();
            if (iKind2 < 0) {
                cur.pop();
                return false;
            }
            if (iKind2 == 2) {
                cur.popButStay();
                return true;
            }
            if (iKind2 > 0) {
                cur.toEnd();
            }
            cur.next();
        }
    }

    public static boolean toPrevNormalAttr(Cur cur) {
        if (!cur.isAttr()) {
            return false;
        }
        cur.push();
        do {
            if (!$assertionsDisabled && !cur.isAttr()) {
                throw new AssertionError();
            }
            if (!cur.prev()) {
                cur.pop();
                return false;
            }
            cur.prev();
            if (!cur.isAttr()) {
                cur.prev();
            }
        } while (!cur.isNormalAttr());
        cur.popButStay();
        return true;
    }

    public static boolean toPrevSiblingElement(Cur cur) {
        int iKind;
        boolean z = false;
        if (!cur.hasParent()) {
            return false;
        }
        Cur curTempCur = cur.tempCur();
        if (curTempCur.kind() != 3) {
            while (true) {
                if (!curTempCur.prev() || (iKind = curTempCur.kind()) == 1 || iKind == 2) {
                    break;
                }
                if (curTempCur.kind() == -2) {
                    curTempCur.toParent();
                    cur.moveToCur(curTempCur);
                    z = true;
                    break;
                }
            }
        }
        curTempCur.release();
        return z;
    }

    private static void verifyAttributeType(Cur cur, QName qName) {
        StringBuffer stringBuffer;
        if (!$assertionsDisabled && !cur.isRoot()) {
            throw new AssertionError();
        }
        cur.push();
        try {
            if (!toFirstNormalAttr(cur) || toNextNormalAttr(cur)) {
                stringBuffer = new StringBuffer();
                stringBuffer.append("The document is not a ");
                stringBuffer.append(QNameHelper.pretty(qName));
                stringBuffer.append(cur.isRoot() ? ": no attributes" : ": multiple attributes");
            } else {
                QName name = cur.getName();
                if (name.equals(qName)) {
                    stringBuffer = null;
                } else {
                    stringBuffer = new StringBuffer();
                    stringBuffer.append("The document is not a ");
                    stringBuffer.append(QNameHelper.pretty(qName));
                    if (qName.getLocalPart().equals(name.getLocalPart())) {
                        stringBuffer.append(": attribute namespace mismatch ");
                        stringBuffer.append("expected ");
                        addNamespace(stringBuffer, qName);
                        stringBuffer.append(" got ");
                        addNamespace(stringBuffer, name);
                    } else if (namespacesSame(qName, name)) {
                        stringBuffer.append(": attribute local name mismatch ");
                        StringBuffer stringBuffer2 = new StringBuffer("expected ");
                        stringBuffer2.append(qName.getLocalPart());
                        stringBuffer.append(stringBuffer2.toString());
                        StringBuffer stringBuffer3 = new StringBuffer(" got ");
                        stringBuffer3.append(name.getLocalPart());
                        stringBuffer.append(stringBuffer3.toString());
                    } else {
                        stringBuffer.append(": attribute element mismatch ");
                        stringBuffer.append("got ");
                        stringBuffer.append(QNameHelper.pretty(name));
                    }
                }
            }
            if (stringBuffer == null) {
                cur.pop();
            } else {
                XmlError xmlErrorForCursor = XmlError.forCursor(stringBuffer.toString(), new Cursor(cur));
                throw new XmlException(xmlErrorForCursor.toString(), (Throwable) null, xmlErrorForCursor);
            }
        } catch (Throwable th) {
            cur.pop();
            throw th;
        }
    }

    private static void verifyDocumentType(Cur cur, QName qName) {
        StringBuffer stringBuffer;
        if (!$assertionsDisabled && !cur.isRoot()) {
            throw new AssertionError();
        }
        cur.push();
        try {
            if (!toFirstChildElement(cur) || toNextSiblingElement(cur)) {
                stringBuffer = new StringBuffer();
                stringBuffer.append("The document is not a ");
                stringBuffer.append(QNameHelper.pretty(qName));
                stringBuffer.append(cur.isRoot() ? ": no document element" : ": multiple document elements");
            } else {
                QName name = cur.getName();
                if (name.equals(qName)) {
                    stringBuffer = null;
                } else {
                    stringBuffer = new StringBuffer();
                    stringBuffer.append("The document is not a ");
                    stringBuffer.append(QNameHelper.pretty(qName));
                    if (qName.getLocalPart().equals(name.getLocalPart())) {
                        stringBuffer.append(": document element namespace mismatch ");
                        stringBuffer.append("expected ");
                        addNamespace(stringBuffer, qName);
                        stringBuffer.append(" got ");
                        addNamespace(stringBuffer, name);
                    } else if (namespacesSame(qName, name)) {
                        stringBuffer.append(": document element local name mismatch ");
                        StringBuffer stringBuffer2 = new StringBuffer("expected ");
                        stringBuffer2.append(qName.getLocalPart());
                        stringBuffer.append(stringBuffer2.toString());
                        StringBuffer stringBuffer3 = new StringBuffer(" got ");
                        stringBuffer3.append(name.getLocalPart());
                        stringBuffer.append(stringBuffer3.toString());
                    } else {
                        stringBuffer.append(": document element mismatch ");
                        stringBuffer.append("got ");
                        stringBuffer.append(QNameHelper.pretty(name));
                    }
                }
            }
            if (stringBuffer == null) {
                cur.pop();
            } else {
                XmlError xmlErrorForCursor = XmlError.forCursor(stringBuffer.toString(), new Cursor(cur));
                throw new XmlException(xmlErrorForCursor.toString(), (Throwable) null, xmlErrorForCursor);
            }
        } catch (Throwable th) {
            cur.pop();
            throw th;
        }
    }

    public static String xmlnsPrefix(QName qName) {
        return qName.getPrefix().equals(XMLConstants.XMLNS_ATTRIBUTE) ? qName.getLocalPart() : "";
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int count(Xobj xobj, QName qName, QNameSet qNameSet) {
        int i = 0;
        for (Xobj xobjFindNthChildElem = findNthChildElem(xobj, qName, qNameSet, 0); xobjFindNthChildElem != null; xobjFindNthChildElem = xobjFindNthChildElem._nextSibling) {
            if (xobjFindNthChildElem.isElem()) {
                if (qNameSet == null) {
                    if (xobjFindNthChildElem._name.equals(qName)) {
                        i++;
                    }
                } else if (qNameSet.contains(xobjFindNthChildElem._name)) {
                }
            }
        }
        return i;
    }

    public DomImpl.CdataNode createCdataNode() {
        return this._saaj == null ? new DomImpl.CdataNode(this) : new DomImpl.SaajCdataNode(this);
    }

    @Override // org.w3c.dom.DOMImplementation
    public Document createDocument(String str, String str2, DocumentType documentType) {
        return DomImpl._domImplementation_createDocument(this, str, str2, documentType);
    }

    @Override // org.w3c.dom.DOMImplementation
    public DocumentType createDocumentType(String str, String str2, String str3) {
        throw new RuntimeException("Not implemented");
    }

    @Override // org.apache.xmlbeans.impl.store.Saaj.SaajCallback
    public Element createSoapElement(QName qName, QName qName2) {
        if ($assertionsDisabled || this._ownerDoc != null) {
            return DomImpl.saajCallback_createSoapElement(this._ownerDoc, qName, qName2);
        }
        throw new AssertionError();
    }

    public DomImpl.TextNode createTextNode() {
        return this._saaj == null ? new DomImpl.TextNode(this) : new DomImpl.SaajTextNode(this);
    }

    public QName createXmlns(String str) {
        if (str == null) {
            str = "";
        }
        return str.length() == 0 ? makeQName("http://www.w3.org/2000/xmlns/", XMLConstants.XMLNS_ATTRIBUTE, "") : makeQName("http://www.w3.org/2000/xmlns/", str, XMLConstants.XMLNS_ATTRIBUTE);
    }

    public int domLength(DomImpl.Dom dom) {
        if (dom == null) {
            return 0;
        }
        int iDistance = this._domNthCache_A.distance(dom, 0);
        int iDistance2 = this._domNthCache_B.distance(dom, 0);
        int length = (iDistance <= iDistance2 ? this._domNthCache_A : this._domNthCache_B).length(dom);
        if (iDistance == iDistance2) {
            domNthCache domnthcache = this._domNthCache_A;
            this._domNthCache_A = this._domNthCache_B;
            this._domNthCache_B = domnthcache;
        }
        return length;
    }

    public void embedCurs() {
        while (true) {
            Cur cur = this._registered;
            if (cur == null) {
                return;
            }
            if (!$assertionsDisabled && cur._xobj == null) {
                throw new AssertionError();
            }
            this._registered = cur.listRemove(cur);
            Xobj xobj = cur._xobj;
            xobj._embedded = cur.listInsert(xobj._embedded);
            cur._state = 2;
        }
    }

    public void enter(Locale locale) {
        enter();
        if (locale != this) {
            locale.enter();
        }
    }

    public boolean entered() {
        return this._tempFrames.length - this._numTempFramesLeft > 0;
    }

    public void exit(Locale locale) {
        exit();
        if (locale != this) {
            locale.exit();
        }
    }

    public DomImpl.Dom findDomNthChild(DomImpl.Dom dom, int i) {
        DomImpl.Dom domFetch;
        if (!$assertionsDisabled && i < 0) {
            throw new AssertionError();
        }
        if (dom == null) {
            return null;
        }
        int iDistance = this._domNthCache_A.distance(dom, i);
        int iDistance2 = this._domNthCache_B.distance(dom, i);
        boolean z = false;
        boolean z2 = iDistance2 - (this._domNthCache_B._len / 2) > 0 && (iDistance2 - (this._domNthCache_B._len / 2)) + (-40) > 0;
        if (iDistance - (this._domNthCache_A._len / 2) > 0 && (iDistance - (this._domNthCache_A._len / 2)) - 40 > 0) {
            z = true;
        }
        if (iDistance <= iDistance2) {
            if (z) {
                this._domNthCache_B._version = -1L;
                domFetch = this._domNthCache_B.fetch(dom, i);
            } else {
                domFetch = this._domNthCache_A.fetch(dom, i);
            }
        } else if (z2) {
            this._domNthCache_A._version = -1L;
            domFetch = this._domNthCache_A.fetch(dom, i);
        } else {
            domFetch = this._domNthCache_B.fetch(dom, i);
        }
        if (iDistance == iDistance2) {
            domNthCache domnthcache = this._domNthCache_A;
            this._domNthCache_A = this._domNthCache_B;
            this._domNthCache_B = domnthcache;
        }
        return domFetch;
    }

    public Xobj findNthChildElem(Xobj xobj, QName qName, QNameSet qNameSet, int i) {
        boolean z = $assertionsDisabled;
        if (!z && qName != null && qNameSet != null) {
            throw new AssertionError();
        }
        if (!z && i < 0) {
            throw new AssertionError();
        }
        if (xobj == null) {
            return null;
        }
        int iDistance = this._nthCache_A.distance(xobj, qName, qNameSet, i);
        int iDistance2 = this._nthCache_B.distance(xobj, qName, qNameSet, i);
        Xobj xobjFetch = (iDistance <= iDistance2 ? this._nthCache_A : this._nthCache_B).fetch(xobj, qName, qNameSet, i);
        if (iDistance == iDistance2) {
            nthCache nthcache = this._nthCache_A;
            this._nthCache_A = this._nthCache_B;
            this._nthCache_B = nthcache;
        }
        return xobjFetch;
    }

    public CharUtil getCharUtil() {
        if (this._charUtil == null) {
            this._charUtil = new CharUtil(1024);
        }
        return this._charUtil;
    }

    public Cur getCur() {
        boolean z = $assertionsDisabled;
        if (!z && this._curPool != null && this._curPoolCount <= 0) {
            throw new AssertionError();
        }
        Cur cur = this._curPool;
        if (cur == null) {
            cur = new Cur(this);
        } else {
            this._curPool = cur.listRemove(cur);
            this._curPoolCount--;
        }
        if (!z && cur._state != 0) {
            throw new AssertionError();
        }
        if (!z && (cur._prev != null || cur._next != null)) {
            throw new AssertionError();
        }
        if (!z && (cur._xobj != null || cur._pos != -2)) {
            throw new AssertionError();
        }
        if (!z && cur._ref != null) {
            throw new AssertionError();
        }
        this._registered = cur.listInsert(this._registered);
        cur._state = 1;
        return cur;
    }

    @Override // org.w3c.dom.DOMImplementation
    public Object getFeature(String str, String str2) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    @Override // org.apache.xmlbeans.impl.store.Saaj.SaajCallback
    public Object getSaajData(Node node) {
        if ($assertionsDisabled || (node instanceof DomImpl.Dom)) {
            return DomImpl.saajCallback_getSaajData((DomImpl.Dom) node);
        }
        throw new AssertionError();
    }

    @Override // org.w3c.dom.DOMImplementation
    public boolean hasFeature(String str, String str2) {
        return DomImpl._domImplementation_hasFeature(this, str, str2);
    }

    @Override // org.apache.xmlbeans.impl.store.Saaj.SaajCallback
    public Element importSoapElement(Document document, Element element, boolean z, QName qName) {
        if ($assertionsDisabled || (document instanceof DomImpl.Dom)) {
            return DomImpl.saajCallback_importSoapElement((DomImpl.Dom) document, element, z, qName);
        }
        throw new AssertionError();
    }

    public void invalidateDomCaches(DomImpl.Dom dom) {
        if (this._domNthCache_A._parent == dom) {
            this._domNthCache_A._version = -1L;
        }
        if (this._domNthCache_B._parent == dom) {
            this._domNthCache_B._version = -1L;
        }
    }

    public boolean isDomCached(DomImpl.Dom dom) {
        return this._domNthCache_A._parent == dom || this._domNthCache_B._parent == dom;
    }

    public void loadNode(Node node, LoadContext loadContext) {
        switch (node.getNodeType()) {
            case 1:
                loadContext.startElement(makeQualifiedQName(node.getNamespaceURI(), node.getNodeName()));
                NamedNodeMap attributes = node.getAttributes();
                for (int i = 0; i < attributes.getLength(); i++) {
                    Node nodeItem = attributes.item(i);
                    String nodeName = nodeItem.getNodeName();
                    String nodeValue = nodeItem.getNodeValue();
                    if (!nodeName.toLowerCase().startsWith(XMLConstants.XMLNS_ATTRIBUTE)) {
                        loadContext.attr(makeQualifiedQName(nodeItem.getNamespaceURI(), nodeName), nodeValue);
                    } else if (nodeName.length() == 5) {
                        loadContext.xmlns(null, nodeValue);
                    } else {
                        loadContext.xmlns(nodeName.substring(6), nodeValue);
                    }
                }
                loadNodeChildren(node, loadContext);
                loadContext.endElement();
                return;
            case 2:
            case 6:
            case 10:
            case 12:
                throw new RuntimeException("Unexpected node");
            case 3:
            case 4:
                loadContext.text(node.getNodeValue());
                return;
            case 5:
            case 9:
            case 11:
                loadNodeChildren(node, loadContext);
                return;
            case 7:
                loadContext.procInst(node.getNodeName(), node.getNodeValue());
                return;
            case 8:
                loadContext.comment(node.getNodeValue());
                return;
            default:
                return;
        }
    }

    public QName makeQName(String str, String str2) {
        if ($assertionsDisabled || (str2 != null && str2.length() > 0)) {
            return this._qnameFactory.getQName(str, str2);
        }
        throw new AssertionError();
    }

    public QName makeQNameNoCheck(String str, String str2) {
        return this._qnameFactory.getQName(str, str2);
    }

    public QName makeQualifiedQName(String str, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        int iIndexOf = str2.indexOf(58);
        return iIndexOf < 0 ? this._qnameFactory.getQName(str, str2) : this._qnameFactory.getQName(str, str2.substring(iIndexOf + 1), str2.substring(0, iIndexOf));
    }

    @Override // org.apache.xmlbeans.impl.common.XmlLocale
    public boolean noSync() {
        return this._noSync;
    }

    public void notifyChange() {
        while (true) {
            ChangeListener changeListener = this._changeListeners;
            if (changeListener == null) {
                this._locations.notifyChange();
                return;
            }
            changeListener.notifyChange();
            ChangeListener nextChangeListener = this._changeListeners.getNextChangeListener();
            ChangeListener changeListener2 = this._changeListeners;
            if (nextChangeListener == changeListener2) {
                changeListener2.setNextChangeListener(null);
            }
            ChangeListener nextChangeListener2 = this._changeListeners.getNextChangeListener();
            this._changeListeners.setNextChangeListener(null);
            this._changeListeners = nextChangeListener2;
        }
    }

    public Cur parse(String str, SchemaType schemaType, XmlOptions xmlOptions) {
        StringReader stringReader = new StringReader(str);
        try {
            try {
                Cur curLoad = getSaxLoader(xmlOptions).load(this, new InputSource(stringReader), xmlOptions);
                autoTypeDocument(curLoad, schemaType, xmlOptions);
                return curLoad;
            } catch (IOException e) {
                if ($assertionsDisabled) {
                    throw new XmlException(e.getMessage(), e);
                }
                throw new AssertionError("StringReader should not throw IOException");
            }
        } finally {
            try {
                stringReader.close();
            } catch (IOException unused) {
            }
        }
    }

    public final ReferenceQueue refQueue() {
        if (this._refQueue == null) {
            this._refQueue = new ReferenceQueue();
        }
        return this._refQueue;
    }

    public void registerForChange(ChangeListener changeListener) {
        if (changeListener.getNextChangeListener() == null) {
            ChangeListener changeListener2 = this._changeListeners;
            if (changeListener2 == null) {
                changeListener.setNextChangeListener(changeListener);
            } else {
                changeListener.setNextChangeListener(changeListener2);
            }
            this._changeListeners = changeListener;
        }
    }

    @Override // org.apache.xmlbeans.impl.store.Saaj.SaajCallback
    public void setSaajData(Node node, Object obj) {
        if (!$assertionsDisabled && !(node instanceof DomImpl.Dom)) {
            throw new AssertionError();
        }
        DomImpl.saajCallback_setSaajData((DomImpl.Dom) node, obj);
    }

    @Override // org.apache.xmlbeans.impl.common.XmlLocale
    public boolean sync() {
        return !this._noSync;
    }

    public Cur tempCur() {
        return tempCur(null);
    }

    public long version() {
        return this._versionAll;
    }

    public Cur weakCur(Object obj) {
        boolean z = $assertionsDisabled;
        if (!z && (obj == null || (obj instanceof Ref))) {
            throw new AssertionError();
        }
        Cur cur = getCur();
        if (!z && cur._tempFrame != -1) {
            throw new AssertionError();
        }
        if (!z && cur._ref != null) {
            throw new AssertionError();
        }
        cur._ref = new Ref(cur, obj);
        return cur;
    }

    public DomImpl.Dom load(Reader reader) {
        return load(reader, (XmlOptions) null);
    }

    public Cur tempCur(String str) {
        Cur cur = getCur();
        boolean z = $assertionsDisabled;
        if (!z && cur._tempFrame != -1) {
            throw new AssertionError();
        }
        if (!z && this._numTempFramesLeft >= this._tempFrames.length) {
            throw new AssertionError("Temp frame not pushed");
        }
        Cur[] curArr = this._tempFrames;
        int length = (curArr.length - this._numTempFramesLeft) - 1;
        if (!z && (length < 0 || length >= curArr.length)) {
            throw new AssertionError();
        }
        Cur cur2 = curArr[length];
        cur._nextTemp = cur2;
        if (!z && cur._prevTemp != null) {
            throw new AssertionError();
        }
        if (cur2 != null) {
            if (!z && cur2._prevTemp != null) {
                throw new AssertionError();
            }
            cur2._prevTemp = cur;
        }
        curArr[length] = cur;
        cur._tempFrame = length;
        cur._id = str;
        return cur;
    }

    public static final boolean isWhiteSpace(StringBuffer stringBuffer) {
        int length = stringBuffer.length();
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (!CharUtil.isWhiteSpace(stringBuffer.charAt(i))) {
                return false;
            }
            length = i;
        }
    }

    private static void lineNumber(XMLStreamReader xMLStreamReader, LoadContext loadContext) {
        org.apache.poi.javax.xml.stream.Location location = xMLStreamReader.getLocation();
        if (location != null) {
            loadContext.lineNumber(location.getLineNumber(), location.getColumnNumber(), location.getCharacterOffset());
        }
    }

    @Override // org.apache.xmlbeans.impl.common.XmlLocale
    public void enter() {
        if (!$assertionsDisabled && this._numTempFramesLeft < 0) {
            throw new AssertionError();
        }
        int i = this._numTempFramesLeft - 1;
        this._numTempFramesLeft = i;
        if (i <= 0) {
            Cur[] curArr = this._tempFrames;
            int length = curArr.length;
            this._numTempFramesLeft = length;
            Cur[] curArr2 = new Cur[length * 2];
            System.arraycopy(curArr, 0, curArr2, 0, curArr.length);
            this._tempFrames = curArr2;
        }
        int i2 = this._entryCount + 1;
        this._entryCount = i2;
        if (i2 > 1000) {
            pollQueue();
            this._entryCount = 0;
        }
    }

    @Override // org.apache.xmlbeans.impl.common.XmlLocale
    public void exit() {
        int i;
        if (!$assertionsDisabled && ((i = this._numTempFramesLeft) < 0 || i > this._tempFrames.length - 1)) {
            StringBuffer stringBuffer = new StringBuffer(" Temp frames mismanaged. Impossible stack frame. Unsynchronized: ");
            stringBuffer.append(noSync());
            throw new AssertionError(stringBuffer.toString());
        }
        int length = this._tempFrames.length;
        int i2 = this._numTempFramesLeft + 1;
        this._numTempFramesLeft = i2;
        int i4 = length - i2;
        while (true) {
            Cur cur = this._tempFrames[i4];
            if (cur == null) {
                return;
            } else {
                cur.release();
            }
        }
    }

    public DomImpl.Dom load(Reader reader, XmlOptions xmlOptions) {
        return load(new InputSource(reader), xmlOptions);
    }

    public QName makeQName(String str, String str2, String str3) {
        QNameFactory qNameFactory = this._qnameFactory;
        if (str3 == null) {
            str3 = "";
        }
        return qNameFactory.getQName(str, str2, str3);
    }

    public DomImpl.Dom load(InputStream inputStream) {
        return load(inputStream, (XmlOptions) null);
    }

    public DomImpl.Dom load(InputStream inputStream, XmlOptions xmlOptions) {
        return load(new InputSource(inputStream), xmlOptions);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class SaxHandler implements ContentHandler, LexicalHandler, DeclHandler, DTDHandler {
        static final /* synthetic */ boolean $assertionsDisabled;
        protected LoadContext _context;
        private int _entityBytes;
        private int _entityBytesLimit;
        private boolean _insideCDATA;
        private int _insideEntity;
        protected Locale _locale;
        private Locator _startLocator;
        private boolean _wantCdataBookmarks;
        private boolean _wantLineNumbers;
        private boolean _wantLineNumbersAtEndElt;

        static {
            if (Locale.class$org$apache$xmlbeans$impl$store$Locale == null) {
                Locale.class$org$apache$xmlbeans$impl$store$Locale = Locale.class$("org.apache.xmlbeans.impl.store.Locale");
            }
            $assertionsDisabled = true;
        }

        public SaxHandler(Locator locator) {
            this._insideCDATA = false;
            this._entityBytesLimit = 10240;
            this._entityBytes = 0;
            this._insideEntity = 0;
            this._startLocator = locator;
        }

        @Override // org.xml.sax.ext.DeclHandler
        public void attributeDecl(String str, String str2, String str3, String str4, String str5) {
            if (str3.equals("ID")) {
                this._context.addIdAttr(str, str2);
            }
        }

        @Override // org.xml.sax.ContentHandler
        public void characters(char[] cArr, int i, int i2) throws SAXException {
            this._context.text(cArr, i, i2);
            if (this._wantCdataBookmarks && this._insideCDATA) {
                this._context.bookmarkLastNonAttr(CDataBookmark.CDATA_BOOKMARK);
            }
            if (this._insideEntity != 0) {
                int i4 = this._entityBytes + i2;
                this._entityBytes = i4;
                int i5 = this._entityBytesLimit;
                if (i4 > i5) {
                    throw new SAXException(XmlError.forMessage(XmlErrorCodes.EXCEPTION_EXCEEDED_ENTITY_BYTES, new Integer[]{new Integer(i5)}).getMessage());
                }
            }
        }

        @Override // org.xml.sax.ext.LexicalHandler
        public void comment(char[] cArr, int i, int i2) {
            this._context.comment(cArr, i, i2);
        }

        @Override // org.xml.sax.ext.LexicalHandler
        public void endCDATA() {
            this._insideCDATA = false;
        }

        @Override // org.xml.sax.ext.LexicalHandler
        public void endDTD() {
            this._context.endDTD();
        }

        @Override // org.xml.sax.ContentHandler
        public void endElement(String str, String str2, String str3) {
            this._context.endElement();
            if (this._wantLineNumbersAtEndElt) {
                this._context.bookmark(new XmlLineNumber(this._startLocator.getLineNumber(), this._startLocator.getColumnNumber() - 1, -1));
            }
        }

        @Override // org.xml.sax.ext.LexicalHandler
        public void endEntity(String str) {
            int i = this._insideEntity - 1;
            this._insideEntity = i;
            if (!$assertionsDisabled && i < 0) {
                throw new AssertionError();
            }
            if (i == 0) {
                this._entityBytes = 0;
            }
        }

        public void initSaxHandler(Locale locale, XmlOptions xmlOptions) {
            this._locale = locale;
            XmlOptions xmlOptionsMaskNull = XmlOptions.maskNull(xmlOptions);
            this._context = new Cur.CurLoadContext(this._locale, xmlOptionsMaskNull);
            boolean z = false;
            this._wantLineNumbers = this._startLocator != null && xmlOptionsMaskNull.hasOption(XmlOptions.LOAD_LINE_NUMBERS);
            this._wantLineNumbersAtEndElt = this._startLocator != null && xmlOptionsMaskNull.hasOption(XmlOptions.LOAD_LINE_NUMBERS_END_ELEMENT);
            if (this._startLocator != null && xmlOptionsMaskNull.hasOption(XmlOptions.LOAD_SAVE_CDATA_BOOKMARKS)) {
                z = true;
            }
            this._wantCdataBookmarks = z;
            if (xmlOptionsMaskNull.hasOption(XmlOptions.LOAD_ENTITY_BYTES_LIMIT)) {
                this._entityBytesLimit = ((Integer) xmlOptionsMaskNull.get(XmlOptions.LOAD_ENTITY_BYTES_LIMIT)).intValue();
            }
        }

        @Override // org.xml.sax.ContentHandler
        public void processingInstruction(String str, String str2) {
            this._context.procInst(str, str2);
        }

        @Override // org.xml.sax.ext.LexicalHandler
        public void startCDATA() {
            this._insideCDATA = true;
        }

        @Override // org.xml.sax.ext.LexicalHandler
        public void startDTD(String str, String str2, String str3) {
            this._context.startDTD(str, str2, str3);
        }

        @Override // org.xml.sax.ContentHandler
        public void startElement(String str, String str2, String str3, Attributes attributes) {
            str2.length();
            if (str3.indexOf(58) >= 0 && str.length() == 0) {
                StringBuffer stringBuffer = new StringBuffer("Use of undefined namespace prefix: ");
                stringBuffer.append(str3.substring(0, str3.indexOf(58)));
                XmlError xmlErrorForMessage = XmlError.forMessage(stringBuffer.toString());
                throw new XmlRuntimeException(xmlErrorForMessage.toString(), (Throwable) null, xmlErrorForMessage);
            }
            this._context.startElement(this._locale.makeQualifiedQName(str, str3));
            if (this._wantLineNumbers) {
                this._context.bookmark(new XmlLineNumber(this._startLocator.getLineNumber(), this._startLocator.getColumnNumber() - 1, -1));
            }
            int length = attributes.getLength();
            for (int i = 0; i < length; i++) {
                String qName = attributes.getQName(i);
                if (qName.equals(XMLConstants.XMLNS_ATTRIBUTE)) {
                    this._context.xmlns("", attributes.getValue(i));
                } else if (qName.startsWith("xmlns:")) {
                    String strSubstring = qName.substring(6);
                    if (strSubstring.length() == 0) {
                        XmlError xmlErrorForMessage2 = XmlError.forMessage("Prefix not specified", 0);
                        throw new XmlRuntimeException(xmlErrorForMessage2.toString(), (Throwable) null, xmlErrorForMessage2);
                    }
                    String value = attributes.getValue(i);
                    if (value.length() == 0) {
                        XmlError xmlErrorForMessage3 = XmlError.forMessage("Prefix can't be mapped to no namespace: ".concat(strSubstring), 0);
                        throw new XmlRuntimeException(xmlErrorForMessage3.toString(), (Throwable) null, xmlErrorForMessage3);
                    }
                    this._context.xmlns(strSubstring, value);
                } else {
                    int iIndexOf = qName.indexOf(58);
                    if (iIndexOf < 0) {
                        this._context.attr(qName, attributes.getURI(i), null, attributes.getValue(i));
                    } else {
                        this._context.attr(qName.substring(iIndexOf + 1), attributes.getURI(i), qName.substring(0, iIndexOf), attributes.getValue(i));
                    }
                }
            }
        }

        @Override // org.xml.sax.ext.LexicalHandler
        public void startEntity(String str) {
            this._insideEntity++;
        }

        @Override // org.xml.sax.ContentHandler
        public void startPrefixMapping(String str, String str2) {
            if (Locale.beginsWithXml(str)) {
                if ("xml".equals(str) && "http://www.w3.org/XML/1998/namespace".equals(str2)) {
                    return;
                }
                StringBuffer stringBuffer = new StringBuffer("Prefix can't begin with XML: ");
                stringBuffer.append(str);
                XmlError xmlErrorForMessage = XmlError.forMessage(stringBuffer.toString(), 0);
                throw new XmlRuntimeException(xmlErrorForMessage.toString(), (Throwable) null, xmlErrorForMessage);
            }
        }

        public SaxHandler() {
            this(null);
        }

        @Override // org.xml.sax.ContentHandler
        public void endDocument() {
        }

        @Override // org.xml.sax.ContentHandler
        public void startDocument() {
        }

        @Override // org.xml.sax.ContentHandler
        public void endPrefixMapping(String str) {
        }

        @Override // org.xml.sax.ContentHandler
        public void setDocumentLocator(Locator locator) {
        }

        @Override // org.xml.sax.ContentHandler
        public void skippedEntity(String str) {
        }

        @Override // org.xml.sax.ext.DeclHandler
        public void elementDecl(String str, String str2) {
        }

        @Override // org.xml.sax.ext.DeclHandler
        public void internalEntityDecl(String str, String str2) {
        }

        @Override // org.xml.sax.ext.DeclHandler
        public void externalEntityDecl(String str, String str2, String str3) {
        }

        @Override // org.xml.sax.ContentHandler
        public void ignorableWhitespace(char[] cArr, int i, int i2) {
        }

        @Override // org.xml.sax.DTDHandler
        public void notationDecl(String str, String str2, String str3) {
        }

        @Override // org.xml.sax.DTDHandler
        public void unparsedEntityDecl(String str, String str2, String str3, String str4) {
        }
    }

    public DomImpl.Dom load(String str) {
        return load(str, (XmlOptions) null);
    }

    public DomImpl.Dom load(String str, XmlOptions xmlOptions) {
        StringReader stringReader = new StringReader(str);
        try {
            try {
                return load(stringReader, xmlOptions);
            } catch (IOException e) {
                if ($assertionsDisabled) {
                    throw new XmlException(e.getMessage(), e);
                }
                throw new AssertionError("StringReader should not throw IOException");
            }
        } finally {
            try {
                stringReader.close();
            } catch (IOException unused) {
            }
        }
    }

    private XmlObject newInstance(SchemaType schemaType, XmlOptions xmlOptions) {
        XmlOptions xmlOptionsMaskNull = XmlOptions.maskNull(xmlOptions);
        Cur curTempCur = tempCur();
        SchemaType schemaType2 = (SchemaType) xmlOptionsMaskNull.get(XmlOptions.DOCUMENT_TYPE);
        if (schemaType2 == null) {
            if (schemaType == null) {
                schemaType = XmlObject.type;
            }
            schemaType2 = schemaType;
        }
        if (schemaType2.isDocumentType()) {
            curTempCur.createDomDocumentRoot();
        } else {
            curTempCur.createRoot();
        }
        curTempCur.setType(schemaType2);
        XmlObject xmlObject = (XmlObject) curTempCur.getUser();
        curTempCur.release();
        return xmlObject;
    }

    private XmlObject parseToXmlObject(String str, SchemaType schemaType, XmlOptions xmlOptions) {
        Cur cur = parse(str, schemaType, xmlOptions);
        XmlObject xmlObject = (XmlObject) cur.getUser();
        cur.release();
        return xmlObject;
    }

    public XmlSaxHandler newSaxHandler(SchemaType schemaType, XmlOptions xmlOptions) {
        return new XmlSaxHandlerImpl(this, schemaType, xmlOptions);
    }

    public static int getTextValue(Cur cur, int i, char[] cArr, int i2, int i4) {
        if (!$assertionsDisabled && !cur.isNode()) {
            throw new AssertionError();
        }
        String valueAsString = cur._xobj.getValueAsString(i);
        int length = valueAsString.length();
        if (length <= i4) {
            i4 = length;
        }
        if (i4 <= 0) {
            return 0;
        }
        valueAsString.getChars(0, i4, cArr, i2);
        return i4;
    }

    public static boolean toNextSiblingElement(Cur cur, Xobj xobj) {
        Xobj xobj2 = cur._xobj;
        int i = cur._pos;
        int iKind = cur.kind();
        if (iKind == 3) {
            cur.moveTo(xobj);
            cur.next();
        } else if (iKind == 2) {
            cur.skip();
        }
        while (true) {
            int iKind2 = cur.kind();
            if (iKind2 < 0) {
                cur.moveTo(xobj2, i);
                return false;
            }
            if (iKind2 == 2) {
                return true;
            }
            if (iKind2 > 0) {
                cur.toEnd();
            }
            cur.next();
        }
    }

    public static XmlObject parseToXmlObject(SchemaTypeLoader schemaTypeLoader, XMLInputStream xMLInputStream, SchemaType schemaType, XmlOptions xmlOptions) {
        XmlObject toXmlObject;
        Locale locale = getLocale(schemaTypeLoader, xmlOptions);
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale.parseToXmlObject(xMLInputStream, schemaType, xmlOptions);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    toXmlObject = locale.parseToXmlObject(xMLInputStream, schemaType, xmlOptions);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return toXmlObject;
    }

    public XmlObject parseToXmlObject(XMLInputStream xMLInputStream, SchemaType schemaType, XmlOptions xmlOptions) throws Throwable {
        try {
            Cur curLoadXMLInputStream = loadXMLInputStream(xMLInputStream, xmlOptions);
            autoTypeDocument(curLoadXMLInputStream, schemaType, xmlOptions);
            XmlObject xmlObject = (XmlObject) curLoadXMLInputStream.getUser();
            curLoadXMLInputStream.release();
            return xmlObject;
        } catch (XMLStreamException e) {
            throw new XmlException(e.getMessage(), e);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class SaxLoader extends SaxHandler implements ErrorHandler {
        private XMLReader _xr;

        public SaxLoader(XMLReader xMLReader, Locator locator) {
            super(locator);
            this._xr = xMLReader;
            try {
                xMLReader.setFeature(Parser.namespacePrefixesFeature, true);
                this._xr.setFeature(Parser.namespacesFeature, true);
                this._xr.setFeature(Parser.validationFeature, false);
                this._xr.setProperty(Parser.lexicalHandlerProperty, this);
                this._xr.setContentHandler(this);
                this._xr.setProperty("http://xml.org/sax/properties/declaration-handler", this);
                this._xr.setDTDHandler(this);
                this._xr.setErrorHandler(this);
            } catch (Throwable th) {
                throw new RuntimeException(th.getMessage(), th);
            }
        }

        public Cur load(Locale locale, InputSource inputSource, XmlOptions xmlOptions) throws XmlException, IOException {
            inputSource.setSystemId("file://");
            initSaxHandler(locale, xmlOptions);
            try {
                this._xr.parse(inputSource);
                Cur curFinish = this._context.finish();
                Locale.associateSourceName(curFinish, xmlOptions);
                postLoad(curFinish);
                return curFinish;
            } catch (XmlRuntimeException e) {
                this._context.abort();
                throw new XmlException(e);
            } catch (RuntimeException e2) {
                this._context.abort();
                throw e2;
            } catch (SAXParseException e3) {
                this._context.abort();
                XmlError xmlErrorForLocation = XmlError.forLocation(e3.getMessage(), (String) XmlOptions.safeGet(xmlOptions, XmlOptions.DOCUMENT_SOURCE_NAME), e3.getLineNumber(), e3.getColumnNumber(), -1);
                throw new XmlException(xmlErrorForLocation.toString(), e3, xmlErrorForLocation);
            } catch (SAXException e5) {
                this._context.abort();
                XmlError xmlErrorForMessage = XmlError.forMessage(e5.getMessage());
                throw new XmlException(xmlErrorForMessage.toString(), e5, xmlErrorForMessage);
            } catch (FileFormatException e6) {
                this._context.abort();
                throw new XmlException(e6.getMessage(), e6);
            }
        }

        public void postLoad(Cur cur) {
            this._locale = null;
            this._context = null;
        }

        public void setEntityResolver(EntityResolver entityResolver) {
            this._xr.setEntityResolver(entityResolver);
        }

        @Override // org.xml.sax.ErrorHandler
        public void error(SAXParseException sAXParseException) throws SAXParseException {
            throw sAXParseException;
        }

        @Override // org.xml.sax.ErrorHandler
        public void fatalError(SAXParseException sAXParseException) throws SAXParseException {
            throw sAXParseException;
        }

        @Override // org.xml.sax.ErrorHandler
        public void warning(SAXParseException sAXParseException) throws SAXParseException {
            throw sAXParseException;
        }
    }

    public static XmlObject parseToXmlObject(SchemaTypeLoader schemaTypeLoader, XMLStreamReader xMLStreamReader, SchemaType schemaType, XmlOptions xmlOptions) {
        XmlObject toXmlObject;
        Locale locale = getLocale(schemaTypeLoader, xmlOptions);
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale.parseToXmlObject(xMLStreamReader, schemaType, xmlOptions);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    toXmlObject = locale.parseToXmlObject(xMLStreamReader, schemaType, xmlOptions);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return toXmlObject;
    }

    public XmlObject parseToXmlObject(XMLStreamReader xMLStreamReader, SchemaType schemaType, XmlOptions xmlOptions) throws Throwable {
        try {
            Cur curLoadXMLStreamReader = loadXMLStreamReader(xMLStreamReader, xmlOptions);
            autoTypeDocument(curLoadXMLStreamReader, schemaType, xmlOptions);
            XmlObject xmlObject = (XmlObject) curLoadXMLStreamReader.getUser();
            curLoadXMLStreamReader.release();
            return xmlObject;
        } catch (org.apache.poi.javax.xml.stream.XMLStreamException e) {
            throw new XmlException(e.getMessage(), e);
        }
    }

    public static XmlObject parseToXmlObject(SchemaTypeLoader schemaTypeLoader, InputStream inputStream, SchemaType schemaType, XmlOptions xmlOptions) {
        XmlObject toXmlObject;
        Locale locale = getLocale(schemaTypeLoader, xmlOptions);
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale.parseToXmlObject(inputStream, schemaType, xmlOptions);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    toXmlObject = locale.parseToXmlObject(inputStream, schemaType, xmlOptions);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return toXmlObject;
    }

    private XmlObject parseToXmlObject(InputStream inputStream, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException, IOException {
        Cur curLoad = getSaxLoader(xmlOptions).load(this, new InputSource(inputStream), xmlOptions);
        autoTypeDocument(curLoad, schemaType, xmlOptions);
        XmlObject xmlObject = (XmlObject) curLoad.getUser();
        curLoad.release();
        return xmlObject;
    }

    public static XmlObject parseToXmlObject(SchemaTypeLoader schemaTypeLoader, Reader reader, SchemaType schemaType, XmlOptions xmlOptions) {
        XmlObject toXmlObject;
        Locale locale = getLocale(schemaTypeLoader, xmlOptions);
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale.parseToXmlObject(reader, schemaType, xmlOptions);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    toXmlObject = locale.parseToXmlObject(reader, schemaType, xmlOptions);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return toXmlObject;
    }

    private XmlObject parseToXmlObject(Reader reader, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException, IOException {
        Cur curLoad = getSaxLoader(xmlOptions).load(this, new InputSource(reader), xmlOptions);
        autoTypeDocument(curLoad, schemaType, xmlOptions);
        XmlObject xmlObject = (XmlObject) curLoad.getUser();
        curLoad.release();
        return xmlObject;
    }

    public static XmlObject parseToXmlObject(SchemaTypeLoader schemaTypeLoader, Node node, SchemaType schemaType, XmlOptions xmlOptions) {
        XmlObject toXmlObject;
        Locale locale = getLocale(schemaTypeLoader, xmlOptions);
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale.parseToXmlObject(node, schemaType, xmlOptions);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    toXmlObject = locale.parseToXmlObject(node, schemaType, xmlOptions);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return toXmlObject;
    }

    public XmlObject parseToXmlObject(Node node, SchemaType schemaType, XmlOptions xmlOptions) {
        Cur.CurLoadContext curLoadContext = new Cur.CurLoadContext(this, xmlOptions);
        loadNode(node, curLoadContext);
        Cur curFinish = curLoadContext.finish();
        associateSourceName(curFinish, xmlOptions);
        autoTypeDocument(curFinish, schemaType, xmlOptions);
        XmlObject xmlObject = (XmlObject) curFinish.getUser();
        curFinish.release();
        return xmlObject;
    }
}
