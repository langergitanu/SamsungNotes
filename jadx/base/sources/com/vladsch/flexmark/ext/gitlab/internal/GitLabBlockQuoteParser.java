package com.vladsch.flexmark.ext.gitlab.internal;

import com.vladsch.flexmark.ext.gitlab.GitLabBlockQuote;
import com.vladsch.flexmark.parser.InlineParser;
import com.vladsch.flexmark.parser.block.AbstractBlockParser;
import com.vladsch.flexmark.parser.block.AbstractBlockParserFactory;
import com.vladsch.flexmark.parser.block.BlockContinue;
import com.vladsch.flexmark.parser.block.BlockParser;
import com.vladsch.flexmark.parser.block.BlockParserFactory;
import com.vladsch.flexmark.parser.block.BlockStart;
import com.vladsch.flexmark.parser.block.CustomBlockParserFactory;
import com.vladsch.flexmark.parser.block.MatchedBlockParser;
import com.vladsch.flexmark.parser.block.ParserState;
import com.vladsch.flexmark.util.ast.Block;
import com.vladsch.flexmark.util.ast.BlockContent;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.DataHolder;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class GitLabBlockQuoteParser extends AbstractBlockParser {
    private final GitLabBlockQuote block;
    private BlockContent content;
    private boolean hadClose;
    static Pattern GIT_LAB_BLOCK_START = Pattern.compile(">>>(\\s*$)");
    static Pattern GIT_LAB_BLOCK_END = Pattern.compile(">>>(\\s*$)");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class BlockFactory extends AbstractBlockParserFactory {
        private final GitLabOptions options;

        public BlockFactory(DataHolder dataHolder) {
            super(dataHolder);
            this.options = new GitLabOptions(dataHolder);
        }

        public boolean haveBlockQuoteParser(ParserState parserState) {
            List<BlockParser> activeBlockParsers = parserState.getActiveBlockParsers();
            int size = activeBlockParsers.size();
            while (true) {
                int i = size - 1;
                if (size <= 0) {
                    return false;
                }
                if (activeBlockParsers.get(i) instanceof GitLabBlockQuoteParser) {
                    return true;
                }
                size = i;
            }
        }

        @Override // com.vladsch.flexmark.parser.block.BlockParserFactory
        public BlockStart tryStart(ParserState parserState, MatchedBlockParser matchedBlockParser) {
            if (this.options.nestedBlockQuotes || !haveBlockQuoteParser(parserState)) {
                BasedSequence lineWithEOL = parserState.getLineWithEOL();
                Matcher matcher = GitLabBlockQuoteParser.GIT_LAB_BLOCK_START.matcher(lineWithEOL);
                if (matcher.matches()) {
                    return BlockStart.m13315of(new GitLabBlockQuoteParser(parserState.getProperties(), lineWithEOL.subSequence(0, 3), lineWithEOL.subSequence(matcher.start(1), matcher.end(1)))).atIndex(parserState.getLineEndIndex());
                }
            }
            return BlockStart.none();
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
            return null;
        }

        @Override // com.vladsch.flexmark.util.dependency.Dependent
        @Nullable
        public Set<Class<?>> getBeforeDependents() {
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.vladsch.flexmark.parser.block.CustomBlockParserFactory, java.util.function.Function
        @NotNull
        public BlockParserFactory apply(@NotNull DataHolder dataHolder) {
            return new BlockFactory(dataHolder);
        }
    }

    public GitLabBlockQuoteParser(DataHolder dataHolder, BasedSequence basedSequence, BasedSequence basedSequence2) {
        GitLabBlockQuote gitLabBlockQuote = new GitLabBlockQuote();
        this.block = gitLabBlockQuote;
        this.content = new BlockContent();
        this.hadClose = false;
        gitLabBlockQuote.setOpeningMarker(basedSequence);
        gitLabBlockQuote.setOpeningTrailing(basedSequence2);
    }

    @Override // com.vladsch.flexmark.parser.block.AbstractBlockParser, com.vladsch.flexmark.parser.block.BlockParser
    public void addLine(ParserState parserState, BasedSequence basedSequence) {
        this.content.add(basedSequence, parserState.getIndent());
    }

    @Override // com.vladsch.flexmark.parser.block.AbstractBlockParser, com.vladsch.flexmark.parser.block.BlockParser
    public boolean canContain(ParserState parserState, BlockParser blockParser, Block block) {
        return true;
    }

    @Override // com.vladsch.flexmark.parser.block.BlockParser
    public void closeBlock(ParserState parserState) {
        this.block.setContent(this.content);
        this.block.setCharsFromContent();
        this.content = null;
    }

    @Override // com.vladsch.flexmark.parser.block.BlockParser
    public Block getBlock() {
        return this.block;
    }

    @Override // com.vladsch.flexmark.parser.block.AbstractBlockParser, com.vladsch.flexmark.parser.block.BlockParser
    public boolean isContainer() {
        return true;
    }

    @Override // com.vladsch.flexmark.parser.block.AbstractBlockParser, com.vladsch.flexmark.parser.block.BlockParser
    public void parseInlines(InlineParser inlineParser) {
    }

    @Override // com.vladsch.flexmark.parser.block.BlockParser
    public BlockContinue tryContinue(ParserState parserState) {
        if (this.hadClose) {
            return BlockContinue.none();
        }
        int index = parserState.getIndex();
        Matcher matcher = GIT_LAB_BLOCK_END.matcher(parserState.getLineWithEOL().subSequence(index));
        if (!matcher.matches()) {
            return BlockContinue.atIndex(index);
        }
        Node lastChild = this.block.getLastChild();
        if (lastChild instanceof GitLabBlockQuote) {
            BlockParser activeBlockParser = parserState.getActiveBlockParser((Block) lastChild);
            if ((activeBlockParser instanceof GitLabBlockQuoteParser) && !((GitLabBlockQuoteParser) activeBlockParser).hadClose) {
                return BlockContinue.atIndex(index);
            }
        }
        this.hadClose = true;
        this.block.setClosingMarker(parserState.getLine().subSequence(index, index + 3));
        this.block.setClosingTrailing(parserState.getLineWithEOL().subSequence(matcher.start(1), matcher.end(1)));
        return BlockContinue.atIndex(parserState.getLineEndIndex());
    }
}
