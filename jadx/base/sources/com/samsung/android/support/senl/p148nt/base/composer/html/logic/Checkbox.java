package com.samsung.android.support.senl.p148nt.base.composer.html.logic;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.glance.AbstractC2821a;
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
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\tHÆ\u0003JE\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u000fR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/html/logic/Checkbox;", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/HtmlNode;", "name", "", "value", "isChecked", "", "isDisabled", "classes", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZZLjava/util/List;)V", "getName", "()Ljava/lang/String;", "getValue", "()Z", "getClasses", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", "toString", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final /* data */ class Checkbox extends HtmlNode {

    @NotNull
    private final List<String> classes;
    private final boolean isChecked;
    private final boolean isDisabled;

    @Nullable
    private final String name;

    @Nullable
    private final String value;

    public Checkbox() {
        this(null, null, false, false, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Checkbox copy$default(Checkbox checkbox, String str, String str2, boolean z, boolean z2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = checkbox.name;
        }
        if ((i & 2) != 0) {
            str2 = checkbox.value;
        }
        if ((i & 4) != 0) {
            z = checkbox.isChecked;
        }
        if ((i & 8) != 0) {
            z2 = checkbox.isDisabled;
        }
        if ((i & 16) != 0) {
            list = checkbox.classes;
        }
        List list2 = list;
        boolean z3 = z;
        return checkbox.copy(str, str2, z3, z2, list2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsChecked() {
        return this.isChecked;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsDisabled() {
        return this.isDisabled;
    }

    @NotNull
    public final List<String> component5() {
        return this.classes;
    }

    @NotNull
    public final Checkbox copy(@Nullable String name, @Nullable String value, boolean isChecked, boolean isDisabled, @NotNull List<String> classes) {
        Intrinsics.checkNotNullParameter(classes, "classes");
        return new Checkbox(name, value, isChecked, isDisabled, classes);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Checkbox)) {
            return false;
        }
        Checkbox checkbox = (Checkbox) other;
        return Intrinsics.areEqual(this.name, checkbox.name) && Intrinsics.areEqual(this.value, checkbox.value) && this.isChecked == checkbox.isChecked && this.isDisabled == checkbox.isDisabled && Intrinsics.areEqual(this.classes, checkbox.classes);
    }

    @NotNull
    public final List<String> getClasses() {
        return this.classes;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.value;
        return this.classes.hashCode() + AbstractC0622a.m1160f(this.isDisabled, AbstractC0622a.m1160f(this.isChecked, (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31, 31), 31);
    }

    public final boolean isChecked() {
        return this.isChecked;
    }

    public final boolean isDisabled() {
        return this.isDisabled;
    }

    @NotNull
    public String toString() {
        String str = this.name;
        String str2 = this.value;
        boolean z = this.isChecked;
        boolean z2 = this.isDisabled;
        List<String> list = this.classes;
        StringBuilder sbM16m = AbstractC0000a.m16m("Checkbox(name=", str, ", value=", str2, ", isChecked=");
        AbstractC2821a.m2208C(sbM16m, z, ", isDisabled=", z2, ", classes=");
        return AbstractC0541b.m777s(sbM16m, list, ")");
    }

    public /* synthetic */ Checkbox(String str, String str2, boolean z, boolean z2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? false : z, (i & 8) != 0 ? false : z2, (i & 16) != 0 ? CollectionsKt.emptyList() : list);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Checkbox(@Nullable String str, @Nullable String str2, boolean z, boolean z2, @NotNull List<String> classes) {
        super(null);
        Intrinsics.checkNotNullParameter(classes, "classes");
        this.name = str;
        this.value = str2;
        this.isChecked = z;
        this.isDisabled = z2;
        this.classes = classes;
    }
}
