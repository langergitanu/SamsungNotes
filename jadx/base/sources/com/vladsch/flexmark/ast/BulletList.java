package com.vladsch.flexmark.ast;

import com.vladsch.flexmark.util.ast.BlockContent;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class BulletList extends ListBlock {
    private char openingMarker;

    public BulletList() {
    }

    public char getOpeningMarker() {
        return this.openingMarker;
    }

    @Override // com.vladsch.flexmark.util.ast.Node
    @NotNull
    public BasedSequence[] getSegments() {
        return Node.EMPTY_SEGMENTS;
    }

    public void setOpeningMarker(char c) {
        this.openingMarker = c;
    }

    public BulletList(BasedSequence basedSequence) {
        super(basedSequence);
    }

    public BulletList(BasedSequence basedSequence, List<BasedSequence> list) {
        super(basedSequence, list);
    }

    public BulletList(BlockContent blockContent) {
        super(blockContent);
    }
}
