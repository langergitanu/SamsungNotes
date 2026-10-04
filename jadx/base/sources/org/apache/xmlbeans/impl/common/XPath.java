package org.apache.xmlbeans.impl.common;

import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.AbstractC12991c;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.XmlError;
import org.apache.xmlbeans.XmlException;
import p258y.AbstractC14516b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class XPath {
    public static final String _DEFAULT_ELT_NS = "$xmlbeans!default_uri";
    public static final String _NS_BOUNDARY = "$xmlbeans!ns_boundary";
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$common$XPath;
    private final boolean _sawDeepDot;
    private final Selector _selector;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CompilationContext {
        static final /* synthetic */ boolean $assertionsDisabled;
        private int _column;
        private String _currentNodeVar;
        private String _expr;
        private Map _externalNamespaces;
        private boolean _lastDeepDot;
        private int _line;
        protected Map _namespaces;
        private int _offset;
        private boolean _sawDeepDot;

        static {
            if (XPath.class$org$apache$xmlbeans$impl$common$XPath == null) {
                XPath.class$org$apache$xmlbeans$impl$common$XPath = XPath.class$("org.apache.xmlbeans.impl.common.XPath");
            }
            $assertionsDisabled = true;
        }

        public CompilationContext(Map map, String str) {
            String str2;
            if (!$assertionsDisabled && (str2 = this._currentNodeVar) != null && !str2.startsWith("$")) {
                throw new AssertionError();
            }
            if (str == null) {
                this._currentNodeVar = "$this";
            } else {
                this._currentNodeVar = str;
            }
            this._namespaces = new HashMap();
            this._externalNamespaces = map == null ? new HashMap() : map;
        }

        private Step addStep(boolean z, boolean z2, QName qName, Step step) {
            Step step2 = new Step(z, z2, qName);
            if (step == null) {
                return step2;
            }
            Step step3 = step;
            while (true) {
                Step step4 = step3._next;
                if (step4 == null) {
                    step3._next = step2;
                    step2._prev = step3;
                    return step;
                }
                step3 = step4;
            }
        }

        private void computeBacktrack(Step step) {
            Step step2;
            while (step != null) {
                Step step3 = step._next;
                while (step3 != null && !step3._deep) {
                    step3 = step3._next;
                }
                if (step._deep) {
                    int i = 0;
                    Step step4 = step;
                    int i2 = 0;
                    while (step4 != step3 && step4._name != null && !step4.isWild() && !step4._attr) {
                        i2++;
                        step4 = step4._next;
                    }
                    int i4 = i2 + 1;
                    Object[] objArr = new QName[i4];
                    int[] iArr = new int[i4];
                    Step step5 = step;
                    for (int i5 = 0; i5 < i2; i5++) {
                        objArr[i5] = step5._name;
                        step5 = step5._next;
                    }
                    objArr[i2] = getAnyQName();
                    iArr[0] = -1;
                    int i6 = 0;
                    int i7 = -1;
                    while (i6 < i2) {
                        while (i7 > -1 && !objArr[i6].equals(objArr[i7])) {
                            i7 = iArr[i7];
                        }
                        i6++;
                        i7++;
                        if (objArr[i6].equals(objArr[i7])) {
                            iArr[i6] = iArr[i7];
                        } else {
                            iArr[i6] = i7;
                        }
                    }
                    for (Step step6 = step; step6 != step4; step6 = step6._next) {
                        step6._hasBacktrack = true;
                        step6._backtrack = step;
                        for (int i8 = iArr[i]; i8 > 0; i8--) {
                            step6._backtrack = step6._backtrack._next;
                        }
                        i++;
                    }
                    if (i2 > 1) {
                        step2 = step;
                        for (int i9 = iArr[i2 - 1]; i9 > 0; i9--) {
                            step2 = step2._next;
                        }
                    } else {
                        step2 = step;
                    }
                    if (step4 != step3 && step4._attr) {
                        step4._hasBacktrack = true;
                        step4._backtrack = step2;
                        step4 = step4._next;
                    }
                    if (step4 != step3 && step4._name == null) {
                        step4._hasBacktrack = true;
                        step4._backtrack = step2;
                    }
                    if (!$assertionsDisabled && !step._deep) {
                        throw new AssertionError();
                    }
                    step._hasBacktrack = true;
                    step._backtrack = step;
                } else {
                    while (step != step3) {
                        step._hasBacktrack = true;
                        step = step._next;
                    }
                }
                step = step3;
            }
        }

        private QName getAnyQName() {
            return new QName("", "");
        }

        private XPathCompileException newError(String str) {
            return new XPathCompileException(XmlError.forLocation(str, 0, null, this._line, this._column, this._offset));
        }

        private boolean parseWhitespace() {
            boolean z = false;
            while (isWhitespace()) {
                advance();
                z = true;
            }
            return z;
        }

        private boolean tokenize(String str) {
            if (!$assertionsDisabled && str.length() <= 0) {
                throw new AssertionError();
            }
            int i = 0;
            while (isWhitespace(i)) {
                i++;
            }
            if (!startsWith(str, i)) {
                return false;
            }
            advance(str.length() + i);
            return true;
        }

        private String tokenizeNCName() throws XPathCompileException {
            parseWhitespace();
            if (!isNCNameStart()) {
                throw newError("Expected non-colonized name");
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append((char) currChar());
            while (true) {
                advance();
                if (!isNCName()) {
                    return stringBuffer.toString();
                }
                stringBuffer.append((char) currChar());
            }
        }

        private void tokenizePath(ArrayList arrayList) throws XPathCompileException {
            this._lastDeepDot = false;
            Step step = tokenizeSteps();
            computeBacktrack(step);
            arrayList.add(step);
            if (this._lastDeepDot) {
                this._sawDeepDot = true;
                Step stepAddStep = null;
                while (step != null) {
                    Step step2 = step._next;
                    stepAddStep = (step2 == null || step2._next != null) ? addStep(step._deep, step._attr, step._name, stepAddStep) : addStep(step._deep, true, step._name, stepAddStep);
                    step = step._next;
                }
                computeBacktrack(stepAddStep);
                arrayList.add(stepAddStep);
            }
        }

        private QName tokenizeQName() throws XPathCompileException {
            if (tokenize("*")) {
                return getAnyQName();
            }
            String str = tokenizeNCName();
            if (tokenize(":")) {
                return new QName(lookupPrefix(str), tokenize("*") ? "" : tokenizeNCName());
            }
            return new QName(lookupPrefix(""), str);
        }

        private String tokenizeQuotedUri() throws XPathCompileException {
            int i;
            if (tokenize("\"")) {
                i = 34;
            } else {
                if (!tokenize("'")) {
                    throw newError("Expected quote (\" or ')");
                }
                i = 39;
            }
            StringBuffer stringBuffer = new StringBuffer();
            while (currChar() != -1) {
                if (currChar() == i) {
                    advance();
                    if (currChar() != i) {
                        return stringBuffer.toString();
                    }
                }
                stringBuffer.append((char) currChar());
                advance();
            }
            throw newError("Path terminated in URI literal");
        }

        private Selector tokenizeSelector() throws XPathCompileException {
            ArrayList arrayList = new ArrayList();
            tokenizePath(arrayList);
            while (tokenize("|")) {
                tokenizePath(arrayList);
            }
            return new Selector((Step[]) arrayList.toArray(new Step[0]));
        }

        /* JADX WARN: Code restructure failed: missing block: B:47:0x008c, code lost:
        
            r2 = addStep(r1, true, tokenizeQName(), r2);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private Step tokenizeSteps() throws XPathCompileException {
            boolean z;
            boolean z2;
            if (tokenize("/")) {
                throw newError("Absolute paths unsupported");
            }
            if (tokenize("$", this._currentNodeVar, "//") || tokenize(Extension.DOT, "//")) {
                z = true;
            } else {
                if (!tokenize("$", this._currentNodeVar, "/") && !tokenize(Extension.DOT, "/") && (tokenize("$", this._currentNodeVar) || tokenize(Extension.DOT))) {
                    return addStep(false, false, null, null);
                }
                z = false;
            }
            Step stepAddStep = null;
            loop0: while (true) {
                z2 = false;
                while (!tokenize("attribute", "::") && !tokenize(Log.TAG_SEPARATOR)) {
                    if (tokenize(Extension.DOT)) {
                        z2 = z2 || z;
                    } else {
                        tokenize("child", "::");
                        QName qName = tokenizeQName();
                        if (qName != null) {
                            stepAddStep = addStep(z, false, qName, stepAddStep);
                            z = false;
                        }
                    }
                    if (!tokenize("//")) {
                        if (!tokenize("/")) {
                            break loop0;
                        }
                        if (z2) {
                            z = true;
                        }
                    } else {
                        break;
                    }
                }
                z = true;
            }
            this._lastDeepDot = z2;
            if (z2) {
                this._lastDeepDot = true;
                stepAddStep = addStep(true, false, getAnyQName(), stepAddStep);
            }
            return addStep(false, false, null, stepAddStep);
        }

        private XPath tokenizeXPath() throws XPathCompileException {
            while (true) {
                if (tokenize("declare", "namespace")) {
                    if (!parseWhitespace()) {
                        throw newError("Expected prefix after 'declare namespace'");
                    }
                    String str = tokenizeNCName();
                    if (!tokenize(MarketingConstants.REFERRER_DELIMITER_U003D)) {
                        throw newError("Expected '='");
                    }
                    String str2 = tokenizeQuotedUri();
                    if (this._namespaces.containsKey(str)) {
                        throw newError(AbstractC14516b.m15113a("Redefinition of namespace prefix: ", str));
                    }
                    this._namespaces.put(str, str2);
                    if (this._externalNamespaces.containsKey(str)) {
                        throw newError(AbstractC14516b.m15113a("Redefinition of namespace prefix: ", str));
                    }
                    this._externalNamespaces.put(str, str2);
                    tokenize(";");
                    this._externalNamespaces.put(XPath._NS_BOUNDARY, new Integer(this._offset));
                } else {
                    if (!tokenize("declare", "default", "element", "namespace")) {
                        if (!this._namespaces.containsKey("")) {
                            this._namespaces.put("", "");
                        }
                        Selector selector = tokenizeSelector();
                        parseWhitespace();
                        if (currChar() == -1) {
                            return new XPath(selector, this._sawDeepDot);
                        }
                        StringBuffer stringBuffer = new StringBuffer("Unexpected char '");
                        stringBuffer.append((char) currChar());
                        stringBuffer.append("'");
                        throw newError(stringBuffer.toString());
                    }
                    String str3 = tokenizeQuotedUri();
                    if (this._namespaces.containsKey("")) {
                        throw newError("Redefinition of default element namespace");
                    }
                    this._namespaces.put("", str3);
                    if (this._externalNamespaces.containsKey(XPath._DEFAULT_ELT_NS)) {
                        throw newError("Redefinition of default element namespace : ");
                    }
                    this._externalNamespaces.put(XPath._DEFAULT_ELT_NS, str3);
                    if (!tokenize(";")) {
                        throw newError("Default Namespace declaration must end with ;");
                    }
                    this._externalNamespaces.put(XPath._NS_BOUNDARY, new Integer(this._offset));
                }
            }
        }

        public void advance() {
            if (this._offset < this._expr.length()) {
                char cCharAt = this._expr.charAt(this._offset);
                int i = this._offset;
                this._offset = i + 1;
                this._column++;
                if (cCharAt == '\r' || cCharAt == '\n') {
                    this._line++;
                    this._column = 1;
                    if (i + 2 < this._expr.length()) {
                        char cCharAt2 = this._expr.charAt(this._offset + 1);
                        if ((cCharAt2 == '\r' || cCharAt2 == '\n') && cCharAt != cCharAt2) {
                            this._offset++;
                        }
                    }
                }
            }
        }

        public XPath compile(String str) {
            this._offset = 0;
            this._line = 1;
            this._column = 1;
            this._expr = str;
            return tokenizeXPath();
        }

        public int currChar() {
            return currChar(0);
        }

        public boolean isNCName() {
            if (currChar() == -1) {
                return false;
            }
            return XMLChar.isNCName(currChar());
        }

        public boolean isNCNameStart() {
            if (currChar() == -1) {
                return false;
            }
            return XMLChar.isNCNameStart(currChar());
        }

        public boolean isWhitespace() {
            return isWhitespace(0);
        }

        public String lookupPrefix(String str) throws XPathCompileException {
            if (this._namespaces.containsKey(str)) {
                return (String) this._namespaces.get(str);
            }
            if (this._externalNamespaces.containsKey(str)) {
                return (String) this._externalNamespaces.get(str);
            }
            if (str.equals("xml")) {
                return "http://www.w3.org/XML/1998/namespace";
            }
            if (str.equals("xs")) {
                return "http://www.w3.org/2001/XMLSchema";
            }
            if (str.equals("xsi")) {
                return "http://www.w3.org/2001/XMLSchema-instance";
            }
            if (str.equals("fn")) {
                return "http://www.w3.org/2002/11/xquery-functions";
            }
            if (str.equals("xdt")) {
                return "http://www.w3.org/2003/11/xpath-datatypes";
            }
            if (str.equals("local")) {
                return "http://www.w3.org/2003/11/xquery-local-functions";
            }
            throw newError("Undefined prefix: ".concat(str));
        }

        public boolean startsWith(String str) {
            return startsWith(str, 0);
        }

        public int currChar(int i) {
            if (this._offset + i >= this._expr.length()) {
                return -1;
            }
            return this._expr.charAt(this._offset + i);
        }

        public boolean isWhitespace(int i) {
            int iCurrChar = currChar(i);
            return iCurrChar == 32 || iCurrChar == 9 || iCurrChar == 10 || iCurrChar == 13;
        }

        public boolean startsWith(String str, int i) {
            if (this._offset + i >= this._expr.length()) {
                return false;
            }
            return this._expr.startsWith(str, this._offset + i);
        }

        private boolean tokenize(String str, String str2) {
            boolean z = $assertionsDisabled;
            if (!z && str.length() <= 0) {
                throw new AssertionError();
            }
            if (!z && str2.length() <= 0) {
                throw new AssertionError();
            }
            int i = 0;
            while (isWhitespace(i)) {
                i++;
            }
            if (!startsWith(str, i)) {
                return false;
            }
            int length = str.length() + i;
            while (isWhitespace(length)) {
                length++;
            }
            if (!startsWith(str2, length)) {
                return false;
            }
            advance(str2.length() + length);
            return true;
        }

        public void advance(int i) {
            if (!$assertionsDisabled && i < 0) {
                throw new AssertionError();
            }
            while (true) {
                int i2 = i - 1;
                if (i <= 0) {
                    return;
                }
                advance();
                i = i2;
            }
        }

        private boolean tokenize(String str, String str2, String str3) {
            boolean z = $assertionsDisabled;
            if (!z && str.length() <= 0) {
                throw new AssertionError();
            }
            if (!z && str2.length() <= 0) {
                throw new AssertionError();
            }
            if (!z && str3.length() <= 0) {
                throw new AssertionError();
            }
            int i = 0;
            while (isWhitespace(i)) {
                i++;
            }
            if (!startsWith(str, i)) {
                return false;
            }
            int length = str.length() + i;
            while (isWhitespace(length)) {
                length++;
            }
            if (!startsWith(str2, length)) {
                return false;
            }
            int length2 = str2.length() + length;
            while (isWhitespace(length2)) {
                length2++;
            }
            if (!startsWith(str3, length2)) {
                return false;
            }
            int length3 = str3.length() + length2;
            while (isWhitespace(length3)) {
                length3++;
            }
            advance(length3);
            return true;
        }

        private void processNonXpathDecls() {
        }

        private boolean tokenize(String str, String str2, String str3, String str4) {
            boolean z = $assertionsDisabled;
            if (!z && str.length() <= 0) {
                throw new AssertionError();
            }
            if (!z && str2.length() <= 0) {
                throw new AssertionError();
            }
            if (!z && str3.length() <= 0) {
                throw new AssertionError();
            }
            if (!z && str4.length() <= 0) {
                throw new AssertionError();
            }
            int i = 0;
            while (isWhitespace(i)) {
                i++;
            }
            if (!startsWith(str, i)) {
                return false;
            }
            int length = str.length() + i;
            while (isWhitespace(length)) {
                length++;
            }
            if (!startsWith(str2, length)) {
                return false;
            }
            int length2 = str2.length() + length;
            while (isWhitespace(length2)) {
                length2++;
            }
            if (!startsWith(str3, length2)) {
                return false;
            }
            int length3 = str3.length() + length2;
            while (isWhitespace(length3)) {
                length3++;
            }
            if (!startsWith(str4, length3)) {
                return false;
            }
            advance(str4.length() + length3);
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ExecutionContext {
        static final /* synthetic */ boolean $assertionsDisabled;
        public static final int ATTRS = 4;
        public static final int DESCEND = 2;
        public static final int HIT = 1;
        private PathContext[] _paths;
        private ArrayList _stack = new ArrayList();
        private XPath _xpath;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public final class PathContext {
            static final /* synthetic */ boolean $assertionsDisabled;
            private Step _curr;
            private List _prev = new ArrayList();

            static {
                if (XPath.class$org$apache$xmlbeans$impl$common$XPath == null) {
                    XPath.class$org$apache$xmlbeans$impl$common$XPath = XPath.class$("org.apache.xmlbeans.impl.common.XPath");
                }
                $assertionsDisabled = true;
            }

            public PathContext() {
            }

            private void backtrack() {
                boolean z = $assertionsDisabled;
                if (!z && this._curr == null) {
                    throw new AssertionError();
                }
                Step step = this._curr;
                if (step._hasBacktrack) {
                    this._curr = step._backtrack;
                    return;
                }
                if (!z && step._deep) {
                    throw new AssertionError();
                }
                this._curr = step._prev;
                while (true) {
                    Step step2 = this._curr;
                    if (step2._deep) {
                        return;
                    }
                    int i = 0;
                    while (!step2._deep) {
                        int i2 = i + 1;
                        if (!step2.match(top(i))) {
                            break;
                        }
                        step2 = step2._prev;
                        i = i2;
                    }
                    return;
                    this._curr = this._curr._prev;
                }
            }

            private QName top(int i) {
                return (QName) ExecutionContext.this._stack.get((ExecutionContext.this._stack.size() - 1) - i);
            }

            public boolean attr(QName qName) {
                Step step = this._curr;
                return step != null && step._attr && step.match(qName);
            }

            public int element(QName qName) {
                this._prev.add(this._curr);
                Step step = this._curr;
                if (step == null) {
                    return 0;
                }
                if (!$assertionsDisabled && step._name == null) {
                    throw new AssertionError();
                }
                if (!step._attr && step.match(qName)) {
                    Step step2 = this._curr._next;
                    this._curr = step2;
                    if (step2._name != null) {
                        return step2._flags;
                    }
                    backtrack();
                    Step step3 = this._curr;
                    if (step3 == null) {
                        return 1;
                    }
                    return step3._flags | 1;
                }
                while (true) {
                    backtrack();
                    Step step4 = this._curr;
                    if (step4 == null) {
                        return 0;
                    }
                    if (step4.match(qName)) {
                        this._curr = this._curr._next;
                        break;
                    }
                    if (this._curr._deep) {
                        break;
                    }
                }
                return this._curr._flags;
            }

            public void end() {
                this._curr = (Step) this._prev.remove(r0.size() - 1);
            }

            public void init(Step step) {
                this._curr = step;
                this._prev.clear();
            }

            public int start() {
                boolean z = $assertionsDisabled;
                if (!z && this._curr == null) {
                    throw new AssertionError();
                }
                if (!z && this._curr._prev != null) {
                    throw new AssertionError();
                }
                Step step = this._curr;
                if (step._name != null) {
                    return step._flags;
                }
                this._curr = null;
                return 1;
            }
        }

        static {
            if (XPath.class$org$apache$xmlbeans$impl$common$XPath == null) {
                XPath.class$org$apache$xmlbeans$impl$common$XPath = XPath.class$("org.apache.xmlbeans.impl.common.XPath");
            }
            $assertionsDisabled = true;
        }

        public final boolean attr(QName qName) {
            int i = 0;
            boolean zAttr = false;
            while (true) {
                PathContext[] pathContextArr = this._paths;
                if (i >= pathContextArr.length) {
                    return zAttr;
                }
                zAttr |= pathContextArr[i].attr(qName);
                i++;
            }
        }

        public final int element(QName qName) {
            if (!$assertionsDisabled && qName == null) {
                throw new AssertionError();
            }
            this._stack.add(qName);
            int i = 0;
            int iElement = 0;
            while (true) {
                PathContext[] pathContextArr = this._paths;
                if (i >= pathContextArr.length) {
                    return iElement;
                }
                iElement |= pathContextArr[i].element(qName);
                i++;
            }
        }

        public final void end() {
            this._stack.remove(r0.size() - 1);
            int i = 0;
            while (true) {
                PathContext[] pathContextArr = this._paths;
                if (i >= pathContextArr.length) {
                    return;
                }
                pathContextArr[i].end();
                i++;
            }
        }

        public final void init(XPath xPath) {
            int i = 0;
            if (this._xpath != xPath) {
                this._xpath = xPath;
                this._paths = new PathContext[xPath._selector._paths.length];
                int i2 = 0;
                while (true) {
                    PathContext[] pathContextArr = this._paths;
                    if (i2 >= pathContextArr.length) {
                        break;
                    }
                    pathContextArr[i2] = new PathContext();
                    i2++;
                }
            }
            this._stack.clear();
            while (true) {
                PathContext[] pathContextArr2 = this._paths;
                if (i >= pathContextArr2.length) {
                    return;
                }
                pathContextArr2[i].init(xPath._selector._paths[i]);
                i++;
            }
        }

        public final int start() {
            int i = 0;
            int iStart = 0;
            while (true) {
                PathContext[] pathContextArr = this._paths;
                if (i >= pathContextArr.length) {
                    return iStart;
                }
                iStart |= pathContextArr[i].start();
                i++;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Selector {
        final Step[] _paths;

        public Selector(Step[] stepArr) {
            this._paths = stepArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Step {
        final boolean _attr;
        Step _backtrack;
        final boolean _deep;
        int _flags;
        boolean _hasBacktrack;
        final QName _name;
        Step _next;
        Step _prev;

        public Step(boolean z, boolean z2, QName qName) {
            this._name = qName;
            this._deep = z;
            this._attr = z2;
            int i = (z || !z2) ? 2 : 0;
            this._flags = z2 ? i | 4 : i;
        }

        public boolean isWild() {
            return this._name.getLocalPart().length() == 0;
        }

        public boolean match(QName qName) {
            String localPart = this._name.getLocalPart();
            String localPart2 = qName.getLocalPart();
            int length = localPart.length();
            if (length == 0) {
                String namespaceURI = this._name.getNamespaceURI();
                if (namespaceURI.length() == 0) {
                    return true;
                }
                return namespaceURI.equals(qName.getNamespaceURI());
            }
            if (length != localPart2.length()) {
                return false;
            }
            String namespaceURI2 = this._name.getNamespaceURI();
            String namespaceURI3 = qName.getNamespaceURI();
            return namespaceURI2.length() == namespaceURI3.length() && localPart.equals(localPart2) && namespaceURI2.equals(namespaceURI3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class XPathCompileException extends XmlException {
        public XPathCompileException(XmlError xmlError) {
            super(xmlError.toString(), (Throwable) null, xmlError);
        }
    }

    public static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw AbstractC12991c.m13994o(e);
        }
    }

    public static XPath compileXPath(String str) {
        return compileXPath(str, "$this", null);
    }

    public boolean sawDeepDot() {
        return this._sawDeepDot;
    }

    private XPath(Selector selector, boolean z) {
        this._selector = selector;
        this._sawDeepDot = z;
    }

    public static XPath compileXPath(String str, String str2) {
        return compileXPath(str, str2, null);
    }

    public static XPath compileXPath(String str, Map map) {
        return compileXPath(str, "$this", map);
    }

    public static XPath compileXPath(String str, String str2, Map map) {
        return new CompilationContext(map, str2).compile(str);
    }
}
