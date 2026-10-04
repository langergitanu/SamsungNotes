package com.vladsch.flexmark.parser.core;

import com.vladsch.flexmark.ast.CodeBlock;
import com.vladsch.flexmark.ast.FencedCodeBlock;
import com.vladsch.flexmark.ast.Text;
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
import com.vladsch.flexmark.parser.core.HeadingParser;
import com.vladsch.flexmark.parser.core.HtmlBlockParser;
import com.vladsch.flexmark.parser.core.IndentedCodeBlockParser;
import com.vladsch.flexmark.parser.core.ListBlockParser;
import com.vladsch.flexmark.parser.core.ThematicBreakParser;
import com.vladsch.flexmark.util.ast.Block;
import com.vladsch.flexmark.util.ast.BlockContent;
import com.vladsch.flexmark.util.data.DataHolder;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import com.vladsch.flexmark.util.sequence.SegmentedSequence;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class FencedCodeBlockParser extends AbstractBlockParser {
    private final boolean codeContentBlock;
    private final char fenceChar;
    private final int fenceIndent;
    private final int fenceLength;
    private final int fenceMarkerIndent;
    private final boolean matchingCloser;
    private static final Pattern OPENING_FENCE = Pattern.compile("^`{3,}(?!.*`)|^~{3,}(?!.*~)");
    private static final Pattern CLOSING_FENCE = Pattern.compile("^(?:`{3,}|~{3,})(?=[ \t]*$)");
    private final FencedCodeBlock block = new FencedCodeBlock();
    private BlockContent content = new BlockContent();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class BlockFactory extends AbstractBlockParserFactory {
        public /* synthetic */ BlockFactory(DataHolder dataHolder, int i) {
            this(dataHolder);
        }

        @Override // com.vladsch.flexmark.parser.block.BlockParserFactory
        public BlockStart tryStart(ParserState parserState, MatchedBlockParser matchedBlockParser) {
            int nextNonSpaceIndex = parserState.getNextNonSpaceIndex();
            BasedSequence line = parserState.getLine();
            if (parserState.getIndent() < 4) {
                BasedSequence basedSequenceSubSequence = line.subSequence(nextNonSpaceIndex, line.length());
                Matcher matcher = FencedCodeBlockParser.OPENING_FENCE.matcher(basedSequenceSubSequence);
                if (matcher.find()) {
                    int length = matcher.group(0).length();
                    FencedCodeBlockParser fencedCodeBlockParser = new FencedCodeBlockParser(parserState.getProperties(), matcher.group(0).charAt(0), length, parserState.getIndent(), nextNonSpaceIndex);
                    fencedCodeBlockParser.block.setOpeningMarker(basedSequenceSubSequence.subSequence(0, length));
                    return BlockStart.m13315of(fencedCodeBlockParser).atIndex(nextNonSpaceIndex + length);
                }
            }
            return BlockStart.none();
        }

        private BlockFactory(DataHolder dataHolder) {
            super(dataHolder);
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
            return new HashSet(Arrays.asList(BlockQuoteParser.Factory.class, HeadingParser.Factory.class));
        }

        @Override // com.vladsch.flexmark.util.dependency.Dependent
        @Nullable
        public Set<Class<?>> getBeforeDependents() {
            return new HashSet(Arrays.asList(HtmlBlockParser.Factory.class, ThematicBreakParser.Factory.class, ListBlockParser.Factory.class, IndentedCodeBlockParser.Factory.class));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.vladsch.flexmark.parser.block.CustomBlockParserFactory, java.util.function.Function
        @NotNull
        public BlockParserFactory apply(@NotNull DataHolder dataHolder) {
            return new BlockFactory(dataHolder, 0);
        }
    }

    public FencedCodeBlockParser(DataHolder dataHolder, char c, int i, int i2, int i4) {
        this.fenceChar = c;
        this.fenceLength = i;
        this.fenceIndent = i2;
        this.fenceMarkerIndent = i2 + i4;
        this.matchingCloser = Parser.MATCH_CLOSING_FENCE_CHARACTERS.get(dataHolder).booleanValue();
        this.codeContentBlock = Parser.FENCED_CODE_CONTENT_BLOCK.get(dataHolder).booleanValue();
    }

    @Override // com.vladsch.flexmark.parser.block.AbstractBlockParser, com.vladsch.flexmark.parser.block.BlockParser
    public void addLine(ParserState parserState, BasedSequence basedSequence) {
        this.content.add(basedSequence, parserState.getIndent());
    }

    @Override // com.vladsch.flexmark.parser.block.BlockParser
    public void closeBlock(ParserState parserState) {
        List<BasedSequence> lines = this.content.getLines();
        if (lines.size() > 0) {
            BasedSequence basedSequence = lines.get(0);
            if (!basedSequence.isBlank()) {
                this.block.setInfo(basedSequence.trim());
            }
            BasedSequence spanningChars = this.content.getSpanningChars();
            BasedSequence basedSequenceBaseSubSequence = spanningChars.baseSubSequence(spanningChars.getStartOffset(), lines.get(0).getEndOffset());
            if (lines.size() > 1) {
                List<BasedSequence> listSubList = lines.subList(1, lines.size());
                this.block.setContent(basedSequenceBaseSubSequence, listSubList);
                if (this.codeContentBlock) {
                    CodeBlock codeBlock = new CodeBlock();
                    codeBlock.setContent(listSubList);
                    codeBlock.setCharsFromContent();
                    this.block.appendChild(codeBlock);
                } else {
                    this.block.appendChild(new Text(SegmentedSequence.create(spanningChars, listSubList)));
                }
            } else {
                this.block.setContent(basedSequenceBaseSubSequence, BasedSequence.EMPTY_LIST);
            }
        } else {
            this.block.setContent(this.content);
        }
        this.block.setCharsFromContent();
        this.content = null;
    }

    @Override // com.vladsch.flexmark.parser.block.BlockParser
    public Block getBlock() {
        return this.block;
    }

    public int getFenceIndent() {
        return this.fenceIndent;
    }

    public int getFenceMarkerIndent() {
        return this.fenceMarkerIndent;
    }

    @Override // com.vladsch.flexmark.parser.block.AbstractBlockParser, com.vladsch.flexmark.parser.block.BlockParser
    public boolean isPropagatingLastBlankLine(BlockParser blockParser) {
        return false;
    }

    @Override // com.vladsch.flexmark.parser.block.BlockParser
    public BlockContinue tryContinue(ParserState parserState) {
        int length;
        int nextNonSpaceIndex = parserState.getNextNonSpaceIndex();
        int index = parserState.getIndex();
        BasedSequence line = parserState.getLine();
        if (parserState.getIndent() <= 3 && nextNonSpaceIndex < line.length() && (!this.matchingCloser || line.charAt(nextNonSpaceIndex) == this.fenceChar)) {
            BasedSequence basedSequenceSubSequence = line.subSequence(nextNonSpaceIndex, line.length());
            Matcher matcher = CLOSING_FENCE.matcher(basedSequenceSubSequence);
            if (matcher.find() && (length = matcher.group(0).length()) >= this.fenceLength) {
                this.block.setClosingMarker(basedSequenceSubSequence.subSequence(0, length));
                return BlockContinue.finished();
            }
        }
        for (int i = this.fenceIndent; i > 0 && index < line.length() && line.charAt(index) == ' '; i--) {
            index++;
        }
        return BlockContinue.atIndex(index);
    }
}
