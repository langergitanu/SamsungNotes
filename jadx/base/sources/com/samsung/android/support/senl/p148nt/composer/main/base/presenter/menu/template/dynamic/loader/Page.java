package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.loader;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.runtime.AbstractC1974b;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0002\u001a\u00020\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003JA\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0005HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\""}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/loader/Page;", "", "id", "", "width", "", "height", "background", "groups", "", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/loader/Group;", "<init>", "(Ljava/lang/String;IILjava/lang/String;Ljava/util/List;)V", "getId", "()Ljava/lang/String;", "getWidth", "()I", "getHeight", "getBackground", "getGroups", "()Ljava/util/List;", "findElementById", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/loader/Element;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final /* data */ class Page {

    @NotNull
    private final String background;

    @NotNull
    private final List<Group> groups;
    private final int height;

    @NotNull
    private final String id;
    private final int width;

    public Page(@NotNull String id, int i, int i2, @NotNull String background, @NotNull List<Group> groups) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(background, "background");
        Intrinsics.checkNotNullParameter(groups, "groups");
        this.id = id;
        this.width = i;
        this.height = i2;
        this.background = background;
        this.groups = groups;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Page copy$default(Page page, String str, int i, int i2, String str2, List list, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = page.id;
        }
        if ((i4 & 2) != 0) {
            i = page.width;
        }
        if ((i4 & 4) != 0) {
            i2 = page.height;
        }
        if ((i4 & 8) != 0) {
            str2 = page.background;
        }
        if ((i4 & 16) != 0) {
            list = page.groups;
        }
        List list2 = list;
        int i5 = i2;
        return page.copy(str, i, i5, str2, list2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getBackground() {
        return this.background;
    }

    @NotNull
    public final List<Group> component5() {
        return this.groups;
    }

    @NotNull
    public final Page copy(@NotNull String id, int width, int height, @NotNull String background, @NotNull List<Group> groups) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(background, "background");
        Intrinsics.checkNotNullParameter(groups, "groups");
        return new Page(id, width, height, background, groups);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Page)) {
            return false;
        }
        Page page = (Page) other;
        return Intrinsics.areEqual(this.id, page.id) && this.width == page.width && this.height == page.height && Intrinsics.areEqual(this.background, page.background) && Intrinsics.areEqual(this.groups, page.groups);
    }

    @Nullable
    public final Element findElementById(@NotNull String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        Iterator<Group> it = this.groups.iterator();
        while (it.hasNext()) {
            Element elementFindElementById = it.next().findElementById(id);
            if (elementFindElementById != null) {
                return elementFindElementById;
            }
        }
        return null;
    }

    @NotNull
    public final String getBackground() {
        return this.background;
    }

    @NotNull
    public final List<Group> getGroups() {
        return this.groups;
    }

    public final int getHeight() {
        return this.height;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return this.groups.hashCode() + AbstractC1038a.m1202c(AbstractC0622a.m1157c(this.height, AbstractC0622a.m1157c(this.width, this.id.hashCode() * 31, 31), 31), 31, this.background);
    }

    @NotNull
    public String toString() {
        String str = this.id;
        int i = this.width;
        int i2 = this.height;
        String str2 = this.background;
        List<Group> list = this.groups;
        StringBuilder sbM780v = AbstractC0541b.m780v("Page(id=", i, str, ", width=", ", height=");
        AbstractC1974b.m1331x(sbM780v, i2, ", background=", str2, ", groups=");
        return AbstractC0541b.m777s(sbM780v, list, ")");
    }
}
