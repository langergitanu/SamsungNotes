package androidx.glance.appwidget.translators;

import android.widget.RemoteViews;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.compose.p109ui.graphics.ColorKt;
import androidx.core.widget.RemoteViewsCompat;
import androidx.glance.appwidget.TranslationContext;
import androidx.glance.color.DayNightColorProvider;
import androidx.glance.unit.ColorProvider;
import androidx.glance.unit.ResourceColorProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(31)
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007¨\u0006\r"}, m13886d2 = {"Landroidx/glance/appwidget/translators/ImageTranslatorApi31Impl;", "", "()V", "applyTintColorFilter", "", "translationContext", "Landroidx/glance/appwidget/TranslationContext;", "rv", "Landroid/widget/RemoteViews;", "colorProvider", "Landroidx/glance/unit/ColorProvider;", "viewId", "", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
final class ImageTranslatorApi31Impl {

    @NotNull
    public static final ImageTranslatorApi31Impl INSTANCE = new ImageTranslatorApi31Impl();

    private ImageTranslatorApi31Impl() {
    }

    @DoNotInline
    public final void applyTintColorFilter(@NotNull TranslationContext translationContext, @NotNull RemoteViews rv, @NotNull ColorProvider colorProvider, int viewId) {
        Intrinsics.checkNotNullParameter(translationContext, "translationContext");
        Intrinsics.checkNotNullParameter(rv, "rv");
        Intrinsics.checkNotNullParameter(colorProvider, "colorProvider");
        if (colorProvider instanceof DayNightColorProvider) {
            DayNightColorProvider dayNightColorProvider = (DayNightColorProvider) colorProvider;
            ImageTranslatorKt.m21399setImageViewColorFilter0YGnOg8(rv, viewId, dayNightColorProvider.m21424getDay0d7_KjU(), dayNightColorProvider.m21425getNight0d7_KjU());
        } else if (colorProvider instanceof ResourceColorProvider) {
            RemoteViewsCompat.setImageViewColorFilterResource(rv, viewId, ((ResourceColorProvider) colorProvider).getResId());
        } else {
            RemoteViewsCompat.setImageViewColorFilter(rv, viewId, ColorKt.m18579toArgb8_81llA(colorProvider.mo21422getColorvNxB06k(translationContext.getContext())));
        }
    }
}
