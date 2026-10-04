package com.vladsch.flexmark.ast;

import com.vladsch.flexmark.util.ast.DoNotLinkDecorate;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.ast.NodeVisitor;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class Code extends DelimitedNodeImpl implements DoNotLinkDecorate {
    public Code() {
    }

    @Override // com.vladsch.flexmark.util.ast.DelimitedNode, com.vladsch.flexmark.util.ast.TextContainer
    public boolean collectText(ISequenceBuilder<? extends ISequenceBuilder<?, BasedSequence>, BasedSequence> iSequenceBuilder, int i, NodeVisitor nodeVisitor) {
        iSequenceBuilder.append((CharSequence) getText());
        return false;
    }

    @Override // com.vladsch.flexmark.ast.DelimitedNodeImpl, com.vladsch.flexmark.util.ast.Node
    public void getAstExtra(@NotNull StringBuilder sb) {
        Node.delimitedSegmentSpan(sb, this.openingMarker, this.text, this.closingMarker, "text");
    }

    public Code(BasedSequence basedSequence) {
        super(basedSequence);
    }

    public Code(BasedSequence basedSequence, BasedSequence basedSequence2, BasedSequence basedSequence3) {
        super(basedSequence, basedSequence2, basedSequence3);
    }
}
