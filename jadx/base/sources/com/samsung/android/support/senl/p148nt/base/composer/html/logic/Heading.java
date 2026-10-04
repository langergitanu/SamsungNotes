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
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003BS\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007HÆ\u0003JW\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u0005HÖ\u0001J\t\u0010$\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\t\u001a\u0004\u0018\u00010\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\n\u001a\u0004\u0018\u00010\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012¨\u0006%"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/html/logic/Heading;", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/HtmlNode;", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/StyledNode;", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/ParentCapableNode;", "level", "", "classes", "", "", "textColor", "backgroundColor", "textAlign", "children", "<init>", "(ILjava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getLevel", "()I", "getClasses", "()Ljava/util/List;", "getTextColor", "()Ljava/lang/String;", "getBackgroundColor", "getTextAlign", "getChildren", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "toString", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final /* data */ class Heading extends HtmlNode implements StyledNode, ParentCapableNode {

    @Nullable
    private final String backgroundColor;

    @NotNull
    private final List<HtmlNode> children;

    @NotNull
    private final List<String> classes;
    private final int level;

    @Nullable
    private final String textAlign;

    @Nullable
    private final String textColor;

    public /* synthetic */ Heading(int i, List list, String str, String str2, String str3, List list2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? CollectionsKt.emptyList() : list, (i2 & 4) != 0 ? null : str, (i2 & 8) != 0 ? null : str2, (i2 & 16) != 0 ? null : str3, (i2 & 32) != 0 ? CollectionsKt.emptyList() : list2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Heading copy$default(Heading heading, int i, List list, String str, String str2, String str3, List list2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = heading.level;
        }
        if ((i2 & 2) != 0) {
            list = heading.classes;
        }
        if ((i2 & 4) != 0) {
            str = heading.textColor;
        }
        if ((i2 & 8) != 0) {
            str2 = heading.backgroundColor;
        }
        if ((i2 & 16) != 0) {
            str3 = heading.textAlign;
        }
        if ((i2 & 32) != 0) {
            list2 = heading.children;
        }
        String str4 = str3;
        List list3 = list2;
        return heading.copy(i, list, str, str2, str4, list3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getLevel() {
        return this.level;
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
    public final Heading copy(int level, @NotNull List<String> classes, @Nullable String textColor, @Nullable String backgroundColor, @Nullable String textAlign, @NotNull List<? extends HtmlNode> children) {
        Intrinsics.checkNotNullParameter(classes, "classes");
        Intrinsics.checkNotNullParameter(children, "children");
        return new Heading(level, classes, textColor, backgroundColor, textAlign, children);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Heading)) {
            return false;
        }
        Heading heading = (Heading) other;
        return this.level == heading.level && Intrinsics.areEqual(this.classes, heading.classes) && Intrinsics.areEqual(this.textColor, heading.textColor) && Intrinsics.areEqual(this.backgroundColor, heading.backgroundColor) && Intrinsics.areEqual(this.textAlign, heading.textAlign) && Intrinsics.areEqual(this.children, heading.children);
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

    public final int getLevel() {
        return this.level;
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
        int iM1159e = AbstractC0622a.m1159e(this.classes, Integer.hashCode(this.level) * 31, 31);
        String str = this.textColor;
        int iHashCode = (iM1159e + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.backgroundColor;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.textAlign;
        return this.children.hashCode() + ((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31);
    }

    @NotNull
    public String toString() {
        int i = this.level;
        List<String> list = this.classes;
        String str = this.textColor;
        String str2 = this.backgroundColor;
        String str3 = this.textAlign;
        List<HtmlNode> list2 = this.children;
        StringBuilder sb = new StringBuilder("Heading(level=");
        sb.append(i);
        sb.append(", classes=");
        sb.append(list);
        sb.append(", textColor=");
        AbstractC2821a.m2207B(sb, str, ", backgroundColor=", str2, ", textAlign=");
        sb.append(str3);
        sb.append(", children=");
        sb.append(list2);
        sb.append(")");
        return sb.toString();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public Heading(int i, @NotNull List<String> classes, @Nullable String str, @Nullable String str2, @Nullable String str3, @NotNull List<? extends HtmlNode> children) {
        super(null);
        Intrinsics.checkNotNullParameter(classes, "classes");
        Intrinsics.checkNotNullParameter(children, "children");
        this.level = i;
        this.classes = classes;
        this.textColor = str;
        this.backgroundColor = str2;
        this.textAlign = str3;
        this.children = children;
    }
}
