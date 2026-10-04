package com.vladsch.flexmark.util.ast;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import androidx.glance.AbstractC2821a;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.vladsch.flexmark.util.collection.iteration.ReversiblePeekingIterable;
import com.vladsch.flexmark.util.collection.iteration.ReversiblePeekingIterator;
import com.vladsch.flexmark.util.misc.Pair;
import com.vladsch.flexmark.util.misc.Utils;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import com.vladsch.flexmark.util.sequence.Range;
import com.vladsch.flexmark.util.sequence.SegmentedSequence;
import com.vladsch.flexmark.util.sequence.builder.SequenceBuilder;
import com.vladsch.flexmark.util.visitor.AstNode;
import cz.msebera.android.httpclient.protocol.HTTP;
import java.util.Arrays;
import opennlp.tools.parser.Parse;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public abstract class Node {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String SPLICE = " … ";

    @NotNull
    private BasedSequence chars;

    @Nullable
    Node firstChild;

    @Nullable
    private Node lastChild;

    @Nullable
    Node next;

    @Nullable
    private Node parent;

    @Nullable
    private Node prev;
    public static final BasedSequence[] EMPTY_SEGMENTS = BasedSequence.EMPTY_ARRAY;
    public static final AstNode<Node> AST_ADAPTER = new AstNode<Node>() { // from class: com.vladsch.flexmark.util.ast.Node.1
        @Override // com.vladsch.flexmark.util.visitor.AstNode
        @Nullable
        public Node getFirstChild(@NotNull Node node) {
            return node.firstChild;
        }

        @Override // com.vladsch.flexmark.util.visitor.AstNode
        @Nullable
        public Node getNext(@NotNull Node node) {
            return node.next;
        }
    };

    public Node() {
        this.parent = null;
        this.firstChild = null;
        this.lastChild = null;
        this.prev = null;
        this.next = null;
        this.chars = BasedSequence.NULL;
    }

    public static void astChars(@NotNull StringBuilder sb, @NotNull CharSequence charSequence, @NotNull String str) {
        if (charSequence.length() > 0) {
            if (charSequence.length() <= 10) {
                sb.append(' ');
                sb.append(str);
                sb.append(" \"");
                sb.append(charSequence);
                sb.append("\"");
                return;
            }
            sb.append(' ');
            sb.append(str);
            sb.append(" \"");
            sb.append(charSequence.subSequence(0, 5));
            sb.append(SPLICE);
            sb.append(charSequence.subSequence(charSequence.length() - 5, charSequence.length()));
            sb.append("\"");
        }
    }

    public static void delimitedSegmentSpan(@NotNull StringBuilder sb, @NotNull BasedSequence basedSequence, @NotNull BasedSequence basedSequence2, @NotNull BasedSequence basedSequence3, @NotNull String str) {
        StringBuilder sb2;
        String str2;
        segmentSpanChars(sb, basedSequence.getStartOffset(), basedSequence.getEndOffset(), AbstractC0541b.m756B(str, "Open"), basedSequence.toString());
        if (basedSequence2.length() <= 10) {
            segmentSpanChars(sb, basedSequence2.getStartOffset(), basedSequence2.getEndOffset(), str, basedSequence2.toVisibleWhitespaceString());
            sb2 = sb;
            str2 = str;
        } else {
            sb2 = sb;
            str2 = str;
            segmentSpanChars(sb2, basedSequence2.getStartOffset(), basedSequence2.getEndOffset(), str2, basedSequence2.subSequence(0, 5).toVisibleWhitespaceString(), SPLICE, basedSequence2.endSequence(basedSequence2.length() - 5).toVisibleWhitespaceString());
        }
        segmentSpanChars(sb2, basedSequence3.getStartOffset(), basedSequence3.getEndOffset(), AbstractC0541b.m756B(str2, HTTP.CONN_CLOSE), basedSequence3.toString());
    }

    public static void delimitedSegmentSpanChars(@NotNull StringBuilder sb, @NotNull BasedSequence basedSequence, @NotNull BasedSequence basedSequence2, @NotNull BasedSequence basedSequence3, @NotNull String str) {
        if (basedSequence.isNotNull()) {
            segmentSpanChars(sb, basedSequence.getStartOffset(), basedSequence.getEndOffset(), AbstractC0541b.m756B(str, "Open"), basedSequence.toString());
        }
        if (basedSequence2.isNotNull()) {
            segmentSpanChars(sb, basedSequence2.getStartOffset(), basedSequence2.getEndOffset(), str, basedSequence2.toVisibleWhitespaceString());
        }
        if (basedSequence3.isNotNull()) {
            segmentSpanChars(sb, basedSequence3.getStartOffset(), basedSequence3.getEndOffset(), AbstractC0541b.m756B(str, HTTP.CONN_CLOSE), basedSequence3.toString());
        }
    }

    @NotNull
    public static BasedSequence getLeadSegment(@NotNull BasedSequence[] basedSequenceArr) {
        for (BasedSequence basedSequence : basedSequenceArr) {
            if (basedSequence != BasedSequence.NULL) {
                return basedSequence;
            }
        }
        return BasedSequence.NULL;
    }

    public static int getNodeOfTypeIndex(@NotNull Node node, @NotNull Class<?>... clsArr) {
        int i = 0;
        for (Class<?> cls : clsArr) {
            if (cls.isInstance(node)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @NotNull
    public static BasedSequence getTrailSegment(BasedSequence[] basedSequenceArr) {
        int length = basedSequenceArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return BasedSequence.NULL;
            }
            BasedSequence basedSequence = basedSequenceArr[i];
            if (basedSequence != BasedSequence.NULL) {
                return basedSequence;
            }
            length = i;
        }
    }

    public static void segmentSpan(@NotNull StringBuilder sb, int i, int i2, @Nullable String str) {
        if (str != null && !str.trim().isEmpty()) {
            AbstractC1974b.m1332y(sb, " ", str, ":");
        }
        AbstractC0622a.m1180z(sb, i, i2, "[", SQLKeyword.COMMA);
        sb.append("]");
    }

    public static void segmentSpanChars(@NotNull StringBuilder sb, int i, int i2, @Nullable String str, @NotNull String str2) {
        segmentSpanChars(sb, i, i2, str, str2, "", "");
    }

    public static void segmentSpanCharsToVisible(@NotNull StringBuilder sb, @NotNull BasedSequence basedSequence, @NotNull String str) {
        if (basedSequence.isNotNull()) {
            if (basedSequence.length() <= 10) {
                segmentSpanChars(sb, basedSequence.getStartOffset(), basedSequence.getEndOffset(), str, basedSequence.toVisibleWhitespaceString());
            } else {
                segmentSpanChars(sb, basedSequence.getStartOffset(), basedSequence.getEndOffset(), str, basedSequence.subSequence(0, 5).toVisibleWhitespaceString(), SPLICE, basedSequence.endSequence(basedSequence.length() - 5).toVisibleWhitespaceString());
            }
        }
    }

    @NotNull
    public static BasedSequence spanningChars(BasedSequence... basedSequenceArr) {
        int startOffset = Integer.MAX_VALUE;
        int endOffset = -1;
        BasedSequence basedSequence = null;
        BasedSequence basedSequence2 = null;
        for (BasedSequence basedSequence3 : basedSequenceArr) {
            if (basedSequence3 != BasedSequence.NULL) {
                if (startOffset > basedSequence3.getStartOffset()) {
                    startOffset = basedSequence3.getStartOffset();
                    basedSequence = basedSequence3;
                }
                if (endOffset <= basedSequence3.getEndOffset()) {
                    endOffset = basedSequence3.getEndOffset();
                    basedSequence2 = basedSequence3;
                }
            }
        }
        return (basedSequence == null || basedSequence2 == null) ? BasedSequence.NULL : basedSequence.baseSubSequence(basedSequence.getStartOffset(), basedSequence2.getEndOffset());
    }

    @NotNull
    public static String toSegmentSpan(@NotNull BasedSequence basedSequence, @Nullable String str) {
        StringBuilder sb = new StringBuilder();
        segmentSpan(sb, basedSequence, str);
        return sb.toString();
    }

    public void appendChain(@NotNull Node node) {
        while (node != null) {
            Node node2 = node.next;
            appendChild(node);
            node = node2;
        }
    }

    public void appendChild(Node node) {
        node.unlink();
        node.setParent(this);
        Node node2 = this.lastChild;
        if (node2 == null) {
            this.firstChild = node;
            this.lastChild = node;
        } else {
            node2.next = node;
            node.prev = node2;
            this.lastChild = node;
        }
    }

    public void astExtraChars(@NotNull StringBuilder sb) {
        if (getChars().length() > 0) {
            if (getChars().length() <= 10) {
                segmentSpanChars(sb, getChars(), "chars");
            } else {
                segmentSpanChars(sb, getChars().getStartOffset(), getChars().getEndOffset(), "chars", getChars().subSequence(0, 5).toVisibleWhitespaceString(), SPLICE, getChars().subSequence(getChars().length() - 5).toVisibleWhitespaceString());
            }
        }
    }

    public void astString(@NotNull StringBuilder sb, boolean z) {
        sb.append(getNodeName());
        sb.append("[");
        sb.append(getStartOffset());
        sb.append(SQLKeyword.COMMA);
        sb.append(getEndOffset());
        sb.append("]");
        if (z) {
            getAstExtra(sb);
        }
    }

    public BasedSequence baseSubSequence(int i, int i2) {
        return this.chars.baseSubSequence(i, i2);
    }

    public int countAncestorsOfType(@NotNull Class<?>... clsArr) {
        int i = 0;
        for (Node parent = getParent(); parent != null; parent = parent.getParent()) {
            int length = clsArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                if (clsArr[i2].isInstance(parent)) {
                    i++;
                    break;
                }
                i2++;
            }
        }
        return i;
    }

    public int countDirectAncestorsOfType(@Nullable Class<?> cls, @NotNull Class<?>... clsArr) {
        boolean z;
        int i = 0;
        for (Node parent = getParent(); parent != null; parent = parent.getParent()) {
            int length = clsArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    z = false;
                    break;
                }
                z = true;
                if (clsArr[i2].isInstance(parent)) {
                    i++;
                    break;
                }
                if (cls != null && cls.isInstance(parent)) {
                    break;
                }
                i2++;
            }
            if (!z) {
                return i;
            }
        }
        return i;
    }

    public int endOfLine(int i) {
        return this.chars.baseEndOfLine(i);
    }

    public void extractChainTo(@NotNull Node node) {
        Node node2 = this;
        while (true) {
            Node next = node2.getNext();
            node.appendChild(node2);
            if (!getClass().isInstance(next)) {
                return;
            } else {
                node2 = next;
            }
        }
    }

    public void extractToFirstInChain(@NotNull Node node) {
        getFirstInChain().extractChainTo(node);
    }

    @Nullable
    public Node getAncestorOfType(@NotNull Class<?>... clsArr) {
        for (Node parent = getParent(); parent != null; parent = parent.getParent()) {
            for (Class<?> cls : clsArr) {
                if (cls.isInstance(parent)) {
                    return parent;
                }
            }
        }
        return null;
    }

    public void getAstExtra(@NotNull StringBuilder sb) {
    }

    public BasedSequence getBaseSequence() {
        return this.chars.getBaseSequence();
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0024, code lost:
    
        return r2;
     */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Node getBlankLineSibling() {
        Node node = this.parent;
        Node node2 = this;
        Node node3 = node2;
        while (true) {
            Node node4 = node.parent;
            if (node4 == null || node != node4.getLastChildAnyNot(BlankLine.class)) {
                break;
            }
            Node node5 = node instanceof BlankLineContainer ? node : node2;
            node = node.parent;
            if (node == null) {
                return node2;
            }
            Node node6 = node5;
            node3 = node2;
            node2 = node6;
        }
    }

    @NotNull
    public BasedSequence getChars() {
        return this.chars;
    }

    @NotNull
    public BasedSequence getCharsFromSegments() {
        BasedSequence[] segmentsForChars = getSegmentsForChars();
        return segmentsForChars.length == 0 ? BasedSequence.NULL : SegmentedSequence.create(segmentsForChars[0], Arrays.asList(segmentsForChars));
    }

    public BasedSequence getChildChars() {
        Node node = this.firstChild;
        return (node == null || this.lastChild == null) ? BasedSequence.NULL : node.baseSubSequence(node.getStartOffset(), this.lastChild.getEndOffset());
    }

    @NotNull
    public ReversiblePeekingIterator<Node> getChildIterator() {
        return this.firstChild == null ? NodeIterator.EMPTY : new NodeIterator(this.firstChild, this.lastChild, false);
    }

    @Nullable
    public Node getChildOfType(@NotNull Class<?>... clsArr) {
        for (Node firstChild = getFirstChild(); firstChild != null; firstChild = firstChild.getNext()) {
            for (Class<?> cls : clsArr) {
                if (cls.isInstance(firstChild)) {
                    return firstChild;
                }
            }
        }
        return null;
    }

    @NotNull
    public ReversiblePeekingIterable<Node> getChildren() {
        return this.firstChild == null ? NodeIterable.EMPTY : new NodeIterable(this.firstChild, this.lastChild, false);
    }

    @NotNull
    public ReversiblePeekingIterable<Node> getDescendants() {
        return this.firstChild == null ? NodeIterable.EMPTY : new DescendantNodeIterable(getChildren());
    }

    @NotNull
    public Document getDocument() {
        Node parent = this;
        while (parent != null && !(parent instanceof Document)) {
            parent = parent.getParent();
        }
        return (Document) parent;
    }

    public BasedSequence getEmptyPrefix() {
        return this.chars.getEmptyPrefix();
    }

    public BasedSequence getEmptySuffix() {
        return this.chars.getEmptySuffix();
    }

    public int getEndLineNumber() {
        int endOffset = this.chars.getEndOffset();
        Document document = getDocument();
        if (endOffset > 0) {
            endOffset--;
        }
        return document.getLineNumber(endOffset);
    }

    public int getEndOfLine() {
        return this.chars.baseEndOfLine();
    }

    public int getEndOffset() {
        return this.chars.getEndOffset();
    }

    public BasedSequence getExactChildChars() {
        if (this.firstChild == null || this.lastChild == null) {
            return BasedSequence.NULL;
        }
        SequenceBuilder sequenceBuilderEmptyBuilder = SequenceBuilder.emptyBuilder(getChars());
        for (Node firstChild = getFirstChild(); firstChild != null; firstChild = firstChild.getNext()) {
            firstChild.getChars().addSegments(sequenceBuilderEmptyBuilder.getSegmentBuilder());
        }
        return sequenceBuilderEmptyBuilder.toSequence();
    }

    @Nullable
    public Node getFirstChild() {
        return this.firstChild;
    }

    @Nullable
    public Node getFirstChildAny(@NotNull Class<?>... clsArr) {
        Node node = this.firstChild;
        if (clsArr.length > 0) {
            while (node != null && getNodeOfTypeIndex(node, clsArr) == -1) {
                node = node.next;
            }
        }
        return node;
    }

    @Nullable
    public Node getFirstChildAnyNot(@NotNull Class<?>... clsArr) {
        Node node = this.firstChild;
        if (clsArr.length > 0) {
            while (node != null && getNodeOfTypeIndex(node, clsArr) != -1) {
                node = node.next;
            }
        }
        return node;
    }

    @NotNull
    public Node getFirstInChain() {
        Node previous = this;
        while (getClass().isInstance(previous.getPrevious())) {
            previous = previous.getPrevious();
        }
        return previous;
    }

    @Nullable
    public Node getGrandParent() {
        Node node = this.parent;
        if (node == null) {
            return null;
        }
        return node.getParent();
    }

    @Nullable
    public Node getLastBlankLineChild() {
        return null;
    }

    @Nullable
    public Node getLastChild() {
        return this.lastChild;
    }

    @Nullable
    public Node getLastChildAny(@NotNull Class<?>... clsArr) {
        Node node = this.lastChild;
        if (clsArr.length > 0) {
            while (node != null && getNodeOfTypeIndex(node, clsArr) == -1) {
                node = node.prev;
            }
        }
        return node;
    }

    @Nullable
    public Node getLastChildAnyNot(@NotNull Class<?>... clsArr) {
        Node node = this.lastChild;
        if (clsArr.length > 0) {
            while (node != null && getNodeOfTypeIndex(node, clsArr) != -1) {
                node = node.prev;
            }
        }
        return node;
    }

    @NotNull
    public Node getLastInChain() {
        Node next = this;
        while (getClass().isInstance(next.getNext())) {
            next = next.getNext();
        }
        return next;
    }

    public Pair<Integer, Integer> getLineColumnAtEnd() {
        return this.chars.baseLineColumnAtEnd();
    }

    public int getLineNumber() {
        return getStartLineNumber();
    }

    @Nullable
    public Node getNext() {
        return this.next;
    }

    @Nullable
    public Node getNextAny(@NotNull Class<?>... clsArr) {
        Node node = this.next;
        if (clsArr.length > 0) {
            while (node != null && getNodeOfTypeIndex(node, clsArr) == -1) {
                node = node.next;
            }
        }
        return node;
    }

    @Nullable
    public Node getNextAnyNot(@NotNull Class<?>... clsArr) {
        Node node = this.next;
        if (clsArr.length > 0) {
            while (node != null && getNodeOfTypeIndex(node, clsArr) != -1) {
                node = node.next;
            }
        }
        return node;
    }

    @NotNull
    public String getNodeName() {
        return getClass().getName().substring(getClass().getPackage().getName().length() + 1);
    }

    @Nullable
    public Node getOldestAncestorOfTypeAfter(@NotNull Class<?> cls, @NotNull Class<?> cls2) {
        Node node = null;
        for (Node parent = getParent(); parent != null; parent = parent.getParent()) {
            if (!cls.isInstance(parent)) {
                if (cls2.isInstance(parent)) {
                    break;
                }
            } else {
                node = parent;
            }
        }
        return node;
    }

    @Nullable
    public Node getParent() {
        return this.parent;
    }

    @Nullable
    public Node getPrevious() {
        return this.prev;
    }

    @Nullable
    public Node getPreviousAny(@NotNull Class<?>... clsArr) {
        Node node = this.prev;
        if (clsArr.length > 0) {
            while (node != null && getNodeOfTypeIndex(node, clsArr) == -1) {
                node = node.prev;
            }
        }
        return node;
    }

    @Nullable
    public Node getPreviousAnyNot(@NotNull Class<?>... clsArr) {
        Node node = this.prev;
        if (clsArr.length > 0) {
            while (node != null && getNodeOfTypeIndex(node, clsArr) != -1) {
                node = node.prev;
            }
        }
        return node;
    }

    @NotNull
    public ReversiblePeekingIterator<Node> getReversedChildIterator() {
        return this.firstChild == null ? NodeIterator.EMPTY : new NodeIterator(this.firstChild, this.lastChild, true);
    }

    @NotNull
    public ReversiblePeekingIterable<Node> getReversedChildren() {
        return this.firstChild == null ? NodeIterable.EMPTY : new NodeIterable(this.firstChild, this.lastChild, true);
    }

    @NotNull
    public ReversiblePeekingIterable<Node> getReversedDescendants() {
        return this.firstChild == null ? NodeIterable.EMPTY : new DescendantNodeIterable(getReversedChildren());
    }

    @NotNull
    public abstract BasedSequence[] getSegments();

    @NotNull
    public BasedSequence[] getSegmentsForChars() {
        return getSegments();
    }

    public Range getSourceRange() {
        return this.chars.getSourceRange();
    }

    public int getStartLineNumber() {
        return getDocument().getLineNumber(this.chars.getStartOffset());
    }

    public int getStartOfLine() {
        return this.chars.baseStartOfLine();
    }

    public int getStartOffset() {
        return this.chars.getStartOffset();
    }

    public int getTextLength() {
        return this.chars.length();
    }

    public boolean hasChildren() {
        return this.firstChild != null;
    }

    public boolean hasOrMoreChildren(int i) {
        if (this.firstChild != null) {
            ReversiblePeekingIterator<Node> it = getChildren().iterator();
            int i2 = 0;
            while (it.hasNext()) {
                it.next();
                i2++;
                if (i2 >= i) {
                    return true;
                }
            }
        }
        return false;
    }

    public void insertAfter(@NotNull Node node) {
        node.unlink();
        Node node2 = this.next;
        node.next = node2;
        if (node2 != null) {
            node2.prev = node;
        }
        node.prev = this;
        this.next = node;
        Node node3 = this.parent;
        node.parent = node3;
        if (node.next == null) {
            node3.lastChild = node;
        }
    }

    public void insertBefore(Node node) {
        node.unlink();
        Node node2 = this.prev;
        node.prev = node2;
        if (node2 != null) {
            node2.next = node;
        }
        node.next = this;
        this.prev = node;
        Node node3 = this.parent;
        node.parent = node3;
        if (node.prev == null) {
            node3.firstChild = node;
        }
    }

    public void insertChainAfter(@NotNull Node node) {
        Node node2 = this;
        while (node != null) {
            Node node3 = node.next;
            node2.insertAfter(node);
            node2 = node;
            node = node3;
        }
    }

    public void insertChainBefore(@NotNull Node node) {
        while (node != null) {
            Node node2 = node.next;
            insertBefore(node);
            node = node2;
        }
    }

    public boolean isOrDescendantOfType(@NotNull Class<?>... clsArr) {
        for (Node parent = this; parent != null; parent = parent.getParent()) {
            if (parent.getNodeOfTypeIndex(clsArr) != -1) {
                return true;
            }
        }
        return false;
    }

    public Pair<Integer, Integer> lineColumnAtIndex(int i) {
        return this.chars.baseLineColumnAtIndex(i);
    }

    public Pair<Integer, Integer> lineColumnAtStart() {
        return this.chars.baseLineColumnAtStart();
    }

    public void moveTrailingBlankLines() {
        Node lastChild = getLastChild();
        if (lastChild instanceof BlankLine) {
            Node blankLineSibling = getBlankLineSibling();
            blankLineSibling.insertChainAfter(lastChild.getFirstInChain());
            Node node = this;
            do {
                node.setCharsFromContentOnly();
                node = node.parent;
                if (node == null) {
                    return;
                }
            } while (node != blankLineSibling.getParent());
        }
    }

    public void prependChild(@NotNull Node node) {
        node.unlink();
        node.setParent(this);
        Node node2 = this.firstChild;
        if (node2 == null) {
            this.firstChild = node;
            this.lastChild = node;
        } else {
            node2.prev = node;
            node.next = node2;
            this.firstChild = node;
        }
    }

    public void removeChildren() {
        Node node = this.firstChild;
        while (node != null) {
            Node next = node.getNext();
            node.unlink();
            node = next;
        }
    }

    public void setChars(@NotNull BasedSequence basedSequence) {
        this.chars = basedSequence;
    }

    public void setCharsFromContent() {
        BasedSequence basedSequenceSpanningChars;
        Node node;
        Node node2;
        BasedSequence[] segments = getSegments();
        if (segments.length > 0) {
            BasedSequence leadSegment = getLeadSegment(segments);
            BasedSequence trailSegment = getTrailSegment(segments);
            Node node3 = this.firstChild;
            basedSequenceSpanningChars = (node3 == null || (node2 = this.lastChild) == null) ? spanningChars(leadSegment, trailSegment) : spanningChars(leadSegment, trailSegment, node3.chars, node2.chars);
        } else {
            Node node4 = this.firstChild;
            basedSequenceSpanningChars = (node4 == null || (node = this.lastChild) == null) ? null : spanningChars(node4.chars, node.chars);
        }
        if (basedSequenceSpanningChars != null) {
            if (this.chars.isNull()) {
                setChars(basedSequenceSpanningChars);
            } else {
                setChars(this.chars.baseSubSequence(Utils.min(this.chars.getStartOffset(), basedSequenceSpanningChars.getStartOffset()), Utils.max(this.chars.getEndOffset(), basedSequenceSpanningChars.getEndOffset())));
            }
        }
    }

    public void setCharsFromContentOnly() {
        this.chars = BasedSequence.NULL;
        setCharsFromContent();
    }

    public void setCharsFromSegments() {
        setChars(getCharsFromSegments());
    }

    public void setParent(@Nullable Node node) {
        this.parent = node;
    }

    public int startOfLine(int i) {
        return this.chars.baseStartOfLine(i);
    }

    public void takeChildren(@NotNull Node node) {
        Node node2 = node.firstChild;
        if (node2 != null) {
            Node node3 = node.lastChild;
            if (node3 == node2) {
                appendChild(node2);
                return;
            }
            node.firstChild = null;
            node.lastChild = null;
            node2.parent = this;
            node3.parent = this;
            Node node4 = this.lastChild;
            if (node4 != null) {
                node4.next = node2;
                node2.prev = node4;
            } else {
                this.firstChild = node2;
            }
            this.lastChild = node3;
        }
    }

    @NotNull
    public String toAstString(boolean z) {
        StringBuilder sb = new StringBuilder();
        astString(sb, z);
        return sb.toString();
    }

    public String toString() {
        return AbstractC2821a.m2221l(getClass().getName().substring(getClass().getPackage().getName().length() + 1), Parse.BRACKET_LCB, toStringAttributes(), "}");
    }

    @NotNull
    public String toStringAttributes() {
        return "";
    }

    public void unlink() {
        Node node = this.prev;
        if (node != null) {
            node.next = this.next;
        } else {
            Node node2 = this.parent;
            if (node2 != null) {
                node2.firstChild = this.next;
            }
        }
        Node node3 = this.next;
        if (node3 != null) {
            node3.prev = node;
        } else {
            Node node4 = this.parent;
            if (node4 != null) {
                node4.lastChild = node;
            }
        }
        this.parent = null;
        this.next = null;
        this.prev = null;
    }

    public static void segmentSpanChars(@NotNull StringBuilder sb, int i, int i2, @Nullable String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        if (str != null && !str.trim().isEmpty()) {
            AbstractC1974b.m1332y(sb, " ", str, ":");
        }
        AbstractC0622a.m1180z(sb, i, i2, "[", SQLKeyword.COMMA);
        if (!str2.isEmpty() || !str4.isEmpty()) {
            sb.append(", \"");
            Utils.escapeJavaString(sb, str2);
            sb.append(str3);
            Utils.escapeJavaString(sb, str4);
            sb.append("\"");
        }
        sb.append("]");
    }

    public BasedSequence baseSubSequence(int i) {
        return this.chars.baseSubSequence(i);
    }

    public int getNodeOfTypeIndex(@NotNull Class<?>... clsArr) {
        return getNodeOfTypeIndex(this, clsArr);
    }

    public Node(@NotNull BasedSequence basedSequence) {
        this.parent = null;
        this.firstChild = null;
        this.lastChild = null;
        this.prev = null;
        this.next = null;
        BasedSequence basedSequence2 = BasedSequence.NULL;
        this.chars = basedSequence;
    }

    public static void segmentSpan(@NotNull StringBuilder sb, @NotNull BasedSequence basedSequence, @Nullable String str) {
        if (basedSequence.isNotNull()) {
            segmentSpan(sb, basedSequence.getStartOffset(), basedSequence.getEndOffset(), str);
        }
    }

    public static void segmentSpanChars(@NotNull StringBuilder sb, @NotNull BasedSequence basedSequence, @NotNull String str) {
        if (basedSequence.isNotNull()) {
            segmentSpanChars(sb, basedSequence.getStartOffset(), basedSequence.getEndOffset(), str, basedSequence.toString());
        }
    }
}
