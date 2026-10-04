package androidx.appcompat.util.theme.resource;

import android.content.Context;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.RestrictTo;
import androidx.appcompat.util.SeslMisc;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b7\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002¨\u0006\u0006"}, m13886d2 = {"Landroidx/appcompat/util/theme/resource/SeslThemeResourceDrawable;", "", "()V", "OpenThemeResourceDrawable", "ResourceDrawable", "ThemeResourceDrawable", "appcompat_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class SeslThemeResourceDrawable {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\t\u0010\u0014\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0017"}, m13886d2 = {"Landroidx/appcompat/util/theme/resource/SeslThemeResourceDrawable$OpenThemeResourceDrawable;", "Landroidx/appcompat/util/theme/resource/SeslThemeResourceDrawable$ResourceDrawable;", "defaultThemeResource", "Landroidx/appcompat/util/theme/resource/SeslThemeResourceDrawable$ThemeResourceDrawable;", "openThemeResource", "(Landroidx/appcompat/util/theme/resource/SeslThemeResourceDrawable$ThemeResourceDrawable;Landroidx/appcompat/util/theme/resource/SeslThemeResourceDrawable$ThemeResourceDrawable;)V", "getDefaultThemeResource", "()Landroidx/appcompat/util/theme/resource/SeslThemeResourceDrawable$ThemeResourceDrawable;", "getOpenThemeResource", "component1", "component2", "copy", "equals", "", "other", "", "getDrawable", "", "context", "Landroid/content/Context;", "hashCode", "toString", "", "appcompat_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final /* data */ class OpenThemeResourceDrawable extends ResourceDrawable {

        @NotNull
        private final ThemeResourceDrawable defaultThemeResource;

        @NotNull
        private final ThemeResourceDrawable openThemeResource;

        public OpenThemeResourceDrawable(@NotNull ThemeResourceDrawable defaultThemeResource, @NotNull ThemeResourceDrawable openThemeResource) {
            Intrinsics.checkNotNullParameter(defaultThemeResource, "defaultThemeResource");
            Intrinsics.checkNotNullParameter(openThemeResource, "openThemeResource");
            this.defaultThemeResource = defaultThemeResource;
            this.openThemeResource = openThemeResource;
        }

        public static /* synthetic */ OpenThemeResourceDrawable copy$default(OpenThemeResourceDrawable openThemeResourceDrawable, ThemeResourceDrawable themeResourceDrawable, ThemeResourceDrawable themeResourceDrawable2, int i, Object obj) {
            if ((i & 1) != 0) {
                themeResourceDrawable = openThemeResourceDrawable.defaultThemeResource;
            }
            if ((i & 2) != 0) {
                themeResourceDrawable2 = openThemeResourceDrawable.openThemeResource;
            }
            return openThemeResourceDrawable.copy(themeResourceDrawable, themeResourceDrawable2);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ThemeResourceDrawable getDefaultThemeResource() {
            return this.defaultThemeResource;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final ThemeResourceDrawable getOpenThemeResource() {
            return this.openThemeResource;
        }

        @NotNull
        public final OpenThemeResourceDrawable copy(@NotNull ThemeResourceDrawable defaultThemeResource, @NotNull ThemeResourceDrawable openThemeResource) {
            Intrinsics.checkNotNullParameter(defaultThemeResource, "defaultThemeResource");
            Intrinsics.checkNotNullParameter(openThemeResource, "openThemeResource");
            return new OpenThemeResourceDrawable(defaultThemeResource, openThemeResource);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OpenThemeResourceDrawable)) {
                return false;
            }
            OpenThemeResourceDrawable openThemeResourceDrawable = (OpenThemeResourceDrawable) other;
            return Intrinsics.areEqual(this.defaultThemeResource, openThemeResourceDrawable.defaultThemeResource) && Intrinsics.areEqual(this.openThemeResource, openThemeResourceDrawable.openThemeResource);
        }

        @NotNull
        public final ThemeResourceDrawable getDefaultThemeResource() {
            return this.defaultThemeResource;
        }

        @Override // androidx.appcompat.util.theme.resource.SeslThemeResourceDrawable.ResourceDrawable
        public int getDrawable(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return SeslMisc.isDefaultTheme(context) ? this.defaultThemeResource.getDrawable(context) : this.openThemeResource.getDrawable(context);
        }

        @NotNull
        public final ThemeResourceDrawable getOpenThemeResource() {
            return this.openThemeResource;
        }

        public int hashCode() {
            return this.openThemeResource.hashCode() + (this.defaultThemeResource.hashCode() * 31);
        }

        @NotNull
        public String toString() {
            return "OpenThemeResourceDrawable(defaultThemeResource=" + this.defaultThemeResource + ", openThemeResource=" + this.openThemeResource + PropertyUtils.MAPPED_DELIM2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H'¨\u0006\u0007"}, m13886d2 = {"Landroidx/appcompat/util/theme/resource/SeslThemeResourceDrawable$ResourceDrawable;", "", "()V", "getDrawable", "", "context", "Landroid/content/Context;", "appcompat_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static abstract class ResourceDrawable {
        @DrawableRes
        public abstract int getDrawable(@NotNull Context context);
    }

    public /* synthetic */ SeslThemeResourceDrawable(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private SeslThemeResourceDrawable() {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0018"}, m13886d2 = {"Landroidx/appcompat/util/theme/resource/SeslThemeResourceDrawable$ThemeResourceDrawable;", "Landroidx/appcompat/util/theme/resource/SeslThemeResourceDrawable$ResourceDrawable;", "resId", "", "(I)V", "lightThemeResId", "darkThemeResId", "(II)V", "getDarkThemeResId", "()I", "getLightThemeResId", "component1", "component2", "copy", "equals", "", "other", "", "getDrawable", "context", "Landroid/content/Context;", "hashCode", "toString", "", "appcompat_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final /* data */ class ThemeResourceDrawable extends ResourceDrawable {
        private final int darkThemeResId;
        private final int lightThemeResId;

        public ThemeResourceDrawable(@DrawableRes int i, @DrawableRes int i2) {
            this.lightThemeResId = i;
            this.darkThemeResId = i2;
        }

        public static /* synthetic */ ThemeResourceDrawable copy$default(ThemeResourceDrawable themeResourceDrawable, int i, int i2, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i = themeResourceDrawable.lightThemeResId;
            }
            if ((i4 & 2) != 0) {
                i2 = themeResourceDrawable.darkThemeResId;
            }
            return themeResourceDrawable.copy(i, i2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getLightThemeResId() {
            return this.lightThemeResId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getDarkThemeResId() {
            return this.darkThemeResId;
        }

        @NotNull
        public final ThemeResourceDrawable copy(@DrawableRes int lightThemeResId, @DrawableRes int darkThemeResId) {
            return new ThemeResourceDrawable(lightThemeResId, darkThemeResId);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ThemeResourceDrawable)) {
                return false;
            }
            ThemeResourceDrawable themeResourceDrawable = (ThemeResourceDrawable) other;
            return this.lightThemeResId == themeResourceDrawable.lightThemeResId && this.darkThemeResId == themeResourceDrawable.darkThemeResId;
        }

        public final int getDarkThemeResId() {
            return this.darkThemeResId;
        }

        @Override // androidx.appcompat.util.theme.resource.SeslThemeResourceDrawable.ResourceDrawable
        public int getDrawable(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return SeslMisc.isLightTheme(context) ? this.lightThemeResId : this.darkThemeResId;
        }

        public final int getLightThemeResId() {
            return this.lightThemeResId;
        }

        public int hashCode() {
            return Integer.hashCode(this.darkThemeResId) + (Integer.hashCode(this.lightThemeResId) * 31);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder("ThemeResourceDrawable(lightThemeResId=");
            sb.append(this.lightThemeResId);
            sb.append(", darkThemeResId=");
            return AbstractC0000a.m13j(sb, this.darkThemeResId, PropertyUtils.MAPPED_DELIM2);
        }

        public ThemeResourceDrawable(@ColorRes int i) {
            this(i, i);
        }
    }
}
