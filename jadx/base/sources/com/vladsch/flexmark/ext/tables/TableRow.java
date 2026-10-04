package com.vladsch.flexmark.ext.tables;

import com.vladsch.flexmark.util.ast.LineBreakNode;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class TableRow extends Node implements LineBreakNode {
    private int rowNumber;

    public TableRow() {
    }

    @Override // com.vladsch.flexmark.util.ast.Node
    public void getAstExtra(@NotNull StringBuilder sb) {
        super.getAstExtra(sb);
        if (this.rowNumber != 0) {
            sb.append(" rowNumber=");
            sb.append(this.rowNumber);
        }
    }

    public int getRowNumber() {
        return this.rowNumber;
    }

    @Override // com.vladsch.flexmark.util.ast.Node
    @NotNull
    public BasedSequence[] getSegments() {
        return Node.EMPTY_SEGMENTS;
    }

    public void setRowNumber(int i) {
        this.rowNumber = i;
    }

    public TableRow(BasedSequence basedSequence) {
        super(basedSequence);
    }
}
