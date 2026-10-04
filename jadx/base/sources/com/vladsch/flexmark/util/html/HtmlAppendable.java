package com.vladsch.flexmark.util.html;

import com.vladsch.flexmark.util.sequence.LineAppendable;
import java.util.List;
import java.util.Stack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface HtmlAppendable extends LineAppendable {
    @NotNull
    HtmlAppendable attr(@NotNull Attributes attributes);

    @NotNull
    HtmlAppendable attr(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2);

    @NotNull
    HtmlAppendable attr(@NotNull Attribute... attributeArr);

    @NotNull
    HtmlAppendable closePre();

    @NotNull
    HtmlAppendable closeTag(@NotNull CharSequence charSequence);

    @Nullable
    Attributes getAttributes();

    @NotNull
    Stack<String> getOpenTags();

    @NotNull
    List<String> getOpenTagsAfterLast(@NotNull CharSequence charSequence);

    boolean inPre();

    @NotNull
    HtmlAppendable openPre();

    @NotNull
    HtmlAppendable raw(@NotNull CharSequence charSequence);

    @NotNull
    HtmlAppendable raw(@NotNull CharSequence charSequence, int i);

    @NotNull
    HtmlAppendable rawIndentedPre(@NotNull CharSequence charSequence);

    @NotNull
    HtmlAppendable rawPre(@NotNull CharSequence charSequence);

    @NotNull
    HtmlAppendable setAttributes(@NotNull Attributes attributes);

    @NotNull
    HtmlAppendable tag(@NotNull CharSequence charSequence);

    @NotNull
    HtmlAppendable tag(@NotNull CharSequence charSequence, @NotNull Runnable runnable);

    @NotNull
    HtmlAppendable tag(@NotNull CharSequence charSequence, boolean z);

    @NotNull
    HtmlAppendable tag(@NotNull CharSequence charSequence, boolean z, boolean z2, @NotNull Runnable runnable);

    @NotNull
    HtmlAppendable tagIndent(@NotNull CharSequence charSequence, @NotNull Runnable runnable);

    @NotNull
    HtmlAppendable tagLine(@NotNull CharSequence charSequence);

    @NotNull
    HtmlAppendable tagLine(@NotNull CharSequence charSequence, @NotNull Runnable runnable);

    @NotNull
    HtmlAppendable tagLine(@NotNull CharSequence charSequence, boolean z);

    @NotNull
    HtmlAppendable tagLineIndent(@NotNull CharSequence charSequence, @NotNull Runnable runnable);

    @NotNull
    HtmlAppendable tagVoid(@NotNull CharSequence charSequence);

    @NotNull
    HtmlAppendable tagVoidLine(@NotNull CharSequence charSequence);

    @NotNull
    HtmlAppendable text(@NotNull CharSequence charSequence);

    @NotNull
    HtmlAppendable withAttr();

    @NotNull
    HtmlAppendable withCondIndent();

    @NotNull
    HtmlAppendable withCondLineOnChildText();
}
