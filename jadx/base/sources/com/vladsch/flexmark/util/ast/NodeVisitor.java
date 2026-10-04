package com.vladsch.flexmark.util.ast;

import com.vladsch.flexmark.util.visitor.AstActionHandler;
import java.util.Collection;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class NodeVisitor extends AstActionHandler<NodeVisitor, Node, Visitor<Node>, VisitHandler<Node>> implements NodeVisitHandler {
    protected static final VisitHandler[] EMPTY_HANDLERS = new VisitHandler[0];

    public NodeVisitor() {
        super(Node.AST_ADAPTER);
    }

    @NotNull
    public NodeVisitor addHandler(@NotNull VisitHandler visitHandler) {
        return (NodeVisitor) super.addActionHandler(visitHandler);
    }

    @NotNull
    public NodeVisitor addHandlers(@NotNull Collection<VisitHandler> collection) {
        return addActionHandlers((VisitHandler[]) collection.toArray(EMPTY_HANDLERS));
    }

    @NotNull
    public NodeVisitor addTypedHandlers(@NotNull Collection<VisitHandler<?>> collection) {
        return addActionHandlers((VisitHandler[]) collection.toArray(EMPTY_HANDLERS));
    }

    @Override // com.vladsch.flexmark.util.ast.Visitor
    public final void visit(@NotNull Node node) {
        processNode(node, true, new C11836a(this, 0));
    }

    @Override // com.vladsch.flexmark.util.ast.NodeVisitHandler
    public final void visitChildren(@NotNull Node node) {
        processChildren(node, new C11836a(this, 0));
    }

    @Override // com.vladsch.flexmark.util.ast.NodeVisitHandler
    public final void visitNodeOnly(@NotNull Node node) {
        processNode(node, false, new C11836a(this, 0));
    }

    public NodeVisitor(@NotNull VisitHandler... visitHandlerArr) {
        super(Node.AST_ADAPTER);
        addActionHandlers(visitHandlerArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void visit(@NotNull Node node, @NotNull Visitor<Node> visitor) {
        visitor.visit(node);
    }

    @NotNull
    public NodeVisitor addHandlers(@NotNull VisitHandler[] visitHandlerArr) {
        return addActionHandlers(visitHandlerArr);
    }

    @NotNull
    public NodeVisitor addHandlers(@NotNull VisitHandler[]... visitHandlerArr) {
        return addActionHandlers(visitHandlerArr);
    }

    public NodeVisitor(@NotNull VisitHandler[]... visitHandlerArr) {
        super(Node.AST_ADAPTER);
        addActionHandlers(visitHandlerArr);
    }

    public NodeVisitor(@NotNull Collection<VisitHandler> collection) {
        super(Node.AST_ADAPTER);
        addHandlers(collection);
    }
}
