package com.vladsch.flexmark.ext.tables.internal;

import androidx.collection.AbstractC0622a;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.somrecognize.common.Constant;
import com.sec.android.diagmonagent.dma.aperf.utils.aPerfUtil;
import com.vladsch.flexmark.ast.Paragraph;
import com.vladsch.flexmark.ast.Text;
import com.vladsch.flexmark.ext.tables.TableBlock;
import com.vladsch.flexmark.ext.tables.TableBody;
import com.vladsch.flexmark.ext.tables.TableCaption;
import com.vladsch.flexmark.ext.tables.TableCell;
import com.vladsch.flexmark.ext.tables.TableHead;
import com.vladsch.flexmark.ext.tables.TableRow;
import com.vladsch.flexmark.ext.tables.TableSeparator;
import com.vladsch.flexmark.ext.tables.TablesExtension;
import com.vladsch.flexmark.formatter.MarkdownWriter;
import com.vladsch.flexmark.formatter.NodeFormatter;
import com.vladsch.flexmark.formatter.NodeFormatterContext;
import com.vladsch.flexmark.formatter.NodeFormatterFactory;
import com.vladsch.flexmark.formatter.NodeFormattingHandler;
import com.vladsch.flexmark.formatter.RenderPurpose;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.DataHolder;
import com.vladsch.flexmark.util.format.MarkdownTable;
import com.vladsch.flexmark.util.format.TableFormatOptions;
import com.vladsch.flexmark.util.format.TableManipulator;
import com.vladsch.flexmark.util.format.TrackedOffset;
import com.vladsch.flexmark.util.format.TrackedOffsetList;
import com.vladsch.flexmark.util.html.CellAlignment;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import com.vladsch.flexmark.util.sequence.LineAppendable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p079T.C0287e;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class TableNodeFormatter implements NodeFormatter {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private MarkdownTable myTable;
    private final TableFormatOptions options;
    private final boolean parserTrimCellWhiteSpace;

    /* JADX INFO: renamed from: com.vladsch.flexmark.ext.tables.internal.TableNodeFormatter$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C117961 {
        static final /* synthetic */ int[] $SwitchMap$com$vladsch$flexmark$formatter$RenderPurpose;

        static {
            int[] iArr = new int[RenderPurpose.values().length];
            $SwitchMap$com$vladsch$flexmark$formatter$RenderPurpose = iArr;
            try {
                iArr[RenderPurpose.TRANSLATION_SPANS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$vladsch$flexmark$formatter$RenderPurpose[RenderPurpose.TRANSLATED_SPANS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$vladsch$flexmark$formatter$RenderPurpose[RenderPurpose.TRANSLATED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$vladsch$flexmark$formatter$RenderPurpose[RenderPurpose.FORMAT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Factory implements NodeFormatterFactory {
        @Override // com.vladsch.flexmark.formatter.NodeFormatterFactory
        @NotNull
        public NodeFormatter create(@NotNull DataHolder dataHolder) {
            return new TableNodeFormatter(dataHolder);
        }
    }

    public TableNodeFormatter(DataHolder dataHolder) {
        this.options = new TableFormatOptions(dataHolder);
        this.parserTrimCellWhiteSpace = TablesExtension.TRIM_CELL_WHITESPACE.get(dataHolder).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$render$0(TableCell tableCell, String[] strArr, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
        nodeFormatterContext.renderChildren(tableCell);
        strArr[0] = markdownWriter.toString(-1, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(TableBlock tableBlock, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
        this.myTable = new MarkdownTable(tableBlock.getChars(), this.options);
        int i = C117961.$SwitchMap$com$vladsch$flexmark$formatter$RenderPurpose[nodeFormatterContext.getRenderPurpose().ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            markdownWriter.blankLine();
            nodeFormatterContext.renderChildren(tableBlock);
            markdownWriter.tailBlankLine();
        } else {
            nodeFormatterContext.renderChildren(tableBlock);
            TrackedOffsetList trackedOffsets = nodeFormatterContext.getTrackedOffsets();
            TrackedOffsetList trackedOffsets2 = trackedOffsets.getTrackedOffsets(tableBlock.getStartOffset(), tableBlock.getEndOffset());
            if (!trackedOffsets.isEmpty()) {
                Iterator<TrackedOffset> it = trackedOffsets2.iterator();
                while (it.hasNext()) {
                    this.myTable.addTrackedOffset(it.next());
                }
            }
            if (this.options.tableManipulator != TableManipulator.NULL) {
                this.myTable.normalize();
                this.options.tableManipulator.apply(this.myTable, tableBlock);
            }
            if (this.myTable.getMaxColumns() > 0) {
                markdownWriter.blankLine();
                this.myTable.setFormatTableIndentPrefix(markdownWriter.getPrefix());
                MarkdownWriter markdownWriter2 = new MarkdownWriter(markdownWriter.getOptions());
                this.myTable.appendTable(markdownWriter2);
                List<TrackedOffset> trackedOffsets3 = this.myTable.getTrackedOffsets();
                int iOffsetWithPending = markdownWriter.offsetWithPending();
                if (!trackedOffsets2.isEmpty()) {
                    for (TrackedOffset trackedOffset : trackedOffsets2) {
                        if (trackedOffset.isResolved()) {
                            trackedOffset.setIndex(trackedOffset.getIndex() + iOffsetWithPending);
                        }
                    }
                }
                int i2 = 0;
                markdownWriter.pushPrefix().setPrefix((CharSequence) "", false).pushOptions().removeOptions(LineAppendable.F_WHITESPACE_REMOVAL).append(markdownWriter2).popOptions().popPrefix(false);
                markdownWriter.tailBlankLine();
                if (this.myTable.getMaxColumns() > 0 && !trackedOffsets2.isEmpty() && this.options.dumpIntellijOffsets) {
                    markdownWriter.append("\nTracked Offsets").line();
                    String str = Constant.WHITE_SPACE_FOR_LINK_ICON;
                    for (TrackedOffset trackedOffset2 : trackedOffsets3) {
                        i2++;
                        MarkdownWriter markdownWriterAppend = markdownWriter.append((CharSequence) str);
                        Locale locale = Locale.US;
                        int index = trackedOffset2.getIndex();
                        int index2 = trackedOffset2.getIndex() + 1;
                        int offset = trackedOffset2.getOffset();
                        int offset2 = trackedOffset2.getOffset() + 1;
                        StringBuilder sb = new StringBuilder();
                        sb.append(i2);
                        sb.append(":[");
                        sb.append(index);
                        sb.append(",");
                        sb.append(index2);
                        AbstractC0622a.m1180z(sb, offset, offset2, "] was:[", ",");
                        sb.append("]");
                        markdownWriterAppend.append((CharSequence) sb.toString());
                        str = " ";
                    }
                    markdownWriter.append("\n");
                }
            }
        }
        this.myTable = null;
    }

    @Override // com.vladsch.flexmark.formatter.NodeFormatter
    @Nullable
    public Set<Class<?>> getNodeClasses() {
        return null;
    }

    @Override // com.vladsch.flexmark.formatter.NodeFormatter
    @Nullable
    public Set<NodeFormattingHandler<?>> getNodeFormattingHandlers() {
        final int i = 0;
        final int i2 = 1;
        final int i4 = 2;
        final int i5 = 3;
        final int i6 = 4;
        final int i7 = 5;
        final int i8 = 6;
        final int i9 = 7;
        return new HashSet(Arrays.asList(new NodeFormattingHandler(TableBlock.class, new NodeFormattingHandler.CustomNodeFormatter(this) { // from class: com.vladsch.flexmark.ext.tables.internal.b

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ TableNodeFormatter f8314b;

            {
                this.f8314b = this;
            }

            @Override // com.vladsch.flexmark.formatter.NodeFormattingHandler.CustomNodeFormatter
            public final void render(Node node, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
                switch (i) {
                    case 0:
                        this.f8314b.render((TableBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 1:
                        this.f8314b.render((TableHead) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 2:
                        this.f8314b.render((TableSeparator) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 3:
                        this.f8314b.render((TableBody) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 4:
                        this.f8314b.render((TableRow) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 5:
                        this.f8314b.render((TableCell) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 6:
                        this.f8314b.render((TableCaption) node, nodeFormatterContext, markdownWriter);
                        break;
                    default:
                        this.f8314b.render((Text) node, nodeFormatterContext, markdownWriter);
                        break;
                }
            }
        }), new NodeFormattingHandler(TableHead.class, new NodeFormattingHandler.CustomNodeFormatter(this) { // from class: com.vladsch.flexmark.ext.tables.internal.b

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ TableNodeFormatter f8314b;

            {
                this.f8314b = this;
            }

            @Override // com.vladsch.flexmark.formatter.NodeFormattingHandler.CustomNodeFormatter
            public final void render(Node node, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
                switch (i2) {
                    case 0:
                        this.f8314b.render((TableBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 1:
                        this.f8314b.render((TableHead) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 2:
                        this.f8314b.render((TableSeparator) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 3:
                        this.f8314b.render((TableBody) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 4:
                        this.f8314b.render((TableRow) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 5:
                        this.f8314b.render((TableCell) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 6:
                        this.f8314b.render((TableCaption) node, nodeFormatterContext, markdownWriter);
                        break;
                    default:
                        this.f8314b.render((Text) node, nodeFormatterContext, markdownWriter);
                        break;
                }
            }
        }), new NodeFormattingHandler(TableSeparator.class, new NodeFormattingHandler.CustomNodeFormatter(this) { // from class: com.vladsch.flexmark.ext.tables.internal.b

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ TableNodeFormatter f8314b;

            {
                this.f8314b = this;
            }

            @Override // com.vladsch.flexmark.formatter.NodeFormattingHandler.CustomNodeFormatter
            public final void render(Node node, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
                switch (i4) {
                    case 0:
                        this.f8314b.render((TableBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 1:
                        this.f8314b.render((TableHead) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 2:
                        this.f8314b.render((TableSeparator) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 3:
                        this.f8314b.render((TableBody) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 4:
                        this.f8314b.render((TableRow) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 5:
                        this.f8314b.render((TableCell) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 6:
                        this.f8314b.render((TableCaption) node, nodeFormatterContext, markdownWriter);
                        break;
                    default:
                        this.f8314b.render((Text) node, nodeFormatterContext, markdownWriter);
                        break;
                }
            }
        }), new NodeFormattingHandler(TableBody.class, new NodeFormattingHandler.CustomNodeFormatter(this) { // from class: com.vladsch.flexmark.ext.tables.internal.b

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ TableNodeFormatter f8314b;

            {
                this.f8314b = this;
            }

            @Override // com.vladsch.flexmark.formatter.NodeFormattingHandler.CustomNodeFormatter
            public final void render(Node node, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
                switch (i5) {
                    case 0:
                        this.f8314b.render((TableBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 1:
                        this.f8314b.render((TableHead) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 2:
                        this.f8314b.render((TableSeparator) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 3:
                        this.f8314b.render((TableBody) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 4:
                        this.f8314b.render((TableRow) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 5:
                        this.f8314b.render((TableCell) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 6:
                        this.f8314b.render((TableCaption) node, nodeFormatterContext, markdownWriter);
                        break;
                    default:
                        this.f8314b.render((Text) node, nodeFormatterContext, markdownWriter);
                        break;
                }
            }
        }), new NodeFormattingHandler(TableRow.class, new NodeFormattingHandler.CustomNodeFormatter(this) { // from class: com.vladsch.flexmark.ext.tables.internal.b

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ TableNodeFormatter f8314b;

            {
                this.f8314b = this;
            }

            @Override // com.vladsch.flexmark.formatter.NodeFormattingHandler.CustomNodeFormatter
            public final void render(Node node, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
                switch (i6) {
                    case 0:
                        this.f8314b.render((TableBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 1:
                        this.f8314b.render((TableHead) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 2:
                        this.f8314b.render((TableSeparator) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 3:
                        this.f8314b.render((TableBody) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 4:
                        this.f8314b.render((TableRow) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 5:
                        this.f8314b.render((TableCell) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 6:
                        this.f8314b.render((TableCaption) node, nodeFormatterContext, markdownWriter);
                        break;
                    default:
                        this.f8314b.render((Text) node, nodeFormatterContext, markdownWriter);
                        break;
                }
            }
        }), new NodeFormattingHandler(TableCell.class, new NodeFormattingHandler.CustomNodeFormatter(this) { // from class: com.vladsch.flexmark.ext.tables.internal.b

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ TableNodeFormatter f8314b;

            {
                this.f8314b = this;
            }

            @Override // com.vladsch.flexmark.formatter.NodeFormattingHandler.CustomNodeFormatter
            public final void render(Node node, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
                switch (i7) {
                    case 0:
                        this.f8314b.render((TableBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 1:
                        this.f8314b.render((TableHead) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 2:
                        this.f8314b.render((TableSeparator) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 3:
                        this.f8314b.render((TableBody) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 4:
                        this.f8314b.render((TableRow) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 5:
                        this.f8314b.render((TableCell) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 6:
                        this.f8314b.render((TableCaption) node, nodeFormatterContext, markdownWriter);
                        break;
                    default:
                        this.f8314b.render((Text) node, nodeFormatterContext, markdownWriter);
                        break;
                }
            }
        }), new NodeFormattingHandler(TableCaption.class, new NodeFormattingHandler.CustomNodeFormatter(this) { // from class: com.vladsch.flexmark.ext.tables.internal.b

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ TableNodeFormatter f8314b;

            {
                this.f8314b = this;
            }

            @Override // com.vladsch.flexmark.formatter.NodeFormattingHandler.CustomNodeFormatter
            public final void render(Node node, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
                switch (i8) {
                    case 0:
                        this.f8314b.render((TableBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 1:
                        this.f8314b.render((TableHead) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 2:
                        this.f8314b.render((TableSeparator) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 3:
                        this.f8314b.render((TableBody) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 4:
                        this.f8314b.render((TableRow) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 5:
                        this.f8314b.render((TableCell) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 6:
                        this.f8314b.render((TableCaption) node, nodeFormatterContext, markdownWriter);
                        break;
                    default:
                        this.f8314b.render((Text) node, nodeFormatterContext, markdownWriter);
                        break;
                }
            }
        }), new NodeFormattingHandler(Text.class, new NodeFormattingHandler.CustomNodeFormatter(this) { // from class: com.vladsch.flexmark.ext.tables.internal.b

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ TableNodeFormatter f8314b;

            {
                this.f8314b = this;
            }

            @Override // com.vladsch.flexmark.formatter.NodeFormattingHandler.CustomNodeFormatter
            public final void render(Node node, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
                switch (i9) {
                    case 0:
                        this.f8314b.render((TableBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 1:
                        this.f8314b.render((TableHead) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 2:
                        this.f8314b.render((TableSeparator) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 3:
                        this.f8314b.render((TableBody) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 4:
                        this.f8314b.render((TableRow) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 5:
                        this.f8314b.render((TableCell) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 6:
                        this.f8314b.render((TableCaption) node, nodeFormatterContext, markdownWriter);
                        break;
                    default:
                        this.f8314b.render((Text) node, nodeFormatterContext, markdownWriter);
                        break;
                }
            }
        })));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(TableHead tableHead, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
        this.myTable.setSeparator(false);
        this.myTable.setHeader(true);
        nodeFormatterContext.renderChildren(tableHead);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(TableSeparator tableSeparator, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
        this.myTable.setSeparator(true);
        nodeFormatterContext.renderChildren(tableSeparator);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(TableBody tableBody, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
        this.myTable.setSeparator(false);
        this.myTable.setHeader(false);
        nodeFormatterContext.renderChildren(tableBody);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(TableRow tableRow, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
        nodeFormatterContext.renderChildren(tableRow);
        if (nodeFormatterContext.getRenderPurpose() == RenderPurpose.FORMAT) {
            if (this.myTable.isSeparator()) {
                return;
            }
            this.myTable.nextRow();
            return;
        }
        markdownWriter.line();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(TableCaption tableCaption, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
        if (nodeFormatterContext.getRenderPurpose() == RenderPurpose.FORMAT) {
            this.myTable.setCaptionWithMarkers(tableCaption, tableCaption.getOpeningMarker(), tableCaption.getText(), tableCaption.getClosingMarker());
            return;
        }
        String str = tableCaption.hasChildren() ? aPerfUtil.DUMMY_SUB_OP_NAME : "";
        if (MarkdownTable.formattedCaption(BasedSequence.m13437of(str).subSequence(0, str.length()), this.options) != null) {
            markdownWriter.line().append((CharSequence) tableCaption.getOpeningMarker());
            nodeFormatterContext.renderChildren(tableCaption);
            markdownWriter.append((CharSequence) tableCaption.getClosingMarker()).line();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(TableCell tableCell, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
        if (nodeFormatterContext.getRenderPurpose() == RenderPurpose.FORMAT) {
            BasedSequence text = tableCell.getText();
            if (this.options.trimCellWhitespace) {
                if (text.isBlank() && !text.isEmpty()) {
                    text = text.subSequence(0, 1);
                } else {
                    text = text.trim();
                }
            }
            this.myTable.addCell(new com.vladsch.flexmark.util.format.TableCell(tableCell, tableCell.getOpeningMarker(), text, tableCell.getClosingMarker(), 1, tableCell.getSpan(), tableCell.getAlignment() == null ? CellAlignment.NONE : tableCell.getAlignment().cellAlignment()));
            return;
        }
        if (tableCell.getPrevious() == null && this.options.leadTrailPipes && tableCell.getOpeningMarker().isEmpty()) {
            markdownWriter.append('|');
        } else {
            markdownWriter.append((CharSequence) tableCell.getOpeningMarker());
        }
        if (!this.myTable.isSeparator() && this.options.spaceAroundPipes && (!tableCell.getText().startsWith(" ") || this.parserTrimCellWhiteSpace)) {
            markdownWriter.append(' ');
        }
        String[] strArr = {""};
        nodeFormatterContext.translatingSpan(new C0287e(tableCell, strArr, 28));
        if (!this.myTable.isSeparator() && this.options.spaceAroundPipes && (!strArr[0].endsWith(" ") || this.parserTrimCellWhiteSpace)) {
            markdownWriter.append(' ');
        }
        if (tableCell.getNext() == null) {
            if (this.options.leadTrailPipes && tableCell.getClosingMarker().isEmpty()) {
                markdownWriter.append('|');
                return;
            } else {
                markdownWriter.append((CharSequence) tableCell.getClosingMarker());
                return;
            }
        }
        markdownWriter.append((CharSequence) tableCell.getClosingMarker());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(Text text, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
        MarkdownTable markdownTable = this.myTable;
        if (markdownTable != null && markdownTable.isSeparator()) {
            Node ancestorOfType = text.getAncestorOfType(Paragraph.class);
            if ((ancestorOfType instanceof Paragraph) && ((Paragraph) ancestorOfType).hasTableSeparator()) {
                markdownWriter.pushPrefix().addPrefix((CharSequence) " ").append((CharSequence) text.getChars()).popPrefix();
                return;
            } else {
                markdownWriter.append((CharSequence) text.getChars());
                return;
            }
        }
        markdownWriter.append((CharSequence) text.getChars());
    }
}
