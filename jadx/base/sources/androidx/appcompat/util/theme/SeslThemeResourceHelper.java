package androidx.appcompat.util.theme;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.annotation.ColorInt;
import androidx.annotation.RestrictTo;
import androidx.appcompat.util.theme.resource.SeslThemeResourceColor;
import androidx.appcompat.util.theme.resource.SeslThemeResourceDrawable;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, m13886d2 = {"Landroidx/appcompat/util/theme/SeslThemeResourceHelper;", "", "()V", "Companion", "appcompat_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class SeslThemeResourceHelper {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f¨\u0006\r"}, m13886d2 = {"Landroidx/appcompat/util/theme/SeslThemeResourceHelper$Companion;", "", "()V", "getColorInt", "", "context", "Landroid/content/Context;", "resourceColor", "Landroidx/appcompat/util/theme/resource/SeslThemeResourceColor$ResourceColor;", "getDrawable", "Landroid/graphics/drawable/Drawable;", "resource", "Landroidx/appcompat/util/theme/resource/SeslThemeResourceDrawable$ResourceDrawable;", "appcompat_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @ColorInt
        public final int getColorInt(@NotNull Context context, @NotNull SeslThemeResourceColor.ResourceColor resourceColor) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(resourceColor, "resourceColor");
            return ContextCompat.getColor(context, resourceColor.getColor(context));
        }

        @Nullable
        public final Drawable getDrawable(@NotNull Context context, @NotNull SeslThemeResourceDrawable.ResourceDrawable resource) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(resource, "resource");
            return ContextCompat.getDrawable(context, resource.getDrawable(context));
        }

        private Companion() {
        }
    }
}
