package com.vladsch.flexmark.ext.gfm.tasklist;

import com.vladsch.flexmark.ast.ListItem;
import com.vladsch.flexmark.ast.OrderedListItem;
import com.vladsch.flexmark.ast.Paragraph;
import com.vladsch.flexmark.parser.ListOptions;
import com.vladsch.flexmark.util.ast.BlockContent;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.DataHolder;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class TaskListItem extends ListItem {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    protected boolean canChangeMarker;
    protected boolean isOrderedItem;

    public TaskListItem() {
        this.isOrderedItem = false;
        this.canChangeMarker = true;
    }

    @Override // com.vladsch.flexmark.ast.ListItem
    public boolean canChangeMarker() {
        return this.canChangeMarker;
    }

    @Override // com.vladsch.flexmark.ast.ListItem, com.vladsch.flexmark.util.ast.Node
    public void getAstExtra(@NotNull StringBuilder sb) {
        super.getAstExtra(sb);
        if (this.isOrderedItem) {
            sb.append(" isOrderedItem");
        }
        sb.append(isItemDoneMarker() ? " isDone" : " isNotDone");
    }

    public boolean isItemDoneMarker() {
        return !this.markerSuffix.matches("[ ]");
    }

    @Override // com.vladsch.flexmark.ast.ListItem
    public boolean isOrderedItem() {
        return this.isOrderedItem;
    }

    @Override // com.vladsch.flexmark.ast.ListItem, com.vladsch.flexmark.ast.ParagraphItemContainer
    public boolean isParagraphWrappingDisabled(Paragraph paragraph, ListOptions listOptions, DataHolder dataHolder) {
        Node firstChild = getFirstChild();
        while (firstChild != null && !(firstChild instanceof Paragraph)) {
            firstChild = firstChild.getNext();
        }
        return firstChild == paragraph;
    }

    public void setCanChangeMarker(boolean z) {
        this.canChangeMarker = z;
    }

    @Override // com.vladsch.flexmark.ast.ListItem
    public void setOpeningMarker(BasedSequence basedSequence) {
        throw new IllegalStateException();
    }

    public void setOrderedItem(boolean z) {
        this.isOrderedItem = z;
    }

    public TaskListItem(BasedSequence basedSequence) {
        super(basedSequence);
        this.isOrderedItem = false;
        this.canChangeMarker = true;
    }

    public TaskListItem(BasedSequence basedSequence, List<BasedSequence> list) {
        super(basedSequence, list);
        this.isOrderedItem = false;
        this.canChangeMarker = true;
    }

    public TaskListItem(BlockContent blockContent) {
        super(blockContent);
        this.isOrderedItem = false;
        this.canChangeMarker = true;
    }

    public TaskListItem(ListItem listItem) {
        super(listItem);
        this.canChangeMarker = true;
        this.isOrderedItem = listItem instanceof OrderedListItem;
    }
}
