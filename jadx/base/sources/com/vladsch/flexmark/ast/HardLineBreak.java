package com.vladsch.flexmark.ast;

import com.vladsch.flexmark.util.ast.DoNotTrim;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.ast.NodeVisitor;
import com.vladsch.flexmark.util.ast.TextContainer;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class HardLineBreak extends Node implements DoNotTrim, TextContainer {
    public HardLineBreak() {
    }

    @Override // com.vladsch.flexmark.util.ast.TextContainer
    public boolean collectText(ISequenceBuilder<? extends ISequenceBuilder<?, BasedSequence>, BasedSequence> iSequenceBuilder, int i, NodeVisitor nodeVisitor) {
        BasedSequence chars = getChars();
        iSequenceBuilder.add(chars.subSequence(chars.length() - 1, chars.length()));
        return false;
    }

    @Override // com.vladsch.flexmark.util.ast.Node
    @NotNull
    public BasedSequence[] getSegments() {
        return Node.EMPTY_SEGMENTS;
    }

    public HardLineBreak(BasedSequence basedSequence) {
        super(basedSequence);
    }
}
