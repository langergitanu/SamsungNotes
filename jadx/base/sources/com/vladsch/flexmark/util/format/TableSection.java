package com.vladsch.flexmark.util.format;

import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.somrecognize.common.Constant;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class TableSection {
    public final TableSectionType sectionType;
    public final ArrayList<TableRow> rows = new ArrayList<>();
    protected int row = 0;
    protected int column = 0;

    public TableSection(TableSectionType tableSectionType) {
        this.sectionType = tableSectionType;
    }

    private CharSequence dumpRows() {
        StringBuilder sb = new StringBuilder();
        for (TableRow tableRow : this.rows) {
            sb.append(Constant.WHITE_SPACE_FOR_LINK_ICON);
            sb.append(tableRow.toString());
            sb.append("\n");
        }
        return sb;
    }

    public TableCell defaultCell() {
        return TableCell.NULL;
    }

    public TableRow defaultRow() {
        return new TableRow();
    }

    public TableRow expandTo(int i) {
        return expandTo(i, (TableCell) null);
    }

    public TableRow get(int i) {
        return expandTo(i, (TableCell) null);
    }

    public int getColumn() {
        return this.column;
    }

    public int getMaxColumns() {
        Iterator<TableRow> it = this.rows.iterator();
        int i = 0;
        while (it.hasNext()) {
            int spannedColumns = it.next().getSpannedColumns();
            if (i < spannedColumns) {
                i = spannedColumns;
            }
        }
        return i;
    }

    public int getMinColumns() {
        Iterator<TableRow> it = this.rows.iterator();
        int i = 0;
        while (it.hasNext()) {
            int spannedColumns = it.next().getSpannedColumns();
            if (i > spannedColumns || i == 0) {
                i = spannedColumns;
            }
        }
        return i;
    }

    public int getRow() {
        return this.row;
    }

    public ArrayList<TableRow> getRows() {
        return this.rows;
    }

    public void nextRow() {
        this.row++;
        this.column = 0;
    }

    public void normalize() {
        Iterator<TableRow> it = this.rows.iterator();
        while (it.hasNext()) {
            it.next().normalize();
        }
    }

    public void setCell(int i, int i2, TableCell tableCell) {
        expandTo(i).set(i2, tableCell);
    }

    public String toString() {
        return getClass().getName().substring(getClass().getPackage().getName().length() + 1) + "[sectionType=" + this.sectionType + ", rows=[\n" + ((Object) dumpRows()) + "]";
    }

    public TableRow expandTo(int i, TableCell tableCell) {
        while (i >= this.rows.size()) {
            this.rows.add(defaultRow());
        }
        return this.rows.get(i);
    }

    public TableRow expandTo(int i, int i2) {
        return expandTo(i, i2, null);
    }

    public TableRow expandTo(int i, int i2, TableCell tableCell) {
        while (i >= this.rows.size()) {
            TableRow tableRowDefaultRow = defaultRow();
            tableRowDefaultRow.expandTo(i2, tableCell);
            this.rows.add(tableRowDefaultRow);
        }
        return this.rows.get(i).expandTo(i2);
    }
}
