package com.vladsch.flexmark.ext.tables;

import com.vladsch.flexmark.ext.tables.internal.TableJiraRenderer;
import com.vladsch.flexmark.ext.tables.internal.TableNodeFormatter;
import com.vladsch.flexmark.ext.tables.internal.TableNodeRenderer;
import com.vladsch.flexmark.ext.tables.internal.TableParagraphPreProcessor;
import com.vladsch.flexmark.formatter.Formatter;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.data.DataKey;
import com.vladsch.flexmark.util.data.MutableDataHolder;
import com.vladsch.flexmark.util.data.NullableDataKey;
import com.vladsch.flexmark.util.format.CharWidthProvider;
import com.vladsch.flexmark.util.format.TableFormatOptions;
import com.vladsch.flexmark.util.format.TableManipulator;
import com.vladsch.flexmark.util.format.options.DiscretionaryText;
import com.vladsch.flexmark.util.format.options.TableCaptionHandling;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class TablesExtension implements Parser.ParserExtension, HtmlRenderer.HtmlRendererExtension, Formatter.FormatterExtension {
    public static final DataKey<Boolean> APPEND_MISSING_COLUMNS;
    public static final DataKey<String> CLASS_NAME;
    public static final DataKey<Boolean> COLUMN_SPANS;
    public static final DataKey<Boolean> DISCARD_EXTRA_COLUMNS;
    public static final DataKey<CharWidthProvider> FORMAT_CHAR_WIDTH_PROVIDER;
    public static final DataKey<Boolean> FORMAT_TABLE_ADJUST_COLUMN_WIDTH;
    public static final DataKey<Boolean> FORMAT_TABLE_APPLY_COLUMN_ALIGNMENT;
    public static final DataKey<TableCaptionHandling> FORMAT_TABLE_CAPTION;
    public static final DataKey<DiscretionaryText> FORMAT_TABLE_CAPTION_SPACES;
    public static final DataKey<Boolean> FORMAT_TABLE_FILL_MISSING_COLUMNS;
    public static final NullableDataKey<Integer> FORMAT_TABLE_FILL_MISSING_MIN_COLUMN;
    public static final DataKey<String> FORMAT_TABLE_INDENT_PREFIX;
    public static final DataKey<Boolean> FORMAT_TABLE_LEAD_TRAIL_PIPES;
    public static final DataKey<DiscretionaryText> FORMAT_TABLE_LEFT_ALIGN_MARKER;
    public static final DataKey<TableManipulator> FORMAT_TABLE_MANIPULATOR;
    public static final DataKey<Integer> FORMAT_TABLE_MIN_SEPARATOR_COLUMN_WIDTH;
    public static final DataKey<Integer> FORMAT_TABLE_MIN_SEPARATOR_DASHES;
    public static final DataKey<Boolean> FORMAT_TABLE_SPACE_AROUND_PIPES;
    public static final DataKey<Boolean> FORMAT_TABLE_TRIM_CELL_WHITESPACE;
    public static final DataKey<Boolean> HEADER_SEPARATOR_COLUMN_MATCH;
    public static final DataKey<Integer> MAX_HEADER_ROWS;
    public static final DataKey<Integer> MIN_HEADER_ROWS;
    public static final DataKey<Integer> MIN_SEPARATOR_DASHES;
    public static final DataKey<Boolean> TRIM_CELL_WHITESPACE;
    public static final DataKey<Boolean> WITH_CAPTION;

    static {
        Boolean bool = Boolean.TRUE;
        TRIM_CELL_WHITESPACE = new DataKey<>("TRIM_CELL_WHITESPACE", bool);
        MIN_SEPARATOR_DASHES = new DataKey<>("MIN_SEPARATOR_DASHES", 3);
        MAX_HEADER_ROWS = new DataKey<>("MAX_HEADER_ROWS", Integer.MAX_VALUE);
        MIN_HEADER_ROWS = new DataKey<>("MIN_HEADER_ROWS", 0);
        Boolean bool2 = Boolean.FALSE;
        APPEND_MISSING_COLUMNS = new DataKey<>("APPEND_MISSING_COLUMNS", bool2);
        DISCARD_EXTRA_COLUMNS = new DataKey<>("DISCARD_EXTRA_COLUMNS", bool2);
        COLUMN_SPANS = new DataKey<>("COLUMN_SPANS", bool);
        HEADER_SEPARATOR_COLUMN_MATCH = new DataKey<>("HEADER_SEPARATOR_COLUMN_MATCH", bool2);
        CLASS_NAME = new DataKey<>("CLASS_NAME", "");
        WITH_CAPTION = new DataKey<>("WITH_CAPTION", bool);
        FORMAT_TABLE_TRIM_CELL_WHITESPACE = TableFormatOptions.FORMAT_TABLE_TRIM_CELL_WHITESPACE;
        FORMAT_TABLE_LEAD_TRAIL_PIPES = TableFormatOptions.FORMAT_TABLE_LEAD_TRAIL_PIPES;
        FORMAT_TABLE_SPACE_AROUND_PIPES = TableFormatOptions.FORMAT_TABLE_SPACE_AROUND_PIPES;
        FORMAT_TABLE_ADJUST_COLUMN_WIDTH = TableFormatOptions.FORMAT_TABLE_ADJUST_COLUMN_WIDTH;
        FORMAT_TABLE_APPLY_COLUMN_ALIGNMENT = TableFormatOptions.FORMAT_TABLE_APPLY_COLUMN_ALIGNMENT;
        FORMAT_TABLE_FILL_MISSING_COLUMNS = TableFormatOptions.FORMAT_TABLE_FILL_MISSING_COLUMNS;
        FORMAT_TABLE_FILL_MISSING_MIN_COLUMN = TableFormatOptions.FORMAT_TABLE_FILL_MISSING_MIN_COLUMN;
        FORMAT_TABLE_LEFT_ALIGN_MARKER = TableFormatOptions.FORMAT_TABLE_LEFT_ALIGN_MARKER;
        FORMAT_TABLE_MIN_SEPARATOR_COLUMN_WIDTH = TableFormatOptions.FORMAT_TABLE_MIN_SEPARATOR_COLUMN_WIDTH;
        FORMAT_TABLE_MIN_SEPARATOR_DASHES = TableFormatOptions.FORMAT_TABLE_MIN_SEPARATOR_DASHES;
        FORMAT_CHAR_WIDTH_PROVIDER = TableFormatOptions.FORMAT_CHAR_WIDTH_PROVIDER;
        FORMAT_TABLE_MANIPULATOR = TableFormatOptions.FORMAT_TABLE_MANIPULATOR;
        FORMAT_TABLE_CAPTION = TableFormatOptions.FORMAT_TABLE_CAPTION;
        FORMAT_TABLE_CAPTION_SPACES = TableFormatOptions.FORMAT_TABLE_CAPTION_SPACES;
        FORMAT_TABLE_INDENT_PREFIX = TableFormatOptions.FORMAT_TABLE_INDENT_PREFIX;
    }

    public static TablesExtension create() {
        return new TablesExtension();
    }

    @Override // com.vladsch.flexmark.formatter.Formatter.FormatterExtension
    public void extend(Formatter.Builder builder) {
        builder.nodeFormatterFactory(new TableNodeFormatter.Factory());
    }

    @Override // com.vladsch.flexmark.parser.Parser.ParserExtension
    public void parserOptions(MutableDataHolder mutableDataHolder) {
    }

    @Override // com.vladsch.flexmark.html.HtmlRenderer.HtmlRendererExtension
    public void rendererOptions(@NotNull MutableDataHolder mutableDataHolder) {
    }

    @Override // com.vladsch.flexmark.parser.Parser.ParserExtension
    public void extend(Parser.Builder builder) {
        builder.paragraphPreProcessorFactory(TableParagraphPreProcessor.Factory());
    }

    @Override // com.vladsch.flexmark.html.HtmlRenderer.HtmlRendererExtension
    public void extend(@NotNull HtmlRenderer.Builder builder, @NotNull String str) {
        if (builder.isRendererType("HTML")) {
            builder.nodeRendererFactory(new TableNodeRenderer.Factory());
        } else if (builder.isRendererType("JIRA")) {
            builder.nodeRendererFactory(new TableJiraRenderer.Factory());
        }
    }
}
