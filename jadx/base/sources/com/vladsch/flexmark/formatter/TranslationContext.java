package com.vladsch.flexmark.formatter;

import com.vladsch.flexmark.html.renderer.HtmlIdGenerator;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.MutableDataHolder;
import java.util.function.Function;
import java.util.function.Supplier;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface TranslationContext {
    void customPlaceholderFormat(@NotNull TranslationPlaceholderGenerator translationPlaceholderGenerator, @NotNull TranslatingSpanRender translatingSpanRender);

    @Nullable
    HtmlIdGenerator getIdGenerator();

    @Nullable
    MergeContext getMergeContext();

    @NotNull
    RenderPurpose getRenderPurpose();

    @NotNull
    MutableDataHolder getTranslationStore();

    boolean isPostProcessingNonTranslating();

    boolean isTransformingText();

    void nonTranslatingSpan(@NotNull TranslatingSpanRender translatingSpanRender);

    @NotNull
    <T> T postProcessNonTranslating(@NotNull Function<String, CharSequence> function, @NotNull Supplier<T> supplier);

    void postProcessNonTranslating(@NotNull Function<String, CharSequence> function, @NotNull Runnable runnable);

    @NotNull
    CharSequence transformAnchorRef(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2);

    @NotNull
    CharSequence transformNonTranslating(@Nullable CharSequence charSequence, @NotNull CharSequence charSequence2, @Nullable CharSequence charSequence3, @Nullable CharSequence charSequence4);

    @NotNull
    CharSequence transformTranslating(@Nullable CharSequence charSequence, @NotNull CharSequence charSequence2, @Nullable CharSequence charSequence3, @Nullable CharSequence charSequence4);

    void translatingRefTargetSpan(@Nullable Node node, @NotNull TranslatingSpanRender translatingSpanRender);

    void translatingSpan(@NotNull TranslatingSpanRender translatingSpanRender);
}
