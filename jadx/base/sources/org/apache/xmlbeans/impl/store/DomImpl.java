package org.apache.xmlbeans.impl.store;

import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import cz.msebera.android.httpclient.cookie.ClientCookie;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import javax.xml.transform.Source;
import kotlin.collections.AbstractC12991c;
import org.apache.poi.javax.xml.XMLConstants;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlRuntimeException;
import org.apache.xmlbeans.impl.common.XMLChar;
import org.apache.xmlbeans.impl.soap.Detail;
import org.apache.xmlbeans.impl.soap.DetailEntry;
import org.apache.xmlbeans.impl.soap.Name;
import org.apache.xmlbeans.impl.soap.SOAPBody;
import org.apache.xmlbeans.impl.soap.SOAPBodyElement;
import org.apache.xmlbeans.impl.soap.SOAPElement;
import org.apache.xmlbeans.impl.soap.SOAPEnvelope;
import org.apache.xmlbeans.impl.soap.SOAPFault;
import org.apache.xmlbeans.impl.soap.SOAPHeader;
import org.apache.xmlbeans.impl.soap.SOAPHeaderElement;
import org.apache.xmlbeans.impl.soap.SOAPPart;
import org.apache.xmlbeans.impl.soap.Text;
import org.apache.xmlbeans.impl.store.Xobj;
import org.apache.xmlbeans.impl.values.NamespaceManager;
import org.w3c.dom.Attr;
import org.w3c.dom.CDATASection;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Comment;
import org.w3c.dom.DOMException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.EntityReference;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ProcessingInstruction;
import org.w3c.dom.UserDataHandler;
import p258y.AbstractC14516b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
final class DomImpl {
    static final /* synthetic */ boolean $assertionsDisabled;
    static final int ATTR = 2;
    static final int CDATA = 4;
    static final int COMMENT = 8;
    static final int DOCFRAG = 11;
    static final int DOCTYPE = 10;
    static final int DOCUMENT = 9;
    static final int ELEMENT = 1;
    static final int ENTITY = 6;
    static final int ENTITYREF = 5;
    static final int NOTATION = 12;
    static final int PROCINST = 7;
    static final int TEXT = 3;
    public static NodeList _emptyNodeList;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$store$DomImpl;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$store$DomImpl$SaajData;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CdataNode extends TextNode implements CDATASection {
        public CdataNode(Locale locale) {
            super(locale);
        }

        @Override // org.apache.xmlbeans.impl.store.DomImpl.TextNode
        public String name() {
            return "#cdata-section";
        }

        @Override // org.apache.xmlbeans.impl.store.DomImpl.TextNode, org.apache.xmlbeans.impl.store.DomImpl.Dom
        public int nodeType() {
            return 4;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Dom {
        void dump();

        void dump(PrintStream printStream);

        void dump(PrintStream printStream, Object obj);

        QName getQName();

        Locale locale();

        boolean nodeCanHavePrefixUri();

        int nodeType();

        Cur tempCur();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ElementsByTagNameNSNodeList extends ElementsNodeList {
        private String _local;
        private String _uri;

        public ElementsByTagNameNSNodeList(Dom dom, String str, String str2) {
            super(dom);
            this._uri = str == null ? "" : str;
            this._local = str2;
        }

        @Override // org.apache.xmlbeans.impl.store.DomImpl.ElementsNodeList
        public boolean match(Dom dom) {
            if (!this._uri.equals("*") && !DomImpl._node_getNamespaceURI(dom).equals(this._uri)) {
                return false;
            }
            if (this._local.equals("*")) {
                return true;
            }
            return DomImpl._node_getLocalName(dom).equals(this._local);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ElementsByTagNameNodeList extends ElementsNodeList {
        private String _name;

        public ElementsByTagNameNodeList(Dom dom, String str) {
            super(dom);
            this._name = str;
        }

        @Override // org.apache.xmlbeans.impl.store.DomImpl.ElementsNodeList
        public boolean match(Dom dom) {
            if (this._name.equals("*")) {
                return true;
            }
            return DomImpl._node_getNodeName(dom).equals(this._name);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class ElementsNodeList implements NodeList {
        static final /* synthetic */ boolean $assertionsDisabled;
        private ArrayList _elements;
        private Locale _locale;
        private Dom _root;
        private long _version;

        static {
            if (DomImpl.class$org$apache$xmlbeans$impl$store$DomImpl == null) {
                DomImpl.class$org$apache$xmlbeans$impl$store$DomImpl = DomImpl.class$("org.apache.xmlbeans.impl.store.DomImpl");
            }
            $assertionsDisabled = true;
        }

        public ElementsNodeList(Dom dom) {
            if (!$assertionsDisabled && dom.nodeType() != 9 && dom.nodeType() != 1) {
                throw new AssertionError();
            }
            this._root = dom;
            this._locale = dom.locale();
            this._version = 0L;
        }

        private void addElements(Dom dom) {
            for (Dom domFirstChild = DomImpl.firstChild(dom); domFirstChild != null; domFirstChild = DomImpl.nextSibling(domFirstChild)) {
                if (domFirstChild.nodeType() == 1) {
                    if (match(domFirstChild)) {
                        this._elements.add(domFirstChild);
                    }
                    addElements(domFirstChild);
                }
            }
        }

        private void ensureElements() {
            if (this._version == this._locale.version()) {
                return;
            }
            this._version = this._locale.version();
            this._elements = new ArrayList();
            Locale locale = this._locale;
            if (locale.noSync()) {
                locale.enter();
                try {
                    addElements(this._root);
                } finally {
                }
            } else {
                synchronized (locale) {
                    try {
                        locale.enter();
                        try {
                            addElements(this._root);
                        } finally {
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }

        @Override // org.w3c.dom.NodeList
        public int getLength() {
            ensureElements();
            return this._elements.size();
        }

        @Override // org.w3c.dom.NodeList
        public Node item(int i) {
            ensureElements();
            if (i < 0 || i >= this._elements.size()) {
                return null;
            }
            return (Node) this._elements.get(i);
        }

        public abstract boolean match(Dom dom);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class EmptyNodeList implements NodeList {
        private EmptyNodeList() {
        }

        @Override // org.w3c.dom.NodeList
        public int getLength() {
            return 0;
        }

        @Override // org.w3c.dom.NodeList
        public Node item(int i) {
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class HierarchyRequestErr extends DOMException {
        public HierarchyRequestErr() {
            this("This node isn't allowed there");
        }

        public HierarchyRequestErr(String str) {
            super((short) 3, str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class IndexSizeError extends DOMException {
        public IndexSizeError() {
            this("Index Size Error");
        }

        public IndexSizeError(String str) {
            super((short) 1, str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class InuseAttributeError extends DOMException {
        public InuseAttributeError() {
            this("Attribute currently in use error");
        }

        public InuseAttributeError(String str) {
            super((short) 10, str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class InvalidCharacterError extends DOMException {
        public InvalidCharacterError() {
            this("The name contains an invalid character");
        }

        public InvalidCharacterError(String str) {
            super((short) 5, str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class NamespaceErr extends DOMException {
        public NamespaceErr() {
            this("Namespace error");
        }

        public NamespaceErr(String str) {
            super((short) 14, str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class NoModificationAllowedErr extends DOMException {
        public NoModificationAllowedErr() {
            this("No modification allowed error");
        }

        public NoModificationAllowedErr(String str) {
            super((short) 7, str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class NotFoundErr extends DOMException {
        public NotFoundErr() {
            this("Node not found");
        }

        public NotFoundErr(String str) {
            super((short) 8, str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class NotSupportedError extends DOMException {
        public NotSupportedError() {
            this("This operation is not supported");
        }

        public NotSupportedError(String str) {
            super((short) 9, str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SaajCdataNode extends CdataNode implements Text {
        public SaajCdataNode(Locale locale) {
            super(locale);
        }

        public void detachNode() {
            DomImpl._soapNode_detachNode(this);
        }

        public SOAPElement getParentElement() {
            return DomImpl._soapNode_getParentElement(this);
        }

        public String getValue() {
            return DomImpl._soapNode_getValue(this);
        }

        public boolean isComment() {
            return DomImpl._soapText_isComment(this);
        }

        public void recycleNode() {
            DomImpl._soapNode_recycleNode(this);
        }

        public void setParentElement(SOAPElement sOAPElement) {
            DomImpl._soapNode_setParentElement(this, sOAPElement);
        }

        public void setValue(String str) {
            DomImpl._soapNode_setValue(this, str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SaajData {
        Object _obj;

        private SaajData() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SaajTextNode extends TextNode implements Text {
        public SaajTextNode(Locale locale) {
            super(locale);
        }

        public void detachNode() {
            DomImpl._soapNode_detachNode(this);
        }

        public SOAPElement getParentElement() {
            return DomImpl._soapNode_getParentElement(this);
        }

        public String getValue() {
            return DomImpl._soapNode_getValue(this);
        }

        public boolean isComment() {
            return DomImpl._soapText_isComment(this);
        }

        public void recycleNode() {
            DomImpl._soapNode_recycleNode(this);
        }

        public void setParentElement(SOAPElement sOAPElement) {
            DomImpl._soapNode_setParentElement(this, sOAPElement);
        }

        public void setValue(String str) {
            DomImpl._soapNode_setValue(this, str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class TextNode extends CharNode implements org.w3c.dom.Text {
        public TextNode(Locale locale) {
            super(locale);
        }

        @Override // org.w3c.dom.Text
        public String getWholeText() {
            return DomImpl._text_getWholeText(this);
        }

        @Override // org.w3c.dom.Text
        public boolean isElementContentWhitespace() {
            return DomImpl._text_isElementContentWhitespace(this);
        }

        public String name() {
            return "#text";
        }

        @Override // org.apache.xmlbeans.impl.store.DomImpl.Dom
        public int nodeType() {
            return 3;
        }

        @Override // org.w3c.dom.Text
        public org.w3c.dom.Text replaceWholeText(String str) {
            return DomImpl._text_replaceWholeText(this, str);
        }

        @Override // org.w3c.dom.Text
        public org.w3c.dom.Text splitText(int i) {
            return DomImpl._text_splitText(this, i);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class WrongDocumentErr extends DOMException {
        public WrongDocumentErr() {
            this("Nodes do not belong to the same document");
        }

        public WrongDocumentErr(String str) {
            super((short) 4, str);
        }
    }

    static {
        if (class$org$apache$xmlbeans$impl$store$DomImpl == null) {
            class$org$apache$xmlbeans$impl$store$DomImpl = class$("org.apache.xmlbeans.impl.store.DomImpl");
        }
        $assertionsDisabled = true;
        _emptyNodeList = new EmptyNodeList();
    }

    public static Element _attr_getOwnerElement(Dom dom) {
        Dom domAttr_getOwnerElement;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                domAttr_getOwnerElement = attr_getOwnerElement(dom);
            } finally {
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    domAttr_getOwnerElement = attr_getOwnerElement(dom);
                    locale.exit();
                } finally {
                }
            }
        }
        return (Element) domAttr_getOwnerElement;
    }

    public static boolean _attr_getSpecified(Dom dom) {
        return true;
    }

    public static int _attributes_getLength(Dom dom) {
        int iAttributes_getLength;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                return attributes_getLength(dom);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    iAttributes_getLength = attributes_getLength(dom);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return iAttributes_getLength;
    }

    public static Node _attributes_getNamedItem(Dom dom, String str) {
        Dom domAttributes_getNamedItem;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                domAttributes_getNamedItem = attributes_getNamedItem(dom, str);
            } finally {
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    domAttributes_getNamedItem = attributes_getNamedItem(dom, str);
                    locale.exit();
                } finally {
                }
            }
        }
        return (Node) domAttributes_getNamedItem;
    }

    public static Node _attributes_getNamedItemNS(Dom dom, String str, String str2) {
        Dom domAttributes_getNamedItemNS;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                domAttributes_getNamedItemNS = attributes_getNamedItemNS(dom, str, str2);
            } finally {
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    domAttributes_getNamedItemNS = attributes_getNamedItemNS(dom, str, str2);
                    locale.exit();
                } finally {
                }
            }
        }
        return (Node) domAttributes_getNamedItemNS;
    }

    public static Node _attributes_item(Dom dom, int i) {
        Dom domAttributes_item;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                domAttributes_item = attributes_item(dom, i);
            } finally {
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    domAttributes_item = attributes_item(dom, i);
                    locale.exit();
                } finally {
                }
            }
        }
        return (Node) domAttributes_item;
    }

    public static Node _attributes_removeNamedItem(Dom dom, String str) {
        Dom domAttributes_removeNamedItem;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                domAttributes_removeNamedItem = attributes_removeNamedItem(dom, str);
            } finally {
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    domAttributes_removeNamedItem = attributes_removeNamedItem(dom, str);
                    locale.exit();
                } finally {
                }
            }
        }
        return (Node) domAttributes_removeNamedItem;
    }

    public static Node _attributes_removeNamedItemNS(Dom dom, String str, String str2) {
        Dom domAttributes_removeNamedItemNS;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                domAttributes_removeNamedItemNS = attributes_removeNamedItemNS(dom, str, str2);
            } finally {
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    domAttributes_removeNamedItemNS = attributes_removeNamedItemNS(dom, str, str2);
                    locale.exit();
                } finally {
                }
            }
        }
        return (Node) domAttributes_removeNamedItemNS;
    }

    public static Node _attributes_setNamedItem(Dom dom, Node node) {
        Dom domAttributes_setNamedItem;
        Locale locale = dom.locale();
        if (node == null) {
            throw new IllegalArgumentException("Attr to set is null");
        }
        if (node instanceof Dom) {
            Dom dom2 = (Dom) node;
            if (dom2.locale() == locale) {
                if (locale.noSync()) {
                    locale.enter();
                    try {
                        domAttributes_setNamedItem = attributes_setNamedItem(dom, dom2);
                    } finally {
                    }
                } else {
                    synchronized (locale) {
                        locale.enter();
                        try {
                            domAttributes_setNamedItem = attributes_setNamedItem(dom, dom2);
                            locale.exit();
                        } finally {
                        }
                    }
                }
                return (Node) domAttributes_setNamedItem;
            }
        }
        throw new WrongDocumentErr("Attr to set is from another document");
    }

    public static Node _attributes_setNamedItemNS(Dom dom, Node node) {
        Dom domAttributes_setNamedItemNS;
        Locale locale = dom.locale();
        if (node == null) {
            throw new IllegalArgumentException("Attr to set is null");
        }
        if (node instanceof Dom) {
            Dom dom2 = (Dom) node;
            if (dom2.locale() == locale) {
                if (locale.noSync()) {
                    locale.enter();
                    try {
                        domAttributes_setNamedItemNS = attributes_setNamedItemNS(dom, dom2);
                    } finally {
                    }
                } else {
                    synchronized (locale) {
                        locale.enter();
                        try {
                            domAttributes_setNamedItemNS = attributes_setNamedItemNS(dom, dom2);
                            locale.exit();
                        } finally {
                        }
                    }
                }
                return (Node) domAttributes_setNamedItemNS;
            }
        }
        throw new WrongDocumentErr("Attr to set is from another document");
    }

    public static void _characterData_appendData(Dom dom, String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        _node_setNodeValue(dom, AbstractC8014b.m7199a(new StringBuffer(), _node_getNodeValue(dom), str));
    }

    public static void _characterData_deleteData(Dom dom, int i, int i2) {
        String str_characterData_getData = _characterData_getData(dom);
        if (i < 0 || i > str_characterData_getData.length() || i2 < 0) {
            throw new IndexSizeError();
        }
        if (i + i2 > str_characterData_getData.length()) {
            i2 = str_characterData_getData.length() - i;
        }
        if (i2 > 0) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str_characterData_getData.substring(0, i));
            stringBuffer.append(str_characterData_getData.substring(i + i2));
            _characterData_setData(dom, stringBuffer.toString());
        }
    }

    public static String _characterData_getData(Dom dom) {
        return _node_getNodeValue(dom);
    }

    public static int _characterData_getLength(Dom dom) {
        return _characterData_getData(dom).length();
    }

    public static void _characterData_insertData(Dom dom, int i, String str) {
        String str_characterData_getData = _characterData_getData(dom);
        if (i < 0 || i > str_characterData_getData.length()) {
            throw new IndexSizeError();
        }
        if (str == null || str.length() <= 0) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str_characterData_getData.substring(0, i));
        stringBuffer.append(str);
        stringBuffer.append(str_characterData_getData.substring(i));
        _characterData_setData(dom, stringBuffer.toString());
    }

    public static void _characterData_replaceData(Dom dom, int i, int i2, String str) {
        String str_characterData_getData = _characterData_getData(dom);
        if (i < 0 || i > str_characterData_getData.length() || i2 < 0) {
            throw new IndexSizeError();
        }
        if (i + i2 > str_characterData_getData.length()) {
            i2 = str_characterData_getData.length() - i;
        }
        if (i2 > 0) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str_characterData_getData.substring(0, i));
            if (str == null) {
                str = "";
            }
            stringBuffer.append(str);
            stringBuffer.append(str_characterData_getData.substring(i + i2));
            _characterData_setData(dom, stringBuffer.toString());
        }
    }

    public static void _characterData_setData(Dom dom, String str) {
        _node_setNodeValue(dom, str);
    }

    public static String _characterData_substringData(Dom dom, int i, int i2) {
        String str_characterData_getData = _characterData_getData(dom);
        if (i < 0 || i > str_characterData_getData.length() || i2 < 0) {
            throw new IndexSizeError();
        }
        if (i + i2 > str_characterData_getData.length()) {
            i2 = str_characterData_getData.length() - i;
        }
        return str_characterData_getData.substring(i, i2 + i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int _childNodes_getLength(Dom dom) {
        int iChildNodes_getLength;
        int domZeroOneChildren;
        Locale locale = dom.locale();
        if (!$assertionsDisabled && !(dom instanceof Xobj)) {
            throw new AssertionError();
        }
        Xobj xobj = (Xobj) dom;
        if (!xobj.isVacant() && (domZeroOneChildren = xobj.getDomZeroOneChildren()) < 2) {
            return domZeroOneChildren;
        }
        if (locale.noSync()) {
            return childNodes_getLength(dom);
        }
        synchronized (locale) {
            iChildNodes_getLength = childNodes_getLength(dom);
        }
        return iChildNodes_getLength;
    }

    public static Node _childNodes_item(Dom dom, int i) {
        Dom domChildNodes_item;
        Locale locale = dom.locale();
        if (i == 0) {
            return _node_getFirstChild(dom);
        }
        if (locale.noSync()) {
            domChildNodes_item = childNodes_item(dom, i);
        } else {
            synchronized (locale) {
                domChildNodes_item = childNodes_item(dom, i);
            }
        }
        return (Node) domChildNodes_item;
    }

    public static Attr _document_createAttribute(Dom dom, String str) {
        Dom domDocument_createAttribute;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                domDocument_createAttribute = document_createAttribute(dom, str);
            } finally {
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    domDocument_createAttribute = document_createAttribute(dom, str);
                    locale.exit();
                } finally {
                }
            }
        }
        return (Attr) domDocument_createAttribute;
    }

    public static Attr _document_createAttributeNS(Dom dom, String str, String str2) {
        Dom domDocument_createAttributeNS;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                domDocument_createAttributeNS = document_createAttributeNS(dom, str, str2);
            } finally {
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    domDocument_createAttributeNS = document_createAttributeNS(dom, str, str2);
                    locale.exit();
                } finally {
                }
            }
        }
        return (Attr) domDocument_createAttributeNS;
    }

    public static CDATASection _document_createCDATASection(Dom dom, String str) {
        return (CDATASection) document_createCDATASection(dom, str);
    }

    public static Comment _document_createComment(Dom dom, String str) {
        Dom domDocument_createComment;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                domDocument_createComment = document_createComment(dom, str);
            } finally {
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    domDocument_createComment = document_createComment(dom, str);
                    locale.exit();
                } finally {
                }
            }
        }
        return (Comment) domDocument_createComment;
    }

    public static DocumentFragment _document_createDocumentFragment(Dom dom) {
        Dom domDocument_createDocumentFragment;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                domDocument_createDocumentFragment = document_createDocumentFragment(dom);
            } finally {
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    domDocument_createDocumentFragment = document_createDocumentFragment(dom);
                    locale.exit();
                } finally {
                }
            }
        }
        return (DocumentFragment) domDocument_createDocumentFragment;
    }

    public static Element _document_createElement(Dom dom, String str) {
        Dom domDocument_createElement;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                domDocument_createElement = document_createElement(dom, str);
            } finally {
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    domDocument_createElement = document_createElement(dom, str);
                    locale.exit();
                } finally {
                }
            }
        }
        return (Element) domDocument_createElement;
    }

    public static Element _document_createElementNS(Dom dom, String str, String str2) {
        Dom domDocument_createElementNS;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                domDocument_createElementNS = document_createElementNS(dom, str, str2);
            } finally {
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    domDocument_createElementNS = document_createElementNS(dom, str, str2);
                    locale.exit();
                } finally {
                }
            }
        }
        return (Element) domDocument_createElementNS;
    }

    public static EntityReference _document_createEntityReference(Dom dom, String str) {
        throw new RuntimeException("Not implemented");
    }

    public static ProcessingInstruction _document_createProcessingInstruction(Dom dom, String str, String str2) {
        Dom domDocument_createProcessingInstruction;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                domDocument_createProcessingInstruction = document_createProcessingInstruction(dom, str, str2);
            } finally {
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    domDocument_createProcessingInstruction = document_createProcessingInstruction(dom, str, str2);
                    locale.exit();
                } finally {
                }
            }
        }
        return (ProcessingInstruction) domDocument_createProcessingInstruction;
    }

    public static org.w3c.dom.Text _document_createTextNode(Dom dom, String str) {
        return (org.w3c.dom.Text) document_createTextNode(dom, str);
    }

    public static DocumentType _document_getDoctype(Dom dom) {
        Dom domDocument_getDoctype;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                domDocument_getDoctype = document_getDoctype(dom);
            } finally {
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    domDocument_getDoctype = document_getDoctype(dom);
                    locale.exit();
                } finally {
                }
            }
        }
        return (DocumentType) domDocument_getDoctype;
    }

    public static Element _document_getDocumentElement(Dom dom) {
        Dom domDocument_getDocumentElement;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                domDocument_getDocumentElement = document_getDocumentElement(dom);
            } finally {
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    domDocument_getDocumentElement = document_getDocumentElement(dom);
                    locale.exit();
                } finally {
                }
            }
        }
        return (Element) domDocument_getDocumentElement;
    }

    public static Element _document_getElementById(Dom dom, String str) {
        throw new RuntimeException("Not implemented");
    }

    public static NodeList _document_getElementsByTagName(Dom dom, String str) {
        NodeList nodeListDocument_getElementsByTagName;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                return document_getElementsByTagName(dom, str);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    nodeListDocument_getElementsByTagName = document_getElementsByTagName(dom, str);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return nodeListDocument_getElementsByTagName;
    }

    public static NodeList _document_getElementsByTagNameNS(Dom dom, String str, String str2) {
        NodeList nodeListDocument_getElementsByTagNameNS;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                return document_getElementsByTagNameNS(dom, str, str2);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    nodeListDocument_getElementsByTagNameNS = document_getElementsByTagNameNS(dom, str, str2);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return nodeListDocument_getElementsByTagNameNS;
    }

    public static DOMImplementation _document_getImplementation(Dom dom) {
        return dom.locale();
    }

    public static Node _document_importNode(Dom dom, Node node, boolean z) {
        Dom domDocument_importNode;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                domDocument_importNode = document_importNode(dom, node, z);
            } finally {
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    domDocument_importNode = document_importNode(dom, node, z);
                    locale.exit();
                } finally {
                }
            }
        }
        return (Node) domDocument_importNode;
    }

    public static Document _domImplementation_createDocument(Locale locale, String str, String str2, DocumentType documentType) {
        Document documentDomImplementation_createDocument;
        if (locale.noSync()) {
            locale.enter();
            try {
                return domImplementation_createDocument(locale, str, str2, documentType);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    documentDomImplementation_createDocument = domImplementation_createDocument(locale, str, str2, documentType);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return documentDomImplementation_createDocument;
    }

    public static boolean _domImplementation_hasFeature(Locale locale, String str, String str2) {
        if (str == null) {
            return false;
        }
        if (str2 == null || str2.length() <= 0 || str2.equals("1.0") || str2.equals("2.0")) {
            return str.equalsIgnoreCase("core") || str.equalsIgnoreCase("xml");
        }
        return false;
    }

    public static String _element_getAttribute(Dom dom, String str) {
        Node node_attributes_getNamedItem = _attributes_getNamedItem(dom, str);
        return node_attributes_getNamedItem == null ? "" : node_attributes_getNamedItem.getNodeValue();
    }

    public static String _element_getAttributeNS(Dom dom, String str, String str2) {
        Node node_attributes_getNamedItemNS = _attributes_getNamedItemNS(dom, str, str2);
        return node_attributes_getNamedItemNS == null ? "" : node_attributes_getNamedItemNS.getNodeValue();
    }

    public static Attr _element_getAttributeNode(Dom dom, String str) {
        return (Attr) _attributes_getNamedItem(dom, str);
    }

    public static Attr _element_getAttributeNodeNS(Dom dom, String str, String str2) {
        return (Attr) _attributes_getNamedItemNS(dom, str, str2);
    }

    public static NodeList _element_getElementsByTagName(Dom dom, String str) {
        NodeList nodeListElement_getElementsByTagName;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                return element_getElementsByTagName(dom, str);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    nodeListElement_getElementsByTagName = element_getElementsByTagName(dom, str);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return nodeListElement_getElementsByTagName;
    }

    public static NodeList _element_getElementsByTagNameNS(Dom dom, String str, String str2) {
        NodeList nodeListElement_getElementsByTagNameNS;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                return element_getElementsByTagNameNS(dom, str, str2);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    nodeListElement_getElementsByTagNameNS = element_getElementsByTagNameNS(dom, str, str2);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return nodeListElement_getElementsByTagNameNS;
    }

    public static String _element_getTagName(Dom dom) {
        return _node_getNodeName(dom);
    }

    public static boolean _element_hasAttribute(Dom dom, String str) {
        return _attributes_getNamedItem(dom, str) != null;
    }

    public static boolean _element_hasAttributeNS(Dom dom, String str, String str2) {
        return _attributes_getNamedItemNS(dom, str, str2) != null;
    }

    public static void _element_removeAttribute(Dom dom, String str) {
        try {
            _attributes_removeNamedItem(dom, str);
        } catch (NotFoundErr unused) {
        }
    }

    public static void _element_removeAttributeNS(Dom dom, String str, String str2) {
        try {
            _attributes_removeNamedItemNS(dom, str, str2);
        } catch (NotFoundErr unused) {
        }
    }

    public static Attr _element_removeAttributeNode(Dom dom, Attr attr) {
        if (attr == null) {
            throw new NotFoundErr("Attribute to remove is null");
        }
        if (attr.getOwnerElement() == dom) {
            return (Attr) _attributes_removeNamedItem(dom, attr.getNodeName());
        }
        throw new NotFoundErr("Attribute to remove does not belong to this element");
    }

    public static void _element_setAttribute(Dom dom, String str, String str2) {
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                element_setAttribute(dom, str, str2);
            } finally {
            }
        } else {
            synchronized (locale) {
                try {
                    locale.enter();
                    try {
                        element_setAttribute(dom, str, str2);
                    } finally {
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static void _element_setAttributeNS(Dom dom, String str, String str2, String str3) {
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                element_setAttributeNS(dom, str, str2, str3);
            } finally {
            }
        } else {
            synchronized (locale) {
                try {
                    locale.enter();
                    try {
                        element_setAttributeNS(dom, str, str2, str3);
                    } finally {
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static Attr _element_setAttributeNode(Dom dom, Attr attr) {
        return (Attr) _attributes_setNamedItem(dom, attr);
    }

    public static Attr _element_setAttributeNodeNS(Dom dom, Attr attr) {
        return (Attr) _attributes_setNamedItemNS(dom, attr);
    }

    public static XmlCursor _getXmlCursor(Dom dom) {
        XmlCursor xmlCursor;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                return getXmlCursor(dom);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    xmlCursor = getXmlCursor(dom);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return xmlCursor;
    }

    public static XmlObject _getXmlObject(Dom dom) {
        XmlObject xmlObject;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                return getXmlObject(dom);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    xmlObject = getXmlObject(dom);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return xmlObject;
    }

    public static XMLStreamReader _getXmlStreamReader(Dom dom) {
        XMLStreamReader xmlStreamReader;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                return getXmlStreamReader(dom);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    xmlStreamReader = getXmlStreamReader(dom);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return xmlStreamReader;
    }

    public static Node _node_appendChild(Dom dom, Node node) {
        return _node_insertBefore(dom, node, null);
    }

    public static Node _node_cloneNode(Dom dom, boolean z) {
        Dom domNode_cloneNode;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                domNode_cloneNode = node_cloneNode(dom, z);
            } finally {
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    domNode_cloneNode = node_cloneNode(dom, z);
                    locale.exit();
                } finally {
                }
            }
        }
        return (Node) domNode_cloneNode;
    }

    public static short _node_compareDocumentPosition(Dom dom, Node node) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    public static String _node_getBaseURI(Dom dom) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    public static Object _node_getFeature(Dom dom, String str, String str2) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Node _node_getFirstChild(Dom dom) {
        Dom domNode_getFirstChild;
        Locale locale = dom.locale();
        if (!$assertionsDisabled && !(dom instanceof Xobj)) {
            throw new AssertionError();
        }
        Xobj xobj = (Xobj) dom;
        if (!xobj.isVacant()) {
            if (xobj.isFirstChildPtrDomUsable()) {
                return (Node) xobj._firstChild;
            }
            Xobj xobjLastAttr = xobj.lastAttr();
            if (xobjLastAttr != null && xobjLastAttr.isNextSiblingPtrDomUsable()) {
                return (Xobj.NodeXobj) xobjLastAttr._nextSibling;
            }
            if (xobj.isExistingCharNodesValueUsable()) {
                return xobj._charNodesValue;
            }
        }
        if (locale.noSync()) {
            domNode_getFirstChild = node_getFirstChild(dom);
        } else {
            synchronized (locale) {
                domNode_getFirstChild = node_getFirstChild(dom);
            }
        }
        return (Node) domNode_getFirstChild;
    }

    public static Node _node_getLastChild(Dom dom) {
        Dom domNode_getLastChild;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                domNode_getLastChild = node_getLastChild(dom);
            } finally {
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    domNode_getLastChild = node_getLastChild(dom);
                    locale.exit();
                } finally {
                }
            }
        }
        return (Node) domNode_getLastChild;
    }

    public static String _node_getLocalName(Dom dom) {
        if (!dom.nodeCanHavePrefixUri()) {
            return null;
        }
        QName qName = dom.getQName();
        return qName == null ? "" : qName.getLocalPart();
    }

    public static String _node_getNamespaceURI(Dom dom) {
        if (!dom.nodeCanHavePrefixUri()) {
            return null;
        }
        QName qName = dom.getQName();
        return qName == null ? "" : qName.getNamespaceURI();
    }

    public static Node _node_getNextSibling(Dom dom) {
        Dom domNode_getNextSibling;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            domNode_getNextSibling = node_getNextSibling(dom);
        } else {
            synchronized (locale) {
                domNode_getNextSibling = node_getNextSibling(dom);
            }
        }
        return (Node) domNode_getNextSibling;
    }

    public static String _node_getNodeName(Dom dom) {
        switch (dom.nodeType()) {
            case 1:
            case 2:
                QName qName = dom.getQName();
                String prefix = qName.getPrefix();
                if (prefix.length() == 0) {
                    return qName.getLocalPart();
                }
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(prefix);
                stringBuffer.append(":");
                stringBuffer.append(qName.getLocalPart());
                return stringBuffer.toString();
            case 3:
                return "#text";
            case 4:
                return "#cdata-section";
            case 5:
            case 6:
            case 10:
            case 12:
                throw new RuntimeException("Not impl");
            case 7:
                return dom.getQName().getLocalPart();
            case 8:
                return "#comment";
            case 9:
                return "#document";
            case 11:
                return "#document-fragment";
            default:
                throw new RuntimeException("Unknown node type");
        }
    }

    public static short _node_getNodeType(Dom dom) {
        return (short) dom.nodeType();
    }

    public static String _node_getNodeValue(Dom dom) {
        String strNode_getNodeValue;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            return node_getNodeValue(dom);
        }
        synchronized (locale) {
            strNode_getNodeValue = node_getNodeValue(dom);
        }
        return strNode_getNodeValue;
    }

    public static Document _node_getOwnerDocument(Dom dom) {
        Dom domNode_getOwnerDocument;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                domNode_getOwnerDocument = node_getOwnerDocument(dom);
            } finally {
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    domNode_getOwnerDocument = node_getOwnerDocument(dom);
                    locale.exit();
                } finally {
                }
            }
        }
        return (Document) domNode_getOwnerDocument;
    }

    public static Node _node_getParentNode(Dom dom) {
        Dom domNode_getParentNode;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                domNode_getParentNode = node_getParentNode(dom);
            } finally {
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    domNode_getParentNode = node_getParentNode(dom);
                    locale.exit();
                } finally {
                }
            }
        }
        return (Node) domNode_getParentNode;
    }

    public static String _node_getPrefix(Dom dom) {
        if (!dom.nodeCanHavePrefixUri()) {
            return null;
        }
        QName qName = dom.getQName();
        return qName == null ? "" : qName.getPrefix();
    }

    public static Node _node_getPreviousSibling(Dom dom) {
        Dom domNode_getPreviousSibling;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            domNode_getPreviousSibling = node_getPreviousSibling(dom);
        } else {
            synchronized (locale) {
                domNode_getPreviousSibling = node_getPreviousSibling(dom);
            }
        }
        return (Node) domNode_getPreviousSibling;
    }

    public static String _node_getTextContent(Dom dom) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    public static Object _node_getUserData(Dom dom, String str) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    public static boolean _node_hasAttributes(Dom dom) {
        boolean zNode_hasAttributes;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                return node_hasAttributes(dom);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    zNode_hasAttributes = node_hasAttributes(dom);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zNode_hasAttributes;
    }

    public static boolean _node_hasChildNodes(Dom dom) {
        return _node_getFirstChild(dom) != null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001e, code lost:
    
        if (r4.locale() == r0) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Node _node_insertBefore(Dom dom, Node node, Node node2) {
        Dom dom2;
        Dom domNode_insertBefore;
        Locale locale = dom.locale();
        if (node == null) {
            throw new IllegalArgumentException("Child to add is null");
        }
        if (node instanceof Dom) {
            Dom dom3 = (Dom) node;
            if (dom3.locale() == locale) {
                if (node2 != null) {
                    if (node2 instanceof Dom) {
                        dom2 = (Dom) node2;
                    }
                    throw new WrongDocumentErr("Reference child is from another document");
                }
                dom2 = null;
                if (locale.noSync()) {
                    locale.enter();
                    try {
                        domNode_insertBefore = node_insertBefore(dom, dom3, dom2);
                    } finally {
                    }
                } else {
                    synchronized (locale) {
                        locale.enter();
                        try {
                            domNode_insertBefore = node_insertBefore(dom, dom3, dom2);
                            locale.exit();
                        } finally {
                        }
                    }
                }
                return (Node) domNode_insertBefore;
            }
        }
        throw new WrongDocumentErr("Child to add is from another document");
    }

    public static boolean _node_isDefaultNamespace(Dom dom, String str) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    public static boolean _node_isEqualNode(Dom dom, Node node) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    public static boolean _node_isSameNode(Dom dom, Node node) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    public static boolean _node_isSupported(Dom dom, String str, String str2) {
        return _domImplementation_hasFeature(dom.locale(), str, str2);
    }

    public static String _node_lookupNamespaceURI(Dom dom, String str) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    public static String _node_lookupPrefix(Dom dom, String str) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    public static void _node_normalize(Dom dom) {
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                node_normalize(dom);
            } finally {
            }
        } else {
            synchronized (locale) {
                try {
                    locale.enter();
                    try {
                        node_normalize(dom);
                    } finally {
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static Node _node_removeChild(Dom dom, Node node) {
        Dom domNode_removeChild;
        Locale locale = dom.locale();
        if (node == null) {
            throw new NotFoundErr("Child to remove is null");
        }
        if (node instanceof Dom) {
            Dom dom2 = (Dom) node;
            if (dom2.locale() == locale) {
                if (locale.noSync()) {
                    locale.enter();
                    try {
                        domNode_removeChild = node_removeChild(dom, dom2);
                    } finally {
                    }
                } else {
                    synchronized (locale) {
                        locale.enter();
                        try {
                            domNode_removeChild = node_removeChild(dom, dom2);
                            locale.exit();
                        } finally {
                        }
                    }
                }
                return (Node) domNode_removeChild;
            }
        }
        throw new WrongDocumentErr("Child to remove is from another document");
    }

    public static Node _node_replaceChild(Dom dom, Node node, Node node2) {
        Dom domNode_replaceChild;
        Locale locale = dom.locale();
        if (node == null) {
            throw new IllegalArgumentException("Child to add is null");
        }
        if (node2 == null) {
            throw new NotFoundErr("Child to replace is null");
        }
        if (node instanceof Dom) {
            Dom dom2 = (Dom) node;
            if (dom2.locale() == locale) {
                if (node2 instanceof Dom) {
                    Dom dom3 = (Dom) node2;
                    if (dom3.locale() == locale) {
                        if (locale.noSync()) {
                            locale.enter();
                            try {
                                domNode_replaceChild = node_replaceChild(dom, dom2, dom3);
                            } finally {
                            }
                        } else {
                            synchronized (locale) {
                                locale.enter();
                                try {
                                    domNode_replaceChild = node_replaceChild(dom, dom2, dom3);
                                    locale.exit();
                                } finally {
                                }
                            }
                        }
                        return (Node) domNode_replaceChild;
                    }
                }
                throw new WrongDocumentErr("Child to replace is from another document");
            }
        }
        throw new WrongDocumentErr("Child to add is from another document");
    }

    public static void _node_setNodeValue(Dom dom, String str) {
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                node_setNodeValue(dom, str);
            } finally {
            }
        } else {
            synchronized (locale) {
                try {
                    locale.enter();
                    try {
                        node_setNodeValue(dom, str);
                    } finally {
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static void _node_setPrefix(Dom dom, String str) {
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                node_setPrefix(dom, str);
            } finally {
            }
        } else {
            synchronized (locale) {
                try {
                    locale.enter();
                    try {
                        node_setPrefix(dom, str);
                    } finally {
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static void _node_setTextContent(Dom dom, String str) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    public static Object _node_setUserData(Dom dom, String str, Object obj, UserDataHandler userDataHandler) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    public static String _processingInstruction_getData(Dom dom) {
        return _node_getNodeValue(dom);
    }

    public static String _processingInstruction_getTarget(Dom dom) {
        return _node_getNodeName(dom);
    }

    public static void _processingInstruction_setData(Dom dom, String str) {
        _node_setNodeValue(dom, str);
    }

    public static SOAPElement _soapElement_addAttribute(Dom dom, Name name, String str) {
        SOAPElement sOAPElementSoapElement_addAttribute;
        Locale locale = dom.locale();
        SOAPElement sOAPElement = (SOAPElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapElement_addAttribute(sOAPElement, name, str);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    sOAPElementSoapElement_addAttribute = locale._saaj.soapElement_addAttribute(sOAPElement, name, str);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sOAPElementSoapElement_addAttribute;
    }

    public static SOAPElement _soapElement_addChildElement(Dom dom, SOAPElement sOAPElement) {
        SOAPElement sOAPElementSoapElement_addChildElement;
        Locale locale = dom.locale();
        SOAPElement sOAPElement2 = (SOAPElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapElement_addChildElement(sOAPElement2, sOAPElement);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    sOAPElementSoapElement_addChildElement = locale._saaj.soapElement_addChildElement(sOAPElement2, sOAPElement);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sOAPElementSoapElement_addChildElement;
    }

    public static SOAPElement _soapElement_addNamespaceDeclaration(Dom dom, String str, String str2) {
        SOAPElement sOAPElementSoapElement_addNamespaceDeclaration;
        Locale locale = dom.locale();
        SOAPElement sOAPElement = (SOAPElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapElement_addNamespaceDeclaration(sOAPElement, str, str2);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    sOAPElementSoapElement_addNamespaceDeclaration = locale._saaj.soapElement_addNamespaceDeclaration(sOAPElement, str, str2);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sOAPElementSoapElement_addNamespaceDeclaration;
    }

    public static SOAPElement _soapElement_addTextNode(Dom dom, String str) {
        SOAPElement sOAPElementSoapElement_addTextNode;
        Locale locale = dom.locale();
        SOAPElement sOAPElement = (SOAPElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapElement_addTextNode(sOAPElement, str);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    sOAPElementSoapElement_addTextNode = locale._saaj.soapElement_addTextNode(sOAPElement, str);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sOAPElementSoapElement_addTextNode;
    }

    public static Iterator _soapElement_getAllAttributes(Dom dom) {
        Iterator itSoapElement_getAllAttributes;
        Locale locale = dom.locale();
        SOAPElement sOAPElement = (SOAPElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapElement_getAllAttributes(sOAPElement);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    itSoapElement_getAllAttributes = locale._saaj.soapElement_getAllAttributes(sOAPElement);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return itSoapElement_getAllAttributes;
    }

    public static String _soapElement_getAttributeValue(Dom dom, Name name) {
        String strSoapElement_getAttributeValue;
        Locale locale = dom.locale();
        SOAPElement sOAPElement = (SOAPElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapElement_getAttributeValue(sOAPElement, name);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    strSoapElement_getAttributeValue = locale._saaj.soapElement_getAttributeValue(sOAPElement, name);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return strSoapElement_getAttributeValue;
    }

    public static Iterator _soapElement_getChildElements(Dom dom) {
        Iterator itSoapElement_getChildElements;
        Locale locale = dom.locale();
        SOAPElement sOAPElement = (SOAPElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapElement_getChildElements(sOAPElement);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    itSoapElement_getChildElements = locale._saaj.soapElement_getChildElements(sOAPElement);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return itSoapElement_getChildElements;
    }

    public static Name _soapElement_getElementName(Dom dom) {
        Name nameSoapElement_getElementName;
        Locale locale = dom.locale();
        SOAPElement sOAPElement = (SOAPElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapElement_getElementName(sOAPElement);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    nameSoapElement_getElementName = locale._saaj.soapElement_getElementName(sOAPElement);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return nameSoapElement_getElementName;
    }

    public static String _soapElement_getEncodingStyle(Dom dom) {
        String strSoapElement_getEncodingStyle;
        Locale locale = dom.locale();
        SOAPElement sOAPElement = (SOAPElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapElement_getEncodingStyle(sOAPElement);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    strSoapElement_getEncodingStyle = locale._saaj.soapElement_getEncodingStyle(sOAPElement);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return strSoapElement_getEncodingStyle;
    }

    public static Iterator _soapElement_getNamespacePrefixes(Dom dom) {
        Iterator itSoapElement_getNamespacePrefixes;
        Locale locale = dom.locale();
        SOAPElement sOAPElement = (SOAPElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapElement_getNamespacePrefixes(sOAPElement);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    itSoapElement_getNamespacePrefixes = locale._saaj.soapElement_getNamespacePrefixes(sOAPElement);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return itSoapElement_getNamespacePrefixes;
    }

    public static String _soapElement_getNamespaceURI(Dom dom, String str) {
        String strSoapElement_getNamespaceURI;
        Locale locale = dom.locale();
        SOAPElement sOAPElement = (SOAPElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapElement_getNamespaceURI(sOAPElement, str);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    strSoapElement_getNamespaceURI = locale._saaj.soapElement_getNamespaceURI(sOAPElement, str);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return strSoapElement_getNamespaceURI;
    }

    public static Iterator _soapElement_getVisibleNamespacePrefixes(Dom dom) {
        Iterator itSoapElement_getVisibleNamespacePrefixes;
        Locale locale = dom.locale();
        SOAPElement sOAPElement = (SOAPElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapElement_getVisibleNamespacePrefixes(sOAPElement);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    itSoapElement_getVisibleNamespacePrefixes = locale._saaj.soapElement_getVisibleNamespacePrefixes(sOAPElement);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return itSoapElement_getVisibleNamespacePrefixes;
    }

    public static boolean _soapElement_removeAttribute(Dom dom, Name name) {
        boolean zSoapElement_removeAttribute;
        Locale locale = dom.locale();
        SOAPElement sOAPElement = (SOAPElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapElement_removeAttribute(sOAPElement, name);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    zSoapElement_removeAttribute = locale._saaj.soapElement_removeAttribute(sOAPElement, name);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zSoapElement_removeAttribute;
    }

    public static void _soapElement_removeContents(Dom dom) {
        Locale locale = dom.locale();
        SOAPElement sOAPElement = (SOAPElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                locale._saaj.soapElement_removeContents(sOAPElement);
            } finally {
            }
        } else {
            synchronized (locale) {
                try {
                    locale.enter();
                    try {
                        locale._saaj.soapElement_removeContents(sOAPElement);
                    } finally {
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static boolean _soapElement_removeNamespaceDeclaration(Dom dom, String str) {
        boolean zSoapElement_removeNamespaceDeclaration;
        Locale locale = dom.locale();
        SOAPElement sOAPElement = (SOAPElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapElement_removeNamespaceDeclaration(sOAPElement, str);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    zSoapElement_removeNamespaceDeclaration = locale._saaj.soapElement_removeNamespaceDeclaration(sOAPElement, str);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zSoapElement_removeNamespaceDeclaration;
    }

    public static void _soapElement_setEncodingStyle(Dom dom, String str) {
        Locale locale = dom.locale();
        SOAPElement sOAPElement = (SOAPElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                locale._saaj.soapElement_setEncodingStyle(sOAPElement, str);
            } finally {
            }
        } else {
            synchronized (locale) {
                try {
                    locale.enter();
                    try {
                        locale._saaj.soapElement_setEncodingStyle(sOAPElement, str);
                    } finally {
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static SOAPBody _soapEnvelope_addBody(Dom dom) {
        SOAPBody sOAPBodySoapEnvelope_addBody;
        Locale locale = dom.locale();
        SOAPEnvelope sOAPEnvelope = (SOAPEnvelope) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapEnvelope_addBody(sOAPEnvelope);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    sOAPBodySoapEnvelope_addBody = locale._saaj.soapEnvelope_addBody(sOAPEnvelope);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sOAPBodySoapEnvelope_addBody;
    }

    public static SOAPHeader _soapEnvelope_addHeader(Dom dom) {
        SOAPHeader sOAPHeaderSoapEnvelope_addHeader;
        Locale locale = dom.locale();
        SOAPEnvelope sOAPEnvelope = (SOAPEnvelope) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapEnvelope_addHeader(sOAPEnvelope);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    sOAPHeaderSoapEnvelope_addHeader = locale._saaj.soapEnvelope_addHeader(sOAPEnvelope);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sOAPHeaderSoapEnvelope_addHeader;
    }

    public static Name _soapEnvelope_createName(Dom dom, String str) {
        Name nameSoapEnvelope_createName;
        Locale locale = dom.locale();
        SOAPEnvelope sOAPEnvelope = (SOAPEnvelope) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapEnvelope_createName(sOAPEnvelope, str);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    nameSoapEnvelope_createName = locale._saaj.soapEnvelope_createName(sOAPEnvelope, str);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return nameSoapEnvelope_createName;
    }

    public static SOAPBody _soapEnvelope_getBody(Dom dom) {
        SOAPBody sOAPBodySoapEnvelope_getBody;
        Locale locale = dom.locale();
        SOAPEnvelope sOAPEnvelope = (SOAPEnvelope) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapEnvelope_getBody(sOAPEnvelope);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    sOAPBodySoapEnvelope_getBody = locale._saaj.soapEnvelope_getBody(sOAPEnvelope);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sOAPBodySoapEnvelope_getBody;
    }

    public static SOAPHeader _soapEnvelope_getHeader(Dom dom) {
        SOAPHeader sOAPHeaderSoapEnvelope_getHeader;
        Locale locale = dom.locale();
        SOAPEnvelope sOAPEnvelope = (SOAPEnvelope) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapEnvelope_getHeader(sOAPEnvelope);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    sOAPHeaderSoapEnvelope_getHeader = locale._saaj.soapEnvelope_getHeader(sOAPEnvelope);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sOAPHeaderSoapEnvelope_getHeader;
    }

    public static void _soapNode_detachNode(Dom dom) {
        Locale locale = dom.locale();
        org.apache.xmlbeans.impl.soap.Node node = (org.apache.xmlbeans.impl.soap.Node) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                locale._saaj.soapNode_detachNode(node);
            } finally {
            }
        } else {
            synchronized (locale) {
                try {
                    locale.enter();
                    try {
                        locale._saaj.soapNode_detachNode(node);
                    } finally {
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static SOAPElement _soapNode_getParentElement(Dom dom) {
        SOAPElement sOAPElementSoapNode_getParentElement;
        Locale locale = dom.locale();
        org.apache.xmlbeans.impl.soap.Node node = (org.apache.xmlbeans.impl.soap.Node) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapNode_getParentElement(node);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    sOAPElementSoapNode_getParentElement = locale._saaj.soapNode_getParentElement(node);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sOAPElementSoapNode_getParentElement;
    }

    public static String _soapNode_getValue(Dom dom) {
        String strSoapNode_getValue;
        Locale locale = dom.locale();
        org.apache.xmlbeans.impl.soap.Node node = (org.apache.xmlbeans.impl.soap.Node) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapNode_getValue(node);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    strSoapNode_getValue = locale._saaj.soapNode_getValue(node);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return strSoapNode_getValue;
    }

    public static void _soapNode_recycleNode(Dom dom) {
        Locale locale = dom.locale();
        org.apache.xmlbeans.impl.soap.Node node = (org.apache.xmlbeans.impl.soap.Node) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                locale._saaj.soapNode_recycleNode(node);
            } finally {
            }
        } else {
            synchronized (locale) {
                try {
                    locale.enter();
                    try {
                        locale._saaj.soapNode_recycleNode(node);
                    } finally {
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static void _soapNode_setParentElement(Dom dom, SOAPElement sOAPElement) {
        Locale locale = dom.locale();
        org.apache.xmlbeans.impl.soap.Node node = (org.apache.xmlbeans.impl.soap.Node) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                locale._saaj.soapNode_setParentElement(node, sOAPElement);
            } finally {
            }
        } else {
            synchronized (locale) {
                try {
                    locale.enter();
                    try {
                        locale._saaj.soapNode_setParentElement(node, sOAPElement);
                    } finally {
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static void _soapNode_setValue(Dom dom, String str) {
        Locale locale = dom.locale();
        org.apache.xmlbeans.impl.soap.Node node = (org.apache.xmlbeans.impl.soap.Node) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                locale._saaj.soapNode_setValue(node, str);
            } finally {
            }
        } else {
            synchronized (locale) {
                try {
                    locale.enter();
                    try {
                        locale._saaj.soapNode_setValue(node, str);
                    } finally {
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static void _soapPart_addMimeHeader(Dom dom, String str, String str2) {
        Locale locale = dom.locale();
        SOAPPart sOAPPart = (SOAPPart) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                locale._saaj.soapPart_addMimeHeader(sOAPPart, str, str2);
            } finally {
            }
        } else {
            synchronized (locale) {
                try {
                    locale.enter();
                    try {
                        locale._saaj.soapPart_addMimeHeader(sOAPPart, str, str2);
                    } finally {
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static Iterator _soapPart_getAllMimeHeaders(Dom dom) {
        Iterator itSoapPart_getAllMimeHeaders;
        Locale locale = dom.locale();
        SOAPPart sOAPPart = (SOAPPart) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapPart_getAllMimeHeaders(sOAPPart);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    itSoapPart_getAllMimeHeaders = locale._saaj.soapPart_getAllMimeHeaders(sOAPPart);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return itSoapPart_getAllMimeHeaders;
    }

    public static Source _soapPart_getContent(Dom dom) {
        Source sourceSoapPart_getContent;
        Locale locale = dom.locale();
        SOAPPart sOAPPart = (SOAPPart) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapPart_getContent(sOAPPart);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    sourceSoapPart_getContent = locale._saaj.soapPart_getContent(sOAPPart);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sourceSoapPart_getContent;
    }

    public static SOAPEnvelope _soapPart_getEnvelope(Dom dom) {
        SOAPEnvelope sOAPEnvelopeSoapPart_getEnvelope;
        Locale locale = dom.locale();
        SOAPPart sOAPPart = (SOAPPart) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapPart_getEnvelope(sOAPPart);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    sOAPEnvelopeSoapPart_getEnvelope = locale._saaj.soapPart_getEnvelope(sOAPPart);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sOAPEnvelopeSoapPart_getEnvelope;
    }

    public static Iterator _soapPart_getMatchingMimeHeaders(Dom dom, String[] strArr) {
        Iterator itSoapPart_getMatchingMimeHeaders;
        Locale locale = dom.locale();
        SOAPPart sOAPPart = (SOAPPart) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapPart_getMatchingMimeHeaders(sOAPPart, strArr);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    itSoapPart_getMatchingMimeHeaders = locale._saaj.soapPart_getMatchingMimeHeaders(sOAPPart, strArr);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return itSoapPart_getMatchingMimeHeaders;
    }

    public static String[] _soapPart_getMimeHeader(Dom dom, String str) {
        String[] strArrSoapPart_getMimeHeader;
        Locale locale = dom.locale();
        SOAPPart sOAPPart = (SOAPPart) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapPart_getMimeHeader(sOAPPart, str);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    strArrSoapPart_getMimeHeader = locale._saaj.soapPart_getMimeHeader(sOAPPart, str);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return strArrSoapPart_getMimeHeader;
    }

    public static Iterator _soapPart_getNonMatchingMimeHeaders(Dom dom, String[] strArr) {
        Iterator itSoapPart_getNonMatchingMimeHeaders;
        Locale locale = dom.locale();
        SOAPPart sOAPPart = (SOAPPart) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapPart_getNonMatchingMimeHeaders(sOAPPart, strArr);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    itSoapPart_getNonMatchingMimeHeaders = locale._saaj.soapPart_getNonMatchingMimeHeaders(sOAPPart, strArr);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return itSoapPart_getNonMatchingMimeHeaders;
    }

    public static void _soapPart_removeAllMimeHeaders(Dom dom) {
        Locale locale = dom.locale();
        SOAPPart sOAPPart = (SOAPPart) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                locale._saaj.soapPart_removeAllMimeHeaders(sOAPPart);
            } finally {
            }
        } else {
            synchronized (locale) {
                try {
                    locale.enter();
                    try {
                        locale._saaj.soapPart_removeAllMimeHeaders(sOAPPart);
                    } finally {
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static void _soapPart_removeMimeHeader(Dom dom, String str) {
        Locale locale = dom.locale();
        SOAPPart sOAPPart = (SOAPPart) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                locale._saaj.soapPart_removeMimeHeader(sOAPPart, str);
            } finally {
            }
        } else {
            synchronized (locale) {
                try {
                    locale.enter();
                    try {
                        locale._saaj.soapPart_removeMimeHeader(sOAPPart, str);
                    } finally {
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static void _soapPart_setContent(Dom dom, Source source) {
        Locale locale = dom.locale();
        SOAPPart sOAPPart = (SOAPPart) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                locale._saaj.soapPart_setContent(sOAPPart, source);
            } finally {
            }
        } else {
            synchronized (locale) {
                try {
                    locale.enter();
                    try {
                        locale._saaj.soapPart_setContent(sOAPPart, source);
                    } finally {
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static void _soapPart_setMimeHeader(Dom dom, String str, String str2) {
        Locale locale = dom.locale();
        SOAPPart sOAPPart = (SOAPPart) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                locale._saaj.soapPart_setMimeHeader(sOAPPart, str, str2);
            } finally {
            }
        } else {
            synchronized (locale) {
                try {
                    locale.enter();
                    try {
                        locale._saaj.soapPart_setMimeHeader(sOAPPart, str, str2);
                    } finally {
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static boolean _soapText_isComment(Dom dom) {
        boolean zSoapText_isComment;
        Locale locale = dom.locale();
        Text text = (Text) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapText_isComment(text);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    zSoapText_isComment = locale._saaj.soapText_isComment(text);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zSoapText_isComment;
    }

    public static String _text_getWholeText(Dom dom) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    public static boolean _text_isElementContentWhitespace(Dom dom) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    public static org.w3c.dom.Text _text_replaceWholeText(Dom dom, String str) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    public static org.w3c.dom.Text _text_splitText(Dom dom, int i) {
        if (!$assertionsDisabled && dom.nodeType() != 3) {
            throw new AssertionError();
        }
        String str_characterData_getData = _characterData_getData(dom);
        if (i < 0 || i > str_characterData_getData.length()) {
            throw new IndexSizeError();
        }
        _characterData_deleteData(dom, i, str_characterData_getData.length() - i);
        Dom dom2 = (Dom) _document_createTextNode(dom, str_characterData_getData.substring(i));
        Dom dom3 = (Dom) _node_getParentNode(dom);
        if (dom3 != null) {
            _node_insertBefore(dom3, (org.w3c.dom.Text) dom2, _node_getNextSibling(dom));
            dom.locale().invalidateDomCaches(dom3);
        }
        return (org.w3c.dom.Text) dom2;
    }

    public static Dom append(Dom dom, Dom dom2) {
        return node_insertBefore(dom2, dom, null);
    }

    public static Dom attr_getOwnerElement(Dom dom) {
        Cur curTempCur = dom.tempCur();
        if (!curTempCur.toParentRaw()) {
            curTempCur.release();
            return null;
        }
        Dom dom2 = curTempCur.getDom();
        curTempCur.release();
        return dom2;
    }

    public static int attributes_getLength(Dom dom) {
        Cur curTempCur = dom.tempCur();
        int i = 0;
        while (curTempCur.toNextAttr()) {
            i++;
        }
        curTempCur.release();
        return i;
    }

    public static Dom attributes_getNamedItem(Dom dom, String str) {
        Dom dom2;
        Cur curTempCur = dom.tempCur();
        while (true) {
            if (!curTempCur.toNextAttr()) {
                dom2 = null;
                break;
            }
            dom2 = curTempCur.getDom();
            if (_node_getNodeName(dom2).equals(str)) {
                break;
            }
        }
        curTempCur.release();
        return dom2;
    }

    public static Dom attributes_getNamedItemNS(Dom dom, String str, String str2) {
        Dom dom2;
        if (str == null) {
            str = "";
        }
        Cur curTempCur = dom.tempCur();
        while (true) {
            if (!curTempCur.toNextAttr()) {
                dom2 = null;
                break;
            }
            dom2 = curTempCur.getDom();
            QName qName = dom2.getQName();
            if (qName.getNamespaceURI().equals(str) && qName.getLocalPart().equals(str2)) {
                break;
            }
        }
        curTempCur.release();
        return dom2;
    }

    public static Dom attributes_item(Dom dom, int i) {
        Dom dom2 = null;
        if (i < 0) {
            return null;
        }
        Cur curTempCur = dom.tempCur();
        while (true) {
            if (!curTempCur.toNextAttr()) {
                break;
            }
            int i2 = i - 1;
            if (i == 0) {
                dom2 = curTempCur.getDom();
                break;
            }
            i = i2;
        }
        curTempCur.release();
        return dom2;
    }

    public static Dom attributes_removeNamedItem(Dom dom, String str) {
        Cur curTempCur = dom.tempCur();
        Dom dom2 = null;
        while (curTempCur.toNextAttr()) {
            Dom dom3 = curTempCur.getDom();
            if (_node_getNodeName(dom3).equals(str)) {
                if (dom2 == null) {
                    dom2 = dom3;
                }
                if (((Xobj.AttrXobj) dom3).isId()) {
                    Dom domNode_getOwnerDocument = node_getOwnerDocument(dom3);
                    String strNode_getNodeValue = node_getNodeValue(dom3);
                    if (domNode_getOwnerDocument instanceof Xobj.DocumentXobj) {
                        ((Xobj.DocumentXobj) domNode_getOwnerDocument).removeIdElement(strNode_getNodeValue);
                    }
                }
                removeNode(dom3);
                curTempCur.toPrevAttr();
            }
        }
        curTempCur.release();
        if (dom2 != null) {
            return dom2;
        }
        throw new NotFoundErr(AbstractC14516b.m15113a("Named item not found: ", str));
    }

    public static Dom attributes_removeNamedItemNS(Dom dom, String str, String str2) {
        if (str == null) {
            str = "";
        }
        Cur curTempCur = dom.tempCur();
        Dom dom2 = null;
        while (curTempCur.toNextAttr()) {
            Dom dom3 = curTempCur.getDom();
            QName qName = dom3.getQName();
            if (qName.getNamespaceURI().equals(str) && qName.getLocalPart().equals(str2)) {
                if (dom2 == null) {
                    dom2 = dom3;
                }
                if (((Xobj.AttrXobj) dom3).isId()) {
                    Dom domNode_getOwnerDocument = node_getOwnerDocument(dom3);
                    String strNode_getNodeValue = node_getNodeValue(dom3);
                    if (domNode_getOwnerDocument instanceof Xobj.DocumentXobj) {
                        ((Xobj.DocumentXobj) domNode_getOwnerDocument).removeIdElement(strNode_getNodeValue);
                    }
                }
                removeNode(dom3);
                curTempCur.toPrevAttr();
            }
        }
        curTempCur.release();
        if (dom2 != null) {
            return dom2;
        }
        StringBuffer stringBuffer = new StringBuffer("Named item not found: uri=");
        stringBuffer.append(str);
        stringBuffer.append(", local=");
        stringBuffer.append(str2);
        throw new NotFoundErr(stringBuffer.toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Dom attributes_setNamedItem(Dom dom, Dom dom2) {
        if (attr_getOwnerElement(dom2) != null) {
            throw new InuseAttributeError();
        }
        if (dom2.nodeType() != 2) {
            throw new HierarchyRequestErr("Node is not an attribute");
        }
        String str_node_getNodeName = _node_getNodeName(dom2);
        Cur curTempCur = dom.tempCur();
        Dom dom3 = null;
        while (curTempCur.toNextAttr()) {
            Dom dom4 = curTempCur.getDom();
            if (_node_getNodeName(dom4).equals(str_node_getNodeName)) {
                if (dom3 == null) {
                    dom3 = dom4;
                } else {
                    removeNode(dom4);
                    curTempCur.toPrevAttr();
                }
            }
        }
        if (dom3 == null) {
            curTempCur.moveToDom(dom);
            curTempCur.next();
            Cur.moveNode((Xobj) dom2, curTempCur);
        } else {
            curTempCur.moveToDom(dom3);
            Cur.moveNode((Xobj) dom2, curTempCur);
            removeNode(dom3);
        }
        curTempCur.release();
        return dom3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Dom attributes_setNamedItemNS(Dom dom, Dom dom2) {
        Dom domAttr_getOwnerElement = attr_getOwnerElement(dom2);
        if (domAttr_getOwnerElement == dom) {
            return dom2;
        }
        if (domAttr_getOwnerElement != null) {
            throw new InuseAttributeError();
        }
        if (dom2.nodeType() != 2) {
            throw new HierarchyRequestErr("Node is not an attribute");
        }
        QName qName = dom2.getQName();
        Cur curTempCur = dom.tempCur();
        Dom dom3 = null;
        while (curTempCur.toNextAttr()) {
            Dom dom4 = curTempCur.getDom();
            if (dom4.getQName().equals(qName)) {
                if (dom3 == null) {
                    dom3 = dom4;
                } else {
                    removeNode(dom4);
                    curTempCur.toPrevAttr();
                }
            }
        }
        if (dom3 == null) {
            curTempCur.moveToDom(dom);
            curTempCur.next();
            Cur.moveNode((Xobj) dom2, curTempCur);
        } else {
            curTempCur.moveToDom(dom3);
            Cur.moveNode((Xobj) dom2, curTempCur);
            removeNode(dom3);
        }
        curTempCur.release();
        return dom3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int childNodes_getLength(Dom dom) {
        switch (dom.nodeType()) {
            case 3:
            case 4:
            case 7:
            case 8:
                return 0;
            case 5:
                throw new RuntimeException("Not impl");
            case 6:
            case 10:
            case 12:
                throw new RuntimeException("Not impl");
            case 9:
            case 11:
            default:
                if (!$assertionsDisabled && !(dom instanceof Xobj)) {
                    throw new AssertionError();
                }
                Xobj xobj = (Xobj) dom;
                xobj.ensureOccupancy();
                int domZeroOneChildren = xobj.getDomZeroOneChildren();
                return domZeroOneChildren < 2 ? domZeroOneChildren : dom.locale().domLength(dom);
        }
    }

    public static Dom childNodes_item(Dom dom, int i) {
        if (i < 0) {
            return null;
        }
        switch (dom.nodeType()) {
            case 3:
            case 4:
            case 7:
            case 8:
                return null;
            case 5:
                throw new RuntimeException("Not impl");
            case 6:
            case 10:
            case 12:
                throw new RuntimeException("Not impl");
            case 9:
            case 11:
            default:
                return i == 0 ? node_getFirstChild(dom) : dom.locale().findDomNthChild(dom, i);
        }
    }

    public static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw AbstractC12991c.m13994o(e);
        }
    }

    public static DetailEntry detail_addDetailEntry(Dom dom, Name name) {
        DetailEntry detailEntryDetail_addDetailEntry;
        Locale locale = dom.locale();
        Detail detail = (Detail) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.detail_addDetailEntry(detail, name);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    detailEntryDetail_addDetailEntry = locale._saaj.detail_addDetailEntry(detail, name);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return detailEntryDetail_addDetailEntry;
    }

    public static Iterator detail_getDetailEntries(Dom dom) {
        Iterator itDetail_getDetailEntries;
        Locale locale = dom.locale();
        Detail detail = (Detail) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.detail_getDetailEntries(detail);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    itDetail_getDetailEntries = locale._saaj.detail_getDetailEntries(detail);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return itDetail_getDetailEntries;
    }

    public static Dom document_createAttribute(Dom dom, String str) {
        validateName(str);
        Locale locale = dom.locale();
        Cur curTempCur = locale.tempCur();
        curTempCur.createAttr(locale.makeQualifiedQName("", str));
        Dom dom2 = curTempCur.getDom();
        curTempCur.release();
        ((Xobj.AttrXobj) dom2)._canHavePrefixUri = false;
        return dom2;
    }

    public static Dom document_createAttributeNS(Dom dom, String str, String str2) {
        validateQualifiedName(str2, str, true);
        Locale locale = dom.locale();
        Cur curTempCur = locale.tempCur();
        curTempCur.createAttr(locale.makeQualifiedQName(str, str2));
        Dom dom2 = curTempCur.getDom();
        curTempCur.release();
        return dom2;
    }

    public static Dom document_createCDATASection(Dom dom, String str) {
        CdataNode cdataNodeCreateCdataNode = dom.locale().createCdataNode();
        if (str == null) {
            str = "";
        }
        cdataNodeCreateCdataNode.setChars(str, 0, str.length());
        return cdataNodeCreateCdataNode;
    }

    public static Dom document_createComment(Dom dom, String str) {
        Cur curTempCur = dom.locale().tempCur();
        curTempCur.createComment();
        Dom dom2 = curTempCur.getDom();
        if (str != null) {
            curTempCur.next();
            curTempCur.insertString(str);
        }
        curTempCur.release();
        return dom2;
    }

    public static Dom document_createDocumentFragment(Dom dom) {
        Cur curTempCur = dom.locale().tempCur();
        curTempCur.createDomDocFragRoot();
        Dom dom2 = curTempCur.getDom();
        curTempCur.release();
        return dom2;
    }

    public static Dom document_createElement(Dom dom, String str) {
        validateName(str);
        Locale locale = dom.locale();
        Cur curTempCur = locale.tempCur();
        curTempCur.createElement(locale.makeQualifiedQName("", str));
        Dom dom2 = curTempCur.getDom();
        curTempCur.release();
        ((Xobj.ElementXobj) dom2)._canHavePrefixUri = false;
        return dom2;
    }

    public static Dom document_createElementNS(Dom dom, String str, String str2) {
        validateQualifiedName(str2, str, false);
        Locale locale = dom.locale();
        Cur curTempCur = locale.tempCur();
        curTempCur.createElement(locale.makeQualifiedQName(str, str2));
        Dom dom2 = curTempCur.getDom();
        curTempCur.release();
        return dom2;
    }

    public static Dom document_createProcessingInstruction(Dom dom, String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Target is null");
        }
        if (str.length() == 0) {
            throw new IllegalArgumentException("Target is empty");
        }
        if (!XMLChar.isValidName(str)) {
            throw new InvalidCharacterError("Target has an invalid character");
        }
        if (Locale.beginsWithXml(str) && str.length() == 3) {
            throw new InvalidCharacterError("Invalid target - is 'xml'");
        }
        Cur curTempCur = dom.locale().tempCur();
        curTempCur.createProcinst(str);
        Dom dom2 = curTempCur.getDom();
        if (str2 != null) {
            curTempCur.next();
            curTempCur.insertString(str2);
        }
        curTempCur.release();
        return dom2;
    }

    public static CharNode document_createTextNode(Dom dom, String str) {
        TextNode textNodeCreateTextNode = dom.locale().createTextNode();
        if (str == null) {
            str = "";
        }
        textNodeCreateTextNode.setChars(str, 0, str.length());
        return textNodeCreateTextNode;
    }

    public static Dom document_getDoctype(Dom dom) {
        return null;
    }

    public static Dom document_getDocumentElement(Dom dom) {
        for (Dom domFirstChild = firstChild(dom); domFirstChild != null; domFirstChild = nextSibling(domFirstChild)) {
            if (domFirstChild.nodeType() == 1) {
                return domFirstChild;
            }
        }
        return null;
    }

    public static NodeList document_getElementsByTagName(Dom dom, String str) {
        return new ElementsByTagNameNodeList(dom, str);
    }

    public static NodeList document_getElementsByTagNameNS(Dom dom, String str, String str2) {
        return new ElementsByTagNameNSNodeList(dom, str, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x0114  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Dom document_importNode(Dom dom, Node node, boolean z) {
        Dom domDocument_createElement;
        Dom domDocument_createAttribute;
        if (node == null) {
            return null;
        }
        switch (node.getNodeType()) {
            case 1:
                String localName = node.getLocalName();
                if (localName == null || localName.length() == 0) {
                    domDocument_createElement = document_createElement(dom, node.getNodeName());
                } else {
                    String prefix = node.getPrefix();
                    if (prefix != null && prefix.length() != 0) {
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append(prefix);
                        stringBuffer.append(":");
                        stringBuffer.append(localName);
                        localName = stringBuffer.toString();
                    }
                    String namespaceURI = node.getNamespaceURI();
                    domDocument_createElement = (namespaceURI == null || namespaceURI.length() == 0) ? document_createElement(dom, localName) : document_createElementNS(dom, namespaceURI, localName);
                }
                NamedNodeMap attributes = node.getAttributes();
                for (int i = 0; i < attributes.getLength(); i++) {
                    attributes_setNamedItem(domDocument_createElement, document_importNode(dom, attributes.item(i), true));
                }
                if (z) {
                    NodeList childNodes = node.getChildNodes();
                    for (int i2 = 0; i2 < childNodes.getLength(); i2++) {
                        node_insertBefore(domDocument_createElement, document_importNode(dom, childNodes.item(i2), true), null);
                    }
                }
                return domDocument_createElement;
            case 2:
                String localName2 = node.getLocalName();
                if (localName2 == null || localName2.length() == 0) {
                    domDocument_createAttribute = document_createAttribute(dom, node.getNodeName());
                } else {
                    String prefix2 = node.getPrefix();
                    if (prefix2 != null && prefix2.length() != 0) {
                        StringBuffer stringBuffer2 = new StringBuffer();
                        stringBuffer2.append(prefix2);
                        stringBuffer2.append(":");
                        stringBuffer2.append(localName2);
                        localName2 = stringBuffer2.toString();
                    }
                    String namespaceURI2 = node.getNamespaceURI();
                    domDocument_createAttribute = (namespaceURI2 == null || namespaceURI2.length() == 0) ? document_createAttribute(dom, localName2) : document_createAttributeNS(dom, namespaceURI2, localName2);
                }
                domDocument_createElement = domDocument_createAttribute;
                z = true;
                if (z) {
                }
                return domDocument_createElement;
            case 3:
                domDocument_createElement = document_createTextNode(dom, node.getNodeValue());
                z = false;
                if (z) {
                }
                return domDocument_createElement;
            case 4:
                domDocument_createElement = document_createCDATASection(dom, node.getNodeValue());
                z = false;
                if (z) {
                }
                return domDocument_createElement;
            case 5:
            case 6:
            case 12:
                throw new RuntimeException("Not impl");
            case 7:
                domDocument_createElement = document_createProcessingInstruction(dom, node.getNodeName(), node.getNodeValue());
                z = false;
                if (z) {
                }
                return domDocument_createElement;
            case 8:
                domDocument_createElement = document_createComment(dom, node.getNodeValue());
                z = false;
                if (z) {
                }
                return domDocument_createElement;
            case 9:
                throw new NotSupportedError("Document nodes may not be imported");
            case 10:
                throw new NotSupportedError("Document type nodes may not be imported");
            case 11:
                domDocument_createElement = document_createDocumentFragment(dom);
                if (z) {
                }
                return domDocument_createElement;
            default:
                throw new RuntimeException("Unknown kind");
        }
    }

    public static Document domImplementation_createDocument(Locale locale, String str, String str2, DocumentType documentType) {
        validateQualifiedName(str2, str, false);
        Cur curTempCur = locale.tempCur();
        curTempCur.createDomDocumentRoot();
        Document document = (Document) curTempCur.getDom();
        curTempCur.next();
        curTempCur.createElement(locale.makeQualifiedQName(str, str2));
        if (documentType != null) {
            throw new RuntimeException("Not impl");
        }
        curTempCur.toParent();
        try {
            Locale.autoTypeDocument(curTempCur, null, null);
            curTempCur.release();
            return document;
        } catch (XmlException e) {
            throw new XmlRuntimeException(e);
        }
    }

    public static NodeList element_getElementsByTagName(Dom dom, String str) {
        return new ElementsByTagNameNodeList(dom, str);
    }

    public static NodeList element_getElementsByTagNameNS(Dom dom, String str, String str2) {
        return new ElementsByTagNameNSNodeList(dom, str, str2);
    }

    public static void element_setAttribute(Dom dom, String str, String str2) {
        Dom domAttributes_getNamedItem = attributes_getNamedItem(dom, str);
        if (domAttributes_getNamedItem == null) {
            domAttributes_getNamedItem = document_createAttribute(node_getOwnerDocument(dom), str);
            attributes_setNamedItem(dom, domAttributes_getNamedItem);
        }
        node_setNodeValue(domAttributes_getNamedItem, str2);
    }

    public static void element_setAttributeNS(Dom dom, String str, String str2, String str3) {
        validateQualifiedName(str2, str, true);
        QName qNameMakeQualifiedQName = dom.locale().makeQualifiedQName(str, str2);
        String localPart = qNameMakeQualifiedQName.getLocalPart();
        String strValidatePrefix = validatePrefix(qNameMakeQualifiedQName.getPrefix(), str, localPart, true);
        Dom domAttributes_getNamedItemNS = attributes_getNamedItemNS(dom, str, localPart);
        if (domAttributes_getNamedItemNS == null) {
            domAttributes_getNamedItemNS = document_createAttributeNS(node_getOwnerDocument(dom), str, localPart);
            attributes_setNamedItemNS(dom, domAttributes_getNamedItemNS);
        }
        node_setPrefix(domAttributes_getNamedItemNS, strValidatePrefix);
        node_setNodeValue(domAttributes_getNamedItemNS, str3);
    }

    public static Dom firstChild(Dom dom) {
        return node_getFirstChild(dom);
    }

    public static XmlCursor getXmlCursor(Dom dom) {
        Cur curTempCur = dom.tempCur();
        Cursor cursor = new Cursor(curTempCur);
        curTempCur.release();
        return cursor;
    }

    public static XmlObject getXmlObject(Dom dom) {
        Cur curTempCur = dom.tempCur();
        XmlObject object = curTempCur.getObject();
        curTempCur.release();
        return object;
    }

    public static XMLStreamReader getXmlStreamReader(Dom dom) {
        XMLStreamReader xMLStreamReaderNewXmlStreamReader;
        switch (dom.nodeType()) {
            case 1:
            case 2:
            case 7:
            case 8:
            case 9:
            case 11:
                Cur curTempCur = dom.tempCur();
                XMLStreamReader xMLStreamReaderNewXmlStreamReader2 = Jsr173.newXmlStreamReader(curTempCur, (XmlOptions) null);
                curTempCur.release();
                return xMLStreamReaderNewXmlStreamReader2;
            case 3:
            case 4:
                CharNode charNode = (CharNode) dom;
                Cur curTempCur2 = charNode.tempCur();
                if (curTempCur2 == null) {
                    curTempCur2 = dom.locale().tempCur();
                    xMLStreamReaderNewXmlStreamReader = Jsr173.newXmlStreamReader(curTempCur2, charNode._src, charNode._off, charNode._cch);
                } else {
                    xMLStreamReaderNewXmlStreamReader = Jsr173.newXmlStreamReader(curTempCur2, curTempCur2.getChars(charNode._cch), curTempCur2._offSrc, curTempCur2._cchSrc);
                }
                curTempCur2.release();
                return xMLStreamReaderNewXmlStreamReader;
            case 5:
            case 6:
            case 10:
            case 12:
                throw new RuntimeException("Not impl");
            default:
                throw new RuntimeException("Unknown kind");
        }
    }

    public static Dom impl_saajCallback_createSoapElement(Dom dom, QName qName, QName qName2) {
        Cur curTempCur = dom.locale().tempCur();
        curTempCur.createElement(qName, qName2);
        Dom dom2 = curTempCur.getDom();
        curTempCur.release();
        return dom2;
    }

    public static org.w3c.dom.Text impl_saajCallback_ensureSoapTextNode(Dom dom) {
        return null;
    }

    public static Object impl_saajCallback_getSaajData(Dom dom) throws Throwable {
        Cur curTempCur = dom.locale().tempCur();
        curTempCur.moveToDom(dom);
        Class clsClass$ = class$org$apache$xmlbeans$impl$store$DomImpl$SaajData;
        if (clsClass$ == null) {
            clsClass$ = class$("org.apache.xmlbeans.impl.store.DomImpl$SaajData");
            class$org$apache$xmlbeans$impl$store$DomImpl$SaajData = clsClass$;
        }
        SaajData saajData = (SaajData) curTempCur.getBookmark(clsClass$);
        Object obj = saajData == null ? null : saajData._obj;
        curTempCur.release();
        return obj;
    }

    public static Dom impl_saajCallback_importSoapElement(Dom dom, Element element, boolean z, QName qName) {
        throw new RuntimeException("Not impl");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void impl_saajCallback_setSaajData(Dom dom, Object obj) throws Throwable {
        Cur curTempCur = dom.locale().tempCur();
        curTempCur.moveToDom(dom);
        SaajData saajData = null;
        Object[] objArr = 0;
        if (obj != null) {
            Class clsClass$ = class$org$apache$xmlbeans$impl$store$DomImpl$SaajData;
            if (clsClass$ == null) {
                clsClass$ = class$("org.apache.xmlbeans.impl.store.DomImpl$SaajData");
                class$org$apache$xmlbeans$impl$store$DomImpl$SaajData = clsClass$;
            }
            SaajData saajData2 = (SaajData) curTempCur.getBookmark(clsClass$);
            if (saajData2 == null) {
                saajData2 = new SaajData();
            }
            saajData = saajData2;
            saajData._obj = obj;
        }
        Class clsClass$2 = class$org$apache$xmlbeans$impl$store$DomImpl$SaajData;
        if (clsClass$2 == null) {
            clsClass$2 = class$("org.apache.xmlbeans.impl.store.DomImpl$SaajData");
            class$org$apache$xmlbeans$impl$store$DomImpl$SaajData = clsClass$2;
        }
        curTempCur.setBookmark(clsClass$2, saajData);
        curTempCur.release();
    }

    public static Dom insert(Dom dom, Dom dom2) {
        if ($assertionsDisabled || dom2 != null) {
            return node_insertBefore(parent(dom2), dom, dom2);
        }
        throw new AssertionError();
    }

    private static String isValidChild(Dom dom, Dom dom2) {
        int iNodeType = dom.nodeType();
        int iNodeType2 = dom2.nodeType();
        switch (iNodeType) {
            case 1:
            case 5:
            case 6:
            case 11:
                if (iNodeType2 == 1 || iNodeType2 == 3 || iNodeType2 == 4 || iNodeType2 == 5 || iNodeType2 == 7 || iNodeType2 == 8) {
                    return null;
                }
                break;
            case 2:
                if (iNodeType2 == 3 || iNodeType2 == 5) {
                    return null;
                }
                break;
            case 3:
            case 4:
            case 7:
            case 8:
            case 10:
            case 12:
                return AbstractC8014b.m7199a(new StringBuffer(), nodeKindName(iNodeType), " nodes may not have any children");
            case 9:
                if (iNodeType2 == 1) {
                    if (document_getDocumentElement(dom) != null) {
                        return "Documents may only have a maximum of one document element";
                    }
                    return null;
                }
                if (iNodeType2 == 10) {
                    if (document_getDoctype(dom) != null) {
                        return "Documents may only have a maximum of one document type node";
                    }
                    return null;
                }
                if (iNodeType2 == 7 || iNodeType2 == 8) {
                    return null;
                }
                break;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(nodeKindName(iNodeType));
        stringBuffer.append(" nodes may not have ");
        return AbstractC8014b.m7199a(stringBuffer, nodeKindName(iNodeType2), " nodes as children");
    }

    public static Dom nextSibling(Dom dom) {
        return node_getNextSibling(dom);
    }

    public static String nodeKindName(int i) {
        switch (i) {
            case 1:
                return "element";
            case 2:
                return "attribute";
            case 3:
                return "text";
            case 4:
                return "cdata section";
            case 5:
                return "entity reference";
            case 6:
                return "entity";
            case 7:
                return "processing instruction";
            case 8:
                return ClientCookie.COMMENT_ATTR;
            case 9:
                return ExternalDataConstants.DOCUMENT_TABLE_NAME;
            case 10:
                return "document type";
            case 11:
                return "document fragment";
            case 12:
                return "notation";
            default:
                throw new RuntimeException("Unknown node type");
        }
    }

    public static Dom node_cloneNode(Dom dom, boolean z) {
        Cur curTempCur;
        Locale locale = dom.locale();
        Dom dom2 = null;
        if (!z) {
            int iNodeType = dom.nodeType();
            if (iNodeType == 1) {
                curTempCur = locale.tempCur();
                curTempCur.createElement(dom.getQName());
                Element element = (Element) curTempCur.getDom();
                NamedNodeMap attributes = ((Element) dom).getAttributes();
                for (int i = 0; i < attributes.getLength(); i++) {
                    element.setAttributeNodeNS((Attr) attributes.item(i).cloneNode(true));
                }
            } else if (iNodeType == 2) {
                curTempCur = locale.tempCur();
                curTempCur.createAttr(dom.getQName());
            } else if (iNodeType == 9) {
                curTempCur = locale.tempCur();
                curTempCur.createDomDocumentRoot();
            } else if (iNodeType != 11) {
                curTempCur = null;
            } else {
                curTempCur = locale.tempCur();
                curTempCur.createDomDocFragRoot();
            }
            if (curTempCur != null) {
                dom2 = curTempCur.getDom();
                curTempCur.release();
            }
        }
        if (dom2 != null) {
            return dom2;
        }
        switch (dom.nodeType()) {
            case 1:
            case 2:
            case 7:
            case 8:
            case 9:
            case 11:
                Cur curTempCur2 = locale.tempCur();
                Cur curTempCur3 = dom.tempCur();
                curTempCur3.copyNode(curTempCur2);
                Dom dom3 = curTempCur2.getDom();
                curTempCur2.release();
                curTempCur3.release();
                return dom3;
            case 3:
            case 4:
                Cur curTempCur4 = dom.tempCur();
                TextNode textNodeCreateTextNode = dom.nodeType() == 3 ? locale.createTextNode() : locale.createCdataNode();
                textNodeCreateTextNode.setChars(curTempCur4.getChars(((CharNode) dom)._cch), curTempCur4._offSrc, curTempCur4._cchSrc);
                curTempCur4.release();
                return textNodeCreateTextNode;
            case 5:
            case 6:
            case 10:
            case 12:
                throw new RuntimeException("Not impl");
            default:
                throw new RuntimeException("Unknown kind");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Dom node_getFirstChild(Dom dom) {
        int iNodeType = dom.nodeType();
        if (iNodeType != 1 && iNodeType != 2) {
            if (iNodeType == 5) {
                throw new RuntimeException("Not impl");
            }
            if (iNodeType != 6) {
                switch (iNodeType) {
                    case 9:
                    case 11:
                        break;
                    case 10:
                    case 12:
                        break;
                    default:
                        return null;
                }
            }
            throw new RuntimeException("Not impl");
        }
        Xobj xobj = (Xobj) dom;
        xobj.ensureOccupancy();
        if (xobj.isFirstChildPtrDomUsable()) {
            return (Xobj.NodeXobj) xobj._firstChild;
        }
        Xobj xobjLastAttr = xobj.lastAttr();
        if (xobjLastAttr != null) {
            if (xobjLastAttr.isNextSiblingPtrDomUsable()) {
                return (Xobj.NodeXobj) xobjLastAttr._nextSibling;
            }
            if (xobjLastAttr.isCharNodesAfterUsable()) {
                return xobjLastAttr._charNodesAfter;
            }
        }
        if (xobj.isCharNodesValueUsable()) {
            return xobj._charNodesValue;
        }
        return null;
    }

    public static Dom node_getLastChild(Dom dom) {
        CharNode charNodes;
        Dom dom2 = null;
        switch (dom.nodeType()) {
            case 3:
            case 4:
            case 7:
            case 8:
                return null;
            case 5:
                throw new RuntimeException("Not impl");
            case 6:
            case 10:
            case 12:
                throw new RuntimeException("Not impl");
            case 9:
            case 11:
            default:
                Cur curTempCur = dom.tempCur();
                if (curTempCur.toLastChild()) {
                    Dom dom3 = curTempCur.getDom();
                    curTempCur.skip();
                    charNodes = curTempCur.getCharNodes();
                    if (charNodes == null) {
                        dom2 = dom3;
                    }
                } else {
                    curTempCur.next();
                    charNodes = curTempCur.getCharNodes();
                }
                if (dom2 == null && charNodes != null) {
                    while (true) {
                        CharNode charNode = charNodes._next;
                        if (charNode != null) {
                            charNodes = charNode;
                        } else {
                            dom2 = charNodes;
                        }
                    }
                }
                curTempCur.release();
                return dom2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Dom node_getNextSibling(Dom dom) {
        switch (dom.nodeType()) {
            case 1:
            case 7:
            case 8:
                if (!$assertionsDisabled && !(dom instanceof Xobj)) {
                    throw new AssertionError("PI, Comments and Elements always backed up by Xobj");
                }
                Xobj xobj = (Xobj) dom;
                xobj.ensureOccupancy();
                if (xobj.isNextSiblingPtrDomUsable()) {
                    return (Xobj.NodeXobj) xobj._nextSibling;
                }
                if (xobj.isCharNodesAfterUsable()) {
                    return xobj._charNodesAfter;
                }
            case 2:
            case 9:
            case 11:
            default:
                return null;
            case 3:
            case 4:
                CharNode charNode = (CharNode) dom;
                if (!(charNode._src instanceof Xobj)) {
                    return null;
                }
                Xobj xobj2 = (Xobj) charNode._src;
                xobj2._charNodesAfter = Cur.updateCharNodes(xobj2._locale, xobj2, xobj2._charNodesAfter, xobj2._cchAfter);
                xobj2._charNodesValue = Cur.updateCharNodes(xobj2._locale, xobj2, xobj2._charNodesValue, xobj2._cchValue);
                CharNode charNode2 = charNode._next;
                return charNode2 != null ? charNode2 : charNode.isNodeAftertext() ? (Xobj.NodeXobj) xobj2._nextSibling : (Xobj.NodeXobj) xobj2._firstChild;
            case 5:
            case 6:
            case 10:
            case 12:
                throw new RuntimeException("Not implemented");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String node_getNodeValue(Dom dom) {
        int iNodeType = dom.nodeType();
        if (iNodeType != 2) {
            if (iNodeType == 3 || iNodeType == 4) {
                if (!$assertionsDisabled && !(dom instanceof CharNode)) {
                    throw new AssertionError("Text/CData should be a CharNode");
                }
                CharNode charNode = (CharNode) dom;
                if (!(charNode._src instanceof Xobj)) {
                    return CharUtil.getString(charNode._src, charNode._off, charNode._cch);
                }
                Xobj xobj = (Xobj) charNode._src;
                xobj.ensureOccupancy();
                if (charNode.isNodeAftertext()) {
                    xobj._charNodesAfter = Cur.updateCharNodes(xobj._locale, xobj, xobj._charNodesAfter, xobj._cchAfter);
                    return xobj.getCharsAfterAsString(charNode._off, charNode._cch);
                }
                xobj._charNodesValue = Cur.updateCharNodes(xobj._locale, xobj, xobj._charNodesValue, xobj._cchValue);
                return xobj.getCharsValueAsString(charNode._off, charNode._cch);
            }
            if (iNodeType != 7 && iNodeType != 8) {
                return null;
            }
        }
        return ((Xobj) dom).getValueAsString();
    }

    public static Dom node_getOwnerDocument(Dom dom) {
        if (dom.nodeType() == 9) {
            return null;
        }
        Locale locale = dom.locale();
        if (locale._ownerDoc == null) {
            Cur curTempCur = locale.tempCur();
            curTempCur.createDomDocumentRoot();
            locale._ownerDoc = curTempCur.getDom();
            curTempCur.release();
        }
        return locale._ownerDoc;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Dom node_getParentNode(Dom dom) {
        Cur curTempCur;
        switch (dom.nodeType()) {
            case 1:
            case 7:
            case 8:
                curTempCur = dom.tempCur();
                if (!curTempCur.toParentRaw()) {
                    curTempCur.release();
                    break;
                }
                if (curTempCur == null) {
                    return null;
                }
                Dom dom2 = curTempCur.getDom();
                curTempCur.release();
                return dom2;
            case 2:
            case 9:
            case 11:
                curTempCur = null;
                if (curTempCur == null) {
                }
                break;
            case 3:
            case 4:
                curTempCur = dom.tempCur();
                if (curTempCur != null) {
                    curTempCur.toParent();
                }
                if (curTempCur == null) {
                }
                break;
            case 5:
                throw new RuntimeException("Not impl");
            case 6:
            case 10:
            case 12:
                throw new RuntimeException("Not impl");
            default:
                throw new RuntimeException("Unknown kind");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:37:0x006c, B:31:0x005c], limit reached: 36 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x006c -> B:34:0x0064). Please report as a decompilation issue!!! */
    public static Dom node_getPreviousSibling(Dom dom) {
        Dom domNode_getFirstChild;
        NamespaceManager namespaceManager;
        int iNodeType = dom.nodeType();
        if (iNodeType == 3 || iNodeType == 4) {
            if (!$assertionsDisabled && !(dom instanceof CharNode)) {
                throw new AssertionError("Text/CData should be a CharNode");
            }
            CharNode charNode = (CharNode) dom;
            if (!(charNode._src instanceof Xobj)) {
                return null;
            }
            Xobj xobj = (Xobj) charNode._src;
            xobj.ensureOccupancy();
            boolean zIsNodeAftertext = charNode.isNodeAftertext();
            Dom domNode_getNextSibling = charNode._prev;
            if (domNode_getNextSibling == null) {
                if (zIsNodeAftertext) {
                    domNode_getFirstChild = (Dom) xobj;
                } else {
                    domNode_getNextSibling = xobj._charNodesValue;
                }
            }
            domNode_getFirstChild = domNode_getNextSibling;
        } else {
            if (!$assertionsDisabled && !(dom instanceof Xobj)) {
                throw new AssertionError();
            }
            Xobj xobj2 = (Xobj) dom;
            domNode_getFirstChild = (Dom) xobj2._prevSibling;
            if (domNode_getFirstChild == null && (namespaceManager = xobj2._parent) != null) {
                domNode_getFirstChild = node_getFirstChild((Dom) namespaceManager);
            }
        }
        if (domNode_getFirstChild != null || (domNode_getNextSibling = node_getNextSibling(domNode_getFirstChild)) == dom) {
            return domNode_getFirstChild;
        }
        domNode_getFirstChild = domNode_getNextSibling;
        if (domNode_getFirstChild != null) {
        }
        return domNode_getFirstChild;
    }

    public static boolean node_hasAttributes(Dom dom) {
        if (dom.nodeType() != 1) {
            return false;
        }
        Cur curTempCur = dom.tempCur();
        boolean zHasAttrs = curTempCur.hasAttrs();
        curTempCur.release();
        return zHasAttrs;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Dom node_insertBefore(Dom dom, Dom dom2, Dom dom3) {
        CharNode charNode;
        boolean z = $assertionsDisabled;
        if (!z && dom2 == 0) {
            throw new AssertionError();
        }
        if (dom2 == dom3) {
            return dom2;
        }
        if (dom3 != null && parent(dom3) != dom) {
            throw new NotFoundErr("RefChild is not a child of this node");
        }
        int iNodeType = dom2.nodeType();
        if (iNodeType == 11) {
            for (Dom domFirstChild = firstChild(dom2); domFirstChild != null; domFirstChild = nextSibling(domFirstChild)) {
                validateNewChild(dom, domFirstChild);
            }
            Dom domFirstChild2 = firstChild(dom2);
            while (domFirstChild2 != null) {
                Dom domNextSibling = nextSibling(domFirstChild2);
                if (dom3 == null) {
                    append(domFirstChild2, dom);
                } else {
                    insert(domFirstChild2, dom3);
                }
                domFirstChild2 = domNextSibling;
            }
        } else {
            validateNewChild(dom, dom2);
            remove(dom2);
            int iNodeType2 = dom.nodeType();
            if (!z && iNodeType2 != 2 && iNodeType2 != 11 && iNodeType2 != 9 && iNodeType2 != 1) {
                throw new AssertionError();
            }
            if (iNodeType != 1) {
                if (iNodeType == 10) {
                    throw new RuntimeException("Not implemented");
                }
                if (iNodeType == 3 || iNodeType == 4) {
                    CharNode charNode2 = (CharNode) dom2;
                    if (!z && (charNode2._prev != null || charNode2._next != null)) {
                        throw new AssertionError();
                    }
                    Cur curTempCur = dom.tempCur();
                    if (dom3 == null) {
                        curTempCur.toEnd();
                    } else {
                        int iNodeType3 = dom3.nodeType();
                        if (iNodeType3 == 3 || iNodeType3 == 4) {
                            charNode = (CharNode) dom3;
                            curTempCur.moveToCharNode(charNode);
                            CharNode charNodeInsertNode = CharNode.insertNode(curTempCur.getCharNodes(), charNode2, charNode);
                            curTempCur.insertChars(charNode2._src, charNode2._off, charNode2._cch);
                            curTempCur.setCharNodes(charNodeInsertNode);
                            curTempCur.release();
                            return dom2;
                        }
                        if (iNodeType3 == 5) {
                            throw new RuntimeException("Not implemented");
                        }
                        curTempCur.moveToDom(dom3);
                    }
                    charNode = null;
                    CharNode charNodeInsertNode2 = CharNode.insertNode(curTempCur.getCharNodes(), charNode2, charNode);
                    curTempCur.insertChars(charNode2._src, charNode2._off, charNode2._cch);
                    curTempCur.setCharNodes(charNodeInsertNode2);
                    curTempCur.release();
                    return dom2;
                }
                if (iNodeType == 5) {
                    throw new RuntimeException("Not implemented");
                }
                if (iNodeType != 7 && iNodeType != 8) {
                    throw new RuntimeException("Unexpected child node type");
                }
            }
            if (dom3 == null) {
                Cur curTempCur2 = dom.tempCur();
                curTempCur2.toEnd();
                Cur.moveNode((Xobj) dom2, curTempCur2);
                curTempCur2.release();
                return dom2;
            }
            int iNodeType4 = dom3.nodeType();
            if (iNodeType4 != 3 && iNodeType4 != 4) {
                if (iNodeType4 == 5) {
                    throw new RuntimeException("Not implemented");
                }
                if (!z && iNodeType4 != 1 && iNodeType4 != 7 && iNodeType4 != 8) {
                    throw new AssertionError();
                }
                Cur curTempCur3 = dom3.tempCur();
                Cur.moveNode((Xobj) dom2, curTempCur3);
                curTempCur3.release();
                return dom2;
            }
            ArrayList arrayList = new ArrayList();
            while (dom3 != null && (dom3.nodeType() == 3 || dom3.nodeType() == 4)) {
                Dom domNextSibling2 = nextSibling(dom3);
                arrayList.add(remove(dom3));
                dom3 = domNextSibling2;
            }
            if (dom3 == null) {
                append(dom2, dom);
            } else {
                insert(dom2, dom3);
            }
            Dom domNextSibling3 = nextSibling(dom2);
            for (int i = 0; i < arrayList.size(); i++) {
                Dom dom4 = (Dom) arrayList.get(i);
                if (domNextSibling3 == null) {
                    append(dom4, dom);
                } else {
                    insert(dom4, domNextSibling3);
                }
            }
        }
        return dom2;
    }

    public static void node_normalize(Dom dom) {
        switch (dom.nodeType()) {
            case 3:
            case 4:
            case 7:
            case 8:
                return;
            case 5:
                throw new RuntimeException("Not impl");
            case 6:
            case 10:
            case 12:
                throw new RuntimeException("Not impl");
            case 9:
            case 11:
            default:
                Cur curTempCur = dom.tempCur();
                curTempCur.push();
                do {
                    curTempCur.nextWithAttrs();
                    CharNode charNodes = curTempCur.getCharNodes();
                    if (charNodes != null) {
                        if (!curTempCur.isText()) {
                            while (charNodes != null) {
                                charNodes.setChars(null, 0, 0);
                                charNodes = CharNode.remove(charNodes, charNodes);
                            }
                        } else if (charNodes._next != null) {
                            while (charNodes._next != null) {
                                charNodes.setChars(null, 0, 0);
                                charNodes = CharNode.remove(charNodes, charNodes._next);
                            }
                            charNodes._cch = Integer.MAX_VALUE;
                        }
                        curTempCur.setCharNodes(charNodes);
                    }
                } while (!curTempCur.isAtEndOfLastPush());
                curTempCur.release();
                dom.locale().invalidateDomCaches(dom);
                return;
        }
    }

    public static Dom node_removeChild(Dom dom, Dom dom2) {
        if (parent(dom2) != dom) {
            throw new NotFoundErr("Child to remove is not a child of given parent");
        }
        switch (dom2.nodeType()) {
            case 1:
            case 7:
            case 8:
                removeNode(dom2);
                return dom2;
            case 2:
            case 9:
            case 11:
                throw new IllegalStateException();
            case 3:
            case 4:
                Cur curTempCur = dom2.tempCur();
                CharNode charNodes = curTempCur.getCharNodes();
                CharNode charNode = (CharNode) dom2;
                if (!$assertionsDisabled && !(charNode._src instanceof Dom)) {
                    throw new AssertionError();
                }
                charNode.setChars(curTempCur.moveChars(null, charNode._cch), curTempCur._offSrc, curTempCur._cchSrc);
                curTempCur.setCharNodes(CharNode.remove(charNodes, charNode));
                curTempCur.release();
                return dom2;
            case 5:
                throw new RuntimeException("Not impl");
            case 6:
            case 10:
            case 12:
                throw new RuntimeException("Not impl");
            default:
                throw new RuntimeException("Unknown kind");
        }
    }

    public static Dom node_replaceChild(Dom dom, Dom dom2, Dom dom3) {
        Dom domNode_getNextSibling = node_getNextSibling(dom3);
        node_removeChild(dom, dom3);
        try {
            node_insertBefore(dom, dom2, domNode_getNextSibling);
            return dom3;
        } catch (DOMException e) {
            node_insertBefore(dom, dom3, domNode_getNextSibling);
            throw e;
        }
    }

    public static void node_setNodeValue(Dom dom, String str) {
        if (str == null) {
            str = "";
        }
        int iNodeType = dom.nodeType();
        if (iNodeType == 2) {
            NodeList childNodes = ((Node) dom).getChildNodes();
            while (childNodes.getLength() > 1) {
                node_removeChild(dom, (Dom) childNodes.item(1));
            }
            if (childNodes.getLength() == 0) {
                TextNode textNodeCreateTextNode = dom.locale().createTextNode();
                textNodeCreateTextNode.setChars(str, 0, str.length());
                node_insertBefore(dom, textNodeCreateTextNode, null);
            } else {
                if (!$assertionsDisabled && childNodes.getLength() != 1) {
                    throw new AssertionError();
                }
                childNodes.item(0).setNodeValue(str);
            }
            if (((Xobj.AttrXobj) dom).isId()) {
                Dom domNode_getOwnerDocument = node_getOwnerDocument(dom);
                String strNode_getNodeValue = node_getNodeValue(dom);
                if (domNode_getOwnerDocument instanceof Xobj.DocumentXobj) {
                    Xobj.DocumentXobj documentXobj = (Xobj.DocumentXobj) domNode_getOwnerDocument;
                    documentXobj.removeIdElement(strNode_getNodeValue);
                    documentXobj.addIdElement(str, attr_getOwnerElement(dom));
                    return;
                }
                return;
            }
            return;
        }
        if (iNodeType == 3 || iNodeType == 4) {
            CharNode charNode = (CharNode) dom;
            Cur curTempCur = charNode.tempCur();
            if (curTempCur == null) {
                charNode.setChars(str, 0, str.length());
                return;
            }
            curTempCur.moveChars(null, charNode._cch);
            charNode._cch = str.length();
            curTempCur.insertString(str);
            curTempCur.release();
            return;
        }
        if (iNodeType == 7 || iNodeType == 8) {
            Cur curTempCur2 = dom.tempCur();
            curTempCur2.next();
            curTempCur2.getChars(-1);
            curTempCur2.moveChars(null, curTempCur2._cchSrc);
            curTempCur2.insertString(str);
            curTempCur2.release();
        }
    }

    public static void node_setPrefix(Dom dom, String str) {
        if (dom.nodeType() != 1 && dom.nodeType() != 2) {
            validatePrefix(str, "", "", false);
            return;
        }
        Cur curTempCur = dom.tempCur();
        QName name = curTempCur.getName();
        String namespaceURI = name.getNamespaceURI();
        String localPart = name.getLocalPart();
        curTempCur.setName(dom.locale().makeQName(namespaceURI, localPart, validatePrefix(str, namespaceURI, localPart, dom.nodeType() == 2)));
        curTempCur.release();
    }

    public static Dom parent(Dom dom) {
        return node_getParentNode(dom);
    }

    public static Dom prevSibling(Dom dom) {
        return node_getPreviousSibling(dom);
    }

    public static Dom remove(Dom dom) {
        Dom domParent = parent(dom);
        if (domParent != null) {
            node_removeChild(domParent, dom);
        }
        return dom;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void removeNode(Dom dom) {
        CharNode charNodes;
        if (!$assertionsDisabled && (dom.nodeType() == 3 || dom.nodeType() == 4)) {
            throw new AssertionError();
        }
        Cur curTempCur = dom.tempCur();
        curTempCur.toEnd();
        if (curTempCur.next() && (charNodes = curTempCur.getCharNodes()) != null) {
            curTempCur.setCharNodes(null);
            Cur curTempCur2 = dom.tempCur();
            curTempCur2.setCharNodes(CharNode.appendNodes(curTempCur2.getCharNodes(), charNodes));
            curTempCur2.release();
        }
        curTempCur.release();
        Cur.moveNode((Xobj) dom, null);
    }

    public static Element saajCallback_createSoapElement(Dom dom, QName qName, QName qName2) {
        Dom domImpl_saajCallback_createSoapElement;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                domImpl_saajCallback_createSoapElement = impl_saajCallback_createSoapElement(dom, qName, qName2);
            } finally {
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    domImpl_saajCallback_createSoapElement = impl_saajCallback_createSoapElement(dom, qName, qName2);
                    locale.exit();
                } finally {
                }
            }
        }
        return (Element) domImpl_saajCallback_createSoapElement;
    }

    public static org.w3c.dom.Text saajCallback_ensureSoapTextNode(Dom dom) {
        org.w3c.dom.Text textImpl_saajCallback_ensureSoapTextNode;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                return impl_saajCallback_ensureSoapTextNode(dom);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    textImpl_saajCallback_ensureSoapTextNode = impl_saajCallback_ensureSoapTextNode(dom);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return textImpl_saajCallback_ensureSoapTextNode;
    }

    public static Object saajCallback_getSaajData(Dom dom) {
        Object objImpl_saajCallback_getSaajData;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                return impl_saajCallback_getSaajData(dom);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    objImpl_saajCallback_getSaajData = impl_saajCallback_getSaajData(dom);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return objImpl_saajCallback_getSaajData;
    }

    public static Element saajCallback_importSoapElement(Dom dom, Element element, boolean z, QName qName) {
        Dom domImpl_saajCallback_importSoapElement;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                domImpl_saajCallback_importSoapElement = impl_saajCallback_importSoapElement(dom, element, z, qName);
            } finally {
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    domImpl_saajCallback_importSoapElement = impl_saajCallback_importSoapElement(dom, element, z, qName);
                    locale.exit();
                } finally {
                }
            }
        }
        return (Element) domImpl_saajCallback_importSoapElement;
    }

    public static void saajCallback_setSaajData(Dom dom, Object obj) {
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                impl_saajCallback_setSaajData(dom, obj);
            } finally {
            }
        } else {
            synchronized (locale) {
                try {
                    locale.enter();
                    try {
                        impl_saajCallback_setSaajData(dom, obj);
                    } finally {
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static SOAPBodyElement soapBody_addBodyElement(Dom dom, Name name) {
        SOAPBodyElement sOAPBodyElementSoapBody_addBodyElement;
        Locale locale = dom.locale();
        SOAPBody sOAPBody = (SOAPBody) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapBody_addBodyElement(sOAPBody, name);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    sOAPBodyElementSoapBody_addBodyElement = locale._saaj.soapBody_addBodyElement(sOAPBody, name);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sOAPBodyElementSoapBody_addBodyElement;
    }

    public static SOAPBodyElement soapBody_addDocument(Dom dom, Document document) {
        SOAPBodyElement sOAPBodyElementSoapBody_addDocument;
        Locale locale = dom.locale();
        SOAPBody sOAPBody = (SOAPBody) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapBody_addDocument(sOAPBody, document);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    sOAPBodyElementSoapBody_addDocument = locale._saaj.soapBody_addDocument(sOAPBody, document);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sOAPBodyElementSoapBody_addDocument;
    }

    public static SOAPFault soapBody_addFault(Dom dom) {
        SOAPFault sOAPFaultSoapBody_addFault;
        Locale locale = dom.locale();
        SOAPBody sOAPBody = (SOAPBody) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapBody_addFault(sOAPBody);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    sOAPFaultSoapBody_addFault = locale._saaj.soapBody_addFault(sOAPBody);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sOAPFaultSoapBody_addFault;
    }

    public static SOAPFault soapBody_getFault(Dom dom) {
        SOAPFault sOAPFaultSoapBody_getFault;
        Locale locale = dom.locale();
        SOAPBody sOAPBody = (SOAPBody) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapBody_getFault(sOAPBody);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    sOAPFaultSoapBody_getFault = locale._saaj.soapBody_getFault(sOAPBody);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sOAPFaultSoapBody_getFault;
    }

    public static boolean soapBody_hasFault(Dom dom) {
        boolean zSoapBody_hasFault;
        Locale locale = dom.locale();
        SOAPBody sOAPBody = (SOAPBody) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapBody_hasFault(sOAPBody);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    zSoapBody_hasFault = locale._saaj.soapBody_hasFault(sOAPBody);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zSoapBody_hasFault;
    }

    public static Detail soapFault_addDetail(Dom dom) {
        Detail detailSoapFault_addDetail;
        Locale locale = dom.locale();
        SOAPFault sOAPFault = (SOAPFault) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapFault_addDetail(sOAPFault);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    detailSoapFault_addDetail = locale._saaj.soapFault_addDetail(sOAPFault);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return detailSoapFault_addDetail;
    }

    public static Detail soapFault_getDetail(Dom dom) {
        Detail detailSoapFault_getDetail;
        Locale locale = dom.locale();
        SOAPFault sOAPFault = (SOAPFault) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapFault_getDetail(sOAPFault);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    detailSoapFault_getDetail = locale._saaj.soapFault_getDetail(sOAPFault);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return detailSoapFault_getDetail;
    }

    public static String soapFault_getFaultActor(Dom dom) {
        String strSoapFault_getFaultActor;
        Locale locale = dom.locale();
        SOAPFault sOAPFault = (SOAPFault) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapFault_getFaultActor(sOAPFault);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    strSoapFault_getFaultActor = locale._saaj.soapFault_getFaultActor(sOAPFault);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return strSoapFault_getFaultActor;
    }

    public static String soapFault_getFaultCode(Dom dom) {
        String strSoapFault_getFaultCode;
        Locale locale = dom.locale();
        SOAPFault sOAPFault = (SOAPFault) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapFault_getFaultCode(sOAPFault);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    strSoapFault_getFaultCode = locale._saaj.soapFault_getFaultCode(sOAPFault);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return strSoapFault_getFaultCode;
    }

    public static Name soapFault_getFaultCodeAsName(Dom dom) {
        Name nameSoapFault_getFaultCodeAsName;
        Locale locale = dom.locale();
        SOAPFault sOAPFault = (SOAPFault) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapFault_getFaultCodeAsName(sOAPFault);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    nameSoapFault_getFaultCodeAsName = locale._saaj.soapFault_getFaultCodeAsName(sOAPFault);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return nameSoapFault_getFaultCodeAsName;
    }

    public static String soapFault_getFaultString(Dom dom) {
        String strSoapFault_getFaultString;
        Locale locale = dom.locale();
        SOAPFault sOAPFault = (SOAPFault) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapFault_getFaultString(sOAPFault);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    strSoapFault_getFaultString = locale._saaj.soapFault_getFaultString(sOAPFault);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return strSoapFault_getFaultString;
    }

    public static java.util.Locale soapFault_getFaultStringLocale(Dom dom) {
        java.util.Locale localeSoapFault_getFaultStringLocale;
        Locale locale = dom.locale();
        SOAPFault sOAPFault = (SOAPFault) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapFault_getFaultStringLocale(sOAPFault);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    localeSoapFault_getFaultStringLocale = locale._saaj.soapFault_getFaultStringLocale(sOAPFault);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return localeSoapFault_getFaultStringLocale;
    }

    public static void soapFault_setFaultActor(Dom dom, String str) {
        Locale locale = dom.locale();
        SOAPFault sOAPFault = (SOAPFault) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                locale._saaj.soapFault_setFaultActor(sOAPFault, str);
            } finally {
            }
        } else {
            synchronized (locale) {
                try {
                    locale.enter();
                    try {
                        locale._saaj.soapFault_setFaultActor(sOAPFault, str);
                    } finally {
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static void soapFault_setFaultCode(Dom dom, Name name) {
        Locale locale = dom.locale();
        SOAPFault sOAPFault = (SOAPFault) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                locale._saaj.soapFault_setFaultCode(sOAPFault, name);
            } finally {
            }
        } else {
            synchronized (locale) {
                try {
                    locale.enter();
                    try {
                        locale._saaj.soapFault_setFaultCode(sOAPFault, name);
                    } finally {
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static void soapFault_setFaultString(Dom dom, String str) {
        Locale locale = dom.locale();
        SOAPFault sOAPFault = (SOAPFault) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                locale._saaj.soapFault_setFaultString(sOAPFault, str);
            } finally {
            }
        } else {
            synchronized (locale) {
                try {
                    locale.enter();
                    try {
                        locale._saaj.soapFault_setFaultString(sOAPFault, str);
                    } finally {
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static String soapHeaderElement_getActor(Dom dom) {
        String strSoapHeaderElement_getActor;
        Locale locale = dom.locale();
        SOAPHeaderElement sOAPHeaderElement = (SOAPHeaderElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapHeaderElement_getActor(sOAPHeaderElement);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    strSoapHeaderElement_getActor = locale._saaj.soapHeaderElement_getActor(sOAPHeaderElement);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return strSoapHeaderElement_getActor;
    }

    public static boolean soapHeaderElement_getMustUnderstand(Dom dom) {
        boolean zSoapHeaderElement_getMustUnderstand;
        Locale locale = dom.locale();
        SOAPHeaderElement sOAPHeaderElement = (SOAPHeaderElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapHeaderElement_getMustUnderstand(sOAPHeaderElement);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    zSoapHeaderElement_getMustUnderstand = locale._saaj.soapHeaderElement_getMustUnderstand(sOAPHeaderElement);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zSoapHeaderElement_getMustUnderstand;
    }

    public static void soapHeaderElement_setActor(Dom dom, String str) {
        Locale locale = dom.locale();
        SOAPHeaderElement sOAPHeaderElement = (SOAPHeaderElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                locale._saaj.soapHeaderElement_setActor(sOAPHeaderElement, str);
            } finally {
            }
        } else {
            synchronized (locale) {
                try {
                    locale.enter();
                    try {
                        locale._saaj.soapHeaderElement_setActor(sOAPHeaderElement, str);
                    } finally {
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static void soapHeaderElement_setMustUnderstand(Dom dom, boolean z) {
        Locale locale = dom.locale();
        SOAPHeaderElement sOAPHeaderElement = (SOAPHeaderElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                locale._saaj.soapHeaderElement_setMustUnderstand(sOAPHeaderElement, z);
            } finally {
            }
        } else {
            synchronized (locale) {
                try {
                    locale.enter();
                    try {
                        locale._saaj.soapHeaderElement_setMustUnderstand(sOAPHeaderElement, z);
                    } finally {
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static SOAPHeaderElement soapHeader_addHeaderElement(Dom dom, Name name) {
        SOAPHeaderElement sOAPHeaderElementSoapHeader_addHeaderElement;
        Locale locale = dom.locale();
        SOAPHeader sOAPHeader = (SOAPHeader) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapHeader_addHeaderElement(sOAPHeader, name);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    sOAPHeaderElementSoapHeader_addHeaderElement = locale._saaj.soapHeader_addHeaderElement(sOAPHeader, name);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sOAPHeaderElementSoapHeader_addHeaderElement;
    }

    public static Iterator soapHeader_examineAllHeaderElements(Dom dom) {
        Iterator itSoapHeader_examineAllHeaderElements;
        Locale locale = dom.locale();
        SOAPHeader sOAPHeader = (SOAPHeader) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapHeader_examineAllHeaderElements(sOAPHeader);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    itSoapHeader_examineAllHeaderElements = locale._saaj.soapHeader_examineAllHeaderElements(sOAPHeader);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return itSoapHeader_examineAllHeaderElements;
    }

    public static Iterator soapHeader_examineHeaderElements(Dom dom, String str) {
        Iterator itSoapHeader_examineHeaderElements;
        Locale locale = dom.locale();
        SOAPHeader sOAPHeader = (SOAPHeader) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapHeader_examineHeaderElements(sOAPHeader, str);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    itSoapHeader_examineHeaderElements = locale._saaj.soapHeader_examineHeaderElements(sOAPHeader, str);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return itSoapHeader_examineHeaderElements;
    }

    public static Iterator soapHeader_examineMustUnderstandHeaderElements(Dom dom, String str) {
        Iterator itSoapHeader_examineMustUnderstandHeaderElements;
        Locale locale = dom.locale();
        SOAPHeader sOAPHeader = (SOAPHeader) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapHeader_examineMustUnderstandHeaderElements(sOAPHeader, str);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    itSoapHeader_examineMustUnderstandHeaderElements = locale._saaj.soapHeader_examineMustUnderstandHeaderElements(sOAPHeader, str);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return itSoapHeader_examineMustUnderstandHeaderElements;
    }

    public static Iterator soapHeader_extractAllHeaderElements(Dom dom) {
        Iterator itSoapHeader_extractAllHeaderElements;
        Locale locale = dom.locale();
        SOAPHeader sOAPHeader = (SOAPHeader) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapHeader_extractAllHeaderElements(sOAPHeader);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    itSoapHeader_extractAllHeaderElements = locale._saaj.soapHeader_extractAllHeaderElements(sOAPHeader);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return itSoapHeader_extractAllHeaderElements;
    }

    public static Iterator soapHeader_extractHeaderElements(Dom dom, String str) {
        Iterator itSoapHeader_extractHeaderElements;
        Locale locale = dom.locale();
        SOAPHeader sOAPHeader = (SOAPHeader) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapHeader_extractHeaderElements(sOAPHeader, str);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    itSoapHeader_extractHeaderElements = locale._saaj.soapHeader_extractHeaderElements(sOAPHeader, str);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return itSoapHeader_extractHeaderElements;
    }

    private static void validateName(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Name is null");
        }
        if (str.length() == 0) {
            throw new IllegalArgumentException("Name is empty");
        }
        if (!XMLChar.isValidName(str)) {
            throw new InvalidCharacterError("Name has an invalid character");
        }
    }

    private static void validateNcName(String str) {
        if (str != null && str.length() > 0 && !XMLChar.isValidNCName(str)) {
            throw new InvalidCharacterError();
        }
    }

    private static void validateNewChild(Dom dom, Dom dom2) {
        String strIsValidChild = isValidChild(dom, dom2);
        if (strIsValidChild != null) {
            throw new HierarchyRequestErr(strIsValidChild);
        }
        if (dom == dom2) {
            throw new HierarchyRequestErr("New child and parent are the same node");
        }
        do {
            dom = parent(dom);
            if (dom == null) {
                return;
            }
            if (dom2.nodeType() == 5) {
                throw new NoModificationAllowedErr("Entity reference trees may not be modified");
            }
        } while (dom2 != dom);
        throw new HierarchyRequestErr("New child is an ancestor node of the parent node");
    }

    private static String validatePrefix(String str, String str2, String str3, boolean z) {
        validateNcName(str);
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        if (str.length() > 0 && str2.length() == 0) {
            throw new NamespaceErr("Attempt to give a prefix for no namespace");
        }
        if (str.equals("xml") && !str2.equals("http://www.w3.org/XML/1998/namespace")) {
            throw new NamespaceErr("Invalid prefix - begins with 'xml'");
        }
        if (z) {
            if (str.length() > 0) {
                if (str3.equals(XMLConstants.XMLNS_ATTRIBUTE)) {
                    throw new NamespaceErr("Invalid namespace - attr is default namespace already");
                }
                if (Locale.beginsWithXml(str3)) {
                    throw new NamespaceErr("Invalid namespace - attr prefix begins with 'xml'");
                }
                if (str.equals(XMLConstants.XMLNS_ATTRIBUTE) && !str2.equals("http://www.w3.org/2000/xmlns/")) {
                    throw new NamespaceErr("Invalid namespace - uri is not 'http://www.w3.org/2000/xmlns/;");
                }
            } else if (str3.equals(XMLConstants.XMLNS_ATTRIBUTE) && !str2.equals("http://www.w3.org/2000/xmlns/")) {
                throw new NamespaceErr("Invalid namespace - uri is not 'http://www.w3.org/2000/xmlns/;");
            }
        } else if (Locale.beginsWithXml(str)) {
            throw new NamespaceErr("Invalid prefix - begins with 'xml'");
        }
        return str;
    }

    private static void validateQualifiedName(String str, String str2, boolean z) {
        if (!$assertionsDisabled && str == null) {
            throw new AssertionError();
        }
        if (str2 == null) {
            str2 = "";
        }
        int iIndexOf = str.indexOf(58);
        if (iIndexOf < 0) {
            validateNcName(str);
            if (z && str.equals(XMLConstants.XMLNS_ATTRIBUTE) && !str2.equals("http://www.w3.org/2000/xmlns/")) {
                throw new NamespaceErr("Default xmlns attribute does not have namespace: http://www.w3.org/2000/xmlns/");
            }
        } else {
            if (iIndexOf == 0) {
                throw new NamespaceErr("Invalid qualified name, no prefix specified");
            }
            String strSubstring = str.substring(0, iIndexOf);
            validateNcName(strSubstring);
            if (str2.length() == 0) {
                throw new NamespaceErr("Attempt to give a prefix for no namespace");
            }
            str = str.substring(iIndexOf + 1);
            if (str.indexOf(58) >= 0) {
                throw new NamespaceErr("Invalid qualified name, more than one colon");
            }
            validateNcName(str);
            if (strSubstring.equals("xml") && !str2.equals("http://www.w3.org/XML/1998/namespace")) {
                throw new NamespaceErr("Invalid prefix - begins with 'xml'");
            }
        }
        if (str.length() == 0) {
            throw new NamespaceErr("Invalid qualified name, no local part specified");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class CharNode implements Dom, Node, CharacterData {
        static final /* synthetic */ boolean $assertionsDisabled;
        int _cch;
        private Locale _locale;
        CharNode _next;
        int _off;
        CharNode _prev;
        private Object _src;

        static {
            if (DomImpl.class$org$apache$xmlbeans$impl$store$DomImpl == null) {
                DomImpl.class$org$apache$xmlbeans$impl$store$DomImpl = DomImpl.class$("org.apache.xmlbeans.impl.store.DomImpl");
            }
            $assertionsDisabled = true;
        }

        public CharNode(Locale locale) {
            if (!$assertionsDisabled && locale == null) {
                throw new AssertionError();
            }
            this._locale = locale;
        }

        public static CharNode appendNode(CharNode charNode, CharNode charNode2) {
            return insertNode(charNode, charNode2, null);
        }

        public static CharNode appendNodes(CharNode charNode, CharNode charNode2) {
            boolean z = $assertionsDisabled;
            if (!z && charNode2 == null) {
                throw new AssertionError();
            }
            if (!z && charNode2._prev != null) {
                throw new AssertionError();
            }
            if (charNode == null) {
                return charNode2;
            }
            CharNode charNode3 = charNode;
            while (true) {
                CharNode charNode4 = charNode3._next;
                if (charNode4 == null) {
                    charNode3._next = charNode2;
                    charNode2._prev = charNode3;
                    return charNode;
                }
                charNode3 = charNode4;
            }
        }

        public static CharNode copyNodes(CharNode charNode, Object obj) {
            TextNode textNode = null;
            TextNode textNode2 = null;
            while (charNode != null) {
                TextNode textNodeCreateTextNode = charNode instanceof TextNode ? charNode.locale().createTextNode() : charNode.locale().createCdataNode();
                textNodeCreateTextNode.setChars(obj, charNode._off, charNode._cch);
                if (textNode == null) {
                    textNode = textNodeCreateTextNode;
                }
                if (textNode2 != null) {
                    textNode2._next = textNodeCreateTextNode;
                    textNodeCreateTextNode._prev = textNode2;
                }
                charNode = charNode._next;
                textNode2 = textNodeCreateTextNode;
            }
            return textNode;
        }

        public static CharNode insertNode(CharNode charNode, CharNode charNode2, CharNode charNode3) {
            CharNode charNode4;
            boolean z = $assertionsDisabled;
            if (!z && isOnList(charNode, charNode2)) {
                throw new AssertionError();
            }
            if (!z && charNode3 != null && !isOnList(charNode, charNode3)) {
                throw new AssertionError();
            }
            if (!z && charNode2 == null) {
                throw new AssertionError();
            }
            if (!z && (charNode2._prev != null || charNode2._next != null)) {
                throw new AssertionError();
            }
            if (charNode == null) {
                if (z || charNode3 == null) {
                    return charNode2;
                }
                throw new AssertionError();
            }
            if (charNode == charNode3) {
                charNode._prev = charNode2;
                charNode2._next = charNode;
                return charNode2;
            }
            CharNode charNode5 = charNode;
            while (true) {
                charNode4 = charNode5._next;
                if (charNode4 == charNode3) {
                    break;
                }
                charNode5 = charNode4;
            }
            charNode2._next = charNode4;
            if (charNode4 != null) {
                charNode5._next._prev = charNode2;
            }
            charNode2._prev = charNode5;
            charNode5._next = charNode2;
            return charNode;
        }

        public static boolean isOnList(CharNode charNode, CharNode charNode2) {
            if (!$assertionsDisabled && charNode2 == null) {
                throw new AssertionError();
            }
            while (charNode != null) {
                if (charNode == charNode2) {
                    return true;
                }
                charNode = charNode._next;
            }
            return false;
        }

        private boolean isValid() {
            return this._src instanceof Dom ? this._locale == null : this._locale != null;
        }

        public static CharNode remove(CharNode charNode, CharNode charNode2) {
            if (!$assertionsDisabled && !isOnList(charNode, charNode2)) {
                throw new AssertionError();
            }
            if (charNode == charNode2) {
                charNode = charNode2._next;
            } else {
                charNode2._prev._next = charNode2._next;
            }
            CharNode charNode3 = charNode2._next;
            if (charNode3 != null) {
                charNode3._prev = charNode2._prev;
            }
            charNode2._next = null;
            charNode2._prev = null;
            return charNode;
        }

        @Override // org.w3c.dom.Node
        public Node appendChild(Node node) {
            return DomImpl._node_appendChild(this, node);
        }

        @Override // org.w3c.dom.CharacterData
        public void appendData(String str) {
            DomImpl._characterData_appendData(this, str);
        }

        @Override // org.w3c.dom.Node
        public Node cloneNode(boolean z) {
            return DomImpl._node_cloneNode(this, z);
        }

        @Override // org.w3c.dom.Node
        public short compareDocumentPosition(Node node) {
            return DomImpl._node_compareDocumentPosition(this, node);
        }

        @Override // org.w3c.dom.CharacterData
        public void deleteData(int i, int i2) {
            DomImpl._characterData_deleteData(this, i, i2);
        }

        @Override // org.apache.xmlbeans.impl.store.DomImpl.Dom
        public void dump(PrintStream printStream, Object obj) {
            Object obj2 = this._src;
            if (obj2 instanceof Dom) {
                ((Dom) obj2).dump(printStream, obj);
                return;
            }
            StringBuffer stringBuffer = new StringBuffer("Lonely CharNode: \"");
            stringBuffer.append(CharUtil.getString(this._src, this._off, this._cch));
            stringBuffer.append("\"");
            printStream.println(stringBuffer.toString());
        }

        @Override // org.w3c.dom.Node
        public NamedNodeMap getAttributes() {
            return null;
        }

        @Override // org.w3c.dom.Node
        public String getBaseURI() {
            return DomImpl._node_getBaseURI(this);
        }

        @Override // org.w3c.dom.Node
        public NodeList getChildNodes() {
            return DomImpl._emptyNodeList;
        }

        @Override // org.w3c.dom.CharacterData
        public String getData() {
            return DomImpl._characterData_getData(this);
        }

        public Dom getDom() {
            if (!$assertionsDisabled && !isValid()) {
                throw new AssertionError();
            }
            Object obj = this._src;
            if (obj instanceof Dom) {
                return (Dom) obj;
            }
            return null;
        }

        @Override // org.w3c.dom.Node
        public Object getFeature(String str, String str2) {
            return DomImpl._node_getFeature(this, str, str2);
        }

        @Override // org.w3c.dom.Node
        public Node getFirstChild() {
            return null;
        }

        @Override // org.w3c.dom.Node
        public Node getLastChild() {
            return null;
        }

        @Override // org.w3c.dom.CharacterData
        public int getLength() {
            return DomImpl._characterData_getLength(this);
        }

        @Override // org.w3c.dom.Node
        public String getLocalName() {
            return DomImpl._node_getLocalName(this);
        }

        @Override // org.w3c.dom.Node
        public String getNamespaceURI() {
            return DomImpl._node_getNamespaceURI(this);
        }

        @Override // org.w3c.dom.Node
        public Node getNextSibling() {
            return DomImpl._node_getNextSibling(this);
        }

        @Override // org.w3c.dom.Node
        public String getNodeName() {
            return DomImpl._node_getNodeName(this);
        }

        @Override // org.w3c.dom.Node
        public short getNodeType() {
            return DomImpl._node_getNodeType(this);
        }

        @Override // org.w3c.dom.Node
        public String getNodeValue() {
            return DomImpl._node_getNodeValue(this);
        }

        @Override // org.w3c.dom.Node
        public Document getOwnerDocument() {
            return DomImpl._node_getOwnerDocument(this);
        }

        @Override // org.w3c.dom.Node
        public Node getParentNode() {
            return DomImpl._node_getParentNode(this);
        }

        @Override // org.w3c.dom.Node
        public String getPrefix() {
            return DomImpl._node_getPrefix(this);
        }

        @Override // org.w3c.dom.Node
        public Node getPreviousSibling() {
            return DomImpl._node_getPreviousSibling(this);
        }

        @Override // org.apache.xmlbeans.impl.store.DomImpl.Dom
        public QName getQName() {
            return null;
        }

        @Override // org.w3c.dom.Node
        public String getTextContent() {
            return DomImpl._node_getTextContent(this);
        }

        @Override // org.w3c.dom.Node
        public Object getUserData(String str) {
            return DomImpl._node_getUserData(this, str);
        }

        @Override // org.w3c.dom.Node
        public boolean hasAttributes() {
            return false;
        }

        @Override // org.w3c.dom.Node
        public boolean hasChildNodes() {
            return false;
        }

        @Override // org.w3c.dom.Node
        public Node insertBefore(Node node, Node node2) {
            return DomImpl._node_insertBefore(this, node, node2);
        }

        @Override // org.w3c.dom.CharacterData
        public void insertData(int i, String str) {
            DomImpl._characterData_insertData(this, i, str);
        }

        @Override // org.w3c.dom.Node
        public boolean isDefaultNamespace(String str) {
            return DomImpl._node_isDefaultNamespace(this, str);
        }

        @Override // org.w3c.dom.Node
        public boolean isEqualNode(Node node) {
            return DomImpl._node_isEqualNode(this, node);
        }

        public boolean isNodeAftertext() {
            if (!$assertionsDisabled && !(this._src instanceof Xobj)) {
                throw new AssertionError("this method is to only be used for nodes backed up by Xobjs");
            }
            Xobj xobj = (Xobj) this._src;
            if (xobj._charNodesValue == null) {
                return true;
            }
            CharNode charNode = xobj._charNodesAfter;
            if (charNode == null) {
                return false;
            }
            return isOnList(charNode, this);
        }

        @Override // org.w3c.dom.Node
        public boolean isSameNode(Node node) {
            return DomImpl._node_isSameNode(this, node);
        }

        @Override // org.w3c.dom.Node
        public boolean isSupported(String str, String str2) {
            return DomImpl._node_isSupported(this, str, str2);
        }

        @Override // org.apache.xmlbeans.impl.store.DomImpl.Dom
        public Locale locale() {
            if (!$assertionsDisabled && !isValid()) {
                throw new AssertionError();
            }
            Locale locale = this._locale;
            return locale == null ? ((Dom) this._src).locale() : locale;
        }

        @Override // org.w3c.dom.Node
        public String lookupNamespaceURI(String str) {
            return DomImpl._node_lookupNamespaceURI(this, str);
        }

        @Override // org.w3c.dom.Node
        public String lookupPrefix(String str) {
            return DomImpl._node_lookupPrefix(this, str);
        }

        @Override // org.apache.xmlbeans.impl.store.DomImpl.Dom
        public boolean nodeCanHavePrefixUri() {
            return false;
        }

        @Override // org.w3c.dom.Node
        public void normalize() {
            DomImpl._node_normalize(this);
        }

        @Override // org.w3c.dom.Node
        public Node removeChild(Node node) {
            return DomImpl._node_removeChild(this, node);
        }

        @Override // org.w3c.dom.Node
        public Node replaceChild(Node node, Node node2) {
            return DomImpl._node_replaceChild(this, node, node2);
        }

        @Override // org.w3c.dom.CharacterData
        public void replaceData(int i, int i2, String str) {
            DomImpl._characterData_replaceData(this, i, i2, str);
        }

        public void setChars(Object obj, int i, int i2) {
            boolean z = $assertionsDisabled;
            if (!z && !CharUtil.isValid(obj, i, i2)) {
                throw new AssertionError();
            }
            if (!z && this._locale == null && !(this._src instanceof Dom)) {
                throw new AssertionError();
            }
            if (this._locale == null) {
                this._locale = ((Dom) this._src).locale();
            }
            this._src = obj;
            this._off = i;
            this._cch = i2;
        }

        @Override // org.w3c.dom.CharacterData
        public void setData(String str) {
            DomImpl._characterData_setData(this, str);
        }

        public void setDom(Dom dom) {
            if (!$assertionsDisabled && dom == null) {
                throw new AssertionError();
            }
            this._src = dom;
            this._locale = null;
        }

        @Override // org.w3c.dom.Node
        public void setNodeValue(String str) {
            DomImpl._node_setNodeValue(this, str);
        }

        @Override // org.w3c.dom.Node
        public void setPrefix(String str) {
            DomImpl._node_setPrefix(this, str);
        }

        @Override // org.w3c.dom.Node
        public void setTextContent(String str) {
            DomImpl._node_setTextContent(this, str);
        }

        @Override // org.w3c.dom.Node
        public Object setUserData(String str, Object obj, UserDataHandler userDataHandler) {
            return DomImpl._node_setUserData(this, str, obj, userDataHandler);
        }

        @Override // org.w3c.dom.CharacterData
        public String substringData(int i, int i2) {
            return DomImpl._characterData_substringData(this, i, i2);
        }

        @Override // org.apache.xmlbeans.impl.store.DomImpl.Dom
        public Cur tempCur() {
            if (!$assertionsDisabled && !isValid()) {
                throw new AssertionError();
            }
            if (!(this._src instanceof Dom)) {
                return null;
            }
            Cur curTempCur = locale().tempCur();
            curTempCur.moveToCharNode(this);
            return curTempCur;
        }

        @Override // org.apache.xmlbeans.impl.store.DomImpl.Dom
        public void dump(PrintStream printStream) {
            dump(printStream, this);
        }

        @Override // org.apache.xmlbeans.impl.store.DomImpl.Dom
        public void dump() {
            dump(System.out);
        }
    }

    public static SOAPElement _soapElement_addChildElement(Dom dom, Name name) {
        SOAPElement sOAPElementSoapElement_addChildElement;
        Locale locale = dom.locale();
        SOAPElement sOAPElement = (SOAPElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapElement_addChildElement(sOAPElement, name);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    sOAPElementSoapElement_addChildElement = locale._saaj.soapElement_addChildElement(sOAPElement, name);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sOAPElementSoapElement_addChildElement;
    }

    public static Iterator _soapElement_getChildElements(Dom dom, Name name) {
        Iterator itSoapElement_getChildElements;
        Locale locale = dom.locale();
        SOAPElement sOAPElement = (SOAPElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapElement_getChildElements(sOAPElement, name);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    itSoapElement_getChildElements = locale._saaj.soapElement_getChildElements(sOAPElement, name);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return itSoapElement_getChildElements;
    }

    public static Name _soapEnvelope_createName(Dom dom, String str, String str2, String str3) {
        Name nameSoapEnvelope_createName;
        Locale locale = dom.locale();
        SOAPEnvelope sOAPEnvelope = (SOAPEnvelope) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapEnvelope_createName(sOAPEnvelope, str, str2, str3);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    nameSoapEnvelope_createName = locale._saaj.soapEnvelope_createName(sOAPEnvelope, str, str2, str3);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return nameSoapEnvelope_createName;
    }

    public static SOAPFault soapBody_addFault(Dom dom, Name name, String str) {
        SOAPFault sOAPFaultSoapBody_addFault;
        Locale locale = dom.locale();
        SOAPBody sOAPBody = (SOAPBody) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapBody_addFault(sOAPBody, name, str);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    sOAPFaultSoapBody_addFault = locale._saaj.soapBody_addFault(sOAPBody, name, str);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sOAPFaultSoapBody_addFault;
    }

    public static void soapFault_setFaultCode(Dom dom, String str) {
        Locale locale = dom.locale();
        SOAPFault sOAPFault = (SOAPFault) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                locale._saaj.soapFault_setFaultCode(sOAPFault, str);
            } finally {
            }
        } else {
            synchronized (locale) {
                try {
                    locale.enter();
                    try {
                        locale._saaj.soapFault_setFaultCode(sOAPFault, str);
                    } finally {
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static void soapFault_setFaultString(Dom dom, String str, java.util.Locale locale) {
        Locale locale2 = dom.locale();
        SOAPFault sOAPFault = (SOAPFault) dom;
        if (locale2.noSync()) {
            locale2.enter();
            try {
                locale2._saaj.soapFault_setFaultString(sOAPFault, str, locale);
            } finally {
            }
        } else {
            synchronized (locale2) {
                try {
                    locale2.enter();
                    try {
                        locale2._saaj.soapFault_setFaultString(sOAPFault, str, locale);
                    } finally {
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static SOAPElement _soapElement_addChildElement(Dom dom, String str) {
        SOAPElement sOAPElementSoapElement_addChildElement;
        Locale locale = dom.locale();
        SOAPElement sOAPElement = (SOAPElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapElement_addChildElement(sOAPElement, str);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    sOAPElementSoapElement_addChildElement = locale._saaj.soapElement_addChildElement(sOAPElement, str);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sOAPElementSoapElement_addChildElement;
    }

    public static SOAPFault soapBody_addFault(Dom dom, Name name, String str, java.util.Locale locale) {
        SOAPFault sOAPFaultSoapBody_addFault;
        Locale locale2 = dom.locale();
        SOAPBody sOAPBody = (SOAPBody) dom;
        if (locale2.noSync()) {
            locale2.enter();
            try {
                return locale2._saaj.soapBody_addFault(sOAPBody, name, str, locale);
            } finally {
            }
        }
        synchronized (locale2) {
            try {
                locale2.enter();
                try {
                    sOAPFaultSoapBody_addFault = locale2._saaj.soapBody_addFault(sOAPBody, name, str, locale);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sOAPFaultSoapBody_addFault;
    }

    public static SOAPElement _soapElement_addChildElement(Dom dom, String str, String str2) {
        SOAPElement sOAPElementSoapElement_addChildElement;
        Locale locale = dom.locale();
        SOAPElement sOAPElement = (SOAPElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapElement_addChildElement(sOAPElement, str, str2);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    sOAPElementSoapElement_addChildElement = locale._saaj.soapElement_addChildElement(sOAPElement, str, str2);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sOAPElementSoapElement_addChildElement;
    }

    public static SOAPElement _soapElement_addChildElement(Dom dom, String str, String str2, String str3) {
        SOAPElement sOAPElementSoapElement_addChildElement;
        Locale locale = dom.locale();
        SOAPElement sOAPElement = (SOAPElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapElement_addChildElement(sOAPElement, str, str2, str3);
            } finally {
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    sOAPElementSoapElement_addChildElement = locale._saaj.soapElement_addChildElement(sOAPElement, str, str2, str3);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sOAPElementSoapElement_addChildElement;
    }
}
