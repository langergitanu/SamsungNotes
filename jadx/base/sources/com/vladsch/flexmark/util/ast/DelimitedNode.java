package com.vladsch.flexmark.util.ast;

import com.vladsch.flexmark.util.misc.BitFieldSet;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface DelimitedNode extends TextContainer {
    @Override // com.vladsch.flexmark.util.ast.TextContainer
    default boolean collectText(ISequenceBuilder<? extends ISequenceBuilder<?, BasedSequence>, BasedSequence> iSequenceBuilder, int i, NodeVisitor nodeVisitor) {
        if (!BitFieldSet.any(i, TextContainer.F_NODE_TEXT)) {
            return true;
        }
        iSequenceBuilder.append((CharSequence) getText());
        return false;
    }

    BasedSequence getChars();

    BasedSequence getClosingMarker();

    BasedSequence getOpeningMarker();

    BasedSequence getText();

    void setClosingMarker(BasedSequence basedSequence);

    void setOpeningMarker(BasedSequence basedSequence);

    void setText(BasedSequence basedSequence);
}
