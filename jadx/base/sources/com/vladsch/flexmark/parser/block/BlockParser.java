package com.vladsch.flexmark.parser.block;

import com.vladsch.flexmark.parser.InlineParser;
import com.vladsch.flexmark.util.ast.Block;
import com.vladsch.flexmark.util.ast.BlockContent;
import com.vladsch.flexmark.util.data.MutableDataHolder;
import com.vladsch.flexmark.util.sequence.BasedSequence;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface BlockParser {
    void addLine(ParserState parserState, BasedSequence basedSequence);

    boolean breakOutOnDoubleBlankLine();

    boolean canContain(ParserState parserState, BlockParser blockParser, Block block);

    boolean canInterruptBy(BlockParserFactory blockParserFactory);

    void closeBlock(ParserState parserState);

    void finalizeClosedBlock();

    Block getBlock();

    BlockContent getBlockContent();

    MutableDataHolder getDataHolder();

    boolean isClosed();

    boolean isContainer();

    boolean isInterruptible();

    boolean isParagraphParser();

    boolean isPropagatingLastBlankLine(BlockParser blockParser);

    boolean isRawText();

    void parseInlines(InlineParser inlineParser);

    BlockContinue tryContinue(ParserState parserState);
}
