package com.vladsch.flexmark.ast;

import com.vladsch.flexmark.util.ast.BlockContent;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class OrderedListItem extends ListItem {
    public OrderedListItem() {
    }

    @Override // com.vladsch.flexmark.ast.ListItem
    public boolean isOrderedItem() {
        return true;
    }

    public OrderedListItem(BasedSequence basedSequence) {
        super(basedSequence);
    }

    public OrderedListItem(BasedSequence basedSequence, List<BasedSequence> list) {
        super(basedSequence, list);
    }

    public OrderedListItem(BlockContent blockContent) {
        super(blockContent);
    }
}
