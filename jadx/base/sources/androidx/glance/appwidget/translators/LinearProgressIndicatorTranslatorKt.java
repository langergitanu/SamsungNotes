package androidx.glance.appwidget.translators;

import android.content.res.ColorStateList;
import android.os.Build;
import android.widget.RemoteViews;
import androidx.compose.p109ui.graphics.ColorKt;
import androidx.core.widget.RemoteViewsCompat;
import androidx.glance.appwidget.ApplyModifiersKt;
import androidx.glance.appwidget.EmittableLinearProgressIndicator;
import androidx.glance.appwidget.InsertedViewInfo;
import androidx.glance.appwidget.LayoutSelectionKt;
import androidx.glance.appwidget.LayoutType;
import androidx.glance.appwidget.TranslationContext;
import androidx.glance.color.DayNightColorProvider;
import androidx.glance.oneui.common.GlanceLog;
import androidx.glance.unit.ColorProvider;
import androidx.glance.unit.FixedColorProvider;
import androidx.glance.unit.ResourceColorProvider;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, m13886d2 = {SearchConstants.TargetContents.TAG, "", "translateEmittableLinearProgressIndicator", "", "Landroid/widget/RemoteViews;", "translationContext", "Landroidx/glance/appwidget/TranslationContext;", "element", "Landroidx/glance/appwidget/EmittableLinearProgressIndicator;", "glance-appwidget_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class LinearProgressIndicatorTranslatorKt {

    @NotNull
    private static final String TAG = "GWT:LinearTranslator";

    public static final void translateEmittableLinearProgressIndicator(@NotNull RemoteViews remoteViews, @NotNull TranslationContext translationContext, @NotNull EmittableLinearProgressIndicator element) {
        Intrinsics.checkNotNullParameter(remoteViews, "<this>");
        Intrinsics.checkNotNullParameter(translationContext, "translationContext");
        Intrinsics.checkNotNullParameter(element, "element");
        InsertedViewInfo insertedViewInfoInsertView = LayoutSelectionKt.insertView(remoteViews, translationContext, element.getIndeterminate() ? LayoutType.LinearProgressIndicator : LayoutType.LinearProgressIndicatorDeterminate, element.getModifier());
        remoteViews.setProgressBar(insertedViewInfoInsertView.getMainViewId(), 100, (int) (element.getProgress() * 100), element.getIndeterminate());
        if (Build.VERSION.SDK_INT >= 31) {
            ColorProvider color = element.getColor();
            if (color instanceof FixedColorProvider) {
                RemoteViewsCompat.setProgressBarProgressTintList(remoteViews, insertedViewInfoInsertView.getMainViewId(), ColorStateList.valueOf(ColorKt.m18579toArgb8_81llA(((FixedColorProvider) color).m22060getColor0d7_KjU())));
            } else if (color instanceof ResourceColorProvider) {
                RemoteViewsCompat.setProgressBarProgressTintList(remoteViews, insertedViewInfoInsertView.getMainViewId(), ((ResourceColorProvider) color).getResId());
            } else if (color instanceof DayNightColorProvider) {
                DayNightColorProvider dayNightColorProvider = (DayNightColorProvider) color;
                RemoteViewsCompat.setProgressBarProgressTintList(remoteViews, insertedViewInfoInsertView.getMainViewId(), ColorStateList.valueOf(ColorKt.m18579toArgb8_81llA(dayNightColorProvider.m21424getDay0d7_KjU())), ColorStateList.valueOf(ColorKt.m18579toArgb8_81llA(dayNightColorProvider.m21425getNight0d7_KjU())));
            } else {
                GlanceLog.INSTANCE.m2305w(TAG, "Unexpected progress indicator color: " + color);
            }
            ColorProvider backgroundColor = element.getBackgroundColor();
            if (backgroundColor instanceof FixedColorProvider) {
                RemoteViewsCompat.setProgressBarProgressBackgroundTintList(remoteViews, insertedViewInfoInsertView.getMainViewId(), ColorStateList.valueOf(ColorKt.m18579toArgb8_81llA(((FixedColorProvider) backgroundColor).m22060getColor0d7_KjU())));
            } else if (backgroundColor instanceof ResourceColorProvider) {
                RemoteViewsCompat.setProgressBarProgressBackgroundTintList(remoteViews, insertedViewInfoInsertView.getMainViewId(), ((ResourceColorProvider) backgroundColor).getResId());
            } else if (backgroundColor instanceof DayNightColorProvider) {
                DayNightColorProvider dayNightColorProvider2 = (DayNightColorProvider) backgroundColor;
                RemoteViewsCompat.setProgressBarProgressBackgroundTintList(remoteViews, insertedViewInfoInsertView.getMainViewId(), ColorStateList.valueOf(ColorKt.m18579toArgb8_81llA(dayNightColorProvider2.m21424getDay0d7_KjU())), ColorStateList.valueOf(ColorKt.m18579toArgb8_81llA(dayNightColorProvider2.m21425getNight0d7_KjU())));
            } else {
                GlanceLog.INSTANCE.m2305w(TAG, "Unexpected progress indicator background color: " + backgroundColor);
            }
        }
        ApplyModifiersKt.applyModifiers$default(translationContext, remoteViews, element.getModifier(), insertedViewInfoInsertView, null, 16, null);
    }
}
