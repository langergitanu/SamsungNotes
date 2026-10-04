package com.vladsch.flexmark.formatter;

import com.vladsch.flexmark.util.ast.Document;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface TranslationHandler extends TranslationContext {
    void beginRendering(@NotNull Document document, @NotNull NodeFormatterContext nodeFormatterContext, @NotNull MarkdownWriter markdownWriter);

    @NotNull
    List<String> getTranslatingTexts();

    void setMergeContext(@NotNull MergeContext mergeContext);

    void setRenderPurpose(@NotNull RenderPurpose renderPurpose);

    void setTranslatedTexts(@NotNull List<? extends CharSequence> list);
}
