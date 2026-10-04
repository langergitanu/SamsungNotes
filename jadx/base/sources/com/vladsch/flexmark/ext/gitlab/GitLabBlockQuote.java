package com.vladsch.flexmark.ext.gitlab;

import com.vladsch.flexmark.ast.Paragraph;
import com.vladsch.flexmark.ast.ParagraphContainer;
import com.vladsch.flexmark.util.ast.Block;
import com.vladsch.flexmark.util.ast.BlockContent;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import java.util.List;
import org.apache.commons.lang3.concurrent.AbstractCircuitBreaker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class GitLabBlockQuote extends Block implements ParagraphContainer {
    private BasedSequence closingMarker;
    private BasedSequence closingTrailing;
    private BasedSequence openingMarker;
    private BasedSequence openingTrailing;

    public GitLabBlockQuote() {
        BasedSequence basedSequence = BasedSequence.NULL;
        this.openingMarker = basedSequence;
        this.openingTrailing = basedSequence;
        this.closingMarker = basedSequence;
        this.closingTrailing = basedSequence;
    }

    @Override // com.vladsch.flexmark.util.ast.Node
    public void getAstExtra(@NotNull StringBuilder sb) {
        Node.segmentSpanChars(sb, this.openingMarker, AbstractCircuitBreaker.PROPERTY_NAME);
        Node.segmentSpanChars(sb, this.openingTrailing, "openTrail");
        Node.segmentSpanChars(sb, this.closingMarker, "close");
        Node.segmentSpanChars(sb, this.closingTrailing, "closeTrail");
    }

    public BasedSequence getClosingMarker() {
        return this.closingMarker;
    }

    public BasedSequence getClosingTrailing() {
        return this.closingTrailing;
    }

    public BasedSequence getOpeningMarker() {
        return this.openingMarker;
    }

    public BasedSequence getOpeningTrailing() {
        return this.openingTrailing;
    }

    @Override // com.vladsch.flexmark.util.ast.Node
    @NotNull
    public BasedSequence[] getSegments() {
        return new BasedSequence[]{this.openingMarker, this.openingTrailing, this.closingMarker, this.closingTrailing};
    }

    @Override // com.vladsch.flexmark.ast.ParagraphContainer
    public boolean isParagraphEndWrappingDisabled(Paragraph paragraph) {
        return paragraph == getLastChild() || (paragraph.getNext() instanceof GitLabBlockQuote);
    }

    @Override // com.vladsch.flexmark.ast.ParagraphContainer
    public boolean isParagraphStartWrappingDisabled(Paragraph paragraph) {
        return paragraph == getFirstChild() || (paragraph.getPrevious() instanceof GitLabBlockQuote);
    }

    public void setClosingMarker(BasedSequence basedSequence) {
        this.closingMarker = basedSequence;
    }

    public void setClosingTrailing(BasedSequence basedSequence) {
        this.closingTrailing = basedSequence;
    }

    public void setOpeningMarker(BasedSequence basedSequence) {
        this.openingMarker = basedSequence;
    }

    public void setOpeningTrailing(BasedSequence basedSequence) {
        this.openingTrailing = basedSequence;
    }

    public GitLabBlockQuote(BasedSequence basedSequence) {
        super(basedSequence);
        BasedSequence basedSequence2 = BasedSequence.NULL;
        this.openingMarker = basedSequence2;
        this.openingTrailing = basedSequence2;
        this.closingMarker = basedSequence2;
        this.closingTrailing = basedSequence2;
    }

    public GitLabBlockQuote(BasedSequence basedSequence, List<BasedSequence> list) {
        super(basedSequence, list);
        BasedSequence basedSequence2 = BasedSequence.NULL;
        this.openingMarker = basedSequence2;
        this.openingTrailing = basedSequence2;
        this.closingMarker = basedSequence2;
        this.closingTrailing = basedSequence2;
    }

    public GitLabBlockQuote(BlockContent blockContent) {
        super(blockContent);
        BasedSequence basedSequence = BasedSequence.NULL;
        this.openingMarker = basedSequence;
        this.openingTrailing = basedSequence;
        this.closingMarker = basedSequence;
        this.closingTrailing = basedSequence;
    }
}
