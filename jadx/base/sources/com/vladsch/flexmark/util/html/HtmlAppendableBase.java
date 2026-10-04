package com.vladsch.flexmark.util.html;

import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.tipcard.RunnableC8551a;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.vladsch.flexmark.util.html.HtmlAppendableBase;
import com.vladsch.flexmark.util.misc.BitFieldSet;
import com.vladsch.flexmark.util.misc.Utils;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import com.vladsch.flexmark.util.sequence.Escaping;
import com.vladsch.flexmark.util.sequence.LineAppendable;
import com.vladsch.flexmark.util.sequence.LineAppendableImpl;
import com.vladsch.flexmark.util.sequence.LineInfo;
import com.vladsch.flexmark.util.sequence.RepeatedSequence;
import com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class HtmlAppendableBase<T extends HtmlAppendableBase<T>> implements HtmlAppendable {
    private final LineAppendable appendable;

    @Nullable
    private MutableAttributes currentAttributes;
    private boolean indentOnFirstEol;
    private boolean lineOnChildText;

    @NotNull
    private final Stack<String> openTags;
    private boolean suppressCloseTagLine;
    private boolean suppressOpenTagLine;
    private boolean withAttributes;

    public HtmlAppendableBase(LineAppendable lineAppendable, boolean z) {
        this(lineAppendable, z ? lineAppendable.getIndentPrefix().length() : 0, lineAppendable.getOptions());
    }

    private boolean haveOptions(int i) {
        return (i & this.appendable.getOptions()) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$tag$0(boolean[] zArr) {
        zArr[0] = true;
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

    @Override // com.vladsch.flexmark.util.html.HtmlAppendable
    public Attributes getAttributes() {
        return this.currentAttributes;
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

    public String getOpenTagText() {
        return Utils.splice(this.openTags, SQLKeyword.COMMA, true);
    }

    @Override // com.vladsch.flexmark.util.html.HtmlAppendable
    @NotNull
    public Stack<String> getOpenTags() {
        return this.openTags;
    }

    @Override // com.vladsch.flexmark.util.html.HtmlAppendable
    @NotNull
    public List<String> getOpenTagsAfterLast(@NotNull CharSequence charSequence) {
        if (this.openTags.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList(this.openTags);
        int size = arrayList.size();
        String strValueOf = String.valueOf(charSequence);
        int i = size;
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                i = size;
                break;
            }
            if (((String) arrayList.get(i2)).equals(strValueOf)) {
                break;
            }
            i = i2;
        }
        return arrayList.subList(i, size);
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

    @Override // com.vladsch.flexmark.util.html.HtmlAppendable
    public boolean inPre() {
        return this.appendable.isPreFormatted();
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

    public boolean isSuppressCloseTagLine() {
        return this.suppressCloseTagLine;
    }

    public boolean isSuppressOpenTagLine() {
        return this.suppressOpenTagLine;
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable, java.lang.Iterable
    @NotNull
    public Iterator<LineInfo> iterator() {
        return this.appendable.iterator();
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    public int offset() {
        return this.appendable.offset();
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    public int offsetWithPending() {
        return this.appendable.offsetWithPending();
    }

    public void popTag(CharSequence charSequence) {
        if (this.openTags.isEmpty()) {
            throw new IllegalStateException("Close tag '" + ((Object) charSequence) + "' with no tags open");
        }
        String strPeek = this.openTags.peek();
        if (strPeek.equals(String.valueOf(charSequence))) {
            this.openTags.pop();
            return;
        }
        throw new IllegalStateException("Close tag '" + ((Object) charSequence) + "' does not match '" + strPeek + "' in " + getOpenTagText());
    }

    public void pushTag(CharSequence charSequence) {
        this.openTags.push(String.valueOf(charSequence));
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
    public T setSuppressCloseTagLine(boolean z) {
        this.suppressCloseTagLine = z;
        return this;
    }

    public void setSuppressOpenTagLine(boolean z) {
        this.suppressOpenTagLine = z;
    }

    public void tagClosed(CharSequence charSequence) {
        popTag(charSequence);
    }

    public void tagOpened(CharSequence charSequence) {
        pushTag(charSequence);
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public CharSequence toSequence(int i, int i2, boolean z) {
        return this.appendable.toSequence(i, i2, z);
    }

    @NotNull
    public String toString() {
        return this.appendable.toString();
    }

    public HtmlAppendableBase(int i, int i2) {
        this(null, i, i2);
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

    @Override // com.vladsch.flexmark.util.html.HtmlAppendable
    @NotNull
    public T closePre() {
        this.appendable.closePreFormatted();
        return this;
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public T closePreFormatted() {
        this.appendable.closePreFormatted();
        return this;
    }

    @Override // com.vladsch.flexmark.util.html.HtmlAppendable
    @NotNull
    public T closeTag(@NotNull CharSequence charSequence) {
        if (charSequence.length() == 0) {
            throw new IllegalStateException("closeTag called with tag:'" + ((Object) charSequence) + "'");
        }
        if (charSequence.charAt(0) == '/') {
            this.appendable.append((CharSequence) "<").append(charSequence).append((CharSequence) ">");
            tagClosed(charSequence.subSequence(1, charSequence.length()));
            return this;
        }
        this.appendable.append((CharSequence) "</").append(charSequence).append((CharSequence) ">");
        tagClosed(charSequence);
        return this;
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public HtmlAppendable getEmptyAppendable() {
        LineAppendable lineAppendable = this.appendable;
        return new HtmlAppendableBase(lineAppendable, lineAppendable.getIndentPrefix().length(), this.appendable.getOptions());
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

    @Override // com.vladsch.flexmark.util.html.HtmlAppendable
    @NotNull
    public T openPre() {
        this.appendable.openPreFormatted(true);
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

    @Override // com.vladsch.flexmark.util.html.HtmlAppendable
    @NotNull
    public T rawIndentedPre(@NotNull CharSequence charSequence) {
        this.appendable.openPreFormatted(true).append(charSequence).closePreFormatted();
        return this;
    }

    @Override // com.vladsch.flexmark.util.html.HtmlAppendable
    @NotNull
    public T rawPre(@NotNull CharSequence charSequence) {
        if (this.appendable.getPendingEOL() == 0 && charSequence.length() > 0 && charSequence.charAt(0) == '\n') {
            this.appendable.line();
            charSequence = charSequence.subSequence(1, charSequence.length());
        }
        this.appendable.openPreFormatted(true).append(charSequence).closePreFormatted();
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

    @Override // com.vladsch.flexmark.util.html.HtmlAppendable
    @NotNull
    public T setAttributes(@NotNull Attributes attributes) {
        this.currentAttributes = attributes.toMutable();
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

    @Override // com.vladsch.flexmark.util.html.HtmlAppendable
    @NotNull
    public T tagIndent(@NotNull CharSequence charSequence, @NotNull Runnable runnable) {
        tag(charSequence, true, false, runnable);
        return this;
    }

    @Override // com.vladsch.flexmark.util.html.HtmlAppendable
    @NotNull
    public T tagLineIndent(@NotNull CharSequence charSequence, @NotNull Runnable runnable) {
        tag(charSequence, true, true, runnable);
        return this;
    }

    @Override // com.vladsch.flexmark.util.html.HtmlAppendable
    @NotNull
    public T tagVoid(@NotNull CharSequence charSequence) {
        return (T) tag(charSequence, true);
    }

    @Override // com.vladsch.flexmark.util.html.HtmlAppendable
    @NotNull
    public T tagVoidLine(@NotNull CharSequence charSequence) {
        lineIf(!this.suppressOpenTagLine).tagVoid(charSequence).lineIf(!this.suppressCloseTagLine);
        return this;
    }

    @Override // com.vladsch.flexmark.util.html.HtmlAppendable
    @NotNull
    public T text(@NotNull CharSequence charSequence) {
        this.appendable.append((CharSequence) Escaping.escapeHtml(charSequence, false));
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

    @Override // com.vladsch.flexmark.util.html.HtmlAppendable
    @NotNull
    public T withAttr() {
        this.withAttributes = true;
        return this;
    }

    @Override // com.vladsch.flexmark.util.html.HtmlAppendable
    @NotNull
    public T withCondIndent() {
        this.indentOnFirstEol = true;
        return this;
    }

    @Override // com.vladsch.flexmark.util.html.HtmlAppendable
    @NotNull
    public T withCondLineOnChildText() {
        this.lineOnChildText = true;
        return this;
    }

    public HtmlAppendableBase(@Nullable Appendable appendable, int i, int i2) {
        this.indentOnFirstEol = false;
        this.lineOnChildText = false;
        this.withAttributes = false;
        this.suppressOpenTagLine = false;
        this.suppressCloseTagLine = false;
        this.openTags = new Stack<>();
        LineAppendableImpl lineAppendableImpl = new LineAppendableImpl(appendable, i2);
        this.appendable = lineAppendableImpl;
        lineAppendableImpl.setIndentPrefix(RepeatedSequence.repeatOf(" ", i).toString());
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

    @Override // com.vladsch.flexmark.util.html.HtmlAppendable
    @NotNull
    public T raw(@NotNull CharSequence charSequence) {
        this.appendable.append(charSequence);
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

    @Override // com.vladsch.flexmark.util.html.HtmlAppendable
    @NotNull
    public T attr(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2) {
        if (this.currentAttributes == null) {
            this.currentAttributes = new MutableAttributes();
        }
        this.currentAttributes.addValue(charSequence, charSequence2);
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

    @Override // com.vladsch.flexmark.util.html.HtmlAppendable
    @NotNull
    public T raw(@NotNull CharSequence charSequence, int i) {
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                return this;
            }
            this.appendable.append(charSequence);
            i = i2;
        }
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public T setPrefix(@Nullable CharSequence charSequence, boolean z) {
        this.appendable.setPrefix(charSequence, z);
        return this;
    }

    @Override // com.vladsch.flexmark.util.html.HtmlAppendable
    @NotNull
    public T tagLine(@NotNull CharSequence charSequence) {
        lineIf(!this.suppressOpenTagLine).tag(charSequence).lineIf(!this.suppressCloseTagLine);
        return this;
    }

    @Override // com.vladsch.flexmark.util.html.HtmlAppendable
    @NotNull
    public T tag(@NotNull CharSequence charSequence) {
        return (T) tag(charSequence, false);
    }

    @Override // com.vladsch.flexmark.util.html.HtmlAppendable
    @NotNull
    public T tagLine(@NotNull CharSequence charSequence, boolean z) {
        lineIf(!this.suppressOpenTagLine).tag(charSequence, z).lineIf(!this.suppressCloseTagLine);
        return this;
    }

    @Override // com.vladsch.flexmark.util.html.HtmlAppendable
    @NotNull
    public T tag(@NotNull CharSequence charSequence, @NotNull Runnable runnable) {
        return (T) tag(charSequence, false, false, runnable);
    }

    @Override // com.vladsch.flexmark.util.html.HtmlAppendable
    @NotNull
    public T tagLine(@NotNull CharSequence charSequence, @NotNull Runnable runnable) {
        lineIf(!this.suppressOpenTagLine).tag(charSequence, false, false, runnable).lineIf(!this.suppressCloseTagLine);
        return this;
    }

    @Override // com.vladsch.flexmark.util.html.HtmlAppendable
    @NotNull
    public T attr(@NotNull Attribute... attributeArr) {
        if (this.currentAttributes == null) {
            this.currentAttributes = new MutableAttributes();
        }
        for (Attribute attribute : attributeArr) {
            this.currentAttributes.addValue(attribute.getName(), attribute.getValue());
        }
        return this;
    }

    @Override // com.vladsch.flexmark.util.html.HtmlAppendable
    @NotNull
    public T tag(@NotNull CharSequence charSequence, boolean z) {
        if (charSequence.length() != 0 && charSequence.charAt(0) != '/') {
            MutableAttributes mutableAttributes = null;
            if (this.withAttributes) {
                MutableAttributes mutableAttributes2 = this.currentAttributes;
                this.currentAttributes = null;
                this.withAttributes = false;
                mutableAttributes = mutableAttributes2;
            }
            this.appendable.append((CharSequence) "<");
            this.appendable.append(charSequence);
            if (mutableAttributes != null && !mutableAttributes.isEmpty()) {
                for (Attribute attribute : mutableAttributes.values()) {
                    String value = attribute.getValue();
                    if (!attribute.isNonRendering()) {
                        this.appendable.append((CharSequence) " ");
                        this.appendable.append((CharSequence) Escaping.escapeHtml(attribute.getName(), true));
                        this.appendable.append((CharSequence) "=\"");
                        this.appendable.append((CharSequence) Escaping.escapeHtml(value, true));
                        this.appendable.append((CharSequence) "\"");
                    }
                }
            }
            if (z) {
                this.appendable.append((CharSequence) " />");
                return this;
            }
            this.appendable.append((CharSequence) ">");
            tagOpened(charSequence);
            return this;
        }
        return (T) closeTag(charSequence);
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

    @Override // com.vladsch.flexmark.util.html.HtmlAppendable
    @NotNull
    public T attr(@NotNull Attributes attributes) {
        if (!attributes.isEmpty()) {
            MutableAttributes mutableAttributes = this.currentAttributes;
            if (mutableAttributes == null) {
                this.currentAttributes = new MutableAttributes(attributes);
                return this;
            }
            mutableAttributes.addValues(attributes);
        }
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

    @Override // com.vladsch.flexmark.util.html.HtmlAppendable
    @NotNull
    public T tag(@NotNull CharSequence charSequence, boolean z, boolean z2, @NotNull Runnable runnable) {
        boolean z3 = this.lineOnChildText;
        boolean z4 = this.indentOnFirstEol;
        this.lineOnChildText = false;
        this.indentOnFirstEol = false;
        if (z && !this.suppressOpenTagLine) {
            this.appendable.line();
        }
        tag(charSequence, false);
        if (z && !z4) {
            this.appendable.indent();
        }
        if ((this.appendable.getOptions() & LineAppendable.F_PASS_THROUGH) != 0) {
            runnable.run();
        } else {
            boolean[] zArr = {false};
            RunnableC8551a runnableC8551a = new RunnableC8551a(zArr, 1);
            if (z3) {
                this.appendable.setLineOnFirstText();
            }
            if (z4) {
                this.appendable.addIndentOnFirstEOL(runnableC8551a);
            }
            runnable.run();
            if (z3) {
                this.appendable.clearLineOnFirstText();
            }
            if (zArr[0]) {
                this.appendable.unIndentNoEol();
            } else {
                this.appendable.removeIndentOnFirstEOL(runnableC8551a);
            }
        }
        if (z && !z4) {
            this.appendable.unIndent();
        }
        if (z2 && !this.suppressCloseTagLine) {
            this.appendable.line();
        }
        closeTag(charSequence);
        if (z && !this.suppressCloseTagLine) {
            this.appendable.line();
        }
        return this;
    }
}
