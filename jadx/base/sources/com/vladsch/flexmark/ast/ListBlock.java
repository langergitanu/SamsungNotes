package com.vladsch.flexmark.ast;

import com.vladsch.flexmark.util.ast.BlankLineContainer;
import com.vladsch.flexmark.util.ast.Block;
import com.vladsch.flexmark.util.ast.BlockContent;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public abstract class ListBlock extends Block implements BlankLineContainer {
    private boolean tight;

    public ListBlock() {
    }

    @Override // com.vladsch.flexmark.util.ast.Node
    public void getAstExtra(@NotNull StringBuilder sb) {
        super.getAstExtra(sb);
        if (isTight()) {
            sb.append(" isTight");
        } else {
            sb.append(" isLoose");
        }
    }

    @Override // com.vladsch.flexmark.util.ast.Node
    public Node getLastBlankLineChild() {
        return getLastChild();
    }

    public boolean isLoose() {
        return !this.tight;
    }

    public boolean isTight() {
        return this.tight;
    }

    public void setLoose(boolean z) {
        this.tight = !z;
    }

    public void setTight(boolean z) {
        this.tight = z;
    }

    public ListBlock(BasedSequence basedSequence) {
        super(basedSequence);
    }

    public ListBlock(BasedSequence basedSequence, List<BasedSequence> list) {
        super(basedSequence, list);
    }

    public ListBlock(BlockContent blockContent) {
        super(blockContent);
    }
}
