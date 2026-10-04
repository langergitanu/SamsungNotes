package com.vladsch.flexmark.ast;

import com.vladsch.flexmark.util.ast.BlockContent;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class HtmlBlock extends HtmlBlockBase {
    public HtmlBlock() {
    }

    @Override // com.vladsch.flexmark.ast.HtmlBlockBase, com.vladsch.flexmark.util.ast.Node
    @NotNull
    public BasedSequence[] getSegments() {
        return Node.EMPTY_SEGMENTS;
    }

    public HtmlBlock(BasedSequence basedSequence) {
        super(basedSequence);
    }

    public HtmlBlock(BasedSequence basedSequence, List<BasedSequence> list) {
        super(basedSequence, list);
    }

    public HtmlBlock(BlockContent blockContent) {
        super(blockContent);
    }
}
