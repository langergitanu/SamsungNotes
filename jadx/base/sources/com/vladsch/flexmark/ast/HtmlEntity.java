package com.vladsch.flexmark.ast;

import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.ast.NodeVisitor;
import com.vladsch.flexmark.util.ast.TextContainer;
import com.vladsch.flexmark.util.misc.BitFieldSet;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import com.vladsch.flexmark.util.sequence.Escaping;
import com.vladsch.flexmark.util.sequence.ReplacedTextMapper;
import com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class HtmlEntity extends Node implements TextContainer {
    public HtmlEntity() {
    }

    @Override // com.vladsch.flexmark.util.ast.TextContainer
    public boolean collectText(ISequenceBuilder<? extends ISequenceBuilder<?, BasedSequence>, BasedSequence> iSequenceBuilder, int i, NodeVisitor nodeVisitor) {
        if (BitFieldSet.any(i, TextContainer.F_NODE_TEXT)) {
            iSequenceBuilder.append((CharSequence) getChars());
            return false;
        }
        iSequenceBuilder.append((CharSequence) Escaping.unescape(getChars(), new ReplacedTextMapper(getChars())));
        return false;
    }

    @Override // com.vladsch.flexmark.util.ast.Node
    public void getAstExtra(@NotNull StringBuilder sb) {
        if (getChars().isEmpty()) {
            return;
        }
        sb.append(" \"");
        sb.append((CharSequence) getChars());
        sb.append("\"");
    }

    @Override // com.vladsch.flexmark.util.ast.Node
    @NotNull
    public BasedSequence[] getSegments() {
        return Node.EMPTY_SEGMENTS;
    }

    public HtmlEntity(BasedSequence basedSequence) {
        super(basedSequence);
    }
}
