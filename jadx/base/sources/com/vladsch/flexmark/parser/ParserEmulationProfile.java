package com.vladsch.flexmark.parser;

import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.ListOptions;
import com.vladsch.flexmark.util.ast.KeepType;
import com.vladsch.flexmark.util.data.DataHolder;
import com.vladsch.flexmark.util.data.DataKey;
import com.vladsch.flexmark.util.data.MutableDataHolder;
import com.vladsch.flexmark.util.data.MutableDataSet;
import com.vladsch.flexmark.util.data.MutableDataSetter;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public enum ParserEmulationProfile implements MutableDataSetter {
    COMMONMARK(null),
    COMMONMARK_0_26(COMMONMARK),
    COMMONMARK_0_27(COMMONMARK),
    COMMONMARK_0_28(COMMONMARK),
    COMMONMARK_0_29(COMMONMARK),
    FIXED_INDENT(null),
    KRAMDOWN(null),
    MARKDOWN(null),
    GITHUB_DOC(MARKDOWN),
    GITHUB(COMMONMARK),
    MULTI_MARKDOWN(FIXED_INDENT),
    PEGDOWN(FIXED_INDENT),
    PEGDOWN_STRICT(FIXED_INDENT);

    public static final DataKey<Integer> PEGDOWN_EXTENSIONS = new DataKey<>("PEGDOWN_EXTENSIONS", 65535);
    public final ParserEmulationProfile family;

    ParserEmulationProfile(ParserEmulationProfile parserEmulationProfile) {
        this.family = parserEmulationProfile == null ? this : parserEmulationProfile;
    }

    public static boolean haveAll(int i, int i2) {
        return (i & i2) == i2;
    }

    public static boolean haveAny(int i, int i2) {
        return (i & i2) != 0;
    }

    public MutableListOptions getOptions() {
        return getOptions(null);
    }

    public MutableDataHolder getProfileOptions() {
        MutableDataSet mutableDataSet = new MutableDataSet();
        setIn(mutableDataSet);
        return mutableDataSet;
    }

    @Override // com.vladsch.flexmark.util.data.MutableDataSetter
    @NotNull
    public MutableDataHolder setIn(@NotNull MutableDataHolder mutableDataHolder) {
        if (this == FIXED_INDENT) {
            getOptions(mutableDataHolder).setIn(mutableDataHolder).set(Parser.STRONG_WRAPS_EMPHASIS, Boolean.TRUE).set(Parser.LINKS_ALLOW_MATCHED_PARENTHESES, Boolean.FALSE);
            return mutableDataHolder;
        }
        if (this == KRAMDOWN) {
            getOptions(mutableDataHolder).setIn(mutableDataHolder);
            DataKey<Boolean> dataKey = Parser.HEADING_NO_LEAD_SPACE;
            Boolean bool = Boolean.TRUE;
            MutableDataHolder mutableDataHolder2 = mutableDataHolder.set(dataKey, bool);
            DataKey<Boolean> dataKey2 = Parser.BLOCK_QUOTE_INTERRUPTS_PARAGRAPH;
            Boolean bool2 = Boolean.FALSE;
            mutableDataHolder2.set(dataKey2, bool2).set(HtmlRenderer.RENDER_HEADER_ID, bool).set(HtmlRenderer.SOFT_BREAK, " ").set(Parser.HTML_BLOCK_DEEP_PARSER, bool).set(Parser.HTML_BLOCK_DEEP_PARSE_NON_BLOCK, bool).set(Parser.HTML_BLOCK_DEEP_PARSE_FIRST_OPEN_TAG_ON_ONE_LINE, bool2).set(Parser.HTML_BLOCK_DEEP_PARSE_BLANK_LINE_INTERRUPTS, bool2).set(Parser.HTML_BLOCK_DEEP_PARSE_MARKDOWN_INTERRUPTS_CLOSED, bool).set(Parser.HTML_BLOCK_DEEP_PARSE_BLANK_LINE_INTERRUPTS_PARTIAL_TAG, bool2).set(Parser.HTML_BLOCK_DEEP_PARSE_INDENTED_CODE_INTERRUPTS, bool).set(Parser.STRONG_WRAPS_EMPHASIS, bool).set(Parser.LINKS_ALLOW_MATCHED_PARENTHESES, bool2);
            return mutableDataHolder;
        }
        if (this == MARKDOWN) {
            getOptions(mutableDataHolder).setIn(mutableDataHolder);
            DataKey<Boolean> dataKey3 = Parser.HEADING_NO_LEAD_SPACE;
            Boolean bool3 = Boolean.TRUE;
            MutableDataHolder mutableDataHolder3 = mutableDataHolder.set(dataKey3, bool3).set(Parser.BLOCK_QUOTE_IGNORE_BLANK_LINE, bool3).set(HtmlRenderer.SOFT_BREAK, " ").set(Parser.HTML_BLOCK_DEEP_PARSER, bool3).set(Parser.HTML_BLOCK_DEEP_PARSE_NON_BLOCK, bool3);
            DataKey<Boolean> dataKey4 = Parser.HTML_BLOCK_DEEP_PARSE_FIRST_OPEN_TAG_ON_ONE_LINE;
            Boolean bool4 = Boolean.FALSE;
            mutableDataHolder3.set(dataKey4, bool4).set(Parser.HTML_BLOCK_DEEP_PARSE_BLANK_LINE_INTERRUPTS, bool4).set(Parser.HTML_BLOCK_DEEP_PARSE_MARKDOWN_INTERRUPTS_CLOSED, bool3).set(Parser.HTML_BLOCK_DEEP_PARSE_BLANK_LINE_INTERRUPTS_PARTIAL_TAG, bool4).set(Parser.HTML_BLOCK_DEEP_PARSE_INDENTED_CODE_INTERRUPTS, bool3).set(Parser.STRONG_WRAPS_EMPHASIS, bool3).set(Parser.LINKS_ALLOW_MATCHED_PARENTHESES, bool4);
            return mutableDataHolder;
        }
        if (this == GITHUB_DOC) {
            getOptions(mutableDataHolder).setIn(mutableDataHolder);
            DataKey<Boolean> dataKey5 = Parser.BLOCK_QUOTE_IGNORE_BLANK_LINE;
            Boolean bool5 = Boolean.TRUE;
            MutableDataHolder mutableDataHolder4 = mutableDataHolder.set(dataKey5, bool5).set(Parser.BLOCK_QUOTE_INTERRUPTS_PARAGRAPH, bool5);
            DataKey<Boolean> dataKey6 = Parser.BLOCK_QUOTE_INTERRUPTS_ITEM_PARAGRAPH;
            Boolean bool6 = Boolean.FALSE;
            mutableDataHolder4.set(dataKey6, bool6).set(Parser.HEADING_NO_LEAD_SPACE, bool5).set(Parser.HTML_BLOCK_DEEP_PARSER, bool5).set(Parser.HTML_BLOCK_DEEP_PARSE_NON_BLOCK, bool5).set(Parser.HTML_BLOCK_DEEP_PARSE_FIRST_OPEN_TAG_ON_ONE_LINE, bool6).set(Parser.HTML_BLOCK_DEEP_PARSE_BLANK_LINE_INTERRUPTS, bool5).set(Parser.HTML_BLOCK_DEEP_PARSE_MARKDOWN_INTERRUPTS_CLOSED, bool5).set(Parser.HTML_BLOCK_DEEP_PARSE_BLANK_LINE_INTERRUPTS_PARTIAL_TAG, bool6).set(Parser.HTML_BLOCK_DEEP_PARSE_INDENTED_CODE_INTERRUPTS, bool6).set(Parser.STRONG_WRAPS_EMPHASIS, bool5).set(Parser.LINKS_ALLOW_MATCHED_PARENTHESES, bool6).set(HtmlRenderer.HEADER_ID_GENERATOR_TO_DASH_CHARS, " -").set(HtmlRenderer.HEADER_ID_GENERATOR_NON_DASH_CHARS, "_").set(HtmlRenderer.HEADER_ID_GENERATOR_NON_ASCII_TO_LOWERCASE, bool6);
            return mutableDataHolder;
        }
        if (this == GITHUB) {
            getOptions(mutableDataHolder).setIn(mutableDataHolder);
            MutableDataHolder mutableDataHolder5 = mutableDataHolder.set(HtmlRenderer.HEADER_ID_GENERATOR_TO_DASH_CHARS, " -").set(HtmlRenderer.HEADER_ID_GENERATOR_NON_DASH_CHARS, "_");
            DataKey<Boolean> dataKey7 = HtmlRenderer.HEADER_ID_GENERATOR_NON_ASCII_TO_LOWERCASE;
            Boolean bool7 = Boolean.FALSE;
            mutableDataHolder5.set(dataKey7, bool7).set(HtmlRenderer.HEADER_ID_REF_TEXT_TRIM_TRAILING_SPACES, bool7).set(HtmlRenderer.HEADER_ID_ADD_EMOJI_SHORTCUT, Boolean.TRUE);
            return mutableDataHolder;
        }
        if (this == MULTI_MARKDOWN) {
            getOptions(mutableDataHolder).setIn(mutableDataHolder);
            DataKey<Boolean> dataKey8 = Parser.BLOCK_QUOTE_IGNORE_BLANK_LINE;
            Boolean bool8 = Boolean.TRUE;
            MutableDataHolder mutableDataHolder6 = mutableDataHolder.set(dataKey8, bool8);
            DataKey<Boolean> dataKey9 = Parser.BLOCK_QUOTE_WITH_LEAD_SPACES_INTERRUPTS_ITEM_PARAGRAPH;
            Boolean bool9 = Boolean.FALSE;
            mutableDataHolder6.set(dataKey9, bool9).set(HtmlRenderer.RENDER_HEADER_ID, bool8).set(HtmlRenderer.HEADER_ID_GENERATOR_RESOLVE_DUPES, bool9).set(HtmlRenderer.HEADER_ID_GENERATOR_TO_DASH_CHARS, "").set(HtmlRenderer.HEADER_ID_GENERATOR_NO_DUPED_DASHES, bool8).set(HtmlRenderer.SOFT_BREAK, " ").set(Parser.HTML_BLOCK_DEEP_PARSER, bool8).set(Parser.HTML_BLOCK_DEEP_PARSE_NON_BLOCK, bool8).set(Parser.HTML_BLOCK_DEEP_PARSE_FIRST_OPEN_TAG_ON_ONE_LINE, bool9).set(Parser.HTML_BLOCK_DEEP_PARSE_BLANK_LINE_INTERRUPTS, bool9).set(Parser.HTML_BLOCK_DEEP_PARSE_MARKDOWN_INTERRUPTS_CLOSED, bool8).set(Parser.HTML_BLOCK_DEEP_PARSE_BLANK_LINE_INTERRUPTS_PARTIAL_TAG, bool9).set(Parser.HTML_BLOCK_DEEP_PARSE_INDENTED_CODE_INTERRUPTS, bool8).set(Parser.STRONG_WRAPS_EMPHASIS, bool8).set(Parser.LINKS_ALLOW_MATCHED_PARENTHESES, bool9);
            return mutableDataHolder;
        }
        if (this != PEGDOWN && this != PEGDOWN_STRICT) {
            if (this != COMMONMARK_0_26 && this != COMMONMARK_0_27) {
                return mutableDataHolder;
            }
            mutableDataHolder.set(Parser.STRONG_WRAPS_EMPHASIS, Boolean.TRUE);
            mutableDataHolder.set(Parser.LINKS_ALLOW_MATCHED_PARENTHESES, Boolean.FALSE);
            return mutableDataHolder;
        }
        int iIntValue = PEGDOWN_EXTENSIONS.get(mutableDataHolder).intValue();
        getOptions(mutableDataHolder).setIn(mutableDataHolder);
        DataKey<Boolean> dataKey10 = Parser.BLOCK_QUOTE_EXTEND_TO_BLANK_LINE;
        Boolean bool10 = Boolean.TRUE;
        MutableDataHolder mutableDataHolder7 = mutableDataHolder.set(dataKey10, bool10).set(Parser.BLOCK_QUOTE_IGNORE_BLANK_LINE, bool10);
        DataKey<Boolean> dataKey11 = Parser.BLOCK_QUOTE_ALLOW_LEADING_SPACE;
        Boolean bool11 = Boolean.FALSE;
        mutableDataHolder7.set(dataKey11, bool11).set(Parser.INDENTED_CODE_NO_TRAILING_BLANK_LINES, bool10).set((DataKey<int>) Parser.HEADING_SETEXT_MARKER_LENGTH, 3).set(Parser.HEADING_NO_LEAD_SPACE, bool10).set(Parser.REFERENCES_KEEP, KeepType.LAST).set(Parser.PARSE_INNER_HTML_COMMENTS, bool10).set(Parser.SPACE_IN_LINK_ELEMENTS, bool10).set(HtmlRenderer.OBFUSCATE_EMAIL, bool10).set(HtmlRenderer.GENERATE_HEADER_ID, bool10).set(HtmlRenderer.HEADER_ID_GENERATOR_NO_DUPED_DASHES, bool10).set(HtmlRenderer.HEADER_ID_GENERATOR_RESOLVE_DUPES, bool11).set(HtmlRenderer.SOFT_BREAK, " ").set(Parser.STRONG_WRAPS_EMPHASIS, bool10).set(Parser.LINKS_ALLOW_MATCHED_PARENTHESES, bool11);
        if (haveAny(iIntValue, 1024)) {
            mutableDataHolder.set(HtmlRenderer.RENDER_HEADER_ID, bool11);
        }
        if (this == PEGDOWN_STRICT) {
            mutableDataHolder.set(Parser.HTML_BLOCK_DEEP_PARSER, bool10).set(Parser.HTML_BLOCK_DEEP_PARSE_NON_BLOCK, bool10).set(Parser.HTML_BLOCK_DEEP_PARSE_FIRST_OPEN_TAG_ON_ONE_LINE, bool11).set(Parser.HTML_BLOCK_DEEP_PARSE_BLANK_LINE_INTERRUPTS, bool11).set(Parser.HTML_BLOCK_DEEP_PARSE_MARKDOWN_INTERRUPTS_CLOSED, bool10).set(Parser.HTML_BLOCK_DEEP_PARSE_BLANK_LINE_INTERRUPTS_PARTIAL_TAG, bool11).set(Parser.HTML_BLOCK_DEEP_PARSE_INDENTED_CODE_INTERRUPTS, bool11);
            return mutableDataHolder;
        }
        mutableDataHolder.set(Parser.HTML_BLOCK_DEEP_PARSER, bool10).set(Parser.HTML_BLOCK_DEEP_PARSE_NON_BLOCK, bool10).set(Parser.HTML_BLOCK_DEEP_PARSE_FIRST_OPEN_TAG_ON_ONE_LINE, bool11).set(Parser.HTML_BLOCK_DEEP_PARSE_BLANK_LINE_INTERRUPTS, bool10).set(Parser.HTML_BLOCK_DEEP_PARSE_MARKDOWN_INTERRUPTS_CLOSED, bool10).set(Parser.HTML_BLOCK_DEEP_PARSE_BLANK_LINE_INTERRUPTS_PARTIAL_TAG, bool11).set(Parser.HTML_BLOCK_DEEP_PARSE_INDENTED_CODE_INTERRUPTS, bool11);
        return mutableDataHolder;
    }

    public MutableListOptions getOptions(DataHolder dataHolder) {
        ParserEmulationProfile parserEmulationProfile = this.family;
        return parserEmulationProfile == FIXED_INDENT ? this == MULTI_MARKDOWN ? new MutableListOptions().setParserEmulationFamily(this).setAutoLoose(true).setAutoLooseOneLevelLists(true).setDelimiterMismatchToNewList(false).setCodeIndent(8).setEndOnDoubleBlank(false).setItemIndent(4).setItemInterrupt(new ListOptions.MutableItemInterrupt().setBulletItemInterruptsParagraph(false).setOrderedItemInterruptsParagraph(false).setOrderedNonOneItemInterruptsParagraph(false).setEmptyBulletItemInterruptsParagraph(false).setEmptyOrderedItemInterruptsParagraph(false).setEmptyOrderedNonOneItemInterruptsParagraph(false).setBulletItemInterruptsItemParagraph(true).setOrderedItemInterruptsItemParagraph(true).setOrderedNonOneItemInterruptsItemParagraph(true).setEmptyBulletItemInterruptsItemParagraph(true).setEmptyOrderedItemInterruptsItemParagraph(true).setEmptyOrderedNonOneItemInterruptsItemParagraph(true).setEmptyBulletSubItemInterruptsItemParagraph(true).setEmptyOrderedSubItemInterruptsItemParagraph(true).setEmptyOrderedNonOneSubItemInterruptsItemParagraph(true)).setItemMarkerSpace(false).setItemTypeMismatchToNewList(false).setItemTypeMismatchToSubList(false).setLooseWhenBlankLineFollowsItemParagraph(true).setLooseWhenHasTrailingBlankLine(false).setLooseWhenHasNonListChildren(true).setNewItemCodeIndent(Integer.MAX_VALUE).setOrderedItemDotOnly(true).setOrderedListManualStart(false) : (this == PEGDOWN || this == PEGDOWN_STRICT) ? new MutableListOptions().setParserEmulationFamily(this).setAutoLoose(false).setAutoLooseOneLevelLists(false).setLooseWhenBlankLineFollowsItemParagraph(false).setLooseWhenHasLooseSubItem(false).setLooseWhenHasTrailingBlankLine(false).setLooseWhenPrevHasTrailingBlankLine(true).setOrderedListManualStart(false).setDelimiterMismatchToNewList(false).setItemTypeMismatchToNewList(true).setItemTypeMismatchToSubList(false).setEndOnDoubleBlank(false).setOrderedItemDotOnly(true).setItemMarkerSpace(true).setItemIndent(4).setCodeIndent(8).setNewItemCodeIndent(Integer.MAX_VALUE).setItemInterrupt(new ListOptions.MutableItemInterrupt().setBulletItemInterruptsParagraph(false).setOrderedItemInterruptsParagraph(false).setOrderedNonOneItemInterruptsParagraph(false).setEmptyBulletItemInterruptsParagraph(false).setEmptyOrderedItemInterruptsParagraph(false).setEmptyOrderedNonOneItemInterruptsParagraph(false).setBulletItemInterruptsItemParagraph(true).setOrderedItemInterruptsItemParagraph(true).setOrderedNonOneItemInterruptsItemParagraph(true).setEmptyBulletItemInterruptsItemParagraph(true).setEmptyOrderedItemInterruptsItemParagraph(true).setEmptyOrderedNonOneItemInterruptsItemParagraph(true).setEmptyBulletSubItemInterruptsItemParagraph(true).setEmptyOrderedSubItemInterruptsItemParagraph(true).setEmptyOrderedNonOneSubItemInterruptsItemParagraph(true)) : new MutableListOptions().setParserEmulationFamily(this).setAutoLoose(false).setAutoLooseOneLevelLists(false).setLooseWhenBlankLineFollowsItemParagraph(false).setLooseWhenHasLooseSubItem(false).setLooseWhenHasTrailingBlankLine(true).setLooseWhenPrevHasTrailingBlankLine(false).setLooseWhenLastItemPrevHasTrailingBlankLine(true).setOrderedListManualStart(false).setDelimiterMismatchToNewList(false).setItemTypeMismatchToNewList(false).setItemTypeMismatchToSubList(false).setEndOnDoubleBlank(false).setOrderedItemDotOnly(true).setItemMarkerSpace(true).setItemIndent(4).setCodeIndent(8).setNewItemCodeIndent(Integer.MAX_VALUE).setItemInterrupt(new ListOptions.MutableItemInterrupt().setBulletItemInterruptsParagraph(false).setOrderedItemInterruptsParagraph(false).setOrderedNonOneItemInterruptsParagraph(false).setEmptyBulletItemInterruptsParagraph(false).setEmptyOrderedItemInterruptsParagraph(false).setEmptyOrderedNonOneItemInterruptsParagraph(false).setBulletItemInterruptsItemParagraph(true).setOrderedItemInterruptsItemParagraph(true).setOrderedNonOneItemInterruptsItemParagraph(true).setEmptyBulletItemInterruptsItemParagraph(true).setEmptyOrderedItemInterruptsItemParagraph(true).setEmptyOrderedNonOneItemInterruptsItemParagraph(true).setEmptyBulletSubItemInterruptsItemParagraph(true).setEmptyOrderedSubItemInterruptsItemParagraph(true).setEmptyOrderedNonOneSubItemInterruptsItemParagraph(true)) : parserEmulationProfile == KRAMDOWN ? new MutableListOptions().setParserEmulationFamily(this).setAutoLoose(false).setLooseWhenBlankLineFollowsItemParagraph(true).setLooseWhenHasLooseSubItem(false).setLooseWhenHasTrailingBlankLine(false).setLooseWhenPrevHasTrailingBlankLine(false).setOrderedListManualStart(false).setDelimiterMismatchToNewList(false).setItemTypeMismatchToNewList(true).setItemTypeMismatchToSubList(true).setOrderedItemDotOnly(true).setItemMarkerSpace(true).setEndOnDoubleBlank(false).setItemIndent(4).setCodeIndent(8).setNewItemCodeIndent(Integer.MAX_VALUE).setItemInterrupt(new ListOptions.MutableItemInterrupt().setBulletItemInterruptsParagraph(false).setOrderedItemInterruptsParagraph(false).setOrderedNonOneItemInterruptsParagraph(false).setEmptyBulletItemInterruptsParagraph(false).setEmptyOrderedItemInterruptsParagraph(false).setEmptyOrderedNonOneItemInterruptsParagraph(false).setBulletItemInterruptsItemParagraph(true).setOrderedItemInterruptsItemParagraph(true).setOrderedNonOneItemInterruptsItemParagraph(true).setEmptyBulletItemInterruptsItemParagraph(true).setEmptyOrderedItemInterruptsItemParagraph(true).setEmptyOrderedNonOneItemInterruptsItemParagraph(true).setEmptyBulletSubItemInterruptsItemParagraph(false).setEmptyOrderedSubItemInterruptsItemParagraph(false).setEmptyOrderedNonOneSubItemInterruptsItemParagraph(false)) : parserEmulationProfile == MARKDOWN ? this == GITHUB_DOC ? new MutableListOptions().setParserEmulationFamily(this).setAutoLoose(false).setLooseWhenBlankLineFollowsItemParagraph(true).setLooseWhenHasLooseSubItem(true).setLooseWhenHasTrailingBlankLine(true).setLooseWhenPrevHasTrailingBlankLine(true).setLooseWhenContainsBlankLine(false).setLooseWhenHasNonListChildren(true).setOrderedListManualStart(false).setDelimiterMismatchToNewList(false).setItemTypeMismatchToNewList(false).setItemTypeMismatchToSubList(false).setEndOnDoubleBlank(false).setOrderedItemDotOnly(true).setItemMarkerSpace(true).setItemIndent(4).setCodeIndent(8).setNewItemCodeIndent(Integer.MAX_VALUE).setItemInterrupt(new ListOptions.MutableItemInterrupt().setBulletItemInterruptsParagraph(true).setOrderedItemInterruptsParagraph(false).setOrderedNonOneItemInterruptsParagraph(false).setEmptyBulletItemInterruptsParagraph(true).setEmptyOrderedItemInterruptsParagraph(false).setEmptyOrderedNonOneItemInterruptsParagraph(false).setBulletItemInterruptsItemParagraph(true).setOrderedItemInterruptsItemParagraph(true).setOrderedNonOneItemInterruptsItemParagraph(true).setEmptyBulletItemInterruptsItemParagraph(true).setEmptyOrderedItemInterruptsItemParagraph(true).setEmptyOrderedNonOneItemInterruptsItemParagraph(true).setEmptyBulletSubItemInterruptsItemParagraph(true).setEmptyOrderedSubItemInterruptsItemParagraph(true).setEmptyOrderedNonOneSubItemInterruptsItemParagraph(true)) : new MutableListOptions().setParserEmulationFamily(this).setAutoLoose(false).setLooseWhenBlankLineFollowsItemParagraph(true).setLooseWhenHasLooseSubItem(true).setLooseWhenHasTrailingBlankLine(true).setLooseWhenPrevHasTrailingBlankLine(true).setLooseWhenContainsBlankLine(true).setOrderedListManualStart(false).setDelimiterMismatchToNewList(false).setItemTypeMismatchToNewList(false).setItemTypeMismatchToSubList(false).setEndOnDoubleBlank(false).setOrderedItemDotOnly(true).setItemMarkerSpace(true).setItemIndent(4).setCodeIndent(8).setNewItemCodeIndent(Integer.MAX_VALUE).setItemInterrupt(new ListOptions.MutableItemInterrupt().setBulletItemInterruptsParagraph(false).setOrderedItemInterruptsParagraph(false).setOrderedNonOneItemInterruptsParagraph(false).setEmptyBulletItemInterruptsParagraph(false).setEmptyOrderedItemInterruptsParagraph(false).setEmptyOrderedNonOneItemInterruptsParagraph(false).setBulletItemInterruptsItemParagraph(true).setOrderedItemInterruptsItemParagraph(true).setOrderedNonOneItemInterruptsItemParagraph(true).setEmptyBulletItemInterruptsItemParagraph(false).setEmptyOrderedItemInterruptsItemParagraph(false).setEmptyOrderedNonOneItemInterruptsItemParagraph(false).setEmptyBulletSubItemInterruptsItemParagraph(true).setEmptyOrderedSubItemInterruptsItemParagraph(true).setEmptyOrderedNonOneSubItemInterruptsItemParagraph(true)) : (parserEmulationProfile == COMMONMARK && this == COMMONMARK_0_26) ? new MutableListOptions((DataHolder) null).setEndOnDoubleBlank(true) : new MutableListOptions((DataHolder) null);
    }
}
