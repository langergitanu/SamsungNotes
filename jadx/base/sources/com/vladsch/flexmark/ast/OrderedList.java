package com.vladsch.flexmark.ast;

import com.vladsch.flexmark.util.ast.BlockContent;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class OrderedList extends ListBlock {
    private char delimiter;
    private int startNumber;

    public OrderedList() {
    }

    @Override // com.vladsch.flexmark.ast.ListBlock, com.vladsch.flexmark.util.ast.Node
    public void getAstExtra(@NotNull StringBuilder sb) {
        super.getAstExtra(sb);
        if (this.startNumber > 1) {
            sb.append(" start:");
            sb.append(this.startNumber);
        }
        sb.append(" delimiter:'");
        sb.append(this.delimiter);
        sb.append("'");
    }

    public char getDelimiter() {
        return this.delimiter;
    }

    @Override // com.vladsch.flexmark.util.ast.Node
    @NotNull
    public BasedSequence[] getSegments() {
        return Node.EMPTY_SEGMENTS;
    }

    public int getStartNumber() {
        return this.startNumber;
    }

    public void setDelimiter(char c) {
        this.delimiter = c;
    }

    public void setStartNumber(int i) {
        this.startNumber = i;
    }

    public OrderedList(BasedSequence basedSequence) {
        super(basedSequence);
    }

    public OrderedList(BasedSequence basedSequence, List<BasedSequence> list) {
        super(basedSequence, list);
    }

    public OrderedList(BlockContent blockContent) {
        super(blockContent);
    }
}
