package com.vladsch.flexmark.util.ast;

import com.vladsch.flexmark.util.sequence.BasedSequence;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public abstract class Block extends ContentNode {
    public Block() {
    }

    @Override // com.vladsch.flexmark.util.ast.Node
    public void setParent(@Nullable Node node) {
        if (node != null && !(node instanceof Block)) {
            throw new IllegalArgumentException("Parent of block must also be block (can not be inline)");
        }
        super.setParent(node);
    }

    public Block(@NotNull BasedSequence basedSequence) {
        super(basedSequence);
    }

    @Override // com.vladsch.flexmark.util.ast.Node
    @Nullable
    public Block getParent() {
        return (Block) super.getParent();
    }

    public Block(@NotNull BasedSequence basedSequence, @NotNull List<BasedSequence> list) {
        super(basedSequence, list);
    }

    public Block(@NotNull List<BasedSequence> list) {
        super(list);
    }

    public Block(BlockContent blockContent) {
        super(blockContent);
    }
}
