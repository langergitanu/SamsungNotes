package com.vladsch.flexmark.ast;

import com.vladsch.flexmark.util.ast.Block;
import com.vladsch.flexmark.util.ast.BlockContent;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class CodeBlock extends Block {
    public CodeBlock() {
    }

    @Override // com.vladsch.flexmark.util.ast.Node
    @NotNull
    public BasedSequence[] getSegments() {
        return Node.EMPTY_SEGMENTS;
    }

    public CodeBlock(BasedSequence basedSequence) {
        super(basedSequence);
    }

    public CodeBlock(BasedSequence basedSequence, List<BasedSequence> list) {
        super(basedSequence, list);
    }

    public CodeBlock(BlockContent blockContent) {
        super(blockContent);
    }
}
