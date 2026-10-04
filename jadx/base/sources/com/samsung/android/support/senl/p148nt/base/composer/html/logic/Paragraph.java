package com.samsung.android.support.senl.p148nt.base.composer.html.logic;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.glance.AbstractC2821a;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003BK\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005HÆ\u0003JM\u0010\u0019\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0006HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\b\u001a\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0016\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000e¨\u0006!"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/html/logic/Paragraph;", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/HtmlNode;", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/StyledNode;", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/ParentCapableNode;", "classes", "", "", "textColor", "backgroundColor", "textAlign", "children", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getClasses", "()Ljava/util/List;", "getTextColor", "()Ljava/lang/String;", "getBackgroundColor", "getTextAlign", "getChildren", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final /* data */ class Paragraph extends HtmlNode implements StyledNode, ParentCapableNode {

    @Nullable
    private final String backgroundColor;

    @NotNull
    private final List<HtmlNode> children;

    @NotNull
    private final List<String> classes;

    @Nullable
    private final String textAlign;

    @Nullable
    private final String textColor;

    public Paragraph() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Paragraph copy$default(Paragraph paragraph, List list, String str, String str2, String str3, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = paragraph.classes;
        }
        if ((i & 2) != 0) {
            str = paragraph.textColor;
        }
        if ((i & 4) != 0) {
            str2 = paragraph.backgroundColor;
        }
        if ((i & 8) != 0) {
            str3 = paragraph.textAlign;
        }
        if ((i & 16) != 0) {
            list2 = paragraph.children;
        }
        List list3 = list2;
        String str4 = str2;
        return paragraph.copy(list, str, str4, str3, list3);
    }

    @NotNull
    public final List<String> component1() {
        return this.classes;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTextColor() {
        return this.textColor;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getTextAlign() {
        return this.textAlign;
    }

    @NotNull
    public final List<HtmlNode> component5() {
        return this.children;
    }

    @NotNull
    public final Paragraph copy(@NotNull List<String> classes, @Nullable String textColor, @Nullable String backgroundColor, @Nullable String textAlign, @NotNull List<? extends HtmlNode> children) {
        Intrinsics.checkNotNullParameter(classes, "classes");
        Intrinsics.checkNotNullParameter(children, "children");
        return new Paragraph(classes, textColor, backgroundColor, textAlign, children);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Paragraph)) {
            return false;
        }
        Paragraph paragraph = (Paragraph) other;
        return Intrinsics.areEqual(this.classes, paragraph.classes) && Intrinsics.areEqual(this.textColor, paragraph.textColor) && Intrinsics.areEqual(this.backgroundColor, paragraph.backgroundColor) && Intrinsics.areEqual(this.textAlign, paragraph.textAlign) && Intrinsics.areEqual(this.children, paragraph.children);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.html.logic.StyledNode
    @Nullable
    public String getBackgroundColor() {
        return this.backgroundColor;
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

    @Override // com.samsung.android.support.senl.p148nt.base.composer.html.logic.StyledNode
    @Nullable
    public String getTextAlign() {
        return this.textAlign;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.html.logic.StyledNode
    @Nullable
    public String getTextColor() {
        return this.textColor;
    }

    public int hashCode() {
        int iHashCode = this.classes.hashCode() * 31;
        String str = this.textColor;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.backgroundColor;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.textAlign;
        return this.children.hashCode() + ((iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31);
    }

    @NotNull
    public String toString() {
        List<String> list = this.classes;
        String str = this.textColor;
        String str2 = this.backgroundColor;
        String str3 = this.textAlign;
        List<HtmlNode> list2 = this.children;
        StringBuilder sb = new StringBuilder("Paragraph(classes=");
        sb.append(list);
        sb.append(", textColor=");
        sb.append(str);
        sb.append(", backgroundColor=");
        AbstractC2821a.m2207B(sb, str2, ", textAlign=", str3, ", children=");
        return AbstractC0541b.m777s(sb, list2, ")");
    }

    public /* synthetic */ Paragraph(List list, String str, String str2, String str3, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? CollectionsKt.emptyList() : list2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public Paragraph(@NotNull List<String> classes, @Nullable String str, @Nullable String str2, @Nullable String str3, @NotNull List<? extends HtmlNode> children) {
        super(null);
        Intrinsics.checkNotNullParameter(classes, "classes");
        Intrinsics.checkNotNullParameter(children, "children");
        this.classes = classes;
        this.textColor = str;
        this.backgroundColor = str2;
        this.textAlign = str3;
        this.children = children;
    }
}
