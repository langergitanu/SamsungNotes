package androidx.appcompat.oneui.common.internal.resource;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.appcompat.util.SeslMisc;
import androidx.core.util.SeslDisplayUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B!\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0002\u0010\u0005J\u0015\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\fR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\r"}, m13886d2 = {"Landroidx/appcompat/oneui/common/internal/resource/OpenThemeResourceImpl;", "Landroidx/appcompat/oneui/common/internal/resource/ThemeResource;", "", "defaultThemeResource", "openThemeResource", "(Landroidx/appcompat/oneui/common/internal/resource/ThemeResource;Landroidx/appcompat/oneui/common/internal/resource/ThemeResource;)V", "getDefaultThemeResource", "()Landroidx/appcompat/oneui/common/internal/resource/ThemeResource;", "getOpenThemeResource", "getResource", "context", "Landroid/content/Context;", "(Landroid/content/Context;)Ljava/lang/Integer;", "appcompat_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class OpenThemeResourceImpl extends ThemeResource<Integer> {

    @NotNull
    private final ThemeResource<Integer> defaultThemeResource;

    @NotNull
    private final ThemeResource<Integer> openThemeResource;

    public OpenThemeResourceImpl(@NotNull ThemeResource<Integer> defaultThemeResource, @NotNull ThemeResource<Integer> openThemeResource) {
        Intrinsics.checkNotNullParameter(defaultThemeResource, "defaultThemeResource");
        Intrinsics.checkNotNullParameter(openThemeResource, "openThemeResource");
        this.defaultThemeResource = defaultThemeResource;
        this.openThemeResource = openThemeResource;
    }

    @NotNull
    public final ThemeResource<Integer> getDefaultThemeResource() {
        return this.defaultThemeResource;
    }

    @NotNull
    public final ThemeResource<Integer> getOpenThemeResource() {
        return this.openThemeResource;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appcompat.oneui.common.internal.resource.ThemeResource
    @NotNull
    public Integer getResource(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return Integer.valueOf((SeslDisplayUtils.isDexEnabled(context) || SeslMisc.isDefaultTheme(context)) ? this.defaultThemeResource.getResource(context).intValue() : this.openThemeResource.getResource(context).intValue());
    }
}
