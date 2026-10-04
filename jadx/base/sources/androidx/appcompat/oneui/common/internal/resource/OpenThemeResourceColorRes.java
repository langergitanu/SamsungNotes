package androidx.appcompat.oneui.common.internal.resource;

import android.content.Context;
import androidx.annotation.ColorRes;
import androidx.annotation.RestrictTo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0015\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0017¢\u0006\u0002\u0010\n¨\u0006\u000b"}, m13886d2 = {"Landroidx/appcompat/oneui/common/internal/resource/OpenThemeResourceColorRes;", "Landroidx/appcompat/oneui/common/internal/resource/OpenThemeResourceImpl;", "defaultThemeResource", "Landroidx/appcompat/oneui/common/internal/resource/ThemeResourceColorRes;", "openThemeResource", "(Landroidx/appcompat/oneui/common/internal/resource/ThemeResourceColorRes;Landroidx/appcompat/oneui/common/internal/resource/ThemeResourceColorRes;)V", "getResource", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)Ljava/lang/Integer;", "appcompat_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class OpenThemeResourceColorRes extends OpenThemeResourceImpl {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OpenThemeResourceColorRes(@NotNull ThemeResourceColorRes defaultThemeResource, @NotNull ThemeResourceColorRes openThemeResource) {
        super(defaultThemeResource, openThemeResource);
        Intrinsics.checkNotNullParameter(defaultThemeResource, "defaultThemeResource");
        Intrinsics.checkNotNullParameter(openThemeResource, "openThemeResource");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appcompat.oneui.common.internal.resource.OpenThemeResourceImpl, androidx.appcompat.oneui.common.internal.resource.ThemeResource
    @ColorRes
    @NotNull
    public Integer getResource(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return super.getResource(context);
    }
}
