package com.vladsch.flexmark.html;

import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.vladsch.flexmark.html.renderer.AttributablePart;
import com.vladsch.flexmark.html.renderer.LinkResolverContext;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.html.Attributes;
import com.vladsch.flexmark.util.html.MutableAttributes;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class EmbeddedAttributeProvider implements AttributeProvider {
    public static final IndependentAttributeProviderFactory Factory = new IndependentAttributeProviderFactory() { // from class: com.vladsch.flexmark.html.EmbeddedAttributeProvider.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.vladsch.flexmark.html.AttributeProviderFactory, java.util.function.Function
        @NotNull
        public AttributeProvider apply(@NotNull LinkResolverContext linkResolverContext) {
            return new EmbeddedAttributeProvider();
        }
    };

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class EmbeddedNodeAttributes extends Node {

        @NotNull
        final Attributes attributes;

        public EmbeddedNodeAttributes(@NotNull Node node, @NotNull Attributes attributes) {
            super(node.getChars().subSequence(0, 0));
            this.attributes = attributes;
        }

        @Override // com.vladsch.flexmark.util.ast.Node
        public void astExtraChars(@NotNull StringBuilder sb) {
        }

        @Override // com.vladsch.flexmark.util.ast.Node
        public void astString(@NotNull StringBuilder sb, boolean z) {
            sb.append(EmbeddedNodeAttributes.class.getSimpleName());
            sb.append("[");
            sb.append(getStartOffset());
            sb.append(SQLKeyword.COMMA);
            sb.append(getEndOffset());
            sb.append("]");
            sb.append(", attributes: ");
            sb.append(this.attributes.toString());
            if (z) {
                getAstExtra(sb);
            }
        }

        @Override // com.vladsch.flexmark.util.ast.Node
        @NotNull
        public BasedSequence[] getSegments() {
            return Node.EMPTY_SEGMENTS;
        }
    }

    @Override // com.vladsch.flexmark.html.AttributeProvider
    public void setAttributes(@NotNull Node node, @NotNull AttributablePart attributablePart, @NotNull MutableAttributes mutableAttributes) {
        if (attributablePart == AttributablePart.NODE) {
            Node childOfType = node.getChildOfType(EmbeddedNodeAttributes.class);
            if (childOfType instanceof EmbeddedNodeAttributes) {
                mutableAttributes.addValues(((EmbeddedNodeAttributes) childOfType).attributes);
            }
        }
    }
}
