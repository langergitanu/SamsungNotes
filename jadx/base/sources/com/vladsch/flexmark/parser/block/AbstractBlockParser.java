package com.vladsch.flexmark.parser.block;

import com.vladsch.flexmark.parser.InlineParser;
import com.vladsch.flexmark.util.ast.BlankLine;
import com.vladsch.flexmark.util.ast.Block;
import com.vladsch.flexmark.util.ast.BlockContent;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.MutableDataHolder;
import com.vladsch.flexmark.util.data.MutableDataSet;
import com.vladsch.flexmark.util.sequence.BasedSequence;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public abstract class AbstractBlockParser implements BlockParser {
    private MutableDataSet mutableData = null;
    private boolean isClosed = false;

    @Override // com.vladsch.flexmark.parser.block.BlockParser
    public void addLine(ParserState parserState, BasedSequence basedSequence) {
    }

    @Override // com.vladsch.flexmark.parser.block.BlockParser
    public boolean breakOutOnDoubleBlankLine() {
        return false;
    }

    @Override // com.vladsch.flexmark.parser.block.BlockParser
    public boolean canContain(ParserState parserState, BlockParser blockParser, Block block) {
        return false;
    }

    @Override // com.vladsch.flexmark.parser.block.BlockParser
    public boolean canInterruptBy(BlockParserFactory blockParserFactory) {
        return true;
    }

    @Override // com.vladsch.flexmark.parser.block.BlockParser
    public final void finalizeClosedBlock() {
        this.mutableData = null;
        this.isClosed = true;
    }

    @Override // com.vladsch.flexmark.parser.block.BlockParser
    public BlockContent getBlockContent() {
        return null;
    }

    @Override // com.vladsch.flexmark.parser.block.BlockParser
    public MutableDataHolder getDataHolder() {
        if (this.mutableData == null) {
            this.mutableData = new MutableDataSet();
        }
        return this.mutableData;
    }

    @Override // com.vladsch.flexmark.parser.block.BlockParser
    public boolean isClosed() {
        return this.isClosed;
    }

    @Override // com.vladsch.flexmark.parser.block.BlockParser
    public boolean isContainer() {
        return false;
    }

    @Override // com.vladsch.flexmark.parser.block.BlockParser
    public boolean isInterruptible() {
        return false;
    }

    @Override // com.vladsch.flexmark.parser.block.BlockParser
    public boolean isParagraphParser() {
        return false;
    }

    @Override // com.vladsch.flexmark.parser.block.BlockParser
    public boolean isPropagatingLastBlankLine(BlockParser blockParser) {
        return true;
    }

    @Override // com.vladsch.flexmark.parser.block.BlockParser
    public boolean isRawText() {
        return false;
    }

    @Override // com.vladsch.flexmark.parser.block.BlockParser
    public void parseInlines(InlineParser inlineParser) {
    }

    public void removeBlankLines() {
        Node firstChild = getBlock().getFirstChild();
        while (firstChild != null) {
            Node next = firstChild.getNext();
            if (firstChild instanceof BlankLine) {
                firstChild.unlink();
            }
            firstChild = next;
        }
    }
}
