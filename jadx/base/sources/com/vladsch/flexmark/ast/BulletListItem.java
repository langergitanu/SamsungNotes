package com.vladsch.flexmark.ast;

import com.vladsch.flexmark.util.ast.BlockContent;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class BulletListItem extends ListItem {
    public BulletListItem() {
    }

    public BulletListItem(BasedSequence basedSequence) {
        super(basedSequence);
    }

    public BulletListItem(BasedSequence basedSequence, List<BasedSequence> list) {
        super(basedSequence, list);
    }

    public BulletListItem(BlockContent blockContent) {
        super(blockContent);
    }
}
