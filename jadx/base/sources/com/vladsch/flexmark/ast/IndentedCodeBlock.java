package com.vladsch.flexmark.ast;

import com.vladsch.flexmark.util.ast.Block;
import com.vladsch.flexmark.util.ast.BlockContent;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.ast.NodeVisitor;
import com.vladsch.flexmark.util.ast.TextContainer;
import com.vladsch.flexmark.util.misc.BitFieldSet;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import com.vladsch.flexmark.util.sequence.Escaping;
import com.vladsch.flexmark.util.sequence.ReplacedTextMapper;
import com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class IndentedCodeBlock extends Block implements TextContainer {
    public IndentedCodeBlock() {
    }

    @Override // com.vladsch.flexmark.util.ast.TextContainer
    public boolean collectText(ISequenceBuilder<? extends ISequenceBuilder<?, BasedSequence>, BasedSequence> iSequenceBuilder, int i, NodeVisitor nodeVisitor) {
        BasedSequence contentChars = getContentChars();
        if (BitFieldSet.any(i, TextContainer.F_NODE_TEXT)) {
            iSequenceBuilder.append((CharSequence) contentChars);
            return false;
        }
        BasedSequence basedSequenceUnescape = Escaping.unescape(contentChars, new ReplacedTextMapper(contentChars));
        if (basedSequenceUnescape.isEmpty()) {
            return false;
        }
        iSequenceBuilder.append((CharSequence) basedSequenceUnescape);
        return false;
    }

    @Override // com.vladsch.flexmark.util.ast.Node
    @NotNull
    public BasedSequence[] getSegments() {
        return Node.EMPTY_SEGMENTS;
    }

    public IndentedCodeBlock(BasedSequence basedSequence) {
        super(basedSequence);
    }

    public IndentedCodeBlock(BasedSequence basedSequence, List<BasedSequence> list) {
        super(basedSequence, list);
    }

    public IndentedCodeBlock(BlockContent blockContent) {
        super(blockContent);
    }
}
