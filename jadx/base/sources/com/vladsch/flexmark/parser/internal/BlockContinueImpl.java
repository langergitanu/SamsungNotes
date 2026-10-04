package com.vladsch.flexmark.parser.internal;

import com.vladsch.flexmark.parser.block.BlockContinue;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class BlockContinueImpl extends BlockContinue {
    private final boolean finalize;
    private final int newColumn;
    private final int newIndex;

    public BlockContinueImpl(int i, int i2, boolean z) {
        this.newIndex = i;
        this.newColumn = i2;
        this.finalize = z;
    }

    public int getNewColumn() {
        return this.newColumn;
    }

    public int getNewIndex() {
        return this.newIndex;
    }

    public boolean isFinalize() {
        return this.finalize;
    }
}
