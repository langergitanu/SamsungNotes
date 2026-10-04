package com.vladsch.flexmark.parser.block;

import com.vladsch.flexmark.ast.util.Parsing;
import com.vladsch.flexmark.parser.InlineParser;
import com.vladsch.flexmark.util.ast.Block;
import com.vladsch.flexmark.util.ast.BlockTracker;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.MutableDataHolder;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface ParserState extends BlockTracker, BlockParserTracker {
    boolean endsWithBlankLine(Node node);

    BlockParser getActiveBlockParser();

    BlockParser getActiveBlockParser(Block block);

    List<BlockParser> getActiveBlockParsers();

    int getColumn();

    int getIndent();

    int getIndex();

    InlineParser getInlineParser();

    BasedSequence getLine();

    int getLineEndIndex();

    int getLineEolLength();

    int getLineNumber();

    List<BasedSequence> getLineSegments();

    int getLineStart();

    BasedSequence getLineWithEOL();

    int getNextNonSpaceIndex();

    ParserPhase getParserPhase();

    Parsing getParsing();

    MutableDataHolder getProperties();

    boolean isBlank();

    boolean isBlankLine();

    boolean isLastLineBlank(Node node);
}
