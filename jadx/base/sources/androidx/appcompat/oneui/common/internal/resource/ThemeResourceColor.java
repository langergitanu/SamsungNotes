package androidx.appcompat.oneui.common.internal.resource;

import android.content.Context;
import androidx.annotation.ColorInt;
import androidx.annotation.RestrictTo;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\b\u0007\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0002¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0002HÆ\u0003J\t\u0010\n\u001a\u00020\u0002HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0003\u0010\u0003\u001a\u00020\u00022\b\b\u0003\u0010\u0004\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\u0015\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0017¢\u0006\u0002\u0010\u0013J\t\u0010\u0014\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0017"}, m13886d2 = {"Landroidx/appcompat/oneui/common/internal/resource/ThemeResourceColor;", "Landroidx/appcompat/oneui/common/internal/resource/ThemeResourceImpl;", "", "resourceLight", "resourceDark", "(II)V", "getResourceDark", "()I", "getResourceLight", "component1", "component2", "copy", "equals", "", "other", "", "getResource", "context", "Landroid/content/Context;", "(Landroid/content/Context;)Ljava/lang/Integer;", "hashCode", "toString", "", "appcompat_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final /* data */ class ThemeResourceColor extends ThemeResourceImpl<Integer> {
    private final int resourceDark;
    private final int resourceLight;

    @JvmOverloads
    public ThemeResourceColor(@ColorInt int i) {
        this(i, 0, 2, null);
    }

    public static /* synthetic */ ThemeResourceColor copy$default(ThemeResourceColor themeResourceColor, int i, int i2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = themeResourceColor.resourceLight;
        }
        if ((i4 & 2) != 0) {
            i2 = themeResourceColor.resourceDark;
        }
        return themeResourceColor.copy(i, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getResourceLight() {
        return this.resourceLight;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getResourceDark() {
        return this.resourceDark;
    }

    @NotNull
    public final ThemeResourceColor copy(@ColorInt int resourceLight, @ColorInt int resourceDark) {
        return new ThemeResourceColor(resourceLight, resourceDark);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ThemeResourceColor)) {
            return false;
        }
        ThemeResourceColor themeResourceColor = (ThemeResourceColor) other;
        return this.resourceLight == themeResourceColor.resourceLight && this.resourceDark == themeResourceColor.resourceDark;
    }

    public final int getResourceDark() {
        return this.resourceDark;
    }

    public final int getResourceLight() {
        return this.resourceLight;
    }

    public int hashCode() {
        return Integer.hashCode(this.resourceDark) + (Integer.hashCode(this.resourceLight) * 31);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder("ThemeResourceColor(resourceLight=");
        sb.append(this.resourceLight);
        sb.append(", resourceDark=");
        return AbstractC0000a.m13j(sb, this.resourceDark, PropertyUtils.MAPPED_DELIM2);
    }

    public /* synthetic */ ThemeResourceColor(int i, int i2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i4 & 2) != 0 ? i : i2);
    }

    @Override // androidx.appcompat.oneui.common.internal.resource.ThemeResourceImpl, androidx.appcompat.oneui.common.internal.resource.ThemeResource
    @ColorInt
    @NotNull
    public Integer getResource(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return (Integer) super.getResource(context);
    }

    @JvmOverloads
    public ThemeResourceColor(@ColorInt int i, @ColorInt int i2) {
        super(Integer.valueOf(i), Integer.valueOf(i2));
        this.resourceLight = i;
        this.resourceDark = i2;
    }
}
