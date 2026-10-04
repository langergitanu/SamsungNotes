package org.apache.xmlbeans.impl.store;

import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.io.PrintStream;
import java.lang.ref.SoftReference;
import kotlin.collections.AbstractC12991c;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class CharUtil {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static int CHARUTIL_INITIAL_BUFSIZE = 0;
    private static final int MAX_COPY = 64;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$store$CharUtil;
    private static ThreadLocal tl_charUtil;
    public int _cchSrc;
    private int _charBufSize;
    private CharIterator _charIter = new CharIterator();
    private char[] _currentBuffer;
    private int _currentOffset;
    public int _offSrc;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class CharIterator {
        static final /* synthetic */ boolean $assertionsDisabled;
        private int _cchRoot;
        private int _maxPos;
        private int _minPos;
        private int _offLeaf;
        private int _offRoot;
        private int _pos;
        private char[] _srcLeafChars;
        private String _srcLeafString;
        private Object _srcRoot;

        static {
            if (CharUtil.class$org$apache$xmlbeans$impl$store$CharUtil == null) {
                CharUtil.class$org$apache$xmlbeans$impl$store$CharUtil = CharUtil.class$("org.apache.xmlbeans.impl.store.CharUtil");
            }
            $assertionsDisabled = true;
        }

        private char currentChar() {
            int i = (this._offLeaf + this._pos) - this._minPos;
            char[] cArr = this._srcLeafChars;
            return cArr == null ? this._srcLeafString.charAt(i) : cArr[i];
        }

        public boolean hasNext() {
            return this._pos < this._cchRoot;
        }

        public boolean hasPrev() {
            return this._pos > 0;
        }

        public void init(Object obj, int i, int i2) {
            init(obj, i, i2, 0);
        }

        public void movePos(int i) {
            if (!$assertionsDisabled && (i < 0 || i > this._cchRoot)) {
                throw new AssertionError();
            }
            if (i < this._minPos || i > this._maxPos) {
                Object obj = this._srcRoot;
                int i2 = this._offRoot;
                int i4 = i2 + i;
                int i5 = this._cchRoot;
                this._offLeaf = i2;
                while (obj instanceof CharJoin) {
                    CharJoin charJoin = (CharJoin) obj;
                    int i6 = charJoin._cchLeft;
                    if (i4 < i6) {
                        Object obj2 = charJoin._srcLeft;
                        int i7 = charJoin._offLeft;
                        this._offLeaf = i7;
                        i4 += i7;
                        obj = obj2;
                        i5 = i6;
                    } else {
                        Object obj3 = charJoin._srcRight;
                        int i8 = charJoin._offRight;
                        this._offLeaf = i8;
                        i4 -= i6 - i8;
                        i5 -= i6;
                        obj = obj3;
                    }
                }
                int i9 = i - (i4 - this._offLeaf);
                this._minPos = i9;
                int i10 = i5 + i9;
                this._maxPos = i10;
                if (i < this._cchRoot) {
                    this._maxPos = i10 - 1;
                }
                this._srcLeafChars = null;
                this._srcLeafString = null;
                if (obj instanceof char[]) {
                    this._srcLeafChars = (char[]) obj;
                } else {
                    this._srcLeafString = (String) obj;
                }
                if (!$assertionsDisabled && (i < i9 || i > this._maxPos)) {
                    throw new AssertionError();
                }
            }
            this._pos = i;
        }

        public char next() {
            if (!$assertionsDisabled && !hasNext()) {
                throw new AssertionError();
            }
            char cCurrentChar = currentChar();
            movePos(this._pos + 1);
            return cCurrentChar;
        }

        public char prev() {
            if (!$assertionsDisabled && !hasPrev()) {
                throw new AssertionError();
            }
            movePos(this._pos - 1);
            return currentChar();
        }

        public void release() {
            this._srcRoot = null;
            this._srcLeafString = null;
            this._srcLeafChars = null;
        }

        public void init(Object obj, int i, int i2, int i4) {
            if (!$assertionsDisabled && !CharUtil.isValid(obj, i, i2)) {
                throw new AssertionError();
            }
            release();
            this._srcRoot = obj;
            this._offRoot = i;
            this._cchRoot = i2;
            this._maxPos = -1;
            this._minPos = -1;
            movePos(i4);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class CharJoin {
        static final /* synthetic */ boolean $assertionsDisabled;
        static final int MAX_DEPTH = 64;
        public final int _cchLeft;
        public final int _depth;
        public final int _offLeft;
        public final int _offRight;
        public final Object _srcLeft;
        public final Object _srcRight;

        static {
            if (CharUtil.class$org$apache$xmlbeans$impl$store$CharUtil == null) {
                CharUtil.class$org$apache$xmlbeans$impl$store$CharUtil = CharUtil.class$("org.apache.xmlbeans.impl.store.CharUtil");
            }
            $assertionsDisabled = true;
        }

        public CharJoin(Object obj, int i, int i2, Object obj2, int i4) {
            int i5;
            this._srcLeft = obj;
            this._offLeft = i;
            this._cchLeft = i2;
            this._srcRight = obj2;
            this._offRight = i4;
            int i6 = obj instanceof CharJoin ? ((CharJoin) obj)._depth : 0;
            if ((obj2 instanceof CharJoin) && (i5 = ((CharJoin) obj2)._depth) > i6) {
                i6 = i5;
            }
            int i7 = i6 + 1;
            this._depth = i7;
            if (!$assertionsDisabled && i7 > 66) {
                throw new AssertionError();
            }
        }

        private int cchRight(int i, int i2) {
            return Math.max(0, (i2 - this._cchLeft) - i);
        }

        private void dumpChars(int i, int i2) {
            dumpChars(System.out, i, i2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void getChars(char[] cArr, int i, int i2, int i4) {
            if (!$assertionsDisabled && i4 <= 0) {
                throw new AssertionError();
            }
            int i5 = this._cchLeft;
            if (i2 >= i5) {
                CharUtil.getChars(cArr, i, this._srcRight, (this._offRight + i2) - i5, i4);
                return;
            }
            int iMin = Math.min(i5 - i2, i4);
            CharUtil.getChars(cArr, i, this._srcLeft, this._offLeft + i2, iMin);
            if (i4 > iMin) {
                CharUtil.getChars(cArr, i + iMin, this._srcRight, this._offRight, i4 - iMin);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void getString(StringBuffer stringBuffer, int i, int i2) {
            if (!$assertionsDisabled && i2 <= 0) {
                throw new AssertionError();
            }
            int i4 = this._cchLeft;
            if (i >= i4) {
                CharUtil.getString(stringBuffer, this._srcRight, (this._offRight + i) - i4, i2);
                return;
            }
            int iMin = Math.min(i4 - i, i2);
            CharUtil.getString(stringBuffer, this._srcLeft, this._offLeft + i, iMin);
            if (i2 > iMin) {
                CharUtil.getString(stringBuffer, this._srcRight, this._offRight, i2 - iMin);
            }
        }

        public int depth() {
            Object obj = this._srcLeft;
            int iDepth = obj instanceof CharJoin ? ((CharJoin) obj).depth() : 0;
            Object obj2 = this._srcRight;
            if (obj2 instanceof CharJoin) {
                iDepth = Math.max(((CharJoin) obj2).depth(), iDepth);
            }
            return iDepth + 1;
        }

        public boolean isValid(int i, int i2) {
            int i4 = this._depth;
            if (i4 > 2) {
                return true;
            }
            if ($assertionsDisabled || i4 == depth()) {
                return i >= 0 && i2 >= 0 && CharUtil.isValid(this._srcLeft, this._offLeft, this._cchLeft) && CharUtil.isValid(this._srcRight, this._offRight, cchRight(i, i2));
            }
            throw new AssertionError();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dumpChars(PrintStream printStream, int i, int i2) {
            printStream.print("( ");
            CharUtil.dumpChars(printStream, this._srcLeft, this._offLeft, this._cchLeft);
            printStream.print(SQLKeyword.COMMA);
            CharUtil.dumpChars(printStream, this._srcRight, this._offRight, cchRight(i, i2));
            printStream.print(" )");
        }
    }

    static {
        if (class$org$apache$xmlbeans$impl$store$CharUtil == null) {
            class$org$apache$xmlbeans$impl$store$CharUtil = class$("org.apache.xmlbeans.impl.store.CharUtil");
        }
        $assertionsDisabled = true;
        CHARUTIL_INITIAL_BUFSIZE = 32768;
        tl_charUtil = new ThreadLocal() { // from class: org.apache.xmlbeans.impl.store.CharUtil.1
            @Override // java.lang.ThreadLocal
            public Object initialValue() {
                return new SoftReference(new CharUtil(CharUtil.CHARUTIL_INITIAL_BUFSIZE));
            }
        };
    }

    public CharUtil(int i) {
        this._charBufSize = i;
    }

    private char[] allocate(int i) {
        char[] cArr;
        boolean z = $assertionsDisabled;
        if (!z && (cArr = this._currentBuffer) != null && cArr.length - this._currentOffset <= 0) {
            throw new AssertionError();
        }
        if (this._currentBuffer == null) {
            this._currentBuffer = new char[Math.max(i, this._charBufSize)];
            this._currentOffset = 0;
        }
        int i2 = this._currentOffset;
        this._offSrc = i2;
        int iMin = Math.min(this._currentBuffer.length - i2, i);
        this._cchSrc = iMin;
        char[] cArr2 = this._currentBuffer;
        if (!z && this._currentOffset + iMin > cArr2.length) {
            throw new AssertionError();
        }
        int i4 = this._currentOffset + iMin;
        this._currentOffset = i4;
        if (i4 == cArr2.length) {
            this._currentBuffer = null;
            this._currentOffset = 0;
        }
        return cArr2;
    }

    private boolean canAllocate(int i) {
        char[] cArr = this._currentBuffer;
        return cArr == null || cArr.length - this._currentOffset >= i;
    }

    public static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw AbstractC12991c.m13994o(e);
        }
    }

    public static void dump(Object obj, int i, int i2) {
        dumpChars(System.out, obj, i, i2);
        System.out.println();
    }

    public static void dumpChars(PrintStream printStream, Object obj, int i, int i2) {
        int i4;
        int i5;
        StringBuffer stringBuffer = new StringBuffer("off=");
        stringBuffer.append(i);
        stringBuffer.append(", cch=");
        stringBuffer.append(i2);
        stringBuffer.append(SQLKeyword.COMMA);
        printStream.print(stringBuffer.toString());
        if (obj == null) {
            printStream.print("<null-src>");
            return;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            printStream.print("String");
            if (!(i == 0 && i2 == str.length()) && (i < 0 || i > str.length() || (i5 = i + i2) < 0 || i5 > str.length())) {
                printStream.print(" (Error)");
                return;
            } else {
                dumpText(printStream, str.substring(i, i2 + i));
                return;
            }
        }
        if (!(obj instanceof char[])) {
            if (!(obj instanceof CharJoin)) {
                printStream.print("Unknown text source");
                return;
            } else {
                printStream.print("CharJoin");
                ((CharJoin) obj).dumpChars(printStream, i, i2);
                return;
            }
        }
        char[] cArr = (char[]) obj;
        printStream.print("char[]");
        if (!(i == 0 && i2 == cArr.length) && (i < 0 || i > cArr.length || (i4 = i + i2) < 0 || i4 > cArr.length)) {
            printStream.print(" (Error)");
        } else {
            dumpText(printStream, new String(cArr, i, i2));
        }
    }

    private static void dumpText(PrintStream printStream, String str) {
        printStream.print("\"");
        int i = 0;
        while (true) {
            if (i >= str.length()) {
                break;
            }
            char cCharAt = str.charAt(i);
            if (i == 36) {
                printStream.print("...");
                break;
            }
            if (cCharAt == '\n') {
                printStream.print("\\n");
            } else if (cCharAt == '\r') {
                printStream.print("\\r");
            } else if (cCharAt == '\t') {
                printStream.print("\\t");
            } else if (cCharAt == '\f') {
                printStream.print("\\f");
            } else if (cCharAt == '\f') {
                printStream.print("\\f");
            } else if (cCharAt == '\"') {
                printStream.print("\\\"");
            } else {
                printStream.print(cCharAt);
            }
            i++;
        }
        printStream.print("\"");
    }

    public static void getChars(char[] cArr, int i, Object obj, int i2, int i4) {
        boolean z = $assertionsDisabled;
        if (!z && !isValid(obj, i2, i4)) {
            throw new AssertionError();
        }
        if (!z && (cArr == null || i < 0 || i > cArr.length)) {
            throw new AssertionError();
        }
        if (i4 == 0) {
            return;
        }
        if (obj instanceof char[]) {
            System.arraycopy((char[]) obj, i2, cArr, i, i4);
        } else if (obj instanceof String) {
            ((String) obj).getChars(i2, i4 + i2, cArr, i);
        } else {
            ((CharJoin) obj).getChars(cArr, i, i2, i4);
        }
    }

    public static void getString(StringBuffer stringBuffer, Object obj, int i, int i2) {
        if (!$assertionsDisabled && !isValid(obj, i, i2)) {
            throw new AssertionError();
        }
        if (i2 == 0) {
            return;
        }
        if (obj instanceof char[]) {
            stringBuffer.append((char[]) obj, i, i2);
            return;
        }
        if (!(obj instanceof String)) {
            ((CharJoin) obj).getString(stringBuffer, i, i2);
            return;
        }
        String str = (String) obj;
        if (i == 0 && i2 == str.length()) {
            stringBuffer.append(str);
        } else {
            stringBuffer.append(str.substring(i, i2 + i));
        }
    }

    public static CharUtil getThreadLocalCharUtil() {
        CharUtil charUtil = (CharUtil) ((SoftReference) tl_charUtil.get()).get();
        if (charUtil != null) {
            return charUtil;
        }
        CharUtil charUtil2 = new CharUtil(CHARUTIL_INITIAL_BUFSIZE);
        tl_charUtil.set(new SoftReference(charUtil2));
        return charUtil2;
    }

    public static boolean isValid(Object obj, int i, int i2) {
        if (i2 >= 0 && i >= 0) {
            if (obj == null) {
                return i == 0 && i2 == 0;
            }
            if (obj instanceof char[]) {
                char[] cArr = (char[]) obj;
                return i <= cArr.length && i + i2 <= cArr.length;
            }
            if (obj instanceof String) {
                String str = (String) obj;
                return i <= str.length() && i + i2 <= str.length();
            }
            if (obj instanceof CharJoin) {
                return ((CharJoin) obj).isValid(i, i2);
            }
        }
        return false;
    }

    public static final boolean isWhiteSpace(char c) {
        return c == '\t' || c == '\n' || c == '\r' || c == ' ';
    }

    private static int sizeof(Object obj) {
        if (!$assertionsDisabled && obj != null && !(obj instanceof String) && !(obj instanceof char[])) {
            throw new AssertionError();
        }
        if (obj instanceof char[]) {
            return ((char[]) obj).length;
        }
        if (obj == null) {
            return 0;
        }
        return ((String) obj).length();
    }

    public CharIterator getCharIterator(Object obj, int i, int i2) {
        this._charIter.init(obj, i, i2);
        return this._charIter;
    }

    public Object insertChars(int i, Object obj, int i2, int i4, Object obj2, int i5, int i6) {
        CharJoin charJoin;
        Object objSaveChars;
        boolean z = $assertionsDisabled;
        if (!z && !isValid(obj, i2, i4)) {
            throw new AssertionError();
        }
        if (!z && !isValid(obj2, i5, i6)) {
            throw new AssertionError();
        }
        if (!z && (i < 0 || i > i4)) {
            throw new AssertionError();
        }
        if (i6 == 0) {
            this._cchSrc = i4;
            this._offSrc = i2;
            return obj;
        }
        if (i4 == 0) {
            this._cchSrc = i6;
            this._offSrc = i5;
            return obj2;
        }
        int i7 = i4 + i6;
        this._cchSrc = i7;
        if (i7 > 64 || !canAllocate(i7)) {
            this._offSrc = 0;
            if (i == 0) {
                charJoin = new CharJoin(obj2, i5, i6, obj, i2);
            } else {
                charJoin = i == i4 ? new CharJoin(obj, i2, i4, obj2, i5) : new CharJoin(new CharJoin(obj, i2, i, obj2, i5), 0, i + i6, obj, i2 + i);
            }
            int i8 = charJoin._depth;
            objSaveChars = charJoin;
            if (i8 > 64) {
                objSaveChars = saveChars(charJoin, this._offSrc, this._cchSrc);
            }
        } else {
            char[] cArrAllocate = allocate(this._cchSrc);
            getChars(cArrAllocate, this._offSrc, obj, i2, i);
            getChars(cArrAllocate, this._offSrc + i, obj2, i5, i6);
            getChars(cArrAllocate, this._offSrc + i + i6, obj, i2 + i, i4 - i);
            objSaveChars = cArrAllocate;
        }
        if (z || isValid(objSaveChars, this._offSrc, this._cchSrc)) {
            return objSaveChars;
        }
        throw new AssertionError();
    }

    public Object removeChars(int i, int i2, Object obj, int i4, int i5) {
        boolean z = $assertionsDisabled;
        if (!z && !isValid(obj, i4, i5)) {
            throw new AssertionError();
        }
        if (!z && (i < 0 || i > i5)) {
            throw new AssertionError();
        }
        if (!z && (i2 < 0 || i + i2 > i5)) {
            throw new AssertionError();
        }
        int i6 = i5 - i2;
        this._cchSrc = i6;
        if (i6 == 0) {
            this._offSrc = 0;
            obj = null;
        } else if (i == 0) {
            this._offSrc = i4 + i2;
        } else if (i + i2 == i5) {
            this._offSrc = i4;
        } else if (i6 > 64 || !canAllocate(i6)) {
            CharJoin charJoin = new CharJoin(obj, i4, i, obj, i4 + i + i2);
            if (charJoin._depth > 64) {
                obj = saveChars(charJoin, 0, this._cchSrc);
            } else {
                this._offSrc = 0;
                obj = charJoin;
            }
        } else {
            char[] cArrAllocate = allocate(i6);
            getChars(cArrAllocate, this._offSrc, obj, i4, i);
            getChars(cArrAllocate, this._offSrc + i, obj, i4 + i + i2, (i5 - i) - i2);
            this._offSrc = this._offSrc;
            obj = cArrAllocate;
        }
        if (z || isValid(obj, this._offSrc, this._cchSrc)) {
            return obj;
        }
        throw new AssertionError();
    }

    public Object saveChars(Object obj, int i, int i2) {
        return saveChars(obj, i, i2, null, 0, 0);
    }

    public Object stripLeft(Object obj, int i, int i2) {
        if (!$assertionsDisabled && !isValid(obj, i, i2)) {
            throw new AssertionError();
        }
        if (i2 > 0) {
            if (obj instanceof char[]) {
                char[] cArr = (char[]) obj;
                while (i2 > 0 && isWhiteSpace(cArr[i])) {
                    i2--;
                    i++;
                }
            } else if (obj instanceof String) {
                String str = (String) obj;
                while (i2 > 0 && isWhiteSpace(str.charAt(i))) {
                    i2--;
                    i++;
                }
            } else {
                this._charIter.init(obj, i, i2);
                int i4 = 0;
                while (this._charIter.hasNext() && isWhiteSpace(this._charIter.next())) {
                    i4++;
                }
                this._charIter.release();
                i += i4;
            }
        }
        if (i2 == 0) {
            this._offSrc = 0;
            this._cchSrc = 0;
            return null;
        }
        this._offSrc = i;
        this._cchSrc = i2;
        return obj;
    }

    public Object stripRight(Object obj, int i, int i2) {
        if (!$assertionsDisabled && !isValid(obj, i, i2)) {
            throw new AssertionError();
        }
        if (i2 > 0) {
            this._charIter.init(obj, i, i2, i2);
            while (this._charIter.hasPrev() && isWhiteSpace(this._charIter.prev())) {
                i2--;
            }
            this._charIter.release();
        }
        if (i2 == 0) {
            this._offSrc = 0;
            this._cchSrc = 0;
            return null;
        }
        this._offSrc = i;
        this._cchSrc = i2;
        return obj;
    }

    public final boolean isWhiteSpace(Object obj, int i, int i2) {
        if (!$assertionsDisabled && !isValid(obj, i, i2)) {
            throw new AssertionError();
        }
        boolean z = true;
        if (i2 <= 0) {
            return true;
        }
        if (obj instanceof char[]) {
            char[] cArr = (char[]) obj;
            while (i2 > 0) {
                int i4 = i + 1;
                if (!isWhiteSpace(cArr[i])) {
                    return false;
                }
                i2--;
                i = i4;
            }
            return true;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            while (i2 > 0) {
                int i5 = i + 1;
                if (!isWhiteSpace(str.charAt(i))) {
                    return false;
                }
                i2--;
                i = i5;
            }
            return true;
        }
        this._charIter.init(obj, i, i2);
        while (true) {
            if (!this._charIter.hasNext()) {
                break;
            }
            if (!isWhiteSpace(this._charIter.next())) {
                z = false;
                break;
            }
        }
        this._charIter.release();
        return z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Object saveChars(Object obj, int i, int i2, Object obj2, int i4, int i5) {
        CharJoin charJoin;
        Object obj3;
        Object obj4;
        Object obj5;
        boolean z = $assertionsDisabled;
        if (!z && !isValid(obj, i, i2)) {
            throw new AssertionError();
        }
        if (!z && !isValid(obj2, i4, i5)) {
            throw new AssertionError();
        }
        char[] cArrAllocate = allocate(i2);
        int i6 = this._offSrc;
        int i7 = this._cchSrc;
        if (!z && i7 > i2) {
            throw new AssertionError();
        }
        getChars(cArrAllocate, i6, obj, i, i7);
        int i8 = i7 + i5;
        int i9 = 0;
        if (i5 == 0) {
            obj4 = cArrAllocate;
        } else {
            if (obj2 == cArrAllocate && i4 + i5 == i6) {
                if (!z && !(obj2 instanceof char[])) {
                    throw new AssertionError();
                }
            } else if (!(obj2 instanceof CharJoin) || (obj3 = (charJoin = (CharJoin) obj2)._srcRight) != cArrAllocate || ((i4 + i5) - charJoin._cchLeft) + charJoin._offRight != i6) {
                CharJoin charJoin2 = new CharJoin(obj2, i4, i5, cArrAllocate, i6);
                int i10 = charJoin2._depth;
                Object objSaveChars = charJoin2;
                if (i10 > 64) {
                    objSaveChars = saveChars(charJoin2, 0, i8);
                }
                i6 = 0;
                obj4 = objSaveChars;
            } else if (!z && !(obj3 instanceof char[])) {
                throw new AssertionError();
            }
            i6 = i4;
            obj4 = obj2;
        }
        int i11 = i2 - i7;
        if (i11 > 0) {
            char[] cArrAllocate2 = allocate(i11);
            int i12 = this._offSrc;
            int i13 = this._cchSrc;
            if (!z && i13 != i11) {
                throw new AssertionError();
            }
            if (!z && i12 != 0) {
                throw new AssertionError();
            }
            getChars(cArrAllocate2, i12, obj, (i2 - i11) + i, i11);
            CharJoin charJoin3 = new CharJoin(obj4, i6, i8, cArrAllocate2, i12);
            i8 += i11;
            int i14 = charJoin3._depth;
            Object objSaveChars2 = charJoin3;
            if (i14 > 64) {
                objSaveChars2 = saveChars(charJoin3, 0, i8);
            }
            obj5 = objSaveChars2;
        } else {
            i9 = i6;
            obj5 = obj4;
        }
        this._offSrc = i9;
        this._cchSrc = i8;
        if (z || isValid(obj5, i9, i8)) {
            return obj5;
        }
        throw new AssertionError();
    }

    public CharIterator getCharIterator(Object obj, int i, int i2, int i4) {
        this._charIter.init(obj, i, i2, i4);
        return this._charIter;
    }

    public static String getString(Object obj, int i, int i2) {
        if (!$assertionsDisabled && !isValid(obj, i, i2)) {
            throw new AssertionError();
        }
        if (i2 == 0) {
            return "";
        }
        if (obj instanceof char[]) {
            return new String((char[]) obj, i, i2);
        }
        if (obj instanceof String) {
            String str = (String) obj;
            return (i == 0 && i2 == str.length()) ? str : str.substring(i, i2 + i);
        }
        StringBuffer stringBuffer = new StringBuffer();
        ((CharJoin) obj).getString(stringBuffer, i, i2);
        return stringBuffer.toString();
    }
}
