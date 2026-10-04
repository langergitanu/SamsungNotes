package com.vladsch.flexmark.ast;

import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class Image extends InlineLinkNode {
    private BasedSequence urlContent;

    public Image() {
        this.urlContent = BasedSequence.NULL;
    }

    @Override // com.vladsch.flexmark.ast.InlineLinkNode, com.vladsch.flexmark.util.ast.Node
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
        if (this.urlContent.isNotNull()) {
            Node.segmentSpanChars(sb, this.urlContent, "urlContent");
        }
        Node.delimitedSegmentSpanChars(sb, this.titleOpeningMarker, this.title, this.titleClosingMarker, "title");
        Node.segmentSpanChars(sb, this.linkClosingMarker, "linkClose");
    }

    @Override // com.vladsch.flexmark.ast.InlineLinkNode, com.vladsch.flexmark.util.ast.Node
    @NotNull
    public BasedSequence[] getSegments() {
        BasedSequence basedSequence = this.textOpeningMarker;
        BasedSequence basedSequence2 = this.text;
        BasedSequence basedSequence3 = this.textClosingMarker;
        BasedSequence basedSequence4 = this.linkOpeningMarker;
        BasedSequence basedSequence5 = this.urlOpeningMarker;
        BasedSequence basedSequence6 = this.url;
        BasedSequence basedSequence7 = this.pageRef;
        BasedSequence basedSequence8 = this.anchorMarker;
        BasedSequence basedSequence9 = this.anchorRef;
        BasedSequence basedSequence10 = this.urlClosingMarker;
        BasedSequence basedSequence11 = this.urlContent;
        BasedSequence basedSequence12 = this.titleOpeningMarker;
        return new BasedSequence[]{basedSequence, basedSequence2, basedSequence3, basedSequence4, basedSequence5, basedSequence6, basedSequence7, basedSequence8, basedSequence9, basedSequence10, basedSequence11, basedSequence12, basedSequence12, this.title, this.titleClosingMarker, this.linkClosingMarker};
    }

    public BasedSequence getUrlContent() {
        return this.urlContent;
    }

    @Override // com.vladsch.flexmark.ast.InlineLinkNode
    public void setTextChars(BasedSequence basedSequence) {
        int length = basedSequence.length();
        this.textOpeningMarker = basedSequence.subSequence(0, 2);
        int i = length - 1;
        this.text = basedSequence.subSequence(2, i).trim();
        this.textClosingMarker = basedSequence.subSequence(i, length);
    }

    public void setUrlContent(BasedSequence basedSequence) {
        this.urlContent = basedSequence;
    }

    public Image(BasedSequence basedSequence) {
        super(basedSequence);
        this.urlContent = BasedSequence.NULL;
    }

    public Image(BasedSequence basedSequence, BasedSequence basedSequence2, BasedSequence basedSequence3, BasedSequence basedSequence4, BasedSequence basedSequence5, BasedSequence basedSequence6, BasedSequence basedSequence7, BasedSequence basedSequence8, BasedSequence basedSequence9) {
        super(basedSequence, basedSequence2, basedSequence3, basedSequence4, basedSequence5, basedSequence6, basedSequence7, basedSequence8, basedSequence9);
        this.urlContent = BasedSequence.NULL;
    }

    public Image(BasedSequence basedSequence, BasedSequence basedSequence2, BasedSequence basedSequence3, BasedSequence basedSequence4, BasedSequence basedSequence5, BasedSequence basedSequence6, BasedSequence basedSequence7, BasedSequence basedSequence8, BasedSequence basedSequence9, BasedSequence basedSequence10) {
        super(basedSequence, basedSequence2, basedSequence3, basedSequence4, basedSequence5, basedSequence6, basedSequence7, basedSequence8, basedSequence9, basedSequence10);
        this.urlContent = BasedSequence.NULL;
    }

    public Image(BasedSequence basedSequence, BasedSequence basedSequence2, BasedSequence basedSequence3, BasedSequence basedSequence4, BasedSequence basedSequence5, BasedSequence basedSequence6) {
        super(basedSequence, basedSequence2, basedSequence3, basedSequence4, basedSequence5, basedSequence6);
        this.urlContent = BasedSequence.NULL;
    }

    public Image(BasedSequence basedSequence, BasedSequence basedSequence2, BasedSequence basedSequence3, BasedSequence basedSequence4, BasedSequence basedSequence5, BasedSequence basedSequence6, BasedSequence basedSequence7) {
        super(basedSequence, basedSequence2, basedSequence3, basedSequence4, basedSequence5, basedSequence6, basedSequence7);
        this.urlContent = BasedSequence.NULL;
    }
}
