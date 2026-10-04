package com.vladsch.flexmark.ext.gfm.strikethrough;

import com.vladsch.flexmark.util.ast.DelimitedNode;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class Strikethrough extends Node implements DelimitedNode {
    protected BasedSequence closingMarker;
    protected BasedSequence openingMarker;
    protected BasedSequence text;

    public Strikethrough() {
        BasedSequence basedSequence = BasedSequence.NULL;
        this.openingMarker = basedSequence;
        this.text = basedSequence;
        this.closingMarker = basedSequence;
    }

    @Override // com.vladsch.flexmark.util.ast.Node
    public void getAstExtra(@NotNull StringBuilder sb) {
        Node.delimitedSegmentSpan(sb, this.openingMarker, this.text, this.closingMarker, "text");
    }

    @Override // com.vladsch.flexmark.util.ast.DelimitedNode
    public BasedSequence getClosingMarker() {
        return this.closingMarker;
    }

    @Override // com.vladsch.flexmark.util.ast.DelimitedNode
    public BasedSequence getOpeningMarker() {
        return this.openingMarker;
    }

    @Override // com.vladsch.flexmark.util.ast.Node
    @NotNull
    public BasedSequence[] getSegments() {
        return new BasedSequence[]{this.openingMarker, this.text, this.closingMarker};
    }

    @Override // com.vladsch.flexmark.util.ast.DelimitedNode
    public BasedSequence getText() {
        return this.text;
    }

    @Override // com.vladsch.flexmark.util.ast.DelimitedNode
    public void setClosingMarker(BasedSequence basedSequence) {
        this.closingMarker = basedSequence;
    }

    @Override // com.vladsch.flexmark.util.ast.DelimitedNode
    public void setOpeningMarker(BasedSequence basedSequence) {
        this.openingMarker = basedSequence;
    }

    @Override // com.vladsch.flexmark.util.ast.DelimitedNode
    public void setText(BasedSequence basedSequence) {
        this.text = basedSequence;
    }

    public Strikethrough(BasedSequence basedSequence) {
        super(basedSequence);
        BasedSequence basedSequence2 = BasedSequence.NULL;
        this.openingMarker = basedSequence2;
        this.text = basedSequence2;
        this.closingMarker = basedSequence2;
    }

    public Strikethrough(BasedSequence basedSequence, BasedSequence basedSequence2, BasedSequence basedSequence3) {
        super(basedSequence.baseSubSequence(basedSequence.getStartOffset(), basedSequence3.getEndOffset()));
        BasedSequence basedSequence4 = BasedSequence.NULL;
        this.openingMarker = basedSequence;
        this.text = basedSequence2;
        this.closingMarker = basedSequence3;
    }
}
