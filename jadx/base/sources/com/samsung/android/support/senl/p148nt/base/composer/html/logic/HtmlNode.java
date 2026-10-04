package com.samsung.android.support.senl.p148nt.base.composer.html.logic;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0000X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u0082\u0001 \t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'(¨\u0006)"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/html/logic/HtmlNode;", "", "<init>", "()V", "parent", "getParent", "()Lcom/samsung/android/support/senl/nt/base/composer/html/logic/HtmlNode;", "setParent", "(Lcom/samsung/android/support/senl/nt/base/composer/html/logic/HtmlNode;)V", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/Anchor;", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/Article;", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/Blockquote;", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/Bold;", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/Checkbox;", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/Code;", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/CodeBlock;", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/Div;", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/Heading;", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/HorizontalRule;", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/Image;", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/Italic;", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/Label;", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/LineBreak;", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/ListItem;", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/OrderedList;", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/Paragraph;", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/Pre;", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/Span;", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/StrikeThrough;", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/Subscript;", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/Superscript;", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/Table;", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/TableBody;", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/TableCell;", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/TableFoot;", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/TableHead;", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/TableHeaderCell;", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/TableRow;", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/TextNode;", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/Underline;", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/UnorderedList;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class HtmlNode {

    @Nullable
    private HtmlNode parent;

    public /* synthetic */ HtmlNode(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Nullable
    public final HtmlNode getParent() {
        return this.parent;
    }

    public final void setParent(@Nullable HtmlNode htmlNode) {
        this.parent = htmlNode;
    }

    private HtmlNode() {
    }
}
