package com.vladsch.flexmark.util.format;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class TableSeparatorSection extends TableSection {
    public static final TableCell DEFAULT_CELL = new TableCell("---", 1, 1);

    public TableSeparatorSection(TableSectionType tableSectionType) {
        super(tableSectionType);
    }

    @Override // com.vladsch.flexmark.util.format.TableSection
    public TableCell defaultCell() {
        return DEFAULT_CELL;
    }

    @Override // com.vladsch.flexmark.util.format.TableSection
    public TableRow defaultRow() {
        return new TableSeparatorRow();
    }
}
