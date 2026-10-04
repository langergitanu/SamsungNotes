package com.vladsch.flexmark.util.ast;

import com.vladsch.flexmark.util.sequence.BasedSequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class BlankLine extends Block {
    private Block claimedBlankLine;

    public BlankLine(@NotNull BasedSequence basedSequence) {
        super(basedSequence);
        this.claimedBlankLine = null;
        setCharsFromContent();
    }

    @Nullable
    public Block getClaimedBlankLine() {
        return this.claimedBlankLine;
    }

    @Override // com.vladsch.flexmark.util.ast.Node
    @NotNull
    public BasedSequence[] getSegments() {
        return Node.EMPTY_SEGMENTS;
    }

    public boolean isClaimed() {
        return this.claimedBlankLine != null;
    }

    public BlankLine setClaimedBlankLine(@NotNull Block block) {
        this.claimedBlankLine = block;
        return this;
    }

    public BlankLine(@NotNull BasedSequence basedSequence, @NotNull Block block) {
        super(basedSequence);
        this.claimedBlankLine = null;
        setCharsFromContent();
        this.claimedBlankLine = block;
    }
}
