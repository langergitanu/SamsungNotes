package com.vladsch.flexmark.util.html.p169ui;

import androidx.appcompat.widget.AbstractC0541b;
import com.vladsch.flexmark.util.html.Attribute;
import com.vladsch.flexmark.util.html.AttributeImpl;
import com.vladsch.flexmark.util.html.Attributes;
import com.vladsch.flexmark.util.html.HtmlAppendableBase;
import com.vladsch.flexmark.util.sequence.LineAppendable;
import java.awt.Color;
import java.awt.Font;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.plaf.FontUIResource;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class HtmlBuilder extends HtmlAppendableBase<HtmlBuilder> {
    public static final HashMap<Class, HtmlStyler> stylerMap;

    static {
        HashMap<Class, HtmlStyler> map = new HashMap<>();
        stylerMap = map;
        ColorStyler colorStyler = new ColorStyler();
        map.put(BackgroundColor.class, colorStyler);
        map.put(Color.class, colorStyler);
        map.put(Color.class, colorStyler);
        FontStyler fontStyler = new FontStyler();
        map.put(Font.class, fontStyler);
        map.put(FontUIResource.class, fontStyler);
        map.put(FontStyle.class, new FontStyleStyler());
    }

    public HtmlBuilder() {
        super(0, LineAppendable.F_PASS_THROUGH);
    }

    public static void addColorStylerClass(Class cls) {
        HashMap<Class, HtmlStyler> map = stylerMap;
        map.put(cls, map.get(Color.class));
    }

    public static Attribute getAttribute(Object obj) {
        String style;
        HtmlStyler htmlStyler = getHtmlStyler(obj);
        if (htmlStyler == null || (style = htmlStyler.getStyle(htmlStyler.getStyleable(obj))) == null || style.isEmpty()) {
            return null;
        }
        return AttributeImpl.m13363of("style", style);
    }

    public static HtmlStyler getHtmlStyler(Object obj) {
        HashMap<Class, HtmlStyler> map = stylerMap;
        HtmlStyler htmlStyler = map.get(obj.getClass());
        if (htmlStyler != null) {
            return htmlStyler;
        }
        Iterator<Class> it = map.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Class next = it.next();
            if (next.isAssignableFrom(obj.getClass())) {
                htmlStyler = stylerMap.get(next);
                break;
            }
        }
        if (htmlStyler != null) {
            stylerMap.put(obj.getClass(), htmlStyler);
        }
        return htmlStyler;
    }

    public HtmlBuilder closeAllTags() {
        while (!getOpenTags().isEmpty()) {
            closeTag((CharSequence) getOpenTags().peek());
        }
        return this;
    }

    public HtmlBuilder closeSpan() {
        return closeTag("span");
    }

    public HtmlBuilder span() {
        return tag("span", false);
    }

    public HtmlBuilder spanLine(Runnable runnable) {
        return span(true, runnable);
    }

    public HtmlBuilder style(CharSequence charSequence) {
        super.withAttr();
        return (HtmlBuilder) super.attr("style", charSequence);
    }

    public String toFinalizedString() {
        closeAllTags();
        return toString(0, 0);
    }

    public HtmlBuilder(int i, int i2) {
        super(i, i2);
    }

    public HtmlBuilder span(CharSequence charSequence) {
        tag("span", false);
        text(charSequence);
        return closeSpan();
    }

    public HtmlBuilder span(boolean z, Runnable runnable) {
        return tag("span", false, z, runnable);
    }

    public HtmlBuilder span(Runnable runnable) {
        return span(false, runnable);
    }

    public HtmlBuilder attr(Object... objArr) {
        for (Object obj : objArr) {
            if (obj instanceof Attribute) {
                super.attr((Attribute) obj);
                super.withAttr();
            } else {
                HtmlStyler htmlStyler = getHtmlStyler(obj);
                if (htmlStyler != null) {
                    String style = htmlStyler.getStyle(htmlStyler.getStyleable(obj));
                    if (style != null && !style.isEmpty()) {
                        super.attr(AttributeImpl.m13363of("style", style));
                        super.withAttr();
                    }
                } else {
                    throw new IllegalStateException(AbstractC0541b.m772n("Don't know how to style ", obj.getClass().getName().substring(getClass().getPackage().getName().length() + 1)));
                }
            }
        }
        return this;
    }

    public HtmlBuilder append(Object obj) {
        return (HtmlBuilder) super.append((CharSequence) String.valueOf(obj));
    }

    public HtmlBuilder append(String str) {
        return (HtmlBuilder) super.append((CharSequence) str);
    }

    public HtmlBuilder append(StringBuffer stringBuffer) {
        return (HtmlBuilder) super.append((CharSequence) stringBuffer.toString());
    }

    @Override // com.vladsch.flexmark.util.html.HtmlAppendableBase, com.vladsch.flexmark.util.sequence.LineAppendable, java.lang.Appendable
    @NotNull
    public HtmlBuilder append(@NotNull CharSequence charSequence) {
        return (HtmlBuilder) super.append(charSequence);
    }

    @Override // com.vladsch.flexmark.util.html.HtmlAppendableBase, com.vladsch.flexmark.util.sequence.LineAppendable, java.lang.Appendable
    @NotNull
    public HtmlBuilder append(@NotNull CharSequence charSequence, int i, int i2) {
        return (HtmlBuilder) super.append(charSequence, i, i2);
    }

    public HtmlBuilder append(char[] cArr) {
        return (HtmlBuilder) super.append((CharSequence) String.valueOf(cArr));
    }

    public HtmlBuilder append(char[] cArr, int i, int i2) {
        return (HtmlBuilder) super.append((CharSequence) String.valueOf(cArr, i, i2));
    }

    public HtmlBuilder append(boolean z) {
        return (HtmlBuilder) super.append((CharSequence) (z ? "true" : "false"));
    }

    @Override // com.vladsch.flexmark.util.html.HtmlAppendableBase, com.vladsch.flexmark.util.sequence.LineAppendable, java.lang.Appendable
    @NotNull
    public HtmlBuilder append(char c) {
        return (HtmlBuilder) super.append(c);
    }

    public HtmlBuilder append(int i) {
        return (HtmlBuilder) super.append((CharSequence) String.valueOf(i));
    }

    public HtmlBuilder append(long j) {
        return (HtmlBuilder) super.append((CharSequence) String.valueOf(j));
    }

    public HtmlBuilder append(float f) {
        return (HtmlBuilder) super.append((CharSequence) String.valueOf(f));
    }

    public HtmlBuilder append(double d) {
        return (HtmlBuilder) super.append((CharSequence) String.valueOf(d));
    }

    @Override // com.vladsch.flexmark.util.html.HtmlAppendableBase, com.vladsch.flexmark.util.html.HtmlAppendable
    @NotNull
    public HtmlBuilder attr(@NotNull CharSequence charSequence, @Nullable CharSequence charSequence2) {
        super.withAttr();
        return (HtmlBuilder) super.attr(charSequence, charSequence2);
    }

    @Override // com.vladsch.flexmark.util.html.HtmlAppendableBase, com.vladsch.flexmark.util.html.HtmlAppendable
    @NotNull
    public HtmlBuilder attr(@NotNull Attribute... attributeArr) {
        super.withAttr();
        return (HtmlBuilder) super.attr(attributeArr);
    }

    @Override // com.vladsch.flexmark.util.html.HtmlAppendableBase, com.vladsch.flexmark.util.html.HtmlAppendable
    @NotNull
    public HtmlBuilder attr(@NotNull Attributes attributes) {
        super.withAttr();
        return (HtmlBuilder) super.attr(attributes);
    }
}
