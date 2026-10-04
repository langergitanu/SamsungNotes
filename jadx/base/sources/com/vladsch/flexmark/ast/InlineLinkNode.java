package com.vladsch.flexmark.ast;

import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public abstract class InlineLinkNode extends LinkNode {
    protected BasedSequence linkClosingMarker;
    protected BasedSequence linkOpeningMarker;
    protected BasedSequence text;
    protected BasedSequence textClosingMarker;
    protected BasedSequence textOpeningMarker;

    public InlineLinkNode() {
        BasedSequence basedSequence = BasedSequence.NULL;
        this.textOpeningMarker = basedSequence;
        this.text = basedSequence;
        this.textClosingMarker = basedSequence;
        this.linkOpeningMarker = basedSequence;
        this.linkClosingMarker = basedSequence;
    }

    @Override // com.vladsch.flexmark.util.ast.Node
    public void getAstExtra(@NotNull StringBuilder sb) {
        Node.delimitedSegmentSpanChars(sb, this.textOpeningMarker, this.text, this.textClosingMarker, "text");
        Node.segmentSpanChars(sb, this.linkOpeningMarker, "linkOpen");
        Node.delimitedSegmentSpanChars(sb, this.urlOpeningMarker, this.url, this.urlClosingMarker, "url");
        if (this.pageRef.isNotNull()) {
            Node.segmentSpanChars(sb, this.pageRef, "pageRef");
        }
        if (this.anchorMarker.isNotNull()) {
            Node.segmentSpanChars(sb, this.anchorMarker, "anchorMarker");
        }
        if (this.anchorRef.isNotNull()) {
            Node.segmentSpanChars(sb, this.anchorRef, "anchorRef");
        }
        Node.delimitedSegmentSpanChars(sb, this.titleOpeningMarker, this.title, this.titleClosingMarker, "title");
        Node.segmentSpanChars(sb, this.linkClosingMarker, "linkClose");
    }

    public BasedSequence getLinkClosingMarker() {
        return this.linkClosingMarker;
    }

    public BasedSequence getLinkOpeningMarker() {
        return this.linkOpeningMarker;
    }

    @Override // com.vladsch.flexmark.util.ast.Node
    @NotNull
    public BasedSequence[] getSegments() {
        return new BasedSequence[]{this.textOpeningMarker, this.text, this.textClosingMarker, this.linkOpeningMarker, this.urlOpeningMarker, this.url, this.pageRef, this.anchorMarker, this.anchorRef, this.urlClosingMarker, this.titleOpeningMarker, this.title, this.titleClosingMarker, this.linkClosingMarker};
    }

    @Override // com.vladsch.flexmark.util.ast.Node
    @NotNull
    public BasedSequence[] getSegmentsForChars() {
        return new BasedSequence[]{this.textOpeningMarker, this.text, this.textClosingMarker, this.linkOpeningMarker, this.urlOpeningMarker, this.pageRef, this.anchorMarker, this.anchorRef, this.urlClosingMarker, this.titleOpeningMarker, this.title, this.titleClosingMarker, this.linkClosingMarker};
    }

    public BasedSequence getText() {
        return this.text;
    }

    public BasedSequence getTextClosingMarker() {
        return this.textClosingMarker;
    }

    public BasedSequence getTextOpeningMarker() {
        return this.textOpeningMarker;
    }

    public void setLinkClosingMarker(BasedSequence basedSequence) {
        this.linkClosingMarker = basedSequence;
    }

    public void setLinkOpeningMarker(BasedSequence basedSequence) {
        this.linkOpeningMarker = basedSequence;
    }

    public void setText(BasedSequence basedSequence) {
        this.text = basedSequence.trim();
    }

    public abstract void setTextChars(BasedSequence basedSequence);

    public void setTextClosingMarker(BasedSequence basedSequence) {
        this.textClosingMarker = basedSequence;
    }

    public void setTextOpeningMarker(BasedSequence basedSequence) {
        this.textOpeningMarker = basedSequence;
    }

    public void setUrl(BasedSequence basedSequence, BasedSequence basedSequence2, BasedSequence basedSequence3) {
        this.linkOpeningMarker = basedSequence;
        setUrlChars(basedSequence2);
        this.linkClosingMarker = basedSequence3;
    }

    @Override // com.vladsch.flexmark.util.ast.Node
    @NotNull
    public String toStringAttributes() {
        return "text=" + ((Object) this.text) + ", url=" + ((Object) this.url) + ", title=" + ((Object) this.title);
    }

    public InlineLinkNode(BasedSequence basedSequence) {
        super(basedSequence);
        BasedSequence basedSequence2 = BasedSequence.NULL;
        this.textOpeningMarker = basedSequence2;
        this.text = basedSequence2;
        this.textClosingMarker = basedSequence2;
        this.linkOpeningMarker = basedSequence2;
        this.linkClosingMarker = basedSequence2;
    }

    public InlineLinkNode(BasedSequence basedSequence, BasedSequence basedSequence2, BasedSequence basedSequence3, BasedSequence basedSequence4, BasedSequence basedSequence5, BasedSequence basedSequence6, BasedSequence basedSequence7, BasedSequence basedSequence8, BasedSequence basedSequence9) {
        BasedSequence basedSequence10 = BasedSequence.NULL;
        this.text = basedSequence10;
        this.textClosingMarker = basedSequence10;
        this.linkOpeningMarker = basedSequence10;
        this.linkClosingMarker = basedSequence10;
        this.textOpeningMarker = basedSequence;
        this.text = basedSequence2.trim();
        this.textClosingMarker = basedSequence3;
        this.linkOpeningMarker = basedSequence4;
        this.url = basedSequence5;
        this.titleOpeningMarker = basedSequence6;
        this.title = basedSequence7;
        this.titleClosingMarker = basedSequence8;
        this.linkClosingMarker = basedSequence9;
    }

    public InlineLinkNode(BasedSequence basedSequence, BasedSequence basedSequence2, BasedSequence basedSequence3, BasedSequence basedSequence4, BasedSequence basedSequence5, BasedSequence basedSequence6, BasedSequence basedSequence7, BasedSequence basedSequence8, BasedSequence basedSequence9, BasedSequence basedSequence10) {
        super(basedSequence);
        BasedSequence basedSequence11 = BasedSequence.NULL;
        this.text = basedSequence11;
        this.textClosingMarker = basedSequence11;
        this.linkOpeningMarker = basedSequence11;
        this.linkClosingMarker = basedSequence11;
        this.textOpeningMarker = basedSequence2;
        this.text = basedSequence3.trim();
        this.textClosingMarker = basedSequence4;
        this.linkOpeningMarker = basedSequence5;
        this.url = basedSequence6;
        this.titleOpeningMarker = basedSequence7;
        this.title = basedSequence8;
        this.titleClosingMarker = basedSequence9;
        this.linkClosingMarker = basedSequence10;
    }

    public InlineLinkNode(BasedSequence basedSequence, BasedSequence basedSequence2, BasedSequence basedSequence3, BasedSequence basedSequence4, BasedSequence basedSequence5, BasedSequence basedSequence6) {
        BasedSequence basedSequence7 = BasedSequence.NULL;
        this.text = basedSequence7;
        this.textClosingMarker = basedSequence7;
        this.linkOpeningMarker = basedSequence7;
        this.linkClosingMarker = basedSequence7;
        this.textOpeningMarker = basedSequence;
        this.text = basedSequence2.trim();
        this.textClosingMarker = basedSequence3;
        this.linkOpeningMarker = basedSequence4;
        this.url = basedSequence5;
        this.linkClosingMarker = basedSequence6;
    }

    public InlineLinkNode(BasedSequence basedSequence, BasedSequence basedSequence2, BasedSequence basedSequence3, BasedSequence basedSequence4, BasedSequence basedSequence5, BasedSequence basedSequence6, BasedSequence basedSequence7) {
        super(basedSequence);
        BasedSequence basedSequence8 = BasedSequence.NULL;
        this.text = basedSequence8;
        this.textClosingMarker = basedSequence8;
        this.linkOpeningMarker = basedSequence8;
        this.linkClosingMarker = basedSequence8;
        this.textOpeningMarker = basedSequence2;
        this.text = basedSequence3.trim();
        this.textClosingMarker = basedSequence4;
        this.linkOpeningMarker = basedSequence5;
        this.url = basedSequence6;
        this.linkClosingMarker = basedSequence7;
    }
}
