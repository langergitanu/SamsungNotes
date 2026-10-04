package com.vladsch.flexmark.ast;

import com.vladsch.flexmark.util.ast.Block;
import com.vladsch.flexmark.util.ast.BlockContent;
import com.vladsch.flexmark.util.ast.BlockQuoteLike;
import com.vladsch.flexmark.util.ast.KeepTrailingBlankLineContainer;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class BlockQuote extends Block implements BlockQuoteLike, KeepTrailingBlankLineContainer {
    private BasedSequence openingMarker;

    public BlockQuote() {
        this.openingMarker = BasedSequence.NULL;
    }

    @Override // com.vladsch.flexmark.util.ast.Node
    public void getAstExtra(@NotNull StringBuilder sb) {
        Node.segmentSpanChars(sb, this.openingMarker, "marker");
    }

    @Override // com.vladsch.flexmark.util.ast.BlockQuoteLike
    public BasedSequence getOpeningMarker() {
        return this.openingMarker;
    }

    @Override // com.vladsch.flexmark.util.ast.Node
    @NotNull
    public BasedSequence[] getSegments() {
        return new BasedSequence[]{this.openingMarker};
    }

    public void setOpeningMarker(BasedSequence basedSequence) {
        this.openingMarker = basedSequence;
    }

    public BlockQuote(BasedSequence basedSequence) {
        super(basedSequence);
        this.openingMarker = BasedSequence.NULL;
    }

    public BlockQuote(BasedSequence basedSequence, List<BasedSequence> list) {
        super(basedSequence, list);
        this.openingMarker = BasedSequence.NULL;
    }

    public BlockQuote(BlockContent blockContent) {
        super(blockContent);
        this.openingMarker = BasedSequence.NULL;
    }
}
