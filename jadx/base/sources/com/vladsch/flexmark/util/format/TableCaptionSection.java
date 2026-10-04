package com.vladsch.flexmark.util.format;

import com.vladsch.flexmark.util.sequence.BasedSequence;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class TableCaptionSection extends TableSection {
    public static final TableCell DEFAULT_CELL;
    public static final TableCell NULL_CELL;

    static {
        BasedSequence basedSequence = BasedSequence.NULL;
        NULL_CELL = new TableCell(null, basedSequence, basedSequence, basedSequence, 1, 0);
        DEFAULT_CELL = new TableCell(null, "[", "", "]", 1, 1);
    }

    public TableCaptionSection(TableSectionType tableSectionType) {
        super(tableSectionType);
    }

    @Override // com.vladsch.flexmark.util.format.TableSection
    public TableCell defaultCell() {
        return DEFAULT_CELL;
    }

    @Override // com.vladsch.flexmark.util.format.TableSection
    public TableRow defaultRow() {
        return new TableCaptionRow();
    }
}
