package com.vladsch.flexmark.ast;

import com.vladsch.flexmark.ast.util.ReferenceRepository;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.ast.ReferenceNode;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import com.vladsch.flexmark.util.sequence.PrefixedSubSequence;
import com.vladsch.flexmark.util.sequence.SequenceUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class Reference extends LinkNodeBase implements ReferenceNode<ReferenceRepository, Reference, RefNode> {
    protected BasedSequence closingMarker;
    protected BasedSequence openingMarker;
    protected BasedSequence reference;

    /* JADX WARN: Illegal instructions before constructor call */
    public Reference(BasedSequence basedSequence, BasedSequence basedSequence2, BasedSequence basedSequence3) {
        BasedSequence basedSequence4 = BasedSequence.NULL;
        super(basedSequence4);
        this.openingMarker = basedSequence4;
        this.reference = basedSequence4;
        this.closingMarker = basedSequence4;
        this.openingMarker = basedSequence.subSequence(0, 1);
        this.reference = basedSequence.subSequence(1, basedSequence.length() - 2).trim();
        this.closingMarker = basedSequence.subSequence(basedSequence.length() - 2, basedSequence.length());
        setUrlChars(basedSequence2);
        if (basedSequence3 != null) {
            this.titleOpeningMarker = basedSequence3.subSequence(0, 1);
            this.title = basedSequence3.subSequence(1, basedSequence3.length() - 1);
            this.titleClosingMarker = basedSequence3.subSequence(basedSequence3.length() - 1, basedSequence3.length());
        }
        setCharsFromContent();
    }

    @Override // com.vladsch.flexmark.ast.LinkNodeBase
    public BasedSequence getAnchorMarker() {
        return this.anchorMarker;
    }

    @Override // com.vladsch.flexmark.ast.LinkNodeBase
    public BasedSequence getAnchorRef() {
        return this.anchorRef;
    }

    @Override // com.vladsch.flexmark.util.ast.Node
    public void getAstExtra(@NotNull StringBuilder sb) {
        Node.delimitedSegmentSpanChars(sb, this.openingMarker, this.reference, this.closingMarker, "ref");
        Node.delimitedSegmentSpanChars(sb, this.urlOpeningMarker, this.url, this.urlClosingMarker, "url");
        Node.delimitedSegmentSpanChars(sb, this.titleOpeningMarker, this.title, this.titleClosingMarker, "title");
    }

    public BasedSequence getClosingMarker() {
        return this.closingMarker;
    }

    public BasedSequence getOpeningMarker() {
        return this.openingMarker;
    }

    @Override // com.vladsch.flexmark.ast.LinkNodeBase
    public BasedSequence getPageRef() {
        return this.pageRef;
    }

    public BasedSequence getReference() {
        return this.reference;
    }

    @Override // com.vladsch.flexmark.util.ast.Node
    @NotNull
    public BasedSequence[] getSegments() {
        return new BasedSequence[]{this.openingMarker, this.reference, this.closingMarker, this.urlOpeningMarker, this.url, this.pageRef, this.anchorMarker, this.anchorRef, this.urlClosingMarker, this.titleOpeningMarker, this.title, this.titleClosingMarker};
    }

    @Override // com.vladsch.flexmark.util.ast.Node
    @NotNull
    public BasedSequence[] getSegmentsForChars() {
        BasedSequence basedSequence = this.openingMarker;
        BasedSequence basedSequence2 = this.reference;
        BasedSequence basedSequence3 = this.closingMarker;
        return new BasedSequence[]{basedSequence, basedSequence2, basedSequence3, PrefixedSubSequence.prefixOf(" ", basedSequence3.getEmptySuffix()), this.urlOpeningMarker, this.pageRef, this.anchorMarker, this.anchorRef, this.urlClosingMarker, this.titleOpeningMarker, this.title, this.titleClosingMarker};
    }

    @Override // com.vladsch.flexmark.ast.LinkNodeBase
    public BasedSequence getTitle() {
        return this.title;
    }

    @Override // com.vladsch.flexmark.ast.LinkNodeBase
    public BasedSequence getTitleClosingMarker() {
        return this.titleClosingMarker;
    }

    @Override // com.vladsch.flexmark.ast.LinkNodeBase
    public BasedSequence getTitleOpeningMarker() {
        return this.titleOpeningMarker;
    }

    @Override // com.vladsch.flexmark.ast.LinkNodeBase
    public BasedSequence getUrl() {
        return this.url;
    }

    @Override // com.vladsch.flexmark.ast.LinkNodeBase
    public BasedSequence getUrlClosingMarker() {
        return this.urlClosingMarker;
    }

    @Override // com.vladsch.flexmark.ast.LinkNodeBase
    public BasedSequence getUrlOpeningMarker() {
        return this.urlOpeningMarker;
    }

    @Override // com.vladsch.flexmark.ast.LinkNodeBase
    public void setAnchorMarker(BasedSequence basedSequence) {
        this.anchorMarker = basedSequence;
    }

    @Override // com.vladsch.flexmark.ast.LinkNodeBase
    public void setAnchorRef(BasedSequence basedSequence) {
        this.anchorRef = basedSequence;
    }

    public void setClosingMarker(BasedSequence basedSequence) {
        this.closingMarker = basedSequence;
    }

    public void setOpeningMarker(BasedSequence basedSequence) {
        this.openingMarker = basedSequence;
    }

    @Override // com.vladsch.flexmark.ast.LinkNodeBase
    public void setPageRef(BasedSequence basedSequence) {
        this.pageRef = basedSequence;
    }

    public void setReference(BasedSequence basedSequence) {
        this.reference = basedSequence;
    }

    @Override // com.vladsch.flexmark.ast.LinkNodeBase
    public void setTitle(BasedSequence basedSequence) {
        this.title = basedSequence;
    }

    @Override // com.vladsch.flexmark.ast.LinkNodeBase
    public void setTitleClosingMarker(BasedSequence basedSequence) {
        this.titleClosingMarker = basedSequence;
    }

    @Override // com.vladsch.flexmark.ast.LinkNodeBase
    public void setTitleOpeningMarker(BasedSequence basedSequence) {
        this.titleOpeningMarker = basedSequence;
    }

    @Override // com.vladsch.flexmark.ast.LinkNodeBase
    public void setUrl(BasedSequence basedSequence) {
        this.url = basedSequence;
    }

    @Override // com.vladsch.flexmark.ast.LinkNodeBase
    public void setUrlClosingMarker(BasedSequence basedSequence) {
        this.urlClosingMarker = basedSequence;
    }

    @Override // com.vladsch.flexmark.ast.LinkNodeBase
    public void setUrlOpeningMarker(BasedSequence basedSequence) {
        this.urlOpeningMarker = basedSequence;
    }

    @Override // com.vladsch.flexmark.util.ast.Node
    @NotNull
    public String toStringAttributes() {
        return "reference=" + ((Object) this.reference) + ", url=" + ((Object) this.url);
    }

    @Override // java.lang.Comparable
    public int compareTo(Reference reference) {
        return SequenceUtils.compare(getReference(), reference.getReference(), true);
    }

    @Override // com.vladsch.flexmark.util.ast.ReferenceNode
    @Nullable
    public RefNode getReferencingNode(@NotNull Node node) {
        if (node instanceof RefNode) {
            return (RefNode) node;
        }
        return null;
    }
}
