package com.vladsch.flexmark.ast;

import com.vladsch.flexmark.util.sequence.BasedSequence;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class Link extends InlineLinkNode {
    public Link() {
    }

    @Override // com.vladsch.flexmark.ast.InlineLinkNode
    public void setTextChars(BasedSequence basedSequence) {
        int length = basedSequence.length();
        this.textOpeningMarker = basedSequence.subSequence(0, 1);
        int i = length - 1;
        this.text = basedSequence.subSequence(1, i).trim();
        this.textClosingMarker = basedSequence.subSequence(i, length);
    }

    public Link(BasedSequence basedSequence) {
        super(basedSequence);
    }

    public Link(BasedSequence basedSequence, BasedSequence basedSequence2, BasedSequence basedSequence3, BasedSequence basedSequence4, BasedSequence basedSequence5, BasedSequence basedSequence6, BasedSequence basedSequence7, BasedSequence basedSequence8, BasedSequence basedSequence9) {
        super(basedSequence, basedSequence2, basedSequence3, basedSequence4, basedSequence5, basedSequence6, basedSequence7, basedSequence8, basedSequence9);
    }

    public Link(BasedSequence basedSequence, BasedSequence basedSequence2, BasedSequence basedSequence3, BasedSequence basedSequence4, BasedSequence basedSequence5, BasedSequence basedSequence6, BasedSequence basedSequence7, BasedSequence basedSequence8, BasedSequence basedSequence9, BasedSequence basedSequence10) {
        super(basedSequence, basedSequence2, basedSequence3, basedSequence4, basedSequence5, basedSequence6, basedSequence7, basedSequence8, basedSequence9, basedSequence10);
    }

    public Link(BasedSequence basedSequence, BasedSequence basedSequence2, BasedSequence basedSequence3, BasedSequence basedSequence4, BasedSequence basedSequence5, BasedSequence basedSequence6) {
        super(basedSequence, basedSequence2, basedSequence3, basedSequence4, basedSequence5, basedSequence6);
    }

    public Link(BasedSequence basedSequence, BasedSequence basedSequence2, BasedSequence basedSequence3, BasedSequence basedSequence4, BasedSequence basedSequence5, BasedSequence basedSequence6, BasedSequence basedSequence7) {
        super(basedSequence, basedSequence2, basedSequence3, basedSequence4, basedSequence5, basedSequence6, basedSequence7);
    }
}
