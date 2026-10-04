package com.vladsch.flexmark.util.sequence;

import androidx.compose.runtime.AbstractC1974b;
import com.vladsch.flexmark.util.collection.iteration.Indexed;
import com.vladsch.flexmark.util.collection.iteration.IndexedItemIterable;
import com.vladsch.flexmark.util.collection.iteration.IndexedItemIterator;
import com.vladsch.flexmark.util.misc.BitFieldSet;
import com.vladsch.flexmark.util.misc.CharPredicate;
import com.vladsch.flexmark.util.misc.Pair;
import com.vladsch.flexmark.util.misc.Utils;
import com.vladsch.flexmark.util.sequence.LineAppendable;
import com.vladsch.flexmark.util.sequence.LineInfo;
import com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder;
import com.vladsch.flexmark.util.sequence.builder.StringSequenceBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class LineAppendableImpl implements LineAppendable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final char EOL = '\n';
    private boolean allWhitespace;
    private ISequenceBuilder<?, ?> appendable;
    private int eolOnFirstText;
    private CharSequence indentPrefix;
    private final Stack<Boolean> indentPrefixStack;
    private final ArrayList<Runnable> indentsOnFirstEol;
    private boolean lastWasWhitespace;
    final ArrayList<LineInfo> lines;
    int modificationCount;
    private final Stack<Integer> optionStack;
    private final BitFieldSet<LineAppendable.Options> options;
    private final boolean passThrough;
    private int preFormattedFirstLine;
    private int preFormattedFirstLineOffset;
    private int preFormattedLastLine;
    private int preFormattedLastLineOffset;
    private int preFormattedNesting;
    private CharSequence prefix;
    private CharSequence prefixAfterEol;
    private final Stack<CharSequence> prefixStack;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class IndexedLineInfoProxy implements Indexed<LineInfo> {

        @NotNull
        final LineAppendableImpl appendable;
        final int endLine;
        final int maxTrailingBlankLines;
        final int startLine;

        public IndexedLineInfoProxy(@NotNull LineAppendableImpl lineAppendableImpl, int i, int i2, int i4) {
            this.appendable = lineAppendableImpl;
            this.startLine = i2;
            this.endLine = Math.min(i4, lineAppendableImpl.getLineCountWithPending());
            this.maxTrailingBlankLines = i;
        }

        @Override // com.vladsch.flexmark.util.collection.iteration.Indexed
        public int modificationCount() {
            return this.appendable.modificationCount;
        }

        @Override // com.vladsch.flexmark.util.collection.iteration.Indexed
        public void removeAt(int i) {
            int i2 = this.startLine;
            if (i + i2 >= this.endLine) {
                throw new IndexOutOfBoundsException(String.format("index %d is out of valid range [%d, %d)", Integer.valueOf(i), Integer.valueOf(this.startLine), Integer.valueOf(this.endLine)));
            }
            this.appendable.removeLines(i2 + i, i + 1);
        }

        @Override // com.vladsch.flexmark.util.collection.iteration.Indexed
        public int size() {
            return Math.max(0, (this.endLine - this.startLine) - this.appendable.tailBlankLinesToRemove(this.endLine, this.maxTrailingBlankLines));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.vladsch.flexmark.util.collection.iteration.Indexed
        @NotNull
        public LineInfo get(int i) {
            int i2 = this.startLine;
            if (i + i2 < this.endLine) {
                return this.appendable.getLineInfo(i + i2);
            }
            throw new IndexOutOfBoundsException(String.format("index %d is out of valid range [%d, %d)", Integer.valueOf(i), Integer.valueOf(this.startLine), Integer.valueOf(this.endLine)));
        }

        @Override // com.vladsch.flexmark.util.collection.iteration.Indexed
        public void set(int i, @NotNull LineInfo lineInfo) {
            int i2 = this.startLine;
            if (i + i2 >= this.endLine) {
                throw new IndexOutOfBoundsException(String.format("index %d is out of valid range [%d, %d)", Integer.valueOf(i), Integer.valueOf(this.startLine), Integer.valueOf(this.endLine)));
            }
            this.appendable.lines.set(i2 + i, lineInfo);
            this.appendable.recomputeLineInfo(this.startLine + i + 1);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class IndexedLineProxy implements Indexed<BasedSequence> {

        @NotNull
        final IndexedLineInfoProxy proxy;
        final boolean withPrefixes;

        public IndexedLineProxy(@NotNull IndexedLineInfoProxy indexedLineInfoProxy, boolean z) {
            this.proxy = indexedLineInfoProxy;
            this.withPrefixes = z;
        }

        @Override // com.vladsch.flexmark.util.collection.iteration.Indexed
        public int modificationCount() {
            return this.proxy.modificationCount();
        }

        @Override // com.vladsch.flexmark.util.collection.iteration.Indexed
        public void removeAt(int i) {
            this.proxy.removeAt(i);
        }

        @Override // com.vladsch.flexmark.util.collection.iteration.Indexed
        public int size() {
            return this.proxy.size();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.vladsch.flexmark.util.collection.iteration.Indexed
        public BasedSequence get(int i) {
            IndexedLineInfoProxy indexedLineInfoProxy = this.proxy;
            return (indexedLineInfoProxy.maxTrailingBlankLines == -1 && i + 1 == indexedLineInfoProxy.size()) ? this.withPrefixes ? this.proxy.get(i).getLineNoEOL() : this.proxy.get(i).getTextNoEOL() : this.withPrefixes ? this.proxy.get(i).getLine() : this.proxy.get(i).getText();
        }

        @Override // com.vladsch.flexmark.util.collection.iteration.Indexed
        public void set(int i, BasedSequence basedSequence) {
            if (this.withPrefixes) {
                IndexedLineInfoProxy indexedLineInfoProxy = this.proxy;
                indexedLineInfoProxy.appendable.setLine(i + indexedLineInfoProxy.startLine, BasedSequence.NULL, basedSequence);
            } else {
                IndexedLineInfoProxy indexedLineInfoProxy2 = this.proxy;
                LineAppendableImpl lineAppendableImpl = indexedLineInfoProxy2.appendable;
                int i2 = indexedLineInfoProxy2.startLine;
                lineAppendableImpl.setLine(i + i2, lineAppendableImpl.getLineInfo(i + i2).getPrefix(), basedSequence);
            }
        }
    }

    public LineAppendableImpl(int i) {
        this((Appendable) null, LineAppendable.toOptionSet(i));
    }

    private void addLineRange(int i, int i2, CharSequence charSequence) {
        this.lines.add(getLineRange(i, i2, charSequence));
        resetBuilder();
    }

    private boolean any(int i) {
        return this.options.any(i);
    }

    private void appendEol(@NotNull CharSequence charSequence) {
        this.appendable.append(charSequence);
        addLineRange(0, this.appendable.length() - charSequence.length(), this.prefix);
        this.eolOnFirstText = 0;
        rawIndentsOnFirstEol();
    }

    private void appendImpl(CharSequence charSequence, int i) {
        char cCharAt = charSequence.charAt(i);
        if (this.passThrough) {
            if (cCharAt == '\n') {
                appendEol(BasedSequence.EOL);
                return;
            }
            if (this.eolOnFirstText > 0) {
                this.eolOnFirstText = 0;
                appendEol(BasedSequence.EOL);
            }
            if (cCharAt != '\t' && cCharAt != ' ') {
                this.allWhitespace = false;
            }
            this.appendable.append(cCharAt);
            return;
        }
        if (cCharAt == '\n') {
            Pair<Range, CharSequence> rangePrefixAfterEol = getRangePrefixAfterEol();
            Range first = rangePrefixAfterEol.getFirst();
            if (first.isNull()) {
                resetBuilder();
            } else {
                this.appendable.append(cCharAt);
                addLineRange(first.getStart(), first.getEnd(), rangePrefixAfterEol.getSecond());
            }
            rawIndentsOnFirstEol();
            return;
        }
        doEolOnFirstTest();
        if (cCharAt == '\t') {
            if (this.preFormattedNesting == 0 && any(LineAppendable.F_COLLAPSE_WHITESPACE)) {
                if (this.lastWasWhitespace) {
                    return;
                }
                this.appendable.append(' ');
                this.lastWasWhitespace = true;
                return;
            }
            if (!any(LineAppendable.F_CONVERT_TABS)) {
                this.appendable.append(charSequence, i, i + 1);
                return;
            } else {
                this.appendable.append(' ', 4 - (this.appendable.length() % 4));
                return;
            }
        }
        if (cCharAt != ' ') {
            this.allWhitespace = false;
            this.lastWasWhitespace = false;
            this.appendable.append(charSequence, i, i + 1);
            return;
        }
        if (this.preFormattedNesting != 0) {
            this.appendable.append(charSequence.subSequence(i, i + 1));
        } else if ((!any(LineAppendable.F_TRIM_LEADING_WHITESPACE) || (this.appendable.length() != 0 && !this.allWhitespace)) && (!any(LineAppendable.F_COLLAPSE_WHITESPACE) || !this.lastWasWhitespace)) {
            this.appendable.append(' ');
        }
        this.lastWasWhitespace = true;
    }

    private LineInfo createLineInfo(int i, @NotNull CharSequence charSequence, @NotNull CharSequence charSequence2) {
        LineInfo lineInfo = i == 0 ? LineInfo.NULL : this.lines.get(i - 1);
        LineInfo lineInfo2 = i == this.lines.size() ? LineInfo.NULL : this.lines.get(i);
        CharSequence charSequenceTrimmedEOL = SequenceUtils.trimmedEOL(charSequence2);
        if (charSequenceTrimmedEOL == null) {
            charSequenceTrimmedEOL = "\n";
        } else {
            charSequence2 = charSequence2.subSequence(0, charSequence2.length() - charSequenceTrimmedEOL.length());
        }
        if (charSequence2.length() == 0) {
            charSequence = SequenceUtils.trimEnd(charSequence);
        }
        CharSequence sequence = this.appendable.getBuilder().append(charSequence).append(charSequence2).append(charSequenceTrimmedEOL).toSequence();
        return LineInfo.create(sequence, lineInfo, charSequence.length(), charSequence2.length(), sequence.length(), SequenceUtils.isBlank(charSequence), SequenceUtils.isBlank(charSequence2), lineInfo2.isNotNull() ? lineInfo2.getPreformatted() : (!lineInfo.isPreformatted() || lineInfo.getPreformatted() == LineInfo.Preformatted.LAST) ? LineInfo.Preformatted.NONE : LineInfo.Preformatted.BODY);
    }

    private void doEolOnFirstTest() {
        if (this.eolOnFirstText > 0) {
            this.eolOnFirstText = 0;
            appendEol(BasedSequence.EOL);
        }
    }

    private LineInfo getLineRange(int i, int i2, CharSequence charSequence) {
        CharSequence sequence = this.appendable.toSequence();
        CharSequence charSequenceTrimmedEOL = SequenceUtils.trimmedEOL(sequence);
        if (charSequenceTrimmedEOL == null || charSequenceTrimmedEOL.length() == 0) {
            charSequenceTrimmedEOL = "\n";
        }
        Range range = Range.NULL;
        CharSequence charSequenceSubSequence = (i == range.getStart() && i2 == range.getEnd()) ? BasedSequence.NULL : sequence.subSequence(i, Math.max(i, i2 - Math.max(0, charSequenceTrimmedEOL.length() - 1)));
        CharSequence charSequenceTrimEnd = i >= i2 ? SequenceUtils.trimEnd(charSequence) : charSequence;
        CharSequence sequence2 = this.appendable.getBuilder().append(charSequenceTrimEnd).append(charSequenceSubSequence).append(charSequenceTrimmedEOL).toSequence();
        return LineInfo.create(sequence2, getLastLineInfo(), charSequenceTrimEnd.length(), charSequenceSubSequence.length(), sequence2.length(), SequenceUtils.isBlank(charSequenceTrimEnd), this.allWhitespace || charSequenceSubSequence.length() == 0, this.preFormattedNesting > 0 ? this.preFormattedFirstLine == this.lines.size() ? LineInfo.Preformatted.FIRST : LineInfo.Preformatted.BODY : this.preFormattedFirstLine == this.lines.size() ? LineInfo.Preformatted.LAST : LineInfo.Preformatted.NONE);
    }

    private Pair<Range, CharSequence> getRangePrefixAfterEol() {
        int i;
        int length = this.appendable.length();
        int iCountTrailingSpaceTab = length + 1;
        int size = this.lines.size();
        boolean zIsPrefixed = isPrefixed(size);
        if (this.passThrough) {
            return new Pair<>(Range.m13451of(0, length), zIsPrefixed ? this.prefix : BasedSequence.NULL);
        }
        if (this.allWhitespace && this.preFormattedNesting == 0 && this.preFormattedFirstLine != size && this.preFormattedLastLine != size) {
            return (any(LineAppendable.F_TRIM_LEADING_EOL) && this.lines.isEmpty()) ? new Pair<>(Range.NULL, BasedSequence.NULL) : new Pair<>(Range.m13451of(0, length), this.prefix);
        }
        if (!isTrimTrailingWhitespace() || this.preFormattedNesting != 0) {
            length = 0;
        } else if (!this.allWhitespace) {
            iCountTrailingSpaceTab -= SequenceUtils.countTrailingSpaceTab(this.appendable.toSequence(), length);
            length = 0;
        }
        if (this.preFormattedFirstLine == size && length > (i = this.preFormattedFirstLineOffset)) {
            length = i;
        }
        if (this.preFormattedLastLine == size) {
            int i2 = this.preFormattedLastLineOffset;
            if (iCountTrailingSpaceTab < i2 + 1) {
                iCountTrailingSpaceTab = i2 + 1;
            }
        }
        return new Pair<>(Range.m13451of(length, iCountTrailingSpaceTab - 1), zIsPrefixed ? this.prefix : BasedSequence.NULL);
    }

    private boolean isCollapseWhitespace() {
        return any(LineAppendable.F_COLLAPSE_WHITESPACE);
    }

    private boolean isConvertingTabs() {
        return any(LineAppendable.F_CONVERT_TABS | LineAppendable.F_COLLAPSE_WHITESPACE);
    }

    private boolean isPrefixed(int i) {
        if (any(LineAppendable.F_PREFIX_PRE_FORMATTED) || this.preFormattedFirstLine == i) {
            return true;
        }
        return this.preFormattedNesting == 0 && this.preFormattedLastLine != i;
    }

    private boolean isTrailingBlankLine() {
        return this.appendable.length() == 0 && getLastLineInfo().isBlankText();
    }

    private boolean isTrimLeadingWhitespace() {
        return any(LineAppendable.F_TRIM_LEADING_WHITESPACE);
    }

    private boolean isTrimTrailingWhitespace() {
        return any(LineAppendable.F_TRIM_TRAILING_WHITESPACE);
    }

    private int offsetAfterEol() {
        Pair<Range, CharSequence> rangePrefixAfterEol = getRangePrefixAfterEol();
        LineInfo lastLineInfo = getLastLineInfo();
        if (rangePrefixAfterEol.getFirst().isNull()) {
            return lastLineInfo.sumLength;
        }
        Range first = rangePrefixAfterEol.getFirst();
        CharSequence second = rangePrefixAfterEol.getSecond();
        if (first.isEmpty() && second.length() != 0) {
            second = SequenceUtils.trimEnd(second);
        }
        return second.length() + rangePrefixAfterEol.getFirst().getSpan() + lastLineInfo.sumLength;
    }

    private void rawIndent() {
        this.prefixStack.push(this.prefixAfterEol);
        CharSequence charSequenceCombinedPrefix = LineAppendable.combinedPrefix(this.prefixAfterEol, this.indentPrefix);
        this.prefix = charSequenceCombinedPrefix;
        this.prefixAfterEol = charSequenceCombinedPrefix;
        this.indentPrefixStack.push(Boolean.TRUE);
    }

    private void rawIndentsOnFirstEol() {
        this.prefix = this.prefixAfterEol;
        while (!this.indentsOnFirstEol.isEmpty()) {
            Runnable runnableRemove = this.indentsOnFirstEol.remove(r0.size() - 1);
            rawIndent();
            runnableRemove.run();
        }
    }

    private void rawUnIndent() {
        if (this.prefixStack.isEmpty()) {
            throw new IllegalStateException("unIndent with an empty stack");
        }
        if (!this.indentPrefixStack.peek().booleanValue()) {
            throw new IllegalStateException("unIndent for an element added by pushPrefix(), use popPrefix() instead");
        }
        CharSequence charSequencePop = this.prefixStack.pop();
        this.prefix = charSequencePop;
        this.prefixAfterEol = charSequencePop;
        this.indentPrefixStack.pop();
    }

    private int removeLinesRaw(int i, int i2) {
        int iMinLimit = Utils.minLimit(i, 0);
        int iMaxLimit = Utils.maxLimit(i2, getLineCountWithPending());
        if (iMinLimit < iMaxLimit) {
            this.lines.subList(iMinLimit, iMaxLimit).clear();
            this.modificationCount++;
            return iMinLimit;
        }
        if (i2 >= getLineCountWithPending() && this.appendable.length() > 0) {
            resetBuilder();
        }
        return this.lines.size();
    }

    private void resetBuilder() {
        this.appendable = this.appendable.getBuilder();
        this.allWhitespace = true;
        this.lastWasWhitespace = true;
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public LineAppendable addIndentOnFirstEOL(@NotNull Runnable runnable) {
        this.indentsOnFirstEol.add(runnable);
        return this;
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public LineAppendable addPrefix(@NotNull CharSequence charSequence, boolean z) {
        if (!this.passThrough && charSequence.length() != 0) {
            if (z) {
                this.prefixAfterEol = LineAppendable.combinedPrefix(this.prefixAfterEol, charSequence);
                return this;
            }
            CharSequence charSequenceCombinedPrefix = LineAppendable.combinedPrefix(this.prefixAfterEol, charSequence);
            this.prefix = charSequenceCombinedPrefix;
            this.prefixAfterEol = charSequenceCombinedPrefix;
        }
        return this;
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    public <T extends Appendable> T appendTo(@NotNull T t, boolean z, int i, int i2, int i4, int i5) {
        line();
        return (T) appendToNoLine(t, z, i, i2, i4, i5);
    }

    public <T extends Appendable> T appendToNoLine(@NotNull T t, boolean z, int i, int i2, int i4, int i5) throws IOException {
        boolean z2 = i2 >= 0;
        int iMax = Math.max(0, i);
        int iMax2 = Math.max(0, i2);
        int size = this.lines.size();
        int iMin = Utils.min(getLineCountWithPending(), i5);
        int iLastNonBlankLine = lastNonBlankLine(iMin);
        int i6 = i4;
        int i7 = 0;
        while (i6 < iMin) {
            LineInfo lineInfo = getLineInfo(i6);
            boolean z3 = i6 < size;
            if (lineInfo.textLength != 0 || lineInfo.isPreformatted()) {
                if (!z3 || (!z2 && i6 >= iLastNonBlankLine && (!lineInfo.isPreformatted() || lineInfo.getPreformatted() == LineInfo.Preformatted.LAST))) {
                    if (z) {
                        t.append(lineInfo.getLineNoEOL());
                    } else {
                        t.append(lineInfo.getText());
                    }
                } else if (z) {
                    t.append(lineInfo.lineSeq);
                } else {
                    t.append(lineInfo.getText());
                }
                i7 = 0;
            } else if (i6 > iLastNonBlankLine) {
                if (i7 < iMax2) {
                    i7++;
                    if (z) {
                        boolean zIsTrimTrailingWhitespace = isTrimTrailingWhitespace();
                        CharSequence prefix = lineInfo.getPrefix();
                        if (zIsTrimTrailingWhitespace) {
                            prefix = SequenceUtils.trimEnd(prefix);
                        }
                        t.append(prefix);
                    }
                    if (z3 && (z2 || i7 != iMax2)) {
                        t.append('\n');
                    }
                }
            } else if (i7 < iMax) {
                i7++;
                if (z) {
                    boolean zIsTrimTrailingWhitespace2 = isTrimTrailingWhitespace();
                    CharSequence prefix2 = lineInfo.getPrefix();
                    if (zIsTrimTrailingWhitespace2) {
                        prefix2 = SequenceUtils.trimEnd(prefix2);
                    }
                    t.append(prefix2);
                }
                if (z3) {
                    t.append('\n');
                }
            }
            i6++;
        }
        return t;
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public LineAppendable blankLine() {
        line();
        if ((!this.lines.isEmpty() && !isTrailingBlankLine()) || (this.lines.isEmpty() && !any(LineAppendable.F_TRIM_LEADING_EOL))) {
            appendEol(BasedSequence.EOL);
        }
        return this;
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public LineAppendable blankLineIf(boolean z) {
        if (z) {
            blankLine();
        }
        return this;
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public LineAppendable changeOptions(int i, int i2) {
        int i4 = i & i2;
        if (i4 != 0) {
            throw new IllegalStateException(String.format("Add flags:%d and remove flags:%d overlap:%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i4)));
        }
        this.options.orMask(i);
        this.options.andNotMask(i2);
        return this;
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public LineAppendable closePreFormatted() {
        int i = this.preFormattedNesting;
        if (i <= 0) {
            throw new IllegalStateException("closePreFormatted called with nesting == 0");
        }
        int i2 = i - 1;
        this.preFormattedNesting = i2;
        if (i2 == 0 && !endsWithEOL()) {
            this.preFormattedLastLine = this.lines.size();
            this.preFormattedLastLineOffset = this.appendable.length();
        }
        return this;
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    public int column() {
        return this.appendable.length();
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    public boolean endsWithEOL() {
        return this.appendable.length() == 0 && getLastLineInfo().isNotNull();
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    public int getAfterEolPrefixDelta() {
        return this.prefixAfterEol.length() - this.prefix.length();
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public BasedSequence getBeforeEolPrefix() {
        return BasedSequence.m13437of(this.prefix);
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public ISequenceBuilder<?, ?> getBuilder() {
        return this.appendable.getBuilder();
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public LineAppendable getEmptyAppendable() {
        return new LineAppendableImpl(this, getOptions());
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public BasedSequence getIndentPrefix() {
        return BasedSequence.m13437of(this.indentPrefix);
    }

    @NotNull
    public IndexedLineInfoProxy getIndexedLineInfoProxy(int i, int i2, int i4) {
        return new IndexedLineInfoProxy(this, i, i2, i4);
    }

    @NotNull
    public IndexedLineProxy getIndexedLineProxy(int i, int i2, int i4, boolean z) {
        return new IndexedLineProxy(getIndexedLineInfoProxy(i, i2, i4), z);
    }

    @NotNull
    public LineInfo getLastLineInfo() {
        return this.lines.isEmpty() ? LineInfo.NULL : (LineInfo) AbstractC1974b.m1313f(1, this.lines);
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public BasedSequence getLine(int i) {
        return getLineInfo(i).getLine();
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    public int getLineCount() {
        return this.lines.size();
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    public int getLineCountWithPending() {
        return this.appendable.length() == 0 ? this.lines.size() : this.lines.size() + 1;
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public LineInfo getLineInfo(int i) {
        if (i != this.lines.size()) {
            return this.lines.get(i);
        }
        if (this.appendable.length() == 0) {
            return LineInfo.NULL;
        }
        Pair<Range, CharSequence> rangePrefixAfterEol = getRangePrefixAfterEol();
        Range first = rangePrefixAfterEol.getFirst();
        return first.isNull() ? LineInfo.NULL : getLineRange(first.getStart(), first.getEnd(), rangePrefixAfterEol.getSecond());
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public Iterable<BasedSequence> getLines(int i, int i2, int i4, boolean z) {
        return new IndexedItemIterable(getIndexedLineProxy(i, i2, i4, z));
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public Iterable<LineInfo> getLinesInfo(int i, int i2, int i4) {
        return new IndexedItemIterable(getIndexedLineInfoProxy(i, i2, i4));
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public BitFieldSet<LineAppendable.Options> getOptionSet() {
        return this.options;
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    public int getPendingEOL() {
        if (this.appendable.length() == 0) {
            return getTrailingBlankLines(this.lines.size()) + 1;
        }
        return 0;
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    public int getPendingSpace() {
        if (!this.lastWasWhitespace || this.appendable.length() == 0) {
            return 0;
        }
        return SequenceUtils.countTrailingSpaceTab(this.appendable.toSequence());
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public BasedSequence getPrefix() {
        return BasedSequence.m13437of(this.prefixAfterEol);
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    public int getTrailingBlankLines(int i) {
        int iMin = Math.min(this.lines.size(), i);
        return (iMin - lastNonBlankLine(iMin)) - 1;
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public LineAppendable indent() {
        if (!this.passThrough) {
            line();
            rawIndent();
        }
        return this;
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    public void insertLine(int i, @NotNull CharSequence charSequence, @NotNull CharSequence charSequence2) {
        this.lines.add(i, createLineInfo(i, charSequence, charSequence2));
        recomputeLineInfo(i + 1);
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    public boolean isPendingSpace() {
        return this.appendable.length() > 0 && this.lastWasWhitespace;
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    public boolean isPreFormatted() {
        return this.preFormattedNesting > 0;
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable, java.lang.Iterable
    @NotNull
    public Iterator<LineInfo> iterator() {
        return new IndexedItemIterator(getIndexedLineInfoProxy(Integer.MAX_VALUE, 0, getLineCount()));
    }

    public int lastNonBlankLine(int i) {
        int i2;
        if (i > this.lines.size() && this.appendable.length() > 0 && !this.allWhitespace) {
            return this.lines.size();
        }
        int iMin = Math.min(this.lines.size(), i);
        while (true) {
            i2 = iMin - 1;
            if (iMin <= 0 || !this.lines.get(i2).isBlankText()) {
                break;
            }
            iMin = i2;
        }
        return i2;
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public LineAppendable line() {
        if (this.preFormattedNesting > 0 || this.appendable.length() != 0) {
            appendImpl("\n", 0);
            return this;
        }
        CharSequence charSequence = this.prefix;
        boolean zIsEmpty = this.indentsOnFirstEol.isEmpty();
        rawIndentsOnFirstEol();
        if (zIsEmpty && (charSequence.length() <= 0 || this.prefix.length() != 0)) {
            return this;
        }
        this.prefix = charSequence;
        return this;
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public LineAppendable lineIf(boolean z) {
        if (z) {
            line();
        }
        return this;
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public LineAppendable lineOnFirstText(boolean z) {
        if (z) {
            this.eolOnFirstText++;
            return this;
        }
        int i = this.eolOnFirstText;
        if (i > 0) {
            this.eolOnFirstText = i - 1;
        }
        return this;
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public LineAppendable lineWithTrailingSpaces(int i) {
        if (this.preFormattedNesting <= 0 && this.appendable.length() == 0) {
            return this;
        }
        int i2 = this.options.toInt();
        this.options.andNotMask(LineAppendable.F_TRIM_TRAILING_WHITESPACE | LineAppendable.F_COLLAPSE_WHITESPACE);
        if (i > 0) {
            append(' ', i);
        }
        appendImpl("\n", 0);
        this.options.setAll(i2);
        return this;
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    public int offset() {
        return getLastLineInfo().sumLength;
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    public int offsetWithPending() {
        return offsetAfterEol();
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public LineAppendable openPreFormatted(boolean z) {
        if (this.preFormattedNesting == 0 && this.preFormattedFirstLine != this.lines.size()) {
            this.preFormattedFirstLine = this.lines.size();
            this.preFormattedFirstLineOffset = this.appendable.length();
        }
        this.preFormattedNesting++;
        return this;
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public LineAppendable popOptions() {
        if (this.optionStack.isEmpty()) {
            throw new IllegalStateException("Option stack is empty");
        }
        this.options.setAll(this.optionStack.pop().intValue());
        return this;
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public LineAppendable popPrefix(boolean z) {
        if (this.passThrough) {
            return this;
        }
        if (this.prefixStack.isEmpty()) {
            throw new IllegalStateException("popPrefix with an empty stack");
        }
        if (this.indentPrefixStack.peek().booleanValue()) {
            throw new IllegalStateException("popPrefix for element added by indent(), use unIndent() instead");
        }
        CharSequence charSequencePop = this.prefixStack.pop();
        this.prefixAfterEol = charSequencePop;
        if (!z) {
            this.prefix = charSequencePop;
        }
        this.indentPrefixStack.pop();
        return this;
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public LineAppendable pushOptions() {
        this.optionStack.push(Integer.valueOf(this.options.toInt()));
        return this;
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public LineAppendable pushPrefix() {
        if (!this.passThrough) {
            this.prefixStack.push(this.prefixAfterEol);
            this.indentPrefixStack.push(Boolean.FALSE);
        }
        return this;
    }

    public void recomputeLineInfo(int i) {
        int size = this.lines.size();
        int iMax = Math.max(0, i);
        if (iMax < size) {
            int i2 = iMax - 1;
            LineInfo lineInfoCreate = i2 >= 0 ? this.lines.get(i2) : LineInfo.NULL;
            while (iMax < size) {
                LineInfo lineInfo = this.lines.get(iMax);
                lineInfoCreate = LineInfo.create(lineInfoCreate, lineInfo);
                this.lines.set(iMax, lineInfoCreate);
                if (!lineInfoCreate.needAggregateUpdate(lineInfo)) {
                    return;
                } else {
                    iMax++;
                }
            }
        }
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    public LineAppendable removeExtraBlankLines(int i, int i2, int i4, int i5) {
        int iMax = Math.max(0, i);
        int iMax2 = Math.max(0, i2);
        int iMin = Utils.min(i5, getLineCountWithPending());
        int lineCountWithPending = getLineCountWithPending();
        int i6 = 0;
        while (true) {
            int i7 = iMin - 1;
            if (iMin <= 0) {
                recomputeLineInfo(lineCountWithPending);
                return this;
            }
            LineInfo lineInfo = getLineInfo(i7);
            if (!lineInfo.isBlankText() || lineInfo.isPreformatted()) {
                iMax2 = iMax;
                i6 = 0;
            } else if (i6 >= iMax2) {
                int i8 = i7 + i6;
                lineCountWithPending = removeLinesRaw(i8, i8 + 1);
            } else {
                i6++;
            }
            iMin = i7;
        }
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public LineAppendable removeIndentOnFirstEOL(@NotNull Runnable runnable) {
        this.indentsOnFirstEol.remove(runnable);
        return this;
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public LineAppendable removeLines(int i, int i2) {
        recomputeLineInfo(removeLinesRaw(i, i2));
        return this;
    }

    @NotNull
    public LineAppendable repeat(@NotNull CharSequence charSequence, int i) {
        append(RepeatedSequence.repeatOf(charSequence, i));
        return this;
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public LineAppendable setIndentPrefix(@Nullable CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = BasedSequence.NULL;
        }
        this.indentPrefix = charSequence;
        return this;
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    public void setLine(int i, @NotNull CharSequence charSequence, @NotNull CharSequence charSequence2) {
        if (i == this.lines.size() && this.appendable.length() > 0) {
            line();
        }
        this.lines.set(i, createLineInfo(i, charSequence, charSequence2));
        recomputeLineInfo(i + 1);
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public LineAppendable setOptions(int i) {
        this.options.setAll(i);
        return this;
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public LineAppendable setPrefix(@Nullable CharSequence charSequence, boolean z) {
        if (!this.passThrough) {
            if (z) {
                if (charSequence == null) {
                    charSequence = BasedSequence.NULL;
                }
                this.prefixAfterEol = charSequence;
                return this;
            }
            if (charSequence == null) {
                charSequence = BasedSequence.NULL;
            }
            this.prefix = charSequence;
            this.prefixAfterEol = charSequence;
        }
        return this;
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    public void setPrefixLength(int i, int i2) {
        if (i == this.lines.size() && this.appendable.length() > 0) {
            line();
        }
        LineInfo lineInfo = this.lines.get(i);
        CharSequence charSequence = lineInfo.lineSeq;
        if (i2 < 0 || i2 > lineInfo.getTextEnd()) {
            throw new IllegalArgumentException(String.format("prefixLength %d is out of valid range [0, %d) for the line", Integer.valueOf(i2), Integer.valueOf(lineInfo.getTextEnd() + 1)));
        }
        if (i2 != lineInfo.prefixLength) {
            CharSequence charSequenceSubSequence = charSequence.subSequence(0, i2);
            this.lines.set(i, LineInfo.create(lineInfo.lineSeq, i == 0 ? LineInfo.NULL : this.lines.get(i - 1), charSequenceSubSequence.length(), (lineInfo.prefixLength + lineInfo.textLength) - i2, lineInfo.length, SequenceUtils.isBlank(charSequenceSubSequence), SequenceUtils.isBlank(charSequence.subSequence(i2, lineInfo.getTextEnd())), lineInfo.getPreformatted()));
            recomputeLineInfo(i + 1);
        }
    }

    public int tailBlankLinesToRemove(int i, int i2) {
        return Utils.max(0, getTrailingBlankLines(i) - Utils.max(0, i2));
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public CharSequence toSequence(int i, int i2, boolean z) {
        ISequenceBuilder<?, ?> builder = getBuilder();
        try {
            appendTo(builder, z, i, i2, 0, Integer.MAX_VALUE);
        } catch (IOException unused) {
        }
        return builder.toSequence();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        try {
            appendToNoLine(sb, true, Integer.MAX_VALUE, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
        } catch (IOException unused) {
        }
        return sb.toString();
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public LineAppendable unIndent() {
        if (!this.passThrough) {
            line();
            rawUnIndent();
        }
        return this;
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public LineAppendable unIndentNoEol() {
        if (!this.passThrough) {
            if (endsWithEOL()) {
                rawUnIndent();
                return this;
            }
            CharSequence charSequence = this.prefix;
            rawUnIndent();
            this.prefixAfterEol = this.prefix;
            this.prefix = charSequence;
        }
        return this;
    }

    public LineAppendableImpl(@Nullable Appendable appendable, int i) {
        this(appendable, LineAppendable.toOptionSet(i));
    }

    @NotNull
    public LineAppendable repeat(@NotNull CharSequence charSequence, int i, int i2, int i4) {
        append(RepeatedSequence.repeatOf(charSequence.subSequence(i, i2), i4));
        return this;
    }

    public LineAppendableImpl(@Nullable Appendable appendable, BitFieldSet<LineAppendable.Options> bitFieldSet) {
        ISequenceBuilder<?, ?> builder;
        this.optionStack = new Stack<>();
        if (appendable instanceof ISequenceBuilder) {
            builder = ((ISequenceBuilder) appendable).getBuilder();
        } else {
            builder = appendable instanceof LineAppendable ? ((LineAppendable) appendable).getBuilder() : StringSequenceBuilder.emptyBuilder();
        }
        this.appendable = builder;
        this.options = bitFieldSet;
        this.passThrough = any(LineAppendable.F_PASS_THROUGH);
        this.preFormattedNesting = 0;
        this.preFormattedFirstLine = -1;
        this.preFormattedLastLine = -1;
        this.allWhitespace = true;
        this.lastWasWhitespace = false;
        this.lines = new ArrayList<>();
        this.prefixStack = new Stack<>();
        this.indentPrefixStack = new Stack<>();
        BasedSequence basedSequence = BasedSequence.EMPTY;
        this.prefix = basedSequence;
        this.prefixAfterEol = basedSequence;
        this.indentPrefix = basedSequence;
        this.eolOnFirstText = 0;
        this.indentsOnFirstEol = new ArrayList<>();
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public LineAppendable blankLine(int i) {
        line();
        if (any(LineAppendable.F_TRIM_LEADING_EOL) && this.lines.isEmpty()) {
            return this;
        }
        appendEol(i - getTrailingBlankLines(this.lines.size()));
        return this;
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable, java.lang.Appendable
    @NotNull
    public LineAppendable append(@NotNull CharSequence charSequence) {
        if (charSequence.length() > 0) {
            appendImpl(charSequence, 0, charSequence.length());
            return this;
        }
        this.appendable.append(charSequence);
        return this;
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public String toString(int i, int i2, boolean z) {
        StringBuilder sb = new StringBuilder();
        try {
            appendTo(sb, z, i, i2, 0, Integer.MAX_VALUE);
        } catch (IOException unused) {
        }
        return sb.toString();
    }

    private void appendEol(int i) {
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                return;
            }
            appendEol(BasedSequence.EOL);
            i = i2;
        }
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable, java.lang.Appendable
    @NotNull
    public LineAppendable append(@NotNull CharSequence charSequence, int i, int i2) {
        if (i < i2) {
            appendImpl(charSequence, i, i2);
        }
        return this;
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable, java.lang.Appendable
    @NotNull
    public LineAppendable append(char c) {
        appendImpl(Character.toString(c), 0);
        return this;
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public LineAppendable append(char c, int i) {
        append(RepeatedSequence.repeatOf(c, i));
        return this;
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public LineAppendable append(@NotNull LineAppendable lineAppendable, int i, int i2, boolean z) {
        int iMin = Math.min(i2, lineAppendable.getLineCountWithPending());
        for (int iMax = Math.max(0, i); iMax < iMin; iMax++) {
            LineInfo lineInfo = lineAppendable.getLineInfo(iMax);
            BasedSequence textNoEOL = lineInfo.getTextNoEOL();
            CharSequence prefix = z ? lineInfo.getPrefix() : BasedSequence.NULL;
            if (any(LineAppendable.F_PREFIX_PRE_FORMATTED) || !lineInfo.isPreformatted() || lineInfo.getPreformatted() == LineInfo.Preformatted.FIRST) {
                prefix = LineAppendable.combinedPrefix(this.prefix, prefix);
            }
            this.appendable.append((CharSequence) textNoEOL);
            this.allWhitespace = lineInfo.isBlankText();
            int i4 = lineInfo.textLength;
            this.lastWasWhitespace = i4 == 0 || CharPredicate.SPACE_TAB.test(textNoEOL.safeCharAt(i4 + (-1)));
            if (iMax < lineAppendable.getLineCount()) {
                this.appendable.append('\n');
                this.allWhitespace = lineInfo.isBlankText();
                addLineRange(0, this.appendable.length() - 1, prefix);
            } else {
                this.prefix = prefix;
            }
        }
        return this;
    }

    private void appendImpl(CharSequence charSequence, int i, int i2) {
        while (i < i2) {
            appendImpl(charSequence, i);
            i++;
        }
    }
}
