package com.vladsch.flexmark.ext.tables.internal;

import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.model.RunnableC10960a;
import com.vladsch.flexmark.ext.tables.TableBlock;
import com.vladsch.flexmark.ext.tables.TableBody;
import com.vladsch.flexmark.ext.tables.TableCaption;
import com.vladsch.flexmark.ext.tables.TableCell;
import com.vladsch.flexmark.ext.tables.TableHead;
import com.vladsch.flexmark.ext.tables.TableRow;
import com.vladsch.flexmark.ext.tables.TableSeparator;
import com.vladsch.flexmark.html.HtmlWriter;
import com.vladsch.flexmark.html.renderer.NodeRenderer;
import com.vladsch.flexmark.html.renderer.NodeRendererContext;
import com.vladsch.flexmark.html.renderer.NodeRendererFactory;
import com.vladsch.flexmark.html.renderer.NodeRenderingHandler;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.DataHolder;
import com.vladsch.flexmark.util.html.Attribute;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class TableNodeRenderer implements NodeRenderer {
    private final TableParserOptions options;

    /* JADX INFO: renamed from: com.vladsch.flexmark.ext.tables.internal.TableNodeRenderer$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C117971 {
        static final /* synthetic */ int[] $SwitchMap$com$vladsch$flexmark$ext$tables$TableCell$Alignment;

        static {
            int[] iArr = new int[TableCell.Alignment.values().length];
            $SwitchMap$com$vladsch$flexmark$ext$tables$TableCell$Alignment = iArr;
            try {
                iArr[TableCell.Alignment.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$vladsch$flexmark$ext$tables$TableCell$Alignment[TableCell.Alignment.CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$vladsch$flexmark$ext$tables$TableCell$Alignment[TableCell.Alignment.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Factory implements NodeRendererFactory {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.vladsch.flexmark.html.renderer.NodeRendererFactory, java.util.function.Function
        @NotNull
        public NodeRenderer apply(@NotNull DataHolder dataHolder) {
            return new TableNodeRenderer(dataHolder);
        }
    }

    public TableNodeRenderer(DataHolder dataHolder) {
        this.options = new TableParserOptions(dataHolder);
    }

    private static String getAlignValue(TableCell.Alignment alignment) {
        int i = C117971.$SwitchMap$com$vladsch$flexmark$ext$tables$TableCell$Alignment[alignment.ordinal()];
        if (i == 1) {
            return "left";
        }
        if (i == 2) {
            return "center";
        }
        if (i == 3) {
            return "right";
        }
        throw new IllegalStateException("Unknown alignment: " + alignment);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(TableSeparator tableSeparator, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
    }

    @Override // com.vladsch.flexmark.html.renderer.NodeRenderer
    public Set<NodeRenderingHandler<?>> getNodeRenderingHandlers() {
        final int i = 0;
        final int i2 = 1;
        final int i4 = 2;
        final int i5 = 3;
        final int i6 = 4;
        final int i7 = 5;
        final int i8 = 6;
        return new HashSet(Arrays.asList(new NodeRenderingHandler(TableBlock.class, new NodeRenderingHandler.CustomNodeRenderer(this) { // from class: com.vladsch.flexmark.ext.tables.internal.c

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ TableNodeRenderer f8316b;

            {
                this.f8316b = this;
            }

            @Override // com.vladsch.flexmark.html.renderer.NodeRenderingHandler.CustomNodeRenderer
            public final void render(Node node, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
                switch (i) {
                    case 0:
                        this.f8316b.render((TableBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 1:
                        this.f8316b.render((TableHead) node, nodeRendererContext, htmlWriter);
                        break;
                    case 2:
                        this.f8316b.render((TableSeparator) node, nodeRendererContext, htmlWriter);
                        break;
                    case 3:
                        this.f8316b.render((TableBody) node, nodeRendererContext, htmlWriter);
                        break;
                    case 4:
                        this.f8316b.render((TableRow) node, nodeRendererContext, htmlWriter);
                        break;
                    case 5:
                        this.f8316b.render((TableCell) node, nodeRendererContext, htmlWriter);
                        break;
                    default:
                        this.f8316b.render((TableCaption) node, nodeRendererContext, htmlWriter);
                        break;
                }
            }
        }), new NodeRenderingHandler(TableHead.class, new NodeRenderingHandler.CustomNodeRenderer(this) { // from class: com.vladsch.flexmark.ext.tables.internal.c

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ TableNodeRenderer f8316b;

            {
                this.f8316b = this;
            }

            @Override // com.vladsch.flexmark.html.renderer.NodeRenderingHandler.CustomNodeRenderer
            public final void render(Node node, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
                switch (i2) {
                    case 0:
                        this.f8316b.render((TableBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 1:
                        this.f8316b.render((TableHead) node, nodeRendererContext, htmlWriter);
                        break;
                    case 2:
                        this.f8316b.render((TableSeparator) node, nodeRendererContext, htmlWriter);
                        break;
                    case 3:
                        this.f8316b.render((TableBody) node, nodeRendererContext, htmlWriter);
                        break;
                    case 4:
                        this.f8316b.render((TableRow) node, nodeRendererContext, htmlWriter);
                        break;
                    case 5:
                        this.f8316b.render((TableCell) node, nodeRendererContext, htmlWriter);
                        break;
                    default:
                        this.f8316b.render((TableCaption) node, nodeRendererContext, htmlWriter);
                        break;
                }
            }
        }), new NodeRenderingHandler(TableSeparator.class, new NodeRenderingHandler.CustomNodeRenderer(this) { // from class: com.vladsch.flexmark.ext.tables.internal.c

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ TableNodeRenderer f8316b;

            {
                this.f8316b = this;
            }

            @Override // com.vladsch.flexmark.html.renderer.NodeRenderingHandler.CustomNodeRenderer
            public final void render(Node node, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
                switch (i4) {
                    case 0:
                        this.f8316b.render((TableBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 1:
                        this.f8316b.render((TableHead) node, nodeRendererContext, htmlWriter);
                        break;
                    case 2:
                        this.f8316b.render((TableSeparator) node, nodeRendererContext, htmlWriter);
                        break;
                    case 3:
                        this.f8316b.render((TableBody) node, nodeRendererContext, htmlWriter);
                        break;
                    case 4:
                        this.f8316b.render((TableRow) node, nodeRendererContext, htmlWriter);
                        break;
                    case 5:
                        this.f8316b.render((TableCell) node, nodeRendererContext, htmlWriter);
                        break;
                    default:
                        this.f8316b.render((TableCaption) node, nodeRendererContext, htmlWriter);
                        break;
                }
            }
        }), new NodeRenderingHandler(TableBody.class, new NodeRenderingHandler.CustomNodeRenderer(this) { // from class: com.vladsch.flexmark.ext.tables.internal.c

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ TableNodeRenderer f8316b;

            {
                this.f8316b = this;
            }

            @Override // com.vladsch.flexmark.html.renderer.NodeRenderingHandler.CustomNodeRenderer
            public final void render(Node node, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
                switch (i5) {
                    case 0:
                        this.f8316b.render((TableBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 1:
                        this.f8316b.render((TableHead) node, nodeRendererContext, htmlWriter);
                        break;
                    case 2:
                        this.f8316b.render((TableSeparator) node, nodeRendererContext, htmlWriter);
                        break;
                    case 3:
                        this.f8316b.render((TableBody) node, nodeRendererContext, htmlWriter);
                        break;
                    case 4:
                        this.f8316b.render((TableRow) node, nodeRendererContext, htmlWriter);
                        break;
                    case 5:
                        this.f8316b.render((TableCell) node, nodeRendererContext, htmlWriter);
                        break;
                    default:
                        this.f8316b.render((TableCaption) node, nodeRendererContext, htmlWriter);
                        break;
                }
            }
        }), new NodeRenderingHandler(TableRow.class, new NodeRenderingHandler.CustomNodeRenderer(this) { // from class: com.vladsch.flexmark.ext.tables.internal.c

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ TableNodeRenderer f8316b;

            {
                this.f8316b = this;
            }

            @Override // com.vladsch.flexmark.html.renderer.NodeRenderingHandler.CustomNodeRenderer
            public final void render(Node node, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
                switch (i6) {
                    case 0:
                        this.f8316b.render((TableBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 1:
                        this.f8316b.render((TableHead) node, nodeRendererContext, htmlWriter);
                        break;
                    case 2:
                        this.f8316b.render((TableSeparator) node, nodeRendererContext, htmlWriter);
                        break;
                    case 3:
                        this.f8316b.render((TableBody) node, nodeRendererContext, htmlWriter);
                        break;
                    case 4:
                        this.f8316b.render((TableRow) node, nodeRendererContext, htmlWriter);
                        break;
                    case 5:
                        this.f8316b.render((TableCell) node, nodeRendererContext, htmlWriter);
                        break;
                    default:
                        this.f8316b.render((TableCaption) node, nodeRendererContext, htmlWriter);
                        break;
                }
            }
        }), new NodeRenderingHandler(TableCell.class, new NodeRenderingHandler.CustomNodeRenderer(this) { // from class: com.vladsch.flexmark.ext.tables.internal.c

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ TableNodeRenderer f8316b;

            {
                this.f8316b = this;
            }

            @Override // com.vladsch.flexmark.html.renderer.NodeRenderingHandler.CustomNodeRenderer
            public final void render(Node node, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
                switch (i7) {
                    case 0:
                        this.f8316b.render((TableBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 1:
                        this.f8316b.render((TableHead) node, nodeRendererContext, htmlWriter);
                        break;
                    case 2:
                        this.f8316b.render((TableSeparator) node, nodeRendererContext, htmlWriter);
                        break;
                    case 3:
                        this.f8316b.render((TableBody) node, nodeRendererContext, htmlWriter);
                        break;
                    case 4:
                        this.f8316b.render((TableRow) node, nodeRendererContext, htmlWriter);
                        break;
                    case 5:
                        this.f8316b.render((TableCell) node, nodeRendererContext, htmlWriter);
                        break;
                    default:
                        this.f8316b.render((TableCaption) node, nodeRendererContext, htmlWriter);
                        break;
                }
            }
        }), new NodeRenderingHandler(TableCaption.class, new NodeRenderingHandler.CustomNodeRenderer(this) { // from class: com.vladsch.flexmark.ext.tables.internal.c

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ TableNodeRenderer f8316b;

            {
                this.f8316b = this;
            }

            @Override // com.vladsch.flexmark.html.renderer.NodeRenderingHandler.CustomNodeRenderer
            public final void render(Node node, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
                switch (i8) {
                    case 0:
                        this.f8316b.render((TableBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 1:
                        this.f8316b.render((TableHead) node, nodeRendererContext, htmlWriter);
                        break;
                    case 2:
                        this.f8316b.render((TableSeparator) node, nodeRendererContext, htmlWriter);
                        break;
                    case 3:
                        this.f8316b.render((TableBody) node, nodeRendererContext, htmlWriter);
                        break;
                    case 4:
                        this.f8316b.render((TableRow) node, nodeRendererContext, htmlWriter);
                        break;
                    case 5:
                        this.f8316b.render((TableCell) node, nodeRendererContext, htmlWriter);
                        break;
                    default:
                        this.f8316b.render((TableCaption) node, nodeRendererContext, htmlWriter);
                        break;
                }
            }
        })));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(TableBlock tableBlock, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
        if (!this.options.className.isEmpty()) {
            htmlWriter.attr(Attribute.CLASS_ATTR, (CharSequence) this.options.className);
        }
        htmlWriter.srcPosWithEOL(tableBlock.getChars()).withAttr().tagLineIndent("table", (Runnable) new RunnableC10960a(nodeRendererContext, tableBlock, 13)).line();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(TableHead tableHead, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
        htmlWriter.withAttr().withCondIndent().tagLine((CharSequence) "thead", (Runnable) new RunnableC10960a(nodeRendererContext, tableHead, 9));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(TableBody tableBody, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
        htmlWriter.withAttr().withCondIndent().tagLine((CharSequence) "tbody", (Runnable) new RunnableC10960a(nodeRendererContext, tableBody, 10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(TableRow tableRow, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
        htmlWriter.srcPos(tableRow.getChars().trimStart()).withAttr().tagLine("tr", (Runnable) new RunnableC10960a(nodeRendererContext, tableRow, 11));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(TableCaption tableCaption, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
        htmlWriter.srcPos(tableCaption.getChars().trimStart()).withAttr().tagLine("caption", (Runnable) new RunnableC10960a(nodeRendererContext, tableCaption, 12));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(TableCell tableCell, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
        String str = tableCell.isHeader() ? "th" : "td";
        if (tableCell.getAlignment() != null) {
            htmlWriter.attr("align", (CharSequence) getAlignValue(tableCell.getAlignment()));
        }
        if (this.options.columnSpans && tableCell.getSpan() > 1) {
            htmlWriter.attr("colspan", (CharSequence) String.valueOf(tableCell.getSpan()));
        }
        htmlWriter.srcPos(tableCell.getText()).withAttr().tag((CharSequence) str);
        nodeRendererContext.renderChildren(tableCell);
        htmlWriter.tag((CharSequence) "/".concat(str));
    }
}
