package com.samsung.android.support.senl.p148nt.base.composer.html.logic;

import androidx.appcompat.widget.AbstractC0541b;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/html/logic/Image;", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/HtmlNode;", "src", "", "alt", "classes", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getSrc", "()Ljava/lang/String;", "getAlt", "getClasses", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final /* data */ class Image extends HtmlNode {

    @Nullable
    private final String alt;

    @NotNull
    private final List<String> classes;

    @Nullable
    private final String src;

    public Image() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Image copy$default(Image image, String str, String str2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = image.src;
        }
        if ((i & 2) != 0) {
            str2 = image.alt;
        }
        if ((i & 4) != 0) {
            list = image.classes;
        }
        return image.copy(str, str2, list);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSrc() {
        return this.src;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAlt() {
        return this.alt;
    }

    @NotNull
    public final List<String> component3() {
        return this.classes;
    }

    @NotNull
    public final Image copy(@Nullable String src, @Nullable String alt, @NotNull List<String> classes) {
        Intrinsics.checkNotNullParameter(classes, "classes");
        return new Image(src, alt, classes);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Image)) {
            return false;
        }
        Image image = (Image) other;
        return Intrinsics.areEqual(this.src, image.src) && Intrinsics.areEqual(this.alt, image.alt) && Intrinsics.areEqual(this.classes, image.classes);
    }

    @Nullable
    public final String getAlt() {
        return this.alt;
    }

    @NotNull
    public final List<String> getClasses() {
        return this.classes;
    }

    @Nullable
    public final String getSrc() {
        return this.src;
    }

    public int hashCode() {
        String str = this.src;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.alt;
        return this.classes.hashCode() + ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31);
    }

    @NotNull
    public String toString() {
        String str = this.src;
        String str2 = this.alt;
        return AbstractC0541b.m777s(AbstractC0000a.m16m("Image(src=", str, ", alt=", str2, ", classes="), this.classes, ")");
    }

    public /* synthetic */ Image(String str, String str2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? CollectionsKt.emptyList() : list);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Image(@Nullable String str, @Nullable String str2, @NotNull List<String> classes) {
        super(null);
        Intrinsics.checkNotNullParameter(classes, "classes");
        this.src = str;
        this.alt = str2;
        this.classes = classes;
    }
}
