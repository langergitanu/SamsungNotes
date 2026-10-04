package com.vladsch.flexmark.parser.internal;

import com.vladsch.flexmark.parser.block.BlockParser;
import com.vladsch.flexmark.parser.block.BlockStart;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class BlockStartImpl extends BlockStart {
    private final BlockParser[] blockParsers;
    private int newIndex = -1;
    private int newColumn = -1;
    private boolean replaceActiveBlockParser = false;

    public BlockStartImpl(BlockParser... blockParserArr) {
        this.blockParsers = blockParserArr;
    }

    @Override // com.vladsch.flexmark.parser.block.BlockStart
    public BlockStart atColumn(int i) {
        this.newColumn = i;
        return this;
    }

    @Override // com.vladsch.flexmark.parser.block.BlockStart
    public BlockStart atIndex(int i) {
        this.newIndex = i;
        return this;
    }

    public BlockParser[] getBlockParsers() {
        return this.blockParsers;
    }

    public int getNewColumn() {
        return this.newColumn;
    }

    public int getNewIndex() {
        return this.newIndex;
    }

    public boolean isReplaceActiveBlockParser() {
        return this.replaceActiveBlockParser;
    }

    @Override // com.vladsch.flexmark.parser.block.BlockStart
    public BlockStart replaceActiveBlockParser() {
        this.replaceActiveBlockParser = true;
        return this;
    }
}
