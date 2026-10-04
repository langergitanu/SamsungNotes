package com.vladsch.flexmark.util.sequence;

import com.vladsch.flexmark.util.misc.BitFieldSet;
import com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder;
import java.io.IOException;
import java.util.Iterator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface LineAppendable extends Appendable, Iterable<LineInfo> {

    @Deprecated
    public static final int ALLOW_LEADING_EOL = 0;

    @Deprecated
    public static final int ALLOW_LEADING_WHITESPACE = 0;

    @Deprecated
    public static final int COLLAPSE_WHITESPACE;

    @Deprecated
    public static final int CONVERT_TABS;

    @Deprecated
    public static final int FORMAT_ALL;
    public static final int F_COLLAPSE_WHITESPACE;
    public static final int F_CONVERT_TABS;
    public static final int F_FORMAT_ALL;
    public static final int F_PASS_THROUGH;
    public static final int F_PREFIX_PRE_FORMATTED;
    public static final int F_TRIM_LEADING_EOL;
    public static final int F_TRIM_LEADING_WHITESPACE;
    public static final int F_TRIM_TRAILING_WHITESPACE;
    public static final int F_WHITESPACE_REMOVAL;
    public static final Options O_COLLAPSE_WHITESPACE;
    public static final Options O_CONVERT_TABS;
    public static final BitFieldSet<Options> O_FORMAT_ALL;
    public static final Options O_PASS_THROUGH;
    public static final Options O_PREFIX_PRE_FORMATTED;
    public static final Options O_TRIM_LEADING_EOL;
    public static final Options O_TRIM_LEADING_WHITESPACE;
    public static final Options O_TRIM_TRAILING_WHITESPACE;

    @Deprecated
    public static final int PASS_THROUGH;

    @Deprecated
    public static final int PREFIX_PRE_FORMATTED;

    @Deprecated
    public static final int TRIM_LEADING_WHITESPACE;

    @Deprecated
    public static final int TRIM_TRAILING_WHITESPACE;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum Options {
        CONVERT_TABS,
        COLLAPSE_WHITESPACE,
        TRIM_TRAILING_WHITESPACE,
        PASS_THROUGH,
        TRIM_LEADING_WHITESPACE,
        TRIM_LEADING_EOL,
        PREFIX_PRE_FORMATTED
    }

    static {
        Options options = Options.CONVERT_TABS;
        O_CONVERT_TABS = options;
        Options options2 = Options.COLLAPSE_WHITESPACE;
        O_COLLAPSE_WHITESPACE = options2;
        Options options3 = Options.TRIM_TRAILING_WHITESPACE;
        O_TRIM_TRAILING_WHITESPACE = options3;
        Options options4 = Options.PASS_THROUGH;
        O_PASS_THROUGH = options4;
        Options options5 = Options.TRIM_LEADING_WHITESPACE;
        O_TRIM_LEADING_WHITESPACE = options5;
        Options options6 = Options.TRIM_LEADING_EOL;
        O_TRIM_LEADING_EOL = options6;
        Options options7 = Options.PREFIX_PRE_FORMATTED;
        O_PREFIX_PRE_FORMATTED = options7;
        O_FORMAT_ALL = BitFieldSet.m13388of(options, options2, options3, options5);
        int iIntMask = BitFieldSet.intMask(options);
        F_CONVERT_TABS = iIntMask;
        int iIntMask2 = BitFieldSet.intMask(options2);
        F_COLLAPSE_WHITESPACE = iIntMask2;
        int iIntMask3 = BitFieldSet.intMask(options3);
        F_TRIM_TRAILING_WHITESPACE = iIntMask3;
        int iIntMask4 = BitFieldSet.intMask(options4);
        F_PASS_THROUGH = iIntMask4;
        int iIntMask5 = BitFieldSet.intMask(options5);
        F_TRIM_LEADING_WHITESPACE = iIntMask5;
        int iIntMask6 = BitFieldSet.intMask(options6);
        F_TRIM_LEADING_EOL = iIntMask6;
        int iIntMask7 = BitFieldSet.intMask(options7);
        F_PREFIX_PRE_FORMATTED = iIntMask7;
        int i = iIntMask6 | iIntMask | iIntMask2 | iIntMask3 | iIntMask5;
        F_FORMAT_ALL = i;
        F_WHITESPACE_REMOVAL = iIntMask2 | iIntMask3 | iIntMask5;
        CONVERT_TABS = iIntMask;
        COLLAPSE_WHITESPACE = iIntMask2;
        TRIM_TRAILING_WHITESPACE = iIntMask3;
        PASS_THROUGH = iIntMask4;
        TRIM_LEADING_WHITESPACE = iIntMask5;
        PREFIX_PRE_FORMATTED = iIntMask7;
        FORMAT_ALL = i;
    }

    static CharSequence combinedPrefix(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2) {
        if (charSequence == null || charSequence.length() <= 0 || charSequence2 == null || charSequence2.length() <= 0) {
            return (charSequence == null || charSequence.length() <= 0) ? (charSequence2 == null || charSequence2.length() <= 0) ? BasedSequence.NULL : charSequence2 : charSequence;
        }
        return String.valueOf(charSequence) + ((Object) charSequence2);
    }

    static BitFieldSet<Options> toOptionSet(int i) {
        return BitFieldSet.m13383of(Options.class, i);
    }

    @NotNull
    LineAppendable addIndentOnFirstEOL(@NotNull Runnable runnable);

    @NotNull
    default LineAppendable addOptions(int i) {
        return changeOptions(i, 0);
    }

    @NotNull
    default LineAppendable addPrefix(@NotNull CharSequence charSequence) {
        return addPrefix(charSequence, getPendingEOL() == 0);
    }

    @NotNull
    LineAppendable addPrefix(@NotNull CharSequence charSequence, boolean z);

    @Override // java.lang.Appendable
    @NotNull
    LineAppendable append(char c);

    @NotNull
    LineAppendable append(char c, int i);

    @NotNull
    LineAppendable append(@NotNull LineAppendable lineAppendable, int i, int i2, boolean z);

    @Override // java.lang.Appendable
    @NotNull
    LineAppendable append(@NotNull CharSequence charSequence);

    @Override // java.lang.Appendable
    @NotNull
    LineAppendable append(@NotNull CharSequence charSequence, int i, int i2);

    @NotNull
    default LineAppendable appendAll(@NotNull Iterable<CharSequence> iterable) {
        Iterator<CharSequence> it = iterable.iterator();
        while (it.hasNext()) {
            append(it.next());
        }
        return this;
    }

    @Deprecated
    default <T extends Appendable> T appendTo(@NotNull T t, int i) {
        return (T) appendTo(t, Integer.MAX_VALUE, i);
    }

    <T extends Appendable> T appendTo(@NotNull T t, boolean z, int i, int i2, int i4, int i5);

    default <T extends Appendable> T appendToSilently(@NotNull T t, boolean z, int i, int i2, int i4, int i5) {
        try {
            appendTo(t, z, i, i2, i4, i5);
        } catch (IOException unused) {
        }
        return t;
    }

    @NotNull
    LineAppendable blankLine();

    @NotNull
    LineAppendable blankLine(int i);

    @NotNull
    LineAppendable blankLineIf(boolean z);

    @NotNull
    LineAppendable changeOptions(int i, int i2);

    @NotNull
    default LineAppendable clearLineOnFirstText() {
        return lineOnFirstText(false);
    }

    @NotNull
    LineAppendable closePreFormatted();

    int column();

    @NotNull
    default LineAppendable copyAppendable(int i, int i2, boolean z) {
        return getEmptyAppendable().append(this, i, i2, z);
    }

    boolean endsWithEOL();

    @NotNull
    default LineInfo get(int i) {
        return getLineInfo(i);
    }

    int getAfterEolPrefixDelta();

    @NotNull
    BasedSequence getBeforeEolPrefix();

    @NotNull
    ISequenceBuilder<?, ?> getBuilder();

    @NotNull
    LineAppendable getEmptyAppendable();

    @NotNull
    BasedSequence getIndentPrefix();

    @NotNull
    BasedSequence getLine(int i);

    @NotNull
    default BasedSequence getLineContent(int i) {
        LineInfo lineInfo = getLineInfo(i);
        BasedSequence line = getLine(i);
        int i2 = lineInfo.prefixLength;
        return line.subSequence(i2, lineInfo.textLength + i2);
    }

    int getLineCount();

    int getLineCountWithPending();

    @NotNull
    LineInfo getLineInfo(int i);

    @NotNull
    default BasedSequence getLinePrefix(int i) {
        return getLine(i).subSequence(0, getLineInfo(i).prefixLength);
    }

    @NotNull
    default Iterable<BasedSequence> getLines(int i) {
        return getLines(i, 0, Integer.MAX_VALUE, true);
    }

    @NotNull
    Iterable<BasedSequence> getLines(int i, int i2, int i4, boolean z);

    @NotNull
    default Iterable<LineInfo> getLinesInfo(int i) {
        return getLinesInfo(i, 0, Integer.MAX_VALUE);
    }

    @NotNull
    Iterable<LineInfo> getLinesInfo(int i, int i2, int i4);

    @NotNull
    BitFieldSet<Options> getOptionSet();

    default int getOptions() {
        return getOptionSet().toInt();
    }

    int getPendingEOL();

    int getPendingSpace();

    @NotNull
    BasedSequence getPrefix();

    default int getTrailingBlankLines() {
        return getTrailingBlankLines(getLineCountWithPending());
    }

    int getTrailingBlankLines(int i);

    @NotNull
    LineAppendable indent();

    void insertLine(int i, @NotNull CharSequence charSequence, @NotNull CharSequence charSequence2);

    default boolean isEmpty() {
        return getLineCountWithPending() == 0;
    }

    default boolean isNotEmpty() {
        return getLineCountWithPending() != 0;
    }

    boolean isPendingSpace();

    boolean isPreFormatted();

    @NotNull
    Iterator<LineInfo> iterator();

    @NotNull
    LineAppendable line();

    @NotNull
    LineAppendable lineIf(boolean z);

    @NotNull
    LineAppendable lineOnFirstText(boolean z);

    @NotNull
    LineAppendable lineWithTrailingSpaces(int i);

    @NotNull
    default LineAppendable noPreserveSpaces() {
        return changeOptions(F_TRIM_LEADING_WHITESPACE | F_COLLAPSE_WHITESPACE, 0);
    }

    @NotNull
    default LineAppendable noTrimLeading() {
        return changeOptions(0, F_TRIM_LEADING_WHITESPACE);
    }

    int offset();

    int offsetWithPending();

    @NotNull
    LineAppendable openPreFormatted(boolean z);

    @NotNull
    LineAppendable popOptions();

    @NotNull
    default LineAppendable popPrefix() {
        return popPrefix(false);
    }

    @NotNull
    LineAppendable popPrefix(boolean z);

    @NotNull
    default LineAppendable preserveSpaces() {
        return changeOptions(0, F_TRIM_LEADING_WHITESPACE | F_COLLAPSE_WHITESPACE);
    }

    @NotNull
    LineAppendable pushOptions();

    @NotNull
    LineAppendable pushPrefix();

    default LineAppendable removeExtraBlankLines(int i, int i2) {
        return removeExtraBlankLines(i, i2, 0, Integer.MAX_VALUE);
    }

    LineAppendable removeExtraBlankLines(int i, int i2, int i4, int i5);

    @NotNull
    LineAppendable removeIndentOnFirstEOL(@NotNull Runnable runnable);

    @NotNull
    LineAppendable removeLines(int i, int i2);

    @NotNull
    default LineAppendable removeOptions(int i) {
        return changeOptions(0, i);
    }

    @NotNull
    LineAppendable setIndentPrefix(@Nullable CharSequence charSequence);

    void setLine(int i, @NotNull CharSequence charSequence, @NotNull CharSequence charSequence2);

    @NotNull
    default LineAppendable setLineOnFirstText() {
        return lineOnFirstText(true);
    }

    @NotNull
    default LineAppendable setOptions(int i) {
        return setOptions(toOptionSet(i));
    }

    @NotNull
    default LineAppendable setPrefix(@NotNull CharSequence charSequence) {
        return setPrefix(charSequence, getPendingEOL() == 0);
    }

    @NotNull
    LineAppendable setPrefix(@Nullable CharSequence charSequence, boolean z);

    void setPrefixLength(int i, int i2);

    @NotNull
    default CharSequence toSequence(int i, int i2) {
        return toSequence(i, i2, true);
    }

    @NotNull
    CharSequence toSequence(int i, int i2, boolean z);

    @NotNull
    default String toString(int i, int i2) {
        return toString(i, i2, true);
    }

    @NotNull
    String toString(int i, int i2, boolean z);

    @NotNull
    default LineAppendable trimLeading() {
        return changeOptions(F_TRIM_LEADING_WHITESPACE, 0);
    }

    @NotNull
    LineAppendable unIndent();

    @NotNull
    LineAppendable unIndentNoEol();

    static BitFieldSet<Options> toOptionSet(Options... optionsArr) {
        return BitFieldSet.m13384of(Options.class, (Enum[]) optionsArr);
    }

    default <T extends Appendable> T appendTo(@NotNull T t, int i, int i2, int i4, int i5) {
        return (T) appendTo(t, true, i, i2, i4, i5);
    }

    default <T extends Appendable> T appendToSilently(@NotNull T t, int i, int i2, int i4, int i5) {
        appendToSilently(t, true, i, i2, i4, i5);
        return t;
    }

    @NotNull
    default LineAppendable copyAppendable(int i, int i2) {
        return getEmptyAppendable().append(this, i, i2, false);
    }

    @NotNull
    default Iterable<BasedSequence> getLines() {
        return getLines(Integer.MAX_VALUE, 0, Integer.MAX_VALUE, true);
    }

    @NotNull
    default Iterable<LineInfo> getLinesInfo() {
        return getLinesInfo(Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
    }

    @NotNull
    default LineAppendable setOptions(Options... optionsArr) {
        return setOptions(toOptionSet(optionsArr).toInt());
    }

    @NotNull
    default CharSequence toSequence(int i, boolean z) {
        return toSequence(i, i, z);
    }

    @NotNull
    default String toString(int i, boolean z) {
        return toString(i, i, z);
    }

    default <T extends Appendable> T appendTo(@NotNull T t, int i, int i2) {
        return (T) appendTo(t, i, i2, 0, Integer.MAX_VALUE);
    }

    default <T extends Appendable> T appendToSilently(@NotNull T t, int i, int i2) {
        appendToSilently(t, i, i2, 0, Integer.MAX_VALUE);
        return t;
    }

    @NotNull
    default LineAppendable copyAppendable(int i) {
        return getEmptyAppendable().append(this, i, Integer.MAX_VALUE, false);
    }

    @NotNull
    default Iterable<BasedSequence> getLines(int i, boolean z) {
        return getLines(i, 0, Integer.MAX_VALUE, z);
    }

    @NotNull
    default LineAppendable setOptions(BitFieldSet<Options> bitFieldSet) {
        return setOptions(bitFieldSet.toInt());
    }

    @NotNull
    default CharSequence toSequence(boolean z) {
        return toSequence(Integer.MAX_VALUE, Integer.MAX_VALUE, z);
    }

    @NotNull
    default String toString(boolean z) {
        return toString(Integer.MAX_VALUE, Integer.MAX_VALUE, z);
    }

    @NotNull
    default LineAppendable append(@NotNull LineAppendable lineAppendable) {
        return append(lineAppendable, 0, Integer.MAX_VALUE, true);
    }

    default <T extends Appendable> T appendTo(@NotNull T t) {
        return (T) appendTo(t, 0, 0, 0, Integer.MAX_VALUE);
    }

    default <T extends Appendable> T appendToSilently(@NotNull T t) {
        return (T) appendToSilently(t, 0, 0, 0, Integer.MAX_VALUE);
    }

    @NotNull
    default LineAppendable copyAppendable() {
        return getEmptyAppendable().append(this, 0, Integer.MAX_VALUE, false);
    }

    @NotNull
    default Iterable<BasedSequence> getLines(boolean z) {
        return getLines(Integer.MAX_VALUE, 0, Integer.MAX_VALUE, z);
    }

    @NotNull
    default CharSequence toSequence() {
        return toSequence(Integer.MAX_VALUE, Integer.MAX_VALUE, true);
    }

    @NotNull
    default String toString(int i) {
        return toString(i, i, true);
    }

    @NotNull
    default LineAppendable append(@NotNull LineAppendable lineAppendable, boolean z) {
        return append(lineAppendable, 0, Integer.MAX_VALUE, z);
    }

    @NotNull
    default LineAppendable copyAppendable(boolean z) {
        return getEmptyAppendable().append(this, 0, Integer.MAX_VALUE, z);
    }
}
