package com.vladsch.flexmark.ast;

import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import org.apache.commons.lang3.concurrent.AbstractCircuitBreaker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class AutoLink extends DelimitedLinkNode {
    public AutoLink() {
    }

    @Override // com.vladsch.flexmark.ast.DelimitedLinkNode, com.vladsch.flexmark.util.ast.Node
    public void getAstExtra(@NotNull StringBuilder sb) {
        Node.segmentSpanChars(sb, this.openingMarker, AbstractCircuitBreaker.PROPERTY_NAME);
        Node.segmentSpanChars(sb, this.text, "text");
        if (this.pageRef.isNotNull()) {
            Node.segmentSpanChars(sb, this.pageRef, "pageRef");
        }
        if (this.anchorMarker.isNotNull()) {
            Node.segmentSpanChars(sb, this.anchorMarker, "anchorMarker");
        }
        if (this.anchorRef.isNotNull()) {
            Node.segmentSpanChars(sb, this.anchorRef, "anchorRef");
        }
        Node.segmentSpanChars(sb, this.closingMarker, "close");
    }

    @Override // com.vladsch.flexmark.ast.DelimitedLinkNode, com.vladsch.flexmark.util.ast.Node
    @NotNull
    public BasedSequence[] getSegments() {
        return new BasedSequence[]{this.openingMarker, this.pageRef, this.anchorMarker, this.anchorRef, this.closingMarker};
    }

    @Override // com.vladsch.flexmark.util.ast.Node
    @NotNull
    public BasedSequence[] getSegmentsForChars() {
        return new BasedSequence[]{this.openingMarker, this.pageRef, this.anchorMarker, this.anchorRef, this.closingMarker};
    }

    public AutoLink(BasedSequence basedSequence) {
        super(basedSequence);
    }

    public AutoLink(BasedSequence basedSequence, BasedSequence basedSequence2, BasedSequence basedSequence3) {
        super(basedSequence, basedSequence2, basedSequence3);
        setUrlChars(basedSequence2);
    }
}
