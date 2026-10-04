package com.vladsch.flexmark.util.format;

import androidx.collection.AbstractC0622a;
import androidx.credentials.playservices.C2517b;
import com.vladsch.flexmark.util.collection.BoundedMaxAggregator;
import com.vladsch.flexmark.util.collection.BoundedMinAggregator;
import com.vladsch.flexmark.util.misc.Utils;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class TableCellOffsetInfo {
    private static final HashMap<TableSectionType, Integer> DEFAULT_STOP_POINTS_MAP;
    public static final int ROW_END = 8;
    public static final int ROW_START = 1;
    public static final int TEXT_END = 4;
    public static final int TEXT_START = 2;
    public final int column;
    public final Integer insideColumn;
    public final Integer insideOffset;
    public final int offset;
    public final int row;
    public final TableSection section;
    public final MarkdownTable table;
    public final TableCell tableCell;
    public final TableRow tableRow;

    static {
        HashMap<TableSectionType, Integer> map = new HashMap<>();
        DEFAULT_STOP_POINTS_MAP = map;
        map.put(TableSectionType.HEADER, 4);
        map.put(TableSectionType.SEPARATOR, 6);
        map.put(TableSectionType.BODY, 4);
        map.put(TableSectionType.CAPTION, 4);
    }

    public TableCellOffsetInfo(int i, MarkdownTable markdownTable, TableSection tableSection, TableRow tableRow, TableCell tableCell, int i2, int i4, Integer num, Integer num2) {
        this.offset = i;
        this.table = markdownTable;
        this.section = tableSection;
        this.tableRow = tableRow;
        this.tableCell = tableCell;
        this.row = i2;
        this.column = i4;
        this.insideColumn = num;
        this.insideOffset = num2;
    }

    private static int getStopOffset(int i, MarkdownTable markdownTable, Map<TableSectionType, Integer> map, boolean z) {
        Integer[] numArr = {null};
        if (map == null) {
            map = DEFAULT_STOP_POINTS_MAP;
        }
        markdownTable.forAllSectionRows(new C2517b(4, markdownTable, map, numArr, z ? new BoundedMinAggregator(i) : new BoundedMaxAggregator(i)));
        Integer num = numArr[0];
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    private static boolean haveRowEnd(int i) {
        return (i & 8) != 0;
    }

    private static boolean haveRowStart(int i) {
        return (i & 1) != 0;
    }

    private static boolean haveStopPoint(int i, int i2) {
        return (i & i2) != 0;
    }

    private static boolean haveTextEnd(int i) {
        return (i & 4) != 0;
    }

    private static boolean haveTextStart(int i) {
        return (i & 2) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$getStopOffset$0(MarkdownTable markdownTable, Map map, Integer[] numArr, BiFunction biFunction, TableRow tableRow, int i, ArrayList arrayList, int i2) {
        int iIntValue;
        TableSection allRowsSection = markdownTable.getAllRowsSection(i);
        if (!tableRow.cells.isEmpty() && map.containsKey(allRowsSection.sectionType) && (iIntValue = ((Integer) map.get(allRowsSection.sectionType)).intValue()) != 0) {
            TableCell tableCell = null;
            int startOffset = tableRow.cells.get(0).getStartOffset(null);
            int endOffset = ((TableCell) AbstractC0000a.m10g(tableRow.cells, 1)).getEndOffset();
            if (haveRowStart(iIntValue)) {
                numArr[0] = (Integer) biFunction.apply(numArr[0], Integer.valueOf(startOffset));
            }
            if (haveStopPoint(iIntValue, 6)) {
                for (TableCell tableCell2 : tableRow.cells) {
                    if (haveTextStart(iIntValue)) {
                        numArr[0] = (Integer) biFunction.apply(numArr[0], Integer.valueOf(tableCell2.getTextStartOffset(tableCell)));
                    }
                    if (haveTextEnd(iIntValue)) {
                        numArr[0] = (Integer) biFunction.apply(numArr[0], Integer.valueOf(tableCell2.getTextEndOffset(tableCell)));
                    }
                    tableCell = tableCell2;
                }
            }
            if (haveRowEnd(iIntValue)) {
                numArr[0] = (Integer) biFunction.apply(numArr[0], Integer.valueOf(endOffset));
            }
        }
        return 0;
    }

    public boolean canDeleteColumn() {
        return this.insideColumn != null && this.table.getMinColumnsWithoutColumns(true, this.column) > 0;
    }

    public boolean canDeleteRow() {
        if (this.tableRow == null) {
            return false;
        }
        TableSection tableSection = this.section;
        MarkdownTable markdownTable = this.table;
        if (tableSection != markdownTable.separator) {
            return this.table.header.rows.size() + markdownTable.body.rows.size() > 1;
        }
        return false;
    }

    public boolean getInsideColumn() {
        return this.insideColumn != null;
    }

    public TableCell getPreviousCell() {
        return getPreviousCell(1);
    }

    public boolean isAfterCaption() {
        return isCaptionLine() && isAfterCells();
    }

    public boolean isAfterCells() {
        TableRow tableRow = this.tableRow;
        return tableRow != null && this.tableCell != null && this.insideColumn == null && this.column == tableRow.cells.size() && this.offset >= this.tableCell.getEndOffset();
    }

    public boolean isBeforeCaption() {
        return isCaptionLine() && isBeforeCells();
    }

    public boolean isBeforeCells() {
        TableRow tableRow = this.tableRow;
        return tableRow != null && this.tableCell != null && this.insideColumn == null && this.column < tableRow.cells.size() && this.offset <= this.tableCell.getStartOffset(getPreviousCell());
    }

    public boolean isCaptionLine() {
        return (this.tableRow instanceof TableCaptionRow) && this.section == this.table.caption;
    }

    public boolean isFirstCell() {
        return getInsideColumn() && this.column == 0;
    }

    public boolean isInCellSpan() {
        TableCell tableCell;
        return this.tableRow != null && (tableCell = this.tableCell) != null && this.insideColumn == null && this.offset >= tableCell.getStartOffset(getPreviousCell()) && this.offset < this.tableCell.getEndOffset();
    }

    public boolean isInsideCaption() {
        return isCaptionLine() && getInsideColumn();
    }

    public boolean isInsideCell() {
        return (this.tableRow == null || this.tableCell == null || this.insideColumn == null) ? false : true;
    }

    public boolean isLastCell() {
        return getInsideColumn() && this.column + 1 == this.tableRow.cells.size();
    }

    public boolean isLastRow() {
        return this.row + 1 == this.table.getAllRowsCount();
    }

    public boolean isSeparatorLine() {
        return this.section.sectionType == TableSectionType.SEPARATOR;
    }

    public TableCellOffsetInfo nextCellOffset(Integer num) {
        if (!getInsideColumn() || this.column + 1 >= this.tableRow.cells.size()) {
            return null;
        }
        TableCell previousCell = getPreviousCell();
        TableCell previousCell2 = getPreviousCell(2);
        if (num == null) {
            TableCell tableCell = this.tableCell;
            Integer num2 = this.insideOffset;
            previousCell.textToInsideOffset(tableCell.insideToTextOffset(num2 == null ? 0 : num2.intValue(), previousCell2), previousCell2);
        }
        return this.table.getCellOffsetInfo(Utils.maxLimit(previousCell.getCellSize(previousCell2), Utils.minLimit(0, num.intValue())) + previousCell.getTextStartOffset(previousCell2));
    }

    public TableCellOffsetInfo nextOffsetStop(Map<TableSectionType, Integer> map) {
        int stopOffset = getStopOffset(this.offset, this.table, map, true);
        if (stopOffset != -1) {
            return this.table.getCellOffsetInfo(stopOffset);
        }
        TableCell tableCell = (TableCell) AbstractC0000a.m10g(((TableRow) AbstractC0000a.m10g(this.table.getAllSectionRows(), 1)).cells, 1);
        int endOffset = tableCell.getEndOffset();
        BasedSequence baseSequence = tableCell.text.getBaseSequence();
        int iEndOfLineAnyEOL = baseSequence.endOfLineAnyEOL(endOffset);
        MarkdownTable markdownTable = this.table;
        if (iEndOfLineAnyEOL != -1) {
            endOffset = baseSequence.eolStartLength(iEndOfLineAnyEOL) + iEndOfLineAnyEOL;
        }
        return markdownTable.getCellOffsetInfo(endOffset);
    }

    public TableCellOffsetInfo nextRowOffset(Integer num) {
        if (this.row + 1 >= this.table.getAllRowsCount()) {
            return null;
        }
        TableRow tableRow = this.table.getAllRows().get(this.row + 1);
        if (!getInsideColumn() || this.column >= tableRow.cells.size()) {
            return isBeforeCells() ? this.table.getCellOffsetInfo(tableRow.cells.get(0).getStartOffset(null)) : this.table.getCellOffsetInfo(((TableCell) AbstractC0000a.m10g(tableRow.cells, 1)).getEndOffset());
        }
        TableCell tableCell = tableRow.cells.get(this.column);
        TableCell previousCell = getPreviousCell(tableRow, 1);
        if (num == null) {
            TableCell tableCell2 = this.tableCell;
            Integer num2 = this.insideOffset;
            tableCell.textToInsideOffset(tableCell2.insideToTextOffset(num2 == null ? 0 : num2.intValue(), previousCell), previousCell);
        }
        return this.table.getCellOffsetInfo(Utils.maxLimit(tableCell.getCellSize(previousCell), Utils.minLimit(0, num.intValue())) + tableCell.getTextStartOffset(previousCell));
    }

    public TableCellOffsetInfo previousCellOffset(Integer num) {
        if (!getInsideColumn() || this.column <= 0) {
            return null;
        }
        TableCell previousCell = getPreviousCell();
        TableCell previousCell2 = getPreviousCell(2);
        if (num == null) {
            TableCell tableCell = this.tableCell;
            Integer num2 = this.insideOffset;
            previousCell.textToInsideOffset(tableCell.insideToTextOffset(num2 == null ? 0 : num2.intValue(), previousCell2), previousCell2);
        }
        return this.table.getCellOffsetInfo(Utils.maxLimit(previousCell.getCellSize(previousCell2), Utils.minLimit(0, num.intValue())) + previousCell.getTextStartOffset(previousCell2));
    }

    public TableCellOffsetInfo previousOffsetStop(Map<TableSectionType, Integer> map) {
        int stopOffset = getStopOffset(this.offset, this.table, map, false);
        if (stopOffset != -1) {
            return this.table.getCellOffsetInfo(stopOffset);
        }
        MarkdownTable markdownTable = this.table;
        return markdownTable.getCellOffsetInfo(markdownTable.getTableStartOffset());
    }

    public TableCellOffsetInfo previousRowOffset(Integer num) {
        if (this.row <= 0) {
            return null;
        }
        TableRow tableRow = this.table.getAllRows().get(this.row - 1);
        if (!getInsideColumn() || this.column >= tableRow.cells.size()) {
            return isBeforeCells() ? this.table.getCellOffsetInfo(tableRow.cells.get(0).getStartOffset(null)) : this.table.getCellOffsetInfo(((TableCell) AbstractC0000a.m10g(tableRow.cells, 1)).getEndOffset());
        }
        TableCell previousCell = getPreviousCell();
        TableCell previousCell2 = getPreviousCell(2);
        if (num == null) {
            TableCell tableCell = this.tableCell;
            Integer num2 = this.insideOffset;
            previousCell.textToInsideOffset(tableCell.insideToTextOffset(num2 == null ? 0 : num2.intValue(), previousCell2), previousCell2);
        }
        return this.table.getCellOffsetInfo(Utils.maxLimit(previousCell.getCellSize(previousCell2), Utils.minLimit(0, num.intValue())) + previousCell.getTextStartOffset(previousCell2));
    }

    public String toString() {
        int i = this.offset;
        int i2 = this.row;
        int i4 = this.column;
        Integer num = this.insideColumn;
        Integer num2 = this.insideOffset;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i2, "CellOffsetInfo{ offset=", ", row=", ", column=");
        sbM1173s.append(i4);
        sbM1173s.append(", insideColumn=");
        sbM1173s.append(num);
        sbM1173s.append(", insideOffset=");
        sbM1173s.append(num2);
        sbM1173s.append("}");
        return sbM1173s.toString();
    }

    public TableCell getPreviousCell(int i) {
        return getPreviousCell(this.tableRow, i);
    }

    public TableCell getPreviousCell(TableRow tableRow, int i) {
        int i2 = this.column;
        if (i2 < i || tableRow == null) {
            return null;
        }
        return tableRow.cells.get(i2 - i);
    }
}
