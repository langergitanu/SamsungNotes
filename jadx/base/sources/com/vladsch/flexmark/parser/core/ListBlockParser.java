package com.vladsch.flexmark.parser.core;

import com.vladsch.flexmark.ast.BulletList;
import com.vladsch.flexmark.ast.ListBlock;
import com.vladsch.flexmark.ast.ListItem;
import com.vladsch.flexmark.ast.OrderedList;
import com.vladsch.flexmark.ast.util.Parsing;
import com.vladsch.flexmark.parser.ListOptions;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.parser.ParserEmulationProfile;
import com.vladsch.flexmark.parser.block.AbstractBlockParser;
import com.vladsch.flexmark.parser.block.AbstractBlockParserFactory;
import com.vladsch.flexmark.parser.block.BlockContinue;
import com.vladsch.flexmark.parser.block.BlockParser;
import com.vladsch.flexmark.parser.block.BlockParserFactory;
import com.vladsch.flexmark.parser.block.BlockStart;
import com.vladsch.flexmark.parser.block.CustomBlockParserFactory;
import com.vladsch.flexmark.parser.block.MatchedBlockParser;
import com.vladsch.flexmark.parser.block.ParserState;
import com.vladsch.flexmark.parser.core.BlockQuoteParser;
import com.vladsch.flexmark.parser.core.FencedCodeBlockParser;
import com.vladsch.flexmark.parser.core.HeadingParser;
import com.vladsch.flexmark.parser.core.HtmlBlockParser;
import com.vladsch.flexmark.parser.core.IndentedCodeBlockParser;
import com.vladsch.flexmark.parser.core.ThematicBreakParser;
import com.vladsch.flexmark.util.ast.BlankLine;
import com.vladsch.flexmark.util.ast.Block;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.collection.iteration.ReversiblePeekingIterator;
import com.vladsch.flexmark.util.data.DataHolder;
import com.vladsch.flexmark.util.data.DataKey;
import com.vladsch.flexmark.util.data.SharedDataKeys;
import com.vladsch.flexmark.util.misc.CharPredicate;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import com.vladsch.flexmark.util.sequence.SequenceUtils;
import com.vladsch.flexmark.util.sequence.mappers.SpecialLeadInCharsHandler;
import com.vladsch.flexmark.util.sequence.mappers.SpecialLeadInHandler;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ListBlockParser extends AbstractBlockParser {
    private final ListBlock myBlock;
    BasedSequence myItemHandledLine = null;
    boolean myItemHandledNewItemLine;
    boolean myItemHandledNewListLine;
    boolean myItemHandledSkipActiveLine;
    ListItemParser myLastChild;
    private final ListData myListData;
    private final ListOptions myOptions;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class BlockFactory extends AbstractBlockParserFactory {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final ListOptions myOptions;

        public BlockFactory(DataHolder dataHolder) {
            super(dataHolder);
            this.myOptions = ListOptions.get(dataHolder);
        }

        @Override // com.vladsch.flexmark.parser.block.BlockParserFactory
        public BlockStart tryStart(ParserState parserState, MatchedBlockParser matchedBlockParser) {
            BlockParser blockParser = matchedBlockParser.getBlockParser();
            ParserEmulationProfile parserEmulationProfile = this.myOptions.getParserEmulationProfile().family;
            int newItemCodeIndent = this.myOptions.getNewItemCodeIndent();
            if (blockParser instanceof ListBlockParser) {
                ListBlockParser listBlockParser = (ListBlockParser) blockParser;
                if (parserState.getLine() != listBlockParser.myItemHandledLine) {
                    return BlockStart.none();
                }
                if (listBlockParser.myItemHandledNewListLine) {
                    ListData listMarker = ListBlockParser.parseListMarker(this.myOptions, newItemCodeIndent, parserState);
                    ListItemParser listItemParser = new ListItemParser(this.myOptions, parserState.getParsing(), listMarker);
                    return BlockStart.m13315of(new ListBlockParser(this.myOptions, listMarker, listItemParser), listItemParser).atColumn(listMarker.listMarker.length() + listMarker.markerColumn + listMarker.contentOffset);
                }
                if (!listBlockParser.myItemHandledNewItemLine) {
                    listBlockParser.myItemHandledLine = null;
                    return BlockStart.none();
                }
                ListData listMarker2 = ListBlockParser.parseListMarker(this.myOptions, newItemCodeIndent, parserState);
                ListItemParser listItemParser2 = new ListItemParser(this.myOptions, parserState.getParsing(), listMarker2);
                int length = listMarker2.listMarker.length() + listMarker2.markerColumn + listMarker2.contentOffset;
                listBlockParser.myLastChild = listItemParser2;
                return BlockStart.m13315of(listItemParser2).atColumn(length);
            }
            ListBlock listBlock = (ListBlock) blockParser.getBlock().getAncestorOfType(ListBlock.class);
            if (listBlock != null) {
                ListBlockParser listBlockParser2 = (ListBlockParser) parserState.getActiveBlockParser(listBlock);
                if (listBlockParser2.myItemHandledLine == parserState.getLine() && listBlockParser2.myItemHandledSkipActiveLine) {
                    listBlockParser2.myItemHandledLine = null;
                    return BlockStart.none();
                }
            }
            if (parserEmulationProfile == ParserEmulationProfile.COMMONMARK) {
                if (parserState.getIndent() >= this.myOptions.getCodeIndent()) {
                    return BlockStart.none();
                }
            } else if (parserEmulationProfile == ParserEmulationProfile.FIXED_INDENT) {
                if (parserState.getIndent() >= this.myOptions.getItemIndent()) {
                    return BlockStart.none();
                }
            } else if (parserEmulationProfile == ParserEmulationProfile.KRAMDOWN) {
                if (parserState.getIndent() >= this.myOptions.getItemIndent()) {
                    return BlockStart.none();
                }
            } else if (parserEmulationProfile == ParserEmulationProfile.MARKDOWN && parserState.getIndent() >= this.myOptions.getItemIndent()) {
                return BlockStart.none();
            }
            ListData listMarker3 = ListBlockParser.parseListMarker(this.myOptions, newItemCodeIndent, parserState);
            if (listMarker3 == null) {
                return BlockStart.none();
            }
            int length2 = listMarker3.listMarker.length() + listMarker3.markerColumn + listMarker3.contentOffset;
            boolean zIsParagraphParser = blockParser.isParagraphParser();
            boolean z = zIsParagraphParser && (blockParser.getBlock().getParent() instanceof ListItem) && blockParser.getBlock() == blockParser.getBlock().getParent().getFirstChild();
            if (zIsParagraphParser && !this.myOptions.canInterrupt(listMarker3.listBlock, listMarker3.isEmpty, z)) {
                return BlockStart.none();
            }
            ListItemParser listItemParser3 = new ListItemParser(this.myOptions, parserState.getParsing(), listMarker3);
            return BlockStart.m13315of(new ListBlockParser(this.myOptions, listMarker3, listItemParser3), listItemParser3).atColumn(length2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Factory implements CustomBlockParserFactory {
        @Override // com.vladsch.flexmark.util.dependency.Dependent
        public boolean affectsGlobalScope() {
            return false;
        }

        @Override // com.vladsch.flexmark.util.dependency.Dependent
        @Nullable
        public Set<Class<?>> getAfterDependents() {
            return new HashSet(Arrays.asList(BlockQuoteParser.Factory.class, HeadingParser.Factory.class, FencedCodeBlockParser.Factory.class, HtmlBlockParser.Factory.class, ThematicBreakParser.Factory.class));
        }

        @Override // com.vladsch.flexmark.util.dependency.Dependent
        @Nullable
        public Set<Class<?>> getBeforeDependents() {
            HashSet hashSet = new HashSet();
            hashSet.add(IndentedCodeBlockParser.Factory.class);
            return hashSet;
        }

        @Override // com.vladsch.flexmark.parser.block.CustomBlockParserFactory
        @Nullable
        public SpecialLeadInHandler getLeadInHandler(@NotNull DataHolder dataHolder) {
            return ListItemLeadInHandler.create(Parser.LISTS_ITEM_PREFIX_CHARS.get(dataHolder), Parser.LISTS_ORDERED_ITEM_DOT_ONLY.get(dataHolder).booleanValue());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.vladsch.flexmark.parser.block.CustomBlockParserFactory, java.util.function.Function
        @NotNull
        public BlockParserFactory apply(@NotNull DataHolder dataHolder) {
            return new BlockFactory(dataHolder);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ListData {
        final int contentOffset;
        final boolean isEmpty;
        final boolean isNumberedList;
        final ListBlock listBlock;
        final BasedSequence listMarker;
        final int markerColumn;
        final int markerIndent;
        final int markerIndex;
        final BasedSequence markerSuffix;
        final int markerSuffixOffset;

        public ListData(ListBlock listBlock, boolean z, int i, int i2, int i4, int i5, BasedSequence basedSequence, boolean z2, BasedSequence basedSequence2, int i6) {
            this.listBlock = listBlock;
            this.isEmpty = z;
            this.markerIndex = i;
            this.markerColumn = i2;
            this.markerIndent = i4;
            this.contentOffset = i5;
            this.listMarker = basedSequence;
            this.isNumberedList = z2;
            this.markerSuffix = basedSequence2;
            this.markerSuffixOffset = i6;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ListItemLeadInHandler extends SpecialLeadInCharsHandler {
        static final SpecialLeadInHandler ORDERED_DELIM_DOT_HANDLER;
        static final SpecialLeadInHandler ORDERED_DELIM_DOT_PARENS_HANDLER;
        final CharPredicate orderedDelims;
        static final CharPredicate ORDERED_DELIM_DOT = CharPredicate.anyOf('.');
        static final CharPredicate ORDERED_DELIM_DOT_PARENS = CharPredicate.anyOf(".)");

        static {
            DataKey<String> dataKey = Parser.LISTS_ITEM_PREFIX_CHARS;
            ORDERED_DELIM_DOT_HANDLER = new ListItemLeadInHandler(dataKey.getDefaultValue(), true);
            ORDERED_DELIM_DOT_PARENS_HANDLER = new ListItemLeadInHandler(dataKey.getDefaultValue(), false);
        }

        public ListItemLeadInHandler(CharSequence charSequence, boolean z) {
            super(CharPredicate.anyOf(charSequence));
            this.orderedDelims = z ? ORDERED_DELIM_DOT : ORDERED_DELIM_DOT_PARENS;
        }

        @NotNull
        public static SpecialLeadInHandler create(@NotNull CharSequence charSequence, boolean z) {
            return SequenceUtils.equals(Parser.LISTS_ITEM_PREFIX_CHARS.getDefaultValue(), charSequence) ? z ? ORDERED_DELIM_DOT_HANDLER : ORDERED_DELIM_DOT_PARENS_HANDLER : new ListItemLeadInHandler(charSequence, z);
        }

        @Override // com.vladsch.flexmark.util.sequence.mappers.SpecialLeadInCharsHandler, com.vladsch.flexmark.util.sequence.mappers.SpecialLeadInHandler
        public boolean escape(@NotNull BasedSequence basedSequence, @Nullable DataHolder dataHolder, @NotNull Consumer<CharSequence> consumer) {
            int iIndexOfAnyNot;
            if (super.escape(basedSequence, dataHolder, consumer)) {
                return true;
            }
            if (!SharedDataKeys.ESCAPE_NUMBERED_LEAD_IN.get(dataHolder).booleanValue() || (iIndexOfAnyNot = basedSequence.indexOfAnyNot(CharPredicate.DECIMAL_DIGITS)) <= 0 || iIndexOfAnyNot + 1 != basedSequence.length() || !this.orderedDelims.test(basedSequence.charAt(iIndexOfAnyNot))) {
                return false;
            }
            consumer.accept(basedSequence.subSequence(0, iIndexOfAnyNot));
            consumer.accept("\\");
            consumer.accept(basedSequence.subSequence(iIndexOfAnyNot));
            return true;
        }

        @Override // com.vladsch.flexmark.util.sequence.mappers.SpecialLeadInCharsHandler, com.vladsch.flexmark.util.sequence.mappers.SpecialLeadInHandler
        public boolean unEscape(@NotNull BasedSequence basedSequence, @Nullable DataHolder dataHolder, @NotNull Consumer<CharSequence> consumer) {
            if (super.unEscape(basedSequence, dataHolder, consumer)) {
                return true;
            }
            int iIndexOfAnyNot = basedSequence.indexOfAnyNot(CharPredicate.DECIMAL_DIGITS);
            if (iIndexOfAnyNot > 0 && iIndexOfAnyNot + 2 == basedSequence.length() && basedSequence.charAt(iIndexOfAnyNot) == '\\') {
                int i = iIndexOfAnyNot + 1;
                if (this.orderedDelims.test(basedSequence.charAt(i))) {
                    consumer.accept(basedSequence.subSequence(0, iIndexOfAnyNot));
                    consumer.accept(basedSequence.subSequence(i));
                    return true;
                }
            }
            return false;
        }
    }

    public ListBlockParser(ListOptions listOptions, ListData listData, ListItemParser listItemParser) {
        this.myLastChild = null;
        this.myOptions = listOptions;
        this.myListData = listData;
        ListBlock listBlock = listData.listBlock;
        this.myBlock = listBlock;
        listBlock.setTight(true);
        this.myLastChild = listItemParser;
        this.myItemHandledNewListLine = false;
        this.myItemHandledNewItemLine = false;
        this.myItemHandledSkipActiveLine = false;
    }

    private static ListBlock createListBlock(Matcher matcher) {
        String strGroup = matcher.group(1);
        if (strGroup != null) {
            BulletList bulletList = new BulletList();
            bulletList.setOpeningMarker(strGroup.charAt(0));
            return bulletList;
        }
        String strGroup2 = matcher.group(2);
        String strGroup3 = matcher.group(3);
        OrderedList orderedList = new OrderedList();
        orderedList.setStartNumber(Integer.parseInt(strGroup2));
        orderedList.setDelimiter(strGroup3.charAt(0));
        return orderedList;
    }

    private void finalizeListTight(ParserState parserState) {
        boolean z;
        boolean z2;
        boolean z3 = true;
        boolean z4 = false;
        boolean z5 = false;
        for (Node firstChild = getBlock().getFirstChild(); firstChild != null; firstChild = firstChild.getNext()) {
            boolean z6 = firstChild instanceof ListItem;
            if (z6) {
                ListItem listItem = (ListItem) firstChild;
                boolean z7 = listItem.isHadBlankAfterItemParagraph() && !(firstChild.getNext() == null && (firstChild.getFirstChild() == null || firstChild.getFirstChild().getNext() == null));
                boolean zIsContainsBlankLine = listItem.isContainsBlankLine();
                z2 = parserState.endsWithBlankLine(firstChild) && firstChild.getNext() != null;
                z = (z2 && this.myOptions.isLooseWhenHasTrailingBlankLine()) || (z7 && this.myOptions.isLooseWhenBlankLineFollowsItemParagraph()) || ((zIsContainsBlankLine && this.myOptions.isLooseWhenContainsBlankLine()) || ((hasNonItemChildren(listItem) && this.myOptions.isLooseWhenHasNonListChildren()) || (((z2 && firstChild.getPrevious() == null) || z5) && (this.myOptions.isLooseWhenPrevHasTrailingBlankLine() || (this.myOptions.isLooseWhenLastItemPrevHasTrailingBlankLine() && firstChild.getNext() == null)))));
                if (z) {
                    listItem.setLoose(true);
                    z3 = false;
                }
            } else {
                z = false;
                z2 = false;
            }
            for (Node firstChild2 = firstChild.getFirstChild(); firstChild2 != null; firstChild2 = firstChild2.getNext()) {
                if (parserState.endsWithBlankLine(firstChild2) && (firstChild.getNext() != null || firstChild2.getNext() != null)) {
                    if (firstChild2 == firstChild.getLastChild()) {
                        z2 = true;
                    }
                    if (!z) {
                        if (this.myOptions.isLooseWhenHasTrailingBlankLine()) {
                            z3 = false;
                        }
                        if (z2 && firstChild.getPrevious() == null && this.myOptions.isLooseWhenPrevHasTrailingBlankLine()) {
                            ((ListItem) firstChild).setLoose(true);
                            z = true;
                            z3 = false;
                        }
                    }
                }
                if (firstChild2 instanceof ListBlock) {
                    if (z || !this.myOptions.isLooseWhenHasLooseSubItem()) {
                        z4 = true;
                    } else {
                        ReversiblePeekingIterator<Node> childIterator = firstChild2.getChildIterator();
                        while (childIterator.hasNext()) {
                            if (!((ListItem) childIterator.next()).isTight()) {
                                ((ListItem) firstChild).setLoose(true);
                                z4 = true;
                                z = true;
                                z3 = false;
                                break;
                            }
                        }
                        z4 = true;
                    }
                }
                if (!this.myOptions.isLooseWhenHasLooseSubItem()) {
                    if (!z3 && (z4 || !this.myOptions.isAutoLooseOneLevelLists())) {
                        break;
                    }
                } else {
                    if (z && (z4 || !this.myOptions.isAutoLooseOneLevelLists())) {
                        break;
                    }
                }
            }
            if (z6) {
                z5 = z2;
            }
        }
        if (!this.myOptions.isAutoLoose() || !this.myOptions.isAutoLooseOneLevelLists()) {
            if (!this.myOptions.isAutoLoose() || z3) {
                return;
            }
            setTight(false);
            return;
        }
        if (z4 || getBlock().getAncestorOfType(ListBlock.class) != null || z3) {
            return;
        }
        setTight(false);
    }

    private static boolean hasNonItemChildren(ListItem listItem) {
        if (listItem.hasChildren()) {
            ReversiblePeekingIterator<Node> it = listItem.getChildren().iterator();
            int i = 0;
            while (it.hasNext()) {
                if (!(it.next() instanceof ListBlock) && (i = i + 1) >= 2) {
                    return true;
                }
            }
        }
        return false;
    }

    public static ListData parseListMarker(ListOptions listOptions, int i, ParserState parserState) {
        boolean z;
        Matcher matcher;
        ListBlock listBlock;
        int iColumnsToNextTabStop;
        int i2;
        boolean z2;
        Parsing parsing = parserState.getParsing();
        BasedSequence line = parserState.getLine();
        int nextNonSpaceIndex = parserState.getNextNonSpaceIndex();
        int indent = parserState.getIndent() + parserState.getColumn();
        int indent2 = parserState.getIndent();
        BasedSequence basedSequenceSubSequence = line.subSequence(nextNonSpaceIndex, line.length());
        Matcher matcher2 = parsing.LIST_ITEM_MARKER.matcher(basedSequenceSubSequence);
        if (!matcher2.find()) {
            return null;
        }
        ListBlock listBlockCreateListBlock = createListBlock(matcher2);
        int iEnd = matcher2.end() - matcher2.start();
        boolean zContains = "+-*".contains(matcher2.group());
        boolean z3 = !zContains;
        int i4 = nextNonSpaceIndex + iEnd;
        int i5 = iEnd + indent;
        int i6 = i4;
        int iColumnsToNextTabStop2 = 0;
        while (true) {
            if (i4 >= line.length()) {
                z = false;
                break;
            }
            char cCharAt = line.charAt(i4);
            if (cCharAt != '\t') {
                if (cCharAt != ' ') {
                    z = true;
                    break;
                }
                iColumnsToNextTabStop2++;
                i6++;
            } else {
                i6++;
                iColumnsToNextTabStop2 = Parsing.columnsToNextTabStop(i5 + iColumnsToNextTabStop2) + iColumnsToNextTabStop2;
            }
            i4++;
        }
        BasedSequence basedSequenceSubSequence2 = BasedSequence.NULL;
        if (!z || iColumnsToNextTabStop2 > i) {
            matcher = matcher2;
            listBlock = listBlockCreateListBlock;
            iColumnsToNextTabStop = 1;
        } else {
            if (zContains || listOptions.isNumberedItemMarkerSuffixed()) {
                String[] itemMarkerSuffixes = listOptions.getItemMarkerSuffixes();
                int length = itemMarkerSuffixes.length;
                matcher = matcher2;
                int i7 = 0;
                while (i7 < length) {
                    int i8 = i7;
                    String str = itemMarkerSuffixes[i8];
                    int length2 = str.length();
                    if (length2 > 0 && line.matchChars(str, i6)) {
                        if (listOptions.isItemMarkerSpace()) {
                            char cMidCharAt = line.midCharAt(i6 + length2);
                            listBlock = listBlockCreateListBlock;
                            if (cMidCharAt == ' ' || cMidCharAt == '\t') {
                            }
                        } else {
                            listBlock = listBlockCreateListBlock;
                        }
                        int i9 = i6 + length2;
                        basedSequenceSubSequence2 = line.subSequence(i6, i9);
                        int i10 = iColumnsToNextTabStop2 + length2;
                        int i11 = i5 + length2;
                        iColumnsToNextTabStop = i10;
                        while (true) {
                            if (i9 >= line.length()) {
                                z2 = false;
                                break;
                            }
                            char cCharAt2 = line.charAt(i9);
                            if (cCharAt2 != '\t') {
                                if (cCharAt2 != ' ') {
                                    z2 = true;
                                    break;
                                }
                                iColumnsToNextTabStop++;
                            } else {
                                iColumnsToNextTabStop = Parsing.columnsToNextTabStop(i11 + iColumnsToNextTabStop) + iColumnsToNextTabStop;
                            }
                            i9++;
                        }
                        if (!z2 || iColumnsToNextTabStop - i10 > i) {
                            z = z2;
                            iColumnsToNextTabStop = i10 + 1;
                        } else {
                            z = z2;
                        }
                        i2 = iColumnsToNextTabStop2;
                        return new ListData(listBlock, !z, nextNonSpaceIndex, indent, indent2, iColumnsToNextTabStop, basedSequenceSubSequence.subSequence(matcher.start(), matcher.end()), z3, basedSequenceSubSequence2, i2);
                    }
                    listBlock = listBlockCreateListBlock;
                    i7 = i8 + 1;
                    listBlockCreateListBlock = listBlock;
                }
            } else {
                matcher = matcher2;
            }
            listBlock = listBlockCreateListBlock;
            iColumnsToNextTabStop = iColumnsToNextTabStop2;
        }
        i2 = iColumnsToNextTabStop;
        return new ListData(listBlock, !z, nextNonSpaceIndex, indent, indent2, iColumnsToNextTabStop, basedSequenceSubSequence.subSequence(matcher.start(), matcher.end()), z3, basedSequenceSubSequence2, i2);
    }

    private void setTight(boolean z) {
        this.myBlock.setTight(z);
    }

    @Override // com.vladsch.flexmark.parser.block.AbstractBlockParser, com.vladsch.flexmark.parser.block.BlockParser
    public boolean breakOutOnDoubleBlankLine() {
        return this.myOptions.isEndOnDoubleBlank();
    }

    @Override // com.vladsch.flexmark.parser.block.AbstractBlockParser, com.vladsch.flexmark.parser.block.BlockParser
    public boolean canContain(ParserState parserState, BlockParser blockParser, Block block) {
        return block instanceof ListItem;
    }

    @Override // com.vladsch.flexmark.parser.block.BlockParser
    public void closeBlock(ParserState parserState) {
        finalizeListTight(parserState);
        if (Parser.BLANK_LINES_IN_AST.get(parserState.getProperties()).booleanValue()) {
            for (Node firstChildAnyNot = getBlock().getFirstChildAnyNot(BlankLine.class); firstChildAnyNot instanceof ListItem; firstChildAnyNot = firstChildAnyNot.getNextAnyNot(BlankLine.class)) {
                firstChildAnyNot.moveTrailingBlankLines();
            }
        }
        this.myBlock.setCharsFromContentOnly();
    }

    public int getContentIndent() {
        ListData listData = this.myListData;
        return listData.listMarker.length() + listData.markerIndent + this.myListData.contentOffset;
    }

    public BasedSequence getItemHandledLine() {
        return this.myItemHandledLine;
    }

    public ListItemParser getLastChild() {
        return this.myLastChild;
    }

    public int getLastContentIndent() {
        return this.myLastChild.getContentIndent();
    }

    public ListData getListData() {
        return this.myListData;
    }

    public ListOptions getOptions() {
        return this.myOptions;
    }

    @Override // com.vladsch.flexmark.parser.block.AbstractBlockParser, com.vladsch.flexmark.parser.block.BlockParser
    public boolean isContainer() {
        return true;
    }

    public void setItemHandledLine(BasedSequence basedSequence) {
        this.myItemHandledLine = basedSequence;
        this.myItemHandledNewListLine = false;
        this.myItemHandledNewItemLine = false;
        this.myItemHandledSkipActiveLine = false;
    }

    public void setItemHandledLineSkipActive(BasedSequence basedSequence) {
        this.myItemHandledLine = basedSequence;
        this.myItemHandledNewListLine = false;
        this.myItemHandledNewItemLine = false;
        this.myItemHandledSkipActiveLine = true;
    }

    public void setItemHandledNewItemLine(BasedSequence basedSequence) {
        this.myItemHandledLine = basedSequence;
        this.myItemHandledNewListLine = false;
        this.myItemHandledNewItemLine = true;
        this.myItemHandledSkipActiveLine = false;
    }

    public void setItemHandledNewListLine(BasedSequence basedSequence) {
        this.myItemHandledLine = basedSequence;
        this.myItemHandledNewListLine = true;
        this.myItemHandledNewItemLine = false;
        this.myItemHandledSkipActiveLine = false;
    }

    public void setLastChild(ListItemParser listItemParser) {
        this.myLastChild = listItemParser;
    }

    @Override // com.vladsch.flexmark.parser.block.BlockParser
    public BlockContinue tryContinue(ParserState parserState) {
        return BlockContinue.atIndex(parserState.getIndex());
    }

    @Override // com.vladsch.flexmark.parser.block.BlockParser
    public ListBlock getBlock() {
        return this.myBlock;
    }
}
