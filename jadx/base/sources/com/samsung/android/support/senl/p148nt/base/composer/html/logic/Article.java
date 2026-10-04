package com.samsung.android.support.senl.p148nt.base.composer.html.logic;

import androidx.collection.AbstractC0622a;
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
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003BW\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007HÆ\u0003JY\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0016\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0016\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011¨\u0006$"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/html/logic/Article;", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/HtmlNode;", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/StyledNode;", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/ParentCapableNode;", "id", "", "classes", "", "textColor", "backgroundColor", "textAlign", "children", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getId", "()Ljava/lang/String;", "getClasses", "()Ljava/util/List;", "getTextColor", "getBackgroundColor", "getTextAlign", "getChildren", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final /* data */ class Article extends HtmlNode implements StyledNode, ParentCapableNode {

    @Nullable
    private final String backgroundColor;

    @NotNull
    private final List<HtmlNode> children;

    @NotNull
    private final List<String> classes;

    @Nullable
    private final String id;

    @Nullable
    private final String textAlign;

    @Nullable
    private final String textColor;

    public Article() {
        this(null, null, null, null, null, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Article copy$default(Article article, String str, List list, String str2, String str3, String str4, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = article.id;
        }
        if ((i & 2) != 0) {
            list = article.classes;
        }
        if ((i & 4) != 0) {
            str2 = article.textColor;
        }
        if ((i & 8) != 0) {
            str3 = article.backgroundColor;
        }
        if ((i & 16) != 0) {
            str4 = article.textAlign;
        }
        if ((i & 32) != 0) {
            list2 = article.children;
        }
        String str5 = str4;
        List list3 = list2;
        return article.copy(str, list, str2, str3, str5, list3);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final List<String> component2() {
        return this.classes;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTextColor() {
        return this.textColor;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getTextAlign() {
        return this.textAlign;
    }

    @NotNull
    public final List<HtmlNode> component6() {
        return this.children;
    }

    @NotNull
    public final Article copy(@Nullable String id, @NotNull List<String> classes, @Nullable String textColor, @Nullable String backgroundColor, @Nullable String textAlign, @NotNull List<? extends HtmlNode> children) {
        Intrinsics.checkNotNullParameter(classes, "classes");
        Intrinsics.checkNotNullParameter(children, "children");
        return new Article(id, classes, textColor, backgroundColor, textAlign, children);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Article)) {
            return false;
        }
        Article article = (Article) other;
        return Intrinsics.areEqual(this.id, article.id) && Intrinsics.areEqual(this.classes, article.classes) && Intrinsics.areEqual(this.textColor, article.textColor) && Intrinsics.areEqual(this.backgroundColor, article.backgroundColor) && Intrinsics.areEqual(this.textAlign, article.textAlign) && Intrinsics.areEqual(this.children, article.children);
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

    @Nullable
    public final String getId() {
        return this.id;
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
        String str = this.id;
        int iM1159e = AbstractC0622a.m1159e(this.classes, (str == null ? 0 : str.hashCode()) * 31, 31);
        String str2 = this.textColor;
        int iHashCode = (iM1159e + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.backgroundColor;
        int iHashCode2 = (iHashCode + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.textAlign;
        return this.children.hashCode() + ((iHashCode2 + (str4 != null ? str4.hashCode() : 0)) * 31);
    }

    @NotNull
    public String toString() {
        String str = this.id;
        List<String> list = this.classes;
        String str2 = this.textColor;
        String str3 = this.backgroundColor;
        String str4 = this.textAlign;
        List<HtmlNode> list2 = this.children;
        StringBuilder sb = new StringBuilder("Article(id=");
        sb.append(str);
        sb.append(", classes=");
        sb.append(list);
        sb.append(", textColor=");
        AbstractC2821a.m2207B(sb, str2, ", backgroundColor=", str3, ", textAlign=");
        sb.append(str4);
        sb.append(", children=");
        sb.append(list2);
        sb.append(")");
        return sb.toString();
    }

    public /* synthetic */ Article(String str, List list, String str2, String str3, String str4, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? CollectionsKt.emptyList() : list, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? CollectionsKt.emptyList() : list2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public Article(@Nullable String str, @NotNull List<String> classes, @Nullable String str2, @Nullable String str3, @Nullable String str4, @NotNull List<? extends HtmlNode> children) {
        super(null);
        Intrinsics.checkNotNullParameter(classes, "classes");
        Intrinsics.checkNotNullParameter(children, "children");
        this.id = str;
        this.classes = classes;
        this.textColor = str2;
        this.backgroundColor = str3;
        this.textAlign = str4;
        this.children = children;
    }
}
