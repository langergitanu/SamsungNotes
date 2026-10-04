package com.vladsch.flexmark.util.format;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p148nt.model.collector.common.C11419a;
import com.vladsch.flexmark.util.data.DataHolder;
import com.vladsch.flexmark.util.data.SharedDataKeys;
import com.vladsch.flexmark.util.misc.CharPredicate;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import com.vladsch.flexmark.util.sequence.Range;
import com.vladsch.flexmark.util.sequence.RepeatedSequence;
import com.vladsch.flexmark.util.sequence.SequenceUtils;
import com.vladsch.flexmark.util.sequence.builder.SequenceBuilder;
import com.vladsch.flexmark.util.sequence.builder.tree.BasedOffsetTracker;
import com.vladsch.flexmark.util.sequence.mappers.SpecialLeadInHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class MarkdownParagraph {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final List<SpecialLeadInHandler> EMPTY_LEAD_IN_HANDLERS;
    public static final List<TrackedOffset> EMPTY_OFFSET_LIST;
    private static final char MARKDOWN_START_LINE_CHAR = 8232;

    @NotNull
    final BasedSequence altSeq;

    @NotNull
    final BasedSequence baseSeq;

    @NotNull
    final CharWidthProvider charWidthProvider;
    boolean escapeSpecialLeadInChars;
    private BasedSequence firstIndent;
    private int firstWidthOffset;
    private BasedSequence indent;
    boolean keepHardLineBreaks;
    boolean keepSoftLineBreaks;

    @NotNull
    List<? extends SpecialLeadInHandler> leadInHandlers;

    @Nullable
    DataHolder options;
    boolean restoreTrackedSpaces;
    private List<TrackedOffset> trackedOffsets;
    private boolean trackedOffsetsSorted;
    boolean unEscapeSpecialLeadInChars;
    int width;

    /* JADX INFO: renamed from: com.vladsch.flexmark.util.format.MarkdownParagraph$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C118511 {

        /* JADX INFO: renamed from: $SwitchMap$com$vladsch$flexmark$util$format$MarkdownParagraph$TextType */
        static final /* synthetic */ int[] f8370xac163d4d;

        static {
            int[] iArr = new int[TextType.values().length];
            f8370xac163d4d = iArr;
            try {
                iArr[TextType.SPACE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8370xac163d4d[TextType.WORD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8370xac163d4d[TextType.MARKDOWN_START_LINE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8370xac163d4d[TextType.MARKDOWN_BREAK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f8370xac163d4d[TextType.BREAK.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class TextTokenizer {
        private final CharSequence chars;
        private final int maxIndex;
        private int index = 0;
        private int lastPos = 0;
        private boolean isInWord = false;
        private boolean isFirstNonBlank = true;
        private int lastConsecutiveSpaces = 0;

        @Nullable
        private Token token = null;

        public TextTokenizer(@NotNull CharSequence charSequence) {
            this.chars = charSequence;
            this.maxIndex = charSequence.length();
            reset();
        }

        @NotNull
        public List<Token> asList() {
            ArrayList arrayList = new ArrayList();
            reset();
            while (true) {
                Token token = this.token;
                if (token == null) {
                    return arrayList;
                }
                arrayList.add(token);
                next();
            }
        }

        @Nullable
        public Token getToken() {
            return this.token;
        }

        public void next() {
            this.token = null;
            while (true) {
                int i = this.index;
                if (i >= this.maxIndex) {
                    break;
                }
                char cCharAt = this.chars.charAt(i);
                if (this.isInWord) {
                    if (cCharAt == ' ' || cCharAt == '\t' || cCharAt == '\n' || cCharAt == 8232) {
                        this.isInWord = false;
                        boolean z = this.isFirstNonBlank;
                        this.isFirstNonBlank = false;
                        int i2 = this.lastPos;
                        int i4 = this.index;
                        if (i2 < i4) {
                            this.token = Token.m13341of(TextType.WORD, i2, i4, z);
                            this.lastPos = this.index;
                            break;
                        }
                    } else {
                        this.index++;
                    }
                } else if (cCharAt != ' ' && cCharAt != '\t' && cCharAt != '\n' && cCharAt != 8232) {
                    int i5 = this.lastPos;
                    int i6 = this.index;
                    if (i5 < i6) {
                        this.token = Token.m13340of(TextType.SPACE, i5, i6);
                        this.lastPos = this.index;
                        this.isInWord = true;
                        this.lastConsecutiveSpaces = 0;
                        break;
                    }
                    this.isInWord = true;
                    this.lastConsecutiveSpaces = 0;
                } else if (cCharAt == '\n') {
                    int i7 = this.lastConsecutiveSpaces;
                    if (i7 >= 2) {
                        TextType textType = TextType.MARKDOWN_BREAK;
                        int i8 = this.index;
                        this.token = Token.m13340of(textType, i8 - i7, i8 + 1);
                    } else {
                        TextType textType2 = TextType.BREAK;
                        int i9 = this.index;
                        this.token = Token.m13340of(textType2, i9, i9 + 1);
                    }
                    int i10 = this.index;
                    this.lastPos = i10 + 1;
                    this.lastConsecutiveSpaces = 0;
                    this.isFirstNonBlank = true;
                    this.index = i10 + 1;
                } else {
                    if (cCharAt == 8232) {
                        TextType textType3 = TextType.MARKDOWN_START_LINE;
                        int i11 = this.index;
                        this.token = Token.m13340of(textType3, i11, i11 + 1);
                        int i12 = this.index;
                        this.lastPos = i12 + 1;
                        this.lastConsecutiveSpaces = 0;
                        this.index = i12 + 1;
                        break;
                    }
                    if (cCharAt == ' ') {
                        this.lastConsecutiveSpaces++;
                    } else {
                        this.lastConsecutiveSpaces = 0;
                    }
                    this.index++;
                }
            }
            int i13 = this.lastPos;
            int i14 = this.index;
            if (i13 < i14) {
                if (this.isInWord) {
                    this.token = Token.m13341of(TextType.WORD, i13, i14, this.isFirstNonBlank);
                    this.isFirstNonBlank = false;
                } else {
                    this.token = Token.m13340of(TextType.SPACE, i13, i14);
                }
                this.lastPos = this.index;
            }
        }

        public void reset() {
            this.index = 0;
            this.lastPos = 0;
            this.isInWord = false;
            this.token = null;
            this.lastConsecutiveSpaces = 0;
            this.isFirstNonBlank = true;
            next();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum TextType {
        WORD,
        SPACE,
        BREAK,
        MARKDOWN_BREAK,
        MARKDOWN_START_LINE
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Token {
        public final boolean isFirstWord;

        @NotNull
        public final Range range;

        @NotNull
        public final TextType type;

        private Token(@NotNull TextType textType, @NotNull Range range, boolean z) {
            this.type = textType;
            this.range = range;
            this.isFirstWord = z;
        }

        @NotNull
        /* JADX INFO: renamed from: of */
        public static Token m13342of(@NotNull TextType textType, @NotNull Range range) {
            return new Token(textType, range, false);
        }

        public BasedSequence subSequence(BasedSequence basedSequence) {
            return this.range.basedSubSequence(basedSequence);
        }

        public String toString() {
            return "token: " + this.type + " " + this.range + (this.isFirstWord ? " isFirst" : "");
        }

        @NotNull
        /* JADX INFO: renamed from: of */
        public static Token m13340of(@NotNull TextType textType, int i, int i2) {
            return new Token(textType, Range.m13451of(i, i2), false);
        }

        public CharSequence subSequence(CharSequence charSequence) {
            return this.range.charSubSequence(charSequence);
        }

        @NotNull
        /* JADX INFO: renamed from: of */
        public static Token m13343of(@NotNull TextType textType, @NotNull Range range, boolean z) {
            return new Token(textType, range, z);
        }

        @NotNull
        /* JADX INFO: renamed from: of */
        public static Token m13341of(@NotNull TextType textType, int i, int i2, boolean z) {
            return new Token(textType, Range.m13451of(i, i2), z);
        }
    }

    static {
        List list = Collections.EMPTY_LIST;
        EMPTY_LEAD_IN_HANDLERS = list;
        EMPTY_OFFSET_LIST = list;
    }

    public MarkdownParagraph(CharSequence charSequence) {
        this(BasedSequence.m13437of(charSequence));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$addTrackedOffset$0(TrackedOffset trackedOffset, TrackedOffset trackedOffset2) {
        return trackedOffset2.getOffset() == trackedOffset.getOffset();
    }

    private List<TrackedOffset> sortedTrackedOffsets() {
        if (!this.trackedOffsetsSorted) {
            this.trackedOffsets.sort(Comparator.comparing(new C11419a(14)));
            this.trackedOffsetsSorted = true;
        }
        return this.trackedOffsets;
    }

    public void addTrackedOffset(@NotNull final TrackedOffset trackedOffset) {
        if (this.trackedOffsets == EMPTY_OFFSET_LIST) {
            this.trackedOffsets = new ArrayList();
        }
        this.trackedOffsets.removeIf(new Predicate() { // from class: com.vladsch.flexmark.util.format.a
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return MarkdownParagraph.lambda$addTrackedOffset$0(trackedOffset, (TrackedOffset) obj);
            }
        });
        this.trackedOffsets.add(trackedOffset);
        this.trackedOffsetsSorted = false;
    }

    @NotNull
    public CharWidthProvider getCharWidthProvider() {
        return this.charWidthProvider;
    }

    @NotNull
    public BasedSequence getChars() {
        return this.baseSeq;
    }

    @NotNull
    public Range getContinuationStartSplice(int i, boolean z, boolean z2) {
        BasedSequence baseSequence = this.altSeq.getBaseSequence();
        if (z && z2) {
            BasedOffsetTracker basedOffsetTrackerCreate = BasedOffsetTracker.create(this.altSeq);
            int iStartOfLine = baseSequence.startOfLine(i);
            if (iStartOfLine > this.altSeq.getStartOffset() && !baseSequence.isCharAt(i, CharPredicate.SPACE_TAB_NBSP_LINE_SEP)) {
                CharPredicate charPredicate = CharPredicate.SPACE_TAB_NBSP_EOL;
                if (baseSequence.lastIndexOfAnyNot(charPredicate, i - 1) < iStartOfLine) {
                    int i2 = basedOffsetTrackerCreate.getOffsetInfo(i, true).endIndex;
                    return Range.m13451of(this.altSeq.lastIndexOfAnyNot(charPredicate, i2 - 1) + 1, i2);
                }
            }
        }
        return Range.NULL;
    }

    public CharSequence getFirstIndent() {
        return this.firstIndent;
    }

    public int getFirstWidth() {
        int i = this.width;
        if (i == 0) {
            return 0;
        }
        return Math.max(0, i + this.firstWidthOffset);
    }

    public int getFirstWidthOffset() {
        return this.firstWidthOffset;
    }

    public CharSequence getIndent() {
        return this.indent;
    }

    public boolean getKeepHardBreaks() {
        return this.keepHardLineBreaks;
    }

    public boolean getKeepSoftBreaks() {
        return this.keepSoftLineBreaks;
    }

    @NotNull
    public List<? extends SpecialLeadInHandler> getLeadInHandlers() {
        return this.leadInHandlers;
    }

    @Nullable
    public DataHolder getOptions() {
        return this.options;
    }

    @Nullable
    public TrackedOffset getTrackedOffset(int i) {
        sortedTrackedOffsets();
        for (TrackedOffset trackedOffset : this.trackedOffsets) {
            if (trackedOffset.getOffset() == i) {
                return trackedOffset;
            }
            if (trackedOffset.getOffset() > i) {
                return null;
            }
        }
        return null;
    }

    public List<TrackedOffset> getTrackedOffsets() {
        return sortedTrackedOffsets();
    }

    public int getWidth() {
        return this.width;
    }

    public boolean isEscapeSpecialLeadIn() {
        return this.escapeSpecialLeadInChars;
    }

    public boolean isRestoreTrackedSpaces() {
        return this.restoreTrackedSpaces;
    }

    public boolean isUnEscapeSpecialLeadIn() {
        return this.unEscapeSpecialLeadInChars;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0035  */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BasedSequence resolveTrackedOffsets(@NotNull BasedSequence basedSequence, @NotNull BasedSequence basedSequence2) {
        BasedOffsetTracker basedOffsetTrackerCreate = BasedOffsetTracker.create(basedSequence2);
        int size = this.trackedOffsets.size();
        while (true) {
            int i = size - 1;
            if (size <= 0) {
                return basedSequence2;
            }
            TrackedOffset trackedOffset = this.trackedOffsets.get(i);
            int offset = trackedOffset.getOffset();
            CharPredicate charPredicate = CharPredicate.WHITESPACE_NBSP;
            boolean zIsBaseCharAt = basedSequence.isBaseCharAt(offset, charPredicate);
            if (zIsBaseCharAt) {
                int i2 = offset - 1;
                if (!basedSequence.isBaseCharAt(i2, charPredicate)) {
                    trackedOffset.setIndex(basedOffsetTrackerCreate.getOffsetInfo(i2, false).endIndex);
                } else if (zIsBaseCharAt || !basedSequence.isBaseCharAt(offset + 1, charPredicate)) {
                    trackedOffset.setIndex(basedOffsetTrackerCreate.getOffsetInfo(offset, true).endIndex);
                } else {
                    trackedOffset.setIndex(basedOffsetTrackerCreate.getOffsetInfo(offset, false).startIndex);
                }
            }
            size = i;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x03f6  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0406  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x043d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0333 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0348  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0362  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0365  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0379  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0386  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x03b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BasedSequence resolveTrackedOffsetsEdit(BasedSequence basedSequence, BasedSequence basedSequence2, BasedSequence basedSequence3) {
        int i;
        int i2;
        String str;
        boolean z;
        int i4;
        boolean z2;
        TrackedOffset trackedOffset;
        BasedOffsetTracker basedOffsetTracker;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int iEolEndLength;
        int i11;
        int iMax;
        CharPredicate charPredicate;
        int i12;
        MarkdownParagraph markdownParagraph;
        int i13;
        MarkdownParagraph markdownParagraph2 = this;
        Boolean bool = SharedDataKeys.RUNNING_TESTS.get(markdownParagraph2.options);
        BasedSequence basedSequenceM13437of = BasedSequence.m13437of(basedSequence.toString());
        BasedSequence sequence = basedSequenceM13437of.getBuilder().append((CharSequence) markdownParagraph2.new LeftAlignedWrapping(basedSequenceM13437of).wrapText()).toSequence(basedSequence2, CharPredicate.LINE_SEP, CharPredicate.SPACE_TAB_EOL);
        BasedOffsetTracker basedOffsetTrackerCreate = BasedOffsetTracker.create(markdownParagraph2.altSeq);
        BasedOffsetTracker basedOffsetTrackerCreate2 = BasedOffsetTracker.create(sequence);
        int size = markdownParagraph2.trackedOffsets.size();
        BasedSequence baseSequence = markdownParagraph2.altSeq.getBaseSequence();
        BasedSequence basedSequence4 = markdownParagraph2.altSeq;
        BasedSequence basedSequenceInsert = basedSequence3;
        int i14 = size;
        int i15 = 0;
        while (true) {
            int i16 = i14 - 1;
            if (i14 <= 0) {
                int i17 = i15;
                return i17 > 0 ? basedSequenceInsert.appendSpaces(i17) : basedSequenceInsert;
            }
            TrackedOffset trackedOffset2 = markdownParagraph2.trackedOffsets.get(i16);
            int offset = trackedOffset2.getOffset();
            CharPredicate charPredicate2 = CharPredicate.SPACE_TAB_NBSP;
            int iCountTrailing = baseSequence.countTrailing(charPredicate2, offset);
            int iCountLeading = baseSequence.countLeading(charPredicate2, offset);
            Boolean bool2 = bool;
            CharPredicate charPredicate3 = CharPredicate.SPACE_TAB_NBSP_EOL;
            int iCountTrailing2 = baseSequence.countTrailing(charPredicate3, offset);
            int iCountLeading2 = baseSequence.countLeading(charPredicate3, offset);
            bool2.booleanValue();
            int i18 = i14;
            char cSafeCharAt = baseSequence.safeCharAt(offset);
            char cSafeCharAt2 = baseSequence.safeCharAt((offset - iCountTrailing) - 1);
            int iMax2 = i15;
            char cSafeCharAt3 = baseSequence.safeCharAt(offset + iCountLeading);
            if (bool2.booleanValue()) {
                System.out.println(trackedOffset2);
            }
            if (!charPredicate2.test(cSafeCharAt)) {
                int i19 = basedOffsetTrackerCreate.getOffsetInfo(offset, false).startIndex;
                if (basedSequence4.safeCharAt(i19 - 1) == 8232) {
                    str = "LSep ";
                    z = true;
                } else {
                    str = "";
                    z = false;
                }
                i2 = i19;
                i = offset;
            } else if (!charPredicate3.test(cSafeCharAt2)) {
                i = offset - iCountTrailing2;
                z = false;
                i2 = basedOffsetTrackerCreate.getOffsetInfo(i - 1, false).endIndex;
                str = "Prev ";
            } else {
                if (charPredicate3.test(cSafeCharAt3)) {
                    throw new IllegalStateException(String.format("Should not be here. altSeq: '%s'", basedSequence4));
                }
                i = offset + iCountLeading2;
                i2 = basedOffsetTrackerCreate.getOffsetInfo(i, false).startIndex;
                str = "Next ";
                z = false;
            }
            BasedOffsetTracker basedOffsetTracker2 = basedOffsetTrackerCreate;
            if (bool2.booleanValue()) {
                z2 = z;
                trackedOffset = trackedOffset2;
                i4 = size;
                System.out.println(str + "BaseSequence offset: `" + AbstractC0541b.m757C(baseSequence.safeSubSequence(offset - 10, offset).toVisibleWhitespaceString(), "|", baseSequence.safeSubSequence(offset, offset + 10).toVisibleWhitespaceString()) + "`");
                System.out.println(str + "BaseSequence anchor: `" + AbstractC0541b.m757C(baseSequence.safeSubSequence(i + (-10), i).toVisibleWhitespaceString(), "|", baseSequence.safeSubSequence(i, i + 10).toVisibleWhitespaceString()) + "`");
                System.out.println(str + "altUnwrapped anchor: `" + AbstractC0541b.m757C(basedSequence4.safeSubSequence(i2 + (-10), i2).toVisibleWhitespaceString(), "|", basedSequence4.safeSubSequence(i2, i2 + 10).toVisibleWhitespaceString()) + "`");
            } else {
                i4 = size;
                z2 = z;
                trackedOffset = trackedOffset2;
            }
            int i20 = basedOffsetTrackerCreate2.getOffsetInfo(i, false).startIndex;
            if (bool2.booleanValue()) {
                int i21 = i20 - 10;
                int i22 = i20 + 10;
                basedOffsetTracker = basedOffsetTrackerCreate2;
                System.out.println("altWrapped anchor: `" + AbstractC0541b.m757C(sequence.safeSubSequence(i21, i20).toVisibleWhitespaceString(), "|", sequence.safeSubSequence(i20, i22).toVisibleWhitespaceString()) + "`");
                System.out.println("wrapped anchor: `" + AbstractC0541b.m757C(basedSequenceInsert.safeSubSequence(i21, i20).toVisibleWhitespaceString(), "|", basedSequenceInsert.safeSubSequence(i20, i22).toVisibleWhitespaceString()) + "`");
            } else {
                basedOffsetTracker = basedOffsetTrackerCreate2;
            }
            CharPredicate charPredicate4 = CharPredicate.WHITESPACE_NBSP;
            int iCountLeading3 = -1;
            if (!charPredicate4.test(basedSequence4.safeCharAt(i2))) {
                if (basedSequence4.safeCharAt(i2) != 8232) {
                    i5 = 0;
                } else if (charPredicate4.test(basedSequence4.safeCharAt(i2 - 1))) {
                    i5 = 1;
                    z2 = true;
                }
                iCountLeading3 = 0;
                i6 = 0;
                i7 = 0;
                if (bool2.booleanValue()) {
                }
                basedSequence4.safeCharAt(i9 + i10 + iCountLeading3);
                basedSequenceInsert.safeCharAt(i8 + i6);
                if (z2) {
                }
                if (basedSequenceInsert.isCharAt(iEolEndLength - 1, CharPredicate.ANY_EOL)) {
                    iEolEndLength -= basedSequenceInsert.eolEndLength(iEolEndLength);
                }
                int iCountTrailing3 = basedSequenceInsert.countTrailing(charPredicate2, iEolEndLength);
                int iCountLeading4 = basedSequenceInsert.countLeading(charPredicate2, iEolEndLength);
                if (trackedOffset.isAfterSpaceEdit()) {
                }
                if (trackedOffset.isSpliced()) {
                }
                int iMax3 = Math.max(i7, iCountLeading - iCountLeading4);
                charPredicate = CharPredicate.ANY_EOL_NUL;
                if (basedSequenceInsert.isCharAt(iEolEndLength, charPredicate)) {
                }
                i12 = iMax + iMax3;
                if (i12 > 0) {
                }
                trackedOffset.setIndex(iEolEndLength);
                if (bool2.booleanValue()) {
                }
                i14 = i16;
                size = i13;
                markdownParagraph2 = markdownParagraph;
                bool = bool2;
                i15 = iMax2;
                basedOffsetTrackerCreate = basedOffsetTracker2;
                basedOffsetTrackerCreate2 = basedOffsetTracker;
            } else if (!CharPredicate.WHITESPACE_NBSP_OR_NUL.test(sequence.safeCharAt(i20))) {
                iCountLeading3 = basedSequence4.countLeading(charPredicate4, i2);
                i7 = 1;
                i5 = 0;
                i6 = 0;
                if (bool2.booleanValue()) {
                    int i23 = i2 + i5 + iCountLeading3;
                    i8 = i20;
                    i9 = i2;
                    i10 = i5;
                    System.out.println("adjusted altWrapped anchor: `" + AbstractC0541b.m757C(sequence.safeSubSequence(i23 - 10, i23).toVisibleWhitespaceString(), "|", sequence.safeSubSequence(i23, i23 + 10).toVisibleWhitespaceString()) + "`");
                    int i24 = i8 + i6;
                    System.out.println("adjusted wrapped anchor: `" + AbstractC0541b.m757C(basedSequenceInsert.safeSubSequence(i24 + (-10), i24).toVisibleWhitespaceString(), "|", basedSequenceInsert.safeSubSequence(i24, i24 + 10).toVisibleWhitespaceString()) + "`");
                } else {
                    i8 = i20;
                    i9 = i2;
                    i10 = i5;
                }
                basedSequence4.safeCharAt(i9 + i10 + iCountLeading3);
                basedSequenceInsert.safeCharAt(i8 + i6);
                if (z2) {
                    iEolEndLength = Math.max(0, i8 - 1);
                    if (bool2.booleanValue()) {
                        System.out.println("LSep Adj wrapped anchor: `" + AbstractC0541b.m757C(basedSequenceInsert.safeSubSequence(iEolEndLength - 10, iEolEndLength).toVisibleWhitespaceString(), "|", basedSequenceInsert.safeSubSequence(iEolEndLength, iEolEndLength + 10).toVisibleWhitespaceString()) + "`");
                    }
                } else {
                    iEolEndLength = i8;
                }
                if (basedSequenceInsert.isCharAt(iEolEndLength - 1, CharPredicate.ANY_EOL) && iCountLeading > 0) {
                    iEolEndLength -= basedSequenceInsert.eolEndLength(iEolEndLength);
                }
                int iCountTrailing32 = basedSequenceInsert.countTrailing(charPredicate2, iEolEndLength);
                int iCountLeading42 = basedSequenceInsert.countLeading(charPredicate2, iEolEndLength);
                if (trackedOffset.isAfterSpaceEdit()) {
                    if (trackedOffset.isAfterInsert()) {
                        iCountTrailing = Math.max(1, iCountTrailing);
                    } else if (trackedOffset.isAfterDelete()) {
                        iCountTrailing = 0;
                    }
                }
                if (trackedOffset.isSpliced()) {
                    iMax = 0;
                    i11 = 0;
                } else {
                    i11 = 0;
                    iMax = Math.max(0, iCountTrailing - iCountTrailing32);
                }
                int iMax32 = Math.max(i7, iCountLeading - iCountLeading42);
                charPredicate = CharPredicate.ANY_EOL_NUL;
                if (basedSequenceInsert.isCharAt(iEolEndLength, charPredicate)) {
                    if (trackedOffset.isAfterDelete()) {
                        iMax = Math.min(1, iMax);
                    }
                    iMax32 = i11;
                } else if (basedSequenceInsert.isCharAt(iEolEndLength - 1, charPredicate)) {
                    if (trackedOffset.isAfterDelete() && !trackedOffset.isAfterSpaceEdit()) {
                        iMax32 = Math.min(1, iMax32);
                    } else if (!trackedOffset.isAfterInsert() && !trackedOffset.isAfterDelete()) {
                        iMax32 = i11;
                    }
                    iMax = i11;
                } else {
                    iMax = Math.min(1, iMax);
                }
                i12 = iMax + iMax32;
                if (i12 > 0) {
                    if (iEolEndLength <= basedSequenceInsert.lastIndexOfAnyNot(charPredicate4)) {
                        basedSequenceInsert = basedSequenceInsert.insert(iEolEndLength, RepeatedSequence.ofSpaces(i12));
                        int i25 = i18;
                        i13 = i4;
                        while (true) {
                            markdownParagraph = this;
                            if (i25 >= i13) {
                                break;
                            }
                            TrackedOffset trackedOffset3 = markdownParagraph.trackedOffsets.get(i25);
                            trackedOffset3.setIndex(trackedOffset3.getIndex() + iMax + iMax32);
                            i25++;
                        }
                    } else {
                        markdownParagraph = this;
                        i13 = i4;
                        iMax2 = Math.max(iMax2, iMax);
                    }
                    iEolEndLength += iMax;
                } else {
                    markdownParagraph = this;
                    i13 = i4;
                }
                trackedOffset.setIndex(iEolEndLength);
                if (bool2.booleanValue()) {
                    System.out.println("Adj wrapped anchor: `" + AbstractC0541b.m757C(basedSequenceInsert.safeSubSequence(iEolEndLength - 20, iEolEndLength).toVisibleWhitespaceString(), "|", basedSequenceInsert.safeSubSequence(iEolEndLength, iEolEndLength + 20).toVisibleWhitespaceString()) + "`");
                    System.out.println();
                }
                i14 = i16;
                size = i13;
                markdownParagraph2 = markdownParagraph;
                bool = bool2;
                i15 = iMax2;
                basedOffsetTrackerCreate = basedOffsetTracker2;
                basedOffsetTrackerCreate2 = basedOffsetTracker;
            }
            i6 = -1;
            i5 = 0;
            i7 = 0;
            if (bool2.booleanValue()) {
            }
            basedSequence4.safeCharAt(i9 + i10 + iCountLeading3);
            basedSequenceInsert.safeCharAt(i8 + i6);
            if (z2) {
            }
            if (basedSequenceInsert.isCharAt(iEolEndLength - 1, CharPredicate.ANY_EOL)) {
            }
            int iCountTrailing322 = basedSequenceInsert.countTrailing(charPredicate2, iEolEndLength);
            int iCountLeading422 = basedSequenceInsert.countLeading(charPredicate2, iEolEndLength);
            if (trackedOffset.isAfterSpaceEdit()) {
            }
            if (trackedOffset.isSpliced()) {
            }
            int iMax322 = Math.max(i7, iCountLeading - iCountLeading422);
            charPredicate = CharPredicate.ANY_EOL_NUL;
            if (basedSequenceInsert.isCharAt(iEolEndLength, charPredicate)) {
            }
            i12 = iMax + iMax322;
            if (i12 > 0) {
            }
            trackedOffset.setIndex(iEolEndLength);
            if (bool2.booleanValue()) {
            }
            i14 = i16;
            size = i13;
            markdownParagraph2 = markdownParagraph;
            bool = bool2;
            i15 = iMax2;
            basedOffsetTrackerCreate = basedOffsetTracker2;
            basedOffsetTrackerCreate2 = basedOffsetTracker;
        }
    }

    public void setEscapeSpecialLeadIn(boolean z) {
        this.escapeSpecialLeadInChars = z;
    }

    public void setFirstIndent(CharSequence charSequence) {
        this.firstIndent = BasedSequence.m13437of(charSequence);
    }

    public void setFirstWidthOffset(int i) {
        this.firstWidthOffset = i;
    }

    public void setIndent(CharSequence charSequence) {
        this.indent = BasedSequence.m13437of(charSequence);
        if (this.firstIndent.isNull()) {
            this.firstIndent = this.indent;
        }
    }

    public void setKeepHardBreaks(boolean z) {
        this.keepHardLineBreaks = z;
    }

    public void setKeepSoftBreaks(boolean z) {
        this.keepSoftLineBreaks = z;
    }

    public void setLeadInHandlers(@NotNull List<? extends SpecialLeadInHandler> list) {
        this.leadInHandlers = list;
    }

    public void setOptions(@Nullable DataHolder dataHolder) {
        this.options = dataHolder;
    }

    public void setRestoreTrackedSpaces(boolean z) {
        this.restoreTrackedSpaces = z;
    }

    public void setUnEscapeSpecialLeadIn(boolean z) {
        this.unEscapeSpecialLeadInChars = z;
    }

    public void setWidth(int i) {
        this.width = Math.max(0, i);
    }

    public BasedSequence wrapText() {
        if (getFirstWidth() <= 0) {
            return this.baseSeq;
        }
        if (this.trackedOffsets.isEmpty()) {
            return wrapTextNotTracked();
        }
        sortedTrackedOffsets();
        BasedSequence basedSequenceDelete = this.baseSeq;
        BasedSequence basedSequenceDelete2 = this.altSeq;
        Range continuationStartSplice = Range.NULL;
        int size = this.trackedOffsets.size();
        while (true) {
            int i = size - 1;
            if (size <= 0) {
                break;
            }
            TrackedOffset trackedOffset = this.trackedOffsets.get(i);
            if (continuationStartSplice.isEmpty() || !continuationStartSplice.contains(trackedOffset.getOffset())) {
                continuationStartSplice = getContinuationStartSplice(trackedOffset.getOffset(), trackedOffset.isAfterSpaceEdit(), trackedOffset.isAfterDelete());
                if (continuationStartSplice.isNotEmpty()) {
                    trackedOffset.setSpliced(true);
                    basedSequenceDelete = basedSequenceDelete.delete(continuationStartSplice.getStart(), continuationStartSplice.getEnd());
                    basedSequenceDelete2 = basedSequenceDelete2.delete(continuationStartSplice.getStart(), continuationStartSplice.getEnd());
                }
            }
            size = i;
        }
        BasedSequence basedSequenceWrapText = new LeftAlignedWrapping(basedSequenceDelete).wrapText();
        if (!this.restoreTrackedSpaces) {
            return resolveTrackedOffsets(this.baseSeq, basedSequenceWrapText);
        }
        if (this.indent.isNotEmpty() || this.firstIndent.isNotEmpty()) {
            throw new IllegalStateException("restoreTrackedSpaces is not supported with indentation applied by MarkdownParagraph");
        }
        return resolveTrackedOffsetsEdit(basedSequenceDelete, basedSequenceDelete2, basedSequenceWrapText);
    }

    public BasedSequence wrapTextNotTracked() {
        return getFirstWidth() <= 0 ? this.baseSeq : new LeftAlignedWrapping(this.baseSeq).wrapText();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class LeftAlignedWrapping {

        @NotNull
        final BasedSequence baseSeq;
        boolean escapeSpecialLeadInChars;
        BasedSequence lastSpace;

        @NotNull
        List<? extends SpecialLeadInHandler> leadInHandlers;
        CharSequence lineIndent;
        int lineWidth;
        final CharSequence nextIndent;
        final int nextWidth;
        final SequenceBuilder result;
        final int spaceWidth;
        final TextTokenizer tokenizer;
        boolean unEscapeSpecialLeadInChars;
        int wordsOnLine;
        int col = 0;
        int lineCount = 0;

        public LeftAlignedWrapping(@NotNull BasedSequence basedSequence) {
            int spaceWidth = MarkdownParagraph.this.charWidthProvider.getSpaceWidth();
            this.spaceWidth = spaceWidth;
            this.lineIndent = MarkdownParagraph.this.getFirstIndent();
            this.nextIndent = MarkdownParagraph.this.getIndent();
            this.lineWidth = MarkdownParagraph.this.getFirstWidth() * spaceWidth;
            int i = MarkdownParagraph.this.width;
            this.nextWidth = i <= 0 ? Integer.MAX_VALUE : spaceWidth * i;
            this.wordsOnLine = 0;
            this.lastSpace = null;
            this.leadInHandlers = MarkdownParagraph.this.leadInHandlers;
            this.unEscapeSpecialLeadInChars = MarkdownParagraph.this.unEscapeSpecialLeadInChars;
            this.escapeSpecialLeadInChars = MarkdownParagraph.this.escapeSpecialLeadInChars;
            this.baseSeq = basedSequence;
            this.result = SequenceBuilder.emptyBuilder(basedSequence);
            this.tokenizer = new TextTokenizer(basedSequence);
        }

        public void addChars(CharSequence charSequence) {
            this.result.append(charSequence);
            this.col = MarkdownParagraph.this.charWidthProvider.getStringWidth(charSequence) + this.col;
        }

        public void addSpaces(int i) {
            this.result.append(' ', i);
            this.col = (MarkdownParagraph.this.charWidthProvider.getSpaceWidth() * i) + this.col;
        }

        public void addToken(Token token) {
            addChars(this.baseSeq.subSequence(token.range.getStart(), token.range.getEnd()));
        }

        public void advance() {
            this.tokenizer.next();
        }

        public void afterLineBreak() {
            this.col = 0;
            this.wordsOnLine = 0;
            this.lineCount++;
            this.lineIndent = this.nextIndent;
            this.lineWidth = this.nextWidth;
            this.lastSpace = null;
        }

        public void processLeadInEscape(List<? extends SpecialLeadInHandler> list, BasedSequence basedSequence) {
            if (basedSequence.isNotEmpty() && this.escapeSpecialLeadInChars) {
                Iterator<? extends SpecialLeadInHandler> it = list.iterator();
                while (it.hasNext()) {
                    if (it.next().escape(basedSequence, MarkdownParagraph.this.options, new C11856b(this))) {
                        return;
                    }
                }
            }
            addChars(basedSequence);
        }

        public void processLeadInUnEscape(List<? extends SpecialLeadInHandler> list, BasedSequence basedSequence) {
            if (basedSequence.isNotEmpty() && this.unEscapeSpecialLeadInChars) {
                Iterator<? extends SpecialLeadInHandler> it = list.iterator();
                while (it.hasNext()) {
                    if (it.next().unEscape(basedSequence, MarkdownParagraph.this.options, new C11856b(this))) {
                        return;
                    }
                }
            }
            addChars(basedSequence);
        }

        @NotNull
        public BasedSequence wrapText() {
            while (true) {
                Token token = this.tokenizer.getToken();
                if (token == null) {
                    return this.result.toSequence();
                }
                int i = C118511.f8370xac163d4d[token.type.ordinal()];
                if (i == 1) {
                    if (this.col != 0) {
                        this.lastSpace = this.baseSeq.subSequence(token.range);
                    }
                    advance();
                } else if (i == 2) {
                    int i2 = this.col;
                    if (i2 == 0 || MarkdownParagraph.this.charWidthProvider.getStringWidth(token.subSequence(this.baseSeq)) + i2 + this.spaceWidth <= this.lineWidth) {
                        int i4 = this.col;
                        boolean z = i4 == 0;
                        if (i4 > 0) {
                            this.lastSpace = addSpaces(this.lastSpace, 1);
                        } else if (!SequenceUtils.isEmpty(this.lineIndent)) {
                            addChars(this.lineIndent);
                        }
                        if (z && !token.isFirstWord) {
                            processLeadInEscape(this.leadInHandlers, this.baseSeq.subSequence(token.range));
                        } else if (z || !token.isFirstWord) {
                            addToken(token);
                        } else {
                            processLeadInUnEscape(this.leadInHandlers, this.baseSeq.subSequence(token.range));
                        }
                        advance();
                        this.wordsOnLine++;
                    } else {
                        addChars("\n");
                        afterLineBreak();
                    }
                } else if (i == 3) {
                    if (this.col > 0) {
                        addChars("\n");
                        afterLineBreak();
                    }
                    advance();
                } else if (i == 4) {
                    if (!MarkdownParagraph.this.keepHardLineBreaks) {
                        this.lastSpace = this.baseSeq.subSequence(token.range);
                    } else if (this.col > 0) {
                        addToken(token);
                        afterLineBreak();
                    }
                    advance();
                } else if (i == 5) {
                    if (this.col > 0 && MarkdownParagraph.this.keepSoftLineBreaks) {
                        addToken(token);
                        afterLineBreak();
                    }
                    advance();
                }
            }
        }

        public BasedSequence addSpaces(BasedSequence basedSequence, int i) {
            if (i <= 0) {
                return basedSequence;
            }
            if (basedSequence != null) {
                addChars(basedSequence.subSequence(0, Math.min(basedSequence.length(), i)));
                basedSequenceSubSequence = basedSequence.length() > i ? basedSequence.subSequence(i) : null;
                i = Math.max(0, i - basedSequence.length());
            }
            if (i > 0) {
                addSpaces(i);
            }
            return basedSequenceSubSequence;
        }
    }

    public MarkdownParagraph(BasedSequence basedSequence) {
        this(basedSequence, basedSequence, CharWidthProvider.NULL);
    }

    public MarkdownParagraph(@NotNull BasedSequence basedSequence, @NotNull CharWidthProvider charWidthProvider) {
        this(basedSequence, basedSequence, charWidthProvider);
    }

    public MarkdownParagraph(@NotNull BasedSequence basedSequence, @NotNull BasedSequence basedSequence2, @NotNull CharWidthProvider charWidthProvider) {
        BasedSequence basedSequence3 = BasedSequence.NULL;
        this.firstIndent = basedSequence3;
        this.indent = basedSequence3;
        this.firstWidthOffset = 0;
        this.width = 0;
        this.keepHardLineBreaks = true;
        this.keepSoftLineBreaks = false;
        this.unEscapeSpecialLeadInChars = true;
        this.escapeSpecialLeadInChars = true;
        this.restoreTrackedSpaces = false;
        this.options = null;
        this.leadInHandlers = EMPTY_LEAD_IN_HANDLERS;
        this.trackedOffsets = EMPTY_OFFSET_LIST;
        this.trackedOffsetsSorted = true;
        this.baseSeq = basedSequence;
        this.altSeq = basedSequence2;
        this.charWidthProvider = charWidthProvider;
    }
}
