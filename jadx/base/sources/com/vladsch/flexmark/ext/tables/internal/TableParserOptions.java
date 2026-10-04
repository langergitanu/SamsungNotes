package com.vladsch.flexmark.ext.tables.internal;

import com.vladsch.flexmark.ext.tables.TablesExtension;
import com.vladsch.flexmark.util.data.DataHolder;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
class TableParserOptions {
    public final boolean appendMissingColumns;
    public final String className;
    public final boolean columnSpans;
    public final boolean discardExtraColumns;
    public final boolean headerSeparatorColumnMatch;
    public final int maxHeaderRows;
    public final int minHeaderRows;
    public final int minSeparatorDashes;
    public final boolean trimCellWhitespace;
    public final boolean withCaption;

    public TableParserOptions(DataHolder dataHolder) {
        this.maxHeaderRows = TablesExtension.MAX_HEADER_ROWS.get(dataHolder).intValue();
        this.minHeaderRows = TablesExtension.MIN_HEADER_ROWS.get(dataHolder).intValue();
        this.minSeparatorDashes = TablesExtension.MIN_SEPARATOR_DASHES.get(dataHolder).intValue();
        this.appendMissingColumns = TablesExtension.APPEND_MISSING_COLUMNS.get(dataHolder).booleanValue();
        this.discardExtraColumns = TablesExtension.DISCARD_EXTRA_COLUMNS.get(dataHolder).booleanValue();
        this.columnSpans = TablesExtension.COLUMN_SPANS.get(dataHolder).booleanValue();
        this.trimCellWhitespace = TablesExtension.TRIM_CELL_WHITESPACE.get(dataHolder).booleanValue();
        this.headerSeparatorColumnMatch = TablesExtension.HEADER_SEPARATOR_COLUMN_MATCH.get(dataHolder).booleanValue();
        this.className = TablesExtension.CLASS_NAME.get(dataHolder);
        this.withCaption = TablesExtension.WITH_CAPTION.get(dataHolder).booleanValue();
    }
}
