package com.vladsch.flexmark.ast.util;

import com.samsung.android.imagetranslation.inpainting.C7126a;
import com.vladsch.flexmark.ast.util.AttributeProvidingHandler;
import com.vladsch.flexmark.html.renderer.AttributablePart;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.html.MutableAttributes;
import com.vladsch.flexmark.util.visitor.AstActionHandler;
import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class AttributeProviderAdapter extends AstActionHandler<AttributeProviderAdapter, Node, AttributeProvidingHandler.AttributeProvidingVisitor<Node>, AttributeProvidingHandler<Node>> implements AttributeProvidingHandler.AttributeProvidingVisitor<Node> {
    protected static final AttributeProvidingHandler[] EMPTY_HANDLERS = new AttributeProvidingHandler[0];

    public AttributeProviderAdapter(AttributeProvidingHandler... attributeProvidingHandlerArr) {
        super(Node.AST_ADAPTER);
        addActionHandlers(attributeProvidingHandlerArr);
    }

    public AttributeProviderAdapter addHandler(AttributeProvidingHandler attributeProvidingHandler) {
        return (AttributeProviderAdapter) super.addActionHandler(attributeProvidingHandler);
    }

    public AttributeProviderAdapter addHandlers(Collection<AttributeProvidingHandler> collection) {
        return addHandlers((AttributeProvidingHandler[]) collection.toArray(EMPTY_HANDLERS));
    }

    @Override // com.vladsch.flexmark.ast.util.AttributeProvidingHandler.AttributeProvidingVisitor
    public void setAttributes(Node node, AttributablePart attributablePart, MutableAttributes mutableAttributes) {
        processNode(node, false, new C7126a(attributablePart, mutableAttributes, 1));
    }

    public AttributeProviderAdapter addHandlers(AttributeProvidingHandler... attributeProvidingHandlerArr) {
        return addActionHandlers(attributeProvidingHandlerArr);
    }

    public AttributeProviderAdapter(AttributeProvidingHandler[]... attributeProvidingHandlerArr) {
        super(Node.AST_ADAPTER);
        addActionHandlers(attributeProvidingHandlerArr);
    }

    public AttributeProviderAdapter addHandlers(AttributeProvidingHandler[]... attributeProvidingHandlerArr) {
        return addActionHandlers(attributeProvidingHandlerArr);
    }

    public AttributeProviderAdapter(Collection<AttributeProvidingHandler> collection) {
        super(Node.AST_ADAPTER);
        addHandlers(collection);
    }
}
