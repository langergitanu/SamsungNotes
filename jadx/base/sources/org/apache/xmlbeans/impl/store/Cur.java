package org.apache.xmlbeans.impl.store;

import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.somrecognize.common.Constant;
import java.io.PrintStream;
import java.util.Map;
import kotlin.collections.AbstractC12991c;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlDocumentProperties;
import org.apache.xmlbeans.XmlLineNumber;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.store.DomImpl;
import org.apache.xmlbeans.impl.store.Locale;
import org.apache.xmlbeans.impl.store.Xobj;
import org.apache.xmlbeans.impl.values.TypeStoreUser;
import org.slf4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.Node;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
final class Cur {
    static final /* synthetic */ boolean $assertionsDisabled;
    static final int ATTR = 3;
    static final int COMMENT = 4;
    static final int DISPOSED = 3;
    static final int ELEM = 2;
    static final int EMBEDDED = 2;
    static final int END_POS = -1;
    static final String LOAD_USE_LOCALE_CHAR_UTIL = "LOAD_USE_LOCALE_CHAR_UTIL";
    static final int NO_POS = -2;
    static final int POOLED = 0;
    static final int PROCINST = 5;
    static final int REGISTERED = 1;
    static final int ROOT = 1;
    static final int TEXT = 0;
    static /* synthetic */ Class class$org$apache$xmlbeans$CDataBookmark;
    static /* synthetic */ Class class$org$apache$xmlbeans$XmlLineNumber;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$soap$Detail;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$soap$DetailEntry;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$soap$SOAPBody;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$soap$SOAPBodyElement;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$soap$SOAPElement;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$soap$SOAPEnvelope;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$soap$SOAPFault;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$soap$SOAPFaultElement;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$soap$SOAPHeader;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$soap$SOAPHeaderElement;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$store$Cur;
    int _cchSrc;
    String _id;
    Locale _locale;
    Cur _next;
    Cur _nextTemp;
    int _offSrc;
    private int _posTemp;
    Cur _prev;
    Cur _prevTemp;
    Locale.Ref _ref;
    Xobj _xobj;
    int _pos = -2;
    int _tempFrame = -1;
    int _state = 0;
    int _stackTop = -1;
    int _selectionFirst = -1;
    int _selectionN = -1;
    int _selectionLoc = -1;
    int _selectionCount = 0;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Locations {
        static final /* synthetic */ boolean $assertionsDisabled;
        private static final int NULL = -1;
        private static final int _initialSize = 32;
        private int _free;
        private Locale _locale;
        private int _naked;
        private Xobj[] _xobjs = new Xobj[32];
        private int[] _poses = new int[32];
        private Cur[] _curs = new Cur[32];
        private int[] _next = new int[32];
        private int[] _prev = new int[32];
        private int[] _nextN = new int[32];
        private int[] _prevN = new int[32];

        static {
            if (Cur.class$org$apache$xmlbeans$impl$store$Cur == null) {
                Cur.class$org$apache$xmlbeans$impl$store$Cur = Cur.class$("org.apache.xmlbeans.impl.store.Cur");
            }
            $assertionsDisabled = true;
        }

        public Locations(Locale locale) {
            this._locale = locale;
            for (int i = 31; i >= 0; i--) {
                if (!$assertionsDisabled && this._xobjs[i] != null) {
                    throw new AssertionError();
                }
                this._poses[i] = -2;
                this._next[i] = i + 1;
                this._prev[i] = -1;
                this._nextN[i] = -1;
                this._prevN[i] = -1;
            }
            this._next[31] = -1;
            this._free = 0;
            this._naked = -1;
        }

        private void makeRoom() {
            if (!$assertionsDisabled && this._free != -1) {
                throw new AssertionError();
            }
            Xobj[] xobjArr = this._xobjs;
            int length = xobjArr.length;
            int[] iArr = this._poses;
            Cur[] curArr = this._curs;
            int[] iArr2 = this._next;
            int[] iArr3 = this._prev;
            int[] iArr4 = this._nextN;
            int[] iArr5 = this._prevN;
            int i = length * 2;
            Xobj[] xobjArr2 = new Xobj[i];
            this._xobjs = xobjArr2;
            this._poses = new int[i];
            this._curs = new Cur[i];
            this._next = new int[i];
            this._prev = new int[i];
            this._nextN = new int[i];
            this._prevN = new int[i];
            System.arraycopy(xobjArr, 0, xobjArr2, 0, length);
            System.arraycopy(iArr, 0, this._poses, 0, length);
            System.arraycopy(curArr, 0, this._curs, 0, length);
            System.arraycopy(iArr2, 0, this._next, 0, length);
            System.arraycopy(iArr3, 0, this._prev, 0, length);
            System.arraycopy(iArr4, 0, this._nextN, 0, length);
            System.arraycopy(iArr5, 0, this._prevN, 0, length);
            int i2 = i - 1;
            for (int i4 = i2; i4 >= length; i4--) {
                this._next[i4] = i4 + 1;
                this._prev[i4] = -1;
                this._nextN[i4] = -1;
                this._prevN[i4] = -1;
                this._poses[i4] = -2;
            }
            this._next[i2] = -1;
            this._free = length;
        }

        public int allocate(Cur cur) {
            boolean z = $assertionsDisabled;
            if (!z && !cur.isPositioned()) {
                throw new AssertionError();
            }
            if (this._free == -1) {
                makeRoom();
            }
            int i = this._free;
            int[] iArr = this._next;
            this._free = iArr[i];
            iArr[i] = -1;
            if (!z && this._prev[i] != -1) {
                throw new AssertionError();
            }
            if (!z && this._curs[i] != null) {
                throw new AssertionError();
            }
            if (!z && this._xobjs[i] != null) {
                throw new AssertionError();
            }
            if (!z && this._poses[i] != -2) {
                throw new AssertionError();
            }
            this._xobjs[i] = cur._xobj;
            this._poses[i] = cur._pos;
            this._naked = insert(this._naked, -1, i, this._nextN, this._prevN);
            return i;
        }

        public int insert(int i, int i2, int i4) {
            return insert(i, i2, i4, this._next, this._prev);
        }

        public boolean isAtEndOf(int i, Cur cur) {
            Cur cur2;
            boolean z = $assertionsDisabled;
            if (!z && this._curs[i] == null && this._poses[i] != 0) {
                throw new AssertionError();
            }
            if (!z && (cur2 = this._curs[i]) != null && !cur2.isNode()) {
                throw new AssertionError();
            }
            Cur cur3 = this._curs[i];
            return cur3 == null ? cur._xobj == this._xobjs[i] && cur._pos == -1 : cur.isAtEndOf(cur3);
        }

        public boolean isSamePos(int i, Cur cur) {
            Cur cur2 = this._curs[i];
            return cur2 == null ? cur._xobj == this._xobjs[i] && cur._pos == this._poses[i] : cur.isSamePos(cur2);
        }

        public void moveTo(int i, Cur cur) {
            Cur cur2 = this._curs[i];
            if (cur2 == null) {
                cur.moveTo(this._xobjs[i], this._poses[i]);
            } else {
                cur.moveToCur(cur2);
            }
        }

        public int next(int i) {
            return this._next[i];
        }

        public void notifyChange() {
            while (true) {
                int i = this._naked;
                if (i == -1) {
                    return;
                }
                if (!$assertionsDisabled && (this._curs[i] != null || this._xobjs[i] == null || this._poses[i] == -2)) {
                    break;
                }
                this._naked = remove(i, i, this._nextN, this._prevN);
                this._curs[i] = this._locale.getCur();
                this._curs[i].moveTo(this._xobjs[i], this._poses[i]);
                this._xobjs[i] = null;
                this._poses[i] = -2;
            }
            throw new AssertionError();
        }

        public int prev(int i) {
            return this._prev[i];
        }

        public int remove(int i, int i2) {
            Cur cur = this._curs[i2];
            boolean z = $assertionsDisabled;
            if (!z && cur == null && this._xobjs[i2] == null) {
                throw new AssertionError();
            }
            if (!z && cur == null && this._xobjs[i2] == null) {
                throw new AssertionError();
            }
            if (cur != null) {
                cur.release();
                this._curs[i2] = null;
                if (!z && this._xobjs[i2] != null) {
                    throw new AssertionError();
                }
                if (!z && this._poses[i2] != -2) {
                    throw new AssertionError();
                }
            } else {
                if (!z && (this._xobjs[i2] == null || this._poses[i2] == -2)) {
                    throw new AssertionError();
                }
                this._xobjs[i2] = null;
                this._poses[i2] = -2;
                this._naked = remove(this._naked, i2, this._nextN, this._prevN);
            }
            int iRemove = remove(i, i2, this._next, this._prev);
            this._next[i2] = this._free;
            this._free = i2;
            return iRemove;
        }

        private static int insert(int i, int i2, int i4, int[] iArr, int[] iArr2) {
            if (i == -1) {
                if (!$assertionsDisabled && i2 != -1) {
                    throw new AssertionError();
                }
                iArr2[i4] = i4;
                return i4;
            }
            if (i2 != -1) {
                iArr2[i4] = iArr2[i2];
                iArr[i4] = i2;
                iArr2[i2] = i4;
                return i == i2 ? i4 : i;
            }
            iArr2[i4] = iArr2[i];
            if (!$assertionsDisabled && iArr[i4] != -1) {
                throw new AssertionError();
            }
            iArr[iArr2[i]] = i4;
            iArr2[i] = i4;
            return i;
        }

        private static int remove(int i, int i2, int[] iArr, int[] iArr2) {
            int i4 = iArr2[i2];
            if (i4 == i2) {
                if (!$assertionsDisabled && i != i2) {
                    throw new AssertionError();
                }
                i = -1;
            } else {
                if (i == i2) {
                    i = iArr[i2];
                } else {
                    iArr[i4] = iArr[i2];
                }
                int i5 = iArr[i2];
                if (i5 == -1) {
                    iArr2[i] = iArr2[i2];
                } else {
                    iArr2[i5] = iArr2[i2];
                    iArr[i2] = -1;
                }
            }
            iArr2[i2] = -1;
            if ($assertionsDisabled || iArr[i2] == -1) {
                return i;
            }
            throw new AssertionError();
        }
    }

    static {
        if (class$org$apache$xmlbeans$impl$store$Cur == null) {
            class$org$apache$xmlbeans$impl$store$Cur = class$("org.apache.xmlbeans.impl.store.Cur");
        }
        $assertionsDisabled = true;
    }

    public Cur(Locale locale) {
        this._locale = locale;
    }

    public static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw AbstractC12991c.m13994o(e);
        }
    }

    public static Xobj createDomDocumentRootXobj(Locale locale) {
        return createDomDocumentRootXobj(locale, false);
    }

    public static Xobj createElementXobj(Locale locale, QName qName, QName qName2) throws Throwable {
        Saaj saaj = locale._saaj;
        if (saaj == null) {
            return new Xobj.ElementXobj(locale, qName);
        }
        Class clsIdentifyElement = saaj.identifyElement(qName, qName2);
        Class clsClass$ = class$org$apache$xmlbeans$impl$soap$SOAPElement;
        if (clsClass$ == null) {
            clsClass$ = class$("org.apache.xmlbeans.impl.soap.SOAPElement");
            class$org$apache$xmlbeans$impl$soap$SOAPElement = clsClass$;
        }
        if (clsIdentifyElement == clsClass$) {
            return new Xobj.SoapElementXobj(locale, qName);
        }
        Class clsClass$2 = class$org$apache$xmlbeans$impl$soap$SOAPBody;
        if (clsClass$2 == null) {
            clsClass$2 = class$("org.apache.xmlbeans.impl.soap.SOAPBody");
            class$org$apache$xmlbeans$impl$soap$SOAPBody = clsClass$2;
        }
        if (clsIdentifyElement == clsClass$2) {
            return new Xobj.SoapBodyXobj(locale, qName);
        }
        Class clsClass$3 = class$org$apache$xmlbeans$impl$soap$SOAPBodyElement;
        if (clsClass$3 == null) {
            clsClass$3 = class$("org.apache.xmlbeans.impl.soap.SOAPBodyElement");
            class$org$apache$xmlbeans$impl$soap$SOAPBodyElement = clsClass$3;
        }
        if (clsIdentifyElement == clsClass$3) {
            return new Xobj.SoapBodyElementXobj(locale, qName);
        }
        Class clsClass$4 = class$org$apache$xmlbeans$impl$soap$SOAPEnvelope;
        if (clsClass$4 == null) {
            clsClass$4 = class$("org.apache.xmlbeans.impl.soap.SOAPEnvelope");
            class$org$apache$xmlbeans$impl$soap$SOAPEnvelope = clsClass$4;
        }
        if (clsIdentifyElement == clsClass$4) {
            return new Xobj.SoapEnvelopeXobj(locale, qName);
        }
        Class clsClass$5 = class$org$apache$xmlbeans$impl$soap$SOAPHeader;
        if (clsClass$5 == null) {
            clsClass$5 = class$("org.apache.xmlbeans.impl.soap.SOAPHeader");
            class$org$apache$xmlbeans$impl$soap$SOAPHeader = clsClass$5;
        }
        if (clsIdentifyElement == clsClass$5) {
            return new Xobj.SoapHeaderXobj(locale, qName);
        }
        Class clsClass$6 = class$org$apache$xmlbeans$impl$soap$SOAPHeaderElement;
        if (clsClass$6 == null) {
            clsClass$6 = class$("org.apache.xmlbeans.impl.soap.SOAPHeaderElement");
            class$org$apache$xmlbeans$impl$soap$SOAPHeaderElement = clsClass$6;
        }
        if (clsIdentifyElement == clsClass$6) {
            return new Xobj.SoapHeaderElementXobj(locale, qName);
        }
        Class clsClass$7 = class$org$apache$xmlbeans$impl$soap$SOAPFaultElement;
        if (clsClass$7 == null) {
            clsClass$7 = class$("org.apache.xmlbeans.impl.soap.SOAPFaultElement");
            class$org$apache$xmlbeans$impl$soap$SOAPFaultElement = clsClass$7;
        }
        if (clsIdentifyElement == clsClass$7) {
            return new Xobj.SoapFaultElementXobj(locale, qName);
        }
        Class clsClass$8 = class$org$apache$xmlbeans$impl$soap$Detail;
        if (clsClass$8 == null) {
            clsClass$8 = class$("org.apache.xmlbeans.impl.soap.Detail");
            class$org$apache$xmlbeans$impl$soap$Detail = clsClass$8;
        }
        if (clsIdentifyElement == clsClass$8) {
            return new Xobj.DetailXobj(locale, qName);
        }
        Class clsClass$9 = class$org$apache$xmlbeans$impl$soap$DetailEntry;
        if (clsClass$9 == null) {
            clsClass$9 = class$("org.apache.xmlbeans.impl.soap.DetailEntry");
            class$org$apache$xmlbeans$impl$soap$DetailEntry = clsClass$9;
        }
        if (clsIdentifyElement == clsClass$9) {
            return new Xobj.DetailEntryXobj(locale, qName);
        }
        Class clsClass$10 = class$org$apache$xmlbeans$impl$soap$SOAPFault;
        if (clsClass$10 == null) {
            clsClass$10 = class$("org.apache.xmlbeans.impl.soap.SOAPFault");
            class$org$apache$xmlbeans$impl$soap$SOAPFault = clsClass$10;
        }
        if (clsIdentifyElement == clsClass$10) {
            return new Xobj.SoapFaultXobj(locale, qName);
        }
        StringBuffer stringBuffer = new StringBuffer("Unknown SAAJ element class: ");
        stringBuffer.append(clsIdentifyElement);
        throw new IllegalStateException(stringBuffer.toString());
    }

    private void createHelper(Xobj xobj) {
        if (!$assertionsDisabled && xobj._locale != this._locale) {
            throw new AssertionError();
        }
        if (isPositioned()) {
            Cur curTempCur = tempCur(xobj, 0);
            curTempCur.moveNode(this);
            curTempCur.release();
        }
        moveTo(xobj);
    }

    public static void dump(PrintStream printStream, DomImpl.Dom dom, Object obj) {
    }

    private static void dumpBookmarks(PrintStream printStream, Xobj xobj, Object obj) {
        for (Xobj.Bookmark bookmark = xobj._bookmarks; bookmark != null; bookmark = bookmark._next) {
            printStream.print(" ");
            if (obj == bookmark) {
                printStream.print("*:");
            }
            Object obj2 = bookmark._value;
            if (obj2 instanceof XmlLineNumber) {
                StringBuffer stringBuffer = new StringBuffer("<line:");
                stringBuffer.append(((XmlLineNumber) obj2).getLine());
                stringBuffer.append(">[");
                stringBuffer.append(bookmark._pos);
                stringBuffer.append("]");
                printStream.print(stringBuffer.toString());
            } else {
                StringBuffer stringBuffer2 = new StringBuffer("<mark>[");
                stringBuffer2.append(bookmark._pos);
                stringBuffer2.append("]");
                printStream.print(stringBuffer2.toString());
            }
        }
    }

    private static void dumpCharNodes(PrintStream printStream, DomImpl.CharNode charNode, Object obj) {
        while (charNode != null) {
            printStream.print(" ");
            if (charNode == obj) {
                printStream.print("*");
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(charNode instanceof DomImpl.TextNode ? "TEXT" : "CDATA");
            stringBuffer.append("[");
            stringBuffer.append(charNode._cch);
            stringBuffer.append("]");
            printStream.print(stringBuffer.toString());
            charNode = charNode._next;
        }
    }

    private static void dumpChars(PrintStream printStream, Object obj, int i, int i2) {
        printStream.print("\"");
        String string = CharUtil.getString(obj, i, i2);
        int i4 = 0;
        while (true) {
            if (i4 >= string.length()) {
                break;
            }
            if (i4 == 36) {
                printStream.print("...");
                break;
            }
            char cCharAt = string.charAt(i4);
            if (cCharAt >= ' ' && cCharAt < 127) {
                printStream.print(cCharAt);
            } else if (cCharAt == '\n') {
                printStream.print("\\n");
            } else if (cCharAt == '\r') {
                printStream.print("\\r");
            } else if (cCharAt == '\t') {
                printStream.print("\\t");
            } else if (cCharAt == '\"') {
                printStream.print("\\\"");
            } else {
                StringBuffer stringBuffer = new StringBuffer("<#");
                stringBuffer.append((int) cCharAt);
                stringBuffer.append(">");
                printStream.print(stringBuffer.toString());
            }
            i4++;
        }
        printStream.print("\"");
    }

    private static void dumpCur(PrintStream printStream, String str, Cur cur, Object obj) {
        printStream.print(" ");
        if (obj == cur) {
            printStream.print("*:");
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        String str2 = cur._id;
        if (str2 == null) {
            str2 = "<cur>";
        }
        stringBuffer.append(str2);
        stringBuffer.append("[");
        stringBuffer.append(cur._pos);
        stringBuffer.append("]");
        printStream.print(stringBuffer.toString());
    }

    private static void dumpCurs(PrintStream printStream, Xobj xobj, Object obj) {
        for (Cur cur = xobj._embedded; cur != null; cur = cur._next) {
            dumpCur(printStream, "E:", cur, obj);
        }
        for (Cur cur2 = xobj._locale._registered; cur2 != null; cur2 = cur2._next) {
            if (cur2._xobj == xobj) {
                dumpCur(printStream, "R:", cur2, obj);
            }
        }
    }

    private static void dumpXobj(PrintStream printStream, Xobj xobj, int i, Object obj) {
        int iLastIndexOf;
        if (xobj == null) {
            return;
        }
        if (xobj == obj) {
            printStream.print("* ");
        } else {
            printStream.print(Constant.WHITE_SPACE_FOR_LINK_ICON);
        }
        for (int i2 = 0; i2 < i; i2++) {
            printStream.print(Constant.WHITE_SPACE_FOR_LINK_ICON);
        }
        printStream.print(kindName(xobj.kind()));
        if (xobj._name != null) {
            printStream.print(" ");
            if (xobj._name.getPrefix().length() > 0) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(xobj._name.getPrefix());
                stringBuffer.append(":");
                printStream.print(stringBuffer.toString());
            }
            printStream.print(xobj._name.getLocalPart());
            if (xobj._name.getNamespaceURI().length() > 0) {
                StringBuffer stringBuffer2 = new StringBuffer(Log.TAG_SEPARATOR);
                stringBuffer2.append(xobj._name.getNamespaceURI());
                printStream.print(stringBuffer2.toString());
            }
        }
        if (xobj._srcValue != null || xobj._charNodesValue != null) {
            printStream.print(" Value( ");
            dumpChars(printStream, xobj._srcValue, xobj._offValue, xobj._cchValue);
            dumpCharNodes(printStream, xobj._charNodesValue, obj);
            printStream.print(" )");
        }
        if (xobj._user != null) {
            printStream.print(" (USER)");
        }
        if (xobj.isVacant()) {
            printStream.print(" (VACANT)");
        }
        if (xobj._srcAfter != null || xobj._charNodesAfter != null) {
            printStream.print(" After( ");
            dumpChars(printStream, xobj._srcAfter, xobj._offAfter, xobj._cchAfter);
            dumpCharNodes(printStream, xobj._charNodesAfter, obj);
            printStream.print(" )");
        }
        dumpCurs(printStream, xobj, obj);
        dumpBookmarks(printStream, xobj, obj);
        String name = xobj.getClass().getName();
        int iLastIndexOf2 = name.lastIndexOf(46);
        if (iLastIndexOf2 > 0 && (iLastIndexOf = (name = name.substring(iLastIndexOf2 + 1)).lastIndexOf(36)) > 0) {
            name = name.substring(iLastIndexOf + 1);
        }
        printStream.print(" (");
        printStream.print(name);
        printStream.print(")");
        printStream.println();
        for (Xobj xobj2 = xobj._firstChild; xobj2 != null; xobj2 = xobj2._nextSibling) {
            dumpXobj(printStream, xobj2, i + 1, obj);
        }
    }

    private Xobj getDenormal() {
        if ($assertionsDisabled || isPositioned()) {
            return getDenormal(this._xobj, this._pos);
        }
        throw new AssertionError();
    }

    private Xobj getNormal(Xobj xobj, int i) {
        Xobj normal = xobj.getNormal(i);
        this._posTemp = xobj._locale._posTemp;
        return normal;
    }

    public static boolean kindIsContainer(int i) {
        return i == 2 || i == 1;
    }

    public static boolean kindIsFinish(int i) {
        return i == -2 || i == -1;
    }

    public static String kindName(int i) {
        if (i == 0) {
            return "TEXT";
        }
        if (i == 1) {
            return Logger.ROOT_LOGGER_NAME;
        }
        if (i == 2) {
            return "ELEM";
        }
        if (i == 3) {
            return "ATTR";
        }
        if (i == 4) {
            return "COMMENT";
        }
        if (i == 5) {
            return "PROCINST";
        }
        StringBuffer stringBuffer = new StringBuffer("<< Unknown Kind (");
        stringBuffer.append(i);
        stringBuffer.append(") >>");
        return stringBuffer.toString();
    }

    public static void release(Cur cur) {
        if (cur != null) {
            cur.release();
        }
    }

    private int selectionIndex(int i) {
        if (!$assertionsDisabled && (this._selectionN < -1 || i < 0 || i >= this._selectionCount)) {
            throw new AssertionError();
        }
        if (this._selectionN == -1) {
            this._selectionN = 0;
            this._selectionLoc = this._selectionFirst;
        }
        while (this._selectionN < i) {
            this._selectionLoc = this._locale._locations.next(this._selectionLoc);
            this._selectionN++;
        }
        while (this._selectionN > i) {
            this._selectionLoc = this._locale._locations.prev(this._selectionLoc);
            this._selectionN--;
        }
        return this._selectionLoc;
    }

    private static void transferChars(Xobj xobj, int i, Xobj xobj2, int i2, int i4) {
        boolean z = $assertionsDisabled;
        if (!z && xobj == xobj2) {
            throw new AssertionError();
        }
        if (!z && xobj._locale != xobj2._locale) {
            throw new AssertionError();
        }
        if (!z && (i <= 0 || i >= xobj.posMax())) {
            throw new AssertionError();
        }
        if (!z && (i2 <= 0 || i2 > xobj2.posMax())) {
            throw new AssertionError();
        }
        if (!z && (i4 <= 0 || i4 > xobj.cchRight(i))) {
            throw new AssertionError();
        }
        if (!z && i2 < xobj2.posAfter() && !xobj2.isOccupied()) {
            throw new AssertionError();
        }
        Object charsHelper = xobj.getCharsHelper(i, i4);
        Locale locale = xobj._locale;
        xobj2.insertCharsHelper(i2, charsHelper, locale._offSrc, locale._cchSrc, false);
        xobj.removeCharsHelper(i, i4, xobj2, i2, true, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static DomImpl.CharNode updateCharNodes(Locale locale, Xobj xobj, DomImpl.CharNode charNode, int i) {
        if (!$assertionsDisabled && charNode != null && charNode.locale() != locale) {
            throw new AssertionError();
        }
        DomImpl.CharNode charNode2 = charNode;
        int i2 = 0;
        while (charNode2 != null && i > 0) {
            if (!$assertionsDisabled && charNode2.getDom() != xobj) {
                throw new AssertionError();
            }
            if (charNode2._cch > i) {
                charNode2._cch = i;
            }
            charNode2._off = i2;
            int i4 = charNode2._cch;
            i2 += i4;
            i -= i4;
            charNode2 = charNode2._next;
        }
        if (i > 0) {
            DomImpl.TextNode textNodeCreateTextNode = locale.createTextNode();
            textNodeCreateTextNode.setDom((DomImpl.Dom) xobj);
            textNodeCreateTextNode._cch = i;
            textNodeCreateTextNode._off = i2;
            return DomImpl.CharNode.appendNode(charNode, textNodeCreateTextNode);
        }
        while (charNode2 != null) {
            if (!$assertionsDisabled && charNode2.getDom() != xobj) {
                throw new AssertionError();
            }
            if (charNode2._cch != 0) {
                charNode2._cch = 0;
            }
            charNode2._off = i2;
            charNode2 = charNode2._next;
        }
        return charNode;
    }

    public void addToSelection(Cur cur) {
        boolean z = $assertionsDisabled;
        if (!z && (cur == null || !cur.isNormal())) {
            throw new AssertionError();
        }
        if (!z && (!isPositioned() || !cur.isPositioned())) {
            throw new AssertionError();
        }
        this._selectionFirst = this._locale._locations.insert(this._selectionFirst, -1, this._locale._locations.allocate(cur));
        this._selectionCount++;
    }

    public int cchLeft() {
        if ($assertionsDisabled || isPositioned()) {
            return this._xobj.cchLeft(this._pos);
        }
        throw new AssertionError();
    }

    public int cchRight() {
        if ($assertionsDisabled || isPositioned()) {
            return this._xobj.cchRight(this._pos);
        }
        throw new AssertionError();
    }

    public void clearSelection() {
        if (!$assertionsDisabled && this._selectionCount < 0) {
            throw new AssertionError();
        }
        while (this._selectionCount > 0) {
            removeSelection(0);
        }
    }

    public int comparePosition(Cur cur) {
        if (!$assertionsDisabled && (!isPositioned() || !cur.isPositioned())) {
            throw new AssertionError();
        }
        if (this._locale != cur._locale) {
            return 2;
        }
        Xobj xobj = this._xobj;
        int iPosAfter = this._pos;
        if (iPosAfter == -1) {
            iPosAfter = xobj.posAfter() - 1;
        }
        Xobj xobj2 = cur._xobj;
        int iPosAfter2 = cur._pos;
        if (iPosAfter2 == -1) {
            iPosAfter2 = xobj2.posAfter() - 1;
        }
        int i = 0;
        if (xobj == xobj2) {
            if (iPosAfter < iPosAfter2) {
                return -1;
            }
            return iPosAfter == iPosAfter2 ? 0 : 1;
        }
        int i2 = 0;
        for (Xobj xobj3 = xobj._parent; xobj3 != null; xobj3 = xobj3._parent) {
            i2++;
            if (xobj3 == xobj2) {
                return iPosAfter2 < xobj2.posAfter() - 1 ? 1 : -1;
            }
        }
        for (Xobj xobj4 = xobj2._parent; xobj4 != null; xobj4 = xobj4._parent) {
            i++;
            if (xobj4 == xobj) {
                return iPosAfter < xobj.posAfter() - 1 ? -1 : 1;
            }
        }
        while (i2 > i) {
            i2--;
            xobj = xobj._parent;
        }
        while (i > i2) {
            i--;
            xobj2 = xobj2._parent;
        }
        boolean z = $assertionsDisabled;
        if (!z && i != i2) {
            throw new AssertionError();
        }
        if (i == 0) {
            return 2;
        }
        if (!z && (xobj._parent == null || xobj2._parent == null)) {
            throw new AssertionError();
        }
        while (true) {
            Xobj xobj5 = xobj._parent;
            Xobj xobj6 = xobj2._parent;
            if (xobj5 == xobj6) {
                if (xobj._prevSibling == null || xobj2._nextSibling == null) {
                    return -1;
                }
                if (xobj._nextSibling == null || xobj2._prevSibling == null) {
                    return 1;
                }
                while (xobj != null) {
                    xobj = xobj._prevSibling;
                    if (xobj == xobj2) {
                        return 1;
                    }
                }
                return -1;
            }
            if (xobj5 == null) {
                return 2;
            }
            xobj = xobj5;
            xobj2 = xobj6;
        }
    }

    public boolean contains(Cur cur) {
        boolean z = $assertionsDisabled;
        if (!z && !isNode()) {
            throw new AssertionError();
        }
        if (z || (cur != null && cur.isPositioned())) {
            return this._xobj.contains(cur);
        }
        throw new AssertionError();
    }

    public void copyNode(Cur cur) {
        boolean z = $assertionsDisabled;
        if (!z && cur == null) {
            throw new AssertionError();
        }
        if (!z && !isNode()) {
            throw new AssertionError();
        }
        Xobj xobjCopyNode = this._xobj.copyNode(cur._locale);
        if (cur.isPositioned()) {
            moveNode(xobjCopyNode, cur);
        } else {
            cur.moveTo(xobjCopyNode);
        }
    }

    public void createAttr(QName qName) {
        createHelper(new Xobj.AttrXobj(this._locale, qName));
    }

    public void createComment() {
        createHelper(new Xobj.CommentXobj(this._locale));
    }

    public void createDomDocFragRoot() {
        moveTo(new Xobj.DocumentFragXobj(this._locale));
    }

    public void createDomDocumentRoot() {
        moveTo(createDomDocumentRootXobj(this._locale));
    }

    public void createElement(QName qName) {
        createElement(qName, null);
    }

    public void createProcinst(String str) {
        createHelper(new Xobj.ProcInstXobj(this._locale, str));
    }

    public void createRoot() {
        createDomDocFragRoot();
    }

    public int firstBookmarkInChars(Object obj, int i) {
        boolean z = $assertionsDisabled;
        if (!z && !isNormal()) {
            throw new AssertionError();
        }
        if (!z && obj == null) {
            throw new AssertionError();
        }
        if (!z && i <= 0) {
            throw new AssertionError();
        }
        if (!z && i > cchRight()) {
            throw new AssertionError();
        }
        if (!isText()) {
            return -1;
        }
        int i2 = -1;
        for (Xobj.Bookmark bookmark = this._xobj._bookmarks; bookmark != null; bookmark = bookmark._next) {
            if (bookmark._key == obj && inChars(bookmark, i, false) && (i2 == -1 || bookmark._pos - this._pos < i2)) {
                i2 = bookmark._pos - this._pos;
            }
        }
        return i2;
    }

    public int firstBookmarkInCharsLeft(Object obj, int i) {
        int i2;
        boolean z = $assertionsDisabled;
        if (!z && !isNormal()) {
            throw new AssertionError();
        }
        if (!z && obj == null) {
            throw new AssertionError();
        }
        if (!z && i <= 0) {
            throw new AssertionError();
        }
        if (!z && i > cchLeft()) {
            throw new AssertionError();
        }
        if (cchLeft() <= 0) {
            return -1;
        }
        Xobj denormal = getDenormal();
        int i4 = this._posTemp - i;
        Xobj.Bookmark bookmark = denormal._bookmarks;
        int i5 = -1;
        while (bookmark != null) {
            if (bookmark._key == obj) {
                i2 = i;
                if (denormal.inChars(i4, bookmark._xobj, bookmark._pos, i2, false) && (i5 == -1 || bookmark._pos - i4 < i5)) {
                    i5 = bookmark._pos - i4;
                }
            } else {
                i2 = i;
            }
            bookmark = bookmark._next;
            i = i2;
        }
        return i5;
    }

    public String getAttrValue(QName qName) {
        push();
        String valueAsString = toAttr(qName) ? getValueAsString() : null;
        pop();
        return valueAsString;
    }

    public Object getBookmark(Object obj) {
        boolean z = $assertionsDisabled;
        if (!z && !isNormal()) {
            throw new AssertionError();
        }
        if (!z && obj == null) {
            throw new AssertionError();
        }
        for (Xobj.Bookmark bookmark = this._xobj._bookmarks; bookmark != null; bookmark = bookmark._next) {
            if (bookmark._pos == this._pos && bookmark._key == obj) {
                return bookmark._value;
            }
        }
        return null;
    }

    public DomImpl.CharNode getCharNodes() {
        boolean z = $assertionsDisabled;
        if (!z && !isPositioned()) {
            throw new AssertionError();
        }
        if (!z && isRoot()) {
            throw new AssertionError();
        }
        Xobj denormal = getDenormal();
        if (this._posTemp >= denormal.posAfter()) {
            DomImpl.CharNode charNodeUpdateCharNodes = updateCharNodes(this._locale, denormal, denormal._charNodesAfter, denormal._cchAfter);
            denormal._charNodesAfter = charNodeUpdateCharNodes;
            return charNodeUpdateCharNodes;
        }
        denormal.ensureOccupancy();
        DomImpl.CharNode charNodeUpdateCharNodes2 = updateCharNodes(this._locale, denormal, denormal._charNodesValue, denormal._cchValue);
        denormal._charNodesValue = charNodeUpdateCharNodes2;
        return charNodeUpdateCharNodes2;
    }

    public Object getChars(int i) {
        if ($assertionsDisabled || isPositioned()) {
            return this._xobj.getChars(this._pos, i, this);
        }
        throw new AssertionError();
    }

    public String getCharsAsString(int i) {
        if ($assertionsDisabled || (isNormal() && this._xobj != null)) {
            return getCharsAsString(i, 1);
        }
        throw new AssertionError();
    }

    public DomImpl.Dom getDom() {
        boolean z = $assertionsDisabled;
        if (!z && !isNormal()) {
            throw new AssertionError();
        }
        if (!z && !isPositioned()) {
            throw new AssertionError();
        }
        if (!isText()) {
            return this._xobj.getDom();
        }
        int iCchLeft = cchLeft();
        DomImpl.CharNode charNodes = getCharNodes();
        while (true) {
            iCchLeft -= charNodes._cch;
            if (iCchLeft < 0) {
                return charNodes;
            }
            charNodes = charNodes._next;
        }
    }

    public Object getFirstChars() {
        if (!$assertionsDisabled && !isNode()) {
            throw new AssertionError();
        }
        Object firstChars = this._xobj.getFirstChars();
        Locale locale = this._locale;
        this._offSrc = locale._offSrc;
        this._cchSrc = locale._cchSrc;
        return firstChars;
    }

    public String getLocal() {
        return getName().getLocalPart();
    }

    public QName getName() {
        if ($assertionsDisabled || isNode() || isEnd()) {
            return this._xobj._name;
        }
        throw new AssertionError();
    }

    public XmlObject getObject() {
        if (isUserNode()) {
            return (XmlObject) getUser();
        }
        return null;
    }

    public Xobj getParent() {
        return getParent(false);
    }

    public Xobj getParentNoRoot() {
        boolean z = $assertionsDisabled;
        if (!z && !isPositioned()) {
            throw new AssertionError();
        }
        int i = this._pos;
        if (i == -1 || (i >= 1 && i < this._xobj.posAfter())) {
            return this._xobj;
        }
        if (!z && this._pos != 0 && this._xobj._parent == null) {
            throw new AssertionError();
        }
        Xobj xobj = this._xobj._parent;
        if (xobj != null) {
            return xobj;
        }
        return null;
    }

    public Xobj getParentRaw() {
        return getParent(true);
    }

    public String getUri() {
        return getName().getNamespaceURI();
    }

    public TypeStoreUser getUser() {
        if ($assertionsDisabled || isUserNode()) {
            return this._xobj.getUser();
        }
        throw new AssertionError();
    }

    public String getValueAsString(int i) {
        if ($assertionsDisabled || isNode()) {
            return this._xobj.getValueAsString(i);
        }
        throw new AssertionError();
    }

    public String getXmlnsPrefix() {
        if ($assertionsDisabled || isXmlns()) {
            return this._xobj.getXmlnsPrefix();
        }
        throw new AssertionError();
    }

    public String getXmlnsUri() {
        if ($assertionsDisabled || isXmlns()) {
            return this._xobj.getXmlnsUri();
        }
        throw new AssertionError();
    }

    public final QName getXsiTypeName() {
        if ($assertionsDisabled || isNode()) {
            return this._xobj.getXsiTypeName();
        }
        throw new AssertionError();
    }

    public boolean hasAttrs() {
        if ($assertionsDisabled || isNode()) {
            return this._xobj.hasAttrs();
        }
        throw new AssertionError();
    }

    public boolean hasChildren() {
        if ($assertionsDisabled || isNode()) {
            return this._xobj.hasChildren();
        }
        throw new AssertionError();
    }

    public boolean hasParent() {
        boolean z = $assertionsDisabled;
        if (!z && !isPositioned()) {
            throw new AssertionError();
        }
        int i = this._pos;
        if (i == -1 || (i >= 1 && i < this._xobj.posAfter())) {
            return true;
        }
        if (z || this._pos == 0 || this._xobj._parent != null) {
            return this._xobj._parent != null;
        }
        throw new AssertionError();
    }

    public boolean hasText() {
        if ($assertionsDisabled || isNode()) {
            return this._xobj.hasTextEnsureOccupancy();
        }
        throw new AssertionError();
    }

    public boolean inChars(Cur cur, int i, boolean z) {
        boolean z2 = $assertionsDisabled;
        if (!z2 && (!isPositioned() || !isText() || cchRight() < i)) {
            throw new AssertionError();
        }
        if (z2 || cur.isNormal()) {
            return this._xobj.inChars(this._pos, cur._xobj, cur._pos, i, z);
        }
        throw new AssertionError();
    }

    public void insertChars(Object obj, int i, int i2) {
        boolean z = $assertionsDisabled;
        if (!z && (!isPositioned() || isRoot())) {
            throw new AssertionError();
        }
        if (!z && !CharUtil.isValid(obj, i, i2)) {
            throw new AssertionError();
        }
        if (i2 <= 0) {
            return;
        }
        this._locale.notifyChange();
        if (this._pos == -1) {
            this._xobj.ensureOccupancy();
        }
        Xobj denormal = getDenormal();
        int i4 = this._posTemp;
        if (!z && i4 <= 0) {
            throw new AssertionError();
        }
        denormal.insertCharsHelper(i4, obj, i, i2, true);
        moveTo(denormal, i4);
        this._locale._versionAll++;
    }

    public void insertString(String str) {
        if (str != null) {
            insertChars(str, 0, str.length());
        }
    }

    public boolean isAtEndOf(Cur cur) {
        if ($assertionsDisabled || (cur != null && cur.isNormal() && cur.isNode())) {
            return this._xobj == cur._xobj && this._pos == -1;
        }
        throw new AssertionError();
    }

    public boolean isAtEndOfLastPush() {
        if ($assertionsDisabled || this._stackTop != -1) {
            return this._locale._locations.isAtEndOf(this._stackTop, this);
        }
        throw new AssertionError();
    }

    public boolean isAtLastPush() {
        if ($assertionsDisabled || this._stackTop != -1) {
            return this._locale._locations.isSamePos(this._stackTop, this);
        }
        throw new AssertionError();
    }

    public boolean isAttr() {
        if ($assertionsDisabled || isPositioned()) {
            return this._pos == 0 && this._xobj.kind() == 3;
        }
        throw new AssertionError();
    }

    public boolean isComment() {
        if ($assertionsDisabled || isPositioned()) {
            return this._pos == 0 && this._xobj.kind() == 4;
        }
        throw new AssertionError();
    }

    public boolean isContainer() {
        if ($assertionsDisabled || isPositioned()) {
            return this._pos == 0 && kindIsContainer(this._xobj.kind());
        }
        throw new AssertionError();
    }

    public boolean isContainerOrFinish() {
        if (!$assertionsDisabled && !isPositioned()) {
            throw new AssertionError();
        }
        int i = this._pos;
        if (i != 0 && i != -1) {
            return false;
        }
        int iKind = this._xobj.kind();
        return iKind == 2 || iKind == -2 || iKind == 1 || iKind == -1;
    }

    public boolean isDomDocRoot() {
        return isRoot() && (this._xobj.getDom() instanceof Document);
    }

    public boolean isDomFragRoot() {
        return isRoot() && (this._xobj.getDom() instanceof DocumentFragment);
    }

    public boolean isElem() {
        if ($assertionsDisabled || isPositioned()) {
            return this._pos == 0 && this._xobj.kind() == 2;
        }
        throw new AssertionError();
    }

    public boolean isEnd() {
        if ($assertionsDisabled || isPositioned()) {
            return this._pos == -1 && this._xobj.kind() == 2;
        }
        throw new AssertionError();
    }

    public boolean isEndRoot() {
        if ($assertionsDisabled || isPositioned()) {
            return this._pos == -1 && this._xobj.kind() == 1;
        }
        throw new AssertionError();
    }

    public boolean isFinish() {
        if ($assertionsDisabled || isPositioned()) {
            return this._pos == -1 && kindIsContainer(this._xobj.kind());
        }
        throw new AssertionError();
    }

    public boolean isInSameTree(Cur cur) {
        if ($assertionsDisabled || (isPositioned() && cur.isPositioned())) {
            return this._xobj.isInSameTree(cur._xobj);
        }
        throw new AssertionError();
    }

    public boolean isJustAfterEnd(Cur cur) {
        if ($assertionsDisabled || (isNormal() && cur != null && cur.isNormal() && cur.isNode())) {
            return cur._xobj.isJustAfterEnd(this._xobj, this._pos);
        }
        throw new AssertionError();
    }

    public boolean isNode() {
        if ($assertionsDisabled || isPositioned()) {
            return this._pos == 0;
        }
        throw new AssertionError();
    }

    public boolean isNormal() {
        int i = this._state;
        if (i == 0 || i == 3) {
            return false;
        }
        Xobj xobj = this._xobj;
        if (xobj == null) {
            return this._pos == -2;
        }
        if (!xobj.isNormal(this._pos)) {
            return false;
        }
        int i2 = this._state;
        if (i2 == 2) {
            return isOnList(this._xobj._embedded);
        }
        if ($assertionsDisabled || i2 == 1) {
            return isOnList(this._locale._registered);
        }
        throw new AssertionError();
    }

    public boolean isNormalAttr() {
        return isNode() && this._xobj.isNormalAttr();
    }

    public boolean isOnList(Cur cur) {
        while (cur != null) {
            if (cur == this) {
                return true;
            }
            cur = cur._next;
        }
        return false;
    }

    public boolean isPositioned() {
        if ($assertionsDisabled || isNormal()) {
            return this._xobj != null;
        }
        throw new AssertionError();
    }

    public boolean isProcinst() {
        if ($assertionsDisabled || isPositioned()) {
            return this._pos == 0 && this._xobj.kind() == 5;
        }
        throw new AssertionError();
    }

    public boolean isRoot() {
        if ($assertionsDisabled || isPositioned()) {
            return this._pos == 0 && this._xobj.kind() == 1;
        }
        throw new AssertionError();
    }

    public boolean isSamePos(Cur cur) {
        if ($assertionsDisabled || (isNormal() && (cur == null || cur.isNormal()))) {
            return this._xobj == cur._xobj && this._pos == cur._pos;
        }
        throw new AssertionError();
    }

    public boolean isText() {
        if ($assertionsDisabled || isPositioned()) {
            return this._pos > 0;
        }
        throw new AssertionError();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public boolean isTextCData() throws Throwable {
        Xobj xobj = this._xobj;
        Class clsClass$ = class$org$apache$xmlbeans$CDataBookmark;
        if (clsClass$ == null) {
            clsClass$ = class$("org.apache.xmlbeans.CDataBookmark");
            class$org$apache$xmlbeans$CDataBookmark = clsClass$;
        }
        return xobj.hasBookmark(clsClass$, this._pos);
    }

    public boolean isUserNode() {
        if (!$assertionsDisabled && !isPositioned()) {
            throw new AssertionError();
        }
        int iKind = kind();
        return iKind == 2 || iKind == 1 || (iKind == 3 && !isXmlns());
    }

    public boolean isXmlns() {
        return isNode() && this._xobj.isXmlns();
    }

    public int kind() {
        if (!$assertionsDisabled && !isPositioned()) {
            throw new AssertionError();
        }
        int iKind = this._xobj.kind();
        int i = this._pos;
        if (i == 0) {
            return iKind;
        }
        if (i == -1) {
            return -iKind;
        }
        return 0;
    }

    public Cur listInsert(Cur cur) {
        if (!$assertionsDisabled && (this._next != null || this._prev != null)) {
            throw new AssertionError();
        }
        if (cur == null) {
            this._prev = this;
            return this;
        }
        this._prev = cur._prev;
        cur._prev._next = this;
        cur._prev = this;
        return cur;
    }

    public Cur listRemove(Cur cur) {
        boolean z = $assertionsDisabled;
        if (!z && (this._prev == null || !isOnList(cur))) {
            throw new AssertionError();
        }
        Cur cur2 = this._prev;
        if (cur2 == this) {
            cur = null;
        } else {
            if (cur == this) {
                cur = this._next;
            } else {
                cur2._next = this._next;
            }
            Cur cur3 = this._next;
            if (cur3 == null) {
                cur._prev = cur2;
            } else {
                cur3._prev = cur2;
                this._next = null;
            }
        }
        this._prev = null;
        if (z || this._next == null) {
            return cur;
        }
        throw new AssertionError();
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x006c, code lost:
    
        if ((r10._pos >= r10._xobj.posAfter() ? r10._xobj._parent : r10._xobj).isOccupied() != false) goto L44;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object moveChars(Cur cur, int i) {
        boolean z = $assertionsDisabled;
        if (!z && !isPositioned()) {
            throw new AssertionError();
        }
        if (!z && i > 0 && i > cchRight()) {
            throw new AssertionError();
        }
        if (!z && cur != null && (!cur.isPositioned() || cur.isRoot())) {
            throw new AssertionError();
        }
        if (i < 0) {
            i = cchRight();
        }
        int i2 = i;
        if (i2 == 0) {
            this._offSrc = 0;
            this._cchSrc = 0;
            return null;
        }
        Object chars = getChars(i2);
        int i4 = this._offSrc;
        if (!z) {
            if (isText()) {
            }
            throw new AssertionError();
        }
        if (cur == null) {
            for (Xobj.Bookmark bookmark = this._xobj._bookmarks; bookmark != null; bookmark = bookmark._next) {
                if (inChars(bookmark, i2, false)) {
                    Cur curTempCur = this._locale.tempCur();
                    curTempCur.createRoot();
                    curTempCur.next();
                    Object objMoveChars = moveChars(curTempCur, i2);
                    curTempCur.release();
                    return objMoveChars;
                }
            }
        } else {
            if (inChars(cur, i2, true)) {
                cur.moveToCur(this);
                nextChars(i2);
                this._offSrc = i4;
                this._cchSrc = i2;
                return chars;
            }
            cur.insertChars(chars, i4, i2);
        }
        this._locale.notifyChange();
        if (cur == null) {
            this._xobj.removeCharsHelper(this._pos, i2, null, -2, false, true);
        } else {
            this._xobj.removeCharsHelper(this._pos, i2, cur._xobj, cur._pos, false, true);
        }
        this._locale._versionAll++;
        this._offSrc = i4;
        this._cchSrc = i2;
        return chars;
    }

    public void moveNode(Cur cur) {
        boolean z = $assertionsDisabled;
        if (!z && (!isNode() || isRoot())) {
            throw new AssertionError();
        }
        if (!z && cur != null && !cur.isPositioned()) {
            throw new AssertionError();
        }
        if (!z && cur != null && contains(cur)) {
            throw new AssertionError();
        }
        if (!z && cur != null && cur.isRoot()) {
            throw new AssertionError();
        }
        Xobj xobj = this._xobj;
        skip();
        moveNode(xobj, cur);
    }

    public void moveNodeContents(Cur cur, boolean z) {
        boolean z2 = $assertionsDisabled;
        if (!z2 && this._pos != 0) {
            throw new AssertionError();
        }
        if (!z2 && cur != null && cur.isRoot()) {
            throw new AssertionError();
        }
        moveNodeContents(this._xobj, cur, z);
    }

    public void moveTo(Xobj xobj) {
        moveTo(xobj, 0);
    }

    public void moveToCharNode(DomImpl.CharNode charNode) {
        if (!$assertionsDisabled && (charNode.getDom() == null || charNode.getDom().locale() != this._locale)) {
            throw new AssertionError();
        }
        moveToDom(charNode.getDom());
        this._xobj.ensureOccupancy();
        Xobj xobj = this._xobj;
        DomImpl.CharNode charNodeUpdateCharNodes = updateCharNodes(this._locale, xobj, xobj._charNodesValue, xobj._cchValue);
        xobj._charNodesValue = charNodeUpdateCharNodes;
        while (charNodeUpdateCharNodes != null) {
            if (charNode == charNodeUpdateCharNodes) {
                moveTo(getNormal(this._xobj, charNodeUpdateCharNodes._off + 1), this._posTemp);
                return;
            }
            charNodeUpdateCharNodes = charNodeUpdateCharNodes._next;
        }
        Xobj xobj2 = this._xobj;
        DomImpl.CharNode charNodeUpdateCharNodes2 = updateCharNodes(this._locale, xobj2, xobj2._charNodesAfter, xobj2._cchAfter);
        xobj2._charNodesAfter = charNodeUpdateCharNodes2;
        while (charNodeUpdateCharNodes2 != null) {
            if (charNode == charNodeUpdateCharNodes2) {
                Xobj xobj3 = this._xobj;
                moveTo(getNormal(xobj3, charNodeUpdateCharNodes2._off + xobj3._cchValue + 2), this._posTemp);
                return;
            }
            charNodeUpdateCharNodes2 = charNodeUpdateCharNodes2._next;
        }
        if (!$assertionsDisabled) {
            throw new AssertionError();
        }
    }

    public void moveToCur(Cur cur) {
        if (!$assertionsDisabled && (!isNormal() || (cur != null && !cur.isNormal()))) {
            throw new AssertionError();
        }
        if (cur == null) {
            moveTo(null, -2);
        } else {
            moveTo(cur._xobj, cur._pos);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void moveToDom(DomImpl.Dom dom) {
        boolean z = $assertionsDisabled;
        if (!z && this._locale != dom.locale()) {
            throw new AssertionError();
        }
        if (!z && !(dom instanceof Xobj) && !(dom instanceof Xobj.SoapPartDom)) {
            throw new AssertionError();
        }
        moveTo(dom instanceof Xobj ? (Xobj) dom : ((Xobj.SoapPartDom) dom)._docXobj);
    }

    public void moveToNoCheck(Xobj xobj, int i) {
        Xobj xobj2;
        if (this._state == 2 && xobj != (xobj2 = this._xobj)) {
            xobj2._embedded = listRemove(xobj2._embedded);
            Locale locale = this._locale;
            locale._registered = listInsert(locale._registered);
            this._state = 1;
        }
        this._xobj = xobj;
        this._pos = i;
    }

    public void moveToSelection(int i) {
        if (!$assertionsDisabled && (i < 0 || i >= this._selectionCount)) {
            throw new AssertionError();
        }
        this._locale._locations.moveTo(selectionIndex(i), this);
    }

    public final String namespaceForPrefix(String str, boolean z) {
        return this._xobj.namespaceForPrefix(str, z);
    }

    public boolean next(boolean z) {
        return z ? nextWithAttrs() : next();
    }

    public int nextChars(int i) {
        if (!$assertionsDisabled && !isPositioned()) {
            throw new AssertionError();
        }
        int iCchRight = cchRight();
        if (iCchRight == 0) {
            return 0;
        }
        if (i < 0 || i >= iCchRight) {
            next();
            return iCchRight;
        }
        moveTo(getNormal(this._xobj, this._pos + i), this._posTemp);
        return i;
    }

    public boolean nextWithAttrs() {
        int iKind = kind();
        if (kindIsContainer(iKind)) {
            if (toFirstAttr()) {
                return true;
            }
        } else if (iKind == -3) {
            if (next()) {
                return true;
            }
            toParent();
            if (!toParentRaw()) {
                return false;
            }
        }
        return next();
    }

    public TypeStoreUser peekUser() {
        if ($assertionsDisabled || isUserNode()) {
            return this._xobj._user;
        }
        throw new AssertionError();
    }

    public void pop(boolean z) {
        if (z) {
            popButStay();
        } else {
            pop();
        }
    }

    public void popButStay() {
        int i = this._stackTop;
        if (i != -1) {
            this._stackTop = this._locale._locations.remove(i, i);
        }
    }

    public final String prefixForNamespace(String str, String str2, boolean z) {
        return (isContainer() ? this._xobj : getParent()).prefixForNamespace(str, str2, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean prev() {
        Xobj xobj;
        boolean z = $assertionsDisabled;
        if (!z && !isPositioned()) {
            throw new AssertionError();
        }
        int i = 0;
        if (this._xobj.isRoot() && this._pos == 0) {
            return false;
        }
        if (this._xobj.isAttr() && this._pos == 0 && this._xobj._prevSibling == null) {
            return false;
        }
        Xobj denormal = getDenormal();
        int i2 = this._posTemp;
        if (!z && (i2 <= 0 || i2 == -1)) {
            throw new AssertionError();
        }
        int iPosAfter = denormal.posAfter();
        if (i2 > iPosAfter) {
            i = iPosAfter;
        } else if (i2 == iPosAfter) {
            if (!denormal.isAttr() || (denormal._cchAfter <= 0 && (xobj = denormal._nextSibling) != null && xobj.isAttr())) {
                i = -1;
            } else {
                denormal = denormal.ensureParent();
            }
        } else if (i2 == iPosAfter - 1) {
            denormal.ensureOccupancy();
            if (denormal._cchValue > 0) {
                i = 1;
            }
        } else if (i2 <= 1) {
            if (!z && i2 != 1) {
                throw new AssertionError();
            }
        }
        moveTo(getNormal(denormal, i), this._posTemp);
        return true;
    }

    public int prevChars(int i) {
        if (!$assertionsDisabled && !isPositioned()) {
            throw new AssertionError();
        }
        int iCchLeft = cchLeft();
        if (i < 0 || i > iCchLeft) {
            i = iCchLeft;
        }
        if (i != 0) {
            moveTo(getNormal(getDenormal(), this._posTemp - i), this._posTemp);
        }
        return i;
    }

    public boolean prevWithAttrs() {
        if (prev()) {
            return true;
        }
        if (!isAttr()) {
            return false;
        }
        toParent();
        return true;
    }

    public void push() {
        if (!$assertionsDisabled && !isPositioned()) {
            throw new AssertionError();
        }
        int iAllocate = this._locale._locations.allocate(this);
        Locations locations = this._locale._locations;
        int i = this._stackTop;
        this._stackTop = locations.insert(i, i, iAllocate);
    }

    public boolean removeAttr(QName qName) {
        if ($assertionsDisabled || isContainer()) {
            return this._xobj.removeAttr(qName);
        }
        throw new AssertionError();
    }

    public void removeFollowingAttrs() {
        if (!$assertionsDisabled && !isAttr()) {
            throw new AssertionError();
        }
        QName name = getName();
        push();
        if (toNextAttr()) {
            while (isAttr()) {
                if (getName().equals(name)) {
                    moveNode(null);
                } else if (!toNextAttr()) {
                    break;
                }
            }
        }
        pop();
    }

    public void removeSelection(int i) {
        if (!$assertionsDisabled && (i < 0 || i >= this._selectionCount)) {
            throw new AssertionError();
        }
        int iSelectionIndex = selectionIndex(i);
        int i2 = this._selectionN;
        if (i < i2) {
            this._selectionN = i2 - 1;
        } else if (i == i2) {
            this._selectionN = i2 - 1;
            if (i == 0) {
                this._selectionLoc = -1;
            } else {
                this._selectionLoc = this._locale._locations.prev(this._selectionLoc);
            }
        }
        this._selectionFirst = this._locale._locations.remove(this._selectionFirst, iSelectionIndex);
        this._selectionCount--;
    }

    public int selectionCount() {
        return this._selectionCount;
    }

    public void setAttrValue(QName qName, String str) {
        if (!$assertionsDisabled && !isContainer()) {
            throw new AssertionError();
        }
        this._xobj.setAttr(qName, str);
    }

    public void setAttrValueAsQName(QName qName, QName qName2) {
        if (!$assertionsDisabled && !isContainer()) {
            throw new AssertionError();
        }
        if (qName2 == null) {
            this._xobj.removeAttr(qName);
            return;
        }
        if (toAttr(qName)) {
            removeFollowingAttrs();
        } else {
            next();
            createAttr(qName);
        }
        setValueAsQName(qName2);
        toParent();
    }

    public final Xobj.Bookmark setBookmark(Object obj, Object obj2) {
        boolean z = $assertionsDisabled;
        if (!z && !isNormal()) {
            throw new AssertionError();
        }
        if (z || obj != null) {
            return this._xobj.setBookmark(this._pos, obj, obj2);
        }
        throw new AssertionError();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setCharNodes(DomImpl.CharNode charNode) {
        boolean z = $assertionsDisabled;
        if (!z && charNode != null && this._locale != charNode.locale()) {
            throw new AssertionError();
        }
        if (!z && !isPositioned()) {
            throw new AssertionError();
        }
        Xobj denormal = getDenormal();
        int i = this._posTemp;
        if (!z && denormal.isRoot() && (i <= 0 || i >= denormal.posAfter())) {
            throw new AssertionError();
        }
        if (i >= denormal.posAfter()) {
            denormal._charNodesAfter = charNode;
        } else {
            denormal._charNodesValue = charNode;
        }
        while (charNode != null) {
            charNode.setDom((DomImpl.Dom) denormal);
            charNode = charNode._next;
        }
    }

    public void setId(String str) {
        this._id = str;
    }

    public void setName(QName qName) {
        if (!$assertionsDisabled && (!isNode() || qName == null)) {
            throw new AssertionError();
        }
        this._xobj.setName(qName);
    }

    public void setSubstitution(QName qName, SchemaType schemaType) {
        setSubstitution(qName, schemaType, true);
    }

    public void setType(SchemaType schemaType) {
        setType(schemaType, true);
    }

    public void setValue(String str) {
        if (!$assertionsDisabled && !isNode()) {
            throw new AssertionError();
        }
        moveNodeContents(null, false);
        next();
        insertString(str);
        toParent();
    }

    public void setValueAsQName(QName qName) {
        if (!$assertionsDisabled && !isNode()) {
            throw new AssertionError();
        }
        String localPart = qName.getLocalPart();
        String strPrefixForNamespace = prefixForNamespace(qName.getNamespaceURI(), qName.getPrefix().length() > 0 ? qName.getPrefix() : null, true);
        if (strPrefixForNamespace.length() > 0) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(strPrefixForNamespace);
            stringBuffer.append(":");
            stringBuffer.append(localPart);
            localPart = stringBuffer.toString();
        }
        setValue(localPart);
    }

    public final void setXsiType(QName qName) {
        if (!$assertionsDisabled && !isContainer()) {
            throw new AssertionError();
        }
        setAttrValueAsQName(Locale._xsiType, qName);
    }

    public boolean skip() {
        if (!$assertionsDisabled && !isNode()) {
            throw new AssertionError();
        }
        if (this._xobj.isRoot()) {
            return false;
        }
        if (!this._xobj.isAttr()) {
            Xobj xobj = this._xobj;
            moveTo(getNormal(xobj, xobj.posAfter()), this._posTemp);
            return true;
        }
        Xobj xobj2 = this._xobj._nextSibling;
        if (xobj2 == null || !xobj2.isAttr()) {
            return false;
        }
        moveTo(this._xobj._nextSibling, 0);
        return true;
    }

    public boolean skipWithAttrs() {
        boolean z = $assertionsDisabled;
        if (!z && !isNode()) {
            throw new AssertionError();
        }
        if (skip()) {
            return true;
        }
        if (this._xobj.isRoot()) {
            return false;
        }
        if (!z && !this._xobj.isAttr()) {
            throw new AssertionError();
        }
        toParent();
        next();
        return true;
    }

    public Cur tempCur() {
        return tempCur(null);
    }

    public boolean toAttr(QName qName) {
        if (!$assertionsDisabled && !isNode()) {
            throw new AssertionError();
        }
        Xobj attr = this._xobj.getAttr(qName);
        if (attr == null) {
            return false;
        }
        moveTo(attr);
        return true;
    }

    public void toEnd() {
        if (!$assertionsDisabled && !isNode()) {
            throw new AssertionError();
        }
        moveTo(this._xobj, -1);
    }

    public boolean toFirstAttr() {
        if (!$assertionsDisabled && !isNode()) {
            throw new AssertionError();
        }
        Xobj xobjFirstAttr = this._xobj.firstAttr();
        if (xobjFirstAttr == null) {
            return false;
        }
        moveTo(xobjFirstAttr);
        return true;
    }

    public boolean toFirstChild() {
        if (!$assertionsDisabled && !isNode()) {
            throw new AssertionError();
        }
        if (!this._xobj.hasChildren()) {
            return false;
        }
        Xobj xobj = this._xobj._firstChild;
        while (xobj.isAttr()) {
            xobj = xobj._nextSibling;
        }
        moveTo(xobj);
        return true;
    }

    public boolean toLastAttr() {
        if (!$assertionsDisabled && !isNode()) {
            throw new AssertionError();
        }
        if (!toFirstAttr()) {
            return false;
        }
        while (toNextAttr()) {
        }
        return true;
    }

    public boolean toLastChild() {
        if (!$assertionsDisabled && !isNode()) {
            throw new AssertionError();
        }
        if (!this._xobj.hasChildren()) {
            return false;
        }
        moveTo(this._xobj._lastChild);
        return true;
    }

    public boolean toNextAttr() {
        if (!$assertionsDisabled && !isAttr() && !isContainer()) {
            throw new AssertionError();
        }
        Xobj xobjNextAttr = this._xobj.nextAttr();
        if (xobjNextAttr == null) {
            return false;
        }
        moveTo(xobjNextAttr);
        return true;
    }

    public boolean toNextSibling() {
        if (!$assertionsDisabled && !isNode()) {
            throw new AssertionError();
        }
        if (!this._xobj.isAttr()) {
            Xobj xobj = this._xobj._nextSibling;
            if (xobj == null) {
                return false;
            }
            moveTo(xobj);
            return true;
        }
        Xobj xobj2 = this._xobj._nextSibling;
        if (xobj2 == null || !xobj2.isAttr()) {
            return false;
        }
        moveTo(this._xobj._nextSibling);
        return true;
    }

    public boolean toParent() {
        return toParent(false);
    }

    public boolean toParentRaw() {
        return toParent(true);
    }

    public boolean toPrevAttr() {
        if (!isAttr()) {
            prev();
            if (isContainer()) {
                return toLastAttr();
            }
            next();
            return false;
        }
        Xobj xobj = this._xobj;
        Xobj xobj2 = xobj._prevSibling;
        if (xobj2 == null) {
            moveTo(xobj.ensureParent());
            return true;
        }
        moveTo(xobj2);
        return true;
    }

    public void toRoot() {
        Xobj xobj = this._xobj;
        while (true) {
            if (xobj.isRoot()) {
                break;
            }
            xobj = xobj._parent;
            if (xobj == null) {
                Cur curTempCur = this._locale.tempCur();
                curTempCur.createRoot();
                Xobj xobj2 = curTempCur._xobj;
                curTempCur.next();
                moveNode(curTempCur);
                curTempCur.release();
                xobj = xobj2;
                break;
            }
        }
        moveTo(xobj);
    }

    public final QName valueAsQName() {
        throw new RuntimeException("Not implemented");
    }

    public Cur weakCur(Object obj) {
        Cur curWeakCur = this._locale.weakCur(obj);
        curWeakCur.moveToCur(this);
        return curWeakCur;
    }

    public static Xobj createDomDocumentRootXobj(Locale locale, boolean z) {
        Xobj documentFragXobj = locale._saaj == null ? z ? new Xobj.DocumentFragXobj(locale) : new Xobj.DocumentXobj(locale) : new Xobj.SoapPartDocXobj(locale);
        if (locale._ownerDoc == null) {
            locale._ownerDoc = documentFragXobj.getDom();
        }
        return documentFragXobj;
    }

    public static void dump(PrintStream printStream, DomImpl.Dom dom) {
        dom.dump(printStream);
    }

    public void createElement(QName qName, QName qName2) {
        createHelper(createElementXobj(this._locale, qName, qName2));
    }

    public Xobj getParent(boolean z) {
        boolean z2 = $assertionsDisabled;
        if (!z2 && !isPositioned()) {
            throw new AssertionError();
        }
        int i = this._pos;
        if (i == -1 || (i >= 1 && i < this._xobj.posAfter())) {
            return this._xobj;
        }
        if (!z2 && this._pos != 0 && this._xobj._parent == null) {
            throw new AssertionError();
        }
        Xobj xobj = this._xobj;
        Xobj xobj2 = xobj._parent;
        if (xobj2 != null) {
            return xobj2;
        }
        if (z || xobj.isRoot()) {
            return null;
        }
        Cur curTempCur = this._locale.tempCur();
        curTempCur.createRoot();
        Xobj xobj3 = curTempCur._xobj;
        curTempCur.next();
        moveNode(curTempCur);
        curTempCur.release();
        return xobj3;
    }

    public void moveTo(Xobj xobj, int i) {
        Xobj xobj2;
        Xobj xobj3;
        int i2;
        boolean z = $assertionsDisabled;
        if (!z && xobj != null && this._locale != xobj._locale) {
            throw new AssertionError();
        }
        if (!z && xobj == null && i != -2) {
            throw new AssertionError();
        }
        if (!z && xobj != null && !xobj.isNormal(i) && (!xobj.isVacant() || xobj._cchValue != 0 || xobj._user != null)) {
            throw new AssertionError();
        }
        if (!z && (i2 = this._state) != 1 && i2 != 2) {
            throw new AssertionError();
        }
        if (!z && this._state != 2 && (xobj3 = this._xobj) != null && isOnList(xobj3._embedded)) {
            throw new AssertionError();
        }
        if (!z && this._state != 1 && ((xobj2 = this._xobj) == null || !isOnList(xobj2._embedded))) {
            throw new AssertionError();
        }
        moveToNoCheck(xobj, i);
        if (z || isNormal()) {
            return;
        }
        if (this._xobj.isVacant()) {
            Xobj xobj4 = this._xobj;
            if (xobj4._cchValue == 0 && xobj4._user == null) {
                return;
            }
        }
        throw new AssertionError();
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x0095, code lost:
    
        if (r0 != null) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean next() {
        Xobj xobj;
        Xobj xobj2;
        Xobj xobj3;
        Xobj xobj4;
        boolean z = $assertionsDisabled;
        if (!z && !isNormal()) {
            throw new AssertionError();
        }
        Xobj xobj5 = this._xobj;
        int i = this._pos;
        int iPosAfter = xobj5.posAfter();
        if (i >= iPosAfter) {
            iPosAfter = this._xobj.posMax();
        } else if (i != -1) {
            if (i > 0) {
                if (!z && (xobj3 = xobj5._firstChild) != null && xobj3.isAttr()) {
                    throw new AssertionError();
                }
                xobj2 = xobj5._firstChild;
                if (xobj2 == null) {
                    iPosAfter = -1;
                }
                xobj5 = xobj2;
            } else {
                if (!z && i != 0) {
                    throw new AssertionError();
                }
                xobj5.ensureOccupancy();
                if (xobj5._cchValue != 0 || (xobj = xobj5._firstChild) == null) {
                    iPosAfter = 1;
                } else if (xobj.isAttr()) {
                    Xobj xobj6 = xobj5._firstChild;
                    while (true) {
                        Xobj xobj7 = xobj6._nextSibling;
                        if (xobj7 == null || !xobj7.isAttr()) {
                            break;
                        }
                        xobj6 = xobj6._nextSibling;
                    }
                    if (xobj6._cchAfter > 0) {
                        iPosAfter = xobj6.posAfter();
                        xobj5 = xobj6;
                    } else {
                        xobj2 = xobj6._nextSibling;
                    }
                } else {
                    xobj5 = xobj5._firstChild;
                }
            }
            iPosAfter = 0;
        } else if (xobj5.isRoot() || (xobj5.isAttr() && ((xobj4 = xobj5._nextSibling) == null || !xobj4.isAttr()))) {
            return false;
        }
        moveTo(getNormal(xobj5, iPosAfter), this._posTemp);
        return true;
    }

    public void release() {
        int i = this._tempFrame;
        if (i >= 0) {
            Cur cur = this._nextTemp;
            if (cur != null) {
                cur._prevTemp = this._prevTemp;
            }
            Cur cur2 = this._prevTemp;
            if (cur2 == null) {
                this._locale._tempFrames[i] = cur;
            } else {
                cur2._nextTemp = cur;
            }
            this._nextTemp = null;
            this._prevTemp = null;
            this._tempFrame = -1;
        }
        int i2 = this._state;
        if (i2 == 0 || i2 == 3) {
            return;
        }
        while (this._stackTop != -1) {
            popButStay();
        }
        clearSelection();
        this._id = null;
        moveToCur(null);
        boolean z = $assertionsDisabled;
        if (!z && !isNormal()) {
            throw new AssertionError();
        }
        if (!z && this._xobj != null) {
            throw new AssertionError();
        }
        if (!z && this._pos != -2) {
            throw new AssertionError();
        }
        Locale.Ref ref = this._ref;
        if (ref != null) {
            ref.clear();
            this._ref._cur = null;
        }
        this._ref = null;
        if (!z && this._state != 1) {
            throw new AssertionError();
        }
        Locale locale = this._locale;
        locale._registered = listRemove(locale._registered);
        Locale locale2 = this._locale;
        if (locale2._curPoolCount >= 16) {
            this._locale = null;
            this._state = 3;
        } else {
            locale2._curPool = listInsert(locale2._curPool);
            this._state = 0;
            this._locale._curPoolCount++;
        }
    }

    public void setSubstitution(QName qName, SchemaType schemaType, boolean z) {
        boolean z2 = $assertionsDisabled;
        if (!z2 && qName == null) {
            throw new AssertionError();
        }
        if (!z2 && schemaType == null) {
            throw new AssertionError();
        }
        if (!z2 && !isUserNode()) {
            throw new AssertionError();
        }
        TypeStoreUser typeStoreUserPeekUser = peekUser();
        if ((typeStoreUserPeekUser != null && typeStoreUserPeekUser.get_schema_type() == schemaType && qName.equals(getName())) || isRoot()) {
            return;
        }
        TypeStoreUser user = this._xobj.ensureParent().getUser();
        if (isAttr()) {
            if (z) {
                throw new IllegalArgumentException("Can't use substitution with attributes");
            }
            return;
        }
        if (!z2 && !isElem()) {
            throw new AssertionError();
        }
        if (user.get_element_type(qName, null) == schemaType) {
            setName(qName);
            removeAttr(Locale._xsiType);
            return;
        }
        QName name = schemaType.getName();
        if (name == null) {
            if (z) {
                throw new IllegalArgumentException("Can't set xsi:type on element, type is un-named");
            }
        } else if (user.get_element_type(qName, name) != schemaType) {
            if (z) {
                throw new IllegalArgumentException("Can't set xsi:type on element, invalid type");
            }
        } else {
            setName(qName);
            setAttrValueAsQName(Locale._xsiType, name);
        }
    }

    public void setType(SchemaType schemaType, boolean z) {
        boolean z2 = $assertionsDisabled;
        if (!z2 && schemaType == null) {
            throw new AssertionError();
        }
        if (!z2 && !isUserNode()) {
            throw new AssertionError();
        }
        TypeStoreUser typeStoreUserPeekUser = peekUser();
        if (typeStoreUserPeekUser == null || typeStoreUserPeekUser.get_schema_type() != schemaType) {
            if (isRoot()) {
                this._xobj.setStableType(schemaType);
                return;
            }
            TypeStoreUser user = this._xobj.ensureParent().getUser();
            if (isAttr()) {
                if (!z || user.get_attribute_type(getName()) == schemaType) {
                    return;
                }
                StringBuffer stringBuffer = new StringBuffer("Can't set type of attribute to ");
                stringBuffer.append(schemaType.toString());
                throw new IllegalArgumentException(stringBuffer.toString());
            }
            if (!z2 && !isElem()) {
                throw new AssertionError();
            }
            if (user.get_element_type(getName(), null) == schemaType) {
                removeAttr(Locale._xsiType);
                return;
            }
            QName name = schemaType.getName();
            if (name == null) {
                if (z) {
                    throw new IllegalArgumentException("Can't set type of element, type is un-named");
                }
            } else if (user.get_element_type(getName(), name) == schemaType) {
                setAttrValueAsQName(Locale._xsiType, name);
            } else if (z) {
                throw new IllegalArgumentException("Can't set type of element, invalid type");
            }
        }
    }

    public Cur tempCur(String str) {
        Cur curTempCur = this._locale.tempCur(str);
        curTempCur.moveToCur(this);
        return curTempCur;
    }

    public boolean toParent(boolean z) {
        Xobj parent = getParent(z);
        if (parent == null) {
            return false;
        }
        moveTo(parent);
        return true;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class CurLoadContext extends Locale.LoadContext {
        static final /* synthetic */ boolean $assertionsDisabled;
        private Map _additionalNamespaces;
        private boolean _after;
        private CharUtil _charUtil;
        private boolean _discardDocElem;
        private String _doctypeName;
        private String _doctypePublicId;
        private String _doctypeSystemId;
        private Xobj _frontier;
        private int _lastPos;
        private Xobj _lastXobj;
        private Locale _locale;
        private QName _replaceDocElem;
        private boolean _stripComments;
        private boolean _stripLeft = true;
        private boolean _stripProcinsts;
        private boolean _stripWhitespace;
        private Map _substituteNamespaces;

        static {
            if (Cur.class$org$apache$xmlbeans$impl$store$Cur == null) {
                Cur.class$org$apache$xmlbeans$impl$store$Cur = Cur.class$("org.apache.xmlbeans.impl.store.Cur");
            }
            $assertionsDisabled = true;
        }

        public CurLoadContext(Locale locale, XmlOptions xmlOptions) {
            XmlOptions xmlOptionsMaskNull = XmlOptions.maskNull(xmlOptions);
            this._locale = locale;
            this._charUtil = xmlOptionsMaskNull.hasOption(Cur.LOAD_USE_LOCALE_CHAR_UTIL) ? this._locale.getCharUtil() : CharUtil.getThreadLocalCharUtil();
            Xobj xobjCreateDomDocumentRootXobj = Cur.createDomDocumentRootXobj(this._locale);
            this._frontier = xobjCreateDomDocumentRootXobj;
            this._after = false;
            this._lastXobj = xobjCreateDomDocumentRootXobj;
            this._lastPos = 0;
            if (xmlOptionsMaskNull.hasOption(XmlOptions.LOAD_REPLACE_DOCUMENT_ELEMENT)) {
                this._replaceDocElem = (QName) xmlOptionsMaskNull.get(XmlOptions.LOAD_REPLACE_DOCUMENT_ELEMENT);
                this._discardDocElem = true;
            }
            this._stripWhitespace = xmlOptionsMaskNull.hasOption(XmlOptions.LOAD_STRIP_WHITESPACE);
            this._stripComments = xmlOptionsMaskNull.hasOption(XmlOptions.LOAD_STRIP_COMMENTS);
            this._stripProcinsts = xmlOptionsMaskNull.hasOption(XmlOptions.LOAD_STRIP_PROCINSTS);
            this._substituteNamespaces = (Map) xmlOptionsMaskNull.get(XmlOptions.LOAD_SUBSTITUTE_NAMESPACES);
            this._additionalNamespaces = (Map) xmlOptionsMaskNull.get(XmlOptions.LOAD_ADDITIONAL_NAMESPACES);
            Locale locale2 = this._locale;
            locale2._versionAll++;
            locale2._versionSansText++;
        }

        private QName checkName(QName qName, boolean z) {
            String str;
            return this._substituteNamespaces != null ? ((!z || qName.getNamespaceURI().length() > 0) && (str = (String) this._substituteNamespaces.get(qName.getNamespaceURI())) != null) ? this._locale.makeQName(str, qName.getLocalPart(), qName.getPrefix()) : qName : qName;
        }

        private void end() {
            boolean z = $assertionsDisabled;
            if (!z && this._frontier == null) {
                throw new AssertionError();
            }
            if (!z && this._after && this._frontier._parent == null) {
                throw new AssertionError();
            }
            flushText();
            if (this._after) {
                this._frontier = this._frontier._parent;
            } else {
                this._after = true;
            }
            this._lastXobj = this._frontier;
            this._lastPos = -1;
        }

        private void flushText() {
            if (this._stripWhitespace) {
                if (this._after) {
                    Xobj xobj = this._frontier;
                    xobj._srcAfter = this._charUtil.stripRight(xobj._srcAfter, xobj._offAfter, xobj._cchAfter);
                    Xobj xobj2 = this._frontier;
                    CharUtil charUtil = this._charUtil;
                    xobj2._offAfter = charUtil._offSrc;
                    xobj2._cchAfter = charUtil._cchSrc;
                    return;
                }
                Xobj xobj3 = this._frontier;
                xobj3._srcValue = this._charUtil.stripRight(xobj3._srcValue, xobj3._offValue, xobj3._cchValue);
                Xobj xobj4 = this._frontier;
                CharUtil charUtil2 = this._charUtil;
                xobj4._offValue = charUtil2._offSrc;
                xobj4._cchValue = charUtil2._cchSrc;
            }
        }

        private Xobj parent() {
            return this._after ? this._frontier._parent : this._frontier;
        }

        private void start(Xobj xobj) {
            boolean z = $assertionsDisabled;
            if (!z && this._frontier == null) {
                throw new AssertionError();
            }
            if (!z && this._after && this._frontier._parent == null) {
                throw new AssertionError();
            }
            flushText();
            if (this._after) {
                this._frontier = this._frontier._parent;
                this._after = false;
            }
            this._frontier.appendXobj(xobj);
            this._frontier = xobj;
            this._lastXobj = xobj;
            this._lastPos = 0;
        }

        private void stripText(Object obj, int i, int i2) {
            if (this._stripWhitespace && this._stripLeft) {
                obj = this._charUtil.stripLeft(obj, i, i2);
                this._stripLeft = false;
                CharUtil charUtil = this._charUtil;
                int i4 = charUtil._offSrc;
                i2 = charUtil._cchSrc;
                i = i4;
            }
            text(obj, i, i2);
        }

        private void text(Object obj, int i, int i2) {
            if (i2 <= 0) {
                return;
            }
            Xobj xobj = this._frontier;
            this._lastXobj = xobj;
            int i4 = xobj._cchValue;
            int i5 = i4 + 1;
            this._lastPos = i5;
            if (!this._after) {
                xobj._srcValue = this._charUtil.saveChars(obj, i, i2, xobj._srcValue, xobj._offValue, i4);
                Xobj xobj2 = this._frontier;
                CharUtil charUtil = this._charUtil;
                xobj2._offValue = charUtil._offSrc;
                xobj2._cchValue = charUtil._cchSrc;
                return;
            }
            int i6 = xobj._cchAfter;
            this._lastPos = i6 + 1 + i5;
            xobj._srcAfter = this._charUtil.saveChars(obj, i, i2, xobj._srcAfter, xobj._offAfter, i6);
            Xobj xobj3 = this._frontier;
            CharUtil charUtil2 = this._charUtil;
            xobj3._offAfter = charUtil2._offSrc;
            xobj3._cchAfter = charUtil2._cchSrc;
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        public void abort() {
            this._stripLeft = true;
            while (!parent().isRoot()) {
                end();
            }
            finish().release();
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        public void attr(QName qName, String str) {
            if (!$assertionsDisabled && !parent().isContainer()) {
                throw new AssertionError();
            }
            boolean zIsAttrOfTypeId = isAttrOfTypeId(qName, (this._after ? this._lastXobj._parent : this._lastXobj).getQName());
            Xobj attrIdXobj = zIsAttrOfTypeId ? new Xobj.AttrIdXobj(this._locale, checkName(qName, true)) : new Xobj.AttrXobj(this._locale, checkName(qName, true));
            start(attrIdXobj);
            text(str, 0, str.length());
            end();
            if (zIsAttrOfTypeId) {
                Cur curTempCur = attrIdXobj.tempCur();
                curTempCur.toRoot();
                Xobj xobj = curTempCur._xobj;
                curTempCur.release();
                if (xobj instanceof Xobj.DocumentXobj) {
                    ((Xobj.DocumentXobj) xobj).addIdElement(str, attrIdXobj._parent.getDom());
                }
            }
            this._lastXobj = attrIdXobj;
            this._lastPos = 0;
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        public void bookmark(XmlCursor.XmlBookmark xmlBookmark) {
            this._lastXobj.setBookmark(this._lastPos, xmlBookmark.getKey(), xmlBookmark);
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        public void bookmarkLastAttr(QName qName, XmlCursor.XmlBookmark xmlBookmark) {
            if (this._lastPos == 0 && this._lastXobj.isAttr()) {
                if (!$assertionsDisabled && this._lastXobj._parent == null) {
                    throw new AssertionError();
                }
                Xobj attr = this._lastXobj._parent.getAttr(qName);
                if (attr != null) {
                    attr.setBookmark(0, xmlBookmark.getKey(), xmlBookmark);
                }
            }
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        public void bookmarkLastNonAttr(XmlCursor.XmlBookmark xmlBookmark) {
            if (this._lastPos > 0 || !this._lastXobj.isAttr()) {
                this._lastXobj.setBookmark(this._lastPos, xmlBookmark.getKey(), xmlBookmark);
            } else {
                if (!$assertionsDisabled && this._lastXobj._parent == null) {
                    throw new AssertionError();
                }
                this._lastXobj._parent.setBookmark(0, xmlBookmark.getKey(), xmlBookmark);
            }
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        public void comment(String str) {
            if (!this._stripComments) {
                comment(str, 0, str.length());
            }
            this._stripLeft = true;
        }

        public void dump() {
            this._frontier.dump();
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        public void endElement() {
            if (!$assertionsDisabled && !parent().isElem()) {
                throw new AssertionError();
            }
            end();
            this._stripLeft = true;
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        public Cur finish() {
            Xobj xobj;
            flushText();
            if (this._after) {
                this._frontier = this._frontier._parent;
            }
            if (!$assertionsDisabled && ((xobj = this._frontier) == null || xobj._parent != null || !xobj.isRoot())) {
                throw new AssertionError();
            }
            Cur curTempCur = this._frontier.tempCur();
            if (!Locale.toFirstChildElement(curTempCur)) {
                return curTempCur;
            }
            boolean zIsFragmentQName = Locale.isFragmentQName(curTempCur.getName());
            if (this._discardDocElem || zIsFragmentQName) {
                QName qName = this._replaceDocElem;
                if (qName != null) {
                    curTempCur.setName(qName);
                } else {
                    while (curTempCur.toParent()) {
                    }
                    curTempCur.next();
                    while (!curTempCur.isElem()) {
                        if (curTempCur.isText()) {
                            curTempCur.moveChars(null, -1);
                        } else {
                            curTempCur.moveNode(null);
                        }
                    }
                    if (!$assertionsDisabled && !curTempCur.isElem()) {
                        throw new AssertionError();
                    }
                    curTempCur.skip();
                    while (!curTempCur.isFinish()) {
                        if (curTempCur.isText()) {
                            curTempCur.moveChars(null, -1);
                        } else {
                            curTempCur.moveNode(null);
                        }
                    }
                    curTempCur.toParent();
                    curTempCur.next();
                    if (!$assertionsDisabled && !curTempCur.isElem()) {
                        throw new AssertionError();
                    }
                    Cur curTempCur2 = curTempCur.tempCur();
                    curTempCur.moveNodeContents(curTempCur, true);
                    curTempCur.moveToCur(curTempCur2);
                    curTempCur2.release();
                    curTempCur.moveNode(null);
                }
                if (zIsFragmentQName) {
                    curTempCur.moveTo(this._frontier);
                    if (curTempCur.toFirstAttr()) {
                        while (true) {
                            if (curTempCur.isXmlns() && curTempCur.getXmlnsUri().equals("http://www.openuri.org/fragment")) {
                                curTempCur.moveNode(null);
                                if (!curTempCur.isAttr()) {
                                    break;
                                }
                            } else if (!curTempCur.toNextAttr()) {
                                break;
                            }
                        }
                    }
                    curTempCur.moveTo(this._frontier);
                    Xobj xobjCreateDomDocumentRootXobj = Cur.createDomDocumentRootXobj(this._locale, true);
                    this._frontier = xobjCreateDomDocumentRootXobj;
                    Cur curTempCur3 = xobjCreateDomDocumentRootXobj.tempCur();
                    curTempCur3.next();
                    curTempCur.moveNodeContents(curTempCur3, true);
                    curTempCur.moveTo(this._frontier);
                    curTempCur3.release();
                }
            }
            if (this._additionalNamespaces != null) {
                curTempCur.moveTo(this._frontier);
                Locale.toFirstChildElement(curTempCur);
                Locale.applyNamespaces(curTempCur, this._additionalNamespaces);
            }
            if (this._doctypeName != null && (this._doctypePublicId != null || this._doctypeSystemId != null)) {
                XmlDocumentProperties docProps = Locale.getDocProps(curTempCur, true);
                docProps.setDoctypeName(this._doctypeName);
                String str = this._doctypePublicId;
                if (str != null) {
                    docProps.setDoctypePublicId(str);
                }
                String str2 = this._doctypeSystemId;
                if (str2 != null) {
                    docProps.setDoctypeSystemId(str2);
                }
            }
            curTempCur.moveTo(this._frontier);
            if ($assertionsDisabled || curTempCur.isRoot()) {
                return curTempCur;
            }
            throw new AssertionError();
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        public void lineNumber(int i, int i2, int i4) throws Throwable {
            Xobj xobj = this._lastXobj;
            int i5 = this._lastPos;
            Class clsClass$ = Cur.class$org$apache$xmlbeans$XmlLineNumber;
            if (clsClass$ == null) {
                clsClass$ = Cur.class$("org.apache.xmlbeans.XmlLineNumber");
                Cur.class$org$apache$xmlbeans$XmlLineNumber = clsClass$;
            }
            xobj.setBookmark(i5, clsClass$, new XmlLineNumber(i, i2, i4));
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        public void procInst(String str, String str2) {
            if (!this._stripProcinsts) {
                Xobj.ProcInstXobj procInstXobj = new Xobj.ProcInstXobj(this._locale, str);
                start(procInstXobj);
                text(str2, 0, str2.length());
                end();
                this._lastXobj = procInstXobj;
                this._lastPos = 0;
            }
            this._stripLeft = true;
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        public void startDTD(String str, String str2, String str3) {
            this._doctypeName = str;
            this._doctypePublicId = str2;
            this._doctypeSystemId = str3;
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        public void startElement(QName qName) {
            start(Cur.createElementXobj(this._locale, checkName(qName, false), parent()._name));
            this._stripLeft = true;
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        public void xmlns(String str, String str2) {
            String str3;
            if (!$assertionsDisabled && !parent().isContainer()) {
                throw new AssertionError();
            }
            Map map = this._substituteNamespaces;
            if (map != null && (str3 = (String) map.get(str2)) != null) {
                str2 = str3;
            }
            Locale locale = this._locale;
            Xobj.AttrXobj attrXobj = new Xobj.AttrXobj(locale, locale.createXmlns(str));
            start(attrXobj);
            text(str2, 0, str2.length());
            end();
            this._lastXobj = attrXobj;
            this._lastPos = 0;
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        public void comment(char[] cArr, int i, int i2) {
            if (!this._stripComments) {
                Object objSaveChars = this._charUtil.saveChars(cArr, i, i2);
                CharUtil charUtil = this._charUtil;
                comment(objSaveChars, charUtil._offSrc, charUtil._cchSrc);
            }
            this._stripLeft = true;
        }

        private void comment(Object obj, int i, int i2) {
            Xobj.CommentXobj commentXobj = new Xobj.CommentXobj(this._locale);
            start(commentXobj);
            text(obj, i, i2);
            end();
            this._lastXobj = commentXobj;
            this._lastPos = 0;
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        public void text(String str) {
            if (str == null) {
                return;
            }
            stripText(str, 0, str.length());
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        public void text(char[] cArr, int i, int i2) {
            stripText(cArr, i, i2);
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        public void attr(String str, String str2, String str3, String str4) {
            attr(this._locale.makeQName(str2, str, str3), str4);
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        public void endDTD() {
        }
    }

    public static void dump(DomImpl.Dom dom) {
        dump(System.out, dom);
    }

    private Xobj getDenormal(Xobj xobj, int i) {
        Xobj denormal = xobj.getDenormal(i);
        this._posTemp = xobj._locale._posTemp;
        return denormal;
    }

    public String getCharsAsString(int i, int i2) {
        return this._xobj.getCharsAsString(this._pos, i, i2);
    }

    public String getValueAsString() {
        boolean z = $assertionsDisabled;
        if (!z && !isNode()) {
            throw new AssertionError();
        }
        if (z || !hasChildren()) {
            return this._xobj.getValueAsString();
        }
        throw new AssertionError();
    }

    public boolean isJustAfterEnd(Xobj xobj) {
        return xobj.isJustAfterEnd(this._xobj, this._pos);
    }

    public boolean pop() {
        int i = this._stackTop;
        if (i == -1) {
            return false;
        }
        this._locale._locations.moveTo(i, this);
        Locations locations = this._locale._locations;
        int i2 = this._stackTop;
        this._stackTop = locations.remove(i2, i2);
        return true;
    }

    public static void dump(Node node) {
        dump(System.out, node);
    }

    /* JADX WARN: Removed duplicated region for block: B:151:0x010b A[EDGE_INSN: B:151:0x010b->B:86:0x010b BREAK  A[LOOP:1: B:83:0x0103->B:85:0x0107], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0107 A[LOOP:1: B:83:0x0103->B:85:0x0107, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x011d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void moveNodeContents(Xobj xobj, Cur cur, boolean z) {
        int i;
        Cur cur2;
        boolean zIsAtLastPush;
        boolean z2 = $assertionsDisabled;
        if (!z2 && cur != null && cur.isRoot()) {
            throw new AssertionError();
        }
        boolean zHasAttrs = xobj.hasAttrs();
        Cur cur3 = null;
        if (!xobj.hasChildren() && (!z || !zHasAttrs)) {
            if (xobj.isVacant() && cur == null) {
                xobj.clearBit(256);
                xobj.invalidateUser();
                xobj.invalidateSpecialAttr(null);
                xobj._locale._versionAll++;
                return;
            }
            if (xobj.hasTextEnsureOccupancy()) {
                Cur curTempCur = xobj.tempCur();
                curTempCur.next();
                curTempCur.moveChars(cur, -1);
                curTempCur.release();
                return;
            }
            return;
        }
        int iPosAfter = 1;
        if (cur != null) {
            if (xobj == cur._xobj && cur._pos == -1) {
                cur.moveTo(xobj);
                if (z && zHasAttrs) {
                    z = true;
                }
                cur.next(z);
                return;
            }
            if (cur._locale == xobj._locale) {
                cur.push();
                cur.moveTo(xobj);
                cur.next(z && zHasAttrs);
                zIsAtLastPush = cur.isAtLastPush();
                cur.pop();
            } else {
                zIsAtLastPush = false;
            }
            if (zIsAtLastPush) {
                return;
            }
            if (!z2 && xobj.contains(cur)) {
                throw new AssertionError();
            }
            if (!z2 && !cur.getParent().isOccupied()) {
                throw new AssertionError();
            }
        }
        if (xobj.hasTextNoEnsureOccupancy()) {
            Cur curTempCur2 = xobj.tempCur();
            curTempCur2.next();
            curTempCur2.moveChars(cur, -1);
            curTempCur2.release();
            if (cur != null) {
                i = curTempCur2._cchSrc;
                cur.nextChars(i);
            } else {
                i = 0;
            }
        }
        xobj._locale.embedCurs();
        Xobj xobjWalk = xobj.walk(xobj, true);
        Xobj xobj2 = xobjWalk;
        boolean z3 = false;
        while (xobjWalk != null) {
            if (xobjWalk._parent == xobj && xobjWalk.isAttr()) {
                if (!$assertionsDisabled && xobjWalk._cchAfter != 0) {
                    throw new AssertionError();
                }
                if (!z) {
                    xobj2 = xobjWalk._nextSibling;
                } else {
                    xobjWalk.invalidateSpecialAttr(cur == null ? null : cur.getParent());
                    while (true) {
                        cur2 = xobjWalk._embedded;
                        if (cur2 != null) {
                        }
                        cur2.moveTo(xobj, -1);
                    }
                    xobjWalk.disconnectUser();
                    if (cur != null) {
                    }
                    if (z3) {
                    }
                }
            } else {
                while (true) {
                    cur2 = xobjWalk._embedded;
                    if (cur2 != null) {
                        break;
                    } else {
                        cur2.moveTo(xobj, -1);
                    }
                }
                xobjWalk.disconnectUser();
                if (cur != null) {
                    xobjWalk._locale = cur._locale;
                }
                z3 = (z3 && xobjWalk._bookmarks == null) ? false : true;
            }
            xobjWalk = xobjWalk.walk(xobj, true);
        }
        Xobj xobj3 = xobj._lastChild;
        if (z3 && cur == null) {
            cur = xobj._locale.tempCur();
            cur.createRoot();
            cur.next();
            cur3 = cur;
        }
        if (!xobj3.isAttr()) {
            xobj.invalidateUser();
        }
        Locale locale = xobj._locale;
        locale._versionAll++;
        locale._versionSansText++;
        if (cur != null && i == 0) {
            cur.getParent().invalidateUser();
            Locale locale2 = cur._locale;
            locale2._versionAll++;
            locale2._versionSansText++;
        }
        xobj.removeXobjs(xobj2, xobj3);
        if (cur != null) {
            Xobj xobj4 = cur._xobj;
            boolean z4 = cur._pos != 0;
            int iCchRight = cur.cchRight();
            if (iCchRight > 0) {
                cur.push();
                cur.next();
                xobj4 = cur._xobj;
                z = cur._pos != 0;
                cur.pop();
                z4 = z;
            }
            if (xobj2.isAttr()) {
                Xobj xobj5 = xobj2;
                while (true) {
                    Xobj xobj6 = xobj5._nextSibling;
                    if (xobj6 == null || !xobj6.isAttr()) {
                        break;
                    } else {
                        xobj5 = xobj5._nextSibling;
                    }
                }
                Xobj parent = cur.getParent();
                if (iCchRight > 0) {
                    transferChars(cur._xobj, cur._pos, xobj5, xobj5.posMax(), iCchRight);
                }
                if (parent.hasTextNoEnsureOccupancy()) {
                    int i2 = parent._cchValue;
                    if (i2 <= 0) {
                        parent = parent.lastAttr();
                        iPosAfter = parent.posAfter();
                        i2 = parent._cchAfter;
                    }
                    transferChars(parent, iPosAfter, xobj5, xobj5.posAfter(), i2);
                }
            } else if (iCchRight > 0) {
                transferChars(cur._xobj, cur._pos, xobj3, xobj3.posMax(), iCchRight);
            }
            if (z4) {
                xobj4.appendXobjs(xobj2, xobj3);
            } else {
                xobj4.insertXobjs(xobj2, xobj3);
            }
            cur.moveTo(xobj2);
            cur.prevChars(i);
        }
        if (cur3 != null) {
            cur3.release();
        }
    }

    private Cur tempCur(Xobj xobj, int i) {
        boolean z = $assertionsDisabled;
        if (!z && this._locale != xobj._locale) {
            throw new AssertionError();
        }
        if (!z && xobj == null && i != -2) {
            throw new AssertionError();
        }
        Cur curTempCur = this._locale.tempCur();
        if (xobj != null) {
            curTempCur.moveTo(getNormal(xobj, i), this._posTemp);
        }
        return curTempCur;
    }

    public boolean inChars(Xobj.Bookmark bookmark, int i, boolean z) {
        boolean z2 = $assertionsDisabled;
        if (!z2 && (!isPositioned() || !isText() || cchRight() < i)) {
            throw new AssertionError();
        }
        if (z2 || bookmark._xobj.isNormal(bookmark._pos)) {
            return this._xobj.inChars(this._pos, bookmark._xobj, bookmark._pos, i, z);
        }
        throw new AssertionError();
    }

    public static void dump(PrintStream printStream, Node node) {
        dump(printStream, (DomImpl.Dom) node);
    }

    public void addToSelection() {
        if (!$assertionsDisabled && !isPositioned()) {
            throw new AssertionError();
        }
        this._selectionFirst = this._locale._locations.insert(this._selectionFirst, -1, this._locale._locations.allocate(this));
        this._selectionCount++;
    }

    public void dump() {
        dump(System.out, this._xobj, this);
    }

    public void dump(PrintStream printStream) {
        Xobj xobj = this._xobj;
        if (xobj == null) {
            printStream.println("Unpositioned xptr");
        } else {
            dump(printStream, xobj, this);
        }
    }

    public static void moveNode(Xobj xobj, Cur cur) {
        Locale locale;
        boolean z = $assertionsDisabled;
        if (!z && (xobj == null || xobj.isRoot())) {
            throw new AssertionError();
        }
        if (!z && cur != null && !cur.isPositioned()) {
            throw new AssertionError();
        }
        if (!z && cur != null && xobj.contains(cur)) {
            throw new AssertionError();
        }
        if (!z && cur != null && cur.isRoot()) {
            throw new AssertionError();
        }
        if (cur != null) {
            if (cur._pos == -1) {
                cur._xobj.ensureOccupancy();
            }
            if ((cur._pos == 0 && cur._xobj == xobj) || cur.isJustAfterEnd(xobj)) {
                cur.moveTo(xobj);
                return;
            }
        }
        xobj._locale.notifyChange();
        Locale locale2 = xobj._locale;
        locale2._versionAll++;
        locale2._versionSansText++;
        if (cur != null && (locale = cur._locale) != locale2) {
            locale.notifyChange();
            Locale locale3 = cur._locale;
            locale3._versionAll++;
            locale3._versionSansText++;
        }
        if (xobj.isAttr()) {
            xobj.invalidateSpecialAttr(cur == null ? null : cur.getParentRaw());
        } else {
            Xobj xobj2 = xobj._parent;
            if (xobj2 != null) {
                xobj2.invalidateUser();
            }
            if (cur != null && cur.hasParent()) {
                cur.getParent().invalidateUser();
            }
        }
        if (xobj._cchAfter > 0) {
            transferChars(xobj, xobj.posAfter(), xobj.getDenormal(0), xobj.posTemp(), xobj._cchAfter);
        }
        if (!z && xobj._cchAfter != 0) {
            throw new AssertionError();
        }
        xobj._locale.embedCurs();
        Xobj xobjWalk = xobj;
        while (xobjWalk != null) {
            while (true) {
                Cur cur2 = xobjWalk._embedded;
                if (cur2 == null) {
                    break;
                } else {
                    cur2.moveTo(xobj.getNormal(xobj.posAfter()));
                }
            }
            xobjWalk.disconnectUser();
            if (cur != null) {
                xobjWalk._locale = cur._locale;
            }
            xobjWalk = xobjWalk.walk(xobj, true);
        }
        xobj.removeXobj();
        if (cur != null) {
            Xobj xobj3 = cur._xobj;
            boolean z2 = cur._pos != 0;
            int iCchRight = cur.cchRight();
            if (iCchRight > 0) {
                cur.push();
                cur.next();
                xobj3 = cur._xobj;
                boolean z3 = cur._pos != 0;
                cur.pop();
                z2 = z3;
            }
            if (z2) {
                xobj3.appendXobj(xobj);
            } else {
                xobj3.insertXobj(xobj);
            }
            if (iCchRight > 0) {
                transferChars(cur._xobj, cur._pos, xobj, xobj.posAfter(), iCchRight);
            }
            cur.moveTo(xobj);
        }
    }

    public static void dump(PrintStream printStream, Xobj xobj, Object obj) {
        if (obj == null) {
            obj = xobj;
        }
        while (true) {
            Xobj xobj2 = xobj._parent;
            if (xobj2 == null) {
                dumpXobj(printStream, xobj, 0, obj);
                printStream.println();
                return;
            }
            xobj = xobj2;
        }
    }
}
