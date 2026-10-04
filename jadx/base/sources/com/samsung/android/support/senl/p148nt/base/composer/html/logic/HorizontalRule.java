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
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/html/logic/HorizontalRule;", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/HtmlNode;", "classes", "", "", "<init>", "(Ljava/util/List;)V", "getClasses", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final /* data */ class HorizontalRule extends HtmlNode {

    @NotNull
    private final List<String> classes;

    /* JADX WARN: Multi-variable type inference failed */
    public HorizontalRule() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HorizontalRule copy$default(HorizontalRule horizontalRule, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = horizontalRule.classes;
        }
        return horizontalRule.copy(list);
    }

    @NotNull
    public final List<String> component1() {
        return this.classes;
    }

    @NotNull
    public final HorizontalRule copy(@NotNull List<String> classes) {
        Intrinsics.checkNotNullParameter(classes, "classes");
        return new HorizontalRule(classes);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof HorizontalRule) && Intrinsics.areEqual(this.classes, ((HorizontalRule) other).classes);
    }

    @NotNull
    public final List<String> getClasses() {
        return this.classes;
    }

    public int hashCode() {
        return this.classes.hashCode();
    }

    @NotNull
    public String toString() {
        return "HorizontalRule(classes=" + this.classes + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HorizontalRule(@NotNull List<String> classes) {
        super(null);
        Intrinsics.checkNotNullParameter(classes, "classes");
        this.classes = classes;
    }

    public /* synthetic */ HorizontalRule(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list);
    }
}
