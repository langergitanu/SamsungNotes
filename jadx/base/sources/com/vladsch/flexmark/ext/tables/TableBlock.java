package com.vladsch.flexmark.ext.tables;

import com.vladsch.flexmark.util.ast.BlankLineBreakNode;
import com.vladsch.flexmark.util.ast.Block;
import com.vladsch.flexmark.util.ast.BlockContent;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class TableBlock extends Block implements BlankLineBreakNode {
    public TableBlock() {
    }

    public TableCaption getCaption() {
        Node lastChild = getLastChild();
        if (lastChild instanceof TableCaption) {
            return (TableCaption) lastChild;
        }
        return null;
    }

    @Override // com.vladsch.flexmark.util.ast.Node
    @NotNull
    public BasedSequence[] getSegments() {
        return new BasedSequence[0];
    }

    public TableBlock(BasedSequence basedSequence) {
        super(basedSequence);
    }

    public TableBlock(BasedSequence basedSequence, List<BasedSequence> list) {
        super(basedSequence, list);
    }

    public TableBlock(List<BasedSequence> list) {
        super(list);
    }

    public TableBlock(BlockContent blockContent) {
        super(blockContent);
    }
}
