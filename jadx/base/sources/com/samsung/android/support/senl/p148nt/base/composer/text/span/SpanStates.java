package com.samsung.android.support.senl.p148nt.base.composer.text.span;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.ccil.cowan.tagsoup.XMLWriter;
import org.jetbrains.annotations.NotNull;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020IJ\u0006\u0010J\u001a\u00020KJ\b\u0010L\u001a\u00020\u0005H\u0016J\b\u0010M\u001a\u00020\u000bH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020)X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020/X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u00104\u001a\u000205X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001a\u0010:\u001a\u00020;X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001a\u0010@\u001a\u00020AX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010E¨\u0006N"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/text/span/SpanStates;", "", "<init>", "()V", "bodyTextFontSize", "Lcom/samsung/android/support/senl/nt/base/composer/text/span/FontSize;", "getBodyTextFontSize", "()Lcom/samsung/android/support/senl/nt/base/composer/text/span/FontSize;", "setBodyTextFontSize", "(Lcom/samsung/android/support/senl/nt/base/composer/text/span/FontSize;)V", "bodyTextAlign", "Lcom/samsung/android/support/senl/nt/base/composer/text/span/Alignment;", "getBodyTextAlign", "()Lcom/samsung/android/support/senl/nt/base/composer/text/span/Alignment;", "setBodyTextAlign", "(Lcom/samsung/android/support/senl/nt/base/composer/text/span/Alignment;)V", "textFormat", "Lcom/samsung/android/support/senl/nt/base/composer/text/span/TextFormat;", "getTextFormat", "()Lcom/samsung/android/support/senl/nt/base/composer/text/span/TextFormat;", "setTextFormat", "(Lcom/samsung/android/support/senl/nt/base/composer/text/span/TextFormat;)V", "fontColor", "Lcom/samsung/android/support/senl/nt/base/composer/text/span/FontColor;", "getFontColor", "()Lcom/samsung/android/support/senl/nt/base/composer/text/span/FontColor;", "setFontColor", "(Lcom/samsung/android/support/senl/nt/base/composer/text/span/FontColor;)V", "fontBgColor", "Lcom/samsung/android/support/senl/nt/base/composer/text/span/FontBgColor;", "getFontBgColor", "()Lcom/samsung/android/support/senl/nt/base/composer/text/span/FontBgColor;", "setFontBgColor", "(Lcom/samsung/android/support/senl/nt/base/composer/text/span/FontBgColor;)V", XMLWriter.INDENT, "Lcom/samsung/android/support/senl/nt/base/composer/text/span/Indent;", "getIndent", "()Lcom/samsung/android/support/senl/nt/base/composer/text/span/Indent;", "setIndent", "(Lcom/samsung/android/support/senl/nt/base/composer/text/span/Indent;)V", "task", "Lcom/samsung/android/support/senl/nt/base/composer/text/span/Task;", "getTask", "()Lcom/samsung/android/support/senl/nt/base/composer/text/span/Task;", "setTask", "(Lcom/samsung/android/support/senl/nt/base/composer/text/span/Task;)V", "bold", "Lcom/samsung/android/support/senl/nt/base/composer/text/span/Bold;", "getBold", "()Lcom/samsung/android/support/senl/nt/base/composer/text/span/Bold;", "setBold", "(Lcom/samsung/android/support/senl/nt/base/composer/text/span/Bold;)V", "italic", "Lcom/samsung/android/support/senl/nt/base/composer/text/span/Italic;", "getItalic", "()Lcom/samsung/android/support/senl/nt/base/composer/text/span/Italic;", "setItalic", "(Lcom/samsung/android/support/senl/nt/base/composer/text/span/Italic;)V", "underline", "Lcom/samsung/android/support/senl/nt/base/composer/text/span/Underline;", "getUnderline", "()Lcom/samsung/android/support/senl/nt/base/composer/text/span/Underline;", "setUnderline", "(Lcom/samsung/android/support/senl/nt/base/composer/text/span/Underline;)V", "strikethrough", "Lcom/samsung/android/support/senl/nt/base/composer/text/span/Strikethrough;", "getStrikethrough", "()Lcom/samsung/android/support/senl/nt/base/composer/text/span/Strikethrough;", "setStrikethrough", "(Lcom/samsung/android/support/senl/nt/base/composer/text/span/Strikethrough;)V", "getShapeStyleSpanState", "Lcom/samsung/android/support/senl/nt/base/composer/text/span/ShapeStyleSpan;", "type", "", "resetToDefault", "", "getFontSize", "getAlign", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class SpanStates {
    public Alignment bodyTextAlign;
    public FontSize bodyTextFontSize;
    public Bold bold;
    public FontBgColor fontBgColor;
    public FontColor fontColor;
    public Indent indent;
    public Italic italic;
    public Strikethrough strikethrough;
    public Task task;
    public TextFormat textFormat;
    public Underline underline;

    @NotNull
    public Alignment getAlign() {
        return getBodyTextAlign();
    }

    @NotNull
    public final Alignment getBodyTextAlign() {
        Alignment alignment = this.bodyTextAlign;
        if (alignment != null) {
            return alignment;
        }
        Intrinsics.throwUninitializedPropertyAccessException("bodyTextAlign");
        return null;
    }

    @NotNull
    public final FontSize getBodyTextFontSize() {
        FontSize fontSize = this.bodyTextFontSize;
        if (fontSize != null) {
            return fontSize;
        }
        Intrinsics.throwUninitializedPropertyAccessException("bodyTextFontSize");
        return null;
    }

    @NotNull
    public final Bold getBold() {
        Bold bold = this.bold;
        if (bold != null) {
            return bold;
        }
        Intrinsics.throwUninitializedPropertyAccessException("bold");
        return null;
    }

    @NotNull
    public final FontBgColor getFontBgColor() {
        FontBgColor fontBgColor = this.fontBgColor;
        if (fontBgColor != null) {
            return fontBgColor;
        }
        Intrinsics.throwUninitializedPropertyAccessException("fontBgColor");
        return null;
    }

    @NotNull
    public final FontColor getFontColor() {
        FontColor fontColor = this.fontColor;
        if (fontColor != null) {
            return fontColor;
        }
        Intrinsics.throwUninitializedPropertyAccessException("fontColor");
        return null;
    }

    @NotNull
    public FontSize getFontSize() {
        return getBodyTextFontSize();
    }

    @NotNull
    public final Indent getIndent() {
        Indent indent = this.indent;
        if (indent != null) {
            return indent;
        }
        Intrinsics.throwUninitializedPropertyAccessException(XMLWriter.INDENT);
        return null;
    }

    @NotNull
    public final Italic getItalic() {
        Italic italic = this.italic;
        if (italic != null) {
            return italic;
        }
        Intrinsics.throwUninitializedPropertyAccessException("italic");
        return null;
    }

    @NotNull
    public final ShapeStyleSpan getShapeStyleSpanState(int type) {
        if (type == 5) {
            return getBold();
        }
        if (type == 6) {
            return getItalic();
        }
        if (type == 7) {
            return getUnderline();
        }
        if (type == 20) {
            return getStrikethrough();
        }
        throw new IllegalStateException(AbstractC0000a.m11h(type, "Unexpected value: "));
    }

    @NotNull
    public final Strikethrough getStrikethrough() {
        Strikethrough strikethrough = this.strikethrough;
        if (strikethrough != null) {
            return strikethrough;
        }
        Intrinsics.throwUninitializedPropertyAccessException("strikethrough");
        return null;
    }

    @NotNull
    public final Task getTask() {
        Task task = this.task;
        if (task != null) {
            return task;
        }
        Intrinsics.throwUninitializedPropertyAccessException("task");
        return null;
    }

    @NotNull
    public final TextFormat getTextFormat() {
        TextFormat textFormat = this.textFormat;
        if (textFormat != null) {
            return textFormat;
        }
        Intrinsics.throwUninitializedPropertyAccessException("textFormat");
        return null;
    }

    @NotNull
    public final Underline getUnderline() {
        Underline underline = this.underline;
        if (underline != null) {
            return underline;
        }
        Intrinsics.throwUninitializedPropertyAccessException("underline");
        return null;
    }

    public final void resetToDefault() {
        getFontSize().reset();
        getFontColor().reset();
        getFontBgColor().reset();
        getBodyTextAlign().reset();
        getTextFormat().reset();
        getUnderline().reset();
        getStrikethrough().reset();
        getItalic().reset();
        getBold().reset();
        getIndent().reset();
    }

    public final void setBodyTextAlign(@NotNull Alignment alignment) {
        Intrinsics.checkNotNullParameter(alignment, "<set-?>");
        this.bodyTextAlign = alignment;
    }

    public final void setBodyTextFontSize(@NotNull FontSize fontSize) {
        Intrinsics.checkNotNullParameter(fontSize, "<set-?>");
        this.bodyTextFontSize = fontSize;
    }

    public final void setBold(@NotNull Bold bold) {
        Intrinsics.checkNotNullParameter(bold, "<set-?>");
        this.bold = bold;
    }

    public final void setFontBgColor(@NotNull FontBgColor fontBgColor) {
        Intrinsics.checkNotNullParameter(fontBgColor, "<set-?>");
        this.fontBgColor = fontBgColor;
    }

    public final void setFontColor(@NotNull FontColor fontColor) {
        Intrinsics.checkNotNullParameter(fontColor, "<set-?>");
        this.fontColor = fontColor;
    }

    public final void setIndent(@NotNull Indent indent) {
        Intrinsics.checkNotNullParameter(indent, "<set-?>");
        this.indent = indent;
    }

    public final void setItalic(@NotNull Italic italic) {
        Intrinsics.checkNotNullParameter(italic, "<set-?>");
        this.italic = italic;
    }

    public final void setStrikethrough(@NotNull Strikethrough strikethrough) {
        Intrinsics.checkNotNullParameter(strikethrough, "<set-?>");
        this.strikethrough = strikethrough;
    }

    public final void setTask(@NotNull Task task) {
        Intrinsics.checkNotNullParameter(task, "<set-?>");
        this.task = task;
    }

    public final void setTextFormat(@NotNull TextFormat textFormat) {
        Intrinsics.checkNotNullParameter(textFormat, "<set-?>");
        this.textFormat = textFormat;
    }

    public final void setUnderline(@NotNull Underline underline) {
        Intrinsics.checkNotNullParameter(underline, "<set-?>");
        this.underline = underline;
    }
}
