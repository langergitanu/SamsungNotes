package opennlp.tools.parser;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.glance.AbstractC2821a;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import opennlp.tools.util.Span;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class Parse implements Cloneable, Comparable<Parse> {
    public static final String BRACKET_LCB = "{";
    public static final String BRACKET_LRB = "(";
    public static final String BRACKET_LSB = "[";
    public static final String BRACKET_RCB = "}";
    public static final String BRACKET_RRB = ")";
    public static final String BRACKET_RSB = "]";
    private static boolean useFunctionTags;
    private StringBuffer derivation;
    private Parse head;
    private int headIndex;
    private boolean isChunk;
    private String label;
    private Collection<Parse> nextPunctSet;
    private Parse parent;
    private List<Parse> parts;
    private Collection<Parse> prevPunctSet;
    private double prob;
    private Span span;
    private final String text;
    private String type;
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) Parse.class);
    private static final Pattern typePattern = Pattern.compile("^([^ =-]+)");
    private static final Pattern funTypePattern = Pattern.compile("^[^ =-]+-([^ =-]+)");
    private static final Pattern tokenPattern = Pattern.compile("^[^ ()]+ ([^ ()]+)\\s*\\)");

    public Parse(String str, Span span, String str2, double d, int i) {
        this.text = str;
        this.span = span;
        this.type = str2;
        this.prob = d;
        this.head = this;
        this.headIndex = i;
        this.parts = new LinkedList();
        this.label = null;
        this.parent = null;
    }

    public static void addNames(String str, Span[] spanArr, Parse[] parseArr) {
        for (Span span : spanArr) {
            Parse parse = parseArr[span.getStart()];
            Parse parse2 = parseArr[span.getEnd() - 1];
            Parse commonParent = parse.getCommonParent(parse2);
            Logger logger2 = logger;
            if (logger2.isTraceEnabled()) {
                logger2.trace("addNames: {} .. {} commonParent = {}", parse, parse2, commonParent);
            }
            if (commonParent != null) {
                Span span2 = new Span(parse.getSpan().getStart(), parse2.getSpan().getEnd());
                if (span2.equals(commonParent.getSpan())) {
                    commonParent.insert(new Parse(commonParent.getText(), span2, str, 1.0d, parse2.getHeadIndex()));
                } else {
                    Parse[] children = commonParent.getChildren();
                    boolean z = false;
                    for (Parse parse3 : children) {
                        if (span2.crosses(parse3.getSpan())) {
                            z = true;
                        }
                    }
                    if (!z) {
                        commonParent.insert(new Parse(commonParent.getText(), span2, str, 1.0d, parse2.getHeadIndex()));
                    } else if (commonParent.getType().equals("NP")) {
                        Parse[] children2 = children[0].getChildren();
                        if (children2.length > 1 && span2.contains(children2[children2.length - 1].getSpan())) {
                            commonParent.insert(new Parse(commonParent.getText(), commonParent.getSpan(), str, 1.0d, commonParent.getHeadIndex()));
                        }
                    }
                }
            }
        }
    }

    private void codeTree(Parse parse, int[] iArr) {
        Parse[] children = parse.getChildren();
        StringBuilder sb = new StringBuilder("[");
        int[] iArr2 = new int[iArr.length + 1];
        for (int i = 0; i < iArr.length; i++) {
            iArr2[i] = iArr[i];
            sb.append(iArr[i]);
            sb.append(Extension.DOT);
        }
        for (int i2 = 0; i2 < children.length; i2++) {
            iArr2[iArr.length] = i2;
            Logger logger2 = logger;
            String string = sb.toString();
            String type = children[i2].getType();
            int iHashCode = children[i2].hashCode();
            int iHashCode2 = children[i2].getParent().hashCode();
            String type2 = children[i2].getParent().getType();
            String coveredText = children[i2].getCoveredText();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(string);
            sb2.append(i2);
            sb2.append("] ");
            sb2.append(type);
            sb2.append(" ");
            AbstractC2821a.m2235z(sb2, iHashCode, iHashCode2, " -> ", " ");
            sb2.append(type2);
            sb2.append(" ");
            sb2.append(coveredText);
            logger2.info(sb2.toString());
            codeTree(children[i2], iArr2);
        }
    }

    private static String decodeToken(String str) {
        return "-LRB-".equals(str) ? "(" : "-RRB-".equals(str) ? ")" : "-LCB-".equals(str) ? BRACKET_LCB : "-RCB-".equals(str) ? "}" : "-LSB-".equals(str) ? "[" : "-RSB-".equals(str) ? "]" : str;
    }

    private static String encodeToken(String str) {
        return "(".equals(str) ? "-LRB-" : ")".equals(str) ? "-RRB-" : BRACKET_LCB.equals(str) ? "-LCB-" : "}".equals(str) ? "-RCB-" : "[".equals(str) ? "-LSB-" : "]".equals(str) ? "-RSB-" : str;
    }

    public static void fixPossesives(Parse parse) {
        int i;
        Parse[] tagNodes = parse.getTagNodes();
        for (int i2 = 0; i2 < tagNodes.length; i2++) {
            if (tagNodes[i2].getType().equals("POS") && (i = i2 + 1) < tagNodes.length && tagNodes[i].getParent() == tagNodes[i2].getParent().getParent()) {
                int start = tagNodes[i].getSpan().getStart();
                int end = tagNodes[i].getSpan().getEnd();
                for (int i4 = i2 + 2; i4 < tagNodes.length && tagNodes[i4].getParent() == tagNodes[i4 - 1].getParent(); i4++) {
                    end = tagNodes[i4].getSpan().getEnd();
                }
                parse.insert(new Parse(parse.getText(), new Span(start, end), "NP", 1.0d, tagNodes[i]));
            }
        }
    }

    private static String getToken(String str) {
        Matcher matcher = tokenPattern.matcher(str);
        if (matcher.find()) {
            return decodeToken(matcher.group(1));
        }
        return null;
    }

    public static Parse parseParse(String str) {
        return parseParse(str, null);
    }

    public static void pruneParse(Parse parse) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(parse);
        while (linkedList.size() != 0) {
            Parse parse2 = (Parse) linkedList.remove(0);
            Parse[] children = parse2.getChildren();
            if (children.length == 1 && parse2.getType().equals(children[0].getType())) {
                int iIndexOf = parse2.getParent().parts.indexOf(parse2);
                children[0].setParent(parse2.getParent());
                parse2.getParent().parts.set(iIndexOf, children[0]);
                parse2.parent = null;
                parse2.parts = null;
            }
            linkedList.addAll(Arrays.asList(children));
        }
    }

    public static void useFunctionTags(boolean z) {
        useFunctionTags = z;
    }

    public void add(Parse parse, HeadRules headRules) {
        Collection<Parse> collection = parse.prevPunctSet;
        if (collection != null) {
            this.parts.addAll(collection);
        }
        this.parts.add(parse);
        this.span = new Span(this.span.getStart(), parse.getSpan().getEnd());
        Parse head = headRules.getHead(getChildren(), this.type);
        this.head = head;
        this.headIndex = head.headIndex;
    }

    public void addNextPunctuation(Parse parse) {
        if (this.nextPunctSet == null) {
            this.nextPunctSet = new TreeSet();
        }
        this.nextPunctSet.add(parse);
    }

    public void addPreviousPunctuation(Parse parse) {
        if (this.prevPunctSet == null) {
            this.prevPunctSet = new TreeSet();
        }
        this.prevPunctSet.add(parse);
    }

    public void addProb(double d) {
        this.prob += d;
    }

    public Parse adjoin(Parse parse, HeadRules headRules) {
        Parse parse2 = (Parse) AbstractC0000a.m10g(this.parts, 1);
        Parse parse3 = new Parse(this.text, new Span(parse2.getSpan().getStart(), parse.getSpan().getEnd()), parse2.getType(), 1.0d, headRules.getHead(new Parse[]{parse2, parse}, parse2.getType()));
        parse3.parts.add(parse2);
        Collection<Parse> collection = parse.prevPunctSet;
        if (collection != null) {
            parse3.parts.addAll(collection);
        }
        parse3.parts.add(parse);
        List<Parse> list = this.parts;
        list.set(list.size() - 1, parse3);
        this.span = new Span(this.span.getStart(), parse.getSpan().getEnd());
        Parse head = headRules.getHead(getChildren(), this.type);
        this.head = head;
        this.headIndex = head.headIndex;
        return parse3;
    }

    public Parse adjoinRoot(Parse parse, HeadRules headRules, int i) {
        Parse parse2 = this.parts.get(i);
        Parse parse3 = new Parse(this.text, new Span(parse2.getSpan().getStart(), parse.getSpan().getEnd()), parse2.getType(), 1.0d, headRules.getHead(new Parse[]{parse2, parse}, parse2.getType()));
        parse3.parts.add(parse2);
        Collection<Parse> collection = parse.prevPunctSet;
        if (collection != null) {
            parse3.parts.addAll(collection);
        }
        parse3.parts.add(parse);
        this.parts.set(i, parse3);
        return parse3;
    }

    public Object clone() {
        Parse parse = new Parse(this.text, this.span, this.type, this.prob, this.head);
        LinkedList linkedList = new LinkedList();
        parse.parts = linkedList;
        linkedList.addAll(this.parts);
        if (this.derivation != null) {
            StringBuffer stringBuffer = new StringBuffer(100);
            parse.derivation = stringBuffer;
            stringBuffer.append(this.derivation);
        }
        parse.label = this.label;
        return parse;
    }

    public Parse cloneRoot(Parse parse, int i) {
        Parse parse2 = (Parse) clone();
        parse2.parts.set(i, parse2.parts.get(i).clone(parse));
        return parse2;
    }

    public boolean complete() {
        return this.parts.size() == 1;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Parse) {
            Parse parse = (Parse) obj;
            if (Objects.equals(this.label, parse.label) && this.span.equals(parse.span) && this.text.equals(parse.text) && this.parts.equals(parse.parts)) {
                return true;
            }
        }
        return false;
    }

    public void expandTopNode(Parse parse) {
        Logger logger2 = logger;
        if (logger2.isTraceEnabled()) {
            logger2.trace("expandTopNode: parts={}", this.parts);
        }
        int i = 0;
        int i2 = 0;
        boolean z = true;
        while (i < this.parts.size()) {
            Parse parse2 = this.parts.get(i);
            if (parse2 == parse) {
                z = false;
            } else {
                if (z) {
                    parse.parts.add(i2, parse2);
                    this.parts.remove(i);
                } else {
                    parse.parts.add(parse2);
                    this.parts.remove(i);
                }
                i--;
            }
            i++;
            i2++;
        }
        parse.updateSpan();
    }

    public int getChildCount() {
        return this.parts.size();
    }

    public Parse[] getChildren() {
        return (Parse[]) this.parts.toArray(new Parse[0]);
    }

    public Parse getCommonParent(Parse parse) {
        if (this == parse) {
            return this.parent;
        }
        HashSet hashSet = new HashSet();
        for (Parse parent = this; parent != null; parent = parent.getParent()) {
            hashSet.add(parent);
        }
        while (parse != null) {
            if (hashSet.contains(parse)) {
                return parse;
            }
            parse = parse.getParent();
        }
        return null;
    }

    public String getCoveredText() {
        return this.text.substring(this.span.getStart(), this.span.getEnd());
    }

    public StringBuffer getDerivation() {
        return this.derivation;
    }

    public Parse getHead() {
        return this.head;
    }

    public int getHeadIndex() {
        return this.headIndex;
    }

    public String getLabel() {
        return this.label;
    }

    public Collection<Parse> getNextPunctuationSet() {
        return this.nextPunctSet;
    }

    public Parse getParent() {
        return this.parent;
    }

    public Collection<Parse> getPreviousPunctuationSet() {
        return this.prevPunctSet;
    }

    public double getProb() {
        return this.prob;
    }

    public Span getSpan() {
        return this.span;
    }

    public Parse[] getTagNodes() {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList(this.parts);
        while (linkedList2.size() != 0) {
            Parse parse = (Parse) linkedList2.remove(0);
            if (parse.isPosTag()) {
                linkedList.add(parse);
            } else {
                linkedList2.addAll(0, parse.parts);
            }
        }
        return (Parse[]) linkedList.toArray(new Parse[0]);
    }

    public double getTagSequenceProb() {
        Logger logger2 = logger;
        if (logger2.isTraceEnabled()) {
            logger2.trace("Parse.getTagSequenceProb: {} {}", this.type, this);
        }
        if (this.parts.size() == 1 && this.parts.get(0).type.equals(AbstractBottomUpParser.TOK_NODE)) {
            if (logger2.isTraceEnabled()) {
                logger2.trace("{} {}", this, Double.valueOf(this.prob));
            }
            return StrictMath.log(this.prob);
        }
        double tagSequenceProb = 0.0d;
        if (this.parts.size() == 0) {
            logger2.warn("Parse.getTagSequenceProb: Wrong base case!");
            return 0.0d;
        }
        Iterator<Parse> it = this.parts.iterator();
        while (it.hasNext()) {
            tagSequenceProb += it.next().getTagSequenceProb();
        }
        return tagSequenceProb;
    }

    public String getText() {
        return this.text;
    }

    public Parse[] getTokenNodes() {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList(this.parts);
        while (linkedList2.size() != 0) {
            Parse parse = (Parse) linkedList2.remove(0);
            if (parse.getType().equals(AbstractBottomUpParser.TOK_NODE)) {
                linkedList.add(parse);
            } else {
                linkedList2.addAll(0, parse.parts);
            }
        }
        return (Parse[]) linkedList.toArray(new Parse[0]);
    }

    public String getType() {
        return this.type;
    }

    public int hashCode() {
        return Objects.hash(this.span, this.text);
    }

    public int indexOf(Parse parse) {
        return this.parts.indexOf(parse);
    }

    public void insert(Parse parse) {
        Span span = parse.span;
        if (!this.span.contains(span)) {
            throw new IllegalArgumentException("Inserting constituent not contained in the sentence!");
        }
        int size = this.parts.size();
        int i = 0;
        while (i < size) {
            Parse parse2 = this.parts.get(i);
            Logger logger2 = logger;
            if (logger2.isTraceEnabled()) {
                logger2.trace("Parse.insert:con={} sp[{}] {} {}", parse, Integer.valueOf(i), parse2, parse2.getType());
            }
            Span span2 = parse2.span;
            if (span2.getStart() >= span.getEnd()) {
                break;
            }
            if (span.contains(span2)) {
                if (logger2.isTraceEnabled()) {
                    logger2.trace("Parse.insert:con contains subPart");
                }
                this.parts.remove(i);
                i--;
                parse.parts.add(parse2);
                parse2.setParent(parse);
                if (logger2.isTraceEnabled()) {
                    logger2.trace("Parse.insert: {} -> {}", Integer.valueOf(parse2.hashCode()), Integer.valueOf(parse2.getParent().hashCode()));
                }
                size = this.parts.size();
            } else if (span2.contains(span)) {
                if (logger2.isTraceEnabled()) {
                    logger2.trace("Parse.insert:subPart contains con");
                }
                parse2.insert(parse);
                return;
            }
            i++;
        }
        Logger logger3 = logger;
        if (logger3.isTraceEnabled()) {
            logger3.trace("Parse.insert:adding con={} to {}", parse, this);
        }
        this.parts.add(i, parse);
        parse.setParent(this);
    }

    public void isChunk(boolean z) {
        this.isChunk = z;
    }

    public boolean isFlat() {
        Iterator<Parse> it = this.parts.iterator();
        boolean zIsPosTag = true;
        while (it.hasNext()) {
            zIsPosTag &= it.next().isPosTag();
        }
        return zIsPosTag;
    }

    public boolean isPosTag() {
        return this.parts.size() == 1 && this.parts.get(0).getType().equals(AbstractBottomUpParser.TOK_NODE);
    }

    public void remove(int i) {
        this.parts.remove(i);
        if (this.parts.isEmpty()) {
            return;
        }
        if (i == 0 || i == this.parts.size()) {
            this.span = new Span(this.parts.get(0).span.getStart(), ((Parse) AbstractC0000a.m10g(this.parts, 1)).span.getEnd());
        }
    }

    public void setChild(int i, String str) {
        Parse parse = (Parse) this.parts.get(i).clone();
        parse.setLabel(str);
        this.parts.set(i, parse);
    }

    public void setDerivation(StringBuffer stringBuffer) {
        this.derivation = stringBuffer;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public void setNextPunctuation(Collection<Parse> collection) {
        this.nextPunctSet = collection;
    }

    public void setParent(Parse parse) {
        this.parent = parse;
    }

    public void setPrevPunctuation(Collection<Parse> collection) {
        this.prevPunctSet = collection;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void show(StringBuffer stringBuffer) {
        int start = this.span.getStart();
        if (!this.type.equals(AbstractBottomUpParser.TOK_NODE)) {
            stringBuffer.append("(");
            stringBuffer.append(this.type);
            stringBuffer.append(" ");
            Logger logger2 = logger;
            if (logger2.isTraceEnabled()) {
                logger2.trace("{} ", this.label);
            }
            if (logger2.isTraceEnabled()) {
                logger2.trace("{} ", this.head);
            }
            if (logger2.isTraceEnabled()) {
                logger2.trace("{} ", Double.valueOf(this.prob));
            }
        }
        for (Parse parse : this.parts) {
            Span span = parse.span;
            if (start < span.getStart()) {
                Logger logger3 = logger;
                if (logger3.isTraceEnabled()) {
                    logger3.trace("pre {} {}", Integer.valueOf(start), Integer.valueOf(span.getStart()));
                }
                stringBuffer.append(encodeToken(this.text.substring(start, span.getStart())));
            }
            parse.show(stringBuffer);
            start = span.getEnd();
        }
        if (start < this.span.getEnd()) {
            stringBuffer.append(encodeToken(this.text.substring(start, this.span.getEnd())));
        }
        if (this.type.equals(AbstractBottomUpParser.TOK_NODE)) {
            return;
        }
        stringBuffer.append(")");
    }

    public void showCodeTree() {
        codeTree(this, new int[0]);
    }

    public String toString() {
        return getCoveredText();
    }

    public String toStringPennTreebank() {
        StringBuffer stringBuffer = new StringBuffer();
        show(stringBuffer);
        return stringBuffer.toString();
    }

    public void updateHeads(HeadRules headRules) {
        List<Parse> list = this.parts;
        if (list == null || list.size() == 0) {
            this.head = this;
            return;
        }
        Iterator<Parse> it = this.parts.iterator();
        while (it.hasNext()) {
            it.next().updateHeads(headRules);
        }
        Parse head = headRules.getHead((Parse[]) this.parts.toArray(new Parse[0]), this.type);
        this.head = head;
        if (head == null) {
            this.head = this;
        } else {
            this.headIndex = head.headIndex;
        }
    }

    public void updateSpan() {
        this.span = new Span(this.parts.get(0).span.getStart(), ((Parse) AbstractC0000a.m10g(this.parts, 1)).span.getEnd());
    }

    private static String getType(String str) {
        if (str.startsWith("-LCB-")) {
            return "-LCB-";
        }
        if (str.startsWith("-RCB-")) {
            return "-RCB-";
        }
        if (str.startsWith("-LRB-")) {
            return "-LRB-";
        }
        if (str.startsWith("-RRB-")) {
            return "-RRB-";
        }
        if (str.startsWith("-RSB-")) {
            return "-RSB-";
        }
        if (str.startsWith("-LSB-")) {
            return "-LSB-";
        }
        if (str.startsWith("-NONE-")) {
            return "-NONE-";
        }
        Matcher matcher = typePattern.matcher(str);
        if (!matcher.find()) {
            return null;
        }
        String strGroup = matcher.group(1);
        if (useFunctionTags) {
            Matcher matcher2 = funTypePattern.matcher(str);
            if (matcher2.find()) {
                return AbstractC0541b.m757C(strGroup, CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR, matcher2.group(1));
            }
        }
        return strGroup;
    }

    public static Parse parseParse(String str, GapLabeler gapLabeler) {
        StringBuilder sb = new StringBuilder();
        Stack<Constituent> stack = new Stack<>();
        LinkedList<Constituent> linkedList = new LinkedList();
        int length = str.length();
        int length2 = 0;
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '(') {
                String strSubstring = str.substring(i + 1);
                String type = getType(strSubstring);
                if (type == null) {
                    logger.warn("null type for: {}", strSubstring);
                }
                String token = getToken(strSubstring);
                stack.push(new Constituent(type, new Span(length2, length2)));
                if (token != null) {
                    if (!Objects.equals(type, "-NONE-") || gapLabeler == null) {
                        linkedList.add(new Constituent(AbstractBottomUpParser.TOK_NODE, new Span(length2, token.length() + length2)));
                        sb.append(token);
                        sb.append(" ");
                        length2 += token.length() + 1;
                    } else {
                        Logger logger2 = logger;
                        if (logger2.isTraceEnabled()) {
                            logger2.trace("stack.size={}", Integer.valueOf(stack.size()));
                        }
                        gapLabeler.labelGaps(stack);
                    }
                }
            } else if (cCharAt == ')') {
                Constituent constituentPop = stack.pop();
                int start = constituentPop.getSpan().getStart();
                if (start < length2) {
                    linkedList.add(new Constituent(constituentPop.getLabel(), new Span(start, length2 - 1)));
                }
            }
        }
        String string = sb.toString();
        Parse parse = new Parse(string, new Span(0, string.length()), AbstractBottomUpParser.TOP_NODE, 1.0d, 0);
        int i2 = -1;
        for (Constituent constituent : linkedList) {
            String label = constituent.getLabel();
            if (!label.equals(AbstractBottomUpParser.TOP_NODE)) {
                if (AbstractBottomUpParser.TOK_NODE.equals(label)) {
                    i2++;
                }
                int i4 = i2;
                Parse parse2 = new Parse(string, constituent.getSpan(), label, 1.0d, i4);
                Logger logger3 = logger;
                if (logger3.isTraceEnabled()) {
                    logger3.trace("insert[{}] {} {} {}", Integer.valueOf(i4), label, parse2, Integer.valueOf(parse2.hashCode()));
                }
                parse.insert(parse2);
                i2 = i4;
            }
        }
        return parse;
    }

    @Override // java.lang.Comparable
    public int compareTo(Parse parse) {
        return Double.compare(parse.getProb(), getProb());
    }

    public boolean isChunk() {
        return this.isChunk;
    }

    public Parse clone(Parse parse) {
        if (this == parse) {
            return (Parse) clone();
        }
        Parse parse2 = (Parse) clone();
        parse2.parts.set(this.parts.size() - 1, parse2.parts.get(this.parts.size() - 1).clone(parse));
        return parse2;
    }

    public Parse(String str, Span span, String str2, double d, Parse parse) {
        this(str, span, str2, d, 0);
        if (parse != null) {
            this.head = parse;
            this.headIndex = parse.headIndex;
        }
    }

    public void show() {
        StringBuffer stringBuffer = new StringBuffer(this.text.length() * 4);
        show(stringBuffer);
        logger.debug(stringBuffer.toString());
    }
}
