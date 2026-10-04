package com.vladsch.flexmark.ast;

import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import com.vladsch.flexmark.util.sequence.BasedSequenceImpl;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class DelimitedLinkNode extends LinkNode {
    protected BasedSequence closingMarker;
    protected BasedSequence openingMarker;
    protected BasedSequence text;

    public DelimitedLinkNode() {
        BasedSequence basedSequence = BasedSequence.NULL;
        this.openingMarker = basedSequence;
        this.text = basedSequence;
        this.closingMarker = basedSequence;
    }

    @Override // com.vladsch.flexmark.util.ast.Node
    public void getAstExtra(@NotNull StringBuilder sb) {
        Node.delimitedSegmentSpanChars(sb, this.openingMarker, this.text, this.closingMarker, "text");
    }

    public BasedSequence getClosingMarker() {
        return this.closingMarker;
    }

    public BasedSequence getLeadSegment() {
        return BasedSequenceImpl.firstNonNull(this.openingMarker, this.text);
    }

    public BasedSequence getOpeningMarker() {
        return this.openingMarker;
    }

    @Override // com.vladsch.flexmark.util.ast.Node
    @NotNull
    public BasedSequence[] getSegments() {
        return new BasedSequence[]{this.openingMarker, this.text, this.closingMarker};
    }

    public BasedSequence getText() {
        return this.text;
    }

    public void setClosingMarker(BasedSequence basedSequence) {
        this.closingMarker = basedSequence;
    }

    public void setOpeningMarker(BasedSequence basedSequence) {
        this.openingMarker = basedSequence;
    }

    public void setText(BasedSequence basedSequence) {
        this.text = basedSequence;
    }

    public DelimitedLinkNode(BasedSequence basedSequence) {
        super(basedSequence);
        BasedSequence basedSequence2 = BasedSequence.NULL;
        this.openingMarker = basedSequence2;
        this.text = basedSequence2;
        this.closingMarker = basedSequence2;
    }

    public DelimitedLinkNode(BasedSequence basedSequence, BasedSequence basedSequence2, BasedSequence basedSequence3) {
        super(basedSequence.baseSubSequence(basedSequence.getStartOffset(), basedSequence3.getEndOffset()));
        BasedSequence basedSequence4 = BasedSequence.NULL;
        this.openingMarker = basedSequence;
        this.text = basedSequence2;
        this.closingMarker = basedSequence3;
    }
}
