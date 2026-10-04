package com.vladsch.flexmark.parser.core;

import com.vladsch.flexmark.ast.BlockQuote;
import com.vladsch.flexmark.ast.ListItem;
import com.vladsch.flexmark.ast.util.Parsing;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.parser.block.AbstractBlockParser;
import com.vladsch.flexmark.parser.block.AbstractBlockParserFactory;
import com.vladsch.flexmark.parser.block.BlockContinue;
import com.vladsch.flexmark.parser.block.BlockParser;
import com.vladsch.flexmark.parser.block.BlockParserFactory;
import com.vladsch.flexmark.parser.block.BlockStart;
import com.vladsch.flexmark.parser.block.CustomBlockParserFactory;
import com.vladsch.flexmark.parser.block.MatchedBlockParser;
import com.vladsch.flexmark.parser.block.ParserState;
import com.vladsch.flexmark.parser.core.FencedCodeBlockParser;
import com.vladsch.flexmark.parser.core.HeadingParser;
import com.vladsch.flexmark.parser.core.HtmlBlockParser;
import com.vladsch.flexmark.parser.core.IndentedCodeBlockParser;
import com.vladsch.flexmark.parser.core.ListBlockParser;
import com.vladsch.flexmark.parser.core.ThematicBreakParser;
import com.vladsch.flexmark.util.ast.Block;
import com.vladsch.flexmark.util.data.DataHolder;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import com.vladsch.flexmark.util.sequence.mappers.SpecialLeadInHandler;
import com.vladsch.flexmark.util.sequence.mappers.SpecialLeadInStartsWithCharsHandler;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class BlockQuoteParser extends AbstractBlockParser {
    public static final char MARKER_CHAR = '>';
    private final boolean allowLeadingSpace;
    private final BlockQuote block;
    private final boolean continueToBlankLine;
    private final boolean ignoreBlankLine;
    private final boolean interruptsItemParagraph;
    private final boolean interruptsParagraph;
    private int lastWasBlankLine;
    private final boolean withLeadSpacesInterruptsItemParagraph;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class BlockFactory extends AbstractBlockParserFactory {
        private final boolean allowLeadingSpace;
        private final boolean interruptsItemParagraph;
        private final boolean interruptsParagraph;
        private final boolean withLeadSpacesInterruptsItemParagraph;

        public BlockFactory(DataHolder dataHolder) {
            super(dataHolder);
            this.allowLeadingSpace = Parser.BLOCK_QUOTE_ALLOW_LEADING_SPACE.get(dataHolder).booleanValue();
            this.interruptsParagraph = Parser.BLOCK_QUOTE_INTERRUPTS_PARAGRAPH.get(dataHolder).booleanValue();
            this.interruptsItemParagraph = Parser.BLOCK_QUOTE_INTERRUPTS_ITEM_PARAGRAPH.get(dataHolder).booleanValue();
            this.withLeadSpacesInterruptsItemParagraph = Parser.BLOCK_QUOTE_WITH_LEAD_SPACES_INTERRUPTS_ITEM_PARAGRAPH.get(dataHolder).booleanValue();
        }

        @Override // com.vladsch.flexmark.parser.block.BlockParserFactory
        public BlockStart tryStart(ParserState parserState, MatchedBlockParser matchedBlockParser) {
            int nextNonSpaceIndex = parserState.getNextNonSpaceIndex();
            BlockParser blockParser = matchedBlockParser.getBlockParser();
            boolean zIsParagraphParser = blockParser.isParagraphParser();
            if (!BlockQuoteParser.isMarker(parserState, nextNonSpaceIndex, zIsParagraphParser, zIsParagraphParser && (blockParser.getBlock().getParent() instanceof ListItem) && blockParser.getBlock() == blockParser.getBlock().getParent().getFirstChild(), this.allowLeadingSpace, this.interruptsParagraph, this.interruptsItemParagraph, this.withLeadSpacesInterruptsItemParagraph)) {
                return BlockStart.none();
            }
            int indent = parserState.getIndent() + parserState.getColumn();
            int i = indent + 1;
            int i2 = nextNonSpaceIndex + 1;
            if (Parsing.isSpaceOrTab(parserState.getLine(), i2)) {
                i = indent + 2;
            }
            return BlockStart.m13315of(new BlockQuoteParser(parserState.getProperties(), parserState.getLine().subSequence(nextNonSpaceIndex, i2))).atColumn(i);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class BlockQuoteLeadInHandler {
        static final SpecialLeadInHandler HANDLER = SpecialLeadInStartsWithCharsHandler.create('>');
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
            return Collections.EMPTY_SET;
        }

        @Override // com.vladsch.flexmark.util.dependency.Dependent
        @Nullable
        public Set<Class<?>> getBeforeDependents() {
            return new HashSet(Arrays.asList(HeadingParser.Factory.class, FencedCodeBlockParser.Factory.class, HtmlBlockParser.Factory.class, ThematicBreakParser.Factory.class, ListBlockParser.Factory.class, IndentedCodeBlockParser.Factory.class));
        }

        @Override // com.vladsch.flexmark.parser.block.CustomBlockParserFactory
        @Nullable
        public SpecialLeadInHandler getLeadInHandler(@NotNull DataHolder dataHolder) {
            return BlockQuoteLeadInHandler.HANDLER;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.vladsch.flexmark.parser.block.CustomBlockParserFactory, java.util.function.Function
        @NotNull
        public BlockParserFactory apply(@NotNull DataHolder dataHolder) {
            return new BlockFactory(dataHolder);
        }
    }

    public BlockQuoteParser(DataHolder dataHolder, BasedSequence basedSequence) {
        BlockQuote blockQuote = new BlockQuote();
        this.block = blockQuote;
        this.lastWasBlankLine = 0;
        blockQuote.setOpeningMarker(basedSequence);
        this.continueToBlankLine = Parser.BLOCK_QUOTE_EXTEND_TO_BLANK_LINE.get(dataHolder).booleanValue();
        this.allowLeadingSpace = Parser.BLOCK_QUOTE_ALLOW_LEADING_SPACE.get(dataHolder).booleanValue();
        this.ignoreBlankLine = Parser.BLOCK_QUOTE_IGNORE_BLANK_LINE.get(dataHolder).booleanValue();
        this.interruptsParagraph = Parser.BLOCK_QUOTE_INTERRUPTS_PARAGRAPH.get(dataHolder).booleanValue();
        this.interruptsItemParagraph = Parser.BLOCK_QUOTE_INTERRUPTS_ITEM_PARAGRAPH.get(dataHolder).booleanValue();
        this.withLeadSpacesInterruptsItemParagraph = Parser.BLOCK_QUOTE_WITH_LEAD_SPACES_INTERRUPTS_ITEM_PARAGRAPH.get(dataHolder).booleanValue();
    }

    public static boolean isMarker(ParserState parserState, int i, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        BasedSequence line = parserState.getLine();
        if ((!z || z4) && i < line.length() && line.charAt(i) == '>' && ((z3 || parserState.getIndent() == 0) && (!z2 || z5))) {
            if (z2 && !z6) {
                return parserState.getIndent() == 0;
            }
            if (parserState.getIndent() < parserState.getParsing().CODE_BLOCK_INDENT) {
                return true;
            }
        }
        return false;
    }

    @Override // com.vladsch.flexmark.parser.block.AbstractBlockParser, com.vladsch.flexmark.parser.block.BlockParser
    public boolean canContain(ParserState parserState, BlockParser blockParser, Block block) {
        return true;
    }

    @Override // com.vladsch.flexmark.parser.block.BlockParser
    public void closeBlock(ParserState parserState) {
        this.block.setCharsFromContent();
        if (Parser.BLANK_LINES_IN_AST.get(parserState.getProperties()).booleanValue()) {
            return;
        }
        removeBlankLines();
    }

    @Override // com.vladsch.flexmark.parser.block.AbstractBlockParser, com.vladsch.flexmark.parser.block.BlockParser
    public boolean isContainer() {
        return true;
    }

    @Override // com.vladsch.flexmark.parser.block.AbstractBlockParser, com.vladsch.flexmark.parser.block.BlockParser
    public boolean isPropagatingLastBlankLine(BlockParser blockParser) {
        return false;
    }

    @Override // com.vladsch.flexmark.parser.block.BlockParser
    public BlockContinue tryContinue(ParserState parserState) {
        ParserState parserState2;
        int nextNonSpaceIndex = parserState.getNextNonSpaceIndex();
        if (parserState.isBlank()) {
            parserState2 = parserState;
        } else {
            parserState2 = parserState;
            boolean zIsMarker = isMarker(parserState2, nextNonSpaceIndex, false, false, this.allowLeadingSpace, this.interruptsParagraph, this.interruptsItemParagraph, this.withLeadSpacesInterruptsItemParagraph);
            if (zIsMarker || (this.continueToBlankLine && this.lastWasBlankLine == 0)) {
                int indent = parserState2.getIndent() + parserState2.getColumn();
                this.lastWasBlankLine = 0;
                if (zIsMarker) {
                    indent = Parsing.isSpaceOrTab(parserState2.getLine(), nextNonSpaceIndex + 1) ? indent + 2 : indent + 1;
                }
                return BlockContinue.atColumn(indent);
            }
        }
        if (!this.ignoreBlankLine || !parserState2.isBlank()) {
            return BlockContinue.none();
        }
        this.lastWasBlankLine++;
        return BlockContinue.atColumn(parserState2.getIndent() + parserState2.getColumn());
    }

    @Override // com.vladsch.flexmark.parser.block.BlockParser
    public BlockQuote getBlock() {
        return this.block;
    }
}
