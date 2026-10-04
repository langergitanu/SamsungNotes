package com.vladsch.flexmark.parser.internal;

import com.vladsch.flexmark.parser.block.BlockParser;
import com.vladsch.flexmark.parser.block.MatchedBlockParser;
import com.vladsch.flexmark.util.data.MutableDataHolder;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class MatchedBlockParserImpl implements MatchedBlockParser {
    private final BlockParser matchedBlockParser;

    public MatchedBlockParserImpl(BlockParser blockParser) {
        this.matchedBlockParser = blockParser;
    }

    @Override // com.vladsch.flexmark.parser.block.MatchedBlockParser
    public BlockParser getBlockParser() {
        return this.matchedBlockParser;
    }

    @Override // com.vladsch.flexmark.parser.block.MatchedBlockParser
    public BasedSequence getParagraphContent() {
        if (this.matchedBlockParser.isParagraphParser()) {
            return this.matchedBlockParser.getBlockContent().getContents();
        }
        return null;
    }

    @Override // com.vladsch.flexmark.parser.block.MatchedBlockParser
    public MutableDataHolder getParagraphDataHolder() {
        if (this.matchedBlockParser.isParagraphParser()) {
            return this.matchedBlockParser.getDataHolder();
        }
        return null;
    }

    @Override // com.vladsch.flexmark.parser.block.MatchedBlockParser
    public List<Integer> getParagraphEolLengths() {
        if (this.matchedBlockParser.isParagraphParser()) {
            return this.matchedBlockParser.getBlockContent().getLineIndents();
        }
        return null;
    }

    @Override // com.vladsch.flexmark.parser.block.MatchedBlockParser
    public List<BasedSequence> getParagraphLines() {
        if (this.matchedBlockParser.isParagraphParser()) {
            return this.matchedBlockParser.getBlockContent().getLines();
        }
        return null;
    }
}
