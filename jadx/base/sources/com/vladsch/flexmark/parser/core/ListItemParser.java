package com.vladsch.flexmark.parser.core;

import com.vladsch.flexmark.ast.BulletListItem;
import com.vladsch.flexmark.ast.FencedCodeBlock;
import com.vladsch.flexmark.ast.ListItem;
import com.vladsch.flexmark.ast.OrderedListItem;
import com.vladsch.flexmark.ast.util.Parsing;
import com.vladsch.flexmark.parser.ListOptions;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.parser.ParserEmulationProfile;
import com.vladsch.flexmark.parser.block.AbstractBlockParser;
import com.vladsch.flexmark.parser.block.BlockContinue;
import com.vladsch.flexmark.parser.block.BlockParser;
import com.vladsch.flexmark.parser.block.ParserState;
import com.vladsch.flexmark.parser.core.ListBlockParser;
import com.vladsch.flexmark.util.ast.Block;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.misc.Utils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ListItemParser extends AbstractBlockParser {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final ListItem myBlock;
    private boolean myHadBlankLine = false;
    private boolean myIsEmpty = false;
    private final ListBlockParser.ListData myListData;
    private final ListOptions myOptions;
    private final Parsing myParsing;

    public ListItemParser(ListOptions listOptions, Parsing parsing, ListBlockParser.ListData listData) {
        this.myOptions = listOptions;
        this.myListData = listData;
        this.myParsing = parsing;
        ListItem orderedListItem = listData.isNumberedList ? new OrderedListItem() : new BulletListItem();
        this.myBlock = orderedListItem;
        orderedListItem.setOpeningMarker(listData.listMarker);
        orderedListItem.setMarkerSuffix(listData.markerSuffix);
    }

    private BlockContinue continueAtColumn(int i) {
        if (this.myHadBlankLine) {
            this.myBlock.setContainsBlankLine(true);
        }
        this.myIsEmpty = false;
        return BlockContinue.atColumn(i);
    }

    @Override // com.vladsch.flexmark.parser.block.AbstractBlockParser, com.vladsch.flexmark.parser.block.BlockParser
    public boolean canContain(ParserState parserState, BlockParser blockParser, Block block) {
        return ((block instanceof FencedCodeBlock) && Parser.PARSER_EMULATION_PROFILE.get(parserState.getProperties()) == ParserEmulationProfile.GITHUB_DOC && this.myListData.markerIndent >= ((FencedCodeBlockParser) blockParser).getFenceMarkerIndent()) ? false : true;
    }

    @Override // com.vladsch.flexmark.parser.block.BlockParser
    public void closeBlock(ParserState parserState) {
        this.myBlock.setCharsFromContent();
    }

    @Override // com.vladsch.flexmark.parser.block.BlockParser
    public Block getBlock() {
        return this.myBlock;
    }

    public int getContentColumn() {
        ListBlockParser.ListData listData = this.myListData;
        return listData.listMarker.length() + listData.markerColumn + (this.myOptions.isItemContentAfterSuffix() ? this.myListData.contentOffset : this.myListData.markerSuffixOffset);
    }

    public int getContentIndent() {
        ListBlockParser.ListData listData = this.myListData;
        return listData.listMarker.length() + listData.markerIndent + (this.myOptions.isItemContentAfterSuffix() ? this.myListData.contentOffset : this.myListData.markerSuffixOffset);
    }

    public int getMarkerContentIndent() {
        ListBlockParser.ListData listData = this.myListData;
        return listData.listMarker.length() + listData.markerIndent + 1;
    }

    @Override // com.vladsch.flexmark.parser.block.AbstractBlockParser, com.vladsch.flexmark.parser.block.BlockParser
    public boolean isContainer() {
        return true;
    }

    @Override // com.vladsch.flexmark.parser.block.AbstractBlockParser, com.vladsch.flexmark.parser.block.BlockParser
    public boolean isPropagatingLastBlankLine(BlockParser blockParser) {
        return this.myBlock.getFirstChild() != null || this == blockParser;
    }

    @Override // com.vladsch.flexmark.parser.block.BlockParser
    public BlockContinue tryContinue(ParserState parserState) {
        if (parserState.isBlank()) {
            Node firstChild = this.myBlock.getFirstChild();
            boolean z = firstChild == null;
            this.myIsEmpty = z;
            if (z || firstChild.getNext() == null) {
                this.myBlock.setHadBlankAfterItemParagraph(true);
            }
            this.myHadBlankLine = true;
            return BlockContinue.atIndex(parserState.getNextNonSpaceIndex());
        }
        ListBlockParser listBlockParser = (ListBlockParser) parserState.getActiveBlockParser(this.myBlock.getParent());
        ParserEmulationProfile parserEmulationProfile = this.myOptions.getParserEmulationProfile();
        ParserEmulationProfile parserEmulationProfile2 = parserEmulationProfile.family;
        int contentIndent = getContentIndent();
        if (parserEmulationProfile2 == ParserEmulationProfile.COMMONMARK) {
            int indent = parserState.getIndent();
            int column = parserState.getColumn() + contentIndent;
            if (indent >= this.myOptions.getCodeIndent() + contentIndent) {
                listBlockParser.setItemHandledLine(parserState.getLine());
                return continueAtColumn(column);
            }
            ListOptions listOptions = this.myOptions;
            ListBlockParser.ListData listMarker = ListBlockParser.parseListMarker(listOptions, listOptions.getCodeIndent(), parserState);
            if (indent >= contentIndent) {
                if (listMarker == null) {
                    if (this.myIsEmpty) {
                        listBlockParser.setItemHandledLine(parserState.getLine());
                        return BlockContinue.none();
                    }
                    listBlockParser.setItemHandledLine(parserState.getLine());
                    return continueAtColumn(column);
                }
                BlockParser activeBlockParser = parserState.getActiveBlockParser();
                if (activeBlockParser.isParagraphParser() && (activeBlockParser.getBlock().getParent() instanceof ListItem) && activeBlockParser.getBlock() == activeBlockParser.getBlock().getParent().getFirstChild() && (!this.myOptions.canInterrupt(listMarker.listBlock, listMarker.isEmpty, true) || !this.myOptions.canStartSubList(listMarker.listBlock, listMarker.isEmpty))) {
                    listBlockParser.setItemHandledLineSkipActive(parserState.getLine());
                    return continueAtColumn(column);
                }
                listBlockParser.setItemHandledNewListLine(parserState.getLine());
                return continueAtColumn(column);
            }
            if (listMarker != null) {
                if (!this.myHadBlankLine && !this.myOptions.canInterrupt(listMarker.listBlock, listMarker.isEmpty, true)) {
                    listBlockParser.setItemHandledLine(parserState.getLine());
                    return continueAtColumn(parserState.getColumn() + indent);
                }
                if (!(this.myOptions.isItemTypeMismatchToNewList() && this.myOptions.isItemTypeMismatchToSubList() && this.myHadBlankLine) && this.myOptions.startSubList(listBlockParser.getBlock(), listMarker.listBlock)) {
                    listBlockParser.setItemHandledNewListLine(parserState.getLine());
                    return continueAtColumn(parserState.getColumn() + indent);
                }
                if (this.myOptions.startNewList(listBlockParser.getBlock(), listMarker.listBlock)) {
                    listBlockParser.setItemHandledNewListLine(parserState.getLine());
                    return BlockContinue.none();
                }
                listBlockParser.setItemHandledNewItemLine(parserState.getLine());
                return BlockContinue.none();
            }
        } else {
            int itemIndent = this.myOptions.getItemIndent();
            if (parserEmulationProfile2 == ParserEmulationProfile.FIXED_INDENT) {
                int indent2 = parserState.getIndent();
                int column2 = parserState.getColumn() + itemIndent;
                if (indent2 >= this.myOptions.getCodeIndent()) {
                    if (this.myBlock.getFirstChild() != null && this.myBlock.getFirstChild() == this.myBlock.getLastChild()) {
                        BlockParser activeBlockParser2 = parserState.getActiveBlockParser();
                        if (activeBlockParser2.isParagraphParser() && activeBlockParser2.getBlock() == this.myBlock.getFirstChild()) {
                            listBlockParser.setItemHandledLineSkipActive(parserState.getLine());
                            return continueAtColumn(column2);
                        }
                    }
                    listBlockParser.setItemHandledLine(parserState.getLine());
                    return continueAtColumn(column2);
                }
                ListBlockParser.ListData listMarker2 = ListBlockParser.parseListMarker(this.myOptions, -1, parserState);
                if (indent2 >= itemIndent) {
                    if (listMarker2 == null) {
                        if (this.myIsEmpty) {
                            listBlockParser.setItemHandledLine(parserState.getLine());
                            return BlockContinue.none();
                        }
                        listBlockParser.setItemHandledLine(parserState.getLine());
                        return continueAtColumn(column2);
                    }
                    BlockParser activeBlockParser3 = parserState.getActiveBlockParser();
                    if (activeBlockParser3.isParagraphParser() && (activeBlockParser3.getBlock().getParent() instanceof ListItem) && activeBlockParser3.getBlock() == activeBlockParser3.getBlock().getParent().getFirstChild() && (!this.myOptions.canInterrupt(listMarker2.listBlock, listMarker2.isEmpty, true) || !this.myOptions.canStartSubList(listMarker2.listBlock, listMarker2.isEmpty))) {
                        listBlockParser.setItemHandledLineSkipActive(parserState.getLine());
                        return continueAtColumn(parserState.getColumn() + indent2);
                    }
                    listBlockParser.setItemHandledNewListLine(parserState.getLine());
                    return continueAtColumn(column2);
                }
                if (listMarker2 != null) {
                    if (!this.myHadBlankLine && !this.myOptions.canInterrupt(listMarker2.listBlock, listMarker2.isEmpty, true)) {
                        listBlockParser.setItemHandledLine(parserState.getLine());
                        return continueAtColumn(parserState.getColumn() + indent2);
                    }
                    if (!(this.myOptions.isItemTypeMismatchToNewList() && this.myOptions.isItemTypeMismatchToSubList() && this.myHadBlankLine) && this.myOptions.startSubList(listBlockParser.getBlock(), listMarker2.listBlock)) {
                        listBlockParser.setItemHandledNewListLine(parserState.getLine());
                        return continueAtColumn(parserState.getColumn() + indent2);
                    }
                    if (this.myOptions.startNewList(listBlockParser.getBlock(), listMarker2.listBlock)) {
                        listBlockParser.setItemHandledNewListLine(parserState.getLine());
                        return BlockContinue.none();
                    }
                    listBlockParser.setItemHandledNewItemLine(parserState.getLine());
                    return BlockContinue.none();
                }
            } else {
                int i = listBlockParser.getListData().markerIndent;
                if (parserEmulationProfile2 == ParserEmulationProfile.KRAMDOWN) {
                    int indent3 = parserState.getIndent();
                    int column3 = parserState.getColumn() + contentIndent;
                    ListBlockParser.ListData listMarker3 = ListBlockParser.parseListMarker(this.myOptions, -1, parserState);
                    if (indent3 >= contentIndent) {
                        if (listMarker3 == null) {
                            if (this.myIsEmpty) {
                                listBlockParser.setItemHandledLine(parserState.getLine());
                                return BlockContinue.none();
                            }
                            listBlockParser.setItemHandledLine(parserState.getLine());
                            return continueAtColumn(column3);
                        }
                        BlockParser activeBlockParser4 = parserState.getActiveBlockParser();
                        if (activeBlockParser4.isParagraphParser() && (activeBlockParser4.getBlock().getParent() instanceof ListItem) && activeBlockParser4.getBlock() == activeBlockParser4.getBlock().getParent().getFirstChild() && (!this.myOptions.canInterrupt(listMarker3.listBlock, listMarker3.isEmpty, true) || !this.myOptions.canStartSubList(listMarker3.listBlock, listMarker3.isEmpty))) {
                            listBlockParser.setItemHandledLineSkipActive(parserState.getLine());
                            return continueAtColumn(column3);
                        }
                        listBlockParser.setItemHandledNewListLine(parserState.getLine());
                        return continueAtColumn(column3);
                    }
                    if (indent3 >= itemIndent + i) {
                        if (!this.myHadBlankLine) {
                            listBlockParser.setItemHandledLineSkipActive(parserState.getLine());
                            return continueAtColumn(parserState.getColumn() + indent3);
                        }
                        if (this.myBlock.isHadBlankAfterItemParagraph()) {
                            this.myBlock.setLoose(true);
                        }
                        listBlockParser.setItemHandledLineSkipActive(parserState.getLine());
                        return BlockContinue.none();
                    }
                    if (listMarker3 != null && indent3 >= i) {
                        if (!(this.myOptions.isItemTypeMismatchToNewList() && this.myOptions.isItemTypeMismatchToSubList() && this.myHadBlankLine) && this.myOptions.startSubList(listBlockParser.getBlock(), listMarker3.listBlock)) {
                            listBlockParser.setItemHandledNewListLine(parserState.getLine());
                            return continueAtColumn(parserState.getColumn() + indent3);
                        }
                        if (this.myOptions.startNewList(listBlockParser.getBlock(), listMarker3.listBlock)) {
                            listBlockParser.setItemHandledNewListLine(parserState.getLine());
                            return BlockContinue.none();
                        }
                        listBlockParser.setItemHandledNewItemLine(parserState.getLine());
                        return BlockContinue.none();
                    }
                } else if (parserEmulationProfile == ParserEmulationProfile.GITHUB_DOC) {
                    int indent4 = parserState.getIndent();
                    parserState.getIndex();
                    int iMaxLimit = Utils.maxLimit(indent4, contentIndent, i + 4);
                    if (indent4 >= this.myOptions.getCodeIndent()) {
                        listBlockParser.setItemHandledLine(parserState.getLine());
                        return continueAtColumn(Utils.maxLimit(contentIndent, itemIndent) + parserState.getColumn());
                    }
                    ListBlockParser.ListData listMarker4 = ListBlockParser.parseListMarker(this.myOptions, -1, parserState);
                    if (indent4 > itemIndent) {
                        if (listMarker4 == null) {
                            listBlockParser.setItemHandledLine(parserState.getLine());
                            return continueAtColumn(parserState.getColumn() + itemIndent);
                        }
                        BlockParser activeBlockParser5 = parserState.getActiveBlockParser();
                        if (activeBlockParser5.isParagraphParser() && (activeBlockParser5.getBlock().getParent() instanceof ListItem) && activeBlockParser5.getBlock() == activeBlockParser5.getBlock().getParent().getFirstChild() && (!this.myOptions.canInterrupt(listMarker4.listBlock, listMarker4.isEmpty, true) || !this.myOptions.canStartSubList(listMarker4.listBlock, listMarker4.isEmpty))) {
                            listBlockParser.setItemHandledLineSkipActive(parserState.getLine());
                            return continueAtColumn(parserState.getColumn() + indent4);
                        }
                        listBlockParser.setItemHandledNewListLine(parserState.getLine());
                        return continueAtColumn(parserState.getColumn() + iMaxLimit);
                    }
                    if (indent4 > i) {
                        if (listMarker4 == null) {
                            listBlockParser.setItemHandledLine(parserState.getLine());
                            return continueAtColumn(parserState.getColumn() + iMaxLimit);
                        }
                        BlockParser activeBlockParser6 = parserState.getActiveBlockParser();
                        if (activeBlockParser6.isParagraphParser() && (activeBlockParser6.getBlock().getParent() instanceof ListItem) && activeBlockParser6.getBlock() == activeBlockParser6.getBlock().getParent().getFirstChild() && (!this.myOptions.canInterrupt(listMarker4.listBlock, listMarker4.isEmpty, true) || !this.myOptions.canStartSubList(listMarker4.listBlock, listMarker4.isEmpty))) {
                            listBlockParser.setItemHandledLineSkipActive(parserState.getLine());
                            return continueAtColumn(parserState.getColumn() + indent4);
                        }
                        listBlockParser.setItemHandledNewListLine(parserState.getLine());
                        return continueAtColumn(parserState.getColumn() + iMaxLimit);
                    }
                    if (listMarker4 != null) {
                        if (!(this.myOptions.isItemTypeMismatchToNewList() && this.myOptions.isItemTypeMismatchToSubList() && this.myHadBlankLine) && this.myOptions.startSubList(listBlockParser.getBlock(), listMarker4.listBlock)) {
                            listBlockParser.setItemHandledNewListLine(parserState.getLine());
                            return continueAtColumn(parserState.getColumn() + iMaxLimit);
                        }
                        if (this.myOptions.startNewList(listBlockParser.getBlock(), listMarker4.listBlock)) {
                            listBlockParser.setItemHandledNewListLine(parserState.getLine());
                            return BlockContinue.none();
                        }
                        BlockParser activeBlockParser7 = parserState.getActiveBlockParser();
                        if (activeBlockParser7.isParagraphParser() && (activeBlockParser7.getBlock().getParent() instanceof ListItem) && activeBlockParser7.getBlock() == activeBlockParser7.getBlock().getParent().getFirstChild() && (!this.myOptions.canInterrupt(listMarker4.listBlock, listMarker4.isEmpty, true) || !this.myOptions.canStartSubList(listMarker4.listBlock, listMarker4.isEmpty))) {
                            listBlockParser.setItemHandledLineSkipActive(parserState.getLine());
                            return continueAtColumn(parserState.getColumn() + indent4);
                        }
                        listBlockParser.setItemHandledNewItemLine(parserState.getLine());
                        return BlockContinue.none();
                    }
                    if (!this.myHadBlankLine || (parserState.getActiveBlockParser() instanceof FencedCodeBlockParser)) {
                        listBlockParser.setItemHandledLine(parserState.getLine());
                        return continueAtColumn(parserState.getColumn() + indent4);
                    }
                } else if (parserEmulationProfile2 == ParserEmulationProfile.MARKDOWN) {
                    int indent5 = parserState.getIndent();
                    if (indent5 >= this.myOptions.getCodeIndent()) {
                        listBlockParser.setItemHandledLine(parserState.getLine());
                        return continueAtColumn(parserState.getColumn() + itemIndent);
                    }
                    ListBlockParser.ListData listMarker5 = ListBlockParser.parseListMarker(this.myOptions, -1, parserState);
                    if (indent5 > itemIndent) {
                        if (listMarker5 == null) {
                            listBlockParser.setItemHandledLine(parserState.getLine());
                            return continueAtColumn(parserState.getColumn() + itemIndent);
                        }
                        BlockParser activeBlockParser8 = parserState.getActiveBlockParser();
                        if (activeBlockParser8.isParagraphParser() && (activeBlockParser8.getBlock().getParent() instanceof ListItem) && activeBlockParser8.getBlock() == activeBlockParser8.getBlock().getParent().getFirstChild() && (!this.myOptions.canInterrupt(listMarker5.listBlock, listMarker5.isEmpty, true) || !this.myOptions.canStartSubList(listMarker5.listBlock, listMarker5.isEmpty))) {
                            listBlockParser.setItemHandledLineSkipActive(parserState.getLine());
                            return continueAtColumn(parserState.getColumn() + indent5);
                        }
                        listBlockParser.setItemHandledNewListLine(parserState.getLine());
                        return continueAtColumn(parserState.getColumn() + itemIndent);
                    }
                    if (indent5 > i) {
                        if (listMarker5 == null) {
                            listBlockParser.setItemHandledLine(parserState.getLine());
                            return continueAtColumn(parserState.getColumn() + indent5);
                        }
                        BlockParser activeBlockParser9 = parserState.getActiveBlockParser();
                        if (activeBlockParser9.isParagraphParser() && (activeBlockParser9.getBlock().getParent() instanceof ListItem) && activeBlockParser9.getBlock() == activeBlockParser9.getBlock().getParent().getFirstChild() && (!this.myOptions.canInterrupt(listMarker5.listBlock, listMarker5.isEmpty, true) || !this.myOptions.canStartSubList(listMarker5.listBlock, listMarker5.isEmpty))) {
                            listBlockParser.setItemHandledLineSkipActive(parserState.getLine());
                            return continueAtColumn(parserState.getColumn() + indent5);
                        }
                        listBlockParser.setItemHandledNewListLine(parserState.getLine());
                        return continueAtColumn(parserState.getColumn() + indent5);
                    }
                    if (listMarker5 != null) {
                        if (!(this.myOptions.isItemTypeMismatchToNewList() && this.myOptions.isItemTypeMismatchToSubList() && this.myHadBlankLine) && this.myOptions.startSubList(listBlockParser.getBlock(), listMarker5.listBlock)) {
                            listBlockParser.setItemHandledNewListLine(parserState.getLine());
                            return continueAtColumn(parserState.getColumn() + indent5);
                        }
                        if (this.myOptions.startNewList(listBlockParser.getBlock(), listMarker5.listBlock)) {
                            listBlockParser.setItemHandledNewListLine(parserState.getLine());
                            return BlockContinue.none();
                        }
                        BlockParser activeBlockParser10 = parserState.getActiveBlockParser();
                        if (activeBlockParser10.isParagraphParser() && (activeBlockParser10.getBlock().getParent() instanceof ListItem) && activeBlockParser10.getBlock() == activeBlockParser10.getBlock().getParent().getFirstChild() && (!this.myOptions.canInterrupt(listMarker5.listBlock, listMarker5.isEmpty, true) || !this.myOptions.canStartSubList(listMarker5.listBlock, listMarker5.isEmpty))) {
                            listBlockParser.setItemHandledLineSkipActive(parserState.getLine());
                            return continueAtColumn(parserState.getColumn() + indent5);
                        }
                        listBlockParser.setItemHandledNewItemLine(parserState.getLine());
                        return BlockContinue.none();
                    }
                }
            }
        }
        return BlockContinue.none();
    }
}
