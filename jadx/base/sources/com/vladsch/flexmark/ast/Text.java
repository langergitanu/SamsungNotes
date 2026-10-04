package com.vladsch.flexmark.ast;

import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.ast.NodeVisitor;
import com.vladsch.flexmark.util.ast.TextContainer;
import com.vladsch.flexmark.util.misc.BitFieldSet;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import com.vladsch.flexmark.util.sequence.Escaping;
import com.vladsch.flexmark.util.sequence.PrefixedSubSequence;
import com.vladsch.flexmark.util.sequence.ReplacedTextMapper;
import com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final class Text extends Node implements TextContainer {
    public Text() {
    }

    @Override // com.vladsch.flexmark.util.ast.TextContainer
    public boolean collectText(ISequenceBuilder<? extends ISequenceBuilder<?, BasedSequence>, BasedSequence> iSequenceBuilder, int i, NodeVisitor nodeVisitor) {
        if (BitFieldSet.any(i, TextContainer.F_NODE_TEXT)) {
            iSequenceBuilder.append((CharSequence) getChars());
            return false;
        }
        BasedSequence basedSequenceUnescape = Escaping.unescape(getChars(), new ReplacedTextMapper(getChars()));
        if (basedSequenceUnescape.isEmpty()) {
            return false;
        }
        iSequenceBuilder.append((CharSequence) basedSequenceUnescape);
        return false;
    }

    @Override // com.vladsch.flexmark.util.ast.Node
    public void getAstExtra(@NotNull StringBuilder sb) {
        astExtraChars(sb);
        if (getChars() instanceof PrefixedSubSequence) {
            Node.astChars(sb, getChars(), "text");
        }
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

    public Text(BasedSequence basedSequence) {
        super(basedSequence);
    }

    public Text(String str) {
        super(BasedSequence.m13437of(str));
    }

    public Text(String str, BasedSequence basedSequence) {
        super(PrefixedSubSequence.prefixOf(str, basedSequence));
    }
}
