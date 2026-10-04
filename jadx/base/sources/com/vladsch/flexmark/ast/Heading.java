package com.vladsch.flexmark.ast;

import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.util.ast.Block;
import com.vladsch.flexmark.util.ast.BlockContent;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.ast.TextCollectingVisitor;
import com.vladsch.flexmark.util.ast.TextContainer;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class Heading extends Block implements AnchorRefTarget {
    protected String anchorRefId;
    protected BasedSequence closingMarker;
    protected boolean explicitAnchorRefId;
    protected int level;
    protected BasedSequence openingMarker;
    protected BasedSequence text;

    public Heading() {
        BasedSequence basedSequence = BasedSequence.NULL;
        this.openingMarker = basedSequence;
        this.text = basedSequence;
        this.closingMarker = basedSequence;
        this.anchorRefId = "";
        this.explicitAnchorRefId = false;
    }

    @Override // com.vladsch.flexmark.ast.AnchorRefTarget
    public String getAnchorRefId() {
        return this.anchorRefId;
    }

    @Override // com.vladsch.flexmark.ast.AnchorRefTarget
    public String getAnchorRefText() {
        return new TextCollectingVisitor().collectAndGetText(this, TextContainer.F_FOR_HEADING_ID + (HtmlRenderer.HEADER_ID_REF_TEXT_TRIM_LEADING_SPACES.get(getDocument()).booleanValue() ? 0 : TextContainer.F_NO_TRIM_REF_TEXT_START) + (HtmlRenderer.HEADER_ID_REF_TEXT_TRIM_TRAILING_SPACES.get(getDocument()).booleanValue() ? 0 : TextContainer.F_NO_TRIM_REF_TEXT_END));
    }

    @Override // com.vladsch.flexmark.util.ast.Node
    public void getAstExtra(@NotNull StringBuilder sb) {
        Node.delimitedSegmentSpanChars(sb, this.openingMarker, this.text, this.closingMarker, "text");
    }

    public BasedSequence getClosingMarker() {
        return this.closingMarker;
    }

    public int getLevel() {
        return this.level;
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

    public boolean isAtxHeading() {
        return this.openingMarker != BasedSequence.NULL;
    }

    @Override // com.vladsch.flexmark.ast.AnchorRefTarget
    public boolean isExplicitAnchorRefId() {
        return this.explicitAnchorRefId;
    }

    public boolean isSetextHeading() {
        BasedSequence basedSequence = this.openingMarker;
        BasedSequence basedSequence2 = BasedSequence.NULL;
        return basedSequence == basedSequence2 && this.closingMarker != basedSequence2;
    }

    @Override // com.vladsch.flexmark.ast.AnchorRefTarget
    public void setAnchorRefId(String str) {
        this.anchorRefId = str;
    }

    public void setClosingMarker(BasedSequence basedSequence) {
        if (basedSequence == null) {
            basedSequence = BasedSequence.NULL;
        }
        this.closingMarker = basedSequence;
    }

    @Override // com.vladsch.flexmark.ast.AnchorRefTarget
    public void setExplicitAnchorRefId(boolean z) {
        this.explicitAnchorRefId = z;
    }

    public void setLevel(int i) {
        this.level = i;
    }

    public void setOpeningMarker(BasedSequence basedSequence) {
        if (basedSequence == null) {
            basedSequence = BasedSequence.NULL;
        }
        this.openingMarker = basedSequence;
    }

    public void setText(BasedSequence basedSequence) {
        if (basedSequence == null) {
            basedSequence = BasedSequence.NULL;
        }
        this.text = basedSequence;
    }

    public Heading(BasedSequence basedSequence) {
        super(basedSequence);
        BasedSequence basedSequence2 = BasedSequence.NULL;
        this.openingMarker = basedSequence2;
        this.text = basedSequence2;
        this.closingMarker = basedSequence2;
        this.anchorRefId = "";
        this.explicitAnchorRefId = false;
    }

    public Heading(BasedSequence basedSequence, List<BasedSequence> list) {
        super(basedSequence, list);
        BasedSequence basedSequence2 = BasedSequence.NULL;
        this.openingMarker = basedSequence2;
        this.text = basedSequence2;
        this.closingMarker = basedSequence2;
        this.anchorRefId = "";
        this.explicitAnchorRefId = false;
    }

    public Heading(BlockContent blockContent) {
        super(blockContent);
        BasedSequence basedSequence = BasedSequence.NULL;
        this.openingMarker = basedSequence;
        this.text = basedSequence;
        this.closingMarker = basedSequence;
        this.anchorRefId = "";
        this.explicitAnchorRefId = false;
    }
}
