package com.vladsch.flexmark.ast;

import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class WhiteSpace extends Node {
    public WhiteSpace() {
    }

    @Override // com.vladsch.flexmark.util.ast.Node
    public void getAstExtra(@NotNull StringBuilder sb) {
        astExtraChars(sb);
    }

    @Override // com.vladsch.flexmark.util.ast.Node
    @NotNull
    public BasedSequence[] getSegments() {
        return Node.EMPTY_SEGMENTS;
    }

    @Override // com.vladsch.flexmark.util.ast.Node
    @NotNull
    public String toStringAttributes() {
        return "text=" + ((Object) getChars());
    }

    public WhiteSpace(BasedSequence basedSequence) {
        super(basedSequence);
    }
}
