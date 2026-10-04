package com.vladsch.flexmark.formatter;

import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.visitor.AstAction;
import com.vladsch.flexmark.util.visitor.AstHandler;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class NodeFormattingHandler<N extends Node> extends AstHandler<N, CustomNodeFormatter<N>> {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface CustomNodeFormatter<N extends Node> extends AstAction<N> {
        void render(@NotNull N n, @NotNull NodeFormatterContext nodeFormatterContext, @NotNull MarkdownWriter markdownWriter);
    }

    public NodeFormattingHandler(@NotNull Class<N> cls, @NotNull CustomNodeFormatter<N> customNodeFormatter) {
        super(cls, customNodeFormatter);
    }

    public void render(@NotNull Node node, @NotNull NodeFormatterContext nodeFormatterContext, @NotNull MarkdownWriter markdownWriter) {
        getAdapter().render(node, nodeFormatterContext, markdownWriter);
    }
}
