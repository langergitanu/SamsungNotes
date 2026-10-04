package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.loader;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0002\u001a\u00020\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/loader/Group;", "", "id", "", "elements", "", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/loader/Element;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getId", "()Ljava/lang/String;", "getElements", "()Ljava/util/List;", "findElementById", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final /* data */ class Group {

    @NotNull
    private final List<Element> elements;

    @NotNull
    private final String id;

    public Group(@NotNull String id, @NotNull List<Element> elements) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(elements, "elements");
        this.id = id;
        this.elements = elements;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Group copy$default(Group group, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = group.id;
        }
        if ((i & 2) != 0) {
            list = group.elements;
        }
        return group.copy(str, list);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final List<Element> component2() {
        return this.elements;
    }

    @NotNull
    public final Group copy(@NotNull String id, @NotNull List<Element> elements) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(elements, "elements");
        return new Group(id, elements);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Group)) {
            return false;
        }
        Group group = (Group) other;
        return Intrinsics.areEqual(this.id, group.id) && Intrinsics.areEqual(this.elements, group.elements);
    }

    @Nullable
    public final Element findElementById(@NotNull String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        for (Element element : this.elements) {
            if (Intrinsics.areEqual(element.getId(), id)) {
                return element;
            }
        }
        return null;
    }

    @NotNull
    public final List<Element> getElements() {
        return this.elements;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    public int hashCode() {
        return this.elements.hashCode() + (this.id.hashCode() * 31);
    }

    @NotNull
    public String toString() {
        return "Group(id=" + this.id + ", elements=" + this.elements + ")";
    }
}
