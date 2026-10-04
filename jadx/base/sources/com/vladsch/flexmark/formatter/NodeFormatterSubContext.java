package com.vladsch.flexmark.formatter;

import com.vladsch.flexmark.util.ast.Node;
import java.io.IOException;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public abstract class NodeFormatterSubContext implements NodeFormatterContext {
    protected final MarkdownWriter markdown;
    List<NodeFormattingHandler<?>> rendererList = null;
    int rendererIndex = -1;
    Node renderingNode = null;

    public NodeFormatterSubContext(@NotNull MarkdownWriter markdownWriter) {
        this.markdown = markdownWriter;
    }

    public void flushTo(@NotNull Appendable appendable, int i) {
        flushTo(appendable, getFormatterOptions().maxBlankLines, i);
    }

    @Override // com.vladsch.flexmark.formatter.NodeFormatterContext
    @NotNull
    public MarkdownWriter getMarkdown() {
        return this.markdown;
    }

    @Nullable
    public Node getRenderingNode() {
        return this.renderingNode;
    }

    public void setRenderingNode(@Nullable Node node) {
        this.renderingNode = node;
    }

    public void flushTo(@NotNull Appendable appendable, int i, int i2) {
        this.markdown.line();
        try {
            this.markdown.appendTo(appendable, i, i2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
