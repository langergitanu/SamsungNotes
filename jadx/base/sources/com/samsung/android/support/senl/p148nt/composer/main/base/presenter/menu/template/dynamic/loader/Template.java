package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.loader;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0005J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J-\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/loader/Template;", "", "version", "", "thumbnail", "", "pages", "", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/loader/Page;", "<init>", "(ILjava/lang/String;Ljava/util/List;)V", "getVersion", "()I", "getThumbnail", "()Ljava/lang/String;", "getPages", "()Ljava/util/List;", "findElementById", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/loader/Element;", "id", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final /* data */ class Template {

    @NotNull
    private final List<Page> pages;

    @NotNull
    private final String thumbnail;
    private final int version;

    public Template(int i, @NotNull String thumbnail, @NotNull List<Page> pages) {
        Intrinsics.checkNotNullParameter(thumbnail, "thumbnail");
        Intrinsics.checkNotNullParameter(pages, "pages");
        this.version = i;
        this.thumbnail = thumbnail;
        this.pages = pages;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Template copy$default(Template template, int i, String str, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = template.version;
        }
        if ((i2 & 2) != 0) {
            str = template.thumbnail;
        }
        if ((i2 & 4) != 0) {
            list = template.pages;
        }
        return template.copy(i, str, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getVersion() {
        return this.version;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getThumbnail() {
        return this.thumbnail;
    }

    @NotNull
    public final List<Page> component3() {
        return this.pages;
    }

    @NotNull
    public final Template copy(int version, @NotNull String thumbnail, @NotNull List<Page> pages) {
        Intrinsics.checkNotNullParameter(thumbnail, "thumbnail");
        Intrinsics.checkNotNullParameter(pages, "pages");
        return new Template(version, thumbnail, pages);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Template)) {
            return false;
        }
        Template template = (Template) other;
        return this.version == template.version && Intrinsics.areEqual(this.thumbnail, template.thumbnail) && Intrinsics.areEqual(this.pages, template.pages);
    }

    @Nullable
    public final Element findElementById(@NotNull String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        Iterator<Page> it = this.pages.iterator();
        while (it.hasNext()) {
            Element elementFindElementById = it.next().findElementById(id);
            if (elementFindElementById != null) {
                return elementFindElementById;
            }
        }
        return null;
    }

    @NotNull
    public final List<Page> getPages() {
        return this.pages;
    }

    @NotNull
    public final String getThumbnail() {
        return this.thumbnail;
    }

    public final int getVersion() {
        return this.version;
    }

    public int hashCode() {
        return this.pages.hashCode() + AbstractC1038a.m1202c(Integer.hashCode(this.version) * 31, 31, this.thumbnail);
    }

    @NotNull
    public String toString() {
        int i = this.version;
        String str = this.thumbnail;
        return AbstractC0541b.m777s(AbstractC2322a.m1629s("Template(version=", i, ", thumbnail=", str, ", pages="), this.pages, ")");
    }
}
