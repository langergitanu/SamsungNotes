package com.vladsch.flexmark.formatter;

import com.vladsch.flexmark.util.ast.BlankLine;
import com.vladsch.flexmark.util.ast.BlockQuoteLike;
import com.vladsch.flexmark.util.ast.Document;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.format.MarkdownWriterBase;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import com.vladsch.flexmark.util.sequence.LineAppendableImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class MarkdownWriter extends MarkdownWriterBase<MarkdownWriter, Node, NodeFormatterContext> {
    public MarkdownWriter() {
        this(null, 0);
    }

    @NotNull
    public MarkdownWriter appendNonTranslating(@NotNull CharSequence charSequence) {
        return appendNonTranslating(null, charSequence, null, null);
    }

    @NotNull
    public MarkdownWriter appendTranslating(@NotNull CharSequence charSequence) {
        return appendTranslating(null, charSequence, null, null);
    }

    @Override // com.vladsch.flexmark.util.format.MarkdownWriterBase
    @NotNull
    public BasedSequence lastBlockQuoteChildPrefix(BasedSequence basedSequence) {
        int iLastIndexOfAny;
        Node currentNode = ((NodeFormatterContext) this.context).getCurrentNode();
        while (currentNode != null && currentNode.getNextAnyNot(BlankLine.class) == null) {
            currentNode = currentNode.getParent();
            if (currentNode == null || (currentNode instanceof Document)) {
                break;
            }
            if ((currentNode instanceof BlockQuoteLike) && (iLastIndexOfAny = basedSequence.lastIndexOfAny(((NodeFormatterContext) this.context).getBlockQuoteLikePrefixPredicate())) >= 0) {
                basedSequence = basedSequence.getBuilder().append((CharSequence) basedSequence.subSequence(0, iLastIndexOfAny)).append(' ').append((CharSequence) basedSequence.subSequence(iLastIndexOfAny + 1)).toSequence();
            }
        }
        return basedSequence;
    }

    public MarkdownWriter(int i) {
        this(null, i);
    }

    @NotNull
    public MarkdownWriter appendNonTranslating(@Nullable CharSequence charSequence, @NotNull CharSequence charSequence2) {
        return appendNonTranslating(charSequence, charSequence2, null, null);
    }

    @NotNull
    public MarkdownWriter appendTranslating(@Nullable CharSequence charSequence, @NotNull CharSequence charSequence2) {
        return appendTranslating(charSequence, charSequence2, null, null);
    }

    @Override // com.vladsch.flexmark.util.sequence.LineAppendable
    @NotNull
    public MarkdownWriter getEmptyAppendable() {
        LineAppendableImpl lineAppendableImpl = this.appendable;
        return new MarkdownWriter(lineAppendableImpl, lineAppendableImpl.getOptions());
    }

    public MarkdownWriter(@Nullable Appendable appendable, int i) {
        super(appendable, i);
    }

    @NotNull
    public MarkdownWriter appendNonTranslating(@Nullable CharSequence charSequence, @NotNull CharSequence charSequence2, @Nullable CharSequence charSequence3) {
        return appendNonTranslating(charSequence, charSequence2, charSequence3, null);
    }

    @NotNull
    public MarkdownWriter appendTranslating(@Nullable CharSequence charSequence, @NotNull CharSequence charSequence2, @Nullable CharSequence charSequence3) {
        return appendTranslating(charSequence, charSequence2, charSequence3, null);
    }

    @NotNull
    public MarkdownWriter appendNonTranslating(@Nullable CharSequence charSequence, @NotNull CharSequence charSequence2, @Nullable CharSequence charSequence3, @Nullable CharSequence charSequence4) {
        if (((NodeFormatterContext) this.context).isTransformingText()) {
            append(((NodeFormatterContext) this.context).transformNonTranslating(charSequence, charSequence2, charSequence3, charSequence4));
            return this;
        }
        append(charSequence2);
        return this;
    }

    @NotNull
    public MarkdownWriter appendTranslating(@Nullable CharSequence charSequence, @NotNull CharSequence charSequence2, @Nullable CharSequence charSequence3, @Nullable CharSequence charSequence4) {
        if (((NodeFormatterContext) this.context).isTransformingText()) {
            append(((NodeFormatterContext) this.context).transformTranslating(charSequence, charSequence2, charSequence3, charSequence4));
            return this;
        }
        if (charSequence != null) {
            append(charSequence);
        }
        append(charSequence2);
        if (charSequence3 != null) {
            append(charSequence3);
        }
        if (charSequence4 != null) {
            append(charSequence4);
        }
        return this;
    }
}
