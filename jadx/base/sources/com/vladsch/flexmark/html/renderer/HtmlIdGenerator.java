package com.vladsch.flexmark.html.renderer;

import com.vladsch.flexmark.ast.util.AnchorRefTargetBlockPreVisitor;
import com.vladsch.flexmark.util.ast.Document;
import com.vladsch.flexmark.util.ast.Node;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface HtmlIdGenerator {
    public static final HtmlIdGenerator NULL = new HtmlIdGenerator() { // from class: com.vladsch.flexmark.html.renderer.HtmlIdGenerator.1
        @Override // com.vladsch.flexmark.html.renderer.HtmlIdGenerator
        public void generateIds(Document document) {
        }

        @Override // com.vladsch.flexmark.html.renderer.HtmlIdGenerator
        @Nullable
        public String getId(@NotNull Node node) {
            return null;
        }

        @Override // com.vladsch.flexmark.html.renderer.HtmlIdGenerator
        public void generateIds(Document document, @Nullable AnchorRefTargetBlockPreVisitor anchorRefTargetBlockPreVisitor) {
        }

        @Override // com.vladsch.flexmark.html.renderer.HtmlIdGenerator
        @Nullable
        public String getId(@NotNull CharSequence charSequence) {
            return null;
        }
    };

    void generateIds(Document document);

    default void generateIds(Document document, @Nullable AnchorRefTargetBlockPreVisitor anchorRefTargetBlockPreVisitor) {
        generateIds(document);
    }

    @Nullable
    String getId(@NotNull Node node);

    @Nullable
    String getId(@NotNull CharSequence charSequence);
}
