package com.vladsch.flexmark.ast;

import com.vladsch.flexmark.parser.ListOptions;
import com.vladsch.flexmark.util.ast.BlankLineContainer;
import com.vladsch.flexmark.util.ast.Block;
import com.vladsch.flexmark.util.ast.BlockContent;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.DataHolder;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import java.util.List;
import org.apache.commons.lang3.concurrent.AbstractCircuitBreaker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public abstract class ListItem extends Block implements ParagraphItemContainer, BlankLineContainer, ParagraphContainer {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private boolean containsBlankLine;
    private boolean hadBlankAfterItemParagraph;
    protected BasedSequence markerSuffix;
    protected BasedSequence openingMarker;
    private int priority;
    private boolean tight;

    public ListItem() {
        BasedSequence basedSequence = BasedSequence.NULL;
        this.openingMarker = basedSequence;
        this.markerSuffix = basedSequence;
        this.tight = true;
        this.hadBlankAfterItemParagraph = false;
        this.containsBlankLine = false;
        this.priority = Integer.MIN_VALUE;
    }

    public boolean canChangeMarker() {
        return true;
    }

    @Override // com.vladsch.flexmark.util.ast.Node
    public void getAstExtra(@NotNull StringBuilder sb) {
        Node.segmentSpanChars(sb, this.openingMarker, AbstractCircuitBreaker.PROPERTY_NAME);
        Node.segmentSpanChars(sb, this.markerSuffix, "openSuffix");
        if (isTight()) {
            sb.append(" isTight");
        } else {
            sb.append(" isLoose");
        }
        if (isHadBlankAfterItemParagraph()) {
            sb.append(" hadBlankLineAfter");
        } else if (isContainsBlankLine()) {
            sb.append(" hadBlankLine");
        }
    }

    @Override // com.vladsch.flexmark.util.ast.Node
    public Node getLastBlankLineChild() {
        return getLastChild();
    }

    public BasedSequence getMarkerSuffix() {
        return this.markerSuffix;
    }

    public BasedSequence getOpeningMarker() {
        return this.openingMarker;
    }

    public int getPriority() {
        return this.priority;
    }

    @Override // com.vladsch.flexmark.util.ast.Node
    @NotNull
    public BasedSequence[] getSegments() {
        return new BasedSequence[]{this.openingMarker, this.markerSuffix};
    }

    public boolean isContainsBlankLine() {
        return this.containsBlankLine;
    }

    public boolean isHadBlankAfterItemParagraph() {
        return this.hadBlankAfterItemParagraph;
    }

    public boolean isInTightList() {
        return !(getParent() instanceof ListBlock) || ((ListBlock) getParent()).isTight();
    }

    @Override // com.vladsch.flexmark.ast.ParagraphItemContainer
    public boolean isItemParagraph(Paragraph paragraph) {
        Node firstChild = getFirstChild();
        while (firstChild != null && !(firstChild instanceof Paragraph)) {
            firstChild = firstChild.getNext();
        }
        return firstChild == paragraph;
    }

    public boolean isLoose() {
        return !isTight();
    }

    public boolean isOrderedItem() {
        return false;
    }

    public boolean isOwnTight() {
        return this.tight;
    }

    @Override // com.vladsch.flexmark.ast.ParagraphContainer
    public boolean isParagraphEndWrappingDisabled(Paragraph paragraph) {
        if (getFirstChild() != paragraph && getLastChild() == paragraph) {
            return true;
        }
        if (getFirstChild() == paragraph) {
            return getParent() == null || getParent().getLastChildAny(ListItem.class) == this;
        }
        return false;
    }

    @Override // com.vladsch.flexmark.ast.ParagraphItemContainer
    public boolean isParagraphInTightListItem(Paragraph paragraph) {
        if (isTight()) {
            return isItemParagraph(paragraph);
        }
        return false;
    }

    @Override // com.vladsch.flexmark.ast.ParagraphContainer
    public boolean isParagraphStartWrappingDisabled(Paragraph paragraph) {
        return isItemParagraph(paragraph);
    }

    @Override // com.vladsch.flexmark.ast.ParagraphItemContainer
    public boolean isParagraphWrappingDisabled(Paragraph paragraph, ListOptions listOptions, DataHolder dataHolder) {
        return listOptions.isInTightListItem(paragraph);
    }

    public boolean isTight() {
        return this.tight && isInTightList();
    }

    public void setContainsBlankLine(boolean z) {
        this.containsBlankLine = z;
    }

    public void setHadBlankAfterItemParagraph(boolean z) {
        this.hadBlankAfterItemParagraph = z;
    }

    public void setLoose(boolean z) {
        this.tight = !z;
    }

    public void setMarkerSuffix(BasedSequence basedSequence) {
        this.markerSuffix = basedSequence;
    }

    public void setOpeningMarker(BasedSequence basedSequence) {
        this.openingMarker = basedSequence;
    }

    public void setPriority(int i) {
        this.priority = i;
    }

    public void setTight(boolean z) {
        this.tight = z;
    }

    public ListItem(ListItem listItem) {
        BasedSequence basedSequence = BasedSequence.NULL;
        this.openingMarker = basedSequence;
        this.markerSuffix = basedSequence;
        this.tight = true;
        this.hadBlankAfterItemParagraph = false;
        this.containsBlankLine = false;
        this.priority = Integer.MIN_VALUE;
        this.openingMarker = listItem.openingMarker;
        this.markerSuffix = listItem.markerSuffix;
        this.tight = listItem.tight;
        this.hadBlankAfterItemParagraph = listItem.hadBlankAfterItemParagraph;
        this.containsBlankLine = listItem.containsBlankLine;
        this.priority = listItem.priority;
        takeChildren(listItem);
        setCharsFromContent();
    }

    public ListItem(BasedSequence basedSequence) {
        super(basedSequence);
        BasedSequence basedSequence2 = BasedSequence.NULL;
        this.openingMarker = basedSequence2;
        this.markerSuffix = basedSequence2;
        this.tight = true;
        this.hadBlankAfterItemParagraph = false;
        this.containsBlankLine = false;
        this.priority = Integer.MIN_VALUE;
    }

    public ListItem(BasedSequence basedSequence, List<BasedSequence> list) {
        super(basedSequence, list);
        BasedSequence basedSequence2 = BasedSequence.NULL;
        this.openingMarker = basedSequence2;
        this.markerSuffix = basedSequence2;
        this.tight = true;
        this.hadBlankAfterItemParagraph = false;
        this.containsBlankLine = false;
        this.priority = Integer.MIN_VALUE;
    }

    public ListItem(BlockContent blockContent) {
        super(blockContent);
        BasedSequence basedSequence = BasedSequence.NULL;
        this.openingMarker = basedSequence;
        this.markerSuffix = basedSequence;
        this.tight = true;
        this.hadBlankAfterItemParagraph = false;
        this.containsBlankLine = false;
        this.priority = Integer.MIN_VALUE;
    }
}
