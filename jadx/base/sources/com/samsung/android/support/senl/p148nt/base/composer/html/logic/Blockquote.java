package com.samsung.android.support.senl.p148nt.base.composer.html.logic;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004HÆ\u0003J)\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/html/logic/Blockquote;", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/HtmlNode;", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/ParentCapableNode;", "classes", "", "", "children", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getClasses", "()Ljava/util/List;", "getChildren", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final /* data */ class Blockquote extends HtmlNode implements ParentCapableNode {

    @NotNull
    private final List<HtmlNode> children;

    @NotNull
    private final List<String> classes;

    /* JADX WARN: Multi-variable type inference failed */
    public Blockquote() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Blockquote copy$default(Blockquote blockquote, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = blockquote.classes;
        }
        if ((i & 2) != 0) {
            list2 = blockquote.children;
        }
        return blockquote.copy(list, list2);
    }

    @NotNull
    public final List<String> component1() {
        return this.classes;
    }

    @NotNull
    public final List<HtmlNode> component2() {
        return this.children;
    }

    @NotNull
    public final Blockquote copy(@NotNull List<String> classes, @NotNull List<? extends HtmlNode> children) {
        Intrinsics.checkNotNullParameter(classes, "classes");
        Intrinsics.checkNotNullParameter(children, "children");
        return new Blockquote(classes, children);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Blockquote)) {
            return false;
        }
        Blockquote blockquote = (Blockquote) other;
        return Intrinsics.areEqual(this.classes, blockquote.classes) && Intrinsics.areEqual(this.children, blockquote.children);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.html.logic.ParentCapableNode
    @NotNull
    public List<HtmlNode> getChildren() {
        return this.children;
    }

    @NotNull
    public final List<String> getClasses() {
        return this.classes;
    }

    public int hashCode() {
        return this.children.hashCode() + (this.classes.hashCode() * 31);
    }

    @NotNull
    public String toString() {
        return "Blockquote(classes=" + this.classes + ", children=" + this.children + ")";
    }

    public /* synthetic */ Blockquote(List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? CollectionsKt.emptyList() : list2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public Blockquote(@NotNull List<String> classes, @NotNull List<? extends HtmlNode> children) {
        super(null);
        Intrinsics.checkNotNullParameter(classes, "classes");
        Intrinsics.checkNotNullParameter(children, "children");
        this.classes = classes;
        this.children = children;
    }
}
