package com.vladsch.flexmark.parser.core;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.glance.AbstractC2821a;
import com.vladsch.flexmark.ast.HtmlBlock;
import com.vladsch.flexmark.ast.HtmlBlockBase;
import com.vladsch.flexmark.ast.HtmlCommentBlock;
import com.vladsch.flexmark.ast.HtmlInnerBlock;
import com.vladsch.flexmark.ast.HtmlInnerBlockComment;
import com.vladsch.flexmark.ast.Paragraph;
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
import com.vladsch.flexmark.parser.core.BlockQuoteParser;
import com.vladsch.flexmark.parser.core.FencedCodeBlockParser;
import com.vladsch.flexmark.parser.core.HeadingParser;
import com.vladsch.flexmark.parser.core.IndentedCodeBlockParser;
import com.vladsch.flexmark.parser.core.ListBlockParser;
import com.vladsch.flexmark.parser.core.ThematicBreakParser;
import com.vladsch.flexmark.parser.internal.HtmlDeepParser;
import com.vladsch.flexmark.util.ast.Block;
import com.vladsch.flexmark.util.ast.BlockContent;
import com.vladsch.flexmark.util.data.DataHolder;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class HtmlBlockParser extends AbstractBlockParser {
    public static final String HTML_COMMENT_CLOSE = "-->";
    public static final String HTML_COMMENT_OPEN = "<!--";
    private final HtmlBlockBase block;
    private final Pattern closingPattern;
    private final HtmlDeepParser deepParser;
    private final boolean myHtmlBlockDeepParseBlankLineInterrupts;
    private final boolean myHtmlBlockDeepParseBlankLineInterruptsPartialTag;
    private final boolean myHtmlBlockDeepParseIndentedCodeInterrupts;
    private final boolean myHtmlBlockDeepParseMarkdownInterruptsClosed;
    private final boolean myHtmlBlockDeepParseNonBlock;
    private final boolean parseInnerHtmlComments;
    private boolean finished = false;
    private BlockContent content = new BlockContent();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class BlockFactory extends AbstractBlockParserFactory {
        private final boolean myHtmlBlockCommentOnlyFullLine;
        private final boolean myHtmlBlockDeepParseFirstOpenTagOnOneLine;
        private final boolean myHtmlBlockDeepParseNonBlock;
        private final boolean myHtmlBlockDeepParser;
        private final boolean myHtmlBlockStartOnlyOnBlockTags;
        private final boolean myHtmlCommentBlocksInterruptParagraph;
        private Patterns myPatterns;

        public /* synthetic */ BlockFactory(DataHolder dataHolder, int i) {
            this(dataHolder);
        }

        @Override // com.vladsch.flexmark.parser.block.BlockParserFactory
        public BlockStart tryStart(ParserState parserState, MatchedBlockParser matchedBlockParser) {
            int nextNonSpaceIndex = parserState.getNextNonSpaceIndex();
            BasedSequence line = parserState.getLine();
            if (parserState.getIndent() < 4 && line.charAt(nextNonSpaceIndex) == '<' && !(matchedBlockParser.getBlockParser() instanceof HtmlBlockParser)) {
                if (this.myHtmlBlockDeepParser) {
                    HtmlDeepParser htmlDeepParser = new HtmlDeepParser(Parser.HTML_BLOCK_TAGS.get(parserState.getProperties()));
                    htmlDeepParser.parseHtmlChunk(line.subSequence(nextNonSpaceIndex, line.length()), this.myHtmlBlockStartOnlyOnBlockTags, this.myHtmlBlockDeepParseNonBlock, this.myHtmlBlockDeepParseFirstOpenTagOnOneLine);
                    if (htmlDeepParser.hadHtml() && ((htmlDeepParser.getHtmlMatch() != HtmlDeepParser.HtmlMatch.OPEN_TAG && (this.myHtmlCommentBlocksInterruptParagraph || htmlDeepParser.getHtmlMatch() != HtmlDeepParser.HtmlMatch.COMMENT)) || htmlDeepParser.isFirstBlockTag() || !(matchedBlockParser.getBlockParser().getBlock() instanceof Paragraph))) {
                        return BlockStart.m13315of(new HtmlBlockParser(parserState.getProperties(), null, htmlDeepParser.getHtmlMatch() == HtmlDeepParser.HtmlMatch.COMMENT, htmlDeepParser)).atIndex(parserState.getIndex());
                    }
                } else {
                    int i = 1;
                    while (i <= 7) {
                        if (i != 7 || (!this.myHtmlBlockStartOnlyOnBlockTags && !(matchedBlockParser.getBlockParser().getBlock() instanceof Paragraph))) {
                            if (this.myPatterns == null) {
                                this.myPatterns = new Patterns(parserState.getParsing(), parserState.getProperties());
                            }
                            Pattern[] patternArr = this.myPatterns.BLOCK_PATTERNS[i];
                            Pattern pattern = patternArr[0];
                            Pattern pattern2 = patternArr[1];
                            Matcher matcher = pattern.matcher(line.subSequence(nextNonSpaceIndex, line.length()));
                            if (matcher.find() && (this.myHtmlCommentBlocksInterruptParagraph || i != this.myPatterns.COMMENT_PATTERN_INDEX || !(matchedBlockParser.getBlockParser() instanceof ParagraphParser))) {
                                Patterns patterns = this.myPatterns;
                                int i2 = patterns.COMMENT_PATTERN_INDEX;
                                if (i == i2 && this.myHtmlBlockCommentOnlyFullLine) {
                                    Matcher matcher2 = patterns.BLOCK_PATTERNS[i2][1].matcher(line.subSequence(matcher.end(), line.length()));
                                    if (matcher2.find() && !line.subSequence(matcher2.end(), line.length()).trim().equals("-->")) {
                                        return BlockStart.none();
                                    }
                                }
                                return BlockStart.m13315of(new HtmlBlockParser(parserState.getProperties(), pattern2, i == this.myPatterns.COMMENT_PATTERN_INDEX, null)).atIndex(parserState.getIndex());
                            }
                        }
                        i++;
                    }
                }
            }
            return BlockStart.none();
        }

        private BlockFactory(DataHolder dataHolder) {
            super(dataHolder);
            this.myPatterns = null;
            this.myHtmlCommentBlocksInterruptParagraph = Parser.HTML_COMMENT_BLOCKS_INTERRUPT_PARAGRAPH.get(dataHolder).booleanValue();
            this.myHtmlBlockDeepParser = Parser.HTML_BLOCK_DEEP_PARSER.get(dataHolder).booleanValue();
            this.myHtmlBlockDeepParseNonBlock = Parser.HTML_BLOCK_DEEP_PARSE_NON_BLOCK.get(dataHolder).booleanValue();
            this.myHtmlBlockDeepParseFirstOpenTagOnOneLine = Parser.HTML_BLOCK_DEEP_PARSE_FIRST_OPEN_TAG_ON_ONE_LINE.get(dataHolder).booleanValue();
            this.myHtmlBlockCommentOnlyFullLine = Parser.HTML_BLOCK_COMMENT_ONLY_FULL_LINE.get(dataHolder).booleanValue();
            this.myHtmlBlockStartOnlyOnBlockTags = Parser.HTML_BLOCK_START_ONLY_ON_BLOCK_TAGS.get(dataHolder).booleanValue();
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
            return new HashSet(Arrays.asList(BlockQuoteParser.Factory.class, HeadingParser.Factory.class, FencedCodeBlockParser.Factory.class));
        }

        @Override // com.vladsch.flexmark.util.dependency.Dependent
        @Nullable
        public Set<Class<?>> getBeforeDependents() {
            return new HashSet(Arrays.asList(ThematicBreakParser.Factory.class, ListBlockParser.Factory.class, IndentedCodeBlockParser.Factory.class));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.vladsch.flexmark.parser.block.CustomBlockParserFactory, java.util.function.Function
        @NotNull
        public BlockParserFactory apply(@NotNull DataHolder dataHolder) {
            return new BlockFactory(dataHolder, 0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Patterns {
        public final Pattern[][] BLOCK_PATTERNS;
        public final int COMMENT_PATTERN_INDEX = 2;

        public Patterns(Parsing parsing, DataHolder dataHolder) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = Parser.HTML_BLOCK_TAGS.get(dataHolder).iterator();
            String str = "";
            while (it.hasNext()) {
                AbstractC2821a.m2207B(sb, str, "\\Q", it.next(), "\\E");
                str = "|";
            }
            if (Parser.HTML_FOR_TRANSLATOR.get(dataHolder).booleanValue()) {
                sb.append(str);
                sb.append(Parser.TRANSLATION_HTML_BLOCK_TAG_PATTERN.get(dataHolder));
            }
            String string = sb.toString();
            this.BLOCK_PATTERNS = new Pattern[][]{new Pattern[]{null, null}, new Pattern[]{Pattern.compile("^<(?:script|pre|style)(?:\\s|>|$)", 2), Pattern.compile("</(?:script|pre|style)>", 2)}, new Pattern[]{Pattern.compile("^<!--"), Pattern.compile("-->")}, new Pattern[]{Pattern.compile("^<[?]"), Pattern.compile("\\?>")}, new Pattern[]{Pattern.compile("^<![A-Z]"), Pattern.compile(">")}, new Pattern[]{Pattern.compile("^<!\\[CDATA\\["), Pattern.compile("\\]\\]>")}, new Pattern[]{Pattern.compile("^</?(?:(?:(?:[_A-Za-zÀ-ÖØ-öø-˿Ͱ-ͽͿ-\u1fff\u200c-\u200d⁰-\u218fⰀ-\u2fef、-\ud7ff豈-﷏ﷰ-�])(?:[_A-Za-zÀ-ÖØ-öø-˿Ͱ-ͽͿ-\u1fff\u200c-\u200d⁰-\u218fⰀ-\u2fef、-\ud7ff豈-﷏ﷰ-�]|[.0-9·̀-ͯ‿-⁀-])*:)?(?:" + string + "))(?:\\s|[/]?[>]|$)", 2), null}, new Pattern[]{Pattern.compile(AbstractC0541b.m775q("^(?:", parsing.OPENTAG, "|", parsing.CLOSETAG, ")\\s*$"), 2), null}};
        }
    }

    public HtmlBlockParser(DataHolder dataHolder, Pattern pattern, boolean z, HtmlDeepParser htmlDeepParser) {
        this.closingPattern = pattern;
        this.block = z ? new HtmlCommentBlock() : new HtmlBlock();
        this.deepParser = htmlDeepParser;
        this.parseInnerHtmlComments = Parser.PARSE_INNER_HTML_COMMENTS.get(dataHolder).booleanValue();
        this.myHtmlBlockDeepParseNonBlock = Parser.HTML_BLOCK_DEEP_PARSE_NON_BLOCK.get(dataHolder).booleanValue();
        this.myHtmlBlockDeepParseBlankLineInterrupts = Parser.HTML_BLOCK_DEEP_PARSE_BLANK_LINE_INTERRUPTS.get(dataHolder).booleanValue();
        this.myHtmlBlockDeepParseMarkdownInterruptsClosed = Parser.HTML_BLOCK_DEEP_PARSE_MARKDOWN_INTERRUPTS_CLOSED.get(dataHolder).booleanValue();
        this.myHtmlBlockDeepParseBlankLineInterruptsPartialTag = Parser.HTML_BLOCK_DEEP_PARSE_BLANK_LINE_INTERRUPTS_PARTIAL_TAG.get(dataHolder).booleanValue();
        this.myHtmlBlockDeepParseIndentedCodeInterrupts = Parser.HTML_BLOCK_DEEP_PARSE_INDENTED_CODE_INTERRUPTS.get(dataHolder).booleanValue();
    }

    @Override // com.vladsch.flexmark.parser.block.AbstractBlockParser, com.vladsch.flexmark.parser.block.BlockParser
    public void addLine(ParserState parserState, BasedSequence basedSequence) {
        if (this.deepParser == null) {
            Pattern pattern = this.closingPattern;
            if (pattern != null && pattern.matcher(basedSequence).find()) {
                this.finished = true;
            }
        } else if (this.content.getLineCount() > 0) {
            this.deepParser.parseHtmlChunk(basedSequence, false, this.myHtmlBlockDeepParseNonBlock, false);
        }
        this.content.add(basedSequence, parserState.getIndent());
    }

    @Override // com.vladsch.flexmark.parser.block.AbstractBlockParser, com.vladsch.flexmark.parser.block.BlockParser
    public boolean canContain(ParserState parserState, BlockParser blockParser, Block block) {
        return false;
    }

    @Override // com.vladsch.flexmark.parser.block.AbstractBlockParser, com.vladsch.flexmark.parser.block.BlockParser
    public boolean canInterruptBy(BlockParserFactory blockParserFactory) {
        HtmlDeepParser htmlDeepParser;
        if (!this.myHtmlBlockDeepParseMarkdownInterruptsClosed || (htmlDeepParser = this.deepParser) == null || (blockParserFactory instanceof Factory)) {
            return false;
        }
        return (this.myHtmlBlockDeepParseIndentedCodeInterrupts || !(blockParserFactory instanceof IndentedCodeBlockParser.BlockFactory)) && htmlDeepParser.isHtmlClosed();
    }

    @Override // com.vladsch.flexmark.parser.block.BlockParser
    public void closeBlock(ParserState parserState) {
        int iIndexOf;
        this.block.setContent(this.content);
        this.content = null;
        HtmlBlockBase htmlBlockBase = this.block;
        if ((htmlBlockBase instanceof HtmlCommentBlock) || !this.parseInnerHtmlComments) {
            return;
        }
        BasedSequence contentChars = htmlBlockBase.getContentChars();
        int i = 0;
        if (contentChars.eolEndLength() > 0) {
            contentChars = contentChars.midSequence(0, -1);
        }
        int length = contentChars.length();
        while (i < length) {
            int iIndexOf2 = contentChars.indexOf("<!--", i);
            if (iIndexOf2 < 0 || (iIndexOf = contentChars.indexOf("-->", iIndexOf2 + 4)) < 0) {
                break;
            }
            if (i < iIndexOf2) {
                this.block.appendChild(new HtmlInnerBlock(contentChars.subSequence(i, iIndexOf2)));
            }
            i = iIndexOf + 3;
            this.block.appendChild(new HtmlInnerBlockComment(contentChars.subSequence(iIndexOf2, i)));
        }
        if (i <= 0 || i >= contentChars.length()) {
            return;
        }
        this.block.appendChild(new HtmlInnerBlock(contentChars.subSequence(i, contentChars.length())));
    }

    @Override // com.vladsch.flexmark.parser.block.BlockParser
    public Block getBlock() {
        return this.block;
    }

    @Override // com.vladsch.flexmark.parser.block.AbstractBlockParser, com.vladsch.flexmark.parser.block.BlockParser
    public boolean isInterruptible() {
        HtmlDeepParser htmlDeepParser;
        return this.myHtmlBlockDeepParseMarkdownInterruptsClosed && (htmlDeepParser = this.deepParser) != null && htmlDeepParser.isHtmlClosed();
    }

    @Override // com.vladsch.flexmark.parser.block.AbstractBlockParser, com.vladsch.flexmark.parser.block.BlockParser
    public boolean isRawText() {
        return true;
    }

    @Override // com.vladsch.flexmark.parser.block.BlockParser
    public BlockContinue tryContinue(ParserState parserState) {
        return this.deepParser != null ? (!parserState.isBlank() || (!this.deepParser.isHtmlClosed() && ((!this.myHtmlBlockDeepParseBlankLineInterrupts || this.deepParser.haveOpenRawTag()) && !(this.myHtmlBlockDeepParseBlankLineInterruptsPartialTag && this.deepParser.isBlankLineInterruptible())))) ? BlockContinue.atIndex(parserState.getIndex()) : BlockContinue.none() : this.finished ? BlockContinue.none() : (parserState.isBlank() && this.closingPattern == null) ? BlockContinue.none() : BlockContinue.atIndex(parserState.getIndex());
    }
}
