package com.vladsch.flexmark.parser.core;

import com.vladsch.flexmark.ast.ThematicBreak;
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
import com.vladsch.flexmark.parser.core.IndentedCodeBlockParser;
import com.vladsch.flexmark.parser.core.ListBlockParser;
import com.vladsch.flexmark.util.ast.Block;
import com.vladsch.flexmark.util.data.DataHolder;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ThematicBreakParser extends AbstractBlockParser {
    static Pattern PATTERN = Pattern.compile("^(?:(?:\\*[ \t]*){3,}|(?:_[ \t]*){3,}|(?:-[ \t]*){3,})[ \t]*$");
    private final ThematicBreak block;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class BlockFactory extends AbstractBlockParserFactory {
        private final ThematicBreakOptions options;

        public BlockFactory(DataHolder dataHolder) {
            super(dataHolder);
            this.options = new ThematicBreakOptions(dataHolder);
        }

        @Override // com.vladsch.flexmark.parser.block.BlockParserFactory
        public BlockStart tryStart(ParserState parserState, MatchedBlockParser matchedBlockParser) {
            if (parserState.getIndent() >= 4 || (matchedBlockParser.getBlockParser().isParagraphParser() && !this.options.relaxedStart)) {
                return BlockStart.none();
            }
            BasedSequence line = parserState.getLine();
            return ThematicBreakParser.PATTERN.matcher(line.subSequence(parserState.getNextNonSpaceIndex(), line.length())).matches() ? BlockStart.m13315of(new ThematicBreakParser(line.subSequence(parserState.getIndex()))).atIndex(line.length()) : BlockStart.none();
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
            return new HashSet(Arrays.asList(BlockQuoteParser.Factory.class, HeadingParser.Factory.class, FencedCodeBlockParser.Factory.class, HtmlBlockParser.Factory.class));
        }

        @Override // com.vladsch.flexmark.util.dependency.Dependent
        @Nullable
        public Set<Class<?>> getBeforeDependents() {
            return new HashSet(Arrays.asList(ListBlockParser.Factory.class, IndentedCodeBlockParser.Factory.class));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.vladsch.flexmark.parser.block.CustomBlockParserFactory, java.util.function.Function
        @NotNull
        public BlockParserFactory apply(@NotNull DataHolder dataHolder) {
            return new BlockFactory(dataHolder);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ThematicBreakOptions {
        final boolean relaxedStart;

        public ThematicBreakOptions(DataHolder dataHolder) {
            this.relaxedStart = Parser.THEMATIC_BREAK_RELAXED_START.get(dataHolder).booleanValue();
        }
    }

    public ThematicBreakParser(BasedSequence basedSequence) {
        ThematicBreak thematicBreak = new ThematicBreak();
        this.block = thematicBreak;
        thematicBreak.setChars(basedSequence);
    }

    @Override // com.vladsch.flexmark.parser.block.BlockParser
    public void closeBlock(ParserState parserState) {
        this.block.setCharsFromContent();
    }

    @Override // com.vladsch.flexmark.parser.block.BlockParser
    public Block getBlock() {
        return this.block;
    }

    @Override // com.vladsch.flexmark.parser.block.BlockParser
    public BlockContinue tryContinue(ParserState parserState) {
        return BlockContinue.none();
    }
}
