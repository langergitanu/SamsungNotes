package org.apache.xmlbeans.impl.store;

import androidx.appcompat.widget.AbstractC0541b;
import com.microsoft.identity.client.internal.MsalUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.text.Typography;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.poi.javax.xml.XMLConstants;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SystemProperties;
import org.apache.xmlbeans.XmlDocumentProperties;
import org.apache.xmlbeans.XmlOptionCharEscapeMap;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.common.EncodingMap;
import org.apache.xmlbeans.impl.common.GenericXmlInputStream;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.XmlEventBase;
import org.apache.xmlbeans.impl.common.XmlNameImpl;
import org.apache.xmlbeans.xml.stream.Attribute;
import org.apache.xmlbeans.xml.stream.AttributeIterator;
import org.apache.xmlbeans.xml.stream.ChangePrefixMapping;
import org.apache.xmlbeans.xml.stream.CharacterData;
import org.apache.xmlbeans.xml.stream.Comment;
import org.apache.xmlbeans.xml.stream.EndDocument;
import org.apache.xmlbeans.xml.stream.EndElement;
import org.apache.xmlbeans.xml.stream.EndPrefixMapping;
import org.apache.xmlbeans.xml.stream.Location;
import org.apache.xmlbeans.xml.stream.ProcessingInstruction;
import org.apache.xmlbeans.xml.stream.StartDocument;
import org.apache.xmlbeans.xml.stream.StartElement;
import org.apache.xmlbeans.xml.stream.StartPrefixMapping;
import org.apache.xmlbeans.xml.stream.XMLEvent;
import org.apache.xmlbeans.xml.stream.XMLName;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.ext.LexicalHandler;
import org.xml.sax.helpers.AttributesImpl;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
abstract class Saver {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int ATTR = 3;
    static final int COMMENT = 4;
    static final int ELEM = 2;
    static final int PROCINST = 5;
    static final int ROOT = 1;
    static final int TEXT = 0;
    static final String _newLine;
    private List _ancestorNamespaces;
    private ArrayList _attrNames;
    private ArrayList _attrValues;
    private SaveCur _cur;
    private int _currentMapping;
    private String _initialDefaultUri;
    private final Locale _locale;
    private ArrayList _namespaceStack;
    private Map _preComputedNamespaces;
    private HashMap _prefixMap;
    protected XmlOptionCharEscapeMap _replaceChar;
    private boolean _saveNamespacesFirst;
    private Map _suggestedPrefixes;
    private HashMap _uriMap;
    private boolean _useDefaultNamespace;
    private final long _version;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class DocSaveCur extends SaveCur {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private Cur _cur;

        public DocSaveCur(Cur cur) {
            this._cur = cur.weakCur(this);
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public List getAncestorNamespaces() {
            return null;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public String getAttrValue() {
            return this._cur.getValueAsString();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public Object getChars() {
            Object chars = this._cur.getChars(-1);
            Cur cur = this._cur;
            this._offSrc = cur._offSrc;
            this._cchSrc = cur._cchSrc;
            return chars;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public XmlDocumentProperties getDocProps() {
            return Locale.getDocProps(this._cur, false);
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public QName getName() {
            return this._cur.getName();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public String getXmlnsPrefix() {
            return this._cur.getXmlnsPrefix();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public String getXmlnsUri() {
            return this._cur.getXmlnsUri();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public boolean hasChildren() {
            return this._cur.hasChildren();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public boolean hasText() {
            return this._cur.hasText();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public boolean isTextCData() {
            return this._cur.isTextCData();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public boolean isXmlns() {
            return this._cur.isXmlns();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public int kind() {
            return this._cur.kind();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public boolean next() {
            return this._cur.next();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public void pop() {
            this._cur.pop();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public void push() {
            this._cur.push();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public void release() {
            this._cur.release();
            this._cur = null;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public void toEnd() {
            this._cur.toEnd();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public boolean toFirstAttr() {
            return this._cur.toFirstAttr();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public boolean toNextAttr() {
            return this._cur.toNextAttr();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class FilterPiSaveCur extends FilterSaveCur {
        private String _piTarget;

        public FilterPiSaveCur(SaveCur saveCur, String str) {
            super(saveCur);
            this._piTarget = str;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.FilterSaveCur
        public boolean filter() {
            return kind() == 5 && getName().getLocalPart().equals(this._piTarget);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class FilterSaveCur extends SaveCur {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private SaveCur _cur;

        public FilterSaveCur(SaveCur saveCur) {
            this._cur = saveCur;
        }

        public abstract boolean filter();

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public List getAncestorNamespaces() {
            return this._cur.getAncestorNamespaces();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public String getAttrValue() {
            return this._cur.getAttrValue();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public Object getChars() {
            Object chars = this._cur.getChars();
            SaveCur saveCur = this._cur;
            this._offSrc = saveCur._offSrc;
            this._cchSrc = saveCur._cchSrc;
            return chars;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public XmlDocumentProperties getDocProps() {
            return this._cur.getDocProps();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public QName getName() {
            return this._cur.getName();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public String getXmlnsPrefix() {
            return this._cur.getXmlnsPrefix();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public String getXmlnsUri() {
            return this._cur.getXmlnsUri();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public boolean hasChildren() {
            return this._cur.hasChildren();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public boolean hasText() {
            return this._cur.hasText();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public boolean isTextCData() {
            return this._cur.isTextCData();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public boolean isXmlns() {
            return this._cur.isXmlns();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public int kind() {
            return this._cur.kind();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public boolean next() {
            if (!this._cur.next()) {
                return false;
            }
            if (!filter()) {
                return true;
            }
            toEnd();
            return next();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public void pop() {
            this._cur.pop();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public void push() {
            this._cur.push();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public void release() {
            this._cur.release();
            this._cur = null;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public void toEnd() {
            this._cur.toEnd();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public boolean toFirstAttr() {
            return this._cur.toFirstAttr();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public boolean toNextAttr() {
            return this._cur.toNextAttr();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class FragSaveCur extends SaveCur {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final int CUR = 5;
        private static final int ELEM_END = 4;
        private static final int ELEM_START = 2;
        private static final int ROOT_END = 3;
        private static final int ROOT_START = 1;
        private ArrayList _ancestorNamespaces;
        private Cur _cur;
        private QName _elem;
        private Cur _end;
        private boolean _saveAttr;
        private int _state;
        private int[] _stateStack;
        private int _stateStackSize;

        public FragSaveCur(Cur cur, Cur cur2, QName qName) {
            this._saveAttr = cur.isAttr() && cur.isSamePos(cur2);
            this._cur = cur.weakCur(this);
            this._end = cur2.weakCur(this);
            this._elem = qName;
            this._state = 1;
            this._stateStack = new int[8];
            cur.push();
            computeAncestorNamespaces(cur);
            cur.pop();
        }

        private void computeAncestorNamespaces(Cur cur) {
            this._ancestorNamespaces = new ArrayList();
            while (cur.toParentRaw()) {
                if (cur.toFirstAttr()) {
                    do {
                        if (cur.isXmlns()) {
                            String xmlnsPrefix = cur.getXmlnsPrefix();
                            if (cur.getXmlnsUri().length() > 0 || xmlnsPrefix.length() == 0) {
                                this._ancestorNamespaces.add(cur.getXmlnsPrefix());
                                this._ancestorNamespaces.add(cur.getXmlnsUri());
                            }
                        }
                    } while (cur.toNextAttr());
                    cur.toParent();
                }
            }
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public List getAncestorNamespaces() {
            return this._ancestorNamespaces;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public String getAttrValue() {
            return this._cur.getValueAsString();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public Object getChars() {
            Object chars = this._cur.getChars(-1);
            Cur cur = this._cur;
            this._offSrc = cur._offSrc;
            this._cchSrc = cur._cchSrc;
            return chars;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public XmlDocumentProperties getDocProps() {
            return Locale.getDocProps(this._cur, false);
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public QName getName() {
            int i = this._state;
            if (i == 1) {
                return null;
            }
            if (i != 2) {
                if (i == 3) {
                    return null;
                }
                if (i != 4) {
                    return this._cur.getName();
                }
            }
            return this._elem;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public String getXmlnsPrefix() {
            return this._cur.getXmlnsPrefix();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public String getXmlnsUri() {
            return this._cur.getXmlnsUri();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public boolean hasChildren() {
            boolean z = false;
            if (isContainer()) {
                push();
                next();
                if (!isText() && !isFinish()) {
                    z = true;
                }
                pop();
            }
            return z;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public boolean hasText() {
            if (!isContainer()) {
                return false;
            }
            push();
            next();
            boolean zIsText = isText();
            pop();
            return zIsText;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public boolean isTextCData() {
            return this._cur.isTextCData();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public boolean isXmlns() {
            return this._cur.isXmlns();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public int kind() {
            int i = this._state;
            int i2 = 1;
            if (i != 1) {
                i2 = 2;
                if (i != 2) {
                    if (i == 3) {
                        return -1;
                    }
                    if (i != 4) {
                        return this._cur.kind();
                    }
                    return -2;
                }
            }
            return i2;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public boolean next() {
            int i = this._state;
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        return false;
                    }
                    if (i == 4) {
                        this._state = 3;
                    } else if (i == 5) {
                        this._cur.next();
                        if (this._cur.isSamePos(this._end)) {
                            this._state = this._elem == null ? 3 : 4;
                        }
                    }
                } else if (this._saveAttr) {
                    this._state = 4;
                } else {
                    if (this._cur.isAttr()) {
                        this._cur.toParent();
                        this._cur.next();
                    }
                    if (this._cur.isSamePos(this._end)) {
                        this._state = 4;
                    } else {
                        this._state = 5;
                    }
                }
            } else {
                this._state = this._elem == null ? 5 : 2;
            }
            return true;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public void pop() {
            this._cur.pop();
            int[] iArr = this._stateStack;
            int i = this._stateStackSize - 1;
            this._stateStackSize = i;
            this._state = iArr[i];
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public void push() {
            int i = this._stateStackSize;
            int[] iArr = this._stateStack;
            if (i == iArr.length) {
                int[] iArr2 = new int[i * 2];
                System.arraycopy(iArr, 0, iArr2, 0, i);
                this._stateStack = iArr2;
            }
            int[] iArr3 = this._stateStack;
            int i2 = this._stateStackSize;
            this._stateStackSize = i2 + 1;
            iArr3[i2] = this._state;
            this._cur.push();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public void release() {
            this._cur.release();
            this._cur = null;
            this._end.release();
            this._end = null;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public void toEnd() {
            int i = this._state;
            if (i == 1) {
                this._state = 3;
                return;
            }
            if (i == 2) {
                this._state = 4;
            } else {
                if (i == 3 || i == 4) {
                    return;
                }
                this._cur.toEnd();
            }
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public boolean toFirstAttr() {
            int i = this._state;
            if (i == 1 || i == 3 || i == 4) {
                return false;
            }
            if (i == 5) {
                return this._cur.toFirstAttr();
            }
            if (!this._cur.isAttr()) {
                return false;
            }
            this._state = 5;
            return true;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public boolean toNextAttr() {
            return !this._saveAttr && this._cur.toNextAttr();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class PrettySaveCur extends SaveCur {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private SaveCur _cur;
        private int _depth;
        private int _prettyIndent;
        private int _prettyOffset;
        private String _txt;
        private boolean _useCDataBookmarks;
        private StringBuffer _sb = new StringBuffer();
        private ArrayList _stack = new ArrayList();
        private boolean _isTextCData = false;

        public PrettySaveCur(SaveCur saveCur, XmlOptions xmlOptions) {
            this._useCDataBookmarks = false;
            this._cur = saveCur;
            this._prettyIndent = 2;
            if (xmlOptions.hasOption(XmlOptions.SAVE_PRETTY_PRINT_INDENT)) {
                this._prettyIndent = ((Integer) xmlOptions.get(XmlOptions.SAVE_PRETTY_PRINT_INDENT)).intValue();
            }
            if (xmlOptions.hasOption(XmlOptions.SAVE_PRETTY_PRINT_OFFSET)) {
                this._prettyOffset = ((Integer) xmlOptions.get(XmlOptions.SAVE_PRETTY_PRINT_OFFSET)).intValue();
            }
            if (xmlOptions.hasOption(XmlOptions.LOAD_SAVE_CDATA_BOOKMARKS)) {
                this._useCDataBookmarks = true;
            }
        }

        public static void spaces(StringBuffer stringBuffer, int i, int i2) {
            while (true) {
                int i4 = i2 - 1;
                if (i2 <= 0) {
                    return;
                }
                stringBuffer.insert(i, ' ');
                i2 = i4;
            }
        }

        public static void trim(StringBuffer stringBuffer) {
            int i = 0;
            while (i < stringBuffer.length() && CharUtil.isWhiteSpace(stringBuffer.charAt(i))) {
                i++;
            }
            stringBuffer.delete(0, i);
            int length = stringBuffer.length();
            while (length > 0 && CharUtil.isWhiteSpace(stringBuffer.charAt(length - 1))) {
                length--;
            }
            stringBuffer.delete(length, stringBuffer.length());
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public List getAncestorNamespaces() {
            return this._cur.getAncestorNamespaces();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public String getAttrValue() {
            return this._cur.getAttrValue();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public Object getChars() {
            String str = this._txt;
            if (str != null) {
                this._offSrc = 0;
                this._cchSrc = str.length();
                return this._txt;
            }
            Object chars = this._cur.getChars();
            SaveCur saveCur = this._cur;
            this._offSrc = saveCur._offSrc;
            this._cchSrc = saveCur._cchSrc;
            return chars;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public XmlDocumentProperties getDocProps() {
            return this._cur.getDocProps();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public QName getName() {
            return this._cur.getName();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public String getXmlnsPrefix() {
            return this._cur.getXmlnsPrefix();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public String getXmlnsUri() {
            return this._cur.getXmlnsUri();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public boolean hasChildren() {
            if (this._txt == null) {
                return this._cur.hasChildren();
            }
            return false;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public boolean hasText() {
            if (this._txt == null) {
                return this._cur.hasText();
            }
            return false;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public boolean isTextCData() {
            return this._txt == null ? this._useCDataBookmarks && this._cur.isTextCData() : this._isTextCData;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public boolean isXmlns() {
            if (this._txt == null) {
                return this._cur.isXmlns();
            }
            return false;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public int kind() {
            if (this._txt == null) {
                return this._cur.kind();
            }
            return 0;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public boolean next() {
            int iKind = 0;
            if (this._txt != null) {
                this._txt = null;
                this._isTextCData = false;
                iKind = this._cur.kind();
            } else {
                int iKind2 = this._cur.kind();
                if (!this._cur.next()) {
                    return false;
                }
                StringBuffer stringBuffer = this._sb;
                stringBuffer.delete(0, stringBuffer.length());
                if (this._cur.isText()) {
                    this._isTextCData = this._useCDataBookmarks && this._cur.isTextCData();
                    StringBuffer stringBuffer2 = this._sb;
                    Object chars = this._cur.getChars();
                    SaveCur saveCur = this._cur;
                    CharUtil.getString(stringBuffer2, chars, saveCur._offSrc, saveCur._cchSrc);
                    this._cur.next();
                    trim(this._sb);
                }
                int iKind3 = this._cur.kind();
                if (this._prettyIndent >= 0 && iKind2 != 4 && iKind2 != 5 && (iKind2 != 2 || iKind3 != -2)) {
                    if (this._sb.length() > 0) {
                        StringBuffer stringBuffer3 = this._sb;
                        String str = Saver._newLine;
                        stringBuffer3.insert(0, str);
                        spaces(this._sb, str.length(), (this._prettyIndent * this._depth) + this._prettyOffset);
                    }
                    if (iKind3 != -1) {
                        if (iKind2 != 1) {
                            this._sb.append(Saver._newLine);
                        }
                        int i = this._depth;
                        if (iKind3 < 0) {
                            i--;
                        }
                        StringBuffer stringBuffer4 = this._sb;
                        spaces(stringBuffer4, stringBuffer4.length(), (this._prettyIndent * i) + this._prettyOffset);
                    }
                }
                if (this._sb.length() > 0) {
                    this._txt = this._sb.toString();
                } else {
                    iKind = iKind3;
                }
            }
            if (iKind == 2) {
                this._depth++;
            } else if (iKind == -2) {
                this._depth--;
            }
            return true;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public void pop() {
            this._cur.pop();
            this._depth = ((Integer) this._stack.remove(r0.size() - 1)).intValue();
            this._txt = (String) this._stack.remove(r0.size() - 1);
            this._isTextCData = false;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public void push() {
            this._cur.push();
            this._stack.add(this._txt);
            this._stack.add(new Integer(this._depth));
            this._isTextCData = false;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public void release() {
            this._cur.release();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public void toEnd() {
            this._cur.toEnd();
            if (this._cur.kind() == -2) {
                this._depth--;
            }
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public boolean toFirstAttr() {
            return this._cur.toFirstAttr();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public boolean toNextAttr() {
            return this._cur.toNextAttr();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class SaveCur {
        int _cchSrc;
        int _offSrc;

        public abstract List getAncestorNamespaces();

        public abstract String getAttrValue();

        public abstract Object getChars();

        public abstract XmlDocumentProperties getDocProps();

        public abstract QName getName();

        public abstract String getXmlnsPrefix();

        public abstract String getXmlnsUri();

        public abstract boolean hasChildren();

        public abstract boolean hasText();

        public final boolean isAttr() {
            return kind() == 3;
        }

        public final boolean isComment() {
            return kind() == 4;
        }

        public final boolean isContainer() {
            return Cur.kindIsContainer(kind());
        }

        public final boolean isElem() {
            return kind() == 2;
        }

        public final boolean isFinish() {
            return Cur.kindIsFinish(kind());
        }

        public final boolean isNormalAttr() {
            return kind() == 3 && !isXmlns();
        }

        public final boolean isProcinst() {
            return kind() == 5;
        }

        public final boolean isRoot() {
            return kind() == 1;
        }

        public final boolean isText() {
            return kind() == 0;
        }

        public abstract boolean isTextCData();

        public abstract boolean isXmlns();

        public abstract int kind();

        public abstract boolean next();

        public abstract void pop();

        public abstract void push();

        public abstract void release();

        public final boolean skip() {
            toEnd();
            return next();
        }

        public abstract void toEnd();

        public abstract boolean toFirstAttr();

        public abstract boolean toNextAttr();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class XmlInputStreamImpl extends GenericXmlInputStream {
        private XmlInputStreamSaver _xmlInputStreamSaver;

        public XmlInputStreamImpl(Cur cur, XmlOptions xmlOptions) {
            XmlInputStreamSaver xmlInputStreamSaver = new XmlInputStreamSaver(cur, xmlOptions);
            this._xmlInputStreamSaver = xmlInputStreamSaver;
            xmlInputStreamSaver.process();
        }

        @Override // org.apache.xmlbeans.impl.common.GenericXmlInputStream
        public XMLEvent nextEvent() {
            return this._xmlInputStreamSaver.dequeue();
        }
    }

    static {
        _newLine = SystemProperties.getProperty(org.apache.commons.lang3.SystemProperties.LINE_SEPARATOR) == null ? "\n" : SystemProperties.getProperty(org.apache.commons.lang3.SystemProperties.LINE_SEPARATOR);
    }

    public Saver(Cur cur, XmlOptions xmlOptions) {
        XmlOptions xmlOptionsMaskNull = XmlOptions.maskNull(xmlOptions);
        this._cur = createSaveCur(cur, xmlOptionsMaskNull);
        Locale locale = cur._locale;
        this._locale = locale;
        this._version = locale.version();
        this._namespaceStack = new ArrayList();
        this._uriMap = new HashMap();
        this._prefixMap = new HashMap();
        this._attrNames = new ArrayList();
        this._attrValues = new ArrayList();
        addMapping("xml", "http://www.w3.org/XML/1998/namespace");
        if (xmlOptionsMaskNull.hasOption(XmlOptions.SAVE_IMPLICIT_NAMESPACES)) {
            Map map = (Map) xmlOptionsMaskNull.get(XmlOptions.SAVE_IMPLICIT_NAMESPACES);
            for (String str : map.keySet()) {
                addMapping(str, (String) map.get(str));
            }
        }
        if (xmlOptionsMaskNull.hasOption(XmlOptions.SAVE_SUBSTITUTE_CHARACTERS)) {
            this._replaceChar = (XmlOptionCharEscapeMap) xmlOptionsMaskNull.get(XmlOptions.SAVE_SUBSTITUTE_CHARACTERS);
        }
        if (getNamespaceForPrefix("") == null) {
            String str2 = new String("");
            this._initialDefaultUri = str2;
            addMapping("", str2);
        }
        if (xmlOptionsMaskNull.hasOption(XmlOptions.SAVE_AGGRESSIVE_NAMESPACES) && !(this instanceof SynthNamespaceSaver)) {
            SynthNamespaceSaver synthNamespaceSaver = new SynthNamespaceSaver(cur, xmlOptionsMaskNull);
            while (synthNamespaceSaver.process()) {
            }
            if (!synthNamespaceSaver._synthNamespaces.isEmpty()) {
                this._preComputedNamespaces = synthNamespaceSaver._synthNamespaces;
            }
        }
        this._useDefaultNamespace = xmlOptionsMaskNull.hasOption(XmlOptions.SAVE_USE_DEFAULT_NAMESPACE);
        this._saveNamespacesFirst = xmlOptionsMaskNull.hasOption(XmlOptions.SAVE_NAMESPACES_FIRST);
        if (xmlOptionsMaskNull.hasOption(XmlOptions.SAVE_SUGGESTED_PREFIXES)) {
            this._suggestedPrefixes = (Map) xmlOptionsMaskNull.get(XmlOptions.SAVE_SUGGESTED_PREFIXES);
        }
        this._ancestorNamespaces = this._cur.getAncestorNamespaces();
    }

    private final void addMapping(String str, String str2) {
        String str3;
        String str4 = (String) this._prefixMap.get(str);
        if (str4 == null) {
            str3 = null;
        } else if (!str4.equals(str2)) {
            int size = this._namespaceStack.size();
            str3 = null;
            while (size > 0) {
                if (this._namespaceStack.get(size - 1) != null) {
                    if (this._namespaceStack.get(size - 7).equals(str4) && ((str3 = (String) this._namespaceStack.get(size - 8)) == null || !str3.equals(str))) {
                        break;
                    } else {
                        size -= 8;
                    }
                } else {
                    size--;
                }
            }
        } else {
            str4 = null;
            str3 = null;
        }
        this._namespaceStack.add(this._uriMap.get(str2));
        this._namespaceStack.add(str2);
        if (str4 != null) {
            this._namespaceStack.add(this._uriMap.get(str4));
            this._namespaceStack.add(str4);
        } else {
            this._namespaceStack.add(null);
            this._namespaceStack.add(null);
        }
        this._namespaceStack.add(str);
        this._namespaceStack.add(this._prefixMap.get(str));
        this._namespaceStack.add(str);
        this._namespaceStack.add(str2);
        this._uriMap.put(str2, str);
        this._prefixMap.put(str, str2);
        if (str4 != null) {
            this._uriMap.put(str4, str3);
        }
    }

    private final void addNewFrameMapping(String str, String str2, boolean z) {
        if (str.length() == 0 || str2.length() > 0) {
            if (!z || str.length() > 0 || str2.length() == 0) {
                iterateMappings();
                while (hasMapping()) {
                    if (mappingPrefix().equals(str)) {
                        return;
                    } else {
                        nextMapping();
                    }
                }
                if (str2.equals(getNamespaceForPrefix(str))) {
                    return;
                }
                addMapping(str, str2);
            }
        }
    }

    private static SaveCur createSaveCur(Cur cur, XmlOptions xmlOptions) {
        SaveCur fragSaveCur;
        QName qName = (QName) xmlOptions.get(XmlOptions.SAVE_SYNTHETIC_DOCUMENT_ELEMENT);
        QName qName2 = qName == null ? xmlOptions.hasOption(XmlOptions.SAVE_USE_OPEN_FRAGMENT) ? Locale._openuriFragment : Locale._xmlFragment : qName;
        boolean z = xmlOptions.hasOption(XmlOptions.SAVE_INNER) && !xmlOptions.hasOption(XmlOptions.SAVE_OUTER);
        Cur curTempCur = cur.tempCur();
        Cur curTempCur2 = cur.tempCur();
        int iKind = cur.kind();
        if (iKind != 1) {
            fragSaveCur = null;
            if (iKind == 2) {
                if (z) {
                    positionToInner(cur, curTempCur, curTempCur2);
                    if (Locale.isFragment(curTempCur, curTempCur2)) {
                        qName = qName2;
                    }
                    fragSaveCur = new FragSaveCur(curTempCur, curTempCur2, qName);
                } else if (qName != null) {
                    positionToInner(cur, curTempCur, curTempCur2);
                    fragSaveCur = new FragSaveCur(curTempCur, curTempCur2, qName);
                } else {
                    curTempCur.moveToCur(cur);
                    curTempCur2.moveToCur(cur);
                    curTempCur2.skip();
                    fragSaveCur = new FragSaveCur(curTempCur, curTempCur2, null);
                }
            }
        } else {
            positionToInner(cur, curTempCur, curTempCur2);
            fragSaveCur = Locale.isFragment(curTempCur, curTempCur2) ? new FragSaveCur(curTempCur, curTempCur2, qName2) : qName != null ? new FragSaveCur(curTempCur, curTempCur2, qName) : new DocSaveCur(cur);
        }
        if (fragSaveCur == null) {
            if (iKind < 0) {
                curTempCur.moveToCur(cur);
                curTempCur2.moveToCur(cur);
            } else if (iKind == 0) {
                curTempCur.moveToCur(cur);
                curTempCur2.moveToCur(cur);
                curTempCur2.next();
            } else if (z) {
                curTempCur.moveToCur(cur);
                curTempCur.next();
                curTempCur2.moveToCur(cur);
                curTempCur2.toEnd();
            } else if (iKind == 3) {
                curTempCur.moveToCur(cur);
                curTempCur2.moveToCur(cur);
            } else {
                curTempCur.moveToCur(cur);
                curTempCur2.moveToCur(cur);
                curTempCur2.skip();
            }
            fragSaveCur = new FragSaveCur(curTempCur, curTempCur2, qName2);
        }
        String str = (String) xmlOptions.get(XmlOptions.SAVE_FILTER_PROCINST);
        if (str != null) {
            fragSaveCur = new FilterPiSaveCur(fragSaveCur, str);
        }
        if (xmlOptions.hasOption(XmlOptions.SAVE_PRETTY_PRINT)) {
            fragSaveCur = new PrettySaveCur(fragSaveCur, xmlOptions);
        }
        curTempCur.release();
        curTempCur2.release();
        return fragSaveCur;
    }

    private final void dumpMappings() {
        int size = this._namespaceStack.size();
        while (size > 0) {
            int i = size - 1;
            if (this._namespaceStack.get(i) == null) {
                System.out.println("----------------");
                size--;
            } else {
                System.out.print("Mapping: ");
                System.out.print(this._namespaceStack.get(size - 2));
                System.out.print(" -> ");
                System.out.print(this._namespaceStack.get(i));
                System.out.println();
                System.out.print("Prefix Undo: ");
                System.out.print(this._namespaceStack.get(size - 4));
                System.out.print(" -> ");
                System.out.print(this._namespaceStack.get(size - 3));
                System.out.println();
                System.out.print("Uri Rename: ");
                System.out.print(this._namespaceStack.get(size - 5));
                System.out.print(" -> ");
                System.out.print(this._namespaceStack.get(size - 6));
                System.out.println();
                System.out.print("UriUndo: ");
                System.out.print(this._namespaceStack.get(size - 7));
                System.out.print(" -> ");
                System.out.print(this._namespaceStack.get(size - 8));
                System.out.println();
                System.out.println();
                size -= 8;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String ensureMapping(String str, String str2, boolean z, boolean z2) {
        if (str.length() == 0) {
            return null;
        }
        String str3 = (String) this._uriMap.get(str);
        if (str3 != null && (str3.length() > 0 || !z2)) {
            return str3;
        }
        if (str2 != null && str2.length() == 0) {
            str2 = null;
        }
        if (str2 == null || !tryPrefix(str2)) {
            Map map = this._suggestedPrefixes;
            if (map != null && map.containsKey(str) && tryPrefix((String) this._suggestedPrefixes.get(str))) {
                str2 = (String) this._suggestedPrefixes.get(str);
            } else if (z && this._useDefaultNamespace) {
                str2 = "";
                if (!tryPrefix("")) {
                }
            } else {
                String strSuggestPrefix = QNameHelper.suggestPrefix(str);
                String str4 = strSuggestPrefix;
                int i = 1;
                while (!tryPrefix(str4)) {
                    str4 = strSuggestPrefix + i;
                    i++;
                }
                str2 = str4;
            }
        }
        syntheticNamespace(str2, str, z);
        addMapping(str2, str);
        return str2;
    }

    private final void popMappings() {
        while (true) {
            int size = this._namespaceStack.size();
            if (size == 0) {
                return;
            }
            int i = size - 1;
            if (this._namespaceStack.get(i) == null) {
                this._namespaceStack.remove(i);
                return;
            }
            int i2 = size - 7;
            Object obj = this._namespaceStack.get(i2);
            int i4 = size - 8;
            Object obj2 = this._namespaceStack.get(i4);
            if (obj2 == null) {
                this._uriMap.remove(obj);
            } else {
                this._uriMap.put(obj, obj2);
            }
            int i5 = size - 4;
            Object obj3 = this._namespaceStack.get(i5);
            int i6 = size - 3;
            Object obj4 = this._namespaceStack.get(i6);
            if (obj4 == null) {
                this._prefixMap.remove(obj3);
            } else {
                this._prefixMap.put(obj3, obj4);
            }
            int i7 = size - 5;
            String str = (String) this._namespaceStack.get(i7);
            if (str != null) {
                this._uriMap.put(str, this._namespaceStack.get(size - 6));
            }
            this._namespaceStack.remove(i);
            this._namespaceStack.remove(size - 2);
            this._namespaceStack.remove(i6);
            this._namespaceStack.remove(i5);
            this._namespaceStack.remove(i7);
            this._namespaceStack.remove(size - 6);
            this._namespaceStack.remove(i2);
            this._namespaceStack.remove(i4);
        }
    }

    private static void positionToInner(Cur cur, Cur cur2, Cur cur3) {
        cur2.moveToCur(cur);
        if (!cur2.toFirstAttr()) {
            cur2.next();
        }
        cur3.moveToCur(cur);
        cur3.toEnd();
    }

    private final void processElement() {
        QName name = this._cur.getName();
        boolean z = name.getNamespaceURI().length() == 0;
        pushMappings(this._cur, z);
        ensureMapping(name.getNamespaceURI(), name.getPrefix(), !z, false);
        this._attrNames.clear();
        this._attrValues.clear();
        this._cur.push();
        boolean firstAttr = this._cur.toFirstAttr();
        while (firstAttr) {
            if (this._cur.isNormalAttr()) {
                QName name2 = this._cur.getName();
                this._attrNames.add(name2);
                int size = this._attrNames.size() - 2;
                while (true) {
                    if (size < 0) {
                        this._attrValues.add(this._cur.getAttrValue());
                        ensureMapping(name2.getNamespaceURI(), name2.getPrefix(), false, true);
                        break;
                    } else {
                        if (this._attrNames.get(size).equals(name2)) {
                            ArrayList arrayList = this._attrNames;
                            arrayList.remove(arrayList.size() - 1);
                            break;
                        }
                        size--;
                    }
                }
            }
            firstAttr = this._cur.toNextAttr();
        }
        this._cur.pop();
        Map map = this._preComputedNamespaces;
        if (map != null) {
            for (String str : map.keySet()) {
                String str2 = (String) this._preComputedNamespaces.get(str);
                ensureMapping(str, str2, str2.length() == 0 && !z, false);
            }
            this._preComputedNamespaces = null;
        }
        if (emitElement(this._cur, this._attrNames, this._attrValues)) {
            popMappings();
            this._cur.toEnd();
        }
    }

    private final void processFinish() {
        emitFinish(this._cur);
        popMappings();
    }

    private final void processRoot() {
        String doctypeSystemId;
        String localPart;
        XmlDocumentProperties docProps = this._cur.getDocProps();
        if (docProps != null) {
            doctypeSystemId = docProps.getDoctypeSystemId();
            localPart = docProps.getDoctypeName();
        } else {
            doctypeSystemId = null;
            localPart = null;
        }
        if (doctypeSystemId != null || localPart != null) {
            if (localPart == null) {
                this._cur.push();
                while (!this._cur.isElem() && this._cur.next()) {
                }
                if (this._cur.isElem()) {
                    localPart = this._cur.getName().getLocalPart();
                }
                this._cur.pop();
            }
            String doctypePublicId = docProps.getDoctypePublicId();
            if (localPart != null) {
                QName name = this._cur.getName();
                if (name == null) {
                    this._cur.push();
                    while (true) {
                        if (this._cur.isFinish()) {
                            break;
                        }
                        if (this._cur.isElem()) {
                            name = this._cur.getName();
                            break;
                        }
                        this._cur.next();
                    }
                    this._cur.pop();
                }
                if (name != null && localPart.equals(name.getLocalPart())) {
                    emitDocType(localPart, doctypePublicId, doctypeSystemId);
                    return;
                }
            }
        }
        emitStartDoc(this._cur);
    }

    private final void pushMappings(SaveCur saveCur, boolean z) {
        this._namespaceStack.add(null);
        saveCur.push();
        boolean firstAttr = saveCur.toFirstAttr();
        while (firstAttr) {
            if (saveCur.isXmlns()) {
                addNewFrameMapping(saveCur.getXmlnsPrefix(), saveCur.getXmlnsUri(), z);
            }
            firstAttr = saveCur.toNextAttr();
        }
        saveCur.pop();
        if (!z || ((String) this._prefixMap.get("")).length() <= 0) {
            return;
        }
        addMapping("", "");
    }

    private final boolean tryPrefix(String str) {
        if (str == null || Locale.beginsWithXml(str)) {
            return false;
        }
        String str2 = (String) this._prefixMap.get(str);
        if (str2 != null) {
            return str.length() <= 0 && str2 == this._initialDefaultUri;
        }
        return true;
    }

    public abstract void emitComment(SaveCur saveCur);

    public abstract void emitDocType(String str, String str2, String str3);

    public abstract boolean emitElement(SaveCur saveCur, ArrayList arrayList, ArrayList arrayList2);

    public abstract void emitEndDoc(SaveCur saveCur);

    public abstract void emitFinish(SaveCur saveCur);

    public abstract void emitProcinst(SaveCur saveCur);

    public abstract void emitStartDoc(SaveCur saveCur);

    public abstract void emitText(SaveCur saveCur);

    public void enterLocale() {
        this._locale.enter();
    }

    public void exitLocale() {
        this._locale.exit();
    }

    public final String getNamespaceForPrefix(String str) {
        return (String) this._prefixMap.get(str);
    }

    public String getNonDefaultUriMapping(String str) {
        String str2 = (String) this._uriMap.get(str);
        if (str2 != null && str2.length() > 0) {
            return str2;
        }
        for (String str3 : this._prefixMap.keySet()) {
            if (str3.length() > 0 && this._prefixMap.get(str3).equals(str)) {
                return str3;
            }
        }
        return null;
    }

    public Map getPrefixMap() {
        return this._prefixMap;
    }

    public final String getUriMapping(String str) {
        return (String) this._uriMap.get(str);
    }

    public boolean hasMapping() {
        return this._currentMapping < this._namespaceStack.size();
    }

    public boolean hasMappings() {
        int size = this._namespaceStack.size();
        return size > 0 && this._namespaceStack.get(size - 1) != null;
    }

    public boolean isBadChar(char c) {
        if (Character.isHighSurrogate(c) || Character.isLowSurrogate(c)) {
            return false;
        }
        if (c >= ' ' && c <= 55295) {
            return false;
        }
        if (c < 57344 || c > 65533) {
            return ((c >= 0 && c <= 65535) || c == '\t' || c == '\n' || c == '\r') ? false : true;
        }
        return false;
    }

    public void iterateMappings() {
        int size = this._namespaceStack.size();
        while (true) {
            this._currentMapping = size;
            int i = this._currentMapping;
            if (i <= 0 || this._namespaceStack.get(i - 1) == null) {
                return;
            } else {
                size = this._currentMapping - 8;
            }
        }
    }

    public String mappingPrefix() {
        return (String) this._namespaceStack.get(this._currentMapping + 6);
    }

    public String mappingUri() {
        return (String) this._namespaceStack.get(this._currentMapping + 7);
    }

    public void nextMapping() {
        this._currentMapping += 8;
    }

    public final boolean process() {
        if (this._cur == null) {
            return false;
        }
        if (this._version != this._locale.version()) {
            throw new ConcurrentModificationException("Document changed during save");
        }
        int iKind = this._cur.kind();
        if (iKind == -2) {
            processFinish();
        } else {
            if (iKind == -1) {
                emitEndDoc(this._cur);
                this._cur.release();
                this._cur = null;
                return true;
            }
            if (iKind == 0) {
                emitText(this._cur);
            } else if (iKind == 1) {
                processRoot();
            } else if (iKind == 2) {
                processElement();
            } else if (iKind == 4) {
                emitComment(this._cur);
                this._cur.toEnd();
            } else {
                if (iKind != 5) {
                    throw new RuntimeException("Unexpected kind");
                }
                emitProcinst(this._cur);
                this._cur.toEnd();
            }
        }
        this._cur.next();
        return true;
    }

    public boolean saveNamespacesFirst() {
        return this._saveNamespacesFirst;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class OptimizedForSpeedSaver extends Saver {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private char[] _buf;

        /* JADX INFO: renamed from: _w */
        Writer f10178_w;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class SaverIOException extends RuntimeException {
            public SaverIOException(IOException iOException) {
                super(iOException);
            }
        }

        public OptimizedForSpeedSaver(Cur cur, Writer writer) {
            super(cur, XmlOptions.maskNull(null));
            this._buf = new char[1024];
            this.f10178_w = writer;
        }

        private void emit(String str) {
            try {
                this.f10178_w.write(str);
            } catch (IOException e) {
                throw new SaverIOException(e);
            }
        }

        private void emitAttrHelper(QName qName, String str) {
            emit(' ');
            emitName(qName, true);
            emit('=', '\"');
            emitAttrValue(str);
            emit('\"');
        }

        private void emitAttrValue(CharSequence charSequence) {
            int length = charSequence.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = charSequence.charAt(i);
                if (cCharAt == '<') {
                    emit("&lt;");
                } else if (cCharAt == '&') {
                    emit("&amp;");
                } else if (cCharAt == '\"') {
                    emit("&quot;");
                } else {
                    emit(cCharAt);
                }
            }
        }

        private void emitLiteral(String str) {
            if (str.indexOf("\"") < 0) {
                emit('\"');
                emit(str);
                emit('\"');
            } else {
                emit('\'');
                emit(str);
                emit('\'');
            }
        }

        private void emitName(QName qName, boolean z) {
            String namespaceURI = qName.getNamespaceURI();
            if (namespaceURI.length() != 0) {
                String prefix = qName.getPrefix();
                String namespaceForPrefix = getNamespaceForPrefix(prefix);
                if (namespaceForPrefix == null || !namespaceForPrefix.equals(namespaceURI)) {
                    prefix = getUriMapping(namespaceURI);
                }
                if (z && prefix.length() == 0) {
                    prefix = getNonDefaultUriMapping(namespaceURI);
                }
                if (prefix.length() > 0) {
                    emit(prefix);
                    emit(':');
                }
            }
            emit(qName.getLocalPart());
        }

        private void emitNamespacesHelper() {
            iterateMappings();
            while (hasMapping()) {
                emit(' ');
                emitXmlns(mappingPrefix(), mappingUri());
                nextMapping();
            }
        }

        private void entitizeAndWriteCommentText(int i) {
            int i2 = 0;
            boolean z = false;
            while (i2 < i) {
                char c = this._buf[i2];
                if (isBadChar(c)) {
                    this._buf[i2] = '?';
                } else if (c != '-') {
                    z = false;
                } else if (z) {
                    this._buf[i2] = ' ';
                    z = false;
                } else {
                    z = true;
                }
                if (i2 == this._buf.length) {
                    i2 = 0;
                }
                i2++;
            }
            char[] cArr = this._buf;
            int i4 = i - 1;
            if (cArr[i4] == '-') {
                cArr[i4] = ' ';
            }
            emit(cArr, 0, i);
        }

        private void entitizeAndWritePIText(int i) {
            boolean z = false;
            for (int i2 = 0; i2 < i; i2++) {
                char c = this._buf[i2];
                if (isBadChar(c)) {
                    this._buf[i2] = '?';
                    c = '?';
                }
                if (c != '>') {
                    z = c == '?';
                } else if (z) {
                    this._buf[i2] = ' ';
                }
            }
            emit(this._buf, 0, i);
        }

        private void entitizeAndWriteText(int i) {
            int i2 = 0;
            for (int i4 = 0; i4 < i; i4++) {
                char[] cArr = this._buf;
                char c = cArr[i4];
                if (c == '&') {
                    emit(cArr, i2, i4 - i2);
                    emit("&amp;");
                } else if (c == '<') {
                    emit(cArr, i2, i4 - i2);
                    emit("&lt;");
                }
                i2 = i4 + 1;
            }
            emit(this._buf, i2, i - i2);
        }

        public static void save(Cur cur, Writer writer) {
            try {
                do {
                } while (new OptimizedForSpeedSaver(cur, writer).process());
            } catch (SaverIOException e) {
                throw ((IOException) e.getCause());
            }
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitComment(SaveCur saveCur) {
            emit("<!--");
            saveCur.push();
            saveCur.next();
            emitCommentText(saveCur);
            saveCur.pop();
            emit("-->");
        }

        public void emitCommentText(SaveCur saveCur) {
            Object chars = saveCur.getChars();
            int i = saveCur._cchSrc;
            int i2 = saveCur._offSrc;
            int i4 = 0;
            while (i4 < i) {
                int i5 = i4 + 512 > i ? i : 512;
                CharUtil.getChars(this._buf, 0, chars, i2 + i4, i5);
                entitizeAndWriteCommentText(i5 - i4);
                i4 = i5;
            }
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitDocType(String str, String str2, String str3) {
            emit("<!DOCTYPE ");
            emit(str);
            if (str2 == null && str3 != null) {
                emit(" SYSTEM ");
                emitLiteral(str3);
            } else if (str2 != null) {
                emit(" PUBLIC ");
                emitLiteral(str2);
                emit(' ');
                emitLiteral(str3);
            }
            emit('>');
            emit(Saver._newLine);
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public boolean emitElement(SaveCur saveCur, ArrayList arrayList, ArrayList arrayList2) {
            emit(Typography.less);
            emitName(saveCur.getName(), false);
            for (int i = 0; i < arrayList.size(); i++) {
                emitAttrHelper((QName) arrayList.get(i), (String) arrayList2.get(i));
            }
            if (!saveNamespacesFirst()) {
                emitNamespacesHelper();
            }
            if (saveCur.hasChildren() || saveCur.hasText()) {
                emit('>');
                return false;
            }
            emit('/', '>');
            return true;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitFinish(SaveCur saveCur) {
            emit(Typography.less, '/');
            emitName(saveCur.getName(), false);
            emit('>');
        }

        public void emitPiText(SaveCur saveCur) {
            Object chars = saveCur.getChars();
            int i = saveCur._cchSrc;
            int i2 = saveCur._offSrc;
            int i4 = 0;
            while (i4 < i) {
                int i5 = i4 + 512 > i ? i : 512;
                CharUtil.getChars(this._buf, 0, chars, i2 + i4, i5);
                entitizeAndWritePIText(i5 - i4);
                i4 = i5;
            }
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitProcinst(SaveCur saveCur) {
            emit("<?");
            emit(saveCur.getName().getLocalPart());
            saveCur.push();
            saveCur.next();
            if (saveCur.isText()) {
                emit(' ');
                emitPiText(saveCur);
            }
            saveCur.pop();
            emit("?>");
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitText(SaveCur saveCur) {
            Object chars = saveCur.getChars();
            int i = saveCur._cchSrc;
            int i2 = saveCur._offSrc;
            int i4 = 0;
            while (i4 < i) {
                int i5 = i4 + 512;
                if (i5 > i) {
                    i5 = i;
                }
                int i6 = i2 + i4;
                int i7 = i5 - i4;
                CharUtil.getChars(this._buf, 0, chars, i6, i7);
                entitizeAndWriteText(i7);
                i4 = i5;
            }
        }

        public void emitXmlns(String str, String str2) {
            emit(XMLConstants.XMLNS_ATTRIBUTE);
            if (str.length() > 0) {
                emit(':');
                emit(str);
            }
            emit('=', '\"');
            emitAttrValue(str2);
            emit('\"');
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public boolean isBadChar(char c) {
            if (Character.isHighSurrogate(c) || Character.isLowSurrogate(c)) {
                return false;
            }
            if (c >= ' ' && c <= 55295) {
                return false;
            }
            if (c < 57344 || c > 65533) {
                return ((c >= 0 && c <= 65535) || c == '\t' || c == '\n' || c == '\r') ? false : true;
            }
            return false;
        }

        private void emit(char c) {
            try {
                char[] cArr = this._buf;
                cArr[0] = c;
                this.f10178_w.write(cArr, 0, 1);
            } catch (IOException e) {
                throw new SaverIOException(e);
            }
        }

        private void emit(char c, char c2) {
            try {
                char[] cArr = this._buf;
                cArr[0] = c;
                cArr[1] = c2;
                this.f10178_w.write(cArr, 0, 2);
            } catch (IOException e) {
                throw new SaverIOException(e);
            }
        }

        private void emit(char[] cArr, int i, int i2) {
            try {
                this.f10178_w.write(cArr, i, i2);
            } catch (IOException e) {
                throw new SaverIOException(e);
            }
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitEndDoc(SaveCur saveCur) {
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitStartDoc(SaveCur saveCur) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class TextSaver extends Saver {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final int _initialBufSize = 4096;
        private char[] _buf;
        private int _cdataEntityCountThreshold;
        private int _cdataLengthThreshold;
        private int _free;
        private int _in;
        private boolean _isPrettyPrint;
        private int _lastEmitCch;
        private int _lastEmitIn;
        private int _out;
        private boolean _useCDataBookmarks;

        public TextSaver(Cur cur, XmlOptions xmlOptions, String str) throws Throwable {
            super(cur, xmlOptions);
            this._cdataLengthThreshold = 32;
            this._cdataEntityCountThreshold = 5;
            this._useCDataBookmarks = false;
            this._isPrettyPrint = false;
            boolean z = xmlOptions != null && xmlOptions.hasOption(XmlOptions.SAVE_NO_XML_DECL);
            if (xmlOptions != null && xmlOptions.hasOption(XmlOptions.SAVE_CDATA_LENGTH_THRESHOLD)) {
                this._cdataLengthThreshold = ((Integer) xmlOptions.get(XmlOptions.SAVE_CDATA_LENGTH_THRESHOLD)).intValue();
            }
            if (xmlOptions != null && xmlOptions.hasOption(XmlOptions.SAVE_CDATA_ENTITY_COUNT_THRESHOLD)) {
                this._cdataEntityCountThreshold = ((Integer) xmlOptions.get(XmlOptions.SAVE_CDATA_ENTITY_COUNT_THRESHOLD)).intValue();
            }
            if (xmlOptions != null && xmlOptions.hasOption(XmlOptions.LOAD_SAVE_CDATA_BOOKMARKS)) {
                this._useCDataBookmarks = true;
            }
            if (xmlOptions != null && xmlOptions.hasOption(XmlOptions.SAVE_PRETTY_PRINT)) {
                this._isPrettyPrint = true;
            }
            this._out = 0;
            this._in = 0;
            this._free = 0;
            if (str == null || z) {
                return;
            }
            XmlDocumentProperties docProps = Locale.getDocProps(cur, false);
            String version = docProps == null ? null : docProps.getVersion();
            version = version == null ? "1.0" : version;
            emit("<?xml version=\"");
            emit(version);
            StringBuilder sbM15l = AbstractC0000a.m15l("\" encoding=\"", str, "\"?>");
            sbM15l.append(Saver._newLine);
            emit(sbM15l.toString());
        }

        private void emit(char c) {
            preEmit(1);
            char[] cArr = this._buf;
            int i = this._in;
            cArr[i] = c;
            this._in = (i + 1) % cArr.length;
        }

        private void emitAttrHelper(QName qName, String str) {
            emit(' ');
            emitName(qName, true);
            emit('=', '\"');
            emit(str);
            entitizeAttrValue(true);
            emit('\"');
        }

        private void emitLiteral(String str) {
            if (str.indexOf("\"") < 0) {
                emit('\"');
                emit(str);
                emit('\"');
            } else {
                emit('\'');
                emit(str);
                emit('\'');
            }
        }

        private void emitName(QName qName, boolean z) {
            String namespaceURI = qName.getNamespaceURI();
            if (namespaceURI.length() != 0) {
                String prefix = qName.getPrefix();
                String namespaceForPrefix = getNamespaceForPrefix(prefix);
                if (namespaceForPrefix == null || !namespaceForPrefix.equals(namespaceURI)) {
                    prefix = getUriMapping(namespaceURI);
                }
                if (z && prefix.length() == 0) {
                    prefix = getNonDefaultUriMapping(namespaceURI);
                }
                if (prefix.length() > 0) {
                    emit(prefix);
                    emit(':');
                }
            }
            emit(qName.getLocalPart());
        }

        private void emitNamespacesHelper() {
            iterateMappings();
            while (hasMapping()) {
                emit(' ');
                emitXmlns(mappingPrefix(), mappingUri());
                nextMapping();
            }
        }

        private int ensure(int i) {
            int available;
            if (i <= 0) {
                i = 1;
            }
            do {
                available = getAvailable();
                if (available >= i) {
                    break;
                }
            } while (process());
            return available;
        }

        private void entitizeAttrValue(boolean z) {
            int i = this._lastEmitCch;
            if (i != 0) {
                int iReplace = this._lastEmitIn;
                while (i > 0) {
                    char c = this._buf[iReplace];
                    if (c == '<') {
                        iReplace = replace(iReplace, "&lt;");
                    } else if (c == '&') {
                        iReplace = replace(iReplace, "&amp;");
                    } else if (c == '\"') {
                        iReplace = replace(iReplace, "&quot;");
                    } else if (!isEscapedChar(c)) {
                        iReplace++;
                    } else if (z) {
                        iReplace = replace(iReplace, this._replaceChar.getEscapedString(c));
                    }
                    if (iReplace == this._buf.length) {
                        iReplace = 0;
                    }
                    i--;
                }
            }
        }

        private void entitizeComment() {
            int i = this._lastEmitCch;
            if (i != 0) {
                int iReplace = this._lastEmitIn;
                boolean z = false;
                while (i > 0) {
                    char c = this._buf[iReplace];
                    if (isBadChar(c)) {
                        iReplace = replace(iReplace, MsalUtils.QUERY_STRING_SYMBOL);
                    } else {
                        if (c != '-') {
                            iReplace++;
                        } else if (z) {
                            iReplace = replace(iReplace, " ");
                        } else {
                            iReplace++;
                            z = true;
                        }
                        z = false;
                    }
                    if (iReplace == this._buf.length) {
                        iReplace = 0;
                    }
                    i--;
                }
                int i2 = (this._lastEmitIn + this._lastEmitCch) - 1;
                char[] cArr = this._buf;
                int length = i2 % cArr.length;
                if (cArr[length] == '-') {
                    replace(length, " ");
                }
            }
        }

        private void entitizeContent(boolean z) {
            int i;
            int i2 = this._lastEmitCch;
            if (i2 != 0) {
                int i4 = this._lastEmitIn;
                int length = this._buf.length;
                int i5 = 0;
                boolean z2 = false;
                char c = 0;
                char c2 = 0;
                while (i2 > 0) {
                    char c4 = this._buf[i4];
                    if (c4 == '<' || c4 == '&') {
                        i5++;
                    } else if ((c == ']' && c2 == ']' && c4 == '>') || isBadChar(c4) || isEscapedChar(c4) || (!this._isPrettyPrint && c4 == '\r')) {
                        z2 = true;
                    }
                    i4++;
                    if (i4 == length) {
                        i4 = 0;
                    }
                    i2--;
                    c = c2;
                    c2 = c4;
                }
                if (z || i5 != 0 || z2 || i5 >= this._cdataEntityCountThreshold) {
                    int iReplace = this._lastEmitIn;
                    if (!z && ((i = this._lastEmitCch) <= this._cdataLengthThreshold || i5 <= this._cdataEntityCountThreshold)) {
                        char c5 = 0;
                        char c6 = 0;
                        while (i > 0) {
                            char c7 = this._buf[iReplace];
                            iReplace = c7 == '<' ? replace(iReplace, "&lt;") : c7 == '&' ? replace(iReplace, "&amp;") : (c7 == '>' && c6 == ']' && c5 == ']') ? replace(iReplace, "&gt;") : isBadChar(c7) ? replace(iReplace, MsalUtils.QUERY_STRING_SYMBOL) : (this._isPrettyPrint || c7 != '\r') ? isEscapedChar(c7) ? replace(iReplace, this._replaceChar.getEscapedString(c7)) : iReplace + 1 : replace(iReplace, "&#13;");
                            if (iReplace == this._buf.length) {
                                iReplace = 0;
                            }
                            i--;
                            c5 = c6;
                            c6 = c7;
                        }
                        return;
                    }
                    boolean z3 = this._buf[iReplace] == ']';
                    int iReplace2 = replace(iReplace, "<![CDATA[" + this._buf[iReplace]);
                    char[] cArr = this._buf;
                    boolean z4 = cArr[iReplace2] == ']';
                    int iReplace3 = iReplace2 + 1;
                    if (iReplace3 == cArr.length) {
                        iReplace3 = 0;
                    }
                    int i6 = this._lastEmitCch;
                    while (i6 > 0) {
                        char c8 = this._buf[iReplace3];
                        iReplace3 = (c8 == '>' && z3 && z4) ? replace(iReplace3, "]]>><![CDATA[") : isBadChar(c8) ? replace(iReplace3, MsalUtils.QUERY_STRING_SYMBOL) : iReplace3 + 1;
                        boolean z5 = c8 == ']';
                        if (iReplace3 == this._buf.length) {
                            iReplace3 = 0;
                        }
                        i6--;
                        boolean z6 = z4;
                        z4 = z5;
                        z3 = z6;
                    }
                    emit("]]>");
                }
            }
        }

        private void entitizeProcinst() {
            int i = this._lastEmitCch;
            if (i != 0) {
                int iReplace = this._lastEmitIn;
                boolean z = false;
                while (i > 0) {
                    char c = this._buf[iReplace];
                    if (isBadChar(c)) {
                        iReplace = replace(iReplace, MsalUtils.QUERY_STRING_SYMBOL);
                    }
                    if (c == '>') {
                        iReplace = z ? replace(iReplace, " ") : iReplace + 1;
                        z = false;
                    } else {
                        z = c == '?';
                        iReplace++;
                    }
                    if (iReplace == this._buf.length) {
                        iReplace = 0;
                    }
                    i--;
                }
            }
        }

        private boolean isEscapedChar(char c) {
            XmlOptionCharEscapeMap xmlOptionCharEscapeMap = this._replaceChar;
            return xmlOptionCharEscapeMap != null && xmlOptionCharEscapeMap.containsChar(c);
        }

        private boolean preEmit(int i) {
            this._lastEmitCch = i;
            if (i == 0) {
                return true;
            }
            if (this._free <= i) {
                resize(i, -1);
            }
            if (getAvailable() == 0) {
                this._out = 0;
                this._in = 0;
            }
            this._lastEmitIn = this._in;
            this._free -= i;
            return false;
        }

        private int replace(int i, String str) {
            int length = str.length();
            int i2 = length - 1;
            if (i2 == 0) {
                this._buf[i] = str.charAt(0);
                return i + 1;
            }
            if (i2 > this._free) {
                i = resize(i2, i);
            }
            int i4 = this._out;
            int i5 = this._in;
            if (i4 <= i5 || i < i4) {
                char[] cArr = this._buf;
                int length2 = cArr.length - i5;
                if (i2 <= length2) {
                    System.arraycopy(cArr, i, cArr, i + i2, i5 - i);
                    this._in = (this._in + i2) % this._buf.length;
                } else if (i2 <= ((length2 + i5) - i) - 1) {
                    int i6 = i2 - length2;
                    System.arraycopy(cArr, i5 - i6, cArr, 0, i6);
                    char[] cArr2 = this._buf;
                    int i7 = i + 1;
                    System.arraycopy(cArr2, i7, cArr2, i7 + i2, ((this._in - i) - 1) - i6);
                    this._in = i6;
                } else {
                    int i8 = (i5 - i) - 1;
                    int i9 = (length2 + i5) - i;
                    System.arraycopy(cArr, i5 - i8, cArr, (i2 - i9) + 1, i8);
                    str.getChars(i9, length, this._buf, 0);
                    this._in = ((i8 + i2) - i9) + 1;
                    length = i9;
                }
            } else {
                char[] cArr3 = this._buf;
                System.arraycopy(cArr3, i4, cArr3, i4 - i2, i - i4);
                this._out -= i2;
                i -= i2;
            }
            str.getChars(0, length, this._buf, i);
            this._free -= i2;
            return ((i + i2) + 1) % this._buf.length;
        }

        private int resize(int i, int i2) {
            int i4;
            char[] cArr = this._buf;
            int length = cArr == null ? 4096 : cArr.length * 2;
            int available = getAvailable();
            while (length - available < i) {
                length *= 2;
            }
            char[] cArr2 = new char[length];
            if (available > 0) {
                int i5 = this._in;
                int i6 = this._out;
                if (i5 > i6) {
                    System.arraycopy(this._buf, i6, cArr2, 0, available);
                    i4 = this._out;
                } else {
                    System.arraycopy(this._buf, i6, cArr2, 0, available - i5);
                    char[] cArr3 = this._buf;
                    int i7 = this._in;
                    System.arraycopy(cArr3, 0, cArr2, available - i7, i7);
                    i4 = this._out;
                    if (i2 < i4) {
                        i2 += i4;
                    }
                    this._out = 0;
                    this._in = available;
                    this._free = (length - this._buf.length) + this._free;
                }
                i2 -= i4;
                this._out = 0;
                this._in = available;
                this._free = (length - this._buf.length) + this._free;
            } else {
                this._free = length;
            }
            this._buf = cArr2;
            return i2;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitComment(SaveCur saveCur) {
            emit("<!--");
            saveCur.push();
            saveCur.next();
            emit(saveCur);
            saveCur.pop();
            entitizeComment();
            emit("-->");
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitDocType(String str, String str2, String str3) {
            emit("<!DOCTYPE ");
            emit(str);
            if (str2 == null && str3 != null) {
                emit(" SYSTEM ");
                emitLiteral(str3);
            } else if (str2 != null) {
                emit(" PUBLIC ");
                emitLiteral(str2);
                emit(" ");
                emitLiteral(str3);
            }
            emit(">");
            emit(Saver._newLine);
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public boolean emitElement(SaveCur saveCur, ArrayList arrayList, ArrayList arrayList2) {
            emit(Typography.less);
            emitName(saveCur.getName(), false);
            if (saveNamespacesFirst()) {
                emitNamespacesHelper();
            }
            for (int i = 0; i < arrayList.size(); i++) {
                emitAttrHelper((QName) arrayList.get(i), (String) arrayList2.get(i));
            }
            if (!saveNamespacesFirst()) {
                emitNamespacesHelper();
            }
            if (saveCur.hasChildren() || saveCur.hasText()) {
                emit('>');
                return false;
            }
            emit('/', '>');
            return true;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitFinish(SaveCur saveCur) {
            emit(Typography.less, '/');
            emitName(saveCur.getName(), false);
            emit('>');
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitProcinst(SaveCur saveCur) {
            emit("<?");
            emit(saveCur.getName().getLocalPart());
            saveCur.push();
            saveCur.next();
            if (saveCur.isText()) {
                emit(" ");
                emit(saveCur);
                entitizeProcinst();
            }
            saveCur.pop();
            emit("?>");
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitText(SaveCur saveCur) {
            boolean z = this._useCDataBookmarks && saveCur.isTextCData();
            emit(saveCur);
            entitizeContent(z);
        }

        public void emitXmlns(String str, String str2) {
            emit(XMLConstants.XMLNS_ATTRIBUTE);
            if (str.length() > 0) {
                emit(':');
                emit(str);
            }
            emit('=', '\"');
            emit(str2);
            entitizeAttrValue(false);
            emit('\"');
        }

        public int getAvailable() {
            char[] cArr = this._buf;
            if (cArr == null) {
                return 0;
            }
            return cArr.length - this._free;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public boolean isBadChar(char c) {
            if (Character.isHighSurrogate(c) || Character.isLowSurrogate(c)) {
                return false;
            }
            if (c >= ' ' && c <= 55295) {
                return false;
            }
            if (c < 57344 || c > 65533) {
                return ((c >= 0 && c <= 65535) || c == '\t' || c == '\n' || c == '\r') ? false : true;
            }
            return false;
        }

        public int read() {
            if (ensure(1) == 0) {
                return -1;
            }
            char[] cArr = this._buf;
            int i = this._out;
            char c = cArr[i];
            this._out = (i + 1) % cArr.length;
            this._free++;
            return c;
        }

        public String saveToString() {
            while (process()) {
            }
            int available = getAvailable();
            return available == 0 ? "" : new String(this._buf, this._out, available);
        }

        public int write(Writer writer, int i) {
            while (getAvailable() < i && process()) {
            }
            int available = getAvailable();
            if (available > 0) {
                try {
                    writer.write(this._buf, 0, available);
                    writer.flush();
                    this._free += available;
                    this._in = 0;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return available;
        }

        private void emit(char c, char c2) {
            if (preEmit(2)) {
                return;
            }
            char[] cArr = this._buf;
            int i = this._in;
            cArr[i] = c;
            int length = (i + 1) % cArr.length;
            this._in = length;
            cArr[length] = c2;
            this._in = (length + 1) % cArr.length;
        }

        public int read(char[] cArr, int i, int i2) {
            int iEnsure = ensure(i2);
            if (iEnsure == 0) {
                return -1;
            }
            if (cArr == null || i2 <= 0) {
                return 0;
            }
            if (iEnsure < i2) {
                i2 = iEnsure;
            }
            int i4 = this._out;
            if (i4 < this._in) {
                System.arraycopy(this._buf, i4, cArr, i, i2);
            } else {
                char[] cArr2 = this._buf;
                int length = cArr2.length - i4;
                if (length >= i2) {
                    System.arraycopy(cArr2, i4, cArr, i, i2);
                } else {
                    System.arraycopy(cArr2, i4, cArr, i, length);
                    System.arraycopy(this._buf, 0, cArr, i + length, i2 - length);
                }
            }
            this._out = (this._out + i2) % this._buf.length;
            this._free += i2;
            return i2;
        }

        private void emit(String str) {
            int length = str == null ? 0 : str.length();
            if (preEmit(length)) {
                return;
            }
            int i = this._in;
            if (i > this._out) {
                char[] cArr = this._buf;
                int length2 = cArr.length - i;
                if (length >= length2) {
                    str.getChars(0, length2, cArr, i);
                    str.getChars(length2, length, this._buf, 0);
                    this._in = (this._in + length) % this._buf.length;
                    return;
                }
            }
            str.getChars(0, length, this._buf, i);
            this._in += length;
        }

        private void emit(SaveCur saveCur) {
            if (saveCur.isText()) {
                Object chars = saveCur.getChars();
                int i = saveCur._cchSrc;
                if (preEmit(i)) {
                    return;
                }
                int i2 = this._in;
                if (i2 > this._out) {
                    char[] cArr = this._buf;
                    int length = cArr.length - i2;
                    if (i >= length) {
                        CharUtil.getChars(cArr, i2, chars, saveCur._offSrc, length);
                        CharUtil.getChars(this._buf, 0, chars, saveCur._offSrc + length, i - length);
                        this._in = (this._in + i) % this._buf.length;
                        return;
                    }
                }
                CharUtil.getChars(this._buf, i2, chars, saveCur._offSrc, i);
                this._in += i;
                return;
            }
            preEmit(0);
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitEndDoc(SaveCur saveCur) {
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitStartDoc(SaveCur saveCur) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class InputStreamSaver extends InputStream {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private boolean _closed = false;
        private OutputStreamWriter _converter;
        private Locale _locale;
        private OutputStreamImpl _outStreamImpl;
        private TextSaver _textSaver;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public final class OutputStreamImpl extends OutputStream {
            static final /* synthetic */ boolean $assertionsDisabled = false;
            private static final int _initialBufSize = 4096;
            private byte[] _buf;
            private int _free;
            private int _in;
            private int _out;

            public int getAvailable() {
                byte[] bArr = this._buf;
                if (bArr == null) {
                    return 0;
                }
                return bArr.length - this._free;
            }

            public int read() {
                if (InputStreamSaver.this.ensure(1) == 0) {
                    return -1;
                }
                byte[] bArr = this._buf;
                int i = this._out;
                byte b = bArr[i];
                this._out = (i + 1) % bArr.length;
                this._free++;
                return b;
            }

            public void resize(int i) {
                byte[] bArr = this._buf;
                int length = bArr == null ? 4096 : bArr.length * 2;
                int available = getAvailable();
                while (length - available < i) {
                    length *= 2;
                }
                byte[] bArr2 = new byte[length];
                if (available > 0) {
                    int i2 = this._in;
                    int i4 = this._out;
                    if (i2 > i4) {
                        System.arraycopy(this._buf, i4, bArr2, 0, available);
                    } else {
                        System.arraycopy(this._buf, i4, bArr2, 0, available - i2);
                        byte[] bArr3 = this._buf;
                        int i5 = this._in;
                        System.arraycopy(bArr3, 0, bArr2, available - i5, i5);
                    }
                    this._out = 0;
                    this._in = available;
                    this._free = (length - this._buf.length) + this._free;
                } else {
                    this._free = length;
                }
                this._buf = bArr2;
            }

            @Override // java.io.OutputStream
            public void write(int i) {
                if (this._free == 0) {
                    resize(1);
                }
                byte[] bArr = this._buf;
                int i2 = this._in;
                bArr[i2] = (byte) i;
                this._in = (i2 + 1) % bArr.length;
                this._free--;
            }

            private OutputStreamImpl() {
            }

            public int read(byte[] bArr, int i, int i2) {
                int iEnsure = InputStreamSaver.this.ensure(i2);
                if (iEnsure == 0) {
                    return -1;
                }
                if (bArr == null || i2 <= 0) {
                    return 0;
                }
                if (iEnsure < i2) {
                    i2 = iEnsure;
                }
                int i4 = this._out;
                if (i4 < this._in) {
                    System.arraycopy(this._buf, i4, bArr, i, i2);
                } else {
                    byte[] bArr2 = this._buf;
                    int length = bArr2.length - i4;
                    if (length >= i2) {
                        System.arraycopy(bArr2, i4, bArr, i, i2);
                    } else {
                        System.arraycopy(bArr2, i4, bArr, i, length);
                        System.arraycopy(this._buf, 0, bArr, i + length, i2 - length);
                    }
                }
                this._out = (this._out + i2) % this._buf.length;
                this._free += i2;
                return i2;
            }

            @Override // java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                if (i2 != 0) {
                    if (this._free < i2) {
                        resize(i2);
                    }
                    if (this._in == this._out) {
                        this._out = 0;
                        this._in = 0;
                    }
                    byte[] bArr2 = this._buf;
                    int length = bArr2.length;
                    int i4 = this._in;
                    int i5 = length - i4;
                    if (i4 > this._out && i2 >= i5) {
                        System.arraycopy(bArr, i, bArr2, i4, i5);
                        System.arraycopy(bArr, i + i5, this._buf, 0, i2 - i5);
                        this._in = (this._in + i2) % this._buf.length;
                    } else {
                        System.arraycopy(bArr, i, bArr2, i4, i2);
                        this._in += i2;
                    }
                    this._free -= i2;
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v1 */
        public InputStreamSaver(Cur cur, XmlOptions xmlOptions) throws Throwable {
            String java2IANAMapping;
            this._locale = cur._locale;
            XmlOptions xmlOptionsMaskNull = XmlOptions.maskNull(xmlOptions);
            String iANA2JavaMapping = 0;
            iANA2JavaMapping = 0;
            this._outStreamImpl = new OutputStreamImpl();
            XmlDocumentProperties docProps = Locale.getDocProps(cur, false);
            if (docProps != null && docProps.getEncoding() != null) {
                iANA2JavaMapping = EncodingMap.getIANA2JavaMapping(docProps.getEncoding());
            }
            String java2IANAMapping2 = xmlOptionsMaskNull.hasOption(XmlOptions.CHARACTER_ENCODING) ? (String) xmlOptionsMaskNull.get(XmlOptions.CHARACTER_ENCODING) : iANA2JavaMapping;
            if (java2IANAMapping2 != 0 && (java2IANAMapping = EncodingMap.getJava2IANAMapping(java2IANAMapping2)) != null) {
                java2IANAMapping2 = java2IANAMapping;
            }
            java2IANAMapping2 = java2IANAMapping2 == 0 ? EncodingMap.getJava2IANAMapping(InternalZipConstants.CHARSET_UTF8) : java2IANAMapping2;
            String iANA2JavaMapping2 = EncodingMap.getIANA2JavaMapping(java2IANAMapping2);
            if (iANA2JavaMapping2 == null) {
                throw new IllegalStateException(AbstractC0541b.m772n("Unknown encoding: ", java2IANAMapping2));
            }
            try {
                this._converter = new OutputStreamWriter(this._outStreamImpl, iANA2JavaMapping2);
                this._textSaver = new TextSaver(cur, xmlOptionsMaskNull, java2IANAMapping2);
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
        }

        private void checkClosed() throws IOException {
            if (this._closed) {
                throw new IOException("Stream closed");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int ensure(int i) {
            if (i <= 0) {
                i = 1;
            }
            while (this._outStreamImpl.getAvailable() < i && this._textSaver.write(this._converter, 2048) >= 2048) {
            }
            return this._outStreamImpl.getAvailable();
        }

        @Override // java.io.InputStream
        public int available() {
            int iEnsure;
            if (this._locale.noSync()) {
                this._locale.enter();
                try {
                    return ensure(1024);
                } finally {
                }
            }
            synchronized (this._locale) {
                try {
                    this._locale.enter();
                    try {
                        iEnsure = ensure(1024);
                    } finally {
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return iEnsure;
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this._closed = true;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            int i;
            checkClosed();
            if (this._locale.noSync()) {
                this._locale.enter();
                try {
                    return this._outStreamImpl.read();
                } finally {
                }
            }
            synchronized (this._locale) {
                try {
                    this._locale.enter();
                    try {
                        i = this._outStreamImpl.read();
                    } finally {
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return i;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int i4;
            checkClosed();
            if (bArr != null) {
                if (i >= 0 && i <= bArr.length) {
                    if (this._locale.noSync()) {
                        this._locale.enter();
                        try {
                            return this._outStreamImpl.read(bArr, i, i2);
                        } finally {
                        }
                    }
                    synchronized (this._locale) {
                        try {
                            this._locale.enter();
                            try {
                                i4 = this._outStreamImpl.read(bArr, i, i2);
                            } finally {
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    return i4;
                }
                throw new IndexOutOfBoundsException("Offset is not within buf");
            }
            throw new NullPointerException("buf to read into is null");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class TextReader extends Reader {
        private boolean _closed = false;
        private Locale _locale;
        private TextSaver _textSaver;

        public TextReader(Cur cur, XmlOptions xmlOptions) {
            this._textSaver = new TextSaver(cur, xmlOptions, null);
            this._locale = cur._locale;
        }

        private void checkClosed() throws IOException {
            if (this._closed) {
                throw new IOException("Reader has been closed");
            }
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this._closed = true;
        }

        @Override // java.io.Reader
        public int read() throws IOException {
            int i;
            checkClosed();
            if (this._locale.noSync()) {
                this._locale.enter();
                try {
                    return this._textSaver.read();
                } finally {
                }
            }
            synchronized (this._locale) {
                try {
                    this._locale.enter();
                    try {
                        i = this._textSaver.read();
                    } finally {
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return i;
        }

        @Override // java.io.Reader
        public boolean ready() {
            return !this._closed;
        }

        @Override // java.io.Reader
        public int read(char[] cArr) throws IOException {
            int i;
            checkClosed();
            if (this._locale.noSync()) {
                this._locale.enter();
                try {
                    return this._textSaver.read(cArr, 0, cArr == null ? 0 : cArr.length);
                } finally {
                }
            }
            synchronized (this._locale) {
                try {
                    this._locale.enter();
                    try {
                        i = this._textSaver.read(cArr, 0, cArr == null ? 0 : cArr.length);
                    } finally {
                    }
                } finally {
                }
            }
            return i;
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            int i4;
            checkClosed();
            if (this._locale.noSync()) {
                this._locale.enter();
                try {
                    return this._textSaver.read(cArr, i, i2);
                } finally {
                }
            }
            synchronized (this._locale) {
                try {
                    this._locale.enter();
                    try {
                        i4 = this._textSaver.read(cArr, i, i2);
                    } finally {
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return i4;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class XmlInputStreamSaver extends Saver {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private XmlEventImpl _in;
        private XmlEventImpl _out;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class ChangePrefixMappingImpl extends XmlEventImpl implements ChangePrefixMapping {
            private String _newUri;
            private String _oldUri;
            private String _prefix;

            public ChangePrefixMappingImpl(String str, String str2, String str3) {
                super(4096);
                this._oldUri = str2;
                this._newUri = str3;
                this._prefix = str;
            }

            public String getNewNamespaceUri() {
                return this._newUri;
            }

            public String getOldNamespaceUri() {
                return this._oldUri;
            }

            public String getPrefix() {
                return this._prefix;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class CharacterDataImpl extends TripletEventImpl implements CharacterData {
            public CharacterDataImpl(Object obj, int i, int i2) {
                super(16, obj, i, i2);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class CommentImpl extends TripletEventImpl implements Comment {
            public CommentImpl(Object obj, int i, int i2) {
                super(32, obj, i, i2);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class EndDocumentImpl extends XmlEventImpl implements EndDocument {
            public EndDocumentImpl() {
                super(512);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class EndElementImpl extends XmlEventImpl implements EndElement {
            private XMLName _name;

            public EndElementImpl(XMLName xMLName) {
                super(4);
                this._name = xMLName;
            }

            @Override // org.apache.xmlbeans.impl.store.Saver.XmlInputStreamSaver.XmlEventImpl
            public XMLName getName() {
                return this._name;
            }

            @Override // org.apache.xmlbeans.impl.store.Saver.XmlInputStreamSaver.XmlEventImpl
            public boolean hasName() {
                return true;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class EndPrefixMappingImpl extends XmlEventImpl implements EndPrefixMapping {
            private String _prefix;

            public EndPrefixMappingImpl(String str) {
                super(2048);
                this._prefix = str;
            }

            public String getPrefix() {
                return this._prefix;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class ProcessingInstructionImpl extends TripletEventImpl implements ProcessingInstruction {
            private String _target;

            public ProcessingInstructionImpl(String str, Object obj, int i, int i2) {
                super(8, obj, i, i2);
                this._target = str;
            }

            public String getData() {
                return getContent();
            }

            public String getTarget() {
                return this._target;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class StartDocumentImpl extends XmlEventImpl implements StartDocument {
            String _encoding;
            boolean _standAlone;
            String _systemID;
            String _version;

            public StartDocumentImpl(String str, String str2, boolean z, String str3) {
                super(256);
                this._systemID = str;
                this._encoding = str2;
                this._standAlone = z;
                this._version = str3;
            }

            public String getCharacterEncodingScheme() {
                return this._encoding;
            }

            public String getSystemId() {
                return this._systemID;
            }

            public String getVersion() {
                return this._version;
            }

            public boolean isStandalone() {
                return this._standAlone;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class StartPrefixMappingImpl extends XmlEventImpl implements StartPrefixMapping {
            private String _prefix;
            private String _uri;

            public StartPrefixMappingImpl(String str, String str2) {
                super(1024);
                this._prefix = str;
                this._uri = str2;
            }

            public String getNamespaceUri() {
                return this._uri;
            }

            public String getPrefix() {
                return this._prefix;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class TripletEventImpl extends XmlEventImpl implements CharacterData {
            private int _cch;
            private Object _obj;
            private int _off;

            public TripletEventImpl(int i, Object obj, int i2, int i4) {
                super(i);
                this._obj = obj;
                this._cch = i2;
                this._off = i4;
            }

            public String getContent() {
                return CharUtil.getString(this._obj, this._off, this._cch);
            }

            public boolean hasContent() {
                return this._cch > 0;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static abstract class XmlEventImpl extends XmlEventBase {
            XmlEventImpl _next;

            public XmlEventImpl(int i) {
                super(i);
            }

            public final Location getLocation() {
                return null;
            }

            public XMLName getName() {
                return null;
            }

            public XMLName getSchemaType() {
                throw new RuntimeException("NYI");
            }

            public boolean hasName() {
                return false;
            }
        }

        public XmlInputStreamSaver(Cur cur, XmlOptions xmlOptions) {
            super(cur, xmlOptions);
        }

        private static XMLName computeName(QName qName, Saver saver, boolean z) {
            String prefix;
            String namespaceURI = qName.getNamespaceURI();
            String localPart = qName.getLocalPart();
            if (namespaceURI == null || namespaceURI.length() == 0) {
                prefix = null;
            } else {
                prefix = qName.getPrefix();
                String namespaceForPrefix = saver.getNamespaceForPrefix(prefix);
                if (namespaceForPrefix == null || !namespaceForPrefix.equals(namespaceURI)) {
                    prefix = saver.getUriMapping(namespaceURI);
                }
                if (z && prefix.length() == 0) {
                    prefix = saver.getNonDefaultUriMapping(namespaceURI);
                }
            }
            return new XmlNameImpl(namespaceURI, localPart, prefix);
        }

        private void enqueue(XmlEventImpl xmlEventImpl) {
            XmlEventImpl xmlEventImpl2 = this._in;
            if (xmlEventImpl2 == null) {
                this._in = xmlEventImpl;
                this._out = xmlEventImpl;
            } else {
                xmlEventImpl2._next = xmlEventImpl;
                this._in = xmlEventImpl;
            }
        }

        public XMLEvent dequeue() {
            if (this._out == null) {
                enterLocale();
                try {
                    if (!process()) {
                        return null;
                    }
                } finally {
                    exitLocale();
                }
            }
            XmlEventImpl xmlEventImpl = this._out;
            if (xmlEventImpl == null) {
                return null;
            }
            XmlEventImpl xmlEventImpl2 = xmlEventImpl._next;
            this._out = xmlEventImpl2;
            if (xmlEventImpl2 == null) {
                this._in = null;
            }
            return xmlEventImpl;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitComment(SaveCur saveCur) {
            enqueue(new CommentImpl(saveCur.getChars(), saveCur._cchSrc, saveCur._offSrc));
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitDocType(String str, String str2, String str3) {
            enqueue(new StartDocumentImpl(str3, null, true, null));
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public boolean emitElement(SaveCur saveCur, ArrayList arrayList, ArrayList arrayList2) {
            iterateMappings();
            while (hasMapping()) {
                enqueue(new StartPrefixMappingImpl(mappingPrefix(), mappingUri()));
                nextMapping();
            }
            StartElementImpl.XmlnsAttributeImpl xmlnsAttributeImpl = null;
            int i = 0;
            StartElementImpl.NormalAttributeImpl normalAttributeImpl = null;
            StartElementImpl.NormalAttributeImpl normalAttributeImpl2 = null;
            while (i < arrayList.size()) {
                StartElementImpl.NormalAttributeImpl normalAttributeImpl3 = new StartElementImpl.NormalAttributeImpl(computeName((QName) arrayList.get(i), this, true), (String) arrayList2.get(i));
                if (normalAttributeImpl == null) {
                    normalAttributeImpl = normalAttributeImpl3;
                } else {
                    normalAttributeImpl2._next = normalAttributeImpl3;
                }
                i++;
                normalAttributeImpl2 = normalAttributeImpl3;
            }
            iterateMappings();
            StartElementImpl.XmlnsAttributeImpl xmlnsAttributeImpl2 = null;
            while (hasMapping()) {
                StartElementImpl.XmlnsAttributeImpl xmlnsAttributeImpl3 = new StartElementImpl.XmlnsAttributeImpl(mappingPrefix(), mappingUri());
                if (xmlnsAttributeImpl == null) {
                    xmlnsAttributeImpl = xmlnsAttributeImpl3;
                } else {
                    xmlnsAttributeImpl2._next = xmlnsAttributeImpl3;
                }
                nextMapping();
                xmlnsAttributeImpl2 = xmlnsAttributeImpl3;
            }
            enqueue(new StartElementImpl(computeName(saveCur.getName(), this, false), normalAttributeImpl, xmlnsAttributeImpl, getPrefixMap()));
            return false;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitEndDoc(SaveCur saveCur) {
            enqueue(new EndDocumentImpl());
        }

        public void emitEndPrefixMappings() {
            iterateMappings();
            while (hasMapping()) {
                String strMappingPrefix = mappingPrefix();
                mappingUri();
                enqueue(new EndPrefixMappingImpl(strMappingPrefix));
                nextMapping();
            }
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitFinish(SaveCur saveCur) {
            if (saveCur.isRoot()) {
                enqueue(new EndDocumentImpl());
            } else {
                enqueue(new EndElementImpl(computeName(saveCur.getName(), this, false)));
            }
            emitEndPrefixMappings();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitProcinst(SaveCur saveCur) {
            QName name = saveCur.getName();
            enqueue(new ProcessingInstructionImpl(name != null ? name.getLocalPart() : null, saveCur.getChars(), saveCur._cchSrc, saveCur._offSrc));
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitStartDoc(SaveCur saveCur) {
            emitDocType(null, null, null);
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitText(SaveCur saveCur) {
            enqueue(new CharacterDataImpl(saveCur.getChars(), saveCur._cchSrc, saveCur._offSrc));
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class StartElementImpl extends XmlEventImpl implements StartElement {
            private AttributeImpl _attributes;
            private XMLName _name;
            private AttributeImpl _namespaces;
            private Map _prefixMap;

            /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
            public static abstract class AttributeImpl implements Attribute {
                protected XMLName _name;
                AttributeImpl _next;

                public XMLName getName() {
                    return this._name;
                }

                public XMLName getSchemaType() {
                    return null;
                }

                public String getType() {
                    return "CDATA";
                }
            }

            /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
            public static class NormalAttributeImpl extends AttributeImpl {
                private String _value;

                public NormalAttributeImpl(XMLName xMLName, String str) {
                    this._name = xMLName;
                    this._value = str;
                }

                public String getValue() {
                    return this._value;
                }
            }

            /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
            public static class XmlnsAttributeImpl extends AttributeImpl {
                private String _uri;

                public XmlnsAttributeImpl(String str, String str2) {
                    this._uri = str2;
                    int length = str.length();
                    String str3 = XMLConstants.XMLNS_ATTRIBUTE;
                    if (length == 0) {
                        str = XMLConstants.XMLNS_ATTRIBUTE;
                        str3 = null;
                    }
                    this._name = new XmlNameImpl((String) null, str, str3);
                }

                public String getValue() {
                    return this._uri;
                }
            }

            public StartElementImpl(XMLName xMLName, AttributeImpl attributeImpl, AttributeImpl attributeImpl2, Map map) {
                super(2);
                this._name = xMLName;
                this._attributes = attributeImpl;
                this._namespaces = attributeImpl2;
                this._prefixMap = map;
            }

            public Attribute getAttributeByName(XMLName xMLName) {
                for (AttributeImpl attributeImpl = this._attributes; attributeImpl != null; attributeImpl = attributeImpl._next) {
                    if (xMLName.equals(attributeImpl.getName())) {
                        return attributeImpl;
                    }
                }
                return null;
            }

            public AttributeIterator getAttributes() {
                return new AttributeIteratorImpl(this._attributes, null);
            }

            public AttributeIterator getAttributesAndNamespaces() {
                return new AttributeIteratorImpl(this._attributes, this._namespaces);
            }

            @Override // org.apache.xmlbeans.impl.store.Saver.XmlInputStreamSaver.XmlEventImpl
            public XMLName getName() {
                return this._name;
            }

            public Map getNamespaceMap() {
                return this._prefixMap;
            }

            public String getNamespaceUri(String str) {
                Map map = this._prefixMap;
                if (str == null) {
                    str = "";
                }
                return (String) map.get(str);
            }

            public AttributeIterator getNamespaces() {
                return new AttributeIteratorImpl(null, this._namespaces);
            }

            @Override // org.apache.xmlbeans.impl.store.Saver.XmlInputStreamSaver.XmlEventImpl
            public boolean hasName() {
                return true;
            }

            /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
            public static class AttributeIteratorImpl implements AttributeIterator {
                private AttributeImpl _attributes;
                private AttributeImpl _namespaces;

                public AttributeIteratorImpl(AttributeImpl attributeImpl, AttributeImpl attributeImpl2) {
                    this._attributes = attributeImpl;
                    this._namespaces = attributeImpl2;
                }

                public boolean hasNext() {
                    boolean z;
                    synchronized (monitor()) {
                        try {
                            checkVersion();
                            z = (this._attributes == null && this._namespaces == null) ? false : true;
                        } finally {
                        }
                    }
                    return z;
                }

                public Attribute next() {
                    AttributeImpl attributeImpl;
                    synchronized (monitor()) {
                        try {
                            checkVersion();
                            attributeImpl = this._attributes;
                            if (attributeImpl != null) {
                                this._attributes = attributeImpl._next;
                            } else {
                                attributeImpl = this._namespaces;
                                if (attributeImpl != null) {
                                    this._namespaces = attributeImpl._next;
                                } else {
                                    attributeImpl = null;
                                }
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    return attributeImpl;
                }

                public Attribute peek() {
                    synchronized (monitor()) {
                        try {
                            checkVersion();
                            AttributeImpl attributeImpl = this._attributes;
                            if (attributeImpl != null) {
                                return attributeImpl;
                            }
                            AttributeImpl attributeImpl2 = this._namespaces;
                            if (attributeImpl2 == null) {
                                attributeImpl2 = null;
                            }
                            return attributeImpl2;
                        } finally {
                        }
                    }
                }

                public void skip() {
                    synchronized (monitor()) {
                        try {
                            checkVersion();
                            AttributeImpl attributeImpl = this._attributes;
                            if (attributeImpl != null) {
                                this._attributes = attributeImpl._next;
                            } else {
                                AttributeImpl attributeImpl2 = this._namespaces;
                                if (attributeImpl2 != null) {
                                    this._namespaces = attributeImpl2._next;
                                }
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }

                private final void checkVersion() {
                }

                public Object monitor() {
                    return this;
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class SaxSaver extends Saver {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private AttributesImpl _attributes;
        private char[] _buf;
        private ContentHandler _contentHandler;
        private LexicalHandler _lexicalHandler;
        private boolean _nsAsAttrs;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class SaverSAXException extends RuntimeException {
            SAXException _saxException;

            public SaverSAXException(SAXException sAXException) {
                this._saxException = sAXException;
            }
        }

        public SaxSaver(Cur cur, XmlOptions xmlOptions, ContentHandler contentHandler, LexicalHandler lexicalHandler) throws SAXException {
            super(cur, xmlOptions);
            this._contentHandler = contentHandler;
            this._lexicalHandler = lexicalHandler;
            this._attributes = new AttributesImpl();
            this._nsAsAttrs = !xmlOptions.hasOption(XmlOptions.SAVE_SAX_NO_NSDECLS_IN_ATTRIBUTES);
            this._contentHandler.startDocument();
            while (true) {
                try {
                    process();
                } catch (SaverSAXException e) {
                    throw e._saxException;
                }
            }
        }

        private void emitNamespacesHelper() {
            iterateMappings();
            while (hasMapping()) {
                String strMappingPrefix = mappingPrefix();
                String strMappingUri = mappingUri();
                try {
                    this._contentHandler.startPrefixMapping(strMappingPrefix, strMappingUri);
                    if (this._nsAsAttrs) {
                        if (strMappingPrefix == null || strMappingPrefix.length() == 0) {
                            this._attributes.addAttribute("http://www.w3.org/2000/xmlns/", XMLConstants.XMLNS_ATTRIBUTE, XMLConstants.XMLNS_ATTRIBUTE, "CDATA", strMappingUri);
                        } else {
                            this._attributes.addAttribute("http://www.w3.org/2000/xmlns/", strMappingPrefix, "xmlns:".concat(strMappingPrefix), "CDATA", strMappingUri);
                        }
                    }
                    nextMapping();
                } catch (SAXException e) {
                    throw new SaverSAXException(e);
                }
            }
        }

        private String getPrefixedName(QName qName) {
            String namespaceURI = qName.getNamespaceURI();
            String localPart = qName.getLocalPart();
            if (namespaceURI.length() != 0) {
                String uriMapping = getUriMapping(namespaceURI);
                if (uriMapping.length() != 0) {
                    return AbstractC0541b.m757C(uriMapping, ":", localPart);
                }
            }
            return localPart;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitComment(SaveCur saveCur) {
            if (this._lexicalHandler != null) {
                saveCur.push();
                saveCur.next();
                try {
                    if (saveCur.isText()) {
                        Object chars = saveCur.getChars();
                        if (chars instanceof char[]) {
                            this._lexicalHandler.comment((char[]) chars, saveCur._offSrc, saveCur._cchSrc);
                        } else {
                            char[] cArr = this._buf;
                            if (cArr == null || cArr.length < saveCur._cchSrc) {
                                this._buf = new char[Math.max(1024, saveCur._cchSrc)];
                            }
                            CharUtil.getChars(this._buf, 0, chars, saveCur._offSrc, saveCur._cchSrc);
                            this._lexicalHandler.comment(this._buf, 0, saveCur._cchSrc);
                        }
                    } else {
                        this._lexicalHandler.comment(null, 0, 0);
                    }
                    saveCur.pop();
                } catch (SAXException e) {
                    throw new SaverSAXException(e);
                }
            }
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitDocType(String str, String str2, String str3) {
            LexicalHandler lexicalHandler = this._lexicalHandler;
            if (lexicalHandler != null) {
                try {
                    lexicalHandler.startDTD(str, str2, str3);
                    this._lexicalHandler.endDTD();
                } catch (SAXException e) {
                    throw new SaverSAXException(e);
                }
            }
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public boolean emitElement(SaveCur saveCur, ArrayList arrayList, ArrayList arrayList2) {
            this._attributes.clear();
            if (saveNamespacesFirst()) {
                emitNamespacesHelper();
            }
            for (int i = 0; i < arrayList.size(); i++) {
                QName qName = (QName) arrayList.get(i);
                this._attributes.addAttribute(qName.getNamespaceURI(), qName.getLocalPart(), getPrefixedName(qName), "CDATA", (String) arrayList2.get(i));
            }
            if (!saveNamespacesFirst()) {
                emitNamespacesHelper();
            }
            QName name = saveCur.getName();
            try {
                this._contentHandler.startElement(name.getNamespaceURI(), name.getLocalPart(), getPrefixedName(name), this._attributes);
                return false;
            } catch (SAXException e) {
                throw new SaverSAXException(e);
            }
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitFinish(SaveCur saveCur) {
            QName name = saveCur.getName();
            try {
                this._contentHandler.endElement(name.getNamespaceURI(), name.getLocalPart(), getPrefixedName(name));
                iterateMappings();
                while (hasMapping()) {
                    this._contentHandler.endPrefixMapping(mappingPrefix());
                    nextMapping();
                }
            } catch (SAXException e) {
                throw new SaverSAXException(e);
            }
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitProcinst(SaveCur saveCur) {
            saveCur.getName().getLocalPart();
            saveCur.push();
            saveCur.next();
            String string = CharUtil.getString(saveCur.getChars(), saveCur._offSrc, saveCur._cchSrc);
            saveCur.pop();
            try {
                this._contentHandler.processingInstruction(saveCur.getName().getLocalPart(), string);
            } catch (SAXException e) {
                throw new SaverSAXException(e);
            }
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitText(SaveCur saveCur) {
            Object chars = saveCur.getChars();
            try {
                if (chars instanceof char[]) {
                    this._contentHandler.characters((char[]) chars, saveCur._offSrc, saveCur._cchSrc);
                    return;
                }
                if (this._buf == null) {
                    this._buf = new char[1024];
                }
                while (true) {
                    int i = saveCur._cchSrc;
                    if (i <= 0) {
                        return;
                    }
                    int iMin = Math.min(this._buf.length, i);
                    CharUtil.getChars(this._buf, 0, chars, saveCur._offSrc, iMin);
                    this._contentHandler.characters(this._buf, 0, iMin);
                    saveCur._offSrc += iMin;
                    saveCur._cchSrc -= iMin;
                }
            } catch (SAXException e) {
                throw new SaverSAXException(e);
            }
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitEndDoc(SaveCur saveCur) {
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitStartDoc(SaveCur saveCur) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class SynthNamespaceSaver extends Saver {
        LinkedHashMap _synthNamespaces;

        public SynthNamespaceSaver(Cur cur, XmlOptions xmlOptions) {
            super(cur, xmlOptions);
            this._synthNamespaces = new LinkedHashMap();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public boolean emitElement(SaveCur saveCur, ArrayList arrayList, ArrayList arrayList2) {
            return false;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void syntheticNamespace(String str, String str2, boolean z) {
            LinkedHashMap linkedHashMap = this._synthNamespaces;
            if (z) {
                str = "";
            }
            linkedHashMap.put(str2, str);
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitComment(SaveCur saveCur) {
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitEndDoc(SaveCur saveCur) {
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitFinish(SaveCur saveCur) {
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitProcinst(SaveCur saveCur) {
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitStartDoc(SaveCur saveCur) {
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitText(SaveCur saveCur) {
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitDocType(String str, String str2, String str3) {
        }
    }

    public void syntheticNamespace(String str, String str2, boolean z) {
    }
}
