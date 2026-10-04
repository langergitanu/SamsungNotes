package com.vladsch.flexmark.ast.util;

import com.vladsch.flexmark.html.renderer.AttributablePart;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.html.MutableAttributes;
import com.vladsch.flexmark.util.visitor.AstAction;
import com.vladsch.flexmark.util.visitor.AstHandler;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class AttributeProvidingHandler<N extends Node> extends AstHandler<N, AttributeProvidingVisitor<N>> {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface AttributeProvidingVisitor<N extends Node> extends AstAction<N> {
        void setAttributes(N n, AttributablePart attributablePart, MutableAttributes mutableAttributes);
    }

    public AttributeProvidingHandler(Class<N> cls, AttributeProvidingVisitor<N> attributeProvidingVisitor) {
        super(cls, attributeProvidingVisitor);
    }

    public void setAttributes(Node node, AttributablePart attributablePart, MutableAttributes mutableAttributes) {
        getAdapter().setAttributes(node, attributablePart, mutableAttributes);
    }
}
