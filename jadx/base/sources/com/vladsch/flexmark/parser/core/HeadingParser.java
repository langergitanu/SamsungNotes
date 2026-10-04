package com.vladsch.flexmark.parser.core;

import com.vladsch.flexmark.ast.Heading;
import com.vladsch.flexmark.ast.ListItem;
import com.vladsch.flexmark.ast.util.Parsing;
import com.vladsch.flexmark.parser.InlineParser;
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
import com.vladsch.flexmark.parser.core.BlockQuoteParser;
import com.vladsch.flexmark.parser.core.FencedCodeBlockParser;
import com.vladsch.flexmark.parser.core.HtmlBlockParser;
import com.vladsch.flexmark.parser.core.IndentedCodeBlockParser;
import com.vladsch.flexmark.parser.core.ListBlockParser;
import com.vladsch.flexmark.parser.core.ThematicBreakParser;
import com.vladsch.flexmark.util.ast.Block;
import com.vladsch.flexmark.util.ast.BlockContent;
import com.vladsch.flexmark.util.data.DataHolder;
import com.vladsch.flexmark.util.data.DataKey;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import com.vladsch.flexmark.util.sequence.mappers.SpecialLeadInCharsHandler;
import com.vladsch.flexmark.util.sequence.mappers.SpecialLeadInHandler;
import com.vladsch.flexmark.util.sequence.mappers.SpecialLeadInStartsWithCharsHandler;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class HeadingParser extends AbstractBlockParser {
    final Heading block;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class BlockFactory extends AbstractBlockParserFactory {
        private final HeadingParsing myParsing;
        private final HeadingOptions options;

        public BlockFactory(DataHolder dataHolder) {
            super(dataHolder);
            this.options = new HeadingOptions(dataHolder);
            this.myParsing = new HeadingParsing(dataHolder);
        }

        @Override // com.vladsch.flexmark.parser.block.BlockParserFactory
        public BlockStart tryStart(ParserState parserState, MatchedBlockParser matchedBlockParser) {
            BasedSequence basedSequenceTrim;
            if (parserState.getIndent() >= 4 || (this.options.noLeadSpace && parserState.getIndent() >= 1)) {
                return BlockStart.none();
            }
            if (parserState.getActiveBlockParser() instanceof FencedCodeBlockParser) {
                return BlockStart.none();
            }
            if (!this.options.canInterruptItemParagraph) {
                BlockParser blockParser = matchedBlockParser.getBlockParser();
                if (blockParser.isParagraphParser() && (blockParser.getBlock().getParent() instanceof ListItem) && blockParser.getBlock() == blockParser.getBlock().getParent().getFirstChild()) {
                    return BlockStart.none();
                }
            }
            BasedSequence line = parserState.getLine();
            int nextNonSpaceIndex = parserState.getNextNonSpaceIndex();
            BasedSequence paragraphContent = matchedBlockParser.getParagraphContent();
            BasedSequence basedSequenceSubSequence = line.subSequence(nextNonSpaceIndex, line.length());
            Matcher matcher = this.myParsing.ATX_HEADING.matcher(basedSequenceSubSequence);
            if (!matcher.find()) {
                Matcher matcher2 = this.myParsing.SETEXT_HEADING.matcher(basedSequenceSubSequence);
                if (!matcher2.find()) {
                    return BlockStart.none();
                }
                if (paragraphContent == null) {
                    return BlockStart.none();
                }
                int i = matcher2.group(0).charAt(0) == '=' ? 1 : 2;
                BlockContent blockContent = new BlockContent();
                blockContent.addAll(matchedBlockParser.getParagraphLines(), matchedBlockParser.getParagraphEolLengths());
                BasedSequence basedSequenceTrim2 = blockContent.getContents().trim();
                BasedSequence basedSequenceTrim3 = line.trim();
                HeadingParser headingParser = new HeadingParser(i);
                headingParser.block.setText(basedSequenceTrim2);
                headingParser.block.setClosingMarker(basedSequenceTrim3);
                headingParser.block.setCharsFromContent();
                return BlockStart.m13315of(headingParser).atIndex(line.length()).replaceActiveBlockParser();
            }
            int length = matcher.group(0).length() + nextNonSpaceIndex;
            int iStart = matcher.start();
            int iEnd = matcher.end();
            BasedSequence basedSequenceTrim4 = basedSequenceSubSequence.subSequence(iStart, iEnd).trim();
            int length2 = basedSequenceTrim4.length();
            new BlockContent().add(parserState.getLineWithEOL().subSequence(length), parserState.getIndent());
            BasedSequence basedSequenceSubSequence2 = basedSequenceSubSequence.subSequence(iEnd);
            Matcher matcher3 = this.myParsing.ATX_TRAILING.matcher(basedSequenceSubSequence2);
            if (matcher3.find()) {
                int iStart2 = matcher3.start();
                basedSequenceTrim = basedSequenceSubSequence2.subSequence(iStart2, matcher3.end()).trim();
                basedSequenceSubSequence2 = basedSequenceSubSequence2.subSequence(0, iStart2);
            } else {
                basedSequenceTrim = null;
            }
            HeadingParser headingParser2 = new HeadingParser(length2);
            headingParser2.block.setOpeningMarker(basedSequenceTrim4);
            headingParser2.block.setText(basedSequenceSubSequence2.trim());
            headingParser2.block.setClosingMarker(basedSequenceTrim);
            headingParser2.block.setCharsFromContent();
            return BlockStart.m13315of(headingParser2).atIndex(line.length());
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
            HashSet hashSet = new HashSet();
            hashSet.add(BlockQuoteParser.Factory.class);
            return hashSet;
        }

        @Override // com.vladsch.flexmark.util.dependency.Dependent
        @Nullable
        public Set<Class<?>> getBeforeDependents() {
            return new HashSet(Arrays.asList(FencedCodeBlockParser.Factory.class, HtmlBlockParser.Factory.class, ThematicBreakParser.Factory.class, ListBlockParser.Factory.class, IndentedCodeBlockParser.Factory.class));
        }

        @Override // com.vladsch.flexmark.parser.block.CustomBlockParserFactory
        @Nullable
        public SpecialLeadInHandler getLeadInHandler(@NotNull DataHolder dataHolder) {
            return (Parser.ESCAPE_HEADING_NO_ATX_SPACE.get(dataHolder).booleanValue() || Parser.HEADING_NO_ATX_SPACE.get(dataHolder).booleanValue()) ? HeadingLeadInHandler.HANDLER_NO_SPACE : HeadingLeadInHandler.HANDLER_SPACE;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.vladsch.flexmark.parser.block.CustomBlockParserFactory, java.util.function.Function
        @NotNull
        public BlockParserFactory apply(@NotNull DataHolder dataHolder) {
            return new BlockFactory(dataHolder);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class HeadingLeadInHandler {
        static final SpecialLeadInHandler HANDLER_NO_SPACE = SpecialLeadInStartsWithCharsHandler.create('#');
        static final SpecialLeadInHandler HANDLER_SPACE = SpecialLeadInCharsHandler.create('#');
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class HeadingOptions {
        final boolean canInterruptItemParagraph;
        final boolean noAtxSpace;
        final boolean noEmptyHeadingWithoutSpace;
        final boolean noLeadSpace;
        final int setextMarkerLength;

        public HeadingOptions(DataHolder dataHolder) {
            this.noAtxSpace = Parser.HEADING_NO_ATX_SPACE.get(dataHolder).booleanValue();
            this.noEmptyHeadingWithoutSpace = Parser.HEADING_NO_EMPTY_HEADING_WITHOUT_SPACE.get(dataHolder).booleanValue();
            this.noLeadSpace = Parser.HEADING_NO_LEAD_SPACE.get(dataHolder).booleanValue();
            this.canInterruptItemParagraph = Parser.HEADING_CAN_INTERRUPT_ITEM_PARAGRAPH.get(dataHolder).booleanValue();
            this.setextMarkerLength = Parser.HEADING_SETEXT_MARKER_LENGTH.get(dataHolder).intValue();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class HeadingParsing extends Parsing {
        private final Pattern ATX_HEADING;
        private final Pattern ATX_TRAILING;
        private final Pattern SETEXT_HEADING;

        public HeadingParsing(DataHolder dataHolder) {
            String str;
            super(dataHolder);
            DataKey<Boolean> dataKey = Parser.HEADING_NO_ATX_SPACE;
            this.ATX_HEADING = Pattern.compile(dataKey.get(dataHolder).booleanValue() ? "^#{1,6}(?:[ \t]*|$)" : Parser.HEADING_NO_EMPTY_HEADING_WITHOUT_SPACE.get(dataHolder).booleanValue() ? "^#{1,6}(?:[ \t]*(?=[^ \t#])|[ \t]+$)" : "^#{1,6}(?:[ \t]+|$)");
            this.ATX_TRAILING = Pattern.compile(dataKey.get(dataHolder).booleanValue() ? "[ \t]*#+[ \t]*$" : "(^| |\t)[ \t]*#+[ \t]*$");
            int iIntValue = Parser.HEADING_SETEXT_MARKER_LENGTH.get(dataHolder).intValue();
            if (iIntValue <= 1) {
                str = "^(?:=+|-+)[ \t]*$";
            } else {
                str = "^(?:={" + iIntValue + ",}|-{" + iIntValue + ",})[ \t]*$";
            }
            this.SETEXT_HEADING = Pattern.compile(str);
        }
    }

    public HeadingParser(int i) {
        Heading heading = new Heading();
        this.block = heading;
        heading.setLevel(i);
    }

    @Override // com.vladsch.flexmark.parser.block.BlockParser
    public void closeBlock(ParserState parserState) {
    }

    @Override // com.vladsch.flexmark.parser.block.BlockParser
    public Block getBlock() {
        return this.block;
    }

    @Override // com.vladsch.flexmark.parser.block.AbstractBlockParser, com.vladsch.flexmark.parser.block.BlockParser
    public void parseInlines(InlineParser inlineParser) {
        inlineParser.parse(this.block.getText(), this.block);
    }

    @Override // com.vladsch.flexmark.parser.block.BlockParser
    public BlockContinue tryContinue(ParserState parserState) {
        return BlockContinue.none();
    }
}
