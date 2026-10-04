package com.vladsch.flexmark.util.format;

import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.html.CellAlignment;
import com.vladsch.flexmark.util.misc.Utils;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import com.vladsch.flexmark.util.sequence.PrefixedSubSequence;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class TableCell {
    public static final TableCell DEFAULT_CELL;
    public static final int NOT_TRACKED = Integer.MAX_VALUE;
    public static final TableCell NULL;
    public final boolean afterDelete;
    public final boolean afterSpace;
    public final CellAlignment alignment;
    public final BasedSequence closeMarker;
    public final int columnSpan;
    public final BasedSequence openMarker;
    public final int rowSpan;
    public final int spanTrackedOffset;
    public final Node tableCellNode;
    public final BasedSequence text;
    public final int trackedTextAdjust;
    public final int trackedTextOffset;

    static {
        BasedSequence basedSequence = BasedSequence.NULL;
        CellAlignment cellAlignment = CellAlignment.NONE;
        NULL = new TableCell(null, basedSequence, " ", basedSequence, 1, 0, cellAlignment);
        DEFAULT_CELL = new TableCell(null, basedSequence, " ", basedSequence, 1, 1, cellAlignment);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public TableCell(CharSequence charSequence, int i, int i2) {
        BasedSequence basedSequence = BasedSequence.NULL;
        this(null, basedSequence, charSequence, basedSequence, i, i2, CellAlignment.NONE);
    }

    private CharSequence dumpSequence(BasedSequence basedSequence) {
        StringBuilder sbM1324q = AbstractC1974b.m1324q("{ \"");
        sbM1324q.append((CharSequence) basedSequence.replace("\"", "\\\""));
        sbM1324q.append("\" [");
        sbM1324q.append(basedSequence.getStartOffset());
        sbM1324q.append(SQLKeyword.COMMA);
        sbM1324q.append(basedSequence.getEndOffset());
        sbM1324q.append("), length=");
        sbM1324q.append(basedSequence.length());
        sbM1324q.append("}");
        return sbM1324q;
    }

    public int getCellLength(TableCell tableCell) {
        return getEndOffset() - getStartOffset(tableCell);
    }

    public int getCellPrefixLength(TableCell tableCell) {
        return getInsideStartOffset(tableCell) - getStartOffset(tableCell);
    }

    public int getCellSize(TableCell tableCell) {
        return getEndOffset() - getStartOffset(tableCell);
    }

    public int getEndOffset() {
        return (!this.closeMarker.isEmpty() ? this.closeMarker : this.text).getEndOffset();
    }

    public int getInsideEndOffset() {
        return !this.closeMarker.isEmpty() ? this.closeMarker.getStartOffset() : this.text.getEndOffset();
    }

    public int getInsideStartOffset(TableCell tableCell) {
        return tableCell != null ? tableCell.getEndOffset() : !this.openMarker.isEmpty() ? this.openMarker.getEndOffset() : this.text.getStartOffset();
    }

    public BasedSequence getLastSegment() {
        return !this.closeMarker.isEmpty() ? this.closeMarker : this.text;
    }

    public int getStartOffset(TableCell tableCell) {
        if (tableCell != null) {
            return tableCell.getEndOffset();
        }
        return (!this.openMarker.isEmpty() ? this.openMarker : this.text).getStartOffset();
    }

    public int getTextEndOffset(TableCell tableCell) {
        return !this.text.isEmpty() ? this.text.getEndOffset() : !this.openMarker.isEmpty() ? this.openMarker.getEndOffset() + 1 : tableCell != null ? tableCell.getEndOffset() + 1 : this.closeMarker.getStartOffset() - 1;
    }

    public int getTextStartOffset(TableCell tableCell) {
        return !this.text.isEmpty() ? this.text.getStartOffset() : !this.openMarker.isEmpty() ? this.openMarker.getEndOffset() + 1 : tableCell != null ? tableCell.getEndOffset() + 1 : this.closeMarker.getStartOffset() - 1;
    }

    public int insideToTextOffset(int i, TableCell tableCell) {
        return Utils.maxLimit(this.text.length(), Utils.minLimit(getTextStartOffset(tableCell) + (i - getInsideStartOffset(tableCell)), 0));
    }

    public boolean isAtCell(int i, TableCell tableCell) {
        return i >= getInsideStartOffset(tableCell) && i <= getInsideEndOffset();
    }

    public boolean isInsideCell(int i, TableCell tableCell) {
        return i >= getInsideStartOffset(tableCell) && i <= getInsideEndOffset();
    }

    public int textToInsideOffset(int i, TableCell tableCell) {
        return Utils.maxLimit(getCellSize(tableCell), Utils.minLimit(getInsideStartOffset(tableCell) + (i - getTextStartOffset(tableCell)), 0));
    }

    public String toString() {
        String strSubstring = getClass().getName().substring(getClass().getPackage().getName().length() + 1);
        CharSequence charSequenceDumpSequence = dumpSequence(this.openMarker);
        CharSequence charSequenceDumpSequence2 = dumpSequence(this.text);
        CharSequence charSequenceDumpSequence3 = dumpSequence(this.closeMarker);
        int i = this.columnSpan;
        int i2 = this.rowSpan;
        CellAlignment cellAlignment = this.alignment;
        int i4 = this.trackedTextOffset;
        int i5 = this.spanTrackedOffset;
        int i6 = this.trackedTextAdjust;
        boolean z = this.afterSpace;
        boolean z2 = this.afterDelete;
        StringBuilder sb = new StringBuilder();
        sb.append(strSubstring);
        sb.append("{openMarker=");
        sb.append((Object) charSequenceDumpSequence);
        sb.append(", text=");
        sb.append((Object) charSequenceDumpSequence2);
        sb.append(", closeMarker=");
        sb.append((Object) charSequenceDumpSequence3);
        sb.append(", columnSpan=");
        sb.append(i);
        sb.append(", rowSpan=");
        sb.append(i2);
        sb.append(", alignment=");
        sb.append(cellAlignment);
        AbstractC0622a.m1180z(sb, i4, i5, ", trackedTextOffset=", ", spanTrackedOffset=");
        sb.append(", trackedTextAdjust=");
        sb.append(i6);
        sb.append(", afterSpace=");
        sb.append(z);
        sb.append(", afterDelete=");
        sb.append(z2);
        sb.append("}");
        return sb.toString();
    }

    public TableCell withAfterSpace(boolean z) {
        return new TableCell(this.tableCellNode, this.openMarker, this.text, this.closeMarker, this.rowSpan, this.columnSpan, this.alignment, this.trackedTextOffset, this.spanTrackedOffset, this.trackedTextAdjust, z, this.afterDelete);
    }

    public TableCell withAlignment(CellAlignment cellAlignment) {
        return new TableCell(this.tableCellNode, this.openMarker, this.text, this.closeMarker, this.rowSpan, this.columnSpan, cellAlignment, this.trackedTextOffset, this.spanTrackedOffset, this.trackedTextAdjust, this.afterSpace, this.afterDelete);
    }

    public TableCell withColumnSpan(int i) {
        Node node = this.tableCellNode;
        BasedSequence basedSequence = this.openMarker;
        BasedSequence basedSequence2 = this.text;
        BasedSequence basedSequence3 = this.closeMarker;
        int i2 = this.rowSpan;
        CellAlignment cellAlignment = this.alignment;
        int i4 = this.trackedTextOffset;
        int i5 = this.spanTrackedOffset;
        return new TableCell(node, basedSequence, basedSequence2, basedSequence3, i2, i, cellAlignment, i4, i5 != Integer.MAX_VALUE ? Utils.min(i5, i) : Integer.MAX_VALUE, this.trackedTextAdjust, this.afterSpace, this.afterDelete);
    }

    public TableCell withRowSpan(int i) {
        return new TableCell(this.tableCellNode, this.openMarker, this.text, this.closeMarker, i, this.columnSpan, this.alignment, this.trackedTextOffset, this.spanTrackedOffset, this.trackedTextAdjust, this.afterSpace, this.afterDelete);
    }

    public TableCell withSpanTrackedOffset(int i) {
        return new TableCell(this.tableCellNode, this.openMarker, this.text, this.closeMarker, this.rowSpan, this.columnSpan, this.alignment, this.trackedTextOffset, i, this.trackedTextAdjust, this.afterSpace, this.afterDelete);
    }

    public TableCell withText(CharSequence charSequence) {
        return new TableCell(this.tableCellNode, this.openMarker, charSequence, this.closeMarker, this.rowSpan, this.columnSpan, this.alignment, Integer.MAX_VALUE, this.spanTrackedOffset, this.trackedTextAdjust, this.afterSpace, this.afterDelete);
    }

    public TableCell withTrackedOffset(int i) {
        return new TableCell(this.tableCellNode, this.openMarker, this.text, this.closeMarker, this.rowSpan, this.columnSpan, this.alignment, i, this.spanTrackedOffset, this.trackedTextAdjust, this.afterSpace, this.afterDelete);
    }

    public TableCell withTrackedTextAdjust(int i) {
        return new TableCell(this.tableCellNode, this.openMarker, this.text, this.closeMarker, this.rowSpan, this.columnSpan, this.alignment, this.trackedTextOffset, this.spanTrackedOffset, i, this.afterSpace, this.afterDelete);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public TableCell(Node node, CharSequence charSequence, int i, int i2, CellAlignment cellAlignment) {
        BasedSequence basedSequence = BasedSequence.NULL;
        this(node, basedSequence, charSequence, basedSequence, i, i2, cellAlignment);
    }

    public TableCell withText(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        return new TableCell(this.tableCellNode, charSequence, charSequence2, charSequence3, this.rowSpan, this.columnSpan, this.alignment, Integer.MAX_VALUE, this.spanTrackedOffset, this.trackedTextAdjust, this.afterSpace, this.afterDelete);
    }

    public TableCell withTrackedOffset(int i, boolean z, boolean z2) {
        return new TableCell(this.tableCellNode, this.openMarker, this.text, this.closeMarker, this.rowSpan, this.columnSpan, this.alignment, i, this.spanTrackedOffset, this.trackedTextAdjust, z, z2);
    }

    public TableCell(Node node, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, int i2) {
        this(node, charSequence, charSequence2, charSequence3, i, i2, CellAlignment.NONE);
    }

    public TableCell(Node node, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, int i2, CellAlignment cellAlignment) {
        this(node, charSequence, charSequence2, charSequence3, i, i2, cellAlignment, Integer.MAX_VALUE, Integer.MAX_VALUE, 0, false, false);
    }

    public TableCell(Node node, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, int i2, CellAlignment cellAlignment, int i4, int i5, int i6, boolean z, boolean z2) {
        BasedSequence basedSequenceM13437of = BasedSequence.m13437of(charSequence2);
        this.tableCellNode = node;
        BasedSequence basedSequenceM13437of2 = BasedSequence.m13437of(charSequence);
        this.openMarker = basedSequenceM13437of2;
        BasedSequence basedSequenceM13437of3 = BasedSequence.m13437of(charSequence3);
        this.closeMarker = basedSequenceM13437of3;
        BasedSequence basedSequenceSubSequence = basedSequenceM13437of2.isEmpty() ? basedSequenceM13437of3.subSequence(0, 0) : basedSequenceM13437of2.subSequence(basedSequenceM13437of2.length());
        if (basedSequenceM13437of.isEmpty() && basedSequenceM13437of != BasedSequence.NULL) {
            basedSequenceM13437of = PrefixedSubSequence.prefixOf(" ", basedSequenceSubSequence);
        }
        this.text = basedSequenceM13437of;
        this.rowSpan = i;
        this.columnSpan = i2;
        this.alignment = cellAlignment == null ? CellAlignment.NONE : cellAlignment;
        this.trackedTextOffset = i4;
        this.spanTrackedOffset = i5;
        this.trackedTextAdjust = i6;
        this.afterSpace = z;
        this.afterDelete = z2;
    }

    public TableCell(@NotNull TableCell tableCell, boolean z, int i, int i2, CellAlignment cellAlignment) {
        this.tableCellNode = z ? tableCell.tableCellNode : null;
        BasedSequence basedSequence = tableCell.openMarker;
        this.openMarker = basedSequence;
        BasedSequence basedSequence2 = tableCell.closeMarker;
        this.closeMarker = basedSequence2;
        BasedSequence basedSequenceSubSequence = basedSequence.isEmpty() ? basedSequence2.subSequence(0, 0) : basedSequence.subSequence(basedSequence.length());
        BasedSequence basedSequence3 = tableCell.text;
        this.text = basedSequence3 == BasedSequence.NULL ? PrefixedSubSequence.prefixOf(" ", basedSequenceSubSequence) : basedSequence3;
        this.rowSpan = i;
        this.columnSpan = i2;
        this.alignment = cellAlignment == null ? CellAlignment.NONE : cellAlignment;
        this.trackedTextOffset = tableCell.trackedTextOffset;
        this.spanTrackedOffset = tableCell.spanTrackedOffset;
        this.trackedTextAdjust = tableCell.trackedTextAdjust;
        this.afterSpace = tableCell.afterSpace;
        this.afterDelete = tableCell.afterDelete;
    }
}
