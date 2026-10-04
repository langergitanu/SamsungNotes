package com.vladsch.flexmark.ext.tables.internal;

import com.vladsch.flexmark.ast.BlockQuote;
import com.vladsch.flexmark.ext.tables.TableBlock;
import com.vladsch.flexmark.ext.tables.TableBody;
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
import com.vladsch.flexmark.util.sequence.BasedSequence;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class TableJiraRenderer implements NodeRenderer {

    /* JADX INFO: renamed from: com.vladsch.flexmark.ext.tables.internal.TableJiraRenderer$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C117951 {
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
            return new TableJiraRenderer(dataHolder);
        }
    }

    public TableJiraRenderer(DataHolder dataHolder) {
    }

    private static String getAlignValue(TableCell.Alignment alignment) {
        int i = C117951.$SwitchMap$com$vladsch$flexmark$ext$tables$TableCell$Alignment[alignment.ordinal()];
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

    private HtmlWriter tailBlankLine(Node node, HtmlWriter htmlWriter) {
        return tailBlankLine(node, 1, htmlWriter);
    }

    @Override // com.vladsch.flexmark.html.renderer.NodeRenderer
    public Set<NodeRenderingHandler<?>> getNodeRenderingHandlers() {
        final int i = 0;
        final int i2 = 1;
        final int i4 = 2;
        final int i5 = 3;
        final int i6 = 4;
        final int i7 = 5;
        return new HashSet(Arrays.asList(new NodeRenderingHandler(TableBlock.class, new NodeRenderingHandler.CustomNodeRenderer(this) { // from class: com.vladsch.flexmark.ext.tables.internal.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ TableJiraRenderer f8312b;

            {
                this.f8312b = this;
            }

            @Override // com.vladsch.flexmark.html.renderer.NodeRenderingHandler.CustomNodeRenderer
            public final void render(Node node, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
                switch (i) {
                    case 0:
                        this.f8312b.render((TableBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 1:
                        this.f8312b.render((TableHead) node, nodeRendererContext, htmlWriter);
                        break;
                    case 2:
                        this.f8312b.render((TableSeparator) node, nodeRendererContext, htmlWriter);
                        break;
                    case 3:
                        this.f8312b.render((TableBody) node, nodeRendererContext, htmlWriter);
                        break;
                    case 4:
                        this.f8312b.render((TableRow) node, nodeRendererContext, htmlWriter);
                        break;
                    default:
                        this.f8312b.render((TableCell) node, nodeRendererContext, htmlWriter);
                        break;
                }
            }
        }), new NodeRenderingHandler(TableHead.class, new NodeRenderingHandler.CustomNodeRenderer(this) { // from class: com.vladsch.flexmark.ext.tables.internal.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ TableJiraRenderer f8312b;

            {
                this.f8312b = this;
            }

            @Override // com.vladsch.flexmark.html.renderer.NodeRenderingHandler.CustomNodeRenderer
            public final void render(Node node, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
                switch (i2) {
                    case 0:
                        this.f8312b.render((TableBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 1:
                        this.f8312b.render((TableHead) node, nodeRendererContext, htmlWriter);
                        break;
                    case 2:
                        this.f8312b.render((TableSeparator) node, nodeRendererContext, htmlWriter);
                        break;
                    case 3:
                        this.f8312b.render((TableBody) node, nodeRendererContext, htmlWriter);
                        break;
                    case 4:
                        this.f8312b.render((TableRow) node, nodeRendererContext, htmlWriter);
                        break;
                    default:
                        this.f8312b.render((TableCell) node, nodeRendererContext, htmlWriter);
                        break;
                }
            }
        }), new NodeRenderingHandler(TableSeparator.class, new NodeRenderingHandler.CustomNodeRenderer(this) { // from class: com.vladsch.flexmark.ext.tables.internal.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ TableJiraRenderer f8312b;

            {
                this.f8312b = this;
            }

            @Override // com.vladsch.flexmark.html.renderer.NodeRenderingHandler.CustomNodeRenderer
            public final void render(Node node, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
                switch (i4) {
                    case 0:
                        this.f8312b.render((TableBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 1:
                        this.f8312b.render((TableHead) node, nodeRendererContext, htmlWriter);
                        break;
                    case 2:
                        this.f8312b.render((TableSeparator) node, nodeRendererContext, htmlWriter);
                        break;
                    case 3:
                        this.f8312b.render((TableBody) node, nodeRendererContext, htmlWriter);
                        break;
                    case 4:
                        this.f8312b.render((TableRow) node, nodeRendererContext, htmlWriter);
                        break;
                    default:
                        this.f8312b.render((TableCell) node, nodeRendererContext, htmlWriter);
                        break;
                }
            }
        }), new NodeRenderingHandler(TableBody.class, new NodeRenderingHandler.CustomNodeRenderer(this) { // from class: com.vladsch.flexmark.ext.tables.internal.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ TableJiraRenderer f8312b;

            {
                this.f8312b = this;
            }

            @Override // com.vladsch.flexmark.html.renderer.NodeRenderingHandler.CustomNodeRenderer
            public final void render(Node node, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
                switch (i5) {
                    case 0:
                        this.f8312b.render((TableBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 1:
                        this.f8312b.render((TableHead) node, nodeRendererContext, htmlWriter);
                        break;
                    case 2:
                        this.f8312b.render((TableSeparator) node, nodeRendererContext, htmlWriter);
                        break;
                    case 3:
                        this.f8312b.render((TableBody) node, nodeRendererContext, htmlWriter);
                        break;
                    case 4:
                        this.f8312b.render((TableRow) node, nodeRendererContext, htmlWriter);
                        break;
                    default:
                        this.f8312b.render((TableCell) node, nodeRendererContext, htmlWriter);
                        break;
                }
            }
        }), new NodeRenderingHandler(TableRow.class, new NodeRenderingHandler.CustomNodeRenderer(this) { // from class: com.vladsch.flexmark.ext.tables.internal.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ TableJiraRenderer f8312b;

            {
                this.f8312b = this;
            }

            @Override // com.vladsch.flexmark.html.renderer.NodeRenderingHandler.CustomNodeRenderer
            public final void render(Node node, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
                switch (i6) {
                    case 0:
                        this.f8312b.render((TableBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 1:
                        this.f8312b.render((TableHead) node, nodeRendererContext, htmlWriter);
                        break;
                    case 2:
                        this.f8312b.render((TableSeparator) node, nodeRendererContext, htmlWriter);
                        break;
                    case 3:
                        this.f8312b.render((TableBody) node, nodeRendererContext, htmlWriter);
                        break;
                    case 4:
                        this.f8312b.render((TableRow) node, nodeRendererContext, htmlWriter);
                        break;
                    default:
                        this.f8312b.render((TableCell) node, nodeRendererContext, htmlWriter);
                        break;
                }
            }
        }), new NodeRenderingHandler(TableCell.class, new NodeRenderingHandler.CustomNodeRenderer(this) { // from class: com.vladsch.flexmark.ext.tables.internal.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ TableJiraRenderer f8312b;

            {
                this.f8312b = this;
            }

            @Override // com.vladsch.flexmark.html.renderer.NodeRenderingHandler.CustomNodeRenderer
            public final void render(Node node, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
                switch (i7) {
                    case 0:
                        this.f8312b.render((TableBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 1:
                        this.f8312b.render((TableHead) node, nodeRendererContext, htmlWriter);
                        break;
                    case 2:
                        this.f8312b.render((TableSeparator) node, nodeRendererContext, htmlWriter);
                        break;
                    case 3:
                        this.f8312b.render((TableBody) node, nodeRendererContext, htmlWriter);
                        break;
                    case 4:
                        this.f8312b.render((TableRow) node, nodeRendererContext, htmlWriter);
                        break;
                    default:
                        this.f8312b.render((TableCell) node, nodeRendererContext, htmlWriter);
                        break;
                }
            }
        })));
    }

    public boolean isLastBlockQuoteChild(Node node) {
        Node parent = node.getParent();
        return (parent instanceof BlockQuote) && parent.getLastChild() == node;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(TableBlock tableBlock, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
        nodeRendererContext.renderChildren(tableBlock);
        tailBlankLine(tableBlock, htmlWriter);
    }

    public HtmlWriter tailBlankLine(Node node, int i, HtmlWriter htmlWriter) {
        if (!isLastBlockQuoteChild(node)) {
            htmlWriter.blankLine(i);
            return htmlWriter;
        }
        BasedSequence prefix = htmlWriter.getPrefix();
        htmlWriter.popPrefix();
        htmlWriter.blankLine(i);
        htmlWriter.pushPrefix();
        htmlWriter.setPrefix((CharSequence) prefix, false);
        return htmlWriter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(TableHead tableHead, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
        nodeRendererContext.renderChildren(tableHead);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(TableBody tableBody, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
        nodeRendererContext.renderChildren(tableBody);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(TableRow tableRow, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
        if (tableRow.getParent() instanceof TableHead) {
            htmlWriter.line().raw((CharSequence) "||");
        } else if (tableRow.getParent() instanceof TableBody) {
            htmlWriter.line().raw((CharSequence) "|");
        }
        nodeRendererContext.renderChildren(tableRow);
        htmlWriter.line();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(TableCell tableCell, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
        nodeRendererContext.renderChildren(tableCell);
        if (tableCell.getGrandParent() instanceof TableHead) {
            htmlWriter.raw("||");
        } else if (tableCell.getGrandParent() instanceof TableBody) {
            htmlWriter.raw("|");
        }
    }
}
