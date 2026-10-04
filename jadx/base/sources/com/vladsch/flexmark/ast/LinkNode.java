package com.vladsch.flexmark.ast;

import com.vladsch.flexmark.util.ast.DoNotLinkDecorate;
import com.vladsch.flexmark.util.ast.NodeVisitor;
import com.vladsch.flexmark.util.ast.TextContainer;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import com.vladsch.flexmark.util.sequence.Escaping;
import com.vladsch.flexmark.util.sequence.ReplacedTextMapper;
import com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public abstract class LinkNode extends LinkNodeBase implements DoNotLinkDecorate, TextContainer {
    public LinkNode() {
    }

    @Override // com.vladsch.flexmark.util.ast.TextContainer
    public boolean collectText(ISequenceBuilder<? extends ISequenceBuilder<?, BasedSequence>, BasedSequence> iSequenceBuilder, int i, NodeVisitor nodeVisitor) {
        BasedSequence pageRef;
        int i2 = i & TextContainer.F_LINK_TEXT_TYPE;
        if (i2 == 1) {
            pageRef = getPageRef();
        } else if (i2 == 2) {
            pageRef = getAnchorRef();
        } else if (i2 == 3) {
            pageRef = getUrl();
        } else {
            if (i2 != 4) {
                return true;
            }
            pageRef = BasedSequence.NULL;
        }
        if (i2 == 4) {
            iSequenceBuilder.append((CharSequence) getChars());
            return false;
        }
        ReplacedTextMapper replacedTextMapper = new ReplacedTextMapper(pageRef);
        iSequenceBuilder.append((CharSequence) Escaping.percentDecodeUrl(Escaping.unescape(pageRef, replacedTextMapper), replacedTextMapper));
        return false;
    }

    public LinkNode(BasedSequence basedSequence) {
        super(basedSequence);
    }
}
