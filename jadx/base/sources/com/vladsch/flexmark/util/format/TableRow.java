package com.vladsch.flexmark.util.format;

import com.vladsch.flexmark.util.format.MarkdownTable;
import com.vladsch.flexmark.util.misc.Utils;
import com.vladsch.flexmark.util.sequence.PrefixedSubSequence;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class TableRow {
    protected int beforeOffset = Integer.MAX_VALUE;
    protected int afterOffset = Integer.MAX_VALUE;
    private boolean normalized = true;
    protected final List<TableCell> cells = new ArrayList();

    private CharSequence dumpCells() {
        StringBuilder sb = new StringBuilder();
        for (TableCell tableCell : this.cells) {
            sb.append("    ");
            sb.append(tableCell.toString());
            sb.append("\n");
        }
        return sb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$forAllCells$0(TableCellConsumer tableCellConsumer, TableCell tableCell, int i, int i2, int i4) {
        tableCellConsumer.accept(tableCell, i, i2);
        return 0;
    }

    public void addColumn(int i) {
        this.cells.add(i, defaultCell());
    }

    public void appendColumns(int i) {
        appendColumns(i, null);
    }

    public int columnOf(int i) {
        return columnOfOrNull(Integer.valueOf(i)).intValue();
    }

    public Integer columnOfOrNull(Integer num) {
        if (num == null) {
            return null;
        }
        int iMaxLimit = Utils.maxLimit(num.intValue(), this.cells.size());
        int i = 0;
        for (int i2 = 0; i2 < iMaxLimit; i2++) {
            i += this.cells.get(i2).columnSpan;
        }
        return Integer.valueOf(i);
    }

    public TableCell defaultCell() {
        return new TableCell(" ", 1, 1);
    }

    public void deleteColumns(int i, int i2) {
        if (i2 <= 0 || i < 0) {
            return;
        }
        normalizeIfNeeded();
        MarkdownTable.IndexSpanOffset indexSpanOffsetIndexOf = indexOf(i);
        int i4 = indexSpanOffsetIndexOf.index;
        int i5 = indexSpanOffsetIndexOf.spanOffset;
        while (i4 < this.cells.size() && i2 > 0) {
            TableCell tableCell = this.cells.get(i4);
            this.cells.remove(i4);
            if (i5 > 0) {
                int i6 = tableCell.columnSpan;
                if (i6 - i5 > i2) {
                    this.cells.add(i4, tableCell.withColumnSpan(i6 - i2));
                    return;
                } else {
                    this.cells.add(i4, tableCell.withColumnSpan(i5));
                    i4++;
                }
            } else if (tableCell.columnSpan - i5 > i2) {
                this.cells.add(i4, defaultCell().withColumnSpan(tableCell.columnSpan - i2));
                return;
            }
            i2 -= tableCell.columnSpan - i5;
            i5 = 0;
        }
    }

    public TableRow expandTo(int i) {
        return expandTo(i, TableCell.NULL);
    }

    public void fillMissingColumns(Integer num, int i) {
        int spannedColumns = getSpannedColumns();
        if (spannedColumns >= i) {
            return;
        }
        int size = num == null ? this.cells.size() : num.intValue();
        int i2 = i - spannedColumns;
        if (num == null || num.intValue() >= spannedColumns) {
            size = this.cells.size();
        }
        TableCell tableCellDefaultCell = defaultCell();
        TableCell tableCellWithText = size > 0 ? this.cells.get(size - 1) : tableCellDefaultCell;
        while (true) {
            int i4 = i2 - 1;
            if (i2 <= 0) {
                return;
            }
            int endOffset = tableCellWithText.getEndOffset();
            tableCellWithText = tableCellDefaultCell.withText(PrefixedSubSequence.prefixOf(" ", tableCellWithText.getLastSegment().getBaseSequence(), endOffset, endOffset));
            List<TableCell> list = this.cells;
            list.add(Math.min(size, list.size()), tableCellWithText);
            size++;
            tableCellDefaultCell = tableCellWithText;
            i2 = i4;
        }
    }

    public void forAllCells(TableCellConsumer tableCellConsumer) {
        forAllCells(0, Integer.MAX_VALUE, tableCellConsumer);
    }

    public int getAfterOffset() {
        return this.afterOffset;
    }

    public int getBeforeOffset() {
        return this.beforeOffset;
    }

    public List<TableCell> getCells() {
        return this.cells;
    }

    public int getColumns() {
        return this.cells.size();
    }

    public int getSpannedColumns() {
        int i = 0;
        for (TableCell tableCell : this.cells) {
            if (tableCell != null) {
                i += tableCell.columnSpan;
            }
        }
        return i;
    }

    public int getTotalColumns() {
        return getSpannedColumns();
    }

    public MarkdownTable.IndexSpanOffset indexOf(int i) {
        return indexOfOrNull(Integer.valueOf(i));
    }

    public MarkdownTable.IndexSpanOffset indexOfOrNull(Integer num) {
        if (num == null) {
            return null;
        }
        int iIntValue = num.intValue();
        Iterator<TableCell> it = this.cells.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2 = it.next().columnSpan;
            if (i2 > iIntValue) {
                return new MarkdownTable.IndexSpanOffset(i, iIntValue);
            }
            iIntValue -= i2;
            if (i2 > 0) {
                i++;
            }
        }
        return new MarkdownTable.IndexSpanOffset(i, 0);
    }

    public void insertColumns(int i, int i2) {
        insertColumns(i, i2, null);
    }

    public boolean isEmpty() {
        for (TableCell tableCell : this.cells) {
            if (tableCell != null && !tableCell.text.isBlank()) {
                return false;
            }
        }
        return true;
    }

    public boolean isEmptyColumn(int i) {
        int i2 = indexOf(i).index;
        return i2 >= this.cells.size() || this.cells.get(i2).text.isBlank();
    }

    public void moveColumn(int i, int i2) {
        if (i < 0 || i2 < 0) {
            return;
        }
        normalizeIfNeeded();
        int totalColumns = getTotalColumns();
        if (i >= totalColumns) {
            return;
        }
        if (i2 >= totalColumns) {
            i2 = totalColumns - 1;
        }
        if (i == i2 || i2 >= totalColumns) {
            return;
        }
        MarkdownTable.IndexSpanOffset indexSpanOffsetIndexOf = indexOf(i);
        int i4 = indexSpanOffsetIndexOf.index;
        int i5 = indexSpanOffsetIndexOf.spanOffset;
        TableCell tableCellWithColumnSpan = this.cells.get(i4).withColumnSpan(1);
        if (indexOf(i2).index != i4) {
            if (i5 > 0) {
                insertColumns((i <= i2 ? 1 : 0) + i2, 1, defaultCell());
            } else {
                insertColumns((i <= i2 ? 1 : 0) + i2, 1, tableCellWithColumnSpan.withColumnSpan(1));
            }
            deleteColumns(i + (i2 <= i ? 1 : 0), 1);
        }
    }

    public void normalize() {
        int i = 0;
        while (i < this.cells.size()) {
            TableCell tableCell = this.cells.get(i);
            if (tableCell == null || tableCell == TableCell.NULL) {
                this.cells.remove(i);
            } else {
                i++;
            }
        }
        this.normalized = true;
    }

    public void normalizeIfNeeded() {
        if (this.normalized) {
            return;
        }
        normalize();
    }

    public void set(int i, TableCell tableCell) {
        expandTo(i, null);
        this.cells.set(i, tableCell);
    }

    public void setAfterOffset(int i) {
        this.afterOffset = i;
    }

    public void setBeforeOffset(int i) {
        this.beforeOffset = i;
    }

    public String toString() {
        return getClass().getName().substring(getClass().getPackage().getName().length() + 1) + "{ beforeOffset=" + this.beforeOffset + ", afterOffset=" + this.afterOffset + ", normalized=" + this.normalized + ", cells=[\n" + ((Object) dumpCells()) + "    ]\n  }";
    }

    public void appendColumns(int i, TableCell tableCell) {
        if (tableCell == null || tableCell.columnSpan == 0) {
            tableCell = defaultCell();
        }
        for (int i2 = 0; i2 < i; i2++) {
            List<TableCell> list = this.cells;
            list.add(list.size(), tableCell);
        }
    }

    public TableRow expandTo(int i, TableCell tableCell) {
        if (tableCell == null || tableCell.columnSpan == 0) {
            this.normalized = false;
        }
        while (i >= this.cells.size()) {
            this.cells.add(tableCell);
        }
        return this;
    }

    public void forAllCells(int i, TableCellConsumer tableCellConsumer) {
        forAllCells(i, Integer.MAX_VALUE, tableCellConsumer);
    }

    public void insertColumns(int i, int i2, TableCell tableCell) {
        if (i2 <= 0 || i < 0) {
            return;
        }
        normalizeIfNeeded();
        if (tableCell == null || tableCell.columnSpan == 0) {
            tableCell = defaultCell();
        }
        if (i >= getTotalColumns()) {
            appendColumns(i2, tableCell);
            return;
        }
        MarkdownTable.IndexSpanOffset indexSpanOffsetIndexOf = indexOf(i);
        int i4 = indexSpanOffsetIndexOf.index;
        int i5 = indexSpanOffsetIndexOf.spanOffset;
        if (i5 <= 0 || i4 >= this.cells.size()) {
            for (int i6 = 0; i6 < i2; i6++) {
                this.cells.add(i4, tableCell);
            }
            return;
        }
        TableCell tableCell2 = this.cells.get(i4);
        if (tableCell.text.isBlank() || i2 > 1) {
            this.cells.remove(i4);
            this.cells.add(i4, tableCell2.withColumnSpan(tableCell2.columnSpan + i2));
        } else {
            this.cells.remove(i4);
            this.cells.add(i4, tableCell2.withColumnSpan(i5));
            this.cells.add(i4 + 1, tableCell.withColumnSpan(Utils.minLimit(1, (tableCell2.columnSpan - i5) + 1)));
        }
    }

    public void forAllCells(int i, int i2, TableCellConsumer tableCellConsumer) {
        forAllCells(i, i2, new C11861g(tableCellConsumer, 3));
    }

    public void forAllCells(TableCellManipulator tableCellManipulator) {
        forAllCells(0, Integer.MAX_VALUE, tableCellManipulator);
    }

    public void forAllCells(int i, TableCellManipulator tableCellManipulator) {
        forAllCells(i, Integer.MAX_VALUE, tableCellManipulator);
    }

    public void forAllCells(int i, int i2, TableCellManipulator tableCellManipulator) {
        int size = this.cells.size();
        if (i >= size || i2 <= 0) {
            return;
        }
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i4 < size) {
            TableCell tableCell = this.cells.get(i4);
            if (i4 >= i) {
                int iApply = tableCellManipulator.apply(tableCell, i4, i6, i5);
                if (iApply == Integer.MIN_VALUE) {
                    return;
                }
                if (iApply < 0) {
                    i5 -= iApply;
                    i2 += iApply;
                } else {
                    i4 += iApply + 1;
                    i6 += tableCell.columnSpan;
                    i2--;
                }
                size += iApply;
                i5++;
                if (i2 <= 0) {
                    return;
                }
            } else {
                i4++;
                i5++;
                i6 += tableCell.columnSpan;
            }
        }
    }
}
