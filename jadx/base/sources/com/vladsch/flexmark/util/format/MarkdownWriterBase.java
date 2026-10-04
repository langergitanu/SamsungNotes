package com.vladsch.flexmark.util.format;

import com.vladsch.flexmark.util.format.MarkdownWriterBase;
import com.vladsch.flexmark.util.format.NodeContext;
import com.vladsch.flexmark.util.misc.BitFieldSet;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import com.vladsch.flexmark.util.sequence.LineAppendable;
import com.vladsch.flexmark.util.sequence.LineAppendableImpl;
import com.vladsch.flexmark.util.sequence.LineInfo;
import com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder;
import java.util.Iterator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public abstract class MarkdownWriterBase<T extends MarkdownWriterBase<T, N, C>, N, C extends NodeContext<N, C>> implements LineAppendable {
    protected final LineAppendableImpl appendable;
    protected C context;

    public MarkdownWriterBase() {
        this(0);
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    public <T extends Appendable> T appendTo(@NotNull T t, boolean z, int i, int i2, int i4, int i5) {
        return (T) this.appendable.appendTo(t, z, i, i2, i4, i5);
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    public int column() {
        return this.appendable.column();
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    public boolean endsWithEOL() {
        return this.appendable.endsWithEOL();
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    public int getAfterEolPrefixDelta() {
        return this.appendable.getAfterEolPrefixDelta();
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public BasedSequence getBeforeEolPrefix() {
        return this.appendable.getBeforeEolPrefix();
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public ISequenceBuilder<?, ?> getBuilder() {
        return this.appendable.getBuilder();
    }

    public C getContext() {
        return this.context;
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public BasedSequence getIndentPrefix() {
        return this.appendable.getIndentPrefix();
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public BasedSequence getLine(int i) {
        return this.appendable.getLine(i);
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    public int getLineCount() {
        return this.appendable.getLineCount();
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    public int getLineCountWithPending() {
        return this.appendable.getLineCountWithPending();
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public LineInfo getLineInfo(int i) {
        return this.appendable.getLineInfo(i);
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public Iterable<BasedSequence> getLines(int i, int i2, int i4, boolean z) {
        return this.appendable.getLines(i, i2, i4, true);
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public Iterable<LineInfo> getLinesInfo(int i, int i2, int i4) {
        return this.appendable.getLinesInfo(i, i2, i4);
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public BitFieldSet<LineAppendable.Options> getOptionSet() {
        return this.appendable.getOptionSet();
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    public int getOptions() {
        return this.appendable.getOptions();
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    public int getPendingEOL() {
        return this.appendable.getPendingEOL();
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    public int getPendingSpace() {
        return this.appendable.getPendingSpace();
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public BasedSequence getPrefix() {
        return this.appendable.getPrefix();
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    public int getTrailingBlankLines(int i) {
        return this.appendable.getTrailingBlankLines(i);
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    public void insertLine(int i, @NotNull CharSequence charSequence, @NotNull CharSequence charSequence2) {
        this.appendable.insertLine(i, charSequence, charSequence2);
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    public boolean isPendingSpace() {
        return this.appendable.isPendingSpace();
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    public boolean isPreFormatted() {
        return this.appendable.isPreFormatted();
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable, java.lang.Iterable
    @NotNull
    public Iterator<LineInfo> iterator() {
        return this.appendable.iterator();
    }

    @NotNull
    public abstract BasedSequence lastBlockQuoteChildPrefix(BasedSequence basedSequence);

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    public int offset() {
        return this.appendable.offset();
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    public int offsetWithPending() {
        return this.appendable.offsetWithPending();
    }

    public void setContext(C c) {
        this.context = c;
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    public void setLine(int i, @NotNull CharSequence charSequence, @NotNull CharSequence charSequence2) {
        this.appendable.setLine(i, charSequence, charSequence2);
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    public void setPrefixLength(int i, int i2) {
        this.appendable.setPrefixLength(i, i2);
    }

    @NotNull
    public T tailBlankLine() {
        return (T) tailBlankLine(1);
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public CharSequence toSequence(int i, int i2, boolean z) {
        return this.appendable.toSequence(i, i2, z);
    }

    public String toString() {
        return this.appendable.toString();
    }

    public MarkdownWriterBase(int i) {
        this(null, i);
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public T addIndentOnFirstEOL(@NotNull Runnable runnable) {
        this.appendable.addIndentOnFirstEOL(runnable);
        return this;
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public T blankLineIf(boolean z) {
        this.appendable.blankLineIf(z);
        return this;
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public T changeOptions(int i, int i2) {
        this.appendable.changeOptions(i, i2);
        return this;
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public T closePreFormatted() {
        this.appendable.closePreFormatted();
        return this;
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public T indent() {
        this.appendable.indent();
        return this;
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public T line() {
        this.appendable.line();
        return this;
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public T lineIf(boolean z) {
        this.appendable.lineIf(z);
        return this;
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public T lineOnFirstText(boolean z) {
        this.appendable.lineOnFirstText(z);
        return this;
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public T lineWithTrailingSpaces(int i) {
        this.appendable.lineWithTrailingSpaces(i);
        return this;
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public T openPreFormatted(boolean z) {
        this.appendable.openPreFormatted(z);
        return this;
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public T popOptions() {
        this.appendable.popOptions();
        return this;
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public T pushOptions() {
        this.appendable.pushOptions();
        return this;
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public T pushPrefix() {
        this.appendable.pushPrefix();
        return this;
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public T removeExtraBlankLines(int i, int i2, int i4, int i5) {
        this.appendable.removeExtraBlankLines(i, i2, i4, i5);
        return this;
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public T removeIndentOnFirstEOL(@NotNull Runnable runnable) {
        this.appendable.removeIndentOnFirstEOL(runnable);
        return this;
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public T removeLines(int i, int i2) {
        this.appendable.removeLines(i, i2);
        return this;
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public T setIndentPrefix(@Nullable CharSequence charSequence) {
        this.appendable.setIndentPrefix(charSequence);
        return this;
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public T setOptions(int i) {
        this.appendable.setOptions(i);
        return this;
    }

    @NotNull
    public T tailBlankLine(int i) {
        BasedSequence prefix = this.appendable.getPrefix();
        BasedSequence basedSequenceLastBlockQuoteChildPrefix = lastBlockQuoteChildPrefix(prefix);
        if (basedSequenceLastBlockQuoteChildPrefix.equals(prefix)) {
            this.appendable.blankLine(i);
            return this;
        }
        this.appendable.setPrefix(basedSequenceLastBlockQuoteChildPrefix, false);
        this.appendable.blankLine(i);
        this.appendable.setPrefix(prefix, false);
        return this;
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public String toString(int i, int i2, boolean z) {
        return this.appendable.toString(i, i2, z);
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public T unIndent() {
        this.appendable.unIndent();
        return this;
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public T unIndentNoEol() {
        this.appendable.unIndentNoEol();
        return this;
    }

    public MarkdownWriterBase(@Nullable Appendable appendable, int i) {
        LineAppendableImpl lineAppendableImpl = new LineAppendableImpl(appendable, i);
        this.appendable = lineAppendableImpl;
        lineAppendableImpl.setOptions(lineAppendableImpl.getOptions() | LineAppendable.F_PREFIX_PRE_FORMATTED);
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public T addPrefix(@NotNull CharSequence charSequence) {
        this.appendable.addPrefix(charSequence);
        return this;
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public T blankLine() {
        this.appendable.blankLine();
        return this;
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public T popPrefix() {
        this.appendable.popPrefix();
        return this;
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public T setPrefix(@NotNull CharSequence charSequence) {
        this.appendable.setPrefix(charSequence);
        return this;
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public T addPrefix(@NotNull CharSequence charSequence, boolean z) {
        this.appendable.addPrefix(charSequence, z);
        return this;
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public T blankLine(int i) {
        this.appendable.blankLine(i);
        return this;
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public T popPrefix(boolean z) {
        this.appendable.popPrefix(z);
        return this;
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public T setPrefix(@Nullable CharSequence charSequence, boolean z) {
        this.appendable.setPrefix(charSequence, z);
        return this;
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable, java.lang.Appendable
    @NotNull
    public T append(char c) {
        this.appendable.append(c);
        return this;
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable, java.lang.Appendable
    @NotNull
    public T append(@NotNull CharSequence charSequence) {
        this.appendable.append(charSequence);
        return this;
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable, java.lang.Appendable
    @NotNull
    public T append(@NotNull CharSequence charSequence, int i, int i2) {
        this.appendable.append(charSequence, i, i2);
        return this;
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public T append(@NotNull LineAppendable lineAppendable, int i, int i2, boolean z) {
        this.appendable.append(lineAppendable, i, i2, z);
        return this;
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public T append(char c, int i) {
        this.appendable.append(c, i);
        return this;
    }
}
