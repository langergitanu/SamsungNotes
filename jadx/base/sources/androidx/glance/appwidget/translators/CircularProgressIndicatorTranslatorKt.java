package androidx.glance.appwidget.translators;

import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.annotation.IdRes;
import androidx.compose.p109ui.graphics.ColorKt;
import androidx.core.widget.RemoteViewsCompat;
import androidx.glance.appwidget.ApplyModifiersKt;
import androidx.glance.appwidget.ContentScale;
import androidx.glance.appwidget.EmittableCircularProgressIndicator;
import androidx.glance.appwidget.InsertedViewInfo;
import androidx.glance.appwidget.LayoutSelectionKt;
import androidx.glance.appwidget.LayoutType;
import androidx.glance.appwidget.TranslationContext;
import androidx.glance.appwidget.util.RemoteViewsReflections;
import androidx.glance.color.DayNightColorProvider;
import androidx.glance.oneui.common.GlanceLog;
import androidx.glance.unit.ColorProvider;
import androidx.glance.unit.FixedColorProvider;
import androidx.glance.unit.ResourceColorProvider;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a\u001c\u0010\t\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m13886d2 = {SearchConstants.TargetContents.TAG, "", "setProgressBarProgressDrawable", "", "Landroid/widget/RemoteViews;", "viewId", "", "drawable", "Landroid/os/Bundle;", "translateEmittableCircularProgressIndicator", "translationContext", "Landroidx/glance/appwidget/TranslationContext;", "element", "Landroidx/glance/appwidget/EmittableCircularProgressIndicator;", "glance-appwidget_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nCircularProgressIndicatorTranslator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CircularProgressIndicatorTranslator.kt\nandroidx/glance/appwidget/translators/CircularProgressIndicatorTranslatorKt\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,141:1\n1109#2,2:142\n*S KotlinDebug\n*F\n+ 1 CircularProgressIndicatorTranslator.kt\nandroidx/glance/appwidget/translators/CircularProgressIndicatorTranslatorKt\n*L\n131#1:142,2\n*E\n"})
public final class CircularProgressIndicatorTranslatorKt {

    @NotNull
    private static final String TAG = "GWT:CircularTranslator";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ContentScale.values().length];
            try {
                iArr[ContentScale.Large.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ContentScale.Medium.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final void setProgressBarProgressDrawable(RemoteViews remoteViews, @IdRes int i, Bundle bundle) throws IllegalAccessException, InvocationTargetException {
        try {
            Method[] declaredMethods = remoteViews.getClass().getDeclaredMethods();
            Intrinsics.checkNotNullExpressionValue(declaredMethods, "getDeclaredMethods(...)");
            for (Method method : declaredMethods) {
                method.setAccessible(true);
                if (Intrinsics.areEqual(method.getName(), RemoteViewsReflections.SET_PROGRESS_BAR_PROGRESS_DRAWABLE_METHOD)) {
                    method.invoke(remoteViews, Integer.valueOf(i), bundle);
                    return;
                }
            }
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        } catch (NoSuchElementException unused) {
            GlanceLog.INSTANCE.m2305w(TAG, "hidden_semSetProgressBarProgressDrawable isn't supported.");
        }
    }

    public static final void translateEmittableCircularProgressIndicator(@NotNull RemoteViews remoteViews, @NotNull TranslationContext translationContext, @NotNull EmittableCircularProgressIndicator element) {
        LayoutType layoutType;
        Intrinsics.checkNotNullParameter(remoteViews, "<this>");
        Intrinsics.checkNotNullParameter(translationContext, "translationContext");
        Intrinsics.checkNotNullParameter(element, "element");
        if (element.getIndeterminate()) {
            layoutType = LayoutType.CircularProgressIndicator;
        } else {
            int i = WhenMappings.$EnumSwitchMapping$0[element.getContentScale().ordinal()];
            layoutType = i != 1 ? i != 2 ? LayoutType.CircularProgressIndicatorSmall : LayoutType.CircularProgressIndicatorMedium : LayoutType.CircularProgressIndicatorLarge;
        }
        InsertedViewInfo insertedViewInfoInsertView = LayoutSelectionKt.insertView(remoteViews, translationContext, layoutType, element.getModifier());
        if (element.getProgressDrawable() != null) {
            int mainViewId = insertedViewInfoInsertView.getMainViewId();
            Bundle progressDrawable = element.getProgressDrawable();
            Intrinsics.checkNotNull(progressDrawable);
            setProgressBarProgressDrawable(remoteViews, mainViewId, progressDrawable);
        }
        if (element.getIndeterminate()) {
            remoteViews.setProgressBar(insertedViewInfoInsertView.getMainViewId(), 0, 0, true);
        } else {
            remoteViews.setProgressBar(insertedViewInfoInsertView.getMainViewId(), 100, (int) (element.getProgress() * 100), false);
        }
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
            if (!element.getIndeterminate()) {
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
        }
        ApplyModifiersKt.applyModifiers$default(translationContext, remoteViews, element.getModifier(), insertedViewInfoInsertView, null, 16, null);
    }
}
