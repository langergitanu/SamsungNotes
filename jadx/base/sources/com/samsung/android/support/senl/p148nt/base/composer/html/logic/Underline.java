package com.samsung.android.support.senl.p148nt.base.composer.html.logic;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/html/logic/Underline;", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/HtmlNode;", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/ParentCapableNode;", "children", "", "<init>", "(Ljava/util/List;)V", "getChildren", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final /* data */ class Underline extends HtmlNode implements ParentCapableNode {

    @NotNull
    private final List<HtmlNode> children;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public Underline(@NotNull List<? extends HtmlNode> children) {
        super(null);
        Intrinsics.checkNotNullParameter(children, "children");
        this.children = children;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Underline copy$default(Underline underline, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = underline.children;
        }
        return underline.copy(list);
    }

    @NotNull
    public final List<HtmlNode> component1() {
        return this.children;
    }

    @NotNull
    public final Underline copy(@NotNull List<? extends HtmlNode> children) {
        Intrinsics.checkNotNullParameter(children, "children");
        return new Underline(children);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof Underline) && Intrinsics.areEqual(this.children, ((Underline) other).children);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.html.logic.ParentCapableNode
    @NotNull
    public List<HtmlNode> getChildren() {
        return this.children;
    }

    public int hashCode() {
        return this.children.hashCode();
    }

    @NotNull
    public String toString() {
        return "Underline(children=" + this.children + ")";
    }
}
