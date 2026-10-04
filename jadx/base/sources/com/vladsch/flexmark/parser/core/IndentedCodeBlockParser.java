package com.vladsch.flexmark.parser.core;

import com.vladsch.flexmark.ast.CodeBlock;
import com.vladsch.flexmark.ast.IndentedCodeBlock;
import com.vladsch.flexmark.ast.Paragraph;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.parser.block.AbstractBlockParser;
import com.vladsch.flexmark.parser.block.AbstractBlockParserFactory;
import com.vladsch.flexmark.parser.block.BlockContinue;
import com.vladsch.flexmark.parser.block.BlockParserFactory;
import com.vladsch.flexmark.parser.block.BlockStart;
import com.vladsch.flexmark.parser.block.CustomBlockParserFactory;
import com.vladsch.flexmark.parser.block.MatchedBlockParser;
import com.vladsch.flexmark.parser.block.ParserState;
import com.vladsch.flexmark.parser.core.BlockQuoteParser;
import com.vladsch.flexmark.parser.core.FencedCodeBlockParser;
import com.vladsch.flexmark.parser.core.HeadingParser;
import com.vladsch.flexmark.parser.core.HtmlBlockParser;
import com.vladsch.flexmark.parser.core.ListBlockParser;
import com.vladsch.flexmark.parser.core.ThematicBreakParser;
import com.vladsch.flexmark.util.ast.Block;
import com.vladsch.flexmark.util.ast.BlockContent;
import com.vladsch.flexmark.util.collection.iteration.Reverse;
import com.vladsch.flexmark.util.collection.iteration.ReversibleIterator;
import com.vladsch.flexmark.util.data.DataHolder;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class IndentedCodeBlockParser extends AbstractBlockParser {
    private final boolean codeContentBlock;
    private final boolean trimTrailingBlankLines;
    private final IndentedCodeBlock block = new IndentedCodeBlock();
    private BlockContent content = new BlockContent();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class BlockFactory extends AbstractBlockParserFactory {
        public /* synthetic */ BlockFactory(DataHolder dataHolder, int i) {
            this(dataHolder);
        }

        @Override // com.vladsch.flexmark.parser.block.BlockParserFactory
        public BlockStart tryStart(ParserState parserState, MatchedBlockParser matchedBlockParser) {
            return (parserState.getIndent() < parserState.getParsing().CODE_BLOCK_INDENT || parserState.isBlank() || (parserState.getActiveBlockParser().getBlock() instanceof Paragraph)) ? BlockStart.none() : BlockStart.m13315of(new IndentedCodeBlockParser(parserState.getProperties())).atColumn(parserState.getColumn() + parserState.getParsing().CODE_BLOCK_INDENT);
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
            return new HashSet(Arrays.asList(BlockQuoteParser.Factory.class, HeadingParser.Factory.class, FencedCodeBlockParser.Factory.class, HtmlBlockParser.Factory.class, ThematicBreakParser.Factory.class, ListBlockParser.Factory.class));
        }

        @Override // com.vladsch.flexmark.util.dependency.Dependent
        @Nullable
        public Set<Class<?>> getBeforeDependents() {
            return Collections.EMPTY_SET;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.vladsch.flexmark.parser.block.CustomBlockParserFactory, java.util.function.Function
        @NotNull
        public BlockParserFactory apply(@NotNull DataHolder dataHolder) {
            return new BlockFactory(dataHolder, 0);
        }
    }

    public IndentedCodeBlockParser(DataHolder dataHolder) {
        this.trimTrailingBlankLines = Parser.INDENTED_CODE_NO_TRAILING_BLANK_LINES.get(dataHolder).booleanValue();
        this.codeContentBlock = Parser.FENCED_CODE_CONTENT_BLOCK.get(dataHolder).booleanValue();
    }

    @Override // com.vladsch.flexmark.parser.block.AbstractBlockParser, com.vladsch.flexmark.parser.block.BlockParser
    public void addLine(ParserState parserState, BasedSequence basedSequence) {
        this.content.add(basedSequence, parserState.getIndent());
    }

    @Override // com.vladsch.flexmark.parser.block.BlockParser
    public void closeBlock(ParserState parserState) {
        if (this.trimTrailingBlankLines) {
            List<BasedSequence> lines = this.content.getLines();
            ReversibleIterator it = new Reverse(lines).iterator();
            int i = 0;
            while (it.hasNext() && ((BasedSequence) it.next()).isBlank()) {
                i++;
            }
            if (i > 0) {
                this.block.setContent(lines.subList(0, lines.size() - i));
            } else {
                this.block.setContent(this.content);
            }
        } else {
            this.block.setContent(this.content);
        }
        if (this.codeContentBlock) {
            this.block.appendChild(new CodeBlock(this.block.getChars(), this.block.getContentLines()));
        }
        this.content = null;
    }

    @Override // com.vladsch.flexmark.parser.block.BlockParser
    public Block getBlock() {
        return this.block;
    }

    @Override // com.vladsch.flexmark.parser.block.BlockParser
    public BlockContinue tryContinue(ParserState parserState) {
        return parserState.getIndent() >= parserState.getParsing().CODE_BLOCK_INDENT ? BlockContinue.atColumn(parserState.getColumn() + parserState.getParsing().CODE_BLOCK_INDENT) : parserState.isBlank() ? BlockContinue.atIndex(parserState.getNextNonSpaceIndex()) : BlockContinue.none();
    }
}
